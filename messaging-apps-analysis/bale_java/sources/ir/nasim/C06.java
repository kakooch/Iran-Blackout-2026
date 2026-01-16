package ir.nasim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class C06 extends AbstractC10365bX5 {
    private String b;
    private boolean c;
    private PA d;
    private boolean e;
    private EnumC6251Mv f;
    private Long g;
    private EnumC6251Mv h;
    private Long i;
    private C5577Jy j;
    private List k;
    private List l;

    public static C06 s(byte[] bArr) {
        return (C06) AbstractC16720ll0.b(new C06(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.r(1);
        this.c = c19084pl0.b(2);
        int iH = c19084pl0.h(3, 0);
        if (iH != 0) {
            this.d = PA.p(iH);
        }
        this.e = c19084pl0.b(4);
        int iH2 = c19084pl0.h(5, 0);
        if (iH2 != 0) {
            this.f = EnumC6251Mv.p(iH2);
        }
        this.g = Long.valueOf(c19084pl0.y(6));
        int iH3 = c19084pl0.h(7, 0);
        if (iH3 != 0) {
            this.h = EnumC6251Mv.p(iH3);
        }
        this.i = Long.valueOf(c19084pl0.y(8));
        this.j = (C5577Jy) c19084pl0.z(9, new C5577Jy());
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(10); i++) {
            arrayList.add(new C7953Tx());
        }
        this.k = c19084pl0.p(10, arrayList);
        this.l = new ArrayList();
        Iterator it = c19084pl0.n(11).iterator();
        while (it.hasNext()) {
            this.l.add(EnumC6251Mv.p(((Integer) it.next()).intValue()));
        }
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) throws IOException {
        String str = this.b;
        if (str == null) {
            throw new IOException();
        }
        c19675ql0.o(1, str);
        c19675ql0.a(2, this.c);
        PA pa = this.d;
        if (pa != null) {
            c19675ql0.f(3, pa.j());
        }
        c19675ql0.a(4, this.e);
        EnumC6251Mv enumC6251Mv = this.f;
        if (enumC6251Mv != null) {
            c19675ql0.f(5, enumC6251Mv.j());
        }
        Long l = this.g;
        if (l != null) {
            c19675ql0.g(6, l.longValue());
        }
        EnumC6251Mv enumC6251Mv2 = this.h;
        if (enumC6251Mv2 != null) {
            c19675ql0.f(7, enumC6251Mv2.j());
        }
        Long l2 = this.i;
        if (l2 != null) {
            c19675ql0.g(8, l2.longValue());
        }
        C5577Jy c5577Jy = this.j;
        if (c5577Jy != null) {
            c19675ql0.i(9, c5577Jy);
        }
        c19675ql0.m(10, this.k);
        Iterator it = this.l.iterator();
        while (it.hasNext()) {
            c19675ql0.f(11, ((EnumC6251Mv) it.next()).j());
        }
    }

    public String toString() {
        return "response StartPhoneAuth{}";
    }
}
