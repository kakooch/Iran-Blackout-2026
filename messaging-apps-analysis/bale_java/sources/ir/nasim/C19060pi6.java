package ir.nasim;

import java.security.GeneralSecurityException;

/* renamed from: ir.nasim.pi6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C19060pi6 {
    private static final C19060pi6 a = new C19060pi6();

    private C19060pi6() {
    }

    static C19060pi6 a() {
        return a;
    }

    public static C19060pi6 b(C19060pi6 c19060pi6) throws GeneralSecurityException {
        if (c19060pi6 != null) {
            return c19060pi6;
        }
        throw new GeneralSecurityException("SecretKeyAccess is required");
    }
}
