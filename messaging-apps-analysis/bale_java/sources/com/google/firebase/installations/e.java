package com.google.firebase.installations;

import ir.nasim.C4982Hj7;
import ir.nasim.W45;

/* loaded from: classes3.dex */
class e implements g {
    final C4982Hj7 a;

    public e(C4982Hj7 c4982Hj7) {
        this.a = c4982Hj7;
    }

    @Override // com.google.firebase.installations.g
    public boolean a(Exception exc) {
        return false;
    }

    @Override // com.google.firebase.installations.g
    public boolean b(W45 w45) {
        if (!w45.l() && !w45.k() && !w45.i()) {
            return false;
        }
        this.a.e(w45.d());
        return true;
    }
}
