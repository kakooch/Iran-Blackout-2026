package ir.nasim.core.modules.file.audio.audiofocus;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.F92;
import ir.nasim.G92;

/* loaded from: classes5.dex */
public interface c {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class a {
        public static final a b = new a("CONTENT_TYPE_UNKNOWN", 0, 0);
        public static final a c = new a("CONTENT_TYPE_SPEECH", 1, 1);
        public static final a d = new a("CONTENT_TYPE_MUSIC", 2, 2);
        public static final a e = new a("CONTENT_TYPE_MOVIE", 3, 3);
        public static final a f = new a("CONTENT_TYPE_SONIFICATION", 4, 4);
        private static final /* synthetic */ a[] g;
        private static final /* synthetic */ F92 h;
        private final int a;

        static {
            a[] aVarArrA = a();
            g = aVarArrA;
            h = G92.a(aVarArrA);
        }

        private a(String str, int i, int i2) {
            this.a = i2;
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{b, c, d, e, f};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) g.clone();
        }

        public final int j() {
            return this.a;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class b {
        public static final b a = new b("REGULAR", 0);
        public static final b b = new b("DUCKING", 1);
        private static final /* synthetic */ b[] c;
        private static final /* synthetic */ F92 d;

        static {
            b[] bVarArrA = a();
            c = bVarArrA;
            d = G92.a(bVarArrA);
        }

        private b(String str, int i) {
        }

        private static final /* synthetic */ b[] a() {
            return new b[]{a, b};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) c.clone();
        }
    }

    a getContentType();

    default void p(b bVar) {
        AbstractC13042fc3.i(bVar, "lossType");
    }

    default boolean q() {
        return false;
    }

    default void r() {
        x();
    }

    default void x() {
    }
}
