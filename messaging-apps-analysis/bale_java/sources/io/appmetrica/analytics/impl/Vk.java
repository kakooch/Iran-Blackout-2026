package io.appmetrica.analytics.impl;

import android.content.Context;
import android.text.TextUtils;
import io.appmetrica.analytics.StartupParamsCallback;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import io.appmetrica.analytics.internal.IdentifiersResult;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC15401jX0;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes3.dex */
public final class Vk {
    public final HashSet a;
    public final HashMap b;
    public final Sk c;
    public List d;
    public HashMap e;
    public long f;
    public boolean g;
    public long h;
    public final C2637je i;
    public final I j;
    public final T3 k;
    public final C2892u6 l;
    public final N9 m;
    public final M9 n;
    public final ln o;

    public Vk(Context context, C2637je c2637je) {
        this(c2637je, new I(), new T3(), C2747o4.g().a(context), new C2892u6(), new N9(), new M9(), new ln());
    }

    public final synchronized boolean a(List list) {
        boolean z;
        boolean z2;
        try {
            z = true;
            boolean z3 = !a(AbstractC15401jX0.w0(list, AbstractC2450bl.a));
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                if (this.a.contains((String) it.next())) {
                    z2 = true;
                    break;
                }
            }
            boolean z4 = AbstractC2450bl.b.currentTimeSeconds() > this.h;
            if (!z3 && !z2 && !z4) {
                if (!this.g) {
                    z = false;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return z;
    }

    public final void b(IdentifiersResult identifiersResult) {
        if (a(identifiersResult)) {
            return;
        }
        this.b.put("appmetrica_clids", identifiersResult);
    }

    public final void c(IdentifiersResult identifiersResult) {
        if (identifiersResult != null) {
            ln lnVar = this.o;
            String str = identifiersResult.id;
            lnVar.getClass();
            if (ln.a(str)) {
                this.b.put(StartupParamsCallback.APPMETRICA_UUID, identifiersResult);
            }
        }
    }

    public final synchronized boolean b() {
        return a(Arrays.asList("appmetrica_clids", StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, StartupParamsCallback.APPMETRICA_DEVICE_ID, "appmetrica_get_ad_url", "appmetrica_report_ad_url", StartupParamsCallback.APPMETRICA_UUID));
    }

    public final void c() {
        P9 p9;
        C2637je c2637jeD = this.i.i((IdentifiersResult) this.b.get(StartupParamsCallback.APPMETRICA_UUID)).e((IdentifiersResult) this.b.get(StartupParamsCallback.APPMETRICA_DEVICE_ID)).d((IdentifiersResult) this.b.get(StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH)).a((IdentifiersResult) this.b.get("appmetrica_get_ad_url")).b((IdentifiersResult) this.b.get("appmetrica_report_ad_url")).e(this.f).h((IdentifiersResult) this.b.get("appmetrica_clids")).g(Gl.a((Map) this.e)).f((IdentifiersResult) this.b.get("appmetrica_google_adv_id")).g((IdentifiersResult) this.b.get("appmetrica_huawei_oaid")).j((IdentifiersResult) this.b.get("appmetrica_yandex_adv_id")).b(this.g).c(this.l.d).d(this.h);
        N9 n9 = this.m;
        synchronized (n9) {
            p9 = n9.b;
        }
        c2637jeD.a(p9).b();
    }

    public Vk(C2637je c2637je, I i, T3 t3, Vc vc, C2892u6 c2892u6, N9 n9, M9 m9, ln lnVar) {
        HashSet hashSet = new HashSet();
        this.a = hashSet;
        this.b = new HashMap();
        this.c = new Sk();
        hashSet.add("appmetrica_google_adv_id");
        hashSet.add("appmetrica_huawei_oaid");
        hashSet.add("appmetrica_yandex_adv_id");
        this.i = c2637je;
        this.j = i;
        this.k = t3;
        this.l = c2892u6;
        this.m = n9;
        this.n = m9;
        this.o = lnVar;
        c(vc.a());
        a(StartupParamsCallback.APPMETRICA_DEVICE_ID, c2637je.j());
        a(StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, c2637je.i());
        a("appmetrica_get_ad_url", c2637je.d());
        a("appmetrica_report_ad_url", c2637je.e());
        b(c2637je.o());
        a("appmetrica_google_adv_id", c2637je.l());
        a("appmetrica_huawei_oaid", c2637je.m());
        a("appmetrica_yandex_adv_id", c2637je.r());
        c2892u6.a(c2637je.h());
        n9.a(c2637je.k());
        this.d = c2637je.g();
        String strF = c2637je.f((String) null);
        this.e = strF != null ? Gl.a(strF) : null;
        this.g = c2637je.a(true);
        this.f = c2637je.b(0L);
        this.h = c2637je.n();
        c();
    }

    public final boolean a() {
        IdentifiersResult identifiersResult = (IdentifiersResult) this.b.get("appmetrica_clids");
        if (!a(identifiersResult) && identifiersResult.id.isEmpty()) {
            return hn.a((Map) this.e);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(io.appmetrica.analytics.impl.C2580h4 r4) {
        /*
            r3 = this;
            io.appmetrica.analytics.internal.IdentifiersResult r0 = r4.a
            java.util.HashMap r1 = r3.b
            java.lang.String r2 = "appmetrica_uuid"
            java.lang.Object r1 = r1.get(r2)
            io.appmetrica.analytics.internal.IdentifiersResult r1 = (io.appmetrica.analytics.internal.IdentifiersResult) r1
            if (r1 == 0) goto L1c
            io.appmetrica.analytics.impl.ln r2 = r3.o
            java.lang.String r1 = r1.id
            r2.getClass()
            boolean r1 = io.appmetrica.analytics.impl.ln.a(r1)
            if (r1 == 0) goto L1c
            goto L1f
        L1c:
            r3.c(r0)
        L1f:
            java.lang.String r0 = "appmetrica_device_id"
            io.appmetrica.analytics.internal.IdentifiersResult r1 = r4.b
            r3.a(r0, r1)
            java.lang.String r0 = "appmetrica_device_id_hash"
            io.appmetrica.analytics.internal.IdentifiersResult r1 = r4.c
            r3.a(r0, r1)
            java.util.HashMap r0 = r3.b
            java.lang.String r1 = "appmetrica_google_adv_id"
            io.appmetrica.analytics.internal.IdentifiersResult r2 = r4.h
            r0.put(r1, r2)
            java.util.HashMap r0 = r3.b
            java.lang.String r1 = "appmetrica_huawei_oaid"
            io.appmetrica.analytics.internal.IdentifiersResult r2 = r4.i
            r0.put(r1, r2)
            java.util.HashMap r0 = r3.b
            java.lang.String r1 = "appmetrica_yandex_adv_id"
            io.appmetrica.analytics.internal.IdentifiersResult r2 = r4.j
            r0.put(r1, r2)
            io.appmetrica.analytics.impl.u6 r0 = r3.l
            io.appmetrica.analytics.internal.IdentifiersResult r1 = r4.k
            r0.a(r1)
            io.appmetrica.analytics.impl.N9 r0 = r3.m
            io.appmetrica.analytics.impl.P9 r1 = r4.n
            monitor-enter(r0)
            r0.b = r1     // Catch: java.lang.Throwable -> Lad
            monitor-exit(r0)
            io.appmetrica.analytics.internal.IdentifiersResult r0 = r4.e
            boolean r1 = a(r0)
            if (r1 != 0) goto L66
            java.util.HashMap r1 = r3.b
            java.lang.String r2 = "appmetrica_get_ad_url"
            r1.put(r2, r0)
        L66:
            io.appmetrica.analytics.internal.IdentifiersResult r0 = r4.d
            boolean r1 = a(r0)
            if (r1 != 0) goto L75
            java.util.HashMap r1 = r3.b
            java.lang.String r2 = "appmetrica_report_ad_url"
            r1.put(r2, r0)
        L75:
            long r0 = r4.l
            r3.f = r0
            io.appmetrica.analytics.impl.T3 r0 = r3.k
            java.util.HashMap r1 = r3.e
            io.appmetrica.analytics.internal.IdentifiersResult r2 = r4.g
            java.lang.String r2 = r2.id
            java.util.HashMap r2 = io.appmetrica.analytics.impl.Ya.a(r2)
            r0.getClass()
            boolean r0 = io.appmetrica.analytics.impl.hn.a(r1)
            if (r0 == 0) goto L93
            boolean r0 = io.appmetrica.analytics.impl.hn.a(r2)
            goto L97
        L93:
            boolean r0 = r1.equals(r2)
        L97:
            if (r0 == 0) goto La5
            java.util.HashMap r0 = r3.b
            java.lang.String r1 = "appmetrica_clids"
            io.appmetrica.analytics.internal.IdentifiersResult r2 = r4.f
            r0.put(r1, r2)
            r0 = 0
            r3.g = r0
        La5:
            long r0 = r4.m
            r3.h = r0
            r3.c()
            return
        Lad:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.appmetrica.analytics.impl.Vk.a(io.appmetrica.analytics.impl.h4):void");
    }

    public static boolean a(IdentifiersResult identifiersResult) {
        return identifiersResult == null || identifiersResult.id == null;
    }

    public final void a(String str, IdentifiersResult identifiersResult) {
        if (identifiersResult == null || TextUtils.isEmpty(identifiersResult.id)) {
            return;
        }
        this.b.put(str, identifiersResult);
    }

    public final synchronized boolean a(Collection collection) {
        Boolean bool;
        String str;
        try {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                IdentifiersResult identifiersResult = (IdentifiersResult) this.b.get(str2);
                if (identifiersResult == null) {
                    identifiersResult = (IdentifiersResult) this.l.c.get(str2);
                }
                if (identifiersResult == null) {
                    P9 p9 = this.m.b;
                    if (!AbstractC13042fc3.d(str2, "appmetrica_lib_ssl_enabled") || (bool = p9.a) == null) {
                        identifiersResult = null;
                    } else {
                        boolean zBooleanValue = bool.booleanValue();
                        IdentifierStatus identifierStatus = p9.b;
                        String str3 = p9.c;
                        if (zBooleanValue) {
                            str = "true";
                        } else if (!zBooleanValue) {
                            str = "false";
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                        identifiersResult = new IdentifiersResult(str, identifierStatus, str3);
                    }
                }
                if ("appmetrica_clids".equals(str2)) {
                    if (this.g || a(identifiersResult) || (identifiersResult.id.isEmpty() && !hn.a((Map) this.e))) {
                        return false;
                    }
                } else if ("appmetrica_lib_ssl_enabled".equals(str2)) {
                    if (identifiersResult == null) {
                        return false;
                    }
                } else if (identifiersResult == null || TextUtils.isEmpty(identifiersResult.id)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }
}
