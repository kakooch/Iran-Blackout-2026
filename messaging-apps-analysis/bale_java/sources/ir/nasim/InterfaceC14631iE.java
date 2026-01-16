package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* renamed from: ir.nasim.iE, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC14631iE {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.iE$a */
    public static final class a {
        public static final a b = new a("LOW", 0, RecyclerView.UNDEFINED_DURATION);
        public static final a c = new a("DEFAULT", 1, 0);
        public static final a d = new a("HIGH", 2, Integer.MAX_VALUE);
        private static final /* synthetic */ a[] e;
        private static final /* synthetic */ F92 f;
        private final int a;

        static {
            a[] aVarArrA = a();
            e = aVarArrA;
            f = G92.a(aVarArrA);
        }

        private a(String str, int i, int i2) {
            this.a = i2;
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{b, c, d};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) e.clone();
        }

        public final int j() {
            return this.a;
        }
    }

    static /* synthetic */ Object c(InterfaceC14631iE interfaceC14631iE, InterfaceC20295rm1 interfaceC20295rm1) {
        return C19938rB7.a;
    }

    default Object a(InterfaceC20295rm1 interfaceC20295rm1) {
        return c(this, interfaceC20295rm1);
    }

    default List b() {
        return AbstractC10360bX0.m();
    }

    void d();

    default a getPriority() {
        return a.c;
    }
}
