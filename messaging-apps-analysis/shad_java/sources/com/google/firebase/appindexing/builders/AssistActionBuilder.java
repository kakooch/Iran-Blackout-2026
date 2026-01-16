package com.google.firebase.appindexing.builders;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.appindexing.Action;

/* compiled from: com.google.firebase:firebase-appindexing@@19.2.0 */
/* loaded from: classes3.dex */
public final class AssistActionBuilder extends Action.Builder {
    private String zza;

    public AssistActionBuilder() {
        super("AssistAction");
    }

    @RecentlyNonNull
    public final AssistActionBuilder setActionToken(@RecentlyNonNull String str) {
        Preconditions.checkNotNull(str);
        this.zza = str;
        return this;
    }

    @Override // com.google.firebase.appindexing.Action.Builder
    @RecentlyNonNull
    public final Action build() {
        Preconditions.checkNotNull(this.zza, "setActionToken is required before calling build().");
        Preconditions.checkNotNull(zzc(), "setActionStatus is required before calling build().");
        put("actionToken", this.zza);
        if (zza() == null) {
            setName("AssistAction");
        }
        if (zzb() == null) {
            String strValueOf = String.valueOf(this.zza);
            setUrl(strValueOf.length() != 0 ? "https://developers.google.com/actions?invocation=".concat(strValueOf) : new String("https://developers.google.com/actions?invocation="));
        }
        return super.build();
    }
}
