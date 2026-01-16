package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.database.dailogLists.DialogPeerUnreadStateEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: ir.nasim.mG3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17024mG3 {
    public static final a e = new a(null);
    public static final int f = 8;
    private final InterfaceC20667sP1 a;
    private final AbstractC13778go1 b;
    private final QB7 c;
    private final AtomicBoolean d;

    /* renamed from: ir.nasim.mG3$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.mG3$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C17024mG3.this.d(this);
        }
    }

    /* renamed from: ir.nasim.mG3$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ List d;
        final /* synthetic */ C17024mG3 e;

        /* renamed from: ir.nasim.mG3$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C17024mG3 c;
            final /* synthetic */ List d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C17024mG3 c17024mG3, List list, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c17024mG3;
                this.d = list;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objO;
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC20667sP1 interfaceC20667sP1 = this.c.a;
                    List list = this.d;
                    this.b = 1;
                    objO = interfaceC20667sP1.o(list, this);
                    if (objO == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    objO = ((C9475a16) obj).l();
                }
                return C9475a16.a(objO);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(List list, C17024mG3 c17024mG3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = list;
            this.e = c17024mG3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = new c(this.d, this.e, interfaceC20295rm1);
            cVar.c = obj;
            return cVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                if (this.d.isEmpty()) {
                    return new C17615nG3(null, null, null, 7, null);
                }
                this.e.d.set(true);
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                ArrayList arrayList = new ArrayList();
                for (DialogPeerUnreadStateEntity dialogPeerUnreadStateEntity : this.d) {
                    linkedHashSet.add(new DialogPeerUnreadStateEntity(dialogPeerUnreadStateEntity.getPeerUid(), dialogPeerUnreadStateEntity.isMute()));
                    C11458d25 c11458d25R = C11458d25.r(dialogPeerUnreadStateEntity.getPeerUid());
                    AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
                    arrayList.add(c11458d25R);
                }
                this.e.a.c(linkedHashSet);
                List listH0 = AbstractC15401jX0.h0(arrayList, 100);
                C17024mG3 c17024mG3 = this.e;
                ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(listH0, 10));
                int i2 = 0;
                for (Object obj2 : listH0) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        AbstractC10360bX0.w();
                    }
                    arrayList2.add(AbstractC10533bm0.b(interfaceC20315ro1, c17024mG3.b, null, new a(c17024mG3, (List) obj2, null), 2, null));
                    i2 = i3;
                }
                this.b = 1;
                obj = DV.a(arrayList2, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C17615nG3 c17615nG3 = new C17615nG3(null, null, null, 7, null);
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                Object objL = ((C9475a16) it.next()).l();
                Throwable thE = C9475a16.e(objL);
                if (thE == null) {
                    List list = (List) objL;
                    c17615nG3.a().addAll(list);
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        c17615nG3.c().add(AbstractC6392Nk0.e(((DialogEntity) it2.next()).getPeerUid()));
                    }
                } else {
                    c17615nG3.b().add(thE);
                }
            }
            this.e.d.set(false);
            return c17615nG3;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C17024mG3(InterfaceC20667sP1 interfaceC20667sP1, AbstractC13778go1 abstractC13778go1, QB7 qb7) {
        AbstractC13042fc3.i(interfaceC20667sP1, "dialogRepository");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(qb7, "unreadPeerMapper");
        this.a = interfaceC20667sP1;
        this.b = abstractC13778go1;
        this.c = qb7;
        this.d = new AtomicBoolean(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.C17024mG3.b
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.mG3$b r0 = (ir.nasim.C17024mG3.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.mG3$b r0 = new ir.nasim.mG3$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            ir.nasim.AbstractC10685c16.b(r6)
            goto L5b
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L34:
            java.lang.Object r2 = r0.a
            ir.nasim.mG3 r2 = (ir.nasim.C17024mG3) r2
            ir.nasim.AbstractC10685c16.b(r6)
            goto L4d
        L3c:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.sP1 r6 = r5.a
            r0.a = r5
            r0.d = r4
            java.lang.Object r6 = r6.b(r0)
            if (r6 != r1) goto L4c
            return r1
        L4c:
            r2 = r5
        L4d:
            java.util.List r6 = (java.util.List) r6
            r4 = 0
            r0.a = r4
            r0.d = r3
            java.lang.Object r6 = r2.f(r6, r0)
            if (r6 != r1) goto L5b
            return r1
        L5b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17024mG3.d(ir.nasim.rm1):java.lang.Object");
    }

    public final Object e(Collection collection, InterfaceC20295rm1 interfaceC20295rm1) {
        return g(this.c.a(collection), interfaceC20295rm1);
    }

    public final Object f(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        return g(list, interfaceC20295rm1);
    }

    public final Object g(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC20906so1.e(new c(list, this, null), interfaceC20295rm1);
    }
}
