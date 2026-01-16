package ir.nasim;

import ai.bale.proto.MessagingStruct$Dialog;
import ai.bale.proto.MessagingStruct$MessageId;
import android.content.Context;
import android.gov.nist.core.Separators;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC19428qK7;
import ir.nasim.AbstractC25195zt3;
import ir.nasim.C24303yO3;
import ir.nasim.KO3;
import ir.nasim.NP1;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.database.dailogLists.UserNamePlaceHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public final class EM1 implements BM1 {
    private final C24011xt3 a;
    private final SettingsModule b;
    private final E84 c;
    private final Context d;
    private final AbstractC13778go1 e;
    private final int f;
    private final InterfaceC11621dJ7 g;
    private final KM2 h;
    private final KO3.a i;
    private final QM1 j;
    private final InterfaceC9173Yu3 k;
    private final InterfaceC9173Yu3 l;

    public static final class a {
        private final String a;
        private final Avatar b;
        private final boolean c;
        private final boolean d;
        private final boolean e;

        public a(String str, Avatar avatar, boolean z, boolean z2, boolean z3) {
            AbstractC13042fc3.i(str, "name");
            this.a = str;
            this.b = avatar;
            this.c = z;
            this.d = z2;
            this.e = z3;
        }

        public final boolean a() {
            return this.d;
        }

        public final boolean b() {
            return this.e;
        }

        public final String c() {
            return this.a;
        }

        public final boolean d() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && AbstractC13042fc3.d(this.b, aVar.b) && this.c == aVar.c && this.d == aVar.d && this.e == aVar.e;
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            Avatar avatar = this.b;
            return ((((((iHashCode + (avatar == null ? 0 : avatar.hashCode())) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + Boolean.hashCode(this.e);
        }

        public String toString() {
            return "DialogPeerDetail(name=" + this.a + ", avatar=" + this.b + ", isDeleteAccount=" + this.c + ", hasBlueTick=" + this.d + ", hasMainWebApp=" + this.e + Separators.RPAREN;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[ExPeerType.values().length];
            try {
                iArr[ExPeerType.PRIVATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ExPeerType.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ExPeerType.CHANNEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ExPeerType.BOT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ExPeerType.THREAD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ExPeerType.UNKNOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            a = iArr;
            int[] iArr2 = new int[EnumC9196Yx.values().length];
            try {
                iArr2[EnumC9196Yx.BOT.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[EnumC9196Yx.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[EnumC9196Yx.CHANNEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[EnumC9196Yx.PRIVATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            b = iArr2;
            int[] iArr3 = new int[EnumC10088b35.values().length];
            try {
                iArr3[EnumC10088b35.ExPeerType_BOT.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[EnumC10088b35.ExPeerType_GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[EnumC10088b35.ExPeerType_CHANNEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[EnumC10088b35.ExPeerType_PRIVATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr3[EnumC10088b35.ExPeerType_THREAD.ordinal()] = 5;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr3[EnumC10088b35.ExPeerType_UNKNOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr3[EnumC10088b35.ExPeerType_SUPERGROUP.ordinal()] = 7;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr3[EnumC10088b35.UNRECOGNIZED.ordinal()] = 8;
            } catch (NoSuchFieldError unused18) {
            }
            c = iArr3;
        }
    }

    static final class c extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return EM1.this.d(0L, null, this);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ ExPeerType c;
        final /* synthetic */ EM1 d;
        final /* synthetic */ long e;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[ExPeerType.values().length];
                try {
                    iArr[ExPeerType.PRIVATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ExPeerType.BOT.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ExPeerType.GROUP.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ExPeerType.CHANNEL.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[ExPeerType.THREAD.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[ExPeerType.UNKNOWN.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(ExPeerType exPeerType, EM1 em1, long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = exPeerType;
            this.d = em1;
            this.e = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.c, this.d, this.e, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0064  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r11.b
                r2 = 2
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L1f
                if (r1 == r4) goto L1b
                if (r1 != r2) goto L13
                ir.nasim.AbstractC10685c16.b(r12)
                goto L46
            L13:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L1b:
                ir.nasim.AbstractC10685c16.b(r12)
                goto L60
            L1f:
                ir.nasim.AbstractC10685c16.b(r12)
                ir.nasim.core.modules.profile.entity.ExPeerType r12 = r11.c
                int[] r1 = ir.nasim.EM1.d.a.a
                int r12 = r12.ordinal()
                r12 = r1[r12]
                switch(r12) {
                    case 1: goto L4f;
                    case 2: goto L4f;
                    case 3: goto L35;
                    case 4: goto L35;
                    case 5: goto L68;
                    case 6: goto L68;
                    default: goto L2f;
                }
            L2f:
                kotlin.NoWhenBranchMatchedException r12 = new kotlin.NoWhenBranchMatchedException
                r12.<init>()
                throw r12
            L35:
                ir.nasim.EM1 r12 = r11.d
                ir.nasim.KM2 r12 = ir.nasim.EM1.j(r12)
                long r5 = r11.e
                r11.b = r2
                java.lang.Object r12 = r12.l(r5, r11)
                if (r12 != r0) goto L46
                return r0
            L46:
                ir.nasim.iL2 r12 = (ir.nasim.C14697iL2) r12
                if (r12 == 0) goto L68
                java.lang.String r3 = r12.v0()
                goto L68
            L4f:
                ir.nasim.EM1 r12 = r11.d
                ir.nasim.dJ7 r12 = ir.nasim.EM1.l(r12)
                long r1 = r11.e
                r11.b = r4
                java.lang.Object r12 = r12.a(r1, r11)
                if (r12 != r0) goto L60
                return r0
            L60:
                ir.nasim.nI7 r12 = (ir.nasim.C17637nI7) r12
                if (r12 == 0) goto L68
                java.lang.String r3 = r12.getName()
            L68:
                ir.nasim.UO1$b r5 = ir.nasim.UO1.b.a
                if (r3 == 0) goto L74
                boolean r12 = ir.nasim.AbstractC14836iZ6.n0(r3)
                if (r12 == 0) goto L73
                goto L74
            L73:
                r4 = 0
            L74:
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r0 = "Dialog title was empty, loaded from their repo and new title isNullOrBlank: "
                r12.append(r0)
                r12.append(r4)
                java.lang.String r6 = r12.toString()
                r9 = 6
                r10 = 0
                r7 = 0
                r8 = 0
                ir.nasim.UO1.b.b(r5, r6, r7, r8, r9, r10)
                if (r3 != 0) goto L9f
                ir.nasim.EM1 r12 = r11.d
                android.content.Context r12 = ir.nasim.EM1.i(r12)
                int r0 = ir.nasim.FD5.user
                java.lang.String r3 = r12.getString(r0)
                java.lang.String r12 = "getString(...)"
                ir.nasim.AbstractC13042fc3.h(r3, r12)
            L9f:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.EM1.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class e extends AbstractC22163um1 {
        boolean A;
        int A0;
        boolean B;
        boolean D;
        boolean G;
        boolean H;
        long J;
        long Y;
        /* synthetic */ Object Z;
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        Object g;
        Object h;
        Object i;
        Object j;
        Object k;
        Object l;
        Object m;
        Object n;
        Object o;
        Object p;
        Object q;
        Object r;
        int s;
        int t;
        int u;
        boolean v;
        boolean w;
        boolean x;
        boolean y;
        boolean z;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.Z = obj;
            this.A0 |= RecyclerView.UNDEFINED_DURATION;
            return EM1.this.b(null, this);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ DialogEntity e;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ EM1 c;
            final /* synthetic */ DialogEntity d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(EM1 em1, DialogEntity dialogEntity, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = em1;
                this.d = dialogEntity;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                SettingsModule settingsModule = this.c.b;
                AbstractC13042fc3.h(C11458d25.r(this.d.getPeerUid()), "fromUniqueId(...)");
                return AbstractC6392Nk0.a(!settingsModule.H5(r0));
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ EM1 c;
            final /* synthetic */ DialogEntity d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(EM1 em1, DialogEntity dialogEntity, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = em1;
                this.d = dialogEntity;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                EM1 em1 = this.c;
                return AbstractC6392Nk0.a(em1.u(em1.b.b2()).contains(AbstractC6392Nk0.e(this.d.getPeerUid())));
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(DialogEntity dialogEntity, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = dialogEntity;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = EM1.this.new f(this.e, interfaceC20295rm1);
            fVar.c = obj;
            return fVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            return new XV4(AbstractC10533bm0.b(interfaceC20315ro1, null, null, new a(EM1.this, this.e, null), 3, null), AbstractC10533bm0.b(interfaceC20315ro1, null, null, new b(EM1.this, this.e, null), 3, null));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class g extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return EM1.this.f(null, this);
        }
    }

    static final class h extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        /* synthetic */ Object g;
        int i;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= RecyclerView.UNDEFINED_DURATION;
            return EM1.this.c(null, null, 0L, this);
        }
    }

    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ UserNamePlaceHolder d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(UserNamePlaceHolder userNamePlaceHolder, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = userNamePlaceHolder;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return EM1.this.new i(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC11621dJ7 interfaceC11621dJ7 = EM1.this.g;
                long userId = this.d.getUserId();
                this.b = 1;
                obj = interfaceC11621dJ7.a(userId, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C17637nI7 c17637nI7 = (C17637nI7) obj;
            String name = c17637nI7 != null ? c17637nI7.getName() : null;
            return name == null ? "" : name;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public EM1(C24011xt3 c24011xt3, SettingsModule settingsModule, E84 e84, Context context, AbstractC13778go1 abstractC13778go1, int i2, InterfaceC11621dJ7 interfaceC11621dJ7, KM2 km2, KO3.a aVar, QM1 qm1) {
        AbstractC13042fc3.i(c24011xt3, "lastMessageMapper");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(e84, "messagesModule");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC11621dJ7, "userRepository");
        AbstractC13042fc3.i(km2, "groupRepository");
        AbstractC13042fc3.i(aVar, "markWonHandlerFactory");
        AbstractC13042fc3.i(qm1, "contentDescriptionMapper");
        this.a = c24011xt3;
        this.b = settingsModule;
        this.c = e84;
        this.d = context;
        this.e = abstractC13778go1;
        this.f = i2;
        this.g = interfaceC11621dJ7;
        this.h = km2;
        this.i = aVar;
        this.j = qm1;
        this.k = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.CM1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return EM1.s();
            }
        });
        this.l = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.DM1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return EM1.t(this.a);
            }
        });
    }

    private final List A(List list) {
        List<MessagingStruct$MessageId> list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        for (MessagingStruct$MessageId messagingStruct$MessageId : list2) {
            arrayList.add(new Q64(messagingStruct$MessageId.getDate(), messagingStruct$MessageId.getRid()));
        }
        return arrayList;
    }

    private final KO3 n() {
        return (KO3) this.l.getValue();
    }

    private final C24303yO3 o() {
        return (C24303yO3) this.k.getValue();
    }

    private final String p(List list, ExPeerType exPeerType, boolean z) {
        List list2 = list;
        return (list2 == null || list2.isEmpty() || !((exPeerType == ExPeerType.GROUP || exPeerType == ExPeerType.PRIVATE) && !z && C8386Vt0.W5())) ? "" : "❤️";
    }

    private final AbstractC19428qK7 q(ExPeerType exPeerType, ir.nasim.features.mxp.entity.a aVar) {
        if (aVar != null) {
            if (aVar == ir.nasim.features.mxp.entity.a.e) {
                aVar = null;
            }
            if (aVar != null) {
                return new AbstractC19428qK7.e(EnumC23487x03.f);
            }
        }
        int i2 = exPeerType == null ? -1 : b.a[exPeerType.ordinal()];
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? AbstractC19428qK7.f.c : AbstractC19428qK7.a.c : AbstractC19428qK7.b.c : AbstractC19428qK7.c.c : AbstractC19428qK7.d.c;
    }

    private final boolean r(List list, ExPeerType exPeerType) {
        List list2 = list;
        return list2 != null && !list2.isEmpty() && exPeerType == ExPeerType.GROUP && C8386Vt0.U5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C24303yO3 s() {
        C24303yO3.a aVar = new C24303yO3.a();
        Boolean bool = Boolean.TRUE;
        C24303yO3.a aVarM = aVar.l(bool).m(bool);
        Boolean bool2 = Boolean.FALSE;
        return aVarM.e(bool2).h(bool2).g(bool2).c(bool2).i(bool2).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KO3 t(EM1 em1) {
        AbstractC13042fc3.i(em1, "this$0");
        return em1.i.a(em1.o());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List u(String str) {
        if (str == null || AbstractC20762sZ6.n0(str)) {
            return AbstractC10360bX0.m();
        }
        List listN0 = AbstractC20762sZ6.N0(str, new String[]{","}, false, 0, 6, null);
        ArrayList arrayList = new ArrayList();
        Iterator it = listN0.iterator();
        while (it.hasNext()) {
            Long lQ = AbstractC19562qZ6.q(AbstractC20762sZ6.n1((String) it.next()).toString());
            if (lQ != null) {
                arrayList.add(lQ);
            }
        }
        return arrayList;
    }

    private final Object v(long j, ExPeerType exPeerType, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.e, new d(exPeerType, this, j, null), interfaceC20295rm1);
    }

    private final String w(CharSequence charSequence) {
        return AbstractC20762sZ6.n1(new C20644sM5("\\s*\n\\s*").k(charSequence, Separators.SP)).toString();
    }

    private final String x(String str, Map map) {
        Set<Map.Entry> setEntrySet;
        if (map == null || (setEntrySet = map.entrySet()) == null) {
            return str;
        }
        String strM = str;
        for (Map.Entry entry : setEntrySet) {
            strM = AbstractC20153rZ6.M(strM, (String) entry.getKey(), (String) entry.getValue(), false, 4, null);
        }
        return strM == null ? str : strM;
    }

    private final NP1 y(String str) {
        Spanned spannedB = n().k().b(w(str));
        AbstractC13042fc3.h(spannedB, "toMarkdown(...)");
        SpannableString spannableStringValueOf = SpannableString.valueOf(spannedB);
        Object[] spans = spannableStringValueOf.getSpans(0, spannableStringValueOf.length(), ClickableSpan.class);
        AbstractC13042fc3.h(spans, "getSpans(...)");
        for (Object obj : spans) {
            spannableStringValueOf.removeSpan((ClickableSpan) obj);
        }
        Object[] spans2 = spannableStringValueOf.getSpans(0, spannableStringValueOf.length(), UnderlineSpan.class);
        AbstractC13042fc3.h(spans2, "getSpans(...)");
        for (Object obj2 : spans2) {
            spannableStringValueOf.removeSpan((UnderlineSpan) obj2);
        }
        Object[] spans3 = spannableStringValueOf.getSpans(0, spannableStringValueOf.length(), StyleSpan.class);
        AbstractC13042fc3.h(spans3, "getSpans(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj3 : spans3) {
            StyleSpan styleSpan = (StyleSpan) obj3;
            if (styleSpan.getStyle() == 1 || styleSpan.getStyle() == 2 || styleSpan.getStyle() == 3) {
                arrayList.add(obj3);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            spannableStringValueOf.removeSpan((StyleSpan) it.next());
        }
        Object[] spans4 = spannableStringValueOf.getSpans(0, spannableStringValueOf.length(), DZ6.class);
        AbstractC13042fc3.h(spans4, "getSpans(...)");
        for (Object obj4 : spans4) {
            spannableStringValueOf.removeSpan((DZ6) obj4);
        }
        Object[] spans5 = spannableStringValueOf.getSpans(0, spannableStringValueOf.length(), AbstractC10741c72.class);
        AbstractC13042fc3.h(spans5, "getSpans(...)");
        for (Object obj5 : spans5) {
            AbstractC18350oW3.a(obj5);
            spannableStringValueOf.removeSpan(null);
        }
        return new NP1.a(spannableStringValueOf);
    }

    private final ExPeerType z(EnumC10088b35 enumC10088b35) {
        switch (b.c[enumC10088b35.ordinal()]) {
            case 1:
                return ExPeerType.BOT;
            case 2:
                return ExPeerType.GROUP;
            case 3:
                return ExPeerType.CHANNEL;
            case 4:
                return ExPeerType.PRIVATE;
            case 5:
                return ExPeerType.THREAD;
            case 6:
            case 7:
            case 8:
                return ExPeerType.UNKNOWN;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // ir.nasim.BM1
    public AbstractC25195zt3.d a(String str) {
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
        return new AbstractC25195zt3.d(y(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x050a  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x050f  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0518  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0526  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x059c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x059d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0672 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0673  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x06e0  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0702  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0705  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0712  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0725  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0728  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0426 A[Catch: all -> 0x042f, TryCatch #1 {all -> 0x042f, blocks: (B:71:0x0414, B:73:0x0426, B:80:0x0432), top: B:147:0x0414 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x045e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0461  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0464  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x04a1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x04a2  */
    /* JADX WARN: Type inference failed for: r42v2 */
    /* JADX WARN: Type inference failed for: r42v4, types: [ir.nasim.zt3] */
    /* JADX WARN: Type inference failed for: r42v5 */
    /* JADX WARN: Type inference failed for: r51v4, types: [ir.nasim.zt3] */
    /* JADX WARN: Type inference failed for: r52v0, types: [ir.nasim.zt3] */
    @Override // ir.nasim.BM1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(ir.nasim.database.dailogLists.DialogEntity r73, ir.nasim.InterfaceC20295rm1 r74) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1892
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.EM1.b(ir.nasim.database.dailogLists.DialogEntity, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00d1 -> B:37:0x00d4). Please report as a decompilation issue!!! */
    @Override // ir.nasim.BM1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(ir.nasim.database.dailogLists.DialogLastMessage r23, java.lang.String r24, long r25, ir.nasim.InterfaceC20295rm1 r27) {
        /*
            Method dump skipped, instructions count: 546
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.EM1.c(ir.nasim.database.dailogLists.DialogLastMessage, java.lang.String, long, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // ir.nasim.BM1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(long r17, ir.nasim.core.modules.profile.entity.ExPeerType r19, ir.nasim.InterfaceC20295rm1 r20) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r20
            boolean r4 = r3 instanceof ir.nasim.EM1.c
            if (r4 == 0) goto L19
            r4 = r3
            ir.nasim.EM1$c r4 = (ir.nasim.EM1.c) r4
            int r5 = r4.c
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r5 & r6
            if (r7 == 0) goto L19
            int r5 = r5 - r6
            r4.c = r5
            goto L1e
        L19:
            ir.nasim.EM1$c r4 = new ir.nasim.EM1$c
            r4.<init>(r3)
        L1e:
            java.lang.Object r3 = r4.a
            java.lang.Object r5 = ir.nasim.AbstractC13660gc3.e()
            int r6 = r4.c
            r7 = 2
            r8 = 1
            r9 = 0
            if (r6 == 0) goto L3f
            if (r6 == r8) goto L3b
            if (r6 != r7) goto L33
            ir.nasim.AbstractC10685c16.b(r3)
            goto L5e
        L33:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L3b:
            ir.nasim.AbstractC10685c16.b(r3)
            goto L99
        L3f:
            ir.nasim.AbstractC10685c16.b(r3)
            int[] r3 = ir.nasim.EM1.b.a
            int r6 = r19.ordinal()
            r3 = r3[r6]
            switch(r3) {
                case 1: goto L8e;
                case 2: goto L53;
                case 3: goto L53;
                case 4: goto L8e;
                case 5: goto Ld2;
                case 6: goto Ld2;
                default: goto L4d;
            }
        L4d:
            kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
            r1.<init>()
            throw r1
        L53:
            ir.nasim.KM2 r3 = r0.h
            r4.c = r7
            java.lang.Object r3 = r3.l(r1, r4)
            if (r3 != r5) goto L5e
            return r5
        L5e:
            ir.nasim.iL2 r3 = (ir.nasim.C14697iL2) r3
            if (r3 == 0) goto Ld2
            ir.nasim.EM1$a r9 = new ir.nasim.EM1$a
            java.lang.String r11 = r3.G0()
            java.lang.String r1 = "getTitle(...)"
            ir.nasim.AbstractC13042fc3.h(r11, r1)
            ir.nasim.core.modules.profile.entity.Avatar r12 = r3.h0()
            ir.nasim.E25 r1 = ir.nasim.E25.VERIFIED
            ir.nasim.E25 r2 = ir.nasim.E25.LEGAL
            ir.nasim.E25[] r1 = new ir.nasim.E25[]{r1, r2}
            java.util.Set r1 = ir.nasim.AbstractC4129Du6.i(r1)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            ir.nasim.E25 r2 = r3.x0()
            boolean r14 = ir.nasim.ZW0.i0(r1, r2)
            r15 = 0
            r13 = 0
            r10 = r9
            r10.<init>(r11, r12, r13, r14, r15)
            goto Ld2
        L8e:
            ir.nasim.dJ7 r3 = r0.g
            r4.c = r8
            java.lang.Object r3 = r3.a(r1, r4)
            if (r3 != r5) goto L99
            return r5
        L99:
            ir.nasim.nI7 r3 = (ir.nasim.C17637nI7) r3
            if (r3 == 0) goto Ld2
            ir.nasim.EM1$a r9 = new ir.nasim.EM1$a
            java.lang.String r11 = r3.getName()
            java.lang.String r1 = "getName(...)"
            ir.nasim.AbstractC13042fc3.h(r11, r1)
            ir.nasim.core.modules.profile.entity.Avatar r12 = r3.S()
            boolean r13 = r3.r0()
            ir.nasim.E25 r1 = ir.nasim.E25.VERIFIED
            ir.nasim.E25 r2 = ir.nasim.E25.LEGAL
            ir.nasim.E25[] r1 = new ir.nasim.E25[]{r1, r2}
            java.util.Set r1 = ir.nasim.AbstractC4129Du6.i(r1)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            ir.nasim.E25 r2 = r3.e0()
            boolean r14 = ir.nasim.ZW0.i0(r1, r2)
            ir.nasim.Li0 r1 = r3.T()
            boolean r15 = r1.c()
            r10 = r9
            r10.<init>(r11, r12, r13, r14, r15)
        Ld2:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.EM1.d(long, ir.nasim.core.modules.profile.entity.ExPeerType, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.BM1
    public Object e(MessagingStruct$Dialog messagingStruct$Dialog, InterfaceC20295rm1 interfaceC20295rm1) {
        EnumC10088b35 exPeerType = messagingStruct$Dialog.getExInfo().getExPeerType();
        AbstractC13042fc3.h(exPeerType, "getExPeerType(...)");
        C11458d25 c11458d25 = new C11458d25(new ExPeer(z(exPeerType), messagingStruct$Dialog.getPeer().getId()));
        int unreadCount = messagingStruct$Dialog.getUnreadCount();
        long sortDate = messagingStruct$Dialog.getSortDate();
        long rid = messagingStruct$Dialog.getRid();
        long date = messagingStruct$Dialog.getDate();
        boolean z = messagingStruct$Dialog.getState() == EnumC16043kc4.MessageState_READ;
        boolean z2 = messagingStruct$Dialog.getState() == EnumC16043kc4.MessageState_RECEIVED;
        EnumC10088b35 exPeerType2 = messagingStruct$Dialog.getExInfo().getExPeerType();
        AbstractC13042fc3.h(exPeerType2, "getExPeerType(...)");
        ExPeerType exPeerTypeZ = z(exPeerType2);
        long value = messagingStruct$Dialog.getFirstUnreadDate().getValue();
        List<MessagingStruct$MessageId> unreadMentionsList = messagingStruct$Dialog.getUnreadMentionsList();
        AbstractC13042fc3.h(unreadMentionsList, "getUnreadMentionsList(...)");
        List listA = A(unreadMentionsList);
        List<MessagingStruct$MessageId> unreadReactionsList = messagingStruct$Dialog.getUnreadReactionsList();
        AbstractC13042fc3.h(unreadReactionsList, "getUnreadReactionsList(...)");
        return new C18267oN1(c11458d25, unreadCount, sortDate, rid, date, z, z2, exPeerTypeZ, value, listA, A(unreadReactionsList));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // ir.nasim.BM1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(ai.bale.proto.MessagingStruct$Dialog r35, ir.nasim.InterfaceC20295rm1 r36) {
        /*
            Method dump skipped, instructions count: 477
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.EM1.f(ai.bale.proto.MessagingStruct$Dialog, ir.nasim.rm1):java.lang.Object");
    }
}
