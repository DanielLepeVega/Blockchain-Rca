/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.blockchainrcanetb;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.*;
import java.io.*;

/**
 *
 * @author yo_da
 */
public class RSA {

    // User parameter
    public int BIT_LENGTH = 512;

    // Generate random primes
    public Random rand = new SecureRandom();
    public BigInteger p = BigInteger.probablePrime(BIT_LENGTH / 2, rand);
    public BigInteger q = BigInteger.probablePrime(BIT_LENGTH / 2, rand);
    //BigInteger p = BigInteger.probablePrime(3, 111111111);
    //BigInteger q = BigInteger.probablePrime(3, 111111111);

    // Calculate products
    public BigInteger n = p.multiply(q);
    public BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
    public BigInteger e;
    public BigInteger d;

    public RSA() {

        // Generate public and private exponents
        do {
            this.e = new BigInteger(this.phi.bitLength(), rand);
        } while (this.e.compareTo(BigInteger.ONE) <= 0 || this.e.compareTo(this.phi) >= 0 || !this.e.gcd(this.phi).equals(BigInteger.ONE));
        this.d = this.e.modInverse(this.phi);

        // Message encryption
        //BigInteger mssg = BigInteger.valueOf(5);
        //BigInteger msg = (mssg);  // Any integer in the range [0, n)
        //BigInteger enc = msg.modPow(e, n);
        // Message decryption
        //BigInteger dec = enc.modPow(d, n);
    }

    public ArrayList<BigInteger> encryptMsg(ArrayList<BigInteger> msg) {
        for (int i = 0; i < msg.size(); i++) {
            msg.set(i, msg.get(i).modPow(this.e, this.n));
        }
        return msg;
    }

    public ArrayList<BigInteger> desencryptMsg(ArrayList<BigInteger> enc) {
        for (int i = 0; i < enc.size(); i++) {
            enc.set(i, enc.get(i).modPow(this.d, this.n));
        }
        return enc;
    }

    public ArrayList<String> strToArrayList(String string) {
        String str[] = string.split(" ");
        List<String> aList = new ArrayList<String>();
        aList = Arrays.asList(str);
        ArrayList<String> msg = new ArrayList<String>();
        for (int i = 0; i < aList.size(); i++) {
            msg.add(aList.get(i));
        }
        return msg;
    }

    public ArrayList<BigInteger> stringToBigInt(String msg) {
        ArrayList<Character> word = new ArrayList<Character>();
        ArrayList<BigInteger> bigIntToCipher = new ArrayList<BigInteger>();
        //Character ch = ' ';
        for (int i = 0; i < msg.length(); i++) {
            /*if(msg.charAt(i) == ch){
                i++;
            }
            else{
                word.add(msg.charAt(i));
            }*/
            word.add(msg.charAt(i));
        }
        HashMap<Character, Integer> cipherLepe = new HashMap<>();
        cipherLepe.put('A', 14);
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
        //cipherLepe.put('Ñ', 14);
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
        cipherLepe.put(' ', 27);
        for (int i = 0; i < word.size(); i++) {
            /*System.out.println(word.get(i));
            System.out.println("---------------");
            System.out.println(cipherLepe.get(word.get(i)));
            System.out.println("---------------");
            System.out.println(BigInteger.valueOf(cipherLepe.get(word.get(i))));
            System.out.println("---------------");*/
            bigIntToCipher.add(BigInteger.valueOf(cipherLepe.get(word.get(i))));
        }

        //BigInteger value = BigInteger.valueOf(5);
        //bigIntToCipher.add(value);
        return bigIntToCipher;
    }

    public ArrayList<String> bigIntToString(ArrayList<BigInteger> bigInt) {
        ArrayList<String> bigIntToDecipher = new ArrayList<String>();
        HashMap<Integer, Character> cipherLepe = new HashMap<>();
        cipherLepe.put(14, 'A');
        cipherLepe.put(1, 'B');
        cipherLepe.put(2, 'C');
        cipherLepe.put(3, 'D');
        cipherLepe.put(4, 'E');
        cipherLepe.put(5, 'F');
        cipherLepe.put(6, 'G');
        cipherLepe.put(7, 'H');
        cipherLepe.put(8, 'I');
        cipherLepe.put(9, 'J');
        cipherLepe.put(10, 'K');
        cipherLepe.put(11, 'L');
        cipherLepe.put(12, 'M');
        cipherLepe.put(13, 'N');
        //cipherLepe.put(14, 'Ñ');
        cipherLepe.put(15, 'O');
        cipherLepe.put(16, 'P');
        cipherLepe.put(17, 'Q');
        cipherLepe.put(18, 'R');
        cipherLepe.put(19, 'S');
        cipherLepe.put(20, 'T');
        cipherLepe.put(21, 'U');
        cipherLepe.put(22, 'V');
        cipherLepe.put(23, 'W');
        cipherLepe.put(24, 'X');
        cipherLepe.put(25, 'Y');
        cipherLepe.put(26, 'Z');
        cipherLepe.put(27, ' ');
        for (int i = 0; i < bigInt.size(); i++) {
            /*System.out.println(bigInt.get(i));
            System.out.println("---------------bigInt");
            System.out.println(cipherLepe.get(bigInt.get(i).intValue()));
            System.out.println("---------------cipherLepe");
            System.out.println(Character.toString(cipherLepe.get(bigInt.get(i).intValue())));
            System.out.println("---------------character");*/
            bigIntToDecipher.add(Character.toString(cipherLepe.get(bigInt.get(i).intValue())));
        }
        return bigIntToDecipher;
    }

    public ArrayList<BigInteger> cipherInt(int msgToEncrypt) {
        BigInteger mssg = BigInteger.valueOf(msgToEncrypt);
        ArrayList<BigInteger> arrCipher = new ArrayList<BigInteger>();
        arrCipher.add(mssg);
        this.encryptMsg(arrCipher);
        return arrCipher;
    }

    public int descipherInt(ArrayList<BigInteger> msgToDesencrypt) {
        ArrayList<BigInteger> arrDescipher = this.desencryptMsg(msgToDesencrypt);
        return arrDescipher.get(0).intValue();
    }

    public ArrayList<BigInteger> cipherMsg(String msgToEncrypt) {
        ArrayList<BigInteger> msg = this.stringToBigInt(msgToEncrypt);
        return this.encryptMsg(msg);
        /*System.out.println();
        System.out.println("----------Message Encrypted-------------");
        for(int i=0;i<msg.size();i++){
            System.out.print(msg.get(i));
        }*/
        /////////////////////ArrayList<BigInteger> mssg = this.desencryptMsg(msg);
        /*System.out.println();
        System.out.println("----------Message Desencrypted------------");
        for(int i=0;i<msg.size();i++){
            System.out.print(msg.get(i));
        }*/
        /* System.out.println();
        System.out.println("----------Final Message-----------");*/
        /////////////////////ArrayList<String> msgDeciphered = this.bigIntToString(mssg);
        /*for(int i=0;i<msgDeciphered.size();i++){
            System.out.print(msgDeciphered.get(i));
        }
        System.out.println();
        System.out.println("----------*****************---------");*/

    }

    public void setN(String n) {
        BigInteger N = new BigInteger(n);
        this.n = N;
    }

    public void setD(String d) {
        BigInteger D = new BigInteger(d);
        this.d = D;
    }

    public ArrayList<String> descipherMsg(ArrayList<BigInteger> msgToDesencrypt) {
        ArrayList<BigInteger> mssg = this.desencryptMsg(msgToDesencrypt);
        return this.bigIntToString(mssg);
    }

    public void writeFile(String msg, int quantity) {
        ArrayList<BigInteger> msgToEncrypt = this.cipherMsg(msg);
        ArrayList<BigInteger> quantityToEncrypt = this.cipherInt(quantity);
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("salida.txt"));
            //pw.println("");
            for (int i = 0; i < msgToEncrypt.size(); i++) {
                pw.println(msgToEncrypt.get(i));
            }
            //pw.println();
            pw.println("---");
            //pw.println();
            for (int i = 0; i < quantityToEncrypt.size(); i++) {
                pw.print(quantityToEncrypt.get(i));
            }
            pw.println();
            pw.println("---");
            pw.println(this.n);
            pw.println("---");
            pw.println(this.d);
            pw.close();
        } catch (IOException e) {
            System.out.println("Error " + e);
        }
    }

    public StringInt readFile(String fileName) {
        ArrayList<BigInteger> msgToDesencrypt = new ArrayList<BigInteger>();
        ArrayList<BigInteger> quantityToDesencrypt = new ArrayList<BigInteger>();
        StringInt result = new StringInt();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            line = br.readLine();
            while (line != null) {
                //System.out.println("-------------------------");
                //System.out.println(line);
                BigInteger word = new BigInteger(line);
                msgToDesencrypt.add(word);

                //System.out.println("-------------------------");
                line = br.readLine();
                if (line.equals("---")) {
                    //System.out.println("------------********-------------");
                    //System.out.println(line);
                    line = br.readLine();
                    //line = br.readLine();
                    //System.out.println(line);
                    BigInteger word2 = new BigInteger(line);
                    quantityToDesencrypt.add(word2);
                    line = br.readLine();
                    line = br.readLine();
                    this.setN(line);
                    line = br.readLine();
                    line = br.readLine();
                    this.setD(line);
                    break;
                }
            }
            br.close();
            ArrayList<String> msgDesciphered = descipherMsg(msgToDesencrypt);
            int intDesciphered = descipherInt(quantityToDesencrypt);
            //System.out.print("Message: ");
            for (int i = 0; i < msgDesciphered.size(); i++) {
                //System.out.print(msgDesciphered.get(i));
                result.addMsg(msgDesciphered.get(i));
            }
            System.out.println();
            //System.out.println("Quantity: " + intDesciphered);
            result.setInt(intDesciphered);
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e);
        } catch (IOException e) {
            System.out.println("File couldn't be read " + e);
        }
        return result;
    }
}
