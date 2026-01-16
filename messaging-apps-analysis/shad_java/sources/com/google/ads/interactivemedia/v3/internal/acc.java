package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;
import org.rbmain.messenger.MessagesController;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class acc {
    private final boolean a;
    private final int b;
    private final byte[] c;
    private final abj[] d;
    private int e;
    private int f;
    private int g;
    private abj[] h;

    public acc() {
        ary.o(true);
        ary.o(true);
        this.a = true;
        this.b = MessagesController.UPDATE_MASK_CHECK;
        this.g = 0;
        this.h = new abj[100];
        this.c = null;
        this.d = new abj[1];
    }

    public final synchronized void a() {
        b(0);
    }

    public final synchronized void b(int i) {
        int i2 = this.e;
        this.e = i;
        if (i < i2) {
            f();
        }
    }

    public final synchronized abj c() {
        abj abjVar;
        this.f++;
        int i = this.g;
        if (i > 0) {
            abj[] abjVarArr = this.h;
            int i2 = i - 1;
            this.g = i2;
            abjVar = abjVarArr[i2];
            ary.t(abjVar);
            this.h[this.g] = null;
        } else {
            abjVar = new abj(new byte[MessagesController.UPDATE_MASK_CHECK], 0);
        }
        return abjVar;
    }

    public final synchronized void d(abj abjVar) {
        abj[] abjVarArr = this.d;
        abjVarArr[0] = abjVar;
        e(abjVarArr);
    }

    public final synchronized void e(abj[] abjVarArr) {
        int length = this.g + abjVarArr.length;
        abj[] abjVarArr2 = this.h;
        int length2 = abjVarArr2.length;
        if (length >= length2) {
            this.h = (abj[]) Arrays.copyOf(abjVarArr2, Math.max(length2 + length2, length));
        }
        for (abj abjVar : abjVarArr) {
            abj[] abjVarArr3 = this.h;
            int i = this.g;
            this.g = i + 1;
            abjVarArr3[i] = abjVar;
        }
        this.f -= abjVarArr.length;
        notifyAll();
    }

    public final synchronized void f() {
        int iMax = Math.max(0, aeu.F(this.e, MessagesController.UPDATE_MASK_CHECK) - this.f);
        int i = this.g;
        if (iMax >= i) {
            return;
        }
        Arrays.fill(this.h, iMax, i, (Object) null);
        this.g = iMax;
    }

    public final synchronized int g() {
        return this.f * MessagesController.UPDATE_MASK_CHECK;
    }

    public final int h() {
        return MessagesController.UPDATE_MASK_CHECK;
    }
}
