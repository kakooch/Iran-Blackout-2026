package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class ZA extends AbstractC17902nl0 {
    private List a;
    private List b;
    private List c;
    private boolean d;
    private long e;
    private int f;

    public ZA(List list, List list2, List list3, boolean z, long j, int i) {
        this.a = list;
        this.b = list2;
        this.c = list3;
        this.d = z;
        this.e = j;
        this.f = i;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(1); i++) {
            arrayList.add(new C12766fA());
        }
        this.a = c19084pl0.p(1, arrayList);
        this.b = c19084pl0.o(2);
        this.c = c19084pl0.o(3);
        this.d = c19084pl0.b(4);
        this.e = c19084pl0.i(5);
        this.f = c19084pl0.g(6);
    }

    public List q() {
        return this.c;
    }

    public List r() {
        return this.a;
    }

    public long s() {
        return this.e;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.m(1, this.a);
        c19675ql0.l(2, this.b);
        c19675ql0.l(3, this.c);
        c19675ql0.a(4, this.d);
        c19675ql0.g(5, this.e);
        c19675ql0.f(6, this.f);
    }

    public String toString() {
        return "struct PollResult{}";
    }

    public List u() {
        return this.b;
    }

    public int w() {
        return this.f;
    }

    public boolean y() {
        return this.d;
    }

    public ZA() {
    }
}
