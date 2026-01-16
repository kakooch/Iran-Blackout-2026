package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/* renamed from: ir.nasim.pH7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18810pH7 {
    private final String a;
    private final int b;
    private final PriorityQueue c;

    /* renamed from: ir.nasim.pH7$a */
    public interface a {

        /* renamed from: ir.nasim.pH7$a$a, reason: collision with other inner class name */
        public static final class C1440a implements a {
            public static final C1440a a = new C1440a();

            private C1440a() {
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof C1440a);
            }

            public int hashCode() {
                return 1499558863;
            }

            public String toString() {
                return "EmptyQueue";
            }
        }

        /* renamed from: ir.nasim.pH7$a$b */
        public static final class b implements a {
            private final C4890Gz5 a;

            public b(C4890Gz5 c4890Gz5) {
                AbstractC13042fc3.i(c4890Gz5, "item");
                this.a = c4890Gz5;
            }

            public final C4890Gz5 a() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof b) && AbstractC13042fc3.d(this.a, ((b) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode();
            }

            public String toString() {
                return "NewItem(item=" + this.a + Separators.RPAREN;
            }
        }

        /* renamed from: ir.nasim.pH7$a$c */
        public static final class c implements a {
            private final List a;

            public c(List list) {
                AbstractC13042fc3.i(list, "activeItems");
                this.a = list;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof c) && AbstractC13042fc3.d(this.a, ((c) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode();
            }

            public String toString() {
                return "ReachedMaxConcurrentUploads(activeItems=" + this.a + Separators.RPAREN;
            }
        }
    }

    /* renamed from: ir.nasim.pH7$b */
    public static final class b implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC18050o01.d(Long.valueOf(((C4890Gz5) obj).q()), Long.valueOf(((C4890Gz5) obj2).q()));
        }
    }

    public C18810pH7(String str, int i, Comparator comparator) {
        AbstractC13042fc3.i(str, "nameTag");
        AbstractC13042fc3.i(comparator, "comparator");
        this.a = str;
        this.b = i;
        this.c = new PriorityQueue(comparator);
    }

    private final String f() {
        return AbstractC15401jX0.A0(this.c, null, null, null, 0, null, new UA2() { // from class: ir.nasim.oH7
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C18810pH7.g((C4890Gz5) obj);
            }
        }, 31, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence g(C4890Gz5 c4890Gz5) {
        return "Item(id: " + AbstractC24249yI3.a(Long.valueOf(c4890Gz5.o())) + ", isStarted: " + c4890Gz5.w() + ", isPuttingLastChunk: " + c4890Gz5.v() + Separators.RPAREN;
    }

    public final boolean b(C4890Gz5 c4890Gz5) {
        AbstractC13042fc3.i(c4890Gz5, "item");
        return this.c.add(c4890Gz5);
    }

    public final C4890Gz5 c(long j) {
        Object next;
        Iterator it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((C4890Gz5) next).l() == j) {
                break;
            }
        }
        return (C4890Gz5) next;
    }

    public final C4890Gz5 d(long j) {
        Object next;
        Iterator it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((C4890Gz5) next).o() == j) {
                break;
            }
        }
        return (C4890Gz5) next;
    }

    public final a e() {
        Object next;
        if (this.c.isEmpty()) {
            C19406qI3.a(this.a, "Queue is empty, returning null from poll().", new Object[0]);
            return a.C1440a.a;
        }
        PriorityQueue priorityQueue = this.c;
        ArrayList arrayList = new ArrayList();
        for (Object obj : priorityQueue) {
            C4890Gz5 c4890Gz5 = (C4890Gz5) obj;
            AbstractC13042fc3.f(c4890Gz5);
            if (c4890Gz5.w() && !c4890Gz5.v()) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() >= this.b) {
            C19406qI3.a(this.a, "Queue reached the maximum concurrent uploads, returning null from poll().", new Object[0]);
            return new a.c(arrayList);
        }
        Iterator it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!((C4890Gz5) next).w()) {
                break;
            }
        }
        C4890Gz5 c4890Gz52 = (C4890Gz5) next;
        if (c4890Gz52 != null) {
            return new a.b(c4890Gz52);
        }
        C19406qI3.j(this.a, "Queue contains " + this.c.size() + " items, but none of them can be started.\nQueue: " + f(), new Object[0]);
        return a.C1440a.a;
    }

    public final boolean h(C4890Gz5 c4890Gz5) {
        AbstractC13042fc3.i(c4890Gz5, "item");
        return this.c.remove(c4890Gz5);
    }

    public /* synthetic */ C18810pH7(String str, int i, Comparator comparator, int i2, ED1 ed1) {
        this(str, i, (i2 & 4) != 0 ? new b() : comparator);
    }
}
