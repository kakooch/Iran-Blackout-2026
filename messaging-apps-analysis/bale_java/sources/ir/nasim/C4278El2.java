package ir.nasim;

import android.gov.nist.core.Separators;
import android.text.TextUtils;
import android.util.SparseArray;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.C21457d;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: ir.nasim.El2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C4278El2 extends F90 {
    private static SparseArray i;
    private static final C4278El2[] j = new C4278El2[1];
    private final C8082Ul2 c;
    private final ConcurrentHashMap d;
    private final ConcurrentHashMap e;
    private HashMap f;
    private int g;
    private ConcurrentHashMap h;

    /* renamed from: ir.nasim.El2$a */
    public interface a {
        File a();
    }

    public C4278El2(int i2) {
        super(i2);
        this.d = new ConcurrentHashMap();
        this.e = new ConcurrentHashMap(10, 1.0f, 2);
        this.f = new HashMap();
        this.h = new ConcurrentHashMap();
        this.c = new C8082Ul2(i2);
        r();
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x006b A[PHI: r6
      0x006b: PHI (r6v2 int) = (r6v1 int), (r6v1 int), (r6v1 int), (r6v1 int), (r6v4 int), (r6v4 int), (r6v4 int), (r6v4 int) binds: [B:36:0x0057, B:43:0x0065, B:45:0x0069, B:41:0x0061, B:24:0x003a, B:31:0x0048, B:33:0x004c, B:29:0x0044] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static ir.nasim.AbstractC11500d67 A(java.util.ArrayList r8, int r9, boolean r10, ir.nasim.AbstractC11500d67 r11, boolean r12) {
        /*
            r0 = 0
            if (r8 == 0) goto L70
            boolean r1 = r8.isEmpty()
            if (r1 == 0) goto Lb
            goto L70
        Lb:
            r1 = 0
            r2 = r1
        Ld:
            int r3 = r8.size()
            if (r1 >= r3) goto L70
            java.lang.Object r3 = r8.get(r1)
            ir.nasim.d67 r3 = (ir.nasim.AbstractC11500d67) r3
            if (r3 == 0) goto L6d
            if (r3 == r11) goto L6d
            boolean r4 = r3 instanceof ir.nasim.C7788Te7
            if (r4 != 0) goto L6d
            boolean r4 = r3 instanceof ir.nasim.C7317Re7
            if (r4 != 0) goto L6d
            if (r12 == 0) goto L2c
            boolean r4 = r3 instanceof ir.nasim.C8758Xe7
            if (r4 == 0) goto L2c
            goto L6d
        L2c:
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = 100
            if (r10 == 0) goto L4f
            int r6 = r3.e
            int r7 = r3.d
            int r6 = java.lang.Math.min(r6, r7)
            if (r0 == 0) goto L6b
            if (r9 <= r5) goto L46
            ir.nasim.s57 r5 = r0.c
            if (r5 == 0) goto L46
            int r5 = r5.b
            if (r5 == r4) goto L6b
        L46:
            boolean r4 = r3 instanceof ir.nasim.C6600Oe7
            if (r4 != 0) goto L6b
            if (r9 <= r2) goto L6d
            if (r2 >= r6) goto L6d
            goto L6b
        L4f:
            int r6 = r3.d
            int r7 = r3.e
            int r6 = java.lang.Math.max(r6, r7)
            if (r0 == 0) goto L6b
            if (r9 <= r5) goto L63
            ir.nasim.s57 r5 = r0.c
            if (r5 == 0) goto L63
            int r5 = r5.b
            if (r5 == r4) goto L6b
        L63:
            boolean r4 = r3 instanceof ir.nasim.C6600Oe7
            if (r4 != 0) goto L6b
            if (r6 > r9) goto L6d
            if (r2 >= r6) goto L6d
        L6b:
            r0 = r3
            r2 = r6
        L6d:
            int r1 = r1 + 1
            goto Ld
        L70:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4278El2.A(java.util.ArrayList, int, boolean, ir.nasim.d67, boolean):ir.nasim.d67");
    }

    public static File B(int i2) {
        File file = (File) i.get(i2);
        if (file == null && i2 != 4) {
            file = (File) i.get(4);
        }
        if (AbstractC8814Xl0.e && file != null) {
            try {
                if (!file.isDirectory()) {
                    file.mkdirs();
                }
            } catch (Exception unused) {
            }
        }
        return file;
    }

    public static String C(AbstractC18106o57 abstractC18106o57) {
        String str = null;
        if (abstractC18106o57 == null) {
            return null;
        }
        String str2 = abstractC18106o57.q;
        if (str2 != null) {
            return str2;
        }
        String str3 = abstractC18106o57.h;
        if (str3 == null) {
            for (int i2 = 0; i2 < abstractC18106o57.p.size(); i2++) {
                AbstractC18697p57 abstractC18697p57 = (AbstractC18697p57) abstractC18106o57.p.get(i2);
                if (abstractC18697p57 instanceof G77) {
                    str = abstractC18697p57.i;
                }
            }
            str3 = str;
        }
        String strS = s(str3);
        return strS != null ? strS : "";
    }

    public static String D(String str) {
        if (str == null) {
            return "";
        }
        switch (str) {
            case "audio/ogg":
                return ".ogg";
            case "video/mp4":
                return ".mp4";
            case "video/x-matroska":
                return ".mkv";
            default:
                return "";
        }
    }

    public static String F(File file) {
        String name = file.getName();
        try {
            return name.substring(name.lastIndexOf(46) + 1);
        } catch (Exception unused) {
            return "";
        }
    }

    public static C4278El2 H(int i2) {
        C4278El2[] c4278El2Arr = j;
        C4278El2 c4278El2 = c4278El2Arr[i2];
        if (c4278El2 == null) {
            synchronized (C4278El2.class) {
                try {
                    c4278El2 = c4278El2Arr[i2];
                    if (c4278El2 == null) {
                        c4278El2 = new C4278El2(i2);
                        c4278El2Arr[i2] = c4278El2;
                    }
                } finally {
                }
            }
        }
        return c4278El2;
    }

    public static File I() {
        return AbstractC14047hG.a.getCacheDir();
    }

    public static String J(L57 l57) {
        AbstractC24495yi7 abstractC24495yi7;
        AbstractC11500d67 abstractC11500d67Y;
        AbstractC11500d67 abstractC11500d67A;
        AbstractC11500d67 abstractC11500d67Y2;
        if (l57 == null) {
            return "";
        }
        if (l57 instanceof C8006Uc7) {
            AbstractC10736c67 abstractC10736c67 = l57.f.i;
            if (abstractC10736c67 != null) {
                ArrayList arrayList = abstractC10736c67.h;
                if (arrayList.size() > 0 && (abstractC11500d67Y2 = y(arrayList, AbstractC21455b.g0())) != null) {
                    return u(abstractC11500d67Y2);
                }
            }
        } else {
            if (C10743c74.W(l57) instanceof C16046kc7) {
                return u(C10743c74.W(l57).s);
            }
            if (C10743c74.W(l57) instanceof C23255wc7) {
                ArrayList arrayList2 = C10743c74.W(l57).f.h;
                if (arrayList2.size() > 0 && (abstractC11500d67A = A(arrayList2, AbstractC21455b.g0(), false, null, true)) != null) {
                    return u(abstractC11500d67A);
                }
            } else if (C10743c74.W(l57) instanceof C5153Ic7) {
                if (C10743c74.W(l57).B.r != null) {
                    return u(C10743c74.W(l57).B.r);
                }
                if (C10743c74.W(l57).B.k != null) {
                    ArrayList arrayList3 = C10743c74.W(l57).B.k.h;
                    if (arrayList3.size() > 0 && (abstractC11500d67Y = y(arrayList3, AbstractC21455b.g0())) != null) {
                        return u(abstractC11500d67Y);
                    }
                }
            } else if ((C10743c74.W(l57) instanceof C22069uc7) && (abstractC24495yi7 = ((C22069uc7) C10743c74.W(l57)).N) != null) {
                return Utilities.a(abstractC24495yi7.b) + Separators.DOT + C21457d.e0(abstractC24495yi7.b, K(abstractC24495yi7.e));
            }
        }
        return "";
    }

    public static String K(String str) {
        int iLastIndexOf = str.lastIndexOf(47);
        return iLastIndexOf != -1 ? str.substring(iLastIndexOf + 1) : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public void W(AbstractC18106o57 abstractC18106o57, boolean z) {
        String strU = u(abstractC18106o57);
        StringBuilder sb = new StringBuilder();
        sb.append(strU);
        sb.append(z ? "p" : "");
        if (this.f.remove(sb.toString()) != null) {
            e().s(ir.nasim.tgwidgets.editor.messenger.E.b1, strU);
        }
    }

    public static void i0(SparseArray sparseArray) {
        i = sparseArray;
    }

    public static File q(int i2) {
        return (File) i.get(i2);
    }

    public static String s(String str) {
        return str != null ? str.replaceAll("[\u0001-\u001f<>\u202e:\"/\\\\|?*\u007f]+", "").trim() : str;
    }

    public static String u(AbstractC12724f57 abstractC12724f57) {
        return v(abstractC12724f57, null);
    }

    public static String v(AbstractC12724f57 abstractC12724f57, String str) {
        return w(abstractC12724f57, null, str);
    }

    public static String w(AbstractC12724f57 abstractC12724f57, String str, String str2) {
        if (abstractC12724f57 instanceof AbstractC18106o57) {
            AbstractC18106o57 abstractC18106o57 = (AbstractC18106o57) abstractC12724f57;
            String strC = C(abstractC18106o57);
            int iLastIndexOf = strC.lastIndexOf(46);
            String strSubstring = iLastIndexOf != -1 ? strC.substring(iLastIndexOf) : "";
            if (strSubstring.length() <= 1) {
                strSubstring = D(abstractC18106o57.i);
            }
            if (strSubstring.length() <= 1) {
                return abstractC18106o57.m + "_" + abstractC18106o57.c;
            }
            return abstractC18106o57.m + "_" + abstractC18106o57.c + strSubstring;
        }
        if (abstractC12724f57 instanceof C12154e78) {
            C12154e78 c12154e78 = (C12154e78) abstractC12724f57;
            return Utilities.a(c12154e78.b) + Separators.DOT + C21457d.e0(c12154e78.b, K(c12154e78.f));
        }
        if (abstractC12724f57 instanceof AbstractC11500d67) {
            AbstractC11500d67 abstractC11500d67 = (AbstractC11500d67) abstractC12724f57;
            AbstractC20488s57 abstractC20488s57 = abstractC11500d67.c;
            if (abstractC20488s57 == null || (abstractC20488s57 instanceof C19318q87)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(abstractC11500d67.c.c);
            sb.append("_");
            sb.append(abstractC11500d67.c.d);
            sb.append(Separators.DOT);
            if (str2 == null) {
                str2 = "jpg";
            }
            sb.append(str2);
            return sb.toString();
        }
        if (abstractC12724f57 instanceof C5432Jh7) {
            C5432Jh7 c5432Jh7 = (C5432Jh7) abstractC12724f57;
            AbstractC20488s57 abstractC20488s572 = c5432Jh7.d;
            if (abstractC20488s572 == null || (abstractC20488s572 instanceof C19318q87)) {
                return "";
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(c5432Jh7.d.c);
            sb2.append("_");
            sb2.append(c5432Jh7.d.d);
            sb2.append(Separators.DOT);
            if (str2 == null) {
                str2 = "mp4";
            }
            sb2.append(str2);
            return sb2.toString();
        }
        if (abstractC12724f57 instanceof AbstractC20488s57) {
            if (abstractC12724f57 instanceof C19318q87) {
                return "";
            }
            AbstractC20488s57 abstractC20488s573 = (AbstractC20488s57) abstractC12724f57;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(abstractC20488s573.c);
            sb3.append("_");
            sb3.append(abstractC20488s573.d);
            sb3.append(Separators.DOT);
            if (str2 == null) {
                str2 = "jpg";
            }
            sb3.append(str2);
            return sb3.toString();
        }
        if (abstractC12724f57 instanceof AbstractC20852si7) {
            if (str == null) {
                str = "s";
            }
            AbstractC20852si7 abstractC20852si7 = (AbstractC20852si7) abstractC12724f57;
            if (abstractC20852si7.e != null) {
                return "s".equals(str) ? v(abstractC20852si7.e, str2) : v(abstractC20852si7.f, str2);
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append(abstractC20852si7.d);
            sb4.append("_");
            sb4.append(str);
            sb4.append(Separators.DOT);
            if (str2 == null) {
                str2 = "jpg";
            }
            sb4.append(str2);
            return sb4.toString();
        }
        if (!(abstractC12724f57 instanceof AbstractC16333l57)) {
            return "";
        }
        AbstractC16333l57 abstractC16333l57 = (AbstractC16333l57) abstractC12724f57;
        if (abstractC16333l57.d != null) {
            return "s".equals(str) ? v(abstractC16333l57.d, str2) : v(abstractC16333l57.e, str2);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(abstractC16333l57.h);
        sb5.append("_");
        sb5.append(str);
        sb5.append(Separators.DOT);
        if (str2 == null) {
            str2 = "jpg";
        }
        sb5.append(str2);
        return sb5.toString();
    }

    public static AbstractC11500d67 y(ArrayList arrayList, int i2) {
        return z(arrayList, i2, false);
    }

    public static AbstractC11500d67 z(ArrayList arrayList, int i2, boolean z) {
        return A(arrayList, i2, z, null, false);
    }

    public C8082Ul2 E() {
        return this.c;
    }

    public int G(Object obj) {
        int i2 = this.g;
        this.g = i2 + 1;
        this.h.put(Integer.valueOf(i2), obj);
        return i2;
    }

    public Object L(int i2) {
        return this.h.get(Integer.valueOf(i2));
    }

    public File M(AbstractC12724f57 abstractC12724f57) {
        return O(abstractC12724f57, null, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.io.File N(ir.nasim.AbstractC12724f57 r11, java.lang.String r12, java.lang.String r13, boolean r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4278El2.N(ir.nasim.f57, java.lang.String, java.lang.String, boolean, boolean):java.io.File");
    }

    public File O(AbstractC12724f57 abstractC12724f57, String str, boolean z) {
        return N(abstractC12724f57, null, str, z, true);
    }

    public File P(AbstractC12724f57 abstractC12724f57, String str, boolean z, boolean z2) {
        return N(abstractC12724f57, null, str, z, z2);
    }

    public File Q(AbstractC12724f57 abstractC12724f57, boolean z) {
        return O(abstractC12724f57, null, z);
    }

    public File R(L57 l57) {
        return S(l57, true);
    }

    public File S(L57 l57, boolean z) {
        AbstractC11500d67 abstractC11500d67Y;
        AbstractC11500d67 abstractC11500d67A;
        AbstractC11500d67 abstractC11500d67Y2;
        if (l57 == null) {
            return new File("");
        }
        if (l57 instanceof C8006Uc7) {
            AbstractC10736c67 abstractC10736c67 = l57.f.i;
            if (abstractC10736c67 != null) {
                ArrayList arrayList = abstractC10736c67.h;
                if (arrayList.size() > 0 && (abstractC11500d67Y2 = y(arrayList, AbstractC21455b.g0())) != null) {
                    return P(abstractC11500d67Y2, null, false, z);
                }
            }
        } else {
            if (C10743c74.W(l57) instanceof C16046kc7) {
                return P(C10743c74.W(l57).s, null, C10743c74.W(l57).F != 0, z);
            }
            if (C10743c74.W(l57) instanceof C23255wc7) {
                ArrayList arrayList2 = C10743c74.W(l57).f.h;
                if (arrayList2.size() > 0 && (abstractC11500d67A = A(arrayList2, AbstractC21455b.g0(), false, null, true)) != null) {
                    return P(abstractC11500d67A, null, C10743c74.W(l57).F != 0, z);
                }
            } else if (C10743c74.W(l57) instanceof C5153Ic7) {
                if (C10743c74.W(l57).B.r != null) {
                    return P(C10743c74.W(l57).B.r, null, false, z);
                }
                if (C10743c74.W(l57).B.k != null) {
                    ArrayList arrayList3 = C10743c74.W(l57).B.k.h;
                    if (arrayList3.size() > 0 && (abstractC11500d67Y = y(arrayList3, AbstractC21455b.g0())) != null) {
                        return P(abstractC11500d67Y, null, false, z);
                    }
                }
            } else if (C10743c74.W(l57) instanceof C22069uc7) {
                return P(((C22069uc7) C10743c74.W(l57)).f, null, true, z);
            }
        }
        return new File("");
    }

    public boolean T(String str) {
        return str != null && this.e.containsKey(str);
    }

    public boolean U(AbstractC18106o57 abstractC18106o57, boolean z) {
        if (abstractC18106o57 != null) {
            HashMap map = this.f;
            StringBuilder sb = new StringBuilder();
            sb.append(u(abstractC18106o57));
            sb.append(z ? "p" : "");
            if (map.containsKey(sb.toString())) {
                return true;
            }
        }
        return false;
    }

    public boolean V(AbstractC18106o57 abstractC18106o57) {
        return U(abstractC18106o57, false) || U(abstractC18106o57, true);
    }

    public void Y(C24687z23 c24687z23, Object obj, String str, int i2, int i3) {
        if (c24687z23 == null) {
            return;
        }
        Z(c24687z23.h, c24687z23.t, c24687z23.f, c24687z23, obj, str, c24687z23.n(), i2, (i3 != 0 || (!c24687z23.p() && (c24687z23.j == null || c24687z23.n() != 0))) ? i3 : 1);
    }

    public void a0(AbstractC18106o57 abstractC18106o57, Object obj, int i2, int i3) {
        if (abstractC18106o57 == null) {
            return;
        }
        if (i3 == 0 && abstractC18106o57.n != null) {
            i3 = 1;
        }
        Z(abstractC18106o57, null, null, null, obj, null, 0L, i2, i3);
    }

    public void b0(C12154e78 c12154e78, int i2, int i3) {
        Z(null, c12154e78, null, null, null, null, 0L, i2, i3);
    }

    protected AbstractC23340wl2 c0(InterfaceC23930xl2 interfaceC23930xl2, AbstractC18106o57 abstractC18106o57, C24687z23 c24687z23, Object obj, long j2, boolean z, int i2) {
        return null;
    }

    public void d0(final AbstractC18106o57 abstractC18106o57, final boolean z, boolean z2) {
        if (abstractC18106o57 == null) {
            return;
        }
        if (z2) {
            AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.yl2
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.W(abstractC18106o57, z);
                }
            });
        } else {
            W(abstractC18106o57, z);
        }
    }

    public void f0(final AbstractC18106o57 abstractC18106o57, final boolean z, boolean z2) {
        if (abstractC18106o57 == null) {
            return;
        }
        if (z2) {
            AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.Al2
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.X(abstractC18106o57, z);
                }
            });
        } else {
            X(abstractC18106o57, z);
        }
    }

    public void g0(AbstractC18106o57 abstractC18106o57, boolean z) {
        if (abstractC18106o57 == null) {
            return;
        }
        String strU = u(abstractC18106o57);
        HashMap map = this.f;
        StringBuilder sb = new StringBuilder();
        sb.append(strU);
        sb.append(z ? "" : "p");
        if (map.containsKey(sb.toString())) {
            HashMap map2 = this.f;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(strU);
            sb2.append(z ? "p" : "");
            map2.put(sb2.toString(), Boolean.TRUE);
        }
    }

    /* renamed from: h0, reason: merged with bridge method [inline-methods] */
    public void X(AbstractC18106o57 abstractC18106o57, boolean z) {
        String strU = u(abstractC18106o57);
        StringBuilder sb = new StringBuilder();
        sb.append(strU);
        sb.append(z ? "p" : "");
        this.f.put(sb.toString(), Boolean.TRUE);
        e().s(ir.nasim.tgwidgets.editor.messenger.E.b1, strU);
    }

    public void j(AbstractC18106o57 abstractC18106o57) {
        l(abstractC18106o57, false);
    }

    public void l(AbstractC18106o57 abstractC18106o57, boolean z) {
        k(abstractC18106o57, null, null, null, null, z);
    }

    public void m(AbstractC20488s57 abstractC20488s57, String str) {
        n(abstractC20488s57, str, false);
    }

    public void n(AbstractC20488s57 abstractC20488s57, String str, boolean z) {
        k(null, null, abstractC20488s57, str, null, z);
    }

    public void o(C12154e78 c12154e78) {
        k(null, c12154e78, null, null, null, false);
    }

    public float x(float f, String str) {
        if (TextUtils.isEmpty(str)) {
            return 0.0f;
        }
        AbstractC18350oW3.a(this.d.get(str));
        return 0.0f;
    }

    public void r() {
    }

    private void k(AbstractC18106o57 abstractC18106o57, C12154e78 c12154e78, AbstractC20488s57 abstractC20488s57, String str, String str2, boolean z) {
    }

    public void p(int i2, AbstractC18106o57 abstractC18106o57, C12154e78 c12154e78, AbstractC20488s57 abstractC20488s57, String str, String str2) {
    }

    private void Z(AbstractC18106o57 abstractC18106o57, C12154e78 c12154e78, C18727p87 c18727p87, C24687z23 c24687z23, Object obj, String str, long j2, int i2, int i3) {
    }
}
