package j$.util.stream;

import j$.util.function.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class R0 implements Function {
    public static final /* synthetic */ R0 a = new R0();

    private /* synthetic */ R0() {
    }

    @Override // j$.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    @Override // j$.util.function.Function
    public final Object apply(Object obj) {
        return ((j$.util.v) obj).toString();
    }

    @Override // j$.util.function.Function
    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
