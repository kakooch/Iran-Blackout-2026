package ir.nasim;

import android.util.Size;
import ir.nasim.AbstractC23884xg6;

/* renamed from: ir.nasim.qJ2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19414qJ2 {
    public static final C19414qJ2 a = new C19414qJ2();

    private C19414qJ2() {
    }

    private final AbstractC23884xg6.a a(C18823pJ2 c18823pJ2) {
        C24967zW1 c24967zW1F = c18823pJ2.q().f();
        XG2 xg2 = c24967zW1F instanceof XG2 ? (XG2) c24967zW1F : null;
        if (xg2 == null) {
            return null;
        }
        long jI = c18823pJ2.i();
        Long lR = c18823pJ2.r();
        AbstractC13042fc3.h(lR, "getDate(...)");
        long jLongValue = lR.longValue();
        int iS = c18823pJ2.s();
        String strX = xg2.x();
        C23345wl7 c23345wl7T = xg2.t();
        String strV = c23345wl7T != null ? c23345wl7T.v() : null;
        long jE = xg2.E();
        C22694vg2 c22694vg2V = xg2.v();
        byte[] bArrC = c22694vg2V != null ? c22694vg2V.c() : null;
        Size size = new Size(xg2.G(), xg2.F());
        InterfaceC18505om2 interfaceC18505om2Z = xg2.z();
        AbstractC13042fc3.g(interfaceC18505om2Z, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.FileRemoteSource");
        return new AbstractC23884xg6.a(size, jE, jI, jLongValue, iS, strV, strX, bArrC, (C11920dm2) interfaceC18505om2Z);
    }

    public final AbstractC23884xg6.b b(C18823pJ2 c18823pJ2) {
        AbstractC13042fc3.i(c18823pJ2, "input");
        C24967zW1 c24967zW1F = c18823pJ2.q().f();
        C13388g85 c13388g85 = c24967zW1F instanceof C13388g85 ? (C13388g85) c24967zW1F : null;
        if (c13388g85 == null) {
            return null;
        }
        long jI = c18823pJ2.i();
        Long lR = c18823pJ2.r();
        AbstractC13042fc3.h(lR, "getDate(...)");
        long jLongValue = lR.longValue();
        int iS = c18823pJ2.s();
        String strX = c13388g85.x();
        C23345wl7 c23345wl7T = c13388g85.t();
        String strV = c23345wl7T != null ? c23345wl7T.v() : null;
        C22694vg2 c22694vg2V = c13388g85.v();
        byte[] bArrC = c22694vg2V != null ? c22694vg2V.c() : null;
        Size size = new Size(c13388g85.E(), c13388g85.D());
        InterfaceC18505om2 interfaceC18505om2Z = c13388g85.z();
        AbstractC13042fc3.g(interfaceC18505om2Z, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.FileRemoteSource");
        return new AbstractC23884xg6.b(size, jI, jLongValue, iS, strV, strX, bArrC, (C11920dm2) interfaceC18505om2Z);
    }

    public final AbstractC23884xg6.c c(C18823pJ2 c18823pJ2) {
        AbstractC13042fc3.i(c18823pJ2, "input");
        C24967zW1 c24967zW1F = c18823pJ2.q().f();
        GS7 gs7 = c24967zW1F instanceof GS7 ? (GS7) c24967zW1F : null;
        if (gs7 == null) {
            return a(c18823pJ2);
        }
        long jI = c18823pJ2.i();
        Long lR = c18823pJ2.r();
        AbstractC13042fc3.h(lR, "getDate(...)");
        long jLongValue = lR.longValue();
        int iS = c18823pJ2.s();
        String strX = gs7.x();
        C23345wl7 c23345wl7T = gs7.t();
        String strV = c23345wl7T != null ? c23345wl7T.v() : null;
        long jG = gs7.G();
        C22694vg2 c22694vg2V = gs7.v();
        byte[] bArrC = c22694vg2V != null ? c22694vg2V.c() : null;
        Size size = new Size(gs7.I(), gs7.H());
        InterfaceC18505om2 interfaceC18505om2Z = gs7.z();
        AbstractC13042fc3.g(interfaceC18505om2Z, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.FileRemoteSource");
        return new AbstractC23884xg6.c(size, jG, jI, jLongValue, iS, strV, strX, bArrC, (C11920dm2) interfaceC18505om2Z);
    }
}
