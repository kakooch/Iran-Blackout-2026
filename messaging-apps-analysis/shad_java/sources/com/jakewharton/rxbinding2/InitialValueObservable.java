package com.jakewharton.rxbinding2;

import io.reactivex.Observable;
import io.reactivex.Observer;

/* loaded from: classes3.dex */
public abstract class InitialValueObservable<T> extends Observable<T> {
    protected abstract T getInitialValue();

    protected abstract void subscribeListener(Observer<? super T> observer);

    @Override // io.reactivex.Observable
    protected final void subscribeActual(Observer<? super T> observer) {
        subscribeListener(observer);
        observer.onNext(getInitialValue());
    }
}
