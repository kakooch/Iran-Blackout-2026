package ir.nasim;

/* renamed from: ir.nasim.sw, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C20983sw extends AbstractC17902nl0 {
    private String a;
    private Boolean b;
    private C7021Py c;
    private C7723Sy d;
    private Boolean e;

    public C20983sw(String str, Boolean bool, C7021Py c7021Py, C7723Sy c7723Sy, Boolean bool2) {
        this.a = str;
        this.b = bool;
        this.c = c7021Py;
        this.d = c7723Sy;
        this.e = bool2;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.A(1);
        this.b = Boolean.valueOf(c19084pl0.u(2));
        this.c = (C7021Py) c19084pl0.z(3, new C7021Py());
        this.d = (C7723Sy) c19084pl0.z(4, new C7723Sy());
        this.e = Boolean.valueOf(c19084pl0.u(5));
    }

    public String q() {
        return this.a;
    }

    public C7723Sy r() {
        return this.d;
    }

    public Boolean s() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        String str = this.a;
        if (str != null) {
            c19675ql0.o(1, str);
        }
        Boolean bool = this.b;
        if (bool != null) {
            c19675ql0.a(2, bool.booleanValue());
        }
        C7021Py c7021Py = this.c;
        if (c7021Py != null) {
            c19675ql0.i(3, c7021Py);
        }
        C7723Sy c7723Sy = this.d;
        if (c7723Sy != null) {
            c19675ql0.i(4, c7723Sy);
        }
        Boolean bool2 = this.e;
        if (bool2 != null) {
            c19675ql0.a(5, bool2.booleanValue());
        }
    }

    public String toString() {
        return "struct BotExInfo{}";
    }

    public Boolean u() {
        return this.e;
    }

    public C20983sw() {
    }
}
