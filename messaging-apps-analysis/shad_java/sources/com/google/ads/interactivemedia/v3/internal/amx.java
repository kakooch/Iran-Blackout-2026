package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.v3.api.UiElement;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class amx {
    private static final age a;
    private final amv b;
    private final Object c;
    private final String d;
    private final amw e;

    static {
        agf agfVar = new agf();
        agfVar.b(UiElement.class, com.google.ads.interactivemedia.v3.impl.data.bq.GSON_TYPE_ADAPTER);
        agfVar.b(CompanionAdSlot.class, new amu());
        agfVar.c(new apt());
        a = agfVar.a();
    }

    public amx(amv amvVar, amw amwVar, String str) {
        this(amvVar, amwVar, str, null);
    }

    public amx(amv amvVar, amw amwVar, String str, Object obj) {
        this.b = amvVar;
        this.e = amwVar;
        this.d = str;
        this.c = obj;
    }

    public static amx a(String str) throws MalformedURLException, agq {
        Uri uri = Uri.parse(str);
        String strSubstring = uri.getPath().substring(1);
        if (uri.getQueryParameter("sid") == null) {
            throw new MalformedURLException("Session id must be provided in message.");
        }
        amv amvVarValueOf = amv.valueOf(strSubstring);
        amw amwVarValueOf = amw.valueOf(uri.getQueryParameter("type"));
        String queryParameter = uri.getQueryParameter("sid");
        age ageVar = a;
        String queryParameter2 = uri.getQueryParameter("data");
        return new amx(amvVarValueOf, amwVarValueOf, queryParameter, aie.b(com.google.ads.interactivemedia.v3.impl.data.bf.class).cast(queryParameter2 == null ? null : ageVar.h(new StringReader(queryParameter2), com.google.ads.interactivemedia.v3.impl.data.bf.class)));
    }

    public final amv b() {
        return this.b;
    }

    public final amw c() {
        return this.e;
    }

    public final Object d() {
        return this.c;
    }

    public final String e() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof amx)) {
            return false;
        }
        amx amxVar = (amx) obj;
        return this.b == amxVar.b && apz.b(this.c, amxVar.c) && apz.b(this.d, amxVar.d) && this.e == amxVar.e;
    }

    public final String f() {
        arq arqVar = new arq();
        arqVar.b("type", this.e);
        arqVar.b("sid", this.d);
        Object obj = this.c;
        if (obj != null) {
            arqVar.b("data", obj);
        }
        return String.format("%s('%s', %s);", "javascript:adsense.mobileads.afmanotify.receiveMessage", this.b, a.e(arqVar.a()));
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, this.d, this.e});
    }

    public final String toString() {
        return String.format("JavaScriptMessage [command=%s, type=%s, sid=%s, data=%s]", this.b, this.e, this.d, this.c);
    }
}
