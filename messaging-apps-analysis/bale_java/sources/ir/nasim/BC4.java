package ir.nasim;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* loaded from: classes8.dex */
public final class BC4 implements KSerializer {
    public static final BC4 a = new BC4();
    private static final SerialDescriptor b = AC4.a;

    private BC4() {
    }

    @Override // ir.nasim.XI1
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void deserialize(Decoder decoder) {
        AbstractC13042fc3.i(decoder, "decoder");
        throw new SerializationException("'kotlin.Nothing' does not have instances");
    }

    @Override // ir.nasim.InterfaceC22798vq6
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(Encoder encoder, Void r3) {
        AbstractC13042fc3.i(encoder, "encoder");
        AbstractC13042fc3.i(r3, "value");
        throw new SerializationException("'kotlin.Nothing' cannot be serialized");
    }

    @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
    public SerialDescriptor getDescriptor() {
        return b;
    }
}
