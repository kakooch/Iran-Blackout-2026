package ir.nasim;

import java.security.cert.X509Certificate;

/* renamed from: ir.nasim.jo8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C15576jo8 extends Ro8 {
    private final byte[] b;

    public C15576jo8(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.b = bArr;
    }

    @Override // java.security.cert.Certificate
    public final byte[] getEncoded() {
        return this.b;
    }
}
