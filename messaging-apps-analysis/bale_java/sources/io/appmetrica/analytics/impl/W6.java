package io.appmetrica.analytics.impl;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreapi.internal.db.DatabaseScript;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import io.appmetrica.analytics.modulesapi.internal.common.TableDescription;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServicesDatabase;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public final class W6 {
    public static volatile W6 t;
    public final Context e;
    public V6 f;
    public V6 g;
    public C2626j3 h;
    public C2650k3 i;
    public C2626j3 j;
    public C2650k3 k;
    public C2634jb l;
    public C2658kb m;
    public C2765om n;
    public C2789pm o;
    public C2634jb p;
    public C2658kb q;
    public Pb r;
    public final HashMap a = new HashMap();
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public final J6 d = AbstractC3011z5.a();
    public final Y6 s = new Y6();

    public W6(Context context) {
        this.e = context;
    }

    public static W6 a(Context context) {
        if (t == null) {
            synchronized (W6.class) {
                try {
                    if (t == null) {
                        t = new W6(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return t;
    }

    public final synchronized Ba b(W4 w4) {
        Ba c2634jb;
        String str = new S4(w4).a;
        c2634jb = (Ba) this.b.get(str);
        if (c2634jb == null) {
            c2634jb = new C2634jb(new C2787pk(c(w4)));
            this.b.put(str, c2634jb);
        }
        return c2634jb;
    }

    public final synchronized V6 c(W4 w4) {
        V6 v6;
        try {
            S4 s4 = new S4(w4);
            v6 = (V6) this.a.get(s4.a);
            if (v6 == null) {
                Context context = this.e;
                Y6 y6 = this.s;
                String strA = new X6(y6.a, y6.b, false).a(context, s4);
                J6 j6 = this.d;
                j6.getClass();
                String str = w4.b;
                if (str == null) {
                    str = "main";
                }
                String str2 = String.format("component-%s", str);
                C2526em c2526em = j6.c;
                T6 t6 = j6.a;
                L6 l6 = t6.a;
                M6 m6 = t6.b;
                C2633ja c2633ja = new C2633ja(false);
                c2633ja.a(Integer.valueOf(SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER), new V4());
                C2574gm c2574gm = new C2574gm(str2, j6.b.a);
                c2526em.getClass();
                v6 = new V6(context, strA, new C2550fm(l6, m6, c2633ja, c2574gm), PublicLogger.getAnonymousInstance());
                this.a.put(s4.a, v6);
            }
        } finally {
        }
        return v6;
    }

    public final synchronized Ba d() {
        try {
            if (this.l == null) {
                this.l = new C2634jb(new C2787pk(h()));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.l;
    }

    public final IBinaryDataHelper e() {
        if (this.j == null) {
            if (this.g == null) {
                Context context = this.e;
                Y6 y6 = this.s;
                String strA = new X6(y6.a, y6.b, false).a(context, new C2936w2());
                J6 j6 = this.d;
                j6.getClass();
                HashMap map = new HashMap();
                map.put("binary_data", AbstractC2891u5.a);
                C2526em c2526em = j6.c;
                T6 t6 = j6.a;
                N6 n6 = t6.g;
                O6 o6 = t6.h;
                C2633ja c2633ja = new C2633ja(false);
                C2574gm c2574gm = new C2574gm("auto_inapp", map);
                c2526em.getClass();
                this.g = new V6(context, strA, new C2550fm(n6, o6, c2633ja, c2574gm), PublicLogger.getAnonymousInstance());
            }
            this.j = new C2626j3(new C2787pk(this.g));
        }
        return this.j;
    }

    public final Ba f() {
        Pb pb;
        if (this.p == null) {
            synchronized (this) {
                try {
                    if (this.r == null) {
                        Y6 y6 = this.s;
                        String strA = new X6(y6.a, y6.b, true).a(this.e, new C2458c4());
                        Context context = this.e;
                        J6 j6 = this.d;
                        j6.getClass();
                        HashMap map = new HashMap();
                        map.put("preferences", InterfaceC2939w5.a);
                        C2526em c2526em = j6.c;
                        T6 t6 = j6.a;
                        P6 p6 = t6.c;
                        Q6 q6 = t6.d;
                        C2633ja c2633ja = new C2633ja(false);
                        c2633ja.a(Integer.valueOf(SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER), new C2483d4());
                        C2574gm c2574gm = new C2574gm("service database", map);
                        c2526em.getClass();
                        this.r = new Pb(context, strA, new S9(strA), new C2550fm(p6, q6, c2633ja, c2574gm));
                    }
                    pb = this.r;
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.p = new C2634jb(pb);
        }
        return this.p;
    }

    public final IBinaryDataHelper g() {
        if (this.h == null) {
            this.h = new C2626j3(new C2787pk(h()));
        }
        return this.h;
    }

    public final synchronized V6 h() {
        try {
            if (this.f == null) {
                Context context = this.e;
                Y6 y6 = this.s;
                String strA = new X6(y6.a, y6.b, true).a(context, new C2786pj());
                J6 j6 = this.d;
                j6.getClass();
                HashMap map = new HashMap();
                map.put("preferences", InterfaceC2939w5.a);
                map.put("binary_data", AbstractC2891u5.a);
                map.put("temp_cache", AbstractC2836rm.a);
                Iterator<ModuleServicesDatabase> it = C2586ha.C.m().a().iterator();
                while (it.hasNext()) {
                    for (TableDescription tableDescription : it.next().getTables()) {
                        map.put(tableDescription.getTableName(), tableDescription.getColumnNames());
                    }
                }
                C2526em c2526em = j6.c;
                T6 t6 = j6.a;
                R6 r6 = t6.e;
                S6 s6 = t6.f;
                C2633ja c2633ja = new C2633ja(false);
                c2633ja.a(114, new C2810qj());
                Iterator<ModuleServicesDatabase> it2 = C2586ha.C.m().a().iterator();
                while (it2.hasNext()) {
                    Iterator<TableDescription> it3 = it2.next().getTables().iterator();
                    while (it3.hasNext()) {
                        for (Map.Entry<Integer, DatabaseScript> entry : it3.next().getDatabaseProviderUpgradeScript().entrySet()) {
                            c2633ja.a(entry.getKey(), entry.getValue());
                        }
                    }
                }
                C2574gm c2574gm = new C2574gm("service database", map);
                c2526em.getClass();
                this.f = new V6(context, strA, new C2550fm(r6, s6, c2633ja, c2574gm), PublicLogger.getAnonymousInstance());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f;
    }

    public final synchronized IBinaryDataHelper a(W4 w4) {
        IBinaryDataHelper c2626j3;
        String str = new S4(w4).a;
        c2626j3 = (IBinaryDataHelper) this.c.get(str);
        if (c2626j3 == null) {
            c2626j3 = new C2626j3(new C2787pk(c(w4)));
            this.c.put(str, c2626j3);
        }
        return c2626j3;
    }

    public final synchronized Ba b() {
        return f();
    }

    public final synchronized Ba a() {
        try {
            if (this.q == null) {
                this.q = new C2658kb(f());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.q;
    }

    public final synchronized Ba c() {
        try {
            if (this.m == null) {
                if (this.l == null) {
                    this.l = new C2634jb(new C2787pk(h()));
                }
                this.m = new C2658kb(this.l);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.m;
    }
}
