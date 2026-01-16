package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.os.Build;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;

/* loaded from: classes8.dex */
public final class YT7 extends GestureDetector.SimpleOnGestureListener {
    private static final a l = new a(null);
    private final Context a;
    private InterfaceC15796kB2 b;
    private InterfaceC14603iB2 c;
    private InterfaceC14603iB2 d;
    private InterfaceC14603iB2 e;
    private InterfaceC14603iB2 f;
    private InterfaceC15796kB2 g;
    private InterfaceC15796kB2 h;
    private boolean i;
    private EnumC7541Sd6 j;
    private final AccessibilityManager k;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ YT7(Context context, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC14603iB2 interfaceC14603iB23, InterfaceC14603iB2 interfaceC14603iB24, InterfaceC15796kB2 interfaceC15796kB22, InterfaceC15796kB2 interfaceC15796kB23, int i, ED1 ed1) {
        this(context, (i & 2) != 0 ? new InterfaceC15796kB2() { // from class: ir.nasim.RT7
            @Override // ir.nasim.InterfaceC15796kB2
            public final Object q(Object obj, Object obj2, Object obj3) {
                return Boolean.valueOf(YT7.h((EnumC7541Sd6) obj, ((Float) obj2).floatValue(), ((Float) obj3).floatValue()));
            }
        } : interfaceC15796kB2, (i & 4) != 0 ? new InterfaceC14603iB2() { // from class: ir.nasim.ST7
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(YT7.i(((Float) obj).floatValue(), ((Float) obj2).floatValue()));
            }
        } : interfaceC14603iB2, (i & 8) != 0 ? new InterfaceC14603iB2() { // from class: ir.nasim.TT7
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(YT7.j(((Float) obj).floatValue(), ((Float) obj2).floatValue()));
            }
        } : interfaceC14603iB22, (i & 16) != 0 ? new InterfaceC14603iB2() { // from class: ir.nasim.UT7
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(YT7.k(((Float) obj).floatValue(), ((Float) obj2).floatValue()));
            }
        } : interfaceC14603iB23, (i & 32) != 0 ? new InterfaceC14603iB2() { // from class: ir.nasim.VT7
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return YT7.l(((Float) obj).floatValue(), ((Float) obj2).floatValue());
            }
        } : interfaceC14603iB24, (i & 64) != 0 ? new InterfaceC15796kB2() { // from class: ir.nasim.WT7
            @Override // ir.nasim.InterfaceC15796kB2
            public final Object q(Object obj, Object obj2, Object obj3) {
                return Boolean.valueOf(YT7.m((EnumC7541Sd6) obj, ((Float) obj2).floatValue(), ((Float) obj3).floatValue()));
            }
        } : interfaceC15796kB22, (i & 128) != 0 ? new InterfaceC15796kB2() { // from class: ir.nasim.XT7
            @Override // ir.nasim.InterfaceC15796kB2
            public final Object q(Object obj, Object obj2, Object obj3) {
                return YT7.n((EnumC7541Sd6) obj, ((Float) obj2).floatValue(), ((Float) obj3).floatValue());
            }
        } : interfaceC15796kB23);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(EnumC7541Sd6 enumC7541Sd6, float f, float f2) {
        AbstractC13042fc3.i(enumC7541Sd6, "<unused var>");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i(float f, float f2) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j(float f, float f2) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean k(float f, float f2) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(float f, float f2) {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(EnumC7541Sd6 enumC7541Sd6, float f, float f2) {
        AbstractC13042fc3.i(enumC7541Sd6, "<unused var>");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(EnumC7541Sd6 enumC7541Sd6, float f, float f2) {
        return C19938rB7.a;
    }

    private final AccessibilityManager o() {
        AccessibilityManager accessibilityManager = this.k;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return null;
        }
        return accessibilityManager;
    }

    public final void A(InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "<set-?>");
        this.d = interfaceC14603iB2;
    }

    public final void B(InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "<set-?>");
        this.e = interfaceC14603iB2;
    }

    public final void C(InterfaceC15796kB2 interfaceC15796kB2) {
        AbstractC13042fc3.i(interfaceC15796kB2, "<set-?>");
        this.g = interfaceC15796kB2;
    }

    public final void D(InterfaceC15796kB2 interfaceC15796kB2) {
        AbstractC13042fc3.i(interfaceC15796kB2, "<set-?>");
        this.h = interfaceC15796kB2;
    }

    public final void E(EnumC7541Sd6 enumC7541Sd6) {
        this.j = enumC7541Sd6;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        AbstractC13042fc3.i(motionEvent, "e");
        C19406qI3.a("VideoPlayerGestureListener", "onDoubleTap(" + motionEvent + Separators.RPAREN, new Object[0]);
        boolean zBooleanValue = ((Boolean) this.c.invoke(Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()))).booleanValue();
        if (zBooleanValue) {
            AccessibilityEvent accessibilityEventA = Build.VERSION.SDK_INT >= 30 ? QT7.a() : AccessibilityEvent.obtain();
            accessibilityEventA.setClassName(YT7.class.getName());
            accessibilityEventA.setPackageName(this.a.getPackageName());
            AccessibilityManager accessibilityManagerO = o();
            if (accessibilityManagerO != null) {
                accessibilityManagerO.sendAccessibilityEvent(accessibilityEventA);
            }
        }
        return zBooleanValue;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        AbstractC13042fc3.i(motionEvent, "e");
        C19406qI3.a("VideoPlayerGestureListener", "onDown(" + motionEvent + Separators.RPAREN, new Object[0]);
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        AbstractC13042fc3.i(motionEvent2, "e2");
        C19406qI3.a("VideoPlayerGestureListener", "onFling(" + motionEvent + ", " + motionEvent2 + Separators.RPAREN, new Object[0]);
        EnumC7541Sd6 enumC7541Sd6 = this.j;
        if (motionEvent == null || enumC7541Sd6 == null) {
            return false;
        }
        boolean zBooleanValue = ((Boolean) this.b.q(enumC7541Sd6, Float.valueOf(motionEvent2.getX() - motionEvent.getX()), Float.valueOf(motionEvent2.getY() - motionEvent.getY()))).booleanValue();
        if (zBooleanValue) {
            AccessibilityEvent accessibilityEventA = Build.VERSION.SDK_INT >= 30 ? QT7.a() : AccessibilityEvent.obtain();
            accessibilityEventA.setClassName(YT7.class.getName());
            accessibilityEventA.setPackageName(this.a.getPackageName());
            AccessibilityManager accessibilityManagerO = o();
            if (accessibilityManagerO != null) {
                accessibilityManagerO.sendAccessibilityEvent(accessibilityEventA);
            }
        }
        return zBooleanValue;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        AbstractC13042fc3.i(motionEvent, "e");
        C19406qI3.a("VideoPlayerGestureListener", "onLongPress(" + motionEvent + Separators.RPAREN, new Object[0]);
        AccessibilityEvent accessibilityEventA = Build.VERSION.SDK_INT >= 30 ? QT7.a() : AccessibilityEvent.obtain();
        accessibilityEventA.setClassName(YT7.class.getName());
        accessibilityEventA.setPackageName(this.a.getPackageName());
        accessibilityEventA.setEventType(2);
        AccessibilityManager accessibilityManagerO = o();
        if (accessibilityManagerO != null) {
            accessibilityManagerO.sendAccessibilityEvent(accessibilityEventA);
        }
        this.e.invoke(Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()));
        this.i = true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        AbstractC13042fc3.i(motionEvent, "e");
        C19406qI3.a("VideoPlayerGestureListener", "onSingleTapConfirmed(" + motionEvent + Separators.RPAREN, new Object[0]);
        boolean zBooleanValue = ((Boolean) this.d.invoke(Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()))).booleanValue();
        if (zBooleanValue) {
            AccessibilityEvent accessibilityEventA = Build.VERSION.SDK_INT >= 30 ? QT7.a() : AccessibilityEvent.obtain();
            accessibilityEventA.setClassName(YT7.class.getName());
            accessibilityEventA.setPackageName(this.a.getPackageName());
            accessibilityEventA.setEventType(1);
            AccessibilityManager accessibilityManagerO = o();
            if (accessibilityManagerO != null) {
                accessibilityManagerO.sendAccessibilityEvent(accessibilityEventA);
            }
        }
        return zBooleanValue;
    }

    public final boolean p() {
        return this.i;
    }

    public final InterfaceC14603iB2 q() {
        return this.f;
    }

    public final InterfaceC15796kB2 r() {
        return this.b;
    }

    public final InterfaceC14603iB2 s() {
        return this.d;
    }

    public final InterfaceC15796kB2 t() {
        return this.g;
    }

    public final InterfaceC15796kB2 u() {
        return this.h;
    }

    public final EnumC7541Sd6 v() {
        return this.j;
    }

    public final void w(boolean z) {
        this.i = z;
    }

    public final void x(InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "<set-?>");
        this.c = interfaceC14603iB2;
    }

    public final void y(InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "<set-?>");
        this.f = interfaceC14603iB2;
    }

    public final void z(InterfaceC15796kB2 interfaceC15796kB2) {
        AbstractC13042fc3.i(interfaceC15796kB2, "<set-?>");
        this.b = interfaceC15796kB2;
    }

    public YT7(Context context, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC14603iB2 interfaceC14603iB23, InterfaceC14603iB2 interfaceC14603iB24, InterfaceC15796kB2 interfaceC15796kB22, InterfaceC15796kB2 interfaceC15796kB23) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(interfaceC15796kB2, "onFling");
        AbstractC13042fc3.i(interfaceC14603iB2, "onDoubleTap");
        AbstractC13042fc3.i(interfaceC14603iB22, "onItemClick");
        AbstractC13042fc3.i(interfaceC14603iB23, "onLongClick");
        AbstractC13042fc3.i(interfaceC14603iB24, "onFinishTouchingAfterLongClick");
        AbstractC13042fc3.i(interfaceC15796kB22, "onMove");
        AbstractC13042fc3.i(interfaceC15796kB23, "onMoveFinished");
        this.a = context;
        this.b = interfaceC15796kB2;
        this.c = interfaceC14603iB2;
        this.d = interfaceC14603iB22;
        this.e = interfaceC14603iB23;
        this.f = interfaceC14603iB24;
        this.g = interfaceC15796kB22;
        this.h = interfaceC15796kB23;
        this.k = (AccessibilityManager) AbstractC4043Dl1.l(context, AccessibilityManager.class);
    }
}
