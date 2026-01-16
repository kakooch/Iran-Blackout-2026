package ir.nasim;

import android.content.Context;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import ir.nasim.GM3;
import ir.nasim.N15;
import ir.nasim.S53;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.TemplateRowView;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class S53 extends P64 {
    public static final a K0 = new a(null);
    public static final int L0 = 8;
    private final C9846af3 D0;
    private final InterfaceC20284rl0 E0;
    private final boolean F0;
    private final boolean G0;
    private final boolean H0;
    private InterfaceC7857Tm2 I0;
    private final LinearLayout J0;

    public static final class a {
        private a() {
        }

        public final P64 a(ViewGroup viewGroup, LayoutInflater layoutInflater, InterfaceC22152ul0 interfaceC22152ul0, boolean z, boolean z2, InterfaceC22948w54 interfaceC22948w54, boolean z3, EW7 ew7, boolean z4, JW7 jw7, EnumC8893Xt7 enumC8893Xt7, boolean z5) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(layoutInflater, "inflater");
            AbstractC13042fc3.i(interfaceC22152ul0, "bubbleFactory");
            AbstractC13042fc3.i(interfaceC22948w54, "messageClickListener");
            AbstractC13042fc3.i(ew7, "viewHolderClickListener");
            AbstractC13042fc3.i(jw7, "viewHolderType");
            C9846af3 c9846af3C = C9846af3.c(layoutInflater, viewGroup, false);
            if (!z2 || jw7.b()) {
                ShapeableImageView shapeableImageView = c9846af3C.e;
                AbstractC13042fc3.h(shapeableImageView, "forwardImageView");
                shapeableImageView.setVisibility(z2 ? 0 : 8);
            } else {
                ViewStub viewStub = c9846af3C.c;
                AbstractC13042fc3.h(viewStub, "bubbleStub");
                ViewGroup.LayoutParams layoutParams = viewStub.getLayoutParams();
                if (layoutParams == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                }
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                layoutParams2.x = (int) ((38 * AbstractC3742Cd6.c()) + 0.5d);
                viewStub.setLayoutParams(layoutParams2);
                ShapeableImageView shapeableImageView2 = c9846af3C.e;
                AbstractC13042fc3.h(shapeableImageView2, "forwardImageView");
                shapeableImageView2.setVisibility(8);
            }
            AbstractC13042fc3.h(c9846af3C, "apply(...)");
            ViewStub viewStub2 = c9846af3C.c;
            AbstractC13042fc3.h(viewStub2, "bubbleStub");
            return new S53(c9846af3C, interfaceC22152ul0.a(viewStub2), z, interfaceC22948w54, z3, ew7, z4, enumC8893Xt7, z5, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b implements Runnable {
        final /* synthetic */ View a;
        final /* synthetic */ C11637dL5 b;

        b(View view, C11637dL5 c11637dL5) {
            this.a = view;
            this.b = c11637dL5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.setMinimumWidth(this.b.a);
        }
    }

    public static final class c implements View.OnLayoutChangeListener {
        public c() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            view.removeOnLayoutChangeListener(this);
            C11637dL5 c11637dL5 = new C11637dL5();
            c11637dL5.a = S53.this.E0.d().getWidth() - ((int) ((12 * AbstractC3742Cd6.c()) + 0.5d));
            Iterator it = AbstractC24379yW7.b(S53.this.J0).iterator();
            while (it.hasNext()) {
                c11637dL5.a = Math.max(((View) it.next()).getWidth(), c11637dL5.a);
            }
            for (View view2 : AbstractC24379yW7.b(S53.this.J0)) {
                if (!view2.post(new b(view2, c11637dL5))) {
                    return;
                }
            }
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC20284rl0 c;
        final /* synthetic */ S53 d;
        final /* synthetic */ C8967Xz7 e;
        final /* synthetic */ AbstractC23538x54 f;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ S53 d;
            final /* synthetic */ C8967Xz7 e;
            final /* synthetic */ AbstractC23538x54 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(S53 s53, C8967Xz7 c8967Xz7, AbstractC23538x54 abstractC23538x54, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = s53;
                this.e = c8967Xz7;
                this.f = abstractC23538x54;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 y(AbstractC23538x54 abstractC23538x54, C8967Xz7 c8967Xz7, G73 g73) {
                abstractC23538x54.b().r(c8967Xz7, g73);
                return C19938rB7.a;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, this.f, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (((EnumC9477a18) this.c) == EnumC9477a18.d) {
                    S53 s53 = this.d;
                    C19672qk7 c19672qk7S = this.e.s();
                    boolean z = this.e.g() != null;
                    final AbstractC23538x54 abstractC23538x54 = this.f;
                    final C8967Xz7 c8967Xz7 = this.e;
                    s53.r2(c19672qk7S, z, new UA2() { // from class: ir.nasim.T53
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj2) {
                            return S53.d.a.y(abstractC23538x54, c8967Xz7, (G73) obj2);
                        }
                    });
                } else {
                    LinearLayout linearLayout = this.d.J0;
                    if (linearLayout != null) {
                        linearLayout.removeAllViews();
                    }
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public final Object invoke(EnumC9477a18 enumC9477a18, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(enumC9477a18, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(InterfaceC20284rl0 interfaceC20284rl0, S53 s53, C8967Xz7 c8967Xz7, AbstractC23538x54 abstractC23538x54, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC20284rl0;
            this.d = s53;
            this.e = c8967Xz7;
            this.f = abstractC23538x54;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 state = ((NM) this.c).X1().i.getState();
                a aVar = new a(this.d, this.e, this.f, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(state, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public /* synthetic */ S53(C9846af3 c9846af3, InterfaceC20284rl0 interfaceC20284rl0, boolean z, InterfaceC22948w54 interfaceC22948w54, boolean z2, EW7 ew7, boolean z3, EnumC8893Xt7 enumC8893Xt7, boolean z4, ED1 ed1) {
        this(c9846af3, interfaceC20284rl0, z, interfaceC22948w54, z2, ew7, z3, enumC8893Xt7, z4);
    }

    private final void B2(final GM3 gm3, C8967Xz7 c8967Xz7) {
        J44 j44J;
        if (((c8967Xz7 == null || (j44J = c8967Xz7.j()) == null) ? null : j44J.F()) instanceof C23345wl7) {
            InterfaceC20284rl0 interfaceC20284rl0 = this.E0;
            if (interfaceC20284rl0 instanceof C20882sl7) {
                final MessageEmojiTextView messageEmojiTextView = ((C20882sl7) interfaceC20284rl0).x0().i;
                messageEmojiTextView.post(new Runnable() { // from class: ir.nasim.K53
                    @Override // java.lang.Runnable
                    public final void run() {
                        S53.C2(messageEmojiTextView, this, gm3);
                    }
                });
                return;
            }
        }
        S2(gm3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C2(MessageEmojiTextView messageEmojiTextView, S53 s53, GM3 gm3) {
        AbstractC13042fc3.i(messageEmojiTextView, "$this_with");
        AbstractC13042fc3.i(s53, "this$0");
        if (messageEmojiTextView.getLineCount() >= 3) {
            s53.S2(gm3);
        }
    }

    private final LinearLayout D2(boolean z) {
        C9846af3 c9846af3 = this.D0;
        if (!z) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(c9846af3.getRoot().getContext());
        linearLayout.setId(View.generateViewId());
        linearLayout.setOrientation(1);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, -2);
        linearLayout.setGravity(3);
        layoutParams.d = 0;
        layoutParams.f = c9846af3.f.getId();
        layoutParams.k = 0;
        if (this.F0) {
            int iI2 = I2();
            AvatarViewGlide avatarViewGlide = c9846af3.i;
            AbstractC13042fc3.h(avatarViewGlide, "userAvatar");
            ViewGroup.LayoutParams layoutParams2 = avatarViewGlide.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
            iC = iI2 - ((marginLayoutParams != null ? marginLayoutParams.rightMargin : 0) + ((int) ((2 * AbstractC3742Cd6.c()) + 0.5d)));
        }
        double d2 = 8;
        layoutParams.setMargins(iC + ((int) ((AbstractC3742Cd6.c() * d2) + 0.5d)), ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (int) ((d2 * AbstractC3742Cd6.c()) + 0.5d), ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        linearLayout.setLayoutParams(layoutParams);
        this.D0.getRoot().addView(linearLayout);
        AvatarViewGlide avatarViewGlide2 = c9846af3.i;
        AbstractC13042fc3.h(avatarViewGlide2, "userAvatar");
        E2(avatarViewGlide2, linearLayout);
        ViewStub viewStub = c9846af3.c;
        AbstractC13042fc3.h(viewStub, "bubbleStub");
        E2(viewStub, linearLayout);
        ShapeableImageView shapeableImageView = c9846af3.e;
        AbstractC13042fc3.h(shapeableImageView, "forwardImageView");
        E2(shapeableImageView, linearLayout);
        ShapeableImageView shapeableImageView2 = c9846af3.b;
        AbstractC13042fc3.h(shapeableImageView2, "addToStory");
        ViewGroup.LayoutParams layoutParams3 = shapeableImageView2.getLayoutParams();
        if (layoutParams3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
        layoutParams4.j = c9846af3.e.getId();
        shapeableImageView2.setLayoutParams(layoutParams4);
        ShapeableImageView shapeableImageView3 = c9846af3.h;
        AbstractC13042fc3.h(shapeableImageView3, "upVoteImageView");
        ViewGroup.LayoutParams layoutParams5 = shapeableImageView3.getLayoutParams();
        if (layoutParams5 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) layoutParams5;
        layoutParams6.j = c9846af3.b.getId();
        shapeableImageView3.setLayoutParams(layoutParams6);
        return linearLayout;
    }

    private static final void E2(View view, LinearLayout linearLayout) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.k = -1;
        layoutParams2.j = linearLayout.getId();
        view.setLayoutParams(layoutParams2);
    }

    private final LinearLayout.LayoutParams F2() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = (int) ((4 * AbstractC3742Cd6.c()) + 0.5d);
        return layoutParams;
    }

    private final void G2(FileReference fileReference, SA2 sa2) {
        if (fileReference != null) {
            this.I0 = AbstractC5969Lp4.d().q(fileReference, true, new e(sa2));
        } else if (sa2 != null) {
            sa2.invoke();
        }
    }

    static /* synthetic */ void H2(S53 s53, FileReference fileReference, SA2 sa2, int i, Object obj) {
        if ((i & 2) != 0) {
            sa2 = null;
        }
        s53.G2(fileReference, sa2);
    }

    private final int I2() {
        AvatarViewGlide avatarViewGlide = this.D0.i;
        AbstractC13042fc3.f(avatarViewGlide);
        if (avatarViewGlide.getVisibility() != 0) {
            return 0;
        }
        int i = avatarViewGlide.getLayoutParams().width;
        ViewGroup.LayoutParams layoutParams = avatarViewGlide.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        int i2 = i + (marginLayoutParams != null ? marginLayoutParams.leftMargin : 0);
        ViewGroup.LayoutParams layoutParams2 = avatarViewGlide.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
        return i2 + (marginLayoutParams2 != null ? marginLayoutParams2.rightMargin : 0);
    }

    private final int J2() {
        ShapeableImageView shapeableImageView = this.D0.e;
        AbstractC13042fc3.f(shapeableImageView);
        if (shapeableImageView.getVisibility() != 0) {
            return 0;
        }
        int i = shapeableImageView.getLayoutParams().width;
        ViewGroup.LayoutParams layoutParams = shapeableImageView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        int i2 = i + (marginLayoutParams != null ? marginLayoutParams.leftMargin : 0);
        ViewGroup.LayoutParams layoutParams2 = shapeableImageView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
        return i2 + (marginLayoutParams2 != null ? marginLayoutParams2.rightMargin : 0);
    }

    private final int K2() {
        int i;
        int i2;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewStub viewStub = this.D0.c;
        C8967Xz7 c8967Xz7E1 = e1();
        int i3 = 0;
        if ((c8967Xz7E1 != null ? c8967Xz7E1.f() : null) instanceof C10240bJ6) {
            ViewGroup.LayoutParams layoutParams = viewStub.getLayoutParams();
            AbstractC13042fc3.g(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            i = ((ConstraintLayout.LayoutParams) layoutParams).x;
        } else {
            i = 0;
        }
        AvatarViewGlide avatarViewGlide = this.D0.i;
        AbstractC13042fc3.h(avatarViewGlide, "userAvatar");
        if (avatarViewGlide.getVisibility() == 0) {
            AbstractC13042fc3.f(viewStub);
            ViewGroup.LayoutParams layoutParams2 = viewStub.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
            i2 = marginLayoutParams2 != null ? marginLayoutParams2.leftMargin : 0;
            ViewGroup.LayoutParams layoutParams3 = viewStub.getLayoutParams();
            marginLayoutParams = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : null;
            if (marginLayoutParams != null) {
                i3 = marginLayoutParams.rightMargin;
            }
        } else {
            ViewGroup.LayoutParams layoutParams4 = viewStub.getLayoutParams();
            AbstractC13042fc3.g(layoutParams4, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            i2 = ((ConstraintLayout.LayoutParams) layoutParams4).v;
            AbstractC13042fc3.f(viewStub);
            ViewGroup.LayoutParams layoutParams5 = viewStub.getLayoutParams();
            marginLayoutParams = layoutParams5 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams5 : null;
            if (marginLayoutParams != null) {
                i3 = marginLayoutParams.rightMargin;
            }
        }
        return i2 + i3 + i;
    }

    private final boolean N2() {
        return AbstractC13042fc3.d(this.E0.getClass(), C20882sl7.class) || AbstractC13042fc3.d(this.E0.getClass(), C19835r13.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O2(ImageView imageView, String str) {
        Context context = imageView.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        QI2.c(str, context, imageView.getHeight(), imageView.getWidth()).Q0(imageView);
    }

    private final void P2(boolean z) {
        AvatarViewGlide avatarViewGlide = this.D0.i;
        avatarViewGlide.B(18.0f, true);
        AbstractC13042fc3.f(avatarViewGlide);
        avatarViewGlide.setVisibility(z ? 0 : 8);
    }

    private final void S2(final GM3 gm3) {
        if (gm3 instanceof GM3.b) {
            ShapeableImageView shapeableImageView = this.D0.h;
            AbstractC13042fc3.h(shapeableImageView, "upVoteImageView");
            shapeableImageView.setVisibility(this.G0 ? 0 : 8);
            this.D0.h.setImageResource(AbstractC24188yB5.up_vote);
            this.D0.h.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Q53
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    S53.T2(gm3, view);
                }
            });
            return;
        }
        if (!(gm3 instanceof GM3.c)) {
            ShapeableImageView shapeableImageView2 = this.D0.h;
            AbstractC13042fc3.h(shapeableImageView2, "upVoteImageView");
            shapeableImageView2.setVisibility(8);
        } else {
            ShapeableImageView shapeableImageView3 = this.D0.h;
            AbstractC13042fc3.h(shapeableImageView3, "upVoteImageView");
            shapeableImageView3.setVisibility(this.G0 ? 0 : 8);
            this.D0.h.setImageResource(AbstractC24188yB5.up_voted);
            this.D0.h.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.R53
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    S53.U2(gm3, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T2(GM3 gm3, View view) {
        ((GM3.b) gm3).a().invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U2(GM3 gm3, View view) {
        ((GM3.c) gm3).a().invoke();
    }

    private final void W1(LinearLayout linearLayout, C19672qk7 c19672qk7, UA2 ua2) {
        List<C20281rk7> listA = c19672qk7.a();
        ViewGroup.LayoutParams layoutParamsF2 = F2();
        for (C20281rk7 c20281rk7 : listA) {
            Context context = linearLayout.getContext();
            AbstractC13042fc3.h(context, "getContext(...)");
            TemplateRowView templateRowView = new TemplateRowView(context, null, 0, 6, null);
            templateRowView.e(c20281rk7, ua2);
            linearLayout.addView(templateRowView, layoutParamsF2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Y1(AbstractC23538x54 abstractC23538x54, C8967Xz7 c8967Xz7, G73 g73) {
        AbstractC13042fc3.i(abstractC23538x54, "$messageClickListenerAdapter");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(g73, "inlineButton");
        abstractC23538x54.b().r(c8967Xz7, g73);
        return C19938rB7.a;
    }

    private final void a2(boolean z) {
        if (C8386Vt0.d4() && N2() && z) {
            this.D0.b.setVisibility(0);
        } else {
            this.D0.b.setVisibility(8);
        }
        InterfaceC20284rl0 interfaceC20284rl0 = this.E0;
        if (!(interfaceC20284rl0 instanceof C20882sl7) || (interfaceC20284rl0 instanceof C19835r13)) {
            return;
        }
        final MessageEmojiTextView messageEmojiTextView = ((C20882sl7) interfaceC20284rl0).x0().i;
        messageEmojiTextView.post(new Runnable() { // from class: ir.nasim.O53
            @Override // java.lang.Runnable
            public final void run() {
                S53.b2(messageEmojiTextView, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b2(MessageEmojiTextView messageEmojiTextView, S53 s53) {
        AbstractC13042fc3.i(messageEmojiTextView, "$this_with");
        AbstractC13042fc3.i(s53, "this$0");
        if (messageEmojiTextView.getLineCount() < 3) {
            s53.D0.b.setVisibility(8);
            messageEmojiTextView.invalidate();
        }
    }

    private final void g2(C9846af3 c9846af3, final C20610sI7 c20610sI7, boolean z) {
        AvatarViewGlide avatarViewGlide = c9846af3.i;
        AbstractC13042fc3.h(avatarViewGlide, "userAvatar");
        avatarViewGlide.setVisibility(this.F0 && z ? 0 : 8);
        c9846af3.i.setImageDrawable(c20610sI7 != null ? c20610sI7.c() : null);
        G2(c20610sI7 != null ? c20610sI7.b() : null, new SA2() { // from class: ir.nasim.P53
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return S53.j2(this.a, c20610sI7);
            }
        });
    }

    static /* synthetic */ void i2(S53 s53, C9846af3 c9846af3, C20610sI7 c20610sI7, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        s53.g2(c9846af3, c20610sI7, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j2(S53 s53, C20610sI7 c20610sI7) {
        AbstractC13042fc3.i(s53, "this$0");
        H2(s53, c20610sI7 != null ? c20610sI7.a() : null, null, 2, null);
        return C19938rB7.a;
    }

    private final void l2(final C8967Xz7 c8967Xz7, final AbstractC23538x54 abstractC23538x54) {
        C9846af3 c9846af3 = this.D0;
        c9846af3.e.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.L53
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                S53.n2(abstractC23538x54, c8967Xz7, view);
            }
        });
        c9846af3.i.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.M53
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                S53.o2(abstractC23538x54, c8967Xz7, view);
            }
        });
        c9846af3.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.N53
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                S53.p2(abstractC23538x54, c8967Xz7, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n2(AbstractC23538x54 abstractC23538x54, C8967Xz7 c8967Xz7, View view) {
        AbstractC13042fc3.i(abstractC23538x54, "$messageClickListener");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        abstractC23538x54.b().k(c8967Xz7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o2(AbstractC23538x54 abstractC23538x54, C8967Xz7 c8967Xz7, View view) {
        AbstractC13042fc3.i(abstractC23538x54, "$messageClickListener");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        abstractC23538x54.b().a(c8967Xz7.j().U());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p2(AbstractC23538x54 abstractC23538x54, C8967Xz7 c8967Xz7, View view) {
        AbstractC13042fc3.i(abstractC23538x54, "$messageClickListener");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        abstractC23538x54.a().a(c8967Xz7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 q2(N15.k kVar, G73 g73) {
        AbstractC13042fc3.i(kVar, "$this_with");
        AbstractC13042fc3.i(g73, "inlineButton");
        kVar.c().b().r(kVar.b(), g73);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r2(C19672qk7 c19672qk7, boolean z, UA2 ua2) {
        LinearLayout linearLayout = this.J0;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            if ((this.E0 instanceof NM) && l1(c19672qk7) && !((NM) this.E0).X1().i.a()) {
                return;
            }
            LinearLayout linearLayout2 = this.J0;
            if (linearLayout2.isLaidOut() && !linearLayout2.isLayoutRequested()) {
                C11637dL5 c11637dL5 = new C11637dL5();
                c11637dL5.a = this.E0.d().getWidth() - ((int) ((12 * AbstractC3742Cd6.c()) + 0.5d));
                Iterator it = AbstractC24379yW7.b(this.J0).iterator();
                while (it.hasNext()) {
                    c11637dL5.a = Math.max(((View) it.next()).getWidth(), c11637dL5.a);
                }
                for (View view : AbstractC24379yW7.b(this.J0)) {
                    if (!view.post(new b(view, c11637dL5))) {
                        break;
                    }
                }
            } else {
                linearLayout2.addOnLayoutChangeListener(new c());
            }
            if (c19672qk7 == null || z) {
                return;
            }
            W1(linearLayout, c19672qk7, ua2);
        }
    }

    private final void v2(C8967Xz7 c8967Xz7, InterfaceC20284rl0 interfaceC20284rl0, AbstractC23538x54 abstractC23538x54) {
        if (interfaceC20284rl0 instanceof NM) {
            C8386Vt0 c8386Vt0 = C8386Vt0.a;
            if (c8386Vt0.Tb() && c8386Vt0.Vb()) {
                AbstractC10533bm0.d(((NM) interfaceC20284rl0).U1(), C12366eV1.c().F0(), null, new d(interfaceC20284rl0, this, c8967Xz7, abstractC23538x54, null), 2, null);
            }
        }
    }

    @Override // ir.nasim.P64
    protected void V0(final C8967Xz7 c8967Xz7, Spannable spannable, boolean z, boolean z2, boolean z3, final AbstractC23538x54 abstractC23538x54, boolean z4) {
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(abstractC23538x54, "messageClickListenerAdapter");
        C9846af3 c9846af3 = this.D0;
        c9846af3.d.r(spannable);
        BubbleTextView bubbleTextView = this.D0.g;
        AbstractC13042fc3.h(bubbleTextView, "newMessageSeparator");
        bubbleTextView.setVisibility(z ? 0 : 8);
        g2(c9846af3, c8967Xz7.u(), c8967Xz7.q());
        l2(c8967Xz7, abstractC23538x54);
        B2(c8967Xz7.t(), c8967Xz7);
        a2(this.H0);
        super.V0(c8967Xz7, spannable, z, z2, z3, abstractC23538x54, z4);
        v2(c8967Xz7, this.E0, abstractC23538x54);
        r2(c8967Xz7.s(), c8967Xz7.g() != null, new UA2() { // from class: ir.nasim.I53
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return S53.Y1(abstractC23538x54, c8967Xz7, (G73) obj);
            }
        });
    }

    @Override // ir.nasim.P64, ir.nasim.AbstractC19821r0
    public void a() {
        super.a();
        InterfaceC7857Tm2 interfaceC7857Tm2 = this.I0;
        if (interfaceC7857Tm2 != null) {
            interfaceC7857Tm2.b();
        }
        this.I0 = null;
        this.D0.e.setOnClickListener(null);
        this.D0.h.setOnClickListener(null);
        AvatarViewGlide avatarViewGlide = this.D0.i;
        avatarViewGlide.setOnClickListener(null);
        OI2.b(C5721Ko.a.d()).n(avatarViewGlide);
    }

    @Override // ir.nasim.P64
    public int j1(int i) {
        ViewGroup.LayoutParams layoutParams = this.D0.f.getLayoutParams();
        AbstractC13042fc3.g(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        return ((((int) (i * ((ConstraintLayout.LayoutParams) layoutParams).c)) - I2()) - K2()) - J2();
    }

    @Override // ir.nasim.P64
    protected void z(N15 n15) {
        AbstractC13042fc3.i(n15, "payload");
        if (n15 instanceof N15.d) {
            i2(this, this.D0, ((N15.d) n15).b(), false, 2, null);
            return;
        }
        if (n15 instanceof N15.x) {
            B2(((N15.x) n15).b(), e1());
            return;
        }
        if (n15 instanceof N15.a) {
            a2(((N15.a) n15).b());
        } else if (!(n15 instanceof N15.k)) {
            super.z(n15);
        } else {
            final N15.k kVar = (N15.k) n15;
            r2(kVar.d(), kVar.b().g() != null, new UA2() { // from class: ir.nasim.J53
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return S53.q2(kVar, (G73) obj);
                }
            });
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private S53(C9846af3 c9846af3, InterfaceC20284rl0 interfaceC20284rl0, boolean z, InterfaceC22948w54 interfaceC22948w54, boolean z2, EW7 ew7, boolean z3, EnumC8893Xt7 enumC8893Xt7, boolean z4) {
        ConstraintLayout root = c9846af3.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        super(root, interfaceC20284rl0, interfaceC22948w54, enumC8893Xt7, ew7);
        this.D0 = c9846af3;
        this.E0 = interfaceC20284rl0;
        this.F0 = z;
        this.G0 = z3;
        this.H0 = z4;
        P2(z);
        c9846af3.d.setTypeface(C6011Lu2.k());
        c9846af3.g.setTypeface(C6011Lu2.i());
        this.J0 = D2(z2);
    }

    public static final class e implements InterfaceC8091Um2 {
        final /* synthetic */ SA2 b;

        e(SA2 sa2) {
            this.b = sa2;
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            AvatarViewGlide avatarViewGlide = S53.this.D0.i;
            S53 s53 = S53.this;
            AbstractC13042fc3.f(avatarViewGlide);
            s53.O2(avatarViewGlide, interfaceC3346Am2.getDescriptor());
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void e() {
            InterfaceC7857Tm2 interfaceC7857Tm2 = S53.this.I0;
            if (interfaceC7857Tm2 != null) {
                interfaceC7857Tm2.b();
            }
            S53.this.I0 = null;
            SA2 sa2 = this.b;
            if (sa2 != null) {
                sa2.invoke();
            }
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
        }
    }
}
