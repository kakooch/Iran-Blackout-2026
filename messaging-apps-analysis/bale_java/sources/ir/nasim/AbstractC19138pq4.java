package ir.nasim;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: ir.nasim.pq4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC19138pq4 {
    private final ReentrantLock a = new ReentrantLock(true);
    private final InterfaceC9336Zm4 b;
    private final InterfaceC9336Zm4 c;
    private boolean d;
    private final InterfaceC10258bL6 e;
    private final InterfaceC10258bL6 f;

    public AbstractC19138pq4() {
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(AbstractC10360bX0.m());
        this.b = interfaceC9336Zm4A;
        InterfaceC9336Zm4 interfaceC9336Zm4A2 = AbstractC12281eL6.a(AbstractC4597Fu6.d());
        this.c = interfaceC9336Zm4A2;
        this.e = AbstractC6459Nq2.c(interfaceC9336Zm4A);
        this.f = AbstractC6459Nq2.c(interfaceC9336Zm4A2);
    }

    public abstract androidx.navigation.d a(androidx.navigation.i iVar, Bundle bundle);

    public final InterfaceC10258bL6 b() {
        return this.e;
    }

    public final InterfaceC10258bL6 c() {
        return this.f;
    }

    public final boolean d() {
        return this.d;
    }

    public void e(androidx.navigation.d dVar) {
        AbstractC13042fc3.i(dVar, "entry");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.c;
        interfaceC9336Zm4.setValue(AbstractC4846Gu6.k((Set) interfaceC9336Zm4.getValue(), dVar));
    }

    public void f(androidx.navigation.d dVar) {
        int iNextIndex;
        AbstractC13042fc3.i(dVar, "backStackEntry");
        ReentrantLock reentrantLock = this.a;
        reentrantLock.lock();
        try {
            List listP1 = AbstractC15401jX0.p1((Collection) this.e.getValue());
            ListIterator listIterator = listP1.listIterator(listP1.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    iNextIndex = -1;
                    break;
                } else if (AbstractC13042fc3.d(((androidx.navigation.d) listIterator.previous()).f(), dVar.f())) {
                    iNextIndex = listIterator.nextIndex();
                    break;
                }
            }
            listP1.set(iNextIndex, dVar);
            this.b.setValue(listP1);
            C19938rB7 c19938rB7 = C19938rB7.a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public void g(androidx.navigation.d dVar, boolean z) {
        AbstractC13042fc3.i(dVar, "popUpTo");
        ReentrantLock reentrantLock = this.a;
        reentrantLock.lock();
        try {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.b;
            Iterable iterable = (Iterable) interfaceC9336Zm4.getValue();
            ArrayList arrayList = new ArrayList();
            for (Object obj : iterable) {
                if (!(!AbstractC13042fc3.d((androidx.navigation.d) obj, dVar))) {
                    break;
                } else {
                    arrayList.add(obj);
                }
            }
            interfaceC9336Zm4.setValue(arrayList);
            C19938rB7 c19938rB7 = C19938rB7.a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public void h(androidx.navigation.d dVar, boolean z) {
        Object objPrevious;
        AbstractC13042fc3.i(dVar, "popUpTo");
        Iterable iterable = (Iterable) this.c.getValue();
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((androidx.navigation.d) it.next()) == dVar) {
                    Iterable iterable2 = (Iterable) this.e.getValue();
                    if ((iterable2 instanceof Collection) && ((Collection) iterable2).isEmpty()) {
                        return;
                    }
                    Iterator it2 = iterable2.iterator();
                    while (it2.hasNext()) {
                        if (((androidx.navigation.d) it2.next()) == dVar) {
                        }
                    }
                    return;
                }
            }
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.c;
        interfaceC9336Zm4.setValue(AbstractC4846Gu6.m((Set) interfaceC9336Zm4.getValue(), dVar));
        List list = (List) this.e.getValue();
        ListIterator listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
            androidx.navigation.d dVar2 = (androidx.navigation.d) objPrevious;
            if (!AbstractC13042fc3.d(dVar2, dVar) && ((List) this.e.getValue()).lastIndexOf(dVar2) < ((List) this.e.getValue()).lastIndexOf(dVar)) {
                break;
            }
        }
        androidx.navigation.d dVar3 = (androidx.navigation.d) objPrevious;
        if (dVar3 != null) {
            InterfaceC9336Zm4 interfaceC9336Zm42 = this.c;
            interfaceC9336Zm42.setValue(AbstractC4846Gu6.m((Set) interfaceC9336Zm42.getValue(), dVar3));
        }
        g(dVar, z);
    }

    public void i(androidx.navigation.d dVar) {
        AbstractC13042fc3.i(dVar, "backStackEntry");
        ReentrantLock reentrantLock = this.a;
        reentrantLock.lock();
        try {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.b;
            interfaceC9336Zm4.setValue(AbstractC15401jX0.S0((Collection) interfaceC9336Zm4.getValue(), dVar));
            C19938rB7 c19938rB7 = C19938rB7.a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void j(androidx.navigation.d dVar) {
        AbstractC13042fc3.i(dVar, "backStackEntry");
        Iterable iterable = (Iterable) this.c.getValue();
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((androidx.navigation.d) it.next()) == dVar) {
                    Iterable iterable2 = (Iterable) this.e.getValue();
                    if (!(iterable2 instanceof Collection) || !((Collection) iterable2).isEmpty()) {
                        Iterator it2 = iterable2.iterator();
                        while (it2.hasNext()) {
                            if (((androidx.navigation.d) it2.next()) == dVar) {
                                return;
                            }
                        }
                    }
                }
            }
        }
        androidx.navigation.d dVar2 = (androidx.navigation.d) AbstractC15401jX0.F0((List) this.e.getValue());
        if (dVar2 != null) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.c;
            interfaceC9336Zm4.setValue(AbstractC4846Gu6.m((Set) interfaceC9336Zm4.getValue(), dVar2));
        }
        InterfaceC9336Zm4 interfaceC9336Zm42 = this.c;
        interfaceC9336Zm42.setValue(AbstractC4846Gu6.m((Set) interfaceC9336Zm42.getValue(), dVar));
        i(dVar);
    }

    public final void k(boolean z) {
        this.d = z;
    }
}
