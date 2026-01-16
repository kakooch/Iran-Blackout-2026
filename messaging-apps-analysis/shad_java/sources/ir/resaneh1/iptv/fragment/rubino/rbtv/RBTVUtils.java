package ir.resaneh1.iptv.fragment.rubino.rbtv;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.rbmain.ui.ActionBar.Theme;

/* compiled from: RBTVUtils.kt */
/* loaded from: classes3.dex */
public final class RBTVUtils {
    public static final Companion Companion = new Companion(null);

    /* compiled from: RBTVUtils.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getBackgroundColor() {
            return -16777216;
        }

        public final int getTextColor() {
            return -1;
        }

        private Companion() {
        }

        public final TextView createTv(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            TextView textView = new TextView(context);
            textView.setTypeface(Theme.getRubinoTypeFaceRegular());
            textView.setTextColor(getTextColor());
            return textView;
        }

        public final TextView createTv(Context context, String string, Integer num) {
            Unit unit;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(string, "string");
            TextView textView = new TextView(context);
            textView.setText(string);
            if (num == null) {
                unit = null;
            } else {
                textView.setTextColor(num.intValue());
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                textView.setTextColor(getTextColor());
            }
            textView.setTypeface(Theme.getRubinoTypeFaceRegular());
            textView.setTextSize(14.0f);
            return textView;
        }

        public final ImageView createIv(Context context, int i) {
            Intrinsics.checkNotNullParameter(context, "context");
            ImageView imageView = new ImageView(context);
            imageView.setImageDrawable(context.getResources().getDrawable(i));
            imageView.setColorFilter(getTextColor());
            return imageView;
        }

        public final String timeInString(int i) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(((i / 3600) * 60) + ((i % 3600) / 60)), Integer.valueOf(i % 60)}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            return str;
        }
    }
}
