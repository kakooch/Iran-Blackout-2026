package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.InterfaceC2029g;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;

/* loaded from: classes2.dex */
public final class y0 implements InterfaceC2029g {
    public static final y0 d = new y0(1.0f);
    private static final String e = AbstractC9683aN7.r0(0);
    private static final String f = AbstractC9683aN7.r0(1);
    public static final InterfaceC2029g.a g = new InterfaceC2029g.a() { // from class: ir.nasim.Xf5
        @Override // com.google.android.exoplayer2.InterfaceC2029g.a
        public final InterfaceC2029g a(Bundle bundle) {
            return com.google.android.exoplayer2.y0.d(bundle);
        }
    };
    public final float a;
    public final float b;
    private final int c;

    public y0(float f2) {
        this(f2, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ y0 d(Bundle bundle) {
        return new y0(bundle.getFloat(e, 1.0f), bundle.getFloat(f, 1.0f));
    }

    @Override // com.google.android.exoplayer2.InterfaceC2029g
    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putFloat(e, this.a);
        bundle.putFloat(f, this.b);
        return bundle;
    }

    public long c(long j) {
        return j * this.c;
    }

    public y0 e(float f2) {
        return new y0(f2, this.b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || y0.class != obj.getClass()) {
            return false;
        }
        y0 y0Var = (y0) obj;
        return this.a == y0Var.a && this.b == y0Var.b;
    }

    public int hashCode() {
        return ((527 + Float.floatToRawIntBits(this.a)) * 31) + Float.floatToRawIntBits(this.b);
    }

    public String toString() {
        return AbstractC9683aN7.A("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.a), Float.valueOf(this.b));
    }

    public y0(float f2, float f3) {
        AbstractC20011rK.a(f2 > 0.0f);
        AbstractC20011rK.a(f3 > 0.0f);
        this.a = f2;
        this.b = f3;
        this.c = Math.round(f2 * 1000.0f);
    }
}
