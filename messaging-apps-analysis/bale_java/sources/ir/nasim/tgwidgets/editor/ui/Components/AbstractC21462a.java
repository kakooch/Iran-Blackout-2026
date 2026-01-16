package ir.nasim.tgwidgets.editor.ui.Components;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Outline;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.AbstractC19363qD5;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.FH3;
import ir.nasim.TD5;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.ActionBar.AlertDialog;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.AbstractC21462a;

/* renamed from: ir.nasim.tgwidgets.editor.ui.Components.a, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC21462a {

    /* renamed from: ir.nasim.tgwidgets.editor.ui.Components.a$a, reason: collision with other inner class name */
    class C1592a extends ViewOutlineProvider {
        C1592a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight() + AbstractC21455b.F(6.0f), AbstractC21455b.H(6.0f));
        }
    }

    public static Dialog c(final Context context, m.h hVar) {
        return new AlertDialog.i(context, hVar).e(FH3.E("ApkRestricted", TD5.tgwidget_ApkRestricted)).k(AbstractC19363qD5.permission_request_apk, 72, false, ir.nasim.tgwidgets.editor.ui.ActionBar.m.i0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.x4)).i(FH3.E("PermissionOpenSettings", TD5.tgwidget_PermissionOpenSettings), new DialogInterface.OnClickListener() { // from class: ir.nasim.bm
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AbstractC21462a.e(context, dialogInterface, i);
            }
        }).f(FH3.E("ContactsPermissionAlertNotNow", TD5.tgwidget_ContactsPermissionAlertNotNow), null).a();
    }

    public static AlertDialog.i d(final Activity activity, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.i iVar = new AlertDialog.i(activity);
        String strS = RLottieDrawable.S(null, AbstractC19363qD5.pip_video_request);
        FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.setBackground(new GradientDrawable(GradientDrawable.Orientation.BL_TR, new int[]{-14535089, -14527894}));
        frameLayout.setClipToOutline(true);
        frameLayout.setOutlineProvider(new C1592a());
        View view = new View(activity);
        view.setBackground(new BitmapDrawable(ir.nasim.tgwidgets.editor.messenger.G.l(strS, AbstractC21455b.F(320.0f), AbstractC21455b.F(161.36752f), false)));
        frameLayout.addView(view, AbstractC13840gu3.c(-1, -1.0f, 0, -1.0f, -1.0f, -1.0f, -1.0f));
        iVar.m(frameLayout);
        iVar.j(FH3.E("PermissionDrawAboveOtherAppsTitle", TD5.tgwidget_PermissionDrawAboveOtherAppsTitle));
        iVar.e(FH3.E("PermissionDrawAboveOtherApps", TD5.tgwidget_PermissionDrawAboveOtherApps));
        iVar.i(FH3.E("Enable", TD5.tgwidget_Enable), new DialogInterface.OnClickListener() { // from class: ir.nasim.am
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AbstractC21462a.f(activity, dialogInterface, i);
            }
        });
        iVar.b(true);
        iVar.f(FH3.E("Cancel", TD5.tgwidget_Cancel), onClickListener);
        iVar.n(0.50427353f);
        return iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(Context context, DialogInterface dialogInterface, int i) {
        try {
            context.startActivity(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + context.getPackageName())));
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(Activity activity, DialogInterface dialogInterface, int i) {
        if (activity != null) {
            try {
                activity.startActivity(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + activity.getPackageName())));
            } catch (Exception e) {
                AbstractC6403Nl2.d(e);
            }
        }
    }
}
