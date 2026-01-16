package androidx.navigation;

import androidx.navigation.i;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC11342cq6;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC20609sI6;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9962aq6;
import ir.nasim.C19409qI6;
import ir.nasim.ED1;
import ir.nasim.InterfaceC17915nm3;
import ir.nasim.UA2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public class j extends i implements Iterable, InterfaceC17915nm3 {
    public static final a p = new a(null);
    private final C19409qI6 l;
    private int m;
    private String n;
    private String o;

    public static final class a {

        /* renamed from: androidx.navigation.j$a$a, reason: collision with other inner class name */
        static final class C0106a extends AbstractC8614Ws3 implements UA2 {
            public static final C0106a e = new C0106a();

            C0106a() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final i invoke(i iVar) {
                AbstractC13042fc3.i(iVar, "it");
                if (!(iVar instanceof j)) {
                    return null;
                }
                j jVar = (j) iVar;
                return jVar.Z(jVar.g0());
            }
        }

        private a() {
        }

        public final i a(j jVar) {
            AbstractC13042fc3.i(jVar, "<this>");
            return (i) AbstractC11342cq6.B(AbstractC9962aq6.j(jVar.Z(jVar.g0()), C0106a.e));
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class b implements Iterator, InterfaceC17915nm3 {
        private int a = -1;
        private boolean b;

        b() {
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public i next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.b = true;
            C19409qI6 c19409qI6D0 = j.this.d0();
            int i = this.a + 1;
            this.a = i;
            Object objP = c19409qI6D0.p(i);
            AbstractC13042fc3.h(objP, "nodes.valueAt(++index)");
            return (i) objP;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a + 1 < j.this.d0().o();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.b) {
                throw new IllegalStateException("You must call next() before you can remove an element".toString());
            }
            C19409qI6 c19409qI6D0 = j.this.d0();
            ((i) c19409qI6D0.p(this.a)).R(null);
            c19409qI6D0.m(this.a);
            this.a--;
            this.b = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(p pVar) {
        super(pVar);
        AbstractC13042fc3.i(pVar, "navGraphNavigator");
        this.l = new C19409qI6();
    }

    private final void l0(int i) {
        if (i != A()) {
            if (this.o != null) {
                n0(null);
            }
            this.m = i;
            this.n = null;
            return;
        }
        throw new IllegalArgumentException(("Start destination " + i + " cannot use the same id as the graph " + this).toString());
    }

    private final void n0(String str) {
        int iHashCode;
        if (str == null) {
            iHashCode = 0;
        } else {
            if (!(!AbstractC13042fc3.d(str, E()))) {
                throw new IllegalArgumentException(("Start destination " + str + " cannot use the same route as the graph " + this).toString());
            }
            if (!(!AbstractC20762sZ6.n0(str))) {
                throw new IllegalArgumentException("Cannot have an empty start destination route".toString());
            }
            iHashCode = i.j.a(str).hashCode();
        }
        this.m = iHashCode;
        this.o = str;
    }

    @Override // androidx.navigation.i
    public i.b L(h hVar) {
        AbstractC13042fc3.i(hVar, "navDeepLinkRequest");
        i.b bVarL = super.L(hVar);
        ArrayList arrayList = new ArrayList();
        Iterator it = iterator();
        while (it.hasNext()) {
            i.b bVarL2 = ((i) it.next()).L(hVar);
            if (bVarL2 != null) {
                arrayList.add(bVarL2);
            }
        }
        return (i.b) AbstractC15401jX0.H0(AbstractC10360bX0.r(bVarL, (i.b) AbstractC15401jX0.H0(arrayList)));
    }

    public final void W(i iVar) {
        AbstractC13042fc3.i(iVar, "node");
        int iA = iVar.A();
        String strE = iVar.E();
        if (iA == 0 && strE == null) {
            throw new IllegalArgumentException("Destinations must have an id or route. Call setId(), setRoute(), or include an android:id or app:route in your navigation XML.".toString());
        }
        if (E() != null && !(!AbstractC13042fc3.d(strE, E()))) {
            throw new IllegalArgumentException(("Destination " + iVar + " cannot have the same route as graph " + this).toString());
        }
        if (iA == A()) {
            throw new IllegalArgumentException(("Destination " + iVar + " cannot have the same id as graph " + this).toString());
        }
        i iVar2 = (i) this.l.f(iA);
        if (iVar2 == iVar) {
            return;
        }
        if (iVar.C() != null) {
            throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.".toString());
        }
        if (iVar2 != null) {
            iVar2.R(null);
        }
        iVar.R(this);
        this.l.l(iVar.A(), iVar);
    }

    public final void Y(Collection collection) {
        AbstractC13042fc3.i(collection, "nodes");
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            if (iVar != null) {
                W(iVar);
            }
        }
    }

    public final i Z(int i) {
        return a0(i, true);
    }

    public final i a0(int i, boolean z) {
        i iVar = (i) this.l.f(i);
        if (iVar != null) {
            return iVar;
        }
        if (!z || C() == null) {
            return null;
        }
        j jVarC = C();
        AbstractC13042fc3.f(jVarC);
        return jVarC.Z(i);
    }

    public final i b0(String str) {
        if (str == null || AbstractC20762sZ6.n0(str)) {
            return null;
        }
        return c0(str, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
    public final i c0(String str, boolean z) {
        i next;
        AbstractC13042fc3.i(str, "route");
        i iVar = (i) this.l.f(i.j.a(str).hashCode());
        if (iVar == null) {
            Iterator it = AbstractC9962aq6.c(AbstractC20609sI6.b(this.l)).iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = 0;
                    break;
                }
                next = it.next();
                if (((i) next).N(str) != null) {
                    break;
                }
            }
            iVar = next;
        }
        if (iVar != null) {
            return iVar;
        }
        if (!z || C() == null) {
            return null;
        }
        j jVarC = C();
        AbstractC13042fc3.f(jVarC);
        return jVarC.b0(str);
    }

    public final C19409qI6 d0() {
        return this.l;
    }

    @Override // androidx.navigation.i
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof j)) {
            return false;
        }
        if (super.equals(obj)) {
            j jVar = (j) obj;
            if (this.l.o() == jVar.l.o() && g0() == jVar.g0()) {
                for (i iVar : AbstractC9962aq6.c(AbstractC20609sI6.b(this.l))) {
                    if (!AbstractC13042fc3.d(iVar, jVar.l.f(iVar.A()))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final String f0() {
        if (this.n == null) {
            String strValueOf = this.o;
            if (strValueOf == null) {
                strValueOf = String.valueOf(this.m);
            }
            this.n = strValueOf;
        }
        String str = this.n;
        AbstractC13042fc3.f(str);
        return str;
    }

    public final int g0() {
        return this.m;
    }

    public final String h0() {
        return this.o;
    }

    @Override // androidx.navigation.i
    public int hashCode() {
        int iG0 = g0();
        C19409qI6 c19409qI6 = this.l;
        int iO = c19409qI6.o();
        for (int i = 0; i < iO; i++) {
            iG0 = (((iG0 * 31) + c19409qI6.k(i)) * 31) + ((i) c19409qI6.p(i)).hashCode();
        }
        return iG0;
    }

    public final i.b i0(h hVar) {
        AbstractC13042fc3.i(hVar, "request");
        return super.L(hVar);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new b();
    }

    public final void j0(int i) {
        l0(i);
    }

    public final void k0(String str) {
        AbstractC13042fc3.i(str, "startDestRoute");
        n0(str);
    }

    @Override // androidx.navigation.i
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        i iVarB0 = b0(this.o);
        if (iVarB0 == null) {
            iVarB0 = Z(g0());
        }
        sb.append(" startDestination=");
        if (iVarB0 == null) {
            String str = this.o;
            if (str != null) {
                sb.append(str);
            } else {
                String str2 = this.n;
                if (str2 != null) {
                    sb.append(str2);
                } else {
                    sb.append("0x" + Integer.toHexString(this.m));
                }
            }
        } else {
            sb.append("{");
            sb.append(iVarB0.toString());
            sb.append("}");
        }
        String string = sb.toString();
        AbstractC13042fc3.h(string, "sb.toString()");
        return string;
    }

    @Override // androidx.navigation.i
    public String x() {
        return A() != 0 ? super.x() : "the root navigation";
    }
}
