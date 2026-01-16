package ir.nasim;

/* loaded from: classes2.dex */
public interface UE0 {
    static /* synthetic */ void g(UE0 ue0, float f, float f2, float f3, float f4, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-N_I0leg");
        }
        if ((i2 & 16) != 0) {
            i = GV0.a.b();
        }
        ue0.b(f, f2, f3, f4, i);
    }

    static /* synthetic */ void m(UE0 ue0, V05 v05, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipPath-mtrdD-E");
        }
        if ((i2 & 2) != 0) {
            i = GV0.a.b();
        }
        ue0.d(v05, i);
    }

    static /* synthetic */ void s(UE0 ue0, CK5 ck5, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-mtrdD-E");
        }
        if ((i2 & 2) != 0) {
            i = GV0.a.b();
        }
        ue0.q(ck5, i);
    }

    void b(float f, float f2, float f3, float f4, int i);

    void c(float f, float f2);

    void d(V05 v05, int i);

    void e(float f, float f2);

    void f(V05 v05, InterfaceC12969fU4 interfaceC12969fU4);

    void h(Y03 y03, long j, long j2, long j3, long j4, InterfaceC12969fU4 interfaceC12969fU4);

    void i();

    void j(CK5 ck5, InterfaceC12969fU4 interfaceC12969fU4);

    void k();

    void l(float f);

    void n();

    void o(float f, float f2, float f3, float f4, float f5, float f6, boolean z, InterfaceC12969fU4 interfaceC12969fU4);

    void p();

    default void q(CK5 ck5, int i) {
        b(ck5.i(), ck5.l(), ck5.j(), ck5.e(), i);
    }

    void r(float[] fArr);

    void t(float f, float f2, float f3, float f4, InterfaceC12969fU4 interfaceC12969fU4);

    void u(long j, long j2, InterfaceC12969fU4 interfaceC12969fU4);

    void v(float f, float f2, float f3, float f4, float f5, float f6, InterfaceC12969fU4 interfaceC12969fU4);

    void w(long j, float f, InterfaceC12969fU4 interfaceC12969fU4);

    void x(Y03 y03, long j, InterfaceC12969fU4 interfaceC12969fU4);
}
