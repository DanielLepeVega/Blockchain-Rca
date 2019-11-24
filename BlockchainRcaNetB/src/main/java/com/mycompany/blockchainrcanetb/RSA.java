/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.blockchainrcanetb;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.*;
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
    BigInteger e = new BigInteger(phi.bitLength(), rand);
    //e.compareTo(BigInteger.ONE) <= 0 || e.compareTo(phi) >= 0 || !e.gcd(phi).equals(BigInteger.ONE);
    
    while(true){
        BigInteger d = e.modInverse(phi);
    }
    
    // Message encryption
    BigInteger mssg = BigInteger.valueOf(5);
    BigInteger msg = (mssg);  // Any integer in the range [0, n)
    BigInteger enc = msg.modPow(e, n);

    // Message decryption
    BigInteger dec = enc.modPow(d, n);
    
    public BigInteger stringToBigInt(String msg){
        BigInteger result;
        HashMap<String, Integer> cifradoLepe = new HashMap<>();
        cifradoLepe.put("A", 0);
        cifradoLepe.put("B", 1);
        cifradoLepe.put("C", 2);
        cifradoLepe.put("D", 3);
        cifradoLepe.put("E", 4);
        cifradoLepe.put("F", 5);
        cifradoLepe.put("G", 6);
        cifradoLepe.put("H", 7);
        cifradoLepe.put("I", 8);
        cifradoLepe.put("J", 9);
        cifradoLepe.put("K", 10);
        cifradoLepe.put("L", 11);
        cifradoLepe.put("M", 12);
        cifradoLepe.put("N", 13);
        cifradoLepe.put("Ñ", 14);
        cifradoLepe.put("O", 15);
        cifradoLepe.put("P", 16);
        cifradoLepe.put("Q", 17);
        cifradoLepe.put("R", 18);
        cifradoLepe.put("S", 19);
        cifradoLepe.put("T", 20);
        cifradoLepe.put("U", 21);
        cifradoLepe.put("V", 22);
        cifradoLepe.put("W", 23);
        cifradoLepe.put("X", 24);
        cifradoLepe.put("Y", 25);
        cifradoLepe.put("Z", 26);
        
        return result;
    }
}
