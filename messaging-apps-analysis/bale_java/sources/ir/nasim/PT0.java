package ir.nasim;

import ir.nasim.AbstractC5747Kq7;
import java.security.GeneralSecurityException;

/* loaded from: classes3.dex */
public final class PT0 implements RT0 {
    private static final AbstractC5747Kq7.b b = AbstractC5747Kq7.b.a;
    private final C4965Hi a;

    public PT0(C4965Hi c4965Hi) throws GeneralSecurityException {
        if (!b.a()) {
            throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
        }
        this.a = c4965Hi;
    }
}
