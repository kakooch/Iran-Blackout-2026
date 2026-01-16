package ir.nasim;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Predicate;

/* renamed from: ir.nasim.v35, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22333v35 {
    private final UA2 a;
    private final HashMap b;

    public C22333v35(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "sendCallback");
        this.a = ua2;
        this.b = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(long j, SP5 sp5) {
        return sp5.e() == j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(UA2 ua2, Object obj) {
        AbstractC13042fc3.i(ua2, "$tmp0");
        return ((Boolean) ua2.invoke(obj)).booleanValue();
    }

    public final void c(int i, SP5 sp5) {
        Object next;
        AbstractC13042fc3.i(sp5, "requestMessage");
        HashMap map = this.b;
        Integer numValueOf = Integer.valueOf(i);
        Object linkedList = map.get(numValueOf);
        if (linkedList == null) {
            linkedList = new LinkedList();
            map.put(numValueOf, linkedList);
        }
        Queue queue = (Queue) linkedList;
        Iterator it = queue.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((SP5) next).e() == sp5.e()) {
                    break;
                }
            }
        }
        if (((SP5) next) != null) {
            return;
        }
        if (queue.size() == 0) {
            this.a.invoke(sp5);
        }
        queue.add(sp5);
    }

    public final void d(int i) {
        Queue queue = (Queue) this.b.get(Integer.valueOf(i));
        if (queue != null) {
            queue.remove();
            SP5 sp5 = (SP5) queue.peek();
            if (sp5 != null) {
                this.a.invoke(sp5);
            }
        }
    }

    public final void e(int i, final long j) {
        Queue queue = (Queue) this.b.get(Integer.valueOf(i));
        if (queue != null) {
            final UA2 ua2 = new UA2() { // from class: ir.nasim.t35
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(C22333v35.f(j, (SP5) obj));
                }
            };
            queue.removeIf(new Predicate() { // from class: ir.nasim.u35
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return C22333v35.g(ua2, obj);
                }
            });
        }
    }
}
