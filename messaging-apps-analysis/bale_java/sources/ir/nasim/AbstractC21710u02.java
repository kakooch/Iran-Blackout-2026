package ir.nasim;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: ir.nasim.u02, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC21710u02 {

    /* renamed from: ir.nasim.u02$a */
    static class a {
        static void a(Drawable drawable, Resources.Theme theme) {
            drawable.applyTheme(theme);
        }

        static boolean b(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        static ColorFilter c(Drawable drawable) {
            return drawable.getColorFilter();
        }

        static void d(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        static void e(Drawable drawable, float f, float f2) {
            drawable.setHotspot(f, f2);
        }

        static void f(Drawable drawable, int i, int i2, int i3, int i4) {
            drawable.setHotspotBounds(i, i2, i3, i4);
        }

        static void g(Drawable drawable, int i) {
            drawable.setTint(i);
        }

        static void h(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        static void i(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }
    }

    /* renamed from: ir.nasim.u02$b */
    static class b {
        static int a(Drawable drawable) {
            return drawable.getLayoutDirection();
        }

        static boolean b(Drawable drawable, int i) {
            return drawable.setLayoutDirection(i);
        }
    }

    public static void a(Drawable drawable) {
        drawable.clearColorFilter();
    }

    public static int b(Drawable drawable) {
        return b.a(drawable);
    }

    public static boolean c(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public static void d(Drawable drawable, boolean z) {
        drawable.setAutoMirrored(z);
    }

    public static void e(Drawable drawable, float f, float f2) {
        a.e(drawable, f, f2);
    }

    public static void f(Drawable drawable, int i, int i2, int i3, int i4) {
        a.f(drawable, i, i2, i3, i4);
    }

    public static boolean g(Drawable drawable, int i) {
        return b.b(drawable, i);
    }

    public static void h(Drawable drawable, int i) {
        a.g(drawable, i);
    }

    public static void i(Drawable drawable, ColorStateList colorStateList) {
        a.h(drawable, colorStateList);
    }

    public static void j(Drawable drawable, PorterDuff.Mode mode) {
        a.i(drawable, mode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Drawable k(Drawable drawable) {
        return drawable instanceof InterfaceC23836xb8 ? ((InterfaceC23836xb8) drawable).a() : drawable;
    }

    public static Drawable l(Drawable drawable) {
        return drawable;
    }
}
