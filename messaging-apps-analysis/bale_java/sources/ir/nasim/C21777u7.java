package ir.nasim;

import ai.bale.proto.AdvertisementStruct$BaleSponsoredMessageAd;
import ai.bale.proto.AdvertisementStruct$IncomeReport;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.settings.SettingsModule;
import java.util.Collection;
import java.util.List;

/* renamed from: ir.nasim.u7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21777u7 implements InterfaceC21103t7 {
    private final C20500s7 a;
    private final SettingsModule b;
    private final InterfaceC12532em2 c;
    private final C9615aG2 d;
    private final C17694nP1 e;
    private final C15281jJ6 f;
    private final AbstractC13778go1 g;
    private VI5 h;

    /* renamed from: ir.nasim.u7$a */
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
            Object objD = C21777u7.this.d(0, this);
            return objD == AbstractC14862ic3.e() ? objD : C9475a16.a(objD);
        }
    }

    /* renamed from: ir.nasim.u7$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        private /* synthetic */ Object d;
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.f = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = C21777u7.this.new b(this.f, interfaceC20295rm1);
            bVar.d = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC20315ro1 interfaceC20315ro1;
            List list;
            Object objA;
            String name;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            boolean z = true;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                interfaceC20315ro1 = (InterfaceC20315ro1) this.d;
                C45 c45 = new C45();
                List listP = c45.x() == 1 ? AbstractC10360bX0.p(AbstractC4616Fw7.a(AbstractC6392Nk0.d(c45.y()), AbstractC6392Nk0.d(c45.x())), AbstractC4616Fw7.a(AbstractC6392Nk0.d(c45.y() - 1), AbstractC6392Nk0.d(12))) : AbstractC10360bX0.p(AbstractC4616Fw7.a(AbstractC6392Nk0.d(c45.y()), AbstractC6392Nk0.d(c45.x())), AbstractC4616Fw7.a(AbstractC6392Nk0.d(c45.y()), AbstractC6392Nk0.d(c45.x() - 1)));
                C20500s7 c20500s7 = C21777u7.this.a;
                int i2 = this.f;
                this.d = interfaceC20315ro1;
                this.b = listP;
                this.c = 1;
                Object objE2 = c20500s7.e(i2, this);
                if (objE2 == objE) {
                    return objE;
                }
                list = listP;
                objA = objE2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list = (List) this.b;
                interfaceC20315ro1 = (InterfaceC20315ro1) this.d;
                AbstractC10685c16.b(obj);
                objA = ((C9475a16) obj).l();
            }
            if (C9475a16.j(objA)) {
                List<AdvertisementStruct$IncomeReport> list2 = (List) objA;
                if ((list2 instanceof Collection) && list2.isEmpty()) {
                    z = false;
                    objA = AbstractC6392Nk0.a(z);
                } else {
                    for (AdvertisementStruct$IncomeReport advertisementStruct$IncomeReport : list2) {
                        boolean zContains = list.contains(AbstractC4616Fw7.a(AbstractC6392Nk0.d(advertisementStruct$IncomeReport.getYear()), AbstractC6392Nk0.d(advertisementStruct$IncomeReport.getMonth())));
                        boolean z2 = advertisementStruct$IncomeReport.getState() != EnumC16679lh.IncomeState_RECEIVED;
                        if (zContains && z2) {
                            break;
                        }
                    }
                    z = false;
                    objA = AbstractC6392Nk0.a(z);
                }
            }
            Object objB = C9475a16.b(objA);
            Throwable thE = C9475a16.e(objB);
            if (thE != null) {
                if (interfaceC20315ro1.getClass().isAnonymousClass()) {
                    name = interfaceC20315ro1.getClass().getName();
                    int length = name.length();
                    AbstractC13042fc3.f(name);
                    if (length > 23) {
                        name = name.substring(name.length() - 23, name.length());
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                } else {
                    name = interfaceC20315ro1.getClass().getSimpleName();
                    int length2 = name.length();
                    AbstractC13042fc3.f(name);
                    if (length2 > 23) {
                        name = name.substring(0, 23);
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                }
                C19406qI3.d(name, thE);
            }
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.u7$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21777u7.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws NumberFormatException {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (!C8386Vt0.p5()) {
                    return null;
                }
                C21777u7 c21777u7 = C21777u7.this;
                String strA1 = c21777u7.b.a1();
                this.b = 1;
                obj = c21777u7.n(strA1, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return (C23564x80) obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.u7$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21777u7.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws NumberFormatException {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (!C8386Vt0.M3() || C21777u7.this.b.L1() >= 3 || C21777u7.this.b.J1()) {
                    return null;
                }
                C21777u7 c21777u7 = C21777u7.this;
                String strK1 = c21777u7.b.K1();
                this.b = 1;
                obj = c21777u7.n(strK1, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return (C23564x80) obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.u7$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ FileReference d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(FileReference fileReference, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = fileReference;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21777u7.this.new e(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C20500s7 c20500s7 = C21777u7.this.a;
                FileReference fileReference = this.d;
                this.b = 1;
                obj = c20500s7.b(fileReference, this);
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
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.u7$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.u7$f$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C21777u7 a;
            final /* synthetic */ InterfaceC4806Gq2 b;

            /* renamed from: ir.nasim.u7$f$a$a, reason: collision with other inner class name */
            static final class C1622a extends AbstractC22163um1 {
                Object a;
                Object b;
                /* synthetic */ Object c;
                int e;

                C1622a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.c = obj;
                    this.e |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            a(C21777u7 c21777u7, InterfaceC4806Gq2 interfaceC4806Gq2) {
                this.a = c21777u7;
                this.b = interfaceC4806Gq2;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(ir.nasim.C19938rB7 r5, ir.nasim.InterfaceC20295rm1 r6) {
                /*
                    r4 = this;
                    boolean r5 = r6 instanceof ir.nasim.C21777u7.f.a.C1622a
                    if (r5 == 0) goto L13
                    r5 = r6
                    ir.nasim.u7$f$a$a r5 = (ir.nasim.C21777u7.f.a.C1622a) r5
                    int r0 = r5.e
                    r1 = -2147483648(0xffffffff80000000, float:-0.0)
                    r2 = r0 & r1
                    if (r2 == 0) goto L13
                    int r0 = r0 - r1
                    r5.e = r0
                    goto L18
                L13:
                    ir.nasim.u7$f$a$a r5 = new ir.nasim.u7$f$a$a
                    r5.<init>(r6)
                L18:
                    java.lang.Object r6 = r5.c
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r5.e
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L40
                    if (r1 == r3) goto L34
                    if (r1 != r2) goto L2c
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L73
                L2c:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L34:
                    java.lang.Object r1 = r5.b
                    ir.nasim.nP1 r1 = (ir.nasim.C17694nP1) r1
                    java.lang.Object r3 = r5.a
                    ir.nasim.u7$f$a r3 = (ir.nasim.C21777u7.f.a) r3
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L5d
                L40:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.u7 r6 = r4.a
                    ir.nasim.nP1 r1 = ir.nasim.C21777u7.i(r6)
                    ir.nasim.u7 r6 = r4.a
                    ir.nasim.s7 r6 = ir.nasim.C21777u7.h(r6)
                    r5.a = r4
                    r5.b = r1
                    r5.e = r3
                    java.lang.Object r6 = r6.c(r5)
                    if (r6 != r0) goto L5c
                    return r0
                L5c:
                    r3 = r4
                L5d:
                    java.util.List r6 = (java.util.List) r6
                    java.util.List r6 = r1.a(r6)
                    ir.nasim.Gq2 r1 = r3.b
                    r3 = 0
                    r5.a = r3
                    r5.b = r3
                    r5.e = r2
                    java.lang.Object r5 = r1.a(r6, r5)
                    if (r5 != r0) goto L73
                    return r0
                L73:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21777u7.f.a.a(ir.nasim.rB7, ir.nasim.rm1):java.lang.Object");
            }
        }

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = C21777u7.this.new f(interfaceC20295rm1);
            fVar.c = obj;
            return fVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC4557Fq2 interfaceC4557Fq2R;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                if (C21777u7.this.h == null) {
                    C21777u7.this.h = AbstractC3851Cp7.f(r4.b.M1() * 1000, 0L, null, null, 12, null);
                }
                VI5 vi5 = C21777u7.this.h;
                if (vi5 != null && (interfaceC4557Fq2R = AbstractC6459Nq2.r(vi5)) != null) {
                    a aVar = new a(C21777u7.this, interfaceC4806Gq2);
                    this.b = 1;
                    if (interfaceC4557Fq2R.b(aVar, this) == objE) {
                        return objE;
                    }
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
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.u7$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;
        final /* synthetic */ boolean e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(int i, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21777u7.this.new g(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C20500s7 c20500s7 = C21777u7.this.a;
                int i2 = this.d;
                boolean z = this.e;
                this.b = 1;
                obj = c20500s7.d(i2, z, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            AdvertisementStruct$BaleSponsoredMessageAd advertisementStruct$BaleSponsoredMessageAd = (AdvertisementStruct$BaleSponsoredMessageAd) obj;
            if (advertisementStruct$BaleSponsoredMessageAd != null) {
                return C21777u7.this.f.a(advertisementStruct$BaleSponsoredMessageAd);
            }
            return null;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.u7$h */
    static final class h extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objF = C21777u7.this.f(0, this);
            return objF == AbstractC14862ic3.e() ? objF : C9475a16.a(objF);
        }
    }

    /* renamed from: ir.nasim.u7$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            i iVar = C21777u7.this.new i(this.e, interfaceC20295rm1);
            iVar.c = obj;
            return iVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC20315ro1 interfaceC20315ro1;
            Object objL;
            String name;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro12 = (InterfaceC20315ro1) this.c;
                C20500s7 c20500s7 = C21777u7.this.a;
                int i2 = this.e;
                this.c = interfaceC20315ro12;
                this.b = 1;
                Object objF = c20500s7.f(i2, this);
                if (objF == objE) {
                    return objE;
                }
                interfaceC20315ro1 = interfaceC20315ro12;
                objL = objF;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                AbstractC10685c16.b(obj);
                objL = ((C9475a16) obj).l();
            }
            Throwable thE = C9475a16.e(objL);
            if (thE != null) {
                if (interfaceC20315ro1.getClass().isAnonymousClass()) {
                    name = interfaceC20315ro1.getClass().getName();
                    int length = name.length();
                    AbstractC13042fc3.f(name);
                    if (length > 23) {
                        name = name.substring(name.length() - 23, name.length());
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                } else {
                    name = interfaceC20315ro1.getClass().getSimpleName();
                    int length2 = name.length();
                    AbstractC13042fc3.f(name);
                    if (length2 > 23) {
                        name = name.substring(0, 23);
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                }
                C19406qI3.d(name, thE);
            }
            return C9475a16.a(objL);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.u7$j */
    static final class j extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C21777u7.this.n(null, this);
        }
    }

    public C21777u7(C20500s7 c20500s7, SettingsModule settingsModule, InterfaceC12532em2 interfaceC12532em2, C9615aG2 c9615aG2, C17694nP1 c17694nP1, C15281jJ6 c15281jJ6, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(c20500s7, "adRemoteDataSource");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(interfaceC12532em2, "fileRepository");
        AbstractC13042fc3.i(c9615aG2, "getLinkActionUseCase");
        AbstractC13042fc3.i(c17694nP1, "dialogPinAdMapper");
        AbstractC13042fc3.i(c15281jJ6, "sponsoredMessageAdMapper");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = c20500s7;
        this.b = settingsModule;
        this.c = interfaceC12532em2;
        this.d = c9615aG2;
        this.e = c17694nP1;
        this.f = c15281jJ6;
        this.g = abstractC13778go1;
    }

    @Override // ir.nasim.InterfaceC21103t7
    public InterfaceC4557Fq2 a() {
        return AbstractC6459Nq2.V(AbstractC6459Nq2.R(new f(null)), this.g);
    }

    @Override // ir.nasim.InterfaceC21103t7
    public Object b(FileReference fileReference, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.g, new e(fileReference, null), interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC21103t7
    public Object c(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.g, new d(null), interfaceC20295rm1);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC21103t7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(int r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.C21777u7.a
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.u7$a r0 = (ir.nasim.C21777u7.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.u7$a r0 = new ir.nasim.u7$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r7)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.go1 r7 = r5.g
            ir.nasim.u7$b r2 = new ir.nasim.u7$b
            r4 = 0
            r2.<init>(r6, r4)
            r0.c = r3
            java.lang.Object r7 = ir.nasim.AbstractC9323Zl0.g(r7, r2, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            java.lang.Object r6 = r7.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21777u7.d(int, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC21103t7
    public Object e(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.g, new c(null), interfaceC20295rm1);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC21103t7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(int r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.C21777u7.h
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.u7$h r0 = (ir.nasim.C21777u7.h) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.u7$h r0 = new ir.nasim.u7$h
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r7)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.go1 r7 = r5.g
            ir.nasim.u7$i r2 = new ir.nasim.u7$i
            r4 = 0
            r2.<init>(r6, r4)
            r0.c = r3
            java.lang.Object r7 = ir.nasim.AbstractC9323Zl0.g(r7, r2, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            java.lang.Object r6 = r7.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21777u7.f(int, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC21103t7
    public Object g(int i2, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.g, new g(i2, z, null), interfaceC20295rm1);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(java.lang.String r22, ir.nasim.InterfaceC20295rm1 r23) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21777u7.n(java.lang.String, ir.nasim.rm1):java.lang.Object");
    }
}
