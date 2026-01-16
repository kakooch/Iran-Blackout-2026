package ir.nasim;

import android.graphics.Outline;
import android.os.Build;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.Window;
import java.util.UUID;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Yf4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class DialogC9039Yf4 extends V01 implements EX7 {
    private SA2 d;
    private C9857ag4 e;
    private final View f;
    private final C8764Xf4 g;
    private final float h;

    /* renamed from: ir.nasim.Yf4$a */
    public static final class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRect(0, 0, view.getWidth(), view.getHeight());
            outline.setAlpha(0.0f);
        }
    }

    /* renamed from: ir.nasim.Yf4$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        b() {
            super(1);
        }

        public final void a(AbstractC23070wI4 abstractC23070wI4) {
            if (DialogC9039Yf4.this.e.b()) {
                DialogC9039Yf4.this.d.invoke();
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC23070wI4) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Yf4$c */
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

    public DialogC9039Yf4(SA2 sa2, C9857ag4 c9857ag4, View view, EnumC12613eu3 enumC12613eu3, WH1 wh1, UUID uuid, C15607js c15607js, InterfaceC20315ro1 interfaceC20315ro1, boolean z) {
        super(new ContextThemeWrapper(view.getContext(), AbstractC18781pE5.EdgeToEdgeFloatingDialogWindowTheme), 0, 2, null);
        this.d = sa2;
        this.e = c9857ag4;
        this.f = view;
        float fQ = C17784nZ1.q(8);
        this.h = fQ;
        Window window = getWindow();
        if (window == null) {
            throw new IllegalStateException("Dialog has no window".toString());
        }
        window.requestFeature(1);
        window.setBackgroundDrawableResource(android.R.color.transparent);
        AbstractC19329q98.b(window, false);
        C8764Xf4 c8764Xf4 = new C8764Xf4(getContext(), window, this.e.b(), this.d, c15607js, interfaceC20315ro1);
        c8764Xf4.setTag(AbstractC22421vC5.compose_view_saveable_id_tag, "Dialog:" + uuid);
        c8764Xf4.setClipChildren(false);
        c8764Xf4.setElevation(wh1.w1(fQ));
        c8764Xf4.setOutlineProvider(new a());
        this.g = c8764Xf4;
        setContentView(c8764Xf4);
        VX7.b(c8764Xf4, VX7.a(view));
        YX7.b(c8764Xf4, YX7.a(view));
        XX7.b(c8764Xf4, XX7.a(view));
        k(this.d, this.e, enumC12613eu3);
        C18391oa8 c18391oa8A = AbstractC19329q98.a(window, window.getDecorView());
        c18391oa8A.c(!z);
        c18391oa8A.b(!z);
        AbstractC24844zI4.b(z2(), this, false, new b(), 2, null);
    }

    private final void i(EnumC12613eu3 enumC12613eu3) {
        C8764Xf4 c8764Xf4 = this.g;
        int i = c.a[enumC12613eu3.ordinal()];
        int i2 = 1;
        if (i == 1) {
            i2 = 0;
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        c8764Xf4.setLayoutDirection(i2);
    }

    private final void j(EnumC20851si6 enumC20851si6) {
        boolean zF = AbstractC10477bg4.f(enumC20851si6, AbstractC10477bg4.e(this.f));
        Window window = getWindow();
        AbstractC13042fc3.f(window);
        window.setFlags(zF ? 8192 : -8193, 8192);
    }

    public final void g() {
        this.g.h();
    }

    public final void h(AbstractC7050Qb1 abstractC7050Qb1, InterfaceC14603iB2 interfaceC14603iB2) {
        this.g.setContent(abstractC7050Qb1, interfaceC14603iB2);
    }

    public final void k(SA2 sa2, C9857ag4 c9857ag4, EnumC12613eu3 enumC12613eu3) {
        this.d = sa2;
        this.e = c9857ag4;
        j(c9857ag4.a());
        i(enumC12613eu3);
        Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setSoftInputMode(Build.VERSION.SDK_INT >= 30 ? 48 : 16);
        }
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        if (zOnTouchEvent) {
            this.d.invoke();
        }
        return zOnTouchEvent;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
    }
}
