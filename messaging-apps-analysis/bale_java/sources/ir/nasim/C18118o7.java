package ir.nasim;

import ai.bale.proto.AdvertisementOuterClass$RequestUpdateClick;
import ai.bale.proto.AdvertisementOuterClass$RequestUpdateView;
import ai.bale.proto.AdvertisementOuterClass$ResponseUpdateClick;
import ai.bale.proto.PeersStruct$ExPeer;
import ai.bale.proto.PeersStruct$GroupOutPeer;
import com.google.protobuf.GeneratedMessageLite;
import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import ir.nasim.InterfaceC10156bA3;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.HashMap;
import java.util.Locale;

/* renamed from: ir.nasim.o7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18118o7 implements InterfaceC17527n7 {
    public static final a g = new a(null);
    public static final int h = 8;
    private final C6287Mz a;
    private final C6409Nm b;
    private final InterfaceC14123hO3 c;
    private final InterfaceC14123hO3 d;
    private final AbstractC13778go1 e;
    private final int f;

    /* renamed from: ir.nasim.o7$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.o7$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ExPeerType.values().length];
            try {
                iArr[ExPeerType.CHANNEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ExPeerType.BOT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.o7$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;
        final /* synthetic */ ExPeer e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, ExPeer exPeer, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
            this.e = exPeer;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C18118o7.this.new c(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C6287Mz c6287Mz = C18118o7.this.a;
                AdvertisementOuterClass$RequestUpdateClick.a aVarNewBuilder = AdvertisementOuterClass$RequestUpdateClick.newBuilder();
                String str = this.d;
                ExPeer exPeer = this.e;
                C18118o7 c18118o7 = C18118o7.this;
                aVarNewBuilder.B(str);
                aVarNewBuilder.A(1);
                if (exPeer != null) {
                    aVarNewBuilder.C((PeersStruct$ExPeer) c18118o7.d.a(exPeer));
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
                GeneratedMessageLite generatedMessageLiteA = aVarNewBuilder.a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                AdvertisementOuterClass$ResponseUpdateClick defaultInstance = AdvertisementOuterClass$ResponseUpdateClick.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.advertisement.v1.Advertisement/UpdateClick", generatedMessageLiteA, defaultInstance);
                this.b = 1;
                obj = InterfaceC16847ly.c(c6287Mz, c22871vx5, 0L, null, this, 6, null);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.o7$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;
        final /* synthetic */ C25238zy e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, C25238zy c25238zy, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
            this.e = c25238zy;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C18118o7.this.new d(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C6287Mz c6287Mz = C18118o7.this.a;
                AdvertisementOuterClass$RequestUpdateView.a aVarNewBuilder = AdvertisementOuterClass$RequestUpdateView.newBuilder();
                String str = this.d;
                C25238zy c25238zy = this.e;
                C18118o7 c18118o7 = C18118o7.this;
                aVarNewBuilder.B(str);
                aVarNewBuilder.A(1);
                if (c25238zy != null) {
                    aVarNewBuilder.C((PeersStruct$GroupOutPeer) c18118o7.c.a(c25238zy));
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
                GeneratedMessageLite generatedMessageLiteA = aVarNewBuilder.a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                AdvertisementOuterClass$ResponseUpdateClick defaultInstance = AdvertisementOuterClass$ResponseUpdateClick.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.advertisement.v1.Advertisement/UpdateView", generatedMessageLiteA, defaultInstance);
                this.b = 1;
                obj = InterfaceC16847ly.c(c6287Mz, c22871vx5, 0L, null, this, 6, null);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C18118o7(C6287Mz c6287Mz, C6409Nm c6409Nm, InterfaceC14123hO3 interfaceC14123hO3, InterfaceC14123hO3 interfaceC14123hO32, AbstractC13778go1 abstractC13778go1, int i) {
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        AbstractC13042fc3.i(c6409Nm, "analyticsRepository");
        AbstractC13042fc3.i(interfaceC14123hO3, "apiGroupOutPeerToStructGroupOutPeerMapper");
        AbstractC13042fc3.i(interfaceC14123hO32, "exPeerToStructExPeerMapper");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = c6287Mz;
        this.b = c6409Nm;
        this.c = interfaceC14123hO3;
        this.d = interfaceC14123hO32;
        this.e = abstractC13778go1;
        this.f = i;
    }

    private final Object p(String str, ExPeer exPeer, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.e, new c(str, exPeer, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    private final Object q(String str, C25238zy c25238zy, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.e, new d(str, c25238zy, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    private final void r(C23564x80 c23564x80, int i) {
        String lowerCase;
        ExPeerType exPeerType;
        String strName;
        XV4 xv4A = AbstractC4616Fw7.a("action_type", Integer.valueOf(i));
        XV4 xv4A2 = AbstractC4616Fw7.a("notif_id", Long.valueOf(c23564x80.g()));
        XV4 xv4A3 = AbstractC4616Fw7.a("url", c23564x80.b());
        ExPeer exPeerC = c23564x80.c().c();
        XV4 xv4A4 = AbstractC4616Fw7.a("peer_id", Integer.valueOf(exPeerC != null ? exPeerC.getPeerId() : 0));
        InterfaceC10156bA3 interfaceC10156bA3C = c23564x80.c();
        if (interfaceC10156bA3C instanceof InterfaceC10156bA3.a) {
            lowerCase = "external_url";
        } else if (interfaceC10156bA3C instanceof C12179eA3) {
            lowerCase = "deep_link";
        } else {
            ExPeer exPeerC2 = interfaceC10156bA3C.c();
            if (exPeerC2 == null || (exPeerType = exPeerC2.getExPeerType()) == null || (strName = exPeerType.name()) == null) {
                lowerCase = null;
            } else {
                lowerCase = strName.toLowerCase(Locale.ROOT);
                AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
            }
        }
        if (lowerCase == null) {
            lowerCase = "";
        }
        this.b.d("c2c_receipt_banner", AbstractC20051rO3.n(xv4A, xv4A2, xv4A3, xv4A4, AbstractC4616Fw7.a("peer_type", lowerCase)));
    }

    @Override // ir.nasim.InterfaceC17527n7
    public Object a(String str, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objP = p(str, null, interfaceC20295rm1);
        return objP == AbstractC14862ic3.e() ? objP : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC17527n7
    public void b(String str, String str2, int i, int i2, Integer num, String str3, int i3, String str4) {
        AbstractC13042fc3.i(str, "adId");
        AbstractC13042fc3.i(str2, "adTitle");
        AbstractC13042fc3.i(str3, "peerType");
        AbstractC13042fc3.i(str4, "linkTitle");
        HashMap map = new HashMap();
        map.put("ad_item_uid", Integer.valueOf(this.f));
        map.put("ad_item_id", str);
        map.put("ad_item_title", str2);
        map.put("tag_1", Integer.valueOf(i));
        map.put("tag_2", Integer.valueOf(i2));
        if (num != null) {
            map.put("peer_id", Integer.valueOf(num.intValue()));
        }
        map.put("peer_type", str3);
        map.put("action_type", Integer.valueOf(i3));
        map.put("link_title", str4);
        map.put("ad_item_provider", "bale");
        map.put("ad_item_state", ConstantDeviceInfo.APP_PLATFORM);
        this.b.d("ad_dialogue_clicked", map);
    }

    @Override // ir.nasim.InterfaceC17527n7
    public void c(String str, int i, int i2, String str2, int i3) {
        AbstractC13042fc3.i(str, "adId");
        AbstractC13042fc3.i(str2, "caption");
        HashMap map = new HashMap();
        map.put("ad_item_id", str);
        map.put("tag_1", Integer.valueOf(i));
        map.put("tag_2", Integer.valueOf(i2));
        map.put("ad_item_title", str2);
        map.put("peer_id", Integer.valueOf(i3));
        map.put("ad_item_state", ConstantDeviceInfo.APP_PLATFORM);
        this.b.d("ad_sponsored_view", map);
    }

    @Override // ir.nasim.InterfaceC17527n7
    public void d(C23564x80 c23564x80) {
        AbstractC13042fc3.i(c23564x80, "bannerAd");
        r(c23564x80, 2);
    }

    @Override // ir.nasim.InterfaceC17527n7
    public void e(C23564x80 c23564x80) {
        AbstractC13042fc3.i(c23564x80, "bannerAd");
        r(c23564x80, 1);
    }

    @Override // ir.nasim.InterfaceC17527n7
    public void f(String str, int i, int i2, String str2, int i3, ExPeerType exPeerType) {
        AbstractC13042fc3.i(str, "adId");
        AbstractC13042fc3.i(str2, "caption");
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        HashMap map = new HashMap();
        map.put("ad_item_id", str);
        map.put("tag_1", Integer.valueOf(i));
        map.put("tag_2", Integer.valueOf(i2));
        map.put("ad_item_title", str2);
        map.put("peer_id", Integer.valueOf(i3));
        int i4 = b.a[exPeerType.ordinal()];
        map.put("peer_type", i4 != 1 ? i4 != 2 ? exPeerType.name() : "bot" : "channel");
        map.put("action_type", 1);
        map.put("ad_item_state", ConstantDeviceInfo.APP_PLATFORM);
        this.b.d("ad_sponsored_action", map);
    }

    @Override // ir.nasim.InterfaceC17527n7
    public void g(int i, String str) {
        AbstractC13042fc3.i(str, "adLink");
        this.b.d("ad_dialogue_banner", AbstractC20051rO3.n(AbstractC4616Fw7.a("notif_id", Integer.valueOf(i)), AbstractC4616Fw7.a("url", str), AbstractC4616Fw7.a("action_type", 1)));
    }

    @Override // ir.nasim.InterfaceC17527n7
    public void h(int i, String str) {
        AbstractC13042fc3.i(str, "adLink");
        this.b.d("ad_dialogue_banner", AbstractC20051rO3.n(AbstractC4616Fw7.a("notif_id", Integer.valueOf(i)), AbstractC4616Fw7.a("url", str), AbstractC4616Fw7.a("action_type", 2)));
    }

    @Override // ir.nasim.InterfaceC17527n7
    public void i(String str, String str2, int i, int i2, Integer num, String str3, int i3, String str4) {
        AbstractC13042fc3.i(str, "adId");
        AbstractC13042fc3.i(str2, "adTitle");
        AbstractC13042fc3.i(str3, "peerType");
        AbstractC13042fc3.i(str4, "linkTitle");
        HashMap map = new HashMap();
        map.put("ad_item_uid", Integer.valueOf(this.f));
        map.put("ad_item_id", str);
        map.put("ad_item_title", str2);
        map.put("tag_1", Integer.valueOf(i));
        map.put("tag_2", Integer.valueOf(i2));
        if (num != null) {
            map.put("peer_id", Integer.valueOf(num.intValue()));
        }
        map.put("peer_type", str3);
        map.put("action_type", Integer.valueOf(i3));
        map.put("link_title", str4);
        map.put("ad_item_provider", "bale");
        map.put("ad_item_state", ConstantDeviceInfo.APP_PLATFORM);
        this.b.d("ad_dialogue_view", map);
    }

    @Override // ir.nasim.InterfaceC17527n7
    public Object j(String str, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objQ = q(str, null, interfaceC20295rm1);
        return objQ == AbstractC14862ic3.e() ? objQ : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC17527n7
    public Object k(String str, C25238zy c25238zy, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objQ = q(str, c25238zy, interfaceC20295rm1);
        return objQ == AbstractC14862ic3.e() ? objQ : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC17527n7
    public Object l(String str, ExPeer exPeer, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objP = p(str, exPeer, interfaceC20295rm1);
        return objP == AbstractC14862ic3.e() ? objP : C19938rB7.a;
    }
}
