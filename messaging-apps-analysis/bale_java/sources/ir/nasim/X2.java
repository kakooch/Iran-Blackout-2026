package ir.nasim;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import ir.nasim.InterfaceC10698c3;
import java.lang.ref.WeakReference;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class X2 {
    private static int d;
    private final AccessibilityNodeInfo a;
    public int b = -1;
    private int c = -1;

    public static class a {
        public static final a A;
        public static final a B;
        public static final a C;
        public static final a D;
        public static final a E;
        public static final a F;
        public static final a G;
        public static final a H;
        public static final a I;
        public static final a J;
        public static final a K;
        public static final a L;
        public static final a M;
        public static final a N;
        public static final a O;
        public static final a P;
        public static final a Q;
        public static final a R;
        public static final a S;
        public static final a T;
        public static final a U;
        public static final a V;
        public static final a e = new a(1, null);
        public static final a f = new a(2, null);
        public static final a g = new a(4, null);
        public static final a h = new a(8, null);
        public static final a i = new a(16, null);
        public static final a j = new a(32, null);
        public static final a k = new a(64, null);
        public static final a l = new a(128, null);
        public static final a m = new a(256, (CharSequence) null, InterfaceC10698c3.b.class);
        public static final a n = new a(512, (CharSequence) null, InterfaceC10698c3.b.class);
        public static final a o = new a(1024, (CharSequence) null, InterfaceC10698c3.c.class);
        public static final a p = new a(2048, (CharSequence) null, InterfaceC10698c3.c.class);
        public static final a q = new a(4096, null);
        public static final a r = new a(8192, null);
        public static final a s = new a(16384, null);
        public static final a t = new a(32768, null);
        public static final a u = new a(65536, null);
        public static final a v = new a(131072, (CharSequence) null, InterfaceC10698c3.g.class);
        public static final a w = new a(262144, null);
        public static final a x = new a(524288, null);
        public static final a y = new a(1048576, null);
        public static final a z = new a(2097152, (CharSequence) null, InterfaceC10698c3.h.class);
        final Object a;
        private final int b;
        private final Class c;
        protected final InterfaceC10698c3 d;

        static {
            int i2 = Build.VERSION.SDK_INT;
            A = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, android.R.id.accessibilityActionShowOnScreen, null, null, null);
            B = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, android.R.id.accessibilityActionScrollToPosition, null, null, InterfaceC10698c3.e.class);
            C = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, android.R.id.accessibilityActionScrollUp, null, null, null);
            D = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, android.R.id.accessibilityActionScrollLeft, null, null, null);
            E = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, android.R.id.accessibilityActionScrollDown, null, null, null);
            F = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, android.R.id.accessibilityActionScrollRight, null, null, null);
            G = new a(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, android.R.id.accessibilityActionPageUp, null, null, null);
            H = new a(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, android.R.id.accessibilityActionPageDown, null, null, null);
            I = new a(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, android.R.id.accessibilityActionPageLeft, null, null, null);
            J = new a(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, android.R.id.accessibilityActionPageRight, null, null, null);
            K = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, android.R.id.accessibilityActionContextClick, null, null, null);
            L = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, android.R.id.accessibilityActionSetProgress, null, null, InterfaceC10698c3.f.class);
            M = new a(i2 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, android.R.id.accessibilityActionMoveWindow, null, null, InterfaceC10698c3.d.class);
            N = new a(i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, android.R.id.accessibilityActionShowTooltip, null, null, null);
            O = new a(i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, android.R.id.accessibilityActionHideTooltip, null, null, null);
            P = new a(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, android.R.id.accessibilityActionPressAndHold, null, null, null);
            Q = new a(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, android.R.id.accessibilityActionImeEnter, null, null, null);
            R = new a(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, android.R.id.accessibilityActionDragStart, null, null, null);
            S = new a(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, android.R.id.accessibilityActionDragDrop, null, null, null);
            T = new a(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, android.R.id.accessibilityActionDragCancel, null, null, null);
            U = new a(i2 >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, android.R.id.accessibilityActionShowTextSuggestions, null, null, null);
            V = new a(i2 >= 34 ? d.a() : null, android.R.id.accessibilityActionScrollInDirection, null, null, null);
        }

        public a(int i2, CharSequence charSequence) {
            this(null, i2, charSequence, null, null);
        }

        public a a(CharSequence charSequence, InterfaceC10698c3 interfaceC10698c3) {
            return new a(null, this.b, charSequence, interfaceC10698c3, this.c);
        }

        public int b() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.a).getId();
        }

        public CharSequence c() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.a).getLabel();
        }

        public boolean d(View view, Bundle bundle) {
            if (this.d == null) {
                return false;
            }
            Class cls = this.c;
            if (cls != null) {
                try {
                    AbstractC18350oW3.a(cls.getDeclaredConstructor(null).newInstance(null));
                    throw null;
                } catch (Exception e2) {
                    Class cls2 = this.c;
                    Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + (cls2 == null ? "null" : cls2.getName()), e2);
                }
            }
            return this.d.a(view, null);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object obj2 = this.a;
            return obj2 == null ? aVar.a == null : obj2.equals(aVar.a);
        }

        public int hashCode() {
            Object obj = this.a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AccessibilityActionCompat: ");
            String strJ = X2.j(this.b);
            if (strJ.equals("ACTION_UNKNOWN") && c() != null) {
                strJ = c().toString();
            }
            sb.append(strJ);
            return sb.toString();
        }

        public a(int i2, CharSequence charSequence, InterfaceC10698c3 interfaceC10698c3) {
            this(null, i2, charSequence, interfaceC10698c3, null);
        }

        a(Object obj) {
            this(obj, 0, null, null, null);
        }

        private a(int i2, CharSequence charSequence, Class cls) {
            this(null, i2, charSequence, null, cls);
        }

        a(Object obj, int i2, CharSequence charSequence, InterfaceC10698c3 interfaceC10698c3, Class cls) {
            this.b = i2;
            this.d = interfaceC10698c3;
            if (obj == null) {
                this.a = new AccessibilityNodeInfo.AccessibilityAction(i2, charSequence);
            } else {
                this.a = obj;
            }
            this.c = cls;
        }
    }

    private static class b {
        public static Object a(int i, float f, float f2, float f3) {
            return new AccessibilityNodeInfo.RangeInfo(i, f, f2, f3);
        }

        public static CharSequence b(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getStateDescription();
        }

        public static void c(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setStateDescription(charSequence);
        }
    }

    private static class c {
        public static f a(boolean z, int i, int i2, int i3, int i4, boolean z2, String str, String str2) {
            return new f(new AccessibilityNodeInfo.CollectionItemInfo.Builder().setHeading(z).setColumnIndex(i).setRowIndex(i2).setColumnSpan(i3).setRowSpan(i4).setSelected(z2).setRowTitle(str).setColumnTitle(str2).build());
        }

        public static X2 b(AccessibilityNodeInfo accessibilityNodeInfo, int i, int i2) {
            return X2.h1(accessibilityNodeInfo.getChild(i, i2));
        }

        public static String c(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getColumnTitle();
        }

        public static String d(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getRowTitle();
        }

        public static AccessibilityNodeInfo.ExtraRenderingInfo e(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExtraRenderingInfo();
        }

        public static X2 f(AccessibilityNodeInfo accessibilityNodeInfo, int i) {
            return X2.h1(accessibilityNodeInfo.getParent(i));
        }

        public static String g(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getUniqueId();
        }

        public static boolean h(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isTextSelectable();
        }

        public static void i(AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
            accessibilityNodeInfo.setTextSelectable(z);
        }

        public static void j(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
            accessibilityNodeInfo.setUniqueId(str);
        }
    }

    private static class d {
        public static AccessibilityNodeInfo.AccessibilityAction a() {
            return AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
        }

        public static void b(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.getBoundsInWindow(rect);
        }

        public static CharSequence c(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getContainerTitle();
        }

        public static long d(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getMinDurationBetweenContentChanges().toMillis();
        }

        public static boolean e(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.hasRequestInitialAccessibilityFocus();
        }

        public static boolean f(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isAccessibilityDataSensitive();
        }

        public static void g(AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
            accessibilityNodeInfo.setAccessibilityDataSensitive(z);
        }

        public static void h(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.setBoundsInWindow(rect);
        }

        public static void i(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setContainerTitle(charSequence);
        }

        public static void j(AccessibilityNodeInfo accessibilityNodeInfo, long j) {
            accessibilityNodeInfo.setMinDurationBetweenContentChanges(Duration.ofMillis(j));
        }

        public static void k(AccessibilityNodeInfo accessibilityNodeInfo, View view, boolean z) {
            accessibilityNodeInfo.setQueryFromAppProcessEnabled(view, z);
        }

        public static void l(AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
            accessibilityNodeInfo.setRequestInitialAccessibilityFocus(z);
        }
    }

    public static class e {
        final Object a;

        e(Object obj) {
            this.a = obj;
        }

        public static e a(int i, int i2, boolean z) {
            return new e(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z));
        }

        public static e b(int i, int i2, boolean z, int i3) {
            return new e(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3));
        }
    }

    public static class f {
        final Object a;

        f(Object obj) {
            this.a = obj;
        }

        public static f a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return new f(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2));
        }
    }

    public static class g {
        final Object a;

        g(Object obj) {
            this.a = obj;
        }

        public static g a(int i, float f, float f2, float f3) {
            return new g(AccessibilityNodeInfo.RangeInfo.obtain(i, f, f2, f3));
        }
    }

    public X2(Object obj) {
        this.a = (AccessibilityNodeInfo) obj;
    }

    private SparseArray A(View view) {
        return (SparseArray) view.getTag(AbstractC24197yC5.tag_accessibility_clickable_spans);
    }

    private boolean G() {
        return !h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    private int H(ClickableSpan clickableSpan, SparseArray sparseArray) {
        if (sparseArray != null) {
            for (int i = 0; i < sparseArray.size(); i++) {
                if (clickableSpan.equals((ClickableSpan) ((WeakReference) sparseArray.valueAt(i)).get())) {
                    return sparseArray.keyAt(i);
                }
            }
        }
        int i2 = d;
        d = i2 + 1;
        return i2;
    }

    public static X2 a0() {
        return g1(AccessibilityNodeInfo.obtain());
    }

    public static X2 b0(View view) {
        return g1(AccessibilityNodeInfo.obtain(view));
    }

    public static X2 c0(X2 x2) {
        return g1(AccessibilityNodeInfo.obtain(x2.a));
    }

    private void e(ClickableSpan clickableSpan, Spanned spanned, int i) {
        h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i));
    }

    private void g() {
        this.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        this.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        this.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        this.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
    }

    private void g0(View view) {
        SparseArray sparseArrayA = A(view);
        if (sparseArrayA != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < sparseArrayA.size(); i++) {
                if (((WeakReference) sparseArrayA.valueAt(i)).get() == null) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                sparseArrayA.remove(((Integer) arrayList.get(i2)).intValue());
            }
        }
    }

    public static X2 g1(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new X2(accessibilityNodeInfo);
    }

    private List h(String str) {
        ArrayList<Integer> integerArrayList = this.a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    static X2 h1(Object obj) {
        if (obj != null) {
            return new X2(obj);
        }
        return null;
    }

    static String j(int i) {
        if (i == 1) {
            return "ACTION_FOCUS";
        }
        if (i == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case android.R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            case android.R.id.accessibilityActionScrollInDirection:
                return "ACTION_SCROLL_IN_DIRECTION";
            default:
                switch (i) {
                    case android.R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case android.R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case android.R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case android.R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case android.R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case android.R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case android.R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case android.R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i) {
                            case android.R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case android.R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case android.R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case android.R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case android.R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case android.R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            case android.R.id.accessibilityActionPressAndHold:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i) {
                                    case android.R.id.accessibilityActionImeEnter:
                                        return "ACTION_IME_ENTER";
                                    case android.R.id.accessibilityActionDragStart:
                                        return "ACTION_DRAG_START";
                                    case android.R.id.accessibilityActionDragDrop:
                                        return "ACTION_DRAG_DROP";
                                    case android.R.id.accessibilityActionDragCancel:
                                        return "ACTION_DRAG_CANCEL";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    private void j0(int i, boolean z) {
        Bundle bundleV = v();
        if (bundleV != null) {
            int i2 = bundleV.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i);
            if (!z) {
                i = 0;
            }
            bundleV.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i | i2);
        }
    }

    private boolean l(int i) {
        Bundle bundleV = v();
        return bundleV != null && (bundleV.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i) == i;
    }

    public static ClickableSpan[] r(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private SparseArray y(View view) {
        SparseArray sparseArrayA = A(view);
        if (sparseArrayA != null) {
            return sparseArrayA;
        }
        SparseArray sparseArray = new SparseArray();
        view.setTag(AbstractC24197yC5.tag_accessibility_clickable_spans, sparseArray);
        return sparseArray;
    }

    public void A0(boolean z) {
        this.a.setFocused(z);
    }

    public CharSequence B() {
        return Build.VERSION.SDK_INT >= 30 ? b.b(this.a) : this.a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY");
    }

    public void B0(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.a.setHeading(z);
        } else {
            j0(2, z);
        }
    }

    public CharSequence C() {
        if (!G()) {
            return this.a.getText();
        }
        List listH = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List listH2 = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List listH3 = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List listH4 = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.a.getText(), 0, this.a.getText().length()));
        for (int i = 0; i < listH.size(); i++) {
            spannableString.setSpan(new C21727u2(((Integer) listH4.get(i)).intValue(), this, v().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) listH.get(i)).intValue(), ((Integer) listH2.get(i)).intValue(), ((Integer) listH3.get(i)).intValue());
        }
        return spannableString;
    }

    public void C0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.a.setHintText(charSequence);
        } else {
            this.a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public CharSequence D() {
        return Build.VERSION.SDK_INT >= 28 ? this.a.getTooltipText() : this.a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY");
    }

    public void D0(boolean z) {
        this.a.setImportantForAccessibility(z);
    }

    public String E() {
        return Build.VERSION.SDK_INT >= 33 ? c.g(this.a) : this.a.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
    }

    public void E0(View view) {
        this.a.setLabelFor(view);
    }

    public String F() {
        return this.a.getViewIdResourceName();
    }

    public void F0(int i) {
        this.a.setLiveRegion(i);
    }

    public void G0(boolean z) {
        this.a.setLongClickable(z);
    }

    public void H0(int i) {
        this.a.setMaxTextLength(i);
    }

    public boolean I() {
        return Build.VERSION.SDK_INT >= 34 ? d.f(this.a) : l(64);
    }

    public void I0(int i) {
        this.a.setMovementGranularities(i);
    }

    public boolean J() {
        return this.a.isAccessibilityFocused();
    }

    public void J0(CharSequence charSequence) {
        this.a.setPackageName(charSequence);
    }

    public boolean K() {
        return this.a.isCheckable();
    }

    public void K0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.a.setPaneTitle(charSequence);
        } else {
            this.a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public boolean L() {
        return this.a.isChecked();
    }

    public void L0(View view) {
        this.b = -1;
        this.a.setParent(view);
    }

    public boolean M() {
        return this.a.isClickable();
    }

    public void M0(View view, int i) {
        this.b = i;
        this.a.setParent(view, i);
    }

    public boolean N() {
        return this.a.isContextClickable();
    }

    public void N0(boolean z) {
        this.a.setPassword(z);
    }

    public boolean O() {
        return this.a.isEnabled();
    }

    public void O0(g gVar) {
        this.a.setRangeInfo((AccessibilityNodeInfo.RangeInfo) gVar.a);
    }

    public boolean P() {
        return this.a.isFocusable();
    }

    public void P0(CharSequence charSequence) {
        this.a.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", charSequence);
    }

    public boolean Q() {
        return this.a.isFocused();
    }

    public void Q0(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.a.setScreenReaderFocusable(z);
        } else {
            j0(1, z);
        }
    }

    public boolean R() {
        return l(67108864);
    }

    public void R0(boolean z) {
        this.a.setScrollable(z);
    }

    public boolean S() {
        return this.a.isImportantForAccessibility();
    }

    public void S0(boolean z) {
        this.a.setSelected(z);
    }

    public boolean T() {
        return this.a.isLongClickable();
    }

    public void T0(boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.a.setShowingHintText(z);
        } else {
            j0(4, z);
        }
    }

    public boolean U() {
        return this.a.isPassword();
    }

    public void U0(View view) {
        this.c = -1;
        this.a.setSource(view);
    }

    public boolean V() {
        return this.a.isScrollable();
    }

    public void V0(View view, int i) {
        this.c = i;
        this.a.setSource(view, i);
    }

    public boolean W() {
        return this.a.isSelected();
    }

    public void W0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            b.c(this.a, charSequence);
        } else {
            this.a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public boolean X() {
        return Build.VERSION.SDK_INT >= 26 ? this.a.isShowingHintText() : l(4);
    }

    public void X0(CharSequence charSequence) {
        this.a.setText(charSequence);
    }

    public boolean Y() {
        return Build.VERSION.SDK_INT >= 33 ? c.h(this.a) : l(8388608);
    }

    public void Y0(int i, int i2) {
        this.a.setTextSelection(i, i2);
    }

    public boolean Z() {
        return this.a.isVisibleToUser();
    }

    public void Z0(View view) {
        this.a.setTraversalAfter(view);
    }

    public void a(int i) {
        this.a.addAction(i);
    }

    public void a1(View view, int i) {
        this.a.setTraversalAfter(view, i);
    }

    public void b(a aVar) {
        this.a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.a);
    }

    public void b1(View view) {
        this.a.setTraversalBefore(view);
    }

    public void c(View view) {
        this.a.addChild(view);
    }

    public void c1(View view, int i) {
        this.a.setTraversalBefore(view, i);
    }

    public void d(View view, int i) {
        this.a.addChild(view, i);
    }

    public boolean d0(int i, Bundle bundle) {
        return this.a.performAction(i, bundle);
    }

    public void d1(String str) {
        this.a.setViewIdResourceName(str);
    }

    public void e1(boolean z) {
        this.a.setVisibleToUser(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof X2)) {
            return false;
        }
        X2 x2 = (X2) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.a;
        if (accessibilityNodeInfo == null) {
            if (x2.a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(x2.a)) {
            return false;
        }
        return this.c == x2.c && this.b == x2.b;
    }

    public void f(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 26) {
            g();
            g0(view);
            ClickableSpan[] clickableSpanArrR = r(charSequence);
            if (clickableSpanArrR == null || clickableSpanArrR.length <= 0) {
                return;
            }
            v().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", AbstractC24197yC5.accessibility_action_clickable_span);
            SparseArray sparseArrayY = y(view);
            for (int i = 0; i < clickableSpanArrR.length; i++) {
                int iH = H(clickableSpanArrR[i], sparseArrayY);
                sparseArrayY.put(iH, new WeakReference(clickableSpanArrR[i]));
                e(clickableSpanArrR[i], (Spanned) charSequence, iH);
            }
        }
    }

    public boolean f0(a aVar) {
        return this.a.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.a);
    }

    public AccessibilityNodeInfo f1() {
        return this.a;
    }

    public void h0(boolean z) {
        this.a.setAccessibilityFocused(z);
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public List i() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.a.getActionList();
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new a(actionList.get(i)));
        }
        return arrayList;
    }

    public void i0(List list) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.a.setAvailableExtraData(list);
        }
    }

    public int k() {
        return this.a.getActions();
    }

    public void k0(Rect rect) {
        this.a.setBoundsInParent(rect);
    }

    public void l0(Rect rect) {
        this.a.setBoundsInScreen(rect);
    }

    public void m(Rect rect) {
        this.a.getBoundsInParent(rect);
    }

    public void m0(boolean z) {
        this.a.setCanOpenPopup(z);
    }

    public void n(Rect rect) {
        this.a.getBoundsInScreen(rect);
    }

    public void n0(boolean z) {
        this.a.setCheckable(z);
    }

    public void o(Rect rect) {
        if (Build.VERSION.SDK_INT >= 34) {
            d.b(this.a, rect);
            return;
        }
        Rect rect2 = (Rect) this.a.getExtras().getParcelable("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY");
        if (rect2 != null) {
            rect.set(rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
    }

    public void o0(boolean z) {
        this.a.setChecked(z);
    }

    public int p() {
        return this.a.getChildCount();
    }

    public void p0(CharSequence charSequence) {
        this.a.setClassName(charSequence);
    }

    public CharSequence q() {
        return this.a.getClassName();
    }

    public void q0(boolean z) {
        this.a.setClickable(z);
    }

    public void r0(Object obj) {
        this.a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((e) obj).a);
    }

    public CharSequence s() {
        return Build.VERSION.SDK_INT >= 34 ? d.c(this.a) : this.a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY");
    }

    public void s0(Object obj) {
        this.a.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((f) obj).a);
    }

    public CharSequence t() {
        return this.a.getContentDescription();
    }

    public void t0(CharSequence charSequence) {
        this.a.setContentDescription(charSequence);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        m(rect);
        sb.append("; boundsInParent: " + rect);
        n(rect);
        sb.append("; boundsInScreen: " + rect);
        o(rect);
        sb.append("; boundsInWindow: " + rect);
        sb.append("; packageName: ");
        sb.append(z());
        sb.append("; className: ");
        sb.append(q());
        sb.append("; text: ");
        sb.append(C());
        sb.append("; error: ");
        sb.append(u());
        sb.append("; maxTextLength: ");
        sb.append(w());
        sb.append("; stateDescription: ");
        sb.append(B());
        sb.append("; contentDescription: ");
        sb.append(t());
        sb.append("; tooltipText: ");
        sb.append(D());
        sb.append("; viewIdResName: ");
        sb.append(F());
        sb.append("; uniqueId: ");
        sb.append(E());
        sb.append("; checkable: ");
        sb.append(K());
        sb.append("; checked: ");
        sb.append(L());
        sb.append("; focusable: ");
        sb.append(P());
        sb.append("; focused: ");
        sb.append(Q());
        sb.append("; selected: ");
        sb.append(W());
        sb.append("; clickable: ");
        sb.append(M());
        sb.append("; longClickable: ");
        sb.append(T());
        sb.append("; contextClickable: ");
        sb.append(N());
        sb.append("; enabled: ");
        sb.append(O());
        sb.append("; password: ");
        sb.append(U());
        sb.append("; scrollable: " + V());
        sb.append("; containerTitle: ");
        sb.append(s());
        sb.append("; granularScrollingSupported: ");
        sb.append(R());
        sb.append("; importantForAccessibility: ");
        sb.append(S());
        sb.append("; visible: ");
        sb.append(Z());
        sb.append("; isTextSelectable: ");
        sb.append(Y());
        sb.append("; accessibilityDataSensitive: ");
        sb.append(I());
        sb.append("; [");
        List listI = i();
        for (int i = 0; i < listI.size(); i++) {
            a aVar = (a) listI.get(i);
            String strJ = j(aVar.b());
            if (strJ.equals("ACTION_UNKNOWN") && aVar.c() != null) {
                strJ = aVar.c().toString();
            }
            sb.append(strJ);
            if (i != listI.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public CharSequence u() {
        return this.a.getError();
    }

    public void u0(boolean z) {
        this.a.setContentInvalid(z);
    }

    public Bundle v() {
        return this.a.getExtras();
    }

    public void v0(boolean z) {
        this.a.setDismissable(z);
    }

    public int w() {
        return this.a.getMaxTextLength();
    }

    public void w0(boolean z) {
        this.a.setEditable(z);
    }

    public int x() {
        return this.a.getMovementGranularities();
    }

    public void x0(boolean z) {
        this.a.setEnabled(z);
    }

    public void y0(CharSequence charSequence) {
        this.a.setError(charSequence);
    }

    public CharSequence z() {
        return this.a.getPackageName();
    }

    public void z0(boolean z) {
        this.a.setFocusable(z);
    }

    private X2(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.a = accessibilityNodeInfo;
    }

    public void e0() {
    }
}
