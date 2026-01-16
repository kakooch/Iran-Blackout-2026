package androidx.datastore.preferences.protobuf;

/* loaded from: classes2.dex */
class d0 extends b0 {
    d0() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.b0
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public c0 g(Object obj) {
        return ((AbstractC1950t) obj).unknownFields;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.b0
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public int h(c0 c0Var) {
        return c0Var.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.b0
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public int i(c0 c0Var) {
        return c0Var.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.b0
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public c0 k(c0 c0Var, c0 c0Var2) {
        return c0Var2.equals(c0.e()) ? c0Var : c0.k(c0Var, c0Var2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.b0
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public c0 n() {
        return c0.l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.b0
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void o(Object obj, c0 c0Var) {
        p(obj, c0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.b0
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void p(Object obj, c0 c0Var) {
        ((AbstractC1950t) obj).unknownFields = c0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.b0
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public c0 r(c0 c0Var) {
        c0Var.j();
        return c0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.b0
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public void s(c0 c0Var, h0 h0Var) {
        c0Var.o(h0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.b0
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public void t(c0 c0Var, h0 h0Var) {
        c0Var.q(h0Var);
    }

    @Override // androidx.datastore.preferences.protobuf.b0
    void j(Object obj) {
        g(obj).j();
    }

    @Override // androidx.datastore.preferences.protobuf.b0
    boolean q(U u) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.b0
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(c0 c0Var, int i, int i2) {
        c0Var.n(g0.c(i, 5), Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.b0
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void b(c0 c0Var, int i, long j) {
        c0Var.n(g0.c(i, 1), Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.b0
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void c(c0 c0Var, int i, c0 c0Var2) {
        c0Var.n(g0.c(i, 3), c0Var2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.b0
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void d(c0 c0Var, int i, AbstractC1937f abstractC1937f) {
        c0Var.n(g0.c(i, 2), abstractC1937f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.b0
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void e(c0 c0Var, int i, long j) {
        c0Var.n(g0.c(i, 0), Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.b0
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public c0 f(Object obj) {
        c0 c0VarG = g(obj);
        if (c0VarG != c0.e()) {
            return c0VarG;
        }
        c0 c0VarL = c0.l();
        p(obj, c0VarL);
        return c0VarL;
    }
}
