package j$.util;

import j$.util.function.C0098i;
import j$.util.function.Consumer;
import j$.util.function.y;

/* loaded from: classes2.dex */
public final /* synthetic */ class h implements y {
    public final /* synthetic */ Consumer a;

    @Override // j$.util.function.y
    public final void accept(int i) {
        this.a.accept(Integer.valueOf(i));
    }

    @Override // j$.util.function.y
    public y k(y yVar) {
        yVar.getClass();
        return new C0098i(this, yVar);
    }
}
