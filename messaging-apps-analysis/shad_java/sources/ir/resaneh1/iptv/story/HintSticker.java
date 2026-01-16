package ir.resaneh1.iptv.story;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes4.dex */
public class HintSticker extends FrameLayout {
    private int BLACK;
    private int WHITE;
    private int cornerRadius;
    private boolean isPointerTop;
    private Paint paint;
    private FrameLayout.LayoutParams params;
    private Path path;
    private int shadowColor;
    private int shadowRadius;
    private String textHint;
    private TextView textView;
    private int textViewPadding;
    private int triangleHeight;
    private int triangleWidth;

    public HintSticker(Context context, boolean z) {
        super(context);
        this.WHITE = -1;
        this.BLACK = -14277082;
        this.shadowColor = -2133864497;
        this.cornerRadius = AndroidUtilities.dp(10.0f);
        this.triangleWidth = AndroidUtilities.dp(20.0f);
        this.triangleHeight = AndroidUtilities.dp(10.0f);
        this.textViewPadding = AndroidUtilities.dp(9.0f);
        this.shadowRadius = AndroidUtilities.dp(10.0f);
        this.textHint = "help text";
        setWillNotDraw(false);
        this.isPointerTop = z;
        init();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 0), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 0));
    }

    private void init() {
        Paint paint = new Paint(1);
        this.paint = paint;
        paint.setColor(this.WHITE);
        this.paint.setShadowLayer(this.shadowRadius, 0.0f, 0.0f, this.shadowColor);
        this.paint.setStyle(Paint.Style.FILL);
        this.path = new Path();
        TextView textView = new TextView(getContext());
        this.textView = textView;
        textView.setHint(this.textHint);
        this.textView.setTypeface(Typeface.DEFAULT_BOLD);
        TextView textView2 = this.textView;
        int i = this.textViewPadding;
        textView2.setPadding(i, i, i, i);
        this.textView.setTextColor(this.BLACK);
        if (Build.VERSION.SDK_INT >= 17) {
            this.textView.setTextAlignment(4);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 48);
        this.params = layoutParams;
        if (this.isPointerTop) {
            layoutParams.topMargin = this.triangleHeight;
        } else {
            layoutParams.bottomMargin = this.triangleHeight;
        }
        addView(this.textView, layoutParams);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.isPointerTop) {
            this.path.reset();
            this.path.moveTo(this.cornerRadius, this.triangleHeight);
            this.path.lineTo((getWidth() / 2.0f) - (this.triangleWidth / 2.0f), this.triangleHeight);
            this.path.rLineTo(this.triangleWidth / 2.0f, -this.triangleHeight);
            this.path.rLineTo(this.triangleWidth / 2.0f, this.triangleHeight);
            this.path.lineTo(getWidth() - this.cornerRadius, this.triangleHeight);
            Path path = this.path;
            int i = this.cornerRadius;
            path.rLineTo(i, i);
            this.path.lineTo(getWidth(), getHeight() - this.cornerRadius);
            this.path.rLineTo(-r2, this.cornerRadius);
            this.path.rLineTo((-getWidth()) + (this.cornerRadius * 2), 0.0f);
            Path path2 = this.path;
            int i2 = this.cornerRadius;
            path2.rLineTo(-i2, -i2);
            this.path.lineTo(0.0f, this.triangleHeight + this.cornerRadius);
            this.path.rLineTo(this.cornerRadius, -r1);
            Path path3 = this.path;
            int i3 = this.cornerRadius;
            path3.addCircle(i3, this.triangleHeight + i3, i3, Path.Direction.CW);
            Path path4 = this.path;
            int width = getWidth();
            path4.addCircle(width - r2, this.triangleHeight + r2, this.cornerRadius, Path.Direction.CW);
            Path path5 = this.path;
            float width2 = getWidth() - this.cornerRadius;
            int height = getHeight();
            path5.addCircle(width2, height - r3, this.cornerRadius, Path.Direction.CW);
            Path path6 = this.path;
            float f = this.cornerRadius;
            int height2 = getHeight();
            path6.addCircle(f, height2 - r3, this.cornerRadius, Path.Direction.CW);
            canvas.drawPath(this.path, this.paint);
            return;
        }
        this.path.reset();
        this.path.moveTo(this.cornerRadius, 0.0f);
        this.path.rLineTo(getWidth() - (this.cornerRadius * 2), 0.0f);
        Path path7 = this.path;
        int i4 = this.cornerRadius;
        path7.rLineTo(i4, i4);
        this.path.rLineTo(0.0f, (getHeight() - (this.cornerRadius * 2)) - this.triangleHeight);
        this.path.rLineTo(-r3, this.cornerRadius);
        this.path.lineTo((getWidth() / 2.0f) + (this.triangleWidth / 2.0f), getHeight() - this.triangleHeight);
        this.path.rLineTo((-this.triangleWidth) / 2.0f, this.triangleHeight);
        this.path.rLineTo((-this.triangleWidth) / 2.0f, -this.triangleHeight);
        this.path.lineTo(this.cornerRadius, getHeight() - this.triangleHeight);
        Path path8 = this.path;
        int i5 = this.cornerRadius;
        path8.rLineTo(-i5, -i5);
        this.path.lineTo(0.0f, this.cornerRadius);
        this.path.rLineTo(this.cornerRadius, -r1);
        Path path9 = this.path;
        int i6 = this.cornerRadius;
        path9.addCircle(i6, i6, i6, Path.Direction.CW);
        Path path10 = this.path;
        int width3 = getWidth();
        int i7 = this.cornerRadius;
        path10.addCircle(width3 - i7, i7, i7, Path.Direction.CW);
        Path path11 = this.path;
        float width4 = getWidth() - this.cornerRadius;
        int height3 = getHeight();
        path11.addCircle(width4, (height3 - r3) - this.triangleHeight, this.cornerRadius, Path.Direction.CW);
        Path path12 = this.path;
        float f2 = this.cornerRadius;
        int height4 = getHeight();
        path12.addCircle(f2, (height4 - r3) - this.triangleHeight, this.cornerRadius, Path.Direction.CW);
        canvas.drawPath(this.path, this.paint);
    }

    public void setText(String str) {
        this.textView.setText(str);
    }
}
