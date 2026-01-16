package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableEntryException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.spec.RSAKeyGenParameterSpec;
import javax.crypto.Cipher;

/* renamed from: ir.nasim.No3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC6431No3 {
    public static void a(Context context, String str) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException, NoSuchProviderException, InvalidAlgorithmParameterException {
        InterfaceC3570Bk5 interfaceC3570Bk5Q = C7183Qq.q(EnumC18608ow5.s);
        boolean zH = interfaceC3570Bk5Q.h("lock.key.inited", false);
        boolean zH2 = h(str);
        if (!zH && !zH2) {
            b(context, str, false);
            interfaceC3570Bk5Q.g("lock.key.inited", true);
        } else {
            if (zH || !zH2) {
                return;
            }
            interfaceC3570Bk5Q.g("lock.key.inited", true);
        }
    }

    private static void b(Context context, String str, boolean z) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        try {
            try {
                KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(str, 3).setAlgorithmParameterSpec(new RSAKeyGenParameterSpec(SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, RSAKeyGenParameterSpec.F4)).setBlockModes("CBC").setEncryptionPaddings("PKCS1Padding").setDigests("SHA-256", "SHA-384", "SHA-512").setUserAuthenticationRequired(z).build());
                try {
                    keyPairGenerator.generateKeyPair();
                } catch (Exception e) {
                    C19406qI3.a("KeyStoreHelper", "[createKM+] failed to create pk with error: \n" + e.getMessage(), new Object[0]);
                }
            } catch (ExceptionInInitializerError e2) {
                e = e2;
                throw new RuntimeException(e);
            }
        } catch (InvalidAlgorithmParameterException e3) {
            e = e3;
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e4) {
            e = e4;
            throw new RuntimeException(e);
        } catch (NoSuchProviderException e5) {
            e = e5;
            throw new RuntimeException(e);
        }
    }

    public static byte[] c(String str, byte[] bArr) throws InvalidKeyException {
        try {
            KeyPair keyPairF = f(str, true);
            if (keyPairF == null) {
                C19406qI3.j("KeyStoreHelper", "[decrypt] keyPair is NULL", new Object[0]);
                return null;
            }
            PrivateKey privateKey = keyPairF.getPrivate();
            Cipher cipherE = e();
            cipherE.init(2, privateKey);
            return cipherE.doFinal(bArr);
        } catch (Exception e) {
            C19406qI3.d("KeyStoreHelper", e);
            return null;
        }
    }

    public static byte[] d(String str, byte[] bArr) throws InvalidKeyException {
        try {
            KeyPair keyPairF = f(str, true);
            if (keyPairF == null) {
                C19406qI3.j("KeyStoreHelper", "[encrypt] keyPair is NULL", new Object[0]);
                return null;
            }
            PublicKey publicKey = keyPairF.getPublic();
            Cipher cipherE = e();
            cipherE.init(1, publicKey);
            return cipherE.doFinal(bArr);
        } catch (Exception e) {
            C19406qI3.d("KeyStoreHelper", e);
            return null;
        }
    }

    private static Cipher e() {
        return Cipher.getInstance(String.format("%s/%s/%s", "RSA", "NONE", "PKCS1Padding"));
    }

    private static KeyPair f(String str, boolean z) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableEntryException {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                KeyStore keyStoreG = g();
                PrivateKey privateKey = (PrivateKey) keyStoreG.getKey(str, null);
                PublicKey publicKey = keyStoreG.getCertificate(str).getPublicKey();
                if (privateKey != null && publicKey != null) {
                    return new KeyPair(publicKey, privateKey);
                }
                C19406qI3.j("KeyStoreHelper", "No key found under alias", new Object[0]);
                C19406qI3.j("KeyStoreHelper", "Exiting signData()...", new Object[0]);
                return null;
            }
            KeyStore.Entry entry = g().getEntry(str, null);
            if (entry == null) {
                C19406qI3.j("KeyStoreHelper", "No key found under alias ", new Object[0]);
                C19406qI3.j("KeyStoreHelper", "Exiting signData()...", new Object[0]);
                return null;
            }
            if (entry instanceof KeyStore.PrivateKeyEntry) {
                KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) entry;
                return new KeyPair(privateKeyEntry.getCertificate().getPublicKey(), privateKeyEntry.getPrivateKey());
            }
            C19406qI3.j("KeyStoreHelper", "Not an instance of a pke", new Object[0]);
            C19406qI3.j("KeyStoreHelper", "Exiting signData()...", new Object[0]);
            return null;
        } catch (Exception e) {
            C19406qI3.d("KeyStoreHelper", e);
            if ((e instanceof UnrecoverableKeyException) && z) {
                try {
                    g().deleteEntry(str);
                    f(str, false);
                } catch (Exception e2) {
                    C19406qI3.d("KeyStoreHelper", e2);
                }
            }
            return null;
        }
    }

    private static KeyStore g() throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        return keyStore;
    }

    public static boolean h(String str) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            return keyStore.containsAlias(str);
        } catch (Exception e) {
            C19406qI3.d("KeyStoreHelper", e);
            return false;
        }
    }
}
