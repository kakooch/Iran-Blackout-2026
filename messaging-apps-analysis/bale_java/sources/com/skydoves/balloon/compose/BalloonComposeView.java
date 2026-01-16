package com.skydoves.balloon.compose;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.AbstractComposeView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13472gH6;
import ir.nasim.AbstractC22421vC5;
import ir.nasim.AbstractC5138Ib1;
import ir.nasim.AbstractC7050Qb1;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.BI4;
import ir.nasim.C19938rB7;
import ir.nasim.C24685z21;
import ir.nasim.C4414Fa3;
import ir.nasim.CI4;
import ir.nasim.D20;
import ir.nasim.DI4;
import ir.nasim.E20;
import ir.nasim.EI4;
import ir.nasim.FI4;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.InterfaceC20208rd6;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC9102Ym4;
import ir.nasim.QJ5;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.VX7;
import ir.nasim.XX7;
import ir.nasim.YX7;
import ir.nasim.Z20;
import java.util.UUID;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0017¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001b\u0010\u001aJ'\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010\"\u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b\"\u0010#J#\u0010\"\u001a\u00020\r2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\u0012H\u0016¢\u0006\u0004\b\"\u0010%J\u0019\u0010(\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b(\u0010)J#\u0010(\u001a\u00020\r2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\u0012H\u0016¢\u0006\u0004\b(\u0010%J\u0019\u0010,\u001a\u00020\r2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\b,\u0010-J\u001d\u0010,\u001a\u00020\r2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\r0.H\u0016¢\u0006\u0004\b,\u0010/J\u0019\u00102\u001a\u00020\r2\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\b2\u00103J)\u00102\u001a\u00020\r2\u0018\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\r04H\u0016¢\u0006\u0004\b2\u00106J\u0019\u00109\u001a\u00020\r2\b\u00108\u001a\u0004\u0018\u000107H\u0016¢\u0006\u0004\b9\u0010:J\u0019\u0010;\u001a\u00020\r2\b\u00108\u001a\u0004\u0018\u000107H\u0016¢\u0006\u0004\b;\u0010:J)\u0010;\u001a\u00020\r2\u0018\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u000504H\u0016¢\u0006\u0004\b;\u00106J\u0019\u0010>\u001a\u00020\r2\b\u0010=\u001a\u0004\u0018\u00010<H\u0016¢\u0006\u0004\b>\u0010?J\u001d\u0010>\u001a\u00020\r2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\r0.H\u0016¢\u0006\u0004\b>\u0010/J\u000f\u0010A\u001a\u00020@H\u0016¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\u0003H\u0016¢\u0006\u0004\bC\u0010DJ\u001a\u0010G\u001a\u00020\r2\u0006\u0010F\u001a\u00020EH\u0000ø\u0001\u0000¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\rH\u0000¢\u0006\u0004\bI\u0010JJ\u000f\u0010L\u001a\u00020KH\u0016¢\u0006\u0004\bL\u0010MR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010DR\u0016\u0010T\u001a\u0004\u0018\u00010Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u001a\u0010Z\u001a\u00020U8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YRC\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\u00122\u0012\u0010[\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\u00128B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b\u0014\u0010`R*\u0010h\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010b0a8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bc\u0010]\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR$\u0010l\u001a\u00020\u00052\u0006\u0010[\u001a\u00020\u00058\u0014@RX\u0094\u000e¢\u0006\f\n\u0004\bI\u0010i\u001a\u0004\bj\u0010k\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006m"}, d2 = {"Lcom/skydoves/balloon/compose/BalloonComposeView;", "Landroidx/compose/ui/platform/AbstractComposeView;", "Lir/nasim/Z20;", "Landroid/view/View;", "anchorView", "", "isComposableContent", "Lir/nasim/D20$a;", "builder", "Ljava/util/UUID;", "balloonID", "<init>", "(Landroid/view/View;ZLir/nasim/D20$a;Ljava/util/UUID;)V", "Lir/nasim/rB7;", "d", "(Lir/nasim/ub1;I)V", "Lir/nasim/Qb1;", "compositionContext", "Lkotlin/Function1;", "content", "setContent", "(Lir/nasim/Qb1;Lir/nasim/kB2;)V", "", "xOff", "yOff", "c", "(II)V", "a", "Lir/nasim/E20;", "align", "o", "(Lir/nasim/E20;II)V", "Lir/nasim/BI4;", "onBalloonClickListener", "setOnBalloonClickListener", "(Lir/nasim/BI4;)V", "block", "(Lir/nasim/UA2;)V", "Lir/nasim/DI4;", "onBalloonInitializedListener", "setOnBalloonInitializedListener", "(Lir/nasim/DI4;)V", "Lir/nasim/CI4;", "onBalloonDismissListener", "setOnBalloonDismissListener", "(Lir/nasim/CI4;)V", "Lkotlin/Function0;", "(Lir/nasim/SA2;)V", "Lir/nasim/EI4;", "onBalloonOutsideTouchListener", "setOnBalloonOutsideTouchListener", "(Lir/nasim/EI4;)V", "Lkotlin/Function2;", "Landroid/view/MotionEvent;", "(Lir/nasim/iB2;)V", "Landroid/view/View$OnTouchListener;", "onTouchListener", "setOnBalloonTouchListener", "(Landroid/view/View$OnTouchListener;)V", "setOnBalloonOverlayTouchListener", "Lir/nasim/FI4;", "onBalloonOverlayClickListener", "setOnBalloonOverlayClickListener", "(Lir/nasim/FI4;)V", "Landroid/view/ViewGroup;", "getContentView", "()Landroid/view/ViewGroup;", "getBalloonArrowView", "()Landroid/view/View;", "Lir/nasim/Fa3;", "size", "p", "(J)V", "n", "()V", "", "getAccessibilityClassName", "()Ljava/lang/CharSequence;", "i", "Landroid/view/View;", "getAnchorView", "Lir/nasim/oz3;", "j", "Lir/nasim/oz3;", "lifecycleOwner", "Lir/nasim/D20;", "k", "Lir/nasim/D20;", "getBalloon", "()Lir/nasim/D20;", "balloon", "<set-?>", "l", "Lir/nasim/Ym4;", "getContent", "()Lir/nasim/kB2;", "(Lir/nasim/kB2;)V", "Lir/nasim/Ym4;", "Lir/nasim/Q20;", "m", "getBalloonLayoutInfo$balloon_compose_release", "()Lir/nasim/Ym4;", "setBalloonLayoutInfo$balloon_compose_release", "(Lir/nasim/Ym4;)V", "balloonLayoutInfo", "Z", "getShouldCreateCompositionOnAttachedToWindow", "()Z", "shouldCreateCompositionOnAttachedToWindow", "balloon-compose_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class BalloonComposeView extends AbstractComposeView implements Z20 {

    /* renamed from: i, reason: from kotlin metadata */
    private final View anchorView;

    /* renamed from: j, reason: from kotlin metadata */
    private final InterfaceC18633oz3 lifecycleOwner;

    /* renamed from: k, reason: from kotlin metadata */
    private final D20 balloon;

    /* renamed from: l, reason: from kotlin metadata */
    private final InterfaceC9102Ym4 content;

    /* renamed from: m, reason: from kotlin metadata */
    private InterfaceC9102Ym4 balloonLayoutInfo;

    /* renamed from: n, reason: from kotlin metadata */
    private boolean shouldCreateCompositionOnAttachedToWindow;

    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i) {
            super(2);
            this.f = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            BalloonComposeView.this.d(interfaceC22053ub1, QJ5.a(this.f | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BalloonComposeView(View view, boolean z, D20.a aVar, UUID uuid) {
        AbstractC13042fc3.i(view, "anchorView");
        AbstractC13042fc3.i(aVar, "builder");
        AbstractC13042fc3.i(uuid, "balloonID");
        Context context = view.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        super(context, null, 0, 6, null);
        this.anchorView = view;
        InterfaceC18633oz3 interfaceC18633oz3A = VX7.a(getAnchorView());
        this.lifecycleOwner = interfaceC18633oz3A;
        D20.a aVarB1 = aVar.G1(interfaceC18633oz3A).B1(z);
        if (z) {
            aVarB1.F1(this);
        }
        this.balloon = aVarB1.a();
        this.content = AbstractC13472gH6.d(C24685z21.a.a(), null, 2, null);
        this.balloonLayoutInfo = AbstractC13472gH6.d(null, null, 2, null);
        VX7.b(this, interfaceC18633oz3A);
        YX7.b(this, YX7.a(getAnchorView()));
        XX7.b(this, XX7.a(getAnchorView()));
        setTag(AbstractC22421vC5.compose_view_saveable_id_tag, "BalloonComposeView:" + uuid);
    }

    private final InterfaceC15796kB2 getContent() {
        return (InterfaceC15796kB2) this.content.getValue();
    }

    private final void setContent(InterfaceC15796kB2 interfaceC15796kB2) {
        this.content.setValue(interfaceC15796kB2);
    }

    @Override // ir.nasim.Z20
    public void a(int xOff, int yOff) {
        getBalloon().L0(getAnchorView(), xOff, yOff);
    }

    @Override // ir.nasim.Z20
    public void c(int xOff, int yOff) {
        getBalloon().J0(getAnchorView(), xOff, yOff);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void d(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-441221009);
        if ((i & 14) == 0) {
            i2 = (interfaceC22053ub1J.V(this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-441221009, i2, -1, "com.skydoves.balloon.compose.BalloonComposeView.Content (BalloonComposeView.kt:93)");
            }
            getContent().q(this, interfaceC22053ub1J, Integer.valueOf(i2 & 14));
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new a(i));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        String name = BalloonComposeView.class.getName();
        AbstractC13042fc3.h(name, "getName(...)");
        return name;
    }

    public View getAnchorView() {
        return this.anchorView;
    }

    public D20 getBalloon() {
        return this.balloon;
    }

    public View getBalloonArrowView() {
        return getBalloon().L();
    }

    /* renamed from: getBalloonLayoutInfo$balloon_compose_release, reason: from getter */
    public final InterfaceC9102Ym4 getBalloonLayoutInfo() {
        return this.balloonLayoutInfo;
    }

    public ViewGroup getContentView() {
        return getBalloon().Q();
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    protected boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    public final void n() {
        getBalloon().E();
        VX7.b(this, null);
        YX7.b(this, null);
        XX7.b(this, null);
    }

    public void o(E20 align, int xOff, int yOff) {
        AbstractC13042fc3.i(align, "align");
        getBalloon().V0(align, getAnchorView(), xOff, yOff);
    }

    public final void p(long size) {
        getBalloon().X0(C4414Fa3.g(size), C4414Fa3.f(size));
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        layoutParams.width = C4414Fa3.g(size);
        layoutParams.height = C4414Fa3.f(size);
        setLayoutParams(layoutParams);
    }

    public final void setBalloonLayoutInfo$balloon_compose_release(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "<set-?>");
        this.balloonLayoutInfo = interfaceC9102Ym4;
    }

    public void setOnBalloonClickListener(BI4 onBalloonClickListener) {
        getBalloon().r0(onBalloonClickListener);
    }

    public void setOnBalloonDismissListener(CI4 onBalloonDismissListener) {
        getBalloon().u0(onBalloonDismissListener);
    }

    public void setOnBalloonInitializedListener(DI4 onBalloonInitializedListener) {
        getBalloon().x0(onBalloonInitializedListener);
    }

    public void setOnBalloonOutsideTouchListener(EI4 onBalloonOutsideTouchListener) {
        getBalloon().z0(onBalloonOutsideTouchListener);
    }

    public void setOnBalloonOverlayClickListener(FI4 onBalloonOverlayClickListener) {
        getBalloon().B0(onBalloonOverlayClickListener);
    }

    public void setOnBalloonOverlayTouchListener(View.OnTouchListener onTouchListener) {
        getBalloon().D0(onTouchListener);
    }

    public void setOnBalloonTouchListener(View.OnTouchListener onTouchListener) {
        getBalloon().G0(onTouchListener);
    }

    public void setOnBalloonClickListener(UA2 block) {
        AbstractC13042fc3.i(block, "block");
        getBalloon().q0(block);
    }

    public void setOnBalloonDismissListener(SA2 block) {
        AbstractC13042fc3.i(block, "block");
        getBalloon().t0(block);
    }

    public void setOnBalloonInitializedListener(UA2 block) {
        AbstractC13042fc3.i(block, "block");
        getBalloon().w0(block);
    }

    public void setOnBalloonOutsideTouchListener(InterfaceC14603iB2 block) {
        AbstractC13042fc3.i(block, "block");
        getBalloon().y0(block);
    }

    public void setOnBalloonOverlayClickListener(SA2 block) {
        AbstractC13042fc3.i(block, "block");
        getBalloon().A0(block);
    }

    public void setOnBalloonOverlayTouchListener(InterfaceC14603iB2 block) {
        AbstractC13042fc3.i(block, "block");
        getBalloon().E0(block);
    }

    public final void setContent(AbstractC7050Qb1 compositionContext, InterfaceC15796kB2 content) {
        AbstractC13042fc3.i(compositionContext, "compositionContext");
        AbstractC13042fc3.i(content, "content");
        setParentCompositionContext(compositionContext);
        this.shouldCreateCompositionOnAttachedToWindow = true;
        setContent(content);
        if (isAttachedToWindow()) {
            g();
        }
    }
}
