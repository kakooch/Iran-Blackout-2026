package ir.eitaa.ui.DatePicker;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import ir.eitaa.ui.DatePicker.util.PersianCalendarUtils;

/* loaded from: classes3.dex */
public class Utils {
    public static boolean isJellybeanOrLater() {
        return Build.VERSION.SDK_INT >= 16;
    }

    @SuppressLint({"NewApi"})
    public static void tryAccessibilityAnnounce(View view, CharSequence text) {
        if (!isJellybeanOrLater() || view == null || text == null) {
            return;
        }
        view.announceForAccessibility(text);
    }

    public static int getDaysInMonth(int month, int year) {
        if (month < 6) {
            return 31;
        }
        return (month >= 11 && !PersianCalendarUtils.isPersianLeapYear(year)) ? 29 : 30;
    }

    public static ObjectAnimator getPulseAnimator(View labelToAnimate, float decreaseRatio, float increaseRatio) {
        Keyframe keyframeOfFloat = Keyframe.ofFloat(0.0f, 1.0f);
        Keyframe keyframeOfFloat2 = Keyframe.ofFloat(0.275f, decreaseRatio);
        Keyframe keyframeOfFloat3 = Keyframe.ofFloat(0.69f, increaseRatio);
        Keyframe keyframeOfFloat4 = Keyframe.ofFloat(1.0f, 1.0f);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(labelToAnimate, PropertyValuesHolder.ofKeyframe("scaleX", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4), PropertyValuesHolder.ofKeyframe("scaleY", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4));
        objectAnimatorOfPropertyValuesHolder.setDuration(544L);
        return objectAnimatorOfPropertyValuesHolder;
    }
}
