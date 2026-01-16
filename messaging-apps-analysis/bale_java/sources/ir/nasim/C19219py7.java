package ir.nasim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.py7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C19219py7 {
    public static final C19219py7 a = new C19219py7();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.py7$a */
    private static final class a {
        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        private static final /* synthetic */ a[] e;

        /* renamed from: ir.nasim.py7$a$a, reason: collision with other inner class name */
        static final class C1464a extends a {
            C1464a(String str, int i) {
                super(str, i, null);
            }

            @Override // ir.nasim.C19219py7.a
            public a a(AbstractC18174oC7 abstractC18174oC7) {
                AbstractC13042fc3.i(abstractC18174oC7, "nextType");
                return j(abstractC18174oC7);
            }
        }

        /* renamed from: ir.nasim.py7$a$b */
        static final class b extends a {
            b(String str, int i) {
                super(str, i, null);
            }

            @Override // ir.nasim.C19219py7.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public b a(AbstractC18174oC7 abstractC18174oC7) {
                AbstractC13042fc3.i(abstractC18174oC7, "nextType");
                return this;
            }
        }

        /* renamed from: ir.nasim.py7$a$c */
        static final class c extends a {
            c(String str, int i) {
                super(str, i, null);
            }

            @Override // ir.nasim.C19219py7.a
            public a a(AbstractC18174oC7 abstractC18174oC7) {
                AbstractC13042fc3.i(abstractC18174oC7, "nextType");
                return j(abstractC18174oC7);
            }
        }

        /* renamed from: ir.nasim.py7$a$d */
        static final class d extends a {
            d(String str, int i) {
                super(str, i, null);
            }

            @Override // ir.nasim.C19219py7.a
            public a a(AbstractC18174oC7 abstractC18174oC7) {
                AbstractC13042fc3.i(abstractC18174oC7, "nextType");
                a aVarJ = j(abstractC18174oC7);
                return aVarJ == a.b ? this : aVarJ;
            }
        }

        static {
            c cVar = new c("START", 0);
            a = cVar;
            C1464a c1464a = new C1464a("ACCEPT_NULL", 1);
            b = c1464a;
            d dVar = new d("UNKNOWN", 2);
            c = dVar;
            b bVar = new b("NOT_NULL", 3);
            d = bVar;
            e = new a[]{cVar, c1464a, dVar, bVar};
        }

        public /* synthetic */ a(String str, int i, ED1 ed1) {
            this(str, i);
        }

        public static a valueOf(String str) {
            AbstractC13042fc3.i(str, "value");
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            a[] aVarArr = e;
            a[] aVarArr2 = new a[aVarArr.length];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, aVarArr.length);
            return aVarArr2;
        }

        public abstract a a(AbstractC18174oC7 abstractC18174oC7);

        protected final a j(AbstractC18174oC7 abstractC18174oC7) {
            AbstractC13042fc3.i(abstractC18174oC7, "<this>");
            return abstractC18174oC7.L0() ? b : C13452gF4.a.a(abstractC18174oC7) ? d : c;
        }

        private a(String str, int i) {
        }
    }

    /* renamed from: ir.nasim.py7$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Set e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Set set) {
            super(0);
            this.e = set;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return AbstractC13042fc3.q("This collections cannot be empty! input types: ", AbstractC15401jX0.A0(this.e, null, null, null, 0, null, null, 63, null));
        }
    }

    /* renamed from: ir.nasim.py7$c */
    /* synthetic */ class c extends DB2 implements InterfaceC14603iB2 {
        c(C19219py7 c19219py7) {
            super(2, c19219py7);
        }

        @Override // ir.nasim.AbstractC15785kA0, ir.nasim.InterfaceC9916am3
        public final String getName() {
            return "isStrictSupertype";
        }

        @Override // ir.nasim.AbstractC15785kA0
        public final InterfaceC15551jm3 getOwner() {
            return AbstractC10882cM5.b(C19219py7.class);
        }

        @Override // ir.nasim.AbstractC15785kA0
        public final String getSignature() {
            return "isStrictSupertype(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return Boolean.valueOf(y((AbstractC4099Dr3) obj, (AbstractC4099Dr3) obj2));
        }

        public final boolean y(AbstractC4099Dr3 abstractC4099Dr3, AbstractC4099Dr3 abstractC4099Dr32) {
            AbstractC13042fc3.i(abstractC4099Dr3, "p0");
            AbstractC13042fc3.i(abstractC4099Dr32, "p1");
            return ((C19219py7) this.receiver).e(abstractC4099Dr3, abstractC4099Dr32);
        }
    }

    /* renamed from: ir.nasim.py7$d */
    /* synthetic */ class d extends DB2 implements InterfaceC14603iB2 {
        d(C15041iu4 c15041iu4) {
            super(2, c15041iu4);
        }

        @Override // ir.nasim.AbstractC15785kA0, ir.nasim.InterfaceC9916am3
        public final String getName() {
            return "equalTypes";
        }

        @Override // ir.nasim.AbstractC15785kA0
        public final InterfaceC15551jm3 getOwner() {
            return AbstractC10882cM5.b(C15041iu4.class);
        }

        @Override // ir.nasim.AbstractC15785kA0
        public final String getSignature() {
            return "equalTypes(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return Boolean.valueOf(y((AbstractC4099Dr3) obj, (AbstractC4099Dr3) obj2));
        }

        public final boolean y(AbstractC4099Dr3 abstractC4099Dr3, AbstractC4099Dr3 abstractC4099Dr32) {
            AbstractC13042fc3.i(abstractC4099Dr3, "p0");
            AbstractC13042fc3.i(abstractC4099Dr32, "p1");
            return ((C15041iu4) this.receiver).c(abstractC4099Dr3, abstractC4099Dr32);
        }
    }

    private C19219py7() {
    }

    private final Collection b(Collection collection, InterfaceC14603iB2 interfaceC14603iB2) {
        ArrayList arrayList = new ArrayList(collection);
        Iterator it = arrayList.iterator();
        AbstractC13042fc3.h(it, "filteredTypes.iterator()");
        while (it.hasNext()) {
            XC6 xc6 = (XC6) it.next();
            if (!arrayList.isEmpty()) {
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    XC6 xc62 = (XC6) it2.next();
                    if (xc62 != xc6) {
                        AbstractC13042fc3.h(xc62, "lower");
                        AbstractC13042fc3.h(xc6, "upper");
                        if (((Boolean) interfaceC14603iB2.invoke(xc62, xc6)).booleanValue()) {
                            it.remove();
                            break;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private final XC6 d(Set set) {
        if (set.size() == 1) {
            return (XC6) AbstractC15401jX0.U0(set);
        }
        new b(set);
        Set set2 = set;
        Collection collectionB = b(set2, new c(this));
        collectionB.isEmpty();
        XC6 xc6B = C7043Qa3.f.b(collectionB);
        if (xc6B != null) {
            return xc6B;
        }
        Collection collectionB2 = b(collectionB, new d(InterfaceC14434hu4.b.a()));
        collectionB2.isEmpty();
        return collectionB2.size() < 2 ? (XC6) AbstractC15401jX0.U0(collectionB2) : new C7993Ub3(set2).g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e(AbstractC4099Dr3 abstractC4099Dr3, AbstractC4099Dr3 abstractC4099Dr32) {
        C15041iu4 c15041iu4A = InterfaceC14434hu4.b.a();
        return c15041iu4A.b(abstractC4099Dr3, abstractC4099Dr32) && !c15041iu4A.b(abstractC4099Dr32, abstractC4099Dr3);
    }

    public final XC6 c(List list) {
        AbstractC13042fc3.i(list, "types");
        list.size();
        ArrayList<XC6> arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            XC6 xc6 = (XC6) it.next();
            if (xc6.K0() instanceof C7993Ub3) {
                Collection collectionB = xc6.K0().b();
                AbstractC13042fc3.h(collectionB, "type.constructor.supertypes");
                Collection<AbstractC4099Dr3> collection = collectionB;
                ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(collection, 10));
                for (AbstractC4099Dr3 abstractC4099Dr3 : collection) {
                    AbstractC13042fc3.h(abstractC4099Dr3, "it");
                    XC6 xc6D = AbstractC7411Rp2.d(abstractC4099Dr3);
                    if (xc6.L0()) {
                        xc6D = xc6D.O0(true);
                    }
                    arrayList2.add(xc6D);
                }
                arrayList.addAll(arrayList2);
            } else {
                arrayList.add(xc6);
            }
        }
        a aVarA = a.a;
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            aVarA = aVarA.a((AbstractC18174oC7) it2.next());
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (XC6 xc6I : arrayList) {
            if (aVarA == a.d) {
                if (xc6I instanceof C24002xs4) {
                    xc6I = AbstractC24252yI6.k((C24002xs4) xc6I);
                }
                xc6I = AbstractC24252yI6.i(xc6I, false, 1, null);
            }
            linkedHashSet.add(xc6I);
        }
        return d(linkedHashSet);
    }
}
