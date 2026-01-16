package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC21804u96;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.C20104rU2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class GoogleSignInOptions extends AbstractSafeParcelable implements a.d, ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;
    public static final GoogleSignInOptions l;
    public static final GoogleSignInOptions m;
    public static final Scope n = new Scope("profile");
    public static final Scope o = new Scope("email");
    public static final Scope p = new Scope("openid");
    public static final Scope q;
    public static final Scope r;
    private static Comparator s;
    final int a;
    private final ArrayList b;
    private Account c;
    private boolean d;
    private final boolean e;
    private final boolean f;
    private String g;
    private String h;
    private ArrayList i;
    private String j;
    private Map k;

    static {
        Scope scope = new Scope("https://www.googleapis.com/auth/games_lite");
        q = scope;
        r = new Scope("https://www.googleapis.com/auth/games");
        a aVar = new a();
        aVar.b();
        aVar.c();
        l = aVar.a();
        a aVar2 = new a();
        aVar2.d(scope, new Scope[0]);
        m = aVar2.a();
        CREATOR = new e();
        s = new d();
    }

    public static GoogleSignInOptions X0(String str) throws JSONException {
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
        return new GoogleSignInOptions(3, new ArrayList(hashSet), !TextUtils.isEmpty(strOptString) ? new Account(strOptString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.has("serverClientId") ? jSONObject.optString("serverClientId") : null, jSONObject.has("hostedDomain") ? jSONObject.optString("hostedDomain") : null, new HashMap(), (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map c2(List list) {
        HashMap map = new HashMap();
        if (list == null) {
            return map;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable = (GoogleSignInOptionsExtensionParcelable) it.next();
            map.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.P()), googleSignInOptionsExtensionParcelable);
        }
        return map;
    }

    public boolean A0() {
        return this.f;
    }

    public boolean C0() {
        return this.d;
    }

    public boolean J0() {
        return this.e;
    }

    public Account P() {
        return this.c;
    }

    public ArrayList S() {
        return this.i;
    }

    public final String V1() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.b, s);
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                jSONArray.put(((Scope) it.next()).P());
            }
            jSONObject.put("scopes", jSONArray);
            Account account = this.c;
            if (account != null) {
                jSONObject.put("accountName", account.name);
            }
            jSONObject.put("idTokenRequested", this.d);
            jSONObject.put("forceCodeForRefreshToken", this.f);
            jSONObject.put("serverAuthRequested", this.e);
            if (!TextUtils.isEmpty(this.g)) {
                jSONObject.put("serverClientId", this.g);
            }
            if (!TextUtils.isEmpty(this.h)) {
                jSONObject.put("hostedDomain", this.h);
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public String d0() {
        return this.j;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0052 A[Catch: ClassCastException -> 0x0090, TryCatch #0 {ClassCastException -> 0x0090, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0018, B:12:0x0028, B:15:0x0035, B:17:0x0039, B:22:0x004a, B:24:0x0052, B:30:0x006a, B:32:0x0072, B:34:0x007a, B:36:0x0082, B:27:0x005d, B:20:0x0040), top: B:42:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005d A[Catch: ClassCastException -> 0x0090, TryCatch #0 {ClassCastException -> 0x0090, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0018, B:12:0x0028, B:15:0x0035, B:17:0x0039, B:22:0x004a, B:24:0x0052, B:30:0x006a, B:32:0x0072, B:34:0x007a, B:36:0x0082, B:27:0x005d, B:20:0x0040), top: B:42:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008e A[RETURN] */
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
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r4 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r4     // Catch: java.lang.ClassCastException -> L90
            java.util.ArrayList r1 = r3.i     // Catch: java.lang.ClassCastException -> L90
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L90
            if (r1 > 0) goto L90
            java.util.ArrayList r1 = r4.i     // Catch: java.lang.ClassCastException -> L90
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L90
            if (r1 <= 0) goto L18
            goto L90
        L18:
            java.util.ArrayList r1 = r3.b     // Catch: java.lang.ClassCastException -> L90
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L90
            java.util.ArrayList r2 = r4.s0()     // Catch: java.lang.ClassCastException -> L90
            int r2 = r2.size()     // Catch: java.lang.ClassCastException -> L90
            if (r1 != r2) goto L90
            java.util.ArrayList r1 = r3.b     // Catch: java.lang.ClassCastException -> L90
            java.util.ArrayList r2 = r4.s0()     // Catch: java.lang.ClassCastException -> L90
            boolean r1 = r1.containsAll(r2)     // Catch: java.lang.ClassCastException -> L90
            if (r1 != 0) goto L35
            goto L90
        L35:
            android.accounts.Account r1 = r3.c     // Catch: java.lang.ClassCastException -> L90
            if (r1 != 0) goto L40
            android.accounts.Account r1 = r4.P()     // Catch: java.lang.ClassCastException -> L90
            if (r1 != 0) goto L90
            goto L4a
        L40:
            android.accounts.Account r2 = r4.P()     // Catch: java.lang.ClassCastException -> L90
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L90
            if (r1 == 0) goto L90
        L4a:
            java.lang.String r1 = r3.g     // Catch: java.lang.ClassCastException -> L90
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L90
            if (r1 == 0) goto L5d
            java.lang.String r1 = r4.x0()     // Catch: java.lang.ClassCastException -> L90
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L90
            if (r1 == 0) goto L90
            goto L6a
        L5d:
            java.lang.String r1 = r3.g     // Catch: java.lang.ClassCastException -> L90
            java.lang.String r2 = r4.x0()     // Catch: java.lang.ClassCastException -> L90
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L90
            if (r1 != 0) goto L6a
            goto L90
        L6a:
            boolean r1 = r3.f     // Catch: java.lang.ClassCastException -> L90
            boolean r2 = r4.A0()     // Catch: java.lang.ClassCastException -> L90
            if (r1 != r2) goto L90
            boolean r1 = r3.d     // Catch: java.lang.ClassCastException -> L90
            boolean r2 = r4.C0()     // Catch: java.lang.ClassCastException -> L90
            if (r1 != r2) goto L90
            boolean r1 = r3.e     // Catch: java.lang.ClassCastException -> L90
            boolean r2 = r4.J0()     // Catch: java.lang.ClassCastException -> L90
            if (r1 != r2) goto L90
            java.lang.String r1 = r3.j     // Catch: java.lang.ClassCastException -> L90
            java.lang.String r4 = r4.d0()     // Catch: java.lang.ClassCastException -> L90
            boolean r4 = android.text.TextUtils.equals(r1, r4)     // Catch: java.lang.ClassCastException -> L90
            if (r4 == 0) goto L90
            r4 = 1
            return r4
        L90:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.b;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(((Scope) arrayList2.get(i)).P());
        }
        Collections.sort(arrayList);
        C20104rU2 c20104rU2 = new C20104rU2();
        c20104rU2.a(arrayList);
        c20104rU2.a(this.c);
        c20104rU2.a(this.g);
        c20104rU2.c(this.f);
        c20104rU2.c(this.d);
        c20104rU2.c(this.e);
        c20104rU2.a(this.j);
        return c20104rU2.b();
    }

    public ArrayList s0() {
        return new ArrayList(this.b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = AbstractC21804u96.a(parcel);
        AbstractC21804u96.n(parcel, 1, this.a);
        AbstractC21804u96.x(parcel, 2, s0(), false);
        AbstractC21804u96.s(parcel, 3, P(), i, false);
        AbstractC21804u96.c(parcel, 4, C0());
        AbstractC21804u96.c(parcel, 5, J0());
        AbstractC21804u96.c(parcel, 6, A0());
        AbstractC21804u96.t(parcel, 7, x0(), false);
        AbstractC21804u96.t(parcel, 8, this.h, false);
        AbstractC21804u96.x(parcel, 9, S(), false);
        AbstractC21804u96.t(parcel, 10, d0(), false);
        AbstractC21804u96.b(parcel, iA);
    }

    public String x0() {
        return this.g;
    }

    public static final class a {
        private Set a;
        private boolean b;
        private boolean c;
        private boolean d;
        private String e;
        private Account f;
        private String g;
        private Map h;
        private String i;

        public a() {
            this.a = new HashSet();
            this.h = new HashMap();
        }

        public GoogleSignInOptions a() {
            if (this.a.contains(GoogleSignInOptions.r)) {
                Set set = this.a;
                Scope scope = GoogleSignInOptions.q;
                if (set.contains(scope)) {
                    this.a.remove(scope);
                }
            }
            if (this.d && (this.f == null || !this.a.isEmpty())) {
                b();
            }
            return new GoogleSignInOptions(new ArrayList(this.a), this.f, this.d, this.b, this.c, this.e, this.g, this.h, this.i);
        }

        public a b() {
            this.a.add(GoogleSignInOptions.p);
            return this;
        }

        public a c() {
            this.a.add(GoogleSignInOptions.n);
            return this;
        }

        public a d(Scope scope, Scope... scopeArr) {
            this.a.add(scope);
            this.a.addAll(Arrays.asList(scopeArr));
            return this;
        }

        public a e(String str) {
            this.i = str;
            return this;
        }

        public a(GoogleSignInOptions googleSignInOptions) {
            this.a = new HashSet();
            this.h = new HashMap();
            AbstractC3795Cj5.j(googleSignInOptions);
            this.a = new HashSet(googleSignInOptions.b);
            this.b = googleSignInOptions.e;
            this.c = googleSignInOptions.f;
            this.d = googleSignInOptions.d;
            this.e = googleSignInOptions.g;
            this.f = googleSignInOptions.c;
            this.g = googleSignInOptions.h;
            this.h = GoogleSignInOptions.c2(googleSignInOptions.i);
            this.i = googleSignInOptions.j;
        }
    }

    GoogleSignInOptions(int i, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, ArrayList arrayList2, String str3) {
        this(i, arrayList, account, z, z2, z3, str, str2, c2(arrayList2), str3);
    }

    private GoogleSignInOptions(int i, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map map, String str3) {
        this.a = i;
        this.b = arrayList;
        this.c = account;
        this.d = z;
        this.e = z2;
        this.f = z3;
        this.g = str;
        this.h = str2;
        this.i = new ArrayList(map.values());
        this.k = map;
        this.j = str3;
    }
}
