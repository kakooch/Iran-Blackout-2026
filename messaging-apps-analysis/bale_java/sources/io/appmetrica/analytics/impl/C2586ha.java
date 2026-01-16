package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreapi.internal.identifiers.PlatformIdentifiers;
import io.appmetrica.analytics.coreapi.internal.system.PermissionExtractor;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceProvider;
import io.appmetrica.analytics.coreutils.internal.services.WaitForActivationDelayBarrier;
import io.appmetrica.analytics.locationapi.internal.LocationClient;

/* renamed from: io.appmetrica.analytics.impl.ha, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2586ha {
    public static volatile C2586ha C;
    public final Context a;
    public volatile Af b;
    public volatile B6 c;
    public volatile Z2 e;
    public volatile Ci f;
    public volatile S g;
    public volatile C2431b2 h;
    public volatile PlatformIdentifiers i;
    public volatile He j;
    public volatile Q3 k;
    public volatile C2733ne l;
    public volatile wn m;
    public volatile C2880ti n;
    public volatile C2969xb o;
    public C3026zk p;
    public volatile C3001yj r;
    public volatile Bb w;
    public volatile C2669km x;
    public volatile C2858sk y;
    public volatile Vc z;
    public final C2562ga q = new C2562ga();
    public final C3018zc s = new C3018zc();
    public final Bc t = new Bc();
    public final C2597hl u = new C2597hl();
    public final C2762oj v = new C2762oj();
    public final C2636jd A = new C2636jd();
    public final UtilityServiceProvider B = new UtilityServiceProvider();
    public final C2881tj d = new C2881tj();

    public C2586ha(Context context) {
        this.a = context;
    }

    public static void a(Context context) {
        if (C == null) {
            synchronized (C2586ha.class) {
                try {
                    if (C == null) {
                        C = new C2586ha(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
    }

    public static C2586ha h() {
        return C;
    }

    public final synchronized wn A() {
        try {
            if (this.m == null) {
                this.m = new wn(this.a);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.m;
    }

    public final void B() {
        if (this.j == null) {
            synchronized (this) {
                try {
                    if (this.j == null) {
                        Rl rlA = Ql.a(C2828re.class);
                        Context context = this.a;
                        ProtobufStateStorage<Object> protobufStateStorageA = rlA.a(context, rlA.c(context));
                        C2828re c2828re = (C2828re) protobufStateStorageA.read();
                        this.j = new He(this.a, protobufStateStorageA, new C2996ye(), new C2781pe(c2828re), new Ge(), new C2972xe(this.a), new Ce(h().w()), new C2852se(), c2828re, "[PreloadInfoStorage]");
                    }
                } finally {
                }
            }
        }
    }

    public final C2431b2 b() {
        C2431b2 c2431b2 = this.h;
        if (c2431b2 == null) {
            synchronized (this) {
                try {
                    c2431b2 = this.h;
                    if (c2431b2 == null) {
                        c2431b2 = new C2431b2(this.a, AbstractC2456c2.a());
                        this.h = c2431b2;
                    }
                } finally {
                }
            }
        }
        return c2431b2;
    }

    public final C2578h2 c() {
        return i().b;
    }

    public final Q3 d() {
        if (this.k == null) {
            synchronized (this) {
                try {
                    if (this.k == null) {
                        Rl rlA = Ql.a(J3.class);
                        Context context = this.a;
                        ProtobufStateStorage<Object> protobufStateStorageA = rlA.a(context, rlA.c(context));
                        this.k = new Q3(this.a, protobufStateStorageA, new R3(), new E3(), new U3(), new C2594hi(this.a), new S3(w()), new F3(), (J3) protobufStateStorageA.read(), "[ClidsInfoStorage]");
                    }
                } finally {
                }
            }
        }
        return this.k;
    }

    public final Context e() {
        return this.a;
    }

    public final B6 f() {
        if (this.c == null) {
            synchronized (this) {
                try {
                    if (this.c == null) {
                        this.c = new B6(new A6(w()));
                    }
                } finally {
                }
            }
        }
        return this.c;
    }

    public final PermissionExtractor g() {
        C2858sk c2858sk = this.y;
        if (c2858sk != null) {
            return c2858sk;
        }
        synchronized (this) {
            try {
                C2858sk c2858sk2 = this.y;
                if (c2858sk2 != null) {
                    return c2858sk2;
                }
                C2858sk c2858sk3 = new C2858sk(m().c.getAskForPermissionStrategy());
                this.y = c2858sk3;
                return c2858sk3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final C2969xb i() {
        C2969xb c2969xb = this.o;
        if (c2969xb == null) {
            synchronized (this) {
                try {
                    c2969xb = this.o;
                    if (c2969xb == null) {
                        c2969xb = new C2969xb(new W2(this.a, this.d.a()), new C2578h2());
                        this.o = c2969xb;
                    }
                } finally {
                }
            }
        }
        return c2969xb;
    }

    public final Bb j() {
        Bb db = this.w;
        if (db == null) {
            synchronized (this) {
                try {
                    db = this.w;
                    if (db == null) {
                        Context context = this.a;
                        LocationClient locationClient = (LocationClient) ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor("io.appmetrica.analytics.location.internal.LocationClientImpl", LocationClient.class);
                        db = locationClient == null ? new Db() : new Cb(context, new Ib(), locationClient);
                        this.w = db;
                    }
                } finally {
                }
            }
        }
        return db;
    }

    public final Bb k() {
        return j();
    }

    public final Bc l() {
        return this.t;
    }

    public final C3001yj m() {
        C3001yj c3001yj = this.r;
        if (c3001yj == null) {
            synchronized (this) {
                try {
                    c3001yj = this.r;
                    if (c3001yj == null) {
                        c3001yj = new C3001yj();
                        this.r = c3001yj;
                    }
                } finally {
                }
            }
        }
        return c3001yj;
    }

    public final Vc n() {
        Vc vc = this.z;
        if (vc == null) {
            synchronized (this) {
                try {
                    vc = this.z;
                    if (vc == null) {
                        vc = new Vc(this.a, new jn());
                        this.z = vc;
                    }
                } finally {
                }
            }
        }
        return vc;
    }

    public final C2636jd o() {
        return this.A;
    }

    public final PlatformIdentifiers p() {
        PlatformIdentifiers platformIdentifiers = this.i;
        if (platformIdentifiers == null) {
            synchronized (this) {
                try {
                    platformIdentifiers = this.i;
                    if (platformIdentifiers == null) {
                        platformIdentifiers = new PlatformIdentifiers(v(), b());
                        this.i = platformIdentifiers;
                    }
                } finally {
                }
            }
        }
        return platformIdentifiers;
    }

    public final He q() {
        B();
        return this.j;
    }

    public final Af r() {
        if (this.b == null) {
            synchronized (this) {
                try {
                    if (this.b == null) {
                        this.b = new Af(this.a, C.A().c);
                    }
                } finally {
                }
            }
        }
        return this.b;
    }

    public final C2880ti s() {
        C2880ti c2880ti = this.n;
        if (c2880ti == null) {
            synchronized (this) {
                try {
                    c2880ti = this.n;
                    if (c2880ti == null) {
                        c2880ti = new C2880ti(this.a);
                        this.n = c2880ti;
                    }
                } finally {
                }
            }
        }
        return c2880ti;
    }

    public final synchronized Ci t() {
        return this.f;
    }

    public final C2881tj u() {
        return this.d;
    }

    public final S v() {
        S s = this.g;
        if (s == null) {
            synchronized (this) {
                try {
                    s = this.g;
                    if (s == null) {
                        s = new S(new P(), new M(), new L(), this.d.a(), "ServiceInternal");
                        this.u.a(s);
                        this.g = s;
                    }
                } finally {
                }
            }
        }
        return s;
    }

    public final C2733ne w() {
        if (this.l == null) {
            synchronized (this) {
                try {
                    if (this.l == null) {
                        this.l = new C2733ne(W6.a(this.a).c());
                    }
                } finally {
                }
            }
        }
        return this.l;
    }

    public final synchronized S2 x() {
        try {
            if (this.p == null) {
                C3026zk c3026zk = new C3026zk(this.a);
                this.p = c3026zk;
                this.u.a(c3026zk);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.p;
    }

    public final C2597hl y() {
        return this.u;
    }

    public final C2669km z() {
        C2669km c2669km = this.x;
        if (c2669km == null) {
            synchronized (this) {
                try {
                    c2669km = this.x;
                    if (c2669km == null) {
                        c2669km = new C2669km(this.a);
                        this.x = c2669km;
                    }
                } finally {
                }
            }
        }
        return c2669km;
    }

    public final WaitForActivationDelayBarrier a() {
        return this.B.getActivationBarrier();
    }
}
