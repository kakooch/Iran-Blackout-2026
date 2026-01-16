package androidx.navigation;

import android.os.Bundle;
import ir.nasim.AbstractC11342cq6;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC19138pq4;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9363Zp4;
import ir.nasim.C19938rB7;
import ir.nasim.UA2;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes2.dex */
public abstract class p {
    private AbstractC19138pq4 a;
    private boolean b;

    public interface a {
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface b {
        String value();
    }

    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ m f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(m mVar, a aVar) {
            super(1);
            this.f = mVar;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final androidx.navigation.d invoke(androidx.navigation.d dVar) {
            i iVarD;
            AbstractC13042fc3.i(dVar, "backStackEntry");
            i iVarE = dVar.e();
            if (!(iVarE instanceof i)) {
                iVarE = null;
            }
            if (iVarE != null && (iVarD = p.this.d(iVarE, dVar.c(), this.f, null)) != null) {
                return AbstractC13042fc3.d(iVarD, iVarE) ? dVar : p.this.b().a(iVarD, iVarD.o(dVar.c()));
            }
            return null;
        }
    }

    static final class d extends AbstractC8614Ws3 implements UA2 {
        public static final d e = new d();

        d() {
            super(1);
        }

        public final void a(n nVar) {
            AbstractC13042fc3.i(nVar, "$this$navOptions");
            nVar.f(true);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((n) obj);
            return C19938rB7.a;
        }
    }

    public abstract i a();

    protected final AbstractC19138pq4 b() {
        AbstractC19138pq4 abstractC19138pq4 = this.a;
        if (abstractC19138pq4 != null) {
            return abstractC19138pq4;
        }
        throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached".toString());
    }

    public final boolean c() {
        return this.b;
    }

    public i d(i iVar, Bundle bundle, m mVar, a aVar) {
        AbstractC13042fc3.i(iVar, "destination");
        return iVar;
    }

    public void e(List list, m mVar, a aVar) {
        AbstractC13042fc3.i(list, "entries");
        Iterator it = AbstractC11342cq6.t(AbstractC11342cq6.C(AbstractC15401jX0.g0(list), new c(mVar, aVar))).iterator();
        while (it.hasNext()) {
            b().i((androidx.navigation.d) it.next());
        }
    }

    public void f(AbstractC19138pq4 abstractC19138pq4) {
        AbstractC13042fc3.i(abstractC19138pq4, "state");
        this.a = abstractC19138pq4;
        this.b = true;
    }

    public void g(androidx.navigation.d dVar) {
        AbstractC13042fc3.i(dVar, "backStackEntry");
        i iVarE = dVar.e();
        if (!(iVarE instanceof i)) {
            iVarE = null;
        }
        if (iVarE == null) {
            return;
        }
        d(iVarE, null, AbstractC9363Zp4.a(d.e), null);
        b().f(dVar);
    }

    public void h(Bundle bundle) {
        AbstractC13042fc3.i(bundle, "savedState");
    }

    public Bundle i() {
        return null;
    }

    public void j(androidx.navigation.d dVar, boolean z) {
        AbstractC13042fc3.i(dVar, "popUpTo");
        List list = (List) b().b().getValue();
        if (!list.contains(dVar)) {
            throw new IllegalStateException(("popBackStack was called with " + dVar + " which does not exist in back stack " + list).toString());
        }
        ListIterator listIterator = list.listIterator(list.size());
        androidx.navigation.d dVar2 = null;
        while (k()) {
            dVar2 = (androidx.navigation.d) listIterator.previous();
            if (AbstractC13042fc3.d(dVar2, dVar)) {
                break;
            }
        }
        if (dVar2 != null) {
            b().g(dVar2, z);
        }
    }

    public boolean k() {
        return true;
    }
}
