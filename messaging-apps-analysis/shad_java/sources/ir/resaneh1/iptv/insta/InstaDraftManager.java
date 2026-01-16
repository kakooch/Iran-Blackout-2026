package ir.resaneh1.iptv.insta;

import ir.resaneh1.iptv.model.SendingMediaInfo;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.BaseController;
import org.rbmain.messenger.NotificationCenter;

/* loaded from: classes3.dex */
public class InstaDraftManager extends BaseController {
    private static volatile InstaDraftManager[] Instance = new InstaDraftManager[3];
    public ConcurrentHashMap<Integer, SendingPostInsta> sendingMediaInfoMap;
    public ConcurrentHashMap<Integer, SendingProfilePhoto> sendingProfilePhotoMap;

    public static InstaDraftManager getInstance(int i) {
        InstaDraftManager instaDraftManager = Instance[i];
        if (instaDraftManager == null) {
            synchronized (InstaDraftManager.class) {
                instaDraftManager = Instance[i];
                if (instaDraftManager == null) {
                    InstaDraftManager[] instaDraftManagerArr = Instance;
                    InstaDraftManager instaDraftManager2 = new InstaDraftManager(i);
                    instaDraftManagerArr[i] = instaDraftManager2;
                    instaDraftManager = instaDraftManager2;
                }
            }
        }
        return instaDraftManager;
    }

    public InstaDraftManager(int i) {
        super(i);
        this.sendingMediaInfoMap = new ConcurrentHashMap<>(0);
        this.sendingProfilePhotoMap = new ConcurrentHashMap<>(0);
    }

    public void removeSendingPost(int i) {
        this.sendingMediaInfoMap.remove(Integer.valueOf(i));
    }

    public void addSendingFile(int i, ArrayList<SendingMediaInfo> arrayList, String str, String str2) {
        SendingPostInsta sendingPostInsta = new SendingPostInsta(this.currentAccount);
        sendingPostInsta.index = 0;
        sendingPostInsta.sendingMediaInfoArrayList = arrayList;
        sendingPostInsta.rnd = i;
        sendingPostInsta.caption = str;
        sendingPostInsta.sendingStatus = SendingPostInsta.SendingStatus.initNextUpload;
        sendingPostInsta.profile_id = str2;
        this.sendingMediaInfoMap.put(Integer.valueOf(i), sendingPostInsta);
    }

    public static class SendingPostInsta extends PresenterItem {
        public String accessHashRec;
        public String accessHashRecSnapShot;
        public String accessHashThumbnail;
        public String caption;
        private final int currentAccount;
        public String fileId;
        public String fileIdSnapShot;
        public String fileIdThumbnail;
        public String postId;
        public String profile_id;
        public int rnd;
        public ArrayList<SendingMediaInfo> sendingMediaInfoArrayList;
        public int index = 0;
        public SendingStatus sendingStatus = SendingStatus.converting;
        public float convertProgress = 0.0f;
        public boolean hasError = false;

        public enum SendingStatus {
            converting,
            uploadingFile,
            uploadingSnapShot,
            uploadingThumbnail,
            sendingPost,
            addFileToPost,
            publishPost,
            initNextUpload,
            done
        }

        SendingPostInsta(int i) {
            this.currentAccount = i;
        }

        public boolean isMulti() {
            ArrayList<SendingMediaInfo> arrayList = this.sendingMediaInfoArrayList;
            return arrayList != null && arrayList.size() > 1;
        }

        public SendingMediaInfo getCurrentSendingMedia() {
            int i;
            if (this.index >= this.sendingMediaInfoArrayList.size() || (i = this.index) < 0) {
                return null;
            }
            return this.sendingMediaInfoArrayList.get(i);
        }

        public void increaseIndexIfPosible() {
            if (this.index < this.sendingMediaInfoArrayList.size() - 1) {
                this.index++;
            } else {
                this.index = -1;
            }
        }

        public int getProgress() {
            if (getCurrentSendingMedia() == null) {
                return 100;
            }
            int size = this.sendingMediaInfoArrayList.size();
            int i = this.index;
            int uploadProgress = FileLoaderInsta.getInstance(this.currentAccount).getUploadProgress(this.rnd) / size;
            int i2 = (i * 100) / size;
            if (this.sendingStatus == SendingStatus.initNextUpload) {
                return i2;
            }
            if (getCurrentSendingMedia().isVideo) {
                SendingStatus sendingStatus = this.sendingStatus;
                if (sendingStatus == SendingStatus.converting) {
                    float f = this.convertProgress;
                    if (f >= 100.0f) {
                        f = 100.0f;
                    }
                    double d = i2;
                    double d2 = f / size;
                    Double.isNaN(d2);
                    Double.isNaN(d);
                    return (int) (d + (d2 * 0.3d));
                }
                if (sendingStatus != SendingStatus.uploadingFile) {
                    return sendingStatus == SendingStatus.uploadingSnapShot ? (int) (i2 + (90.0f / size) + (uploadProgress * 0.05f)) : i2 + (100 / size);
                }
                double d3 = i2;
                double d4 = size;
                Double.isNaN(d4);
                Double.isNaN(d3);
                double d5 = uploadProgress * 0.6f;
                Double.isNaN(d5);
                return (int) (d3 + (30.0d / d4) + d5);
            }
            SendingStatus sendingStatus2 = this.sendingStatus;
            return sendingStatus2 == SendingStatus.uploadingFile ? i2 + ((int) (uploadProgress * 0.9f)) : sendingStatus2 == SendingStatus.uploadingThumbnail ? (int) (i2 + (90.0f / size) + (uploadProgress * 0.1f)) : i2 + (100 / size);
        }

        @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
        public PresenterItemType getPresenterType() {
            return PresenterItemType.SendingPostInsta;
        }
    }

    public static class SendingProfilePhoto {
        public String accessHashRec;
        public String accessHashRecThumb;
        final int currentAccount;
        public String fileId;
        public String fileIdThumb;
        public boolean hasError;
        public boolean isInvalidUserName;
        public boolean isUploadForMessengerAfterDone;
        public String profile_id;
        public SendingMediaInfo sendingMediaInfo;
        public SendingStatus sendingStatus;

        public enum SendingStatus {
            uploadingFile,
            uploadingThumbnail,
            update,
            done
        }

        public void setStatusDone() {
            this.sendingStatus = SendingStatus.done;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.insta.InstaDraftManager.SendingProfilePhoto.1
                @Override // java.lang.Runnable
                public void run() {
                    NotificationCenter.getInstance(SendingProfilePhoto.this.currentAccount).postNotificationName(NotificationCenter.myInstaUploadProfileDone, new Object[0]);
                }
            });
        }

        public void setError() {
            this.hasError = true;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.insta.InstaDraftManager.SendingProfilePhoto.3
                @Override // java.lang.Runnable
                public void run() {
                    NotificationCenter.getInstance(SendingProfilePhoto.this.currentAccount).postNotificationName(NotificationCenter.myInstaUploadProfileRefreshView, new Object[0]);
                }
            });
        }
    }
}
