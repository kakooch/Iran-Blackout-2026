package ir.nasim;

import java.util.Iterator;
import java.util.Map;

/* renamed from: ir.nasim.f55, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C12722f55 implements Iterator, InterfaceC17915nm3 {
    private final C11488d55 a;

    public C12722f55(AbstractC10724c55 abstractC10724c55) {
        AbstractC13273fw7[] abstractC13273fw7Arr = new AbstractC13273fw7[8];
        for (int i = 0; i < 8; i++) {
            abstractC13273fw7Arr[i] = new C15655jw7(this);
        }
        this.a = new C11488d55(abstractC10724c55, abstractC13273fw7Arr);
    }

    @Override // java.util.Iterator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Map.Entry next() {
        return (Map.Entry) this.a.next();
    }

    public final void c(Object obj, Object obj2) {
        this.a.l(obj, obj2);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.a.remove();
    }
}
