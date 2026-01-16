package ir.nasim;

import android.content.Context;
import ir.nasim.AbstractC19670qk5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.tZ0, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C21376tZ0 {
    static final /* synthetic */ InterfaceC5239Im3[] c = {AbstractC10882cM5.j(new C3678Bw5(C21376tZ0.class, "commentDataStore", "getCommentDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0))};
    public static final int d = 8;
    private final E84 a;
    private final InterfaceC23661xI5 b;

    /* renamed from: ir.nasim.tZ0$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ int e;

        /* renamed from: ir.nasim.tZ0$a$a, reason: collision with other inner class name */
        static final class C1577a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ int d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1577a(int i, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = i;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C1577a c1577a = new C1577a(this.d, interfaceC20295rm1);
                c1577a.c = obj;
                return c1577a;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                ((C4772Gm4) this.c).j(AbstractC21557tk5.g(String.valueOf(this.d)), AbstractC4597Fu6.d());
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C4772Gm4 c4772Gm4, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1577a) create(c4772Gm4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C21376tZ0.this.new a(this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws Throwable {
            Set set;
            List listM1;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            try {
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4557Fq2 data = C21376tZ0.this.c(C5721Ko.a.d()).getData();
                    this.c = 1;
                    obj = AbstractC6459Nq2.I(data, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        if (i == 2) {
                            AbstractC10685c16.b(obj);
                            return C19938rB7.a;
                        }
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Throwable th = (Throwable) this.b;
                        AbstractC10685c16.b(obj);
                        throw th;
                    }
                    AbstractC10685c16.b(obj);
                }
                AbstractC19670qk5 abstractC19670qk5 = (AbstractC19670qk5) obj;
                if (abstractC19670qk5 != null && (set = (Set) abstractC19670qk5.b(AbstractC21557tk5.g(String.valueOf(this.e)))) != null && (listM1 = AbstractC15401jX0.m1(set)) != null) {
                    C21376tZ0.this.e(this.e, listM1);
                }
                InterfaceC23475wz1 interfaceC23475wz1C = C21376tZ0.this.c(C5721Ko.a.d());
                C1577a c1577a = new C1577a(this.e, null);
                this.c = 2;
                if (AbstractC22147uk5.a(interfaceC23475wz1C, c1577a, this) == objE) {
                    return objE;
                }
                return C19938rB7.a;
            } catch (Throwable th2) {
                InterfaceC23475wz1 interfaceC23475wz1C2 = C21376tZ0.this.c(C5721Ko.a.d());
                C1577a c1577a2 = new C1577a(this.e, null);
                this.b = th2;
                this.c = 3;
                if (AbstractC22147uk5.a(interfaceC23475wz1C2, c1577a2, this) == objE) {
                    return objE;
                }
                throw th2;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tZ0$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        /* renamed from: ir.nasim.tZ0$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;

            a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                ((C4772Gm4) this.c).f();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C4772Gm4 c4772Gm4, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c4772Gm4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = C21376tZ0.this.new b(interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AbstractC19670qk5 abstractC19670qk5 = (AbstractC19670qk5) this.c;
                try {
                    Set<AbstractC19670qk5.a> setKeySet = abstractC19670qk5.a().keySet();
                    C21376tZ0 c21376tZ0 = C21376tZ0.this;
                    for (AbstractC19670qk5.a aVar : setKeySet) {
                        Object objB = abstractC19670qk5.b(aVar);
                        if (objB instanceof Set) {
                            int i2 = Integer.parseInt(aVar.a());
                            ArrayList arrayList = new ArrayList();
                            for (Object obj2 : (Iterable) objB) {
                                if (obj2 instanceof String) {
                                    arrayList.add(obj2);
                                }
                            }
                            c21376tZ0.e(i2, arrayList);
                        }
                    }
                    InterfaceC23475wz1 interfaceC23475wz1C = C21376tZ0.this.c(C5721Ko.a.d());
                    a aVar2 = new a(null);
                    this.b = 1;
                    if (AbstractC22147uk5.a(interfaceC23475wz1C, aVar2, this) == objE) {
                        return objE;
                    }
                } catch (Throwable th) {
                    InterfaceC23475wz1 interfaceC23475wz1C2 = C21376tZ0.this.c(C5721Ko.a.d());
                    a aVar3 = new a(null);
                    this.c = th;
                    this.b = 2;
                    if (AbstractC22147uk5.a(interfaceC23475wz1C2, aVar3, this) == objE) {
                        return objE;
                    }
                    throw th;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Throwable th2 = (Throwable) this.c;
                    AbstractC10685c16.b(obj);
                    throw th2;
                }
                AbstractC10685c16.b(obj);
            }
            return AbstractC6392Nk0.a(true);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(AbstractC19670qk5 abstractC19670qk5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(abstractC19670qk5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.tZ0$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ int d;
        final /* synthetic */ long e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(int i, long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = new c(this.d, this.e, interfaceC20295rm1);
            cVar.c = obj;
            return cVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C4772Gm4 c4772Gm4 = (C4772Gm4) this.c;
            Set setD = (Set) c4772Gm4.b(AbstractC21557tk5.g(String.valueOf(this.d)));
            if (setD == null) {
                setD = AbstractC4597Fu6.d();
            }
            c4772Gm4.j(AbstractC21557tk5.g(String.valueOf(this.d)), AbstractC4846Gu6.m(setD, String.valueOf(this.e)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C4772Gm4 c4772Gm4, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(c4772Gm4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C21376tZ0(E84 e84) {
        AbstractC13042fc3.i(e84, "messagesModule");
        this.a = e84;
        this.b = AbstractC16715lk5.b(EnumC18608ow5.r.getValue(), null, null, null, 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC23475wz1 c(Context context) {
        return (InterfaceC23475wz1) this.b.a(context, c[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(int i, List list) {
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            J44 j44 = (J44) this.a.H0(C11458d25.y(i)).a(Long.parseLong((String) it.next()));
            J44 j44D = null;
            if (j44 != null) {
                C17532n74 c17532n74T = j44.T();
                j44D = J44.D(j44, 0L, 0L, 0L, 0, null, null, null, 0, null, null, 0L, null, null, false, null, false, c17532n74T != null ? c17532n74T.q((504 & 1) != 0 ? c17532n74T.a : 0, (504 & 2) != 0 ? c17532n74T.b : null, (504 & 4) != 0 ? c17532n74T.c : null, (504 & 8) != 0 ? c17532n74T.d : null, (504 & 16) != 0 ? c17532n74T.e : null, (504 & 32) != 0 ? c17532n74T.f : null, (504 & 64) != 0 ? c17532n74T.g : false, (504 & 128) != 0 ? c17532n74T.h : 0L, (504 & 256) != 0 ? c17532n74T.i : 0) : null, null, 196607, null);
            }
            arrayList.add(j44D);
        }
        DB3 db3H0 = this.a.H0(C11458d25.y(i));
        if (db3H0 != null) {
            db3H0.c(AbstractC15401jX0.n0(arrayList));
        }
    }

    public final void d(int i) {
        AbstractC10533bm0.d(C17050mJ2.a, null, null, new a(i, null), 3, null);
    }

    public final Object f(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objH = AbstractC6459Nq2.H(c(C5721Ko.a.d()).getData(), new b(null), interfaceC20295rm1);
        return objH == AbstractC14862ic3.e() ? objH : C19938rB7.a;
    }

    public final Object g(int i, long j, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objA = AbstractC22147uk5.a(c(C5721Ko.a.d()), new c(i, j, null), interfaceC20295rm1);
        return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
    }
}
