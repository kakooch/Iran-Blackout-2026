package com.google.android.gms.wallet;

import android.accounts.Account;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.wallet.zzaa;
import com.google.android.gms.internal.wallet.zzaf;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
/* loaded from: classes3.dex */
public final class Wallet {
    public static final Api<WalletOptions> API;
    private static final Api.ClientKey<zzaa> CLIENT_KEY;
    private static final Api.AbstractClientBuilder<zzaa, WalletOptions> zzei;

    /* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
    public static final class WalletOptions implements Api.ApiOptions.HasAccountOptions {
        public final int environment;
        public final int theme;
        final boolean zzem;

        private WalletOptions() {
            this(new Builder());
        }

        @Override // com.google.android.gms.common.api.Api.ApiOptions.HasAccountOptions
        public final Account getAccount() {
            return null;
        }

        private WalletOptions(Builder builder) {
            this.environment = builder.environment;
            this.theme = builder.theme;
            this.zzem = builder.zzem;
        }

        /* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
        public static final class Builder {
            private int environment = 3;
            private int theme = 1;
            private boolean zzem = true;

            public final Builder setEnvironment(int i) {
                if (i == 0 || i == 0 || i == 2 || i == 1 || i == 23 || i == 3) {
                    this.environment = i;
                    return this;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid environment value %d", Integer.valueOf(i)));
            }

            public final Builder setTheme(int i) {
                if (i == 0 || i == 1 || i == 2 || i == 3) {
                    this.theme = i;
                    return this;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid theme value %d", Integer.valueOf(i)));
            }

            public final WalletOptions build() {
                return new WalletOptions(this, null);
            }
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof WalletOptions)) {
                return false;
            }
            WalletOptions walletOptions = (WalletOptions) obj;
            return Objects.equal(Integer.valueOf(this.environment), Integer.valueOf(walletOptions.environment)) && Objects.equal(Integer.valueOf(this.theme), Integer.valueOf(walletOptions.theme)) && Objects.equal(null, null) && Objects.equal(Boolean.valueOf(this.zzem), Boolean.valueOf(walletOptions.zzem));
        }

        public final int hashCode() {
            return Objects.hashCode(Integer.valueOf(this.environment), Integer.valueOf(this.theme), null, Boolean.valueOf(this.zzem));
        }

        /* synthetic */ WalletOptions(Builder builder, zzaj zzajVar) {
            this(builder);
        }

        /* synthetic */ WalletOptions(zzaj zzajVar) {
            this();
        }
    }

    public static PaymentsClient getPaymentsClient(Context context, WalletOptions walletOptions) {
        return new PaymentsClient(context, walletOptions);
    }

    static {
        Api.ClientKey<zzaa> clientKey = new Api.ClientKey<>();
        CLIENT_KEY = clientKey;
        zzaj zzajVar = new zzaj();
        zzei = zzajVar;
        API = new Api<>("Wallet.API", zzajVar, clientKey);
        new com.google.android.gms.internal.wallet.zzx();
        new zzaf();
        new com.google.android.gms.internal.wallet.zzag();
    }
}
