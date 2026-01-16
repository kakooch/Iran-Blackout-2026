package ir.nasim;

import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;

/* renamed from: ir.nasim.jn7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC15565jn7 {
    private static final C6893Pk7 a = new C6893Pk7();
    private static final long b = a(0, 0);

    public static final long a(int i, int i2) {
        return AbstractC15363jS7.a((i2 & 4294967295L) | (i << 32));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Paint.FontMetricsInt h(C10550bn7 c10550bn7, TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, C5122Hz3[] c5122Hz3Arr) {
        int iM = c10550bn7.m() - 1;
        if (c10550bn7.i().getLineStart(iM) != c10550bn7.i().getLineEnd(iM) || c5122Hz3Arr == null || c5122Hz3Arr.length == 0) {
            return null;
        }
        SpannableString spannableString = new SpannableString("\u200b");
        C5122Hz3 c5122Hz3 = (C5122Hz3) AbstractC10242bK.b0(c5122Hz3Arr);
        spannableString.setSpan(c5122Hz3.b(0, spannableString.length(), (iM == 0 || !c5122Hz3.e()) ? c5122Hz3.e() : false), 0, spannableString.length(), 33);
        StaticLayout staticLayoutA = C15899kM6.a.a(spannableString, textPaint, Integer.MAX_VALUE, (2072512 & 8) != 0 ? 0 : 0, (2072512 & 16) != 0 ? spannableString.length() : spannableString.length(), (2072512 & 32) != 0 ? C9999au3.a.b() : textDirectionHeuristic, (2072512 & 64) != 0 ? C9999au3.a.a() : null, (2072512 & 128) != 0 ? Integer.MAX_VALUE : 0, (2072512 & 256) != 0 ? null : null, (2072512 & 512) != 0 ? Integer.MAX_VALUE : 0, (2072512 & 1024) != 0 ? 1.0f : 0.0f, (2072512 & 2048) != 0 ? 0.0f : 0.0f, (2072512 & 4096) != 0 ? 0 : 0, (2072512 & 8192) != 0 ? false : c10550bn7.h(), (2072512 & 16384) != 0 ? true : c10550bn7.e(), (32768 & 2072512) != 0 ? 0 : 0, (65536 & 2072512) != 0 ? 0 : 0, (131072 & 2072512) != 0 ? 0 : 0, (262144 & 2072512) != 0 ? 0 : 0, (524288 & 2072512) != 0 ? null : null, (2072512 & 1048576) != 0 ? null : null);
        Paint.FontMetricsInt fontMetricsInt = new Paint.FontMetricsInt();
        fontMetricsInt.ascent = staticLayoutA.getLineAscent(0);
        fontMetricsInt.descent = staticLayoutA.getLineDescent(0);
        fontMetricsInt.top = staticLayoutA.getLineTop(0);
        fontMetricsInt.bottom = staticLayoutA.getLineBottom(0);
        return fontMetricsInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long i(C5122Hz3[] c5122Hz3Arr) {
        int iMax = 0;
        int iMax2 = 0;
        for (C5122Hz3 c5122Hz3 : c5122Hz3Arr) {
            if (c5122Hz3.c() < 0) {
                iMax = Math.max(iMax, Math.abs(c5122Hz3.c()));
            }
            if (c5122Hz3.d() < 0) {
                iMax2 = Math.max(iMax, Math.abs(c5122Hz3.d()));
            }
        }
        return (iMax == 0 && iMax2 == 0) ? b : a(iMax, iMax2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C5122Hz3[] j(C10550bn7 c10550bn7) {
        if (!(c10550bn7.G() instanceof Spanned)) {
            return null;
        }
        CharSequence charSequenceG = c10550bn7.G();
        AbstractC13042fc3.g(charSequenceG, "null cannot be cast to non-null type android.text.Spanned");
        if (!AbstractC18227oI6.a((Spanned) charSequenceG, C5122Hz3.class) && c10550bn7.G().length() > 0) {
            return null;
        }
        CharSequence charSequenceG2 = c10550bn7.G();
        AbstractC13042fc3.g(charSequenceG2, "null cannot be cast to non-null type android.text.Spanned");
        return (C5122Hz3[]) ((Spanned) charSequenceG2).getSpans(0, c10550bn7.G().length(), C5122Hz3.class);
    }

    public static final TextDirectionHeuristic k(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? TextDirectionHeuristics.FIRSTSTRONG_LTR : TextDirectionHeuristics.LOCALE : TextDirectionHeuristics.ANYRTL_LTR : TextDirectionHeuristics.FIRSTSTRONG_RTL : TextDirectionHeuristics.FIRSTSTRONG_LTR : TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long l(C10550bn7 c10550bn7) {
        if (c10550bn7.h() || c10550bn7.J()) {
            return b;
        }
        TextPaint paint = c10550bn7.i().getPaint();
        CharSequence text = c10550bn7.i().getText();
        Rect rectC = AbstractC14789iU4.c(paint, text, c10550bn7.i().getLineStart(0), c10550bn7.i().getLineEnd(0));
        int lineAscent = c10550bn7.i().getLineAscent(0);
        int i = rectC.top;
        int topPadding = i < lineAscent ? lineAscent - i : c10550bn7.i().getTopPadding();
        if (c10550bn7.m() != 1) {
            int iM = c10550bn7.m() - 1;
            rectC = AbstractC14789iU4.c(paint, text, c10550bn7.i().getLineStart(iM), c10550bn7.i().getLineEnd(iM));
        }
        int lineDescent = c10550bn7.i().getLineDescent(c10550bn7.m() - 1);
        int i2 = rectC.bottom;
        int bottomPadding = i2 > lineDescent ? i2 - lineDescent : c10550bn7.i().getBottomPadding();
        return (topPadding == 0 && bottomPadding == 0) ? b : a(topPadding, bottomPadding);
    }

    public static final boolean m(Layout layout, int i) {
        return layout.getEllipsisCount(i) > 0;
    }
}
