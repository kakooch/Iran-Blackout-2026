package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Shader;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class XI6 {
    private static XI6 l;
    private Bitmap b;
    Bitmap c;
    Bitmap d;
    Canvas e;
    Paint f;
    long g;
    ArrayList h;
    boolean i;
    int k;
    final HU1 a = new HU1("SpoilerEffectBitmapFactory", true, 3);
    Matrix j = new Matrix();

    private XI6() {
        int iF = AbstractC21455b.F(AbstractC8662Wx6.h() == 2 ? 200.0f : 150.0f);
        Point point = AbstractC21455b.h;
        int iMin = (int) Math.min(Math.min(point.x, point.y) * 0.5f, iF);
        this.k = iMin;
        if (iMin < AbstractC21455b.F(100.0f)) {
            this.k = AbstractC21455b.F(100.0f);
        }
    }

    public static XI6 d() {
        if (l == null) {
            l = new XI6();
        }
        return l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(Bitmap bitmap) {
        this.c = this.b;
        this.b = bitmap;
        Paint paint = this.f;
        Bitmap bitmap2 = this.b;
        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
        paint.setShader(new BitmapShader(bitmap2, tileMode, tileMode));
        this.i = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(final Bitmap bitmap) {
        if (bitmap == null) {
            int i = this.k;
            bitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
        }
        Bitmap bitmap2 = this.d;
        if (bitmap2 == null) {
            int i2 = this.k;
            this.d = Bitmap.createBitmap(i2, i2, Bitmap.Config.ARGB_8888);
        } else {
            bitmap2.eraseColor(0);
        }
        Canvas canvas = new Canvas(bitmap);
        Canvas canvas2 = new Canvas(this.d);
        for (int i3 = 0; i3 < 10; i3++) {
            for (int i4 = 0; i4 < 10; i4++) {
                ((TI6) this.h.get((i3 * 10) + i4)).draw(canvas2);
            }
        }
        bitmap.eraseColor(0);
        canvas.drawBitmap(this.d, 0.0f, 0.0f, (Paint) null);
        AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.WI6
            @Override // java.lang.Runnable
            public final void run() {
                this.a.f(bitmap);
            }
        });
    }

    public void c() {
        if (System.currentTimeMillis() - this.g <= 32 || this.i) {
            return;
        }
        this.g = System.currentTimeMillis();
        this.i = true;
        final Bitmap bitmap = this.c;
        this.a.i(new Runnable() { // from class: ir.nasim.VI6
            @Override // java.lang.Runnable
            public final void run() {
                this.a.g(bitmap);
            }
        });
    }

    Paint e() {
        if (this.b == null) {
            int i = this.k;
            this.b = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
            this.e = new Canvas(this.b);
            this.f = new Paint();
            this.h = new ArrayList(100);
            Paint paint = this.f;
            Bitmap bitmap = this.b;
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
            int i2 = this.k;
            int i3 = (int) (i2 / 10.0f);
            int iF = (int) ((i2 / AbstractC21455b.F(200.0f)) * 60.0f);
            for (int i4 = 0; i4 < 10; i4++) {
                for (int i5 = 0; i5 < 10; i5++) {
                    TI6 ti6 = new TI6();
                    int i6 = i3 * i4;
                    int i7 = i3 * i5;
                    ti6.setBounds(i6, i7 - AbstractC21455b.F(5.0f), i6 + i3 + AbstractC21455b.F(3.0f), i7 + i3 + AbstractC21455b.F(5.0f));
                    ti6.z = true;
                    ti6.d = (float[][]) Array.newInstance((Class<?>) Float.TYPE, TI6.C.length, iF * 2);
                    ti6.C(iF);
                    ti6.A(-1);
                    this.h.add(ti6);
                }
            }
            for (int i8 = 0; i8 < 10; i8++) {
                for (int i9 = 0; i9 < 10; i9++) {
                    ((TI6) this.h.get((i8 * 10) + i9)).draw(this.e);
                }
            }
            Paint paint2 = this.f;
            Bitmap bitmap2 = this.b;
            Shader.TileMode tileMode2 = Shader.TileMode.REPEAT;
            paint2.setShader(new BitmapShader(bitmap2, tileMode2, tileMode2));
            this.g = System.currentTimeMillis();
        }
        return this.f;
    }
}
