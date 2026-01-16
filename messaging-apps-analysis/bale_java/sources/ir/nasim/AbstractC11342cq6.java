package ir.nasim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.cq6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC11342cq6 extends AbstractC10579bq6 {

    /* renamed from: ir.nasim.cq6$a */
    public static final class a implements Iterable, InterfaceC17915nm3 {
        final /* synthetic */ InterfaceC23384wp6 a;

        public a(InterfaceC23384wp6 interfaceC23384wp6) {
            this.a = interfaceC23384wp6;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return this.a.iterator();
        }
    }

    /* renamed from: ir.nasim.cq6$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i) {
            super(1);
            this.e = i;
        }

        public final Object a(int i) {
            throw new IndexOutOfBoundsException("Sequence doesn't contain element at index " + this.e + '.');
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    /* renamed from: ir.nasim.cq6$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Object obj) {
            return Boolean.valueOf(obj == null);
        }
    }

    /* renamed from: ir.nasim.cq6$d */
    /* synthetic */ class d extends EB2 implements UA2 {
        public static final d a = new d();

        d() {
            super(1, Iterable.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
        }

        @Override // ir.nasim.UA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final Iterator invoke(Iterable iterable) {
            AbstractC13042fc3.i(iterable, "p0");
            return iterable.iterator();
        }
    }

    /* renamed from: ir.nasim.cq6$e */
    /* synthetic */ class e extends EB2 implements UA2 {
        public static final e a = new e();

        e() {
            super(1, InterfaceC23384wp6.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
        }

        @Override // ir.nasim.UA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final Iterator invoke(InterfaceC23384wp6 interfaceC23384wp6) {
            AbstractC13042fc3.i(interfaceC23384wp6, "p0");
            return interfaceC23384wp6.iterator();
        }
    }

    public static /* synthetic */ String A(InterfaceC23384wp6 interfaceC23384wp6, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, UA2 ua2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
        if ((i2 & 8) != 0) {
            i = -1;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            ua2 = null;
        }
        return z(interfaceC23384wp6, charSequence, charSequence5, charSequence6, i3, charSequence7, ua2);
    }

    public static Object B(InterfaceC23384wp6 interfaceC23384wp6) {
        AbstractC13042fc3.i(interfaceC23384wp6, "<this>");
        Iterator it = interfaceC23384wp6.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Sequence is empty.");
        }
        Object next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static InterfaceC23384wp6 C(InterfaceC23384wp6 interfaceC23384wp6, UA2 ua2) {
        AbstractC13042fc3.i(interfaceC23384wp6, "<this>");
        AbstractC13042fc3.i(ua2, "transform");
        return new C20391rv7(interfaceC23384wp6, ua2);
    }

    public static InterfaceC23384wp6 D(InterfaceC23384wp6 interfaceC23384wp6, InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(interfaceC23384wp6, "<this>");
        AbstractC13042fc3.i(interfaceC14603iB2, "transform");
        return new C19782qv7(interfaceC23384wp6, interfaceC14603iB2);
    }

    public static InterfaceC23384wp6 E(InterfaceC23384wp6 interfaceC23384wp6, UA2 ua2) {
        AbstractC13042fc3.i(interfaceC23384wp6, "<this>");
        AbstractC13042fc3.i(ua2, "transform");
        return t(new C20391rv7(interfaceC23384wp6, ua2));
    }

    public static InterfaceC23384wp6 F(InterfaceC23384wp6 interfaceC23384wp6, Iterable iterable) {
        AbstractC13042fc3.i(interfaceC23384wp6, "<this>");
        AbstractC13042fc3.i(iterable, "elements");
        return AbstractC9962aq6.f(AbstractC9962aq6.k(interfaceC23384wp6, AbstractC15401jX0.g0(iterable)));
    }

    public static InterfaceC23384wp6 G(InterfaceC23384wp6 interfaceC23384wp6, Object obj) {
        AbstractC13042fc3.i(interfaceC23384wp6, "<this>");
        return AbstractC9962aq6.f(AbstractC9962aq6.k(interfaceC23384wp6, AbstractC9962aq6.k(obj)));
    }

    public static InterfaceC23384wp6 H(InterfaceC23384wp6 interfaceC23384wp6, int i) {
        AbstractC13042fc3.i(interfaceC23384wp6, "<this>");
        if (i >= 0) {
            return i == 0 ? AbstractC9962aq6.e() : interfaceC23384wp6 instanceof InterfaceC19834r12 ? ((InterfaceC19834r12) interfaceC23384wp6).b(i) : new C18480oj7(interfaceC23384wp6, i);
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    public static InterfaceC23384wp6 I(InterfaceC23384wp6 interfaceC23384wp6, UA2 ua2) {
        AbstractC13042fc3.i(interfaceC23384wp6, "<this>");
        AbstractC13042fc3.i(ua2, "predicate");
        return new C19071pj7(interfaceC23384wp6, ua2);
    }

    public static final Collection J(InterfaceC23384wp6 interfaceC23384wp6, Collection collection) {
        AbstractC13042fc3.i(interfaceC23384wp6, "<this>");
        AbstractC13042fc3.i(collection, "destination");
        Iterator it = interfaceC23384wp6.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
        return collection;
    }

    public static List K(InterfaceC23384wp6 interfaceC23384wp6) {
        AbstractC13042fc3.i(interfaceC23384wp6, "<this>");
        Iterator it = interfaceC23384wp6.iterator();
        if (!it.hasNext()) {
            return AbstractC10360bX0.m();
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return AbstractC9766aX0.e(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static List L(InterfaceC23384wp6 interfaceC23384wp6) {
        AbstractC13042fc3.i(interfaceC23384wp6, "<this>");
        return (List) J(interfaceC23384wp6, new ArrayList());
    }

    public static Set M(InterfaceC23384wp6 interfaceC23384wp6) {
        AbstractC13042fc3.i(interfaceC23384wp6, "<this>");
        Iterator it = interfaceC23384wp6.iterator();
        if (!it.hasNext()) {
            return AbstractC4597Fu6.d();
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return AbstractC4363Eu6.c(next);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(next);
        while (it.hasNext()) {
            linkedHashSet.add(it.next());
        }
        return linkedHashSet;
    }

    public static final InterfaceC23384wp6 N(InterfaceC23384wp6 interfaceC23384wp6, int i, int i2, boolean z) {
        AbstractC13042fc3.i(interfaceC23384wp6, "<this>");
        return AbstractC20573sE6.c(interfaceC23384wp6, i, i2, z, false);
    }

    public static Iterable l(InterfaceC23384wp6 interfaceC23384wp6) {
        AbstractC13042fc3.i(interfaceC23384wp6, "<this>");
        return new a(interfaceC23384wp6);
    }

    public static InterfaceC23384wp6 m(InterfaceC23384wp6 interfaceC23384wp6, int i) {
        AbstractC13042fc3.i(interfaceC23384wp6, "<this>");
        return N(interfaceC23384wp6, i, i, true);
    }

    public static int n(InterfaceC23384wp6 interfaceC23384wp6) {
        AbstractC13042fc3.i(interfaceC23384wp6, "<this>");
        Iterator it = interfaceC23384wp6.iterator();
        int i = 0;
        while (it.hasNext()) {
            it.next();
            i++;
            if (i < 0) {
                AbstractC10360bX0.v();
            }
        }
        return i;
    }

    public static InterfaceC23384wp6 o(InterfaceC23384wp6 interfaceC23384wp6, int i) {
        AbstractC13042fc3.i(interfaceC23384wp6, "<this>");
        if (i >= 0) {
            return i == 0 ? interfaceC23384wp6 : interfaceC23384wp6 instanceof InterfaceC19834r12 ? ((InterfaceC19834r12) interfaceC23384wp6).a(i) : new C16879m12(interfaceC23384wp6, i);
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    public static Object p(InterfaceC23384wp6 interfaceC23384wp6, int i) {
        AbstractC13042fc3.i(interfaceC23384wp6, "<this>");
        return q(interfaceC23384wp6, i, new b(i));
    }

    public static final Object q(InterfaceC23384wp6 interfaceC23384wp6, int i, UA2 ua2) {
        AbstractC13042fc3.i(interfaceC23384wp6, "<this>");
        AbstractC13042fc3.i(ua2, "defaultValue");
        if (i < 0) {
            return ua2.invoke(Integer.valueOf(i));
        }
        int i2 = 0;
        for (Object obj : interfaceC23384wp6) {
            int i3 = i2 + 1;
            if (i == i2) {
                return obj;
            }
            i2 = i3;
        }
        return ua2.invoke(Integer.valueOf(i));
    }

    public static InterfaceC23384wp6 r(InterfaceC23384wp6 interfaceC23384wp6, UA2 ua2) {
        AbstractC13042fc3.i(interfaceC23384wp6, "<this>");
        AbstractC13042fc3.i(ua2, "predicate");
        return new C20907so2(interfaceC23384wp6, true, ua2);
    }

    public static InterfaceC23384wp6 s(InterfaceC23384wp6 interfaceC23384wp6, UA2 ua2) {
        AbstractC13042fc3.i(interfaceC23384wp6, "<this>");
        AbstractC13042fc3.i(ua2, "predicate");
        return new C20907so2(interfaceC23384wp6, false, ua2);
    }

    public static InterfaceC23384wp6 t(InterfaceC23384wp6 interfaceC23384wp6) {
        AbstractC13042fc3.i(interfaceC23384wp6, "<this>");
        InterfaceC23384wp6 interfaceC23384wp6S = s(interfaceC23384wp6, c.e);
        AbstractC13042fc3.g(interfaceC23384wp6S, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return interfaceC23384wp6S;
    }

    public static Object u(InterfaceC23384wp6 interfaceC23384wp6) {
        AbstractC13042fc3.i(interfaceC23384wp6, "<this>");
        Iterator it = interfaceC23384wp6.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    public static Object v(InterfaceC23384wp6 interfaceC23384wp6) {
        AbstractC13042fc3.i(interfaceC23384wp6, "<this>");
        Iterator it = interfaceC23384wp6.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static InterfaceC23384wp6 w(InterfaceC23384wp6 interfaceC23384wp6, UA2 ua2) {
        AbstractC13042fc3.i(interfaceC23384wp6, "<this>");
        AbstractC13042fc3.i(ua2, "transform");
        return new C5967Lp2(interfaceC23384wp6, ua2, e.a);
    }

    public static InterfaceC23384wp6 x(InterfaceC23384wp6 interfaceC23384wp6, UA2 ua2) {
        AbstractC13042fc3.i(interfaceC23384wp6, "<this>");
        AbstractC13042fc3.i(ua2, "transform");
        return new C5967Lp2(interfaceC23384wp6, ua2, d.a);
    }

    public static final Appendable y(InterfaceC23384wp6 interfaceC23384wp6, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, UA2 ua2) throws IOException {
        AbstractC13042fc3.i(interfaceC23384wp6, "<this>");
        AbstractC13042fc3.i(appendable, "buffer");
        AbstractC13042fc3.i(charSequence, "separator");
        AbstractC13042fc3.i(charSequence2, "prefix");
        AbstractC13042fc3.i(charSequence3, "postfix");
        AbstractC13042fc3.i(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i2 = 0;
        for (Object obj : interfaceC23384wp6) {
            i2++;
            if (i2 > 1) {
                appendable.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            AbstractC15425jZ6.b(appendable, obj, ua2);
        }
        if (i >= 0 && i2 > i) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final String z(InterfaceC23384wp6 interfaceC23384wp6, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, UA2 ua2) {
        AbstractC13042fc3.i(interfaceC23384wp6, "<this>");
        AbstractC13042fc3.i(charSequence, "separator");
        AbstractC13042fc3.i(charSequence2, "prefix");
        AbstractC13042fc3.i(charSequence3, "postfix");
        AbstractC13042fc3.i(charSequence4, "truncated");
        String string = ((StringBuilder) y(interfaceC23384wp6, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, ua2)).toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }
}
