package ir.nasim;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* renamed from: ir.nasim.tF4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C21183tF4 implements KSerializer {
    private final KSerializer a;
    private final SerialDescriptor b;

    public C21183tF4(KSerializer kSerializer) {
        AbstractC13042fc3.i(kSerializer, "serializer");
        this.a = kSerializer;
        this.b = new C16776lq6(kSerializer.getDescriptor());
    }

    @Override // ir.nasim.XI1
    public Object deserialize(Decoder decoder) {
        AbstractC13042fc3.i(decoder, "decoder");
        return decoder.C() ? decoder.k(this.a) : decoder.j();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && C21183tF4.class == obj.getClass() && AbstractC13042fc3.d(this.a, ((C21183tF4) obj).a);
    }

    @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
    public SerialDescriptor getDescriptor() {
        return this.b;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // ir.nasim.InterfaceC22798vq6
    public void serialize(Encoder encoder, Object obj) {
        AbstractC13042fc3.i(encoder, "encoder");
        if (obj == null) {
            encoder.o();
        } else {
            encoder.v();
            encoder.h(this.a, obj);
        }
    }
}
