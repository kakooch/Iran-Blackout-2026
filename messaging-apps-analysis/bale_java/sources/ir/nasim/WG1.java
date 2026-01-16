package ir.nasim;

import java.util.List;

/* loaded from: classes5.dex */
public class WG1 extends AbstractC17902nl0 {
    private C11458d25 a;
    private List b;
    private List c;
    private boolean d;

    public WG1(C11458d25 c11458d25, List list, List list2, boolean z) {
        this.a = c11458d25;
        this.b = list;
        this.c = list2;
        this.d = z;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = C11458d25.q(c19084pl0.d(1));
        this.b = c19084pl0.o(2);
        if (c19084pl0.t()) {
            this.c = c19084pl0.o(3);
        }
        if (c19084pl0.t()) {
            this.d = c19084pl0.c(4, true);
        }
    }

    public List q() {
        return this.c;
    }

    public C11458d25 r() {
        return this.a;
    }

    public List s() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.i(1, this.a);
        c19675ql0.l(2, this.b);
        c19675ql0.l(3, this.c);
        c19675ql0.a(4, this.d);
    }

    public boolean u() {
        return this.d;
    }

    public WG1() {
    }
}
