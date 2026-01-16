package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.internal.AbstractC2058b;
import ir.nasim.InterfaceC17823nd1;
import ir.nasim.PB6;
import ir.nasim.ZI4;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public abstract class c {
    private static final Set a = Collections.newSetFromMap(new WeakHashMap());

    public interface a extends InterfaceC17823nd1 {
    }

    public interface b extends ZI4 {
    }

    public static Set b() {
        Set set = a;
        synchronized (set) {
        }
        return set;
    }

    public abstract AbstractC2058b a(AbstractC2058b abstractC2058b);

    public abstract Looper c();

    public boolean d(PB6 pb6) {
        throw new UnsupportedOperationException();
    }

    public void e() {
        throw new UnsupportedOperationException();
    }
}
