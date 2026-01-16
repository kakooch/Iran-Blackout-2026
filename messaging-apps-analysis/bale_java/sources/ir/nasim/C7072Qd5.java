package ir.nasim;

import ai.bale.proto.PeersStruct$ExPeer;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.database.dailogLists.DialogFolderAssociationEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Qd5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7072Qd5 implements InterfaceC6828Pd5 {
    private static final a k = new a(null);
    public static final int l = 8;
    private final C19467qP1 a;
    private final C10299bQ2 b;
    private final InterfaceC14123hO3 c;
    private final HM1 d;
    private final ir.nasim.database.dailogLists.c e;
    private final BM1 f;
    private final InterfaceC20667sP1 g;
    private final AbstractC13778go1 h;
    private final InterfaceC3570Bk5 i;
    private final YF3 j;

    /* renamed from: ir.nasim.Qd5$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Qd5$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ F92 a = G92.a(EnumC7296Rc4.values());
    }

    /* renamed from: ir.nasim.Qd5$c */
    static final class c extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        int f;
        /* synthetic */ Object g;
        int i;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= RecyclerView.UNDEFINED_DURATION;
            Object objB = C7072Qd5.this.b(0, false, this);
            return objB == AbstractC14862ic3.e() ? objB : C9475a16.a(objB);
        }
    }

    /* renamed from: ir.nasim.Qd5$d */
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
            Object objD = C7072Qd5.this.d(0, this);
            return objD == AbstractC14862ic3.e() ? objD : C9475a16.a(objD);
        }
    }

    /* renamed from: ir.nasim.Qd5$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        private /* synthetic */ Object e;
        final /* synthetic */ List f;
        final /* synthetic */ C7072Qd5 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(List list, C7072Qd5 c7072Qd5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.f = list;
            this.g = c7072Qd5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = new e(this.f, this.g, interfaceC20295rm1);
            eVar.e = obj;
            return eVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            List<C11458d25> arrayList;
            Object objA;
            List list;
            ExPeer exPeer;
            ExPeer exPeer2;
            Object objE = AbstractC14862ic3.e();
            int i = this.d;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.e;
                arrayList = new ArrayList();
                List list2 = this.f;
                C7072Qd5 c7072Qd5 = this.g;
                ArrayList arrayList2 = new ArrayList();
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    C11458d25 c11458d25R = C11458d25.r(((Number) it.next()).longValue());
                    AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
                    ExPeerType exPeerTypeM1 = c7072Qd5.b.M1(c11458d25R);
                    if (exPeerTypeM1 == null) {
                        arrayList.add(c11458d25R);
                        exPeer = null;
                    } else {
                        exPeer = new ExPeer(exPeerTypeM1, c11458d25R.getPeerId());
                    }
                    if (exPeer != null) {
                        arrayList2.add(exPeer);
                    }
                }
                if (arrayList.isEmpty()) {
                    return arrayList2;
                }
                YF3 yf3 = this.g.j;
                this.e = interfaceC20315ro1;
                this.b = arrayList;
                this.c = arrayList2;
                this.d = 1;
                objA = yf3.a(arrayList, true, this);
                if (objA == objE) {
                    return objE;
                }
                list = arrayList2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list = (List) this.c;
                arrayList = (List) this.b;
                AbstractC10685c16.b(obj);
                objA = ((C9475a16) obj).l();
            }
            Throwable thE = C9475a16.e(objA);
            if (thE != null) {
                C19406qI3.b("PinRepositoryImpl", "Loading peers failed: " + thE.getMessage());
            }
            List list3 = list;
            C7072Qd5 c7072Qd52 = this.g;
            ArrayList arrayList3 = new ArrayList();
            for (C11458d25 c11458d25 : arrayList) {
                ExPeerType exPeerTypeM12 = c7072Qd52.b.M1(c11458d25);
                if (exPeerTypeM12 == null) {
                    C19406qI3.b("PinRepositoryImpl", "Failed to pin/unpin " + c11458d25.getPeerId() + " even after fetching peer from the server.");
                    exPeer2 = null;
                } else {
                    exPeer2 = new ExPeer(exPeerTypeM12, c11458d25.getPeerId());
                }
                if (exPeer2 != null) {
                    arrayList3.add(exPeer2);
                }
            }
            return AbstractC15401jX0.R0(list3, arrayList3);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Qd5$f */
    static final class f extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        int d;
        /* synthetic */ Object e;
        int g;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            Object objA = C7072Qd5.this.a(0, null, this);
            return objA == AbstractC14862ic3.e() ? objA : C9475a16.a(objA);
        }
    }

    /* renamed from: ir.nasim.Qd5$g */
    static final class g extends AbstractC22163um1 {
        Object a;
        Object b;
        int c;
        /* synthetic */ Object d;
        int f;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return C7072Qd5.this.s(null, 0, this);
        }
    }

    /* renamed from: ir.nasim.Qd5$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ List d;
        final /* synthetic */ C7072Qd5 e;
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(List list, C7072Qd5 c7072Qd5, int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = list;
            this.e = c7072Qd5;
            this.f = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new h(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            List arrayList;
            Object objO;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                List<C8421Vx> list = this.d;
                arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                for (C8421Vx c8421Vx : list) {
                    arrayList.add(new C11458d25(new ExPeer(C18732p92.v(c8421Vx.r()), c8421Vx.q())));
                }
                C7072Qd5 c7072Qd5 = this.e;
                ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(AbstractC6392Nk0.e(((C11458d25) it.next()).u()));
                }
                int i2 = this.f;
                this.b = arrayList;
                this.c = 1;
                if (c7072Qd5.r(arrayList2, i2, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    objO = ((C9475a16) obj).l();
                    return C9475a16.a(objO);
                }
                arrayList = (List) this.b;
                AbstractC10685c16.b(obj);
            }
            InterfaceC20667sP1 interfaceC20667sP1 = this.e.g;
            this.b = null;
            this.c = 2;
            objO = interfaceC20667sP1.o(arrayList, this);
            if (objO == objE) {
                return objE;
            }
            return C9475a16.a(objO);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Qd5$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List c;
        final /* synthetic */ C7072Qd5 d;
        final /* synthetic */ int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(List list, C7072Qd5 c7072Qd5, int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = list;
            this.d = c7072Qd5;
            this.e = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new i(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                List<C8421Vx> list = this.c;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                for (C8421Vx c8421Vx : list) {
                    arrayList.add(AbstractC6392Nk0.e(new C11458d25(new ExPeer(C18732p92.v(c8421Vx.r()), c8421Vx.q())).u()));
                }
                C7072Qd5 c7072Qd5 = this.d;
                int i2 = this.e;
                this.b = 1;
                if (c7072Qd5.t(arrayList, i2, this) == objE) {
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
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Qd5$j */
    static final class j extends AbstractC22163um1 {
        Object a;
        Object b;
        int c;
        /* synthetic */ Object d;
        int f;

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            Object objF = C7072Qd5.this.f(0, null, this);
            return objF == AbstractC14862ic3.e() ? objF : C9475a16.a(objF);
        }
    }

    public C7072Qd5(C19467qP1 c19467qP1, C10299bQ2 c10299bQ2, InterfaceC14123hO3 interfaceC14123hO3, HM1 hm1, ir.nasim.database.dailogLists.c cVar, BM1 bm1, InterfaceC20667sP1 interfaceC20667sP1, AbstractC13778go1 abstractC13778go1, InterfaceC3570Bk5 interfaceC3570Bk5, YF3 yf3) {
        AbstractC13042fc3.i(c19467qP1, "remoteDataSource");
        AbstractC13042fc3.i(c10299bQ2, "groupsModule");
        AbstractC13042fc3.i(interfaceC14123hO3, "structExPeerTypeToExpeerType");
        AbstractC13042fc3.i(hm1, "dialogDao");
        AbstractC13042fc3.i(cVar, "dialogFolderDao");
        AbstractC13042fc3.i(bm1, "dialogDTOMapper");
        AbstractC13042fc3.i(interfaceC20667sP1, "dialogRepository");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferences");
        AbstractC13042fc3.i(yf3, "loadPeersUseCase");
        this.a = c19467qP1;
        this.b = c10299bQ2;
        this.c = interfaceC14123hO3;
        this.d = hm1;
        this.e = cVar;
        this.f = bm1;
        this.g = interfaceC20667sP1;
        this.h = abstractC13778go1;
        this.i = interfaceC3570Bk5;
        this.j = yf3;
    }

    private final List m(List list, int i2) {
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        int i3 = 0;
        for (Object obj : list2) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                AbstractC10360bX0.w();
            }
            arrayList.add(new DialogFolderAssociationEntity(((DialogEntity) obj).getPeerUid(), i2, Integer.valueOf(i3)));
            i3 = i4;
        }
        return arrayList;
    }

    private final List n(List list, int i2) {
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        int i3 = 0;
        for (Object obj : list2) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                AbstractC10360bX0.w();
            }
            arrayList.add(new DialogFolderAssociationEntity(((Number) obj).longValue(), i2, Integer.valueOf(i3)));
            i3 = i4;
        }
        return arrayList;
    }

    private final boolean o(int i2) {
        F92 f92 = b.a;
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
        return arrayList2.contains(Integer.valueOf(i2));
    }

    private final Object p(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.h, new e(list, this, null), interfaceC20295rm1);
    }

    private final List q(List list) {
        List<PeersStruct$ExPeer> list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        for (PeersStruct$ExPeer peersStruct$ExPeer : list2) {
            InterfaceC14123hO3 interfaceC14123hO3 = this.c;
            EnumC10088b35 type = peersStruct$ExPeer.getType();
            AbstractC13042fc3.h(type, "getType(...)");
            arrayList.add(Long.valueOf(new C11458d25(new ExPeer((ExPeerType) interfaceC14123hO3.a(type), peersStruct$ExPeer.getId())).u()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object r(List list, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objF0 = this.e.f0(n(list, i2), interfaceC20295rm1);
        return objF0 == AbstractC14862ic3.e() ? objF0 : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(java.util.List r6, int r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof ir.nasim.C7072Qd5.g
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.Qd5$g r0 = (ir.nasim.C7072Qd5.g) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ir.nasim.Qd5$g r0 = new ir.nasim.Qd5$g
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            ir.nasim.AbstractC10685c16.b(r8)
            goto L6b
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            int r7 = r0.c
            java.lang.Object r6 = r0.b
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r2 = r0.a
            ir.nasim.Qd5 r2 = (ir.nasim.C7072Qd5) r2
            ir.nasim.AbstractC10685c16.b(r8)
            goto L57
        L42:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.HM1 r8 = r5.d
            r0.a = r5
            r0.b = r6
            r0.c = r7
            r0.f = r4
            java.lang.Object r8 = r8.b(r6, r0)
            if (r8 != r1) goto L56
            return r1
        L56:
            r2 = r5
        L57:
            java.util.List r6 = r2.m(r6, r7)
            ir.nasim.database.dailogLists.c r7 = r2.e
            r8 = 0
            r0.a = r8
            r0.b = r8
            r0.f = r3
            java.lang.Object r6 = r7.f0(r6, r0)
            if (r6 != r1) goto L6b
            return r1
        L6b:
            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C7072Qd5.s(java.util.List, int, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object t(List list, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objY = this.e.Y(list, i2, interfaceC20295rm1);
        return objY == AbstractC14862ic3.e() ? objY : C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c9 A[LOOP:0: B:35:0x00c3->B:37:0x00c9, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ec A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC6828Pd5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(int r8, java.util.List r9, ir.nasim.InterfaceC20295rm1 r10) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C7072Qd5.a(int, java.util.List, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x014f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0100 -> B:49:0x0105). Please report as a decompilation issue!!! */
    @Override // ir.nasim.InterfaceC6828Pd5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(int r13, boolean r14, ir.nasim.InterfaceC20295rm1 r15) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C7072Qd5.b(int, boolean, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC6828Pd5
    public void c(List list, int i2) {
        AbstractC13042fc3.i(list, "unpinnedPeersList");
        AbstractC9323Zl0.e(this.h, new i(list, this, i2, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC6828Pd5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(int r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ir.nasim.C7072Qd5.d
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.Qd5$d r0 = (ir.nasim.C7072Qd5.d) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.Qd5$d r0 = new ir.nasim.Qd5$d
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
            goto L45
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.qP1 r6 = r4.a
            r0.c = r3
            java.lang.Object r5 = r6.k(r5, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C7072Qd5.d(int, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC6828Pd5
    public void e(List list, int i2) {
        AbstractC13042fc3.i(list, "apiExPeersList");
        AbstractC9323Zl0.e(this.h, new h(list, this, i2, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC6828Pd5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(int r8, java.util.List r9, ir.nasim.InterfaceC20295rm1 r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof ir.nasim.C7072Qd5.j
            if (r0 == 0) goto L13
            r0 = r10
            ir.nasim.Qd5$j r0 = (ir.nasim.C7072Qd5.j) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ir.nasim.Qd5$j r0 = new ir.nasim.Qd5$j
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.f
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L60
            if (r2 == r5) goto L52
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r8 = r0.a
            ir.nasim.AbstractC10685c16.b(r10)
            goto L9d
        L32:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3a:
            int r8 = r0.c
            java.lang.Object r9 = r0.b
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r2 = r0.a
            ir.nasim.Qd5 r2 = (ir.nasim.C7072Qd5) r2
            ir.nasim.AbstractC10685c16.b(r10)
            ir.nasim.a16 r10 = (ir.nasim.C9475a16) r10
            java.lang.Object r10 = r10.l()
        L4d:
            r6 = r9
            r9 = r8
            r8 = r10
            r10 = r6
            goto L86
        L52:
            int r8 = r0.c
            java.lang.Object r9 = r0.b
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r2 = r0.a
            ir.nasim.Qd5 r2 = (ir.nasim.C7072Qd5) r2
            ir.nasim.AbstractC10685c16.b(r10)
            goto L73
        L60:
            ir.nasim.AbstractC10685c16.b(r10)
            r0.a = r7
            r0.b = r9
            r0.c = r8
            r0.f = r5
            java.lang.Object r10 = r7.p(r9, r0)
            if (r10 != r1) goto L72
            return r1
        L72:
            r2 = r7
        L73:
            java.util.List r10 = (java.util.List) r10
            ir.nasim.qP1 r5 = r2.a
            r0.a = r2
            r0.b = r9
            r0.c = r8
            r0.f = r4
            java.lang.Object r10 = r5.r(r8, r10, r0)
            if (r10 != r1) goto L4d
            return r1
        L86:
            boolean r4 = ir.nasim.C9475a16.j(r8)
            if (r4 == 0) goto L9d
            r4 = r8
            ir.nasim.rB7 r4 = (ir.nasim.C19938rB7) r4
            r0.a = r8
            r4 = 0
            r0.b = r4
            r0.f = r3
            java.lang.Object r9 = r2.t(r10, r9, r0)
            if (r9 != r1) goto L9d
            return r1
        L9d:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C7072Qd5.f(int, java.util.List, ir.nasim.rm1):java.lang.Object");
    }
}
