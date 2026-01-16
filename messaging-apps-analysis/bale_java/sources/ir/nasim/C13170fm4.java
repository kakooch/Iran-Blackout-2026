package ir.nasim;

import ir.nasim.AbstractC20375ru1;

/* renamed from: ir.nasim.fm4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C13170fm4 extends AbstractC20375ru1 {
    /* JADX WARN: Multi-variable type inference failed */
    public C13170fm4() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // ir.nasim.AbstractC20375ru1
    public Object a(AbstractC20375ru1.b bVar) {
        AbstractC13042fc3.i(bVar, "key");
        return b().get(bVar);
    }

    public final void c(AbstractC20375ru1.b bVar, Object obj) {
        AbstractC13042fc3.i(bVar, "key");
        b().put(bVar, obj);
    }

    public C13170fm4(AbstractC20375ru1 abstractC20375ru1) {
        AbstractC13042fc3.i(abstractC20375ru1, "initialExtras");
        b().putAll(abstractC20375ru1.b());
    }

    public /* synthetic */ C13170fm4(AbstractC20375ru1 abstractC20375ru1, int i, ED1 ed1) {
        this((i & 1) != 0 ? AbstractC20375ru1.a.b : abstractC20375ru1);
    }
}
