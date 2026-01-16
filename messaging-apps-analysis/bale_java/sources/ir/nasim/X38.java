package ir.nasim;

import android.content.Context;
import android.content.res.Resources;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import ir.nasim.designsystem.BackgroundPreviewViewGlide;
import java.io.File;
import java.util.List;

/* loaded from: classes6.dex */
public abstract class X38 {
    private static final List a = AbstractC10360bX0.p(0, 3, 6, 7, 8, 9);

    public static final String a(String str) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        return "patternBg" + str + ".webp";
    }

    public static final String b(String str) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        return "customWallpaper" + str + ".jpg";
    }

    public static final String c(String str) {
        AbstractC13042fc3.i(str, "uri");
        String strSubstring = str.substring(str.length() - 7, str.length() - 4);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final Drawable d(Context context, int i, int i2) throws Resources.NotFoundException {
        String strR2;
        AbstractC13042fc3.i(context, "context");
        try {
            strR2 = AbstractC5969Lp4.d().r2();
        } catch (Exception unused) {
            strR2 = null;
        }
        try {
            if (strR2 == null) {
                return f(context, i, i2);
            }
            if (!AbstractC20153rZ6.S(strR2, "local:", false, 2, null)) {
                if (!AbstractC20762sZ6.X(strR2, "customWallpaper", false, 2, null)) {
                    return f(context, i, i2);
                }
                File file = new File(strR2);
                if (file.exists()) {
                    return new BitmapDrawable(context.getResources(), V13.e(file.getAbsolutePath()));
                }
                String strC = c(strR2);
                A18 a18A = A18.c.a(context, i, i2, strC);
                if (a18A == null) {
                    return f(context, i, i2);
                }
                a18A.b(strC);
                return a18A.a();
            }
            int selectedBackgroundIndex = BackgroundPreviewViewGlide.getSelectedBackgroundIndex();
            if (!a.contains(Integer.valueOf(selectedBackgroundIndex))) {
                if (selectedBackgroundIndex == BackgroundPreviewViewGlide.getSize()) {
                    return f(context, i, i2);
                }
                Drawable drawable = context.getResources().getDrawable(BackgroundPreviewViewGlide.d(selectedBackgroundIndex));
                AbstractC13042fc3.f(drawable);
                return drawable;
            }
            if (C7183Qq.s().h("is_using_old_wallpapers", true)) {
                C7183Qq.s().g("is_using_old_wallpapers", false);
                AbstractC5969Lp4.d().b2(new File(i(), "customWallpaper000.jpg").getAbsolutePath());
                return f(context, i, i2);
            }
            if (selectedBackgroundIndex == BackgroundPreviewViewGlide.getSize()) {
                return f(context, i, i2);
            }
            Drawable drawable2 = context.getResources().getDrawable(BackgroundPreviewViewGlide.d(selectedBackgroundIndex));
            AbstractC13042fc3.f(drawable2);
            return drawable2;
        } catch (Exception unused2) {
            return f(context, i, i2);
        }
    }

    private static final File e() {
        File externalFilesDir = AbstractC5969Lp4.d().j2().getExternalFilesDir(null);
        if (externalFilesDir == null) {
            return null;
        }
        File file = new File(externalFilesDir.getAbsolutePath() + "/Bale/wallpapers/dark");
        file.mkdirs();
        return new File(file, "customWallpaper.jpg");
    }

    private static final Drawable f(Context context, int i, int i2) throws Resources.NotFoundException {
        Drawable drawable;
        File file = new File(i(), "customWallpaper000.jpg");
        if (file.exists()) {
            return new BitmapDrawable(context.getResources(), V13.e(file.getAbsolutePath()));
        }
        A18 a18A = A18.c.a(context, i, i2, "000");
        if (a18A != null) {
            a18A.b("000");
            drawable = a18A.a();
        } else {
            drawable = context.getResources().getDrawable(BackgroundPreviewViewGlide.d(0));
        }
        Drawable drawable2 = drawable;
        AbstractC13042fc3.f(drawable2);
        return drawable2;
    }

    private static final File g() {
        File externalFilesDir = AbstractC5969Lp4.d().j2().getExternalFilesDir(null);
        if (externalFilesDir == null) {
            return null;
        }
        File file = new File(externalFilesDir.getAbsolutePath() + "/Bale/wallpapers/light");
        file.mkdirs();
        return new File(file, "customWallpaper.jpg");
    }

    public static final File h() {
        File file;
        File externalFilesDir = AbstractC5969Lp4.d().j2().getExternalFilesDir(null);
        String absolutePath = externalFilesDir != null ? externalFilesDir.getAbsolutePath() : null;
        if (C5495Jo7.a.J2()) {
            file = new File(absolutePath + "/Bale/wallpapers/thumbnails/dark");
        } else {
            file = new File(absolutePath + "/Bale/wallpapers/thumbnails/light");
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static final File i() {
        File file;
        File externalFilesDir = AbstractC5969Lp4.d().j2().getExternalFilesDir(null);
        if (externalFilesDir == null) {
            return null;
        }
        String absolutePath = externalFilesDir.getAbsolutePath();
        if (C5495Jo7.a.J2()) {
            file = new File(absolutePath + "/Bale/wallpapers/dark");
        } else {
            file = new File(absolutePath + "/Bale/wallpapers/light");
        }
        file.mkdirs();
        return file;
    }

    public static final File j() {
        return C5495Jo7.a.J2() ? e() : g();
    }
}
