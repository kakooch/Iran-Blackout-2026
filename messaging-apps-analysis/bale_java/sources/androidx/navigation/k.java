package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.p;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC9766aX0;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J1\u0010\u0014\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00122\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroidx/navigation/k;", "Landroidx/navigation/p;", "Landroidx/navigation/j;", "Landroidx/navigation/q;", "navigatorProvider", "<init>", "(Landroidx/navigation/q;)V", "Landroidx/navigation/d;", "entry", "Landroidx/navigation/m;", "navOptions", "Landroidx/navigation/p$a;", "navigatorExtras", "Lir/nasim/rB7;", "m", "(Landroidx/navigation/d;Landroidx/navigation/m;Landroidx/navigation/p$a;)V", "l", "()Landroidx/navigation/j;", "", "entries", "e", "(Ljava/util/List;Landroidx/navigation/m;Landroidx/navigation/p$a;)V", "c", "Landroidx/navigation/q;", "navigation-common_release"}, k = 1, mv = {1, 8, 0})
@p.b("navigation")
/* loaded from: classes2.dex */
public class k extends p {

    /* renamed from: c, reason: from kotlin metadata */
    private final q navigatorProvider;

    public k(q qVar) {
        AbstractC13042fc3.i(qVar, "navigatorProvider");
        this.navigatorProvider = qVar;
    }

    private final void m(d entry, m navOptions, p.a navigatorExtras) {
        i iVarE = entry.e();
        AbstractC13042fc3.g(iVarE, "null cannot be cast to non-null type androidx.navigation.NavGraph");
        j jVar = (j) iVarE;
        Bundle bundleC = entry.c();
        int iG0 = jVar.g0();
        String strH0 = jVar.h0();
        if (iG0 == 0 && strH0 == null) {
            throw new IllegalStateException(("no start destination defined via app:startDestination for " + jVar.x()).toString());
        }
        i iVarC0 = strH0 != null ? jVar.c0(strH0, false) : jVar.a0(iG0, false);
        if (iVarC0 != null) {
            this.navigatorProvider.e(iVarC0.B()).e(AbstractC9766aX0.e(b().a(iVarC0, iVarC0.o(bundleC))), navOptions, navigatorExtras);
            return;
        }
        throw new IllegalArgumentException("navigation destination " + jVar.f0() + " is not a direct child of this NavGraph");
    }

    @Override // androidx.navigation.p
    public void e(List entries, m navOptions, p.a navigatorExtras) {
        AbstractC13042fc3.i(entries, "entries");
        Iterator it = entries.iterator();
        while (it.hasNext()) {
            m((d) it.next(), navOptions, navigatorExtras);
        }
    }

    @Override // androidx.navigation.p
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public j a() {
        return new j(this);
    }
}
