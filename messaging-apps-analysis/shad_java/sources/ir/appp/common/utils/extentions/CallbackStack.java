package ir.appp.common.utils.extentions;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import ir.appp.common.domain.model.BaseError;
import ir.appp.common.domain.model.BaseResponse;
import ir.appp.common.utils.extentions.CallbackStack;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LiveDataExt.kt */
/* loaded from: classes3.dex */
public final class CallbackStack<T> {
    private Function0<Unit> doFinally;
    private Function1<? super BaseError, Unit> onFailed;
    private Function0<Unit> onLoading;
    private Function1<? super T, Unit> onSuccess;

    public final void onSuccess(Function1<? super T, Unit> cb) {
        Intrinsics.checkNotNullParameter(cb, "cb");
        this.onSuccess = cb;
    }

    public final void onFailed(Function1<? super BaseError, Unit> cb) {
        Intrinsics.checkNotNullParameter(cb, "cb");
        this.onFailed = cb;
    }

    public final void onLoading(Function0<Unit> cb) {
        Intrinsics.checkNotNullParameter(cb, "cb");
        this.onLoading = cb;
    }

    /* compiled from: LiveDataExt.kt */
    public static final class ObserveStarter<T> {
        private boolean isStarted;
        private final LiveData<BaseResponse<T>> liveData;
        private final LifecycleOwner owner;

        public ObserveStarter(LifecycleOwner owner, LiveData<BaseResponse<T>> liveData) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            Intrinsics.checkNotNullParameter(liveData, "liveData");
            this.owner = owner;
            this.liveData = liveData;
        }

        public final void callbacks(Function1<? super CallbackStack<T>, Unit> action) {
            Intrinsics.checkNotNullParameter(action, "action");
            final CallbackStack callbackStack = new CallbackStack();
            action.invoke(callbackStack);
            this.liveData.observe(this.owner, new Observer() { // from class: ir.appp.common.utils.extentions.CallbackStack$ObserveStarter$$ExternalSyntheticLambda0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    CallbackStack.ObserveStarter.m275callbacks$lambda1(this.f$0, callbackStack, (BaseResponse) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: callbacks$lambda-1, reason: not valid java name */
        public static final void m275callbacks$lambda1(ObserveStarter this$0, CallbackStack stack, BaseResponse baseResponse) {
            Function1 function1;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(stack, "$stack");
            boolean z = baseResponse instanceof BaseResponse.Loading;
            if (z) {
                this$0.isStarted = true;
                Function0 function0 = stack.onLoading;
                if (function0 != null) {
                    function0.invoke();
                }
            } else if (baseResponse instanceof BaseResponse.Success) {
                Object data = ((BaseResponse.Success) baseResponse).getData();
                Function1 function12 = stack.onSuccess;
                if (function12 != null) {
                    function12.invoke(data);
                }
            } else if ((baseResponse instanceof BaseResponse.Error) && this$0.isStarted && (function1 = stack.onFailed) != null) {
                function1.invoke(((BaseResponse.Error) baseResponse).getError());
            }
            if (z || !this$0.isStarted) {
                return;
            }
            this$0.isStarted = false;
            Function0 function02 = stack.doFinally;
            if (function02 == null) {
                return;
            }
            function02.invoke();
        }
    }
}
