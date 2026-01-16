package ir.eitaa.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class SlideChooseView extends View {
    private final SeekBarAccessibilityDelegate accessibilityDelegate;
    private Callback callback;
    private int circleSize;
    private int dashedFrom;
    private int gapSize;
    private int lastDash;
    private Paint linePaint;
    private int lineSize;
    private boolean moving;
    private int[] optionsSizes;
    private String[] optionsStr;
    private Paint paint;
    private final Theme.ResourcesProvider resourcesProvider;
    private int selectedIndex;
    private int sideSide;
    private boolean startMoving;
    private int startMovingPreset;
    private float startX;
    private TextPaint textPaint;

    public interface Callback {

        /* renamed from: ir.eitaa.ui.Components.SlideChooseView$Callback$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onTouchEnd(Callback callback) {
            }
        }

        void onOptionSelected(int index);

        void onTouchEnd();
    }

    public SlideChooseView(Context context) {
        this(context, null);
    }

    public SlideChooseView(Context context, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.dashedFrom = -1;
        this.resourcesProvider = resourcesProvider;
        this.paint = new Paint(1);
        this.textPaint = new TextPaint(1);
        Paint paint = new Paint(1);
        this.linePaint = paint;
        paint.setStrokeWidth(AndroidUtilities.dp(2.0f));
        this.linePaint.setStrokeCap(Paint.Cap.ROUND);
        this.textPaint.setTextSize(AndroidUtilities.dp(13.0f));
        this.textPaint.setTypeface(AndroidUtilities.getFontFamily(false));
        this.accessibilityDelegate = new IntSeekBarAccessibilityDelegate() { // from class: ir.eitaa.ui.Components.SlideChooseView.1
            @Override // ir.eitaa.ui.Components.IntSeekBarAccessibilityDelegate
            protected int getProgress() {
                return SlideChooseView.this.selectedIndex;
            }

            @Override // ir.eitaa.ui.Components.IntSeekBarAccessibilityDelegate
            protected void setProgress(int progress) {
                SlideChooseView.this.setOption(progress);
            }

            @Override // ir.eitaa.ui.Components.IntSeekBarAccessibilityDelegate
            protected int getMaxValue() {
                return SlideChooseView.this.optionsStr.length - 1;
            }

            @Override // ir.eitaa.ui.Components.SeekBarAccessibilityDelegate
            protected CharSequence getContentDescription(View host) {
                if (SlideChooseView.this.selectedIndex < SlideChooseView.this.optionsStr.length) {
                    return SlideChooseView.this.optionsStr[SlideChooseView.this.selectedIndex];
                }
                return null;
            }
        };
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public void setOptions(int selected, String... options) {
        this.optionsStr = options;
        this.selectedIndex = selected;
        this.optionsSizes = new int[options.length];
        int i = 0;
        while (true) {
            if (i < this.optionsStr.length) {
                this.optionsSizes[i] = (int) Math.ceil(this.textPaint.measureText(r5[i]));
                i++;
            } else {
                requestLayout();
                return;
            }
        }
    }

    public void setDashedFrom(int from) {
        this.dashedFrom = from;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        int i = 0;
        if (motionEvent.getAction() == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
            int i2 = 0;
            while (true) {
                if (i2 >= this.optionsStr.length) {
                    break;
                }
                int i3 = this.sideSide;
                int i4 = this.lineSize + (this.gapSize * 2);
                int i5 = this.circleSize;
                int i6 = i3 + ((i4 + i5) * i2) + (i5 / 2);
                if (x <= i6 - AndroidUtilities.dp(15.0f) || x >= i6 + AndroidUtilities.dp(15.0f)) {
                    i2++;
                } else {
                    int i7 = this.selectedIndex;
                    this.startMoving = i2 == i7;
                    this.startX = x;
                    this.startMovingPreset = i7;
                }
            }
        } else if (motionEvent.getAction() == 2) {
            if (this.startMoving) {
                if (Math.abs(this.startX - x) >= AndroidUtilities.getPixelsInCM(0.5f, true)) {
                    this.moving = true;
                    this.startMoving = false;
                }
            } else if (this.moving) {
                while (true) {
                    if (i >= this.optionsStr.length) {
                        break;
                    }
                    int i8 = this.sideSide;
                    int i9 = this.lineSize;
                    int i10 = this.gapSize;
                    int i11 = this.circleSize;
                    int i12 = i8 + (((i10 * 2) + i9 + i11) * i) + (i11 / 2);
                    int i13 = (i9 / 2) + (i11 / 2) + i10;
                    if (x <= i12 - i13 || x >= i12 + i13) {
                        i++;
                    } else if (this.selectedIndex != i) {
                        setOption(i);
                    }
                }
            }
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            if (!this.moving) {
                int i14 = 0;
                while (true) {
                    if (i14 >= 5) {
                        break;
                    }
                    int i15 = this.sideSide;
                    int i16 = this.lineSize + (this.gapSize * 2);
                    int i17 = this.circleSize;
                    int i18 = i15 + ((i16 + i17) * i14) + (i17 / 2);
                    if (x <= i18 - AndroidUtilities.dp(15.0f) || x >= i18 + AndroidUtilities.dp(15.0f)) {
                        i14++;
                    } else if (this.selectedIndex != i14) {
                        setOption(i14);
                    }
                }
            } else {
                int i19 = this.selectedIndex;
                if (i19 != this.startMovingPreset) {
                    setOption(i19);
                }
            }
            Callback callback = this.callback;
            if (callback != null) {
                callback.onTouchEnd();
            }
            this.startMoving = false;
            this.moving = false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOption(int index) {
        this.selectedIndex = index;
        Callback callback = this.callback;
        if (callback != null) {
            callback.onOptionSelected(index);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(74.0f), 1073741824));
        View.MeasureSpec.getSize(widthMeasureSpec);
        this.circleSize = AndroidUtilities.dp(6.0f);
        this.gapSize = AndroidUtilities.dp(2.0f);
        this.sideSide = AndroidUtilities.dp(22.0f);
        this.lineSize = (((getMeasuredWidth() - (this.circleSize * this.optionsStr.length)) - ((this.gapSize * 2) * (r0.length - 1))) - (this.sideSide * 2)) / (r0.length - 1);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.textPaint.setColor(getThemedColor("windowBackgroundWhiteGrayText"));
        int measuredHeight = (getMeasuredHeight() / 2) + AndroidUtilities.dp(11.0f);
        int i = 0;
        while (i < this.optionsStr.length) {
            int i2 = this.sideSide;
            int i3 = this.lineSize + (this.gapSize * 2);
            int i4 = this.circleSize;
            int i5 = i2 + ((i3 + i4) * i) + (i4 / 2);
            if (i <= this.selectedIndex) {
                int themedColor = getThemedColor("switchTrackChecked");
                this.paint.setColor(themedColor);
                this.linePaint.setColor(themedColor);
            } else {
                int themedColor2 = getThemedColor("switchTrack");
                this.paint.setColor(themedColor2);
                this.linePaint.setColor(themedColor2);
            }
            float f = measuredHeight;
            canvas.drawCircle(i5, f, i == this.selectedIndex ? AndroidUtilities.dp(6.0f) : this.circleSize / 2, this.paint);
            if (i != 0) {
                int i6 = (i5 - (this.circleSize / 2)) - this.gapSize;
                int iDp = this.lineSize;
                int iDp2 = i6 - iDp;
                int i7 = this.dashedFrom;
                if (i7 != -1 && i - 1 >= i7) {
                    int iDp3 = iDp2 + AndroidUtilities.dp(3.0f);
                    int iDp4 = (iDp - AndroidUtilities.dp(3.0f)) / AndroidUtilities.dp(13.0f);
                    if (this.lastDash != iDp4) {
                        this.linePaint.setPathEffect(new DashPathEffect(new float[]{AndroidUtilities.dp(6.0f), (r2 - (AndroidUtilities.dp(8.0f) * iDp4)) / (iDp4 - 1)}, 0.0f));
                        this.lastDash = iDp4;
                    }
                    canvas.drawLine(AndroidUtilities.dp(1.0f) + iDp3, f, (iDp3 + r2) - AndroidUtilities.dp(1.0f), f, this.linePaint);
                } else {
                    int i8 = this.selectedIndex;
                    if (i == i8 || i == i8 + 1) {
                        iDp -= AndroidUtilities.dp(3.0f);
                    }
                    if (i == this.selectedIndex + 1) {
                        iDp2 += AndroidUtilities.dp(3.0f);
                    }
                    canvas.drawRect(iDp2, measuredHeight - AndroidUtilities.dp(1.0f), iDp2 + iDp, AndroidUtilities.dp(1.0f) + measuredHeight, this.paint);
                }
            }
            int i9 = this.optionsSizes[i];
            String[] strArr = this.optionsStr;
            String str = strArr[i];
            if (i == 0) {
                canvas.drawText(str, AndroidUtilities.dp(22.0f), AndroidUtilities.dp(28.0f), this.textPaint);
            } else if (i == strArr.length - 1) {
                canvas.drawText(str, (getMeasuredWidth() - i9) - AndroidUtilities.dp(22.0f), AndroidUtilities.dp(28.0f), this.textPaint);
            } else {
                canvas.drawText(str, i5 - (i9 / 2), AndroidUtilities.dp(28.0f), this.textPaint);
            }
            i++;
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        this.accessibilityDelegate.onInitializeAccessibilityNodeInfoInternal(this, info);
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int action, Bundle arguments) {
        return super.performAccessibilityAction(action, arguments) || this.accessibilityDelegate.performAccessibilityActionInternal(this, action, arguments);
    }

    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
