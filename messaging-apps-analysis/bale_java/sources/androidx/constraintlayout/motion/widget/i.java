package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.gov.nist.core.Separators;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import ir.nasim.AbstractC23607xC5;
import ir.nasim.C17663nL6;
import ir.nasim.J22;
import ir.nasim.OA1;
import ir.nasim.SE5;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes2.dex */
public class i {
    private final MotionLayout a;
    private MotionEvent n;
    private MotionLayout.g q;
    private boolean r;
    final l s;
    float t;
    float u;
    C17663nL6 b = null;
    b c = null;
    private boolean d = false;
    private ArrayList e = new ArrayList();
    private b f = null;
    private ArrayList g = new ArrayList();
    private SparseArray h = new SparseArray();
    private HashMap i = new HashMap();
    private SparseIntArray j = new SparseIntArray();
    private boolean k = false;
    private int l = 400;
    private int m = 0;
    private boolean o = false;
    private boolean p = false;

    class a implements Interpolator {
        final /* synthetic */ J22 a;

        a(i iVar, J22 j22) {
            this.a = j22;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return (float) this.a.a(f);
        }
    }

    i(Context context, MotionLayout motionLayout, int i) throws XmlPullParserException, Resources.NotFoundException, IOException {
        this.a = motionLayout;
        this.s = new l(motionLayout);
        K(context, i);
        this.h.put(AbstractC23607xC5.motion_base, new androidx.constraintlayout.widget.c());
        this.i.put("motion_base", Integer.valueOf(AbstractC23607xC5.motion_base));
    }

    private boolean I(int i) {
        int i2 = this.j.get(i);
        int size = this.j.size();
        while (i2 > 0) {
            if (i2 == i) {
                return true;
            }
            int i3 = size - 1;
            if (size < 0) {
                return true;
            }
            i2 = this.j.get(i2);
            size = i3;
        }
        return false;
    }

    private boolean J() {
        return this.q != null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void K(android.content.Context r10, int r11) throws org.xmlpull.v1.XmlPullParserException, android.content.res.Resources.NotFoundException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 458
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.i.K(android.content.Context, int):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int L(android.content.Context r17, org.xmlpull.v1.XmlPullParser r18) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.i.L(android.content.Context, org.xmlpull.v1.XmlPullParser):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int M(Context context, int i) throws XmlPullParserException, Resources.NotFoundException, IOException {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                String name = xml.getName();
                if (2 == eventType && "ConstraintSet".equals(name)) {
                    return L(context, xml);
                }
            }
            return -1;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    private void N(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, Resources.NotFoundException, IOException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), SE5.include);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == SE5.include_constraintSet) {
                M(context, typedArrayObtainStyledAttributes.getResourceId(index, -1));
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void O(Context context, XmlPullParser xmlPullParser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), SE5.MotionScene);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == SE5.MotionScene_defaultDuration) {
                int i2 = typedArrayObtainStyledAttributes.getInt(index, this.l);
                this.l = i2;
                if (i2 < 8) {
                    this.l = 8;
                }
            } else if (index == SE5.MotionScene_layoutDuringTransition) {
                this.m = typedArrayObtainStyledAttributes.getInteger(index, 0);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void S(int i, MotionLayout motionLayout) {
        androidx.constraintlayout.widget.c cVar = (androidx.constraintlayout.widget.c) this.h.get(i);
        cVar.c = cVar.b;
        int i2 = this.j.get(i);
        if (i2 > 0) {
            S(i2, motionLayout);
            androidx.constraintlayout.widget.c cVar2 = (androidx.constraintlayout.widget.c) this.h.get(i2);
            if (cVar2 == null) {
                String strValueOf = String.valueOf(OA1.c(this.a.getContext(), i2));
                Log.e("MotionScene", strValueOf.length() != 0 ? "ERROR! invalid deriveConstraintsFrom: @id/".concat(strValueOf) : new String("ERROR! invalid deriveConstraintsFrom: @id/"));
                return;
            }
            String strValueOf2 = String.valueOf(cVar.c);
            String str = cVar2.c;
            StringBuilder sb = new StringBuilder(strValueOf2.length() + 1 + String.valueOf(str).length());
            sb.append(strValueOf2);
            sb.append(Separators.SLASH);
            sb.append(str);
            cVar.c = sb.toString();
            cVar.O(cVar2);
        } else {
            cVar.c = String.valueOf(cVar.c).concat("  layout");
            cVar.N(motionLayout);
        }
        cVar.h(cVar);
    }

    public static String a0(String str) {
        if (str == null) {
            return "";
        }
        int iIndexOf = str.indexOf(47);
        return iIndexOf < 0 ? str : str.substring(iIndexOf + 1);
    }

    private int r(Context context, String str) {
        int identifier;
        if (str.contains(Separators.SLASH)) {
            identifier = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
            if (this.k) {
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder(27);
                sb.append("id getMap res = ");
                sb.append(identifier);
                printStream.println(sb.toString());
            }
        } else {
            identifier = -1;
        }
        if (identifier != -1) {
            return identifier;
        }
        if (str.length() > 1) {
            return Integer.parseInt(str.substring(1));
        }
        Log.e("MotionScene", "error in parsing id");
        return identifier;
    }

    private int y(int i) {
        int iC;
        C17663nL6 c17663nL6 = this.b;
        return (c17663nL6 == null || (iC = c17663nL6.c(i, -1, -1)) == -1) ? i : iC;
    }

    float A() {
        b bVar = this.c;
        if (bVar == null || bVar.l == null) {
            return 0.0f;
        }
        return this.c.l.l();
    }

    float B() {
        b bVar = this.c;
        if (bVar == null || bVar.l == null) {
            return 0.0f;
        }
        return this.c.l.m();
    }

    float C() {
        b bVar = this.c;
        if (bVar == null || bVar.l == null) {
            return 0.0f;
        }
        return this.c.l.n();
    }

    float D() {
        b bVar = this.c;
        if (bVar == null || bVar.l == null) {
            return 0.0f;
        }
        return this.c.l.o();
    }

    public float E() {
        b bVar = this.c;
        if (bVar != null) {
            return bVar.i;
        }
        return 0.0f;
    }

    int F() {
        b bVar = this.c;
        if (bVar == null) {
            return -1;
        }
        return bVar.d;
    }

    public b G(int i) {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.a == i) {
                return bVar;
            }
        }
        return null;
    }

    public List H(int i) {
        int iY = y(i);
        ArrayList arrayList = new ArrayList();
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.d == iY || bVar.c == iY) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    void P(float f, float f2) {
        b bVar = this.c;
        if (bVar == null || bVar.l == null) {
            return;
        }
        this.c.l.u(f, f2);
    }

    void Q(float f, float f2) {
        b bVar = this.c;
        if (bVar == null || bVar.l == null) {
            return;
        }
        this.c.l.v(f, f2);
    }

    void R(MotionEvent motionEvent, int i, MotionLayout motionLayout) {
        MotionLayout.g gVar;
        MotionEvent motionEvent2;
        RectF rectF = new RectF();
        if (this.q == null) {
            this.q = this.a.b1();
        }
        this.q.b(motionEvent);
        if (i != -1) {
            int action = motionEvent.getAction();
            boolean z = false;
            if (action == 0) {
                this.t = motionEvent.getRawX();
                this.u = motionEvent.getRawY();
                this.n = motionEvent;
                this.o = false;
                if (this.c.l != null) {
                    RectF rectFF = this.c.l.f(this.a, rectF);
                    if (rectFF != null && !rectFF.contains(this.n.getX(), this.n.getY())) {
                        this.n = null;
                        this.o = true;
                        return;
                    }
                    RectF rectFP = this.c.l.p(this.a, rectF);
                    if (rectFP == null || rectFP.contains(this.n.getX(), this.n.getY())) {
                        this.p = false;
                    } else {
                        this.p = true;
                    }
                    this.c.l.w(this.t, this.u);
                    return;
                }
                return;
            }
            if (action == 2 && !this.o) {
                float rawY = motionEvent.getRawY() - this.u;
                float rawX = motionEvent.getRawX() - this.t;
                if ((rawX == 0.0d && rawY == 0.0d) || (motionEvent2 = this.n) == null) {
                    return;
                }
                b bVarI = i(i, rawX, rawY, motionEvent2);
                if (bVarI != null) {
                    motionLayout.setTransition(bVarI);
                    RectF rectFP2 = this.c.l.p(this.a, rectF);
                    if (rectFP2 != null && !rectFP2.contains(this.n.getX(), this.n.getY())) {
                        z = true;
                    }
                    this.p = z;
                    this.c.l.z(this.t, this.u);
                }
            }
        }
        if (this.o) {
            return;
        }
        b bVar = this.c;
        if (bVar != null && bVar.l != null && !this.p) {
            this.c.l.s(motionEvent, this.q, i, this);
        }
        this.t = motionEvent.getRawX();
        this.u = motionEvent.getRawY();
        if (motionEvent.getAction() != 1 || (gVar = this.q) == null) {
            return;
        }
        gVar.a();
        this.q = null;
        int i2 = motionLayout.G;
        if (i2 != -1) {
            h(motionLayout, i2);
        }
    }

    void T(MotionLayout motionLayout) {
        for (int i = 0; i < this.h.size(); i++) {
            int iKeyAt = this.h.keyAt(i);
            if (I(iKeyAt)) {
                Log.e("MotionScene", "Cannot be derived from yourself");
                return;
            }
            S(iKeyAt, motionLayout);
        }
    }

    public void U(int i, androidx.constraintlayout.widget.c cVar) {
        this.h.put(i, cVar);
    }

    public void V(int i) {
        b bVar = this.c;
        if (bVar != null) {
            bVar.E(i);
        } else {
            this.l = i;
        }
    }

    public void W(boolean z) {
        this.r = z;
        b bVar = this.c;
        if (bVar == null || bVar.l == null) {
            return;
        }
        this.c.l.x(this.r);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void X(int r7, int r8) {
        /*
            r6 = this;
            ir.nasim.nL6 r0 = r6.b
            r1 = -1
            if (r0 == 0) goto L18
            int r0 = r0.c(r7, r1, r1)
            if (r0 == r1) goto Lc
            goto Ld
        Lc:
            r0 = r7
        Ld:
            ir.nasim.nL6 r2 = r6.b
            int r2 = r2.c(r8, r1, r1)
            if (r2 == r1) goto L16
            goto L1a
        L16:
            r2 = r8
            goto L1a
        L18:
            r0 = r7
            goto L16
        L1a:
            androidx.constraintlayout.motion.widget.i$b r3 = r6.c
            if (r3 == 0) goto L2d
            int r3 = androidx.constraintlayout.motion.widget.i.b.a(r3)
            if (r3 != r8) goto L2d
            androidx.constraintlayout.motion.widget.i$b r3 = r6.c
            int r3 = androidx.constraintlayout.motion.widget.i.b.c(r3)
            if (r3 != r7) goto L2d
            return
        L2d:
            java.util.ArrayList r3 = r6.e
            java.util.Iterator r3 = r3.iterator()
        L33:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L6d
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.i$b r4 = (androidx.constraintlayout.motion.widget.i.b) r4
            int r5 = androidx.constraintlayout.motion.widget.i.b.a(r4)
            if (r5 != r2) goto L4b
            int r5 = androidx.constraintlayout.motion.widget.i.b.c(r4)
            if (r5 == r0) goto L57
        L4b:
            int r5 = androidx.constraintlayout.motion.widget.i.b.a(r4)
            if (r5 != r8) goto L33
            int r5 = androidx.constraintlayout.motion.widget.i.b.c(r4)
            if (r5 != r7) goto L33
        L57:
            r6.c = r4
            if (r4 == 0) goto L6c
            androidx.constraintlayout.motion.widget.j r7 = androidx.constraintlayout.motion.widget.i.b.l(r4)
            if (r7 == 0) goto L6c
            androidx.constraintlayout.motion.widget.i$b r7 = r6.c
            androidx.constraintlayout.motion.widget.j r7 = androidx.constraintlayout.motion.widget.i.b.l(r7)
            boolean r8 = r6.r
            r7.x(r8)
        L6c:
            return
        L6d:
            androidx.constraintlayout.motion.widget.i$b r7 = r6.f
            java.util.ArrayList r3 = r6.g
            java.util.Iterator r3 = r3.iterator()
        L75:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L89
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.motion.widget.i$b r4 = (androidx.constraintlayout.motion.widget.i.b) r4
            int r5 = androidx.constraintlayout.motion.widget.i.b.a(r4)
            if (r5 != r8) goto L75
            r7 = r4
            goto L75
        L89:
            androidx.constraintlayout.motion.widget.i$b r8 = new androidx.constraintlayout.motion.widget.i$b
            r8.<init>(r6, r7)
            androidx.constraintlayout.motion.widget.i.b.d(r8, r0)
            androidx.constraintlayout.motion.widget.i.b.b(r8, r2)
            if (r0 == r1) goto L9b
            java.util.ArrayList r7 = r6.e
            r7.add(r8)
        L9b:
            r6.c = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.i.X(int, int):void");
    }

    public void Y(b bVar) {
        this.c = bVar;
        if (bVar == null || bVar.l == null) {
            return;
        }
        this.c.l.x(this.r);
    }

    void Z() {
        b bVar = this.c;
        if (bVar == null || bVar.l == null) {
            return;
        }
        this.c.l.A();
    }

    boolean b0() {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            if (((b) it.next()).l != null) {
                return true;
            }
        }
        b bVar = this.c;
        return (bVar == null || bVar.l == null) ? false : true;
    }

    public void f(MotionLayout motionLayout, int i) {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.m.size() > 0) {
                Iterator it2 = bVar.m.iterator();
                while (it2.hasNext()) {
                    ((b.a) it2.next()).c(motionLayout);
                }
            }
        }
        Iterator it3 = this.g.iterator();
        while (it3.hasNext()) {
            b bVar2 = (b) it3.next();
            if (bVar2.m.size() > 0) {
                Iterator it4 = bVar2.m.iterator();
                while (it4.hasNext()) {
                    ((b.a) it4.next()).c(motionLayout);
                }
            }
        }
        Iterator it5 = this.e.iterator();
        while (it5.hasNext()) {
            b bVar3 = (b) it5.next();
            if (bVar3.m.size() > 0) {
                Iterator it6 = bVar3.m.iterator();
                while (it6.hasNext()) {
                    ((b.a) it6.next()).a(motionLayout, i, bVar3);
                }
            }
        }
        Iterator it7 = this.g.iterator();
        while (it7.hasNext()) {
            b bVar4 = (b) it7.next();
            if (bVar4.m.size() > 0) {
                Iterator it8 = bVar4.m.iterator();
                while (it8.hasNext()) {
                    ((b.a) it8.next()).a(motionLayout, i, bVar4);
                }
            }
        }
    }

    public boolean g(int i, g gVar) {
        return this.s.d(i, gVar);
    }

    boolean h(MotionLayout motionLayout, int i) {
        b bVar;
        if (J() || this.d) {
            return false;
        }
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            b bVar2 = (b) it.next();
            if (bVar2.n != 0 && ((bVar = this.c) != bVar2 || !bVar.D(2))) {
                if (i == bVar2.d && (bVar2.n == 4 || bVar2.n == 2)) {
                    MotionLayout.k kVar = MotionLayout.k.FINISHED;
                    motionLayout.setState(kVar);
                    motionLayout.setTransition(bVar2);
                    if (bVar2.n == 4) {
                        motionLayout.i1();
                        motionLayout.setState(MotionLayout.k.SETUP);
                        motionLayout.setState(MotionLayout.k.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.L0(true);
                        motionLayout.setState(MotionLayout.k.SETUP);
                        motionLayout.setState(MotionLayout.k.MOVING);
                        motionLayout.setState(kVar);
                        motionLayout.c1();
                    }
                    return true;
                }
                if (i == bVar2.c && (bVar2.n == 3 || bVar2.n == 1)) {
                    MotionLayout.k kVar2 = MotionLayout.k.FINISHED;
                    motionLayout.setState(kVar2);
                    motionLayout.setTransition(bVar2);
                    if (bVar2.n == 3) {
                        motionLayout.k1();
                        motionLayout.setState(MotionLayout.k.SETUP);
                        motionLayout.setState(MotionLayout.k.MOVING);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.L0(true);
                        motionLayout.setState(MotionLayout.k.SETUP);
                        motionLayout.setState(MotionLayout.k.MOVING);
                        motionLayout.setState(kVar2);
                        motionLayout.c1();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public b i(int i, float f, float f2, MotionEvent motionEvent) {
        if (i == -1) {
            return this.c;
        }
        List<b> listH = H(i);
        RectF rectF = new RectF();
        float f3 = 0.0f;
        b bVar = null;
        for (b bVar2 : listH) {
            if (!bVar2.o && bVar2.l != null) {
                bVar2.l.x(this.r);
                RectF rectFP = bVar2.l.p(this.a, rectF);
                if (rectFP == null || motionEvent == null || rectFP.contains(motionEvent.getX(), motionEvent.getY())) {
                    RectF rectFF = bVar2.l.f(this.a, rectF);
                    if (rectFF == null || motionEvent == null || rectFF.contains(motionEvent.getX(), motionEvent.getY())) {
                        float fA = bVar2.l.a(f, f2);
                        if (bVar2.l.l && motionEvent != null) {
                            fA = ((float) (Math.atan2(f2 + r10, f + r9) - Math.atan2(motionEvent.getX() - bVar2.l.i, motionEvent.getY() - bVar2.l.j))) * 10.0f;
                        }
                        float f4 = fA * (bVar2.c == i ? -1.0f : 1.1f);
                        if (f4 > f3) {
                            bVar = bVar2;
                            f3 = f4;
                        }
                    }
                }
            }
        }
        return bVar;
    }

    public int j() {
        b bVar = this.c;
        if (bVar != null) {
            return bVar.p;
        }
        return -1;
    }

    int k() {
        b bVar = this.c;
        if (bVar == null || bVar.l == null) {
            return 0;
        }
        return this.c.l.d();
    }

    androidx.constraintlayout.widget.c l(int i) {
        return m(i, -1, -1);
    }

    androidx.constraintlayout.widget.c m(int i, int i2, int i3) {
        int iC;
        if (this.k) {
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder(14);
            sb.append("id ");
            sb.append(i);
            printStream.println(sb.toString());
            int size = this.h.size();
            StringBuilder sb2 = new StringBuilder(16);
            sb2.append("size ");
            sb2.append(size);
            printStream.println(sb2.toString());
        }
        C17663nL6 c17663nL6 = this.b;
        if (c17663nL6 != null && (iC = c17663nL6.c(i, i2, i3)) != -1) {
            i = iC;
        }
        if (this.h.get(i) != null) {
            return (androidx.constraintlayout.widget.c) this.h.get(i);
        }
        String strC = OA1.c(this.a.getContext(), i);
        StringBuilder sb3 = new StringBuilder(String.valueOf(strC).length() + 55);
        sb3.append("Warning could not find ConstraintSet id/");
        sb3.append(strC);
        sb3.append(" In MotionScene");
        Log.e("MotionScene", sb3.toString());
        SparseArray sparseArray = this.h;
        return (androidx.constraintlayout.widget.c) sparseArray.get(sparseArray.keyAt(0));
    }

    public int[] n() {
        int size = this.h.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = this.h.keyAt(i);
        }
        return iArr;
    }

    public ArrayList o() {
        return this.e;
    }

    public int p() {
        b bVar = this.c;
        return bVar != null ? bVar.h : this.l;
    }

    int q() {
        b bVar = this.c;
        if (bVar == null) {
            return -1;
        }
        return bVar.c;
    }

    public Interpolator s() {
        int i = this.c.e;
        if (i == -2) {
            return AnimationUtils.loadInterpolator(this.a.getContext(), this.c.g);
        }
        if (i == -1) {
            return new a(this, J22.c(this.c.f));
        }
        if (i == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i == 1) {
            return new AccelerateInterpolator();
        }
        if (i == 2) {
            return new DecelerateInterpolator();
        }
        if (i == 4) {
            return new BounceInterpolator();
        }
        if (i == 5) {
            return new OvershootInterpolator();
        }
        if (i != 6) {
            return null;
        }
        return new AnticipateInterpolator();
    }

    public void t(g gVar) {
        b bVar = this.c;
        if (bVar != null) {
            Iterator it = bVar.k.iterator();
            while (it.hasNext()) {
                ((c) it.next()).b(gVar);
            }
        } else {
            b bVar2 = this.f;
            if (bVar2 != null) {
                Iterator it2 = bVar2.k.iterator();
                while (it2.hasNext()) {
                    ((c) it2.next()).b(gVar);
                }
            }
        }
    }

    float u() {
        b bVar = this.c;
        if (bVar == null || bVar.l == null) {
            return 0.0f;
        }
        return this.c.l.g();
    }

    float v() {
        b bVar = this.c;
        if (bVar == null || bVar.l == null) {
            return 0.0f;
        }
        return this.c.l.h();
    }

    boolean w() {
        b bVar = this.c;
        if (bVar == null || bVar.l == null) {
            return false;
        }
        return this.c.l.i();
    }

    float x(float f, float f2) {
        b bVar = this.c;
        if (bVar == null || bVar.l == null) {
            return 0.0f;
        }
        return this.c.l.j(f, f2);
    }

    int z() {
        b bVar = this.c;
        if (bVar == null || bVar.l == null) {
            return 0;
        }
        return this.c.l.k();
    }

    public static class b {
        private int a;
        private boolean b;
        private int c;
        private int d;
        private int e;
        private String f;
        private int g;
        private int h;
        private float i;
        private final i j;
        private ArrayList k;
        private j l;
        private ArrayList m;
        private int n;
        private boolean o;
        private int p;
        private int q;
        private int r;

        public static class a implements View.OnClickListener {
            private final b a;
            int b;
            int c;

            public a(Context context, b bVar, XmlPullParser xmlPullParser) {
                this.b = -1;
                this.c = 17;
                this.a = bVar;
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), SE5.OnClick);
                int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
                for (int i = 0; i < indexCount; i++) {
                    int index = typedArrayObtainStyledAttributes.getIndex(i);
                    if (index == SE5.OnClick_targetId) {
                        this.b = typedArrayObtainStyledAttributes.getResourceId(index, this.b);
                    } else if (index == SE5.OnClick_clickAction) {
                        this.c = typedArrayObtainStyledAttributes.getInt(index, this.c);
                    }
                }
                typedArrayObtainStyledAttributes.recycle();
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r7v4, types: [android.view.View] */
            public void a(MotionLayout motionLayout, int i, b bVar) {
                int i2 = this.b;
                MotionLayout motionLayoutFindViewById = motionLayout;
                if (i2 != -1) {
                    motionLayoutFindViewById = motionLayout.findViewById(i2);
                }
                if (motionLayoutFindViewById == null) {
                    int i3 = this.b;
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("OnClick could not find id ");
                    sb.append(i3);
                    Log.e("MotionScene", sb.toString());
                    return;
                }
                int i4 = bVar.d;
                int i5 = bVar.c;
                if (i4 == -1) {
                    motionLayoutFindViewById.setOnClickListener(this);
                    return;
                }
                int i6 = this.c;
                boolean z = false;
                boolean z2 = ((i6 & 1) != 0 && i == i4) | ((i6 & 1) != 0 && i == i4) | ((i6 & 256) != 0 && i == i4) | ((i6 & 16) != 0 && i == i5);
                if ((i6 & 4096) != 0 && i == i5) {
                    z = true;
                }
                if (z2 || z) {
                    motionLayoutFindViewById.setOnClickListener(this);
                }
            }

            boolean b(b bVar, MotionLayout motionLayout) {
                b bVar2 = this.a;
                if (bVar2 == bVar) {
                    return true;
                }
                int i = bVar2.c;
                int i2 = this.a.d;
                if (i2 == -1) {
                    return motionLayout.G != i;
                }
                int i3 = motionLayout.G;
                return i3 == i2 || i3 == i;
            }

            public void c(MotionLayout motionLayout) {
                int i = this.b;
                if (i == -1) {
                    return;
                }
                View viewFindViewById = motionLayout.findViewById(i);
                if (viewFindViewById != null) {
                    viewFindViewById.setOnClickListener(null);
                    return;
                }
                int i2 = this.b;
                StringBuilder sb = new StringBuilder(35);
                sb.append(" (*)  could not find id ");
                sb.append(i2);
                Log.e("MotionScene", sb.toString());
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MotionLayout motionLayout = this.a.j.a;
                if (motionLayout.a1()) {
                    if (this.a.d == -1) {
                        int currentState = motionLayout.getCurrentState();
                        if (currentState == -1) {
                            motionLayout.l1(this.a.c);
                            return;
                        }
                        b bVar = new b(this.a.j, this.a);
                        bVar.d = currentState;
                        bVar.c = this.a.c;
                        motionLayout.setTransition(bVar);
                        motionLayout.i1();
                        return;
                    }
                    b bVar2 = this.a.j.c;
                    int i = this.c;
                    boolean z = false;
                    boolean z2 = ((i & 1) == 0 && (i & 256) == 0) ? false : true;
                    boolean z3 = ((i & 16) == 0 && (i & 4096) == 0) ? false : true;
                    if (z2 && z3) {
                        b bVar3 = this.a.j.c;
                        b bVar4 = this.a;
                        if (bVar3 != bVar4) {
                            motionLayout.setTransition(bVar4);
                        }
                        if (motionLayout.getCurrentState() != motionLayout.getEndState() && motionLayout.getProgress() <= 0.5f) {
                            z3 = false;
                            z = z2;
                        }
                    } else {
                        z = z2;
                    }
                    if (b(bVar2, motionLayout)) {
                        if (z && (this.c & 1) != 0) {
                            motionLayout.setTransition(this.a);
                            motionLayout.i1();
                            return;
                        }
                        if (z3 && (this.c & 16) != 0) {
                            motionLayout.setTransition(this.a);
                            motionLayout.k1();
                        } else if (z && (this.c & 256) != 0) {
                            motionLayout.setTransition(this.a);
                            motionLayout.setProgress(1.0f);
                        } else {
                            if (!z3 || (this.c & 4096) == 0) {
                                return;
                            }
                            motionLayout.setTransition(this.a);
                            motionLayout.setProgress(0.0f);
                        }
                    }
                }
            }
        }

        b(i iVar, b bVar) {
            this.a = -1;
            this.b = false;
            this.c = -1;
            this.d = -1;
            this.e = 0;
            this.f = null;
            this.g = -1;
            this.h = 400;
            this.i = 0.0f;
            this.k = new ArrayList();
            this.l = null;
            this.m = new ArrayList();
            this.n = 0;
            this.o = false;
            this.p = -1;
            this.q = 0;
            this.r = 0;
            this.j = iVar;
            this.h = iVar.l;
            if (bVar != null) {
                this.p = bVar.p;
                this.e = bVar.e;
                this.f = bVar.f;
                this.g = bVar.g;
                this.h = bVar.h;
                this.k = bVar.k;
                this.i = bVar.i;
                this.q = bVar.q;
            }
        }

        private void v(i iVar, Context context, TypedArray typedArray) throws Resources.NotFoundException {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                if (index == SE5.Transition_constraintSetEnd) {
                    this.c = typedArray.getResourceId(index, -1);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.c);
                    if ("layout".equals(resourceTypeName)) {
                        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
                        cVar.F(context, this.c);
                        iVar.h.append(this.c, cVar);
                    } else if ("xml".equals(resourceTypeName)) {
                        this.c = iVar.M(context, this.c);
                    }
                } else if (index == SE5.Transition_constraintSetStart) {
                    this.d = typedArray.getResourceId(index, this.d);
                    String resourceTypeName2 = context.getResources().getResourceTypeName(this.d);
                    if ("layout".equals(resourceTypeName2)) {
                        androidx.constraintlayout.widget.c cVar2 = new androidx.constraintlayout.widget.c();
                        cVar2.F(context, this.d);
                        iVar.h.append(this.d, cVar2);
                    } else if ("xml".equals(resourceTypeName2)) {
                        this.d = iVar.M(context, this.d);
                    }
                } else if (index == SE5.Transition_motionInterpolator) {
                    int i2 = typedArray.peekValue(index).type;
                    if (i2 == 1) {
                        int resourceId = typedArray.getResourceId(index, -1);
                        this.g = resourceId;
                        if (resourceId != -1) {
                            this.e = -2;
                        }
                    } else if (i2 == 3) {
                        String string = typedArray.getString(index);
                        this.f = string;
                        if (string != null) {
                            if (string.indexOf(Separators.SLASH) > 0) {
                                this.g = typedArray.getResourceId(index, -1);
                                this.e = -2;
                            } else {
                                this.e = -1;
                            }
                        }
                    } else {
                        this.e = typedArray.getInteger(index, this.e);
                    }
                } else if (index == SE5.Transition_duration) {
                    int i3 = typedArray.getInt(index, this.h);
                    this.h = i3;
                    if (i3 < 8) {
                        this.h = 8;
                    }
                } else if (index == SE5.Transition_staggered) {
                    this.i = typedArray.getFloat(index, this.i);
                } else if (index == SE5.Transition_autoTransition) {
                    this.n = typedArray.getInteger(index, this.n);
                } else if (index == SE5.Transition_android_id) {
                    this.a = typedArray.getResourceId(index, this.a);
                } else if (index == SE5.Transition_transitionDisable) {
                    this.o = typedArray.getBoolean(index, this.o);
                } else if (index == SE5.Transition_pathMotionArc) {
                    this.p = typedArray.getInteger(index, -1);
                } else if (index == SE5.Transition_layoutDuringTransition) {
                    this.q = typedArray.getInteger(index, 0);
                } else if (index == SE5.Transition_transitionFlags) {
                    this.r = typedArray.getInteger(index, 0);
                }
            }
            if (this.d == -1) {
                this.b = true;
            }
        }

        private void w(i iVar, Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, SE5.Transition);
            v(iVar, context, typedArrayObtainStyledAttributes);
            typedArrayObtainStyledAttributes.recycle();
        }

        public int A() {
            return this.d;
        }

        public j B() {
            return this.l;
        }

        public boolean C() {
            return !this.o;
        }

        public boolean D(int i) {
            return (i & this.r) != 0;
        }

        public void E(int i) {
            this.h = Math.max(i, 8);
        }

        public void F(int i, String str, int i2) {
            this.e = i;
            this.f = str;
            this.g = i2;
        }

        public void G(int i) {
            j jVarB = B();
            if (jVarB != null) {
                jVarB.y(i);
            }
        }

        public void H(int i) {
            this.p = i;
        }

        public void t(c cVar) {
            this.k.add(cVar);
        }

        public void u(Context context, XmlPullParser xmlPullParser) {
            this.m.add(new a(context, this, xmlPullParser));
        }

        public int x() {
            return this.n;
        }

        public int y() {
            return this.c;
        }

        public int z() {
            return this.q;
        }

        public b(int i, i iVar, int i2, int i3) {
            this.a = -1;
            this.b = false;
            this.c = -1;
            this.d = -1;
            this.e = 0;
            this.f = null;
            this.g = -1;
            this.h = 400;
            this.i = 0.0f;
            this.k = new ArrayList();
            this.l = null;
            this.m = new ArrayList();
            this.n = 0;
            this.o = false;
            this.p = -1;
            this.q = 0;
            this.r = 0;
            this.a = i;
            this.j = iVar;
            this.d = i2;
            this.c = i3;
            this.h = iVar.l;
            this.q = iVar.m;
        }

        b(i iVar, Context context, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
            this.a = -1;
            this.b = false;
            this.c = -1;
            this.d = -1;
            this.e = 0;
            this.f = null;
            this.g = -1;
            this.h = 400;
            this.i = 0.0f;
            this.k = new ArrayList();
            this.l = null;
            this.m = new ArrayList();
            this.n = 0;
            this.o = false;
            this.p = -1;
            this.q = 0;
            this.r = 0;
            this.h = iVar.l;
            this.q = iVar.m;
            this.j = iVar;
            w(iVar, context, Xml.asAttributeSet(xmlPullParser));
        }
    }
}
