package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes3.dex */
class c0 extends a0 {
    c0() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.crypto.tink.shaded.protobuf.a0
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public b0 g(Object obj) {
        return ((AbstractC2358u) obj).unknownFields;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.crypto.tink.shaded.protobuf.a0
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public int h(b0 b0Var) {
        return b0Var.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.crypto.tink.shaded.protobuf.a0
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public int i(b0 b0Var) {
        return b0Var.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.crypto.tink.shaded.protobuf.a0
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public b0 k(b0 b0Var, b0 b0Var2) {
        return b0.c().equals(b0Var2) ? b0Var : b0.c().equals(b0Var) ? b0.j(b0Var, b0Var2) : b0Var.i(b0Var2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.crypto.tink.shaded.protobuf.a0
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public b0 n() {
        return b0.k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.crypto.tink.shaded.protobuf.a0
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void o(Object obj, b0 b0Var) {
        p(obj, b0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.crypto.tink.shaded.protobuf.a0
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void p(Object obj, b0 b0Var) {
        ((AbstractC2358u) obj).unknownFields = b0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.crypto.tink.shaded.protobuf.a0
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public b0 r(b0 b0Var) {
        b0Var.h();
        return b0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.crypto.tink.shaded.protobuf.a0
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public void s(b0 b0Var, g0 g0Var) {
        b0Var.p(g0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.crypto.tink.shaded.protobuf.a0
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public void t(b0 b0Var, g0 g0Var) {
        b0Var.r(g0Var);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.a0
    void j(Object obj) {
        g(obj).h();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.a0
    boolean q(U u) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.crypto.tink.shaded.protobuf.a0
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(b0 b0Var, int i, int i2) {
        b0Var.n(f0.c(i, 5), Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.crypto.tink.shaded.protobuf.a0
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void b(b0 b0Var, int i, long j) {
        b0Var.n(f0.c(i, 1), Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.crypto.tink.shaded.protobuf.a0
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void c(b0 b0Var, int i, b0 b0Var2) {
        b0Var.n(f0.c(i, 3), b0Var2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.crypto.tink.shaded.protobuf.a0
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void d(b0 b0Var, int i, AbstractC2345g abstractC2345g) {
        b0Var.n(f0.c(i, 2), abstractC2345g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.crypto.tink.shaded.protobuf.a0
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void e(b0 b0Var, int i, long j) {
        b0Var.n(f0.c(i, 0), Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.crypto.tink.shaded.protobuf.a0
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public b0 f(Object obj) {
        b0 b0VarG = g(obj);
        if (b0VarG != b0.c()) {
            return b0VarG;
        }
        b0 b0VarK = b0.k();
        p(obj, b0VarK);
        return b0VarK;
    }
}
