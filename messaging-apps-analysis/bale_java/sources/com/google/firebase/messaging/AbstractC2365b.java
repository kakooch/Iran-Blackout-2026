package com.google.firebase.messaging;

import android.os.Bundle;
import ir.nasim.KJ;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.firebase.messaging.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2365b {
    public static final long a = TimeUnit.MINUTES.toMillis(3);

    /* renamed from: com.google.firebase.messaging.b$a */
    public static final class a {
        public static KJ a(Bundle bundle) {
            KJ kj = new KJ();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals("from") && !str.equals("message_type") && !str.equals("collapse_key")) {
                        kj.put(str, str2);
                    }
                }
            }
            return kj;
        }
    }
}
