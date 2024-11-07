package com.omg.pf.client.netty.cipher;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public class SecretKeyGenerator {
    public static SecretKey decryptSecretKey(PrivateKey privateKey, byte[] bytes) {
        return new SecretKeySpec(decryptCipher(privateKey, bytes), "AES");
    }

    public static SecretKey genSecretKey() {
        try {
            KeyGenerator var0 = KeyGenerator.getInstance("AES");
            var0.init(128);
            return var0.generateKey();
        } catch (NoSuchAlgorithmException var1) {
            throw new Error(var1);
        }
    }


    public static KeyPair genPublicKeyPair() {
        try {
            KeyPairGenerator var0 = KeyPairGenerator.getInstance("RSA");
            var0.initialize(1024);
            return var0.generateKeyPair();
        } catch (NoSuchAlgorithmException var1) {
            var1.printStackTrace();
            return null;
        }
    }

    public static byte[] Method808(String var0, PublicKey var1, SecretKey var2) {
        try {
            return Method810("SHA-1", var0.getBytes("ISO_8859_1"), var2.getEncoded(), var1.getEncoded());
        } catch (UnsupportedEncodingException var4) {
            var4.printStackTrace();
            return null;
        }
    }

    // $FF: synthetic method
    private static byte[] Method810(String var0, byte[]... var1) {
        try {
            MessageDigest var2 = MessageDigest.getInstance(var0);
            byte[][] var3 = var1;
            int var4 = var1.length;

            for (int var5 = 0; var5 < var4; ++var5) {
                byte[] var6 = var3[var5];
                var2.update(var6);
            }

            return var2.digest();
        } catch (NoSuchAlgorithmException var7) {
            var7.printStackTrace();
            return null;
        }
    }

    public static byte[] encryptCipher(Key key, byte[] bytes) {
        return doCipher(1, key, bytes);
    }

    public static Cipher getCipher(int opMode, Key key) {
        try {
            Cipher var2 = Cipher.getInstance("AES/CFB8/NoPadding");
            var2.init(opMode, key, new IvParameterSpec(key.getEncoded()));
            return var2;
        } catch (GeneralSecurityException var3) {
            throw new RuntimeException(var3);
        }
    }

    public static PublicKey decodePublicKey(byte[] bytes) {
        try {
            X509EncodedKeySpec var1 = new X509EncodedKeySpec(bytes);
            return KeyFactory.getInstance("RSA").generatePublic(var1);
        } catch (NoSuchAlgorithmException var2) {
        } catch (InvalidKeySpecException var3) {
        }

        return null;
    }


    private static byte[] doCipher(int opMode, Key key, byte[] toDO) {
        try {
            return doCipher(opMode, key.getAlgorithm(), key).doFinal(toDO);
        } catch (IllegalBlockSizeException | BadPaddingException var4) {
            var4.printStackTrace();
        }

        return null;
    }

    // $FF: synthetic method
    private static Cipher doCipher(int opMode, String transformation, Key key) {
        try {
            Cipher var3 = Cipher.getInstance(transformation);
            var3.init(opMode, key);
            return var3;
        } catch (InvalidKeyException var4) {
            var4.printStackTrace();
        } catch (NoSuchAlgorithmException var5) {
            var5.printStackTrace();
        } catch (NoSuchPaddingException var6) {
            var6.printStackTrace();
        }

        return null;
    }

    public static byte[] decryptCipher(Key var0, byte[] var1) {
        return doCipher(2, var0, var1);
    }
}
