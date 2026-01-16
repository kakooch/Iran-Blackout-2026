package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import io.appmetrica.analytics.AdvIdentifiersResult;
import io.appmetrica.analytics.StartupParamsCallback;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.internal.IdentifiersResult;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public final class Nk implements Ok {
    public static final Map j = Collections.unmodifiableMap(new Kk());
    public final List a;
    public final Lh b;
    public final Vk c;
    public final Handler d;
    public PublicLogger e;
    public final Lk f;
    public final Object g;
    public final WeakHashMap h;
    public HashMap i;

    public Nk(Context context, Lh lh, C2637je c2637je, Handler handler) {
        this(lh, new Vk(context, c2637je), handler);
    }

    public final void a(StartupParamsCallback startupParamsCallback, List<String> list, Map<String, String> map) {
        synchronized (this.g) {
            try {
                Vk vk = this.c;
                vk.getClass();
                if (!hn.a((Map) map) && !hn.a(map, vk.e)) {
                    vk.e = new HashMap(map);
                    vk.g = true;
                    vk.c();
                }
                a(startupParamsCallback, list);
                if (this.c.a((List) list)) {
                    a(list, new Mk(this, startupParamsCallback), map);
                } else {
                    a(new Bundle(), startupParamsCallback);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(Bundle bundle, StartupParamsCallback startupParamsCallback) {
        synchronized (this.g) {
            try {
                b(bundle);
                h();
                if (startupParamsCallback != null) {
                    a(bundle, startupParamsCallback);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String c() {
        IdentifiersResult identifiersResult = (IdentifiersResult) this.c.b.get(StartupParamsCallback.APPMETRICA_DEVICE_ID);
        if (identifiersResult == null) {
            return null;
        }
        return identifiersResult.id;
    }

    public final R9 d() {
        P9 p9;
        Vk vk = this.c;
        M9 m9 = vk.n;
        N9 n9 = vk.m;
        synchronized (n9) {
            p9 = n9.b;
        }
        m9.getClass();
        Boolean bool = p9.a;
        return new R9();
    }

    public final long e() {
        return this.c.f;
    }

    public final InterfaceC2964x6 f() {
        return this.f;
    }

    public final String g() {
        IdentifiersResult identifiersResult = (IdentifiersResult) this.c.b.get(StartupParamsCallback.APPMETRICA_UUID);
        if (identifiersResult == null) {
            return null;
        }
        return identifiersResult.id;
    }

    public final void h() {
        WeakHashMap weakHashMap = new WeakHashMap();
        for (Map.Entry entry : this.h.entrySet()) {
            List list = (List) entry.getValue();
            if (this.c.a((Collection) list)) {
                weakHashMap.put((StartupParamsCallback) entry.getKey(), list);
            }
        }
        Iterator it = weakHashMap.entrySet().iterator();
        while (it.hasNext()) {
            StartupParamsCallback startupParamsCallback = (StartupParamsCallback) ((Map.Entry) it.next()).getKey();
            if (startupParamsCallback != null) {
                a(new Bundle(), startupParamsCallback);
            }
        }
        weakHashMap.clear();
    }

    public final void i() {
        synchronized (this.g) {
            try {
                if (this.c.b()) {
                    a(this.a, this.f, this.i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Nk(Lh lh, Vk vk, Handler handler) {
        this.a = Arrays.asList(StartupParamsCallback.APPMETRICA_UUID, StartupParamsCallback.APPMETRICA_DEVICE_ID, StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, "appmetrica_get_ad_url", "appmetrica_report_ad_url", "appmetrica_clids");
        this.g = new Object();
        this.h = new WeakHashMap();
        this.b = lh;
        this.c = vk;
        this.d = handler;
        this.f = new Lk();
    }

    public final void b(Bundle bundle) {
        Vk vk = this.c;
        synchronized (vk) {
            vk.a(new C2580h4(C2580h4.a(bundle, "Uuid"), C2580h4.a(bundle, "DeviceId"), C2580h4.a(bundle, "DeviceIdHash"), C2580h4.a(bundle, "AdUrlReport"), C2580h4.a(bundle, "AdUrlGet"), C2580h4.a(bundle, "Clids"), C2580h4.a(bundle, "RequestClids"), C2580h4.a(bundle, "GAID"), C2580h4.a(bundle, "HOAID"), C2580h4.a(bundle, "YANDEX_ADV_ID"), C2580h4.a(bundle, "CUSTOM_SDK_HOSTS"), bundle.getLong("ServerTimeOffset"), bundle.getLong("NextStartupTime"), C2580h4.a(bundle)));
        }
        h();
    }

    public final void a(Bundle bundle) {
        b(bundle, null);
    }

    public final void a(PublicLogger publicLogger) {
        this.e = publicLogger;
    }

    public final void a(List list, InterfaceC2964x6 interfaceC2964x6, Map map) {
        ResultReceiverC2988y6 resultReceiverC2988y6 = new ResultReceiverC2988y6(this.d, interfaceC2964x6);
        Lh lh = this.b;
        lh.getClass();
        Bundle bundle = new Bundle();
        bundle.putParcelable("io.appmetrica.analytics.impl.IdentifiersData", new Ra(resultReceiverC2988y6, list, map));
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        PublicLogger anonymousInstance = PublicLogger.getAnonymousInstance();
        Set set = AbstractC2776p9.a;
        C2433b4 c2433b4 = new C2433b4("", "", 1536, 0, anonymousInstance);
        c2433b4.m = bundle;
        Q4 q4 = lh.a;
        lh.a(Lh.a(c2433b4, q4), q4, 1, null);
    }

    public final void b(List<String> list) {
        synchronized (this.g) {
            try {
                List list2 = this.c.d;
                if (hn.a((Collection) list)) {
                    if (!hn.a((Collection) list2)) {
                        Vk vk = this.c;
                        vk.d = null;
                        vk.i.a((List<String>) null);
                        this.b.a((List) null);
                    }
                } else if (!hn.a(list, list2)) {
                    Vk vk2 = this.c;
                    vk2.d = list;
                    vk2.i.a(list);
                    this.b.a(list);
                } else {
                    this.b.a(list2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a(Map<String, String> map) {
        if (hn.a((Map) map)) {
            return;
        }
        synchronized (this.g) {
            try {
                HashMap mapB = Gl.b(map);
                this.i = mapB;
                this.b.a(mapB);
                Vk vk = this.c;
                vk.getClass();
                if (!hn.a((Map) mapB) && !hn.a(mapB, vk.e)) {
                    vk.e = new HashMap(mapB);
                    vk.g = true;
                    vk.c();
                }
            } finally {
            }
        }
    }

    public final void a(String str) {
        synchronized (this.g) {
            this.b.a(str);
        }
    }

    public final void a(Bundle bundle, StartupParamsCallback startupParamsCallback) {
        Ik ik;
        if (this.h.containsKey(startupParamsCallback)) {
            List list = (List) this.h.get(startupParamsCallback);
            if (this.c.a((Collection) list)) {
                startupParamsCallback.onReceive(a(list));
            } else {
                StartupParamsCallback.Reason reason = null;
                if (bundle.containsKey("startup_error_key_code")) {
                    int i = bundle.getInt("startup_error_key_code");
                    ik = Ik.UNKNOWN;
                    if (i == 1) {
                        ik = Ik.NETWORK;
                    } else if (i == 2) {
                        ik = Ik.PARSE;
                    }
                } else {
                    ik = null;
                }
                if (ik == null) {
                    if (!this.c.a()) {
                        PublicLogger publicLogger = this.e;
                        if (publicLogger != null) {
                            publicLogger.warning("Clids error. Passed clids: %s, and clids from server are empty.", this.i);
                        }
                        reason = new StartupParamsCallback.Reason("INCONSISTENT_CLIDS");
                    } else {
                        ik = Ik.UNKNOWN;
                    }
                }
                if (reason == null) {
                    reason = (StartupParamsCallback.Reason) CollectionUtils.getOrDefault(j, ik, StartupParamsCallback.Reason.UNKNOWN);
                }
                startupParamsCallback.onRequestError(reason, a(list));
            }
            this.h.remove(startupParamsCallback);
            if (this.h.isEmpty()) {
                C2552g0 c2552g0 = this.b.d;
                synchronized (c2552g0.f) {
                    c2552g0.c = false;
                    c2552g0.c();
                }
            }
        }
    }

    public final void b(String str) {
        synchronized (this.g) {
            this.b.b(str);
        }
    }

    public final Map<String, String> b() {
        IdentifiersResult identifiersResult = (IdentifiersResult) this.c.b.get("appmetrica_clids");
        String str = identifiersResult == null ? null : identifiersResult.id;
        if (!TextUtils.isEmpty(str)) {
            return Ya.a(str);
        }
        return this.i;
    }

    public final StartupParamsCallback.Result a(List list) {
        HashMap map = new HashMap();
        Vk vk = this.c;
        synchronized (vk) {
            try {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    IdentifiersResult identifiersResult = (IdentifiersResult) vk.b.get(str);
                    if (identifiersResult != null) {
                        map.put(str, vk.c.a(identifiersResult));
                    }
                }
                vk.l.a(list, map);
                vk.m.a(list, map);
            } catch (Throwable th) {
                throw th;
            }
        }
        return new StartupParamsCallback.Result(map);
    }

    public final void a(StartupParamsCallback startupParamsCallback, List list) {
        if (this.h.isEmpty()) {
            C2552g0 c2552g0 = this.b.d;
            synchronized (c2552g0.f) {
                c2552g0.c = true;
                c2552g0.b();
            }
        }
        this.h.put(startupParamsCallback, list);
    }

    public final AdvIdentifiersResult a() {
        Vk vk = this.c;
        I i = vk.j;
        IdentifiersResult identifiersResult = (IdentifiersResult) vk.b.get("appmetrica_google_adv_id");
        IdentifiersResult identifiersResult2 = (IdentifiersResult) vk.b.get("appmetrica_huawei_oaid");
        IdentifiersResult identifiersResult3 = (IdentifiersResult) vk.b.get("appmetrica_yandex_adv_id");
        i.getClass();
        return new AdvIdentifiersResult(I.a(identifiersResult), I.a(identifiersResult2), I.a(identifiersResult3));
    }
}
