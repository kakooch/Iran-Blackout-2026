package ir.nasim.tgwidgets.editor.messenger;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.gov.nist.core.Separators;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import ir.nasim.AbstractC11500d67;
import ir.nasim.AbstractC12724f57;
import ir.nasim.AbstractC14047hG;
import ir.nasim.AbstractC17069mL3;
import ir.nasim.AbstractC18106o57;
import ir.nasim.AbstractC25148zo6;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.AbstractC8662Wx6;
import ir.nasim.AbstractC8814Xl0;
import ir.nasim.C10743c74;
import ir.nasim.C12154e78;
import ir.nasim.C14483hz6;
import ir.nasim.C18727p87;
import ir.nasim.C24687z23;
import ir.nasim.C4278El2;
import ir.nasim.NZ;
import ir.nasim.RU1;
import ir.nasim.tgwidgets.editor.messenger.C21457d;
import ir.nasim.tgwidgets.editor.messenger.ImageReceiver;
import ir.nasim.tgwidgets.editor.ui.Components.AnimatedFileDrawable;
import ir.nasim.tgwidgets.editor.ui.Components.RLottieDrawable;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: ir.nasim.tgwidgets.editor.messenger.d, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C21457d {
    private static ThreadLocal F = new ThreadLocal();
    private static ThreadLocal G = new ThreadLocal();
    private static byte[] H = new byte[12];
    private static byte[] I = new byte[12];
    private static volatile C21457d J = null;
    private AbstractC17069mL3 b;
    private AbstractC17069mL3 c;
    private AbstractC17069mL3 d;
    private AbstractC17069mL3 e;
    private boolean v;
    private HashMap a = new HashMap();
    ArrayList f = new ArrayList();
    private HashMap g = new HashMap();
    private HashMap h = new HashMap();
    private HashMap i = new HashMap();
    private SparseArray j = new SparseArray();
    private HashMap k = new HashMap();
    private SparseArray l = new SparseArray();
    private LinkedList m = new LinkedList();
    private LinkedList n = new LinkedList();
    private RU1 o = new RU1("cacheOutQueue");
    private HashMap p = new HashMap();
    private ConcurrentHashMap q = new ConcurrentHashMap();
    private HashMap r = new HashMap();
    private HashMap s = new HashMap();
    private int t = 0;
    private int u = 0;
    private ConcurrentHashMap w = new ConcurrentHashMap();
    private LinkedList x = new LinkedList();
    private HashMap y = new HashMap();
    private HashMap z = new HashMap();
    private int A = 0;
    private String B = null;
    private volatile long C = 0;
    private int D = 0;
    private File E = null;

    /* renamed from: ir.nasim.tgwidgets.editor.messenger.d$a */
    class a extends AbstractC17069mL3 {
        a(int i) {
            super(i);
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.messenger.d$b */
    class b extends AbstractC17069mL3 {
        b(int i) {
            super(i);
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.messenger.d$c */
    class c extends AbstractC17069mL3 {
        c(int i) {
            super(i);
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.messenger.d$d, reason: collision with other inner class name */
    class C1580d extends AbstractC17069mL3 {
        C1580d(int i) {
            super(i);
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.messenger.d$e */
    class e extends BroadcastReceiver {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            C21457d.this.Q();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (AbstractC8814Xl0.b) {
                AbstractC6403Nl2.a("file system changed");
            }
            Runnable runnable = new Runnable() { // from class: ir.nasim.tgwidgets.editor.messenger.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b();
                }
            };
            if ("android.intent.action.MEDIA_UNMOUNTED".equals(intent.getAction())) {
                AbstractC21455b.n1(runnable, 1000L);
            } else {
                runnable.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ir.nasim.tgwidgets.editor.messenger.d$f */
    class f extends AsyncTask {
        private g a;
        private boolean b = true;
        private HttpURLConnection c;
        private boolean d;

        public f(g gVar) {
            this.a = gVar;
            this.d = Uri.parse(gVar.h.g).getQueryParameter("s") != null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f() {
            C21457d.this.G0(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(String str) {
            g gVar = this.a;
            gVar.r = C21457d.this.new i(gVar, 0, str);
            C21457d.this.m.add(this.a.r);
            C21457d.this.H0(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h() {
            C21457d.this.G0(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Finally extract failed */
        @Override // android.os.AsyncTask
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public String doInBackground(Void... voidArr) throws IOException {
            InputStream inputStream;
            ByteArrayOutputStream byteArrayOutputStream;
            InputStream inputStream2;
            ByteArrayOutputStream byteArrayOutputStream2;
            JSONArray jSONArray;
            int i;
            int responseCode;
            try {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.a.h.g.replace("athumb://", "https://")).openConnection();
                    this.c = httpURLConnection;
                    httpURLConnection.setConnectTimeout(5000);
                    this.c.setReadTimeout(5000);
                    this.c.connect();
                    try {
                        HttpURLConnection httpURLConnection2 = this.c;
                        if (httpURLConnection2 != null && (responseCode = httpURLConnection2.getResponseCode()) != 200 && responseCode != 202 && responseCode != 304) {
                            this.b = false;
                        }
                    } catch (Exception e) {
                        AbstractC6403Nl2.e(e, false);
                    }
                    inputStream2 = this.c.getInputStream();
                    try {
                        byteArrayOutputStream2 = new ByteArrayOutputStream();
                    } catch (Throwable th) {
                        byteArrayOutputStream = null;
                        inputStream = inputStream2;
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = null;
                    byteArrayOutputStream = null;
                }
            } catch (Exception unused) {
            }
            try {
                byte[] bArr = new byte[32768];
                while (!isCancelled() && (i = inputStream2.read(bArr)) > 0) {
                    byteArrayOutputStream2.write(bArr, 0, i);
                }
                this.b = false;
                jSONArray = new JSONObject(new String(byteArrayOutputStream2.toByteArray())).getJSONArray("results");
            } catch (Throwable th3) {
                inputStream = inputStream2;
                th = th3;
                byteArrayOutputStream = byteArrayOutputStream2;
                try {
                    if (th instanceof SocketTimeoutException) {
                        if (AbstractC14047hG.c()) {
                            this.b = false;
                        }
                    } else if (th instanceof UnknownHostException) {
                        this.b = false;
                    } else if (th instanceof SocketException) {
                        if (th.getMessage() != null && th.getMessage().contains("ECONNRESET")) {
                            this.b = false;
                        }
                    } else if (th instanceof FileNotFoundException) {
                        this.b = false;
                    }
                    AbstractC6403Nl2.e(th, false);
                    try {
                        HttpURLConnection httpURLConnection3 = this.c;
                        if (httpURLConnection3 != null) {
                            httpURLConnection3.disconnect();
                        }
                    } catch (Throwable unused2) {
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th4) {
                            AbstractC6403Nl2.d(th4);
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return null;
                } catch (Throwable th5) {
                    try {
                        HttpURLConnection httpURLConnection4 = this.c;
                        if (httpURLConnection4 != null) {
                            httpURLConnection4.disconnect();
                        }
                    } catch (Throwable unused3) {
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th6) {
                            AbstractC6403Nl2.d(th6);
                        }
                    }
                    if (byteArrayOutputStream == null) {
                        throw th5;
                    }
                    try {
                        byteArrayOutputStream.close();
                        throw th5;
                    } catch (Exception unused4) {
                        throw th5;
                    }
                }
            }
            if (jSONArray.length() <= 0) {
                try {
                    HttpURLConnection httpURLConnection5 = this.c;
                    if (httpURLConnection5 != null) {
                        httpURLConnection5.disconnect();
                    }
                } catch (Throwable unused5) {
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Throwable th7) {
                        AbstractC6403Nl2.d(th7);
                    }
                }
                byteArrayOutputStream2.close();
                return null;
            }
            String string = jSONArray.getJSONObject(0).getString("artworkUrl100");
            if (this.d) {
                try {
                    HttpURLConnection httpURLConnection6 = this.c;
                    if (httpURLConnection6 != null) {
                        httpURLConnection6.disconnect();
                    }
                } catch (Throwable unused6) {
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Throwable th8) {
                        AbstractC6403Nl2.d(th8);
                    }
                }
                try {
                    byteArrayOutputStream2.close();
                } catch (Exception unused7) {
                }
                return string;
            }
            String strReplace = string.replace("100x100", "600x600");
            try {
                HttpURLConnection httpURLConnection7 = this.c;
                if (httpURLConnection7 != null) {
                    httpURLConnection7.disconnect();
                }
            } catch (Throwable unused8) {
            }
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (Throwable th9) {
                    AbstractC6403Nl2.d(th9);
                }
            }
            try {
                byteArrayOutputStream2.close();
            } catch (Exception unused9) {
            }
            return strReplace;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(final String str) {
            if (str != null) {
                C21457d.this.f0().postRunnable(new Runnable() { // from class: ir.nasim.tgwidgets.editor.messenger.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.g(str);
                    }
                });
            } else if (this.b) {
                C21457d.this.M(this.a.e);
            }
            C21457d.this.f0().postRunnable(new Runnable() { // from class: ir.nasim.tgwidgets.editor.messenger.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.h();
                }
            });
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            C21457d.this.f0().postRunnable(new Runnable() { // from class: ir.nasim.tgwidgets.editor.messenger.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.f();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ir.nasim.tgwidgets.editor.messenger.d$g */
    class g {
        public int a;
        public Runnable b;
        public boolean c;
        protected String d;
        protected String e;
        protected String f;
        protected String g;
        protected C24687z23 h;
        protected Object i;
        protected long j;
        protected int k;
        protected int l;
        protected int m;
        protected File n;
        protected File o;
        protected File p;
        protected f q;
        protected i r;
        protected h s;
        protected ArrayList t;
        protected ArrayList u;
        protected ArrayList v;
        protected ArrayList w;
        protected ArrayList x;

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:34:? A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ void d(android.graphics.drawable.Drawable r10, java.util.ArrayList r11, java.util.ArrayList r12, java.lang.String r13) throws java.lang.InterruptedException {
            /*
                r9 = this;
                boolean r0 = r10 instanceof ir.nasim.tgwidgets.editor.ui.Components.AnimatedFileDrawable
                r1 = 0
                if (r0 == 0) goto L4a
                r0 = r10
                ir.nasim.tgwidgets.editor.ui.Components.AnimatedFileDrawable r0 = (ir.nasim.tgwidgets.editor.ui.Components.AnimatedFileDrawable) r0
                boolean r2 = r0.W0
                if (r2 != 0) goto L4a
                r10 = r1
            Ld:
                int r2 = r11.size()
                if (r1 >= r2) goto L44
                java.lang.Object r2 = r11.get(r1)
                r3 = r2
                ir.nasim.tgwidgets.editor.messenger.ImageReceiver r3 = (ir.nasim.tgwidgets.editor.messenger.ImageReceiver) r3
                if (r1 != 0) goto L1e
                r2 = r0
                goto L22
            L1e:
                ir.nasim.tgwidgets.editor.ui.Components.AnimatedFileDrawable r2 = r0.N0()
            L22:
                java.lang.String r5 = r9.d
                int r6 = r9.l
                java.lang.Object r4 = r12.get(r1)
                java.lang.Integer r4 = (java.lang.Integer) r4
                int r8 = r4.intValue()
                r7 = 0
                r4 = r2
                boolean r3 = r3.X0(r4, r5, r6, r7, r8)
                if (r3 == 0) goto L3c
                if (r2 != r0) goto L41
                r10 = 1
                goto L41
            L3c:
                if (r2 == r0) goto L41
                r2.O0()
            L41:
                int r1 = r1 + 1
                goto Ld
            L44:
                if (r10 != 0) goto L77
                r0.O0()
                goto L77
            L4a:
                int r0 = r11.size()
                if (r1 >= r0) goto L77
                java.lang.Object r0 = r11.get(r1)
                r2 = r0
                ir.nasim.tgwidgets.editor.messenger.ImageReceiver r2 = (ir.nasim.tgwidgets.editor.messenger.ImageReceiver) r2
                java.lang.String r4 = r9.d
                java.util.ArrayList r0 = r9.x
                java.lang.Object r0 = r0.get(r1)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r5 = r0.intValue()
                java.lang.Object r0 = r12.get(r1)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r7 = r0.intValue()
                r6 = 0
                r3 = r10
                r2.X0(r3, r4, r5, r6, r7)
                int r1 = r1 + 1
                goto L4a
            L77:
                if (r13 == 0) goto L7e
                ir.nasim.tgwidgets.editor.messenger.d r10 = ir.nasim.tgwidgets.editor.messenger.C21457d.this
                r10.W(r13)
            L7e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.C21457d.g.d(android.graphics.drawable.Drawable, java.util.ArrayList, java.util.ArrayList, java.lang.String):void");
        }

        public void b(ImageReceiver imageReceiver, String str, String str2, int i, int i2) {
            int iIndexOf = this.t.indexOf(imageReceiver);
            if (iIndexOf >= 0 && Objects.equals(((ImageReceiver) this.t.get(iIndexOf)).C(), str)) {
                this.u.set(iIndexOf, Integer.valueOf(i2));
                return;
            }
            this.t.add(imageReceiver);
            this.u.add(Integer.valueOf(i2));
            this.v.add(str);
            this.w.add(str2);
            this.x.add(Integer.valueOf(i));
            C21457d.this.j.put(imageReceiver.Y(i), this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        void c(int i) {
            AbstractC18106o57 abstractC18106o57;
            C18727p87 c18727p87;
            AbstractC12724f57 abstractC12724f57;
            C18727p87 c18727p872;
            String str;
            C12154e78 c12154e78;
            C24687z23 c24687z23 = this.h;
            if (c24687z23 != null) {
                C18727p87 c18727p873 = c24687z23.f;
                if (c18727p873 != null) {
                    str = this.g;
                    c18727p872 = c18727p873;
                    abstractC18106o57 = null;
                    c12154e78 = 0;
                } else {
                    AbstractC18106o57 abstractC18106o572 = c24687z23.h;
                    if (abstractC18106o572 != null) {
                        abstractC18106o57 = abstractC18106o572;
                        c18727p87 = null;
                    } else {
                        AbstractC12724f57 abstractC12724f572 = c24687z23.t;
                        if (abstractC12724f572 != null) {
                            abstractC12724f57 = abstractC12724f572;
                            abstractC18106o57 = null;
                            c18727p872 = null;
                            str = c18727p872;
                            c12154e78 = abstractC12724f57;
                        } else {
                            abstractC18106o57 = null;
                            c18727p87 = null;
                        }
                    }
                    c18727p872 = c18727p87;
                    abstractC12724f57 = c18727p87;
                    str = c18727p872;
                    c12154e78 = abstractC12724f57;
                }
                C4278El2.H(this.m).p(i, abstractC18106o57, c12154e78, c18727p872, str, null);
            }
        }

        public void e(ImageReceiver imageReceiver) throws InterruptedException {
            int iIntValue = this.l;
            int i = 0;
            while (i < this.t.size()) {
                ImageReceiver imageReceiver2 = (ImageReceiver) this.t.get(i);
                if (imageReceiver2 == null || imageReceiver2 == imageReceiver) {
                    this.t.remove(i);
                    this.u.remove(i);
                    this.v.remove(i);
                    this.w.remove(i);
                    iIntValue = ((Integer) this.x.remove(i)).intValue();
                    if (imageReceiver2 != null) {
                        C21457d.this.j.remove(imageReceiver2.Y(iIntValue));
                    }
                    i--;
                }
                i++;
            }
            if (this.t.isEmpty()) {
                if (this.h != null && !C21457d.this.s.containsKey(this.d)) {
                    C24687z23 c24687z23 = this.h;
                    if (c24687z23.f != null) {
                        C4278El2.H(this.m).m(this.h.f, this.g);
                    } else if (c24687z23.h != null) {
                        C4278El2.H(this.m).j(this.h.h);
                    } else if (c24687z23.t != null) {
                        C4278El2.H(this.m).o(this.h.t);
                    }
                }
                if (this.s != null) {
                    if (iIntValue == 1) {
                        C21457d.this.a0().cancelRunnable(this.s);
                    } else {
                        C21457d.this.o.b(this.s);
                        C21457d.this.o.b(this.b);
                    }
                    this.s.d();
                    this.s = null;
                }
                if (this.r != null) {
                    C21457d.this.m.remove(this.r);
                    this.r.cancel(true);
                    this.r = null;
                }
                if (this.q != null) {
                    C21457d.this.n.remove(this.q);
                    this.q.cancel(true);
                    this.q = null;
                }
                if (this.e != null) {
                    C21457d.this.g.remove(this.e);
                }
                if (this.e != null) {
                    C21457d.this.h.remove(this.e);
                }
                if (this.d != null) {
                    C21457d.this.i.remove(this.d);
                }
            }
        }

        public void f(ImageReceiver imageReceiver, String str, String str2, int i, int i2) {
            int iIndexOf = this.t.indexOf(imageReceiver);
            if (iIndexOf == -1) {
                return;
            }
            if (((Integer) this.x.get(iIndexOf)).intValue() != i) {
                ArrayList arrayList = this.t;
                iIndexOf = arrayList.subList(iIndexOf + 1, arrayList.size()).indexOf(imageReceiver);
                if (iIndexOf == -1) {
                    return;
                }
            }
            this.u.set(iIndexOf, Integer.valueOf(i2));
            this.v.set(iIndexOf, str);
            this.w.set(iIndexOf, str2);
        }

        public void g(final Drawable drawable, final String str) {
            if (drawable != null) {
                final ArrayList arrayList = new ArrayList(this.t);
                final ArrayList arrayList2 = new ArrayList(this.u);
                AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.tgwidgets.editor.messenger.i
                    @Override // java.lang.Runnable
                    public final void run() throws InterruptedException {
                        this.a.d(drawable, arrayList, arrayList2, str);
                    }
                });
            }
            for (int i = 0; i < this.t.size(); i++) {
                C21457d.this.j.remove(((ImageReceiver) this.t.get(i)).Y(this.l));
            }
            this.t.clear();
            this.u.clear();
            if (this.e != null) {
                C21457d.this.g.remove(this.e);
            }
            if (this.e != null) {
                C21457d.this.h.remove(this.e);
            }
            if (this.d != null) {
                C21457d.this.i.remove(this.d);
            }
        }

        public void h(ImageReceiver imageReceiver, int i) {
            int iIndexOf = this.t.indexOf(imageReceiver);
            if (iIndexOf == -1) {
                return;
            }
            this.u.set(iIndexOf, Integer.valueOf(i));
        }

        private g() {
            this.a = 1;
            this.t = new ArrayList();
            this.u = new ArrayList();
            this.v = new ArrayList();
            this.w = new ArrayList();
            this.x = new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ir.nasim.tgwidgets.editor.messenger.d$h */
    class h implements Runnable {
        private Thread a;
        private final Object b = new Object();
        private g c;
        private boolean d;

        public h(g gVar) {
            this.c = gVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(Drawable drawable, String str) {
            this.c.g(drawable, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(Drawable drawable) throws InterruptedException {
            final String str;
            boolean z = false;
            final Drawable drawable2 = null;
            str = null;
            str = null;
            str = null;
            String str2 = null;
            if (drawable instanceof RLottieDrawable) {
                RLottieDrawable rLottieDrawable = (RLottieDrawable) drawable;
                Drawable drawable3 = (Drawable) C21457d.this.e.d(this.c.d);
                if (drawable3 == null) {
                    C21457d.this.e.f(this.c.d, rLottieDrawable);
                    drawable = rLottieDrawable;
                } else {
                    rLottieDrawable.T(false);
                    drawable = drawable3;
                }
                if (drawable != null) {
                    C21457d.this.o0(this.c.d);
                    str2 = this.c.d;
                }
            } else if (drawable instanceof AnimatedFileDrawable) {
                AnimatedFileDrawable animatedFileDrawable = (AnimatedFileDrawable) drawable;
                if (animatedFileDrawable.W0) {
                    BitmapDrawable bitmapDrawableC0 = C21457d.this.c0(this.c.d);
                    if (bitmapDrawableC0 == null) {
                        C21457d.this.e.f(this.c.d, animatedFileDrawable);
                        drawable = animatedFileDrawable;
                    } else {
                        animatedFileDrawable.O0();
                        drawable = bitmapDrawableC0;
                    }
                    C21457d.this.o0(this.c.d);
                    str2 = this.c.d;
                }
            } else {
                if (!(drawable instanceof BitmapDrawable)) {
                    str = null;
                    C21457d.this.f0().postRunnable(new Runnable() { // from class: ir.nasim.tgwidgets.editor.messenger.k
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.e(drawable2, str);
                        }
                    }, this.c.a);
                }
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                BitmapDrawable bitmapDrawableD0 = C21457d.this.d0(this.c.d);
                boolean z2 = true;
                if (bitmapDrawableD0 == null) {
                    if (this.c.d.endsWith("_f")) {
                        C21457d.this.d.f(this.c.d, bitmapDrawable);
                    } else {
                        if (this.c.d.endsWith("_isc") || bitmapDrawable.getBitmap().getWidth() > AbstractC21455b.g * 80.0f || bitmapDrawable.getBitmap().getHeight() > AbstractC21455b.g * 80.0f) {
                            C21457d.this.c.f(this.c.d, bitmapDrawable);
                        } else {
                            C21457d.this.b.f(this.c.d, bitmapDrawable);
                        }
                        z = true;
                    }
                    z2 = z;
                    drawable = bitmapDrawable;
                } else {
                    AbstractC21455b.g1(bitmapDrawable.getBitmap());
                    drawable = bitmapDrawableD0;
                }
                if (drawable != null && z2) {
                    C21457d.this.o0(this.c.d);
                    str2 = this.c.d;
                }
            }
            String str3 = str2;
            drawable2 = drawable;
            str = str3;
            C21457d.this.f0().postRunnable(new Runnable() { // from class: ir.nasim.tgwidgets.editor.messenger.k
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.e(drawable2, str);
                }
            }, this.c.a);
        }

        private void g(RLottieDrawable rLottieDrawable, int i, int i2, boolean z, boolean z2) {
            Bitmap bitmapCreateBitmap;
            Canvas canvas;
            Drawable bitmapDrawable;
            if (z && z2) {
                float f = i * 1.2f;
                float f2 = i2 * 1.2f;
                bitmapCreateBitmap = Bitmap.createBitmap((int) f, (int) f2, Bitmap.Config.ARGB_8888);
                canvas = new Canvas(bitmapCreateBitmap);
                canvas.scale(2.0f, 2.0f, f / 2.0f, f2 / 2.0f);
            } else {
                bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                canvas = new Canvas(bitmapCreateBitmap);
            }
            rLottieDrawable.b();
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(rLottieDrawable.getIntrinsicWidth(), rLottieDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            rLottieDrawable.m0(z ? rLottieDrawable.J() - 1 : 0);
            rLottieDrawable.a(bitmapCreateBitmap2);
            rLottieDrawable.c();
            canvas.save();
            if (!z || !z2) {
                canvas.scale(bitmapCreateBitmap2.getWidth() / i, bitmapCreateBitmap2.getHeight() / i2, i / 2.0f, i2 / 2.0f);
            }
            Paint paint = new Paint(1);
            paint.setFilterBitmap(true);
            if (z && z2) {
                canvas.drawBitmap(bitmapCreateBitmap2, (bitmapCreateBitmap.getWidth() - bitmapCreateBitmap2.getWidth()) / 2.0f, (bitmapCreateBitmap.getHeight() - bitmapCreateBitmap2.getHeight()) / 2.0f, paint);
                bitmapDrawable = new ImageReceiver.d(bitmapCreateBitmap);
            } else {
                canvas.drawBitmap(bitmapCreateBitmap2, 0.0f, 0.0f, paint);
                bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
            }
            rLottieDrawable.T(false);
            bitmapCreateBitmap2.recycle();
            h(bitmapDrawable);
        }

        private void h(final Drawable drawable) {
            AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.tgwidgets.editor.messenger.j
                @Override // java.lang.Runnable
                public final void run() throws InterruptedException {
                    this.a.f(drawable);
                }
            });
        }

        public void d() {
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

        /* JADX WARN: Can't wrap try/catch for region: R(15:(17:26|(8:28|(1:35)(1:34)|36|(1:48)(1:40)|49|(1:51)|52|(1:54)(1:55))(1:56)|57|(3:68|69|(1:89)(3:71|(1:73)(3:75|(1:77)(2:80|(1:82)(2:83|(1:85)(3:86|(1:88)|89)))|78)|74))(2:59|(2:62|(3:64|69|(0)(0))(5:65|(4:67|61|69|(0)(0))|68|69|(0)(0)))(3:61|69|(0)(0)))|91|740|92|760|93|(1:95)(1:100)|101|(5:103|104|(1:106)(1:107)|737|108)(0)|(1:126)|(3:132|(1:145)(4:135|(1:139)|140|(1:144))|146)(1:131)|(1:148)(1:150)|149|(2:155|784)(2:154|783))(1:90)|740|92|760|93|(0)(0)|101|(0)(0)|(1:126)|(2:132|(2:145|146)(0))(0)|(0)(0)|149|(0)|155|784) */
        /* JADX WARN: Can't wrap try/catch for region: R(18:24|(17:26|(8:28|(1:35)(1:34)|36|(1:48)(1:40)|49|(1:51)|52|(1:54)(1:55))(1:56)|57|(3:68|69|(1:89)(3:71|(1:73)(3:75|(1:77)(2:80|(1:82)(2:83|(1:85)(3:86|(1:88)|89)))|78)|74))(2:59|(2:62|(3:64|69|(0)(0))(5:65|(4:67|61|69|(0)(0))|68|69|(0)(0)))(3:61|69|(0)(0)))|91|740|92|760|93|(1:95)(1:100)|101|(5:103|104|(1:106)(1:107)|737|108)(0)|(1:126)|(3:132|(1:145)(4:135|(1:139)|140|(1:144))|146)(1:131)|(1:148)(1:150)|149|(2:155|784)(2:154|783))(1:90)|79|91|740|92|760|93|(0)(0)|101|(0)(0)|(1:126)|(2:132|(2:145|146)(0))(0)|(0)(0)|149|(0)|155|784) */
        /* JADX WARN: Code restructure failed: missing block: B:112:0x01e0, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:113:0x01e1, code lost:
        
            r1 = r0;
            r6 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:114:0x01e5, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:115:0x01e6, code lost:
        
            r14 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:116:0x01e7, code lost:
        
            ir.nasim.AbstractC6403Nl2.e(r0, false);
         */
        /* JADX WARN: Code restructure failed: missing block: B:117:0x01ea, code lost:
        
            if (r14 != null) goto L713;
         */
        /* JADX WARN: Code restructure failed: missing block: B:118:0x01ec, code lost:
        
            r14.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:120:0x01f0, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:121:0x01f1, code lost:
        
            ir.nasim.AbstractC6403Nl2.d(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:122:0x01f5, code lost:
        
            r2 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x01be, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 20, insn: 0x05ce: MOVE (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r20 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:356:0x05cc */
        /* JADX WARN: Removed duplicated region for block: B:100:0x01c0 A[Catch: all -> 0x01b9, Exception -> 0x01be, TryCatch #16 {all -> 0x01b9, blocks: (B:93:0x01ae, B:95:0x01b4, B:101:0x01c4, B:103:0x01cd, B:100:0x01c0, B:116:0x01e7), top: B:740:0x01a3 }] */
        /* JADX WARN: Removed duplicated region for block: B:103:0x01cd A[Catch: all -> 0x01b9, Exception -> 0x01be, TRY_LEAVE, TryCatch #16 {all -> 0x01b9, blocks: (B:93:0x01ae, B:95:0x01b4, B:101:0x01c4, B:103:0x01cd, B:100:0x01c0, B:116:0x01e7), top: B:740:0x01a3 }] */
        /* JADX WARN: Removed duplicated region for block: B:107:0x01d5  */
        /* JADX WARN: Removed duplicated region for block: B:124:0x01f8 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:128:0x01fe A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:132:0x0206  */
        /* JADX WARN: Removed duplicated region for block: B:145:0x0232  */
        /* JADX WARN: Removed duplicated region for block: B:148:0x0238  */
        /* JADX WARN: Removed duplicated region for block: B:150:0x0257  */
        /* JADX WARN: Removed duplicated region for block: B:152:0x0273 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:178:0x02cd  */
        /* JADX WARN: Removed duplicated region for block: B:209:0x0335  */
        /* JADX WARN: Removed duplicated region for block: B:210:0x033a  */
        /* JADX WARN: Removed duplicated region for block: B:256:0x03eb  */
        /* JADX WARN: Removed duplicated region for block: B:261:0x0411  */
        /* JADX WARN: Removed duplicated region for block: B:311:0x0515  */
        /* JADX WARN: Removed duplicated region for block: B:494:0x0853  */
        /* JADX WARN: Removed duplicated region for block: B:527:0x08aa A[Catch: all -> 0x08a6, TryCatch #5 {all -> 0x08a6, blocks: (B:507:0x087b, B:508:0x0884, B:517:0x0891, B:520:0x0899, B:523:0x08a0, B:528:0x08af, B:532:0x08b7, B:534:0x08c1, B:539:0x08ed, B:540:0x08fd, B:527:0x08aa, B:671:0x0acc, B:509:0x0885, B:511:0x0889, B:515:0x088e), top: B:721:0x087b, inners: #22 }] */
        /* JADX WARN: Removed duplicated region for block: B:553:0x0934 A[Catch: all -> 0x0973, TRY_ENTER, TRY_LEAVE, TryCatch #13 {all -> 0x0973, blocks: (B:545:0x0913, B:553:0x0934), top: B:735:0x0913 }] */
        /* JADX WARN: Removed duplicated region for block: B:623:0x0a27  */
        /* JADX WARN: Removed duplicated region for block: B:625:0x0a2a A[Catch: all -> 0x09d5, TryCatch #32 {all -> 0x09d5, blocks: (B:594:0x09c4, B:596:0x09ce, B:601:0x09d7, B:603:0x09dd, B:605:0x09e3, B:611:0x09fa, B:617:0x0a07, B:619:0x0a0d, B:625:0x0a2a, B:620:0x0a17, B:622:0x0a1d, B:628:0x0a32, B:630:0x0a3f, B:632:0x0a48), top: B:767:0x09c0 }] */
        /* JADX WARN: Removed duplicated region for block: B:663:0x0abb A[PHI: r2
          0x0abb: PHI (r2v25 android.graphics.Bitmap) = (r2v24 android.graphics.Bitmap), (r2v28 android.graphics.Bitmap) binds: [B:604:0x09e1, B:626:0x0a2e] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:677:0x0ae6  */
        /* JADX WARN: Removed duplicated region for block: B:681:0x0af2 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:686:0x0afb  */
        /* JADX WARN: Removed duplicated region for block: B:687:0x0b01  */
        /* JADX WARN: Removed duplicated region for block: B:690:0x0b08  */
        /* JADX WARN: Removed duplicated region for block: B:691:0x0b0e  */
        /* JADX WARN: Removed duplicated region for block: B:698:0x0b3e  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x0136  */
        /* JADX WARN: Removed duplicated region for block: B:741:0x0287 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:766:0x06de A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:779:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:89:0x018f  */
        /* JADX WARN: Removed duplicated region for block: B:95:0x01b4 A[Catch: all -> 0x01b9, Exception -> 0x01be, TryCatch #16 {all -> 0x01b9, blocks: (B:93:0x01ae, B:95:0x01b4, B:101:0x01c4, B:103:0x01cd, B:100:0x01c0, B:116:0x01e7), top: B:740:0x01a3 }] */
        /* JADX WARN: Type inference failed for: r14v32 */
        /* JADX WARN: Type inference failed for: r14v33 */
        /* JADX WARN: Type inference failed for: r14v41 */
        /* JADX WARN: Type inference failed for: r14v42 */
        /* JADX WARN: Type inference failed for: r37v0, types: [ir.nasim.tgwidgets.editor.messenger.d$h] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 2915
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.C21457d.h.run():void");
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.messenger.d$j */
    private static class j {
        private AbstractC18106o57 a;
        private String b;
        private ArrayList c;
        private ArrayList d;
        private boolean e;

        private j() {
            this.c = new ArrayList();
            this.d = new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ir.nasim.tgwidgets.editor.messenger.d$k */
    class k implements Runnable {
        private File a;
        private int b;
        private j c;

        public k(int i, File file, j jVar) {
            this.b = i;
            this.a = file;
            this.c = jVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(String str) {
            C21457d.this.r.remove(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(String str, ArrayList arrayList, BitmapDrawable bitmapDrawable, ArrayList arrayList2) {
            e();
            if (this.c.b != null) {
                str = str + Separators.AT + this.c.b;
            }
            for (int i = 0; i < arrayList.size(); i++) {
                ((ImageReceiver) arrayList.get(i)).X0(bitmapDrawable, str, 0, false, ((Integer) arrayList2.get(i)).intValue());
            }
            C21457d.this.c.f(str, bitmapDrawable);
        }

        private void e() {
            j jVar = this.c;
            if (jVar == null) {
                return;
            }
            final String strU = C4278El2.u(jVar.a);
            C21457d.this.f0().postRunnable(new Runnable() { // from class: ir.nasim.tgwidgets.editor.messenger.u
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.c(strU);
                }
            });
        }

        @Override // java.lang.Runnable
        public void run() {
            int iMin;
            Bitmap bitmapC;
            try {
                if (this.c == null) {
                    e();
                    return;
                }
                final String str = "q_" + this.c.a.m + "_" + this.c.a.c;
                File file = new File(C4278El2.B(4), str + ".jpg");
                if (!file.exists() && this.a.exists()) {
                    if (this.c.e) {
                        Point point = AbstractC21455b.h;
                        iMin = Math.max(point.x, point.y);
                    } else {
                        Point point2 = AbstractC21455b.h;
                        iMin = Math.min(SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER, Math.min(point2.x, point2.y) / 4);
                    }
                    int i = this.b;
                    Bitmap bitmapB0 = null;
                    if (i == 0) {
                        float f = iMin;
                        bitmapB0 = C21457d.B0(this.a.toString(), null, f, f, false);
                    } else {
                        int i2 = 2;
                        if (i == 2) {
                            String string = this.a.toString();
                            if (!this.c.e) {
                                i2 = 1;
                            }
                            bitmapB0 = AbstractC25148zo6.d(string, i2);
                        } else if (i == 3) {
                            String lowerCase = this.a.toString().toLowerCase();
                            if (lowerCase.endsWith("mp4")) {
                                String string2 = this.a.toString();
                                if (!this.c.e) {
                                    i2 = 1;
                                }
                                bitmapB0 = AbstractC25148zo6.d(string2, i2);
                            } else if (lowerCase.endsWith(".jpg") || lowerCase.endsWith(".jpeg") || lowerCase.endsWith(".png") || lowerCase.endsWith(".gif")) {
                                float f2 = iMin;
                                bitmapB0 = C21457d.B0(lowerCase, null, f2, f2, false);
                            }
                        }
                    }
                    if (bitmapB0 == null) {
                        e();
                        return;
                    }
                    int width = bitmapB0.getWidth();
                    int height = bitmapB0.getHeight();
                    if (width != 0 && height != 0) {
                        float f3 = width;
                        float f4 = iMin;
                        float f5 = height;
                        float fMin = Math.min(f3 / f4, f5 / f4);
                        if (fMin > 1.0f && (bitmapC = AbstractC21456c.c(bitmapB0, (int) (f3 / fMin), (int) (f5 / fMin), true)) != bitmapB0) {
                            bitmapB0.recycle();
                            bitmapB0 = bitmapC;
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        bitmapB0.compress(Bitmap.CompressFormat.JPEG, this.c.e ? 83 : 60, fileOutputStream);
                        try {
                            fileOutputStream.close();
                        } catch (Exception e) {
                            AbstractC6403Nl2.d(e);
                        }
                        final BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapB0);
                        final ArrayList arrayList = new ArrayList(this.c.c);
                        final ArrayList arrayList2 = new ArrayList(this.c.d);
                        AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.tgwidgets.editor.messenger.t
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.a.d(str, arrayList, bitmapDrawable, arrayList2);
                            }
                        });
                        return;
                    }
                    e();
                    return;
                }
                e();
            } catch (Throwable th) {
                AbstractC6403Nl2.d(th);
                e();
            }
        }
    }

    public C21457d() {
        k0().setPriority(1);
        int memoryClass = ((ActivityManager) AbstractC14047hG.a.getSystemService("activity")).getMemoryClass();
        boolean z = memoryClass >= 192;
        this.v = z;
        int iMin = Math.min(z ? 30 : 15, memoryClass / 7) * 1048576;
        float f2 = iMin;
        this.c = new a((int) (0.8f * f2));
        this.b = new b((int) (f2 * 0.2f));
        this.d = new c(iMin / 4);
        this.e = new C1580d(10485760);
        SparseArray sparseArray = new SparseArray();
        File fileV = AbstractC21455b.V();
        if (!fileV.isDirectory()) {
            try {
                fileV.mkdirs();
            } catch (Exception e2) {
                AbstractC6403Nl2.d(e2);
            }
        }
        AbstractC21455b.E(new File(fileV, ".nomedia"));
        sparseArray.put(4, fileV);
        C4278El2.i0(sparseArray);
        e eVar = new e();
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
        try {
            AbstractC14047hG.a.registerReceiver(eVar, intentFilter);
        } catch (Throwable unused) {
        }
        Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A0(String str) {
        g gVar = (g) this.g.get(str);
        if (gVar == null) {
            return;
        }
        i iVar = gVar.r;
        if (iVar != null) {
            i iVar2 = new i(iVar.a, iVar.c);
            gVar.r = iVar2;
            this.m.add(iVar2);
        }
        H0(false);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(28:0|2|(1:19)(3:7|(1:9)(3:11|(2:154|15)|19)|10)|20|(1:22)(16:(3:150|24|25)|30|(1:32)(1:33)|34|(1:36)|37|(3:39|(2:40|(1:42)(1:162))|43)|44|148|45|(5:156|49|160|50|(1:52))|56|(6:62|152|63|(5:65|(1:67)(1:68)|69|(1:71)(1:72)|73)|74|(1:76))(1:61)|77|(2:(1:80)|81)|(3:158|83|(4:85|(1:87)|90|(3:92|93|165)(1:164))(1:135))(2:141|(5:144|110|(4:112|(1:114)|117|(2:119|120))|121|171)(1:169)))|29|30|(0)(0)|34|(0)|37|(0)|44|148|45|(6:47|156|49|160|50|(0))|56|(2:58|60)|62|152|63|(0)|74|(0)|77|(0)|(0)(0)|(1:(0))) */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0141 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ca A[Catch: all -> 0x00e7, PHI: r8 r9
      0x00ca: PHI (r8v5 android.util.Pair) = (r8v2 android.util.Pair), (r8v7 android.util.Pair) binds: [B:55:0x00d1, B:51:0x00c8] A[DONT_GENERATE, DONT_INLINE]
      0x00ca: PHI (r9v22 java.io.InputStream) = (r9v21 java.io.InputStream), (r9v25 java.io.InputStream) binds: [B:55:0x00d1, B:51:0x00c8] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #5 {all -> 0x00e7, blocks: (B:45:0x00a2, B:47:0x00b0, B:52:0x00ca, B:56:0x00d2, B:58:0x00dc, B:62:0x00e9), top: B:148:0x00a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00dc A[Catch: all -> 0x00e7, TryCatch #5 {all -> 0x00e7, blocks: (B:45:0x00a2, B:47:0x00b0, B:52:0x00ca, B:56:0x00d2, B:58:0x00dc, B:62:0x00e9), top: B:148:0x00a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f8 A[Catch: all -> 0x012c, TryCatch #7 {all -> 0x012c, blocks: (B:63:0x00ee, B:65:0x00f8, B:69:0x0107, B:73:0x0113, B:74:0x0116, B:76:0x0120), top: B:152:0x00ee }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0120 A[Catch: all -> 0x012c, TRY_LEAVE, TryCatch #7 {all -> 0x012c, blocks: (B:63:0x00ee, B:65:0x00f8, B:69:0x0107, B:73:0x0113, B:74:0x0116, B:76:0x0120), top: B:152:0x00ee }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0134  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap B0(java.lang.String r17, android.net.Uri r18, float r19, float r20, boolean r21) throws java.io.FileNotFoundException {
        /*
            Method dump skipped, instructions count: 493
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.C21457d.B0(java.lang.String, android.net.Uri, float, float, boolean):android.graphics.Bitmap");
    }

    private void E0(int i2, ImageReceiver imageReceiver) {
        String str = (String) this.l.get(i2);
        if (str != null) {
            j jVar = (j) this.k.get(str);
            if (jVar != null) {
                int iIndexOf = jVar.c.indexOf(imageReceiver);
                if (iIndexOf >= 0) {
                    jVar.c.remove(iIndexOf);
                    jVar.d.remove(iIndexOf);
                }
                if (jVar.c.isEmpty()) {
                    this.k.remove(str);
                }
            }
            this.l.remove(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(boolean z) {
        if (z) {
            this.u--;
        }
        while (this.u < 4 && !this.n.isEmpty()) {
            try {
                ((f) this.n.poll()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null, null, null);
                this.u++;
            } catch (Throwable unused) {
                G0(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(boolean z) {
        if (z) {
            this.t--;
        }
        while (this.t < 4 && !this.m.isEmpty()) {
            i iVar = (i) this.m.poll();
            if (iVar != null) {
                iVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null, null, null);
                this.t++;
            }
        }
    }

    public static AbstractC11500d67 I0(Bitmap bitmap, float f2, float f3, int i2, boolean z, int i3, int i4) {
        return K0(null, bitmap, Bitmap.CompressFormat.JPEG, false, f2, f3, i2, z, i3, i4, false);
    }

    public static AbstractC11500d67 J0(Bitmap bitmap, Bitmap.CompressFormat compressFormat, float f2, float f3, int i2, boolean z, int i3, int i4) {
        return K0(null, bitmap, compressFormat, false, f2, f3, i2, z, i3, i4, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static ir.nasim.AbstractC11500d67 K0(ir.nasim.AbstractC11500d67 r21, android.graphics.Bitmap r22, android.graphics.Bitmap.CompressFormat r23, boolean r24, float r25, float r26, int r27, boolean r28, int r29, int r30, boolean r31) {
        /*
            Method dump skipped, instructions count: 187
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.C21457d.K0(ir.nasim.d67, android.graphics.Bitmap, android.graphics.Bitmap$CompressFormat, boolean, float, float, int, boolean, int, int, boolean):ir.nasim.d67");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static ir.nasim.AbstractC11500d67 L0(ir.nasim.AbstractC11500d67 r2, android.graphics.Bitmap r3, android.graphics.Bitmap.CompressFormat r4, boolean r5, int r6, int r7, float r8, float r9, float r10, int r11, boolean r12, boolean r13, boolean r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.C21457d.L0(ir.nasim.d67, android.graphics.Bitmap, android.graphics.Bitmap$CompressFormat, boolean, int, int, float, float, float, int, boolean, boolean, boolean):ir.nasim.d67");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(final String str) {
        f0().postRunnable(new Runnable() { // from class: ir.nasim.m23
            @Override // java.lang.Runnable
            public final void run() {
                this.a.t0(str);
            }
        });
    }

    private boolean M0(C24687z23 c24687z23, String str) {
        if (str.endsWith("_firstframe") || str.endsWith("_lastframe")) {
            return false;
        }
        return (c24687z23 != null && (C10743c74.m0(c24687z23.h, true) || c24687z23.o == 1 || C10743c74.g1(c24687z23.h))) || p0(str);
    }

    private boolean N(File file, File file2, int i2) throws Throwable {
        File file3;
        File file4;
        byte[] bArr;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                if (i2 == 0 || i2 == 3 || i2 == 5 || i2 == 6 || i2 == 1 || i2 == 2) {
                    file3 = new File(file, "000000000_999999_temp.f");
                    file4 = new File(file2, "000000000_999999.f");
                } else {
                    file4 = null;
                    file3 = null;
                }
                bArr = new byte[1024];
                file3.createNewFile();
                randomAccessFile = new RandomAccessFile(file3, "rws");
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            randomAccessFile.write(bArr);
            randomAccessFile.close();
            boolean zRenameTo = file3.renameTo(file4);
            file3.delete();
            file4.delete();
            return zRenameTo;
        } catch (Exception e3) {
            e = e3;
            randomAccessFile2 = randomAccessFile;
            AbstractC6403Nl2.d(e);
            if (randomAccessFile2 == null) {
                return false;
            }
            try {
                randomAccessFile2.close();
                return false;
            } catch (Exception e4) {
                AbstractC6403Nl2.d(e4);
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (Exception e5) {
                    AbstractC6403Nl2.d(e5);
                }
            }
            throw th;
        }
    }

    private void T(final ImageReceiver imageReceiver, final String str, final String str2, final String str3, final C24687z23 c24687z23, final String str4, final long j2, final int i2, final int i3, final int i4, final int i5) throws InterruptedException {
        if (imageReceiver == null || str2 == null || str == null || c24687z23 == null) {
            return;
        }
        int iY = imageReceiver.Y(i3);
        if (iY == 0) {
            iY = this.D;
            imageReceiver.p1(iY, i3);
            int i6 = this.D + 1;
            this.D = i6;
            if (i6 == Integer.MAX_VALUE) {
                this.D = 0;
            }
        }
        final int i7 = iY;
        final boolean zN0 = imageReceiver.n0();
        final Object objS = imageReceiver.S();
        final AbstractC18106o57 abstractC18106o57U = imageReceiver.U();
        final boolean zO0 = imageReceiver.o0();
        final int iS = imageReceiver.s();
        final boolean z = i3 == 0 && imageReceiver.j0();
        Runnable runnable = new Runnable() { // from class: ir.nasim.j23
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.a.y0(i4, str2, str, i7, imageReceiver, i5, str4, i3, c24687z23, z, objS, iS, abstractC18106o57U, zN0, zO0, str3, i2, j2);
            }
        };
        f0().postRunnable(runnable, imageReceiver.x() == 0 ? 0L : 1L);
        imageReceiver.a(runnable);
    }

    public static String V(File file) throws IOException {
        StringBuilder sb = new StringBuilder();
        if (file == null) {
            return "";
        }
        try {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(new FileInputStream(file));
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gZIPInputStream, "UTF-8"));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            String string = sb.toString();
                            bufferedReader.close();
                            gZIPInputStream.close();
                            return string;
                        }
                        sb.append(line);
                    } finally {
                    }
                }
            } finally {
            }
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(final String str, final File file, final int i2) {
        f0().postRunnable(new Runnable() { // from class: ir.nasim.k23
            @Override // java.lang.Runnable
            public final void run() {
                this.a.z0(str, i2, file);
            }
        });
    }

    private Drawable Y(String str, List list) {
        if (list == null) {
            return null;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ImageReceiver imageReceiver = (ImageReceiver) list.get(i2);
            if (str.equals(imageReceiver.C())) {
                return imageReceiver.z();
            }
            if (str.equals(imageReceiver.N())) {
                return imageReceiver.L();
            }
        }
        return null;
    }

    private void Z(int i2, File file, j jVar) {
        if ((i2 != 0 && i2 != 2 && i2 != 3) || file == null || jVar == null) {
            return;
        }
        if (((k) this.r.get(C4278El2.u(jVar.a))) == null) {
            k0().postRunnable(new k(i2, file, jVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NZ a0() {
        return C14483hz6.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BitmapDrawable c0(String str) {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) this.e.d(str);
        if (!(bitmapDrawable instanceof AnimatedFileDrawable) || !((AnimatedFileDrawable) bitmapDrawable).K0()) {
            return bitmapDrawable;
        }
        this.e.g(str);
        return null;
    }

    public static String e0(String str, String str2) {
        String lastPathSegment = Uri.parse(str).getLastPathSegment();
        if (!TextUtils.isEmpty(lastPathSegment) && lastPathSegment.length() > 1) {
            str = lastPathSegment;
        }
        int iLastIndexOf = str.lastIndexOf(46);
        String strSubstring = iLastIndexOf != -1 ? str.substring(iLastIndexOf + 1) : null;
        return (strSubstring == null || strSubstring.length() == 0 || strSubstring.length() > 4) ? str2 : strSubstring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NZ f0() {
        return C14483hz6.i();
    }

    public static C21457d g0() {
        C21457d c21457d = J;
        if (c21457d == null) {
            synchronized (C21457d.class) {
                try {
                    c21457d = J;
                    if (c21457d == null) {
                        c21457d = new C21457d();
                        J = c21457d;
                    }
                } finally {
                }
            }
        }
        return c21457d;
    }

    private File h0() {
        File file = AbstractC14047hG.a.getExternalMediaDirs()[0];
        if (!TextUtils.isEmpty(AbstractC8662Wx6.K)) {
            for (int i2 = 0; i2 < AbstractC14047hG.a.getExternalMediaDirs().length; i2++) {
                File file2 = AbstractC14047hG.a.getExternalMediaDirs()[i2];
                if (file2 != null && file2.getPath().startsWith(AbstractC8662Wx6.K)) {
                    file = AbstractC14047hG.a.getExternalMediaDirs()[i2];
                }
            }
        }
        return file;
    }

    public static Bitmap j0(byte[] bArr, String str) {
        int length = (bArr.length - 3) + AbstractC21456c.b.length + AbstractC21456c.c.length;
        byte[] bArr2 = (byte[]) F.get();
        if (bArr2 == null || bArr2.length < length) {
            bArr2 = null;
        }
        if (bArr2 == null) {
            bArr2 = new byte[length];
            F.set(bArr2);
        }
        byte[] bArr3 = AbstractC21456c.b;
        System.arraycopy(bArr3, 0, bArr2, 0, bArr3.length);
        System.arraycopy(bArr, 3, bArr2, AbstractC21456c.b.length, bArr.length - 3);
        System.arraycopy(AbstractC21456c.c, 0, bArr2, (AbstractC21456c.b.length + bArr.length) - 3, AbstractC21456c.c.length);
        bArr2[164] = bArr[1];
        bArr2[166] = bArr[2];
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr2, 0, length);
        if (bitmapDecodeByteArray != null && !TextUtils.isEmpty(str) && str.contains("b")) {
            Utilities.blurBitmap(bitmapDecodeByteArray, 3, 1, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight(), bitmapDecodeByteArray.getRowBytes());
        }
        return bitmapDecodeByteArray;
    }

    private NZ k0() {
        return C14483hz6.j();
    }

    public static boolean l0(String str) {
        if (str == null) {
            return false;
        }
        String[] strArrSplit = str.split("_");
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            if ("g".equals(strArrSplit[i2]) || "pframe".equals(strArrSplit[i2])) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(final String str) {
        f0().postRunnable(new Runnable() { // from class: ir.nasim.l23
            @Override // java.lang.Runnable
            public final void run() {
                this.a.A0(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p0(String str) {
        return str != null && str.endsWith("avatar");
    }

    private boolean r0(String str) {
        return str != null && str.endsWith("pframe");
    }

    public static boolean s0(File file) {
        return !TextUtils.isEmpty(AbstractC8662Wx6.K) && file.getAbsolutePath().startsWith(AbstractC8662Wx6.K);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(String str) {
        g gVar = (g) this.g.get(str);
        if (gVar == null) {
            return;
        }
        f fVar = gVar.q;
        if (fVar != null) {
            f fVar2 = new f(fVar.a);
            gVar.q = fVar2;
            this.n.add(fVar2);
        }
        G0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(boolean z, ImageReceiver imageReceiver) throws InterruptedException {
        int i2 = 0;
        while (true) {
            int i3 = 3;
            if (i2 >= 3) {
                return;
            }
            if (i2 > 0 && !z) {
                return;
            }
            if (i2 == 0) {
                i3 = 1;
            } else if (i2 == 1) {
                i3 = 0;
            }
            int iY = imageReceiver.Y(i3);
            if (iY != 0) {
                if (i2 == 0) {
                    E0(iY, imageReceiver);
                }
                g gVar = (g) this.j.get(iY);
                if (gVar != null) {
                    gVar.e(imageReceiver);
                }
            }
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(ImageReceiver imageReceiver, int i2) {
        g gVar;
        int i3 = 0;
        while (true) {
            int i4 = 3;
            if (i3 >= 3) {
                return;
            }
            if (i3 == 0) {
                i4 = 1;
            } else if (i3 == 1) {
                i4 = 0;
            }
            int iY = imageReceiver.Y(i4);
            if (iY != 0 && (gVar = (g) this.j.get(iY)) != null) {
                gVar.c(i2);
            }
            i3++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w0(SparseArray sparseArray, Runnable runnable) {
        C4278El2.i0(sparseArray);
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(final Runnable runnable) {
        final SparseArray sparseArrayU = U();
        AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.i23
            @Override // java.lang.Runnable
            public final void run() {
                C21457d.w0(sparseArrayU, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x04d7  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x04f5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01bf  */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v5, types: [ir.nasim.El2] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void y0(int r27, java.lang.String r28, java.lang.String r29, int r30, ir.nasim.tgwidgets.editor.messenger.ImageReceiver r31, int r32, java.lang.String r33, int r34, ir.nasim.C24687z23 r35, boolean r36, java.lang.Object r37, int r38, ir.nasim.AbstractC18106o57 r39, boolean r40, boolean r41, java.lang.String r42, int r43, long r44) throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 1627
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.C21457d.y0(int, java.lang.String, java.lang.String, int, ir.nasim.tgwidgets.editor.messenger.ImageReceiver, int, java.lang.String, int, ir.nasim.z23, boolean, java.lang.Object, int, ir.nasim.o57, boolean, boolean, java.lang.String, int, long):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(String str, int i2, File file) {
        j jVar = (j) this.k.get(str);
        if (jVar != null && jVar.a != null) {
            Z(i2, file, jVar);
            this.k.remove(str);
        }
        g gVar = (g) this.g.get(str);
        if (gVar == null) {
            return;
        }
        this.g.remove(str);
        this.h.remove(str);
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < gVar.t.size(); i3++) {
            String str2 = (String) gVar.v.get(i3);
            String str3 = (String) gVar.w.get(i3);
            int iIntValue = ((Integer) gVar.x.get(i3)).intValue();
            ImageReceiver imageReceiver = (ImageReceiver) gVar.t.get(i3);
            int iIntValue2 = ((Integer) gVar.u.get(i3)).intValue();
            g gVar2 = (g) this.i.get(str2);
            if (gVar2 == null) {
                gVar2 = new g();
                gVar2.a = gVar.a;
                gVar2.m = gVar.m;
                gVar2.n = file;
                gVar2.i = gVar.i;
                gVar2.c = gVar.c;
                gVar2.d = str2;
                gVar2.h = gVar.h;
                gVar2.l = iIntValue;
                gVar2.g = gVar.g;
                gVar2.p = gVar.p;
                gVar2.s = new h(gVar2);
                gVar2.f = str3;
                gVar2.k = gVar.k;
                this.i.put(str2, gVar2);
                arrayList.add(gVar2.s);
            }
            gVar2.b(imageReceiver, str2, str3, iIntValue, iIntValue2);
        }
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            h hVar = (h) arrayList.get(i4);
            if (hVar.c.l == 1) {
                a0().postRunnable(hVar);
            } else {
                this.o.c(hVar, hVar.c.a);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:167:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0171  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void C0(ir.nasim.tgwidgets.editor.messenger.ImageReceiver r38, java.util.List r39) throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 1420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.C21457d.C0(ir.nasim.tgwidgets.editor.messenger.ImageReceiver, java.util.List):void");
    }

    public void D0(BitmapDrawable bitmapDrawable, String str, boolean z) {
        if (z) {
            this.b.f(str, bitmapDrawable);
        } else {
            this.c.f(str, bitmapDrawable);
        }
    }

    public void F0(String str) {
        this.a.remove(str);
        this.c.g(str);
        this.b.g(str);
    }

    public void O(final ImageReceiver imageReceiver, final boolean z) throws InterruptedException {
        if (imageReceiver == null) {
            return;
        }
        ArrayList arrayListI = imageReceiver.I();
        if (!arrayListI.isEmpty()) {
            for (int i2 = 0; i2 < arrayListI.size(); i2++) {
                f0().cancelRunnable((Runnable) arrayListI.get(i2));
            }
            arrayListI.clear();
        }
        imageReceiver.a(null);
        f0().postRunnable(new Runnable() { // from class: ir.nasim.f23
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.a.u0(z, imageReceiver);
            }
        });
    }

    public void P(final ImageReceiver imageReceiver) {
        if (imageReceiver == null) {
            return;
        }
        final int iX = imageReceiver.x();
        f0().postRunnable(new Runnable() { // from class: ir.nasim.h23
            @Override // java.lang.Runnable
            public final void run() {
                this.a.v0(imageReceiver, iX);
            }
        });
    }

    public void Q() {
        R(null);
    }

    public void R(final Runnable runnable) {
        this.o.d(new Runnable() { // from class: ir.nasim.g23
            @Override // java.lang.Runnable
            public final void run() {
                this.a.x0(runnable);
            }
        });
    }

    public void S() {
        this.b.c();
        this.c.c();
        this.e.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:157:0x0374 A[Catch: Exception -> 0x0387, TRY_LEAVE, TryCatch #10 {Exception -> 0x0387, blocks: (B:151:0x0357, B:153:0x0365, B:155:0x036b, B:157:0x0374), top: B:198:0x0357, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03a8 A[Catch: Exception -> 0x03bb, TRY_LEAVE, TryCatch #8 {Exception -> 0x03bb, blocks: (B:161:0x038b, B:163:0x0399, B:165:0x039f, B:167:0x03a8), top: B:194:0x038b, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x01e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x016a A[Catch: Exception -> 0x00ad, TryCatch #0 {Exception -> 0x00ad, blocks: (B:12:0x0053, B:14:0x005f, B:16:0x006d, B:19:0x0075, B:21:0x007c, B:24:0x00aa, B:27:0x00b0, B:29:0x00bc, B:32:0x00c5, B:34:0x00c8, B:38:0x00e9, B:37:0x00cd, B:39:0x00ec, B:56:0x012d, B:73:0x0190, B:75:0x019d, B:77:0x01a8, B:79:0x01b0, B:81:0x01b8, B:83:0x01c4, B:84:0x01cf, B:85:0x01d2, B:147:0x034c, B:137:0x030b, B:127:0x02ca, B:117:0x0289, B:107:0x0248, B:149:0x0351, B:170:0x03bc, B:160:0x0388, B:174:0x03c9, B:97:0x0214, B:55:0x012a, B:57:0x013c, B:59:0x0144, B:72:0x0189, B:62:0x0151, B:64:0x0157, B:69:0x0164, B:71:0x016a, B:67:0x015e, B:171:0x03c0, B:173:0x03c4, B:138:0x030e, B:140:0x0320, B:142:0x0327, B:144:0x0336, B:128:0x02cd, B:130:0x02df, B:132:0x02e6, B:134:0x02f5, B:118:0x028c, B:120:0x029e, B:122:0x02a5, B:124:0x02b4, B:88:0x01e3, B:90:0x01f3, B:92:0x01f9, B:94:0x0200, B:161:0x038b, B:163:0x0399, B:165:0x039f, B:167:0x03a8, B:108:0x024b, B:110:0x025d, B:112:0x0264, B:114:0x0273, B:151:0x0357, B:153:0x0365, B:155:0x036b, B:157:0x0374, B:98:0x0217, B:100:0x0227, B:102:0x022d, B:104:0x0234), top: B:178:0x0053, inners: #1, #2, #3, #4, #8, #9, #10, #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x019d A[Catch: Exception -> 0x00ad, TryCatch #0 {Exception -> 0x00ad, blocks: (B:12:0x0053, B:14:0x005f, B:16:0x006d, B:19:0x0075, B:21:0x007c, B:24:0x00aa, B:27:0x00b0, B:29:0x00bc, B:32:0x00c5, B:34:0x00c8, B:38:0x00e9, B:37:0x00cd, B:39:0x00ec, B:56:0x012d, B:73:0x0190, B:75:0x019d, B:77:0x01a8, B:79:0x01b0, B:81:0x01b8, B:83:0x01c4, B:84:0x01cf, B:85:0x01d2, B:147:0x034c, B:137:0x030b, B:127:0x02ca, B:117:0x0289, B:107:0x0248, B:149:0x0351, B:170:0x03bc, B:160:0x0388, B:174:0x03c9, B:97:0x0214, B:55:0x012a, B:57:0x013c, B:59:0x0144, B:72:0x0189, B:62:0x0151, B:64:0x0157, B:69:0x0164, B:71:0x016a, B:67:0x015e, B:171:0x03c0, B:173:0x03c4, B:138:0x030e, B:140:0x0320, B:142:0x0327, B:144:0x0336, B:128:0x02cd, B:130:0x02df, B:132:0x02e6, B:134:0x02f5, B:118:0x028c, B:120:0x029e, B:122:0x02a5, B:124:0x02b4, B:88:0x01e3, B:90:0x01f3, B:92:0x01f9, B:94:0x0200, B:161:0x038b, B:163:0x0399, B:165:0x039f, B:167:0x03a8, B:108:0x024b, B:110:0x025d, B:112:0x0264, B:114:0x0273, B:151:0x0357, B:153:0x0365, B:155:0x036b, B:157:0x0374, B:98:0x0217, B:100:0x0227, B:102:0x022d, B:104:0x0234), top: B:178:0x0053, inners: #1, #2, #3, #4, #8, #9, #10, #11 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.util.SparseArray U() {
        /*
            Method dump skipped, instructions count: 977
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.C21457d.U():android.util.SparseArray");
    }

    public boolean W(String str) {
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

    public Float b0(String str) {
        long[] jArr;
        if (str == null || (jArr = (long[]) this.q.get(str)) == null) {
            return null;
        }
        long j2 = jArr[1];
        return j2 == 0 ? Float.valueOf(0.0f) : Float.valueOf(Math.min(1.0f, jArr[0] / j2));
    }

    public BitmapDrawable d0(String str) {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) this.c.d(str);
        if (bitmapDrawable == null) {
            bitmapDrawable = (BitmapDrawable) this.b.d(str);
        }
        if (bitmapDrawable == null) {
            bitmapDrawable = (BitmapDrawable) this.d.d(str);
        }
        return bitmapDrawable == null ? c0(str) : bitmapDrawable;
    }

    public String i0(String str) {
        if (str == null) {
            return null;
        }
        return (String) this.p.get(str);
    }

    public boolean m0(String str) {
        AbstractC17069mL3 abstractC17069mL3 = this.e;
        return abstractC17069mL3 != null && abstractC17069mL3.a(str);
    }

    public void o0(String str) {
        Integer num = (Integer) this.a.get(str);
        if (num == null) {
            this.a.put(str, 1);
        } else {
            this.a.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public boolean q0(String str, boolean z) {
        return z ? c0(str) != null : d0(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ir.nasim.tgwidgets.editor.messenger.d$i */
    class i extends AsyncTask {
        private g a;
        private RandomAccessFile b;
        private long c;
        private long d;
        private boolean e = true;
        private String f;
        private HttpURLConnection g;

        public i(g gVar, long j) {
            this.a = gVar;
            this.c = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l() {
            C21457d.this.H0(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m() {
            E.k(this.a.m).s(E.N1, this.a.e, 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n() {
            C21457d.this.q.remove(this.a.e);
            AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.tgwidgets.editor.messenger.r
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.m();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(Boolean bool) {
            if (!bool.booleanValue()) {
                E.k(this.a.m).s(E.N1, this.a.e, 2);
                return;
            }
            E eK = E.k(this.a.m);
            int i = E.M1;
            g gVar = this.a;
            eK.s(i, gVar.e, gVar.n);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(final Boolean bool) {
            C21457d.this.q.remove(this.a.e);
            AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.tgwidgets.editor.messenger.q
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.o(bool);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q() {
            C21457d.this.H0(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(long j, long j2) {
            E.k(this.a.m).s(E.L1, this.a.e, Long.valueOf(j), Long.valueOf(j2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(final long j, final long j2) {
            C21457d.this.q.put(this.a.e, new long[]{j, j2});
            AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.tgwidgets.editor.messenger.s
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.r(j, j2);
                }
            });
        }

        private void u(final long j, final long j2) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (j != j2) {
                long j3 = this.d;
                if (j3 != 0 && j3 >= jElapsedRealtime - 100) {
                    return;
                }
            }
            this.d = jElapsedRealtime;
            Utilities.f().i(new Runnable() { // from class: ir.nasim.tgwidgets.editor.messenger.l
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.s(j, j2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code restructure failed: missing block: B:101:0x013f, code lost:
        
            ir.nasim.AbstractC6403Nl2.d(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x0121, code lost:
        
            if (r7 != (-1)) goto L97;
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x0123, code lost:
        
            r2 = r12.c;
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x0127, code lost:
        
            if (r2 == 0) goto L100;
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x0129, code lost:
        
            u(r2, r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:93:0x012d, code lost:
        
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:94:0x012e, code lost:
        
            r2 = true;
            r0 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:0x0132, code lost:
        
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:96:0x0133, code lost:
        
            r2 = true;
            r0 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x0137, code lost:
        
            r0 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x0139, code lost:
        
            ir.nasim.AbstractC6403Nl2.d(r0);
         */
        /* JADX WARN: Removed duplicated region for block: B:104:0x0146 A[Catch: all -> 0x014c, TRY_LEAVE, TryCatch #5 {all -> 0x014c, blocks: (B:102:0x0142, B:104:0x0146), top: B:135:0x0142 }] */
        /* JADX WARN: Removed duplicated region for block: B:110:0x0154 A[Catch: all -> 0x0157, TRY_LEAVE, TryCatch #1 {all -> 0x0157, blocks: (B:108:0x0150, B:110:0x0154), top: B:127:0x0150 }] */
        /* JADX WARN: Removed duplicated region for block: B:117:0x0163  */
        /* JADX WARN: Removed duplicated region for block: B:129:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:139:0x0159 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x009b  */
        @Override // android.os.AsyncTask
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Boolean doInBackground(java.lang.Void... r13) {
            /*
                Method dump skipped, instructions count: 380
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.messenger.C21457d.i.doInBackground(java.lang.Void[]):java.lang.Boolean");
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() throws InterruptedException {
            C21457d.this.f0().postRunnable(new Runnable() { // from class: ir.nasim.tgwidgets.editor.messenger.m
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.l();
                }
            }, this.a.a);
            Utilities.f().i(new Runnable() { // from class: ir.nasim.tgwidgets.editor.messenger.n
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.n();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(final Boolean bool) throws InterruptedException {
            if (bool.booleanValue() || !this.e) {
                C21457d c21457d = C21457d.this;
                g gVar = this.a;
                c21457d.X(gVar.e, gVar.n, 0);
            } else {
                C21457d.this.n0(this.a.e);
            }
            Utilities.f().i(new Runnable() { // from class: ir.nasim.tgwidgets.editor.messenger.o
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.p(bool);
                }
            });
            C21457d.this.f0().postRunnable(new Runnable() { // from class: ir.nasim.tgwidgets.editor.messenger.p
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.q();
                }
            }, this.a.a);
        }

        public i(g gVar, int i, String str) {
            this.a = gVar;
            this.c = i;
            this.f = str;
        }
    }
}
