package io.appmetrica.analytics.impl;

import android.content.Context;
import android.gov.nist.javax.sip.clientauthutils.DigestServerAuthenticationHelper;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdTrackingInfo;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdTrackingInfoResult;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.C12275eL0;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes3.dex */
public final class H7 {
    public final Context a;
    public final S b;
    public final C2431b2 c;

    public H7(Context context, S s, C2431b2 c2431b2) {
        this.a = context;
        this.b = s;
        this.c = c2431b2;
    }

    public final String a() {
        byte[] bArrDigest;
        AdTrackingInfoResult yandex = this.b.a(this.a, new Fm(5, SIPTransactionStack.BASE_TIMER_INTERVAL)).getYandex();
        if (!yandex.isValid()) {
            String id = this.c.getAppSetId().getId();
            if (id != null && id.length() != 0) {
                try {
                    UUID.fromString(id);
                    if (!AbstractC13042fc3.d(id, "00000000-0000-0000-0000-000000000000")) {
                        return AbstractC20153rZ6.M(id, "-", "", false, 4, null);
                    }
                } catch (Throwable unused) {
                }
            }
            return AbstractC20153rZ6.M(UUID.randomUUID().toString(), "-", "", false, 4, null).toLowerCase(Locale.US);
        }
        AdTrackingInfo adTrackingInfo = yandex.mAdTrackingInfo;
        AbstractC13042fc3.f(adTrackingInfo);
        String str = adTrackingInfo.advId;
        AbstractC13042fc3.f(str);
        try {
            bArrDigest = MessageDigest.getInstance(DigestServerAuthenticationHelper.DEFAULT_ALGORITHM).digest(str.getBytes(C12275eL0.b));
        } catch (NoSuchAlgorithmException unused2) {
            bArrDigest = new byte[0];
        }
        return StringUtils.toHexString(bArrDigest);
    }

    public H7(Context context) {
        this(context, C2586ha.h().v(), C2586ha.h().b());
    }
}
