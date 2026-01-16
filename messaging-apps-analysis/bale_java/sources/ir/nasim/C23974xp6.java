package ir.nasim;

import ir.nasim.C9475a16;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: ir.nasim.xp6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C23974xp6 extends AbstractC6703Op6 implements Iterator, InterfaceC20295rm1, InterfaceC17915nm3 {
    private int a;
    private Object b;
    private Iterator c;
    private InterfaceC20295rm1 d;

    private final Throwable f() {
        int i = this.a;
        if (i == 4) {
            return new NoSuchElementException();
        }
        if (i == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.a);
    }

    private final Object g() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    @Override // ir.nasim.AbstractC6703Op6
    public Object c(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
        this.b = obj;
        this.a = 3;
        this.d = interfaceC20295rm1;
        Object objE = AbstractC14862ic3.e();
        if (objE == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
    }

    @Override // ir.nasim.AbstractC6703Op6
    public Object e(Iterator it, InterfaceC20295rm1 interfaceC20295rm1) {
        if (!it.hasNext()) {
            return C19938rB7.a;
        }
        this.c = it;
        this.a = 2;
        this.d = interfaceC20295rm1;
        Object objE = AbstractC14862ic3.e();
        if (objE == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC20295rm1
    public InterfaceC11938do1 getContext() {
        return C18712p72.a;
    }

    public final void h(InterfaceC20295rm1 interfaceC20295rm1) {
        this.d = interfaceC20295rm1;
    }

    @Override // java.util.Iterator
    public boolean hasNext() throws Throwable {
        while (true) {
            int i = this.a;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2 || i == 3) {
                        return true;
                    }
                    if (i == 4) {
                        return false;
                    }
                    throw f();
                }
                Iterator it = this.c;
                AbstractC13042fc3.f(it);
                if (it.hasNext()) {
                    this.a = 2;
                    return true;
                }
                this.c = null;
            }
            this.a = 5;
            InterfaceC20295rm1 interfaceC20295rm1 = this.d;
            AbstractC13042fc3.f(interfaceC20295rm1);
            this.d = null;
            C9475a16.a aVar = C9475a16.b;
            interfaceC20295rm1.resumeWith(C9475a16.b(C19938rB7.a));
        }
    }

    @Override // java.util.Iterator
    public Object next() throws Throwable {
        int i = this.a;
        if (i == 0 || i == 1) {
            return g();
        }
        if (i == 2) {
            this.a = 1;
            Iterator it = this.c;
            AbstractC13042fc3.f(it);
            return it.next();
        }
        if (i != 3) {
            throw f();
        }
        this.a = 0;
        Object obj = this.b;
        this.b = null;
        return obj;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // ir.nasim.InterfaceC20295rm1
    public void resumeWith(Object obj) {
        AbstractC10685c16.b(obj);
        this.a = 4;
    }
}
