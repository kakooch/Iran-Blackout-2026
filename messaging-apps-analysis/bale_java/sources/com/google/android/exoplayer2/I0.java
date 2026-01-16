package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.InterfaceC2029g;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.EG4;

/* loaded from: classes2.dex */
public final class I0 extends C0 {
    private static final String e = AbstractC9683aN7.r0(1);
    private static final String f = AbstractC9683aN7.r0(2);
    public static final InterfaceC2029g.a g = new InterfaceC2029g.a() { // from class: ir.nasim.wp7
        @Override // com.google.android.exoplayer2.InterfaceC2029g.a
        public final InterfaceC2029g a(Bundle bundle) {
            return com.google.android.exoplayer2.I0.e(bundle);
        }
    };
    private final boolean c;
    private final boolean d;

    public I0() {
        this.c = false;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static I0 e(Bundle bundle) {
        AbstractC20011rK.a(bundle.getInt(C0.a, -1) == 3);
        return bundle.getBoolean(e, false) ? new I0(bundle.getBoolean(f, false)) : new I0();
    }

    @Override // com.google.android.exoplayer2.InterfaceC2029g
    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putInt(C0.a, 3);
        bundle.putBoolean(e, this.c);
        bundle.putBoolean(f, this.d);
        return bundle;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof I0)) {
            return false;
        }
        I0 i0 = (I0) obj;
        return this.d == i0.d && this.c == i0.c;
    }

    public int hashCode() {
        return EG4.b(Boolean.valueOf(this.c), Boolean.valueOf(this.d));
    }

    public I0(boolean z) {
        this.c = true;
        this.d = z;
    }
}
