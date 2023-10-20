import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Tournament {
    private List<Character> fighters = new ArrayList<>();
    public Tournament(String tString) {
        tString.chars().forEach(fighter -> fighters.add((char)fighter));
    }
    public void evaluateRound() {
        ArrayList<Character> temp = new ArrayList<>();
        for (int i = 0; i < fighters.size() - 1; i++) {
            if (i % 2 != 0)  continue;
            temp.add(getResult(fighters.get(i), fighters.get(i + 1)));
        }
        this.fighters = temp;
    }
    public void evaluateUntilLastRound() {
        while(fighters.size() > 2) {
            this.evaluateRound();
        }
    }
    /**
     * After the second round there should be no Rocks left and Scissors should Win
     * @return finished tournament
     */
    public static Tournament generateScissorsWin(int r, int p , int s) {
        StringBuilder tournament = new StringBuilder();
        while(r >= 2 && p >= 2) {
            tournament.append("RR");
            tournament.append("PP");
            r-=2;
            p-=2;
        }
        if(r == 1 && p == 0 && s > 1) {
            tournament.insert(0,"RS");
            r--;
            s--;
        }
        else if(r == 1 && p > 0){
            tournament.insert(0,"RP");
            r--;
            s--;
        }

        while(p >= 2)  {
            tournament.append("PP");
            p-=2;
        }
        while(s >= 2)  {
            tournament.append("SS");
            s-=2;
        }
        if(p > 0) {
            tournament.append("P");
            p--;
        }
        if(s > 0) {
            tournament.append("S");
            s--;
        }
        //System.out.println("debug");
        assert r == 0;
        assert p == 0;
        assert s ==0;
        return new Tournament(tournament.toString());
    }
    public static char getResult(char a, char b) {

        if(a == 'R') {
            if(b == 'R') return a;

            if(b == 'P') return b;
            if(b == 'S') return a;
        }
        else if(a == 'P') {
            if(b == 'P') return a;

            if(b == 'R') return a;
            if(b == 'S') return b;
        }
        else if(a == 'S') {
            if(b == 'S') return a;

            if(b == 'R') return b;
            if(b == 'P') return a;
        }
        return 'X';
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        this.fighters.forEach(s::append);
        return s.toString();
    }

    public List<Character> getFighters() {
        return fighters;
    }
}
