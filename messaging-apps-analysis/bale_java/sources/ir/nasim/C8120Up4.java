package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Up4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C8120Up4 extends AbstractC7886Tp4 {
    private final androidx.navigation.q h;
    private int i;
    private String j;
    private final List k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8120Up4(androidx.navigation.q qVar, String str, String str2) {
        super(qVar.d(androidx.navigation.k.class), str2);
        AbstractC13042fc3.i(qVar, "provider");
        AbstractC13042fc3.i(str, "startDestination");
        this.k = new ArrayList();
        this.h = qVar;
        this.j = str;
    }

    public final void c(androidx.navigation.i iVar) {
        AbstractC13042fc3.i(iVar, "destination");
        this.k.add(iVar);
    }

    public androidx.navigation.j d() {
        androidx.navigation.j jVar = (androidx.navigation.j) super.a();
        jVar.Y(this.k);
        int i = this.i;
        if (i == 0 && this.j == null) {
            if (b() != null) {
                throw new IllegalStateException("You must set a start destination route");
            }
            throw new IllegalStateException("You must set a start destination id");
        }
        String str = this.j;
        if (str != null) {
            AbstractC13042fc3.f(str);
            jVar.k0(str);
        } else {
            jVar.j0(i);
        }
        return jVar;
    }

    public final androidx.navigation.q e() {
        return this.h;
    }
}
