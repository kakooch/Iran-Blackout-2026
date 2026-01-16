package j$.util.function;

/* loaded from: classes2.dex */
public interface Function<T, R> {

    /* renamed from: j$.util.function.Function$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Function $default$andThen(Function function, Function function2) {
            function2.getClass();
            return new i(function, function2, 0);
        }

        public static Function $default$compose(Function function, Function function2) {
            function2.getClass();
            return new i(function, function2, 1);
        }
    }

    <V> Function<T, V> andThen(Function<? super R, ? extends V> function);

    R apply(T t);

    <V> Function<V, R> compose(Function<? super V, ? extends T> function);
}
