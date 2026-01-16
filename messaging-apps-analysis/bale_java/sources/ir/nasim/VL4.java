package ir.nasim;

import ai.bale.proto.OrganizationsOuterClass$RequestGetUserOrganizationalContacts;
import ai.bale.proto.OrganizationsOuterClass$ResponseGetUserOrganizationalContacts;
import ai.bale.proto.PeersStruct$UserOutPeer;
import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.C9475a16;
import ir.nasim.Z06;
import ir.nasim.core.network.RpcException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes4.dex */
public final class VL4 {
    private final C6287Mz a;
    private final OK7 b;
    private final AbstractC13778go1 c;
    private final C14375ho5 d;
    private final InterfaceC4308Eo5 e;
    private final Context f;
    private final InterfaceC20315ro1 g;

    static final class a extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objG = VL4.this.g(this);
            return objG == AbstractC14862ic3.e() ? objG : C9475a16.a(objG);
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;
        private /* synthetic */ Object f;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ VL4 c;
            final /* synthetic */ OrganizationsOuterClass$ResponseGetUserOrganizationalContacts d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(VL4 vl4, OrganizationsOuterClass$ResponseGetUserOrganizationalContacts organizationsOuterClass$ResponseGetUserOrganizationalContacts, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = vl4;
                this.d = organizationsOuterClass$ResponseGetUserOrganizationalContacts;
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
                    InterfaceC4308Eo5 interfaceC4308Eo5 = this.c.e;
                    List<PeersStruct$UserOutPeer> userPeersList = this.d.getUserPeersList();
                    AbstractC13042fc3.h(userPeersList, "getUserPeersList(...)");
                    List<PeersStruct$UserOutPeer> list = userPeersList;
                    ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(AbstractC6392Nk0.d(((PeersStruct$UserOutPeer) it.next()).getUid()));
                    }
                    this.b = 1;
                    if (interfaceC4308Eo5.f(arrayList, true, this) == objE) {
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

        /* renamed from: ir.nasim.VL4$b$b, reason: collision with other inner class name */
        static final class C0701b extends AbstractC19859r37 implements InterfaceC14603iB2 {
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
            int l;
            boolean m;
            int n;
            final /* synthetic */ VL4 o;
            final /* synthetic */ OrganizationsOuterClass$ResponseGetUserOrganizationalContacts p;
            final /* synthetic */ HE0 q;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0701b(VL4 vl4, OrganizationsOuterClass$ResponseGetUserOrganizationalContacts organizationsOuterClass$ResponseGetUserOrganizationalContacts, HE0 he0, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.o = vl4;
                this.p = organizationsOuterClass$ResponseGetUserOrganizationalContacts;
                this.q = he0;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C0701b(this.o, this.p, this.q, interfaceC20295rm1);
            }

            /* JADX WARN: Removed duplicated region for block: B:32:0x0129  */
            /* JADX WARN: Removed duplicated region for block: B:35:0x014d  */
            /* JADX WARN: Removed duplicated region for block: B:43:0x01b3  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0195 -> B:8:0x004b). Please report as a decompilation issue!!! */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r21) {
                /*
                    Method dump skipped, instructions count: 490
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.VL4.b.C0701b.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0701b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = VL4.this.new b(interfaceC20295rm1);
            bVar.f = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC20315ro1 interfaceC20315ro1;
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.e;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                interfaceC20315ro1 = (InterfaceC20315ro1) this.f;
                GeneratedMessageLite generatedMessageLiteA = OrganizationsOuterClass$RequestGetUserOrganizationalContacts.newBuilder().a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                OrganizationsOuterClass$ResponseGetUserOrganizationalContacts defaultInstance = OrganizationsOuterClass$ResponseGetUserOrganizationalContacts.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.organizations.v1.Organizations/GetUserOrganizationalContacts", generatedMessageLiteA, defaultInstance);
                C6287Mz c6287Mz = VL4.this.a;
                this.f = interfaceC20315ro1;
                this.e = 1;
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
                    objB = C9475a16.b((List) obj);
                    return C9475a16.a(objB);
                }
                interfaceC20315ro1 = (InterfaceC20315ro1) this.f;
                AbstractC10685c16.b(obj);
            }
            InterfaceC20315ro1 interfaceC20315ro12 = interfaceC20315ro1;
            Z06 z06 = (Z06) obj;
            VL4 vl4 = VL4.this;
            if (z06 instanceof Z06.a) {
                RpcException rpcExceptionA = ((Z06.a) z06).a();
                C9475a16.a aVar = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(rpcExceptionA));
                return C9475a16.a(objB);
            }
            if (!(z06 instanceof Z06.b)) {
                throw new NoWhenBranchMatchedException();
            }
            C9475a16.a aVar2 = C9475a16.b;
            OrganizationsOuterClass$ResponseGetUserOrganizationalContacts organizationsOuterClass$ResponseGetUserOrganizationalContacts = (OrganizationsOuterClass$ResponseGetUserOrganizationalContacts) ((Z06.b) z06).a();
            AbstractC10533bm0.d(vl4.g, null, null, new a(vl4, organizationsOuterClass$ResponseGetUserOrganizationalContacts, null), 3, null);
            this.f = interfaceC20315ro12;
            this.b = vl4;
            this.c = organizationsOuterClass$ResponseGetUserOrganizationalContacts;
            this.d = this;
            this.e = 2;
            IE0 ie0 = new IE0(AbstractC14251hc3.c(this), 1);
            ie0.w();
            AbstractC10533bm0.d(interfaceC20315ro12, null, null, new C0701b(vl4, organizationsOuterClass$ResponseGetUserOrganizationalContacts, ie0, null), 3, null);
            obj = ie0.t();
            if (obj == AbstractC14862ic3.e()) {
                WA1.c(this);
            }
            if (obj == objE) {
                return objE;
            }
            objB = C9475a16.b((List) obj);
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class c implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ VL4 b;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ VL4 b;

            /* renamed from: ir.nasim.VL4$c$a$a, reason: collision with other inner class name */
            public static final class C0702a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0702a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, VL4 vl4) {
                this.a = interfaceC4806Gq2;
                this.b = vl4;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r8, ir.nasim.InterfaceC20295rm1 r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof ir.nasim.VL4.c.a.C0702a
                    if (r0 == 0) goto L13
                    r0 = r9
                    ir.nasim.VL4$c$a$a r0 = (ir.nasim.VL4.c.a.C0702a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.VL4$c$a$a r0 = new ir.nasim.VL4$c$a$a
                    r0.<init>(r9)
                L18:
                    java.lang.Object r9 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r9)
                    goto L4e
                L29:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L31:
                    ir.nasim.AbstractC10685c16.b(r9)
                    ir.nasim.Gq2 r9 = r7.a
                    ir.nasim.PI7 r8 = (ir.nasim.PI7) r8
                    ir.nasim.VL4 r2 = r7.b
                    android.content.Context r2 = ir.nasim.VL4.b(r2)
                    r4 = 4
                    r5 = 0
                    r6 = 0
                    java.lang.String r8 = ir.nasim.C14593iA1.y(r2, r8, r6, r4, r5)
                    r0.b = r3
                    java.lang.Object r8 = r9.a(r8, r0)
                    if (r8 != r1) goto L4e
                    return r1
                L4e:
                    ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.VL4.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public c(InterfaceC4557Fq2 interfaceC4557Fq2, VL4 vl4) {
            this.a = interfaceC4557Fq2;
            this.b = vl4;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    static final class d extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return VL4.this.h(0, this);
        }
    }

    public VL4(C6287Mz c6287Mz, OK7 ok7, AbstractC13778go1 abstractC13778go1, C14375ho5 c14375ho5, InterfaceC4308Eo5 interfaceC4308Eo5, Context context, InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        AbstractC13042fc3.i(ok7, "usersModule");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(c14375ho5, "presenceModule");
        AbstractC13042fc3.i(interfaceC4308Eo5, "presenceRepository");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        this.a = c6287Mz;
        this.b = ok7;
        this.c = abstractC13778go1;
        this.d = c14375ho5;
        this.e = interfaceC4308Eo5;
        this.f = context;
        this.g = interfaceC20315ro1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(int r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof ir.nasim.VL4.d
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.VL4$d r0 = (ir.nasim.VL4.d) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.VL4$d r0 = new ir.nasim.VL4$d
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r7 = r0.a
            ir.nasim.VL4 r7 = (ir.nasim.VL4) r7
            ir.nasim.AbstractC10685c16.b(r8)
            goto L47
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.ho5 r8 = r6.d
            long r4 = (long) r7
            r0.a = r6
            r0.d = r3
            java.lang.Object r8 = r8.F(r4, r0)
            if (r8 != r1) goto L46
            return r1
        L46:
            r7 = r6
        L47:
            ir.nasim.Fq2 r8 = (ir.nasim.InterfaceC4557Fq2) r8
            ir.nasim.VL4$c r0 = new ir.nasim.VL4$c
            r0.<init>(r8, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.VL4.h(int, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.VL4.a
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.VL4$a r0 = (ir.nasim.VL4.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.VL4$a r0 = new ir.nasim.VL4$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r6)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.go1 r6 = r5.c
            ir.nasim.VL4$b r2 = new ir.nasim.VL4$b
            r4 = 0
            r2.<init>(r4)
            r0.c = r3
            java.lang.Object r6 = ir.nasim.AbstractC9323Zl0.g(r6, r2, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
            java.lang.Object r6 = r6.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.VL4.g(ir.nasim.rm1):java.lang.Object");
    }
}
