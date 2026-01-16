package ir.nasim;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import ir.nasim.AbstractC11710dT6;
import ir.nasim.EnumC20117rV6;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class ZQ6 extends PQ6 {
    private final GW7 v;
    private final int w;
    public static final a x = new a(null);
    public static final int y = 8;
    private static final int z = AbstractC23008wB5.drawable_ring_viewed_story;
    private static final int A = AbstractC23008wB5.drawable_ring_error_story;

    public static final class a {
        private a() {
        }

        public final int a() {
            return ZQ6.z;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[E25.values().length];
            try {
                iArr[E25.VERIFIED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[E25.LEGAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZQ6(View view) {
        super(view);
        AbstractC13042fc3.i(view, "itemView");
        GW7 gw7A = GW7.a(view);
        AbstractC13042fc3.h(gw7A, "bind(...)");
        this.v = gw7A;
        this.w = AbstractC23008wB5.drawable_ring_new_story;
        gw7A.e.B(22.0f, true);
        AvatarViewGlide avatarViewGlide = gw7A.e;
        AbstractC13042fc3.h(avatarViewGlide, "profileAvatar");
        int iC = (int) ((5 * AbstractC3742Cd6.c()) + 0.5d);
        avatarViewGlide.setPadding(iC, iC, iC, iC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(ZQ6 zq6, C21231tK7 c21231tK7) {
        AbstractC13042fc3.i(zq6, "this$0");
        zq6.Y0(c21231tK7.t());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(C11692dR6 c11692dR6, final ZQ6 zq6, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c11692dR6, "$storyKey");
        AbstractC13042fc3.i(zq6, "this$0");
        AbstractC5969Lp4.d().k0().k(c11692dR6.a()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.RQ6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ZQ6.T0(this.a, (C21231tK7) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(ZQ6 zq6, C21231tK7 c21231tK7) {
        AbstractC13042fc3.i(zq6, "this$0");
        AvatarViewGlide avatarViewGlide = zq6.v.e;
        AbstractC13042fc3.f(c21231tK7);
        AvatarViewGlide.u(avatarViewGlide, c21231tK7, null, 2, null);
        zq6.v.h.setText((CharSequence) c21231tK7.r().b());
        zq6.Y0(c21231tK7.t());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(C11692dR6 c11692dR6, final ZQ6 zq6, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c11692dR6, "$storyKey");
        AbstractC13042fc3.i(zq6, "this$0");
        AbstractC5969Lp4.d().k0().k(c11692dR6.a()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.SQ6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ZQ6.V0(this.a, (C21231tK7) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V0(ZQ6 zq6, C21231tK7 c21231tK7) {
        AbstractC13042fc3.i(zq6, "this$0");
        AvatarViewGlide avatarViewGlide = zq6.v.e;
        AbstractC13042fc3.f(c21231tK7);
        AvatarViewGlide.u(avatarViewGlide, c21231tK7, null, 2, null);
        zq6.v.h.setText((CharSequence) c21231tK7.r().b());
        zq6.Y0(c21231tK7.t());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W0(C11692dR6 c11692dR6, ZQ6 zq6, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c11692dR6, "$storyKey");
        AbstractC13042fc3.i(zq6, "this$0");
        C14733iO2 c14733iO2 = (C14733iO2) AbstractC5969Lp4.b().n(c11692dR6.a());
        if (c14733iO2 != null) {
            zq6.v.e.q(c14733iO2);
            zq6.v.h.setText((CharSequence) c14733iO2.v().b());
            zq6.Y0(c14733iO2.y());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(QQ6 qq6, InterfaceC12270eK4 interfaceC12270eK4, C12335eR6 c12335eR6, ZQ6 zq6, View view) {
        AbstractC13042fc3.i(qq6, "$storyItem");
        AbstractC13042fc3.i(interfaceC12270eK4, "$listener");
        AbstractC13042fc3.i(c12335eR6, "$storyKeyItem");
        AbstractC13042fc3.i(zq6, "this$0");
        if (qq6.u() != YK6.d) {
            interfaceC12270eK4.K2(c12335eR6, zq6.I());
        }
    }

    private final void Y0(C19482qQ7 c19482qQ7) {
        if (c19482qQ7 != null) {
            c19482qQ7.f(new InterfaceC14756iQ7() { // from class: ir.nasim.TQ6
                @Override // ir.nasim.InterfaceC14756iQ7
                public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                    ZQ6.Z0(this.a, (E25) obj, abstractC13554gQ7);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z0(ZQ6 zq6, E25 e25, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(zq6, "this$0");
        int i = e25 == null ? -1 : b.a[e25.ordinal()];
        if (i == 1 || i == 2) {
            AppCompatImageView appCompatImageView = zq6.v.l;
            AbstractC13042fc3.h(appCompatImageView, "verified");
            appCompatImageView.setVisibility(0);
        } else {
            AppCompatImageView appCompatImageView2 = zq6.v.l;
            AbstractC13042fc3.h(appCompatImageView2, "verified");
            appCompatImageView2.setVisibility(8);
        }
    }

    private final void d1(int i) {
        GW7 gw7 = this.v;
        gw7.k.setVisibility(4);
        gw7.g.setImageDrawable(AbstractC4043Dl1.f(C0(), i));
        gw7.g.setVisibility(0);
    }

    private final void e1() {
        GW7 gw7 = this.v;
        gw7.g.setVisibility(4);
        gw7.k.setAnimation(AbstractC18772pD5.story_upload_animation_lottie);
        gw7.k.x();
        gw7.k.setVisibility(0);
    }

    private final void f1(int i) {
        GW7 gw7 = this.v;
        gw7.b.setVisibility(8);
        gw7.f.setVisibility(0);
        gw7.f.setImageResource(i);
    }

    @Override // ir.nasim.PQ6
    public void D0(final C12335eR6 c12335eR6, final InterfaceC12270eK4 interfaceC12270eK4) {
        AbstractC13042fc3.i(c12335eR6, "storyKeyItem");
        AbstractC13042fc3.i(interfaceC12270eK4, "listener");
        final QQ6 qq6A = c12335eR6.a();
        this.v.l.setVisibility(8);
        this.v.f.setVisibility(8);
        this.v.k.setVisibility(8);
        this.v.k.clearAnimation();
        this.v.i.setVisibility(8);
        YK6 yk6U = qq6A.u();
        YK6 yk6 = YK6.b;
        if (yk6U == yk6) {
            d1(A);
        } else if (qq6A.u() == YK6.d || qq6A.u() == YK6.a) {
            e1();
        } else if (!AbstractC13042fc3.d(qq6A.s(), AbstractC11710dT6.a.a)) {
            d1(z);
        } else if (AbstractC9718aR6.a(qq6A)) {
            EnumC20117rV6.a aVar = EnumC20117rV6.h;
            Integer numY = qq6A.y();
            AbstractC13042fc3.f(numY);
            EnumC20117rV6 enumC20117rV6A = aVar.a(numY.intValue());
            if (enumC20117rV6A != null) {
                d1(enumC20117rV6A.u());
            }
        } else {
            d1(c1());
        }
        Integer numY2 = qq6A.y();
        if (numY2 != null) {
            EnumC20117rV6 enumC20117rV6A2 = EnumC20117rV6.h.a(numY2.intValue());
            if (enumC20117rV6A2 != null) {
                f1(AbstractC13042fc3.d(qq6A.s(), AbstractC11710dT6.a.a) ? enumC20117rV6A2.j() : enumC20117rV6A2.p());
            }
        }
        AppCompatImageView appCompatImageView = this.v.i;
        AbstractC13042fc3.h(appCompatImageView, "textStoryBadge");
        appCompatImageView.setVisibility(qq6A.q() ? 0 : 8);
        AppCompatImageView appCompatImageView2 = this.v.j;
        AbstractC13042fc3.h(appCompatImageView2, "textStoryBadgeBackground");
        appCompatImageView2.setVisibility(qq6A.q() && !C5495Jo7.a.J2() ? 0 : 8);
        if (qq6A.u() == yk6) {
            f1(AbstractC23008wB5.story_upload_error_badge);
        }
        final C11692dR6 c11692dR6B = c12335eR6.b();
        if (c11692dR6B.f()) {
            C3512Be1 c3512Be1K0 = AbstractC5969Lp4.d().o2().A().k0(c11692dR6B.a());
            if (c3512Be1K0 != null) {
                this.v.e.o(c3512Be1K0);
                this.v.h.setText(c3512Be1K0.getName());
                AbstractC5969Lp4.d().k0().k(c11692dR6B.a()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.UQ6
                    @Override // ir.nasim.InterfaceC24449ye1
                    public final void apply(Object obj) {
                        ZQ6.Q0(this.a, (C21231tK7) obj);
                    }
                });
            } else {
                AbstractC5969Lp4.d().V0(AbstractC10360bX0.g(Integer.valueOf(c11692dR6B.a()))).m0(new InterfaceC24449ye1() { // from class: ir.nasim.VQ6
                    @Override // ir.nasim.InterfaceC24449ye1
                    public final void apply(Object obj) {
                        ZQ6.S0(c11692dR6B, this, (C14505i18) obj);
                    }
                });
            }
        } else if (c11692dR6B.d()) {
            AbstractC5969Lp4.d().V0(AbstractC10360bX0.g(Integer.valueOf(c11692dR6B.a()))).m0(new InterfaceC24449ye1() { // from class: ir.nasim.WQ6
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    ZQ6.U0(c11692dR6B, this, (C14505i18) obj);
                }
            });
        } else {
            C14733iO2 c14733iO2 = (C14733iO2) AbstractC5969Lp4.b().n(c11692dR6B.a());
            if (c14733iO2 != null) {
                this.v.e.q(c14733iO2);
                this.v.h.setText((CharSequence) c14733iO2.v().b());
                Y0(c14733iO2.y());
                C19938rB7 c19938rB7 = C19938rB7.a;
            } else {
                AbstractC5969Lp4.e().V().s0(new ArrayList(), AbstractC9766aX0.e(new C25238zy(c11692dR6B.a(), 0L))).m0(new InterfaceC24449ye1() { // from class: ir.nasim.XQ6
                    @Override // ir.nasim.InterfaceC24449ye1
                    public final void apply(Object obj) {
                        ZQ6.W0(c11692dR6B, this, (C14505i18) obj);
                    }
                });
            }
        }
        this.v.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.YQ6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZQ6.X0(qq6A, interfaceC12270eK4, c12335eR6, this, view);
            }
        });
    }

    public final void a() {
        this.v.e.D();
    }

    public final GW7 a1() {
        return this.v;
    }

    public int c1() {
        return this.w;
    }
}
