package ir.nasim.authenticator.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.UA2;
import java.util.regex.Pattern;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0010B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000e\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0012R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lir/nasim/authenticator/ui/OtpReceiver;", "Landroid/content/BroadcastReceiver;", "Ljava/util/regex/Pattern;", "matcherPattern", "Lkotlin/Function1;", "", "Lir/nasim/rB7;", "onReceivedOtp", "<init>", "(Ljava/util/regex/Pattern;Lir/nasim/UA2;)V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "a", "(Landroid/content/Context;)Landroid/content/Intent;", "Ljava/util/regex/Pattern;", "b", "Lir/nasim/UA2;", "c", "authenticator_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes4.dex */
public final class OtpReceiver extends BroadcastReceiver {
    public static final int d = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private final Pattern matcherPattern;

    /* renamed from: b, reason: from kotlin metadata */
    private final UA2 onReceivedOtp;

    public OtpReceiver(Pattern pattern, UA2 ua2) {
        AbstractC13042fc3.i(pattern, "matcherPattern");
        AbstractC13042fc3.i(ua2, "onReceivedOtp");
        this.matcherPattern = pattern;
        this.onReceivedOtp = ua2;
    }

    public final Intent a(Context context) {
        AbstractC13042fc3.i(context, "context");
        IntentFilter intentFilter = new IntentFilter("com.google.android.gms.auth.api.phone.SMS_RETRIEVED");
        return Build.VERSION.SDK_INT >= 33 ? context.registerReceiver(this, intentFilter, 2) : context.registerReceiver(this, intentFilter);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0029  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onReceive(android.content.Context r4, android.content.Intent r5) {
        /*
            r3 = this;
            r4 = 0
            if (r5 == 0) goto L8
            java.lang.String r0 = r5.getAction()
            goto L9
        L8:
            r0 = r4
        L9:
            java.lang.String r1 = "com.google.android.gms.auth.api.phone.SMS_RETRIEVED"
            boolean r0 = ir.nasim.AbstractC13042fc3.d(r0, r1)
            if (r0 != 0) goto L12
            return
        L12:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 33
            java.lang.String r2 = "com.google.android.gms.auth.api.phone.EXTRA_STATUS"
            if (r0 < r1) goto L2b
            android.os.Bundle r0 = r5.getExtras()
            if (r0 == 0) goto L29
            java.lang.Class<com.google.android.gms.common.api.Status> r1 = com.google.android.gms.common.api.Status.class
            java.lang.Object r0 = ir.nasim.KM4.a(r0, r2, r1)
            com.google.android.gms.common.api.Status r0 = (com.google.android.gms.common.api.Status) r0
            goto L3d
        L29:
            r0 = r4
            goto L3d
        L2b:
            android.os.Bundle r0 = r5.getExtras()
            if (r0 == 0) goto L38
            android.os.Parcelable r0 = r0.getParcelable(r2)
            com.google.android.gms.common.api.Status r0 = (com.google.android.gms.common.api.Status) r0
            goto L39
        L38:
            r0 = r4
        L39:
            boolean r1 = r0 instanceof com.google.android.gms.common.api.Status
            if (r1 == 0) goto L29
        L3d:
            if (r0 != 0) goto L40
            return
        L40:
            int r0 = r0.S()
            if (r0 == 0) goto L53
            r4 = 15
            if (r0 == r4) goto L4b
            goto L7a
        L4b:
            java.lang.String r4 = "OtpReceiver"
            java.lang.String r5 = "Failed to receive otp because of timeout!!"
            ir.nasim.C19406qI3.b(r4, r5)
            goto L7a
        L53:
            android.os.Bundle r5 = r5.getExtras()
            if (r5 == 0) goto L5f
            java.lang.String r4 = "com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE"
            java.lang.String r4 = r5.getString(r4)
        L5f:
            if (r4 != 0) goto L62
            return
        L62:
            java.util.regex.Pattern r5 = r3.matcherPattern
            java.util.regex.Matcher r4 = r5.matcher(r4)
            boolean r5 = r4.find()
            if (r5 == 0) goto L7a
            java.lang.String r4 = r4.group()
            ir.nasim.UA2 r5 = r3.onReceivedOtp
            ir.nasim.AbstractC13042fc3.f(r4)
            r5.invoke(r4)
        L7a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.authenticator.ui.OtpReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }
}
