package j$;

import java.util.function.LongConsumer;

/* renamed from: j$.g0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0065g0 implements LongConsumer {
    final /* synthetic */ j$.util.function.E a;

    private /* synthetic */ C0065g0(j$.util.function.E e) {
        this.a = e;
    }

    public static /* synthetic */ LongConsumer a(j$.util.function.E e) {
        if (e == null) {
            return null;
        }
        return e instanceof C0063f0 ? ((C0063f0) e).a : new C0065g0(e);
    }

    @Override // java.util.function.LongConsumer
    public /* synthetic */ void accept(long j) {
        this.a.accept(j);
    }

    @Override // java.util.function.LongConsumer
    public /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return a(this.a.f(C0063f0.b(longConsumer)));
    }
}
