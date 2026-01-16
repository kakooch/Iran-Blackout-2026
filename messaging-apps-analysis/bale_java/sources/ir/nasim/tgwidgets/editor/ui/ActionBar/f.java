package ir.nasim.tgwidgets.editor.ui.ActionBar;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.Property;
import android.util.Size;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.C22477vI7;
import ir.nasim.FH3;
import ir.nasim.TD5;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.E;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.xbill.DNS.Type;

/* loaded from: classes7.dex */
public final class f {
    private static final MenuItem.OnMenuItemClickListener n = new MenuItem.OnMenuItemClickListener() { // from class: ir.nasim.zq2
        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem menuItem) {
            return ir.nasim.tgwidgets.editor.ui.ActionBar.f.y(menuItem);
        }
    };
    private final View a;
    private final b b;
    private Menu e;
    private int h;
    private int j;
    private final m.h m;
    private final Rect c = new Rect();
    private final Rect d = new Rect();
    private List f = new ArrayList();
    private MenuItem.OnMenuItemClickListener g = n;
    private boolean i = true;
    private final View.OnLayoutChangeListener k = new a();
    private final Comparator l = new Comparator() { // from class: ir.nasim.yq2
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ir.nasim.tgwidgets.editor.ui.ActionBar.f.x((MenuItem) obj, (MenuItem) obj2);
        }
    };

    class a implements View.OnLayoutChangeListener {
        private final Rect a = new Rect();
        private final Rect b = new Rect();

        a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.a.set(i, i2, i3, i4);
            this.b.set(i5, i6, i7, i8);
            if (!f.this.b.M() || this.a.equals(this.b)) {
                return;
            }
            f.this.i = true;
            f.this.F();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class b {
        private final int B;
        private final int C;
        private boolean F;
        private final Size G;
        private Size H;
        private Size I;
        private MenuItem.OnMenuItemClickListener J;
        private boolean L;
        private boolean M;
        private int N;
        private final Context a;
        private final View b;
        private final PopupWindow c;
        private final int d;
        private final int e;
        private final ViewGroup f;
        private final ViewGroup g;
        private final o h;
        private final ImageButton i;
        private final Drawable j;
        private final Drawable k;
        private final AnimatedVectorDrawable l;
        private final AnimatedVectorDrawable m;
        private final p n;
        private final Interpolator o;
        private final Interpolator p;
        private final Interpolator q;
        private final Interpolator r;
        private final AnimatorSet s;
        private final AnimatorSet t;
        private final AnimatorSet u;
        private final AnimationSet v;
        private final AnimationSet w;
        private final Rect x = new Rect();
        private final Point y = new Point();
        private final int[] z = new int[2];
        private final Region A = new Region();
        private final Runnable D = new e();
        private boolean E = true;
        private final View.OnClickListener K = new ViewOnClickListenerC1582f();

        class a extends Animation {
            final /* synthetic */ float a;
            final /* synthetic */ float b;
            final /* synthetic */ int c;

            a(float f, float f2, int i) {
                this.a = f;
                this.b = f2;
                this.c = i;
            }

            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                float f2 = this.a;
                b.this.i.setX(f2 + (f * (this.b - f2)) + (b.this.K() ? 0.0f : b.this.f.getWidth() - this.c));
            }
        }

        /* renamed from: ir.nasim.tgwidgets.editor.ui.ActionBar.f$b$b, reason: collision with other inner class name */
        class C1581b extends LinearLayout {
            C1581b(Context context) {
                super(context);
            }

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                return b.this.L();
            }

            @Override // android.widget.LinearLayout, android.view.View
            protected void onMeasure(int i, int i2) {
                if (b.this.L() && b.this.I != null) {
                    i = View.MeasureSpec.makeMeasureSpec(b.this.I.getWidth(), 1073741824);
                }
                super.onMeasure(i, i2);
            }
        }

        class c extends ArrayAdapter {
            c(Context context, int i) {
                super(context, i);
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i, View view, ViewGroup viewGroup) {
                return b.this.n.c((MenuItem) getItem(i), b.this.H.getWidth(), view);
            }
        }

        class d implements Animation.AnimationListener {
            d() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void b() {
                b.this.f0();
                b.this.d0();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.f.post(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.ActionBar.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.b();
                    }
                });
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                b.this.i.setEnabled(false);
                b.this.g.setVisibility(0);
                b.this.h.setVisibility(0);
            }
        }

        class e implements Runnable {
            e() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f0();
                b.this.d0();
                b.this.f.setAlpha(1.0f);
            }
        }

        /* renamed from: ir.nasim.tgwidgets.editor.ui.ActionBar.f$b$f, reason: collision with other inner class name */
        class ViewOnClickListenerC1582f implements View.OnClickListener {
            ViewOnClickListenerC1582f() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!(view.getTag() instanceof MenuItem) || b.this.J == null) {
                    return;
                }
                b.this.J.onMenuItemClick((MenuItem) view.getTag());
            }
        }

        class g extends AnimatorListenerAdapter {
            final /* synthetic */ f a;

            g(f fVar) {
                this.a = fVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void b() {
                b.this.c.dismiss();
                b.this.f.removeAllViews();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                E.k(C22477vI7.f).h(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.ActionBar.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.b();
                    }
                });
            }
        }

        class h extends AnimatorListenerAdapter {
            final /* synthetic */ f a;

            h(f fVar) {
                this.a = fVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void b() {
                b.this.c.dismiss();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                E.k(C22477vI7.f).h(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.ActionBar.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.b();
                    }
                });
            }
        }

        class i extends Animation {
            final /* synthetic */ int a;
            final /* synthetic */ int b;
            final /* synthetic */ float c;
            final /* synthetic */ float d;

            i(int i, int i2, float f, float f2) {
                this.a = i;
                this.b = i2;
                this.c = f;
                this.d = f2;
            }

            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                b bVar = b.this;
                bVar.j0(bVar.f, this.b + ((int) (f * (this.a - this.b))));
                if (b.this.K()) {
                    b.this.f.setX(this.c);
                    b.this.g.setX(0.0f);
                    b.this.h.setX(0.0f);
                } else {
                    b.this.f.setX(this.d - b.this.f.getWidth());
                    b.this.g.setX(b.this.f.getWidth() - this.b);
                    b.this.h.setX(b.this.f.getWidth() - this.a);
                }
            }
        }

        class j extends Animation {
            final /* synthetic */ int a;
            final /* synthetic */ int b;
            final /* synthetic */ float c;

            j(int i, int i2, float f) {
                this.a = i;
                this.b = i2;
                this.c = f;
            }

            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                b bVar = b.this;
                bVar.e0(bVar.f, this.b + ((int) (f * (this.a - this.b))));
                if (b.this.L) {
                    b.this.f.setY(this.c - (b.this.f.getHeight() - this.b));
                    b.this.V();
                }
            }
        }

        class k extends Animation {
            final /* synthetic */ float a;
            final /* synthetic */ float b;
            final /* synthetic */ int c;

            k(float f, float f2, int i) {
                this.a = f;
                this.b = f2;
                this.c = i;
            }

            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                float f2 = this.a;
                b.this.i.setX(f2 + (f * (this.b - f2)) + (b.this.K() ? 0.0f : b.this.f.getWidth() - this.c));
            }
        }

        class l extends Animation {
            final /* synthetic */ int a;
            final /* synthetic */ int b;
            final /* synthetic */ float c;
            final /* synthetic */ float d;

            l(int i, int i2, float f, float f2) {
                this.a = i;
                this.b = i2;
                this.c = f;
                this.d = f2;
            }

            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                b bVar = b.this;
                bVar.j0(bVar.f, this.b + ((int) (f * (this.a - this.b))));
                if (b.this.K()) {
                    b.this.f.setX(this.c);
                    b.this.g.setX(0.0f);
                    b.this.h.setX(0.0f);
                } else {
                    b.this.f.setX(this.d - b.this.f.getWidth());
                    b.this.g.setX(b.this.f.getWidth() - this.a);
                    b.this.h.setX(b.this.f.getWidth() - this.b);
                }
            }
        }

        class m extends Animation {
            final /* synthetic */ int a;
            final /* synthetic */ int b;
            final /* synthetic */ float c;

            m(int i, int i2, float f) {
                this.a = i;
                this.b = i2;
                this.c = f;
            }

            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                b bVar = b.this;
                bVar.e0(bVar.f, this.b + ((int) (f * (this.a - this.b))));
                if (b.this.L) {
                    b.this.f.setY(this.c - b.this.f.getHeight());
                    b.this.V();
                }
            }
        }

        private final class n implements Interpolator {
            private final int a;
            private final float b;

            private float a(float f, int i) {
                return (float) (1.0d - Math.pow(i, -f));
            }

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return 1.0f - (a(1.0f - f, 100) * this.b);
            }

            private n() {
                this.a = 100;
                this.b = 1.0f / a(1.0f, 100);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        final class o extends ListView {
            private final b a;

            class a extends ViewOutlineProvider {
                final /* synthetic */ b a;

                a(b bVar) {
                    this.a = bVar;
                }

                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) {
                    outline.setRoundRect(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight() + AbstractC21455b.F(6.0f), AbstractC21455b.F(6.0f));
                }
            }

            o(b bVar) {
                super(bVar.a);
                this.a = bVar;
                setVerticalScrollBarEnabled(false);
                setOutlineProvider(new a(b.this));
                setClipToOutline(true);
            }

            @Override // android.view.View
            protected boolean awakenScrollBars() {
                return super.awakenScrollBars();
            }

            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                if (this.a.L()) {
                    return true;
                }
                return super.dispatchTouchEvent(motionEvent);
            }

            @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
            protected void onMeasure(int i, int i2) {
                super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.a.H.getHeight() - this.a.G.getHeight(), 1073741824));
            }
        }

        private final class p {
            private final int b;
            private final Context d;
            private final int c = AbstractC21455b.F(18.0f);
            private final View a = b(null);

            public p(Context context, int i) {
                this.d = context;
                this.b = i;
            }

            private View b(MenuItem menuItem) {
                View viewP = f.this.p(this.d, menuItem, this.b, false, false);
                int i = this.c;
                viewP.setPadding(i, 0, i, 0);
                return viewP;
            }

            public int a(MenuItem menuItem) {
                f.G(this.a, menuItem, this.b);
                this.a.measure(0, 0);
                return this.a.getMeasuredWidth();
            }

            public View c(MenuItem menuItem, int i, View view) {
                if (view != null) {
                    f.G(view, menuItem, this.b);
                } else {
                    view = b(menuItem);
                }
                view.setMinimumWidth(i);
                return view;
            }
        }

        public b(Context context, View view) {
            this.b = view;
            this.a = context;
            ViewGroup viewGroupM = f.this.m(context);
            this.f = viewGroupM;
            this.c = f.q(viewGroupM);
            this.d = AbstractC21455b.F(16.0f);
            this.e = AbstractC21455b.F(8.0f);
            this.B = AbstractC21455b.F(48.0f);
            int iF = AbstractC21455b.F(8.0f);
            this.C = iF;
            this.o = new n();
            this.p = AnimationUtils.loadInterpolator(context, R.interpolator.fast_out_slow_in);
            this.q = AnimationUtils.loadInterpolator(context, R.interpolator.linear_out_slow_in);
            this.r = AnimationUtils.loadInterpolator(context, R.interpolator.fast_out_linear_in);
            Drawable drawableMutate = context.getDrawable(AbstractC23598xB5.ft_avd_tooverflow).mutate();
            this.j = drawableMutate;
            drawableMutate.setAutoMirrored(true);
            Drawable drawableMutate2 = context.getDrawable(AbstractC23598xB5.ft_avd_toarrow).mutate();
            this.k = drawableMutate2;
            drawableMutate2.setAutoMirrored(true);
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) context.getDrawable(AbstractC23598xB5.ft_avd_toarrow_animation).mutate();
            this.l = animatedVectorDrawable;
            animatedVectorDrawable.setAutoMirrored(true);
            AnimatedVectorDrawable animatedVectorDrawable2 = (AnimatedVectorDrawable) context.getDrawable(AbstractC23598xB5.ft_avd_tooverflow_animation).mutate();
            this.m = animatedVectorDrawable2;
            animatedVectorDrawable2.setAutoMirrored(true);
            ImageButton imageButtonC = C();
            this.i = imageButtonC;
            this.G = T(imageButtonC);
            this.g = A();
            this.n = new p(context, iF);
            this.h = D();
            Animation.AnimationListener animationListenerB = B();
            AnimationSet animationSet = new AnimationSet(true);
            this.v = animationSet;
            animationSet.setAnimationListener(animationListenerB);
            AnimationSet animationSet2 = new AnimationSet(true);
            this.w = animationSet2;
            animationSet2.setAnimationListener(animationListenerB);
            this.s = f.n(viewGroupM);
            this.t = f.o(viewGroupM, 150, new g(f.this));
            this.u = f.o(viewGroupM, 0, new h(f.this));
        }

        private ViewGroup A() {
            return new C1581b(this.a);
        }

        private Animation.AnimationListener B() {
            return new d();
        }

        private ImageButton C() {
            int iT;
            final ImageButton imageButton = new ImageButton(this.a);
            imageButton.setLayoutParams(new ViewGroup.LayoutParams(AbstractC21455b.F(56.0f), AbstractC21455b.F(48.0f)));
            imageButton.setPaddingRelative(AbstractC21455b.F(16.0f), AbstractC21455b.F(12.0f), AbstractC21455b.F(16.0f), AbstractC21455b.F(12.0f));
            imageButton.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageButton.setImageDrawable(this.k);
            if (f.this.j == 0) {
                iT = f.this.t(ir.nasim.tgwidgets.editor.ui.ActionBar.m.V3);
                imageButton.setBackgroundDrawable(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Z(f.this.t(ir.nasim.tgwidgets.editor.ui.ActionBar.m.S4), 1));
            } else if (f.this.j == 2) {
                imageButton.setBackgroundDrawable(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Z(1090519039, 1));
                iT = -328966;
            } else {
                iT = f.this.t(ir.nasim.tgwidgets.editor.ui.ActionBar.m.p5);
                imageButton.setBackgroundDrawable(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Z(f.this.t(ir.nasim.tgwidgets.editor.ui.ActionBar.m.S4), 1));
            }
            this.k.setTint(iT);
            this.j.setTint(iT);
            this.l.setTint(iT);
            this.m.setTint(iT);
            imageButton.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.tgwidgets.editor.ui.ActionBar.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.N(imageButton, view);
                }
            });
            return imageButton;
        }

        private o D() {
            final o oVar = new o(this);
            oVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            oVar.setDivider(null);
            oVar.setDividerHeight(0);
            oVar.setAdapter((ListAdapter) new c(this.a, 0));
            oVar.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: ir.nasim.tgwidgets.editor.ui.ActionBar.g
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
                    this.a.O(oVar, adapterView, view, i2, j2);
                }
            });
            return oVar;
        }

        private int F(int i2) {
            int i3 = this.N;
            return i3 < 150 ? Math.max(i2 - 50, 0) : i3 > 300 ? i2 + 50 : i2;
        }

        private int G(int i2) {
            Y();
            int iWidth = this.x.width() - (AbstractC21455b.F(16.0f) * 2);
            if (i2 <= 0) {
                i2 = AbstractC21455b.F(400.0f);
            }
            return Math.min(i2, iWidth);
        }

        private int H() {
            int count = this.h.getAdapter().getCount();
            int iMax = 0;
            for (int i2 = 0; i2 < count; i2++) {
                iMax = Math.max(this.n.a((MenuItem) this.h.getAdapter().getItem(i2)), iMax);
            }
            return iMax;
        }

        private boolean I() {
            return this.H != null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean K() {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean L() {
            return (this.v.hasStarted() && !this.v.hasEnded()) || (this.w.hasStarted() && !this.w.hasEnded());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void N(ImageButton imageButton, View view) {
            if (this.M) {
                imageButton.setImageDrawable(this.m);
                this.m.start();
                z();
            } else {
                imageButton.setImageDrawable(this.l);
                this.l.start();
                U();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void O(o oVar, AdapterView adapterView, View view, int i2, long j2) {
            MenuItem menuItem = (MenuItem) oVar.getAdapter().getItem(i2);
            MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.J;
            if (onMenuItemClickListener != null) {
                onMenuItemClickListener.onMenuItemClick(menuItem);
            }
        }

        private void R(List list) {
            ArrayAdapter arrayAdapter = (ArrayAdapter) this.h.getAdapter();
            arrayAdapter.clear();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayAdapter.add((MenuItem) list.get(i2));
            }
            this.h.setAdapter((ListAdapter) arrayAdapter);
            if (this.L) {
                this.h.setY(0.0f);
            } else {
                this.h.setY(this.G.getHeight());
            }
            Size size2 = new Size(Math.max(H(), this.G.getWidth()), v(4));
            this.H = size2;
            h0(this.h, size2);
        }

        private void S() {
            Size size = this.I;
            if (size == null || this.H == null) {
                return;
            }
            int width = size.getWidth() - this.H.getWidth();
            int height = this.H.getHeight() - this.I.getHeight();
            this.N = (int) (Math.sqrt((width * width) + (height * height)) / this.f.getContext().getResources().getDisplayMetrics().density);
        }

        private Size T(View view) {
            view.measure(0, 0);
            return new Size(view.getMeasuredWidth(), view.getMeasuredHeight());
        }

        private void U() {
            int width = this.H.getWidth();
            int height = this.H.getHeight();
            int width2 = this.f.getWidth();
            int height2 = this.f.getHeight();
            float y = this.f.getY();
            float x = this.f.getX();
            i iVar = new i(width, width2, x, x + this.f.getWidth());
            j jVar = new j(height, height2, y);
            float x2 = this.i.getX();
            float f = width;
            k kVar = new k(x2, K() ? (f + x2) - this.i.getWidth() : (x2 - f) + this.i.getWidth(), width2);
            iVar.setInterpolator(this.o);
            iVar.setDuration(F(Type.TSIG));
            jVar.setInterpolator(this.p);
            jVar.setDuration(F(Type.TSIG));
            kVar.setInterpolator(this.p);
            kVar.setDuration(F(Type.TSIG));
            this.v.getAnimations().clear();
            this.v.addAnimation(iVar);
            this.v.addAnimation(jVar);
            this.v.addAnimation(kVar);
            this.f.startAnimation(this.v);
            this.M = true;
            this.g.animate().alpha(0.0f).withLayer().setInterpolator(this.q).setDuration(250L).start();
            this.h.setAlpha(1.0f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void V() {
            if (this.L) {
                this.g.setY(this.f.getHeight() - this.I.getHeight());
                this.i.setY(this.f.getHeight() - this.i.getHeight());
                this.h.setY(this.f.getHeight() - this.H.getHeight());
            }
        }

        private void W() {
            this.f.removeAllViews();
            if (I()) {
                this.f.addView(this.h);
            }
            this.f.addView(this.g);
            if (I()) {
                this.f.addView(this.i);
            }
            f0();
            d0();
            if (K()) {
                this.f.setAlpha(0.0f);
                this.f.post(this.D);
            }
        }

        private void X(Rect rect) {
            int height;
            Y();
            int iMin = Math.min(rect.centerX() - (this.c.getWidth() / 2), this.x.right - this.c.getWidth());
            int i2 = rect.top;
            Rect rect2 = this.x;
            int i3 = i2 - rect2.top;
            int i4 = rect2.bottom - rect.bottom;
            int i5 = this.e * 2;
            int i6 = this.B + i5;
            if (I()) {
                int iV = v(2) + i5;
                Rect rect3 = this.x;
                int i7 = (rect3.bottom - rect.top) + i6;
                int i8 = (rect.bottom - rect3.top) + i6;
                if (i3 >= iV) {
                    n0(i3 - i5);
                    height = rect.top - this.c.getHeight();
                    this.L = true;
                } else if (i3 >= i6 && i7 >= iV) {
                    n0(i7 - i5);
                    height = rect.top - i6;
                    this.L = false;
                } else if (i4 >= iV) {
                    n0(i4 - i5);
                    height = rect.bottom;
                    this.L = false;
                } else if (i4 < i6 || rect3.height() < iV) {
                    n0(this.x.height() - i5);
                    height = this.x.top;
                    this.L = false;
                } else {
                    n0(i8 - i5);
                    height = (rect.bottom + i6) - this.c.getHeight();
                    this.L = true;
                }
            } else {
                height = i3 >= i6 ? rect.top - i6 : i4 >= i6 ? rect.bottom : i4 >= this.B ? rect.bottom - this.e : Math.max(this.x.top, rect.top - i6);
            }
            this.b.getRootView().getLocationOnScreen(this.z);
            int[] iArr = this.z;
            int i9 = iArr[0];
            int i10 = iArr[1];
            this.b.getRootView().getLocationInWindow(this.z);
            int[] iArr2 = this.z;
            this.y.set(Math.max(0, iMin - (i9 - iArr2[0])), Math.max(0, height - (i10 - iArr2[1])));
        }

        private void Y() {
            this.b.getWindowVisibleDisplayFrame(this.x);
        }

        private void Z() {
            this.t.start();
        }

        private void a0() {
            this.u.start();
        }

        private void b0() {
            this.s.start();
        }

        private void c0(View view, MenuItem menuItem) {
            view.setTag(menuItem);
            view.setOnClickListener(this.K);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d0() {
            int width;
            int height;
            if (this.M) {
                width = this.H.getWidth();
                height = this.H.getHeight();
            } else {
                width = this.I.getWidth();
                height = this.I.getHeight();
            }
            this.A.set((int) this.f.getX(), (int) this.f.getY(), ((int) this.f.getX()) + width, ((int) this.f.getY()) + height);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e0(View view, int i2) {
            g0(view, view.getLayoutParams().width, i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f0() {
            this.i.setEnabled(true);
            this.h.awakenScrollBars();
            if (this.M) {
                h0(this.f, this.H);
                this.g.setAlpha(0.0f);
                this.g.setVisibility(4);
                this.h.setAlpha(1.0f);
                this.h.setVisibility(0);
                this.i.setImageDrawable(this.j);
                this.i.setContentDescription(FH3.E("AccDescrMoreOptions", TD5.tgwidget_AccDescrMoreOptions));
                if (K()) {
                    this.f.setX(this.d);
                    this.g.setX(0.0f);
                    this.i.setX(r0.getWidth() - this.G.getWidth());
                    this.h.setX(0.0f);
                } else {
                    this.f.setX((this.c.getWidth() - r0.getWidth()) - this.d);
                    this.g.setX(-this.f.getX());
                    this.i.setX(0.0f);
                    this.h.setX(0.0f);
                }
                if (this.L) {
                    this.f.setY(this.e);
                    this.g.setY(r0.getHeight() - this.f.getHeight());
                    this.i.setY(r0.getHeight() - this.G.getHeight());
                    this.h.setY(0.0f);
                    return;
                }
                this.f.setY(this.e);
                this.g.setY(0.0f);
                this.i.setY(0.0f);
                this.h.setY(this.G.getHeight());
                return;
            }
            h0(this.f, this.I);
            this.g.setAlpha(1.0f);
            this.g.setVisibility(0);
            this.h.setAlpha(0.0f);
            this.h.setVisibility(4);
            this.i.setImageDrawable(this.k);
            this.i.setContentDescription(FH3.E("AccDescrMoreOptions", TD5.tgwidget_AccDescrMoreOptions));
            if (!I()) {
                this.f.setX(this.d);
                this.f.setY(this.e);
                this.g.setX(0.0f);
                this.g.setY(0.0f);
                return;
            }
            if (K()) {
                this.f.setX(this.d);
                this.g.setX(0.0f);
                this.i.setX(0.0f);
                this.h.setX(0.0f);
            } else {
                this.f.setX((this.c.getWidth() - r0.getWidth()) - this.d);
                this.g.setX(0.0f);
                this.i.setX(r0.getWidth() - this.G.getWidth());
                this.h.setX(r0.getWidth() - this.H.getWidth());
            }
            if (this.L) {
                this.f.setY((this.e + this.H.getHeight()) - r0.getHeight());
                this.g.setY(0.0f);
                this.i.setY(0.0f);
                this.h.setY(r0.getHeight() - this.H.getHeight());
                return;
            }
            this.f.setY(this.e);
            this.g.setY(0.0f);
            this.i.setY(0.0f);
            this.h.setY(this.G.getHeight());
        }

        private void g0(View view, int i2, int i3) {
            view.setMinimumWidth(i2);
            view.setMinimumHeight(i3);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(0, 0);
            }
            layoutParams.width = i2;
            layoutParams.height = i3;
            view.setLayoutParams(layoutParams);
        }

        private void h0(View view, Size size) {
            g0(view, size.getWidth(), size.getHeight());
        }

        private void i0() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j0(View view, int i2) {
            g0(view, i2, view.getLayoutParams().height);
        }

        private void k0() {
            this.A.setEmpty();
        }

        private void n0(int i2) {
            if (I()) {
                int iV = v((i2 - this.G.getHeight()) / this.B);
                if (this.H.getHeight() != iV) {
                    this.H = new Size(this.H.getWidth(), iV);
                }
                h0(this.h, this.H);
                if (this.M) {
                    h0(this.f, this.H);
                    if (this.L) {
                        int height = this.H.getHeight() - iV;
                        ViewGroup viewGroup = this.f;
                        float f = height;
                        viewGroup.setY(viewGroup.getY() + f);
                        ImageButton imageButton = this.i;
                        imageButton.setY(imageButton.getY() - f);
                    }
                } else {
                    h0(this.f, this.I);
                }
                o0();
            }
        }

        private void o0() {
            int iMax;
            Size size = this.I;
            int iMax2 = 0;
            if (size != null) {
                iMax2 = Math.max(0, size.getWidth());
                iMax = Math.max(0, this.I.getHeight());
            } else {
                iMax = 0;
            }
            Size size2 = this.H;
            if (size2 != null) {
                iMax2 = Math.max(iMax2, size2.getWidth());
                iMax = Math.max(iMax, this.H.getHeight());
            }
            this.c.setWidth(iMax2 + (this.d * 2));
            this.c.setHeight(iMax + (this.e * 2));
            S();
        }

        private int v(int i2) {
            int iMin = Math.min(4, Math.min(Math.max(2, i2), this.h.getCount()));
            return (iMin * this.B) + this.G.getHeight() + (iMin < this.h.getCount() ? (int) (this.B * 0.5f) : 0);
        }

        private void w() {
            this.t.cancel();
            this.u.cancel();
        }

        private void x() {
            this.f.clearAnimation();
            this.g.animate().cancel();
            this.h.animate().cancel();
            this.l.stop();
            this.m.stop();
        }

        private void y() {
            this.H = null;
            this.I = null;
            this.M = false;
            this.g.removeAllViews();
            ArrayAdapter arrayAdapter = (ArrayAdapter) this.h.getAdapter();
            arrayAdapter.clear();
            this.h.setAdapter((ListAdapter) arrayAdapter);
            this.f.removeAllViews();
        }

        private void z() {
            int width = this.I.getWidth();
            int width2 = this.f.getWidth();
            float x = this.f.getX();
            l lVar = new l(width, width2, x, x + this.f.getWidth());
            m mVar = new m(this.I.getHeight(), this.f.getHeight(), this.f.getY() + this.f.getHeight());
            float x2 = this.i.getX();
            a aVar = new a(x2, K() ? (x2 - width2) + this.i.getWidth() : (width2 + x2) - this.i.getWidth(), width2);
            lVar.setInterpolator(this.p);
            lVar.setDuration(F(Type.TSIG));
            mVar.setInterpolator(this.o);
            mVar.setDuration(F(Type.TSIG));
            aVar.setInterpolator(this.p);
            aVar.setDuration(F(Type.TSIG));
            this.w.getAnimations().clear();
            this.w.addAnimation(lVar);
            this.w.addAnimation(mVar);
            this.w.addAnimation(aVar);
            this.f.startAnimation(this.w);
            this.M = false;
            this.g.animate().alpha(1.0f).withLayer().setInterpolator(this.r).setDuration(100L).start();
            this.h.animate().alpha(0.0f).withLayer().setInterpolator(this.q).setDuration(150L).start();
        }

        public void E() {
            if (this.E) {
                return;
            }
            this.F = false;
            this.E = true;
            this.u.cancel();
            Z();
            k0();
        }

        public void J() {
            if (M()) {
                this.F = true;
                a0();
                k0();
            }
        }

        public boolean M() {
            return (this.E || this.F) ? false : true;
        }

        public List P(List list, int i2) {
            LinkedList linkedList = new LinkedList(list);
            this.g.removeAllViews();
            this.g.setPaddingRelative(0, 0, 0, 0);
            int i3 = i2;
            boolean z = true;
            while (!linkedList.isEmpty()) {
                MenuItem menuItem = (MenuItem) linkedList.peek();
                boolean z2 = linkedList.size() == 1;
                View viewP = f.this.p(this.a, menuItem, this.C, z, z2);
                if (viewP instanceof LinearLayout) {
                    ((LinearLayout) viewP).setGravity(17);
                }
                viewP.setPaddingRelative((int) ((z ? 1.5d : 1.0d) * viewP.getPaddingStart()), viewP.getPaddingTop(), (int) ((z2 ? 1.5d : 1.0d) * viewP.getPaddingEnd()), viewP.getPaddingBottom());
                viewP.measure(0, 0);
                int iMin = Math.min(viewP.getMeasuredWidth(), i2);
                boolean z3 = iMin <= i3 - this.G.getWidth();
                boolean z4 = z2 && iMin <= i3;
                if (!z3 && !z4) {
                    break;
                }
                c0(viewP, menuItem);
                this.g.addView(viewP);
                ViewGroup.LayoutParams layoutParams = viewP.getLayoutParams();
                layoutParams.width = iMin;
                viewP.setLayoutParams(layoutParams);
                i3 -= iMin;
                linkedList.pop();
                z = false;
            }
            if (!linkedList.isEmpty()) {
                this.g.setPaddingRelative(0, 0, this.G.getWidth(), 0);
            }
            this.I = T(this.g);
            return linkedList;
        }

        public void Q(List list, MenuItem.OnMenuItemClickListener onMenuItemClickListener, int i2) {
            this.J = onMenuItemClickListener;
            x();
            y();
            List listP = P(list, G(i2));
            if (!listP.isEmpty()) {
                R(listP);
            }
            o0();
        }

        public void l0(Rect rect) {
            if (M()) {
                return;
            }
            this.F = false;
            this.E = false;
            w();
            x();
            X(rect);
            W();
            PopupWindow popupWindow = this.c;
            View view = this.b;
            Point point = this.y;
            popupWindow.showAtLocation(view, 0, point.x, point.y);
            i0();
            b0();
        }

        public void m0(Rect rect) {
            if (M() && this.c.isShowing()) {
                x();
                X(rect);
                W();
                PopupWindow popupWindow = this.c;
                Point point = this.y;
                popupWindow.update(point.x, point.y, popupWindow.getWidth(), this.c.getHeight());
            }
        }
    }

    public f(Context context, View view, int i, m.h hVar) {
        this.a = view;
        this.j = i;
        this.m = hVar;
        this.b = new b(context, view);
    }

    private void E() {
        this.a.removeOnLayoutChangeListener(this.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void G(View view, MenuItem menuItem, int i) {
        TextView textView = (TextView) ((ViewGroup) view).getChildAt(0);
        textView.setEllipsize(null);
        if (TextUtils.isEmpty(menuItem.getTitle())) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(menuItem.getTitle());
        }
        textView.setPaddingRelative(0, 0, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewGroup m(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        int iF = AbstractC21455b.F(20.0f);
        marginLayoutParams.rightMargin = iF;
        marginLayoutParams.topMargin = iF;
        marginLayoutParams.leftMargin = iF;
        marginLayoutParams.bottomMargin = iF;
        relativeLayout.setLayoutParams(marginLayoutParams);
        relativeLayout.setElevation(AbstractC21455b.F(2.0f));
        relativeLayout.setFocusable(true);
        relativeLayout.setFocusableInTouchMode(true);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        float F = AbstractC21455b.F(6.0f);
        gradientDrawable.setCornerRadii(new float[]{F, F, F, F, F, F, F, F});
        int i = this.j;
        if (i == 0) {
            gradientDrawable.setColor(t(m.T3));
        } else if (i == 2) {
            gradientDrawable.setColor(-115203550);
        } else if (i == 1) {
            gradientDrawable.setColor(t(m.N4));
        }
        relativeLayout.setBackgroundDrawable(gradientDrawable);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        relativeLayout.setClipToOutline(true);
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AnimatorSet n(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f).setDuration(150L));
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AnimatorSet o(View view, int i, Animator.AnimatorListener animatorListener) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 1.0f, 0.0f).setDuration(100L));
        animatorSet.setStartDelay(i);
        animatorSet.addListener(animatorListener);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View p(Context context, MenuItem menuItem, int i, boolean z, boolean z2) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        linearLayout.setOrientation(0);
        linearLayout.setMinimumWidth(AbstractC21455b.F(48.0f));
        linearLayout.setMinimumHeight(AbstractC21455b.F(48.0f));
        linearLayout.setPaddingRelative(AbstractC21455b.F(16.0f), 0, AbstractC21455b.F(16.0f), 0);
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        textView.setTextSize(1, 14.0f);
        textView.setFocusable(false);
        textView.setImportantForAccessibility(2);
        textView.setFocusableInTouchMode(false);
        int iT = t(m.S4);
        int i2 = this.j;
        if (i2 == 0) {
            textView.setTextColor(t(m.V3));
        } else if (i2 == 2) {
            textView.setTextColor(-328966);
            iT = 1090519039;
        } else if (i2 == 1) {
            textView.setTextColor(t(m.p5));
        }
        if (z || z2) {
            linearLayout.setBackgroundDrawable(m.V(iT, z ? 6 : 0, z2 ? 6 : 0, z2 ? 6 : 0, z ? 6 : 0));
        } else {
            linearLayout.setBackgroundDrawable(m.u0(iT, false));
        }
        textView.setPaddingRelative(AbstractC21455b.F(11.0f), 0, 0, 0);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, AbstractC21455b.F(48.0f)));
        if (menuItem != null) {
            G(linearLayout, menuItem, i);
        }
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PopupWindow q(ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
        PopupWindow popupWindow = new PopupWindow(linearLayout);
        popupWindow.setClippingEnabled(false);
        popupWindow.setAnimationStyle(0);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        viewGroup.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        linearLayout.addView(viewGroup);
        return popupWindow;
    }

    private void s() {
        List listU = u(this.e);
        Collections.sort(listU, this.l);
        if (!w(listU) || this.i) {
            this.b.E();
            this.b.Q(listU, this.g, this.h);
            this.f = listU;
        }
        if (!this.b.M()) {
            this.b.l0(this.c);
        } else if (!this.d.equals(this.c)) {
            this.b.m0(this.c);
        }
        this.i = false;
        this.d.set(this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int t(int i) {
        return m.j0(i, this.m);
    }

    private List u(Menu menu) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; menu != null && i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            if (item.isVisible() && item.isEnabled()) {
                SubMenu subMenu = item.getSubMenu();
                if (subMenu != null) {
                    arrayList.addAll(u(subMenu));
                } else if (item.getItemId() != 16908353) {
                    arrayList.add(item);
                }
            }
        }
        return arrayList;
    }

    private boolean w(List list) {
        if (this.f == null || list.size() != this.f.size()) {
            return false;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            MenuItem menuItem = (MenuItem) list.get(i);
            MenuItem menuItem2 = (MenuItem) this.f.get(i);
            if (menuItem.getItemId() != menuItem2.getItemId() || !TextUtils.equals(menuItem.getTitle(), menuItem2.getTitle()) || !Objects.equals(menuItem.getIcon(), menuItem2.getIcon()) || menuItem.getGroupId() != menuItem2.getGroupId()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int x(MenuItem menuItem, MenuItem menuItem2) {
        return menuItem.getOrder() - menuItem2.getOrder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean y(MenuItem menuItem) {
        return false;
    }

    private void z() {
        E();
        this.a.addOnLayoutChangeListener(this.k);
    }

    public f A(Rect rect) {
        this.c.set(rect);
        return this;
    }

    public f B(Menu menu) {
        this.e = menu;
        return this;
    }

    public f C(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        if (onMenuItemClickListener != null) {
            this.g = onMenuItemClickListener;
        } else {
            this.g = n;
        }
        return this;
    }

    public f D() {
        z();
        s();
        return this;
    }

    public f F() {
        if (this.b.M()) {
            s();
        }
        return this;
    }

    public void r() {
        E();
        this.b.E();
    }

    public void v() {
        this.b.J();
    }
}
