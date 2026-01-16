package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.xE6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC23626xE6 {
    private static final C25005za3 a = new C25005za3(0, 0, 0, 0);
    private static final C20644sM5 b = new C20644sM5("(\\d+)|([,])|([*])|([:])|L|(P\\([^)]*\\))|(C(\\(([^)]*)\\))?)|@");
    private static final C20644sM5 c = new C20644sM5("(\\d+)|,|[!P()]|:([^,!)]+)");

    /* renamed from: ir.nasim.xE6$a */
    public static final class a implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC18050o01.d(((Field) obj).getName(), ((Field) obj2).getName());
        }
    }

    private static final String A(String str, String str2, String str3) {
        if (!AbstractC20153rZ6.S(str, str2, false, 2, null)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        String strSubstring = str.substring(str2.length());
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        sb.append(strSubstring);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final ir.nasim.MH6 B(java.lang.String r14, ir.nasim.MH6 r15) throws ir.nasim.GW4 {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC23626xE6.B(java.lang.String, ir.nasim.MH6):ir.nasim.MH6");
    }

    private static final OU3 C(C12889fL5 c12889fL5) {
        OU3 ou3 = (OU3) c12889fL5.a;
        if (ou3 != null) {
            c12889fL5.a = ou3.next();
        }
        return (OU3) c12889fL5.a;
    }

    private static final VH6 D(C12889fL5 c12889fL5) {
        Integer numValueOf;
        Integer numValueOf2;
        Integer numValueOf3;
        try {
            OU3 ou3C = (OU3) c12889fL5.a;
            if (ou3C == null || !n(ou3C)) {
                numValueOf = null;
            } else {
                numValueOf = Integer.valueOf(p(ou3C) + 1);
                ou3C = C(c12889fL5);
            }
            if (ou3C != null && k(ou3C, Separators.AT)) {
                OU3 ou3C2 = C(c12889fL5);
                if (ou3C2 != null && n(ou3C2)) {
                    numValueOf3 = Integer.valueOf(p(ou3C2));
                    OU3 ou3C3 = C(c12889fL5);
                    if (ou3C3 != null && k(ou3C3, TokenNames.L)) {
                        OU3 ou3C4 = C(c12889fL5);
                        if (ou3C4 != null && n(ou3C4)) {
                            numValueOf2 = Integer.valueOf(p(ou3C4));
                        }
                        return null;
                    }
                    numValueOf2 = null;
                }
                return null;
            }
            numValueOf2 = null;
            numValueOf3 = null;
            if (numValueOf != null && numValueOf3 != null && numValueOf2 != null) {
                return new VH6(numValueOf, numValueOf3, numValueOf2);
            }
        } catch (GW4 unused) {
        }
        return null;
    }

    public static final C25005za3 E(C25005za3 c25005za3, C25005za3 c25005za32) {
        C25005za3 c25005za33 = a;
        if (AbstractC13042fc3.d(c25005za3, c25005za33)) {
            return c25005za32;
        }
        if (AbstractC13042fc3.d(c25005za32, c25005za33)) {
            return c25005za3;
        }
        return new C25005za3(Math.min(c25005za3.g(), c25005za32.g()), Math.min(c25005za3.j(), c25005za32.j()), Math.max(c25005za3.h(), c25005za32.h()), Math.max(c25005za3.d(), c25005za32.d()));
    }

    private static final Field a(Class cls, String str) throws SecurityException {
        Field field;
        Field[] declaredFields = cls.getDeclaredFields();
        int length = declaredFields.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                field = null;
                break;
            }
            field = declaredFields[i];
            if (AbstractC13042fc3.d(field.getName(), str)) {
                break;
            }
            i++;
        }
        if (field == null) {
            return null;
        }
        field.setAccessible(true);
        return field;
    }

    public static final AbstractC15886kL2 b(InterfaceC7518Sb1 interfaceC7518Sb1) {
        AbstractC15886kL2 abstractC15886kL2G;
        InterfaceC7991Ub1 interfaceC7991Ub1 = (InterfaceC7991Ub1) AbstractC15401jX0.r0(interfaceC7518Sb1.f());
        return (interfaceC7991Ub1 == null || (abstractC15886kL2G = g(interfaceC7991Ub1, null)) == null) ? C21106t72.i : abstractC15886kL2G;
    }

    private static final C25005za3 c(InterfaceC16813lu3 interfaceC16813lu3) {
        InterfaceC11379cu3 interfaceC11379cu3S = interfaceC16813lu3.s();
        if (!interfaceC16813lu3.b() || !interfaceC11379cu3S.b()) {
            return new C25005za3(0, 0, interfaceC16813lu3.getWidth(), interfaceC16813lu3.getHeight());
        }
        long jF = AbstractC12000du3.f(interfaceC11379cu3S);
        long jA = interfaceC11379cu3S.a();
        int iD = AbstractC20723sV3.d(Float.intBitsToFloat((int) (jF >> 32)));
        int iD2 = AbstractC20723sV3.d(Float.intBitsToFloat((int) (jF & 4294967295L)));
        return new C25005za3(iD, iD2, ((int) (jA >> 32)) + iD, ((int) (jA & 4294967295L)) + iD2);
    }

    private static final String d(OU3 ou3) {
        return (String) ou3.b().get(8);
    }

    private static final List e(List list, MH6 mh6) {
        int i;
        Object next;
        Object obj;
        int iIntValue;
        int iIntValue2;
        List listM;
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (true) {
                i = 2;
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next != null && AbstractC20153rZ6.C(next.getClass().getName(), ".RecomposeScopeImpl", false, 2, null)) {
                    break;
                }
            }
            if (next != null) {
                try {
                    Field fieldA = a(next.getClass(), "block");
                    if (fieldA != null && (obj = fieldA.get(next)) != null) {
                        Class<?> cls = obj.getClass();
                        Field fieldA2 = a(cls, "$$default");
                        Field fieldA3 = a(cls, "$$changed");
                        if (fieldA2 != null) {
                            Object obj2 = fieldA2.get(obj);
                            AbstractC13042fc3.g(obj2, "null cannot be cast to non-null type kotlin.Int");
                            iIntValue = ((Integer) obj2).intValue();
                        } else {
                            iIntValue = 0;
                        }
                        if (fieldA3 != null) {
                            Object obj3 = fieldA3.get(obj);
                            AbstractC13042fc3.g(obj3, "null cannot be cast to non-null type kotlin.Int");
                            iIntValue2 = ((Integer) obj3).intValue();
                        } else {
                            iIntValue2 = 0;
                        }
                        Field[] declaredFields = cls.getDeclaredFields();
                        ArrayList arrayList = new ArrayList();
                        for (Field field : declaredFields) {
                            if (AbstractC20153rZ6.S(field.getName(), "$", false, 2, null) && !AbstractC20153rZ6.S(field.getName(), "$$", false, 2, null) && !AbstractC20153rZ6.S(field.getName(), "$jacoco", false, 2, null)) {
                                arrayList.add(field);
                            }
                        }
                        List listA1 = AbstractC15401jX0.a1(arrayList, new a());
                        ArrayList arrayList2 = new ArrayList();
                        if (mh6 == null || (listM = mh6.c()) == null) {
                            listM = AbstractC10360bX0.m();
                        }
                        int size = listA1.size();
                        int i2 = 0;
                        while (i2 < size) {
                            C16578lW4 c16578lW4 = i2 < listM.size() ? (C16578lW4) listM.get(i2) : new C16578lW4(i2, null, i, null);
                            if (c16578lW4.b() < listA1.size()) {
                                Field field2 = (Field) listA1.get(c16578lW4.b());
                                field2.setAccessible(true);
                                Object obj4 = field2.get(obj);
                                boolean z = ((1 << i2) & iIntValue) != 0;
                                int i3 = (i2 * 3) + 1;
                                int i4 = ((7 << i3) & iIntValue2) >> i3;
                                int i5 = i4 & 3;
                                boolean z2 = i5 == 3;
                                boolean z3 = i5 == 0;
                                boolean z4 = (i4 & 4) == 0;
                                String strSubstring = field2.getName().substring(1);
                                AbstractC13042fc3.h(strSubstring, "substring(...)");
                                arrayList2.add(new C17760nW4(strSubstring, obj4, z, z2, z3 && !z, c16578lW4.a(), z4));
                            }
                            i2++;
                            i = 2;
                        }
                        return arrayList2;
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return AbstractC10360bX0.m();
    }

    public static final C25005za3 f() {
        return a;
    }

    private static final AbstractC15886kL2 g(InterfaceC7991Ub1 interfaceC7991Ub1, MH6 mh6) {
        C25005za3 c25005za3C;
        Object key = interfaceC7991Ub1.getKey();
        String strI = interfaceC7991Ub1.i();
        MH6 mh6B = strI != null ? B(strI, mh6) : null;
        Object objH = interfaceC7991Ub1.h();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        AbstractC13610gX0.D(arrayList, interfaceC7991Ub1.getData());
        Iterator it = interfaceC7991Ub1.f().iterator();
        while (it.hasNext()) {
            arrayList2.add(g((InterfaceC7991Ub1) it.next(), mh6B));
        }
        boolean z = objH instanceof InterfaceC16813lu3;
        List listK = z ? ((InterfaceC16813lu3) objH).k() : AbstractC10360bX0.m();
        if (z) {
            c25005za3C = c((InterfaceC16813lu3) objH);
        } else if (arrayList2.isEmpty()) {
            c25005za3C = a;
        } else {
            ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(arrayList2, 10));
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                arrayList3.add(((AbstractC15886kL2) it2.next()).a());
            }
            Iterator it3 = arrayList3.iterator();
            if (!it3.hasNext()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            Object next = it3.next();
            while (it3.hasNext()) {
                next = E((C25005za3) it3.next(), (C25005za3) next);
            }
            c25005za3C = (C25005za3) next;
        }
        TH6 th6G = (mh6B == null || !mh6B.e() || mh6 == null) ? null : mh6.g();
        if (objH != null) {
            return new ZA4(key, objH, c25005za3C, arrayList, listK, arrayList2);
        }
        String strA = mh6B != null ? mh6B.a() : null;
        String strA2 = mh6B != null ? mh6B.a() : null;
        return new C13256fv0(key, strA, c25005za3C, th6G, (strA2 == null || strA2.length() == 0 || (c25005za3C.d() - c25005za3C.j() <= 0 && c25005za3C.h() - c25005za3C.g() <= 0)) ? null : interfaceC7991Ub1.j(), e(arrayList, mh6B), arrayList, arrayList2, mh6B != null && mh6B.f());
    }

    private static final String h(OU3 ou3) {
        return (String) ou3.b().get(0);
    }

    private static final boolean i(OU3 ou3) {
        return ou3.d().get(1) != null;
    }

    private static final boolean j(OU3 ou3) {
        return ou3.d().get(6) != null;
    }

    private static final boolean k(OU3 ou3, String str) {
        return AbstractC13042fc3.d(h(ou3), str);
    }

    private static final boolean l(OU3 ou3) {
        return ou3.d().get(2) != null;
    }

    private static final boolean m(OU3 ou3) {
        return ou3.d().get(4) != null;
    }

    private static final boolean n(OU3 ou3) {
        return ou3.d().get(1) != null;
    }

    private static final boolean o(OU3 ou3) {
        return ou3.d().get(5) != null;
    }

    private static final int p(OU3 ou3) {
        return y((String) ou3.b().get(1));
    }

    private static final List q(String str) {
        C12889fL5 c12889fL5 = new C12889fL5();
        c12889fL5.a = C20644sM5.c(c, str, 0, 2, null);
        List listS = AbstractC10360bX0.s(0, 1, 2, 3);
        C11637dL5 c11637dL5 = new C11637dL5();
        c11637dL5.a = listS.size() - 1;
        ArrayList arrayList = new ArrayList();
        try {
            s(c12889fL5, "P");
            s(c12889fL5, Separators.LPAREN);
            while (!v(c12889fL5, Separators.RPAREN)) {
                if (v(c12889fL5, "!")) {
                    x(c12889fL5);
                    int iU = u(c12889fL5);
                    r(c11637dL5, listS, arrayList.size() + iU);
                    for (int i = 0; i < iU; i++) {
                        arrayList.add(new C16578lW4(((Number) AbstractC15401jX0.q0(listS)).intValue(), null, 2, null));
                        listS.remove(0);
                    }
                } else if (v(c12889fL5, ",")) {
                    x(c12889fL5);
                } else {
                    int iU2 = u(c12889fL5);
                    arrayList.add(new C16578lW4(iU2, w(c12889fL5) ? t(c12889fL5) : null));
                    r(c11637dL5, listS, iU2);
                    listS.remove(Integer.valueOf(iU2));
                }
            }
            s(c12889fL5, Separators.RPAREN);
            while (listS.size() > 0) {
                arrayList.add(new C16578lW4(((Number) AbstractC15401jX0.q0(listS)).intValue(), null, 2, null));
                listS.remove(0);
            }
            return arrayList;
        } catch (GW4 unused) {
            return AbstractC10360bX0.m();
        } catch (NumberFormatException unused2) {
            return AbstractC10360bX0.m();
        }
    }

    private static final void r(C11637dL5 c11637dL5, List list, int i) {
        int i2 = i - c11637dL5.a;
        if (i2 > 0) {
            if (i2 < 4) {
                i2 = 4;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                list.add(Integer.valueOf(c11637dL5.a + i3 + 1));
            }
            c11637dL5.a += i2;
        }
    }

    private static final void s(C12889fL5 c12889fL5, String str) throws GW4 {
        OU3 ou3 = (OU3) c12889fL5.a;
        if (ou3 == null || !AbstractC13042fc3.d(h(ou3), str)) {
            throw new GW4();
        }
        x(c12889fL5);
    }

    private static final String t(C12889fL5 c12889fL5) throws GW4 {
        OU3 ou3 = (OU3) c12889fL5.a;
        if (ou3 == null || !l(ou3)) {
            throw new GW4();
        }
        x(c12889fL5);
        String strSubstring = h(ou3).substring(1);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        return A(strSubstring, "c#", "androidx.compose.");
    }

    private static final int u(C12889fL5 c12889fL5) throws GW4 {
        OU3 ou3 = (OU3) c12889fL5.a;
        if (ou3 == null || !i(ou3)) {
            throw new GW4();
        }
        x(c12889fL5);
        return y(h(ou3));
    }

    private static final boolean v(C12889fL5 c12889fL5, String str) {
        OU3 ou3 = (OU3) c12889fL5.a;
        return ou3 == null || AbstractC13042fc3.d(h(ou3), str);
    }

    private static final boolean w(C12889fL5 c12889fL5) {
        OU3 ou3 = (OU3) c12889fL5.a;
        return ou3 != null && l(ou3);
    }

    private static final OU3 x(C12889fL5 c12889fL5) {
        OU3 ou3 = (OU3) c12889fL5.a;
        if (ou3 != null) {
            c12889fL5.a = ou3.next();
        }
        return (OU3) c12889fL5.a;
    }

    private static final int y(String str) throws GW4 {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            throw new GW4();
        }
    }

    private static final int z(String str, int i) throws GW4 {
        try {
            return Integer.parseInt(str, AbstractC10868cL0.a(i));
        } catch (NumberFormatException unused) {
            throw new GW4();
        }
    }
}
