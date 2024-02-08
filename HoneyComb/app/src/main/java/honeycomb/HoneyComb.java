package honeycomb;

import java.util.*;

public class HoneyComb {
    public ArrayList<String> field = new ArrayList<>();
    public Position getWaspPosition() {
        for (String string : field) {
            if (string.indexOf("W") != -1) {
                return new Position(field.indexOf(string), string.indexOf('W'));
            }
        }
        return new Position(-1, -1);
    }
    public int countEmptyCell(Position pos) {
        int count = 0;
        
        int x = pos.x();
        int y = pos.y();

        if(x == -1 && y == -1) return -1;
        count += countChar(this.field.get(x - 1).substring(y - 1, y + 2), 'O');
        count += countChar(this.field.get(x).substring(y - 2, y + 3), 'O');
        count += countChar(this.field.get(x + 1).substring(y - 1, y + 2), 'O');
        return count;
    }
    public boolean canMove(Position pos, Direction direction) {
        int x = pos.x();
        int y = pos.y();

        switch(direction) {
            case LEFT:
                if(field.get(x).charAt(y - 2) == 'O') return true;
                break;
            case RIGHT:
                if(field.get(x).charAt(y + 2) == 'O') return true;
                break;
            case TOP_LEFT:
                if(field.get(x - 1).charAt(y - 1) == 'O') return true;
                break;
            case TOP_RIGHT:
                if(field.get(x - 1).charAt(y + 1) == 'O') return true;
                break;
            case BOTTOM_LEFT:
                if(field.get(x + 1).charAt(y - 1) == 'O') return true;
                break;
            case BOTTOM_RIGHT:
                if(field.get(x + 1).charAt(y + 1) == 'O') return true;
                break;
        }
        return false;
    }
    public boolean canWaspEscapeSmart(Position start) {
        Stack<Position> stack = new Stack<>();
        Set<Position> visited = new HashSet<>();

        stack.push(start);
        while(!stack.empty()) {
            Position current = stack.pop();

            if(current.x() < 0
            || current.y() < 0
            || current.x() > this.field.size() - 1
            || current.y() > this.field.get(current.x()).length() - 1
            || this.field.get(current.x()).charAt(current.y()) == 'X'
            || visited.contains(current)
            ) continue;

            visited.add(current);

            if(isOnEdge(current)) return true;

            stack.push(new Position(current.x() , current.y() - 2));
            stack.push(new Position(current.x() , current.y() + 2));
            stack.push(new Position(current.x() + 1 , current.y() + 1));
            stack.push(new Position(current.x() - 1 , current.y() - 1));
            stack.push(new Position(current.x() + 1 , current.y() - 1));
            stack.push(new Position(current.x() - 1 , current.y() + 1));
        }
        return false;
    }

    public boolean canWaspEscapeLinear() {
        Position waPosition = this.getWaspPosition();
        if(countEmptyCell(waPosition) == 0) return false;
        if(canMove(waPosition, Direction.LEFT)) {
            int x = waPosition.x();
            int y = waPosition.y();
            while(true) {
                if(isOnEdge(new Position(x, y), Direction.LEFT)) return true;
                else if(!canMove(new Position(x, y), Direction.LEFT)) break;
                y-=2;
            }
        }
        if(canMove(waPosition, Direction.RIGHT)) {
            int x = waPosition.x();
            int y = waPosition.y();
            while(true) {
                if(isOnEdge(new Position(x, y), Direction.RIGHT)) return true;
                else if(!canMove(new Position(x, y), Direction.RIGHT)) break;
                y+=2;
            }
        }
        if(canMove(waPosition, Direction.BOTTOM_LEFT)) {
            int x = waPosition.x();
            int y = waPosition.y();
            while(true) {
                if(isOnEdge(new Position(x, y), Direction.BOTTOM_LEFT)) return true;
                else if(!canMove(new Position(x, y), Direction.BOTTOM_LEFT)) break;
                x++;
                y--;
                
            }
        }
        if(canMove(waPosition, Direction.BOTTOM_RIGHT)) {
            int x = waPosition.x();
            int y = waPosition.y();
            while(true) {
                if(isOnEdge(new Position(x, y), Direction.BOTTOM_RIGHT)) return true;
                else if(!canMove(new Position(x, y), Direction.BOTTOM_RIGHT)) break;
                x++;
                y++;
            }
        }
        if(canMove(waPosition, Direction.TOP_LEFT)) {
            int x = waPosition.x();
            int y = waPosition.y();
            while(true) {
                if(isOnEdge(new Position(x, y), Direction.TOP_LEFT)) return true;
                else if(!canMove(new Position(x, y), Direction.TOP_LEFT)) break;
                x--;
                y--;
            }
        }
        if(canMove(waPosition, Direction.TOP_RIGHT)) {
            int x = waPosition.x();
            int y = waPosition.y();
            while(true) {
                if(isOnEdge(new Position(x, y), Direction.TOP_RIGHT)) return true;
                else if(!canMove(new Position(x, y), Direction.TOP_RIGHT)) break;
                x--;
                y++;
            }
        }



        return false;
    }
    public boolean isOnEdge(Position p) {
        if(p.x() == 0 || field.size() - 1 == p.x()) return true;
        if(p.y() == 0 || field.get(0).length() - 1 == p.y()) return true;
        return false;
    }
    public boolean isOnEdge(Position p, Direction dir) {
        if(p.x() == 0 || field.size() - 1 == p.x()) return true;
        if(dir == Direction.RIGHT || dir == Direction.LEFT) {
            if(p.y() == 0 ||p.y() == 1 || p.y() == field.get(0).length() - 2 || p.y() == field.get(0).length() - 1) return true;
        }
        else if (p.y() == 0 || field.get(0).length() - 1 == p.y()) return true;
        return false;
    }
    public int distanceToEdge(Position pos) {
        return -1;
    }
    private int countChar(String str, char c) {
        int count = 0;

        for(int i=0; i < str.length(); i++)
        {    if(str.charAt(i) == c)
                count++;
        }
    
        return count;
    }
}
