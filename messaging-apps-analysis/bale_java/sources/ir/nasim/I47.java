package ir.nasim;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import ir.nasim.InterfaceC16193kr4;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public final class I47 implements ComponentCallbacks2, InterfaceC16193kr4.a {
    public static final a f = new a(null);
    private final WeakReference a;
    private Context b;
    private InterfaceC16193kr4 c;
    private boolean d;
    private boolean e = true;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public I47(FI5 fi5) {
        this.a = new WeakReference(fi5);
    }

    private final synchronized void d() {
        C19938rB7 c19938rB7;
        try {
            FI5 fi5 = (FI5) this.a.get();
            if (fi5 != null) {
                if (this.c == null) {
                    InterfaceC16193kr4 interfaceC16193kr4A = fi5.p().f() ? AbstractC16784lr4.a(fi5.k(), this, fi5.n()) : new C24736z72();
                    this.c = interfaceC16193kr4A;
                    this.e = interfaceC16193kr4A.a();
                }
                c19938rB7 = C19938rB7.a;
            } else {
                c19938rB7 = null;
            }
            if (c19938rB7 == null) {
                e();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // ir.nasim.InterfaceC16193kr4.a
    public synchronized void a(boolean z) {
        try {
            FI5 fi5 = (FI5) this.a.get();
            C19938rB7 c19938rB7 = null;
            if (fi5 != null) {
                II3 ii3N = fi5.n();
                if (ii3N != null && ii3N.a() <= 4) {
                    ii3N.b("NetworkObserver", 4, z ? "ONLINE" : "OFFLINE", null);
                }
                this.e = z;
                c19938rB7 = C19938rB7.a;
            }
            if (c19938rB7 == null) {
                e();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean b() {
        d();
        return this.e;
    }

    public final synchronized void c() {
        C19938rB7 c19938rB7;
        try {
            FI5 fi5 = (FI5) this.a.get();
            if (fi5 != null) {
                if (this.b == null) {
                    Context contextK = fi5.k();
                    this.b = contextK;
                    contextK.registerComponentCallbacks(this);
                }
                c19938rB7 = C19938rB7.a;
            } else {
                c19938rB7 = null;
            }
            if (c19938rB7 == null) {
                e();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void e() {
        try {
            if (this.d) {
                return;
            }
            this.d = true;
            Context context = this.b;
            if (context != null) {
                context.unregisterComponentCallbacks(this);
            }
            InterfaceC16193kr4 interfaceC16193kr4 = this.c;
            if (interfaceC16193kr4 != null) {
                interfaceC16193kr4.shutdown();
            }
            this.a.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.ComponentCallbacks
    public synchronized void onConfigurationChanged(Configuration configuration) {
        try {
            if ((((FI5) this.a.get()) != null ? C19938rB7.a : null) == null) {
                e();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.ComponentCallbacks
    public synchronized void onLowMemory() {
        onTrimMemory(80);
    }

    @Override // android.content.ComponentCallbacks2
    public synchronized void onTrimMemory(int i) {
        try {
            FI5 fi5 = (FI5) this.a.get();
            C19938rB7 c19938rB7 = null;
            if (fi5 != null) {
                II3 ii3N = fi5.n();
                if (ii3N != null && ii3N.a() <= 2) {
                    ii3N.b("NetworkObserver", 2, "trimMemory, level=" + i, null);
                }
                fi5.t(i);
                c19938rB7 = C19938rB7.a;
            }
            if (c19938rB7 == null) {
                e();
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
