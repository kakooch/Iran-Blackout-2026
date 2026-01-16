package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import java.util.List;

/* renamed from: ir.nasim.Kl4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5699Kl4 extends Drawable {
    private final List a;
    private final Paint b;
    private final Paint c;
    private final Path d;
    private final float e;
    private final int f;
    private final int g;

    public /* synthetic */ C5699Kl4(Context context, List list, float f, float f2, float f3, int i, ED1 ed1) {
        this(context, list, (i & 4) != 0 ? 18.0f : f, (i & 8) != 0 ? 2.0f : f2, (i & 16) != 0 ? 4.0f : f3);
    }

    private final void a(Canvas canvas, float f, float f2) {
        int i = this.f;
        float f3 = f + (i / 2.0f);
        float f4 = f2 + (i / 2.0f);
        float f5 = i * 0.25f;
        Paint paint = new Paint(1);
        paint.setColor(-16777216);
        paint.setAlpha(SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(f3, f4, 1.2f * f5, paint);
        this.d.reset();
        float f6 = f3 - (f5 / 2.0f);
        this.d.moveTo(f6, f4 - f5);
        this.d.lineTo(f6, f4 + f5);
        this.d.lineTo(f3 + f5, f4);
        this.d.close();
        canvas.drawPath(this.d, this.c);
    }

    private final void b(Canvas canvas, Bitmap bitmap, float f, float f2) {
        int i = this.f;
        RectF rectF = new RectF(f, f2, i + f, i + f2);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.b.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        float f3 = this.e;
        canvas.drawRoundRect(rectF, f3, f3, this.b);
        this.b.setShader(null);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        AbstractC13042fc3.i(canvas, "canvas");
        float fHeight = getBounds().top + (((getBounds().height() - this.f) / 2.0f) - C22078ud6.a(1.0f));
        float f = getBounds().left;
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            C24565yp7 c24565yp7 = (C24565yp7) this.a.get(i);
            Bitmap bitmapB = c24565yp7.b();
            if (bitmapB == null) {
                int i2 = this.f;
                bitmapB = Bitmap.createBitmap(i2, i2, Bitmap.Config.ARGB_8888);
            }
            int i3 = this.f;
            b(canvas, Bitmap.createScaledBitmap(bitmapB, i3, i3, true), f, fHeight);
            if (c24565yp7.a()) {
                a(canvas, f, fHeight);
            }
            f += this.f + this.g;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i = AbstractC23053wG5.i(this.a.size(), 3);
        return (this.f * i) + ((i - 1) * this.g);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.b.setAlpha(i);
        this.c.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public C5699Kl4(Context context, List list, float f, float f2, float f3) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(list, "items");
        this.a = list;
        this.b = new Paint(1);
        Paint paint = new Paint(1);
        this.c = paint;
        this.d = new Path();
        float f4 = context.getResources().getDisplayMetrics().density;
        this.e = f3 * f4;
        this.f = (int) (f * f4);
        this.g = (int) (f2 * f4);
        paint.setColor(-1);
        paint.setStyle(Paint.Style.FILL);
        paint.setAlpha(SetRpcStruct$ComposedRpc.CREATE_GROUP_FIELD_NUMBER);
    }
}
