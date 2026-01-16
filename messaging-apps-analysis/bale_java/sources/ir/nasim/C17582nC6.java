package ir.nasim;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.nC6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C17582nC6 {
    public static final C17582nC6 a = new C17582nC6();

    /* renamed from: ir.nasim.nC6$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(String str) {
            AbstractC13042fc3.i(str, "it");
            return C17582nC6.this.c(str);
        }
    }

    private C17582nC6() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String c(String str) {
        if (str.length() <= 1) {
            return str;
        }
        return 'L' + str + ';';
    }

    public final String[] b(String... strArr) {
        AbstractC13042fc3.i(strArr, "signatures");
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add("<init>(" + str + ")V");
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final Set d(String str, String... strArr) {
        AbstractC13042fc3.i(str, "internalName");
        AbstractC13042fc3.i(strArr, "signatures");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str2 : strArr) {
            linkedHashSet.add(str + '.' + str2);
        }
        return linkedHashSet;
    }

    public final Set e(String str, String... strArr) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(strArr, "signatures");
        String strH = h(str);
        String[] strArr2 = new String[strArr.length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return d(strH, strArr2);
    }

    public final Set f(String str, String... strArr) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(strArr, "signatures");
        String strI = i(str);
        String[] strArr2 = new String[strArr.length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return d(strI, strArr2);
    }

    public final String g(String str) {
        AbstractC13042fc3.i(str, "name");
        return AbstractC13042fc3.q("java/util/function/", str);
    }

    public final String h(String str) {
        AbstractC13042fc3.i(str, "name");
        return AbstractC13042fc3.q("java/lang/", str);
    }

    public final String i(String str) {
        AbstractC13042fc3.i(str, "name");
        return AbstractC13042fc3.q("java/util/", str);
    }

    public final String j(String str, List list, String str2) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(list, "parameters");
        AbstractC13042fc3.i(str2, "ret");
        return str + '(' + AbstractC15401jX0.A0(list, "", null, null, 0, null, new a(), 30, null) + ')' + c(str2);
    }

    public final String k(String str, String str2) {
        AbstractC13042fc3.i(str, "internalName");
        AbstractC13042fc3.i(str2, "jvmDescriptor");
        return str + '.' + str2;
    }
}
