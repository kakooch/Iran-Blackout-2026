package ir.nasim;

/* renamed from: ir.nasim.sz5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C21029sz5 {
    private EnumC12474eg4 a;
    private X92 b;
    private YR7 c;
    private int d = -1;
    private C5722Ko0 e;

    public static boolean b(int i) {
        return i >= 0 && i < 8;
    }

    public C5722Ko0 a() {
        return this.e;
    }

    public void c(X92 x92) {
        this.b = x92;
    }

    public void d(int i) {
        this.d = i;
    }

    public void e(C5722Ko0 c5722Ko0) {
        this.e = c5722Ko0;
    }

    public void f(EnumC12474eg4 enumC12474eg4) {
        this.a = enumC12474eg4;
    }

    public void g(YR7 yr7) {
        this.c = yr7;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.a);
        sb.append("\n ecLevel: ");
        sb.append(this.b);
        sb.append("\n version: ");
        sb.append(this.c);
        sb.append("\n maskPattern: ");
        sb.append(this.d);
        if (this.e == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.e);
        }
        sb.append(">>\n");
        return sb.toString();
    }
}
