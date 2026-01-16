package ir.nasim;

import ir.nasim.AbstractC25167zq5;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* renamed from: ir.nasim.Az6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C3467Az6 implements KSerializer {
    public static final C3467Az6 a = new C3467Az6();
    private static final SerialDescriptor b = new C3858Cq5("kotlin.Short", AbstractC25167zq5.h.a);

    private C3467Az6() {
    }

    @Override // ir.nasim.XI1
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Short deserialize(Decoder decoder) {
        AbstractC13042fc3.i(decoder, "decoder");
        return Short.valueOf(decoder.s());
    }

    public void b(Encoder encoder, short s) {
        AbstractC13042fc3.i(encoder, "encoder");
        encoder.q(s);
    }

    @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
    public SerialDescriptor getDescriptor() {
        return b;
    }

    @Override // ir.nasim.InterfaceC22798vq6
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((Number) obj).shortValue());
    }
}
