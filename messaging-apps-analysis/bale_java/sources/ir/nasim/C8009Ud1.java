package ir.nasim;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: ir.nasim.Ud1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C8009Ud1 implements InterfaceC23384wp6 {
    private final AtomicReference a;

    public C8009Ud1(InterfaceC23384wp6 interfaceC23384wp6) {
        AbstractC13042fc3.i(interfaceC23384wp6, "sequence");
        this.a = new AtomicReference(interfaceC23384wp6);
    }

    @Override // ir.nasim.InterfaceC23384wp6
    public Iterator iterator() {
        InterfaceC23384wp6 interfaceC23384wp6 = (InterfaceC23384wp6) this.a.getAndSet(null);
        if (interfaceC23384wp6 != null) {
            return interfaceC23384wp6.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
