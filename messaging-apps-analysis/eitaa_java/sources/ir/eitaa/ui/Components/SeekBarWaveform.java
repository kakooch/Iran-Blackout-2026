package ir.eitaa.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.ui.Components.SeekBar;

/* loaded from: classes3.dex */
public class SeekBarWaveform {
    private static Paint paintInner;
    private static Paint paintOuter;
    private int clearFromX;
    private SeekBar.SeekBarDelegate delegate;
    private int height;
    private int innerColor;
    private boolean isUnread;
    private MessageObject messageObject;
    private int outerColor;
    private View parentView;
    private boolean selected;
    private int selectedColor;
    private float startX;
    private byte[] waveformBytes;
    private int width;
    private int thumbX = 0;
    private int thumbDX = 0;
    private boolean startDraging = false;
    private boolean pressed = false;
    private float clearProgress = 1.0f;
    private float waveScaling = 1.0f;

    public SeekBarWaveform(Context context) {
        if (paintInner == null) {
            paintInner = new Paint(1);
            paintOuter = new Paint(1);
            paintInner.setStyle(Paint.Style.STROKE);
            paintOuter.setStyle(Paint.Style.STROKE);
            paintInner.setStrokeWidth(AndroidUtilities.dpf2(2.0f));
            paintOuter.setStrokeWidth(AndroidUtilities.dpf2(2.0f));
            paintInner.setStrokeCap(Paint.Cap.ROUND);
            paintOuter.setStrokeCap(Paint.Cap.ROUND);
        }
    }

    public void setDelegate(SeekBar.SeekBarDelegate seekBarDelegate) {
        this.delegate = seekBarDelegate;
    }

    public void setColors(int inner, int outer, int selected) {
        this.innerColor = inner;
        this.outerColor = outer;
        this.selectedColor = selected;
    }

    public void setWaveform(byte[] waveform) {
        this.waveformBytes = waveform;
    }

    public void setSelected(boolean value) {
        this.selected = value;
    }

    public void setMessageObject(MessageObject object) {
        this.messageObject = object;
    }

    public void setParentView(View view) {
        this.parentView = view;
    }

    public boolean isStartDraging() {
        return this.startDraging;
    }

    public boolean onTouch(int action, float x, float y) {
        SeekBar.SeekBarDelegate seekBarDelegate;
        if (action == 0) {
            if (0.0f <= x && x <= this.width && y >= 0.0f && y <= this.height) {
                this.startX = x;
                this.pressed = true;
                this.thumbDX = (int) (x - this.thumbX);
                this.startDraging = false;
                return true;
            }
        } else if (action == 1 || action == 3) {
            if (this.pressed) {
                if (action == 1 && (seekBarDelegate = this.delegate) != null) {
                    seekBarDelegate.onSeekBarDrag(this.thumbX / this.width);
                }
                this.pressed = false;
                return true;
            }
        } else if (action == 2 && this.pressed) {
            if (this.startDraging) {
                int i = (int) (x - this.thumbDX);
                this.thumbX = i;
                if (i < 0) {
                    this.thumbX = 0;
                } else {
                    int i2 = this.width;
                    if (i > i2) {
                        this.thumbX = i2;
                    }
                }
            }
            float f = this.startX;
            if (f != -1.0f && Math.abs(x - f) > AndroidUtilities.getPixelsInCM(0.2f, true)) {
                View view = this.parentView;
                if (view != null && view.getParent() != null) {
                    this.parentView.getParent().requestDisallowInterceptTouchEvent(true);
                }
                this.startDraging = true;
                this.startX = -1.0f;
            }
            return true;
        }
        return false;
    }

    public float getProgress() {
        return this.thumbX / this.width;
    }

    public void setProgress(float progress) {
        setProgress(progress, false);
    }

    public void setProgress(float progress, boolean animated) {
        int i = this.isUnread ? this.width : this.thumbX;
        if (animated && i != 0 && progress == 0.0f) {
            this.clearFromX = i;
            this.clearProgress = 0.0f;
        } else if (!animated) {
            this.clearProgress = 1.0f;
        }
        int iCeil = (int) Math.ceil(this.width * progress);
        this.thumbX = iCeil;
        if (iCeil < 0) {
            this.thumbX = 0;
            return;
        }
        int i2 = this.width;
        if (iCeil > i2) {
            this.thumbX = i2;
        }
    }

    public boolean isDragging() {
        return this.pressed;
    }

    public void setSize(int w, int h) {
        this.width = w;
        this.height = h;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r29, android.view.View r30) {
        /*
            Method dump skipped, instructions count: 554
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.SeekBarWaveform.draw(android.graphics.Canvas, android.view.View):void");
    }

    private void drawLine(Canvas canvas, float x, int y, float h, Paint paint) {
        float f = h * this.waveScaling;
        if (f == 0.0f) {
            canvas.drawPoint(x + AndroidUtilities.dpf2(1.0f), y + AndroidUtilities.dp(7.0f), paint);
        } else {
            canvas.drawLine(x + AndroidUtilities.dpf2(1.0f), (AndroidUtilities.dp(7.0f) + y) - f, x + AndroidUtilities.dpf2(1.0f), y + AndroidUtilities.dp(7.0f) + f, paint);
        }
    }

    public void setWaveScaling(float waveScaling) {
        this.waveScaling = waveScaling;
    }
}
