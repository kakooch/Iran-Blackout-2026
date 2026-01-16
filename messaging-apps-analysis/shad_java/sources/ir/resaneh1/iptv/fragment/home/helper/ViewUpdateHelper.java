package ir.resaneh1.iptv.fragment.home.helper;

import android.graphics.Color;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.ui.ActionBar.Theme;

/* compiled from: ViewUpdateHelper.kt */
/* loaded from: classes3.dex */
public final class ViewUpdateHelper {
    public static final ViewUpdateHelper INSTANCE = new ViewUpdateHelper();

    private ViewUpdateHelper() {
    }

    public final void updateTextSize(TextView textView, Float f) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        if (f != null && f.floatValue() > 0.0f) {
            textView.setTextSize(1, f.floatValue() * 13);
        } else {
            textView.setTextSize(1, 13.0f);
        }
    }

    public final void updateColor(TextView textView, String str) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        if (!(str == null || str.length() == 0)) {
            textView.setTextColor(Color.parseColor(str));
        } else {
            textView.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
        }
    }
}
