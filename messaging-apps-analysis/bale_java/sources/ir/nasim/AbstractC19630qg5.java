package ir.nasim;

import java.util.Arrays;
import java.util.Iterator;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* renamed from: ir.nasim.qg5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC19630qg5 {
    public static final int a(SerialDescriptor serialDescriptor, SerialDescriptor[] serialDescriptorArr) {
        AbstractC13042fc3.i(serialDescriptor, "<this>");
        AbstractC13042fc3.i(serialDescriptorArr, "typeParams");
        int iHashCode = (serialDescriptor.i().hashCode() * 31) + Arrays.hashCode(serialDescriptorArr);
        Iterable iterableA = AbstractC17367mq6.a(serialDescriptor);
        Iterator it = iterableA.iterator();
        int iHashCode2 = 1;
        int i = 1;
        while (true) {
            int iHashCode3 = 0;
            if (!it.hasNext()) {
                break;
            }
            int i2 = i * 31;
            String strI = ((SerialDescriptor) it.next()).i();
            if (strI != null) {
                iHashCode3 = strI.hashCode();
            }
            i = i2 + iHashCode3;
        }
        Iterator it2 = iterableA.iterator();
        while (it2.hasNext()) {
            int i3 = iHashCode2 * 31;
            AbstractC19731qq6 abstractC19731qq6F = ((SerialDescriptor) it2.next()).f();
            iHashCode2 = i3 + (abstractC19731qq6F != null ? abstractC19731qq6F.hashCode() : 0);
        }
        return (((iHashCode * 31) + i) * 31) + iHashCode2;
    }
}
