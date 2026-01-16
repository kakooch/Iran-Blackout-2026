package kotlinx.serialization.internal;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC18503om0;
import ir.nasim.AbstractC23393wq5;
import ir.nasim.TJ0;
import ir.nasim.YJ0;
import kotlinx.serialization.KSerializer;

/* loaded from: classes8.dex */
public final class c extends AbstractC23393wq5 implements KSerializer {
    public static final c c = new c();

    private c() {
        super(AbstractC18503om0.s(YJ0.a));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public int e(char[] cArr) {
        AbstractC13042fc3.i(cArr, "<this>");
        return cArr.length;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC23393wq5
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public char[] r() {
        return new char[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.RW0, ir.nasim.H0
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void h(kotlinx.serialization.encoding.c cVar, int i, TJ0 tj0, boolean z) {
        AbstractC13042fc3.i(cVar, "decoder");
        AbstractC13042fc3.i(tj0, "builder");
        tj0.e(cVar.z(getDescriptor(), i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public TJ0 k(char[] cArr) {
        AbstractC13042fc3.i(cArr, "<this>");
        return new TJ0(cArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC23393wq5
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void u(kotlinx.serialization.encoding.d dVar, char[] cArr, int i) {
        AbstractC13042fc3.i(dVar, "encoder");
        AbstractC13042fc3.i(cArr, "content");
        for (int i2 = 0; i2 < i; i2++) {
            dVar.n(getDescriptor(), i2, cArr[i2]);
        }
    }
}
