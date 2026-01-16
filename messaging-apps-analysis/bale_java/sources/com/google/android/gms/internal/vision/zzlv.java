package com.google.android.gms.internal.vision;

import ir.nasim.InterfaceC18561or8;
import java.util.List;

/* loaded from: classes3.dex */
public final class zzlv extends RuntimeException {
    private final List a;

    public zzlv(InterfaceC18561or8 interfaceC18561or8) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.a = null;
    }
}
