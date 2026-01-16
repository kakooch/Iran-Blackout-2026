package ir.appp.common.utils;

import android.content.Context;
import com.google.android.material.internal.ViewUtils;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceUtils.kt */
/* loaded from: classes3.dex */
public final class DeviceUtils {
    public static final DeviceUtils INSTANCE = new DeviceUtils();

    private DeviceUtils() {
    }

    public final float dpToPx(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ViewUtils.dpToPx(context, i);
    }
}
