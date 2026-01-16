package kotlinx.coroutines.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.DebugKt;

/* compiled from: InlineList.kt */
/* loaded from: classes4.dex */
public final class InlineList<E> {
    /* renamed from: constructor-impl, reason: not valid java name */
    public static Object m559constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ Object m560constructorimpl$default(Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return m559constructorimpl(obj);
    }

    /* renamed from: plus-UZ7vuAc, reason: not valid java name */
    public static final Object m561plusUZ7vuAc(Object obj, E e) {
        if (DebugKt.getASSERTIONS_ENABLED() && !(!(e instanceof List))) {
            throw new AssertionError();
        }
        if (obj == null) {
            return m559constructorimpl(e);
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(e);
            return m559constructorimpl(obj);
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(e);
        return m559constructorimpl(arrayList);
    }
}
