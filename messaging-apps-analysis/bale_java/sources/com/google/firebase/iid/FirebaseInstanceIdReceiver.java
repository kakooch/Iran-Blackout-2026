package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.cloudmessaging.CloudMessagingReceiver;
import com.google.firebase.messaging.C2367d;
import com.google.firebase.messaging.n;
import ir.nasim.AbstractC9078Yj7;
import java.util.concurrent.ExecutionException;

/* loaded from: classes3.dex */
public final class FirebaseInstanceIdReceiver extends CloudMessagingReceiver {
    private static Intent g(Context context, String str, Bundle bundle) {
        return new Intent(str).putExtras(bundle);
    }

    @Override // com.google.android.gms.cloudmessaging.CloudMessagingReceiver
    protected int b(Context context, CloudMessage cloudMessage) {
        try {
            return ((Integer) AbstractC9078Yj7.a(new C2367d(context).i(cloudMessage.P()))).intValue();
        } catch (InterruptedException | ExecutionException e) {
            Log.e("FirebaseMessaging", "Failed to send message to service.", e);
            return SIPTransactionStack.BASE_TIMER_INTERVAL;
        }
    }

    @Override // com.google.android.gms.cloudmessaging.CloudMessagingReceiver
    protected void c(Context context, Bundle bundle) {
        Intent intentG = g(context, "com.google.firebase.messaging.NOTIFICATION_DISMISS", bundle);
        if (n.A(intentG)) {
            n.s(intentG);
        }
    }
}
