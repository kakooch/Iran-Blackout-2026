package ir.nasim;

import ir.nasim.InterfaceC13521gN1;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.pT1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18912pT1 implements InterfaceC18321oT1 {
    private final C14723iN1 a;
    private final AbstractC13778go1 b;
    private final InterfaceC20315ro1 c;
    private final BM1 d;
    private final ir.nasim.database.dailogLists.c e;
    private volatile Map f;

    /* renamed from: ir.nasim.pT1$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C18912pT1.this.new a(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                ir.nasim.database.dailogLists.c cVar = C18912pT1.this.e;
                int i2 = this.d;
                boolean zI3 = C8386Vt0.I3();
                this.b = 1;
                obj = cVar.G(i2, 90, 0, zI3, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i == 2) {
                        AbstractC10685c16.b(obj);
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            this.b = 2;
            obj = FM1.a(C18912pT1.this.d, (List) obj, this);
            return obj == objE ? objE : obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.pT1$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        private /* synthetic */ Object d;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = C18912pT1.this.new b(interfaceC20295rm1);
            bVar.d = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC20315ro1 interfaceC20315ro1;
            C18912pT1 c18912pT1;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                interfaceC20315ro1 = (InterfaceC20315ro1) this.d;
                C18912pT1 c18912pT12 = C18912pT1.this;
                C14723iN1 c14723iN1 = c18912pT12.a;
                this.d = interfaceC20315ro1;
                this.b = c18912pT12;
                this.c = 1;
                Object objP = c14723iN1.p(this);
                if (objP == objE) {
                    return objE;
                }
                c18912pT1 = c18912pT12;
                obj = objP;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c18912pT1 = (C18912pT1) this.b;
                interfaceC20315ro1 = (InterfaceC20315ro1) this.d;
                AbstractC10685c16.b(obj);
            }
            ArrayList<InterfaceC13521gN1.b> arrayList = new ArrayList();
            for (Object obj2 : (Iterable) obj) {
                if (obj2 instanceof InterfaceC13521gN1.b) {
                    arrayList.add(obj2);
                }
            }
            C18912pT1 c18912pT13 = C18912pT1.this;
            LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(AbstractC10976cX0.x(arrayList, 10)), 16));
            for (InterfaceC13521gN1.b bVar : arrayList) {
                XV4 xv4A = AbstractC4616Fw7.a(AbstractC6392Nk0.d(bVar.e()), c18912pT13.g(interfaceC20315ro1, bVar.e()));
                linkedHashMap.put(xv4A.e(), xv4A.f());
            }
            c18912pT1.f = AbstractC20051rO3.A(linkedHashMap);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C18912pT1(C14723iN1 c14723iN1, AbstractC13778go1 abstractC13778go1, InterfaceC20315ro1 interfaceC20315ro1, BM1 bm1, ir.nasim.database.dailogLists.c cVar) {
        AbstractC13042fc3.i(c14723iN1, "dialogFolderTabsProvider");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        AbstractC13042fc3.i(bm1, "dialogDTOConverter");
        AbstractC13042fc3.i(cVar, "dialogFolderDao");
        this.a = c14723iN1;
        this.b = abstractC13778go1;
        this.c = interfaceC20315ro1;
        this.d = bm1;
        this.e = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC24823zG1 g(InterfaceC20315ro1 interfaceC20315ro1, int i) {
        return AbstractC10533bm0.b(interfaceC20315ro1, null, null, new a(i, null), 3, null);
    }

    public final InterfaceC24823zG1 f(int i) {
        Map map = null;
        if (this.f == null) {
            return null;
        }
        Map map2 = this.f;
        if (map2 == null) {
            AbstractC13042fc3.y("deferredDialogs");
        } else {
            map = map2;
        }
        return (InterfaceC24823zG1) map.get(Integer.valueOf(i));
    }

    @Override // ir.nasim.InterfaceC18321oT1
    public void start() {
        AbstractC10533bm0.d(this.c, this.b, null, new b(null), 2, null);
    }
}
