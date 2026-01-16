package ir.nasim;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* renamed from: ir.nasim.x02, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC23486x02 {
    private static volatile boolean a = true;

    public static Drawable a(Context context, int i, Resources.Theme theme) {
        return c(context, context, i, theme);
    }

    public static Drawable b(Context context, Context context2, int i) {
        return c(context, context2, i, null);
    }

    private static Drawable c(Context context, Context context2, int i, Resources.Theme theme) {
        try {
            if (a) {
                return e(context2, i, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                throw e;
            }
            return AbstractC4043Dl1.f(context2, i);
        } catch (NoClassDefFoundError unused2) {
            a = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return d(context2, i, theme);
    }

    private static Drawable d(Context context, int i, Resources.Theme theme) {
        return VW5.f(context.getResources(), i, theme);
    }

    private static Drawable e(Context context, int i, Resources.Theme theme) {
        if (theme != null) {
            C16731lm1 c16731lm1 = new C16731lm1(context, theme);
            c16731lm1.a(theme.getResources().getConfiguration());
            context = c16731lm1;
        }
        return AbstractC9594aE.b(context, i);
    }
}
