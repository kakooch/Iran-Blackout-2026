package androidx.lifecycle;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: ViewModel.kt */
/* loaded from: classes.dex */
public final class ViewModelKt {
    public static final CoroutineScope getViewModelScope(ViewModel viewModelScope) throws IOException {
        Intrinsics.checkNotNullParameter(viewModelScope, "$this$viewModelScope");
        CoroutineScope coroutineScope = (CoroutineScope) viewModelScope.getTag("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY");
        if (coroutineScope != null) {
            return coroutineScope;
        }
        Object tagIfAbsent = viewModelScope.setTagIfAbsent("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY", new CloseableCoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate())));
        Intrinsics.checkNotNullExpressionValue(tagIfAbsent, "setTagIfAbsent(\n        …Main.immediate)\n        )");
        return (CoroutineScope) tagIfAbsent;
    }
}
