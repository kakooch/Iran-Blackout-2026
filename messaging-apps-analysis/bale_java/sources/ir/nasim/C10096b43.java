package ir.nasim;

import java.io.Serializable;

/* renamed from: ir.nasim.b43, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C10096b43 extends AbstractC16285l1 implements Serializable {
    final Object a;
    final Object b;

    C10096b43(Object obj, Object obj2) {
        this.a = obj;
        this.b = obj2;
    }

    @Override // ir.nasim.AbstractC16285l1, java.util.Map.Entry
    public final Object getKey() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC16285l1, java.util.Map.Entry
    public final Object getValue() {
        return this.b;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }
}
