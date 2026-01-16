package ir.eitaa.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.voip.VoIPService;
import ir.eitaa.tgnet.TLRPC$PhoneCall;
import ir.eitaa.ui.Components.voip.VoIPHelper;
import java.io.IOException;
import java.util.ArrayList;

@TargetApi(23)
/* loaded from: classes3.dex */
public class VoIPPermissionActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        TLRPC$PhoneCall tLRPC$PhoneCall;
        super.onCreate(savedInstanceState);
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        boolean z = (sharedInstance == null || (tLRPC$PhoneCall = sharedInstance.privateCall) == null || !tLRPC$PhoneCall.video) ? false : true;
        ArrayList arrayList = new ArrayList();
        if (checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
            arrayList.add("android.permission.RECORD_AUDIO");
        }
        if (z && checkSelfPermission("android.permission.CAMERA") != 0) {
            arrayList.add("android.permission.CAMERA");
        }
        if (arrayList.isEmpty()) {
            return;
        }
        try {
            requestPermissions((String[]) arrayList.toArray(new String[0]), z ? R.styleable.AppCompatTheme_textAppearanceSearchResultTitle : R.styleable.AppCompatTheme_textAppearanceSearchResultSubtitle);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) throws IllegalStateException, InterruptedException, IOException {
        if (requestCode == 101 || requestCode == 102) {
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= grantResults.length) {
                    z = true;
                    break;
                } else if (grantResults[i] != 0) {
                    break;
                } else {
                    i++;
                }
            }
            if (grantResults.length > 0 && z) {
                if (VoIPService.getSharedInstance() != null) {
                    VoIPService.getSharedInstance().acceptIncomingCall();
                }
                finish();
                startActivity(new Intent(this, (Class<?>) LaunchActivity.class).setAction("voip"));
                return;
            }
            if (!shouldShowRequestPermissionRationale("android.permission.RECORD_AUDIO")) {
                if (VoIPService.getSharedInstance() != null) {
                    VoIPService.getSharedInstance().declineIncomingCall();
                }
                VoIPHelper.permissionDenied(this, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$9AH4051lVU8U_uA2CTW7uOnPPT0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.finish();
                    }
                }, requestCode);
                return;
            }
            finish();
        }
    }
}
