package ir.nasim;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* loaded from: classes3.dex */
public final class F93 extends G93 {
    public F93(byte[] bArr) {
        super(bArr);
    }

    @Override // ir.nasim.G93
    public /* bridge */ /* synthetic */ byte[] a(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) {
        return super.a(byteBuffer, bArr, bArr2);
    }

    @Override // ir.nasim.G93
    public /* bridge */ /* synthetic */ void b(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        super.b(byteBuffer, bArr, bArr2, bArr3);
    }

    @Override // ir.nasim.G93
    E93 e(byte[] bArr, int i) {
        return new D93(bArr, i);
    }
}
