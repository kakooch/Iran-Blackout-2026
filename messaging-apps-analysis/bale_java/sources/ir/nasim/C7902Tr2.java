package ir.nasim;

import ir.nasim.database.dailogLists.DialogFolderAssociationEntity;
import ir.nasim.database.dailogLists.DialogFolderEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Tr2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7902Tr2 implements InterfaceC7663Sr2 {
    private final ir.nasim.database.dailogLists.c a;
    private final InterfaceC20315ro1 b;
    private final AbstractC13778go1 c;
    private final InterfaceC20667sP1 d;

    /* renamed from: ir.nasim.Tr2$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ F92 a = G92.a(EnumC7296Rc4.values());
    }

    /* renamed from: ir.nasim.Tr2$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;
        final /* synthetic */ int e;
        final /* synthetic */ String f;
        final /* synthetic */ List g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i, int i2, String str, List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = i2;
            this.f = str;
            this.g = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C7902Tr2.this.new b(this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (C7902Tr2.this.m().contains(AbstractC6392Nk0.d(this.d))) {
                    ir.nasim.database.dailogLists.c cVar = C7902Tr2.this.a;
                    int i2 = this.d;
                    int i3 = this.e;
                    this.b = 1;
                    if (cVar.b0(i2, true, i3, this) == objE) {
                        return objE;
                    }
                } else {
                    ir.nasim.database.dailogLists.c cVar2 = C7902Tr2.this.a;
                    DialogFolderEntity dialogFolderEntity = new DialogFolderEntity(this.d, this.f, this.e, null, false, false, true, 32, null);
                    this.b = 2;
                    if (cVar2.c0(dialogFolderEntity, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1 && i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                AbstractC10685c16.b(obj);
            }
            List list = this.g;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(AbstractC6392Nk0.e(C18732p92.m((C8421Vx) it.next()).u()));
            }
            List listN = C7902Tr2.this.n(arrayList, this.d);
            ir.nasim.database.dailogLists.c cVar3 = C7902Tr2.this.a;
            this.b = 3;
            if (cVar3.a(listN, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Tr2$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C7902Tr2.this.new c(this.d, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x006a A[RETURN] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r5.b
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L22
                if (r1 == r4) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                goto L1e
            L12:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1a:
                ir.nasim.AbstractC10685c16.b(r6)
                goto L5a
            L1e:
                ir.nasim.AbstractC10685c16.b(r6)
                goto L6b
            L22:
                ir.nasim.AbstractC10685c16.b(r6)
                ir.nasim.Tr2 r6 = ir.nasim.C7902Tr2.this
                java.util.List r6 = ir.nasim.C7902Tr2.g(r6)
                int r1 = r5.d
                java.lang.Integer r1 = ir.nasim.AbstractC6392Nk0.d(r1)
                boolean r6 = r6.contains(r1)
                if (r6 == 0) goto L49
                ir.nasim.Tr2 r6 = ir.nasim.C7902Tr2.this
                ir.nasim.database.dailogLists.c r6 = ir.nasim.C7902Tr2.h(r6)
                int r1 = r5.d
                r5.b = r4
                r2 = 0
                java.lang.Object r6 = r6.b0(r1, r2, r1, r5)
                if (r6 != r0) goto L6b
                return r0
            L49:
                ir.nasim.Tr2 r6 = ir.nasim.C7902Tr2.this
                ir.nasim.database.dailogLists.c r6 = ir.nasim.C7902Tr2.h(r6)
                int r1 = r5.d
                r5.b = r3
                java.lang.Object r6 = r6.e(r1, r5)
                if (r6 != r0) goto L5a
                return r0
            L5a:
                ir.nasim.Tr2 r6 = ir.nasim.C7902Tr2.this
                ir.nasim.database.dailogLists.c r6 = ir.nasim.C7902Tr2.h(r6)
                int r1 = r5.d
                r5.b = r2
                java.lang.Object r6 = r6.d(r1, r5)
                if (r6 != r0) goto L6b
                return r0
            L6b:
                ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C7902Tr2.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Tr2$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        int g;
        final /* synthetic */ String h;
        final /* synthetic */ C7902Tr2 i;
        final /* synthetic */ int j;
        final /* synthetic */ List k;
        final /* synthetic */ List l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, C7902Tr2 c7902Tr2, int i, List list, List list2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.h = str;
            this.i = c7902Tr2;
            this.j = i;
            this.k = list;
            this.l = list2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.h, this.i, this.j, this.k, this.l, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00b2  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0107 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00a4 -> B:26:0x00a5). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instructions count: 267
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C7902Tr2.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Tr2$e */
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
            return C7902Tr2.this.new e(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                ir.nasim.database.dailogLists.c cVar = C7902Tr2.this.a;
                List list = this.d;
                this.b = 1;
                if (cVar.N(list, this) == objE) {
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
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C7902Tr2(ir.nasim.database.dailogLists.c cVar, InterfaceC20315ro1 interfaceC20315ro1, AbstractC13778go1 abstractC13778go1, InterfaceC20667sP1 interfaceC20667sP1) {
        AbstractC13042fc3.i(cVar, "dialogFolderDao");
        AbstractC13042fc3.i(interfaceC20315ro1, "applicationScope");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC20667sP1, "dialogRepository");
        this.a = cVar;
        this.b = interfaceC20315ro1;
        this.c = abstractC13778go1;
        this.d = interfaceC20667sP1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object k(List list, int i, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objA = this.a.a(n(list, i), interfaceC20295rm1);
        return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object l(List list, int i, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objF = this.a.f(n(list, i), interfaceC20295rm1);
        return objF == AbstractC14862ic3.e() ? objF : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List m() {
        F92 f92 = a.a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : f92) {
            if (((EnumC7296Rc4) obj) != EnumC7296Rc4.UNRECOGNIZED) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(((EnumC7296Rc4) it.next()).getNumber()));
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List n(List list, int i) {
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(new DialogFolderAssociationEntity(((Number) it.next()).longValue(), i, null));
        }
        return arrayList;
    }

    @Override // ir.nasim.InterfaceC7663Sr2
    public void a(int i, String str, int i2, List list) {
        AbstractC13042fc3.i(str, "folderName");
        AbstractC13042fc3.i(list, "apiExPeers");
        AbstractC10533bm0.d(this.b, this.c, null, new b(i, i2, str, list, null), 2, null);
    }

    @Override // ir.nasim.InterfaceC7663Sr2
    public void b(int i) {
        AbstractC10533bm0.d(this.b, this.c, null, new c(i, null), 2, null);
    }

    @Override // ir.nasim.InterfaceC7663Sr2
    public void c(List list) {
        AbstractC13042fc3.i(list, "folderIds");
        AbstractC10533bm0.d(this.b, this.c, null, new e(list, null), 2, null);
    }

    @Override // ir.nasim.InterfaceC7663Sr2
    public void d(int i, String str, List list, List list2) {
        AbstractC13042fc3.i(str, "folderName");
        AbstractC13042fc3.i(list, "addedPeers");
        AbstractC13042fc3.i(list2, "deletedPeers");
        AbstractC10533bm0.d(this.b, this.c, null, new d(str, this, i, list, list2, null), 2, null);
    }
}
