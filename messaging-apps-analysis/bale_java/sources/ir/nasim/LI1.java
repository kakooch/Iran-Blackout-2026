package ir.nasim;

import java.util.Map;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: classes8.dex */
public final class LI1 {
    private final Map a = AbstractC7662Sr1.a(16);

    public static final class a {
    }

    public final Object a(SerialDescriptor serialDescriptor, a aVar) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        AbstractC13042fc3.i(aVar, "key");
        Map map = (Map) this.a.get(serialDescriptor);
        Object obj = map != null ? map.get(aVar) : null;
        if (obj == null) {
            return null;
        }
        return obj;
    }

    public final Object b(SerialDescriptor serialDescriptor, a aVar, SA2 sa2) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        AbstractC13042fc3.i(aVar, "key");
        AbstractC13042fc3.i(sa2, "defaultValue");
        Object objA = a(serialDescriptor, aVar);
        if (objA != null) {
            return objA;
        }
        Object objInvoke = sa2.invoke();
        c(serialDescriptor, aVar, objInvoke);
        return objInvoke;
    }

    public final void c(SerialDescriptor serialDescriptor, a aVar, Object obj) {
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        AbstractC13042fc3.i(aVar, "key");
        AbstractC13042fc3.i(obj, "value");
        Map map = this.a;
        Object objA = map.get(serialDescriptor);
        if (objA == null) {
            objA = AbstractC7662Sr1.a(2);
            map.put(serialDescriptor, objA);
        }
        ((Map) objA).put(aVar, obj);
    }
}
