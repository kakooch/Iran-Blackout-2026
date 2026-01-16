package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import ir.nasim.AbstractC9594aE;
import ir.nasim.VW5;

/* loaded from: classes.dex */
public class C {
    private final Context a;
    private final TypedArray b;
    private TypedValue c;

    private C(Context context, TypedArray typedArray) {
        this.a = context;
        this.b = typedArray;
    }

    public static C t(Context context, int i, int[] iArr) {
        return new C(context, context.obtainStyledAttributes(i, iArr));
    }

    public static C u(Context context, AttributeSet attributeSet, int[] iArr) {
        return new C(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static C v(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new C(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public boolean a(int i, boolean z) {
        return this.b.getBoolean(i, z);
    }

    public int b(int i, int i2) {
        return this.b.getColor(i, i2);
    }

    public ColorStateList c(int i) {
        int resourceId;
        ColorStateList colorStateListA;
        return (!this.b.hasValue(i) || (resourceId = this.b.getResourceId(i, 0)) == 0 || (colorStateListA = AbstractC9594aE.a(this.a, resourceId)) == null) ? this.b.getColorStateList(i) : colorStateListA;
    }

    public float d(int i, float f) {
        return this.b.getDimension(i, f);
    }

    public int e(int i, int i2) {
        return this.b.getDimensionPixelOffset(i, i2);
    }

    public int f(int i, int i2) {
        return this.b.getDimensionPixelSize(i, i2);
    }

    public Drawable g(int i) {
        int resourceId;
        return (!this.b.hasValue(i) || (resourceId = this.b.getResourceId(i, 0)) == 0) ? this.b.getDrawable(i) : AbstractC9594aE.b(this.a, resourceId);
    }

    public Drawable h(int i) {
        int resourceId;
        if (!this.b.hasValue(i) || (resourceId = this.b.getResourceId(i, 0)) == 0) {
            return null;
        }
        return g.b().d(this.a, resourceId, true);
    }

    public float i(int i, float f) {
        return this.b.getFloat(i, f);
    }

    public Typeface j(int i, int i2, VW5.e eVar) {
        int resourceId = this.b.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.c == null) {
            this.c = new TypedValue();
        }
        return VW5.i(this.a, resourceId, this.c, i2, eVar);
    }

    public int k(int i, int i2) {
        return this.b.getInt(i, i2);
    }

    public int l(int i, int i2) {
        return this.b.getInteger(i, i2);
    }

    public int m(int i, int i2) {
        return this.b.getLayoutDimension(i, i2);
    }

    public int n(int i, int i2) {
        return this.b.getResourceId(i, i2);
    }

    public String o(int i) {
        return this.b.getString(i);
    }

    public CharSequence p(int i) {
        return this.b.getText(i);
    }

    public CharSequence[] q(int i) {
        return this.b.getTextArray(i);
    }

    public TypedArray r() {
        return this.b;
    }

    public boolean s(int i) {
        return this.b.hasValue(i);
    }

    public void w() {
        this.b.recycle();
    }
}
