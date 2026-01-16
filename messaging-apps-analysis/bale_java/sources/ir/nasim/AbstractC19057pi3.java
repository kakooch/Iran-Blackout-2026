package ir.nasim;

/* renamed from: ir.nasim.pi3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC19057pi3 {
    private static final boolean a(InterfaceC20257ri3 interfaceC20257ri3) {
        C9424Zw2 c9424Zw2E;
        InterfaceC9065Yi3 interfaceC9065Yi3 = (InterfaceC9065Yi3) AbstractC15401jX0.X0(interfaceC20257ri3.h());
        InterfaceC6138Mi3 type = interfaceC9065Yi3 == null ? null : interfaceC9065Yi3.getType();
        InterfaceC9056Yh3 interfaceC9056Yh3 = type instanceof InterfaceC9056Yh3 ? (InterfaceC9056Yh3) type : null;
        if (interfaceC9056Yh3 == null) {
            return false;
        }
        InterfaceC8781Xh3 interfaceC8781Xh3A = interfaceC9056Yh3.a();
        return (interfaceC8781Xh3A instanceof InterfaceC7106Qh3) && (c9424Zw2E = ((InterfaceC7106Qh3) interfaceC8781Xh3A).e()) != null && AbstractC13042fc3.d(c9424Zw2E.b(), "java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
    
        if (r0.equals("hashCode") == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
    
        if (r0.equals("toString") == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:
    
        return r3.h().isEmpty();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final boolean b(ir.nasim.InterfaceC20257ri3 r3) {
        /*
            ir.nasim.No4 r0 = r3.getName()
            java.lang.String r0 = r0.h()
            int r1 = r0.hashCode()
            r2 = -1776922004(0xffffffff9616526c, float:-1.2142911E-25)
            if (r1 == r2) goto L33
            r2 = -1295482945(0xffffffffb2c87fbf, float:-2.3341157E-8)
            if (r1 == r2) goto L25
            r2 = 147696667(0x8cdac1b, float:1.23784505E-33)
            if (r1 == r2) goto L1c
            goto L3b
        L1c:
            java.lang.String r1 = "hashCode"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L3d
            goto L3b
        L25:
            java.lang.String r1 = "equals"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L2e
            goto L3b
        L2e:
            boolean r3 = a(r3)
            goto L45
        L33:
            java.lang.String r1 = "toString"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L3d
        L3b:
            r3 = 0
            goto L45
        L3d:
            java.util.List r3 = r3.h()
            boolean r3 = r3.isEmpty()
        L45:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC19057pi3.b(ir.nasim.ri3):boolean");
    }

    public static final boolean c(InterfaceC19648qi3 interfaceC19648qi3) {
        AbstractC13042fc3.i(interfaceC19648qi3, "<this>");
        return interfaceC19648qi3.Q().L() && (interfaceC19648qi3 instanceof InterfaceC20257ri3) && b((InterfaceC20257ri3) interfaceC19648qi3);
    }
}
