package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.C9427Zw5;
import java.util.LinkedList;
import java.util.List;

/* renamed from: ir.nasim.Po4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C6926Po4 implements InterfaceC6692Oo4 {
    private final C10030ax5 a;
    private final C9427Zw5 b;

    /* renamed from: ir.nasim.Po4$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[C9427Zw5.c.EnumC0820c.values().length];
            iArr[C9427Zw5.c.EnumC0820c.CLASS.ordinal()] = 1;
            iArr[C9427Zw5.c.EnumC0820c.PACKAGE.ordinal()] = 2;
            iArr[C9427Zw5.c.EnumC0820c.LOCAL.ordinal()] = 3;
            a = iArr;
        }
    }

    public C6926Po4(C10030ax5 c10030ax5, C9427Zw5 c9427Zw5) {
        AbstractC13042fc3.i(c10030ax5, "strings");
        AbstractC13042fc3.i(c9427Zw5, "qualifiedNames");
        this.a = c10030ax5;
        this.b = c9427Zw5;
    }

    private final C17428mw7 c(int i) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z = false;
        while (i != -1) {
            C9427Zw5.c cVarU = this.b.u(i);
            String strU = this.a.u(cVarU.C());
            C9427Zw5.c.EnumC0820c enumC0820cY = cVarU.y();
            AbstractC13042fc3.f(enumC0820cY);
            int i2 = a.a[enumC0820cY.ordinal()];
            if (i2 == 1) {
                linkedList2.addFirst(strU);
            } else if (i2 == 2) {
                linkedList.addFirst(strU);
            } else if (i2 == 3) {
                linkedList2.addFirst(strU);
                z = true;
            }
            i = cVarU.z();
        }
        return new C17428mw7(linkedList, linkedList2, Boolean.valueOf(z));
    }

    @Override // ir.nasim.InterfaceC6692Oo4
    public boolean a(int i) {
        return ((Boolean) c(i).j()).booleanValue();
    }

    @Override // ir.nasim.InterfaceC6692Oo4
    public String b(int i) {
        C17428mw7 c17428mw7C = c(i);
        List list = (List) c17428mw7C.a();
        String strA0 = AbstractC15401jX0.A0((List) c17428mw7C.b(), Separators.DOT, null, null, 0, null, null, 62, null);
        if (list.isEmpty()) {
            return strA0;
        }
        return AbstractC15401jX0.A0(list, Separators.SLASH, null, null, 0, null, null, 62, null) + '/' + strA0;
    }

    @Override // ir.nasim.InterfaceC6692Oo4
    public String getString(int i) {
        String strU = this.a.u(i);
        AbstractC13042fc3.h(strU, "strings.getString(index)");
        return strU;
    }
}
