package ir.nasim;

import ai.bale.proto.AbacusOuterClass$ResponseGetMessageReactionsList;
import ai.bale.proto.AbacusOuterClass$UserReaction;
import android.gov.nist.core.Separators;
import ir.nasim.Z06;
import ir.nasim.core.modules.profile.entity.Avatar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.cG3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C10826cG3 {
    public static final a f = new a(null);
    public static final int g = 8;
    private final OK7 a;
    private final C6287Mz b;
    private final AbstractC13778go1 c;
    private final AbstractC13778go1 d;
    private final InterfaceC20468s37 e;

    /* renamed from: ir.nasim.cG3$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.cG3$b */
    public static final class b {
        private final String a;
        private final Avatar b;
        private final boolean c;

        public b(String str, Avatar avatar, boolean z) {
            AbstractC13042fc3.i(str, "name");
            this.a = str;
            this.b = avatar;
            this.c = z;
        }

        public final Avatar a() {
            return this.b;
        }

        public final String b() {
            return this.a;
        }

        public final boolean c() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.a, bVar.a) && AbstractC13042fc3.d(this.b, bVar.b) && this.c == bVar.c;
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            Avatar avatar = this.b;
            return ((iHashCode + (avatar == null ? 0 : avatar.hashCode())) * 31) + Boolean.hashCode(this.c);
        }

        public String toString() {
            return "TempUser(name=" + this.a + ", avatar=" + this.b + ", isDeleteAccount=" + this.c + Separators.RPAREN;
        }
    }

    /* renamed from: ir.nasim.cG3$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ C11458d25 e;
        final /* synthetic */ long f;
        final /* synthetic */ String g;
        final /* synthetic */ long h;
        final /* synthetic */ int i;
        final /* synthetic */ int j;

        /* renamed from: ir.nasim.cG3$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            Object b;
            Object c;
            int d;
            final /* synthetic */ C10826cG3 e;
            final /* synthetic */ Z06 f;

            /* renamed from: ir.nasim.cG3$c$a$a, reason: collision with other inner class name */
            static final class C0931a implements InterfaceC24449ye1 {
                final /* synthetic */ C10826cG3 a;
                final /* synthetic */ Z06 b;
                final /* synthetic */ HE0 c;

                /* renamed from: ir.nasim.cG3$c$a$a$a, reason: collision with other inner class name */
                static final class C0932a implements InterfaceC24449ye1 {
                    final /* synthetic */ HE0 a;

                    C0932a(HE0 he0) {
                        this.a = he0;
                    }

                    @Override // ir.nasim.InterfaceC24449ye1
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final void apply(List list) {
                        HE0 he0 = this.a;
                        AbstractC13042fc3.f(list);
                        List<C17637nI7> list2 = list;
                        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
                        for (C17637nI7 c17637nI7 : list2) {
                            String name = c17637nI7.getName();
                            AbstractC13042fc3.h(name, "getName(...)");
                            arrayList.add(new b(name, c17637nI7.S(), c17637nI7.r0()));
                        }
                        AbstractC24549yo1.c(he0, arrayList);
                    }
                }

                C0931a(C10826cG3 c10826cG3, Z06 z06, HE0 he0) {
                    this.a = c10826cG3;
                    this.b = z06;
                    this.c = he0;
                }

                @Override // ir.nasim.InterfaceC24449ye1
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final void apply(C14505i18 c14505i18) {
                    InterfaceC8344Vo3 interfaceC8344Vo3P0 = this.a.a.p0();
                    List<AbacusOuterClass$UserReaction> userReactionsList = ((AbacusOuterClass$ResponseGetMessageReactionsList) ((Z06.b) this.b).a()).getUserReactionsList();
                    AbstractC13042fc3.h(userReactionsList, "getUserReactionsList(...)");
                    List<AbacusOuterClass$UserReaction> list = userReactionsList;
                    ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Long.valueOf(((AbacusOuterClass$UserReaction) it.next()).getUserId()));
                    }
                    interfaceC8344Vo3P0.g(arrayList).m0(new C0932a(this.c));
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C10826cG3 c10826cG3, Z06 z06, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.e = c10826cG3;
                this.f = z06;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.e, this.f, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.d;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C10826cG3 c10826cG3 = this.e;
                    Z06 z06 = this.f;
                    this.b = c10826cG3;
                    this.c = z06;
                    this.d = 1;
                    IE0 ie0 = new IE0(AbstractC14251hc3.c(this), 1);
                    ie0.w();
                    OK7 ok7 = c10826cG3.a;
                    List<AbacusOuterClass$UserReaction> userReactionsList = ((AbacusOuterClass$ResponseGetMessageReactionsList) ((Z06.b) z06).a()).getUserReactionsList();
                    AbstractC13042fc3.h(userReactionsList, "getUserReactionsList(...)");
                    List<AbacusOuterClass$UserReaction> list = userReactionsList;
                    ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(AbstractC6392Nk0.d(((AbacusOuterClass$UserReaction) it.next()).getUserId()));
                    }
                    ok7.w0(arrayList, false).m0(new C0931a(c10826cG3, z06, ie0));
                    obj = ie0.t();
                    if (obj == AbstractC14862ic3.e()) {
                        WA1.c(this);
                    }
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
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C11458d25 c11458d25, long j, String str, long j2, int i, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = c11458d25;
            this.f = j;
            this.g = str;
            this.h = j2;
            this.i = i;
            this.j = i2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10826cG3.this.new c(this.e, this.f, this.g, this.h, this.i, this.j, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x00b4  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00f8  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0157  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                Method dump skipped, instructions count: 348
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10826cG3.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C10826cG3(OK7 ok7, C6287Mz c6287Mz, AbstractC13778go1 abstractC13778go1, AbstractC13778go1 abstractC13778go12, InterfaceC20468s37 interfaceC20468s37) {
        AbstractC13042fc3.i(ok7, "usersModule");
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(abstractC13778go12, "mainDispatcher");
        AbstractC13042fc3.i(interfaceC20468s37, "peerToOutPeerMapper");
        this.a = ok7;
        this.b = c6287Mz;
        this.c = abstractC13778go1;
        this.d = abstractC13778go12;
        this.e = interfaceC20468s37;
    }

    public final Object e(String str, long j, C11458d25 c11458d25, int i, int i2, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.c, new c(c11458d25, j2, str, j, i, i2, null), interfaceC20295rm1);
    }
}
