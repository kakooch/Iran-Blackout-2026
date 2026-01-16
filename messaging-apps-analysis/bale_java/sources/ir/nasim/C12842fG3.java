package ir.nasim;

import ai.bale.proto.NegahOuterClass$ResponseGetMessageSeenList;
import ai.bale.proto.NegahStruct$UserSeenMessage;
import android.gov.nist.core.Separators;
import ir.nasim.Z06;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.fG3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C12842fG3 {
    public static final a e = new a(null);
    public static final int f = 8;
    private final OK7 a;
    private final C6287Mz b;
    private final AbstractC13778go1 c;
    private final AbstractC13778go1 d;

    /* renamed from: ir.nasim.fG3$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.fG3$b */
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

    /* renamed from: ir.nasim.fG3$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ long d;
        final /* synthetic */ long e;
        final /* synthetic */ ExPeerType f;
        final /* synthetic */ C11458d25 g;
        final /* synthetic */ int h;
        final /* synthetic */ int i;
        final /* synthetic */ C12842fG3 j;

        /* renamed from: ir.nasim.fG3$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            Object b;
            Object c;
            int d;
            final /* synthetic */ C12842fG3 e;
            final /* synthetic */ Z06 f;

            /* renamed from: ir.nasim.fG3$c$a$a, reason: collision with other inner class name */
            static final class C1113a implements InterfaceC24449ye1 {
                final /* synthetic */ C12842fG3 a;
                final /* synthetic */ Z06 b;
                final /* synthetic */ HE0 c;

                /* renamed from: ir.nasim.fG3$c$a$a$a, reason: collision with other inner class name */
                static final class C1114a implements InterfaceC24449ye1 {
                    final /* synthetic */ HE0 a;

                    C1114a(HE0 he0) {
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

                C1113a(C12842fG3 c12842fG3, Z06 z06, HE0 he0) {
                    this.a = c12842fG3;
                    this.b = z06;
                    this.c = he0;
                }

                @Override // ir.nasim.InterfaceC24449ye1
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final void apply(C14505i18 c14505i18) {
                    InterfaceC8344Vo3 interfaceC8344Vo3P0 = this.a.a.p0();
                    List<NegahStruct$UserSeenMessage> usersSeenList = ((NegahOuterClass$ResponseGetMessageSeenList) ((Z06.b) this.b).a()).getUsersSeenList();
                    AbstractC13042fc3.h(usersSeenList, "getUsersSeenList(...)");
                    List<NegahStruct$UserSeenMessage> list = usersSeenList;
                    ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Long.valueOf(((NegahStruct$UserSeenMessage) it.next()).getUserId()));
                    }
                    interfaceC8344Vo3P0.g(arrayList).m0(new C1114a(this.c));
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C12842fG3 c12842fG3, Z06 z06, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.e = c12842fG3;
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
                    C12842fG3 c12842fG3 = this.e;
                    Z06 z06 = this.f;
                    this.b = c12842fG3;
                    this.c = z06;
                    this.d = 1;
                    IE0 ie0 = new IE0(AbstractC14251hc3.c(this), 1);
                    ie0.w();
                    OK7 ok7 = c12842fG3.a;
                    List<NegahStruct$UserSeenMessage> usersSeenList = ((NegahOuterClass$ResponseGetMessageSeenList) ((Z06.b) z06).a()).getUsersSeenList();
                    AbstractC13042fc3.h(usersSeenList, "getUsersSeenList(...)");
                    List<NegahStruct$UserSeenMessage> list = usersSeenList;
                    ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(AbstractC6392Nk0.d(((NegahStruct$UserSeenMessage) it.next()).getUserId()));
                    }
                    ok7.w0(arrayList, false).m0(new C1113a(c12842fG3, z06, ie0));
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
        c(long j, long j2, ExPeerType exPeerType, C11458d25 c11458d25, int i, int i2, C12842fG3 c12842fG3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = j2;
            this.f = exPeerType;
            this.g = c11458d25;
            this.h = i;
            this.i = i2;
            this.j = c12842fG3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.d, this.e, this.f, this.g, this.h, this.i, this.j, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x00c2  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0125  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x017f  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instructions count: 426
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12842fG3.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C12842fG3(OK7 ok7, C6287Mz c6287Mz, AbstractC13778go1 abstractC13778go1, AbstractC13778go1 abstractC13778go12) {
        AbstractC13042fc3.i(ok7, "usersModule");
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(abstractC13778go12, "mainDispatcher");
        this.a = ok7;
        this.b = c6287Mz;
        this.c = abstractC13778go1;
        this.d = abstractC13778go12;
    }

    public final Object d(long j, C11458d25 c11458d25, ExPeerType exPeerType, long j2, int i, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.c, new c(j2, j, exPeerType, c11458d25, i2, i, this, null), interfaceC20295rm1);
    }
}
