package ir.nasim;

/* renamed from: ir.nasim.r02, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC19824r02 {
    static /* synthetic */ void e(InterfaceC19824r02 interfaceC19824r02, V05 v05, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipPath-mtrdD-E");
        }
        if ((i2 & 2) != 0) {
            i = GV0.a.b();
        }
        interfaceC19824r02.d(v05, i);
    }

    static /* synthetic */ void i(InterfaceC19824r02 interfaceC19824r02, float f, float f2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: translate");
        }
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        interfaceC19824r02.c(f, f2);
    }

    void a(float[] fArr);

    void b(float f, float f2, float f3, float f4, int i);

    void c(float f, float f2);

    void d(V05 v05, int i);

    void f(float f, float f2, long j);

    void g(float f, long j);

    void h(float f, float f2, float f3, float f4);
}
