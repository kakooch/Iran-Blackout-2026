package ir.nasim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.zz, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C25247zz extends AbstractC17902nl0 {
    private int a;
    private long b;
    private long c;
    private AbstractC24063xz d;
    private EnumC4884Gz e;
    private List f;
    private C24653yz g;
    private C16975mB h;
    private Long i;
    private C3460Az j;
    private C3460Az k;
    private Long l;
    private Integer m;
    private Long n;
    private Boolean o;
    private C23592xB p;
    private C3460Az q;

    public C25247zz(int i, long j, long j2, AbstractC24063xz abstractC24063xz, EnumC4884Gz enumC4884Gz, List list, C24653yz c24653yz, C16975mB c16975mB, Long l, C3460Az c3460Az, C3460Az c3460Az2, Long l2, Integer num, Long l3, Boolean bool, C23592xB c23592xB, C3460Az c3460Az3) {
        this.a = i;
        this.b = j;
        this.c = j2;
        this.d = abstractC24063xz;
        this.e = enumC4884Gz;
        this.f = list;
        this.g = c24653yz;
        this.h = c16975mB;
        this.i = l;
        this.j = c3460Az;
        this.k = c3460Az2;
        this.l = l2;
        this.m = num;
        this.n = l3;
        this.o = bool;
        this.p = c23592xB;
        this.q = c3460Az3;
    }

    public C23592xB C() {
        return this.p;
    }

    public int D() {
        return this.a;
    }

    public EnumC4884Gz E() {
        return this.e;
    }

    public Boolean F() {
        return this.o;
    }

    public long h() {
        return this.c;
    }

    public long i() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.i(2);
        this.c = c19084pl0.i(3);
        this.d = AbstractC24063xz.r(c19084pl0.d(5));
        int iH = c19084pl0.h(6, 0);
        if (iH != 0) {
            this.e = EnumC4884Gz.p(iH);
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(7); i++) {
            arrayList.add(new C4167Dz());
        }
        this.f = c19084pl0.p(7, arrayList);
        this.g = (C24653yz) c19084pl0.z(8, new C24653yz());
        this.h = (C16975mB) c19084pl0.z(9, new C16975mB());
        this.i = Long.valueOf(c19084pl0.y(10));
        this.j = (C3460Az) c19084pl0.z(11, new C3460Az());
        this.k = (C3460Az) c19084pl0.z(12, new C3460Az());
        this.l = Long.valueOf(c19084pl0.y(13));
        this.m = Integer.valueOf(c19084pl0.x(14));
        this.n = Long.valueOf(c19084pl0.y(15));
        this.o = Boolean.valueOf(c19084pl0.u(16));
        this.p = (C23592xB) c19084pl0.z(17, new C23592xB());
        this.q = (C3460Az) c19084pl0.z(18, new C3460Az());
    }

    public Long q() {
        return this.l;
    }

    public Long r() {
        return this.n;
    }

    public AbstractC24063xz s() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.f(1, this.a);
        c19675ql0.g(2, this.b);
        c19675ql0.g(3, this.c);
        AbstractC24063xz abstractC24063xz = this.d;
        if (abstractC24063xz == null) {
            throw new IOException();
        }
        c19675ql0.b(5, abstractC24063xz.q());
        EnumC4884Gz enumC4884Gz = this.e;
        if (enumC4884Gz != null) {
            c19675ql0.f(6, enumC4884Gz.j());
        }
        c19675ql0.m(7, this.f);
        C24653yz c24653yz = this.g;
        if (c24653yz != null) {
            c19675ql0.i(8, c24653yz);
        }
        C16975mB c16975mB = this.h;
        if (c16975mB != null) {
            c19675ql0.i(9, c16975mB);
        }
        Long l = this.i;
        if (l != null) {
            c19675ql0.g(10, l.longValue());
        }
        C3460Az c3460Az = this.j;
        if (c3460Az != null) {
            c19675ql0.i(11, c3460Az);
        }
        C3460Az c3460Az2 = this.k;
        if (c3460Az2 != null) {
            c19675ql0.i(12, c3460Az2);
        }
        Long l2 = this.l;
        if (l2 != null) {
            c19675ql0.g(13, l2.longValue());
        }
        Integer num = this.m;
        if (num != null) {
            c19675ql0.f(14, num.intValue());
        }
        Long l3 = this.n;
        if (l3 != null) {
            c19675ql0.g(15, l3.longValue());
        }
        Boolean bool = this.o;
        if (bool != null) {
            c19675ql0.a(16, bool.booleanValue());
        }
        C23592xB c23592xB = this.p;
        if (c23592xB != null) {
            c19675ql0.i(17, c23592xB);
        }
        C3460Az c3460Az3 = this.q;
        if (c3460Az3 != null) {
            c19675ql0.i(18, c3460Az3);
        }
    }

    public String toString() {
        return "struct MessageContainer{}";
    }

    public C3460Az u() {
        return this.k;
    }

    public C3460Az w() {
        return this.j;
    }

    public C16975mB y() {
        return this.h;
    }

    public List z() {
        return this.f;
    }

    public C25247zz() {
    }
}
