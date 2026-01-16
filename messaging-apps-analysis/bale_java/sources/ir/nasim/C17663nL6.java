package ir.nasim;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: ir.nasim.nL6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C17663nL6 {
    int a = -1;
    int b = -1;
    int c = -1;
    private SparseArray d = new SparseArray();
    private SparseArray e = new SparseArray();

    /* renamed from: ir.nasim.nL6$a */
    static class a {
        int a;
        ArrayList b = new ArrayList();
        int c;
        boolean d;

        public a(Context context, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
            this.c = -1;
            this.d = false;
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
                        this.d = true;
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        void a(b bVar) {
            this.b.add(bVar);
        }

        public int b(float f, float f2) {
            for (int i = 0; i < this.b.size(); i++) {
                if (((b) this.b.get(i)).a(f, f2)) {
                    return i;
                }
            }
            return -1;
        }
    }

    /* renamed from: ir.nasim.nL6$b */
    static class b {
        float a;
        float b;
        float c;
        float d;
        int e;
        boolean f;

        public b(Context context, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
            this.a = Float.NaN;
            this.b = Float.NaN;
            this.c = Float.NaN;
            this.d = Float.NaN;
            this.e = -1;
            this.f = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), SE5.Variant);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == SE5.Variant_constraints) {
                    this.e = typedArrayObtainStyledAttributes.getResourceId(index, this.e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.e);
                    context.getResources().getResourceName(this.e);
                    if ("layout".equals(resourceTypeName)) {
                        this.f = true;
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

    public C17663nL6(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        b(context, xmlPullParser);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b(android.content.Context r9, org.xmlpull.v1.XmlPullParser r10) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r8 = this;
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r10)
            int[] r1 = ir.nasim.SE5.StateSet
            android.content.res.TypedArray r0 = r9.obtainStyledAttributes(r0, r1)
            int r1 = r0.getIndexCount()
            r2 = 0
            r3 = r2
        L10:
            if (r3 >= r1) goto L25
            int r4 = r0.getIndex(r3)
            int r5 = ir.nasim.SE5.StateSet_defaultState
            if (r4 != r5) goto L22
            int r5 = r8.a
            int r4 = r0.getResourceId(r4, r5)
            r8.a = r4
        L22:
            int r3 = r3 + 1
            goto L10
        L25:
            r0.recycle()
            int r0 = r10.getEventType()     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            r1 = 0
        L2d:
            r3 = 1
            if (r0 == r3) goto La9
            if (r0 == 0) goto L9a
            java.lang.String r4 = "StateSet"
            r5 = 3
            r6 = 2
            if (r0 == r6) goto L4b
            if (r0 == r5) goto L3c
            goto L9d
        L3c:
            java.lang.String r0 = r10.getName()     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            boolean r0 = r4.equals(r0)     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            if (r0 == 0) goto L9d
            return
        L47:
            r9 = move-exception
            goto La2
        L49:
            r9 = move-exception
            goto La6
        L4b:
            java.lang.String r0 = r10.getName()     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            int r7 = r0.hashCode()     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            switch(r7) {
                case 80204913: goto L72;
                case 1301459538: goto L68;
                case 1382829617: goto L61;
                case 1901439077: goto L57;
                default: goto L56;
            }     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
        L56:
            goto L7c
        L57:
            java.lang.String r3 = "Variant"
            boolean r0 = r0.equals(r3)     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            if (r0 == 0) goto L7c
            r3 = r5
            goto L7d
        L61:
            boolean r0 = r0.equals(r4)     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            if (r0 == 0) goto L7c
            goto L7d
        L68:
            java.lang.String r3 = "LayoutDescription"
            boolean r0 = r0.equals(r3)     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            if (r0 == 0) goto L7c
            r3 = r2
            goto L7d
        L72:
            java.lang.String r3 = "State"
            boolean r0 = r0.equals(r3)     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            if (r0 == 0) goto L7c
            r3 = r6
            goto L7d
        L7c:
            r3 = -1
        L7d:
            if (r3 == r6) goto L8d
            if (r3 == r5) goto L82
            goto L9d
        L82:
            ir.nasim.nL6$b r0 = new ir.nasim.nL6$b     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            r0.<init>(r9, r10)     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            if (r1 == 0) goto L9d
            r1.a(r0)     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            goto L9d
        L8d:
            ir.nasim.nL6$a r1 = new ir.nasim.nL6$a     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            r1.<init>(r9, r10)     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            android.util.SparseArray r0 = r8.d     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            int r3 = r1.a     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            r0.put(r3, r1)     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            goto L9d
        L9a:
            r10.getName()     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
        L9d:
            int r0 = r10.next()     // Catch: java.io.IOException -> L47 org.xmlpull.v1.XmlPullParserException -> L49
            goto L2d
        La2:
            r9.printStackTrace()
            goto La9
        La6:
            r9.printStackTrace()
        La9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17663nL6.b(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public int a(int i, int i2, float f, float f2) {
        a aVar = (a) this.d.get(i2);
        if (aVar == null) {
            return i2;
        }
        if (f == -1.0f || f2 == -1.0f) {
            if (aVar.c == i) {
                return i;
            }
            Iterator it = aVar.b.iterator();
            while (it.hasNext()) {
                if (i == ((b) it.next()).e) {
                    return i;
                }
            }
            return aVar.c;
        }
        Iterator it2 = aVar.b.iterator();
        b bVar = null;
        while (it2.hasNext()) {
            b bVar2 = (b) it2.next();
            if (bVar2.a(f, f2)) {
                if (i == bVar2.e) {
                    return i;
                }
                bVar = bVar2;
            }
        }
        return bVar != null ? bVar.e : aVar.c;
    }

    public int c(int i, int i2, int i3) {
        return d(-1, i, i2, i3);
    }

    public int d(int i, int i2, float f, float f2) {
        int iB;
        if (i == i2) {
            a aVar = i2 == -1 ? (a) this.d.valueAt(0) : (a) this.d.get(this.b);
            if (aVar == null) {
                return -1;
            }
            return ((this.c == -1 || !((b) aVar.b.get(i)).a(f, f2)) && i != (iB = aVar.b(f, f2))) ? iB == -1 ? aVar.c : ((b) aVar.b.get(iB)).e : i;
        }
        a aVar2 = (a) this.d.get(i2);
        if (aVar2 == null) {
            return -1;
        }
        int iB2 = aVar2.b(f, f2);
        return iB2 == -1 ? aVar2.c : ((b) aVar2.b.get(iB2)).e;
    }
}
