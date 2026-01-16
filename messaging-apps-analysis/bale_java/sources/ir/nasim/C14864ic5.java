package ir.nasim;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.gov.nist.core.Separators;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.view.ContextThemeWrapper;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import ir.nasim.C14864ic5;
import ir.nasim.features.smiles.panel.SmileKeyboardContainer;
import ir.nasim.features.smiles.panel.SmilesPanelView;
import ir.nasim.tgwidgets.editor.ui.O;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.ic5, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C14864ic5 implements ir.nasim.tgwidgets.editor.ui.O {
    private static final a t = new a(null);
    public static final int u = 8;
    private final C11458d25 a;
    private final Context b;
    private final InterfaceC20315ro1 c;
    private final b d;
    private final InputMethodManager e;
    private final ContextThemeWrapper f;
    private final InterfaceC9173Yu3 g;
    private View h;
    private final InterfaceC9173Yu3 i;
    private final InterfaceC9173Yu3 j;
    private final InterfaceC9173Yu3 k;
    private O.a l;
    private final int m;
    private final int n;
    private final InterfaceC9173Yu3 o;
    private final d p;
    private final d q;
    private final d r;
    private final d s;

    /* renamed from: ir.nasim.ic5$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ir.nasim.ic5$c */
    static final class c {
        private static final a h = new a(null);
        private final InterfaceC3570Bk5 a;
        private Integer b;
        private final InterfaceC9336Zm4 c;
        private final InterfaceC9336Zm4 d;
        private final InterfaceC9336Zm4 e;
        private final InterfaceC9336Zm4 f;
        private final InterfaceC10258bL6 g;

        /* renamed from: ir.nasim.ic5$c$a */
        private static final class a {
            private a() {
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        /* renamed from: ir.nasim.ic5$c$b */
        public interface b {

            /* renamed from: ir.nasim.ic5$c$b$a */
            public static final class a implements b {
                public static final a a = new a();
                private static final int b = KB5.icon_emoji;

                private a() {
                }

                @Override // ir.nasim.C14864ic5.c.b
                public int a() {
                    return b;
                }

                public boolean equals(Object obj) {
                    return this == obj || (obj instanceof a);
                }

                public int hashCode() {
                    return -9731377;
                }

                public String toString() {
                    return "Closed";
                }
            }

            /* renamed from: ir.nasim.ic5$c$b$b, reason: collision with other inner class name */
            public static final class C1301b implements b {
                private final int a;
                private final int b = KB5.icon_emoji;

                public C1301b(int i) {
                    this.a = i;
                }

                @Override // ir.nasim.C14864ic5.c.b
                public int a() {
                    return this.b;
                }

                public final int b() {
                    return this.a;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof C1301b) && this.a == ((C1301b) obj).a;
                }

                public int hashCode() {
                    return Integer.hashCode(this.a);
                }

                public String toString() {
                    return "DefaultKeyboard(height=" + this.a + Separators.RPAREN;
                }
            }

            /* renamed from: ir.nasim.ic5$c$b$c, reason: collision with other inner class name */
            public static final class C1302c implements b {
                private final Integer a;
                private final boolean b;
                private final int c;
                private final int d = KB5.ic_keyboard;

                public C1302c(Integer num, boolean z, int i) {
                    this.a = num;
                    this.b = z;
                    this.c = i;
                }

                @Override // ir.nasim.C14864ic5.c.b
                public int a() {
                    return this.d;
                }

                public final int b() {
                    return this.c;
                }

                public final Integer c() {
                    return this.a;
                }

                public final boolean d() {
                    return this.b;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof C1302c)) {
                        return false;
                    }
                    C1302c c1302c = (C1302c) obj;
                    return AbstractC13042fc3.d(this.a, c1302c.a) && this.b == c1302c.b && this.c == c1302c.c;
                }

                public int hashCode() {
                    Integer num = this.a;
                    return ((((num == null ? 0 : num.hashCode()) * 31) + Boolean.hashCode(this.b)) * 31) + Integer.hashCode(this.c);
                }

                public String toString() {
                    return "SmileKeyboard(height=" + this.a + ", searchBarIsVisible=" + this.b + ", defaultHeightDimenRes=" + this.c + Separators.RPAREN;
                }
            }

            int a();
        }

        /* renamed from: ir.nasim.ic5$c$c, reason: collision with other inner class name */
        static final class C1303c extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ boolean c;

            C1303c(InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C1303c c1303c = c.this.new C1303c(interfaceC20295rm1);
                c1303c.c = ((Boolean) obj).booleanValue();
                return c1303c;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return n(((Boolean) obj).booleanValue(), (InterfaceC20295rm1) obj2);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                boolean z = this.c;
                c cVar = c.this;
                cVar.b = cVar.m(z);
                return C19938rB7.a;
            }

            public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1303c) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.ic5$c$d */
        static final class d extends AbstractC19859r37 implements InterfaceC18160oB2 {
            int b;
            /* synthetic */ boolean c;
            /* synthetic */ int d;
            /* synthetic */ int e;
            /* synthetic */ boolean f;

            d(InterfaceC20295rm1 interfaceC20295rm1) {
                super(5, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object c1302c;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                boolean z = this.c;
                int i = this.d;
                int i2 = this.e;
                boolean z2 = this.f;
                if (i2 > 0) {
                    Integer numJ = c.this.j(i, z);
                    c1302c = new b.C1302c(numJ != null ? AbstractC6392Nk0.d(numJ.intValue() + i2) : null, true, c.this.g(z));
                } else if (i > 0) {
                    Integer num = c.this.b;
                    if (num == null || num.intValue() < i) {
                        c.this.b = AbstractC6392Nk0.d(i);
                        c.this.n(i, z);
                    }
                    Integer num2 = c.this.b;
                    c1302c = new b.C1301b(num2 != null ? num2.intValue() : i);
                } else {
                    c1302c = z2 ? new b.C1302c(c.this.j(i, z), false, c.this.g(z)) : b.a.a;
                }
                C19406qI3.a("SmileKeyboardPanel", "keyboardHeight: " + i + ", searchBarHeight: " + i2 + ", isPanelVisible: " + z2 + " --> " + c1302c, new Object[0]);
                return c1302c;
            }

            public final Object n(boolean z, int i, int i2, boolean z2, InterfaceC20295rm1 interfaceC20295rm1) {
                d dVar = c.this.new d(interfaceC20295rm1);
                dVar.c = z;
                dVar.d = i;
                dVar.e = i2;
                dVar.f = z2;
                return dVar.invokeSuspend(C19938rB7.a);
            }

            @Override // ir.nasim.InterfaceC18160oB2
            public /* bridge */ /* synthetic */ Object s(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                return n(((Boolean) obj).booleanValue(), ((Number) obj2).intValue(), ((Number) obj3).intValue(), ((Boolean) obj4).booleanValue(), (InterfaceC20295rm1) obj5);
            }
        }

        public c(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC3570Bk5 interfaceC3570Bk5) {
            AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
            AbstractC13042fc3.i(interfaceC3570Bk5, "preferences");
            this.a = interfaceC3570Bk5;
            Boolean bool = Boolean.FALSE;
            InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(bool);
            this.c = interfaceC9336Zm4A;
            InterfaceC9336Zm4 interfaceC9336Zm4A2 = AbstractC12281eL6.a(0);
            this.d = interfaceC9336Zm4A2;
            InterfaceC9336Zm4 interfaceC9336Zm4A3 = AbstractC12281eL6.a(0);
            this.e = interfaceC9336Zm4A3;
            InterfaceC9336Zm4 interfaceC9336Zm4A4 = AbstractC12281eL6.a(bool);
            this.f = interfaceC9336Zm4A4;
            this.g = AbstractC6459Nq2.o0(AbstractC6459Nq2.n(AbstractC6459Nq2.b0(interfaceC9336Zm4A, new C1303c(null)), interfaceC9336Zm4A2, interfaceC9336Zm4A3, interfaceC9336Zm4A4, new d(null)), interfaceC20315ro1, InterfaceC16863lz6.a.c(), b.a.a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int g(boolean z) {
            return z ? AbstractC14008hB5.keyboard_height : AbstractC14008hB5.keyboard_height_landscape;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Integer j(int i, boolean z) {
            if (i > 0) {
                return Integer.valueOf(i);
            }
            Integer num = this.b;
            return num == null ? m(z) : num;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Integer m(boolean z) {
            Integer numValueOf = Integer.valueOf(this.a.getInt(z ? "keyboard_height" : "keyboard_height_landscape", -1));
            if (numValueOf.intValue() != -1) {
                return numValueOf;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void n(int i, boolean z) {
            this.a.putInt(z ? "keyboard_height" : "keyboard_height_landscape", i);
        }

        public final int h() {
            Integer numM = m(((Boolean) this.c.getValue()).booleanValue());
            if (numM != null) {
                return numM.intValue();
            }
            return 0;
        }

        public final InterfaceC10258bL6 i() {
            return this.g;
        }

        public final void k(boolean z) {
            Object value;
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.c;
            do {
                value = interfaceC9336Zm4.getValue();
                ((Boolean) value).booleanValue();
            } while (!interfaceC9336Zm4.f(value, Boolean.valueOf(z)));
        }

        public final void l(boolean z) {
            Object value;
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.f;
            do {
                value = interfaceC9336Zm4.getValue();
                ((Boolean) value).booleanValue();
            } while (!interfaceC9336Zm4.f(value, Boolean.valueOf(z)));
            if (z) {
                return;
            }
            p(0);
        }

        public final void o(int i) {
            Object value;
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.d;
            do {
                value = interfaceC9336Zm4.getValue();
                ((Number) value).intValue();
            } while (!interfaceC9336Zm4.f(value, Integer.valueOf(i)));
        }

        public final void p(int i) {
            Object value;
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.e;
            do {
                value = interfaceC9336Zm4.getValue();
                ((Number) value).intValue();
            } while (!interfaceC9336Zm4.f(value, Integer.valueOf(i)));
        }
    }

    /* renamed from: ir.nasim.ic5$e */
    private static final class e implements CF6 {
        private final EditText a;

        public e(EditText editText) {
            AbstractC13042fc3.i(editText, "editText");
            this.a = editText;
        }

        private final CharSequence h(String str, Paint paint) {
            return R62.W(str, paint.getFontMetricsInt(), AbstractC7426Rr.a.f(20.0f), false, null, null, 48, null);
        }

        @Override // ir.nasim.CF6
        public boolean a() {
            EditText editText = this.a;
            Editable text = editText.getText();
            if (text == null || text.length() == 0) {
                return true;
            }
            editText.dispatchKeyEvent(new KeyEvent(0, 67));
            return true;
        }

        @Override // ir.nasim.CF6
        public void f(String str) {
            AbstractC13042fc3.i(str, "emoji");
            EditText editText = this.a;
            TextPaint paint = editText.getPaint();
            AbstractC13042fc3.h(paint, "getPaint(...)");
            CharSequence charSequenceH = h(str, paint);
            if (charSequenceH == null) {
                return;
            }
            int iMax = Math.max(editText.getSelectionEnd(), 0);
            Editable text = editText.getText();
            if (text != null) {
                text.insert(iMax, charSequenceH);
            }
            editText.setSelection(iMax + charSequenceH.length());
        }
    }

    /* renamed from: ir.nasim.ic5$f */
    public /* synthetic */ class f {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC22195up3.values().length];
            try {
                iArr[EnumC22195up3.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC22195up3.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.ic5$g */
    public static final class g extends AbstractC8614Ws3 implements UA2 {
        public static final g e = new g();

        public g() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Object obj) {
            return Boolean.valueOf(obj instanceof TextView);
        }
    }

    /* renamed from: ir.nasim.ic5$h */
    public static final class h extends GestureDetector.SimpleOnGestureListener {
        final /* synthetic */ EditText a;
        final /* synthetic */ C14864ic5 b;
        final /* synthetic */ Point c;

        h(EditText editText, C14864ic5 c14864ic5, Point point) {
            this.a = editText;
            this.b = c14864ic5;
            this.c = point;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(C14864ic5 c14864ic5, EditText editText, Point point) {
            AbstractC13042fc3.i(c14864ic5, "this$0");
            AbstractC13042fc3.i(editText, "$this_apply");
            AbstractC13042fc3.i(point, "$lastTouchPoint");
            c14864ic5.B0(editText, point);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            AbstractC13042fc3.i(motionEvent, "e");
            final EditText editText = this.a;
            final C14864ic5 c14864ic5 = this.b;
            final Point point = this.c;
            editText.postDelayed(new Runnable() { // from class: ir.nasim.jc5
                @Override // java.lang.Runnable
                public final void run() {
                    C14864ic5.h.b(c14864ic5, editText, point);
                }
            }, 300L);
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            AbstractC13042fc3.i(motionEvent, "e");
            return true;
        }
    }

    /* renamed from: ir.nasim.ic5$i */
    public static final class i implements BF6 {
        i() {
        }

        @Override // ir.nasim.BF6
        public void a() {
            C14864ic5.this.e0().p(0);
        }

        @Override // ir.nasim.BF6
        public void b(int i) {
            C14864ic5.this.e0().p(i);
        }
    }

    /* renamed from: ir.nasim.ic5$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.ic5$j$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C14864ic5 d;

            /* renamed from: ir.nasim.ic5$j$a$a, reason: collision with other inner class name */
            public static final class ViewOnLayoutChangeListenerC1304a implements View.OnLayoutChangeListener {
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    view.removeOnLayoutChangeListener(this);
                    view.animate().translationY(view.getHeight() + ((int) ((10 * AbstractC3742Cd6.c()) + 0.5d))).setInterpolator(InterpolatorC12631ew1.i).setDuration(200L);
                }
            }

            /* renamed from: ir.nasim.ic5$j$a$b */
            public static final class b implements View.OnLayoutChangeListener {
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    view.removeOnLayoutChangeListener(this);
                    view.animate().translationY(view.getHeight() + ((int) ((10 * AbstractC3742Cd6.c()) + 0.5d))).setInterpolator(InterpolatorC12631ew1.i).setDuration(200L);
                }
            }

            /* renamed from: ir.nasim.ic5$j$a$c */
            public static final class c implements View.OnLayoutChangeListener {
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    view.removeOnLayoutChangeListener(this);
                    view.animate().translationY(0.0f).setInterpolator(InterpolatorC12631ew1.g).setDuration(200L);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C14864ic5 c14864ic5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c14864ic5;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void M(C14864ic5 c14864ic5, View view) {
                c14864ic5.x0(EnumC22195up3.a);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void P(C14864ic5 c14864ic5, View view) {
                O.a aVarF0 = c14864ic5.f0();
                if (aVarF0 != null) {
                    aVarF0.onDoneButtonClicked();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void Q(C14864ic5 c14864ic5, View view) {
                c14864ic5.x0(EnumC22195up3.a);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void R(C14864ic5 c14864ic5, View view) {
                O.a aVarF0 = c14864ic5.f0();
                if (aVarF0 != null) {
                    aVarF0.c();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean S(C14864ic5 c14864ic5, KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1) {
                    return false;
                }
                c14864ic5.h();
                return true;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void T(C14864ic5 c14864ic5, View view) {
                O.a aVarF0 = c14864ic5.f0();
                if (aVarF0 != null) {
                    aVarF0.onDoneButtonClicked();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void U(C14864ic5 c14864ic5, View view) {
                c14864ic5.x0(EnumC22195up3.b);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean V(C14864ic5 c14864ic5, c.b bVar, KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1) {
                    return false;
                }
                if (((c.b.C1302c) bVar).d()) {
                    c14864ic5.g0().w();
                    return true;
                }
                c14864ic5.x0(EnumC22195up3.b);
                return true;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: L, reason: merged with bridge method [inline-methods] */
            public final Object invoke(c.b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(bVar, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                final c.b bVar = (c.b) this.c;
                if (bVar instanceof c.b.C1301b) {
                    this.d.e0().l(false);
                    c.b.C1301b c1301b = (c.b.C1301b) bVar;
                    this.d.w0(c1301b.b());
                    ImageView imageView = this.d.b0().j;
                    final C14864ic5 c14864ic5 = this.d;
                    imageView.setImageResource(c1301b.a());
                    imageView.setImageTintList(ColorStateList.valueOf(c14864ic5.n));
                    imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.kc5
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            C14864ic5.j.a.M(c14864ic5, view);
                        }
                    });
                    SmileKeyboardContainer root = this.d.b0().getRoot();
                    final C14864ic5 c14864ic52 = this.d;
                    root.setOnDispatchKeyEvent(new UA2() { // from class: ir.nasim.lc5
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj2) {
                            return Boolean.valueOf(C14864ic5.j.a.S(c14864ic52, (KeyEvent) obj2));
                        }
                    });
                    ImageView imageView2 = this.d.b0().k;
                    final C14864ic5 c14864ic53 = this.d;
                    imageView2.setBackgroundResource(KB5.market_badge_count_done);
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.mc5
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            C14864ic5.j.a.T(c14864ic53, view);
                        }
                    });
                    LinearLayout linearLayout = this.d.b0().i;
                    AbstractC13042fc3.h(linearLayout, "itemsContainer");
                    if (!linearLayout.isLaidOut() || linearLayout.isLayoutRequested()) {
                        linearLayout.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC1304a());
                    } else {
                        linearLayout.animate().translationY(linearLayout.getHeight() + ((int) ((10 * AbstractC3742Cd6.c()) + 0.5d))).setInterpolator(InterpolatorC12631ew1.i).setDuration(200L);
                    }
                    this.d.h.setVisibility(0);
                } else if (bVar instanceof c.b.C1302c) {
                    C14864ic5 c14864ic54 = this.d;
                    c.b.C1302c c1302c = (c.b.C1302c) bVar;
                    Integer numC = c1302c.c();
                    c14864ic54.w0(numC != null ? numC.intValue() : (int) this.d.f.getResources().getDimension(c1302c.b()));
                    ImageView imageView3 = this.d.b0().j;
                    final C14864ic5 c14864ic55 = this.d;
                    imageView3.setImageResource(c1302c.a());
                    imageView3.setImageTintList(ColorStateList.valueOf(c14864ic55.n));
                    imageView3.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.nc5
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            C14864ic5.j.a.U(c14864ic55, view);
                        }
                    });
                    SmileKeyboardContainer root2 = this.d.b0().getRoot();
                    final C14864ic5 c14864ic56 = this.d;
                    root2.setOnDispatchKeyEvent(new UA2() { // from class: ir.nasim.oc5
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj2) {
                            return Boolean.valueOf(C14864ic5.j.a.V(c14864ic56, bVar, (KeyEvent) obj2));
                        }
                    });
                    ImageView imageView4 = this.d.b0().k;
                    final C14864ic5 c14864ic57 = this.d;
                    imageView4.setBackgroundResource(KB5.market_badge_count_done);
                    imageView4.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.pc5
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            C14864ic5.j.a.P(c14864ic57, view);
                        }
                    });
                    LinearLayout linearLayout2 = this.d.b0().i;
                    AbstractC13042fc3.h(linearLayout2, "itemsContainer");
                    if (!linearLayout2.isLaidOut() || linearLayout2.isLayoutRequested()) {
                        linearLayout2.addOnLayoutChangeListener(new b());
                    } else {
                        linearLayout2.animate().translationY(linearLayout2.getHeight() + ((int) ((10 * AbstractC3742Cd6.c()) + 0.5d))).setInterpolator(InterpolatorC12631ew1.i).setDuration(200L);
                    }
                    this.d.h.setVisibility(0);
                    if (!c1302c.d()) {
                        this.d.U();
                    }
                    this.d.g0().B();
                } else {
                    if (!AbstractC13042fc3.d(bVar, c.b.a.a)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    ImageView imageView5 = this.d.b0().j;
                    final C14864ic5 c14864ic58 = this.d;
                    imageView5.setImageResource(bVar.a());
                    imageView5.setImageTintList(ColorStateList.valueOf(c14864ic58.n));
                    imageView5.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.qc5
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            C14864ic5.j.a.Q(c14864ic58, view);
                        }
                    });
                    LinearLayout linearLayout3 = this.d.b0().i;
                    AbstractC13042fc3.h(linearLayout3, "itemsContainer");
                    if (!linearLayout3.isLaidOut() || linearLayout3.isLayoutRequested()) {
                        linearLayout3.addOnLayoutChangeListener(new c());
                    } else {
                        linearLayout3.animate().translationY(0.0f).setInterpolator(InterpolatorC12631ew1.g).setDuration(200L);
                    }
                    ImageView imageView6 = this.d.b0().k;
                    final C14864ic5 c14864ic59 = this.d;
                    imageView6.setBackgroundResource(KB5.ba_send_fill_icon);
                    imageView6.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.rc5
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            C14864ic5.j.a.R(c14864ic59, view);
                        }
                    });
                    this.d.b0().getRoot().setOnDispatchKeyEvent(null);
                    this.d.h.setVisibility(8);
                    O.a aVarF0 = this.d.f0();
                    if (aVarF0 != null) {
                        aVarF0.a();
                    }
                }
                return C19938rB7.a;
            }
        }

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C14864ic5.this.new j(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6I = C14864ic5.this.e0().i();
                a aVar = new a(C14864ic5.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6I, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.ic5$l */
    static final class l implements Runnable {
        final /* synthetic */ EditText b;

        l(EditText editText) {
            this.b = editText;
        }

        @Override // java.lang.Runnable
        public final void run() {
            C14864ic5.this.e.showSoftInput(this.b, 0);
        }
    }

    /* renamed from: ir.nasim.ic5$m */
    static final class m implements Runnable {
        m() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            C14864ic5.this.y0();
        }
    }

    public C14864ic5(C11458d25 c11458d25, Context context, InterfaceC20315ro1 interfaceC20315ro1, b bVar, InputMethodManager inputMethodManager, final InterfaceC3570Bk5 interfaceC3570Bk5) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(context, "baseContext");
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(bVar, "inputBarConfiguration");
        AbstractC13042fc3.i(inputMethodManager, "inputMethodManager");
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferencesStorage");
        this.a = c11458d25;
        this.b = context;
        this.c = interfaceC20315ro1;
        this.d = bVar;
        this.e = inputMethodManager;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(AbstractC20790sc5.b(context, 0, 1, null), AbstractC23035wE5.MainActivityTheme);
        this.f = contextThemeWrapper;
        this.g = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Nb5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C14864ic5.D0(this.a);
            }
        });
        View view = new View(contextThemeWrapper);
        view.setBackgroundColor(AbstractC4043Dl1.c(view.getContext(), TA5.color4));
        this.h = view;
        this.i = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Yb5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C14864ic5.S(this.a);
            }
        });
        this.j = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.ac5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C14864ic5.T(this.a);
            }
        });
        this.k = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.bc5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C14864ic5.v0(this.a, interfaceC3570Bk5);
            }
        });
        this.m = Color.parseColor("#43C89E");
        this.n = AbstractC4043Dl1.c(contextThemeWrapper, TA5.n300);
        this.o = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.cc5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C14864ic5.V(this.a);
            }
        });
        int i2 = 2;
        ED1 ed1 = null;
        boolean z = false;
        this.p = new d(android.R.id.cut, z, new InterfaceC14603iB2() { // from class: ir.nasim.dc5
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(C14864ic5.Z(this.a, (EditText) obj, (PopupWindow) obj2));
            }
        }, i2, ed1);
        this.q = new d(android.R.id.copy, z, new InterfaceC14603iB2() { // from class: ir.nasim.ec5
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(C14864ic5.X(this.a, (EditText) obj, (PopupWindow) obj2));
            }
        }, i2, ed1);
        this.r = new d(android.R.id.paste, z, new InterfaceC14603iB2() { // from class: ir.nasim.fc5
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(C14864ic5.z0(this.a, (EditText) obj, (PopupWindow) obj2));
            }
        }, i2, ed1);
        this.s = new d(android.R.id.selectAll, false, new InterfaceC14603iB2() { // from class: ir.nasim.gc5
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(C14864ic5.A0(this.a, (EditText) obj, (PopupWindow) obj2));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean A0(C14864ic5 c14864ic5, EditText editText, PopupWindow popupWindow) {
        AbstractC13042fc3.i(c14864ic5, "this$0");
        AbstractC13042fc3.i(editText, "editText");
        AbstractC13042fc3.i(popupWindow, "popupWindow");
        editText.selectAll();
        c14864ic5.F0(c14864ic5.Y(editText), popupWindow, editText);
        return c14864ic5.i0(editText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B0(EditText editText, Point point) {
        int width;
        int measuredWidth;
        int width2;
        if (d0().getRoot().getParent() != null) {
            return;
        }
        List listY = Y(editText);
        PopupWindow popupWindow = new PopupWindow(d0().getRoot(), -2, -2);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: ir.nasim.Zb5
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                C14864ic5.C0(this.a);
            }
        });
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchable(true);
        F0(listY, popupWindow, editText);
        ScrollView root = d0().getRoot();
        root.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        if (point.x < root.getMeasuredWidth() / 2) {
            width2 = popupWindow.getWidth() / 2;
        } else {
            if (point.x > editText.getWidth() - (root.getMeasuredWidth() / 2)) {
                width = editText.getWidth();
                measuredWidth = root.getMeasuredWidth() / 2;
            } else {
                width = point.x;
                measuredWidth = root.getMeasuredWidth() / 2;
            }
            width2 = width - measuredWidth;
        }
        popupWindow.showAsDropDown(editText, width2, point.y - ((root.getMeasuredHeight() + editText.getLineHeight()) + ((int) ((20 * AbstractC3742Cd6.c()) + 0.5d))), 17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(C14864ic5 c14864ic5) {
        AbstractC13042fc3.i(c14864ic5, "this$0");
        ScrollView root = c14864ic5.d0().getRoot();
        ViewParent parent = root.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return;
        }
        viewGroup.removeView(root);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SmilesPanelView D0(C14864ic5 c14864ic5) {
        AbstractC13042fc3.i(c14864ic5, "this$0");
        C11458d25 c11458d25 = c14864ic5.a;
        ContextThemeWrapper contextThemeWrapper = c14864ic5.f;
        FragmentManager fragmentManagerB0 = c14864ic5.a0(c14864ic5.b).B0();
        AbstractC13042fc3.h(fragmentManagerB0, "getSupportFragmentManager(...)");
        return new SmilesPanelView(c11458d25, contextThemeWrapper, fragmentManagerB0, false, false, null, false, true, 32, null);
    }

    private final void F0(List list, final PopupWindow popupWindow, final EditText editText) {
        Object next;
        LinearLayout linearLayout = d0().d;
        AbstractC13042fc3.h(linearLayout, "itemsContainer");
        for (View view : AbstractC24379yW7.b(linearLayout)) {
            Iterator it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    next = it.next();
                    if (((d) next).c() == view.getId()) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            final d dVar = (d) next;
            view.setVisibility(dVar != null ? 0 : 8);
            if (dVar == null) {
                view.setOnClickListener(null);
            } else {
                view.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Wb5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        C14864ic5.G0(dVar, popupWindow, editText, view2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(d dVar, PopupWindow popupWindow, EditText editText, View view) {
        AbstractC13042fc3.i(popupWindow, "$popupWindow");
        AbstractC13042fc3.i(editText, "$editText");
        if (dVar.b()) {
            popupWindow.dismiss();
        }
        dVar.a().invoke(editText, popupWindow);
    }

    private final void R() {
        SmilesPanelView smilesPanelViewG0 = g0();
        View view = this.h;
        if (smilesPanelViewG0 == view) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        b0().getRoot().removeView(this.h);
        b0().getRoot().addView(g0(), layoutParams);
        this.h = g0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AF6 S(C14864ic5 c14864ic5) {
        AbstractC13042fc3.i(c14864ic5, "this$0");
        return AF6.c(LayoutInflater.from(c14864ic5.f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClipboardManager T(C14864ic5 c14864ic5) {
        AbstractC13042fc3.i(c14864ic5, "this$0");
        Object systemService = c14864ic5.f.getSystemService("clipboard");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        return (ClipboardManager) systemService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean U() {
        EditText editText = b0().d;
        O.a aVarF0 = f0();
        if (aVarF0 != null) {
            aVarF0.e();
        }
        return this.e.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C3614Bp4 V(C14864ic5 c14864ic5) {
        AbstractC13042fc3.i(c14864ic5, "this$0");
        C3614Bp4 c3614Bp4C = C3614Bp4.c(LayoutInflater.from(c14864ic5.f));
        ScrollView root = c3614Bp4C.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        InterfaceC23384wp6 interfaceC23384wp6R = AbstractC11342cq6.r(AbstractC24379yW7.b(root), g.e);
        AbstractC13042fc3.g(interfaceC23384wp6R, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        Iterator it = interfaceC23384wp6R.iterator();
        while (it.hasNext()) {
            ((TextView) it.next()).setTypeface(C6011Lu2.i());
        }
        return c3614Bp4C;
    }

    private final CharSequence W(EditText editText) {
        return editText.getText().subSequence(editText.getSelectionStart(), editText.getSelectionEnd());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean X(C14864ic5 c14864ic5, EditText editText, PopupWindow popupWindow) {
        AbstractC13042fc3.i(c14864ic5, "this$0");
        AbstractC13042fc3.i(editText, "editText");
        AbstractC13042fc3.i(popupWindow, "<unused var>");
        return KV0.a(c14864ic5.f, c14864ic5.W(editText));
    }

    private final List Y(EditText editText) {
        ArrayList arrayList = new ArrayList();
        if (editText.hasSelection()) {
            arrayList.add(this.q);
            arrayList.add(this.p);
        }
        if (j0(c0())) {
            arrayList.add(this.r);
        }
        if (!i0(editText)) {
            arrayList.add(this.s);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z(C14864ic5 c14864ic5, EditText editText, PopupWindow popupWindow) {
        AbstractC13042fc3.i(c14864ic5, "this$0");
        AbstractC13042fc3.i(editText, "editText");
        AbstractC13042fc3.i(popupWindow, "<unused var>");
        CharSequence charSequenceW = c14864ic5.W(editText);
        editText.getText().delete(editText.getSelectionStart(), editText.getSelectionEnd());
        return KV0.a(c14864ic5.f, charSequenceW);
    }

    private final AppCompatActivity a0(Context context) throws Exception {
        while (!(context instanceof AppCompatActivity)) {
            if (!(context instanceof ContextWrapper)) {
                throw new Exception("Activity not found");
            }
            context = ((ContextWrapper) context).getBaseContext();
            AbstractC13042fc3.h(context, "getBaseContext(...)");
        }
        return (AppCompatActivity) context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AF6 b0() {
        return (AF6) this.i.getValue();
    }

    private final ClipboardManager c0() {
        return (ClipboardManager) this.j.getValue();
    }

    private final C3614Bp4 d0() {
        return (C3614Bp4) this.o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c e0() {
        return (c) this.k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SmilesPanelView g0() {
        return (SmilesPanelView) this.g.getValue();
    }

    private final CharSequence h0(ClipboardManager clipboardManager) {
        ClipData.Item itemAt;
        ClipData primaryClip = clipboardManager.getPrimaryClip();
        if (primaryClip == null || primaryClip.getItemCount() == 0 || (itemAt = primaryClip.getItemAt(0)) == null) {
            return null;
        }
        return itemAt.getText();
    }

    private final boolean i0(EditText editText) {
        return Math.abs(editText.getSelectionEnd() - editText.getSelectionStart()) >= editText.length();
    }

    private final boolean j0(ClipboardManager clipboardManager) {
        return clipboardManager.hasPrimaryClip() && h0(clipboardManager) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l0(C14864ic5 c14864ic5, Configuration configuration) {
        AbstractC13042fc3.i(c14864ic5, "this$0");
        AbstractC13042fc3.i(configuration, "configuration");
        c14864ic5.e0().k(configuration.orientation == 1);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m0(Point point, GestureDetector gestureDetector, View view, MotionEvent motionEvent) {
        AbstractC13042fc3.i(point, "$lastTouchPoint");
        AbstractC13042fc3.i(gestureDetector, "$gestureDetector");
        point.set((int) motionEvent.getX(), (int) motionEvent.getY());
        gestureDetector.onTouchEvent(motionEvent);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n0(final C14864ic5 c14864ic5, final EditText editText, final Point point, View view) {
        AbstractC13042fc3.i(c14864ic5, "this$0");
        AbstractC13042fc3.i(editText, "$this_apply");
        AbstractC13042fc3.i(point, "$lastTouchPoint");
        if (!view.isFocused()) {
            return false;
        }
        view.postDelayed(new Runnable() { // from class: ir.nasim.Xb5
            @Override // java.lang.Runnable
            public final void run() {
                C14864ic5.o0(this.a, editText, point);
            }
        }, 300L);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(C14864ic5 c14864ic5, EditText editText, Point point) {
        AbstractC13042fc3.i(c14864ic5, "this$0");
        AbstractC13042fc3.i(editText, "$this_apply");
        AbstractC13042fc3.i(point, "$lastTouchPoint");
        c14864ic5.B0(editText, point);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(C14864ic5 c14864ic5, View view) {
        AbstractC13042fc3.i(c14864ic5, "this$0");
        O.a aVarF0 = c14864ic5.f0();
        if (aVarF0 != null) {
            aVarF0.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(C14864ic5 c14864ic5, View view) {
        AbstractC13042fc3.i(c14864ic5, "this$0");
        O.a aVarF0 = c14864ic5.f0();
        if (aVarF0 != null) {
            aVarF0.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(C14864ic5 c14864ic5, View view) {
        AbstractC13042fc3.i(c14864ic5, "this$0");
        O.a aVarF0 = c14864ic5.f0();
        if (aVarF0 != null) {
            aVarF0.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(C14864ic5 c14864ic5, View view) {
        AbstractC13042fc3.i(c14864ic5, "this$0");
        O.a aVarF0 = c14864ic5.f0();
        if (aVarF0 != null) {
            aVarF0.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t0(C14864ic5 c14864ic5, boolean z) {
        AbstractC13042fc3.i(c14864ic5, "this$0");
        if (z) {
            c14864ic5.b0().d.requestFocus();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(C14864ic5 c14864ic5, View view) {
        AbstractC13042fc3.i(c14864ic5, "this$0");
        c14864ic5.x0(EnumC22195up3.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c v0(C14864ic5 c14864ic5, InterfaceC3570Bk5 interfaceC3570Bk5) {
        AbstractC13042fc3.i(c14864ic5, "this$0");
        AbstractC13042fc3.i(interfaceC3570Bk5, "$preferencesStorage");
        return new c(c14864ic5.c, interfaceC3570Bk5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0(int i2) {
        View view = this.h;
        if (view.getHeight() == i2 || i2 <= 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x0(EnumC22195up3 enumC22195up3) {
        O.a aVarF0;
        C19406qI3.g("SmileKeyboardPanel", "open(" + enumC22195up3 + ", " + e0().i().getValue() + Separators.RPAREN, new Object[0]);
        if ((e0().i().getValue() instanceof c.b.a) && (aVarF0 = f0()) != null) {
            aVarF0.g();
        }
        int i2 = f.a[enumC22195up3.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            y0();
        } else {
            U();
            R();
            e0().l(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y0() {
        EditText editText = b0().d;
        O.a aVarF0 = f0();
        if (aVarF0 != null) {
            aVarF0.f();
        }
        AbstractC13042fc3.f(editText);
        if (!editText.isAttachedToWindow()) {
            editText.addOnAttachStateChangeListener(new n(editText, this, editText));
        } else if (editText.requestFocus()) {
            editText.post(new l(editText));
        } else {
            editText.post(new m());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean z0(C14864ic5 c14864ic5, EditText editText, PopupWindow popupWindow) {
        AbstractC13042fc3.i(c14864ic5, "this$0");
        AbstractC13042fc3.i(editText, "editText");
        AbstractC13042fc3.i(popupWindow, "<unused var>");
        CharSequence charSequenceH0 = c14864ic5.h0(c14864ic5.c0());
        if (charSequenceH0 == null) {
            return false;
        }
        int selectionStart = editText.getSelectionStart();
        editText.getText().replace(selectionStart, editText.getSelectionEnd(), charSequenceH0);
        editText.setSelection(selectionStart + charSequenceH0.length());
        return true;
    }

    public void E0() {
        f(null);
        U();
        g0().setSmilesKeyboardListener(null);
        ViewParent parent = b0().getRoot().getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(b0().getRoot());
        }
    }

    @Override // ir.nasim.tgwidgets.editor.ui.O
    public CharSequence a() {
        return b0().d.getText();
    }

    @Override // ir.nasim.tgwidgets.editor.ui.O
    public void b(boolean z, boolean z2) {
        AF6 af6B0 = b0();
        AbstractC14525i33.c(af6B0.g, ColorStateList.valueOf(z ? this.m : -1));
        AbstractC14525i33.c(af6B0.h, ColorStateList.valueOf(z2 ? this.m : -1));
    }

    @Override // ir.nasim.tgwidgets.editor.ui.O
    public void c(boolean z, boolean z2) {
        AF6 af6B0 = b0();
        AppCompatImageView appCompatImageView = af6B0.g;
        AbstractC13042fc3.h(appCompatImageView, "itemCrop");
        appCompatImageView.setVisibility(z ? 0 : 8);
        AppCompatImageView appCompatImageView2 = af6B0.h;
        AbstractC13042fc3.h(appCompatImageView2, "itemPaint");
        appCompatImageView2.setVisibility(z2 ? 0 : 8);
        LinearLayout linearLayout = af6B0.i;
        AbstractC13042fc3.h(linearLayout, "itemsContainer");
        linearLayout.setVisibility(z || z2 ? 0 : 8);
    }

    @Override // ir.nasim.tgwidgets.editor.ui.O
    public ViewGroup d() {
        SmileKeyboardContainer root = b0().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.O
    public void e(CharSequence charSequence) {
        EditText editText = b0().d;
        editText.setText(charSequence);
        if (charSequence != null) {
            editText.setSelection(charSequence.length());
        }
    }

    @Override // ir.nasim.tgwidgets.editor.ui.O
    public void f(O.a aVar) {
        this.l = aVar;
    }

    public O.a f0() {
        return this.l;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.O
    public void g(float f2) {
        e0().o(AbstractC23053wG5.e(AbstractC20723sV3.d(f2), 0));
    }

    @Override // ir.nasim.tgwidgets.editor.ui.O
    public void h() {
        C19406qI3.g("SmileKeyboardPanel", "closeKeyboardAndPanel()", new Object[0]);
        e0().l(false);
        U();
    }

    @Override // ir.nasim.tgwidgets.editor.ui.O
    public boolean i() {
        return !AbstractC13042fc3.d(e0().i().getValue(), c.b.a.a);
    }

    @Override // ir.nasim.tgwidgets.editor.ui.O
    public void j() {
        c(false, false);
        ConstraintLayout constraintLayout = b0().f;
        AbstractC13042fc3.h(constraintLayout, "inputBarLayout");
        constraintLayout.setVisibility(8);
        ConstraintLayout constraintLayout2 = b0().c;
        AbstractC13042fc3.h(constraintLayout2, "avatarSelectLayout");
        constraintLayout2.setVisibility(0);
        b0().c.setBackgroundColor(2130706432);
    }

    public void k0() {
        AF6 af6B0 = b0();
        af6B0.getRoot().addView(this.h, new LinearLayoutCompat.LayoutParams(-1, e0().h()));
        af6B0.getRoot().setOnDispatchConfiguration(new UA2() { // from class: ir.nasim.hc5
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C14864ic5.l0(this.a, (Configuration) obj);
            }
        });
        final EditText editText = af6B0.d;
        editText.setTypeface(C6011Lu2.k());
        editText.setHint(this.d.a());
        editText.setMaxLines(this.d.b());
        AbstractC13042fc3.f(editText);
        editText.addTextChangedListener(new k());
        final Point point = new Point();
        final GestureDetector gestureDetector = new GestureDetector(editText.getContext(), new h(editText, this, point));
        editText.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.Ob5
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return C14864ic5.m0(point, gestureDetector, view, motionEvent);
            }
        });
        editText.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.Pb5
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return C14864ic5.n0(this.a, editText, point, view);
            }
        });
        AppCompatImageView appCompatImageView = af6B0.g;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Qb5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C14864ic5.p0(this.a, view);
            }
        });
        appCompatImageView.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y(1090519039));
        AppCompatImageView appCompatImageView2 = af6B0.h;
        appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Rb5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C14864ic5.q0(this.a, view);
            }
        });
        appCompatImageView2.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y(1090519039));
        ImageView imageView = b0().l;
        imageView.setBackgroundResource(KB5.market_badge_count_done);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Sb5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C14864ic5.r0(this.a, view);
            }
        });
        AppCompatImageView appCompatImageView3 = af6B0.b;
        appCompatImageView3.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Tb5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C14864ic5.s0(this.a, view);
            }
        });
        appCompatImageView3.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y(1090519039));
        e0().k(this.f.getResources().getConfiguration().orientation == 1);
        SmilesPanelView smilesPanelViewG0 = g0();
        EditText editText2 = b0().d;
        AbstractC13042fc3.h(editText2, "captionEditText");
        smilesPanelViewG0.setSmilesKeyboardListener(new e(editText2));
        smilesPanelViewG0.setSmilesActionListener(new i());
        b0().getRoot().setOnVisibilityChanged(new UA2() { // from class: ir.nasim.Ub5
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C14864ic5.t0(this.a, ((Boolean) obj).booleanValue());
            }
        });
        b0().d.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Vb5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C14864ic5.u0(this.a, view);
            }
        });
        AbstractC10533bm0.d(this.c, null, null, new j(null), 3, null);
    }

    /* renamed from: ir.nasim.ic5$b */
    public static final class b {
        public static final a c = new a(null);
        public static final int d = 8;
        private final CharSequence a;
        private final int b;

        /* renamed from: ir.nasim.ic5$b$a */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        public b(CharSequence charSequence, int i) {
            this.a = charSequence;
            this.b = i;
        }

        public final CharSequence a() {
            return this.a;
        }

        public final int b() {
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
            return AbstractC13042fc3.d(this.a, bVar.a) && this.b == bVar.b;
        }

        public int hashCode() {
            CharSequence charSequence = this.a;
            return ((charSequence == null ? 0 : charSequence.hashCode()) * 31) + Integer.hashCode(this.b);
        }

        public String toString() {
            CharSequence charSequence = this.a;
            return "InputBarConfiguration(hint=" + ((Object) charSequence) + ", maxLines=" + this.b + Separators.RPAREN;
        }

        public /* synthetic */ b(CharSequence charSequence, int i, int i2, ED1 ed1) {
            this((i2 & 1) != 0 ? null : charSequence, (i2 & 2) != 0 ? 4 : i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ir.nasim.ic5$d */
    static final class d {
        private final int a;
        private final boolean b;
        private final InterfaceC14603iB2 c;

        public d(int i, boolean z, InterfaceC14603iB2 interfaceC14603iB2) {
            AbstractC13042fc3.i(interfaceC14603iB2, "action");
            this.a = i;
            this.b = z;
            this.c = interfaceC14603iB2;
        }

        public final InterfaceC14603iB2 a() {
            return this.c;
        }

        public final boolean b() {
            return this.b;
        }

        public final int c() {
            return this.a;
        }

        public /* synthetic */ d(int i, boolean z, InterfaceC14603iB2 interfaceC14603iB2, int i2, ED1 ed1) {
            this(i, (i2 & 2) != 0 ? true : z, interfaceC14603iB2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ C14864ic5(C11458d25 c11458d25, Context context, InterfaceC20315ro1 interfaceC20315ro1, b bVar, InputMethodManager inputMethodManager, InterfaceC3570Bk5 interfaceC3570Bk5, int i2, ED1 ed1) {
        b bVar2;
        InputMethodManager inputMethodManager2;
        if ((i2 & 8) != 0) {
            bVar2 = new b(null, 0, 3, 0 == true ? 1 : 0);
        } else {
            bVar2 = bVar;
        }
        if ((i2 & 16) != 0) {
            Object systemService = context.getSystemService("input_method");
            AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            inputMethodManager2 = (InputMethodManager) systemService;
        } else {
            inputMethodManager2 = inputMethodManager;
        }
        this(c11458d25, context, interfaceC20315ro1, bVar2, inputMethodManager2, (i2 & 32) != 0 ? ((InterfaceC9291Zh4) C92.a(context, InterfaceC9291Zh4.class)).E0() : interfaceC3570Bk5);
    }

    /* renamed from: ir.nasim.ic5$k */
    public static final class k implements TextWatcher {
        public k() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            O.a aVarF0 = C14864ic5.this.f0();
            if (aVarF0 != null) {
                aVarF0.onCaptionChanged(charSequence);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: ir.nasim.ic5$n */
    public static final class n implements View.OnAttachStateChangeListener {
        final /* synthetic */ View a;
        final /* synthetic */ C14864ic5 b;
        final /* synthetic */ EditText c;

        public n(View view, C14864ic5 c14864ic5, EditText editText) {
            this.a = view;
            this.b = c14864ic5;
            this.c = editText;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.a.removeOnAttachStateChangeListener(this);
            if (view.requestFocus()) {
                view.post(this.b.new l(this.c));
            } else {
                view.post(this.b.new m());
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }
}
