package kotlinx.serialization.internal;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC18503om0;
import ir.nasim.AbstractC23393wq5;
import ir.nasim.C14599iA7;
import ir.nasim.C15201jA7;
import ir.nasim.C15792kA7;
import kotlinx.serialization.KSerializer;

/* loaded from: classes8.dex */
public final class k extends AbstractC23393wq5 implements KSerializer {
    public static final k c = new k();

    private k() {
        super(AbstractC18503om0.C(C14599iA7.b));
    }

    @Override // ir.nasim.H0
    public /* bridge */ /* synthetic */ int e(Object obj) {
        return v(((C15201jA7) obj).N());
    }

    @Override // ir.nasim.H0
    public /* bridge */ /* synthetic */ Object k(Object obj) {
        return y(((C15201jA7) obj).N());
    }

    @Override // ir.nasim.AbstractC23393wq5
    public /* bridge */ /* synthetic */ Object r() {
        return C15201jA7.f(w());
    }

    @Override // ir.nasim.AbstractC23393wq5
    public /* bridge */ /* synthetic */ void u(kotlinx.serialization.encoding.d dVar, Object obj, int i) {
        z(dVar, ((C15201jA7) obj).N(), i);
    }

    protected int v(long[] jArr) {
        AbstractC13042fc3.i(jArr, "$this$collectionSize");
        return C15201jA7.B(jArr);
    }

    protected long[] w() {
        return C15201jA7.h(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.RW0, ir.nasim.H0
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void h(kotlinx.serialization.encoding.c cVar, int i, C15792kA7 c15792kA7, boolean z) {
        AbstractC13042fc3.i(cVar, "decoder");
        AbstractC13042fc3.i(c15792kA7, "builder");
        c15792kA7.e(C14599iA7.h(cVar.r(getDescriptor(), i).m()));
    }

    protected C15792kA7 y(long[] jArr) {
        AbstractC13042fc3.i(jArr, "$this$toBuilder");
        return new C15792kA7(jArr, null);
    }

    protected void z(kotlinx.serialization.encoding.d dVar, long[] jArr, int i) {
        AbstractC13042fc3.i(dVar, "encoder");
        AbstractC13042fc3.i(jArr, "content");
        for (int i2 = 0; i2 < i; i2++) {
            dVar.e(getDescriptor(), i2).l(C15201jA7.x(jArr, i2));
        }
    }
}
