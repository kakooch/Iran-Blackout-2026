package ir.nasim;

import ir.nasim.AbstractC25167zq5;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonPrimitive;

/* renamed from: ir.nasim.cl3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C11289cl3 implements KSerializer {
    public static final C11289cl3 a = new C11289cl3();
    private static final SerialDescriptor b = AbstractC17958nq6.c("kotlinx.serialization.json.JsonPrimitive", AbstractC25167zq5.i.a, new SerialDescriptor[0], null, 8, null);

    private C11289cl3() {
    }

    @Override // ir.nasim.XI1
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public JsonPrimitive deserialize(Decoder decoder) {
        AbstractC13042fc3.i(decoder, "decoder");
        JsonElement jsonElementG = AbstractC25105zk3.d(decoder).g();
        if (jsonElementG instanceof JsonPrimitive) {
            return (JsonPrimitive) jsonElementG;
        }
        throw AbstractC3802Ck3.e(-1, "Unexpected JSON element, expected JsonPrimitive, had " + AbstractC10882cM5.b(jsonElementG.getClass()), jsonElementG.toString());
    }

    @Override // ir.nasim.InterfaceC22798vq6
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(Encoder encoder, JsonPrimitive jsonPrimitive) {
        AbstractC13042fc3.i(encoder, "encoder");
        AbstractC13042fc3.i(jsonPrimitive, "value");
        AbstractC25105zk3.h(encoder);
        if (jsonPrimitive instanceof JsonNull) {
            encoder.h(C8308Vk3.a, JsonNull.INSTANCE);
        } else {
            encoder.h(C5455Jk3.a, (C5221Ik3) jsonPrimitive);
        }
    }

    @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
    public SerialDescriptor getDescriptor() {
        return b;
    }
}
