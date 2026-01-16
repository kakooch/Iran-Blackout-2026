package ir.nasim;

/* renamed from: ir.nasim.zO5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC24899zO5 {
    static int F(int i) {
        return i & 7;
    }

    static int a(int i) {
        return x(i, 0, 0);
    }

    static int k(int i) {
        return i & 384;
    }

    static int n(int i, int i2, int i3, int i4, int i5) {
        return i | i2 | i3 | i4 | i5;
    }

    static int o(int i) {
        return i & 32;
    }

    static int p(int i) {
        return i & 24;
    }

    static int v(int i) {
        return i & 64;
    }

    static int x(int i, int i2, int i3) {
        return n(i, i2, i3, 0, 128);
    }

    int A();

    int b(com.google.android.exoplayer2.X x);

    int g();

    String getName();
}
