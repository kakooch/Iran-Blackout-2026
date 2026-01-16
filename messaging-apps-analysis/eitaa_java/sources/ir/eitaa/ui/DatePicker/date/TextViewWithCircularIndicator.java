package ir.eitaa.ui.DatePicker.date;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.DatePicker.util.LanguageUtils;

/* loaded from: classes3.dex */
public class TextViewWithCircularIndicator extends AppCompatTextView {
    private final int mCircleColor;
    Paint mCirclePaint;
    private boolean mDrawCircle;
    private final String mItemIsSelectedText;
    private final int mRadius;

    public TextViewWithCircularIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mCirclePaint = new Paint();
        context.getResources();
        this.mCircleColor = Theme.getColor("chats_actionBackground");
        this.mRadius = AndroidUtilities.dp(45.0f);
        this.mItemIsSelectedText = "انتخاب شد";
        init();
    }

    private void init() {
        this.mCirclePaint.setFakeBoldText(true);
        this.mCirclePaint.setAntiAlias(true);
        this.mCirclePaint.setColor(this.mCircleColor);
        this.mCirclePaint.setTextAlign(Paint.Align.CENTER);
        this.mCirclePaint.setStyle(Paint.Style.FILL);
        this.mCirclePaint.setAlpha(255);
    }

    public void drawIndicator(boolean drawCircle) {
        this.mDrawCircle = drawCircle;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mDrawCircle) {
            int width = getWidth();
            int height = getHeight();
            canvas.drawCircle(width / 2, height / 2, Math.min(width, height) / 2, this.mCirclePaint);
        }
        setSelected(this.mDrawCircle);
        super.onDraw(canvas);
    }

    @Override // android.view.View
    @SuppressLint({"GetContentDescriptionOverride"})
    public CharSequence getContentDescription() {
        String persianNumbers = LanguageUtils.getPersianNumbers(getText().toString());
        return this.mDrawCircle ? String.format(this.mItemIsSelectedText, persianNumbers) : persianNumbers;
    }
}
