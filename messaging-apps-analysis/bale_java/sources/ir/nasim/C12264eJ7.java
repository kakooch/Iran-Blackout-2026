package ir.nasim;

import ai.bale.proto.FilesStruct$FileLocation;
import ai.bale.proto.UsersOuterClass$RequestEditAvatar;
import ai.bale.proto.UsersOuterClass$ResponseEditAvatar;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import ir.nasim.core.modules.profile.entity.Avatar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.eJ7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12264eJ7 implements InterfaceC11621dJ7 {
    private static final a f = new a(null);
    private final AbstractC13778go1 a;
    private final InterfaceC20315ro1 b;
    private final OK7 c;
    private final C6287Mz d;
    private final KM2 e;

    /* renamed from: ir.nasim.eJ7$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.eJ7$b */
    static final class b extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objJ = C12264eJ7.this.j(null, this);
            return objJ == AbstractC14862ic3.e() ? objJ : C9475a16.a(objJ);
        }
    }

    /* renamed from: ir.nasim.eJ7$c */
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
            Object objH = C12264eJ7.this.h(0L, this);
            return objH == AbstractC14862ic3.e() ? objH : C9475a16.a(objH);
        }
    }

    /* renamed from: ir.nasim.eJ7$d */
    static final class d extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objK = C12264eJ7.this.k(null, this);
            return objK == AbstractC14862ic3.e() ? objK : C9475a16.a(objK);
        }
    }

    /* renamed from: ir.nasim.eJ7$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12264eJ7.this.new e(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            VL3 vl3O0 = C12264eJ7.this.c.o0();
            List list = this.d;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(AbstractC6392Nk0.e(((Number) it.next()).intValue()));
            }
            List listM = vl3O0.m(arrayList);
            AbstractC13042fc3.h(listM, "getArrayBlocking(...)");
            ArrayList arrayList2 = new ArrayList();
            int size = listM.size();
            for (int i = 0; i < size; i++) {
                if (listM.get(i) == null) {
                    arrayList2.add(this.d.get(i));
                }
            }
            if (!arrayList2.isEmpty()) {
                C12264eJ7.this.c.w0(arrayList2, true);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.eJ7$f */
    static final class f extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objD = C12264eJ7.this.d(this);
            return objD == AbstractC14862ic3.e() ? objD : C9475a16.a(objD);
        }
    }

    /* renamed from: ir.nasim.eJ7$g */
    static final class g extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objI = C12264eJ7.this.i(0L, this);
            return objI == AbstractC14862ic3.e() ? objI : C9475a16.a(objI);
        }
    }

    /* renamed from: ir.nasim.eJ7$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12264eJ7.this.new h(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objD;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C6517Nv5 c6517Nv5K = C12264eJ7.this.c.o0().k(this.d);
                AbstractC13042fc3.h(c6517Nv5K, "get(...)");
                this.b = 1;
                objD = AbstractC6756Ov5.d(c6517Nv5K, null, this, 1, null);
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
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.eJ7$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12264eJ7.this.new i(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return C12264eJ7.this.c.p0().d(this.d);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.eJ7$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;

        /* renamed from: ir.nasim.eJ7$j$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C12264eJ7 c;
            final /* synthetic */ long d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C12264eJ7 c12264eJ7, long j, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c12264eJ7;
                this.d = j;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C12264eJ7 c12264eJ7 = this.c;
                    long j = this.d;
                    this.b = 1;
                    if (InterfaceC11621dJ7.q(c12264eJ7, j, false, this, 2, null) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    ((C9475a16) obj).l();
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12264eJ7.this.new j(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C12264eJ7 c12264eJ7 = C12264eJ7.this;
                long j = this.d;
                this.b = 1;
                obj = c12264eJ7.a(j, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            long j2 = this.d;
            C12264eJ7 c12264eJ72 = C12264eJ7.this;
            if (((C17637nI7) obj) == null) {
                Log.d("NullUser", "user with id {" + j2 + "} was not found for getting Avatar try to load asynchronously");
                AbstractC10533bm0.d(c12264eJ72.b, c12264eJ72.a, null, new a(c12264eJ72, j2, null), 2, null);
            }
            return obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.eJ7$k */
    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12264eJ7.this.new k(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return C12264eJ7.this.c.o0().n(this.d);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.eJ7$l */
    static final class l implements InterfaceC24449ye1 {
        final /* synthetic */ List b;
        final /* synthetic */ HE0 c;

        /* renamed from: ir.nasim.eJ7$l$a */
        static final class a implements InterfaceC24449ye1 {
            final /* synthetic */ HE0 a;

            a(HE0 he0) {
                this.a = he0;
            }

            @Override // ir.nasim.InterfaceC24449ye1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void apply(List list) {
                AbstractC24549yo1.c(this.a, list);
            }
        }

        /* renamed from: ir.nasim.eJ7$l$b */
        static final class b implements InterfaceC24449ye1 {
            final /* synthetic */ HE0 a;

            b(HE0 he0) {
                this.a = he0;
            }

            @Override // ir.nasim.InterfaceC24449ye1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void apply(Exception exc) {
                AbstractC24549yo1.c(this.a, AbstractC10360bX0.m());
            }
        }

        l(List list, HE0 he0) {
            this.b = list;
            this.c = he0;
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void apply(C14505i18 c14505i18) {
            InterfaceC8344Vo3 interfaceC8344Vo3P0 = C12264eJ7.this.c.p0();
            List list = this.b;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((Number) it.next()).intValue()));
            }
            interfaceC8344Vo3P0.g(arrayList).m0(new a(this.c)).E(new b(this.c));
        }
    }

    /* renamed from: ir.nasim.eJ7$m */
    static final class m implements InterfaceC24449ye1 {
        final /* synthetic */ HE0 a;

        m(HE0 he0) {
            this.a = he0;
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void apply(Exception exc) {
            AbstractC24549yo1.c(this.a, AbstractC10360bX0.m());
        }
    }

    /* renamed from: ir.nasim.eJ7$n */
    static final class n implements InterfaceC24449ye1 {
        final /* synthetic */ HE0 a;

        n(HE0 he0) {
            this.a = he0;
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void apply(List list) {
            AbstractC24549yo1.c(this.a, list);
        }
    }

    /* renamed from: ir.nasim.eJ7$o */
    static final class o implements InterfaceC24449ye1 {
        final /* synthetic */ HE0 a;

        o(HE0 he0) {
            this.a = he0;
        }

        @Override // ir.nasim.InterfaceC24449ye1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void apply(Exception exc) {
            AbstractC24549yo1.c(this.a, AbstractC10360bX0.m());
        }
    }

    /* renamed from: ir.nasim.eJ7$p */
    static final class p extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        p(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objT = C12264eJ7.this.t(null, false, this);
            return objT == AbstractC14862ic3.e() ? objT : C9475a16.a(objT);
        }
    }

    /* renamed from: ir.nasim.eJ7$q */
    static final class q extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        int g;
        int h;
        int i;
        final /* synthetic */ boolean k;
        final /* synthetic */ String l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        q(boolean z, String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.k = z;
            this.l = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12264eJ7.this.new q(this.k, this.l, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x0177  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                Method dump skipped, instructions count: 440
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12264eJ7.q.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((q) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.eJ7$r */
    static final class r extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        r(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return C12264eJ7.this.r(0L, 0L, 0L, this);
        }
    }

    /* renamed from: ir.nasim.eJ7$s */
    static final class s extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        s(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objO = C12264eJ7.this.o(0, this);
            return objO == AbstractC14862ic3.e() ? objO : C9475a16.a(objO);
        }
    }

    /* renamed from: ir.nasim.eJ7$t */
    static final class t extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        t(int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12264eJ7.this.new t(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return C12264eJ7.this.c.j0(this.d);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((t) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.eJ7$u */
    static final class u extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        u(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objS = C12264eJ7.this.s(0L, false, this);
            return objS == AbstractC14862ic3.e() ? objS : C9475a16.a(objS);
        }
    }

    /* renamed from: ir.nasim.eJ7$v */
    static final class v extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        v(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objC = C12264eJ7.this.c(null, false, this);
            return objC == AbstractC14862ic3.e() ? objC : C9475a16.a(objC);
        }
    }

    /* renamed from: ir.nasim.eJ7$w */
    static final class w extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        w(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objE = C12264eJ7.this.e(0, this);
            return objE == AbstractC14862ic3.e() ? objE : C9475a16.a(objE);
        }
    }

    public C12264eJ7(AbstractC13778go1 abstractC13778go1, InterfaceC20315ro1 interfaceC20315ro1, OK7 ok7, C6287Mz c6287Mz, KM2 km2) {
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        AbstractC13042fc3.i(ok7, "usersModule");
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        AbstractC13042fc3.i(km2, "groupRepository");
        this.a = abstractC13778go1;
        this.b = interfaceC20315ro1;
        this.c = ok7;
        this.d = c6287Mz;
        this.e = km2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List A(List list) {
        List<C17637nI7> list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        for (C17637nI7 c17637nI7 : list2) {
            Avatar avatarS = c17637nI7.S();
            String name = c17637nI7.getName();
            AbstractC13042fc3.h(name, "getName(...)");
            arrayList.add(new R14(avatarS, name, c17637nI7.n0()));
        }
        return arrayList;
    }

    @Override // ir.nasim.InterfaceC11621dJ7
    public Object a(long j2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.a, new i(j2, null), interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC11621dJ7
    public Object b(long j2, long j3, InterfaceC20295rm1 interfaceC20295rm1) {
        GeneratedMessageLite generatedMessageLiteA = UsersOuterClass$RequestEditAvatar.newBuilder().B((FilesStruct$FileLocation) FilesStruct$FileLocation.newBuilder().B(j2).A(j3).C(Int32Value.of(1)).a()).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        UsersOuterClass$ResponseEditAvatar defaultInstance = UsersOuterClass$ResponseEditAvatar.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        Object objC = InterfaceC16847ly.c(this.d, new C22871vx5("/bale.users.v1.Users/EditAvatar", generatedMessageLiteA, defaultInstance), 0L, null, interfaceC20295rm1, 6, null);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC11621dJ7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(java.util.List r7, boolean r8, ir.nasim.InterfaceC20295rm1 r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof ir.nasim.C12264eJ7.v
            if (r0 == 0) goto L13
            r0 = r9
            ir.nasim.eJ7$v r0 = (ir.nasim.C12264eJ7.v) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.eJ7$v r0 = new ir.nasim.eJ7$v
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.a16 r9 = (ir.nasim.C9475a16) r9
            java.lang.Object r7 = r9.l()
            goto L74
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L37:
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.OK7 r9 = r6.c
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r2 = new java.util.ArrayList
            r4 = 10
            int r4 = ir.nasim.ZW0.x(r7, r4)
            r2.<init>(r4)
            java.util.Iterator r7 = r7.iterator()
        L4d:
            boolean r4 = r7.hasNext()
            if (r4 == 0) goto L66
            java.lang.Object r4 = r7.next()
            java.lang.Number r4 = (java.lang.Number) r4
            long r4 = r4.longValue()
            int r4 = (int) r4
            java.lang.Integer r4 = ir.nasim.AbstractC6392Nk0.d(r4)
            r2.add(r4)
            goto L4d
        L66:
            ir.nasim.Nv5 r7 = r9.w0(r2, r8)
            r0.c = r3
            r8 = 0
            java.lang.Object r7 = ir.nasim.AbstractC6756Ov5.d(r7, r8, r0, r3, r8)
            if (r7 != r1) goto L74
            return r1
        L74:
            boolean r8 = ir.nasim.C9475a16.j(r7)
            if (r8 == 0) goto L7e
            ir.nasim.i18 r7 = (ir.nasim.C14505i18) r7
            ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
        L7e:
            java.lang.Object r7 = ir.nasim.C9475a16.b(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12264eJ7.c(java.util.List, boolean, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // ir.nasim.InterfaceC11621dJ7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(ir.nasim.InterfaceC20295rm1 r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof ir.nasim.C12264eJ7.f
            if (r0 == 0) goto L14
            r0 = r10
            ir.nasim.eJ7$f r0 = (ir.nasim.C12264eJ7.f) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.c = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            ir.nasim.eJ7$f r0 = new ir.nasim.eJ7$f
            r0.<init>(r10)
            goto L12
        L1a:
            java.lang.Object r10 = r6.a
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.c
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            ir.nasim.AbstractC10685c16.b(r10)
            goto L64
        L2b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L33:
            ir.nasim.AbstractC10685c16.b(r10)
            ir.nasim.vx5 r10 = new ir.nasim.vx5
            ai.bale.proto.OrganizationsOuterClass$RequestGetUserOrganizationInfo$a r1 = ai.bale.proto.OrganizationsOuterClass$RequestGetUserOrganizationInfo.newBuilder()
            com.google.protobuf.GeneratedMessageLite r1 = r1.a()
            java.lang.String r3 = "build(...)"
            ir.nasim.AbstractC13042fc3.h(r1, r3)
            ai.bale.proto.OrganizationsOuterClass$ResponseGetUserOrganizationInfo r3 = ai.bale.proto.OrganizationsOuterClass$ResponseGetUserOrganizationInfo.getDefaultInstance()
            java.lang.String r4 = "getDefaultInstance(...)"
            ir.nasim.AbstractC13042fc3.h(r3, r4)
            java.lang.String r4 = "/bale.organizations.v1.Organizations/GetUserOrganizationInfo"
            r10.<init>(r4, r1, r3)
            ir.nasim.Mz r1 = r9.d
            r6.c = r2
            r3 = 0
            r5 = 0
            r7 = 6
            r8 = 0
            r2 = r10
            java.lang.Object r10 = ir.nasim.InterfaceC16847ly.c(r1, r2, r3, r5, r6, r7, r8)
            if (r10 != r0) goto L64
            return r0
        L64:
            ir.nasim.Z06 r10 = (ir.nasim.Z06) r10
            boolean r0 = r10 instanceof ir.nasim.Z06.a
            if (r0 == 0) goto L7b
            ir.nasim.Z06$a r10 = (ir.nasim.Z06.a) r10
            ir.nasim.core.network.RpcException r10 = r10.a()
            ir.nasim.a16$a r0 = ir.nasim.C9475a16.b
            java.lang.Object r10 = ir.nasim.AbstractC10685c16.a(r10)
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
            goto L91
        L7b:
            boolean r0 = r10 instanceof ir.nasim.Z06.b
            if (r0 == 0) goto L92
            ir.nasim.a16$a r0 = ir.nasim.C9475a16.b
            ir.nasim.Z06$b r10 = (ir.nasim.Z06.b) r10
            com.google.protobuf.P r10 = r10.a()
            ai.bale.proto.OrganizationsOuterClass$ResponseGetUserOrganizationInfo r10 = (ai.bale.proto.OrganizationsOuterClass$ResponseGetUserOrganizationInfo) r10
            ai.bale.proto.OrganizationsStruct$UserOrganization r10 = r10.getUserOrganization()
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
        L91:
            return r10
        L92:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12264eJ7.d(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC11621dJ7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(int r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ir.nasim.C12264eJ7.w
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.eJ7$w r0 = (ir.nasim.C12264eJ7.w) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.eJ7$w r0 = new ir.nasim.eJ7$w
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
            java.lang.Object r5 = r6.l()
            goto L4a
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.OK7 r6 = r4.c
            ir.nasim.Nv5 r5 = r6.C0(r5)
            r0.c = r3
            r6 = 0
            java.lang.Object r5 = ir.nasim.AbstractC6756Ov5.d(r5, r6, r0, r3, r6)
            if (r5 != r1) goto L4a
            return r1
        L4a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12264eJ7.e(int, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // ir.nasim.InterfaceC11621dJ7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object h(long r10, ir.nasim.InterfaceC20295rm1 r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof ir.nasim.C12264eJ7.c
            if (r0 == 0) goto L14
            r0 = r12
            ir.nasim.eJ7$c r0 = (ir.nasim.C12264eJ7.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.c = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            ir.nasim.eJ7$c r0 = new ir.nasim.eJ7$c
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r12 = r6.a
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.c
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            ir.nasim.AbstractC10685c16.b(r12)
            goto L68
        L2b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L33:
            ir.nasim.AbstractC10685c16.b(r12)
            ir.nasim.vx5 r12 = new ir.nasim.vx5
            ai.bale.proto.UsersOuterClass$RequestChangePhoneNumber$a r1 = ai.bale.proto.UsersOuterClass$RequestChangePhoneNumber.newBuilder()
            ai.bale.proto.UsersOuterClass$RequestChangePhoneNumber$a r10 = r1.A(r10)
            com.google.protobuf.GeneratedMessageLite r10 = r10.a()
            java.lang.String r11 = "build(...)"
            ir.nasim.AbstractC13042fc3.h(r10, r11)
            ai.bale.proto.Misc$ResponseVoid r11 = ai.bale.proto.Misc$ResponseVoid.getDefaultInstance()
            java.lang.String r1 = "getDefaultInstance(...)"
            ir.nasim.AbstractC13042fc3.h(r11, r1)
            java.lang.String r1 = "/bale.users.v1.Users/ChangePhoneNumber"
            r12.<init>(r1, r10, r11)
            ir.nasim.Mz r1 = r9.d
            r6.c = r2
            r3 = 0
            r5 = 0
            r7 = 6
            r8 = 0
            r2 = r12
            java.lang.Object r12 = ir.nasim.InterfaceC16847ly.c(r1, r2, r3, r5, r6, r7, r8)
            if (r12 != r0) goto L68
            return r0
        L68:
            ir.nasim.Z06 r12 = (ir.nasim.Z06) r12
            boolean r10 = r12 instanceof ir.nasim.Z06.a
            if (r10 == 0) goto L7f
            ir.nasim.Z06$a r12 = (ir.nasim.Z06.a) r12
            ir.nasim.core.network.RpcException r10 = r12.a()
            ir.nasim.a16$a r11 = ir.nasim.C9475a16.b
            java.lang.Object r10 = ir.nasim.AbstractC10685c16.a(r10)
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
            goto L93
        L7f:
            boolean r10 = r12 instanceof ir.nasim.Z06.b
            if (r10 == 0) goto L94
            ir.nasim.a16$a r10 = ir.nasim.C9475a16.b
            ir.nasim.Z06$b r12 = (ir.nasim.Z06.b) r12
            com.google.protobuf.P r10 = r12.a()
            ai.bale.proto.Misc$ResponseVoid r10 = (ai.bale.proto.Misc$ResponseVoid) r10
            ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
        L93:
            return r10
        L94:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12264eJ7.h(long, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC11621dJ7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object i(long r6, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof ir.nasim.C12264eJ7.g
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.eJ7$g r0 = (ir.nasim.C12264eJ7.g) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.eJ7$g r0 = new ir.nasim.eJ7$g
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r8)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.go1 r8 = r5.a
            ir.nasim.eJ7$h r2 = new ir.nasim.eJ7$h
            r4 = 0
            r2.<init>(r6, r4)
            r0.c = r3
            java.lang.Object r8 = ir.nasim.AbstractC9323Zl0.g(r8, r2, r0)
            if (r8 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
            java.lang.Object r6 = r8.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12264eJ7.i(long, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // ir.nasim.InterfaceC11621dJ7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object j(java.lang.String r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof ir.nasim.C12264eJ7.b
            if (r0 == 0) goto L14
            r0 = r11
            ir.nasim.eJ7$b r0 = (ir.nasim.C12264eJ7.b) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.c = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            ir.nasim.eJ7$b r0 = new ir.nasim.eJ7$b
            r0.<init>(r11)
            goto L12
        L1a:
            java.lang.Object r11 = r6.a
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.c
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            ir.nasim.AbstractC10685c16.b(r11)
            goto L68
        L2b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L33:
            ir.nasim.AbstractC10685c16.b(r11)
            ir.nasim.vx5 r11 = new ir.nasim.vx5
            ai.bale.proto.UsersOuterClass$RequestCheckNickName$a r1 = ai.bale.proto.UsersOuterClass$RequestCheckNickName.newBuilder()
            ai.bale.proto.UsersOuterClass$RequestCheckNickName$a r10 = r1.A(r10)
            com.google.protobuf.GeneratedMessageLite r10 = r10.a()
            java.lang.String r1 = "build(...)"
            ir.nasim.AbstractC13042fc3.h(r10, r1)
            ai.bale.proto.Misc$ResponseBool r1 = ai.bale.proto.Misc$ResponseBool.getDefaultInstance()
            java.lang.String r3 = "getDefaultInstance(...)"
            ir.nasim.AbstractC13042fc3.h(r1, r3)
            java.lang.String r3 = "/bale.users.v1.Users/CheckNickName"
            r11.<init>(r3, r10, r1)
            ir.nasim.Mz r1 = r9.d
            r6.c = r2
            r3 = 0
            r5 = 0
            r7 = 6
            r8 = 0
            r2 = r11
            java.lang.Object r11 = ir.nasim.InterfaceC16847ly.c(r1, r2, r3, r5, r6, r7, r8)
            if (r11 != r0) goto L68
            return r0
        L68:
            ir.nasim.Z06 r11 = (ir.nasim.Z06) r11
            boolean r10 = r11 instanceof ir.nasim.Z06.a
            if (r10 == 0) goto L7f
            ir.nasim.Z06$a r11 = (ir.nasim.Z06.a) r11
            ir.nasim.core.network.RpcException r10 = r11.a()
            ir.nasim.a16$a r11 = ir.nasim.C9475a16.b
            java.lang.Object r10 = ir.nasim.AbstractC10685c16.a(r10)
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
            goto L99
        L7f:
            boolean r10 = r11 instanceof ir.nasim.Z06.b
            if (r10 == 0) goto L9a
            ir.nasim.a16$a r10 = ir.nasim.C9475a16.b
            ir.nasim.Z06$b r11 = (ir.nasim.Z06.b) r11
            com.google.protobuf.P r10 = r11.a()
            ai.bale.proto.Misc$ResponseBool r10 = (ai.bale.proto.Misc$ResponseBool) r10
            boolean r10 = r10.getValue()
            java.lang.Boolean r10 = ir.nasim.AbstractC6392Nk0.a(r10)
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
        L99:
            return r10
        L9a:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12264eJ7.j(java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // ir.nasim.InterfaceC11621dJ7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object k(java.lang.String r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof ir.nasim.C12264eJ7.d
            if (r0 == 0) goto L14
            r0 = r11
            ir.nasim.eJ7$d r0 = (ir.nasim.C12264eJ7.d) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.c = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            ir.nasim.eJ7$d r0 = new ir.nasim.eJ7$d
            r0.<init>(r11)
            goto L12
        L1a:
            java.lang.Object r11 = r6.a
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.c
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            ir.nasim.AbstractC10685c16.b(r11)
            goto L68
        L2b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L33:
            ir.nasim.AbstractC10685c16.b(r11)
            ir.nasim.vx5 r11 = new ir.nasim.vx5
            ai.bale.proto.UsersOuterClass$RequestConfirmPhoneNumber$a r1 = ai.bale.proto.UsersOuterClass$RequestConfirmPhoneNumber.newBuilder()
            ai.bale.proto.UsersOuterClass$RequestConfirmPhoneNumber$a r10 = r1.A(r10)
            com.google.protobuf.GeneratedMessageLite r10 = r10.a()
            java.lang.String r1 = "build(...)"
            ir.nasim.AbstractC13042fc3.h(r10, r1)
            ai.bale.proto.Misc$ResponseVoid r1 = ai.bale.proto.Misc$ResponseVoid.getDefaultInstance()
            java.lang.String r3 = "getDefaultInstance(...)"
            ir.nasim.AbstractC13042fc3.h(r1, r3)
            java.lang.String r3 = "/bale.users.v1.Users/ConfirmPhoneNumber"
            r11.<init>(r3, r10, r1)
            ir.nasim.Mz r1 = r9.d
            r6.c = r2
            r3 = 0
            r5 = 0
            r7 = 6
            r8 = 0
            r2 = r11
            java.lang.Object r11 = ir.nasim.InterfaceC16847ly.c(r1, r2, r3, r5, r6, r7, r8)
            if (r11 != r0) goto L68
            return r0
        L68:
            ir.nasim.Z06 r11 = (ir.nasim.Z06) r11
            boolean r10 = r11 instanceof ir.nasim.Z06.a
            if (r10 == 0) goto L7f
            ir.nasim.Z06$a r11 = (ir.nasim.Z06.a) r11
            ir.nasim.core.network.RpcException r10 = r11.a()
            ir.nasim.a16$a r11 = ir.nasim.C9475a16.b
            java.lang.Object r10 = ir.nasim.AbstractC10685c16.a(r10)
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
            goto L93
        L7f:
            boolean r10 = r11 instanceof ir.nasim.Z06.b
            if (r10 == 0) goto L94
            ir.nasim.a16$a r10 = ir.nasim.C9475a16.b
            ir.nasim.Z06$b r11 = (ir.nasim.Z06.b) r11
            com.google.protobuf.P r10 = r11.a()
            ai.bale.proto.Misc$ResponseVoid r10 = (ai.bale.proto.Misc$ResponseVoid) r10
            ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
        L93:
            return r10
        L94:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12264eJ7.k(java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC11621dJ7
    public Object l(List list, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
        IE0 ie0 = new IE0(AbstractC14251hc3.c(interfaceC20295rm1), 1);
        ie0.w();
        this.c.w0(list, z).m0(new l(list, ie0)).E(new m(ie0));
        Object objT = ie0.t();
        if (objT == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objT;
    }

    @Override // ir.nasim.InterfaceC11621dJ7
    public Object m(long j2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.a, new k(j2, null), interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC11621dJ7
    public Object n(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        IE0 ie0 = new IE0(AbstractC14251hc3.c(interfaceC20295rm1), 1);
        ie0.w();
        InterfaceC8344Vo3 interfaceC8344Vo3P0 = this.c.p0();
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(AbstractC6392Nk0.e(((Number) it.next()).intValue()));
        }
        interfaceC8344Vo3P0.g(arrayList).m0(new n(ie0)).E(new o(ie0));
        Object objT = ie0.t();
        if (objT == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objT;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC11621dJ7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object o(int r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof ir.nasim.C12264eJ7.s
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.eJ7$s r0 = (ir.nasim.C12264eJ7.s) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.eJ7$s r0 = new ir.nasim.eJ7$s
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L3f
            if (r2 == r5) goto L3b
            if (r2 != r3) goto L33
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
            java.lang.Object r7 = r8.l()
            goto L5d
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3b:
            ir.nasim.AbstractC10685c16.b(r8)
            goto L52
        L3f:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.go1 r8 = r6.a
            ir.nasim.eJ7$t r2 = new ir.nasim.eJ7$t
            r2.<init>(r7, r4)
            r0.c = r5
            java.lang.Object r8 = ir.nasim.AbstractC9323Zl0.g(r8, r2, r0)
            if (r8 != r1) goto L52
            return r1
        L52:
            ir.nasim.Nv5 r8 = (ir.nasim.C6517Nv5) r8
            r0.c = r3
            java.lang.Object r7 = ir.nasim.AbstractC6756Ov5.d(r8, r4, r0, r5, r4)
            if (r7 != r1) goto L5d
            return r1
        L5d:
            boolean r8 = ir.nasim.C9475a16.j(r7)
            if (r8 == 0) goto L67
            ir.nasim.i18 r7 = (ir.nasim.C14505i18) r7
            ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
        L67:
            java.lang.Object r7 = ir.nasim.C9475a16.b(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12264eJ7.o(int, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC11621dJ7
    public C17637nI7 p(long j2) {
        return (C17637nI7) AbstractC9913am0.b(null, new j(j2, null), 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    @Override // ir.nasim.InterfaceC11621dJ7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object r(long r18, long r20, long r22, ir.nasim.InterfaceC20295rm1 r24) {
        /*
            Method dump skipped, instructions count: 337
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12264eJ7.r(long, long, long, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC11621dJ7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object s(long r5, boolean r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof ir.nasim.C12264eJ7.u
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.eJ7$u r0 = (ir.nasim.C12264eJ7.u) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.eJ7$u r0 = new ir.nasim.eJ7$u
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
            java.lang.Object r5 = r8.l()
            goto L57
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.OK7 r8 = r4.c
            int r5 = (int) r5
            java.lang.Integer r5 = ir.nasim.AbstractC6392Nk0.d(r5)
            java.lang.Integer[] r5 = new java.lang.Integer[]{r5}
            java.util.ArrayList r5 = ir.nasim.ZW0.g(r5)
            ir.nasim.Nv5 r5 = r8.w0(r5, r7)
            r0.c = r3
            r6 = 0
            java.lang.Object r5 = ir.nasim.AbstractC6756Ov5.d(r5, r6, r0, r3, r6)
            if (r5 != r1) goto L57
            return r1
        L57:
            boolean r6 = ir.nasim.C9475a16.j(r5)
            if (r6 == 0) goto L61
            ir.nasim.i18 r5 = (ir.nasim.C14505i18) r5
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
        L61:
            java.lang.Object r5 = ir.nasim.C9475a16.b(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12264eJ7.s(long, boolean, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC11621dJ7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object t(java.lang.String r6, boolean r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof ir.nasim.C12264eJ7.p
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.eJ7$p r0 = (ir.nasim.C12264eJ7.p) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.eJ7$p r0 = new ir.nasim.eJ7$p
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r8)
            goto L47
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.go1 r8 = ir.nasim.C12366eV1.b()
            ir.nasim.eJ7$q r2 = new ir.nasim.eJ7$q
            r4 = 0
            r2.<init>(r7, r6, r4)
            r0.c = r3
            java.lang.Object r8 = ir.nasim.AbstractC9323Zl0.g(r8, r2, r0)
            if (r8 != r1) goto L47
            return r1
        L47:
            ir.nasim.a16 r8 = (ir.nasim.C9475a16) r8
            java.lang.Object r6 = r8.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12264eJ7.t(java.lang.String, boolean, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC11621dJ7
    public Object u(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.a, new e(list, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }
}
