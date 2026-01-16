package ir.resaneh1.iptv.story;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.widget.FrameLayout;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes4.dex */
public class DateSticker extends FrameLayout {
    public int BLACK;
    public int RED;
    public int WHITE;
    private StaticLayout dateStaticLayout;
    private String dateString;
    private DateTheme dateTheme;
    private int fontSizePx;
    private int fontSizeStepPx;
    private TextPaint textPaint;
    public static int maxStaticLayoutWidth = AndroidUtilities.dp(207.0f);
    public static int maxStaticLayoutHeight = AndroidUtilities.dp(67.0f);

    public enum DateTheme {
        WHITE,
        BLACK,
        RED
    }

    public DateSticker(Context context, String str) {
        super(context);
        this.WHITE = -1;
        this.BLACK = -16777216;
        this.RED = -1357483;
        this.fontSizePx = AndroidUtilities.dp(53.0f);
        this.fontSizeStepPx = AndroidUtilities.dp(1.0f);
        setWillNotDraw(false);
        init(str);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(maxStaticLayoutWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(maxStaticLayoutHeight, 1073741824));
    }

    private void init(String str) {
        TextPaint textPaint = new TextPaint();
        this.textPaint = textPaint;
        textPaint.setAntiAlias(true);
        this.textPaint.setColor(this.WHITE);
        this.textPaint.setTextSize(this.fontSizePx);
        this.textPaint.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/AvenyTRegular.otf"));
        setDateString(str);
    }

    public void setDateString(String str) {
        this.dateString = str;
        setupStaticLayout();
    }

    private void setupStaticLayout() {
        this.dateStaticLayout = new StaticLayout(this.dateString, this.textPaint, maxStaticLayoutWidth, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
        while (this.dateStaticLayout.getLineCount() > 1) {
            int i = this.fontSizePx - this.fontSizeStepPx;
            this.fontSizePx = i;
            this.textPaint.setTextSize(i);
            this.dateStaticLayout = new StaticLayout(this.dateString, this.textPaint, maxStaticLayoutWidth, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.translate((getWidth() / 2.0f) - (this.dateStaticLayout.getWidth() / 2.0f), (getHeight() / 2.0f) - (this.dateStaticLayout.getHeight() / 2.0f));
        this.dateStaticLayout.draw(canvas);
        canvas.restore();
    }

    /* renamed from: ir.resaneh1.iptv.story.DateSticker$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$ir$resaneh1$iptv$story$DateSticker$DateTheme;

        static {
            int[] iArr = new int[DateTheme.values().length];
            $SwitchMap$ir$resaneh1$iptv$story$DateSticker$DateTheme = iArr;
            try {
                iArr[DateTheme.WHITE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$story$DateSticker$DateTheme[DateTheme.BLACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$story$DateSticker$DateTheme[DateTheme.RED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public void setDateTheme(DateTheme dateTheme) {
        this.dateTheme = dateTheme;
        int i = AnonymousClass1.$SwitchMap$ir$resaneh1$iptv$story$DateSticker$DateTheme[dateTheme.ordinal()];
        if (i == 1) {
            this.textPaint.setColor(this.WHITE);
        } else if (i == 2) {
            this.textPaint.setColor(this.BLACK);
        } else if (i == 3) {
            this.textPaint.setColor(this.RED);
        }
        invalidate();
    }

    public DateTheme getDateTheme() {
        return this.dateTheme;
    }

    public static int getViewHeight() {
        return maxStaticLayoutHeight;
    }

    public static int getViewWidth() {
        return maxStaticLayoutWidth;
    }
}
