package ir.nasim;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.webkit.MimeTypeMap;
import androidx.core.content.FileProvider;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.designsystem.photoviewer.PhotoViewerActivity;
import ir.nasim.designsystem.photoviewer.data.Photo;
import ir.nasim.features.conversation.sharedmedia.old.SharedMediaActivity;
import ir.nasim.features.media.GalleryActivity;
import ir.nasim.features.media.GalleryConfig;
import ir.nasim.features.payment.view.activity.WebViewPaymentActivity;
import ir.nasim.features.root.RootActivity;
import ir.nasim.features.settings.EditNameActivity;
import java.io.File;

/* renamed from: ir.nasim.ub3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22055ub3 {
    public static final C22055ub3 a = new C22055ub3();

    private C22055ub3() {
    }

    private final Photo a(J44 j44, InterfaceC3346Am2 interfaceC3346Am2) {
        C21231tK7 c21231tK7 = (C21231tK7) AbstractC5969Lp4.g().n(j44.U());
        if (interfaceC3346Am2 != null) {
            return b(j44, interfaceC3346Am2.getDescriptor(), null, null, false);
        }
        C24967zW1 c24967zW1H = j44.H();
        byte[] bArrC = (c24967zW1H != null ? c24967zW1H.v() : null) != null ? c24967zW1H.v().c() : null;
        int iO = c21231tK7 != null ? c21231tK7.o() : 0;
        String str = c21231tK7 != null ? (String) c21231tK7.r().b() : "";
        AbstractC13042fc3.f(str);
        return new Photo(iO, null, str, null, null, bArrC, d(j44), e(j44), j44.h(), j44.toByteArray(), null, null, false, 7168, null);
    }

    private final Photo b(J44 j44, String str, Integer num, Integer num2, boolean z) {
        C21231tK7 c21231tK7 = (C21231tK7) AbstractC5969Lp4.g().n(j44.U());
        Uri uriFromFile = Uri.fromFile(new File(str));
        int iO = c21231tK7 != null ? c21231tK7.o() : 0;
        String str2 = c21231tK7 != null ? (String) c21231tK7.r().b() : "";
        AbstractC13042fc3.f(str2);
        return new Photo(iO, null, str2, uriFromFile.toString(), null, null, d(j44), e(j44), j44.h(), j44.toByteArray(), num, num2, z);
    }

    public static final Intent c(int i, Context context) {
        AbstractC13042fc3.i(context, "context");
        Intent intentPutExtra = new Intent(context, (Class<?>) EditNameActivity.class).putExtra("edit_type", 1).putExtra("edit_id", i);
        AbstractC13042fc3.h(intentPutExtra, "putExtra(...)");
        return intentPutExtra;
    }

    private final String d(J44 j44) {
        try {
            if (!j44.g0()) {
                C24967zW1 c24967zW1H = j44.H();
                return (c24967zW1H == null || c24967zW1H.t() == null) ? "" : c24967zW1H.t().v();
            }
            AbstractC17457n0 abstractC17457n0F = j44.F();
            AbstractC13042fc3.g(abstractC17457n0F, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.SponsoredContent");
            return ((C12872fJ6) abstractC17457n0F).s();
        } catch (Exception e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
            return "";
        }
    }

    private final String e(J44 j44) {
        long jH = j44.h();
        Context contextD = C5721Ko.a.d();
        String string = contextD.getString(AbstractC12217eE5.formatDateAtTime, C14593iA1.h(contextD, jH, false, 4, null), C14593iA1.A(jH));
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    public static final Intent f(Context context, String str, String str2, CharSequence charSequence) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(str, "fileName");
        AbstractC13042fc3.i(str2, "fileFullPath");
        return a.h(context, MimeTypeMap.getSingleton().getMimeTypeFromExtension(VZ2.c(str)), str2, charSequence);
    }

    public static /* synthetic */ Intent g(Context context, String str, String str2, CharSequence charSequence, int i, Object obj) {
        if ((i & 8) != 0) {
            charSequence = null;
        }
        return f(context, str, str2, charSequence);
    }

    public static final Intent i(Context context, String str, String str2) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(str, "fileName");
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(VZ2.c(str));
        if (mimeTypeFromExtension == null) {
            mimeTypeFromExtension = "*/*";
        }
        if (Build.VERSION.SDK_INT >= 26 && AbstractC13042fc3.d(mimeTypeFromExtension, "application/vnd.android.package-archive") && !context.getApplicationContext().getPackageManager().canRequestPackageInstalls()) {
            Intent intentAddFlags = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + context.getPackageName())).addFlags(268435456);
            AbstractC13042fc3.h(intentAddFlags, "addFlags(...)");
            return intentAddFlags;
        }
        Uri uriH = FileProvider.h(context, context.getApplicationContext().getPackageName() + ".provider", new File(str2));
        AbstractC13042fc3.f(uriH);
        Intent intentAddFlags2 = new Intent("android.intent.action.VIEW").setDataAndType(uriH, mimeTypeFromExtension).addFlags(1).addFlags(268435456);
        AbstractC13042fc3.h(intentAddFlags2, "addFlags(...)");
        return intentAddFlags2;
    }

    public static final Intent j(Context context, boolean z, boolean z2, boolean z3, boolean z4) {
        AbstractC13042fc3.i(context, "context");
        GalleryConfig galleryConfigA = new GalleryConfig.b().d(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT).h(z).e(z2).c("Gallery picker").b(new String[0]).f(z3).g(z4).a();
        Intent intent = new Intent(context, (Class<?>) GalleryActivity.class);
        intent.putExtra("gallery_config", galleryConfigA);
        return intent;
    }

    public static final Intent k(C11458d25 c11458d25, Context context) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(context, "context");
        return SharedMediaActivity.INSTANCE.a(context, c11458d25);
    }

    public static final void m(Context context, J44 j44, long j, ExPeerType exPeerType, InterfaceC3346Am2 interfaceC3346Am2, boolean z) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        if (j44 == null) {
            C19406qI3.d("NON_FATAL_EXCEPTION", new Exception("message null in openPhotoViewer"));
        } else {
            PhotoViewerActivity.INSTANCE.a(context, a.a(j44, interfaceC3346Am2), j, exPeerType, z);
        }
    }

    public static final void p(Context context, String str) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(str, "TAG");
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://bale.ai/dl")));
        } catch (Exception e) {
            C19406qI3.d(str, e);
        }
    }

    public final Intent h(Context context, String str, String str2, CharSequence charSequence) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(str2, "fileFullPath");
        if (str == null || str.length() == 0) {
            str = "*/*";
        }
        try {
            return new Intent("android.intent.action.SEND").putExtra("android.intent.extra.STREAM", FileProvider.h(context, context.getApplicationContext().getPackageName() + ".provider", new File(str2))).putExtra("android.intent.extra.TEXT", charSequence).setType(str).addFlags(268435456).addFlags(1);
        } catch (Exception e) {
            C19406qI3.d("Intents", e);
            return null;
        }
    }

    public final Intent l(Context context, C11458d25 c11458d25) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c11458d25, "peer");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.EMPTY, context, RootActivity.class);
        intent.addFlags(67108864);
        intent.putExtra("chat_peer", c11458d25.u());
        intent.putExtra("app_shortcut_intent", true);
        return intent;
    }

    public final void n(Context context, J44 j44, long j, ExPeerType exPeerType, String str, boolean z, Integer num, Integer num2, boolean z2) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(str, "descriptor");
        PhotoViewerActivity.INSTANCE.a(context, b(j44, str, num, num2, z2), j, exPeerType, z);
    }

    public final void o(String str, Context context) {
        AbstractC13042fc3.i(str, "url");
        AbstractC13042fc3.i(context, "context");
        Intent intent = new Intent(context, (Class<?>) WebViewPaymentActivity.class);
        intent.putExtra("url_param", str);
        context.startActivity(intent);
    }
}
