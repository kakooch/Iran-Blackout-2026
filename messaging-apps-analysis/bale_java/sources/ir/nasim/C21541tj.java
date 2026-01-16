package ir.nasim;

import ir.nasim.AbstractC5747Kq7;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: ir.nasim.tj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C21541tj implements InterfaceC3780Ci {
    public static final AbstractC5747Kq7.b c = AbstractC5747Kq7.b.b;
    private final C93 a;
    private final byte[] b;

    private C21541tj(byte[] bArr, C8575Wo0 c8575Wo0) throws GeneralSecurityException {
        if (!c.a()) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        this.a = new C93(bArr, true);
        this.b = c8575Wo0.d();
    }

    @Override // ir.nasim.InterfaceC3780Ci
    public byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArrA = AbstractC16435lG5.a(12);
        byte[] bArr3 = this.b;
        return bArr3.length == 0 ? this.a.b(bArrA, bArr, bArr2) : AbstractC8841Xo0.a(bArr3, this.a.b(bArrA, bArr, bArr2));
    }

    @Override // ir.nasim.InterfaceC3780Ci
    public byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.b;
        if (bArr3.length == 0) {
            return this.a.a(Arrays.copyOf(bArr, 12), bArr, bArr2);
        }
        if (!AbstractC10893cN7.e(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, this.b.length, bArr.length);
        return this.a.a(Arrays.copyOf(bArrCopyOfRange, 12), bArrCopyOfRange, bArr2);
    }

    public C21541tj(byte[] bArr) {
        this(bArr, C8575Wo0.a(new byte[0]));
    }
}
