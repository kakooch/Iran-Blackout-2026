package ir.nasim;

import android.text.TextUtils;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC14815iX3;
import ir.nasim.features.media.components.PhotoViewerAbs;
import ir.nasim.tgwidgets.editor.messenger.MediaController;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: ir.nasim.iX3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC14815iX3 {
    public static a a;
    private static Runnable b;
    private static final String[] c = {"_id", "bucket_id", "bucket_display_name", "_data", "date_added", "orientation"};
    private static final String[] d = {"_id", "bucket_id", "bucket_display_name", "_data", "date_added"};

    /* renamed from: ir.nasim.iX3$a */
    public static class a {
        public String a;
        public b b;
        public ArrayList c = new ArrayList();
        public HashMap d = new HashMap();
        public boolean e;

        public a(String str, b bVar, boolean z) {
            this.a = str;
            this.b = bVar;
            this.e = z;
        }

        public void a(b bVar) {
            this.c.add(bVar);
            this.d.put(Integer.valueOf(bVar.u), bVar);
        }
    }

    /* renamed from: ir.nasim.iX3$b */
    public static class b extends MediaController.m {
        public ArrayList H;

        public b(int i, int i2, long j, String str, int i3, boolean z) {
            super(i, i2, j, str, i3, z, 0, 0, 0L);
            this.H = new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ir.nasim.iX3$c */
    static class c {
        private final int a;
        private final ArrayList b;
        private final Integer c;
        private final ArrayList d;
        private final Integer e;
        private final a f;

        public c(int i, ArrayList arrayList, Integer num, ArrayList arrayList2, Integer num2, a aVar) {
            this.a = i;
            this.b = arrayList;
            this.c = num;
            this.d = arrayList2;
            this.e = num2;
            this.f = aVar;
        }

        public ArrayList a() {
            return this.b;
        }

        public a b() {
            return this.f;
        }

        public Integer c() {
            return this.c;
        }

        public Integer d() {
            return this.e;
        }

        public int e() {
            return this.a;
        }

        public ArrayList f() {
            return this.d;
        }
    }

    private static void d(final int i, final ArrayList arrayList, final Integer num, final ArrayList arrayList2, final Integer num2, final a aVar, int i2) {
        Runnable runnable = b;
        if (runnable != null) {
            AbstractC7426Rr.w(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: ir.nasim.hX3
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC14815iX3.i(i, arrayList, num, arrayList2, num2, aVar);
            }
        };
        b = runnable2;
        AbstractC7426Rr.Q(runnable2, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(c cVar) {
        d(cVar.e(), cVar.a(), cVar.c(), cVar.f(), cVar.d(), cVar.b(), 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String f(android.net.Uri r9) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "_display_name"
            java.lang.String r1 = r9.getScheme()
            r2 = 0
            if (r1 == 0) goto L51
            java.lang.String r1 = r9.getScheme()
            java.lang.String r3 = "content"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L51
            android.content.Context r1 = ir.nasim.C5721Ko.b     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
            android.content.ContentResolver r3 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
            java.lang.String[] r5 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
            r7 = 0
            r8 = 0
            r6 = 0
            r4 = r9
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
            boolean r3 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            if (r3 == 0) goto L3b
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            java.lang.String r2 = r1.getString(r0)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            goto L3b
        L36:
            r9 = move-exception
            r2 = r1
            goto L4b
        L39:
            r0 = move-exception
            goto L43
        L3b:
            r1.close()
            goto L51
        L3f:
            r9 = move-exception
            goto L4b
        L41:
            r0 = move-exception
            r1 = r2
        L43:
            java.lang.String r3 = "baleMessages"
            ir.nasim.C19406qI3.d(r3, r0)     // Catch: java.lang.Throwable -> L36
            if (r1 == 0) goto L51
            goto L3b
        L4b:
            if (r2 == 0) goto L50
            r2.close()
        L50:
            throw r9
        L51:
            if (r2 != 0) goto L6f
            java.lang.String r0 = r9.getPath()
            if (r0 != 0) goto L5f
            java.lang.String r9 = r9.toString()
            r2 = r9
            goto L60
        L5f:
            r2 = r0
        L60:
            r9 = 47
            int r9 = r2.lastIndexOf(r9)
            r0 = -1
            if (r9 == r0) goto L6f
            int r9 = r9 + 1
            java.lang.String r2 = r2.substring(r9)
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC14815iX3.f(android.net.Uri):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(14:0|2|160|3|(2:5|(21:190|7|8|184|9|10|170|11|12|158|13|14|(5:17|(2:21|197)(7:22|(3:24|182|25)(1:30)|31|(2:33|(1:39)(1:38))|40|41|196)|42|188|15)|195|(2:176|58)|63|174|70|(3:156|72|(7:180|74|75|(5:78|(2:82|194)(6:83|(7:85|86|172|87|88|162|89)(1:96)|97|(2:99|(1:105)(1:104))(1:106)|107|193)|108|186|76)|192|109|(2:150|119))(3:114|115|(0)))(2:115|(0))|132|133)(1:52))(1:56)|53|(0)|63|174|70|(0)(0)|132|133|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0298, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0299, code lost:
    
        r3 = r18;
        r2 = r19;
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0284 A[PHI: r1
      0x0284: PHI (r1v26 android.database.Cursor) = (r1v4 android.database.Cursor), (r1v12 android.database.Cursor) binds: [B:71:0x0184, B:114:0x0282] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x028c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0186 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0177 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0163 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static ir.nasim.AbstractC14815iX3.c g(int r35) {
        /*
            Method dump skipped, instructions count: 720
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC14815iX3.g(int):ir.nasim.iX3$c");
    }

    public static boolean h(J44 j44) {
        try {
            if (!(j44.F() instanceof C24967zW1) || (j44.F() instanceof J08) || TextUtils.isEmpty(((C24967zW1) j44.F()).x())) {
                return false;
            }
            return C25056zf4.b(((C24967zW1) j44.F()).x());
        } catch (Exception e) {
            C19406qI3.d("MediaControllerUtility", e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(int i, ArrayList arrayList, Integer num, ArrayList arrayList2, Integer num2, a aVar) {
        if (PhotoViewerAbs.getInstance().isVisible()) {
            d(i, arrayList, num, arrayList2, num2, aVar, AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
            return;
        }
        b = null;
        a = aVar;
        C15225jD4.b().c(C15225jD4.w, Integer.valueOf(i), arrayList, num, arrayList2, num2);
    }

    public static void k() {
        l(0);
    }

    public static void l(final int i) {
        SZ.e(new C9248Zc6(new InterfaceC7298Rc6() { // from class: ir.nasim.fX3
            @Override // ir.nasim.InterfaceC7298Rc6
            public final Object run() {
                return AbstractC14815iX3.g(i);
            }
        }).h(EnumC11723dV1.IO).g(new InterfaceC5620Kc6() { // from class: ir.nasim.gX3
            @Override // ir.nasim.InterfaceC5620Kc6
            public final void onSuccess(Object obj) {
                AbstractC14815iX3.e((AbstractC14815iX3.c) obj);
            }
        }));
    }
}
