package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.LruCache;
import android.view.ContextThemeWrapper;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC16012kZ2;
import ir.nasim.core.modules.banking.BankingModule;
import ir.nasim.core.modules.messaging.entity.content.CrowdfundingContentInfo;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.cQ0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10913cQ0 implements VB3 {
    public static final a E = new a(null);
    public static final int F = 8;
    private final InterfaceC9173Yu3 A;
    private final InterfaceC9173Yu3 B;
    private final InterfaceC9173Yu3 C;
    private final boolean D;
    private final C11458d25 a;
    private final ExPeerType b;
    private final C13518gM7 c;
    private final C6975Pu d;
    private final C18812pI0 e;
    private final SA2 f;
    private final SettingsModule g;
    private final Integer h;
    private final IQ0 i;
    private final UA2 j;
    private final R74 k;
    private final OO5 l;
    private final Q74 m;
    private final boolean n;
    private final ContextThemeWrapper o;
    private final LruCache p;
    private final LruCache q;
    private final HashMap r;
    private SA2 s;
    private long t;
    private long u;
    private SA2 v;
    private InterfaceC14603iB2 w;
    private boolean x;
    private final InterfaceC9173Yu3 y;
    private final InterfaceC9173Yu3 z;

    /* renamed from: ir.nasim.cQ0$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.cQ0$b */
    /* synthetic */ class b extends EB2 implements UA2 {
        b(Object obj) {
            super(1, obj, C13518gM7.class, "getMemberTitle", "getMemberTitle(I)Ljava/lang/String;", 0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return y(((Number) obj).intValue());
        }

        public final String y(int i) {
            return ((C13518gM7) this.receiver).b(i);
        }
    }

    /* renamed from: ir.nasim.cQ0$c */
    /* synthetic */ class c extends EB2 implements UA2 {
        c(Object obj) {
            super(1, obj, C13518gM7.class, "forceGetUser", "forceGetUser(I)Lir/nasim/core/modules/users/entity/UserLight;", 0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return y(((Number) obj).intValue());
        }

        public final CI7 y(int i) {
            return ((C13518gM7) this.receiver).a(i);
        }
    }

    /* renamed from: ir.nasim.cQ0$d */
    /* synthetic */ class d extends EB2 implements InterfaceC14603iB2 {
        d(Object obj) {
            super(2, obj, C10913cQ0.class, "getCrowdFundingInfo", "getCrowdFundingInfo(Lir/nasim/core/modules/messaging/entity/Message;Lir/nasim/core/modules/messaging/entity/content/CrowdfundingContentInfo;)Lir/nasim/core/modules/messaging/entity/content/CrowdfundingContentInfo;", 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final CrowdfundingContentInfo invoke(J44 j44, CrowdfundingContentInfo crowdfundingContentInfo) {
            AbstractC13042fc3.i(j44, "p0");
            AbstractC13042fc3.i(crowdfundingContentInfo, "p1");
            return ((C10913cQ0) this.receiver).A(j44, crowdfundingContentInfo);
        }
    }

    public C10913cQ0(C11458d25 c11458d25, ExPeerType exPeerType, Context context, C13518gM7 c13518gM7, C6975Pu c6975Pu, C18812pI0 c18812pI0, SA2 sa2, SettingsModule settingsModule, Integer num, IQ0 iq0, UA2 ua2, R74 r74, OO5 oo5, Q74 q74, long j, long j2) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(context, "originalContext");
        AbstractC13042fc3.i(c13518gM7, "usersProcessor");
        AbstractC13042fc3.i(c6975Pu, "anonymousContentUseCase");
        AbstractC13042fc3.i(c18812pI0, "changeContactContentUseCase");
        AbstractC13042fc3.i(sa2, "enableDiscussionGroup");
        this.a = c11458d25;
        this.b = exPeerType;
        this.c = c13518gM7;
        this.d = c6975Pu;
        this.e = c18812pI0;
        this.f = sa2;
        this.g = settingsModule;
        this.h = num;
        this.i = iq0;
        this.j = ua2;
        this.k = r74;
        this.l = oo5;
        this.m = q74;
        boolean zA7 = C8386Vt0.a7();
        this.n = zA7;
        this.o = new ContextThemeWrapper(context, AbstractC23035wE5.Theme_Bale_BubbleTheme);
        this.p = zA7 ? new LruCache(SIPTransactionStack.BASE_TIMER_INTERVAL) : null;
        this.q = zA7 ? new LruCache(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT) : null;
        this.r = zA7 ? null : new HashMap();
        this.s = new SA2() { // from class: ir.nasim.UP0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C10913cQ0.R();
            }
        };
        this.t = j;
        this.u = j2;
        this.w = new InterfaceC14603iB2() { // from class: ir.nasim.VP0
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return C10913cQ0.N((J44) obj, (C17532n74) obj2);
            }
        };
        this.x = true;
        this.y = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.WP0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C10913cQ0.m(this.a);
            }
        });
        this.z = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.XP0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C10913cQ0.H(this.a);
            }
        });
        this.A = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.YP0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C10913cQ0.O(this.a);
            }
        });
        this.B = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.ZP0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C10913cQ0.Z(this.a);
            }
        });
        this.C = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.aQ0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C10913cQ0.s(this.a);
            }
        });
        this.D = exPeerType == ExPeerType.GROUP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CrowdfundingContentInfo A(J44 j44, CrowdfundingContentInfo crowdfundingContentInfo) {
        C11458d25 c11458d25 = this.a;
        BankingModule bankingModuleY = AbstractC5969Lp4.e().y();
        AbstractC13042fc3.h(bankingModuleY, "getBanking(...)");
        return new C8396Vu1(c11458d25, bankingModuleY).c(j44, crowdfundingContentInfo, this.v);
    }

    private final ContextThemeWrapper B() {
        return (ContextThemeWrapper) this.z.getValue();
    }

    private final CrowdfundingContentInfo C(ir.nasim.core.modules.messaging.entity.content.a aVar) {
        C8540Wk1 c8540Wk1U = aVar.u();
        if (c8540Wk1U != null) {
            AbstractC19230q0 abstractC19230q0C = c8540Wk1U.c();
            AbstractC13042fc3.g(abstractC19230q0C, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.internal.LocalCrowdfundingContent");
            CrowdfundingContentInfo crowdfundingContentInfoC = ((MG3) abstractC19230q0C).C();
            if (crowdfundingContentInfoC != null) {
                return crowdfundingContentInfoC;
            }
        }
        return aVar.t();
    }

    private final ContextThemeWrapper D() {
        return (ContextThemeWrapper) this.A.getValue();
    }

    private final C8837Xn5 E(long j) {
        if (this.n) {
            LruCache lruCache = this.q;
            if (lruCache != null) {
                return (C8837Xn5) lruCache.get(Long.valueOf(j));
            }
            return null;
        }
        HashMap map = this.r;
        if (map != null) {
            return (C8837Xn5) map.get(Long.valueOf(j));
        }
        return null;
    }

    private final C18226oI5 F() {
        return (C18226oI5) this.B.getValue();
    }

    private final int G(J44 j44) {
        return new V74(j44).hashCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContextThemeWrapper H(C10913cQ0 c10913cQ0) {
        AbstractC13042fc3.i(c10913cQ0, "this$0");
        return new ContextThemeWrapper(c10913cQ0.o, AbstractC23035wE5.Theme_Bale_BubbleTheme_Incomming);
    }

    private final boolean J(C8445Vz5 c8445Vz5, InterfaceC8344Vo3 interfaceC8344Vo3) {
        C11458d25 c11458d25U;
        C14697iL2 c14697iL2;
        if (c8445Vz5.E() && (c11458d25U = c8445Vz5.u()) != null && c11458d25U.s() == W25.b && (c14697iL2 = (C14697iL2) interfaceC8344Vo3.d(c11458d25U.getPeerId())) != null && c14697iL2.q0() == ZN2.CHANNEL) {
            return !AbstractC13042fc3.d(c11458d25U, this.a);
        }
        return false;
    }

    private final boolean K(AbstractC17457n0 abstractC17457n0) {
        if (abstractC17457n0 == null || !(abstractC17457n0 instanceof C23345wl7)) {
            return false;
        }
        C23345wl7 c23345wl7L = ((C23345wl7) abstractC17457n0).l();
        AbstractC9585aD abstractC9585aDW = c23345wl7L != null ? c23345wl7L.w() : null;
        XC xc = abstractC9585aDW instanceof XC ? (XC) abstractC9585aDW : null;
        if (xc == null) {
            return false;
        }
        return AbstractC13042fc3.d(xc.u(), "HTML");
    }

    private final boolean L(String str) {
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (AbstractC10868cL0.c(str.charAt(i2)) == XJ0.p) {
                i++;
            }
            if (i >= 2) {
                return false;
            }
        }
        return i == 1;
    }

    private final String M(J44 j44, String str) {
        return (AbstractC20153rZ6.S(str, "/start", false, 2, null) && L(str) && j44.U() == AbstractC5969Lp4.f()) ? "/start" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 N(J44 j44, C17532n74 c17532n74) {
        AbstractC13042fc3.i(j44, "<unused var>");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContextThemeWrapper O(C10913cQ0 c10913cQ0) {
        AbstractC13042fc3.i(c10913cQ0, "this$0");
        return new ContextThemeWrapper(c10913cQ0.o, AbstractC23035wE5.Theme_Bale_BubbleTheme_Outgoing);
    }

    private final Spannable P(String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!new ir.nasim.core.runtime.markdown.html.a(str).f()) {
            return spannableStringBuilder;
        }
        List<AbstractC16012kZ2.b> listB = AbstractC16012kZ2.b(str);
        AbstractC13042fc3.f(listB);
        for (AbstractC16012kZ2.b bVar : listB) {
            spannableStringBuilder.append(bVar.b() ? AbstractC14221hZ2.a(bVar.a(), 0) : bVar.a());
        }
        return spannableStringBuilder;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0484  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x04cd  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x04de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final android.text.SpannableString Q(ir.nasim.AbstractC17457n0 r24) {
        /*
            Method dump skipped, instructions count: 1338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10913cQ0.Q(ir.nasim.n0):android.text.SpannableString");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List R() {
        return AbstractC10360bX0.m();
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x018d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final ir.nasim.C8337Vn5 S(ir.nasim.J44 r13) {
        /*
            Method dump skipped, instructions count: 452
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10913cQ0.S(ir.nasim.J44):ir.nasim.Vn5");
    }

    private final Spannable T(C6833Pe1 c6833Pe1, J44 j44, String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String strV = c6833Pe1.v();
        spannableStringBuilder.append((CharSequence) strV);
        C22161um c22161umX = x();
        if (c22161umX != null) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(c22161umX.a(j44.U())), 0, strV.length(), 17);
        }
        SpannableStringBuilder spannableStringBuilderAppend = spannableStringBuilder.append((CharSequence) new SpannableString(str));
        AbstractC13042fc3.h(spannableStringBuilderAppend, "append(...)");
        return spannableStringBuilderAppend;
    }

    private final Spannable U(ir.nasim.core.modules.messaging.entity.content.a aVar, boolean z) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        CrowdfundingContentInfo crowdfundingContentInfoC = C(aVar);
        Spannable spannableF = AbstractC5730Kp.f(crowdfundingContentInfoC.getTitle(), null, null, null);
        spannableF.setSpan(new T10(C6011Lu2.i()), 0, spannableF.length(), 33);
        spannableStringBuilder.append((CharSequence) spannableF);
        if (crowdfundingContentInfoC.getStatus() == EnumC16838lx.INPROGRESS && crowdfundingContentInfoC.p() != null && !crowdfundingContentInfoC.t()) {
            spannableStringBuilder.append((CharSequence) Separators.RETURN);
            spannableStringBuilder.append((CharSequence) Separators.SP);
            spannableStringBuilder.setSpan(new C20431s00(C22078ud6.a(8.0f)), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
            spannableStringBuilder.append((CharSequence) Separators.RETURN);
            Spannable spannableF2 = AbstractC5730Kp.f(crowdfundingContentInfoC.getDescription(), null, null, null);
            spannableF2.setSpan(new T10(C6011Lu2.k()), 0, spannableF2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableF2);
        }
        return spannableStringBuilder;
    }

    private final Spannable V(NI5 ni5, J44 j44) {
        Spannable spannableD = AbstractC5730Kp.d(Q(ni5));
        AbstractC13042fc3.h(spannableD, "processMarkdowns(...)");
        return spannableD;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003c, code lost:
    
        if ((!r5.equals(r7)) == true) goto L17;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:66:0x012c  */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final ir.nasim.C8837Xn5 W(ir.nasim.J44 r18, ir.nasim.AbstractC17457n0 r19, java.lang.String r20, android.text.Spannable r21, java.lang.String r22, android.text.Spannable r23) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10913cQ0.W(ir.nasim.J44, ir.nasim.n0, java.lang.String, android.text.Spannable, java.lang.String, android.text.Spannable):ir.nasim.Xn5");
    }

    private final void Y(long j, C8837Xn5 c8837Xn5) {
        if (this.n) {
            LruCache lruCache = this.q;
            if (lruCache != null) {
                return;
            }
            return;
        }
        HashMap map = this.r;
        if (map != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C18226oI5 Z(C10913cQ0 c10913cQ0) {
        AbstractC13042fc3.i(c10913cQ0, "this$0");
        return new C18226oI5(c10913cQ0.o);
    }

    private final void a0(J44 j44) {
        CI7 ci7C = this.c.c(Integer.valueOf(j44.U()));
        if (ci7C != null) {
            j44.o0(ci7C);
        }
    }

    private final void d0(J44 j44) {
        C8445Vz5 c8445Vz5Q = j44.Q();
        if (c8445Vz5Q != null) {
            c8445Vz5Q.F(C7741Sz5.a.a(c8445Vz5Q).a());
        }
    }

    private final void g0(J44 j44) {
        if (j44.F() instanceof InterfaceC4499Fj7) {
            InterfaceC25103zk1 interfaceC25103zk1F = j44.F();
            AbstractC13042fc3.g(interfaceC25103zk1F, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.TargetedServiceContent");
            InterfaceC4499Fj7 interfaceC4499Fj7 = (InterfaceC4499Fj7) interfaceC25103zk1F;
            interfaceC4499Fj7.d(this.c.e(Integer.valueOf(interfaceC4499Fj7.c())));
        }
    }

    private final boolean h0(AbstractC17457n0 abstractC17457n0) {
        return (abstractC17457n0 instanceof C23345wl7) || (abstractC17457n0 instanceof C24967zW1) || (abstractC17457n0 instanceof JM6) || (abstractC17457n0 instanceof C16799lt) || (abstractC17457n0 instanceof C10844cI3) || (abstractC17457n0 instanceof C6833Pe1) || (abstractC17457n0 instanceof C18626oy5) || (abstractC17457n0 instanceof C22472vI2) || (abstractC17457n0 instanceof BJ2) || (abstractC17457n0 instanceof ir.nasim.core.modules.messaging.entity.content.a) || (abstractC17457n0 instanceof C11907dl) || (abstractC17457n0 instanceof LC3) || (abstractC17457n0 instanceof C19049ph5) || ((abstractC17457n0 instanceof C22149uk7) && this.b != ExPeerType.BOT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C22161um m(C10913cQ0 c10913cQ0) {
        AbstractC13042fc3.i(c10913cQ0, "this$0");
        if (c10913cQ0.b == ExPeerType.GROUP) {
            return new C22161um(c10913cQ0.o);
        }
        return null;
    }

    private final void n(J44 j44, String str, SpannableStringBuilder spannableStringBuilder) {
        if (!this.D || j44.U() == AbstractC5969Lp4.f()) {
            return;
        }
        o(j44, str, spannableStringBuilder);
    }

    private final void o(J44 j44, String str, SpannableStringBuilder spannableStringBuilder) {
        if (str == null) {
            str = "???";
        }
        spannableStringBuilder.append((CharSequence) str);
        C22161um c22161umX = x();
        if (c22161umX != null) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(c22161umX.a(j44.U())), 0, str.length(), 17);
        }
    }

    private final C8967Xz7 p(J44 j44, final int i, final C8337Vn5 c8337Vn5) {
        M74 m74 = new M74(this.t, this.u);
        I74 i74 = new I74(this.o);
        ContextThemeWrapper contextThemeWrapper = this.o;
        Integer num = this.h;
        AbstractC13042fc3.f(num);
        int iIntValue = num.intValue();
        SettingsModule settingsModuleS = AbstractC5969Lp4.e().S();
        AbstractC13042fc3.h(settingsModuleS, "getSettingsModule(...)");
        J74 j74 = new J74(contextThemeWrapper, iIntValue, settingsModuleS, this.b == ExPeerType.CHANNEL ? ZN2.CHANNEL : ZN2.GROUP, x());
        F74 f74 = new F74(this.o);
        ContextThemeWrapper contextThemeWrapperB = B();
        ContextThemeWrapper contextThemeWrapperD = D();
        SettingsModule settingsModuleS2 = AbstractC5969Lp4.e().S();
        AbstractC13042fc3.h(settingsModuleS2, "getSettingsModule(...)");
        H74 h74 = new H74(contextThemeWrapperB, contextThemeWrapperD, settingsModuleS2, this.a, this.h.intValue(), new c(this.c), new d(this));
        C16721ll1 c16721ll1 = new C16721ll1();
        N44 n44T = t();
        K74 k74 = new K74(this.o, m74);
        int iIntValue2 = this.h.intValue();
        ExPeerType exPeerType = this.b;
        List list = (List) this.s.invoke();
        R74 r74 = this.k;
        UA2 ua2 = this.j;
        AbstractC13042fc3.f(ua2);
        HM3 hm3 = new HM3();
        Q74 q74 = this.m;
        AbstractC13042fc3.f(q74);
        OO5 oo5 = this.l;
        AbstractC13042fc3.f(oo5);
        return new L74(iIntValue2, exPeerType, list, k74, n44T, h74, i74, j74, r74, c16721ll1, ua2, f74, m74, hm3, q74, oo5, new UA2() { // from class: ir.nasim.bQ0
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C10913cQ0.q(i, c8337Vn5, ((Integer) obj).intValue());
            }
        }, false, new b(this.c), this.o, this.w).n(new XV4(j44, Integer.valueOf(i)), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C8337Vn5 q(int i, C8337Vn5 c8337Vn5, int i2) {
        if (i2 == i) {
            return c8337Vn5;
        }
        return null;
    }

    private final boolean r(C6833Pe1 c6833Pe1) {
        return c6833Pe1.y() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TZ0 s(C10913cQ0 c10913cQ0) {
        AbstractC13042fc3.i(c10913cQ0, "this$0");
        return new TZ0(c10913cQ0.o);
    }

    private final N44 t() {
        final InterfaceC8344Vo3 interfaceC8344Vo3O = AbstractC5969Lp4.b().o();
        if (this.a.s() != W25.b) {
            int peerId = this.a.getPeerId();
            Integer num = this.h;
            AbstractC13042fc3.f(num);
            int iIntValue = num.intValue();
            SettingsModule settingsModule = this.g;
            AbstractC13042fc3.f(settingsModule);
            IQ0 iq0 = this.i;
            AbstractC13042fc3.f(iq0);
            return new N44(peerId, iIntValue, settingsModule, iq0, (List) this.s.invoke(), false, new UA2() { // from class: ir.nasim.TP0
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(C10913cQ0.v(this.a, interfaceC8344Vo3O, (C8445Vz5) obj));
                }
            }, 32, null);
        }
        int peerId2 = this.a.getPeerId();
        Integer num2 = this.h;
        AbstractC13042fc3.f(num2);
        int iIntValue2 = num2.intValue();
        SettingsModule settingsModule2 = this.g;
        AbstractC13042fc3.f(settingsModule2);
        AbstractC14869id0 abstractC14869id0N = AbstractC5969Lp4.b().n(this.a.getPeerId());
        AbstractC13042fc3.f(abstractC14869id0N);
        C14733iO2 c14733iO2 = (C14733iO2) abstractC14869id0N;
        ZN2 zn2 = this.b == ExPeerType.GROUP ? ZN2.GROUP : ZN2.CHANNEL;
        List list = (List) this.s.invoke();
        IQ0 iq02 = this.i;
        AbstractC13042fc3.f(iq02);
        OO5 oo5 = this.l;
        AbstractC13042fc3.f(oo5);
        return new AM2(peerId2, iIntValue2, settingsModule2, c14733iO2, zn2, list, iq02, oo5.c(), new UA2() { // from class: ir.nasim.SP0
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return Boolean.valueOf(C10913cQ0.u(this.a, interfaceC8344Vo3O, (C8445Vz5) obj));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean u(C10913cQ0 c10913cQ0, InterfaceC8344Vo3 interfaceC8344Vo3, C8445Vz5 c8445Vz5) {
        AbstractC13042fc3.i(c10913cQ0, "this$0");
        AbstractC13042fc3.i(c8445Vz5, "it");
        AbstractC13042fc3.f(interfaceC8344Vo3);
        return c10913cQ0.J(c8445Vz5, interfaceC8344Vo3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean v(C10913cQ0 c10913cQ0, InterfaceC8344Vo3 interfaceC8344Vo3, C8445Vz5 c8445Vz5) {
        AbstractC13042fc3.i(c10913cQ0, "this$0");
        AbstractC13042fc3.i(c8445Vz5, "it");
        AbstractC13042fc3.f(interfaceC8344Vo3);
        return c10913cQ0.J(c8445Vz5, interfaceC8344Vo3);
    }

    private final String w(J44 j44) {
        String strV;
        AbstractC17457n0 abstractC17457n0F = j44.F();
        if (abstractC17457n0F instanceof LC3) {
            String strV2 = ((LC3) abstractC17457n0F).l().v();
            if (!AbstractC20762sZ6.n0(strV2)) {
                return strV2;
            }
            String string = this.o.getString(AbstractC12217eE5.media_live);
            AbstractC13042fc3.h(string, "getString(...)");
            return string;
        }
        if (!(abstractC17457n0F instanceof C6833Pe1)) {
            if (abstractC17457n0F instanceof C22472vI2) {
                return ((C22472vI2) abstractC17457n0F).t();
            }
            if (abstractC17457n0F instanceof BJ2) {
                return ((BJ2) abstractC17457n0F).r();
            }
            if (abstractC17457n0F instanceof ir.nasim.core.modules.messaging.entity.content.a) {
                return ((ir.nasim.core.modules.messaging.entity.content.a) abstractC17457n0F).t().getDescription();
            }
            if (abstractC17457n0F instanceof C10844cI3) {
                return ((C10844cI3) abstractC17457n0F).v();
            }
            if (abstractC17457n0F instanceof C12872fJ6) {
                return ((C12872fJ6) abstractC17457n0F).s();
            }
            C23345wl7 c23345wl7L = abstractC17457n0F.l();
            if (this.b == ExPeerType.BOT && c23345wl7L != null && (strV = c23345wl7L.v()) != null && AbstractC20153rZ6.S(strV, Separators.SLASH, false, 2, null)) {
                return M(j44, c23345wl7L.v());
            }
            if (c23345wl7L != null) {
                return c23345wl7L.v();
            }
        }
        return null;
    }

    private final C22161um x() {
        return (C22161um) this.y.getValue();
    }

    private final TZ0 z() {
        return (TZ0) this.C.getValue();
    }

    public final void I(List list) {
        AbstractC13042fc3.i(list, "messages");
        if (this.n) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                J44 j44 = (J44) it.next();
                LruCache lruCache = this.p;
                if (lruCache != null) {
                }
            }
        }
    }

    public final void X(J44 j44, C8967Xz7 c8967Xz7) {
        LruCache lruCache;
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(c8967Xz7, "data");
        if (this.n && (lruCache = this.p) != null) {
        }
    }

    @Override // ir.nasim.VB3
    public Object a(List list, Object obj) {
        C8967Xz7 c8967Xz7Y;
        AbstractC13042fc3.i(list, "items");
        this.c.f(list);
        if (!this.n) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(S((J44) it.next()));
            }
            return new C8571Wn5((C8337Vn5[]) arrayList.toArray(new C8337Vn5[0]));
        }
        ArrayList arrayList2 = new ArrayList(list.size());
        Iterator it2 = list.iterator();
        int i = 0;
        while (it2.hasNext()) {
            int i2 = i + 1;
            J44 j44 = (J44) it2.next();
            if (!C8386Vt0.T4() || (c8967Xz7Y = y(j44)) == null) {
                try {
                    C8967Xz7 c8967Xz7P = p(j44, i, S(j44));
                    X(j44, c8967Xz7P);
                    arrayList2.add(c8967Xz7P);
                } catch (Exception e) {
                    C19406qI3.c("ChatListProcessor", "Failed to build UI message for rid: " + j44.i(), e);
                }
            } else {
                arrayList2.add(c8967Xz7Y);
            }
            i = i2;
        }
        return new C21751u43((C8967Xz7[]) arrayList2.toArray(new C8967Xz7[0]));
    }

    public final void b0(InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "<set-?>");
        this.w = interfaceC14603iB2;
    }

    public final void c0(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "<set-?>");
        this.s = sa2;
    }

    public final void e0(long j) {
        this.t = j;
    }

    public final void f0(long j) {
        this.u = j;
    }

    public final C8967Xz7 y(J44 j44) {
        LruCache lruCache;
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        if (this.n && (lruCache = this.p) != null) {
            return (C8967Xz7) lruCache.get(Integer.valueOf(G(j44)));
        }
        return null;
    }
}
