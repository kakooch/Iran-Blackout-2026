package ir.nasim;

import android.gov.nist.core.Separators;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.SystemFonts;
import android.os.Build;
import android.text.TextUtils;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class LU4 {
    public static final LU4 g;
    public static final LU4 h;
    public static final LU4 i;
    public static final LU4 j;
    public static final LU4 k;
    public static final LU4 l;
    public static final LU4 m;
    public static final LU4 n;
    public static final LU4 o;
    public static final LU4 p;
    public static final LU4 q;
    public static final List r;
    private static final List s;
    private static List t;
    public static boolean u;
    private final String a;
    private final String b;
    private final String c;
    private final Typeface d;
    private final c e;
    private final Font f;

    static class a {
        String a;
        ArrayList b = new ArrayList();

        a() {
        }

        public b a() {
            for (int i = 0; i < this.b.size(); i++) {
                if ("Bold".equalsIgnoreCase(((b) this.b.get(i)).c)) {
                    return (b) this.b.get(i);
                }
            }
            return null;
        }

        public b b() {
            b bVar;
            int i = 0;
            while (true) {
                if (i >= this.b.size()) {
                    bVar = null;
                    break;
                }
                if ("Regular".equalsIgnoreCase(((b) this.b.get(i)).c)) {
                    bVar = (b) this.b.get(i);
                    break;
                }
                i++;
            }
            return (bVar != null || this.b.isEmpty()) ? bVar : (b) this.b.get(0);
        }
    }

    static class b {
        Font a;
        String b;
        String c;

        b() {
        }

        public String a() {
            if ("Regular".equals(this.c) || TextUtils.isEmpty(this.c)) {
                return this.b;
            }
            return this.b + Separators.SP + this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class c {
        private final a a;
        private Typeface b;

        public interface a {
            Typeface a();
        }

        public c(a aVar) {
            this.a = aVar;
        }

        public Typeface a() {
            if (this.b == null) {
                this.b = this.a.a();
            }
            return this.b;
        }
    }

    private static class d {
        final int a;
        final int b;
        final int c;
        final int d;
        final int e;
        final int f;

        public d(RandomAccessFile randomAccessFile) {
            this.a = randomAccessFile.readUnsignedShort();
            this.b = randomAccessFile.readUnsignedShort();
            this.c = randomAccessFile.readUnsignedShort();
            this.d = randomAccessFile.readUnsignedShort();
            this.e = randomAccessFile.readUnsignedShort();
            this.f = randomAccessFile.readUnsignedShort();
        }

        public String a(RandomAccessFile randomAccessFile, int i) throws IOException {
            randomAccessFile.seek(i + this.f);
            byte[] bArr = new byte[this.e];
            randomAccessFile.read(bArr);
            return new String(bArr, this.b == 1 ? StandardCharsets.UTF_16BE : StandardCharsets.UTF_8);
        }
    }

    static {
        LU4 lu4 = new LU4("raviSemiBold", "PhotoEditorTypefaceBaleRaviSemiBold", new c(new c.a() { // from class: ir.nasim.EU4
            @Override // ir.nasim.LU4.c.a
            public final Typeface a() {
                return LU4.u();
            }
        }));
        g = lu4;
        LU4 lu42 = new LU4("raviBlack", "PhotoEditorTypefaceBaleRaviBlack", new c(new c.a() { // from class: ir.nasim.GU4
            @Override // ir.nasim.LU4.c.a
            public final Typeface a() {
                return LU4.v();
            }
        }));
        h = lu42;
        LU4 lu43 = new LU4("iransans", "PhotoEditorTypefaceBaleIransans", new c(new c.a() { // from class: ir.nasim.HU4
            @Override // ir.nasim.LU4.c.a
            public final Typeface a() {
                return C6011Lu2.h();
            }
        }));
        i = lu43;
        LU4 lu44 = new LU4("lalezar", "PhotoEditorTypefaceBaleLalezar", new c(new c.a() { // from class: ir.nasim.IU4
            @Override // ir.nasim.LU4.c.a
            public final Typeface a() {
                return LU4.w();
            }
        }));
        j = lu44;
        LU4 lu45 = new LU4("ketab", "PhotoEditorTypefaceBaleKetab", new c(new c.a() { // from class: ir.nasim.JU4
            @Override // ir.nasim.LU4.c.a
            public final Typeface a() {
                return LU4.x();
            }
        }));
        k = lu45;
        LU4 lu46 = new LU4("nastaligh", "PhotoEditorTypefaceBaleNastaligh", new c(new c.a() { // from class: ir.nasim.KU4
            @Override // ir.nasim.LU4.c.a
            public final Typeface a() {
                return LU4.y();
            }
        }));
        l = lu46;
        LU4 lu47 = new LU4("paeez", "PhotoEditorTypefaceBalePaeez", new c(new c.a() { // from class: ir.nasim.xU4
            @Override // ir.nasim.LU4.c.a
            public final Typeface a() {
                return LU4.z();
            }
        }));
        m = lu47;
        LU4 lu48 = new LU4("ordibehesht", "PhotoEditorTypefaceBaleOrdibehesht", new c(new c.a() { // from class: ir.nasim.yU4
            @Override // ir.nasim.LU4.c.a
            public final Typeface a() {
                return LU4.A();
            }
        }));
        n = lu48;
        LU4 lu49 = new LU4("roboto", "PhotoEditorTypefaceRoboto", new c(new c.a() { // from class: ir.nasim.zU4
            @Override // ir.nasim.LU4.c.a
            public final Typeface a() {
                return LU4.B();
            }
        }));
        o = lu49;
        LU4 lu410 = new LU4("italic", "PhotoEditorTypefaceItalic", new c(new c.a() { // from class: ir.nasim.AU4
            @Override // ir.nasim.LU4.c.a
            public final Typeface a() {
                return LU4.C();
            }
        }));
        p = lu410;
        LU4 lu411 = new LU4("serif", "PhotoEditorTypefaceSerif", new c(new c.a() { // from class: ir.nasim.FU4
            @Override // ir.nasim.LU4.c.a
            public final Typeface a() {
                return LU4.D();
            }
        }));
        q = lu411;
        r = Arrays.asList(lu4, lu42, lu43, lu44, lu45, lu46, lu47, lu48, lu49, lu410, lu411);
        s = Arrays.asList("Google Sans", "Dancing Script");
    }

    LU4(String str, String str2, c cVar) {
        this.a = str;
        this.b = str2;
        this.c = null;
        this.d = null;
        this.e = cVar;
        this.f = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Typeface A() {
        return AbstractC21455b.q0("fonts/Ordibehesht.ttf");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Typeface B() {
        return AbstractC21455b.q0("fonts/rmedium.ttf");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Typeface C() {
        return AbstractC21455b.q0("fonts/rmediumitalic.ttf");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Typeface D() {
        return Typeface.create("serif", 1);
    }

    private static void E() {
        if (t != null || u) {
            return;
        }
        u = true;
        Utilities.g.i(new Runnable() { // from class: ir.nasim.BU4
            @Override // java.lang.Runnable
            public final void run() {
                LU4.s();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static ir.nasim.LU4.b F(android.graphics.fonts.Font r9) throws java.lang.Throwable {
        /*
            r0 = 0
            if (r9 != 0) goto L4
            return r0
        L4:
            java.io.File r1 = ir.nasim.AbstractC23178wU4.a(r9)
            if (r1 != 0) goto Lb
            return r0
        Lb:
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            java.lang.String r3 = "r"
            r2.<init>(r1, r3)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            int r1 = r2.readInt()     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            r3 = 65536(0x10000, float:9.1835E-41)
            if (r1 == r3) goto L23
            r3 = 1330926671(0x4f54544f, float:3.562295E9)
            if (r1 == r3) goto L23
            r2.close()     // Catch: java.lang.Exception -> L22
        L22:
            return r0
        L23:
            int r1 = r2.readUnsignedShort()     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            r3 = 6
            r2.skipBytes(r3)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            r3 = 0
            r4 = r3
        L2d:
            if (r4 >= r1) goto L9f
            int r5 = r2.readInt()     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            r6 = 4
            r2.skipBytes(r6)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            int r6 = r2.readInt()     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            r2.readInt()     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            r7 = 1851878757(0x6e616d65, float:1.7441594E28)
            if (r5 != r7) goto L9c
            int r1 = r6 + 2
            long r4 = (long) r1     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            r2.seek(r4)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            int r1 = r2.readUnsignedShort()     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            int r4 = r2.readUnsignedShort()     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            java.util.HashMap r5 = new java.util.HashMap     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            r5.<init>()     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
        L56:
            if (r3 >= r1) goto L6e
            ir.nasim.LU4$d r7 = new ir.nasim.LU4$d     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            r7.<init>(r2)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            int r8 = r7.d     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            r5.put(r8, r7)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            int r3 = r3 + 1
            goto L56
        L69:
            r9 = move-exception
            r0 = r2
            goto Lae
        L6c:
            r9 = move-exception
            goto La7
        L6e:
            ir.nasim.LU4$b r1 = new ir.nasim.LU4$b     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            r1.<init>()     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            r1.a = r9     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            int r6 = r6 + r4
            r9 = 1
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            java.lang.Object r9 = r5.get(r9)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            ir.nasim.LU4$d r9 = (ir.nasim.LU4.d) r9     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            java.lang.String r9 = G(r2, r6, r9)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            r1.b = r9     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            r9 = 2
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            java.lang.Object r9 = r5.get(r9)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            ir.nasim.LU4$d r9 = (ir.nasim.LU4.d) r9     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            java.lang.String r9 = G(r2, r6, r9)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            r1.c = r9     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6c
            r2.close()     // Catch: java.lang.Exception -> L9b
        L9b:
            return r1
        L9c:
            int r4 = r4 + 1
            goto L2d
        L9f:
            r2.close()     // Catch: java.lang.Exception -> Lad
            goto Lad
        La3:
            r9 = move-exception
            goto Lae
        La5:
            r9 = move-exception
            r2 = r0
        La7:
            ir.nasim.AbstractC6403Nl2.d(r9)     // Catch: java.lang.Throwable -> L69
            if (r2 == 0) goto Lad
            goto L9f
        Lad:
            return r0
        Lae:
            if (r0 == 0) goto Lb3
            r0.close()     // Catch: java.lang.Exception -> Lb3
        Lb3:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.LU4.F(android.graphics.fonts.Font):ir.nasim.LU4$b");
    }

    private static String G(RandomAccessFile randomAccessFile, int i2, d dVar) {
        if (dVar == null) {
            return null;
        }
        return dVar.a(randomAccessFile, i2);
    }

    public static List n() {
        List list = t;
        if (list != null) {
            return list;
        }
        E();
        return r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void r(ArrayList arrayList) {
        t = arrayList;
        u = false;
        ir.nasim.tgwidgets.editor.messenger.E.j().s(ir.nasim.tgwidgets.editor.messenger.E.a4, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s() {
        b bVarF;
        final ArrayList arrayList = new ArrayList(r);
        if (Build.VERSION.SDK_INT >= 29) {
            Iterator it = SystemFonts.getAvailableFonts().iterator();
            HashMap map = new HashMap();
            while (it.hasNext()) {
                Font fontA = AbstractC22582vU4.a(it.next());
                if (!fontA.getFile().getName().contains("Noto") && (bVarF = F(fontA)) != null) {
                    a aVar = (a) map.get(bVarF.b);
                    if (aVar == null) {
                        aVar = new a();
                        String str = bVarF.b;
                        aVar.a = str;
                        map.put(str, aVar);
                    }
                    aVar.b.add(bVarF);
                }
            }
            Iterator it2 = s.iterator();
            while (it2.hasNext()) {
                a aVar2 = (a) map.get((String) it2.next());
                if (aVar2 != null) {
                    b bVarA = aVar2.a();
                    if (bVarA == null) {
                        bVarA = aVar2.b();
                    }
                    if (bVarA != null) {
                        arrayList.add(new LU4(bVarA.a, bVarA.a()));
                    }
                }
            }
        }
        AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.CU4
            @Override // java.lang.Runnable
            public final void run() {
                LU4.r(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Typeface t(Font font) {
        return Typeface.createFromFile(font.getFile());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Typeface u() {
        return AbstractC21455b.q0("fonts/Ravi-SemiBold.ttf");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Typeface v() {
        return AbstractC21455b.q0("fonts/Ravi-Black.ttf");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Typeface w() {
        return AbstractC21455b.q0("fonts/Lalezar.ttf");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Typeface x() {
        return AbstractC21455b.q0("fonts/Ketab.ttf");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Typeface y() {
        return AbstractC21455b.q0("fonts/IranNastaliq.ttf");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Typeface z() {
        return AbstractC21455b.q0("fonts/Paeez.ttf");
    }

    public String o() {
        return this.a;
    }

    public String p() {
        String str = this.c;
        return str != null ? str : FH3.D(this.b);
    }

    public Typeface q() {
        c cVar = this.e;
        return cVar != null ? cVar.a() : this.d;
    }

    LU4(final Font font, String str) {
        this.a = str;
        this.c = str;
        this.b = null;
        this.d = null;
        this.e = new c(new c.a() { // from class: ir.nasim.DU4
            @Override // ir.nasim.LU4.c.a
            public final Typeface a() {
                return LU4.t(font);
            }
        });
        this.f = font;
    }
}
