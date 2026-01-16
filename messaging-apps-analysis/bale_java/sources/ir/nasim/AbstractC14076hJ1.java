package ir.nasim;

import ir.nasim.C24841zI1;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.hJ1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC14076hJ1 extends X24 {
    static final /* synthetic */ InterfaceC5239Im3[] f = {AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(AbstractC14076hJ1.class), "classNames", "getClassNames$deserialization()Ljava/util/Set;")), AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(AbstractC14076hJ1.class), "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;"))};
    private final WI1 b;
    private final a c;
    private final InterfaceC23016wC4 d;
    private final InterfaceC20580sF4 e;

    /* renamed from: ir.nasim.hJ1$a */
    private interface a {
        Set a();

        Collection b(C6432No4 c6432No4, IJ3 ij3);

        Set c();

        Collection d(C6432No4 c6432No4, IJ3 ij3);

        Set e();

        void f(Collection collection, C24841zI1 c24841zI1, UA2 ua2, IJ3 ij3);

        InterfaceC7722Sx7 g(C6432No4 c6432No4);
    }

    /* renamed from: ir.nasim.hJ1$b */
    private final class b implements a {
        static final /* synthetic */ InterfaceC5239Im3[] o = {AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(b.class), "declaredFunctions", "getDeclaredFunctions()Ljava/util/List;")), AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(b.class), "declaredProperties", "getDeclaredProperties()Ljava/util/List;")), AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(b.class), "allTypeAliases", "getAllTypeAliases()Ljava/util/List;")), AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(b.class), "allFunctions", "getAllFunctions()Ljava/util/List;")), AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(b.class), "allProperties", "getAllProperties()Ljava/util/List;")), AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(b.class), "typeAliasesByName", "getTypeAliasesByName()Ljava/util/Map;")), AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(b.class), "functionsByName", "getFunctionsByName()Ljava/util/Map;")), AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(b.class), "propertiesByName", "getPropertiesByName()Ljava/util/Map;")), AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(b.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(b.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};
        private final List a;
        private final List b;
        private final List c;
        private final InterfaceC23016wC4 d;
        private final InterfaceC23016wC4 e;
        private final InterfaceC23016wC4 f;
        private final InterfaceC23016wC4 g;
        private final InterfaceC23016wC4 h;
        private final InterfaceC23016wC4 i;
        private final InterfaceC23016wC4 j;
        private final InterfaceC23016wC4 k;
        private final InterfaceC23016wC4 l;
        private final InterfaceC23016wC4 m;
        final /* synthetic */ AbstractC14076hJ1 n;

        /* renamed from: ir.nasim.hJ1$b$a */
        static final class a extends AbstractC8614Ws3 implements SA2 {
            a() {
                super(0);
            }

            @Override // ir.nasim.SA2
            public final List invoke() {
                return AbstractC15401jX0.R0(b.this.D(), b.this.t());
            }
        }

        /* renamed from: ir.nasim.hJ1$b$b, reason: collision with other inner class name */
        static final class C1267b extends AbstractC8614Ws3 implements SA2 {
            C1267b() {
                super(0);
            }

            @Override // ir.nasim.SA2
            public final List invoke() {
                return AbstractC15401jX0.R0(b.this.E(), b.this.u());
            }
        }

        /* renamed from: ir.nasim.hJ1$b$c */
        static final class c extends AbstractC8614Ws3 implements SA2 {
            c() {
                super(0);
            }

            @Override // ir.nasim.SA2
            public final List invoke() {
                return b.this.z();
            }
        }

        /* renamed from: ir.nasim.hJ1$b$d */
        static final class d extends AbstractC8614Ws3 implements SA2 {
            d() {
                super(0);
            }

            @Override // ir.nasim.SA2
            public final List invoke() {
                return b.this.v();
            }
        }

        /* renamed from: ir.nasim.hJ1$b$e */
        static final class e extends AbstractC8614Ws3 implements SA2 {
            e() {
                super(0);
            }

            @Override // ir.nasim.SA2
            public final List invoke() {
                return b.this.y();
            }
        }

        /* renamed from: ir.nasim.hJ1$b$f */
        static final class f extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ AbstractC14076hJ1 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            f(AbstractC14076hJ1 abstractC14076hJ1) {
                super(0);
                this.f = abstractC14076hJ1;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Set invoke() {
                b bVar = b.this;
                List list = bVar.a;
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                AbstractC14076hJ1 abstractC14076hJ1 = bVar.n;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    linkedHashSet.add(AbstractC7170Qo4.b(abstractC14076hJ1.b.g(), ((C7950Tw5) ((kotlin.reflect.jvm.internal.impl.protobuf.l) it.next())).Z()));
                }
                return AbstractC4846Gu6.l(linkedHashSet, this.f.u());
            }
        }

        /* renamed from: ir.nasim.hJ1$b$g */
        static final class g extends AbstractC8614Ws3 implements SA2 {
            g() {
                super(0);
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Map invoke() {
                List listA = b.this.A();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : listA) {
                    C6432No4 name = ((JC6) obj).getName();
                    AbstractC13042fc3.h(name, "it.name");
                    Object arrayList = linkedHashMap.get(name);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        linkedHashMap.put(name, arrayList);
                    }
                    ((List) arrayList).add(obj);
                }
                return linkedHashMap;
            }
        }

        /* renamed from: ir.nasim.hJ1$b$h */
        static final class h extends AbstractC8614Ws3 implements SA2 {
            h() {
                super(0);
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Map invoke() {
                List listB = b.this.B();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : listB) {
                    C6432No4 name = ((InterfaceC20989sw5) obj).getName();
                    AbstractC13042fc3.h(name, "it.name");
                    Object arrayList = linkedHashMap.get(name);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        linkedHashMap.put(name, arrayList);
                    }
                    ((List) arrayList).add(obj);
                }
                return linkedHashMap;
            }
        }

        /* renamed from: ir.nasim.hJ1$b$i */
        static final class i extends AbstractC8614Ws3 implements SA2 {
            i() {
                super(0);
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Map invoke() {
                List listC = b.this.C();
                LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(AbstractC10976cX0.x(listC, 10)), 16));
                for (Object obj : listC) {
                    C6432No4 name = ((InterfaceC7722Sx7) obj).getName();
                    AbstractC13042fc3.h(name, "it.name");
                    linkedHashMap.put(name, obj);
                }
                return linkedHashMap;
            }
        }

        /* renamed from: ir.nasim.hJ1$b$j */
        static final class j extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ AbstractC14076hJ1 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            j(AbstractC14076hJ1 abstractC14076hJ1) {
                super(0);
                this.f = abstractC14076hJ1;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Set invoke() {
                b bVar = b.this;
                List list = bVar.b;
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                AbstractC14076hJ1 abstractC14076hJ1 = bVar.n;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    linkedHashSet.add(AbstractC7170Qo4.b(abstractC14076hJ1.b.g(), ((C9193Yw5) ((kotlin.reflect.jvm.internal.impl.protobuf.l) it.next())).Y()));
                }
                return AbstractC4846Gu6.l(linkedHashSet, this.f.v());
            }
        }

        public b(AbstractC14076hJ1 abstractC14076hJ1, List list, List list2, List list3) {
            AbstractC13042fc3.i(abstractC14076hJ1, "this$0");
            AbstractC13042fc3.i(list, "functionList");
            AbstractC13042fc3.i(list2, "propertyList");
            AbstractC13042fc3.i(list3, "typeAliasList");
            this.n = abstractC14076hJ1;
            this.a = list;
            this.b = list2;
            this.c = abstractC14076hJ1.q().c().g().c() ? list3 : AbstractC10360bX0.m();
            this.d = abstractC14076hJ1.q().h().c(new d());
            this.e = abstractC14076hJ1.q().h().c(new e());
            this.f = abstractC14076hJ1.q().h().c(new c());
            this.g = abstractC14076hJ1.q().h().c(new a());
            this.h = abstractC14076hJ1.q().h().c(new C1267b());
            this.i = abstractC14076hJ1.q().h().c(new i());
            this.j = abstractC14076hJ1.q().h().c(new g());
            this.k = abstractC14076hJ1.q().h().c(new h());
            this.l = abstractC14076hJ1.q().h().c(new f(abstractC14076hJ1));
            this.m = abstractC14076hJ1.q().h().c(new j(abstractC14076hJ1));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List A() {
            return (List) MN6.a(this.g, this, o[3]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List B() {
            return (List) MN6.a(this.h, this, o[4]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List C() {
            return (List) MN6.a(this.f, this, o[2]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List D() {
            return (List) MN6.a(this.d, this, o[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List E() {
            return (List) MN6.a(this.e, this, o[1]);
        }

        private final Map F() {
            return (Map) MN6.a(this.j, this, o[6]);
        }

        private final Map G() {
            return (Map) MN6.a(this.k, this, o[7]);
        }

        private final Map H() {
            return (Map) MN6.a(this.i, this, o[5]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List t() {
            Set setU = this.n.u();
            ArrayList arrayList = new ArrayList();
            Iterator it = setU.iterator();
            while (it.hasNext()) {
                AbstractC13610gX0.D(arrayList, w((C6432No4) it.next()));
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List u() {
            Set setV = this.n.v();
            ArrayList arrayList = new ArrayList();
            Iterator it = setV.iterator();
            while (it.hasNext()) {
                AbstractC13610gX0.D(arrayList, x((C6432No4) it.next()));
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List v() {
            List list = this.a;
            AbstractC14076hJ1 abstractC14076hJ1 = this.n;
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                JC6 jc6N = abstractC14076hJ1.b.f().n((C7950Tw5) ((kotlin.reflect.jvm.internal.impl.protobuf.l) it.next()));
                if (!abstractC14076hJ1.y(jc6N)) {
                    jc6N = null;
                }
                if (jc6N != null) {
                    arrayList.add(jc6N);
                }
            }
            return arrayList;
        }

        private final List w(C6432No4 c6432No4) {
            List listD = D();
            AbstractC14076hJ1 abstractC14076hJ1 = this.n;
            ArrayList arrayList = new ArrayList();
            for (Object obj : listD) {
                if (AbstractC13042fc3.d(((InterfaceC12795fB1) obj).getName(), c6432No4)) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size();
            abstractC14076hJ1.l(c6432No4, arrayList);
            return arrayList.subList(size, arrayList.size());
        }

        private final List x(C6432No4 c6432No4) {
            List listE = E();
            AbstractC14076hJ1 abstractC14076hJ1 = this.n;
            ArrayList arrayList = new ArrayList();
            for (Object obj : listE) {
                if (AbstractC13042fc3.d(((InterfaceC12795fB1) obj).getName(), c6432No4)) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size();
            abstractC14076hJ1.m(c6432No4, arrayList);
            return arrayList.subList(size, arrayList.size());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List y() {
            List list = this.b;
            AbstractC14076hJ1 abstractC14076hJ1 = this.n;
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                InterfaceC20989sw5 interfaceC20989sw5P = abstractC14076hJ1.b.f().p((C9193Yw5) ((kotlin.reflect.jvm.internal.impl.protobuf.l) it.next()));
                if (interfaceC20989sw5P != null) {
                    arrayList.add(interfaceC20989sw5P);
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List z() {
            List list = this.c;
            AbstractC14076hJ1 abstractC14076hJ1 = this.n;
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                InterfaceC7722Sx7 interfaceC7722Sx7Q = abstractC14076hJ1.b.f().q((C11410cx5) ((kotlin.reflect.jvm.internal.impl.protobuf.l) it.next()));
                if (interfaceC7722Sx7Q != null) {
                    arrayList.add(interfaceC7722Sx7Q);
                }
            }
            return arrayList;
        }

        @Override // ir.nasim.AbstractC14076hJ1.a
        public Set a() {
            return (Set) MN6.a(this.l, this, o[8]);
        }

        @Override // ir.nasim.AbstractC14076hJ1.a
        public Collection b(C6432No4 c6432No4, IJ3 ij3) {
            Collection collection;
            AbstractC13042fc3.i(c6432No4, "name");
            AbstractC13042fc3.i(ij3, "location");
            return (c().contains(c6432No4) && (collection = (Collection) G().get(c6432No4)) != null) ? collection : AbstractC10360bX0.m();
        }

        @Override // ir.nasim.AbstractC14076hJ1.a
        public Set c() {
            return (Set) MN6.a(this.m, this, o[9]);
        }

        @Override // ir.nasim.AbstractC14076hJ1.a
        public Collection d(C6432No4 c6432No4, IJ3 ij3) {
            Collection collection;
            AbstractC13042fc3.i(c6432No4, "name");
            AbstractC13042fc3.i(ij3, "location");
            return (a().contains(c6432No4) && (collection = (Collection) F().get(c6432No4)) != null) ? collection : AbstractC10360bX0.m();
        }

        @Override // ir.nasim.AbstractC14076hJ1.a
        public Set e() {
            List list = this.c;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            AbstractC14076hJ1 abstractC14076hJ1 = this.n;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(AbstractC7170Qo4.b(abstractC14076hJ1.b.g(), ((C11410cx5) ((kotlin.reflect.jvm.internal.impl.protobuf.l) it.next())).a0()));
            }
            return linkedHashSet;
        }

        @Override // ir.nasim.AbstractC14076hJ1.a
        public void f(Collection collection, C24841zI1 c24841zI1, UA2 ua2, IJ3 ij3) {
            AbstractC13042fc3.i(collection, "result");
            AbstractC13042fc3.i(c24841zI1, "kindFilter");
            AbstractC13042fc3.i(ua2, "nameFilter");
            AbstractC13042fc3.i(ij3, "location");
            if (c24841zI1.a(C24841zI1.c.k())) {
                for (Object obj : B()) {
                    C6432No4 name = ((InterfaceC20989sw5) obj).getName();
                    AbstractC13042fc3.h(name, "it.name");
                    if (((Boolean) ua2.invoke(name)).booleanValue()) {
                        collection.add(obj);
                    }
                }
            }
            if (c24841zI1.a(C24841zI1.c.e())) {
                for (Object obj2 : A()) {
                    C6432No4 name2 = ((JC6) obj2).getName();
                    AbstractC13042fc3.h(name2, "it.name");
                    if (((Boolean) ua2.invoke(name2)).booleanValue()) {
                        collection.add(obj2);
                    }
                }
            }
        }

        @Override // ir.nasim.AbstractC14076hJ1.a
        public InterfaceC7722Sx7 g(C6432No4 c6432No4) {
            AbstractC13042fc3.i(c6432No4, "name");
            return (InterfaceC7722Sx7) H().get(c6432No4);
        }
    }

    /* renamed from: ir.nasim.hJ1$c */
    private final class c implements a {
        static final /* synthetic */ InterfaceC5239Im3[] j = {AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(c.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(c.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};
        private final Map a;
        private final Map b;
        private final Map c;
        private final I34 d;
        private final I34 e;
        private final J34 f;
        private final InterfaceC23016wC4 g;
        private final InterfaceC23016wC4 h;
        final /* synthetic */ AbstractC14076hJ1 i;

        /* renamed from: ir.nasim.hJ1$c$a */
        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ LW4 e;
            final /* synthetic */ ByteArrayInputStream f;
            final /* synthetic */ AbstractC14076hJ1 g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(LW4 lw4, ByteArrayInputStream byteArrayInputStream, AbstractC14076hJ1 abstractC14076hJ1) {
                super(0);
                this.e = lw4;
                this.f = byteArrayInputStream;
                this.g = abstractC14076hJ1;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final kotlin.reflect.jvm.internal.impl.protobuf.l invoke() {
                return (kotlin.reflect.jvm.internal.impl.protobuf.l) this.e.c(this.f, this.g.q().c().j());
            }
        }

        /* renamed from: ir.nasim.hJ1$c$b */
        static final class b extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ AbstractC14076hJ1 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(AbstractC14076hJ1 abstractC14076hJ1) {
                super(0);
                this.f = abstractC14076hJ1;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Set invoke() {
                return AbstractC4846Gu6.l(c.this.a.keySet(), this.f.u());
            }
        }

        /* renamed from: ir.nasim.hJ1$c$c, reason: collision with other inner class name */
        static final class C1268c extends AbstractC8614Ws3 implements UA2 {
            C1268c() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Collection invoke(C6432No4 c6432No4) {
                AbstractC13042fc3.i(c6432No4, "it");
                return c.this.m(c6432No4);
            }
        }

        /* renamed from: ir.nasim.hJ1$c$d */
        static final class d extends AbstractC8614Ws3 implements UA2 {
            d() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Collection invoke(C6432No4 c6432No4) {
                AbstractC13042fc3.i(c6432No4, "it");
                return c.this.n(c6432No4);
            }
        }

        /* renamed from: ir.nasim.hJ1$c$e */
        static final class e extends AbstractC8614Ws3 implements UA2 {
            e() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final InterfaceC7722Sx7 invoke(C6432No4 c6432No4) {
                AbstractC13042fc3.i(c6432No4, "it");
                return c.this.o(c6432No4);
            }
        }

        /* renamed from: ir.nasim.hJ1$c$f */
        static final class f extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ AbstractC14076hJ1 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            f(AbstractC14076hJ1 abstractC14076hJ1) {
                super(0);
                this.f = abstractC14076hJ1;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Set invoke() {
                return AbstractC4846Gu6.l(c.this.b.keySet(), this.f.v());
            }
        }

        public c(AbstractC14076hJ1 abstractC14076hJ1, List list, List list2, List list3) throws IOException {
            Map mapK;
            AbstractC13042fc3.i(abstractC14076hJ1, "this$0");
            AbstractC13042fc3.i(list, "functionList");
            AbstractC13042fc3.i(list2, "propertyList");
            AbstractC13042fc3.i(list3, "typeAliasList");
            this.i = abstractC14076hJ1;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : list) {
                C6432No4 c6432No4B = AbstractC7170Qo4.b(abstractC14076hJ1.b.g(), ((C7950Tw5) ((kotlin.reflect.jvm.internal.impl.protobuf.l) obj)).Z());
                Object arrayList = linkedHashMap.get(c6432No4B);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(c6432No4B, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            this.a = p(linkedHashMap);
            AbstractC14076hJ1 abstractC14076hJ12 = this.i;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj2 : list2) {
                C6432No4 c6432No4B2 = AbstractC7170Qo4.b(abstractC14076hJ12.b.g(), ((C9193Yw5) ((kotlin.reflect.jvm.internal.impl.protobuf.l) obj2)).Y());
                Object arrayList2 = linkedHashMap2.get(c6432No4B2);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    linkedHashMap2.put(c6432No4B2, arrayList2);
                }
                ((List) arrayList2).add(obj2);
            }
            this.b = p(linkedHashMap2);
            if (this.i.q().c().g().c()) {
                AbstractC14076hJ1 abstractC14076hJ13 = this.i;
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                for (Object obj3 : list3) {
                    C6432No4 c6432No4B3 = AbstractC7170Qo4.b(abstractC14076hJ13.b.g(), ((C11410cx5) ((kotlin.reflect.jvm.internal.impl.protobuf.l) obj3)).a0());
                    Object arrayList3 = linkedHashMap3.get(c6432No4B3);
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                        linkedHashMap3.put(c6432No4B3, arrayList3);
                    }
                    ((List) arrayList3).add(obj3);
                }
                mapK = p(linkedHashMap3);
            } else {
                mapK = AbstractC20051rO3.k();
            }
            this.c = mapK;
            this.d = this.i.q().h().e(new C1268c());
            this.e = this.i.q().h().e(new d());
            this.f = this.i.q().h().b(new e());
            this.g = this.i.q().h().c(new b(this.i));
            this.h = this.i.q().h().c(new f(this.i));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection m(C6432No4 c6432No4) {
            Map map = this.a;
            LW4 lw4 = C7950Tw5.t;
            AbstractC13042fc3.h(lw4, "PARSER");
            AbstractC14076hJ1 abstractC14076hJ1 = this.i;
            byte[] bArr = (byte[]) map.get(c6432No4);
            List listK = bArr == null ? null : AbstractC11342cq6.K(AbstractC9962aq6.h(new a(lw4, new ByteArrayInputStream(bArr), this.i)));
            List<C7950Tw5> listM = listK == null ? AbstractC10360bX0.m() : listK;
            ArrayList arrayList = new ArrayList(listM.size());
            for (C7950Tw5 c7950Tw5 : listM) {
                C21732u24 c21732u24F = abstractC14076hJ1.q().f();
                AbstractC13042fc3.h(c7950Tw5, "it");
                JC6 jc6N = c21732u24F.n(c7950Tw5);
                if (!abstractC14076hJ1.y(jc6N)) {
                    jc6N = null;
                }
                if (jc6N != null) {
                    arrayList.add(jc6N);
                }
            }
            abstractC14076hJ1.l(c6432No4, arrayList);
            return YW0.c(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection n(C6432No4 c6432No4) {
            Map map = this.b;
            LW4 lw4 = C9193Yw5.t;
            AbstractC13042fc3.h(lw4, "PARSER");
            AbstractC14076hJ1 abstractC14076hJ1 = this.i;
            byte[] bArr = (byte[]) map.get(c6432No4);
            List listK = bArr == null ? null : AbstractC11342cq6.K(AbstractC9962aq6.h(new a(lw4, new ByteArrayInputStream(bArr), this.i)));
            List<C9193Yw5> listM = listK == null ? AbstractC10360bX0.m() : listK;
            ArrayList arrayList = new ArrayList(listM.size());
            for (C9193Yw5 c9193Yw5 : listM) {
                C21732u24 c21732u24F = abstractC14076hJ1.q().f();
                AbstractC13042fc3.h(c9193Yw5, "it");
                InterfaceC20989sw5 interfaceC20989sw5P = c21732u24F.p(c9193Yw5);
                if (interfaceC20989sw5P != null) {
                    arrayList.add(interfaceC20989sw5P);
                }
            }
            abstractC14076hJ1.m(c6432No4, arrayList);
            return YW0.c(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final InterfaceC7722Sx7 o(C6432No4 c6432No4) {
            C11410cx5 c11410cx5S0;
            byte[] bArr = (byte[]) this.c.get(c6432No4);
            if (bArr == null || (c11410cx5S0 = C11410cx5.s0(new ByteArrayInputStream(bArr), this.i.q().c().j())) == null) {
                return null;
            }
            return this.i.q().f().q(c11410cx5S0);
        }

        private final Map p(Map map) throws IOException {
            LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC19460qO3.f(map.size()));
            for (Map.Entry entry : map.entrySet()) {
                Object key = entry.getKey();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Iterable iterable = (Iterable) entry.getValue();
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(iterable, 10));
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    ((kotlin.reflect.jvm.internal.impl.protobuf.a) it.next()).d(byteArrayOutputStream);
                    arrayList.add(C19938rB7.a);
                }
                linkedHashMap.put(key, byteArrayOutputStream.toByteArray());
            }
            return linkedHashMap;
        }

        @Override // ir.nasim.AbstractC14076hJ1.a
        public Set a() {
            return (Set) MN6.a(this.g, this, j[0]);
        }

        @Override // ir.nasim.AbstractC14076hJ1.a
        public Collection b(C6432No4 c6432No4, IJ3 ij3) {
            AbstractC13042fc3.i(c6432No4, "name");
            AbstractC13042fc3.i(ij3, "location");
            return !c().contains(c6432No4) ? AbstractC10360bX0.m() : (Collection) this.e.invoke(c6432No4);
        }

        @Override // ir.nasim.AbstractC14076hJ1.a
        public Set c() {
            return (Set) MN6.a(this.h, this, j[1]);
        }

        @Override // ir.nasim.AbstractC14076hJ1.a
        public Collection d(C6432No4 c6432No4, IJ3 ij3) {
            AbstractC13042fc3.i(c6432No4, "name");
            AbstractC13042fc3.i(ij3, "location");
            return !a().contains(c6432No4) ? AbstractC10360bX0.m() : (Collection) this.d.invoke(c6432No4);
        }

        @Override // ir.nasim.AbstractC14076hJ1.a
        public Set e() {
            return this.c.keySet();
        }

        @Override // ir.nasim.AbstractC14076hJ1.a
        public void f(Collection collection, C24841zI1 c24841zI1, UA2 ua2, IJ3 ij3) {
            AbstractC13042fc3.i(collection, "result");
            AbstractC13042fc3.i(c24841zI1, "kindFilter");
            AbstractC13042fc3.i(ua2, "nameFilter");
            AbstractC13042fc3.i(ij3, "location");
            if (c24841zI1.a(C24841zI1.c.k())) {
                Set<C6432No4> setC = c();
                ArrayList arrayList = new ArrayList();
                for (C6432No4 c6432No4 : setC) {
                    if (((Boolean) ua2.invoke(c6432No4)).booleanValue()) {
                        arrayList.addAll(b(c6432No4, ij3));
                    }
                }
                C20455s24 c20455s24 = C20455s24.a;
                AbstractC13042fc3.h(c20455s24, "INSTANCE");
                AbstractC12992fX0.B(arrayList, c20455s24);
                collection.addAll(arrayList);
            }
            if (c24841zI1.a(C24841zI1.c.e())) {
                Set<C6432No4> setA = a();
                ArrayList arrayList2 = new ArrayList();
                for (C6432No4 c6432No42 : setA) {
                    if (((Boolean) ua2.invoke(c6432No42)).booleanValue()) {
                        arrayList2.addAll(d(c6432No42, ij3));
                    }
                }
                C20455s24 c20455s242 = C20455s24.a;
                AbstractC13042fc3.h(c20455s242, "INSTANCE");
                AbstractC12992fX0.B(arrayList2, c20455s242);
                collection.addAll(arrayList2);
            }
        }

        @Override // ir.nasim.AbstractC14076hJ1.a
        public InterfaceC7722Sx7 g(C6432No4 c6432No4) {
            AbstractC13042fc3.i(c6432No4, "name");
            return (InterfaceC7722Sx7) this.f.invoke(c6432No4);
        }
    }

    /* renamed from: ir.nasim.hJ1$d */
    static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Set invoke() {
            return AbstractC15401jX0.r1((Iterable) this.e.invoke());
        }
    }

    /* renamed from: ir.nasim.hJ1$e */
    static final class e extends AbstractC8614Ws3 implements SA2 {
        e() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Set invoke() {
            Set setT = AbstractC14076hJ1.this.t();
            if (setT == null) {
                return null;
            }
            return AbstractC4846Gu6.l(AbstractC4846Gu6.l(AbstractC14076hJ1.this.r(), AbstractC14076hJ1.this.c.e()), setT);
        }
    }

    protected AbstractC14076hJ1(WI1 wi1, List list, List list2, List list3, SA2 sa2) {
        AbstractC13042fc3.i(wi1, "c");
        AbstractC13042fc3.i(list, "functionList");
        AbstractC13042fc3.i(list2, "propertyList");
        AbstractC13042fc3.i(list3, "typeAliasList");
        AbstractC13042fc3.i(sa2, "classNames");
        this.b = wi1;
        this.c = o(list, list2, list3);
        this.d = wi1.h().c(new d(sa2));
        this.e = wi1.h().g(new e());
    }

    private final a o(List list, List list2, List list3) {
        return this.b.c().g().a() ? new b(this, list, list2, list3) : new c(this, list, list2, list3);
    }

    private final InterfaceC21331tU0 p(C6432No4 c6432No4) {
        return this.b.c().b(n(c6432No4));
    }

    private final Set s() {
        return (Set) MN6.b(this.e, this, f[1]);
    }

    private final InterfaceC7722Sx7 w(C6432No4 c6432No4) {
        return this.c.g(c6432No4);
    }

    @Override // ir.nasim.X24, ir.nasim.W24
    public Set a() {
        return this.c.a();
    }

    @Override // ir.nasim.X24, ir.nasim.W24
    public Collection b(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        return this.c.b(c6432No4, ij3);
    }

    @Override // ir.nasim.X24, ir.nasim.W24
    public Set c() {
        return this.c.c();
    }

    @Override // ir.nasim.X24, ir.nasim.W24
    public Collection d(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        return this.c.d(c6432No4, ij3);
    }

    @Override // ir.nasim.X24, ir.nasim.InterfaceC22011uW5
    public MU0 e(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        if (x(c6432No4)) {
            return p(c6432No4);
        }
        if (this.c.e().contains(c6432No4)) {
            return w(c6432No4);
        }
        return null;
    }

    @Override // ir.nasim.X24, ir.nasim.W24
    public Set g() {
        return s();
    }

    protected abstract void j(Collection collection, UA2 ua2);

    protected final Collection k(C24841zI1 c24841zI1, UA2 ua2, IJ3 ij3) {
        AbstractC13042fc3.i(c24841zI1, "kindFilter");
        AbstractC13042fc3.i(ua2, "nameFilter");
        AbstractC13042fc3.i(ij3, "location");
        ArrayList arrayList = new ArrayList(0);
        C24841zI1.a aVar = C24841zI1.c;
        if (c24841zI1.a(aVar.h())) {
            j(arrayList, ua2);
        }
        this.c.f(arrayList, c24841zI1, ua2, ij3);
        if (c24841zI1.a(aVar.d())) {
            for (C6432No4 c6432No4 : r()) {
                if (((Boolean) ua2.invoke(c6432No4)).booleanValue()) {
                    YW0.a(arrayList, p(c6432No4));
                }
            }
        }
        if (c24841zI1.a(C24841zI1.c.i())) {
            for (C6432No4 c6432No42 : this.c.e()) {
                if (((Boolean) ua2.invoke(c6432No42)).booleanValue()) {
                    YW0.a(arrayList, this.c.g(c6432No42));
                }
            }
        }
        return YW0.c(arrayList);
    }

    protected void l(C6432No4 c6432No4, List list) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(list, "functions");
    }

    protected void m(C6432No4 c6432No4, List list) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(list, "descriptors");
    }

    protected abstract C24948zU0 n(C6432No4 c6432No4);

    protected final WI1 q() {
        return this.b;
    }

    public final Set r() {
        return (Set) MN6.a(this.d, this, f[0]);
    }

    protected abstract Set t();

    protected abstract Set u();

    protected abstract Set v();

    protected boolean x(C6432No4 c6432No4) {
        AbstractC13042fc3.i(c6432No4, "name");
        return r().contains(c6432No4);
    }

    protected boolean y(JC6 jc6) {
        AbstractC13042fc3.i(jc6, "function");
        return true;
    }
}
