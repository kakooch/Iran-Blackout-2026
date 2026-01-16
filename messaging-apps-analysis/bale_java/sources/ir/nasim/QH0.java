package ir.nasim;

import java.security.cert.X509Certificate;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class QH0 extends PH0 {
    private final X509Certificate d;

    protected QH0(String str) {
        super(str);
        if (AbstractC17827nd5.c == null) {
            throw new IllegalStateException("Can not create sha256 pins");
        }
        this.d = Ub8.a(this.a);
    }

    @Override // ir.nasim.PH0
    protected boolean c(byte[] bArr) {
        return Arrays.equals(this.a, bArr);
    }
}
