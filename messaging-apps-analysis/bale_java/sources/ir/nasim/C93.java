package ir.nasim;

import ir.nasim.AbstractC5747Kq7;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public final class C93 {
    public static final AbstractC5747Kq7.b c = AbstractC5747Kq7.b.b;
    private static final ThreadLocal d = new a();
    private final SecretKey a;
    private final boolean b;

    class a extends ThreadLocal {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Cipher initialValue() {
            try {
                return (Cipher) P82.b.a("AES/GCM/NoPadding");
            } catch (GeneralSecurityException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public C93(byte[] bArr, boolean z) throws GeneralSecurityException {
        if (!c.a()) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        AbstractC12327eQ7.a(bArr.length);
        this.a = new SecretKeySpec(bArr, "AES");
        this.b = z;
    }

    private static AlgorithmParameterSpec c(byte[] bArr) {
        return d(bArr, 0, bArr.length);
    }

    private static AlgorithmParameterSpec d(byte[] bArr, int i, int i2) {
        Integer numC = AbstractC10893cN7.c();
        return (numC == null || numC.intValue() > 19) ? new GCMParameterSpec(128, bArr, i, i2) : new IvParameterSpec(bArr, i, i2);
    }

    public byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (bArr.length != 12) {
            throw new GeneralSecurityException("iv is wrong size");
        }
        boolean z = this.b;
        if (bArr2.length < (z ? 28 : 16)) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (z && !ByteBuffer.wrap(bArr).equals(ByteBuffer.wrap(bArr2, 0, 12))) {
            throw new GeneralSecurityException("iv does not match prepended iv");
        }
        AlgorithmParameterSpec algorithmParameterSpecC = c(bArr);
        ThreadLocal threadLocal = d;
        ((Cipher) threadLocal.get()).init(2, this.a, algorithmParameterSpecC);
        if (bArr3 != null && bArr3.length != 0) {
            ((Cipher) threadLocal.get()).updateAAD(bArr3);
        }
        boolean z2 = this.b;
        return ((Cipher) threadLocal.get()).doFinal(bArr2, z2 ? 12 : 0, z2 ? bArr2.length - 12 : bArr2.length);
    }

    public byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (bArr.length != 12) {
            throw new GeneralSecurityException("iv is wrong size");
        }
        if (bArr2.length > 2147483619) {
            throw new GeneralSecurityException("plaintext too long");
        }
        boolean z = this.b;
        byte[] bArr4 = new byte[z ? bArr2.length + 28 : bArr2.length + 16];
        if (z) {
            System.arraycopy(bArr, 0, bArr4, 0, 12);
        }
        AlgorithmParameterSpec algorithmParameterSpecC = c(bArr);
        ThreadLocal threadLocal = d;
        ((Cipher) threadLocal.get()).init(1, this.a, algorithmParameterSpecC);
        if (bArr3 != null && bArr3.length != 0) {
            ((Cipher) threadLocal.get()).updateAAD(bArr3);
        }
        int iDoFinal = ((Cipher) threadLocal.get()).doFinal(bArr2, 0, bArr2.length, bArr4, this.b ? 12 : 0);
        if (iDoFinal == bArr2.length + 16) {
            return bArr4;
        }
        throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", 16, Integer.valueOf(iDoFinal - bArr2.length)));
    }
}
