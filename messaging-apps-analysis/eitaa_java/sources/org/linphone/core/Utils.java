package org.linphone.core;

/* loaded from: classes3.dex */
public class Utils {
    public static String getPrefixFromE164(String str) {
        return String.valueOf(Factory.instance().getDialPlans()[0].lookupCccFromE164(str));
    }

    public static int getCccFromIso(String str) {
        return Factory.instance().getDialPlans()[0].lookupCccFromIso(str);
    }
}
