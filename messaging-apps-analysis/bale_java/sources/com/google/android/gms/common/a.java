package com.google.android.gms.common;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.zabx;
import ir.nasim.AbstractC13022fa3;
import ir.nasim.AbstractC16407lD4;
import ir.nasim.AbstractC20013rK1;
import ir.nasim.AbstractC21166tD5;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.AbstractC3993Df5;
import ir.nasim.AbstractC9851af8;
import ir.nasim.Cf8;
import ir.nasim.GB5;
import ir.nasim.InterfaceC16269kz3;
import ir.nasim.Of8;
import ir.nasim.Rf8;
import ir.nasim.V17;
import ir.nasim.Y92;
import ir.nasim.Ye8;
import ir.nasim.ZC4;

/* loaded from: classes3.dex */
public class a extends b {
    private String c;
    private static final Object e = new Object();
    private static final a f = new a();
    public static final int d = b.a;

    public static a m() {
        return f;
    }

    @Override // com.google.android.gms.common.b
    public Intent b(Context context, int i, String str) {
        return super.b(context, i, str);
    }

    @Override // com.google.android.gms.common.b
    public PendingIntent c(Context context, int i, int i2) {
        return super.c(context, i, i2);
    }

    @Override // com.google.android.gms.common.b
    public final String e(int i) {
        return super.e(i);
    }

    @Override // com.google.android.gms.common.b
    public int g(Context context) {
        return super.g(context);
    }

    @Override // com.google.android.gms.common.b
    public int h(Context context, int i) {
        return super.h(context, i);
    }

    @Override // com.google.android.gms.common.b
    public final boolean j(int i) {
        return super.j(i);
    }

    public Dialog k(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return p(activity, i, Cf8.b(activity, b(activity, i, "d"), i2), onCancelListener);
    }

    public PendingIntent l(Context context, ConnectionResult connectionResult) {
        return connectionResult.s0() ? connectionResult.d0() : c(context, connectionResult.P(), 0);
    }

    public boolean n(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogK = k(activity, i, i2, onCancelListener);
        if (dialogK == null) {
            return false;
        }
        s(activity, dialogK, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public void o(Context context, int i) {
        t(context, i, null, d(context, i, 0, "n"));
    }

    final Dialog p(Context context, int i, Cf8 cf8, DialogInterface.OnCancelListener onCancelListener) {
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(AbstractC9851af8.d(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String strC = AbstractC9851af8.c(context, i);
        if (strC != null) {
            builder.setPositiveButton(strC, cf8);
        }
        String strG = AbstractC9851af8.g(context, i);
        if (strG != null) {
            builder.setTitle(strG);
        }
        Log.w("GoogleApiAvailability", String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", Integer.valueOf(i)), new IllegalArgumentException());
        return builder.create();
    }

    public final Dialog q(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, null, R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(AbstractC9851af8.d(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog alertDialogCreate = builder.create();
        s(activity, alertDialogCreate, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return alertDialogCreate;
    }

    public final zabx r(Context context, Ye8 ye8) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        zabx zabxVar = new zabx(ye8);
        Of8.q(context, zabxVar, intentFilter);
        zabxVar.a(context);
        if (i(context, "com.google.android.gms")) {
            return zabxVar;
        }
        ye8.a();
        zabxVar.b();
        return null;
    }

    final void s(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof FragmentActivity) {
                V17.M8(dialog, onCancelListener).K8(((FragmentActivity) activity).B0(), str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        Y92.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    final void t(Context context, int i, String str, PendingIntent pendingIntent) {
        int i2;
        String str2;
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", Integer.valueOf(i), null), new IllegalArgumentException());
        if (i == 18) {
            u(context);
            return;
        }
        if (pendingIntent == null) {
            if (i == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String strF = AbstractC9851af8.f(context, i);
        String strE = AbstractC9851af8.e(context, i);
        Resources resources = context.getResources();
        NotificationManager notificationManager = (NotificationManager) AbstractC3795Cj5.j(context.getSystemService("notification"));
        AbstractC16407lD4.e eVarM = new AbstractC16407lD4.e(context).B(true).f(true).n(strF).M(new AbstractC16407lD4.c().n(strE));
        if (AbstractC20013rK1.c(context)) {
            AbstractC3795Cj5.m(AbstractC3993Df5.e());
            eVarM.K(context.getApplicationInfo().icon).F(2);
            if (AbstractC20013rK1.d(context)) {
                eVarM.a(GB5.common_full_open_on_phone, resources.getString(AbstractC21166tD5.common_open_on_phone), pendingIntent);
            } else {
                eVarM.l(pendingIntent);
            }
        } else {
            eVarM.K(R.drawable.stat_sys_warning).O(resources.getString(AbstractC21166tD5.common_google_play_services_notification_ticker)).S(System.currentTimeMillis()).l(pendingIntent).m(strE);
        }
        if (AbstractC3993Df5.h()) {
            AbstractC3795Cj5.m(AbstractC3993Df5.h());
            synchronized (e) {
                str2 = this.c;
            }
            if (str2 == null) {
                str2 = "com.google.android.gms.availability";
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                String strB = AbstractC9851af8.b(context);
                if (notificationChannel == null) {
                    notificationManager.createNotificationChannel(ZC4.a("com.google.android.gms.availability", strB, 4));
                } else if (!strB.contentEquals(notificationChannel.getName())) {
                    notificationChannel.setName(strB);
                    notificationManager.createNotificationChannel(notificationChannel);
                }
            }
            eVarM.i(str2);
        }
        Notification notificationC = eVarM.c();
        if (i == 1 || i == 2 || i == 3) {
            d.b.set(false);
            i2 = 10436;
        } else {
            i2 = 39789;
        }
        notificationManager.notify(i2, notificationC);
    }

    final void u(Context context) {
        new f(this, context).sendEmptyMessageDelayed(1, 120000L);
    }

    public final boolean v(Activity activity, InterfaceC16269kz3 interfaceC16269kz3, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogP = p(activity, i, Cf8.c(interfaceC16269kz3, b(activity, i, "d"), 2), onCancelListener);
        if (dialogP == null) {
            return false;
        }
        s(activity, dialogP, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public final boolean w(Context context, ConnectionResult connectionResult, int i) {
        PendingIntent pendingIntentL;
        if (AbstractC13022fa3.a(context) || (pendingIntentL = l(context, connectionResult)) == null) {
            return false;
        }
        t(context, connectionResult.P(), null, PendingIntent.getActivity(context, 0, GoogleApiActivity.a(context, pendingIntentL, i, true), Rf8.a | 134217728));
        return true;
    }
}
