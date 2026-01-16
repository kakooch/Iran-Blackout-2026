package ir.aaap.messengercore;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

/* loaded from: classes3.dex */
public interface CoreEncryptionHelper {
    String decryptRSA(String str, PrivateKey privateKey) throws GeneralSecurityException, IOException;

    String encodeChars(String str);

    KeyPair generateKey();

    boolean supportAlgorithm();

    String toPemString(PublicKey publicKey);

    PrivateKey toPrivate(String str);

    PublicKey toPublic(String str);

    String toString(PrivateKey privateKey);

    String toString(PublicKey publicKey);
}
