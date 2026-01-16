package org.rbmain.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.Utilities;
import org.rbmain.tgnet.SerializedData;
import org.rbmain.tgnet.TLRPC$Message;
import org.rbmain.ui.Components.ShareAlert;

/* loaded from: classes4.dex */
public class ShareActivity extends Activity {
    private Dialog visibleDialog;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        ApplicationLoader.postInitApplication();
        AndroidUtilities.checkDisplaySize(this, getResources().getConfiguration());
        requestWindowFeature(1);
        setTheme(2131952303);
        super.onCreate(bundle);
        setContentView(new View(this), new ViewGroup.LayoutParams(-1, -1));
        Intent intent = getIntent();
        if (intent == null || !"android.intent.action.VIEW".equals(intent.getAction()) || intent.getData() == null) {
            finish();
            return;
        }
        Uri data = intent.getData();
        String scheme = data.getScheme();
        String string = data.toString();
        String queryParameter = data.getQueryParameter("hash");
        if (!"tgb".equals(scheme) || !string.toLowerCase().startsWith("tgb://share_game_score") || TextUtils.isEmpty(queryParameter)) {
            finish();
            return;
        }
        SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("botshare", 0);
        String string2 = sharedPreferences.getString(queryParameter + "_m", null);
        if (TextUtils.isEmpty(string2)) {
            finish();
            return;
        }
        SerializedData serializedData = new SerializedData(Utilities.hexToBytes(string2));
        TLRPC$Message tLRPC$MessageTLdeserialize = TLRPC$Message.TLdeserialize(serializedData, serializedData.readInt32(false), false);
        tLRPC$MessageTLdeserialize.readAttachPath(serializedData, 0);
        serializedData.cleanup();
        String string3 = sharedPreferences.getString(queryParameter + "_link", null);
        MessageObject messageObject = new MessageObject(UserConfig.selectedAccount, tLRPC$MessageTLdeserialize, false, true);
        messageObject.messageOwner.with_my_score = true;
        try {
            ShareAlert shareAlertCreateShareAlert = ShareAlert.createShareAlert(this, messageObject, null, false, string3, false);
            this.visibleDialog = shareAlertCreateShareAlert;
            shareAlertCreateShareAlert.setCanceledOnTouchOutside(true);
            this.visibleDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: org.rbmain.ui.ShareActivity$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    this.f$0.lambda$onCreate$0(dialogInterface);
                }
            });
            this.visibleDialog.show();
        } catch (Exception e) {
            FileLog.e(e);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(DialogInterface dialogInterface) {
        if (!isFinishing()) {
            finish();
        }
        this.visibleDialog = null;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        try {
            Dialog dialog = this.visibleDialog;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            this.visibleDialog.dismiss();
            this.visibleDialog = null;
        } catch (Exception e) {
            FileLog.e(e);
        }
    }
}
