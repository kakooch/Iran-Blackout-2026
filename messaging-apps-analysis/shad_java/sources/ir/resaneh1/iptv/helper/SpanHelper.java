package ir.resaneh1.iptv.helper;

import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import java.util.regex.Pattern;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes3.dex */
public class SpanHelper {
    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public static SpannableString makeLinkSpanWithColor(SpannableString spannableString, View.OnClickListener onClickListener, int i, int i2, int i3) {
        if (i < 0 || i2 > spannableString.length()) {
            return spannableString;
        }
        spannableString.setSpan(new ClickableString(onClickListener), i, i2, 17);
        spannableString.setSpan(new ForegroundColorSpan(ApplicationLoader.applicationContext.getResources().getColor(i3)), i, i2, 33);
        spannableString.setSpan(new RelativeSizeSpan(1.0f), i, i2, 33);
        return spannableString;
    }

    public static SpannableString makeLinkSpanPrimary(SpannableString spannableString, View.OnClickListener onClickListener, int i, int i2) {
        spannableString.setSpan(new ClickableString(onClickListener), i, i2, 17);
        spannableString.setSpan(new ForegroundColorSpan(-15288867), i, i2, 33);
        spannableString.setSpan(new RelativeSizeSpan(1.05f), i, i2, 33);
        return spannableString;
    }

    public static SpannableString makeBoldLinkSpanWithColor(SpannableString spannableString, View.OnClickListener onClickListener, int i, int i2, int i3) {
        if (onClickListener != null) {
            spannableString.setSpan(new ClickableString(onClickListener), i, i2, 17);
        }
        spannableString.setSpan(new StyleSpan(1), i, i2, 33);
        spannableString.setSpan(new ForegroundColorSpan(i3), i, i2, 33);
        return spannableString;
    }

    public static SpannableString makeBoldSpanWithColor(CharSequence charSequence, int i) {
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new StyleSpan(1), 0, charSequence.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, charSequence.length(), 33);
        return spannableString;
    }

    public static SpannableString makeWithColorAndRelativeSize(CharSequence charSequence, int i, float f) {
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, charSequence.length(), 33);
        spannableString.setSpan(new RelativeSizeSpan(f), 0, charSequence.length(), 33);
        return spannableString;
    }

    public static SpannableString makeWithColorAndRelativeSize(SpannableString spannableString, int i, int i2, int i3, float f) {
        spannableString.setSpan(new ForegroundColorSpan(i3), i, i2, 33);
        spannableString.setSpan(new RelativeSizeSpan(f), i, i2, 33);
        return spannableString;
    }

    public static SpannableString makeBoldWithColorAndRelativeSize(SpannableString spannableString, int i, int i2, int i3, float f) {
        spannableString.setSpan(new StyleSpan(1), i, i2, 33);
        spannableString.setSpan(new ForegroundColorSpan(i3), i, i2, 33);
        spannableString.setSpan(new RelativeSizeSpan(f), i, i2, 33);
        return spannableString;
    }

    public static SpannableString makeBoldAndRelativeSize(SpannableString spannableString, int i, int i2, float f) {
        spannableString.setSpan(new StyleSpan(1), i, i2, 33);
        spannableString.setSpan(new RelativeSizeSpan(f), i, i2, 33);
        return spannableString;
    }

    public static void parseMessageTextInstaLimitHashtag(TextView textView, SpannableString spannableString, boolean z) {
        parseMessageText(textView, spannableString, z, true, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void parseMessageText(final android.widget.TextView r10, android.text.SpannableString r11, boolean r12, final boolean r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.helper.SpanHelper.parseMessageText(android.widget.TextView, android.text.SpannableString, boolean, boolean, boolean):void");
    }

    public static boolean isPersianLetter(char c) {
        return Pattern.compile("\\p{InArabic}").matcher(c + BuildConfig.FLAVOR).matches();
    }

    public static void makeLinksFocusable(TextView textView) {
        MovementMethod movementMethod = textView.getMovementMethod();
        if ((movementMethod == null || !(movementMethod instanceof BetterLinkMovementMethod)) && textView.getLinksClickable()) {
            textView.setMovementMethod(BetterLinkMovementMethod.getInstance());
        }
    }

    public static class ClickableString extends ClickableSpan {
        private View.OnClickListener mListener;

        public ClickableString(View.OnClickListener onClickListener) {
            this.mListener = onClickListener;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.mListener.onClick(view);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
        }
    }

    private static class IndexObject {
        public int firstIndex;
        public int lastIndex;

        public IndexObject(int i, int i2) {
            this.firstIndex = i;
            this.lastIndex = i2;
        }
    }
}
