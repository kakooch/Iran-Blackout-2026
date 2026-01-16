package ir.nasim;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import ir.nasim.C16275l0;
import ir.nasim.designsystem.modal.bottomSheet.BottomSheetWebView;
import ir.nasim.features.bank.AmountAbolContentView;
import ir.nasim.features.bank.MelliLoanBottomSheetContentView;
import ir.nasim.features.bank.NewGiftPacketRecyclerResultBottomSheetContentView;
import ir.nasim.features.bank.PaymentListAbolContentView;
import ir.nasim.features.bank.SendGiftPacketBottomSheetContentView;
import ir.nasim.features.bank.wallet.WalletChargeBottomsheetContentView;
import ir.nasim.features.bank.wallet.WalletPayBottomsheetContentView;

/* renamed from: ir.nasim.i0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14486i0 {
    private static boolean h;
    private InterfaceC16866m0 a;
    private b b;
    private c c;
    private FragmentManager d;
    private C16275l0 e;
    public static final a f = new a(null);
    public static final int g = 8;
    private static final String i = "ABOL";

    /* renamed from: ir.nasim.i0$a */
    public static final class a {
        private a() {
        }

        public final C14486i0 a(FragmentActivity fragmentActivity) {
            AbstractC13042fc3.i(fragmentActivity, "activity");
            return new C14486i0(fragmentActivity, (ED1) null);
        }

        public final C14486i0 b(FragmentManager fragmentManager) {
            AbstractC13042fc3.i(fragmentManager, "fragmentManager");
            return new C14486i0(fragmentManager, (ED1) null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.i0$b */
    public interface b {
        void onDismiss();
    }

    /* renamed from: ir.nasim.i0$c */
    public interface c {
        void a(int i);
    }

    /* renamed from: ir.nasim.i0$d */
    public static final class d implements C16275l0.b {
        d() {
        }

        @Override // ir.nasim.C16275l0.b
        public boolean a() {
            return C14486i0.this.k();
        }

        @Override // ir.nasim.C16275l0.b
        public void onDismiss() {
            C14486i0.h = false;
            b bVar = C14486i0.this.b;
            if (bVar != null) {
                bVar.onDismiss();
            }
        }
    }

    /* renamed from: ir.nasim.i0$e */
    public static final class e extends BottomSheetBehavior.f {
        e() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void b(View view, float f) {
            AbstractC13042fc3.i(view, "bottomSheet");
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void c(View view, int i) {
            AbstractC13042fc3.i(view, "bottomSheet");
            try {
                c cVar = C14486i0.this.c;
                if (cVar != null) {
                    cVar.a(i);
                }
                switch (i) {
                    case -1:
                        C19406qI3.a(C14486i0.i, "PEEK_HEIGHT_AUTO", new Object[0]);
                        break;
                    case 1:
                        C19406qI3.a(C14486i0.i, "STATE_DRAGGING ", new Object[0]);
                        break;
                    case 2:
                        C19406qI3.a(C14486i0.i, "STATE_SETTLING", new Object[0]);
                        break;
                    case 3:
                        C19406qI3.a(C14486i0.i, "STATE_EXPANDED", new Object[0]);
                        break;
                    case 4:
                        C19406qI3.a(C14486i0.i, "STATE_COLLAPSED ", new Object[0]);
                        C16275l0 c16275l0 = C14486i0.this.e;
                        if (c16275l0 != null) {
                            c16275l0.u8();
                            break;
                        }
                        break;
                    case 5:
                        C19406qI3.a(C14486i0.i, "STATE_HIDDEN", new Object[0]);
                        C16275l0 c16275l02 = C14486i0.this.e;
                        if (c16275l02 != null) {
                            c16275l02.u8();
                            break;
                        }
                        break;
                    case 6:
                        C19406qI3.a(C14486i0.i, "STATE_HALF_EXPANDED", new Object[0]);
                        break;
                }
            } catch (Exception e) {
                C19406qI3.d("NON_FATAL_EXCEPTION", e);
            }
        }
    }

    public /* synthetic */ C14486i0(FragmentActivity fragmentActivity, ED1 ed1) {
        this(fragmentActivity);
    }

    public static final C14486i0 f(FragmentActivity fragmentActivity) {
        return f.a(fragmentActivity);
    }

    public static /* synthetic */ boolean i(C14486i0 c14486i0, View view, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return c14486i0.h(view, z);
    }

    private final void n() {
        if (this.e == null) {
            this.e = new C16275l0();
        }
        C16275l0 c16275l0 = this.e;
        if (c16275l0 != null) {
            c16275l0.Z8(new d());
        }
        C16275l0 c16275l02 = this.e;
        if (c16275l02 != null) {
            c16275l02.X8(new e());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean p(View view, boolean z, boolean z2) {
        C16275l0 c16275l0;
        if (h && !z) {
            return false;
        }
        h = true;
        if (this.e == null) {
            n();
        }
        if (this.d.P0()) {
            return false;
        }
        this.a = (InterfaceC16866m0) view;
        C16275l0 c16275l02 = this.e;
        if (c16275l02 != null) {
            c16275l02.a9((view instanceof AmountAbolContentView) || (view instanceof PaymentListAbolContentView) || (view instanceof NewGiftPacketRecyclerResultBottomSheetContentView) || (view instanceof SendGiftPacketBottomSheetContentView) || (view instanceof MelliLoanBottomSheetContentView) || (view instanceof WalletChargeBottomsheetContentView) || (view instanceof WalletPayBottomsheetContentView) || (view instanceof BottomSheetWebView));
        }
        C16275l0 c16275l03 = this.e;
        if (c16275l03 != null) {
            c16275l03.Y8(view);
        }
        C16275l0 c16275l04 = this.e;
        if (c16275l04 != null) {
            ir.nasim.features.payment.view.fragment.y.INSTANCE.b(c16275l04, this.d, c16275l04 != null ? c16275l04.j6() : null);
        }
        if (z2 && (c16275l0 = this.e) != null) {
            c16275l0.b9();
        }
        if (view != 0) {
            ((InterfaceC16866m0) view).b();
        }
        return true;
    }

    public final boolean g() {
        C16275l0 c16275l0;
        if (!j() || (c16275l0 = this.e) == null) {
            return false;
        }
        if (c16275l0 != null) {
            try {
                c16275l0.u8();
            } catch (IllegalStateException unused) {
                return false;
            }
        }
        this.e = null;
        return true;
    }

    public final boolean h(View view, boolean z) {
        C16275l0 c16275l0;
        if (!j() || (c16275l0 = this.e) == null) {
            return false;
        }
        this.a = null;
        if (c16275l0 != null) {
            c16275l0.u8();
        }
        return p(view, true, z);
    }

    public final boolean j() {
        C16275l0 c16275l0 = this.e;
        return c16275l0 != null && c16275l0.U8();
    }

    public final boolean k() {
        InterfaceC16866m0 interfaceC16866m0 = this.a;
        return (interfaceC16866m0 == null || interfaceC16866m0 == null || !interfaceC16866m0.a()) ? false : true;
    }

    public final void l(b bVar) {
        this.b = bVar;
    }

    public final void m(c cVar) {
        this.c = cVar;
    }

    public final boolean o(View view) {
        return p(view, false, false);
    }

    public /* synthetic */ C14486i0(FragmentManager fragmentManager, ED1 ed1) {
        this(fragmentManager);
    }

    private C14486i0(FragmentActivity fragmentActivity) {
        this.d = fragmentActivity.B0();
        n();
    }

    private C14486i0(FragmentManager fragmentManager) {
        this.d = fragmentManager;
        n();
    }
}
