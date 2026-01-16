package com.google.android.material.bottomsheet;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC21175tE5;
import ir.nasim.C10345bV3;
import ir.nasim.C22317v2;
import ir.nasim.InterfaceC22474vI4;
import ir.nasim.O98;
import ir.nasim.WB5;
import ir.nasim.WU3;
import ir.nasim.X2;
import ir.nasim.YC5;
import ir.nasim.YD;

/* loaded from: classes3.dex */
public class a extends YD {
    private BottomSheetBehavior f;
    private FrameLayout g;
    private CoordinatorLayout h;
    private FrameLayout i;
    boolean j;
    boolean k;
    private boolean l;
    private boolean m;
    private BottomSheetBehavior.f n;
    private boolean o;
    private BottomSheetBehavior.f p;

    /* renamed from: com.google.android.material.bottomsheet.a$a, reason: collision with other inner class name */
    class C0177a implements InterfaceC22474vI4 {
        C0177a() {
        }

        @Override // ir.nasim.InterfaceC22474vI4
        public O98 b(View view, O98 o98) {
            if (a.this.n != null) {
                a.this.f.r0(a.this.n);
            }
            if (o98 != null) {
                a aVar = a.this;
                aVar.n = new f(aVar.i, o98, null);
                a.this.f.W(a.this.n);
            }
            return o98;
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            if (aVar.k && aVar.isShowing() && a.this.t()) {
                a.this.cancel();
            }
        }
    }

    class c extends C22317v2 {
        c() {
        }

        @Override // ir.nasim.C22317v2
        public void g(View view, X2 x2) {
            super.g(view, x2);
            if (!a.this.k) {
                x2.v0(false);
            } else {
                x2.a(1048576);
                x2.v0(true);
            }
        }

        @Override // ir.nasim.C22317v2
        public boolean j(View view, int i, Bundle bundle) {
            if (i == 1048576) {
                a aVar = a.this;
                if (aVar.k) {
                    aVar.cancel();
                    return true;
                }
            }
            return super.j(view, i, bundle);
        }
    }

    class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    class e extends BottomSheetBehavior.f {
        e() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void b(View view, float f) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void c(View view, int i) {
            if (i == 5) {
                a.this.cancel();
            }
        }
    }

    private static class f extends BottomSheetBehavior.f {
        private final boolean a;
        private final boolean b;
        private final O98 c;

        /* synthetic */ f(View view, O98 o98, C0177a c0177a) {
            this(view, o98);
        }

        private void d(View view) {
            if (view.getTop() < this.c.m()) {
                a.s(view, this.a);
                view.setPadding(view.getPaddingLeft(), this.c.m() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
            } else if (view.getTop() != 0) {
                a.s(view, this.b);
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        void a(View view) {
            d(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void b(View view, float f) {
            d(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void c(View view, int i) {
            d(view);
        }

        private f(View view, O98 o98) {
            this.c = o98;
            boolean z = (view.getSystemUiVisibility() & 8192) != 0;
            this.b = z;
            C10345bV3 c10345bV3I0 = BottomSheetBehavior.f0(view).i0();
            ColorStateList colorStateListX = c10345bV3I0 != null ? c10345bV3I0.x() : AbstractC12990fW7.r(view);
            if (colorStateListX != null) {
                this.a = WU3.f(colorStateListX.getDefaultColor());
            } else if (view.getBackground() instanceof ColorDrawable) {
                this.a = WU3.f(((ColorDrawable) view.getBackground()).getColor());
            } else {
                this.a = z;
            }
        }
    }

    public a(Context context) {
        this(context, 0);
        this.o = getContext().getTheme().obtainStyledAttributes(new int[]{AbstractC12181eA5.enableEdgeToEdge}).getBoolean(0, false);
    }

    private static int f(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(AbstractC12181eA5.bottomSheetDialogTheme, typedValue, true) ? typedValue.resourceId : AbstractC21175tE5.Theme_Design_Light_BottomSheetDialog;
    }

    private FrameLayout m() {
        if (this.g == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), YC5.design_bottom_sheet_dialog, null);
            this.g = frameLayout;
            this.h = (CoordinatorLayout) frameLayout.findViewById(WB5.coordinator);
            FrameLayout frameLayout2 = (FrameLayout) this.g.findViewById(WB5.design_bottom_sheet);
            this.i = frameLayout2;
            BottomSheetBehavior bottomSheetBehaviorF0 = BottomSheetBehavior.f0(frameLayout2);
            this.f = bottomSheetBehaviorF0;
            bottomSheetBehaviorF0.W(this.p);
            this.f.C0(this.k);
        }
        return this.g;
    }

    public static void s(View view, boolean z) {
        int systemUiVisibility = view.getSystemUiVisibility();
        view.setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
    }

    private View u(int i, View view, ViewGroup.LayoutParams layoutParams) {
        m();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.g.findViewById(WB5.coordinator);
        if (i != 0 && view == null) {
            view = getLayoutInflater().inflate(i, (ViewGroup) coordinatorLayout, false);
        }
        if (this.o) {
            AbstractC12990fW7.E0(this.i, new C0177a());
        }
        this.i.removeAllViews();
        if (layoutParams == null) {
            this.i.addView(view);
        } else {
            this.i.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(WB5.touch_outside).setOnClickListener(new b());
        AbstractC12990fW7.p0(this.i, new c());
        this.i.setOnTouchListener(new d());
        return this.g;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior bottomSheetBehaviorO = o();
        if (!this.j || bottomSheetBehaviorO.k0() == 5) {
            super.cancel();
        } else {
            bottomSheetBehaviorO.J0(5);
        }
    }

    public BottomSheetBehavior o() {
        if (this.f == null) {
            m();
        }
        return this.f;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            boolean z = this.o && Color.alpha(window.getNavigationBarColor()) < 255;
            FrameLayout frameLayout = this.g;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z);
            }
            CoordinatorLayout coordinatorLayout = this.h;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z);
            }
            if (z) {
                window.getDecorView().setSystemUiVisibility(768);
            }
        }
    }

    @Override // ir.nasim.YD, ir.nasim.V01, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(0);
            window.addFlags(RecyclerView.UNDEFINED_DURATION);
            window.setLayout(-1, -1);
        }
    }

    @Override // ir.nasim.V01, android.app.Dialog
    protected void onStart() {
        super.onStart();
        BottomSheetBehavior bottomSheetBehavior = this.f;
        if (bottomSheetBehavior == null || bottomSheetBehavior.k0() != 5) {
            return;
        }
        this.f.J0(4);
    }

    public boolean p() {
        return this.j;
    }

    void q() {
        this.f.r0(this.p);
    }

    public void r(boolean z) {
        this.j = z;
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.k != z) {
            this.k = z;
            BottomSheetBehavior bottomSheetBehavior = this.f;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.C0(z);
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.k) {
            this.k = true;
        }
        this.l = z;
        this.m = true;
    }

    @Override // ir.nasim.YD, ir.nasim.V01, android.app.Dialog
    public void setContentView(int i) {
        super.setContentView(u(i, null, null));
    }

    boolean t() {
        if (!this.m) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
            this.l = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
            this.m = true;
        }
        return this.l;
    }

    @Override // ir.nasim.YD, ir.nasim.V01, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(u(0, view, null));
    }

    @Override // ir.nasim.YD, ir.nasim.V01, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(u(0, view, layoutParams));
    }

    public a(Context context, int i) {
        super(context, f(context, i));
        this.k = true;
        this.l = true;
        this.p = new e();
        h(1);
        this.o = getContext().getTheme().obtainStyledAttributes(new int[]{AbstractC12181eA5.enableEdgeToEdge}).getBoolean(0, false);
    }
}
