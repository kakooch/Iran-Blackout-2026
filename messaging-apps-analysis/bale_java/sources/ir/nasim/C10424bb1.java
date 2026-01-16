package ir.nasim;

import androidx.navigation.p;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002$%B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J1\u0010\r\u001a\u00020\f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0018R \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120\u00198\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006&"}, d2 = {"Lir/nasim/bb1;", "Landroidx/navigation/p;", "Lir/nasim/bb1$b;", "<init>", "()V", "", "Landroidx/navigation/d;", "entries", "Landroidx/navigation/m;", "navOptions", "Landroidx/navigation/p$a;", "navigatorExtras", "Lir/nasim/rB7;", "e", "(Ljava/util/List;Landroidx/navigation/m;Landroidx/navigation/p$a;)V", "l", "()Lir/nasim/bb1$b;", "popUpTo", "", "savedState", "j", "(Landroidx/navigation/d;Z)V", "entry", "o", "(Landroidx/navigation/d;)V", "Lir/nasim/Ym4;", "c", "Lir/nasim/Ym4;", "n", "()Lir/nasim/Ym4;", "isPop", "Lir/nasim/bL6;", "m", "()Lir/nasim/bL6;", "backStack", "d", "a", "b", "navigation-compose_release"}, k = 1, mv = {1, 8, 0})
@p.b("composable")
/* renamed from: ir.nasim.bb1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C10424bb1 extends androidx.navigation.p {

    /* renamed from: c, reason: from kotlin metadata */
    private final InterfaceC9102Ym4 isPop = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);

    /* renamed from: ir.nasim.bb1$b */
    public static final class b extends androidx.navigation.i {
        private final InterfaceC16978mB2 l;
        private UA2 m;
        private UA2 n;
        private UA2 o;
        private UA2 p;

        public b(C10424bb1 c10424bb1, InterfaceC16978mB2 interfaceC16978mB2) {
            super(c10424bb1);
            this.l = interfaceC16978mB2;
        }

        public final InterfaceC16978mB2 W() {
            return this.l;
        }

        public final UA2 Y() {
            return this.m;
        }

        public final UA2 Z() {
            return this.n;
        }

        public final UA2 a0() {
            return this.o;
        }

        public final UA2 b0() {
            return this.p;
        }

        public final void c0(UA2 ua2) {
            this.m = ua2;
        }

        public final void d0(UA2 ua2) {
            this.n = ua2;
        }

        public final void f0(UA2 ua2) {
            this.o = ua2;
        }

        public final void g0(UA2 ua2) {
            this.p = ua2;
        }
    }

    @Override // androidx.navigation.p
    public void e(List entries, androidx.navigation.m navOptions, p.a navigatorExtras) {
        Iterator it = entries.iterator();
        while (it.hasNext()) {
            b().j((androidx.navigation.d) it.next());
        }
        this.isPop.setValue(Boolean.FALSE);
    }

    @Override // androidx.navigation.p
    public void j(androidx.navigation.d popUpTo, boolean savedState) {
        b().h(popUpTo, savedState);
        this.isPop.setValue(Boolean.TRUE);
    }

    @Override // androidx.navigation.p
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public b a() {
        return new b(this, C19262q31.a.a());
    }

    public final InterfaceC10258bL6 m() {
        return b().b();
    }

    /* renamed from: n, reason: from getter */
    public final InterfaceC9102Ym4 getIsPop() {
        return this.isPop;
    }

    public final void o(androidx.navigation.d entry) {
        b().e(entry);
    }
}
