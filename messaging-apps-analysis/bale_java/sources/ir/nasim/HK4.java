package ir.nasim;

import ir.nasim.C9475a16;
import ir.nasim.features.onboarding.data.model.OnboardingBannerType;

/* loaded from: classes5.dex */
public abstract class HK4 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final OnboardingBannerType.ActionCardBanner b(String str) {
        Object objB;
        OnboardingBannerType.ActionCardBanner actionCardBanner;
        String strV;
        Integer numO;
        try {
            C9475a16.a aVar = C9475a16.b;
            C8542Wk3 c8542Wk3O = AbstractC9083Yk3.c(str).o();
            if (c8542Wk3O.I().isEmpty()) {
                actionCardBanner = null;
            } else {
                AbstractC22735vk3 abstractC22735vk3L = c8542Wk3O.L("peerId");
                int iIntValue = (abstractC22735vk3L == null || (strV = abstractC22735vk3L.v()) == null || (numO = AbstractC19562qZ6.o(strV)) == null) ? 0 : numO.intValue();
                AbstractC22735vk3 abstractC22735vk3L2 = c8542Wk3O.L("description");
                String strV2 = abstractC22735vk3L2 != null ? abstractC22735vk3L2.v() : null;
                String str2 = strV2 == null ? "" : strV2;
                AbstractC22735vk3 abstractC22735vk3L3 = c8542Wk3O.L("isBlueTick");
                boolean zF = abstractC22735vk3L3 != null ? abstractC22735vk3L3.f() : false;
                AbstractC22735vk3 abstractC22735vk3L4 = c8542Wk3O.L("title");
                String strV3 = abstractC22735vk3L4 != null ? abstractC22735vk3L4.v() : null;
                String str3 = strV3 == null ? "" : strV3;
                AbstractC22735vk3 abstractC22735vk3L5 = c8542Wk3O.L("buttonText");
                String strV4 = abstractC22735vk3L5 != null ? abstractC22735vk3L5.v() : null;
                if (strV4 == null) {
                    strV4 = "";
                }
                actionCardBanner = new OnboardingBannerType.ActionCardBanner(iIntValue, str2, str3, null, zF, strV4);
            }
            objB = C9475a16.b(actionCardBanner);
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        return (OnboardingBannerType.ActionCardBanner) (C9475a16.g(objB) ? null : objB);
    }
}
