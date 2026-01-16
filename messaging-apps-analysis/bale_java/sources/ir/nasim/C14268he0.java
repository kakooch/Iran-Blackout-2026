package ir.nasim;

import ir.nasim.C15238jF;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: ir.nasim.he0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C14268he0 extends XZ6 {
    static final a[] h = new a[0];
    static final a[] i = new a[0];
    final AtomicReference a;
    final AtomicReference b;
    final ReadWriteLock c;
    final Lock d;
    final Lock e;
    final AtomicReference f;
    long g;

    /* renamed from: ir.nasim.he0$a */
    static final class a implements GV1, C15238jF.a {
        final PG4 a;
        final C14268he0 b;
        boolean c;
        boolean d;
        C15238jF e;
        boolean f;
        volatile boolean g;
        long h;

        a(PG4 pg4, C14268he0 c14268he0) {
            this.a = pg4;
            this.b = c14268he0;
        }

        void a() {
            if (this.g) {
                return;
            }
            synchronized (this) {
                try {
                    if (this.g) {
                        return;
                    }
                    if (this.c) {
                        return;
                    }
                    C14268he0 c14268he0 = this.b;
                    Lock lock = c14268he0.d;
                    lock.lock();
                    this.h = c14268he0.g;
                    Object obj = c14268he0.a.get();
                    lock.unlock();
                    this.d = obj != null;
                    this.c = true;
                    if (obj == null || test(obj)) {
                        return;
                    }
                    b();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        void b() {
            C15238jF c15238jF;
            while (!this.g) {
                synchronized (this) {
                    try {
                        c15238jF = this.e;
                        if (c15238jF == null) {
                            this.d = false;
                            return;
                        }
                        this.e = null;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                c15238jF.c(this);
            }
        }

        void c(Object obj, long j) {
            if (this.g) {
                return;
            }
            if (!this.f) {
                synchronized (this) {
                    try {
                        if (this.g) {
                            return;
                        }
                        if (this.h == j) {
                            return;
                        }
                        if (this.d) {
                            C15238jF c15238jF = this.e;
                            if (c15238jF == null) {
                                c15238jF = new C15238jF(4);
                                this.e = c15238jF;
                            }
                            c15238jF.b(obj);
                            return;
                        }
                        this.c = true;
                        this.f = true;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            test(obj);
        }

        @Override // ir.nasim.GV1
        public void dispose() {
            if (this.g) {
                return;
            }
            this.g = true;
            this.b.m(this);
        }

        @Override // ir.nasim.C15238jF.a
        public boolean test(Object obj) {
            return this.g || EnumC24799zD4.a(obj, this.a);
        }
    }

    C14268he0(Object obj) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.c = reentrantReadWriteLock;
        this.d = reentrantReadWriteLock.readLock();
        this.e = reentrantReadWriteLock.writeLock();
        this.b = new AtomicReference(h);
        this.a = new AtomicReference(obj);
        this.f = new AtomicReference();
    }

    public static C14268he0 l() {
        return new C14268he0(null);
    }

    @Override // ir.nasim.PG4
    public void a(Throwable th) {
        AbstractC8226Vb2.b(th, "onError called with a null Throwable.");
        if (!AbstractC16775lq5.a(this.f, null, th)) {
            D76.d(th);
            return;
        }
        Object objQ = EnumC24799zD4.q(th);
        for (a aVar : o(objQ)) {
            aVar.c(objQ, this.g);
        }
    }

    @Override // ir.nasim.PG4
    public void b(GV1 gv1) {
        if (this.f.get() != null) {
            gv1.dispose();
        }
    }

    @Override // ir.nasim.PG4
    public void c() {
        if (AbstractC16775lq5.a(this.f, null, AbstractC8226Vb2.a)) {
            Object objP = EnumC24799zD4.p();
            for (a aVar : o(objP)) {
                aVar.c(objP, this.g);
            }
        }
    }

    @Override // ir.nasim.PG4
    public void e(Object obj) {
        AbstractC8226Vb2.b(obj, "onNext called with a null value.");
        if (this.f.get() != null) {
            return;
        }
        Object objR = EnumC24799zD4.r(obj);
        n(objR);
        for (a aVar : (a[]) this.b.get()) {
            aVar.c(objR, this.g);
        }
    }

    @Override // ir.nasim.IG4
    protected void j(PG4 pg4) {
        a aVar = new a(pg4, this);
        pg4.b(aVar);
        if (k(aVar)) {
            if (aVar.g) {
                m(aVar);
                return;
            } else {
                aVar.a();
                return;
            }
        }
        Throwable th = (Throwable) this.f.get();
        if (th == AbstractC8226Vb2.a) {
            pg4.c();
        } else {
            pg4.a(th);
        }
    }

    boolean k(a aVar) {
        a[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = (a[]) this.b.get();
            if (aVarArr == i) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!AbstractC16775lq5.a(this.b, aVarArr, aVarArr2));
        return true;
    }

    void m(a aVar) {
        a[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = (a[]) this.b.get();
            int length = aVarArr.length;
            if (length == 0) {
                return;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    i2 = -1;
                    break;
                } else if (aVarArr[i2] == aVar) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 < 0) {
                return;
            }
            if (length == 1) {
                aVarArr2 = h;
            } else {
                a[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!AbstractC16775lq5.a(this.b, aVarArr, aVarArr2));
    }

    void n(Object obj) {
        this.e.lock();
        this.g++;
        this.a.lazySet(obj);
        this.e.unlock();
    }

    a[] o(Object obj) {
        n(obj);
        return (a[]) this.b.getAndSet(i);
    }
}
