package ir.nasim;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class Fj8 {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static InterfaceC22720vi8 a(String str, Ch8 ch8, C20322ro8 c20322ro8, List list) {
        String str2;
        char c;
        double dA;
        String strJ;
        double d;
        switch (str.hashCode()) {
            case -1776922004:
                str2 = "toString";
                if (str.equals(str2)) {
                    c = 18;
                    break;
                } else {
                    c = 65535;
                    break;
                }
            case -1354795244:
                if (str.equals("concat")) {
                    str2 = "toString";
                    c = 0;
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case -1274492040:
                if (str.equals("filter")) {
                    str2 = "toString";
                    c = 2;
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case -934873754:
                if (str.equals("reduce")) {
                    c = '\n';
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case -895859076:
                if (str.equals("splice")) {
                    c = 17;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case -678635926:
                if (str.equals("forEach")) {
                    str2 = "toString";
                    c = 3;
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case -467511597:
                if (str.equals("lastIndexOf")) {
                    c = 6;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case -277637751:
                if (str.equals("unshift")) {
                    c = 19;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 107868:
                if (str.equals("map")) {
                    c = 7;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 111185:
                if (str.equals("pop")) {
                    c = '\b';
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 3267882:
                if (str.equals("join")) {
                    c = 5;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 3452698:
                if (str.equals("push")) {
                    c = '\t';
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 3536116:
                if (str.equals("some")) {
                    c = 15;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 3536286:
                if (str.equals("sort")) {
                    c = 16;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 96891675:
                if (str.equals("every")) {
                    str2 = "toString";
                    c = 1;
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 109407362:
                if (str.equals("shift")) {
                    c = '\r';
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 109526418:
                if (str.equals("slice")) {
                    c = 14;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 965561430:
                if (str.equals("reduceRight")) {
                    c = 11;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 1099846370:
                if (str.equals("reverse")) {
                    c = '\f';
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 1943291465:
                if (str.equals("indexOf")) {
                    c = 4;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            default:
                str2 = "toString";
                c = 65535;
                break;
        }
        Vh8 vh8 = null;
        switch (c) {
            case 0:
                InterfaceC22720vi8 interfaceC22720vi8D = ch8.d();
                if (!list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        InterfaceC22720vi8 interfaceC22720vi8B = c20322ro8.b((InterfaceC22720vi8) it.next());
                        if (interfaceC22720vi8B instanceof Lh8) {
                            throw new IllegalStateException("Failed evaluation of arguments");
                        }
                        Ch8 ch82 = (Ch8) interfaceC22720vi8D;
                        int iW = ch82.w();
                        if (interfaceC22720vi8B instanceof Ch8) {
                            Ch8 ch83 = (Ch8) interfaceC22720vi8B;
                            Iterator itB = ch83.B();
                            while (itB.hasNext()) {
                                Integer num = (Integer) itB.next();
                                ch82.I(num.intValue() + iW, ch83.x(num.intValue()));
                            }
                        } else {
                            ch82.I(iW, interfaceC22720vi8B);
                        }
                    }
                }
                return interfaceC22720vi8D;
            case 1:
                AbstractC9951ap8.h("every", 1, list);
                InterfaceC22720vi8 interfaceC22720vi8B2 = c20322ro8.b((InterfaceC22720vi8) list.get(0));
                if (interfaceC22720vi8B2 instanceof C20853si8) {
                    return ch8.w() == 0 ? InterfaceC22720vi8.w0 : b(ch8, c20322ro8, (C20853si8) interfaceC22720vi8B2, Boolean.FALSE, Boolean.TRUE).w() != ch8.w() ? InterfaceC22720vi8.x0 : InterfaceC22720vi8.w0;
                }
                throw new IllegalArgumentException("Callback should be a method");
            case 2:
                AbstractC9951ap8.h("filter", 1, list);
                InterfaceC22720vi8 interfaceC22720vi8B3 = c20322ro8.b((InterfaceC22720vi8) list.get(0));
                if (!(interfaceC22720vi8B3 instanceof C20853si8)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (ch8.v() == 0) {
                    return new Ch8();
                }
                InterfaceC22720vi8 interfaceC22720vi8D2 = ch8.d();
                Ch8 ch8B = b(ch8, c20322ro8, (C20853si8) interfaceC22720vi8B3, null, Boolean.TRUE);
                Ch8 ch84 = new Ch8();
                Iterator itB2 = ch8B.B();
                while (itB2.hasNext()) {
                    ch84.I(ch84.w(), ((Ch8) interfaceC22720vi8D2).x(((Integer) itB2.next()).intValue()));
                }
                return ch84;
            case 3:
                AbstractC9951ap8.h("forEach", 1, list);
                InterfaceC22720vi8 interfaceC22720vi8B4 = c20322ro8.b((InterfaceC22720vi8) list.get(0));
                if (!(interfaceC22720vi8B4 instanceof C20853si8)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (ch8.v() == 0) {
                    return InterfaceC22720vi8.r0;
                }
                b(ch8, c20322ro8, (C20853si8) interfaceC22720vi8B4, null, null);
                return InterfaceC22720vi8.r0;
            case 4:
                AbstractC9951ap8.j("indexOf", 2, list);
                InterfaceC22720vi8 interfaceC22720vi8B5 = InterfaceC22720vi8.r0;
                if (!list.isEmpty()) {
                    interfaceC22720vi8B5 = c20322ro8.b((InterfaceC22720vi8) list.get(0));
                }
                if (list.size() > 1) {
                    dA = AbstractC9951ap8.a(c20322ro8.b((InterfaceC22720vi8) list.get(1)).k().doubleValue());
                    if (dA >= ch8.w()) {
                        return new Ph8(Double.valueOf(-1.0d));
                    }
                    if (dA < 0.0d) {
                        dA += ch8.w();
                    }
                } else {
                    dA = 0.0d;
                }
                Iterator itB3 = ch8.B();
                while (itB3.hasNext()) {
                    int iIntValue = ((Integer) itB3.next()).intValue();
                    double d2 = iIntValue;
                    if (d2 >= dA && AbstractC9951ap8.l(ch8.x(iIntValue), interfaceC22720vi8B5)) {
                        return new Ph8(Double.valueOf(d2));
                    }
                }
                return new Ph8(Double.valueOf(-1.0d));
            case 5:
                AbstractC9951ap8.j("join", 1, list);
                if (ch8.w() == 0) {
                    return InterfaceC22720vi8.y0;
                }
                if (list.isEmpty()) {
                    strJ = ",";
                } else {
                    InterfaceC22720vi8 interfaceC22720vi8B6 = c20322ro8.b((InterfaceC22720vi8) list.get(0));
                    strJ = ((interfaceC22720vi8B6 instanceof C19062pi8) || (interfaceC22720vi8B6 instanceof Ii8)) ? "" : interfaceC22720vi8B6.j();
                }
                return new Ei8(ch8.A(strJ));
            case 6:
                AbstractC9951ap8.j("lastIndexOf", 2, list);
                InterfaceC22720vi8 interfaceC22720vi8B7 = InterfaceC22720vi8.r0;
                if (!list.isEmpty()) {
                    interfaceC22720vi8B7 = c20322ro8.b((InterfaceC22720vi8) list.get(0));
                }
                double dW = ch8.w() - 1;
                if (list.size() > 1) {
                    InterfaceC22720vi8 interfaceC22720vi8B8 = c20322ro8.b((InterfaceC22720vi8) list.get(1));
                    dW = Double.isNaN(interfaceC22720vi8B8.k().doubleValue()) ? ch8.w() - 1 : AbstractC9951ap8.a(interfaceC22720vi8B8.k().doubleValue());
                    d = 0.0d;
                    if (dW < 0.0d) {
                        dW += ch8.w();
                    }
                } else {
                    d = 0.0d;
                }
                if (dW < d) {
                    return new Ph8(Double.valueOf(-1.0d));
                }
                for (int iMin = (int) Math.min(ch8.w(), dW); iMin >= 0; iMin--) {
                    if (ch8.L(iMin) && AbstractC9951ap8.l(ch8.x(iMin), interfaceC22720vi8B7)) {
                        return new Ph8(Double.valueOf(iMin));
                    }
                }
                return new Ph8(Double.valueOf(-1.0d));
            case 7:
                AbstractC9951ap8.h("map", 1, list);
                InterfaceC22720vi8 interfaceC22720vi8B9 = c20322ro8.b((InterfaceC22720vi8) list.get(0));
                if (interfaceC22720vi8B9 instanceof C20853si8) {
                    return ch8.w() == 0 ? new Ch8() : b(ch8, c20322ro8, (C20853si8) interfaceC22720vi8B9, null, null);
                }
                throw new IllegalArgumentException("Callback should be a method");
            case '\b':
                AbstractC9951ap8.h("pop", 0, list);
                int iW2 = ch8.w();
                if (iW2 == 0) {
                    return InterfaceC22720vi8.r0;
                }
                int i = iW2 - 1;
                InterfaceC22720vi8 interfaceC22720vi8X = ch8.x(i);
                ch8.F(i);
                return interfaceC22720vi8X;
            case '\t':
                if (!list.isEmpty()) {
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        ch8.I(ch8.w(), c20322ro8.b((InterfaceC22720vi8) it2.next()));
                    }
                }
                return new Ph8(Double.valueOf(ch8.w()));
            case '\n':
                return c(ch8, c20322ro8, list, true);
            case 11:
                return c(ch8, c20322ro8, list, false);
            case '\f':
                AbstractC9951ap8.h("reverse", 0, list);
                int iW3 = ch8.w();
                if (iW3 != 0) {
                    for (int i2 = 0; i2 < iW3 / 2; i2++) {
                        if (ch8.L(i2)) {
                            InterfaceC22720vi8 interfaceC22720vi8X2 = ch8.x(i2);
                            ch8.I(i2, null);
                            int i3 = (iW3 - 1) - i2;
                            if (ch8.L(i3)) {
                                ch8.I(i2, ch8.x(i3));
                            }
                            ch8.I(i3, interfaceC22720vi8X2);
                        }
                    }
                }
                return ch8;
            case '\r':
                AbstractC9951ap8.h("shift", 0, list);
                if (ch8.w() == 0) {
                    return InterfaceC22720vi8.r0;
                }
                InterfaceC22720vi8 interfaceC22720vi8X3 = ch8.x(0);
                ch8.F(0);
                return interfaceC22720vi8X3;
            case 14:
                AbstractC9951ap8.j("slice", 2, list);
                if (list.isEmpty()) {
                    return ch8.d();
                }
                double dW2 = ch8.w();
                double dA2 = AbstractC9951ap8.a(c20322ro8.b((InterfaceC22720vi8) list.get(0)).k().doubleValue());
                double dMax = dA2 < 0.0d ? Math.max(dA2 + dW2, 0.0d) : Math.min(dA2, dW2);
                if (list.size() == 2) {
                    double dA3 = AbstractC9951ap8.a(c20322ro8.b((InterfaceC22720vi8) list.get(1)).k().doubleValue());
                    dW2 = dA3 < 0.0d ? Math.max(dW2 + dA3, 0.0d) : Math.min(dW2, dA3);
                }
                Ch8 ch85 = new Ch8();
                for (int i4 = (int) dMax; i4 < dW2; i4++) {
                    ch85.I(ch85.w(), ch8.x(i4));
                }
                return ch85;
            case 15:
                AbstractC9951ap8.h("some", 1, list);
                InterfaceC22720vi8 interfaceC22720vi8B10 = c20322ro8.b((InterfaceC22720vi8) list.get(0));
                if (!(interfaceC22720vi8B10 instanceof Vh8)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (ch8.w() == 0) {
                    return InterfaceC22720vi8.x0;
                }
                Vh8 vh82 = (Vh8) interfaceC22720vi8B10;
                Iterator itB4 = ch8.B();
                while (itB4.hasNext()) {
                    int iIntValue2 = ((Integer) itB4.next()).intValue();
                    if (ch8.L(iIntValue2) && vh82.a(c20322ro8, Arrays.asList(ch8.x(iIntValue2), new Ph8(Double.valueOf(iIntValue2)), ch8)).o().booleanValue()) {
                        return InterfaceC22720vi8.w0;
                    }
                }
                return InterfaceC22720vi8.x0;
            case 16:
                AbstractC9951ap8.j("sort", 1, list);
                if (ch8.w() >= 2) {
                    List listC = ch8.C();
                    if (!list.isEmpty()) {
                        InterfaceC22720vi8 interfaceC22720vi8B11 = c20322ro8.b((InterfaceC22720vi8) list.get(0));
                        if (!(interfaceC22720vi8B11 instanceof Vh8)) {
                            throw new IllegalArgumentException("Comparator should be a method");
                        }
                        vh8 = (Vh8) interfaceC22720vi8B11;
                    }
                    Collections.sort(listC, new Bj8(vh8, c20322ro8));
                    ch8.D();
                    Iterator it3 = listC.iterator();
                    int i5 = 0;
                    while (it3.hasNext()) {
                        ch8.I(i5, (InterfaceC22720vi8) it3.next());
                        i5++;
                    }
                }
                return ch8;
            case 17:
                if (list.isEmpty()) {
                    return new Ch8();
                }
                int iA = (int) AbstractC9951ap8.a(c20322ro8.b((InterfaceC22720vi8) list.get(0)).k().doubleValue());
                if (iA < 0) {
                    iA = Math.max(0, iA + ch8.w());
                } else if (iA > ch8.w()) {
                    iA = ch8.w();
                }
                int iW4 = ch8.w();
                Ch8 ch86 = new Ch8();
                if (list.size() > 1) {
                    int iMax = Math.max(0, (int) AbstractC9951ap8.a(c20322ro8.b((InterfaceC22720vi8) list.get(1)).k().doubleValue()));
                    if (iMax > 0) {
                        for (int i6 = iA; i6 < Math.min(iW4, iA + iMax); i6++) {
                            ch86.I(ch86.w(), ch8.x(iA));
                            ch8.F(iA);
                        }
                    }
                    if (list.size() > 2) {
                        for (int i7 = 2; i7 < list.size(); i7++) {
                            InterfaceC22720vi8 interfaceC22720vi8B12 = c20322ro8.b((InterfaceC22720vi8) list.get(i7));
                            if (interfaceC22720vi8B12 instanceof Lh8) {
                                throw new IllegalArgumentException("Failed to parse elements to add");
                            }
                            ch8.E((iA + i7) - 2, interfaceC22720vi8B12);
                        }
                    }
                } else {
                    while (iA < iW4) {
                        ch86.I(ch86.w(), ch8.x(iA));
                        ch8.I(iA, null);
                        iA++;
                    }
                }
                return ch86;
            case 18:
                AbstractC9951ap8.h(str2, 0, list);
                return new Ei8(ch8.A(","));
            case 19:
                if (!list.isEmpty()) {
                    Ch8 ch87 = new Ch8();
                    Iterator it4 = list.iterator();
                    while (it4.hasNext()) {
                        InterfaceC22720vi8 interfaceC22720vi8B13 = c20322ro8.b((InterfaceC22720vi8) it4.next());
                        if (interfaceC22720vi8B13 instanceof Lh8) {
                            throw new IllegalStateException("Argument evaluation failed");
                        }
                        ch87.I(ch87.w(), interfaceC22720vi8B13);
                    }
                    int iW5 = ch87.w();
                    Iterator itB5 = ch8.B();
                    while (itB5.hasNext()) {
                        Integer num2 = (Integer) itB5.next();
                        ch87.I(num2.intValue() + iW5, ch8.x(num2.intValue()));
                    }
                    ch8.D();
                    Iterator itB6 = ch87.B();
                    while (itB6.hasNext()) {
                        Integer num3 = (Integer) itB6.next();
                        ch8.I(num3.intValue(), ch87.x(num3.intValue()));
                    }
                }
                return new Ph8(Double.valueOf(ch8.w()));
            default:
                throw new IllegalArgumentException("Command not supported");
        }
    }

    private static Ch8 b(Ch8 ch8, C20322ro8 c20322ro8, Vh8 vh8, Boolean bool, Boolean bool2) {
        Ch8 ch82 = new Ch8();
        Iterator itB = ch8.B();
        while (itB.hasNext()) {
            int iIntValue = ((Integer) itB.next()).intValue();
            if (ch8.L(iIntValue)) {
                InterfaceC22720vi8 interfaceC22720vi8A = vh8.a(c20322ro8, Arrays.asList(ch8.x(iIntValue), new Ph8(Double.valueOf(iIntValue)), ch8));
                if (interfaceC22720vi8A.o().equals(bool)) {
                    return ch82;
                }
                if (bool2 == null || interfaceC22720vi8A.o().equals(bool2)) {
                    ch82.I(iIntValue, interfaceC22720vi8A);
                }
            }
        }
        return ch82;
    }

    private static InterfaceC22720vi8 c(Ch8 ch8, C20322ro8 c20322ro8, List list, boolean z) {
        InterfaceC22720vi8 interfaceC22720vi8A;
        AbstractC9951ap8.i("reduce", 1, list);
        AbstractC9951ap8.j("reduce", 2, list);
        InterfaceC22720vi8 interfaceC22720vi8B = c20322ro8.b((InterfaceC22720vi8) list.get(0));
        if (!(interfaceC22720vi8B instanceof Vh8)) {
            throw new IllegalArgumentException("Callback should be a method");
        }
        if (list.size() == 2) {
            interfaceC22720vi8A = c20322ro8.b((InterfaceC22720vi8) list.get(1));
            if (interfaceC22720vi8A instanceof Lh8) {
                throw new IllegalArgumentException("Failed to parse initial value");
            }
        } else {
            if (ch8.w() == 0) {
                throw new IllegalStateException("Empty array with no initial value error");
            }
            interfaceC22720vi8A = null;
        }
        Vh8 vh8 = (Vh8) interfaceC22720vi8B;
        int iW = ch8.w();
        int i = z ? 0 : iW - 1;
        int i2 = z ? iW - 1 : 0;
        int i3 = true == z ? 1 : -1;
        if (interfaceC22720vi8A == null) {
            interfaceC22720vi8A = ch8.x(i);
            i += i3;
        }
        while ((i2 - i) * i3 >= 0) {
            if (ch8.L(i)) {
                interfaceC22720vi8A = vh8.a(c20322ro8, Arrays.asList(interfaceC22720vi8A, ch8.x(i), new Ph8(Double.valueOf(i)), ch8));
                if (interfaceC22720vi8A instanceof Lh8) {
                    throw new IllegalStateException("Reduce operation failed");
                }
                i += i3;
            } else {
                i += i3;
            }
        }
        return interfaceC22720vi8A;
    }
}
