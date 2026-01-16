package kotlinx.coroutines;

import kotlin.Unit;

/* compiled from: JobSupport.kt */
/* loaded from: classes4.dex */
public final class ChildContinuation extends JobCancellingNode<Job> {
    public final CancellableContinuationImpl<?> child;

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    public ChildContinuation(Job job, CancellableContinuationImpl<?> cancellableContinuationImpl) {
        super(job);
        this.child = cancellableContinuationImpl;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(Throwable th) {
        CancellableContinuationImpl<?> cancellableContinuationImpl = this.child;
        cancellableContinuationImpl.parentCancelled$kotlinx_coroutines_core(cancellableContinuationImpl.getContinuationCancellationCause(this.job));
    }
}
