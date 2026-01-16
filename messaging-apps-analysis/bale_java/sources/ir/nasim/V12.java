package ir.nasim;

import ir.nasim.AbstractC25167zq5;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* loaded from: classes8.dex */
public final class V12 implements KSerializer {
    public static final V12 a = new V12();
    private static final SerialDescriptor b = new C3858Cq5("kotlin.time.Duration", AbstractC25167zq5.i.a);

    private V12() {
    }

    public long a(Decoder decoder) {
        AbstractC13042fc3.i(decoder, "decoder");
        return Q12.b.d(decoder.y());
    }

    public void b(Encoder encoder, long j) {
        AbstractC13042fc3.i(encoder, "encoder");
        encoder.F(Q12.Q(j));
    }

    @Override // ir.nasim.XI1
    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        return Q12.p(a(decoder));
    }

    @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
    public SerialDescriptor getDescriptor() {
        return b;
    }

    @Override // ir.nasim.InterfaceC22798vq6
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((Q12) obj).U());
    }
}
