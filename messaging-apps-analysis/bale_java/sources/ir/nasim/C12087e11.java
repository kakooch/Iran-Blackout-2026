package ir.nasim;

import ir.nasim.CB1;
import ir.nasim.InterfaceC22734vk2;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.e11, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C12087e11 {
    private final List a;
    private final List b;
    private final List c;
    private final List d;
    private final List e;

    public /* synthetic */ C12087e11(List list, List list2, List list3, List list4, List list5, ED1 ed1) {
        this(list, list2, list3, list4, list5);
    }

    public final List a() {
        return this.e;
    }

    public final List b() {
        return this.d;
    }

    public final List c() {
        return this.a;
    }

    public final List d() {
        return this.c;
    }

    public final List e() {
        return this.b;
    }

    public final String f(Object obj, IL4 il4) {
        List list = this.c;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            XV4 xv4 = (XV4) list.get(i);
            InterfaceC23971xp3 interfaceC23971xp3 = (InterfaceC23971xp3) xv4.a();
            if (((Class) xv4.b()).isAssignableFrom(obj.getClass())) {
                AbstractC13042fc3.g(interfaceC23971xp3, "null cannot be cast to non-null type coil.key.Keyer<kotlin.Any>");
                String strA = interfaceC23971xp3.a(obj, il4);
                if (strA != null) {
                    return strA;
                }
            }
        }
        return null;
    }

    public final Object g(Object obj, IL4 il4) {
        List list = this.b;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            XV4 xv4 = (XV4) list.get(i);
            InterfaceC14734iO3 interfaceC14734iO3 = (InterfaceC14734iO3) xv4.a();
            if (((Class) xv4.b()).isAssignableFrom(obj.getClass())) {
                AbstractC13042fc3.g(interfaceC14734iO3, "null cannot be cast to non-null type coil.map.Mapper<kotlin.Any, *>");
                Object objA = interfaceC14734iO3.a(obj, il4);
                if (objA != null) {
                    obj = objA;
                }
            }
        }
        return obj;
    }

    public final a h() {
        return new a(this);
    }

    public final XV4 i(WH6 wh6, IL4 il4, InterfaceC18663p23 interfaceC18663p23, int i) {
        int size = this.e.size();
        while (i < size) {
            CB1 cb1A = ((CB1.a) this.e.get(i)).a(wh6, il4, interfaceC18663p23);
            if (cb1A != null) {
                return AbstractC4616Fw7.a(cb1A, Integer.valueOf(i));
            }
            i++;
        }
        return null;
    }

    public final XV4 j(Object obj, IL4 il4, InterfaceC18663p23 interfaceC18663p23, int i) {
        int size = this.d.size();
        while (i < size) {
            XV4 xv4 = (XV4) this.d.get(i);
            InterfaceC22734vk2.a aVar = (InterfaceC22734vk2.a) xv4.a();
            if (((Class) xv4.b()).isAssignableFrom(obj.getClass())) {
                AbstractC13042fc3.g(aVar, "null cannot be cast to non-null type coil.fetch.Fetcher.Factory<kotlin.Any>");
                InterfaceC22734vk2 interfaceC22734vk2A = aVar.a(obj, il4, interfaceC18663p23);
                if (interfaceC22734vk2A != null) {
                    return AbstractC4616Fw7.a(interfaceC22734vk2A, Integer.valueOf(i));
                }
            }
            i++;
        }
        return null;
    }

    private C12087e11(List list, List list2, List list3, List list4, List list5) {
        this.a = list;
        this.b = list2;
        this.c = list3;
        this.d = list4;
        this.e = list5;
    }

    /* renamed from: ir.nasim.e11$a */
    public static final class a {
        private final List a;
        private final List b;
        private final List c;
        private final List d;
        private final List e;

        public a() {
            this.a = new ArrayList();
            this.b = new ArrayList();
            this.c = new ArrayList();
            this.d = new ArrayList();
            this.e = new ArrayList();
        }

        public final a a(CB1.a aVar) {
            this.e.add(aVar);
            return this;
        }

        public final a b(InterfaceC22734vk2.a aVar, Class cls) {
            this.d.add(AbstractC4616Fw7.a(aVar, cls));
            return this;
        }

        public final a c(InterfaceC23971xp3 interfaceC23971xp3, Class cls) {
            this.c.add(AbstractC4616Fw7.a(interfaceC23971xp3, cls));
            return this;
        }

        public final a d(InterfaceC14734iO3 interfaceC14734iO3, Class cls) {
            this.b.add(AbstractC4616Fw7.a(interfaceC14734iO3, cls));
            return this;
        }

        public final C12087e11 e() {
            return new C12087e11(AbstractC12074e.a(this.a), AbstractC12074e.a(this.b), AbstractC12074e.a(this.c), AbstractC12074e.a(this.d), AbstractC12074e.a(this.e), null);
        }

        public final List f() {
            return this.e;
        }

        public final List g() {
            return this.d;
        }

        public a(C12087e11 c12087e11) {
            this.a = AbstractC15401jX0.p1(c12087e11.c());
            this.b = AbstractC15401jX0.p1(c12087e11.e());
            this.c = AbstractC15401jX0.p1(c12087e11.d());
            this.d = AbstractC15401jX0.p1(c12087e11.b());
            this.e = AbstractC15401jX0.p1(c12087e11.a());
        }
    }

    public C12087e11() {
        this(AbstractC10360bX0.m(), AbstractC10360bX0.m(), AbstractC10360bX0.m(), AbstractC10360bX0.m(), AbstractC10360bX0.m());
    }
}
