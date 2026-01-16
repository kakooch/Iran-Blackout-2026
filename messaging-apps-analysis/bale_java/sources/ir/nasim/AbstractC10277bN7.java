package ir.nasim;

import ir.nasim.C20317ro3;
import ir.nasim.C5032Hp3;
import ir.nasim.C5500Jp3;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.Iterator;

/* renamed from: ir.nasim.bN7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC10277bN7 {
    public static final Charset a = Charset.forName("UTF-8");

    public static C5500Jp3.c a(C5032Hp3.c cVar) {
        return (C5500Jp3.c) C5500Jp3.c.X().s(cVar.W().X()).r(cVar.Z()).q(cVar.Y()).p(cVar.X()).e();
    }

    public static C5500Jp3 b(C5032Hp3 c5032Hp3) {
        C5500Jp3.b bVarQ = C5500Jp3.X().q(c5032Hp3.Z());
        Iterator it = c5032Hp3.Y().iterator();
        while (it.hasNext()) {
            bVarQ.p(a((C5032Hp3.c) it.next()));
        }
        return (C5500Jp3) bVarQ.e();
    }

    public static void c(C5032Hp3.c cVar) throws GeneralSecurityException {
        if (!cVar.a0()) {
            throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(cVar.X())));
        }
        if (cVar.Y() == FN4.UNKNOWN_PREFIX) {
            throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(cVar.X())));
        }
        if (cVar.Z() == EnumC6192Mo3.UNKNOWN_STATUS) {
            throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(cVar.X())));
        }
    }

    public static void d(C5032Hp3 c5032Hp3) throws GeneralSecurityException {
        int iZ = c5032Hp3.Z();
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        for (C5032Hp3.c cVar : c5032Hp3.Y()) {
            if (cVar.Z() == EnumC6192Mo3.ENABLED) {
                c(cVar);
                if (cVar.X() == iZ) {
                    if (z) {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                    z = true;
                }
                if (cVar.W().W() != C20317ro3.c.ASYMMETRIC_PUBLIC) {
                    z2 = false;
                }
                i++;
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
        if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
