package kotlinx.serialization.internal;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC18503om0;
import ir.nasim.AbstractC23393wq5;
import ir.nasim.C10237bJ3;
import ir.nasim.ZI3;
import kotlinx.serialization.KSerializer;

/* loaded from: classes8.dex */
public final class g extends AbstractC23393wq5 implements KSerializer {
    public static final g c = new g();

    private g() {
        super(AbstractC18503om0.x(C10237bJ3.a));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public int e(long[] jArr) {
        AbstractC13042fc3.i(jArr, "<this>");
        return jArr.length;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC23393wq5
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public long[] r() {
        return new long[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.RW0, ir.nasim.H0
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void h(kotlinx.serialization.encoding.c cVar, int i, ZI3 zi3, boolean z) {
        AbstractC13042fc3.i(cVar, "decoder");
        AbstractC13042fc3.i(zi3, "builder");
        zi3.e(cVar.f(getDescriptor(), i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public ZI3 k(long[] jArr) {
        AbstractC13042fc3.i(jArr, "<this>");
        return new ZI3(jArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC23393wq5
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void u(kotlinx.serialization.encoding.d dVar, long[] jArr, int i) {
        AbstractC13042fc3.i(dVar, "encoder");
        AbstractC13042fc3.i(jArr, "content");
        for (int i2 = 0; i2 < i; i2++) {
            dVar.E(getDescriptor(), i2, jArr[i2]);
        }
    }
}
