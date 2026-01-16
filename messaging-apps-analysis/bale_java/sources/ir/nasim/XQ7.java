package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.C12700f33;
import ir.nasim.C13336g33;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes2.dex */
public abstract class XQ7 {
    public static final C13336g33.a a(Resources.Theme theme, Resources resources, XmlResourceParser xmlResourceParser, int i) throws XmlPullParserException, IOException {
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlResourceParser);
        C8133Ur c8133Ur = new C8133Ur(xmlResourceParser, 0, 2, null);
        C12700f33.a aVarA = AbstractC19593qc8.a(c8133Ur, resources, theme, attributeSetAsAttributeSet);
        int iG = 0;
        while (!AbstractC19593qc8.d(xmlResourceParser)) {
            iG = AbstractC19593qc8.g(c8133Ur, resources, attributeSetAsAttributeSet, theme, aVarA, iG);
            xmlResourceParser.next();
        }
        return new C13336g33.a(aVarA.f(), i);
    }

    public static final C12700f33 b(C12700f33.b bVar, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(44534090, i2, -1, "androidx.compose.ui.res.vectorResource (VectorResources.android.kt:47)");
        }
        Context context = (Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g());
        Resources resourcesA = YW5.a(interfaceC22053ub1, 0);
        Resources.Theme theme = context.getTheme();
        boolean zV = interfaceC22053ub1.V(resourcesA) | ((((i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) > 32 && interfaceC22053ub1.e(i)) || (i2 & 48) == 32) | interfaceC22053ub1.V(theme) | interfaceC22053ub1.V(resourcesA.getConfiguration());
        Object objB = interfaceC22053ub1.B();
        if (zV || objB == InterfaceC22053ub1.a.a()) {
            objB = c(bVar, theme, resourcesA, i);
            interfaceC22053ub1.s(objB);
        }
        C12700f33 c12700f33 = (C12700f33) objB;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return c12700f33;
    }

    public static final C12700f33 c(C12700f33.b bVar, Resources.Theme theme, Resources resources, int i) throws XmlPullParserException, Resources.NotFoundException, IOException {
        TypedValue typedValue = new TypedValue();
        resources.getValue(i, typedValue, true);
        XmlResourceParser xml = resources.getXml(i);
        AbstractC19593qc8.j(xml);
        C19938rB7 c19938rB7 = C19938rB7.a;
        return a(theme, resources, xml, typedValue.changingConfigurations).b();
    }
}
