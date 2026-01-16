package ir.nasim;

import ir.nasim.AbstractC25167zq5;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* renamed from: ir.nasim.lX1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C16584lX1 implements KSerializer {
    public static final C16584lX1 a = new C16584lX1();
    private static final SerialDescriptor b = new C3858Cq5("kotlin.Double", AbstractC25167zq5.d.a);

    private C16584lX1() {
    }

    @Override // ir.nasim.XI1
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Double deserialize(Decoder decoder) {
        AbstractC13042fc3.i(decoder, "decoder");
        return Double.valueOf(decoder.v());
    }

    public void b(Encoder encoder, double d) {
        AbstractC13042fc3.i(encoder, "encoder");
        encoder.f(d);
    }

    @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
    public SerialDescriptor getDescriptor() {
        return b;
    }

    @Override // ir.nasim.InterfaceC22798vq6
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((Number) obj).doubleValue());
    }
}
