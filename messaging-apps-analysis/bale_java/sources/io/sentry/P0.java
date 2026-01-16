package io.sentry;

import io.sentry.B1;
import io.sentry.protocol.C3168c;
import io.sentry.util.q;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* loaded from: classes3.dex */
public final class P0 implements X {
    private static final P0 b = new P0();
    private final io.sentry.util.q a = new io.sentry.util.q(new q.a() { // from class: io.sentry.O0
        @Override // io.sentry.util.q.a
        public final Object a() {
            return C3155n3.empty();
        }
    });

    private P0() {
    }

    public static P0 i() {
        return b;
    }

    @Override // io.sentry.X
    public void A(String str) {
    }

    @Override // io.sentry.X
    public InterfaceC3092b0 B() {
        return U0.h();
    }

    @Override // io.sentry.X
    public List C() {
        return new ArrayList();
    }

    @Override // io.sentry.X
    public void D(L2 l2) {
    }

    @Override // io.sentry.X
    public C3199u1 E(B1.a aVar) {
        return new C3199u1();
    }

    @Override // io.sentry.X
    public void F(B1.c cVar) {
    }

    @Override // io.sentry.X
    public void G(io.sentry.protocol.v vVar) {
    }

    @Override // io.sentry.X
    public List H() {
        return new ArrayList();
    }

    @Override // io.sentry.X
    public void I(C3199u1 c3199u1) {
    }

    @Override // io.sentry.X
    public Y2 a() {
        return null;
    }

    @Override // io.sentry.X
    public void b(C3106e c3106e, I i) {
    }

    @Override // io.sentry.X
    public InterfaceC3117g0 c() {
        return null;
    }

    @Override // io.sentry.X
    public void clear() {
    }

    @Override // io.sentry.X
    public void d(Throwable th, InterfaceC3117g0 interfaceC3117g0, String str) {
    }

    @Override // io.sentry.X
    public C3155n3 e() {
        return (C3155n3) this.a.a();
    }

    @Override // io.sentry.X
    public InterfaceC3127i0 f() {
        return null;
    }

    @Override // io.sentry.X
    public C3 g() {
        return null;
    }

    @Override // io.sentry.X
    public Map getExtras() {
        return new HashMap();
    }

    @Override // io.sentry.X
    public io.sentry.protocol.m getRequest() {
        return null;
    }

    @Override // io.sentry.X
    public io.sentry.protocol.G getUser() {
        return null;
    }

    @Override // io.sentry.X
    public io.sentry.protocol.v j() {
        return io.sentry.protocol.v.b;
    }

    @Override // io.sentry.X
    public void k(io.sentry.protocol.v vVar) {
    }

    @Override // io.sentry.X
    public B1.d l() {
        return null;
    }

    @Override // io.sentry.X
    public void m(C3155n3 c3155n3) {
    }

    @Override // io.sentry.X
    public Queue n() {
        return new ArrayDeque();
    }

    @Override // io.sentry.X
    public C3 o(B1.b bVar) {
        return null;
    }

    @Override // io.sentry.X
    public Map p() {
        return new HashMap();
    }

    @Override // io.sentry.X
    public List q() {
        return new ArrayList();
    }

    @Override // io.sentry.X
    public C3168c r() {
        return new C3168c();
    }

    @Override // io.sentry.X
    public String s() {
        return null;
    }

    @Override // io.sentry.X
    public void t(InterfaceC3127i0 interfaceC3127i0) {
    }

    @Override // io.sentry.X
    public List u() {
        return new ArrayList();
    }

    @Override // io.sentry.X
    public String v() {
        return null;
    }

    @Override // io.sentry.X
    public void w() {
    }

    @Override // io.sentry.X
    public void x(InterfaceC3092b0 interfaceC3092b0) {
    }

    @Override // io.sentry.X
    public C3 y() {
        return null;
    }

    @Override // io.sentry.X
    public C3199u1 z() {
        return new C3199u1();
    }

    @Override // io.sentry.X
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public X m20clone() {
        return i();
    }
}
