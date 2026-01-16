package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.BuildConfig;
import io.appmetrica.analytics.coreutils.internal.executors.BlockingExecutor;
import io.appmetrica.analytics.coreutils.internal.network.UserAgent;
import io.appmetrica.analytics.networktasks.internal.AESRSARequestBodyEncrypter;
import io.appmetrica.analytics.networktasks.internal.AllHostsExponentialBackoffPolicy;
import io.appmetrica.analytics.networktasks.internal.DefaultResponseValidityChecker;
import io.appmetrica.analytics.networktasks.internal.ExponentialBackoffDataHolder;
import io.appmetrica.analytics.networktasks.internal.FullUrlFormer;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;
import io.appmetrica.analytics.networktasks.internal.RequestDataHolder;
import io.appmetrica.analytics.networktasks.internal.ResponseDataHolder;
import ir.nasim.AbstractC9766aX0;
import java.util.LinkedHashMap;

/* renamed from: io.appmetrica.analytics.impl.nd, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2732nd {
    public static final C2732nd a = new C2732nd();
    public static final LinkedHashMap b = new LinkedHashMap();
    public static final String c = UserAgent.getFor(BuildConfig.LIBRARY_PACKAGE_NAME, "7.1.0", "50089575");

    public final synchronized ExponentialBackoffDataHolder a(EnumC2684ld enumC2684ld) {
        Object exponentialBackoffDataHolder;
        try {
            LinkedHashMap linkedHashMap = b;
            exponentialBackoffDataHolder = linkedHashMap.get(enumC2684ld);
            if (exponentialBackoffDataHolder == null) {
                exponentialBackoffDataHolder = new ExponentialBackoffDataHolder(new C2801qa(C2586ha.C.w(), enumC2684ld));
                linkedHashMap.put(enumC2684ld, exponentialBackoffDataHolder);
            }
        } catch (Throwable th) {
            throw th;
        }
        return (ExponentialBackoffDataHolder) exponentialBackoffDataHolder;
    }

    public static final NetworkTask a(C2484d5 c2484d5) {
        AESRSARequestBodyEncrypter aESRSARequestBodyEncrypter = new AESRSARequestBodyEncrypter();
        C2830rg c2830rg = new C2830rg(aESRSARequestBodyEncrypter);
        C2778pb c2778pb = new C2778pb(c2484d5);
        return new NetworkTask(new BlockingExecutor(), new C2823r9(c2484d5.a), new AllHostsExponentialBackoffPolicy(a.a(EnumC2684ld.REPORT)), new Mg(c2484d5, c2830rg, c2778pb, new FullUrlFormer(c2830rg, c2778pb), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), c2484d5.h(), c2484d5.o(), c2484d5.u(), aESRSARequestBodyEncrypter), AbstractC9766aX0.e(new gn()), c);
    }
}
