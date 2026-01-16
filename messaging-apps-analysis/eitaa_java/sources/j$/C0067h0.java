package j$;

import java.util.function.LongFunction;

/* renamed from: j$.h0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0067h0 implements j$.util.function.F {
    final /* synthetic */ LongFunction a;

    private /* synthetic */ C0067h0(LongFunction longFunction) {
        this.a = longFunction;
    }

    public static /* synthetic */ j$.util.function.F a(LongFunction longFunction) {
        if (longFunction == null) {
            return null;
        }
        return longFunction instanceof C0069i0 ? ((C0069i0) longFunction).a : new C0067h0(longFunction);
    }

    @Override // j$.util.function.F
    public /* synthetic */ Object apply(long j) {
        return this.a.apply(j);
    }
}
