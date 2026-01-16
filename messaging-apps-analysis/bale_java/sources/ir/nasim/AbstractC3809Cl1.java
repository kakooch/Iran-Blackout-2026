package ir.nasim;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* renamed from: ir.nasim.Cl1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC3809Cl1 {
    public static final InterfaceC11299cm3 a(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "<this>");
        if (serialDescriptor instanceof C16776lq6) {
            return a(((C16776lq6) serialDescriptor).k());
        }
        return null;
    }

    public static final SerialDescriptor b(AbstractC3859Cq6 abstractC3859Cq6, SerialDescriptor serialDescriptor) {
        KSerializer kSerializerC;
        AbstractC13042fc3.i(abstractC3859Cq6, "<this>");
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        InterfaceC11299cm3 interfaceC11299cm3A = a(serialDescriptor);
        if (interfaceC11299cm3A == null || (kSerializerC = AbstractC3859Cq6.c(abstractC3859Cq6, interfaceC11299cm3A, null, 2, null)) == null) {
            return null;
        }
        return kSerializerC.getDescriptor();
    }
}
