package ir.nasim;

import ir.nasim.AbstractC5747Kq7;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: ir.nasim.dj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C11887dj implements Y53 {
    public static final AbstractC5747Kq7.b d = AbstractC5747Kq7.b.b;
    private static final ThreadLocal e = new a();
    private final SecretKeySpec a;
    private final int b;
    private final int c;

    /* renamed from: ir.nasim.dj$a */
    class a extends ThreadLocal {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Cipher initialValue() {
            try {
                return (Cipher) P82.b.a("AES/CTR/NoPadding");
            } catch (GeneralSecurityException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public C11887dj(byte[] bArr, int i) throws GeneralSecurityException {
        if (!d.a()) {
            throw new GeneralSecurityException("Can not use AES-CTR in FIPS-mode, as BoringCrypto module is not available.");
        }
        AbstractC12327eQ7.a(bArr.length);
        this.a = new SecretKeySpec(bArr, "AES");
        int blockSize = ((Cipher) e.get()).getBlockSize();
        this.c = blockSize;
        if (i < 12 || i > blockSize) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.b = i;
    }

    private void b(byte[] bArr, int i, int i2, byte[] bArr2, int i3, byte[] bArr3, boolean z) throws GeneralSecurityException {
        Cipher cipher = (Cipher) e.get();
        byte[] bArr4 = new byte[this.c];
        System.arraycopy(bArr3, 0, bArr4, 0, this.b);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr4);
        if (z) {
            cipher.init(1, this.a, ivParameterSpec);
        } else {
            cipher.init(2, this.a, ivParameterSpec);
        }
        if (cipher.doFinal(bArr, i, i2, bArr2, i3) != i2) {
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
    }

    @Override // ir.nasim.Y53
    public byte[] a(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.b;
        if (length < i) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        int length2 = bArr.length;
        int i2 = this.b;
        byte[] bArr3 = new byte[length2 - i2];
        b(bArr, i2, bArr.length - i2, bArr3, 0, bArr2, false);
        return bArr3;
    }

    @Override // ir.nasim.Y53
    public byte[] encrypt(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.b;
        if (length > Integer.MAX_VALUE - i) {
            throw new GeneralSecurityException("plaintext length can not exceed " + (Integer.MAX_VALUE - this.b));
        }
        byte[] bArr2 = new byte[bArr.length + i];
        byte[] bArrA = AbstractC16435lG5.a(i);
        System.arraycopy(bArrA, 0, bArr2, 0, this.b);
        b(bArr, 0, bArr.length, bArr2, this.b, bArrA, true);
        return bArr2;
    }
}
