package ir.nasim;

import java.io.Serializable;

/* loaded from: classes8.dex */
public final class TB7 implements InterfaceC9173Yu3, Serializable {
    private SA2 a;
    private Object b;

    public TB7(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "initializer");
        this.a = sa2;
        this.b = C17565nA7.a;
    }

    @Override // ir.nasim.InterfaceC9173Yu3
    public Object getValue() {
        if (this.b == C17565nA7.a) {
            SA2 sa2 = this.a;
            AbstractC13042fc3.f(sa2);
            this.b = sa2.invoke();
            this.a = null;
        }
        return this.b;
    }

    @Override // ir.nasim.InterfaceC9173Yu3
    public boolean isInitialized() {
        return this.b != C17565nA7.a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
