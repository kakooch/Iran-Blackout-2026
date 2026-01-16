package ir.resaneh1.iptv.model;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.ThumbnailUtils;
import android.util.Base64;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.helper.DataGenerator;
import ir.resaneh1.iptv.helper.StorageHelper;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Locale;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.Bitmaps;
import org.rbmain.messenger.FileLog;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$GeoPoint;
import org.rbmain.tgnet.TLRPC$MessageMedia;

/* loaded from: classes3.dex */
public class FileInlineObject extends PresenterItem {
    public String access_hash_rec;
    public CharSequence address;
    public boolean auto_play;
    public transient String customid;
    public transient TLRPC$Document document;
    public long file_id;
    public String file_name;
    public TLRPC$GeoPoint geo;
    public int height;
    public transient boolean isRecentlyDownloaded;
    public transient String local_attach_path;
    public transient String local_attach_path_orginal;
    public TLRPC$MessageMedia.MediaType mediaType;
    public String music_performer;
    public long size;
    public String thumb_inline;
    public CharSequence title;
    public int width;
    public String mime = "none";
    public int time = 5;
    public FileInlineType type = FileInlineType.File;
    public String dc_id = "0";
    public transient boolean forceDownload = false;
    public transient long forMessageId = 0;

    public enum FileInlineType {
        File,
        Image,
        Voice,
        Video,
        Music,
        Gif
    }

    public String getSizeString() {
        long j = this.size;
        if (j < 1000) {
            return this.size + " B";
        }
        if (j >= 1000 && j < 1000000) {
            return (this.size / 1000) + " KB";
        }
        return String.format(Locale.getDefault(), "%.1f", Float.valueOf(this.size / 1000000.0f)) + " MB";
    }

    public String getUniqueName() {
        if (this.customid == null) {
            this.customid = getFileDownloadedName();
        }
        return this.customid;
    }

    public String getFileDownloadedName() {
        if ((this instanceof AvatarFileInline) || (this instanceof WallpaperFileInline)) {
            return this.file_id + ".jpg";
        }
        return this.file_id + "." + this.mime;
    }

    public File getDownloadedFile() {
        File file;
        if (this.local_attach_path != null) {
            File file2 = new File(this.local_attach_path);
            if (file2.exists()) {
                return file2;
            }
        }
        if (this.local_attach_path_orginal != null) {
            File file3 = new File(this.local_attach_path_orginal);
            if (file3.exists()) {
                return file3;
            }
        }
        if (this instanceof AvatarFileInline) {
            return new File(StorageHelper.getDownloadDirectoryImageProfile(), getFileDownloadedName() + BuildConfig.FLAVOR);
        }
        if (this instanceof WallpaperFileInline) {
            return new File(StorageHelper.getDownloadDirectoryWallpaper(), getFileDownloadedName() + BuildConfig.FLAVOR);
        }
        FileInlineType fileInlineType = this.type;
        if (fileInlineType == FileInlineType.Image) {
            file = new File(StorageHelper.getImagesDownloadDirectory(), getFileDownloadedName() + BuildConfig.FLAVOR);
        } else if (fileInlineType == FileInlineType.Video) {
            file = new File(StorageHelper.getVideosDownloadDirectory(), getFileDownloadedName() + BuildConfig.FLAVOR);
        } else if (fileInlineType == FileInlineType.Voice) {
            file = new File(StorageHelper.getVoicesDownloadDirectory(), getFileDownloadedName() + BuildConfig.FLAVOR);
        } else {
            file = new File(StorageHelper.getDocumentsDownloadDirectory(), getFileDownloadedName() + BuildConfig.FLAVOR);
        }
        file.setLastModified(System.currentTimeMillis());
        return file;
    }

    public File getThumbnailFile() {
        return new File(StorageHelper.getThumbDirectory(), this.file_id + ".jpg");
    }

    public File getSnapShotFile() {
        if (this.file_id == 0 && this.local_attach_path_orginal != null) {
            return new File(StorageHelper.getThumbDirectory(), this.local_attach_path_orginal.hashCode() + "_s_.jpg");
        }
        return new File(StorageHelper.getThumbDirectory(), this.file_id + "_s_.jpg");
    }

    public void saveThumbnail() throws IOException {
        String str = this.thumb_inline;
        if (str == null || str.isEmpty()) {
            return;
        }
        File thumbnailFile = getThumbnailFile();
        if (thumbnailFile.exists()) {
            return;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(thumbnailFile, "rws");
            randomAccessFile.write(Base64.decode(this.thumb_inline, 0));
            randomAccessFile.close();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public FileInlineObject getThumbnailFileInline() {
        FileInlineObject fileInlineObject = new FileInlineObject();
        fileInlineObject.type = FileInlineType.Image;
        fileInlineObject.local_attach_path = getThumbnailFile().getPath();
        fileInlineObject.customid = "thumb_" + this.file_id;
        return fileInlineObject;
    }

    public String getMime() {
        return this.mime;
    }

    public void saveVideoThumbnail(Bitmap bitmap) throws IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(getSnapShotFile());
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FileInlineObject)) {
            return false;
        }
        FileInlineObject fileInlineObject = (FileInlineObject) obj;
        return DataGenerator.isTwoStringEquals(this.access_hash_rec, fileInlineObject.access_hash_rec) && this.file_id == fileInlineObject.file_id && DataGenerator.isTwoStringEquals(this.dc_id, fileInlineObject.dc_id);
    }

    public static FileInlineObject generate() {
        FileInlineObject fileInlineObject = new FileInlineObject();
        fileInlineObject.file_id = DataGenerator.randomLong();
        fileInlineObject.mime = DataGenerator.randomName();
        fileInlineObject.dc_id = DataGenerator.randomName();
        fileInlineObject.access_hash_rec = DataGenerator.randomName();
        fileInlineObject.file_name = DataGenerator.randomName();
        fileInlineObject.width = DataGenerator.randomInt(10, 5000);
        fileInlineObject.height = DataGenerator.randomInt(10, 5000);
        fileInlineObject.time = DataGenerator.randomInt(0, 100);
        fileInlineObject.size = DataGenerator.randomLong();
        if (DataGenerator.randomBoolean(0.7f)) {
            if (DataGenerator.randomBoolean(0.7f)) {
                fileInlineObject.type = FileInlineType.Image;
            } else {
                fileInlineObject.type = FileInlineType.Video;
            }
        } else if (DataGenerator.randomBoolean()) {
            fileInlineObject.type = FileInlineType.Voice;
        } else {
            fileInlineObject.type = FileInlineType.File;
        }
        fileInlineObject.auto_play = DataGenerator.randomBoolean();
        return fileInlineObject;
    }

    public static FileInlineObject generatePhoto() {
        FileInlineObject fileInlineObject = new FileInlineObject();
        fileInlineObject.width = DataGenerator.randomInt(10, 5000);
        fileInlineObject.height = DataGenerator.randomInt(10, 5000);
        fileInlineObject.time = DataGenerator.randomInt(0, 100);
        fileInlineObject.size = DataGenerator.randomLong();
        fileInlineObject.type = FileInlineType.Image;
        fileInlineObject.access_hash_rec = "433009399491726572245100283077";
        fileInlineObject.dc_id = "26";
        fileInlineObject.file_name = "images (3).jpg";
        fileInlineObject.mime = "jpg";
        fileInlineObject.file_id = 240237929L;
        fileInlineObject.auto_play = DataGenerator.randomBoolean();
        return fileInlineObject;
    }

    public static FileInlineObject generateFile() {
        FileInlineObject fileInlineObject = new FileInlineObject();
        fileInlineObject.width = DataGenerator.randomInt(10, 5000);
        fileInlineObject.height = DataGenerator.randomInt(10, 5000);
        fileInlineObject.time = DataGenerator.randomInt(0, 100);
        fileInlineObject.size = DataGenerator.randomLong();
        fileInlineObject.type = FileInlineType.File;
        fileInlineObject.access_hash_rec = "433009399491726572245100283077";
        fileInlineObject.dc_id = "26";
        fileInlineObject.file_name = "sss.apk";
        fileInlineObject.mime = "apk";
        fileInlineObject.file_id = 240237929L;
        fileInlineObject.auto_play = DataGenerator.randomBoolean();
        return fileInlineObject;
    }

    public static FileInlineObject generateMusic() {
        FileInlineObject fileInlineObject = new FileInlineObject();
        fileInlineObject.width = DataGenerator.randomInt(10, 5000);
        fileInlineObject.height = DataGenerator.randomInt(10, 5000);
        fileInlineObject.time = DataGenerator.randomInt(0, 100);
        fileInlineObject.size = DataGenerator.randomLong();
        fileInlineObject.type = FileInlineType.Music;
        fileInlineObject.access_hash_rec = "433009399491726572245100283077";
        fileInlineObject.dc_id = "26";
        fileInlineObject.file_name = "Earth.mp3";
        fileInlineObject.mime = "mp3";
        fileInlineObject.file_id = 240237929L;
        fileInlineObject.auto_play = DataGenerator.randomBoolean();
        return fileInlineObject;
    }

    public static FileInlineObject generateVoice() {
        FileInlineObject fileInlineObject = new FileInlineObject();
        fileInlineObject.width = DataGenerator.randomInt(10, 5000);
        fileInlineObject.height = DataGenerator.randomInt(10, 5000);
        fileInlineObject.time = DataGenerator.randomInt(0, 100);
        fileInlineObject.size = DataGenerator.randomLong();
        fileInlineObject.type = FileInlineType.Voice;
        fileInlineObject.access_hash_rec = "433009399491726572245100283077";
        fileInlineObject.dc_id = "26";
        fileInlineObject.file_name = "Earth.mp3";
        fileInlineObject.mime = "mp3";
        fileInlineObject.file_id = 240237929L;
        fileInlineObject.auto_play = DataGenerator.randomBoolean();
        return fileInlineObject;
    }

    public void saveVideoThumbnail() {
        try {
            File snapShotFile = getSnapShotFile();
            if (snapShotFile.exists()) {
                snapShotFile.delete();
            }
            Point point = AndroidUtilities.displaySize;
            int iMin = Math.min(360, Math.min(point.x, point.y) / 4);
            Bitmap bitmapCreateVideoThumbnail = ThumbnailUtils.createVideoThumbnail(getDownloadedFile().getPath(), 2);
            if (bitmapCreateVideoThumbnail == null) {
                return;
            }
            int width = bitmapCreateVideoThumbnail.getWidth();
            int height = bitmapCreateVideoThumbnail.getHeight();
            if (width != 0 && height != 0) {
                float f = width;
                float f2 = iMin;
                float f3 = height;
                float fMin = Math.min(f / f2, f3 / f2);
                Bitmap bitmapCreateScaledBitmap = Bitmaps.createScaledBitmap(bitmapCreateVideoThumbnail, (int) (f / fMin), (int) (f3 / fMin), true);
                if (bitmapCreateScaledBitmap != bitmapCreateVideoThumbnail) {
                    bitmapCreateVideoThumbnail.recycle();
                    bitmapCreateVideoThumbnail = bitmapCreateScaledBitmap;
                }
                FileOutputStream fileOutputStream = new FileOutputStream(snapShotFile);
                bitmapCreateVideoThumbnail.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
                try {
                    fileOutputStream.close();
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
        } catch (Throwable th) {
            FileLog.e(th);
        }
    }
}
