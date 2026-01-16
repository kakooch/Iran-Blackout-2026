package j$;

import java.util.function.IntConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class Q implements j$.util.function.y {
    final /* synthetic */ IntConsumer a;

    private /* synthetic */ Q(IntConsumer intConsumer) {
        this.a = intConsumer;
    }

    public static /* synthetic */ j$.util.function.y b(IntConsumer intConsumer) {
        if (intConsumer == null) {
            return null;
        }
        return intConsumer instanceof S ? ((S) intConsumer).a : new Q(intConsumer);
    }

    @Override // j$.util.function.y
    public /* synthetic */ void accept(int i) {
        this.a.accept(i);
    }

    @Override // j$.util.function.y
    public /* synthetic */ j$.util.function.y k(j$.util.function.y yVar) {
        return b(this.a.andThen(S.a(yVar)));
    }
}
