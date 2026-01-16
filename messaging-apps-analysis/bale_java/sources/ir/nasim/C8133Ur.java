package ir.nasim;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: ir.nasim.Ur, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C8133Ur {
    private final XmlPullParser a;
    private int b;
    public final C21723u15 c;

    public C8133Ur(XmlPullParser xmlPullParser, int i) {
        this.a = xmlPullParser;
        this.b = i;
        this.c = new C21723u15();
    }

    private final void l(int i) {
        this.b = i | this.b;
    }

    public final float a(TypedArray typedArray, int i, float f) {
        float dimension = typedArray.getDimension(i, f);
        l(typedArray.getChangingConfigurations());
        return dimension;
    }

    public final float b(TypedArray typedArray, int i, float f) {
        float f2 = typedArray.getFloat(i, f);
        l(typedArray.getChangingConfigurations());
        return f2;
    }

    public final int c(TypedArray typedArray, int i, int i2) {
        int i3 = typedArray.getInt(i, i2);
        l(typedArray.getChangingConfigurations());
        return i3;
    }

    public final boolean d(TypedArray typedArray, String str, int i, boolean z) {
        boolean zA = AbstractC8958Xy7.a(typedArray, this.a, str, i, z);
        l(typedArray.getChangingConfigurations());
        return zA;
    }

    public final ColorStateList e(TypedArray typedArray, Resources.Theme theme, String str, int i) {
        ColorStateList colorStateListC = AbstractC8958Xy7.c(typedArray, this.a, theme, str, i);
        l(typedArray.getChangingConfigurations());
        return colorStateListC;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C8133Ur)) {
            return false;
        }
        C8133Ur c8133Ur = (C8133Ur) obj;
        return AbstractC13042fc3.d(this.a, c8133Ur.a) && this.b == c8133Ur.b;
    }

    public final F01 f(TypedArray typedArray, Resources.Theme theme, String str, int i, int i2) {
        F01 f01E = AbstractC8958Xy7.e(typedArray, this.a, theme, str, i, i2);
        l(typedArray.getChangingConfigurations());
        return f01E;
    }

    public final float g(TypedArray typedArray, String str, int i, float f) {
        float f2 = AbstractC8958Xy7.f(typedArray, this.a, str, i, f);
        l(typedArray.getChangingConfigurations());
        return f2;
    }

    public final int h(TypedArray typedArray, String str, int i, int i2) {
        int iG = AbstractC8958Xy7.g(typedArray, this.a, str, i, i2);
        l(typedArray.getChangingConfigurations());
        return iG;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + Integer.hashCode(this.b);
    }

    public final String i(TypedArray typedArray, int i) {
        String string = typedArray.getString(i);
        l(typedArray.getChangingConfigurations());
        return string;
    }

    public final XmlPullParser j() {
        return this.a;
    }

    public final TypedArray k(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        TypedArray typedArrayK = AbstractC8958Xy7.k(resources, theme, attributeSet, iArr);
        l(typedArrayK.getChangingConfigurations());
        return typedArrayK;
    }

    public String toString() {
        return "AndroidVectorParser(xmlParser=" + this.a + ", config=" + this.b + ')';
    }

    public /* synthetic */ C8133Ur(XmlPullParser xmlPullParser, int i, int i2, ED1 ed1) {
        this(xmlPullParser, (i2 & 2) != 0 ? 0 : i);
    }
}
