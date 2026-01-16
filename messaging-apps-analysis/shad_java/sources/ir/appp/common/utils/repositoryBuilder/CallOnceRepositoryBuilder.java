package ir.appp.common.utils.repositoryBuilder;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import ir.appp.common.domain.error.ErrorHandler;
import ir.appp.common.domain.model.BaseResponse;
import ir.appp.common.utils.extentions.ViewModelExtensionsKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.flow.Flow;

/* compiled from: CallOnceRepositoryBuilder.kt */
/* loaded from: classes3.dex */
public final class CallOnceRepositoryBuilder<T> extends ViewModel {
    private final MutableLiveData<BaseResponse<T>> _mutableLiveData;
    private final ErrorHandler errorHandler;
    private final Function1<Continuation<? super Flow<? extends BaseResponse<? extends T>>>, Object> flow;
    private CoroutineScope scope;

    /* JADX WARN: Multi-variable type inference failed */
    public CallOnceRepositoryBuilder(ErrorHandler errorHandler, CoroutineScope viewModelScope, Function1<? super Continuation<? super Flow<? extends BaseResponse<? extends T>>>, ? extends Object> flow) {
        Intrinsics.checkNotNullParameter(errorHandler, "errorHandler");
        Intrinsics.checkNotNullParameter(viewModelScope, "viewModelScope");
        Intrinsics.checkNotNullParameter(flow, "flow");
        this.errorHandler = errorHandler;
        this.flow = flow;
        this.scope = CoroutineScopeKt.CoroutineScope(JobKt__JobKt.Job$default(null, 1, null).plus(viewModelScope.getCoroutineContext()));
        this._mutableLiveData = new MutableLiveData<>();
    }

    public final LiveData<BaseResponse<T>> getLiveData() {
        return (LiveData) BuildersKt__BuildersKt.runBlocking$default(null, new CallOnceRepositoryBuilder$liveData$1(this, null), 1, null);
    }

    /* compiled from: CallOnceRepositoryBuilder.kt */
    @DebugMetadata(c = "ir.appp.common.utils.repositoryBuilder.CallOnceRepositoryBuilder$retry$1", f = "CallOnceRepositoryBuilder.kt", l = {29}, m = "invokeSuspend")
    /* renamed from: ir.appp.common.utils.repositoryBuilder.CallOnceRepositoryBuilder$retry$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Flow<? extends BaseResponse<? extends T>>>, Object> {
        int label;
        final /* synthetic */ CallOnceRepositoryBuilder<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CallOnceRepositoryBuilder<T> callOnceRepositoryBuilder, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.this$0 = callOnceRepositoryBuilder;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Flow<? extends BaseResponse<? extends T>>> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function1 function1 = ((CallOnceRepositoryBuilder) this.this$0).flow;
                this.label = 1;
                obj = function1.invoke(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    public final void retry() {
        ViewModelExtensionsKt.callOnceApi(this.scope, this.errorHandler, this._mutableLiveData, new AnonymousClass1(this, null));
    }
}
