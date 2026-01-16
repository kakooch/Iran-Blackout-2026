package ir.nasim;

import android.content.Context;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import java.util.List;

/* renamed from: ir.nasim.uC6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C21832uC6 {
    public static final C21832uC6 a = new C21832uC6();

    private C21832uC6() {
    }

    public final int a(Context context) {
        List<SubscriptionInfo> activeSubscriptionInfoList;
        AbstractC13042fc3.i(context, "context");
        SubscriptionManager subscriptionManagerFrom = SubscriptionManager.from(context);
        if (AbstractC4043Dl1.a(context, "android.permission.READ_PHONE_STATE") != 0 || (activeSubscriptionInfoList = subscriptionManagerFrom.getActiveSubscriptionInfoList()) == null) {
            return 0;
        }
        return activeSubscriptionInfoList.size();
    }
}
