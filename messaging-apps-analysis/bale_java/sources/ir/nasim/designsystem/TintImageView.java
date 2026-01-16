package ir.nasim.designsystem;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import ir.nasim.YE5;

/* loaded from: classes5.dex */
public class TintImageView extends View {
    private Paint a;
    private Bitmap b;
    private int c;
    private int d;
    private int e;
    private long f;

    public TintImageView(Context context) {
        super(context);
        this.a = new Paint();
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = 0L;
    }

    private void a(AttributeSet attributeSet) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, YE5.TintImageView);
        setTint(typedArrayObtainStyledAttributes.getColor(YE5.TintImageView_tintColor, -1));
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(YE5.TintImageView_src, 0);
        if (resourceId != 0) {
            Drawable drawable = getResources().getDrawable(resourceId);
            if (drawable instanceof BitmapDrawable) {
                setDrawable(((BitmapDrawable) drawable).getBitmap());
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        long jUptimeMillis = SystemClock.uptimeMillis() - this.f;
        if (jUptimeMillis > 200) {
            this.c = this.e;
        } else {
            float f = jUptimeMillis / 200.0f;
            int iRed = Color.red(this.d);
            int iGreen = Color.green(this.d);
            int iBlue = Color.blue(this.d);
            float f2 = 1.0f - f;
            this.c = Color.argb((int) ((Color.alpha(this.d) * f2) + (Color.alpha(this.e) * f)), (int) ((iRed * f2) + (Color.red(this.e) * f)), (int) ((iGreen * f2) + (Color.green(this.e) * f)), (int) ((iBlue * f2) + (Color.blue(this.e) * f)));
            invalidate();
        }
        if (this.b != null) {
            this.a.setColorFilter(new PorterDuffColorFilter(this.c, PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(this.b, (getWidth() - this.b.getWidth()) / 2, (getHeight() - this.b.getHeight()) / 2, this.a);
        }
    }

    public void setDrawable(Bitmap bitmap) {
        this.b = bitmap;
        invalidate();
    }

    public void setResource(int i) {
        setDrawable(((BitmapDrawable) getResources().getDrawable(i)).getBitmap());
    }

    public void setTint(int i) {
        this.c = i;
        this.d = i;
        this.e = i;
        this.f = 0L;
        invalidate();
    }

    public TintImageView(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        this.a = new Paint();
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = 0L;
        a(attributeSet);
    }

    public TintImageView(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        super(context, attributeSet, i);
        this.a = new Paint();
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = 0L;
        a(attributeSet);
    }
}
