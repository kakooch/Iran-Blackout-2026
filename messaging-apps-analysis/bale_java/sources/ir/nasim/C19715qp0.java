package ir.nasim;

/* renamed from: ir.nasim.qp0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C19715qp0 {
    private final C13183fn7 a;

    public C19715qp0(C13183fn7 c13183fn7) {
        this.a = c13183fn7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C19715qp0)) {
            return false;
        }
        C13183fn7 c13183fn7 = this.a;
        C19715qp0 c19715qp0 = (C19715qp0) obj;
        return AbstractC13042fc3.d(c13183fn7.j(), c19715qp0.a.j()) && c13183fn7.i().G(c19715qp0.a.i()) && AbstractC13042fc3.d(c13183fn7.g(), c19715qp0.a.g()) && c13183fn7.e() == c19715qp0.a.e() && c13183fn7.h() == c19715qp0.a.h() && AbstractC23365wn7.g(c13183fn7.f(), c19715qp0.a.f()) && AbstractC13042fc3.d(c13183fn7.b(), c19715qp0.a.b()) && c13183fn7.d() == c19715qp0.a.d() && c13183fn7.c() == c19715qp0.a.c() && C17833ne1.f(c13183fn7.a(), c19715qp0.a.a());
    }

    public int hashCode() {
        C13183fn7 c13183fn7 = this.a;
        return (((((((((((((((((c13183fn7.j().hashCode() * 31) + c13183fn7.i().H()) * 31) + c13183fn7.g().hashCode()) * 31) + c13183fn7.e()) * 31) + Boolean.hashCode(c13183fn7.h())) * 31) + AbstractC23365wn7.h(c13183fn7.f())) * 31) + c13183fn7.b().hashCode()) * 31) + c13183fn7.d().hashCode()) * 31) + c13183fn7.c().hashCode()) * 31) + C17833ne1.o(c13183fn7.a());
    }
}
