import java.util.Scanner;

public class CaesarAlgorithm {

    private String alphabet = "abcdefghijklmnopqrstuwxyz";

    private void start() {
        System.out.println("Enter the key 'k':");
        Scanner in = new Scanner(System.in);
        int key = in.nextInt();

        System.out.println("Enter the text for encryption");

        Scanner iin = new Scanner(System.in);
        String text = iin.nextLine();

        encryption(text, key);
        System.out.println("------------------Decryption process start----------");

        System.out.println("Enter the key 'k':");
        Scanner innn = new Scanner(System.in);
        key = innn.nextInt();
        System.out.println("Enter the cipherText for decryption:");
        String cipherText = iin.nextLine();
        decryption(cipherText, key);
    }

    private void encryption(String text, int key) {
        char[] textEncrypt = text.toCharArray();
        StringBuilder encryptWord = new StringBuilder();

        for (char ch : textEncrypt){
            if(ch == ' ')
                encryptWord.append('*');
            else
                encryptWord.append(alphabet.toCharArray()[(alphabet.indexOf(ch)+key)%26]);
        }
        System.out.println(encryptWord);
    }

    private void decryption(String text, int key) {
        char[] textEncrypt = text.toCharArray();
        StringBuilder decryptWord = new StringBuilder();

        for (char ch : textEncrypt){
            if(ch == '*')
                decryptWord.append(' ');
            else
                decryptWord.append(alphabet.toCharArray()[(alphabet.indexOf(ch) + 26 - key)%26]);

        }
        System.out.println(decryptWord);
    }

    public static void main(String[] args) {
        CaesarAlgorithm crypt = new CaesarAlgorithm();
        crypt.start();
    }
}
