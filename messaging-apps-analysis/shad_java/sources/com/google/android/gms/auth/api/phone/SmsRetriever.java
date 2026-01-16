package com.google.android.gms.auth.api.phone;

import android.content.Context;
import com.google.android.gms.internal.p001authapiphone.zzaa;

/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.5.0 */
/* loaded from: classes.dex */
public final class SmsRetriever {
    public static SmsRetrieverClient getClient(Context context) {
        return new zzaa(context);
    }
}
