package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;

/* loaded from: classes3.dex */
public final class Ml extends Rl {
    @Override // io.appmetrica.analytics.impl.Rl
    public final ProtobufStateStorage a(Context context, IBinaryDataHelper iBinaryDataHelper) {
        byte[] bArrA;
        byte[] bArrA2;
        C2948we c2948we = new C2948we();
        try {
            bArrA = AbstractC2928vi.a(context.getPackageName());
        } catch (Throwable unused) {
            bArrA = new byte[16];
        }
        try {
            bArrA2 = AbstractC2928vi.a(new StringBuilder(context.getPackageName()).reverse().toString());
        } catch (Throwable unused2) {
            bArrA2 = new byte[16];
        }
        return new Ye("preload_info_data", iBinaryDataHelper, new C2894u8(c2948we, new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, bArrA, bArrA2)), new C2876te());
    }

    @Override // io.appmetrica.analytics.impl.Rl
    public final IBinaryDataHelper c(Context context) {
        C2650k3 c2650k3;
        W6 w6A = W6.a(context);
        synchronized (w6A) {
            try {
                if (w6A.i == null) {
                    w6A.i = new C2650k3(w6A.g());
                }
                c2650k3 = w6A.i;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c2650k3;
    }

    @Override // io.appmetrica.analytics.impl.Rl
    public final IBinaryDataHelper d(Context context) {
        IBinaryDataHelper iBinaryDataHelperG;
        W6 w6A = W6.a(context);
        synchronized (w6A) {
            iBinaryDataHelperG = w6A.g();
        }
        return iBinaryDataHelperG;
    }
}
