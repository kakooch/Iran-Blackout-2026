package ir.nasim;

/* renamed from: ir.nasim.Om, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C6669Om {
    private int a;

    public C6669Om(int i) {
        this.a = i;
    }

    public final int a() {
        return this.a;
    }

    public final boolean b() {
        return this.a != Integer.MIN_VALUE;
    }

    public final void c(int i) {
        this.a = i;
    }

    public final int d(C21850uE6 c21850uE6) {
        return c21850uE6.t(this);
    }

    public final int e(C24216yE6 c24216yE6) {
        return c24216yE6.E(this);
    }

    public String toString() {
        return super.toString() + "{ location = " + this.a + " }";
    }
}
