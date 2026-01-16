package ir.nasim;

import ir.nasim.AbstractC25167zq5;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* loaded from: classes8.dex */
public final class VY6 implements KSerializer {
    public static final VY6 a = new VY6();
    private static final SerialDescriptor b = new C3858Cq5("kotlin.String", AbstractC25167zq5.i.a);

    private VY6() {
    }

    @Override // ir.nasim.XI1
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String deserialize(Decoder decoder) {
        AbstractC13042fc3.i(decoder, "decoder");
        return decoder.y();
    }

    @Override // ir.nasim.InterfaceC22798vq6
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(Encoder encoder, String str) {
        AbstractC13042fc3.i(encoder, "encoder");
        AbstractC13042fc3.i(str, "value");
        encoder.F(str);
    }

    @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
    public SerialDescriptor getDescriptor() {
        return b;
    }
}
