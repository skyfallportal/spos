import java.io.*;
import java.util.*;

public class optimal {
    static boolean search(int key, int[] fr) {
        for(int i=0; i<fr.length; i++) {
            if(fr[i] == key) 
                return true;
        }
        return false;
    }

    static int predict(int pg[], int[] fr, int pn, int index) {
        int res=-1, farthest = index;
        for(int i=0; i<fr.length; i++) {
            int j;
            for(j=index; j<fr.length; j++) {
                if(fr[i] == pg[j]) {
                    if(j>farthest) {
                        farthest = j;
                        res = i;
                    }
                    break;
                }
            }
            if(j == pn)
                return i;
        }
        return (res == -1) ? 0:res;
    }

    static void optimalPage(int pg[], int pn, int fn) {
        int[] fr = new int[fn];
        int hit = 0, index = 0;
        for(int i=0; i<pn; i++) {
            if(search(pg[i], fr)) {
                hit++;
                continue;
            }
            if(index < fn) {
                fr[index++] = pg[i];
            }
            else {
                int j= predict(pg, fr, pn, i+1);
                fr[j] = pg[i];
            }
        }
        System.out.println("No. of hits = " + hit);
        System.out.println("No. of misses = " + (pn - hit));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total number of Frames: ");
        int fn = sc.nextInt();
        System.out.println("Enter the reference string size: ");
        int pn = sc.nextInt();
        int pg[] = new int[10];
        System.out.println("Enter the elements in array: ");
        for(int i=0; i<pn; i++) {
            pg[i] = sc.nextInt();
        }
        optimalPage(pg, pn, fn);
    }
}
