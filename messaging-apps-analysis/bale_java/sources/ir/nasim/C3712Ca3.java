package ir.nasim;

import ir.nasim.AbstractC25167zq5;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* renamed from: ir.nasim.Ca3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C3712Ca3 implements KSerializer {
    public static final C3712Ca3 a = new C3712Ca3();
    private static final SerialDescriptor b = new C3858Cq5("kotlin.Int", AbstractC25167zq5.f.a);

    private C3712Ca3() {
    }

    @Override // ir.nasim.XI1
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer deserialize(Decoder decoder) {
        AbstractC13042fc3.i(decoder, "decoder");
        return Integer.valueOf(decoder.h());
    }

    public void b(Encoder encoder, int i) {
        AbstractC13042fc3.i(encoder, "encoder");
        encoder.A(i);
    }

    @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
    public SerialDescriptor getDescriptor() {
        return b;
    }

    @Override // ir.nasim.InterfaceC22798vq6
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((Number) obj).intValue());
    }
}
