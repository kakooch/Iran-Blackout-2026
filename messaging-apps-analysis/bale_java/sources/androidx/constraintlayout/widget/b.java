package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.gov.nist.core.Separators;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import ir.nasim.AbstractC19015pe1;
import ir.nasim.SE5;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes2.dex */
public class b {
    private final ConstraintLayout a;
    c b;
    int c = -1;
    int d = -1;
    private SparseArray e = new SparseArray();
    private SparseArray f = new SparseArray();

    static class a {
        int a;
        ArrayList b = new ArrayList();
        int c;
        c d;

        public a(Context context, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
            this.c = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), SE5.State);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == SE5.State_android_id) {
                    this.a = typedArrayObtainStyledAttributes.getResourceId(index, this.a);
                } else if (index == SE5.State_constraints) {
                    this.c = typedArrayObtainStyledAttributes.getResourceId(index, this.c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.c);
                    context.getResources().getResourceName(this.c);
                    if ("layout".equals(resourceTypeName)) {
                        c cVar = new c();
                        this.d = cVar;
                        cVar.o(context, this.c);
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        void a(C0076b c0076b) {
            this.b.add(c0076b);
        }

        public int b(float f, float f2) {
            for (int i = 0; i < this.b.size(); i++) {
                if (((C0076b) this.b.get(i)).a(f, f2)) {
                    return i;
                }
            }
            return -1;
        }
    }

    /* renamed from: androidx.constraintlayout.widget.b$b, reason: collision with other inner class name */
    static class C0076b {
        float a;
        float b;
        float c;
        float d;
        int e;
        c f;

        public C0076b(Context context, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
            this.a = Float.NaN;
            this.b = Float.NaN;
            this.c = Float.NaN;
            this.d = Float.NaN;
            this.e = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), SE5.Variant);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == SE5.Variant_constraints) {
                    this.e = typedArrayObtainStyledAttributes.getResourceId(index, this.e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.e);
                    context.getResources().getResourceName(this.e);
                    if ("layout".equals(resourceTypeName)) {
                        c cVar = new c();
                        this.f = cVar;
                        cVar.o(context, this.e);
                    }
                } else if (index == SE5.Variant_region_heightLessThan) {
                    this.d = typedArrayObtainStyledAttributes.getDimension(index, this.d);
                } else if (index == SE5.Variant_region_heightMoreThan) {
                    this.b = typedArrayObtainStyledAttributes.getDimension(index, this.b);
                } else if (index == SE5.Variant_region_widthLessThan) {
                    this.c = typedArrayObtainStyledAttributes.getDimension(index, this.c);
                } else if (index == SE5.Variant_region_widthMoreThan) {
                    this.a = typedArrayObtainStyledAttributes.getDimension(index, this.a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        boolean a(float f, float f2) {
            if (!Float.isNaN(this.a) && f < this.a) {
                return false;
            }
            if (!Float.isNaN(this.b) && f2 < this.b) {
                return false;
            }
            if (Float.isNaN(this.c) || f <= this.c) {
                return Float.isNaN(this.d) || f2 <= this.d;
            }
            return false;
        }
    }

    b(Context context, ConstraintLayout constraintLayout, int i) throws XmlPullParserException, Resources.NotFoundException, IOException, NumberFormatException {
        this.a = constraintLayout;
        a(context, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(android.content.Context r8, int r9) throws org.xmlpull.v1.XmlPullParserException, android.content.res.Resources.NotFoundException, java.io.IOException, java.lang.NumberFormatException {
        /*
            r7 = this;
            android.content.res.Resources r0 = r8.getResources()
            android.content.res.XmlResourceParser r9 = r0.getXml(r9)
            int r0 = r9.getEventType()     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            r1 = 0
        Ld:
            r2 = 1
            if (r0 == r2) goto L8d
            if (r0 == 0) goto L7e
            r3 = 2
            if (r0 == r3) goto L17
            goto L81
        L17:
            java.lang.String r0 = r9.getName()     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            int r4 = r0.hashCode()     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            r5 = 4
            r6 = 3
            switch(r4) {
                case -1349929691: goto L50;
                case 80204913: goto L46;
                case 1382829617: goto L3d;
                case 1657696882: goto L33;
                case 1901439077: goto L25;
                default: goto L24;
            }     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
        L24:
            goto L5a
        L25:
            java.lang.String r2 = "Variant"
            boolean r0 = r0.equals(r2)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            if (r0 == 0) goto L5a
            r2 = r6
            goto L5b
        L2f:
            r8 = move-exception
            goto L86
        L31:
            r8 = move-exception
            goto L8a
        L33:
            java.lang.String r2 = "layoutDescription"
            boolean r0 = r0.equals(r2)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            if (r0 == 0) goto L5a
            r2 = 0
            goto L5b
        L3d:
            java.lang.String r4 = "StateSet"
            boolean r0 = r0.equals(r4)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            if (r0 == 0) goto L5a
            goto L5b
        L46:
            java.lang.String r2 = "State"
            boolean r0 = r0.equals(r2)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            if (r0 == 0) goto L5a
            r2 = r3
            goto L5b
        L50:
            java.lang.String r2 = "ConstraintSet"
            boolean r0 = r0.equals(r2)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            if (r0 == 0) goto L5a
            r2 = r5
            goto L5b
        L5a:
            r2 = -1
        L5b:
            if (r2 == r3) goto L71
            if (r2 == r6) goto L66
            if (r2 == r5) goto L62
            goto L81
        L62:
            r7.b(r8, r9)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            goto L81
        L66:
            androidx.constraintlayout.widget.b$b r0 = new androidx.constraintlayout.widget.b$b     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            r0.<init>(r8, r9)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            if (r1 == 0) goto L81
            r1.a(r0)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            goto L81
        L71:
            androidx.constraintlayout.widget.b$a r1 = new androidx.constraintlayout.widget.b$a     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            r1.<init>(r8, r9)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            android.util.SparseArray r0 = r7.e     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            int r2 = r1.a     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            r0.put(r2, r1)     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            goto L81
        L7e:
            r9.getName()     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
        L81:
            int r0 = r9.next()     // Catch: java.io.IOException -> L2f org.xmlpull.v1.XmlPullParserException -> L31
            goto Ld
        L86:
            r8.printStackTrace()
            goto L8d
        L8a:
            r8.printStackTrace()
        L8d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.b.a(android.content.Context, int):void");
    }

    private void b(Context context, XmlPullParser xmlPullParser) throws NumberFormatException {
        c cVar = new c();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if (attributeName != null && attributeValue != null && "id".equals(attributeName)) {
                int identifier = attributeValue.contains(Separators.SLASH) ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                if (identifier == -1) {
                    if (attributeValue.length() > 1) {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                cVar.G(context, xmlPullParser);
                this.f.put(identifier, cVar);
                return;
            }
        }
    }

    public void d(int i, float f, float f2) {
        int iB;
        int i2 = this.c;
        if (i2 == i) {
            a aVar = i == -1 ? (a) this.e.valueAt(0) : (a) this.e.get(i2);
            int i3 = this.d;
            if ((i3 == -1 || !((C0076b) aVar.b.get(i3)).a(f, f2)) && this.d != (iB = aVar.b(f, f2))) {
                c cVar = iB == -1 ? this.b : ((C0076b) aVar.b.get(iB)).f;
                if (iB != -1) {
                    int i4 = ((C0076b) aVar.b.get(iB)).e;
                }
                if (cVar == null) {
                    return;
                }
                this.d = iB;
                cVar.i(this.a);
                return;
            }
            return;
        }
        this.c = i;
        a aVar2 = (a) this.e.get(i);
        int iB2 = aVar2.b(f, f2);
        c cVar2 = iB2 == -1 ? aVar2.d : ((C0076b) aVar2.b.get(iB2)).f;
        if (iB2 != -1) {
            int i5 = ((C0076b) aVar2.b.get(iB2)).e;
        }
        if (cVar2 != null) {
            this.d = iB2;
            cVar2.i(this.a);
            return;
        }
        StringBuilder sb = new StringBuilder(79);
        sb.append("NO Constraint set found ! id=");
        sb.append(i);
        sb.append(", dim =");
        sb.append(f);
        sb.append(", ");
        sb.append(f2);
        Log.v("ConstraintLayoutStates", sb.toString());
    }

    public void c(AbstractC19015pe1 abstractC19015pe1) {
    }
}
