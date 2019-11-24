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
    BigInteger e;
    BigInteger d;
    
    public RSA(){

        // Generate public and private exponents
        
        do this.e = new BigInteger(this.phi.bitLength(), rand);
        while (this.e.compareTo(BigInteger.ONE) <= 0 || this.e.compareTo(this.phi) >= 0 || !this.e.gcd(this.phi).equals(BigInteger.ONE));
        this.d = this.e.modInverse(this.phi);

        // Message encryption
        //BigInteger mssg = BigInteger.valueOf(5);
        //BigInteger msg = (mssg);  // Any integer in the range [0, n)
        //BigInteger enc = msg.modPow(e, n);

        // Message decryption
        //BigInteger dec = enc.modPow(d, n);
    }
    
    public BigInteger encryptMsg(BigInteger msg){
        return msg.modPow(this.e, this.n);
    }
    
    public BigInteger desencryptMsg(BigInteger enc){
        return enc.modPow(this.e, this.n);
    }
    
    public ArrayList<BigInteger> stringToBigInt(String msg){
        ArrayList<Character> word = new ArrayList<Character>();
        ArrayList<BigInteger> bigIntToCipher = new ArrayList<BigInteger>();
        for(int i=0;i<msg.length();i++){
            word.add(msg.charAt(i));
        }
        HashMap<Character, Integer> cipherLepe = new HashMap<>();
        cipherLepe.put('A', 0);
        cipherLepe.put('B', 1);
        cipherLepe.put('C', 2);
        cipherLepe.put('D', 3);
        cipherLepe.put('E', 4);
        cipherLepe.put('F', 5);
        cipherLepe.put('G', 6);
        cipherLepe.put('H', 7);
        cipherLepe.put('I', 8);
        cipherLepe.put('J', 9);
        cipherLepe.put('K', 10);
        cipherLepe.put('L', 11);
        cipherLepe.put('M', 12);
        cipherLepe.put('N', 13);
        cipherLepe.put('Ñ', 14);
        cipherLepe.put('O', 15);
        cipherLepe.put('P', 16);
        cipherLepe.put('Q', 17);
        cipherLepe.put('R', 18);
        cipherLepe.put('S', 19);
        cipherLepe.put('T', 20);
        cipherLepe.put('U', 21);
        cipherLepe.put('V', 22);
        cipherLepe.put('W', 23);
        cipherLepe.put('X', 24);
        cipherLepe.put('Y', 25);
        cipherLepe.put('Z', 26);
        
        for(int i=0;i<word.size();i++){
            bigIntToCipher.add(BigInteger.valueOf(cipherLepe.get(word.get(i))));
        }
        
        return bigIntToCipher;
    }
}
