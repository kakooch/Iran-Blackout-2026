package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.gov.nist.core.Separators;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.ThumbnailUtils;
import android.os.AsyncTask;
import android.os.Environment;
import ir.nasim.AbstractC10754c85;
import ir.nasim.AbstractC4761Gl2;
import ir.nasim.C17481n23;
import ir.nasim.C4044Dl2;
import ir.nasim.H95;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: ir.nasim.n23, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C17481n23 {
    private static byte[] q = null;
    private static byte[] r = null;
    private static byte[] s = new byte[12];
    private static byte[] t = new byte[12];
    private static boolean u = false;
    private static volatile C17481n23 v;
    private HashMap a = new HashMap();
    private HashMap c = new HashMap();
    private HashMap d = new HashMap();
    private HashMap e = new HashMap();
    private HashMap f = new HashMap();
    private HashMap g = new HashMap();
    private LinkedList h = new LinkedList();
    private ConcurrentHashMap i = new ConcurrentHashMap();
    private HashMap j = new HashMap();
    private int k = 0;
    private String l = null;
    private volatile long m = 0;
    private int n = 0;
    private long o = 0;
    private File p = null;
    private AbstractC16478lL3 b = new a(Math.min(15, ((ActivityManager) C5721Ko.b.getSystemService("activity")).getMemoryClass() / 7) * 1048576);

    /* renamed from: ir.nasim.n23$a */
    class a extends AbstractC16478lL3 {
        a(int i) {
            super(i);
        }

        @Override // ir.nasim.AbstractC16478lL3
        protected void a(String str, BitmapDrawable bitmapDrawable) {
            if (C17481n23.this.l == null || str == null || !C17481n23.this.l.equals(str)) {
                Integer num = (Integer) C17481n23.this.a.get(str);
                if (num == null || num.intValue() == 0) {
                    Bitmap bitmap = bitmapDrawable.getBitmap();
                    if (bitmap.isRecycled()) {
                        return;
                    }
                    bitmap.recycle();
                }
            }
        }

        @Override // ir.nasim.AbstractC16478lL3
        protected int g(BitmapDrawable bitmapDrawable) {
            return bitmapDrawable.getBitmap().getByteCount();
        }
    }

    /* renamed from: ir.nasim.n23$b */
    class b implements C4044Dl2.a {
        b() {
        }
    }

    /* renamed from: ir.nasim.n23$c */
    class c extends BroadcastReceiver {

        /* renamed from: ir.nasim.n23$c$a */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C17481n23.this.E();
            }
        }

        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C19406qI3.b("baleMessages", "file system changed");
            a aVar = new a();
            if ("android.intent.action.MEDIA_UNMOUNTED".equals(intent.getAction())) {
                AbstractC7426Rr.Q(aVar, 1000L);
            } else {
                aVar.run();
            }
        }
    }

    /* renamed from: ir.nasim.n23$d */
    class d implements Runnable {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(HashMap map) {
            C4044Dl2.m().y(map);
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            final HashMap mapH = C17481n23.this.H();
            AbstractC7426Rr.P(new Runnable() { // from class: ir.nasim.o23
                @Override // java.lang.Runnable
                public final void run() {
                    C17481n23.d.b(mapH);
                }
            });
            C17481n23.this.D();
        }
    }

    /* renamed from: ir.nasim.n23$e */
    class e implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ S23 b;

        e(int i, S23 s23) {
            this.a = i;
            this.b = s23;
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            int i;
            int i2;
            i iVar;
            int i3 = this.a;
            if (i3 == 1) {
                i2 = 0;
                i = 1;
            } else {
                i = 2;
                i2 = i3 == 2 ? 1 : 0;
            }
            while (i2 < i) {
                Integer numX = this.b.x(i2 == 0);
                if (i2 == 0) {
                    C17481n23.this.b0(numX);
                }
                if (numX != null && (iVar = (i) C17481n23.this.e.get(numX)) != null) {
                    iVar.b(this.b);
                }
                i2++;
            }
        }
    }

    /* renamed from: ir.nasim.n23$f */
    class f implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ Integer d;
        final /* synthetic */ S23 e;
        final /* synthetic */ String f;
        final /* synthetic */ String g;
        final /* synthetic */ boolean h;
        final /* synthetic */ C11507d74 i;
        final /* synthetic */ AbstractC13360g57 j;
        final /* synthetic */ boolean k;
        final /* synthetic */ boolean l;
        final /* synthetic */ int m;
        final /* synthetic */ String n;

        f(int i, String str, String str2, Integer num, S23 s23, String str3, String str4, boolean z, C11507d74 c11507d74, AbstractC13360g57 abstractC13360g57, boolean z2, boolean z3, int i2, String str5) {
            this.a = i;
            this.b = str;
            this.c = str2;
            this.d = num;
            this.e = s23;
            this.f = str3;
            this.g = str4;
            this.h = z;
            this.i = c11507d74;
            this.j = abstractC13360g57;
            this.k = z2;
            this.l = z3;
            this.m = i2;
            this.n = str5;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0043 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0051 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0092  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00ed  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x010d  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0110  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x013b  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0187  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() throws java.lang.InterruptedException {
            /*
                Method dump skipped, instructions count: 762
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17481n23.f.run():void");
        }
    }

    /* renamed from: ir.nasim.n23$g */
    class g implements Runnable {
        final /* synthetic */ String a;

        g(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            i iVar = (i) C17481n23.this.c.get(this.a);
            if (iVar == null) {
                return;
            }
            k kVar = iVar.k;
            iVar.k = C17481n23.this.new k(kVar.a, kVar.c);
            C17481n23.this.h.add(iVar.k);
            C17481n23.this.d0(false);
        }
    }

    /* renamed from: ir.nasim.n23$h */
    class h implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ int b;
        final /* synthetic */ File c;

        h(String str, int i, File file) {
            this.a = str;
            this.b = i;
            this.c = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            m mVar = (m) C17481n23.this.f.get(this.a);
            if (mVar != null) {
                C17481n23.this.N(this.b, this.c, mVar.b, mVar.c);
                C17481n23.this.f.remove(this.a);
            }
            i iVar = (i) C17481n23.this.c.get(this.a);
            if (iVar == null) {
                return;
            }
            C17481n23.this.c.remove(this.a);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < iVar.m.size(); i++) {
                String str = (String) iVar.n.get(i);
                String str2 = (String) iVar.o.get(i);
                S23 s23 = (S23) iVar.m.get(i);
                i iVar2 = (i) C17481n23.this.d.get(str);
                if (iVar2 == null) {
                    iVar2 = new i();
                    iVar2.g = this.c;
                    iVar2.a = str;
                    iVar2.j = iVar.j;
                    iVar2.i = iVar.i;
                    iVar2.d = iVar.d;
                    iVar2.l = C17481n23.this.new j(iVar2);
                    iVar2.c = str2;
                    iVar2.f = iVar.f;
                    C17481n23.this.d.put(str, iVar2);
                    arrayList.add(iVar2.l);
                }
                iVar2.a(s23, str, str2);
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (iVar.i) {
                    C17481n23.this.P().postRunnable((Runnable) arrayList.get(i2));
                } else {
                    C17481n23.this.O().postRunnable((Runnable) arrayList.get(i2));
                }
            }
        }
    }

    /* renamed from: ir.nasim.n23$i */
    private class i {
        protected String a;
        protected String b;
        protected String c;
        protected String d;
        protected AbstractC13360g57 e;
        protected boolean f;
        protected File g;
        protected File h;
        protected boolean i;
        protected String j;
        protected k k;
        protected j l;
        protected ArrayList m;
        protected ArrayList n;
        protected ArrayList o;

        /* renamed from: ir.nasim.n23$i$a */
        class a implements Runnable {
            final /* synthetic */ BitmapDrawable a;
            final /* synthetic */ ArrayList b;

            a(BitmapDrawable bitmapDrawable, ArrayList arrayList) {
                this.a = bitmapDrawable;
                this.b = arrayList;
            }

            @Override // java.lang.Runnable
            public void run() {
                BitmapDrawable bitmapDrawable = this.a;
                if (!(bitmapDrawable instanceof C8610Ws)) {
                    for (int i = 0; i < this.b.size(); i++) {
                        S23 s23 = (S23) this.b.get(i);
                        BitmapDrawable bitmapDrawable2 = this.a;
                        i iVar = i.this;
                        s23.Q(bitmapDrawable2, iVar.a, iVar.i, false);
                    }
                    return;
                }
                C8610Ws c8610Ws = (C8610Ws) bitmapDrawable;
                int i2 = 0;
                boolean z = false;
                while (i2 < this.b.size()) {
                    S23 s232 = (S23) this.b.get(i2);
                    C8610Ws c8610WsO = i2 == 0 ? c8610Ws : c8610Ws.O();
                    i iVar2 = i.this;
                    if (s232.Q(c8610WsO, iVar2.a, iVar2.i, false)) {
                        z = true;
                    }
                    i2++;
                }
                if (z) {
                    return;
                }
                ((C8610Ws) this.a).P();
            }
        }

        public void a(S23 s23, String str, String str2) {
            if (this.m.contains(s23)) {
                return;
            }
            this.m.add(s23);
            this.n.add(str);
            this.o.add(str2);
            C17481n23.this.e.put(s23.x(this.i), this);
        }

        public void b(S23 s23) throws InterruptedException {
            int i = 0;
            while (i < this.m.size()) {
                S23 s232 = (S23) this.m.get(i);
                if (s232 == null || s232 == s23) {
                    this.m.remove(i);
                    this.n.remove(i);
                    this.o.remove(i);
                    if (s232 != null) {
                        C17481n23.this.e.remove(s232.x(this.i));
                    }
                    i--;
                }
                i++;
            }
            if (this.m.size() == 0) {
                for (int i2 = 0; i2 < this.m.size(); i2++) {
                    C17481n23.this.e.remove(((S23) this.m.get(i2)).x(this.i));
                }
                this.m.clear();
                AbstractC13360g57 abstractC13360g57 = this.e;
                if (abstractC13360g57 != null) {
                    if (abstractC13360g57 instanceof AbstractC4761Gl2) {
                        C4044Dl2.m().e((AbstractC4761Gl2) this.e, this.d);
                    } else if (abstractC13360g57 instanceof AbstractC18939pW1) {
                        C4044Dl2.m().c((AbstractC18939pW1) this.e);
                    }
                }
                if (this.l != null) {
                    if (this.i) {
                        C17481n23.this.P().cancelRunnable(this.l);
                    } else {
                        C17481n23.this.O().cancelRunnable(this.l);
                    }
                    this.l.b();
                    this.l = null;
                }
                if (this.k != null) {
                    C17481n23.this.h.remove(this.k);
                    this.k.cancel(true);
                    this.k = null;
                }
                if (this.b != null) {
                    C17481n23.this.c.remove(this.b);
                }
                if (this.a != null) {
                    C17481n23.this.d.remove(this.a);
                }
            }
        }

        public void c(BitmapDrawable bitmapDrawable) {
            if (bitmapDrawable != null) {
                AbstractC7426Rr.P(new a(bitmapDrawable, new ArrayList(this.m)));
            }
            for (int i = 0; i < this.m.size(); i++) {
                C17481n23.this.e.remove(((S23) this.m.get(i)).x(this.i));
            }
            this.m.clear();
            if (this.b != null) {
                C17481n23.this.c.remove(this.b);
            }
            if (this.a != null) {
                C17481n23.this.d.remove(this.a);
            }
        }

        private i() {
            this.m = new ArrayList();
            this.n = new ArrayList();
            this.o = new ArrayList();
        }
    }

    /* renamed from: ir.nasim.n23$j */
    private class j implements Runnable {
        private Thread a;
        private final Object b = new Object();
        private i c;
        private boolean d;

        /* renamed from: ir.nasim.n23$j$a */
        class a implements Runnable {
            final /* synthetic */ BitmapDrawable a;

            /* renamed from: ir.nasim.n23$j$a$a, reason: collision with other inner class name */
            class RunnableC1405a implements Runnable {
                final /* synthetic */ BitmapDrawable a;

                RunnableC1405a(BitmapDrawable bitmapDrawable) {
                    this.a = bitmapDrawable;
                }

                @Override // java.lang.Runnable
                public void run() {
                    j.this.c.c(this.a);
                }
            }

            a(BitmapDrawable bitmapDrawable) {
                this.a = bitmapDrawable;
            }

            @Override // java.lang.Runnable
            public void run() {
                BitmapDrawable bitmapDrawableC = this.a;
                if (!(bitmapDrawableC instanceof C8610Ws)) {
                    if (bitmapDrawableC != null) {
                        bitmapDrawableC = C17481n23.this.b.c(j.this.c.a);
                        if (bitmapDrawableC == null) {
                            bitmapDrawableC = this.a;
                        } else {
                            this.a.getBitmap().recycle();
                        }
                    } else {
                        bitmapDrawableC = null;
                    }
                }
                C17481n23.this.S().postRunnable(new RunnableC1405a(bitmapDrawableC));
            }
        }

        public j(i iVar) {
            this.c = iVar;
        }

        private void c(BitmapDrawable bitmapDrawable) {
            AbstractC7426Rr.P(new a(bitmapDrawable));
        }

        public void b() {
            synchronized (this.b) {
                try {
                    this.d = true;
                    Thread thread = this.a;
                    if (thread != null) {
                        thread.interrupt();
                    }
                } catch (Exception unused) {
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:123:0x0212  */
        /* JADX WARN: Removed duplicated region for block: B:183:0x02fe  */
        /* JADX WARN: Removed duplicated region for block: B:184:0x0300  */
        /* JADX WARN: Removed duplicated region for block: B:197:0x032c  */
        /* JADX WARN: Removed duplicated region for block: B:244:0x03cd  */
        /* JADX WARN: Removed duplicated region for block: B:251:0x03e5 A[Catch: all -> 0x03c4, TryCatch #3 {all -> 0x03c4, blocks: (B:238:0x03bc, B:245:0x03cf, B:247:0x03d9, B:249:0x03df, B:251:0x03e5, B:253:0x03eb, B:259:0x0402, B:265:0x0411, B:267:0x0419, B:273:0x0438, B:268:0x0423, B:270:0x042b, B:280:0x044a, B:282:0x0452, B:286:0x046f, B:288:0x0473), top: B:315:0x03bc }] */
        /* JADX WARN: Removed duplicated region for block: B:271:0x0435  */
        /* JADX WARN: Removed duplicated region for block: B:273:0x0438 A[Catch: all -> 0x03c4, TryCatch #3 {all -> 0x03c4, blocks: (B:238:0x03bc, B:245:0x03cf, B:247:0x03d9, B:249:0x03df, B:251:0x03e5, B:253:0x03eb, B:259:0x0402, B:265:0x0411, B:267:0x0419, B:273:0x0438, B:268:0x0423, B:270:0x042b, B:280:0x044a, B:282:0x0452, B:286:0x046f, B:288:0x0473), top: B:315:0x03bc }] */
        /* JADX WARN: Removed duplicated region for block: B:304:0x048f  */
        /* JADX WARN: Removed duplicated region for block: B:305:0x0495  */
        /* JADX WARN: Removed duplicated region for block: B:319:0x0304 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:330:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0081  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 1180
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17481n23.j.run():void");
        }
    }

    /* renamed from: ir.nasim.n23$k */
    private class k extends AsyncTask {
        private i a;
        private int c;
        private long d;
        private RandomAccessFile b = null;
        private boolean e = true;
        private URLConnection f = null;

        /* renamed from: ir.nasim.n23$k$a */
        class a implements Runnable {
            final /* synthetic */ float a;

            /* renamed from: ir.nasim.n23$k$a$a, reason: collision with other inner class name */
            class RunnableC1406a implements Runnable {
                RunnableC1406a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C15225jD4.b().c(C15225jD4.t, k.this.a.b, Float.valueOf(a.this.a));
                }
            }

            a(float f) {
                this.a = f;
            }

            @Override // java.lang.Runnable
            public void run() {
                C17481n23.this.i.put(k.this.a.b, Float.valueOf(this.a));
                AbstractC7426Rr.P(new RunnableC1406a());
            }
        }

        /* renamed from: ir.nasim.n23$k$b */
        class b implements Runnable {
            final /* synthetic */ Boolean a;

            /* renamed from: ir.nasim.n23$k$b$a */
            class a implements Runnable {
                a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.a.booleanValue()) {
                        C15225jD4.b().c(C15225jD4.u, k.this.a.b);
                    } else {
                        C15225jD4.b().c(C15225jD4.v, k.this.a.b, 2);
                    }
                }
            }

            b(Boolean bool) {
                this.a = bool;
            }

            @Override // java.lang.Runnable
            public void run() {
                C17481n23.this.i.remove(k.this.a.b);
                AbstractC7426Rr.P(new a());
            }
        }

        /* renamed from: ir.nasim.n23$k$c */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C17481n23.this.d0(true);
            }
        }

        /* renamed from: ir.nasim.n23$k$d */
        class d implements Runnable {
            d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C17481n23.this.d0(true);
            }
        }

        /* renamed from: ir.nasim.n23$k$e */
        class e implements Runnable {

            /* renamed from: ir.nasim.n23$k$e$a */
            class a implements Runnable {
                a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C15225jD4.b().c(C15225jD4.v, k.this.a.b, 1);
                }
            }

            e() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C17481n23.this.i.remove(k.this.a.b);
                AbstractC7426Rr.P(new a());
            }
        }

        public k(i iVar, int i) {
            this.a = iVar;
            this.c = i;
        }

        private void e(float f) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (f != 1.0f) {
                long j = this.d;
                if (j != 0 && j >= jCurrentTimeMillis - 500) {
                    return;
                }
            }
            this.d = jCurrentTimeMillis;
            AbstractC15318jN7.d().postRunnable(new a(f));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x0127, code lost:
        
            if (r6 != (-1)) goto L94;
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x012b, code lost:
        
            if (r9.c == 0) goto L97;
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x012d, code lost:
        
            e(1.0f);
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x0133, code lost:
        
            r3 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x0134, code lost:
        
            r3 = true;
            r0 = r3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:92:0x0138, code lost:
        
            r3 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x0139, code lost:
        
            r3 = true;
            r0 = r3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:94:0x013d, code lost:
        
            r0 = r3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:0x013f, code lost:
        
            ir.nasim.C19406qI3.d("baleMessages", r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x0145, code lost:
        
            ir.nasim.C19406qI3.d("baleMessages", r0);
         */
        /* JADX WARN: Removed duplicated region for block: B:101:0x014c A[Catch: all -> 0x0152, TRY_LEAVE, TryCatch #0 {all -> 0x0152, blocks: (B:99:0x0148, B:101:0x014c), top: B:118:0x0148 }] */
        /* JADX WARN: Removed duplicated region for block: B:111:0x0162  */
        /* JADX WARN: Removed duplicated region for block: B:128:0x0158 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:132:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00a0  */
        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Boolean doInBackground(java.lang.Void... r10) {
            /*
                Method dump skipped, instructions count: 379
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17481n23.k.doInBackground(java.lang.Void[]):java.lang.Boolean");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue() || !this.e) {
                C17481n23 c17481n23 = C17481n23.this;
                i iVar = this.a;
                c17481n23.J(iVar.b, iVar.g, 0);
            } else {
                C17481n23.this.W(this.a.b);
            }
            AbstractC15318jN7.d().postRunnable(new b(bool));
            C17481n23.this.S().postRunnable(new c());
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            C17481n23.this.S().postRunnable(new d());
            AbstractC15318jN7.d().postRunnable(new e());
        }
    }

    /* renamed from: ir.nasim.n23$l */
    private class l implements Runnable {
        private File a;
        private int b;
        private AbstractC4761Gl2 c;
        private String d;

        /* renamed from: ir.nasim.n23$l$a */
        class a implements Runnable {
            final /* synthetic */ String a;

            a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                C17481n23.this.j.remove(this.a);
            }
        }

        /* renamed from: ir.nasim.n23$l$b */
        class b implements Runnable {
            final /* synthetic */ String a;
            final /* synthetic */ BitmapDrawable b;

            b(String str, BitmapDrawable bitmapDrawable) {
                this.a = str;
                this.b = bitmapDrawable;
            }

            @Override // java.lang.Runnable
            public void run() {
                l.this.c();
                String str = this.a;
                if (l.this.d != null) {
                    str = str + Separators.AT + l.this.d;
                }
                C15225jD4.b().c(C15225jD4.s, this.b, str);
                C17481n23.this.b.d(str, this.b);
            }
        }

        public l(int i, File file, AbstractC4761Gl2 abstractC4761Gl2, String str) {
            this.b = i;
            this.a = file;
            this.c = abstractC4761Gl2;
            this.d = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            AbstractC4761Gl2 abstractC4761Gl2 = this.c;
            if (abstractC4761Gl2 == null) {
                return;
            }
            C17481n23.this.S().postRunnable(new a(C4044Dl2.f(abstractC4761Gl2)));
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap bitmapZ;
            try {
                if (this.c == null) {
                    c();
                    return;
                }
                String str = this.c.b + "_" + this.c.c;
                File file = new File(C4044Dl2.m().j(4), "q_" + str + ".jpg");
                if (!file.exists() && this.a.exists()) {
                    int iMin = Math.min(SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER, Math.min(AbstractC7426Rr.C().x, AbstractC7426Rr.C().y) / 4);
                    int i = this.b;
                    if (i == 0) {
                        float f = iMin;
                        bitmapZ = C17481n23.Z(this.a.toString(), f, f, false);
                    } else if (i == 2) {
                        bitmapZ = ThumbnailUtils.createVideoThumbnail(this.a.toString(), 1);
                    } else if (i == 3) {
                        String lowerCase = this.a.toString().toLowerCase();
                        if (!lowerCase.endsWith(".jpg") && !lowerCase.endsWith(".jpeg") && !lowerCase.endsWith(".png") && !lowerCase.endsWith(".gif")) {
                            c();
                            return;
                        } else {
                            float f2 = iMin;
                            bitmapZ = C17481n23.Z(lowerCase, f2, f2, false);
                        }
                    } else {
                        bitmapZ = null;
                    }
                    if (bitmapZ == null) {
                        c();
                        return;
                    }
                    int width = bitmapZ.getWidth();
                    int height = bitmapZ.getHeight();
                    if (width != 0 && height != 0) {
                        float f3 = width;
                        float f4 = iMin;
                        float f5 = height;
                        float fMin = Math.min(f3 / f4, f5 / f4);
                        Bitmap bitmapC = AbstractC17261mg0.c(bitmapZ, (int) (f3 / fMin), (int) (f5 / fMin), true);
                        if (bitmapC != bitmapZ) {
                            bitmapZ.recycle();
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        bitmapC.compress(Bitmap.CompressFormat.JPEG, 60, fileOutputStream);
                        try {
                            fileOutputStream.close();
                        } catch (Exception e) {
                            C19406qI3.d("baleMessages", e);
                        }
                        AbstractC7426Rr.P(new b(str, new BitmapDrawable(bitmapC)));
                        return;
                    }
                    c();
                    return;
                }
                c();
            } catch (Throwable th) {
                C19406qI3.d("baleMessages", th);
                c();
            }
        }
    }

    /* renamed from: ir.nasim.n23$m */
    private class m {
        private int a;
        private AbstractC4761Gl2 b;
        private String c;

        private m() {
        }
    }

    public C17481n23() throws IOException {
        C4044Dl2.m().x(new b());
        c cVar = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
        intentFilter.addAction("android.intent.action.MEDIA_CHECKING");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_NOFS");
        intentFilter.addAction("android.intent.action.MEDIA_REMOVED");
        intentFilter.addAction("android.intent.action.MEDIA_SHARED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTABLE");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        C5721Ko.b.registerReceiver(cVar, intentFilter);
        HashMap map = new HashMap();
        File fileJ = C6906Pm2.j();
        if (!fileJ.isDirectory()) {
            try {
                fileJ.mkdirs();
            } catch (Exception e2) {
                C19406qI3.d("baleMessages", e2);
            }
        }
        try {
            new File(fileJ, ".nomedia").createNewFile();
        } catch (Exception e3) {
            C19406qI3.d("baleMessages", e3);
        }
        map.put(4, fileJ);
        C4044Dl2.m().y(map);
        E();
    }

    public static int A(Bitmap bitmap) {
        return bitmap.getAllocationByteCount();
    }

    private boolean B(File file, File file2, int i2) throws Throwable {
        File file3;
        File file4;
        byte[] bArr;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                if (i2 == 0) {
                    file4 = new File(file, "000000000_999999_temp.jpg");
                    file3 = new File(file2, "000000000_999999.jpg");
                } else if (i2 == 3) {
                    file4 = new File(file, "000000000_999999_temp.doc");
                    file3 = new File(file2, "000000000_999999.doc");
                } else if (i2 == 1) {
                    file4 = new File(file, "000000000_999999_temp.ogg");
                    file3 = new File(file2, "000000000_999999.ogg");
                } else if (i2 == 2) {
                    file4 = new File(file, "000000000_999999_temp.mp4");
                    file3 = new File(file2, "000000000_999999.mp4");
                } else {
                    file3 = null;
                    file4 = null;
                }
                bArr = new byte[1024];
                file4.createNewFile();
                randomAccessFile = new RandomAccessFile(file4, "rws");
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            randomAccessFile.write(bArr);
            randomAccessFile.close();
            boolean zRenameTo = file4.renameTo(file3);
            file4.delete();
            file3.delete();
            return zRenameTo;
        } catch (Exception e3) {
            e = e3;
            randomAccessFile2 = randomAccessFile;
            C19406qI3.d("baleMessages", e);
            if (randomAccessFile2 == null) {
                return false;
            }
            try {
                randomAccessFile2.close();
                return false;
            } catch (Exception e4) {
                C19406qI3.d("baleMessages", e4);
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (Exception e5) {
                    C19406qI3.d("baleMessages", e5);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() throws IOException {
        File externalFilesDir = C5721Ko.b.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            return;
        }
        File file = new File(externalFilesDir.getAbsolutePath() + Separators.SLASH + "Bale/cache/");
        file.mkdirs();
        try {
            new File(file, ".nomedia").createNewFile();
        } catch (IOException e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
        }
    }

    private void G(S23 s23, String str, String str2, String str3, AbstractC13360g57 abstractC13360g57, String str4, String str5, int i2, boolean z, int i3) {
        if (s23 == null || str2 == null || str == null) {
            return;
        }
        Integer numX = s23.x(i3 != 0);
        if (numX == null) {
            numX = Integer.valueOf(this.n);
            s23.Y(numX, i3 != 0);
            int i4 = this.n + 1;
            this.n = i4;
            if (i4 == Integer.MAX_VALUE) {
                this.n = 0;
            }
        }
        S().postRunnable(new f(i3, str2, str, numX, s23, str5, str4, s23.E(), s23.v(), abstractC13360g57, s23.F(), z, i2, str3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(String str, File file, int i2) {
        S().postRunnable(new h(str, i2, file));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(int i2, File file, AbstractC4761Gl2 abstractC4761Gl2, String str) {
        if ((i2 != 0 && i2 != 2 && i2 != 3) || file == null || abstractC4761Gl2 == null) {
            return;
        }
        if (((l) this.j.get(C4044Dl2.f(abstractC4761Gl2))) == null) {
            V().postRunnable(new l(i2, file, abstractC4761Gl2, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NZ O() {
        return C14483hz6.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NZ P() {
        return C14483hz6.h();
    }

    public static String R(String str, String str2) {
        int iLastIndexOf = str.lastIndexOf(46);
        String strSubstring = iLastIndexOf != -1 ? str.substring(iLastIndexOf + 1) : null;
        return (strSubstring == null || strSubstring.length() == 0 || strSubstring.length() > 4) ? str2 : strSubstring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NZ S() {
        return C14483hz6.i();
    }

    public static C17481n23 T() {
        C17481n23 c17481n23 = v;
        if (c17481n23 == null) {
            synchronized (C17481n23.class) {
                try {
                    c17481n23 = v;
                    if (c17481n23 == null) {
                        c17481n23 = new C17481n23();
                        v = c17481n23;
                    }
                } finally {
                }
            }
        }
        return c17481n23;
    }

    public static H95 U(Bitmap bitmap, Long l2, Integer num) {
        if (bitmap == null) {
            return null;
        }
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        if (width == 0.0f || height == 0.0f || l2 == null || num == null) {
            return null;
        }
        AbstractC4761Gl2.a aVar = new AbstractC4761Gl2.a();
        aVar.b = l2.longValue();
        aVar.a = l2.longValue();
        aVar.c = num.intValue();
        H95.a aVar2 = new H95.a();
        aVar2.b = aVar;
        aVar2.c = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        aVar2.d = height2;
        int i2 = aVar2.c;
        if (i2 <= 100 && height2 <= 100) {
            aVar2.a = "s";
        } else if (i2 <= 320 && height2 <= 320) {
            aVar2.a = "m";
        } else if (i2 <= 800 && height2 <= 800) {
            aVar2.a = "x";
        } else if (i2 > 1280 || height2 > 1280) {
            aVar2.a = "w";
        } else {
            aVar2.a = "y";
        }
        aVar2.e = A(bitmap);
        bitmap.recycle();
        return aVar2;
    }

    private NZ V() {
        return C14483hz6.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(String str) {
        S().postRunnable(new g(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap Z(java.lang.String r9, float r10, float r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17481n23.Z(java.lang.String, float, float, boolean):android.graphics.Bitmap");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(Integer num) {
        String str = (String) this.g.get(num);
        if (str != null) {
            m mVar = (m) this.f.get(str);
            if (mVar != null) {
                mVar.a--;
                if (mVar.a == 0) {
                    this.f.remove(str);
                }
            }
            this.g.remove(num);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(boolean z) {
        if (z) {
            this.k--;
        }
        while (this.k < 4 && !this.h.isEmpty()) {
            ((k) this.h.poll()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null, null, null);
            this.k++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static ir.nasim.H95 e0(android.graphics.Bitmap r16, float r17, float r18, int r19, boolean r20, int r21, int r22, java.lang.Long r23, java.lang.Integer r24) {
        /*
            r0 = r21
            r1 = r22
            r2 = 0
            if (r16 != 0) goto L8
            return r2
        L8:
            int r3 = r16.getWidth()
            float r3 = (float) r3
            int r4 = r16.getHeight()
            float r4 = (float) r4
            r5 = 0
            int r6 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r6 == 0) goto L9e
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 != 0) goto L1d
            goto L9e
        L1d:
            float r5 = r3 / r17
            float r6 = r4 / r18
            float r5 = java.lang.Math.max(r5, r6)
            if (r0 == 0) goto L56
            if (r1 == 0) goto L56
            float r0 = (float) r0
            int r6 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r6 < 0) goto L33
            float r7 = (float) r1
            int r7 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r7 >= 0) goto L56
        L33:
            if (r6 >= 0) goto L3d
            float r5 = (float) r1
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 <= 0) goto L3d
            float r0 = r3 / r0
            goto L52
        L3d:
            int r5 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r5 <= 0) goto L49
            float r5 = (float) r1
            int r6 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r6 >= 0) goto L49
            float r0 = r4 / r5
            goto L52
        L49:
            float r0 = r3 / r0
            float r1 = (float) r1
            float r1 = r4 / r1
            float r0 = java.lang.Math.max(r0, r1)
        L52:
            r1 = 1
            r12 = r1
            r1 = r0
            goto L59
        L56:
            r0 = 0
            r12 = r0
            r1 = r5
        L59:
            float r3 = r3 / r1
            int r13 = (int) r3
            float r4 = r4 / r1
            int r14 = (int) r4
            if (r14 == 0) goto L9e
            if (r13 != 0) goto L62
            goto L9e
        L62:
            r3 = r16
            r4 = r13
            r5 = r14
            r6 = r1
            r7 = r19
            r8 = r20
            r9 = r12
            r10 = r23
            r11 = r24
            ir.nasim.H95 r0 = g0(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L75
            return r0
        L75:
            r0 = move-exception
            r3 = r0
            java.lang.String r15 = "baleMessages"
            ir.nasim.C19406qI3.d(r15, r3)
            ir.nasim.n23 r0 = T()
            r0.F()
            java.lang.System.gc()
            r3 = r16
            r4 = r13
            r5 = r14
            r6 = r1
            r7 = r19
            r8 = r20
            r9 = r12
            r10 = r23
            r11 = r24
            ir.nasim.H95 r0 = g0(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L99
            return r0
        L99:
            r0 = move-exception
            r1 = r0
            ir.nasim.C19406qI3.d(r15, r1)
        L9e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17481n23.e0(android.graphics.Bitmap, float, float, int, boolean, int, int, java.lang.Long, java.lang.Integer):ir.nasim.H95");
    }

    public static H95 f0(Bitmap bitmap, float f2, float f3, int i2, boolean z, Long l2, Integer num) {
        return e0(bitmap, f2, f3, i2, z, 0, 0, l2, num);
    }

    private static H95 g0(Bitmap bitmap, int i2, int i3, float f2, int i4, boolean z, boolean z2, Long l2, Integer num) throws IOException {
        Bitmap bitmapC = (f2 > 1.0f || z2) ? AbstractC17261mg0.c(bitmap, i2, i3, true) : bitmap;
        u = false;
        AbstractC4761Gl2.a aVar = new AbstractC4761Gl2.a();
        if (l2 == null || num == null) {
            aVar.b = Long.MIN_VALUE;
            aVar.a = Long.MIN_VALUE;
            int i5 = C23073wI7.b;
            aVar.c = i5;
            C23073wI7.b = i5 - 1;
            u = true;
        } else {
            aVar.b = l2.longValue();
            aVar.a = l2.longValue();
            aVar.c = num.intValue();
        }
        H95.a aVar2 = new H95.a();
        aVar2.b = aVar;
        aVar2.c = bitmapC.getWidth();
        int height = bitmapC.getHeight();
        aVar2.d = height;
        int i6 = aVar2.c;
        if (i6 <= 100 && height <= 100) {
            aVar2.a = "s";
        } else if (i6 <= 320 && height <= 320) {
            aVar2.a = "m";
        } else if (i6 <= 800 && height <= 800) {
            aVar2.a = "x";
        } else if (i6 > 1280 || height > 1280) {
            aVar2.a = "w";
        } else {
            aVar2.a = "y";
        }
        FileOutputStream fileOutputStream = new FileOutputStream(new File(C4044Dl2.m().j(4), aVar.b + "_" + aVar.c + ".jpg"));
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        bitmapC.compress(compressFormat, i4, fileOutputStream);
        if (z) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmapC.compress(compressFormat, i4, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            aVar2.f = byteArray;
            aVar2.e = byteArray.length;
            byteArrayOutputStream.close();
        } else {
            aVar2.e = (int) fileOutputStream.getChannel().size();
        }
        fileOutputStream.close();
        if (bitmapC != bitmap) {
            bitmapC.recycle();
        }
        return aVar2;
    }

    public void C(S23 s23, int i2) {
        if (s23 == null) {
            return;
        }
        S().postRunnable(new e(i2, s23));
    }

    public void E() {
        O().postRunnable(new d());
    }

    public void F() {
        this.b.b();
    }

    public HashMap H() throws IOException {
        HashMap map = new HashMap();
        File fileJ = C6906Pm2.j();
        if (!fileJ.isDirectory()) {
            try {
                fileJ.mkdirs();
            } catch (Exception e2) {
                C19406qI3.d("baleMessages", e2);
            }
        }
        try {
            new File(fileJ, ".nomedia").createNewFile();
        } catch (Exception e3) {
            C19406qI3.d("baleMessages", e3);
        }
        map.put(4, fileJ);
        C19406qI3.b("baleMessages", "cache path = " + fileJ);
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                File file = new File(Environment.getExternalStorageDirectory(), "Bale");
                this.p = file;
                file.mkdirs();
                if (this.p.isDirectory()) {
                    try {
                        File file2 = new File(this.p, "Bale Images");
                        file2.mkdir();
                        if (file2.isDirectory() && B(fileJ, file2, 0)) {
                            map.put(0, file2);
                            C19406qI3.b("baleMessages", "image path = " + file2);
                        }
                    } catch (Exception e4) {
                        C19406qI3.d("baleMessages", e4);
                    }
                    try {
                        File file3 = new File(this.p, "Bale Video");
                        file3.mkdir();
                        if (file3.isDirectory() && B(fileJ, file3, 2)) {
                            map.put(2, file3);
                            C19406qI3.b("baleMessages", "video path = " + file3);
                        }
                    } catch (Exception e5) {
                        C19406qI3.d("baleMessages", e5);
                    }
                    try {
                        File file4 = new File(this.p, "Bale Audio");
                        file4.mkdir();
                        if (file4.isDirectory() && B(fileJ, file4, 1)) {
                            new File(file4, ".nomedia").createNewFile();
                            map.put(1, file4);
                            C19406qI3.b("baleMessages", "audio path = " + file4);
                        }
                    } catch (Exception e6) {
                        C19406qI3.d("baleMessages", e6);
                    }
                    try {
                        File file5 = new File(this.p, "Bale Documents");
                        file5.mkdir();
                        if (file5.isDirectory() && B(fileJ, file5, 3)) {
                            new File(file5, ".nomedia").createNewFile();
                            map.put(3, file5);
                            C19406qI3.b("baleMessages", "documents path = " + file5);
                        }
                    } catch (Exception e7) {
                        C19406qI3.d("baleMessages", e7);
                    }
                }
            } else {
                C19406qI3.b("baleMessages", "this Android can't rename files");
            }
            AbstractC11743dX3.b().a();
        } catch (Exception e8) {
            C19406qI3.d("baleMessages", e8);
        }
        return map;
    }

    public boolean I(String str) {
        Integer num = (Integer) this.a.get(str);
        if (num == null) {
            return true;
        }
        if (num.intValue() == 1) {
            this.a.remove(str);
            return true;
        }
        this.a.put(str, Integer.valueOf(num.intValue() - 1));
        return false;
    }

    public AbstractC10754c85.a K(byte[] bArr, long j2, int i2) {
        Bitmap bitmapF;
        H95 h95F0;
        if (bArr == null) {
            return null;
        }
        try {
            bitmapF = AbstractC24097y23.f(bArr);
        } catch (Exception e2) {
            C19406qI3.d("baleMessages", e2);
            System.gc();
            try {
                bitmapF = AbstractC24097y23.f(bArr);
            } catch (Exception e3) {
                C19406qI3.d("baleMessages", e3);
                bitmapF = null;
            }
        }
        if (bitmapF == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        File file = new File(C4044Dl2.m().j(4), j2 + "_" + i2 + ".jpg");
        if (file.exists()) {
            h95F0 = U(Z(file.getAbsolutePath(), 90.0f, 90.0f, true), Long.valueOf(j2), Integer.valueOf(i2));
        } else {
            h95F0 = f0(bitmapF, 90.0f, 90.0f, 55, true, Long.valueOf(j2), Integer.valueOf(i2));
        }
        if (h95F0 != null) {
            arrayList.add(h95F0);
        }
        bitmapF.recycle();
        if (arrayList.isEmpty()) {
            return null;
        }
        if (u) {
            C23073wI7.e();
        }
        AbstractC10754c85.a aVar = new AbstractC10754c85.a();
        aVar.a = C3971Dd1.c().b();
        aVar.b = arrayList;
        return aVar;
    }

    public AbstractC10754c85.a L(String str) {
        String str2;
        Integer numValueOf;
        Long l2;
        Bitmap bitmapZ = Z(str, AbstractC7426Rr.G(), AbstractC7426Rr.G(), true);
        if (bitmapZ == null && AbstractC7426Rr.G() != 800) {
            bitmapZ = Z(str, 800.0f, 800.0f, true);
        }
        u = false;
        str2 = "";
        if (str != null) {
            try {
                try {
                    String strSubstring = str.substring(str.lastIndexOf(Separators.SLASH) + 1);
                    String strSubstring2 = strSubstring.substring(0, strSubstring.lastIndexOf("_"));
                    String strSubstring3 = strSubstring.substring(strSubstring.lastIndexOf("_") + 1, strSubstring.contains(Separators.DOT) ? strSubstring.lastIndexOf(Separators.DOT) : strSubstring.length());
                    Long lValueOf = Long.valueOf(Long.parseLong(strSubstring2));
                    numValueOf = Integer.valueOf(Integer.parseInt(strSubstring3));
                    str2 = strSubstring;
                    l2 = lValueOf;
                } catch (Exception unused) {
                    String strSubstring4 = str.substring(0, str.lastIndexOf(Separators.SLASH));
                    String strSubstring5 = str.substring(str.lastIndexOf(Separators.SLASH) + 1);
                    int i2 = C23073wI7.b;
                    Integer numValueOf2 = Integer.valueOf(i2);
                    C23073wI7.b--;
                    u = true;
                    Long lValueOf2 = Long.valueOf(Long.parseLong(strSubstring5.substring(strSubstring5.lastIndexOf("_") + 1, strSubstring5.contains(Separators.DOT) ? strSubstring5.lastIndexOf(Separators.DOT) : strSubstring5.length())));
                    VZ2.a(new File(str), new File(strSubstring4 + Separators.SLASH + lValueOf2 + "_" + i2 + (strSubstring5.contains(Separators.DOT) ? strSubstring5.substring(strSubstring5.lastIndexOf(Separators.DOT)) : "")));
                    str2 = strSubstring5;
                    numValueOf = numValueOf2;
                    l2 = lValueOf2;
                }
            } catch (Exception e2) {
                C19406qI3.d("baleMessages", e2);
                return null;
            }
        } else {
            numValueOf = null;
            l2 = null;
        }
        ArrayList arrayList = new ArrayList();
        File file = new File(C4044Dl2.m().j(4), str2);
        H95 h95U = file.exists() ? U(Z(file.getAbsolutePath(), 90.0f, 90.0f, true), l2, numValueOf) : f0(bitmapZ, 90.0f, 90.0f, 55, true, l2, numValueOf);
        if (h95U != null) {
            arrayList.add(h95U);
        }
        H95 h95U2 = U(bitmapZ, l2, numValueOf);
        if (h95U2 != null) {
            arrayList.add(h95U2);
        }
        if (bitmapZ != null) {
            bitmapZ.recycle();
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (u) {
            C23073wI7.e();
        }
        AbstractC10754c85.a aVar = new AbstractC10754c85.a();
        aVar.a = C3971Dd1.c().b();
        aVar.b = arrayList;
        return aVar;
    }

    public H95 M(byte[] bArr, long j2, int i2) {
        Bitmap bitmapF;
        H95 h95F0;
        if (bArr == null) {
            return null;
        }
        try {
            bitmapF = AbstractC24097y23.f(bArr);
        } catch (Exception e2) {
            C19406qI3.d("baleMessages", e2);
            System.gc();
            try {
                bitmapF = AbstractC24097y23.f(bArr);
            } catch (Exception e3) {
                C19406qI3.d("baleMessages", e3);
                bitmapF = null;
            }
        }
        if (bitmapF == null) {
            return null;
        }
        File file = new File(C4044Dl2.m().j(4), j2 + "_" + i2 + ".jpg");
        if (file.exists()) {
            h95F0 = U(Z(file.getAbsolutePath(), 90.0f, 90.0f, true), Long.valueOf(j2), Integer.valueOf(i2));
        } else {
            h95F0 = f0(bitmapF, 90.0f, 90.0f, 55, true, Long.valueOf(j2), Integer.valueOf(i2));
        }
        bitmapF.recycle();
        return h95F0;
    }

    public Float Q(String str) {
        if (str == null) {
            return null;
        }
        return (Float) this.i.get(str);
    }

    public void X(String str) {
        Integer num = (Integer) this.a.get(str);
        if (num == null) {
            this.a.put(str, 1);
        } else {
            this.a.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public boolean Y(String str) {
        return this.b.c(str) != null;
    }

    public void a0(S23 s23) {
        boolean z;
        String strA;
        String str;
        int iLastIndexOf;
        String str2;
        String str3;
        String str4;
        BitmapDrawable bitmapDrawableC;
        BitmapDrawable bitmapDrawableC2;
        if (s23 == null) {
            return;
        }
        String strT = s23.t();
        boolean z2 = false;
        int i2 = 1;
        if (strT != null && (bitmapDrawableC2 = this.b.c(strT)) != null) {
            C(s23, 0);
            if (!s23.D()) {
                s23.Q(bitmapDrawableC2, strT, false, true);
                return;
            }
        }
        String strZ = s23.z();
        if (strZ == null || (bitmapDrawableC = this.b.c(strZ)) == null) {
            z = false;
        } else {
            s23.Q(bitmapDrawableC, strZ, true, true);
            C(s23, 1);
            z = true;
        }
        AbstractC4761Gl2 abstractC4761Gl2A = s23.A();
        AbstractC13360g57 abstractC13360g57P = s23.p();
        String strN = s23.n();
        String strL = s23.l();
        String str5 = strL == null ? "jpg" : strL;
        String str6 = null;
        if (strN != null) {
            strA = AbstractC15318jN7.a(strN);
            str = strA + Separators.DOT + R(strN, "jpg");
        } else if (abstractC13360g57P == null) {
            strA = null;
            str = null;
            z2 = false;
        } else if (abstractC13360g57P instanceof AbstractC4761Gl2) {
            AbstractC4761Gl2 abstractC4761Gl2 = (AbstractC4761Gl2) abstractC13360g57P;
            strA = abstractC4761Gl2.b + "_" + abstractC4761Gl2.c;
            String str7 = strA + Separators.DOT + str5;
            z2 = (s23.l() == null && abstractC4761Gl2.d == null && (abstractC4761Gl2.b != -2147483648L || abstractC4761Gl2.c >= 0)) ? false : true;
            str = str7;
            i2 = 1;
        } else if (abstractC13360g57P instanceof AbstractC18939pW1) {
            AbstractC18939pW1 abstractC18939pW1 = (AbstractC18939pW1) abstractC13360g57P;
            if (abstractC18939pW1.a == 0 || abstractC18939pW1.h == 0) {
                return;
            }
            if (abstractC18939pW1.g == 0) {
                strA = abstractC18939pW1.h + "_" + abstractC18939pW1.a;
            } else {
                strA = abstractC18939pW1.h + "_" + abstractC18939pW1.a + "_" + abstractC18939pW1.g;
            }
            String strK = C4044Dl2.k(abstractC18939pW1);
            String str8 = "";
            String strSubstring = (strK == null || (iLastIndexOf = strK.lastIndexOf(46)) == -1) ? "" : strK.substring(iLastIndexOf);
            i2 = 1;
            if (strSubstring.length() <= 1) {
                String str9 = abstractC18939pW1.d;
                if (str9 != null && str9.equals("video/mp4")) {
                    str8 = ".mp4";
                }
            } else {
                str8 = strSubstring;
            }
            str = strA + str8;
            z2 = true;
        } else {
            i2 = 1;
            strA = null;
            str = null;
            z2 = false;
        }
        if (abstractC4761Gl2A != null) {
            str6 = abstractC4761Gl2A.b + "_" + abstractC4761Gl2A.c;
            str2 = str6 + Separators.DOT + str5;
        } else {
            str2 = null;
        }
        String strM = s23.m();
        String strY = s23.y();
        if (strA == null || strM == null) {
            str3 = strA;
        } else {
            str3 = strA + Separators.AT + strM;
        }
        if (str6 == null || strY == null) {
            str4 = str6;
        } else {
            str4 = str6 + Separators.AT + strY;
        }
        if (strN == null) {
            String str10 = str5;
            G(s23, str4, str2, str10, abstractC4761Gl2A, null, strY, 0, true, z ? 2 : i2);
            G(s23, str3, str, str10, abstractC13360g57P, null, strM, s23.w(), (z2 || s23.j()) ? i2 : false, 0);
        } else {
            if (z) {
                i2 = 2;
            }
            G(s23, str4, str2, str5, abstractC4761Gl2A, null, strY, 0, true, i2);
            G(s23, str3, str, str5, null, strN, strM, 0, true, 0);
        }
    }

    public void c0(String str) {
        this.a.remove(str);
        this.b.e(str);
    }
}
