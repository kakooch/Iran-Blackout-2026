package ir.nasim;

/* renamed from: ir.nasim.La3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C5833La3 {
    private static final C5833La3 b = new C5833La3(C5599Ka3.f);
    private final C5599Ka3 a;

    private C5833La3(C5599Ka3 c5599Ka3) {
        this.a = c5599Ka3;
    }

    public static C5833La3 a() {
        return b;
    }

    private C5833La3 d(C5599Ka3 c5599Ka3) {
        return c5599Ka3 == this.a ? this : new C5833La3(c5599Ka3);
    }

    public Object b(int i) {
        return this.a.a(i);
    }

    public C5833La3 c(int i, Object obj) {
        return d(this.a.b(i, obj));
    }
}
