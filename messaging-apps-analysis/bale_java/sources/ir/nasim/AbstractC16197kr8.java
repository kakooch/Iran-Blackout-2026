package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.kr8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC16197kr8 {
    private final Gu8 a;
    protected final C10571bp8 b;
    private final List c;

    protected AbstractC16197kr8(Gu8 gu8, OV0 ov0) {
        AbstractC3795Cj5.j(gu8);
        this.a = gu8;
        this.c = new ArrayList();
        C10571bp8 c10571bp8 = new C10571bp8(this, ov0);
        c10571bp8.d();
        this.b = c10571bp8;
    }

    protected final void a(C10571bp8 c10571bp8) {
        Iterator it = this.c.iterator();
        if (it.hasNext()) {
            AbstractC18350oW3.a(it.next());
            throw null;
        }
    }
}
