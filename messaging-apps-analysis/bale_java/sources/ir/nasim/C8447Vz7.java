package ir.nasim;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* renamed from: ir.nasim.Vz7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C8447Vz7 implements KSerializer {
    public static final C8447Vz7 a = new C8447Vz7();
    private static final SerialDescriptor b = J73.a("kotlin.UByte", AbstractC18503om0.r(C5488Jo0.a));

    private C8447Vz7() {
    }

    public byte a(Decoder decoder) {
        AbstractC13042fc3.i(decoder, "decoder");
        return C7743Sz7.h(decoder.q(getDescriptor()).G());
    }

    public void b(Encoder encoder, byte b2) {
        AbstractC13042fc3.i(encoder, "encoder");
        encoder.k(getDescriptor()).g(b2);
    }

    @Override // ir.nasim.XI1
    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        return C7743Sz7.a(a(decoder));
    }

    @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
    public SerialDescriptor getDescriptor() {
        return b;
    }

    @Override // ir.nasim.InterfaceC22798vq6
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((C7743Sz7) obj).p());
    }
}
