package j$;

import java.util.function.LongPredicate;

/* renamed from: j$.j0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0071j0 implements j$.util.function.G {
    final /* synthetic */ LongPredicate a;

    private /* synthetic */ C0071j0(LongPredicate longPredicate) {
        this.a = longPredicate;
    }

    public static /* synthetic */ j$.util.function.G a(LongPredicate longPredicate) {
        if (longPredicate == null) {
            return null;
        }
        return longPredicate instanceof C0073k0 ? ((C0073k0) longPredicate).a : new C0071j0(longPredicate);
    }

    public /* synthetic */ boolean b(long j) {
        return this.a.test(j);
    }
}
