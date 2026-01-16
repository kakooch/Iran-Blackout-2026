package com.google.firebase.installations;

import ir.nasim.C4982Hj7;
import ir.nasim.W45;

/* loaded from: classes3.dex */
class d implements g {
    private final h a;
    private final C4982Hj7 b;

    public d(h hVar, C4982Hj7 c4982Hj7) {
        this.a = hVar;
        this.b = c4982Hj7;
    }

    @Override // com.google.firebase.installations.g
    public boolean a(Exception exc) {
        this.b.d(exc);
        return true;
    }

    @Override // com.google.firebase.installations.g
    public boolean b(W45 w45) {
        if (!w45.k() || this.a.f(w45)) {
            return false;
        }
        this.b.c(f.a().b(w45.b()).d(w45.c()).c(w45.h()).a());
        return true;
    }
}
