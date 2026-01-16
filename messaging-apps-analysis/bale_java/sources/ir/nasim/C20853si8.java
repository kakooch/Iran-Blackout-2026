package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.si8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C20853si8 extends Vh8 implements InterfaceC14926ii8 {
    protected final List c;
    protected final List d;
    protected C20322ro8 e;

    private C20853si8(C20853si8 c20853si8) {
        super(c20853si8.a);
        ArrayList arrayList = new ArrayList(c20853si8.c.size());
        this.c = arrayList;
        arrayList.addAll(c20853si8.c);
        ArrayList arrayList2 = new ArrayList(c20853si8.d.size());
        this.d = arrayList2;
        arrayList2.addAll(c20853si8.d);
        this.e = c20853si8.e;
    }

    @Override // ir.nasim.Vh8
    public final InterfaceC22720vi8 a(C20322ro8 c20322ro8, List list) {
        C20322ro8 c20322ro8A = this.e.a();
        for (int i = 0; i < this.c.size(); i++) {
            if (i < list.size()) {
                c20322ro8A.e((String) this.c.get(i), c20322ro8.b((InterfaceC22720vi8) list.get(i)));
            } else {
                c20322ro8A.e((String) this.c.get(i), InterfaceC22720vi8.r0);
            }
        }
        for (InterfaceC22720vi8 interfaceC22720vi8 : this.d) {
            InterfaceC22720vi8 interfaceC22720vi8B = c20322ro8A.b(interfaceC22720vi8);
            if (interfaceC22720vi8B instanceof C23906xi8) {
                interfaceC22720vi8B = c20322ro8A.b(interfaceC22720vi8);
            }
            if (interfaceC22720vi8B instanceof Lh8) {
                return ((Lh8) interfaceC22720vi8B).a();
            }
        }
        return InterfaceC22720vi8.r0;
    }

    @Override // ir.nasim.Vh8, ir.nasim.InterfaceC22720vi8
    public final InterfaceC22720vi8 d() {
        return new C20853si8(this);
    }

    public C20853si8(String str, List list, List list2, C20322ro8 c20322ro8) {
        super(str);
        this.c = new ArrayList();
        this.e = c20322ro8;
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.c.add(((InterfaceC22720vi8) it.next()).j());
            }
        }
        this.d = new ArrayList(list2);
    }
}
