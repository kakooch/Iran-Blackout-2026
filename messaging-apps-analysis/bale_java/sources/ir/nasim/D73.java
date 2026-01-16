package ir.nasim;

import java.io.Serializable;

/* loaded from: classes8.dex */
public final class D73 implements InterfaceC9173Yu3, Serializable {
    private final Object a;

    public D73(Object obj) {
        this.a = obj;
    }

    @Override // ir.nasim.InterfaceC9173Yu3
    public Object getValue() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC9173Yu3
    public boolean isInitialized() {
        return true;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
