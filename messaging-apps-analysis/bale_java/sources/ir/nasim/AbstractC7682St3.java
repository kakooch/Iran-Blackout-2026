package ir.nasim;

import android.graphics.Color;
import android.graphics.Rect;
import ir.nasim.AbstractC11911dl3;
import ir.nasim.C6970Pt3;
import java.util.ArrayList;
import java.util.Collections;

/* renamed from: ir.nasim.St3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC7682St3 {
    private static final AbstractC11911dl3.a a = AbstractC11911dl3.a.a("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd", "ao", "bm");
    private static final AbstractC11911dl3.a b = AbstractC11911dl3.a.a("d", "a");
    private static final AbstractC11911dl3.a c = AbstractC11911dl3.a.a("ty", "nm");

    /* renamed from: ir.nasim.St3$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[C6970Pt3.b.values().length];
            a = iArr;
            try {
                iArr[C6970Pt3.b.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[C6970Pt3.b.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static C6970Pt3 a(AbstractC11911dl3 abstractC11911dl3, C23677xK3 c23677xK3) {
        ArrayList arrayList;
        boolean z;
        float f;
        C6970Pt3.b bVar = C6970Pt3.b.NONE;
        EnumC6469Nr3 enumC6469Nr3 = EnumC6469Nr3.NORMAL;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        abstractC11911dl3.B();
        Float fValueOf = Float.valueOf(0.0f);
        Float fValueOf2 = Float.valueOf(1.0f);
        C6970Pt3.b bVar2 = bVar;
        EnumC6469Nr3 enumC6469Nr32 = enumC6469Nr3;
        C6970Pt3.a aVar = null;
        String strT0 = null;
        C23407ws c23407wsD = null;
        C23997xs c23997xsA = null;
        C17380ms c17380msF = null;
        C4474Fh0 c4474Fh0B = null;
        C18061o12 c18061o12B = null;
        long jR0 = 0;
        boolean z2 = false;
        int iR0 = 0;
        int iR02 = 0;
        int color = 0;
        boolean zE = false;
        float fF1 = 0.0f;
        float fF12 = 0.0f;
        float fF13 = 0.0f;
        float fF14 = 0.0f;
        float f2 = 0.0f;
        long jR02 = -1;
        float fF15 = 1.0f;
        String strT02 = "UNSET";
        String strT03 = null;
        C3636Bs c3636Bs = null;
        while (abstractC11911dl3.d()) {
            switch (abstractC11911dl3.l(a)) {
                case 0:
                    strT02 = abstractC11911dl3.T0();
                    break;
                case 1:
                    jR0 = abstractC11911dl3.r0();
                    break;
                case 2:
                    strT0 = abstractC11911dl3.T0();
                    break;
                case 3:
                    int iR03 = abstractC11911dl3.r0();
                    aVar = C6970Pt3.a.UNKNOWN;
                    if (iR03 >= aVar.ordinal()) {
                        break;
                    } else {
                        aVar = C6970Pt3.a.values()[iR03];
                        break;
                    }
                case 4:
                    jR02 = abstractC11911dl3.r0();
                    break;
                case 5:
                    iR0 = (int) (abstractC11911dl3.r0() * AbstractC16500lN7.e());
                    break;
                case 6:
                    iR02 = (int) (abstractC11911dl3.r0() * AbstractC16500lN7.e());
                    break;
                case 7:
                    color = Color.parseColor(abstractC11911dl3.T0());
                    break;
                case 8:
                    c3636Bs = AbstractC3870Cs.g(abstractC11911dl3, c23677xK3);
                    break;
                case 9:
                    int iR04 = abstractC11911dl3.r0();
                    if (iR04 < C6970Pt3.b.values().length) {
                        bVar2 = C6970Pt3.b.values()[iR04];
                        int i = a.a[bVar2.ordinal()];
                        if (i == 1) {
                            c23677xK3.a("Unsupported matte type: Luma");
                        } else if (i == 2) {
                            c23677xK3.a("Unsupported matte type: Luma Inverted");
                        }
                        c23677xK3.s(1);
                        break;
                    } else {
                        c23677xK3.a("Unsupported matte type: " + iR04);
                        break;
                    }
                case 10:
                    abstractC11911dl3.b();
                    while (abstractC11911dl3.d()) {
                        arrayList2.add(GU3.a(abstractC11911dl3, c23677xK3));
                    }
                    c23677xK3.s(arrayList2.size());
                    abstractC11911dl3.c();
                    break;
                case 11:
                    abstractC11911dl3.b();
                    while (abstractC11911dl3.d()) {
                        InterfaceC9904al1 interfaceC9904al1A = AbstractC10524bl1.a(abstractC11911dl3, c23677xK3);
                        if (interfaceC9904al1A != null) {
                            arrayList3.add(interfaceC9904al1A);
                        }
                    }
                    abstractC11911dl3.c();
                    break;
                case 12:
                    abstractC11911dl3.B();
                    while (abstractC11911dl3.d()) {
                        int iL = abstractC11911dl3.l(b);
                        if (iL == 0) {
                            c23407wsD = AbstractC4338Es.d(abstractC11911dl3, c23677xK3);
                        } else if (iL != 1) {
                            abstractC11911dl3.m();
                            abstractC11911dl3.R();
                        } else {
                            abstractC11911dl3.b();
                            if (abstractC11911dl3.d()) {
                                c23997xsA = AbstractC24587ys.a(abstractC11911dl3, c23677xK3);
                            }
                            while (abstractC11911dl3.d()) {
                                abstractC11911dl3.R();
                            }
                            abstractC11911dl3.c();
                        }
                    }
                    abstractC11911dl3.F();
                    break;
                case 13:
                    abstractC11911dl3.b();
                    ArrayList arrayList4 = new ArrayList();
                    while (abstractC11911dl3.d()) {
                        abstractC11911dl3.B();
                        while (abstractC11911dl3.d()) {
                            int iL2 = abstractC11911dl3.l(c);
                            if (iL2 == 0) {
                                int iR05 = abstractC11911dl3.r0();
                                if (iR05 == 29) {
                                    c4474Fh0B = AbstractC4723Gh0.b(abstractC11911dl3, c23677xK3);
                                } else if (iR05 == 25) {
                                    c18061o12B = new C18652p12().b(abstractC11911dl3, c23677xK3);
                                }
                            } else if (iL2 != 1) {
                                abstractC11911dl3.m();
                                abstractC11911dl3.R();
                            } else {
                                arrayList4.add(abstractC11911dl3.T0());
                            }
                        }
                        abstractC11911dl3.F();
                    }
                    abstractC11911dl3.c();
                    c23677xK3.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList4);
                    break;
                case 14:
                    fF15 = (float) abstractC11911dl3.f1();
                    break;
                case 15:
                    fF12 = (float) abstractC11911dl3.f1();
                    break;
                case 16:
                    fF13 = (float) (abstractC11911dl3.f1() * AbstractC16500lN7.e());
                    break;
                case 17:
                    fF14 = (float) (abstractC11911dl3.f1() * AbstractC16500lN7.e());
                    break;
                case 18:
                    fF1 = (float) abstractC11911dl3.f1();
                    break;
                case 19:
                    f2 = (float) abstractC11911dl3.f1();
                    break;
                case 20:
                    c17380msF = AbstractC4338Es.f(abstractC11911dl3, c23677xK3, false);
                    break;
                case 21:
                    strT03 = abstractC11911dl3.T0();
                    break;
                case 22:
                    zE = abstractC11911dl3.e();
                    break;
                case 23:
                    if (abstractC11911dl3.r0() != 1) {
                        z2 = false;
                        break;
                    } else {
                        z2 = true;
                        break;
                    }
                case 24:
                    int iR06 = abstractC11911dl3.r0();
                    if (iR06 < EnumC6469Nr3.values().length) {
                        enumC6469Nr32 = EnumC6469Nr3.values()[iR06];
                        break;
                    } else {
                        c23677xK3.a("Unsupported Blend Mode: " + iR06);
                        enumC6469Nr32 = EnumC6469Nr3.NORMAL;
                        break;
                    }
                default:
                    abstractC11911dl3.m();
                    abstractC11911dl3.R();
                    break;
            }
        }
        abstractC11911dl3.F();
        ArrayList arrayList5 = new ArrayList();
        if (fF1 > 0.0f) {
            arrayList = arrayList2;
            z = z2;
            arrayList5.add(new C24561yp3(c23677xK3, fValueOf, fValueOf, null, 0.0f, Float.valueOf(fF1)));
            f = 0.0f;
        } else {
            arrayList = arrayList2;
            z = z2;
            f = 0.0f;
        }
        if (f2 <= f) {
            f2 = c23677xK3.f();
        }
        arrayList5.add(new C24561yp3(c23677xK3, fValueOf2, fValueOf2, null, fF1, Float.valueOf(f2)));
        arrayList5.add(new C24561yp3(c23677xK3, fValueOf, fValueOf, null, f2, Float.valueOf(Float.MAX_VALUE)));
        if (strT02.endsWith(".ai") || "ai".equals(strT03)) {
            c23677xK3.a("Convert your Illustrator layers to shape layers.");
        }
        if (z) {
            if (c3636Bs == null) {
                c3636Bs = new C3636Bs();
            }
            c3636Bs.m(z);
        }
        return new C6970Pt3(arrayList3, c23677xK3, strT02, jR0, aVar, jR02, strT0, arrayList, c3636Bs, iR0, iR02, color, fF15, fF12, fF13, fF14, c23407wsD, c23997xsA, arrayList5, bVar2, c17380msF, zE, c4474Fh0B, c18061o12B, enumC6469Nr32);
    }

    public static C6970Pt3 b(C23677xK3 c23677xK3) {
        Rect rectB = c23677xK3.b();
        return new C6970Pt3(Collections.emptyList(), c23677xK3, "__container", -1L, C6970Pt3.a.PRE_COMP, -1L, null, Collections.emptyList(), new C3636Bs(), 0, 0, 0, 0.0f, 0.0f, rectB.width(), rectB.height(), null, null, Collections.emptyList(), C6970Pt3.b.NONE, null, false, null, null, EnumC6469Nr3.NORMAL);
    }
}
