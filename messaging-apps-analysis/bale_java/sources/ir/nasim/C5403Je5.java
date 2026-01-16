package ir.nasim;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: ir.nasim.Je5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5403Je5 extends AbstractC17902nl0 {
    private HashMap a = new HashMap();

    public static C5403Je5 q(byte[] bArr) {
        return (C5403Je5) AbstractC16720ll0.b(new C5403Je5(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        Iterator it = c19084pl0.l(1).iterator();
        while (it.hasNext()) {
            try {
                C5169Ie5 c5169Ie5S = C5169Ie5.s((byte[]) it.next());
                this.a.put(c5169Ie5S.u(), c5169Ie5S);
            } catch (IOException e) {
                C19406qI3.c("PlainCursorsStorage", "parse", e);
            }
        }
    }

    public Collection r() {
        return this.a.values();
    }

    public C5169Ie5 s(C11458d25 c11458d25) {
        if (!this.a.containsKey(c11458d25)) {
            this.a.put(c11458d25, new C5169Ie5(c11458d25, 0L, 0L));
        }
        return (C5169Ie5) this.a.get(c11458d25);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        Iterator it = this.a.values().iterator();
        while (it.hasNext()) {
            c19675ql0.i(1, (C5169Ie5) it.next());
        }
    }

    public void u(C5169Ie5 c5169Ie5) {
        this.a.put(c5169Ie5.u(), c5169Ie5);
    }
}
