package androidx.compose.ui.tooling;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.y;
import androidx.lifecycle.j;
import androidx.lifecycle.p;
import ir.nasim.AI4;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10721c52;
import ir.nasim.AbstractC10976cX0;
import ir.nasim.AbstractC11024cc1;
import ir.nasim.AbstractC13040fc1;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13248fu2;
import ir.nasim.AbstractC13472gH6;
import ir.nasim.AbstractC13610gX0;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC15744k6;
import ir.nasim.AbstractC15886kL2;
import ir.nasim.AbstractC18108o6;
import ir.nasim.AbstractC19242q11;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC20776sb1;
import ir.nasim.AbstractC23626xE6;
import ir.nasim.AbstractC24133y6;
import ir.nasim.AbstractC5138Ib1;
import ir.nasim.AbstractC5474Jm4;
import ir.nasim.AbstractC7244Qw6;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9364Zp5;
import ir.nasim.AbstractC9766aX0;
import ir.nasim.B6;
import ir.nasim.C11333cp7;
import ir.nasim.C14819iX7;
import ir.nasim.C17469n11;
import ir.nasim.C19853r31;
import ir.nasim.C19938rB7;
import ir.nasim.C23660xI4;
import ir.nasim.C24381yX0;
import ir.nasim.C25005za3;
import ir.nasim.C5298It;
import ir.nasim.C7252Qx5;
import ir.nasim.C7289Rb6;
import ir.nasim.C7523Sb6;
import ir.nasim.C8398Vu3;
import ir.nasim.C9355Zo5;
import ir.nasim.DX0;
import ir.nasim.EB2;
import ir.nasim.EG3;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15408jX7;
import ir.nasim.InterfaceC16813lu3;
import ir.nasim.InterfaceC18060o11;
import ir.nasim.InterfaceC20208rd6;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC7518Sb1;
import ir.nasim.InterfaceC7760Tb6;
import ir.nasim.InterfaceC9102Ym4;
import ir.nasim.LW7;
import ir.nasim.MW7;
import ir.nasim.QJ5;
import ir.nasim.SA2;
import ir.nasim.TH6;
import ir.nasim.UA2;
import ir.nasim.VX7;
import ir.nasim.XG3;
import ir.nasim.XX7;
import ir.nasim.YX7;
import ir.nasim.ZA4;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\t*\b\u0080\u0001\u0083\u0001\u0086\u0001\u0089\u0001\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nJ\u0013\u0010\r\u001a\u00020\f*\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\f*\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u0013\u0010\u0011\u001a\u00020\u0010*\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0015J\u0013\u0010\u0018\u001a\u00020\f*\u00020\u000bH\u0002¢\u0006\u0004\b\u0018\u0010\u000eJ\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001b*\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010 \u001a\u0004\u0018\u00010\u001f*\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J%\u0010$\u001a\u0004\u0018\u00010\u001b*\u00020\u001e2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\bH\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0013H\u0002¢\u0006\u0004\b&\u0010\u0015J\u001d\u0010)\u001a\u00020\u00132\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00130'H\u0003¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b+\u0010,J7\u00102\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\bH\u0014¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0013H\u0014¢\u0006\u0004\b4\u0010\u0015J\u0017\u00107\u001a\u00020\u00132\u0006\u00106\u001a\u000205H\u0014¢\u0006\u0004\b7\u00108J\u009f\u0001\u0010H\u001a\u00020\u00132\u0006\u00109\u001a\u00020\u001b2\u0006\u0010:\u001a\u00020\u001b2\u0016\b\u0002\u0010=\u001a\u0010\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030<\u0018\u00010;2\b\b\u0002\u0010>\u001a\u00020\b2\b\b\u0002\u0010?\u001a\u00020\f2\b\b\u0002\u0010@\u001a\u00020\f2\b\b\u0002\u0010B\u001a\u00020A2\b\b\u0002\u0010C\u001a\u00020\f2\b\b\u0002\u0010D\u001a\u00020\f2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u001b2\u000e\b\u0002\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00130'2\u000e\b\u0002\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00130'H\u0001¢\u0006\u0004\bH\u0010IR\u0014\u0010K\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b)\u0010JR\u0014\u0010O\u001a\u00020L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010@\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010?\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010QR(\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00100S8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR(\u0010^\u001a\b\u0012\u0004\u0012\u00020\u001b0S8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b[\u0010U\u001a\u0004\b\\\u0010W\"\u0004\b]\u0010YR\u0014\u0010a\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010`R\u0016\u0010b\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010JR\u0016\u0010c\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010QR\u0014\u0010f\u001a\u00020d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010eR\u001c\u0010i\u001a\b\u0012\u0004\u0012\u00020\u00130'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR&\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130'0j8\u0002X\u0082\u0004¢\u0006\f\n\u0004\bk\u0010l\u0012\u0004\bm\u0010\u0015R\u0016\u0010C\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010QR\u0016\u0010D\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010QR\u0016\u0010E\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010JR\u001c\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00130'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010nR\"\u0010t\u001a\u00020\f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bo\u0010Q\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u0014\u0010w\u001a\u00020u8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010vR(\u0010\u007f\u001a\u00020x8\u0000@\u0000X\u0081.¢\u0006\u0018\n\u0004\b$\u0010y\u0012\u0004\b~\u0010\u0015\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R\u0017\u0010\u0082\u0001\u001a\u00030\u0080\u00018\u0002X\u0083\u0004¢\u0006\u0007\n\u0005\b\u000f\u0010\u0081\u0001R\u0017\u0010\u0085\u0001\u001a\u00030\u0083\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0014\u0010\u0084\u0001R\u0017\u0010\u0088\u0001\u001a\u00030\u0086\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0011\u0010\u0087\u0001R\u0018\u0010\u008c\u0001\u001a\u00030\u0089\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001a\u0010\u008e\u0001\u001a\u00020\u001b*\u00020\u000b8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bg\u0010\u008d\u0001R\u001a\u0010\u0090\u0001\u001a\u00020\b*\u00020\u000b8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bk\u0010\u008f\u0001¨\u0006\u0091\u0001"}, d2 = {"Landroidx/compose/ui/tooling/ComposeViewAdapter;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/kL2;", "", "n", "(Lir/nasim/kL2;)Z", "t", "Lir/nasim/LW7;", "v", "(Lir/nasim/kL2;)Lir/nasim/LW7;", "Lir/nasim/rB7;", "u", "()V", "g", "h", "m", "Lir/nasim/za3;", "box", "", "j", "(Lir/nasim/kL2;Lir/nasim/za3;)Ljava/lang/String;", "", "Ljava/lang/reflect/Method;", "i", "(Ljava/lang/Object;)Ljava/lang/reflect/Method;", "x", "y", "s", "(Ljava/lang/Object;II)Ljava/lang/String;", "r", "Lkotlin/Function0;", "content", "a", "(Lir/nasim/iB2;Lir/nasim/ub1;I)V", "o", "(Landroid/util/AttributeSet;)V", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "onAttachedToWindow", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "className", "methodName", "Ljava/lang/Class;", "Lir/nasim/Up5;", "parameterProvider", "parameterProviderIndex", "debugPaintBounds", "debugViewInfos", "", "animationClockStartTime", "forceCompositionInvalidation", "lookForDesignInfoProviders", "designInfoProvidersArgument", "onCommit", "onDraw", "p", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;IZZJZZLjava/lang/String;Lir/nasim/SA2;Lir/nasim/SA2;)V", "Ljava/lang/String;", "TAG", "Landroidx/compose/ui/platform/ComposeView;", "b", "Landroidx/compose/ui/platform/ComposeView;", "composeView", "c", "Z", "d", "", "e", "Ljava/util/List;", "getViewInfos$ui_tooling_release", "()Ljava/util/List;", "setViewInfos$ui_tooling_release", "(Ljava/util/List;)V", "viewInfos", "f", "getDesignInfoList$ui_tooling_release", "setDesignInfoList$ui_tooling_release", "designInfoList", "Landroidx/compose/ui/tooling/a;", "Landroidx/compose/ui/tooling/a;", "slotTableRecord", "composableName", "hasAnimations", "Lir/nasim/cp7;", "Lir/nasim/cp7;", "delayedException", "k", "Lir/nasim/iB2;", "previewComposition", "Lir/nasim/Ym4;", "l", "Lir/nasim/Ym4;", "getContent$annotations", "Lir/nasim/SA2;", "q", "getStitchTrees$ui_tooling_release", "()Z", "setStitchTrees$ui_tooling_release", "(Z)V", "stitchTrees", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "debugBoundsPaint", "Lir/nasim/Zo5;", "Lir/nasim/Zo5;", "getClock$ui_tooling_release", "()Lir/nasim/Zo5;", "setClock$ui_tooling_release", "(Lir/nasim/Zo5;)V", "getClock$ui_tooling_release$annotations", "clock", "androidx/compose/ui/tooling/ComposeViewAdapter$c", "Landroidx/compose/ui/tooling/ComposeViewAdapter$c;", "FakeSavedStateRegistryOwner", "androidx/compose/ui/tooling/ComposeViewAdapter$d", "Landroidx/compose/ui/tooling/ComposeViewAdapter$d;", "FakeViewModelStoreOwner", "androidx/compose/ui/tooling/ComposeViewAdapter$b", "Landroidx/compose/ui/tooling/ComposeViewAdapter$b;", "FakeOnBackPressedDispatcherOwner", "androidx/compose/ui/tooling/ComposeViewAdapter$a", "w", "Landroidx/compose/ui/tooling/ComposeViewAdapter$a;", "FakeActivityResultRegistryOwner", "(Lir/nasim/kL2;)Ljava/lang/String;", "fileName", "(Lir/nasim/kL2;)I", "lineNumber", "ui-tooling_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes2.dex */
public final class ComposeViewAdapter extends FrameLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private final String TAG;

    /* renamed from: b, reason: from kotlin metadata */
    private final ComposeView composeView;

    /* renamed from: c, reason: from kotlin metadata */
    private boolean debugViewInfos;

    /* renamed from: d, reason: from kotlin metadata */
    private boolean debugPaintBounds;

    /* renamed from: e, reason: from kotlin metadata */
    private List viewInfos;

    /* renamed from: f, reason: from kotlin metadata */
    private List designInfoList;

    /* renamed from: g, reason: from kotlin metadata */
    private final androidx.compose.ui.tooling.a slotTableRecord;

    /* renamed from: h, reason: from kotlin metadata */
    private String composableName;

    /* renamed from: i, reason: from kotlin metadata */
    private boolean hasAnimations;

    /* renamed from: j, reason: from kotlin metadata */
    private final C11333cp7 delayedException;

    /* renamed from: k, reason: from kotlin metadata */
    private InterfaceC14603iB2 previewComposition;

    /* renamed from: l, reason: from kotlin metadata */
    private final InterfaceC9102Ym4 content;

    /* renamed from: m, reason: from kotlin metadata */
    private boolean forceCompositionInvalidation;

    /* renamed from: n, reason: from kotlin metadata */
    private boolean lookForDesignInfoProviders;

    /* renamed from: o, reason: from kotlin metadata */
    private String designInfoProvidersArgument;

    /* renamed from: p, reason: from kotlin metadata */
    private SA2 onDraw;

    /* renamed from: q, reason: from kotlin metadata */
    private boolean stitchTrees;

    /* renamed from: r, reason: from kotlin metadata */
    private final Paint debugBoundsPaint;

    /* renamed from: s, reason: from kotlin metadata */
    public C9355Zo5 clock;

    /* renamed from: t, reason: from kotlin metadata */
    private final c FakeSavedStateRegistryOwner;

    /* renamed from: u, reason: from kotlin metadata */
    private final d FakeViewModelStoreOwner;

    /* renamed from: v, reason: from kotlin metadata */
    private final b FakeOnBackPressedDispatcherOwner;

    /* renamed from: w, reason: from kotlin metadata */
    private final a FakeActivityResultRegistryOwner;

    public static final class a implements B6 {
        private final C0070a a = new C0070a();

        /* renamed from: androidx.compose.ui.tooling.ComposeViewAdapter$a$a, reason: collision with other inner class name */
        public static final class C0070a extends AbstractC24133y6 {
            C0070a() {
            }

            @Override // ir.nasim.AbstractC24133y6
            public void i(int i, AbstractC18108o6 abstractC18108o6, Object obj, AbstractC15744k6 abstractC15744k6) {
                throw new IllegalStateException("Calling launch() is not supported in Preview");
            }
        }

        a() {
        }

        @Override // ir.nasim.B6
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0070a getActivityResultRegistry() {
            return this.a;
        }
    }

    public static final class b implements AI4 {
        private final C23660xI4 a = new C23660xI4(null, 1, null);

        b() {
        }

        @Override // ir.nasim.InterfaceC18633oz3
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p getLifecycle() {
            return ComposeViewAdapter.this.FakeSavedStateRegistryOwner.b();
        }

        @Override // ir.nasim.AI4
        public C23660xI4 z2() {
            return this.a;
        }
    }

    public static final class c implements InterfaceC7760Tb6 {
        private final p a;
        private final C7523Sb6 b;

        c() {
            p pVarA = p.k.a(this);
            this.a = pVarA;
            C7523Sb6 c7523Sb6A = C7523Sb6.d.a(this);
            c7523Sb6A.d(new Bundle());
            this.b = c7523Sb6A;
            pVarA.n(j.b.RESUMED);
        }

        @Override // ir.nasim.InterfaceC18633oz3
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p getLifecycle() {
            return this.a;
        }

        public final p b() {
            return this.a;
        }

        @Override // ir.nasim.InterfaceC7760Tb6
        public C7289Rb6 v1() {
            return this.b.b();
        }
    }

    public static final class d implements InterfaceC15408jX7 {
        private final C14819iX7 a;
        private final C14819iX7 b;

        d() {
            C14819iX7 c14819iX7 = new C14819iX7();
            this.a = c14819iX7;
            this.b = c14819iX7;
        }

        @Override // ir.nasim.InterfaceC15408jX7
        public C14819iX7 d1() {
            return this.b;
        }
    }

    static final class e extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC14603iB2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(InterfaceC14603iB2 interfaceC14603iB2) {
            super(2);
            this.f = interfaceC14603iB2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1475548980, i, -1, "androidx.compose.ui.tooling.ComposeViewAdapter.WrapPreview.<anonymous> (ComposeViewAdapter.android.kt:413)");
            }
            androidx.compose.ui.tooling.c.a(ComposeViewAdapter.this.slotTableRecord, this.f, interfaceC22053ub1, 0);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class f extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC14603iB2 f;
        final /* synthetic */ int g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(InterfaceC14603iB2 interfaceC14603iB2, int i) {
            super(2);
            this.f = interfaceC14603iB2;
            this.g = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            ComposeViewAdapter.this.a(this.f, interfaceC22053ub1, QJ5.a(this.g | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* synthetic */ class h extends EB2 implements SA2 {
        h(Object obj) {
            super(0, obj, ComposeViewAdapter.class, "requestLayout", "requestLayout()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((ComposeViewAdapter) this.receiver).requestLayout();
        }
    }

    static final class i extends AbstractC8614Ws3 implements UA2 {
        i() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(AbstractC15886kL2 abstractC15886kL2) {
            boolean z;
            if (!AbstractC13042fc3.d(abstractC15886kL2.f(), "remember") && ComposeViewAdapter.this.m(abstractC15886kL2)) {
                z = true;
                break;
            }
            Collection<AbstractC15886kL2> collectionB = abstractC15886kL2.b();
            ComposeViewAdapter composeViewAdapter = ComposeViewAdapter.this;
            if (!(collectionB instanceof Collection) || !collectionB.isEmpty()) {
                for (AbstractC15886kL2 abstractC15886kL22 : collectionB) {
                    if (AbstractC13042fc3.d(abstractC15886kL22.f(), "remember") && composeViewAdapter.m(abstractC15886kL22)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            return Boolean.valueOf(z);
        }
    }

    static final class j extends AbstractC8614Ws3 implements SA2 {
        public static final j e = new j();

        j() {
            super(0);
        }

        public final void a() {
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    static final class k extends AbstractC8614Ws3 implements SA2 {
        public static final k e = new k();

        k() {
            super(0);
        }

        public final void a() {
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    static final class l extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ ComposeViewAdapter f;
        final /* synthetic */ String g;
        final /* synthetic */ String h;
        final /* synthetic */ Class i;
        final /* synthetic */ int j;
        final /* synthetic */ long k;

        static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ String e;
            final /* synthetic */ String f;
            final /* synthetic */ Class g;
            final /* synthetic */ int h;
            final /* synthetic */ ComposeViewAdapter i;
            final /* synthetic */ long j;

            /* renamed from: androidx.compose.ui.tooling.ComposeViewAdapter$l$a$a, reason: collision with other inner class name */
            static final class C0071a extends AbstractC8614Ws3 implements SA2 {
                final /* synthetic */ ComposeViewAdapter e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0071a(ComposeViewAdapter composeViewAdapter) {
                    super(0);
                    this.e = composeViewAdapter;
                }

                public final void a() {
                    View childAt = this.e.getChildAt(0);
                    AbstractC13042fc3.g(childAt, "null cannot be cast to non-null type androidx.compose.ui.platform.ComposeView");
                    KeyEvent.Callback childAt2 = ((ComposeView) childAt).getChildAt(0);
                    y yVar = childAt2 instanceof y ? (y) childAt2 : null;
                    if (yVar != null) {
                        yVar.z();
                    }
                    androidx.compose.runtime.snapshots.g.e.m();
                }

                @Override // ir.nasim.SA2
                public /* bridge */ /* synthetic */ Object invoke() {
                    a();
                    return C19938rB7.a;
                }
            }

            static final class b extends AbstractC8614Ws3 implements SA2 {
                final /* synthetic */ String e;
                final /* synthetic */ String f;
                final /* synthetic */ InterfaceC22053ub1 g;
                final /* synthetic */ Class h;
                final /* synthetic */ int i;
                final /* synthetic */ ComposeViewAdapter j;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                b(String str, String str2, InterfaceC22053ub1 interfaceC22053ub1, Class cls, int i, ComposeViewAdapter composeViewAdapter) {
                    super(0);
                    this.e = str;
                    this.f = str2;
                    this.g = interfaceC22053ub1;
                    this.h = cls;
                    this.i = i;
                    this.j = composeViewAdapter;
                }

                public final void a() {
                    Throwable cause;
                    try {
                        C17469n11 c17469n11 = C17469n11.a;
                        String str = this.e;
                        String str2 = this.f;
                        InterfaceC22053ub1 interfaceC22053ub1 = this.g;
                        Object[] objArrF = AbstractC9364Zp5.f(this.h, this.i);
                        c17469n11.g(str, str2, interfaceC22053ub1, Arrays.copyOf(objArrF, objArrF.length));
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        while ((th2 instanceof ReflectiveOperationException) && (cause = th2.getCause()) != null) {
                            th2 = cause;
                        }
                        this.j.delayedException.a(th2);
                        throw th;
                    }
                }

                @Override // ir.nasim.SA2
                public /* bridge */ /* synthetic */ Object invoke() {
                    a();
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str, String str2, Class cls, int i, ComposeViewAdapter composeViewAdapter, long j) {
                super(2);
                this.e = str;
                this.f = str2;
                this.g = cls;
                this.h = i;
                this.i = composeViewAdapter;
                this.j = j;
            }

            /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r9v8 ??, still in use, count: 1, list:
                  (r9v8 ?? I:java.lang.Object) from 0x0065: INVOKE (r8v0 ?? I:ir.nasim.ub1), (r9v8 ?? I:java.lang.Object) INTERFACE call: ir.nasim.ub1.s(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:102)
                	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
                	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
                	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
                	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
                	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
                	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
                */
            public final void a(
            /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r9v8 ??, still in use, count: 1, list:
                  (r9v8 ?? I:java.lang.Object) from 0x0065: INVOKE (r8v0 ?? I:ir.nasim.ub1), (r9v8 ?? I:java.lang.Object) INTERFACE call: ir.nasim.ub1.s(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:102)
                	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
                	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
                	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
                	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
                	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
                */
            /*  JADX ERROR: Method generation error
                jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r8v0 ??
                	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:405)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                */

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(SA2 sa2, ComposeViewAdapter composeViewAdapter, String str, String str2, Class cls, int i, long j) {
            super(2);
            this.e = sa2;
            this.f = composeViewAdapter;
            this.g = str;
            this.h = str2;
            this.i = cls;
            this.j = i;
            this.k = j;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-2046245106, i, -1, "androidx.compose.ui.tooling.ComposeViewAdapter.init.<anonymous> (ComposeViewAdapter.android.kt:466)");
            }
            AbstractC10721c52.i(this.e, interfaceC22053ub1, 0);
            ComposeViewAdapter composeViewAdapter = this.f;
            composeViewAdapter.a(AbstractC19242q11.e(320194433, true, new a(this.g, this.h, this.i, this.j, composeViewAdapter, this.k), interfaceC22053ub1, 54), interfaceC22053ub1, 6);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class m extends AbstractC8614Ws3 implements SA2 {
        public static final m e = new m();

        m() {
            super(0);
        }

        public final void a() {
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    public ComposeViewAdapter(Context context, AttributeSet attributeSet) throws NumberFormatException {
        super(context, attributeSet);
        this.TAG = "ComposeViewAdapter";
        this.composeView = new ComposeView(getContext(), null, 0, 6, null);
        this.viewInfos = AbstractC10360bX0.m();
        this.designInfoList = AbstractC10360bX0.m();
        this.slotTableRecord = androidx.compose.ui.tooling.a.a.a();
        this.composableName = "";
        this.delayedException = new C11333cp7();
        this.previewComposition = C19853r31.a.b();
        this.content = AbstractC13472gH6.d(AbstractC20776sb1.a, null, 2, null);
        this.designInfoProvidersArgument = "";
        this.onDraw = m.e;
        this.stitchTrees = true;
        Paint paint = new Paint();
        paint.setPathEffect(new DashPathEffect(new float[]{5.0f, 10.0f, 15.0f, 20.0f}, 0.0f));
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(DX0.k(C24381yX0.b.g()));
        this.debugBoundsPaint = paint;
        this.FakeSavedStateRegistryOwner = new c();
        this.FakeViewModelStoreOwner = new d();
        this.FakeOnBackPressedDispatcherOwner = new b();
        this.FakeActivityResultRegistryOwner = new a();
        o(attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(522143116);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(interfaceC14603iB2) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(this) ? 32 : 16;
        }
        if (interfaceC22053ub1J.o((i3 & 19) != 18, i3 & 1)) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(522143116, i3, -1, "androidx.compose.ui.tooling.ComposeViewAdapter.WrapPreview (ComposeViewAdapter.android.kt:402)");
            }
            AbstractC11024cc1.b(new C7252Qx5[]{AbstractC13040fc1.j().d(new C8398Vu3(getContext())), AbstractC13040fc1.i().d(AbstractC13248fu2.a(getContext())), XG3.a.b(this.FakeOnBackPressedDispatcherOwner), EG3.a.b(this.FakeActivityResultRegistryOwner)}, AbstractC19242q11.e(-1475548980, true, new e(interfaceC14603iB2), interfaceC22053ub1J, 54), interfaceC22053ub1J, C7252Qx5.i | 48);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new f(interfaceC14603iB2, i2));
        }
    }

    private final void g() {
        Set setA = this.slotTableRecord.a();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(setA, 10));
        Iterator it = setA.iterator();
        while (it.hasNext()) {
            arrayList.add(AbstractC23626xE6.b((InterfaceC7518Sb1) it.next()));
        }
        boolean z = this.clock != null;
        C5298It c5298It = new C5298It(new AbstractC5474Jm4(this) { // from class: androidx.compose.ui.tooling.ComposeViewAdapter.g
            @Override // ir.nasim.InterfaceC3820Cm3
            public Object get() {
                return ((ComposeViewAdapter) this.receiver).getClock$ui_tooling_release();
            }
        }, new h(this));
        boolean zF = c5298It.f(arrayList);
        this.hasAnimations = zF;
        if (z && zF) {
            c5298It.d(arrayList);
        }
    }

    public static /* synthetic */ void getClock$ui_tooling_release$annotations() {
    }

    private static /* synthetic */ void getContent$annotations() {
    }

    private final void h() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Set setA = this.slotTableRecord.a();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(setA, 10));
        Iterator it = setA.iterator();
        while (it.hasNext()) {
            arrayList.add(AbstractC23626xE6.b((InterfaceC7518Sb1) it.next()));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            List<AbstractC15886kL2> listB = AbstractC9364Zp5.b((AbstractC15886kL2) it2.next(), new i());
            ArrayList arrayList3 = new ArrayList();
            for (AbstractC15886kL2 abstractC15886kL2 : listB) {
                String strJ = j(abstractC15886kL2, abstractC15886kL2.a());
                if (strJ == null) {
                    Iterator it3 = abstractC15886kL2.b().iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            strJ = null;
                            break;
                        }
                        String strJ2 = j((AbstractC15886kL2) it3.next(), abstractC15886kL2.a());
                        if (strJ2 != null) {
                            strJ = strJ2;
                            break;
                        }
                    }
                }
                if (strJ != null) {
                    arrayList3.add(strJ);
                }
            }
            AbstractC13610gX0.D(arrayList2, arrayList3);
        }
        this.designInfoList = arrayList2;
    }

    private final Method i(Object obj) {
        try {
            Class<?> cls = obj.getClass();
            Class cls2 = Integer.TYPE;
            return cls.getDeclaredMethod("getDesignInfo", cls2, cls2, String.class);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private final String j(AbstractC15886kL2 abstractC15886kL2, C25005za3 c25005za3) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String strS;
        Iterator it = abstractC15886kL2.c().iterator();
        do {
            strS = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (next != null) {
                strS = s(next, c25005za3.g(), c25005za3.h());
            }
        } while (strS == null);
        return strS;
    }

    private final String k(AbstractC15886kL2 abstractC15886kL2) {
        String strD;
        TH6 th6D = abstractC15886kL2.d();
        return (th6D == null || (strD = th6D.d()) == null) ? "" : strD;
    }

    private final int l(AbstractC15886kL2 abstractC15886kL2) {
        TH6 th6D = abstractC15886kL2.d();
        if (th6D != null) {
            return th6D.b();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean m(AbstractC15886kL2 abstractC15886kL2) {
        Collection collectionC = abstractC15886kL2.c();
        if ((collectionC instanceof Collection) && collectionC.isEmpty()) {
            return false;
        }
        Iterator it = collectionC.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if ((next != null ? i(next) : null) != null) {
                return true;
            }
        }
        return false;
    }

    private final boolean n(AbstractC15886kL2 abstractC15886kL2) {
        return k(abstractC15886kL2).length() == 0 && l(abstractC15886kL2) == -1;
    }

    private final void o(AttributeSet attrs) throws NumberFormatException {
        long j2;
        VX7.b(this, this.FakeSavedStateRegistryOwner);
        XX7.b(this, this.FakeSavedStateRegistryOwner);
        YX7.b(this, this.FakeViewModelStoreOwner);
        addView(this.composeView);
        String attributeValue = attrs.getAttributeValue("http://schemas.android.com/tools", "composableName");
        if (attributeValue == null) {
            return;
        }
        String strK1 = AbstractC20762sZ6.k1(attributeValue, '.', null, 2, null);
        String strC1 = AbstractC20762sZ6.c1(attributeValue, '.', null, 2, null);
        int attributeIntValue = attrs.getAttributeIntValue("http://schemas.android.com/tools", "parameterProviderIndex", 0);
        String attributeValue2 = attrs.getAttributeValue("http://schemas.android.com/tools", "parameterProviderClass");
        Class clsA = attributeValue2 != null ? AbstractC9364Zp5.a(attributeValue2) : null;
        try {
            j2 = Long.parseLong(attrs.getAttributeValue("http://schemas.android.com/tools", "animationClockStartTime"));
        } catch (Exception unused) {
            j2 = -1;
        }
        q(this, strK1, strC1, clsA, attributeIntValue, attrs.getAttributeBooleanValue("http://schemas.android.com/tools", "paintBounds", this.debugPaintBounds), attrs.getAttributeBooleanValue("http://schemas.android.com/tools", "printViewInfos", this.debugViewInfos), j2, attrs.getAttributeBooleanValue("http://schemas.android.com/tools", "forceCompositionInvalidation", false), attrs.getAttributeBooleanValue("http://schemas.android.com/tools", "findDesignInfoProviders", this.lookForDesignInfoProviders), attrs.getAttributeValue("http://schemas.android.com/tools", "designInfoProvidersArgument"), null, null, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, null);
    }

    public static /* synthetic */ void q(ComposeViewAdapter composeViewAdapter, String str, String str2, Class cls, int i2, boolean z, boolean z2, long j2, boolean z3, boolean z4, String str3, SA2 sa2, SA2 sa22, int i3, Object obj) {
        composeViewAdapter.p(str, str2, (i3 & 4) != 0 ? null : cls, (i3 & 8) != 0 ? 0 : i2, (i3 & 16) != 0 ? false : z, (i3 & 32) != 0 ? false : z2, (i3 & 64) != 0 ? -1L : j2, (i3 & 128) != 0 ? false : z3, (i3 & 256) != 0 ? false : z4, (i3 & 512) != 0 ? null : str3, (i3 & 1024) != 0 ? j.e : sa2, (i3 & 2048) != 0 ? k.e : sa22);
    }

    private final void r() {
        this.content.setValue(C19853r31.a.c());
        this.content.setValue(this.previewComposition);
        invalidate();
    }

    private final String s(Object obj, int i2, int i3) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method methodI = i(obj);
        if (methodI == null) {
            return null;
        }
        try {
            Object objInvoke = methodI.invoke(obj, Integer.valueOf(i2), Integer.valueOf(i3), this.designInfoProvidersArgument);
            AbstractC13042fc3.g(objInvoke, "null cannot be cast to non-null type kotlin.String");
            String str = (String) objInvoke;
            if (str.length() == 0) {
                return null;
            }
            return str;
        } catch (Exception unused) {
            return null;
        }
    }

    private final boolean t(AbstractC15886kL2 abstractC15886kL2) {
        if (n(abstractC15886kL2) && abstractC15886kL2.b().isEmpty()) {
            ZA4 za4 = abstractC15886kL2 instanceof ZA4 ? (ZA4) abstractC15886kL2 : null;
            Object objG = za4 != null ? za4.g() : null;
            if ((objG instanceof InterfaceC16813lu3 ? (InterfaceC16813lu3) objG : null) == null) {
                return true;
            }
        }
        return false;
    }

    private final void u() {
        Set setA = this.slotTableRecord.a();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(setA, 10));
        Iterator it = setA.iterator();
        while (it.hasNext()) {
            arrayList.add(v(AbstractC23626xE6.b((InterfaceC7518Sb1) it.next())));
        }
        List listM1 = AbstractC15401jX0.m1(arrayList);
        if (this.stitchTrees) {
            listM1 = AbstractC7244Qw6.a(listM1);
        }
        this.viewInfos = listM1;
        if (this.debugViewInfos) {
            Log.d(this.TAG, MW7.c(listM1, 0, null, 3, null));
        }
    }

    private final LW7 v(AbstractC15886kL2 abstractC15886kL2) {
        String strD;
        ZA4 za4 = abstractC15886kL2 instanceof ZA4 ? (ZA4) abstractC15886kL2 : null;
        Object objG = za4 != null ? za4.g() : null;
        InterfaceC16813lu3 interfaceC16813lu3 = objG instanceof InterfaceC16813lu3 ? (InterfaceC16813lu3) objG : null;
        if (abstractC15886kL2.b().size() == 1 && n(abstractC15886kL2) && interfaceC16813lu3 == null) {
            return v((AbstractC15886kL2) AbstractC15401jX0.U0(abstractC15886kL2.b()));
        }
        Collection collectionB = abstractC15886kL2.b();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionB) {
            if (!t((AbstractC15886kL2) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(v((AbstractC15886kL2) it.next()));
        }
        TH6 th6D = abstractC15886kL2.d();
        if (th6D == null || (strD = th6D.d()) == null) {
            strD = "";
        }
        String str = strD;
        TH6 th6D2 = abstractC15886kL2.d();
        return new LW7(str, th6D2 != null ? th6D2.b() : -1, abstractC15886kL2.a(), abstractC15886kL2.d(), arrayList2, interfaceC16813lu3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.forceCompositionInvalidation) {
            r();
        }
        this.onDraw.invoke();
        if (this.debugPaintBounds) {
            List<LW7> list = this.viewInfos;
            ArrayList<LW7> arrayList = new ArrayList();
            for (LW7 lw7 : list) {
                AbstractC13610gX0.D(arrayList, AbstractC15401jX0.R0(AbstractC9766aX0.e(lw7), lw7.a()));
            }
            for (LW7 lw72 : arrayList) {
                if (lw72.h()) {
                    canvas.drawRect(new Rect(lw72.b().g(), lw72.b().j(), lw72.b().h(), lw72.b().d()), this.debugBoundsPaint);
                }
            }
        }
    }

    public final C9355Zo5 getClock$ui_tooling_release() {
        C9355Zo5 c9355Zo5 = this.clock;
        if (c9355Zo5 != null) {
            return c9355Zo5;
        }
        AbstractC13042fc3.y("clock");
        return null;
    }

    public final List<String> getDesignInfoList$ui_tooling_release() {
        return this.designInfoList;
    }

    /* renamed from: getStitchTrees$ui_tooling_release, reason: from getter */
    public final boolean getStitchTrees() {
        return this.stitchTrees;
    }

    public final List<LW7> getViewInfos$ui_tooling_release() {
        return this.viewInfos;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        VX7.b(this.composeView.getRootView(), this.FakeSavedStateRegistryOwner);
        super.onAttachedToWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onLayout(changed, left, top, right, bottom);
        this.delayedException.b();
        u();
        if (this.composableName.length() > 0) {
            g();
            if (this.lookForDesignInfoProviders) {
                h();
            }
        }
    }

    public final void p(String className, String methodName, Class parameterProvider, int parameterProviderIndex, boolean debugPaintBounds, boolean debugViewInfos, long animationClockStartTime, boolean forceCompositionInvalidation, boolean lookForDesignInfoProviders, String designInfoProvidersArgument, SA2 onCommit, SA2 onDraw) {
        this.debugPaintBounds = debugPaintBounds;
        this.debugViewInfos = debugViewInfos;
        this.composableName = methodName;
        this.forceCompositionInvalidation = forceCompositionInvalidation;
        this.lookForDesignInfoProviders = lookForDesignInfoProviders;
        this.designInfoProvidersArgument = designInfoProvidersArgument == null ? "" : designInfoProvidersArgument;
        this.onDraw = onDraw;
        InterfaceC18060o11 interfaceC18060o11C = AbstractC19242q11.c(-2046245106, true, new l(onCommit, this, className, methodName, parameterProvider, parameterProviderIndex, animationClockStartTime));
        this.previewComposition = interfaceC18060o11C;
        this.composeView.setContent(interfaceC18060o11C);
        invalidate();
    }

    public final void setClock$ui_tooling_release(C9355Zo5 c9355Zo5) {
        this.clock = c9355Zo5;
    }

    public final void setDesignInfoList$ui_tooling_release(List<String> list) {
        this.designInfoList = list;
    }

    public final void setStitchTrees$ui_tooling_release(boolean z) {
        this.stitchTrees = z;
    }

    public final void setViewInfos$ui_tooling_release(List<LW7> list) {
        this.viewInfos = list;
    }

    public ComposeViewAdapter(Context context, AttributeSet attributeSet, int i2) throws NumberFormatException {
        super(context, attributeSet, i2);
        this.TAG = "ComposeViewAdapter";
        this.composeView = new ComposeView(getContext(), null, 0, 6, null);
        this.viewInfos = AbstractC10360bX0.m();
        this.designInfoList = AbstractC10360bX0.m();
        this.slotTableRecord = androidx.compose.ui.tooling.a.a.a();
        this.composableName = "";
        this.delayedException = new C11333cp7();
        this.previewComposition = C19853r31.a.b();
        this.content = AbstractC13472gH6.d(AbstractC20776sb1.a, null, 2, null);
        this.designInfoProvidersArgument = "";
        this.onDraw = m.e;
        this.stitchTrees = true;
        Paint paint = new Paint();
        paint.setPathEffect(new DashPathEffect(new float[]{5.0f, 10.0f, 15.0f, 20.0f}, 0.0f));
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(DX0.k(C24381yX0.b.g()));
        this.debugBoundsPaint = paint;
        this.FakeSavedStateRegistryOwner = new c();
        this.FakeViewModelStoreOwner = new d();
        this.FakeOnBackPressedDispatcherOwner = new b();
        this.FakeActivityResultRegistryOwner = new a();
        o(attributeSet);
    }
}
