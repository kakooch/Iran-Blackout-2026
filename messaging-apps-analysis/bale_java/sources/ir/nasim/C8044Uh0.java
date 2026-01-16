package ir.nasim;

import ir.nasim.AbstractC25167zq5;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* renamed from: ir.nasim.Uh0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C8044Uh0 implements KSerializer {
    public static final C8044Uh0 a = new C8044Uh0();
    private static final SerialDescriptor b = new C3858Cq5("kotlin.Boolean", AbstractC25167zq5.a.a);

    private C8044Uh0() {
    }

    @Override // ir.nasim.XI1
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean deserialize(Decoder decoder) {
        AbstractC13042fc3.i(decoder, "decoder");
        return Boolean.valueOf(decoder.w());
    }

    public void b(Encoder encoder, boolean z) {
        AbstractC13042fc3.i(encoder, "encoder");
        encoder.r(z);
    }

    @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
    public SerialDescriptor getDescriptor() {
        return b;
    }

    @Override // ir.nasim.InterfaceC22798vq6
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((Boolean) obj).booleanValue());
    }
}
