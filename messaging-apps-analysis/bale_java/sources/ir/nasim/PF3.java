package ir.nasim;

import ir.nasim.PF3;
import ir.nasim.core.modules.profile.entity.Avatar;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class PF3 {
    private final C8054Ui1 a;
    private final InterfaceC20315ro1 b;
    private final InterfaceC9173Yu3 c;
    private final InterfaceC9173Yu3 d;

    static final class a extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;

        /* renamed from: ir.nasim.PF3$a$a, reason: collision with other inner class name */
        public static final class C0571a implements Comparator {
            /* JADX WARN: Removed duplicated region for block: B:20:0x0060  */
            @Override // java.util.Comparator
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final int compare(java.lang.Object r10, java.lang.Object r11) {
                /*
                    r9 = this;
                    ir.nasim.Be1 r10 = (ir.nasim.C3512Be1) r10
                    ir.nasim.core.modules.profile.entity.Avatar r0 = r10.q()
                    r1 = 1
                    r2 = 0
                    r3 = 0
                    r5 = 10
                    if (r0 == 0) goto L60
                    ir.nasim.vD1 r0 = ir.nasim.C22426vD1.a
                    java.util.List r0 = r0.a()
                    java.lang.Iterable r0 = (java.lang.Iterable) r0
                    java.util.ArrayList r6 = new java.util.ArrayList
                    int r7 = ir.nasim.ZW0.x(r0, r5)
                    r6.<init>(r7)
                    java.util.Iterator r0 = r0.iterator()
                L23:
                    boolean r7 = r0.hasNext()
                    if (r7 == 0) goto L3b
                    java.lang.Object r7 = r0.next()
                    ir.nasim.dy r7 = (ir.nasim.C12056dy) r7
                    long r7 = r7.getFileId()
                    java.lang.Long r7 = java.lang.Long.valueOf(r7)
                    r6.add(r7)
                    goto L23
                L3b:
                    ir.nasim.core.modules.profile.entity.Avatar r10 = r10.q()
                    if (r10 == 0) goto L52
                    ir.nasim.core.modules.profile.entity.AvatarImage r10 = r10.getFullImage()
                    if (r10 == 0) goto L52
                    ir.nasim.core.modules.file.entity.FileReference r10 = r10.getFileReference()
                    if (r10 == 0) goto L52
                    long r7 = r10.getFileId()
                    goto L53
                L52:
                    r7 = r3
                L53:
                    java.lang.Long r10 = java.lang.Long.valueOf(r7)
                    boolean r10 = r6.contains(r10)
                    if (r10 == 0) goto L5e
                    goto L60
                L5e:
                    r10 = r2
                    goto L61
                L60:
                    r10 = r1
                L61:
                    java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
                    ir.nasim.Be1 r11 = (ir.nasim.C3512Be1) r11
                    ir.nasim.core.modules.profile.entity.Avatar r0 = r11.q()
                    if (r0 == 0) goto Lbc
                    ir.nasim.vD1 r0 = ir.nasim.C22426vD1.a
                    java.util.List r0 = r0.a()
                    java.lang.Iterable r0 = (java.lang.Iterable) r0
                    java.util.ArrayList r6 = new java.util.ArrayList
                    int r5 = ir.nasim.ZW0.x(r0, r5)
                    r6.<init>(r5)
                    java.util.Iterator r0 = r0.iterator()
                L82:
                    boolean r5 = r0.hasNext()
                    if (r5 == 0) goto L9a
                    java.lang.Object r5 = r0.next()
                    ir.nasim.dy r5 = (ir.nasim.C12056dy) r5
                    long r7 = r5.getFileId()
                    java.lang.Long r5 = java.lang.Long.valueOf(r7)
                    r6.add(r5)
                    goto L82
                L9a:
                    ir.nasim.core.modules.profile.entity.Avatar r11 = r11.q()
                    if (r11 == 0) goto Lb0
                    ir.nasim.core.modules.profile.entity.AvatarImage r11 = r11.getFullImage()
                    if (r11 == 0) goto Lb0
                    ir.nasim.core.modules.file.entity.FileReference r11 = r11.getFileReference()
                    if (r11 == 0) goto Lb0
                    long r3 = r11.getFileId()
                Lb0:
                    java.lang.Long r11 = java.lang.Long.valueOf(r3)
                    boolean r11 = r6.contains(r11)
                    if (r11 == 0) goto Lbb
                    goto Lbc
                Lbb:
                    r1 = r2
                Lbc:
                    java.lang.Boolean r11 = java.lang.Boolean.valueOf(r1)
                    int r10 = ir.nasim.AbstractC16868m01.d(r10, r11)
                    return r10
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.PF3.a.C0571a.compare(java.lang.Object, java.lang.Object):int");
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object next;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            List list = (List) this.c;
            List list2 = (List) this.d;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                if (!((C3512Be1) obj2).s()) {
                    arrayList.add(obj2);
                }
            }
            List listA1 = AbstractC15401jX0.a1(arrayList, new C0571a());
            ArrayList arrayList2 = new ArrayList();
            if (listA1.isEmpty()) {
                return new QI4(AbstractC10360bX0.m(), 0);
            }
            List<C3512Be1> list3 = listA1;
            Iterator it = list3.iterator();
            while (true) {
                Object obj3 = null;
                if (!it.hasNext()) {
                    break;
                }
                C3512Be1 c3512Be1 = (C3512Be1) it.next();
                if (arrayList2.size() != 5) {
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj4 : list2) {
                        if (!((C14755iQ6) obj4).b()) {
                            arrayList3.add(obj4);
                        }
                    }
                    Iterator it2 = arrayList3.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        Object next2 = it2.next();
                        if (((C14755iQ6) next2).a().getPeerId() == c3512Be1.r()) {
                            obj3 = next2;
                            break;
                        }
                    }
                    if (((C14755iQ6) obj3) != null) {
                        int iR = c3512Be1.r();
                        Avatar avatarQ = c3512Be1.q();
                        String name = c3512Be1.getName();
                        AbstractC13042fc3.h(name, "getName(...)");
                        arrayList2.add(new PI4(iR, 0L, avatarQ, true, name));
                    }
                }
            }
            if (arrayList2.size() < 5) {
                for (C3512Be1 c3512Be12 : list3) {
                    if (arrayList2.size() != 5) {
                        Iterator it3 = list2.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it3.next();
                            if (((C14755iQ6) next).a().getPeerId() == c3512Be12.r()) {
                                break;
                            }
                        }
                        if (((C14755iQ6) next) == null) {
                            int iR2 = c3512Be12.r();
                            Avatar avatarQ2 = c3512Be12.q();
                            String name2 = c3512Be12.getName();
                            AbstractC13042fc3.h(name2, "getName(...)");
                            arrayList2.add(new PI4(iR2, 0L, avatarQ2, false, name2));
                        }
                    }
                }
            }
            return new QI4(arrayList2, listA1.size());
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(List list, List list2, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(interfaceC20295rm1);
            aVar.c = list;
            aVar.d = list2;
            return aVar.invokeSuspend(C19938rB7.a);
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        public static final class a implements FB3 {
            final /* synthetic */ InterfaceC16204ks5 a;
            final /* synthetic */ PF3 b;

            a(InterfaceC16204ks5 interfaceC16204ks5, PF3 pf3) {
                this.a = interfaceC16204ks5;
                this.b = pf3;
            }

            @Override // ir.nasim.FB3
            public void b() {
                InterfaceC16204ks5 interfaceC16204ks5 = this.a;
                List listK = this.b.f().k();
                if (listK == null) {
                    listK = AbstractC10360bX0.m();
                }
                interfaceC16204ks5.h(listK);
            }

            @Override // ir.nasim.FB3
            public void c(List list) {
                InterfaceC16204ks5 interfaceC16204ks5 = this.a;
                List listK = this.b.f().k();
                if (listK == null) {
                    listK = AbstractC10360bX0.m();
                }
                interfaceC16204ks5.h(listK);
            }

            @Override // ir.nasim.FB3
            public void d(List list) {
                InterfaceC16204ks5 interfaceC16204ks5 = this.a;
                List listK = this.b.f().k();
                if (listK == null) {
                    listK = AbstractC10360bX0.m();
                }
                interfaceC16204ks5.h(listK);
            }

            @Override // ir.nasim.FB3
            public void e(long j) {
                InterfaceC16204ks5 interfaceC16204ks5 = this.a;
                List listK = this.b.f().k();
                if (listK == null) {
                    listK = AbstractC10360bX0.m();
                }
                interfaceC16204ks5.h(listK);
            }

            @Override // ir.nasim.FB3
            public void f(long[] jArr) {
                InterfaceC16204ks5 interfaceC16204ks5 = this.a;
                List listK = this.b.f().k();
                if (listK == null) {
                    listK = AbstractC10360bX0.m();
                }
                interfaceC16204ks5.h(listK);
            }

            @Override // ir.nasim.FB3
            public void g(List list, EnumC24659yz5 enumC24659yz5) {
                InterfaceC16204ks5 interfaceC16204ks5 = this.a;
                List listK = this.b.f().k();
                if (listK == null) {
                    listK = AbstractC10360bX0.m();
                }
                interfaceC16204ks5.h(listK);
            }

            @Override // ir.nasim.FB3
            /* renamed from: h, reason: merged with bridge method [inline-methods] */
            public void a(C3512Be1 c3512Be1) {
                InterfaceC16204ks5 interfaceC16204ks5 = this.a;
                List listK = this.b.f().k();
                if (listK == null) {
                    listK = AbstractC10360bX0.m();
                }
                interfaceC16204ks5.h(listK);
            }
        }

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(PF3 pf3, a aVar) {
            pf3.f().n(aVar);
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = PF3.this.new b(interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC16204ks5 interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                if (PF3.this.f().k() != null) {
                    List listK = PF3.this.f().k();
                    if (listK == null) {
                        listK = AbstractC10360bX0.m();
                    }
                    interfaceC16204ks5.h(listK);
                }
                final a aVar = new a(interfaceC16204ks5, PF3.this);
                PF3.this.f().j(aVar);
                final PF3 pf3 = PF3.this;
                SA2 sa2 = new SA2() { // from class: ir.nasim.QF3
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return PF3.b.y(pf3, aVar);
                    }
                };
                this.b = 1;
                if (AbstractC13822gs5.a(interfaceC16204ks5, sa2, this) == objE) {
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
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public PF3(C8054Ui1 c8054Ui1) {
        AbstractC13042fc3.i(c8054Ui1, "contactsModule");
        this.a = c8054Ui1;
        this.b = AbstractC20906so1.a(C12366eV1.a().X(P17.b(null, 1, null)));
        this.c = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.NF3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return PF3.d(this.a);
            }
        });
        this.d = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.OF3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return PF3.h(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC10258bL6 d(PF3 pf3) {
        AbstractC13042fc3.i(pf3, "this$0");
        return AbstractC6459Nq2.o0(pf3.i(), pf3.b, InterfaceC16863lz6.a.c(), AbstractC10360bX0.m());
    }

    private final InterfaceC4557Fq2 e() {
        return (InterfaceC4557Fq2) this.c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WK f() {
        return (WK) this.d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WK h(PF3 pf3) {
        AbstractC13042fc3.i(pf3, "this$0");
        DB3 db3M0 = pf3.a.m0();
        AbstractC13042fc3.g(db3M0, "null cannot be cast to non-null type ir.nasim.core.runtime.storage.AsyncListEngine<ir.nasim.core.modules.contacts.entity.Contact>");
        return (WK) db3M0;
    }

    private final InterfaceC4557Fq2 i() {
        return AbstractC6459Nq2.V(AbstractC6459Nq2.f(new b(null)), C12366eV1.b());
    }

    public final InterfaceC4557Fq2 g() {
        return AbstractC6459Nq2.V(AbstractC6459Nq2.p(e(), InterfaceC23301wh3.a.a().a(), new a(null)), C12366eV1.a());
    }
}
