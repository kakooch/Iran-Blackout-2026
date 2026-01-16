package j$.wrappers;

import java.util.function.LongFunction;

/* renamed from: j$.wrappers.g0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0276g0 implements j$.util.function.r {
    final /* synthetic */ LongFunction a;

    private /* synthetic */ C0276g0(LongFunction longFunction) {
        this.a = longFunction;
    }

    public static /* synthetic */ j$.util.function.r a(LongFunction longFunction) {
        if (longFunction == null) {
            return null;
        }
        return longFunction instanceof C0278h0 ? ((C0278h0) longFunction).a : new C0276g0(longFunction);
    }

    @Override // j$.util.function.r
    public /* synthetic */ Object apply(long j) {
        return this.a.apply(j);
    }
}
