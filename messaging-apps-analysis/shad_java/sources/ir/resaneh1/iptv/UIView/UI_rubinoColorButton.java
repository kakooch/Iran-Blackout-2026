package ir.resaneh1.iptv.UIView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.SweepGradient;
import android.widget.FrameLayout;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class UI_rubinoColorButton extends FrameLayout {
    final int[] COLORS2;
    private float paddingDp;
    Paint paint;
    Paint paint2;

    public UI_rubinoColorButton(Context context) {
        super(context);
        this.paddingDp = 2.0f;
        this.COLORS2 = new int[]{Color.parseColor("#33004c"), Color.parseColor("#4600d2"), Color.parseColor("#0000ff"), Color.parseColor("#0099ff"), Color.parseColor("#00eeff"), Color.parseColor("#00FF7F"), Color.parseColor("#48FF00"), Color.parseColor("#B6FF00"), Color.parseColor("#FFD700"), Color.parseColor("#ff9500"), Color.parseColor("#FF6200"), Color.parseColor("#FF0000"), Color.parseColor("#33004c")};
        setWillNotDraw(false);
        this.paint = new Paint(1);
        this.paint2 = new Paint(1);
        this.paint.setColor(-1);
        this.paint2.setColor(-1);
        this.paint2.setStyle(Paint.Style.STROKE);
        this.paint2.setStrokeWidth(AndroidUtilities.dp(2.0f));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.paint.setShader(new SweepGradient(getMeasuredWidth() / 2, getMeasuredHeight() / 2, this.COLORS2, (float[]) null));
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, (getMeasuredHeight() / 2) - AndroidUtilities.dp(this.paddingDp), this.paint);
        canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, (getMeasuredHeight() / 2) - AndroidUtilities.dp(this.paddingDp), this.paint2);
    }
}
