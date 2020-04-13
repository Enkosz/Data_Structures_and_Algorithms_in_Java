package com.base.chapter3.arrays;

public class CaesarCipher {
    protected char[] encoder = new char[26];
    protected char[] decoder = new char[26];

    public CaesarCipher(int rotation) {
        for (int k = 0; k < 26; k++) {
            encoder[k] = (char) ('A' + (k + rotation) % 26);
            decoder[k] = (char) ('A' + (k - rotation + 26) % 26);
        }
    }

    public String encrypt(String message) {
        return transform(message, encoder);
    }

    public String decrypt(String message) {
        return transform(message, decoder);
    }

    private String transform(String original, char[] code) {
        char[] msg = original.toCharArray();

        for (int i = 0; i < msg.length; i++) {
            if (Character.isUpperCase(msg[i])) {
                int j = msg[i] - 'A';
                msg[i] = code[j];
            }
        }

        return new String(msg);
    }

    public static void main(String[] args) {
        CaesarCipher caesarCipher = new CaesarCipher(3);

        System.out.println("Encryption code " + new String(caesarCipher.encoder));
        System.out.println("Decryption code " + new String(caesarCipher.decoder));

        String message = "THE EAGLE IS IN PLAY; MEET AT JOE'S";

        String coded = caesarCipher.encrypt(message);
        String decoded = caesarCipher.decrypt(coded);

        System.out.println("Encrypted message " + coded);
        System.out.println("Decrypted message " + decoded);
    }
}
