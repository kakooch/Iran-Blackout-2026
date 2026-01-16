package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.C17660nL3;
import ir.nasim.C19409qI6;
import ir.nasim.C21892uJ3;
import ir.nasim.C24792zC6;
import ir.nasim.CB5;
import ir.nasim.RQ7;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class u {
    private static u i;
    private WeakHashMap a;
    private C24792zC6 b;
    private C19409qI6 c;
    private final WeakHashMap d = new WeakHashMap(0);
    private TypedValue e;
    private boolean f;
    private c g;
    private static final PorterDuff.Mode h = PorterDuff.Mode.SRC_IN;
    private static final a j = new a(6);

    private static class a extends C17660nL3 {
        public a(int i) {
            super(i);
        }

        private static int m(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter n(int i, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) d(Integer.valueOf(m(i, mode)));
        }

        PorterDuffColorFilter o(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) f(Integer.valueOf(m(i, mode)), porterDuffColorFilter);
        }
    }

    private interface b {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    public interface c {
        Drawable a(u uVar, Context context, int i);

        ColorStateList b(Context context, int i);

        boolean c(Context context, int i, Drawable drawable);

        PorterDuff.Mode d(int i);

        boolean e(Context context, int i, Drawable drawable);
    }

    private synchronized boolean a(Context context, long j2, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState == null) {
                return false;
            }
            C21892uJ3 c21892uJ3 = (C21892uJ3) this.d.get(context);
            if (c21892uJ3 == null) {
                c21892uJ3 = new C21892uJ3();
                this.d.put(context, c21892uJ3);
            }
            c21892uJ3.l(j2, new WeakReference(constantState));
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    private void b(Context context, int i2, ColorStateList colorStateList) {
        if (this.a == null) {
            this.a = new WeakHashMap();
        }
        C19409qI6 c19409qI6 = (C19409qI6) this.a.get(context);
        if (c19409qI6 == null) {
            c19409qI6 = new C19409qI6();
            this.a.put(context, c19409qI6);
        }
        c19409qI6.b(i2, colorStateList);
    }

    private void c(Context context) {
        if (this.f) {
            return;
        }
        this.f = true;
        Drawable drawableI = i(context, CB5.abc_vector_test);
        if (drawableI == null || !p(drawableI)) {
            this.f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    private static long d(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    private Drawable e(Context context, int i2) throws Resources.NotFoundException {
        if (this.e == null) {
            this.e = new TypedValue();
        }
        TypedValue typedValue = this.e;
        context.getResources().getValue(i2, typedValue, true);
        long jD = d(typedValue);
        Drawable drawableH = h(context, jD);
        if (drawableH != null) {
            return drawableH;
        }
        c cVar = this.g;
        Drawable drawableA = cVar == null ? null : cVar.a(this, context, i2);
        if (drawableA != null) {
            drawableA.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, jD, drawableA);
        }
        return drawableA;
    }

    private static PorterDuffColorFilter f(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return k(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized u g() {
        try {
            if (i == null) {
                u uVar = new u();
                i = uVar;
                o(uVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return i;
    }

    private synchronized Drawable h(Context context, long j2) {
        C21892uJ3 c21892uJ3 = (C21892uJ3) this.d.get(context);
        if (c21892uJ3 == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) c21892uJ3.f(j2);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            c21892uJ3.m(j2);
        }
        return null;
    }

    public static synchronized PorterDuffColorFilter k(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterN;
        a aVar = j;
        porterDuffColorFilterN = aVar.n(i2, mode);
        if (porterDuffColorFilterN == null) {
            porterDuffColorFilterN = new PorterDuffColorFilter(i2, mode);
            aVar.o(i2, mode, porterDuffColorFilterN);
        }
        return porterDuffColorFilterN;
    }

    private ColorStateList m(Context context, int i2) {
        C19409qI6 c19409qI6;
        WeakHashMap weakHashMap = this.a;
        if (weakHashMap == null || (c19409qI6 = (C19409qI6) weakHashMap.get(context)) == null) {
            return null;
        }
        return (ColorStateList) c19409qI6.f(i2);
    }

    private static void o(u uVar) {
    }

    private static boolean p(Drawable drawable) {
        return (drawable instanceof RQ7) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    private Drawable q(Context context, int i2) throws XmlPullParserException, Resources.NotFoundException, IOException {
        int next;
        C24792zC6 c24792zC6 = this.b;
        if (c24792zC6 == null || c24792zC6.isEmpty()) {
            return null;
        }
        C19409qI6 c19409qI6 = this.c;
        if (c19409qI6 != null) {
            String str = (String) c19409qI6.f(i2);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.b.get(str) == null)) {
                return null;
            }
        } else {
            this.c = new C19409qI6();
        }
        if (this.e == null) {
            this.e = new TypedValue();
        }
        TypedValue typedValue = this.e;
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        long jD = d(typedValue);
        Drawable drawableH = h(context, jD);
        if (drawableH != null) {
            return drawableH;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i2);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.c.b(i2, name);
                b bVar = (b) this.b.get(name);
                if (bVar != null) {
                    drawableH = bVar.a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableH != null) {
                    drawableH.setChangingConfigurations(typedValue.changingConfigurations);
                    a(context, jD, drawableH);
                }
            } catch (Exception e) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e);
            }
        }
        if (drawableH == null) {
            this.c.b(i2, "appcompat_skip_skip");
        }
        return drawableH;
    }

    private Drawable u(Context context, int i2, boolean z, Drawable drawable) {
        ColorStateList colorStateListL = l(context, i2);
        if (colorStateListL == null) {
            c cVar = this.g;
            if ((cVar == null || !cVar.e(context, i2, drawable)) && !w(context, i2, drawable) && z) {
                return null;
            }
            return drawable;
        }
        if (r.a(drawable)) {
            drawable = drawable.mutate();
        }
        Drawable drawableL = AbstractC21710u02.l(drawable);
        AbstractC21710u02.i(drawableL, colorStateListL);
        PorterDuff.Mode modeN = n(i2);
        if (modeN == null) {
            return drawableL;
        }
        AbstractC21710u02.j(drawableL, modeN);
        return drawableL;
    }

    static void v(Drawable drawable, A a2, int[] iArr) {
        int[] state = drawable.getState();
        if (r.a(drawable) && drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z = a2.d;
        if (z || a2.c) {
            drawable.setColorFilter(f(z ? a2.a : null, a2.c ? a2.b : h, iArr));
        } else {
            drawable.clearColorFilter();
        }
    }

    public synchronized Drawable i(Context context, int i2) {
        return j(context, i2, false);
    }

    synchronized Drawable j(Context context, int i2, boolean z) {
        Drawable drawableQ;
        try {
            c(context);
            drawableQ = q(context, i2);
            if (drawableQ == null) {
                drawableQ = e(context, i2);
            }
            if (drawableQ == null) {
                drawableQ = AbstractC4043Dl1.f(context, i2);
            }
            if (drawableQ != null) {
                drawableQ = u(context, i2, z, drawableQ);
            }
            if (drawableQ != null) {
                r.b(drawableQ);
            }
        } catch (Throwable th) {
            throw th;
        }
        return drawableQ;
    }

    synchronized ColorStateList l(Context context, int i2) {
        ColorStateList colorStateListM;
        colorStateListM = m(context, i2);
        if (colorStateListM == null) {
            c cVar = this.g;
            colorStateListM = cVar == null ? null : cVar.b(context, i2);
            if (colorStateListM != null) {
                b(context, i2, colorStateListM);
            }
        }
        return colorStateListM;
    }

    PorterDuff.Mode n(int i2) {
        c cVar = this.g;
        if (cVar == null) {
            return null;
        }
        return cVar.d(i2);
    }

    public synchronized void r(Context context) {
        C21892uJ3 c21892uJ3 = (C21892uJ3) this.d.get(context);
        if (c21892uJ3 != null) {
            c21892uJ3.c();
        }
    }

    synchronized Drawable s(Context context, E e, int i2) {
        try {
            Drawable drawableQ = q(context, i2);
            if (drawableQ == null) {
                drawableQ = e.a(i2);
            }
            if (drawableQ == null) {
                return null;
            }
            return u(context, i2, false, drawableQ);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void t(c cVar) {
        this.g = cVar;
    }

    boolean w(Context context, int i2, Drawable drawable) {
        c cVar = this.g;
        return cVar != null && cVar.c(context, i2, drawable);
    }
}
