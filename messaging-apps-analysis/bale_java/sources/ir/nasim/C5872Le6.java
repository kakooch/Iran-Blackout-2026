package ir.nasim;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.MessagingStruct$Message;
import ai.bale.proto.SharedMedia$RequestLoadMedia;
import ai.bale.proto.SharedMedia$ResponseLoadMedia;
import ai.bale.proto.SharedMediaStruct$MessageMediaResult;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Le6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5872Le6 extends AbstractC6360Ng4 {
    public static final a w = new a(null);
    public static final int x = 8;
    private final C9057Yh4 m;
    private final DB3 n;
    private final DB3 o;
    private final DB3 p;
    private final DB3 q;
    private final DB3 r;
    private final DB3 s;
    private final InterfaceC9173Yu3 t;
    private final InterfaceC9173Yu3 u;
    private final InterfaceC9173Yu3 v;

    /* renamed from: ir.nasim.Le6$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Le6$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[W25.values().length];
            try {
                iArr[W25.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[W25.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[W25.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
            int[] iArr2 = new int[ExPeerType.values().length];
            try {
                iArr2[ExPeerType.CHANNEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ExPeerType.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ExPeerType.PRIVATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ExPeerType.BOT.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[ExPeerType.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[ExPeerType.THREAD.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            b = iArr2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5872Le6(C9057Yh4 c9057Yh4, DB3 db3, DB3 db32, DB3 db33, DB3 db34, DB3 db35, DB3 db36) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        AbstractC13042fc3.i(db3, "recentSearchListEngine");
        AbstractC13042fc3.i(db32, "localSearchListEngine");
        AbstractC13042fc3.i(db33, "channelSearchListEngine");
        AbstractC13042fc3.i(db34, "groupSearchListEngine");
        AbstractC13042fc3.i(db35, "privateSearchListEngine");
        AbstractC13042fc3.i(db36, "botSearchListEngine");
        this.m = c9057Yh4;
        this.n = db3;
        this.o = db32;
        this.p = db33;
        this.q = db34;
        this.r = db35;
        this.s = db36;
        this.t = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Ge6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C5872Le6.i0();
            }
        });
        this.u = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.He6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C5872Le6.k0();
            }
        });
        this.v = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Ie6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C5872Le6.q0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C7559Sf6 i0() {
        return new C7559Sf6();
    }

    private final C18823pJ2 j0(C11458d25 c11458d25, String str, long j, String str2) {
        return new C18823pJ2(c11458d25, XY6.o(str), null, null, Long.valueOf(j), null, null, null, 4, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C7051Qb2 k0() {
        return new C7051Qb2(new C7519Sb2());
    }

    private final C7559Sf6 l0() {
        return (C7559Sf6) this.t.getValue();
    }

    private final C7051Qb2 m0() {
        return (C7051Qb2) this.u.getValue();
    }

    private final C21451tg6 n0() {
        return (C21451tg6) this.v.getValue();
    }

    private final String o0(C25254zz6 c25254zz6) {
        String strD0;
        int i = b.a[c25254zz6.w().s().ordinal()];
        if (i == 1) {
            C17637nI7 c17637nI7 = (C17637nI7) this.m.W().p0().d(c25254zz6.w().getPeerId());
            if (c17637nI7 == null || (strD0 = c17637nI7.d0()) == null) {
                return "";
            }
        } else {
            if (i != 2) {
                if (i == 3) {
                    return "";
                }
                throw new NoWhenBranchMatchedException();
            }
            C14697iL2 c14697iL2 = (C14697iL2) this.m.E().X1().d(c25254zz6.w().getPeerId());
            if (c14697iL2 == null || (strD0 = c14697iL2.v0()) == null) {
                return "";
            }
        }
        return strD0;
    }

    private final C6517Nv5 p0(List list) {
        w0(list);
        C6517Nv5 c6517Nv5L0 = C6517Nv5.l0(C14505i18.a);
        AbstractC13042fc3.h(c6517Nv5L0, "success(...)");
        return c6517Nv5L0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C21451tg6 q0() {
        return new C21451tg6();
    }

    private final void r0(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            C17637nI7 c17637nI7 = (C17637nI7) this.m.W().p0().d(iArr[i]);
            if (c17637nI7 != null) {
                String strD0 = c17637nI7.d0();
                C11458d25 c11458d25E = C11458d25.E(c17637nI7.n0());
                AbstractC13042fc3.h(c11458d25E, "user(...)");
                String name = c17637nI7.getName();
                AbstractC13042fc3.h(name, "getName(...)");
                C18823pJ2 c18823pJ2J0 = j0(c11458d25E, name, 4294967296L + i, strD0);
                arrayList.add(c18823pJ2J0);
                if (!c17637nI7.r0()) {
                    if (c17637nI7.p0()) {
                        arrayList3.add(c18823pJ2J0);
                    } else {
                        arrayList2.add(c18823pJ2J0);
                    }
                }
            }
        }
        this.o.c(arrayList);
        this.r.c(arrayList2);
        this.s.c(arrayList3);
    }

    private final void s0(C11458d25 c11458d25) {
        this.o.b(c11458d25.u());
        this.n.b(c11458d25.u());
        if (c11458d25.s() == W25.b) {
            C14697iL2 c14697iL2 = (C14697iL2) this.m.E().X1().d(c11458d25.getPeerId());
            if (c14697iL2 == null) {
                return;
            }
            if (c14697iL2.q0() == ZN2.GROUP) {
                this.q.b(c11458d25.u());
                return;
            } else {
                this.p.b(c11458d25.u());
                return;
            }
        }
        C17637nI7 c17637nI7 = (C17637nI7) this.m.W().p0().d(c11458d25.getPeerId());
        if (c17637nI7 == null) {
            return;
        }
        if (c17637nI7.p0()) {
            this.s.b(c11458d25.u());
        } else {
            this.r.b(c11458d25.u());
        }
    }

    private final C6517Nv5 t0(final C11458d25 c11458d25, long j, EnumC19631qg6 enumC19631qg6, EnumC7325Rf6 enumC7325Rf6) {
        ExPeerType exPeerTypeA = X25.a(c11458d25);
        if (exPeerTypeA == null) {
            C6517Nv5 c6517Nv5F = C6517Nv5.F(new Exception("Null exPeer"));
            AbstractC13042fc3.h(c6517Nv5F, "failure(...)");
            return c6517Nv5F;
        }
        GeneratedMessageLite generatedMessageLiteA = SharedMedia$RequestLoadMedia.newBuilder().C(m0().a(new ExPeer(exPeerTypeA, c11458d25.getPeerId()))).B((CollectionsStruct$Int64Value) CollectionsStruct$Int64Value.newBuilder().A(j).a()).A(l0().a(enumC7325Rf6)).D(n0().a(enumC19631qg6)).E(20).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        SharedMedia$ResponseLoadMedia defaultInstance = SharedMedia$ResponseLoadMedia.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5H0 = L(new C22871vx5("/bale.shared_media.v1.SharedMediaService/LoadMedia", generatedMessageLiteA, defaultInstance)).h0(new InterfaceC17569nB2() { // from class: ir.nasim.Je6
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C5872Le6.u0(c11458d25, (SharedMedia$ResponseLoadMedia) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H0, "map(...)");
        return c6517Nv5H0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C22372v74 u0(final C11458d25 c11458d25, SharedMedia$ResponseLoadMedia sharedMedia$ResponseLoadMedia) {
        AbstractC13042fc3.i(c11458d25, "$peer");
        AbstractC13042fc3.i(sharedMedia$ResponseLoadMedia, "response");
        return new C22372v74(C17678nN3.r(sharedMedia$ResponseLoadMedia.getMediaResultsList()).f(new InterfaceC17569nB2() { // from class: ir.nasim.Ke6
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C5872Le6.v0(c11458d25, (SharedMediaStruct$MessageMediaResult) obj);
            }
        }), sharedMedia$ResponseLoadMedia.getMediaResultsCount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C18823pJ2 v0(C11458d25 c11458d25, SharedMediaStruct$MessageMediaResult sharedMediaStruct$MessageMediaResult) {
        AbstractC13042fc3.i(c11458d25, "$peer");
        AbstractC13042fc3.i(sharedMediaStruct$MessageMediaResult, "mediaResult");
        long rid = sharedMediaStruct$MessageMediaResult.getRid();
        long date = sharedMediaStruct$MessageMediaResult.getDate();
        int senderId = sharedMediaStruct$MessageMediaResult.getSenderId();
        C18732p92 c18732p92 = C18732p92.a;
        MessagingStruct$Message content = sharedMediaStruct$MessageMediaResult.getContent();
        AbstractC13042fc3.h(content, "getContent(...)");
        return new C18823pJ2(c11458d25, rid, date, senderId, AbstractC17457n0.h(c18732p92.A0(content)));
    }

    private final void w0(List list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C25254zz6 c25254zz6 = (C25254zz6) it.next();
            if (c25254zz6 != null) {
                String strO0 = o0(c25254zz6);
                C11458d25 c11458d25W = c25254zz6.w();
                AbstractC13042fc3.h(c11458d25W, "getPeer(...)");
                String strY = c25254zz6.y();
                AbstractC13042fc3.h(strY, "getTitle(...)");
                C18823pJ2 c18823pJ2J0 = j0(c11458d25W, strY, c25254zz6.h(), strO0);
                arrayList.add(c18823pJ2J0);
                ExPeerType exPeerType = c25254zz6.getExPeerType();
                switch (exPeerType == null ? -1 : b.b[exPeerType.ordinal()]) {
                    case -1:
                    case 5:
                    case 6:
                        break;
                    case 0:
                    default:
                        throw new NoWhenBranchMatchedException();
                    case 1:
                        arrayList2.add(c18823pJ2J0);
                        break;
                    case 2:
                        arrayList3.add(c18823pJ2J0);
                        break;
                    case 3:
                        C17637nI7 c17637nI7 = (C17637nI7) this.m.W().p0().d(c25254zz6.w().getPeerId());
                        if (c17637nI7 != null && !c17637nI7.r0()) {
                            arrayList4.add(c18823pJ2J0);
                            break;
                        } else {
                            break;
                        }
                        break;
                    case 4:
                        C17637nI7 c17637nI72 = (C17637nI7) this.m.W().p0().d(c25254zz6.w().getPeerId());
                        if (c17637nI72 != null && !c17637nI72.r0()) {
                            arrayList5.add(c18823pJ2J0);
                            break;
                        } else {
                            break;
                        }
                        break;
                }
            }
        }
        this.o.c(arrayList);
        this.p.c(arrayList2);
        this.q.c(arrayList3);
        this.r.c(arrayList4);
        this.s.c(arrayList5);
    }

    @Override // ir.nasim.AbstractC17647nK
    public C6517Nv5 G(Object obj) {
        AbstractC13042fc3.i(obj, DialogEntity.COLUMN_MESSAGE);
        if (obj instanceof C23294wg6) {
            C23294wg6 c23294wg6 = (C23294wg6) obj;
            return t0(c23294wg6.d(), c23294wg6.b(), c23294wg6.c(), c23294wg6.a());
        }
        if (obj instanceof C13376g73) {
            return p0(((C13376g73) obj).a());
        }
        C6517Nv5 c6517Nv5G = super.G(obj);
        AbstractC13042fc3.h(c6517Nv5G, "onAsk(...)");
        return c6517Nv5G;
    }

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) throws Exception {
        AbstractC13042fc3.i(obj, DialogEntity.COLUMN_MESSAGE);
        if (obj instanceof C9653aK4) {
            w0(((C9653aK4) obj).a());
            return;
        }
        if (obj instanceof C10238bJ4) {
            r0(((C10238bJ4) obj).a());
        } else if (obj instanceof KJ4) {
            s0(((KJ4) obj).a());
        } else {
            super.m(obj);
        }
    }
}
