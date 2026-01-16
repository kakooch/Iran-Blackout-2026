package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdvIdentifiersResult;
import io.appmetrica.analytics.internal.IdentifiersResult;

/* loaded from: classes3.dex */
public final class I {
    public static AdvIdentifiersResult.AdvId a(IdentifiersResult identifiersResult) {
        AdvIdentifiersResult.Details details;
        String str = identifiersResult == null ? null : identifiersResult.id;
        if (identifiersResult == null) {
            details = AdvIdentifiersResult.Details.INTERNAL_ERROR;
        } else {
            int i = H.a[identifiersResult.status.ordinal()];
            details = i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? AdvIdentifiersResult.Details.INTERNAL_ERROR : AdvIdentifiersResult.Details.INVALID_ADV_ID : AdvIdentifiersResult.Details.IDENTIFIER_PROVIDER_UNAVAILABLE : AdvIdentifiersResult.Details.FEATURE_DISABLED : AdvIdentifiersResult.Details.NO_STARTUP : AdvIdentifiersResult.Details.OK;
        }
        return new AdvIdentifiersResult.AdvId(str, details, identifiersResult != null ? identifiersResult.errorExplanation : null);
    }
}
