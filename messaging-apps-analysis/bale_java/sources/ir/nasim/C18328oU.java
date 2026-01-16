package ir.nasim;

import android.util.Log;
import android.view.View;
import android.view.autofill.AutofillManager$AutofillCallback;

/* renamed from: ir.nasim.oU, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C18328oU extends AutofillManager$AutofillCallback {
    public static final C18328oU a = new C18328oU();

    private C18328oU() {
    }

    public final void a(C13766gn c13766gn) {
        c13766gn.a().registerCallback(AbstractC16555lU.a(this));
    }

    public final void b(C13766gn c13766gn) {
        c13766gn.a().unregisterCallback(AbstractC16555lU.a(this));
    }

    public void onAutofillEvent(View view, int i, int i2) {
        super.onAutofillEvent(view, i, i2);
        Log.d("Autofill Status", i2 != 1 ? i2 != 2 ? i2 != 3 ? "Unknown status event." : "Autofill popup isn't shown because autofill is not available.\n\nDid you set up autofill?\n1. Go to Settings > System > Languages&input > Advanced > Autofill Service\n2. Pick a service\n\nDid you add an account?\n1. Go to Settings > System > Languages&input > Advanced\n2. Click on the settings icon next to the Autofill Service\n3. Add your account" : "Autofill popup was hidden." : "Autofill popup was shown.");
    }
}
