package ir.appp.rghapp.rubinoPostSlider;

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
import android.view.animation.DecelerateInterpolator;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class PhotoViewerShoppingView extends View {
    int animatingTotalWidth;
    float animationClippingRight;
    long animationStartTime;
    Paint backgroundPaint;
    RectF backgroundRect;
    State currentState;
    Rect drawableBound;
    int drawablePadding;
    int drawableSize;
    DecelerateInterpolator interpolator;
    int oneDp;
    Drawable productDrawable;
    String shoppingText;
    StaticLayout textStaticLayout;

    public enum State {
        COLLAPSED,
        EXPANDED,
        EXPANDING,
        COLLAPSING
    }

    public PhotoViewerShoppingView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        Drawable drawableMutate = context.getResources().getDrawable(R.drawable.rubino_grid_shopping_icon).mutate();
        this.productDrawable = drawableMutate;
        drawableMutate.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        this.drawablePadding = AndroidUtilities.dp(3.0f);
        this.oneDp = AndroidUtilities.dp(1.0f);
        this.drawableBound = new Rect(0, 0, 0, 0);
        this.backgroundRect = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        Paint paint = new Paint();
        this.backgroundPaint = paint;
        paint.setAntiAlias(true);
        this.backgroundPaint.setColor(Theme.getColor(Theme.key_rubino_mentionViewBackground));
        this.interpolator = new DecelerateInterpolator();
        this.currentState = State.EXPANDED;
    }

    public void setShoppingText(String str) {
        this.shoppingText = str;
        endAnimation();
        createTextStaticLayout();
        requestLayout();
    }

    public void setShoppingTextStaticLayout(StaticLayout staticLayout) {
        endAnimation();
        this.textStaticLayout = staticLayout;
        requestLayout();
    }

    public void setDrawablePadding(int i) {
        this.drawablePadding = i;
        requestLayout();
    }

    public void toggleVisibility(boolean z) {
        State state = this.currentState;
        if (state == State.COLLAPSING || state == State.EXPANDING) {
            endAnimation();
        }
        if (z && getVisibility() == 0) {
            setVisibility(8);
        } else {
            if (z || getVisibility() != 8) {
                return;
            }
            setVisibility(0);
        }
    }

    private void endAnimation() {
        State state = this.currentState;
        if (state == State.COLLAPSING) {
            this.backgroundRect.right = this.drawableSize;
            this.currentState = State.COLLAPSED;
        } else if (state == State.EXPANDING) {
            this.backgroundRect.right = this.drawableSize + this.animatingTotalWidth;
            this.currentState = State.EXPANDED;
        }
    }

    public void toggleShoppingViewState() {
        State state = this.currentState;
        if (state == State.EXPANDED) {
            collapseView();
        } else if (state == State.COLLAPSED) {
            expandView();
        }
    }

    private void collapseView() {
        if (this.currentState == State.EXPANDED) {
            this.currentState = State.COLLAPSING;
            this.animationStartTime = System.currentTimeMillis();
            updateAnimation();
        }
    }

    private void expandView() {
        if (this.currentState == State.COLLAPSED) {
            this.currentState = State.EXPANDING;
            this.animationStartTime = System.currentTimeMillis();
            updateAnimation();
        }
    }

    private void createTextStaticLayout() {
        String str = this.shoppingText;
        if (str == null || str.length() == 0) {
            return;
        }
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(AndroidUtilities.density * 12.0f);
        textPaint.setTypeface(Theme.getRubinoTypeFaceMedium());
        textPaint.setColor(-1);
        float fMeasureText = textPaint.measureText(this.shoppingText);
        if (Build.VERSION.SDK_INT >= 23) {
            String str2 = this.shoppingText;
            this.textStaticLayout = StaticLayout.Builder.obtain(str2, 0, str2.length(), textPaint, (int) fMeasureText).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(0.0f, 1.0f).setIncludePad(false).build();
        } else {
            this.textStaticLayout = new StaticLayout(this.shoppingText, textPaint, (int) fMeasureText, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        }
    }

    private void updateAnimation() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.animationStartTime;
        if (jCurrentTimeMillis <= 150) {
            float interpolation = this.interpolator.getInterpolation(jCurrentTimeMillis / 150.0f);
            int i = this.animatingTotalWidth;
            float f = interpolation * i;
            State state = this.currentState;
            if (state == State.COLLAPSING) {
                float f2 = this.drawableSize + (i - f);
                this.backgroundRect.right = f2;
                this.animationClippingRight = f2 - AndroidUtilities.dp(8.0f);
            } else if (state == State.EXPANDING) {
                float f3 = this.drawableSize + f;
                this.backgroundRect.right = f3;
                this.animationClippingRight = f3 - AndroidUtilities.dp(8.0f);
            }
        } else {
            endAnimation();
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        Rect rect = this.drawableBound;
        int i3 = this.drawablePadding;
        rect.left = i3;
        rect.right = size - i3;
        rect.top = i3;
        rect.bottom = size - i3;
        int width = this.textStaticLayout.getWidth() + size + AndroidUtilities.dp(8.0f);
        this.animatingTotalWidth = width - size;
        this.drawableSize = size;
        RectF rectF = this.backgroundRect;
        float f = size;
        rectF.bottom = f;
        if (this.currentState != State.COLLAPSED) {
            rectF.right = width;
        } else {
            rectF.right = f;
        }
        setMeasuredDimension(width, size);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.productDrawable == null) {
            return;
        }
        canvas.drawRoundRect(this.backgroundRect, getMeasuredHeight() / 2.0f, getMeasuredHeight() / 2.0f, this.backgroundPaint);
        this.productDrawable.setBounds(this.drawableBound);
        this.productDrawable.draw(canvas);
        if (this.textStaticLayout != null) {
            State state = this.currentState;
            if (state == State.COLLAPSING || state == State.EXPANDING) {
                RectF rectF = this.backgroundRect;
                canvas.clipRect(rectF.left, rectF.top, this.animationClippingRight, rectF.bottom);
            }
            if (this.currentState != State.COLLAPSED) {
                canvas.translate((this.drawableSize - this.drawablePadding) + this.oneDp, (getMeasuredHeight() / 2.0f) - (this.textStaticLayout.getHeight() / 2.0f));
                this.textStaticLayout.draw(canvas);
            }
        }
        State state2 = this.currentState;
        if (state2 == State.COLLAPSING || state2 == State.EXPANDING) {
            updateAnimation();
        }
    }
}
