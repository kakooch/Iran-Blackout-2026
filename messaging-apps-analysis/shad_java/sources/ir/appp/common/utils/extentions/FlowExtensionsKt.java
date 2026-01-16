package ir.appp.common.utils.extentions;

import android.util.Log;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import ir.appp.common.domain.error.ErrorHandler;
import ir.appp.common.domain.model.BaseResponse;
import ir.appp.common.utils.extentions.FlowExtensionsKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: FlowExtensions.kt */
/* loaded from: classes3.dex */
public final class FlowExtensionsKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: FlowExtensions.kt */
    @DebugMetadata(c = "ir.appp.common.utils.extentions.FlowExtensionsKt$toResult$2", f = "FlowExtensions.kt", l = {18}, m = "invokeSuspend")
    /* renamed from: ir.appp.common.utils.extentions.FlowExtensionsKt$toResult$2, reason: invalid class name and case insensitive filesystem */
    static final class C00872<T> extends SuspendLambda implements Function2<FlowCollector<? super BaseResponse<? extends T>>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C00872(Continuation<? super C00872> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00872 c00872 = new C00872(continuation);
            c00872.L$0 = obj;
            return c00872;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super BaseResponse<? extends T>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C00872) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Log.d("SAEED", "Loading: ");
                BaseResponse.Loading loading = BaseResponse.Loading.INSTANCE;
                this.label = 1;
                if (flowCollector.emit(loading, this) == coroutine_suspended) {
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

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: FlowExtensions.kt */
    @DebugMetadata(c = "ir.appp.common.utils.extentions.FlowExtensionsKt$toResult$3", f = "FlowExtensions.kt", l = {21}, m = "invokeSuspend")
    /* renamed from: ir.appp.common.utils.extentions.FlowExtensionsKt$toResult$3, reason: invalid class name */
    static final class AnonymousClass3<T> extends SuspendLambda implements Function3<FlowCollector<? super BaseResponse<? extends T>>, Throwable, Continuation<? super Unit>, Object> {
        final /* synthetic */ ErrorHandler $errorHandler;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(ErrorHandler errorHandler, Continuation<? super AnonymousClass3> continuation) {
            super(3, continuation);
            this.$errorHandler = errorHandler;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super BaseResponse<? extends T>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$errorHandler, continuation);
            anonymousClass3.L$0 = flowCollector;
            anonymousClass3.L$1 = th;
            return anonymousClass3.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Throwable th = (Throwable) this.L$1;
                Log.d("SAEED", Intrinsics.stringPlus("Error: ", th));
                BaseResponse.Error error = new BaseResponse.Error(this.$errorHandler.getError(th));
                this.L$0 = null;
                this.label = 1;
                if (flowCollector.emit(error, this) == coroutine_suspended) {
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

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: FlowExtensions.kt */
    @DebugMetadata(c = "ir.appp.common.utils.extentions.FlowExtensionsKt$toFlow$1", f = "FlowExtensions.kt", l = {31}, m = "invokeSuspend")
    /* renamed from: ir.appp.common.utils.extentions.FlowExtensionsKt$toFlow$1, reason: invalid class name */
    static final class AnonymousClass1<T> extends SuspendLambda implements Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Observable<T> $this_toFlow;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Observable<T> observable, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_toFlow = observable;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_toFlow, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final ProducerScope producerScope = (ProducerScope) this.L$0;
                final Disposable disposableSubscribe = this.$this_toFlow.subscribe(new Consumer() { // from class: ir.appp.common.utils.extentions.FlowExtensionsKt$toFlow$1$$ExternalSyntheticLambda1
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj2) {
                        producerScope.offer(obj2);
                    }
                }, new Consumer() { // from class: ir.appp.common.utils.extentions.FlowExtensionsKt$toFlow$1$$ExternalSyntheticLambda0
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj2) {
                        producerScope.close((Throwable) obj2);
                    }
                });
                Function0<Unit> function0 = new Function0<Unit>() { // from class: ir.appp.common.utils.extentions.FlowExtensionsKt.toFlow.1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        if (disposableSubscribe.isDisposed()) {
                            return;
                        }
                        disposableSubscribe.dispose();
                    }
                };
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
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

    public static final <T> Flow<T> toFlow(Observable<T> observable) {
        Intrinsics.checkNotNullParameter(observable, "<this>");
        return FlowKt.callbackFlow(new AnonymousClass1(observable, null));
    }

    /* compiled from: FlowExtensions.kt */
    @DebugMetadata(c = "ir.appp.common.utils.extentions.FlowExtensionsKt$toFlow$2", f = "FlowExtensions.kt", l = {45}, m = "invokeSuspend")
    /* renamed from: ir.appp.common.utils.extentions.FlowExtensionsKt$toFlow$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<ProducerScope<? super Object>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Completable $this_toFlow;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Completable completable, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$this_toFlow = completable;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_toFlow, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super Object> producerScope, Continuation<? super Unit> continuation) {
            return invoke2((ProducerScope<Object>) producerScope, continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(ProducerScope<Object> producerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final ProducerScope producerScope = (ProducerScope) this.L$0;
                final Disposable disposableSubscribe = this.$this_toFlow.subscribe(new Action() { // from class: ir.appp.common.utils.extentions.FlowExtensionsKt$toFlow$2$$ExternalSyntheticLambda0
                    @Override // io.reactivex.functions.Action
                    public final void run() {
                        FlowExtensionsKt.AnonymousClass2.m279invokeSuspend$lambda0(producerScope);
                    }
                }, new Consumer() { // from class: ir.appp.common.utils.extentions.FlowExtensionsKt$toFlow$2$$ExternalSyntheticLambda1
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj2) {
                        producerScope.close((Throwable) obj2);
                    }
                });
                Function0<Unit> function0 = new Function0<Unit>() { // from class: ir.appp.common.utils.extentions.FlowExtensionsKt.toFlow.2.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        if (disposableSubscribe.isDisposed()) {
                            return;
                        }
                        disposableSubscribe.dispose();
                    }
                };
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
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

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: invokeSuspend$lambda-0, reason: not valid java name */
        public static final void m279invokeSuspend$lambda0(ProducerScope producerScope) {
            producerScope.offer(Boolean.TRUE);
        }
    }

    public static final Flow<Object> toFlow(Completable completable) {
        Intrinsics.checkNotNullParameter(completable, "<this>");
        return FlowKt.callbackFlow(new AnonymousClass2(completable, null));
    }

    public static final <T> Flow<BaseResponse<T>> toResult(final Flow<? extends T> flow, ErrorHandler errorHandler) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(errorHandler, "errorHandler");
        return FlowKt.m557catch(FlowKt.onStart(new Flow<BaseResponse<? extends T>>() { // from class: ir.appp.common.utils.extentions.FlowExtensionsKt$toResult$$inlined$map$1

            /* compiled from: Collect.kt */
            /* renamed from: ir.appp.common.utils.extentions.FlowExtensionsKt$toResult$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2 implements FlowCollector<T> {
                final /* synthetic */ FlowCollector $this_unsafeFlow$inlined;

                @DebugMetadata(c = "ir.appp.common.utils.extentions.FlowExtensionsKt$toResult$$inlined$map$1$2", f = "FlowExtensions.kt", l = {136}, m = "emit")
                /* renamed from: ir.appp.common.utils.extentions.FlowExtensionsKt$toResult$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, FlowExtensionsKt$toResult$$inlined$map$1 flowExtensionsKt$toResult$$inlined$map$1) {
                    this.$this_unsafeFlow$inlined = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof ir.appp.common.utils.extentions.FlowExtensionsKt$toResult$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        ir.appp.common.utils.extentions.FlowExtensionsKt$toResult$$inlined$map$1$2$1 r0 = (ir.appp.common.utils.extentions.FlowExtensionsKt$toResult$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        ir.appp.common.utils.extentions.FlowExtensionsKt$toResult$$inlined$map$1$2$1 r0 = new ir.appp.common.utils.extentions.FlowExtensionsKt$toResult$$inlined$map$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r7)
                        goto L4b
                    L29:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L31:
                        kotlin.ResultKt.throwOnFailure(r7)
                        kotlinx.coroutines.flow.FlowCollector r7 = r5.$this_unsafeFlow$inlined
                        java.lang.String r2 = "SAEED"
                        java.lang.String r4 = "Success: "
                        android.util.Log.d(r2, r4)
                        ir.appp.common.domain.model.BaseResponse$Success r2 = new ir.appp.common.domain.model.BaseResponse$Success
                        r2.<init>(r6)
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r2, r0)
                        if (r6 != r1) goto L4b
                        return r1
                    L4b:
                        kotlin.Unit r6 = kotlin.Unit.INSTANCE
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.appp.common.utils.extentions.FlowExtensionsKt$toResult$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = flow.collect(new AnonymousClass2(flowCollector, this), continuation);
                return objCollect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, new C00872(null)), new AnonymousClass3(errorHandler, null));
    }
}
