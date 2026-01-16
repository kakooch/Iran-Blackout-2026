package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.ky, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C16256ky extends AbstractC17902nl0 {
    private int a;
    private List b;
    private String c;
    private List d;
    private String e;
    private List f;
    private C19811qz g;
    private Boolean h;
    private C7714Sx i;
    private String j;
    private String k;
    private Boolean l;
    private Boolean m;
    private EnumC14002hB n;
    private Long o;
    private EnumC12184eB p;
    private Boolean q;

    public C16256ky(int i, List list, String str, List list2, String str2, List list3, C19811qz c19811qz, Boolean bool, C7714Sx c7714Sx, String str3, String str4, Boolean bool2, Boolean bool3, EnumC14002hB enumC14002hB, Long l, EnumC12184eB enumC12184eB, Boolean bool4) {
        this.a = i;
        this.b = list;
        this.c = str;
        this.d = list2;
        this.e = str2;
        this.f = list3;
        this.g = c19811qz;
        this.h = bool;
        this.i = c7714Sx;
        this.j = str3;
        this.k = str4;
        this.l = bool2;
        this.m = bool3;
        this.n = enumC14002hB;
        this.o = l;
        this.p = enumC12184eB;
        this.q = bool4;
    }

    public C19811qz C() {
        return this.g;
    }

    public int D() {
        return this.a;
    }

    public List E() {
        return this.d;
    }

    public EnumC12184eB F() {
        return this.p;
    }

    public EnumC14002hB G() {
        return this.n;
    }

    public String H() {
        return this.e;
    }

    public Boolean J() {
        return this.h;
    }

    public Boolean K() {
        return this.m;
    }

    public Boolean L() {
        return this.l;
    }

    public Boolean M() {
        return this.q;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(2); i++) {
            arrayList.add(new C13865gx());
        }
        this.b = c19084pl0.p(2, arrayList);
        this.c = c19084pl0.A(3);
        this.d = c19084pl0.q(4);
        this.e = c19084pl0.A(5);
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < c19084pl0.m(6); i2++) {
            arrayList2.add(new C20393rw());
        }
        this.f = c19084pl0.p(6, arrayList2);
        this.g = (C19811qz) c19084pl0.z(7, new C19811qz());
        this.h = Boolean.valueOf(c19084pl0.u(8));
        this.i = (C7714Sx) c19084pl0.z(9, new C7714Sx());
        this.j = c19084pl0.A(10);
        this.k = c19084pl0.A(11);
        this.l = Boolean.valueOf(c19084pl0.u(12));
        this.m = Boolean.valueOf(c19084pl0.u(13));
        int iH = c19084pl0.h(14, 0);
        if (iH != 0) {
            this.n = EnumC14002hB.p(iH);
        }
        this.o = Long.valueOf(c19084pl0.y(15));
        int iH2 = c19084pl0.h(16, 0);
        if (iH2 != 0) {
            this.p = EnumC12184eB.p(iH2);
        }
        this.q = Boolean.valueOf(c19084pl0.u(17));
    }

    public String q() {
        return this.c;
    }

    public List r() {
        return this.f;
    }

    public List s() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.f(1, this.a);
        c19675ql0.m(2, this.b);
        String str = this.c;
        if (str != null) {
            c19675ql0.o(3, str);
        }
        c19675ql0.n(4, this.d);
        String str2 = this.e;
        if (str2 != null) {
            c19675ql0.o(5, str2);
        }
        c19675ql0.m(6, this.f);
        C19811qz c19811qz = this.g;
        if (c19811qz != null) {
            c19675ql0.i(7, c19811qz);
        }
        Boolean bool = this.h;
        if (bool != null) {
            c19675ql0.a(8, bool.booleanValue());
        }
        C7714Sx c7714Sx = this.i;
        if (c7714Sx != null) {
            c19675ql0.i(9, c7714Sx);
        }
        String str3 = this.j;
        if (str3 != null) {
            c19675ql0.o(10, str3);
        }
        String str4 = this.k;
        if (str4 != null) {
            c19675ql0.o(11, str4);
        }
        Boolean bool2 = this.l;
        if (bool2 != null) {
            c19675ql0.a(12, bool2.booleanValue());
        }
        Boolean bool3 = this.m;
        if (bool3 != null) {
            c19675ql0.a(13, bool3.booleanValue());
        }
        EnumC14002hB enumC14002hB = this.n;
        if (enumC14002hB != null) {
            c19675ql0.f(14, enumC14002hB.j());
        }
        Long l = this.o;
        if (l != null) {
            c19675ql0.g(15, l.longValue());
        }
        EnumC12184eB enumC12184eB = this.p;
        if (enumC12184eB != null) {
            c19675ql0.f(16, enumC12184eB.j());
        }
        Boolean bool4 = this.q;
        if (bool4 != null) {
            c19675ql0.a(17, bool4.booleanValue());
        }
    }

    public String toString() {
        return "struct FullUserLegacy{}";
    }

    public Long u() {
        return this.o;
    }

    public String w() {
        return this.j;
    }

    public String y() {
        return this.k;
    }

    public C7714Sx z() {
        return this.i;
    }

    public C16256ky() {
    }
}
