package org.rbmain.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import org.rbmain.messenger.MessagesController;
import org.rbmain.ui.Components.voip.VoIPHelper;

/* loaded from: classes4.dex */
public class VoIPFeedbackActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        getWindow().addFlags(MessagesController.UPDATE_MASK_CHAT_SHOW_SPAM);
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        setContentView(new View(this));
        VoIPHelper.showRateAlert(this, new Runnable() { // from class: org.rbmain.ui.VoIPFeedbackActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.finish();
            }
        }, getIntent().getBooleanExtra("call_video", false), getIntent().getStringExtra("call_id"), getIntent().getLongExtra("call_access_hash", 0L), getIntent().getIntExtra("account", 0), false);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }
}
