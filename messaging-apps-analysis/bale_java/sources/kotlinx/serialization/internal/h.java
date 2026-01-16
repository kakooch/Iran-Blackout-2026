package kotlinx.serialization.internal;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC18503om0;
import ir.nasim.AbstractC23393wq5;
import ir.nasim.C24070xz6;
import ir.nasim.C24660yz6;
import kotlinx.serialization.KSerializer;

/* loaded from: classes8.dex */
public final class h extends AbstractC23393wq5 implements KSerializer {
    public static final h c = new h();

    private h() {
        super(AbstractC18503om0.y(C24660yz6.a));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public int e(short[] sArr) {
        AbstractC13042fc3.i(sArr, "<this>");
        return sArr.length;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC23393wq5
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public short[] r() {
        return new short[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.RW0, ir.nasim.H0
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void h(kotlinx.serialization.encoding.c cVar, int i, C24070xz6 c24070xz6, boolean z) {
        AbstractC13042fc3.i(cVar, "decoder");
        AbstractC13042fc3.i(c24070xz6, "builder");
        c24070xz6.e(cVar.D(getDescriptor(), i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public C24070xz6 k(short[] sArr) {
        AbstractC13042fc3.i(sArr, "<this>");
        return new C24070xz6(sArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC23393wq5
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void u(kotlinx.serialization.encoding.d dVar, short[] sArr, int i) {
        AbstractC13042fc3.i(dVar, "encoder");
        AbstractC13042fc3.i(sArr, "content");
        for (int i2 = 0; i2 < i; i2++) {
            dVar.C(getDescriptor(), i2, sArr[i2]);
        }
    }
}
