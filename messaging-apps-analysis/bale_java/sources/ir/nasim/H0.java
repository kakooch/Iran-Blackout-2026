package ir.nasim;

import java.util.Iterator;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.encoding.Decoder;

/* loaded from: classes8.dex */
public abstract class H0 implements KSerializer {
    public /* synthetic */ H0(ED1 ed1) {
        this();
    }

    public static /* synthetic */ void i(H0 h0, kotlinx.serialization.encoding.c cVar, int i, Object obj, boolean z, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readElement");
        }
        if ((i2 & 8) != 0) {
            z = true;
        }
        h0.h(cVar, i, obj, z);
    }

    private final int j(kotlinx.serialization.encoding.c cVar, Object obj) {
        int iL = cVar.l(getDescriptor());
        c(obj, iL);
        return iL;
    }

    protected abstract Object a();

    protected abstract int b(Object obj);

    protected abstract void c(Object obj, int i);

    protected abstract Iterator d(Object obj);

    @Override // ir.nasim.XI1
    public Object deserialize(Decoder decoder) {
        AbstractC13042fc3.i(decoder, "decoder");
        return f(decoder, null);
    }

    protected abstract int e(Object obj);

    public final Object f(Decoder decoder, Object obj) {
        Object objA;
        AbstractC13042fc3.i(decoder, "decoder");
        if (obj == null || (objA = k(obj)) == null) {
            objA = a();
        }
        int iB = b(objA);
        kotlinx.serialization.encoding.c cVarB = decoder.b(getDescriptor());
        if (!cVarB.p()) {
            while (true) {
                int iO = cVarB.o(getDescriptor());
                if (iO == -1) {
                    break;
                }
                i(this, cVarB, iB + iO, objA, false, 8, null);
            }
        } else {
            g(cVarB, objA, iB, j(cVarB, objA));
        }
        cVarB.c(getDescriptor());
        return l(objA);
    }

    protected abstract void g(kotlinx.serialization.encoding.c cVar, Object obj, int i, int i2);

    protected abstract void h(kotlinx.serialization.encoding.c cVar, int i, Object obj, boolean z);

    protected abstract Object k(Object obj);

    protected abstract Object l(Object obj);

    private H0() {
    }
}
