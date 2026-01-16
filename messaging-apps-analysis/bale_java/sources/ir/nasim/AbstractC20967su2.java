package ir.nasim;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import android.util.Base64;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: ir.nasim.su2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC20967su2 {

    /* renamed from: ir.nasim.su2$a */
    static class a {
        static int a(TypedArray typedArray, int i) {
            return typedArray.getType(i);
        }
    }

    /* renamed from: ir.nasim.su2$b */
    public interface b {
    }

    /* renamed from: ir.nasim.su2$c */
    public static final class c implements b {
        private final d[] a;

        public c(d[] dVarArr) {
            this.a = dVarArr;
        }

        public d[] a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.su2$d */
    public static final class d {
        private final String a;
        private final int b;
        private final boolean c;
        private final String d;
        private final int e;
        private final int f;

        public d(String str, int i, boolean z, String str2, int i2, int i3) {
            this.a = str;
            this.b = i;
            this.c = z;
            this.d = str2;
            this.e = i2;
            this.f = i3;
        }

        public String a() {
            return this.a;
        }

        public int b() {
            return this.f;
        }

        public int c() {
            return this.e;
        }

        public String d() {
            return this.d;
        }

        public int e() {
            return this.b;
        }

        public boolean f() {
            return this.c;
        }
    }

    /* renamed from: ir.nasim.su2$e */
    public static final class e implements b {
        private final C19767qu2 a;
        private final int b;
        private final int c;
        private final String d;

        public e(C19767qu2 c19767qu2, int i, int i2, String str) {
            this.a = c19767qu2;
            this.c = i;
            this.b = i2;
            this.d = str;
        }

        public int a() {
            return this.c;
        }

        public C19767qu2 b() {
            return this.a;
        }

        public String c() {
            return this.d;
        }

        public int d() {
            return this.b;
        }
    }

    private static int a(TypedArray typedArray, int i) {
        return a.a(typedArray, i);
    }

    public static b b(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return d(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List c(Resources resources, int i) throws Resources.NotFoundException {
        if (i == 0) {
            return Collections.emptyList();
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(typedArrayObtainTypedArray, 0) == 1) {
                for (int i2 = 0; i2 < typedArrayObtainTypedArray.length(); i2++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i2, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i)));
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    private static b d(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    private static b e(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), UE5.FontFamily);
        String string = typedArrayObtainAttributes.getString(UE5.FontFamily_fontProviderAuthority);
        String string2 = typedArrayObtainAttributes.getString(UE5.FontFamily_fontProviderPackage);
        String string3 = typedArrayObtainAttributes.getString(UE5.FontFamily_fontProviderQuery);
        int resourceId = typedArrayObtainAttributes.getResourceId(UE5.FontFamily_fontProviderCerts, 0);
        int integer = typedArrayObtainAttributes.getInteger(UE5.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(UE5.FontFamily_fontProviderFetchTimeout, SIPTransactionStack.BASE_TIMER_INTERVAL);
        String string4 = typedArrayObtainAttributes.getString(UE5.FontFamily_fontProviderSystemFontFamily);
        typedArrayObtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                g(xmlPullParser);
            }
            return new e(new C19767qu2(string, string2, string3, c(resources, resourceId)), integer, integer2, string4);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(f(xmlPullParser, resources));
                } else {
                    g(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new c((d[]) arrayList.toArray(new d[0]));
    }

    private static d f(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), UE5.FontFamilyFont);
        int i = typedArrayObtainAttributes.getInt(typedArrayObtainAttributes.hasValue(UE5.FontFamilyFont_fontWeight) ? UE5.FontFamilyFont_fontWeight : UE5.FontFamilyFont_android_fontWeight, 400);
        boolean z = 1 == typedArrayObtainAttributes.getInt(typedArrayObtainAttributes.hasValue(UE5.FontFamilyFont_fontStyle) ? UE5.FontFamilyFont_fontStyle : UE5.FontFamilyFont_android_fontStyle, 0);
        int i2 = typedArrayObtainAttributes.hasValue(UE5.FontFamilyFont_ttcIndex) ? UE5.FontFamilyFont_ttcIndex : UE5.FontFamilyFont_android_ttcIndex;
        String string = typedArrayObtainAttributes.getString(typedArrayObtainAttributes.hasValue(UE5.FontFamilyFont_fontVariationSettings) ? UE5.FontFamilyFont_fontVariationSettings : UE5.FontFamilyFont_android_fontVariationSettings);
        int i3 = typedArrayObtainAttributes.getInt(i2, 0);
        int i4 = typedArrayObtainAttributes.hasValue(UE5.FontFamilyFont_font) ? UE5.FontFamilyFont_font : UE5.FontFamilyFont_android_font;
        int resourceId = typedArrayObtainAttributes.getResourceId(i4, 0);
        String string2 = typedArrayObtainAttributes.getString(i4);
        typedArrayObtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new d(string2, i, z, string, i3, resourceId);
    }

    private static void g(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i = 1;
        while (i > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }

    private static List h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }
}
