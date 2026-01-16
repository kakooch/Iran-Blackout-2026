package ir.nasim;

/* renamed from: ir.nasim.Ae2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C3274Ae2 {
    private final Object a = new Object();
    private final C19349qC0 b;
    private int c;

    C3274Ae2(C19349qC0 c19349qC0, int i) {
        this.b = c19349qC0;
        this.c = i;
    }

    public int a() {
        int i;
        synchronized (this.a) {
            i = this.c;
        }
        return i;
    }

    void b(int i) {
        synchronized (this.a) {
            this.c = i;
        }
    }
}
