package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.qB, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C19339qB extends AbstractC17902nl0 {
    private long a;
    private long b;
    private List c;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.i(2);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c19084pl0.m(3); i++) {
            arrayList.add(new C4167Dz());
        }
        this.c = c19084pl0.p(3, arrayList);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.g(1, this.a);
        c19675ql0.g(2, this.b);
        c19675ql0.m(3, this.c);
    }

    public String toString() {
        return "struct ReactionContainer{}";
    }
}
