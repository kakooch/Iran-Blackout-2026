package ir.nasim.features.smiles.widget;

import android.R;
import android.content.Context;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.drawable.RippleDrawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC22360v62;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C19938rB7;
import ir.nasim.C5161Id6;
import ir.nasim.ED1;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.SA2;
import ir.nasim.features.smiles.widget.EmojiRecyclerView;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0002IJB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000e\u001a\u00020\r*\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0017\u001a\u00020\r2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001e\u0010\u0014R\u0018\u0010!\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001b\u0010,\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010/R\u0016\u00104\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010/R\u0016\u00106\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010/R\u0016\u00109\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00108R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u001e\u0010B\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR2\u0010H\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020D0Cj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020D`E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010G¨\u0006K"}, d2 = {"Lir/nasim/features/smiles/widget/EmojiRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/features/smiles/widget/ImageViewEmoji;", "", "override", "Lir/nasim/rB7;", "o1", "(Lir/nasim/features/smiles/widget/ImageViewEmoji;Ljava/lang/String;)V", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "Lkotlin/Function0;", "listener", "setClearRecentListener", "(Lir/nasim/SA2;)V", "Landroid/view/View;", "view", "k1", "(Landroid/view/View;)V", "ev", "dispatchTouchEvent", "B1", "Lir/nasim/features/smiles/widget/ImageViewEmoji;", "emojiTouchedView", "Lir/nasim/features/smiles/widget/c;", "C1", "Lir/nasim/Yu3;", "getPickerView", "()Lir/nasim/features/smiles/widget/c;", "pickerView", "Lir/nasim/features/smiles/widget/d;", "D1", "getPickerViewPopup", "()Lir/nasim/features/smiles/widget/d;", "pickerViewPopup", "", "E1", TokenNames.F, "emojiLastX", "F1", "emojiLastY", "G1", "emojiTouchedX", "H1", "emojiTouchedY", "I1", TokenNames.I, "popupWidth", "J1", "popupHeight", "", "K1", "[I", "location", "L1", "Lir/nasim/SA2;", "onClearRecentListener", "Ljava/util/HashMap;", "Lir/nasim/features/smiles/widget/EmojiRecyclerView$b;", "Lkotlin/collections/HashMap;", "M1", "Ljava/util/HashMap;", "touches", "b", "c", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class EmojiRecyclerView extends RecyclerView {

    /* renamed from: B1, reason: from kotlin metadata */
    private ImageViewEmoji emojiTouchedView;

    /* renamed from: C1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 pickerView;

    /* renamed from: D1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 pickerViewPopup;

    /* renamed from: E1, reason: from kotlin metadata */
    private float emojiLastX;

    /* renamed from: F1, reason: from kotlin metadata */
    private float emojiLastY;

    /* renamed from: G1, reason: from kotlin metadata */
    private float emojiTouchedX;

    /* renamed from: H1, reason: from kotlin metadata */
    private float emojiTouchedY;

    /* renamed from: I1, reason: from kotlin metadata */
    private int popupWidth;

    /* renamed from: J1, reason: from kotlin metadata */
    private int popupHeight;

    /* renamed from: K1, reason: from kotlin metadata */
    private final int[] location;

    /* renamed from: L1, reason: from kotlin metadata */
    private SA2 onClearRecentListener;

    /* renamed from: M1, reason: from kotlin metadata */
    private HashMap touches;

    public static final class a implements RecyclerView.s {
        final /* synthetic */ c a;

        a(c cVar) {
            this.a = cVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
            AbstractC13042fc3.i(recyclerView, "rv");
            AbstractC13042fc3.i(motionEvent, "e");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public boolean c(RecyclerView recyclerView, MotionEvent motionEvent) {
            AbstractC13042fc3.i(recyclerView, "rv");
            AbstractC13042fc3.i(motionEvent, "e");
            this.a.b(recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY()), motionEvent);
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void e(boolean z) {
        }
    }

    public static final class b {
        private final int a;
        private final int b;
        private final long c;
        private final View d;

        public b(int i, int i2, long j, View view) {
            AbstractC13042fc3.i(view, "view");
            this.a = i;
            this.b = i2;
            this.c = j;
            this.d = view;
        }

        public final long a() {
            return this.c;
        }

        public final View b() {
            return this.d;
        }

        public final int c() {
            return this.a;
        }

        public final int d() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.b == bVar.b && this.c == bVar.c && AbstractC13042fc3.d(this.d, bVar.d);
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31) + Long.hashCode(this.c)) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "TouchDownInfo(x=" + this.a + ", y=" + this.b + ", time=" + this.c + ", view=" + this.d + Separators.RPAREN;
        }
    }

    private final class c {
        private View a;
        private final GestureDetector b;
        final /* synthetic */ EmojiRecyclerView c;

        public static final class a extends GestureDetector.SimpleOnGestureListener {
            final /* synthetic */ EmojiRecyclerView b;

            a(EmojiRecyclerView emojiRecyclerView) {
                this.b = emojiRecyclerView;
            }

            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
            java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
            	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
            	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
             */
            /* JADX WARN: Removed duplicated region for block: B:64:0x0190  */
            /* JADX WARN: Removed duplicated region for block: B:67:0x01a0  */
            /* JADX WARN: Removed duplicated region for block: B:68:0x01a3  */
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void onLongPress(android.view.MotionEvent r12) {
                /*
                    Method dump skipped, instructions count: 522
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.smiles.widget.EmojiRecyclerView.c.a.onLongPress(android.view.MotionEvent):void");
            }
        }

        public c(EmojiRecyclerView emojiRecyclerView, Context context) {
            AbstractC13042fc3.i(context, "context");
            this.c = emojiRecyclerView;
            this.b = new GestureDetector(context, new a(emojiRecyclerView));
        }

        public final View a() {
            return this.a;
        }

        public final boolean b(View view, MotionEvent motionEvent) {
            this.a = view;
            GestureDetector gestureDetector = this.b;
            AbstractC13042fc3.f(motionEvent);
            return gestureDetector.onTouchEvent(motionEvent);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmojiRecyclerView(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ir.nasim.features.smiles.widget.c getPickerView() {
        return (ir.nasim.features.smiles.widget.c) this.pickerView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d getPickerViewPopup() {
        return (d) this.pickerViewPopup.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final d l1(final EmojiRecyclerView emojiRecyclerView) {
        AbstractC13042fc3.i(emojiRecyclerView, "this$0");
        ir.nasim.features.smiles.widget.c pickerView = emojiRecyclerView.getPickerView();
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        int iF = aVar.f((AbstractC22360v62.a * 6) + 10.0f + 20.0f);
        emojiRecyclerView.popupWidth = iF;
        int iF2 = aVar.f(AbstractC22360v62.b);
        emojiRecyclerView.popupHeight = iF2;
        C19938rB7 c19938rB7 = C19938rB7.a;
        final d dVar = new d(pickerView, iF, iF2);
        dVar.setOutsideTouchable(true);
        dVar.setClippingEnabled(true);
        dVar.setInputMethodMode(2);
        dVar.setSoftInputMode(0);
        dVar.getContentView().setFocusableInTouchMode(true);
        dVar.getContentView().setOnKeyListener(new View.OnKeyListener() { // from class: ir.nasim.features.smiles.widget.e
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                return EmojiRecyclerView.m1(dVar, emojiRecyclerView, view, i, keyEvent);
            }
        });
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m1(d dVar, EmojiRecyclerView emojiRecyclerView, View view, int i, KeyEvent keyEvent) {
        AbstractC13042fc3.i(dVar, "$this_apply");
        AbstractC13042fc3.i(emojiRecyclerView, "this$0");
        AbstractC13042fc3.i(view, "<unused var>");
        AbstractC13042fc3.i(keyEvent, "event");
        if (i != 82 || keyEvent.getRepeatCount() != 0 || keyEvent.getAction() != 1 || !dVar.isShowing()) {
            return false;
        }
        emojiRecyclerView.getPickerViewPopup().dismiss();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ir.nasim.features.smiles.widget.c n1(Context context) {
        AbstractC13042fc3.i(context, "$context");
        return new ir.nasim.features.smiles.widget.c(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void o1(ir.nasim.features.smiles.widget.ImageViewEmoji r3, java.lang.String r4) {
        /*
            r2 = this;
            ir.nasim.UA2 r0 = r3.getListener()
            if (r0 != 0) goto L7
            return
        L7:
            if (r4 != 0) goto L15
            java.lang.Object r0 = r3.getTag()
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.String"
            ir.nasim.AbstractC13042fc3.g(r0, r1)
            java.lang.String r0 = (java.lang.String) r0
            goto L16
        L15:
            r0 = r4
        L16:
            if (r4 != 0) goto L32
            boolean r4 = r3.getIsRecent()
            if (r4 != 0) goto L31
            ir.nasim.R62 r4 = ir.nasim.R62.a
            java.util.HashMap r1 = r4.z()
            java.lang.Object r1 = r1.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L31
            java.lang.String r4 = r4.m(r0, r1)
            goto L32
        L31:
            r4 = r0
        L32:
            ir.nasim.UA2 r3 = r3.getListener()
            if (r3 == 0) goto L3b
            r3.invoke(r4)
        L3b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.smiles.widget.EmojiRecyclerView.o1(ir.nasim.features.smiles.widget.ImageViewEmoji, java.lang.String):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        AbstractC13042fc3.i(ev, "ev");
        boolean z = ev.getActionMasked() == 5 || ev.getActionMasked() == 0;
        boolean z2 = ev.getActionMasked() == 6 || ev.getActionMasked() == 1;
        boolean z3 = ev.getActionMasked() == 3;
        if (z || z2 || z3) {
            int actionIndex = ev.getActionIndex();
            int pointerId = ev.getPointerId(actionIndex);
            float x = ev.getX(actionIndex);
            float y = ev.getY(actionIndex);
            View viewFindChildViewUnder = findChildViewUnder(x, y);
            if (!z) {
                b bVar = (b) this.touches.remove(Integer.valueOf(pointerId));
                if (viewFindChildViewUnder != null && bVar != null && Math.sqrt(Math.pow(x - bVar.c(), 2.0d) + Math.pow(y - bVar.d(), 2.0d)) < C5161Id6.a.h() * 3 && !z3 && (!getPickerViewPopup().isShowing() || SystemClock.elapsedRealtime() - bVar.a() < ViewConfiguration.getLongPressTimeout())) {
                    View viewB = bVar.b();
                    if (viewB instanceof ImageViewEmoji) {
                        o1((ImageViewEmoji) viewB, null);
                        try {
                            performHapticFeedback(3, 1);
                        } catch (Exception unused) {
                            C19938rB7 c19938rB7 = C19938rB7.a;
                        }
                    } else {
                        viewB.callOnClick();
                    }
                }
                if (bVar != null && (bVar.b().getBackground() instanceof RippleDrawable)) {
                    bVar.b().getBackground().setState(new int[0]);
                }
                if (bVar != null) {
                    bVar.b().setPressed(false);
                }
            } else if (viewFindChildViewUnder != null) {
                b bVar2 = new b((int) x, (int) y, SystemClock.elapsedRealtime(), viewFindChildViewUnder);
                if (viewFindChildViewUnder.getBackground() instanceof RippleDrawable) {
                    viewFindChildViewUnder.getBackground().setState(new int[]{R.attr.state_pressed, R.attr.state_enabled});
                }
                bVar2.b().setPressed(true);
                this.touches.put(Integer.valueOf(pointerId), bVar2);
                stopScroll();
            }
        }
        return super.dispatchTouchEvent(ev) || (!z3 && (this.touches.isEmpty() ^ true));
    }

    public final void k1(View view) {
        b bVar;
        AbstractC13042fc3.i(view, "view");
        for (Object obj : this.touches.entrySet()) {
            AbstractC13042fc3.h(obj, "next(...)");
            Map.Entry entry = (Map.Entry) obj;
            if (((b) entry.getValue()).b() == view && (bVar = (b) this.touches.remove(entry.getKey())) != null) {
                if (bVar.b().getBackground() instanceof RippleDrawable) {
                    bVar.b().getBackground().setState(new int[0]);
                }
                bVar.b().setPressed(false);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00ae A[Catch: Exception -> 0x0050, TryCatch #0 {Exception -> 0x0050, blocks: (B:3:0x000a, B:5:0x000e, B:10:0x0021, B:21:0x0057, B:27:0x0096, B:31:0x00a5, B:13:0x0028, B:15:0x003c, B:20:0x0053, B:32:0x00ae, B:34:0x00b9, B:47:0x00e3, B:50:0x00f7, B:52:0x010e, B:54:0x0121, B:51:0x0105, B:55:0x0127, B:57:0x0166, B:58:0x0170, B:59:0x0173, B:61:0x017b), top: B:67:0x000a }] */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r23) {
        /*
            Method dump skipped, instructions count: 431
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.smiles.widget.EmojiRecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void setClearRecentListener(SA2 listener) {
        AbstractC13042fc3.i(listener, "listener");
        this.onClearRecentListener = listener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmojiRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ EmojiRecyclerView(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiRecyclerView(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        this.pickerView = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.t62
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return EmojiRecyclerView.n1(context);
            }
        });
        this.pickerViewPopup = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.u62
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return EmojiRecyclerView.l1(this.a);
            }
        });
        this.location = new int[2];
        addOnItemTouchListener(new a(new c(this, context)));
        setFocusable(true);
        setClickable(true);
        this.touches = new HashMap();
    }
}
