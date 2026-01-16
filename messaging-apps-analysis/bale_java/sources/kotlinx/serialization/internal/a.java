package kotlinx.serialization.internal;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC18503om0;
import ir.nasim.AbstractC23393wq5;
import ir.nasim.C7337Rh0;
import ir.nasim.C7571Sh0;
import kotlinx.serialization.KSerializer;

/* loaded from: classes8.dex */
public final class a extends AbstractC23393wq5 implements KSerializer {
    public static final a c = new a();

    private a() {
        super(AbstractC18503om0.q(C7571Sh0.a));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public int e(boolean[] zArr) {
        AbstractC13042fc3.i(zArr, "<this>");
        return zArr.length;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC23393wq5
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public boolean[] r() {
        return new boolean[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.RW0, ir.nasim.H0
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void h(kotlinx.serialization.encoding.c cVar, int i, C7337Rh0 c7337Rh0, boolean z) {
        AbstractC13042fc3.i(cVar, "decoder");
        AbstractC13042fc3.i(c7337Rh0, "builder");
        c7337Rh0.e(cVar.B(getDescriptor(), i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public C7337Rh0 k(boolean[] zArr) {
        AbstractC13042fc3.i(zArr, "<this>");
        return new C7337Rh0(zArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC23393wq5
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void u(kotlinx.serialization.encoding.d dVar, boolean[] zArr, int i) {
        AbstractC13042fc3.i(dVar, "encoder");
        AbstractC13042fc3.i(zArr, "content");
        for (int i2 = 0; i2 < i; i2++) {
            dVar.x(getDescriptor(), i2, zArr[i2]);
        }
    }
}
