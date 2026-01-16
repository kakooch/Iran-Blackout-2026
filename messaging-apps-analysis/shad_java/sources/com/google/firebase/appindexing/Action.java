package com.google.firebase.appindexing;

import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.appindexing.builders.IndexableBuilder;
import com.google.firebase.appindexing.internal.zzd;

/* compiled from: com.google.firebase:firebase-appindexing@@19.2.0 */
/* loaded from: classes3.dex */
public interface Action {

    /* compiled from: com.google.firebase:firebase-appindexing@@19.2.0 */
    public static class Builder {
        private final Bundle zza = new Bundle();
        private final String zzb;
        private String zzc;
        private String zzd;
        private String zze;
        private zzd zzf;
        private String zzg;

        public Builder(@RecentlyNonNull String str) {
            this.zzb = str;
        }

        @RecentlyNonNull
        public Builder put(@RecentlyNonNull String str, @RecentlyNonNull String... strArr) {
            IndexableBuilder.zza(this.zza, str, strArr);
            return this;
        }

        @RecentlyNonNull
        public final Builder setUrl(@RecentlyNonNull String str) {
            Preconditions.checkNotNull(str);
            this.zzd = str;
            return put("url", str);
        }

        @RecentlyNonNull
        public final Builder setName(@RecentlyNonNull String str) {
            Preconditions.checkNotNull(str);
            this.zzc = str;
            return put("name", str);
        }

        @RecentlyNonNull
        public Builder setActionStatus(@RecentlyNonNull String str) {
            Preconditions.checkNotNull(str);
            this.zzg = str;
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v3, types: [com.google.firebase.appindexing.Action$Metadata$Builder] */
        @RecentlyNonNull
        public Action build() {
            Preconditions.checkNotNull(this.zzc, "setObject is required before calling build().");
            Preconditions.checkNotNull(this.zzd, "setObject is required before calling build().");
            String str = this.zzb;
            String str2 = this.zzc;
            String str3 = this.zzd;
            String str4 = this.zze;
            zzd zzdVarZza = this.zzf;
            if (zzdVarZza == null) {
                zzdVarZza = new Object() { // from class: com.google.firebase.appindexing.Action$Metadata$Builder
                    private boolean zza = true;

                    public final zzd zza() {
                        return new zzd(this.zza, null, null, null, false);
                    }
                }.zza();
            }
            return new com.google.firebase.appindexing.internal.zza(str, str2, str3, str4, zzdVarZza, this.zzg, this.zza);
        }

        @RecentlyNonNull
        protected final String zza() {
            String str = this.zzc;
            if (str == null) {
                return null;
            }
            return new String(str);
        }

        @RecentlyNonNull
        protected final String zzb() {
            String str = this.zzd;
            if (str == null) {
                return null;
            }
            return new String(str);
        }

        @RecentlyNonNull
        protected final String zzc() {
            return new String(this.zzg);
        }
    }
}
