package ir.nasim;

import android.hardware.camera2.params.InputConfiguration;
import android.os.Build;
import java.util.Objects;

/* renamed from: ir.nasim.h93, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C13987h93 {
    private final c a;

    /* renamed from: ir.nasim.h93$a */
    private static class a implements c {
        private final InputConfiguration a;

        a(Object obj) {
            this.a = (InputConfiguration) obj;
        }

        @Override // ir.nasim.C13987h93.c
        public Object a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return Objects.equals(this.a, ((c) obj).a());
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return this.a.toString();
        }
    }

    /* renamed from: ir.nasim.h93$b */
    private static final class b extends a {
        b(Object obj) {
            super(obj);
        }
    }

    /* renamed from: ir.nasim.h93$c */
    private interface c {
        Object a();
    }

    private C13987h93(c cVar) {
        this.a = cVar;
    }

    public static C13987h93 b(Object obj) {
        if (obj == null) {
            return null;
        }
        return Build.VERSION.SDK_INT >= 31 ? new C13987h93(new b(obj)) : new C13987h93(new a(obj));
    }

    public Object a() {
        return this.a.a();
    }

    public boolean equals(Object obj) {
        if (obj instanceof C13987h93) {
            return this.a.equals(((C13987h93) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a.toString();
    }
}
