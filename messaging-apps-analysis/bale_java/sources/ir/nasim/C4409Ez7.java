package ir.nasim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: ir.nasim.Ez7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C4409Ez7 extends AbstractC6360Ng4 {
    private C9057Yh4 m;
    private HashMap n;
    private HashSet o;
    private HashMap p;
    private HashMap q;

    /* renamed from: ir.nasim.Ez7$a */
    public static class a {
        private int a;
        private int b;
        private EnumC5360Iz7 c;

        public a(int i, int i2, EnumC5360Iz7 enumC5360Iz7) {
            this.a = i;
            this.b = i2;
            this.c = enumC5360Iz7;
        }

        public int a() {
            return this.a;
        }

        public EnumC5360Iz7 b() {
            return this.c;
        }

        public int c() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.c == aVar.c && this.b == aVar.b;
        }

        public int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.c.p();
        }
    }

    /* renamed from: ir.nasim.Ez7$b */
    public static class b {
        private int a;
        private EnumC5360Iz7 b;

        public b(int i, EnumC5360Iz7 enumC5360Iz7) {
            this.a = i;
            this.b = enumC5360Iz7;
        }

        public EnumC5360Iz7 a() {
            return this.b;
        }

        public int b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.b == bVar.b && this.a == bVar.a;
        }

        public int hashCode() {
            return (this.a * 31) + this.b.p();
        }
    }

    /* renamed from: ir.nasim.Ez7$c */
    public static class c {
        private int a;
        private int b;
        private EnumC5360Iz7 c;

        public c(int i, int i2, EnumC5360Iz7 enumC5360Iz7) {
            this.a = i;
            this.b = i2;
            this.c = enumC5360Iz7;
        }

        public int a() {
            return this.a;
        }

        public EnumC5360Iz7 b() {
            return this.c;
        }

        public int c() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            return this.a == cVar.a && this.b == cVar.b;
        }

        public int hashCode() {
            return (this.a * 31) + this.b;
        }
    }

    /* renamed from: ir.nasim.Ez7$d */
    public static class d {
        private int a;
        private EnumC5360Iz7 b;

        public d(int i, EnumC5360Iz7 enumC5360Iz7) {
            this.a = i;
            this.b = enumC5360Iz7;
        }

        public EnumC5360Iz7 a() {
            return this.b;
        }

        public int b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.a == dVar.a && this.b == dVar.b;
        }

        public int hashCode() {
            return this.a;
        }
    }

    public C4409Ez7(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        this.n = new HashMap();
        this.o = new HashSet();
        this.p = new HashMap();
        this.q = new HashMap();
        this.m = c9057Yh4;
    }

    public static C9528a7 e0(final C9057Yh4 c9057Yh4) {
        return C12736f7.n().d("actor/typing", new V6() { // from class: ir.nasim.Dz7
            @Override // ir.nasim.V6
            public final K6 create() {
                return C4409Ez7.g0(c9057Yh4);
            }
        });
    }

    private void f0(int i, int i2, EnumC5360Iz7 enumC5360Iz7) {
        if (AbstractC4699Ge3.d(enumC5360Iz7) || this.m.E().X1().d(i) == null || this.m.W().p0().d(i2) == null) {
            return;
        }
        if (this.p.containsKey(Integer.valueOf(i))) {
            HashSet hashSet = (HashSet) this.p.get(Integer.valueOf(i));
            if (!hashSet.contains(Integer.valueOf(i2))) {
                hashSet.add(Integer.valueOf(i2));
                C19482qQ7 c19482qQ7A = this.m.U().A(i).a();
                ArrayList arrayList = new ArrayList((Collection) c19482qQ7A.b());
                arrayList.add(new C11661dO2(i2, enumC5360Iz7));
                c19482qQ7A.i(arrayList);
            }
        } else {
            HashSet hashSet2 = new HashSet();
            hashSet2.add(Integer.valueOf(i2));
            this.p.put(Integer.valueOf(i), hashSet2);
            C12304eO2 c12304eO2A = this.m.U().A(i);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new C11661dO2(i2, enumC5360Iz7));
            c12304eO2A.a().i(arrayList2);
        }
        if (!this.q.containsKey(Integer.valueOf(i))) {
            this.q.put(Integer.valueOf(i), new HashMap());
        }
        HashMap map = (HashMap) this.q.get(Integer.valueOf(i));
        if (map.containsKey(Integer.valueOf(i2))) {
            ((FE0) map.remove(Integer.valueOf(i2))).cancel();
        }
        map.put(Integer.valueOf(i2), q(new c(i, i2, enumC5360Iz7), 7000L));
        this.m.N().G(i2, AbstractC20507s76.p());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ K6 g0(C9057Yh4 c9057Yh4) {
        return new C4409Ez7(c9057Yh4);
    }

    private void h0(int i, EnumC5360Iz7 enumC5360Iz7) {
        if (AbstractC4699Ge3.d(enumC5360Iz7) || this.m.W().p0().d(i) == null) {
            return;
        }
        if (!this.o.contains(Integer.valueOf(i))) {
            this.o.add(Integer.valueOf(i));
            this.m.U().B(i).a().i(enumC5360Iz7);
        }
        FE0 fe0 = (FE0) this.n.remove(Integer.valueOf(i));
        if (fe0 != null) {
            fe0.cancel();
        }
        this.n.put(Integer.valueOf(i), q(new d(i, enumC5360Iz7), 7000L));
        this.m.N().G(i, AbstractC20507s76.p());
    }

    private void i0(int i, int i2, EnumC5360Iz7 enumC5360Iz7) {
        if (!AbstractC4699Ge3.d(enumC5360Iz7) && this.p.containsKey(Integer.valueOf(i))) {
            HashSet hashSet = (HashSet) this.p.get(Integer.valueOf(i));
            if (hashSet.contains(Integer.valueOf(i2))) {
                hashSet.remove(Integer.valueOf(i2));
                ArrayList arrayList = new ArrayList((Collection) this.m.U().A(i).a().b());
                int i3 = 0;
                while (true) {
                    if (i3 >= arrayList.size()) {
                        i3 = -1;
                        break;
                    } else if (((C11661dO2) arrayList.get(i3)).b() == i2) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i3 != -1) {
                    arrayList.remove(i3);
                }
                this.m.U().A(i).a().j(arrayList);
            }
        }
    }

    private void j0(int i, EnumC5360Iz7 enumC5360Iz7) {
        if (!AbstractC4699Ge3.d(enumC5360Iz7) && this.o.contains(Integer.valueOf(i))) {
            this.o.remove(Integer.valueOf(i));
            if (this.n.containsKey(Integer.valueOf(i))) {
                ((FE0) this.n.remove(Integer.valueOf(i))).cancel();
            }
            this.m.U().B(i).a().i(EnumC5360Iz7.b);
        }
    }

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) throws Exception {
        if (obj instanceof b) {
            b bVar = (b) obj;
            h0(bVar.b(), bVar.a());
            return;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            f0(aVar.a(), aVar.c(), aVar.b());
        } else if (obj instanceof d) {
            d dVar = (d) obj;
            j0(dVar.b(), dVar.a());
        } else if (!(obj instanceof c)) {
            super.m(obj);
        } else {
            c cVar = (c) obj;
            i0(cVar.a(), cVar.c(), cVar.b());
        }
    }
}
