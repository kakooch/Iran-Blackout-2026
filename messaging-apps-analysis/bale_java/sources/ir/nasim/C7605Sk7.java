package ir.nasim;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import ir.nasim.VW5;

/* renamed from: ir.nasim.Sk7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C7605Sk7 {
    public final ColorStateList a;
    public final ColorStateList b;
    public final ColorStateList c;
    public final String d;
    public final int e;
    public final int f;
    public final boolean g;
    public final float h;
    public final float i;
    public final float j;
    public final boolean k;
    public final float l;
    private ColorStateList m;
    private float n;
    private final int o;
    private boolean p = false;
    private Typeface q;

    /* renamed from: ir.nasim.Sk7$a */
    class a extends VW5.e {
        final /* synthetic */ AbstractC8078Uk7 a;

        a(AbstractC8078Uk7 abstractC8078Uk7) {
            this.a = abstractC8078Uk7;
        }

        @Override // ir.nasim.VW5.e
        /* renamed from: h */
        public void f(int i) {
            C7605Sk7.this.p = true;
            this.a.a(i);
        }

        @Override // ir.nasim.VW5.e
        /* renamed from: i */
        public void g(Typeface typeface) {
            C7605Sk7 c7605Sk7 = C7605Sk7.this;
            c7605Sk7.q = Typeface.create(typeface, c7605Sk7.e);
            C7605Sk7.this.p = true;
            this.a.b(C7605Sk7.this.q, false);
        }
    }

    /* renamed from: ir.nasim.Sk7$b */
    class b extends AbstractC8078Uk7 {
        final /* synthetic */ Context a;
        final /* synthetic */ TextPaint b;
        final /* synthetic */ AbstractC8078Uk7 c;

        b(Context context, TextPaint textPaint, AbstractC8078Uk7 abstractC8078Uk7) {
            this.a = context;
            this.b = textPaint;
            this.c = abstractC8078Uk7;
        }

        @Override // ir.nasim.AbstractC8078Uk7
        public void a(int i) {
            this.c.a(i);
        }

        @Override // ir.nasim.AbstractC8078Uk7
        public void b(Typeface typeface, boolean z) {
            C7605Sk7.this.p(this.a, this.b, typeface);
            this.c.b(typeface, z);
        }
    }

    public C7605Sk7(Context context, int i) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, GE5.TextAppearance);
        l(typedArrayObtainStyledAttributes.getDimension(GE5.TextAppearance_android_textSize, 0.0f));
        k(AbstractC9751aV3.a(context, typedArrayObtainStyledAttributes, GE5.TextAppearance_android_textColor));
        this.a = AbstractC9751aV3.a(context, typedArrayObtainStyledAttributes, GE5.TextAppearance_android_textColorHint);
        this.b = AbstractC9751aV3.a(context, typedArrayObtainStyledAttributes, GE5.TextAppearance_android_textColorLink);
        this.e = typedArrayObtainStyledAttributes.getInt(GE5.TextAppearance_android_textStyle, 0);
        this.f = typedArrayObtainStyledAttributes.getInt(GE5.TextAppearance_android_typeface, 1);
        int iF = AbstractC9751aV3.f(typedArrayObtainStyledAttributes, GE5.TextAppearance_fontFamily, GE5.TextAppearance_android_fontFamily);
        this.o = typedArrayObtainStyledAttributes.getResourceId(iF, 0);
        this.d = typedArrayObtainStyledAttributes.getString(iF);
        this.g = typedArrayObtainStyledAttributes.getBoolean(GE5.TextAppearance_textAllCaps, false);
        this.c = AbstractC9751aV3.a(context, typedArrayObtainStyledAttributes, GE5.TextAppearance_android_shadowColor);
        this.h = typedArrayObtainStyledAttributes.getFloat(GE5.TextAppearance_android_shadowDx, 0.0f);
        this.i = typedArrayObtainStyledAttributes.getFloat(GE5.TextAppearance_android_shadowDy, 0.0f);
        this.j = typedArrayObtainStyledAttributes.getFloat(GE5.TextAppearance_android_shadowRadius, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i, GE5.MaterialTextAppearance);
        this.k = typedArrayObtainStyledAttributes2.hasValue(GE5.MaterialTextAppearance_android_letterSpacing);
        this.l = typedArrayObtainStyledAttributes2.getFloat(GE5.MaterialTextAppearance_android_letterSpacing, 0.0f);
        typedArrayObtainStyledAttributes2.recycle();
    }

    private void d() {
        String str;
        if (this.q == null && (str = this.d) != null) {
            this.q = Typeface.create(str, this.e);
        }
        if (this.q == null) {
            int i = this.f;
            if (i == 1) {
                this.q = Typeface.SANS_SERIF;
            } else if (i == 2) {
                this.q = Typeface.SERIF;
            } else if (i != 3) {
                this.q = Typeface.DEFAULT;
            } else {
                this.q = Typeface.MONOSPACE;
            }
            this.q = Typeface.create(this.q, this.e);
        }
    }

    private boolean m(Context context) {
        if (AbstractC7844Tk7.a()) {
            return true;
        }
        int i = this.o;
        return (i != 0 ? VW5.c(context, i) : null) != null;
    }

    public Typeface e() {
        d();
        return this.q;
    }

    public Typeface f(Context context) {
        if (this.p) {
            return this.q;
        }
        if (!context.isRestricted()) {
            try {
                Typeface typefaceH = VW5.h(context, this.o);
                this.q = typefaceH;
                if (typefaceH != null) {
                    this.q = Typeface.create(typefaceH, this.e);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e) {
                Log.d("TextAppearance", "Error loading font " + this.d, e);
            }
        }
        d();
        this.p = true;
        return this.q;
    }

    public void g(Context context, TextPaint textPaint, AbstractC8078Uk7 abstractC8078Uk7) {
        p(context, textPaint, e());
        h(context, new b(context, textPaint, abstractC8078Uk7));
    }

    public void h(Context context, AbstractC8078Uk7 abstractC8078Uk7) {
        if (m(context)) {
            f(context);
        } else {
            d();
        }
        int i = this.o;
        if (i == 0) {
            this.p = true;
        }
        if (this.p) {
            abstractC8078Uk7.b(this.q, true);
            return;
        }
        try {
            VW5.j(context, i, new a(abstractC8078Uk7), null);
        } catch (Resources.NotFoundException unused) {
            this.p = true;
            abstractC8078Uk7.a(1);
        } catch (Exception e) {
            Log.d("TextAppearance", "Error loading font " + this.d, e);
            this.p = true;
            abstractC8078Uk7.a(-3);
        }
    }

    public ColorStateList i() {
        return this.m;
    }

    public float j() {
        return this.n;
    }

    public void k(ColorStateList colorStateList) {
        this.m = colorStateList;
    }

    public void l(float f) {
        this.n = f;
    }

    public void n(Context context, TextPaint textPaint, AbstractC8078Uk7 abstractC8078Uk7) {
        o(context, textPaint, abstractC8078Uk7);
        ColorStateList colorStateList = this.m;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f = this.j;
        float f2 = this.h;
        float f3 = this.i;
        ColorStateList colorStateList2 = this.c;
        textPaint.setShadowLayer(f, f2, f3, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void o(Context context, TextPaint textPaint, AbstractC8078Uk7 abstractC8078Uk7) {
        if (m(context)) {
            p(context, textPaint, f(context));
        } else {
            g(context, textPaint, abstractC8078Uk7);
        }
    }

    public void p(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface typefaceA = AbstractC22295uz7.a(context, typeface);
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        textPaint.setTypeface(typeface);
        int i = this.e & (~typeface.getStyle());
        textPaint.setFakeBoldText((i & 1) != 0);
        textPaint.setTextSkewX((i & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.n);
        if (this.k) {
            textPaint.setLetterSpacing(this.l);
        }
    }
}
