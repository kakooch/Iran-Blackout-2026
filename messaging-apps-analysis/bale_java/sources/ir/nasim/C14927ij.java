package ir.nasim;

import ir.nasim.AbstractC5747Kq7;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: ir.nasim.ij, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C14927ij implements InterfaceC3780Ci {
    public static final AbstractC5747Kq7.b e = AbstractC5747Kq7.b.a;
    private static final ThreadLocal f = new a();
    private static final ThreadLocal g = new b();
    private final byte[] a;
    private final byte[] b;
    private final SecretKeySpec c;
    private final int d;

    /* renamed from: ir.nasim.ij$a */
    class a extends ThreadLocal {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Cipher initialValue() {
            try {
                return (Cipher) P82.b.a("AES/ECB/NOPADDING");
            } catch (GeneralSecurityException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    /* renamed from: ir.nasim.ij$b */
    class b extends ThreadLocal {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Cipher initialValue() {
            try {
                return (Cipher) P82.b.a("AES/CTR/NOPADDING");
            } catch (GeneralSecurityException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public C14927ij(byte[] bArr, int i) throws GeneralSecurityException {
        if (!e.a()) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        if (i != 12 && i != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.d = i;
        AbstractC12327eQ7.a(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.c = secretKeySpec;
        Cipher cipher = (Cipher) f.get();
        cipher.init(1, secretKeySpec);
        byte[] bArrC = c(cipher.doFinal(new byte[16]));
        this.a = bArrC;
        this.b = c(bArrC);
    }

    private static byte[] c(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        while (i < 15) {
            int i2 = i + 1;
            bArr2[i] = (byte) (((bArr[i] << 1) ^ ((bArr[i2] & 255) >>> 7)) & 255);
            i = i2;
        }
        bArr2[15] = (byte) (((bArr[0] >> 7) & 135) ^ (bArr[15] << 1));
        return bArr2;
    }

    private byte[] d(Cipher cipher, int i, byte[] bArr, int i2, int i3) throws BadPaddingException, IllegalBlockSizeException {
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) i;
        if (i3 == 0) {
            return cipher.doFinal(f(bArr2, this.a));
        }
        byte[] bArrDoFinal = cipher.doFinal(bArr2);
        int i4 = 0;
        while (i3 - i4 > 16) {
            for (int i5 = 0; i5 < 16; i5++) {
                bArrDoFinal[i5] = (byte) (bArrDoFinal[i5] ^ bArr[(i2 + i4) + i5]);
            }
            bArrDoFinal = cipher.doFinal(bArrDoFinal);
            i4 += 16;
        }
        return cipher.doFinal(f(bArrDoFinal, e(Arrays.copyOfRange(bArr, i4 + i2, i2 + i3))));
    }

    private byte[] e(byte[] bArr) {
        if (bArr.length == 16) {
            return f(bArr, this.a);
        }
        byte[] bArrCopyOf = Arrays.copyOf(this.b, 16);
        for (int i = 0; i < bArr.length; i++) {
            bArrCopyOf[i] = (byte) (bArrCopyOf[i] ^ bArr[i]);
        }
        bArrCopyOf[bArr.length] = (byte) (bArrCopyOf[bArr.length] ^ 128);
        return bArrCopyOf;
    }

    private static byte[] f(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    @Override // ir.nasim.InterfaceC3780Ci
    public byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.d;
        if (length > 2147483631 - i) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr3 = new byte[bArr.length + i + 16];
        byte[] bArrA = AbstractC16435lG5.a(i);
        System.arraycopy(bArrA, 0, bArr3, 0, this.d);
        Cipher cipher = (Cipher) f.get();
        cipher.init(1, this.c);
        byte[] bArrD = d(cipher, 0, bArrA, 0, bArrA.length);
        byte[] bArr4 = bArr2 == null ? new byte[0] : bArr2;
        byte[] bArrD2 = d(cipher, 1, bArr4, 0, bArr4.length);
        Cipher cipher2 = (Cipher) g.get();
        cipher2.init(1, this.c, new IvParameterSpec(bArrD));
        cipher2.doFinal(bArr, 0, bArr.length, bArr3, this.d);
        byte[] bArrD3 = d(cipher, 2, bArr3, this.d, bArr.length);
        int length2 = bArr.length + this.d;
        for (int i2 = 0; i2 < 16; i2++) {
            bArr3[length2 + i2] = (byte) ((bArrD2[i2] ^ bArrD[i2]) ^ bArrD3[i2]);
        }
        return bArr3;
    }

    @Override // ir.nasim.InterfaceC3780Ci
    public byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = (bArr.length - this.d) - 16;
        if (length < 0) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        Cipher cipher = (Cipher) f.get();
        cipher.init(1, this.c);
        byte[] bArrD = d(cipher, 0, bArr, 0, this.d);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] bArr3 = bArr2;
        byte[] bArrD2 = d(cipher, 1, bArr3, 0, bArr3.length);
        byte[] bArrD3 = d(cipher, 2, bArr, this.d, length);
        int length2 = bArr.length - 16;
        byte b2 = 0;
        for (int i = 0; i < 16; i++) {
            b2 = (byte) (b2 | (((bArr[length2 + i] ^ bArrD2[i]) ^ bArrD[i]) ^ bArrD3[i]));
        }
        if (b2 != 0) {
            throw new AEADBadTagException("tag mismatch");
        }
        Cipher cipher2 = (Cipher) g.get();
        cipher2.init(1, this.c, new IvParameterSpec(bArrD));
        return cipher2.doFinal(bArr, this.d, length);
    }
}
