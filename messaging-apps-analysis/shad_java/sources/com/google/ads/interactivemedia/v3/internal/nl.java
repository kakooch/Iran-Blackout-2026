package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class nl {
    private final nm a = new nm();
    private final aee b = new aee(new byte[65025], 0);
    private int c = -1;
    private int d;
    private boolean e;

    nl() {
    }

    private final int f(int i) {
        int i2;
        int i3 = 0;
        this.d = 0;
        do {
            int i4 = this.d;
            int i5 = i + i4;
            nm nmVar = this.a;
            if (i5 >= nmVar.d) {
                break;
            }
            int[] iArr = nmVar.g;
            this.d = i4 + 1;
            i2 = iArr[i5];
            i3 += i2;
        } while (i2 == 255);
        return i3;
    }

    public final void a() {
        this.a.a();
        this.b.a(0);
        this.c = -1;
        this.e = false;
    }

    public final nm b() {
        return this.a;
    }

    public final aee c() {
        return this.b;
    }

    public final void d() {
        if (this.b.i().length == 65025) {
            return;
        }
        aee aeeVar = this.b;
        aeeVar.c(Arrays.copyOf(aeeVar.i(), Math.max(65025, this.b.e())), this.b.e());
    }

    public final boolean e(jv jvVar) throws IOException {
        ary.q(true);
        if (this.e) {
            this.e = false;
            this.b.a(0);
        }
        while (!this.e) {
            int i = this.c;
            if (i < 0) {
                if (!this.a.b(jvVar) || !this.a.d(jvVar, true)) {
                    return false;
                }
                nm nmVar = this.a;
                int iF = nmVar.e;
                if ((nmVar.b & 1) == 1 && this.b.e() == 0) {
                    iF += f(0);
                    i = this.d;
                } else {
                    i = 0;
                }
                jvVar.d(iF);
                this.c = i;
            }
            int iF2 = f(i);
            int i2 = this.c + this.d;
            if (iF2 > 0) {
                if (this.b.j() < this.b.e() + iF2) {
                    aee aeeVar = this.b;
                    aeeVar.c(Arrays.copyOf(aeeVar.i(), this.b.e() + iF2), this.b.e());
                }
                jvVar.c(this.b.i(), this.b.e(), iF2);
                aee aeeVar2 = this.b;
                aeeVar2.f(aeeVar2.e() + iF2);
                this.e = this.a.g[i2 + (-1)] != 255;
            }
            if (i2 == this.a.d) {
                i2 = -1;
            }
            this.c = i2;
        }
        return true;
    }
}
