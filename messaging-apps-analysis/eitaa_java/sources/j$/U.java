package j$;

import java.util.function.IntFunction;

/* loaded from: classes2.dex */
public final /* synthetic */ class U implements IntFunction {
    final /* synthetic */ j$.util.function.z a;

    private /* synthetic */ U(j$.util.function.z zVar) {
        this.a = zVar;
    }

    public static /* synthetic */ IntFunction a(j$.util.function.z zVar) {
        if (zVar == null) {
            return null;
        }
        return zVar instanceof T ? ((T) zVar).a : new U(zVar);
    }

    @Override // java.util.function.IntFunction
    public /* synthetic */ Object apply(int i) {
        return this.a.apply(i);
    }
}
