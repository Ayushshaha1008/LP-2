package practical6;

import java.math.BigInteger;
import java.util.Scanner;

public class DiffieHellman {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Public parameters
        System.out.print("Enter a prime number (P): ");
        BigInteger P = sc.nextBigInteger(); // e.g., 23

        System.out.print("Enter primitive root modulo P (G): ");
        BigInteger G = sc.nextBigInteger(); // e.g., 5

        // Step 2: Private keys
        System.out.print("Enter private key for User A: ");
        BigInteger a = sc.nextBigInteger(); // e.g., 4

        System.out.print("Enter private key for User B: ");
        BigInteger b = sc.nextBigInteger(); // e.g., 3

        // Step 3: Calculate public keys
        BigInteger x = G.modPow(a, P); // A's public key
        BigInteger y = G.modPow(b, P); // B's public key

        // Step 4: Exchange public keys and compute shared secret key
        BigInteger keyA = y.modPow(a, P); // A computes key
        BigInteger keyB = x.modPow(b, P); // B computes key

        // Step 5: Output results
        System.out.println("\nPublic Key of A (x) = " + x);
        System.out.println("Public Key of B (y) = " + y);
        System.out.println("Shared Secret Key calculated by A = " + keyA);
        System.out.println("Shared Secret Key calculated by B = " + keyB);

        if (keyA.equals(keyB)) {
            System.out.println("Key exchange successful! Shared key = " + keyA);
        } else {
            System.out.println("Key mismatch! Something went wrong.");
        }

        sc.close();
    }
}
