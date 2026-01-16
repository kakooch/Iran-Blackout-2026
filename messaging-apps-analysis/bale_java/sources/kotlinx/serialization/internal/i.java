package kotlinx.serialization.internal;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC18503om0;
import ir.nasim.AbstractC23393wq5;
import ir.nasim.C7743Sz7;
import ir.nasim.C7979Tz7;
import ir.nasim.C8213Uz7;
import kotlinx.serialization.KSerializer;

/* loaded from: classes8.dex */
public final class i extends AbstractC23393wq5 implements KSerializer {
    public static final i c = new i();

    private i() {
        super(AbstractC18503om0.A(C7743Sz7.b));
    }

    @Override // ir.nasim.H0
    public /* bridge */ /* synthetic */ int e(Object obj) {
        return v(((C7979Tz7) obj).N());
    }

    @Override // ir.nasim.H0
    public /* bridge */ /* synthetic */ Object k(Object obj) {
        return y(((C7979Tz7) obj).N());
    }

    @Override // ir.nasim.AbstractC23393wq5
    public /* bridge */ /* synthetic */ Object r() {
        return C7979Tz7.f(w());
    }

    @Override // ir.nasim.AbstractC23393wq5
    public /* bridge */ /* synthetic */ void u(kotlinx.serialization.encoding.d dVar, Object obj, int i) {
        z(dVar, ((C7979Tz7) obj).N(), i);
    }

    protected int v(byte[] bArr) {
        AbstractC13042fc3.i(bArr, "$this$collectionSize");
        return C7979Tz7.B(bArr);
    }

    protected byte[] w() {
        return C7979Tz7.h(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.RW0, ir.nasim.H0
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void h(kotlinx.serialization.encoding.c cVar, int i, C8213Uz7 c8213Uz7, boolean z) {
        AbstractC13042fc3.i(cVar, "decoder");
        AbstractC13042fc3.i(c8213Uz7, "builder");
        c8213Uz7.e(C7743Sz7.h(cVar.r(getDescriptor(), i).G()));
    }

    protected C8213Uz7 y(byte[] bArr) {
        AbstractC13042fc3.i(bArr, "$this$toBuilder");
        return new C8213Uz7(bArr, null);
    }

    protected void z(kotlinx.serialization.encoding.d dVar, byte[] bArr, int i) {
        AbstractC13042fc3.i(dVar, "encoder");
        AbstractC13042fc3.i(bArr, "content");
        for (int i2 = 0; i2 < i; i2++) {
            dVar.e(getDescriptor(), i2).g(C7979Tz7.x(bArr, i2));
        }
    }
}
