package ir.nasim;

import android.graphics.Outline;
import android.os.Build;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.Window;
import java.util.UUID;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes2.dex */
final class XP1 extends V01 implements EX7 {
    private SA2 d;
    private C18876pP1 e;
    private final View f;
    private final IN1 g;
    private final float h;

    public static final class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRect(0, 0, view.getWidth(), view.getHeight());
            outline.setAlpha(0.0f);
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        b() {
            super(1);
        }

        public final void a(AbstractC23070wI4 abstractC23070wI4) {
            if (XP1.this.e.b()) {
                XP1.this.d.invoke();
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC23070wI4) obj);
            return C19938rB7.a;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC12613eu3.values().length];
            try {
                iArr[EnumC12613eu3.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC12613eu3.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    public XP1(SA2 sa2, C18876pP1 c18876pP1, View view, EnumC12613eu3 enumC12613eu3, WH1 wh1, UUID uuid) {
        super(new ContextThemeWrapper(view.getContext(), c18876pP1.a() ? AbstractC19372qE5.DialogWindowTheme : AbstractC19372qE5.FloatingDialogWindowTheme), 0, 2, null);
        this.d = sa2;
        this.e = c18876pP1;
        this.f = view;
        float fQ = C17784nZ1.q(8);
        this.h = fQ;
        Window window = getWindow();
        if (window == null) {
            throw new IllegalStateException("Dialog has no window".toString());
        }
        window.requestFeature(1);
        window.setBackgroundDrawableResource(android.R.color.transparent);
        AbstractC19329q98.b(window, this.e.a());
        window.setGravity(17);
        IN1 in1 = new IN1(getContext(), window);
        in1.setTag(AbstractC22421vC5.compose_view_saveable_id_tag, "Dialog:" + uuid);
        in1.setClipChildren(false);
        in1.setElevation(wh1.w1(fQ));
        in1.setOutlineProvider(new a());
        this.g = in1;
        View decorView = window.getDecorView();
        ViewGroup viewGroup = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
        if (viewGroup != null) {
            e(viewGroup);
        }
        setContentView(in1);
        VX7.b(in1, VX7.a(view));
        YX7.b(in1, YX7.a(view));
        XX7.b(in1, XX7.a(view));
        l(this.d, this.e, enumC12613eu3);
        AbstractC24844zI4.b(z2(), this, false, new b(), 2, null);
    }

    private static final void e(ViewGroup viewGroup) {
        viewGroup.setClipChildren(false);
        if (viewGroup instanceof IN1) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            ViewGroup viewGroup2 = childAt instanceof ViewGroup ? (ViewGroup) childAt : null;
            if (viewGroup2 != null) {
                e(viewGroup2);
            }
        }
    }

    private final void j(EnumC12613eu3 enumC12613eu3) {
        IN1 in1 = this.g;
        int i = c.a[enumC12613eu3.ordinal()];
        int i2 = 1;
        if (i == 1) {
            i2 = 0;
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        in1.setLayoutDirection(i2);
    }

    private final void k(EnumC20851si6 enumC20851si6) {
        boolean zA = AbstractC21538ti6.a(enumC20851si6, AbstractC6456Nq.j(this.f));
        Window window = getWindow();
        AbstractC13042fc3.f(window);
        window.setFlags(zA ? 8192 : -8193, 8192);
    }

    public final void h() {
        this.g.h();
    }

    public final void i(AbstractC7050Qb1 abstractC7050Qb1, InterfaceC14603iB2 interfaceC14603iB2) {
        this.g.setContent(abstractC7050Qb1, interfaceC14603iB2);
    }

    public final void l(SA2 sa2, C18876pP1 c18876pP1, EnumC12613eu3 enumC12613eu3) {
        this.d = sa2;
        this.e = c18876pP1;
        k(c18876pP1.d());
        j(enumC12613eu3);
        boolean zA = c18876pP1.a();
        this.g.q(c18876pP1.e(), zA);
        setCanceledOnTouchOutside(c18876pP1.c());
        Window window = getWindow();
        if (window != null) {
            window.setSoftInputMode(zA ? 0 : Build.VERSION.SDK_INT < 31 ? 16 : 48);
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (!this.e.b() || !keyEvent.isTracking() || keyEvent.isCanceled() || i != 111) {
            return super.onKeyUp(i, keyEvent);
        }
        this.d.invoke();
        return true;
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        if (!this.e.c() || this.g.p(motionEvent)) {
            return zOnTouchEvent;
        }
        this.d.invoke();
        return true;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
    }
}
