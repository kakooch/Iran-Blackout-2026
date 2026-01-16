package ir.nasim;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* renamed from: ir.nasim.gA7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C13410gA7 implements KSerializer {
    public static final C13410gA7 a = new C13410gA7();
    private static final SerialDescriptor b = J73.a("kotlin.UInt", AbstractC18503om0.w(C15431ja3.a));

    private C13410gA7() {
    }

    public int a(Decoder decoder) {
        AbstractC13042fc3.i(decoder, "decoder");
        return C11540dA7.h(decoder.q(getDescriptor()).h());
    }

    public void b(Encoder encoder, int i) {
        AbstractC13042fc3.i(encoder, "encoder");
        encoder.k(getDescriptor()).A(i);
    }

    @Override // ir.nasim.XI1
    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        return C11540dA7.a(a(decoder));
    }

    @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
    public SerialDescriptor getDescriptor() {
        return b;
    }

    @Override // ir.nasim.InterfaceC22798vq6
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((C11540dA7) obj).p());
    }
}
