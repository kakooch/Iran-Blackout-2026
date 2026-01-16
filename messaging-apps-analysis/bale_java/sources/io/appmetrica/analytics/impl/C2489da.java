package io.appmetrica.analytics.impl;

import ir.nasim.AbstractC13042fc3;
import java.util.concurrent.TimeUnit;

/* renamed from: io.appmetrica.analytics.impl.da, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2489da implements Lb {
    @Override // io.appmetrica.analytics.impl.Lb
    public final U8 a(C2559g7 c2559g7) {
        U8 u8 = null;
        if ((c2559g7 != null ? c2559g7.b : null) != null && c2559g7.c != null) {
            u8 = new U8();
            u8.b = c2559g7.b.doubleValue();
            u8.a = c2559g7.c.doubleValue();
            Integer num = c2559g7.d;
            if (num != null) {
                u8.g = num.intValue();
            }
            Integer num2 = c2559g7.e;
            if (num2 != null) {
                u8.e = num2.intValue();
            }
            Integer num3 = c2559g7.f;
            if (num3 != null) {
                u8.d = num3.intValue();
            }
            Integer num4 = c2559g7.g;
            if (num4 != null) {
                u8.f = num4.intValue();
            }
            Long l = c2559g7.h;
            if (l != null) {
                u8.c = TimeUnit.MILLISECONDS.toSeconds(l.longValue());
            }
            String str = c2559g7.i;
            if (str != null) {
                if (AbstractC13042fc3.d(str, "gps")) {
                    u8.h = 1;
                } else if (AbstractC13042fc3.d(str, "network")) {
                    u8.h = 2;
                }
            }
            String str2 = c2559g7.j;
            if (str2 != null) {
                u8.i = str2;
            }
        }
        return u8;
    }
}
