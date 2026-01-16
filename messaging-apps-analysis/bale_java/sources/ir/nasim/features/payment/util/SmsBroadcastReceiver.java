package ir.nasim.features.payment.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.gov.nist.core.Separators;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.C19406qI3;
import ir.nasim.ED1;
import ir.nasim.ZY6;
import ir.nasim.database.dailogLists.DialogEntity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\fB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lir/nasim/features/payment/util/SmsBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "Lir/nasim/rB7;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Lir/nasim/features/payment/util/SmsBroadcastReceiver$b;", "a", "Lir/nasim/features/payment/util/SmsBroadcastReceiver$b;", "()Lir/nasim/features/payment/util/SmsBroadcastReceiver$b;", "b", "(Lir/nasim/features/payment/util/SmsBroadcastReceiver$b;)V", "smsBroadcastReceiverListener", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class SmsBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: b, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int c = 8;

    /* renamed from: a, reason: from kotlin metadata */
    public b smsBroadcastReceiverListener;

    /* renamed from: ir.nasim.features.payment.util.SmsBroadcastReceiver$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final String a(String str) {
            AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
            try {
                String strSubstring = str.substring(AbstractC20762sZ6.h0(str, "رمز", 0, true));
                AbstractC13042fc3.h(strSubstring, "substring(...)");
                return ZY6.a((String) AbstractC20762sZ6.N0(strSubstring, new String[]{Separators.RETURN}, false, 0, 6, null).get(0));
            } catch (Exception e) {
                C19406qI3.d("NON_FATAL_EXCEPTION", e);
                return null;
            }
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public interface b {
        void a(Intent intent);
    }

    public final b a() {
        b bVar = this.smsBroadcastReceiverListener;
        if (bVar != null) {
            return bVar;
        }
        AbstractC13042fc3.y("smsBroadcastReceiverListener");
        return null;
    }

    public final void b(b bVar) {
        AbstractC13042fc3.i(bVar, "<set-?>");
        this.smsBroadcastReceiverListener = bVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (AbstractC13042fc3.d(intent != null ? intent.getAction() : null, "com.google.android.gms.auth.api.phone.SMS_RETRIEVED")) {
            Bundle extras = intent.getExtras();
            Object obj = extras != null ? extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS") : null;
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type com.google.android.gms.common.api.Status");
            if (((Status) obj).S() != 0) {
                return;
            }
            a().a((Intent) extras.getParcelable("com.google.android.gms.auth.api.phone.EXTRA_CONSENT_INTENT"));
        }
    }
}
