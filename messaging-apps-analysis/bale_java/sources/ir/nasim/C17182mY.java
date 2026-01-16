package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C22023uY;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.database.entity.ContactEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.mY, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C17182mY implements ir.nasim.contact.data.d {
    private final C9864ah1 b;
    private final InterfaceC6118Mg1 c;
    private final OK7 d;
    private final AbstractC13778go1 e;
    private final int f;
    private final String g;
    private final boolean h;
    private final String i;
    private final EnumC4715Gg1 j;
    private final InterfaceC9173Yu3 k;

    /* renamed from: ir.nasim.mY$a */
    public interface a {
        C17182mY a(String str, boolean z, String str2, EnumC4715Gg1 enumC4715Gg1);
    }

    /* renamed from: ir.nasim.mY$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;
        private /* synthetic */ Object f;
        final /* synthetic */ int h;
        final /* synthetic */ int i;

        /* renamed from: ir.nasim.mY$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C17182mY c;
            final /* synthetic */ List d;
            final /* synthetic */ HE0 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C17182mY c17182mY, List list, HE0 he0, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c17182mY;
                this.d = list;
                this.e = he0;
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
                    OK7 ok7 = this.c.d;
                    List list = this.d;
                    ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(AbstractC6392Nk0.d(((ContactEntity) it.next()).getId()));
                    }
                    C6517Nv5 c6517Nv5W0 = ok7.w0(arrayList, false);
                    this.b = 1;
                    objD = AbstractC6756Ov5.d(c6517Nv5W0, null, this, 1, null);
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
                HE0 he0 = this.e;
                List list2 = this.d;
                if (C9475a16.j(objD)) {
                    List<ContactEntity> list3 = list2;
                    ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list3, 10));
                    for (ContactEntity contactEntity : list3) {
                        int id = contactEntity.getId();
                        String name = contactEntity.getName();
                        Avatar avatarA = AbstractC18364oY.a(contactEntity);
                        arrayList2.add(new C22023uY(id, name, avatarA != null ? new C22023uY.a.C1635a(avatarA) : null, contactEntity.isBot(), null, 16, null));
                    }
                    AbstractC24549yo1.c(he0, arrayList2);
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
        b(int i, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.h = i;
            this.i = i2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = C17182mY.this.new b(this.h, this.i, interfaceC20295rm1);
            bVar.f = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC20315ro1 interfaceC20315ro1;
            Object objE = AbstractC14862ic3.e();
            int i = this.e;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                interfaceC20315ro1 = (InterfaceC20315ro1) this.f;
                InterfaceC6118Mg1 interfaceC6118Mg1 = C17182mY.this.c;
                String str = C17182mY.this.g;
                EnumC4715Gg1 enumC4715Gg1 = C17182mY.this.j;
                int i2 = this.h;
                int i3 = this.i;
                this.f = interfaceC20315ro1;
                this.e = 1;
                obj = interfaceC6118Mg1.a(str, enumC4715Gg1, i2, i3, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return (List) obj;
                }
                interfaceC20315ro1 = (InterfaceC20315ro1) this.f;
                AbstractC10685c16.b(obj);
            }
            InterfaceC20315ro1 interfaceC20315ro12 = interfaceC20315ro1;
            C17182mY c17182mY = C17182mY.this;
            List list = (List) obj;
            this.f = interfaceC20315ro12;
            this.b = c17182mY;
            this.c = list;
            this.d = this;
            this.e = 2;
            IE0 ie0 = new IE0(AbstractC14251hc3.c(this), 1);
            ie0.w();
            AbstractC10533bm0.d(interfaceC20315ro12, null, null, new a(c17182mY, list, ie0, null), 3, null);
            obj = ie0.t();
            if (obj == AbstractC14862ic3.e()) {
                WA1.c(this);
            }
            if (obj == objE) {
                return objE;
            }
            return (List) obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.mY$c */
    static final class c extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C17182mY.this.m(this);
        }
    }

    /* renamed from: ir.nasim.mY$d */
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
            return C17182mY.this.o(0, null, this);
        }
    }

    /* renamed from: ir.nasim.mY$e */
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
            return C17182mY.this.q(null, this);
        }
    }

    /* renamed from: ir.nasim.mY$f */
    static final class f extends AbstractC22163um1 {
        Object a;
        int b;
        /* synthetic */ Object c;
        int e;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C17182mY.this.a(0, 0, this);
        }
    }

    public C17182mY(final C8054Ui1 c8054Ui1, C9864ah1 c9864ah1, InterfaceC6118Mg1 interfaceC6118Mg1, OK7 ok7, AbstractC13778go1 abstractC13778go1, int i, String str, boolean z, String str2, EnumC4715Gg1 enumC4715Gg1) {
        AbstractC13042fc3.i(c8054Ui1, "contactsModule");
        AbstractC13042fc3.i(c9864ah1, "mapper");
        AbstractC13042fc3.i(interfaceC6118Mg1, "contactRepository");
        AbstractC13042fc3.i(ok7, "usersModule");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(str2, "savedMessagesName");
        AbstractC13042fc3.i(enumC4715Gg1, "sortType");
        this.b = c9864ah1;
        this.c = interfaceC6118Mg1;
        this.d = ok7;
        this.e = abstractC13778go1;
        this.f = i;
        this.g = str;
        this.h = z;
        this.i = str2;
        this.j = enumC4715Gg1;
        this.k = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.kY
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C17182mY.r(c8054Ui1);
            }
        });
    }

    private final Object k(int i, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.e, new b(i, i2, null), interfaceC20295rm1);
    }

    private final WK l() {
        return (WK) this.k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(ir.nasim.InterfaceC20295rm1 r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof ir.nasim.C17182mY.c
            if (r0 == 0) goto L13
            r0 = r10
            ir.nasim.mY$c r0 = (ir.nasim.C17182mY.c) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.mY$c r0 = new ir.nasim.mY$c
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.a
            ir.nasim.mY r0 = (ir.nasim.C17182mY) r0
            ir.nasim.AbstractC10685c16.b(r10)
            goto L44
        L2d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L35:
            ir.nasim.AbstractC10685c16.b(r10)
            r0.a = r9
            r0.d = r3
            java.lang.Object r10 = r9.n(r0)
            if (r10 != r1) goto L43
            return r1
        L43:
            r0 = r9
        L44:
            r1 = r10
            ir.nasim.uY r1 = (ir.nasim.C22023uY) r1
            if (r1 == 0) goto L5d
            java.lang.String r3 = r0.i
            ir.nasim.uY$a$b r4 = new ir.nasim.uY$a$b
            int r10 = ir.nasim.KB5.ic_saved_message
            r4.<init>(r10)
            r7 = 17
            r8 = 0
            r2 = 0
            r5 = 0
            r6 = 0
            ir.nasim.uY r10 = ir.nasim.C22023uY.b(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L5e
        L5d:
            r10 = 0
        L5e:
            if (r10 == 0) goto L66
            java.util.List r10 = ir.nasim.ZW0.e(r10)
            if (r10 != 0) goto L6a
        L66:
            java.util.List r10 = ir.nasim.ZW0.m()
        L6a:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17182mY.m(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(int r6, java.util.List r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof ir.nasim.C17182mY.d
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.mY$d r0 = (ir.nasim.C17182mY.d) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.mY$d r0 = new ir.nasim.mY$d
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r6 = r0.a
            java.util.List r6 = (java.util.List) r6
            ir.nasim.AbstractC10685c16.b(r8)
            goto L84
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            java.lang.Object r6 = r0.b
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r0.a
            ir.nasim.mY r7 = (ir.nasim.C17182mY) r7
            ir.nasim.AbstractC10685c16.b(r8)
            goto L6e
        L44:
            ir.nasim.AbstractC10685c16.b(r8)
            java.lang.String r8 = r5.g
            if (r8 == 0) goto L8e
            boolean r8 = ir.nasim.AbstractC14836iZ6.n0(r8)
            if (r8 == 0) goto L52
            goto L8e
        L52:
            ir.nasim.iY r8 = new ir.nasim.iY
            r8.<init>()
            java.util.List r7 = r5.s(r7, r8)
            if (r6 != 0) goto L8e
            java.lang.String r6 = r5.g
            r0.a = r5
            r0.b = r7
            r0.e = r4
            java.lang.Object r8 = r5.q(r6, r0)
            if (r8 != r1) goto L6c
            return r1
        L6c:
            r6 = r7
            r7 = r5
        L6e:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L8d
            r0.a = r6
            r8 = 0
            r0.b = r8
            r0.e = r3
            java.lang.Object r8 = r7.m(r0)
            if (r8 != r1) goto L84
            return r1
        L84:
            java.util.Collection r8 = (java.util.Collection) r8
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.List r7 = ir.nasim.ZW0.R0(r8, r6)
            goto L8e
        L8d:
            r7 = r6
        L8e:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17182mY.o(int, java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p(C17182mY c17182mY, C22023uY c22023uY) {
        AbstractC13042fc3.i(c17182mY, "this$0");
        AbstractC13042fc3.i(c22023uY, "it");
        return c22023uY.c() == c17182mY.f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q(java.lang.String r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ir.nasim.C17182mY.e
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.mY$e r0 = (ir.nasim.C17182mY.e) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.mY$e r0 = new ir.nasim.mY$e
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.b
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r0 = r0.a
            ir.nasim.mY r0 = (ir.nasim.C17182mY) r0
            ir.nasim.AbstractC10685c16.b(r6)
            goto L4a
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            ir.nasim.AbstractC10685c16.b(r6)
            r0.a = r4
            r0.b = r5
            r0.e = r3
            java.lang.Object r6 = r4.n(r0)
            if (r6 != r1) goto L49
            return r1
        L49:
            r0 = r4
        L4a:
            ir.nasim.uY r6 = (ir.nasim.C22023uY) r6
            r1 = 0
            if (r6 == 0) goto L5a
            java.lang.String r6 = r6.e()
            if (r6 == 0) goto L5a
            boolean r6 = ir.nasim.AbstractC14836iZ6.V(r6, r5, r3)
            goto L5b
        L5a:
            r6 = r1
        L5b:
            if (r6 != 0) goto L67
            java.lang.String r6 = r0.i
            boolean r5 = ir.nasim.AbstractC14836iZ6.V(r6, r5, r3)
            if (r5 == 0) goto L66
            goto L67
        L66:
            r3 = r1
        L67:
            java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17182mY.q(java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WK r(C8054Ui1 c8054Ui1) {
        AbstractC13042fc3.i(c8054Ui1, "$contactsModule");
        DB3 db3M0 = c8054Ui1.m0();
        AbstractC13042fc3.g(db3M0, "null cannot be cast to non-null type ir.nasim.core.runtime.storage.AsyncListEngine<ir.nasim.core.modules.contacts.entity.Contact>");
        return (WK) db3M0;
    }

    private final List s(List list, UA2 ua2) {
        Iterator it = list.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (((Boolean) ua2.invoke(it.next())).booleanValue()) {
                break;
            }
            i++;
        }
        if (i == -1) {
            return list;
        }
        List listP1 = AbstractC15401jX0.p1(list);
        listP1.remove(i);
        return listP1;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.contact.data.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(int r6, int r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof ir.nasim.C17182mY.f
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.mY$f r0 = (ir.nasim.C17182mY.f) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.mY$f r0 = new ir.nasim.mY$f
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            ir.nasim.AbstractC10685c16.b(r8)
            goto L61
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            int r6 = r0.b
            java.lang.Object r7 = r0.a
            ir.nasim.mY r7 = (ir.nasim.C17182mY) r7
            ir.nasim.AbstractC10685c16.b(r8)
            goto L4f
        L3e:
            ir.nasim.AbstractC10685c16.b(r8)
            r0.a = r5
            r0.b = r6
            r0.e = r4
            java.lang.Object r8 = r5.k(r6, r7, r0)
            if (r8 != r1) goto L4e
            return r1
        L4e:
            r7 = r5
        L4f:
            java.util.List r8 = (java.util.List) r8
            boolean r2 = r7.h
            if (r2 == 0) goto L61
            r2 = 0
            r0.a = r2
            r0.e = r3
            java.lang.Object r8 = r7.o(r6, r8, r0)
            if (r8 != r1) goto L61
            return r1
        L61:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17182mY.a(int, int, ir.nasim.rm1):java.lang.Object");
    }

    public final Object n(InterfaceC20295rm1 interfaceC20295rm1) {
        C3512Be1 c3512Be1 = (C3512Be1) l().a(this.f);
        if (c3512Be1 == null) {
            return null;
        }
        return this.b.a(c3512Be1, interfaceC20295rm1);
    }
}
