package ir.nasim;

import android.graphics.Rect;
import ir.nasim.AbstractC11911dl3;
import ir.nasim.C6970Pt3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class KK3 {
    private static final AbstractC11911dl3.a a = AbstractC11911dl3.a.a("w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");
    static AbstractC11911dl3.a b = AbstractC11911dl3.a.a("id", "layers", "w", "h", "p", "u");
    private static final AbstractC11911dl3.a c = AbstractC11911dl3.a.a("list");
    private static final AbstractC11911dl3.a d = AbstractC11911dl3.a.a("cm", "tm", "dr");

    public static C23677xK3 a(AbstractC11911dl3 abstractC11911dl3) {
        HashMap map;
        ArrayList arrayList;
        AbstractC11911dl3 abstractC11911dl32 = abstractC11911dl3;
        float fE = AbstractC16500lN7.e();
        C21892uJ3 c21892uJ3 = new C21892uJ3();
        ArrayList arrayList2 = new ArrayList();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        HashMap map4 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        C19409qI6 c19409qI6 = new C19409qI6();
        C23677xK3 c23677xK3 = new C23677xK3();
        abstractC11911dl3.B();
        float fF1 = 0.0f;
        float fF12 = 0.0f;
        float fF13 = 0.0f;
        int iF1 = 0;
        int iF12 = 0;
        while (abstractC11911dl3.d()) {
            switch (abstractC11911dl32.l(a)) {
                case 0:
                    map = map4;
                    arrayList = arrayList3;
                    iF12 = (int) abstractC11911dl3.f1();
                    break;
                case 1:
                    iF1 = (int) abstractC11911dl3.f1();
                    continue;
                    abstractC11911dl32 = abstractC11911dl3;
                case 2:
                    fF1 = (float) abstractC11911dl3.f1();
                    continue;
                    abstractC11911dl32 = abstractC11911dl3;
                case 3:
                    map = map4;
                    arrayList = arrayList3;
                    fF12 = ((float) abstractC11911dl3.f1()) - 0.01f;
                    break;
                case 4:
                    map = map4;
                    arrayList = arrayList3;
                    fF13 = (float) abstractC11911dl3.f1();
                    break;
                case 5:
                    String[] strArrSplit = abstractC11911dl3.T0().split("\\.");
                    if (!AbstractC16500lN7.j(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), 4, 4, 0)) {
                        c23677xK3.a("Lottie only supports bodymovin >= 4.4.0");
                        continue;
                    }
                    abstractC11911dl32 = abstractC11911dl3;
                case 6:
                    e(abstractC11911dl32, c23677xK3, arrayList2, c21892uJ3);
                    continue;
                    abstractC11911dl32 = abstractC11911dl3;
                case 7:
                    b(abstractC11911dl32, c23677xK3, map2, map3);
                    continue;
                    abstractC11911dl32 = abstractC11911dl3;
                case 8:
                    d(abstractC11911dl32, map4);
                    continue;
                    abstractC11911dl32 = abstractC11911dl3;
                case 9:
                    c(abstractC11911dl32, c23677xK3, c19409qI6);
                    continue;
                    abstractC11911dl32 = abstractC11911dl3;
                case 10:
                    f(abstractC11911dl32, arrayList3);
                    continue;
                    abstractC11911dl32 = abstractC11911dl3;
                default:
                    abstractC11911dl3.m();
                    abstractC11911dl3.R();
                    continue;
                    abstractC11911dl32 = abstractC11911dl3;
            }
            map4 = map;
            arrayList3 = arrayList;
            abstractC11911dl32 = abstractC11911dl3;
        }
        c23677xK3.t(new Rect(0, 0, (int) (iF12 * fE), (int) (iF1 * fE)), fF1, fF12, fF13, arrayList2, c21892uJ3, map2, map3, AbstractC16500lN7.e(), c19409qI6, map4, arrayList3, iF12, iF1);
        return c23677xK3;
    }

    private static void b(AbstractC11911dl3 abstractC11911dl3, C23677xK3 c23677xK3, Map map, Map map2) {
        abstractC11911dl3.b();
        while (abstractC11911dl3.d()) {
            ArrayList arrayList = new ArrayList();
            C21892uJ3 c21892uJ3 = new C21892uJ3();
            abstractC11911dl3.B();
            int iR0 = 0;
            int iR02 = 0;
            String strT0 = null;
            String strT02 = null;
            String strT03 = null;
            while (abstractC11911dl3.d()) {
                int iL = abstractC11911dl3.l(b);
                if (iL == 0) {
                    strT0 = abstractC11911dl3.T0();
                } else if (iL == 1) {
                    abstractC11911dl3.b();
                    while (abstractC11911dl3.d()) {
                        C6970Pt3 c6970Pt3A = AbstractC7682St3.a(abstractC11911dl3, c23677xK3);
                        c21892uJ3.l(c6970Pt3A.e(), c6970Pt3A);
                        arrayList.add(c6970Pt3A);
                    }
                    abstractC11911dl3.c();
                } else if (iL == 2) {
                    iR0 = abstractC11911dl3.r0();
                } else if (iL == 3) {
                    iR02 = abstractC11911dl3.r0();
                } else if (iL == 4) {
                    strT02 = abstractC11911dl3.T0();
                } else if (iL != 5) {
                    abstractC11911dl3.m();
                    abstractC11911dl3.R();
                } else {
                    strT03 = abstractC11911dl3.T0();
                }
            }
            abstractC11911dl3.F();
            if (strT02 != null) {
                VK3 vk3 = new VK3(iR0, iR02, strT0, strT02, strT03);
                map2.put(vk3.e(), vk3);
            } else {
                map.put(strT0, arrayList);
            }
        }
        abstractC11911dl3.c();
    }

    private static void c(AbstractC11911dl3 abstractC11911dl3, C23677xK3 c23677xK3, C19409qI6 c19409qI6) {
        abstractC11911dl3.b();
        while (abstractC11911dl3.d()) {
            C9163Yt2 c9163Yt2A = AbstractC9397Zt2.a(abstractC11911dl3, c23677xK3);
            c19409qI6.l(c9163Yt2A.hashCode(), c9163Yt2A);
        }
        abstractC11911dl3.c();
    }

    private static void d(AbstractC11911dl3 abstractC11911dl3, Map map) {
        abstractC11911dl3.B();
        while (abstractC11911dl3.d()) {
            if (abstractC11911dl3.l(c) != 0) {
                abstractC11911dl3.m();
                abstractC11911dl3.R();
            } else {
                abstractC11911dl3.b();
                while (abstractC11911dl3.d()) {
                    C8388Vt2 c8388Vt2A = AbstractC17994nu2.a(abstractC11911dl3);
                    map.put(c8388Vt2A.b(), c8388Vt2A);
                }
                abstractC11911dl3.c();
            }
        }
        abstractC11911dl3.F();
    }

    private static void e(AbstractC11911dl3 abstractC11911dl3, C23677xK3 c23677xK3, List list, C21892uJ3 c21892uJ3) {
        abstractC11911dl3.b();
        int i = 0;
        while (abstractC11911dl3.d()) {
            C6970Pt3 c6970Pt3A = AbstractC7682St3.a(abstractC11911dl3, c23677xK3);
            if (c6970Pt3A.g() == C6970Pt3.a.IMAGE) {
                i++;
            }
            list.add(c6970Pt3A);
            c21892uJ3.l(c6970Pt3A.e(), c6970Pt3A);
            if (i > 4) {
                JI3.c("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        abstractC11911dl3.c();
    }

    private static void f(AbstractC11911dl3 abstractC11911dl3, List list) {
        abstractC11911dl3.b();
        while (abstractC11911dl3.d()) {
            abstractC11911dl3.B();
            float fF1 = 0.0f;
            String strT0 = null;
            float fF12 = 0.0f;
            while (abstractC11911dl3.d()) {
                int iL = abstractC11911dl3.l(d);
                if (iL == 0) {
                    strT0 = abstractC11911dl3.T0();
                } else if (iL == 1) {
                    fF1 = (float) abstractC11911dl3.f1();
                } else if (iL != 2) {
                    abstractC11911dl3.m();
                    abstractC11911dl3.R();
                } else {
                    fF12 = (float) abstractC11911dl3.f1();
                }
            }
            abstractC11911dl3.F();
            list.add(new NO3(strT0, fF1, fF12));
        }
        abstractC11911dl3.c();
    }
}
