package io.appmetrica.analytics.impl;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.text.TextUtils;
import android.util.SparseArray;
import io.appmetrica.analytics.AdRevenue;
import io.appmetrica.analytics.ModuleEvent;
import io.appmetrica.analytics.Revenue;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.io.Base64Utils;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import io.appmetrica.analytics.plugins.IPluginReporter;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import io.appmetrica.analytics.profile.UserProfile;
import io.appmetrica.analytics.profile.UserProfileUpdate;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class Q2 implements InterfaceC2968xa {
    public static final HashSet m = new HashSet(Arrays.asList(1, 13));
    public static final O2 n = new O2();
    protected final Context a;
    protected final Wg b;
    protected final PublicLogger c;
    protected final Nm d;
    protected final Tf e;
    protected final C2844s6 f;
    public final Y g;
    protected final Lh h;
    public C2539fb i;
    public final Sb j;
    public final G9 k;
    public final Yd l;

    public Q2(Context context, Lh lh, Wg wg, G9 g9, Sb sb, Nm nm, Tf tf, C2844s6 c2844s6, Y y, Yd yd) {
        this.a = context.getApplicationContext();
        this.h = lh;
        this.b = wg;
        this.k = g9;
        this.d = nm;
        this.e = tf;
        this.f = c2844s6;
        this.g = y;
        this.l = yd;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(wg.b().getApiKey());
        this.c = orCreatePublicLogger;
        wg.a(new C2811qk(orCreatePublicLogger, "Crash Environment"));
        if (AbstractC2770p3.a(wg.b().isLogEnabled())) {
            orCreatePublicLogger.setEnabled(true);
        }
        this.j = sb;
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            this.c.warning("Invalid Error Environment (key,value) pair: (%s,%s).", str, str2);
        } else {
            C2966x8 c2966x8 = this.b.c;
            c2966x8.b.b(c2966x8.a, str, str2);
        }
    }

    public final void b(Map<String, String> map) {
        if (hn.a((Map) map)) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            a(entry.getKey(), entry.getValue());
        }
    }

    public final void c(String str) {
        if (this.b.f()) {
            return;
        }
        this.h.d.c();
        C2539fb c2539fb = this.i;
        c2539fb.a.removeCallbacks(c2539fb.c, c2539fb.b.b.b.getApiKey());
        this.b.e = true;
        Lh lh = this.h;
        PublicLogger publicLogger = this.c;
        Set set = AbstractC2776p9.a;
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        C2433b4 c2433b4 = new C2433b4("", str, 3, 0, publicLogger);
        Wg wg = this.b;
        lh.getClass();
        lh.a(Lh.a(c2433b4, wg), wg, 1, null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void clearAppEnvironment() {
        String str;
        Lh lh = this.h;
        Wg wg = this.b;
        lh.getClass();
        Q5 q5N = C2433b4.n();
        Oe oe = new Oe(wg.a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(wg.b);
        synchronized (wg) {
            str = wg.f;
        }
        lh.a(new Ng(q5N, false, 1, null, new Wg(oe, counterConfiguration, str)));
    }

    public final void d(String str) {
        this.h.d.b();
        C2539fb c2539fb = this.i;
        C2539fb.a(c2539fb.a, c2539fb.b, c2539fb.c);
        Lh lh = this.h;
        PublicLogger publicLogger = this.c;
        Set set = AbstractC2776p9.a;
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        C2433b4 c2433b4 = new C2433b4("", str, 6400, 0, publicLogger);
        Wg wg = this.b;
        lh.getClass();
        lh.a(Lh.a(c2433b4, wg), wg, 1, null);
        this.b.e = false;
    }

    @Override // io.appmetrica.analytics.IReporter
    public final IPluginReporter getPluginExtension() {
        return this;
    }

    public String j() {
        return "[BaseReporter]";
    }

    public void k() {
        String str;
        Ee ee;
        Lh lh = this.h;
        Wg wg = this.b;
        lh.getClass();
        Ie ie = wg.d;
        synchronized (wg) {
            str = wg.f;
        }
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(wg.b.getApiKey());
        Set set = AbstractC2776p9.a;
        JSONObject jSONObject = new JSONObject();
        if (ie != null && (ee = ie.a) != null) {
            try {
                jSONObject.put("preloadInfo", ee.c());
            } catch (Throwable unused) {
            }
        }
        String string = jSONObject.toString();
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        C2433b4 c2433b4 = new C2433b4(string, "", 6144, 0, orCreatePublicLogger);
        c2433b4.c(str);
        lh.a(Lh.a(c2433b4, wg), wg, 1, null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void pauseSession() {
        this.c.info("Pause session", new Object[0]);
        c(null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void putAppEnvironmentValue(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            this.c.warning("Invalid App Environment (key,value) pair: (%s,%s).", str, str2);
            return;
        }
        Lh lh = this.h;
        Wg wg = this.b;
        lh.getClass();
        Q5 q5B = C2433b4.b(str, str2);
        Oe oe = new Oe(wg.a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(wg.b);
        synchronized (wg) {
            str3 = wg.f;
        }
        lh.a(new Ng(q5B, false, 1, null, new Wg(oe, counterConfiguration, str3)));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportAdRevenue(AdRevenue adRevenue) {
        reportAdRevenue(adRevenue, false);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportECommerce(ECommerceEvent eCommerceEvent) {
        String str;
        this.c.info("E-commerce event received: " + eCommerceEvent.getPublicDescription(), new Object[0]);
        Lh lh = this.h;
        Wg wg = this.b;
        lh.getClass();
        for (Rh rh : eCommerceEvent.toProto()) {
            C2433b4 c2433b4 = new C2433b4(LoggerStorage.getOrCreatePublicLogger(wg.b.getApiKey()));
            Ta ta = Ta.EVENT_TYPE_UNDEFINED;
            c2433b4.d = 41000;
            c2433b4.b = c2433b4.e(Base64Utils.compressBase64(MessageNano.toByteArray((MessageNano) rh.a)));
            c2433b4.g = rh.b.getBytesTruncated();
            Oe oe = new Oe(wg.a);
            CounterConfiguration counterConfiguration = new CounterConfiguration(wg.b);
            synchronized (wg) {
                str = wg.f;
            }
            lh.a(new Ng(c2433b4, false, 1, null, new Wg(oe, counterConfiguration, str)));
        }
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, Throwable th) {
        Sf sf = new Sf(str, a(th));
        Lh lh = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.e.fromModel(sf));
        PublicLogger publicLogger = this.c;
        Set set = AbstractC2776p9.a;
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        C2433b4 c2433b4 = new C2433b4(byteArray, str, 5892, publicLogger);
        Wg wg = this.b;
        lh.getClass();
        lh.a(Lh.a(c2433b4, wg), wg, 1, null);
        this.c.info("Error received: %s", WrapUtils.wrapToTag(str));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str) {
        this.c.info("Event received: " + WrapUtils.wrapToTag(str), new Object[0]);
        Lh lh = this.h;
        PublicLogger publicLogger = this.c;
        Set set = AbstractC2776p9.a;
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        C2433b4 c2433b4 = new C2433b4("", str, 1, 0, publicLogger);
        Wg wg = this.b;
        lh.getClass();
        lh.a(Lh.a(c2433b4, wg), wg, 1, null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportRevenue(Revenue revenue) {
        String str;
        C2447bi c2447bi = P2.a;
        c2447bi.getClass();
        mn mnVarA = c2447bi.a(revenue);
        if (!mnVarA.a) {
            this.c.warning("Passed revenue is not valid. Reason: " + mnVarA.b, new Object[0]);
            return;
        }
        Lh lh = this.h;
        C2472ci c2472ci = new C2472ci(revenue, this.c);
        Wg wg = this.b;
        lh.getClass();
        C2433b4 c2433b4A = C2433b4.a(LoggerStorage.getOrCreatePublicLogger(wg.b.getApiKey()), c2472ci);
        Oe oe = new Oe(wg.a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(wg.b);
        synchronized (wg) {
            str = wg.f;
        }
        lh.a(new Ng(c2433b4A, false, 1, null, new Wg(oe, counterConfiguration, str)));
        this.c.info("Revenue received for productID: " + WrapUtils.wrapToTag(revenue.productID) + " of quantity: " + WrapUtils.wrapToTag(revenue.quantity) + " with price (in micros): " + revenue.priceMicros + Separators.SP + revenue.currency, new Object[0]);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportUnhandledException(Throwable th) {
        Mm mmA = Pm.a(th, new T(null, null, this.j.b()), null, (String) this.k.a.a(), (Boolean) this.k.b.a());
        Lh lh = this.h;
        Wg wg = this.b;
        lh.d.b();
        lh.a(lh.b.a(mmA, wg));
        this.c.info("Unhandled exception received: " + mmA, new Object[0]);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportUserProfile(UserProfile userProfile) {
        String str;
        Zm zm = new Zm(Zm.c);
        Iterator<UserProfileUpdate<? extends InterfaceC2427an>> it = userProfile.getUserProfileUpdates().iterator();
        while (it.hasNext()) {
            InterfaceC2427an userProfileUpdatePatcher = it.next().getUserProfileUpdatePatcher();
            ((AbstractC2417ad) userProfileUpdatePatcher).e = this.c;
            userProfileUpdatePatcher.a(zm);
        }
        en enVar = new en();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < zm.a.size(); i++) {
            SparseArray sparseArray = zm.a;
            Iterator it2 = ((HashMap) sparseArray.get(sparseArray.keyAt(i))).values().iterator();
            while (it2.hasNext()) {
                arrayList.add((C2452bn) it2.next());
            }
        }
        enVar.a = (C2452bn[]) arrayList.toArray(new C2452bn[arrayList.size()]);
        mn mnVarA = n.a(enVar);
        if (!mnVarA.a) {
            this.c.warning("UserInfo wasn't sent because " + mnVarA.b, new Object[0]);
            return;
        }
        Lh lh = this.h;
        Wg wg = this.b;
        lh.getClass();
        Q5 q5A = C2433b4.a(enVar);
        Oe oe = new Oe(wg.a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(wg.b);
        synchronized (wg) {
            str = wg.f;
        }
        lh.a(new Ng(q5A, false, 1, null, new Wg(oe, counterConfiguration, str)));
        this.c.info("User profile received", new Object[0]);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void resumeSession() {
        d(null);
        this.c.info("Resume session", new Object[0]);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void sendEventsBuffer() {
        Lh lh = this.h;
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        PublicLogger publicLogger = this.c;
        Set set = AbstractC2776p9.a;
        C2433b4 c2433b4 = new C2433b4("", "", 256, 0, publicLogger);
        Wg wg = this.b;
        lh.getClass();
        lh.a(Lh.a(c2433b4, wg), wg, 1, null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void setDataSendingEnabled(boolean z) {
        this.b.b.setDataSendingEnabled(z);
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void setSessionExtra(String str, byte[] bArr) {
        Lh lh = this.h;
        PublicLogger publicLogger = this.c;
        Set set = AbstractC2776p9.a;
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        C2433b4 c2433b4 = new C2433b4("", null, 8193, 0, publicLogger);
        if (bArr == null) {
            bArr = new byte[0];
        }
        c2433b4.p = Collections.singletonMap(str, bArr);
        Wg wg = this.b;
        lh.getClass();
        lh.a(Lh.a(c2433b4, wg), wg, 1, null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void setUserProfileID(String str) {
        String str2;
        Lh lh = this.h;
        Wg wg = this.b;
        lh.getClass();
        C2433b4 c2433b4 = new C2433b4(LoggerStorage.getOrCreatePublicLogger(wg.b.getApiKey()));
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        c2433b4.d = 40962;
        c2433b4.c(str);
        c2433b4.b = c2433b4.e(str);
        Oe oe = new Oe(wg.a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(wg.b);
        synchronized (wg) {
            str2 = wg.f;
        }
        lh.a(new Ng(c2433b4, false, 1, null, new Wg(oe, counterConfiguration, str2)));
        this.c.info("Set user profile ID: " + WrapUtils.wrapToTag(str), new Object[0]);
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void reportAdRevenue(AdRevenue adRevenue, boolean z) {
        String str;
        Lh lh = this.h;
        B b = new B(adRevenue, z, this.c);
        Wg wg = this.b;
        lh.getClass();
        C2433b4 c2433b4A = C2433b4.a(LoggerStorage.getOrCreatePublicLogger(wg.b.getApiKey()), b);
        Oe oe = new Oe(wg.a);
        CounterConfiguration counterConfiguration = new CounterConfiguration(wg.b);
        synchronized (wg) {
            str = wg.f;
        }
        lh.a(new Ng(c2433b4A, false, 1, null, new Wg(oe, counterConfiguration, str)));
        this.c.info("AdRevenue Received: AdRevenue{adRevenue=" + adRevenue.adRevenue + ", currency='" + WrapUtils.wrapToTag(adRevenue.currency.getCurrencyCode()) + "', adType=" + WrapUtils.wrapToTag(adRevenue.adType) + ", adNetwork='" + WrapUtils.wrapToTag(adRevenue.adNetwork) + "', adUnitId='" + WrapUtils.wrapToTag(adRevenue.adUnitId) + "', adUnitName='" + WrapUtils.wrapToTag(adRevenue.adUnitName) + "', adPlacementId='" + WrapUtils.wrapToTag(adRevenue.adPlacementId) + "', adPlacementName='" + WrapUtils.wrapToTag(adRevenue.adPlacementName) + "', precision='" + WrapUtils.wrapToTag(adRevenue.precision) + "', payload=" + Ya.b(adRevenue.payload) + ", autoCollected=" + z + "}", new Object[0]);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2968xa
    public final void b(String str, String str2) {
        this.c.info("Event received: " + WrapUtils.wrapToTag(str) + ". With value: " + WrapUtils.wrapToTag(str2), new Object[0]);
        Lh lh = this.h;
        PublicLogger publicLogger = this.c;
        Set set = AbstractC2776p9.a;
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        C2433b4 c2433b4 = new C2433b4(str2, str, 1, 0, publicLogger);
        c2433b4.l = EnumC2585h9.JS;
        Wg wg = this.b;
        lh.getClass();
        lh.a(Lh.a(c2433b4, wg), wg, 1, null);
    }

    public final void a(Map<String, String> map) {
        if (hn.a((Map) map)) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            putAppEnvironmentValue(entry.getKey(), entry.getValue());
        }
    }

    public final Mm a(Throwable th) {
        Throwable th2;
        StackTraceElement[] stackTrace;
        if (th == null) {
            stackTrace = null;
            th2 = null;
        } else if (th instanceof O1) {
            stackTrace = th.getStackTrace();
            th2 = null;
        } else {
            th2 = th;
            stackTrace = null;
        }
        return Pm.a(th2, new T(null, null, this.j.b()), stackTrace != null ? Arrays.asList(stackTrace) : null, (String) this.k.a.a(), (Boolean) this.k.b.a());
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, String str2) {
        reportError(str, str2, (Throwable) null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str, String str2) {
        this.c.info("Event received: " + WrapUtils.wrapToTag(str) + ". With value: " + WrapUtils.wrapToTag(str2), new Object[0]);
        Lh lh = this.h;
        PublicLogger publicLogger = this.c;
        Set set = AbstractC2776p9.a;
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        C2433b4 c2433b4 = new C2433b4(str2, str, 1, 0, publicLogger);
        Wg wg = this.b;
        lh.getClass();
        lh.a(Lh.a(c2433b4, wg), wg, 1, null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, String str2, Throwable th) {
        C2820r6 c2820r6 = new C2820r6(new Sf(str2, a(th)), str);
        Lh lh = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.f.fromModel(c2820r6));
        PublicLogger publicLogger = this.c;
        Set set = AbstractC2776p9.a;
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        C2433b4 c2433b4 = new C2433b4(byteArray, str2, 5896, publicLogger);
        Wg wg = this.b;
        lh.getClass();
        lh.a(Lh.a(c2433b4, wg), wg, 1, null);
        this.c.info("Error received: id: %s, message: %s", WrapUtils.wrapToTag(str), WrapUtils.wrapToTag(str2));
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        Mm mmA = this.l.a(pluginErrorDetails);
        Lh lh = this.h;
        Cm cm = mmA.a;
        String str = cm != null ? (String) WrapUtils.getOrDefault(cm.a, "") : "";
        byte[] byteArray = MessageNano.toByteArray(this.d.fromModel(mmA));
        PublicLogger publicLogger = this.c;
        Set set = AbstractC2776p9.a;
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        C2433b4 c2433b4 = new C2433b4(byteArray, str, 5891, publicLogger);
        Wg wg = this.b;
        lh.getClass();
        lh.a(Lh.a(c2433b4, wg), wg, 1, null);
        this.c.info("Crash from plugin received: %s", WrapUtils.wrapToTag(pluginErrorDetails.getMessage()));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2968xa
    public final boolean b() {
        return this.b.f();
    }

    @Override // io.appmetrica.analytics.impl.La, io.appmetrica.analytics.impl.Oa
    public void a(Mm mm) {
        Lh lh = this.h;
        Wg wg = this.b;
        lh.d.b();
        Ng ngA = lh.b.a(mm, wg);
        Wg wg2 = ngA.e;
        Ok ok = lh.e;
        if (ok != null) {
            wg2.b.setUuid(((Nk) ok).g());
        } else {
            wg2.getClass();
        }
        lh.c.b(ngA);
        this.c.info("Unhandled exception received: " + mm, new Object[0]);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str, Map<String, Object> map) {
        Lh lh = this.h;
        PublicLogger publicLogger = this.c;
        Set set = AbstractC2776p9.a;
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        lh.a(new C2433b4("", str, 1, 0, publicLogger), this.b, 1, map);
        PublicLogger publicLogger2 = this.c;
        StringBuilder sb = new StringBuilder("Event received: ");
        sb.append(WrapUtils.wrapToTag(str));
        sb.append(". With value: ");
        sb.append(WrapUtils.wrapToTag(map == null ? null : map.toString()));
        publicLogger2.info(sb.toString(), new Object[0]);
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        Mm mmA;
        Yd yd = this.l;
        if (pluginErrorDetails != null) {
            mmA = yd.a(pluginErrorDetails);
        } else {
            yd.getClass();
            mmA = null;
        }
        Sf sf = new Sf(str, mmA);
        Lh lh = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.e.fromModel(sf));
        PublicLogger publicLogger = this.c;
        Set set = AbstractC2776p9.a;
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        C2433b4 c2433b4 = new C2433b4(byteArray, str, 5896, publicLogger);
        Wg wg = this.b;
        lh.getClass();
        lh.a(Lh.a(c2433b4, wg), wg, 1, null);
        this.c.info("Error from plugin received: %s", WrapUtils.wrapToTag(str));
    }

    @Override // io.appmetrica.analytics.impl.La, io.appmetrica.analytics.impl.Oa
    public final void a(T t) {
        X x = new X(t, (String) this.k.a.a(), (Boolean) this.k.b.a());
        Lh lh = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.g.fromModel(x));
        PublicLogger publicLogger = this.c;
        Set set = AbstractC2776p9.a;
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        C2433b4 c2433b4 = new C2433b4(byteArray, "", 5968, publicLogger);
        Wg wg = this.b;
        lh.getClass();
        lh.a(Lh.a(c2433b4, wg), wg, 1, null);
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void reportEvent(ModuleEvent moduleEvent) {
        if (m.contains(Integer.valueOf(moduleEvent.getType()))) {
            return;
        }
        int type = moduleEvent.getType();
        String name = moduleEvent.getName();
        String value = moduleEvent.getValue();
        Map<String, Object> environment = moduleEvent.getEnvironment();
        Map<String, byte[]> extras = moduleEvent.getExtras();
        PublicLogger publicLogger = this.c;
        Set set = AbstractC2776p9.a;
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        C2433b4 c2433b4 = new C2433b4(value, name, 8192, type, publicLogger);
        c2433b4.c = Ya.b(environment);
        if (extras != null) {
            c2433b4.p = extras;
        }
        this.h.a(c2433b4, this.b, moduleEvent.getServiceDataReporterType(), moduleEvent.getAttributes());
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        Mm mmA;
        Yd yd = this.l;
        if (pluginErrorDetails != null) {
            mmA = yd.a(pluginErrorDetails);
        } else {
            yd.getClass();
            mmA = null;
        }
        C2820r6 c2820r6 = new C2820r6(new Sf(str2, mmA), str);
        Lh lh = this.h;
        byte[] byteArray = MessageNano.toByteArray(this.f.fromModel(c2820r6));
        PublicLogger publicLogger = this.c;
        Set set = AbstractC2776p9.a;
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        C2433b4 c2433b4 = new C2433b4(byteArray, str2, 5896, publicLogger);
        Wg wg = this.b;
        lh.getClass();
        lh.a(Lh.a(c2433b4, wg), wg, 1, null);
        this.c.info("Error with identifier: %s from plugin received: %s", str, WrapUtils.wrapToTag(str2));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2968xa
    public final void a(String str) {
        Lh lh = this.h;
        Q5 q5A = Q5.a(str);
        Wg wg = this.b;
        lh.getClass();
        lh.a(Lh.a(q5A, wg), wg, 1, null);
    }
}
