package ir.nasim;

/* loaded from: classes2.dex */
public final class FS0 {
    private C21226tK2 a;
    private C21226tK2 b;
    private C7620Sm4 c;
    private C7620Sm4 d;
    private boolean e;

    public final boolean i(C21226tK2 c21226tK2) {
        if (!this.e) {
            L73.a("Only add dependencies during a tracking");
        }
        C7620Sm4 c7620Sm4 = this.c;
        if (c7620Sm4 != null) {
            AbstractC13042fc3.f(c7620Sm4);
            c7620Sm4.h(c21226tK2);
        } else if (this.a != null) {
            C7620Sm4 c7620Sm4A = AbstractC23254wc6.a();
            C21226tK2 c21226tK22 = this.a;
            AbstractC13042fc3.f(c21226tK22);
            c7620Sm4A.h(c21226tK22);
            c7620Sm4A.h(c21226tK2);
            this.c = c7620Sm4A;
            this.a = null;
        } else {
            this.a = c21226tK2;
        }
        C7620Sm4 c7620Sm42 = this.d;
        if (c7620Sm42 != null) {
            AbstractC13042fc3.f(c7620Sm42);
            return !c7620Sm42.y(c21226tK2);
        }
        if (this.b != c21226tK2) {
            return true;
        }
        this.b = null;
        return false;
    }
}
