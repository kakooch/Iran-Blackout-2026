package ir.nasim;

import java.util.Iterator;

/* renamed from: ir.nasim.j63, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C15157j63 implements Iterable, InterfaceC17915nm3 {
    private final SA2 a;

    public C15157j63(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "iteratorFactory");
        this.a = sa2;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new C15748k63((Iterator) this.a.invoke());
    }
}
