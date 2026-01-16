package com.google.android.gms.wallet;

import com.google.android.gms.common.Feature;

/* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
/* loaded from: classes3.dex */
public final class zzg {
    private static final Feature zzay;
    private static final Feature zzaz;
    public static final Feature zzba;
    public static final Feature[] zzbb;

    static {
        Feature feature = new Feature("wallet", 1L);
        zzay = feature;
        Feature feature2 = new Feature("wallet_biometric_auth_keys", 1L);
        zzaz = feature2;
        Feature feature3 = new Feature("wallet_payment_dynamic_update", 2L);
        zzba = feature3;
        zzbb = new Feature[]{feature, feature2, feature3};
    }
}
