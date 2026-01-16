package j$;

import java.util.function.LongToIntFunction;

/* renamed from: j$.n0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0079n0 {
    final /* synthetic */ LongToIntFunction a;

    private /* synthetic */ C0079n0(LongToIntFunction longToIntFunction) {
        this.a = longToIntFunction;
    }

    public static /* synthetic */ C0079n0 b(LongToIntFunction longToIntFunction) {
        if (longToIntFunction == null) {
            return null;
        }
        return longToIntFunction instanceof C0081o0 ? ((C0081o0) longToIntFunction).a : new C0079n0(longToIntFunction);
    }

    public int a(long j) {
        return this.a.applyAsInt(j);
    }
}
