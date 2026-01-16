package ir.appp.vod.util;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: VodViewExtensions.kt */
/* loaded from: classes3.dex */
public final class VodViewExtensionsKt {
    public static final String toReadableTime(long j) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long hours = timeUnit.toHours(j);
        long j2 = 60;
        long minutes = timeUnit.toMinutes(j) % j2;
        long seconds = timeUnit.toSeconds(j) % j2;
        if (hours > 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(hours), Long.valueOf(minutes), Long.valueOf(seconds)}, 3));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            return str;
        }
        if (minutes > 0) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String str2 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(minutes), Long.valueOf(seconds)}, 2));
            Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
            return str2;
        }
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
        String str3 = String.format("00:%02d", Arrays.copyOf(new Object[]{Long.valueOf(seconds)}, 1));
        Intrinsics.checkNotNullExpressionValue(str3, "format(format, *args)");
        return str3;
    }
}
