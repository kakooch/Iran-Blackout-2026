package ir.nasim;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes2.dex */
public abstract class MY0 {
    private static final ThreadLocal a = new ThreadLocal();

    public static ColorStateList a(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return b(resources, xmlPullParser, attributeSetAsAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static ColorStateList b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return e(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    private static TypedValue c() {
        ThreadLocal threadLocal = a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    public static ColorStateList d(Resources resources, int i, Resources.Theme theme) {
        try {
            return a(resources, resources.getXml(i), theme);
        } catch (Exception e) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e);
            return null;
        }
    }

    private static ColorStateList e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int color;
        Resources resources2 = resources;
        int i = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20][];
        int[] iArrA = new int[20];
        int i2 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray typedArrayH = h(resources2, theme, attributeSet, UE5.ColorStateListItem);
                int resourceId = typedArrayH.getResourceId(UE5.ColorStateListItem_android_color, -1);
                if (resourceId == -1 || f(resources2, resourceId)) {
                    color = typedArrayH.getColor(UE5.ColorStateListItem_android_color, -65281);
                } else {
                    try {
                        color = a(resources2, resources2.getXml(resourceId), theme).getDefaultColor();
                    } catch (Exception unused) {
                        color = typedArrayH.getColor(UE5.ColorStateListItem_android_color, -65281);
                    }
                }
                float f = 1.0f;
                if (typedArrayH.hasValue(UE5.ColorStateListItem_android_alpha)) {
                    f = typedArrayH.getFloat(UE5.ColorStateListItem_android_alpha, 1.0f);
                } else if (typedArrayH.hasValue(UE5.ColorStateListItem_alpha)) {
                    f = typedArrayH.getFloat(UE5.ColorStateListItem_alpha, 1.0f);
                }
                float f2 = (Build.VERSION.SDK_INT < 31 || !typedArrayH.hasValue(UE5.ColorStateListItem_android_lStar)) ? typedArrayH.getFloat(UE5.ColorStateListItem_lStar, -1.0f) : typedArrayH.getFloat(UE5.ColorStateListItem_android_lStar, -1.0f);
                typedArrayH.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr2 = new int[attributeCount];
                int i3 = 0;
                for (int i4 = 0; i4 < attributeCount; i4++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i4);
                    if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != AbstractC18154oA5.alpha && attributeNameResource != AbstractC18154oA5.lStar) {
                        int i5 = i3 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i4, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr2[i3] = attributeNameResource;
                        i3 = i5;
                    }
                }
                int[] iArrTrimStateSet = StateSet.trimStateSet(iArr2, i3);
                iArrA = JS2.a(iArrA, i2, g(color, f, f2));
                iArr = (int[][]) JS2.b(iArr, i2, iArrTrimStateSet);
                i2++;
            }
            i = 1;
            resources2 = resources;
        }
        int[] iArr3 = new int[i2];
        int[][] iArr4 = new int[i2][];
        System.arraycopy(iArrA, 0, iArr3, 0, i2);
        System.arraycopy(iArr, 0, iArr4, 0, i2);
        return new ColorStateList(iArr4, iArr3);
    }

    private static boolean f(Resources resources, int i) throws Resources.NotFoundException {
        TypedValue typedValueC = c();
        resources.getValue(i, typedValueC, true);
        int i2 = typedValueC.type;
        return i2 >= 28 && i2 <= 31;
    }

    private static int g(int i, float f, float f2) {
        boolean z = f2 >= 0.0f && f2 <= 100.0f;
        if (f == 1.0f && !z) {
            return i;
        }
        int iB = AbstractC22000uV3.b((int) ((Color.alpha(i) * f) + 0.5f), 0, 255);
        if (z) {
            C20531sA0 c20531sA0C = C20531sA0.c(i);
            i = C20531sA0.m(c20531sA0C.j(), c20531sA0C.i(), f2);
        }
        return (i & 16777215) | (iB << 24);
    }

    private static TypedArray h(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
