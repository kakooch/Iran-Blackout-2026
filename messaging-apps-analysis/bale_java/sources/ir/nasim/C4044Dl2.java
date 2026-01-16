package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.file.entity.FileReference;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: ir.nasim.Dl2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C4044Dl2 {
    private static volatile C4044Dl2 b;
    private HashMap a = null;

    /* renamed from: ir.nasim.Dl2$a */
    public interface a {
    }

    private void d(AbstractC18939pW1 abstractC18939pW1, AbstractC4761Gl2 abstractC4761Gl2, String str) {
        C19406qI3.j("BaleFileLoader", "cancelLoadFile is called!!", new Object[0]);
    }

    public static String f(AbstractC13360g57 abstractC13360g57) {
        return g(abstractC13360g57, null);
    }

    public static String g(AbstractC13360g57 abstractC13360g57, String str) {
        int iLastIndexOf;
        String str2 = "";
        if (!(abstractC13360g57 instanceof AbstractC18939pW1)) {
            if (abstractC13360g57 instanceof H95) {
                H95 h95 = (H95) abstractC13360g57;
                if (h95.b == null) {
                    return "";
                }
                StringBuilder sb = new StringBuilder();
                sb.append(h95.b.b);
                sb.append("_");
                sb.append(h95.b.c);
                sb.append(Separators.DOT);
                if (str == null) {
                    str = "jpg";
                }
                sb.append(str);
                return sb.toString();
            }
            if (!(abstractC13360g57 instanceof AbstractC4761Gl2)) {
                return "";
            }
            AbstractC4761Gl2 abstractC4761Gl2 = (AbstractC4761Gl2) abstractC13360g57;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(abstractC4761Gl2.b);
            sb2.append("_");
            sb2.append(abstractC4761Gl2.c);
            sb2.append(Separators.DOT);
            if (str == null) {
                str = "jpg";
            }
            sb2.append(str);
            return sb2.toString();
        }
        AbstractC18939pW1 abstractC18939pW1 = (AbstractC18939pW1) abstractC13360g57;
        String strK = k(abstractC18939pW1);
        String strSubstring = (strK == null || (iLastIndexOf = strK.lastIndexOf(46)) == -1) ? "" : strK.substring(iLastIndexOf);
        if (strSubstring.length() <= 1) {
            String str3 = abstractC18939pW1.d;
            if (str3 != null) {
                str3.hashCode();
                if (str3.equals("audio/ogg")) {
                    str2 = ".ogg";
                } else if (str3.equals("video/mp4")) {
                    str2 = ".mp4";
                }
            }
        } else {
            str2 = strSubstring;
        }
        if (abstractC18939pW1.g == 0) {
            if (str2.length() <= 1) {
                return abstractC18939pW1.h + "_" + abstractC18939pW1.a;
            }
            return abstractC18939pW1.h + "_" + abstractC18939pW1.a + str2;
        }
        if (str2.length() <= 1) {
            return abstractC18939pW1.h + "_" + abstractC18939pW1.a + "_" + abstractC18939pW1.g;
        }
        return abstractC18939pW1.h + "_" + abstractC18939pW1.a + "_" + abstractC18939pW1.g + str2;
    }

    public static H95 h(ArrayList arrayList, int i) {
        return i(arrayList, i, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0056 A[PHI: r7
      0x0056: PHI (r7v3 int) = (r7v1 int), (r7v1 int), (r7v1 int), (r7v5 int), (r7v5 int), (r7v5 int) binds: [B:31:0x0044, B:38:0x0054, B:36:0x0050, B:18:0x0029, B:25:0x0039, B:23:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static ir.nasim.H95 i(java.util.ArrayList r10, int r11, boolean r12) {
        /*
            r0 = 0
            if (r10 == 0) goto L5b
            boolean r1 = r10.isEmpty()
            if (r1 == 0) goto La
            goto L5b
        La:
            r1 = 0
            r2 = r1
        Lc:
            int r3 = r10.size()
            if (r1 >= r3) goto L5b
            java.lang.Object r3 = r10.get(r1)
            ir.nasim.H95 r3 = (ir.nasim.H95) r3
            if (r3 != 0) goto L1b
            goto L58
        L1b:
            r4 = -2147483648(0xffffffff80000000, double:NaN)
            r6 = 100
            if (r12 == 0) goto L3c
            int r7 = r3.d
            int r8 = r3.c
            if (r7 < r8) goto L29
            r7 = r8
        L29:
            if (r0 == 0) goto L56
            if (r11 <= r6) goto L37
            ir.nasim.Gl2 r6 = r0.b
            if (r6 == 0) goto L37
            long r8 = r6.a
            int r4 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r4 == 0) goto L56
        L37:
            if (r11 <= r2) goto L58
            if (r2 >= r7) goto L58
            goto L56
        L3c:
            int r7 = r3.c
            int r8 = r3.d
            if (r7 < r8) goto L43
            goto L44
        L43:
            r7 = r8
        L44:
            if (r0 == 0) goto L56
            if (r11 <= r6) goto L52
            ir.nasim.Gl2 r6 = r0.b
            if (r6 == 0) goto L52
            long r8 = r6.a
            int r4 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r4 == 0) goto L56
        L52:
            if (r7 > r11) goto L58
            if (r2 >= r7) goto L58
        L56:
            r0 = r3
            r2 = r7
        L58:
            int r1 = r1 + 1
            goto Lc
        L5b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4044Dl2.i(java.util.ArrayList, int, boolean):ir.nasim.H95");
    }

    public static String k(AbstractC18939pW1 abstractC18939pW1) {
        if (abstractC18939pW1 == null) {
            return "";
        }
        String str = abstractC18939pW1.c;
        if (str != null) {
            return str;
        }
        for (int i = 0; i < abstractC18939pW1.j.size(); i++) {
            AbstractC18350oW3.a(abstractC18939pW1.j.get(i));
        }
        return "";
    }

    private static QF2 l() {
        return ((InterfaceC24602yt4) C92.a(C5721Ko.b, InterfaceC24602yt4.class)).C0();
    }

    public static C4044Dl2 m() {
        C4044Dl2 c4044Dl2 = b;
        if (c4044Dl2 == null) {
            synchronized (C4044Dl2.class) {
                try {
                    c4044Dl2 = b;
                    if (c4044Dl2 == null) {
                        c4044Dl2 = new C4044Dl2();
                        b = c4044Dl2;
                    }
                } finally {
                }
            }
        }
        return c4044Dl2;
    }

    public static String n(C11507d74 c11507d74) {
        if (c11507d74 == null) {
            return null;
        }
        String str = c11507d74.y;
        String strQ = (str == null || str.isEmpty()) ? q(c11507d74) : c11507d74.y;
        if (strQ != null) {
            return strQ.substring(strQ.lastIndexOf(Separators.SLASH) + 1);
        }
        if (c11507d74.u0()) {
            String str2 = c11507d74.i() + "_" + c11507d74.U() + ".jpg";
            if (new File(m().j(4).getAbsolutePath() + Separators.SLASH + str2).exists()) {
                return str2;
            }
            return null;
        }
        if (c11507d74.t0()) {
            return c11507d74.i() + "_" + c11507d74.U() + ".mp3";
        }
        if (!c11507d74.v0()) {
            return null;
        }
        String str3 = c11507d74.i() + "_" + c11507d74.U() + ".mp4";
        if (new File(m().j(2).getAbsolutePath() + Separators.SLASH + str3).exists()) {
            return str3;
        }
        return null;
    }

    public static File o(AbstractC13360g57 abstractC13360g57, String str, boolean z) {
        File fileJ;
        if (z) {
            fileJ = m().j(4);
        } else if (abstractC13360g57 instanceof AbstractC18939pW1) {
            AbstractC18939pW1 abstractC18939pW1 = (AbstractC18939pW1) abstractC13360g57;
            fileJ = abstractC18939pW1.i != null ? m().j(4) : C11507d74.y0(abstractC18939pW1) ? m().j(1) : C11507d74.w0(abstractC18939pW1) ? m().j(2) : m().j(3);
        } else if (abstractC13360g57 instanceof H95) {
            H95 h95 = (H95) abstractC13360g57;
            AbstractC4761Gl2 abstractC4761Gl2 = h95.b;
            fileJ = (abstractC4761Gl2 == null || abstractC4761Gl2.d != null || (abstractC4761Gl2.b == -2147483648L && abstractC4761Gl2.c < 0) || h95.e < 0) ? m().j(4) : m().j(0);
        } else if (abstractC13360g57 instanceof AbstractC4761Gl2) {
            AbstractC4761Gl2 abstractC4761Gl22 = (AbstractC4761Gl2) abstractC13360g57;
            fileJ = (abstractC4761Gl22.d != null || (abstractC4761Gl22.b == -2147483648L && abstractC4761Gl22.c < 0)) ? m().j(4) : m().j(0);
        } else {
            fileJ = null;
        }
        return fileJ == null ? new File("") : new File(fileJ, g(abstractC13360g57, str));
    }

    public static File p(AbstractC13360g57 abstractC13360g57, boolean z) {
        return o(abstractC13360g57, null, z);
    }

    public static String q(C11507d74 c11507d74) {
        if (c11507d74 == null) {
            return null;
        }
        String str = c11507d74.y;
        if (str != null && !str.isEmpty()) {
            return c11507d74.y;
        }
        C24967zW1 c24967zW1H = c11507d74.H();
        if (c24967zW1H.z() instanceof C4512Fl2) {
            return ((C4512Fl2) c24967zW1H.z()).c;
        }
        if (c24967zW1H.z() instanceof C11920dm2) {
            try {
                final FileReference fileReferenceB = ((C11920dm2) c24967zW1H.z()).b();
                C10405bZ1 c10405bZ1 = (C10405bZ1) AbstractC24549yo1.b(new UA2() { // from class: ir.nasim.zl2
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C4044Dl2.s(fileReferenceB, (InterfaceC20295rm1) obj);
                    }
                });
                if (c10405bZ1 == null) {
                    return null;
                }
                InterfaceC3346Am2 interfaceC3346Am2R = KN6.r(c10405bZ1.q());
                boolean zA = interfaceC3346Am2R.a();
                int iF = interfaceC3346Am2R.f();
                if (zA && iF == c10405bZ1.getFileSize()) {
                    return c10405bZ1.q();
                }
                return null;
            } catch (Exception e) {
                C19406qI3.d("baleMessages", e);
            }
        }
        return null;
    }

    public static String r(J44 j44) {
        if (j44 != null && j44.H() != null) {
            C24967zW1 c24967zW1H = j44.H();
            if (c24967zW1H.z() instanceof C4512Fl2) {
                return ((C4512Fl2) c24967zW1H.z()).c;
            }
            if (c24967zW1H.z() instanceof C11920dm2) {
                try {
                    C11920dm2 c11920dm2 = (C11920dm2) c24967zW1H.z();
                    final FileReference fileReferenceB = c11920dm2.b();
                    C10405bZ1 c10405bZ1 = (C10405bZ1) AbstractC24549yo1.b(new UA2() { // from class: ir.nasim.Bl2
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C4044Dl2.t(fileReferenceB, (InterfaceC20295rm1) obj);
                        }
                    });
                    if (c10405bZ1 == null) {
                        return null;
                    }
                    InterfaceC3346Am2 interfaceC3346Am2R = KN6.r(c10405bZ1.q());
                    boolean zA = interfaceC3346Am2R.a();
                    int iF = interfaceC3346Am2R.f();
                    if (zA && iF == c11920dm2.f()) {
                        return c10405bZ1.q();
                    }
                    return null;
                } catch (Exception e) {
                    C19406qI3.d("baleMessages", e);
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object s(FileReference fileReference, InterfaceC20295rm1 interfaceC20295rm1) {
        return l().o(fileReference, interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object t(FileReference fileReference, InterfaceC20295rm1 interfaceC20295rm1) {
        return l().o(fileReference, interfaceC20295rm1);
    }

    public void c(AbstractC18939pW1 abstractC18939pW1) {
        d(abstractC18939pW1, null, null);
    }

    public void e(AbstractC4761Gl2 abstractC4761Gl2, String str) {
        d(null, abstractC4761Gl2, str);
    }

    public File j(int i) {
        File file = (File) this.a.get(Integer.valueOf(i));
        if (file == null && i != 4) {
            file = (File) this.a.get(4);
        }
        try {
            if (!file.isDirectory()) {
                file.mkdirs();
            }
        } catch (Exception unused) {
        }
        return file;
    }

    public void u(C11507d74 c11507d74, AbstractC18939pW1 abstractC18939pW1, AbstractC4761Gl2 abstractC4761Gl2, String str, int i, boolean z, boolean z2) {
        C19406qI3.j("BaleFileLoader", "loadFile is called!!", new Object[0]);
    }

    public void v(C11507d74 c11507d74, AbstractC18939pW1 abstractC18939pW1, boolean z, boolean z2) {
        u(c11507d74, abstractC18939pW1, null, null, 0, z, z2 || !(abstractC18939pW1 == null || abstractC18939pW1.i == null));
    }

    public void w(C11507d74 c11507d74, AbstractC4761Gl2 abstractC4761Gl2, String str, int i, boolean z) {
        u(c11507d74, null, abstractC4761Gl2, str, i, true, z || i == 0 || !(abstractC4761Gl2 == null || abstractC4761Gl2.d == null));
    }

    public void y(HashMap map) {
        this.a = map;
    }

    public void x(a aVar) {
    }
}
