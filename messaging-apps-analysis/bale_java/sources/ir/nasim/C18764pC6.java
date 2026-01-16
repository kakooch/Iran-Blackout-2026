package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenNames;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.pC6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C18764pC6 {
    private final Map a = new LinkedHashMap();

    /* renamed from: ir.nasim.pC6$a */
    public final class a {
        private final String a;
        final /* synthetic */ C18764pC6 b;

        /* renamed from: ir.nasim.pC6$a$a, reason: collision with other inner class name */
        public final class C1435a {
            private final String a;
            private final List b;
            private XV4 c;
            final /* synthetic */ a d;

            public C1435a(a aVar, String str) {
                AbstractC13042fc3.i(aVar, "this$0");
                AbstractC13042fc3.i(str, "functionName");
                this.d = aVar;
                this.a = str;
                this.b = new ArrayList();
                this.c = AbstractC4616Fw7.a(TokenNames.V, null);
            }

            public final XV4 a() {
                C17582nC6 c17582nC6 = C17582nC6.a;
                String strB = this.d.b();
                String strB2 = b();
                List list = this.b;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) ((XV4) it.next()).e());
                }
                String strK = c17582nC6.k(strB, c17582nC6.j(strB2, arrayList, (String) this.c.e()));
                C17446my7 c17446my7 = (C17446my7) this.c.f();
                List list2 = this.b;
                ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list2, 10));
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((C17446my7) ((XV4) it2.next()).f());
                }
                return AbstractC4616Fw7.a(strK, new C8067Uj5(c17446my7, arrayList2));
            }

            public final String b() {
                return this.a;
            }

            public final void c(String str, C8056Ui3... c8056Ui3Arr) {
                C17446my7 c17446my7;
                AbstractC13042fc3.i(str, "type");
                AbstractC13042fc3.i(c8056Ui3Arr, "qualifiers");
                List list = this.b;
                if (c8056Ui3Arr.length == 0) {
                    c17446my7 = null;
                } else {
                    Iterable<C14555i63> iterableT1 = AbstractC10242bK.t1(c8056Ui3Arr);
                    LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(AbstractC10976cX0.x(iterableT1, 10)), 16));
                    for (C14555i63 c14555i63 : iterableT1) {
                        linkedHashMap.put(Integer.valueOf(c14555i63.c()), (C8056Ui3) c14555i63.d());
                    }
                    c17446my7 = new C17446my7(linkedHashMap);
                }
                list.add(AbstractC4616Fw7.a(str, c17446my7));
            }

            public final void d(EnumC7376Rl3 enumC7376Rl3) {
                AbstractC13042fc3.i(enumC7376Rl3, "type");
                String strQ = enumC7376Rl3.q();
                AbstractC13042fc3.h(strQ, "type.desc");
                this.c = AbstractC4616Fw7.a(strQ, null);
            }

            public final void e(String str, C8056Ui3... c8056Ui3Arr) {
                AbstractC13042fc3.i(str, "type");
                AbstractC13042fc3.i(c8056Ui3Arr, "qualifiers");
                Iterable<C14555i63> iterableT1 = AbstractC10242bK.t1(c8056Ui3Arr);
                LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(AbstractC10976cX0.x(iterableT1, 10)), 16));
                for (C14555i63 c14555i63 : iterableT1) {
                    linkedHashMap.put(Integer.valueOf(c14555i63.c()), (C8056Ui3) c14555i63.d());
                }
                this.c = AbstractC4616Fw7.a(str, new C17446my7(linkedHashMap));
            }
        }

        public a(C18764pC6 c18764pC6, String str) {
            AbstractC13042fc3.i(c18764pC6, "this$0");
            AbstractC13042fc3.i(str, "className");
            this.b = c18764pC6;
            this.a = str;
        }

        public final void a(String str, UA2 ua2) {
            AbstractC13042fc3.i(str, "name");
            AbstractC13042fc3.i(ua2, "block");
            Map map = this.b.a;
            C1435a c1435a = new C1435a(this, str);
            ua2.invoke(c1435a);
            XV4 xv4A = c1435a.a();
            map.put(xv4A.e(), xv4A.f());
        }

        public final String b() {
            return this.a;
        }
    }

    public final Map b() {
        return this.a;
    }
}
