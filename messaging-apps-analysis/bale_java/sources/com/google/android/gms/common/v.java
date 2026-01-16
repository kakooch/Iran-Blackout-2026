package com.google.android.gms.common;

import ir.nasim.AbstractC12037dv8;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
final class v extends w {
    private final Callable f;

    /* synthetic */ v(Callable callable, AbstractC12037dv8 abstractC12037dv8) {
        super();
        this.f = callable;
    }

    @Override // com.google.android.gms.common.w
    final String a() {
        try {
            return (String) this.f.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
