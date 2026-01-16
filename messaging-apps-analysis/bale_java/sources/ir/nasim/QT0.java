package ir.nasim;

import ir.nasim.AbstractC5747Kq7;
import java.security.GeneralSecurityException;

/* loaded from: classes3.dex */
public final class QT0 implements RT0 {
    private static final AbstractC5747Kq7.b b = AbstractC5747Kq7.b.b;
    private final C20140rY2 a;

    public QT0(C20140rY2 c20140rY2) throws GeneralSecurityException {
        if (!b.a()) {
            throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
        }
        this.a = c20140rY2;
    }
}
