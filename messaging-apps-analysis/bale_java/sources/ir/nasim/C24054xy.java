package ir.nasim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.xy, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C24054xy extends AbstractC17902nl0 {
    private long a;
    private String b;
    private String c;
    private OC d;
    private boolean e;
    private Long f;
    private C5577Jy g;
    private int h;
    private C16966mA i;
    private EnumC5325Iw j;
    private String k;
    private boolean l;
    private String m;
    private List n;
    private Long o;
    private List p;
    private List q;

    public C24054xy(long j, String str, String str2, OC oc, boolean z, Long l, C5577Jy c5577Jy, int i, C16966mA c16966mA, EnumC5325Iw enumC5325Iw, String str3, boolean z2, String str4, List list, Long l2, List list2, List list3) {
        this.a = j;
        this.b = str;
        this.c = str2;
        this.d = oc;
        this.e = z;
        this.f = l;
        this.g = c5577Jy;
        this.h = i;
        this.i = c16966mA;
        this.j = enumC5325Iw;
        this.k = str3;
        this.l = z2;
        this.m = str4;
        this.n = list;
        this.o = l2;
        this.p = list2;
        this.q = list3;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.r(2);
        this.c = c19084pl0.r(3);
        this.d = (OC) c19084pl0.z(4, new OC());
        this.e = c19084pl0.b(5);
        this.f = Long.valueOf(c19084pl0.y(6));
        this.g = (C5577Jy) c19084pl0.z(7, new C5577Jy());
        this.h = c19084pl0.g(8);
        this.i = (C16966mA) c19084pl0.z(9, new C16966mA());
        int iH = c19084pl0.h(11, 0);
        if (iH != 0) {
            this.j = EnumC5325Iw.p(iH);
        }
        this.k = c19084pl0.r(12);
        this.l = c19084pl0.b(13);
        this.m = c19084pl0.r(16);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(17); i++) {
            arrayList.add(new C16966mA());
        }
        this.n = c19084pl0.p(17, arrayList);
        this.o = Long.valueOf(c19084pl0.y(18));
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < c19084pl0.m(19); i2++) {
            arrayList2.add(new C8430Vy());
        }
        this.p = c19084pl0.p(19, arrayList2);
        this.q = c19084pl0.q(20);
    }

    public C5577Jy q() {
        return this.g;
    }

    public int r() {
        return this.h;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        c19675ql0.g(1, this.a);
        String str = this.b;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(2, str);
        String str2 = this.c;
        if (str2 == null) {
            throw new IOException();
        }
        c19675ql0.o(3, str2);
        OC oc = this.d;
        if (oc != null) {
            c19675ql0.i(4, oc);
        }
        c19675ql0.a(5, this.e);
        Long l = this.f;
        if (l != null) {
            c19675ql0.g(6, l.longValue());
        }
        C5577Jy c5577Jy = this.g;
        if (c5577Jy != null) {
            c19675ql0.i(7, c5577Jy);
        }
        c19675ql0.f(8, this.h);
        C16966mA c16966mA = this.i;
        if (c16966mA != null) {
            c19675ql0.i(9, c16966mA);
        }
        EnumC5325Iw enumC5325Iw = this.j;
        if (enumC5325Iw != null) {
            c19675ql0.f(11, enumC5325Iw.j());
        }
        String str3 = this.k;
        if (str3 == null) {
            throw new IOException();
        }
        c19675ql0.o(12, str3);
        c19675ql0.a(13, this.l);
        String str4 = this.m;
        if (str4 == null) {
            throw new IOException();
        }
        c19675ql0.o(16, str4);
        c19675ql0.m(17, this.n);
        Long l2 = this.o;
        if (l2 != null) {
            c19675ql0.g(18, l2.longValue());
        }
        c19675ql0.m(19, this.p);
        c19675ql0.n(20, this.q);
    }

    public String toString() {
        return "struct GroupCall{}";
    }

    public C24054xy() {
    }
}
