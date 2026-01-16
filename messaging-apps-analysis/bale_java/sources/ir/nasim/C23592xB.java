package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.xB, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C23592xB extends AbstractC17902nl0 {
    private int a;
    private List b;
    private C3460Az c;

    public C23592xB(int i, List list, C3460Az c3460Az) {
        this.a = i;
        this.b = list;
        this.c = c3460Az;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(2); i++) {
            arrayList.add(new C18766pD());
        }
        this.b = c19084pl0.p(2, arrayList);
        this.c = (C3460Az) c19084pl0.z(3, new C3460Az());
    }

    public C3460Az q() {
        return this.c;
    }

    public List r() {
        return this.b;
    }

    public int s() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.f(1, this.a);
        c19675ql0.m(2, this.b);
        C3460Az c3460Az = this.c;
        if (c3460Az != null) {
            c19675ql0.i(3, c3460Az);
        }
    }

    public String toString() {
        return "struct Replies{}";
    }

    public C23592xB() {
    }
}
