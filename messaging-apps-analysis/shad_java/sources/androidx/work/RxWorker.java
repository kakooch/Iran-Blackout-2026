package androidx.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.SynchronousExecutor;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class RxWorker extends ListenableWorker {
    static final Executor INSTANT_EXECUTOR = new SynchronousExecutor();
    private SingleFutureAdapter<ListenableWorker.Result> mSingleFutureObserverAdapter;

    public abstract Single<ListenableWorker.Result> createWork();

    public RxWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @Override // androidx.work.ListenableWorker
    public ListenableFuture<ListenableWorker.Result> startWork() {
        this.mSingleFutureObserverAdapter = new SingleFutureAdapter<>();
        createWork().subscribeOn(getBackgroundScheduler()).observeOn(Schedulers.from(getTaskExecutor().getBackgroundExecutor())).subscribe(this.mSingleFutureObserverAdapter);
        return this.mSingleFutureObserverAdapter.mFuture;
    }

    protected Scheduler getBackgroundScheduler() {
        return Schedulers.from(getBackgroundExecutor());
    }

    @Override // androidx.work.ListenableWorker
    public void onStopped() {
        super.onStopped();
        SingleFutureAdapter<ListenableWorker.Result> singleFutureAdapter = this.mSingleFutureObserverAdapter;
        if (singleFutureAdapter != null) {
            singleFutureAdapter.dispose();
            this.mSingleFutureObserverAdapter = null;
        }
    }

    static class SingleFutureAdapter<T> implements SingleObserver<T>, Runnable {
        private Disposable mDisposable;
        final SettableFuture<T> mFuture;

        SingleFutureAdapter() {
            SettableFuture<T> settableFutureCreate = SettableFuture.create();
            this.mFuture = settableFutureCreate;
            settableFutureCreate.addListener(this, RxWorker.INSTANT_EXECUTOR);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            this.mDisposable = disposable;
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            this.mFuture.set(t);
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.mFuture.setException(th);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mFuture.isCancelled()) {
                dispose();
            }
        }

        void dispose() {
            Disposable disposable = this.mDisposable;
            if (disposable != null) {
                disposable.dispose();
            }
        }
    }
}
