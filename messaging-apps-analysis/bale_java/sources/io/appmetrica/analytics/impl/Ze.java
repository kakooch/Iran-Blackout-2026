package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import android.util.Base64;
import io.appmetrica.analytics.protobuf.nano.MessageNano;

/* loaded from: classes3.dex */
public final class Ze implements pn {
    @Override // io.appmetrica.analytics.impl.pn
    public final byte[] a(G8 g8, Cg cg) {
        if (!TextUtils.isEmpty(g8.b)) {
            try {
                byte[] bArrDecode = Base64.decode(g8.b, 0);
                Cf cf = (bArrDecode == null || bArrDecode.length == 0) ? null : new Cf(bArrDecode);
                Cif cif = new Cif();
                String str = cf.a;
                cif.a = str == null ? new byte[0] : str.getBytes();
                cif.c = cf.b;
                cif.b = cf.c;
                int iOrdinal = cf.d.ordinal();
                int i = 1;
                if (iOrdinal != 1) {
                    i = 2;
                    if (iOrdinal != 2) {
                        i = 0;
                    }
                }
                cif.d = i;
                return MessageNano.toByteArray(cif);
            } catch (Throwable unused) {
            }
        }
        return new byte[0];
    }
}
