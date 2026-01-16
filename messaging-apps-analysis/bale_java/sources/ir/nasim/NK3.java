package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes2.dex */
public interface NK3 {

    public static final class a implements NK3 {
        private final String a;

        private /* synthetic */ a(String str) {
            this.a = str;
        }

        public static final /* synthetic */ a a(String str) {
            return new a(str);
        }

        public static String b(String str) {
            AbstractC13042fc3.i(str, "jsonString");
            return str;
        }

        public static boolean c(String str, Object obj) {
            return (obj instanceof a) && AbstractC13042fc3.d(str, ((a) obj).f());
        }

        public static int d(String str) {
            return str.hashCode();
        }

        public static String e(String str) {
            return "JsonString(jsonString=" + str + Separators.RPAREN;
        }

        public boolean equals(Object obj) {
            return c(this.a, obj);
        }

        public final /* synthetic */ String f() {
            return this.a;
        }

        public int hashCode() {
            return d(this.a);
        }

        public String toString() {
            return e(this.a);
        }
    }

    public static final class b implements NK3 {
        private final int a;

        private /* synthetic */ b(int i) {
            this.a = i;
        }

        public static final /* synthetic */ b a(int i) {
            return new b(i);
        }

        public static boolean c(int i, Object obj) {
            return (obj instanceof b) && i == ((b) obj).f();
        }

        public static int d(int i) {
            return Integer.hashCode(i);
        }

        public static String e(int i) {
            return "RawRes(resId=" + i + Separators.RPAREN;
        }

        public boolean equals(Object obj) {
            return c(this.a, obj);
        }

        public final /* synthetic */ int f() {
            return this.a;
        }

        public int hashCode() {
            return d(this.a);
        }

        public String toString() {
            return e(this.a);
        }

        public static int b(int i) {
            return i;
        }
    }
}
