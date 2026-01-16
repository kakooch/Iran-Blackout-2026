package ir.nasim.tgwidgets.editor.ui.stories.recorder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.provider.MediaStore;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.LruCache;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC12384eX1;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.C9151Ys;
import ir.nasim.FH3;
import ir.nasim.HU1;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.TD5;
import ir.nasim.YE2;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.C;
import ir.nasim.tgwidgets.editor.messenger.E;
import ir.nasim.tgwidgets.editor.messenger.MediaController;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBar;
import ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarMenu;
import ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarMenuItem;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView;
import ir.nasim.tgwidgets.editor.ui.stories.recorder.GalleryListView;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class GalleryListView extends FrameLayout implements E.d {
    private static final MediaController.h y = new MediaController.h(-1, null, null);
    private final int a;
    private m.h b;
    private final Paint c;
    public final RecyclerListView d;
    public final GridLayoutManager e;
    public final h f;
    private boolean g;
    private final ActionBar h;
    private final TextView i;
    private final Drawable j;
    private final ActionBarMenuItem k;
    public boolean l;
    public final boolean m;
    private final C9151Ys n;
    public boolean o;
    private Runnable p;
    private Utilities.a q;
    private final ArrayList r;
    private boolean s;
    private boolean t;
    public MediaController.h u;
    public ArrayList v;
    private ArrayList w;
    private k x;

    class a extends RecyclerListView {
        a(Context context, m.h hVar) {
            super(context, hVar);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView, android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (GalleryListView.this.l) {
                return false;
            }
            return super.dispatchTouchEvent(motionEvent);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (GalleryListView.this.l) {
                return false;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    class b extends GridLayoutManager {
        b(Context context, int i) {
            super(context, i);
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
        public void a1(RecyclerView.v vVar, RecyclerView.z zVar) {
            super.a1(vVar, zVar);
            GalleryListView galleryListView = GalleryListView.this;
            if (galleryListView.o) {
                galleryListView.o = false;
                galleryListView.o();
            }
        }
    }

    class c extends GridLayoutManager.b {
        c() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int f(int i) {
            return (i == 0 || i == 1 || i == GalleryListView.this.f.getItemCount() - 1) ? 3 : 1;
        }
    }

    class d extends RecyclerView.o {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
            int iF = AbstractC21455b.F(5.0f);
            rect.right = iF;
            rect.bottom = iF;
        }
    }

    class e extends RecyclerView.t {
        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i, int i2) {
            GalleryListView.this.x();
            GalleryListView.this.invalidate();
        }
    }

    class f extends ActionBar.e {
        f() {
        }

        @Override // ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBar.e
        public void b(int i) {
            if (i == -1) {
                if (GalleryListView.this.p != null) {
                    GalleryListView.this.p.run();
                }
            } else if (i >= 10) {
                GalleryListView galleryListView = GalleryListView.this;
                galleryListView.z((MediaController.h) galleryListView.w.get(i - 10), false);
            }
        }
    }

    class g extends ActionBarMenuItem {
        g(Context context, ActionBarMenu actionBarMenu, int i, int i2, m.h hVar) {
            super(context, actionBarMenu, i, i2, hVar);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarMenuItem, android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setText(GalleryListView.this.i.getText());
        }
    }

    private class h extends RecyclerListView.f {
        @Override // ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView.n
        public boolean A(RecyclerView.C c) {
            return c.M() == 2;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView.f
        public String C(int i) {
            MediaController.m mVar;
            int size = i - 2;
            if (GalleryListView.this.s) {
                if (size == 0) {
                    return null;
                }
                size = i - 3;
            } else if (GalleryListView.this.t) {
                if (size >= 0 && size < GalleryListView.this.r.size()) {
                    return FH3.u(((l) GalleryListView.this.r.get(size)).k / 1000, true);
                }
                size -= GalleryListView.this.r.size();
            }
            ArrayList arrayList = GalleryListView.this.v;
            if (arrayList == null || size < 0 || size >= arrayList.size() || (mVar = (MediaController.m) GalleryListView.this.v.get(size)) == null) {
                return null;
            }
            long j = mVar.v;
            if (Build.VERSION.SDK_INT <= 28) {
                j /= 1000;
            }
            return FH3.u(j, true);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView.f
        public void D(RecyclerListView recyclerListView, float f, int[] iArr) {
            int I = I();
            int width = (int) (((int) (((recyclerListView.getWidth() - recyclerListView.getPaddingLeft()) - recyclerListView.getPaddingRight()) / GalleryListView.this.e.c3())) * 1.39f);
            int iCeil = (int) Math.ceil(I / GalleryListView.this.e.c3());
            float fU0 = (AbstractC21455b.U0(0, Math.max(0, r2 - ((AbstractC21455b.h.y - recyclerListView.getPaddingTop()) - recyclerListView.getPaddingBottom())), f) / (iCeil * width)) * iCeil;
            int iRound = Math.round(fU0);
            iArr[0] = Math.max(0, GalleryListView.this.e.c3() * iRound) + 2;
            iArr[1] = recyclerListView.getPaddingTop() + ((int) ((fU0 - iRound) * width));
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView.f
        public float E(RecyclerListView recyclerListView) {
            int I = I();
            return (Math.max(0, recyclerListView.computeVerticalScrollOffset() - GalleryListView.this.getPadding()) - recyclerListView.getPaddingTop()) / ((((int) Math.ceil(I / GalleryListView.this.e.c3())) * ((int) (((int) (((recyclerListView.getWidth() - recyclerListView.getPaddingLeft()) - recyclerListView.getPaddingRight()) / GalleryListView.this.e.c3())) * 1.39f))) - (AbstractC21455b.h.y - recyclerListView.getPaddingTop()));
        }

        public int I() {
            ArrayList arrayList = GalleryListView.this.v;
            int size = arrayList == null ? 0 : arrayList.size();
            return GalleryListView.this.s ? size + 1 : GalleryListView.this.t ? size + GalleryListView.this.r.size() : size;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public int getItemCount() {
            return I() + 3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public int getItemViewType(int i) {
            if (i == 0 || i == getItemCount() - 1) {
                return 0;
            }
            return i == 1 ? 1 : 2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public void onBindViewHolder(RecyclerView.C c, int i) throws InterruptedException {
            int iM = c.M();
            if (iM == 0) {
                ((j) c.a).a(i == 0 ? GalleryListView.this.getPadding() : -1);
                return;
            }
            if (iM == 2) {
                i iVar = (i) c.a;
                iVar.x(i == 2, i == 4);
                int size = i - 2;
                if (GalleryListView.this.s) {
                    if (size == 0) {
                        iVar.u((l) GalleryListView.this.r.get(0), GalleryListView.this.r.size());
                        return;
                    }
                    size = i - 3;
                } else if (GalleryListView.this.t) {
                    if (size >= 0 && size < GalleryListView.this.r.size()) {
                        iVar.u((l) GalleryListView.this.r.get(size), 0);
                        return;
                    }
                    size -= GalleryListView.this.r.size();
                }
                ArrayList arrayList = GalleryListView.this.v;
                if (arrayList == null || size < 0 || size >= arrayList.size()) {
                    return;
                }
                iVar.t((MediaController.m) GalleryListView.this.v.get(size));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public RecyclerView.C onCreateViewHolder(ViewGroup viewGroup, int i) {
            View iVar;
            if (i == 0) {
                GalleryListView galleryListView = GalleryListView.this;
                iVar = galleryListView.new j(galleryListView.getContext());
            } else if (i == 1) {
                GalleryListView galleryListView2 = GalleryListView.this;
                k kVar = new k(GalleryListView.this.getContext(), GalleryListView.this.m);
                galleryListView2.x = kVar;
                iVar = kVar;
            } else {
                iVar = new i(GalleryListView.this.getContext());
            }
            return new RecyclerListView.g(iVar);
        }

        private h() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class i extends View {
        private static int D;
        private final float[] A;
        private Bitmap a;
        private final Paint b;
        private final Paint c;
        private final Paint d;
        private LinearGradient e;
        private final Matrix f;
        private final Matrix g;
        private final Paint h;
        private final TextPaint i;
        private final TextPaint j;
        private final Drawable k;
        private boolean l;
        private StaticLayout m;
        private float n;
        private float o;
        private StaticLayout p;
        private float q;
        private float r;
        private final Runnable s;
        private HU1 t;
        private String u;
        private Object v;
        private Runnable w;
        private boolean x;
        private boolean y;
        private final Path z;
        private static ArrayList B = new ArrayList();
        private static final HashMap G = new HashMap();
        private static final LruCache H = new a(45);

        class a extends LruCache {
            a(int i) {
                super(i);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void entryRemoved(boolean z, String str, Bitmap bitmap, Bitmap bitmap2) {
                if (bitmap.isRecycled() || i.G.containsKey(str)) {
                    return;
                }
                bitmap.recycle();
            }
        }

        public i(Context context) {
            super(context);
            this.b = new Paint(3);
            Paint paint = new Paint(1);
            this.c = paint;
            this.d = new Paint(1);
            this.f = new Matrix();
            this.g = new Matrix();
            Paint paint2 = new Paint(1);
            this.h = paint2;
            TextPaint textPaint = new TextPaint(1);
            this.i = textPaint;
            TextPaint textPaint2 = new TextPaint(1);
            this.j = textPaint2;
            this.s = new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.stories.recorder.c
                @Override // java.lang.Runnable
                public final void run() throws InterruptedException {
                    this.a.n();
                }
            };
            this.z = new Path();
            this.A = new float[8];
            paint.setColor(285212671);
            paint2.setColor(1275068416);
            textPaint.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            textPaint.setTextSize(AbstractC21455b.H(12.66f));
            textPaint.setColor(-1);
            textPaint2.setTextSize(AbstractC21455b.F(11.33f));
            textPaint2.setColor(-1);
            this.k = context.getResources().getDrawable(AbstractC23598xB5.play_mini_video).mutate();
        }

        private void f(String str, Bitmap bitmap, int[] iArr) {
            if (bitmap == null) {
                return;
            }
            p(str, bitmap);
            if (!TextUtils.equals(str, this.u)) {
                s(str);
                return;
            }
            this.a = bitmap;
            if (iArr == null) {
                this.d.setShader(null);
                this.e = null;
            } else {
                Paint paint = this.d;
                LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, iArr, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
                this.e = linearGradient;
                paint.setShader(linearGradient);
            }
            y();
            invalidate();
        }

        public static void g() throws InterruptedException {
            r();
            for (int i = 0; i < B.size(); i++) {
                ((HU1) B.get(i)).c();
                ((HU1) B.get(i)).k();
            }
            B.clear();
        }

        private static Bitmap h(String str) {
            if (str == null) {
                return null;
            }
            Bitmap bitmap = (Bitmap) H.get(str);
            if (bitmap != null) {
                HashMap map = G;
                Integer num = (Integer) map.get(str);
                map.put(str, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
            }
            return bitmap;
        }

        private HU1 i() {
            HU1 hu1 = this.t;
            if (hu1 != null) {
                return hu1;
            }
            if (B.size() < 4) {
                ArrayList arrayList = B;
                HU1 hu12 = new HU1("gallery_load_" + B.size());
                this.t = hu12;
                arrayList.add(hu12);
            } else {
                int i = D + 1;
                D = i;
                if (i >= B.size()) {
                    D = 0;
                }
                this.t = (HU1) B.get(D);
            }
            return this.t;
        }

        private Pair j(Object obj) {
            int[] iArr;
            File file;
            int i;
            Bitmap bitmapDecodeFile = null;
            iArrC = null;
            iArrC = null;
            iArrC = null;
            int[] iArrC = null;
            if (obj == null) {
                return null;
            }
            int iMin = (int) Math.min(AbstractC21455b.h.x / 3.0f, AbstractC21455b.F(330.0f));
            int i2 = (int) (iMin * 1.39f);
            if (obj instanceof MediaController.m) {
                MediaController.m mVar = (MediaController.m) obj;
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                q(mVar, options);
                l.M(options, iMin, i2);
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                options.inDither = true;
                options.inJustDecodeBounds = false;
                Bitmap bitmapQ = q(mVar, options);
                if (bitmapQ != null && bitmapQ.getHeight() / bitmapQ.getWidth() < 1.39f) {
                    if (mVar.F != 0 || mVar.G != 0 || bitmapQ == null || bitmapQ.isRecycled()) {
                        int i3 = mVar.F;
                        if (i3 != 0 && (i = mVar.G) != 0) {
                            iArrC = new int[]{i3, i};
                        }
                    } else {
                        iArrC = AbstractC12384eX1.c(true, bitmapQ, true);
                        mVar.F = iArrC[0];
                        mVar.G = iArrC[1];
                    }
                }
                iArr = iArrC;
                bitmapDecodeFile = bitmapQ;
            } else if (!(obj instanceof l) || (file = ((l) obj).J) == null) {
                iArr = null;
            } else {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(file.getPath(), options2);
                l.M(options2, iMin, i2);
                options2.inPreferredConfig = Bitmap.Config.ARGB_8888;
                options2.inDither = true;
                options2.inJustDecodeBounds = false;
                bitmapDecodeFile = BitmapFactory.decodeFile(file.getPath(), options2);
                iArr = null;
            }
            return new Pair(bitmapDecodeFile, iArr);
        }

        private String k(MediaController.m mVar) {
            if (mVar == null) {
                return "";
            }
            String str = mVar.b;
            if (str != null) {
                return str;
            }
            if (!mVar.D) {
                return mVar.A;
            }
            return "" + mVar.u;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(String str, Pair pair) {
            f(str, (Bitmap) pair.first, (int[]) pair.second);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(Object obj, final String str) {
            final Pair pairJ = j(obj);
            AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.stories.recorder.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.l(str, pairJ);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n() throws InterruptedException {
            o(null);
        }

        private void o(final Object obj) throws InterruptedException {
            final String strK;
            if (obj == null) {
                s(this.u);
                this.u = null;
                this.a = null;
                invalidate();
                return;
            }
            boolean z = obj instanceof MediaController.m;
            if (z) {
                strK = k((MediaController.m) obj);
            } else if (obj instanceof l) {
                strK = "d" + ((l) obj).i;
            } else {
                strK = null;
            }
            if (TextUtils.equals(strK, this.u)) {
                return;
            }
            String str = this.u;
            if (str != null) {
                this.a = null;
                s(str);
                invalidate();
            }
            this.u = strK;
            this.d.setShader(null);
            this.e = null;
            if (z) {
                MediaController.m mVar = (MediaController.m) obj;
                if (mVar.F != 0 && mVar.G != 0) {
                    Paint paint = this.d;
                    LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, new int[]{mVar.F, mVar.G}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
                    this.e = linearGradient;
                    paint.setShader(linearGradient);
                    y();
                }
            }
            Bitmap bitmapH = h(strK);
            this.a = bitmapH;
            if (bitmapH != null) {
                invalidate();
                return;
            }
            if (this.w != null) {
                i().b(this.w);
                this.w = null;
            }
            HU1 hu1I = i();
            Runnable runnable = new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.stories.recorder.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.m(obj, strK);
                }
            };
            this.w = runnable;
            hu1I.i(runnable);
        }

        private static void p(String str, Bitmap bitmap) {
            if (str == null || bitmap == null) {
                return;
            }
            H.put(str, bitmap);
            HashMap map = G;
            Integer num = (Integer) map.get(str);
            if (num != null) {
                map.put(str, Integer.valueOf(num.intValue() + 1));
            } else {
                map.put(str, 1);
            }
        }

        private Bitmap q(MediaController.m mVar, BitmapFactory.Options options) {
            if (mVar == null) {
                return null;
            }
            String str = mVar.b;
            return str != null ? BitmapFactory.decodeFile(str, options) : mVar.D ? MediaStore.Video.Thumbnails.getThumbnail(getContext().getContentResolver(), mVar.u, 1, options) : MediaStore.Images.Thumbnails.getThumbnail(getContext().getContentResolver(), mVar.u, 1, options);
        }

        private static void r() {
            G.clear();
            H.evictAll();
        }

        private static void s(String str) {
            if (str == null) {
                return;
            }
            HashMap map = G;
            Integer num = (Integer) map.get(str);
            if (num != null) {
                int iIntValue = num.intValue() - 1;
                Integer numValueOf = Integer.valueOf(iIntValue);
                if (iIntValue <= 0) {
                    map.remove(str);
                } else {
                    map.put(str, numValueOf);
                }
            }
        }

        private void v(boolean z) {
            if (!z) {
                this.p = null;
                return;
            }
            StaticLayout staticLayout = new StaticLayout(FH3.E("StoryDraft", TD5.tgwidget_StoryDraft), this.j, getMeasuredWidth() > 0 ? getMeasuredWidth() : AbstractC21455b.h.x, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            this.p = staticLayout;
            this.q = staticLayout.getLineCount() > 0 ? this.p.getLineWidth(0) : 0.0f;
            this.r = this.p.getLineCount() > 0 ? this.p.getLineLeft(0) : 0.0f;
        }

        private void w(String str) {
            if (TextUtils.isEmpty(str)) {
                this.m = null;
            } else {
                StaticLayout staticLayout = new StaticLayout(str, this.i, getMeasuredWidth() > 0 ? getMeasuredWidth() : AbstractC21455b.h.x, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                this.m = staticLayout;
                this.n = staticLayout.getLineCount() > 0 ? this.m.getLineWidth(0) : 0.0f;
                this.o = this.m.getLineCount() > 0 ? this.m.getLineLeft(0) : 0.0f;
            }
            this.l = true;
        }

        private void y() {
            Bitmap bitmap;
            if (getMeasuredWidth() > 0 && getMeasuredHeight() > 0 && (bitmap = this.a) != null) {
                float fMax = ((float) bitmap.getHeight()) / ((float) this.a.getWidth()) > 1.29f ? Math.max(getMeasuredWidth() / this.a.getWidth(), getMeasuredHeight() / this.a.getHeight()) : getMeasuredWidth() / this.a.getWidth();
                this.f.reset();
                this.f.postScale(fMax, fMax);
                this.f.postTranslate((getMeasuredWidth() - (this.a.getWidth() * fMax)) / 2.0f, (getMeasuredHeight() - (fMax * this.a.getHeight())) / 2.0f);
            }
            if (getMeasuredHeight() > 0) {
                this.g.reset();
                this.g.postScale(1.0f, getMeasuredHeight());
                LinearGradient linearGradient = this.e;
                if (linearGradient != null) {
                    linearGradient.setLocalMatrix(this.g);
                }
            }
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            boolean z = false;
            if (this.x || this.y) {
                canvas.save();
                this.z.rewind();
                RectF rectF = AbstractC21455b.x;
                rectF.set(0.0f, 0.0f, getWidth(), getHeight());
                float[] fArr = this.A;
                float F = this.x ? AbstractC21455b.F(6.0f) : 0.0f;
                fArr[1] = F;
                fArr[0] = F;
                float[] fArr2 = this.A;
                float F2 = this.y ? AbstractC21455b.F(6.0f) : 0.0f;
                fArr2[3] = F2;
                fArr2[2] = F2;
                this.z.addRoundRect(rectF, this.A, Path.Direction.CW);
                canvas.clipPath(this.z);
                z = true;
            }
            super.draw(canvas);
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.c);
            if (this.e != null) {
                canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.d);
            }
            Bitmap bitmap = this.a;
            if (bitmap != null && !bitmap.isRecycled()) {
                canvas.drawBitmap(this.a, this.f, this.b);
            }
            if (this.p != null) {
                RectF rectF2 = AbstractC21455b.x;
                rectF2.set(AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), AbstractC21455b.F(10.0f) + this.q + AbstractC21455b.F(6.0f), AbstractC21455b.F(5.0f) + this.p.getHeight() + AbstractC21455b.F(2.0f));
                canvas.drawRoundRect(rectF2, AbstractC21455b.F(10.0f), AbstractC21455b.F(10.0f), this.h);
                canvas.save();
                canvas.translate((rectF2.left + AbstractC21455b.F(6.0f)) - this.r, rectF2.top + AbstractC21455b.F(1.33f));
                this.p.draw(canvas);
                canvas.restore();
            }
            if (this.m != null) {
                RectF rectF3 = AbstractC21455b.x;
                rectF3.set(AbstractC21455b.F(4.0f), ((getHeight() - AbstractC21455b.F(4.0f)) - this.m.getHeight()) - AbstractC21455b.F(2.0f), AbstractC21455b.F(4.0f) + (this.l ? AbstractC21455b.F(16.0f) : AbstractC21455b.F(4.0f)) + this.n + AbstractC21455b.F(5.0f), getHeight() - AbstractC21455b.F(4.0f));
                canvas.drawRoundRect(rectF3, AbstractC21455b.F(10.0f), AbstractC21455b.F(10.0f), this.h);
                if (this.l) {
                    this.k.setBounds((int) (rectF3.left + AbstractC21455b.F(6.0f)), (int) (rectF3.centerY() - (AbstractC21455b.F(8.0f) / 2)), (int) (rectF3.left + AbstractC21455b.F(13.0f)), (int) (rectF3.centerY() + (AbstractC21455b.F(8.0f) / 2)));
                    this.k.draw(canvas);
                }
                canvas.save();
                canvas.translate((rectF3.left + (this.l ? AbstractC21455b.F(16.0f) : AbstractC21455b.F(5.0f))) - this.o, rectF3.top + AbstractC21455b.F(1.0f));
                this.m.draw(canvas);
                canvas.restore();
            }
            if (z) {
                canvas.restore();
            }
        }

        @Override // android.view.View
        protected void onAttachedToWindow() throws InterruptedException {
            super.onAttachedToWindow();
            AbstractC21455b.t(this.s);
            Object obj = this.v;
            if (obj != null) {
                o(obj);
            }
        }

        @Override // android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            AbstractC21455b.n1(this.s, 250L);
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            int size = View.MeasureSpec.getSize(i);
            setMeasuredDimension(size, (int) (size * 1.39f));
            y();
        }

        public void t(MediaController.m mVar) throws InterruptedException {
            this.v = mVar;
            w((mVar == null || !mVar.D) ? null : AbstractC21455b.O(mVar.w));
            v(false);
            o(mVar);
            invalidate();
        }

        public void u(l lVar, int i) throws InterruptedException {
            this.v = lVar;
            boolean z = false;
            if (i > 0) {
                v(false);
                w(FH3.o("StoryDrafts", i, new Object[0]));
                this.l = false;
            } else {
                if (lVar != null && lVar.j) {
                    z = true;
                }
                v(z);
                w((lVar == null || !lVar.p) ? null : AbstractC21455b.O((int) Math.max(0.0f, (lVar.y * (lVar.v - lVar.u)) / 1000.0f)));
            }
            o(lVar);
        }

        public void x(boolean z, boolean z2) {
            this.x = z;
            this.y = z2;
        }
    }

    private class j extends View {
        int a;

        public j(Context context) {
            super(context);
        }

        public void a(int i) {
            this.a = i;
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            int size;
            int size2 = View.MeasureSpec.getSize(i);
            int i3 = this.a;
            if (i3 != -1) {
                setMeasuredDimension(size2, i3);
                return;
            }
            if (GalleryListView.this.u == GalleryListView.y) {
                size = GalleryListView.this.r.size();
            } else {
                ArrayList arrayList = GalleryListView.this.v;
                if (arrayList != null) {
                    size = arrayList.size() + (GalleryListView.this.s ? 1 : 0) + (GalleryListView.this.t ? GalleryListView.this.r.size() : 0);
                } else {
                    size = 0;
                }
            }
            setMeasuredDimension(size2, Math.max(0, (AbstractC21455b.h.y - AbstractC21455b.F(62.0f)) - (((int) (((int) (size2 / GalleryListView.this.e.c3())) * 1.39f)) * ((int) Math.ceil(size / GalleryListView.this.e.c3())))));
        }
    }

    private static class k extends TextView {
        public k(Context context, boolean z) {
            super(context);
            setTextSize(1, 16.0f);
            setTextColor(-1);
            setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            setPadding(AbstractC21455b.F(16.0f), AbstractC21455b.F(16.0f), AbstractC21455b.F(21.0f), AbstractC21455b.F(10.0f));
            setText(FH3.C(z ? TD5.tgwidget_AddImage : TD5.tgwidget_ChoosePhotoOrVideo));
        }
    }

    public GalleryListView(int i2, Context context, m.h hVar, MediaController.h hVar2, boolean z) {
        super(context);
        Paint paint = new Paint(1);
        this.c = paint;
        this.n = new C9151Ys(this, 0L, 350L, InterpolatorC12631ew1.h);
        this.o = true;
        ArrayList arrayList = new ArrayList();
        this.r = arrayList;
        this.a = i2;
        this.b = hVar;
        this.m = z;
        paint.setColor(-14737633);
        paint.setShadowLayer(AbstractC21455b.F(2.33f), 0.0f, AbstractC21455b.F(-0.4f), 134217728);
        a aVar = new a(context, hVar);
        this.d = aVar;
        aVar.setItemSelectorColorProvider(new YE2() { // from class: ir.nasim.gD2
            @Override // ir.nasim.YE2
            public final Object a(Object obj) {
                return GalleryListView.q((Integer) obj);
            }
        });
        h hVar3 = new h();
        this.f = hVar3;
        aVar.setAdapter(hVar3);
        b bVar = new b(context, 3);
        this.e = bVar;
        aVar.setLayoutManager(bVar);
        aVar.setFastScrollEnabled(1);
        aVar.setFastScrollVisible(true);
        aVar.getFastScroll().setAlpha(0.0f);
        bVar.k3(new c());
        aVar.addItemDecoration(new d());
        aVar.setClipToPadding(false);
        addView(aVar, AbstractC13840gu3.d(-1, -1, 119));
        aVar.setOnItemClickListener(new RecyclerListView.i() { // from class: ir.nasim.hD2
            @Override // ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView.i
            public final void a(View view, int i3) {
                this.a.r(view, i3);
            }
        });
        aVar.setOnScrollListener(new e());
        ActionBar actionBar = new ActionBar(context, hVar);
        this.h = actionBar;
        actionBar.setBackgroundColor(-14737633);
        actionBar.setTitleColor(-1);
        actionBar.setAlpha(0.0f);
        actionBar.setVisibility(8);
        actionBar.setBackButtonImage(AbstractC23598xB5.ic_ab_back);
        actionBar.setItemsBackgroundColor(436207615, false);
        actionBar.setItemsColor(-1, false);
        addView(actionBar, AbstractC13840gu3.d(-1, -2, 55));
        actionBar.setActionBarMenuOnItemClick(new f());
        g gVar = new g(context, actionBar.l(), 0, 0, hVar);
        this.k = gVar;
        gVar.setSubMenuOpenSide(1);
        actionBar.addView(gVar, 0, AbstractC13840gu3.c(-2, -1.0f, 51, AbstractC21455b.F0() ? 64.0f : 56.0f, 0.0f, 40.0f, 0.0f));
        gVar.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.iD2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.s(view);
            }
        });
        TextView textView = new TextView(context);
        this.i = textView;
        textView.setImportantForAccessibility(2);
        textView.setGravity(3);
        textView.setSingleLine(true);
        textView.setLines(1);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextColor(-1);
        textView.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        Drawable drawableMutate = context.getResources().getDrawable(AbstractC23598xB5.ic_arrow_drop_down).mutate();
        this.j = drawableMutate;
        drawableMutate.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.MULTIPLY));
        textView.setCompoundDrawablePadding(AbstractC21455b.F(4.0f));
        textView.setPadding(0, AbstractC21455b.d, AbstractC21455b.F(10.0f), 0);
        gVar.addView(textView, AbstractC13840gu3.c(-2, -2.0f, 16, 16.0f, 0.0f, 0.0f, 0.0f));
        arrayList.clear();
        if (!z) {
            arrayList.addAll(C.n(i2).r().e().b);
        }
        B();
        if (hVar2 == null || (hVar2 == y && arrayList.size() <= 0)) {
            ArrayList arrayList2 = this.w;
            if (arrayList2 == null || arrayList2.isEmpty()) {
                this.u = MediaController.R0;
            } else {
                this.u = (MediaController.h) this.w.get(0);
            }
        } else {
            this.u = hVar2;
        }
        this.v = p(this.u);
        C();
        MediaController.h hVar4 = this.u;
        if (hVar4 == MediaController.R0) {
            textView.setText(FH3.E("ChatGallery", TD5.tgwidget_ChatGallery));
        } else if (hVar4 == y) {
            textView.setText(FH3.E("StoryDraftsAlbum", TD5.tgwidget_StoryDraftsAlbum));
        } else {
            textView.setText(hVar4.c);
        }
    }

    private void B() {
        AlbumButton albumButton;
        this.k.l0();
        final ArrayList arrayList = MediaController.M0;
        ArrayList arrayList2 = new ArrayList(arrayList);
        this.w = arrayList2;
        Collections.sort(arrayList2, new Comparator() { // from class: ir.nasim.eD2
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return GalleryListView.u(arrayList, (MediaController.h) obj, (MediaController.h) obj2);
            }
        });
        if (!this.r.isEmpty()) {
            ArrayList arrayList3 = this.w;
            arrayList3.add(!arrayList3.isEmpty() ? 1 : 0, y);
        }
        if (this.w.isEmpty()) {
            this.i.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        this.i.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.j, (Drawable) null);
        int size = this.w.size();
        for (int i2 = 0; i2 < size; i2++) {
            final MediaController.h hVar = (MediaController.h) this.w.get(i2);
            if (hVar == y) {
                albumButton = new AlbumButton(getContext(), hVar.d, FH3.E("StoryDraftsAlbum", TD5.tgwidget_StoryDraftsAlbum), this.r.size(), this.b);
            } else {
                ArrayList arrayListP = p(hVar);
                if (!arrayListP.isEmpty()) {
                    albumButton = new AlbumButton(getContext(), hVar.d, hVar.c, arrayListP.size(), this.b);
                }
            }
            this.k.getPopupLayout().addView(albumButton);
            albumButton.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.fD2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.v(hVar, view);
                }
            });
        }
    }

    private void C() {
        ArrayList arrayList;
        ArrayList arrayList2 = this.w;
        boolean z = true;
        boolean z2 = arrayList2 != null && !arrayList2.isEmpty() && this.w.get(0) == this.u && this.r.size() > 2;
        this.s = z2;
        if (z2 || (this.u != y && ((arrayList = this.w) == null || arrayList.isEmpty() || this.w.get(0) != this.u))) {
            z = false;
        }
        this.t = z;
    }

    private ArrayList p(MediaController.h hVar) {
        if (hVar == null) {
            return new ArrayList();
        }
        if (!this.m) {
            return hVar.e;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < hVar.e.size(); i2++) {
            MediaController.m mVar = (MediaController.m) hVar.e.get(i2);
            if (!mVar.D) {
                arrayList.add(mVar);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer q(Integer num) {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(View view, int i2) {
        if (i2 < 2 || this.q == null || !(view instanceof i)) {
            return;
        }
        i iVar = (i) view;
        int size = i2 - 2;
        if (this.s) {
            if (size == 0) {
                z(y, true);
                return;
            }
            size = i2 - 3;
        } else if (this.t) {
            if (size >= 0 && size < this.r.size()) {
                l lVar = (l) this.r.get(size);
                this.q.a(lVar, lVar.p ? y(iVar) : null);
                return;
            }
            size -= this.r.size();
        }
        if (size < 0 || size >= this.v.size()) {
            return;
        }
        MediaController.m mVar = (MediaController.m) this.v.get(size);
        this.q.a(mVar, mVar.D ? y(iVar) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(View view) {
        this.k.p0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int u(ArrayList arrayList, MediaController.h hVar, MediaController.h hVar2) {
        int iIndexOf;
        int iIndexOf2;
        int i2 = hVar.a;
        if (i2 == 0 && hVar2.a != 0) {
            return -1;
        }
        if ((i2 == 0 || hVar2.a != 0) && (iIndexOf = arrayList.indexOf(hVar)) <= (iIndexOf2 = arrayList.indexOf(hVar2))) {
            return iIndexOf < iIndexOf2 ? -1 : 0;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(MediaController.h hVar, View view) {
        z(hVar, false);
        this.k.M();
    }

    private Bitmap y(i iVar) {
        Bitmap bitmap = iVar.a;
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        return Utilities.k(bitmap, 6.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(MediaController.h hVar, boolean z) {
        this.u = hVar;
        this.v = p(hVar);
        C();
        MediaController.h hVar2 = this.u;
        if (hVar2 == MediaController.R0) {
            this.i.setText(FH3.E("ChatGallery", TD5.tgwidget_ChatGallery));
        } else if (hVar2 == y) {
            this.i.setText(FH3.E("StoryDraftsAlbum", TD5.tgwidget_StoryDraftsAlbum));
        } else {
            this.i.setText(hVar2.c);
        }
        this.f.notifyDataSetChanged();
        if (!z) {
            this.e.E2(1, (-ActionBar.getCurrentActionBarHeight()) + AbstractC21455b.F(16.0f));
            return;
        }
        androidx.recyclerview.widget.p pVar = new androidx.recyclerview.widget.p(getContext(), 2);
        pVar.p(1);
        pVar.x((-ActionBar.getCurrentActionBarHeight()) + AbstractC21455b.F(16.0f));
        this.e.M1(pVar);
    }

    public int A() {
        RecyclerListView recyclerListView = this.d;
        if (recyclerListView == null || recyclerListView.getChildCount() <= 0) {
            return getPadding();
        }
        int iMin = Integer.MAX_VALUE;
        if (this.d != null) {
            for (int i2 = 0; i2 < this.d.getChildCount(); i2++) {
                View childAt = this.d.getChildAt(i2);
                if (this.d.getChildAdapterPosition(childAt) > 0) {
                    iMin = Math.min(iMin, (int) childAt.getY());
                }
            }
        }
        return Math.max(0, Math.min(iMin, getHeight()));
    }

    public void D() {
        this.r.clear();
        if (!this.m) {
            this.r.addAll(C.n(this.a).r().e().b);
        }
        B();
        C();
        h hVar = this.f;
        if (hVar != null) {
            hVar.notifyDataSetChanged();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        float fA = A();
        boolean z = fA <= ((float) Math.max(0, (AbstractC21455b.d + ActionBar.getCurrentActionBarHeight()) - AbstractC21455b.F(32.0f)));
        float fE = this.n.e(z);
        float fT0 = AbstractC21455b.T0(fA, 0.0f, fE);
        if (z != this.g) {
            this.g = z;
            w(z);
            this.d.getFastScroll().animate().alpha(this.g ? 1.0f : 0.0f).start();
        }
        ActionBar actionBar = this.h;
        if (actionBar != null) {
            actionBar.setAlpha(fE);
            int i2 = fE <= 0.0f ? 8 : 0;
            if (this.h.getVisibility() != i2) {
                this.h.setVisibility(i2);
            }
        }
        k kVar = this.x;
        if (kVar != null) {
            kVar.setAlpha(1.0f - fE);
        }
        RectF rectF = AbstractC21455b.x;
        rectF.set(0.0f, fT0, getWidth(), getHeight() + AbstractC21455b.F(14.0f));
        canvas.drawRoundRect(rectF, AbstractC21455b.F(14.0f), AbstractC21455b.F(14.0f), this.c);
        canvas.save();
        canvas.clipRect(0.0f, fT0, getWidth(), getHeight());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public int getPadding() {
        return (int) (AbstractC21455b.h.y * 0.35f);
    }

    public MediaController.h getSelectedAlbum() {
        return this.u;
    }

    protected void o() {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        E.j().e(this, E.d2);
        E.k(this.a).e(this, E.W3);
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() throws InterruptedException {
        super.onDetachedFromWindow();
        E.j().u(this, E.d2);
        E.k(this.a).u(this, E.W3);
        i.g();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0047  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView r0 = r5.d
            int r1 = ir.nasim.tgwidgets.editor.messenger.AbstractC21455b.d
            int r2 = ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBar.getCurrentActionBarHeight()
            int r1 = r1 + r2
            r0.setPinnedSectionOffsetY(r1)
            ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView r0 = r5.d
            r1 = 1086324736(0x40c00000, float:6.0)
            int r1 = ir.nasim.tgwidgets.editor.messenger.AbstractC21455b.F(r1)
            int r2 = ir.nasim.tgwidgets.editor.messenger.AbstractC21455b.d
            int r3 = ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBar.getCurrentActionBarHeight()
            int r2 = r2 + r3
            r3 = 1065353216(0x3f800000, float:1.0)
            int r3 = ir.nasim.tgwidgets.editor.messenger.AbstractC21455b.F(r3)
            int r4 = ir.nasim.tgwidgets.editor.messenger.AbstractC21455b.e
            r0.setPadding(r1, r2, r3, r4)
            android.widget.TextView r0 = r5.i
            int r1 = ir.nasim.tgwidgets.editor.messenger.AbstractC21455b.d
            r2 = 1092616192(0x41200000, float:10.0)
            int r2 = ir.nasim.tgwidgets.editor.messenger.AbstractC21455b.F(r2)
            r3 = 0
            r0.setPadding(r3, r1, r2, r3)
            android.widget.TextView r0 = r5.i
            boolean r1 = ir.nasim.tgwidgets.editor.messenger.AbstractC21455b.F0()
            if (r1 != 0) goto L47
            android.graphics.Point r1 = ir.nasim.tgwidgets.editor.messenger.AbstractC21455b.h
            int r2 = r1.x
            int r1 = r1.y
            if (r2 <= r1) goto L47
            r1 = 1099956224(0x41900000, float:18.0)
            goto L49
        L47:
            r1 = 1101004800(0x41a00000, float:20.0)
        L49:
            r0.setTextSize(r1)
            super.onMeasure(r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.stories.recorder.GalleryListView.onMeasure(int, int):void");
    }

    public void setOnBackClickListener(Runnable runnable) {
        this.p = runnable;
    }

    public void setOnSelectListener(Utilities.a aVar) {
        this.q = aVar;
    }

    @Override // ir.nasim.tgwidgets.editor.messenger.E.d
    public void t(int i2, int i3, Object... objArr) {
        if (i2 != E.d2) {
            if (i2 == E.W3) {
                D();
                return;
            }
            return;
        }
        B();
        int i4 = 0;
        if (this.u != null) {
            while (true) {
                if (i4 >= MediaController.M0.size()) {
                    break;
                }
                MediaController.h hVar = (MediaController.h) MediaController.M0.get(i4);
                int i5 = hVar.a;
                MediaController.h hVar2 = this.u;
                if (i5 == hVar2.a && hVar.b == hVar2.b) {
                    this.u = hVar;
                    break;
                }
                i4++;
            }
        } else {
            ArrayList arrayList = this.w;
            if (arrayList == null || arrayList.isEmpty()) {
                this.u = MediaController.R0;
            } else {
                this.u = (MediaController.h) this.w.get(0);
            }
        }
        this.v = p(this.u);
        C();
        h hVar3 = this.f;
        if (hVar3 != null) {
            hVar3.notifyDataSetChanged();
        }
    }

    protected void w(boolean z) {
    }

    protected void x() {
    }
}
