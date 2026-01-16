package kotlinx.serialization.internal;

import ir.nasim.AA7;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC18503om0;
import ir.nasim.AbstractC23393wq5;
import ir.nasim.BA7;
import ir.nasim.C24771zA7;
import kotlinx.serialization.KSerializer;

/* loaded from: classes8.dex */
public final class l extends AbstractC23393wq5 implements KSerializer {
    public static final l c = new l();

    private l() {
        super(AbstractC18503om0.D(C24771zA7.b));
    }

    @Override // ir.nasim.H0
    public /* bridge */ /* synthetic */ int e(Object obj) {
        return v(((AA7) obj).N());
    }

    @Override // ir.nasim.H0
    public /* bridge */ /* synthetic */ Object k(Object obj) {
        return y(((AA7) obj).N());
    }

    @Override // ir.nasim.AbstractC23393wq5
    public /* bridge */ /* synthetic */ Object r() {
        return AA7.f(w());
    }

    @Override // ir.nasim.AbstractC23393wq5
    public /* bridge */ /* synthetic */ void u(kotlinx.serialization.encoding.d dVar, Object obj, int i) {
        z(dVar, ((AA7) obj).N(), i);
    }

    protected int v(short[] sArr) {
        AbstractC13042fc3.i(sArr, "$this$collectionSize");
        return AA7.B(sArr);
    }

    protected short[] w() {
        return AA7.h(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.RW0, ir.nasim.H0
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void h(kotlinx.serialization.encoding.c cVar, int i, BA7 ba7, boolean z) {
        AbstractC13042fc3.i(cVar, "decoder");
        AbstractC13042fc3.i(ba7, "builder");
        ba7.e(C24771zA7.h(cVar.r(getDescriptor(), i).s()));
    }

    protected BA7 y(short[] sArr) {
        AbstractC13042fc3.i(sArr, "$this$toBuilder");
        return new BA7(sArr, null);
    }

    protected void z(kotlinx.serialization.encoding.d dVar, short[] sArr, int i) {
        AbstractC13042fc3.i(dVar, "encoder");
        AbstractC13042fc3.i(sArr, "content");
        for (int i2 = 0; i2 < i; i2++) {
            dVar.e(getDescriptor(), i2).q(AA7.x(sArr, i2));
        }
    }
}
