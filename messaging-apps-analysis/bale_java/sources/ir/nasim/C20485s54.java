package ir.nasim;

import android.content.Context;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import android.os.Handler;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.util.LruCache;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC22588vV1;
import ir.nasim.AbstractC4571Fr7;
import ir.nasim.C16401lC7;
import ir.nasim.C20603sI0;
import ir.nasim.C5521Jr6;
import ir.nasim.P64;
import ir.nasim.core.modules.messaging.entity.content.CrowdfundingContentInfo;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.s54, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20485s54 extends AbstractC21435tf0 implements SZ2 {
    private static final a V = new a(null);
    public static final int W = 8;
    private boolean A;
    private final InterfaceC9169Yu B;
    private final boolean C;
    private final ContextThemeWrapper D;
    private List E;
    private long F;
    private long G;
    private K74 H;
    private L74 I;
    private InterfaceC14123hO3 J;
    private final LruCache K;
    private final InterfaceC9173Yu3 L;
    private final C20919sp4 M;
    private long N;
    private final TreeSet O;
    private J44 P;
    private final InterfaceC9173Yu3 Q;
    private final Runnable R;
    private final InterfaceC9173Yu3 S;
    private final InterfaceC9173Yu3 T;
    private final InterfaceC9173Yu3 U;
    private final SettingsModule g;
    private final InterfaceC10258bL6 h;
    private final AbstractC23538x54 i;
    private final int j;
    private final C11458d25 k;
    private final ExPeerType l;
    private final IQ0 m;
    private final int n;
    private final InterfaceC14123hO3 o;
    private final InterfaceC14123hO3 p;
    private final InterfaceC14123hO3 q;
    private final InterfaceC14123hO3 r;
    private final C13518gM7 s;
    private final C8396Vu1 t;
    private final EW7 u;
    private final B17 v;
    private boolean w;
    private final HM3 x;
    private final OO5 y;
    private final Q74 z;

    /* renamed from: ir.nasim.s54$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.s54$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[EnumC9782aY7.values().length];
            try {
                iArr[EnumC9782aY7.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC9782aY7.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC9782aY7.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC9782aY7.e.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnumC9782aY7.g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EnumC9782aY7.h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[EnumC9782aY7.i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[EnumC9782aY7.j.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[EnumC9782aY7.f.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[EnumC9782aY7.l.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[EnumC9782aY7.m.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[EnumC9782aY7.n.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[EnumC9782aY7.y.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[EnumC9782aY7.o.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[EnumC9782aY7.q.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[EnumC9782aY7.t.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[EnumC9782aY7.r.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[EnumC9782aY7.v.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[EnumC9782aY7.s.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[EnumC9782aY7.w.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[EnumC9782aY7.x.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[EnumC9782aY7.z.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[EnumC9782aY7.k.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            a = iArr;
            int[] iArr2 = new int[C20603sI0.a.values().length];
            try {
                iArr2[C20603sI0.a.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr2[C20603sI0.a.UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr2[C20603sI0.a.MOVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr2[C20603sI0.a.REMOVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused27) {
            }
            b = iArr2;
        }
    }

    /* renamed from: ir.nasim.s54$c */
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

    /* renamed from: ir.nasim.s54$d */
    /* synthetic */ class d extends EB2 implements InterfaceC14603iB2 {
        d(Object obj) {
            super(2, obj, C20485s54.class, "getCrowdFundingInfo", "getCrowdFundingInfo(Lir/nasim/core/modules/messaging/entity/Message;Lir/nasim/core/modules/messaging/entity/content/CrowdfundingContentInfo;)Lir/nasim/core/modules/messaging/entity/content/CrowdfundingContentInfo;", 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final CrowdfundingContentInfo invoke(J44 j44, CrowdfundingContentInfo crowdfundingContentInfo) {
            AbstractC13042fc3.i(j44, "p0");
            AbstractC13042fc3.i(crowdfundingContentInfo, "p1");
            return ((C20485s54) this.receiver).M0(j44, crowdfundingContentInfo);
        }
    }

    /* renamed from: ir.nasim.s54$e */
    /* synthetic */ class e extends EB2 implements UA2 {
        e(Object obj) {
            super(1, obj, C20485s54.class, "getAlbumItemSelectionInfo", "getAlbumItemSelectionInfo(Lir/nasim/features/conversation/messages/content/data/UIMessage;)Ljava/lang/Boolean;", 0);
        }

        @Override // ir.nasim.UA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(C8967Xz7 c8967Xz7) {
            AbstractC13042fc3.i(c8967Xz7, "p0");
            return ((C20485s54) this.receiver).d(c8967Xz7);
        }
    }

    /* renamed from: ir.nasim.s54$f */
    /* synthetic */ class f extends EB2 implements UA2 {
        f(Object obj) {
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

    /* renamed from: ir.nasim.s54$g */
    /* synthetic */ class g extends EB2 implements InterfaceC14603iB2 {
        g(Object obj) {
            super(2, obj, C20485s54.class, "openReplies", "openReplies(Lir/nasim/core/modules/messaging/entity/Message;Lir/nasim/core/modules/messaging/entity/comment/MessageRepliesInfo;)V", 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            y((J44) obj, (C17532n74) obj2);
            return C19938rB7.a;
        }

        public final void y(J44 j44, C17532n74 c17532n74) {
            AbstractC13042fc3.i(j44, "p0");
            ((C20485s54) this.receiver).d1(j44, c17532n74);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C20485s54(SettingsModule settingsModule, Context context, final XZ xz, InterfaceC10258bL6 interfaceC10258bL6, AbstractC23538x54 abstractC23538x54, int i, C11458d25 c11458d25, ExPeerType exPeerType, IQ0 iq0, C19024pf0 c19024pf0, long j, long j2, int i2, InterfaceC14123hO3 interfaceC14123hO3, InterfaceC14123hO3 interfaceC14123hO32, InterfaceC14123hO3 interfaceC14123hO33, InterfaceC14123hO3 interfaceC14123hO34, C13518gM7 c13518gM7, C8396Vu1 c8396Vu1, EW7 ew7, B17 b17, boolean z, HM3 hm3, OO5 oo5, Q74 q74, boolean z2, InterfaceC9169Yu interfaceC9169Yu) {
        super(c19024pf0, false);
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(context, "originalContext");
        AbstractC13042fc3.i(xz, "lifecycleOwner");
        AbstractC13042fc3.i(interfaceC10258bL6, "chatUIState");
        AbstractC13042fc3.i(abstractC23538x54, "clickListenerAdapter");
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(iq0, "chatType");
        AbstractC13042fc3.i(interfaceC14123hO32, "messageToServiceMessageMapper");
        AbstractC13042fc3.i(interfaceC14123hO33, "contentToTemplateMapper");
        AbstractC13042fc3.i(interfaceC14123hO34, "exPeerTypeToTrafficUsageOriginMapper");
        AbstractC13042fc3.i(c13518gM7, "usersProcessor");
        AbstractC13042fc3.i(c8396Vu1, "crowdFundingProcessor");
        AbstractC13042fc3.i(ew7, "viewHolderClickListener");
        AbstractC13042fc3.i(b17, "onSuggestionChannelClickListener");
        AbstractC13042fc3.i(hm3, "magazineSuggestStateProcessor");
        AbstractC13042fc3.i(oo5, "repliesActions");
        AbstractC13042fc3.i(q74, "messageToUpVote");
        AbstractC13042fc3.i(interfaceC9169Yu, "anonymousUserListener");
        this.g = settingsModule;
        this.h = interfaceC10258bL6;
        this.i = abstractC23538x54;
        this.j = i;
        this.k = c11458d25;
        this.l = exPeerType;
        this.m = iq0;
        this.n = i2;
        this.o = interfaceC14123hO3;
        this.p = interfaceC14123hO32;
        this.q = interfaceC14123hO33;
        this.r = interfaceC14123hO34;
        this.s = c13518gM7;
        this.t = c8396Vu1;
        this.u = ew7;
        this.v = b17;
        this.w = z;
        this.x = hm3;
        this.y = oo5;
        this.z = q74;
        this.A = z2;
        this.B = interfaceC9169Yu;
        boolean zA7 = C8386Vt0.a7();
        this.C = zA7;
        this.D = new ContextThemeWrapper(context, AbstractC23035wE5.Theme_Bale_BubbleTheme);
        this.E = AbstractC10360bX0.m();
        this.F = j;
        this.G = j2;
        this.K = zA7 ? new LruCache(SIPTransactionStack.BASE_TIMER_INTERVAL) : null;
        this.L = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Q44
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C20485s54.t0(this.a, xz);
            }
        });
        this.M = new C20919sp4();
        this.N = -1L;
        this.O = F0();
        this.Q = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.R44
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C20485s54.U0();
            }
        });
        this.R = new Runnable() { // from class: ir.nasim.S44
            @Override // java.lang.Runnable
            public final void run() {
                C20485s54.T0(this.a);
            }
        };
        if (zA7) {
            x1();
        }
        SettingsModule settingsModuleS = AbstractC5969Lp4.e().S();
        AbstractC13042fc3.h(settingsModuleS, "getSettingsModule(...)");
        AbstractC18639p0.b(settingsModuleS);
        C3335Al0.w(C3335Al0.a, null, 1, null);
        this.S = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.T44
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C20485s54.J0(this.a);
            }
        });
        this.T = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.U44
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C20485s54.V0(this.a);
            }
        });
        this.U = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.V44
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C20485s54.e1(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 A0(C20485s54 c20485s54, J44 j44, C17532n74 c17532n74) {
        AbstractC13042fc3.i(c20485s54, "this$0");
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        c20485s54.i.b().b(j44, c17532n74);
        return C19938rB7.a;
    }

    private final void A1(long j) {
        VB3 vb3P = this.d.p();
        AbstractC13042fc3.g(vb3P, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.preprocessor.ChatListProcessor");
        ((C10913cQ0) vb3P).e0(j);
    }

    private final N44 B0() {
        final InterfaceC8344Vo3 interfaceC8344Vo3O = AbstractC5969Lp4.b().o();
        if (this.k.s() != W25.b) {
            return new N44(this.k.getPeerId(), this.j, this.g, this.m, this.E, false, new UA2() { // from class: ir.nasim.e54
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(C20485s54.D0(this.a, interfaceC8344Vo3O, (C8445Vz5) obj));
                }
            }, 32, null);
        }
        int peerId = this.k.getPeerId();
        int i = this.j;
        SettingsModule settingsModule = this.g;
        AbstractC14869id0 abstractC14869id0N = AbstractC5969Lp4.b().n(this.k.getPeerId());
        AbstractC13042fc3.f(abstractC14869id0N);
        return new AM2(peerId, i, settingsModule, (C14733iO2) abstractC14869id0N, this.l == ExPeerType.GROUP ? ZN2.GROUP : ZN2.CHANNEL, this.E, this.m, this.y.c(), new UA2() { // from class: ir.nasim.d54
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return Boolean.valueOf(C20485s54.C0(this.a, interfaceC8344Vo3O, (C8445Vz5) obj));
            }
        });
    }

    private final void B1(long j) {
        VB3 vb3P = this.d.p();
        AbstractC13042fc3.g(vb3P, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.preprocessor.ChatListProcessor");
        ((C10913cQ0) vb3P).f0(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean C0(C20485s54 c20485s54, InterfaceC8344Vo3 interfaceC8344Vo3, C8445Vz5 c8445Vz5) {
        AbstractC13042fc3.i(c20485s54, "this$0");
        AbstractC13042fc3.i(c8445Vz5, "quotedMessage");
        AbstractC13042fc3.f(interfaceC8344Vo3);
        return c20485s54.X0(c8445Vz5, interfaceC8344Vo3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean D0(C20485s54 c20485s54, InterfaceC8344Vo3 interfaceC8344Vo3, C8445Vz5 c8445Vz5) {
        AbstractC13042fc3.i(c20485s54, "this$0");
        AbstractC13042fc3.i(c8445Vz5, "quotedMessage");
        AbstractC13042fc3.f(interfaceC8344Vo3);
        return c20485s54.X0(c8445Vz5, interfaceC8344Vo3);
    }

    private final K74 E0(InterfaceC14123hO3 interfaceC14123hO3) {
        return new K74(this.D, interfaceC14123hO3);
    }

    private final TreeSet F0() {
        final InterfaceC14603iB2 interfaceC14603iB2 = new InterfaceC14603iB2() { // from class: ir.nasim.b54
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(C20485s54.G0((J44) obj, (J44) obj2));
            }
        };
        return new TreeSet(new Comparator() { // from class: ir.nasim.c54
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C20485s54.H0(interfaceC14603iB2, obj, obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int G0(J44 j44, J44 j442) {
        int iL = AbstractC13042fc3.l(j44.W(), j442.W());
        return iL == 0 ? AbstractC13042fc3.l(j44.i(), j442.i()) : iL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int H0(InterfaceC14603iB2 interfaceC14603iB2, Object obj, Object obj2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$tmp0");
        return ((Number) interfaceC14603iB2.invoke(obj, obj2)).intValue();
    }

    private final M74 I0() {
        return new M74(this.F, this.G);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LayoutInflater J0(C20485s54 c20485s54) {
        AbstractC13042fc3.i(c20485s54, "this$0");
        return LayoutInflater.from(c20485s54.D);
    }

    private final C22742vl0 K0() {
        return (C22742vl0) this.L.getValue();
    }

    private final C10913cQ0 L0() {
        VB3 vb3P = this.d.p();
        AbstractC13042fc3.g(vb3P, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.preprocessor.ChatListProcessor");
        return (C10913cQ0) vb3P;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CrowdfundingContentInfo M0(J44 j44, CrowdfundingContentInfo crowdfundingContentInfo) {
        return this.t.c(j44, crowdfundingContentInfo, new SA2() { // from class: ir.nasim.i54
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C20485s54.N0(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 N0(C20485s54 c20485s54) {
        AbstractC13042fc3.i(c20485s54, "this$0");
        c20485s54.notifyDataSetChanged();
        return C19938rB7.a;
    }

    private final Spannable O0(J44 j44, int i) {
        LruCache lruCache;
        Spannable spannable;
        if (j44.g0()) {
            return null;
        }
        J44 j44C = i < getItemCount() + (-1) ? C(i + 1) : null;
        if (!this.C) {
            return u0(j44, j44C);
        }
        XV4 xv4 = new XV4(Long.valueOf(j44.h()), Long.valueOf(j44C != null ? j44C.h() : -1L));
        LruCache lruCache2 = this.K;
        if (lruCache2 != null && (spannable = (Spannable) lruCache2.get(xv4)) != null) {
            return spannable;
        }
        Spannable spannableU0 = u0(j44, j44C);
        if (spannableU0 != null && (lruCache = this.K) != null) {
        }
        return spannableU0;
    }

    private final LayoutInflater P0() {
        return (LayoutInflater) this.S.getValue();
    }

    private final Handler Q0() {
        return (Handler) this.Q.getValue();
    }

    private final ContextThemeWrapper R0() {
        return (ContextThemeWrapper) this.T.getValue();
    }

    private final ContextThemeWrapper S0() {
        return (ContextThemeWrapper) this.U.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(C20485s54 c20485s54) {
        AbstractC13042fc3.i(c20485s54, "this$0");
        c20485s54.e(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler U0() {
        return new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContextThemeWrapper V0(C20485s54 c20485s54) {
        AbstractC13042fc3.i(c20485s54, "this$0");
        return new ContextThemeWrapper(c20485s54.D, AbstractC23035wE5.Theme_Bale_BubbleTheme_Incomming);
    }

    private final void W0(List list) {
        if (this.C) {
            L0().I(list);
        }
    }

    private final boolean X0(C8445Vz5 c8445Vz5, InterfaceC8344Vo3 interfaceC8344Vo3) {
        C11458d25 c11458d25U;
        C14697iL2 c14697iL2;
        if (c8445Vz5.E() && (c11458d25U = c8445Vz5.u()) != null && c11458d25U.s() == W25.b && (c14697iL2 = (C14697iL2) interfaceC8344Vo3.d(c11458d25U.getPeerId())) != null && c14697iL2.q0() == ZN2.CHANNEL) {
            return !AbstractC13042fc3.d(c11458d25U, this.k);
        }
        return false;
    }

    private final boolean Y0(J44 j44) {
        return j44.i() == this.N && !this.y.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d1(J44 j44, C17532n74 c17532n74) {
        this.i.b().b(j44, c17532n74);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContextThemeWrapper e1(C20485s54 c20485s54) {
        AbstractC13042fc3.i(c20485s54, "this$0");
        return new ContextThemeWrapper(c20485s54.D, AbstractC23035wE5.Theme_Bale_BubbleTheme_Outgoing);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(C20485s54 c20485s54, int i) {
        AbstractC13042fc3.i(c20485s54, "this$0");
        c20485s54.notifyItemChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g1(Q64 q64, J44 j44) {
        AbstractC13042fc3.i(q64, "$messageId");
        AbstractC13042fc3.i(j44, "it");
        return j44.i() == q64.i() && j44.h() == q64.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(C20485s54 c20485s54, int i) {
        AbstractC13042fc3.i(c20485s54, "this$0");
        c20485s54.notifyItemChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(final C20485s54 c20485s54, Long l, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(c20485s54, "this$0");
        long j = c20485s54.F;
        if (l != null && l.longValue() == j) {
            return;
        }
        long j2 = c20485s54.F;
        c20485s54.r1(l.longValue());
        int iR = c20485s54.d.r();
        for (final int i = 0; i < iR; i++) {
            J44 j44 = (J44) c20485s54.d.o(i);
            long jW = j44.W();
            long j3 = 1 + j2;
            AbstractC13042fc3.f(l);
            if (jW <= l.longValue() && j3 <= jW) {
                c20485s54.W0(AbstractC9766aX0.e(j44));
                c20485s54.d.l(AbstractC18447og4.f(AbstractC9766aX0.e(j44)), new Runnable() { // from class: ir.nasim.n54
                    @Override // java.lang.Runnable
                    public final void run() {
                        C20485s54.k1(this.a, i);
                    }
                });
            }
            if (jW <= j2) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(C20485s54 c20485s54, int i) {
        AbstractC13042fc3.i(c20485s54, "this$0");
        c20485s54.notifyItemChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l1(final C20485s54 c20485s54, Long l, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(c20485s54, "this$0");
        long j = c20485s54.G;
        if (l != null && l.longValue() == j) {
            return;
        }
        long j2 = c20485s54.G;
        c20485s54.s1(l.longValue());
        int iR = c20485s54.d.r();
        for (final int i = 0; i < iR; i++) {
            J44 j44 = (J44) c20485s54.d.o(i);
            long jW = j44.W();
            long j3 = 1 + j2;
            AbstractC13042fc3.f(l);
            if (jW <= l.longValue() && j3 <= jW) {
                c20485s54.W0(AbstractC9766aX0.e(j44));
                c20485s54.d.l(AbstractC18447og4.f(AbstractC9766aX0.e(j44)), new Runnable() { // from class: ir.nasim.m54
                    @Override // java.lang.Runnable
                    public final void run() {
                        C20485s54.m1(this.a, i);
                    }
                });
            }
            if (jW <= j2) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m1(C20485s54 c20485s54, int i) {
        AbstractC13042fc3.i(c20485s54, "this$0");
        c20485s54.notifyItemChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n1(C20485s54 c20485s54, Long l, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(c20485s54, "this$0");
        long j = c20485s54.F;
        if (l != null && l.longValue() == j) {
            return;
        }
        int iR = c20485s54.d.r();
        for (int i = 0; i < iR; i++) {
            long jW = ((J44) c20485s54.d.o(i)).W();
            long j2 = c20485s54.F + 1;
            AbstractC13042fc3.f(l);
            if (jW <= l.longValue() && j2 <= jW) {
                c20485s54.notifyItemChanged(i);
            }
            if (jW <= c20485s54.F) {
                break;
            }
        }
        c20485s54.r1(l.longValue());
    }

    private final void o0(List list, Runnable runnable) {
        C19024pf0 c19024pf0 = this.d;
        VB3 vb3P = c19024pf0.p();
        AbstractC13042fc3.g(vb3P, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.preprocessor.ChatListProcessor");
        ((C10913cQ0) vb3P).I(list);
        c19024pf0.l(AbstractC18447og4.f(new ArrayList()), runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o1(C20485s54 c20485s54, Long l, AbstractC13554gQ7 abstractC13554gQ7) {
        AbstractC13042fc3.i(c20485s54, "this$0");
        long j = c20485s54.G;
        if (l != null && l.longValue() == j) {
            return;
        }
        int iR = c20485s54.d.r();
        for (int i = 0; i < iR; i++) {
            long jW = ((J44) c20485s54.d.o(i)).W();
            long j2 = c20485s54.G + 1;
            AbstractC13042fc3.f(l);
            if (jW <= l.longValue() && j2 <= jW) {
                c20485s54.notifyItemChanged(i);
            }
            if (jW <= c20485s54.G) {
                break;
            }
        }
        c20485s54.s1(l.longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(C20485s54 c20485s54, int i) {
        AbstractC13042fc3.i(c20485s54, "this$0");
        c20485s54.notifyItemChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List p1(C20485s54 c20485s54) {
        AbstractC13042fc3.i(c20485s54, "this$0");
        return c20485s54.E;
    }

    private final void q0(RecyclerView.C c2, J44 j44, int i) {
        if (this.C) {
            r0(c2, j44, i);
        } else {
            s0(c2, j44, i);
        }
    }

    private final void q1(List list) {
        this.E = list;
        if (this.C) {
            y1(list);
        }
    }

    private final void r0(RecyclerView.C c2, J44 j44, int i) {
        Object objF;
        C8967Xz7[] c8967Xz7ArrA;
        c8967Xz7 = null;
        C8967Xz7 c8967Xz7 = null;
        if (!(c2 instanceof P64)) {
            boolean z = false;
            if (c2 instanceof C5521Jr6) {
                C9456Zz7 c9456Zz7 = (C9456Zz7) this.p.a(j44);
                ((C5521Jr6) c2).r1(j44, c9456Zz7.a((447 & 1) != 0 ? c9456Zz7.a : null, (447 & 2) != 0 ? c9456Zz7.b : null, (447 & 4) != 0 ? c9456Zz7.c : null, (447 & 8) != 0 ? c9456Zz7.d : null, (447 & 16) != 0 ? c9456Zz7.e : null, (447 & 32) != 0 ? c9456Zz7.f : null, (447 & 64) != 0 ? c9456Zz7.g : this.w, (447 & 128) != 0 ? c9456Zz7.h : null, (447 & 256) != 0 ? c9456Zz7.i : null), O0(j44, i), Y0(j44), h(j44), AbstractC13042fc3.d(f(), j44), getSelectedCount() > 0, this.i.i());
                return;
            } else {
                if (c2 instanceof C16401lC7) {
                    K74 k74 = new K74(this.D, new M74(this.F, this.G));
                    if (j44.U() == this.j && this.l != ExPeerType.CHANNEL) {
                        z = true;
                    }
                    SpannableStringBuilder spannableStringBuilderA = k74.a(j44, z, false, this.E.contains(j44), null, null, false);
                    InterfaceC14123hO3 interfaceC14123hO3 = this.o;
                    ((C16401lC7) c2).a1(j44, spannableStringBuilderA, interfaceC14123hO3 != null ? (C20610sI7) interfaceC14123hO3.a(j44) : null);
                    return;
                }
                return;
            }
        }
        Spannable spannableO0 = O0(j44, i);
        Object objD = D();
        C21751u43 c21751u43 = objD instanceof C21751u43 ? (C21751u43) objD : null;
        if (c21751u43 != null && (c8967Xz7ArrA = c21751u43.a()) != null) {
            c8967Xz7 = c8967Xz7ArrA[i];
        }
        C8967Xz7 c8967Xz72 = c8967Xz7;
        if (c8967Xz72 != null) {
            if (c8967Xz72.f() instanceof C8304Vk) {
                List<C14339hl> listA = ((C8304Vk) c8967Xz72.f()).a();
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listA, 10));
                for (C14339hl c14339hl : listA) {
                    arrayList.add(C14339hl.b(c14339hl, null, null, d(c14339hl.d()), 3, null));
                }
                objF = new C8304Vk(arrayList);
            } else {
                objF = c8967Xz72.f();
            }
            ((P64) c2).p1(c8967Xz72.a((324977 & 1) != 0 ? c8967Xz72.a : null, (324977 & 2) != 0 ? c8967Xz72.b : null, (324977 & 4) != 0 ? c8967Xz72.c : null, (324977 & 8) != 0 ? c8967Xz72.d : null, (324977 & 16) != 0 ? c8967Xz72.e : null, (324977 & 32) != 0 ? c8967Xz72.f : null, (324977 & 64) != 0 ? c8967Xz72.g : objF, (324977 & 128) != 0 ? c8967Xz72.h : null, (324977 & 256) != 0 ? c8967Xz72.i : null, (324977 & 512) != 0 ? c8967Xz72.j : null, (324977 & 1024) != 0 ? c8967Xz72.k : null, (324977 & 2048) != 0 ? c8967Xz72.l : null, (324977 & 4096) != 0 ? c8967Xz72.m : null, (324977 & 8192) != 0 ? c8967Xz72.n : h(j44) ? c8967Xz72.n() : c8967Xz72.e(), (324977 & 16384) != 0 ? c8967Xz72.o : null, (324977 & 32768) != 0 ? c8967Xz72.p : null, (324977 & 65536) != 0 ? c8967Xz72.q : null, (324977 & 131072) != 0 ? c8967Xz72.r : false, (324977 & 262144) != 0 ? c8967Xz72.s : false), spannableO0, Y0(j44), h(j44), AbstractC13042fc3.d(f(), j44), this.i);
        }
    }

    private final void r1(long j) {
        this.F = j;
        if (this.C) {
            A1(j);
        } else {
            w1();
        }
    }

    private final void s0(RecyclerView.C c2, J44 j44, int i) {
        if (c2 instanceof P64) {
            L74 l74Y0 = this.I;
            if (l74Y0 == null) {
                l74Y0 = y0();
                this.I = l74Y0;
            }
            C8967Xz7 c8967Xz7N = l74Y0.n(new XV4(j44, Integer.valueOf(i)), h(j44));
            if (h(j44)) {
                c8967Xz7N = c8967Xz7N.a((324977 & 1) != 0 ? c8967Xz7N.a : null, (324977 & 2) != 0 ? c8967Xz7N.b : null, (324977 & 4) != 0 ? c8967Xz7N.c : null, (324977 & 8) != 0 ? c8967Xz7N.d : null, (324977 & 16) != 0 ? c8967Xz7N.e : null, (324977 & 32) != 0 ? c8967Xz7N.f : null, (324977 & 64) != 0 ? c8967Xz7N.g : null, (324977 & 128) != 0 ? c8967Xz7N.h : null, (324977 & 256) != 0 ? c8967Xz7N.i : null, (324977 & 512) != 0 ? c8967Xz7N.j : null, (324977 & 1024) != 0 ? c8967Xz7N.k : null, (324977 & 2048) != 0 ? c8967Xz7N.l : null, (324977 & 4096) != 0 ? c8967Xz7N.m : null, (324977 & 8192) != 0 ? c8967Xz7N.n : c8967Xz7N.n(), (324977 & 16384) != 0 ? c8967Xz7N.o : null, (324977 & 32768) != 0 ? c8967Xz7N.p : null, (324977 & 65536) != 0 ? c8967Xz7N.q : null, (324977 & 131072) != 0 ? c8967Xz7N.r : false, (324977 & 262144) != 0 ? c8967Xz7N.s : false);
            }
            ((P64) c2).p1(c8967Xz7N, O0(j44, i), Y0(j44), h(j44), AbstractC13042fc3.d(f(), j44), this.i);
            return;
        }
        boolean z = false;
        if (c2 instanceof C5521Jr6) {
            C9456Zz7 c9456Zz7 = (C9456Zz7) this.p.a(j44);
            ((C5521Jr6) c2).r1(j44, c9456Zz7.a((447 & 1) != 0 ? c9456Zz7.a : null, (447 & 2) != 0 ? c9456Zz7.b : null, (447 & 4) != 0 ? c9456Zz7.c : null, (447 & 8) != 0 ? c9456Zz7.d : null, (447 & 16) != 0 ? c9456Zz7.e : null, (447 & 32) != 0 ? c9456Zz7.f : null, (447 & 64) != 0 ? c9456Zz7.g : this.w, (447 & 128) != 0 ? c9456Zz7.h : null, (447 & 256) != 0 ? c9456Zz7.i : null), O0(j44, i), Y0(j44), h(j44), AbstractC13042fc3.d(f(), j44), getSelectedCount() > 0, this.i.i());
            return;
        }
        if (c2 instanceof C16401lC7) {
            InterfaceC14123hO3 interfaceC14123hO3I0 = this.J;
            if (interfaceC14123hO3I0 == null) {
                interfaceC14123hO3I0 = I0();
                this.J = interfaceC14123hO3I0;
            }
            K74 k74 = this.H;
            K74 k74E0 = k74 == null ? E0(interfaceC14123hO3I0) : k74;
            if (j44.U() == this.j && this.l != ExPeerType.CHANNEL) {
                z = true;
            }
            SpannableStringBuilder spannableStringBuilderA = k74E0.a(j44, z, false, this.E.contains(j44), null, null, false);
            InterfaceC14123hO3 interfaceC14123hO3 = this.o;
            ((C16401lC7) c2).a1(j44, spannableStringBuilderA, interfaceC14123hO3 != null ? (C20610sI7) interfaceC14123hO3.a(j44) : null);
        }
    }

    private final void s1(long j) {
        this.G = j;
        if (this.C) {
            B1(j);
        } else {
            w1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C22742vl0 t0(C20485s54 c20485s54, XZ xz) {
        AbstractC13042fc3.i(c20485s54, "this$0");
        AbstractC13042fc3.i(xz, "$lifecycleOwner");
        int peerId = c20485s54.k.getPeerId();
        AbstractC23538x54 abstractC23538x54 = c20485s54.i;
        long jK4 = c20485s54.g.K4();
        long jM4 = c20485s54.g.M4();
        List listN0 = AbstractC20762sZ6.N0(c20485s54.g.L4(), new String[]{","}, false, 0, 6, null);
        String upperCase = c20485s54.l.name().toUpperCase(Locale.ROOT);
        AbstractC13042fc3.h(upperCase, "toUpperCase(...)");
        return new C22742vl0(peerId, xz, abstractC23538x54, jK4, jM4, listN0.contains(upperCase));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t1(C20485s54 c20485s54) {
        AbstractC13042fc3.i(c20485s54, "this$0");
        c20485s54.notifyDataSetChanged();
    }

    private final Spannable u0(J44 j44, J44 j442) {
        C3460Az c3460AzO;
        if (j442 == null ? (c3460AzO = j44.O()) == null || !C14593iA1.J(c3460AzO.h(), j44.h()) : !C14593iA1.J(j442.h(), j44.h())) {
            return AbstractC17636nI6.i(C14593iA1.p(this.D, j44.h(), true, false, 8, null));
        }
        return null;
    }

    private final void u1() {
        v1();
        Q0().postDelayed(this.R, 1700L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(C20485s54 c20485s54) {
        AbstractC13042fc3.i(c20485s54, "this$0");
        c20485s54.notifyDataSetChanged();
    }

    private final void v1() {
        Q0().removeCallbacks(this.R);
    }

    private final H74 w0() {
        ContextThemeWrapper contextThemeWrapperR0 = R0();
        ContextThemeWrapper contextThemeWrapperS0 = S0();
        SettingsModule settingsModuleS = AbstractC5969Lp4.e().S();
        AbstractC13042fc3.h(settingsModuleS, "getSettingsModule(...)");
        return new H74(contextThemeWrapperR0, contextThemeWrapperS0, settingsModuleS, this.k, this.j, new c(this.s), new d(this));
    }

    private final void w1() {
        if (this.C) {
            return;
        }
        this.I = y0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(C20485s54 c20485s54, C4311Ep c4311Ep) {
        AbstractC13042fc3.i(c20485s54, "this$0");
        c20485s54.f = c4311Ep;
        C20603sI0 c20603sI0C = c4311Ep.c();
        while (c20603sI0C != null) {
            int i = b.b[c20603sI0C.g().ordinal()];
            if (i == 1) {
                c20485s54.notifyItemRangeInserted(c20603sI0C.d(), c20603sI0C.f());
            } else if (i == 2) {
                c20485s54.notifyItemRangeChanged(c20603sI0C.d(), c20603sI0C.f(), "payload");
            } else if (i == 3) {
                c20485s54.notifyItemMoved(c20603sI0C.d(), c20603sI0C.c());
            } else {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                c20485s54.notifyItemRangeRemoved(c20603sI0C.d(), c20603sI0C.f());
            }
            c20603sI0C = c4311Ep.c();
        }
        c20485s54.f = null;
    }

    private final void x1() {
        VB3 vb3P = this.d.p();
        AbstractC13042fc3.g(vb3P, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.preprocessor.ChatListProcessor");
        ((C10913cQ0) vb3P).b0(new g(this));
    }

    private final L74 y0() {
        C22161um c22161um = this.l == ExPeerType.GROUP ? new C22161um(this.D) : null;
        M74 m74I0 = I0();
        this.J = m74I0;
        K74 k74E0 = E0(m74I0);
        this.H = k74E0;
        int i = this.j;
        ExPeerType exPeerType = this.l;
        List list = this.E;
        N44 n44B0 = B0();
        H74 h74W0 = w0();
        I74 i74 = new I74(this.D);
        ContextThemeWrapper contextThemeWrapper = this.D;
        int i2 = this.j;
        SettingsModule settingsModuleS = AbstractC5969Lp4.e().S();
        AbstractC13042fc3.h(settingsModuleS, "getSettingsModule(...)");
        return new L74(i, exPeerType, list, k74E0, n44B0, h74W0, i74, new J74(contextThemeWrapper, i2, settingsModuleS, this.l == ExPeerType.CHANNEL ? ZN2.CHANNEL : ZN2.GROUP, c22161um), this.o, this.q, new e(this), new F74(this.D), m74I0, this.x, this.z, this.y, new UA2() { // from class: ir.nasim.q54
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C20485s54.z0(this.a, ((Integer) obj).intValue());
            }
        }, this.A, new f(this.s), this.D, new InterfaceC14603iB2() { // from class: ir.nasim.r54
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return C20485s54.A0(this.a, (J44) obj, (C17532n74) obj2);
            }
        });
    }

    private final void y1(final List list) {
        VB3 vb3P = this.d.p();
        AbstractC13042fc3.g(vb3P, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.preprocessor.ChatListProcessor");
        ((C10913cQ0) vb3P).c0(new SA2() { // from class: ir.nasim.f54
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C20485s54.z1(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C8337Vn5 z0(C20485s54 c20485s54, int i) {
        AbstractC13042fc3.i(c20485s54, "this$0");
        Object objD = c20485s54.D();
        AbstractC13042fc3.g(objD, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.preprocessor.PreprocessedList");
        return ((C8571Wn5) objD).a()[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List z1(List list) {
        AbstractC13042fc3.i(list, "$pinnedMessage");
        return list;
    }

    @Override // ir.nasim.AbstractC21435tf0
    protected AbstractC22588vV1.a A() {
        return new AbstractC22588vV1.a() { // from class: ir.nasim.p54
            @Override // ir.nasim.AbstractC22588vV1.a
            public final void a(C4311Ep c4311Ep) {
                C20485s54.x0(this.a, c4311Ep);
            }
        };
    }

    @Override // ir.nasim.AbstractC21435tf0
    /* renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public void G(AbstractC19821r0 abstractC19821r0, int i, J44 j44) {
        AbstractC13042fc3.i(abstractC19821r0, "dialogHolder");
        AbstractC13042fc3.i(j44, "item");
        q0(abstractC19821r0, j44, i);
    }

    @Override // ir.nasim.SZ2
    public boolean a() {
        return this.i.k();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: a1, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(AbstractC19821r0 abstractC19821r0, int i, List list) {
        AbstractC13042fc3.i(abstractC19821r0, "holder");
        AbstractC13042fc3.i(list, "payloads");
        if (list.isEmpty()) {
            super.onBindViewHolder(abstractC19821r0, i, list);
            return;
        }
        J44 j44C = C(i);
        if (j44C == null) {
            return;
        }
        q0(abstractC19821r0, j44C, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public AbstractC19821r0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "viewGroup");
        JW7 jw7A = JW7.f.a(i);
        switch (b.a[jw7A.d().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
                P64.a aVar = P64.A0;
                LayoutInflater layoutInflaterFrom = LayoutInflater.from(R0());
                AbstractC13042fc3.h(layoutInflaterFrom, "from(...)");
                LayoutInflater layoutInflaterFrom2 = LayoutInflater.from(S0());
                AbstractC13042fc3.h(layoutInflaterFrom2, "from(...)");
                InterfaceC22152ul0 interfaceC22152ul0A = K0().a(jw7A);
                ExPeerType exPeerType = this.l;
                AbstractC23538x54 abstractC23538x54 = this.i;
                EW7 ew7 = this.u;
                EnumC8893Xt7 enumC8893Xt7 = (EnumC8893Xt7) this.r.a(exPeerType);
                boolean z = this.A;
                ExPeerType exPeerType2 = this.l;
                return aVar.a(viewGroup, layoutInflaterFrom, layoutInflaterFrom2, jw7A, interfaceC22152ul0A, exPeerType, abstractC23538x54, ew7, enumC8893Xt7, z, (exPeerType2 == ExPeerType.CHANNEL || exPeerType2 == ExPeerType.BOT) && jw7A.d() != EnumC9782aY7.s);
            case 23:
                C5521Jr6.a aVar2 = C5521Jr6.B0;
                LayoutInflater layoutInflaterP0 = P0();
                AbstractC13042fc3.h(layoutInflaterP0, "<get-defaultInflater>(...)");
                return aVar2.a(viewGroup, layoutInflaterP0, this.v, this.B);
            default:
                C16401lC7.a aVar3 = C16401lC7.A;
                LayoutInflater layoutInflaterP02 = P0();
                AbstractC13042fc3.h(layoutInflaterP02, "<get-defaultInflater>(...)");
                return aVar3.a(viewGroup, layoutInflaterP02, jw7A.f(), this.l == ExPeerType.GROUP && jw7A.f(), this.i.j());
        }
    }

    @Override // ir.nasim.SZ2
    public TreeSet c() {
        return this.O;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(AbstractC19821r0 abstractC19821r0) {
        AbstractC13042fc3.i(abstractC19821r0, "holder");
        super.onViewRecycled(abstractC19821r0);
        abstractC19821r0.a();
    }

    @Override // ir.nasim.SZ2
    public Boolean d(C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(c8967Xz7, "uiMessage");
        if (!i() || GY.s.a()) {
            return null;
        }
        return Boolean.valueOf(h(c8967Xz7.j()));
    }

    @Override // ir.nasim.SZ2
    public void e(J44 j44) {
        if (AbstractC13042fc3.d(this.P, j44)) {
            return;
        }
        v1();
        this.P = j44;
        notifyDataSetChanged();
        if (j44 != null) {
            u1();
        }
    }

    @Override // ir.nasim.SZ2
    public J44 f() {
        return this.P;
    }

    @Override // ir.nasim.SZ2
    public C20919sp4 g() {
        return this.M;
    }

    @Override // ir.nasim.AbstractC21435tf0
    /* renamed from: getItem, reason: merged with bridge method [inline-methods] */
    public J44 C(int i) {
        return (J44) super.C(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005a  */
    @Override // androidx.recyclerview.widget.RecyclerView.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int getItemViewType(int r12) {
        /*
            Method dump skipped, instructions count: 576
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20485s54.getItemViewType(int):int");
    }

    @Override // ir.nasim.SZ2
    public int getSelectedCount() {
        return c().size();
    }

    @Override // ir.nasim.SZ2
    public boolean h(J44 j44) {
        AbstractC13042fc3.i(j44, "msg");
        return c().contains(j44);
    }

    @Override // ir.nasim.SZ2
    public boolean i() {
        return getSelectedCount() > 0 || (((JQ0) this.h.getValue()).r() instanceof AbstractC4571Fr7.c);
    }

    @Override // ir.nasim.SZ2
    public void j(boolean z) {
        this.A = z;
        if (this.C) {
            o0(new ArrayList(), new Runnable() { // from class: ir.nasim.h54
                @Override // java.lang.Runnable
                public final void run() {
                    C20485s54.i1();
                }
            });
        }
    }

    @Override // ir.nasim.SZ2
    public void k(List list, boolean z) {
        AbstractC13042fc3.i(list, "messages");
        if (!z) {
            c().removeAll(AbstractC15401jX0.r1(list));
        } else if (getSelectedCount() < this.n) {
            c().addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // ir.nasim.SZ2
    public void l() {
        notifyDataSetChanged();
    }

    @Override // ir.nasim.SZ2
    public void m(C5246In1 c5246In1) {
        AbstractC13042fc3.i(c5246In1, "conversationVM");
        if (this.C) {
            g().r(c5246In1.j(), new InterfaceC14756iQ7() { // from class: ir.nasim.P44
                @Override // ir.nasim.InterfaceC14756iQ7
                public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                    C20485s54.j1(this.a, (Long) obj, abstractC13554gQ7);
                }
            });
            g().r(c5246In1.k(), new InterfaceC14756iQ7() { // from class: ir.nasim.a54
                @Override // ir.nasim.InterfaceC14756iQ7
                public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                    C20485s54.l1(this.a, (Long) obj, abstractC13554gQ7);
                }
            });
        } else {
            g().r(c5246In1.j(), new InterfaceC14756iQ7() { // from class: ir.nasim.k54
                @Override // ir.nasim.InterfaceC14756iQ7
                public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                    C20485s54.n1(this.a, (Long) obj, abstractC13554gQ7);
                }
            });
            g().r(c5246In1.k(), new InterfaceC14756iQ7() { // from class: ir.nasim.l54
                @Override // ir.nasim.InterfaceC14756iQ7
                public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                    C20485s54.o1(this.a, (Long) obj, abstractC13554gQ7);
                }
            });
        }
    }

    @Override // ir.nasim.SZ2
    public void n(J44 j44) {
        AbstractC13042fc3.i(j44, "pinnedMessage");
        if (!this.E.contains(j44)) {
            List listP1 = AbstractC15401jX0.p1(this.E);
            listP1.add(j44);
            q1(listP1);
            if (!this.C) {
                w1();
            }
        }
        int iR = this.d.r();
        for (final int i = 0; i < iR; i++) {
            J44 j442 = (J44) this.d.o(i);
            if (AbstractC13042fc3.d(j442, j44)) {
                if (this.C) {
                    o0(AbstractC10360bX0.g(j442), new Runnable() { // from class: ir.nasim.W44
                        @Override // java.lang.Runnable
                        public final void run() {
                            C20485s54.p0(this.a, i);
                        }
                    });
                } else {
                    notifyItemChanged(i);
                }
            }
        }
    }

    @Override // ir.nasim.SZ2
    public void o(List list) {
        AbstractC13042fc3.i(list, "pinnedMessages");
        q1(list);
        if (this.C) {
            L0().c0(new SA2() { // from class: ir.nasim.g54
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C20485s54.p1(this.a);
                }
            });
            notifyDataSetChanged();
            return;
        }
        w1();
        if (list.isEmpty()) {
            notifyDataSetChanged();
            return;
        }
        int iR = this.d.r();
        for (int i = 0; i < iR; i++) {
            if (list.contains((J44) this.d.o(i))) {
                notifyItemChanged(i);
            }
        }
    }

    @Override // ir.nasim.SZ2
    public void q(boolean z) {
        c().clear();
        if (z) {
            notifyDataSetChanged();
        }
    }

    @Override // ir.nasim.SZ2
    public List r() {
        return this.E;
    }

    @Override // ir.nasim.SZ2
    public void s(J44 j44, boolean z) {
        AbstractC13042fc3.i(j44, "msg");
        if (!z) {
            c().remove(j44);
        } else if (getSelectedCount() < this.n) {
            c().add(j44);
        }
        notifyDataSetChanged();
    }

    @Override // ir.nasim.SZ2
    public void t(J44 j44) {
        AbstractC13042fc3.i(j44, "pinnedMessage");
        if (this.E.contains(j44)) {
            List listP1 = AbstractC15401jX0.p1(this.E);
            listP1.remove(j44);
            q1(listP1);
            if (!this.C) {
                w1();
            }
        }
        int iR = this.d.r();
        for (final int i = 0; i < iR; i++) {
            J44 j442 = (J44) this.d.o(i);
            if (AbstractC13042fc3.d(j442, j44)) {
                if (this.C) {
                    o0(AbstractC10360bX0.g(j442), new Runnable() { // from class: ir.nasim.j54
                        @Override // java.lang.Runnable
                        public final void run() {
                            C20485s54.f1(this.a, i);
                        }
                    });
                } else {
                    notifyItemChanged(i);
                }
            }
        }
    }

    @Override // ir.nasim.SZ2
    public void u(long j) {
        this.N = j;
        AbstractC7426Rr.a.F(new Runnable() { // from class: ir.nasim.X44
            @Override // java.lang.Runnable
            public final void run() {
                C20485s54.v0(this.a);
            }
        });
    }

    @Override // ir.nasim.SZ2
    public void v(final Q64 q64) {
        AbstractC13042fc3.i(q64, "messageId");
        List<J44> list = this.E;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (J44 j44 : list) {
            arrayList.add(AbstractC4616Fw7.a(Long.valueOf(j44.i()), Long.valueOf(j44.h())));
        }
        if (arrayList.contains(AbstractC4616Fw7.a(Long.valueOf(q64.i()), Long.valueOf(q64.h())))) {
            if (q64.i() >= 0 || q64.h() >= 0 || q64.r() >= 0) {
                List listP1 = AbstractC15401jX0.p1(this.E);
                AbstractC13610gX0.K(listP1, new UA2() { // from class: ir.nasim.Y44
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(C20485s54.g1(q64, (J44) obj));
                    }
                });
                q1(listP1);
            } else {
                q1(AbstractC10360bX0.m());
            }
            if (!this.C) {
                w1();
            }
        }
        int iR = this.d.r();
        for (final int i = 0; i < iR; i++) {
            J44 j442 = (J44) this.d.o(i);
            if (j442.i() == q64.i() && j442.h() == q64.h()) {
                if (this.C) {
                    o0(AbstractC10360bX0.g(j442), new Runnable() { // from class: ir.nasim.Z44
                        @Override // java.lang.Runnable
                        public final void run() {
                            C20485s54.h1(this.a, i);
                        }
                    });
                } else {
                    notifyItemChanged(i);
                }
            }
        }
    }

    @Override // ir.nasim.SZ2
    public void w(List list) {
        AbstractC13042fc3.i(list, "upVotes");
        this.x.b(list);
        if (this.C) {
            o0(new ArrayList(), new Runnable() { // from class: ir.nasim.o54
                @Override // java.lang.Runnable
                public final void run() {
                    C20485s54.t1(this.a);
                }
            });
        } else {
            notifyDataSetChanged();
        }
    }

    @Override // ir.nasim.SZ2
    public void x(boolean z) {
        this.w = z;
    }

    @Override // ir.nasim.SZ2
    /* renamed from: c */
    public J44[] mo23c() {
        try {
            return (J44[]) c().toArray(new J44[0]);
        } catch (Exception unused) {
            C19406qI3.d("NON_FATAL_EXCEPTION", new Exception("Selected Message is NULL"));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1() {
    }
}
