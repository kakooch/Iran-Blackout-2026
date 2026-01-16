package ir.nasim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: ir.nasim.yG7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C24235yG7 extends AbstractC21707u0 {
    private C9057Yh4 b;

    public C24235yG7(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        this.b = c9057Yh4;
    }

    public boolean A(Collection collection) {
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((Integer) it.next()).intValue()));
        }
        return this.b.E().X1().f(arrayList).size() == collection.size();
    }

    public boolean B(Collection collection) {
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((Integer) it.next()).intValue()));
        }
        return this.b.W().p0().f(arrayList).size() == collection.size();
    }

    public boolean C(AbstractC20556sC7 abstractC20556sC7) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        if (abstractC20556sC7 instanceof CE7) {
            CE7 ce7 = (CE7) abstractC20556sC7;
            hashSet.add(Integer.valueOf(ce7.i()));
            if (ce7.e().s() == W25.b) {
                hashSet2.add(Integer.valueOf(ce7.e().getPeerId()));
            }
            if (ce7.e().s() == W25.a) {
                hashSet.add(Integer.valueOf(ce7.e().getPeerId()));
            }
            if (ce7.g() != null) {
                int iY = ce7.g().y();
                Integer numS = ce7.g().s();
                if (numS.intValue() != 0) {
                    hashSet2.add(numS);
                }
                if (iY != 0) {
                    hashSet.add(Integer.valueOf(iY));
                }
            }
        } else if (abstractC20556sC7 instanceof C12210eD7) {
            hashSet.add(Integer.valueOf(((C12210eD7) abstractC20556sC7).c()));
        } else if (abstractC20556sC7 instanceof C20574sE7) {
            C20574sE7 c20574sE7 = (C20574sE7) abstractC20556sC7;
            hashSet.add(Integer.valueOf(c20574sE7.c()));
            hashSet.add(Integer.valueOf(c20574sE7.e()));
            hashSet2.add(Integer.valueOf(c20574sE7.b()));
        } else if (abstractC20556sC7 instanceof C21851uE7) {
            C21851uE7 c21851uE7 = (C21851uE7) abstractC20556sC7;
            hashSet.add(Integer.valueOf(c21851uE7.c()));
            hashSet.add(Integer.valueOf(c21851uE7.e()));
            hashSet2.add(Integer.valueOf(c21851uE7.b()));
        } else if (abstractC20556sC7 instanceof C23037wE7) {
            C23037wE7 c23037wE7 = (C23037wE7) abstractC20556sC7;
            hashSet.add(Integer.valueOf(c23037wE7.d()));
            hashSet2.add(Integer.valueOf(c23037wE7.b()));
        } else if (abstractC20556sC7 instanceof NF7) {
            hashSet.add(Integer.valueOf(((NF7) abstractC20556sC7).b()));
        } else if (abstractC20556sC7 instanceof WF7) {
            hashSet.add(Integer.valueOf(((WF7) abstractC20556sC7).b()));
        } else if (abstractC20556sC7 instanceof YF7) {
            hashSet.add(Integer.valueOf(((YF7) abstractC20556sC7).b()));
        } else if (abstractC20556sC7 instanceof OF7) {
            hashSet.add(Integer.valueOf(((OF7) abstractC20556sC7).b()));
        } else if (abstractC20556sC7 instanceof C9620aG7) {
            hashSet.add(Integer.valueOf(((C9620aG7) abstractC20556sC7).a()));
        } else if (abstractC20556sC7 instanceof C13437gD7) {
            hashSet.addAll(((C13437gD7) abstractC20556sC7).b());
        } else if (abstractC20556sC7 instanceof C14630iD7) {
            hashSet.addAll(((C14630iD7) abstractC20556sC7).a());
        } else if (abstractC20556sC7 instanceof C17028mG7) {
            hashSet.add(Integer.valueOf(((C17028mG7) abstractC20556sC7).b()));
        } else if (abstractC20556sC7 instanceof C12237eG7) {
            hashSet.add(Integer.valueOf(((C12237eG7) abstractC20556sC7).b()));
        } else if (abstractC20556sC7 instanceof C10803cD7) {
            Iterator it = ((C10803cD7) abstractC20556sC7).a().iterator();
            while (it.hasNext()) {
                for (C3681Bx c3681Bx : ((C25229zx) it.next()).q()) {
                    if (c3681Bx.u().r() == CA.PRIVATE) {
                        hashSet.add(Integer.valueOf(c3681Bx.u().q()));
                    } else if (c3681Bx.u().r() == CA.GROUP) {
                        hashSet2.add(Integer.valueOf(c3681Bx.u().q()));
                    }
                }
            }
        }
        if (B(hashSet)) {
            return !A(hashSet2);
        }
        return true;
    }
}
