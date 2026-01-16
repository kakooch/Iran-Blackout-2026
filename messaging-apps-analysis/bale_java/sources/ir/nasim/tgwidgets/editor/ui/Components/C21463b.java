package ir.nasim.tgwidgets.editor.ui.Components;

import android.gov.nist.core.Separators;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.View;
import ir.nasim.AbstractC11500d67;
import ir.nasim.AbstractC18106o57;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.AbstractC8662Wx6;
import ir.nasim.AbstractC8814Xl0;
import ir.nasim.C10743c74;
import ir.nasim.C24445yd7;
import ir.nasim.C24687z23;
import ir.nasim.C4278El2;
import ir.nasim.JQ5;
import ir.nasim.tgwidgets.editor.SQLite.SQLiteCursor;
import ir.nasim.tgwidgets.editor.SQLite.SQLiteDatabase;
import ir.nasim.tgwidgets.editor.SQLite.SQLiteException;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.C21457d;
import ir.nasim.tgwidgets.editor.messenger.ImageReceiver;
import ir.nasim.tgwidgets.editor.tgnet.ConnectionsManager;
import ir.nasim.tgwidgets.editor.tgnet.NativeByteBuffer;
import ir.nasim.tgwidgets.editor.ui.Components.AnimatedEmojiSpan;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;

/* renamed from: ir.nasim.tgwidgets.editor.ui.Components.b, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C21463b extends Drawable {
    private static SparseArray o = null;
    private static boolean p = false;
    private static HashMap q;
    private static boolean r;
    private static boolean s;
    public static int t;
    public static ArrayList u;
    private boolean a;
    private ArrayList b;
    private ArrayList c;
    public int d;
    private AbstractC18106o57 e;
    private long f;
    private int g;
    private int h;
    private String i;
    private ImageReceiver j;
    private float k = 1.0f;
    private Boolean l = null;
    private Boolean m = null;
    private ColorFilter n;

    /* renamed from: ir.nasim.tgwidgets.editor.ui.Components.b$a */
    class a extends ImageReceiver {
        a() {
        }

        @Override // ir.nasim.tgwidgets.editor.messenger.ImageReceiver
        protected boolean X0(Drawable drawable, String str, int i, boolean z, int i2) {
            C21463b.this.n();
            return super.X0(drawable, str, i, z, i2);
        }

        @Override // ir.nasim.tgwidgets.editor.messenger.ImageReceiver
        public void h0() {
            C21463b.this.n();
            super.h0();
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.Components.b$b, reason: collision with other inner class name */
    public static class C1593b {
        private HashMap a;
        private HashMap b;
        private HashSet c;
        private Runnable d;
        private Runnable e;
        private final int f;

        public C1593b(int i) {
            this.f = i;
        }

        private boolean f() {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                return true;
            }
            if (!AbstractC8814Xl0.a) {
                return false;
            }
            AbstractC6403Nl2.c("EmojiDocumentFetcher", new IllegalStateException("Wrong thread"));
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h() {
            ArrayList arrayList = new ArrayList(this.c);
            this.c.clear();
            m(arrayList, this.e == null);
            this.d = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(final ArrayList arrayList, final HashSet hashSet) {
            AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.Ps
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.j(arrayList, hashSet);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(ArrayList arrayList) {
            ir.nasim.tgwidgets.editor.messenger.D dF = ir.nasim.tgwidgets.editor.messenger.D.F(this.f);
            SQLiteDatabase sQLiteDatabaseD = dF.D();
            if (sQLiteDatabaseD == null) {
                return;
            }
            try {
                SQLiteCursor sQLiteCursorG = sQLiteDatabaseD.g(String.format(Locale.US, "SELECT data FROM animated_emoji WHERE document_id IN (%s)", TextUtils.join(",", arrayList)), new Object[0]);
                ArrayList arrayList2 = new ArrayList();
                HashSet hashSet = new HashSet(arrayList);
                while (sQLiteCursorG.h()) {
                    NativeByteBuffer nativeByteBufferB = sQLiteCursorG.b(0);
                    try {
                        AbstractC18106o57 abstractC18106o57D = AbstractC18106o57.d(nativeByteBufferB, nativeByteBufferB.e(true), true);
                        if (abstractC18106o57D != null && abstractC18106o57D.c != 0) {
                            arrayList2.add(abstractC18106o57D);
                            hashSet.remove(Long.valueOf(abstractC18106o57D.c));
                        }
                    } catch (Exception e) {
                        AbstractC6403Nl2.d(e);
                    }
                    if (nativeByteBufferB != null) {
                        nativeByteBufferB.t();
                    }
                }
                o(arrayList2, hashSet);
                sQLiteCursorG.d();
                Runnable runnable = this.e;
                if (runnable != null) {
                    runnable.run();
                    this.e = null;
                }
            } catch (SQLiteException e2) {
                dF.x(e2);
            }
        }

        private void m(final ArrayList arrayList, boolean z) {
            if (z) {
                ir.nasim.tgwidgets.editor.messenger.D.F(this.f).G().i(new Runnable() { // from class: ir.nasim.Ns
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.i(arrayList);
                    }
                });
            } else {
                i(arrayList);
            }
        }

        private void n(final ArrayList arrayList) {
            C24445yd7 c24445yd7 = new C24445yd7();
            c24445yd7.b = arrayList;
            ConnectionsManager.k(this.f).m(c24445yd7, new JQ5() { // from class: ir.nasim.Qs
            });
        }

        private void o(final ArrayList arrayList, final HashSet hashSet) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                j(arrayList, hashSet);
            } else {
                ir.nasim.tgwidgets.editor.messenger.E.k(this.f).h(new Runnable() { // from class: ir.nasim.Os
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.k(arrayList, hashSet);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public void j(ArrayList arrayList, HashSet hashSet) {
            p(arrayList);
            if (hashSet.isEmpty()) {
                return;
            }
            n(new ArrayList(hashSet));
        }

        public void g(long j, c cVar) {
            AbstractC18106o57 abstractC18106o57;
            synchronized (this) {
                try {
                    HashMap map = this.a;
                    if (map != null && (abstractC18106o57 = (AbstractC18106o57) map.get(Long.valueOf(j))) != null) {
                        if (cVar != null) {
                            cVar.a(abstractC18106o57);
                        }
                        return;
                    }
                    if (f()) {
                        if (this.b == null) {
                            this.b = new HashMap();
                        }
                        ArrayList arrayList = (ArrayList) this.b.get(Long.valueOf(j));
                        if (arrayList != null) {
                            arrayList.add(cVar);
                            return;
                        }
                        ArrayList arrayList2 = new ArrayList(1);
                        arrayList2.add(cVar);
                        this.b.put(Long.valueOf(j), arrayList2);
                        if (this.c == null) {
                            this.c = new HashSet();
                        }
                        this.c.add(Long.valueOf(j));
                        if (this.d != null) {
                            return;
                        }
                        Runnable runnable = new Runnable() { // from class: ir.nasim.Ms
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.a.h();
                            }
                        };
                        this.d = runnable;
                        AbstractC21455b.m1(runnable);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void p(ArrayList arrayList) {
            ArrayList arrayList2;
            if (f()) {
                C21463b.A();
                for (int i = 0; i < arrayList.size(); i++) {
                    if (arrayList.get(i) instanceof AbstractC18106o57) {
                        AbstractC18106o57 abstractC18106o57 = (AbstractC18106o57) arrayList.get(i);
                        r(abstractC18106o57);
                        HashMap map = this.b;
                        if (map != null && (arrayList2 = (ArrayList) map.remove(Long.valueOf(abstractC18106o57.c))) != null) {
                            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                                c cVar = (c) arrayList2.get(i2);
                                if (cVar != null) {
                                    cVar.a(abstractC18106o57);
                                }
                            }
                            arrayList2.clear();
                        }
                    }
                }
            }
        }

        public void r(AbstractC18106o57 abstractC18106o57) {
            if (abstractC18106o57 == null) {
                return;
            }
            synchronized (this) {
                try {
                    if (this.a == null) {
                        this.a = new HashMap();
                    }
                    this.a.put(Long.valueOf(abstractC18106o57.c), abstractC18106o57);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* renamed from: ir.nasim.tgwidgets.editor.ui.Components.b$c */
    public interface c {
        void a(AbstractC18106o57 abstractC18106o57);
    }

    public C21463b(int i, int i2, long j, String str) {
        this.h = i2;
        this.g = i;
        B();
        this.f = j;
        this.i = str;
        k(i2).g(j, new c() { // from class: ir.nasim.Ls
            @Override // ir.nasim.tgwidgets.editor.ui.Components.C21463b.c
            public final void a(AbstractC18106o57 abstractC18106o57) throws InterruptedException {
                this.a.p(abstractC18106o57);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void A() {
        r = ir.nasim.tgwidgets.editor.messenger.v.e(16388);
        s = ir.nasim.tgwidgets.editor.messenger.v.e(8200);
    }

    private void B() {
        int i = this.g;
        if (i == 0) {
            this.d = (int) (((Math.abs(ir.nasim.tgwidgets.editor.ui.ActionBar.m.v1.ascent()) + Math.abs(ir.nasim.tgwidgets.editor.ui.ActionBar.m.v1.descent())) * 1.15f) / AbstractC21455b.g);
            return;
        }
        if (i == 1 || i == 4) {
            this.d = (int) (((Math.abs(ir.nasim.tgwidgets.editor.ui.ActionBar.m.B1[2].ascent()) + Math.abs(ir.nasim.tgwidgets.editor.ui.ActionBar.m.B1[2].descent())) * 1.15f) / AbstractC21455b.g);
            return;
        }
        if (i == 8) {
            this.d = (int) (((Math.abs(ir.nasim.tgwidgets.editor.ui.ActionBar.m.B1[0].ascent()) + Math.abs(ir.nasim.tgwidgets.editor.ui.ActionBar.m.B1[0].descent())) * 1.15f) / AbstractC21455b.g);
        } else if (i == 14 || i == 15) {
            this.d = 100;
        } else {
            this.d = 34;
        }
    }

    public static AbstractC18106o57 h(int i, long j) {
        C1593b c1593bK = k(i);
        if (c1593bK == null || c1593bK.a == null) {
            return null;
        }
        return (AbstractC18106o57) c1593bK.a.get(Long.valueOf(j));
    }

    public static int i() {
        return AbstractC8662Wx6.h() == 0 ? 0 : 2;
    }

    public static C1593b k(int i) {
        if (q == null) {
            q = new HashMap();
        }
        C1593b c1593b = (C1593b) q.get(Integer.valueOf(i));
        if (c1593b != null) {
            return c1593b;
        }
        HashMap map = q;
        Integer numValueOf = Integer.valueOf(i);
        C1593b c1593b2 = new C1593b(i);
        map.put(numValueOf, c1593b2);
        return c1593b2;
    }

    private void m(boolean z) throws InterruptedException {
        int i;
        C24687z23 c24687z23B;
        String str;
        int i2;
        if (this.e != null) {
            ImageReceiver imageReceiver = this.j;
            if (imageReceiver == null || z) {
                if (imageReceiver == null) {
                    a aVar = new a();
                    this.j = aVar;
                    aVar.v0(true);
                }
                if (this.g == 12) {
                    this.j.k = true;
                }
                if (this.n != null && e()) {
                    this.j.C0(this.n);
                }
                int i3 = this.g;
                if (i3 != 0) {
                    if (i3 == 12) {
                        i3 = 2;
                    }
                    this.j.q1(i3 + "_");
                }
                this.j.s1(true);
                boolean z2 = (AbstractC8662Wx6.h() == 0 && this.g == 5) || ((i = this.g) == 2 && !r) || (i == 3 && !s);
                if (this.g == 13) {
                    z2 = true;
                }
                String str2 = this.d + "_" + this.d;
                if (this.g == 12) {
                    str2 = str2 + "_d_nostream";
                }
                int i4 = this.g;
                if (i4 != 15 && i4 != 14 && i4 != 8 && ((i4 != 1 || AbstractC8662Wx6.h() < 2) && this.g != 12)) {
                    str2 = str2 + "_pcache";
                }
                int i5 = this.g;
                if (i5 != 0 && i5 != 1 && i5 != 14 && i5 != 15) {
                    str2 = str2 + "_compress";
                }
                if (this.g == 8) {
                    str2 = str2 + "firstframe";
                }
                AbstractC11500d67 abstractC11500d67Y = C4278El2.y(this.e.k, 90);
                if ("video/webm".equals(this.e.i)) {
                    c24687z23B = C24687z23.b(this.e);
                    str2 = str2 + "_g";
                } else if ("application/x-tgsticker".equals(this.e.i)) {
                    StringBuilder sb = new StringBuilder();
                    if (this.g != 0) {
                        str = this.g + "_";
                    } else {
                        str = "";
                    }
                    sb.append(str);
                    sb.append(this.f);
                    sb.append(Separators.AT);
                    sb.append(str2);
                    String string = sb.toString();
                    if (AbstractC8662Wx6.h() == 0 && this.g != 2) {
                        C21457d.g0().m0(string);
                    }
                    c24687z23B = C24687z23.b(this.e);
                } else {
                    c24687z23B = null;
                }
                if (this.i != null) {
                    this.j.W0(new AnimatedFileDrawable(new File(this.i), true, 0L, 0, null, null, null, 0L, this.h, true, 512, 512, null));
                } else {
                    int i6 = this.g;
                    if (i6 == 8) {
                        ImageReceiver imageReceiver2 = this.j;
                        AbstractC18106o57 abstractC18106o57 = this.e;
                        imageReceiver2.S0(null, null, c24687z23B, str2, null, null, null, abstractC18106o57.j, null, abstractC18106o57, 1);
                    } else if (!z2 && (r || i6 == 14)) {
                        ImageReceiver imageReceiver3 = this.j;
                        C24687z23 c24687z23C = C24687z23.c(abstractC11500d67Y, this.e);
                        String str3 = this.d + "_" + this.d;
                        AbstractC18106o57 abstractC18106o572 = this.e;
                        imageReceiver3.S0(c24687z23B, str2, c24687z23C, str3, null, null, null, abstractC18106o572.j, null, abstractC18106o572, 1);
                    } else if ("video/webm".equals(this.e.i)) {
                        ImageReceiver imageReceiver4 = this.j;
                        C24687z23 c24687z23C2 = C24687z23.c(abstractC11500d67Y, this.e);
                        String str4 = this.d + "_" + this.d;
                        AbstractC18106o57 abstractC18106o573 = this.e;
                        imageReceiver4.S0(null, null, c24687z23C2, str4, null, null, null, abstractC18106o573.j, null, abstractC18106o573, 1);
                    } else if (C10743c74.m0(this.e, true)) {
                        AbstractC18106o57 abstractC18106o574 = this.e;
                        this.j.Q0(c24687z23B, str2 + "_firstframe", null, null, null, abstractC18106o574.j, null, abstractC18106o574, 1);
                    } else {
                        ImageReceiver imageReceiver5 = this.j;
                        C24687z23 c24687z23C3 = C24687z23.c(abstractC11500d67Y, this.e);
                        String str5 = this.d + "_" + this.d;
                        AbstractC18106o57 abstractC18106o575 = this.e;
                        imageReceiver5.Q0(c24687z23C3, str5, null, null, null, abstractC18106o575.j, null, abstractC18106o575, 1);
                    }
                }
                z(this.j);
                int i7 = this.g;
                if (i7 == 13 || i7 == 3 || i7 == 5 || i7 == 4) {
                    this.j.d1(7);
                }
                if (this.g == 9) {
                    this.j.d1(6656);
                }
                this.j.y0(true);
                int i8 = this.g;
                if (i8 == 12 || i8 == 8 || i8 == 6 || i8 == 5) {
                    i2 = 0;
                    this.j.w0(false);
                    this.j.x0(false);
                    this.j.z0(0);
                } else {
                    this.j.x0(true);
                    this.j.w0(true);
                    this.j.z0(1);
                    i2 = 0;
                }
                this.j.u0(true);
                int i9 = this.g;
                this.j.k1((i9 == 5 || i9 == 6) ? AbstractC21455b.F(6.0f) : i2);
                y();
                n();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(AbstractC18106o57 abstractC18106o57) throws InterruptedException {
        this.e = abstractC18106o57;
        m(false);
    }

    public static C21463b q(int i, int i2, long j) {
        return r(i, i2, j, null);
    }

    public static C21463b r(int i, int i2, long j, String str) {
        if (o == null) {
            o = new SparseArray();
        }
        int iHash = Objects.hash(Integer.valueOf(i), Integer.valueOf(i2));
        LongSparseArray longSparseArray = (LongSparseArray) o.get(iHash);
        if (longSparseArray == null) {
            SparseArray sparseArray = o;
            LongSparseArray longSparseArray2 = new LongSparseArray();
            sparseArray.put(iHash, longSparseArray2);
            longSparseArray = longSparseArray2;
        }
        C21463b c21463b = (C21463b) longSparseArray.get(j);
        if (c21463b != null) {
            return c21463b;
        }
        C21463b c21463b2 = new C21463b(i2, i, j, str);
        longSparseArray.put(j, c21463b2);
        return c21463b2;
    }

    public static C21463b s(int i, int i2, AbstractC18106o57 abstractC18106o57) {
        if (o == null) {
            o = new SparseArray();
        }
        int iHash = Objects.hash(Integer.valueOf(i), Integer.valueOf(i2));
        LongSparseArray longSparseArray = (LongSparseArray) o.get(iHash);
        if (longSparseArray == null) {
            SparseArray sparseArray = o;
            LongSparseArray longSparseArray2 = new LongSparseArray();
            sparseArray.put(iHash, longSparseArray2);
            longSparseArray = longSparseArray2;
        }
        C21463b c21463b = (C21463b) longSparseArray.get(abstractC18106o57.c);
        if (c21463b != null) {
            return c21463b;
        }
        long j = abstractC18106o57.c;
        C21463b c21463b2 = new C21463b(i2, i, abstractC18106o57);
        longSparseArray.put(j, c21463b2);
        return c21463b2;
    }

    public static void x() {
        if (o == null) {
            return;
        }
        A();
        for (int i = 0; i < o.size(); i++) {
            LongSparseArray longSparseArray = (LongSparseArray) o.valueAt(i);
            for (int i2 = 0; i2 < longSparseArray.size(); i2++) {
                long jKeyAt = longSparseArray.keyAt(i2);
                C21463b c21463b = (C21463b) longSparseArray.get(jKeyAt);
                if (c21463b == null || !c21463b.a) {
                    longSparseArray.remove(jKeyAt);
                } else {
                    c21463b.m(true);
                }
            }
        }
    }

    private void y() throws InterruptedException {
        ArrayList arrayList;
        if (this.j == null) {
            return;
        }
        ArrayList arrayList2 = this.b;
        boolean z = (arrayList2 != null && arrayList2.size() > 0) || ((arrayList = this.c) != null && arrayList.size() > 0);
        if (z != this.a) {
            this.a = z;
            if (z) {
                this.j.q0();
            } else {
                this.j.s0();
            }
            if (p) {
                if (u == null) {
                    u = new ArrayList();
                }
                if (this.a) {
                    t++;
                    u.add(this);
                } else {
                    t--;
                    u.remove(this);
                }
                Log.d("animatedDrawable", "attached count " + t);
            }
        }
    }

    private void z(ImageReceiver imageReceiver) {
        int i = this.g;
        if (i == 7 || i == 9 || i == 10) {
            imageReceiver.A0(2);
        } else if (i == 11 || i == 14 || i == 6 || i == 5) {
            imageReceiver.A0(1);
        }
    }

    public void c(View view) throws InterruptedException {
        if (this.b == null) {
            this.b = new ArrayList(10);
        }
        if (!this.b.contains(view)) {
            this.b.add(view);
        }
        y();
    }

    public void d(AnimatedEmojiSpan.c cVar) {
        if (this.c == null) {
            this.c = new ArrayList(10);
        }
        if (!this.c.contains(cVar)) {
            this.c.add(cVar);
        }
        y();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ImageReceiver imageReceiver = this.j;
        if (imageReceiver == null) {
            return;
        }
        imageReceiver.Z0(getBounds());
        this.j.setAlpha(this.k);
        this.j.e(canvas);
    }

    public boolean e() {
        Boolean bool = this.l;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (this.e != null) {
            z = o() || C10743c74.b1(this.e);
            this.l = Boolean.valueOf(z);
        }
        return z;
    }

    public void f(Canvas canvas, Rect rect, float f) {
        ImageReceiver imageReceiver = this.j;
        if (imageReceiver == null) {
            return;
        }
        imageReceiver.Z0(rect);
        this.j.setAlpha(f);
        this.j.e(canvas);
    }

    public void g(Canvas canvas, ImageReceiver.a aVar, boolean z) {
        ImageReceiver imageReceiver = this.j;
        if (imageReceiver == null) {
            return;
        }
        imageReceiver.setAlpha(this.k);
        this.j.f(canvas, aVar);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return (int) (this.k * 255.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public AbstractC18106o57 j() {
        return this.e;
    }

    public ImageReceiver l() {
        return this.j;
    }

    void n() {
        if (this.b != null) {
            for (int i = 0; i < this.b.size(); i++) {
                View view = (View) this.b.get(i);
                if (view != null) {
                    view.invalidate();
                }
            }
        }
        if (this.c != null) {
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                AnimatedEmojiSpan.c cVar = (AnimatedEmojiSpan.c) this.c.get(i2);
                if (cVar != null) {
                    cVar.invalidate();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean o() {
        /*
            r6 = this;
            java.lang.Boolean r0 = r6.m
            if (r0 == 0) goto L9
            boolean r0 = r0.booleanValue()
            return r0
        L9:
            ir.nasim.o57 r0 = r6.e
            r1 = 0
            if (r0 == 0) goto L35
            ir.nasim.F57 r0 = ir.nasim.C10743c74.U(r0)
            boolean r2 = r0 instanceof ir.nasim.H97
            if (r2 != 0) goto L2e
            boolean r2 = r0 instanceof ir.nasim.L97
            if (r2 == 0) goto L2f
            long r2 = r0.b
            r4 = 773947703670341676(0xabd9d560000002c, double:6.163529620788447E-257)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L2e
            r4 = 2964141614563343(0xa87df0000000f, double:1.4644805411641533E-308)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L2f
        L2e:
            r1 = 1
        L2f:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            r6.m = r0
        L35:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.C21463b.o():boolean");
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        float f = i / 255.0f;
        this.k = f;
        ImageReceiver imageReceiver = this.j;
        if (imageReceiver != null) {
            imageReceiver.setAlpha(f);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.j == null || this.e == null) {
            this.n = colorFilter;
        } else if (e()) {
            this.j.C0(colorFilter);
        }
    }

    public void t(View view) throws InterruptedException {
        ArrayList arrayList = this.b;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        y();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AnimatedEmojiDrawable{");
        AbstractC18106o57 abstractC18106o57 = this.e;
        sb.append(abstractC18106o57 == null ? "null" : C10743c74.w(abstractC18106o57, null));
        sb.append("}");
        return sb.toString();
    }

    public void u(AnimatedEmojiSpan.c cVar) {
        ArrayList arrayList = this.c;
        if (arrayList != null) {
            arrayList.remove(cVar);
        }
        y();
    }

    public void v(long j) {
        ImageReceiver imageReceiver = this.j;
        if (imageReceiver != null) {
            if (this.g == 8) {
                j = 0;
            }
            imageReceiver.G0(j);
        }
    }

    public void w(long j) {
        ImageReceiver imageReceiver = this.j;
        if (imageReceiver != null) {
            if (this.g == 8) {
                j = 0;
            }
            if (imageReceiver.J() != null) {
                this.j.J().u0(j, true);
            }
            if (this.j.k() != null) {
                this.j.k().d1(j, true);
            }
        }
    }

    public C21463b(int i, int i2, AbstractC18106o57 abstractC18106o57) throws InterruptedException {
        this.g = i;
        this.h = i2;
        this.e = abstractC18106o57;
        B();
        A();
        m(false);
    }
}
