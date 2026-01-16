package ir.nasim.story.repository;

import ai.bale.proto.FilesStruct$FileLocation;
import ai.bale.proto.PeersStruct$ExPeer;
import ai.bale.proto.StoryStruct$BotStory;
import ai.bale.proto.StoryStruct$ChannelStory;
import ai.bale.proto.StoryStruct$ExPeerPopularity;
import ai.bale.proto.StoryStruct$MediaStory;
import ai.bale.proto.StoryStruct$Story;
import ai.bale.proto.StoryStruct$TextStory;
import ai.bale.proto.StoryStruct$UserPrivacyConfig;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.gson.reflect.TypeToken;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC10976cX0;
import ir.nasim.AbstractC12281eL6;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.AbstractC22163um1;
import ir.nasim.AbstractC24369yV6;
import ir.nasim.AbstractC6459Nq2;
import ir.nasim.AbstractC6756Ov5;
import ir.nasim.C10431bb8;
import ir.nasim.C11692dR6;
import ir.nasim.C12366eV1;
import ir.nasim.C14189hV6;
import ir.nasim.C15225jD4;
import ir.nasim.C15344jQ6;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C21670tw;
import ir.nasim.C23144wQ6;
import ir.nasim.C25238zy;
import ir.nasim.C6260Mw;
import ir.nasim.C6517Nv5;
import ir.nasim.C9475a16;
import ir.nasim.ED1;
import ir.nasim.EnumC10088b35;
import ir.nasim.EnumC23779xV6;
import ir.nasim.HH5;
import ir.nasim.IM5;
import ir.nasim.InterfaceC10258bL6;
import ir.nasim.InterfaceC10891cN5;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC22036uZ3;
import ir.nasim.InterfaceC3570Bk5;
import ir.nasim.InterfaceC4806Gq2;
import ir.nasim.InterfaceC9336Zm4;
import ir.nasim.KM2;
import ir.nasim.KS2;
import ir.nasim.MC;
import ir.nasim.QQ6;
import ir.nasim.RC;
import ir.nasim.UG7;
import ir.nasim.VP6;
import ir.nasim.XV4;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.data.model.story.CachedVideos;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes7.dex */
public final class StoryRepository {
    public static final a r = new a(null);
    public static final int s = 8;
    private final VP6 a;
    private final SettingsModule b;
    private final UG7 c;
    private final InterfaceC3570Bk5 d;
    private final KM2 e;
    private final C6260Mw.a f;
    private final C21670tw g;
    private final MC h;
    private final RC i;
    private final HH5 j;
    private final Cache k;
    private final InterfaceC9336Zm4 l;
    private final InterfaceC10258bL6 m;
    private final InterfaceC9336Zm4 n;
    private final InterfaceC10258bL6 o;
    private final InterfaceC9336Zm4 p;
    private final InterfaceC10258bL6 q;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC23779xV6.values().length];
            try {
                iArr[EnumC23779xV6.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC23779xV6.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC23779xV6.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC23779xV6.f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnumC23779xV6.e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EnumC23779xV6.a.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            a = iArr;
        }
    }

    static final class c extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return StoryRepository.this.u(null, this);
        }
    }

    static final class d extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return StoryRepository.this.w(null, this);
        }
    }

    static final class e extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return StoryRepository.this.A(null, this);
        }
    }

    static final class f extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return StoryRepository.this.F(null, false, this);
        }
    }

    static final class g extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return StoryRepository.this.H(this);
        }
    }

    static final class h extends AbstractC22163um1 {
        Object a;
        int b;
        /* synthetic */ Object c;
        int e;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return StoryRepository.this.L(0, this);
        }
    }

    static final class i extends AbstractC22163um1 {
        Object a;
        long b;
        /* synthetic */ Object c;
        int e;

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return StoryRepository.this.R(null, this);
        }
    }

    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new j(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C15225jD4.b().c(C15225jD4.x, new Object[0]);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class k extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objT = StoryRepository.this.T(null, this);
            return objT == AbstractC14862ic3.e() ? objT : C9475a16.a(objT);
        }
    }

    static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return StoryRepository.this.new l(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objD;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                UG7 ug7 = StoryRepository.this.c;
                ArrayList arrayList = new ArrayList();
                List list = this.d;
                ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new C25238zy(((Number) it.next()).intValue(), 0L));
                }
                C6517Nv5 c6517Nv5S0 = ug7.s0(arrayList, arrayList2);
                AbstractC13042fc3.h(c6517Nv5S0, "loadRequiredPeers(...)");
                this.b = 1;
                objD = AbstractC6756Ov5.d(c6517Nv5S0, null, this, 1, null);
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
            return ((l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        private /* synthetic */ Object e;
        final /* synthetic */ PeersStruct$ExPeer g;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            Object b;
            int c;
            private /* synthetic */ Object d;
            final /* synthetic */ List e;
            final /* synthetic */ StoryRepository f;

            /* renamed from: ir.nasim.story.repository.StoryRepository$m$a$a, reason: collision with other inner class name */
            static final class C1546a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ StoryRepository c;
                final /* synthetic */ int d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1546a(StoryRepository storyRepository, int i, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = storyRepository;
                    this.d = i;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C1546a(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        KM2 km2 = this.c.e;
                        long j = this.d;
                        this.b = 1;
                        obj = km2.l(j, this);
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
                    return ((C1546a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(List list, StoryRepository storyRepository, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.e = list;
                this.f = storyRepository;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.e, this.f, interfaceC20295rm1);
                aVar.d = obj;
                return aVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x006d  */
            /* JADX WARN: Removed duplicated region for block: B:20:0x0084  */
            /* JADX WARN: Removed duplicated region for block: B:21:0x0088  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x007d -> B:18:0x0080). Please report as a decompilation issue!!! */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r12) {
                /*
                    r11 = this;
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r11.c
                    r2 = 1
                    if (r1 == 0) goto L1f
                    if (r1 != r2) goto L17
                    java.lang.Object r1 = r11.b
                    java.util.Iterator r1 = (java.util.Iterator) r1
                    java.lang.Object r3 = r11.d
                    java.util.Collection r3 = (java.util.Collection) r3
                    ir.nasim.AbstractC10685c16.b(r12)
                    goto L80
                L17:
                    java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r12.<init>(r0)
                    throw r12
                L1f:
                    ir.nasim.AbstractC10685c16.b(r12)
                    java.lang.Object r12 = r11.d
                    ir.nasim.ro1 r12 = (ir.nasim.InterfaceC20315ro1) r12
                    java.util.List r1 = r11.e
                    java.lang.Iterable r1 = (java.lang.Iterable) r1
                    ir.nasim.story.repository.StoryRepository r9 = r11.f
                    java.util.ArrayList r10 = new java.util.ArrayList
                    r3 = 10
                    int r3 = ir.nasim.ZW0.x(r1, r3)
                    r10.<init>(r3)
                    java.util.Iterator r1 = r1.iterator()
                L3b:
                    boolean r3 = r1.hasNext()
                    if (r3 == 0) goto L5d
                    java.lang.Object r3 = r1.next()
                    java.lang.Number r3 = (java.lang.Number) r3
                    int r3 = r3.intValue()
                    ir.nasim.story.repository.StoryRepository$m$a$a r6 = new ir.nasim.story.repository.StoryRepository$m$a$a
                    r4 = 0
                    r6.<init>(r9, r3, r4)
                    r7 = 3
                    r8 = 0
                    r5 = 0
                    r3 = r12
                    ir.nasim.zG1 r3 = ir.nasim.AbstractC9323Zl0.b(r3, r4, r5, r6, r7, r8)
                    r10.add(r3)
                    goto L3b
                L5d:
                    java.util.ArrayList r12 = new java.util.ArrayList
                    r12.<init>()
                    java.util.Iterator r1 = r10.iterator()
                    r3 = r12
                L67:
                    boolean r12 = r1.hasNext()
                    if (r12 == 0) goto L88
                    java.lang.Object r12 = r1.next()
                    ir.nasim.zG1 r12 = (ir.nasim.InterfaceC24823zG1) r12
                    r11.d = r3
                    r11.b = r1
                    r11.c = r2
                    java.lang.Object r12 = r12.y(r11)
                    if (r12 != r0) goto L80
                    return r0
                L80:
                    ir.nasim.iL2 r12 = (ir.nasim.C14697iL2) r12
                    if (r12 == 0) goto L67
                    r3.add(r12)
                    goto L67
                L88:
                    java.util.List r3 = (java.util.List) r3
                    return r3
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.story.repository.StoryRepository.m.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(PeersStruct$ExPeer peersStruct$ExPeer, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.g = peersStruct$ExPeer;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            m mVar = StoryRepository.this.new m(this.g, interfaceC20295rm1);
            mVar.e = obj;
            return mVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0075 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00c3 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00c4  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00cd  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00e0  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00f1  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                Method dump skipped, instructions count: 292
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.story.repository.StoryRepository.m.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((m) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class n extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;

        n(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                String message = ((Throwable) this.d).getMessage();
                if (message == null) {
                    message = "Unknown error";
                }
                IM5.a aVar = new IM5.a(message);
                this.c = null;
                this.b = 1;
                if (interfaceC4806Gq2.a(aVar, this) == objE) {
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

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Throwable th, InterfaceC20295rm1 interfaceC20295rm1) {
            n nVar = new n(interfaceC20295rm1);
            nVar.c = interfaceC4806Gq2;
            nVar.d = th;
            return nVar.invokeSuspend(C19938rB7.a);
        }
    }

    public StoryRepository(VP6 vp6, SettingsModule settingsModule, UG7 ug7, InterfaceC3570Bk5 interfaceC3570Bk5, KM2 km2, C6260Mw.a aVar, C21670tw c21670tw, MC mc, RC rc, HH5 hh5, Cache cache) {
        AbstractC13042fc3.i(vp6, "storyApi");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(ug7, "updatesModule");
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferences");
        AbstractC13042fc3.i(km2, "groupRepository");
        AbstractC13042fc3.i(aVar, "apiChannelStoryToStoryItemMapper");
        AbstractC13042fc3.i(c21670tw, "apiBotStoryToStoryItemMapper");
        AbstractC13042fc3.i(mc, "apiStoryToStoryItemMapper");
        AbstractC13042fc3.i(rc, "apiTagToTagMapper");
        AbstractC13042fc3.i(hh5, "reactionRepository");
        AbstractC13042fc3.i(cache, "cache");
        this.a = vp6;
        this.b = settingsModule;
        this.c = ug7;
        this.d = interfaceC3570Bk5;
        this.e = km2;
        this.f = aVar;
        this.g = c21670tw;
        this.h = mc;
        this.i = rc;
        this.j = hh5;
        this.k = cache;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(null);
        this.l = interfaceC9336Zm4A;
        this.m = interfaceC9336Zm4A;
        InterfaceC9336Zm4 interfaceC9336Zm4A2 = AbstractC12281eL6.a(InterfaceC10891cN5.b.a);
        this.n = interfaceC9336Zm4A2;
        this.o = interfaceC9336Zm4A2;
        InterfaceC9336Zm4 interfaceC9336Zm4A3 = AbstractC12281eL6.a(InterfaceC22036uZ3.b.a);
        this.p = interfaceC9336Zm4A3;
        this.q = AbstractC6459Nq2.c(interfaceC9336Zm4A3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object A(java.util.Map r8, ir.nasim.InterfaceC20295rm1 r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof ir.nasim.story.repository.StoryRepository.e
            if (r0 == 0) goto L13
            r0 = r9
            ir.nasim.story.repository.StoryRepository$e r0 = (ir.nasim.story.repository.StoryRepository.e) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.story.repository.StoryRepository$e r0 = new ir.nasim.story.repository.StoryRepository$e
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L48
            if (r2 == r5) goto L3c
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            ir.nasim.AbstractC10685c16.b(r9)
            goto Ld3
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L38:
            ir.nasim.AbstractC10685c16.b(r9)
            goto L9f
        L3c:
            java.lang.Object r8 = r0.b
            java.util.Map r8 = (java.util.Map) r8
            java.lang.Object r2 = r0.a
            ir.nasim.story.repository.StoryRepository r2 = (ir.nasim.story.repository.StoryRepository) r2
            ir.nasim.AbstractC10685c16.b(r9)
            goto L5b
        L48:
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.VP6 r9 = r7.a
            r0.a = r7
            r0.b = r8
            r0.e = r5
            java.lang.Object r9 = r9.b(r0)
            if (r9 != r1) goto L5a
            return r1
        L5a:
            r2 = r7
        L5b:
            ir.nasim.Z06 r9 = (ir.nasim.Z06) r9
            boolean r5 = r9 instanceof ir.nasim.Z06.b
            r6 = 0
            if (r5 == 0) goto La2
            ir.nasim.Z06$b r9 = (ir.nasim.Z06.b) r9
            com.google.protobuf.P r3 = r9.a()
            ai.bale.proto.StoryOuterClass$ResponseGetChannelStories r3 = (ai.bale.proto.StoryOuterClass$ResponseGetChannelStories) r3
            java.util.List r3 = r3.getResultList()
            java.lang.String r5 = "getResultList(...)"
            ir.nasim.AbstractC13042fc3.h(r3, r5)
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.List r3 = ir.nasim.ZW0.n0(r3)
            com.google.protobuf.P r9 = r9.a()
            ai.bale.proto.StoryOuterClass$ResponseGetChannelStories r9 = (ai.bale.proto.StoryOuterClass$ResponseGetChannelStories) r9
            java.util.List r9 = r9.getPopularityListList()
            java.lang.String r5 = "getPopularityListList(...)"
            ir.nasim.AbstractC13042fc3.h(r9, r5)
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.List r9 = ir.nasim.ZW0.n0(r9)
            java.util.Map r8 = r2.n(r8, r3, r9)
            r0.a = r6
            r0.b = r6
            r0.e = r4
            java.lang.Object r8 = r2.w(r8, r0)
            if (r8 != r1) goto L9f
            return r1
        L9f:
            ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
            return r8
        La2:
            boolean r4 = r9 instanceof ir.nasim.Z06.a
            if (r4 == 0) goto Ld6
            ir.nasim.Z06$a r9 = (ir.nasim.Z06.a) r9
            ir.nasim.core.network.RpcException r9 = r9.a()
            java.lang.String r9 = r9.getIr.nasim.database.dailogLists.DialogEntity.COLUMN_MESSAGE java.lang.String()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "getChannelStories error "
            r4.append(r5)
            r4.append(r9)
            java.lang.String r9 = r4.toString()
            java.lang.String r4 = "story"
            ir.nasim.C19406qI3.b(r4, r9)
            r0.a = r6
            r0.b = r6
            r0.e = r3
            java.lang.Object r8 = r2.w(r8, r0)
            if (r8 != r1) goto Ld3
            return r1
        Ld3:
            ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
            return r8
        Ld6:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.story.repository.StoryRepository.A(java.util.Map, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x011d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object F(java.util.Map r13, boolean r14, ir.nasim.InterfaceC20295rm1 r15) {
        /*
            Method dump skipped, instructions count: 385
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.story.repository.StoryRepository.F(java.util.Map, boolean, ir.nasim.rm1):java.lang.Object");
    }

    private final List G() {
        try {
            String string = this.d.getString("PROPERTIES_CACHED_KEYS", null);
            if (string == null) {
                return new ArrayList();
            }
            Object objL = new KS2().l(string, new TypeToken<List<? extends CachedVideos>>() { // from class: ir.nasim.story.repository.StoryRepository$getStoredCachedKeys$data$type$1
            }.d());
            AbstractC13042fc3.f(objL);
            return (List) objL;
        } catch (Exception e2) {
            C19406qI3.b("story", "getStoredCachedKeys error:" + e2.getMessage());
            return new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object L(int r9, ir.nasim.InterfaceC20295rm1 r10) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.story.repository.StoryRepository.L(int, ir.nasim.rm1):java.lang.Object");
    }

    static /* synthetic */ Object M(StoryRepository storyRepository, int i2, InterfaceC20295rm1 interfaceC20295rm1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        return storyRepository.L(i2, interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object R(java.util.Map r12, ir.nasim.InterfaceC20295rm1 r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof ir.nasim.story.repository.StoryRepository.i
            if (r0 == 0) goto L13
            r0 = r13
            ir.nasim.story.repository.StoryRepository$i r0 = (ir.nasim.story.repository.StoryRepository.i) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.story.repository.StoryRepository$i r0 = new ir.nasim.story.repository.StoryRepository$i
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            java.lang.String r3 = "STORY_LAST_VISITED_PREFERENCE"
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 != r4) goto L32
            long r1 = r0.b
            java.lang.Object r12 = r0.a
            ir.nasim.story.repository.StoryRepository r12 = (ir.nasim.story.repository.StoryRepository) r12
            ir.nasim.AbstractC10685c16.b(r13)
            goto Ldf
        L32:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L3a:
            ir.nasim.AbstractC10685c16.b(r13)
            java.util.LinkedHashMap r13 = new java.util.LinkedHashMap
            r13.<init>()
            java.util.Set r12 = r12.entrySet()
            java.util.Iterator r12 = r12.iterator()
        L4a:
            boolean r2 = r12.hasNext()
            if (r2 == 0) goto L71
            java.lang.Object r2 = r12.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r5 = r2.getKey()
            ir.nasim.dR6 r5 = (ir.nasim.C11692dR6) r5
            ir.nasim.xV6 r5 = r5.c()
            ir.nasim.xV6 r6 = ir.nasim.EnumC23779xV6.e
            if (r5 != r6) goto L65
            goto L4a
        L65:
            java.lang.Object r5 = r2.getKey()
            java.lang.Object r2 = r2.getValue()
            r13.put(r5, r2)
            goto L4a
        L71:
            java.util.Collection r12 = r13.values()
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.List r12 = ir.nasim.ZW0.z(r12)
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.Iterator r12 = r12.iterator()
            boolean r13 = r12.hasNext()
            r2 = 0
            if (r13 != 0) goto L8a
            r13 = r2
            goto Lb3
        L8a:
            java.lang.Object r13 = r12.next()
            boolean r5 = r12.hasNext()
            if (r5 != 0) goto L95
            goto Lb3
        L95:
            r5 = r13
            ir.nasim.QQ6 r5 = (ir.nasim.QQ6) r5
            long r5 = r5.f()
        L9c:
            java.lang.Object r7 = r12.next()
            r8 = r7
            ir.nasim.QQ6 r8 = (ir.nasim.QQ6) r8
            long r8 = r8.f()
            int r10 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r10 >= 0) goto Lad
            r13 = r7
            r5 = r8
        Lad:
            boolean r7 = r12.hasNext()
            if (r7 != 0) goto L9c
        Lb3:
            ir.nasim.QQ6 r13 = (ir.nasim.QQ6) r13
            if (r13 == 0) goto Le7
            long r12 = r13.f()
            ir.nasim.Bk5 r5 = r11.d
            r6 = 0
            long r5 = r5.getLong(r3, r6)
            int r5 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r5 <= 0) goto Le4
            ir.nasim.WM3 r5 = ir.nasim.C12366eV1.c()
            ir.nasim.story.repository.StoryRepository$j r6 = new ir.nasim.story.repository.StoryRepository$j
            r6.<init>(r2)
            r0.a = r11
            r0.b = r12
            r0.e = r4
            java.lang.Object r0 = ir.nasim.AbstractC9323Zl0.g(r5, r6, r0)
            if (r0 != r1) goto Ldd
            return r1
        Ldd:
            r1 = r12
            r12 = r11
        Ldf:
            ir.nasim.Bk5 r12 = r12.d
            r12.putLong(r3, r1)
        Le4:
            ir.nasim.rB7 r12 = ir.nasim.C19938rB7.a
            return r12
        Le7:
            ir.nasim.rB7 r12 = ir.nasim.C19938rB7.a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.story.repository.StoryRepository.R(java.util.Map, ir.nasim.rm1):java.lang.Object");
    }

    private final void S(Map map) {
        Iterator it = map.entrySet().iterator();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (it.hasNext()) {
            switch (b.a[((C11692dR6) ((Map.Entry) it.next()).getKey()).c().ordinal()]) {
                case 1:
                    i2++;
                    break;
                case 2:
                    i3++;
                    break;
                case 3:
                    i4++;
                    break;
                case 4:
                    i5++;
                    break;
                case 5:
                case 6:
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        C23144wQ6.a.h(i2, i3, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object T(java.util.List r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.story.repository.StoryRepository.k
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.story.repository.StoryRepository$k r0 = (ir.nasim.story.repository.StoryRepository.k) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.story.repository.StoryRepository$k r0 = new ir.nasim.story.repository.StoryRepository$k
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r7)
            goto L47
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.WM3 r7 = ir.nasim.C12366eV1.c()
            ir.nasim.story.repository.StoryRepository$l r2 = new ir.nasim.story.repository.StoryRepository$l
            r4 = 0
            r2.<init>(r6, r4)
            r0.c = r3
            java.lang.Object r7 = ir.nasim.AbstractC9323Zl0.g(r7, r2, r0)
            if (r7 != r1) goto L47
            return r1
        L47:
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            java.lang.Object r6 = r7.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.story.repository.StoryRepository.T(java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    private final Map k(Map map, List list, List list2) {
        XV4 xv4;
        Object next;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            Integer numValueOf = Integer.valueOf(((StoryStruct$BotStory) obj).getExPeer().getId());
            Object arrayList = linkedHashMap.get(numValueOf);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(numValueOf, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Iterable iterable = (Iterable) entry.getValue();
            ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(iterable, 10));
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList3.add(this.g.a((StoryStruct$BotStory) it.next()));
            }
            Iterator it2 = list2.iterator();
            while (true) {
                xv4 = null;
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                StoryStruct$ExPeerPopularity storyStruct$ExPeerPopularity = (StoryStruct$ExPeerPopularity) next;
                if (storyStruct$ExPeerPopularity.getExPeer().getId() == ((Number) entry.getKey()).intValue()) {
                    C11692dR6 c11692dR6C = AbstractC24369yV6.c((QQ6) AbstractC15401jX0.q0(arrayList3));
                    PeersStruct$ExPeer exPeer = storyStruct$ExPeerPopularity.getExPeer();
                    AbstractC13042fc3.h(exPeer, "getExPeer(...)");
                    if (AbstractC24369yV6.d(c11692dR6C, exPeer)) {
                        break;
                    }
                }
            }
            StoryStruct$ExPeerPopularity storyStruct$ExPeerPopularity2 = (StoryStruct$ExPeerPopularity) next;
            if (storyStruct$ExPeerPopularity2 != null) {
                int iIntValue = ((Number) entry.getKey()).intValue();
                EnumC10088b35 type = storyStruct$ExPeerPopularity2.getExPeer().getType();
                AbstractC13042fc3.h(type, "getType(...)");
                xv4 = new XV4(new C11692dR6(iIntValue, AbstractC24369yV6.b(type), Float.valueOf(storyStruct$ExPeerPopularity2.getPopularity())), arrayList3);
            }
            if (xv4 != null) {
                arrayList2.add(xv4);
            }
        }
        return AbstractC20051rO3.s(map, arrayList2);
    }

    private final Map n(Map map, List list, List list2) {
        XV4 xv4;
        Object next;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            Integer numValueOf = Integer.valueOf(((StoryStruct$ChannelStory) obj).getExPeer().getId());
            Object arrayList = linkedHashMap.get(numValueOf);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(numValueOf, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Iterable iterable = (Iterable) entry.getValue();
            ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(iterable, 10));
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList3.add(this.f.a(false).a((StoryStruct$ChannelStory) it.next()));
            }
            Iterator it2 = list2.iterator();
            while (true) {
                xv4 = null;
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                StoryStruct$ExPeerPopularity storyStruct$ExPeerPopularity = (StoryStruct$ExPeerPopularity) next;
                if (storyStruct$ExPeerPopularity.getExPeer().getId() == ((Number) entry.getKey()).intValue()) {
                    C11692dR6 c11692dR6C = AbstractC24369yV6.c((QQ6) AbstractC15401jX0.q0(arrayList3));
                    PeersStruct$ExPeer exPeer = storyStruct$ExPeerPopularity.getExPeer();
                    AbstractC13042fc3.h(exPeer, "getExPeer(...)");
                    if (AbstractC24369yV6.d(c11692dR6C, exPeer)) {
                        break;
                    }
                }
            }
            StoryStruct$ExPeerPopularity storyStruct$ExPeerPopularity2 = (StoryStruct$ExPeerPopularity) next;
            if (storyStruct$ExPeerPopularity2 != null) {
                int iIntValue = ((Number) entry.getKey()).intValue();
                EnumC10088b35 type = storyStruct$ExPeerPopularity2.getExPeer().getType();
                AbstractC13042fc3.h(type, "getType(...)");
                xv4 = new XV4(new C11692dR6(iIntValue, AbstractC24369yV6.b(type), Float.valueOf(storyStruct$ExPeerPopularity2.getPopularity())), arrayList3);
            }
            if (xv4 != null) {
                arrayList2.add(xv4);
            }
        }
        return AbstractC20051rO3.s(map, arrayList2);
    }

    private final Map p(Map map, List list, List list2) {
        Map mapA = AbstractC20051rO3.A(map);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            Integer numValueOf = Integer.valueOf(((StoryStruct$ChannelStory) obj).getOwnerUserId());
            Object arrayList = linkedHashMap.get(numValueOf);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(numValueOf, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        XV4 xv4V = v(645784619, linkedHashMap, list2);
        if (xv4V != null) {
            mapA.put(xv4V.e(), xv4V.f());
        }
        XV4 xv4V2 = v(178536948, linkedHashMap, list2);
        if (xv4V2 != null) {
            mapA.put(xv4V2.e(), xv4V2.f());
        }
        return mapA;
    }

    private final Map q(Map map, List list, List list2) {
        XV4 xv4;
        Object next;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            Integer numValueOf = Integer.valueOf(((StoryStruct$Story) obj).getOwnerUserId());
            Object arrayList = linkedHashMap.get(numValueOf);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(numValueOf, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Iterator it = list2.iterator();
            while (true) {
                xv4 = null;
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((StoryStruct$ExPeerPopularity) next).getExPeer().getId() == ((Number) entry.getKey()).intValue()) {
                    break;
                }
            }
            StoryStruct$ExPeerPopularity storyStruct$ExPeerPopularity = (StoryStruct$ExPeerPopularity) next;
            if (storyStruct$ExPeerPopularity != null) {
                int iIntValue = ((Number) entry.getKey()).intValue();
                EnumC10088b35 type = storyStruct$ExPeerPopularity.getExPeer().getType();
                AbstractC13042fc3.h(type, "getType(...)");
                C11692dR6 c11692dR6 = new C11692dR6(iIntValue, AbstractC24369yV6.b(type), Float.valueOf(storyStruct$ExPeerPopularity.getPopularity()));
                Iterable iterable = (Iterable) entry.getValue();
                ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(iterable, 10));
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    QQ6 qq6A = this.h.a((StoryStruct$Story) it2.next());
                    qq6A.H(storyStruct$ExPeerPopularity.getExPeer());
                    arrayList3.add(qq6A);
                }
                xv4 = new XV4(c11692dR6, arrayList3);
            }
            if (xv4 != null) {
                arrayList2.add(xv4);
            }
        }
        return AbstractC20051rO3.s(map, arrayList2);
    }

    private final void t(List list) {
        FilesStruct$FileLocation fileLocation;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            StoryStruct$MediaStory storyStruct$MediaStoryD = ((QQ6) it.next()).d();
            Long lValueOf = (storyStruct$MediaStoryD == null || (fileLocation = storyStruct$MediaStoryD.getFileLocation()) == null) ? null : Long.valueOf(fileLocation.getFileId());
            AbstractC13042fc3.f(lValueOf);
            arrayList.add(lValueOf);
        }
        long seconds = TimeUnit.MILLISECONDS.toSeconds(Calendar.getInstance().getTimeInMillis());
        List listG = G();
        ArrayList<CachedVideos> arrayList2 = new ArrayList();
        for (Object obj : listG) {
            if (((CachedVideos) obj).getExpireTimestamp() < seconds) {
                arrayList2.add(obj);
            }
        }
        for (CachedVideos cachedVideos : arrayList2) {
            this.k.k(cachedVideos.getCacheKey());
            V(cachedVideos.getCacheKey());
        }
        C10431bb8.a.g(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0093 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object u(java.util.Map r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof ir.nasim.story.repository.StoryRepository.c
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.story.repository.StoryRepository$c r0 = (ir.nasim.story.repository.StoryRepository.c) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.story.repository.StoryRepository$c r0 = new ir.nasim.story.repository.StoryRepository$c
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L4f
            if (r2 == r5) goto L43
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r8)
            goto L94
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L37:
            java.lang.Object r7 = r0.b
            java.util.Map r7 = (java.util.Map) r7
            java.lang.Object r2 = r0.a
            ir.nasim.story.repository.StoryRepository r2 = (ir.nasim.story.repository.StoryRepository) r2
            ir.nasim.AbstractC10685c16.b(r8)
            goto L83
        L43:
            java.lang.Object r7 = r0.b
            java.util.Map r7 = (java.util.Map) r7
            java.lang.Object r2 = r0.a
            ir.nasim.story.repository.StoryRepository r2 = (ir.nasim.story.repository.StoryRepository) r2
            ir.nasim.AbstractC10685c16.b(r8)
            goto L74
        L4f:
            ir.nasim.AbstractC10685c16.b(r8)
            java.util.Collection r8 = r7.values()
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.List r8 = ir.nasim.ZW0.z(r8)
            r6.t(r8)
            ir.nasim.Zm4 r8 = r6.l
            ir.nasim.xG2$b r2 = new ir.nasim.xG2$b
            r2.<init>(r7)
            r0.a = r6
            r0.b = r7
            r0.e = r5
            java.lang.Object r8 = r8.a(r2, r0)
            if (r8 != r1) goto L73
            return r1
        L73:
            r2 = r6
        L74:
            ir.nasim.jQ6 r8 = ir.nasim.C15344jQ6.a
            r0.a = r2
            r0.b = r7
            r0.e = r4
            java.lang.Object r8 = r8.b(r7, r0)
            if (r8 != r1) goto L83
            return r1
        L83:
            r2.S(r7)
            r8 = 0
            r0.a = r8
            r0.b = r8
            r0.e = r3
            java.lang.Object r7 = r2.R(r7, r0)
            if (r7 != r1) goto L94
            return r1
        L94:
            ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.story.repository.StoryRepository.u(java.util.Map, ir.nasim.rm1):java.lang.Object");
    }

    private final XV4 v(int i2, Map map, List list) {
        Object next;
        List list2 = (List) map.get(Integer.valueOf(i2));
        if (list2 == null) {
            return null;
        }
        List list3 = list2;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list3, 10));
        Iterator it = list3.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f.a(true).a((StoryStruct$ChannelStory) it.next()));
        }
        Iterator it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            if (((StoryStruct$ExPeerPopularity) next).getExPeer().getId() == i2) {
                break;
            }
        }
        StoryStruct$ExPeerPopularity storyStruct$ExPeerPopularity = (StoryStruct$ExPeerPopularity) next;
        if (storyStruct$ExPeerPopularity == null) {
            return null;
        }
        return new XV4(new C11692dR6(i2, EnumC23779xV6.e, Float.valueOf(storyStruct$ExPeerPopularity.getPopularity())), AbstractC15401jX0.p1(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object w(java.util.Map r8, ir.nasim.InterfaceC20295rm1 r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof ir.nasim.story.repository.StoryRepository.d
            if (r0 == 0) goto L13
            r0 = r9
            ir.nasim.story.repository.StoryRepository$d r0 = (ir.nasim.story.repository.StoryRepository.d) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.story.repository.StoryRepository$d r0 = new ir.nasim.story.repository.StoryRepository$d
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L48
            if (r2 == r5) goto L3c
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            ir.nasim.AbstractC10685c16.b(r9)
            goto Ld3
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L38:
            ir.nasim.AbstractC10685c16.b(r9)
            goto L99
        L3c:
            java.lang.Object r8 = r0.b
            java.util.Map r8 = (java.util.Map) r8
            java.lang.Object r2 = r0.a
            ir.nasim.story.repository.StoryRepository r2 = (ir.nasim.story.repository.StoryRepository) r2
            ir.nasim.AbstractC10685c16.b(r9)
            goto L5b
        L48:
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.VP6 r9 = r7.a
            r0.a = r7
            r0.b = r8
            r0.e = r5
            java.lang.Object r9 = r9.g(r0)
            if (r9 != r1) goto L5a
            return r1
        L5a:
            r2 = r7
        L5b:
            ir.nasim.Z06 r9 = (ir.nasim.Z06) r9
            boolean r5 = r9 instanceof ir.nasim.Z06.b
            r6 = 0
            if (r5 == 0) goto L9c
            ir.nasim.Z06$b r9 = (ir.nasim.Z06.b) r9
            com.google.protobuf.P r3 = r9.a()
            ai.bale.proto.StoryOuterClass$ResponseGetBotStories r3 = (ai.bale.proto.StoryOuterClass$ResponseGetBotStories) r3
            java.util.List r3 = r3.getResultList()
            java.lang.String r5 = "getResultList(...)"
            ir.nasim.AbstractC13042fc3.h(r3, r5)
            com.google.protobuf.P r9 = r9.a()
            ai.bale.proto.StoryOuterClass$ResponseGetBotStories r9 = (ai.bale.proto.StoryOuterClass$ResponseGetBotStories) r9
            java.util.List r9 = r9.getPopularityListList()
            java.lang.String r5 = "getPopularityListList(...)"
            ir.nasim.AbstractC13042fc3.h(r9, r5)
            java.util.Map r8 = r2.k(r8, r3, r9)
            ir.nasim.Vt0 r9 = ir.nasim.C8386Vt0.a
            boolean r9 = r9.rb()
            r0.a = r6
            r0.b = r6
            r0.e = r4
            java.lang.Object r8 = r2.F(r8, r9, r0)
            if (r8 != r1) goto L99
            return r1
        L99:
            ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
            return r8
        L9c:
            boolean r4 = r9 instanceof ir.nasim.Z06.a
            if (r4 == 0) goto Ld6
            ir.nasim.Z06$a r9 = (ir.nasim.Z06.a) r9
            ir.nasim.core.network.RpcException r9 = r9.a()
            java.lang.String r9 = r9.getIr.nasim.database.dailogLists.DialogEntity.COLUMN_MESSAGE java.lang.String()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "getBotStories error "
            r4.append(r5)
            r4.append(r9)
            java.lang.String r9 = r4.toString()
            java.lang.String r4 = "story"
            ir.nasim.C19406qI3.b(r4, r9)
            ir.nasim.Vt0 r9 = ir.nasim.C8386Vt0.a
            boolean r9 = r9.rb()
            r0.a = r6
            r0.b = r6
            r0.e = r3
            java.lang.Object r8 = r2.F(r8, r9, r0)
            if (r8 != r1) goto Ld3
            return r1
        Ld3:
            ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
            return r8
        Ld6:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.story.repository.StoryRepository.w(java.util.Map, ir.nasim.rm1):java.lang.Object");
    }

    public final InterfaceC10258bL6 B() {
        return this.m;
    }

    public final boolean C() {
        return this.b.r2();
    }

    public final boolean D() {
        return this.d.h("BADGE_IS_SHOWN_GROUP", false);
    }

    public final boolean E() {
        return this.b.s2();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object H(ir.nasim.InterfaceC20295rm1 r15) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.story.repository.StoryRepository.H(ir.nasim.rm1):java.lang.Object");
    }

    public final Object I(String str, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.a.i(str, interfaceC20295rm1);
    }

    public final Object J(InterfaceC20295rm1 interfaceC20295rm1) {
        return this.a.h(interfaceC20295rm1);
    }

    public final boolean K() {
        return this.b.p4();
    }

    public final boolean N() {
        return this.b.q4();
    }

    public final InterfaceC10258bL6 O() {
        return this.o;
    }

    public final String P() {
        return this.d.e("KEY_PREFERENCES_STORY_DRAFT");
    }

    public final InterfaceC10258bL6 Q() {
        return this.q;
    }

    public final Object U(PeersStruct$ExPeer peersStruct$ExPeer, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC6459Nq2.V(AbstractC6459Nq2.v(AbstractC6459Nq2.h(AbstractC6459Nq2.R(new m(peersStruct$ExPeer, null)), new n(null))), C12366eV1.b());
    }

    public final void V(String str) {
        AbstractC13042fc3.i(str, "cacheKey");
        try {
            List listG = G();
            Iterator it = listG.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                } else if (AbstractC13042fc3.d(((CachedVideos) it.next()).getCacheKey(), str)) {
                    break;
                } else {
                    i2++;
                }
            }
            Integer numValueOf = Integer.valueOf(i2);
            if (numValueOf.intValue() == -1) {
                numValueOf = null;
            }
            if (numValueOf != null) {
                listG.remove(numValueOf.intValue());
                this.d.putString("PROPERTIES_CACHED_KEYS", new KS2().t(listG));
            }
        } catch (Exception e2) {
            C19406qI3.b("story", "removeCacheFromStorage error: " + e2.getMessage());
        }
    }

    public final Object W(String str, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.a.l(str, interfaceC20295rm1);
    }

    public final void X() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.l;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, null));
    }

    public final void Y() {
        this.b.A6(true);
    }

    public final void Z() {
        this.d.g("BADGE_IS_SHOWN", true);
    }

    public final void a0() {
        this.b.B6(true);
    }

    public final void b0() {
        this.b.U6(true);
    }

    public final void c0() {
        this.d.g("BADGE_IS_SHOWN_GROUP", true);
    }

    public final void d0() {
        this.b.V6(true);
    }

    public final Object e0(StoryStruct$UserPrivacyConfig storyStruct$UserPrivacyConfig, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.a.f(storyStruct$UserPrivacyConfig, interfaceC20295rm1);
    }

    public final void f0() {
        this.b.K7(true);
    }

    public final void g0() {
        this.b.L7(true);
    }

    public final void h0(String str) {
        this.d.putString("KEY_PREFERENCES_STORY_DRAFT", str);
    }

    public final void i0(InterfaceC22036uZ3 interfaceC22036uZ3) {
        Object value;
        AbstractC13042fc3.i(interfaceC22036uZ3, "volume");
        if (AbstractC13042fc3.d(interfaceC22036uZ3, this.p.getValue())) {
            return;
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.p;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, interfaceC22036uZ3));
    }

    public final Object j0(Map map, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objB = C15344jQ6.a.b(map, interfaceC20295rm1);
        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
    }

    public final Object l(StoryStruct$MediaStory storyStruct$MediaStory, C14189hV6 c14189hV6, PeersStruct$ExPeer peersStruct$ExPeer, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.a.n(storyStruct$MediaStory, c14189hV6, peersStruct$ExPeer, interfaceC20295rm1);
    }

    public final void m(String str, long j2) {
        Object next;
        AbstractC13042fc3.i(str, "cacheKey");
        try {
            List listG = G();
            long seconds = j2 + TimeUnit.HOURS.toSeconds(24L);
            Iterator it = listG.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (AbstractC13042fc3.d(((CachedVideos) next).getCacheKey(), str)) {
                        break;
                    }
                }
            }
            CachedVideos cachedVideos = (CachedVideos) next;
            if (cachedVideos == null) {
                listG.add(new CachedVideos(str, seconds));
            } else if (cachedVideos.getExpireTimestamp() == seconds) {
                return;
            } else {
                cachedVideos.c(seconds);
            }
            this.d.putString("PROPERTIES_CACHED_KEYS", new KS2().t(listG));
        } catch (Exception e2) {
            C19406qI3.b("story", "addCacheToStorage error: " + e2.getMessage());
        }
    }

    public final Object o(PeersStruct$ExPeer peersStruct$ExPeer, StoryStruct$MediaStory storyStruct$MediaStory, C14189hV6 c14189hV6, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.a.o(peersStruct$ExPeer, storyStruct$MediaStory, c14189hV6, interfaceC20295rm1);
    }

    public final Object r(StoryStruct$MediaStory storyStruct$MediaStory, C14189hV6 c14189hV6, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.a.j(storyStruct$MediaStory, c14189hV6, interfaceC20295rm1);
    }

    public final Object s(StoryStruct$TextStory storyStruct$TextStory, PeersStruct$ExPeer peersStruct$ExPeer, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.a.e(storyStruct$TextStory, peersStruct$ExPeer, interfaceC20295rm1);
    }

    public final boolean x() {
        return this.b.o1();
    }

    public final boolean y() {
        return this.d.h("BADGE_IS_SHOWN", false);
    }

    public final boolean z() {
        return this.b.p1();
    }
}
