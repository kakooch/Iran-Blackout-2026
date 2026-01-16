package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.widget.FrameLayout;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.model.Rubino;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class ExploreTopicCell extends FrameLayout {
    int cornerRadius;
    int drawablePadding;
    int drawableSize;
    Drawable iconDrawable;
    Rect iconDrawableBound;
    int sidePadding;
    int strokeColor;
    Paint strokePaint;
    int strokeSize;
    String text;
    int textStartX;
    StaticLayout textStaticLayout;
    public Rubino.ExploreTopicObject topicObject;
    RectF viewBound;

    public ExploreTopicCell(Context context) {
        super(context);
        init();
    }

    private void init() {
        this.viewBound = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.sidePadding = AndroidUtilities.dp(18.0f);
        this.drawablePadding = AndroidUtilities.dp(2.0f);
        this.cornerRadius = AndroidUtilities.dp(4.0f);
        setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        this.strokeColor = Theme.getColor(Theme.key_rubinoFollowingBorderColor);
        this.strokeSize = AndroidUtilities.dp(1.0f);
        Paint paint = new Paint();
        this.strokePaint = paint;
        paint.setAntiAlias(true);
        this.strokePaint.setColor(this.strokeColor);
        this.strokePaint.setStyle(Paint.Style.STROKE);
        this.strokePaint.setStrokeWidth(this.strokeSize);
        this.strokePaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void setTopicObject(Rubino.ExploreTopicObject exploreTopicObject) {
        String str;
        String str2;
        this.topicObject = exploreTopicObject;
        if (exploreTopicObject != null && (str2 = exploreTopicObject.topic) != null) {
            this.text = str2;
        } else {
            this.text = BuildConfig.FLAVOR;
        }
        this.iconDrawable = null;
        if (exploreTopicObject != null && (str = exploreTopicObject.topic) != null && str.equals("فروشگاه")) {
            Drawable drawableMutate = getContext().getResources().getDrawable(R.drawable.rubino_grid_shopping_icon).mutate();
            this.iconDrawable = drawableMutate;
            drawableMutate.setColorFilter(Theme.getColor(Theme.key_rubinoBlackColor), PorterDuff.Mode.SRC_ATOP);
            this.iconDrawableBound = new Rect(0, 0, 0, 0);
        }
        createStaticTextLayout();
        requestLayout();
    }

    public void setStrokeColor(int i) {
        this.strokeColor = i;
        invalidate();
    }

    public void setStrokeSize(int i) {
        this.strokeSize = i;
        invalidate();
    }

    public void setDrawablePadding(int i) {
        this.drawablePadding = i;
        invalidate();
    }

    public void setDrawableSize(int i) {
        this.drawableSize = i;
        invalidate();
    }

    public void setSidePadding(int i) {
        this.sidePadding = i;
        invalidate();
    }

    public void setCornerRadius(int i) {
        this.cornerRadius = i;
    }

    private void createStaticTextLayout() {
        String str = this.text;
        if (str == null || str.length() == 0) {
            return;
        }
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(AndroidUtilities.density * 13.0f);
        textPaint.setTypeface(Theme.getRubinoTypeFaceBold());
        textPaint.setColor(Theme.getColor(Theme.key_rubinoBlackColor));
        float fMeasureText = textPaint.measureText(this.text);
        if (Build.VERSION.SDK_INT >= 23) {
            String str2 = this.text;
            this.textStaticLayout = StaticLayout.Builder.obtain(str2, 0, str2.length(), textPaint, (int) fMeasureText).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(0.0f, 1.0f).setIncludePad(false).build();
        } else {
            this.textStaticLayout = new StaticLayout(this.text, textPaint, (int) fMeasureText, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        StaticLayout staticLayout = this.textStaticLayout;
        int width = 0;
        if (staticLayout != null) {
            width = (this.sidePadding * 2) + staticLayout.getWidth() + 0;
        }
        if (this.iconDrawable != null) {
            int iDp = size - AndroidUtilities.dp(4.0f);
            this.drawableSize = iDp;
            width += (this.drawablePadding * 2) + iDp;
            this.iconDrawableBound.left = ((int) ((width / 2.0f) - ((iDp + this.textStaticLayout.getWidth()) / 2.0f))) - AndroidUtilities.dp(2.0f);
            Rect rect = this.iconDrawableBound;
            rect.right = rect.left + this.drawableSize;
            int i3 = this.drawablePadding;
            rect.top = i3;
            rect.bottom = size - i3;
            this.iconDrawable.setBounds(rect);
            this.textStartX = this.iconDrawableBound.right - AndroidUtilities.dp(2.0f);
        } else {
            this.textStartX = this.sidePadding;
        }
        this.textStartX += this.strokeSize;
        RectF rectF = this.viewBound;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = width;
        rectF.bottom = size;
        setMeasuredDimension(width, size);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.viewBound;
        int i = this.cornerRadius;
        canvas.drawRoundRect(rectF, i, i, this.strokePaint);
        Drawable drawable = this.iconDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        if (this.textStaticLayout != null) {
            canvas.translate(this.textStartX, (getMeasuredHeight() / 2.0f) - (this.textStaticLayout.getHeight() / 2.0f));
            this.textStaticLayout.draw(canvas);
        }
    }
}
