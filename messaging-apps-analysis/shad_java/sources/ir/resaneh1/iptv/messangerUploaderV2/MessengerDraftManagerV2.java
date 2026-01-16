package ir.resaneh1.iptv.messangerUploaderV2;

import j$.util.concurrent.ConcurrentHashMap;
import org.rbmain.messenger.BaseController;

/* loaded from: classes3.dex */
public class MessengerDraftManagerV2 extends BaseController {
    private static volatile MessengerDraftManagerV2[] Instance = new MessengerDraftManagerV2[3];
    public ConcurrentHashMap<Integer, SendingProfilePhoto> sendingProfilePhotoMap;

    public MessengerDraftManagerV2(int i) {
        super(i);
        this.sendingProfilePhotoMap = new ConcurrentHashMap<>(0);
    }

    public static MessengerDraftManagerV2 getInstance(int i) {
        MessengerDraftManagerV2 messengerDraftManagerV2 = Instance[i];
        if (messengerDraftManagerV2 == null) {
            synchronized (MessengerDraftManagerV2.class) {
                messengerDraftManagerV2 = Instance[i];
                if (messengerDraftManagerV2 == null) {
                    MessengerDraftManagerV2[] messengerDraftManagerV2Arr = Instance;
                    MessengerDraftManagerV2 messengerDraftManagerV22 = new MessengerDraftManagerV2(i);
                    messengerDraftManagerV2Arr[i] = messengerDraftManagerV22;
                    messengerDraftManagerV2 = messengerDraftManagerV22;
                }
            }
        }
        return messengerDraftManagerV2;
    }

    public static class SendingProfilePhoto {
        public boolean hasError = false;

        public enum SendingStatus {
            uploadingFile,
            uploadingThumbnail,
            update,
            done
        }

        public SendingProfilePhoto() {
            SendingStatus sendingStatus = SendingStatus.uploadingFile;
        }
    }
}
