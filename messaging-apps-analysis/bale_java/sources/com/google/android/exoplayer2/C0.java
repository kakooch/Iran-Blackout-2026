package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.InterfaceC2029g;
import ir.nasim.AbstractC9683aN7;

/* loaded from: classes2.dex */
public abstract class C0 implements InterfaceC2029g {
    static final String a = AbstractC9683aN7.r0(0);
    public static final InterfaceC2029g.a b = new InterfaceC2029g.a() { // from class: ir.nasim.CG5
        @Override // com.google.android.exoplayer2.InterfaceC2029g.a
        public final InterfaceC2029g a(Bundle bundle) {
            return com.google.android.exoplayer2.C0.c(bundle);
        }
    };

    C0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C0 c(Bundle bundle) {
        int i = bundle.getInt(a, -1);
        if (i == 0) {
            return (C0) Y.g.a(bundle);
        }
        if (i == 1) {
            return (C0) v0.e.a(bundle);
        }
        if (i == 2) {
            return (C0) F0.g.a(bundle);
        }
        if (i == 3) {
            return (C0) I0.g.a(bundle);
        }
        throw new IllegalArgumentException("Unknown RatingType: " + i);
    }
}
