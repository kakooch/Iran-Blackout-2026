package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.m18, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16885m18 extends AbstractC17902nl0 {
    private long a;
    private List b;
    private List c;
    private boolean d;
    private int e;
    private List f;
    private int g;

    public C16885m18(long j, List list, List list2, boolean z, int i, List list3, int i2) {
        AbstractC13042fc3.i(list, "chosenOptionIds");
        AbstractC13042fc3.i(list2, "optionResults");
        AbstractC13042fc3.i(list3, "recentVoters");
        this.a = j;
        this.b = list;
        this.c = list2;
        this.d = z;
        this.e = i;
        this.f = list3;
        this.g = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C16885m18)) {
            return false;
        }
        C16885m18 c16885m18 = (C16885m18) obj;
        return this.a == c16885m18.a && AbstractC13042fc3.d(this.b, c16885m18.b) && AbstractC13042fc3.d(this.c, c16885m18.c) && this.e == c16885m18.e && AbstractC13042fc3.d(this.f, c16885m18.f) && this.g == c16885m18.g && this.d == c16885m18.d;
    }

    public int hashCode() {
        return (((((((((((Long.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.e)) * 31) + this.f.hashCode()) * 31) + Integer.hashCode(this.g)) * 31) + Boolean.hashCode(this.d);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        AbstractC13042fc3.i(c19084pl0, "values");
        this.a = c19084pl0.i(2);
        this.b = c19084pl0.o(3);
        ArrayList arrayList = new ArrayList();
        int iM = c19084pl0.m(4);
        if (iM >= 0) {
            int i = 0;
            while (true) {
                arrayList.add(new C4011Dh5());
                if (i == iM) {
                    break;
                } else {
                    i++;
                }
            }
        }
        this.c = c19084pl0.p(4, arrayList);
        this.d = c19084pl0.b(5);
        this.e = c19084pl0.g(6);
        this.f = c19084pl0.o(7);
        this.g = c19084pl0.g(8);
    }

    public final List q() {
        return this.b;
    }

    public final List r() {
        return this.c;
    }

    public final long s() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        AbstractC13042fc3.i(c19675ql0, "writer");
        c19675ql0.g(2, this.a);
        c19675ql0.l(3, this.b);
        c19675ql0.m(4, this.c);
        c19675ql0.a(5, this.d);
        c19675ql0.f(6, this.e);
        c19675ql0.l(7, this.f);
        c19675ql0.f(8, this.g);
    }

    public final List u() {
        return this.f;
    }

    public final int w() {
        return this.e;
    }

    public final boolean y() {
        return this.d;
    }

    public C16885m18() {
        this(0L, new ArrayList(), new ArrayList(), false, 0, AbstractC10360bX0.m(), 0);
    }
}
