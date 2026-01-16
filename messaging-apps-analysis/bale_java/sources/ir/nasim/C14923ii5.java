package ir.nasim;

import ir.nasim.AbstractC19731qq6;
import ir.nasim.IZ6;
import ir.nasim.InterfaceC4561Fq6;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* renamed from: ir.nasim.ii5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C14923ii5 implements InterfaceC4561Fq6 {
    private final boolean a;
    private final String b;

    public C14923ii5(boolean z, String str) {
        AbstractC13042fc3.i(str, "discriminator");
        this.a = z;
        this.b = str;
    }

    private final void f(SerialDescriptor serialDescriptor, InterfaceC11299cm3 interfaceC11299cm3) {
        int iD = serialDescriptor.d();
        for (int i = 0; i < iD; i++) {
            String strE = serialDescriptor.e(i);
            if (AbstractC13042fc3.d(strE, this.b)) {
                throw new IllegalArgumentException("Polymorphic serializer for " + interfaceC11299cm3 + " has property '" + strE + "' that conflicts with JSON class discriminator. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism");
            }
        }
    }

    private final void g(SerialDescriptor serialDescriptor, InterfaceC11299cm3 interfaceC11299cm3) {
        AbstractC19731qq6 abstractC19731qq6F = serialDescriptor.f();
        if ((abstractC19731qq6F instanceof AbstractC12495ei5) || AbstractC13042fc3.d(abstractC19731qq6F, AbstractC19731qq6.a.a)) {
            throw new IllegalArgumentException("Serializer for " + interfaceC11299cm3.p() + " can't be registered as a subclass for polymorphic serialization because its kind " + abstractC19731qq6F + " is not concrete. To work with multiple hierarchies, register it as a base class.");
        }
        if (this.a) {
            return;
        }
        if (AbstractC13042fc3.d(abstractC19731qq6F, IZ6.b.a) || AbstractC13042fc3.d(abstractC19731qq6F, IZ6.c.a) || (abstractC19731qq6F instanceof AbstractC25167zq5) || (abstractC19731qq6F instanceof AbstractC19731qq6.b)) {
            throw new IllegalArgumentException("Serializer for " + interfaceC11299cm3.p() + " of kind " + abstractC19731qq6F + " cannot be serialized polymorphically with class discriminator.");
        }
    }

    @Override // ir.nasim.InterfaceC4561Fq6
    public void a(InterfaceC11299cm3 interfaceC11299cm3, UA2 ua2) {
        AbstractC13042fc3.i(interfaceC11299cm3, "baseClass");
        AbstractC13042fc3.i(ua2, "defaultDeserializerProvider");
    }

    @Override // ir.nasim.InterfaceC4561Fq6
    public void b(InterfaceC11299cm3 interfaceC11299cm3, UA2 ua2) {
        AbstractC13042fc3.i(interfaceC11299cm3, "baseClass");
        AbstractC13042fc3.i(ua2, "defaultSerializerProvider");
    }

    @Override // ir.nasim.InterfaceC4561Fq6
    public void c(InterfaceC11299cm3 interfaceC11299cm3, UA2 ua2) {
        AbstractC13042fc3.i(interfaceC11299cm3, "kClass");
        AbstractC13042fc3.i(ua2, "provider");
    }

    @Override // ir.nasim.InterfaceC4561Fq6
    public void d(InterfaceC11299cm3 interfaceC11299cm3, InterfaceC11299cm3 interfaceC11299cm32, KSerializer kSerializer) {
        AbstractC13042fc3.i(interfaceC11299cm3, "baseClass");
        AbstractC13042fc3.i(interfaceC11299cm32, "actualClass");
        AbstractC13042fc3.i(kSerializer, "actualSerializer");
        SerialDescriptor descriptor = kSerializer.getDescriptor();
        g(descriptor, interfaceC11299cm32);
        if (this.a) {
            return;
        }
        f(descriptor, interfaceC11299cm32);
    }

    @Override // ir.nasim.InterfaceC4561Fq6
    public void e(InterfaceC11299cm3 interfaceC11299cm3, KSerializer kSerializer) {
        InterfaceC4561Fq6.a.a(this, interfaceC11299cm3, kSerializer);
    }
}
