package ir.nasim;

import java.util.Arrays;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* loaded from: classes8.dex */
public final class L92 implements KSerializer {
    private final Enum[] a;
    private SerialDescriptor b;
    private final InterfaceC9173Yu3 c;

    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str) {
            super(0);
            this.f = str;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SerialDescriptor invoke() {
            SerialDescriptor serialDescriptor = L92.this.b;
            return serialDescriptor == null ? L92.this.c(this.f) : serialDescriptor;
        }
    }

    public L92(String str, Enum[] enumArr) {
        AbstractC13042fc3.i(str, "serialName");
        AbstractC13042fc3.i(enumArr, "values");
        this.a = enumArr;
        this.c = AbstractC13269fw3.a(new a(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SerialDescriptor c(String str) {
        E92 e92 = new E92(str, this.a.length);
        for (Enum r0 : this.a) {
            PluginGeneratedSerialDescriptor.m(e92, r0.name(), false, 2, null);
        }
        return e92;
    }

    @Override // ir.nasim.XI1
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Enum deserialize(Decoder decoder) {
        AbstractC13042fc3.i(decoder, "decoder");
        int iE = decoder.e(getDescriptor());
        if (iE >= 0) {
            Enum[] enumArr = this.a;
            if (iE < enumArr.length) {
                return enumArr[iE];
            }
        }
        throw new SerializationException(iE + " is not among valid " + getDescriptor().i() + " enum values, values size is " + this.a.length);
    }

    @Override // ir.nasim.InterfaceC22798vq6
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void serialize(Encoder encoder, Enum r4) {
        AbstractC13042fc3.i(encoder, "encoder");
        AbstractC13042fc3.i(r4, "value");
        int iS0 = AbstractC10242bK.s0(this.a, r4);
        if (iS0 != -1) {
            encoder.j(getDescriptor(), iS0);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(r4);
        sb.append(" is not a valid enum ");
        sb.append(getDescriptor().i());
        sb.append(", must be one of ");
        String string = Arrays.toString(this.a);
        AbstractC13042fc3.h(string, "toString(...)");
        sb.append(string);
        throw new SerializationException(sb.toString());
    }

    @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.c.getValue();
    }

    public String toString() {
        return "kotlinx.serialization.internal.EnumSerializer<" + getDescriptor().i() + '>';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public L92(String str, Enum[] enumArr, SerialDescriptor serialDescriptor) {
        this(str, enumArr);
        AbstractC13042fc3.i(str, "serialName");
        AbstractC13042fc3.i(enumArr, "values");
        AbstractC13042fc3.i(serialDescriptor, "descriptor");
        this.b = serialDescriptor;
    }
}
