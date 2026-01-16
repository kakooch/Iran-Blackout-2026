package ir.nasim;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.method.MovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.button.MaterialButton;
import ir.nasim.AbstractC14879ie0;
import ir.nasim.AbstractC8081Ul1;
import ir.nasim.C12800fB6;
import ir.nasim.GY;
import ir.nasim.O98;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import ir.nasim.jaryan.feed.ui.components.FeedEmojiImageView;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes6.dex */
public abstract class JA2 extends AbstractC13019fa0 {
    public static final a K0 = new a(null);
    public static final int L0 = 8;
    private final C11258ci2 A0;
    private C5886Lg2 B0;
    private C4743Gj2 C0;
    private InterfaceC11890dj2 D0;
    private volatile C12800fB6 E0;
    private boolean F0;
    private final InterfaceC9173Yu3 G0;
    private final InterfaceC9173Yu3 H0;
    private boolean I0;
    private boolean J0;
    private final O98 z0;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class b implements InterfaceC11890dj2 {
        final /* synthetic */ C4743Gj2 b;

        b(C4743Gj2 c4743Gj2) {
            this.b = c4743Gj2;
        }

        @Override // ir.nasim.InterfaceC11890dj2
        public void a(String str, boolean z) {
            AbstractC13042fc3.i(str, "reactionCode");
            JA2.this.s1().A(str, this.b.f(), z, WH5.c, this.b.e());
            if (z) {
                JA2.this.l1().r.setImageDrawable(JA2.this.o1());
                JA2.this.N2(this.b.i() - 1);
            } else {
                if (AbstractC13042fc3.d(str, "❤")) {
                    JA2.this.l1().r.setImageResource(AbstractC18163oB5.ic_feed_heart_bold);
                } else {
                    JA2.this.l1().r.setImageDrawable(R62.A(str));
                }
                if (this.b.h().length() == 0) {
                    JA2.this.N2(this.b.i() + 1);
                }
            }
            JA2.this.z1().E();
            JA2.this.l1().r.h();
        }
    }

    public static final class c implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC18050o01.d(Long.valueOf(((C15759k74) obj2).a()), Long.valueOf(((C15759k74) obj).a()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JA2(O98 o98, C11258ci2 c11258ci2, InterfaceC13138fj2 interfaceC13138fj2) {
        super(c11258ci2, interfaceC13138fj2);
        AbstractC13042fc3.i(c11258ci2, "binding");
        AbstractC13042fc3.i(interfaceC13138fj2, "feedListener");
        this.z0 = o98;
        this.A0 = c11258ci2;
        this.G0 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.EA2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return JA2.i3(this.a);
            }
        });
        this.H0 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.FA2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return JA2.k3(this.a);
            }
        });
        this.I0 = true;
        this.J0 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A3(JA2 ja2, C4743Gj2 c4743Gj2, View view) {
        AbstractC13042fc3.i(ja2, "this$0");
        AbstractC13042fc3.i(c4743Gj2, "$feedUI");
        ja2.s1().w(c4743Gj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B2(JA2 ja2, C4743Gj2 c4743Gj2, View view) {
        AbstractC13042fc3.i(ja2, "this$0");
        AbstractC13042fc3.i(c4743Gj2, "$feedUI");
        AbstractC8081Ul1.b bVar = new AbstractC8081Ul1.b();
        List<AbstractC19657qj2> listU0 = ja2.U0(c4743Gj2.f(), c4743Gj2.g(), c4743Gj2.e());
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listU0, 10));
        for (AbstractC19657qj2 abstractC19657qj2 : listU0) {
            arrayList.add(AbstractC8081Ul1.b.k(bVar, abstractC19657qj2.c(), abstractC19657qj2.b(), null, abstractC19657qj2.a(), 4, null));
        }
        AbstractC13042fc3.f(view);
        ConstraintLayout root = ja2.l1().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        new GY.a(view, root, null, 4, null).d(true).h(new Point((int) view.getX(), 0)).b(bVar).showAsDropDown(view, -view.getWidth(), -view.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C2(C4743Gj2 c4743Gj2, JA2 ja2, View view) {
        AbstractC13042fc3.i(c4743Gj2, "$feedUI");
        AbstractC13042fc3.i(ja2, "this$0");
        List listE = AbstractC9766aX0.e(new J44(c4743Gj2.e().m(), c4743Gj2.e().e(), c4743Gj2.e().e(), c4743Gj2.e().n(), EnumC23558x74.PENDING, ja2.T0(), null, 0, new C8445Vz5(c4743Gj2.e().m(), c4743Gj2.f().p0(), c4743Gj2.f().w0(), c4743Gj2.e().e(), ja2.T0(), c4743Gj2.f().I0(), true, null), null, 0L, null, null, false, null, null, false, null, null, 523968, null));
        InterfaceC13138fj2 interfaceC13138fj2S1 = ja2.s1();
        C11458d25 c11458d25I0 = c4743Gj2.f().I0();
        AbstractC13042fc3.h(c11458d25I0, "peer(...)");
        interfaceC13138fj2S1.h(c11458d25I0, listE, XH6.b, c4743Gj2.e(), c4743Gj2);
    }

    private final void C3() {
        LinearLayout linearLayout = l1().e;
        this.J0 = true;
        AbstractC13042fc3.f(linearLayout);
        o2(linearLayout, 0.0f, 100L, true);
    }

    private final void D2(final C14697iL2 c14697iL2, final C14733iO2 c14733iO2, final C5886Lg2 c5886Lg2) {
        C19482qQ7 c19482qQ7Y;
        Avatar avatarH0 = c14697iL2.h0();
        if (avatarH0 != null) {
            l1().d.B(18.0f, true);
            AvatarViewGlide.v(l1().d, avatarH0, c14697iL2.G0(), c14697iL2.p0(), false, null, 16, null);
        }
        if (c14733iO2 != null && (c19482qQ7Y = c14733iO2.y()) != null) {
            String strG0 = c14697iL2.G0();
            AbstractC13042fc3.h(strG0, "getTitle(...)");
            a3(c19482qQ7Y, strG0);
        }
        l1().j.setText(this.a.getContext().getString(ID5.member_count, AbstractC20655sN7.g(Long.parseLong(JF5.g() ? GY6.a(String.valueOf(c14697iL2.t0())) : GY6.b(String.valueOf(c14697iL2.t0()))))));
        int[] referencedIds = l1().s.getReferencedIds();
        AbstractC13042fc3.h(referencedIds, "getReferencedIds(...)");
        for (int i : referencedIds) {
            View viewFindViewById = l1().s.getRootView().findViewById(i);
            if (viewFindViewById != null) {
                viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.uA2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        JA2.E2(this.a, c14697iL2, c5886Lg2, view);
                    }
                });
            }
        }
        MaterialButton materialButton = l1().l;
        AbstractC13042fc3.h(materialButton, "feedJoinButton");
        materialButton.setVisibility(c14697iL2.H0() ^ true ? 0 : 8);
        l1().l.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.vA2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JA2.F2(c14733iO2, this, c14697iL2, c5886Lg2, view);
            }
        });
        B1(y1().r(c14733iO2 != null ? c14733iO2.F() : null, new InterfaceC14756iQ7() { // from class: ir.nasim.wA2
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                JA2.G2(this.a, ((Boolean) obj).booleanValue(), abstractC13554gQ7);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E2(JA2 ja2, C14697iL2 c14697iL2, C5886Lg2 c5886Lg2, View view) {
        AbstractC13042fc3.i(ja2, "this$0");
        AbstractC13042fc3.i(c14697iL2, "$group");
        AbstractC13042fc3.i(c5886Lg2, "$feed");
        InterfaceC13138fj2 interfaceC13138fj2S1 = ja2.s1();
        C11458d25 c11458d25I0 = c14697iL2.I0();
        AbstractC13042fc3.h(c11458d25I0, "peer(...)");
        interfaceC13138fj2S1.z(c11458d25I0, XH6.b, c5886Lg2);
    }

    private final void E3() {
        BaleToolbar baleToolbar = l1().w;
        this.I0 = true;
        AbstractC13042fc3.f(baleToolbar);
        o2(baleToolbar, 0.0f, 100L, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F2(C14733iO2 c14733iO2, JA2 ja2, C14697iL2 c14697iL2, C5886Lg2 c5886Lg2, View view) {
        C8512Wh0 c8512Wh0F;
        Boolean bool;
        AbstractC13042fc3.i(ja2, "this$0");
        AbstractC13042fc3.i(c14697iL2, "$group");
        AbstractC13042fc3.i(c5886Lg2, "$feed");
        if (c14733iO2 == null || (c8512Wh0F = c14733iO2.F()) == null || (bool = (Boolean) c8512Wh0F.b()) == null) {
            return;
        }
        boolean zBooleanValue = bool.booleanValue();
        InterfaceC13138fj2 interfaceC13138fj2S1 = ja2.s1();
        C11458d25 c11458d25I0 = c14697iL2.I0();
        AbstractC13042fc3.h(c11458d25I0, "peer(...)");
        interfaceC13138fj2S1.m(zBooleanValue, c11458d25I0, XH6.c, c5886Lg2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G2(JA2 ja2, boolean z, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(ja2, "this$0");
        if (z) {
            ja2.l1().l.setText(ja2.l1().getRoot().getContext().getString(ID5.btn_show));
        } else {
            ja2.l1().l.setText(ja2.l1().getRoot().getContext().getString(ID5.btn_join));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean I2(JA2 ja2, TextView textView, String str) {
        AbstractC13042fc3.i(ja2, "this$0");
        InterfaceC13138fj2 interfaceC13138fj2S1 = ja2.s1();
        AbstractC13042fc3.f(str);
        return interfaceC13138fj2S1.e(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 J2(JA2 ja2) {
        AbstractC13042fc3.i(ja2, "this$0");
        if (ja2.l1().w.getY() > 0.0f) {
            ja2.p3();
            ja2.o3();
            ja2.s1().o();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 K2(JA2 ja2) {
        AbstractC13042fc3.i(ja2, "this$0");
        if (ja2.l1().w.getY() < 0.0f) {
            ja2.E3();
            ja2.C3();
            ja2.s1().u();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean P2(JA2 ja2, View view) {
        AbstractC13042fc3.i(ja2, "this$0");
        D20 d20Z1 = ja2.z1();
        AbstractC13042fc3.f(view);
        d20Z1.M0(view, 50, -5);
        ja2.s1().n();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean S2(JA2 ja2, View view) {
        AbstractC13042fc3.i(ja2, "this$0");
        D20 d20Z1 = ja2.z1();
        AbstractC13042fc3.f(view);
        d20Z1.M0(view, 50, -5);
        ja2.s1().n();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean T2(C4743Gj2 c4743Gj2, JA2 ja2) {
        AbstractC13042fc3.i(c4743Gj2, "$feedUI");
        AbstractC13042fc3.i(ja2, "this$0");
        if ((!c4743Gj2.d().isEmpty()) && !AbstractC13042fc3.d(c4743Gj2.h(), "❤")) {
            if (ja2.e3(c4743Gj2)) {
                ja2.s1().A("❤", c4743Gj2.f(), false, WH5.d, c4743Gj2.e());
                ja2.l1().r.setImageResource(AbstractC18163oB5.ic_feed_heart_bold);
                ja2.N2(c4743Gj2.i() + 1);
            } else {
                ja2.l1().r.performLongClick();
            }
        }
        ja2.l1().r.h();
        ja2.c1();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U2(C4743Gj2 c4743Gj2, JA2 ja2, View view) {
        AbstractC13042fc3.i(c4743Gj2, "$feedUI");
        AbstractC13042fc3.i(ja2, "this$0");
        if (c4743Gj2.h().length() != 0) {
            ja2.s1().A(c4743Gj2.h(), c4743Gj2.f(), true, WH5.b, c4743Gj2.e());
            ja2.l1().r.setImageDrawable(ja2.o1());
            ja2.N2(c4743Gj2.i() - 1);
            ja2.l1().r.h();
            return;
        }
        if (!ja2.e3(c4743Gj2)) {
            ja2.l1().r.performLongClick();
            return;
        }
        ja2.s1().A("❤", c4743Gj2.f(), false, WH5.b, c4743Gj2.e());
        ja2.l1().r.setImageResource(AbstractC18163oB5.ic_feed_heart_bold);
        ja2.N2(c4743Gj2.i() + 1);
        if (ja2.s1().d()) {
            ja2.s1().t();
        }
        ja2.l1().r.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V2(C4743Gj2 c4743Gj2, JA2 ja2, View view) {
        AbstractC13042fc3.i(c4743Gj2, "$feedUI");
        AbstractC13042fc3.i(ja2, "this$0");
        if (c4743Gj2.h().length() != 0) {
            ja2.s1().A(c4743Gj2.h(), c4743Gj2.f(), true, WH5.b, c4743Gj2.e());
            ja2.l1().r.setImageDrawable(ja2.o1());
            ja2.N2(c4743Gj2.i() - 1);
            ja2.l1().r.h();
            return;
        }
        if (!ja2.e3(c4743Gj2)) {
            ja2.l1().r.performLongClick();
            return;
        }
        ja2.s1().A("❤", c4743Gj2.f(), false, WH5.b, c4743Gj2.e());
        ja2.l1().r.setImageResource(AbstractC18163oB5.ic_feed_heart_bold);
        ja2.N2(c4743Gj2.i() + 1);
        if (ja2.s1().d()) {
            ja2.s1().t();
        }
        ja2.l1().r.h();
    }

    private final void Y2(final C4743Gj2 c4743Gj2) {
        if (c4743Gj2.e().p() == null || c4743Gj2.e().p().intValue() <= 0 || !C8386Vt0.Ea()) {
            LinearLayout linearLayout = l1().E;
            AbstractC13042fc3.h(linearLayout, "upvotersBottomBar");
            linearLayout.setVisibility(8);
            return;
        }
        LinearLayout linearLayout2 = l1().E;
        AbstractC13042fc3.h(linearLayout2, "upvotersBottomBar");
        linearLayout2.setVisibility(0);
        String strG = AbstractC20655sN7.g(c4743Gj2.e().p().intValue());
        String string = c4743Gj2.e().p().intValue() > 1 ? l1().getRoot().getContext().getString(ID5.feed_suggesters_number, strG) : l1().getRoot().getContext().getString(ID5.feed_suggesters_number_many, strG);
        AbstractC13042fc3.f(string);
        l1().D.setText(string);
        l1().E.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.GA2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JA2.Z2(this.a, c4743Gj2, view);
            }
        });
        l1().A.B(12.0f, true);
        l1().B.B(12.0f, true);
        l1().C.B(12.0f, true);
        Integer numP = c4743Gj2.e().p();
        if (numP != null && numP.intValue() == 1) {
            AvatarViewGlide avatarViewGlide = l1().A;
            AbstractC13042fc3.h(avatarViewGlide, "upVotersAvatar1");
            avatarViewGlide.setVisibility(0);
            AvatarViewGlide avatarViewGlide2 = l1().B;
            AbstractC13042fc3.h(avatarViewGlide2, "upVotersAvatar2");
            avatarViewGlide2.setVisibility(8);
            AvatarViewGlide avatarViewGlide3 = l1().C;
            AbstractC13042fc3.h(avatarViewGlide3, "upVotersAvatar3");
            avatarViewGlide3.setVisibility(8);
        } else if (numP != null && numP.intValue() == 2) {
            AvatarViewGlide avatarViewGlide4 = l1().A;
            AbstractC13042fc3.h(avatarViewGlide4, "upVotersAvatar1");
            avatarViewGlide4.setVisibility(0);
            AvatarViewGlide avatarViewGlide5 = l1().B;
            AbstractC13042fc3.h(avatarViewGlide5, "upVotersAvatar2");
            avatarViewGlide5.setVisibility(0);
            AvatarViewGlide avatarViewGlide6 = l1().C;
            AbstractC13042fc3.h(avatarViewGlide6, "upVotersAvatar3");
            avatarViewGlide6.setVisibility(8);
        } else {
            AvatarViewGlide avatarViewGlide7 = l1().C;
            AbstractC13042fc3.h(avatarViewGlide7, "upVotersAvatar3");
            avatarViewGlide7.setVisibility(0);
            AvatarViewGlide avatarViewGlide8 = l1().B;
            AbstractC13042fc3.h(avatarViewGlide8, "upVotersAvatar2");
            avatarViewGlide8.setVisibility(0);
            AvatarViewGlide avatarViewGlide9 = l1().A;
            AbstractC13042fc3.h(avatarViewGlide9, "upVotersAvatar1");
            avatarViewGlide9.setVisibility(0);
        }
        X2(c4743Gj2.j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z2(JA2 ja2, C4743Gj2 c4743Gj2, View view) {
        AbstractC13042fc3.i(ja2, "this$0");
        AbstractC13042fc3.i(c4743Gj2, "$feedUI");
        ja2.s1().B(c4743Gj2.e());
    }

    private final void a3(C19482qQ7 c19482qQ7, String str) {
        l1().k.setText(str);
        C1(y1().r(c19482qQ7, new InterfaceC14756iQ7() { // from class: ir.nasim.AA2
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                JA2.b3(this.a, (E25) obj, abstractC13554gQ7);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b3(JA2 ja2, E25 e25, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(ja2, "this$0");
        if (e25 != E25.VERIFIED) {
            ja2.l1().k.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            ja2.l1().k.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, AbstractC4043Dl1.f(ja2.a.getContext(), KB5.blue_tick), (Drawable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d3(JA2 ja2) {
        AbstractC13042fc3.i(ja2, "this$0");
        ja2.F0 = false;
    }

    private final boolean e3(C4743Gj2 c4743Gj2) {
        return c4743Gj2.d().contains("❤");
    }

    private final C12800fB6 g3(C5886Lg2 c5886Lg2) {
        C12800fB6 c12800fB6 = this.E0;
        if (c12800fB6 != null) {
            return c12800fB6;
        }
        C12800fB6 c12800fB6H3 = h3(c5886Lg2);
        this.E0 = c12800fB6H3;
        return c12800fB6H3;
    }

    private final C12800fB6 h3(C5886Lg2 c5886Lg2) {
        Context context = this.a.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        C12800fB6.a aVarT = new C12800fB6.a(context).t(1, 1);
        String string = this.a.getContext().getString(ID5.resizable_text_read_more);
        AbstractC13042fc3.h(string, "getString(...)");
        C12800fB6 c12800fB6A = aVarT.q(string).r(AbstractC4043Dl1.c(this.a.getContext(), AA5.onBackground_fixed)).p(true).b(false).s(true, true).a();
        c12800fB6A.v(new d(c5886Lg2));
        return c12800fB6A;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C4485Fi2 i3(JA2 ja2) {
        AbstractC13042fc3.i(ja2, "this$0");
        Context context = ja2.l1().getRoot().getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        return new C4485Fi2(context, ja2.r1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ColorDrawable k3(JA2 ja2) {
        AbstractC13042fc3.i(ja2, "this$0");
        return new ColorDrawable(AbstractC4043Dl1.c(ja2.a.getContext(), AA5.background_fixed));
    }

    private final void o2(View view, float f, long j, boolean z) {
        view.animate().translationY(f).alpha(z ? 1.0f : 0.0f).setInterpolator(z ? InterpolatorC12631ew1.i : InterpolatorC12631ew1.g).setDuration(j);
    }

    private final void o3() {
        LinearLayout linearLayout = l1().e;
        this.J0 = false;
        AbstractC13042fc3.f(linearLayout);
        o2(linearLayout, linearLayout.getHeight(), 100L, false);
    }

    private final void p3() {
        BaleToolbar baleToolbar = l1().w;
        this.I0 = false;
        AbstractC13042fc3.f(baleToolbar);
        o2(baleToolbar, -baleToolbar.getHeight(), 100L, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean q2(JA2 ja2, View view, MotionEvent motionEvent) {
        AbstractC13042fc3.i(ja2, "this$0");
        C4485Fi2 c4485Fi2Q1 = ja2.q1();
        AbstractC13042fc3.f(motionEvent);
        return c4485Fi2Q1.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r2(JA2 ja2, View view) {
        AbstractC13042fc3.i(ja2, "this$0");
        AbstractC13042fc3.i(view, "it");
        ja2.s1().a();
        return C19938rB7.a;
    }

    private final void u3(TextView textView) {
        C12800fB6 c12800fB6 = this.E0;
        if (c12800fB6 != null) {
            CharSequence text = textView.getText();
            AbstractC13042fc3.h(text, "getText(...)");
            c12800fB6.t(textView, text, false);
        }
    }

    private final void v2(final C4743Gj2 c4743Gj2) {
        N2(c4743Gj2.i());
        l1().n.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.xA2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JA2.B2(this.a, c4743Gj2, view);
            }
        });
        l1().i.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.yA2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JA2.C2(c4743Gj2, this, view);
            }
        });
    }

    private final void y3() {
        L93 l93F;
        BaleToolbar baleToolbar = l1().w;
        AbstractC13042fc3.h(baleToolbar, "fullScreenToolbar");
        ViewGroup.LayoutParams layoutParams = baleToolbar.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        O98 o98 = this.z0;
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, (o98 == null || (l93F = o98.f(O98.m.h())) == null) ? 0 : l93F.b, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        baleToolbar.setLayoutParams(marginLayoutParams);
    }

    public void H2(C5886Lg2 c5886Lg2, AbstractC15520jj2 abstractC15520jj2) {
        AbstractC13042fc3.i(c5886Lg2, "feed");
        AbstractC13042fc3.i(abstractC15520jj2, DialogEntity.COLUMN_MESSAGE);
        t1().i(new AbstractC14879ie0.d() { // from class: ir.nasim.oA2
            @Override // ir.nasim.AbstractC14879ie0.d
            public final boolean a(TextView textView, String str) {
                return JA2.I2(this.a, textView, str);
            }
        });
        r1().f(new SA2() { // from class: ir.nasim.zA2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return JA2.J2(this.a);
            }
        });
        r1().e(new SA2() { // from class: ir.nasim.BA2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return JA2.K2(this.a);
            }
        });
    }

    public final void N2(long j) {
        if (j > 0) {
            l1().q.setText(AbstractC20655sN7.g(j));
        }
    }

    public final void O2(final C4743Gj2 c4743Gj2) {
        AbstractC13042fc3.i(c4743Gj2, "feedUI");
        if (c4743Gj2.d().isEmpty()) {
            FeedEmojiImageView feedEmojiImageView = l1().r;
            AbstractC13042fc3.h(feedEmojiImageView, "feedReactionIv");
            feedEmojiImageView.setVisibility(8);
            TextView textView = l1().q;
            AbstractC13042fc3.h(textView, "feedReactionCount");
            textView.setVisibility(8);
        } else {
            FeedEmojiImageView feedEmojiImageView2 = l1().r;
            AbstractC13042fc3.h(feedEmojiImageView2, "feedReactionIv");
            feedEmojiImageView2.setVisibility(0);
            TextView textView2 = l1().q;
            AbstractC13042fc3.h(textView2, "feedReactionCount");
            textView2.setVisibility(0);
        }
        if (c4743Gj2.h().length() <= 0) {
            l1().r.setImageDrawable(o1());
        } else if (!AbstractC13042fc3.d(c4743Gj2.h(), "❤")) {
            l1().r.setImageDrawable(R62.A(c4743Gj2.h()));
        } else if (e3(c4743Gj2)) {
            l1().r.setImageResource(AbstractC18163oB5.ic_feed_heart_bold);
            l1().r.setColorFilter(0);
        } else {
            l1().r.performLongClick();
        }
        l1().r.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.HA2
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return JA2.P2(this.a, view);
            }
        });
        l1().q.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.IA2
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return JA2.S2(this.a, view);
            }
        });
        this.D0 = new b(c4743Gj2);
        r1().d(new SA2() { // from class: ir.nasim.pA2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(JA2.T2(c4743Gj2, this));
            }
        });
        InterfaceC11890dj2 interfaceC11890dj2 = this.D0;
        if (interfaceC11890dj2 != null) {
            C22134uj2 c22134uj2 = new C22134uj2(interfaceC11890dj2);
            View viewFindViewById = z1().Q().findViewById(AbstractC12808fC5.feed_reactions_rv);
            AbstractC13042fc3.h(viewFindViewById, "findViewById(...)");
            ((RecyclerView) viewFindViewById).setAdapter(c22134uj2);
            List listK = c4743Gj2.e().k();
            ArrayList arrayList = new ArrayList();
            for (Object obj : listK) {
                if (!AbstractC13042fc3.d(((C15759k74) obj).b(), "👁️")) {
                    arrayList.add(obj);
                }
            }
            FeedEmojiImageView feedEmojiImageView3 = l1().r;
            AbstractC13042fc3.h(feedEmojiImageView3, "feedReactionIv");
            feedEmojiImageView3.setVisibility(arrayList.isEmpty() ^ true ? 0 : 8);
            TextView textView3 = l1().q;
            AbstractC13042fc3.h(textView3, "feedReactionCount");
            textView3.setVisibility(arrayList.isEmpty() ^ true ? 0 : 8);
            if (!arrayList.isEmpty()) {
                c22134uj2.C(AbstractC15401jX0.a1(arrayList, new c()));
            }
        }
        l1().r.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.qA2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JA2.U2(c4743Gj2, this, view);
            }
        });
        l1().q.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.rA2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JA2.V2(c4743Gj2, this, view);
            }
        });
    }

    public final void X2(List list) {
        AbstractC13042fc3.i(list, "users");
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            C17637nI7 c17637nI7 = (C17637nI7) obj;
            if (i == 0) {
                AvatarViewGlide.v(l1().A, c17637nI7.S(), c17637nI7.getName(), c17637nI7.n0(), c17637nI7.r0(), null, 16, null);
            }
            if (i == 1) {
                AvatarViewGlide.v(l1().B, c17637nI7.S(), c17637nI7.getName(), c17637nI7.n0(), c17637nI7.r0(), null, 16, null);
            }
            if (i == 2) {
                AvatarViewGlide.v(l1().C, c17637nI7.S(), c17637nI7.getName(), c17637nI7.n0(), c17637nI7.r0(), null, 16, null);
            }
            i = i2;
        }
    }

    @Override // ir.nasim.AbstractC13019fa0
    public void a() {
        super.a();
        l1().d.D();
        this.B0 = null;
    }

    @Override // ir.nasim.AbstractC13019fa0
    public final void c1() {
        LottieAnimationView lottieAnimationView = l1().p;
        AbstractC13042fc3.h(lottieAnimationView, "feedReactionAnim");
        lottieAnimationView.setVisibility(0);
        l1().p.x();
    }

    public final void c3(View view) {
        AbstractC13042fc3.i(view, "captionView");
        if (this.F0) {
            TextView textView = l1().o;
            AbstractC13042fc3.h(textView, "feedPhotoText");
            u3(textView);
            l1().o.postDelayed(new Runnable() { // from class: ir.nasim.sA2
                @Override // java.lang.Runnable
                public final void run() {
                    JA2.d3(this.a);
                }
            }, 100L);
            l1().e.setBackground(new ColorDrawable(0));
        }
        view.setOnClickListener(null);
    }

    public final void f3(TextView textView, C5886Lg2 c5886Lg2, String str, MovementMethod movementMethod) {
        C12800fB6 c12800fB6;
        AbstractC13042fc3.i(textView, "textView");
        AbstractC13042fc3.i(c5886Lg2, "feed");
        AbstractC13042fc3.i(str, "caption");
        AbstractC13042fc3.i(movementMethod, "feedMovementMethod");
        g3(c5886Lg2);
        textView.setMovementMethod(movementMethod);
        CharSequence charSequenceE = p1().e(str);
        if (charSequenceE == null || (c12800fB6 = this.E0) == null) {
            return;
        }
        c12800fB6.t(textView, charSequenceE, false);
    }

    /* renamed from: l3 */
    public abstract C11258ci2 l1();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC13019fa0
    /* renamed from: m3, reason: merged with bridge method [inline-methods] */
    public C4485Fi2 q1() {
        return (C4485Fi2) this.G0.getValue();
    }

    public final C4743Gj2 n3() {
        return this.C0;
    }

    public final void p2(C4743Gj2 c4743Gj2) {
        AbstractC13042fc3.i(c4743Gj2, "feedUI");
        this.C0 = c4743Gj2;
        l1().getRoot().setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.CA2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return JA2.q2(this.a, view, motionEvent);
            }
        });
        z3(c4743Gj2);
        v2(c4743Gj2);
        D2(c4743Gj2.f(), c4743Gj2.g(), c4743Gj2.e());
        Y2(c4743Gj2);
        O2(c4743Gj2);
        InterfaceC13138fj2 interfaceC13138fj2S1 = s1();
        C11458d25 c11458d25I0 = c4743Gj2.f().I0();
        AbstractC13042fc3.h(c11458d25I0, "peer(...)");
        interfaceC13138fj2S1.k(c11458d25I0, c4743Gj2.f().getAccessHash(), new C8755Xe4(c4743Gj2.e().f().getPeerId(), c4743Gj2.e().e(), c4743Gj2.e().m(), 0, 8, null));
        BaleToolbar.setHasBackButtonClickListener$default(l1().w, true, false, new UA2() { // from class: ir.nasim.DA2
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return JA2.r2(this.a, (View) obj);
            }
        }, 2, null);
        y3();
    }

    public final boolean t3() {
        return this.F0;
    }

    public final void v3(C5886Lg2 c5886Lg2) {
        this.B0 = c5886Lg2;
    }

    public final void w3(boolean z) {
        this.F0 = z;
    }

    public void z3(final C4743Gj2 c4743Gj2) {
        C19482qQ7 c19482qQ7O;
        AbstractC13042fc3.i(c4743Gj2, "feedUI");
        TextView textView = l1().f;
        AbstractC13042fc3.h(textView, "feedCommentCount");
        textView.setVisibility(8);
        ImageView imageView = l1().g;
        AbstractC13042fc3.h(imageView, "feedCommentIv");
        imageView.setVisibility(8);
        C14733iO2 c14733iO2G = c4743Gj2.g();
        if (c14733iO2G == null || (c19482qQ7O = c14733iO2G.o()) == null || ((Integer) c19482qQ7O.b()) == null) {
            return;
        }
        boolean z = c4743Gj2.e().l() != null;
        TextView textView2 = l1().f;
        AbstractC13042fc3.h(textView2, "feedCommentCount");
        textView2.setVisibility(z ? 0 : 8);
        ImageView imageView2 = l1().g;
        AbstractC13042fc3.h(imageView2, "feedCommentIv");
        imageView2.setVisibility(z ? 0 : 8);
        C17532n74 c17532n74L = c4743Gj2.e().l();
        if (c17532n74L != null) {
            if (c17532n74L.E() == 0) {
                l1().f.setText("");
            } else {
                l1().f.setText(XY6.v(XY6.i(c17532n74L.E())));
            }
        }
        l1().g.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.tA2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JA2.A3(this.a, c4743Gj2, view);
            }
        });
    }

    public static final class d implements C12800fB6.c {
        final /* synthetic */ C5886Lg2 b;

        d(C5886Lg2 c5886Lg2) {
            this.b = c5886Lg2;
        }

        @Override // ir.nasim.C12800fB6.c
        public void b() {
            if (!JA2.this.t3()) {
                JA2.this.w3(true);
                JA2.this.s1().i(this.b);
            }
            int iC = AbstractC4043Dl1.c(JA2.this.a.getContext(), AA5.surface_fixed);
            JA2.this.l1().e.setBackground(new ColorDrawable(Color.argb(AbstractC20723sV3.c(Color.alpha(iC) * 0.6d), Color.red(iC), Color.green(iC), Color.blue(iC))));
        }

        @Override // ir.nasim.C12800fB6.c
        public void a() {
        }
    }
}
