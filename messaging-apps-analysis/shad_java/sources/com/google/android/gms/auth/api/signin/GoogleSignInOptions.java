package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.auth.api.signin.internal.HashAccumulator;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
/* loaded from: classes.dex */
public class GoogleSignInOptions extends AbstractSafeParcelable implements Api.ApiOptions, ReflectedParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;

    @RecentlyNonNull
    public static final GoogleSignInOptions DEFAULT_SIGN_IN;

    @RecentlyNonNull
    public static final Scope zaa = new Scope("profile");

    @RecentlyNonNull
    public static final Scope zac;

    @RecentlyNonNull
    public static final Scope zad;

    @RecentlyNonNull
    public static final Scope zae;
    private static Comparator<Scope> zaq;
    private final int zaf;
    private final ArrayList<Scope> zag;
    private Account zah;
    private boolean zai;
    private final boolean zaj;
    private final boolean zak;
    private String zal;
    private String zam;
    private ArrayList<GoogleSignInOptionsExtensionParcelable> zan;
    private String zao;
    private Map<Integer, GoogleSignInOptionsExtensionParcelable> zap;

    @RecentlyNullable
    public static GoogleSignInOptions zaa(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        String strOptString = jSONObject.has("accountName") ? jSONObject.optString("accountName") : null;
        return new GoogleSignInOptions(3, (ArrayList<Scope>) new ArrayList(hashSet), !TextUtils.isEmpty(strOptString) ? new Account(strOptString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.has("serverClientId") ? jSONObject.optString("serverClientId") : null, jSONObject.has("hostedDomain") ? jSONObject.optString("hostedDomain") : null, new HashMap(), (String) null);
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
    public static final class Builder {
        private Set<Scope> zaa;
        private boolean zab;
        private boolean zac;
        private boolean zad;
        private String zae;
        private Account zaf;
        private String zag;
        private Map<Integer, GoogleSignInOptionsExtensionParcelable> zah;
        private String zai;

        public Builder() {
            this.zaa = new HashSet();
            this.zah = new HashMap();
        }

        public Builder(@RecentlyNonNull GoogleSignInOptions googleSignInOptions) {
            this.zaa = new HashSet();
            this.zah = new HashMap();
            Preconditions.checkNotNull(googleSignInOptions);
            this.zaa = new HashSet(googleSignInOptions.zag);
            this.zab = googleSignInOptions.zaj;
            this.zac = googleSignInOptions.zak;
            this.zad = googleSignInOptions.zai;
            this.zae = googleSignInOptions.zal;
            this.zaf = googleSignInOptions.zah;
            this.zag = googleSignInOptions.zam;
            this.zah = GoogleSignInOptions.zab(googleSignInOptions.zan);
            this.zai = googleSignInOptions.zao;
        }

        @RecentlyNonNull
        public final Builder requestId() {
            this.zaa.add(GoogleSignInOptions.zac);
            return this;
        }

        @RecentlyNonNull
        public final Builder requestProfile() {
            this.zaa.add(GoogleSignInOptions.zaa);
            return this;
        }

        @RecentlyNonNull
        public final Builder requestScopes(@RecentlyNonNull Scope scope, @RecentlyNonNull Scope... scopeArr) {
            this.zaa.add(scope);
            this.zaa.addAll(Arrays.asList(scopeArr));
            return this;
        }

        @RecentlyNonNull
        public final Builder setLogSessionId(@RecentlyNonNull String str) {
            this.zai = str;
            return this;
        }

        @RecentlyNonNull
        public final GoogleSignInOptions build() {
            if (this.zaa.contains(GoogleSignInOptions.zae)) {
                Set<Scope> set = this.zaa;
                Scope scope = GoogleSignInOptions.zad;
                if (set.contains(scope)) {
                    this.zaa.remove(scope);
                }
            }
            if (this.zad && (this.zaf == null || !this.zaa.isEmpty())) {
                requestId();
            }
            return new GoogleSignInOptions(3, new ArrayList(this.zaa), this.zaf, this.zad, this.zab, this.zac, this.zae, this.zag, this.zah, this.zai, null);
        }
    }

    GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, ArrayList<GoogleSignInOptionsExtensionParcelable> arrayList2, String str3) {
        this(i, arrayList, account, z, z2, z3, str, str2, zab(arrayList2), str3);
    }

    private GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map<Integer, GoogleSignInOptionsExtensionParcelable> map, String str3) {
        this.zaf = i;
        this.zag = arrayList;
        this.zah = account;
        this.zai = z;
        this.zaj = z2;
        this.zak = z3;
        this.zal = str;
        this.zam = str2;
        this.zan = new ArrayList<>(map.values());
        this.zap = map;
        this.zao = str3;
    }

    @RecentlyNonNull
    public ArrayList<Scope> getScopes() {
        return new ArrayList<>(this.zag);
    }

    @RecentlyNullable
    public Account getAccount() {
        return this.zah;
    }

    public boolean isIdTokenRequested() {
        return this.zai;
    }

    public boolean isServerAuthCodeRequested() {
        return this.zaj;
    }

    public boolean isForceCodeForRefreshToken() {
        return this.zak;
    }

    @RecentlyNullable
    public String getServerClientId() {
        return this.zal;
    }

    @RecentlyNullable
    public String getLogSessionId() {
        return this.zao;
    }

    @RecentlyNonNull
    public ArrayList<GoogleSignInOptionsExtensionParcelable> getExtensions() {
        return this.zan;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<Integer, GoogleSignInOptionsExtensionParcelable> zab(List<GoogleSignInOptionsExtensionParcelable> list) {
        HashMap map = new HashMap();
        if (list == null) {
            return map;
        }
        for (GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable : list) {
            map.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.getType()), googleSignInOptionsExtensionParcelable);
        }
        return map;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zaf);
        SafeParcelWriter.writeTypedList(parcel, 2, getScopes(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, getAccount(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 4, isIdTokenRequested());
        SafeParcelWriter.writeBoolean(parcel, 5, isServerAuthCodeRequested());
        SafeParcelWriter.writeBoolean(parcel, 6, isForceCodeForRefreshToken());
        SafeParcelWriter.writeString(parcel, 7, getServerClientId(), false);
        SafeParcelWriter.writeString(parcel, 8, this.zam, false);
        SafeParcelWriter.writeTypedList(parcel, 9, getExtensions(), false);
        SafeParcelWriter.writeString(parcel, 10, getLogSessionId(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0052 A[Catch: ClassCastException -> 0x008f, TryCatch #0 {ClassCastException -> 0x008f, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0018, B:12:0x0028, B:15:0x0035, B:17:0x0039, B:22:0x004a, B:24:0x0052, B:29:0x0069, B:31:0x0071, B:33:0x0079, B:35:0x0081, B:27:0x005d, B:20:0x0040), top: B:41:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005d A[Catch: ClassCastException -> 0x008f, TryCatch #0 {ClassCastException -> 0x008f, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0018, B:12:0x0028, B:15:0x0035, B:17:0x0039, B:22:0x004a, B:24:0x0052, B:29:0x0069, B:31:0x0071, B:33:0x0079, B:35:0x0081, B:27:0x005d, B:20:0x0040), top: B:41:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r4 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r4     // Catch: java.lang.ClassCastException -> L8f
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r1 = r3.zan     // Catch: java.lang.ClassCastException -> L8f
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 > 0) goto L8f
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r1 = r4.zan     // Catch: java.lang.ClassCastException -> L8f
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 <= 0) goto L18
            goto L8f
        L18:
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.zag     // Catch: java.lang.ClassCastException -> L8f
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L8f
            java.util.ArrayList r2 = r4.getScopes()     // Catch: java.lang.ClassCastException -> L8f
            int r2 = r2.size()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != r2) goto L8f
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.zag     // Catch: java.lang.ClassCastException -> L8f
            java.util.ArrayList r2 = r4.getScopes()     // Catch: java.lang.ClassCastException -> L8f
            boolean r1 = r1.containsAll(r2)     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != 0) goto L35
            goto L8f
        L35:
            android.accounts.Account r1 = r3.zah     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != 0) goto L40
            android.accounts.Account r1 = r4.getAccount()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != 0) goto L8f
            goto L4a
        L40:
            android.accounts.Account r2 = r4.getAccount()     // Catch: java.lang.ClassCastException -> L8f
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L8f
            if (r1 == 0) goto L8f
        L4a:
            java.lang.String r1 = r3.zal     // Catch: java.lang.ClassCastException -> L8f
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L8f
            if (r1 == 0) goto L5d
            java.lang.String r1 = r4.getServerClientId()     // Catch: java.lang.ClassCastException -> L8f
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L8f
            if (r1 == 0) goto L8f
            goto L69
        L5d:
            java.lang.String r1 = r3.zal     // Catch: java.lang.ClassCastException -> L8f
            java.lang.String r2 = r4.getServerClientId()     // Catch: java.lang.ClassCastException -> L8f
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L8f
            if (r1 == 0) goto L8f
        L69:
            boolean r1 = r3.zak     // Catch: java.lang.ClassCastException -> L8f
            boolean r2 = r4.isForceCodeForRefreshToken()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != r2) goto L8f
            boolean r1 = r3.zai     // Catch: java.lang.ClassCastException -> L8f
            boolean r2 = r4.isIdTokenRequested()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != r2) goto L8f
            boolean r1 = r3.zaj     // Catch: java.lang.ClassCastException -> L8f
            boolean r2 = r4.isServerAuthCodeRequested()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != r2) goto L8f
            java.lang.String r1 = r3.zao     // Catch: java.lang.ClassCastException -> L8f
            java.lang.String r4 = r4.getLogSessionId()     // Catch: java.lang.ClassCastException -> L8f
            boolean r4 = android.text.TextUtils.equals(r1, r4)     // Catch: java.lang.ClassCastException -> L8f
            if (r4 == 0) goto L8f
            r4 = 1
            return r4
        L8f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList<Scope> arrayList2 = this.zag;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Scope scope = arrayList2.get(i);
            i++;
            arrayList.add(scope.getScopeUri());
        }
        Collections.sort(arrayList);
        return new HashAccumulator().addObject(arrayList).addObject(this.zah).addObject(this.zal).zaa(this.zak).zaa(this.zai).zaa(this.zaj).addObject(this.zao).hash();
    }

    @RecentlyNonNull
    public final String zaa() {
        return zab().toString();
    }

    private final JSONObject zab() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.zag, zaq);
            ArrayList<Scope> arrayList = this.zag;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Scope scope = arrayList.get(i);
                i++;
                jSONArray.put(scope.getScopeUri());
            }
            jSONObject.put("scopes", jSONArray);
            Account account = this.zah;
            if (account != null) {
                jSONObject.put("accountName", account.name);
            }
            jSONObject.put("idTokenRequested", this.zai);
            jSONObject.put("forceCodeForRefreshToken", this.zak);
            jSONObject.put("serverAuthRequested", this.zaj);
            if (!TextUtils.isEmpty(this.zal)) {
                jSONObject.put("serverClientId", this.zal);
            }
            if (!TextUtils.isEmpty(this.zam)) {
                jSONObject.put("hostedDomain", this.zam);
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* synthetic */ GoogleSignInOptions(int i, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map map, String str3, zac zacVar) {
        this(3, (ArrayList<Scope>) arrayList, account, z, z2, z3, str, str2, (Map<Integer, GoogleSignInOptionsExtensionParcelable>) map, str3);
    }

    static {
        new Scope("email");
        zac = new Scope("openid");
        Scope scope = new Scope("https://www.googleapis.com/auth/games_lite");
        zad = scope;
        zae = new Scope("https://www.googleapis.com/auth/games");
        DEFAULT_SIGN_IN = new Builder().requestId().requestProfile().build();
        new Builder().requestScopes(scope, new Scope[0]).build();
        CREATOR = new zad();
        zaq = new zac();
    }
}
