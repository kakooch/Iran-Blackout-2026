package ir.nasim;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.ContextThemeWrapper;
import android.view.View;
import ir.nasim.K74;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class L74 {
    private final int a;
    private final ExPeerType b;
    private final List c;
    private final K74 d;
    private final InterfaceC14123hO3 e;
    private final InterfaceC14123hO3 f;
    private final InterfaceC14123hO3 g;
    private final InterfaceC14123hO3 h;
    private final InterfaceC14123hO3 i;
    private final InterfaceC14123hO3 j;
    private final UA2 k;
    private final F74 l;
    private final M74 m;
    private final HM3 n;
    private final Q74 o;
    private final OO5 p;
    private final UA2 q;
    private final boolean r;
    private final UA2 s;
    private final Context t;
    private final InterfaceC14603iB2 u;

    public static final class a extends ClickableSpan {
        final /* synthetic */ J44 b;
        final /* synthetic */ Spannable c;

        a(J44 j44, Spannable spannable) {
            this.b = j44;
            this.c = spannable;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            AbstractC13042fc3.i(view, "widget");
            L74.this.u.invoke(this.b, new C17532n74(L74.this.p.b(), L74.this.p.d()));
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            AbstractC13042fc3.i(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setColor(K74.c.o(L74.this.m(this.b, this.c), L74.this.t));
            textPaint.setUnderlineText(false);
        }
    }

    public L74(int i, ExPeerType exPeerType, List list, K74 k74, InterfaceC14123hO3 interfaceC14123hO3, InterfaceC14123hO3 interfaceC14123hO32, InterfaceC14123hO3 interfaceC14123hO33, InterfaceC14123hO3 interfaceC14123hO34, InterfaceC14123hO3 interfaceC14123hO35, InterfaceC14123hO3 interfaceC14123hO36, UA2 ua2, F74 f74, M74 m74, HM3 hm3, Q74 q74, OO5 oo5, UA2 ua22, boolean z, UA2 ua23, Context context, InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(exPeerType, "peerType");
        AbstractC13042fc3.i(list, "pinnedMessage");
        AbstractC13042fc3.i(k74, "stateMapper");
        AbstractC13042fc3.i(interfaceC14123hO3, "messageToAvailableActionsMapper");
        AbstractC13042fc3.i(interfaceC14123hO32, "contentToDocumentMapper");
        AbstractC13042fc3.i(interfaceC14123hO33, "messageToForwardMapper");
        AbstractC13042fc3.i(interfaceC14123hO34, "messageToReplyMapper");
        AbstractC13042fc3.i(interfaceC14123hO36, "contentToTemplateMapper");
        AbstractC13042fc3.i(ua2, "albumItemSelectionInfoProvider");
        AbstractC13042fc3.i(f74, "messageToContentDescriptionMapper");
        AbstractC13042fc3.i(m74, "messageToUiMessageStateMapper");
        AbstractC13042fc3.i(hm3, "magazineSuggestStateProcessor");
        AbstractC13042fc3.i(q74, "messageToUpVote");
        AbstractC13042fc3.i(oo5, "repliesActions");
        AbstractC13042fc3.i(ua22, "preprocessedDataProvider");
        AbstractC13042fc3.i(ua23, "personalNameProvider");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(interfaceC14603iB2, "openReplies");
        this.a = i;
        this.b = exPeerType;
        this.c = list;
        this.d = k74;
        this.e = interfaceC14123hO3;
        this.f = interfaceC14123hO32;
        this.g = interfaceC14123hO33;
        this.h = interfaceC14123hO34;
        this.i = interfaceC14123hO35;
        this.j = interfaceC14123hO36;
        this.k = ua2;
        this.l = f74;
        this.m = m74;
        this.n = hm3;
        this.o = q74;
        this.p = oo5;
        this.q = ua22;
        this.r = z;
        this.s = ua23;
        this.t = context;
        this.u = interfaceC14603iB2;
    }

    private final void e(SpannableStringBuilder spannableStringBuilder, J44 j44, Spannable spannable) {
        AbstractC17636nI6.b(4);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        C17532n74 c17532n74T = j44.T();
        spannableStringBuilder2.append((CharSequence) XY6.v(String.valueOf(c17532n74T != null ? Integer.valueOf(c17532n74T.E()) : null)));
        AbstractC17636nI6.d(spannableStringBuilder2, 12, true, 0, 0, 12, null);
        spannableStringBuilder.append((CharSequence) new SpannedString(spannableStringBuilder2));
        K74.a aVar = K74.c;
        Context context = this.t;
        AbstractC13042fc3.g(context, "null cannot be cast to non-null type android.view.ContextThemeWrapper");
        Object objC = aVar.c((ContextThemeWrapper) context, KB5.reply);
        spannableStringBuilder.append("  ");
        spannableStringBuilder.setSpan(objC, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 17);
        spannableStringBuilder.setSpan(new a(j44, spannable), (spannableStringBuilder.length() - r1.length()) - 2, spannableStringBuilder.length(), 17);
    }

    private final boolean f(J44 j44) {
        boolean z = (this.p.c() || this.b.isPrivate().booleanValue() || !this.p.a() || j44.T() == null) ? false : true;
        return this.b == ExPeerType.GROUP ? z && C8386Vt0.T3() : z;
    }

    private final boolean g(J44 j44) {
        C11458d25 c11458d25U;
        if (this.b != ExPeerType.PRIVATE) {
            return false;
        }
        C8445Vz5 c8445Vz5Q = j44.Q();
        if (((c8445Vz5Q == null || (c11458d25U = c8445Vz5Q.u()) == null) ? null : c11458d25U.s()) == W25.b) {
            return false;
        }
        return !(j44.F() instanceof C5980Lq6);
    }

    private final boolean h(J44 j44) {
        return !this.p.c() && !this.b.isPrivate().booleanValue() && this.p.a() && j44.T() != null && C8386Vt0.T3() && this.b == ExPeerType.GROUP;
    }

    private final boolean i(J44 j44) {
        return j44.U() == this.a && this.b != ExPeerType.CHANNEL;
    }

    private final C8967Xz7 j(C8967Xz7 c8967Xz7, C11907dl c11907dl) {
        Object objF = c8967Xz7.f();
        AbstractC13042fc3.g(objF, "null cannot be cast to non-null type kotlin.collections.List<ir.nasim.features.conversation.messages.content.data.Document>");
        List list = (List) objF;
        List listF1 = AbstractC15401jX0.f1(c11907dl.r(), 10);
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listF1, 10));
        int i = 0;
        for (Object obj : listF1) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            J44 j44 = (J44) obj;
            C8967Xz7 c8967Xz7A = c8967Xz7.a((324977 & 1) != 0 ? c8967Xz7.a : new Q64(j44.h(), j44.i()), (324977 & 2) != 0 ? c8967Xz7.b : null, (324977 & 4) != 0 ? c8967Xz7.c : null, (324977 & 8) != 0 ? c8967Xz7.d : null, (324977 & 16) != 0 ? c8967Xz7.e : null, (324977 & 32) != 0 ? c8967Xz7.f : j44, (324977 & 64) != 0 ? c8967Xz7.g : list.get(i), (324977 & 128) != 0 ? c8967Xz7.h : null, (324977 & 256) != 0 ? c8967Xz7.i : null, (324977 & 512) != 0 ? c8967Xz7.j : null, (324977 & 1024) != 0 ? c8967Xz7.k : null, (324977 & 2048) != 0 ? c8967Xz7.l : null, (324977 & 4096) != 0 ? c8967Xz7.m : null, (324977 & 8192) != 0 ? c8967Xz7.n : null, (324977 & 16384) != 0 ? c8967Xz7.o : null, (324977 & 32768) != 0 ? c8967Xz7.p : null, (324977 & 65536) != 0 ? c8967Xz7.q : null, (324977 & 131072) != 0 ? c8967Xz7.r : false, (324977 & 262144) != 0 ? c8967Xz7.s : false);
            arrayList.add(new C14339hl(c8967Xz7A, (AbstractC17757nW1) list.get(i), (Boolean) this.k.invoke(c8967Xz7A)));
            i = i2;
        }
        return c8967Xz7.a((324977 & 1) != 0 ? c8967Xz7.a : null, (324977 & 2) != 0 ? c8967Xz7.b : null, (324977 & 4) != 0 ? c8967Xz7.c : null, (324977 & 8) != 0 ? c8967Xz7.d : null, (324977 & 16) != 0 ? c8967Xz7.e : null, (324977 & 32) != 0 ? c8967Xz7.f : null, (324977 & 64) != 0 ? c8967Xz7.g : new C8304Vk(arrayList), (324977 & 128) != 0 ? c8967Xz7.h : null, (324977 & 256) != 0 ? c8967Xz7.i : null, (324977 & 512) != 0 ? c8967Xz7.j : null, (324977 & 1024) != 0 ? c8967Xz7.k : null, (324977 & 2048) != 0 ? c8967Xz7.l : null, (324977 & 4096) != 0 ? c8967Xz7.m : null, (324977 & 8192) != 0 ? c8967Xz7.n : null, (324977 & 16384) != 0 ? c8967Xz7.o : null, (324977 & 32768) != 0 ? c8967Xz7.p : null, (324977 & 65536) != 0 ? c8967Xz7.q : null, (324977 & 131072) != 0 ? c8967Xz7.r : false, (324977 & 262144) != 0 ? c8967Xz7.s : false);
    }

    private final Spannable k(C8837Xn5 c8837Xn5) {
        CharSequence charSequenceF = c8837Xn5.f();
        Spannable spannable = charSequenceF instanceof Spannable ? (Spannable) charSequenceF : null;
        if (spannable != null) {
            return spannable;
        }
        Spannable spannableE = c8837Xn5.e();
        return spannableE == null ? AbstractC17636nI6.i(c8837Xn5.g()) : spannableE;
    }

    private final GG5 l(J44 j44) {
        if (this.b != ExPeerType.PRIVATE) {
            return null;
        }
        List listR = r(j44.R());
        if (listR.size() == 1) {
            return (GG5) listR.get(0);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean m(J44 j44, Spannable spannable) {
        AbstractC17457n0 abstractC17457n0F = j44.F();
        if ((abstractC17457n0F instanceof C16799lt) || (abstractC17457n0F instanceof JM6)) {
            return true;
        }
        return ((abstractC17457n0F instanceof C13388g85) || (abstractC17457n0F instanceof GS7) || (abstractC17457n0F instanceof XG2) || (abstractC17457n0F instanceof C10844cI3) || (abstractC17457n0F instanceof C11907dl)) && (spannable == null || AbstractC20762sZ6.n0(spannable)) && (r(j44.R()).isEmpty() || l(j44) != null);
    }

    private final SpannableStringBuilder o(J44 j44, Spannable spannable, GG5 gg5) {
        return this.d.a(j44, i(j44), m(j44, spannable), this.c.contains(j44), gg5, this.n.a(j44.i()), j44.F() instanceof C21788u80);
    }

    static /* synthetic */ SpannableStringBuilder p(L74 l74, J44 j44, Spannable spannable, GG5 gg5, int i, Object obj) {
        if ((i & 4) != 0) {
            gg5 = null;
        }
        return l74.o(j44, spannable, gg5);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final android.text.SpannableStringBuilder q(ir.nasim.C8837Xn5 r16, ir.nasim.J44 r17) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.L74.q(ir.nasim.Xn5, ir.nasim.J44):android.text.SpannableStringBuilder");
    }

    private final List r(List list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (PG5.a.f(((GG5) obj).u())) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x021e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final ir.nasim.C8967Xz7 n(ir.nasim.XV4 r40, boolean r41) {
        /*
            Method dump skipped, instructions count: 584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.L74.n(ir.nasim.XV4, boolean):ir.nasim.Xz7");
    }
}
