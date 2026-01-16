package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import ir.nasim.ZD;

/* loaded from: classes3.dex */
public class b extends ZD {
    private boolean m1;

    /* renamed from: com.google.android.material.bottomsheet.b$b, reason: collision with other inner class name */
    private class C0178b extends BottomSheetBehavior.f {
        private C0178b() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void b(View view, float f) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.f
        public void c(View view, int i) {
            if (i == 5) {
                b.this.N8();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N8() {
        if (this.m1) {
            super.v8();
        } else {
            super.u8();
        }
    }

    private void O8(BottomSheetBehavior bottomSheetBehavior, boolean z) {
        this.m1 = z;
        if (bottomSheetBehavior.k0() == 5) {
            N8();
            return;
        }
        if (y8() instanceof com.google.android.material.bottomsheet.a) {
            ((com.google.android.material.bottomsheet.a) y8()).q();
        }
        bottomSheetBehavior.W(new C0178b());
        bottomSheetBehavior.J0(5);
    }

    private boolean P8(boolean z) {
        Dialog dialogY8 = y8();
        if (!(dialogY8 instanceof com.google.android.material.bottomsheet.a)) {
            return false;
        }
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialogY8;
        BottomSheetBehavior bottomSheetBehaviorO = aVar.o();
        if (!bottomSheetBehaviorO.o0() || !aVar.p()) {
            return false;
        }
        O8(bottomSheetBehaviorO, z);
        return true;
    }

    @Override // ir.nasim.ZD, androidx.fragment.app.l
    public Dialog B8(Bundle bundle) {
        return new com.google.android.material.bottomsheet.a(G5(), A8());
    }

    @Override // androidx.fragment.app.l
    public void u8() {
        if (P8(false)) {
            return;
        }
        super.u8();
    }

    @Override // androidx.fragment.app.l
    public void v8() {
        if (P8(true)) {
            return;
        }
        super.v8();
    }
}
