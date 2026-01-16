package ir.nasim;

import ir.nasim.C16651le1;
import java.util.ArrayList;

/* renamed from: ir.nasim.qO2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC19459qO2 {
    public static C14590i98 a(C16651le1 c16651le1, int i, ArrayList arrayList, C14590i98 c14590i98) {
        int iR1;
        int i2 = i == 0 ? c16651le1.S0 : c16651le1.T0;
        if (i2 != -1 && (c14590i98 == null || i2 != c14590i98.b)) {
            int i3 = 0;
            while (true) {
                if (i3 >= arrayList.size()) {
                    break;
                }
                C14590i98 c14590i982 = (C14590i98) arrayList.get(i3);
                if (c14590i982.c() == i2) {
                    if (c14590i98 != null) {
                        c14590i98.g(i, c14590i982);
                        arrayList.remove(c14590i98);
                    }
                    c14590i98 = c14590i982;
                } else {
                    i3++;
                }
            }
        } else if (i2 != -1) {
            return c14590i98;
        }
        if (c14590i98 == null) {
            if ((c16651le1 instanceof C18931pV2) && (iR1 = ((C18931pV2) c16651le1).r1(i)) != -1) {
                int i4 = 0;
                while (true) {
                    if (i4 >= arrayList.size()) {
                        break;
                    }
                    C14590i98 c14590i983 = (C14590i98) arrayList.get(i4);
                    if (c14590i983.c() == iR1) {
                        c14590i98 = c14590i983;
                        break;
                    }
                    i4++;
                }
            }
            if (c14590i98 == null) {
                c14590i98 = new C14590i98(i);
            }
            arrayList.add(c14590i98);
        }
        if (c14590i98.a(c16651le1)) {
            if (c16651le1 instanceof NS2) {
                NS2 ns2 = (NS2) c16651le1;
                ns2.q1().c(ns2.r1() == 0 ? 1 : 0, arrayList, c14590i98);
            }
            if (i == 0) {
                c16651le1.S0 = c14590i98.c();
                c16651le1.Q.c(i, arrayList, c14590i98);
                c16651le1.S.c(i, arrayList, c14590i98);
            } else {
                c16651le1.T0 = c14590i98.c();
                c16651le1.R.c(i, arrayList, c14590i98);
                c16651le1.U.c(i, arrayList, c14590i98);
                c16651le1.T.c(i, arrayList, c14590i98);
            }
            c16651le1.X.c(i, arrayList, c14590i98);
        }
        return c14590i98;
    }

    private static C14590i98 b(ArrayList arrayList, int i) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            C14590i98 c14590i98 = (C14590i98) arrayList.get(i2);
            if (i == c14590i98.b) {
                return c14590i98;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:176:0x0348  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean c(ir.nasim.C17242me1 r16, ir.nasim.C20795sd0.b r17) {
        /*
            Method dump skipped, instructions count: 921
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC19459qO2.c(ir.nasim.me1, ir.nasim.sd0$b):boolean");
    }

    public static boolean d(C16651le1.b bVar, C16651le1.b bVar2, C16651le1.b bVar3, C16651le1.b bVar4) {
        C16651le1.b bVar5;
        C16651le1.b bVar6;
        C16651le1.b bVar7 = C16651le1.b.FIXED;
        return (bVar3 == bVar7 || bVar3 == (bVar6 = C16651le1.b.WRAP_CONTENT) || (bVar3 == C16651le1.b.MATCH_PARENT && bVar != bVar6)) || (bVar4 == bVar7 || bVar4 == (bVar5 = C16651le1.b.WRAP_CONTENT) || (bVar4 == C16651le1.b.MATCH_PARENT && bVar2 != bVar5));
    }
}
