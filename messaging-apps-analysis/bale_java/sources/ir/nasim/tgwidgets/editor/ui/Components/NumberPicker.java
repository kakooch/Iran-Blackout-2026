package ir.nasim.tgwidgets.editor.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC21558tk6;
import ir.nasim.C23274we6;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import java.util.Locale;

/* loaded from: classes7.dex */
public class NumberPicker extends LinearLayout {
    private static final InterpolatorC12631ew1 V0 = new InterpolatorC12631ew1(0.0f, 0.5f, 0.5f, 1.0f);
    private C23274we6 A;
    private VelocityTracker A0;
    private C23274we6 B;
    private int B0;
    private int C0;
    private int D;
    private int D0;
    private boolean E0;
    private boolean F0;
    private b G;
    private int G0;
    private float H;
    private Paint H0;
    private int I0;
    private long J;
    private int J0;
    private boolean K0;
    private int L0;
    private int M0;
    private boolean N0;
    private boolean O0;
    private f P0;
    private int Q0;
    private AbstractC21558tk6 R0;
    private final m.h S0;
    private boolean T0;
    private Integer U0;
    private int a;
    private int b;
    private int c;
    private TextView d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private boolean j;
    private int k;
    private int l;
    private String[] m;
    private int n;
    private boolean o;
    private int p;
    private boolean q;
    private int r;
    private int s;
    private long t;
    private final SparseArray u;
    private int[] v;
    private Paint w;
    private int x;
    private int y;
    private int z;
    private float z0;

    class a extends AbstractC21558tk6 {
        a() {
        }

        @Override // ir.nasim.AbstractC21558tk6
        protected boolean c(View view) {
            return true;
        }

        @Override // ir.nasim.AbstractC21558tk6
        protected boolean d(View view) {
            return true;
        }

        @Override // ir.nasim.AbstractC21558tk6
        protected void e(View view, boolean z) {
            NumberPicker.this.i(!z);
        }

        @Override // ir.nasim.AbstractC21558tk6
        public CharSequence f(View view) {
            NumberPicker numberPicker = NumberPicker.this;
            return numberPicker.p(numberPicker.r);
        }
    }

    class b implements Runnable {
        private boolean a;

        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            NumberPicker.this.i(this.a);
            NumberPicker numberPicker = NumberPicker.this;
            numberPicker.postDelayed(this, numberPicker.t);
        }
    }

    public interface c {
    }

    public interface d {
    }

    public interface e {
    }

    class f implements Runnable {
        private final int a = 1;
        private final int b = 2;
        private int c;
        private int d;

        f() {
        }

        public void a(int i) {
            c();
            this.d = 1;
            this.c = i;
            NumberPicker.this.postDelayed(this, ViewConfiguration.getTapTimeout());
        }

        public void b(int i) {
            c();
            this.d = 2;
            this.c = i;
            NumberPicker.this.post(this);
        }

        public void c() {
            this.d = 0;
            this.c = 0;
            NumberPicker.this.removeCallbacks(this);
            if (NumberPicker.this.N0) {
                NumberPicker.this.N0 = false;
                NumberPicker numberPicker = NumberPicker.this;
                numberPicker.invalidate(0, numberPicker.M0, NumberPicker.this.getRight(), NumberPicker.this.getBottom());
            }
            NumberPicker.this.O0 = false;
            if (NumberPicker.this.O0) {
                NumberPicker numberPicker2 = NumberPicker.this;
                numberPicker2.invalidate(0, 0, numberPicker2.getRight(), NumberPicker.this.L0);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = this.d;
            if (i == 1) {
                int i2 = this.c;
                if (i2 == 1) {
                    NumberPicker.this.N0 = true;
                    NumberPicker numberPicker = NumberPicker.this;
                    numberPicker.invalidate(0, numberPicker.M0, NumberPicker.this.getRight(), NumberPicker.this.getBottom());
                    return;
                } else {
                    if (i2 != 2) {
                        return;
                    }
                    NumberPicker.this.O0 = true;
                    NumberPicker numberPicker2 = NumberPicker.this;
                    numberPicker2.invalidate(0, 0, numberPicker2.getRight(), NumberPicker.this.L0);
                    return;
                }
            }
            if (i != 2) {
                return;
            }
            int i3 = this.c;
            if (i3 == 1) {
                if (!NumberPicker.this.N0) {
                    NumberPicker.this.postDelayed(this, ViewConfiguration.getPressedStateDuration());
                }
                NumberPicker.this.N0 = !r0.N0;
                NumberPicker numberPicker3 = NumberPicker.this;
                numberPicker3.invalidate(0, numberPicker3.M0, NumberPicker.this.getRight(), NumberPicker.this.getBottom());
                return;
            }
            if (i3 != 2) {
                return;
            }
            if (!NumberPicker.this.O0) {
                NumberPicker.this.postDelayed(this, ViewConfiguration.getPressedStateDuration());
            }
            NumberPicker.this.O0 = !r0.O0;
            NumberPicker numberPicker4 = NumberPicker.this;
            numberPicker4.invalidate(0, 0, numberPicker4.getRight(), NumberPicker.this.L0);
        }
    }

    public NumberPicker(Context context) {
        this(context, null);
    }

    private void A(int i) {
        if (this.J0 == i) {
            return;
        }
        this.J0 = i;
        if (i == 0) {
            AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
            if (accessibilityManager.isTouchExplorationEnabled()) {
                String[] strArr = this.m;
                String strN = strArr == null ? n(this.r) : strArr[this.r - this.n];
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(16384);
                accessibilityEventObtain.getText().add(strN);
                accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain);
            }
        }
    }

    private void B(C23274we6 c23274we6) {
        if (c23274we6 == this.A) {
            if (!l()) {
                I();
            }
            A(0);
        } else if (this.J0 != 1) {
            I();
        }
    }

    private void C(boolean z, long j) {
        b bVar = this.G;
        if (bVar == null) {
            this.G = new b();
        } else {
            removeCallbacks(bVar);
        }
        this.G.b(z);
        postDelayed(this.G, j);
    }

    private void D() {
        b bVar = this.G;
        if (bVar != null) {
            removeCallbacks(bVar);
        }
        this.P0.c();
    }

    private void E() {
        b bVar = this.G;
        if (bVar != null) {
            removeCallbacks(bVar);
        }
    }

    private int F(int i, int i2, int i3) {
        return i != -1 ? resolveSizeAndState(Math.max(i, i2), i3, 0) : i2;
    }

    private void G(int i, boolean z) {
        if (this.r == i) {
            return;
        }
        int iR = this.E0 ? r(i) : Math.min(Math.max(i, this.n), this.p);
        int i2 = this.r;
        this.s = iR;
        this.r = iR;
        I();
        if (Math.abs(i2 - iR) > 0.9f && Build.VERSION.SDK_INT >= 27) {
            try {
                performHapticFeedback(9, 1);
            } catch (Exception unused) {
            }
        }
        if (z) {
            z(i2, iR);
        }
        w();
        invalidate();
    }

    private void H() {
        int i;
        if (this.j) {
            String[] strArr = this.m;
            int i2 = 0;
            if (strArr == null) {
                float f2 = 0.0f;
                for (int i3 = 0; i3 <= 9; i3++) {
                    float fMeasureText = this.w.measureText(o(i3));
                    if (fMeasureText > f2) {
                        f2 = fMeasureText;
                    }
                }
                for (int i4 = this.p; i4 > 0; i4 /= 10) {
                    i2++;
                }
                i = (int) (i2 * f2);
            } else {
                int length = strArr.length;
                int i5 = 0;
                while (i2 < length) {
                    float fMeasureText2 = this.w.measureText(strArr[i2]);
                    if (fMeasureText2 > i5) {
                        i5 = (int) fMeasureText2;
                    }
                    i2++;
                }
                i = i5;
            }
            int paddingLeft = i + this.d.getPaddingLeft() + this.d.getPaddingRight();
            if (this.i != paddingLeft) {
                int i6 = this.h;
                if (paddingLeft > i6) {
                    this.i = paddingLeft;
                } else {
                    this.i = i6;
                }
                invalidate();
            }
        }
    }

    private boolean I() {
        String[] strArr = this.m;
        String strN = strArr == null ? n(this.r) : strArr[this.r - this.n];
        if (TextUtils.isEmpty(strN) || strN.equals(this.d.getText().toString())) {
            return false;
        }
        this.d.setText(strN);
        return true;
    }

    private void j(int[] iArr) {
        System.arraycopy(iArr, 0, iArr, 1, iArr.length - 1);
        int i = iArr[1] - 1;
        if (this.E0 && i < this.n) {
            i = this.p;
        }
        iArr[0] = i;
        k(i);
    }

    private void k(int i) {
        String strN;
        SparseArray sparseArray = this.u;
        if (((String) sparseArray.get(i)) != null) {
            return;
        }
        int i2 = this.n;
        if (i < i2 || i > this.p) {
            strN = "";
        } else {
            String[] strArr = this.m;
            strN = strArr != null ? strArr[i - i2] : n(i);
        }
        sparseArray.put(i, strN);
    }

    private boolean l() {
        int i = this.y - this.z;
        if (i == 0) {
            return false;
        }
        this.D = 0;
        int iAbs = Math.abs(i);
        int i2 = this.x;
        if (iAbs > i2 / 2) {
            if (i > 0) {
                i2 = -i2;
            }
            i += i2;
        }
        this.B.j(0, 0, 0, i, 800);
        invalidate();
        return true;
    }

    private void m(int i) {
        this.D = 0;
        if (i > 0) {
            this.A.c(0, 0, 0, i, 0, 0, 0, Integer.MAX_VALUE);
        } else {
            this.A.c(0, Integer.MAX_VALUE, 0, i, 0, 0, 0, Integer.MAX_VALUE);
        }
        invalidate();
    }

    private String n(int i) {
        return o(i);
    }

    private static String o(int i) {
        return String.format(Locale.getDefault(), "%d", Integer.valueOf(i));
    }

    private int q(int i) {
        return ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(i, this.S0);
    }

    private int r(int i) {
        int i2;
        int i3;
        if (this.q && i > (i3 = this.p)) {
            if (i3 - this.n != 0) {
                return (r1 + ((i - i3) % (i3 - r1))) - 1;
            }
        }
        if (this.o && i < (i2 = this.n)) {
            int i4 = this.p;
            if (i4 - i2 != 0) {
                return (i4 - ((i2 - i) % (i4 - i2))) + 1;
            }
        }
        return i;
    }

    public static int resolveSizeAndState(int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 1073741824) {
                i = size;
            }
        } else if (size < i) {
            i = 16777216 | size;
        }
        return i | ((-16777216) & i3);
    }

    private void s(int[] iArr) {
        System.arraycopy(iArr, 1, iArr, 0, iArr.length - 1);
        int i = iArr[iArr.length - 2] + 1;
        if (this.E0 && i > this.p) {
            i = this.n;
        }
        iArr[iArr.length - 1] = i;
        k(i);
    }

    private void t() {
        this.G0 = 0;
        Paint paint = new Paint();
        this.H0 = paint;
        paint.setColor(q(ir.nasim.tgwidgets.editor.ui.ActionBar.m.t4));
        this.I0 = (int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics());
        this.e = (int) TypedValue.applyDimension(1, 48.0f, getResources().getDisplayMetrics());
        this.f = -1;
        int iApplyDimension = (int) TypedValue.applyDimension(1, 180.0f, getResources().getDisplayMetrics());
        this.g = iApplyDimension;
        int i = this.f;
        if (i != -1 && iApplyDimension != -1 && i > iApplyDimension) {
            throw new IllegalArgumentException("minHeight > maxHeight");
        }
        this.h = (int) TypedValue.applyDimension(1, 64.0f, getResources().getDisplayMetrics());
        this.i = -1;
        this.j = true;
        this.P0 = new f();
        setWillNotDraw(false);
        TextView textView = new TextView(getContext());
        this.d = textView;
        textView.setGravity(17);
        this.d.setSingleLine(true);
        this.d.setTextColor(q(ir.nasim.tgwidgets.editor.ui.ActionBar.m.V3));
        this.d.setBackgroundResource(0);
        this.d.setTextSize(0, this.k);
        this.d.setVisibility(4);
        addView(this.d, new LinearLayout.LayoutParams(-1, -2));
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.B0 = viewConfiguration.getScaledTouchSlop();
        this.C0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.D0 = viewConfiguration.getScaledMaximumFlingVelocity() / 8;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setTextAlign(Paint.Align.CENTER);
        paint2.setTextSize(this.k);
        paint2.setTypeface(this.d.getTypeface());
        paint2.setColor(this.d.getTextColors().getColorForState(LinearLayout.ENABLED_STATE_SET, -1));
        this.w = paint2;
        this.A = new C23274we6(getContext(), null, true);
        this.B = new C23274we6(getContext(), new DecelerateInterpolator(2.5f));
        I();
        setImportantForAccessibility(1);
        a aVar = new a();
        this.R0 = aVar;
        setAccessibilityDelegate(aVar);
    }

    private void u() {
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength(((getBottom() - getTop()) - this.k) / 2);
    }

    private void v() {
        w();
        int length = this.v.length * this.k;
        int bottom = getBottom() - getTop();
        int i = this.k;
        int length2 = (int) ((((bottom + i) - length) / r0.length) + 0.5f);
        this.l = length2;
        this.x = i + length2;
        int baseline = (this.d.getBaseline() + this.d.getTop()) - (this.x * this.b);
        this.y = baseline;
        this.z = baseline;
        I();
    }

    private void w() {
        this.u.clear();
        int[] iArr = this.v;
        int value = getValue();
        for (int i = 0; i < this.v.length; i++) {
            int iR = (i - this.b) + value;
            if (this.E0) {
                iR = r(iR);
            }
            iArr[i] = iR;
            k(iR);
        }
    }

    private int x(int i, int i2) {
        if (i2 == -1) {
            return i;
        }
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i2), 1073741824);
        }
        if (mode == 0) {
            return View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        }
        if (mode == 1073741824) {
            return i;
        }
        throw new IllegalArgumentException("Unknown measure mode: " + mode);
    }

    private boolean y(C23274we6 c23274we6) {
        c23274we6.d(true);
        int iG = c23274we6.g() - c23274we6.f();
        int i = this.y - ((this.z + iG) % this.x);
        if (i == 0) {
            return false;
        }
        int iAbs = Math.abs(i);
        int i2 = this.x;
        if (iAbs > i2 / 2) {
            i = i > 0 ? i - i2 : i + i2;
        }
        scrollBy(0, iG + i);
        return true;
    }

    private void z(int i, int i2) {
    }

    @Override // android.view.View
    public void computeScroll() {
        C23274we6 c23274we6 = this.A;
        if (c23274we6.i()) {
            c23274we6 = this.B;
            if (c23274we6.i()) {
                return;
            }
        }
        c23274we6.b();
        int iF = c23274we6.f();
        if (this.D == 0) {
            this.D = c23274we6.h();
        }
        scrollBy(0, iF - this.D);
        this.D = iF;
        if (c23274we6.i()) {
            B(c23274we6);
        } else {
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeVerticalScrollExtent() {
        return getHeight();
    }

    @Override // android.view.View
    protected int computeVerticalScrollOffset() {
        return this.z;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return ((this.p - this.n) + 1) * this.x;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0047, code lost:
    
        requestFocus();
        r5.Q0 = r0;
        D();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0055, code lost:
    
        if (r5.A.i() == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0057, code lost:
    
        if (r0 != 20) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0059, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005b, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005c, code lost:
    
        i(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005f, code lost:
    
        return true;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchKeyEvent(android.view.KeyEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getKeyCode()
            r1 = 19
            r2 = 20
            if (r0 == r1) goto L19
            if (r0 == r2) goto L19
            r1 = 23
            if (r0 == r1) goto L15
            r1 = 66
            if (r0 == r1) goto L15
            goto L60
        L15:
            r5.D()
            goto L60
        L19:
            int r1 = r6.getAction()
            r3 = 1
            if (r1 == 0) goto L2b
            if (r1 == r3) goto L23
            goto L60
        L23:
            int r1 = r5.Q0
            if (r1 != r0) goto L60
            r6 = -1
            r5.Q0 = r6
            return r3
        L2b:
            boolean r1 = r5.E0
            if (r1 != 0) goto L3d
            if (r0 != r2) goto L32
            goto L3d
        L32:
            int r1 = r5.getValue()
            int r4 = r5.getMinValue()
            if (r1 <= r4) goto L60
            goto L47
        L3d:
            int r1 = r5.getValue()
            int r4 = r5.getMaxValue()
            if (r1 >= r4) goto L60
        L47:
            r5.requestFocus()
            r5.Q0 = r0
            r5.D()
            ir.nasim.we6 r6 = r5.A
            boolean r6 = r6.i()
            if (r6 == 0) goto L5f
            if (r0 != r2) goto L5b
            r6 = r3
            goto L5c
        L5b:
            r6 = 0
        L5c:
            r5.i(r6)
        L5f:
            return r3
        L60:
            boolean r6 = super.dispatchKeyEvent(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.NumberPicker.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            D();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            D();
        }
        return super.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        return 0.9f;
    }

    public String[] getDisplayedValues() {
        return this.m;
    }

    public int getItemsCount() {
        return this.a;
    }

    public int getMaxValue() {
        return this.p;
    }

    public int getMinValue() {
        return this.n;
    }

    @Override // android.view.View
    public int getSolidColor() {
        return this.G0;
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        return 0.9f;
    }

    public int getValue() {
        return this.r;
    }

    public boolean getWrapSelectorWheel() {
        return this.E0;
    }

    protected void i(boolean z) {
        this.d.setVisibility(4);
        if (!y(this.A)) {
            y(this.B);
        }
        this.D = 0;
        if (z) {
            this.A.j(0, 0, 0, -this.x, 300);
        } else {
            this.A.j(0, 0, 0, this.x, 300);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        D();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        float measuredHeight;
        boolean z;
        int alpha;
        float right = ((getRight() - getLeft()) / 2) + this.c;
        float f2 = this.z;
        int[] iArr = this.v;
        for (int i = 0; i < iArr.length; i++) {
            String str = (String) this.u.get(iArr[i]);
            if (str != null && (i != this.b || this.d.getVisibility() != 0)) {
                if (this.a > 3) {
                    float measuredHeight2 = getMeasuredHeight() / 2.0f;
                    float measuredHeight3 = getMeasuredHeight() * 0.5f;
                    float textSize = f2 - (this.w.getTextSize() / 2.0f);
                    if (textSize < measuredHeight2) {
                        measuredHeight = textSize / measuredHeight3;
                        z = true;
                    } else {
                        measuredHeight = (getMeasuredHeight() - textSize) / measuredHeight3;
                        z = false;
                    }
                    float interpolation = V0.getInterpolation(Utilities.c(measuredHeight, 1.0f, 0.0f));
                    float textSize2 = (1.0f - interpolation) * this.w.getTextSize();
                    if (!z) {
                        textSize2 = -textSize2;
                    }
                    canvas.save();
                    canvas.translate(0.0f, textSize2);
                    canvas.scale((0.2f * interpolation) + 0.8f, interpolation, right, textSize);
                    if (interpolation < 0.1f) {
                        alpha = this.w.getAlpha();
                        this.w.setAlpha((int) ((alpha * interpolation) / 0.1f));
                    } else {
                        alpha = -1;
                    }
                    canvas.drawText(str, right, f2, this.w);
                    canvas.restore();
                    if (alpha != -1) {
                        this.w.setAlpha(alpha);
                    }
                } else {
                    canvas.drawText(str, right, f2, this.w);
                }
            }
            f2 += this.x;
        }
        if (this.T0) {
            canvas.drawRect(0.0f, this.L0, getRight(), this.I0 + r0, this.H0);
            canvas.drawRect(0.0f, r0 - this.I0, getRight(), this.M0, this.H0);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || motionEvent.getActionMasked() != 0) {
            return false;
        }
        D();
        this.d.setVisibility(4);
        float y = motionEvent.getY();
        this.H = y;
        this.z0 = y;
        this.J = motionEvent.getEventTime();
        this.K0 = false;
        float f2 = this.H;
        if (f2 < this.L0) {
            if (this.J0 == 0) {
                this.P0.a(2);
            }
        } else if (f2 > this.M0 && this.J0 == 0) {
            this.P0.a(1);
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        if (!this.A.i()) {
            this.A.d(true);
            this.B.d(true);
            A(0);
        } else if (this.B.i()) {
            float f3 = this.H;
            if (f3 < this.L0) {
                C(false, ViewConfiguration.getLongPressTimeout());
            } else if (f3 > this.M0) {
                C(true, ViewConfiguration.getLongPressTimeout());
            }
        } else {
            this.A.d(true);
            this.B.d(true);
        }
        return true;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int measuredWidth2 = this.d.getMeasuredWidth();
        int measuredHeight2 = this.d.getMeasuredHeight();
        int i5 = (measuredWidth - measuredWidth2) / 2;
        int i6 = (measuredHeight - measuredHeight2) / 2;
        this.d.layout(i5, i6, measuredWidth2 + i5, measuredHeight2 + i6);
        if (z) {
            v();
            u();
            this.L0 = ((getHeight() - this.k) - this.l) / 2;
            this.M0 = ((getHeight() + this.k) + this.l) / 2;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(x(i, this.i), x(i2, this.g));
        setMeasuredDimension(F(this.h, getMeasuredWidth(), i), F(this.f, getMeasuredHeight(), i2));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        if (this.A0 == null) {
            this.A0 = VelocityTracker.obtain();
        }
        this.A0.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            E();
            this.P0.c();
            VelocityTracker velocityTracker = this.A0;
            velocityTracker.computeCurrentVelocity(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, this.D0);
            int yVelocity = (int) velocityTracker.getYVelocity();
            if (Math.abs(yVelocity) > this.C0) {
                m(yVelocity);
                A(2);
            } else {
                int y = (int) motionEvent.getY();
                int iAbs = (int) Math.abs(y - this.H);
                long eventTime = motionEvent.getEventTime() - this.J;
                if (iAbs > this.B0 || eventTime >= ViewConfiguration.getTapTimeout()) {
                    l();
                } else {
                    int i = (y / this.x) - this.b;
                    if (i > 0) {
                        i(true);
                        this.P0.b(1);
                    } else if (i < 0) {
                        i(false);
                        this.P0.b(2);
                    }
                }
                A(0);
            }
            this.A0.recycle();
            this.A0 = null;
        } else if (actionMasked == 2 && !this.K0) {
            float y2 = motionEvent.getY();
            if (this.J0 == 1) {
                scrollBy(0, (int) (y2 - this.z0));
                invalidate();
            } else if (((int) Math.abs(y2 - this.H)) > this.B0) {
                D();
                A(1);
            }
            this.z0 = y2;
        }
        return true;
    }

    protected CharSequence p(int i) {
        return this.d.getText();
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        int[] iArr = this.v;
        boolean z = this.E0;
        if (!z && i2 > 0 && iArr[this.b] <= this.n) {
            int i3 = this.z + i2;
            int i4 = this.y;
            if (i3 > i4) {
                this.z = i4;
                return;
            }
        }
        if (!z && i2 < 0 && iArr[this.b] >= this.p) {
            int i5 = this.z + i2;
            int i6 = this.y;
            if (i5 < i6) {
                this.z = i6;
                return;
            }
        }
        this.z += i2;
        while (true) {
            int i7 = this.z;
            if (i7 - this.y <= this.l) {
                break;
            }
            this.z = i7 - this.x;
            j(iArr);
            if (!this.E0 && iArr[this.b] <= this.n) {
                int i8 = this.z;
                int i9 = this.y;
                if (i8 > i9) {
                    this.z = i9;
                }
            }
        }
        while (true) {
            int i10 = this.z;
            if (i10 - this.y >= (-this.l)) {
                G(iArr[this.b], true);
                return;
            }
            this.z = i10 + this.x;
            s(iArr);
            if (!this.E0 && iArr[this.b] >= this.p) {
                int i11 = this.z;
                int i12 = this.y;
                if (i11 < i12) {
                    this.z = i12;
                }
            }
        }
    }

    public void setAllItemsCount(int i) {
        this.U0 = Integer.valueOf(i);
        setWrapSelectorWheel(this.F0);
    }

    public void setDisplayedValues(String[] strArr) {
        if (this.m == strArr) {
            return;
        }
        this.m = strArr;
        I();
        w();
        H();
    }

    public void setDrawDividers(boolean z) {
        this.T0 = z;
        invalidate();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.d.setEnabled(z);
    }

    public void setFormatter(c cVar) {
        if (cVar == null) {
            return;
        }
        w();
        I();
    }

    public void setItemCount(int i) {
        if (this.a == i) {
            return;
        }
        this.a = i;
        this.b = i / 2;
        this.v = new int[i];
        w();
    }

    public void setMaxValue(int i) {
        this.q = true;
        if (this.p == i) {
            return;
        }
        if (i < 0) {
            throw new IllegalArgumentException("maxValue must be >= 0");
        }
        this.p = i;
        if (i < this.r) {
            int i2 = this.s;
            if (i >= i2) {
                this.r = i2;
            } else {
                this.r = i;
            }
        }
        setWrapSelectorWheel(this.F0);
        w();
        I();
        H();
        invalidate();
    }

    public void setMinValue(int i) {
        this.o = true;
        if (this.n == i) {
            return;
        }
        if (i < 0) {
            throw new IllegalArgumentException("minValue must be >= 0");
        }
        this.n = i;
        if (i > this.r) {
            int i2 = this.s;
            if (i <= i2) {
                this.r = i2;
            } else {
                this.r = i;
            }
        }
        setWrapSelectorWheel(this.F0);
        w();
        I();
        H();
        invalidate();
    }

    public void setOnLongPressUpdateInterval(long j) {
        this.t = j;
    }

    public void setOnScrollListener(d dVar) {
    }

    public void setOnValueChangedListener(e eVar) {
    }

    public void setSelectorColor(int i) {
        this.H0.setColor(i);
    }

    public void setTextColor(int i) {
        this.d.setTextColor(i);
        this.w.setColor(i);
    }

    public void setTextOffset(int i) {
        this.c = i;
        invalidate();
    }

    public void setValue(int i) {
        G(i, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setWrapSelectorWheel(boolean r5) {
        /*
            r4 = this;
            boolean r0 = r4.q
            r1 = 1
            if (r0 == 0) goto L19
            boolean r0 = r4.o
            if (r0 == 0) goto L19
            java.lang.Integer r0 = r4.U0
            if (r0 == 0) goto L1e
            int r2 = r4.p
            int r3 = r4.n
            int r2 = r2 - r3
            int r2 = r2 + r1
            int r0 = r0.intValue()
            if (r2 < r0) goto L1e
        L19:
            r4.F0 = r5
            if (r5 == 0) goto L1e
            goto L1f
        L1e:
            r1 = 0
        L1f:
            r4.E0 = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.NumberPicker.setWrapSelectorWheel(boolean):void");
    }

    public NumberPicker(Context context, m.h hVar) {
        this(context, 18, hVar);
    }

    public NumberPicker(Context context, int i, m.h hVar) {
        super(context);
        this.a = 3;
        this.b = 3 / 2;
        this.t = 300L;
        this.u = new SparseArray();
        this.v = new int[this.a];
        this.y = RecyclerView.UNDEFINED_DURATION;
        this.J0 = 0;
        this.Q0 = -1;
        this.T0 = true;
        this.S0 = hVar;
        this.k = AbstractC21455b.F(i);
        t();
    }
}
