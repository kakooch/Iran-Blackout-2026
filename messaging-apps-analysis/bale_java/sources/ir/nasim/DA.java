package ir.nasim;

/* loaded from: classes4.dex */
public class DA extends AbstractC17902nl0 {
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private Boolean k;
    private Boolean l;
    private Boolean m;
    private Boolean n;
    private Boolean o;
    private Boolean p;
    private Boolean q;
    private Boolean r;
    private Boolean s;
    private Boolean t;

    public DA(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
        this.e = z5;
        this.f = z6;
        this.g = z7;
        this.h = z8;
        this.i = z9;
        this.j = z10;
        this.k = bool;
        this.l = bool2;
        this.m = bool3;
        this.n = bool4;
        this.o = bool5;
        this.p = bool6;
        this.q = bool7;
        this.r = bool8;
        this.s = bool9;
        this.t = bool10;
    }

    public boolean C() {
        return this.c;
    }

    public Boolean D() {
        return this.t;
    }

    public boolean E() {
        return this.d;
    }

    public Boolean F() {
        return this.m;
    }

    public boolean G() {
        return this.i;
    }

    public boolean H() {
        return this.a;
    }

    public Boolean J() {
        return this.r;
    }

    public Boolean K() {
        return this.l;
    }

    public Boolean L() {
        return this.o;
    }

    public Boolean M() {
        return this.q;
    }

    public Boolean N() {
        return this.k;
    }

    public boolean O() {
        return this.h;
    }

    public Boolean P() {
        return this.p;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.b(1);
        this.b = c19084pl0.b(2);
        this.c = c19084pl0.b(3);
        this.d = c19084pl0.b(4);
        this.e = c19084pl0.b(5);
        this.f = c19084pl0.b(6);
        this.g = c19084pl0.b(7);
        this.h = c19084pl0.b(8);
        this.i = c19084pl0.b(9);
        this.j = c19084pl0.b(10);
        this.k = Boolean.valueOf(c19084pl0.u(11));
        this.l = Boolean.valueOf(c19084pl0.u(12));
        this.m = Boolean.valueOf(c19084pl0.u(13));
        this.n = Boolean.valueOf(c19084pl0.u(14));
        this.o = Boolean.valueOf(c19084pl0.u(15));
        this.p = Boolean.valueOf(c19084pl0.u(16));
        this.q = Boolean.valueOf(c19084pl0.u(17));
        this.r = Boolean.valueOf(c19084pl0.u(18));
        this.s = Boolean.valueOf(c19084pl0.u(19));
        this.t = Boolean.valueOf(c19084pl0.u(20));
    }

    public boolean q() {
        return this.f;
    }

    public Boolean r() {
        return this.s;
    }

    public boolean s() {
        return this.g;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.a(1, this.a);
        c19675ql0.a(2, this.b);
        c19675ql0.a(3, this.c);
        c19675ql0.a(4, this.d);
        c19675ql0.a(5, this.e);
        c19675ql0.a(6, this.f);
        c19675ql0.a(7, this.g);
        c19675ql0.a(8, this.h);
        c19675ql0.a(9, this.i);
        c19675ql0.a(10, this.j);
        Boolean bool = this.k;
        if (bool != null) {
            c19675ql0.a(11, bool.booleanValue());
        }
        Boolean bool2 = this.l;
        if (bool2 != null) {
            c19675ql0.a(12, bool2.booleanValue());
        }
        Boolean bool3 = this.m;
        if (bool3 != null) {
            c19675ql0.a(13, bool3.booleanValue());
        }
        Boolean bool4 = this.n;
        if (bool4 != null) {
            c19675ql0.a(14, bool4.booleanValue());
        }
        Boolean bool5 = this.o;
        if (bool5 != null) {
            c19675ql0.a(15, bool5.booleanValue());
        }
        Boolean bool6 = this.p;
        if (bool6 != null) {
            c19675ql0.a(16, bool6.booleanValue());
        }
        Boolean bool7 = this.q;
        if (bool7 != null) {
            c19675ql0.a(17, bool7.booleanValue());
        }
        Boolean bool8 = this.r;
        if (bool8 != null) {
            c19675ql0.a(18, bool8.booleanValue());
        }
        Boolean bool9 = this.s;
        if (bool9 != null) {
            c19675ql0.a(19, bool9.booleanValue());
        }
        Boolean bool10 = this.t;
        if (bool10 != null) {
            c19675ql0.a(20, bool10.booleanValue());
        }
    }

    public String toString() {
        return "struct Permissions{}";
    }

    public boolean u() {
        return this.b;
    }

    public boolean w() {
        return this.j;
    }

    public Boolean y() {
        return this.n;
    }

    public boolean z() {
        return this.e;
    }

    public DA() {
    }
}
