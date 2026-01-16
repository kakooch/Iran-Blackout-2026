package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.WindowManager;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class afj {
    private final WindowManager a;
    private final afi b;
    private final afh c;
    private long d;
    private long e;
    private long f;
    private long g;
    private long h;
    private boolean i;
    private long j;
    private long k;
    private long l;

    public afj() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        Display defaultDisplay = this.a.getDefaultDisplay();
        if (defaultDisplay != null) {
            double refreshRate = defaultDisplay.getRefreshRate();
            Double.isNaN(refreshRate);
            long j = (long) (1.0E9d / refreshRate);
            this.d = j;
            this.e = (j * 80) / 100;
        }
    }

    private final boolean f(long j, long j2) {
        return Math.abs((j2 - this.j) - (j - this.k)) > 20000000;
    }

    public final void a() {
        this.i = false;
        if (this.a != null) {
            this.b.b();
            afh afhVar = this.c;
            if (afhVar != null) {
                afhVar.a();
            }
            e();
        }
    }

    public final void b() {
        if (this.a != null) {
            afh afhVar = this.c;
            if (afhVar != null) {
                afhVar.b();
            }
            this.b.c();
        }
    }

    public final long c(long j, long j2) {
        long j3;
        long j4;
        long j5;
        long j6 = 1000 * j;
        if (this.i) {
            if (j != this.f) {
                this.l++;
                this.g = this.h;
            }
            long j7 = this.l;
            if (j7 >= 6) {
                j4 = this.g + ((j6 - this.k) / j7);
                if (f(j4, j2)) {
                    this.i = false;
                } else {
                    j3 = (this.j + j4) - this.k;
                }
            } else if (f(j6, j2)) {
                this.i = false;
            }
            j3 = j2;
            j4 = j6;
        } else {
            j3 = j2;
            j4 = j6;
        }
        if (!this.i) {
            this.k = j6;
            this.j = j2;
            this.l = 0L;
            this.i = true;
        }
        this.f = j;
        this.h = j4;
        afi afiVar = this.b;
        if (afiVar == null || this.d == -9223372036854775807L) {
            return j3;
        }
        long j8 = afiVar.a;
        if (j8 == -9223372036854775807L) {
            return j3;
        }
        long j9 = this.d;
        long j10 = j8 + (((j3 - j8) / j9) * j9);
        if (j3 <= j10) {
            j5 = j10 - j9;
        } else {
            j10 = j9 + j10;
            j5 = j10;
        }
        if (j10 - j3 >= j3 - j5) {
            j10 = j5;
        }
        return j10 - this.e;
    }

    public afj(Context context) {
        DisplayManager displayManager;
        afh afhVar = null;
        if (context != null) {
            context = context.getApplicationContext();
            this.a = (WindowManager) context.getSystemService("window");
        } else {
            this.a = null;
        }
        if (this.a != null) {
            if (aeu.a >= 17 && (displayManager = (DisplayManager) context.getSystemService("display")) != null) {
                afhVar = new afh(this, displayManager);
            }
            this.c = afhVar;
            this.b = afi.a();
        } else {
            this.c = null;
            this.b = null;
        }
        this.d = -9223372036854775807L;
        this.e = -9223372036854775807L;
    }
}
