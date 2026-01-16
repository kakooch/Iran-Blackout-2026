package ir.nasim;

import java.util.ArrayDeque;

/* loaded from: classes.dex */
public abstract class NJ {
    private final int a;
    private final ArrayDeque b;
    private final Object c = new Object();
    final InterfaceC15120j26 d;

    public NJ(int i, InterfaceC15120j26 interfaceC15120j26) {
        this.a = i;
        this.b = new ArrayDeque(i);
        this.d = interfaceC15120j26;
    }

    public Object a() {
        Object objRemoveLast;
        synchronized (this.c) {
            objRemoveLast = this.b.removeLast();
        }
        return objRemoveLast;
    }

    public void b(Object obj) {
        Object objA;
        synchronized (this.c) {
            try {
                objA = this.b.size() >= this.a ? a() : null;
                this.b.addFirst(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
        InterfaceC15120j26 interfaceC15120j26 = this.d;
        if (interfaceC15120j26 == null || objA == null) {
            return;
        }
        interfaceC15120j26.a(objA);
    }

    public boolean c() {
        boolean zIsEmpty;
        synchronized (this.c) {
            zIsEmpty = this.b.isEmpty();
        }
        return zIsEmpty;
    }
}
