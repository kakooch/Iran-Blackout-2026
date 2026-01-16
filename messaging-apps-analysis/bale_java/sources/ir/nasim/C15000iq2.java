package ir.nasim;

import ir.nasim.AbstractC25167zq5;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* renamed from: ir.nasim.iq2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C15000iq2 implements KSerializer {
    public static final C15000iq2 a = new C15000iq2();
    private static final SerialDescriptor b = new C3858Cq5("kotlin.Float", AbstractC25167zq5.e.a);

    private C15000iq2() {
    }

    @Override // ir.nasim.XI1
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float deserialize(Decoder decoder) {
        AbstractC13042fc3.i(decoder, "decoder");
        return Float.valueOf(decoder.t());
    }

    public void b(Encoder encoder, float f) {
        AbstractC13042fc3.i(encoder, "encoder");
        encoder.t(f);
    }

    @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
    public SerialDescriptor getDescriptor() {
        return b;
    }

    @Override // ir.nasim.InterfaceC22798vq6
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((Number) obj).floatValue());
    }
}
