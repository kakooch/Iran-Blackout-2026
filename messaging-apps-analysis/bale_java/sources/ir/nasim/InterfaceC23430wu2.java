package ir.nasim;

/* renamed from: ir.nasim.wu2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC23430wu2 {
    default long T(float f) {
        C22244uu2 c22244uu2 = C22244uu2.a;
        if (!c22244uu2.f(t1())) {
            return AbstractC13784go7.f(f / t1());
        }
        InterfaceC21654tu2 interfaceC21654tu2B = c22244uu2.b(t1());
        return AbstractC13784go7.f(interfaceC21654tu2B != null ? interfaceC21654tu2B.a(f) : f / t1());
    }

    default float Y(long j) {
        if (!C14377ho7.g(C13193fo7.g(j), C14377ho7.b.b())) {
            O73.b("Only Sp can convert to Px");
        }
        C22244uu2 c22244uu2 = C22244uu2.a;
        if (!c22244uu2.f(t1())) {
            return C17784nZ1.q(C13193fo7.h(j) * t1());
        }
        InterfaceC21654tu2 interfaceC21654tu2B = c22244uu2.b(t1());
        float fH = C13193fo7.h(j);
        return C17784nZ1.q(interfaceC21654tu2B == null ? fH * t1() : interfaceC21654tu2B.b(fH));
    }

    float t1();
}
