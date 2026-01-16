package ir.appp.messenger;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Build;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.rghapp.DispatchQueue;
import ir.appp.rghapp.videocompress.RGHCompress;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.FirebaseEventSender;
import ir.resaneh1.iptv.helper.ImageHelper;
import ir.resaneh1.iptv.insta.FileLoaderInsta;
import ir.resaneh1.iptv.insta.FileUploadOperationInsta;
import ir.resaneh1.iptv.insta.InstaDraftManager;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.InataAddPostOutput;
import ir.resaneh1.iptv.model.InstaAddPostInput;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.RubinoAddFilePostInput;
import ir.resaneh1.iptv.model.RubinoPublishPostInput;
import ir.resaneh1.iptv.model.RubinoUpdateProfilePhotoInput;
import ir.resaneh1.iptv.model.SendingMediaInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.BaseController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.Utilities;
import org.rbmain.messenger.VideoEditedInfo;
import retrofit2.Call;

/* loaded from: classes3.dex */
public class SendMessagesHelper extends BaseController implements NotificationCenter.NotificationCenterDelegate {
    private static ThreadPoolExecutor mediaSendThreadPool;
    private static DispatchQueue mySendMediaQueue = new DispatchQueue("myMediaSendQueue");
    private static volatile SendMessagesHelper[] Instance = new SendMessagesHelper[3];

    static {
        int iAvailableProcessors = Build.VERSION.SDK_INT >= 17 ? Runtime.getRuntime().availableProcessors() : 2;
        mediaSendThreadPool = new ThreadPoolExecutor(iAvailableProcessors, iAvailableProcessors, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    public static SendMessagesHelper getInstance(int i) {
        SendMessagesHelper sendMessagesHelper = Instance[i];
        if (sendMessagesHelper == null) {
            synchronized (SendMessagesHelper.class) {
                sendMessagesHelper = Instance[i];
                if (sendMessagesHelper == null) {
                    SendMessagesHelper[] sendMessagesHelperArr = Instance;
                    SendMessagesHelper sendMessagesHelper2 = new SendMessagesHelper(i);
                    sendMessagesHelperArr[i] = sendMessagesHelper2;
                    sendMessagesHelper = sendMessagesHelper2;
                }
            }
        }
        return sendMessagesHelper;
    }

    SendMessagesHelper(int i) {
        super(i);
        addObserver();
    }

    public void addObserver() {
        getNotificationCenter().addObserver(this, NotificationCenter.myFileUploadDoneInsta);
        getNotificationCenter().addObserver(this, NotificationCenter.myFileUploadProgressInsta);
        getNotificationCenter().addObserver(this, NotificationCenter.myFileUploadFaildInsta);
        getNotificationCenter().addObserver(this, NotificationCenter.myFileUploadDoneMessengerV2);
        getNotificationCenter().addObserver(this, NotificationCenter.myFileUploadProgressMessengerV2);
        getNotificationCenter().addObserver(this, NotificationCenter.myFileUploadFaildMessengerV2);
        getNotificationCenter().addObserver(this, NotificationCenter.compressVideoProgressChanged);
        getNotificationCenter().addObserver(this, NotificationCenter.compressVideoDone);
        getNotificationCenter().addObserver(this, NotificationCenter.compressVideoFaild);
        getNotificationCenter().addObserver(this, NotificationCenter.sshFileNewChunkAvailable);
        getNotificationCenter().addObserver(this, NotificationCenter.sshFilePreparingFailed);
        getNotificationCenter().addObserver(this, NotificationCenter.sshFilePreparingStarted);
    }

    public void prepareSendVideoRubino(ArrayList<SendingMediaInfo> arrayList, String str, String str2) {
        addObserver();
        int nextRnd = AndroidUtilities.getNextRnd();
        InstaDraftManager.getInstance(this.currentAccount).addSendingFile(nextRnd, arrayList, str, str2);
        doNext(InstaDraftManager.getInstance(this.currentAccount).sendingMediaInfoMap.get(Integer.valueOf(nextRnd)));
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.SendMessagesHelper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$prepareSendVideoRubino$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$prepareSendVideoRubino$0() {
        getNotificationCenter().postNotificationName(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
    }

    private static class MediaSendPrepareWorker {
        public volatile String comperessedPath;
        public CountDownLatch sync;
        public volatile String thumbPath;

        private MediaSendPrepareWorker() {
        }
    }

    public void compressPhoto(final SendingMediaInfo sendingMediaInfo) throws InterruptedException {
        final MediaSendPrepareWorker mediaSendPrepareWorker = new MediaSendPrepareWorker();
        mediaSendPrepareWorker.sync = new CountDownLatch(1);
        mediaSendThreadPool.execute(new Runnable(this) { // from class: ir.appp.messenger.SendMessagesHelper.1
            @Override // java.lang.Runnable
            public void run() {
                mediaSendPrepareWorker.thumbPath = ImageHelper.compressImageAndSave(ImageHelper.loadImage(sendingMediaInfo.orginalPath, 256.0f, 256.0f, true));
                mediaSendPrepareWorker.comperessedPath = ImageHelper.compressImageAndSave(ImageHelper.loadImage(sendingMediaInfo.orginalPath, 800.0f, 800.0f, false));
                mediaSendPrepareWorker.sync.countDown();
            }
        });
        if (mediaSendPrepareWorker.comperessedPath == null) {
            try {
                mediaSendPrepareWorker.sync.await();
            } catch (Exception unused) {
            }
        }
        sendingMediaInfo.path = mediaSendPrepareWorker.comperessedPath;
        sendingMediaInfo.thumbPath = mediaSendPrepareWorker.thumbPath;
    }

    /* renamed from: ir.appp.messenger.SendMessagesHelper$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ String val$caption;
        final /* synthetic */ ArrayList val$sendingMediaInfos;

        AnonymousClass2(ArrayList arrayList, String str) {
            this.val$sendingMediaInfos = arrayList;
            this.val$caption = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            int nextRnd = AndroidUtilities.getNextRnd();
            try {
                if (this.val$sendingMediaInfos.size() <= 0) {
                    return;
                }
                InstaDraftManager.getInstance(((BaseController) SendMessagesHelper.this).currentAccount).addSendingFile(nextRnd, this.val$sendingMediaInfos, this.val$caption, AppRubinoPreferences.getInstance(((BaseController) SendMessagesHelper.this).currentAccount).getInstaCurrentProfileObject().id);
                SendMessagesHelper.this.doNext(InstaDraftManager.getInstance(((BaseController) SendMessagesHelper.this).currentAccount).sendingMediaInfoMap.get(Integer.valueOf(nextRnd)));
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.SendMessagesHelper$2$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$0();
                    }
                });
            } catch (Exception e) {
                MyLog.handleException(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0() {
            SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
        }
    }

    public void prepareSendPhotoPostRubino(ArrayList<SendingMediaInfo> arrayList, String str, String str2) {
        addObserver();
        mySendMediaQueue.postRunnable(new AnonymousClass2(arrayList, str));
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) throws InterruptedException, IOException {
        InstaDraftManager.SendingPostInsta.SendingStatus sendingStatus;
        if (i == NotificationCenter.myFileUploadProgressInsta) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.SendMessagesHelper.3
                @Override // java.lang.Runnable
                public void run() {
                    SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaPostChangeProgressView, new Object[0]);
                    SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaUploadProfilePhotoProgressView, new Object[0]);
                }
            });
            return;
        }
        if (i == NotificationCenter.myFileUploadDoneInsta) {
            int iIntValue = ((Integer) objArr[0]).intValue();
            InstaDraftManager.SendingPostInsta sendingPostInsta = InstaDraftManager.getInstance(this.currentAccount).sendingMediaInfoMap.get(Integer.valueOf(iIntValue));
            if (sendingPostInsta != null) {
                if (sendingPostInsta.getCurrentSendingMedia() == null && ((sendingStatus = sendingPostInsta.sendingStatus) == InstaDraftManager.SendingPostInsta.SendingStatus.sendingPost || sendingStatus == InstaDraftManager.SendingPostInsta.SendingStatus.addFileToPost)) {
                    sendingPostInsta.sendingStatus = InstaDraftManager.SendingPostInsta.SendingStatus.publishPost;
                } else if (sendingPostInsta.getCurrentSendingMedia() != null && sendingPostInsta.getCurrentSendingMedia().isVideo) {
                    InstaDraftManager.SendingPostInsta.SendingStatus sendingStatus2 = sendingPostInsta.sendingStatus;
                    if (sendingStatus2 == InstaDraftManager.SendingPostInsta.SendingStatus.uploadingFile) {
                        sendingPostInsta.sendingStatus = InstaDraftManager.SendingPostInsta.SendingStatus.uploadingSnapShot;
                        sendingPostInsta.fileId = objArr[1] + BuildConfig.FLAVOR;
                        StringBuilder sb = new StringBuilder();
                        sb.append(objArr[2]);
                        sb.append(BuildConfig.FLAVOR);
                        sendingPostInsta.accessHashRec = objArr[3] + BuildConfig.FLAVOR;
                    } else if (sendingStatus2 == InstaDraftManager.SendingPostInsta.SendingStatus.uploadingSnapShot) {
                        sendingPostInsta.fileIdSnapShot = objArr[1] + BuildConfig.FLAVOR;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(objArr[2]);
                        sb2.append(BuildConfig.FLAVOR);
                        sendingPostInsta.accessHashRecSnapShot = objArr[3] + BuildConfig.FLAVOR;
                        if (sendingPostInsta.index == 0) {
                            sendingPostInsta.sendingStatus = InstaDraftManager.SendingPostInsta.SendingStatus.uploadingThumbnail;
                        } else {
                            sendingPostInsta.sendingStatus = InstaDraftManager.SendingPostInsta.SendingStatus.addFileToPost;
                        }
                    } else if (sendingStatus2 == InstaDraftManager.SendingPostInsta.SendingStatus.uploadingThumbnail) {
                        sendingPostInsta.fileIdThumbnail = objArr[1] + BuildConfig.FLAVOR;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(objArr[2]);
                        sb3.append(BuildConfig.FLAVOR);
                        sendingPostInsta.accessHashThumbnail = objArr[3] + BuildConfig.FLAVOR;
                        if (sendingPostInsta.index == 0) {
                            sendingPostInsta.sendingStatus = InstaDraftManager.SendingPostInsta.SendingStatus.sendingPost;
                        }
                    }
                } else if (sendingPostInsta.getCurrentSendingMedia() != null && !sendingPostInsta.getCurrentSendingMedia().isVideo) {
                    InstaDraftManager.SendingPostInsta.SendingStatus sendingStatus3 = sendingPostInsta.sendingStatus;
                    if (sendingStatus3 == InstaDraftManager.SendingPostInsta.SendingStatus.uploadingFile) {
                        sendingPostInsta.fileId = objArr[1] + BuildConfig.FLAVOR;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(objArr[2]);
                        sb4.append(BuildConfig.FLAVOR);
                        sendingPostInsta.accessHashRec = objArr[3] + BuildConfig.FLAVOR;
                        if (sendingPostInsta.index == 0) {
                            sendingPostInsta.sendingStatus = InstaDraftManager.SendingPostInsta.SendingStatus.uploadingThumbnail;
                        } else {
                            sendingPostInsta.sendingStatus = InstaDraftManager.SendingPostInsta.SendingStatus.addFileToPost;
                        }
                    } else if (sendingStatus3 == InstaDraftManager.SendingPostInsta.SendingStatus.uploadingThumbnail) {
                        sendingPostInsta.fileIdThumbnail = objArr[1] + BuildConfig.FLAVOR;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(objArr[2]);
                        sb5.append(BuildConfig.FLAVOR);
                        sendingPostInsta.accessHashThumbnail = objArr[3] + BuildConfig.FLAVOR;
                        if (sendingPostInsta.index == 0) {
                            sendingPostInsta.sendingStatus = InstaDraftManager.SendingPostInsta.SendingStatus.sendingPost;
                        }
                    }
                }
                doNext(sendingPostInsta);
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.SendMessagesHelper.4
                    @Override // java.lang.Runnable
                    public void run() {
                        SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
                    }
                });
            }
            InstaDraftManager.SendingProfilePhoto sendingProfilePhoto = InstaDraftManager.getInstance(this.currentAccount).sendingProfilePhotoMap.get(Integer.valueOf(iIntValue));
            if (sendingProfilePhoto != null) {
                InstaDraftManager.SendingProfilePhoto.SendingStatus sendingStatus4 = sendingProfilePhoto.sendingStatus;
                if (sendingStatus4 == InstaDraftManager.SendingProfilePhoto.SendingStatus.uploadingFile) {
                    sendingProfilePhoto.sendingStatus = InstaDraftManager.SendingProfilePhoto.SendingStatus.uploadingThumbnail;
                    sendingProfilePhoto.fileId = objArr[1] + BuildConfig.FLAVOR;
                    sendingProfilePhoto.accessHashRec = objArr[3] + BuildConfig.FLAVOR;
                    FileLoaderInsta.getInstance(this.currentAccount).uploadFile(iIntValue, sendingProfilePhoto.sendingMediaInfo.thumbPath, "1.jpg", "jpg", sendingProfilePhoto.profile_id);
                    return;
                }
                if (sendingStatus4 == InstaDraftManager.SendingProfilePhoto.SendingStatus.uploadingThumbnail) {
                    sendingProfilePhoto.sendingStatus = InstaDraftManager.SendingProfilePhoto.SendingStatus.update;
                    sendingProfilePhoto.fileIdThumb = objArr[1] + BuildConfig.FLAVOR;
                    sendingProfilePhoto.accessHashRecThumb = objArr[3] + BuildConfig.FLAVOR;
                    updateProfilePhotoRubino(sendingProfilePhoto);
                    return;
                }
                return;
            }
            return;
        }
        if (i == NotificationCenter.myFileUploadFaildInsta) {
            int iIntValue2 = ((Integer) objArr[0]).intValue();
            InstaDraftManager.SendingPostInsta sendingPostInsta2 = InstaDraftManager.getInstance(this.currentAccount).sendingMediaInfoMap.get(Integer.valueOf(iIntValue2));
            if (sendingPostInsta2 != null) {
                sendingPostInsta2.hasError = true;
                getNotificationCenter().postNotificationName(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
            }
            InstaDraftManager.SendingProfilePhoto sendingProfilePhoto2 = InstaDraftManager.getInstance(this.currentAccount).sendingProfilePhotoMap.get(Integer.valueOf(iIntValue2));
            if (sendingProfilePhoto2 != null) {
                if (objArr.length == 2) {
                    if (objArr[1] == FileUploadOperationInsta.UploadError.invalidUsername) {
                        sendingProfilePhoto2.isInvalidUserName = true;
                    }
                    if (sendingProfilePhoto2.isInvalidUserName) {
                        sendingProfilePhoto2.setStatusDone();
                        return;
                    }
                }
                sendingProfilePhoto2.setError();
                return;
            }
            return;
        }
        if (i == NotificationCenter.compressVideoProgressChanged) {
            int iIntValue3 = ((Integer) objArr[0]).intValue();
            final float fFloatValue = ((Float) objArr[1]).floatValue();
            final InstaDraftManager.SendingPostInsta sendingPostInsta3 = InstaDraftManager.getInstance(this.currentAccount).sendingMediaInfoMap.get(Integer.valueOf(iIntValue3));
            if (sendingPostInsta3 != null) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.SendMessagesHelper.5
                    @Override // java.lang.Runnable
                    public void run() {
                        sendingPostInsta3.convertProgress = fFloatValue;
                        SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaPostChangeProgressView, new Object[0]);
                    }
                });
                return;
            }
            return;
        }
        if (i == NotificationCenter.compressVideoDone) {
            int iIntValue4 = ((Integer) objArr[0]).intValue();
            String str = (String) objArr[1];
            InstaDraftManager.SendingPostInsta sendingPostInsta4 = InstaDraftManager.getInstance(this.currentAccount).sendingMediaInfoMap.get(Integer.valueOf(iIntValue4));
            if (sendingPostInsta4 != null) {
                sendingPostInsta4.sendingStatus = InstaDraftManager.SendingPostInsta.SendingStatus.uploadingFile;
                sendingPostInsta4.convertProgress = 0.0f;
                sendingPostInsta4.getCurrentSendingMedia().orginalPath = sendingPostInsta4.getCurrentSendingMedia().path;
                sendingPostInsta4.getCurrentSendingMedia().path = str;
                FileLoaderInsta.getInstance(this.currentAccount).uploadFile(sendingPostInsta4.rnd, sendingPostInsta4.getCurrentSendingMedia().path, "1.mp4", "mp4", sendingPostInsta4.profile_id);
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.SendMessagesHelper.6
                @Override // java.lang.Runnable
                public void run() {
                    SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
                }
            });
        }
    }

    private void updateProfilePhotoRubino(final InstaDraftManager.SendingProfilePhoto sendingProfilePhoto) {
        RubinoUpdateProfilePhotoInput rubinoUpdateProfilePhotoInput = new RubinoUpdateProfilePhotoInput();
        rubinoUpdateProfilePhotoInput.file_id = sendingProfilePhoto.fileId;
        rubinoUpdateProfilePhotoInput.hash_file_receive = sendingProfilePhoto.accessHashRec;
        rubinoUpdateProfilePhotoInput.thumbnail_file_id = sendingProfilePhoto.fileIdThumb;
        rubinoUpdateProfilePhotoInput.thumbnail_hash_file_receive = sendingProfilePhoto.accessHashRecThumb;
        rubinoUpdateProfilePhotoInput.profile_id = sendingProfilePhoto.profile_id;
        ApiRequestMessanger.getInstance(this.currentAccount).instaUpdateProfilePhoto(rubinoUpdateProfilePhotoInput, new ApiRequestMessanger.Listener(this) { // from class: ir.appp.messenger.SendMessagesHelper.7
            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onResponse(Call call, Object obj) {
                sendingProfilePhoto.setStatusDone();
                boolean z = sendingProfilePhoto.isUploadForMessengerAfterDone;
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onFailure(Call call, Throwable th) {
                sendingProfilePhoto.setError();
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onError(MessangerOutput messangerOutput) {
                if (messangerOutput.status_det == MessangerOutput.EnumStatusDet.INVALID_INPUT) {
                    sendingProfilePhoto.setStatusDone();
                    boolean z = sendingProfilePhoto.isUploadForMessengerAfterDone;
                } else {
                    sendingProfilePhoto.setError();
                }
            }
        });
    }

    private void uploadThumbnailPhotoRubino(int i, SendingMediaInfo sendingMediaInfo, String str) {
        FileLoaderInsta.getInstance(this.currentAccount).uploadFile(i, sendingMediaInfo.thumbPath, "1.jpg", "jpg", str);
    }

    private void uploadSnapshotRubino(int i, SendingMediaInfo sendingMediaInfo, String str) throws IOException {
        VideoEditedInfo videoEditedInfo = sendingMediaInfo.videoEditedInfo;
        long j = 0;
        if (videoEditedInfo != null) {
            long j2 = videoEditedInfo.startTime;
            if (j2 > 0) {
                j = j2;
            }
        }
        Bitmap bitmapCreateVideoSnapShotInsta = createVideoSnapShotInsta(sendingMediaInfo.orginalPath, j);
        if (bitmapCreateVideoSnapShotInsta == null) {
            bitmapCreateVideoSnapShotInsta = ThumbnailUtils.createVideoThumbnail(sendingMediaInfo.orginalPath, 1);
        }
        FileLoaderInsta.getInstance(this.currentAccount).uploadFile(i, ImageHelper.compressImageAndSave(bitmapCreateVideoSnapShotInsta), "1.jpg", "jpg", str);
    }

    public void addPostRubinoPicture(final InstaDraftManager.SendingPostInsta sendingPostInsta) {
        InstaAddPostInput instaAddPostInput = new InstaAddPostInput();
        instaAddPostInput.caption = sendingPostInsta.caption;
        instaAddPostInput.file_id = sendingPostInsta.fileId;
        instaAddPostInput.hash_file_receive = sendingPostInsta.accessHashRec;
        instaAddPostInput.thumbnail_file_id = sendingPostInsta.fileIdThumbnail;
        instaAddPostInput.thumbnail_hash_file_receive = sendingPostInsta.accessHashThumbnail;
        instaAddPostInput.height = sendingPostInsta.getCurrentSendingMedia().height + BuildConfig.FLAVOR;
        instaAddPostInput.width = sendingPostInsta.getCurrentSendingMedia().width + BuildConfig.FLAVOR;
        instaAddPostInput.post_type = "Picture";
        instaAddPostInput.rnd = sendingPostInsta.rnd;
        instaAddPostInput.profile_id = sendingPostInsta.profile_id;
        instaAddPostInput.is_multi_file = sendingPostInsta.isMulti();
        ApiRequestMessanger.getInstance(this.currentAccount).instaAddPost(instaAddPostInput, new ApiRequestMessanger.Listener() { // from class: ir.appp.messenger.SendMessagesHelper.8
            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onResponse(Call call, Object obj) throws InterruptedException, IOException {
                if (ApplicationLoader.applicationActivity != null) {
                    FirebaseEventSender.sendEvent(ApplicationLoader.applicationActivity, "robino_post", BuildConfig.FLAVOR);
                }
                InstaDraftManager.SendingPostInsta sendingPostInsta2 = InstaDraftManager.getInstance(((BaseController) SendMessagesHelper.this).currentAccount).sendingMediaInfoMap.get(Integer.valueOf(sendingPostInsta.rnd));
                if (sendingPostInsta2 == null) {
                    return;
                }
                final InataAddPostOutput inataAddPostOutput = (InataAddPostOutput) obj;
                if (inataAddPostOutput == null || inataAddPostOutput.post == null) {
                    sendingPostInsta2.hasError = true;
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.SendMessagesHelper.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
                        }
                    });
                    return;
                }
                if (!sendingPostInsta2.isMulti()) {
                    InstaDraftManager.getInstance(((BaseController) SendMessagesHelper.this).currentAccount).removeSendingPost(sendingPostInsta2.rnd);
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.SendMessagesHelper.8.3
                        @Override // java.lang.Runnable
                        public void run() {
                            SendMessagesHelper.this.getRubinoController().onAddPost(null, inataAddPostOutput.post.profile_id);
                            SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
                            SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaSendPostDone, new Object[0]);
                        }
                    });
                    return;
                }
                sendingPostInsta2.postId = inataAddPostOutput.post.id;
                sendingPostInsta2.increaseIndexIfPosible();
                if (sendingPostInsta2.getCurrentSendingMedia() != null) {
                    sendingPostInsta2.sendingStatus = InstaDraftManager.SendingPostInsta.SendingStatus.initNextUpload;
                    SendMessagesHelper.this.doNext(sendingPostInsta2);
                } else {
                    sendingPostInsta2.sendingStatus = InstaDraftManager.SendingPostInsta.SendingStatus.publishPost;
                    SendMessagesHelper.this.doNext(sendingPostInsta2);
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.SendMessagesHelper.8.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
                    }
                });
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onFailure(Call call, Throwable th) {
                InstaDraftManager.SendingPostInsta sendingPostInsta2 = InstaDraftManager.getInstance(((BaseController) SendMessagesHelper.this).currentAccount).sendingMediaInfoMap.get(Integer.valueOf(sendingPostInsta.rnd));
                if (sendingPostInsta2 != null) {
                    sendingPostInsta2.hasError = true;
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.SendMessagesHelper.8.4
                    @Override // java.lang.Runnable
                    public void run() {
                        SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
                    }
                });
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onError(MessangerOutput messangerOutput) {
                InstaDraftManager.SendingPostInsta sendingPostInsta2 = InstaDraftManager.getInstance(((BaseController) SendMessagesHelper.this).currentAccount).sendingMediaInfoMap.get(Integer.valueOf(sendingPostInsta.rnd));
                if (sendingPostInsta2 != null) {
                    sendingPostInsta2.hasError = true;
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.SendMessagesHelper.8.5
                    @Override // java.lang.Runnable
                    public void run() {
                        SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
                    }
                });
            }
        });
    }

    public void addVideoFileToPost(final InstaDraftManager.SendingPostInsta sendingPostInsta) {
        RubinoAddFilePostInput rubinoAddFilePostInput = new RubinoAddFilePostInput();
        rubinoAddFilePostInput.post_id = sendingPostInsta.postId;
        rubinoAddFilePostInput.file_type = RubinoAddFilePostInput.FileTypeEnum.Video;
        rubinoAddFilePostInput.file_id = sendingPostInsta.fileId;
        rubinoAddFilePostInput.hash_file_receive = sendingPostInsta.accessHashRec;
        rubinoAddFilePostInput.snapshot_file_id = sendingPostInsta.fileIdSnapShot;
        rubinoAddFilePostInput.snapshot_hash_file_receive = sendingPostInsta.accessHashRecSnapShot;
        rubinoAddFilePostInput.profile_id = sendingPostInsta.profile_id;
        rubinoAddFilePostInput.duration = sendingPostInsta.getCurrentSendingMedia().duration + BuildConfig.FLAVOR;
        ApiRequestMessanger.getInstance(this.currentAccount).rubinoAddFilePost(rubinoAddFilePostInput, new ApiRequestMessanger.Listener() { // from class: ir.appp.messenger.SendMessagesHelper.9
            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onResponse(Call call, Object obj) throws InterruptedException, IOException {
                InstaDraftManager.SendingPostInsta sendingPostInsta2 = InstaDraftManager.getInstance(((BaseController) SendMessagesHelper.this).currentAccount).sendingMediaInfoMap.get(Integer.valueOf(sendingPostInsta.rnd));
                sendingPostInsta2.increaseIndexIfPosible();
                if (sendingPostInsta2.getCurrentSendingMedia() != null) {
                    sendingPostInsta2.sendingStatus = InstaDraftManager.SendingPostInsta.SendingStatus.initNextUpload;
                    SendMessagesHelper.this.doNext(sendingPostInsta2);
                } else {
                    sendingPostInsta2.sendingStatus = InstaDraftManager.SendingPostInsta.SendingStatus.publishPost;
                    SendMessagesHelper.this.doNext(sendingPostInsta2);
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.SendMessagesHelper.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
                    }
                });
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onFailure(Call call, Throwable th) {
                InstaDraftManager.SendingPostInsta sendingPostInsta2 = InstaDraftManager.getInstance(((BaseController) SendMessagesHelper.this).currentAccount).sendingMediaInfoMap.get(Integer.valueOf(sendingPostInsta.rnd));
                if (sendingPostInsta2 != null) {
                    sendingPostInsta2.hasError = true;
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.SendMessagesHelper.9.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
                    }
                });
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onError(MessangerOutput messangerOutput) {
                InstaDraftManager.SendingPostInsta sendingPostInsta2 = InstaDraftManager.getInstance(((BaseController) SendMessagesHelper.this).currentAccount).sendingMediaInfoMap.get(Integer.valueOf(sendingPostInsta.rnd));
                if (sendingPostInsta2 != null) {
                    sendingPostInsta2.hasError = true;
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.SendMessagesHelper.9.3
                    @Override // java.lang.Runnable
                    public void run() {
                        SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
                    }
                });
            }
        });
    }

    public void addPictureFileToPost(final InstaDraftManager.SendingPostInsta sendingPostInsta) {
        RubinoAddFilePostInput rubinoAddFilePostInput = new RubinoAddFilePostInput();
        rubinoAddFilePostInput.post_id = sendingPostInsta.postId;
        rubinoAddFilePostInput.file_type = RubinoAddFilePostInput.FileTypeEnum.Picture;
        rubinoAddFilePostInput.file_id = sendingPostInsta.fileId;
        rubinoAddFilePostInput.hash_file_receive = sendingPostInsta.accessHashRec;
        rubinoAddFilePostInput.profile_id = sendingPostInsta.profile_id;
        ApiRequestMessanger.getInstance(this.currentAccount).rubinoAddFilePost(rubinoAddFilePostInput, new ApiRequestMessanger.Listener() { // from class: ir.appp.messenger.SendMessagesHelper.10
            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onResponse(Call call, Object obj) throws InterruptedException, IOException {
                InstaDraftManager.SendingPostInsta sendingPostInsta2 = InstaDraftManager.getInstance(((BaseController) SendMessagesHelper.this).currentAccount).sendingMediaInfoMap.get(Integer.valueOf(sendingPostInsta.rnd));
                sendingPostInsta2.increaseIndexIfPosible();
                if (sendingPostInsta2.getCurrentSendingMedia() != null) {
                    sendingPostInsta2.sendingStatus = InstaDraftManager.SendingPostInsta.SendingStatus.initNextUpload;
                    SendMessagesHelper.this.doNext(sendingPostInsta2);
                } else {
                    sendingPostInsta2.sendingStatus = InstaDraftManager.SendingPostInsta.SendingStatus.publishPost;
                    SendMessagesHelper.this.doNext(sendingPostInsta2);
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.SendMessagesHelper.10.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
                    }
                });
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onFailure(Call call, Throwable th) {
                InstaDraftManager.SendingPostInsta sendingPostInsta2 = InstaDraftManager.getInstance(((BaseController) SendMessagesHelper.this).currentAccount).sendingMediaInfoMap.get(Integer.valueOf(sendingPostInsta.rnd));
                if (sendingPostInsta2 != null) {
                    sendingPostInsta2.hasError = true;
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.SendMessagesHelper.10.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
                    }
                });
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onError(MessangerOutput messangerOutput) {
                InstaDraftManager.SendingPostInsta sendingPostInsta2 = InstaDraftManager.getInstance(((BaseController) SendMessagesHelper.this).currentAccount).sendingMediaInfoMap.get(Integer.valueOf(sendingPostInsta.rnd));
                if (sendingPostInsta2 != null) {
                    sendingPostInsta2.hasError = true;
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.SendMessagesHelper.10.3
                    @Override // java.lang.Runnable
                    public void run() {
                        SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
                    }
                });
            }
        });
    }

    public void publishPost(final InstaDraftManager.SendingPostInsta sendingPostInsta) {
        RubinoPublishPostInput rubinoPublishPostInput = new RubinoPublishPostInput();
        rubinoPublishPostInput.post_id = sendingPostInsta.postId;
        rubinoPublishPostInput.profile_id = sendingPostInsta.profile_id;
        ApiRequestMessanger.getInstance(this.currentAccount).rubinoPublishPost(rubinoPublishPostInput, new ApiRequestMessanger.Listener() { // from class: ir.appp.messenger.SendMessagesHelper.11
            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onResponse(Call call, Object obj) {
                final InstaDraftManager.SendingPostInsta sendingPostInsta2 = InstaDraftManager.getInstance(((BaseController) SendMessagesHelper.this).currentAccount).sendingMediaInfoMap.get(Integer.valueOf(sendingPostInsta.rnd));
                if (sendingPostInsta2 != null) {
                    InstaDraftManager.getInstance(((BaseController) SendMessagesHelper.this).currentAccount).removeSendingPost(sendingPostInsta2.rnd);
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.SendMessagesHelper.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SendMessagesHelper.this.getRubinoController().onAddPost(null, sendingPostInsta2.profile_id);
                        SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
                        SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaSendPostDone, new Object[0]);
                    }
                });
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onFailure(Call call, Throwable th) {
                InstaDraftManager.SendingPostInsta sendingPostInsta2 = InstaDraftManager.getInstance(((BaseController) SendMessagesHelper.this).currentAccount).sendingMediaInfoMap.get(Integer.valueOf(sendingPostInsta.rnd));
                if (sendingPostInsta2 != null) {
                    sendingPostInsta2.hasError = true;
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.SendMessagesHelper.11.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
                    }
                });
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onError(MessangerOutput messangerOutput) {
                InstaDraftManager.SendingPostInsta sendingPostInsta2 = InstaDraftManager.getInstance(((BaseController) SendMessagesHelper.this).currentAccount).sendingMediaInfoMap.get(Integer.valueOf(sendingPostInsta.rnd));
                if (sendingPostInsta2 != null) {
                    sendingPostInsta2.hasError = true;
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.SendMessagesHelper.11.3
                    @Override // java.lang.Runnable
                    public void run() {
                        SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
                    }
                });
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Bitmap createVideoSnapShotInsta(java.lang.String r3, long r4) throws java.io.IOException {
        /*
            android.media.MediaMetadataRetriever r0 = new android.media.MediaMetadataRetriever
            r0.<init>()
            r1 = 1
            r2 = 0
            r0.setDataSource(r3)     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L19
            android.graphics.Bitmap r3 = r0.getFrameAtTime(r4, r1)     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L19
            r0.release()     // Catch: java.lang.RuntimeException -> L12
            goto L1d
        L12:
            goto L1d
        L14:
            r3 = move-exception
            r0.release()     // Catch: java.lang.RuntimeException -> L18
        L18:
            throw r3
        L19:
            r0.release()     // Catch: java.lang.RuntimeException -> L1c
        L1c:
            r3 = r2
        L1d:
            if (r3 != 0) goto L20
            return r2
        L20:
            int r4 = r3.getWidth()
            int r5 = r3.getHeight()
            int r0 = java.lang.Math.max(r4, r5)
            r2 = 800(0x320, float:1.121E-42)
            if (r0 <= r2) goto L46
            r2 = 1145569280(0x44480000, float:800.0)
            float r0 = (float) r0
            float r2 = r2 / r0
            float r4 = (float) r4
            float r4 = r4 * r2
            int r4 = java.lang.Math.round(r4)
            float r5 = (float) r5
            float r2 = r2 * r5
            int r5 = java.lang.Math.round(r2)
            android.graphics.Bitmap r3 = org.rbmain.messenger.Bitmaps.createScaledBitmap(r3, r4, r5, r1)
        L46:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.messenger.SendMessagesHelper.createVideoSnapShotInsta(java.lang.String, long):android.graphics.Bitmap");
    }

    private void uploadThumbnailVideoRubino(final int i, final SendingMediaInfo sendingMediaInfo, final String str) {
        Utilities.myQueue.postRunnable(new Runnable() { // from class: ir.appp.messenger.SendMessagesHelper.14
            /* JADX WARN: Removed duplicated region for block: B:7:0x000f  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() throws java.io.IOException {
                /*
                    r7 = this;
                    ir.resaneh1.iptv.model.SendingMediaInfo r0 = r2
                    org.rbmain.messenger.VideoEditedInfo r1 = r0.videoEditedInfo
                    if (r1 == 0) goto Lf
                    long r1 = r1.startTime
                    r3 = 0
                    int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                    if (r5 <= 0) goto Lf
                    goto L11
                Lf:
                    r1 = 3
                L11:
                    java.lang.String r0 = r0.orginalPath
                    android.graphics.Bitmap r0 = ir.appp.messenger.SendMessagesHelper.createVideoThumbnailInsta(r0, r1)
                    if (r0 != 0) goto L22
                    ir.resaneh1.iptv.model.SendingMediaInfo r0 = r2
                    java.lang.String r0 = r0.orginalPath
                    r1 = 1
                    android.graphics.Bitmap r0 = android.media.ThumbnailUtils.createVideoThumbnail(r0, r1)
                L22:
                    int r1 = r0.getWidth()
                    int r2 = r0.getHeight()
                    r3 = 0
                    if (r1 >= r2) goto L45
                    int r1 = r0.getHeight()
                    int r2 = r0.getWidth()
                    int r1 = r1 - r2
                    int r1 = r1 / 2
                    int r2 = r0.getWidth()
                    int r4 = r0.getWidth()
                    android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r3, r1, r2, r4)
                    goto L66
                L45:
                    int r1 = r0.getHeight()
                    int r2 = r0.getWidth()
                    if (r1 >= r2) goto L66
                    int r1 = r0.getWidth()
                    int r2 = r0.getHeight()
                    int r1 = r1 - r2
                    int r1 = r1 / 2
                    int r2 = r0.getHeight()
                    int r4 = r0.getHeight()
                    android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r1, r3, r2, r4)
                L66:
                    if (r0 == 0) goto L81
                    java.lang.String r3 = ir.resaneh1.iptv.helper.ImageHelper.compressImageAndSave(r0)
                    ir.appp.messenger.SendMessagesHelper r0 = ir.appp.messenger.SendMessagesHelper.this
                    int r0 = ir.appp.messenger.SendMessagesHelper.access$4200(r0)
                    ir.resaneh1.iptv.insta.FileLoaderInsta r1 = ir.resaneh1.iptv.insta.FileLoaderInsta.getInstance(r0)
                    int r2 = r3
                    java.lang.String r6 = r4
                    java.lang.String r4 = "1.jpg"
                    java.lang.String r5 = "jpg"
                    r1.uploadFile(r2, r3, r4, r5, r6)
                L81:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.appp.messenger.SendMessagesHelper.AnonymousClass14.run():void");
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap createVideoThumbnailInsta(java.lang.String r2, long r3) throws java.io.IOException {
        /*
            android.media.MediaMetadataRetriever r0 = new android.media.MediaMetadataRetriever
            r0.<init>()
            r1 = 0
            r0.setDataSource(r2)     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L19
            r2 = 2
            android.graphics.Bitmap r2 = r0.getFrameAtTime(r3, r2)     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L19
            r0.release()     // Catch: java.lang.RuntimeException -> L12
            goto L1d
        L12:
            goto L1d
        L14:
            r2 = move-exception
            r0.release()     // Catch: java.lang.RuntimeException -> L18
        L18:
            throw r2
        L19:
            r0.release()     // Catch: java.lang.RuntimeException -> L1c
        L1c:
            r2 = r1
        L1d:
            if (r2 != 0) goto L20
            return r1
        L20:
            r2.getWidth()
            r2.getHeight()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.messenger.SendMessagesHelper.createVideoThumbnailInsta(java.lang.String, long):android.graphics.Bitmap");
    }

    public void addPostRubinoVideo(InstaDraftManager.SendingPostInsta sendingPostInsta) {
        InstaAddPostInput instaAddPostInput = new InstaAddPostInput();
        instaAddPostInput.caption = sendingPostInsta.getCurrentSendingMedia().caption.isEmpty() ? BuildConfig.FLAVOR : sendingPostInsta.getCurrentSendingMedia().caption;
        instaAddPostInput.file_id = sendingPostInsta.fileId;
        instaAddPostInput.hash_file_receive = sendingPostInsta.accessHashRec;
        instaAddPostInput.snapshot_file_id = sendingPostInsta.fileIdSnapShot;
        instaAddPostInput.snapshot_hash_file_receive = sendingPostInsta.accessHashRecSnapShot;
        instaAddPostInput.height = sendingPostInsta.getCurrentSendingMedia().height + BuildConfig.FLAVOR;
        instaAddPostInput.width = sendingPostInsta.getCurrentSendingMedia().width + BuildConfig.FLAVOR;
        instaAddPostInput.post_type = "Video";
        instaAddPostInput.duration = sendingPostInsta.getCurrentSendingMedia().duration + BuildConfig.FLAVOR;
        instaAddPostInput.thumbnail_file_id = sendingPostInsta.fileIdThumbnail;
        instaAddPostInput.thumbnail_hash_file_receive = sendingPostInsta.accessHashThumbnail;
        instaAddPostInput.rnd = sendingPostInsta.rnd;
        instaAddPostInput.profile_id = sendingPostInsta.profile_id;
        instaAddPostInput.is_multi_file = sendingPostInsta.isMulti();
        ApiRequestMessanger.getInstance(this.currentAccount).instaAddPost(instaAddPostInput, new AnonymousClass15(sendingPostInsta));
    }

    /* renamed from: ir.appp.messenger.SendMessagesHelper$15, reason: invalid class name */
    class AnonymousClass15 implements ApiRequestMessanger.Listener {
        final /* synthetic */ InstaDraftManager.SendingPostInsta val$sendingPostInsta;

        AnonymousClass15(InstaDraftManager.SendingPostInsta sendingPostInsta) {
            this.val$sendingPostInsta = sendingPostInsta;
        }

        @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
        public void onResponse(Call call, Object obj) throws InterruptedException, IOException {
            if (ApplicationLoader.applicationActivity != null) {
                FirebaseEventSender.sendEvent(ApplicationLoader.applicationActivity, "robino_post", BuildConfig.FLAVOR);
            }
            InstaDraftManager.SendingPostInsta sendingPostInsta = InstaDraftManager.getInstance(((BaseController) SendMessagesHelper.this).currentAccount).sendingMediaInfoMap.get(Integer.valueOf(this.val$sendingPostInsta.rnd));
            final InataAddPostOutput inataAddPostOutput = (InataAddPostOutput) obj;
            if (inataAddPostOutput == null || inataAddPostOutput.post == null) {
                sendingPostInsta.hasError = true;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.SendMessagesHelper.15.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
                    }
                });
                return;
            }
            if (!sendingPostInsta.isMulti()) {
                InstaDraftManager.getInstance(((BaseController) SendMessagesHelper.this).currentAccount).removeSendingPost(sendingPostInsta.rnd);
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.SendMessagesHelper.15.3
                    @Override // java.lang.Runnable
                    public void run() {
                        SendMessagesHelper.this.getRubinoController().onAddPost(null, inataAddPostOutput.post.profile_id);
                        SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
                        SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaSendPostDone, new Object[0]);
                    }
                });
                return;
            }
            sendingPostInsta.postId = inataAddPostOutput.post.id;
            sendingPostInsta.increaseIndexIfPosible();
            if (sendingPostInsta.getCurrentSendingMedia() != null) {
                sendingPostInsta.sendingStatus = InstaDraftManager.SendingPostInsta.SendingStatus.initNextUpload;
                SendMessagesHelper.this.doNext(sendingPostInsta);
            } else {
                sendingPostInsta.sendingStatus = InstaDraftManager.SendingPostInsta.SendingStatus.publishPost;
                SendMessagesHelper.this.doNext(sendingPostInsta);
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.SendMessagesHelper.15.2
                @Override // java.lang.Runnable
                public void run() {
                    SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
                }
            });
        }

        @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
        public void onFailure(Call call, Throwable th) {
            InstaDraftManager.SendingPostInsta sendingPostInsta = InstaDraftManager.getInstance(((BaseController) SendMessagesHelper.this).currentAccount).sendingMediaInfoMap.get(Integer.valueOf(this.val$sendingPostInsta.rnd));
            if (sendingPostInsta != null) {
                sendingPostInsta.hasError = true;
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.SendMessagesHelper.15.4
                @Override // java.lang.Runnable
                public void run() {
                    SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
                }
            });
        }

        @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
        public void onError(MessangerOutput messangerOutput) {
            InstaDraftManager.SendingPostInsta sendingPostInsta = InstaDraftManager.getInstance(((BaseController) SendMessagesHelper.this).currentAccount).sendingMediaInfoMap.get(Integer.valueOf(this.val$sendingPostInsta.rnd));
            if (sendingPostInsta != null) {
                sendingPostInsta.hasError = true;
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.SendMessagesHelper$15$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onError$0();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onError$0() {
            SendMessagesHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
        }
    }

    public void doNext(InstaDraftManager.SendingPostInsta sendingPostInsta) throws InterruptedException, IOException {
        if (sendingPostInsta != null) {
            if (sendingPostInsta.sendingStatus == InstaDraftManager.SendingPostInsta.SendingStatus.publishPost) {
                publishPost(sendingPostInsta);
                return;
            }
            if (sendingPostInsta.getCurrentSendingMedia().isVideo) {
                InstaDraftManager.SendingPostInsta.SendingStatus sendingStatus = sendingPostInsta.sendingStatus;
                if (sendingStatus == InstaDraftManager.SendingPostInsta.SendingStatus.initNextUpload) {
                    sendingPostInsta.sendingStatus = InstaDraftManager.SendingPostInsta.SendingStatus.converting;
                    doNext(sendingPostInsta);
                    return;
                }
                if (sendingStatus == InstaDraftManager.SendingPostInsta.SendingStatus.converting) {
                    sendingPostInsta.getCurrentSendingMedia().videoEditedInfo.rnd = sendingPostInsta.rnd;
                    sendingPostInsta.getCurrentSendingMedia().videoEditedInfo.currentAccount = this.currentAccount;
                    RGHCompress.getInstance().scheduleVideoConvert(sendingPostInsta.getCurrentSendingMedia().videoEditedInfo);
                    return;
                }
                if (sendingStatus == InstaDraftManager.SendingPostInsta.SendingStatus.uploadingFile) {
                    FileLoaderInsta.getInstance(this.currentAccount).uploadFile(sendingPostInsta.rnd, sendingPostInsta.getCurrentSendingMedia().path, "1.mp4", "mp4", sendingPostInsta.profile_id);
                    return;
                }
                if (sendingStatus == InstaDraftManager.SendingPostInsta.SendingStatus.uploadingSnapShot) {
                    uploadSnapshotRubino(sendingPostInsta.rnd, sendingPostInsta.getCurrentSendingMedia(), sendingPostInsta.profile_id);
                    return;
                }
                if (sendingStatus == InstaDraftManager.SendingPostInsta.SendingStatus.uploadingThumbnail) {
                    uploadThumbnailVideoRubino(sendingPostInsta.rnd, sendingPostInsta.getCurrentSendingMedia(), sendingPostInsta.profile_id);
                    return;
                } else if (sendingStatus == InstaDraftManager.SendingPostInsta.SendingStatus.sendingPost) {
                    addPostRubinoVideo(sendingPostInsta);
                    return;
                } else {
                    if (sendingStatus == InstaDraftManager.SendingPostInsta.SendingStatus.addFileToPost) {
                        addVideoFileToPost(sendingPostInsta);
                        return;
                    }
                    return;
                }
            }
            InstaDraftManager.SendingPostInsta.SendingStatus sendingStatus2 = sendingPostInsta.sendingStatus;
            if (sendingStatus2 == InstaDraftManager.SendingPostInsta.SendingStatus.initNextUpload) {
                sendingPostInsta.sendingStatus = InstaDraftManager.SendingPostInsta.SendingStatus.uploadingFile;
                doNext(sendingPostInsta);
                return;
            }
            if (sendingStatus2 == InstaDraftManager.SendingPostInsta.SendingStatus.uploadingFile) {
                compressPhoto(sendingPostInsta.getCurrentSendingMedia());
                FileLoaderInsta.getInstance(this.currentAccount).uploadFile(sendingPostInsta.rnd, sendingPostInsta.getCurrentSendingMedia().path, "1.jpg", "jpg", sendingPostInsta.profile_id);
            } else if (sendingStatus2 == InstaDraftManager.SendingPostInsta.SendingStatus.uploadingThumbnail) {
                uploadThumbnailPhotoRubino(sendingPostInsta.rnd, sendingPostInsta.getCurrentSendingMedia(), sendingPostInsta.profile_id);
            } else if (sendingStatus2 == InstaDraftManager.SendingPostInsta.SendingStatus.sendingPost) {
                addPostRubinoPicture(sendingPostInsta);
            } else if (sendingStatus2 == InstaDraftManager.SendingPostInsta.SendingStatus.addFileToPost) {
                addPictureFileToPost(sendingPostInsta);
            }
        }
    }
}
