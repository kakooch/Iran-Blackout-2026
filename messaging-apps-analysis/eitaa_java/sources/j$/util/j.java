package j$.util;

import j$.util.function.C0095f;
import j$.util.function.Consumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class j implements j$.util.function.s {
    public final /* synthetic */ Consumer a;

    @Override // j$.util.function.s
    public final void accept(double d) {
        this.a.accept(Double.valueOf(d));
    }

    @Override // j$.util.function.s
    public j$.util.function.s j(j$.util.function.s sVar) {
        sVar.getClass();
        return new C0095f(this, sVar);
    }
}
