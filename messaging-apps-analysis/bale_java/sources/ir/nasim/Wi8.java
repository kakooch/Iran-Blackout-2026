package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class Wi8 extends Ni8 {
    protected Wi8() {
        this.a.add(EnumC9901ak8.APPLY);
        this.a.add(EnumC9901ak8.BLOCK);
        this.a.add(EnumC9901ak8.BREAK);
        this.a.add(EnumC9901ak8.CASE);
        this.a.add(EnumC9901ak8.DEFAULT);
        this.a.add(EnumC9901ak8.CONTINUE);
        this.a.add(EnumC9901ak8.DEFINE_FUNCTION);
        this.a.add(EnumC9901ak8.FN);
        this.a.add(EnumC9901ak8.IF);
        this.a.add(EnumC9901ak8.QUOTE);
        this.a.add(EnumC9901ak8.RETURN);
        this.a.add(EnumC9901ak8.SWITCH);
        this.a.add(EnumC9901ak8.TERNARY);
    }

    private static InterfaceC22720vi8 c(C20322ro8 c20322ro8, List list) {
        AbstractC9951ap8.i(EnumC9901ak8.FN.name(), 2, list);
        InterfaceC22720vi8 interfaceC22720vi8B = c20322ro8.b((InterfaceC22720vi8) list.get(0));
        InterfaceC22720vi8 interfaceC22720vi8B2 = c20322ro8.b((InterfaceC22720vi8) list.get(1));
        if (!(interfaceC22720vi8B2 instanceof Ch8)) {
            throw new IllegalArgumentException(String.format("FN requires an ArrayValue of parameter names found %s", interfaceC22720vi8B2.getClass().getCanonicalName()));
        }
        List listC = ((Ch8) interfaceC22720vi8B2).C();
        List arrayList = new ArrayList();
        if (list.size() > 2) {
            arrayList = list.subList(2, list.size());
        }
        return new C20853si8(interfaceC22720vi8B.j(), listC, arrayList, c20322ro8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0128, code lost:
    
        if (r8.equals("continue") == false) goto L64;
     */
    @Override // ir.nasim.Ni8
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final ir.nasim.InterfaceC22720vi8 a(java.lang.String r8, ir.nasim.C20322ro8 r9, java.util.List r10) {
        /*
            Method dump skipped, instructions count: 634
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.Wi8.a(java.lang.String, ir.nasim.ro8, java.util.List):ir.nasim.vi8");
    }
}
