package ir.nasim;

import ir.nasim.AbstractC11684dQ7;
import ir.nasim.EX4;
import java.util.ArrayList;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Ik2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C5220Ik2 {
    private final AbstractC11684dQ7 c(EX4.a aVar) {
        Long lE = aVar.e();
        if (lE != null) {
            long jLongValue = lE.longValue();
            Long lD = aVar.d();
            Long lC = aVar.c();
            if (lD != null && jLongValue < lD.longValue()) {
                return new AbstractC11684dQ7.b.e(lD.longValue());
            }
            if (lC != null && jLongValue > lC.longValue()) {
                return new AbstractC11684dQ7.b.C1008b(lC.longValue());
            }
        }
        return null;
    }

    private final AbstractC11684dQ7 d(EX4.b bVar) {
        Integer numE = bVar.e();
        if (numE != null) {
            int iIntValue = numE.intValue();
            Integer numD = bVar.d();
            Integer numC = bVar.c();
            if (numD != null && iIntValue < numD.intValue()) {
                return new AbstractC11684dQ7.b.g(numD.intValue());
            }
            if (numC != null && iIntValue > numC.intValue()) {
                return new AbstractC11684dQ7.b.d(numC.intValue());
            }
        }
        return null;
    }

    private final AbstractC11684dQ7 e(EX4.c cVar) {
        String strH = cVar.h();
        if (strH == null) {
            return null;
        }
        Integer numG = cVar.g();
        Integer numF = cVar.f();
        C20644sM5 c20644sM5D = cVar.d();
        if (AbstractC20762sZ6.n0(strH)) {
            return null;
        }
        if (numG != null && strH.length() < numG.intValue()) {
            return new AbstractC11684dQ7.b.f(numG.intValue());
        }
        if (numF != null && strH.length() > numF.intValue()) {
            return new AbstractC11684dQ7.b.c(numF.intValue());
        }
        if (c20644sM5D != null && !c20644sM5D.g(strH)) {
            return AbstractC11684dQ7.b.a.b;
        }
        if (cVar.c() != EnumC15099j05.a || a(strH)) {
            return null;
        }
        return AbstractC11684dQ7.b.a.b;
    }

    public final boolean a(String str) {
        AbstractC13042fc3.i(str, "code");
        if (str.length() != 10) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        ArrayList arrayList = new ArrayList(str.length());
        for (int i2 = 0; i2 < str.length(); i2++) {
            arrayList.add(Integer.valueOf(Integer.parseInt(String.valueOf(str.charAt(i2)))));
        }
        int iIntValue = ((Number) AbstractC15401jX0.C0(arrayList)).intValue();
        int iIntValue2 = 0;
        for (int i3 = 0; i3 < 9; i3++) {
            iIntValue2 += ((Number) arrayList.get(i3)).intValue() * (10 - i3);
        }
        int i4 = iIntValue2 % 11;
        if (i4 < 2) {
            if (iIntValue != i4) {
                return false;
            }
        } else if (iIntValue != 11 - i4) {
            return false;
        }
        return true;
    }

    public final AbstractC11684dQ7 b(EX4 ex4) {
        AbstractC13042fc3.i(ex4, "fieldType");
        if (ex4 instanceof EX4.c) {
            return e((EX4.c) ex4);
        }
        if (ex4 instanceof EX4.b) {
            return d((EX4.b) ex4);
        }
        if (ex4 instanceof EX4.a) {
            return c((EX4.a) ex4);
        }
        if (ex4 instanceof EX4.d) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }
}
