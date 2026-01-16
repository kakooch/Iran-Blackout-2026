package ir.nasim;

import ir.nasim.AbstractC25167zq5;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* renamed from: ir.nasim.gK0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C13493gK0 implements KSerializer {
    public static final C13493gK0 a = new C13493gK0();
    private static final SerialDescriptor b = new C3858Cq5("kotlin.Char", AbstractC25167zq5.c.a);

    private C13493gK0() {
    }

    @Override // ir.nasim.XI1
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Character deserialize(Decoder decoder) {
        AbstractC13042fc3.i(decoder, "decoder");
        return Character.valueOf(decoder.x());
    }

    public void b(Encoder encoder, char c) {
        AbstractC13042fc3.i(encoder, "encoder");
        encoder.u(c);
    }

    @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
    public SerialDescriptor getDescriptor() {
        return b;
    }

    @Override // ir.nasim.InterfaceC22798vq6
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((Character) obj).charValue());
    }
}
