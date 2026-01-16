package ir.nasim;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.Fu6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC4597Fu6 extends AbstractC4363Eu6 {
    public static Set d() {
        return G72.a;
    }

    public static HashSet e(Object... objArr) {
        AbstractC13042fc3.i(objArr, "elements");
        return (HashSet) AbstractC10242bK.W0(objArr, new HashSet(AbstractC19460qO3.f(objArr.length)));
    }

    public static LinkedHashSet f(Object... objArr) {
        AbstractC13042fc3.i(objArr, "elements");
        return (LinkedHashSet) AbstractC10242bK.W0(objArr, new LinkedHashSet(AbstractC19460qO3.f(objArr.length)));
    }

    public static Set g(Object... objArr) {
        AbstractC13042fc3.i(objArr, "elements");
        return (Set) AbstractC10242bK.W0(objArr, new LinkedHashSet(AbstractC19460qO3.f(objArr.length)));
    }

    public static final Set h(Set set) {
        AbstractC13042fc3.i(set, "<this>");
        int size = set.size();
        return size != 0 ? size != 1 ? set : AbstractC4363Eu6.c(set.iterator().next()) : d();
    }

    public static Set i(Object... objArr) {
        AbstractC13042fc3.i(objArr, "elements");
        return AbstractC10242bK.s1(objArr);
    }
}
