package ir.nasim;

import ir.nasim.EX1;

/* renamed from: ir.nasim.sM6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C20645sM6 implements InterfaceC14123hO3 {
    public static final C20645sM6 a = new C20645sM6();

    private C20645sM6() {
    }

    @Override // ir.nasim.InterfaceC14123hO3
    public /* bridge */ /* synthetic */ Object a(Object obj) {
        return b(((Number) obj).intValue());
    }

    public EX1.c b(int i) {
        return i == 403 ? EX1.c.e.b : i == 404 ? EX1.c.b.b : i == 416 ? EX1.c.f.b : i == 429 ? EX1.c.g.b : i == 451 ? EX1.c.a.b : (500 > i || i >= 600) ? new EX1.c.j(i) : EX1.c.C0342c.b;
    }
}
