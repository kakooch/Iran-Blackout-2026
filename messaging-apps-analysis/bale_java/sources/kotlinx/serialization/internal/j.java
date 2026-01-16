package kotlinx.serialization.internal;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC18503om0;
import ir.nasim.AbstractC23393wq5;
import ir.nasim.C11540dA7;
import ir.nasim.C12183eA7;
import ir.nasim.C12792fA7;
import kotlinx.serialization.KSerializer;

/* loaded from: classes8.dex */
public final class j extends AbstractC23393wq5 implements KSerializer {
    public static final j c = new j();

    private j() {
        super(AbstractC18503om0.B(C11540dA7.b));
    }

    @Override // ir.nasim.H0
    public /* bridge */ /* synthetic */ int e(Object obj) {
        return v(((C12183eA7) obj).N());
    }

    @Override // ir.nasim.H0
    public /* bridge */ /* synthetic */ Object k(Object obj) {
        return y(((C12183eA7) obj).N());
    }

    @Override // ir.nasim.AbstractC23393wq5
    public /* bridge */ /* synthetic */ Object r() {
        return C12183eA7.f(w());
    }

    @Override // ir.nasim.AbstractC23393wq5
    public /* bridge */ /* synthetic */ void u(kotlinx.serialization.encoding.d dVar, Object obj, int i) {
        z(dVar, ((C12183eA7) obj).N(), i);
    }

    protected int v(int[] iArr) {
        AbstractC13042fc3.i(iArr, "$this$collectionSize");
        return C12183eA7.B(iArr);
    }

    protected int[] w() {
        return C12183eA7.h(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.RW0, ir.nasim.H0
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void h(kotlinx.serialization.encoding.c cVar, int i, C12792fA7 c12792fA7, boolean z) {
        AbstractC13042fc3.i(cVar, "decoder");
        AbstractC13042fc3.i(c12792fA7, "builder");
        c12792fA7.e(C11540dA7.h(cVar.r(getDescriptor(), i).h()));
    }

    protected C12792fA7 y(int[] iArr) {
        AbstractC13042fc3.i(iArr, "$this$toBuilder");
        return new C12792fA7(iArr, null);
    }

    protected void z(kotlinx.serialization.encoding.d dVar, int[] iArr, int i) {
        AbstractC13042fc3.i(dVar, "encoder");
        AbstractC13042fc3.i(iArr, "content");
        for (int i2 = 0; i2 < i; i2++) {
            dVar.e(getDescriptor(), i2).A(C12183eA7.x(iArr, i2));
        }
    }
}
