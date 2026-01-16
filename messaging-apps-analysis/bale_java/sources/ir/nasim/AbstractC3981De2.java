package ir.nasim;

import java.util.HashMap;
import java.util.Map;

/* renamed from: ir.nasim.De2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC3981De2 {
    private static final Object a = new Object();
    private static final Map b = new HashMap();

    public static InterfaceC21152tC0 a(Object obj) {
        InterfaceC21152tC0 interfaceC21152tC0;
        synchronized (a) {
            interfaceC21152tC0 = (InterfaceC21152tC0) b.get(obj);
        }
        return interfaceC21152tC0 == null ? InterfaceC21152tC0.a : interfaceC21152tC0;
    }
}
