package ir.nasim.tgwidgets.editor.ui.Components;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.SystemClock;
import android.view.View;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC8662Wx6;
import ir.nasim.FH3;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import java.util.Random;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes7.dex */
public class FlickerLoadingView extends View {
    private float A;
    FlickerLoadingView B;
    private boolean D;
    private int a;
    private LinearGradient b;
    private Paint c;
    private Paint d;
    private long e;
    private int f;
    private Matrix g;
    private RectF h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private final m.h v;
    float[] w;
    private Paint x;
    private int y;
    private int z;

    public FlickerLoadingView(Context context) {
        this(context, null);
    }

    private float a(float f) {
        return FH3.D ? getMeasuredWidth() - f : f;
    }

    private void b(RectF rectF) {
        if (FH3.D) {
            rectF.left = getMeasuredWidth() - rectF.left;
            rectF.right = getMeasuredWidth() - rectF.right;
        }
    }

    private int c(int i) {
        switch (getViewType()) {
            case 1:
                return AbstractC21455b.F(78.0f) + 1;
            case 2:
                return ((i - (AbstractC21455b.F(2.0f) * (getColumnsCount() - 1))) / getColumnsCount()) + AbstractC21455b.F(2.0f);
            case 3:
            case 4:
                return AbstractC21455b.F(56.0f);
            case 5:
                return AbstractC21455b.F(80.0f);
            case 6:
            case 18:
                return AbstractC21455b.F(64.0f);
            case 7:
                return AbstractC21455b.F((AbstractC8662Wx6.G0 ? 78 : 72) + 1);
            case 8:
                return AbstractC21455b.F(61.0f);
            case 9:
                return AbstractC21455b.F(66.0f);
            case 10:
                return AbstractC21455b.F(58.0f);
            case 11:
                return AbstractC21455b.F(36.0f);
            case 12:
                return AbstractC21455b.F(103.0f);
            case 13:
            case 14:
            case 16:
            case 17:
            case 20:
            case 23:
            case 27:
            default:
                return 0;
            case 15:
                return AbstractC21455b.F(107.0f);
            case 19:
                return AbstractC21455b.F(58.0f);
            case 21:
                return AbstractC21455b.F(58.0f);
            case 22:
                return AbstractC21455b.F(60.0f);
            case 24:
                return AbstractC21455b.F((AbstractC8662Wx6.G0 ? 76 : 64) + 1);
            case 25:
                return AbstractC21455b.F(51.0f);
            case 26:
                return AbstractC21455b.F(50.0f) + 1;
            case 28:
                return AbstractC21455b.F(58.0f);
        }
    }

    private int d(int i) {
        return ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(i, this.v);
    }

    public void e() {
        int i;
        FlickerLoadingView flickerLoadingView = this.B;
        if (flickerLoadingView != null) {
            flickerLoadingView.e();
            return;
        }
        int iD = d(this.r);
        int iD2 = d(this.s);
        if (this.j == iD2 && this.i == iD) {
            return;
        }
        this.i = iD;
        this.j = iD2;
        if (this.n || (i = this.o) == 13 || i == 14 || i == 17) {
            int iF = AbstractC21455b.F(200.0f);
            this.a = iF;
            this.b = new LinearGradient(0.0f, 0.0f, iF, 0.0f, new int[]{iD2, iD, iD, iD2}, new float[]{0.0f, 0.4f, 0.6f, 1.0f}, Shader.TileMode.CLAMP);
        } else {
            int iF2 = AbstractC21455b.F(600.0f);
            this.a = iF2;
            this.b = new LinearGradient(0.0f, 0.0f, 0.0f, iF2, new int[]{iD2, iD, iD, iD2}, new float[]{0.0f, 0.4f, 0.6f, 1.0f}, Shader.TileMode.CLAMP);
        }
        this.c.setShader(this.b);
    }

    public void f() {
        FlickerLoadingView flickerLoadingView = this.B;
        if (flickerLoadingView != null) {
            flickerLoadingView.f();
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jAbs = Math.abs(this.e - jElapsedRealtime);
        if (jAbs > 17) {
            jAbs = 16;
        }
        if (jAbs < 4) {
            jAbs = 0;
        }
        int measuredWidth = this.y;
        if (measuredWidth == 0) {
            measuredWidth = getMeasuredWidth();
        }
        int measuredHeight = this.z;
        if (measuredHeight == 0) {
            measuredHeight = getMeasuredHeight();
        }
        this.e = jElapsedRealtime;
        if (this.n || this.o == 13 || getViewType() == 14 || getViewType() == 17) {
            int i = (int) (this.f + ((jAbs * measuredWidth) / 400.0f));
            this.f = i;
            if (i >= measuredWidth * 2) {
                this.f = (-this.a) * 2;
            }
            this.g.setTranslate(this.f + this.A, 0.0f);
        } else {
            int i2 = (int) (this.f + ((jAbs * measuredHeight) / 400.0f));
            this.f = i2;
            if (i2 >= measuredHeight * 2) {
                this.f = (-this.a) * 2;
            }
            this.g.setTranslate(this.A, this.f);
        }
        LinearGradient linearGradient = this.b;
        if (linearGradient != null) {
            linearGradient.setLocalMatrix(this.g);
        }
    }

    public int getAdditionalHeight() {
        return 0;
    }

    public int getColumnsCount() {
        return 2;
    }

    public Paint getPaint() {
        return this.c;
    }

    public int getViewType() {
        return this.o;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Paint paint = this.c;
        if (this.B != null) {
            if (getParent() != null) {
                View view = (View) getParent();
                this.B.setParentSize(view.getMeasuredWidth(), view.getMeasuredHeight(), -getX());
            }
            paint = this.B.c;
        }
        Paint paint2 = paint;
        e();
        f();
        int iC = this.p;
        if (this.m) {
            int iF = iC + AbstractC21455b.F(32.0f);
            int i = this.t;
            if (i >= 0) {
                this.d.setColor(d(i));
            }
            canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), AbstractC21455b.F(32.0f), this.t >= 0 ? this.d : paint2);
            iC = iF;
        }
        float f = 28.0f;
        int i2 = 0;
        int i3 = 1;
        if (getViewType() == 7) {
            while (iC <= getMeasuredHeight()) {
                int iC2 = c(getMeasuredWidth());
                canvas.drawCircle(a(AbstractC21455b.F(10.0f) + r3), (iC2 >> i3) + iC, AbstractC21455b.F(f), paint2);
                this.h.set(AbstractC21455b.F(76.0f), AbstractC21455b.F(16.0f) + iC, AbstractC21455b.F(148.0f), iC + AbstractC21455b.F(24.0f));
                b(this.h);
                canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                this.h.set(AbstractC21455b.F(76.0f), AbstractC21455b.F(38.0f) + iC, AbstractC21455b.F(268.0f), AbstractC21455b.F(46.0f) + iC);
                b(this.h);
                canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                if (AbstractC8662Wx6.G0) {
                    this.h.set(AbstractC21455b.F(76.0f), AbstractC21455b.F(54.0f) + iC, AbstractC21455b.F(220.0f), AbstractC21455b.F(62.0f) + iC);
                    b(this.h);
                    canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                }
                if (this.l) {
                    this.h.set(getMeasuredWidth() - AbstractC21455b.F(50.0f), AbstractC21455b.F(16.0f) + iC, getMeasuredWidth() - AbstractC21455b.F(12.0f), AbstractC21455b.F(24.0f) + iC);
                    b(this.h);
                    canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                }
                iC += c(getMeasuredWidth());
                int i4 = i2 + 1;
                if (this.n && i4 >= this.u) {
                    break;
                }
                i2 = i4;
                i3 = 1;
                f = 28.0f;
            }
        } else if (getViewType() == 24) {
            while (iC <= getMeasuredHeight()) {
                canvas.drawCircle(a(AbstractC21455b.F(10.0f) + r2), AbstractC21455b.F(10.0f) + iC + r2, AbstractC21455b.F(14.0f), paint2);
                canvas.save();
                canvas.translate(0.0f, -AbstractC21455b.F(4.0f));
                this.h.set(AbstractC21455b.F(50.0f), AbstractC21455b.F(16.0f) + iC, AbstractC21455b.F(148.0f), AbstractC21455b.F(24.0f) + iC);
                b(this.h);
                canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                this.h.set(AbstractC21455b.F(50.0f), AbstractC21455b.F(38.0f) + iC, AbstractC21455b.F(268.0f), AbstractC21455b.F(46.0f) + iC);
                b(this.h);
                canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                if (AbstractC8662Wx6.G0) {
                    this.h.set(AbstractC21455b.F(50.0f), AbstractC21455b.F(54.0f) + iC, AbstractC21455b.F(220.0f), AbstractC21455b.F(62.0f) + iC);
                    b(this.h);
                    canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                }
                if (this.l) {
                    this.h.set(getMeasuredWidth() - AbstractC21455b.F(50.0f), AbstractC21455b.F(16.0f) + iC, getMeasuredWidth() - AbstractC21455b.F(12.0f), AbstractC21455b.F(24.0f) + iC);
                    b(this.h);
                    canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                }
                canvas.restore();
                iC += c(getMeasuredWidth());
                int i5 = i2 + 1;
                if (this.n && i5 >= this.u) {
                    break;
                } else {
                    i2 = i5;
                }
            }
        } else if (getViewType() == 18) {
            int iC3 = iC;
            while (iC3 <= getMeasuredHeight()) {
                canvas.drawCircle(a(this.q + AbstractC21455b.F(9.0f) + r1), AbstractC21455b.F(32.0f) + iC3, AbstractC21455b.F(25.0f), paint2);
                int i6 = i2 % 2 == 0 ? 52 : 72;
                float f2 = 76;
                this.h.set(AbstractC21455b.F(f2), AbstractC21455b.F(20.0f) + iC3, AbstractC21455b.F(i6 + 76), AbstractC21455b.F(28.0f) + iC3);
                b(this.h);
                canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                this.h.set(AbstractC21455b.F(i6 + 84), AbstractC21455b.F(20.0f) + iC3, AbstractC21455b.F(i6 + 168), AbstractC21455b.F(28.0f) + iC3);
                b(this.h);
                canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                this.h.set(AbstractC21455b.F(f2), AbstractC21455b.F(42.0f) + iC3, AbstractC21455b.F(WKSRecord.Service.EMFIS_DATA), AbstractC21455b.F(50.0f) + iC3);
                b(this.h);
                canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                canvas.drawLine(AbstractC21455b.F(f2), c(getMeasuredWidth()) + iC3, getMeasuredWidth(), c(getMeasuredWidth()) + iC3, paint2);
                iC3 += c(getMeasuredWidth());
                int i7 = i2 + 1;
                if (this.n && i7 >= this.u) {
                    break;
                } else {
                    i2 = i7;
                }
            }
        } else if (getViewType() == 19) {
            int iC4 = iC;
            while (iC4 <= getMeasuredHeight()) {
                canvas.drawCircle(a(this.q + AbstractC21455b.F(9.0f) + r1), AbstractC21455b.F(29.0f) + iC4, AbstractC21455b.F(20.0f), paint2);
                float f3 = 76;
                this.h.set(AbstractC21455b.F(f3), AbstractC21455b.F(16.0f) + iC4, AbstractC21455b.F((i2 % 2 == 0 ? 92 : 128) + 76), AbstractC21455b.F(24.0f) + iC4);
                b(this.h);
                canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                this.h.set(AbstractC21455b.F(f3), AbstractC21455b.F(38.0f) + iC4, AbstractC21455b.F(SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER), AbstractC21455b.F(46.0f) + iC4);
                b(this.h);
                canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                canvas.drawLine(AbstractC21455b.F(f3), c(getMeasuredWidth()) + iC4, getMeasuredWidth(), c(getMeasuredWidth()) + iC4, paint2);
                iC4 += c(getMeasuredWidth());
                int i8 = i2 + 1;
                if (this.n && i8 >= this.u) {
                    break;
                } else {
                    i2 = i8;
                }
            }
        } else if (getViewType() == 1) {
            while (iC <= getMeasuredHeight()) {
                canvas.drawCircle(a(AbstractC21455b.F(9.0f) + r2), (AbstractC21455b.F(78.0f) >> 1) + iC, AbstractC21455b.F(25.0f), paint2);
                this.h.set(AbstractC21455b.F(68.0f), AbstractC21455b.F(20.0f) + iC, AbstractC21455b.F(140.0f), AbstractC21455b.F(28.0f) + iC);
                b(this.h);
                canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                this.h.set(AbstractC21455b.F(68.0f), AbstractC21455b.F(42.0f) + iC, AbstractC21455b.F(260.0f), AbstractC21455b.F(50.0f) + iC);
                b(this.h);
                canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                if (this.l) {
                    this.h.set(getMeasuredWidth() - AbstractC21455b.F(50.0f), AbstractC21455b.F(20.0f) + iC, getMeasuredWidth() - AbstractC21455b.F(12.0f), AbstractC21455b.F(28.0f) + iC);
                    b(this.h);
                    canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                }
                iC += c(getMeasuredWidth());
                int i9 = i2 + 1;
                if (this.n && i9 >= this.u) {
                    break;
                } else {
                    i2 = i9;
                }
            }
        } else {
            int i10 = 2;
            if (getViewType() == 2 || getViewType() == 27) {
                int measuredWidth = (getMeasuredWidth() - (AbstractC21455b.F(2.0f) * (getColumnsCount() - 1))) / getColumnsCount();
                int i11 = getViewType() == 27 ? (int) (measuredWidth * 1.25f) : measuredWidth;
                int iF2 = iC;
                int i12 = 0;
                while (true) {
                    if (iF2 >= getMeasuredHeight() && !this.n) {
                        break;
                    }
                    for (int i13 = 0; i13 < getColumnsCount(); i13++) {
                        if (i12 != 0 || i13 >= this.k) {
                            canvas.drawRect((AbstractC21455b.F(2.0f) + measuredWidth) * i13, iF2, r1 + measuredWidth, iF2 + i11, paint2);
                        }
                    }
                    iF2 += AbstractC21455b.F(2.0f) + i11;
                    i12++;
                    if (this.n && i12 >= 2) {
                        break;
                    }
                }
            } else if (getViewType() == 3) {
                while (iC <= getMeasuredHeight()) {
                    this.h.set(AbstractC21455b.F(12.0f), AbstractC21455b.F(8.0f) + iC, AbstractC21455b.F(52.0f), AbstractC21455b.F(48.0f) + iC);
                    b(this.h);
                    canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                    this.h.set(AbstractC21455b.F(68.0f), AbstractC21455b.F(12.0f) + iC, AbstractC21455b.F(140.0f), AbstractC21455b.F(20.0f) + iC);
                    b(this.h);
                    canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                    this.h.set(AbstractC21455b.F(68.0f), AbstractC21455b.F(34.0f) + iC, AbstractC21455b.F(260.0f), AbstractC21455b.F(42.0f) + iC);
                    b(this.h);
                    canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                    if (this.l) {
                        this.h.set(getMeasuredWidth() - AbstractC21455b.F(50.0f), AbstractC21455b.F(12.0f) + iC, getMeasuredWidth() - AbstractC21455b.F(12.0f), AbstractC21455b.F(20.0f) + iC);
                        b(this.h);
                        canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                    }
                    iC += c(getMeasuredWidth());
                    int i14 = i2 + 1;
                    if (this.n && i14 >= this.u) {
                        break;
                    } else {
                        i2 = i14;
                    }
                }
            } else if (getViewType() == 4) {
                while (iC <= getMeasuredHeight()) {
                    canvas.drawCircle(a(AbstractC21455b.F(12.0f) + r2), AbstractC21455b.F(6.0f) + iC + r2, AbstractC21455b.F(44.0f) >> 1, paint2);
                    this.h.set(AbstractC21455b.F(68.0f), AbstractC21455b.F(12.0f) + iC, AbstractC21455b.F(140.0f), AbstractC21455b.F(20.0f) + iC);
                    b(this.h);
                    canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                    this.h.set(AbstractC21455b.F(68.0f), AbstractC21455b.F(34.0f) + iC, AbstractC21455b.F(260.0f), AbstractC21455b.F(42.0f) + iC);
                    b(this.h);
                    canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                    if (this.l) {
                        this.h.set(getMeasuredWidth() - AbstractC21455b.F(50.0f), AbstractC21455b.F(12.0f) + iC, getMeasuredWidth() - AbstractC21455b.F(12.0f), AbstractC21455b.F(20.0f) + iC);
                        b(this.h);
                        canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                    }
                    iC += c(getMeasuredWidth());
                    int i15 = i2 + 1;
                    if (this.n && i15 >= this.u) {
                        break;
                    } else {
                        i2 = i15;
                    }
                }
            } else if (getViewType() == 5) {
                while (iC <= getMeasuredHeight()) {
                    this.h.set(AbstractC21455b.F(10.0f), AbstractC21455b.F(11.0f) + iC, AbstractC21455b.F(62.0f), AbstractC21455b.F(63.0f) + iC);
                    b(this.h);
                    canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                    this.h.set(AbstractC21455b.F(68.0f), AbstractC21455b.F(12.0f) + iC, AbstractC21455b.F(140.0f), AbstractC21455b.F(20.0f) + iC);
                    b(this.h);
                    canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                    this.h.set(AbstractC21455b.F(68.0f), AbstractC21455b.F(34.0f) + iC, AbstractC21455b.F(268.0f), AbstractC21455b.F(42.0f) + iC);
                    b(this.h);
                    canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                    this.h.set(AbstractC21455b.F(68.0f), AbstractC21455b.F(54.0f) + iC, AbstractC21455b.F(188.0f), AbstractC21455b.F(62.0f) + iC);
                    b(this.h);
                    canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                    if (this.l) {
                        this.h.set(getMeasuredWidth() - AbstractC21455b.F(50.0f), AbstractC21455b.F(12.0f) + iC, getMeasuredWidth() - AbstractC21455b.F(12.0f), AbstractC21455b.F(20.0f) + iC);
                        b(this.h);
                        canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                    }
                    iC += c(getMeasuredWidth());
                    int i16 = i2 + 1;
                    if (this.n && i16 >= this.u) {
                        break;
                    } else {
                        i2 = i16;
                    }
                }
            } else if (getViewType() == 6 || getViewType() == 10) {
                while (iC <= getMeasuredHeight()) {
                    canvas.drawCircle(a(this.q + AbstractC21455b.F(9.0f) + r2), (AbstractC21455b.F(64.0f) >> 1) + iC, AbstractC21455b.F(23.0f), paint2);
                    this.h.set(this.q + AbstractC21455b.F(68.0f), AbstractC21455b.F(17.0f) + iC, this.q + AbstractC21455b.F(260.0f), AbstractC21455b.F(25.0f) + iC);
                    b(this.h);
                    canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                    this.h.set(this.q + AbstractC21455b.F(68.0f), AbstractC21455b.F(39.0f) + iC, this.q + AbstractC21455b.F(140.0f), AbstractC21455b.F(47.0f) + iC);
                    b(this.h);
                    canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                    if (this.l) {
                        this.h.set(getMeasuredWidth() - AbstractC21455b.F(50.0f), AbstractC21455b.F(20.0f) + iC, getMeasuredWidth() - AbstractC21455b.F(12.0f), AbstractC21455b.F(28.0f) + iC);
                        b(this.h);
                        canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                    }
                    iC += c(getMeasuredWidth());
                    int i17 = i2 + 1;
                    if (this.n && i17 >= this.u) {
                        break;
                    } else {
                        i2 = i17;
                    }
                }
            } else if (getViewType() == 8) {
                while (iC <= getMeasuredHeight()) {
                    canvas.drawCircle(a(this.q + AbstractC21455b.F(11.0f) + r2), (AbstractC21455b.F(64.0f) >> 1) + iC, AbstractC21455b.F(23.0f), paint2);
                    this.h.set(this.q + AbstractC21455b.F(68.0f), AbstractC21455b.F(17.0f) + iC, this.q + AbstractC21455b.F(140.0f), AbstractC21455b.F(25.0f) + iC);
                    b(this.h);
                    canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                    this.h.set(this.q + AbstractC21455b.F(68.0f), AbstractC21455b.F(39.0f) + iC, this.q + AbstractC21455b.F(260.0f), AbstractC21455b.F(47.0f) + iC);
                    b(this.h);
                    canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                    if (this.l) {
                        this.h.set(getMeasuredWidth() - AbstractC21455b.F(50.0f), AbstractC21455b.F(20.0f) + iC, getMeasuredWidth() - AbstractC21455b.F(12.0f), AbstractC21455b.F(28.0f) + iC);
                        b(this.h);
                        canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                    }
                    iC += c(getMeasuredWidth());
                    int i18 = i2 + 1;
                    if (this.n && i18 >= this.u) {
                        break;
                    } else {
                        i2 = i18;
                    }
                }
            } else if (getViewType() == 9) {
                while (iC <= getMeasuredHeight()) {
                    canvas.drawCircle(a(AbstractC21455b.F(35.0f)), (c(getMeasuredWidth()) >> 1) + iC, AbstractC21455b.F(32.0f) / i10, paint2);
                    this.h.set(AbstractC21455b.F(72.0f), AbstractC21455b.F(16.0f) + iC, AbstractC21455b.F(268.0f), iC + AbstractC21455b.F(24.0f));
                    b(this.h);
                    canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                    this.h.set(AbstractC21455b.F(72.0f), AbstractC21455b.F(38.0f) + iC, AbstractC21455b.F(140.0f), AbstractC21455b.F(46.0f) + iC);
                    b(this.h);
                    canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                    if (this.l) {
                        this.h.set(getMeasuredWidth() - AbstractC21455b.F(50.0f), AbstractC21455b.F(16.0f) + iC, getMeasuredWidth() - AbstractC21455b.F(12.0f), AbstractC21455b.F(24.0f) + iC);
                        b(this.h);
                        canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                    }
                    iC += c(getMeasuredWidth());
                    int i19 = i2 + 1;
                    if (this.n && i19 >= this.u) {
                        break;
                    }
                    i2 = i19;
                    i10 = 2;
                }
            } else if (getViewType() == 11) {
                int i20 = 0;
                while (iC <= getMeasuredHeight()) {
                    this.h.set(AbstractC21455b.F(18.0f), AbstractC21455b.F(14.0f), (getMeasuredWidth() * 0.5f) + AbstractC21455b.F(this.w[0] * 40.0f), AbstractC21455b.F(14.0f) + AbstractC21455b.F(8.0f));
                    b(this.h);
                    canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                    this.h.set(getMeasuredWidth() - AbstractC21455b.F(18.0f), AbstractC21455b.F(14.0f), (getMeasuredWidth() - (getMeasuredWidth() * 0.2f)) - AbstractC21455b.F(this.w[0] * 20.0f), AbstractC21455b.F(14.0f) + AbstractC21455b.F(8.0f));
                    b(this.h);
                    canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                    iC += c(getMeasuredWidth());
                    i20++;
                    if (this.n && i20 >= this.u) {
                        break;
                    }
                }
            } else if (getViewType() == 12) {
                int iF3 = iC + AbstractC21455b.F(14.0f);
                while (iF3 <= getMeasuredHeight()) {
                    int measuredWidth2 = getMeasuredWidth() / 4;
                    for (int i21 = 0; i21 < 4; i21++) {
                        float f4 = (measuredWidth2 * i21) + (measuredWidth2 / 2.0f);
                        canvas.drawCircle(f4, AbstractC21455b.F(7.0f) + iF3 + (AbstractC21455b.F(56.0f) / 2.0f), AbstractC21455b.F(28.0f), paint2);
                        float F = AbstractC21455b.F(7.0f) + iF3 + AbstractC21455b.F(56.0f) + AbstractC21455b.F(16.0f);
                        RectF rectF = AbstractC21455b.x;
                        rectF.set(f4 - AbstractC21455b.F(24.0f), F - AbstractC21455b.F(4.0f), f4 + AbstractC21455b.F(24.0f), F + AbstractC21455b.F(4.0f));
                        canvas.drawRoundRect(rectF, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                    }
                    iF3 += c(getMeasuredWidth());
                    if (this.n) {
                        break;
                    }
                }
            } else if (getViewType() == 13) {
                float measuredHeight = getMeasuredHeight() / 2.0f;
                RectF rectF2 = AbstractC21455b.x;
                rectF2.set(AbstractC21455b.F(40.0f), measuredHeight - AbstractC21455b.F(4.0f), getMeasuredWidth() - AbstractC21455b.F(120.0f), AbstractC21455b.F(4.0f) + measuredHeight);
                canvas.drawRoundRect(rectF2, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                if (this.x == null) {
                    Paint paint3 = new Paint(1);
                    this.x = paint3;
                    paint3.setColor(ir.nasim.tgwidgets.editor.ui.ActionBar.m.i0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.n7));
                }
                for (int i22 = 0; i22 < 3; i22++) {
                    canvas.drawCircle((getMeasuredWidth() - AbstractC21455b.F(56.0f)) + AbstractC21455b.F(13.0f) + (AbstractC21455b.F(12.0f) * i22), measuredHeight, AbstractC21455b.F(13.0f), this.x);
                    canvas.drawCircle((getMeasuredWidth() - AbstractC21455b.F(56.0f)) + AbstractC21455b.F(13.0f) + (AbstractC21455b.F(12.0f) * i22), measuredHeight, AbstractC21455b.F(12.0f), paint2);
                }
            } else if (getViewType() == 14 || getViewType() == 17) {
                int iF4 = AbstractC21455b.F(12.0f);
                int iF5 = AbstractC21455b.F(77.0f);
                int iF6 = AbstractC21455b.F(4.0f);
                float F2 = AbstractC21455b.F(21.0f);
                float F3 = AbstractC21455b.F(41.0f);
                while (iF4 < getMeasuredWidth()) {
                    if (this.x == null) {
                        this.x = new Paint(1);
                    }
                    this.x.setColor(ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.T3, this.v));
                    RectF rectF3 = AbstractC21455b.x;
                    int i23 = iF4 + iF5;
                    rectF3.set(AbstractC21455b.F(4.0f) + iF4, AbstractC21455b.F(4.0f), i23 - AbstractC21455b.F(4.0f), getMeasuredHeight() - AbstractC21455b.F(4.0f));
                    canvas.drawRoundRect(rectF3, AbstractC21455b.F(6.0f), AbstractC21455b.F(6.0f), paint2);
                    if (getViewType() == 14) {
                        float F4 = AbstractC21455b.F(8.0f) + iF6;
                        float f5 = iF4;
                        float F5 = AbstractC21455b.F(22.0f) + iF6 + f5;
                        this.h.set(F5, F4, F5 + F3, F4 + F2);
                        RectF rectF4 = this.h;
                        canvas.drawRoundRect(rectF4, rectF4.height() * 0.5f, this.h.height() * 0.5f, this.x);
                        float F6 = F4 + AbstractC21455b.F(4.0f) + F2;
                        float F7 = f5 + AbstractC21455b.F(5.0f) + iF6;
                        this.h.set(F7, F6, F7 + F3, F6 + F2);
                        RectF rectF5 = this.h;
                        canvas.drawRoundRect(rectF5, rectF5.height() * 0.5f, this.h.height() * 0.5f, this.x);
                    } else if (getViewType() == 17) {
                        float F8 = AbstractC21455b.F(5.0f);
                        float F9 = AbstractC21455b.F(32.0f);
                        float f6 = iF4 + ((iF5 - F9) / 2.0f);
                        rectF3.set(f6, AbstractC21455b.F(21.0f), F9 + f6, r15 + AbstractC21455b.F(32.0f));
                        canvas.drawRoundRect(rectF3, F8, F8, this.x);
                    }
                    canvas.drawCircle(iF4 + (iF5 / 2), getMeasuredHeight() - AbstractC21455b.F(20.0f), AbstractC21455b.F(8.0f), this.x);
                    iF4 = i23;
                }
            } else if (getViewType() == 15) {
                int iF7 = AbstractC21455b.F(23.0f);
                int iF8 = AbstractC21455b.F(4.0f);
                while (iC <= getMeasuredHeight()) {
                    float f7 = iF7;
                    canvas.drawCircle(a(this.q + AbstractC21455b.F(12.0f)) + f7, AbstractC21455b.F(8.0f) + iC + iF7, f7, paint2);
                    this.h.set(this.q + AbstractC21455b.F(74.0f), AbstractC21455b.F(12.0f) + iC, this.q + AbstractC21455b.F(260.0f), AbstractC21455b.F(20.0f) + iC);
                    b(this.h);
                    float f8 = iF8;
                    canvas.drawRoundRect(this.h, f8, f8, paint2);
                    this.h.set(this.q + AbstractC21455b.F(74.0f), AbstractC21455b.F(36.0f) + iC, this.q + AbstractC21455b.F(140.0f), AbstractC21455b.F(42.0f) + iC);
                    b(this.h);
                    canvas.drawRoundRect(this.h, f8, f8, paint2);
                    iC += c(getMeasuredWidth());
                    int i24 = i2 + 1;
                    if (this.n && i24 >= this.u) {
                        break;
                    } else {
                        i2 = i24;
                    }
                }
            } else if (getViewType() == 16 || getViewType() == 23) {
                int i25 = 0;
                while (iC <= getMeasuredHeight()) {
                    canvas.drawCircle(a(this.q + AbstractC21455b.F(8.0f) + r3), AbstractC21455b.F(24.0f) + iC, AbstractC21455b.F(18.0f), paint2);
                    this.h.set(this.q + AbstractC21455b.F(58.0f), AbstractC21455b.F(20.0f) + iC, getWidth() - AbstractC21455b.F(53.0f), AbstractC21455b.F(28.0f) + iC);
                    b(this.h);
                    canvas.drawRoundRect(this.h, AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f), paint2);
                    if (i25 < 4) {
                        canvas.drawCircle(a((getWidth() - AbstractC21455b.F(12.0f)) - r3), AbstractC21455b.F(24.0f) + iC, AbstractC21455b.F(12.0f), paint2);
                    }
                    iC += c(getMeasuredWidth());
                    i25++;
                    if (this.n && i25 >= this.u) {
                        break;
                    }
                }
                this.h.set(this.q + AbstractC21455b.F(8.0f), AbstractC21455b.F(20.0f) + iC, getWidth() - AbstractC21455b.F(8.0f), AbstractC21455b.F(28.0f) + iC);
                b(this.h);
                canvas.drawRoundRect(this.h, AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f), paint2);
                this.h.set(this.q + AbstractC21455b.F(8.0f), AbstractC21455b.F(36.0f) + iC, getWidth() - AbstractC21455b.F(53.0f), iC + AbstractC21455b.F(44.0f));
                b(this.h);
                canvas.drawRoundRect(this.h, AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f), paint2);
            } else {
                int i26 = this.o;
                if (i26 == 21) {
                    while (iC <= getMeasuredHeight()) {
                        canvas.drawCircle(a(AbstractC21455b.F(20.0f) + r2), (AbstractC21455b.F(58.0f) >> 1) + iC, AbstractC21455b.F(46.0f) >> 1, paint2);
                        this.h.set(AbstractC21455b.F(74.0f), AbstractC21455b.F(16.0f) + iC, AbstractC21455b.F(140.0f), AbstractC21455b.F(24.0f) + iC);
                        b(this.h);
                        canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                        this.h.set(AbstractC21455b.F(74.0f), AbstractC21455b.F(38.0f) + iC, AbstractC21455b.F(260.0f), AbstractC21455b.F(46.0f) + iC);
                        b(this.h);
                        canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                        iC += c(getMeasuredWidth());
                        int i27 = i2 + 1;
                        if (this.n && i27 >= this.u) {
                            break;
                        } else {
                            i2 = i27;
                        }
                    }
                } else if (i26 == 22) {
                    while (iC <= getMeasuredHeight()) {
                        canvas.drawCircle(a(AbstractC21455b.F(20.0f) + r2), AbstractC21455b.F(6.0f) + iC + r2, AbstractC21455b.F(48.0f) >> 1, paint2);
                        this.h.set(AbstractC21455b.F(76.0f), AbstractC21455b.F(16.0f) + iC, AbstractC21455b.F(140.0f), AbstractC21455b.F(24.0f) + iC);
                        b(this.h);
                        canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                        this.h.set(AbstractC21455b.F(76.0f), AbstractC21455b.F(38.0f) + iC, AbstractC21455b.F(260.0f), AbstractC21455b.F(46.0f) + iC);
                        b(this.h);
                        canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                        iC += c(getMeasuredWidth());
                        int i28 = i2 + 1;
                        if (this.n && i28 >= this.u) {
                            break;
                        } else {
                            i2 = i28;
                        }
                    }
                } else if (i26 == 25) {
                    while (iC <= getMeasuredHeight()) {
                        canvas.drawCircle(AbstractC21455b.F(17.0f) + r2, AbstractC21455b.F(6.0f) + iC + r2, AbstractC21455b.F(38.0f) >> 1, paint2);
                        this.h.set(AbstractC21455b.F(76.0f), AbstractC21455b.F(21.0f) + iC, AbstractC21455b.F(220.0f), AbstractC21455b.F(29.0f) + iC);
                        canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                        iC += c(getMeasuredWidth());
                        int i29 = i2 + 1;
                        if (this.n && i29 >= this.u) {
                            break;
                        } else {
                            i2 = i29;
                        }
                    }
                } else if (i26 == 26) {
                    while (iC <= getMeasuredHeight()) {
                        canvas.drawCircle(FH3.D ? (getMeasuredWidth() - AbstractC21455b.F(21.0f)) - r2 : AbstractC21455b.F(21.0f) + r2, AbstractC21455b.F(16.0f) + iC + r2, AbstractC21455b.F(21.0f) >> 1, paint2);
                        this.h.set(AbstractC21455b.F(60.0f), AbstractC21455b.F(21.0f) + iC, AbstractC21455b.F(190.0f), AbstractC21455b.F(29.0f) + iC);
                        b(this.h);
                        canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                        this.h.set(getMeasuredWidth() - AbstractC21455b.F(16.0f), AbstractC21455b.F(21.0f) + iC, getMeasuredWidth() - AbstractC21455b.F(62.0f), AbstractC21455b.F(29.0f) + iC);
                        b(this.h);
                        canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                        iC += c(getMeasuredWidth());
                        int i30 = i2 + 1;
                        if (this.n && i30 >= this.u) {
                            break;
                        } else {
                            i2 = i30;
                        }
                    }
                } else if (getViewType() == 28) {
                    while (iC <= getMeasuredHeight()) {
                        canvas.drawCircle(a(this.q + AbstractC21455b.F(10.0f) + r2), (AbstractC21455b.F(58.0f) >> 1) + iC, AbstractC21455b.F(24.0f), paint2);
                        this.h.set(this.q + AbstractC21455b.F(68.0f), AbstractC21455b.F(17.0f) + iC, this.q + AbstractC21455b.F(260.0f), AbstractC21455b.F(25.0f) + iC);
                        b(this.h);
                        canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                        this.h.set(this.q + AbstractC21455b.F(68.0f), AbstractC21455b.F(39.0f) + iC, this.q + AbstractC21455b.F(140.0f), AbstractC21455b.F(47.0f) + iC);
                        b(this.h);
                        canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                        if (this.l) {
                            this.h.set(getMeasuredWidth() - AbstractC21455b.F(50.0f), AbstractC21455b.F(20.0f) + iC, getMeasuredWidth() - AbstractC21455b.F(12.0f), AbstractC21455b.F(28.0f) + iC);
                            b(this.h);
                            canvas.drawRoundRect(this.h, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), paint2);
                        }
                        iC += c(getMeasuredWidth());
                        int i31 = i2 + 1;
                        if (this.n && i31 >= this.u) {
                            break;
                        } else {
                            i2 = i31;
                        }
                    }
                }
            }
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (!this.n) {
            super.onMeasure(i, i2);
            return;
        }
        int i3 = this.u;
        if (i3 > 1 && this.D) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec((c(View.MeasureSpec.getSize(i)) * this.u) + getAdditionalHeight(), 1073741824));
        } else if (i3 <= 1 || View.MeasureSpec.getSize(i2) <= 0) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(c(View.MeasureSpec.getSize(i)) + getAdditionalHeight(), 1073741824));
        } else {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i2), c(View.MeasureSpec.getSize(i)) * this.u) + getAdditionalHeight(), 1073741824));
        }
    }

    public void setColors(int i, int i2, int i3) {
        this.r = i;
        this.s = i2;
        this.t = i3;
        invalidate();
    }

    public void setGlobalGradientView(FlickerLoadingView flickerLoadingView) {
        this.B = flickerLoadingView;
    }

    public void setIgnoreHeightCheck(boolean z) {
        this.D = z;
    }

    public void setIsSingleCell(boolean z) {
        this.n = z;
    }

    public void setItemsCount(int i) {
        this.u = i;
    }

    public void setPaddingLeft(int i) {
        this.q = i;
        invalidate();
    }

    public void setPaddingTop(int i) {
        this.p = i;
        invalidate();
    }

    public void setParentSize(int i, int i2, float f) {
        this.y = i;
        this.z = i2;
        this.A = f;
    }

    public void setUseHeaderOffset(boolean z) {
        this.m = z;
    }

    public void setViewType(int i) {
        this.o = i;
        if (i == 11) {
            Random random = new Random();
            this.w = new float[2];
            for (int i2 = 0; i2 < 2; i2++) {
                this.w[i2] = Math.abs(random.nextInt() % AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT) / 1000.0f;
            }
        }
        invalidate();
    }

    public FlickerLoadingView(Context context, m.h hVar) {
        super(context);
        this.c = new Paint();
        this.d = new Paint();
        this.h = new RectF();
        this.l = true;
        this.r = ir.nasim.tgwidgets.editor.ui.ActionBar.m.n7;
        this.s = ir.nasim.tgwidgets.editor.ui.ActionBar.m.S4;
        this.u = 1;
        this.v = hVar;
        this.g = new Matrix();
    }
}
