package io.appmetrica.analytics.impl;

import ir.nasim.AbstractC10360bX0;
import ir.nasim.C12275eL0;
import java.util.Map;

/* renamed from: io.appmetrica.analytics.impl.ca, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2464ca implements H9 {
    public final C8 a = new C8();

    public final X8[] a(byte[] bArr) {
        int i = 0;
        if (bArr == null) {
            return new X8[0];
        }
        Map<String, byte[]> model = this.a.toModel(bArr);
        X8[] x8Arr = new X8[model.size()];
        for (Object obj : model.entrySet()) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            Map.Entry entry = (Map.Entry) obj;
            X8 x8 = new X8();
            x8.a = ((String) entry.getKey()).getBytes(C12275eL0.b);
            x8.b = (byte[]) entry.getValue();
            x8Arr[i] = x8;
            i = i2;
        }
        return x8Arr;
    }
}
