package ir.nasim;

/* renamed from: ir.nasim.dk1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C11899dk1 extends AbstractC24641yx5 {
    private C20408rx5[] a;

    public C11899dk1(C9207Yy1 c9207Yy1) {
        super(c9207Yy1);
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected byte d() {
        return (byte) 10;
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected void e(C9207Yy1 c9207Yy1) {
        int iK = (int) c9207Yy1.k();
        this.a = new C20408rx5[iK];
        for (int i = 0; i < iK; i++) {
            this.a[i] = new C20408rx5(c9207Yy1);
        }
    }

    @Override // ir.nasim.AbstractC24641yx5
    protected void f(C12658ez1 c12658ez1) {
        C20408rx5[] c20408rx5Arr = this.a;
        if (c20408rx5Arr == null || c20408rx5Arr.length <= 0) {
            c12658ez1.n(0L);
            return;
        }
        c12658ez1.n(c20408rx5Arr.length);
        for (C20408rx5 c20408rx5 : this.a) {
            c20408rx5.c(c12658ez1);
        }
    }

    public C20408rx5[] g() {
        return this.a;
    }

    public String toString() {
        return "Conatiner[" + this.a.length + " items]";
    }

    public C11899dk1(C20408rx5[] c20408rx5Arr) {
        this.a = c20408rx5Arr;
    }
}
