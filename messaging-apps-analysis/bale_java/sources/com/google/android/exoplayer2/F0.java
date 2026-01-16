package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.InterfaceC2029g;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.EG4;

/* loaded from: classes2.dex */
public final class F0 extends C0 {
    private static final String e = AbstractC9683aN7.r0(1);
    private static final String f = AbstractC9683aN7.r0(2);
    public static final InterfaceC2029g.a g = new InterfaceC2029g.a() { // from class: ir.nasim.TJ6
        @Override // com.google.android.exoplayer2.InterfaceC2029g.a
        public final InterfaceC2029g a(Bundle bundle) {
            return com.google.android.exoplayer2.F0.e(bundle);
        }
    };
    private final int c;
    private final float d;

    public F0(int i) {
        AbstractC20011rK.b(i > 0, "maxStars must be a positive integer");
        this.c = i;
        this.d = -1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static F0 e(Bundle bundle) {
        AbstractC20011rK.a(bundle.getInt(C0.a, -1) == 2);
        int i = bundle.getInt(e, 5);
        float f2 = bundle.getFloat(f, -1.0f);
        return f2 == -1.0f ? new F0(i) : new F0(i, f2);
    }

    @Override // com.google.android.exoplayer2.InterfaceC2029g
    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putInt(C0.a, 2);
        bundle.putInt(e, this.c);
        bundle.putFloat(f, this.d);
        return bundle;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof F0)) {
            return false;
        }
        F0 f0 = (F0) obj;
        return this.c == f0.c && this.d == f0.d;
    }

    public int hashCode() {
        return EG4.b(Integer.valueOf(this.c), Float.valueOf(this.d));
    }

    public F0(int i, float f2) {
        boolean z = false;
        AbstractC20011rK.b(i > 0, "maxStars must be a positive integer");
        if (f2 >= 0.0f && f2 <= i) {
            z = true;
        }
        AbstractC20011rK.b(z, "starRating is out of range [0, maxStars]");
        this.c = i;
        this.d = f2;
    }
}
