package ir.nasim;

import ir.nasim.AbstractC14699iL4;
import ir.nasim.C20025rL4;

/* renamed from: ir.nasim.tp2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C21604tp2 extends AbstractC20634sL4 {
    private final C20025rL4 a = new C20025rL4();
    private final C20025rL4 b = new C20025rL4();

    public final void a() {
        this.b.a();
        this.a.a();
    }

    public final void b(SA2 sa2, int i, C6669Om c6669Om) {
        C20025rL4 c20025rL4 = this.a;
        AbstractC14699iL4.o oVar = AbstractC14699iL4.o.c;
        c20025rL4.j(oVar);
        C20025rL4 c20025rL4A = C20025rL4.b.a(c20025rL4);
        C20025rL4.b.b(c20025rL4A, AbstractC14699iL4.t.a(0), sa2);
        c20025rL4A.c[c20025rL4A.d - c20025rL4A.a[c20025rL4A.b - 1].b()] = i;
        C20025rL4.b.b(c20025rL4A, AbstractC14699iL4.t.a(1), c6669Om);
        c20025rL4.c(oVar);
        C20025rL4 c20025rL42 = this.b;
        AbstractC14699iL4.u uVar = AbstractC14699iL4.u.c;
        c20025rL42.j(uVar);
        C20025rL4 c20025rL4A2 = C20025rL4.b.a(c20025rL42);
        c20025rL4A2.c[c20025rL4A2.d - c20025rL4A2.a[c20025rL4A2.b - 1].b()] = i;
        C20025rL4.b.b(c20025rL4A2, AbstractC14699iL4.t.a(0), c6669Om);
        c20025rL42.c(uVar);
    }

    public final void c() {
        if (!this.b.g()) {
            AbstractC5138Ib1.s("Cannot end node insertion, there are no pending operations that can be realized.");
        }
        this.b.h(this.a);
    }

    public final void d(InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
        if (!this.b.f()) {
            AbstractC5138Ib1.s("FixupList has pending fixup operations that were not realized. Were there mismatched insertNode() and endNodeInsert() calls?");
        }
        this.a.d(interfaceC15247jG, c24216yE6, xm5);
    }

    public final boolean e() {
        return this.a.f();
    }

    public final void f(Object obj, InterfaceC14603iB2 interfaceC14603iB2) {
        C20025rL4 c20025rL4 = this.a;
        AbstractC14699iL4.F f = AbstractC14699iL4.F.c;
        c20025rL4.j(f);
        C20025rL4 c20025rL4A = C20025rL4.b.a(c20025rL4);
        C20025rL4.b.b(c20025rL4A, AbstractC14699iL4.t.a(0), obj);
        int iA = AbstractC14699iL4.t.a(1);
        AbstractC13042fc3.g(interfaceC14603iB2, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Unit>");
        C20025rL4.b.b(c20025rL4A, iA, (InterfaceC14603iB2) AbstractC19810qy7.g(interfaceC14603iB2, 2));
        c20025rL4.c(f);
    }
}
