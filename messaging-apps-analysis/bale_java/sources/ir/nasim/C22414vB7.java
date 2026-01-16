package ir.nasim;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* renamed from: ir.nasim.vB7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C22414vB7 implements KSerializer {
    public static final C22414vB7 b = new C22414vB7();
    private final /* synthetic */ AG4 a = new AG4("kotlin.Unit", C19938rB7.a);

    private C22414vB7() {
    }

    public void a(Decoder decoder) {
        AbstractC13042fc3.i(decoder, "decoder");
        this.a.deserialize(decoder);
    }

    @Override // ir.nasim.InterfaceC22798vq6
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(Encoder encoder, C19938rB7 c19938rB7) {
        AbstractC13042fc3.i(encoder, "encoder");
        AbstractC13042fc3.i(c19938rB7, "value");
        this.a.serialize(encoder, c19938rB7);
    }

    @Override // ir.nasim.XI1
    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        a(decoder);
        return C19938rB7.a;
    }

    @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
    public SerialDescriptor getDescriptor() {
        return this.a.getDescriptor();
    }
}
