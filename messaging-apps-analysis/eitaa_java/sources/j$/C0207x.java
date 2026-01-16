package j$;

import java.util.function.Consumer;

/* renamed from: j$.x, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0207x implements Consumer {
    final /* synthetic */ j$.util.function.Consumer a;

    private /* synthetic */ C0207x(j$.util.function.Consumer consumer) {
        this.a = consumer;
    }

    public static /* synthetic */ Consumer a(j$.util.function.Consumer consumer) {
        if (consumer == null) {
            return null;
        }
        return consumer instanceof C0206w ? ((C0206w) consumer).a : new C0207x(consumer);
    }

    @Override // java.util.function.Consumer
    public /* synthetic */ void accept(Object obj) {
        this.a.accept(obj);
    }

    @Override // java.util.function.Consumer
    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return a(this.a.andThen(C0206w.b(consumer)));
    }
}
