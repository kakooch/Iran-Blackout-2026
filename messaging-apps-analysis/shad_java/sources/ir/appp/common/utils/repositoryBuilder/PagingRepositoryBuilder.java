package ir.appp.common.utils.repositoryBuilder;

import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ir.appp.common.domain.error.ErrorHandler;
import ir.appp.common.domain.model.BaseResponse;
import java.util.concurrent.CancellationException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.SharingStarted;

/* compiled from: PagingRepositoryBuilder.kt */
/* loaded from: classes3.dex */
public final class PagingRepositoryBuilder<T> {
    private final MutableLiveData<BaseResponse<T>> _mutableLiveData;
    private final MutableSharedFlow<Pair<String, Bundle>> _paginatorSharedFlow;
    private final ErrorHandler errorHandler;
    private final Bundle extras;
    private final Function3<String, Bundle, Continuation<? super Flow<? extends BaseResponse<? extends T>>>, Object> flow;
    private Job job;
    private final LiveData<BaseResponse<T>> liveData;
    private final boolean retryAtInit;
    private CoroutineScope scope;
    private final String startIdInitValue;

    /* JADX WARN: Multi-variable type inference failed */
    public PagingRepositoryBuilder(CoroutineScope viewModelScope, ErrorHandler errorHandler, boolean z, String str, Bundle bundle, Function3<? super String, ? super Bundle, ? super Continuation<? super Flow<? extends BaseResponse<? extends T>>>, ? extends Object> flow) {
        Intrinsics.checkNotNullParameter(viewModelScope, "viewModelScope");
        Intrinsics.checkNotNullParameter(errorHandler, "errorHandler");
        Intrinsics.checkNotNullParameter(flow, "flow");
        this.errorHandler = errorHandler;
        this.retryAtInit = z;
        this.startIdInitValue = str;
        this.extras = bundle;
        this.flow = flow;
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(viewModelScope.getCoroutineContext()));
        this._paginatorSharedFlow = SharedFlowKt.MutableSharedFlow(1, 0, BufferOverflow.SUSPEND);
        MutableLiveData<BaseResponse<T>> mutableLiveData = new MutableLiveData<>();
        this._mutableLiveData = mutableLiveData;
        this.liveData = mutableLiveData;
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass1(this, null), 3, null);
    }

    public /* synthetic */ PagingRepositoryBuilder(CoroutineScope coroutineScope, ErrorHandler errorHandler, boolean z, String str, Bundle bundle, Function3 function3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineScope, errorHandler, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : bundle, function3);
    }

    public final LiveData<BaseResponse<T>> getLiveData() {
        return this.liveData;
    }

    /* compiled from: PagingRepositoryBuilder.kt */
    @DebugMetadata(c = "ir.appp.common.utils.repositoryBuilder.PagingRepositoryBuilder$1", f = "PagingRepositoryBuilder.kt", l = {32, 38}, m = "invokeSuspend")
    /* renamed from: ir.appp.common.utils.repositoryBuilder.PagingRepositoryBuilder$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PagingRepositoryBuilder<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PagingRepositoryBuilder<T> pagingRepositoryBuilder, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = pagingRepositoryBuilder;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (((PagingRepositoryBuilder) this.this$0).retryAtInit) {
                    MutableSharedFlow mutableSharedFlow = ((PagingRepositoryBuilder) this.this$0)._paginatorSharedFlow;
                    Pair pair = new Pair(((PagingRepositoryBuilder) this.this$0).startIdInitValue, ((PagingRepositoryBuilder) this.this$0).extras);
                    this.label = 1;
                    if (mutableSharedFlow.emit(pair, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Flow flowOnEach = FlowKt.onEach(((PagingRepositoryBuilder) this.this$0)._paginatorSharedFlow, new C00201(this.this$0, null));
            this.label = 2;
            if (FlowKt.collect(flowOnEach, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }

        /* compiled from: PagingRepositoryBuilder.kt */
        @DebugMetadata(c = "ir.appp.common.utils.repositoryBuilder.PagingRepositoryBuilder$1$1", f = "PagingRepositoryBuilder.kt", l = {}, m = "invokeSuspend")
        /* renamed from: ir.appp.common.utils.repositoryBuilder.PagingRepositoryBuilder$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00201 extends SuspendLambda implements Function2<Pair<? extends String, ? extends Bundle>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ PagingRepositoryBuilder<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00201(PagingRepositoryBuilder<T> pagingRepositoryBuilder, Continuation<? super C00201> continuation) {
                super(2, continuation);
                this.this$0 = pagingRepositoryBuilder;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00201 c00201 = new C00201(this.this$0, continuation);
                c00201.L$0 = obj;
                return c00201;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Pair<? extends String, ? extends Bundle> pair, Continuation<? super Unit> continuation) {
                return invoke2((Pair<String, Bundle>) pair, continuation);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Pair<String, Bundle> pair, Continuation<? super Unit> continuation) {
                return ((C00201) create(pair, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Pair pair = (Pair) this.L$0;
                this.this$0.invokeFlow((String) pair.getFirst(), (Bundle) pair.getSecond());
                return Unit.INSTANCE;
            }
        }
    }

    /* compiled from: PagingRepositoryBuilder.kt */
    @DebugMetadata(c = "ir.appp.common.utils.repositoryBuilder.PagingRepositoryBuilder$invokeFlow$1", f = "PagingRepositoryBuilder.kt", l = {}, m = "invokeSuspend")
    /* renamed from: ir.appp.common.utils.repositoryBuilder.PagingRepositoryBuilder$invokeFlow$1, reason: invalid class name and case insensitive filesystem */
    static final class C00881 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bundle $extras;
        final /* synthetic */ String $startId;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ PagingRepositoryBuilder<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00881(PagingRepositoryBuilder<T> pagingRepositoryBuilder, String str, Bundle bundle, Continuation<? super C00881> continuation) {
            super(2, continuation);
            this.this$0 = pagingRepositoryBuilder;
            this.$startId = str;
            this.$extras = bundle;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00881 c00881 = new C00881(this.this$0, this.$startId, this.$extras, continuation);
            c00881.L$0 = obj;
            return c00881;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C00881) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            if (!(((PagingRepositoryBuilder) this.this$0)._mutableLiveData.getValue() instanceof BaseResponse.Loading)) {
                try {
                    PagingRepositoryBuilder<T> pagingRepositoryBuilder = this.this$0;
                    ((PagingRepositoryBuilder) pagingRepositoryBuilder).job = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C00211(pagingRepositoryBuilder, this.$startId, this.$extras, null), 3, null);
                } catch (CancellationException e) {
                    ((PagingRepositoryBuilder) this.this$0)._mutableLiveData.setValue(new BaseResponse.Error(((PagingRepositoryBuilder) this.this$0).errorHandler.getError(e)));
                }
            }
            return Unit.INSTANCE;
        }

        /* compiled from: PagingRepositoryBuilder.kt */
        @DebugMetadata(c = "ir.appp.common.utils.repositoryBuilder.PagingRepositoryBuilder$invokeFlow$1$1", f = "PagingRepositoryBuilder.kt", l = {48, 54}, m = "invokeSuspend")
        /* renamed from: ir.appp.common.utils.repositoryBuilder.PagingRepositoryBuilder$invokeFlow$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00211 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Bundle $extras;
            final /* synthetic */ String $startId;
            int label;
            final /* synthetic */ PagingRepositoryBuilder<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00211(PagingRepositoryBuilder<T> pagingRepositoryBuilder, String str, Bundle bundle, Continuation<? super C00211> continuation) {
                super(2, continuation);
                this.this$0 = pagingRepositoryBuilder;
                this.$startId = str;
                this.$extras = bundle;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00211(this.this$0, this.$startId, this.$extras, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00211) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Function3 function3 = ((PagingRepositoryBuilder) this.this$0).flow;
                    String str = this.$startId;
                    Bundle bundle = this.$extras;
                    this.label = 1;
                    obj = function3.invoke(str, bundle, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        if (i == 2) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Flow flowBuffer = FlowKt.buffer(FlowKt.onEach(FlowKt.cancellable((Flow) obj), new C00221(this.this$0, null)), 1, BufferOverflow.SUSPEND);
                this.label = 2;
                if (FlowKt.collect(flowBuffer, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }

            /* compiled from: PagingRepositoryBuilder.kt */
            @DebugMetadata(c = "ir.appp.common.utils.repositoryBuilder.PagingRepositoryBuilder$invokeFlow$1$1$1", f = "PagingRepositoryBuilder.kt", l = {}, m = "invokeSuspend")
            /* renamed from: ir.appp.common.utils.repositoryBuilder.PagingRepositoryBuilder$invokeFlow$1$1$1, reason: invalid class name and collision with other inner class name */
            static final class C00221 extends SuspendLambda implements Function2<BaseResponse<? extends T>, Continuation<? super Unit>, Object> {
                /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ PagingRepositoryBuilder<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00221(PagingRepositoryBuilder<T> pagingRepositoryBuilder, Continuation<? super C00221> continuation) {
                    super(2, continuation);
                    this.this$0 = pagingRepositoryBuilder;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C00221 c00221 = new C00221(this.this$0, continuation);
                    c00221.L$0 = obj;
                    return c00221;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(BaseResponse<? extends T> baseResponse, Continuation<? super Unit> continuation) {
                    return ((C00221) create(baseResponse, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    ((PagingRepositoryBuilder) this.this$0)._mutableLiveData.setValue((BaseResponse) this.L$0);
                    return Unit.INSTANCE;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invokeFlow(String str, Bundle bundle) {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C00881(this, str, bundle, null), 3, null);
    }

    /* compiled from: PagingRepositoryBuilder.kt */
    @DebugMetadata(c = "ir.appp.common.utils.repositoryBuilder.PagingRepositoryBuilder$nextPage$1", f = "PagingRepositoryBuilder.kt", l = {66}, m = "invokeSuspend")
    /* renamed from: ir.appp.common.utils.repositoryBuilder.PagingRepositoryBuilder$nextPage$1, reason: invalid class name and case insensitive filesystem */
    static final class C00891 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bundle $extras;
        final /* synthetic */ String $startId;
        int label;
        final /* synthetic */ PagingRepositoryBuilder<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00891(PagingRepositoryBuilder<T> pagingRepositoryBuilder, String str, Bundle bundle, Continuation<? super C00891> continuation) {
            super(2, continuation);
            this.this$0 = pagingRepositoryBuilder;
            this.$startId = str;
            this.$extras = bundle;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00891(this.this$0, this.$startId, this.$extras, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C00891) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow mutableSharedFlow = ((PagingRepositoryBuilder) this.this$0)._paginatorSharedFlow;
                Pair pair = new Pair(this.$startId, this.$extras);
                this.label = 1;
                if (mutableSharedFlow.emit(pair, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void nextPage$default(PagingRepositoryBuilder pagingRepositoryBuilder, String str, Bundle bundle, int i, Object obj) {
        if ((i & 2) != 0) {
            bundle = null;
        }
        pagingRepositoryBuilder.nextPage(str, bundle);
    }

    public final void nextPage(String str, Bundle bundle) {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C00891(this, str, bundle, null), 3, null);
    }

    /* compiled from: PagingRepositoryBuilder.kt */
    @DebugMetadata(c = "ir.appp.common.utils.repositoryBuilder.PagingRepositoryBuilder$retry$1", f = "PagingRepositoryBuilder.kt", l = {76}, m = "invokeSuspend")
    /* renamed from: ir.appp.common.utils.repositoryBuilder.PagingRepositoryBuilder$retry$1, reason: invalid class name and case insensitive filesystem */
    static final class C00901 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PagingRepositoryBuilder<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00901(PagingRepositoryBuilder<T> pagingRepositoryBuilder, Continuation<? super C00901> continuation) {
            super(2, continuation);
            this.this$0 = pagingRepositoryBuilder;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00901(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C00901) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flowOnEach = FlowKt.onEach(FlowKt.shareIn(((PagingRepositoryBuilder) this.this$0)._paginatorSharedFlow, ((PagingRepositoryBuilder) this.this$0).scope, SharingStarted.Companion.getEagerly(), 1), new C00231(this.this$0, null));
                this.label = 1;
                if (FlowKt.collect(flowOnEach, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* compiled from: PagingRepositoryBuilder.kt */
        @DebugMetadata(c = "ir.appp.common.utils.repositoryBuilder.PagingRepositoryBuilder$retry$1$1", f = "PagingRepositoryBuilder.kt", l = {}, m = "invokeSuspend")
        /* renamed from: ir.appp.common.utils.repositoryBuilder.PagingRepositoryBuilder$retry$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00231 extends SuspendLambda implements Function2<Pair<? extends String, ? extends Bundle>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ PagingRepositoryBuilder<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00231(PagingRepositoryBuilder<T> pagingRepositoryBuilder, Continuation<? super C00231> continuation) {
                super(2, continuation);
                this.this$0 = pagingRepositoryBuilder;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00231 c00231 = new C00231(this.this$0, continuation);
                c00231.L$0 = obj;
                return c00231;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Pair<? extends String, ? extends Bundle> pair, Continuation<? super Unit> continuation) {
                return invoke2((Pair<String, Bundle>) pair, continuation);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Pair<String, Bundle> pair, Continuation<? super Unit> continuation) {
                return ((C00231) create(pair, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Pair pair = (Pair) this.L$0;
                this.this$0.invokeFlow((String) pair.getFirst(), (Bundle) pair.getSecond());
                return Unit.INSTANCE;
            }
        }
    }

    public final void retry() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C00901(this, null), 3, null);
    }
}
