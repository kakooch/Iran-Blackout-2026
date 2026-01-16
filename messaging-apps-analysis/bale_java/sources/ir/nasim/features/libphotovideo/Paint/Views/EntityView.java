package ir.nasim.features.libphotovideo.Paint.Views;

import android.content.Context;
import android.graphics.Paint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C5495Jo7;
import ir.nasim.features.media.components.Point;
import ir.nasim.features.media.components.Rect;
import java.util.UUID;

/* loaded from: classes3.dex */
public class EntityView extends FrameLayout {
    private float a;
    private float b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private b i;
    protected Point j;
    protected SelectionView k;
    private int l;
    private int m;
    private GestureDetector n;
    private UUID o;

    public class SelectionView extends FrameLayout {
        protected Paint a;
        protected Paint b;
        protected Paint c;
        private int d;

        public SelectionView(Context context) {
            super(context);
            this.a = new Paint(1);
            this.b = new Paint(1);
            this.c = new Paint(1);
            setWillNotDraw(false);
            Paint paint = this.a;
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            paint.setColor(c5495Jo7.f0());
            this.b.setColor(c5495Jo7.t2());
            this.c.setColor(c5495Jo7.f0());
            this.c.setStyle(Paint.Style.STROKE);
            this.c.setStrokeWidth(AbstractC7426Rr.z(1.0f));
        }

        protected int a(float f, float f2) {
            return 0;
        }

        protected void b() {
            Rect selectionBounds = EntityView.this.getSelectionBounds();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
            layoutParams.leftMargin = ((int) selectionBounds.x) + EntityView.this.l;
            layoutParams.topMargin = ((int) selectionBounds.y) + EntityView.this.m;
            layoutParams.width = (int) selectionBounds.width;
            layoutParams.height = (int) selectionBounds.height;
            setLayoutParams(layoutParams);
            setRotation(EntityView.this.getRotation());
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x00fe  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x011f  */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTouchEvent(android.view.MotionEvent r12) {
            /*
                Method dump skipped, instructions count: 340
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.libphotovideo.Paint.Views.EntityView.SelectionView.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (EntityView.this.c || EntityView.this.e || EntityView.this.d) {
                return;
            }
            EntityView.this.h = true;
            if (EntityView.this.i != null) {
                EntityView.this.performHapticFeedback(0);
                EntityView.this.i.e(EntityView.this);
            }
        }
    }

    public interface b {
        boolean a();

        void b();

        void c();

        boolean d(EntityView entityView);

        boolean e(EntityView entityView);
    }

    public EntityView(Context context, Point point) {
        super(context);
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.j = new Point();
        this.o = UUID.randomUUID();
        this.j = point;
        this.n = new GestureDetector(context, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u(float f, float f2) {
        float scaleX = ((View) getParent()).getScaleX();
        Point point = new Point((f - this.a) / scaleX, (f2 - this.b) / scaleX);
        if (((float) Math.hypot(point.x, point.y)) <= (this.c ? 6.0f : 16.0f)) {
            return false;
        }
        w(point);
        this.a = f;
        this.b = f2;
        if (!this.g) {
            this.g = true;
            b bVar = this.i;
            if (bVar != null) {
                bVar.c();
            }
        }
        this.c = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        b bVar;
        b bVar2;
        if (!this.h && !this.c && !this.e && !this.f && (bVar2 = this.i) != null) {
            bVar2.d(this);
        }
        if (this.g && (bVar = this.i) != null) {
            bVar.b();
        }
        this.h = false;
        this.c = false;
        this.e = false;
        this.d = true;
        this.f = false;
        this.g = false;
    }

    protected void A() {
        setX(this.j.x - (getWidth() / 2.0f));
        setY(this.j.y - (getHeight() / 2.0f));
        B();
    }

    public void B() {
        SelectionView selectionView = this.k;
        if (selectionView != null) {
            selectionView.b();
        }
    }

    public Point getPosition() {
        return this.j;
    }

    public float getScale() {
        return getScaleX();
    }

    protected Rect getSelectionBounds() {
        return new Rect(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public UUID getUUID() {
        return this.o;
    }

    @Override // android.view.View
    public boolean isSelected() {
        return this.k != null;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.i.a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002b, code lost:
    
        if (r4 != 6) goto L28;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getPointerCount()
            r1 = 0
            r2 = 1
            if (r0 > r2) goto L53
            ir.nasim.features.libphotovideo.Paint.Views.EntityView$b r0 = r6.i
            boolean r0 = r0.a()
            if (r0 != 0) goto L11
            goto L53
        L11:
            float r0 = r7.getRawX()
            float r3 = r7.getRawY()
            int r4 = r7.getActionMasked()
            if (r4 == 0) goto L38
            if (r4 == r2) goto L33
            r5 = 2
            if (r4 == r5) goto L2e
            r5 = 3
            if (r4 == r5) goto L33
            r5 = 5
            if (r4 == r5) goto L38
            r0 = 6
            if (r4 == r0) goto L33
            goto L4e
        L2e:
            boolean r1 = r6.u(r0, r3)
            goto L4e
        L33:
            r6.v()
        L36:
            r1 = r2
            goto L4e
        L38:
            boolean r4 = r6.isSelected()
            if (r4 != 0) goto L47
            ir.nasim.features.libphotovideo.Paint.Views.EntityView$b r4 = r6.i
            if (r4 == 0) goto L47
            r4.d(r6)
            r6.f = r2
        L47:
            r6.a = r0
            r6.b = r3
            r6.d = r1
            goto L36
        L4e:
            android.view.GestureDetector r0 = r6.n
            r0.onTouchEvent(r7)
        L53:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.libphotovideo.Paint.Views.EntityView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    protected SelectionView s() {
        return null;
    }

    public void setDelegate(b bVar) {
        this.i = bVar;
    }

    public void setOffset(int i, int i2) {
        this.l = i;
        this.m = i2;
    }

    public void setPosition(Point point) {
        this.j = point;
        A();
    }

    public void setScale(float f) {
        setScaleX(f);
        setScaleY(f);
    }

    public void setSelectionVisibility(boolean z) {
        SelectionView selectionView = this.k;
        if (selectionView == null) {
            return;
        }
        selectionView.setVisibility(z ? 0 : 8);
    }

    public void t() {
        SelectionView selectionView = this.k;
        if (selectionView == null) {
            return;
        }
        if (selectionView.getParent() != null) {
            ((ViewGroup) this.k.getParent()).removeView(this.k);
        }
        this.k = null;
    }

    public void w(Point point) {
        Point point2 = this.j;
        point2.x += point.x;
        point2.y += point.y;
        A();
    }

    public void x(float f) {
        setRotation(f);
        B();
    }

    public void y(float f) {
        setScale(Math.max(getScale() * f, 0.1f));
        B();
    }

    public void z(ViewGroup viewGroup) {
        SelectionView selectionViewS = s();
        this.k = selectionViewS;
        viewGroup.addView(selectionViewS);
        selectionViewS.b();
    }
}
