package com.google.protobuf;

/* loaded from: classes3.dex */
class n0 extends l0 {
    n0() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.l0
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public m0 g(Object obj) {
        return ((GeneratedMessageLite) obj).unknownFields;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.l0
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public int h(m0 m0Var) {
        return m0Var.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.l0
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public int i(m0 m0Var) {
        return m0Var.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.l0
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public m0 k(m0 m0Var, m0 m0Var2) {
        return m0.c().equals(m0Var2) ? m0Var : m0.c().equals(m0Var) ? m0.n(m0Var, m0Var2) : m0Var.k(m0Var2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.l0
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public m0 n() {
        return m0.o();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.l0
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void o(Object obj, m0 m0Var) {
        p(obj, m0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.l0
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void p(Object obj, m0 m0Var) {
        ((GeneratedMessageLite) obj).unknownFields = m0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.l0
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public m0 r(m0 m0Var) {
        m0Var.h();
        return m0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.l0
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public void s(m0 m0Var, s0 s0Var) {
        m0Var.t(s0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.l0
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public void t(m0 m0Var, s0 s0Var) {
        m0Var.v(s0Var);
    }

    @Override // com.google.protobuf.l0
    void j(Object obj) {
        g(obj).h();
    }

    @Override // com.google.protobuf.l0
    boolean q(d0 d0Var) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.l0
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(m0 m0Var, int i, int i2) {
        m0Var.r(r0.c(i, 5), Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.l0
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void b(m0 m0Var, int i, long j) {
        m0Var.r(r0.c(i, 1), Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.l0
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void c(m0 m0Var, int i, m0 m0Var2) {
        m0Var.r(r0.c(i, 3), m0Var2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.l0
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void d(m0 m0Var, int i, AbstractC2383g abstractC2383g) {
        m0Var.r(r0.c(i, 2), abstractC2383g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.l0
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void e(m0 m0Var, int i, long j) {
        m0Var.r(r0.c(i, 0), Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.l0
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public m0 f(Object obj) {
        m0 m0VarG = g(obj);
        if (m0VarG != m0.c()) {
            return m0VarG;
        }
        m0 m0VarO = m0.o();
        p(obj, m0VarO);
        return m0VarO;
    }
}
