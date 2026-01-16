package com.google.android.gms.measurement.internal;

import android.util.Log;

/* renamed from: com.google.android.gms.measurement.internal.a1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC2212a1 implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ String b;
    final /* synthetic */ Object c;
    final /* synthetic */ Object d;
    final /* synthetic */ Object e;
    final /* synthetic */ C2227d1 f;

    RunnableC2212a1(C2227d1 c2227d1, int i, String str, Object obj, Object obj2, Object obj3) {
        this.f = c2227d1;
        this.a = i;
        this.b = str;
        this.c = obj;
        this.d = obj2;
        this.e = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2292q1 c2292q1F = this.f.a.F();
        if (!c2292q1F.n()) {
            Log.println(6, this.f.C(), "Persisted config not initialized. Not logging error/warn");
            return;
        }
        C2227d1 c2227d1 = this.f;
        if (c2227d1.c == 0) {
            if (c2227d1.a.z().H()) {
                C2227d1 c2227d12 = this.f;
                c2227d12.a.d();
                c2227d12.c = 'C';
            } else {
                C2227d1 c2227d13 = this.f;
                c2227d13.a.d();
                c2227d13.c = 'c';
            }
        }
        C2227d1 c2227d14 = this.f;
        if (c2227d14.d < 0) {
            c2227d14.a.z().q();
            c2227d14.d = 74029L;
        }
        char cCharAt = "01VDIWEA?".charAt(this.a);
        C2227d1 c2227d15 = this.f;
        String strSubstring = "2" + cCharAt + c2227d15.c + c2227d15.d + ":" + C2227d1.A(true, this.b, this.c, this.d, this.e);
        if (strSubstring.length() > 1024) {
            strSubstring = this.b.substring(0, 1024);
        }
        C2282o1 c2282o1 = c2292q1F.d;
        if (c2282o1 != null) {
            c2282o1.b(strSubstring, 1L);
        }
    }
}
