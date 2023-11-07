import java.util.*;

public class Fcfs {
    public static void main(String[] args) {
        int id[] = new int[20];
        int etime[] = new int[20];//Execution Time
        int stime[] = new int[20];//Start Time
        int wtime[] = new int[20]; //Waiting Time
        int tat[] = new int[20]; //Turn Around Time

        int total = 0, total1 = 0;
        float avg, avg1;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Processes: ");
        int n = sc.nextInt();
        for(int i=0; i<n; i++) {
            System.out.println();

            System.out.println("Enter the process ID for process " + (i+1) + ": ");
            id[i] = sc.nextInt();
            System.out.println("Enter the execution time for process " + (i+1) + ": ");
            etime[i] = sc.nextInt();
        }

        stime[0] = 0;
        for(int i=1; i<n; i++) {
            stime[i] = stime[i-1] + etime[i-1];
        }
        wtime[0] = 0;
        for(int i=1; i<n; i++) {
            wtime[i] = stime[i-1] + id[i];
            total = total+wtime[i];
        }
        for(int i=1; i<n; i++) {
            tat[i] = wtime[i] + etime[i];
            total1 = total1+tat[i];
        }
        avg = (float)total/n;
        avg1 = (float)total1/n;

        System.out.println("Arrial Time\tExecution Time\tStart Time\tWaiting Time\tTurnAround Time");
        for(int i=0; i<n; i++) {
            System.out.println(id[i] + "\t\t" + etime[i] + "\t\t" + stime[i] + "\t\t" + wtime[i] + "\t\t" + tat[i]);
        }
        System.out.println("Average Turn Around Time: "+avg1 + "\n Average Waiting Time: "+avg);
        
        sc.close();
    }
}
