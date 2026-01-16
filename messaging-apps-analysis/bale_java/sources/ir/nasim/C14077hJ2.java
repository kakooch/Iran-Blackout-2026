package ir.nasim;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: ir.nasim.hJ2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C14077hJ2 {
    private static volatile C14077hJ2 b;
    private final Set a = new HashSet();

    C14077hJ2() {
    }

    public static C14077hJ2 a() {
        C14077hJ2 c14077hJ2 = b;
        if (c14077hJ2 == null) {
            synchronized (C14077hJ2.class) {
                try {
                    c14077hJ2 = b;
                    if (c14077hJ2 == null) {
                        c14077hJ2 = new C14077hJ2();
                        b = c14077hJ2;
                    }
                } finally {
                }
            }
        }
        return c14077hJ2;
    }

    Set b() {
        Set setUnmodifiableSet;
        synchronized (this.a) {
            setUnmodifiableSet = Collections.unmodifiableSet(this.a);
        }
        return setUnmodifiableSet;
    }
}
