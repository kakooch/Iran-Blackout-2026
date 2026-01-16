package ir.nasim;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.TypedValue;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.ResourceResolutionException;
import ir.nasim.C13336g33;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes2.dex */
public abstract class FV4 {
    private static final Y03 a(CharSequence charSequence, Resources resources, int i) {
        try {
            return X23.a(Y03.a, resources, i);
        } catch (Exception e) {
            throw new ResourceResolutionException("Error attempting to load resource: " + ((Object) charSequence), e);
        }
    }

    private static final C12700f33 b(Resources.Theme theme, Resources resources, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) throws XmlPullParserException, Resources.NotFoundException, IOException {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(21855625, i3, -1, "androidx.compose.ui.res.loadVectorResource (PainterResources.android.kt:89)");
        }
        C13336g33 c13336g33 = (C13336g33) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.h());
        C13336g33.b bVar = new C13336g33.b(theme, i);
        C13336g33.a aVarB = c13336g33.b(bVar);
        if (aVarB == null) {
            XmlResourceParser xml = resources.getXml(i);
            if (!AbstractC13042fc3.d(AbstractC19593qc8.j(xml).getName(), "vector")) {
                throw new IllegalArgumentException("Only VectorDrawables and rasterized asset types are supported ex. PNG, JPG, WEBP");
            }
            aVarB = XQ7.a(theme, resources, xml, i2);
            c13336g33.d(bVar, aVarB);
        }
        C12700f33 c12700f33B = aVarB.b();
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return c12700f33B;
    }

    public static final EV4 c(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        EV4 bitmapPainter;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(473971343, i2, -1, "androidx.compose.ui.res.painterResource (PainterResources.android.kt:56)");
        }
        Context context = (Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g());
        interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.f());
        Resources resources = context.getResources();
        TypedValue typedValueB = ((NW5) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.i())).b(resources, i);
        CharSequence charSequence = typedValueB.string;
        boolean z = true;
        if (charSequence == null || !AbstractC20762sZ6.c0(charSequence, ".xml", false, 2, null)) {
            interfaceC22053ub1.W(-802887899);
            Object theme = context.getTheme();
            boolean zV = interfaceC22053ub1.V(charSequence);
            if ((((i2 & 14) ^ 6) <= 4 || !interfaceC22053ub1.e(i)) && (i2 & 6) != 4) {
                z = false;
            }
            boolean zV2 = zV | z | interfaceC22053ub1.V(theme);
            Object objB = interfaceC22053ub1.B();
            if (zV2 || objB == InterfaceC22053ub1.a.a()) {
                objB = a(charSequence, resources, i);
                interfaceC22053ub1.s(objB);
            }
            bitmapPainter = new BitmapPainter((Y03) objB, 0L, 0L, 6, null);
            interfaceC22053ub1.Q();
        } else {
            interfaceC22053ub1.W(-803043333);
            bitmapPainter = VQ7.g(b(context.getTheme(), resources, i, typedValueB.changingConfigurations, interfaceC22053ub1, (i2 << 6) & 896), interfaceC22053ub1, 0);
            interfaceC22053ub1.Q();
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return bitmapPainter;
    }
}
