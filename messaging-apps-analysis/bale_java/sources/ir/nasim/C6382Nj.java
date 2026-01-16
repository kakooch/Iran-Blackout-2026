package ir.nasim;

import ir.nasim.AbstractC5747Kq7;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: ir.nasim.Nj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C6382Nj implements GJ1 {
    public static final AbstractC5747Kq7.b c = AbstractC5747Kq7.b.a;
    private static final Collection d = Arrays.asList(64);
    private static final byte[] e = new byte[16];
    private static final byte[] f = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
    private final C19730qq5 a;
    private final byte[] b;

    public C6382Nj(byte[] bArr) throws GeneralSecurityException {
        if (!c.a()) {
            throw new GeneralSecurityException("Can not use AES-SIV in FIPS-mode.");
        }
        if (d.contains(Integer.valueOf(bArr.length))) {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length / 2);
            this.b = Arrays.copyOfRange(bArr, bArr.length / 2, bArr.length);
            this.a = new C19730qq5(bArrCopyOfRange);
        } else {
            throw new InvalidKeyException("invalid key size: " + bArr.length + " bytes; key must have 64 bytes");
        }
    }

    private byte[] c(byte[]... bArr) throws GeneralSecurityException {
        if (bArr.length == 0) {
            return this.a.a(f, 16);
        }
        byte[] bArrA = this.a.a(e, 16);
        for (int i = 0; i < bArr.length - 1; i++) {
            byte[] bArr2 = bArr[i];
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            bArrA = AbstractC8841Xo0.e(AbstractC8795Xj.b(bArrA), this.a.a(bArr2, 16));
        }
        byte[] bArr3 = bArr[bArr.length - 1];
        return this.a.a(bArr3.length >= 16 ? AbstractC8841Xo0.f(bArr3, bArrA) : AbstractC8841Xo0.e(AbstractC8795Xj.a(bArr3), AbstractC8795Xj.b(bArrA)), 16);
    }

    @Override // ir.nasim.GJ1
    public byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > 2147483631) {
            throw new GeneralSecurityException("plaintext too long");
        }
        Cipher cipher = (Cipher) P82.b.a("AES/CTR/NoPadding");
        byte[] bArrC = c(bArr2, bArr);
        byte[] bArr3 = (byte[]) bArrC.clone();
        bArr3[8] = (byte) (bArr3[8] & 127);
        bArr3[12] = (byte) (bArr3[12] & 127);
        cipher.init(1, new SecretKeySpec(this.b, "AES"), new IvParameterSpec(bArr3));
        return AbstractC8841Xo0.a(bArrC, cipher.doFinal(bArr));
    }

    @Override // ir.nasim.GJ1
    public byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length < 16) {
            throw new GeneralSecurityException("Ciphertext too short.");
        }
        Cipher cipher = (Cipher) P82.b.a("AES/CTR/NoPadding");
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, 16);
        byte[] bArr3 = (byte[]) bArrCopyOfRange.clone();
        bArr3[8] = (byte) (bArr3[8] & 127);
        bArr3[12] = (byte) (bArr3[12] & 127);
        cipher.init(2, new SecretKeySpec(this.b, "AES"), new IvParameterSpec(bArr3));
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, 16, bArr.length);
        byte[] bArrDoFinal = cipher.doFinal(bArrCopyOfRange2);
        if (bArrCopyOfRange2.length == 0 && bArrDoFinal == null && E07.a()) {
            bArrDoFinal = new byte[0];
        }
        if (AbstractC8841Xo0.b(bArrCopyOfRange, c(bArr2, bArrDoFinal))) {
            return bArrDoFinal;
        }
        throw new AEADBadTagException("Integrity check failed.");
    }
}
