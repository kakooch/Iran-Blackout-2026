package com.airbnb.lottie;

import android.os.Build;
import ir.nasim.JI3;
import ir.nasim.SK3;
import java.util.HashSet;

/* loaded from: classes2.dex */
class r {
    private final HashSet a = new HashSet();

    r() {
    }

    public boolean a(SK3 sk3, boolean z) {
        if (!z) {
            return this.a.remove(sk3);
        }
        if (Build.VERSION.SDK_INT >= sk3.a) {
            return this.a.add(sk3);
        }
        JI3.c(String.format("%s is not supported pre SDK %d", sk3.name(), Integer.valueOf(sk3.a)));
        return false;
    }

    public boolean b(SK3 sk3) {
        return this.a.contains(sk3);
    }
}
