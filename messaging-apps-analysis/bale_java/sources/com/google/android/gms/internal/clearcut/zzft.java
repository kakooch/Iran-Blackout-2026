package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import org.xbill.DNS.Type;

/* loaded from: classes3.dex */
public final class zzft extends IOException {
    zzft(int i, int i2) {
        StringBuilder sb = new StringBuilder(Type.EUI48);
        sb.append("CodedOutputStream was writing to a flat byte array and ran out of space (pos ");
        sb.append(i);
        sb.append(" limit ");
        sb.append(i2);
        sb.append(").");
        super(sb.toString());
    }
}
