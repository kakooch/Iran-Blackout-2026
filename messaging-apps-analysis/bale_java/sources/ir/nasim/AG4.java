package ir.nasim;

import ir.nasim.IZ6;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* loaded from: classes8.dex */
public final class AG4 implements KSerializer {
    private final Object a;
    private List b;
    private final InterfaceC9173Yu3 c;

    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ String e;
        final /* synthetic */ AG4 f;

        /* renamed from: ir.nasim.AG4$a$a, reason: collision with other inner class name */
        static final class C0258a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ AG4 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0258a(AG4 ag4) {
                super(1);
                this.e = ag4;
            }

            public final void a(FU0 fu0) {
                AbstractC13042fc3.i(fu0, "$this$buildSerialDescriptor");
                fu0.h(this.e.b);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((FU0) obj);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, AG4 ag4) {
            super(0);
            this.e = str;
            this.f = ag4;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SerialDescriptor invoke() {
            return AbstractC17958nq6.b(this.e, IZ6.d.a, new SerialDescriptor[0], new C0258a(this.f));
        }
    }

    public AG4(String str, Object obj) {
        AbstractC13042fc3.i(str, "serialName");
        AbstractC13042fc3.i(obj, "objectInstance");
        this.a = obj;
        this.b = AbstractC10360bX0.m();
        this.c = AbstractC13269fw3.b(EnumC4870Gx3.b, new a(str, this));
    }

    @Override // ir.nasim.XI1
    public Object deserialize(Decoder decoder) {
        int iO;
        AbstractC13042fc3.i(decoder, "decoder");
        SerialDescriptor descriptor = getDescriptor();
        kotlinx.serialization.encoding.c cVarB = decoder.b(descriptor);
        if (cVarB.p() || (iO = cVarB.o(getDescriptor())) == -1) {
            C19938rB7 c19938rB7 = C19938rB7.a;
            cVarB.c(descriptor);
            return this.a;
        }
        throw new SerializationException("Unexpected index " + iO);
    }

    @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.c.getValue();
    }

    @Override // ir.nasim.InterfaceC22798vq6
    public void serialize(Encoder encoder, Object obj) {
        AbstractC13042fc3.i(encoder, "encoder");
        AbstractC13042fc3.i(obj, "value");
        encoder.b(getDescriptor()).c(getDescriptor());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AG4(String str, Object obj, Annotation[] annotationArr) {
        this(str, obj);
        AbstractC13042fc3.i(str, "serialName");
        AbstractC13042fc3.i(obj, "objectInstance");
        AbstractC13042fc3.i(annotationArr, "classAnnotations");
        this.b = AbstractC9648aK.d(annotationArr);
    }
}
