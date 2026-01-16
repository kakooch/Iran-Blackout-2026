package io.sentry;

import java.io.Closeable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/* renamed from: io.sentry.g1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public interface InterfaceC3118g1 extends Closeable {
    static Date H0(String str, ILogger iLogger) {
        if (str == null) {
            return null;
        }
        try {
            try {
                return AbstractC3141l.f(str);
            } catch (Exception e) {
                iLogger.b(Y2.ERROR, "Error when deserializing millis timestamp format.", e);
                return null;
            }
        } catch (Exception unused) {
            return AbstractC3141l.g(str);
        }
    }

    void B();

    void D(boolean z);

    Object E0(ILogger iLogger, InterfaceC3176q0 interfaceC3176q0);

    void F();

    Object H1();

    long K1();

    List Q1(ILogger iLogger, InterfaceC3176q0 interfaceC3176q0);

    void R();

    String T0();

    Integer Y0();

    TimeZone a0(ILogger iLogger);

    Long a1();

    float e1();

    double f1();

    String g1();

    Map i1(ILogger iLogger, InterfaceC3176q0 interfaceC3176q0);

    void j1(ILogger iLogger, Map map, String str);

    Double l0();

    String n0();

    io.sentry.vendor.gson.stream.b peek();

    Date q0(ILogger iLogger);

    int r0();

    Boolean v0();

    Float x1();
}
