package j$.util.function;

/* renamed from: j$.util.function.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0091b implements BiFunction {
    public final /* synthetic */ BiFunction a;
    public final /* synthetic */ Function b;

    public /* synthetic */ C0091b(BiFunction biFunction, Function function) {
        this.a = biFunction;
        this.b = function;
    }

    @Override // j$.util.function.BiFunction
    public BiFunction andThen(Function function) {
        function.getClass();
        return new C0091b(this, function);
    }

    @Override // j$.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return this.b.apply(this.a.apply(obj, obj2));
    }
}
