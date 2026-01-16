package ir.appp.vod.util;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import ir.appp.common.domain.model.BaseResponse;
import ir.appp.vod.di.VodAppModule;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapWithDefaultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: VodViewModelExtensions.kt */
/* loaded from: classes3.dex */
public final class VodViewModelExtensionsKt {
    public static final <T> void callOnceApi(ViewModel viewModel, CoroutineScope scope, MutableLiveData<BaseResponse<T>> liveData, Function1<? super Continuation<? super Flow<? extends BaseResponse<? extends T>>>, ? extends Object> flow) {
        Intrinsics.checkNotNullParameter(viewModel, "<this>");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(liveData, "liveData");
        Intrinsics.checkNotNullParameter(flow, "flow");
        if (liveData.getValue() == null || (liveData.getValue() instanceof BaseResponse.Error)) {
            Log.d("SAEED", "callOnceApi: ");
            BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass1(flow, liveData, null), 3, null);
        }
    }

    /* compiled from: VodViewModelExtensions.kt */
    @DebugMetadata(c = "ir.appp.vod.util.VodViewModelExtensionsKt$callOnceApi$1", f = "VodViewModelExtensions.kt", l = {46, 49}, m = "invokeSuspend")
    /* renamed from: ir.appp.vod.util.VodViewModelExtensionsKt$callOnceApi$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super Flow<? extends BaseResponse<? extends T>>>, Object> $flow;
        final /* synthetic */ MutableLiveData<BaseResponse<T>> $liveData;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function1<? super Continuation<? super Flow<? extends BaseResponse<? extends T>>>, ? extends Object> function1, MutableLiveData<BaseResponse<T>> mutableLiveData, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$flow = function1;
            this.$liveData = mutableLiveData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$flow, this.$liveData, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
            } catch (CancellationException e) {
                this.$liveData.setValue(new BaseResponse.Error(VodAppModule.INSTANCE.provideVodGeneralErrorHandler().getError(e)));
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function1<Continuation<? super Flow<? extends BaseResponse<? extends T>>>, Object> function1 = this.$flow;
                this.label = 1;
                obj = function1.invoke(this);
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
            Flow flowOnEach = FlowKt.onEach(FlowKt.cancellable((Flow) obj), new C00281(this.$liveData, null));
            this.label = 2;
            if (FlowKt.collect(flowOnEach, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Add missing generic type declarations: [T] */
        /* compiled from: VodViewModelExtensions.kt */
        @DebugMetadata(c = "ir.appp.vod.util.VodViewModelExtensionsKt$callOnceApi$1$1", f = "VodViewModelExtensions.kt", l = {}, m = "invokeSuspend")
        /* renamed from: ir.appp.vod.util.VodViewModelExtensionsKt$callOnceApi$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00281<T> extends SuspendLambda implements Function2<BaseResponse<? extends T>, Continuation<? super Unit>, Object> {
            final /* synthetic */ MutableLiveData<BaseResponse<T>> $liveData;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00281(MutableLiveData<BaseResponse<T>> mutableLiveData, Continuation<? super C00281> continuation) {
                super(2, continuation);
                this.$liveData = mutableLiveData;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00281 c00281 = new C00281(this.$liveData, continuation);
                c00281.L$0 = obj;
                return c00281;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(BaseResponse<? extends T> baseResponse, Continuation<? super Unit> continuation) {
                return ((C00281) create(baseResponse, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$liveData.setValue((BaseResponse) this.L$0);
                return Unit.INSTANCE;
            }
        }
    }

    public static final <K, V> Map<K, V> lazyMap(ViewModel viewModel, final Function1<? super K, ? extends V> initializer) {
        Intrinsics.checkNotNullParameter(viewModel, "<this>");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        return MapsKt__MapWithDefaultKt.withDefaultMutable(linkedHashMap, new Function1<K, V>() { // from class: ir.appp.vod.util.VodViewModelExtensionsKt.lazyMap.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final V invoke(K k) {
                V vInvoke = initializer.invoke(k);
                linkedHashMap.put(k, vInvoke);
                return vInvoke;
            }
        });
    }
}
