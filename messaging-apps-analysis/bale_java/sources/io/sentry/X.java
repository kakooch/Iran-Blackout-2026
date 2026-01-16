package io.sentry;

import io.sentry.B1;
import io.sentry.protocol.C3168c;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* loaded from: classes3.dex */
public interface X {
    void A(String str);

    InterfaceC3092b0 B();

    List C();

    void D(L2 l2);

    C3199u1 E(B1.a aVar);

    void F(B1.c cVar);

    void G(io.sentry.protocol.v vVar);

    List H();

    void I(C3199u1 c3199u1);

    Y2 a();

    void b(C3106e c3106e, I i);

    InterfaceC3117g0 c();

    void clear();

    /* renamed from: clone */
    X m15clone();

    void d(Throwable th, InterfaceC3117g0 interfaceC3117g0, String str);

    C3155n3 e();

    InterfaceC3127i0 f();

    C3 g();

    Map getExtras();

    io.sentry.protocol.m getRequest();

    io.sentry.protocol.G getUser();

    io.sentry.protocol.v j();

    void k(io.sentry.protocol.v vVar);

    B1.d l();

    void m(C3155n3 c3155n3);

    Queue n();

    C3 o(B1.b bVar);

    Map p();

    List q();

    C3168c r();

    String s();

    void t(InterfaceC3127i0 interfaceC3127i0);

    List u();

    String v();

    void w();

    void x(InterfaceC3092b0 interfaceC3092b0);

    C3 y();

    C3199u1 z();
}
