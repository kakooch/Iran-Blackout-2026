package ir.appp.rghapp.rubinoPostSlider;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.helper.StorageHelper;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.Rubino;
import java.io.File;
import java.util.List;
import org.rbmain.messenger.Utilities;

/* loaded from: classes3.dex */
public class PhotoViewerObject {
    private String downloadName;
    public int duration;
    public String filePath;
    private File fullFile;
    public PhotoViewerObject imageObject;
    public boolean isFileExist;
    private boolean isIGTV;
    public boolean isPreloadedCalled;
    public boolean isRecentlyDownloaded;
    public boolean isVideo;
    public long lastPlayedPosition;
    public String postId;
    public List<PostTagObject> postTags;
    public int size = 0;
    public String storyId;
    public String thumbnailPath;

    public int getDuration() {
        return this.duration;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public boolean isVideo() {
        return this.isVideo;
    }

    public boolean isIGTV() {
        return this.isIGTV;
    }

    public void setForPicture(String str, String str2) {
        this.filePath = str2;
        this.isVideo = false;
        this.imageObject = this;
        this.postId = str;
        checkIsFileExist();
    }

    public void setForVideo(String str, String str2, String str3, int i, int i2, int i3, Rubino.ShowType showType) {
        this.filePath = str3;
        this.thumbnailPath = str2;
        boolean z = true;
        this.isVideo = true;
        if (showType != Rubino.ShowType.IGTV && !MyLog.isDebugAble) {
            z = false;
        }
        this.isIGTV = z;
        this.postId = str;
        this.duration = i3;
        PhotoViewerObject photoViewerObject = new PhotoViewerObject();
        this.imageObject = photoViewerObject;
        photoViewerObject.setForPicture(str, this.thumbnailPath);
        checkIsFileExist();
    }

    public void setForStoryVideo(String str, String str2, int i, int i2, int i3) {
        this.filePath = str2;
        this.isVideo = true;
        this.storyId = str;
        this.duration = i3;
        this.imageObject = new PhotoViewerObject();
        checkIsFileExist();
    }

    public File getDownloadFile() {
        if (this.fullFile == null) {
            File file = new File(StorageHelper.getDownloadDirectoryRubino(), getFileDownloadedName() + BuildConfig.FLAVOR);
            this.fullFile = file;
            file.getPath();
            try {
                this.fullFile.setLastModified(System.currentTimeMillis());
            } catch (Exception unused) {
            }
        }
        return this.fullFile;
    }

    public boolean checkIsFileExist() {
        if (this.isFileExist) {
            return true;
        }
        boolean zExists = getDownloadFile().exists();
        this.isFileExist = zExists;
        return zExists;
    }

    public String getFileDownloadedName() {
        if (this.downloadName == null) {
            if (this.postId != null) {
                this.downloadName = this.postId + Utilities.MD5(this.filePath);
            }
            if (this.storyId != null) {
                this.downloadName = "ST_" + this.storyId + Utilities.MD5(this.filePath);
            }
        }
        return this.downloadName;
    }
}
