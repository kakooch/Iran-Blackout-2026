package ir.nasim;

import android.app.Dialog;
import android.gov.nist.core.Separators;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.features.pfm.persiandate.view.PersianDatePicker;
import java.text.ParseException;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\rJ)\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u0003J\u0019\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\"\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u000fH\u0017¢\u0006\u0004\b\"\u0010#J\u0019\u0010$\u001a\u00020\u001f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0004H\u0016¢\u0006\u0004\b&\u0010\u0003R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b(\u0010)R\"\u00102\u001a\u00020+8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00106\u001a\u00020+8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b3\u0010-\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R\"\u0010>\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R*\u0010G\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001b\u0010M\u001a\u00020H8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u0017\u0010\u0017\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\"\u0010U\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u00109\u001a\u0004\bS\u0010;\"\u0004\bT\u0010=R\"\u0010Y\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u00109\u001a\u0004\bW\u0010;\"\u0004\bX\u0010=R\"\u0010]\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u00109\u001a\u0004\b[\u0010;\"\u0004\b\\\u0010=R\"\u0010a\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u00109\u001a\u0004\b_\u0010;\"\u0004\b`\u0010=R\u0018\u0010e\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0014\u0010i\u001a\u00020f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0014\u0010m\u001a\u00020j8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u0014\u0010q\u001a\u00020n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010pR(\u0010z\u001a\b\u0012\u0004\u0012\u00020s0r8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u0016\u0010}\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u0015\u0010\u0080\u0001\u001a\u00020b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b~\u0010\u007f¨\u0006\u0081\u0001"}, d2 = {"Lir/nasim/dR4;", "Lcom/google/android/material/bottomsheet/b;", "<init>", "()V", "Lir/nasim/rB7;", "i9", "j9", "r9", "u9", "h9", "o9", "", "f9", "()Z", "e9", "", "newYear", "newMonth", "newDay", "", "b9", "(III)Ljava/lang/String;", "Lir/nasim/D45;", "persianDate", "c9", "(Lir/nasim/D45;)Ljava/lang/String;", "g9", "Landroid/os/Bundle;", "savedInstanceState", "M6", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "dialog", "style", "J8", "(Landroid/app/Dialog;I)V", "B8", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "R6", "Lcom/google/android/material/bottomsheet/a;", "n1", "Lcom/google/android/material/bottomsheet/a;", "bottomSheetDialog", "Lir/nasim/jA1;", "o1", "Lir/nasim/jA1;", "Y8", "()Lir/nasim/jA1;", "l9", "(Lir/nasim/jA1;)V", "dateFilterType", "p1", "Z8", "m9", "oldDateFilterType", "", "q1", "J", "getStartDateConfig", "()J", "setStartDateConfig", "(J)V", "startDateConfig", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/widget/FrameLayout;", "r1", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "getBottomSheetBehavior", "()Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "setBottomSheetBehavior", "(Lcom/google/android/material/bottomsheet/BottomSheetBehavior;)V", "bottomSheetBehavior", "Lir/nasim/features/pfm/h;", "s1", "Lir/nasim/Yu3;", "d9", "()Lir/nasim/features/pfm/h;", "viewModel", "t1", "Lir/nasim/D45;", "getPersianDate", "()Lir/nasim/D45;", "u1", "getFromTimeTimeStamp", "setFromTimeTimeStamp", "fromTimeTimeStamp", "v1", "getToTimeTimeStamp", "setToTimeTimeStamp", "toTimeTimeStamp", "w1", "getOldFromTimeTimeStamp", "setOldFromTimeTimeStamp", "oldFromTimeTimeStamp", "x1", "getOldToTimeTimeStamp", "setOldToTimeTimeStamp", "oldToTimeTimeStamp", "Lir/nasim/Yy2;", "y1", "Lir/nasim/Yy2;", "_binding", "Landroid/graphics/drawable/shapes/RoundRectShape;", "z1", "Landroid/graphics/drawable/shapes/RoundRectShape;", "topRoundRectShape", "Landroid/graphics/drawable/shapes/RectShape;", "A1", "Landroid/graphics/drawable/shapes/RectShape;", "rectShape", "Landroid/graphics/drawable/ShapeDrawable;", "B1", "Landroid/graphics/drawable/ShapeDrawable;", "backGroundDrawable", "", "Landroid/widget/RadioButton;", "C1", "Ljava/util/List;", "a9", "()Ljava/util/List;", "n9", "(Ljava/util/List;)V", "radioButtons", "D1", "Z", "timeError", "X8", "()Lir/nasim/Yy2;", "binding", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.dR4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C11690dR4 extends com.google.android.material.bottomsheet.b {

    /* renamed from: C1, reason: from kotlin metadata */
    public List radioButtons;

    /* renamed from: D1, reason: from kotlin metadata */
    private boolean timeError;

    /* renamed from: n1, reason: from kotlin metadata */
    private com.google.android.material.bottomsheet.a bottomSheetDialog;

    /* renamed from: o1, reason: from kotlin metadata */
    public EnumC15195jA1 dateFilterType;

    /* renamed from: p1, reason: from kotlin metadata */
    public EnumC15195jA1 oldDateFilterType;

    /* renamed from: r1, reason: from kotlin metadata */
    private BottomSheetBehavior bottomSheetBehavior;

    /* renamed from: y1, reason: from kotlin metadata */
    private C9208Yy2 _binding;

    /* renamed from: q1, reason: from kotlin metadata */
    private long startDateConfig = -1;

    /* renamed from: s1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.WQ4
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C11690dR4.w9(this.a);
        }
    });

    /* renamed from: t1, reason: from kotlin metadata */
    private final D45 persianDate = new D45();

    /* renamed from: u1, reason: from kotlin metadata */
    private long fromTimeTimeStamp = AbstractC15360jS4.a(new D45());

    /* renamed from: v1, reason: from kotlin metadata */
    private long toTimeTimeStamp = AbstractC15360jS4.b(new D45());

    /* renamed from: w1, reason: from kotlin metadata */
    private long oldFromTimeTimeStamp = AbstractC15360jS4.a(new D45());

    /* renamed from: x1, reason: from kotlin metadata */
    private long oldToTimeTimeStamp = AbstractC15360jS4.b(new D45());

    /* renamed from: z1, reason: from kotlin metadata */
    private final RoundRectShape topRoundRectShape = new RoundRectShape(new float[]{AbstractC8943Xx1.c(12), AbstractC8943Xx1.c(12), AbstractC8943Xx1.c(12), AbstractC8943Xx1.c(12), AbstractC8943Xx1.c(0), AbstractC8943Xx1.c(0), AbstractC8943Xx1.c(0), AbstractC8943Xx1.c(0)}, null, null);

    /* renamed from: A1, reason: from kotlin metadata */
    private final RectShape rectShape = new RectShape();

    /* renamed from: B1, reason: from kotlin metadata */
    private final ShapeDrawable backGroundDrawable = new ShapeDrawable();

    /* renamed from: ir.nasim.dR4$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC15195jA1.values().length];
            try {
                iArr[EnumC15195jA1.e.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC15195jA1.a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC15195jA1.b.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC15195jA1.c.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnumC15195jA1.d.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
        }
    }

    private final C9208Yy2 X8() {
        C9208Yy2 c9208Yy2 = this._binding;
        AbstractC13042fc3.f(c9208Yy2);
        return c9208Yy2;
    }

    private final String b9(int newYear, int newMonth, int newDay) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(AbstractC16613la3.a(newYear));
        stringBuffer.append(Separators.SLASH);
        stringBuffer.append(AbstractC16613la3.a(newMonth));
        stringBuffer.append(Separators.SLASH);
        stringBuffer.append(AbstractC16613la3.a(newDay));
        return XY6.e(stringBuffer.toString());
    }

    private final String c9(D45 persianDate) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(h6(AbstractC12217eE5.pfm_transactions_are_available_from));
        stringBuffer.append(Separators.SP);
        stringBuffer.append(persianDate.A());
        stringBuffer.append(Separators.SP);
        stringBuffer.append(persianDate.M());
        stringBuffer.append(Separators.SP);
        stringBuffer.append(persianDate.C());
        stringBuffer.append(Separators.SP);
        stringBuffer.append(h6(AbstractC12217eE5.pfm_transactions_are_available));
        return XY6.e(stringBuffer.toString());
    }

    private final ir.nasim.features.pfm.h d9() {
        return (ir.nasim.features.pfm.h) this.viewModel.getValue();
    }

    private final boolean e9() {
        long j = this.fromTimeTimeStamp;
        long j2 = this.startDateConfig;
        boolean z = true;
        if (j < j2) {
            X8().g.setText(c9(new D45(Long.valueOf(j2))));
            TextView textView = X8().g;
            AbstractC13042fc3.h(textView, "fromTimeErrorTv");
            textView.setVisibility(0);
            X8().j.setTextColor(C5495Jo7.a.J0());
        } else if (j > this.toTimeTimeStamp) {
            X8().g.setText(h6(AbstractC12217eE5.from_time_not_after_to_time));
            TextView textView2 = X8().g;
            AbstractC13042fc3.h(textView2, "fromTimeErrorTv");
            textView2.setVisibility(0);
            X8().j.setTextColor(C5495Jo7.a.J0());
        } else if (j >= D45.X().E().longValue()) {
            X8().g.setText(h6(AbstractC12217eE5.from_time_not_after_today));
            TextView textView3 = X8().g;
            AbstractC13042fc3.h(textView3, "fromTimeErrorTv");
            textView3.setVisibility(0);
            X8().j.setTextColor(C5495Jo7.a.J0());
        } else {
            TextView textView4 = X8().g;
            AbstractC13042fc3.h(textView4, "fromTimeErrorTv");
            textView4.setVisibility(8);
            X8().j.setTextColor(C5495Jo7.a.g1());
            z = false;
        }
        this.timeError = z;
        g9();
        return this.timeError;
    }

    private final boolean f9() {
        boolean z = false;
        if (this.toTimeTimeStamp < this.fromTimeTimeStamp) {
            X8().q.setText(h6(AbstractC12217eE5.to_time_not_befor_from_time));
            TextView textView = X8().q;
            AbstractC13042fc3.h(textView, "toTimeErrorTv");
            textView.setVisibility(0);
            X8().t.setTextColor(C5495Jo7.a.J0());
            z = true;
        } else {
            TextView textView2 = X8().q;
            AbstractC13042fc3.h(textView2, "toTimeErrorTv");
            textView2.setVisibility(8);
            X8().t.setTextColor(C5495Jo7.a.g1());
        }
        this.timeError = z;
        g9();
        return this.timeError;
    }

    private final void g9() {
        if (this.timeError && Y8() == EnumC15195jA1.e) {
            TextView textView = X8().e;
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            textView.setBackgroundColor(c5495Jo7.H0());
            X8().e.setTextColor(c5495Jo7.e0());
            return;
        }
        TextView textView2 = X8().e;
        C5495Jo7 c5495Jo72 = C5495Jo7.a;
        textView2.setBackgroundColor(c5495Jo72.t2());
        X8().e.setTextColor(c5495Jo72.l2());
    }

    private final void h9() throws IllegalAccessException, SecurityException, IllegalArgumentException {
        X8().i.setMaxYear(this.persianDate.C());
        X8().s.setMaxYear(this.persianDate.C());
        X8().i.setMinYear(1395);
        X8().s.setMinYear(1395);
        X8().i.getYearNumberPicker().setWrapSelectorWheel(false);
        X8().s.getYearNumberPicker().setWrapSelectorWheel(false);
    }

    private final void i9() {
        ir.nasim.features.pfm.h hVarD9 = d9();
        l9(hVarD9.W1());
        m9(hVarD9.W1());
        this.startDateConfig = hVarD9.o2();
        this.oldFromTimeTimeStamp = d9().v2();
        this.oldToTimeTimeStamp = d9().w2();
        n9(AbstractC10360bX0.p(X8().n, X8().m, X8().w, X8().u, X8().b));
    }

    private final void j9() {
        C9208Yy2 c9208Yy2X8 = X8();
        int i = a.a[Y8().ordinal()];
        if (i == 1) {
            c9208Yy2X8.c.setVisibility(0);
            c9208Yy2X8.b.setChecked(true);
            c9208Yy2X8.b.setTextColor(AbstractC4043Dl1.c(S7(), TA5.buttonContent));
            this.backGroundDrawable.setShape(this.rectShape);
            ImageView imageView = c9208Yy2X8.l;
            AbstractC13042fc3.h(imageView, "lineIv");
            imageView.setVisibility(8);
            ImageView imageView2 = c9208Yy2X8.k;
            AbstractC13042fc3.h(imageView2, "imvClose");
            imageView2.setVisibility(0);
        } else if (i == 2) {
            c9208Yy2X8.c.setVisibility(8);
            c9208Yy2X8.m.setChecked(true);
            c9208Yy2X8.m.setTextColor(AbstractC4043Dl1.c(S7(), TA5.buttonContent));
            this.backGroundDrawable.setShape(this.topRoundRectShape);
            ImageView imageView3 = c9208Yy2X8.l;
            AbstractC13042fc3.h(imageView3, "lineIv");
            imageView3.setVisibility(0);
            ImageView imageView4 = c9208Yy2X8.k;
            AbstractC13042fc3.h(imageView4, "imvClose");
            imageView4.setVisibility(8);
        } else if (i == 3) {
            c9208Yy2X8.c.setVisibility(8);
            c9208Yy2X8.w.setChecked(true);
            c9208Yy2X8.w.setTextColor(AbstractC4043Dl1.c(S7(), TA5.buttonContent));
            this.backGroundDrawable.setShape(this.topRoundRectShape);
            ImageView imageView5 = c9208Yy2X8.l;
            AbstractC13042fc3.h(imageView5, "lineIv");
            imageView5.setVisibility(0);
            ImageView imageView6 = c9208Yy2X8.k;
            AbstractC13042fc3.h(imageView6, "imvClose");
            imageView6.setVisibility(8);
        } else if (i == 4) {
            c9208Yy2X8.c.setVisibility(8);
            c9208Yy2X8.u.setChecked(true);
            c9208Yy2X8.u.setTextColor(AbstractC4043Dl1.c(S7(), TA5.buttonContent));
            this.backGroundDrawable.setShape(this.topRoundRectShape);
            ImageView imageView7 = c9208Yy2X8.l;
            AbstractC13042fc3.h(imageView7, "lineIv");
            imageView7.setVisibility(0);
            ImageView imageView8 = c9208Yy2X8.k;
            AbstractC13042fc3.h(imageView8, "imvClose");
            imageView8.setVisibility(8);
        } else {
            if (i != 5) {
                throw new NoWhenBranchMatchedException();
            }
            c9208Yy2X8.c.setVisibility(8);
            c9208Yy2X8.n.setChecked(true);
            c9208Yy2X8.n.setTextColor(AbstractC4043Dl1.c(S7(), TA5.buttonContent));
            this.backGroundDrawable.setShape(this.topRoundRectShape);
            ImageView imageView9 = c9208Yy2X8.l;
            AbstractC13042fc3.h(imageView9, "lineIv");
            imageView9.setVisibility(0);
            ImageView imageView10 = c9208Yy2X8.k;
            AbstractC13042fc3.h(imageView10, "imvClose");
            imageView10.setVisibility(8);
        }
        X8().getRoot().setBackground(this.backGroundDrawable);
        ImageView imageView11 = c9208Yy2X8.k;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        imageView11.setBackground(AbstractC4310Eo7.f(48, c5495Jo7.j(), c5495Jo7.y0(c5495Jo7.n0(), 27)));
        c9208Yy2X8.e.setBackground(AbstractC4310Eo7.j(b6().getColor(TA5.secondary), b6().getColor(TA5.secondary_tint), 0));
        c9208Yy2X8.j.setText(b9(this.persianDate.C(), this.persianDate.B(), this.persianDate.A()));
        c9208Yy2X8.t.setText(b9(this.persianDate.C(), this.persianDate.B(), this.persianDate.A()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k9(C11690dR4 c11690dR4) {
        AbstractC13042fc3.i(c11690dR4, "this$0");
        BottomSheetBehavior bottomSheetBehavior = c11690dR4.bottomSheetBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.J0(3);
        }
    }

    private final void o9() {
        X8().i.setOnDateChangedListener(new PersianDatePicker.e() { // from class: ir.nasim.YQ4
            @Override // ir.nasim.features.pfm.persiandate.view.PersianDatePicker.e
            public final void a(int i, int i2, int i3) {
                C11690dR4.p9(this.a, i, i2, i3);
            }
        });
        X8().s.setOnDateChangedListener(new PersianDatePicker.e() { // from class: ir.nasim.ZQ4
            @Override // ir.nasim.features.pfm.persiandate.view.PersianDatePicker.e
            public final void a(int i, int i2, int i3) {
                C11690dR4.q9(this.a, i, i2, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p9(C11690dR4 c11690dR4, int i, int i2, int i3) {
        AbstractC13042fc3.i(c11690dR4, "this$0");
        D45 d45D = c11690dR4.X8().i.getPersianPickerDate().d();
        AbstractC13042fc3.h(d45D, "getPersianDate(...)");
        c11690dR4.fromTimeTimeStamp = AbstractC15360jS4.a(d45D);
        c11690dR4.X8().j.setText(c11690dR4.b9(i, i2, i3));
        if (c11690dR4.e9()) {
            return;
        }
        c11690dR4.f9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q9(C11690dR4 c11690dR4, int i, int i2, int i3) {
        AbstractC13042fc3.i(c11690dR4, "this$0");
        D45 d45D = c11690dR4.X8().s.getPersianPickerDate().d();
        AbstractC13042fc3.h(d45D, "getPersianDate(...)");
        c11690dR4.toTimeTimeStamp = AbstractC15360jS4.b(d45D);
        c11690dR4.X8().t.setText(c11690dR4.b9(i, i2, i3));
        if (c11690dR4.f9()) {
            return;
        }
        c11690dR4.e9();
    }

    private final void r9() {
        X8().k.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.aR4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C11690dR4.s9(this.a, view);
            }
        });
        X8().e.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.bR4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws ParseException {
                C11690dR4.t9(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s9(C11690dR4 c11690dR4, View view) {
        AbstractC13042fc3.i(c11690dR4, "this$0");
        com.google.android.material.bottomsheet.a aVar = c11690dR4.bottomSheetDialog;
        if (aVar == null) {
            AbstractC13042fc3.y("bottomSheetDialog");
            aVar = null;
        }
        aVar.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t9(C11690dR4 c11690dR4, View view) throws ParseException {
        AbstractC13042fc3.i(c11690dR4, "this$0");
        if (c11690dR4.timeError && c11690dR4.Y8() == EnumC15195jA1.e) {
            AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
            aVar.S(c11690dR4.X8().g, 5.0f, 1);
            aVar.S(c11690dR4.X8().q, 5.0f, 1);
            return;
        }
        com.google.android.material.bottomsheet.a aVar2 = null;
        if (c11690dR4.Y8() == c11690dR4.Z8()) {
            if (c11690dR4.Y8() != EnumC15195jA1.e) {
                com.google.android.material.bottomsheet.a aVar3 = c11690dR4.bottomSheetDialog;
                if (aVar3 == null) {
                    AbstractC13042fc3.y("bottomSheetDialog");
                } else {
                    aVar2 = aVar3;
                }
                aVar2.dismiss();
                return;
            }
            if (c11690dR4.oldToTimeTimeStamp == c11690dR4.toTimeTimeStamp && c11690dR4.oldFromTimeTimeStamp == c11690dR4.fromTimeTimeStamp) {
                com.google.android.material.bottomsheet.a aVar4 = c11690dR4.bottomSheetDialog;
                if (aVar4 == null) {
                    AbstractC13042fc3.y("bottomSheetDialog");
                } else {
                    aVar2 = aVar4;
                }
                aVar2.dismiss();
                return;
            }
        }
        int i = a.a[c11690dR4.Y8().ordinal()];
        if (i == 1) {
            c11690dR4.d9().v3(c11690dR4.fromTimeTimeStamp, c11690dR4.toTimeTimeStamp);
        } else if (i == 2) {
            c11690dR4.d9().x3();
        } else if (i == 3) {
            c11690dR4.d9().y3();
        } else if (i == 4) {
            c11690dR4.d9().w3();
        } else {
            if (i != 5) {
                throw new NoWhenBranchMatchedException();
            }
            c11690dR4.d9().u3();
        }
        com.google.android.material.bottomsheet.a aVar5 = c11690dR4.bottomSheetDialog;
        if (aVar5 == null) {
            AbstractC13042fc3.y("bottomSheetDialog");
        } else {
            aVar2 = aVar5;
        }
        aVar2.dismiss();
        c11690dR4.d9().a3();
    }

    private final void u9() {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: ir.nasim.cR4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                C11690dR4.v9(this.a, compoundButton, z);
            }
        };
        X8().b.setOnCheckedChangeListener(onCheckedChangeListener);
        X8().m.setOnCheckedChangeListener(onCheckedChangeListener);
        X8().w.setOnCheckedChangeListener(onCheckedChangeListener);
        X8().u.setOnCheckedChangeListener(onCheckedChangeListener);
        X8().n.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v9(C11690dR4 c11690dR4, CompoundButton compoundButton, boolean z) {
        AbstractC13042fc3.i(c11690dR4, "this$0");
        if (z) {
            int id = compoundButton.getId();
            if (id == c11690dR4.X8().b.getId()) {
                c11690dR4.X8().c.setVisibility(0);
                c11690dR4.l9(EnumC15195jA1.e);
                c11690dR4.backGroundDrawable.setShape(c11690dR4.rectShape);
                ImageView imageView = c11690dR4.X8().l;
                AbstractC13042fc3.h(imageView, "lineIv");
                imageView.setVisibility(8);
                ImageView imageView2 = c11690dR4.X8().k;
                AbstractC13042fc3.h(imageView2, "imvClose");
                imageView2.setVisibility(0);
            } else if (id == c11690dR4.X8().m.getId()) {
                c11690dR4.X8().c.setVisibility(8);
                c11690dR4.l9(EnumC15195jA1.a);
                c11690dR4.backGroundDrawable.setShape(c11690dR4.topRoundRectShape);
                ImageView imageView3 = c11690dR4.X8().l;
                AbstractC13042fc3.h(imageView3, "lineIv");
                imageView3.setVisibility(0);
                ImageView imageView4 = c11690dR4.X8().k;
                AbstractC13042fc3.h(imageView4, "imvClose");
                imageView4.setVisibility(8);
            } else if (id == c11690dR4.X8().w.getId()) {
                c11690dR4.X8().c.setVisibility(8);
                c11690dR4.l9(EnumC15195jA1.b);
                c11690dR4.backGroundDrawable.setShape(c11690dR4.topRoundRectShape);
                ImageView imageView5 = c11690dR4.X8().l;
                AbstractC13042fc3.h(imageView5, "lineIv");
                imageView5.setVisibility(0);
                ImageView imageView6 = c11690dR4.X8().k;
                AbstractC13042fc3.h(imageView6, "imvClose");
                imageView6.setVisibility(8);
            } else if (id == c11690dR4.X8().u.getId()) {
                c11690dR4.X8().c.setVisibility(8);
                c11690dR4.l9(EnumC15195jA1.c);
                c11690dR4.backGroundDrawable.setShape(c11690dR4.topRoundRectShape);
                ImageView imageView7 = c11690dR4.X8().l;
                AbstractC13042fc3.h(imageView7, "lineIv");
                imageView7.setVisibility(0);
                ImageView imageView8 = c11690dR4.X8().k;
                AbstractC13042fc3.h(imageView8, "imvClose");
                imageView8.setVisibility(8);
            } else if (id == c11690dR4.X8().n.getId()) {
                c11690dR4.X8().c.setVisibility(8);
                c11690dR4.l9(EnumC15195jA1.d);
                c11690dR4.backGroundDrawable.setShape(c11690dR4.topRoundRectShape);
                ImageView imageView9 = c11690dR4.X8().l;
                AbstractC13042fc3.h(imageView9, "lineIv");
                imageView9.setVisibility(0);
                ImageView imageView10 = c11690dR4.X8().k;
                AbstractC13042fc3.h(imageView10, "imvClose");
                imageView10.setVisibility(8);
            }
            c11690dR4.X8().getRoot().setBackground(c11690dR4.backGroundDrawable);
            for (RadioButton radioButton : c11690dR4.a9()) {
                if (radioButton.getId() == compoundButton.getId()) {
                    radioButton.setTextColor(AbstractC4043Dl1.c(c11690dR4.S7(), TA5.buttonContent));
                    radioButton.setChecked(true);
                } else {
                    radioButton.setTextColor(AbstractC4043Dl1.c(c11690dR4.S7(), TA5.itemSubtitle));
                    radioButton.setChecked(false);
                }
            }
            c11690dR4.g9();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ir.nasim.features.pfm.h w9(C11690dR4 c11690dR4) {
        AbstractC13042fc3.i(c11690dR4, "this$0");
        FragmentActivity fragmentActivityQ7 = c11690dR4.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        return (ir.nasim.features.pfm.h) new androidx.lifecycle.G(fragmentActivityQ7).b(ir.nasim.features.pfm.h.class);
    }

    @Override // com.google.android.material.bottomsheet.b, ir.nasim.ZD, androidx.fragment.app.l
    public Dialog B8(Bundle savedInstanceState) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        Dialog dialogB8 = super.B8(savedInstanceState);
        AbstractC13042fc3.g(dialogB8, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        this.bottomSheetDialog = (com.google.android.material.bottomsheet.a) dialogB8;
        this._binding = C9208Yy2.c(LayoutInflater.from(G5()));
        com.google.android.material.bottomsheet.a aVar = this.bottomSheetDialog;
        if (aVar == null) {
            AbstractC13042fc3.y("bottomSheetDialog");
            aVar = null;
        }
        aVar.setContentView(X8().getRoot());
        BottomSheetBehavior bottomSheetBehavior = this.bottomSheetBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.J0(3);
        }
        X8().getRoot().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ir.nasim.XQ4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                C11690dR4.k9(this.a);
            }
        });
        i9();
        j9();
        r9();
        u9();
        h9();
        o9();
        com.google.android.material.bottomsheet.a aVar2 = this.bottomSheetDialog;
        if (aVar2 != null) {
            return aVar2;
        }
        AbstractC13042fc3.y("bottomSheetDialog");
        return null;
    }

    @Override // ir.nasim.ZD, androidx.fragment.app.l
    public void J8(Dialog dialog, int style) {
        AbstractC13042fc3.i(dialog, "dialog");
        Window window = dialog.getWindow();
        FrameLayout frameLayout = window != null ? (FrameLayout) window.findViewById(BC5.design_bottom_sheet) : null;
        AbstractC13042fc3.g(frameLayout, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.bottomSheetBehavior = BottomSheetBehavior.f0(frameLayout);
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        I8(0, AbstractC23035wE5.PlayListBottomSheetDialogTheme);
        this.backGroundDrawable.getPaint().setAntiAlias(true);
        this.backGroundDrawable.getPaint().setColor(C5495Jo7.a.j());
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        super.R6();
        this._binding = null;
    }

    public final EnumC15195jA1 Y8() {
        EnumC15195jA1 enumC15195jA1 = this.dateFilterType;
        if (enumC15195jA1 != null) {
            return enumC15195jA1;
        }
        AbstractC13042fc3.y("dateFilterType");
        return null;
    }

    public final EnumC15195jA1 Z8() {
        EnumC15195jA1 enumC15195jA1 = this.oldDateFilterType;
        if (enumC15195jA1 != null) {
            return enumC15195jA1;
        }
        AbstractC13042fc3.y("oldDateFilterType");
        return null;
    }

    public final List a9() {
        List list = this.radioButtons;
        if (list != null) {
            return list;
        }
        AbstractC13042fc3.y("radioButtons");
        return null;
    }

    public final void l9(EnumC15195jA1 enumC15195jA1) {
        AbstractC13042fc3.i(enumC15195jA1, "<set-?>");
        this.dateFilterType = enumC15195jA1;
    }

    public final void m9(EnumC15195jA1 enumC15195jA1) {
        AbstractC13042fc3.i(enumC15195jA1, "<set-?>");
        this.oldDateFilterType = enumC15195jA1;
    }

    public final void n9(List list) {
        AbstractC13042fc3.i(list, "<set-?>");
        this.radioButtons = list;
    }
}
