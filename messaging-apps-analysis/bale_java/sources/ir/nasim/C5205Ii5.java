package ir.nasim;

import android.view.View;
import ir.nasim.AbstractC11710dT6;
import ir.nasim.EnumC20117rV6;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import java.util.ArrayList;

/* renamed from: ir.nasim.Ii5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C5205Ii5 extends ZQ6 {
    private int B;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5205Ii5(View view) {
        super(view);
        AbstractC13042fc3.i(view, "itemView");
        this.B = AbstractC23008wB5.drawble_ring_popular_story;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o1(C12335eR6 c12335eR6, C5205Ii5 c5205Ii5, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c12335eR6, "$storyKeyItem");
        AbstractC13042fc3.i(c5205Ii5, "this$0");
        C14733iO2 c14733iO2 = (C14733iO2) AbstractC5969Lp4.b().n(c12335eR6.b().a());
        if (c14733iO2 != null) {
            c5205Ii5.a1().e.q(c14733iO2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(InterfaceC12270eK4 interfaceC12270eK4, C12335eR6 c12335eR6, C5205Ii5 c5205Ii5, View view) {
        AbstractC13042fc3.i(interfaceC12270eK4, "$listener");
        AbstractC13042fc3.i(c12335eR6, "$storyKeyItem");
        AbstractC13042fc3.i(c5205Ii5, "this$0");
        interfaceC12270eK4.K2(c12335eR6, c5205Ii5.I());
    }

    private final void q1(final C12335eR6 c12335eR6) {
        if (c12335eR6.b().f()) {
            C3512Be1 c3512Be1K0 = AbstractC5969Lp4.d().o2().A().k0(c12335eR6.b().a());
            if (c3512Be1K0 == null) {
                AbstractC5969Lp4.d().V0(AbstractC10360bX0.g(Integer.valueOf(c12335eR6.b().a()))).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Di5
                    @Override // ir.nasim.InterfaceC24449ye1
                    public final void apply(Object obj) {
                        C5205Ii5.r1(c12335eR6, this, (C14505i18) obj);
                    }
                });
                return;
            }
            a1().e.o(c3512Be1K0);
            a1().h.setText(c3512Be1K0.getName());
            AbstractC5969Lp4.d().k0().k(c12335eR6.b().a());
            return;
        }
        C14733iO2 c14733iO2 = (C14733iO2) AbstractC5969Lp4.b().n(c12335eR6.b().a());
        if (c14733iO2 == null) {
            AbstractC5969Lp4.e().V().s0(new ArrayList(), AbstractC9766aX0.e(new C25238zy(c12335eR6.b().a(), 0L))).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Ei5
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C5205Ii5.t1(c12335eR6, this, (C14505i18) obj);
                }
            });
            return;
        }
        a1().e.q(c14733iO2);
        a1().h.setText((CharSequence) c14733iO2.v().b());
        C19938rB7 c19938rB7 = C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r1(C12335eR6 c12335eR6, final C5205Ii5 c5205Ii5, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c12335eR6, "$storyKeyItem");
        AbstractC13042fc3.i(c5205Ii5, "this$0");
        AbstractC5969Lp4.d().k0().k(c12335eR6.b().a()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Fi5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C5205Ii5.s1(this.a, (C21231tK7) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s1(C5205Ii5 c5205Ii5, C21231tK7 c21231tK7) {
        AbstractC13042fc3.i(c5205Ii5, "this$0");
        AvatarViewGlide avatarViewGlide = c5205Ii5.a1().e;
        AbstractC13042fc3.f(c21231tK7);
        AvatarViewGlide.u(avatarViewGlide, c21231tK7, null, 2, null);
        c5205Ii5.a1().h.setText((CharSequence) c21231tK7.r().b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t1(C12335eR6 c12335eR6, C5205Ii5 c5205Ii5, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c12335eR6, "$storyKeyItem");
        AbstractC13042fc3.i(c5205Ii5, "this$0");
        C14733iO2 c14733iO2 = (C14733iO2) AbstractC5969Lp4.b().n(c12335eR6.b().a());
        if (c14733iO2 != null) {
            c5205Ii5.a1().e.q(c14733iO2);
            c5205Ii5.a1().h.setText((CharSequence) c14733iO2.v().b());
        }
    }

    @Override // ir.nasim.ZQ6, ir.nasim.PQ6
    public void D0(final C12335eR6 c12335eR6, final InterfaceC12270eK4 interfaceC12270eK4) {
        AbstractC13042fc3.i(c12335eR6, "storyKeyItem");
        AbstractC13042fc3.i(interfaceC12270eK4, "listener");
        C14733iO2 c14733iO2 = (C14733iO2) AbstractC5969Lp4.b().n(c12335eR6.b().a());
        if (c14733iO2 != null) {
            a1().e.q(c14733iO2);
        } else {
            AbstractC5969Lp4.e().V().s0(new ArrayList(), AbstractC9766aX0.e(new C25238zy(c12335eR6.b().a(), 0L))).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Gi5
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C5205Ii5.o1(c12335eR6, this, (C14505i18) obj);
                }
            });
        }
        a1().c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Hi5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C5205Ii5.p1(interfaceC12270eK4, c12335eR6, this, view);
            }
        });
        if (!AbstractC13042fc3.d(c12335eR6.a().s(), AbstractC11710dT6.a.a)) {
            a1().g.setImageDrawable(AbstractC4043Dl1.f(C0(), ZQ6.x.a()));
        } else if (!AbstractC9718aR6.a(c12335eR6.a()) || AbstractC9766aX0.e(645784619).contains(Integer.valueOf(c12335eR6.b().a()))) {
            a1().g.setImageDrawable(AbstractC4043Dl1.f(C0(), c1()));
        } else {
            EnumC20117rV6.a aVar = EnumC20117rV6.h;
            Integer numY = c12335eR6.a().y();
            AbstractC13042fc3.f(numY);
            EnumC20117rV6 enumC20117rV6A = aVar.a(numY.intValue());
            if (enumC20117rV6A != null) {
                a1().g.setImageResource(enumC20117rV6A.u());
            }
        }
        q1(c12335eR6);
    }

    @Override // ir.nasim.ZQ6
    public int c1() {
        return this.B;
    }
}
