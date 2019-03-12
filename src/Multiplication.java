import java.util.Scanner;

public class Multiplication {

    private int key;
    private String alphabet = "abcdefghijklmnopqrstuwxyz";

    private void start() {
        System.out.println("Enter the key (3-9,5-21, 9-3):");
        Scanner in = new Scanner(System.in);
        int pass = in.nextInt();

        System.out.println("Enter the text for encryption");
        Scanner inn = new Scanner(System.in);
        String ttext = inn.nextLine();

        encryption(ttext, pass);
        System.out.println("------------------Decryption process start----------");

        while(key == 0) {
            System.out.println("Enter the key:");
            pass = in.nextInt();
            for (int i = 1; i <= 26; i++) {
                if (!((i == 1) || (i % 2 == 0) || (i == 13) || (i == pass)) && (i * pass) % 26 == 1)
                    key = i;
            }
        }

        System.out.println(key);
        System.out.println("Enter the cipherText for decryption:");
        String cipherText = inn.nextLine();
        decryption(cipherText);
    }

    private void decryption(String cipherText) {

        char[] textEncrypt = cipherText.toCharArray();
        StringBuilder decryptWord = new StringBuilder();

        for (char ch : textEncrypt){
            if(ch == '*')
                decryptWord.append(' ');
            else
                decryptWord.append(alphabet.toCharArray()[(((alphabet.indexOf(ch))*key))%26]);
        }
        System.out.println(decryptWord);
    }

    private void encryption(String plaintext, int pass) {
        char[] textEncrypt = plaintext.toCharArray();
        StringBuilder encryptWord = new StringBuilder();

        for (char ch : textEncrypt){
            if(ch == ' ')
                encryptWord.append('*');
            else
                encryptWord.append(alphabet.toCharArray()[((alphabet.indexOf(ch))*pass)%26]);
        }
        System.out.println(encryptWord);
    }

    public static void main(String[] args) {
        Multiplication crypt = new Multiplication();
        crypt.start();
    }
}
