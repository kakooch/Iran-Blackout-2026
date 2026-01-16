package ir.nasim;

import java.io.IOException;
import java.util.List;

/* renamed from: ir.nasim.wy, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C23464wy extends AbstractC17902nl0 {
    private int a;
    private long b;
    private String c;
    private C6984Pv d;
    private Integer e;
    private Boolean f;
    private Boolean g;
    private EnumC3690By h;
    private Boolean i;
    private C19811qz j;
    private String k;
    private Boolean l;
    private Long m;
    private DA n;
    private DA o;
    private Integer p;
    private List q;
    private Boolean r;
    private Integer s;
    private Boolean t;

    public C23464wy(int i, long j, String str, C6984Pv c6984Pv, Integer num, Boolean bool, Boolean bool2, EnumC3690By enumC3690By, Boolean bool3, C19811qz c19811qz, String str2, Boolean bool4, Long l, DA da, DA da2, Integer num2, List list, Boolean bool5, Integer num3, Boolean bool6) {
        this.a = i;
        this.b = j;
        this.c = str;
        this.d = c6984Pv;
        this.e = num;
        this.f = bool;
        this.g = bool2;
        this.h = enumC3690By;
        this.i = bool3;
        this.j = c19811qz;
        this.k = str2;
        this.l = bool4;
        this.m = l;
        this.n = da;
        this.o = da2;
        this.p = num2;
        this.q = list;
        this.r = bool5;
        this.s = num3;
        this.t = bool6;
    }

    public EnumC3690By C() {
        return this.h;
    }

    public int D() {
        return this.a;
    }

    public Integer E() {
        return this.s;
    }

    public Integer F() {
        return this.e;
    }

    public String G() {
        return this.k;
    }

    public Integer H() {
        return this.p;
    }

    public DA J() {
        return this.n;
    }

    public Long K() {
        return this.m;
    }

    public String L() {
        return this.c;
    }

    public Boolean M() {
        return this.g;
    }

    public Boolean N() {
        return this.f;
    }

    public Boolean O() {
        return this.r;
    }

    public long getAccessHash() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.i(2);
        this.c = c19084pl0.r(3);
        this.d = (C6984Pv) c19084pl0.z(4, new C6984Pv());
        this.e = Integer.valueOf(c19084pl0.x(24));
        this.f = Boolean.valueOf(c19084pl0.u(6));
        this.g = Boolean.valueOf(c19084pl0.u(20));
        int iH = c19084pl0.h(25, 0);
        if (iH != 0) {
            this.h = EnumC3690By.p(iH);
        }
        this.i = Boolean.valueOf(c19084pl0.u(26));
        this.j = (C19811qz) c19084pl0.z(22, new C19811qz());
        this.k = c19084pl0.A(27);
        this.l = Boolean.valueOf(c19084pl0.u(28));
        this.m = Long.valueOf(c19084pl0.y(29));
        this.n = (DA) c19084pl0.z(30, new DA());
        this.o = (DA) c19084pl0.z(31, new DA());
        this.p = Integer.valueOf(c19084pl0.x(32));
        this.q = c19084pl0.q(33);
        this.r = Boolean.valueOf(c19084pl0.u(34));
        this.s = Integer.valueOf(c19084pl0.x(35));
        this.t = Boolean.valueOf(c19084pl0.u(36));
        if (c19084pl0.t()) {
            setUnmappedObjects(c19084pl0.a());
        }
    }

    public Boolean q() {
        return this.l;
    }

    public Boolean r() {
        return this.i;
    }

    public Boolean s() {
        return this.t;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.f(1, this.a);
        c19675ql0.g(2, this.b);
        String str = this.c;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(3, str);
        C6984Pv c6984Pv = this.d;
        if (c6984Pv != null) {
            c19675ql0.i(4, c6984Pv);
        }
        Integer num = this.e;
        if (num != null) {
            c19675ql0.f(24, num.intValue());
        }
        Boolean bool = this.f;
        if (bool != null) {
            c19675ql0.a(6, bool.booleanValue());
        }
        Boolean bool2 = this.g;
        if (bool2 != null) {
            c19675ql0.a(20, bool2.booleanValue());
        }
        EnumC3690By enumC3690By = this.h;
        if (enumC3690By != null) {
            c19675ql0.f(25, enumC3690By.j());
        }
        Boolean bool3 = this.i;
        if (bool3 != null) {
            c19675ql0.a(26, bool3.booleanValue());
        }
        C19811qz c19811qz = this.j;
        if (c19811qz != null) {
            c19675ql0.i(22, c19811qz);
        }
        String str2 = this.k;
        if (str2 != null) {
            c19675ql0.o(27, str2);
        }
        Boolean bool4 = this.l;
        if (bool4 != null) {
            c19675ql0.a(28, bool4.booleanValue());
        }
        Long l = this.m;
        if (l != null) {
            c19675ql0.g(29, l.longValue());
        }
        DA da = this.n;
        if (da != null) {
            c19675ql0.i(30, da);
        }
        DA da2 = this.o;
        if (da2 != null) {
            c19675ql0.i(31, da2);
        }
        Integer num2 = this.p;
        if (num2 != null) {
            c19675ql0.f(32, num2.intValue());
        }
        c19675ql0.n(33, this.q);
        Boolean bool5 = this.r;
        if (bool5 != null) {
            c19675ql0.a(34, bool5.booleanValue());
        }
        Integer num3 = this.s;
        if (num3 != null) {
            c19675ql0.f(35, num3.intValue());
        }
        Boolean bool6 = this.t;
        if (bool6 != null) {
            c19675ql0.a(36, bool6.booleanValue());
        }
        if (getUnmappedObjects() != null) {
            C18818pI6 unmappedObjects = getUnmappedObjects();
            for (int i = 0; i < unmappedObjects.k(); i++) {
                int iH = unmappedObjects.h(i);
                c19675ql0.q(iH, unmappedObjects.d(iH));
            }
        }
    }

    public String toString() {
        return "struct Group{}";
    }

    public List u() {
        return this.q;
    }

    public C6984Pv w() {
        return this.d;
    }

    public DA y() {
        return this.o;
    }

    public C19811qz z() {
        return this.j;
    }

    public C23464wy() {
    }
}
