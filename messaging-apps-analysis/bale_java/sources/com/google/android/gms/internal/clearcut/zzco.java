package com.google.android.gms.internal.clearcut;

import ir.nasim.InterfaceC20302rm8;
import java.io.IOException;

/* loaded from: classes3.dex */
public class zzco extends IOException {
    private InterfaceC20302rm8 a;

    public zzco(String str) {
        super(str);
        this.a = null;
    }

    static zzco a() {
        return new zzco("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzco b() {
        return new zzco("Protocol message contained an invalid tag (zero).");
    }

    static zzcp c() {
        return new zzcp("Protocol message tag had invalid wire type.");
    }

    static zzco d() {
        return new zzco("Failed to parse the message.");
    }

    static zzco e() {
        return new zzco("Protocol message had invalid UTF-8.");
    }

    public final zzco f(InterfaceC20302rm8 interfaceC20302rm8) {
        this.a = interfaceC20302rm8;
        return this;
    }
}
