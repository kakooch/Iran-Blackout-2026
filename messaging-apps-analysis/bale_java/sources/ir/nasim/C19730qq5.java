package ir.nasim;

import ir.nasim.AbstractC5747Kq7;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: ir.nasim.qq5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C19730qq5 implements InterfaceC19139pq5 {
    public static final AbstractC5747Kq7.b d = AbstractC5747Kq7.b.a;
    private final SecretKey a;
    private byte[] b;
    private byte[] c;

    public C19730qq5(byte[] bArr) throws GeneralSecurityException {
        AbstractC12327eQ7.a(bArr.length);
        this.a = new SecretKeySpec(bArr, "AES");
        b();
    }

    private void b() throws GeneralSecurityException {
        Cipher cipherC = c();
        cipherC.init(1, this.a);
        byte[] bArrB = AbstractC8795Xj.b(cipherC.doFinal(new byte[16]));
        this.b = bArrB;
        this.c = AbstractC8795Xj.b(bArrB);
    }

    private static Cipher c() throws GeneralSecurityException {
        if (d.a()) {
            return (Cipher) P82.b.a("AES/ECB/NoPadding");
        }
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }

    @Override // ir.nasim.InterfaceC19139pq5
    public byte[] a(byte[] bArr, int i) throws GeneralSecurityException {
        if (i > 16) {
            throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
        }
        Cipher cipherC = c();
        cipherC.init(1, this.a);
        int iMax = Math.max(1, (int) Math.ceil(bArr.length / 16.0d));
        byte[] bArrD = iMax * 16 == bArr.length ? AbstractC8841Xo0.d(bArr, (iMax - 1) * 16, this.b, 0, 16) : AbstractC8841Xo0.e(AbstractC8795Xj.a(Arrays.copyOfRange(bArr, (iMax - 1) * 16, bArr.length)), this.c);
        byte[] bArrDoFinal = new byte[16];
        for (int i2 = 0; i2 < iMax - 1; i2++) {
            bArrDoFinal = cipherC.doFinal(AbstractC8841Xo0.d(bArrDoFinal, 0, bArr, i2 * 16, 16));
        }
        return Arrays.copyOf(cipherC.doFinal(AbstractC8841Xo0.e(bArrD, bArrDoFinal)), i);
    }
}
