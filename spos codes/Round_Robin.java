import java.util.Scanner;

public class Round_Robin {
    public static void main(String args[]) {
        int n, i, qt, count=0, temp, sq=0, bt[], wt[], tat[], rem_bt[];
        float awt=0, atat=0;
        
        bt = new int[10];
        wt = new int[10];
        tat = new int[10];
        rem_bt = new int[10];

        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of process: ");
        n = s.nextInt();
        System.out.println("Enter the burst time: ");
        for(i=0; i<n; i++) {
            System.out.println("P"+i+"=");
            bt[i] = s.nextInt();
            rem_bt[i] = bt[i];
        }
        System.out.println("Enter the quantum time: ");
        qt = s.nextInt();
        while(true) {
            for(i=0, count=0; i<n; i++) {
                temp = qt;
                if(rem_bt[i]==0) {
                    count++;
                    continue;
                }
                if(rem_bt[i]>qt) {
                    rem_bt[i] = rem_bt[i]-qt;
                }
                else if(rem_bt[i]>=0) {
                    temp = rem_bt[i];
                    rem_bt[i] = 0;
                }
                sq = sq+temp;
                tat[i] = sq;
            }
            if(n==count) {
                break;
            }

            System.out.println("-----------------------------------------");
            System.out.println("Process \t Burst Time \t TrunAround Time \t Waiting Time \n");
            System.out.println("-----------------------------------------");
            for(i=0; i<n; i++) {
                wt[i] = tat[i]-bt[i];
                awt = awt + wt[i];
                atat = atat + tat[i];
                System.out.println("\n"+(i+1)+"\t"+bt[i]+"\t"+tat[i]+"\t"+wt[i]+"\n");
            }
            awt = awt/n;
            atat = atat/n;
        }
        s.close();
    }
}
