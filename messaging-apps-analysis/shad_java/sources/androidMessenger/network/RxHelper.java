package androidMessenger.network;

import androidMessenger.network.RxHelper;
import androidMessenger.utilites.MyLog;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class RxHelper {
    public <T> ObservableTransformer<T, T> applySchedulers() {
        return new ObservableTransformer<T, T>(this) { // from class: androidMessenger.network.RxHelper.1
            @Override // io.reactivex.ObservableTransformer
            public ObservableSource<T> apply(Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io());
            }
        };
    }

    public <T> ObservableTransformer<T, T> addRegularRetryAndDelay() {
        return addRetryAndDelay(0, 2, 3, 5, 10);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: androidMessenger.network.RxHelper$2, reason: invalid class name */
    class AnonymousClass2<T> implements ObservableTransformer<T, T> {
        final /* synthetic */ int val$delaySecond;
        final /* synthetic */ int val$retryCount;

        AnonymousClass2(RxHelper rxHelper, int i, int i2) {
            this.val$retryCount = i;
            this.val$delaySecond = i2;
        }

        @Override // io.reactivex.ObservableTransformer
        public ObservableSource<T> apply(Observable<T> observable) {
            final int i = this.val$retryCount;
            final int i2 = this.val$delaySecond;
            return observable.retryWhen(new Function() { // from class: androidMessenger.network.RxHelper$2$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return RxHelper.AnonymousClass2.lambda$apply$2(i, i2, (Observable) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ ObservableSource lambda$apply$2(final int i, final int i2, Observable observable) throws Exception {
            return observable.zipWith(Observable.range(1, i + 1), new BiFunction() { // from class: androidMessenger.network.RxHelper$2$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return RxHelper.AnonymousClass2.lambda$apply$0(i, (Throwable) obj, (Integer) obj2);
                }
            }).flatMap(new Function() { // from class: androidMessenger.network.RxHelper$2$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return RxHelper.AnonymousClass2.lambda$apply$1(i2, (Integer) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Integer lambda$apply$0(int i, Throwable th, Integer num) throws Exception {
            if (num.intValue() < i + 1) {
                return num;
            }
            if (th instanceof Exception) {
                throw ((Exception) th);
            }
            throw new Exception(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ ObservableSource lambda$apply$1(int i, Integer num) throws Exception {
            MyLog.e("addRetryAndDelay", "delay retry by " + i + " second(s)");
            MyLog.e("ApiReqCore", "delay retry by " + i + " second(s)");
            return Observable.timer(i, TimeUnit.SECONDS);
        }
    }

    public <T> ObservableTransformer<T, T> addRetryAndDelay(int i, int i2) {
        return new AnonymousClass2(this, i, i2);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: androidMessenger.network.RxHelper$3, reason: invalid class name */
    class AnonymousClass3<T> implements ObservableTransformer<T, T> {
        final /* synthetic */ int[] val$delay;

        AnonymousClass3(RxHelper rxHelper, int[] iArr) {
            this.val$delay = iArr;
        }

        @Override // io.reactivex.ObservableTransformer
        public ObservableSource<T> apply(Observable<T> observable) {
            final int[] iArr = this.val$delay;
            return observable.retryWhen(new Function() { // from class: androidMessenger.network.RxHelper$3$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return RxHelper.AnonymousClass3.lambda$apply$2(iArr, (Observable) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ ObservableSource lambda$apply$2(final int[] iArr, Observable observable) throws Exception {
            return observable.zipWith(Observable.range(1, iArr.length + 1), new BiFunction() { // from class: androidMessenger.network.RxHelper$3$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return RxHelper.AnonymousClass3.lambda$apply$0(iArr, (Throwable) obj, (Integer) obj2);
                }
            }).flatMap(new Function() { // from class: androidMessenger.network.RxHelper$3$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return RxHelper.AnonymousClass3.lambda$apply$1(iArr, (Integer) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Integer lambda$apply$0(int[] iArr, Throwable th, Integer num) throws Exception {
            if (num.intValue() < iArr.length + 1) {
                return num;
            }
            throw new Exception(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ ObservableSource lambda$apply$1(int[] iArr, Integer num) throws Exception {
            MyLog.e("addRetryAndDelay", "delay retry by " + iArr[num.intValue() - 1] + " second(s)");
            MyLog.e("ApiReqCore", "delay retry by " + iArr[num.intValue() + (-1)] + " second(s)");
            return Observable.timer(iArr[num.intValue() - 1], TimeUnit.SECONDS);
        }
    }

    public <T> ObservableTransformer<T, T> addRetryAndDelay(int... iArr) {
        return new AnonymousClass3(this, iArr);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: androidMessenger.network.RxHelper$4, reason: invalid class name */
    class AnonymousClass4<T> implements ObservableTransformer<T, T> {
        private long currentTime;
        final /* synthetic */ int[] val$delay;
        final /* synthetic */ int val$diffTime;

        AnonymousClass4(RxHelper rxHelper, int[] iArr, int i) {
            this.val$delay = iArr;
            this.val$diffTime = i;
        }

        @Override // io.reactivex.ObservableTransformer
        public ObservableSource<T> apply(Observable<T> observable) {
            final int[] iArr = this.val$delay;
            final int i = this.val$diffTime;
            return observable.retryWhen(new Function() { // from class: androidMessenger.network.RxHelper$4$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return this.f$0.lambda$apply$2(iArr, i, (Observable) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ ObservableSource lambda$apply$2(final int[] iArr, final int i, Observable observable) throws Exception {
            return observable.zipWith(Observable.range(1, iArr.length + 1), new BiFunction() { // from class: androidMessenger.network.RxHelper$4$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return this.f$0.lambda$apply$0(iArr, i, (Throwable) obj, (Integer) obj2);
                }
            }).flatMap(new Function() { // from class: androidMessenger.network.RxHelper$4$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return RxHelper.AnonymousClass4.lambda$apply$1(iArr, (Integer) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Integer lambda$apply$0(int[] iArr, int i, Throwable th, Integer num) throws Exception {
            if (num.intValue() == 1) {
                this.currentTime = System.currentTimeMillis();
            }
            if (num.intValue() >= iArr.length + 1 || System.currentTimeMillis() - this.currentTime > i * 1000) {
                throw new Exception(th);
            }
            return num;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ ObservableSource lambda$apply$1(int[] iArr, Integer num) throws Exception {
            MyLog.e("addRetryAndDelay", "delay retry by " + iArr[num.intValue() - 1] + " second(s)");
            MyLog.e("ApiReqCore", "delay retry by " + iArr[num.intValue() + (-1)] + " second(s)");
            return Observable.timer(iArr[num.intValue() - 1], TimeUnit.SECONDS);
        }
    }

    public <T> ObservableTransformer<T, T> addRetryAndDelayWithTime(int i, int... iArr) {
        return new AnonymousClass4(this, iArr, i);
    }
}
