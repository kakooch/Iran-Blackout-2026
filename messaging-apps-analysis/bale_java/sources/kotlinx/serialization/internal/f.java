package kotlinx.serialization.internal;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC18503om0;
import ir.nasim.AbstractC23393wq5;
import ir.nasim.C14842ia3;
import ir.nasim.C15431ja3;
import kotlinx.serialization.KSerializer;

/* loaded from: classes8.dex */
public final class f extends AbstractC23393wq5 implements KSerializer {
    public static final f c = new f();

    private f() {
        super(AbstractC18503om0.w(C15431ja3.a));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public int e(int[] iArr) {
        AbstractC13042fc3.i(iArr, "<this>");
        return iArr.length;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC23393wq5
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public int[] r() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.RW0, ir.nasim.H0
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void h(kotlinx.serialization.encoding.c cVar, int i, C14842ia3 c14842ia3, boolean z) {
        AbstractC13042fc3.i(cVar, "decoder");
        AbstractC13042fc3.i(c14842ia3, "builder");
        c14842ia3.e(cVar.i(getDescriptor(), i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public C14842ia3 k(int[] iArr) {
        AbstractC13042fc3.i(iArr, "<this>");
        return new C14842ia3(iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC23393wq5
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void u(kotlinx.serialization.encoding.d dVar, int[] iArr, int i) {
        AbstractC13042fc3.i(dVar, "encoder");
        AbstractC13042fc3.i(iArr, "content");
        for (int i2 = 0; i2 < i; i2++) {
            dVar.w(getDescriptor(), i2, iArr[i2]);
        }
    }
}
