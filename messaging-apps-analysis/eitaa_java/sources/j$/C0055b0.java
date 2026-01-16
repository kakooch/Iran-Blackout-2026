package j$;

import java.util.function.IntUnaryOperator;

/* renamed from: j$.b0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0055b0 implements j$.util.function.C {
    final /* synthetic */ IntUnaryOperator a;

    private /* synthetic */ C0055b0(IntUnaryOperator intUnaryOperator) {
        this.a = intUnaryOperator;
    }

    public static /* synthetic */ j$.util.function.C b(IntUnaryOperator intUnaryOperator) {
        if (intUnaryOperator == null) {
            return null;
        }
        return intUnaryOperator instanceof C0057c0 ? ((C0057c0) intUnaryOperator).a : new C0055b0(intUnaryOperator);
    }

    public /* synthetic */ int a(int i) {
        return this.a.applyAsInt(i);
    }
}
