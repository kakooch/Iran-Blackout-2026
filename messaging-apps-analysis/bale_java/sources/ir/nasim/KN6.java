package ir.nasim;

import java.util.List;

/* loaded from: classes5.dex */
public abstract class KN6 {
    private static final PO6 a = new QO6(C7183Qq.p());
    private static final PO6 b = new W34();
    private static final S82 c = new T82();
    private static final InterfaceC3585Bm2 d = new C4053Dm2();

    public static void a(List list) {
        a.d(list);
    }

    public static void b(String str) {
        a.f(str);
    }

    public static InterfaceC3346Am2 c(InterfaceC3346Am2 interfaceC3346Am2, long j, String str) {
        return d.c(interfaceC3346Am2, j, str);
    }

    public static InterfaceC9031Ye5 d(DB3 db3, boolean z, String str) {
        return c.b(db3, z, str);
    }

    public static AbstractC9119Yo3 e(C86 c86, String str, InterfaceC17311ml0 interfaceC17311ml0, InterfaceC15345jQ7 interfaceC15345jQ7) {
        return a.h(c86, str, interfaceC17311ml0, interfaceC15345jQ7);
    }

    public static AbstractC9119Yo3 f(C86 c86, String str, InterfaceC17311ml0 interfaceC17311ml0, InterfaceC15345jQ7 interfaceC15345jQ7, boolean z) {
        return z ? a.h(c86, str, interfaceC17311ml0, interfaceC15345jQ7) : b.h(c86, str, interfaceC17311ml0, interfaceC15345jQ7);
    }

    public static AbstractC9119Yo3 g(String str, InterfaceC17311ml0 interfaceC17311ml0) {
        return h(str, interfaceC17311ml0, null);
    }

    public static AbstractC9119Yo3 h(String str, InterfaceC17311ml0 interfaceC17311ml0, InterfaceC15345jQ7 interfaceC15345jQ7) {
        return f(C86.a, str, interfaceC17311ml0, interfaceC15345jQ7, true);
    }

    public static VL3 i(String str, InterfaceC20073rQ7 interfaceC20073rQ7, InterfaceC17311ml0 interfaceC17311ml0) {
        return new VL3(g(str, interfaceC17311ml0), interfaceC20073rQ7);
    }

    public static VL3 j(String str, InterfaceC20073rQ7 interfaceC20073rQ7, InterfaceC17311ml0 interfaceC17311ml0, InterfaceC15345jQ7 interfaceC15345jQ7, boolean z) {
        return new VL3(f(C86.a, str, interfaceC17311ml0, interfaceC15345jQ7, z), interfaceC20073rQ7);
    }

    public static VL3 k(String str, InterfaceC20073rQ7 interfaceC20073rQ7, InterfaceC17311ml0 interfaceC17311ml0, boolean z) {
        return new VL3(f(C86.a, str, interfaceC17311ml0, null, z), interfaceC20073rQ7);
    }

    public static DB3 l(String str, InterfaceC17311ml0 interfaceC17311ml0) {
        return c.c(a.g(str), interfaceC17311ml0);
    }

    public static InterfaceC9031Ye5 m(DB3 db3, boolean z, String str) {
        return c.a(db3, z, str);
    }

    public static DB3 n(String str, InterfaceC17311ml0 interfaceC17311ml0) {
        return c.d(b.g(str), interfaceC17311ml0);
    }

    public static InterfaceC3570Bk5 o() {
        return a.b();
    }

    public static InterfaceC3346Am2 p() {
        return d.d();
    }

    public static InterfaceC3346Am2 q(String str) {
        return d.a(str);
    }

    public static InterfaceC3346Am2 r(String str) {
        return d.b(str);
    }

    public static PO6 s() {
        return a;
    }

    public static void t() {
        a.a();
        ((InterfaceC9291Zh4) C92.a(C5721Ko.b, InterfaceC9291Zh4.class)).k0().f(C5721Ko.b);
    }
}
