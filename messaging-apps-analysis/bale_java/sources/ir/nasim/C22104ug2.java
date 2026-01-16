package ir.nasim;

import ir.nasim.C18145o96;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ir.nasim.ug2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C22104ug2 extends C18145o96 {
    private final HashMap e = new HashMap();

    public boolean contains(Object obj) {
        return this.e.containsKey(obj);
    }

    @Override // ir.nasim.C18145o96
    protected C18145o96.c h(Object obj) {
        return (C18145o96.c) this.e.get(obj);
    }

    @Override // ir.nasim.C18145o96
    public Object r(Object obj, Object obj2) {
        C18145o96.c cVarH = h(obj);
        if (cVarH != null) {
            return cVarH.b;
        }
        this.e.put(obj, o(obj, obj2));
        return null;
    }

    @Override // ir.nasim.C18145o96
    public Object t(Object obj) {
        Object objT = super.t(obj);
        this.e.remove(obj);
        return objT;
    }

    public Map.Entry v(Object obj) {
        if (contains(obj)) {
            return ((C18145o96.c) this.e.get(obj)).d;
        }
        return null;
    }
}
