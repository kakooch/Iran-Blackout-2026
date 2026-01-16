package ir.nasim;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: ir.nasim.yx3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C24639yx3 implements InterfaceC7959Tx5 {
    private volatile Set b = null;
    private volatile Set a = Collections.newSetFromMap(new ConcurrentHashMap());

    C24639yx3(Collection collection) {
        this.a.addAll(collection);
    }

    static C24639yx3 b(Collection collection) {
        return new C24639yx3((Set) collection);
    }

    private synchronized void d() {
        try {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                this.b.add(((InterfaceC7959Tx5) it.next()).get());
            }
            this.a = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    synchronized void a(InterfaceC7959Tx5 interfaceC7959Tx5) {
        try {
            if (this.b == null) {
                this.a.add(interfaceC7959Tx5);
            } else {
                this.b.add(interfaceC7959Tx5.get());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // ir.nasim.InterfaceC7959Tx5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Set get() {
        if (this.b == null) {
            synchronized (this) {
                try {
                    if (this.b == null) {
                        this.b = Collections.newSetFromMap(new ConcurrentHashMap());
                        d();
                    }
                } finally {
                }
            }
        }
        return Collections.unmodifiableSet(this.b);
    }
}
