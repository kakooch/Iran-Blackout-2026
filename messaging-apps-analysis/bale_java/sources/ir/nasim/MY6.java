package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public final class MY6 implements InterfaceC8121Up5 {
    private final InterfaceC23384wp6 a;

    public MY6() {
        List listM1 = AbstractC15401jX0.m1(new C12266eK0('a', 'z'));
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listM1, 10));
        Iterator it = listM1.iterator();
        while (it.hasNext()) {
            arrayList.add(((Character) it.next()).charValue() + "name and last");
        }
        List listP = AbstractC10360bX0.p("", Separators.SP, "");
        List listM12 = AbstractC15401jX0.m1(new C12266eK0('1', '9'));
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(listM12, 10));
        Iterator it2 = listM12.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((Character) it2.next()).charValue() + "name and last");
        }
        List listM13 = AbstractC15401jX0.m1(new C12266eK0((char) 1575, (char) 1606));
        ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(listM13, 10));
        Iterator it3 = listM13.iterator();
        while (it3.hasNext()) {
            arrayList3.add(((Character) it3.next()).charValue() + "نام");
        }
        List listM14 = AbstractC15401jX0.m1(new C12266eK0((char) 1777, (char) 1785));
        ArrayList arrayList4 = new ArrayList(AbstractC10976cX0.x(listM14, 10));
        Iterator it4 = listM14.iterator();
        while (it4.hasNext()) {
            arrayList4.add(((Character) it4.next()).charValue() + "نام");
        }
        this.a = AbstractC9962aq6.k(arrayList, listP, arrayList2, arrayList3, arrayList4, AbstractC10360bX0.p("!", Separators.AT, Separators.POUND, "$", Separators.SP, Separators.STAR));
    }

    @Override // ir.nasim.InterfaceC8121Up5
    public InterfaceC23384wp6 a() {
        return this.a;
    }
}
