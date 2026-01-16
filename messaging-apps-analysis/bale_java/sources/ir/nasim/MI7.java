package ir.nasim;

import ir.nasim.IQ0;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes8.dex */
public final class MI7 {
    public static final MI7 a = new MI7();

    private MI7() {
    }

    public static final boolean a(int i, IQ0 iq0) {
        C19482qQ7 c19482qQ7S;
        C23104wM2 c23104wM2;
        AbstractC13042fc3.i(iq0, "chatType");
        if (iq0 instanceof IQ0.b) {
            return true;
        }
        if (iq0 instanceof IQ0.a.b) {
            if (i == AbstractC5969Lp4.f()) {
                return true;
            }
            C14733iO2 c14733iO2A = ((IQ0.a.b) iq0).a();
            if (c14733iO2A != null && FM2.a.j(c14733iO2A).g()) {
                return true;
            }
        } else {
            if (!(iq0 instanceof IQ0.a.C0416a)) {
                throw new NoWhenBranchMatchedException();
            }
            C14733iO2 c14733iO2A2 = ((IQ0.a.C0416a) iq0).a();
            if (c14733iO2A2 != null && FM2.a.j(c14733iO2A2).g()) {
                return true;
            }
            if (c14733iO2A2 != null && (c19482qQ7S = c14733iO2A2.s()) != null && (c23104wM2 = (C23104wM2) c19482qQ7S.b()) != null && c23104wM2.j() && i == AbstractC5969Lp4.f()) {
                return true;
            }
        }
        return false;
    }
}
