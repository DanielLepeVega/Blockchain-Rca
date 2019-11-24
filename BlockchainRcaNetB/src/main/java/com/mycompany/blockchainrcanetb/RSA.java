/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.blockchainrcanetb;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
/**
 *
 * @author yo_da
 */
public class RSA {
    

    // User parameter
    int BIT_LENGTH = 2048;

    // Generate random primes
    Random rand = new SecureRandom();
    BigInteger p = BigInteger.probablePrime(BIT_LENGTH / 2, rand);
    BigInteger q = BigInteger.probablePrime(BIT_LENGTH / 2, rand);

    // Calculate products
    BigInteger n = p.multiply(q);
    BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

    // Generate public and private exponents
    BigInteger e;
    do e = new BigInteger(phi.bitLength(), rand);
    while (e.compareTo(BigInteger.ONE) <= 0 || e.compareTo(phi) >= 0 || !e.gcd(phi).equals(BigInteger.ONE));
    BigInteger d = e.modInverse(phi);
    
    
    // Message encryption
    BigInteger mssg = BigInteger.valueOf(5);
    BigInteger msg = (mssg);  // Any integer in the range [0, n)
    BigInteger enc = msg.modPow(e, n);

    // Message decryption
    BigInteger dec = enc.modPow(d, n);
}
