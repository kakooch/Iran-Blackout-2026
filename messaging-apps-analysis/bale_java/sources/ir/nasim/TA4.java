package ir.nasim;

/* loaded from: classes8.dex */
public abstract class TA4 {
    private TA4 a = null;
    private TA4 b = null;
    private TA4 c = null;
    private TA4 d = null;
    private TA4 e = null;

    public abstract void a(NY7 ny7);

    public void b(TA4 ta4) {
        ta4.l();
        ta4.j(this);
        TA4 ta42 = this.c;
        if (ta42 == null) {
            this.b = ta4;
            this.c = ta4;
        } else {
            ta42.e = ta4;
            ta4.d = ta42;
            this.c = ta4;
        }
    }

    public TA4 c() {
        return this.b;
    }

    public TA4 d() {
        return this.c;
    }

    public TA4 e() {
        return this.e;
    }

    public TA4 f() {
        return this.a;
    }

    public TA4 g() {
        return this.d;
    }

    public void h(TA4 ta4) {
        ta4.l();
        TA4 ta42 = this.e;
        ta4.e = ta42;
        if (ta42 != null) {
            ta42.d = ta4;
        }
        ta4.d = this;
        this.e = ta4;
        TA4 ta43 = this.a;
        ta4.a = ta43;
        if (ta4.e == null) {
            ta43.c = ta4;
        }
    }

    public void i(TA4 ta4) {
        ta4.l();
        TA4 ta42 = this.d;
        ta4.d = ta42;
        if (ta42 != null) {
            ta42.e = ta4;
        }
        ta4.e = this;
        this.d = ta4;
        TA4 ta43 = this.a;
        ta4.a = ta43;
        if (ta4.d == null) {
            ta43.b = ta4;
        }
    }

    protected void j(TA4 ta4) {
        this.a = ta4;
    }

    protected String k() {
        return "";
    }

    public void l() {
        TA4 ta4 = this.d;
        if (ta4 != null) {
            ta4.e = this.e;
        } else {
            TA4 ta42 = this.a;
            if (ta42 != null) {
                ta42.b = this.e;
            }
        }
        TA4 ta43 = this.e;
        if (ta43 != null) {
            ta43.d = ta4;
        } else {
            TA4 ta44 = this.a;
            if (ta44 != null) {
                ta44.c = ta4;
            }
        }
        this.a = null;
        this.e = null;
        this.d = null;
    }

    public String toString() {
        return getClass().getSimpleName() + "{" + k() + "}";
    }
}
