package io.appmetrica.analytics.impl;

import ir.nasim.AbstractC13042fc3;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes3.dex */
public abstract class Ed {
    public final int a = -1;
    public final int b = 0;
    public final int c = 1;

    public final int a(Boolean bool) {
        if (bool == null) {
            return this.a;
        }
        if (AbstractC13042fc3.d(bool, Boolean.FALSE)) {
            return this.b;
        }
        if (AbstractC13042fc3.d(bool, Boolean.TRUE)) {
            return this.c;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Boolean a(int i) {
        if (i == this.b) {
            return Boolean.FALSE;
        }
        if (i == this.c) {
            return Boolean.TRUE;
        }
        return null;
    }
}
