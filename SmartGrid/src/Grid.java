public class Grid {
    private int[] minutes;
    private Task[] tasks;
    public Grid(int[] minutes, Task[] tasks) {
        this.minutes = minutes;
        this.tasks = tasks;
    }
    public Task[] cheapestTasks() {
        Task[] out = new Task[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            int start = -1;
            int minSum = 999999999;
            int length = tasks[i].val();
            for (int j = 0; j < minutes.length - length + 1; j++) {
                int sum = 0;
                for (int k = j; k < j + length; k++) {
                    sum+=minutes[k];
                }
                if(sum < minSum) {
                    minSum = sum;
                    start = j;
                }
            }
            out[i] = new Task(tasks[i].id(), start, 0, 0);
        }
        return out;
    }
    public int cheapestMinute() {
        int iMin = 0;
        for (int i = 0; i < minutes.length ; i++) {
            if(minutes[i] < minutes[iMin]) {
                iMin = i;
            }
        }
        return iMin;
    }
    public Task[] cheapestIntervals() {
        Task[] outTasks = new Task[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            int start = -1;
            int minSum = 999999999;

            for (int j = tasks[i].startInterval(); j <= tasks[i].endInterval(); j++) {
                int sum = 0;
                for (int k = j; k < j + tasks[i].val(); k++) {
                    sum+=minutes[k];
                }
                if(sum < minSum) {
                    minSum = sum;
                    start = j;
                }
            }
            outTasks[i] = new Task(tasks[i].id(), start, 0, 0);
            
        }
        return outTasks;
    }
}
