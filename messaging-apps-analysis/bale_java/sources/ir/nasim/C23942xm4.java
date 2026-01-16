package ir.nasim;

import ir.nasim.InterfaceC20297rm3;
import java.util.Map;

/* renamed from: ir.nasim.xm4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C23942xm4 extends QN3 implements Map.Entry, InterfaceC20297rm3.a {
    private final C12722f55 c;
    private Object d;

    public C23942xm4(C12722f55 c12722f55, Object obj, Object obj2) {
        super(obj, obj2);
        this.c = c12722f55;
        this.d = obj2;
    }

    public void b(Object obj) {
        this.d = obj;
    }

    @Override // ir.nasim.QN3, java.util.Map.Entry
    public Object getValue() {
        return this.d;
    }

    @Override // ir.nasim.QN3, java.util.Map.Entry
    public Object setValue(Object obj) {
        Object value = getValue();
        b(obj);
        this.c.c(getKey(), obj);
        return value;
    }
}
