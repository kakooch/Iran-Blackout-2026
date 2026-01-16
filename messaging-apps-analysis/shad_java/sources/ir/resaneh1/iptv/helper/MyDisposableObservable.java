package ir.resaneh1.iptv.helper;

import io.reactivex.observers.DisposableObserver;

/* loaded from: classes3.dex */
public abstract class MyDisposableObservable<T> extends DisposableObserver<T> {
    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        onComplete();
    }
}
