package androidx.compose.ui.window;

import android.R;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import androidx.compose.runtime.snapshots.k;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.window.PopupLayout;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10222bH6;
import ir.nasim.AbstractC12000du3;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13472gH6;
import ir.nasim.AbstractC22421vC5;
import ir.nasim.AbstractC3239Aa3;
import ir.nasim.AbstractC5138Ib1;
import ir.nasim.AbstractC6456Nq;
import ir.nasim.AbstractC7050Qb1;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9600aE5;
import ir.nasim.C12280eL5;
import ir.nasim.C17784nZ1;
import ir.nasim.C19938rB7;
import ir.nasim.C22045ua3;
import ir.nasim.C25005za3;
import ir.nasim.C4414Fa3;
import ir.nasim.C7117Qi5;
import ir.nasim.ED1;
import ir.nasim.EX7;
import ir.nasim.EnumC12613eu3;
import ir.nasim.InterfaceC11379cu3;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC6379Ni5;
import ir.nasim.InterfaceC6873Pi5;
import ir.nasim.InterfaceC9102Ym4;
import ir.nasim.InterfaceC9664aL6;
import ir.nasim.L11;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.VX7;
import ir.nasim.WH1;
import ir.nasim.XX7;
import ir.nasim.YX7;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\t\b\u0001\u0018\u0000 \u0099\u00012\u00020\u00012\u00020\u0002:\u0002\u009a\u0001BQ\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\u0004¢\u0006\u0004\b%\u0010\u0017J#\u0010)\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0004H\u0017¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0004H\u0014¢\u0006\u0004\b-\u0010\u0017J\u000f\u0010.\u001a\u00020\u0004H\u0014¢\u0006\u0004\b.\u0010\u0017J\u001f\u00102\u001a\u00020\u00042\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020/H\u0010¢\u0006\u0004\b2\u00103J7\u0010:\u001a\u00020\u00042\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u00020/2\u0006\u00107\u001a\u00020/2\u0006\u00108\u001a\u00020/2\u0006\u00109\u001a\u00020/H\u0010¢\u0006\u0004\b:\u0010;J\u0017\u0010>\u001a\u0002042\u0006\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\b>\u0010?J5\u0010@\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b@\u0010AJ\u0015\u0010D\u001a\u00020\u00042\u0006\u0010C\u001a\u00020B¢\u0006\u0004\bD\u0010EJ\r\u0010F\u001a\u00020\u0004¢\u0006\u0004\bF\u0010\u0017J\u000f\u0010G\u001a\u00020\u0004H\u0001¢\u0006\u0004\bG\u0010\u0017J\r\u0010H\u001a\u00020\u0004¢\u0006\u0004\bH\u0010\u0017J\r\u0010I\u001a\u00020\u0004¢\u0006\u0004\bI\u0010\u0017J\u0019\u0010K\u001a\u0002042\b\u0010=\u001a\u0004\u0018\u00010JH\u0016¢\u0006\u0004\bK\u0010LJ\u0017\u0010M\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020/H\u0016¢\u0006\u0004\bM\u0010NR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010QR\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010^\u001a\u00020[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R \u0010b\u001a\u00020\u001f8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b \u0010_\u0012\u0004\ba\u0010\u0017\u001a\u0004\b`\u0010!R\"\u0010h\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\"\u0010m\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010\u001eR5\u0010u\u001a\u0004\u0018\u00010n2\b\u0010o\u001a\u0004\u0018\u00010n8F@FX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0018\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR/\u0010C\u001a\u0004\u0018\u00010B2\b\u0010o\u001a\u0004\u0018\u00010B8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bF\u0010p\u001a\u0004\bv\u0010w\"\u0004\bx\u0010ER\u0018\u0010z\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010yR\u001b\u0010~\u001a\u0002048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010{\u001a\u0004\b|\u0010}R\u001c\u0010\u0081\u0001\u001a\u00020\u007f8\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0007\n\u0005\b@\u0010\u0080\u0001R\u0017\u0010\u0084\u0001\u001a\u00030\u0082\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bG\u0010\u0083\u0001R\u0017\u0010\u0087\u0001\u001a\u00030\u0085\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bD\u0010\u0086\u0001R\u001b\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0019\u0010\u0089\u0001R:\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038B@BX\u0082\u008e\u0002¢\u0006\u0015\n\u0004\bH\u0010p\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0005\b)\u0010\u008d\u0001R(\u0010\u0091\u0001\u001a\u0002042\u0006\u0010o\u001a\u0002048\u0014@RX\u0094\u000e¢\u0006\u000f\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0005\b\u0090\u0001\u0010}R\u0018\u0010\u0095\u0001\u001a\u00030\u0092\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0017\u0010\u0098\u0001\u001a\u00020\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u009b\u0001"}, d2 = {"Landroidx/compose/ui/window/PopupLayout;", "Landroidx/compose/ui/platform/AbstractComposeView;", "Lir/nasim/EX7;", "Lkotlin/Function0;", "Lir/nasim/rB7;", "onDismissRequest", "Lir/nasim/Qi5;", "properties", "", "testTag", "Landroid/view/View;", "composeView", "Lir/nasim/WH1;", "density", "Lir/nasim/Pi5;", "initialPositionProvider", "Ljava/util/UUID;", "popupId", "Lir/nasim/Ni5;", "popupLayoutHelper", "<init>", "(Lir/nasim/SA2;Lir/nasim/Qi5;Ljava/lang/String;Landroid/view/View;Lir/nasim/WH1;Lir/nasim/Pi5;Ljava/util/UUID;Lir/nasim/Ni5;)V", "q", "()V", "r", "y", "(Lir/nasim/Qi5;)V", "Lir/nasim/eu3;", "layoutDirection", "u", "(Lir/nasim/eu3;)V", "Landroid/view/WindowManager$LayoutParams;", "o", "()Landroid/view/WindowManager$LayoutParams;", "Lir/nasim/za3;", "getVisibleDisplayBounds", "()Lir/nasim/za3;", "t", "Lir/nasim/Qb1;", "parent", "content", "setContent", "(Lir/nasim/Qb1;Lir/nasim/iB2;)V", "d", "(Lir/nasim/ub1;I)V", "onAttachedToWindow", "onDetachedFromWindow", "", "widthMeasureSpec", "heightMeasureSpec", "k", "(II)V", "", "changed", "left", "top", "right", "bottom", "j", "(ZIIII)V", "Landroid/view/KeyEvent;", "event", "dispatchKeyEvent", "(Landroid/view/KeyEvent;)Z", "v", "(Lir/nasim/SA2;Lir/nasim/Qi5;Ljava/lang/String;Lir/nasim/eu3;)V", "Lir/nasim/cu3;", "parentLayoutCoordinates", "x", "(Lir/nasim/cu3;)V", "s", "w", "z", "p", "Landroid/view/MotionEvent;", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "setLayoutDirection", "(I)V", "i", "Lir/nasim/SA2;", "Lir/nasim/Qi5;", "Ljava/lang/String;", "getTestTag", "()Ljava/lang/String;", "setTestTag", "(Ljava/lang/String;)V", "l", "Landroid/view/View;", "m", "Lir/nasim/Ni5;", "Landroid/view/WindowManager;", "n", "Landroid/view/WindowManager;", "windowManager", "Landroid/view/WindowManager$LayoutParams;", "getParams$ui_release", "getParams$ui_release$annotations", "params", "Lir/nasim/Pi5;", "getPositionProvider", "()Lir/nasim/Pi5;", "setPositionProvider", "(Lir/nasim/Pi5;)V", "positionProvider", "Lir/nasim/eu3;", "getParentLayoutDirection", "()Lir/nasim/eu3;", "setParentLayoutDirection", "parentLayoutDirection", "Lir/nasim/Fa3;", "<set-?>", "Lir/nasim/Ym4;", "getPopupContentSize-bOM6tXw", "()Lir/nasim/Fa3;", "setPopupContentSize-fhxjrPA", "(Lir/nasim/Fa3;)V", "popupContentSize", "getParentLayoutCoordinates", "()Lir/nasim/cu3;", "setParentLayoutCoordinates", "Lir/nasim/za3;", "parentBounds", "Lir/nasim/aL6;", "getCanCalculatePosition", "()Z", "canCalculatePosition", "Lir/nasim/nZ1;", TokenNames.F, "maxSupportedElevation", "Landroid/graphics/Rect;", "Landroid/graphics/Rect;", "previousWindowVisibleFrame", "Landroidx/compose/runtime/snapshots/k;", "Landroidx/compose/runtime/snapshots/k;", "snapshotStateObserver", "", "Ljava/lang/Object;", "backCallback", "getContent", "()Lir/nasim/iB2;", "(Lir/nasim/iB2;)V", "A", "Z", "getShouldCreateCompositionOnAttachedToWindow", "shouldCreateCompositionOnAttachedToWindow", "", "B", "[I", "locationOnScreen", "getSubCompositionView", "()Landroidx/compose/ui/platform/AbstractComposeView;", "subCompositionView", "D", "c", "ui_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes2.dex */
public final class PopupLayout extends AbstractComposeView implements EX7 {
    private static final c D = new c(null);
    public static final int G = 8;
    private static final UA2 H = b.e;

    /* renamed from: A, reason: from kotlin metadata */
    private boolean shouldCreateCompositionOnAttachedToWindow;

    /* renamed from: B, reason: from kotlin metadata */
    private final int[] locationOnScreen;

    /* renamed from: i, reason: from kotlin metadata */
    private SA2 onDismissRequest;

    /* renamed from: j, reason: from kotlin metadata */
    private C7117Qi5 properties;

    /* renamed from: k, reason: from kotlin metadata */
    private String testTag;

    /* renamed from: l, reason: from kotlin metadata */
    private final View composeView;

    /* renamed from: m, reason: from kotlin metadata */
    private final InterfaceC6379Ni5 popupLayoutHelper;

    /* renamed from: n, reason: from kotlin metadata */
    private final WindowManager windowManager;

    /* renamed from: o, reason: from kotlin metadata */
    private final WindowManager.LayoutParams params;

    /* renamed from: p, reason: from kotlin metadata */
    private InterfaceC6873Pi5 positionProvider;

    /* renamed from: q, reason: from kotlin metadata */
    private EnumC12613eu3 parentLayoutDirection;

    /* renamed from: r, reason: from kotlin metadata */
    private final InterfaceC9102Ym4 popupContentSize;

    /* renamed from: s, reason: from kotlin metadata */
    private final InterfaceC9102Ym4 parentLayoutCoordinates;

    /* renamed from: t, reason: from kotlin metadata */
    private C25005za3 parentBounds;

    /* renamed from: u, reason: from kotlin metadata */
    private final InterfaceC9664aL6 canCalculatePosition;

    /* renamed from: v, reason: from kotlin metadata */
    private final float maxSupportedElevation;

    /* renamed from: w, reason: from kotlin metadata */
    private final Rect previousWindowVisibleFrame;

    /* renamed from: x, reason: from kotlin metadata */
    private final k snapshotStateObserver;

    /* renamed from: y, reason: from kotlin metadata */
    private Object backCallback;

    /* renamed from: z, reason: from kotlin metadata */
    private final InterfaceC9102Ym4 content;

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
        public static final b e = new b();

        b() {
            super(1);
        }

        public final void a(PopupLayout popupLayout) {
            if (popupLayout.isAttachedToWindow()) {
                popupLayout.z();
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((PopupLayout) obj);
            return C19938rB7.a;
        }
    }

    private static final class c {
        private c() {
        }

        public /* synthetic */ c(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ class d {
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

    static final class e extends AbstractC8614Ws3 implements SA2 {
        e() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            InterfaceC11379cu3 parentLayoutCoordinates = PopupLayout.this.getParentLayoutCoordinates();
            if (parentLayoutCoordinates == null || !parentLayoutCoordinates.b()) {
                parentLayoutCoordinates = null;
            }
            return Boolean.valueOf((parentLayoutCoordinates == null || PopupLayout.this.m3getPopupContentSizebOM6tXw() == null) ? false : true);
        }
    }

    static final class f extends AbstractC8614Ws3 implements UA2 {
        f() {
            super(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(SA2 sa2) {
            sa2.invoke();
        }

        public final void b(final SA2 sa2) {
            Handler handler = PopupLayout.this.getHandler();
            if ((handler != null ? handler.getLooper() : null) == Looper.myLooper()) {
                sa2.invoke();
                return;
            }
            Handler handler2 = PopupLayout.this.getHandler();
            if (handler2 != null) {
                handler2.post(new Runnable() { // from class: androidx.compose.ui.window.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        PopupLayout.f.c(sa2);
                    }
                });
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((SA2) obj);
            return C19938rB7.a;
        }
    }

    static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ C12280eL5 e;
        final /* synthetic */ PopupLayout f;
        final /* synthetic */ C25005za3 g;
        final /* synthetic */ long h;
        final /* synthetic */ long i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(C12280eL5 c12280eL5, PopupLayout popupLayout, C25005za3 c25005za3, long j, long j2) {
            super(0);
            this.e = c12280eL5;
            this.f = popupLayout;
            this.g = c25005za3;
            this.h = j;
            this.i = j2;
        }

        public final void a() {
            this.e.a = this.f.getPositionProvider().a(this.g, this.h, this.f.getParentLayoutDirection(), this.i);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PopupLayout(SA2 sa2, C7117Qi5 c7117Qi5, String str, View view, WH1 wh1, InterfaceC6873Pi5 interfaceC6873Pi5, UUID uuid, InterfaceC6379Ni5 interfaceC6379Ni5, int i, ED1 ed1) {
        InterfaceC6379Ni5 dVar;
        if ((i & 128) != 0) {
            dVar = Build.VERSION.SDK_INT >= 29 ? new androidx.compose.ui.window.d() : new androidx.compose.ui.window.e();
        } else {
            dVar = interfaceC6379Ni5;
        }
        this(sa2, c7117Qi5, str, view, wh1, interfaceC6873Pi5, uuid, dVar);
    }

    private final InterfaceC14603iB2 getContent() {
        return (InterfaceC14603iB2) this.content.getValue();
    }

    public static /* synthetic */ void getParams$ui_release$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC11379cu3 getParentLayoutCoordinates() {
        return (InterfaceC11379cu3) this.parentLayoutCoordinates.getValue();
    }

    private final C25005za3 getVisibleDisplayBounds() {
        Rect rect = this.previousWindowVisibleFrame;
        this.popupLayoutHelper.a(this.composeView, rect);
        return AbstractC6456Nq.k(rect);
    }

    private final WindowManager.LayoutParams o() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 8388659;
        layoutParams.flags = AbstractC6456Nq.i(this.properties, AbstractC6456Nq.j(this.composeView));
        layoutParams.type = 1002;
        layoutParams.token = this.composeView.getApplicationWindowToken();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.setTitle(this.composeView.getContext().getResources().getString(AbstractC9600aE5.default_popup_window_title));
        return layoutParams;
    }

    private final void q() {
        if (!this.properties.a() || Build.VERSION.SDK_INT < 33) {
            return;
        }
        if (this.backCallback == null) {
            this.backCallback = androidx.compose.ui.window.b.b(this.onDismissRequest);
        }
        androidx.compose.ui.window.b.d(this, this.backCallback);
    }

    private final void r() {
        if (Build.VERSION.SDK_INT >= 33) {
            androidx.compose.ui.window.b.e(this, this.backCallback);
        }
        this.backCallback = null;
    }

    private final void setContent(InterfaceC14603iB2 interfaceC14603iB2) {
        this.content.setValue(interfaceC14603iB2);
    }

    private final void setParentLayoutCoordinates(InterfaceC11379cu3 interfaceC11379cu3) {
        this.parentLayoutCoordinates.setValue(interfaceC11379cu3);
    }

    private final void u(EnumC12613eu3 layoutDirection) {
        int i = d.a[layoutDirection.ordinal()];
        int i2 = 1;
        if (i == 1) {
            i2 = 0;
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        super.setLayoutDirection(i2);
    }

    private final void y(C7117Qi5 properties) {
        if (AbstractC13042fc3.d(this.properties, properties)) {
            return;
        }
        if (properties.f() && !this.properties.f()) {
            WindowManager.LayoutParams layoutParams = this.params;
            layoutParams.width = -2;
            layoutParams.height = -2;
        }
        this.properties = properties;
        this.params.flags = AbstractC6456Nq.i(properties, AbstractC6456Nq.j(this.composeView));
        this.popupLayoutHelper.b(this.windowManager, this, this.params);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void d(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.W(-857613600);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-857613600, i, -1, "androidx.compose.ui.window.PopupLayout.Content (AndroidPopup.android.kt:572)");
        }
        getContent().invoke(interfaceC22053ub1, 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.Q();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (!this.properties.a()) {
            return super.dispatchKeyEvent(event);
        }
        if (event.getKeyCode() == 4 || event.getKeyCode() == 111) {
            KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
            if (keyDispatcherState == null) {
                return super.dispatchKeyEvent(event);
            }
            if (event.getAction() == 0 && event.getRepeatCount() == 0) {
                keyDispatcherState.startTracking(event, this);
                return true;
            }
            if (event.getAction() == 1 && keyDispatcherState.isTracking(event) && !event.isCanceled()) {
                SA2 sa2 = this.onDismissRequest;
                if (sa2 != null) {
                    sa2.invoke();
                }
                return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }

    public final boolean getCanCalculatePosition() {
        return ((Boolean) this.canCalculatePosition.getValue()).booleanValue();
    }

    /* renamed from: getParams$ui_release, reason: from getter */
    public final WindowManager.LayoutParams getParams() {
        return this.params;
    }

    public final EnumC12613eu3 getParentLayoutDirection() {
        return this.parentLayoutDirection;
    }

    /* renamed from: getPopupContentSize-bOM6tXw, reason: not valid java name */
    public final C4414Fa3 m3getPopupContentSizebOM6tXw() {
        return (C4414Fa3) this.popupContentSize.getValue();
    }

    public final InterfaceC6873Pi5 getPositionProvider() {
        return this.positionProvider;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    protected boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    @Override // ir.nasim.EX7
    public AbstractComposeView getSubCompositionView() {
        return this;
    }

    public final String getTestTag() {
        return this.testTag;
    }

    @Override // ir.nasim.EX7
    public /* bridge */ /* synthetic */ View getViewRoot() {
        return super.getViewRoot();
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void j(boolean changed, int left, int top, int right, int bottom) {
        View childAt;
        super.j(changed, left, top, right, bottom);
        if (this.properties.f() || (childAt = getChildAt(0)) == null) {
            return;
        }
        this.params.width = childAt.getMeasuredWidth();
        this.params.height = childAt.getMeasuredHeight();
        this.popupLayoutHelper.b(this.windowManager, this, this.params);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void k(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.properties.f()) {
            super.k(widthMeasureSpec, heightMeasureSpec);
        } else {
            C25005za3 visibleDisplayBounds = getVisibleDisplayBounds();
            super.k(View.MeasureSpec.makeMeasureSpec(visibleDisplayBounds.l(), RecyclerView.UNDEFINED_DURATION), View.MeasureSpec.makeMeasureSpec(visibleDisplayBounds.f(), RecyclerView.UNDEFINED_DURATION));
        }
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.snapshotStateObserver.t();
        q();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.snapshotStateObserver.u();
        this.snapshotStateObserver.k();
        r();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (!this.properties.b()) {
            return super.onTouchEvent(event);
        }
        if (event != null && event.getAction() == 0 && (event.getX() < 0.0f || event.getX() >= getWidth() || event.getY() < 0.0f || event.getY() >= getHeight())) {
            SA2 sa2 = this.onDismissRequest;
            if (sa2 != null) {
                sa2.invoke();
            }
            return true;
        }
        if (event == null || event.getAction() != 4) {
            return super.onTouchEvent(event);
        }
        SA2 sa22 = this.onDismissRequest;
        if (sa22 != null) {
            sa22.invoke();
        }
        return true;
    }

    public final void p() {
        VX7.b(this, null);
        this.windowManager.removeViewImmediate(this);
    }

    public final void s() {
        int[] iArr = this.locationOnScreen;
        int i = iArr[0];
        int i2 = iArr[1];
        this.composeView.getLocationOnScreen(iArr);
        int[] iArr2 = this.locationOnScreen;
        if (i == iArr2[0] && i2 == iArr2[1]) {
            return;
        }
        w();
    }

    @Override // android.view.View
    public void setLayoutDirection(int layoutDirection) {
    }

    public final void setParentLayoutDirection(EnumC12613eu3 enumC12613eu3) {
        this.parentLayoutDirection = enumC12613eu3;
    }

    /* renamed from: setPopupContentSize-fhxjrPA, reason: not valid java name */
    public final void m4setPopupContentSizefhxjrPA(C4414Fa3 c4414Fa3) {
        this.popupContentSize.setValue(c4414Fa3);
    }

    public final void setPositionProvider(InterfaceC6873Pi5 interfaceC6873Pi5) {
        this.positionProvider = interfaceC6873Pi5;
    }

    public final void setTestTag(String str) {
        this.testTag = str;
    }

    public final void t() {
        this.windowManager.addView(this, this.params);
    }

    public final void v(SA2 onDismissRequest, C7117Qi5 properties, String testTag, EnumC12613eu3 layoutDirection) {
        this.onDismissRequest = onDismissRequest;
        this.testTag = testTag;
        y(properties);
        u(layoutDirection);
    }

    public final void w() {
        InterfaceC11379cu3 parentLayoutCoordinates = getParentLayoutCoordinates();
        if (parentLayoutCoordinates != null) {
            if (!parentLayoutCoordinates.b()) {
                parentLayoutCoordinates = null;
            }
            if (parentLayoutCoordinates == null) {
                return;
            }
            long jA = parentLayoutCoordinates.a();
            long jF = AbstractC12000du3.f(parentLayoutCoordinates);
            C25005za3 c25005za3A = AbstractC3239Aa3.a(C22045ua3.f((Math.round(Float.intBitsToFloat((int) (jF >> 32))) << 32) | (4294967295L & Math.round(Float.intBitsToFloat((int) (jF & 4294967295L))))), jA);
            if (AbstractC13042fc3.d(c25005za3A, this.parentBounds)) {
                return;
            }
            this.parentBounds = c25005za3A;
            z();
        }
    }

    public final void x(InterfaceC11379cu3 parentLayoutCoordinates) {
        setParentLayoutCoordinates(parentLayoutCoordinates);
        w();
    }

    public final void z() {
        C4414Fa3 c4414Fa3M3getPopupContentSizebOM6tXw;
        C25005za3 c25005za3 = this.parentBounds;
        if (c25005za3 == null || (c4414Fa3M3getPopupContentSizebOM6tXw = m3getPopupContentSizebOM6tXw()) == null) {
            return;
        }
        long j = c4414Fa3M3getPopupContentSizebOM6tXw.j();
        C25005za3 visibleDisplayBounds = getVisibleDisplayBounds();
        long jC = C4414Fa3.c((visibleDisplayBounds.l() << 32) | (visibleDisplayBounds.f() & 4294967295L));
        C12280eL5 c12280eL5 = new C12280eL5();
        c12280eL5.a = C22045ua3.b.b();
        this.snapshotStateObserver.p(this, H, new g(c12280eL5, this, c25005za3, jC, j));
        this.params.x = C22045ua3.k(c12280eL5.a);
        this.params.y = C22045ua3.l(c12280eL5.a);
        if (this.properties.c()) {
            this.popupLayoutHelper.c(this, (int) (jC >> 32), (int) (4294967295L & jC));
        }
        this.popupLayoutHelper.b(this.windowManager, this, this.params);
    }

    public final void setContent(AbstractC7050Qb1 parent, InterfaceC14603iB2 content) {
        setParentCompositionContext(parent);
        setContent(content);
        this.shouldCreateCompositionOnAttachedToWindow = true;
    }

    public PopupLayout(SA2 sa2, C7117Qi5 c7117Qi5, String str, View view, WH1 wh1, InterfaceC6873Pi5 interfaceC6873Pi5, UUID uuid, InterfaceC6379Ni5 interfaceC6379Ni5) {
        super(view.getContext(), null, 0, 6, null);
        this.onDismissRequest = sa2;
        this.properties = c7117Qi5;
        this.testTag = str;
        this.composeView = view;
        this.popupLayoutHelper = interfaceC6379Ni5;
        Object systemService = view.getContext().getSystemService("window");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.windowManager = (WindowManager) systemService;
        this.params = o();
        this.positionProvider = interfaceC6873Pi5;
        this.parentLayoutDirection = EnumC12613eu3.a;
        this.popupContentSize = AbstractC13472gH6.d(null, null, 2, null);
        this.parentLayoutCoordinates = AbstractC13472gH6.d(null, null, 2, null);
        this.canCalculatePosition = AbstractC10222bH6.d(new e());
        float fQ = C17784nZ1.q(8);
        this.maxSupportedElevation = fQ;
        this.previousWindowVisibleFrame = new Rect();
        this.snapshotStateObserver = new k(new f());
        setId(R.id.content);
        VX7.b(this, VX7.a(view));
        YX7.b(this, YX7.a(view));
        XX7.b(this, XX7.a(view));
        setTag(AbstractC22421vC5.compose_view_saveable_id_tag, "Popup:" + uuid);
        setClipChildren(false);
        setElevation(wh1.w1(fQ));
        setOutlineProvider(new a());
        this.content = AbstractC13472gH6.d(L11.a.a(), null, 2, null);
        this.locationOnScreen = new int[2];
    }
}
