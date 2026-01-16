package ir.nasim;

import java.util.Iterator;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* renamed from: ir.nasim.wq5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC23393wq5 extends RW0 {
    private final SerialDescriptor b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC23393wq5(KSerializer kSerializer) {
        super(kSerializer, null);
        AbstractC13042fc3.i(kSerializer, "primitiveSerializer");
        this.b = new C22797vq5(kSerializer.getDescriptor());
    }

    @Override // ir.nasim.H0
    protected final Iterator d(Object obj) {
        throw new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead".toString());
    }

    @Override // ir.nasim.H0, ir.nasim.XI1
    public final Object deserialize(Decoder decoder) {
        AbstractC13042fc3.i(decoder, "decoder");
        return f(decoder, null);
    }

    @Override // ir.nasim.RW0, kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
    public final SerialDescriptor getDescriptor() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public final AbstractC22207uq5 a() {
        return (AbstractC22207uq5) k(r());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public final int b(AbstractC22207uq5 abstractC22207uq5) {
        AbstractC13042fc3.i(abstractC22207uq5, "<this>");
        return abstractC22207uq5.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public final void c(AbstractC22207uq5 abstractC22207uq5, int i) {
        AbstractC13042fc3.i(abstractC22207uq5, "<this>");
        abstractC22207uq5.b(i);
    }

    protected abstract Object r();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.RW0
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public final void n(AbstractC22207uq5 abstractC22207uq5, int i, Object obj) {
        AbstractC13042fc3.i(abstractC22207uq5, "<this>");
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead".toString());
    }

    @Override // ir.nasim.RW0, ir.nasim.InterfaceC22798vq6
    public final void serialize(Encoder encoder, Object obj) {
        AbstractC13042fc3.i(encoder, "encoder");
        int iE = e(obj);
        SerialDescriptor serialDescriptor = this.b;
        kotlinx.serialization.encoding.d dVarI = encoder.i(serialDescriptor, iE);
        u(dVarI, obj, iE);
        dVarI.c(serialDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public final Object l(AbstractC22207uq5 abstractC22207uq5) {
        AbstractC13042fc3.i(abstractC22207uq5, "<this>");
        return abstractC22207uq5.a();
    }

    protected abstract void u(kotlinx.serialization.encoding.d dVar, Object obj, int i);
}
