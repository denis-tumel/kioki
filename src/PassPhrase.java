import java.util.*;

public class PassPhrase {

    private String alphabet = "abcdefghijklmnopqrstuwxyz";

    public void start() {
        System.out.println("Enter the words of pass:");
        Scanner in = new Scanner(System.in);
        String pass = in.nextLine();

        System.out.println("Enter the plaintext for encryption");
        String plaintext = in.nextLine();

        encryption(plaintext, pass);
        System.out.println("------------------Decryption process start----------");

        System.out.println("Enter the words of pass:");
        pass = in.nextLine();
        System.out.println("Enter the ciphertext for decryption:");
        String ciphertext = in.nextLine();
        decryption(ciphertext, pass);
    }

    private void decryption(String ciphertext, String pass) {
        code_information(ciphertext, pass);
    }

    private void encryption(String plaintext, String pass) {
        code_information(plaintext, pass);
    }

    private void code_information(String cipher_text, String pass) {
        StringBuilder encrypt_word = new StringBuilder();
        List<Integer> key = getKey(pass);

        double count_part = Math.ceil(((double) cipher_text.length()+(key.size()-cipher_text.length()%key.size()))/key.size());

        for (int i = 0; i < key.size()-cipher_text.length()%key.size(); i++){
            cipher_text += " ";
        }

        if(count_part == 0)
            count_part = 1;

        int num = 0;
        for(int j = 0; j < count_part; j++) {
            for (int i : key) {
                for (int c_text = 0; c_text < cipher_text.toCharArray().length; c_text++) {
                    if (i == c_text - num)
                        encrypt_word.append(cipher_text.toCharArray()[c_text]);
                }
            }
            num += key.size();
        }
        System.out.println(encrypt_word.toString());
    }

    private List<Integer> getKey(String pass) {
        List<Integer> key = new ArrayList<>();

        for (char c_alpha : alphabet.toCharArray()) {
            for (char c_pass : pass.toCharArray()) {
                if (c_pass == c_alpha)
                    key.add(pass.indexOf(c_alpha));
            }
        }
        return key;
    }

    public static void main(String[] args) {
        PassPhrase crypt = new PassPhrase();
        crypt.start();
    }
}
