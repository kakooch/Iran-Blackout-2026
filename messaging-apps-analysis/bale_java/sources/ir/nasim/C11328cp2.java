package ir.nasim;

import android.content.Context;
import android.text.TextUtils;

/* renamed from: ir.nasim.cp2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C11328cp2 {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;

    private C11328cp2(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AbstractC3795Cj5.n(!AbstractC13016fZ6.a(str), "ApplicationId must be set.");
        this.b = str;
        this.a = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
    }

    public static C11328cp2 a(Context context) {
        TY6 ty6 = new TY6(context);
        String strA = ty6.a("google_app_id");
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        return new C11328cp2(strA, ty6.a("google_api_key"), ty6.a("firebase_database_url"), ty6.a("ga_trackingId"), ty6.a("gcm_defaultSenderId"), ty6.a("google_storage_bucket"), ty6.a("project_id"));
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.e;
    }

    public String e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C11328cp2)) {
            return false;
        }
        C11328cp2 c11328cp2 = (C11328cp2) obj;
        return DG4.a(this.b, c11328cp2.b) && DG4.a(this.a, c11328cp2.a) && DG4.a(this.c, c11328cp2.c) && DG4.a(this.d, c11328cp2.d) && DG4.a(this.e, c11328cp2.e) && DG4.a(this.f, c11328cp2.f) && DG4.a(this.g, c11328cp2.g);
    }

    public int hashCode() {
        return DG4.b(this.b, this.a, this.c, this.d, this.e, this.f, this.g);
    }

    public String toString() {
        return DG4.c(this).a("applicationId", this.b).a("apiKey", this.a).a("databaseUrl", this.c).a("gcmSenderId", this.e).a("storageBucket", this.f).a("projectId", this.g).toString();
    }
}
