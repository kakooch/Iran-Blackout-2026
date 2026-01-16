package ir.nasim;

import java.io.Serializable;

/* loaded from: classes8.dex */
final class A47 implements InterfaceC9173Yu3, Serializable {
    private SA2 a;
    private volatile Object b;
    private final Object c;

    public A47(SA2 sa2, Object obj) {
        AbstractC13042fc3.i(sa2, "initializer");
        this.a = sa2;
        this.b = C17565nA7.a;
        this.c = obj == null ? this : obj;
    }

    @Override // ir.nasim.InterfaceC9173Yu3
    public Object getValue() {
        Object objInvoke;
        Object obj = this.b;
        C17565nA7 c17565nA7 = C17565nA7.a;
        if (obj != c17565nA7) {
            return obj;
        }
        synchronized (this.c) {
            objInvoke = this.b;
            if (objInvoke == c17565nA7) {
                SA2 sa2 = this.a;
                AbstractC13042fc3.f(sa2);
                objInvoke = sa2.invoke();
                this.b = objInvoke;
                this.a = null;
            }
        }
        return objInvoke;
    }

    @Override // ir.nasim.InterfaceC9173Yu3
    public boolean isInitialized() {
        return this.b != C17565nA7.a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ A47(SA2 sa2, Object obj, int i, ED1 ed1) {
        this(sa2, (i & 2) != 0 ? null : obj);
    }
}
