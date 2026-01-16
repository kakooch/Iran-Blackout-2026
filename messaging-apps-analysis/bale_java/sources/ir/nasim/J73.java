package ir.nasim;

import ir.nasim.NE2;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.InlineClassDescriptor;

/* loaded from: classes8.dex */
public abstract class J73 {

    public static final class a implements NE2 {
        final /* synthetic */ KSerializer a;

        a(KSerializer kSerializer) {
            this.a = kSerializer;
        }

        @Override // ir.nasim.NE2
        public KSerializer[] childSerializers() {
            return new KSerializer[]{this.a};
        }

        @Override // ir.nasim.XI1
        public Object deserialize(Decoder decoder) {
            AbstractC13042fc3.i(decoder, "decoder");
            throw new IllegalStateException("unsupported".toString());
        }

        @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
        public SerialDescriptor getDescriptor() {
            throw new IllegalStateException("unsupported".toString());
        }

        @Override // ir.nasim.InterfaceC22798vq6
        public void serialize(Encoder encoder, Object obj) {
            AbstractC13042fc3.i(encoder, "encoder");
            throw new IllegalStateException("unsupported".toString());
        }

        @Override // ir.nasim.NE2
        public KSerializer[] typeParametersSerializers() {
            return NE2.a.a(this);
        }
    }

    public static final SerialDescriptor a(String str, KSerializer kSerializer) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(kSerializer, "primitiveSerializer");
        return new InlineClassDescriptor(str, new a(kSerializer));
    }
}
