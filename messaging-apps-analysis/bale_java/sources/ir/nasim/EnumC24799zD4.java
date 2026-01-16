package ir.nasim;

import java.io.Serializable;
import java.util.Objects;

/* renamed from: ir.nasim.zD4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public enum EnumC24799zD4 {
    COMPLETE;

    /* renamed from: ir.nasim.zD4$a */
    static final class a implements Serializable {
        final Throwable a;

        a(Throwable th) {
            this.a = th;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return Objects.equals(this.a, ((a) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.a + "]";
        }
    }

    public static boolean a(Object obj, PG4 pg4) {
        if (obj == COMPLETE) {
            pg4.c();
            return true;
        }
        if (obj instanceof a) {
            pg4.a(((a) obj).a);
            return true;
        }
        pg4.e(obj);
        return false;
    }

    public static boolean j(Object obj, PG4 pg4) {
        if (obj == COMPLETE) {
            pg4.c();
            return true;
        }
        if (obj instanceof a) {
            pg4.a(((a) obj).a);
            return true;
        }
        pg4.e(obj);
        return false;
    }

    public static Object p() {
        return COMPLETE;
    }

    public static Object q(Throwable th) {
        return new a(th);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    public static Object r(Object obj) {
        return obj;
    }
}
