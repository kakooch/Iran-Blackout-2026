package ir.nasim;

import java.util.Arrays;

/* renamed from: ir.nasim.bL3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C10255bL3 {
    private final Object a;
    private final Throwable b;

    public C10255bL3(Object obj) {
        this.a = obj;
        this.b = null;
    }

    public Throwable a() {
        return this.b;
    }

    public Object b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C10255bL3)) {
            return false;
        }
        C10255bL3 c10255bL3 = (C10255bL3) obj;
        if (b() != null && b().equals(c10255bL3.b())) {
            return true;
        }
        if (a() == null || c10255bL3.a() == null) {
            return false;
        }
        return a().toString().equals(a().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{b(), a()});
    }

    public C10255bL3(Throwable th) {
        this.b = th;
        this.a = null;
    }
}
