package ir.nasim;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import ir.nasim.AbstractC14502i15;
import ir.nasim.C12700f33;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: ir.nasim.qc8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC19593qc8 {
    private static final int a = 0;

    public static final C12700f33.a a(C8133Ur c8133Ur, Resources resources, Resources.Theme theme, AttributeSet attributeSet) throws XmlPullParserException {
        long jI;
        int iZ;
        ColorStateList colorStateListE;
        C8367Vr c8367Vr = C8367Vr.a;
        TypedArray typedArrayK = c8133Ur.k(resources, theme, attributeSet, c8367Vr.F());
        boolean zD = c8133Ur.d(typedArrayK, "autoMirrored", c8367Vr.a(), false);
        float fG = c8133Ur.g(typedArrayK, "viewportWidth", c8367Vr.H(), 0.0f);
        float fG2 = c8133Ur.g(typedArrayK, "viewportHeight", c8367Vr.G(), 0.0f);
        if (fG <= 0.0f) {
            throw new XmlPullParserException(typedArrayK.getPositionDescription() + "<VectorGraphic> tag requires viewportWidth > 0");
        }
        if (fG2 <= 0.0f) {
            throw new XmlPullParserException(typedArrayK.getPositionDescription() + "<VectorGraphic> tag requires viewportHeight > 0");
        }
        float fA = c8133Ur.a(typedArrayK, c8367Vr.I(), 0.0f);
        float fA2 = c8133Ur.a(typedArrayK, c8367Vr.n(), 0.0f);
        if (typedArrayK.hasValue(c8367Vr.D())) {
            TypedValue typedValue = new TypedValue();
            typedArrayK.getValue(c8367Vr.D(), typedValue);
            jI = (typedValue.type == 2 || (colorStateListE = c8133Ur.e(typedArrayK, theme, "tint", c8367Vr.D())) == null) ? C24381yX0.b.i() : DX0.b(colorStateListE.getDefaultColor());
        } else {
            jI = C24381yX0.b.i();
        }
        long j = jI;
        int iC = c8133Ur.c(typedArrayK, c8367Vr.E(), -1);
        if (iC == -1) {
            iZ = AbstractC7094Qg0.a.z();
        } else if (iC == 3) {
            iZ = AbstractC7094Qg0.a.B();
        } else if (iC == 5) {
            iZ = AbstractC7094Qg0.a.z();
        } else if (iC != 9) {
            switch (iC) {
                case 14:
                    iZ = AbstractC7094Qg0.a.q();
                    break;
                case 15:
                    iZ = AbstractC7094Qg0.a.v();
                    break;
                case 16:
                    iZ = AbstractC7094Qg0.a.t();
                    break;
                default:
                    iZ = AbstractC7094Qg0.a.z();
                    break;
            }
        } else {
            iZ = AbstractC7094Qg0.a.y();
        }
        int i = iZ;
        float fQ = C17784nZ1.q(fA / resources.getDisplayMetrics().density);
        float fQ2 = C17784nZ1.q(fA2 / resources.getDisplayMetrics().density);
        typedArrayK.recycle();
        return new C12700f33.a(null, fQ, fQ2, fG, fG2, j, i, zD, 1, null);
    }

    private static final int b(int i, int i2) {
        return i != 0 ? i != 1 ? i != 2 ? i2 : AbstractC24405yZ6.a.c() : AbstractC24405yZ6.a.b() : AbstractC24405yZ6.a.a();
    }

    private static final int c(int i, int i2) {
        return i != 0 ? i != 1 ? i != 2 ? i2 : AZ6.a.a() : AZ6.a.c() : AZ6.a.b();
    }

    public static final boolean d(XmlPullParser xmlPullParser) {
        if (xmlPullParser.getEventType() != 1) {
            return xmlPullParser.getDepth() < 1 && xmlPullParser.getEventType() == 3;
        }
        return true;
    }

    private static final AbstractC12520el0 e(F01 f01) {
        if (!f01.i()) {
            return null;
        }
        Shader shaderF = f01.f();
        return shaderF != null ? AbstractC14340hl0.a(shaderF) : new CH6(DX0.b(f01.e()), null);
    }

    public static final void f(C8133Ur c8133Ur, Resources resources, Resources.Theme theme, AttributeSet attributeSet, C12700f33.a aVar) {
        C8367Vr c8367Vr = C8367Vr.a;
        TypedArray typedArrayK = c8133Ur.k(resources, theme, attributeSet, c8367Vr.b());
        String strI = c8133Ur.i(typedArrayK, c8367Vr.c());
        if (strI == null) {
            strI = "";
        }
        String str = strI;
        String strI2 = c8133Ur.i(typedArrayK, c8367Vr.d());
        List listD = strI2 == null ? TQ7.d() : C21723u15.b(c8133Ur.c, strI2, null, 2, null);
        typedArrayK.recycle();
        aVar.a((254 & 1) != 0 ? "" : str, (254 & 2) != 0 ? 0.0f : 0.0f, (254 & 4) != 0 ? 0.0f : 0.0f, (254 & 8) != 0 ? 0.0f : 0.0f, (254 & 16) != 0 ? 1.0f : 0.0f, (254 & 32) == 0 ? 0.0f : 1.0f, (254 & 64) != 0 ? 0.0f : 0.0f, (254 & 128) == 0 ? 0.0f : 0.0f, (254 & 256) != 0 ? TQ7.d() : listD);
    }

    public static final int g(C8133Ur c8133Ur, Resources resources, AttributeSet attributeSet, Resources.Theme theme, C12700f33.a aVar, int i) throws XmlPullParserException {
        int eventType = c8133Ur.j().getEventType();
        if (eventType != 2) {
            if (eventType != 3 || !AbstractC13042fc3.d("group", c8133Ur.j().getName())) {
                return i;
            }
            int i2 = i + 1;
            for (int i3 = 0; i3 < i2; i3++) {
                aVar.g();
            }
            return 0;
        }
        String name = c8133Ur.j().getName();
        if (name == null) {
            return i;
        }
        int iHashCode = name.hashCode();
        if (iHashCode == -1649314686) {
            if (!name.equals("clip-path")) {
                return i;
            }
            f(c8133Ur, resources, theme, attributeSet, aVar);
            return i + 1;
        }
        if (iHashCode == 3433509) {
            if (!name.equals("path")) {
                return i;
            }
            i(c8133Ur, resources, theme, attributeSet, aVar);
            return i;
        }
        if (iHashCode != 98629247 || !name.equals("group")) {
            return i;
        }
        h(c8133Ur, resources, theme, attributeSet, aVar);
        return i;
    }

    public static final void h(C8133Ur c8133Ur, Resources resources, Resources.Theme theme, AttributeSet attributeSet, C12700f33.a aVar) {
        C8367Vr c8367Vr = C8367Vr.a;
        TypedArray typedArrayK = c8133Ur.k(resources, theme, attributeSet, c8367Vr.e());
        float fG = c8133Ur.g(typedArrayK, "rotation", c8367Vr.i(), 0.0f);
        float fB = c8133Ur.b(typedArrayK, c8367Vr.g(), 0.0f);
        float fB2 = c8133Ur.b(typedArrayK, c8367Vr.h(), 0.0f);
        float fG2 = c8133Ur.g(typedArrayK, "scaleX", c8367Vr.j(), 1.0f);
        float fG3 = c8133Ur.g(typedArrayK, "scaleY", c8367Vr.k(), 1.0f);
        float fG4 = c8133Ur.g(typedArrayK, "translateX", c8367Vr.l(), 0.0f);
        float fG5 = c8133Ur.g(typedArrayK, "translateY", c8367Vr.m(), 0.0f);
        String strI = c8133Ur.i(typedArrayK, c8367Vr.f());
        if (strI == null) {
            strI = "";
        }
        typedArrayK.recycle();
        aVar.a(strI, fG, fB, fB2, fG2, fG3, fG4, fG5, TQ7.d());
    }

    public static final void i(C8133Ur c8133Ur, Resources resources, Resources.Theme theme, AttributeSet attributeSet, C12700f33.a aVar) {
        C8367Vr c8367Vr = C8367Vr.a;
        TypedArray typedArrayK = c8133Ur.k(resources, theme, attributeSet, c8367Vr.o());
        if (!AbstractC8958Xy7.j(c8133Ur.j(), "pathData")) {
            throw new IllegalArgumentException("No path data available");
        }
        String strI = c8133Ur.i(typedArrayK, c8367Vr.r());
        if (strI == null) {
            strI = "";
        }
        String str = strI;
        String strI2 = c8133Ur.i(typedArrayK, c8367Vr.s());
        List listD = strI2 == null ? TQ7.d() : C21723u15.b(c8133Ur.c, strI2, null, 2, null);
        F01 f01F = c8133Ur.f(typedArrayK, theme, "fillColor", c8367Vr.q(), 0);
        float fG = c8133Ur.g(typedArrayK, "fillAlpha", c8367Vr.p(), 1.0f);
        int iB = b(c8133Ur.h(typedArrayK, "strokeLineCap", c8367Vr.v(), -1), AbstractC24405yZ6.a.a());
        int iC = c(c8133Ur.h(typedArrayK, "strokeLineJoin", c8367Vr.w(), -1), AZ6.a.a());
        float fG2 = c8133Ur.g(typedArrayK, "strokeMiterLimit", c8367Vr.x(), 1.0f);
        F01 f01F2 = c8133Ur.f(typedArrayK, theme, "strokeColor", c8367Vr.u(), 0);
        float fG3 = c8133Ur.g(typedArrayK, "strokeAlpha", c8367Vr.t(), 1.0f);
        float fG4 = c8133Ur.g(typedArrayK, "strokeWidth", c8367Vr.y(), 1.0f);
        float fG5 = c8133Ur.g(typedArrayK, "trimPathEnd", c8367Vr.z(), 1.0f);
        float fG6 = c8133Ur.g(typedArrayK, "trimPathOffset", c8367Vr.B(), 0.0f);
        float fG7 = c8133Ur.g(typedArrayK, "trimPathStart", c8367Vr.C(), 0.0f);
        int iH = c8133Ur.h(typedArrayK, "fillType", c8367Vr.A(), a);
        typedArrayK.recycle();
        AbstractC12520el0 abstractC12520el0E = e(f01F);
        AbstractC12520el0 abstractC12520el0E2 = e(f01F2);
        AbstractC14502i15.a aVar2 = AbstractC14502i15.a;
        aVar.c(listD, iH == 0 ? aVar2.b() : aVar2.a(), str, abstractC12520el0E, fG, abstractC12520el0E2, fG3, fG4, iB, iC, fG2, fG7, fG5, fG6);
    }

    public static final XmlPullParser j(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int next = xmlPullParser.next();
        while (next != 2 && next != 1) {
            next = xmlPullParser.next();
        }
        if (next == 2) {
            return xmlPullParser;
        }
        throw new XmlPullParserException("No start tag found");
    }
}
