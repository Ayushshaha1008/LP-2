package practical3;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class DESExample {

    // Method to generate a DES key from a string
    public static SecretKey getKey(String keyStr) throws Exception {
        byte[] keyBytes = keyStr.getBytes("UTF-8");
        // DES key size must be 8 bytes
        byte[] keyBytes8 = new byte[8];
        System.arraycopy(keyBytes, 0, keyBytes8, 0, Math.min(keyBytes.length, 8));
        return new SecretKeySpec(keyBytes8, "DES");
    }

    // Padding method
    public static String pad(String text) {
        int padLen = 8 - (text.length() % 8);
        return text + " ".repeat(padLen);
    }

    public static void main(String[] args) {
        try {
            String keyStr = "hello123"; // 8-byte key
            String plaintext = "Python is the Best Language!";

            // Padding the plaintext to be multiple of 8
            String paddedText = pad(plaintext);

            // Get DES key
            SecretKey key = getKey(keyStr);

            // Create cipher
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

            // Encrypt
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encrypted = cipher.doFinal(paddedText.getBytes("UTF8"));
            String encryptedText = Base64.getEncoder().encodeToString(encrypted);

            // Decrypt
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
            String decryptedText = new String(decrypted).trim(); // Remove padding

            // Output
            System.out.println("Plaintext      : " + plaintext);
            System.out.println("Encrypted Text : " + encryptedText);
            System.out.println("Decrypted Text : " + decryptedText);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
