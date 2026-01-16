package ir.nasim;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import android.net.Uri;
import ir.nasim.designsystem.modal.dialog.AlertDialog;

/* renamed from: ir.nasim.Ee3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C4216Ee3 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(C22042ua0 c22042ua0, DialogInterface dialogInterface, int i) {
        AbstractC13042fc3.i(c22042ua0, "$fragment");
        try {
            c22042ua0.Q7().startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.android.apps.maps")), SIPTransactionStack.BASE_TIMER_INTERVAL);
        } catch (Exception e) {
            C19406qI3.d("IsGoogleMapsInstalledUseCase", e);
        }
    }

    public final boolean b(final C22042ua0 c22042ua0) throws PackageManager.NameNotFoundException {
        AbstractC13042fc3.i(c22042ua0, "fragment");
        try {
            C5721Ko.a.d().getPackageManager().getApplicationInfo("com.google.android.apps.maps", 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            if (c22042ua0.A5() == null) {
                return false;
            }
            Context contextS7 = c22042ua0.S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            AlertDialog.a aVar = new AlertDialog.a(contextS7);
            C5721Ko c5721Ko = C5721Ko.a;
            aVar.i(c5721Ko.d().getString(AbstractC12217eE5.map_install_google_map));
            aVar.l(c5721Ko.d().getString(AbstractC12217eE5.OK), new DialogInterface.OnClickListener() { // from class: ir.nasim.De3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    C4216Ee3.c(c22042ua0, dialogInterface, i);
                }
            });
            aVar.j(c5721Ko.d().getString(AbstractC12217eE5.Cancel), null);
            c22042ua0.q9(aVar.a());
            return false;
        }
    }
}
