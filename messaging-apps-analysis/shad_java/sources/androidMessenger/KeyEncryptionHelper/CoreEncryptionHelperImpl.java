package androidMessenger.KeyEncryptionHelper;

import android.util.Base64;
import androidMessenger.network.EncryptionHelper;
import com.facebook.stetho.common.Utf8Charset;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import ir.aaap.messengercore.CoreEncryptionHelper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import okio.ByteString;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;

/* loaded from: classes.dex */
public class CoreEncryptionHelperImpl implements CoreEncryptionHelper {
    private boolean isNotSupportingAlgorithm;

    @Override // ir.aaap.messengercore.CoreEncryptionHelper
    public String toString(PublicKey publicKey) {
        if (publicKey == null) {
            return null;
        }
        return encodeChars(Base64.encodeToString(publicKey.getEncoded(), 0));
    }

    @Override // ir.aaap.messengercore.CoreEncryptionHelper
    public String toPemString(PublicKey publicKey) {
        if (publicKey == null) {
            return null;
        }
        try {
            return Base64.encodeToString(("-----BEGIN PUBLIC KEY-----\r\n" + encodeChars(toString(publicKey)) + "-----END PUBLIC KEY-----").getBytes(Utf8Charset.NAME), 0);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // ir.aaap.messengercore.CoreEncryptionHelper
    public String toString(PrivateKey privateKey) {
        if (privateKey == null) {
            return null;
        }
        try {
            return encodeChars(ByteString.of(PrivateKeyInfo.getInstance(privateKey.getEncoded()).parsePrivateKey().toASN1Primitive().getEncoded()).base64());
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @Override // ir.aaap.messengercore.CoreEncryptionHelper
    public PublicKey toPublic(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(encodeChars(str), 0)));
        } catch (NoSuchAlgorithmException e) {
            this.isNotSupportingAlgorithm = true;
            FirebaseCrashlytics.getInstance().recordException(e);
            e.printStackTrace();
            return null;
        } catch (InvalidKeySpecException e2) {
            FirebaseCrashlytics.getInstance().recordException(e2);
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    @Override // ir.aaap.messengercore.CoreEncryptionHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.security.PrivateKey toPrivate(java.lang.String r5) throws java.security.spec.InvalidKeySpecException {
        /*
            r4 = this;
            java.lang.String r0 = "RSA"
            java.lang.String r5 = r4.encodeChars(r5)
            r1 = 0
            byte[] r5 = android.util.Base64.decode(r5, r1)
            java.security.spec.PKCS8EncodedKeySpec r1 = new java.security.spec.PKCS8EncodedKeySpec
            r1.<init>(r5)
            java.security.KeyFactory r5 = java.security.KeyFactory.getInstance(r0)     // Catch: java.security.spec.InvalidKeySpecException -> L19 java.security.NoSuchAlgorithmException -> L1e
            java.security.PrivateKey r5 = r5.generatePrivate(r1)     // Catch: java.security.spec.InvalidKeySpecException -> L19 java.security.NoSuchAlgorithmException -> L1e
            goto L23
        L19:
            r5 = move-exception
            ir.resaneh1.iptv.logger.MyLog.handleException(r5)
            goto L22
        L1e:
            r5 = move-exception
            ir.resaneh1.iptv.logger.MyLog.handleException(r5)
        L22:
            r5 = 0
        L23:
            if (r5 != 0) goto L5a
            r2 = 1
            java.lang.String r3 = "BC"
            java.security.KeyFactory r0 = java.security.KeyFactory.getInstance(r0, r3)     // Catch: java.security.NoSuchProviderException -> L31 java.security.spec.InvalidKeySpecException -> L3f java.security.NoSuchAlgorithmException -> L4d
            java.security.PrivateKey r5 = r0.generatePrivate(r1)     // Catch: java.security.NoSuchProviderException -> L31 java.security.spec.InvalidKeySpecException -> L3f java.security.NoSuchAlgorithmException -> L4d
            goto L5a
        L31:
            r0 = move-exception
            r4.isNotSupportingAlgorithm = r2
            com.google.firebase.crashlytics.FirebaseCrashlytics r1 = com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
            r1.recordException(r0)
            ir.resaneh1.iptv.logger.MyLog.handleException(r0)
            goto L5a
        L3f:
            r0 = move-exception
            r4.isNotSupportingAlgorithm = r2
            com.google.firebase.crashlytics.FirebaseCrashlytics r1 = com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
            r1.recordException(r0)
            ir.resaneh1.iptv.logger.MyLog.handleException(r0)
            goto L5a
        L4d:
            r0 = move-exception
            r4.isNotSupportingAlgorithm = r2
            com.google.firebase.crashlytics.FirebaseCrashlytics r1 = com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
            r1.recordException(r0)
            ir.resaneh1.iptv.logger.MyLog.handleException(r0)
        L5a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidMessenger.KeyEncryptionHelper.CoreEncryptionHelperImpl.toPrivate(java.lang.String):java.security.PrivateKey");
    }

    @Override // ir.aaap.messengercore.CoreEncryptionHelper
    public KeyPair generateKey() throws NoSuchAlgorithmException {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(1024);
            return keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            this.isNotSupportingAlgorithm = true;
            FirebaseCrashlytics.getInstance().recordException(e);
            e.printStackTrace();
            return null;
        }
    }

    @Override // ir.aaap.messengercore.CoreEncryptionHelper
    public String encodeChars(String str) {
        return EncryptionHelper.encodeChars(str);
    }

    @Override // ir.aaap.messengercore.CoreEncryptionHelper
    public boolean supportAlgorithm() {
        return !this.isNotSupportingAlgorithm;
    }

    @Override // ir.aaap.messengercore.CoreEncryptionHelper
    public String decryptRSA(String str, PrivateKey privateKey) throws GeneralSecurityException, IOException {
        return EncryptionHelper.decryptRSA(str, privateKey);
    }
}
