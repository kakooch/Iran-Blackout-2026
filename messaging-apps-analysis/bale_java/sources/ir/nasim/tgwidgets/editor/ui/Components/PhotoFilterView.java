package ir.nasim.tgwidgets.editor.ui.Components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.C22697vg5;
import ir.nasim.C9151Ys;
import ir.nasim.FH3;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.TD5;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.MediaController;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Cells.PhotoEditRadioCell;
import ir.nasim.tgwidgets.editor.ui.Cells.PhotoEditToolCell;
import ir.nasim.tgwidgets.editor.ui.Components.PhotoEditorSeekBar;
import ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView;
import ir.nasim.tgwidgets.editor.ui.Components.l;
import ir.nasim.tgwidgets.editor.ui.stories.recorder.StoryRecorder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class PhotoFilterView extends FrameLayout implements l.c, StoryRecorder.u {
    private float A;
    private C22697vg5 A0;
    private float B;
    private float B0;
    private float C0;
    private float D;
    private MediaController.n D0;
    private FrameLayout E0;
    private TextView F0;
    private int G;
    private TextView G0;
    private float H;
    private TextureView H0;
    private boolean I0;
    private b J;
    private boolean J0;
    private k K0;
    private RecyclerView L0;
    private FrameLayout M0;
    private PhotoFilterBlurControl N0;
    private PhotoFilterCurvesControl O0;
    private TextView P0;
    private TextView Q0;
    private TextView R0;
    private FrameLayout S0;
    private RadioButton[] T0;
    private PaintingOverlay U0;
    private boolean V0;
    private boolean W0;
    private int X0;
    private ImageView Y0;
    private ImageView Z0;
    private boolean a;
    private ImageView a1;
    private int b;
    private Bitmap b1;
    private int c;
    private int c1;
    private int d;
    private final m.h d1;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private float q;
    private float r;
    private float s;
    private float t;
    private float u;
    private float v;
    private float w;
    private int x;
    private int y;
    private float z;
    private float z0;

    public static class EnhanceView extends View {
        private TextPaint a;
        private TextPaint b;
        private StaticLayout c;
        private float d;
        private float e;
        private StaticLayout f;
        private float g;
        private float h;
        private boolean i;
        private C9151Ys j;
        private boolean k;
        private PhotoFilterView l;
        private Runnable m;
        private boolean n;
        private long o;
        private float p;
        private float q;
        private float r;
        private Runnable s;

        public EnhanceView(Context context, Runnable runnable) {
            super(context);
            this.a = new TextPaint(1);
            this.b = new TextPaint(1);
            this.j = new C9151Ys(this, 0L, 350L, InterpolatorC12631ew1.h);
            this.s = new Runnable() { // from class: ir.nasim.W85
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b();
                }
            };
            this.m = runnable;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            this.i = false;
            invalidate();
        }

        private void d() {
            PhotoFilterView photoFilterView = this.l;
            StaticLayout staticLayout = new StaticLayout("" + Math.round((photoFilterView == null ? 0.0f : photoFilterView.getEnhanceValue()) * 100.0f), this.b, getMeasuredWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            this.f = staticLayout;
            this.g = staticLayout.getLineCount() > 0 ? this.f.getLineWidth(0) : 0.0f;
            this.h = this.f.getLineCount() > 0 ? this.f.getLineLeft(0) : 0.0f;
            invalidate();
        }

        public boolean c(MotionEvent motionEvent) {
            if (this.k && motionEvent.getPointerCount() == 1) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.n = false;
                    this.o = System.currentTimeMillis();
                    this.p = motionEvent.getX();
                    this.q = motionEvent.getY();
                    PhotoFilterView photoFilterView = this.l;
                    if (photoFilterView != null) {
                        this.r = photoFilterView.getEnhanceValue();
                    }
                    return true;
                }
                if (action == 2) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    if (!this.n && System.currentTimeMillis() - this.o <= ViewConfiguration.getLongPressTimeout() && Math.abs(this.q - y) < Math.abs(this.p - x) && Math.abs(this.p - x) > AbstractC21455b.o0()) {
                        this.n = true;
                        AbstractC21455b.t(this.s);
                        this.i = true;
                        invalidate();
                    }
                    if (this.n) {
                        float f = x - this.p;
                        if (this.l == null) {
                            this.m.run();
                        }
                        PhotoFilterView photoFilterView2 = this.l;
                        if (photoFilterView2 == null) {
                            this.n = false;
                            return false;
                        }
                        float enhanceValue = photoFilterView2.getEnhanceValue();
                        float fC = Utilities.c((f / (AbstractC21455b.h.x * 0.8f)) + enhanceValue, 1.0f, 0.0f);
                        int iRound = Math.round(fC * 100.0f);
                        int iRound2 = Math.round(enhanceValue * 100.0f);
                        int iRound3 = Math.round(this.r * 100.0f);
                        if (iRound != iRound2 && (iRound == 100 || iRound == 0)) {
                            try {
                                performHapticFeedback(3, 1);
                            } catch (Exception unused) {
                            }
                            this.r = fC;
                        } else if (Math.abs(iRound - iRound3) > 5) {
                            try {
                                performHapticFeedback(9, 1);
                            } catch (Exception unused2) {
                            }
                            this.r = fC;
                        }
                        this.l.setEnhanceValue(fC);
                        d();
                    }
                    this.p = x;
                    this.q = y;
                } else if (action == 1 || action == 3) {
                    this.n = false;
                    this.o = -1L;
                    PhotoFilterView photoFilterView3 = this.l;
                    if (photoFilterView3 != null) {
                        this.r = photoFilterView3.getEnhanceValue();
                    }
                    AbstractC21455b.n1(this.s, 600L);
                    return false;
                }
            } else if (this.i) {
                this.i = false;
                invalidate();
            }
            return false;
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            float fE = this.j.e(this.i);
            if (fE <= 0.0f || this.c == null || this.f == null) {
                return;
            }
            canvas.saveLayerAlpha(0.0f, 0.0f, getWidth(), getHeight(), (int) (fE * 255.0f), 31);
            canvas.save();
            canvas.translate(((getWidth() - this.d) / 2.0f) - this.e, getHeight() * 0.22f);
            this.c.draw(canvas);
            canvas.restore();
            canvas.save();
            canvas.translate(((getWidth() - this.g) / 2.0f) - this.h, (getHeight() * 0.22f) + AbstractC21455b.F(60.0f));
            this.f.draw(canvas);
            canvas.restore();
            canvas.restore();
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
            this.a.setColor(-1);
            this.a.setShadowLayer(AbstractC21455b.F(8.0f), 0.0f, 0.0f, 805306368);
            this.a.setTextSize(AbstractC21455b.F(34.0f));
            this.b.setColor(-1);
            this.b.setShadowLayer(AbstractC21455b.F(12.0f), 0.0f, 0.0f, 805306368);
            this.b.setTextSize(AbstractC21455b.F(58.0f));
            if (this.c == null) {
                StaticLayout staticLayout = new StaticLayout(FH3.E("Enhance", TD5.tgwidget_Enhance), this.a, getMeasuredWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                this.c = staticLayout;
                this.d = staticLayout.getLineCount() > 0 ? this.c.getLineWidth(0) : 0.0f;
                this.e = this.c.getLineCount() > 0 ? this.c.getLineLeft(0) : 0.0f;
            }
        }

        public void setAllowTouch(boolean z) {
            this.k = z;
        }

        public void setFilterView(PhotoFilterView photoFilterView) {
            this.l = photoFilterView;
        }
    }

    class a implements TextureView.SurfaceTextureListener {
        final /* synthetic */ boolean a;

        a(boolean z) {
            this.a = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            if (PhotoFilterView.this.K0 != null) {
                PhotoFilterView.this.K0.m0(false, true, false);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            if (PhotoFilterView.this.K0 != null || surfaceTexture == null) {
                return;
            }
            PhotoFilterView.this.K0 = new k(surfaceTexture, PhotoFilterView.this.b1, PhotoFilterView.this.c1, PhotoFilterView.this.V0, null, this.a);
            PhotoFilterView.this.K0.n0(PhotoFilterView.this);
            PhotoFilterView.this.K0.p0(i, i2);
            PhotoFilterView.this.K0.m0(true, true, false);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (PhotoFilterView.this.K0 == null) {
                return true;
            }
            PhotoFilterView.this.K0.r0();
            PhotoFilterView.this.K0 = null;
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            if (PhotoFilterView.this.K0 != null) {
                PhotoFilterView.this.K0.p0(i, i2);
                PhotoFilterView.this.K0.m0(false, true, false);
                PhotoFilterView.this.K0.i(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.Components.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.b();
                    }
                });
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public static class b {
        public c a = new c();
        public c b = new c();
        public c c = new c();
        public c d = new c();
        public ByteBuffer e;
        public int f;

        public b() {
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(800);
            this.e = byteBufferAllocateDirect;
            byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        }

        public void a() {
            this.e.position(0);
            float[] fArrA = this.a.a();
            float[] fArrA2 = this.b.a();
            float[] fArrA3 = this.c.a();
            float[] fArrA4 = this.d.a();
            for (int i = 0; i < 200; i++) {
                this.e.put((byte) (fArrA2[i] * 255.0f));
                this.e.put((byte) (fArrA3[i] * 255.0f));
                this.e.put((byte) (fArrA4[i] * 255.0f));
                this.e.put((byte) (fArrA[i] * 255.0f));
            }
            this.e.position(0);
        }

        public boolean b() {
            return this.a.c() && this.b.c() && this.c.c() && this.d.c();
        }
    }

    public static class c {
        public float a = 0.0f;
        public float b = 25.0f;
        public float c = 50.0f;
        public float d = 75.0f;
        public float e = 100.0f;
        public float f = 0.0f;
        public float g = 25.0f;
        public float h = 50.0f;
        public float i = 75.0f;
        public float j = 100.0f;
        public float[] k;

        public float[] a() {
            if (this.k == null) {
                b();
            }
            return this.k;
        }

        public float[] b() {
            float f = this.a;
            float f2 = this.b / 100.0f;
            float f3 = this.c / 100.0f;
            float f4 = this.d / 100.0f;
            float f5 = this.e;
            float f6 = 0.0f;
            int i = 5;
            float[] fArr = {-0.001f, f / 100.0f, 0.0f, f / 100.0f, 0.25f, f2, 0.5f, f3, 0.75f, f4, 1.0f, f5 / 100.0f, 1.001f, f5 / 100.0f};
            ArrayList arrayList = new ArrayList(100);
            ArrayList arrayList2 = new ArrayList(100);
            arrayList2.add(Float.valueOf(fArr[0]));
            arrayList2.add(Float.valueOf(fArr[1]));
            int i2 = 1;
            while (i2 < i) {
                int i3 = (i2 - 1) * 2;
                float f7 = fArr[i3];
                float f8 = fArr[i3 + 1];
                int i4 = i2 * 2;
                float f9 = fArr[i4];
                float f10 = fArr[i4 + 1];
                int i5 = i2 + 1;
                int i6 = i5 * 2;
                float f11 = fArr[i6];
                float f12 = fArr[i6 + 1];
                int i7 = (i2 + 2) * 2;
                float f13 = fArr[i7];
                float f14 = fArr[i7 + 1];
                int i8 = 1;
                while (i8 < 100) {
                    float f15 = i8 * 0.01f;
                    float f16 = f15 * f15;
                    float f17 = f16 * f15;
                    float f18 = ((f9 * 2.0f) + ((f11 - f7) * f15) + (((((f7 * 2.0f) - (f9 * 5.0f)) + (f11 * 4.0f)) - f13) * f16) + (((((f9 * 3.0f) - f7) - (f11 * 3.0f)) + f13) * f17)) * 0.5f;
                    float fMax = Math.max(f6, Math.min(1.0f, ((f10 * 2.0f) + ((f12 - f8) * f15) + (((((2.0f * f8) - (5.0f * f10)) + (4.0f * f12)) - f14) * f16) + (((((f10 * 3.0f) - f8) - (3.0f * f12)) + f14) * f17)) * 0.5f));
                    if (f18 > f7) {
                        arrayList2.add(Float.valueOf(f18));
                        arrayList2.add(Float.valueOf(fMax));
                    }
                    if ((i8 - 1) % 2 == 0) {
                        arrayList.add(Float.valueOf(fMax));
                    }
                    i8++;
                    f6 = 0.0f;
                }
                arrayList2.add(Float.valueOf(f11));
                arrayList2.add(Float.valueOf(f12));
                i2 = i5;
                i = 5;
                f6 = 0.0f;
            }
            arrayList2.add(Float.valueOf(fArr[12]));
            arrayList2.add(Float.valueOf(fArr[13]));
            this.k = new float[arrayList.size()];
            int i9 = 0;
            while (true) {
                float[] fArr2 = this.k;
                if (i9 >= fArr2.length) {
                    break;
                }
                fArr2[i9] = ((Float) arrayList.get(i9)).floatValue();
                i9++;
            }
            int size = arrayList2.size();
            float[] fArr3 = new float[size];
            for (int i10 = 0; i10 < size; i10++) {
                fArr3[i10] = ((Float) arrayList2.get(i10)).floatValue();
            }
            return fArr3;
        }

        public boolean c() {
            return ((double) Math.abs(this.a - 0.0f)) < 1.0E-5d && ((double) Math.abs(this.b - 25.0f)) < 1.0E-5d && ((double) Math.abs(this.c - 50.0f)) < 1.0E-5d && ((double) Math.abs(this.d - 75.0f)) < 1.0E-5d && ((double) Math.abs(this.e - 100.0f)) < 1.0E-5d;
        }
    }

    private static class d extends RecyclerView {
        private final Paint B1;
        private final Paint C1;
        private boolean D1;
        private boolean E1;
        private C9151Ys F1;
        private C9151Ys G1;

        public d(Context context) {
            super(context);
            Paint paint = new Paint(1);
            this.B1 = paint;
            Paint paint2 = new Paint(1);
            this.C1 = paint2;
            this.F1 = new C9151Ys(this);
            this.G1 = new C9151Ys(this);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, AbstractC21455b.F(8.0f), new int[]{-16777216, 0}, new float[]{0.0f, 1.0f}, tileMode));
            paint2.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, AbstractC21455b.F(8.0f), new int[]{0, -16777216}, new float[]{0.0f, 1.0f}, tileMode));
        }

        private void W0() {
            boolean zCanScrollVertically = canScrollVertically(-1);
            boolean zCanScrollVertically2 = canScrollVertically(1);
            if (zCanScrollVertically == this.D1 && zCanScrollVertically2 == this.E1) {
                return;
            }
            this.D1 = zCanScrollVertically;
            this.E1 = zCanScrollVertically2;
            invalidate();
        }

        @Override // android.view.ViewGroup, android.view.View
        public void dispatchDraw(Canvas canvas) {
            super.dispatchDraw(canvas);
            this.B1.setAlpha((int) (this.F1.c(this.D1 ? 1.0f : 0.0f) * 255.0f));
            canvas.drawRect(0.0f, 0.0f, getWidth(), AbstractC21455b.F(8.0f), this.B1);
            this.C1.setAlpha((int) (this.G1.c(this.E1 ? 1.0f : 0.0f) * 255.0f));
            canvas.save();
            canvas.translate(0.0f, getHeight() - AbstractC21455b.F(8.0f));
            canvas.drawRect(0.0f, 0.0f, getWidth(), AbstractC21455b.F(8.0f), this.C1);
            canvas.restore();
        }

        @Override // androidx.recyclerview.widget.RecyclerView
        public void onScrolled(int i, int i2) {
            super.onScrolled(i, i2);
            W0();
        }
    }

    public class e extends RecyclerListView.n {
        private Context d;

        public e(Context context) {
            this.d = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void D(int i, int i2) {
            if (i == PhotoFilterView.this.b) {
                PhotoFilterView.this.q = i2;
            } else if (i == PhotoFilterView.this.i) {
                PhotoFilterView.this.z = i2;
            } else if (i == PhotoFilterView.this.d) {
                PhotoFilterView.this.s = i2;
            } else if (i == PhotoFilterView.this.c) {
                PhotoFilterView.this.r = i2;
            } else if (i == PhotoFilterView.this.f) {
                PhotoFilterView.this.t = i2;
            } else if (i == PhotoFilterView.this.e) {
                PhotoFilterView.this.u = i2;
            } else if (i == PhotoFilterView.this.k) {
                PhotoFilterView.this.B = i2;
            } else if (i == PhotoFilterView.this.j) {
                PhotoFilterView.this.A = i2;
            } else if (i == PhotoFilterView.this.l) {
                PhotoFilterView.this.D = i2;
            } else if (i == PhotoFilterView.this.m) {
                PhotoFilterView.this.H = i2;
            } else if (i == PhotoFilterView.this.g) {
                PhotoFilterView.this.v = i2;
            } else if (i == PhotoFilterView.this.h) {
                PhotoFilterView.this.w = i2;
            }
            if (PhotoFilterView.this.K0 != null) {
                PhotoFilterView.this.K0.l0(true);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void E(View view) {
            PhotoEditRadioCell photoEditRadioCell = (PhotoEditRadioCell) view;
            if (((Integer) photoEditRadioCell.getTag()).intValue() == PhotoFilterView.this.n) {
                PhotoFilterView.this.x = photoEditRadioCell.getCurrentColor();
            } else {
                PhotoFilterView.this.y = photoEditRadioCell.getCurrentColor();
            }
            if (PhotoFilterView.this.K0 != null) {
                PhotoFilterView.this.K0.l0(false);
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.RecyclerListView.n
        public boolean A(RecyclerView.C c) {
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public int getItemCount() {
            return PhotoFilterView.this.p;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public long getItemId(int i) {
            return i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public int getItemViewType(int i) {
            return (i == PhotoFilterView.this.n || i == PhotoFilterView.this.o) ? 1 : 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public void onBindViewHolder(RecyclerView.C c, int i) {
            int iM = c.M();
            if (iM != 0) {
                if (iM != 1) {
                    return;
                }
                PhotoEditRadioCell photoEditRadioCell = (PhotoEditRadioCell) c.a;
                photoEditRadioCell.setTag(Integer.valueOf(i));
                if (i == PhotoFilterView.this.n) {
                    photoEditRadioCell.setIconAndTextAndValue(FH3.E("TintShadows", TD5.tgwidget_TintShadows), 0, PhotoFilterView.this.x);
                    return;
                } else {
                    if (i == PhotoFilterView.this.o) {
                        photoEditRadioCell.setIconAndTextAndValue(FH3.E("TintHighlights", TD5.tgwidget_TintHighlights), 0, PhotoFilterView.this.y);
                        return;
                    }
                    return;
                }
            }
            PhotoEditToolCell photoEditToolCell = (PhotoEditToolCell) c.a;
            photoEditToolCell.setTag(Integer.valueOf(i));
            if (i == PhotoFilterView.this.b) {
                photoEditToolCell.setIconAndTextAndValue(FH3.E("Enhance", TD5.tgwidget_Enhance), PhotoFilterView.this.q, 0, 100);
                return;
            }
            if (i == PhotoFilterView.this.i) {
                photoEditToolCell.setIconAndTextAndValue(FH3.E("Highlights", TD5.tgwidget_Highlights), PhotoFilterView.this.z, -100, 100);
                return;
            }
            if (i == PhotoFilterView.this.d) {
                photoEditToolCell.setIconAndTextAndValue(FH3.E("Contrast", TD5.tgwidget_Contrast), PhotoFilterView.this.s, -100, 100);
                return;
            }
            if (i == PhotoFilterView.this.c) {
                photoEditToolCell.setIconAndTextAndValue(FH3.E("Exposure", TD5.tgwidget_Exposure), PhotoFilterView.this.r, -100, 100);
                return;
            }
            if (i == PhotoFilterView.this.f) {
                photoEditToolCell.setIconAndTextAndValue(FH3.E("Warmth", TD5.tgwidget_Warmth), PhotoFilterView.this.t, -100, 100);
                return;
            }
            if (i == PhotoFilterView.this.e) {
                photoEditToolCell.setIconAndTextAndValue(FH3.E("Saturation", TD5.tgwidget_Saturation), PhotoFilterView.this.u, -100, 100);
                return;
            }
            if (i == PhotoFilterView.this.k) {
                photoEditToolCell.setIconAndTextAndValue(FH3.E("Vignette", TD5.tgwidget_Vignette), PhotoFilterView.this.B, 0, 100);
                return;
            }
            if (i == PhotoFilterView.this.j) {
                photoEditToolCell.setIconAndTextAndValue(FH3.E("Shadows", TD5.tgwidget_Shadows), PhotoFilterView.this.A, -100, 100);
                return;
            }
            if (i == PhotoFilterView.this.l) {
                photoEditToolCell.setIconAndTextAndValue(FH3.E("Grain", TD5.tgwidget_Grain), PhotoFilterView.this.D, 0, 100);
                return;
            }
            if (i == PhotoFilterView.this.m) {
                photoEditToolCell.setIconAndTextAndValue(FH3.E("Sharpen", TD5.tgwidget_Sharpen), PhotoFilterView.this.H, 0, 100);
            } else if (i == PhotoFilterView.this.g) {
                photoEditToolCell.setIconAndTextAndValue(FH3.E("Fade", TD5.tgwidget_Fade), PhotoFilterView.this.v, 0, 100);
            } else if (i == PhotoFilterView.this.h) {
                photoEditToolCell.setIconAndTextAndValue(FH3.E("SoftenSkin", TD5.tgwidget_SoftenSkin), PhotoFilterView.this.w, 0, 100);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.h
        public RecyclerView.C onCreateViewHolder(ViewGroup viewGroup, int i) {
            PhotoEditRadioCell photoEditRadioCell;
            if (i == 0) {
                PhotoEditToolCell photoEditToolCell = new PhotoEditToolCell(this.d, PhotoFilterView.this.d1);
                photoEditToolCell.setSeekBarDelegate(new PhotoEditorSeekBar.a() { // from class: ir.nasim.X85
                    @Override // ir.nasim.tgwidgets.editor.ui.Components.PhotoEditorSeekBar.a
                    public final void a(int i2, int i3) {
                        this.a.D(i2, i3);
                    }
                });
                photoEditRadioCell = photoEditToolCell;
            } else {
                PhotoEditRadioCell photoEditRadioCell2 = new PhotoEditRadioCell(this.d);
                photoEditRadioCell2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Y85
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.a.E(view);
                    }
                });
                photoEditRadioCell = photoEditRadioCell2;
            }
            return new RecyclerListView.g(photoEditRadioCell);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x04ca  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x04ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public PhotoFilterView(android.content.Context r24, ir.nasim.tgwidgets.editor.ui.Components.VideoEditTextureView r25, android.graphics.Bitmap r26, int r27, ir.nasim.tgwidgets.editor.messenger.MediaController.n r28, ir.nasim.tgwidgets.editor.ui.Components.PaintingOverlay r29, int r30, boolean r31, boolean r32, ir.nasim.tgwidgets.editor.ui.ActionBar.m.h r33) {
        /*
            Method dump skipped, instructions count: 1584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.PhotoFilterView.<init>(android.content.Context, ir.nasim.tgwidgets.editor.ui.Components.VideoEditTextureView, android.graphics.Bitmap, int, ir.nasim.tgwidgets.editor.messenger.MediaController$n, ir.nasim.tgwidgets.editor.ui.Components.PaintingOverlay, int, boolean, boolean, ir.nasim.tgwidgets.editor.ui.ActionBar.m$h):void");
    }

    private void C0() {
        int i = this.G;
        if (i == 0) {
            Drawable drawableMutate = this.P0.getContext().getResources().getDrawable(AbstractC23598xB5.msg_blur_off).mutate();
            int i2 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.F4;
            drawableMutate.setColorFilter(new PorterDuffColorFilter(m0(i2), PorterDuff.Mode.MULTIPLY));
            this.P0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawableMutate, (Drawable) null, (Drawable) null);
            this.P0.setTextColor(m0(i2));
            this.Q0.setCompoundDrawablesWithIntrinsicBounds(0, AbstractC23598xB5.msg_blur_radial, 0, 0);
            this.Q0.setTextColor(-1);
            this.R0.setCompoundDrawablesWithIntrinsicBounds(0, AbstractC23598xB5.msg_blur_linear, 0, 0);
            this.R0.setTextColor(-1);
            return;
        }
        if (i == 1) {
            this.P0.setCompoundDrawablesWithIntrinsicBounds(0, AbstractC23598xB5.msg_blur_off, 0, 0);
            this.P0.setTextColor(-1);
            Drawable drawableMutate2 = this.P0.getContext().getResources().getDrawable(AbstractC23598xB5.msg_blur_radial).mutate();
            int i3 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.F4;
            drawableMutate2.setColorFilter(new PorterDuffColorFilter(m0(i3), PorterDuff.Mode.MULTIPLY));
            this.Q0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawableMutate2, (Drawable) null, (Drawable) null);
            this.Q0.setTextColor(m0(i3));
            this.R0.setCompoundDrawablesWithIntrinsicBounds(0, AbstractC23598xB5.msg_blur_linear, 0, 0);
            this.R0.setTextColor(-1);
            return;
        }
        if (i == 2) {
            this.P0.setCompoundDrawablesWithIntrinsicBounds(0, AbstractC23598xB5.msg_blur_off, 0, 0);
            this.P0.setTextColor(-1);
            this.Q0.setCompoundDrawablesWithIntrinsicBounds(0, AbstractC23598xB5.msg_blur_radial, 0, 0);
            this.Q0.setTextColor(-1);
            Drawable drawableMutate3 = this.P0.getContext().getResources().getDrawable(AbstractC23598xB5.msg_blur_linear).mutate();
            int i4 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.F4;
            drawableMutate3.setColorFilter(new PorterDuffColorFilter(m0(i4), PorterDuff.Mode.MULTIPLY));
            this.R0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawableMutate3, (Drawable) null, (Drawable) null);
            this.R0.setTextColor(m0(i4));
        }
    }

    private void l0(int i, int i2) {
        float width;
        int height;
        float fCeil;
        float fCeil2;
        if (this.J0) {
            int iF = i - AbstractC21455b.F(28.0f);
            int iF2 = i2 - (AbstractC21455b.F(214.0f) + (!this.W0 ? AbstractC21455b.d : 0));
            Bitmap bitmap = this.b1;
            if (bitmap != null) {
                int i3 = this.c1;
                if (i3 % 360 == 90 || i3 % 360 == 270) {
                    width = bitmap.getHeight();
                    height = this.b1.getWidth();
                } else {
                    width = bitmap.getWidth();
                    height = this.b1.getHeight();
                }
            } else {
                width = this.H0.getWidth();
                height = this.H0.getHeight();
            }
            float f = iF;
            float f2 = iF2;
            if (f / width > f2 / height) {
                fCeil2 = (int) Math.ceil(width * r7);
                fCeil = f2;
            } else {
                fCeil = (int) Math.ceil(r2 * r5);
                fCeil2 = f;
            }
            int iCeil = (int) Math.ceil(((f - fCeil2) / 2.0f) + AbstractC21455b.F(14.0f));
            int iCeil2 = (int) Math.ceil(((f2 - fCeil) / 2.0f) + AbstractC21455b.F(14.0f) + (!this.W0 ? AbstractC21455b.d : 0));
            int i4 = (int) fCeil2;
            int i5 = (int) fCeil;
            if (this.I0) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.H0.getLayoutParams();
                layoutParams.leftMargin = iCeil;
                layoutParams.topMargin = iCeil2;
                layoutParams.width = i4;
                layoutParams.height = i5;
            }
            float f3 = i4;
            float f4 = i5;
            this.O0.setActualArea(iCeil, iCeil2 - (!this.W0 ? AbstractC21455b.d : 0), f3, f4);
            this.N0.setActualAreaSize(f3, f4);
            ((FrameLayout.LayoutParams) this.N0.getLayoutParams()).height = AbstractC21455b.F(38.0f) + iF2;
            ((FrameLayout.LayoutParams) this.O0.getLayoutParams()).height = iF2 + AbstractC21455b.F(28.0f);
            if (AbstractC21455b.F0()) {
                int iF3 = AbstractC21455b.F(86.0f) * 10;
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.L0.getLayoutParams();
                if (iF3 < iF) {
                    layoutParams2.width = iF3;
                    layoutParams2.leftMargin = (iF - iF3) / 2;
                } else {
                    layoutParams2.width = -1;
                    layoutParams2.leftMargin = 0;
                }
            }
        }
    }

    private int m0(int i) {
        return ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(i, this.d1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(k kVar) {
        this.K0 = kVar;
        kVar.n0(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(C22697vg5 c22697vg5, float f, float f2, float f3) {
        this.z0 = f2;
        this.A0 = c22697vg5;
        this.B0 = f;
        this.C0 = f3;
        k kVar = this.K0;
        if (kVar != null) {
            kVar.l0(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0() {
        k kVar = this.K0;
        if (kVar != null) {
            kVar.l0(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(View view) {
        this.X0 = 0;
        this.Y0.setColorFilter(new PorterDuffColorFilter(m0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.F4), PorterDuff.Mode.MULTIPLY));
        this.Z0.setColorFilter((ColorFilter) null);
        this.a1.setColorFilter((ColorFilter) null);
        A0();
    }

    private void setShowOriginal(boolean z) {
        if (this.a == z) {
            return;
        }
        this.a = z;
        k kVar = this.K0;
        if (kVar != null) {
            kVar.l0(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(View view) {
        this.X0 = 1;
        this.Y0.setColorFilter((ColorFilter) null);
        this.Z0.setColorFilter(new PorterDuffColorFilter(m0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.F4), PorterDuff.Mode.MULTIPLY));
        this.a1.setColorFilter((ColorFilter) null);
        A0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(View view) {
        this.X0 = 2;
        this.Y0.setColorFilter((ColorFilter) null);
        this.Z0.setColorFilter((ColorFilter) null);
        this.a1.setColorFilter(new PorterDuffColorFilter(m0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.F4), PorterDuff.Mode.MULTIPLY));
        A0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(View view) {
        int iIntValue = ((Integer) view.getTag()).intValue();
        this.J.f = iIntValue;
        int i = 0;
        while (i < 4) {
            this.T0[i].setChecked(i == iIntValue, true);
            i++;
        }
        this.O0.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(View view) {
        this.G = 0;
        C0();
        this.N0.setVisibility(4);
        k kVar = this.K0;
        if (kVar != null) {
            kVar.l0(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(View view) {
        this.G = 1;
        C0();
        this.N0.setVisibility(0);
        this.N0.setType(1);
        k kVar = this.K0;
        if (kVar != null) {
            kVar.l0(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0(View view) {
        this.G = 2;
        C0();
        this.N0.setVisibility(0);
        this.N0.setType(0);
        k kVar = this.K0;
        if (kVar != null) {
            kVar.l0(false);
        }
    }

    public void A0() {
        int i = this.X0;
        if (i == 0) {
            this.N0.setVisibility(4);
            this.M0.setVisibility(4);
            this.S0.setVisibility(4);
            this.O0.setVisibility(4);
            this.L0.setVisibility(0);
            return;
        }
        if (i == 1) {
            this.L0.setVisibility(4);
            this.S0.setVisibility(4);
            this.O0.setVisibility(4);
            this.M0.setVisibility(0);
            if (this.G != 0) {
                this.N0.setVisibility(0);
            }
            C0();
            return;
        }
        if (i == 2) {
            this.L0.setVisibility(4);
            this.M0.setVisibility(4);
            this.N0.setVisibility(4);
            this.S0.setVisibility(0);
            this.O0.setVisibility(0);
            this.J.f = 0;
            int i2 = 0;
            while (i2 < 4) {
                this.T0[i2].setChecked(i2 == 0, false);
                i2++;
            }
        }
    }

    public void B0() {
        TextView textView = this.F0;
        if (textView != null) {
            textView.setTextColor(m0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.F4));
        }
        ImageView imageView = this.Y0;
        if (imageView != null && imageView.getColorFilter() != null) {
            this.Y0.setColorFilter(new PorterDuffColorFilter(m0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.F4), PorterDuff.Mode.MULTIPLY));
        }
        ImageView imageView2 = this.Z0;
        if (imageView2 != null && imageView2.getColorFilter() != null) {
            this.Z0.setColorFilter(new PorterDuffColorFilter(m0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.F4), PorterDuff.Mode.MULTIPLY));
        }
        ImageView imageView3 = this.a1;
        if (imageView3 != null && imageView3.getColorFilter() != null) {
            this.a1.setColorFilter(new PorterDuffColorFilter(m0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.F4), PorterDuff.Mode.MULTIPLY));
        }
        C0();
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
    public boolean a() {
        return this.a;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
    public boolean b() {
        return !this.J.b();
    }

    @Override // ir.nasim.tgwidgets.editor.ui.stories.recorder.StoryRecorder.u
    public boolean c(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0 || motionEvent.getActionMasked() == 5) {
            TextureView textureView = this.H0;
            if (textureView instanceof VideoEditTextureView) {
                if (((VideoEditTextureView) textureView).c(motionEvent.getX(), motionEvent.getY())) {
                    setShowOriginal(true);
                }
            } else if (motionEvent.getX() >= this.H0.getX() && motionEvent.getY() >= this.H0.getY() && motionEvent.getX() <= this.H0.getX() + this.H0.getWidth() && motionEvent.getY() <= this.H0.getY() + this.H0.getHeight()) {
                setShowOriginal(true);
            }
        } else if (motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 6) {
            setShowOriginal(false);
        }
        return true;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
    public ByteBuffer d() {
        this.J.a();
        return this.J.e;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean zDrawChild = super.drawChild(canvas, view, j);
        if (this.U0 != null && view == this.H0) {
            canvas.save();
            canvas.translate(this.H0.getLeft(), this.H0.getTop());
            float measuredWidth = this.H0.getMeasuredWidth() / this.U0.getMeasuredWidth();
            canvas.scale(measuredWidth, measuredWidth);
            this.U0.draw(canvas);
            canvas.restore();
        }
        return zDrawChild;
    }

    public Bitmap getBitmap() {
        k kVar = this.K0;
        if (kVar != null) {
            return kVar.Z();
        }
        return null;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
    public float getBlurAngle() {
        return this.C0;
    }

    public PhotoFilterBlurControl getBlurControl() {
        return this.N0;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
    public float getBlurExcludeBlurSize() {
        return this.B0;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
    public C22697vg5 getBlurExcludePoint() {
        return this.A0;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
    public float getBlurExcludeSize() {
        return this.z0;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
    public int getBlurType() {
        return this.G;
    }

    public TextView getCancelTextView() {
        return this.G0;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
    public float getContrastValue() {
        return ((this.s / 100.0f) * 0.3f) + 1.0f;
    }

    public PhotoFilterCurvesControl getCurveControl() {
        return this.O0;
    }

    public TextView getDoneTextView() {
        return this.F0;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
    public float getEnhanceValue() {
        return this.q / 100.0f;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
    public float getExposureValue() {
        return this.r / 100.0f;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
    public float getFadeValue() {
        return this.v / 100.0f;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
    public float getGrainValue() {
        return (this.D / 100.0f) * 0.04f;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
    public float getHighlightsValue() {
        return ((this.z * 0.75f) + 100.0f) / 100.0f;
    }

    public TextureView getMyTextureView() {
        if (!this.I0 || this.J0) {
            return null;
        }
        return this.H0;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
    public float getSaturationValue() {
        float f = this.u / 100.0f;
        if (f > 0.0f) {
            f *= 1.05f;
        }
        return f + 1.0f;
    }

    public MediaController.n getSavedFilterState() {
        MediaController.n nVar = new MediaController.n();
        nVar.a = this.q;
        nVar.c = this.r;
        nVar.d = this.s;
        nVar.e = this.t;
        nVar.f = this.u;
        nVar.g = this.v;
        nVar.b = this.w;
        nVar.h = this.x;
        nVar.i = this.y;
        nVar.j = this.z;
        nVar.k = this.A;
        nVar.l = this.B;
        nVar.m = this.D;
        nVar.n = this.G;
        nVar.o = this.H;
        nVar.p = this.J;
        nVar.q = this.z0;
        nVar.r = this.A0;
        nVar.s = this.B0;
        nVar.t = this.C0;
        this.D0 = nVar;
        return nVar;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
    public float getShadowsValue() {
        return ((this.A * 0.55f) + 100.0f) / 100.0f;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
    public float getSharpenValue() {
        return ((this.H / 100.0f) * 0.6f) + 0.11f;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
    public float getSoftenSkinValue() {
        return this.w / 100.0f;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
    public int getTintHighlightsColor() {
        return this.y;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
    public float getTintHighlightsIntensityValue() {
        return this.y == 0 ? 0.0f : 0.5f;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
    public int getTintShadowsColor() {
        return this.x;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
    public float getTintShadowsIntensityValue() {
        return this.x == 0 ? 0.0f : 0.5f;
    }

    public FrameLayout getToolsView() {
        return this.E0;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
    public float getVignetteValue() {
        return this.B / 100.0f;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.l.c
    public float getWarmthValue() {
        return this.t / 100.0f;
    }

    public boolean n0() {
        MediaController.n nVar = this.D0;
        return nVar != null ? (this.q == nVar.a && this.s == nVar.d && this.z == nVar.j && this.r == nVar.c && this.t == nVar.e && this.u == nVar.f && this.B == nVar.l && this.A == nVar.k && this.D == nVar.m && this.H == nVar.o && this.v == nVar.g && this.w == nVar.b && this.y == nVar.i && this.x == nVar.h && this.J.b()) ? false : true : (this.q == 0.0f && this.s == 0.0f && this.z == 0.0f && this.r == 0.0f && this.t == 0.0f && this.u == 0.0f && this.B == 0.0f && this.A == 0.0f && this.D == 0.0f && this.H == 0.0f && this.v == 0.0f && this.w == 0.0f && this.y == 0 && this.x == 0 && this.J.b()) ? false : true;
    }

    public void o0() {
        this.H0.setVisibility(0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        l0(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        super.onMeasure(i, i2);
    }

    public void setEnhanceValue(float f) {
        this.q = f * 100.0f;
        int i = 0;
        while (true) {
            if (i >= this.L0.getChildCount()) {
                break;
            }
            View childAt = this.L0.getChildAt(i);
            if ((childAt instanceof PhotoEditToolCell) && this.L0.getChildAdapterPosition(childAt) == this.b) {
                ((PhotoEditToolCell) childAt).setIconAndTextAndValue(FH3.E("Enhance", TD5.tgwidget_Enhance), this.q, 0, 100);
                break;
            }
            i++;
        }
        k kVar = this.K0;
        if (kVar != null) {
            kVar.l0(true);
        }
    }

    public void z0() {
        if (this.I0) {
            k kVar = this.K0;
            if (kVar != null) {
                kVar.r0();
                this.K0 = null;
            }
            this.H0.setVisibility(8);
            return;
        }
        TextureView textureView = this.H0;
        if (textureView instanceof VideoEditTextureView) {
            VideoEditTextureView videoEditTextureView = (VideoEditTextureView) textureView;
            MediaController.n nVar = this.D0;
            if (nVar == null) {
                videoEditTextureView.setDelegate(null);
                return;
            }
            k kVar2 = this.K0;
            if (kVar2 != null) {
                kVar2.n0(l.k(nVar));
            }
        }
    }
}
