package ir.nasim.tgwidgets.editor.ui.Components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class VideoTimelinePlayView extends View {
    private static final Object D = new Object();
    public static int G = 0;
    public static int H = 1;
    public static int J = 2;
    private Rect A;
    private Path B;
    private long a;
    private float b;
    private float c;
    private Paint d;
    private Paint e;
    private Paint f;
    private boolean g;
    private boolean h;
    private boolean i;
    private float j;
    private float k;
    private MediaMetadataRetriever l;
    private c m;
    private ArrayList n;
    private AsyncTask o;
    private long p;
    private int q;
    private int r;
    private int s;
    private float t;
    private float u;
    private RectF v;
    private int w;
    private int x;
    Paint y;
    private ArrayList z;

    class a extends AsyncTask {
        private int a = 0;

        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap doInBackground(Integer... numArr) {
            Bitmap frameAtTime;
            this.a = numArr[0].intValue();
            Bitmap bitmap = null;
            if (isCancelled()) {
                return null;
            }
            try {
                frameAtTime = VideoTimelinePlayView.this.l.getFrameAtTime(VideoTimelinePlayView.this.p * this.a * 1000, 2);
            } catch (Exception e) {
                e = e;
            }
            try {
                if (isCancelled()) {
                    return null;
                }
                if (frameAtTime == null) {
                    return frameAtTime;
                }
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(VideoTimelinePlayView.this.q, VideoTimelinePlayView.this.r, frameAtTime.getConfig());
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                float fMax = Math.max(VideoTimelinePlayView.this.q / frameAtTime.getWidth(), VideoTimelinePlayView.this.r / frameAtTime.getHeight());
                int width = (int) (frameAtTime.getWidth() * fMax);
                int height = (int) (frameAtTime.getHeight() * fMax);
                canvas.drawBitmap(frameAtTime, new Rect(0, 0, frameAtTime.getWidth(), frameAtTime.getHeight()), new Rect((VideoTimelinePlayView.this.q - width) / 2, (VideoTimelinePlayView.this.r - height) / 2, (VideoTimelinePlayView.this.q + width) / 2, (VideoTimelinePlayView.this.r + height) / 2), (Paint) null);
                frameAtTime.recycle();
                return bitmapCreateBitmap;
            } catch (Exception e2) {
                e = e2;
                bitmap = frameAtTime;
                AbstractC6403Nl2.d(e);
                return bitmap;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
            if (isCancelled()) {
                return;
            }
            VideoTimelinePlayView.this.n.add(new b(bitmap));
            VideoTimelinePlayView.this.invalidate();
            if (this.a < VideoTimelinePlayView.this.s) {
                VideoTimelinePlayView.this.l(this.a + 1);
            }
        }
    }

    private static class b {
        Bitmap a;
        float b;

        public b(Bitmap bitmap) {
            this.a = bitmap;
        }
    }

    public interface c {
        void a(float f);

        void b(int i);

        void c(int i);

        void d(float f);

        void e(float f);
    }

    public VideoTimelinePlayView(Context context) {
        super(context);
        this.c = 1.0f;
        this.j = 0.5f;
        this.n = new ArrayList();
        this.t = 1.0f;
        this.u = 0.0f;
        this.v = new RectF();
        this.x = 0;
        this.y = new Paint(3);
        this.z = new ArrayList();
        this.A = new Rect();
        this.B = new Path();
        Paint paint = new Paint(1);
        this.d = paint;
        paint.setColor(-1);
        Paint paint2 = new Paint();
        this.e = paint2;
        paint2.setColor(1291845632);
        Paint paint3 = new Paint();
        this.f = paint3;
        paint3.setColor(-16777216);
        this.z.add(this.A);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i) {
        if (this.l == null) {
            return;
        }
        if (i == 0) {
            this.r = AbstractC21455b.F(40.0f);
            this.s = Math.max(1, (getMeasuredWidth() - AbstractC21455b.F(16.0f)) / this.r);
            this.q = (int) Math.ceil((getMeasuredWidth() - AbstractC21455b.F(16.0f)) / this.s);
            this.p = this.a / this.s;
        }
        a aVar = new a();
        this.o = aVar;
        aVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, Integer.valueOf(i), null, null);
    }

    public float getLeftProgress() {
        return this.b;
    }

    public long getLength() {
        return Math.max(1L, this.a);
    }

    public float getProgress() {
        return this.j;
    }

    public float getRightProgress() {
        return this.c;
    }

    public void h() {
        Bitmap bitmap;
        for (int i = 0; i < this.n.size(); i++) {
            b bVar = (b) this.n.get(i);
            if (bVar != null && (bitmap = bVar.a) != null) {
                bitmap.recycle();
            }
        }
        this.n.clear();
        AsyncTask asyncTask = this.o;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.o = null;
        }
        invalidate();
    }

    public void i() {
        Bitmap bitmap;
        MediaMetadataRetriever mediaMetadataRetriever;
        synchronized (D) {
            try {
                mediaMetadataRetriever = this.l;
            } catch (Exception e) {
                AbstractC6403Nl2.d(e);
            }
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
                this.l = null;
            }
        }
        for (int i = 0; i < this.n.size(); i++) {
            b bVar = (b) this.n.get(i);
            if (bVar != null && (bitmap = bVar.a) != null) {
                bitmap.recycle();
            }
        }
        this.n.clear();
        AsyncTask asyncTask = this.o;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.o = null;
        }
    }

    public float j(int i) {
        if (i == G) {
            return getLeftProgress();
        }
        if (i == J) {
            return getProgress();
        }
        if (i == H) {
            return getRightProgress();
        }
        return 0.0f;
    }

    public boolean k() {
        return this.i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        int measuredWidth = getMeasuredWidth() - AbstractC21455b.F(32.0f);
        float f2 = measuredWidth;
        int iF = ((int) (this.b * f2)) + AbstractC21455b.F(16.0f);
        int iF2 = ((int) (this.c * f2)) + AbstractC21455b.F(16.0f);
        float f3 = 6.0f;
        int iF3 = AbstractC21455b.F(6.0f);
        int iF4 = AbstractC21455b.F(48.0f);
        canvas.save();
        canvas.clipRect(AbstractC21455b.F(16.0f), AbstractC21455b.F(4.0f), AbstractC21455b.F(20.0f) + measuredWidth, AbstractC21455b.F(48.0f));
        if (this.n.isEmpty() && this.o == null) {
            canvas.drawRect(AbstractC21455b.F(16.0f), iF3, AbstractC21455b.F(16.0f) + measuredWidth + AbstractC21455b.F(4.0f), AbstractC21455b.F(46.0f), this.e);
            l(0);
            f = 1.0f;
        } else {
            int i = 0;
            canvas.save();
            this.B.rewind();
            RectF rectF = AbstractC21455b.x;
            rectF.set(AbstractC21455b.F(16.0f), AbstractC21455b.F(6.0f), AbstractC21455b.F(20.0f) + measuredWidth, AbstractC21455b.F(46.0f));
            this.B.addRoundRect(rectF, AbstractC21455b.F(6.0f), AbstractC21455b.F(6.0f), Path.Direction.CW);
            canvas.clipPath(this.B);
            float f4 = iF;
            float f5 = iF3;
            canvas.drawRect(f4, f5, iF2, AbstractC21455b.F(46.0f), this.e);
            int i2 = 0;
            while (i2 < this.n.size()) {
                b bVar = (b) this.n.get(i2);
                if (bVar.a != null) {
                    int iF5 = AbstractC21455b.F(16.0f) + (this.q * i);
                    int iF6 = AbstractC21455b.F(f3);
                    float f6 = bVar.b;
                    if (f6 != 1.0f) {
                        float f7 = f6 + 0.045714285f;
                        bVar.b = f7;
                        if (f7 > 1.0f) {
                            bVar.b = 1.0f;
                        } else {
                            invalidate();
                        }
                        this.y.setAlpha((int) (InterpolatorC12631ew1.h.getInterpolation(bVar.b) * 255.0f));
                        canvas.drawBitmap(bVar.a, iF5, iF6, this.y);
                    } else {
                        canvas.drawBitmap(bVar.a, iF5, iF6, (Paint) null);
                    }
                }
                i++;
                i2++;
                f3 = 6.0f;
            }
            f = 1.0f;
            canvas.drawRect(AbstractC21455b.F(16.0f), f5, f4, AbstractC21455b.F(46.0f), this.e);
            canvas.drawRect(AbstractC21455b.F(4.0f) + iF2, f5, AbstractC21455b.F(16.0f) + measuredWidth + AbstractC21455b.F(4.0f), AbstractC21455b.F(46.0f), this.e);
            canvas.restore();
        }
        float f8 = iF;
        float f9 = iF4;
        canvas.drawRect(f8, AbstractC21455b.F(4.0f), AbstractC21455b.F(2.0f) + iF, f9, this.d);
        canvas.drawRect(AbstractC21455b.F(2.0f) + iF2, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f) + iF2, f9, this.d);
        canvas.drawRect(AbstractC21455b.F(2.0f) + iF, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f) + iF2, iF3, this.d);
        canvas.drawRect(AbstractC21455b.F(2.0f) + iF, iF4 - AbstractC21455b.F(2.0f), AbstractC21455b.F(4.0f) + iF2, f9, this.d);
        canvas.restore();
        this.v.set(iF - AbstractC21455b.F(8.0f), AbstractC21455b.F(4.0f), iF + AbstractC21455b.F(2.0f), f9);
        canvas.drawRoundRect(this.v, AbstractC21455b.F(3.0f), AbstractC21455b.F(3.0f), this.d);
        this.v.set(f8 - AbstractC21455b.H(2.0f), AbstractC21455b.F(21.17f), f8 - AbstractC21455b.H(4.0f), AbstractC21455b.F(30.83f));
        canvas.drawRoundRect(this.v, AbstractC21455b.F(3.0f), AbstractC21455b.F(3.0f), this.f);
        this.v.set(AbstractC21455b.F(2.0f) + iF2, AbstractC21455b.F(4.0f), AbstractC21455b.F(12.0f) + iF2, f9);
        canvas.drawRoundRect(this.v, AbstractC21455b.F(3.0f), AbstractC21455b.F(3.0f), this.d);
        float f10 = iF2;
        this.v.set(AbstractC21455b.H(6.0f) + f10, AbstractC21455b.F(21.17f), f10 + AbstractC21455b.H(8.0f), AbstractC21455b.F(30.83f));
        canvas.drawRoundRect(this.v, AbstractC21455b.F(3.0f), AbstractC21455b.F(3.0f), this.f);
        float F = AbstractC21455b.F(18.0f) + (f2 * this.j);
        this.v.set(F - AbstractC21455b.F(2.0f), AbstractC21455b.F(2.0f), AbstractC21455b.F(2.0f) + F, AbstractC21455b.F(50.0f));
        canvas.drawRoundRect(this.v, AbstractC21455b.F(f), AbstractC21455b.F(f), this.e);
        this.v.set(F - AbstractC21455b.H(1.5f), AbstractC21455b.F(2.0f), F + AbstractC21455b.H(1.5f), AbstractC21455b.F(50.0f));
        canvas.drawRoundRect(this.v, AbstractC21455b.F(f), AbstractC21455b.F(f), this.d);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (Build.VERSION.SDK_INT >= 29) {
            this.A.set(i, 0, i3, getMeasuredHeight());
            setSystemGestureExclusionRects(this.z);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        if (this.w != size) {
            h();
            this.w = size;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int measuredWidth = getMeasuredWidth() - AbstractC21455b.F(32.0f);
        float f = measuredWidth;
        int iF = ((int) (this.b * f)) + AbstractC21455b.F(16.0f);
        int iF2 = ((int) (this.j * f)) + AbstractC21455b.F(16.0f);
        int iF3 = ((int) (this.c * f)) + AbstractC21455b.F(16.0f);
        if (motionEvent.getAction() == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
            if (this.l == null) {
                return false;
            }
            int iF4 = AbstractC21455b.F(16.0f);
            int iF5 = AbstractC21455b.F(8.0f);
            if (iF3 != iF && iF2 - iF5 <= x && x <= iF5 + iF2 && y >= 0.0f && y <= getMeasuredHeight()) {
                c cVar = this.m;
                if (cVar != null) {
                    cVar.b(J);
                }
                this.i = true;
                this.k = (int) (x - iF2);
                invalidate();
                return true;
            }
            if (iF - iF4 <= x && x <= Math.min(iF + iF4, iF3) && y >= 0.0f && y <= getMeasuredHeight()) {
                c cVar2 = this.m;
                if (cVar2 != null) {
                    cVar2.b(G);
                }
                this.g = true;
                this.k = (int) (x - iF);
                invalidate();
                return true;
            }
            if (iF3 - iF4 <= x && x <= iF4 + iF3 && y >= 0.0f && y <= getMeasuredHeight()) {
                c cVar3 = this.m;
                if (cVar3 != null) {
                    cVar3.b(H);
                }
                this.h = true;
                this.k = (int) (x - iF3);
                invalidate();
                return true;
            }
            if (iF <= x && x <= iF3 && y >= 0.0f && y <= getMeasuredHeight()) {
                c cVar4 = this.m;
                if (cVar4 != null) {
                    cVar4.b(J);
                }
                this.i = true;
                float F = (x - AbstractC21455b.F(16.0f)) / f;
                this.j = F;
                c cVar5 = this.m;
                if (cVar5 != null) {
                    cVar5.e(F);
                }
                this.k = 0.0f;
                invalidate();
                return true;
            }
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            if (this.g) {
                c cVar6 = this.m;
                if (cVar6 != null) {
                    cVar6.c(G);
                }
                this.g = false;
                return true;
            }
            if (this.h) {
                c cVar7 = this.m;
                if (cVar7 != null) {
                    cVar7.c(H);
                }
                this.h = false;
                return true;
            }
            if (this.i) {
                c cVar8 = this.m;
                if (cVar8 != null) {
                    cVar8.c(J);
                }
                this.i = false;
            }
        } else if (motionEvent.getAction() == 2) {
            if (this.i) {
                float F2 = (((int) (x - this.k)) - AbstractC21455b.F(16.0f)) / f;
                this.j = F2;
                float f2 = this.b;
                if (F2 < f2) {
                    this.j = f2;
                } else {
                    float f3 = this.c;
                    if (F2 > f3) {
                        this.j = f3;
                    }
                }
                c cVar9 = this.m;
                if (cVar9 != null) {
                    cVar9.e(this.j);
                }
                invalidate();
                return true;
            }
            if (this.g) {
                int i = (int) (x - this.k);
                if (i < AbstractC21455b.F(16.0f)) {
                    iF3 = AbstractC21455b.F(16.0f);
                } else if (i <= iF3) {
                    iF3 = i;
                }
                float F3 = (iF3 - AbstractC21455b.F(16.0f)) / f;
                this.b = F3;
                float f4 = this.c;
                float f5 = f4 - F3;
                float f6 = this.t;
                if (f5 > f6) {
                    this.c = F3 + f6;
                } else {
                    float f7 = this.u;
                    if (f7 != 0.0f && f4 - F3 < f7) {
                        float f8 = f4 - f7;
                        this.b = f8;
                        if (f8 < 0.0f) {
                            this.b = 0.0f;
                        }
                    }
                }
                float f9 = this.b;
                float f10 = this.j;
                if (f9 > f10) {
                    this.j = f9;
                } else {
                    float f11 = this.c;
                    if (f11 < f10) {
                        this.j = f11;
                    }
                }
                c cVar10 = this.m;
                if (cVar10 != null) {
                    cVar10.d(f9);
                }
                invalidate();
                return true;
            }
            if (this.h) {
                int i2 = (int) (x - this.k);
                if (i2 >= iF) {
                    iF = i2 > AbstractC21455b.F(16.0f) + measuredWidth ? measuredWidth + AbstractC21455b.F(16.0f) : i2;
                }
                float F4 = (iF - AbstractC21455b.F(16.0f)) / f;
                this.c = F4;
                float f12 = this.b;
                float f13 = F4 - f12;
                float f14 = this.t;
                if (f13 > f14) {
                    this.b = F4 - f14;
                } else {
                    float f15 = this.u;
                    if (f15 != 0.0f && F4 - f12 < f15) {
                        float f16 = f12 + f15;
                        this.c = f16;
                        if (f16 > 1.0f) {
                            this.c = 1.0f;
                        }
                    }
                }
                float f17 = this.b;
                float f18 = this.j;
                if (f17 > f18) {
                    this.j = f17;
                } else {
                    float f19 = this.c;
                    if (f19 < f18) {
                        this.j = f19;
                    }
                }
                c cVar11 = this.m;
                if (cVar11 != null) {
                    cVar11.a(this.c);
                }
                invalidate();
                return true;
            }
        }
        return true;
    }

    public void setDelegate(c cVar) {
        this.m = cVar;
    }

    public void setLeftRightProgress(float f, float f2) {
        this.c = f2;
        this.b = f;
        invalidate();
    }

    public void setMaxProgressDiff(float f) {
        this.t = f;
        float f2 = this.c;
        float f3 = this.b;
        if (f2 - f3 > f) {
            this.c = f3 + f;
            invalidate();
        }
    }

    public void setMinProgressDiff(float f) {
        this.u = f;
    }

    public void setMode(int i) {
        if (this.x == i) {
            return;
        }
        this.x = i;
        invalidate();
    }

    public void setProgress(float f) {
        this.j = f;
        invalidate();
    }

    public void setRightProgress(float f) {
        this.c = f;
        c cVar = this.m;
        if (cVar != null) {
            cVar.b(H);
        }
        c cVar2 = this.m;
        if (cVar2 != null) {
            cVar2.a(this.c);
        }
        c cVar3 = this.m;
        if (cVar3 != null) {
            cVar3.c(H);
        }
        invalidate();
    }

    public void setVideoPath(String str, float f, float f2) {
        i();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        this.l = mediaMetadataRetriever;
        this.b = f;
        this.c = f2;
        try {
            mediaMetadataRetriever.setDataSource(str);
            this.a = Long.parseLong(this.l.extractMetadata(9));
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
        }
        invalidate();
    }
}
