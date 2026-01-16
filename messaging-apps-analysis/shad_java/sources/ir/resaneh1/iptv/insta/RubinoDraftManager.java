package ir.resaneh1.iptv.insta;

import ir.appp.rghapp.RGHMediaHelper$PhotoEntry;
import ir.appp.rghapp.rubinoPostSlider.RGHAddPostActivity;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.BaseController;
import org.rbmain.messenger.MediaController;

/* loaded from: classes3.dex */
public class RubinoDraftManager extends BaseController {
    private static final RubinoDraftManager[] Instance = new RubinoDraftManager[3];
    public ConcurrentHashMap<Integer, RubinoSendingPost> sendingPostInfoMap;

    public RubinoDraftManager(int i) {
        super(i);
        this.sendingPostInfoMap = new ConcurrentHashMap<>(0);
    }

    public static RubinoDraftManager getInstance(int i) {
        RubinoDraftManager[] rubinoDraftManagerArr = Instance;
        RubinoDraftManager rubinoDraftManager = rubinoDraftManagerArr[i];
        if (rubinoDraftManager == null) {
            synchronized (RubinoDraftManager.class) {
                rubinoDraftManager = rubinoDraftManagerArr[i];
                if (rubinoDraftManager == null) {
                    rubinoDraftManager = new RubinoDraftManager(i);
                    rubinoDraftManagerArr[i] = rubinoDraftManager;
                }
            }
        }
        return rubinoDraftManager;
    }

    public void removeSendingPost(int i) {
        this.sendingPostInfoMap.remove(Integer.valueOf(i));
    }

    public void addSendingPost(RubinoSendingPost rubinoSendingPost) {
        this.sendingPostInfoMap.put(Integer.valueOf(rubinoSendingPost.rnd), rubinoSendingPost);
    }

    public RubinoSendingPost createSendingPost(RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry, String str) {
        ArrayList<RGHMediaHelper$PhotoEntry> arrayList = new ArrayList<>();
        arrayList.add(rGHMediaHelper$PhotoEntry);
        return createSendingPost(arrayList, str);
    }

    public RubinoSendingPost createSendingPost(ArrayList<RGHMediaHelper$PhotoEntry> arrayList, String str) {
        RubinoSendingPost rubinoSendingPost = new RubinoSendingPost(this.currentAccount);
        rubinoSendingPost.currentIndex = 0;
        rubinoSendingPost.entryList = arrayList;
        rubinoSendingPost.rnd = AndroidUtilities.getNextRnd();
        rubinoSendingPost.sendingStatus = RubinoSendingPost.SendingStatus.initNextUpload;
        rubinoSendingPost.profile_id = str;
        return rubinoSendingPost;
    }

    public void clear() {
        ConcurrentHashMap<Integer, RubinoSendingPost> concurrentHashMap = this.sendingPostInfoMap;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
    }

    public static class RubinoSendingPost extends PresenterItem {
        public String accessHashRec;
        public String accessHashRecSnapShot;
        public String accessHashThumbnail;
        public boolean allow_show_comment;
        public String caption;
        final int currentAccount;
        public ArrayList<RGHMediaHelper$PhotoEntry> entryList;
        public String fileId;
        public String fileIdSnapShot;
        public String fileIdThumbnail;
        public MediaController.SSHMediaConvertRequest mediaConvertRequest;
        public String postId;
        public String profile_id;
        public int rnd;
        public int currentIndex = 0;
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

        public RubinoSendingPost(int i) {
            this.currentAccount = i;
        }

        public boolean isMulti() {
            ArrayList<RGHMediaHelper$PhotoEntry> arrayList = this.entryList;
            return arrayList != null && arrayList.size() > 1;
        }

        public boolean isIGTV() {
            RGHMediaHelper$PhotoEntry currentSendingEntry;
            return (isMulti() || (currentSendingEntry = getCurrentSendingEntry()) == null || currentSendingEntry.editedInfo == null || getCurrentSendingEntry().editedInfo.estimatedDuration <= (RGHAddPostActivity.minIGTVDuration + 1) * 1000000) ? false : true;
        }

        public RGHMediaHelper$PhotoEntry getCurrentSendingEntry() {
            int i;
            if (this.currentIndex >= this.entryList.size() || (i = this.currentIndex) < 0) {
                return null;
            }
            return this.entryList.get(i);
        }

        public void increaseIndexIfPosible() {
            if (this.currentIndex < this.entryList.size() - 1) {
                this.currentIndex++;
            } else {
                this.currentIndex = -1;
            }
        }

        public int getProgress() {
            if (getCurrentSendingEntry() == null) {
                return 100;
            }
            int size = this.entryList.size();
            int i = this.currentIndex;
            int uploadProgress = FileLoaderInsta.getInstance(this.currentAccount).getUploadProgress(this.rnd) / size;
            int i2 = (i * 100) / size;
            if (this.sendingStatus == SendingStatus.initNextUpload) {
                return i2;
            }
            if (getCurrentSendingEntry().isVideo) {
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
                    return (int) (d + (d2 * 0.5d));
                }
                if (sendingStatus != SendingStatus.uploadingFile) {
                    return sendingStatus == SendingStatus.uploadingSnapShot ? (int) (i2 + (90.0f / size) + (uploadProgress * 0.05f)) : i2 + (100 / size);
                }
                double d3 = i2;
                double d4 = size;
                Double.isNaN(d4);
                Double.isNaN(d3);
                double d5 = uploadProgress * 0.4f;
                Double.isNaN(d5);
                return (int) (d3 + (50.0d / d4) + d5);
            }
            SendingStatus sendingStatus2 = this.sendingStatus;
            return sendingStatus2 == SendingStatus.uploadingFile ? i2 + ((int) (uploadProgress * 0.9f)) : sendingStatus2 == SendingStatus.uploadingThumbnail ? (int) (i2 + (90.0f / size) + (uploadProgress * 0.1f)) : i2 + (100 / size);
        }

        @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
        public PresenterItemType getPresenterType() {
            return PresenterItemType.SendingPostInsta;
        }
    }
}
