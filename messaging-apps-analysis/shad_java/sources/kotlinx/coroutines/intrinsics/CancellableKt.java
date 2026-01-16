package kotlinx.coroutines.intrinsics;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.internal.DispatchedContinuationKt;

/* compiled from: Cancellable.kt */
/* loaded from: classes4.dex */
public final class CancellableKt {
    public static /* synthetic */ void startCoroutineCancellable$default(Function2 function2, Object obj, Continuation continuation, Function1 function1, int i, Object obj2) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        startCoroutineCancellable(function2, obj, continuation, function1);
    }

    public static final <R, T> void startCoroutineCancellable(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation, Function1<? super Throwable, Unit> function1) {
        try {
            Continuation continuationIntercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function2, r, continuation));
            Result.Companion companion = Result.Companion;
            DispatchedContinuationKt.resumeCancellableWith(continuationIntercepted, Result.m542constructorimpl(Unit.INSTANCE), function1);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            continuation.resumeWith(Result.m542constructorimpl(ResultKt.createFailure(th)));
        }
    }

    public static final void startCoroutineCancellable(Continuation<? super Unit> continuation, Continuation<?> continuation2) {
        try {
            Continuation continuationIntercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            Result.Companion companion = Result.Companion;
            DispatchedContinuationKt.resumeCancellableWith$default(continuationIntercepted, Result.m542constructorimpl(Unit.INSTANCE), null, 2, null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            continuation2.resumeWith(Result.m542constructorimpl(ResultKt.createFailure(th)));
        }
    }
}
