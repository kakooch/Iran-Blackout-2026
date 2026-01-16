package ir.nasim;

import java.util.Iterator;
import java.util.Set;

/* renamed from: ir.nasim.nG1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C17613nG1 implements InterfaceC19410qI7 {
    private final String a;
    private final C14077hJ2 b;

    C17613nG1(Set set, C14077hJ2 c14077hJ2) {
        this.a = d(set);
        this.b = c14077hJ2;
    }

    public static I01 b() {
        return I01.c(InterfaceC19410qI7.class).b(C10226bI1.k(AbstractC9443Zy3.class)).f(new Y01() { // from class: ir.nasim.mG1
            @Override // ir.nasim.Y01
            public final Object a(S01 s01) {
                return C17613nG1.c(s01);
            }
        }).d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ InterfaceC19410qI7 c(S01 s01) {
        return new C17613nG1(s01.c(AbstractC9443Zy3.class), C14077hJ2.a());
    }

    private static String d(Set set) {
        StringBuilder sb = new StringBuilder();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            AbstractC9443Zy3 abstractC9443Zy3 = (AbstractC9443Zy3) it.next();
            sb.append(abstractC9443Zy3.b());
            sb.append('/');
            sb.append(abstractC9443Zy3.c());
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    @Override // ir.nasim.InterfaceC19410qI7
    public String getUserAgent() {
        if (this.b.b().isEmpty()) {
            return this.a;
        }
        return this.a + ' ' + d(this.b.b());
    }
}
