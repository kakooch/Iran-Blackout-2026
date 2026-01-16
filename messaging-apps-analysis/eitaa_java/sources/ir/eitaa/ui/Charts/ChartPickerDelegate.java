package ir.eitaa.ui.Charts;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.MotionEvent;
import ir.eitaa.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class ChartPickerDelegate {
    public boolean disabled;
    ValueAnimator moveToAnimator;
    public float moveToX;
    public float moveToY;
    public float pickerWidth;
    public long startTapTime;
    public boolean tryMoveTo;
    Listener view;
    public Rect leftPickerArea = new Rect();
    public Rect rightPickerArea = new Rect();
    public Rect middlePickerArea = new Rect();
    public float pickerStart = 0.7f;
    public float pickerEnd = 1.0f;
    public float minDistance = 0.1f;
    CapturesData[] capturedStates = {null, null};

    interface Listener {
        void invalidate();

        void onPickerDataChanged();

        void onPickerJumpTo(float start, float end, boolean force);
    }

    public ChartPickerDelegate(Listener view) {
        this.view = view;
    }

    public CapturesData getMiddleCaptured() {
        CapturesData[] capturesDataArr = this.capturedStates;
        if (capturesDataArr[0] != null && capturesDataArr[0].state == 4) {
            return capturesDataArr[0];
        }
        if (capturesDataArr[1] == null || capturesDataArr[1].state != 4) {
            return null;
        }
        return capturesDataArr[1];
    }

    public CapturesData getLeftCaptured() {
        CapturesData[] capturesDataArr = this.capturedStates;
        if (capturesDataArr[0] != null && capturesDataArr[0].state == 1) {
            return capturesDataArr[0];
        }
        if (capturesDataArr[1] == null || capturesDataArr[1].state != 1) {
            return null;
        }
        return capturesDataArr[1];
    }

    public CapturesData getRightCaptured() {
        CapturesData[] capturesDataArr = this.capturedStates;
        if (capturesDataArr[0] != null && capturesDataArr[0].state == 2) {
            return capturesDataArr[0];
        }
        if (capturesDataArr[1] == null || capturesDataArr[1].state != 2) {
            return null;
        }
        return capturesDataArr[1];
    }

    class CapturesData {
        ValueAnimator a;
        public float aValue = 0.0f;
        public int capturedX;
        public float end;
        ValueAnimator jumpToAnimator;
        public int lastMovingX;
        public float start;
        public final int state;

        public CapturesData(int state) {
            this.state = state;
        }

        public void captured() {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.a = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(600L);
            this.a.setInterpolator(BaseChartView.INTERPOLATOR);
            this.a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Charts.-$$Lambda$ChartPickerDelegate$CapturesData$boXpCnIuiHQZnNFgv_DcPnJv3Q0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$captured$0$ChartPickerDelegate$CapturesData(valueAnimator);
                }
            });
            this.a.start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$captured$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$captured$0$ChartPickerDelegate$CapturesData(ValueAnimator valueAnimator) {
            this.aValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ChartPickerDelegate.this.view.invalidate();
        }

        public void uncapture() {
            ValueAnimator valueAnimator = this.a;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator valueAnimator2 = this.jumpToAnimator;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
            }
        }
    }

    public boolean capture(int x, int y, int pointerIndex) {
        if (this.disabled) {
            return false;
        }
        if (pointerIndex == 0) {
            if (this.leftPickerArea.contains(x, y)) {
                CapturesData[] capturesDataArr = this.capturedStates;
                if (capturesDataArr[0] != null) {
                    capturesDataArr[1] = capturesDataArr[0];
                }
                capturesDataArr[0] = new CapturesData(1);
                CapturesData[] capturesDataArr2 = this.capturedStates;
                capturesDataArr2[0].start = this.pickerStart;
                capturesDataArr2[0].capturedX = x;
                capturesDataArr2[0].lastMovingX = x;
                capturesDataArr2[0].captured();
                ValueAnimator valueAnimator = this.moveToAnimator;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                return true;
            }
            if (this.rightPickerArea.contains(x, y)) {
                CapturesData[] capturesDataArr3 = this.capturedStates;
                if (capturesDataArr3[0] != null) {
                    capturesDataArr3[1] = capturesDataArr3[0];
                }
                capturesDataArr3[0] = new CapturesData(2);
                CapturesData[] capturesDataArr4 = this.capturedStates;
                capturesDataArr4[0].end = this.pickerEnd;
                capturesDataArr4[0].capturedX = x;
                capturesDataArr4[0].lastMovingX = x;
                capturesDataArr4[0].captured();
                ValueAnimator valueAnimator2 = this.moveToAnimator;
                if (valueAnimator2 != null) {
                    valueAnimator2.cancel();
                }
                return true;
            }
            if (this.middlePickerArea.contains(x, y)) {
                this.capturedStates[0] = new CapturesData(4);
                CapturesData[] capturesDataArr5 = this.capturedStates;
                capturesDataArr5[0].end = this.pickerEnd;
                capturesDataArr5[0].start = this.pickerStart;
                capturesDataArr5[0].capturedX = x;
                capturesDataArr5[0].lastMovingX = x;
                capturesDataArr5[0].captured();
                ValueAnimator valueAnimator3 = this.moveToAnimator;
                if (valueAnimator3 != null) {
                    valueAnimator3.cancel();
                }
                return true;
            }
            Rect rect = this.leftPickerArea;
            if (y < rect.bottom && y > rect.top) {
                this.tryMoveTo = true;
                this.moveToX = x;
                this.moveToY = y;
                this.startTapTime = System.currentTimeMillis();
                ValueAnimator valueAnimator4 = this.moveToAnimator;
                if (valueAnimator4 != null) {
                    if (valueAnimator4.isRunning()) {
                        this.view.onPickerJumpTo(this.pickerStart, this.pickerEnd, true);
                    }
                    this.moveToAnimator.cancel();
                }
                return true;
            }
        } else if (pointerIndex == 1) {
            CapturesData[] capturesDataArr6 = this.capturedStates;
            if (capturesDataArr6[0] == null || capturesDataArr6[0].state == 4) {
                return false;
            }
            if (this.leftPickerArea.contains(x, y)) {
                CapturesData[] capturesDataArr7 = this.capturedStates;
                if (capturesDataArr7[0].state != 1) {
                    capturesDataArr7[1] = new CapturesData(1);
                    CapturesData[] capturesDataArr8 = this.capturedStates;
                    capturesDataArr8[1].start = this.pickerStart;
                    capturesDataArr8[1].capturedX = x;
                    capturesDataArr8[1].lastMovingX = x;
                    capturesDataArr8[1].captured();
                    ValueAnimator valueAnimator5 = this.moveToAnimator;
                    if (valueAnimator5 != null) {
                        valueAnimator5.cancel();
                    }
                    return true;
                }
            }
            if (this.rightPickerArea.contains(x, y)) {
                CapturesData[] capturesDataArr9 = this.capturedStates;
                if (capturesDataArr9[0].state == 2) {
                    return false;
                }
                capturesDataArr9[1] = new CapturesData(2);
                CapturesData[] capturesDataArr10 = this.capturedStates;
                capturesDataArr10[1].end = this.pickerEnd;
                capturesDataArr10[1].capturedX = x;
                capturesDataArr10[1].lastMovingX = x;
                capturesDataArr10[1].captured();
                ValueAnimator valueAnimator6 = this.moveToAnimator;
                if (valueAnimator6 != null) {
                    valueAnimator6.cancel();
                }
                return true;
            }
        }
        return false;
    }

    public boolean captured() {
        return this.capturedStates[0] != null || this.tryMoveTo;
    }

    public boolean move(int x, int y, int pointer) {
        CapturesData capturesData;
        boolean z = false;
        if (this.tryMoveTo || (capturesData = this.capturedStates[pointer]) == null) {
            return false;
        }
        int i = capturesData.state;
        float f = capturesData.start;
        float f2 = capturesData.end;
        int i2 = capturesData.capturedX;
        capturesData.lastMovingX = x;
        if (i == 1) {
            float f3 = f - ((i2 - x) / this.pickerWidth);
            this.pickerStart = f3;
            if (f3 < 0.0f) {
                this.pickerStart = 0.0f;
            }
            float f4 = this.pickerEnd;
            float f5 = f4 - this.pickerStart;
            float f6 = this.minDistance;
            if (f5 < f6) {
                this.pickerStart = f4 - f6;
            }
            z = true;
        }
        if (i == 2) {
            float f7 = f2 - ((i2 - x) / this.pickerWidth);
            this.pickerEnd = f7;
            if (f7 > 1.0f) {
                this.pickerEnd = 1.0f;
            }
            float f8 = this.pickerEnd;
            float f9 = this.pickerStart;
            float f10 = f8 - f9;
            float f11 = this.minDistance;
            if (f10 < f11) {
                this.pickerEnd = f9 + f11;
            }
            z = true;
        }
        if (i == 4) {
            float f12 = i2 - x;
            float f13 = this.pickerWidth;
            float f14 = f - (f12 / f13);
            this.pickerStart = f14;
            this.pickerEnd = f2 - (f12 / f13);
            if (f14 < 0.0f) {
                this.pickerStart = 0.0f;
                this.pickerEnd = f2 - f;
            }
            if (this.pickerEnd > 1.0f) {
                this.pickerEnd = 1.0f;
                this.pickerStart = 1.0f - (f2 - f);
            }
            z = true;
        }
        if (z) {
            this.view.onPickerDataChanged();
        }
        return true;
    }

    public boolean uncapture(MotionEvent event, int pointerIndex) {
        final float f;
        final float f2;
        if (pointerIndex == 0) {
            if (this.tryMoveTo) {
                this.tryMoveTo = false;
                float x = this.moveToX - event.getX();
                float y = this.moveToY - event.getY();
                if (event.getAction() == 1 && System.currentTimeMillis() - this.startTapTime < 300 && Math.sqrt((x * x) + (y * y)) < AndroidUtilities.dp(10.0f)) {
                    float f3 = (this.moveToX - BaseChartView.HORIZONTAL_PADDING) / this.pickerWidth;
                    final float f4 = this.pickerEnd;
                    final float f5 = this.pickerStart;
                    float f6 = f4 - f5;
                    float f7 = f6 / 2.0f;
                    float f8 = f3 - f7;
                    float f9 = f3 + f7;
                    if (f8 < 0.0f) {
                        f = f6;
                        f2 = 0.0f;
                    } else if (f9 > 1.0f) {
                        f2 = 1.0f - f6;
                        f = 1.0f;
                    } else {
                        f = f9;
                        f2 = f8;
                    }
                    this.moveToAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.view.onPickerJumpTo(f2, f, true);
                    this.moveToAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Charts.-$$Lambda$ChartPickerDelegate$iTDARg9rI7EtSoFmryQcIo-AHVg
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            this.f$0.lambda$uncapture$0$ChartPickerDelegate(f5, f2, f4, f, valueAnimator);
                        }
                    });
                    this.moveToAnimator.setInterpolator(BaseChartView.INTERPOLATOR);
                    this.moveToAnimator.start();
                }
                return true;
            }
            CapturesData[] capturesDataArr = this.capturedStates;
            if (capturesDataArr[0] != null) {
                capturesDataArr[0].uncapture();
            }
            CapturesData[] capturesDataArr2 = this.capturedStates;
            capturesDataArr2[0] = null;
            if (capturesDataArr2[1] != null) {
                capturesDataArr2[0] = capturesDataArr2[1];
                capturesDataArr2[1] = null;
            }
        } else {
            CapturesData[] capturesDataArr3 = this.capturedStates;
            if (capturesDataArr3[1] != null) {
                capturesDataArr3[1].uncapture();
            }
            this.capturedStates[1] = null;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$uncapture$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$uncapture$0$ChartPickerDelegate(float f, float f2, float f3, float f4, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.pickerStart = f + ((f2 - f) * fFloatValue);
        this.pickerEnd = f3 + ((f4 - f3) * fFloatValue);
        this.view.onPickerJumpTo(f2, f4, false);
    }

    public void uncapture() {
        CapturesData[] capturesDataArr = this.capturedStates;
        if (capturesDataArr[0] != null) {
            capturesDataArr[0].uncapture();
        }
        CapturesData[] capturesDataArr2 = this.capturedStates;
        if (capturesDataArr2[1] != null) {
            capturesDataArr2[1].uncapture();
        }
        CapturesData[] capturesDataArr3 = this.capturedStates;
        capturesDataArr3[0] = null;
        capturesDataArr3[1] = null;
    }
}
