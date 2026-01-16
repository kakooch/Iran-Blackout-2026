package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class LB extends HB {
    private List a;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = new ArrayList();
        Iterator it = c19084pl0.l(2).iterator();
        while (it.hasNext()) {
            this.a.add(HB.r((byte[]) it.next()));
        }
    }

    @Override // ir.nasim.HB
    public int s() {
        return 4;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            c19675ql0.b(2, ((HB) it.next()).q());
        }
    }

    public String toString() {
        return "struct SearchOrCondition{}";
    }
}
