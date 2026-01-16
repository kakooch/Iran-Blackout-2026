package j$;

import java.util.function.LongConsumer;

/* renamed from: j$.f0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0063f0 implements j$.util.function.E {
    final /* synthetic */ LongConsumer a;

    private /* synthetic */ C0063f0(LongConsumer longConsumer) {
        this.a = longConsumer;
    }

    public static /* synthetic */ j$.util.function.E b(LongConsumer longConsumer) {
        if (longConsumer == null) {
            return null;
        }
        return longConsumer instanceof C0065g0 ? ((C0065g0) longConsumer).a : new C0063f0(longConsumer);
    }

    @Override // j$.util.function.E
    public /* synthetic */ void accept(long j) {
        this.a.accept(j);
    }

    @Override // j$.util.function.E
    public /* synthetic */ j$.util.function.E f(j$.util.function.E e) {
        return b(this.a.andThen(C0065g0.a(e)));
    }
}
