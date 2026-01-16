package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.InterfaceC2029g;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.EG4;

/* loaded from: classes2.dex */
public final class Y extends C0 {
    private static final String e = AbstractC9683aN7.r0(1);
    private static final String f = AbstractC9683aN7.r0(2);
    public static final InterfaceC2029g.a g = new InterfaceC2029g.a() { // from class: ir.nasim.kV2
        @Override // com.google.android.exoplayer2.InterfaceC2029g.a
        public final InterfaceC2029g a(Bundle bundle) {
            return com.google.android.exoplayer2.Y.e(bundle);
        }
    };
    private final boolean c;
    private final boolean d;

    public Y() {
        this.c = false;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Y e(Bundle bundle) {
        AbstractC20011rK.a(bundle.getInt(C0.a, -1) == 0);
        return bundle.getBoolean(e, false) ? new Y(bundle.getBoolean(f, false)) : new Y();
    }

    @Override // com.google.android.exoplayer2.InterfaceC2029g
    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putInt(C0.a, 0);
        bundle.putBoolean(e, this.c);
        bundle.putBoolean(f, this.d);
        return bundle;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Y)) {
            return false;
        }
        Y y = (Y) obj;
        return this.d == y.d && this.c == y.c;
    }

    public int hashCode() {
        return EG4.b(Boolean.valueOf(this.c), Boolean.valueOf(this.d));
    }

    public Y(boolean z) {
        this.c = true;
        this.d = z;
    }
}
