package ir.nasim;

import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Eu, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public interface InterfaceC4356Eu extends Iterable, InterfaceC17915nm3 {
    public static final a W = a.a;

    /* renamed from: ir.nasim.Eu$a */
    public static final class a {
        static final /* synthetic */ a a = new a();
        private static final InterfaceC4356Eu b = new C0348a();

        /* renamed from: ir.nasim.Eu$a$a, reason: collision with other inner class name */
        public static final class C0348a implements InterfaceC4356Eu {
            C0348a() {
            }

            @Override // ir.nasim.InterfaceC4356Eu
            public boolean M1(C9424Zw2 c9424Zw2) {
                return b.b(this, c9424Zw2);
            }

            public Void f(C9424Zw2 c9424Zw2) {
                AbstractC13042fc3.i(c9424Zw2, "fqName");
                return null;
            }

            @Override // ir.nasim.InterfaceC4356Eu
            public boolean isEmpty() {
                return true;
            }

            @Override // java.lang.Iterable
            public Iterator iterator() {
                return AbstractC10360bX0.m().iterator();
            }

            public String toString() {
                return "EMPTY";
            }

            @Override // ir.nasim.InterfaceC4356Eu
            public /* bridge */ /* synthetic */ InterfaceC21651tu z(C9424Zw2 c9424Zw2) {
                return (InterfaceC21651tu) f(c9424Zw2);
            }
        }

        private a() {
        }

        public final InterfaceC4356Eu a(List list) {
            AbstractC13042fc3.i(list, "annotations");
            return list.isEmpty() ? b : new C4590Fu(list);
        }

        public final InterfaceC4356Eu b() {
            return b;
        }
    }

    /* renamed from: ir.nasim.Eu$b */
    public static final class b {
        public static InterfaceC21651tu a(InterfaceC4356Eu interfaceC4356Eu, C9424Zw2 c9424Zw2) {
            Object next;
            AbstractC13042fc3.i(interfaceC4356Eu, "this");
            AbstractC13042fc3.i(c9424Zw2, "fqName");
            Iterator it = interfaceC4356Eu.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (AbstractC13042fc3.d(((InterfaceC21651tu) next).e(), c9424Zw2)) {
                    break;
                }
            }
            return (InterfaceC21651tu) next;
        }

        public static boolean b(InterfaceC4356Eu interfaceC4356Eu, C9424Zw2 c9424Zw2) {
            AbstractC13042fc3.i(interfaceC4356Eu, "this");
            AbstractC13042fc3.i(c9424Zw2, "fqName");
            return interfaceC4356Eu.z(c9424Zw2) != null;
        }
    }

    boolean M1(C9424Zw2 c9424Zw2);

    boolean isEmpty();

    InterfaceC21651tu z(C9424Zw2 c9424Zw2);
}
