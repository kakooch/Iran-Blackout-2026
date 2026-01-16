package ir.nasim.designsystem.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC15575jo7;
import ir.nasim.AbstractC23035wE5;
import ir.nasim.AbstractC3742Cd6;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.InterfaceC14067hI1;
import ir.nasim.KB5;
import ir.nasim.YE5;
import ir.nasim.designsystem.button.a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0017\u0010\u0018J7\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tH\u0014¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\f2\u0006\u0010\"\u001a\u00020!H\u0014¢\u0006\u0004\b#\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006("}, d2 = {"Lir/nasim/designsystem/button/BaleButton;", "Landroidx/appcompat/widget/AppCompatButton;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rB7;", "b", "(Landroid/util/AttributeSet;)V", "a", "()V", "Lir/nasim/designsystem/button/a;", "baleButtonType", "setButtonType", "(Lir/nasim/designsystem/button/a;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "d", "Lir/nasim/designsystem/button/a;", "buttonType", "nasim_release"}, k = 1, mv = {2, 0, 0})
@InterfaceC14067hI1
/* loaded from: classes5.dex */
public final class BaleButton extends AppCompatButton {

    /* renamed from: d, reason: from kotlin metadata */
    private ir.nasim.designsystem.button.a buttonType;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ir.nasim.designsystem.button.a.values().length];
            try {
                iArr[ir.nasim.designsystem.button.a.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ir.nasim.designsystem.button.a.f.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ir.nasim.designsystem.button.a.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ir.nasim.designsystem.button.a.e.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ir.nasim.designsystem.button.a.g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ir.nasim.designsystem.button.a.h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ir.nasim.designsystem.button.a.k.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ir.nasim.designsystem.button.a.i.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ir.nasim.designsystem.button.a.j.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[ir.nasim.designsystem.button.a.l.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[ir.nasim.designsystem.button.a.m.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[ir.nasim.designsystem.button.a.n.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[ir.nasim.designsystem.button.a.o.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[ir.nasim.designsystem.button.a.p.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaleButton(Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        b(null);
    }

    private final void a() {
        ir.nasim.designsystem.button.a aVar = this.buttonType;
        switch (aVar == null ? -1 : a.a[aVar.ordinal()]) {
            case 1:
                setBackgroundResource(KB5.green_selector);
                setTextSize(2, 17.0f);
                setTextColor(C5495Jo7.a.b0());
                break;
            case 2:
                setBackgroundResource(KB5.green_selector_border);
                setTextSize(2, 15.0f);
                setTextColor(C5495Jo7.a.e2());
                break;
            case 3:
                setBackgroundResource(KB5.green_selector);
                setTextSize(2, 13.0f);
                setTextColor(C5495Jo7.a.b0());
                break;
            case 4:
                setBackgroundResource(KB5.green_selector_border);
                setTextSize(2, 17.0f);
                setTextColor(C5495Jo7.a.e2());
                break;
            case 5:
                setBackgroundResource(KB5.green_selector_border);
                setTextSize(2, 13.0f);
                setTextColor(C5495Jo7.a.e2());
                break;
            case 6:
                setBackgroundResource(KB5.blue_selector);
                setTextSize(2, 17.0f);
                setTextColor(C5495Jo7.a.b0());
                break;
            case 7:
                setBackgroundResource(KB5.blue_selector_border);
                setTextSize(2, 15.0f);
                setTextColor(C5495Jo7.a.a0());
                break;
            case 8:
                setBackgroundResource(KB5.blue_selector);
                setTextSize(2, 13.0f);
                setTextColor(C5495Jo7.a.b0());
                break;
            case 9:
                setBackgroundResource(KB5.blue_selector_border);
                setTextSize(2, 17.0f);
                setTextColor(C5495Jo7.a.a0());
                break;
            case 10:
                setBackgroundResource(KB5.blue_selector_border);
                setTextSize(2, 13.0f);
                setTextColor(C5495Jo7.a.a0());
                break;
            case 11:
                setBackgroundResource(KB5.bank_blue_selector);
                setTextColor(C5495Jo7.a.b0());
                AbstractC15575jo7.p(this, AbstractC23035wE5.BALE_BUTTON_BANK_BLUE);
                setPadding(0, 0, 0, 0);
                setTypeface(C6011Lu2.i());
                setTextSize(2, 18.0f);
                break;
            case 12:
                setBackgroundResource(KB5.bank_green_selector);
                setTypeface(C6011Lu2.i());
                setTextSize(2, 18.0f);
                setTextColor(C5495Jo7.a.b0());
                setPadding(0, 0, 0, 0);
                break;
            case 13:
                setBackgroundResource(KB5.bank_blue_selector_disabled);
                setTypeface(C6011Lu2.i());
                setTextSize(2, 18.0f);
                setTextColor(C5495Jo7.a.e0());
                setPadding(0, 0, 0, 0);
                break;
            case 14:
                setBackgroundResource(KB5.update_button);
                setTypeface(C6011Lu2.i());
                setTextSize(2, 14.0f);
                setTextColor(C5495Jo7.a.d0());
                setPadding(0, 0, 0, 0);
                break;
        }
    }

    private final void b(AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, YE5.BaleButton, 0, 0);
        AbstractC13042fc3.h(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        int i = typedArrayObtainStyledAttributes.getInt(YE5.BaleButton_bale_button_type, 0);
        a.C1020a c1020a = ir.nasim.designsystem.button.a.b;
        this.buttonType = c1020a.a(i);
        int i2 = typedArrayObtainStyledAttributes.getInt(YE5.BaleButton_bale_button_type_custom, 0);
        if (i == 0 && i2 != 0) {
            this.buttonType = c1020a.a(i2);
        }
        typedArrayObtainStyledAttributes.recycle();
        setTypeface(C6011Lu2.k());
        setStateListAnimator(null);
        double d = 20.0f;
        setPadding((int) ((AbstractC3742Cd6.c() * d) + 0.5d), 0, (int) ((d * AbstractC3742Cd6.c()) + 0.5d), 0);
        a();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        AbstractC13042fc3.i(canvas, "canvas");
        super.onDraw(canvas);
        ir.nasim.designsystem.button.a aVar = this.buttonType;
        if (aVar == ir.nasim.designsystem.button.a.l || aVar == ir.nasim.designsystem.button.a.i || aVar == ir.nasim.designsystem.button.a.g || aVar == ir.nasim.designsystem.button.a.d) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-2, (int) ((28.0f * AbstractC3742Cd6.c()) + 0.5d));
            } else {
                layoutParams.height = (int) ((28.0f * AbstractC3742Cd6.c()) + 0.5d);
            }
            setLayoutParams(layoutParams);
        }
        ir.nasim.designsystem.button.a aVar2 = this.buttonType;
        if (aVar2 == ir.nasim.designsystem.button.a.k || aVar2 == ir.nasim.designsystem.button.a.f) {
            ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new ViewGroup.LayoutParams(-2, (int) ((37.0f * AbstractC3742Cd6.c()) + 0.5d));
            } else {
                layoutParams2.height = (int) ((37.0f * AbstractC3742Cd6.c()) + 0.5d);
            }
            setLayoutParams(layoutParams2);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public final void setButtonType(ir.nasim.designsystem.button.a baleButtonType) {
        this.buttonType = baleButtonType;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        b(attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        b(attributeSet);
    }
}
