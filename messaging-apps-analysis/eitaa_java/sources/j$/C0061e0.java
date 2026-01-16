package j$;

import java.util.function.LongBinaryOperator;

/* renamed from: j$.e0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0061e0 implements LongBinaryOperator {
    final /* synthetic */ j$.util.function.D a;

    private /* synthetic */ C0061e0(j$.util.function.D d) {
        this.a = d;
    }

    public static /* synthetic */ LongBinaryOperator a(j$.util.function.D d) {
        if (d == null) {
            return null;
        }
        return d instanceof C0059d0 ? ((C0059d0) d).a : new C0061e0(d);
    }

    @Override // java.util.function.LongBinaryOperator
    public /* synthetic */ long applyAsLong(long j, long j2) {
        return this.a.applyAsLong(j, j2);
    }
}
