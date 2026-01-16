package com.google.android.gms.internal.clearcut;

import ir.nasim.InterfaceC20302rm8;
import java.util.List;

/* loaded from: classes3.dex */
public final class zzew extends RuntimeException {
    private final List a;

    public zzew(InterfaceC20302rm8 interfaceC20302rm8) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.a = null;
    }
}
