package ir.nasim;

import ir.nasim.AbstractC19731qq6;
import ir.nasim.IZ6;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: classes8.dex */
public abstract class Hb8 {
    public static final SerialDescriptor a(SerialDescriptor serialDescriptor, AbstractC3859Cq6 abstractC3859Cq6) {
        SerialDescriptor serialDescriptorA;
        AbstractC13042fc3.i(serialDescriptor, "<this>");
        AbstractC13042fc3.i(abstractC3859Cq6, "module");
        if (!AbstractC13042fc3.d(serialDescriptor.f(), AbstractC19731qq6.a.a)) {
            return serialDescriptor.isInline() ? a(serialDescriptor.h(0), abstractC3859Cq6) : serialDescriptor;
        }
        SerialDescriptor serialDescriptorB = AbstractC3809Cl1.b(abstractC3859Cq6, serialDescriptor);
        return (serialDescriptorB == null || (serialDescriptorA = a(serialDescriptorB, abstractC3859Cq6)) == null) ? serialDescriptor : serialDescriptorA;
    }

    public static final Gb8 b(AbstractC11279ck3 abstractC11279ck3, SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(abstractC11279ck3, "<this>");
        AbstractC13042fc3.i(serialDescriptor, "desc");
        AbstractC19731qq6 abstractC19731qq6F = serialDescriptor.f();
        if (abstractC19731qq6F instanceof AbstractC12495ei5) {
            return Gb8.f;
        }
        if (AbstractC13042fc3.d(abstractC19731qq6F, IZ6.b.a)) {
            return Gb8.d;
        }
        if (!AbstractC13042fc3.d(abstractC19731qq6F, IZ6.c.a)) {
            return Gb8.c;
        }
        SerialDescriptor serialDescriptorA = a(serialDescriptor.h(0), abstractC11279ck3.a());
        AbstractC19731qq6 abstractC19731qq6F2 = serialDescriptorA.f();
        if ((abstractC19731qq6F2 instanceof AbstractC25167zq5) || AbstractC13042fc3.d(abstractC19731qq6F2, AbstractC19731qq6.b.a)) {
            return Gb8.e;
        }
        if (abstractC11279ck3.d().b()) {
            return Gb8.d;
        }
        throw AbstractC3802Ck3.c(serialDescriptorA);
    }
}
