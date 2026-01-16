package ir.resaneh1.iptv.helper;

import android.content.Context;
import ir.medu.shad.R;
import java.io.File;
import java.io.IOException;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;

/* loaded from: classes.dex */
public class StorageHelper {
    private static File rubinoFile;

    public static String getTempDirectory(Context context) {
        return new File(new File(context.getExternalCacheDir(), LocaleController.getString(R.string.AppName)), "temp").getPath();
    }

    public static File getTempDirectoryFile(Context context) {
        return new File(new File(context.getExternalCacheDir(), LocaleController.getString(R.string.AppName)), "temp");
    }

    public static String getImageTempFilePath(Context context) {
        return new File(getTempDirectoryFile(context), "img.jpg").getPath();
    }

    public static File getImagesDownloadDirectory() {
        return new File(new File(ApplicationLoader.applicationContext.getExternalCacheDir(), LocaleController.getString(R.string.AppName)).getPath(), LocaleController.getString(R.string.AppName) + " Images");
    }

    public static File getVideosDownloadDirectory() {
        return new File(new File(ApplicationLoader.applicationContext.getExternalCacheDir(), LocaleController.getString(R.string.AppName)).getPath(), LocaleController.getString(R.string.AppName) + " Videos");
    }

    public static File getVoicesDownloadDirectory() {
        return new File(new File(ApplicationLoader.applicationContext.getExternalCacheDir(), LocaleController.getString(R.string.AppName)).getPath(), LocaleController.getString(R.string.AppName) + " Audio");
    }

    public static File getDocumentsDownloadDirectory() {
        return new File(new File(ApplicationLoader.applicationContext.getExternalCacheDir(), LocaleController.getString(R.string.AppName)).getPath(), LocaleController.getString(R.string.AppName) + " Documents");
    }

    public static File getThumbDirectory() {
        return new File(new File(ApplicationLoader.applicationContext.getExternalCacheDir(), LocaleController.getString(R.string.AppName)).getPath(), "thumbs");
    }

    public static File getDownloadDirectoryApp() {
        return new File(new File(ApplicationLoader.applicationContext.getExternalCacheDir(), LocaleController.getString(R.string.AppName)).getPath(), "As");
    }

    public static File getDownloadDirectoryImageProfile() {
        return new File(new File(ApplicationLoader.applicationContext.getExternalCacheDir(), LocaleController.getString(R.string.AppName)).getPath(), "profilePicsThumb");
    }

    public static File getDownloadDirectoryWallpaper() {
        return new File(new File(ApplicationLoader.applicationContext.getExternalCacheDir(), LocaleController.getString(R.string.AppName)).getPath(), "wallpapers");
    }

    public static File getDownloadDirectoryRubino() {
        if (rubinoFile == null) {
            rubinoFile = new File(new File(ApplicationLoader.applicationContext.getExternalCacheDir(), LocaleController.getString(R.string.AppName)).getPath(), "ru");
        }
        return rubinoFile;
    }

    public static void makeDownloadDirs() {
        File file = new File(ApplicationLoader.applicationContext.getExternalCacheDir(), LocaleController.getString(R.string.AppName));
        file.mkdirs();
        File file2 = new File(file.getPath(), LocaleController.getString(R.string.AppName) + " Images");
        file2.mkdirs();
        try {
            new File(file2, ".nomedia").createNewFile();
        } catch (IOException unused) {
        }
        File file3 = new File(file.getPath(), LocaleController.getString(R.string.AppName) + " Videos");
        file3.mkdirs();
        try {
            new File(file3, ".nomedia").createNewFile();
        } catch (IOException unused2) {
        }
        File file4 = new File(file.getPath(), LocaleController.getString(R.string.AppName) + " Documents");
        file4.mkdirs();
        try {
            new File(file4, ".nomedia").createNewFile();
        } catch (IOException unused3) {
        }
        File file5 = new File(ApplicationLoader.applicationContext.getExternalCacheDir(), LocaleController.getString(R.string.AppName));
        file5.mkdirs();
        new File(file5.getPath(), "temp").mkdirs();
        new File(file5.getPath(), "thumbs").mkdirs();
        new File(file5.getPath(), "snapshots").mkdirs();
        new File(file5.getPath(), "wallpapers").mkdirs();
        new File(file5.getPath(), "ru").mkdirs();
        new File(file5.getPath(), "downloadtemp").mkdirs();
        new File(file5.getPath(), "downloadtempA").mkdirs();
        new File(file5.getPath(), "downloadtempB").mkdirs();
        new File(file5.getPath(), "As").mkdirs();
        File file6 = new File(file5.getPath(), "Bs");
        file6.mkdirs();
        try {
            new File(file6, ".nomedia").createNewFile();
        } catch (IOException unused4) {
        }
        new File(file5.getPath(), "profilePicsThumb").mkdirs();
    }
}
