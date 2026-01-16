package ir.nasim;

import java.util.Iterator;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.encoding.c;

/* loaded from: classes8.dex */
public abstract class RW0 extends H0 {
    private final KSerializer a;

    public /* synthetic */ RW0(KSerializer kSerializer, ED1 ed1) {
        this(kSerializer);
    }

    @Override // ir.nasim.H0
    protected final void g(kotlinx.serialization.encoding.c cVar, Object obj, int i, int i2) {
        AbstractC13042fc3.i(cVar, "decoder");
        if (i2 < 0) {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL".toString());
        }
        for (int i3 = 0; i3 < i2; i3++) {
            h(cVar, i + i3, obj, false);
        }
    }

    @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
    public abstract SerialDescriptor getDescriptor();

    @Override // ir.nasim.H0
    protected void h(kotlinx.serialization.encoding.c cVar, int i, Object obj, boolean z) {
        AbstractC13042fc3.i(cVar, "decoder");
        n(obj, i, c.a.c(cVar, getDescriptor(), i, this.a, null, 8, null));
    }

    protected abstract void n(Object obj, int i, Object obj2);

    @Override // ir.nasim.InterfaceC22798vq6
    public void serialize(Encoder encoder, Object obj) {
        AbstractC13042fc3.i(encoder, "encoder");
        int iE = e(obj);
        SerialDescriptor descriptor = getDescriptor();
        kotlinx.serialization.encoding.d dVarI = encoder.i(descriptor, iE);
        Iterator itD = d(obj);
        for (int i = 0; i < iE; i++) {
            dVarI.B(getDescriptor(), i, this.a, itD.next());
        }
        dVarI.c(descriptor);
    }

    private RW0(KSerializer kSerializer) {
        super(null);
        this.a = kSerializer;
    }
}
