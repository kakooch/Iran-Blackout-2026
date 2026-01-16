package j$;

import java.util.function.IntUnaryOperator;

/* renamed from: j$.c0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0057c0 implements IntUnaryOperator {
    final /* synthetic */ j$.util.function.C a;

    private /* synthetic */ C0057c0(j$.util.function.C c) {
        this.a = c;
    }

    public static /* synthetic */ IntUnaryOperator a(j$.util.function.C c) {
        if (c == null) {
            return null;
        }
        return c instanceof C0055b0 ? ((C0055b0) c).a : new C0057c0(c);
    }

    @Override // java.util.function.IntUnaryOperator
    public /* synthetic */ IntUnaryOperator andThen(IntUnaryOperator intUnaryOperator) {
        return a(C0055b0.b(((C0055b0) this.a).a.andThen(a(C0055b0.b(intUnaryOperator)))));
    }

    @Override // java.util.function.IntUnaryOperator
    public /* synthetic */ int applyAsInt(int i) {
        return ((C0055b0) this.a).a.applyAsInt(i);
    }

    @Override // java.util.function.IntUnaryOperator
    public /* synthetic */ IntUnaryOperator compose(IntUnaryOperator intUnaryOperator) {
        return a(C0055b0.b(((C0055b0) this.a).a.compose(a(C0055b0.b(intUnaryOperator)))));
    }
}
