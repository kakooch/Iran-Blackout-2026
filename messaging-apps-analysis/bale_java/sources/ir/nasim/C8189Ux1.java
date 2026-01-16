package ir.nasim;

import android.gov.nist.core.Separators;
import androidx.fragment.app.Fragment;

/* renamed from: ir.nasim.Ux1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C8189Ux1 extends AbstractC21525th3 {
    private final InterfaceC8506Wg3 a;
    private final EnumC22705vh3 b;
    private final int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8189Ux1(InterfaceC8506Wg3 interfaceC8506Wg3) {
        super(null);
        AbstractC13042fc3.i(interfaceC8506Wg3, "jaryanScrollListener");
        this.a = interfaceC8506Wg3;
        this.b = EnumC22705vh3.b;
        this.c = ID5.tab_title_discover;
    }

    @Override // ir.nasim.AbstractC21525th3
    public Fragment a() {
        return C15375jU1.t1.a(this.a);
    }

    @Override // ir.nasim.AbstractC21525th3
    public int b() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC21525th3
    public EnumC22705vh3 c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C8189Ux1) && AbstractC13042fc3.d(this.a, ((C8189Ux1) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "DISCOVER(jaryanScrollListener=" + this.a + Separators.RPAREN;
    }
}
