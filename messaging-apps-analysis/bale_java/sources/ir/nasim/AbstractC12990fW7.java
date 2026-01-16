package ir.nasim;

import android.content.ClipData;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.OnReceiveContentListener;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import ir.nasim.B98;
import ir.nasim.C22317v2;
import ir.nasim.O98;
import ir.nasim.X2;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

/* renamed from: ir.nasim.fW7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC12990fW7 {
    private static WeakHashMap a = null;
    private static Field b = null;
    private static boolean c = false;
    private static final int[] d = {AbstractC24197yC5.accessibility_custom_action_0, AbstractC24197yC5.accessibility_custom_action_1, AbstractC24197yC5.accessibility_custom_action_2, AbstractC24197yC5.accessibility_custom_action_3, AbstractC24197yC5.accessibility_custom_action_4, AbstractC24197yC5.accessibility_custom_action_5, AbstractC24197yC5.accessibility_custom_action_6, AbstractC24197yC5.accessibility_custom_action_7, AbstractC24197yC5.accessibility_custom_action_8, AbstractC24197yC5.accessibility_custom_action_9, AbstractC24197yC5.accessibility_custom_action_10, AbstractC24197yC5.accessibility_custom_action_11, AbstractC24197yC5.accessibility_custom_action_12, AbstractC24197yC5.accessibility_custom_action_13, AbstractC24197yC5.accessibility_custom_action_14, AbstractC24197yC5.accessibility_custom_action_15, AbstractC24197yC5.accessibility_custom_action_16, AbstractC24197yC5.accessibility_custom_action_17, AbstractC24197yC5.accessibility_custom_action_18, AbstractC24197yC5.accessibility_custom_action_19, AbstractC24197yC5.accessibility_custom_action_20, AbstractC24197yC5.accessibility_custom_action_21, AbstractC24197yC5.accessibility_custom_action_22, AbstractC24197yC5.accessibility_custom_action_23, AbstractC24197yC5.accessibility_custom_action_24, AbstractC24197yC5.accessibility_custom_action_25, AbstractC24197yC5.accessibility_custom_action_26, AbstractC24197yC5.accessibility_custom_action_27, AbstractC24197yC5.accessibility_custom_action_28, AbstractC24197yC5.accessibility_custom_action_29, AbstractC24197yC5.accessibility_custom_action_30, AbstractC24197yC5.accessibility_custom_action_31};
    private static final TJ4 e = new TJ4() { // from class: ir.nasim.eW7
        @Override // ir.nasim.TJ4
        public final C5219Ik1 a(C5219Ik1 c5219Ik1) {
            return AbstractC12990fW7.X(c5219Ik1);
        }
    };
    private static final e f = new e();

    /* renamed from: ir.nasim.fW7$a */
    class a extends f {
        a(int i, Class cls, int i2) {
            super(i, cls, i2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ir.nasim.AbstractC12990fW7.f
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Boolean c(View view) {
            return Boolean.valueOf(l.d(view));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ir.nasim.AbstractC12990fW7.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, Boolean bool) {
            l.j(view, bool.booleanValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ir.nasim.AbstractC12990fW7.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    /* renamed from: ir.nasim.fW7$b */
    class b extends f {
        b(int i, Class cls, int i2, int i3) {
            super(i, cls, i2, i3);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ir.nasim.AbstractC12990fW7.f
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public CharSequence c(View view) {
            return l.b(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ir.nasim.AbstractC12990fW7.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, CharSequence charSequence) {
            l.h(view, charSequence);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ir.nasim.AbstractC12990fW7.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    /* renamed from: ir.nasim.fW7$c */
    class c extends f {
        c(int i, Class cls, int i2, int i3) {
            super(i, cls, i2, i3);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ir.nasim.AbstractC12990fW7.f
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public CharSequence c(View view) {
            return n.b(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ir.nasim.AbstractC12990fW7.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, CharSequence charSequence) {
            n.e(view, charSequence);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ir.nasim.AbstractC12990fW7.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    /* renamed from: ir.nasim.fW7$d */
    class d extends f {
        d(int i, Class cls, int i2) {
            super(i, cls, i2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ir.nasim.AbstractC12990fW7.f
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Boolean c(View view) {
            return Boolean.valueOf(l.c(view));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ir.nasim.AbstractC12990fW7.f
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, Boolean bool) {
            l.g(view, bool.booleanValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ir.nasim.AbstractC12990fW7.f
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    /* renamed from: ir.nasim.fW7$f */
    static abstract class f {
        private final int a;
        private final Class b;
        private final int c;
        private final int d;

        f(int i, Class cls, int i2) {
            this(i, cls, 0, i2);
        }

        private boolean b() {
            return Build.VERSION.SDK_INT >= this.c;
        }

        boolean a(Boolean bool, Boolean bool2) {
            return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
        }

        abstract Object c(View view);

        abstract void d(View view, Object obj);

        Object e(View view) {
            if (b()) {
                return c(view);
            }
            Object tag = view.getTag(this.a);
            if (this.b.isInstance(tag)) {
                return tag;
            }
            return null;
        }

        void f(View view, Object obj) {
            if (b()) {
                d(view, obj);
            } else if (g(e(view), obj)) {
                AbstractC12990fW7.j(view);
                view.setTag(this.a, obj);
                AbstractC12990fW7.Y(view, this.d);
            }
        }

        abstract boolean g(Object obj, Object obj2);

        f(int i, Class cls, int i2, int i3) {
            this.a = i;
            this.b = cls;
            this.d = i2;
            this.c = i3;
        }
    }

    /* renamed from: ir.nasim.fW7$g */
    static class g {
        static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        static void c(View view) {
            view.requestApplyInsets();
        }
    }

    /* renamed from: ir.nasim.fW7$h */
    private static class h {

        /* renamed from: ir.nasim.fW7$h$a */
        class a implements View.OnApplyWindowInsetsListener {
            O98 a = null;
            final /* synthetic */ View b;
            final /* synthetic */ InterfaceC22474vI4 c;

            a(View view, InterfaceC22474vI4 interfaceC22474vI4) {
                this.b = view;
                this.c = interfaceC22474vI4;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                O98 o98A = O98.A(windowInsets, view);
                int i = Build.VERSION.SDK_INT;
                if (i < 30) {
                    h.a(windowInsets, this.b);
                    if (o98A.equals(this.a)) {
                        return this.c.b(view, o98A).y();
                    }
                }
                this.a = o98A;
                O98 o98B = this.c.b(view, o98A);
                if (i >= 30) {
                    return o98B.y();
                }
                AbstractC12990fW7.m0(view);
                return o98B.y();
            }
        }

        static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(AbstractC24197yC5.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        static O98 b(View view, O98 o98, Rect rect) {
            WindowInsets windowInsetsY = o98.y();
            if (windowInsetsY != null) {
                return O98.A(view.computeSystemWindowInsets(windowInsetsY, rect), view);
            }
            rect.setEmpty();
            return o98;
        }

        static boolean c(View view, float f, float f2, boolean z) {
            return view.dispatchNestedFling(f, f2, z);
        }

        static boolean d(View view, float f, float f2) {
            return view.dispatchNestedPreFling(f, f2);
        }

        static boolean e(View view, int i, int i2, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i, i2, iArr, iArr2);
        }

        static boolean f(View view, int i, int i2, int i3, int i4, int[] iArr) {
            return view.dispatchNestedScroll(i, i2, i3, i4, iArr);
        }

        static ColorStateList g(View view) {
            return view.getBackgroundTintList();
        }

        static PorterDuff.Mode h(View view) {
            return view.getBackgroundTintMode();
        }

        static float i(View view) {
            return view.getElevation();
        }

        public static O98 j(View view) {
            return O98.a.a(view);
        }

        static String k(View view) {
            return view.getTransitionName();
        }

        static float l(View view) {
            return view.getTranslationZ();
        }

        static float m(View view) {
            return view.getZ();
        }

        static boolean n(View view) {
            return view.hasNestedScrollingParent();
        }

        static boolean o(View view) {
            return view.isImportantForAccessibility();
        }

        static boolean p(View view) {
            return view.isNestedScrollingEnabled();
        }

        static void q(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        static void r(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        static void s(View view, float f) {
            view.setElevation(f);
        }

        static void t(View view, boolean z) {
            view.setNestedScrollingEnabled(z);
        }

        static void u(View view, InterfaceC22474vI4 interfaceC22474vI4) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(AbstractC24197yC5.tag_on_apply_window_listener, interfaceC22474vI4);
            }
            if (interfaceC22474vI4 == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(AbstractC24197yC5.tag_window_insets_animation_callback));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, interfaceC22474vI4));
            }
        }

        static void v(View view, String str) {
            view.setTransitionName(str);
        }

        static void w(View view, float f) {
            view.setTranslationZ(f);
        }

        static void x(View view, float f) {
            view.setZ(f);
        }

        static boolean y(View view, int i) {
            return view.startNestedScroll(i);
        }

        static void z(View view) {
            view.stopNestedScroll();
        }
    }

    /* renamed from: ir.nasim.fW7$i */
    private static class i {
        public static O98 a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            O98 o98Z = O98.z(rootWindowInsets);
            o98Z.w(o98Z);
            o98Z.d(view.getRootView());
            return o98Z;
        }

        static int b(View view) {
            return view.getScrollIndicators();
        }

        static void c(View view, int i) {
            view.setScrollIndicators(i);
        }

        static void d(View view, int i, int i2) {
            view.setScrollIndicators(i, i2);
        }
    }

    /* renamed from: ir.nasim.fW7$j */
    static class j {
        static void a(View view) {
            view.cancelDragAndDrop();
        }

        static void b(View view) {
            view.dispatchFinishTemporaryDetach();
        }

        static void c(View view) {
            view.dispatchStartTemporaryDetach();
        }

        static void d(View view, PointerIcon pointerIcon) {
            view.setPointerIcon(pointerIcon);
        }

        static boolean e(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i) {
            return view.startDragAndDrop(clipData, dragShadowBuilder, obj, i);
        }

        static void f(View view, View.DragShadowBuilder dragShadowBuilder) {
            view.updateDragShadow(dragShadowBuilder);
        }
    }

    /* renamed from: ir.nasim.fW7$k */
    static class k {
        static void a(View view, Collection<View> collection, int i) {
            view.addKeyboardNavigationClusters(collection, i);
        }

        public static AutofillId b(View view) {
            return view.getAutofillId();
        }

        static int c(View view) {
            return view.getImportantForAutofill();
        }

        static int d(View view) {
            return view.getNextClusterForwardId();
        }

        static boolean e(View view) {
            return view.hasExplicitFocusable();
        }

        static boolean f(View view) {
            return view.isFocusedByDefault();
        }

        static boolean g(View view) {
            return view.isImportantForAutofill();
        }

        static boolean h(View view) {
            return view.isKeyboardNavigationCluster();
        }

        static View i(View view, View view2, int i) {
            return view.keyboardNavigationClusterSearch(view2, i);
        }

        static boolean j(View view) {
            return view.restoreDefaultFocus();
        }

        static void k(View view, String... strArr) {
            view.setAutofillHints(strArr);
        }

        static void l(View view, boolean z) {
            view.setFocusedByDefault(z);
        }

        static void m(View view, int i) {
            view.setImportantForAutofill(i);
        }

        static void n(View view, boolean z) {
            view.setKeyboardNavigationCluster(z);
        }

        static void o(View view, int i) {
            view.setNextClusterForwardId(i);
        }

        static void p(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    /* renamed from: ir.nasim.fW7$l */
    static class l {
        static void a(View view, final q qVar) {
            C24792zC6 c24792zC6 = (C24792zC6) view.getTag(AbstractC24197yC5.tag_unhandled_key_listeners);
            if (c24792zC6 == null) {
                c24792zC6 = new C24792zC6();
                view.setTag(AbstractC24197yC5.tag_unhandled_key_listeners, c24792zC6);
            }
            Objects.requireNonNull(qVar);
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener = new View.OnUnhandledKeyEventListener(qVar) { // from class: ir.nasim.gW7
                @Override // android.view.View.OnUnhandledKeyEventListener
                public final boolean onUnhandledKeyEvent(View view2, KeyEvent keyEvent) {
                    throw null;
                }
            };
            c24792zC6.put(qVar, onUnhandledKeyEventListener);
            view.addOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        static CharSequence b(View view) {
            return view.getAccessibilityPaneTitle();
        }

        static boolean c(View view) {
            return view.isAccessibilityHeading();
        }

        static boolean d(View view) {
            return view.isScreenReaderFocusable();
        }

        static void e(View view, q qVar) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            C24792zC6 c24792zC6 = (C24792zC6) view.getTag(AbstractC24197yC5.tag_unhandled_key_listeners);
            if (c24792zC6 == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) c24792zC6.get(qVar)) == null) {
                return;
            }
            view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        static <T> T f(View view, int i) {
            return (T) view.requireViewById(i);
        }

        static void g(View view, boolean z) {
            view.setAccessibilityHeading(z);
        }

        static void h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        public static void i(View view, AbstractC20710sU abstractC20710sU) {
            view.setAutofillId(null);
        }

        static void j(View view, boolean z) {
            view.setScreenReaderFocusable(z);
        }
    }

    /* renamed from: ir.nasim.fW7$m */
    private static class m {
        static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        static ContentCaptureSession b(View view) {
            return view.getContentCaptureSession();
        }

        static List<Rect> c(View view) {
            return view.getSystemGestureExclusionRects();
        }

        static void d(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i2);
        }

        static void e(View view, AbstractC20275rk1 abstractC20275rk1) {
            view.setContentCaptureSession(null);
        }

        static void f(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    /* renamed from: ir.nasim.fW7$n */
    private static class n {
        static int a(View view) {
            return view.getImportantForContentCapture();
        }

        static CharSequence b(View view) {
            return view.getStateDescription();
        }

        static boolean c(View view) {
            return view.isImportantForContentCapture();
        }

        static void d(View view, int i) {
            view.setImportantForContentCapture(i);
        }

        static void e(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    /* renamed from: ir.nasim.fW7$o */
    private static final class o {
        public static String[] a(View view) {
            return view.getReceiveContentMimeTypes();
        }

        public static C5219Ik1 b(View view, C5219Ik1 c5219Ik1) {
            ContentInfo contentInfoF = c5219Ik1.f();
            ContentInfo contentInfoPerformReceiveContent = view.performReceiveContent(contentInfoF);
            if (contentInfoPerformReceiveContent == null) {
                return null;
            }
            return contentInfoPerformReceiveContent == contentInfoF ? c5219Ik1 : C5219Ik1.g(contentInfoPerformReceiveContent);
        }

        public static void c(View view, String[] strArr, SJ4 sj4) {
            if (sj4 == null) {
                view.setOnReceiveContentListener(strArr, null);
            } else {
                view.setOnReceiveContentListener(strArr, new p(sj4));
            }
        }
    }

    /* renamed from: ir.nasim.fW7$p */
    private static final class p implements OnReceiveContentListener {
        private final SJ4 a;

        p(SJ4 sj4) {
            this.a = sj4;
        }

        public ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
            C5219Ik1 c5219Ik1G = C5219Ik1.g(contentInfo);
            C5219Ik1 c5219Ik1A = this.a.a(view, c5219Ik1G);
            if (c5219Ik1A == null) {
                return null;
            }
            return c5219Ik1A == c5219Ik1G ? contentInfo : c5219Ik1A.f();
        }
    }

    /* renamed from: ir.nasim.fW7$q */
    public interface q {
    }

    /* renamed from: ir.nasim.fW7$r */
    static class r {
        private static final ArrayList d = new ArrayList();
        private WeakHashMap a = null;
        private SparseArray b = null;
        private WeakReference c = null;

        r() {
        }

        static r a(View view) {
            r rVar = (r) view.getTag(AbstractC24197yC5.tag_unhandled_key_event_manager);
            if (rVar != null) {
                return rVar;
            }
            r rVar2 = new r();
            view.setTag(AbstractC24197yC5.tag_unhandled_key_event_manager, rVar2);
            return rVar2;
        }

        private View c(View view, KeyEvent keyEvent) {
            WeakHashMap weakHashMap = this.a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View viewC = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (viewC != null) {
                            return viewC;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private SparseArray d() {
            if (this.b == null) {
                this.b = new SparseArray();
            }
            return this.b;
        }

        private boolean e(View view, KeyEvent keyEvent) {
            int size;
            ArrayList arrayList = (ArrayList) view.getTag(AbstractC24197yC5.tag_unhandled_key_listeners);
            if (arrayList == null || arrayList.size() - 1 < 0) {
                return false;
            }
            AbstractC18350oW3.a(arrayList.get(size));
            throw null;
        }

        private void g() {
            WeakHashMap weakHashMap = this.a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList = d;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                try {
                    if (this.a == null) {
                        this.a = new WeakHashMap();
                    }
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ArrayList arrayList2 = d;
                        View view = (View) ((WeakReference) arrayList2.get(size)).get();
                        if (view == null) {
                            arrayList2.remove(size);
                        } else {
                            this.a.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.a.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View viewC = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (viewC != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference(viewC));
                }
            }
            return viewC != null;
        }

        boolean f(KeyEvent keyEvent) {
            WeakReference weakReference;
            int iIndexOfKey;
            WeakReference weakReference2 = this.c;
            if (weakReference2 != null && weakReference2.get() == keyEvent) {
                return false;
            }
            this.c = new WeakReference(keyEvent);
            SparseArray sparseArrayD = d();
            if (keyEvent.getAction() != 1 || (iIndexOfKey = sparseArrayD.indexOfKey(keyEvent.getKeyCode())) < 0) {
                weakReference = null;
            } else {
                weakReference = (WeakReference) sparseArrayD.valueAt(iIndexOfKey);
                sparseArrayD.removeAt(iIndexOfKey);
            }
            if (weakReference == null) {
                weakReference = (WeakReference) sparseArrayD.get(keyEvent.getKeyCode());
            }
            if (weakReference == null) {
                return false;
            }
            View view = (View) weakReference.get();
            if (view != null && view.isAttachedToWindow()) {
                e(view, keyEvent);
            }
            return true;
        }
    }

    public static int A(View view) {
        return view.getLayoutDirection();
    }

    public static void A0(View view, int i2) {
        view.setImportantForAccessibility(i2);
    }

    public static int B(View view) {
        return view.getMinimumHeight();
    }

    private static void B0(View view) {
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    public static int C(View view) {
        return view.getMinimumWidth();
    }

    public static void C0(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            k.m(view, i2);
        }
    }

    public static String[] D(View view) {
        return Build.VERSION.SDK_INT >= 31 ? o.a(view) : (String[]) view.getTag(AbstractC24197yC5.tag_on_receive_content_mime_types);
    }

    public static void D0(View view, boolean z) {
        h.t(view, z);
    }

    public static int E(View view) {
        return view.getPaddingEnd();
    }

    public static void E0(View view, InterfaceC22474vI4 interfaceC22474vI4) {
        h.u(view, interfaceC22474vI4);
    }

    public static int F(View view) {
        return view.getPaddingStart();
    }

    public static void F0(View view, int i2, int i3, int i4, int i5) {
        view.setPaddingRelative(i2, i3, i4, i5);
    }

    public static ViewParent G(View view) {
        return view.getParentForAccessibility();
    }

    public static void G0(View view, C5187Ig5 c5187Ig5) {
        j.d(view, (PointerIcon) (c5187Ig5 != null ? c5187Ig5.a() : null));
    }

    public static O98 H(View view) {
        return i.a(view);
    }

    public static void H0(View view, boolean z) {
        o0().f(view, Boolean.valueOf(z));
    }

    public static CharSequence I(View view) {
        return (CharSequence) P0().e(view);
    }

    public static void I0(View view, int i2, int i3) {
        i.d(view, i2, i3);
    }

    public static String J(View view) {
        return h.k(view);
    }

    public static void J0(View view, CharSequence charSequence) {
        P0().f(view, charSequence);
    }

    public static float K(View view) {
        return h.l(view);
    }

    public static void K0(View view, List list) {
        if (Build.VERSION.SDK_INT >= 29) {
            m.f(view, list);
        }
    }

    public static int L(View view) {
        return view.getWindowSystemUiVisibility();
    }

    public static void L0(View view, String str) {
        h.v(view, str);
    }

    public static float M(View view) {
        return h.m(view);
    }

    public static void M0(View view, float f2) {
        h.w(view, f2);
    }

    public static boolean N(View view) {
        return m(view) != null;
    }

    public static void N0(View view, B98.b bVar) {
        B98.d(view, bVar);
    }

    public static boolean O(View view) {
        return view.hasOnClickListeners();
    }

    public static void O0(View view, float f2) {
        h.x(view, f2);
    }

    public static boolean P(View view) {
        return view.hasOverlappingRendering();
    }

    private static f P0() {
        return new c(AbstractC24197yC5.tag_state_description, CharSequence.class, 64, 30);
    }

    public static boolean Q(View view) {
        return view.hasTransientState();
    }

    public static void Q0(View view) {
        h.z(view);
    }

    public static boolean R(View view) {
        Boolean bool = (Boolean) b().e(view);
        return bool != null && bool.booleanValue();
    }

    public static boolean S(View view) {
        return view.isAttachedToWindow();
    }

    public static boolean T(View view) {
        return view.isLaidOut();
    }

    public static boolean U(View view) {
        return h.p(view);
    }

    public static boolean V(View view) {
        return view.isPaddingRelative();
    }

    public static boolean W(View view) {
        Boolean bool = (Boolean) o0().e(view);
        return bool != null && bool.booleanValue();
    }

    static void Y(View view, int i2) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z = o(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i2);
                if (z) {
                    accessibilityEventObtain.getText().add(o(view));
                    B0(view);
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i2 == 32) {
                AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.setEventType(32);
                accessibilityEventObtain2.setContentChangeTypes(i2);
                accessibilityEventObtain2.setSource(view);
                view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
                accessibilityEventObtain2.getText().add(o(view));
                accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
                return;
            }
            if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i2);
                } catch (AbstractMethodError e2) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e2);
                }
            }
        }
    }

    public static void Z(View view, int i2) {
        view.offsetLeftAndRight(i2);
    }

    public static void a0(View view, int i2) {
        view.offsetTopAndBottom(i2);
    }

    private static f b() {
        return new d(AbstractC24197yC5.tag_accessibility_heading, Boolean.class, 28);
    }

    public static O98 b0(View view, O98 o98) {
        WindowInsets windowInsetsY = o98.y();
        if (windowInsetsY != null) {
            WindowInsets windowInsetsB = g.b(view, windowInsetsY);
            if (!windowInsetsB.equals(windowInsetsY)) {
                return O98.A(windowInsetsB, view);
            }
        }
        return o98;
    }

    public static int c(View view, CharSequence charSequence, InterfaceC10698c3 interfaceC10698c3) {
        int iQ = q(view, charSequence);
        if (iQ != -1) {
            d(view, new X2.a(iQ, charSequence, interfaceC10698c3));
        }
        return iQ;
    }

    public static void c0(View view, X2 x2) {
        view.onInitializeAccessibilityNodeInfo(x2.f1());
    }

    private static void d(View view, X2.a aVar) {
        j(view);
        k0(aVar.b(), view);
        p(view).add(aVar);
        Y(view, 0);
    }

    private static f d0() {
        return new b(AbstractC24197yC5.tag_accessibility_pane_title, CharSequence.class, 8, 28);
    }

    public static C23798xX7 e(View view) {
        if (a == null) {
            a = new WeakHashMap();
        }
        C23798xX7 c23798xX7 = (C23798xX7) a.get(view);
        if (c23798xX7 != null) {
            return c23798xX7;
        }
        C23798xX7 c23798xX72 = new C23798xX7(view);
        a.put(view, c23798xX72);
        return c23798xX72;
    }

    public static boolean e0(View view, int i2, Bundle bundle) {
        return view.performAccessibilityAction(i2, bundle);
    }

    public static O98 f(View view, O98 o98, Rect rect) {
        return h.b(view, o98, rect);
    }

    public static C5219Ik1 f0(View view, C5219Ik1 c5219Ik1) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + c5219Ik1 + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return o.b(view, c5219Ik1);
        }
        SJ4 sj4 = (SJ4) view.getTag(AbstractC24197yC5.tag_on_receive_content_listener);
        if (sj4 == null) {
            return w(view).a(c5219Ik1);
        }
        C5219Ik1 c5219Ik1A = sj4.a(view, c5219Ik1);
        if (c5219Ik1A == null) {
            return null;
        }
        return w(view).a(c5219Ik1A);
    }

    public static O98 g(View view, O98 o98) {
        WindowInsets windowInsetsY = o98.y();
        if (windowInsetsY != null) {
            WindowInsets windowInsetsA = g.a(view, windowInsetsY);
            if (!windowInsetsA.equals(windowInsetsY)) {
                return O98.A(windowInsetsA, view);
            }
        }
        return o98;
    }

    public static void g0(View view) {
        view.postInvalidateOnAnimation();
    }

    static boolean h(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return r.a(view).b(view, keyEvent);
    }

    public static void h0(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    static boolean i(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return r.a(view).f(keyEvent);
    }

    public static void i0(View view, Runnable runnable, long j2) {
        view.postOnAnimationDelayed(runnable, j2);
    }

    static void j(View view) {
        C22317v2 c22317v2L = l(view);
        if (c22317v2L == null) {
            c22317v2L = new C22317v2();
        }
        p0(view, c22317v2L);
    }

    public static void j0(View view, int i2) {
        k0(i2, view);
        Y(view, 0);
    }

    public static int k() {
        return View.generateViewId();
    }

    private static void k0(int i2, View view) {
        List listP = p(view);
        for (int i3 = 0; i3 < listP.size(); i3++) {
            if (((X2.a) listP.get(i3)).b() == i2) {
                listP.remove(i3);
                return;
            }
        }
    }

    public static C22317v2 l(View view) {
        View.AccessibilityDelegate accessibilityDelegateM = m(view);
        if (accessibilityDelegateM == null) {
            return null;
        }
        return accessibilityDelegateM instanceof C22317v2.a ? ((C22317v2.a) accessibilityDelegateM).a : new C22317v2(accessibilityDelegateM);
    }

    public static void l0(View view, X2.a aVar, CharSequence charSequence, InterfaceC10698c3 interfaceC10698c3) {
        if (interfaceC10698c3 == null && charSequence == null) {
            j0(view, aVar.b());
        } else {
            d(view, aVar.a(charSequence, interfaceC10698c3));
        }
    }

    private static View.AccessibilityDelegate m(View view) {
        return Build.VERSION.SDK_INT >= 29 ? m.a(view) : n(view);
    }

    public static void m0(View view) {
        g.c(view);
    }

    private static View.AccessibilityDelegate n(View view) {
        if (c) {
            return null;
        }
        if (b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                c = true;
                return null;
            }
        }
        try {
            Object obj = b.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            c = true;
            return null;
        }
    }

    public static void n0(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 29) {
            m.d(view, context, iArr, attributeSet, typedArray, i2, i3);
        }
    }

    public static CharSequence o(View view) {
        return (CharSequence) d0().e(view);
    }

    private static f o0() {
        return new a(AbstractC24197yC5.tag_screen_reader_focusable, Boolean.class, 28);
    }

    private static List p(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(AbstractC24197yC5.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(AbstractC24197yC5.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    public static void p0(View view, C22317v2 c22317v2) {
        if (c22317v2 == null && (m(view) instanceof C22317v2.a)) {
            c22317v2 = new C22317v2();
        }
        B0(view);
        view.setAccessibilityDelegate(c22317v2 == null ? null : c22317v2.d());
    }

    private static int q(View view, CharSequence charSequence) {
        List listP = p(view);
        for (int i2 = 0; i2 < listP.size(); i2++) {
            if (TextUtils.equals(charSequence, ((X2.a) listP.get(i2)).c())) {
                return ((X2.a) listP.get(i2)).b();
            }
        }
        int i3 = -1;
        int i4 = 0;
        while (true) {
            int[] iArr = d;
            if (i4 >= iArr.length || i3 != -1) {
                break;
            }
            int i5 = iArr[i4];
            boolean z = true;
            for (int i6 = 0; i6 < listP.size(); i6++) {
                z &= ((X2.a) listP.get(i6)).b() != i5;
            }
            if (z) {
                i3 = i5;
            }
            i4++;
        }
        return i3;
    }

    public static void q0(View view, boolean z) {
        b().f(view, Boolean.valueOf(z));
    }

    public static ColorStateList r(View view) {
        return h.g(view);
    }

    public static void r0(View view, int i2) {
        view.setAccessibilityLiveRegion(i2);
    }

    public static PorterDuff.Mode s(View view) {
        return h.h(view);
    }

    public static void s0(View view, CharSequence charSequence) {
        d0().f(view, charSequence);
        if (charSequence != null) {
            f.a(view);
        } else {
            f.d(view);
        }
    }

    public static Rect t(View view) {
        return view.getClipBounds();
    }

    public static void t0(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static Display u(View view) {
        return view.getDisplay();
    }

    public static void u0(View view, ColorStateList colorStateList) {
        h.q(view, colorStateList);
    }

    public static float v(View view) {
        return h.i(view);
    }

    public static void v0(View view, PorterDuff.Mode mode) {
        h.r(view, mode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static TJ4 w(View view) {
        return view instanceof TJ4 ? (TJ4) view : e;
    }

    public static void w0(View view, Rect rect) {
        view.setClipBounds(rect);
    }

    public static boolean x(View view) {
        return view.getFitsSystemWindows();
    }

    public static void x0(View view, float f2) {
        h.s(view, f2);
    }

    public static int y(View view) {
        return view.getImportantForAccessibility();
    }

    public static void y0(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static int z(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return k.c(view);
        }
        return 0;
    }

    public static void z0(View view, boolean z) {
        view.setHasTransientState(z);
    }

    /* renamed from: ir.nasim.fW7$e */
    static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {
        private final WeakHashMap a = new WeakHashMap();

        e() {
        }

        private void b(Map.Entry entry) {
            View view = (View) entry.getKey();
            boolean zBooleanValue = ((Boolean) entry.getValue()).booleanValue();
            boolean z = view.isShown() && view.getWindowVisibility() == 0;
            if (zBooleanValue != z) {
                AbstractC12990fW7.Y(view, z ? 16 : 32);
                entry.setValue(Boolean.valueOf(z));
            }
        }

        private void c(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        private void e(View view) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        void a(View view) {
            this.a.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(this);
            if (view.isAttachedToWindow()) {
                c(view);
            }
        }

        void d(View view) {
            this.a.remove(view);
            view.removeOnAttachStateChangeListener(this);
            e(view);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                Iterator it = this.a.entrySet().iterator();
                while (it.hasNext()) {
                    b((Map.Entry) it.next());
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            c(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C5219Ik1 X(C5219Ik1 c5219Ik1) {
        return c5219Ik1;
    }
}
