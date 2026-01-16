package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.gov.nist.core.Separators;
import android.graphics.Rect;
import android.util.Xml;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.motion.widget.i;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import ir.nasim.AbstractC23607xC5;
import ir.nasim.C17935no3;
import ir.nasim.J22;
import ir.nasim.OA1;
import ir.nasim.SE5;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes2.dex */
public class k {
    private static String w = "ViewTransition";
    private int a;
    int e;
    c f;
    c.a g;
    private int j;
    private String k;
    Context o;
    private int b = -1;
    private boolean c = false;
    private int d = 0;
    private int h = -1;
    private int i = -1;
    private int l = 0;
    private String m = null;
    private int n = -1;
    private int p = -1;
    private int q = -1;
    private int r = -1;
    private int s = -1;
    private int t = -1;
    private int u = -1;
    private int v = -1;

    class a implements Interpolator {
        final /* synthetic */ J22 a;

        a(k kVar, J22 j22) {
            this.a = j22;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return (float) this.a.a(f);
        }
    }

    static class b {
        private final int a;
        private final int b;
        long c;
        g d;
        int e;
        int f;
        l h;
        Interpolator i;
        float k;
        float l;
        long m;
        boolean o;
        C17935no3 g = new C17935no3();
        boolean j = false;
        Rect n = new Rect();

        b(l lVar, g gVar, int i, int i2, int i3, Interpolator interpolator, int i4, int i5) {
            this.o = false;
            this.h = lVar;
            this.d = gVar;
            this.e = i;
            this.f = i2;
            long jNanoTime = System.nanoTime();
            this.c = jNanoTime;
            this.m = jNanoTime;
            this.h.b(this);
            this.i = interpolator;
            this.a = i4;
            this.b = i5;
            if (i3 == 3) {
                this.o = true;
            }
            this.l = i == 0 ? Float.MAX_VALUE : 1.0f / i;
            a();
        }

        void a() {
            if (this.j) {
                c();
            } else {
                b();
            }
        }

        void b() {
            long jNanoTime = System.nanoTime();
            long j = jNanoTime - this.m;
            this.m = jNanoTime;
            float f = this.k + (((float) (j * 1.0E-6d)) * this.l);
            this.k = f;
            if (f >= 1.0f) {
                this.k = 1.0f;
            }
            Interpolator interpolator = this.i;
            float interpolation = interpolator == null ? this.k : interpolator.getInterpolation(this.k);
            g gVar = this.d;
            boolean zX = gVar.x(gVar.b, interpolation, jNanoTime, this.g);
            if (this.k >= 1.0f) {
                if (this.a != -1) {
                    this.d.v().setTag(this.a, Long.valueOf(System.nanoTime()));
                }
                if (this.b != -1) {
                    this.d.v().setTag(this.b, null);
                }
                if (!this.o) {
                    this.h.g(this);
                }
            }
            if (this.k < 1.0f || zX) {
                this.h.e();
            }
        }

        void c() {
            long jNanoTime = System.nanoTime();
            long j = jNanoTime - this.m;
            this.m = jNanoTime;
            float f = this.k - (((float) (j * 1.0E-6d)) * this.l);
            this.k = f;
            if (f < 0.0f) {
                this.k = 0.0f;
            }
            Interpolator interpolator = this.i;
            float interpolation = interpolator == null ? this.k : interpolator.getInterpolation(this.k);
            g gVar = this.d;
            boolean zX = gVar.x(gVar.b, interpolation, jNanoTime, this.g);
            if (this.k <= 0.0f) {
                if (this.a != -1) {
                    this.d.v().setTag(this.a, Long.valueOf(System.nanoTime()));
                }
                if (this.b != -1) {
                    this.d.v().setTag(this.b, null);
                }
                this.h.g(this);
            }
            if (this.k > 0.0f || zX) {
                this.h.e();
            }
        }

        public void d(int i, float f, float f2) {
            if (i == 1) {
                if (this.j) {
                    return;
                }
                e(true);
            } else {
                if (i != 2) {
                    return;
                }
                this.d.v().getHitRect(this.n);
                if (this.n.contains((int) f, (int) f2) || this.j) {
                    return;
                }
                e(true);
            }
        }

        void e(boolean z) {
            int i;
            this.j = z;
            if (z && (i = this.f) != -1) {
                this.l = i == 0 ? Float.MAX_VALUE : 1.0f / i;
            }
            this.h.e();
            this.m = System.nanoTime();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    k(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.k.<init>(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(View[] viewArr) {
        if (this.p != -1) {
            for (View view : viewArr) {
                view.setTag(this.p, Long.valueOf(System.nanoTime()));
            }
        }
        if (this.q != -1) {
            for (View view2 : viewArr) {
                view2.setTag(this.q, null);
            }
        }
    }

    private void l(Context context, XmlPullParser xmlPullParser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), SE5.ViewTransition);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == SE5.ViewTransition_android_id) {
                this.a = typedArrayObtainStyledAttributes.getResourceId(index, this.a);
            } else if (index == SE5.ViewTransition_motionTarget) {
                if (MotionLayout.S1) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.j);
                    this.j = resourceId;
                    if (resourceId == -1) {
                        this.k = typedArrayObtainStyledAttributes.getString(index);
                    }
                } else if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                    this.k = typedArrayObtainStyledAttributes.getString(index);
                } else {
                    this.j = typedArrayObtainStyledAttributes.getResourceId(index, this.j);
                }
            } else if (index == SE5.ViewTransition_onStateTransition) {
                this.b = typedArrayObtainStyledAttributes.getInt(index, this.b);
            } else if (index == SE5.ViewTransition_transitionDisable) {
                this.c = typedArrayObtainStyledAttributes.getBoolean(index, this.c);
            } else if (index == SE5.ViewTransition_pathMotionArc) {
                this.d = typedArrayObtainStyledAttributes.getInt(index, this.d);
            } else if (index == SE5.ViewTransition_duration) {
                this.h = typedArrayObtainStyledAttributes.getInt(index, this.h);
            } else if (index == SE5.ViewTransition_upDuration) {
                this.i = typedArrayObtainStyledAttributes.getInt(index, this.i);
            } else if (index == SE5.ViewTransition_viewTransitionMode) {
                this.e = typedArrayObtainStyledAttributes.getInt(index, this.e);
            } else if (index == SE5.ViewTransition_motionInterpolator) {
                int i2 = typedArrayObtainStyledAttributes.peekValue(index).type;
                if (i2 == 1) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                    this.n = resourceId2;
                    if (resourceId2 != -1) {
                        this.l = -2;
                    }
                } else if (i2 == 3) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.m = string;
                    if (string == null || string.indexOf(Separators.SLASH) <= 0) {
                        this.l = -1;
                    } else {
                        this.n = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                        this.l = -2;
                    }
                } else {
                    this.l = typedArrayObtainStyledAttributes.getInteger(index, this.l);
                }
            } else if (index == SE5.ViewTransition_setsTag) {
                this.p = typedArrayObtainStyledAttributes.getResourceId(index, this.p);
            } else if (index == SE5.ViewTransition_clearsTag) {
                this.q = typedArrayObtainStyledAttributes.getResourceId(index, this.q);
            } else if (index == SE5.ViewTransition_ifTagSet) {
                this.r = typedArrayObtainStyledAttributes.getResourceId(index, this.r);
            } else if (index == SE5.ViewTransition_ifTagNotSet) {
                this.s = typedArrayObtainStyledAttributes.getResourceId(index, this.s);
            } else if (index == SE5.ViewTransition_SharedValueId) {
                this.u = typedArrayObtainStyledAttributes.getResourceId(index, this.u);
            } else if (index == SE5.ViewTransition_SharedValue) {
                this.t = typedArrayObtainStyledAttributes.getInteger(index, this.t);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void n(i.b bVar, View view) {
        int i = this.h;
        if (i != -1) {
            bVar.E(i);
        }
        bVar.H(this.d);
        bVar.F(this.l, this.m, this.n);
        int id = view.getId();
        c cVar = this.f;
        if (cVar != null) {
            ArrayList arrayListD = cVar.d(-1);
            c cVar2 = new c();
            Iterator it = arrayListD.iterator();
            while (it.hasNext()) {
                cVar2.c(((androidx.constraintlayout.motion.widget.a) it.next()).clone().i(id));
            }
            bVar.t(cVar2);
        }
    }

    void b(l lVar, MotionLayout motionLayout, View view) {
        g gVar = new g(view);
        gVar.B(view);
        this.f.a(gVar);
        gVar.I(motionLayout.getWidth(), motionLayout.getHeight(), this.h, System.nanoTime());
        new b(lVar, gVar, this.h, this.i, this.b, f(motionLayout.getContext()), this.p, this.q);
    }

    void c(l lVar, MotionLayout motionLayout, int i, androidx.constraintlayout.widget.c cVar, final View... viewArr) {
        if (this.c) {
            return;
        }
        int i2 = this.e;
        if (i2 == 2) {
            b(lVar, motionLayout, viewArr[0]);
            return;
        }
        if (i2 == 1) {
            for (int i3 : motionLayout.getConstraintSetIds()) {
                if (i3 != i) {
                    androidx.constraintlayout.widget.c cVarU0 = motionLayout.U0(i3);
                    for (View view : viewArr) {
                        c.a aVarY = cVarU0.y(view.getId());
                        c.a aVar = this.g;
                        if (aVar != null) {
                            aVar.d(aVarY);
                            aVarY.g.putAll(this.g.g);
                        }
                    }
                }
            }
        }
        androidx.constraintlayout.widget.c cVar2 = new androidx.constraintlayout.widget.c();
        cVar2.q(cVar);
        for (View view2 : viewArr) {
            c.a aVarY2 = cVar2.y(view2.getId());
            c.a aVar2 = this.g;
            if (aVar2 != null) {
                aVar2.d(aVarY2);
                aVarY2.g.putAll(this.g.g);
            }
        }
        motionLayout.q1(i, cVar2);
        motionLayout.q1(AbstractC23607xC5.view_transition, cVar);
        motionLayout.setState(AbstractC23607xC5.view_transition, -1, -1);
        i.b bVar = new i.b(-1, motionLayout.y, AbstractC23607xC5.view_transition, i);
        for (View view3 : viewArr) {
            n(bVar, view3);
        }
        motionLayout.setTransition(bVar);
        motionLayout.j1(new Runnable() { // from class: ir.nasim.TX7
            @Override // java.lang.Runnable
            public final void run() {
                this.a.j(viewArr);
            }
        });
    }

    boolean d(View view) {
        int i = this.r;
        boolean z = i == -1 || view.getTag(i) != null;
        int i2 = this.s;
        return z && (i2 == -1 || view.getTag(i2) == null);
    }

    int e() {
        return this.a;
    }

    Interpolator f(Context context) {
        int i = this.l;
        if (i == -2) {
            return AnimationUtils.loadInterpolator(context, this.n);
        }
        if (i == -1) {
            return new a(this, J22.c(this.m));
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

    public int g() {
        return this.t;
    }

    public int h() {
        return this.u;
    }

    public int i() {
        return this.b;
    }

    boolean k(View view) {
        String str;
        if (view == null) {
            return false;
        }
        if ((this.j == -1 && this.k == null) || !d(view)) {
            return false;
        }
        if (view.getId() == this.j) {
            return true;
        }
        return this.k != null && (view.getLayoutParams() instanceof ConstraintLayout.LayoutParams) && (str = ((ConstraintLayout.LayoutParams) view.getLayoutParams()).b0) != null && str.matches(this.k);
    }

    boolean m(int i) {
        int i2 = this.b;
        return i2 == 1 ? i == 0 : i2 == 2 ? i == 1 : i2 == 3 && i == 0;
    }

    public String toString() {
        String strC = OA1.c(this.o, this.a);
        StringBuilder sb = new StringBuilder(String.valueOf(strC).length() + 16);
        sb.append("ViewTransition(");
        sb.append(strC);
        sb.append(Separators.RPAREN);
        return sb.toString();
    }
}
