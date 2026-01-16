package ir.nasim;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: ir.nasim.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC12665f {
    public static final Drawable a(Context context, int i) {
        Drawable drawableB = AbstractC9594aE.b(context, i);
        if (drawableB != null) {
            return drawableB;
        }
        throw new IllegalStateException(("Invalid resource ID: " + i).toString());
    }

    public static final Drawable b(Resources resources, int i, Resources.Theme theme) {
        Drawable drawableF = VW5.f(resources, i, theme);
        if (drawableF != null) {
            return drawableF;
        }
        throw new IllegalStateException(("Invalid resource ID: " + i).toString());
    }

    public static final androidx.lifecycle.j c(Context context) {
        Object baseContext = context;
        while (!(baseContext instanceof InterfaceC18633oz3)) {
            if (!(baseContext instanceof ContextWrapper)) {
                return null;
            }
            baseContext = ((ContextWrapper) baseContext).getBaseContext();
        }
        return ((InterfaceC18633oz3) baseContext).getLifecycle();
    }

    public static final Drawable d(Context context, Resources resources, int i) throws XmlPullParserException, Resources.NotFoundException, IOException {
        XmlResourceParser xml = resources.getXml(i);
        int next = xml.next();
        while (next != 2 && next != 1) {
            next = xml.next();
        }
        if (next == 2) {
            return b(resources, i, context.getTheme());
        }
        throw new XmlPullParserException("No start tag found.");
    }

    public static final boolean e(Context context, String str) {
        return AbstractC4043Dl1.a(context, str) == 0;
    }
}
