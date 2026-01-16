package ir.nasim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.J37;

/* renamed from: ir.nasim.Ka2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5598Ka2 {
    public static final a l = new a(null);
    public static final int m = 8;
    private final InterfaceC22634va2 a;
    private final c b;
    private final b c;
    private ConstraintLayout d;
    private ImageView e;
    private RelativeLayout f;
    private ImageView g;
    private TextView h;
    private TextView i;
    private ImageView j;
    private TextView k;

    /* renamed from: ir.nasim.Ka2$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Ka2$b */
    public interface b {
        void h4();
    }

    /* renamed from: ir.nasim.Ka2$c */
    public interface c {
        void x4(boolean z);
    }

    /* renamed from: ir.nasim.Ka2$d */
    public interface d {
        void B0();
    }

    /* renamed from: ir.nasim.Ka2$e */
    public static final class e extends AnimatorListenerAdapter {
        final /* synthetic */ d b;

        e(d dVar) {
            this.b = dVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AbstractC13042fc3.i(animator, "animation");
            C5598Ka2.this.e();
            d dVar = this.b;
            if (dVar != null) {
                dVar.B0();
            }
        }
    }

    /* renamed from: ir.nasim.Ka2$f */
    public static final class f implements J37.d {
        f() {
        }

        @Override // ir.nasim.J37.d
        public boolean a(Object obj) {
            return true;
        }

        @Override // ir.nasim.J37.d
        public void b(View view, Object obj) {
            AbstractC13042fc3.i(view, "view");
            c cVar = C5598Ka2.this.b;
            if (cVar != null) {
                cVar.x4(false);
            }
        }
    }

    /* renamed from: ir.nasim.Ka2$g */
    public static final class g extends AnimatorListenerAdapter {
        final /* synthetic */ SA2 a;

        g(SA2 sa2) {
            this.a = sa2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AbstractC13042fc3.i(animator, "animation");
            this.a.invoke();
        }
    }

    public C5598Ka2(InterfaceC22634va2 interfaceC22634va2, c cVar, b bVar) {
        AbstractC13042fc3.i(interfaceC22634va2, "eventBarFactory");
        this.a = interfaceC22634va2;
        this.b = cVar;
        this.c = bVar;
    }

    private final void A() {
        ImageView imageView = this.e;
        RelativeLayout relativeLayout = null;
        if (imageView == null) {
            AbstractC13042fc3.y("eventBarClose");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Ia2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C5598Ka2.B(this.a, view);
            }
        });
        RelativeLayout relativeLayout2 = this.f;
        if (relativeLayout2 == null) {
            AbstractC13042fc3.y("eventBarCloseContainer");
        } else {
            relativeLayout = relativeLayout2;
        }
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Ja2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C5598Ka2.C(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(C5598Ka2 c5598Ka2, View view) {
        AbstractC13042fc3.i(c5598Ka2, "this$0");
        c cVar = c5598Ka2.b;
        if (cVar != null) {
            cVar.x4(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(C5598Ka2 c5598Ka2, View view) {
        AbstractC13042fc3.i(c5598Ka2, "this$0");
        c cVar = c5598Ka2.b;
        if (cVar != null) {
            cVar.x4(true);
        }
    }

    private final void D() {
        String strB = this.a.b();
        TextView textView = null;
        if (!this.a.v() || strB == null) {
            TextView textView2 = this.k;
            if (textView2 == null) {
                AbstractC13042fc3.y("eventBarEmoji");
            } else {
                textView = textView2;
            }
            textView.setVisibility(8);
            return;
        }
        TextView textView3 = this.k;
        if (textView3 == null) {
            AbstractC13042fc3.y("eventBarEmoji");
            textView3 = null;
        }
        textView3.setVisibility(0);
        TextView textView4 = this.k;
        if (textView4 == null) {
            AbstractC13042fc3.y("eventBarEmoji");
            textView4 = null;
        }
        textView4.setTypeface(C6011Lu2.i());
        TextView textView5 = this.k;
        if (textView5 == null) {
            AbstractC13042fc3.y("eventBarEmoji");
            textView5 = null;
        }
        TextView textView6 = this.h;
        if (textView6 == null) {
            AbstractC13042fc3.y("eventBarTitle");
        } else {
            textView = textView6;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        AbstractC13042fc3.h(fontMetricsInt, "getFontMetricsInt(...)");
        textView5.setText(k(strB, fontMetricsInt, 20.0f));
    }

    private final void E() {
        String strB = this.a.b();
        ImageView imageView = null;
        TextView textView = null;
        ImageView imageView2 = null;
        if (this.a.v() && strB != null) {
            ImageView imageView3 = this.j;
            if (imageView3 == null) {
                AbstractC13042fc3.y("eventBarIcon");
                imageView3 = null;
            }
            imageView3.setVisibility(8);
            TextView textView2 = this.k;
            if (textView2 == null) {
                AbstractC13042fc3.y("eventBarEmoji");
                textView2 = null;
            }
            textView2.setVisibility(0);
            TextView textView3 = this.k;
            if (textView3 == null) {
                AbstractC13042fc3.y("eventBarEmoji");
                textView3 = null;
            }
            textView3.setTypeface(C6011Lu2.i());
            TextView textView4 = this.k;
            if (textView4 == null) {
                AbstractC13042fc3.y("eventBarEmoji");
                textView4 = null;
            }
            TextView textView5 = this.h;
            if (textView5 == null) {
                AbstractC13042fc3.y("eventBarTitle");
            } else {
                textView = textView5;
            }
            Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
            AbstractC13042fc3.h(fontMetricsInt, "getFontMetricsInt(...)");
            textView4.setText(k(strB, fontMetricsInt, 20.0f));
            return;
        }
        if (!this.a.f()) {
            TextView textView6 = this.k;
            if (textView6 == null) {
                AbstractC13042fc3.y("eventBarEmoji");
                textView6 = null;
            }
            textView6.setVisibility(8);
            ImageView imageView4 = this.j;
            if (imageView4 == null) {
                AbstractC13042fc3.y("eventBarIcon");
            } else {
                imageView = imageView4;
            }
            imageView.setVisibility(8);
            return;
        }
        TextView textView7 = this.k;
        if (textView7 == null) {
            AbstractC13042fc3.y("eventBarEmoji");
            textView7 = null;
        }
        textView7.setVisibility(8);
        ImageView imageView5 = this.j;
        if (imageView5 == null) {
            AbstractC13042fc3.y("eventBarIcon");
            imageView5 = null;
        }
        imageView5.setVisibility(0);
        ImageView imageView6 = this.j;
        if (imageView6 == null) {
            AbstractC13042fc3.y("eventBarIcon");
        } else {
            imageView2 = imageView6;
        }
        imageView2.setImageResource(this.a.m());
    }

    private final void F() {
        t();
        q();
    }

    private final void i(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(BC5.event_bar);
        this.e = (ImageView) constraintLayout.findViewById(BC5.imv_close_event_bar);
        this.f = (RelativeLayout) constraintLayout.findViewById(BC5.close_event_bar_container);
        this.g = (ImageView) constraintLayout.findViewById(BC5.imv_event_bar_background);
        this.h = (TextView) constraintLayout.findViewById(BC5.tv_event_bar_title);
        this.i = (TextView) constraintLayout.findViewById(BC5.tv_event_bar_more_info_link);
        this.j = (ImageView) constraintLayout.findViewById(BC5.imv_event_bar_icon);
        this.k = (TextView) constraintLayout.findViewById(BC5.tv_event_bar_emoji);
        this.d = constraintLayout;
        if (constraintLayout != null) {
            constraintLayout.setOnTouchListener(new J37(constraintLayout, null, new f()));
        }
    }

    private final CharSequence k(String str, Paint.FontMetricsInt fontMetricsInt, float f2) {
        return R62.W(str, fontMetricsInt, AbstractC7426Rr.a.f(f2), false, null, null, 48, null);
    }

    private final void l() {
        ImageView imageView = this.e;
        TextView textView = null;
        if (imageView == null) {
            AbstractC13042fc3.y("eventBarClose");
            imageView = null;
        }
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        imageView.setColorFilter(c5495Jo7.D0());
        TextView textView2 = this.h;
        if (textView2 == null) {
            AbstractC13042fc3.y("eventBarTitle");
            textView2 = null;
        }
        textView2.setTextColor(c5495Jo7.E0());
        TextView textView3 = this.i;
        if (textView3 == null) {
            AbstractC13042fc3.y("eventBarLink");
        } else {
            textView = textView3;
        }
        textView.setTextColor(c5495Jo7.C0());
    }

    private final void m() {
        if (this.a.c()) {
            try {
                int color = Color.parseColor(this.a.u());
                ImageView imageView = this.g;
                if (imageView == null) {
                    AbstractC13042fc3.y("eventBarBackground");
                    imageView = null;
                }
                imageView.setColorFilter(color);
            } catch (IllegalArgumentException e2) {
                C19406qI3.a("EventBarViewHandler", e2.getMessage(), new Object[0]);
            }
        }
    }

    private final void n() {
        if (this.a.r()) {
            try {
                int color = Color.parseColor(this.a.A());
                ImageView imageView = this.e;
                if (imageView == null) {
                    AbstractC13042fc3.y("eventBarClose");
                    imageView = null;
                }
                imageView.setColorFilter(color);
            } catch (IllegalArgumentException e2) {
                C19406qI3.a("EventBarViewHandler", e2.getMessage(), new Object[0]);
            }
        }
    }

    private final void o() {
        x();
        F();
        p();
    }

    private final void p() {
        if (this.a.x()) {
            E();
            return;
        }
        if (this.a.y()) {
            ImageView imageView = this.j;
            if (imageView == null) {
                AbstractC13042fc3.y("eventBarIcon");
                imageView = null;
            }
            imageView.setVisibility(8);
            D();
        }
    }

    private final void q() {
        ConstraintLayout constraintLayout = this.d;
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Ha2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C5598Ka2.r(this.a, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(C5598Ka2 c5598Ka2, View view) {
        AbstractC13042fc3.i(c5598Ka2, "this$0");
        try {
            b bVar = c5598Ka2.c;
            if (bVar != null) {
                bVar.h4();
            }
        } catch (Exception e2) {
            C19406qI3.d("EventBarViewHandler", e2);
        }
    }

    private final void s() {
        if (this.a.p()) {
            try {
                int color = Color.parseColor(this.a.l());
                TextView textView = this.i;
                if (textView == null) {
                    AbstractC13042fc3.y("eventBarLink");
                    textView = null;
                }
                textView.setTextColor(color);
            } catch (IllegalArgumentException e2) {
                C19406qI3.a("EventBarViewHandler", e2.getMessage(), new Object[0]);
            }
        }
    }

    private final void t() {
        String strN = this.a.n();
        if (!this.a.g() || strN == null) {
            return;
        }
        TextView textView = this.i;
        TextView textView2 = null;
        if (textView == null) {
            AbstractC13042fc3.y("eventBarLink");
            textView = null;
        }
        TextView textView3 = this.i;
        if (textView3 == null) {
            AbstractC13042fc3.y("eventBarLink");
        } else {
            textView2 = textView3;
        }
        Paint.FontMetricsInt fontMetricsInt = textView2.getPaint().getFontMetricsInt();
        AbstractC13042fc3.h(fontMetricsInt, "getFontMetricsInt(...)");
        textView.setText(k(strN, fontMetricsInt, 14.0f));
    }

    private final void u() {
        if (this.a.e()) {
            z(6.0f);
        } else {
            z(16.0f);
        }
    }

    private final void v() {
        TextView textView = this.h;
        TextView textView2 = null;
        if (textView == null) {
            AbstractC13042fc3.y("eventBarTitle");
            textView = null;
        }
        textView.setTypeface(C6011Lu2.i());
        TextView textView3 = this.i;
        if (textView3 == null) {
            AbstractC13042fc3.y("eventBarLink");
            textView3 = null;
        }
        textView3.setTypeface(C6011Lu2.i());
        TextView textView4 = this.k;
        if (textView4 == null) {
            AbstractC13042fc3.y("eventBarEmoji");
        } else {
            textView2 = textView4;
        }
        textView2.setTypeface(C6011Lu2.i());
    }

    private final void w() {
        l();
        v();
        m();
        y();
        s();
        n();
        u();
    }

    private final void x() {
        String strI;
        if (!this.a.w() || (strI = this.a.i()) == null) {
            return;
        }
        TextView textView = this.h;
        TextView textView2 = null;
        if (textView == null) {
            AbstractC13042fc3.y("eventBarTitle");
            textView = null;
        }
        TextView textView3 = this.h;
        if (textView3 == null) {
            AbstractC13042fc3.y("eventBarTitle");
        } else {
            textView2 = textView3;
        }
        Paint.FontMetricsInt fontMetricsInt = textView2.getPaint().getFontMetricsInt();
        AbstractC13042fc3.h(fontMetricsInt, "getFontMetricsInt(...)");
        textView.setText(k(strI, fontMetricsInt, 14.0f));
    }

    private final void y() {
        if (this.a.z()) {
            try {
                int color = Color.parseColor(this.a.d());
                TextView textView = this.h;
                if (textView == null) {
                    AbstractC13042fc3.y("eventBarTitle");
                    textView = null;
                }
                textView.setTextColor(color);
            } catch (IllegalArgumentException e2) {
                C19406qI3.a("EventBarViewHandler", e2.getMessage(), new Object[0]);
            }
        }
    }

    private final void z(float f2) {
        TextView textView = this.h;
        TextView textView2 = null;
        if (textView == null) {
            AbstractC13042fc3.y("eventBarTitle");
            textView = null;
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        AbstractC13042fc3.g(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.setMarginStart(AbstractC7426Rr.a.f(f2));
        TextView textView3 = this.h;
        if (textView3 == null) {
            AbstractC13042fc3.y("eventBarTitle");
        } else {
            textView2 = textView3;
        }
        textView2.setLayoutParams(layoutParams2);
    }

    public final void G() {
        ConstraintLayout constraintLayout = this.d;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
            TextView textView = this.h;
            if (textView == null) {
                AbstractC13042fc3.y("eventBarTitle");
                textView = null;
            }
            textView.setSelected(true);
        }
    }

    public final void H(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "eventBarShownWithAnimation");
        ConstraintLayout constraintLayout = this.d;
        if (constraintLayout != null) {
            constraintLayout.setTranslationY(AbstractC7426Rr.a.f(70.0f));
            constraintLayout.setAlpha(0.2f);
            G();
            ViewPropertyAnimator viewPropertyAnimatorAnimate = constraintLayout.animate();
            viewPropertyAnimatorAnimate.translationY(0.0f).alpha(1.0f).setDuration(450L).setInterpolator(new OvershootInterpolator()).start();
            viewPropertyAnimatorAnimate.setListener(new g(sa2));
        }
    }

    public final void e() {
        ConstraintLayout constraintLayout = this.d;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
    }

    public final void f(View view) {
        View viewFindViewById;
        if (view == null || (viewFindViewById = view.findViewById(BC5.event_bar)) == null) {
            return;
        }
        viewFindViewById.setVisibility(8);
    }

    public final void g(d dVar) {
        ConstraintLayout constraintLayout = this.d;
        if (constraintLayout != null) {
            ViewPropertyAnimator viewPropertyAnimatorAnimate = constraintLayout.animate();
            viewPropertyAnimatorAnimate.translationY(70.0f).setInterpolator(new AnticipateInterpolator()).alpha(0.0f).setDuration(250L).start();
            viewPropertyAnimatorAnimate.setListener(new e(dVar));
        }
    }

    public final void h(View view) {
        AbstractC13042fc3.i(view, "parentView");
        i(view);
        w();
        A();
        o();
    }

    public final void j() {
        try {
            TextView textView = this.k;
            TextView textView2 = null;
            if (textView == null) {
                AbstractC13042fc3.y("eventBarEmoji");
                textView = null;
            }
            textView.invalidate();
            TextView textView3 = this.h;
            if (textView3 == null) {
                AbstractC13042fc3.y("eventBarTitle");
                textView3 = null;
            }
            textView3.invalidate();
            TextView textView4 = this.i;
            if (textView4 == null) {
                AbstractC13042fc3.y("eventBarLink");
            } else {
                textView2 = textView4;
            }
            textView2.invalidate();
        } catch (Exception e2) {
            C19406qI3.a("EventBarViewHandler", e2.getMessage(), new Object[0]);
        }
    }
}
