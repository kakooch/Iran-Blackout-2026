package ir.nasim;

import java.security.cert.X509Certificate;

/* renamed from: ir.nasim.ky5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC16262ky5 extends AbstractC17827nd5 {
    protected AbstractC16262ky5(String str) {
        super(str);
    }

    @Override // ir.nasim.AbstractC17827nd5
    public boolean b(X509Certificate x509Certificate) {
        return c(x509Certificate.getPublicKey().getEncoded());
    }

    protected abstract boolean c(byte[] bArr);
}
