package ir.nasim;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* renamed from: ir.nasim.lA7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C16383lA7 implements KSerializer {
    public static final C16383lA7 a = new C16383lA7();
    private static final SerialDescriptor b = J73.a("kotlin.ULong", AbstractC18503om0.x(C10237bJ3.a));

    private C16383lA7() {
    }

    public long a(Decoder decoder) {
        AbstractC13042fc3.i(decoder, "decoder");
        return C14599iA7.h(decoder.q(getDescriptor()).m());
    }

    public void b(Encoder encoder, long j) {
        AbstractC13042fc3.i(encoder, "encoder");
        encoder.k(getDescriptor()).l(j);
    }

    @Override // ir.nasim.XI1
    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        return C14599iA7.a(a(decoder));
    }

    @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
    public SerialDescriptor getDescriptor() {
        return b;
    }

    @Override // ir.nasim.InterfaceC22798vq6
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((C14599iA7) obj).q());
    }
}
