package ir.nasim;

import java.security.cert.X509Certificate;

/* loaded from: classes3.dex */
public abstract class PH0 extends AbstractC17827nd5 {
    protected PH0(String str) {
        super(str);
    }

    @Override // ir.nasim.AbstractC17827nd5
    public boolean b(X509Certificate x509Certificate) {
        return c(x509Certificate.getEncoded());
    }

    protected abstract boolean c(byte[] bArr);
}
