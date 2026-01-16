package ir.nasim;

import androidx.navigation.p;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0006\b\u0007\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002#$B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\b\u0010\tJ1\u0010\u0010\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u001a\u0010\tR \u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\u001b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR \u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001f0\u001b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001d¨\u0006%"}, d2 = {"Lir/nasim/YO1;", "Landroidx/navigation/p;", "Lir/nasim/YO1$b;", "<init>", "()V", "Landroidx/navigation/d;", "backStackEntry", "Lir/nasim/rB7;", "m", "(Landroidx/navigation/d;)V", "", "entries", "Landroidx/navigation/m;", "navOptions", "Landroidx/navigation/p$a;", "navigatorExtras", "e", "(Ljava/util/List;Landroidx/navigation/m;Landroidx/navigation/p$a;)V", "l", "()Lir/nasim/YO1$b;", "popUpTo", "", "savedState", "j", "(Landroidx/navigation/d;Z)V", "entry", "p", "Lir/nasim/bL6;", "n", "()Lir/nasim/bL6;", "backStack", "", "o", "transitionInProgress", "c", "a", "b", "navigation-compose_release"}, k = 1, mv = {1, 8, 0})
@p.b("dialog")
/* loaded from: classes2.dex */
public final class YO1 extends androidx.navigation.p {
    @Override // androidx.navigation.p
    public void e(List entries, androidx.navigation.m navOptions, p.a navigatorExtras) {
        Iterator it = entries.iterator();
        while (it.hasNext()) {
            b().i((androidx.navigation.d) it.next());
        }
    }

    @Override // androidx.navigation.p
    public void j(androidx.navigation.d popUpTo, boolean savedState) {
        b().h(popUpTo, savedState);
        int iU0 = AbstractC15401jX0.u0((Iterable) b().c().getValue(), popUpTo);
        int i = 0;
        for (Object obj : (Iterable) b().c().getValue()) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            androidx.navigation.d dVar = (androidx.navigation.d) obj;
            if (i > iU0) {
                p(dVar);
            }
            i = i2;
        }
    }

    @Override // androidx.navigation.p
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public b a() {
        return new b(this, null, C17509n51.a.a(), 2, null);
    }

    public final void m(androidx.navigation.d backStackEntry) {
        j(backStackEntry, false);
    }

    public final InterfaceC10258bL6 n() {
        return b().b();
    }

    public final InterfaceC10258bL6 o() {
        return b().c();
    }

    public final void p(androidx.navigation.d entry) {
        b().e(entry);
    }

    public static final class b extends androidx.navigation.i implements InterfaceC3621Bq2 {
        private final C18876pP1 l;
        private final InterfaceC15796kB2 m;

        public /* synthetic */ b(YO1 yo1, C18876pP1 c18876pP1, InterfaceC15796kB2 interfaceC15796kB2, int i, ED1 ed1) {
            this(yo1, (i & 2) != 0 ? new C18876pP1(false, false, (EnumC20851si6) null, 7, (ED1) null) : c18876pP1, interfaceC15796kB2);
        }

        public final InterfaceC15796kB2 W() {
            return this.m;
        }

        public final C18876pP1 Y() {
            return this.l;
        }

        public b(YO1 yo1, C18876pP1 c18876pP1, InterfaceC15796kB2 interfaceC15796kB2) {
            super(yo1);
            this.l = c18876pP1;
            this.m = interfaceC15796kB2;
        }
    }
}
