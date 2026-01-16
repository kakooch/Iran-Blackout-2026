package ir.nasim;

import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import ir.nasim.C17227mc6;
import ja.burhanrashid52.photoeditor.Vector2D;

/* renamed from: ir.nasim.Ll4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class ViewOnTouchListenerC5933Ll4 implements View.OnTouchListener {
    public static final a v = new a(null);
    private final boolean a;
    private final GestureDetector b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final float f;
    private final float g;
    private int h;
    private float i;
    private float j;
    private float k;
    private float l;
    private final C17227mc6 m;
    private final int[] n;
    private Rect o;
    private final View p;
    private final ImageView q;
    private final RelativeLayout r;
    private c s;
    private final LJ4 t;
    private final C24159y85 u;

    /* renamed from: ir.nasim.Ll4$a */
    public static final class a {
        private a() {
        }

        private final float c(float f) {
            return f > 180.0f ? f - 360.0f : f < -180.0f ? f + 360.0f : f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(View view, float f, float f2) {
            float[] fArr = {f, f2};
            view.getMatrix().mapVectors(fArr);
            view.setTranslationX(view.getTranslationX() + fArr[0]);
            view.setTranslationY(view.getTranslationY() + fArr[1]);
        }

        private final void e(View view, float f, float f2) {
            if (view.getPivotX() == f && view.getPivotY() == f2) {
                return;
            }
            float[] fArr = {0.0f, 0.0f};
            view.getMatrix().mapPoints(fArr);
            view.setPivotX(f);
            view.setPivotY(f2);
            float[] fArr2 = {0.0f, 0.0f};
            view.getMatrix().mapPoints(fArr2);
            float f3 = fArr2[0] - fArr[0];
            float f4 = fArr2[1] - fArr[1];
            view.setTranslationX(view.getTranslationX() - f3);
            view.setTranslationY(view.getTranslationY() - f4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void f(View view, e eVar) {
            e(view, eVar.g(), eVar.h());
            d(view, eVar.c(), eVar.d());
            float fMax = Math.max(eVar.f(), Math.min(eVar.e(), view.getScaleX() * eVar.b()));
            view.setScaleX(fMax);
            view.setScaleY(fMax);
            view.setRotation(c(view.getRotation() + eVar.a()));
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Ll4$b */
    private final class b extends GestureDetector.SimpleOnGestureListener {
        final /* synthetic */ ViewOnTouchListenerC5933Ll4 a;

        public b(ViewOnTouchListenerC5933Ll4 viewOnTouchListenerC5933Ll4) {
            AbstractC13042fc3.i(viewOnTouchListenerC5933Ll4, "this$0");
            this.a = viewOnTouchListenerC5933Ll4;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            AbstractC13042fc3.i(motionEvent, "e");
            super.onLongPress(motionEvent);
            c cVar = this.a.s;
            if (cVar == null) {
                return;
            }
            cVar.b();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            AbstractC13042fc3.i(motionEvent, "e");
            c cVar = this.a.s;
            if (cVar == null) {
                return true;
            }
            cVar.a();
            return true;
        }
    }

    /* renamed from: ir.nasim.Ll4$c */
    public interface c {
        void a();

        void b();
    }

    /* renamed from: ir.nasim.Ll4$d */
    private final class d extends C17227mc6.c {
        private float a;
        private float b;
        private final Vector2D c;
        final /* synthetic */ ViewOnTouchListenerC5933Ll4 d;

        public d(ViewOnTouchListenerC5933Ll4 viewOnTouchListenerC5933Ll4) {
            AbstractC13042fc3.i(viewOnTouchListenerC5933Ll4, "this$0");
            this.d = viewOnTouchListenerC5933Ll4;
            this.c = new Vector2D();
        }

        @Override // ir.nasim.C17227mc6.b
        public boolean a(View view, C17227mc6 c17227mc6) {
            AbstractC13042fc3.i(view, "view");
            AbstractC13042fc3.i(c17227mc6, "detector");
            this.a = c17227mc6.d();
            this.b = c17227mc6.e();
            this.c.set(c17227mc6.c());
            return this.d.a;
        }

        @Override // ir.nasim.C17227mc6.b
        public boolean c(View view, C17227mc6 c17227mc6) {
            AbstractC13042fc3.i(view, "view");
            AbstractC13042fc3.i(c17227mc6, "detector");
            e eVar = new e(this.d);
            eVar.j(this.d.e ? c17227mc6.g() : 1.0f);
            eVar.i(this.d.c ? Vector2D.INSTANCE.a(this.c, c17227mc6.c()) : 0.0f);
            eVar.k(this.d.d ? c17227mc6.d() - this.a : 0.0f);
            eVar.l(this.d.d ? c17227mc6.e() - this.b : 0.0f);
            eVar.o(this.a);
            eVar.p(this.b);
            eVar.n(this.d.f);
            eVar.m(this.d.g);
            ViewOnTouchListenerC5933Ll4.v.f(view, eVar);
            return !this.d.a;
        }
    }

    /* renamed from: ir.nasim.Ll4$e */
    private final class e {
        private float a;
        private float b;
        private float c;
        private float d;
        private float e;
        private float f;
        private float g;
        private float h;
        final /* synthetic */ ViewOnTouchListenerC5933Ll4 i;

        public e(ViewOnTouchListenerC5933Ll4 viewOnTouchListenerC5933Ll4) {
            AbstractC13042fc3.i(viewOnTouchListenerC5933Ll4, "this$0");
            this.i = viewOnTouchListenerC5933Ll4;
        }

        public final float a() {
            return this.d;
        }

        public final float b() {
            return this.c;
        }

        public final float c() {
            return this.a;
        }

        public final float d() {
            return this.b;
        }

        public final float e() {
            return this.h;
        }

        public final float f() {
            return this.g;
        }

        public final float g() {
            return this.e;
        }

        public final float h() {
            return this.f;
        }

        public final void i(float f) {
            this.d = f;
        }

        public final void j(float f) {
            this.c = f;
        }

        public final void k(float f) {
            this.a = f;
        }

        public final void l(float f) {
            this.b = f;
        }

        public final void m(float f) {
            this.h = f;
        }

        public final void n(float f) {
            this.g = f;
        }

        public final void o(float f) {
            this.e = f;
        }

        public final void p(float f) {
            this.f = f;
        }
    }

    public ViewOnTouchListenerC5933Ll4(View view, RelativeLayout relativeLayout, ImageView imageView, boolean z, LJ4 lj4, C24159y85 c24159y85) {
        AbstractC13042fc3.i(relativeLayout, "parentView");
        AbstractC13042fc3.i(c24159y85, "viewState");
        this.a = z;
        this.c = true;
        this.d = true;
        this.e = true;
        this.f = 0.5f;
        this.g = 10.0f;
        this.h = -1;
        this.n = new int[2];
        this.m = new C17227mc6(new d(this));
        this.b = new GestureDetector(new b(this));
        this.p = view;
        this.r = relativeLayout;
        this.q = imageView;
        this.t = lj4;
        this.o = view != null ? new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) : new Rect(0, 0, 0, 0);
        this.u = c24159y85;
    }

    private final void h(View view, boolean z) {
        Object tag = view.getTag();
        LJ4 lj4 = this.t;
        if (lj4 == null || tag == null || !(tag instanceof ZX7)) {
            return;
        }
        if (z) {
            Object tag2 = view.getTag();
            if (tag2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type ja.burhanrashid52.photoeditor.ViewType");
            }
            lj4.O1((ZX7) tag2);
            return;
        }
        Object tag3 = view.getTag();
        if (tag3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type ja.burhanrashid52.photoeditor.ViewType");
        }
        lj4.F1((ZX7) tag3);
    }

    private final boolean i(View view, int i, int i2) {
        if (view == null) {
            return false;
        }
        view.getDrawingRect(this.o);
        view.getLocationOnScreen(this.n);
        Rect rect = this.o;
        if (rect != null) {
            int[] iArr = this.n;
            rect.offset(iArr[0], iArr[1]);
        }
        Rect rect2 = this.o;
        Boolean boolValueOf = rect2 == null ? null : Boolean.valueOf(rect2.contains(i, i2));
        if (boolValueOf == null) {
            return false;
        }
        return boolValueOf.booleanValue();
    }

    public final void j(c cVar) {
        this.s = cVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int iFindPointerIndex;
        AbstractC13042fc3.i(view, "view");
        AbstractC13042fc3.i(motionEvent, "event");
        this.m.i(view, motionEvent);
        this.b.onTouchEvent(motionEvent);
        if (!this.d) {
            return true;
        }
        int action = motionEvent.getAction();
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int actionMasked = motionEvent.getActionMasked() & action;
        if (actionMasked == 0) {
            this.i = motionEvent.getX();
            this.j = motionEvent.getY();
            this.k = motionEvent.getRawX();
            this.l = motionEvent.getRawY();
            this.h = motionEvent.getPointerId(0);
            View view2 = this.p;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            view.bringToFront();
            h(view, true);
        } else if (actionMasked == 1) {
            this.h = -1;
            View view3 = this.p;
            if ((view3 == null || !i(view3, rawX, rawY)) && !i(this.q, rawX, rawY)) {
                view.animate().translationY(0.0f).translationY(0.0f);
            }
            View view4 = this.p;
            if (view4 != null) {
                view4.setVisibility(8);
            }
            h(view, false);
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                this.h = -1;
            } else if (actionMasked == 6) {
                int i = (65280 & action) >> 8;
                if (motionEvent.getPointerId(i) == this.h) {
                    int i2 = i == 0 ? 1 : 0;
                    this.i = motionEvent.getX(i2);
                    this.j = motionEvent.getY(i2);
                    this.h = motionEvent.getPointerId(i2);
                }
            }
        } else if (view == this.u.h() && (iFindPointerIndex = motionEvent.findPointerIndex(this.h)) != -1) {
            float x = motionEvent.getX(iFindPointerIndex);
            float y = motionEvent.getY(iFindPointerIndex);
            if (!this.m.h()) {
                v.d(view, x - this.i, y - this.j);
            }
        }
        return true;
    }
}
