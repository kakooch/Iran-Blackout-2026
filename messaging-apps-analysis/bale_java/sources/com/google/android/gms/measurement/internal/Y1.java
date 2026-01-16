package com.google.android.gms.measurement.internal;

/* loaded from: classes3.dex */
final class Y1 implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ long d;
    final /* synthetic */ Z1 e;

    Y1(Z1 z1, String str, String str2, String str3, long j) {
        this.e = z1;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = this.a;
        if (str == null) {
            this.e.a.w(this.b, null);
        } else {
            this.e.a.w(this.b, new M2(this.c, str, this.d));
        }
    }
}
