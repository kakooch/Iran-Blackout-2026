package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.EndConsumerHelper;

/* loaded from: classes3.dex */
public abstract class DefaultObserver<T> implements Observer<T> {
    private Disposable upstream;

    protected void onStart() {
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        if (EndConsumerHelper.validate(this.upstream, disposable, getClass())) {
            this.upstream = disposable;
            onStart();
        }
    }
}
