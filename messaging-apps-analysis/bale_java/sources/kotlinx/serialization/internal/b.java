package kotlinx.serialization.internal;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC18503om0;
import ir.nasim.AbstractC23393wq5;
import ir.nasim.C23368wo0;
import ir.nasim.C5488Jo0;
import kotlinx.serialization.KSerializer;

/* loaded from: classes8.dex */
public final class b extends AbstractC23393wq5 implements KSerializer {
    public static final b c = new b();

    private b() {
        super(AbstractC18503om0.r(C5488Jo0.a));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public int e(byte[] bArr) {
        AbstractC13042fc3.i(bArr, "<this>");
        return bArr.length;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC23393wq5
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public byte[] r() {
        return new byte[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.RW0, ir.nasim.H0
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void h(kotlinx.serialization.encoding.c cVar, int i, C23368wo0 c23368wo0, boolean z) {
        AbstractC13042fc3.i(cVar, "decoder");
        AbstractC13042fc3.i(c23368wo0, "builder");
        c23368wo0.e(cVar.A(getDescriptor(), i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.H0
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public C23368wo0 k(byte[] bArr) {
        AbstractC13042fc3.i(bArr, "<this>");
        return new C23368wo0(bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC23393wq5
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void u(kotlinx.serialization.encoding.d dVar, byte[] bArr, int i) {
        AbstractC13042fc3.i(dVar, "encoder");
        AbstractC13042fc3.i(bArr, "content");
        for (int i2 = 0; i2 < i; i2++) {
            dVar.p(getDescriptor(), i2, bArr[i2]);
        }
    }
}
