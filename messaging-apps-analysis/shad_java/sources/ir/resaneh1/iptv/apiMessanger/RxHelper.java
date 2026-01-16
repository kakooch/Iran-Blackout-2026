package ir.resaneh1.iptv.apiMessanger;

import android.util.Log;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import ir.resaneh1.iptv.apiMessanger.RxHelper;
import ir.resaneh1.iptv.model.GetEndpointDataOutput;
import ir.resaneh1.iptv.model.MessangerOutput;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class RxHelper {
    public <T> ObservableTransformer<T, T> applySchedulers() {
        return new ObservableTransformer<T, T>(this) { // from class: ir.resaneh1.iptv.apiMessanger.RxHelper.1
            @Override // io.reactivex.ObservableTransformer
            public ObservableSource<T> apply(Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public <T> ObservableTransformer<T, T> addRegularRetryAndDelay() {
        return addRetryAndDelay(0, 2, 3, 5, 10);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: ir.resaneh1.iptv.apiMessanger.RxHelper$2, reason: invalid class name */
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
            return observable.retryWhen(new Function() { // from class: ir.resaneh1.iptv.apiMessanger.RxHelper$2$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return RxHelper.AnonymousClass2.lambda$apply$2(i, i2, (Observable) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ ObservableSource lambda$apply$2(final int i, final int i2, Observable observable) throws Exception {
            return observable.zipWith(Observable.range(1, i + 1), new BiFunction() { // from class: ir.resaneh1.iptv.apiMessanger.RxHelper$2$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return RxHelper.AnonymousClass2.lambda$apply$0(i, (Throwable) obj, (Integer) obj2);
                }
            }).flatMap(new Function() { // from class: ir.resaneh1.iptv.apiMessanger.RxHelper$2$$ExternalSyntheticLambda1
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
            Log.e("addRetryAndDelay", "delay retry by " + i + " second(s)");
            return Observable.timer(i, TimeUnit.SECONDS);
        }
    }

    public <T> ObservableTransformer<T, T> addRetryAndDelay(int i, int i2) {
        return new AnonymousClass2(this, i, i2);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: ir.resaneh1.iptv.apiMessanger.RxHelper$3, reason: invalid class name */
    class AnonymousClass3<T> implements ObservableTransformer<T, T> {
        final /* synthetic */ int[] val$delay;

        AnonymousClass3(RxHelper rxHelper, int[] iArr) {
            this.val$delay = iArr;
        }

        @Override // io.reactivex.ObservableTransformer
        public ObservableSource<T> apply(Observable<T> observable) {
            final int[] iArr = this.val$delay;
            return observable.retryWhen(new Function() { // from class: ir.resaneh1.iptv.apiMessanger.RxHelper$3$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return RxHelper.AnonymousClass3.lambda$apply$2(iArr, (Observable) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ ObservableSource lambda$apply$2(final int[] iArr, Observable observable) throws Exception {
            return observable.zipWith(Observable.range(1, iArr.length + 1), new BiFunction() { // from class: ir.resaneh1.iptv.apiMessanger.RxHelper$3$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return RxHelper.AnonymousClass3.lambda$apply$0(iArr, (Throwable) obj, (Integer) obj2);
                }
            }).flatMap(new Function() { // from class: ir.resaneh1.iptv.apiMessanger.RxHelper$3$$ExternalSyntheticLambda2
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
            Log.e("addRetryAndDelay", "delay retry by " + iArr[num.intValue() - 1] + " second(s)");
            return Observable.timer(iArr[num.intValue() - 1], TimeUnit.SECONDS);
        }
    }

    public <T> ObservableTransformer<T, T> addRetryAndDelay(int... iArr) {
        return new AnonymousClass3(this, iArr);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: ir.resaneh1.iptv.apiMessanger.RxHelper$4, reason: invalid class name */
    class AnonymousClass4<T> implements ObservableTransformer<T, T> {
        final /* synthetic */ int val$delayMillis;
        final /* synthetic */ int val$retryCount;

        AnonymousClass4(RxHelper rxHelper, int i, int i2) {
            this.val$retryCount = i;
            this.val$delayMillis = i2;
        }

        @Override // io.reactivex.ObservableTransformer
        public ObservableSource<T> apply(Observable<T> observable) {
            final int i = this.val$retryCount;
            final int i2 = this.val$delayMillis;
            return observable.retryWhen(new Function() { // from class: ir.resaneh1.iptv.apiMessanger.RxHelper$4$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return RxHelper.AnonymousClass4.lambda$apply$2(i, i2, (Observable) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ ObservableSource lambda$apply$2(final int i, final int i2, Observable observable) throws Exception {
            return observable.zipWith(Observable.range(1, i + 1), new BiFunction() { // from class: ir.resaneh1.iptv.apiMessanger.RxHelper$4$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return RxHelper.AnonymousClass4.lambda$apply$0(i, (Throwable) obj, (Integer) obj2);
                }
            }).flatMap(new Function() { // from class: ir.resaneh1.iptv.apiMessanger.RxHelper$4$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return RxHelper.AnonymousClass4.lambda$apply$1(i2, (Integer) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Integer lambda$apply$0(int i, Throwable th, Integer num) throws Exception {
            if (num.intValue() < i + 1) {
                return num;
            }
            throw new Exception(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ ObservableSource lambda$apply$1(int i, Integer num) throws Exception {
            return Observable.timer(i, TimeUnit.MILLISECONDS);
        }
    }

    public <T> ObservableTransformer<T, T> addRetryAndDelayMilliSecond(int i, int i2) {
        return new AnonymousClass4(this, i, i2);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: ir.resaneh1.iptv.apiMessanger.RxHelper$5, reason: invalid class name */
    class AnonymousClass5<T> implements ObservableTransformer<T, T> {
        final /* synthetic */ int val$delaySecond;

        AnonymousClass5(RxHelper rxHelper, int i) {
            this.val$delaySecond = i;
        }

        @Override // io.reactivex.ObservableTransformer
        public ObservableSource<T> apply(Observable<T> observable) {
            final int i = this.val$delaySecond;
            return observable.retryWhen(new Function() { // from class: ir.resaneh1.iptv.apiMessanger.RxHelper$5$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return RxHelper.AnonymousClass5.lambda$apply$1(i, (Observable) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ ObservableSource lambda$apply$1(final int i, Observable observable) throws Exception {
            return observable.flatMap(new Function() { // from class: ir.resaneh1.iptv.apiMessanger.RxHelper$5$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return RxHelper.AnonymousClass5.lambda$apply$0(i, (Throwable) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ ObservableSource lambda$apply$0(int i, Throwable th) throws Exception {
            Log.e("addInfinitRetryAndDelay", "delay retry by " + i + " second(s)");
            return Observable.timer(i, TimeUnit.SECONDS);
        }
    }

    public <T> ObservableTransformer<T, T> addInfiniteRetryAndDelay(int i) {
        return new AnonymousClass5(this, i);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: ir.resaneh1.iptv.apiMessanger.RxHelper$6, reason: invalid class name */
    class AnonymousClass6<T> implements ObservableTransformer<T, T> {
        final /* synthetic */ long val$miliSecond;

        AnonymousClass6(RxHelper rxHelper, long j) {
            this.val$miliSecond = j;
        }

        @Override // io.reactivex.ObservableTransformer
        public ObservableSource<T> apply(Observable<T> observable) {
            final long j = this.val$miliSecond;
            return observable.retryWhen(new Function() { // from class: ir.resaneh1.iptv.apiMessanger.RxHelper$6$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return RxHelper.AnonymousClass6.lambda$apply$1(j, (Observable) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ ObservableSource lambda$apply$1(final long j, Observable observable) throws Exception {
            return observable.flatMap(new Function() { // from class: ir.resaneh1.iptv.apiMessanger.RxHelper$6$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return RxHelper.AnonymousClass6.lambda$apply$0(j, (Throwable) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ ObservableSource lambda$apply$0(long j, Throwable th) throws Exception {
            return Observable.timer(j, TimeUnit.MILLISECONDS);
        }
    }

    public <T> ObservableTransformer<T, T> addInfiniteRetryAndDelayMiliSecond(long j) {
        return new AnonymousClass6(this, j);
    }

    public Observable<MessangerOutput<GetEndpointDataOutput>[]> zipMultiDataOutput(List<Observable<MessangerOutput<GetEndpointDataOutput>>> list) {
        return Observable.zip(list, new Function<Object[], MessangerOutput<GetEndpointDataOutput>[]>(this) { // from class: ir.resaneh1.iptv.apiMessanger.RxHelper.7
            @Override // io.reactivex.functions.Function
            public MessangerOutput<GetEndpointDataOutput>[] apply(Object[] objArr) throws Exception {
                MessangerOutput<GetEndpointDataOutput>[] messangerOutputArr = new MessangerOutput[objArr.length];
                for (int i = 0; i < objArr.length; i++) {
                    messangerOutputArr[i] = (MessangerOutput) objArr[i];
                }
                return messangerOutputArr;
            }
        });
    }
}
