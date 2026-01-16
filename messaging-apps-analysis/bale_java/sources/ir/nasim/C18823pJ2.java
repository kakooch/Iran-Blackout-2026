package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.features.mxp.entity.PuppetGroup;
import java.util.ArrayList;

/* renamed from: ir.nasim.pJ2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C18823pJ2 extends AbstractC17902nl0 implements HB3 {
    public static final InterfaceC17311ml0 t = new InterfaceC17311ml0() { // from class: ir.nasim.oJ2
        @Override // ir.nasim.InterfaceC17311ml0
        public final Object a() {
            return new C18823pJ2();
        }
    };
    private final long a;
    private final long b;
    public C11458d25 c;
    public boolean d;
    private Long e;
    private long f;
    private int g;
    private AbstractC17457n0 h;
    private boolean i;
    private long j;
    private String k;
    private String l;
    private Integer m;
    private Integer n;
    private Boolean o;
    private Boolean p;
    private int q;
    private String r;
    public PuppetGroup s;

    public C18823pJ2(C11458d25 c11458d25, long j, long j2, int i, AbstractC17457n0 abstractC17457n0) {
        this.a = 1648113849794613178L;
        this.b = 977941318413168487L;
        this.d = false;
        this.c = c11458d25;
        this.f = j;
        this.e = Long.valueOf(j2);
        this.j = j2;
        this.g = i;
        this.h = abstractC17457n0;
        this.i = true;
        this.q = 1;
    }

    @Override // ir.nasim.HB3
    public long a() {
        if (this.i) {
            if (this.q == 1) {
                return this.f;
            }
            return 977941318413168487L;
        }
        int i = this.q;
        if (i == 1 || i == 4) {
            return this.c.u();
        }
        if (i == 2) {
            return u();
        }
        return 1648113849794613178L;
    }

    public boolean equals(Object obj) {
        return a() == ((C18823pJ2) obj).a();
    }

    public long i() {
        return this.f;
    }

    @Override // ir.nasim.HB3
    public long j() {
        return this.j;
    }

    @Override // ir.nasim.HB3
    public String p() {
        String str = "";
        if (this.k != null) {
            str = "" + this.k;
        }
        if (this.r == null) {
            return str;
        }
        return str + Separators.SP + this.r;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.c = C11458d25.q(c19084pl0.d(1));
        this.e = Long.valueOf(c19084pl0.y(2));
        this.j = c19084pl0.i(3);
        boolean zB = c19084pl0.b(4);
        this.i = zB;
        if (zB) {
            this.f = c19084pl0.i(5);
            this.g = c19084pl0.g(6);
            this.h = AbstractC17457n0.n(c19084pl0.d(7));
        } else {
            this.k = c19084pl0.r(8);
            this.l = c19084pl0.A(9);
            this.m = Integer.valueOf(c19084pl0.x(10));
            this.n = Integer.valueOf(c19084pl0.x(11));
            this.o = Boolean.valueOf(c19084pl0.u(12));
            this.p = Boolean.valueOf(c19084pl0.u(13));
        }
        this.q = c19084pl0.g(14);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(15); i++) {
            arrayList.add(new PuppetGroup("", new ArrayList()));
        }
        if (arrayList.size() > 0) {
            this.s = (PuppetGroup) c19084pl0.p(15, arrayList).get(0);
        }
    }

    public AbstractC17457n0 q() {
        return this.h;
    }

    public Long r() {
        return this.e;
    }

    public int s() {
        return this.g;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.i(1, this.c);
        Long l = this.e;
        if (l != null) {
            c19675ql0.g(2, l.longValue());
        }
        c19675ql0.g(3, this.j);
        c19675ql0.a(4, this.i);
        if (this.i) {
            c19675ql0.g(5, this.f);
            c19675ql0.f(6, this.g);
            c19675ql0.b(7, AbstractC17457n0.o(this.h));
        } else {
            c19675ql0.o(8, this.k);
            String str = this.l;
            if (str != null) {
                c19675ql0.o(9, str);
            }
            Integer num = this.m;
            if (num != null) {
                c19675ql0.f(10, num.intValue());
            }
            Integer num2 = this.n;
            if (num2 != null) {
                c19675ql0.f(11, num2.intValue());
            }
            Boolean bool = this.o;
            if (bool != null) {
                c19675ql0.a(12, bool.booleanValue());
            }
            Boolean bool2 = this.p;
            if (bool2 != null) {
                c19675ql0.a(13, bool2.booleanValue());
            }
        }
        c19675ql0.f(14, this.q);
        PuppetGroup puppetGroup = this.s;
        if (puppetGroup != null) {
            c19675ql0.m(15, AbstractC22311v13.a(new Object[]{puppetGroup}));
        }
    }

    public long u() {
        return this.j;
    }

    public String w() {
        return this.k;
    }

    public int y() {
        return this.q;
    }

    public boolean z() {
        return this.i;
    }

    public C18823pJ2(C11458d25 c11458d25, String str, String str2, Integer num, Long l, Integer num2, Boolean bool, Boolean bool2, int i, String str3) {
        this.a = 1648113849794613178L;
        this.b = 977941318413168487L;
        this.d = false;
        this.c = c11458d25;
        this.k = str;
        this.l = str2;
        this.m = num;
        this.e = l;
        this.j = l.longValue();
        this.n = num2;
        this.o = bool;
        this.p = bool2;
        this.i = false;
        this.q = i;
        this.r = str3;
    }

    public C18823pJ2(C11458d25 c11458d25, long j) {
        this.a = 1648113849794613178L;
        this.b = 977941318413168487L;
        this.d = false;
        this.c = c11458d25;
        this.e = Long.valueOf(j);
        this.j = j;
        this.i = false;
        this.q = 4;
        this.k = "";
        this.l = "";
        this.m = 0;
        this.n = 0;
        Boolean bool = Boolean.FALSE;
        this.p = bool;
        this.o = bool;
    }

    public C18823pJ2() {
        this.a = 1648113849794613178L;
        this.b = 977941318413168487L;
        this.d = false;
    }
}
