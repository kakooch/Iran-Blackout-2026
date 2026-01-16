package j$.wrappers;

import java.util.function.IntUnaryOperator;

/* renamed from: j$.wrappers.a0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0264a0 {
    final /* synthetic */ IntUnaryOperator a;

    private /* synthetic */ C0264a0(IntUnaryOperator intUnaryOperator) {
        this.a = intUnaryOperator;
    }

    public static /* synthetic */ C0264a0 b(IntUnaryOperator intUnaryOperator) {
        if (intUnaryOperator == null) {
            return null;
        }
        return intUnaryOperator instanceof AbstractC0266b0 ? ((AbstractC0266b0) intUnaryOperator).a : new C0264a0(intUnaryOperator);
    }

    public int a(int i) {
        return this.a.applyAsInt(i);
    }
}
