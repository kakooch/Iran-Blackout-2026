package ir.nasim;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: ir.nasim.f82, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C12749f82 implements InterfaceC3780Ci {
    private final Y53 a;
    private final WL3 b;
    private final int c;

    public C12749f82(Y53 y53, WL3 wl3, int i) {
        this.a = y53;
        this.b = wl3;
        this.c = i;
    }

    @Override // ir.nasim.InterfaceC3780Ci
    public byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArrEncrypt = this.a.encrypt(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        return AbstractC8841Xo0.a(bArrEncrypt, this.b.b(AbstractC8841Xo0.a(bArr2, bArrEncrypt, Arrays.copyOf(ByteBuffer.allocate(8).putLong(bArr2.length * 8).array(), 8))));
    }

    @Override // ir.nasim.InterfaceC3780Ci
    public byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.c;
        if (length < i) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length - i);
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, bArr.length - this.c, bArr.length);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        this.b.a(bArrCopyOfRange2, AbstractC8841Xo0.a(bArr2, bArrCopyOfRange, Arrays.copyOf(ByteBuffer.allocate(8).putLong(bArr2.length * 8).array(), 8)));
        return this.a.a(bArrCopyOfRange);
    }
}
