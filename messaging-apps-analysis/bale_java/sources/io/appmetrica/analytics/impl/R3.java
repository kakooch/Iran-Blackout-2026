package io.appmetrica.analytics.impl;

/* loaded from: classes3.dex */
public final class R3 extends L7 {
    @Override // io.appmetrica.analytics.impl.L7
    public final boolean a(I3 i3, I3 i32) {
        if (!hn.a(i32.a)) {
            if (hn.a(i3.a)) {
                return false;
            }
            M7 m7 = i3.b;
            if (m7 == M7.c) {
                if (((Number) this.a.a(m7)).intValue() < ((Number) this.a.a(i32.b)).intValue()) {
                    return false;
                }
            } else if (((Number) this.a.a(m7)).intValue() <= ((Number) this.a.a(i32.b)).intValue()) {
                return false;
            }
        }
        return true;
    }
}
