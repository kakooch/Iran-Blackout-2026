package ir.nasim;

import ir.nasim.AbstractC25167zq5;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* renamed from: ir.nasim.rJ3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C20006rJ3 implements KSerializer {
    public static final C20006rJ3 a = new C20006rJ3();
    private static final SerialDescriptor b = new C3858Cq5("kotlin.Long", AbstractC25167zq5.g.a);

    private C20006rJ3() {
    }

    @Override // ir.nasim.XI1
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Long deserialize(Decoder decoder) {
        AbstractC13042fc3.i(decoder, "decoder");
        return Long.valueOf(decoder.m());
    }

    public void b(Encoder encoder, long j) {
        AbstractC13042fc3.i(encoder, "encoder");
        encoder.l(j);
    }

    @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
    public SerialDescriptor getDescriptor() {
        return b;
    }

    @Override // ir.nasim.InterfaceC22798vq6
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((Number) obj).longValue());
    }
}
