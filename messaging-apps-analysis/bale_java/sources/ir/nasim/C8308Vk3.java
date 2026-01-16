package ir.nasim;

import ir.nasim.AbstractC19731qq6;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.internal.JsonDecodingException;

/* renamed from: ir.nasim.Vk3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C8308Vk3 implements KSerializer {
    public static final C8308Vk3 a = new C8308Vk3();
    private static final SerialDescriptor b = AbstractC17958nq6.c("kotlinx.serialization.json.JsonNull", AbstractC19731qq6.b.a, new SerialDescriptor[0], null, 8, null);

    private C8308Vk3() {
    }

    @Override // ir.nasim.XI1
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public JsonNull deserialize(Decoder decoder) {
        AbstractC13042fc3.i(decoder, "decoder");
        AbstractC25105zk3.g(decoder);
        if (decoder.C()) {
            throw new JsonDecodingException("Expected 'null' literal");
        }
        decoder.j();
        return JsonNull.INSTANCE;
    }

    @Override // ir.nasim.InterfaceC22798vq6
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(Encoder encoder, JsonNull jsonNull) {
        AbstractC13042fc3.i(encoder, "encoder");
        AbstractC13042fc3.i(jsonNull, "value");
        AbstractC25105zk3.h(encoder);
        encoder.o();
    }

    @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
    public SerialDescriptor getDescriptor() {
        return b;
    }
}
