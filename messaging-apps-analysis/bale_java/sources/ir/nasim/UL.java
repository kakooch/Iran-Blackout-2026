package ir.nasim;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes8.dex */
public abstract class UL extends QK4 {
    private static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(UL.class, Object.class, "_consensus");
    private volatile Object _consensus = SL.a;

    private final Object c(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        Object obj2 = atomicReferenceFieldUpdater.get(this);
        Object obj3 = SL.a;
        return obj2 != obj3 ? obj2 : F1.a(atomicReferenceFieldUpdater, this, obj3, obj) ? obj : atomicReferenceFieldUpdater.get(this);
    }

    @Override // ir.nasim.QK4
    public final Object a(Object obj) {
        Object objC = a.get(this);
        if (objC == SL.a) {
            objC = c(d(obj));
        }
        b(obj, objC);
        return objC;
    }

    public abstract void b(Object obj, Object obj2);

    public abstract Object d(Object obj);
}
