import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RotatableGrid {

    private char[][] matrix;
    private List<char[][]> listMatrix = new ArrayList<>();
    private static int count = 0;

    private void encrypt(String plaintext) {
        char[] text;
        if (plaintext.length() % 16 == 0) {
            text = new char[plaintext.length()];
        } else {
            text = new char[plaintext.length() + (16 - plaintext.length() % 16)];
        }

        int count_part = text.length / 16;

        for (int j = 0; j < text.length; j++) {
            if (plaintext.length() - 1 < j) {
                text[j] = ' ';
            } else {
                text[j] = plaintext.charAt(j);
            }
        }

        for (int i = 0; i < count_part; i++){
            matrix = new char[4][4];
            for (int j = i*16; j < text.length; j += 4) {
                matrix[0][0] = text[j];
                matrix[1][3] = text[j + 1];
                matrix[3][1] = text[j + 2];
                matrix[2][2] = text[j + 3];
                matrix = rotate(matrix);
                if (count == 4) {
                    addInListMatrix(matrix);
                    break;
                }
            }
        }
        print();
    }

    private void addInListMatrix(char[][] matrix) {
        listMatrix.add(matrix);
        count = 0;
    }

    private void decrypt(String cipherText) {
        listMatrix.clear();
        count = 0;
        char[] text = cipherText.toCharArray();
        int count_part = text.length / 16;
        StringBuilder decryptText = new StringBuilder();

        for (int part = 0; part < count_part; part++) {
            matrix = new char[4][4];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (text.length > j + i * 4) {
                        matrix[i][j] = text[j + part*16 + i * 4];
                    } else {
                        matrix[i][j] = '_';
                    }
                }
            }
            addInListMatrix(matrix);
        }

        for (char[][] matrix : listMatrix) {
            while(count != 4){
                decryptText.append(matrix[0][0]);
                decryptText.append(matrix[1][3]);
                decryptText.append(matrix[3][1]);
                decryptText.append(matrix[2][2]);
                matrix = rotate(matrix);
            }
            count = 0;
        }


        System.out.println(decryptText.toString().replaceAll("_", " "));
    }

    private char[][] rotate(char[][] matrix) {
        count++;
        char[][] newArray = new char[4][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                newArray[i][j] = matrix[Math.abs(j - 3)][i];
            }
        }
        return newArray;
    }

    private void print() {
        StringBuilder encryptWord = new StringBuilder();

        for (char[][] matrixInList : listMatrix) {
            for (char[] matrixX : matrixInList) {
                for (char matrixY : matrixX) {
                    if (matrixY == ' ')
                        matrixY = '_';
                    encryptWord.append(matrixY);
                }
            }
        }

        System.out.println(encryptWord);
    }

    private void start() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the plaintext for encryption");
        String plaintext = in.nextLine();

        encrypt(plaintext);
        System.out.println("------------------Decryption process start----------");

        System.out.println("Enter the ciphertext for decryption:");
        String cipherText = in.nextLine();
        decrypt(cipherText);
    }

    public static void main(String[] args) {
        RotatableGrid crypt = new RotatableGrid();
        crypt.start();
    }
}
