package io.sentry.android.replay.util;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20723sV3;
import ir.nasim.C13774gn7;

/* loaded from: classes3.dex */
public final class b implements o {
    public static final int c = C13774gn7.g;
    private final C13774gn7 a;
    private final boolean b;

    public b(C13774gn7 c13774gn7, boolean z) {
        AbstractC13042fc3.i(c13774gn7, "layout");
        this.a = c13774gn7;
        this.b = z;
    }

    @Override // io.sentry.android.replay.util.o
    public int a(int i) {
        return AbstractC20723sV3.d(this.a.v(i));
    }

    @Override // io.sentry.android.replay.util.o
    public int b(int i) {
        return this.a.u(i);
    }

    @Override // io.sentry.android.replay.util.o
    public int d(int i) {
        return AbstractC20723sV3.d(this.a.m(i));
    }

    @Override // io.sentry.android.replay.util.o
    public float e(int i, int i2) {
        float fJ = this.a.j(i2, true);
        return (this.b || getLineCount() != 1) ? fJ : fJ - this.a.s(i);
    }

    @Override // io.sentry.android.replay.util.o
    public Integer f() {
        return null;
    }

    @Override // io.sentry.android.replay.util.o
    public int g(int i) {
        return this.a.o(i, true);
    }

    @Override // io.sentry.android.replay.util.o
    public int getLineCount() {
        return this.a.n();
    }

    @Override // io.sentry.android.replay.util.o
    public int h(int i) {
        return this.a.D(i) ? 1 : 0;
    }
}
