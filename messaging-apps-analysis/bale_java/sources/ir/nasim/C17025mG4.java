package ir.nasim;

import java.util.concurrent.ConcurrentHashMap;

/* renamed from: ir.nasim.mG4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C17025mG4 extends ConcurrentHashMap {
    public Object b(Object obj) {
        return super.get(obj);
    }

    public void c(Object obj, Object obj2) {
        if (super.containsKey(obj)) {
            return;
        }
        super.put(obj, obj2);
    }

    public void d(Object obj, Object obj2) {
        super.put(obj, obj2);
    }

    public void e(Object obj) {
        super.remove(obj);
    }
}
