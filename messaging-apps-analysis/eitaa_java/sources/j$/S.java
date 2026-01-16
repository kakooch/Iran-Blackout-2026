package j$;

import java.util.function.IntConsumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class S implements IntConsumer {
    final /* synthetic */ j$.util.function.y a;

    private /* synthetic */ S(j$.util.function.y yVar) {
        this.a = yVar;
    }

    public static /* synthetic */ IntConsumer a(j$.util.function.y yVar) {
        if (yVar == null) {
            return null;
        }
        return yVar instanceof Q ? ((Q) yVar).a : new S(yVar);
    }

    @Override // java.util.function.IntConsumer
    public /* synthetic */ void accept(int i) {
        this.a.accept(i);
    }

    @Override // java.util.function.IntConsumer
    public /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a(this.a.k(Q.b(intConsumer)));
    }
}
