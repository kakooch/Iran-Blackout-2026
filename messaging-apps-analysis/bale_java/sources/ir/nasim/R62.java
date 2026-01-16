package ir.nasim;

import android.content.res.AssetManager;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import ir.nasim.R62;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes6.dex */
public final class R62 {
    public static final R62 a = new R62();
    private static final Runnable b = new Runnable() { // from class: ir.nasim.I62
        @Override // java.lang.Runnable
        public final void run() {
            R62.G();
        }
    };
    private static final HashMap c = new HashMap();
    private static final InterfaceC9173Yu3 d = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.J62
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return Integer.valueOf(R62.s());
        }
    });
    private static final InterfaceC9173Yu3 e = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.K62
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return Integer.valueOf(R62.o());
        }
    });
    private static final Paint f;
    private static final List g;
    private static final List h;
    private static HashMap i;
    private static ArrayList j;
    private static HashMap k;
    private static float l;
    private static boolean m;
    private static boolean n;
    public static final int o;

    public static final class a {
        private short a;
        private short b;
        private int c;

        public a(short s, short s2, int i) {
            this.a = s;
            this.b = s2;
            this.c = i;
        }

        public final short a() {
            return this.a;
        }

        public final short b() {
            return this.b;
        }
    }

    public static class b extends O52 {
        public static final a g = new a(null);
        public static final int h = 8;
        private static final Paint i = new Paint(2);
        private static final Rect j = new Rect();
        private final a b;
        private boolean c;
        private final boolean d;
        private int e;
        private final Runnable f;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        public /* synthetic */ b(a aVar, boolean z, boolean z2, int i2, ED1 ed1) {
            this(aVar, (i2 & 2) != 0 ? false : z, z2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(b bVar) {
            AbstractC13042fc3.i(bVar, "this$0");
            bVar.draw(new Canvas());
        }

        public Rect b() {
            Rect bounds = getBounds();
            AbstractC13042fc3.h(bounds, "getBounds(...)");
            int iCenterX = bounds.centerX();
            int iCenterY = bounds.centerY();
            Rect rect = j;
            rect.left = iCenterX - ((c() ? R62.a.v() : R62.a.w()) / 2);
            rect.right = iCenterX + ((c() ? R62.a.v() : R62.a.w()) / 2);
            rect.top = iCenterY - ((c() ? R62.a.v() : R62.a.w()) / 2);
            rect.bottom = iCenterY + ((c() ? R62.a.v() : R62.a.w()) / 2);
            return rect;
        }

        public boolean c() {
            return this.c;
        }

        public int d() {
            return this.e;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Rect bounds;
            AbstractC13042fc3.i(canvas, "canvas");
            if (!e()) {
                R62 r62 = R62.a;
                r62.J(this.b.a(), this.b.b(), this.f);
                r62.E().setColor(d());
                AbstractC13042fc3.h(getBounds(), "getBounds(...)");
                canvas.drawCircle(r1.centerX(), r1.centerY(), r1.width() * 0.4f, r62.E());
                return;
            }
            if (c()) {
                bounds = b();
            } else {
                bounds = getBounds();
                AbstractC13042fc3.f(bounds);
            }
            if (canvas.quickReject(bounds.left, bounds.top, bounds.right, bounds.bottom, Canvas.EdgeType.AA)) {
                return;
            }
            if (this.d) {
                canvas.save();
                canvas.scale(-1.0f, 1.0f, bounds.centerX(), bounds.centerY());
            }
            Object obj = ((List) R62.g.get(this.b.a())).get(this.b.b());
            AbstractC13042fc3.f(obj);
            canvas.drawBitmap((Bitmap) obj, (Rect) null, bounds, i);
            if (this.d) {
                canvas.restore();
            }
        }

        public boolean e() {
            return ((List) R62.g.get(this.b.a())).get(this.b.b()) != null;
        }

        public void g(boolean z) {
            this.c = z;
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -2;
        }

        public void h(int i2) {
            this.e = i2;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i2) {
            i.setAlpha(i2);
        }

        public b(a aVar, boolean z, boolean z2) {
            AbstractC13042fc3.i(aVar, "drawableInfo");
            this.b = aVar;
            this.c = z;
            this.d = z2;
            this.e = 268435456;
            this.f = new Runnable() { // from class: ir.nasim.S62
                @Override // java.lang.Runnable
                public final void run() {
                    R62.b.f(this.a);
                }
            };
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    public static final class c extends ImageSpan {
        private Paint.FontMetricsInt a;
        private float b;
        private int c;
        private String d;
        private boolean e;
        private float f;
        private float g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Drawable drawable, int i, Paint.FontMetricsInt fontMetricsInt) {
            super(drawable, i);
            AbstractC13042fc3.f(drawable);
            this.a = fontMetricsInt;
            this.b = 1.0f;
            this.c = AbstractC21455b.F(20.0f);
            Paint.FontMetricsInt fontMetricsInt2 = this.a;
            if (fontMetricsInt2 != null) {
                int iAbs = Math.abs(fontMetricsInt2.descent) + Math.abs(fontMetricsInt2.ascent);
                this.c = iAbs;
                if (iAbs == 0) {
                    this.c = AbstractC21455b.F(20.0f);
                }
            }
        }

        public final void a(Paint.FontMetricsInt fontMetricsInt) {
            this.a = fontMetricsInt;
            if (fontMetricsInt != null) {
                AbstractC13042fc3.f(fontMetricsInt);
                double dAbs = Math.abs(fontMetricsInt.descent);
                AbstractC13042fc3.f(this.a);
                int iAbs = (int) (dAbs + Math.abs(r5.ascent));
                this.c = iAbs;
                if (iAbs == 0) {
                    this.c = AbstractC21455b.F(20.0f);
                }
            }
        }

        public final void b(Paint.FontMetricsInt fontMetricsInt, int i) {
            this.a = fontMetricsInt;
            this.c = i;
        }

        public final void c(String str) {
            this.d = str;
        }

        public final void d(float f) {
            this.b = f;
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            AbstractC13042fc3.i(canvas, "canvas");
            AbstractC13042fc3.i(charSequence, ParameterNames.TEXT);
            AbstractC13042fc3.i(paint, "paint");
            this.f = (this.c / 2.0f) + f;
            this.g = i3 + ((i5 - i3) / 2.0f);
            boolean z = true;
            this.e = true;
            if (paint.getAlpha() == 255 || !R62.a.B()) {
                z = false;
            } else {
                getDrawable().setAlpha(paint.getAlpha());
            }
            float fDescent = (((i4 + paint.descent()) - getDrawable().getBounds().bottom) - (this.c != getDrawable().getBounds().height() ? (r9 - r4) / 2 : 0)) + R62.a.C();
            int iSave = canvas.save();
            canvas.translate(f, fDescent);
            try {
                getDrawable().draw(canvas);
                if (z) {
                    getDrawable().setAlpha(255);
                }
            } finally {
                canvas.restoreToCount(iSave);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !AbstractC13042fc3.d(c.class, obj.getClass())) {
                return false;
            }
            c cVar = (c) obj;
            return Float.compare(this.b, cVar.b) == 0 && this.c == cVar.c && AbstractC13042fc3.d(this.d, cVar.d);
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            AbstractC13042fc3.i(paint, "paint");
            AbstractC13042fc3.i(charSequence, ParameterNames.TEXT);
            if (fontMetricsInt == null) {
                fontMetricsInt = new Paint.FontMetricsInt();
            }
            Paint.FontMetricsInt fontMetricsInt2 = this.a;
            if (fontMetricsInt2 != null) {
                fontMetricsInt.ascent = fontMetricsInt2.ascent;
                fontMetricsInt.descent = fontMetricsInt2.descent;
                fontMetricsInt.top = fontMetricsInt2.top;
                fontMetricsInt.bottom = fontMetricsInt2.bottom;
                if (getDrawable() != null) {
                    Drawable drawable = getDrawable();
                    int i3 = this.c;
                    drawable.setBounds(0, 0, i3, i3);
                }
                return this.c;
            }
            int size = super.getSize(paint, charSequence, i, i2, fontMetricsInt);
            int iF = AbstractC21455b.F(8.0f);
            int iF2 = AbstractC21455b.F(10.0f);
            int i4 = (-iF2) - iF;
            fontMetricsInt.top = i4;
            int i5 = iF2 - iF;
            fontMetricsInt.bottom = i5;
            fontMetricsInt.ascent = i4;
            fontMetricsInt.leading = 0;
            fontMetricsInt.descent = i5;
            return size;
        }

        @Override // android.text.style.ReplacementSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            AbstractC13042fc3.i(textPaint, "ds");
            if (getDrawable() instanceof b) {
                Drawable drawable = getDrawable();
                AbstractC13042fc3.g(drawable, "null cannot be cast to non-null type ir.nasim.features.smiles.EmojiUtils.EmojiDrawable");
                ((b) drawable).h(285212671 & textPaint.getColor());
            }
            super.updateDrawState(textPaint);
        }
    }

    public static final class d extends e {
        @Override // ir.nasim.R62.e
        public ImageSpan a(Drawable drawable, int i, Paint.FontMetricsInt fontMetricsInt) {
            return new c(drawable, 0, fontMetricsInt);
        }
    }

    public static abstract class e {
        public abstract ImageSpan a(Drawable drawable, int i, Paint.FontMetricsInt fontMetricsInt);
    }

    public static final class f {
        private int a;
        private int b;
        private CharSequence c;

        public f(int i, int i2, CharSequence charSequence) {
            this.a = i;
            this.b = i2;
            this.c = charSequence;
        }

        public final CharSequence a() {
            return this.c;
        }

        public final int b() {
            return this.b;
        }

        public final int c() {
            return this.a;
        }
    }

    static {
        Paint paint = new Paint();
        paint.setColor(0);
        f = paint;
        ArrayList arrayList = new ArrayList(8);
        for (int i2 = 0; i2 < 8; i2++) {
            int length = T52.k[i2].length;
            ArrayList arrayList2 = new ArrayList(length);
            for (int i3 = 0; i3 < length; i3++) {
                arrayList2.add(null);
            }
            arrayList.add(arrayList2);
        }
        g = arrayList;
        ArrayList arrayList3 = new ArrayList(8);
        for (int i4 = 0; i4 < 8; i4++) {
            int length2 = T52.k[i4].length;
            ArrayList arrayList4 = new ArrayList(length2);
            for (int i5 = 0; i5 < length2; i5++) {
                arrayList4.add(Boolean.FALSE);
            }
            arrayList3.add(arrayList4);
        }
        h = arrayList3;
        i = new HashMap();
        j = new ArrayList();
        k = new HashMap();
        int length3 = T52.k.length;
        for (int i6 = 0; i6 < length3; i6++) {
            int length4 = T52.k[i6].length;
            for (int i7 = 0; i7 < length4; i7++) {
                c.put(T52.k[i6][i7], new a((byte) i6, (short) i7, i7));
            }
        }
        o = 8;
    }

    private R62() {
    }

    public static final b A(CharSequence charSequence) {
        a aVarX = x(charSequence);
        if (aVarX == null) {
            return null;
        }
        R62 r62 = a;
        b bVar = new b(aVarX, false, r62.t(charSequence), 2, null);
        bVar.setBounds(0, 0, r62.w(), r62.w());
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G() {
        C15225jD4.b().c(C15225jD4.i, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(final short s, final short s2, final Runnable runnable) {
        if (((List) g.get(s)).get(s2) == null) {
            List list = h;
            if (((Boolean) ((List) list.get(s)).get(s2)).booleanValue()) {
                return;
            }
            ((List) list.get(s)).set(s2, Boolean.TRUE);
            Utilities.e.i(new Runnable() { // from class: ir.nasim.H62
                @Override // java.lang.Runnable
                public final void run() {
                    R62.K(s, s2, runnable);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(short s, short s2, Runnable runnable) {
        a.L(s, s2);
        ((List) h.get(s)).set(s2, Boolean.FALSE);
        if (runnable != null) {
            AbstractC21455b.m1(runnable);
        }
    }

    private final void L(short s, short s2) {
        try {
            int i2 = AbstractC21455b.g <= 1.0f ? 2 : 1;
            Bitmap bitmapDecodeStream = null;
            try {
                AssetManager assets = C5721Ko.a.d().getAssets();
                DY6 dy6 = DY6.a;
                String str = String.format(Locale.US, "%d_%d.png", Arrays.copyOf(new Object[]{Short.valueOf(s), Short.valueOf(s2)}, 2));
                AbstractC13042fc3.h(str, "format(...)");
                InputStream inputStreamOpen = assets.open("emoji/" + str);
                AbstractC13042fc3.h(inputStreamOpen, "open(...)");
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = false;
                options.inSampleSize = i2;
                bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen, null, options);
                inputStreamOpen.close();
            } catch (Throwable th) {
                C19406qI3.a("EmojiUtils", "loadEmojiInternal error= " + th, new Object[0]);
            }
            ((List) g.get(s)).set(s2, bitmapDecodeStream);
        } catch (Throwable th2) {
            C19406qI3.a("EmojiUtils", "loadEmojiInternal(2) error= " + th2, new Object[0]);
        }
    }

    public static final void M() {
        if (n) {
            return;
        }
        n = true;
        C9248Zc6 c9248Zc6H = new C9248Zc6(new InterfaceC7298Rc6() { // from class: ir.nasim.N62
            @Override // ir.nasim.InterfaceC7298Rc6
            public final Object run() {
                return R62.N();
            }
        }).h(EnumC11723dV1.IO);
        AbstractC13042fc3.h(c9248Zc6H, "subscribeOn(...)");
        SZ.e(c9248Zc6H);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:143:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0077 A[Catch: Exception -> 0x0062, TryCatch #1 {Exception -> 0x0062, blocks: (B:3:0x0012, B:5:0x001d, B:7:0x0023, B:9:0x0029, B:11:0x003b, B:12:0x0043, B:14:0x0049, B:17:0x0056, B:21:0x0069, B:23:0x0077, B:25:0x008c, B:26:0x0094, B:28:0x009a, B:31:0x00a7, B:33:0x00b7, B:36:0x00d0, B:39:0x00f8, B:40:0x00fd, B:42:0x0103, B:43:0x0113, B:32:0x00b3, B:20:0x0065, B:44:0x0119, B:72:0x01da, B:74:0x01e2, B:76:0x01e9, B:79:0x0236, B:80:0x0246, B:81:0x024f, B:45:0x0123, B:47:0x012b, B:49:0x0131, B:51:0x0143, B:52:0x014b, B:54:0x0151, B:57:0x015e, B:59:0x016f, B:61:0x017e, B:63:0x0192, B:64:0x019a, B:66:0x01a0, B:69:0x01ad, B:71:0x01be, B:70:0x01ba, B:58:0x016b), top: B:119:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x017e A[Catch: Exception -> 0x0062, TryCatch #1 {Exception -> 0x0062, blocks: (B:3:0x0012, B:5:0x001d, B:7:0x0023, B:9:0x0029, B:11:0x003b, B:12:0x0043, B:14:0x0049, B:17:0x0056, B:21:0x0069, B:23:0x0077, B:25:0x008c, B:26:0x0094, B:28:0x009a, B:31:0x00a7, B:33:0x00b7, B:36:0x00d0, B:39:0x00f8, B:40:0x00fd, B:42:0x0103, B:43:0x0113, B:32:0x00b3, B:20:0x0065, B:44:0x0119, B:72:0x01da, B:74:0x01e2, B:76:0x01e9, B:79:0x0236, B:80:0x0246, B:81:0x024f, B:45:0x0123, B:47:0x012b, B:49:0x0131, B:51:0x0143, B:52:0x014b, B:54:0x0151, B:57:0x015e, B:59:0x016f, B:61:0x017e, B:63:0x0192, B:64:0x019a, B:66:0x01a0, B:69:0x01ad, B:71:0x01be, B:70:0x01ba, B:58:0x016b), top: B:119:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0274 A[Catch: Exception -> 0x02b4, TryCatch #0 {Exception -> 0x02b4, blocks: (B:84:0x026c, B:86:0x0274, B:88:0x027a, B:90:0x028c, B:91:0x0294, B:93:0x029a, B:96:0x02a7, B:100:0x02ba, B:102:0x02c9, B:104:0x02dd, B:105:0x02e5, B:107:0x02eb, B:110:0x02f8, B:112:0x0309, B:111:0x0305, B:99:0x02b6), top: B:117:0x026c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Void N() {
        /*
            Method dump skipped, instructions count: 826
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.R62.N():java.lang.Void");
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0188 A[PHI: r9 r13
      0x0188: PHI (r9v2 int) = (r9v1 int), (r9v1 int), (r9v1 int), (r9v1 int), (r9v1 int), (r9v1 int), (r9v7 int), (r9v1 int), (r9v1 int) binds: [B:84:0x010c, B:86:0x0110, B:95:0x013c, B:97:0x0146, B:99:0x0150, B:101:0x0155, B:114:0x0186, B:90:0x0124, B:92:0x0129] A[DONT_GENERATE, DONT_INLINE]
      0x0188: PHI (r13v7 int) = (r13v6 int), (r13v6 int), (r13v6 int), (r13v6 int), (r13v6 int), (r13v6 int), (r13v19 int), (r13v6 int), (r13v6 int) binds: [B:84:0x010c, B:86:0x0110, B:95:0x013c, B:97:0x0146, B:99:0x0150, B:101:0x0155, B:114:0x0186, B:90:0x0124, B:92:0x0129] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x018f A[Catch: Exception -> 0x006d, TryCatch #0 {Exception -> 0x006d, blocks: (B:9:0x0026, B:27:0x0060, B:85:0x010e, B:87:0x0112, B:89:0x011d, B:93:0x012b, B:119:0x018f, B:121:0x0193, B:125:0x01a0, B:127:0x01a6, B:144:0x01d1, B:146:0x01d5, B:152:0x01df, B:155:0x01e6, B:157:0x01eb, B:159:0x01ef, B:161:0x01fa, B:165:0x0208, B:168:0x0218, B:169:0x021f, B:94:0x0137, B:96:0x013e, B:98:0x0148, B:102:0x0157, B:104:0x015d, B:105:0x0164, B:107:0x016c, B:108:0x0173, B:110:0x017d, B:114:0x0186, B:16:0x003b, B:18:0x0046, B:31:0x0070, B:39:0x0082, B:40:0x0085, B:42:0x008f, B:44:0x0098, B:48:0x00a2, B:57:0x00b7, B:66:0x00d4, B:71:0x00e5, B:83:0x0104), top: B:182:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01e4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01eb A[Catch: Exception -> 0x006d, TryCatch #0 {Exception -> 0x006d, blocks: (B:9:0x0026, B:27:0x0060, B:85:0x010e, B:87:0x0112, B:89:0x011d, B:93:0x012b, B:119:0x018f, B:121:0x0193, B:125:0x01a0, B:127:0x01a6, B:144:0x01d1, B:146:0x01d5, B:152:0x01df, B:155:0x01e6, B:157:0x01eb, B:159:0x01ef, B:161:0x01fa, B:165:0x0208, B:168:0x0218, B:169:0x021f, B:94:0x0137, B:96:0x013e, B:98:0x0148, B:102:0x0157, B:104:0x015d, B:105:0x0164, B:107:0x016c, B:108:0x0173, B:110:0x017d, B:114:0x0186, B:16:0x003b, B:18:0x0046, B:31:0x0070, B:39:0x0082, B:40:0x0085, B:42:0x008f, B:44:0x0098, B:48:0x00a2, B:57:0x00b7, B:66:0x00d4, B:71:0x00e5, B:83:0x0104), top: B:182:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x010e A[Catch: Exception -> 0x006d, TryCatch #0 {Exception -> 0x006d, blocks: (B:9:0x0026, B:27:0x0060, B:85:0x010e, B:87:0x0112, B:89:0x011d, B:93:0x012b, B:119:0x018f, B:121:0x0193, B:125:0x01a0, B:127:0x01a6, B:144:0x01d1, B:146:0x01d5, B:152:0x01df, B:155:0x01e6, B:157:0x01eb, B:159:0x01ef, B:161:0x01fa, B:165:0x0208, B:168:0x0218, B:169:0x021f, B:94:0x0137, B:96:0x013e, B:98:0x0148, B:102:0x0157, B:104:0x015d, B:105:0x0164, B:107:0x016c, B:108:0x0173, B:110:0x017d, B:114:0x0186, B:16:0x003b, B:18:0x0046, B:31:0x0070, B:39:0x0082, B:40:0x0085, B:42:0x008f, B:44:0x0098, B:48:0x00a2, B:57:0x00b7, B:66:0x00d4, B:71:0x00e5, B:83:0x0104), top: B:182:0x0026 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.ArrayList O(java.lang.CharSequence r21, int[] r22) {
        /*
            Method dump skipped, instructions count: 621
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.R62.O(java.lang.CharSequence, int[]):java.util.ArrayList");
    }

    public static /* synthetic */ ArrayList P(CharSequence charSequence, int[] iArr, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            iArr = null;
        }
        return O(charSequence, iArr);
    }

    public static final void Q() {
        for (String[] strArr : T52.k) {
            a.R(strArr);
        }
    }

    public static final CharSequence S(CharSequence charSequence, Paint.FontMetricsInt fontMetricsInt, int i2, boolean z) {
        return W(charSequence, fontMetricsInt, i2, z, null, null, 48, null);
    }

    public static final CharSequence T(CharSequence charSequence, Paint.FontMetricsInt fontMetricsInt, int i2, boolean z, int[] iArr) {
        return W(charSequence, fontMetricsInt, i2, z, iArr, null, 32, null);
    }

    public static final CharSequence U(CharSequence charSequence, Paint.FontMetricsInt fontMetricsInt, int i2, boolean z, int[] iArr, e eVar) {
        Spannable spannableNewSpannable;
        AbstractC13042fc3.i(eVar, "emojiSpanFactory");
        if (charSequence == null || charSequence.length() == 0) {
            return charSequence;
        }
        if (z || !(charSequence instanceof Spannable)) {
            spannableNewSpannable = Spannable.Factory.getInstance().newSpannable(charSequence.toString());
            AbstractC13042fc3.f(spannableNewSpannable);
        } else {
            spannableNewSpannable = (Spannable) charSequence;
        }
        ArrayList arrayListO = O(spannableNewSpannable, iArr);
        if (arrayListO.isEmpty()) {
            return charSequence;
        }
        int size = arrayListO.size();
        for (int i3 = 0; i3 < size; i3++) {
            try {
                Object obj = arrayListO.get(i3);
                AbstractC13042fc3.h(obj, "get(...)");
                f fVar = (f) obj;
                b bVarA = A(fVar.a());
                if (bVarA != null) {
                    ImageSpan imageSpanA = eVar.a(bVarA, i2, fontMetricsInt);
                    String strValueOf = null;
                    if (!(imageSpanA instanceof c)) {
                        AbstractC13042fc3.g(imageSpanA, "null cannot be cast to non-null type ir.nasim.features.smiles.EmojiUtils.ReactionEmojiSpan");
                        AbstractC18350oW3.a(imageSpanA);
                        if (fVar.a() != null) {
                            String.valueOf(fVar.a());
                        }
                        throw null;
                    }
                    c cVar = (c) imageSpanA;
                    if (fVar.a() != null) {
                        strValueOf = String.valueOf(fVar.a());
                    }
                    cVar.c(strValueOf);
                    spannableNewSpannable.setSpan(imageSpanA, fVar.c(), fVar.b(), 33);
                } else {
                    continue;
                }
            } catch (Exception e2) {
                C19406qI3.a("EmojiUtils", "replaceEmoji error= " + e2, new Object[0]);
            }
        }
        return spannableNewSpannable;
    }

    public static final CharSequence V(CharSequence charSequence, Paint.FontMetricsInt fontMetricsInt, boolean z) {
        return W(charSequence, fontMetricsInt, 0, z, null, null, 32, null);
    }

    public static /* synthetic */ CharSequence W(CharSequence charSequence, Paint.FontMetricsInt fontMetricsInt, int i2, boolean z, int[] iArr, e eVar, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            iArr = null;
        }
        int[] iArr2 = iArr;
        if ((i3 & 32) != 0) {
            eVar = new d();
        }
        return U(charSequence, fontMetricsInt, i2, z, iArr2, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void Y() {
        InterfaceC3570Bk5 interfaceC3570Bk5Q = C7183Qq.q(EnumC18608ow5.j);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : k.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(str);
            sb.append(Separators.EQUALS);
            sb.append(str2);
        }
        interfaceC3570Bk5Q.putString("color", sb.toString());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void a0() {
        InterfaceC3570Bk5 interfaceC3570Bk5Q = C7183Qq.q(EnumC18608ow5.j);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : i.entrySet()) {
            String str = (String) entry.getKey();
            int iIntValue = ((Number) entry.getValue()).intValue();
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(str);
            sb.append(Separators.EQUALS);
            sb.append(iIntValue);
        }
        interfaceC3570Bk5Q.putString("emojis2", sb.toString());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int c0(String str, String str2) {
        AbstractC13042fc3.i(str, "lhs");
        AbstractC13042fc3.i(str2, "rhs");
        Integer num = (Integer) i.get(str);
        int iIntValue = num != null ? num.intValue() : 0;
        Integer num2 = (Integer) i.get(str2);
        int iIntValue2 = num2 != null ? num2.intValue() : 0;
        if (iIntValue > iIntValue2) {
            return -1;
        }
        return iIntValue < iIntValue2 ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int d0(InterfaceC14603iB2 interfaceC14603iB2, Object obj, Object obj2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$tmp0");
        return ((Number) interfaceC14603iB2.invoke(obj, obj2)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int o() {
        return AbstractC21455b.F(AbstractC21455b.F0() ? 40.0f : 34.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void q() {
        C7183Qq.q(EnumC18608ow5.j).g("filled_default", true);
        i.clear();
        j.clear();
        a.Z();
        return null;
    }

    public static final boolean r(String str) {
        AbstractC13042fc3.i(str, "input");
        int length = T52.h.length;
        for (int i2 = 0; i2 < length; i2++) {
            int length2 = T52.h[i2].length;
            for (int i3 = 0; i3 < length2; i3++) {
                if (AbstractC20762sZ6.X(str, T52.h[i2][i3], false, 2, null)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int s() {
        return AbstractC21455b.F(20.0f);
    }

    private final boolean t(CharSequence charSequence) {
        return charSequence != null && charSequence.length() > 2 && charSequence.charAt(charSequence.length() - 2) == 8205 && charSequence.charAt(charSequence.length() - 1) == 10145;
    }

    public static final a x(CharSequence charSequence) {
        CharSequence charSequence2;
        if (a.t(charSequence)) {
            charSequence = charSequence != null ? charSequence.subSequence(0, charSequence.length() - 2) : null;
        }
        HashMap map = c;
        Object obj = map.get(charSequence);
        if (obj == null && (charSequence2 = (CharSequence) T52.p.get(charSequence)) != null) {
            obj = map.get(charSequence2);
        }
        return (a) obj;
    }

    public final boolean B() {
        return m;
    }

    public final float C() {
        return l;
    }

    public final String D(String str, String[] strArr) {
        AbstractC13042fc3.i(str, "coloredEmoji");
        String strM = AbstractC20153rZ6.M(str, "🏻", "", false, 4, null);
        String str2 = !AbstractC13042fc3.d(strM, str) ? "🏻" : null;
        if (str2 == null) {
            strM = AbstractC20153rZ6.M(str, "🏼", "", false, 4, null);
            if (!AbstractC13042fc3.d(strM, str)) {
                str2 = "🏼";
            }
        }
        if (str2 == null) {
            strM = AbstractC20153rZ6.M(str, "🏽", "", false, 4, null);
            if (!AbstractC13042fc3.d(strM, str)) {
                str2 = "🏽";
            }
        }
        if (str2 == null) {
            strM = AbstractC20153rZ6.M(str, "🏾", "", false, 4, null);
            if (!AbstractC13042fc3.d(strM, str)) {
                str2 = "🏾";
            }
        }
        if (str2 == null) {
            strM = AbstractC20153rZ6.M(str, "🏿", "", false, 4, null);
            if (!AbstractC13042fc3.d(strM, str)) {
                str2 = "🏿";
            }
        }
        if (strArr != null) {
            strArr[0] = str2;
        }
        return strM;
    }

    public final Paint E() {
        return f;
    }

    public final ArrayList F() {
        return j;
    }

    public final boolean H(char c2) {
        int type = Character.getType(c2);
        return type == 19 || type == 28;
    }

    public final boolean I(CharSequence charSequence) {
        AbstractC13042fc3.i(charSequence, "code");
        return (TextUtils.isEmpty(charSequence) || x(charSequence) == null) ? false : true;
    }

    public final void R(String[] strArr) {
        AbstractC13042fc3.i(strArr, "pack");
        for (String str : strArr) {
            a aVarX = x(str);
            if (aVarX != null) {
                short sA = aVarX.a();
                short sB = aVarX.b();
                if (((List) g.get(sA)).get(sB) == null) {
                    List list = h;
                    if (((Boolean) ((List) list.get(sA)).get(sB)).booleanValue()) {
                        return;
                    }
                    ((List) list.get(sA)).set(sB, Boolean.TRUE);
                    L(sA, sB);
                    ((List) list.get(sA)).set(sB, Boolean.FALSE);
                } else {
                    continue;
                }
            }
        }
        Runnable runnable = b;
        AbstractC21455b.t(runnable);
        AbstractC21455b.m1(runnable);
    }

    public final void X() {
        C9248Zc6 c9248Zc6H = new C9248Zc6(new InterfaceC7298Rc6() { // from class: ir.nasim.M62
            @Override // ir.nasim.InterfaceC7298Rc6
            public final Object run() {
                return R62.Y();
            }
        }).h(EnumC11723dV1.IO);
        AbstractC13042fc3.h(c9248Zc6H, "subscribeOn(...)");
        SZ.e(c9248Zc6H);
    }

    public final void Z() {
        C9248Zc6 c9248Zc6H = new C9248Zc6(new InterfaceC7298Rc6() { // from class: ir.nasim.O62
            @Override // ir.nasim.InterfaceC7298Rc6
            public final Object run() {
                return R62.a0();
            }
        }).h(EnumC11723dV1.IO);
        AbstractC13042fc3.h(c9248Zc6H, "subscribeOn(...)");
        SZ.e(c9248Zc6H);
    }

    public final void b0() {
        j.clear();
        Iterator it = i.entrySet().iterator();
        while (it.hasNext()) {
            j.add((String) ((Map.Entry) it.next()).getKey());
        }
        ArrayList arrayList = j;
        final InterfaceC14603iB2 interfaceC14603iB2 = new InterfaceC14603iB2() { // from class: ir.nasim.P62
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(R62.c0((String) obj, (String) obj2));
            }
        };
        AbstractC12992fX0.B(arrayList, new Comparator() { // from class: ir.nasim.Q62
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return R62.d0(interfaceC14603iB2, obj, obj2);
            }
        });
        while (j.size() > 48) {
            j.remove(r0.size() - 1);
        }
    }

    public final String m(String str, String str2) {
        boolean z;
        String strSubstring;
        AbstractC13042fc3.i(str, "code");
        AbstractC13042fc3.i(str2, "color");
        if (t(str)) {
            str = str.substring(0, str.length() - 2);
            AbstractC13042fc3.h(str, "substring(...)");
            z = true;
        } else {
            z = false;
        }
        int length = str.length();
        if (length > 2 && str.charAt(str.length() - 2) == 8205) {
            strSubstring = str.substring(str.length() - 2);
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            str = str.substring(0, str.length() - 2);
            AbstractC13042fc3.h(str, "substring(...)");
        } else if (length <= 3 || str.charAt(str.length() - 3) != 8205) {
            strSubstring = null;
        } else {
            strSubstring = str.substring(str.length() - 3);
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            str = str.substring(0, str.length() - 3);
            AbstractC13042fc3.h(str, "substring(...)");
        }
        String str3 = str + str2;
        if (strSubstring != null) {
            str3 = str3 + strSubstring;
        }
        if (!z) {
            return str3;
        }
        return str3 + "\u200d➡";
    }

    public final void n(String str) {
        AbstractC13042fc3.i(str, "code");
        Integer num = (Integer) i.get(str);
        if (num == null) {
            num = 0;
        }
        if (num.intValue() == 0 && i.size() >= 48) {
            Object obj = j.get(r1.size() - 1);
            AbstractC13042fc3.h(obj, "get(...)");
            i.remove((String) obj);
            j.set(r1.size() - 1, str);
        }
        i.put(str, Integer.valueOf(num.intValue() + 1));
    }

    public final void p() {
        C9248Zc6 c9248Zc6H = new C9248Zc6(new InterfaceC7298Rc6() { // from class: ir.nasim.L62
            @Override // ir.nasim.InterfaceC7298Rc6
            public final Object run() {
                return R62.q();
            }
        }).h(EnumC11723dV1.IO);
        AbstractC13042fc3.h(c9248Zc6H, "subscribeOn(...)");
        SZ.e(c9248Zc6H);
    }

    public final String u(String str) {
        AbstractC13042fc3.i(str, "emoji");
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            if (55356 > cCharAt || cCharAt >= 55359) {
                if (cCharAt == 8419) {
                    return str;
                }
                if (8252 <= cCharAt && cCharAt < 12954 && T52.l.containsKey(Character.valueOf(cCharAt))) {
                    i2++;
                    String strSubstring = str.substring(0, i2);
                    AbstractC13042fc3.h(strSubstring, "substring(...)");
                    String strSubstring2 = str.substring(i2);
                    AbstractC13042fc3.h(strSubstring2, "substring(...)");
                    str = strSubstring + "️" + strSubstring2;
                    length++;
                }
            } else if (cCharAt != 55356 || i2 >= length - 1) {
                i2++;
            } else {
                int i3 = i2 + 1;
                char cCharAt2 = str.charAt(i3);
                if (cCharAt2 == 56879 || cCharAt2 == 56324 || cCharAt2 == 56858 || cCharAt2 == 56703) {
                    i2 += 2;
                    String strSubstring3 = str.substring(0, i2);
                    AbstractC13042fc3.h(strSubstring3, "substring(...)");
                    String strSubstring4 = str.substring(i2);
                    AbstractC13042fc3.h(strSubstring4, "substring(...)");
                    str = strSubstring3 + "️" + strSubstring4;
                    length++;
                } else {
                    i2 = i3;
                }
            }
            i2++;
        }
        return str;
    }

    public final int v() {
        return ((Number) e.getValue()).intValue();
    }

    public final int w() {
        return ((Number) d.getValue()).intValue();
    }

    public final Drawable y(String str) {
        AbstractC13042fc3.i(str, "code");
        b bVarA = A(str);
        if (bVarA == null) {
            bVarA = A((CharSequence) T52.p.get(str));
        }
        if (bVarA == null) {
            return null;
        }
        R62 r62 = a;
        bVarA.setBounds(0, 0, r62.v(), r62.v());
        bVarA.g(true);
        return bVarA;
    }

    public final HashMap z() {
        return k;
    }
}
