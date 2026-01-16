package ir.nasim;

import android.app.Activity;
import android.content.DialogInterface;
import ir.nasim.designsystem.modal.dialog.AlertDialog;

/* renamed from: ir.nasim.nz6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C18045nz6 {
    public static final C18045nz6 a = new C18045nz6();

    /* renamed from: ir.nasim.nz6$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[W25.values().length];
            try {
                iArr[W25.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[W25.a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    private C18045nz6() {
    }

    private final String b(C11458d25 c11458d25) {
        C10410bZ6 c10410bZ6R;
        String str;
        int i = a.a[c11458d25.s().ordinal()];
        if (i == 1) {
            Object objB = AbstractC5969Lp4.d().V(c11458d25.getPeerId()).v().b();
            AbstractC13042fc3.f(objB);
            return (String) objB;
        }
        if (i != 2) {
            throw new IllegalStateException("Unexpected PeerType");
        }
        C21231tK7 c21231tK7I0 = AbstractC5969Lp4.d().i0(c11458d25.getPeerId());
        return (c21231tK7I0 == null || (c10410bZ6R = c21231tK7I0.r()) == null || (str = (String) c10410bZ6R.b()) == null) ? "" : str;
    }

    private final String c(Activity activity, C11458d25 c11458d25, String str) {
        if (c11458d25.getPeerId() == AbstractC5969Lp4.f()) {
            String string = activity.getString(AbstractC12217eE5.confirm_share_saved_message);
            AbstractC13042fc3.h(string, "getString(...)");
            String string2 = activity.getString(AbstractC12217eE5.settings_saved_messages);
            AbstractC13042fc3.h(string2, "getString(...)");
            return AbstractC20153rZ6.M(string, "$$$", string2, false, 4, null);
        }
        if (str == null || str.length() == 0) {
            str = b(c11458d25);
        }
        String str2 = str;
        String string3 = activity.getString(AbstractC12217eE5.confirm_share);
        AbstractC13042fc3.h(string3, "getString(...)");
        return AbstractC20153rZ6.M(string3, "$$$", str2, false, 4, null);
    }

    public static final AlertDialog d(Activity activity, C11458d25 c11458d25, String str, final ZJ4 zj4) {
        AbstractC13042fc3.i(activity, "activity");
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(zj4, "callback");
        return new AlertDialog.a(activity).i(a.c(activity, c11458d25, str)).l(activity.getString(AbstractC12217eE5.dialog_yes), new DialogInterface.OnClickListener() { // from class: ir.nasim.mz6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                C18045nz6.e(zj4, dialogInterface, i);
            }
        }).j(activity.getString(AbstractC12217eE5.dialog_cancel), null).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(ZJ4 zj4, DialogInterface dialogInterface, int i) {
        AbstractC13042fc3.i(zj4, "$callback");
        zj4.a();
    }
}
