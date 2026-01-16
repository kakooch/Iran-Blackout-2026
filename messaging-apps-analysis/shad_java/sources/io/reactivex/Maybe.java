package io.reactivex;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.operators.maybe.MaybeCreate;
import io.reactivex.internal.operators.maybe.MaybeEmpty;
import io.reactivex.internal.operators.maybe.MaybeFilter;
import io.reactivex.internal.operators.maybe.MaybeFlatMapCompletable;
import io.reactivex.internal.operators.maybe.MaybeFlatten;
import io.reactivex.internal.operators.maybe.MaybeFromCallable;
import io.reactivex.internal.operators.maybe.MaybeIsEmptySingle;
import io.reactivex.internal.operators.maybe.MaybeJust;
import io.reactivex.internal.operators.maybe.MaybeMap;
import io.reactivex.internal.operators.maybe.MaybeObserveOn;
import io.reactivex.internal.operators.maybe.MaybeOnErrorNext;
import io.reactivex.internal.operators.maybe.MaybePeek;
import io.reactivex.internal.operators.maybe.MaybeSwitchIfEmpty;
import io.reactivex.internal.operators.maybe.MaybeToFlowable;
import io.reactivex.internal.operators.maybe.MaybeZipArray;
import io.reactivex.internal.operators.mixed.MaybeFlatMapObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public abstract class Maybe<T> implements MaybeSource<T> {
    protected abstract void subscribeActual(MaybeObserver<? super T> maybeObserver);

    public static <T> Maybe<T> create(MaybeOnSubscribe<T> maybeOnSubscribe) {
        ObjectHelper.requireNonNull(maybeOnSubscribe, "onSubscribe is null");
        return RxJavaPlugins.onAssembly(new MaybeCreate(maybeOnSubscribe));
    }

    public static <T> Maybe<T> empty() {
        return RxJavaPlugins.onAssembly(MaybeEmpty.INSTANCE);
    }

    public static <T> Maybe<T> fromCallable(Callable<? extends T> callable) {
        ObjectHelper.requireNonNull(callable, "callable is null");
        return RxJavaPlugins.onAssembly(new MaybeFromCallable(callable));
    }

    public static <T> Maybe<T> just(T t) {
        ObjectHelper.requireNonNull(t, "item is null");
        return RxJavaPlugins.onAssembly(new MaybeJust(t));
    }

    public static <T1, T2, R> Maybe<R> zip(MaybeSource<? extends T1> maybeSource, MaybeSource<? extends T2> maybeSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.requireNonNull(maybeSource, "source1 is null");
        ObjectHelper.requireNonNull(maybeSource2, "source2 is null");
        return zipArray(Functions.toFunction(biFunction), maybeSource, maybeSource2);
    }

    public static <T, R> Maybe<R> zipArray(Function<? super Object[], ? extends R> function, MaybeSource<? extends T>... maybeSourceArr) {
        ObjectHelper.requireNonNull(maybeSourceArr, "sources is null");
        if (maybeSourceArr.length == 0) {
            return empty();
        }
        ObjectHelper.requireNonNull(function, "zipper is null");
        return RxJavaPlugins.onAssembly(new MaybeZipArray(maybeSourceArr, function));
    }

    public final Maybe<T> defaultIfEmpty(T t) {
        ObjectHelper.requireNonNull(t, "defaultItem is null");
        return switchIfEmpty(just(t));
    }

    public final Maybe<T> doOnError(Consumer<? super Throwable> consumer) {
        Consumer consumerEmptyConsumer = Functions.emptyConsumer();
        Consumer consumerEmptyConsumer2 = Functions.emptyConsumer();
        Consumer consumer2 = (Consumer) ObjectHelper.requireNonNull(consumer, "onError is null");
        Action action = Functions.EMPTY_ACTION;
        return RxJavaPlugins.onAssembly(new MaybePeek(this, consumerEmptyConsumer, consumerEmptyConsumer2, consumer2, action, action, action));
    }

    public final Maybe<T> doOnSuccess(Consumer<? super T> consumer) {
        Consumer consumerEmptyConsumer = Functions.emptyConsumer();
        Consumer consumer2 = (Consumer) ObjectHelper.requireNonNull(consumer, "onSuccess is null");
        Consumer consumerEmptyConsumer2 = Functions.emptyConsumer();
        Action action = Functions.EMPTY_ACTION;
        return RxJavaPlugins.onAssembly(new MaybePeek(this, consumerEmptyConsumer, consumer2, consumerEmptyConsumer2, action, action, action));
    }

    public final Maybe<T> filter(Predicate<? super T> predicate) {
        ObjectHelper.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.onAssembly(new MaybeFilter(this, predicate));
    }

    public final <R> Maybe<R> flatMap(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly(new MaybeFlatten(this, function));
    }

    public final <R> Observable<R> flatMapObservable(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly(new MaybeFlatMapObservable(this, function));
    }

    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly(new MaybeFlatMapCompletable(this, function));
    }

    public final Single<Boolean> isEmpty() {
        return RxJavaPlugins.onAssembly(new MaybeIsEmptySingle(this));
    }

    public final <R> Maybe<R> map(Function<? super T, ? extends R> function) {
        ObjectHelper.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.onAssembly(new MaybeMap(this, function));
    }

    public final Maybe<T> observeOn(Scheduler scheduler) {
        ObjectHelper.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.onAssembly(new MaybeObserveOn(this, scheduler));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Flowable<T> toFlowable() {
        if (this instanceof FuseToFlowable) {
            return ((FuseToFlowable) this).fuseToFlowable();
        }
        return RxJavaPlugins.onAssembly(new MaybeToFlowable(this));
    }

    public final Maybe<T> onErrorResumeNext(MaybeSource<? extends T> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, "next is null");
        return onErrorResumeNext(Functions.justFunction(maybeSource));
    }

    public final Maybe<T> onErrorResumeNext(Function<? super Throwable, ? extends MaybeSource<? extends T>> function) {
        ObjectHelper.requireNonNull(function, "resumeFunction is null");
        return RxJavaPlugins.onAssembly(new MaybeOnErrorNext(this, function, true));
    }

    @Override // io.reactivex.MaybeSource
    public final void subscribe(MaybeObserver<? super T> maybeObserver) {
        ObjectHelper.requireNonNull(maybeObserver, "observer is null");
        MaybeObserver<? super T> maybeObserverOnSubscribe = RxJavaPlugins.onSubscribe(this, maybeObserver);
        ObjectHelper.requireNonNull(maybeObserverOnSubscribe, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            subscribeActual(maybeObserverOnSubscribe);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final Maybe<T> switchIfEmpty(MaybeSource<? extends T> maybeSource) {
        ObjectHelper.requireNonNull(maybeSource, "other is null");
        return RxJavaPlugins.onAssembly(new MaybeSwitchIfEmpty(this, maybeSource));
    }
}
