package ir.nasim.tgwidgets.editor.ui.ActionBar;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.N72;
import ir.nasim.TI6;
import ir.nasim.WL6;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.Components.AnimatedEmojiSpan;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/* loaded from: classes7.dex */
public class SimpleTextView extends View implements Drawable.Callback {
    private int A;
    private int A0;
    private Paint B;
    private int B0;
    private int C0;
    private Paint D;
    private int D0;
    public int E0;
    public int F0;
    private Paint G;
    private boolean G0;
    private int H;
    private boolean H0;
    private boolean I0;
    private int J;
    private boolean J0;
    private Boolean K0;
    private int L0;
    private int M0;
    private int N0;
    private int O0;
    private int P0;
    private float Q0;
    private int R0;
    private int S0;
    private List T0;
    private Stack U0;
    private Path V0;
    private boolean W0;
    private boolean X0;
    private View.OnClickListener Y0;
    private boolean Z0;
    private Layout a;
    private float a1;
    private Layout b;
    private float b1;
    private Layout c;
    private AnimatedEmojiSpan.b c1;
    private Layout d;
    private boolean d1;
    private TextPaint e;
    private Layout.Alignment e1;
    private int f;
    private int g;
    private CharSequence h;
    private Drawable i;
    private Drawable j;
    private Drawable k;
    private String l;
    private int m;
    private float n;
    private float o;
    private int p;
    private int q;
    private int r;
    private boolean s;
    private float t;
    private boolean u;
    private Drawable v;
    private boolean w;
    private boolean x;
    private float y;
    private long z;
    private int z0;

    public SimpleTextView(Context context) {
        super(context);
        this.f = 51;
        this.g = 1;
        this.o = 1.0f;
        this.p = AbstractC21455b.F(4.0f);
        this.L0 = 16;
        this.S0 = 3;
        this.T0 = new ArrayList();
        this.U0 = new Stack();
        this.V0 = new Path();
        this.e1 = Layout.Alignment.ALIGN_NORMAL;
        this.e = new TextPaint(1);
        setImportantForAccessibility(1);
    }

    private void a(int i) {
        Layout layout = this.a;
        if (layout == null) {
            return;
        }
        if (layout.getLineCount() > 0) {
            this.B0 = (int) Math.ceil(this.a.getLineWidth(0));
            Layout layout2 = this.c;
            if (layout2 != null) {
                this.D0 = layout2.getLineBottom(layout2.getLineCount() - 1);
            } else if (this.g <= 1 || this.a.getLineCount() <= 0) {
                this.D0 = this.a.getLineBottom(0);
            } else {
                Layout layout3 = this.a;
                this.D0 = layout3.getLineBottom(layout3.getLineCount() - 1);
            }
            int i2 = this.f;
            if ((i2 & 7) == 1) {
                this.z0 = ((i - this.B0) / 2) - ((int) this.a.getLineLeft(0));
            } else if ((i2 & 7) == 3) {
                Layout layout4 = this.b;
                if (layout4 != null) {
                    this.z0 = -((int) layout4.getLineLeft(0));
                } else {
                    this.z0 = -((int) this.a.getLineLeft(0));
                }
            } else if (this.a.getLineLeft(0) == 0.0f) {
                Layout layout5 = this.b;
                if (layout5 != null) {
                    this.z0 = (int) (i - layout5.getLineWidth(0));
                } else {
                    this.z0 = i - this.B0;
                }
            } else {
                this.z0 = -AbstractC21455b.F(8.0f);
            }
            this.z0 += getPaddingLeft();
            this.x = this.B0 > i - this.M0;
            Layout layout6 = this.c;
            if (layout6 != null && this.O0 > 0) {
                this.Q0 = layout6.getPrimaryHorizontal(0) - this.b.getPrimaryHorizontal(0);
            }
        }
        int i3 = this.m;
        if (i3 >= 0) {
            this.n = this.a.getPrimaryHorizontal(i3);
        } else {
            this.n = 0.0f;
        }
    }

    private void b(Canvas canvas) {
        this.V0.rewind();
        Iterator it = this.T0.iterator();
        while (it.hasNext()) {
            Rect bounds = ((TI6) it.next()).getBounds();
            this.V0.addRect(bounds.left, bounds.top, bounds.right, bounds.bottom, Path.Direction.CW);
        }
        canvas.clipPath(this.V0, Region.Op.DIFFERENCE);
    }

    private void e(Canvas canvas) {
        if (this.t <= 0.0f || this.P0 == 0) {
            canvas.save();
            b(canvas);
            AnimatedEmojiSpan.b bVar = this.c1;
            if (bVar != null) {
                bVar.b();
            }
            this.a.draw(canvas);
            canvas.restore();
            AnimatedEmojiSpan.e(canvas, this.a, this.c1, 0.0f, null, 0.0f, 0.0f, 0.0f, 1.0f);
            f(canvas);
            return;
        }
        canvas.save();
        float f = -this.P0;
        float f2 = this.t;
        canvas.translate((f * f2) + (this.Q0 * f2), 0.0f);
        canvas.save();
        b(canvas);
        AnimatedEmojiSpan.b bVar2 = this.c1;
        if (bVar2 != null) {
            bVar2.b();
        }
        this.a.draw(canvas);
        canvas.restore();
        AnimatedEmojiSpan.e(canvas, this.a, this.c1, 0.0f, null, 0.0f, 0.0f, 0.0f, 1.0f);
        f(canvas);
        canvas.restore();
    }

    private void f(Canvas canvas) {
        Iterator it = this.T0.iterator();
        while (it.hasNext()) {
            ((TI6) it.next()).draw(canvas);
        }
    }

    private boolean g() {
        if (!this.G0 || getMeasuredHeight() == 0 || this.s) {
            requestLayout();
            return true;
        }
        boolean zD = d(((getMaxTextWidth() - getPaddingLeft()) - getPaddingRight()) - this.R0);
        if ((this.f & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 16) {
            this.A0 = (getMeasuredHeight() - this.D0) / 2;
        } else {
            this.A0 = getPaddingTop();
        }
        return zD;
    }

    private Layout.Alignment getAlignment() {
        return this.e1;
    }

    private int getMaxTextWidth() {
        Drawable drawable;
        return getMeasuredWidth() - ((!this.H0 || (drawable = this.j) == null) ? 0 : drawable.getIntrinsicWidth() + this.p);
    }

    private void k() {
        if ((this.B == null || this.D == null) && this.w) {
            Paint paint = new Paint();
            this.B = paint;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new LinearGradient(0.0f, 0.0f, AbstractC21455b.F(6.0f), 0.0f, new int[]{-1, 0}, new float[]{0.0f, 1.0f}, tileMode));
            Paint paint2 = this.B;
            PorterDuff.Mode mode = PorterDuff.Mode.DST_OUT;
            paint2.setXfermode(new PorterDuffXfermode(mode));
            Paint paint3 = new Paint();
            this.D = paint3;
            paint3.setShader(new LinearGradient(0.0f, 0.0f, AbstractC21455b.F(6.0f), 0.0f, new int[]{0, -1}, new float[]{0.0f, 1.0f}, tileMode));
            this.D.setXfermode(new PorterDuffXfermode(mode));
        }
        Boolean bool = this.K0;
        boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
        if (!(this.G != null && this.H == AbstractC21455b.F(this.L0) && this.J0 == zBooleanValue) && this.I0) {
            if (this.G == null) {
                this.G = new Paint();
            }
            this.J0 = zBooleanValue;
            if (zBooleanValue) {
                Paint paint4 = this.G;
                int iF = AbstractC21455b.F(this.L0);
                this.H = iF;
                paint4.setShader(new LinearGradient(0.0f, 0.0f, iF, 0.0f, new int[]{-1, 0}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP));
            } else {
                Paint paint5 = this.G;
                int iF2 = AbstractC21455b.F(this.L0);
                this.H = iF2;
                paint5.setShader(new LinearGradient(0.0f, 0.0f, iF2, 0.0f, new int[]{0, -1}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP));
            }
            this.G.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        }
    }

    private void l() {
        if (this.w) {
            if (this.x || this.y != 0.0f) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long j = jElapsedRealtime - this.z;
                if (j > 17) {
                    j = 17;
                }
                int i = this.A;
                if (i > 0) {
                    this.A = (int) (i - j);
                } else {
                    int iF = this.C0 + AbstractC21455b.F(16.0f);
                    float F = this.y + ((j / 1000.0f) * AbstractC21455b.F(this.y < ((float) AbstractC21455b.F(100.0f)) ? ((this.y / AbstractC21455b.F(100.0f)) * 20.0f) + 30.0f : this.y >= ((float) (iF - AbstractC21455b.F(100.0f))) ? 50.0f - (((this.y - (iF - AbstractC21455b.F(100.0f))) / AbstractC21455b.F(100.0f)) * 20.0f) : 50.0f));
                    this.y = F;
                    this.z = jElapsedRealtime;
                    if (F > iF) {
                        this.y = 0.0f;
                        this.A = SIPTransactionStack.BASE_TIMER_INTERVAL;
                    }
                }
                invalidate();
            }
        }
    }

    public void c(SimpleTextView simpleTextView) {
        this.y = simpleTextView.y;
    }

    protected boolean d(int i) {
        int intrinsicWidth;
        int i2;
        CharSequence charSequenceEllipsize = this.h;
        this.m = -1;
        this.X0 = false;
        if (charSequenceEllipsize != null) {
            try {
                Drawable drawable = this.i;
                int intrinsicWidth2 = drawable != null ? (i - drawable.getIntrinsicWidth()) - this.p : i;
                if (this.j == null || this.H0) {
                    intrinsicWidth = 0;
                } else {
                    intrinsicWidth = (int) (r3.getIntrinsicWidth() * this.o);
                    intrinsicWidth2 = (intrinsicWidth2 - intrinsicWidth) - this.p;
                }
                if (this.l != null && this.k != null) {
                    int iIndexOf = charSequenceEllipsize.toString().indexOf(this.l);
                    this.m = iIndexOf;
                    if (iIndexOf >= 0) {
                        charSequenceEllipsize = SpannableStringBuilder.valueOf(charSequenceEllipsize);
                    } else {
                        intrinsicWidth2 = (intrinsicWidth2 - this.k.getIntrinsicWidth()) - this.p;
                    }
                }
                if (this.W0 && intrinsicWidth != 0 && !this.H0 && !charSequenceEllipsize.equals(TextUtils.ellipsize(charSequenceEllipsize, this.e, intrinsicWidth2, TextUtils.TruncateAt.END))) {
                    this.X0 = true;
                    intrinsicWidth2 = intrinsicWidth2 + intrinsicWidth + this.p;
                }
                int i3 = intrinsicWidth2;
                if (this.s) {
                    CharSequence charSequenceEllipsize2 = !this.I0 ? TextUtils.ellipsize(charSequenceEllipsize, this.e, i3, TextUtils.TruncateAt.END) : charSequenceEllipsize;
                    if (this.I0 || charSequenceEllipsize2.equals(charSequenceEllipsize)) {
                        this.a = new StaticLayout(charSequenceEllipsize2, 0, charSequenceEllipsize2.length(), this.e, (this.w || this.I0) ? AbstractC21455b.F(2000.0f) : AbstractC21455b.F(8.0f) + i3, getAlignment(), 1.0f, 0.0f, false);
                        this.c = null;
                        this.d = null;
                        this.b = null;
                    } else {
                        int length = charSequenceEllipsize.length();
                        TextPaint textPaint = this.e;
                        Layout.Alignment alignment = getAlignment();
                        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
                        StaticLayout staticLayoutC = WL6.c(charSequenceEllipsize, 0, length, textPaint, i3, alignment, 1.0f, 0.0f, false, truncateAt, i3, this.S0, false);
                        this.c = staticLayoutC;
                        if (staticLayoutC != null) {
                            int lineEnd = staticLayoutC.getLineEnd(0);
                            int lineStart = this.c.getLineStart(1);
                            CharSequence charSequenceSubSequence = charSequenceEllipsize.subSequence(0, lineEnd);
                            SpannableStringBuilder spannableStringBuilderValueOf = SpannableStringBuilder.valueOf(charSequenceEllipsize);
                            spannableStringBuilderValueOf.setSpan(new N72(), 0, lineStart, 0);
                            String strSubSequence = lineEnd < charSequenceEllipsize2.length() ? charSequenceEllipsize2.subSequence(lineEnd, charSequenceEllipsize2.length()) : "…";
                            this.b = new StaticLayout(charSequenceEllipsize2, 0, charSequenceEllipsize2.length(), this.e, this.w ? AbstractC21455b.F(2000.0f) : AbstractC21455b.F(8.0f) + i3, getAlignment(), 1.0f, 0.0f, false);
                            StaticLayout staticLayout = new StaticLayout(charSequenceSubSequence, 0, charSequenceSubSequence.length(), this.e, this.w ? AbstractC21455b.F(2000.0f) : AbstractC21455b.F(8.0f) + i3, getAlignment(), 1.0f, 0.0f, false);
                            this.a = staticLayout;
                            if (staticLayout.getLineLeft(0) != 0.0f) {
                                strSubSequence = "\u200f" + ((Object) strSubSequence);
                            }
                            CharSequence charSequence = strSubSequence;
                            this.d = new StaticLayout(charSequence, 0, charSequence.length(), this.e, this.w ? AbstractC21455b.F(2000.0f) : AbstractC21455b.F(8.0f) + i3, getAlignment(), 1.0f, 0.0f, false);
                            this.c = WL6.c(spannableStringBuilderValueOf, 0, spannableStringBuilderValueOf.length(), this.e, AbstractC21455b.F(8.0f) + i3 + this.O0, getAlignment(), 1.0f, 0.0f, false, truncateAt, i3 + this.O0, this.S0, false);
                        }
                    }
                } else if (this.g > 1) {
                    this.a = WL6.c(charSequenceEllipsize, 0, charSequenceEllipsize.length(), this.e, i3, getAlignment(), 1.0f, 0.0f, false, TextUtils.TruncateAt.END, i3, this.g, false);
                } else {
                    if (!this.w && !this.I0) {
                        charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.e, i3, TextUtils.TruncateAt.END);
                    }
                    CharSequence charSequence2 = charSequenceEllipsize;
                    this.a = new StaticLayout(charSequence2, 0, charSequence2.length(), this.e, (this.w || this.I0) ? AbstractC21455b.F(2000.0f) : AbstractC21455b.F(8.0f) + i3, getAlignment(), 1.0f, 0.0f, false);
                }
                this.U0.addAll(this.T0);
                this.T0.clear();
                Layout layout = this.a;
                if (layout == null || !(layout.getText() instanceof Spannable)) {
                    i2 = i3;
                } else {
                    i2 = i3;
                    TI6.m(this, this.a, -2, -2, this.U0, this.T0);
                }
                a(i2);
            } catch (Exception unused) {
            }
        } else {
            this.a = null;
            this.B0 = 0;
            this.D0 = 0;
        }
        AnimatedEmojiSpan.i(this, this.c1);
        if (this.d1) {
            this.c1 = AnimatedEmojiSpan.l(0, this, this.c1, this.a);
        }
        invalidate();
        return true;
    }

    @Override // android.view.View
    public Drawable getBackground() {
        Drawable drawable = this.v;
        return drawable != null ? drawable : super.getBackground();
    }

    public Paint getPaint() {
        return this.e;
    }

    public CharSequence getText() {
        CharSequence charSequence = this.h;
        return charSequence == null ? "" : charSequence;
    }

    public int getTextColor() {
        return this.e.getColor();
    }

    public int getTextHeight() {
        return this.D0;
    }

    public TextPaint getTextPaint() {
        return this.e;
    }

    public int getTextStartX() {
        int intrinsicWidth = 0;
        if (this.a == null) {
            return 0;
        }
        Drawable drawable = this.i;
        if (drawable != null && (this.f & 7) == 3) {
            intrinsicWidth = this.p + drawable.getIntrinsicWidth();
        }
        Drawable drawable2 = this.k;
        if (drawable2 != null && this.m < 0 && (this.f & 7) == 3) {
            intrinsicWidth += this.p + drawable2.getIntrinsicWidth();
        }
        return ((int) getX()) + this.z0 + intrinsicWidth;
    }

    public int getTextStartY() {
        if (this.a == null) {
            return 0;
        }
        return (int) getY();
    }

    public int getTextWidth() {
        return this.B0;
    }

    public void h() {
        this.y = 0.0f;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public boolean i(CharSequence charSequence) {
        return j(charSequence, false);
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = this.i;
        if (drawable == drawable2) {
            invalidate(drawable2.getBounds());
            return;
        }
        Drawable drawable3 = this.j;
        if (drawable == drawable3) {
            invalidate(drawable3.getBounds());
            return;
        }
        Drawable drawable4 = this.k;
        if (drawable == drawable4) {
            invalidate(drawable4.getBounds());
        }
    }

    public boolean j(CharSequence charSequence, boolean z) {
        CharSequence charSequence2 = this.h;
        if (charSequence2 == null && charSequence == null) {
            return false;
        }
        if (!z && charSequence2 != null && charSequence2.equals(charSequence)) {
            return false;
        }
        this.h = charSequence;
        this.A = SIPTransactionStack.BASE_TIMER_INTERVAL;
        g();
        return true;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.d1 = true;
        this.c1 = AnimatedEmojiSpan.l(0, this, this.c1, this.a);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.d1 = false;
        AnimatedEmojiSpan.i(this, this.c1);
        this.G0 = false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int intrinsicWidth;
        int paddingTop;
        int i;
        float F;
        int paddingTop2;
        int i2;
        int paddingTop3;
        int i3;
        int paddingTop4;
        int i4;
        int paddingTop5;
        int i5;
        super.onDraw(canvas);
        boolean z = this.w && (this.x || this.y != 0.0f);
        int iSaveLayerAlpha = (z || this.I0) ? canvas.saveLayerAlpha(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), 255, 31) : RecyclerView.UNDEFINED_DURATION;
        this.C0 = this.B0;
        if (this.i != null) {
            int i6 = (int) (-this.y);
            int i7 = this.f;
            if ((i7 & 7) == 1) {
                i6 += this.z0;
            }
            if ((i7 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 16) {
                paddingTop5 = (getMeasuredHeight() - this.i.getIntrinsicHeight()) / 2;
                i5 = this.q;
            } else {
                paddingTop5 = getPaddingTop() + ((this.D0 - this.i.getIntrinsicHeight()) / 2);
                i5 = this.q;
            }
            int i8 = paddingTop5 + i5;
            Drawable drawable = this.i;
            drawable.setBounds(i6, i8, drawable.getIntrinsicWidth() + i6, this.i.getIntrinsicHeight() + i8);
            this.i.draw(canvas);
            int i9 = this.f;
            intrinsicWidth = ((i9 & 7) == 3 || (i9 & 7) == 1) ? this.p + this.i.getIntrinsicWidth() : 0;
            this.C0 += this.p + this.i.getIntrinsicWidth();
        } else {
            intrinsicWidth = 0;
        }
        Drawable drawable2 = this.k;
        if (drawable2 != null && this.l != null) {
            int i10 = (int) ((-this.y) + this.n);
            int i11 = this.f;
            if ((i11 & 7) == 1) {
                i10 += this.z0;
            }
            int measuredHeight = (i11 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 16 ? ((getMeasuredHeight() - this.k.getIntrinsicHeight()) / 2) + this.q : this.q + ((this.D0 - drawable2.getIntrinsicHeight()) / 2);
            Drawable drawable3 = this.k;
            drawable3.setBounds(i10, measuredHeight, drawable3.getIntrinsicWidth() + i10, this.k.getIntrinsicHeight() + measuredHeight);
            this.k.draw(canvas);
            if (this.m < 0) {
                int i12 = this.f;
                if ((i12 & 7) == 3 || (i12 & 7) == 1) {
                    intrinsicWidth += this.p + this.k.getIntrinsicWidth();
                }
                this.C0 += this.p + this.k.getIntrinsicWidth();
            }
        }
        int i13 = intrinsicWidth;
        if (this.j != null && !this.X0 && this.o > 0.0f && !this.H0) {
            int i14 = this.B0 + i13 + this.p + ((int) (-this.y));
            int i15 = this.f;
            if ((i15 & 7) == 1 || (i15 & 7) == 5) {
                i14 += this.z0;
            }
            int intrinsicWidth2 = (int) (r1.getIntrinsicWidth() * this.o);
            int intrinsicHeight = (int) (this.j.getIntrinsicHeight() * this.o);
            if ((this.f & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 16) {
                paddingTop4 = (getMeasuredHeight() - intrinsicHeight) / 2;
                i4 = this.r;
            } else {
                paddingTop4 = getPaddingTop() + ((this.D0 - intrinsicHeight) / 2);
                i4 = this.r;
            }
            int i16 = paddingTop4 + i4;
            this.j.setBounds(i14, i16, i14 + intrinsicWidth2, i16 + intrinsicHeight);
            this.E0 = i14 + (intrinsicWidth2 >> 1);
            this.F0 = i16 + (intrinsicHeight >> 1);
            this.j.draw(canvas);
            this.C0 += this.p + intrinsicWidth2;
        }
        int iF = this.C0 + AbstractC21455b.F(16.0f);
        float f = this.y;
        if (f != 0.0f) {
            if (this.i != null) {
                int i17 = ((int) (-f)) + iF;
                if ((this.f & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 16) {
                    paddingTop3 = (getMeasuredHeight() - this.i.getIntrinsicHeight()) / 2;
                    i3 = this.q;
                } else {
                    paddingTop3 = getPaddingTop() + ((this.D0 - this.i.getIntrinsicHeight()) / 2);
                    i3 = this.q;
                }
                int i18 = paddingTop3 + i3;
                Drawable drawable4 = this.i;
                drawable4.setBounds(i17, i18, drawable4.getIntrinsicWidth() + i17, this.i.getIntrinsicHeight() + i18);
                this.i.draw(canvas);
            }
            if (this.j != null && !this.H0) {
                int intrinsicWidth3 = (int) (r1.getIntrinsicWidth() * this.o);
                int intrinsicHeight2 = (int) (this.j.getIntrinsicHeight() * this.o);
                int i19 = this.B0 + i13 + this.p + ((int) (-this.y)) + iF;
                if ((this.f & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 16) {
                    paddingTop2 = (getMeasuredHeight() - intrinsicHeight2) / 2;
                    i2 = this.r;
                } else {
                    paddingTop2 = getPaddingTop() + ((this.D0 - intrinsicHeight2) / 2);
                    i2 = this.r;
                }
                int i20 = paddingTop2 + i2;
                this.j.setBounds(i19, i20, intrinsicWidth3 + i19, intrinsicHeight2 + i20);
                this.j.draw(canvas);
            }
        }
        if (this.a != null) {
            if (this.H0 || this.I0 || this.M0 > 0) {
                canvas.save();
                canvas.clipRect(0, 0, (getMaxTextWidth() - this.M0) - AbstractC21455b.F((this.j == null || !this.H0) ? 0.0f : 2.0f), getMeasuredHeight());
            }
            if (this.v != null) {
                int i21 = (int) ((this.z0 + i13) - this.y);
                int i22 = this.B0;
                int i23 = i21 + (i22 / 2);
                int iMax = Math.max(i22 + getPaddingLeft() + getPaddingRight(), this.N0);
                int i24 = i23 - (iMax / 2);
                this.v.setBounds(i24, 0, iMax + i24, getMeasuredHeight());
                this.v.draw(canvas);
            }
            if (this.z0 + i13 != 0 || this.A0 != 0 || this.y != 0.0f) {
                canvas.save();
                canvas.translate((this.z0 + i13) - this.y, this.A0);
            }
            e(canvas);
            if (this.d != null && this.t < 1.0f) {
                int alpha = this.e.getAlpha();
                this.e.setAlpha((int) ((1.0f - this.t) * 255.0f));
                canvas.save();
                if (this.d.getText().length() == 1) {
                    F = AbstractC21455b.F(this.S0 == 1 ? 0.5f : 4.0f);
                } else {
                    F = 0.0f;
                }
                if (this.a.getLineLeft(0) != 0.0f) {
                    canvas.translate((-this.a.getLineWidth(0)) + F, 0.0f);
                } else {
                    canvas.translate(this.a.getLineWidth(0) - F, 0.0f);
                }
                float f2 = -this.P0;
                float f3 = this.t;
                canvas.translate((f2 * f3) + (this.Q0 * f3), 0.0f);
                this.d.draw(canvas);
                canvas.restore();
                this.e.setAlpha(alpha);
            }
            if (this.c != null && this.t > 0.0f) {
                int alpha2 = this.e.getAlpha();
                this.e.setAlpha((int) (this.t * 255.0f));
                float f4 = -this.P0;
                float f5 = this.t;
                float f6 = this.Q0;
                canvas.translate(((f4 * f5) + (f5 * f6)) - f6, 0.0f);
                this.c.draw(canvas);
                this.e.setAlpha(alpha2);
            }
            if (this.y != 0.0f) {
                canvas.translate(iF, 0.0f);
                e(canvas);
            }
            if (this.z0 + i13 != 0 || this.A0 != 0 || this.y != 0.0f) {
                canvas.restore();
            }
            if (z) {
                if (this.y < AbstractC21455b.F(10.0f)) {
                    this.B.setAlpha((int) ((this.y / AbstractC21455b.F(10.0f)) * 255.0f));
                } else if (this.y > (this.C0 + AbstractC21455b.F(16.0f)) - AbstractC21455b.F(10.0f)) {
                    this.B.setAlpha((int) ((1.0f - ((this.y - ((this.C0 + AbstractC21455b.F(16.0f)) - AbstractC21455b.F(10.0f))) / AbstractC21455b.F(10.0f))) * 255.0f));
                } else {
                    this.B.setAlpha(255);
                }
                canvas.drawRect(0.0f, 0.0f, AbstractC21455b.F(6.0f), getMeasuredHeight(), this.B);
                canvas.save();
                canvas.translate((getMaxTextWidth() - this.M0) - AbstractC21455b.F(6.0f), 0.0f);
                canvas.drawRect(0.0f, 0.0f, AbstractC21455b.F(6.0f), getMeasuredHeight(), this.D);
                canvas.restore();
            } else if (this.I0 && this.x && this.G != null) {
                canvas.save();
                k();
                if (!this.J0) {
                    canvas.translate(((getMaxTextWidth() - this.M0) - this.H) - AbstractC21455b.F((this.j == null || !this.H0) ? 0.0f : 2.0f), 0.0f);
                }
                canvas.drawRect(0.0f, 0.0f, this.H, getMeasuredHeight(), this.G);
                canvas.restore();
            }
            l();
            if (this.H0 || this.I0 || this.M0 > 0) {
                canvas.restore();
            }
        }
        if (z || this.I0) {
            canvas.restoreToCount(iSaveLayerAlpha);
        }
        if (this.j == null || !this.H0) {
            return;
        }
        int i25 = i13 + this.B0 + this.p;
        float f7 = this.y;
        int iMin = Math.min(i25 + (f7 == 0.0f ? -iF : (int) (-f7)) + iF, (getMaxTextWidth() - this.M0) + this.p);
        int intrinsicWidth4 = (int) (this.j.getIntrinsicWidth() * this.o);
        int intrinsicHeight3 = (int) (this.j.getIntrinsicHeight() * this.o);
        if ((this.f & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 16) {
            paddingTop = (getMeasuredHeight() - intrinsicHeight3) / 2;
            i = this.r;
        } else {
            paddingTop = getPaddingTop() + ((this.D0 - intrinsicHeight3) / 2);
            i = this.r;
        }
        int i26 = paddingTop + i;
        this.j.setBounds(iMin, i26, iMin + intrinsicWidth4, i26 + intrinsicHeight3);
        this.E0 = iMin + (intrinsicWidth4 >> 1);
        this.F0 = i26 + (intrinsicHeight3 >> 1);
        this.j.draw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setVisibleToUser(true);
        accessibilityNodeInfo.setClassName("android.widget.TextView");
        accessibilityNodeInfo.setText(this.h);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.G0 = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        Drawable drawable;
        Drawable drawable2;
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i3 = this.J;
        int i4 = AbstractC21455b.h.x;
        if (i3 != i4) {
            this.J = i4;
            this.y = 0.0f;
            this.A = SIPTransactionStack.BASE_TIMER_INTERVAL;
        }
        int intrinsicWidth = 0;
        d((((size - getPaddingLeft()) - getPaddingRight()) - this.R0) - ((!this.H0 || (drawable2 = this.j) == null) ? 0 : drawable2.getIntrinsicWidth() + this.p));
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            size2 = getPaddingBottom() + getPaddingTop() + this.D0;
        }
        if (this.u) {
            int paddingLeft = getPaddingLeft() + this.B0 + getPaddingRight() + this.R0;
            if (this.H0 && (drawable = this.j) != null) {
                intrinsicWidth = drawable.getIntrinsicWidth() + this.p;
            }
            size = Math.min(size, paddingLeft + intrinsicWidth);
        }
        setMeasuredDimension(size, size2);
        if ((this.f & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 16) {
            this.A0 = getPaddingTop() + ((((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - this.D0) / 2);
        } else {
            this.A0 = getPaddingTop();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Y0 != null && this.j != null) {
            RectF rectF = AbstractC21455b.x;
            rectF.set(this.E0 - AbstractC21455b.F(16.0f), this.F0 - AbstractC21455b.F(16.0f), this.E0 + AbstractC21455b.F(16.0f), this.F0 + AbstractC21455b.F(16.0f));
            if (motionEvent.getAction() == 0 && rectF.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                this.Z0 = true;
                this.a1 = motionEvent.getX();
                this.b1 = motionEvent.getY();
                getParent().requestDisallowInterceptTouchEvent(true);
            } else if (motionEvent.getAction() == 2 && this.Z0) {
                if (Math.abs(motionEvent.getX() - this.a1) >= AbstractC21455b.b.intValue() || Math.abs(motionEvent.getY() - this.b1) >= AbstractC21455b.b.intValue()) {
                    this.Z0 = false;
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (this.Z0 && motionEvent.getAction() == 1) {
                    this.Y0.onClick(this);
                }
                this.Z0 = false;
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.onTouchEvent(motionEvent) || this.Z0;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.g > 1) {
            super.setBackgroundDrawable(drawable);
        } else {
            this.v = drawable;
        }
    }

    public void setDrawablePadding(int i) {
        if (this.p == i) {
            return;
        }
        this.p = i;
        if (g()) {
            return;
        }
        invalidate();
    }

    public void setEllipsizeByGradient(boolean z) {
        setEllipsizeByGradient(z, (Boolean) null);
    }

    public void setGravity(int i) {
        this.f = i;
    }

    public void setLinkTextColor(int i) {
        this.e.linkColor = i;
        invalidate();
    }

    public void setMinWidth(int i) {
        this.N0 = i;
    }

    public void setRightDrawable(Drawable drawable) {
        Drawable drawable2 = this.j;
        if (drawable2 == drawable) {
            return;
        }
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.j = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        if (g()) {
            return;
        }
        invalidate();
    }

    public void setRightDrawableOnClick(View.OnClickListener onClickListener) {
        this.Y0 = onClickListener;
    }

    public void setRightDrawableOutside(boolean z) {
        this.H0 = z;
    }

    public void setRightDrawableTopPadding(int i) {
        this.r = i;
    }

    public void setRightPadding(int i) {
        int intrinsicWidth;
        if (this.M0 != i) {
            this.M0 = i;
            int maxTextWidth = ((getMaxTextWidth() - getPaddingLeft()) - getPaddingRight()) - this.R0;
            Drawable drawable = this.i;
            if (drawable != null) {
                maxTextWidth = (maxTextWidth - drawable.getIntrinsicWidth()) - this.p;
            }
            if (this.j == null || this.H0) {
                intrinsicWidth = 0;
            } else {
                intrinsicWidth = (int) (r0.getIntrinsicWidth() * this.o);
                maxTextWidth = (maxTextWidth - intrinsicWidth) - this.p;
            }
            if (this.l != null && this.k != null) {
                int iIndexOf = this.h.toString().indexOf(this.l);
                this.m = iIndexOf;
                if (iIndexOf < 0) {
                    maxTextWidth = (maxTextWidth - this.k.getIntrinsicWidth()) - this.p;
                }
            }
            if (this.W0 && intrinsicWidth != 0 && !this.H0) {
                if (!this.h.equals(TextUtils.ellipsize(this.h, this.e, maxTextWidth, TextUtils.TruncateAt.END))) {
                    this.X0 = true;
                    maxTextWidth = maxTextWidth + intrinsicWidth + this.p;
                }
            }
            a(maxTextWidth);
            invalidate();
        }
    }

    public void setScrollNonFitText(boolean z) {
        if (this.w == z) {
            return;
        }
        this.w = z;
        k();
        requestLayout();
    }

    public void setSideDrawablesColor(int i) {
        m.d1(this.j, i);
        m.d1(this.i, i);
    }

    public void setTextColor(int i) {
        this.e.setColor(i);
        invalidate();
    }

    public void setTextSize(int i) {
        float F = AbstractC21455b.F(i);
        if (F == this.e.getTextSize()) {
            return;
        }
        this.e.setTextSize(F);
        if (g()) {
            return;
        }
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        this.e.setTypeface(typeface);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.j || drawable == this.i || super.verifyDrawable(drawable);
    }

    public void setEllipsizeByGradient(int i) {
        setEllipsizeByGradient(i, (Boolean) null);
    }

    public void setEllipsizeByGradient(boolean z, Boolean bool) {
        if (this.w == z) {
            return;
        }
        this.I0 = z;
        this.K0 = bool;
        k();
    }

    public void setEllipsizeByGradient(int i, Boolean bool) {
        setEllipsizeByGradient(true, bool);
        this.L0 = i;
        k();
    }
}
