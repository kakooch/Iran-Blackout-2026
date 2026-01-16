package ir.appp.rghapp.components;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class SSHPhotoEditCell extends FrameLayout {
    private final FrameLayout aspectRatioFrameLayout;
    private Animator checkAnimator;
    private final ImageView imageView;
    private OnViewClickListener listener;
    private final Paint paint;
    private final Paint paint2;
    private float scaleState;
    public boolean selected;
    private float startX;
    private float startY;
    private final TextView textView;

    public interface OnViewClickListener {
        void onClick(SSHPhotoEditCell sSHPhotoEditCell);
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public SSHPhotoEditCell(Context context) {
        super(context);
        setWillNotDraw(false);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        Paint paint = new Paint(1);
        this.paint = paint;
        paint.setColor(-1714894648);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3.0f);
        Paint paint2 = new Paint(1);
        this.paint2 = paint2;
        paint2.setColor(-6710887);
        TextView textView = new TextView(context);
        this.textView = textView;
        textView.setIncludeFontPadding(false);
        textView.setGravity(49);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTypeface(Theme.getRubinoTypeFaceMedium());
        textView.setTextColor(Theme.getColor(Theme.key_rubino_add_post_TabActiveText));
        textView.setTextSize(1, 12.0f);
        textView.setPadding(0, 0, 0, AndroidUtilities.dp(4.0f));
        linearLayout.addView(textView, LayoutHelper.createFrame(-1, -2, 49));
        FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.appp.rghapp.components.SSHPhotoEditCell.1
            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i, int i2) {
                int iMin = Math.min(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i)) - AndroidUtilities.dp(8.0f);
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), View.MeasureSpec.makeMeasureSpec(iMin, 1073741824));
            }

            @Override // android.view.ViewGroup
            protected boolean drawChild(Canvas canvas, View view, long j) {
                boolean zDrawChild = super.drawChild(canvas, view, j);
                canvas.drawCircle(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f, (getMeasuredWidth() / 2.0f) - 2.0f, SSHPhotoEditCell.this.paint);
                return zDrawChild;
            }
        };
        this.aspectRatioFrameLayout = frameLayout;
        linearLayout.addView(frameLayout, LayoutHelper.createFrame(-1, -1, 17));
        ImageView imageView = new ImageView(context);
        this.imageView = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setColorFilter(Theme.getColor(Theme.key_rubinoBlackColor), PorterDuff.Mode.SRC_IN);
        imageView.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
        frameLayout.addView(imageView, LayoutHelper.createFrame(-1, -1, 17));
        addView(linearLayout, LayoutHelper.createFrame(-1, -2, 17));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.startX = motionEvent.getX();
            this.startY = motionEvent.getY();
            updateScaleState(true, true);
            return true;
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            updateScaleState(false, true);
            int x = (int) (motionEvent.getX() - this.startX);
            int y = (int) (motionEvent.getY() - this.startY);
            OnViewClickListener onViewClickListener = this.listener;
            if (onViewClickListener != null && x > -10 && y > -10 && x < 10 && y < 10) {
                onViewClickListener.onClick(this);
            }
            return true;
        }
        motionEvent.getAction();
        return true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.selected) {
            float measuredHeight = (getMeasuredHeight() / 2.0f) + AndroidUtilities.dp(44.0f);
            canvas.drawCircle(getMeasuredWidth() / 2.0f, ((getMeasuredHeight() - measuredHeight) / 2.0f) + measuredHeight + AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.5f), this.paint2);
        }
    }

    public void setOnViewClickListener(OnViewClickListener onViewClickListener) {
        this.listener = onViewClickListener;
    }

    public void updateScaleState(boolean z, boolean z2) {
        Animator animator = this.checkAnimator;
        if (animator != null) {
            animator.cancel();
        }
        if (z2) {
            float[] fArr = new float[1];
            fArr[0] = z ? 1.0f : 0.0f;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "scaleState", fArr);
            this.checkAnimator = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(200L);
            this.checkAnimator.start();
            return;
        }
        setScaleState(z ? 1.0f : 0.0f);
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        this.selected = z;
        invalidate();
    }

    @Keep
    public float getScaleState() {
        return this.scaleState;
    }

    @Keep
    public void setScaleState(float f) {
        this.scaleState = f;
        float f2 = 1.0f - (f * 0.06f);
        this.textView.setScaleX(f2);
        this.textView.setScaleY(f2);
        this.aspectRatioFrameLayout.setScaleX(f2);
        this.aspectRatioFrameLayout.setScaleY(f2);
        invalidate();
    }

    public void setTextAndIcon(CharSequence charSequence, int i) {
        this.textView.setText(charSequence);
        this.imageView.setImageDrawable(getContext().getResources().getDrawable(i));
    }

    public void setDrawablePadding(int i) {
        this.imageView.setPadding(i, i, i, i);
    }
}
