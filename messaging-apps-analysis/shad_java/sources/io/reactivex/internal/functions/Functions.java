package io.reactivex.internal.functions;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscription;

/* loaded from: classes3.dex */
public final class Functions {
    public static final Consumer<Throwable> ON_ERROR_MISSING;
    static final Function<Object, Object> IDENTITY = new Identity();
    public static final Runnable EMPTY_RUNNABLE = new EmptyRunnable();
    public static final Action EMPTY_ACTION = new EmptyAction();
    static final Consumer<Object> EMPTY_CONSUMER = new EmptyConsumer();

    public static <T1, T2, R> Function<Object[], R> toFunction(BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(biFunction, "f is null");
        return new Array2Func(biFunction);
    }

    static {
        new ErrorConsumer();
        ON_ERROR_MISSING = new OnErrorMissingConsumer();
        new EmptyLongConsumer();
        new TruePredicate();
        new FalsePredicate();
        new NullCallable();
        new NaturalObjectComparator();
        new MaxRequestSubscription();
    }

    public static <T> Function<T, T> identity() {
        return (Function<T, T>) IDENTITY;
    }

    public static <T> Consumer<T> emptyConsumer() {
        return (Consumer<T>) EMPTY_CONSUMER;
    }

    static final class JustValue<T, U> implements Callable<U>, Function<T, U> {
        final U value;

        JustValue(U u) {
            this.value = u;
        }

        @Override // java.util.concurrent.Callable
        public U call() throws Exception {
            return this.value;
        }

        @Override // io.reactivex.functions.Function
        public U apply(T t) throws Exception {
            return this.value;
        }
    }

    public static <T, U> Function<T, U> justFunction(U u) {
        return new JustValue(u);
    }

    static final class EqualsPredicate<T> implements Predicate<T> {
        final T value;

        EqualsPredicate(T t) {
            this.value = t;
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(T t) throws Exception {
            return ObjectHelper.equals(t, this.value);
        }
    }

    public static <T> Predicate<T> equalsWith(T t) {
        return new EqualsPredicate(t);
    }

    static final class ListSorter<T> implements Function<List<T>, List<T>> {
        final Comparator<? super T> comparator;

        ListSorter(Comparator<? super T> comparator) {
            this.comparator = comparator;
        }

        @Override // io.reactivex.functions.Function
        public List<T> apply(List<T> list) {
            Collections.sort(list, this.comparator);
            return list;
        }
    }

    public static <T> Function<List<T>, List<T>> listSorter(Comparator<? super T> comparator) {
        return new ListSorter(comparator);
    }

    static final class Array2Func<T1, T2, R> implements Function<Object[], R> {
        final BiFunction<? super T1, ? super T2, ? extends R> f;

        Array2Func(BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
            this.f = biFunction;
        }

        @Override // io.reactivex.functions.Function
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 2) {
                throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
            }
            return this.f.apply(objArr[0], objArr[1]);
        }
    }

    static final class Identity implements Function<Object, Object> {
        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }

        Identity() {
        }
    }

    static final class EmptyRunnable implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }

        EmptyRunnable() {
        }
    }

    static final class EmptyAction implements Action {
        @Override // io.reactivex.functions.Action
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }

        EmptyAction() {
        }
    }

    static final class EmptyConsumer implements Consumer<Object> {
        @Override // io.reactivex.functions.Consumer
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }

        EmptyConsumer() {
        }
    }

    static final class ErrorConsumer implements Consumer<Throwable> {
        ErrorConsumer() {
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            RxJavaPlugins.onError(th);
        }
    }

    static final class OnErrorMissingConsumer implements Consumer<Throwable> {
        OnErrorMissingConsumer() {
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            RxJavaPlugins.onError(new OnErrorNotImplementedException(th));
        }
    }

    static final class EmptyLongConsumer {
        EmptyLongConsumer() {
        }
    }

    static final class TruePredicate implements Predicate<Object> {
        @Override // io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            return true;
        }

        TruePredicate() {
        }
    }

    static final class FalsePredicate implements Predicate<Object> {
        @Override // io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            return false;
        }

        FalsePredicate() {
        }
    }

    static final class NullCallable implements Callable<Object> {
        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }

        NullCallable() {
        }
    }

    static final class NaturalObjectComparator implements Comparator<Object> {
        NaturalObjectComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    static final class MaxRequestSubscription implements Consumer<Subscription> {
        MaxRequestSubscription() {
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Subscription subscription) throws Exception {
            subscription.request(Long.MAX_VALUE);
        }
    }
}
