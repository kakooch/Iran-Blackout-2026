package ir.nasim;

import android.content.Context;
import android.content.res.Resources;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class A18 {
    public static final a c = new a(null);
    public static final int d = 8;
    private final Context a;
    private final Bitmap b;

    public static final class a {
        private a() {
        }

        public final A18 a(Context context, int i, int i2, String str) {
            Object next;
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(str, ParameterNames.TAG);
            Iterator it = F15.a().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (AbstractC13042fc3.d(((E15) next).f(), str)) {
                    break;
                }
            }
            E15 e15 = (E15) next;
            if (e15 == null) {
                return null;
            }
            return new A18(context, i, i2, e15.a(), e15.e(), e15.g(), e15.b(), e15.c(), e15.d());
        }

        public final void b(Context context, int i, int i2) {
            AbstractC13042fc3.i(context, "context");
            for (E15 e15 : F15.a()) {
                String strF = e15.f();
                if (!new File(X38.h(), X38.a(strF)).exists()) {
                    new A18(context, i, i2, e15.a(), e15.e(), e15.g(), e15.b(), e15.c(), e15.d()).c(strF);
                }
            }
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public A18(Context context, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        GradientDrawable.Orientation orientation;
        GradientDrawable.Orientation orientation2;
        float f;
        AbstractC13042fc3.i(context, "context");
        this.a = context;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        List listS = AbstractC10360bX0.s(new int[]{i3, c5495Jo7.y0(i3, 0)}, new int[]{i4, c5495Jo7.y0(i4, 0)}, new int[]{i5, c5495Jo7.y0(i5, 0)}, new int[]{i6, c5495Jo7.y0(i6, 0)});
        ArrayList arrayList = new ArrayList();
        for (int i9 = 0; i9 < 4; i9++) {
            float f2 = 1.8f;
            float f3 = 0.0f;
            if (i9 != 0) {
                f = 1.0f;
                if (i9 == 1) {
                    orientation2 = GradientDrawable.Orientation.BR_TL;
                    f2 = 1.65f;
                    f3 = 1.0f;
                } else if (i9 == 2) {
                    f3 = 1.5f;
                    f2 = 1.35f;
                    orientation2 = GradientDrawable.Orientation.TR_BL;
                    f = 0.0f;
                } else if (i9 != 3) {
                    orientation = GradientDrawable.Orientation.TL_BR;
                } else {
                    f3 = -0.3f;
                    orientation2 = GradientDrawable.Orientation.BL_TR;
                    f2 = 1.3f;
                }
                GradientDrawable gradientDrawable = new GradientDrawable(orientation2, (int[]) listS.get(i9));
                gradientDrawable.setGradientType(1);
                gradientDrawable.setGradientRadius(i * f2);
                gradientDrawable.setGradientCenter(f3, f);
                arrayList.add(gradientDrawable);
            } else {
                orientation = GradientDrawable.Orientation.TL_BR;
            }
            orientation2 = orientation;
            f = 0.0f;
            GradientDrawable gradientDrawable2 = new GradientDrawable(orientation2, (int[]) listS.get(i9));
            gradientDrawable2.setGradientType(1);
            gradientDrawable2.setGradientRadius(i * f2);
            gradientDrawable2.setGradientCenter(f3, f);
            arrayList.add(gradientDrawable2);
        }
        LayerDrawable layerDrawable = new LayerDrawable((Drawable[]) arrayList.toArray(new GradientDrawable[0]));
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        this.b = bitmapCreateBitmap;
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        layerDrawable.setBounds(0, 0, i, i2);
        layerDrawable.draw(canvas);
        Drawable drawableF = AbstractC4043Dl1.f(this.a, i7);
        if (drawableF != null) {
            C4319Ep7 c4319Ep7 = new C4319Ep7(drawableF, Shader.TileMode.REPEAT);
            if (C5495Jo7.a.J2()) {
                c4319Ep7.setAlpha(90);
                c4319Ep7.setColorFilter(new PorterDuffColorFilter(AbstractC4043Dl1.c(this.a, i8), PorterDuff.Mode.SRC_IN));
            } else {
                c4319Ep7.setAlpha(80);
            }
            canvas.drawPaint(c4319Ep7.b());
        }
    }

    public final BitmapDrawable a() {
        Bitmap bitmap = this.b;
        Resources resources = this.a.getResources();
        AbstractC13042fc3.h(resources, "getResources(...)");
        return new BitmapDrawable(resources, bitmap);
    }

    public final void b(String str) {
        String name;
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        File fileI = X38.i();
        if (fileI == null) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(fileI.getAbsolutePath(), X38.b(str)));
            if (Build.VERSION.SDK_INT >= 30) {
                this.b.compress(Bitmap.CompressFormat.WEBP_LOSSLESS, 35, fileOutputStream);
            } else {
                this.b.compress(Bitmap.CompressFormat.WEBP, 35, fileOutputStream);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            if (A18.class.isAnonymousClass()) {
                name = A18.class.getName();
                int length = name.length();
                AbstractC13042fc3.f(name);
                if (length > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = A18.class.getSimpleName();
                int length2 = name.length();
                AbstractC13042fc3.f(name);
                if (length2 > 23) {
                    name = name.substring(0, 23);
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            }
            C19406qI3.d(name, e);
        }
    }

    public final void c(String str) throws IOException {
        String name;
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(X38.h(), X38.a(str)));
            if (Build.VERSION.SDK_INT >= 30) {
                this.b.compress(Bitmap.CompressFormat.WEBP_LOSSLESS, 60, fileOutputStream);
            } else {
                this.b.compress(Bitmap.CompressFormat.WEBP, 60, fileOutputStream);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            if (A18.class.isAnonymousClass()) {
                name = A18.class.getName();
                int length = name.length();
                AbstractC13042fc3.f(name);
                if (length > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = A18.class.getSimpleName();
                int length2 = name.length();
                AbstractC13042fc3.f(name);
                if (length2 > 23) {
                    name = name.substring(0, 23);
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            }
            C19406qI3.d(name, e);
        }
    }
}
