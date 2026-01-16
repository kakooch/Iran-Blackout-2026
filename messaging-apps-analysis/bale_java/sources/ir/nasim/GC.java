package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class GC extends AbstractC17902nl0 {
    private int a;
    private long b;
    private List c;
    private Boolean d;
    private List e;
    private String f;

    public GC(int i, long j, List list, Boolean bool, List list2, String str) {
        this.a = i;
        this.b = j;
        this.c = list;
        this.d = bool;
        this.e = list2;
        this.f = str;
    }

    public long getAccessHash() {
        return this.b;
    }

    public String getName() {
        return this.f;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.i(2);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(3); i++) {
            arrayList.add(new HC());
        }
        this.c = c19084pl0.p(3, arrayList);
        this.d = Boolean.valueOf(c19084pl0.u(4));
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < c19084pl0.m(5); i2++) {
            arrayList2.add(new C5082Hv());
        }
        this.e = c19084pl0.p(5, arrayList2);
        this.f = c19084pl0.A(6);
    }

    public int q() {
        return this.a;
    }

    public List r() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.f(1, this.a);
        c19675ql0.g(2, this.b);
        c19675ql0.m(3, this.c);
        Boolean bool = this.d;
        if (bool != null) {
            c19675ql0.a(4, bool.booleanValue());
        }
        c19675ql0.m(5, this.e);
        String str = this.f;
        if (str != null) {
            c19675ql0.o(6, str);
        }
    }

    public String toString() {
        return "struct StickerCollection{}";
    }

    public GC() {
    }
}
