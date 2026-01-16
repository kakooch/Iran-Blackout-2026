package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import androidx.collection.ArraySet;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.SignInOptions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes.dex */
public final class ClientSettings {

    @Nullable
    private final Account zaa;
    private final Set zab;
    private final Set zac;
    private final Map zad;
    private final int zae;

    @Nullable
    private final View zaf;
    private final String zag;
    private final String zah;
    private final SignInOptions zai;
    private Integer zaj;

    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    public static final class Builder {

        @Nullable
        private Account zaa;
        private ArraySet zab;
        private String zac;
        private String zad;
        private SignInOptions zae = SignInOptions.zaa;

        public ClientSettings build() {
            return new ClientSettings(this.zaa, this.zab, null, 0, null, this.zac, this.zad, this.zae, false);
        }

        @CanIgnoreReturnValue
        public Builder setRealClientPackageName(String str) {
            this.zac = str;
            return this;
        }

        @CanIgnoreReturnValue
        public final Builder zaa(Collection collection) {
            if (this.zab == null) {
                this.zab = new ArraySet();
            }
            this.zab.addAll(collection);
            return this;
        }

        @CanIgnoreReturnValue
        public final Builder zab(@Nullable Account account) {
            this.zaa = account;
            return this;
        }

        @CanIgnoreReturnValue
        public final Builder zac(String str) {
            this.zad = str;
            return this;
        }
    }

    public Account getAccount() {
        return this.zaa;
    }

    public Account getAccountOrDefault() {
        Account account = this.zaa;
        return account != null ? account : new Account("<<default account>>", "com.google");
    }

    public Set<Scope> getAllRequestedScopes() {
        return this.zac;
    }

    public String getRealClientPackageName() {
        return this.zag;
    }

    public Set<Scope> getRequiredScopes() {
        return this.zab;
    }

    public final SignInOptions zaa() {
        return this.zai;
    }

    public final Integer zab() {
        return this.zaj;
    }

    public final String zac() {
        return this.zah;
    }

    public final Map zad() {
        return this.zad;
    }

    public final void zae(Integer num) {
        this.zaj = num;
    }

    public ClientSettings(@Nullable Account account, Set set, Map map, int i, @Nullable View view, String str, String str2, @Nullable SignInOptions signInOptions, boolean z) {
        this.zaa = account;
        Set setEmptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.zab = setEmptySet;
        map = map == null ? Collections.emptyMap() : map;
        this.zad = map;
        this.zaf = view;
        this.zae = i;
        this.zag = str;
        this.zah = str2;
        this.zai = signInOptions == null ? SignInOptions.zaa : signInOptions;
        HashSet hashSet = new HashSet(setEmptySet);
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            hashSet.addAll(((zab) it.next()).zaa);
        }
        this.zac = Collections.unmodifiableSet(hashSet);
    }
}
