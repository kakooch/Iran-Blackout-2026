package kotlinx.serialization.internal;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC18503om0;
import ir.nasim.AbstractC23393wq5;
import ir.nasim.C13611gX1;
import ir.nasim.C15402jX1;
import kotlinx.serialization.KSerializer;

/* loaded from: classes8.dex */
public final class d extends AbstractC23393wq5 implements KSerializer {
    public static final d c = new d();

    private d() {
        super(AbstractC18503om0.t(C15402jX1.a));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public int e(double[] dArr) {
        AbstractC13042fc3.i(dArr, "<this>");
        return dArr.length;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC23393wq5
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public double[] r() {
        return new double[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.RW0, ir.nasim.H0
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void h(kotlinx.serialization.encoding.c cVar, int i, C13611gX1 c13611gX1, boolean z) {
        AbstractC13042fc3.i(cVar, "decoder");
        AbstractC13042fc3.i(c13611gX1, "builder");
        c13611gX1.e(cVar.F(getDescriptor(), i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public C13611gX1 k(double[] dArr) {
        AbstractC13042fc3.i(dArr, "<this>");
        return new C13611gX1(dArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC23393wq5
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void u(kotlinx.serialization.encoding.d dVar, double[] dArr, int i) {
        AbstractC13042fc3.i(dVar, "encoder");
        AbstractC13042fc3.i(dArr, "content");
        for (int i2 = 0; i2 < i; i2++) {
            dVar.D(getDescriptor(), i2, dArr[i2]);
        }
    }
}
