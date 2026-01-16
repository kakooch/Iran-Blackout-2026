package ir.nasim;

import android.gov.nist.core.Separators;
import androidx.fragment.app.Fragment;

/* renamed from: ir.nasim.gf2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C13689gf2 extends AbstractC21525th3 {
    private final InterfaceC8506Wg3 a;
    private final EnumC22705vh3 b;
    private final int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C13689gf2(InterfaceC8506Wg3 interfaceC8506Wg3) {
        super(null);
        AbstractC13042fc3.i(interfaceC8506Wg3, "jaryanScrollListener");
        this.a = interfaceC8506Wg3;
        this.b = EnumC22705vh3.c;
        this.c = ID5.tab_title_feed;
    }

    @Override // ir.nasim.AbstractC21525th3
    public Fragment a() {
        return C14330hk2.D1.a(this.a);
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
        return (obj instanceof C13689gf2) && AbstractC13042fc3.d(this.a, ((C13689gf2) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "FEED(jaryanScrollListener=" + this.a + Separators.RPAREN;
    }
}
