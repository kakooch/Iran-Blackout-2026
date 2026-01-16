package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.helper.StorageHelper;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import java.io.File;

/* loaded from: classes3.dex */
public class AppAbsObject extends PresenterItem {
    public String app_id;
    public String en_name;
    public String fa_name;
    public String icon_url;
    public String package_name;
    public float stars;
    public String version;
    public int version_code;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.app;
    }

    public String getName() {
        String str = this.fa_name;
        if (str != null && !str.isEmpty()) {
            return this.fa_name;
        }
        String str2 = this.en_name;
        return str2 != null ? str2 : "app";
    }

    public String getFullName() {
        String str = this.en_name;
        String str2 = BuildConfig.FLAVOR;
        if (str != null) {
            str2 = BuildConfig.FLAVOR + this.en_name;
        }
        String str3 = this.fa_name;
        if (str3 == null || str3.isEmpty()) {
            return str2;
        }
        String str4 = this.en_name;
        if (str4 != null && !str4.isEmpty()) {
            return str2 + " (" + this.fa_name + ")";
        }
        return str2 + this.fa_name;
    }

    public String getFileName() {
        return this.app_id + "_" + this.version_code + ".apk";
    }

    public boolean isDownloaded() {
        return getDownloadedFile().exists();
    }

    public File getDownloadedFile() {
        return new File(StorageHelper.getDownloadDirectoryApp(), getFileName());
    }
}
