package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.kD, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C15811kD extends AbstractC17902nl0 {
    private int a;
    private long b;
    private String c;
    private String d;
    private String e;
    private EnumC24781zC f;
    private C6984Pv g;
    private Boolean h;
    private C19811qz i;
    private Long j;
    private Boolean k;
    private EnumC14002hB l;
    private Long m;
    private C20983sw n;

    public C15811kD(int i, long j, String str, String str2, String str3, EnumC24781zC enumC24781zC, C6984Pv c6984Pv, Boolean bool, C19811qz c19811qz, Long l, Boolean bool2, EnumC14002hB enumC14002hB, Long l2, C20983sw c20983sw) {
        this.a = i;
        this.b = j;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = enumC24781zC;
        this.g = c6984Pv;
        this.h = bool;
        this.i = c19811qz;
        this.j = l;
        this.k = bool2;
        this.l = enumC14002hB;
        this.m = l2;
        this.n = c20983sw;
    }

    public EnumC14002hB C() {
        return this.l;
    }

    public EnumC24781zC D() {
        return this.f;
    }

    public Long E() {
        return this.j;
    }

    public Boolean F() {
        return this.h;
    }

    public Boolean G() {
        return this.k;
    }

    public long getAccessHash() {
        return this.b;
    }

    public String getName() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.i(2);
        this.c = c19084pl0.r(3);
        this.d = c19084pl0.A(4);
        this.e = c19084pl0.A(13);
        int iH = c19084pl0.h(5, 0);
        if (iH != 0) {
            this.f = EnumC24781zC.p(iH);
        }
        this.g = (C6984Pv) c19084pl0.z(8, new C6984Pv());
        this.h = Boolean.valueOf(c19084pl0.u(11));
        this.i = (C19811qz) c19084pl0.z(20, new C19811qz());
        this.j = Long.valueOf(c19084pl0.y(21));
        this.k = Boolean.valueOf(c19084pl0.u(22));
        int iH2 = c19084pl0.h(23, 0);
        if (iH2 != 0) {
            this.l = EnumC14002hB.p(iH2);
        }
        this.m = Long.valueOf(c19084pl0.y(24));
        this.n = (C20983sw) c19084pl0.z(26, new C20983sw());
        if (c19084pl0.t()) {
            setUnmappedObjects(c19084pl0.a());
        }
    }

    public C6984Pv q() {
        return this.g;
    }

    public C20983sw r() {
        return this.n;
    }

    public Long s() {
        return this.m;
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
        String str2 = this.d;
        if (str2 != null) {
            c19675ql0.o(4, str2);
        }
        String str3 = this.e;
        if (str3 != null) {
            c19675ql0.o(13, str3);
        }
        EnumC24781zC enumC24781zC = this.f;
        if (enumC24781zC != null) {
            c19675ql0.f(5, enumC24781zC.j());
        }
        C6984Pv c6984Pv = this.g;
        if (c6984Pv != null) {
            c19675ql0.i(8, c6984Pv);
        }
        Boolean bool = this.h;
        if (bool != null) {
            c19675ql0.a(11, bool.booleanValue());
        }
        C19811qz c19811qz = this.i;
        if (c19811qz != null) {
            c19675ql0.i(20, c19811qz);
        }
        Long l = this.j;
        if (l != null) {
            c19675ql0.g(21, l.longValue());
        }
        Boolean bool2 = this.k;
        if (bool2 != null) {
            c19675ql0.a(22, bool2.booleanValue());
        }
        EnumC14002hB enumC14002hB = this.l;
        if (enumC14002hB != null) {
            c19675ql0.f(23, enumC14002hB.j());
        }
        Long l2 = this.m;
        if (l2 != null) {
            c19675ql0.g(24, l2.longValue());
        }
        C20983sw c20983sw = this.n;
        if (c20983sw != null) {
            c19675ql0.i(26, c20983sw);
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
        return "struct User{}";
    }

    public C19811qz u() {
        return this.i;
    }

    public int w() {
        return this.a;
    }

    public String y() {
        return this.d;
    }

    public String z() {
        return this.e;
    }

    public C15811kD() {
    }
}
