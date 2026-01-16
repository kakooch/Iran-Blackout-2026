package j$.util.stream;

import j$.util.function.BiFunction;
import j$.util.function.C0091b;
import j$.util.function.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class N implements j$.util.function.p {
    public static final /* synthetic */ N a = new N();

    private /* synthetic */ N() {
    }

    @Override // j$.util.function.BiFunction
    public BiFunction andThen(Function function) {
        function.getClass();
        return new C0091b(this, function);
    }

    @Override // j$.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        j$.util.v vVar = (j$.util.v) obj;
        vVar.b((j$.util.v) obj2);
        return vVar;
    }
}
