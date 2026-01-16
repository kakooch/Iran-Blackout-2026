package j$.util;

import j$.util.function.Consumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class m implements j$.util.function.f {
    public final /* synthetic */ Consumer a;

    public /* synthetic */ m(Consumer consumer) {
        this.a = consumer;
    }

    @Override // j$.util.function.f
    public final void accept(double d) {
        this.a.accept(Double.valueOf(d));
    }

    @Override // j$.util.function.f
    public j$.util.function.f k(j$.util.function.f fVar) {
        fVar.getClass();
        return new j$.util.function.e(this, fVar);
    }
}
