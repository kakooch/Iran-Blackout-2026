package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import ir.nasim.AbstractC14879ie0;
import ir.nasim.AbstractC8081Ul1;
import ir.nasim.C12800fB6;
import ir.nasim.D20;
import ir.nasim.GY;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import ir.nasim.jaryan.feed.ui.components.FeedEmojiImageView;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* renamed from: ir.nasim.bj2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC10505bj2 extends AbstractC13019fa0 {
    private final InterfaceC9173Yu3 A0;
    private final InterfaceC9173Yu3 B0;
    private InterfaceC11890dj2 C0;
    private C12800fB6 D0;
    private final d E0;
    private C4743Gj2 F0;
    private final C11268cj2 z0;

    /* renamed from: ir.nasim.bj2$a */
    public static final class a implements InterfaceC11890dj2 {
        final /* synthetic */ C4743Gj2 b;

        a(C4743Gj2 c4743Gj2) {
            this.b = c4743Gj2;
        }

        @Override // ir.nasim.InterfaceC11890dj2
        public void a(String str, boolean z) {
            AbstractC13042fc3.i(str, "reactionCode");
            AbstractC10505bj2.this.s1().A(str, this.b.f(), z, WH5.c, this.b.e());
            if (z) {
                AbstractC10505bj2.this.l1().u.setImageDrawable(AbstractC10505bj2.this.o1());
                AbstractC10505bj2.this.G2(this.b.i() - 1);
            } else {
                if (AbstractC13042fc3.d(str, "❤")) {
                    AbstractC10505bj2.this.l1().u.setImageResource(AbstractC18163oB5.ic_feed_heart_bold);
                } else {
                    AbstractC10505bj2.this.l1().u.setImageDrawable(R62.A(str));
                }
                if (this.b.h().length() == 0) {
                    AbstractC10505bj2.this.G2(this.b.i() + 1);
                }
            }
            AbstractC10505bj2.this.z1().E();
            AbstractC10505bj2.this.l1().u.h();
        }
    }

    /* renamed from: ir.nasim.bj2$b */
    public static final class b implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC18050o01.d(Long.valueOf(((C15759k74) obj2).a()), Long.valueOf(((C15759k74) obj).a()));
        }
    }

    /* renamed from: ir.nasim.bj2$d */
    public static final class d extends ClickableSpan {
        d() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            AbstractC13042fc3.i(view, "view");
            D20.N0(AbstractC10505bj2.this.k3(), view, 0, 0, 6, null);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            AbstractC13042fc3.i(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC10505bj2(C11268cj2 c11268cj2, InterfaceC13138fj2 interfaceC13138fj2) {
        super(c11268cj2, interfaceC13138fj2);
        AbstractC13042fc3.i(c11268cj2, "binding");
        AbstractC13042fc3.i(interfaceC13138fj2, "feedListener");
        this.z0 = c11268cj2;
        this.A0 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Wi2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AbstractC10505bj2.o3(this.a);
            }
        });
        this.B0 = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Xi2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AbstractC10505bj2.E3(this.a);
            }
        });
        this.E0 = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A3(AbstractC10505bj2 abstractC10505bj2, C4743Gj2 c4743Gj2, View view) {
        AbstractC13042fc3.i(abstractC10505bj2, "this$0");
        AbstractC13042fc3.i(c4743Gj2, "$feedUI");
        abstractC10505bj2.s1().w(c4743Gj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B2(C14733iO2 c14733iO2, AbstractC10505bj2 abstractC10505bj2, C14697iL2 c14697iL2, C5886Lg2 c5886Lg2, View view) {
        C8512Wh0 c8512Wh0F;
        Boolean bool;
        AbstractC13042fc3.i(abstractC10505bj2, "this$0");
        AbstractC13042fc3.i(c14697iL2, "$group");
        AbstractC13042fc3.i(c5886Lg2, "$feed");
        if (c14733iO2 == null || (c8512Wh0F = c14733iO2.F()) == null || (bool = (Boolean) c8512Wh0F.b()) == null) {
            return;
        }
        boolean zBooleanValue = bool.booleanValue();
        InterfaceC13138fj2 interfaceC13138fj2S1 = abstractC10505bj2.s1();
        C11458d25 c11458d25I0 = c14697iL2.I0();
        AbstractC13042fc3.h(c11458d25I0, "peer(...)");
        interfaceC13138fj2S1.m(zBooleanValue, c11458d25I0, XH6.c, c5886Lg2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C2(AbstractC10505bj2 abstractC10505bj2, C14697iL2 c14697iL2, C5886Lg2 c5886Lg2, View view) {
        AbstractC13042fc3.i(abstractC10505bj2, "this$0");
        AbstractC13042fc3.i(c14697iL2, "$group");
        AbstractC13042fc3.i(c5886Lg2, "$feed");
        InterfaceC13138fj2 interfaceC13138fj2S1 = abstractC10505bj2.s1();
        C11458d25 c11458d25I0 = c14697iL2.I0();
        AbstractC13042fc3.h(c11458d25I0, "peer(...)");
        interfaceC13138fj2S1.z(c11458d25I0, XH6.b, c5886Lg2);
    }

    private final void C3() {
        C11268cj2 c11268cj2L1 = l1();
        TextView textView = c11268cj2L1.o;
        C20837sh2 c20837sh2 = C20837sh2.a;
        textView.setTextSize(c20837sh2.c());
        c11268cj2L1.n.setTextSize(c20837sh2.c());
        if (AbstractC8943Xx1.c(c20837sh2.a()) != c11268cj2L1.c.getWidth()) {
            AvatarViewGlide avatarViewGlide = c11268cj2L1.c;
            AbstractC13042fc3.h(avatarViewGlide, "feedAvatar");
            ViewGroup.LayoutParams layoutParams = avatarViewGlide.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            layoutParams.width = AbstractC8943Xx1.c(c20837sh2.a());
            layoutParams.height = AbstractC8943Xx1.c(c20837sh2.a());
            avatarViewGlide.setLayoutParams(layoutParams);
            c11268cj2L1.c.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D2(AbstractC10505bj2 abstractC10505bj2, boolean z, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(abstractC10505bj2, "this$0");
        if (z) {
            abstractC10505bj2.l1().q.setText(abstractC10505bj2.l1().getRoot().getContext().getString(ID5.btn_show));
        } else {
            abstractC10505bj2.l1().q.setText(abstractC10505bj2.l1().getRoot().getContext().getString(ID5.btn_join));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final D20 E3(AbstractC10505bj2 abstractC10505bj2) {
        C5886Lg2 c5886Lg2E;
        AbstractC13042fc3.i(abstractC10505bj2, "this$0");
        C10600bs7 c10600bs7 = C10600bs7.a;
        Context context = abstractC10505bj2.a.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        D20.a aVarB = c10600bs7.b(null, context);
        C4743Gj2 c4743Gj2 = abstractC10505bj2.F0;
        if ((c4743Gj2 == null || (c5886Lg2E = c4743Gj2.e()) == null) ? false : AbstractC13042fc3.d(c5886Lg2E.q(), Boolean.TRUE)) {
            CharSequence text = abstractC10505bj2.a.getContext().getText(ID5.feed_up_voters_your_tooltip);
            AbstractC13042fc3.h(text, "getText(...)");
            aVarB.X1(text);
        } else {
            CharSequence text2 = abstractC10505bj2.a.getContext().getText(ID5.feed_up_voters_other_tooltip);
            AbstractC13042fc3.h(text2, "getText(...)");
            aVarB.X1(text2);
        }
        if (!JF5.g()) {
            aVarB.a1(0.9f);
        }
        return aVarB.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean F2(AbstractC10505bj2 abstractC10505bj2, TextView textView, String str) {
        AbstractC13042fc3.i(abstractC10505bj2, "this$0");
        InterfaceC13138fj2 interfaceC13138fj2S1 = abstractC10505bj2.s1();
        AbstractC13042fc3.f(str);
        return interfaceC13138fj2S1.e(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean I2(AbstractC10505bj2 abstractC10505bj2, View view) {
        AbstractC13042fc3.i(abstractC10505bj2, "this$0");
        D20 d20Z1 = abstractC10505bj2.z1();
        AbstractC13042fc3.f(view);
        d20Z1.M0(view, 50, -5);
        abstractC10505bj2.s1().n();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean J2(AbstractC10505bj2 abstractC10505bj2, C4743Gj2 c4743Gj2) {
        AbstractC13042fc3.i(abstractC10505bj2, "this$0");
        AbstractC13042fc3.i(c4743Gj2, "$feedUI");
        abstractC10505bj2.b3(c4743Gj2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K2(C4743Gj2 c4743Gj2, AbstractC10505bj2 abstractC10505bj2, View view) {
        AbstractC13042fc3.i(c4743Gj2, "$feedUI");
        AbstractC13042fc3.i(abstractC10505bj2, "this$0");
        if (c4743Gj2.h().length() != 0) {
            abstractC10505bj2.s1().A(c4743Gj2.h(), c4743Gj2.f(), true, WH5.b, c4743Gj2.e());
            abstractC10505bj2.l1().u.setImageDrawable(abstractC10505bj2.o1());
            abstractC10505bj2.G2(c4743Gj2.i() - 1);
            abstractC10505bj2.l1().u.h();
            return;
        }
        if (!abstractC10505bj2.Z2(c4743Gj2)) {
            abstractC10505bj2.l1().u.performLongClick();
            return;
        }
        abstractC10505bj2.s1().A("❤", c4743Gj2.f(), false, WH5.b, c4743Gj2.e());
        abstractC10505bj2.l1().u.setImageResource(AbstractC18163oB5.ic_feed_heart_bold);
        abstractC10505bj2.G2(c4743Gj2.i() + 1);
        if (abstractC10505bj2.s1().d()) {
            D20 d20G3 = abstractC10505bj2.g3();
            AbstractC13042fc3.f(view);
            D20.N0(d20G3, view, 0, 0, 6, null);
            abstractC10505bj2.s1().t();
        }
        abstractC10505bj2.l1().u.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N2(C4743Gj2 c4743Gj2, AbstractC10505bj2 abstractC10505bj2, View view) {
        AbstractC13042fc3.i(c4743Gj2, "$feedUI");
        AbstractC13042fc3.i(abstractC10505bj2, "this$0");
        if (c4743Gj2.h().length() != 0) {
            abstractC10505bj2.s1().A(c4743Gj2.h(), c4743Gj2.f(), true, WH5.b, c4743Gj2.e());
            abstractC10505bj2.l1().u.setImageDrawable(abstractC10505bj2.o1());
            abstractC10505bj2.G2(c4743Gj2.i() - 1);
            abstractC10505bj2.l1().u.h();
            return;
        }
        if (!abstractC10505bj2.Z2(c4743Gj2)) {
            abstractC10505bj2.l1().u.performLongClick();
            return;
        }
        abstractC10505bj2.s1().A("❤", c4743Gj2.f(), false, WH5.b, c4743Gj2.e());
        abstractC10505bj2.l1().u.setImageResource(AbstractC18163oB5.ic_feed_heart_bold);
        abstractC10505bj2.G2(c4743Gj2.i() + 1);
        if (abstractC10505bj2.s1().d()) {
            D20 d20G3 = abstractC10505bj2.g3();
            AbstractC13042fc3.f(view);
            D20.N0(d20G3, view, 0, 0, 6, null);
            abstractC10505bj2.s1().t();
        }
        abstractC10505bj2.l1().u.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean O2(AbstractC10505bj2 abstractC10505bj2, View view) {
        AbstractC13042fc3.i(abstractC10505bj2, "this$0");
        D20 d20Z1 = abstractC10505bj2.z1();
        AbstractC13042fc3.f(view);
        d20Z1.M0(view, 50, -5);
        abstractC10505bj2.s1().n();
        return true;
    }

    private final void T2(final C4743Gj2 c4743Gj2) {
        if (c4743Gj2.e().p() == null || c4743Gj2.e().p().intValue() <= 0 || !C8386Vt0.Ea()) {
            Group group = l1().y;
            AbstractC13042fc3.h(group, "feedUpVoters");
            group.setVisibility(8);
            AvatarViewGlide avatarViewGlide = l1().C;
            AbstractC13042fc3.h(avatarViewGlide, "upVotersAvatar3");
            avatarViewGlide.setVisibility(8);
            AvatarViewGlide avatarViewGlide2 = l1().B;
            AbstractC13042fc3.h(avatarViewGlide2, "upVotersAvatar2");
            avatarViewGlide2.setVisibility(8);
            AvatarViewGlide avatarViewGlide3 = l1().A;
            AbstractC13042fc3.h(avatarViewGlide3, "upVotersAvatar1");
            avatarViewGlide3.setVisibility(8);
            return;
        }
        Group group2 = l1().y;
        AbstractC13042fc3.h(group2, "feedUpVoters");
        group2.setVisibility(0);
        String strG = AbstractC20655sN7.g(c4743Gj2.e().p().intValue());
        String string = c4743Gj2.e().p().intValue() > 1 ? l1().getRoot().getContext().getString(ID5.feed_suggesters_number, strG) : l1().getRoot().getContext().getString(ID5.feed_suggesters_number_many, strG);
        AbstractC13042fc3.f(string);
        l1().E.setText(string);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: ir.nasim.Zi2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AbstractC10505bj2.U2(this.a, c4743Gj2, view);
            }
        };
        Group group3 = l1().y;
        AbstractC13042fc3.h(group3, "feedUpVoters");
        p3(group3, onClickListener);
        l1().A.setOnClickListener(onClickListener);
        l1().B.setOnClickListener(onClickListener);
        l1().C.setOnClickListener(onClickListener);
        l1().A.B(12.0f, true);
        l1().B.B(12.0f, true);
        l1().C.B(12.0f, true);
        Integer numP = c4743Gj2.e().p();
        if (numP != null && numP.intValue() == 1) {
            AvatarViewGlide avatarViewGlide4 = l1().A;
            AbstractC13042fc3.h(avatarViewGlide4, "upVotersAvatar1");
            avatarViewGlide4.setVisibility(0);
            AvatarViewGlide avatarViewGlide5 = l1().B;
            AbstractC13042fc3.h(avatarViewGlide5, "upVotersAvatar2");
            avatarViewGlide5.setVisibility(8);
            AvatarViewGlide avatarViewGlide6 = l1().C;
            AbstractC13042fc3.h(avatarViewGlide6, "upVotersAvatar3");
            avatarViewGlide6.setVisibility(8);
        } else if (numP != null && numP.intValue() == 2) {
            AvatarViewGlide avatarViewGlide7 = l1().A;
            AbstractC13042fc3.h(avatarViewGlide7, "upVotersAvatar1");
            avatarViewGlide7.setVisibility(0);
            AvatarViewGlide avatarViewGlide8 = l1().B;
            AbstractC13042fc3.h(avatarViewGlide8, "upVotersAvatar2");
            avatarViewGlide8.setVisibility(0);
            AvatarViewGlide avatarViewGlide9 = l1().C;
            AbstractC13042fc3.h(avatarViewGlide9, "upVotersAvatar3");
            avatarViewGlide9.setVisibility(8);
        } else {
            AvatarViewGlide avatarViewGlide10 = l1().C;
            AbstractC13042fc3.h(avatarViewGlide10, "upVotersAvatar3");
            avatarViewGlide10.setVisibility(0);
            AvatarViewGlide avatarViewGlide11 = l1().B;
            AbstractC13042fc3.h(avatarViewGlide11, "upVotersAvatar2");
            avatarViewGlide11.setVisibility(0);
            AvatarViewGlide avatarViewGlide12 = l1().A;
            AbstractC13042fc3.h(avatarViewGlide12, "upVotersAvatar1");
            avatarViewGlide12.setVisibility(0);
        }
        S2(c4743Gj2.j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U2(AbstractC10505bj2 abstractC10505bj2, C4743Gj2 c4743Gj2, View view) {
        AbstractC13042fc3.i(abstractC10505bj2, "this$0");
        AbstractC13042fc3.i(c4743Gj2, "$feedUI");
        abstractC10505bj2.s1().B(c4743Gj2.e());
    }

    private final void V2(C19482qQ7 c19482qQ7, String str) {
        l1().o.setText(str);
        C1(y1().r(c19482qQ7, new InterfaceC14756iQ7() { // from class: ir.nasim.Ri2
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                AbstractC10505bj2.X2(this.a, (E25) obj, abstractC13554gQ7);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X2(AbstractC10505bj2 abstractC10505bj2, E25 e25, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(abstractC10505bj2, "this$0");
        if (e25 != E25.VERIFIED) {
            abstractC10505bj2.l1().o.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            abstractC10505bj2.l1().o.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, AbstractC4043Dl1.f(abstractC10505bj2.a.getContext(), KB5.blue_tick), (Drawable) null);
        }
    }

    private final boolean Z2(C4743Gj2 c4743Gj2) {
        return c4743Gj2.d().contains("❤");
    }

    private final C12800fB6 a3(C5886Lg2 c5886Lg2) {
        Context context = this.a.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        C12800fB6.a aVarT = new C12800fB6.a(context).t(x1(), 1);
        String string = this.a.getContext().getString(ID5.resizable_text_read_more);
        AbstractC13042fc3.h(string, "getString(...)");
        C12800fB6.a aVarQ = aVarT.q(string);
        Context context2 = this.a.getContext();
        AbstractC13042fc3.h(context2, "getContext(...)");
        C12800fB6 c12800fB6A = aVarQ.r(OY0.b(context2, AbstractC13999hA5.colorPrimary)).p(true).b(false).s(true, false).a();
        c12800fB6A.v(new c(c5886Lg2));
        return c12800fB6A;
    }

    private final Spannable d3(long j, Context context) {
        return new SpannableString(C14593iA1.s(context, j, false, 4, null));
    }

    private final Spannable e3(C5886Lg2 c5886Lg2, long j, boolean z, Context context) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (JF5.g()) {
            if (j > 0) {
                Spannable spannableM3 = m3(context, OY0.b(context, AbstractC13999hA5.bubble_low_text), z);
                SpannableString spannableStringL3 = l3(j);
                AbstractC17636nI6.d(spannableStringL3, 12, true, 0, 0, 12, null);
                spannableStringBuilder.append((CharSequence) spannableStringL3);
                spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(2));
                spannableStringBuilder.append((CharSequence) spannableM3);
            }
            Integer numP = c5886Lg2.p();
            if (numP != null && numP.intValue() > 0) {
                Spannable spannableN3 = n3(context, c5886Lg2.q());
                spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(10));
                SpannableString spannableStringL32 = l3(numP.intValue());
                AbstractC17636nI6.d(spannableStringL32, 12, true, 0, 0, 12, null);
                spannableStringBuilder.append((CharSequence) spannableStringL32);
                spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(2));
                spannableStringBuilder.append((CharSequence) spannableN3);
                spannableStringBuilder.setSpan(this.E0, ((spannableStringBuilder.length() - spannableStringL32.length()) - (spannableN3 != null ? spannableN3.length() : 0)) - 1, spannableStringBuilder.length(), 33);
            }
        } else {
            Integer numP2 = c5886Lg2.p();
            if (numP2 != null && numP2.intValue() > 0) {
                Spannable spannableN32 = n3(context, c5886Lg2.q());
                SpannableString spannableStringL33 = l3(numP2.intValue());
                AbstractC17636nI6.d(spannableStringL33, 12, true, 0, 0, 12, null);
                spannableStringBuilder.append((CharSequence) spannableStringL33);
                spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(2));
                spannableStringBuilder.append((CharSequence) spannableN32);
                spannableStringBuilder.setSpan(this.E0, ((spannableStringBuilder.length() - spannableStringL33.length()) - (spannableN32 != null ? spannableN32.length() : 0)) - 1, spannableStringBuilder.length(), 33);
            }
            if (j > 0) {
                Spannable spannableM32 = m3(context, OY0.b(context, AbstractC13999hA5.bubble_low_text), z);
                spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(10));
                SpannableString spannableStringL34 = l3(j);
                AbstractC17636nI6.d(spannableStringL34, 12, true, 0, 0, 12, null);
                spannableStringBuilder.append((CharSequence) spannableStringL34);
                spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(2));
                spannableStringBuilder.append((CharSequence) spannableM32);
            }
        }
        AbstractC17636nI6.f(spannableStringBuilder, OY0.b(context, AbstractC21139tA5.bubble_low_text), 0, 0, 6, null);
        AbstractC17636nI6.h(spannableStringBuilder, C5495Jo7.a.B2(), 0, 0, 0, 14, null);
        return spannableStringBuilder;
    }

    private final D20 g3() {
        return (D20) this.A0.getValue();
    }

    private final Spannable i3(C4026Dj2 c4026Dj2, boolean z) {
        return new SpannableString(z ? c4026Dj2.b() : c4026Dj2.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final D20 k3() {
        return (D20) this.B0.getValue();
    }

    private final SpannableString l3(long j) {
        return new SpannableString(AbstractC20655sN7.g(j));
    }

    private final Spannable m3(Context context, int i, boolean z) {
        Drawable drawableD = AbstractC6713Oq7.d(context, KB5.bubble_state_view, i);
        if (drawableD == null) {
            return null;
        }
        drawableD.setBounds(0, 0, AbstractC8943Xx1.c(15), AbstractC8943Xx1.c(15));
        int iC = AbstractC8943Xx1.c(1) * (-10);
        if (!z) {
            iC -= 2;
        }
        C12109e33 c12109e33 = new C12109e33(drawableD, iC);
        SpannableString spannableString = new SpannableString(Separators.SP);
        spannableString.setSpan(c12109e33, 0, spannableString.length(), 17);
        return spannableString;
    }

    private final Spannable n3(Context context, Boolean bool) {
        if (bool == null) {
            return null;
        }
        Drawable drawableF = AbstractC4043Dl1.f(context, bool.booleanValue() ? KB5.bubble_state_up_vote_by_me : KB5.bubble_state_up_vote);
        if (drawableF == null) {
            return null;
        }
        drawableF.setBounds(0, 0, AbstractC8943Xx1.c(14), AbstractC8943Xx1.c(14));
        ImageSpan imageSpan = Build.VERSION.SDK_INT >= 29 ? new ImageSpan(drawableF, 2) : new ImageSpan(drawableF, 1);
        SpannableString spannableString = new SpannableString(Separators.SP);
        spannableString.setSpan(imageSpan, 0, spannableString.length(), 17);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o2(AbstractC10505bj2 abstractC10505bj2, View view, MotionEvent motionEvent) {
        AbstractC13042fc3.i(abstractC10505bj2, "this$0");
        return abstractC10505bj2.q1().onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final D20 o3(AbstractC10505bj2 abstractC10505bj2) {
        AbstractC13042fc3.i(abstractC10505bj2, "this$0");
        C10600bs7 c10600bs7 = C10600bs7.a;
        Context context = abstractC10505bj2.a.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        D20.a aVarB = c10600bs7.b(null, context);
        CharSequence text = abstractC10505bj2.a.getContext().getText(ID5.feed_hold_reaction_tooltip);
        AbstractC13042fc3.h(text, "getText(...)");
        aVarB.X1(text);
        if (JF5.g()) {
            aVarB.a1(0.7f);
        } else {
            aVarB.a1(0.3f);
        }
        return aVarB.a();
    }

    private final void p2(final C4743Gj2 c4743Gj2) {
        G2(c4743Gj2.i());
        Integer numG = c4743Gj2.e().g();
        if (numG != null) {
            int iIntValue = numG.intValue();
            if (iIntValue == 0) {
                TextView textView = l1().l;
                AbstractC13042fc3.h(textView, "feedForwardCount");
                textView.setVisibility(8);
            } else {
                TextView textView2 = l1().l;
                AbstractC13042fc3.h(textView2, "feedForwardCount");
                textView2.setVisibility(0);
                l1().l.setText(JF5.g() ? GY6.a(String.valueOf(iIntValue)) : GY6.b(String.valueOf(iIntValue)));
            }
        } else {
            TextView textView3 = l1().l;
            AbstractC13042fc3.h(textView3, "feedForwardCount");
            textView3.setVisibility(8);
        }
        Group group = l1().k;
        AbstractC13042fc3.h(group, "feedForward");
        p3(group, new View.OnClickListener() { // from class: ir.nasim.Li2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AbstractC10505bj2.q2(c4743Gj2, this, view);
            }
        });
        long jE = c4743Gj2.e().e();
        Context context = this.a.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        Spannable spannableD3 = d3(jE, context);
        TextView textView4 = l1().h;
        TextView.BufferType bufferType = TextView.BufferType.SPANNABLE;
        textView4.setText(spannableD3, bufferType);
        C4026Dj2 c4026Dj2O = c4743Gj2.e().o();
        if (c4026Dj2O != null) {
            l1().w.setText(i3(c4026Dj2O, JF5.g()), bufferType);
        }
        C5886Lg2 c5886Lg2E = c4743Gj2.e();
        long jK = c4743Gj2.k();
        boolean zG = JF5.g();
        Context context2 = this.a.getContext();
        AbstractC13042fc3.h(context2, "getContext(...)");
        l1().v.setText(e3(c5886Lg2E, jK, zG, context2), bufferType);
        l1().v.setLinksClickable(true);
        l1().v.setClickable(true);
        l1().v.setMovementMethod(LinkMovementMethod.getInstance());
        l1().r.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Mi2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AbstractC10505bj2.r2(this.a, c4743Gj2, view);
            }
        });
    }

    private final void p3(Group group, View.OnClickListener onClickListener) {
        int[] referencedIds = group.getReferencedIds();
        AbstractC13042fc3.h(referencedIds, "getReferencedIds(...)");
        for (int i : referencedIds) {
            View viewFindViewById = group.getRootView().findViewById(i);
            if (viewFindViewById != null) {
                viewFindViewById.setOnClickListener(onClickListener);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q2(C4743Gj2 c4743Gj2, AbstractC10505bj2 abstractC10505bj2, View view) {
        AbstractC13042fc3.i(c4743Gj2, "$feedUI");
        AbstractC13042fc3.i(abstractC10505bj2, "this$0");
        List listE = AbstractC9766aX0.e(new J44(c4743Gj2.e().m(), c4743Gj2.e().e(), c4743Gj2.e().e(), c4743Gj2.e().n(), EnumC23558x74.PENDING, abstractC10505bj2.T0(), null, 0, new C8445Vz5(c4743Gj2.e().m(), c4743Gj2.f().p0(), c4743Gj2.f().w0(), c4743Gj2.e().e(), abstractC10505bj2.T0(), c4743Gj2.f().I0(), true, null), null, 0L, null, null, false, null, null, false, null, null, 523968, null));
        InterfaceC13138fj2 interfaceC13138fj2S1 = abstractC10505bj2.s1();
        C11458d25 c11458d25I0 = c4743Gj2.f().I0();
        AbstractC13042fc3.h(c11458d25I0, "peer(...)");
        interfaceC13138fj2S1.h(c11458d25I0, listE, XH6.b, c4743Gj2.e(), c4743Gj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r2(AbstractC10505bj2 abstractC10505bj2, C4743Gj2 c4743Gj2, View view) {
        AbstractC13042fc3.i(abstractC10505bj2, "this$0");
        AbstractC13042fc3.i(c4743Gj2, "$feedUI");
        AbstractC8081Ul1.b bVar = new AbstractC8081Ul1.b();
        List<AbstractC19657qj2> listU0 = abstractC10505bj2.U0(c4743Gj2.f(), c4743Gj2.g(), c4743Gj2.e());
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listU0, 10));
        for (AbstractC19657qj2 abstractC19657qj2 : listU0) {
            arrayList.add(AbstractC8081Ul1.b.k(bVar, abstractC19657qj2.c(), abstractC19657qj2.b(), null, abstractC19657qj2.a(), 4, null));
        }
        AbstractC13042fc3.f(view);
        ConstraintLayout root = abstractC10505bj2.l1().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        new GY.a(view, root, null, 4, null).d(true).h(new Point((int) view.getX(), 0)).b(bVar).h();
    }

    private final void v2(final C14697iL2 c14697iL2, final C14733iO2 c14733iO2, final C5886Lg2 c5886Lg2) {
        C19482qQ7 c19482qQ7Y;
        Avatar avatarH0 = c14697iL2.h0();
        if (avatarH0 != null) {
            l1().c.B(18.0f, true);
            AvatarViewGlide.v(l1().c, avatarH0, c14697iL2.G0(), c14697iL2.p0(), false, null, 16, null);
        }
        if (c14733iO2 != null && (c19482qQ7Y = c14733iO2.y()) != null) {
            String strG0 = c14697iL2.G0();
            AbstractC13042fc3.h(strG0, "getTitle(...)");
            V2(c19482qQ7Y, strG0);
        }
        String strA = JF5.g() ? GY6.a(String.valueOf(c14697iL2.t0())) : GY6.b(String.valueOf(c14697iL2.t0()));
        l1().n.setText(AbstractC20655sN7.g(Long.parseLong(strA)) + Separators.SP + l1().getRoot().getContext().getString(ID5.member));
        MaterialButton materialButton = l1().q;
        AbstractC13042fc3.h(materialButton, "feedJoinButton");
        materialButton.setVisibility(c14697iL2.H0() ^ true ? 0 : 8);
        l1().q.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Ni2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AbstractC10505bj2.B2(c14733iO2, this, c14697iL2, c5886Lg2, view);
            }
        });
        Group group = l1().x;
        AbstractC13042fc3.h(group, "feedTitle");
        p3(group, new View.OnClickListener() { // from class: ir.nasim.Oi2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AbstractC10505bj2.C2(this.a, c14697iL2, c5886Lg2, view);
            }
        });
        B1(y1().r(c14733iO2 != null ? c14733iO2.F() : null, new InterfaceC14756iQ7() { // from class: ir.nasim.Pi2
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                AbstractC10505bj2.D2(this.a, ((Boolean) obj).booleanValue(), abstractC13554gQ7);
            }
        }));
    }

    public static /* synthetic */ void v3(AbstractC10505bj2 abstractC10505bj2, View view, long j, float f, UA2 ua2, UA2 ua22, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setFeedItemClickListener");
        }
        if ((i & 1) != 0) {
            j = 500;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            f = 10.0f;
        }
        abstractC10505bj2.u3(view, j2, f, ua2, ua22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean w3(C10873cL5 c10873cL5, C10873cL5 c10873cL52, C9663aL5 c9663aL5, float f, final C12280eL5 c12280eL5, final long j, UA2 ua2, final View view, final UA2 ua22, View view2, MotionEvent motionEvent) {
        AbstractC13042fc3.i(c10873cL5, "$lastTouchX");
        AbstractC13042fc3.i(c10873cL52, "$lastTouchY");
        AbstractC13042fc3.i(c9663aL5, "$isDragging");
        AbstractC13042fc3.i(c12280eL5, "$lastTapTime");
        AbstractC13042fc3.i(ua2, "$onDoubleTap");
        AbstractC13042fc3.i(view, "$this_setFeedItemClickListener");
        AbstractC13042fc3.i(ua22, "$onSingleTap");
        int action = motionEvent.getAction();
        if (action == 0) {
            c10873cL5.a = motionEvent.getX();
            c10873cL52.a = motionEvent.getY();
            c9663aL5.a = false;
        } else if (action == 1) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (c9663aL5.a) {
                return false;
            }
            if (jElapsedRealtime - c12280eL5.a < j) {
                ua2.invoke(view);
            } else {
                view.postDelayed(new Runnable() { // from class: ir.nasim.Qi2
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbstractC10505bj2.y3(c12280eL5, j, ua22, view);
                    }
                }, j);
            }
            c12280eL5.a = jElapsedRealtime;
            view.performClick();
        } else if (action == 2) {
            float fAbs = Math.abs(motionEvent.getX() - c10873cL5.a);
            float fAbs2 = Math.abs(motionEvent.getY() - c10873cL52.a);
            if (fAbs > f || fAbs2 > f) {
                c9663aL5.a = true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y3(C12280eL5 c12280eL5, long j, UA2 ua2, View view) {
        AbstractC13042fc3.i(c12280eL5, "$lastTapTime");
        AbstractC13042fc3.i(ua2, "$onSingleTap");
        AbstractC13042fc3.i(view, "$this_setFeedItemClickListener");
        if (SystemClock.elapsedRealtime() - c12280eL5.a >= j) {
            ua2.invoke(view);
        }
    }

    public void E2(AbstractC15520jj2 abstractC15520jj2) {
        AbstractC13042fc3.i(abstractC15520jj2, "feedMessage");
        t1().i(new AbstractC14879ie0.d() { // from class: ir.nasim.Ki2
            @Override // ir.nasim.AbstractC14879ie0.d
            public final boolean a(TextView textView, String str) {
                return AbstractC10505bj2.F2(this.a, textView, str);
            }
        });
        t3(abstractC15520jj2);
    }

    public final void G2(long j) {
        if (j > 0) {
            l1().t.setText(AbstractC20655sN7.g(j));
        }
    }

    public final void H2(final C4743Gj2 c4743Gj2) {
        AbstractC13042fc3.i(c4743Gj2, "feedUI");
        if (c4743Gj2.d().isEmpty()) {
            FeedEmojiImageView feedEmojiImageView = l1().u;
            AbstractC13042fc3.h(feedEmojiImageView, "feedReactionIv");
            feedEmojiImageView.setVisibility(8);
            TextView textView = l1().t;
            AbstractC13042fc3.h(textView, "feedReactionCount");
            textView.setVisibility(8);
        } else {
            FeedEmojiImageView feedEmojiImageView2 = l1().u;
            AbstractC13042fc3.h(feedEmojiImageView2, "feedReactionIv");
            feedEmojiImageView2.setVisibility(0);
            TextView textView2 = l1().t;
            AbstractC13042fc3.h(textView2, "feedReactionCount");
            textView2.setVisibility(0);
        }
        if (c4743Gj2.h().length() <= 0) {
            l1().u.setImageDrawable(o1());
        } else if (!AbstractC13042fc3.d(c4743Gj2.h(), "❤")) {
            l1().u.setImageDrawable(R62.A(c4743Gj2.h()));
        } else if (Z2(c4743Gj2)) {
            l1().u.setImageResource(AbstractC18163oB5.ic_feed_heart_bold);
        } else {
            l1().u.performLongClick();
        }
        l1().u.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.Ii2
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return AbstractC10505bj2.O2(this.a, view);
            }
        });
        l1().t.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.Si2
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return AbstractC10505bj2.I2(this.a, view);
            }
        });
        this.C0 = new a(c4743Gj2);
        r1().d(new SA2() { // from class: ir.nasim.Ti2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(AbstractC10505bj2.J2(this.a, c4743Gj2));
            }
        });
        InterfaceC11890dj2 interfaceC11890dj2 = this.C0;
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
            Group group = l1().s;
            AbstractC13042fc3.h(group, "feedReaction");
            group.setVisibility(arrayList.isEmpty() ^ true ? 0 : 8);
            if (!arrayList.isEmpty()) {
                c22134uj2.C(AbstractC15401jX0.a1(arrayList, new b()));
            }
        }
        l1().u.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Ui2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AbstractC10505bj2.K2(c4743Gj2, this, view);
            }
        });
        l1().t.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Vi2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AbstractC10505bj2.N2(c4743Gj2, this, view);
            }
        });
    }

    public final void P2(C5886Lg2 c5886Lg2, long j) {
        AbstractC13042fc3.i(c5886Lg2, "feed");
        long jE = c5886Lg2.e();
        Context context = this.a.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        Spannable spannableD3 = d3(jE, context);
        TextView textView = l1().h;
        TextView.BufferType bufferType = TextView.BufferType.SPANNABLE;
        textView.setText(spannableD3, bufferType);
        C4026Dj2 c4026Dj2O = c5886Lg2.o();
        if (c4026Dj2O != null) {
            l1().w.setText(i3(c4026Dj2O, JF5.g()), bufferType);
        }
        boolean zG = JF5.g();
        Context context2 = this.a.getContext();
        AbstractC13042fc3.h(context2, "getContext(...)");
        l1().v.setText(e3(c5886Lg2, j, zG, context2), bufferType);
    }

    public final void S2(List list) {
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

    public final void Y2(C8755Xe4 c8755Xe4, C5886Lg2 c5886Lg2) {
        AbstractC13042fc3.i(c8755Xe4, "mid");
        AbstractC13042fc3.i(c5886Lg2, "feed");
        s1().c(c8755Xe4, c5886Lg2);
    }

    @Override // ir.nasim.AbstractC13019fa0
    public void a() {
        super.a();
        l1().c.D();
        this.C0 = null;
        this.F0 = null;
    }

    public final void b3(C4743Gj2 c4743Gj2) {
        AbstractC13042fc3.i(c4743Gj2, "feedUI");
        if ((!c4743Gj2.d().isEmpty()) && !AbstractC13042fc3.d(c4743Gj2.h(), "❤")) {
            if (Z2(c4743Gj2)) {
                s1().A("❤", c4743Gj2.f(), false, WH5.d, c4743Gj2.e());
                l1().u.setImageResource(AbstractC18163oB5.ic_feed_heart_bold);
                G2(c4743Gj2.i() + 1);
            } else {
                l1().u.performLongClick();
            }
        }
        l1().u.h();
        c1();
    }

    @Override // ir.nasim.AbstractC13019fa0
    /* renamed from: c3, reason: merged with bridge method [inline-methods] */
    public C11268cj2 l1() {
        return this.z0;
    }

    public final C4743Gj2 f3() {
        return this.F0;
    }

    protected final C12800fB6 h3() {
        return this.D0;
    }

    public final void n2(C4743Gj2 c4743Gj2) {
        AbstractC13042fc3.i(c4743Gj2, "feedUI");
        this.F0 = c4743Gj2;
        this.D0 = a3(c4743Gj2.e());
        l1().b.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.Yi2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return AbstractC10505bj2.o2(this.a, view, motionEvent);
            }
        });
        z3(c4743Gj2);
        l1().d.setMovementMethod(t1());
        l1().d.setTextSize(C20837sh2.a.b());
        v2(c4743Gj2.f(), c4743Gj2.g(), c4743Gj2.e());
        p2(c4743Gj2);
        T2(c4743Gj2);
        H2(c4743Gj2);
        InterfaceC13138fj2 interfaceC13138fj2S1 = s1();
        C11458d25 c11458d25I0 = c4743Gj2.f().I0();
        AbstractC13042fc3.h(c11458d25I0, "peer(...)");
        interfaceC13138fj2S1.k(c11458d25I0, c4743Gj2.f().getAccessHash(), new C8755Xe4(c4743Gj2.f().I0().getPeerId(), c4743Gj2.e().e(), c4743Gj2.e().m(), 0, 8, null));
        s1().y(c4743Gj2.e().f().getPeerId(), new C8755Xe4(c4743Gj2.f().I0().getPeerId(), c4743Gj2.e().e(), c4743Gj2.e().m(), 0, 8, null));
        C3();
    }

    public abstract void t3(AbstractC15520jj2 abstractC15520jj2);

    public final void u3(final View view, final long j, final float f, final UA2 ua2, final UA2 ua22) {
        AbstractC13042fc3.i(view, "<this>");
        AbstractC13042fc3.i(ua2, "onDoubleTap");
        AbstractC13042fc3.i(ua22, "onSingleTap");
        final C12280eL5 c12280eL5 = new C12280eL5();
        final C10873cL5 c10873cL5 = new C10873cL5();
        final C10873cL5 c10873cL52 = new C10873cL5();
        final C9663aL5 c9663aL5 = new C9663aL5();
        view.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.aj2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return AbstractC10505bj2.w3(c10873cL5, c10873cL52, c9663aL5, f, c12280eL5, j, ua2, view, ua22, view2, motionEvent);
            }
        });
    }

    public void z3(final C4743Gj2 c4743Gj2) {
        C19482qQ7 c19482qQ7O;
        AbstractC13042fc3.i(c4743Gj2, "feedUI");
        TextView textView = l1().e;
        AbstractC13042fc3.h(textView, "feedCommentCount");
        textView.setVisibility(8);
        ImageView imageView = l1().f;
        AbstractC13042fc3.h(imageView, "feedCommentIv");
        imageView.setVisibility(8);
        C14733iO2 c14733iO2G = c4743Gj2.g();
        if (c14733iO2G == null || (c19482qQ7O = c14733iO2G.o()) == null || ((Integer) c19482qQ7O.b()) == null) {
            return;
        }
        boolean z = c4743Gj2.e().l() != null;
        TextView textView2 = l1().e;
        AbstractC13042fc3.h(textView2, "feedCommentCount");
        textView2.setVisibility(z ? 0 : 8);
        ImageView imageView2 = l1().f;
        AbstractC13042fc3.h(imageView2, "feedCommentIv");
        imageView2.setVisibility(z ? 0 : 8);
        C17532n74 c17532n74L = c4743Gj2.e().l();
        if (c17532n74L != null) {
            if (c17532n74L.E() == 0) {
                l1().e.setText("");
            } else {
                l1().e.setText(XY6.v(XY6.i(c17532n74L.E())));
            }
        }
        l1().f.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Ji2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AbstractC10505bj2.A3(this.a, c4743Gj2, view);
            }
        });
    }

    /* renamed from: ir.nasim.bj2$c */
    public static final class c implements C12800fB6.c {
        final /* synthetic */ C5886Lg2 b;

        c(C5886Lg2 c5886Lg2) {
            this.b = c5886Lg2;
        }

        @Override // ir.nasim.C12800fB6.c
        public void b() {
            AbstractC10505bj2.this.s1().i(this.b);
        }

        @Override // ir.nasim.C12800fB6.c
        public void a() {
        }
    }
}
