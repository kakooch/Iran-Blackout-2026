package ir.eitaa.helper;

import android.app.Activity;
import android.app.DownloadManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import java.util.Date;

/* loaded from: classes.dex */
public class DownloadHelper {
    public static void downloadVideo(Activity activity, String videoURL) {
        if (Build.VERSION.SDK_INT >= 23 && activity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            activity.requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 4);
            return;
        }
        if (videoURL.endsWith(".mp4")) {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(videoURL));
            request.allowScanningByMediaScanner();
            request.setAllowedNetworkTypes(3);
            request.setNotificationVisibility(1).setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "Eitaa-Live-" + new Date().getTime() + ".mp4").setTitle(LocaleController.getString("LiveArchiveDownloadingTitle", R.string.LiveArchiveDownloadingTitle)).setDescription(LocaleController.getString("LiveArchiveDownloadingDescription", R.string.LiveArchiveDownloadingDescription));
            ((DownloadManager) activity.getSystemService("download")).enqueue(request);
        }
    }
}
