package ir.nasim;

import ir.nasim.AbstractC19731qq6;
import java.lang.annotation.Annotation;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* renamed from: ir.nasim.fi5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC13131fi5 {

    /* renamed from: ir.nasim.fi5$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC24354yU0.values().length];
            try {
                iArr[EnumC24354yU0.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC24354yU0.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC24354yU0.b.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public static final void b(AbstractC19731qq6 abstractC19731qq6) {
        AbstractC13042fc3.i(abstractC19731qq6, "kind");
        if (abstractC19731qq6 instanceof AbstractC19731qq6.b) {
            throw new IllegalStateException("Enums cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead".toString());
        }
        if (abstractC19731qq6 instanceof AbstractC25167zq5) {
            throw new IllegalStateException("Primitives cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead".toString());
        }
        if (abstractC19731qq6 instanceof AbstractC12495ei5) {
            throw new IllegalStateException("Actual serializer for polymorphic cannot be polymorphic itself".toString());
        }
    }

    public static final String c(SerialDescriptor serialDescriptor, AbstractC11279ck3 abstractC11279ck3) {
        AbstractC13042fc3.i(serialDescriptor, "<this>");
        AbstractC13042fc3.i(abstractC11279ck3, "json");
        for (Annotation annotation : serialDescriptor.getAnnotations()) {
            if (annotation instanceof InterfaceC14941ik3) {
                return ((InterfaceC14941ik3) annotation).discriminator();
            }
        }
        return abstractC11279ck3.d().d();
    }

    public static final Object d(InterfaceC20277rk3 interfaceC20277rk3, XI1 xi1) {
        JsonPrimitive jsonPrimitiveH;
        AbstractC13042fc3.i(interfaceC20277rk3, "<this>");
        AbstractC13042fc3.i(xi1, "deserializer");
        if (!(xi1 instanceof AbstractC24673z1) || interfaceC20277rk3.d().d().o()) {
            return xi1.deserialize(interfaceC20277rk3);
        }
        String strC = c(xi1.getDescriptor(), interfaceC20277rk3.d());
        JsonElement jsonElementG = interfaceC20277rk3.g();
        SerialDescriptor descriptor = xi1.getDescriptor();
        if (!(jsonElementG instanceof JsonObject)) {
            throw AbstractC3802Ck3.d(-1, "Expected " + AbstractC10882cM5.b(JsonObject.class) + " as the serialized body of " + descriptor.i() + ", but had " + AbstractC10882cM5.b(jsonElementG.getClass()));
        }
        JsonObject jsonObject = (JsonObject) jsonElementG;
        JsonElement jsonElement = (JsonElement) jsonObject.get(strC);
        try {
            XI1 xi1A = AbstractC14313hi5.a((AbstractC24673z1) xi1, interfaceC20277rk3, (jsonElement == null || (jsonPrimitiveH = AbstractC23331wk3.h(jsonElement)) == null) ? null : AbstractC23331wk3.d(jsonPrimitiveH));
            AbstractC13042fc3.g(xi1A, "null cannot be cast to non-null type kotlinx.serialization.DeserializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.decodeSerializableValuePolymorphic>");
            return AbstractC9420Zv7.a(interfaceC20277rk3.d(), strC, jsonObject, xi1A);
        } catch (SerializationException e) {
            String message = e.getMessage();
            AbstractC13042fc3.f(message);
            throw AbstractC3802Ck3.e(-1, message, jsonObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(InterfaceC22798vq6 interfaceC22798vq6, InterfaceC22798vq6 interfaceC22798vq62, String str) {
        if ((interfaceC22798vq6 instanceof C4219Ee6) && AbstractC4753Gk3.a(interfaceC22798vq62.getDescriptor()).contains(str)) {
            String strI = interfaceC22798vq6.getDescriptor().i();
            throw new IllegalStateException(("Sealed class '" + interfaceC22798vq62.getDescriptor().i() + "' cannot be serialized as base class '" + strI + "' because it has property name that conflicts with JSON class discriminator '" + str + "'. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism").toString());
        }
    }
}
