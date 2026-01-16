package io.appmetrica.analytics.impl;

import android.content.Context;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import io.appmetrica.analytics.coreapi.internal.annotations.DoNotInline;
import io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import io.appmetrica.analytics.impl.C2739nk;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10976cX0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@DoNotInline
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\t"}, d2 = {"Lio/appmetrica/analytics/impl/nk;", "", "Landroid/content/Context;", "context", "", "Lio/appmetrica/analytics/impl/hk;", "a", "<init>", "()V", "analytics_binaryProdRelease"}, k = 1, mv = {1, 6, 0})
/* renamed from: io.appmetrica.analytics.impl.nk, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2739nk {
    public static final C2739nk a = new C2739nk();

    private C2739nk() {
    }

    public static final List<C2596hk> a(Context context) {
        List<SubscriptionInfo> list = (List) SystemServiceUtils.accessSystemServiceByNameSafely(context, "telephony_subscription_service", "getting active subcription info list", "SubscriptionManager", new FunctionWithThrowable() { // from class: ir.nasim.qe8
            @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
            public final Object apply(Object obj) {
                return C2739nk.a((SubscriptionManager) obj);
            }
        });
        if (list == null) {
            return AbstractC10360bX0.m();
        }
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (SubscriptionInfo subscriptionInfo : list) {
            Integer numA = AndroidUtils.isApiAchieved(29) ? C2763ok.a(subscriptionInfo) : Integer.valueOf(subscriptionInfo.getMcc());
            Integer numB = AndroidUtils.isApiAchieved(29) ? C2763ok.b(subscriptionInfo) : Integer.valueOf(subscriptionInfo.getMnc());
            boolean z = subscriptionInfo.getDataRoaming() == 1;
            CharSequence carrierName = subscriptionInfo.getCarrierName();
            arrayList.add(new C2596hk(numA, numB, z, carrierName != null ? carrierName.toString() : null));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List a(SubscriptionManager subscriptionManager) {
        return subscriptionManager.getActiveSubscriptionInfoList();
    }
}
