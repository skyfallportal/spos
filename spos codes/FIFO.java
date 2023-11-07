import java.io.*;

class FIFO {
    public static void main(String args[]) throws Exception {
        int n, f;
        float rat;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the Number of FRAMES: ");
        f = Integer.parseInt(br.readLine());
        int fifo[] = new int[f];
        System.out.println("Enter the number of INPUTS: ");
        n = Integer.parseInt(br.readLine());
        int inp[] = new int[n];
        System.out.println("Enter INPUT: ");
        for (int i = 0; i < n; i++)
            inp[i] = Integer.parseInt(br.readLine());
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < f; i++)
            fifo[i] = -1;

        int hit = 0, fault = 0, j = 0;
        boolean check;
        for (int i = 0; i < n; i++) {
            check = false;
            for (int k = 0; k < f; k++)
                if (fifo[k] == inp[i]) {
                    check = true;
                    hit = hit + 1;
                }
            if (check == false) {
                fifo[j] = inp[i];
                j++;
                if (j >= f)
                    fault = fault + 1;
            }
        }
        rat = (float) hit / (float) n;
        System.out.println("HIT: " + hit + "FAULT: " + fault + "HIT RATIO: " + rat);
    }
}
