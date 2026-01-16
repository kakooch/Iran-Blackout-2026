package ir.appp.common.utils.repositoryBuilder;

import androidx.lifecycle.MutableLiveData;
import ir.appp.common.domain.model.BaseResponse;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: CallOnceRepositoryBuilder.kt */
@DebugMetadata(c = "ir.appp.common.utils.repositoryBuilder.CallOnceRepositoryBuilder$liveData$1", f = "CallOnceRepositoryBuilder.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class CallOnceRepositoryBuilder$liveData$1<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super MutableLiveData<BaseResponse<? extends T>>>, Object> {
    int label;
    final /* synthetic */ CallOnceRepositoryBuilder<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CallOnceRepositoryBuilder$liveData$1(CallOnceRepositoryBuilder<T> callOnceRepositoryBuilder, Continuation<? super CallOnceRepositoryBuilder$liveData$1> continuation) {
        super(2, continuation);
        this.this$0 = callOnceRepositoryBuilder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CallOnceRepositoryBuilder$liveData$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super MutableLiveData<BaseResponse<T>>> continuation) {
        return ((CallOnceRepositoryBuilder$liveData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.retry();
        return ((CallOnceRepositoryBuilder) this.this$0)._mutableLiveData;
    }
}
