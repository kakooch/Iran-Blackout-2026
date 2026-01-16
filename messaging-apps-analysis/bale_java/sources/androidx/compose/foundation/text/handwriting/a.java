package androidx.compose.foundation.text.handwriting;

import androidx.compose.ui.e;
import ir.nasim.AbstractC15625jt7;
import ir.nasim.AbstractC3360An7;
import ir.nasim.AbstractC5421Jg5;
import ir.nasim.C17784nZ1;
import ir.nasim.C20757sZ1;
import ir.nasim.NZ6;
import ir.nasim.SA2;

/* loaded from: classes.dex */
public abstract class a {
    private static final float a;
    private static final float b;
    private static final C20757sZ1 c;

    static {
        float fQ = C17784nZ1.q(40);
        a = fQ;
        float fQ2 = C17784nZ1.q(10);
        b = fQ2;
        c = AbstractC15625jt7.a(fQ2, fQ, fQ2, fQ);
    }

    public static final C20757sZ1 a() {
        return c;
    }

    public static final e b(e eVar, boolean z, boolean z2, SA2 sa2) {
        if (!z || !NZ6.a()) {
            return eVar;
        }
        if (z2) {
            eVar = AbstractC5421Jg5.c(eVar, AbstractC3360An7.a(), false, c);
        }
        return eVar.i(new StylusHandwritingElement(sa2));
    }
}
