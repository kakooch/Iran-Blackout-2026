package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* compiled from: LifecycleController.kt */
/* loaded from: classes.dex */
final class LifecycleController$observer$1 implements LifecycleEventObserver {
    final /* synthetic */ Job $parentJob;
    final /* synthetic */ LifecycleController this$0;

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "<anonymous parameter 1>");
        Lifecycle lifecycle = source.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "source.lifecycle");
        if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
            Lifecycle lifecycle2 = source.getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle2, "source.lifecycle");
            if (lifecycle2.getCurrentState().compareTo(LifecycleController.access$getMinState$p(this.this$0)) < 0) {
                LifecycleController.access$getDispatchQueue$p(this.this$0);
                throw null;
            }
            LifecycleController.access$getDispatchQueue$p(this.this$0);
            throw null;
        }
        Job.DefaultImpls.cancel$default(this.$parentJob, null, 1, null);
        throw null;
    }
}
