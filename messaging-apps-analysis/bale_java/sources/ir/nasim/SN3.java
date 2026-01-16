package ir.nasim;

import java.util.Map;

/* loaded from: classes.dex */
final class SN3 implements Map.Entry, InterfaceC17915nm3 {
    private final Object a;
    private final Object b;

    public SN3(Object obj, Object obj2) {
        this.a = obj;
        this.b = obj2;
    }

    @Override // java.util.Map.Entry
    public Object getKey() {
        return this.a;
    }

    @Override // java.util.Map.Entry
    public Object getValue() {
        return this.b;
    }

    @Override // java.util.Map.Entry
    public Object setValue(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
