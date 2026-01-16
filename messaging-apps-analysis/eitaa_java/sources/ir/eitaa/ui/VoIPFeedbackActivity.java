package ir.eitaa.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import ir.eitaa.ui.Components.voip.VoIPHelper;

/* loaded from: classes3.dex */
public class VoIPFeedbackActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().addFlags(524288);
        super.onCreate(savedInstanceState);
        overridePendingTransition(0, 0);
        setContentView(new View(this));
        VoIPHelper.showRateAlert(this, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$QyuaNd6oZO19cZUgnrSgZu6UTLI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.finish();
            }
        }, getIntent().getBooleanExtra("call_video", false), getIntent().getLongExtra("call_id", 0L), getIntent().getLongExtra("call_access_hash", 0L), getIntent().getIntExtra("account", 0), false);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }
}
