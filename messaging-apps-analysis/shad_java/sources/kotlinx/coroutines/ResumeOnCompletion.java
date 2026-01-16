package kotlinx.coroutines;

import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: JobSupport.kt */
/* loaded from: classes4.dex */
final class ResumeOnCompletion extends JobNode<Job> {
    private final Continuation<Unit> continuation;

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ResumeOnCompletion(Job job, Continuation<? super Unit> continuation) {
        super(job);
        this.continuation = continuation;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(Throwable th) {
        Continuation<Unit> continuation = this.continuation;
        Unit unit = Unit.INSTANCE;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m542constructorimpl(unit));
    }
}
