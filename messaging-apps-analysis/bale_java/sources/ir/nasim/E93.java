package ir.nasim;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* loaded from: classes3.dex */
abstract class E93 {
    int[] a;
    private final int b;

    public E93(byte[] bArr, int i) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.a = AbstractC10841cI0.e(bArr);
        this.b = i;
    }

    private void f(byte[] bArr, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws GeneralSecurityException {
        if (bArr.length != e()) {
            throw new GeneralSecurityException("The nonce length (in bytes) must be " + e());
        }
        int iRemaining = byteBuffer2.remaining();
        int i = iRemaining / 64;
        int i2 = i + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            ByteBuffer byteBufferA = a(bArr, this.b + i3);
            if (i3 == i) {
                AbstractC8841Xo0.c(byteBuffer, byteBuffer2, byteBufferA, iRemaining % 64);
            } else {
                AbstractC8841Xo0.c(byteBuffer, byteBuffer2, byteBufferA, 64);
            }
        }
    }

    ByteBuffer a(byte[] bArr, int i) {
        int[] iArrB = b(AbstractC10841cI0.e(bArr), i);
        int[] iArr = (int[]) iArrB.clone();
        AbstractC10841cI0.d(iArr);
        for (int i2 = 0; i2 < iArrB.length; i2++) {
            iArrB[i2] = iArrB[i2] + iArr[i2];
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.asIntBuffer().put(iArrB, 0, 16);
        return byteBufferOrder;
    }

    abstract int[] b(int[] iArr, int i);

    public byte[] c(byte[] bArr, ByteBuffer byteBuffer) throws GeneralSecurityException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
        f(bArr, byteBufferAllocate, byteBuffer);
        return byteBufferAllocate.array();
    }

    public void d(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (byteBuffer.remaining() < bArr2.length) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        f(bArr, byteBuffer, ByteBuffer.wrap(bArr2));
    }

    abstract int e();
}
