package ir.resaneh1.iptv.UIView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import ir.resaneh1.iptv.helper.StoryEntityView;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class UI_rubinoDropperSelectorCell {
    public float circleCenterX;
    public float circleCenterY;
    public DropperSelectorFrameLayout frameLayout;
    public DropperSelectorFrameLayout view;

    public View createView(Activity activity) {
        DropperSelectorFrameLayout dropperSelectorFrameLayout = new DropperSelectorFrameLayout(activity);
        this.frameLayout = dropperSelectorFrameLayout;
        this.view = dropperSelectorFrameLayout;
        dropperSelectorFrameLayout.setTag(this);
        return this.view;
    }

    public void setColor(int i) {
        this.frameLayout.setColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public class DropperSelectorFrameLayout extends StoryEntityView {
        int color;
        int lastHeight;
        int lastWidth;
        int padding;
        Paint paintBorder;
        Paint paintColor;
        Paint paintShadow;
        Path path;
        float whRatio;

        public DropperSelectorFrameLayout(Context context) {
            super(context);
            this.paintShadow = new Paint(1);
            this.paintBorder = new Paint(1);
            this.paintColor = new Paint(1);
            setWillNotDraw(false);
            this.whRatio = 1.4117647f;
            this.padding = AndroidUtilities.dp(4.0f);
            this.paintBorder.setColor(-1);
            this.paintColor.setColor(-65536);
            this.paintShadow.setColor(-184549376);
            this.paintShadow.setShadowLayer(this.padding, 0.0f, AndroidUtilities.dp(1.0f), -16777216);
            this.paintShadow.setStyle(Paint.Style.FILL);
            this.paintBorder.setStyle(Paint.Style.STROKE);
            this.paintBorder.setStrokeCap(Paint.Cap.ROUND);
            this.paintBorder.setStrokeJoin(Paint.Join.ROUND);
            this.paintBorder.setStrokeWidth(AndroidUtilities.dp(1.0f));
        }

        public void setPath(float f, float f2) {
            Path path = new Path();
            this.path = path;
            float f3 = f / 2.0f;
            path.moveTo(f3, 0.0f);
            float f4 = f2 - (f2 / 2.0f);
            this.path.cubicTo(f / 4.0f, 0.0f, 0.0f, f4, f3, f2);
            this.path.cubicTo(f, f4, (f * 3.0f) / 4.0f, 0.0f, f3, 0.0f);
            UI_rubinoDropperSelectorCell uI_rubinoDropperSelectorCell = UI_rubinoDropperSelectorCell.this;
            uI_rubinoDropperSelectorCell.circleCenterX = f3;
            float f5 = f / 20.0f;
            float f6 = ((f2 * 3.0f) / 2.0f) - f5;
            uI_rubinoDropperSelectorCell.circleCenterY = f6;
            this.path.moveTo(f3, f6);
            Path path2 = this.path;
            UI_rubinoDropperSelectorCell uI_rubinoDropperSelectorCell2 = UI_rubinoDropperSelectorCell.this;
            path2.addCircle(uI_rubinoDropperSelectorCell2.circleCenterX, uI_rubinoDropperSelectorCell2.circleCenterY, f5, Path.Direction.CW);
        }

        public void setColor(int i) {
            this.color = i;
            this.paintColor.setColor(i);
            invalidate();
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (z) {
                if (this.lastWidth == getMeasuredWidth() && this.lastHeight == getMeasuredHeight()) {
                    return;
                }
                float measuredWidth = getMeasuredWidth() - (this.padding * 2);
                float measuredHeight = ((getMeasuredHeight() - (this.padding * 2)) * 3.0f) / 4.0f;
                float f = measuredWidth / measuredHeight;
                float f2 = this.whRatio;
                if (f >= f2) {
                    measuredWidth = f2 * measuredHeight;
                } else {
                    measuredHeight = measuredWidth / f2;
                }
                setPath(measuredWidth, measuredHeight);
                this.lastWidth = getMeasuredWidth();
                this.lastHeight = getMeasuredHeight();
            }
        }

        @Override // ir.resaneh1.iptv.helper.StoryEntityView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.path != null) {
                canvas.save();
                int i = this.padding;
                canvas.translate(i, i);
                canvas.drawPath(this.path, this.paintShadow);
                canvas.drawPath(this.path, this.paintColor);
                canvas.drawPath(this.path, this.paintBorder);
                canvas.restore();
            }
        }
    }

    public int getColor() {
        return this.frameLayout.color;
    }
}
