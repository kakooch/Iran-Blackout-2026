package io.sentry;

import android.gov.nist.javax.sip.header.SIPHeaderNames;
import java.net.URI;
import java.util.HashMap;

/* renamed from: io.sentry.z1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3232z1 {
    private final C3215w a;
    private final String b;

    public C3232z1(C3155n3 c3155n3) {
        io.sentry.util.u.c(c3155n3, "options is required");
        this.a = c3155n3.retrieveParsedDsn();
        this.b = c3155n3.getSentryClientName();
    }

    public C3227y1 a() {
        String str;
        URI uriC = this.a.c();
        String string = uriC.resolve(uriC.getPath() + "/envelope/").toString();
        String strA = this.a.a();
        String strB = this.a.b();
        StringBuilder sb = new StringBuilder();
        sb.append("Sentry sentry_version=7,sentry_client=");
        sb.append(this.b);
        sb.append(",sentry_key=");
        sb.append(strA);
        if (strB == null || strB.length() <= 0) {
            str = "";
        } else {
            str = ",sentry_secret=" + strB;
        }
        sb.append(str);
        String string2 = sb.toString();
        HashMap map = new HashMap();
        map.put(SIPHeaderNames.USER_AGENT, this.b);
        map.put("X-Sentry-Auth", string2);
        return new C3227y1(string, map);
    }
}
