package ir.nasim;

import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.lifecycle.j;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.gz3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C13887gz3 {
    private final Object a = new Object();
    private final Map b = new HashMap();
    private final Map c = new HashMap();
    private final ArrayDeque d = new ArrayDeque();
    MC0 e;

    /* renamed from: ir.nasim.gz3$a */
    static abstract class a {
        a() {
        }

        static a a(InterfaceC18633oz3 interfaceC18633oz3, CameraUseCaseAdapter.a aVar) {
            return new C17137mT(interfaceC18633oz3, aVar);
        }

        public abstract CameraUseCaseAdapter.a b();

        public abstract InterfaceC18633oz3 c();
    }

    /* renamed from: ir.nasim.gz3$b */
    private static class b implements InterfaceC18042nz3 {
        private final C13887gz3 a;
        private final InterfaceC18633oz3 b;

        b(InterfaceC18633oz3 interfaceC18633oz3, C13887gz3 c13887gz3) {
            this.b = interfaceC18633oz3;
            this.a = c13887gz3;
        }

        InterfaceC18633oz3 a() {
            return this.b;
        }

        @androidx.lifecycle.t(j.a.ON_DESTROY)
        public void onDestroy(InterfaceC18633oz3 interfaceC18633oz3) {
            this.a.l(interfaceC18633oz3);
        }

        @androidx.lifecycle.t(j.a.ON_START)
        public void onStart(InterfaceC18633oz3 interfaceC18633oz3) {
            this.a.h(interfaceC18633oz3);
        }

        @androidx.lifecycle.t(j.a.ON_STOP)
        public void onStop(InterfaceC18633oz3 interfaceC18633oz3) {
            this.a.i(interfaceC18633oz3);
        }
    }

    C13887gz3() {
    }

    private b d(InterfaceC18633oz3 interfaceC18633oz3) {
        synchronized (this.a) {
            try {
                for (b bVar : this.c.keySet()) {
                    if (interfaceC18633oz3.equals(bVar.a())) {
                        return bVar;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean f(InterfaceC18633oz3 interfaceC18633oz3) {
        synchronized (this.a) {
            try {
                b bVarD = d(interfaceC18633oz3);
                if (bVarD == null) {
                    return false;
                }
                Iterator it = ((Set) this.c.get(bVarD)).iterator();
                while (it.hasNext()) {
                    if (!((C13296fz3) AbstractC4980Hj5.g((C13296fz3) this.b.get((a) it.next()))).u().isEmpty()) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void g(C13296fz3 c13296fz3) {
        synchronized (this.a) {
            try {
                InterfaceC18633oz3 interfaceC18633oz3R = c13296fz3.r();
                a aVarA = a.a(interfaceC18633oz3R, CameraUseCaseAdapter.A((S06) c13296fz3.a(), (S06) c13296fz3.t()));
                b bVarD = d(interfaceC18633oz3R);
                Set hashSet = bVarD != null ? (Set) this.c.get(bVarD) : new HashSet();
                hashSet.add(aVarA);
                this.b.put(aVarA, c13296fz3);
                if (bVarD == null) {
                    b bVar = new b(interfaceC18633oz3R, this);
                    this.c.put(bVar, hashSet);
                    interfaceC18633oz3R.getLifecycle().a(bVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void j(InterfaceC18633oz3 interfaceC18633oz3) {
        synchronized (this.a) {
            try {
                b bVarD = d(interfaceC18633oz3);
                if (bVarD == null) {
                    return;
                }
                Iterator it = ((Set) this.c.get(bVarD)).iterator();
                while (it.hasNext()) {
                    ((C13296fz3) AbstractC4980Hj5.g((C13296fz3) this.b.get((a) it.next()))).w();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void m(InterfaceC18633oz3 interfaceC18633oz3) {
        synchronized (this.a) {
            try {
                Iterator it = ((Set) this.c.get(d(interfaceC18633oz3))).iterator();
                while (it.hasNext()) {
                    C13296fz3 c13296fz3 = (C13296fz3) this.b.get((a) it.next());
                    if (!((C13296fz3) AbstractC4980Hj5.g(c13296fz3)).u().isEmpty()) {
                        c13296fz3.z();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void a(C13296fz3 c13296fz3, C22022uX7 c22022uX7, List list, Collection collection, MC0 mc0) {
        synchronized (this.a) {
            try {
                AbstractC4980Hj5.a(!collection.isEmpty());
                this.e = mc0;
                InterfaceC18633oz3 interfaceC18633oz3R = c13296fz3.r();
                b bVarD = d(interfaceC18633oz3R);
                if (bVarD == null) {
                    return;
                }
                Set set = (Set) this.c.get(bVarD);
                MC0 mc02 = this.e;
                if (mc02 == null || mc02.c() != 2) {
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        C13296fz3 c13296fz32 = (C13296fz3) AbstractC4980Hj5.g((C13296fz3) this.b.get((a) it.next()));
                        if (!c13296fz32.equals(c13296fz3) && !c13296fz32.u().isEmpty()) {
                            throw new IllegalArgumentException("Multiple LifecycleCameras with use cases are registered to the same LifecycleOwner.");
                        }
                    }
                }
                try {
                    c13296fz3.g().c0(c22022uX7);
                    c13296fz3.g().a0(list);
                    c13296fz3.f(collection);
                    if (interfaceC18633oz3R.getLifecycle().b().j(j.b.STARTED)) {
                        h(interfaceC18633oz3R);
                    }
                } catch (CameraUseCaseAdapter.CameraException e) {
                    throw new IllegalArgumentException(e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    C13296fz3 b(InterfaceC18633oz3 interfaceC18633oz3, CameraUseCaseAdapter cameraUseCaseAdapter) {
        synchronized (this.a) {
            try {
                AbstractC4980Hj5.b(this.b.get(a.a(interfaceC18633oz3, cameraUseCaseAdapter.C())) == null, "LifecycleCamera already exists for the given LifecycleOwner and set of cameras");
                C13296fz3 c13296fz3 = new C13296fz3(interfaceC18633oz3, cameraUseCaseAdapter);
                if (cameraUseCaseAdapter.I().isEmpty()) {
                    c13296fz3.w();
                }
                if (interfaceC18633oz3.getLifecycle().b() == j.b.DESTROYED) {
                    return c13296fz3;
                }
                g(c13296fz3);
                return c13296fz3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    C13296fz3 c(InterfaceC18633oz3 interfaceC18633oz3, CameraUseCaseAdapter.a aVar) {
        C13296fz3 c13296fz3;
        synchronized (this.a) {
            c13296fz3 = (C13296fz3) this.b.get(a.a(interfaceC18633oz3, aVar));
        }
        return c13296fz3;
    }

    Collection e() {
        Collection collectionUnmodifiableCollection;
        synchronized (this.a) {
            collectionUnmodifiableCollection = Collections.unmodifiableCollection(this.b.values());
        }
        return collectionUnmodifiableCollection;
    }

    void h(InterfaceC18633oz3 interfaceC18633oz3) {
        synchronized (this.a) {
            try {
                if (f(interfaceC18633oz3)) {
                    if (this.d.isEmpty()) {
                        this.d.push(interfaceC18633oz3);
                    } else {
                        MC0 mc0 = this.e;
                        if (mc0 == null || mc0.c() != 2) {
                            InterfaceC18633oz3 interfaceC18633oz32 = (InterfaceC18633oz3) this.d.peek();
                            if (!interfaceC18633oz3.equals(interfaceC18633oz32)) {
                                j(interfaceC18633oz32);
                                this.d.remove(interfaceC18633oz3);
                                this.d.push(interfaceC18633oz3);
                            }
                        }
                    }
                    m(interfaceC18633oz3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void i(InterfaceC18633oz3 interfaceC18633oz3) {
        synchronized (this.a) {
            try {
                this.d.remove(interfaceC18633oz3);
                j(interfaceC18633oz3);
                if (!this.d.isEmpty()) {
                    m((InterfaceC18633oz3) this.d.peek());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void k() {
        synchronized (this.a) {
            try {
                Iterator it = this.b.keySet().iterator();
                while (it.hasNext()) {
                    C13296fz3 c13296fz3 = (C13296fz3) this.b.get((a) it.next());
                    c13296fz3.x();
                    i(c13296fz3.r());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void l(InterfaceC18633oz3 interfaceC18633oz3) {
        synchronized (this.a) {
            try {
                b bVarD = d(interfaceC18633oz3);
                if (bVarD == null) {
                    return;
                }
                i(interfaceC18633oz3);
                Iterator it = ((Set) this.c.get(bVarD)).iterator();
                while (it.hasNext()) {
                    this.b.remove((a) it.next());
                }
                this.c.remove(bVarD);
                bVarD.a().getLifecycle().d(bVarD);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
