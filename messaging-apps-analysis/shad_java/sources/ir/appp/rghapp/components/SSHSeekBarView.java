package ir.appp.rghapp.components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class SSHSeekBarView extends FrameLayout {
    private OnActionClickedListener delegate;
    private final SSHSeekBar seekBar;

    public interface OnActionClickedListener {
        void onCancelClicked();

        void onDoneClicked();
    }

    public interface SeekBarDelegate {
        void onProgressChanged(int i);
    }

    public SSHSeekBarView(Context context) {
        super(context);
        SSHSeekBar sSHSeekBar = new SSHSeekBar(context);
        this.seekBar = sSHSeekBar;
        addView(sSHSeekBar, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 0.0f, 0.0f, 44.0f));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        TextView textView = new TextView(getContext());
        textView.setWillNotDraw(false);
        textView.setGravity(17);
        textView.setText(LocaleController.getString("CANCEL", R.string.rubinoActionCancel));
        int i = Theme.key_rubino_add_post_TabActiveText;
        textView.setTextColor(Theme.getColor(i));
        textView.setTextSize(1, 14.0f);
        textView.setSingleLine(true);
        textView.setTypeface(Theme.getRubinoTypeFaceRegular());
        textView.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.rghapp.components.SSHSeekBarView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$0(view);
            }
        });
        linearLayout.addView(textView, LayoutHelper.createLinear(0, -1, 0.5f));
        TextView textView2 = new TextView(getContext());
        textView2.setWillNotDraw(false);
        textView2.setGravity(17);
        textView2.setText(LocaleController.getString("DONE", R.string.rubinoActionDone));
        textView2.setTextColor(Theme.getColor(i));
        textView2.setTextSize(1, 14.0f);
        textView2.setSingleLine(true);
        textView2.setTypeface(Theme.getRubinoTypeFaceMedium());
        textView2.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.rghapp.components.SSHSeekBarView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$1(view);
            }
        });
        linearLayout.addView(textView2, LayoutHelper.createLinear(0, -1, 0.5f));
        addView(linearLayout, LayoutHelper.createFrame(-1, 44, 83));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        OnActionClickedListener onActionClickedListener = this.delegate;
        if (onActionClickedListener != null) {
            onActionClickedListener.onCancelClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(View view) {
        OnActionClickedListener onActionClickedListener = this.delegate;
        if (onActionClickedListener != null) {
            onActionClickedListener.onDoneClicked();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size2, 1073741824), View.MeasureSpec.makeMeasureSpec(size - size2, 1073741824));
    }

    public void setSeekBarDelegate(SeekBarDelegate seekBarDelegate) {
        this.seekBar.setDelegate(seekBarDelegate);
    }

    public void setValue(float f, int i, int i2) {
        this.seekBar.setMinMax(i, i2);
        this.seekBar.setProgress((int) f, false);
    }

    public int getProgress() {
        return this.seekBar.getProgress();
    }

    public void setProgress(int i) {
        this.seekBar.setProgress(i);
    }

    public void setOnActionClickedListener(OnActionClickedListener onActionClickedListener) {
        this.delegate = onActionClickedListener;
    }

    public static class SSHSeekBar extends View {
        private final Rect bounds;
        private SeekBarDelegate delegate;
        private final Paint innerPaint;
        private int maxValue;
        private int minValue;
        private final Paint outerPaint;
        private boolean pressed;
        private float progress;
        private final Paint textPaint;
        private int thumbDX;
        private final int thumbSize;

        public SSHSeekBar(Context context) {
            super(context);
            Paint paint = new Paint();
            this.innerPaint = paint;
            Paint paint2 = new Paint(1);
            this.outerPaint = paint2;
            Paint paint3 = new Paint(1);
            this.textPaint = paint3;
            this.bounds = new Rect();
            this.thumbSize = AndroidUtilities.dp(12.5f);
            this.thumbDX = 0;
            this.progress = 0.0f;
            this.pressed = false;
            paint3.setColor(Theme.getColor(Theme.key_rubino_add_post_TabUnactiveText));
            paint3.setTextSize(AndroidUtilities.dp(15.0f));
            paint2.setColor(Theme.getColor(Theme.key_rubinoBlackColor));
            paint.setColor(Theme.getColor(Theme.key_dialogGrayLine));
        }

        public void setDelegate(SeekBarDelegate seekBarDelegate) {
            this.delegate = seekBarDelegate;
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (motionEvent == null) {
                return false;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            float measuredWidth = (int) ((getMeasuredWidth() - AndroidUtilities.dp(35.0f)) * this.progress);
            float f = 0.0f;
            if (motionEvent.getAction() == 0) {
                int measuredHeight = getMeasuredHeight();
                int i = this.thumbSize;
                float f2 = (measuredHeight - i) / 2;
                if (measuredWidth - f2 <= x && x <= i + measuredWidth + f2 && y >= 0.0f && y <= getMeasuredHeight()) {
                    this.pressed = true;
                    this.thumbDX = (int) (x - measuredWidth);
                    getParent().requestDisallowInterceptTouchEvent(true);
                    invalidate();
                    return true;
                }
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (this.pressed) {
                    this.pressed = false;
                    invalidate();
                    return true;
                }
            } else if (motionEvent.getAction() == 2 && this.pressed) {
                float f3 = (int) (x - this.thumbDX);
                if (f3 >= 0.0f) {
                    f = f3 > ((float) (getMeasuredWidth() - AndroidUtilities.dp(35.0f))) ? getMeasuredWidth() - AndroidUtilities.dp(35.0f) : f3;
                }
                this.progress = f / (getMeasuredWidth() - AndroidUtilities.dp(35.0f));
                SeekBarDelegate seekBarDelegate = this.delegate;
                if (seekBarDelegate != null) {
                    seekBarDelegate.onProgressChanged(getProgress());
                }
                invalidate();
                return true;
            }
            return false;
        }

        public void setProgress(int i, boolean z) {
            SeekBarDelegate seekBarDelegate;
            int i2 = this.minValue;
            if (i < i2) {
                i = i2;
            } else {
                int i3 = this.maxValue;
                if (i > i3) {
                    i = i3;
                }
            }
            this.progress = (i - i2) / (this.maxValue - i2);
            invalidate();
            if (!z || (seekBarDelegate = this.delegate) == null) {
                return;
            }
            seekBarDelegate.onProgressChanged(getProgress());
        }

        public int getProgress() {
            return (int) (this.minValue + (this.progress * (this.maxValue - r0)));
        }

        public void setProgress(int i) {
            setProgress(i, true);
        }

        public void setMinMax(int i, int i2) {
            this.minValue = i;
            this.maxValue = i2;
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            int iDp = AndroidUtilities.dp(35.0f);
            int measuredWidth = getMeasuredWidth() - iDp;
            int measuredHeight = (getMeasuredHeight() - this.thumbSize) / 2;
            float measuredHeight2 = getMeasuredHeight() / 2.0f;
            float measuredWidth2 = getMeasuredWidth() / 2.0f;
            int i = ((int) ((measuredWidth - iDp) * this.progress)) + iDp;
            float f = this.thumbSize / 2.0f;
            float f2 = iDp;
            float f3 = measuredHeight2 + 5.0f;
            canvas.drawRect(f2, measuredHeight2, measuredWidth, f3, this.innerPaint);
            if (this.minValue == 0) {
                canvas.drawRect(f2, measuredHeight2, i, f3, this.outerPaint);
            } else if (this.progress > 0.5f) {
                canvas.drawRect(measuredWidth2, measuredHeight2, i, f3, this.outerPaint);
            } else {
                canvas.drawRect(i, measuredHeight2, measuredWidth2, f3, this.outerPaint);
            }
            String strValueOf = String.valueOf(getProgress());
            if (!strValueOf.equals("0")) {
                this.textPaint.getTextBounds(strValueOf, 0, strValueOf.length(), this.bounds);
                canvas.drawText(strValueOf, i - (this.bounds.width() / 2.0f), (getMeasuredHeight() / 4.0f) + AndroidUtilities.dp(5.0f), this.textPaint);
            }
            canvas.drawCircle(i, measuredHeight + f, f, this.outerPaint);
        }
    }
}
