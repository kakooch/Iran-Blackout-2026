package ir.nasim;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* loaded from: classes8.dex */
public final class CA7 implements KSerializer {
    public static final CA7 a = new CA7();
    private static final SerialDescriptor b = J73.a("kotlin.UShort", AbstractC18503om0.y(C24660yz6.a));

    private CA7() {
    }

    public short a(Decoder decoder) {
        AbstractC13042fc3.i(decoder, "decoder");
        return C24771zA7.h(decoder.q(getDescriptor()).s());
    }

    public void b(Encoder encoder, short s) {
        AbstractC13042fc3.i(encoder, "encoder");
        encoder.k(getDescriptor()).q(s);
    }

    @Override // ir.nasim.XI1
    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        return C24771zA7.a(a(decoder));
    }

    @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
    public SerialDescriptor getDescriptor() {
        return b;
    }

    @Override // ir.nasim.InterfaceC22798vq6
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((C24771zA7) obj).p());
    }
}
