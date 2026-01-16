package ir.nasim;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import ir.nasim.designsystem.modal.bottomSheet.abol.LockedBottomSheetBehavior;

/* renamed from: ir.nasim.l0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C16275l0 extends com.google.android.material.bottomsheet.b {
    private b n1;
    private BottomSheetBehavior.f p1;
    private CoordinatorLayout.Behavior q1;
    private View r1;
    private boolean o1 = false;
    private boolean s1 = false;

    /* renamed from: ir.nasim.l0$a */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            C16275l0.this.r1.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            ((BottomSheetBehavior) C16275l0.this.q1).F0(0);
        }
    }

    /* renamed from: ir.nasim.l0$b */
    interface b {
        boolean a();

        void onDismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean V8(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (this.n1 != null && i == 4 && keyEvent.getAction() == 1) {
            return this.n1.a();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W8(DialogInterface dialogInterface) {
        ((BottomSheetBehavior) this.q1).J0(3);
    }

    @Override // androidx.fragment.app.Fragment
    public void H6(int i, int i2, Intent intent) {
        super.H6(i, i2, intent);
    }

    @Override // ir.nasim.ZD, androidx.fragment.app.l
    public void J8(Dialog dialog, int i) {
        View view = this.r1;
        if (view == null) {
            return;
        }
        try {
            dialog.setContentView(view);
        } catch (Exception e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
        }
        Window window = dialog.getWindow();
        if (window != null) {
            if (this.s1) {
                window.setSoftInputMode(19);
            }
            window.setStatusBarColor(C5495Jo7.a.B2());
        }
        CoordinatorLayout.e eVar = (CoordinatorLayout.e) ((View) this.r1.getParent()).getLayoutParams();
        eVar.o(new LockedBottomSheetBehavior());
        this.q1 = eVar.f();
        ((View) this.r1.getParent()).setBackgroundColor(b6().getColor(android.R.color.transparent));
        CoordinatorLayout.Behavior behavior = this.q1;
        if (behavior == null || !(behavior instanceof BottomSheetBehavior)) {
            return;
        }
        BottomSheetBehavior.f fVar = this.p1;
        if (fVar != null) {
            ((BottomSheetBehavior) behavior).w0(fVar);
        }
        this.r1.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: ir.nasim.j0
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                return this.a.V8(dialogInterface, i2, keyEvent);
            }
        });
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: ir.nasim.k0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.a.W8(dialogInterface);
            }
        });
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void M6(Bundle bundle) {
        super.M6(bundle);
        i8(true);
        if (A5() != null && this.o1) {
            Q7().getWindow().addFlags(8192);
        }
        if (this.s1) {
            I8(0, AbstractC23035wE5.BottomSheetDialogFragmentTheme);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        super.R6();
        if (A5() != null) {
            A5().getWindow().clearFlags(8192);
        }
        Dialog dialogY8 = y8();
        if (dialogY8 != null) {
            onDismiss(dialogY8);
        }
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void U6() {
        super.U6();
        Dialog dialogY8 = y8();
        if (dialogY8 != null) {
            onDismiss(dialogY8);
        }
    }

    public boolean U8() {
        return y8() != null && y8().isShowing();
    }

    public void X8(BottomSheetBehavior.f fVar) {
        this.p1 = fVar;
    }

    public void Y8(View view) {
        this.r1 = view;
    }

    public void Z8(b bVar) {
        this.n1 = bVar;
    }

    public void a9(boolean z) {
        this.s1 = z;
    }

    public void b9() {
        this.o1 = true;
    }

    @Override // androidx.fragment.app.l, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        View view = this.r1;
        if (view != null) {
            View view2 = (View) view.getParent();
            if (view2 instanceof ViewGroup) {
                ((ViewGroup) view2).removeAllViews();
            }
        }
        Dialog dialogY8 = y8();
        if (dialogY8 != null) {
            dialogY8.dismiss();
        }
        b bVar = this.n1;
        if (bVar != null) {
            bVar.onDismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void g7(int i, String[] strArr, int[] iArr) {
    }
}
