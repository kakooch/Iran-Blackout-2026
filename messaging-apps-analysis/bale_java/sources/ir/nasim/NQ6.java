package ir.nasim;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import ir.nasim.AbstractC11710dT6;
import ir.nasim.EnumC20117rV6;
import ir.nasim.designsystem.avatar.AvatarViewGlide;

/* loaded from: classes7.dex */
public final class NQ6 extends PQ6 {
    private final GW7 v;
    private InterfaceC12270eK4 w;
    public static final a x = new a(null);
    public static final int y = 8;
    private static final int z = AbstractC23008wB5.drawable_ring_viewed_story;
    private static final int A = AbstractC23008wB5.drawable_ring_new_story;
    private static final int B = AbstractC23008wB5.drawable_ring_error_story;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[YK6.values().length];
            try {
                iArr[YK6.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[YK6.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[YK6.a.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
            int[] iArr2 = new int[E25.values().length];
            try {
                iArr2[E25.VERIFIED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[E25.LEGAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            b = iArr2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NQ6(View view) {
        super(view);
        AbstractC13042fc3.i(view, "itemView");
        GW7 gw7A = GW7.a(view);
        AbstractC13042fc3.h(gw7A, "bind(...)");
        this.v = gw7A;
        gw7A.e.B(22.0f, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(C12335eR6 c12335eR6, InterfaceC12270eK4 interfaceC12270eK4, NQ6 nq6, View view) {
        AbstractC13042fc3.i(interfaceC12270eK4, "$listener");
        AbstractC13042fc3.i(nq6, "this$0");
        if (c12335eR6 == null) {
            interfaceC12270eK4.r();
        } else {
            interfaceC12270eK4.K2(c12335eR6, nq6.I());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(InterfaceC12270eK4 interfaceC12270eK4, View view) {
        AbstractC13042fc3.i(interfaceC12270eK4, "$listener");
        interfaceC12270eK4.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(NQ6 nq6, C21231tK7 c21231tK7) {
        AbstractC13042fc3.i(nq6, "this$0");
        nq6.X0(c21231tK7.t());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(final NQ6 nq6, C14505i18 c14505i18) {
        AbstractC13042fc3.i(nq6, "$this_run");
        AbstractC5969Lp4.d().k0().k(AbstractC5969Lp4.f()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.HQ6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                NQ6.U0(this.a, (C21231tK7) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(NQ6 nq6, C21231tK7 c21231tK7) {
        AbstractC13042fc3.i(nq6, "$this_run");
        AvatarViewGlide avatarViewGlide = nq6.v.e;
        AbstractC13042fc3.f(c21231tK7);
        AvatarViewGlide.u(avatarViewGlide, c21231tK7, null, 2, null);
        nq6.X0(c21231tK7.t());
    }

    private final void V0(final C12335eR6 c12335eR6) {
        QQ6 qq6A = c12335eR6.a();
        int i = b.a[qq6A.u().ordinal()];
        if (i == 1) {
            Z0(B);
            c1(AbstractC23008wB5.story_upload_error_badge);
            this.v.f.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.IQ6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NQ6.W0(this.a, c12335eR6, view);
                }
            });
        } else if (i == 2 || i == 3) {
            a1();
            d1();
        } else {
            if (!AbstractC13042fc3.d(qq6A.s(), AbstractC11710dT6.a.a)) {
                Z0(z);
            } else if (AbstractC9718aR6.a(qq6A)) {
                EnumC20117rV6.a aVar = EnumC20117rV6.h;
                Integer numY = qq6A.y();
                AbstractC13042fc3.f(numY);
                EnumC20117rV6 enumC20117rV6A = aVar.a(numY.intValue());
                if (enumC20117rV6A != null) {
                    Z0(enumC20117rV6A.u());
                }
            } else {
                Z0(A);
            }
            d1();
        }
        Integer numY2 = qq6A.y();
        if (numY2 != null) {
            EnumC20117rV6 enumC20117rV6A2 = EnumC20117rV6.h.a(numY2.intValue());
            if (enumC20117rV6A2 != null) {
                this.v.f.setVisibility(0);
                c1(AbstractC13042fc3.d(qq6A.s(), AbstractC11710dT6.a.a) ? enumC20117rV6A2.j() : enumC20117rV6A2.p());
            }
        }
        AppCompatImageView appCompatImageView = this.v.i;
        AbstractC13042fc3.h(appCompatImageView, "textStoryBadge");
        appCompatImageView.setVisibility(qq6A.q() ? 0 : 8);
        AppCompatImageView appCompatImageView2 = this.v.j;
        AbstractC13042fc3.h(appCompatImageView2, "textStoryBadgeBackground");
        appCompatImageView2.setVisibility(qq6A.q() && !C5495Jo7.a.J2() ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W0(NQ6 nq6, C12335eR6 c12335eR6, View view) {
        AbstractC13042fc3.i(nq6, "this$0");
        AbstractC13042fc3.i(c12335eR6, "$storyKeyItem");
        InterfaceC12270eK4 interfaceC12270eK4 = nq6.w;
        if (interfaceC12270eK4 == null) {
            AbstractC13042fc3.y("listener");
            interfaceC12270eK4 = null;
        }
        interfaceC12270eK4.K2(c12335eR6, nq6.I());
    }

    private final void X0(C19482qQ7 c19482qQ7) {
        if (c19482qQ7 != null) {
            c19482qQ7.f(new InterfaceC14756iQ7() { // from class: ir.nasim.GQ6
                @Override // ir.nasim.InterfaceC14756iQ7
                public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                    NQ6.Y0(this.a, (E25) obj, abstractC13554gQ7);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(NQ6 nq6, E25 e25, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(nq6, "this$0");
        int i = e25 == null ? -1 : b.b[e25.ordinal()];
        if (i == 1 || i == 2) {
            AppCompatImageView appCompatImageView = nq6.v.l;
            AbstractC13042fc3.h(appCompatImageView, "verified");
            appCompatImageView.setVisibility(0);
        } else {
            AppCompatImageView appCompatImageView2 = nq6.v.l;
            AbstractC13042fc3.h(appCompatImageView2, "verified");
            appCompatImageView2.setVisibility(8);
        }
    }

    private final void Z0(int i) {
        GW7 gw7 = this.v;
        gw7.k.setVisibility(4);
        gw7.g.setImageDrawable(AbstractC4043Dl1.f(C0(), i));
        gw7.g.setVisibility(0);
    }

    private final void a1() {
        GW7 gw7 = this.v;
        gw7.g.setVisibility(4);
        gw7.k.setAnimation(AbstractC18772pD5.story_upload_animation_lottie);
        gw7.k.x();
        gw7.k.setVisibility(0);
    }

    private final void c1(int i) {
        GW7 gw7 = this.v;
        gw7.b.setVisibility(8);
        gw7.f.setVisibility(0);
        gw7.f.setImageResource(i);
    }

    private final void d1() {
        GW7 gw7 = this.v;
        gw7.f.setVisibility(8);
        gw7.b.setVisibility(0);
    }

    public void O0(final C12335eR6 c12335eR6, final InterfaceC12270eK4 interfaceC12270eK4) {
        AbstractC13042fc3.i(interfaceC12270eK4, "listener");
        this.w = interfaceC12270eK4;
        this.v.f.setVisibility(8);
        this.v.b.setVisibility(0);
        AppCompatTextView appCompatTextView = this.v.h;
        appCompatTextView.setText(appCompatTextView.getContext().getText(SD5.add_story));
        Context context = appCompatTextView.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        appCompatTextView.setTextColor(OY0.b(context, AbstractC14597iA5.colorPrimary));
        this.v.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.JQ6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NQ6.P0(c12335eR6, interfaceC12270eK4, this, view);
            }
        });
        this.v.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.KQ6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NQ6.Q0(interfaceC12270eK4, view);
            }
        });
        if (c12335eR6 != null) {
            AvatarViewGlide avatarViewGlide = this.v.e;
            AbstractC13042fc3.h(avatarViewGlide, "profileAvatar");
            int iC = (int) ((5 * AbstractC3742Cd6.c()) + 0.5d);
            avatarViewGlide.setPadding(iC, iC, iC, iC);
            V0(c12335eR6);
        } else {
            AvatarViewGlide avatarViewGlide2 = this.v.e;
            AbstractC13042fc3.h(avatarViewGlide2, "profileAvatar");
            avatarViewGlide2.setPadding(0, 0, 0, 0);
            this.v.k.setVisibility(4);
            this.v.k.clearAnimation();
            this.v.g.setVisibility(4);
            AppCompatImageView appCompatImageView = this.v.i;
            AbstractC13042fc3.h(appCompatImageView, "textStoryBadge");
            appCompatImageView.setVisibility(8);
            AppCompatImageView appCompatImageView2 = this.v.j;
            AbstractC13042fc3.h(appCompatImageView2, "textStoryBadgeBackground");
            appCompatImageView2.setVisibility(8);
            d1();
        }
        C3512Be1 c3512Be1K0 = AbstractC5969Lp4.d().o2().A().k0(AbstractC5969Lp4.f());
        if (c3512Be1K0 != null) {
            this.v.e.o(c3512Be1K0);
            if (AbstractC5969Lp4.d().k0().k(AbstractC5969Lp4.f()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.LQ6
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    NQ6.S0(this.a, (C21231tK7) obj);
                }
            }) != null) {
                return;
            }
        }
        AbstractC5969Lp4.d().V0(AbstractC10360bX0.g(Integer.valueOf(AbstractC5969Lp4.f()))).m0(new InterfaceC24449ye1() { // from class: ir.nasim.MQ6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                NQ6.T0(this.a, (C14505i18) obj);
            }
        });
    }

    public final void a() {
        this.v.e.D();
    }
}
