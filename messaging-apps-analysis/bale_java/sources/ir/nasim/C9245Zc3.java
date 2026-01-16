package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: ir.nasim.Zc3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C9245Zc3 {
    private final UA2 a;
    private final SA2 b;
    private final ReentrantLock c;
    private final List d;
    private boolean e;

    public C9245Zc3(UA2 ua2, SA2 sa2) {
        AbstractC13042fc3.i(ua2, "callbackInvoker");
        this.a = ua2;
        this.b = sa2;
        this.c = new ReentrantLock();
        this.d = new ArrayList();
    }

    public final boolean a() {
        return this.e;
    }

    public final boolean b() {
        if (this.e) {
            return false;
        }
        ReentrantLock reentrantLock = this.c;
        try {
            reentrantLock.lock();
            if (this.e) {
                return false;
            }
            this.e = true;
            List listM1 = AbstractC15401jX0.m1(this.d);
            this.d.clear();
            reentrantLock.unlock();
            UA2 ua2 = this.a;
            Iterator it = listM1.iterator();
            while (it.hasNext()) {
                ua2.invoke(it.next());
            }
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void c(Object obj) {
        SA2 sa2 = this.b;
        boolean z = true;
        if (sa2 != null && ((Boolean) sa2.invoke()).booleanValue()) {
            b();
        }
        if (this.e) {
            this.a.invoke(obj);
            return;
        }
        ReentrantLock reentrantLock = this.c;
        try {
            reentrantLock.lock();
            if (!this.e) {
                this.d.add(obj);
                z = false;
            }
            if (z) {
                this.a.invoke(obj);
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void d(Object obj) {
        ReentrantLock reentrantLock = this.c;
        try {
            reentrantLock.lock();
            this.d.remove(obj);
        } finally {
            reentrantLock.unlock();
        }
    }

    public /* synthetic */ C9245Zc3(UA2 ua2, SA2 sa2, int i, ED1 ed1) {
        this(ua2, (i & 2) != 0 ? null : sa2);
    }
}
