package j$.util;

import j$.util.function.C0099j;
import j$.util.function.Consumer;
import j$.util.function.E;

/* loaded from: classes2.dex */
public final /* synthetic */ class g implements E {
    public final /* synthetic */ Consumer a;

    @Override // j$.util.function.E
    public final void accept(long j) {
        this.a.accept(Long.valueOf(j));
    }

    @Override // j$.util.function.E
    public E f(E e) {
        e.getClass();
        return new C0099j(this, e);
    }
}
