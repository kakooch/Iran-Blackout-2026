package ir.nasim;

import kotlin.KotlinNothingValueException;
import kotlinx.serialization.SerializationException;

/* loaded from: classes8.dex */
public abstract class A1 {
    public static final Void a(InterfaceC11299cm3 interfaceC11299cm3, InterfaceC11299cm3 interfaceC11299cm32) {
        AbstractC13042fc3.i(interfaceC11299cm3, "subClass");
        AbstractC13042fc3.i(interfaceC11299cm32, "baseClass");
        String strP = interfaceC11299cm3.p();
        if (strP == null) {
            strP = String.valueOf(interfaceC11299cm3);
        }
        b(strP, interfaceC11299cm32);
        throw new KotlinNothingValueException();
    }

    public static final Void b(String str, InterfaceC11299cm3 interfaceC11299cm3) {
        String str2;
        AbstractC13042fc3.i(interfaceC11299cm3, "baseClass");
        String str3 = "in the polymorphic scope of '" + interfaceC11299cm3.p() + '\'';
        if (str == null) {
            str2 = "Class discriminator was missing and no default serializers were registered " + str3 + '.';
        } else {
            str2 = "Serializer for subclass '" + str + "' is not found " + str3 + ".\nCheck if class with serial name '" + str + "' exists and serializer is registered in a corresponding SerializersModule.\nTo be registered automatically, class '" + str + "' has to be '@Serializable', and the base class '" + interfaceC11299cm3.p() + "' has to be sealed and '@Serializable'.";
        }
        throw new SerializationException(str2);
    }
}
