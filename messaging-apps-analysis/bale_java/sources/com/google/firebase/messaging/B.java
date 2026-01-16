package com.google.firebase.messaging;

import android.text.TextUtils;
import android.util.Log;
import ir.nasim.DG4;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
final class B {
    private static final Pattern d = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");
    private final String a;
    private final String b;
    private final String c;

    private B(String str, String str2) {
        this.a = d(str2, str);
        this.b = str;
        this.c = str + "!" + str2;
    }

    static B a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split("!", -1);
        if (strArrSplit.length != 2) {
            return null;
        }
        return new B(strArrSplit[0], strArrSplit[1]);
    }

    private static String d(String str, String str2) {
        if (str != null && str.startsWith("/topics/")) {
            Log.w("FirebaseMessaging", String.format("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in %s.", str2));
            str = str.substring(8);
        }
        if (str == null || !d.matcher(str).matches()) {
            throw new IllegalArgumentException(String.format("Invalid topic name: %s does not match the allowed format %s.", str, "[a-zA-Z0-9-_.~%]{1,900}"));
        }
        return str;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public String e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof B)) {
            return false;
        }
        B b = (B) obj;
        return this.a.equals(b.a) && this.b.equals(b.b);
    }

    public int hashCode() {
        return DG4.b(this.b, this.a);
    }
}
