package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aej {
    private static final Comparator<aei> a = aeg.a;
    private static final Comparator<aei> b = aeh.a;
    private int g;
    private int h;
    private int i;
    private final int c = 2000;
    private final aei[] e = new aei[5];
    private final ArrayList<aei> d = new ArrayList<>();
    private int f = -1;

    public aej(int i) {
    }

    public final void a() {
        this.d.clear();
        this.f = -1;
        this.g = 0;
        this.h = 0;
    }

    public final void b(int i, float f) {
        aei aeiVar;
        if (this.f != 1) {
            Collections.sort(this.d, a);
            this.f = 1;
        }
        int i2 = this.i;
        if (i2 > 0) {
            aei[] aeiVarArr = this.e;
            int i3 = i2 - 1;
            this.i = i3;
            aeiVar = aeiVarArr[i3];
        } else {
            aeiVar = new aei(null);
        }
        int i4 = this.g;
        this.g = i4 + 1;
        aeiVar.a = i4;
        aeiVar.b = i;
        aeiVar.c = f;
        this.d.add(aeiVar);
        this.h += i;
        while (true) {
            int i5 = this.h;
            if (i5 <= 2000) {
                return;
            }
            int i6 = i5 - 2000;
            aei aeiVar2 = this.d.get(0);
            int i7 = aeiVar2.b;
            if (i7 <= i6) {
                this.h -= i7;
                this.d.remove(0);
                int i8 = this.i;
                if (i8 < 5) {
                    aei[] aeiVarArr2 = this.e;
                    this.i = i8 + 1;
                    aeiVarArr2[i8] = aeiVar2;
                }
            } else {
                aeiVar2.b = i7 - i6;
                this.h -= i6;
            }
        }
    }

    public final float c() {
        if (this.f != 0) {
            Collections.sort(this.d, b);
            this.f = 0;
        }
        float f = this.h * 0.5f;
        int i = 0;
        for (int i2 = 0; i2 < this.d.size(); i2++) {
            aei aeiVar = this.d.get(i2);
            i += aeiVar.b;
            if (i >= f) {
                return aeiVar.c;
            }
        }
        if (this.d.isEmpty()) {
            return Float.NaN;
        }
        return this.d.get(r0.size() - 1).c;
    }
}
