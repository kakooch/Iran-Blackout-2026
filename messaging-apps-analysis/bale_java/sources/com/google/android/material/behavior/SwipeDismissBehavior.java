package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.C22013uW7;
import ir.nasim.InterfaceC10698c3;
import ir.nasim.X2;

/* loaded from: classes3.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    C22013uW7 a;
    c b;
    private boolean c;
    private boolean e;
    private float d = 0.0f;
    int f = 2;
    float g = 0.5f;
    float h = 0.0f;
    float i = 0.5f;
    private final C22013uW7.c j = new a();

    class a extends C22013uW7.c {
        private int a;
        private int b = -1;

        a() {
        }

        private boolean n(View view, float f) {
            if (f == 0.0f) {
                return Math.abs(view.getLeft() - this.a) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.g);
            }
            boolean z = AbstractC12990fW7.A(view) == 1;
            int i = SwipeDismissBehavior.this.f;
            if (i == 2) {
                return true;
            }
            if (i == 0) {
                if (z) {
                    if (f >= 0.0f) {
                        return false;
                    }
                } else if (f <= 0.0f) {
                    return false;
                }
                return true;
            }
            if (i != 1) {
                return false;
            }
            if (z) {
                if (f <= 0.0f) {
                    return false;
                }
            } else if (f >= 0.0f) {
                return false;
            }
            return true;
        }

        @Override // ir.nasim.C22013uW7.c
        public int a(View view, int i, int i2) {
            int width;
            int width2;
            int width3;
            boolean z = AbstractC12990fW7.A(view) == 1;
            int i3 = SwipeDismissBehavior.this.f;
            if (i3 == 0) {
                if (z) {
                    width = this.a - view.getWidth();
                    width2 = this.a;
                } else {
                    width = this.a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i3 != 1) {
                width = this.a - view.getWidth();
                width2 = view.getWidth() + this.a;
            } else if (z) {
                width = this.a;
                width3 = view.getWidth();
                width2 = width3 + width;
            } else {
                width = this.a - view.getWidth();
                width2 = this.a;
            }
            return SwipeDismissBehavior.G(width, i, width2);
        }

        @Override // ir.nasim.C22013uW7.c
        public int b(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // ir.nasim.C22013uW7.c
        public int d(View view) {
            return view.getWidth();
        }

        @Override // ir.nasim.C22013uW7.c
        public void i(View view, int i) {
            this.b = i;
            this.a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // ir.nasim.C22013uW7.c
        public void j(int i) {
            c cVar = SwipeDismissBehavior.this.b;
            if (cVar != null) {
                cVar.b(i);
            }
        }

        @Override // ir.nasim.C22013uW7.c
        public void k(View view, int i, int i2, int i3, int i4) {
            float width = this.a + (view.getWidth() * SwipeDismissBehavior.this.h);
            float width2 = this.a + (view.getWidth() * SwipeDismissBehavior.this.i);
            float f = i;
            if (f <= width) {
                view.setAlpha(1.0f);
            } else if (f >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.F(0.0f, 1.0f - SwipeDismissBehavior.I(width, width2, f), 1.0f));
            }
        }

        @Override // ir.nasim.C22013uW7.c
        public void l(View view, float f, float f2) {
            int i;
            boolean z;
            c cVar;
            this.b = -1;
            int width = view.getWidth();
            if (n(view, f)) {
                int left = view.getLeft();
                int i2 = this.a;
                i = left < i2 ? i2 - width : i2 + width;
                z = true;
            } else {
                i = this.a;
                z = false;
            }
            if (SwipeDismissBehavior.this.a.P(i, view.getTop())) {
                AbstractC12990fW7.h0(view, new d(view, z));
            } else {
                if (!z || (cVar = SwipeDismissBehavior.this.b) == null) {
                    return;
                }
                cVar.a(view);
            }
        }

        @Override // ir.nasim.C22013uW7.c
        public boolean m(View view, int i) {
            int i2 = this.b;
            return (i2 == -1 || i2 == i) && SwipeDismissBehavior.this.E(view);
        }
    }

    class b implements InterfaceC10698c3 {
        b() {
        }

        @Override // ir.nasim.InterfaceC10698c3
        public boolean a(View view, InterfaceC10698c3.a aVar) {
            if (!SwipeDismissBehavior.this.E(view)) {
                return false;
            }
            boolean z = AbstractC12990fW7.A(view) == 1;
            int i = SwipeDismissBehavior.this.f;
            AbstractC12990fW7.Z(view, (!(i == 0 && z) && (i != 1 || z)) ? view.getWidth() : -view.getWidth());
            view.setAlpha(0.0f);
            c cVar = SwipeDismissBehavior.this.b;
            if (cVar != null) {
                cVar.a(view);
            }
            return true;
        }
    }

    public interface c {
        void a(View view);

        void b(int i);
    }

    private class d implements Runnable {
        private final View a;
        private final boolean b;

        d(View view, boolean z) {
            this.a = view;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar;
            C22013uW7 c22013uW7 = SwipeDismissBehavior.this.a;
            if (c22013uW7 != null && c22013uW7.n(true)) {
                AbstractC12990fW7.h0(this.a, this);
            } else {
                if (!this.b || (cVar = SwipeDismissBehavior.this.b) == null) {
                    return;
                }
                cVar.a(this.a);
            }
        }
    }

    static float F(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    static int G(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    private void H(ViewGroup viewGroup) {
        if (this.a == null) {
            this.a = this.e ? C22013uW7.o(viewGroup, this.d, this.j) : C22013uW7.p(viewGroup, this.j);
        }
    }

    static float I(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }

    private void N(View view) {
        AbstractC12990fW7.j0(view, 1048576);
        if (E(view)) {
            AbstractC12990fW7.l0(view, X2.a.y, null, new b());
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean D(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        C22013uW7 c22013uW7 = this.a;
        if (c22013uW7 == null) {
            return false;
        }
        c22013uW7.G(motionEvent);
        return true;
    }

    public boolean E(View view) {
        return true;
    }

    public void J(float f) {
        this.i = F(0.0f, f, 1.0f);
    }

    public void K(c cVar) {
        this.b = cVar;
    }

    public void L(float f) {
        this.h = F(0.0f, f, 1.0f);
    }

    public void M(int i) {
        this.f = i;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean zF = this.c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            zF = coordinatorLayout.F(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.c = zF;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.c = false;
        }
        if (!zF) {
            return false;
        }
        H(coordinatorLayout);
        return this.a.Q(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
        boolean zL = super.l(coordinatorLayout, view, i);
        if (AbstractC12990fW7.y(view) == 0) {
            AbstractC12990fW7.A0(view, 1);
            N(view);
        }
        return zL;
    }
}
