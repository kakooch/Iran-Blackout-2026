package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MutableCollectionsJVM.kt */
/* loaded from: classes4.dex */
class CollectionsKt__MutableCollectionsJVMKt extends CollectionsKt__IteratorsKt {
    public static final <T> void sortWith(List<T> list, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
