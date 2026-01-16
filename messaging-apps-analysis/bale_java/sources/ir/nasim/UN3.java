package ir.nasim;

import java.util.Iterator;
import java.util.Map;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.encoding.c;

/* loaded from: classes8.dex */
public abstract class UN3 extends H0 {
    private final KSerializer a;
    private final KSerializer b;

    public /* synthetic */ UN3(KSerializer kSerializer, KSerializer kSerializer2, ED1 ed1) {
        this(kSerializer, kSerializer2);
    }

    @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
    public abstract SerialDescriptor getDescriptor();

    public final KSerializer m() {
        return this.a;
    }

    public final KSerializer n() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public final void g(kotlinx.serialization.encoding.c cVar, Map map, int i, int i2) {
        AbstractC13042fc3.i(cVar, "decoder");
        AbstractC13042fc3.i(map, "builder");
        if (i2 < 0) {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL".toString());
        }
        C23231wa3 c23231wa3V = AbstractC23053wG5.v(AbstractC23053wG5.y(0, i2 * 2), 2);
        int iO = c23231wa3V.o();
        int iT = c23231wa3V.t();
        int iV = c23231wa3V.v();
        if ((iV <= 0 || iO > iT) && (iV >= 0 || iT > iO)) {
            return;
        }
        while (true) {
            h(cVar, i + iO, map, false);
            if (iO == iT) {
                return;
            } else {
                iO += iV;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public final void h(kotlinx.serialization.encoding.c cVar, int i, Map map, boolean z) {
        int iO;
        AbstractC13042fc3.i(cVar, "decoder");
        AbstractC13042fc3.i(map, "builder");
        Object objC = c.a.c(cVar, getDescriptor(), i, this.a, null, 8, null);
        if (z) {
            iO = cVar.o(getDescriptor());
            if (iO != i + 1) {
                throw new IllegalArgumentException(("Value must follow key in a map, index for key: " + i + ", returned index for value: " + iO).toString());
            }
        } else {
            iO = i + 1;
        }
        int i2 = iO;
        map.put(objC, (!map.containsKey(objC) || (this.b.getDescriptor().f() instanceof AbstractC25167zq5)) ? c.a.c(cVar, getDescriptor(), i2, this.b, null, 8, null) : cVar.E(getDescriptor(), i2, this.b, AbstractC20051rO3.l(map, objC)));
    }

    @Override // ir.nasim.InterfaceC22798vq6
    public void serialize(Encoder encoder, Object obj) {
        AbstractC13042fc3.i(encoder, "encoder");
        int iE = e(obj);
        SerialDescriptor descriptor = getDescriptor();
        kotlinx.serialization.encoding.d dVarI = encoder.i(descriptor, iE);
        Iterator itD = d(obj);
        int i = 0;
        while (itD.hasNext()) {
            Map.Entry entry = (Map.Entry) itD.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            int i2 = i + 1;
            dVarI.B(getDescriptor(), i, m(), key);
            i += 2;
            dVarI.B(getDescriptor(), i2, n(), value);
        }
        dVarI.c(descriptor);
    }

    private UN3(KSerializer kSerializer, KSerializer kSerializer2) {
        super(null);
        this.a = kSerializer;
        this.b = kSerializer2;
    }
}
