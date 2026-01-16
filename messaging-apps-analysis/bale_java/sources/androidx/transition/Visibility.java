package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import ir.nasim.AbstractC8958Xy7;
import ir.nasim.TB5;

/* loaded from: classes2.dex */
public abstract class Visibility extends Transition {
    private static final String[] B0 = {"android:visibility:visibility", "android:visibility:parent"};
    private int A0;

    class a extends q {
        final /* synthetic */ ViewGroup a;
        final /* synthetic */ View b;
        final /* synthetic */ View c;

        a(ViewGroup viewGroup, View view, View view2) {
            this.a = viewGroup;
            this.b = view;
            this.c = view2;
        }

        @Override // androidx.transition.q, androidx.transition.Transition.f
        public void a(Transition transition) {
            if (this.b.getParent() == null) {
                y.b(this.a).c(this.b);
            } else {
                Visibility.this.cancel();
            }
        }

        @Override // androidx.transition.q, androidx.transition.Transition.f
        public void c(Transition transition) {
            y.b(this.a).d(this.b);
        }

        @Override // androidx.transition.Transition.f
        public void d(Transition transition) {
            this.c.setTag(TB5.save_overlay_view, null);
            y.b(this.a).d(this.b);
            transition.W(this);
        }
    }

    private static class b extends AnimatorListenerAdapter implements Transition.f {
        private final View a;
        private final int b;
        private final ViewGroup c;
        private final boolean d;
        private boolean e;
        boolean f = false;

        b(View view, int i, boolean z) {
            this.a = view;
            this.b = i;
            this.c = (ViewGroup) view.getParent();
            this.d = z;
            g(true);
        }

        private void f() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
            if (!this.f) {
                B.i(this.a, this.b);
                ViewGroup viewGroup = this.c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            g(false);
        }

        private void g(boolean z) {
            ViewGroup viewGroup;
            if (!this.d || this.e == z || (viewGroup = this.c) == null) {
                return;
            }
            this.e = z;
            y.d(viewGroup, z);
        }

        @Override // androidx.transition.Transition.f
        public void a(Transition transition) {
            g(true);
        }

        @Override // androidx.transition.Transition.f
        public void b(Transition transition) {
        }

        @Override // androidx.transition.Transition.f
        public void c(Transition transition) {
            g(false);
        }

        @Override // androidx.transition.Transition.f
        public void d(Transition transition) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
            f();
            transition.W(this);
        }

        @Override // androidx.transition.Transition.f
        public void e(Transition transition) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
            f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
            if (this.f) {
                return;
            }
            B.i(this.a, this.b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
            if (this.f) {
                return;
            }
            B.i(this.a, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    private static class c {
        boolean a;
        boolean b;
        int c;
        int d;
        ViewGroup e;
        ViewGroup f;

        c() {
        }
    }

    public Visibility() {
        this.A0 = 3;
    }

    private void l0(t tVar) {
        tVar.a.put("android:visibility:visibility", Integer.valueOf(tVar.b.getVisibility()));
        tVar.a.put("android:visibility:parent", tVar.b.getParent());
        int[] iArr = new int[2];
        tVar.b.getLocationOnScreen(iArr);
        tVar.a.put("android:visibility:screenLocation", iArr);
    }

    private c n0(t tVar, t tVar2) {
        c cVar = new c();
        cVar.a = false;
        cVar.b = false;
        if (tVar == null || !tVar.a.containsKey("android:visibility:visibility")) {
            cVar.c = -1;
            cVar.e = null;
        } else {
            cVar.c = ((Integer) tVar.a.get("android:visibility:visibility")).intValue();
            cVar.e = (ViewGroup) tVar.a.get("android:visibility:parent");
        }
        if (tVar2 == null || !tVar2.a.containsKey("android:visibility:visibility")) {
            cVar.d = -1;
            cVar.f = null;
        } else {
            cVar.d = ((Integer) tVar2.a.get("android:visibility:visibility")).intValue();
            cVar.f = (ViewGroup) tVar2.a.get("android:visibility:parent");
        }
        if (tVar != null && tVar2 != null) {
            int i = cVar.c;
            int i2 = cVar.d;
            if (i == i2 && cVar.e == cVar.f) {
                return cVar;
            }
            if (i != i2) {
                if (i == 0) {
                    cVar.b = false;
                    cVar.a = true;
                } else if (i2 == 0) {
                    cVar.b = true;
                    cVar.a = true;
                }
            } else if (cVar.f == null) {
                cVar.b = false;
                cVar.a = true;
            } else if (cVar.e == null) {
                cVar.b = true;
                cVar.a = true;
            }
        } else if (tVar == null && cVar.d == 0) {
            cVar.b = true;
            cVar.a = true;
        } else if (tVar2 == null && cVar.c == 0) {
            cVar.b = false;
            cVar.a = true;
        }
        return cVar;
    }

    @Override // androidx.transition.Transition
    public String[] G() {
        return B0;
    }

    @Override // androidx.transition.Transition
    public boolean I(t tVar, t tVar2) {
        if (tVar == null && tVar2 == null) {
            return false;
        }
        if (tVar != null && tVar2 != null && tVar2.a.containsKey("android:visibility:visibility") != tVar.a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c cVarN0 = n0(tVar, tVar2);
        if (cVarN0.a) {
            return cVarN0.c == 0 || cVarN0.d == 0;
        }
        return false;
    }

    @Override // androidx.transition.Transition
    public void i(t tVar) {
        l0(tVar);
    }

    @Override // androidx.transition.Transition
    public void m(t tVar) {
        l0(tVar);
    }

    public int m0() {
        return this.A0;
    }

    public Animator o0(ViewGroup viewGroup, View view, t tVar, t tVar2) {
        return null;
    }

    public Animator p0(ViewGroup viewGroup, t tVar, int i, t tVar2, int i2) {
        if ((this.A0 & 1) != 1 || tVar2 == null) {
            return null;
        }
        if (tVar == null) {
            View view = (View) tVar2.b.getParent();
            if (n0(x(view, false), H(view, false)).a) {
                return null;
            }
        }
        return o0(viewGroup, tVar2.b, tVar, tVar2);
    }

    @Override // androidx.transition.Transition
    public Animator q(ViewGroup viewGroup, t tVar, t tVar2) {
        c cVarN0 = n0(tVar, tVar2);
        if (!cVarN0.a) {
            return null;
        }
        if (cVarN0.e == null && cVarN0.f == null) {
            return null;
        }
        return cVarN0.b ? p0(viewGroup, tVar, cVarN0.c, tVar2, cVarN0.d) : r0(viewGroup, tVar, cVarN0.c, tVar2, cVarN0.d);
    }

    public Animator q0(ViewGroup viewGroup, View view, t tVar, t tVar2) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0069 A[PHI: r2
      0x0069: PHI (r2v3 android.view.View) = 
      (r2v2 android.view.View)
      (r2v2 android.view.View)
      (r2v2 android.view.View)
      (r2v2 android.view.View)
      (r2v2 android.view.View)
      (r2v2 android.view.View)
      (r2v6 android.view.View)
     binds: [B:26:0x003e, B:31:0x004d, B:37:0x0076, B:39:0x0079, B:41:0x007f, B:43:0x0083, B:34:0x0065] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.animation.Animator r0(android.view.ViewGroup r11, androidx.transition.t r12, int r13, androidx.transition.t r14, int r15) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.r0(android.view.ViewGroup, androidx.transition.t, int, androidx.transition.t, int):android.animation.Animator");
    }

    public void t0(int i) {
        if ((i & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.A0 = i;
    }

    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.A0 = 3;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.e);
        int iG = AbstractC8958Xy7.g(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
        typedArrayObtainStyledAttributes.recycle();
        if (iG != 0) {
            t0(iG);
        }
    }
}
