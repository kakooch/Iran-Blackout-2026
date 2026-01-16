package ir.nasim;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.StateSet;

/* renamed from: ir.nasim.Eo7, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC4310Eo7 {
    private static final Paint a = new Paint(1);
    private static final Drawable[] b = new Drawable[8];
    private static final int[] c = {0, 0, 0, AbstractC19954rD5.giftpacket_attachment_animation, 0, 0, 0, 0};

    public static Drawable b(int i) {
        return c(i, true);
    }

    public static Drawable c(int i, boolean z) {
        a aVar;
        if (z) {
            a.setColor(-1);
            aVar = new a();
        } else {
            aVar = null;
        }
        return new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{i}), null, aVar);
    }

    public static Drawable d(int i, int i2) {
        float f = i;
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{f, f, f, f, f, f, f, f}, null, null));
        shapeDrawable.getPaint().setColor(i2);
        return shapeDrawable;
    }

    public static Drawable e(int i, int i2) {
        Drawable colorDrawable;
        if (i2 == 1) {
            a.setColor(-1);
            colorDrawable = new b();
        } else {
            colorDrawable = i2 == 2 ? new ColorDrawable(-1) : null;
        }
        return new RippleDrawable(new ColorStateList(new int[][]{StateSet.WILD_CARD}, new int[]{i}), null, colorDrawable);
    }

    public static Drawable f(int i, int i2, int i3) {
        OvalShape ovalShape = new OvalShape();
        float f = i;
        ovalShape.resize(f, f);
        ShapeDrawable shapeDrawable = new ShapeDrawable(ovalShape);
        shapeDrawable.getPaint().setColor(i2);
        ShapeDrawable shapeDrawable2 = new ShapeDrawable(ovalShape);
        shapeDrawable2.getPaint().setColor(-1);
        return new RippleDrawable(new ColorStateList(new int[][]{StateSet.WILD_CARD}, new int[]{i3}), shapeDrawable, shapeDrawable2);
    }

    public static Drawable g() {
        Drawable drawableD = d(AbstractC7426Rr.z(3.0f), -1);
        int[][] iArr = {StateSet.WILD_CARD};
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        return new RippleDrawable(new ColorStateList(iArr, new int[]{c5495Jo7.y0(c5495Jo7.n0(), 27)}), null, drawableD);
    }

    public static Drawable h(float f) {
        Drawable drawableD = d(AbstractC7426Rr.z(f), -1);
        int[][] iArr = {StateSet.WILD_CARD};
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        return new RippleDrawable(new ColorStateList(iArr, new int[]{c5495Jo7.y0(c5495Jo7.n0(), 27)}), null, drawableD);
    }

    public static Drawable i(int i, int i2) {
        return j(i, i2, 3);
    }

    public static Drawable j(int i, int i2, int i3) {
        float fZ = AbstractC7426Rr.z(i3);
        RoundRectShape roundRectShape = new RoundRectShape(new float[]{fZ, fZ, fZ, fZ, fZ, fZ, fZ, fZ}, null, null);
        ShapeDrawable shapeDrawable = new ShapeDrawable(roundRectShape);
        shapeDrawable.getPaint().setColor(i);
        ShapeDrawable shapeDrawable2 = new ShapeDrawable(roundRectShape);
        shapeDrawable2.getPaint().setColor(-1);
        return new RippleDrawable(new ColorStateList(new int[][]{StateSet.WILD_CARD}, new int[]{i2}), shapeDrawable, shapeDrawable2);
    }

    public static Drawable k(boolean z) {
        if (!z) {
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            return e(c5495Jo7.y0(c5495Jo7.j2(), 6), 2);
        }
        ColorDrawable colorDrawable = new ColorDrawable(-1);
        int[][] iArr = {StateSet.WILD_CARD};
        C5495Jo7 c5495Jo72 = C5495Jo7.a;
        return new RippleDrawable(new ColorStateList(iArr, new int[]{c5495Jo72.y0(c5495Jo72.j2(), 6)}), new ColorDrawable(c5495Jo72.f0()), colorDrawable);
    }

    /* renamed from: ir.nasim.Eo7$a */
    class a extends Drawable {
        a() {
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Rect bounds = getBounds();
            canvas.drawCircle(bounds.centerX(), bounds.centerY(), C22078ud6.a(18.0f), AbstractC4310Eo7.a);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    /* renamed from: ir.nasim.Eo7$b */
    class b extends Drawable {
        b() {
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Rect bounds = getBounds();
            canvas.drawCircle(bounds.centerX(), bounds.centerY(), AbstractC7426Rr.z(18.0f), AbstractC4310Eo7.a);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }
    }
}
