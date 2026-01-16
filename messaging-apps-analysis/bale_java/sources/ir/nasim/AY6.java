package ir.nasim;

import ir.nasim.C13245fu;

/* loaded from: classes2.dex */
public final class AY6 implements C13245fu.a {
    private final String a;

    private /* synthetic */ AY6(String str) {
        this.a = str;
    }

    public static final /* synthetic */ AY6 a(String str) {
        return new AY6(str);
    }

    public static boolean c(String str, Object obj) {
        return (obj instanceof AY6) && AbstractC13042fc3.d(str, ((AY6) obj).f());
    }

    public static int d(String str) {
        return str.hashCode();
    }

    public static String e(String str) {
        return "StringAnnotation(value=" + str + ')';
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

    public static String b(String str) {
        return str;
    }
}
