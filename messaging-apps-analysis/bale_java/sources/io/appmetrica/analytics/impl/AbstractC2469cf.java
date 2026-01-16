package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import ir.nasim.C12275eL0;
import java.util.Iterator;

/* renamed from: io.appmetrica.analytics.impl.cf, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2469cf {
    public static final String a(Z8 z8) {
        String string;
        Iterator it = AbstractC2776p9.e.iterator();
        while (it.hasNext()) {
            if (z8.c == ((Integer) it.next()).intValue()) {
                StringBuilder sb = new StringBuilder("Event sent: ");
                if (z8.c == 3 && TextUtils.isEmpty(z8.d)) {
                    string = "Native crash of app";
                } else if (z8.c == 4) {
                    StringBuilder sb2 = new StringBuilder(z8.d);
                    byte[] bArr = z8.e;
                    if (bArr != null) {
                        String str = new String(bArr, C12275eL0.b);
                        if (!TextUtils.isEmpty(str)) {
                            sb2.append(" with value ");
                            sb2.append(str);
                        }
                    }
                    string = sb2.toString();
                } else {
                    string = z8.d;
                }
                sb.append(string);
                return sb.toString();
            }
        }
        return null;
    }
}
