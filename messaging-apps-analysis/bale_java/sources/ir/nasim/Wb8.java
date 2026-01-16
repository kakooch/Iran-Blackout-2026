package ir.nasim;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class Wb8 implements InterfaceC3780Ci {
    private final I93 a;

    public Wb8(byte[] bArr) {
        this.a = new I93(bArr);
    }

    @Override // ir.nasim.InterfaceC3780Ci
    public byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length + 40);
        byte[] bArrA = AbstractC16435lG5.a(24);
        byteBufferAllocate.put(bArrA);
        this.a.b(byteBufferAllocate, bArrA, bArr, bArr2);
        return byteBufferAllocate.array();
    }

    @Override // ir.nasim.InterfaceC3780Ci
    public byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length < 40) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, 24);
        return this.a.a(ByteBuffer.wrap(bArr, 24, bArr.length - 24), bArrCopyOf, bArr2);
    }
}
