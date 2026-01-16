package ir.nasim;

import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.database.entity.ContactEntity;
import java.util.HashMap;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Fg6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4471Fg6 extends AbstractC21707u0 {
    public static final int p = 8;
    private final C9057Yh4 b;
    private final C9528a7 c;
    private final C6105Me6 d;
    private final DB3 e;
    private final DB3 f;
    private final DB3 g;
    private final DB3 h;
    private final DB3 i;
    private final DB3 j;
    private final HashMap k;
    private final HashMap l;
    private final HashMap m;
    private final HashMap n;
    private final HashMap o;

    /* renamed from: ir.nasim.Fg6$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC7325Rf6.values().length];
            try {
                iArr[EnumC7325Rf6.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC7325Rf6.a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC7325Rf6.b.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC7325Rf6.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnumC7325Rf6.e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4471Fg6(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.b = c9057Yh4;
        InterfaceC17311ml0 interfaceC17311ml0 = C18823pJ2.t;
        DB3 db3L = KN6.l("message_entity_search", interfaceC17311ml0);
        AbstractC13042fc3.h(db3L, "createList(...)");
        this.e = db3L;
        DB3 db3L2 = KN6.l("recent_entity_search", interfaceC17311ml0);
        AbstractC13042fc3.h(db3L2, "createList(...)");
        this.f = db3L2;
        DB3 db3L3 = KN6.l("channel_entity_search", interfaceC17311ml0);
        AbstractC13042fc3.h(db3L3, "createList(...)");
        this.g = db3L3;
        DB3 db3L4 = KN6.l("group_entity_search", interfaceC17311ml0);
        AbstractC13042fc3.h(db3L4, "createList(...)");
        this.h = db3L4;
        DB3 db3L5 = KN6.l("private_entity_search", interfaceC17311ml0);
        AbstractC13042fc3.h(db3L5, "createList(...)");
        this.i = db3L5;
        DB3 db3L6 = KN6.l("bot_entity_search", interfaceC17311ml0);
        AbstractC13042fc3.h(db3L6, "createList(...)");
        this.j = db3L6;
        this.k = new HashMap();
        this.l = new HashMap();
        this.m = new HashMap();
        this.n = new HashMap();
        this.o = new HashMap();
        C9528a7 c9528a7D = C12736f7.n().d("actor/search", new V6() { // from class: ir.nasim.Dg6
            @Override // ir.nasim.V6
            public final K6 create() {
                return C4471Fg6.C(this.a);
            }
        });
        this.c = c9528a7D;
        this.d = new C6105Me6(c9528a7D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final K6 C(C4471Fg6 c4471Fg6) {
        AbstractC13042fc3.i(c4471Fg6, "this$0");
        return new C5872Le6(c4471Fg6.b, c4471Fg6.f, c4471Fg6.e, c4471Fg6.g, c4471Fg6.h, c4471Fg6.i, c4471Fg6.j);
    }

    private final DB3 F(C11458d25 c11458d25, EnumC7325Rf6 enumC7325Rf6) {
        DB3 db3N;
        int i = a.a[enumC7325Rf6.ordinal()];
        if (i == 1) {
            db3N = (DB3) this.k.get(c11458d25);
            if (db3N == null) {
                db3N = KN6.n("content_peer_search_documents" + c11458d25.u(), C18823pJ2.t);
                this.k.put(c11458d25, db3N);
            }
            AbstractC13042fc3.f(db3N);
        } else if (i == 2) {
            db3N = (DB3) this.l.get(c11458d25);
            if (db3N == null) {
                db3N = KN6.n("content_peer_search_photos" + c11458d25.u(), C18823pJ2.t);
                this.l.put(c11458d25, db3N);
            }
            AbstractC13042fc3.f(db3N);
        } else if (i == 3) {
            db3N = (DB3) this.m.get(c11458d25);
            if (db3N == null) {
                db3N = KN6.n("content_peer_search_videos" + c11458d25.u(), C18823pJ2.t);
                this.m.put(c11458d25, db3N);
            }
            AbstractC13042fc3.f(db3N);
        } else if (i == 4) {
            db3N = (DB3) this.n.get(c11458d25);
            if (db3N == null) {
                db3N = KN6.n("content_peer_search_audios" + c11458d25.u(), C18823pJ2.t);
                this.n.put(c11458d25, db3N);
            }
            AbstractC13042fc3.f(db3N);
        } else {
            if (i != 5) {
                throw new NoWhenBranchMatchedException();
            }
            db3N = (DB3) this.o.get(c11458d25);
            if (db3N == null) {
                db3N = KN6.n("content_peer_search_voices" + c11458d25.u(), C18823pJ2.t);
                this.o.put(c11458d25, db3N);
            }
            AbstractC13042fc3.f(db3N);
        }
        return db3N;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(C4471Fg6 c4471Fg6, C11458d25 c11458d25, EnumC7325Rf6 enumC7325Rf6, C22372v74 c22372v74) {
        AbstractC13042fc3.i(c4471Fg6, "this$0");
        AbstractC13042fc3.i(c11458d25, "$peer");
        AbstractC13042fc3.i(enumC7325Rf6, "$contentType");
        AbstractC13042fc3.i(c22372v74, "messageSearchResult");
        c4471Fg6.F(c11458d25, enumC7325Rf6).c(c22372v74.a());
    }

    public final DB3 D() {
        return this.j;
    }

    public final DB3 E() {
        return this.g;
    }

    public final DB3 G() {
        return this.h;
    }

    public final DB3 H() {
        return this.e;
    }

    public final DB3 I(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "peer");
        return F(c11458d25, EnumC7325Rf6.d);
    }

    public final DB3 J() {
        return this.i;
    }

    public final DB3 K() {
        return this.f;
    }

    public final C6517Nv5 L(List list) {
        AbstractC13042fc3.i(list, "shortDialogs");
        return this.d.j(list);
    }

    public final void M(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "deletedPeer");
        this.c.d(new KJ4(c11458d25));
    }

    public final void N(int[] iArr) {
        AbstractC13042fc3.i(iArr, ContactEntity.TABLE_NAME);
        this.c.d(new C10238bJ4(iArr));
    }

    public final void O(List list) {
        AbstractC13042fc3.i(list, "shortDialogs");
        this.c.d(new C9653aK4(list));
    }

    public final void P() {
        this.f.l(false);
    }

    public final void Q(long j) {
        this.f.b(j);
    }

    public final C6517Nv5 R(final C11458d25 c11458d25, long j, EnumC19631qg6 enumC19631qg6, final EnumC7325Rf6 enumC7325Rf6) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(enumC19631qg6, "loadMode");
        AbstractC13042fc3.i(enumC7325Rf6, "contentType");
        C6517Nv5 c6517Nv5M0 = T(c11458d25, j, enumC19631qg6, enumC7325Rf6).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Eg6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C4471Fg6.S(this.a, c11458d25, enumC7325Rf6, (C22372v74) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5M0, "then(...)");
        return c6517Nv5M0;
    }

    public final C6517Nv5 T(C11458d25 c11458d25, long j, EnumC19631qg6 enumC19631qg6, EnumC7325Rf6 enumC7325Rf6) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(enumC19631qg6, "loadMode");
        AbstractC13042fc3.i(enumC7325Rf6, "contentType");
        return this.d.k(c11458d25, j, enumC19631qg6, enumC7325Rf6);
    }

    public final void U(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "peer");
        SettingsModule settingsModuleS = this.b.S();
        if (settingsModuleS != null && this.f.getCount() >= settingsModuleS.I3()) {
            this.f.b(((C18823pJ2) this.f.m()).a());
        }
        this.f.d(new C18823pJ2(c11458d25, AbstractC20507s76.p()));
    }
}
