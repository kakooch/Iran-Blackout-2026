package kotlin.text;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: _Strings.kt */
/* loaded from: classes4.dex */
class StringsKt___StringsKt extends StringsKt___StringsJvmKt {
    public static final String drop(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
        }
        String strSubstring = str.substring(RangesKt___RangesKt.coerceAtMost(i, str.length()));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }
}
