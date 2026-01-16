package ir.appp.common.utils.extentions;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import ir.appp.common.domain.model.BaseResponse;
import ir.appp.common.utils.extentions.CallbackStack;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LiveDataExt.kt */
/* loaded from: classes3.dex */
public final class LiveDataExtKt {
    public static final <T> CallbackStack.ObserveStarter<T> with(LiveData<BaseResponse<T>> liveData, LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(owner, "owner");
        return new CallbackStack.ObserveStarter<>(owner, liveData);
    }
}
