package ir.resaneh1.iptv.UIView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import ir.resaneh1.iptv.fragment.messanger.SeekBarView;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class UI_rubinoSeekBar {
    public FrameLayout frameLayout;
    boolean hasSizeCircle;
    public int heightInDp;
    public MySeekBar seekbar;
    public View view;

    public interface ChangeSizeListener {
        void onSelectSize(float f);
    }

    public View createView(Activity activity, final ChangeSizeListener changeSizeListener, int i, boolean z) {
        this.hasSizeCircle = z;
        FrameLayout frameLayout = new FrameLayout(activity);
        this.frameLayout = frameLayout;
        this.view = frameLayout;
        this.heightInDp = i;
        MySeekBar mySeekBar = new MySeekBar(activity);
        this.seekbar = mySeekBar;
        if (changeSizeListener != null) {
            mySeekBar.setDelegate(new SeekBarView.SeekBarViewDelegate(this) { // from class: ir.resaneh1.iptv.UIView.UI_rubinoSeekBar.1
                @Override // ir.resaneh1.iptv.fragment.messanger.SeekBarView.SeekBarViewDelegate
                public void onSeekBarDrag(float f) {
                    changeSizeListener.onSelectSize(f);
                }
            });
        }
        this.seekbar.setRotation(270.0f);
        int i2 = z ? 40 : 0;
        this.frameLayout.addView(this.seekbar, LayoutHelper.createFrame(i, i2 + 40, 19, ((-i) / 2) + 20 + (i2 / 2), 0.0f, 0.0f, 0.0f));
        return this.view;
    }

    public void setProgress(float f) {
        MySeekBar mySeekBar = this.seekbar;
        if (mySeekBar != null) {
            mySeekBar.setProgress(f);
        }
    }

    public void setColor(int i) {
        MySeekBar mySeekBar = this.seekbar;
        if (mySeekBar != null) {
            mySeekBar.colorPaint.setColor(i);
        }
    }

    public class MySeekBar extends SeekBarView {
        private Paint borderPaint;
        private Paint colorPaint;
        private int extraHeight;
        private int lastHeight;
        private int lastWidth;
        private int padding;
        private Path path;
        private float progress;
        private Paint shadowPaint;

        public MySeekBar(Context context) {
            super(context);
            this.outerPaint1.setColor(-1);
            this.innerPaint1.setColor(-1929379841);
            Paint paint = new Paint(1);
            this.shadowPaint = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.shadowPaint.setStrokeWidth(AndroidUtilities.dp(0.5f));
            this.shadowPaint.setColor(1426063360);
            Paint paint2 = new Paint(1);
            this.borderPaint = paint2;
            paint2.setStyle(Paint.Style.STROKE);
            this.borderPaint.setStrokeWidth(AndroidUtilities.dp(1.0f));
            this.borderPaint.setColor(-1);
            Paint paint3 = new Paint(1);
            this.colorPaint = paint3;
            paint3.setColor(-1);
            if (UI_rubinoSeekBar.this.hasSizeCircle) {
                this.padding = AndroidUtilities.dp(10.0f);
                this.extraHeight = AndroidUtilities.dp(30.0f);
            } else {
                this.extraHeight = 0;
                this.padding = 0;
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (z) {
                if (this.lastWidth == getMeasuredWidth() && this.lastHeight == getMeasuredHeight()) {
                    return;
                }
                setPath();
                this.lastWidth = getMeasuredWidth();
                this.lastHeight = getMeasuredHeight();
            }
        }

        private void setPath() {
            this.path = new Path();
            int measuredHeight = getMeasuredHeight() - this.extraHeight;
            int measuredWidth = getMeasuredWidth() - this.padding;
            int i = measuredHeight / 2;
            Point point = new Point(this.thumbWidth / 2, i);
            Point point2 = new Point(measuredWidth - (this.thumbWidth / 2), (this.thumbHeight / 2) + i);
            Point point3 = new Point(measuredWidth - (this.thumbWidth / 2), i - (this.thumbHeight / 2));
            this.path.moveTo(point.x, point.y);
            this.path.lineTo(point2.x, point2.y);
            this.path.lineTo(point3.x, point3.y);
            this.path.lineTo(point.x, point.y);
        }

        @Override // ir.resaneh1.iptv.fragment.messanger.SeekBarView
        public void setProgress(float f) {
            this.progress = f;
            int measuredWidth = getMeasuredWidth() - this.padding;
            if (getMeasuredWidth() == 0) {
                this.progressToSet = f;
                return;
            }
            this.progressToSet = -1.0f;
            int iCeil = (int) Math.ceil((measuredWidth - this.thumbWidth) * f);
            if (this.thumbX != iCeil) {
                this.thumbX = iCeil;
                if (iCeil < 0) {
                    this.thumbX = 0;
                } else {
                    int i = this.thumbWidth;
                    if (iCeil > measuredWidth - i) {
                        this.thumbX = measuredWidth - i;
                    }
                }
                invalidate();
            }
        }

        public float getProgress() {
            return this.progress;
        }

        @Override // ir.resaneh1.iptv.fragment.messanger.SeekBarView, android.view.View
        protected void onDraw(Canvas canvas) {
            int measuredHeight = ((getMeasuredHeight() - this.extraHeight) - this.thumbHeight) / 2;
            int measuredWidth = getMeasuredWidth() - this.padding;
            if (this.path == null) {
                setPath();
            }
            canvas.drawPath(this.path, this.innerPaint1);
            canvas.drawPath(this.path, this.shadowPaint);
            canvas.drawCircle(this.thumbX + (this.thumbWidth / 2), (this.thumbHeight / 2) + measuredHeight, AndroidUtilities.dp(8.0f), this.outerPaint1);
            canvas.drawCircle(this.thumbX + (this.thumbWidth / 2), (this.thumbHeight / 2) + measuredHeight, AndroidUtilities.dp(8.0f), this.shadowPaint);
            int i = this.thumbX;
            int i2 = this.thumbWidth;
            float f = i / (measuredWidth - i2);
            if (this.pressed && UI_rubinoSeekBar.this.hasSizeCircle) {
                float f2 = measuredHeight;
                float f3 = (f * 20.0f) + 8.0f;
                canvas.drawCircle(i + (i2 / 2), (this.thumbHeight / 2.0f) + f2 + AndroidUtilities.dp(40.0f), AndroidUtilities.dp(f3) / 2, this.colorPaint);
                canvas.drawCircle(this.thumbX + (this.thumbWidth / 2), f2 + (this.thumbHeight / 2.0f) + AndroidUtilities.dp(40.0f), AndroidUtilities.dp(f3) / 2, this.borderPaint);
            }
        }

        @Override // ir.resaneh1.iptv.fragment.messanger.SeekBarView
        public boolean onTouch(MotionEvent motionEvent) {
            int measuredWidth = getMeasuredWidth() - this.padding;
            int measuredHeight = getMeasuredHeight() - this.extraHeight;
            if (motionEvent.getAction() == 0) {
                getParent().requestDisallowInterceptTouchEvent(true);
                int i = (measuredHeight - this.thumbWidth) / 2;
                if (motionEvent.getY() >= 0.0f && motionEvent.getY() <= measuredHeight) {
                    if (this.thumbX - i > motionEvent.getX() || motionEvent.getX() > this.thumbX + this.thumbWidth + i) {
                        int x = (int) motionEvent.getX();
                        int i2 = this.thumbWidth;
                        int i3 = x - (i2 / 2);
                        this.thumbX = i3;
                        if (i3 < 0) {
                            this.thumbX = 0;
                        } else if (i3 > measuredWidth - i2) {
                            this.thumbX = measuredWidth - i2;
                        }
                    }
                    this.thumbDX = (int) (motionEvent.getX() - this.thumbX);
                    this.pressed = true;
                    invalidate();
                    return true;
                }
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (this.pressed) {
                    if (motionEvent.getAction() == 1) {
                        float f = this.thumbX / (measuredWidth - this.thumbWidth);
                        this.progress = f;
                        this.delegate.onSeekBarDrag(f);
                    }
                    this.pressed = false;
                    invalidate();
                    return true;
                }
            } else if (motionEvent.getAction() == 2 && this.pressed) {
                int x2 = (int) (motionEvent.getX() - this.thumbDX);
                this.thumbX = x2;
                if (x2 < 0) {
                    this.thumbX = 0;
                } else {
                    int i4 = this.thumbWidth;
                    if (x2 > measuredWidth - i4) {
                        this.thumbX = measuredWidth - i4;
                    }
                }
                if (this.reportChanges) {
                    float f2 = this.thumbX / (measuredWidth - this.thumbWidth);
                    this.progress = f2;
                    this.delegate.onSeekBarDrag(f2);
                }
                invalidate();
                return true;
            }
            return false;
        }
    }
}
