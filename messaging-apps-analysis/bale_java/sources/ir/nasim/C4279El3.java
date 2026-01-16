package ir.nasim;

import ir.nasim.PJ6;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.El3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C4279El3 {
    public static final C4279El3 a;
    private static final Set b;
    private static final Set c;
    private static final Set d;
    private static final Set e;
    private static final Set f;
    private static final Set g;

    static {
        C4279El3 c4279El3 = new C4279El3();
        a = c4279El3;
        C17582nC6 c17582nC6 = C17582nC6.a;
        b = AbstractC4846Gu6.m(c17582nC6.f("Collection", "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
        c = AbstractC4846Gu6.l(AbstractC4846Gu6.l(AbstractC4846Gu6.l(AbstractC4846Gu6.l(AbstractC4846Gu6.l(AbstractC4846Gu6.l(c4279El3.b(), c17582nC6.f("List", "sort(Ljava/util/Comparator;)V")), c17582nC6.e("String", "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;")), c17582nC6.e("Double", "isInfinite()Z", "isNaN()Z")), c17582nC6.e("Float", "isInfinite()Z", "isNaN()Z")), c17582nC6.e("Enum", "getDeclaringClass()Ljava/lang/Class;", "finalize()V")), c17582nC6.e("CharSequence", "isEmpty()Z"));
        d = AbstractC4846Gu6.l(AbstractC4846Gu6.l(AbstractC4846Gu6.l(AbstractC4846Gu6.l(AbstractC4846Gu6.l(AbstractC4846Gu6.l(c17582nC6.e("CharSequence", "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"), c17582nC6.f("Iterator", "forEachRemaining(Ljava/util/function/Consumer;)V")), c17582nC6.e("Iterable", "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;")), c17582nC6.e("Throwable", "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V")), c17582nC6.f("Collection", "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z")), c17582nC6.f("List", "replaceAll(Ljava/util/function/UnaryOperator;)V")), c17582nC6.f("Map", "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"));
        e = AbstractC4846Gu6.l(AbstractC4846Gu6.l(c17582nC6.f("Collection", "removeIf(Ljava/util/function/Predicate;)Z"), c17582nC6.f("List", "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V")), c17582nC6.f("Map", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"));
        Set setA = c4279El3.a();
        String[] strArrB = c17582nC6.b("D");
        String[] strArr = new String[strArrB.length];
        System.arraycopy(strArrB, 0, strArr, 0, strArrB.length);
        Set setL = AbstractC4846Gu6.l(setA, c17582nC6.e("Float", strArr));
        String[] strArrB2 = c17582nC6.b("[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;");
        String[] strArr2 = new String[strArrB2.length];
        System.arraycopy(strArrB2, 0, strArr2, 0, strArrB2.length);
        f = AbstractC4846Gu6.l(setL, c17582nC6.e("String", strArr2));
        String[] strArrB3 = c17582nC6.b("Ljava/lang/String;Ljava/lang/Throwable;ZZ");
        String[] strArr3 = new String[strArrB3.length];
        System.arraycopy(strArrB3, 0, strArr3, 0, strArrB3.length);
        g = c17582nC6.e("Throwable", strArr3);
    }

    private C4279El3() {
    }

    private final Set a() {
        C17582nC6 c17582nC6 = C17582nC6.a;
        EnumC7376Rl3 enumC7376Rl3 = EnumC7376Rl3.BOOLEAN;
        EnumC7376Rl3 enumC7376Rl32 = EnumC7376Rl3.BYTE;
        List listP = AbstractC10360bX0.p(enumC7376Rl3, enumC7376Rl32, EnumC7376Rl3.DOUBLE, EnumC7376Rl3.FLOAT, enumC7376Rl32, EnumC7376Rl3.INT, EnumC7376Rl3.LONG, EnumC7376Rl3.SHORT);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = listP.iterator();
        while (it.hasNext()) {
            String strH = ((EnumC7376Rl3) it.next()).u().g().h();
            AbstractC13042fc3.h(strH, "it.wrapperFqName.shortName().asString()");
            String[] strArrB = c17582nC6.b("Ljava/lang/String;");
            String[] strArr = new String[strArrB.length];
            System.arraycopy(strArrB, 0, strArr, 0, strArrB.length);
            AbstractC13610gX0.D(linkedHashSet, c17582nC6.e(strH, strArr));
        }
        return linkedHashSet;
    }

    private final Set b() {
        C17582nC6 c17582nC6 = C17582nC6.a;
        List<EnumC7376Rl3> listP = AbstractC10360bX0.p(EnumC7376Rl3.BOOLEAN, EnumC7376Rl3.CHAR);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (EnumC7376Rl3 enumC7376Rl3 : listP) {
            String strH = enumC7376Rl3.u().g().h();
            AbstractC13042fc3.h(strH, "it.wrapperFqName.shortName().asString()");
            AbstractC13610gX0.D(linkedHashSet, c17582nC6.e(strH, enumC7376Rl3.r() + "Value()" + enumC7376Rl3.q()));
        }
        return linkedHashSet;
    }

    public final Set c() {
        return b;
    }

    public final Set d() {
        return f;
    }

    public final Set e() {
        return c;
    }

    public final Set f() {
        return e;
    }

    public final Set g() {
        return g;
    }

    public final Set h() {
        return d;
    }

    public final boolean i(C10027ax2 c10027ax2) {
        AbstractC13042fc3.i(c10027ax2, "fqName");
        return AbstractC13042fc3.d(c10027ax2, PJ6.a.i) || PJ6.e(c10027ax2);
    }

    public final boolean j(C10027ax2 c10027ax2) {
        AbstractC13042fc3.i(c10027ax2, "fqName");
        if (i(c10027ax2)) {
            return true;
        }
        C24948zU0 c24948zU0O = C5203Ii3.a.o(c10027ax2);
        if (c24948zU0O == null) {
            return false;
        }
        try {
            return Serializable.class.isAssignableFrom(Class.forName(c24948zU0O.b().b()));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
