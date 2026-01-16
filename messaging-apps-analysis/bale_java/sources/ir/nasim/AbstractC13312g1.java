package ir.nasim;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.g1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC13312g1 extends AbstractC14496i1 implements TB3 {
    protected AbstractC13312g1(Map map) {
        super(map);
    }

    @Override // ir.nasim.AbstractC14496i1
    Collection G(Collection collection) {
        return Collections.unmodifiableList((List) collection);
    }

    @Override // ir.nasim.AbstractC14496i1
    Collection H(Object obj, Collection collection) {
        return J(obj, (List) collection, null);
    }

    @Override // ir.nasim.AbstractC18649p1, ir.nasim.InterfaceC7143Ql4
    public Map b() {
        return super.b();
    }

    @Override // ir.nasim.AbstractC18649p1
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // ir.nasim.AbstractC14496i1, ir.nasim.InterfaceC7143Ql4
    public boolean put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }

    @Override // ir.nasim.AbstractC14496i1, ir.nasim.InterfaceC7143Ql4
    public List get(Object obj) {
        return (List) super.get(obj);
    }
}
