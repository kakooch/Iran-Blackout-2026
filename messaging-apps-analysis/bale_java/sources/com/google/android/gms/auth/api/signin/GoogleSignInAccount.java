package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.BD1;
import ir.nasim.OV0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new c();
    public static OV0 n = BD1.a();
    final int a;
    private String b;
    private String c;
    private String d;
    private String e;
    private Uri f;
    private String g;
    private long h;
    private String i;
    List j;
    private String k;
    private String l;
    private Set m = new HashSet();

    GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List list, String str7, String str8) {
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = uri;
        this.g = str5;
        this.h = j;
        this.i = str6;
        this.j = list;
        this.k = str7;
        this.l = str8;
    }

    public static GoogleSignInAccount S1(String str) throws JSONException, NumberFormatException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("photoUrl");
        Uri uri = !TextUtils.isEmpty(strOptString) ? Uri.parse(strOptString) : null;
        long j = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        GoogleSignInAccount googleSignInAccountX0 = X0(jSONObject.optString("id"), jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null, jSONObject.has("email") ? jSONObject.optString("email") : null, jSONObject.has("displayName") ? jSONObject.optString("displayName") : null, jSONObject.has("givenName") ? jSONObject.optString("givenName") : null, jSONObject.has("familyName") ? jSONObject.optString("familyName") : null, uri, Long.valueOf(j), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        googleSignInAccountX0.g = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return googleSignInAccountX0;
    }

    public static GoogleSignInAccount X0(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l, String str7, Set set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, l.longValue(), AbstractC3795Cj5.f(str7), new ArrayList((Collection) AbstractC3795Cj5.j(set)), str5, str6);
    }

    public String A0() {
        return this.c;
    }

    public Uri C0() {
        return this.f;
    }

    public Set J0() {
        HashSet hashSet = new HashSet(this.j);
        hashSet.addAll(this.m);
        return hashSet;
    }

    public String N0() {
        return this.g;
    }

    public String P() {
        return this.e;
    }

    public String S() {
        return this.d;
    }

    public final String T1() {
        return this.i;
    }

    public final String U1() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            if (x0() != null) {
                jSONObject.put("id", x0());
            }
            if (A0() != null) {
                jSONObject.put("tokenId", A0());
            }
            if (S() != null) {
                jSONObject.put("email", S());
            }
            if (P() != null) {
                jSONObject.put("displayName", P());
            }
            if (s0() != null) {
                jSONObject.put("givenName", s0());
            }
            if (d0() != null) {
                jSONObject.put("familyName", d0());
            }
            Uri uriC0 = C0();
            if (uriC0 != null) {
                jSONObject.put("photoUrl", uriC0.toString());
            }
            if (N0() != null) {
                jSONObject.put("serverAuthCode", N0());
            }
            jSONObject.put("expirationTime", this.h);
            jSONObject.put("obfuscatedIdentifier", this.i);
            JSONArray jSONArray = new JSONArray();
            List list = this.j;
            Scope[] scopeArr = (Scope[]) list.toArray(new Scope[list.size()]);
            Arrays.sort(scopeArr, new Comparator() { // from class: ir.nasim.Ne8
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    Parcelable.Creator<GoogleSignInAccount> creator = GoogleSignInAccount.CREATOR;
                    return ((Scope) obj).P().compareTo(((Scope) obj2).P());
                }
            });
            for (Scope scope : scopeArr) {
                jSONArray.put(scope.P());
            }
            jSONObject.put("grantedScopes", jSONArray);
            jSONObject.remove("serverAuthCode");
            return jSONObject.toString();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public String d0() {
        return this.l;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.i.equals(this.i) && googleSignInAccount.J0().equals(J0());
    }

    public int hashCode() {
        return ((this.i.hashCode() + 527) * 31) + J0().hashCode();
    }

    public String s0() {
        return this.k;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.n(parcel, 1, this.a);
        AbstractC21804u96.t(parcel, 2, x0(), false);
        AbstractC21804u96.t(parcel, 3, A0(), false);
        AbstractC21804u96.t(parcel, 4, S(), false);
        AbstractC21804u96.t(parcel, 5, P(), false);
        AbstractC21804u96.s(parcel, 6, C0(), i, false);
        AbstractC21804u96.t(parcel, 7, N0(), false);
        AbstractC21804u96.q(parcel, 8, this.h);
        AbstractC21804u96.t(parcel, 9, this.i, false);
        AbstractC21804u96.x(parcel, 10, this.j, false);
        AbstractC21804u96.t(parcel, 11, s0(), false);
        AbstractC21804u96.t(parcel, 12, d0(), false);
        AbstractC21804u96.b(parcel, iA);
    }

    public String x0() {
        return this.b;
    }
}
