package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Movie;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.uk4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C22146uk4 extends Drawable implements Animatable {
    public static final a v = new a(null);
    private final Movie a;
    private final Bitmap.Config b;
    private final EnumC14254hc6 c;
    private Canvas h;
    private Bitmap i;
    private float l;
    private float m;
    private boolean n;
    private long o;
    private long p;
    private int r;
    private Picture s;
    private boolean u;
    private final Paint d = new Paint(3);
    private final List e = new ArrayList();
    private final Rect f = new Rect();
    private final Rect g = new Rect();
    private float j = 1.0f;
    private float k = 1.0f;
    private int q = -1;
    private EnumC20217re5 t = EnumC20217re5.a;

    /* renamed from: ir.nasim.uk4$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C22146uk4(Movie movie, Bitmap.Config config, EnumC14254hc6 enumC14254hc6) {
        this.a = movie;
        this.b = config;
        this.c = enumC14254hc6;
        if (!(!AbstractC14485i.b(config))) {
            throw new IllegalArgumentException("Bitmap config must not be hardware.".toString());
        }
    }

    private final void a(Canvas canvas) {
        Canvas canvas2 = this.h;
        Bitmap bitmap = this.i;
        if (canvas2 == null || bitmap == null) {
            return;
        }
        canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
        int iSave = canvas2.save();
        try {
            float f = this.j;
            canvas2.scale(f, f);
            this.a.draw(canvas2, 0.0f, 0.0f, this.d);
            Picture picture = this.s;
            if (picture != null) {
                picture.draw(canvas2);
            }
            canvas2.restoreToCount(iSave);
            int iSave2 = canvas.save();
            try {
                canvas.translate(this.l, this.m);
                float f2 = this.k;
                canvas.scale(f2, f2);
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.d);
            } finally {
                canvas.restoreToCount(iSave2);
            }
        } catch (Throwable th) {
            canvas2.restoreToCount(iSave);
            throw th;
        }
    }

    private final Rect b(Canvas canvas) {
        Rect rect = this.g;
        rect.set(0, 0, canvas.getWidth(), canvas.getHeight());
        return rect;
    }

    private final void f(Rect rect) {
        if (AbstractC13042fc3.d(this.f, rect)) {
            return;
        }
        this.f.set(rect);
        int iWidth = rect.width();
        int iHeight = rect.height();
        int iWidth2 = this.a.width();
        int iHeight2 = this.a.height();
        if (iWidth2 <= 0 || iHeight2 <= 0) {
            return;
        }
        double dC = C21144tB1.c(iWidth2, iHeight2, iWidth, iHeight, this.c);
        if (!this.u) {
            dC = AbstractC23053wG5.g(dC, 1.0d);
        }
        float f = (float) dC;
        this.j = f;
        int i = (int) (iWidth2 * f);
        int i2 = (int) (f * iHeight2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, this.b);
        Bitmap bitmap = this.i;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.i = bitmapCreateBitmap;
        this.h = new Canvas(bitmapCreateBitmap);
        if (this.u) {
            this.k = 1.0f;
            this.l = 0.0f;
            this.m = 0.0f;
        } else {
            float fC = (float) C21144tB1.c(i, i2, iWidth, iHeight, this.c);
            this.k = fC;
            float f2 = iWidth - (i * fC);
            float f3 = 2;
            this.l = rect.left + (f2 / f3);
            this.m = rect.top + ((iHeight - (fC * i2)) / f3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean g() {
        boolean z;
        int iDuration = this.a.duration();
        if (iDuration == 0) {
            z = 0;
        } else {
            if (this.n) {
                this.p = SystemClock.uptimeMillis();
            }
            int i = (int) (this.p - this.o);
            int i2 = i / iDuration;
            this.r = i2;
            int i3 = this.q;
            i = (i3 == -1 || i2 <= i3) ? 1 : 0;
            if (i != 0) {
                iDuration = i - (i2 * iDuration);
            }
            int i4 = i;
            i = iDuration;
            z = i4;
        }
        this.a.setTime(i);
        return z;
    }

    public void c(AbstractC16198ks abstractC16198ks) {
        this.e.add(abstractC16198ks);
    }

    public final void d(InterfaceC19754qt interfaceC19754qt) {
        if (interfaceC19754qt == null || this.a.width() <= 0 || this.a.height() <= 0) {
            this.s = null;
            this.t = EnumC20217re5.a;
            this.u = false;
        } else {
            Picture picture = new Picture();
            this.t = interfaceC19754qt.a(picture.beginRecording(this.a.width(), this.a.height()));
            picture.endRecording();
            this.s = picture;
            this.u = true;
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean zG = g();
        if (this.u) {
            f(b(canvas));
            int iSave = canvas.save();
            try {
                float f = 1 / this.j;
                canvas.scale(f, f);
                a(canvas);
            } finally {
                canvas.restoreToCount(iSave);
            }
        } else {
            f(getBounds());
            a(canvas);
        }
        if (this.n && zG) {
            invalidateSelf();
        } else {
            stop();
        }
    }

    public final void e(int i) {
        if (i >= -1) {
            this.q = i;
            return;
        }
        throw new IllegalArgumentException(("Invalid repeatCount: " + i).toString());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.a.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.a.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        EnumC20217re5 enumC20217re5;
        return (this.d.getAlpha() == 255 && ((enumC20217re5 = this.t) == EnumC20217re5.c || (enumC20217re5 == EnumC20217re5.a && this.a.isOpaque()))) ? -1 : -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.n;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i >= 0 && i < 256) {
            this.d.setAlpha(i);
            return;
        }
        throw new IllegalArgumentException(("Invalid alpha: " + i).toString());
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.d.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.n) {
            return;
        }
        this.n = true;
        this.r = 0;
        this.o = SystemClock.uptimeMillis();
        List list = this.e;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((AbstractC16198ks) list.get(i)).b(this);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.n) {
            this.n = false;
            List list = this.e;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ((AbstractC16198ks) list.get(i)).a(this);
            }
        }
    }
}
