package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

/* compiled from: WithLifecycleState.kt */
/* loaded from: classes.dex */
public final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$1 implements LifecycleEventObserver {
    final /* synthetic */ Function0 $block$inlined;
    final /* synthetic */ CancellableContinuation $co;
    final /* synthetic */ Lifecycle.State $state$inlined;
    final /* synthetic */ Lifecycle $this_suspendWithStateAtLeastUnchecked$inlined;

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        Object objM542constructorimpl;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.upTo(this.$state$inlined)) {
            this.$this_suspendWithStateAtLeastUnchecked$inlined.removeObserver(this);
            CancellableContinuation cancellableContinuation = this.$co;
            Function0 function0 = this.$block$inlined;
            try {
                Result.Companion companion = Result.Companion;
                objM542constructorimpl = Result.m542constructorimpl(function0.invoke());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                objM542constructorimpl = Result.m542constructorimpl(ResultKt.createFailure(th));
            }
            cancellableContinuation.resumeWith(objM542constructorimpl);
            return;
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.$this_suspendWithStateAtLeastUnchecked$inlined.removeObserver(this);
            CancellableContinuation cancellableContinuation2 = this.$co;
            LifecycleDestroyedException lifecycleDestroyedException = new LifecycleDestroyedException();
            Result.Companion companion3 = Result.Companion;
            cancellableContinuation2.resumeWith(Result.m542constructorimpl(ResultKt.createFailure(lifecycleDestroyedException)));
        }
    }
}
