package j$.util;

import j$.util.function.ToIntFunction;
import java.util.Collections;
import java.util.Comparator;

/* renamed from: j$.util.Comparator$-CC, reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class Comparator$CC {
    public static Comparator a() {
        return EnumC0107f.INSTANCE;
    }

    public static <T> Comparator<T> comparingInt(ToIntFunction<? super T> toIntFunction) {
        toIntFunction.getClass();
        return new C0105d(toIntFunction);
    }

    public static <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
        return Collections.reverseOrder();
    }
}
