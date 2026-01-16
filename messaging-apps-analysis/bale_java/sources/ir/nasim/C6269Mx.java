package ir.nasim;

import ir.nasim.InterfaceC21839uD4;

/* renamed from: ir.nasim.Mx, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6269Mx implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public InterfaceC21839uD4 a(C6035Lx c6035Lx) {
        AbstractC13042fc3.i(c6035Lx, "input");
        AbstractC4383Ex abstractC4383ExW = c6035Lx.w();
        if (abstractC4383ExW instanceof C5100Hx) {
            return new InterfaceC21839uD4.d(C9590aD4.a.c(c6035Lx));
        }
        if (abstractC4383ExW instanceof C5568Jx) {
            return InterfaceC21839uD4.e.a;
        }
        if (abstractC4383ExW instanceof C5802Kx) {
            return InterfaceC21839uD4.f.a;
        }
        if (abstractC4383ExW instanceof C4866Gx) {
            return InterfaceC21839uD4.c.a;
        }
        if (!(abstractC4383ExW instanceof C4617Fx)) {
            ZC zcU = c6035Lx.u();
            return new InterfaceC21839uD4.b(zcU != null ? zcU.z() : null);
        }
        String name = c6035Lx.getName();
        AbstractC13042fc3.h(name, "getName(...)");
        return new InterfaceC21839uD4.a(name);
    }
}
