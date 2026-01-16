package ir.nasim;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* renamed from: ir.nasim.Ef5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC4227Ef5 {
    private static final SerialDescriptor[] a = new SerialDescriptor[0];

    public static final Set a(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "<this>");
        if (serialDescriptor instanceof InterfaceC8886Xt0) {
            return ((InterfaceC8886Xt0) serialDescriptor).a();
        }
        HashSet hashSet = new HashSet(serialDescriptor.d());
        int iD = serialDescriptor.d();
        for (int i = 0; i < iD; i++) {
            hashSet.add(serialDescriptor.e(i));
        }
        return hashSet;
    }

    public static final SerialDescriptor[] b(List list) {
        SerialDescriptor[] serialDescriptorArr;
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            list = null;
        }
        return (list == null || (serialDescriptorArr = (SerialDescriptor[]) list.toArray(new SerialDescriptor[0])) == null) ? a : serialDescriptorArr;
    }
}
