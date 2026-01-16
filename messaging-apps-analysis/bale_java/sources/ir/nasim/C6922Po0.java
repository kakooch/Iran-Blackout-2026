package ir.nasim;

import ir.nasim.AbstractC25167zq5;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* renamed from: ir.nasim.Po0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C6922Po0 implements KSerializer {
    public static final C6922Po0 a = new C6922Po0();
    private static final SerialDescriptor b = new C3858Cq5("kotlin.Byte", AbstractC25167zq5.b.a);

    private C6922Po0() {
    }

    @Override // ir.nasim.XI1
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Byte deserialize(Decoder decoder) {
        AbstractC13042fc3.i(decoder, "decoder");
        return Byte.valueOf(decoder.G());
    }

    public void b(Encoder encoder, byte b2) {
        AbstractC13042fc3.i(encoder, "encoder");
        encoder.g(b2);
    }

    @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
    public SerialDescriptor getDescriptor() {
        return b;
    }

    @Override // ir.nasim.InterfaceC22798vq6
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((Number) obj).byteValue());
    }
}
