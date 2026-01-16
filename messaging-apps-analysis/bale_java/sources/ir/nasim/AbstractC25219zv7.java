package ir.nasim;

import java.util.Set;

/* renamed from: ir.nasim.zv7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC25219zv7 {
    public static final C24625yv7 a(C21669tv7 c21669tv7) {
        Set setC;
        Object objH = c21669tv7.h();
        if (objH == null) {
            return null;
        }
        Object[] enumConstants = objH.getClass().getEnumConstants();
        if (enumConstants == null || (setC = AbstractC10242bK.s1(enumConstants)) == null) {
            setC = AbstractC4363Eu6.c(objH);
        }
        String strJ = c21669tv7.j();
        if (strJ == null) {
            strJ = AbstractC10882cM5.b(objH.getClass()).p();
        }
        return new C24625yv7(c21669tv7, setC, strJ);
    }
}
