package ir.nasim;

import androidx.recyclerview.widget.i;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: ir.nasim.Ce5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC3750Ce5 {

    /* renamed from: ir.nasim.Ce5$a */
    public static final class a extends i.b {
        final /* synthetic */ InterfaceC3516Be5 a;
        final /* synthetic */ InterfaceC3516Be5 b;
        final /* synthetic */ i.f c;
        final /* synthetic */ int d;
        final /* synthetic */ int e;

        a(InterfaceC3516Be5 interfaceC3516Be5, InterfaceC3516Be5 interfaceC3516Be52, i.f fVar, int i, int i2) {
            this.a = interfaceC3516Be5;
            this.b = interfaceC3516Be52;
            this.c = fVar;
            this.d = i;
            this.e = i2;
        }

        @Override // androidx.recyclerview.widget.i.b
        public boolean a(int i, int i2) {
            Object item = this.a.getItem(i);
            Object item2 = this.b.getItem(i2);
            if (item == item2) {
                return true;
            }
            return this.c.a(item, item2);
        }

        @Override // androidx.recyclerview.widget.i.b
        public boolean b(int i, int i2) {
            Object item = this.a.getItem(i);
            Object item2 = this.b.getItem(i2);
            if (item == item2) {
                return true;
            }
            return this.c.b(item, item2);
        }

        @Override // androidx.recyclerview.widget.i.b
        public Object c(int i, int i2) {
            Object item = this.a.getItem(i);
            Object item2 = this.b.getItem(i2);
            return item == item2 ? Boolean.TRUE : this.c.c(item, item2);
        }

        @Override // androidx.recyclerview.widget.i.b
        public int d() {
            return this.e;
        }

        @Override // androidx.recyclerview.widget.i.b
        public int e() {
            return this.d;
        }
    }

    public static final C3277Ae5 a(InterfaceC3516Be5 interfaceC3516Be5, InterfaceC3516Be5 interfaceC3516Be52, i.f fVar) {
        AbstractC13042fc3.i(interfaceC3516Be5, "<this>");
        AbstractC13042fc3.i(interfaceC3516Be52, "newList");
        AbstractC13042fc3.i(fVar, "diffCallback");
        a aVar = new a(interfaceC3516Be5, interfaceC3516Be52, fVar, interfaceC3516Be5.a(), interfaceC3516Be52.a());
        boolean z = true;
        i.e eVarC = androidx.recyclerview.widget.i.c(aVar, true);
        AbstractC13042fc3.h(eVarC, "PlaceholderPaddedList<T>…    },\n        true\n    )");
        Iterable iterableY = AbstractC23053wG5.y(0, interfaceC3516Be5.a());
        if ((iterableY instanceof Collection) && ((Collection) iterableY).isEmpty()) {
            z = false;
        } else {
            Iterator it = iterableY.iterator();
            while (it.hasNext()) {
                if (eVarC.b(((AbstractC18386oa3) it).b()) != -1) {
                    break;
                }
            }
            z = false;
        }
        return new C3277Ae5(eVarC, z);
    }

    public static final void b(InterfaceC3516Be5 interfaceC3516Be5, InterfaceC12197eC3 interfaceC12197eC3, InterfaceC3516Be5 interfaceC3516Be52, C3277Ae5 c3277Ae5) {
        AbstractC13042fc3.i(interfaceC3516Be5, "<this>");
        AbstractC13042fc3.i(interfaceC12197eC3, "callback");
        AbstractC13042fc3.i(interfaceC3516Be52, "newList");
        AbstractC13042fc3.i(c3277Ae5, "diffResult");
        if (c3277Ae5.b()) {
            ON4.a.a(interfaceC3516Be5, interfaceC3516Be52, interfaceC12197eC3, c3277Ae5);
        } else {
            WV1.a.b(interfaceC12197eC3, interfaceC3516Be5, interfaceC3516Be52);
        }
    }

    public static final int c(InterfaceC3516Be5 interfaceC3516Be5, C3277Ae5 c3277Ae5, InterfaceC3516Be5 interfaceC3516Be52, int i) {
        int iB;
        AbstractC13042fc3.i(interfaceC3516Be5, "<this>");
        AbstractC13042fc3.i(c3277Ae5, "diffResult");
        AbstractC13042fc3.i(interfaceC3516Be52, "newList");
        if (!c3277Ae5.b()) {
            return AbstractC23053wG5.n(i, AbstractC23053wG5.y(0, interfaceC3516Be52.f()));
        }
        int iB2 = i - interfaceC3516Be5.b();
        int iA = interfaceC3516Be5.a();
        if (iB2 >= 0 && iB2 < iA) {
            for (int i2 = 0; i2 < 30; i2++) {
                int i3 = ((i2 / 2) * (i2 % 2 == 1 ? -1 : 1)) + iB2;
                if (i3 >= 0 && i3 < interfaceC3516Be5.a() && (iB = c3277Ae5.a().b(i3)) != -1) {
                    return iB + interfaceC3516Be52.b();
                }
            }
        }
        return AbstractC23053wG5.n(i, AbstractC23053wG5.y(0, interfaceC3516Be52.f()));
    }
}
