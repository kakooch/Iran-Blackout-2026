package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Kv, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C5784Kv extends AbstractC17566nB {
    private List a;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = new ArrayList();
        Iterator it = c19084pl0.l(1).iterator();
        while (it.hasNext()) {
            this.a.add(AbstractC17566nB.r((byte[]) it.next()));
        }
    }

    @Override // ir.nasim.AbstractC17566nB
    public int s() {
        return 5;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            c19675ql0.b(1, ((AbstractC17566nB) it.next()).q());
        }
    }

    public String toString() {
        return "struct ArrayValue{}";
    }

    public List u() {
        return this.a;
    }
}
