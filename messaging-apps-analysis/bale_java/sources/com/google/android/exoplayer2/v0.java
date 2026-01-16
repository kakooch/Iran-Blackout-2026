package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.InterfaceC2029g;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.EG4;

/* loaded from: classes2.dex */
public final class v0 extends C0 {
    private static final String d = AbstractC9683aN7.r0(1);
    public static final InterfaceC2029g.a e = new InterfaceC2029g.a() { // from class: ir.nasim.A35
        @Override // com.google.android.exoplayer2.InterfaceC2029g.a
        public final InterfaceC2029g a(Bundle bundle) {
            return com.google.android.exoplayer2.v0.e(bundle);
        }
    };
    private final float c;

    public v0() {
        this.c = -1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static v0 e(Bundle bundle) {
        AbstractC20011rK.a(bundle.getInt(C0.a, -1) == 1);
        float f = bundle.getFloat(d, -1.0f);
        return f == -1.0f ? new v0() : new v0(f);
    }

    @Override // com.google.android.exoplayer2.InterfaceC2029g
    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putInt(C0.a, 1);
        bundle.putFloat(d, this.c);
        return bundle;
    }

    public boolean equals(Object obj) {
        return (obj instanceof v0) && this.c == ((v0) obj).c;
    }

    public int hashCode() {
        return EG4.b(Float.valueOf(this.c));
    }

    public v0(float f) {
        AbstractC20011rK.b(f >= 0.0f && f <= 100.0f, "percent must be in the range of [0, 100]");
        this.c = f;
    }
}
