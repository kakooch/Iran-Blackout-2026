package ir.nasim;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.text.BidiFormatter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextDirectionHeuristics;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import ir.nasim.AbstractC16407lD4;
import ir.nasim.D55;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.AvatarImage;
import ir.nasim.features.call.service.CallActionsReceiver;
import ir.nasim.features.call.ui.CallActivity;
import java.util.Locale;

/* renamed from: ir.nasim.Ix0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5335Ix0 {
    public static final C5335Ix0 a = new C5335Ix0();

    private C5335Ix0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 B(UA2 ua2, Context context, C8942Xx0 c8942Xx0, long j, boolean z, C8942Xx0 c8942Xx02, Bitmap bitmap) {
        AbstractC13042fc3.i(ua2, "$onNotificationUpdated");
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(c8942Xx0, "$this_with");
        AbstractC13042fc3.i(c8942Xx02, "$callPeer");
        AbstractC13042fc3.i(bitmap, "it");
        ua2.invoke(a.j(context, c8942Xx0.c(), j, bitmap, z, c8942Xx02.d()));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 D(UA2 ua2, Context context, C8942Xx0 c8942Xx0, long j, boolean z, C8942Xx0 c8942Xx02, Bitmap bitmap) {
        AbstractC13042fc3.i(ua2, "$onNotificationUpdated");
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(c8942Xx0, "$this_with");
        AbstractC13042fc3.i(c8942Xx02, "$callPeer");
        AbstractC13042fc3.i(bitmap, "it");
        ua2.invoke(a.l(context, c8942Xx0.c(), j, bitmap, z, c8942Xx02.d()));
        return C19938rB7.a;
    }

    private final NotificationChannel E(String str, Uri uri, AudioAttributes audioAttributes) {
        EE4.a();
        NotificationChannel notificationChannelA = ZC4.a(str, "IncomingCalls", 4);
        notificationChannelA.setSound(uri, audioAttributes);
        notificationChannelA.enableVibration(false);
        notificationChannelA.enableLights(false);
        notificationChannelA.setBypassDnd(true);
        notificationChannelA.setLockscreenVisibility(1);
        return notificationChannelA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 G(UA2 ua2, Context context, C8942Xx0 c8942Xx0, boolean z, C8942Xx0 c8942Xx02, Bitmap bitmap) {
        AbstractC13042fc3.i(ua2, "$onNotificationUpdated");
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(c8942Xx0, "$this_with");
        AbstractC13042fc3.i(c8942Xx02, "$callPeer");
        AbstractC13042fc3.i(bitmap, "it");
        ua2.invoke(a.n(context, c8942Xx0.c(), bitmap, z, c8942Xx02.d()));
        return C19938rB7.a;
    }

    private final NotificationChannel H(Context context, Uri uri, AudioAttributes audioAttributes) {
        String name;
        int i = C7183Qq.p().getInt("calls_notification_channel", 0);
        int i2 = i + 1;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
        NotificationChannel notificationChannel = notificationManager.getNotificationChannel(y(i));
        NotificationChannel notificationChannelE = E(y(i2), uri, audioAttributes);
        if (notificationChannel == null) {
            notificationManager.createNotificationChannel(notificationChannelE);
        } else {
            if (!J(notificationChannel, notificationChannelE)) {
                return notificationChannel;
            }
            try {
                notificationManager.deleteNotificationChannel(y(i));
            } catch (Exception e) {
                if (C5335Ix0.class.isAnonymousClass()) {
                    name = C5335Ix0.class.getName();
                    int length = name.length();
                    AbstractC13042fc3.f(name);
                    if (length > 23) {
                        name = name.substring(name.length() - 23, name.length());
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                } else {
                    name = C5335Ix0.class.getSimpleName();
                    int length2 = name.length();
                    AbstractC13042fc3.f(name);
                    if (length2 > 23) {
                        name = name.substring(0, 23);
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                }
                C19406qI3.d(name, e);
            }
            C7183Qq.p().putInt("calls_notification_channel", i2);
            notificationManager.createNotificationChannel(notificationChannelE);
        }
        return notificationChannelE;
    }

    private final Bitmap I(Context context, int i, String str) {
        return B02.a(new WU(str, i, 18.0f, context, false, false, 32, null), 100, 100, Bitmap.Config.ARGB_8888);
    }

    private final boolean J(NotificationChannel notificationChannel, NotificationChannel notificationChannel2) {
        return (notificationChannel.getImportance() == notificationChannel2.getImportance() && AbstractC13042fc3.d(notificationChannel.getSound(), notificationChannel2.getSound()) && notificationChannel.shouldVibrate() == notificationChannel2.shouldVibrate()) ? false : true;
    }

    private final void K(final int i, Avatar avatar, final String str, final UA2 ua2) {
        AvatarImage smallImage;
        AbstractC9915am2.a((avatar == null || (smallImage = avatar.getSmallImage()) == null) ? null : smallImage.getFileReference(), new UA2() { // from class: ir.nasim.Gx0
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C5335Ix0.L(i, str, ua2, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 L(final int i, final String str, final UA2 ua2, final String str2) {
        AbstractC13042fc3.i(str, "$name");
        AbstractC13042fc3.i(ua2, "$onAvatarLoaded");
        AbstractC13042fc3.i(str2, "it");
        C9248Zc6 c9248Zc6G = new C9248Zc6(new InterfaceC7298Rc6() { // from class: ir.nasim.zx0
            @Override // ir.nasim.InterfaceC7298Rc6
            public final Object run() {
                return C5335Ix0.N(i, str, str2);
            }
        }).h(EnumC11723dV1.IO).f(true).g(new InterfaceC5620Kc6() { // from class: ir.nasim.Ax0
            @Override // ir.nasim.InterfaceC5620Kc6
            public final void onSuccess(Object obj) {
                C5335Ix0.M(ua2, (Bitmap) obj);
            }
        });
        AbstractC13042fc3.f(c9248Zc6G);
        SZ.e(c9248Zc6G);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(UA2 ua2, Bitmap bitmap) {
        AbstractC13042fc3.i(ua2, "$onAvatarLoaded");
        AbstractC13042fc3.f(bitmap);
        ua2.invoke(C16670lg0.h(bitmap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap N(int i, String str, String str2) {
        AbstractC13042fc3.i(str, "$name");
        AbstractC13042fc3.i(str2, "$it");
        return C16670lg0.d(i, str, str2);
    }

    private final Notification j(final Context context, String str, long j, final Bitmap bitmap, final boolean z, final boolean z2) {
        int i = Build.VERSION.SDK_INT;
        String id = i >= 26 ? H(context, null, null).getId() : z(this, 0, 1, null);
        PendingIntent pendingIntentS = s(context);
        final PendingIntent pendingIntentP = p(context, j, z2 ? "ACTION_JOIN_VOICE_CALL" : z ? "answer_video_call" : "answer_voice_call");
        final SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(C6011Lu2.i(), 0, spannableString.length() - 1, 33);
        final PendingIntent pendingIntentT = t(context, j, z2);
        UA2 ua2 = new UA2() { // from class: ir.nasim.Hx0
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C5335Ix0.k(spannableString, z, context, bitmap, pendingIntentP, pendingIntentT, z2, (RemoteViews) obj);
            }
        };
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), AbstractC12208eD5.call_notification);
        ua2.invoke(remoteViews);
        RemoteViews remoteViews2 = new RemoteViews(context.getPackageName(), AbstractC12208eD5.call_notification_collapsed);
        ua2.invoke(remoteViews2);
        AbstractC16407lD4.e eVarO = new AbstractC16407lD4.e(context, id).n("Bale Voice Call").m(str).K(KB5.ic_stat_white_notif_icon).l(pendingIntentS).L(null).a(KB5.call_notif_accept, r(context), pendingIntentP).a(KB5.call_notif_decline, v(context), pendingIntentT).F(2).I(false).j(AbstractC4043Dl1.c(context, TA5.color6_2)).Q(null).h("call").v(pendingIntentS, true).z(bitmap).k(true).o(remoteViews);
        if (i >= 31) {
            eVarO.p(remoteViews2);
            eVarO.q(remoteViews2);
        } else {
            eVarO.p(remoteViews);
            eVarO.q(remoteViews);
        }
        Notification notificationC = eVarO.c();
        AbstractC13042fc3.h(notificationC, "build(...)");
        return notificationC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k(Spannable spannable, boolean z, Context context, Bitmap bitmap, PendingIntent pendingIntent, PendingIntent pendingIntent2, boolean z2, RemoteViews remoteViews) {
        AbstractC13042fc3.i(spannable, "$notificationTitle");
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(bitmap, "$bitmap");
        AbstractC13042fc3.i(remoteViews, "<this>");
        remoteViews.setTextViewText(BC5.name, spannable);
        if (z) {
            SpannableString spannableString = new SpannableString(context.getString(AbstractC12217eE5.video_call_incoming));
            String string = context.getString(AbstractC12217eE5.video_call_notif_bold_part);
            AbstractC13042fc3.h(string, "getString(...)");
            int iL0 = AbstractC20762sZ6.l0(spannableString, string, 0, false, 6, null);
            spannableString.setSpan(new StyleSpan(1), iL0, string.length() + iL0, 33);
            spannableString.setSpan(C6011Lu2.k(), 0, spannableString.length() - 1, 33);
            remoteViews.setTextViewText(BC5.title, spannableString);
        } else {
            SpannableString spannableString2 = new SpannableString(context.getString(AbstractC12217eE5.voice_call_incoming));
            spannableString2.setSpan(C6011Lu2.k(), 0, spannableString2.length() - 1, 33);
            remoteViews.setTextViewText(BC5.title, spannableString2);
        }
        remoteViews.setImageViewBitmap(BC5.photo, bitmap);
        remoteViews.setOnClickPendingIntent(BC5.answer_btn, pendingIntent);
        remoteViews.setOnClickPendingIntent(BC5.decline_btn, pendingIntent2);
        remoteViews.setTextColor(BC5.name, AbstractC4043Dl1.c(context, TA5.color9));
        remoteViews.setTextColor(BC5.title, AbstractC4043Dl1.c(context, TA5.color8));
        remoteViews.setViewVisibility(BC5.group_ic, z2 ? 0 : 8);
        remoteViews.setInt(BC5.group_ic, "setColorFilter", AbstractC4043Dl1.c(context, TA5.color9));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(Spannable spannable, boolean z, Context context, Bitmap bitmap, PendingIntent pendingIntent, PendingIntent pendingIntent2, boolean z2, RemoteViews remoteViews) {
        AbstractC13042fc3.i(spannable, "$notificationTitle");
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(bitmap, "$bitmap");
        AbstractC13042fc3.i(pendingIntent, "$answerPendingIntent");
        AbstractC13042fc3.i(remoteViews, "<this>");
        remoteViews.setTextViewText(BC5.name, spannable);
        if (z) {
            SpannableString spannableString = new SpannableString(context.getString(AbstractC12217eE5.video_call_incoming));
            String string = context.getString(AbstractC12217eE5.video_call_notif_bold_part);
            AbstractC13042fc3.h(string, "getString(...)");
            int iL0 = AbstractC20762sZ6.l0(spannableString, string, 0, false, 6, null);
            spannableString.setSpan(new StyleSpan(1), iL0, string.length() + iL0, 33);
            spannableString.setSpan(C6011Lu2.k(), 0, spannableString.length() - 1, 33);
            remoteViews.setTextViewText(BC5.title, spannableString);
        } else {
            SpannableString spannableString2 = new SpannableString(context.getString(AbstractC12217eE5.voice_call_incoming));
            spannableString2.setSpan(C6011Lu2.k(), 0, spannableString2.length() - 1, 33);
            remoteViews.setTextViewText(BC5.title, spannableString2);
        }
        remoteViews.setImageViewBitmap(BC5.photo, bitmap);
        remoteViews.setOnClickPendingIntent(BC5.answer_btn, pendingIntent);
        remoteViews.setOnClickPendingIntent(BC5.decline_btn, pendingIntent2);
        remoteViews.setTextColor(BC5.name, AbstractC4043Dl1.c(context, TA5.color9));
        remoteViews.setTextColor(BC5.title, AbstractC4043Dl1.c(context, TA5.color8));
        remoteViews.setViewVisibility(BC5.group_ic, z2 ? 0 : 8);
        remoteViews.setInt(BC5.group_ic, "setColorFilter", AbstractC4043Dl1.c(context, TA5.color9));
        return C19938rB7.a;
    }

    private final Notification n(final Context context, String str, final Bitmap bitmap, final boolean z, final boolean z2) {
        PendingIntent pendingIntentS = s(context);
        final PendingIntent pendingIntentW = w(context, z2);
        int i = Build.VERSION.SDK_INT;
        String strL = i >= 26 ? E00.a.l() : z(this, 0, 1, null);
        final SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(C6011Lu2.i(), 0, !AbstractC20762sZ6.n0(spannableString) ? spannableString.length() - 1 : 0, 33);
        UA2 ua2 = new UA2() { // from class: ir.nasim.Fx0
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C5335Ix0.o(spannableString, z, context, bitmap, pendingIntentW, z2, (RemoteViews) obj);
            }
        };
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), AbstractC12208eD5.call_notification);
        ua2.invoke(remoteViews);
        remoteViews.setTextViewText(BC5.decline_text, context.getString(AbstractC12217eE5.voice_call_notif_hang_up));
        remoteViews.setViewVisibility(BC5.divider, 8);
        RemoteViews remoteViews2 = new RemoteViews(context.getPackageName(), AbstractC12208eD5.call_notification_collapsed);
        ua2.invoke(remoteViews2);
        AbstractC16407lD4.e eVarO = new AbstractC16407lD4.e(context, strL).m(spannableString).l(pendingIntentS).n("Bale Voice Call").K(KB5.ic_stat_white_notif_icon).a(KB5.call_notif_decline, x(context), pendingIntentW).F(2).I(false).z(bitmap).o(remoteViews);
        if (i >= 31) {
            eVarO.p(remoteViews2);
            eVarO.q(remoteViews2);
        } else {
            eVarO.p(remoteViews);
            eVarO.q(remoteViews);
        }
        AbstractC16407lD4.e eVarK = eVarO.j(AbstractC4043Dl1.c(context, TA5.color6_2)).k(true);
        AbstractC13042fc3.h(eVarK, "setColorized(...)");
        Notification notificationC = eVarK.c();
        AbstractC13042fc3.h(notificationC, "build(...)");
        return notificationC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o(Spannable spannable, boolean z, Context context, Bitmap bitmap, PendingIntent pendingIntent, boolean z2, RemoteViews remoteViews) {
        AbstractC13042fc3.i(spannable, "$notificationTitle");
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(remoteViews, "<this>");
        remoteViews.setTextViewText(BC5.name, spannable);
        if (z) {
            SpannableString spannableString = new SpannableString(context.getString(AbstractC12217eE5.video_call_notif_answered_text));
            String string = context.getString(AbstractC12217eE5.video_call_notif_bold_part);
            AbstractC13042fc3.h(string, "getString(...)");
            int iL0 = AbstractC20762sZ6.l0(spannableString, string, 0, false, 6, null);
            spannableString.setSpan(new StyleSpan(1), iL0, string.length() + iL0, 33);
            remoteViews.setTextViewText(BC5.title, spannableString);
        } else {
            remoteViews.setTextViewText(BC5.title, context.getString(AbstractC12217eE5.voice_call_notif_answered_text));
        }
        remoteViews.setViewVisibility(BC5.answer_btn, 8);
        remoteViews.setImageViewBitmap(BC5.photo, bitmap);
        remoteViews.setOnClickPendingIntent(BC5.decline_btn, pendingIntent);
        remoteViews.setTextColor(BC5.name, AbstractC4043Dl1.c(context, TA5.color9));
        remoteViews.setTextColor(BC5.title, AbstractC4043Dl1.c(context, TA5.color8));
        remoteViews.setViewVisibility(BC5.group_ic, z2 ? 0 : 8);
        remoteViews.setInt(BC5.group_ic, "setColorFilter", AbstractC4043Dl1.c(context, TA5.color9));
        return C19938rB7.a;
    }

    private final PendingIntent p(Context context, long j, String str) {
        Intent intent = new Intent(context, (Class<?>) CallActionsReceiver.class);
        intent.setAction(str);
        intent.putExtra("call_id", j);
        return PendingIntent.getBroadcast(context, 0, intent, 335544320);
    }

    private final PendingIntent q(Context context, String str, long j) {
        Intent intent = new Intent(context, (Class<?>) CallActivity.class);
        intent.setAction(str);
        intent.putExtra("call_id", j);
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 201326592);
        AbstractC13042fc3.h(activity, "let(...)");
        return activity;
    }

    private final CharSequence r(Context context) {
        String string = context.getString(AbstractC12217eE5.call_notif_answer);
        AbstractC13042fc3.h(string, "getString(...)");
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(AbstractC4043Dl1.c(context, TA5.primary)), 0, spannableString.length(), 0);
        return spannableString;
    }

    private final PendingIntent s(Context context) {
        Intent intent = new Intent(context, (Class<?>) CallActivity.class);
        intent.setAction("bale_voice_call");
        return PendingIntent.getActivity(context, 0, intent, 201326592);
    }

    private final PendingIntent t(Context context, long j, boolean z) {
        Intent intent = new Intent(context, (Class<?>) CallActionsReceiver.class);
        intent.setAction(z ? "ACTION_DECLINE_GROUP" : "decline_call");
        intent.putExtra("call_id", j);
        return PendingIntent.getBroadcast(context, 0, intent, 335544320);
    }

    private final PendingIntent u(Context context, long j, boolean z) {
        Intent intent = new Intent(context, (Class<?>) CallActionsReceiver.class);
        intent.setAction(z ? "ACTION_DECLINE_GROUP" : "decline_call");
        intent.putExtra("call_id", j);
        return PendingIntent.getBroadcast(context, 0, intent, 201326592);
    }

    private final CharSequence v(Context context) {
        String string = context.getString(AbstractC12217eE5.call_notif_decline);
        AbstractC13042fc3.h(string, "getString(...)");
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(AbstractC4043Dl1.c(context, TA5.error)), 0, spannableString.length(), 0);
        return spannableString;
    }

    private final PendingIntent w(Context context, boolean z) {
        Intent intent = new Intent(context, (Class<?>) CallActionsReceiver.class);
        intent.setAction(z ? "ACTION_END_GROUP_CALL" : "end_call");
        return PendingIntent.getBroadcast(context, 0, intent, 335544320);
    }

    private final CharSequence x(Context context) {
        String string = context.getString(AbstractC12217eE5.call_notif_hangup);
        AbstractC13042fc3.h(string, "getString(...)");
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(AbstractC4043Dl1.c(context, TA5.error)), 0, spannableString.length(), 0);
        return spannableString;
    }

    private final String y(int i) {
        return "bale_incoming_calls" + i;
    }

    static /* synthetic */ String z(C5335Ix0 c5335Ix0, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return c5335Ix0.y(i);
    }

    public final Notification A(final Context context, final C8942Xx0 c8942Xx0, final long j, final boolean z, final UA2 ua2) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c8942Xx0, "callPeer");
        AbstractC13042fc3.i(ua2, "onNotificationUpdated");
        C5335Ix0 c5335Ix0 = a;
        Bitmap bitmapI = c5335Ix0.I(context, c8942Xx0.b(), c8942Xx0.c());
        c5335Ix0.K(c8942Xx0.b(), c8942Xx0.a(), c8942Xx0.c(), new UA2() { // from class: ir.nasim.Ex0
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C5335Ix0.B(ua2, context, c8942Xx0, j, z, c8942Xx0, (Bitmap) obj);
            }
        });
        return c5335Ix0.j(context, c8942Xx0.c(), j, bitmapI, z, c8942Xx0.d());
    }

    public final Notification C(final Context context, final C8942Xx0 c8942Xx0, final long j, final boolean z, final UA2 ua2) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c8942Xx0, "callPeer");
        AbstractC13042fc3.i(ua2, "onNotificationUpdated");
        C5335Ix0 c5335Ix0 = a;
        Bitmap bitmapI = c5335Ix0.I(context, c8942Xx0.b(), c8942Xx0.c());
        c5335Ix0.K(c8942Xx0.b(), c8942Xx0.a(), c8942Xx0.c(), new UA2() { // from class: ir.nasim.Bx0
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C5335Ix0.D(ua2, context, c8942Xx0, j, z, c8942Xx0, (Bitmap) obj);
            }
        });
        return c5335Ix0.l(context, c8942Xx0.c(), j, bitmapI, z, c8942Xx0.d());
    }

    public final Notification F(final Context context, final C8942Xx0 c8942Xx0, final boolean z, final UA2 ua2) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c8942Xx0, "callPeer");
        AbstractC13042fc3.i(ua2, "onNotificationUpdated");
        C5335Ix0 c5335Ix0 = a;
        Bitmap bitmapI = c5335Ix0.I(context, c8942Xx0.b(), c8942Xx0.c());
        c5335Ix0.K(c8942Xx0.b(), c8942Xx0.a(), c8942Xx0.c(), new UA2() { // from class: ir.nasim.Dx0
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C5335Ix0.G(ua2, context, c8942Xx0, z, c8942Xx0, (Bitmap) obj);
            }
        });
        return c5335Ix0.n(context, c8942Xx0.c(), bitmapI, z, c8942Xx0.d());
    }

    public final Notification l(final Context context, String str, long j, final Bitmap bitmap, final boolean z, final boolean z2) {
        String string;
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(bitmap, "bitmap");
        int i = Build.VERSION.SDK_INT;
        String id = i >= 26 ? H(context, null, null).getId() : z(this, 0, 1, null);
        PendingIntent pendingIntentS = s(context);
        final PendingIntent pendingIntentQ = q(context, z2 ? "ACTION_JOIN_VOICE_CALL" : z ? "answer_video_call" : "answer_voice_call", j);
        final PendingIntent pendingIntentU = u(context, j, z2);
        if (str.length() == 0) {
            string = context.getString(AbstractC12217eE5.all_default_user_title);
            AbstractC13042fc3.h(string, "getString(...)");
        } else {
            string = str;
        }
        String strUnicodeWrap = BidiFormatter.getInstance(Locale.forLanguageTag("fa_IR")).unicodeWrap(string, TextDirectionHeuristics.ANYRTL_LTR);
        if (i >= 29) {
            Notification notificationC = new AbstractC16407lD4.e(context, id).n("Bale Voice Call").j(AbstractC4043Dl1.c(C5721Ko.a.d(), TA5.primary)).K(KB5.ic_stat_white_notif_icon).l(pendingIntentS).v(pendingIntentS, true).F(2).I(false).h("call").M(AbstractC16407lD4.f.n(new D55.c().f(strUnicodeWrap).c(IconCompat.i(bitmap)).a(), pendingIntentU, pendingIntentQ)).c();
            notificationC.flags = 34;
            AbstractC13042fc3.f(notificationC);
            return notificationC;
        }
        final SpannableString spannableString = new SpannableString(strUnicodeWrap);
        spannableString.setSpan(C6011Lu2.i(), 0, spannableString.length() - 1, 33);
        UA2 ua2 = new UA2() { // from class: ir.nasim.Cx0
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C5335Ix0.m(spannableString, z, context, bitmap, pendingIntentQ, pendingIntentU, z2, (RemoteViews) obj);
            }
        };
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), AbstractC12208eD5.call_notification);
        ua2.invoke(remoteViews);
        RemoteViews remoteViews2 = new RemoteViews(context.getPackageName(), AbstractC12208eD5.call_notification_collapsed);
        ua2.invoke(remoteViews2);
        AbstractC16407lD4.e eVarO = new AbstractC16407lD4.e(context, id).n("Bale Voice Call").m(strUnicodeWrap).K(KB5.ic_stat_white_notif_icon).l(pendingIntentS).L(null).a(KB5.call_notif_accept, r(context), pendingIntentQ).a(KB5.call_notif_decline, v(context), pendingIntentU).F(2).I(false).j(AbstractC4043Dl1.c(context, TA5.color6_2)).Q(null).h("call").v(pendingIntentS, true).z(bitmap).k(true).o(remoteViews);
        if (i >= 31) {
            eVarO.p(remoteViews2);
            eVarO.q(remoteViews2);
        } else {
            eVarO.p(remoteViews);
            eVarO.q(remoteViews);
        }
        Notification notificationC2 = eVarO.c();
        notificationC2.flags = 34;
        AbstractC13042fc3.f(notificationC2);
        return notificationC2;
    }
}
