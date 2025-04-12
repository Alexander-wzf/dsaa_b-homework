import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        List<String> results = new ArrayList<>();

        int[] id = new int[num];
        for (int i = 0; i < num; i++) {
            id[i] = i;
        }

        while (sc.hasNextLine()){
            String line = sc.nextLine();
            if (line.trim().isEmpty()) {
                break;
            }
            String[] elements = line.split(" ");

            String operation = elements[0];
            int a = Integer.parseInt(elements[1]);
            a = a - 1;
            int b = Integer.parseInt(elements[2]);
            b = b - 1;

            if (operation.equals("C")){
                connect(id,a,b);
            }else {
                if (query(id,a,b)){
                    results.add("Yes");
                }else {
                    results.add("No");
                }
            }
        }
        for (String result : results) {
            System.out.println(result);
        }
    }


    public static void connect(int[] id,int i,int j){
        int iid = id[i];
        int jid = id[j];
        for (int k = 0; k < id.length; k++) {
            if (id[k] == iid){
                id[k] = jid;
            }
        }
    }

    public static boolean query(int[] id,int i,int j){
        return id[i] == id[j];
    }
}
