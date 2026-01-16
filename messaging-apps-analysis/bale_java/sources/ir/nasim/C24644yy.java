package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.yy, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C24644yy extends AbstractC17902nl0 {
    private int a;
    private long b;
    private int c;
    private List d;
    private String e;
    private String f;
    private C19811qz g;
    private Boolean h;
    private Boolean i;
    private Boolean j;
    private Boolean k;
    private C7714Sx l;
    private C25247zz m;
    private BB n;
    private EnumC4599Fv o;
    private String p;
    private String q;
    private List r;
    private Boolean s;
    private EnumC12184eB t;

    public C24644yy(int i, long j, int i2, List list, String str, String str2, C19811qz c19811qz, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, C7714Sx c7714Sx, C25247zz c25247zz, BB bb, EnumC4599Fv enumC4599Fv, String str3, String str4, List list2, Boolean bool5, EnumC12184eB enumC12184eB) {
        this.a = i;
        this.b = j;
        this.c = i2;
        this.d = list;
        this.e = str;
        this.f = str2;
        this.g = c19811qz;
        this.h = bool;
        this.i = bool2;
        this.j = bool3;
        this.k = bool4;
        this.l = c7714Sx;
        this.m = c25247zz;
        this.n = bb;
        this.o = enumC4599Fv;
        this.p = str3;
        this.q = str4;
        this.r = list2;
        this.s = bool5;
        this.t = enumC12184eB;
    }

    public long C() {
        return this.b;
    }

    public C7714Sx D() {
        return this.l;
    }

    public C19811qz E() {
        return this.g;
    }

    public int F() {
        return this.a;
    }

    public List G() {
        return this.d;
    }

    public int H() {
        return this.c;
    }

    public C25247zz J() {
        return this.m;
    }

    public EnumC12184eB K() {
        return this.t;
    }

    public BB L() {
        return this.n;
    }

    public String M() {
        return this.e;
    }

    public Boolean N() {
        return this.h;
    }

    public Boolean O() {
        return this.k;
    }

    public Boolean P() {
        return this.s;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.i(6);
        this.c = c19084pl0.g(5);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(12); i++) {
            arrayList.add(new C22883vz());
        }
        this.d = c19084pl0.p(12, arrayList);
        this.e = c19084pl0.A(2);
        this.f = c19084pl0.A(3);
        this.g = (C19811qz) c19084pl0.z(7, new C19811qz());
        this.h = Boolean.valueOf(c19084pl0.u(11));
        this.i = Boolean.valueOf(c19084pl0.u(8));
        this.j = Boolean.valueOf(c19084pl0.u(9));
        this.k = Boolean.valueOf(c19084pl0.u(10));
        this.l = (C7714Sx) c19084pl0.z(13, new C7714Sx());
        this.m = (C25247zz) c19084pl0.z(14, new C25247zz());
        int iH = c19084pl0.h(15, 0);
        if (iH != 0) {
            this.n = BB.p(iH);
        }
        int iH2 = c19084pl0.h(16, 0);
        if (iH2 != 0) {
            this.o = EnumC4599Fv.p(iH2);
        }
        this.p = c19084pl0.A(18);
        this.q = c19084pl0.A(19);
        this.r = c19084pl0.q(20);
        this.s = Boolean.valueOf(c19084pl0.u(34));
        int iH3 = c19084pl0.h(35, 0);
        if (iH3 != 0) {
            this.t = EnumC12184eB.p(iH3);
        }
    }

    public Boolean q() {
        return this.j;
    }

    public Boolean r() {
        return this.i;
    }

    public String s() {
        return this.f;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.f(1, this.a);
        c19675ql0.g(6, this.b);
        c19675ql0.f(5, this.c);
        c19675ql0.m(12, this.d);
        String str = this.e;
        if (str != null) {
            c19675ql0.o(2, str);
        }
        String str2 = this.f;
        if (str2 != null) {
            c19675ql0.o(3, str2);
        }
        C19811qz c19811qz = this.g;
        if (c19811qz != null) {
            c19675ql0.i(7, c19811qz);
        }
        Boolean bool = this.h;
        if (bool != null) {
            c19675ql0.a(11, bool.booleanValue());
        }
        Boolean bool2 = this.i;
        if (bool2 != null) {
            c19675ql0.a(8, bool2.booleanValue());
        }
        Boolean bool3 = this.j;
        if (bool3 != null) {
            c19675ql0.a(9, bool3.booleanValue());
        }
        Boolean bool4 = this.k;
        if (bool4 != null) {
            c19675ql0.a(10, bool4.booleanValue());
        }
        C7714Sx c7714Sx = this.l;
        if (c7714Sx != null) {
            c19675ql0.i(13, c7714Sx);
        }
        C25247zz c25247zz = this.m;
        if (c25247zz != null) {
            c19675ql0.i(14, c25247zz);
        }
        BB bb = this.n;
        if (bb != null) {
            c19675ql0.f(15, bb.j());
        }
        EnumC4599Fv enumC4599Fv = this.o;
        if (enumC4599Fv != null) {
            c19675ql0.f(16, enumC4599Fv.j());
        }
        String str3 = this.p;
        if (str3 != null) {
            c19675ql0.o(18, str3);
        }
        String str4 = this.q;
        if (str4 != null) {
            c19675ql0.o(19, str4);
        }
        c19675ql0.n(20, this.r);
        Boolean bool5 = this.s;
        if (bool5 != null) {
            c19675ql0.a(34, bool5.booleanValue());
        }
        EnumC12184eB enumC12184eB = this.t;
        if (enumC12184eB != null) {
            c19675ql0.f(35, enumC12184eB.j());
        }
    }

    public String toString() {
        return "struct GroupFull{}";
    }

    public EnumC4599Fv u() {
        return this.o;
    }

    public List w() {
        return this.r;
    }

    public String y() {
        return this.q;
    }

    public String z() {
        return this.p;
    }

    public C24644yy() {
    }
}
