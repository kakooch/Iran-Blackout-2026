package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10086b33;
import ir.nasim.CB1;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/* renamed from: ir.nasim.Yf0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C9035Yf0 implements CB1 {
    public static final a e = new a(null);
    private final AbstractC10086b33 a;
    private final IL4 b;
    private final InterfaceC13783go6 c;
    private final EnumC19597qd2 d;

    /* renamed from: ir.nasim.Yf0$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Yf0$b */
    private static final class b extends ForwardingSource {
        private Exception a;

        public b(Source source) {
            super(source);
        }

        public final Exception a() {
            return this.a;
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer buffer, long j) throws Exception {
            try {
                return super.read(buffer, j);
            } catch (Exception e) {
                this.a = e;
                throw e;
            }
        }
    }

    /* renamed from: ir.nasim.Yf0$c */
    public static final class c implements CB1.a {
        private final EnumC19597qd2 a;
        private final InterfaceC13783go6 b;

        public c(int i, EnumC19597qd2 enumC19597qd2) {
            this.a = enumC19597qd2;
            this.b = AbstractC14984io6.b(i, 0, 2, null);
        }

        @Override // ir.nasim.CB1.a
        public CB1 a(WH6 wh6, IL4 il4, InterfaceC18663p23 interfaceC18663p23) {
            return new C9035Yf0(wh6.c(), il4, this.b, this.a);
        }

        public boolean equals(Object obj) {
            return obj instanceof c;
        }

        public int hashCode() {
            return c.class.hashCode();
        }
    }

    /* renamed from: ir.nasim.Yf0$d */
    static final class d extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return C9035Yf0.this.a(this);
        }
    }

    /* renamed from: ir.nasim.Yf0$e */
    static final class e extends AbstractC8614Ws3 implements SA2 {
        e() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C20541sB1 invoke() {
            return C9035Yf0.this.e(new BitmapFactory.Options());
        }
    }

    public C9035Yf0(AbstractC10086b33 abstractC10086b33, IL4 il4, InterfaceC13783go6 interfaceC13783go6, EnumC19597qd2 enumC19597qd2) {
        this.a = abstractC10086b33;
        this.b = il4;
        this.c = interfaceC13783go6;
        this.d = enumC19597qd2;
    }

    private final void c(BitmapFactory.Options options, C16642ld2 c16642ld2) {
        Bitmap.Config configF = this.b.f();
        if (c16642ld2.b() || AbstractC23260wd2.a(c16642ld2)) {
            configF = AbstractC10667c.e(configF);
        }
        if (this.b.d() && configF == Bitmap.Config.ARGB_8888 && AbstractC13042fc3.d(options.outMimeType, "image/jpeg")) {
            configF = Bitmap.Config.RGB_565;
        }
        if (Build.VERSION.SDK_INT >= 26 && options.outConfig == Bitmap.Config.RGBA_F16 && configF != Bitmap.Config.HARDWARE) {
            configF = Bitmap.Config.RGBA_F16;
        }
        options.inPreferredConfig = configF;
    }

    private final void d(BitmapFactory.Options options, C16642ld2 c16642ld2) {
        AbstractC10086b33.a aVarB = this.a.b();
        if ((aVarB instanceof QW5) && AbstractC17456n.b(this.b.o())) {
            options.inSampleSize = 1;
            options.inScaled = true;
            options.inDensity = ((QW5) aVarB).a();
            options.inTargetDensity = this.b.g().getResources().getDisplayMetrics().densityDpi;
            return;
        }
        if (options.outWidth <= 0 || options.outHeight <= 0) {
            options.inSampleSize = 1;
            options.inScaled = false;
            return;
        }
        int i = AbstractC23260wd2.b(c16642ld2) ? options.outHeight : options.outWidth;
        int i2 = AbstractC23260wd2.b(c16642ld2) ? options.outWidth : options.outHeight;
        PD6 pd6O = this.b.o();
        int iA = AbstractC17456n.b(pd6O) ? i : AbstractC18638p.A(pd6O.d(), this.b.n());
        PD6 pd6O2 = this.b.o();
        int iA2 = AbstractC17456n.b(pd6O2) ? i2 : AbstractC18638p.A(pd6O2.c(), this.b.n());
        int iA3 = C21144tB1.a(i, i2, iA, iA2, this.b.n());
        options.inSampleSize = iA3;
        double dB = C21144tB1.b(i / iA3, i2 / iA3, iA, iA2, this.b.n());
        if (this.b.c()) {
            dB = AbstractC23053wG5.g(dB, 1.0d);
        }
        boolean z = !(dB == 1.0d);
        options.inScaled = z;
        if (z) {
            if (dB > 1.0d) {
                options.inDensity = AbstractC20723sV3.c(Integer.MAX_VALUE / dB);
                options.inTargetDensity = Integer.MAX_VALUE;
            } else {
                options.inDensity = Integer.MAX_VALUE;
                options.inTargetDensity = AbstractC20723sV3.c(Integer.MAX_VALUE * dB);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C20541sB1 e(BitmapFactory.Options options) throws Exception {
        b bVar = new b(this.a.c());
        BufferedSource bufferedSourceBuffer = Okio.buffer(bVar);
        boolean z = true;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(bufferedSourceBuffer.peek().inputStream(), null, options);
        Exception excA = bVar.a();
        if (excA != null) {
            throw excA;
        }
        options.inJustDecodeBounds = false;
        C22664vd2 c22664vd2 = C22664vd2.a;
        C16642ld2 c16642ld2A = c22664vd2.a(options.outMimeType, bufferedSourceBuffer, this.d);
        Exception excA2 = bVar.a();
        if (excA2 != null) {
            throw excA2;
        }
        options.inMutable = false;
        if (Build.VERSION.SDK_INT >= 26 && this.b.e() != null) {
            options.inPreferredColorSpace = this.b.e();
        }
        options.inPremultiplied = this.b.m();
        c(options, c16642ld2A);
        d(options, c16642ld2A);
        try {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(bufferedSourceBuffer.inputStream(), null, options);
            YV0.a(bufferedSourceBuffer, null);
            Exception excA3 = bVar.a();
            if (excA3 != null) {
                throw excA3;
            }
            if (bitmapDecodeStream == null) {
                throw new IllegalStateException("BitmapFactory returned a null bitmap. Often this means BitmapFactory could not decode the image data read from the input source (e.g. network, disk, or memory) as it's not encoded as a valid image format.".toString());
            }
            bitmapDecodeStream.setDensity(this.b.g().getResources().getDisplayMetrics().densityDpi);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.b.g().getResources(), c22664vd2.b(bitmapDecodeStream, c16642ld2A));
            if (options.inSampleSize <= 1 && !options.inScaled) {
                z = false;
            }
            return new C20541sB1(bitmapDrawable, z);
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.CB1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(ir.nasim.InterfaceC20295rm1 r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof ir.nasim.C9035Yf0.d
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.Yf0$d r0 = (ir.nasim.C9035Yf0.d) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.Yf0$d r0 = new ir.nasim.Yf0$d
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L47
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r0 = r0.a
            ir.nasim.go6 r0 = (ir.nasim.InterfaceC13783go6) r0
            ir.nasim.AbstractC10685c16.b(r8)     // Catch: java.lang.Throwable -> L30
            goto L70
        L30:
            r8 = move-exception
            goto L7a
        L32:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L3a:
            java.lang.Object r2 = r0.b
            ir.nasim.go6 r2 = (ir.nasim.InterfaceC13783go6) r2
            java.lang.Object r5 = r0.a
            ir.nasim.Yf0 r5 = (ir.nasim.C9035Yf0) r5
            ir.nasim.AbstractC10685c16.b(r8)
            r8 = r2
            goto L5a
        L47:
            ir.nasim.AbstractC10685c16.b(r8)
            ir.nasim.go6 r8 = r7.c
            r0.a = r7
            r0.b = r8
            r0.e = r4
            java.lang.Object r2 = r8.b(r0)
            if (r2 != r1) goto L59
            return r1
        L59:
            r5 = r7
        L5a:
            ir.nasim.Yf0$e r2 = new ir.nasim.Yf0$e     // Catch: java.lang.Throwable -> L76
            r2.<init>()     // Catch: java.lang.Throwable -> L76
            r0.a = r8     // Catch: java.lang.Throwable -> L76
            r5 = 0
            r0.b = r5     // Catch: java.lang.Throwable -> L76
            r0.e = r3     // Catch: java.lang.Throwable -> L76
            java.lang.Object r0 = ir.nasim.AbstractC7757Tb3.c(r5, r2, r0, r4, r5)     // Catch: java.lang.Throwable -> L76
            if (r0 != r1) goto L6d
            return r1
        L6d:
            r6 = r0
            r0 = r8
            r8 = r6
        L70:
            ir.nasim.sB1 r8 = (ir.nasim.C20541sB1) r8     // Catch: java.lang.Throwable -> L30
            r0.release()
            return r8
        L76:
            r0 = move-exception
            r6 = r0
            r0 = r8
            r8 = r6
        L7a:
            r0.release()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9035Yf0.a(ir.nasim.rm1):java.lang.Object");
    }
}
