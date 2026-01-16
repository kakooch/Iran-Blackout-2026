package ir.nasim;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;

/* renamed from: ir.nasim.bY7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC10402bY7 {

    /* renamed from: ir.nasim.bY7$a */
    class a implements Runnable {
        final /* synthetic */ View a;

        a(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((InputMethodManager) this.a.getContext().getSystemService("input_method")).showSoftInput(this.a, 1);
        }
    }

    /* renamed from: ir.nasim.bY7$b */
    class b implements e {
        final /* synthetic */ boolean a;
        final /* synthetic */ boolean b;
        final /* synthetic */ boolean c;
        final /* synthetic */ e d;

        b(boolean z, boolean z2, boolean z3, e eVar) {
            this.a = z;
            this.b = z2;
            this.c = z3;
            this.d = eVar;
        }

        @Override // ir.nasim.AbstractC10402bY7.e
        public O98 a(View view, O98 o98, f fVar) {
            if (this.a) {
                fVar.d += o98.j();
            }
            boolean zJ = AbstractC10402bY7.j(view);
            if (this.b) {
                if (zJ) {
                    fVar.c += o98.k();
                } else {
                    fVar.a += o98.k();
                }
            }
            if (this.c) {
                if (zJ) {
                    fVar.a += o98.l();
                } else {
                    fVar.c += o98.l();
                }
            }
            fVar.a(view);
            e eVar = this.d;
            return eVar != null ? eVar.a(view, o98, fVar) : o98;
        }
    }

    /* renamed from: ir.nasim.bY7$c */
    class c implements InterfaceC22474vI4 {
        final /* synthetic */ e a;
        final /* synthetic */ f b;

        c(e eVar, f fVar) {
            this.a = eVar;
            this.b = fVar;
        }

        @Override // ir.nasim.InterfaceC22474vI4
        public O98 b(View view, O98 o98) {
            return this.a.a(view, o98, new f(this.b));
        }
    }

    /* renamed from: ir.nasim.bY7$e */
    public interface e {
        O98 a(View view, O98 o98, f fVar);
    }

    public static void a(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (view != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public static void b(View view, AttributeSet attributeSet, int i, int i2, e eVar) {
        TypedArray typedArrayObtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, GE5.Insets, i, i2);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(GE5.Insets_paddingBottomSystemWindowInsets, false);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(GE5.Insets_paddingLeftSystemWindowInsets, false);
        boolean z3 = typedArrayObtainStyledAttributes.getBoolean(GE5.Insets_paddingRightSystemWindowInsets, false);
        typedArrayObtainStyledAttributes.recycle();
        c(view, new b(z, z2, z3, eVar));
    }

    public static void c(View view, e eVar) {
        AbstractC12990fW7.E0(view, new c(eVar, new f(AbstractC12990fW7.F(view), view.getPaddingTop(), AbstractC12990fW7.E(view), view.getPaddingBottom())));
        n(view);
    }

    public static float d(Context context, int i) {
        return TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }

    public static Integer e(View view) {
        if (view.getBackground() instanceof ColorDrawable) {
            return Integer.valueOf(((ColorDrawable) view.getBackground()).getColor());
        }
        return null;
    }

    public static ViewGroup f(View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(android.R.id.content);
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView == view || !(rootView instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) rootView;
    }

    public static InterfaceC17181mX7 g(View view) {
        return h(f(view));
    }

    public static InterfaceC17181mX7 h(View view) {
        if (view == null) {
            return null;
        }
        return new C16590lX7(view);
    }

    public static float i(View view) {
        float fV = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            fV += AbstractC12990fW7.v((View) parent);
        }
        return fV;
    }

    public static boolean j(View view) {
        return AbstractC12990fW7.A(view) == 1;
    }

    public static PorterDuff.Mode k(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static void l(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (view != null) {
            m(view.getViewTreeObserver(), onGlobalLayoutListener);
        }
    }

    public static void m(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public static void n(View view) {
        if (AbstractC12990fW7.S(view)) {
            AbstractC12990fW7.m0(view);
        } else {
            view.addOnAttachStateChangeListener(new d());
        }
    }

    public static void o(View view) {
        view.requestFocus();
        view.post(new a(view));
    }

    /* renamed from: ir.nasim.bY7$f */
    public static class f {
        public int a;
        public int b;
        public int c;
        public int d;

        public f(int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        public void a(View view) {
            AbstractC12990fW7.F0(view, this.a, this.b, this.c, this.d);
        }

        public f(f fVar) {
            this.a = fVar.a;
            this.b = fVar.b;
            this.c = fVar.c;
            this.d = fVar.d;
        }
    }

    /* renamed from: ir.nasim.bY7$d */
    class d implements View.OnAttachStateChangeListener {
        d() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
            AbstractC12990fW7.m0(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }
}
