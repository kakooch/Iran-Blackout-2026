package kotlinx.serialization.internal;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC18503om0;
import ir.nasim.AbstractC23393wq5;
import ir.nasim.C8852Xp2;
import ir.nasim.C9361Zp2;
import kotlinx.serialization.KSerializer;

/* loaded from: classes8.dex */
public final class e extends AbstractC23393wq5 implements KSerializer {
    public static final e c = new e();

    private e() {
        super(AbstractC18503om0.v(C9361Zp2.a));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public int e(float[] fArr) {
        AbstractC13042fc3.i(fArr, "<this>");
        return fArr.length;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC23393wq5
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public float[] r() {
        return new float[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.RW0, ir.nasim.H0
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void h(kotlinx.serialization.encoding.c cVar, int i, C8852Xp2 c8852Xp2, boolean z) {
        AbstractC13042fc3.i(cVar, "decoder");
        AbstractC13042fc3.i(c8852Xp2, "builder");
        c8852Xp2.e(cVar.u(getDescriptor(), i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public C8852Xp2 k(float[] fArr) {
        AbstractC13042fc3.i(fArr, "<this>");
        return new C8852Xp2(fArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC23393wq5
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void u(kotlinx.serialization.encoding.d dVar, float[] fArr, int i) {
        AbstractC13042fc3.i(dVar, "encoder");
        AbstractC13042fc3.i(fArr, "content");
        for (int i2 = 0; i2 < i; i2++) {
            dVar.s(getDescriptor(), i2, fArr[i2]);
        }
    }
}
