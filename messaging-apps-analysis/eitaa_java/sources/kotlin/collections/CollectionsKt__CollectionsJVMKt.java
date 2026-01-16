package kotlin.collections;

import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CollectionsJVM.kt */
/* loaded from: classes.dex */
class CollectionsKt__CollectionsJVMKt {
    public static final <T> List<T> listOf(T t) {
        List<T> listSingletonList = Collections.singletonList(t);
        Intrinsics.checkNotNullExpressionValue(listSingletonList, "singletonList(element)");
        return listSingletonList;
    }
}
