import java.util.*;

public class RailFence {

    private void encryption(String str, int rails){
        int j = 0;
        int row = rails;
        int col=str.length();
        char[][] a = new char[row][col];
        boolean checkDown = false;

        for(int i = 0; i < col; i++){
            if(j == 0 || j == row - 1)
                checkDown =! checkDown;
            a[j][i] = str.charAt(i);
            if(checkDown){
                j++;
            }
            else
                j--;
        }
        System.out.println("success:");
        String en ="";
        for(int i=0;i<row;i++){
            for(int k=0;k<col;k++){
                if(a[i][k]!=0)
                    en=en+a[i][k];

            }
        }
        System.out.println(en);
    }

    private void decryption(String str, int rails){
        int j = 0;
        int row = rails;
        int col=str.length();
        char[][] a = new char[row][col];
        boolean checkdown = false;

        for(int i = 0; i<col; i++){
            if(j==0||j==row-1)
                checkdown =! checkdown;
            a[j][i]='*';
            if(checkdown)
                j++;
            else j--;
        }

        int index=0;

        for(int i=0;i<row;i++) {
            for (int k = 0; k < col; k++) {
                if (a[i][k] == '*' && index < str.length()) {
                    a[i][k] = str.charAt(index++);
                }
            }
        }
        System.out.println("success:");
        checkdown=false;
        String s="";
        j=0;

        for(int i=0;i<col;i++){
            if( j==0||j==row-1)
                checkdown=!checkdown;
            s+=a[j][i];
            if(checkdown)j++;
            else j--;
        }
        System.out.print(s);
    }

    private void start() {
        System.out.println("Enter the number of rails:");
        Scanner in=new Scanner (System.in);
        int rails=in.nextInt();

        System.out.println("Enter the plaintext for encryption");
        Scanner inn = new Scanner (System.in);
        String plaintext = inn.nextLine();

        encryption(plaintext,rails);
        System.out.println("------------------Decryption process start----------");

        System.out.println("Enter the number of rails:");
        rails=in.nextInt();
        System.out.println("Enter the ciphertext for decryption:");
        String ciphertext = inn.nextLine();
        decryption(ciphertext,rails);
    }

    public static void main(String[] args) {
        RailFence crypt = new RailFence();
        crypt.start();
    }
}