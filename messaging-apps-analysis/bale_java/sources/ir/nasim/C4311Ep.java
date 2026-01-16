package ir.nasim;

import ir.nasim.C20603sI0;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: ir.nasim.Ep, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C4311Ep {
    private ArrayList a;
    private ArrayList b;

    /* renamed from: ir.nasim.Ep$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[C20603sI0.a.values().length];
            a = iArr;
            try {
                iArr[C20603sI0.a.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[C20603sI0.a.UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[C20603sI0.a.MOVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[C20603sI0.a.REMOVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public C4311Ep(ArrayList arrayList, ArrayList arrayList2) {
        this.a = new ArrayList(arrayList);
        this.b = new ArrayList(arrayList2);
    }

    public Object a(int i) {
        return this.a.get(i);
    }

    public int b() {
        return this.a.size();
    }

    public C20603sI0 c() {
        if (this.b.size() == 0) {
            return null;
        }
        C20603sI0 c20603sI0 = (C20603sI0) this.b.remove(0);
        int i = a.a[c20603sI0.g().ordinal()];
        if (i == 1) {
            int iD = c20603sI0.d();
            Iterator it = c20603sI0.e().iterator();
            while (it.hasNext()) {
                this.a.add(iD, it.next());
                iD++;
            }
        } else if (i == 2) {
            int iD2 = c20603sI0.d();
            Iterator it2 = c20603sI0.e().iterator();
            while (it2.hasNext()) {
                Object next = it2.next();
                this.a.remove(iD2);
                this.a.add(iD2, next);
                iD2++;
            }
        } else if (i == 3) {
            this.a.add(c20603sI0.c(), this.a.remove(c20603sI0.d()));
        } else if (i == 4) {
            int iD3 = c20603sI0.d();
            for (int i2 = 0; i2 < c20603sI0.f(); i2++) {
                this.a.remove(iD3);
            }
        }
        return c20603sI0;
    }
}
