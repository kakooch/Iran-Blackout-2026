package io.sentry.rrweb;

import android.gov.nist.javax.sip.header.ParameterNames;
import io.sentry.A0;
import io.sentry.C3155n3;
import io.sentry.C3165p3;
import io.sentry.ILogger;
import io.sentry.InterfaceC3123h1;
import io.sentry.protocol.p;
import io.sentry.rrweb.b;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class h extends b implements A0 {
    private String c;
    private Map d;
    private Map e;
    private Map f;

    public h() {
        super(c.Custom);
        this.d = new HashMap();
        this.c = "options";
    }

    private void g(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        interfaceC3123h1.f(ParameterNames.TAG).h(this.c);
        interfaceC3123h1.f("payload");
        h(interfaceC3123h1, iLogger);
        Map map = this.f;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f.get(str);
                interfaceC3123h1.f(str);
                interfaceC3123h1.l(iLogger, obj);
            }
        }
        interfaceC3123h1.F();
    }

    private void h(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        Map map = this.d;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.d.get(str);
                interfaceC3123h1.f(str);
                interfaceC3123h1.l(iLogger, obj);
            }
        }
        interfaceC3123h1.F();
    }

    @Override // io.sentry.A0
    public void serialize(InterfaceC3123h1 interfaceC3123h1, ILogger iLogger) {
        interfaceC3123h1.B();
        new b.C0251b().a(this, interfaceC3123h1, iLogger);
        interfaceC3123h1.f("data");
        g(interfaceC3123h1, iLogger);
        Map map = this.e;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.e.get(str);
                interfaceC3123h1.f(str);
                interfaceC3123h1.l(iLogger, obj);
            }
        }
        interfaceC3123h1.F();
    }

    public h(C3155n3 c3155n3) {
        this();
        p sdkVersion = c3155n3.getSdkVersion();
        if (sdkVersion != null) {
            this.d.put("nativeSdkName", sdkVersion.e());
            this.d.put("nativeSdkVersion", sdkVersion.g());
        }
        C3165p3 sessionReplay = c3155n3.getSessionReplay();
        this.d.put("errorSampleRate", sessionReplay.g());
        this.d.put("sessionSampleRate", sessionReplay.k());
        this.d.put("maskAllImages", Boolean.valueOf(sessionReplay.e().contains("android.widget.ImageView")));
        this.d.put("maskAllText", Boolean.valueOf(sessionReplay.e().contains("android.widget.TextView")));
        this.d.put("quality", sessionReplay.h().serializedName());
        this.d.put("maskedViewClasses", sessionReplay.e());
        this.d.put("unmaskedViewClasses", sessionReplay.m());
    }
}
