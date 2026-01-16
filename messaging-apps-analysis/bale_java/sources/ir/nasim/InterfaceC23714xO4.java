package ir.nasim;

import android.view.View;
import ir.nasim.AbstractC21430te5;
import ir.nasim.AbstractC9998au2;
import ir.nasim.InterfaceC8154Ut2;

/* renamed from: ir.nasim.xO4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC23714xO4 extends InterfaceC8058Ui5 {
    public static final a q0 = a.a;

    /* renamed from: ir.nasim.xO4$a */
    public static final class a {
        static final /* synthetic */ a a = new a();
        private static boolean b;

        private a() {
        }

        public final boolean a() {
            return b;
        }
    }

    /* renamed from: ir.nasim.xO4$b */
    public interface b {
        void n();
    }

    static /* synthetic */ void A(InterfaceC23714xO4 interfaceC23714xO4, C3419Au3 c3419Au3, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onRequestMeasure");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        if ((i & 8) != 0) {
            z3 = true;
        }
        interfaceC23714xO4.j(c3419Au3, z, z2, z3);
    }

    static /* synthetic */ void B(InterfaceC23714xO4 interfaceC23714xO4, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: measureAndLayout");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        interfaceC23714xO4.a(z);
    }

    static /* synthetic */ void C(InterfaceC23714xO4 interfaceC23714xO4, C3419Au3 c3419Au3, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onRequestRelayout");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        interfaceC23714xO4.G(c3419Au3, z, z2);
    }

    static /* synthetic */ void f(InterfaceC23714xO4 interfaceC23714xO4, C3419Au3 c3419Au3, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: forceMeasureTheSubtree");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        interfaceC23714xO4.w(c3419Au3, z);
    }

    static /* synthetic */ InterfaceC23124wO4 x(InterfaceC23714xO4 interfaceC23714xO4, InterfaceC14603iB2 interfaceC14603iB2, SA2 sa2, C21226tK2 c21226tK2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createLayer");
        }
        if ((i & 4) != 0) {
            c21226tK2 = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        return interfaceC23714xO4.o(interfaceC14603iB2, sa2, c21226tK2, z);
    }

    void D(C3419Au3 c3419Au3, int i);

    void E();

    void F();

    void G(C3419Au3 c3419Au3, boolean z, boolean z2);

    void H(C3419Au3 c3419Au3);

    void I(C3419Au3 c3419Au3, int i);

    void J(C3419Au3 c3419Au3, long j);

    void a(boolean z);

    void b(C3419Au3 c3419Au3);

    long d(long j);

    void e(View view);

    A2 getAccessibilityManager();

    TT getAutofill();

    AbstractC21987uU getAutofillManager();

    C22577vU getAutofillTree();

    IV0 getClipboard();

    JV0 getClipboardManager();

    InterfaceC11938do1 getCoroutineContext();

    WH1 getDensity();

    InterfaceC24400yZ1 getDragAndDropManager();

    InterfaceC4566Fr2 getFocusOwner();

    AbstractC9998au2.b getFontFamilyResolver();

    InterfaceC8154Ut2.a getFontLoader();

    InterfaceC20014rK2 getGraphicsContext();

    InterfaceC15967kU2 getHapticFeedBack();

    InterfaceC22987w93 getInputModeManager();

    EnumC12613eu3 getLayoutDirection();

    C21449tg4 getModifierLocalManager();

    AbstractC21430te5.a getPlacementScope();

    InterfaceC5655Kg5 getPointerIconService();

    HK5 getRectManager();

    C3419Au3 getRoot();

    C8572Wn6 getSemanticsOwner();

    C3892Cu3 getSharedDrawScope();

    boolean getShowLayoutBounds();

    C24898zO4 getSnapshotObserver();

    InterfaceC20600sH6 getSoftwareKeyboardController();

    C7155Qm7 getTextInputService();

    InterfaceC11323co7 getTextToolbar();

    InterfaceC18354oW7 getViewConfiguration();

    InterfaceC19920r98 getWindowInfo();

    void h(SA2 sa2);

    void i(C3419Au3 c3419Au3);

    void j(C3419Au3 c3419Au3, boolean z, boolean z2, boolean z3);

    void l(C3419Au3 c3419Au3);

    void n(C3419Au3 c3419Au3);

    InterfaceC23124wO4 o(InterfaceC14603iB2 interfaceC14603iB2, SA2 sa2, C21226tK2 c21226tK2, boolean z);

    void q(C3419Au3 c3419Au3);

    long r(long j);

    void setShowLayoutBounds(boolean z);

    void t(C3419Au3 c3419Au3);

    Object v(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1);

    void w(C3419Au3 c3419Au3, boolean z);
}
