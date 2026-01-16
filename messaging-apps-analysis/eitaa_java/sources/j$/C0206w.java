package j$;

import j$.util.function.Consumer;

/* renamed from: j$.w, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0206w implements Consumer {
    final /* synthetic */ java.util.function.Consumer a;

    private /* synthetic */ C0206w(java.util.function.Consumer consumer) {
        this.a = consumer;
    }

    public static /* synthetic */ Consumer b(java.util.function.Consumer consumer) {
        if (consumer == null) {
            return null;
        }
        return consumer instanceof C0207x ? ((C0207x) consumer).a : new C0206w(consumer);
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ void accept(Object obj) {
        this.a.accept(obj);
    }

    @Override // j$.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return b(this.a.andThen(C0207x.a(consumer)));
    }
}
