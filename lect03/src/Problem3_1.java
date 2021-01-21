// Student ID: 6330300879
// First Name: supanut
// Last Name: klakerdpol
//
// Team Members:
// 1. 6330300879 Supanut Klakerdpol
// 2. 6330300208 Yadaporn Ajmontri
// 3. 6330300461 Terapat Malaob

public class Problem3_1 {
    public static void main(String[] args) {
        // TODO
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input: ");
        int line = scanner.nextInt();
        int answer = 0;

        for (int i=0;i<line;i++){
            int varA = scanner.nextInt();

            if ((varA % 4) == 0){

                if (varA > answer){
                    answer = varA;
                }
            } // end if /4
        } /// end for
        System.out.println("Output :\n"+ answer);
    }
}
