package ir.nasim;

import ai.bale.proto.VitrineOuterClass$RequestGetFullVitrine;
import ai.bale.proto.VitrineOuterClass$ResponseGetFullVitrine;
import ai.bale.proto.VitrineOuterClass$VitrineSection;
import ir.nasim.Z06;
import ir.nasim.core.modules.market.model.MarketItem;
import ir.nasim.core.modules.market.model.MarketPost;
import ir.nasim.core.modules.market.model.MarketProductItem;
import ir.nasim.core.modules.market.model.MarketSection;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.jaryan.discover.model.DiscoverSection;
import ir.nasim.jaryan.discover.model.PeerItem;
import ir.nasim.jaryan.discover.model.PeerSection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.qU1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C19512qU1 extends VW7 {
    public static final b m = new b(null);
    public static final int n = 8;
    private static final int o = 1;
    private static final int p = 2;
    private static final int q = 3;
    private static final String r = "banner";
    private static final String s = "market";
    private static final String t = "vitrin";
    private final C6287Mz b;
    private final UG7 c;
    private final EP5 d;
    private final C14837iZ7 e;
    private EnumC17739nU1 f;
    private final Set g;
    private final List h;
    private final int i;
    private final long j;
    private final InterfaceC9336Zm4 k;
    private List l;

    /* renamed from: ir.nasim.qU1$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.qU1$a$a, reason: collision with other inner class name */
        static final class C1479a implements InterfaceC4806Gq2 {
            final /* synthetic */ C19512qU1 a;

            C1479a(C19512qU1 c19512qU1) {
                this.a = c19512qU1;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(C19938rB7 c19938rB7, InterfaceC20295rm1 interfaceC20295rm1) {
                List list = this.a.h;
                C19512qU1 c19512qU1 = this.a;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (System.currentTimeMillis() - ((Number) ((XV4) obj).f()).longValue() >= c19512qU1.i) {
                        arrayList.add(obj);
                    }
                }
                this.a.h.removeAll(arrayList);
                C19512qU1 c19512qU12 = this.a;
                ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((XV4) it.next()).e());
                }
                c19512qU12.l1(AbstractC15401jX0.r1(arrayList2));
                return C19938rB7.a;
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C19512qU1.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2R = AbstractC6459Nq2.r(AbstractC3851Cp7.f(C19512qU1.this.j, 0L, null, null, 12, null));
                C1479a c1479a = new C1479a(C19512qU1.this);
                this.b = 1;
                if (interfaceC4557Fq2R.b(c1479a, this) == objE) {
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
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.qU1$b */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.qU1$c */
    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC17739nU1.values().length];
            try {
                iArr[EnumC17739nU1.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC17739nU1.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC17739nU1.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.qU1$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C19512qU1.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            try {
                Object objK = new KS2().k(C7183Qq.q(EnumC18608ow5.l).getString("discover_sections", ""), DiscoverSection[].class);
                AbstractC13042fc3.h(objK, "fromJson(...)");
                C19512qU1.this.l = AbstractC10242bK.f1((Object[]) objK);
                C19512qU1.g1(C19512qU1.this, null, 1, null);
            } catch (Exception unused) {
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.qU1$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.qU1$e$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ List c;
            final /* synthetic */ C19512qU1 d;
            final /* synthetic */ List e;

            /* renamed from: ir.nasim.qU1$e$a$a, reason: collision with other inner class name */
            static final class C1480a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ HashSet c;
                final /* synthetic */ HashSet d;
                final /* synthetic */ C19512qU1 e;
                final /* synthetic */ HashSet f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1480a(HashSet hashSet, HashSet hashSet2, C19512qU1 c19512qU1, HashSet hashSet3, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = hashSet;
                    this.d = hashSet2;
                    this.e = c19512qU1;
                    this.f = hashSet3;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C1480a(this.c, this.d, this.e, this.f, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    C7183Qq.p().putStringSet("discovers_peer", AbstractC4846Gu6.l(this.c, this.d));
                    this.e.c.w0(this.f);
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1480a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(List list, C19512qU1 c19512qU1, List list2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = list;
                this.d = c19512qU1;
                this.e = list2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objD;
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    Set<String> setL = C7183Qq.q(EnumC18608ow5.l).l("discovers_peer");
                    HashSet hashSet = new HashSet();
                    HashSet hashSet2 = new HashSet();
                    Iterator it = this.c.iterator();
                    while (it.hasNext()) {
                        String string = it.next().toString();
                        if (setL.contains(string)) {
                            hashSet.add(string);
                        } else {
                            hashSet2.add(string);
                        }
                    }
                    HashSet hashSet3 = new HashSet();
                    AbstractC13042fc3.f(setL);
                    for (String str : setL) {
                        if (!hashSet2.contains(str) && !hashSet.contains(str)) {
                            hashSet3.add(str);
                        }
                    }
                    AbstractC10533bm0.d(AbstractC9773aX7.a(this.d), C12366eV1.b(), null, new C1480a(hashSet, hashSet2, this.d, hashSet3, null), 2, null);
                    ArrayList arrayList = new ArrayList();
                    Iterator it2 = hashSet2.iterator();
                    while (it2.hasNext()) {
                        try {
                            arrayList.add(new C25238zy(Integer.parseInt((String) it2.next()), 0L));
                        } catch (Exception unused) {
                        }
                    }
                    C6517Nv5 c6517Nv5U0 = this.d.c.u0(this.e, arrayList, false, true);
                    AbstractC13042fc3.h(c6517Nv5U0, "loadRequiredPeers(...)");
                    this.b = 1;
                    objD = AbstractC6756Ov5.d(c6517Nv5U0, null, this, 1, null);
                    if (objD == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    objD = ((C9475a16) obj).l();
                }
                return C9475a16.a(objD);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C19512qU1.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                VitrineOuterClass$RequestGetFullVitrine defaultInstance = VitrineOuterClass$RequestGetFullVitrine.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                VitrineOuterClass$ResponseGetFullVitrine defaultInstance2 = VitrineOuterClass$ResponseGetFullVitrine.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance2, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.vitrine.v1.Vitrine/GetFullVitrine", defaultInstance, defaultInstance2);
                C6287Mz c6287Mz = C19512qU1.this.b;
                this.b = 1;
                obj = InterfaceC16847ly.c(c6287Mz, c22871vx5, 0L, null, this, 6, null);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    C19512qU1 c19512qU1 = C19512qU1.this;
                    c19512qU1.f1(c19512qU1.f);
                    return C19938rB7.a;
                }
                AbstractC10685c16.b(obj);
            }
            Z06 z06 = (Z06) obj;
            if (z06 instanceof Z06.b) {
                C19512qU1 c19512qU12 = C19512qU1.this;
                List<VitrineOuterClass$VitrineSection> sectionsList = ((VitrineOuterClass$ResponseGetFullVitrine) ((Z06.b) z06).a()).getSectionsList();
                AbstractC13042fc3.h(sectionsList, "getSectionsList(...)");
                C19512qU1 c19512qU13 = C19512qU1.this;
                ArrayList arrayList = new ArrayList();
                for (VitrineOuterClass$VitrineSection vitrineOuterClass$VitrineSection : sectionsList) {
                    C14837iZ7 c14837iZ7 = c19512qU13.e;
                    AbstractC13042fc3.f(vitrineOuterClass$VitrineSection);
                    DiscoverSection discoverSectionB = c14837iZ7.a(vitrineOuterClass$VitrineSection);
                    if (discoverSectionB != null) {
                        arrayList.add(discoverSectionB);
                    }
                }
                c19512qU12.l = arrayList;
                try {
                    String strT = new KS2().t(C19512qU1.this.l);
                    if (strT != null && strT.length() != 0) {
                        C7183Qq.q(EnumC18608ow5.l).putString("discover_sections", strT);
                    }
                } catch (Exception unused) {
                }
                List list = C19512qU1.this.l;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : list) {
                    if (DiscoverSection.INSTANCE.c((DiscoverSection) obj2)) {
                        arrayList2.add(obj2);
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    PeerSection peerSection = ((DiscoverSection) it.next()).getPeerSection();
                    AbstractC13042fc3.f(peerSection);
                    AbstractC13610gX0.D(arrayList3, peerSection.getItems());
                }
                ArrayList arrayList4 = new ArrayList();
                for (Object obj3 : arrayList3) {
                    PeerItem peerItem = (PeerItem) obj3;
                    if (peerItem.getExPeer().getExPeerType() == ExPeerType.PRIVATE || peerItem.getExPeer().getExPeerType() == ExPeerType.BOT) {
                        arrayList4.add(obj3);
                    }
                }
                ArrayList arrayList5 = new ArrayList(AbstractC10976cX0.x(arrayList4, 10));
                Iterator it2 = arrayList4.iterator();
                while (it2.hasNext()) {
                    arrayList5.add(new C18766pD(((PeerItem) it2.next()).getExPeer().getPeerId(), 0L));
                }
                List list2 = C19512qU1.this.l;
                ArrayList arrayList6 = new ArrayList();
                for (Object obj4 : list2) {
                    if (DiscoverSection.INSTANCE.c((DiscoverSection) obj4)) {
                        arrayList6.add(obj4);
                    }
                }
                ArrayList arrayList7 = new ArrayList();
                Iterator it3 = arrayList6.iterator();
                while (it3.hasNext()) {
                    PeerSection peerSection2 = ((DiscoverSection) it3.next()).getPeerSection();
                    AbstractC13042fc3.f(peerSection2);
                    AbstractC13610gX0.D(arrayList7, peerSection2.getItems());
                }
                ArrayList arrayList8 = new ArrayList();
                for (Object obj5 : arrayList7) {
                    PeerItem peerItem2 = (PeerItem) obj5;
                    if (peerItem2.getExPeer().getExPeerType() == ExPeerType.CHANNEL || peerItem2.getExPeer().getExPeerType() == ExPeerType.GROUP) {
                        arrayList8.add(obj5);
                    }
                }
                ArrayList arrayList9 = new ArrayList(AbstractC10976cX0.x(arrayList8, 10));
                Iterator it4 = arrayList8.iterator();
                while (it4.hasNext()) {
                    arrayList9.add(new C25238zy(((PeerItem) it4.next()).getExPeer().getPeerId(), 0L));
                }
                List list3 = C19512qU1.this.l;
                ArrayList arrayList10 = new ArrayList();
                for (Object obj6 : list3) {
                    if (DiscoverSection.INSTANCE.b((DiscoverSection) obj6)) {
                        arrayList10.add(obj6);
                    }
                }
                ArrayList arrayList11 = new ArrayList();
                Iterator it5 = arrayList10.iterator();
                while (it5.hasNext()) {
                    MarketSection marketSection = ((DiscoverSection) it5.next()).getMarketSection();
                    AbstractC13042fc3.f(marketSection);
                    AbstractC13610gX0.D(arrayList11, marketSection.getItems());
                }
                ArrayList arrayList12 = new ArrayList(AbstractC10976cX0.x(arrayList11, 10));
                Iterator it6 = arrayList11.iterator();
                while (it6.hasNext()) {
                    arrayList12.add(AbstractC6392Nk0.d((int) ((MarketItem) it6.next()).getId()));
                }
                List listR0 = AbstractC15401jX0.R0(arrayList12, arrayList9);
                WM3 wm3C = C12366eV1.c();
                a aVar = new a(listR0, C19512qU1.this, arrayList5, null);
                this.b = 2;
                if (AbstractC9323Zl0.g(wm3C, aVar, this) == objE) {
                    return objE;
                }
                C19512qU1 c19512qU14 = C19512qU1.this;
                c19512qU14.f1(c19512qU14.f);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C19512qU1(C6287Mz c6287Mz, UG7 ug7, SettingsModule settingsModule, EP5 ep5, C14837iZ7 c14837iZ7) {
        EnumC17739nU1 enumC17739nU1ValueOf;
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        AbstractC13042fc3.i(ug7, "updateModule");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(ep5, "reportPeerUseCase");
        AbstractC13042fc3.i(c14837iZ7, "vitrineSectionMapper");
        this.b = c6287Mz;
        this.c = ug7;
        this.d = ep5;
        this.e = c14837iZ7;
        this.f = EnumC17739nU1.a;
        this.g = new LinkedHashSet();
        this.h = new ArrayList();
        this.i = 2000;
        this.j = 3000L;
        try {
            enumC17739nU1ValueOf = EnumC17739nU1.valueOf(settingsModule.G1());
        } catch (Exception unused) {
            enumC17739nU1ValueOf = EnumC17739nU1.a;
        }
        this.f = enumC17739nU1ValueOf;
        d1();
        e1();
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new a(null), 3, null);
        this.k = AbstractC12281eL6.a(new C18330oU1(null, false, 3, null));
        this.l = AbstractC10360bX0.m();
    }

    private final long c1(Object obj) {
        int peerId;
        if (!(obj instanceof C80)) {
            if (obj instanceof MarketItem) {
                return ((MarketItem) obj).getId();
            }
            if (obj instanceof C22536vP3) {
                return ((C22536vP3) obj).a().getId();
            }
            if (obj instanceof C9724aS3) {
                Long rId = ((C9724aS3) obj).a().getPost().getRId();
                if (rId != null) {
                    return rId.longValue();
                }
            } else if (obj instanceof MarketProductItem) {
                Long rId2 = ((MarketProductItem) obj).getPost().getRId();
                if (rId2 != null) {
                    return rId2.longValue();
                }
            } else if (obj instanceof PeerItem) {
                peerId = ((PeerItem) obj).getExPeer().getPeerId();
            } else if (obj instanceof C16017kZ7) {
                peerId = ((C16017kZ7) obj).a().getExPeer().getPeerId();
            }
            return 0L;
        }
        peerId = ((C80) obj).a();
        return peerId;
    }

    private final void d1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new d(null), 2, null);
    }

    private final void e1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new e(null), 2, null);
    }

    public static /* synthetic */ void g1(C19512qU1 c19512qU1, EnumC17739nU1 enumC17739nU1, int i, Object obj) {
        if ((i & 1) != 0) {
            enumC17739nU1 = c19512qU1.f;
        }
        c19512qU1.f1(enumC17739nU1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i1(Object obj, XV4 xv4) {
        AbstractC13042fc3.i(obj, "$item");
        AbstractC13042fc3.i(xv4, "it");
        return AbstractC13042fc3.d(xv4.e(), obj);
    }

    private final void j1(String str, int i, int i2, String str2) {
        HashMap map = new HashMap();
        map.put("title", str);
        map.put("peer_id", Integer.valueOf(i));
        map.put("action_type", Integer.valueOf(o));
        map.put("event_type", str2);
        map.put("block_id", Integer.valueOf(i2));
        String lowerCase = "CHANNEL".toLowerCase(Locale.ROOT);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        map.put("peer_type", lowerCase);
        C3343Am.i("flow_discover", map);
    }

    static /* synthetic */ void k1(C19512qU1 c19512qU1, String str, int i, int i2, String str2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            str2 = s;
        }
        c19512qU1.j1(str, i, i2, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l1(Set set) {
        MarketPost marketPost;
        Integer groupId;
        Set set2 = this.g;
        Set set3 = set;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(set3, 10));
        Iterator it = set3.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(c1(it.next())));
        }
        set2.addAll(arrayList);
        for (Object obj : set3) {
            if (obj instanceof C16017kZ7) {
                C16017kZ7 c16017kZ7 = (C16017kZ7) obj;
                j1(c16017kZ7.c(), c16017kZ7.a().getExPeer().getPeerId(), c16017kZ7.b(), t);
            } else {
                if (obj instanceof C22536vP3) {
                    C22536vP3 c22536vP3 = (C22536vP3) obj;
                    String title = c22536vP3.b().getTitle();
                    ArrayList<MarketPost> posts = c22536vP3.a().getPosts();
                    if (posts != null && (marketPost = (MarketPost) AbstractC15401jX0.s0(posts)) != null && (groupId = marketPost.getGroupId()) != null) {
                        iIntValue = groupId.intValue();
                    }
                    k1(this, title, iIntValue, c22536vP3.b().getId(), null, 8, null);
                } else if (obj instanceof C9724aS3) {
                    C9724aS3 c9724aS3 = (C9724aS3) obj;
                    String title2 = c9724aS3.b().getTitle();
                    Integer groupId2 = c9724aS3.a().getPost().getGroupId();
                    k1(this, title2, groupId2 != null ? groupId2.intValue() : 0, c9724aS3.b().getId(), null, 8, null);
                } else if (obj instanceof C80) {
                    j1("", 0, ((C80) obj).a(), r);
                }
            }
        }
    }

    public final InterfaceC10258bL6 b1() {
        return this.k;
    }

    public final void f1(EnumC17739nU1 enumC17739nU1) {
        ArrayList arrayList;
        Object value;
        AbstractC13042fc3.i(enumC17739nU1, "item");
        this.f = enumC17739nU1;
        int i = c.a[enumC17739nU1.ordinal()];
        if (i == 1) {
            List list = this.l;
            arrayList = new ArrayList();
            for (Object obj : list) {
                DiscoverSection discoverSection = (DiscoverSection) obj;
                DiscoverSection.Companion companion = DiscoverSection.INSTANCE;
                if (companion.a(discoverSection) || companion.c(discoverSection) || companion.b(discoverSection)) {
                    arrayList.add(obj);
                }
            }
        } else if (i == 2) {
            List list2 = this.l;
            arrayList = new ArrayList();
            for (Object obj2 : list2) {
                if (DiscoverSection.INSTANCE.b((DiscoverSection) obj2)) {
                    arrayList.add(obj2);
                }
            }
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            List list3 = this.l;
            arrayList = new ArrayList();
            for (Object obj3 : list3) {
                DiscoverSection discoverSection2 = (DiscoverSection) obj3;
                DiscoverSection.Companion companion2 = DiscoverSection.INSTANCE;
                if (companion2.c(discoverSection2) || companion2.a(discoverSection2)) {
                    arrayList.add(obj3);
                }
            }
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.k;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, ((C18330oU1) value).a(arrayList, true)));
    }

    public final void h1(final Object obj) {
        AbstractC13042fc3.i(obj, "item");
        AbstractC13610gX0.K(this.h, new UA2() { // from class: ir.nasim.pU1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj2) {
                return Boolean.valueOf(C19512qU1.i1(obj, (XV4) obj2));
            }
        });
    }

    public final void m1(String str, int i, OP5 op5) {
        AbstractC13042fc3.i(str, "reason");
        AbstractC13042fc3.i(op5, "reportType");
        this.d.b(new ExPeer(ExPeerType.CHANNEL, i), str, op5, P25.c);
    }

    public final void o1(Object obj) {
        AbstractC13042fc3.i(obj, "item");
        if (this.g.contains(Long.valueOf(c1(obj)))) {
            return;
        }
        List list = this.h;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (c1(((XV4) it.next()).e()) == c1(obj)) {
                    return;
                }
            }
        }
        this.h.add(new XV4(obj, Long.valueOf(System.currentTimeMillis())));
    }
}
