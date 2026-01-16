package ir.appp.messenger;

import android.os.Build;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import ir.appp.rghapp.RGHMediaHelper$PhotoEntry;
import ir.appp.rghapp.Utils;
import ir.appp.rghapp.rubinoPostSlider.PostTagObject;
import ir.resaneh1.iptv.fragment.rubino.RubinoController;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.ImageHelper;
import ir.resaneh1.iptv.insta.FileLoaderInsta;
import ir.resaneh1.iptv.insta.RubinoDraftManager;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.Rubino;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.BaseController;
import org.rbmain.messenger.MediaController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.Utilities;
import org.rbmain.ui.Components.Point;

/* loaded from: classes3.dex */
public class SendPostHelper extends BaseController implements NotificationCenter.NotificationCenterDelegate {
    private static volatile SendPostHelper[] Instance = new SendPostHelper[3];
    private CompositeDisposable compositeDisposable;

    static {
        int iAvailableProcessors = Build.VERSION.SDK_INT >= 17 ? Runtime.getRuntime().availableProcessors() : 2;
        new ThreadPoolExecutor(iAvailableProcessors, iAvailableProcessors, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    public static SendPostHelper getInstance(int i) {
        SendPostHelper sendPostHelper = Instance[i];
        if (sendPostHelper == null) {
            synchronized (SendPostHelper.class) {
                sendPostHelper = Instance[i];
                if (sendPostHelper == null) {
                    SendPostHelper[] sendPostHelperArr = Instance;
                    SendPostHelper sendPostHelper2 = new SendPostHelper(i);
                    sendPostHelperArr[i] = sendPostHelper2;
                    sendPostHelper = sendPostHelper2;
                }
            }
        }
        return sendPostHelper;
    }

    SendPostHelper(int i) {
        super(i);
        this.compositeDisposable = new CompositeDisposable();
        addObserver();
    }

    public void addObserver() {
        getNotificationCenter().addObserver(this, NotificationCenter.myFileUploadDoneInsta);
        getNotificationCenter().addObserver(this, NotificationCenter.myFileUploadProgressInsta);
        getNotificationCenter().addObserver(this, NotificationCenter.myFileUploadFaildInsta);
        getNotificationCenter().addObserver(this, NotificationCenter.myFileUploadDoneMessengerV2);
        getNotificationCenter().addObserver(this, NotificationCenter.myFileUploadProgressMessengerV2);
        getNotificationCenter().addObserver(this, NotificationCenter.myFileUploadFaildMessengerV2);
        getNotificationCenter().addObserver(this, NotificationCenter.sshFileNewChunkAvailable);
        getNotificationCenter().addObserver(this, NotificationCenter.sshFilePreparingFailed);
        getNotificationCenter().addObserver(this, NotificationCenter.sshFilePreparingStarted);
    }

    public void prepareSendPostRubino(RubinoDraftManager.RubinoSendingPost rubinoSendingPost) throws InterruptedException {
        addObserver();
        RubinoDraftManager.getInstance(this.currentAccount).addSendingPost(rubinoSendingPost);
        doNext(rubinoSendingPost);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.SendPostHelper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$prepareSendPostRubino$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$prepareSendPostRubino$0() {
        getNotificationCenter().postNotificationName(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) throws InterruptedException {
        RubinoDraftManager.RubinoSendingPost.SendingStatus sendingStatus;
        if (i == NotificationCenter.myFileUploadProgressInsta) {
            MyLog.e("SendPost", "progress upload");
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.SendPostHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    SendPostHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaPostChangeProgressView, new Object[0]);
                    SendPostHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaUploadProfilePhotoProgressView, new Object[0]);
                }
            });
            return;
        }
        if (i == NotificationCenter.myFileUploadDoneInsta) {
            MyLog.e("SendPost", "finish upload");
            RubinoDraftManager.RubinoSendingPost rubinoSendingPost = RubinoDraftManager.getInstance(this.currentAccount).sendingPostInfoMap.get(Integer.valueOf(((Integer) objArr[0]).intValue()));
            if (rubinoSendingPost != null) {
                if (rubinoSendingPost.getCurrentSendingEntry() == null && ((sendingStatus = rubinoSendingPost.sendingStatus) == RubinoDraftManager.RubinoSendingPost.SendingStatus.sendingPost || sendingStatus == RubinoDraftManager.RubinoSendingPost.SendingStatus.addFileToPost)) {
                    rubinoSendingPost.sendingStatus = RubinoDraftManager.RubinoSendingPost.SendingStatus.publishPost;
                } else if (rubinoSendingPost.getCurrentSendingEntry() != null && rubinoSendingPost.getCurrentSendingEntry().isVideo) {
                    RubinoDraftManager.RubinoSendingPost.SendingStatus sendingStatus2 = rubinoSendingPost.sendingStatus;
                    if (sendingStatus2 == RubinoDraftManager.RubinoSendingPost.SendingStatus.uploadingFile) {
                        rubinoSendingPost.sendingStatus = RubinoDraftManager.RubinoSendingPost.SendingStatus.uploadingSnapShot;
                        rubinoSendingPost.fileId = objArr[1] + BuildConfig.FLAVOR;
                        StringBuilder sb = new StringBuilder();
                        sb.append(objArr[2]);
                        sb.append(BuildConfig.FLAVOR);
                        rubinoSendingPost.accessHashRec = objArr[3] + BuildConfig.FLAVOR;
                    } else if (sendingStatus2 == RubinoDraftManager.RubinoSendingPost.SendingStatus.uploadingSnapShot) {
                        rubinoSendingPost.fileIdSnapShot = objArr[1] + BuildConfig.FLAVOR;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(objArr[2]);
                        sb2.append(BuildConfig.FLAVOR);
                        rubinoSendingPost.accessHashRecSnapShot = objArr[3] + BuildConfig.FLAVOR;
                        if (rubinoSendingPost.currentIndex == 0) {
                            rubinoSendingPost.sendingStatus = RubinoDraftManager.RubinoSendingPost.SendingStatus.uploadingThumbnail;
                        } else {
                            rubinoSendingPost.sendingStatus = RubinoDraftManager.RubinoSendingPost.SendingStatus.addFileToPost;
                        }
                    } else if (sendingStatus2 == RubinoDraftManager.RubinoSendingPost.SendingStatus.uploadingThumbnail) {
                        rubinoSendingPost.fileIdThumbnail = objArr[1] + BuildConfig.FLAVOR;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(objArr[2]);
                        sb3.append(BuildConfig.FLAVOR);
                        rubinoSendingPost.accessHashThumbnail = objArr[3] + BuildConfig.FLAVOR;
                        if (rubinoSendingPost.currentIndex == 0) {
                            rubinoSendingPost.sendingStatus = RubinoDraftManager.RubinoSendingPost.SendingStatus.sendingPost;
                        }
                    }
                } else if (rubinoSendingPost.getCurrentSendingEntry() != null && !rubinoSendingPost.getCurrentSendingEntry().isVideo) {
                    RubinoDraftManager.RubinoSendingPost.SendingStatus sendingStatus3 = rubinoSendingPost.sendingStatus;
                    if (sendingStatus3 == RubinoDraftManager.RubinoSendingPost.SendingStatus.uploadingFile) {
                        rubinoSendingPost.fileId = objArr[1] + BuildConfig.FLAVOR;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(objArr[2]);
                        sb4.append(BuildConfig.FLAVOR);
                        rubinoSendingPost.accessHashRec = objArr[3] + BuildConfig.FLAVOR;
                        if (rubinoSendingPost.currentIndex == 0) {
                            rubinoSendingPost.sendingStatus = RubinoDraftManager.RubinoSendingPost.SendingStatus.uploadingThumbnail;
                        } else {
                            rubinoSendingPost.sendingStatus = RubinoDraftManager.RubinoSendingPost.SendingStatus.addFileToPost;
                        }
                    } else if (sendingStatus3 == RubinoDraftManager.RubinoSendingPost.SendingStatus.uploadingThumbnail) {
                        rubinoSendingPost.fileIdThumbnail = objArr[1] + BuildConfig.FLAVOR;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(objArr[2]);
                        sb5.append(BuildConfig.FLAVOR);
                        rubinoSendingPost.accessHashThumbnail = objArr[3] + BuildConfig.FLAVOR;
                        if (rubinoSendingPost.currentIndex == 0) {
                            rubinoSendingPost.sendingStatus = RubinoDraftManager.RubinoSendingPost.SendingStatus.sendingPost;
                        }
                    }
                }
                doNext(rubinoSendingPost);
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.SendPostHelper.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SendPostHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
                    }
                });
                return;
            }
            return;
        }
        if (i == NotificationCenter.myFileUploadFaildInsta) {
            MyLog.e("SendPost", "failed upload");
            RubinoDraftManager.RubinoSendingPost rubinoSendingPost2 = RubinoDraftManager.getInstance(this.currentAccount).sendingPostInfoMap.get(Integer.valueOf(((Integer) objArr[0]).intValue()));
            if (rubinoSendingPost2 != null) {
                rubinoSendingPost2.hasError = true;
                getNotificationCenter().postNotificationName(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
                return;
            }
            return;
        }
        if (i == NotificationCenter.sshFileNewChunkAvailable) {
            MyLog.e("SendPost", "progress sshFileNewChunk");
            MediaController.SSHMediaConvertRequest sSHMediaConvertRequest = (MediaController.SSHMediaConvertRequest) objArr[0];
            float fFloatValue = ((Float) objArr[4]).floatValue();
            int i3 = sSHMediaConvertRequest.postRnd;
            long jLongValue = ((Long) objArr[3]).longValue();
            RubinoDraftManager.RubinoSendingPost rubinoSendingPost3 = RubinoDraftManager.getInstance(this.currentAccount).sendingPostInfoMap.get(Integer.valueOf(i3));
            if (rubinoSendingPost3 != null) {
                if (jLongValue == 0) {
                    rubinoSendingPost3.convertProgress = fFloatValue * 100.0f;
                    getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.myInstaPostChangeProgressView, new Object[0]);
                    return;
                }
                MyLog.e("SendPost", "progress sshFileNewChunk last last");
                rubinoSendingPost3.sendingStatus = RubinoDraftManager.RubinoSendingPost.SendingStatus.uploadingFile;
                rubinoSendingPost3.convertProgress = 0.0f;
                rubinoSendingPost3.getCurrentSendingEntry().path = sSHMediaConvertRequest.cacheFile.getAbsolutePath();
                if (rubinoSendingPost3.getCurrentSendingEntry().isVideo) {
                    FileLoaderInsta.getInstance(this.currentAccount).uploadFile(rubinoSendingPost3.rnd, rubinoSendingPost3.getCurrentSendingEntry().path, "1.mp4", "mp4", rubinoSendingPost3.profile_id);
                } else {
                    FileLoaderInsta.getInstance(this.currentAccount).uploadFile(rubinoSendingPost3.rnd, rubinoSendingPost3.getCurrentSendingEntry().path, "1.jpg", "jpg", rubinoSendingPost3.profile_id);
                }
                getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
                return;
            }
            return;
        }
        if (i == NotificationCenter.sshFilePreparingFailed) {
            MyLog.e("SendPost", "progress sshFilePreparingFailed");
            RubinoDraftManager.RubinoSendingPost rubinoSendingPost4 = RubinoDraftManager.getInstance(this.currentAccount).sendingPostInfoMap.get(Integer.valueOf(((MediaController.SSHMediaConvertRequest) objArr[0]).postRnd));
            if (rubinoSendingPost4 != null) {
                rubinoSendingPost4.hasError = true;
                getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
                return;
            }
            return;
        }
        if (i == NotificationCenter.compressVideoDone) {
            int iIntValue = ((Integer) objArr[0]).intValue();
            String str = (String) objArr[1];
            RubinoDraftManager.RubinoSendingPost rubinoSendingPost5 = RubinoDraftManager.getInstance(this.currentAccount).sendingPostInfoMap.get(Integer.valueOf(iIntValue));
            if (rubinoSendingPost5 != null) {
                rubinoSendingPost5.sendingStatus = RubinoDraftManager.RubinoSendingPost.SendingStatus.uploadingFile;
                rubinoSendingPost5.convertProgress = 0.0f;
                rubinoSendingPost5.getCurrentSendingEntry().path = str;
                FileLoaderInsta.getInstance(this.currentAccount).uploadFile(rubinoSendingPost5.rnd, rubinoSendingPost5.getCurrentSendingEntry().path, "1.mp4", "mp4", rubinoSendingPost5.profile_id);
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.SendPostHelper.3
                @Override // java.lang.Runnable
                public void run() {
                    SendPostHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
                }
            });
        }
    }

    private void uploadThumbnailRubino(final int i, final String str, final String str2) {
        Utilities.myQueue.postRunnable(new Runnable() { // from class: ir.appp.messenger.SendPostHelper.4
            @Override // java.lang.Runnable
            public void run() {
                String strCompressImageAndSave = ImageHelper.compressImageAndSave(ImageHelper.loadImage(str, 256.0f, 256.0f, true));
                if (strCompressImageAndSave != null) {
                    FileLoaderInsta.getInstance(((BaseController) SendPostHelper.this).currentAccount).uploadFile(i, strCompressImageAndSave, "1.jpg", "jpg", str2);
                }
            }
        });
    }

    private void uploadSnapshotRubino(int i, String str, String str2) {
        if (str != null) {
            FileLoaderInsta.getInstance(this.currentAccount).uploadFile(i, str, "1.jpg", "jpg", str2);
        }
    }

    public void addPostRubinoPicture(RubinoDraftManager.RubinoSendingPost rubinoSendingPost) {
        final Rubino.AddPostInput addPostInput = new Rubino.AddPostInput(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id);
        addPostInput.caption = rubinoSendingPost.caption;
        addPostInput.file_id = rubinoSendingPost.fileId;
        addPostInput.hash_file_receive = rubinoSendingPost.accessHashRec;
        addPostInput.thumbnail_file_id = rubinoSendingPost.fileIdThumbnail;
        addPostInput.thumbnail_hash_file_receive = rubinoSendingPost.accessHashThumbnail;
        addPostInput.height = rubinoSendingPost.getCurrentSendingEntry().editedInfo.resultHeight + BuildConfig.FLAVOR;
        addPostInput.width = rubinoSendingPost.getCurrentSendingEntry().editedInfo.resultWidth + BuildConfig.FLAVOR;
        addPostInput.post_type = "Picture";
        addPostInput.rnd = rubinoSendingPost.rnd;
        addPostInput.profile_id = rubinoSendingPost.profile_id;
        addPostInput.is_multi_file = rubinoSendingPost.isMulti();
        addPostInput.tagged_profiles = createTagProfiles(rubinoSendingPost);
        this.compositeDisposable.add((Disposable) getApiRequestMessangerRx().rubinoAddPost(addPostInput).subscribeWith(new DisposableObserver<MessangerOutput<Rubino.AddPostOutput>>() { // from class: ir.appp.messenger.SendPostHelper.5
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<Rubino.AddPostOutput> messangerOutput) throws InterruptedException {
                RubinoDraftManager.RubinoSendingPost rubinoSendingPost2 = RubinoDraftManager.getInstance(((BaseController) SendPostHelper.this).currentAccount).sendingPostInfoMap.get(Integer.valueOf(addPostInput.rnd));
                if (rubinoSendingPost2 == null) {
                    return;
                }
                final Rubino.AddPostOutput addPostOutput = messangerOutput.data;
                if (addPostOutput == null || addPostOutput.post == null) {
                    rubinoSendingPost2.hasError = true;
                    SendPostHelper.this.getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
                    return;
                }
                if (!rubinoSendingPost2.isMulti()) {
                    RubinoDraftManager.getInstance(((BaseController) SendPostHelper.this).currentAccount).removeSendingPost(rubinoSendingPost2.rnd);
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.SendPostHelper.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RubinoController rubinoController = SendPostHelper.this.getRubinoController();
                            Rubino.PostObjectFromServer postObjectFromServer = addPostOutput.post;
                            rubinoController.onAddPost(postObjectFromServer, postObjectFromServer.profile_id);
                            SendPostHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
                            SendPostHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaSendPostDone, new Object[0]);
                        }
                    });
                    return;
                }
                rubinoSendingPost2.postId = addPostOutput.post.id;
                rubinoSendingPost2.increaseIndexIfPosible();
                if (rubinoSendingPost2.getCurrentSendingEntry() != null) {
                    rubinoSendingPost2.sendingStatus = RubinoDraftManager.RubinoSendingPost.SendingStatus.initNextUpload;
                } else {
                    rubinoSendingPost2.sendingStatus = RubinoDraftManager.RubinoSendingPost.SendingStatus.publishPost;
                }
                SendPostHelper.this.doNext(rubinoSendingPost2);
                SendPostHelper.this.getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                RubinoDraftManager.RubinoSendingPost rubinoSendingPost2 = RubinoDraftManager.getInstance(((BaseController) SendPostHelper.this).currentAccount).sendingPostInfoMap.get(Integer.valueOf(addPostInput.rnd));
                if (rubinoSendingPost2 != null) {
                    rubinoSendingPost2.hasError = true;
                }
                SendPostHelper.this.getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
            }
        }));
    }

    private ArrayList<Rubino.TagProfileObject> createTagProfiles(RubinoDraftManager.RubinoSendingPost rubinoSendingPost) {
        ArrayList<RGHMediaHelper$PhotoEntry> arrayList;
        if (rubinoSendingPost == null || (arrayList = rubinoSendingPost.entryList) == null || arrayList.isEmpty()) {
            return null;
        }
        ArrayList<Rubino.TagProfileObject> arrayList2 = new ArrayList<>();
        for (int i = 0; i < rubinoSendingPost.entryList.size(); i++) {
            RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry = rubinoSendingPost.entryList.get(i);
            HashMap<PostTagObject, Point> map = rGHMediaHelper$PhotoEntry.tempTaggedProfiles;
            if (map != null) {
                for (PostTagObject postTagObject : map.keySet()) {
                    if (postTagObject != null) {
                        Point point = rGHMediaHelper$PhotoEntry.tempTaggedProfiles.get(postTagObject);
                        Rubino.TagProfileObject tagProfileObject = new Rubino.TagProfileObject();
                        tagProfileObject.file_index = i;
                        tagProfileObject.profile_id = postTagObject.profileObject.id;
                        if (point != null) {
                            int i2 = point.parentWidth;
                            float f = i2 == 0 ? 0.0f : point.x / i2;
                            int i3 = point.parentHeight;
                            tagProfileObject.position = new Rubino.GeneralPosition(f, i3 != 0 ? point.y / i3 : 0.0f);
                        }
                        arrayList2.add(tagProfileObject);
                    }
                }
            }
        }
        return arrayList2;
    }

    public void addPostRubinoVideo(RubinoDraftManager.RubinoSendingPost rubinoSendingPost) {
        final Rubino.AddPostInput addPostInput = new Rubino.AddPostInput(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id);
        addPostInput.caption = rubinoSendingPost.caption;
        addPostInput.file_id = rubinoSendingPost.fileId;
        addPostInput.hash_file_receive = rubinoSendingPost.accessHashRec;
        addPostInput.snapshot_file_id = rubinoSendingPost.fileIdSnapShot;
        addPostInput.snapshot_hash_file_receive = rubinoSendingPost.accessHashRecSnapShot;
        addPostInput.tagged_profiles = createTagProfiles(rubinoSendingPost);
        addPostInput.width = rubinoSendingPost.getCurrentSendingEntry().editedInfo.cropState.transformWidth + BuildConfig.FLAVOR;
        addPostInput.height = rubinoSendingPost.getCurrentSendingEntry().editedInfo.cropState.transformHeight + BuildConfig.FLAVOR;
        addPostInput.post_type = "Video";
        addPostInput.duration = (rubinoSendingPost.getCurrentSendingEntry().editedInfo.estimatedDuration / 1000000) + BuildConfig.FLAVOR;
        addPostInput.thumbnail_file_id = rubinoSendingPost.fileIdThumbnail;
        addPostInput.thumbnail_hash_file_receive = rubinoSendingPost.accessHashThumbnail;
        addPostInput.rnd = rubinoSendingPost.rnd;
        addPostInput.profile_id = rubinoSendingPost.profile_id;
        addPostInput.is_multi_file = rubinoSendingPost.isMulti();
        addPostInput.show_type = rubinoSendingPost.isIGTV() ? Rubino.ShowType.IGTV : null;
        this.compositeDisposable.add((Disposable) getApiRequestMessangerRx().rubinoAddPost(addPostInput).subscribeWith(new DisposableObserver<MessangerOutput<Rubino.AddPostOutput>>() { // from class: ir.appp.messenger.SendPostHelper.6
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<Rubino.AddPostOutput> messangerOutput) throws InterruptedException {
                RubinoDraftManager.RubinoSendingPost rubinoSendingPost2 = RubinoDraftManager.getInstance(((BaseController) SendPostHelper.this).currentAccount).sendingPostInfoMap.get(Integer.valueOf(addPostInput.rnd));
                final Rubino.AddPostOutput addPostOutput = messangerOutput.data;
                if (addPostOutput == null || addPostOutput.post == null) {
                    rubinoSendingPost2.hasError = true;
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.SendPostHelper.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SendPostHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
                        }
                    });
                    return;
                }
                if (!rubinoSendingPost2.isMulti()) {
                    RubinoDraftManager.getInstance(((BaseController) SendPostHelper.this).currentAccount).removeSendingPost(rubinoSendingPost2.rnd);
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.SendPostHelper.6.3
                        @Override // java.lang.Runnable
                        public void run() {
                            RubinoController rubinoController = SendPostHelper.this.getRubinoController();
                            Rubino.PostObjectFromServer postObjectFromServer = addPostOutput.post;
                            rubinoController.onAddPost(postObjectFromServer, postObjectFromServer.profile_id);
                            SendPostHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
                            SendPostHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaSendPostDone, new Object[0]);
                        }
                    });
                    return;
                }
                rubinoSendingPost2.postId = addPostOutput.post.id;
                rubinoSendingPost2.increaseIndexIfPosible();
                if (rubinoSendingPost2.getCurrentSendingEntry() != null) {
                    rubinoSendingPost2.sendingStatus = RubinoDraftManager.RubinoSendingPost.SendingStatus.initNextUpload;
                } else {
                    rubinoSendingPost2.sendingStatus = RubinoDraftManager.RubinoSendingPost.SendingStatus.publishPost;
                }
                SendPostHelper.this.doNext(rubinoSendingPost2);
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.SendPostHelper.6.2
                    @Override // java.lang.Runnable
                    public void run() {
                        SendPostHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
                    }
                });
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                RubinoDraftManager.RubinoSendingPost rubinoSendingPost2 = RubinoDraftManager.getInstance(((BaseController) SendPostHelper.this).currentAccount).sendingPostInfoMap.get(Integer.valueOf(addPostInput.rnd));
                if (rubinoSendingPost2 != null) {
                    rubinoSendingPost2.hasError = true;
                }
                SendPostHelper.this.getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
            }
        }));
    }

    public void addVideoFileToPost(final RubinoDraftManager.RubinoSendingPost rubinoSendingPost) {
        Rubino.AddFilePostInput addFilePostInput = new Rubino.AddFilePostInput(rubinoSendingPost.profile_id);
        addFilePostInput.post_id = rubinoSendingPost.postId;
        addFilePostInput.file_type = Rubino.FileTypeEnum.Video;
        addFilePostInput.file_id = rubinoSendingPost.fileId;
        addFilePostInput.hash_file_receive = rubinoSendingPost.accessHashRec;
        addFilePostInput.snapshot_file_id = rubinoSendingPost.fileIdSnapShot;
        addFilePostInput.snapshot_hash_file_receive = rubinoSendingPost.accessHashRecSnapShot;
        addFilePostInput.profile_id = rubinoSendingPost.profile_id;
        addFilePostInput.duration = (rubinoSendingPost.getCurrentSendingEntry().editedInfo.estimatedDuration / 1000000) + BuildConfig.FLAVOR;
        this.compositeDisposable.add((Disposable) getApiRequestMessangerRx().rubinoAddFilePost(addFilePostInput).subscribeWith(new DisposableObserver<MessangerOutput>() { // from class: ir.appp.messenger.SendPostHelper.7
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput messangerOutput) throws InterruptedException {
                RubinoDraftManager.RubinoSendingPost rubinoSendingPost2 = RubinoDraftManager.getInstance(((BaseController) SendPostHelper.this).currentAccount).sendingPostInfoMap.get(Integer.valueOf(rubinoSendingPost.rnd));
                rubinoSendingPost2.increaseIndexIfPosible();
                if (rubinoSendingPost2.getCurrentSendingEntry() != null) {
                    rubinoSendingPost2.sendingStatus = RubinoDraftManager.RubinoSendingPost.SendingStatus.initNextUpload;
                } else {
                    rubinoSendingPost2.sendingStatus = RubinoDraftManager.RubinoSendingPost.SendingStatus.publishPost;
                }
                SendPostHelper.this.doNext(rubinoSendingPost2);
                SendPostHelper.this.getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                RubinoDraftManager.RubinoSendingPost rubinoSendingPost2 = RubinoDraftManager.getInstance(((BaseController) SendPostHelper.this).currentAccount).sendingPostInfoMap.get(Integer.valueOf(rubinoSendingPost.rnd));
                if (rubinoSendingPost2 != null) {
                    rubinoSendingPost2.hasError = true;
                }
                SendPostHelper.this.getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
            }
        }));
    }

    public void addPictureFileToPost(final RubinoDraftManager.RubinoSendingPost rubinoSendingPost) {
        Rubino.AddFilePostInput addFilePostInput = new Rubino.AddFilePostInput(rubinoSendingPost.profile_id);
        addFilePostInput.post_id = rubinoSendingPost.postId;
        addFilePostInput.file_type = Rubino.FileTypeEnum.Picture;
        addFilePostInput.file_id = rubinoSendingPost.fileId;
        addFilePostInput.hash_file_receive = rubinoSendingPost.accessHashRec;
        addFilePostInput.profile_id = rubinoSendingPost.profile_id;
        this.compositeDisposable.add((Disposable) getApiRequestMessangerRx().rubinoAddFilePost(addFilePostInput).subscribeWith(new DisposableObserver<MessangerOutput>() { // from class: ir.appp.messenger.SendPostHelper.8
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput messangerOutput) throws InterruptedException {
                RubinoDraftManager.RubinoSendingPost rubinoSendingPost2 = RubinoDraftManager.getInstance(((BaseController) SendPostHelper.this).currentAccount).sendingPostInfoMap.get(Integer.valueOf(rubinoSendingPost.rnd));
                rubinoSendingPost2.increaseIndexIfPosible();
                if (rubinoSendingPost2.getCurrentSendingEntry() != null) {
                    rubinoSendingPost2.sendingStatus = RubinoDraftManager.RubinoSendingPost.SendingStatus.initNextUpload;
                    SendPostHelper.this.doNext(rubinoSendingPost2);
                } else {
                    rubinoSendingPost2.sendingStatus = RubinoDraftManager.RubinoSendingPost.SendingStatus.publishPost;
                    SendPostHelper.this.doNext(rubinoSendingPost2);
                }
                SendPostHelper.this.getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                RubinoDraftManager.RubinoSendingPost rubinoSendingPost2 = RubinoDraftManager.getInstance(((BaseController) SendPostHelper.this).currentAccount).sendingPostInfoMap.get(Integer.valueOf(rubinoSendingPost.rnd));
                if (rubinoSendingPost2 != null) {
                    rubinoSendingPost2.hasError = true;
                }
                SendPostHelper.this.getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
            }
        }));
    }

    public void cancelSendPostRubino(int i) {
        RubinoDraftManager.RubinoSendingPost rubinoSendingPost = RubinoDraftManager.getInstance(this.currentAccount).sendingPostInfoMap.get(Integer.valueOf(i));
        if (rubinoSendingPost != null) {
            cancelSendPostRubino(rubinoSendingPost);
        }
    }

    public void cancelSendPostRubino(RubinoDraftManager.RubinoSendingPost rubinoSendingPost) {
        if (rubinoSendingPost != null) {
            int i = rubinoSendingPost.rnd;
            RubinoDraftManager.RubinoSendingPost.SendingStatus sendingStatus = rubinoSendingPost.sendingStatus;
            if (sendingStatus == RubinoDraftManager.RubinoSendingPost.SendingStatus.converting) {
                MediaController.getInstance().cancelVideoConvert(i);
            } else if (sendingStatus == RubinoDraftManager.RubinoSendingPost.SendingStatus.uploadingFile) {
                FileLoaderInsta.getInstance(this.currentAccount).cancelUploadFile(i);
            }
            RubinoDraftManager.getInstance(this.currentAccount).removeSendingPost(i);
            getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
        }
    }

    public void retrySendPostRubino(int i) throws InterruptedException {
        RubinoDraftManager.RubinoSendingPost rubinoSendingPost = RubinoDraftManager.getInstance(this.currentAccount).sendingPostInfoMap.get(Integer.valueOf(i));
        if (rubinoSendingPost != null) {
            rubinoSendingPost.hasError = false;
            doNext(rubinoSendingPost);
        }
        getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
    }

    public void publishPost(final RubinoDraftManager.RubinoSendingPost rubinoSendingPost) {
        Rubino.PublishPostInput publishPostInput = new Rubino.PublishPostInput(rubinoSendingPost.profile_id);
        publishPostInput.post_id = rubinoSendingPost.postId;
        this.compositeDisposable.add((Disposable) getApiRequestMessangerRx().rubinoPublishPost(publishPostInput).subscribeWith(new DisposableObserver<MessangerOutput<Rubino.AddPostOutput>>() { // from class: ir.appp.messenger.SendPostHelper.9
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(final MessangerOutput<Rubino.AddPostOutput> messangerOutput) {
                final RubinoDraftManager.RubinoSendingPost rubinoSendingPost2 = RubinoDraftManager.getInstance(((BaseController) SendPostHelper.this).currentAccount).sendingPostInfoMap.get(Integer.valueOf(rubinoSendingPost.rnd));
                if (rubinoSendingPost2 != null) {
                    RubinoDraftManager.getInstance(((BaseController) SendPostHelper.this).currentAccount).removeSendingPost(rubinoSendingPost2.rnd);
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.messenger.SendPostHelper.9.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        SendPostHelper.this.getRubinoController().onAddPost(((Rubino.AddPostOutput) messangerOutput.data).post, rubinoSendingPost2.profile_id);
                        SendPostHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
                        SendPostHelper.this.getNotificationCenter().postNotificationName(NotificationCenter.myInstaSendPostDone, new Object[0]);
                    }
                });
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                RubinoDraftManager.RubinoSendingPost rubinoSendingPost2 = RubinoDraftManager.getInstance(((BaseController) SendPostHelper.this).currentAccount).sendingPostInfoMap.get(Integer.valueOf(rubinoSendingPost.rnd));
                if (rubinoSendingPost2 != null) {
                    rubinoSendingPost2.hasError = true;
                }
                SendPostHelper.this.getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
            }
        }));
    }

    public void doNext(RubinoDraftManager.RubinoSendingPost rubinoSendingPost) throws InterruptedException {
        if (rubinoSendingPost != null) {
            if (rubinoSendingPost.sendingStatus == RubinoDraftManager.RubinoSendingPost.SendingStatus.publishPost) {
                publishPost(rubinoSendingPost);
                return;
            }
            if (rubinoSendingPost.getCurrentSendingEntry().isVideo) {
                RubinoDraftManager.RubinoSendingPost.SendingStatus sendingStatus = rubinoSendingPost.sendingStatus;
                if (sendingStatus == RubinoDraftManager.RubinoSendingPost.SendingStatus.initNextUpload) {
                    rubinoSendingPost.sendingStatus = RubinoDraftManager.RubinoSendingPost.SendingStatus.converting;
                    doNext(rubinoSendingPost);
                    return;
                }
                if (sendingStatus == RubinoDraftManager.RubinoSendingPost.SendingStatus.converting) {
                    MediaController.SSHMediaConvertRequest sSHMediaConvertRequest = new MediaController.SSHMediaConvertRequest(this.currentAccount, r8.imageId, new File(Utils.getVideoOutputFilePath()), new File(Utils.getImageOutputFilePath()), rubinoSendingPost.getCurrentSendingEntry());
                    sSHMediaConvertRequest.postRnd = rubinoSendingPost.rnd;
                    rubinoSendingPost.mediaConvertRequest = sSHMediaConvertRequest;
                    if (ApplicationLoader.applicationActivity != null) {
                        MediaController.getInstance().scheduleMediaConvert(ApplicationLoader.applicationActivity, sSHMediaConvertRequest);
                        return;
                    }
                    return;
                }
                if (sendingStatus == RubinoDraftManager.RubinoSendingPost.SendingStatus.uploadingFile) {
                    FileLoaderInsta.getInstance(this.currentAccount).uploadFile(rubinoSendingPost.rnd, rubinoSendingPost.getCurrentSendingEntry().path, "1.mp4", "mp4", rubinoSendingPost.profile_id);
                    return;
                }
                if (sendingStatus == RubinoDraftManager.RubinoSendingPost.SendingStatus.uploadingSnapShot) {
                    uploadSnapshotRubino(rubinoSendingPost.rnd, rubinoSendingPost.mediaConvertRequest.coverFile.getAbsolutePath(), rubinoSendingPost.profile_id);
                    return;
                }
                if (sendingStatus == RubinoDraftManager.RubinoSendingPost.SendingStatus.uploadingThumbnail) {
                    uploadThumbnailRubino(rubinoSendingPost.rnd, rubinoSendingPost.mediaConvertRequest.coverFile.getAbsolutePath(), rubinoSendingPost.profile_id);
                    return;
                } else if (sendingStatus == RubinoDraftManager.RubinoSendingPost.SendingStatus.sendingPost) {
                    addPostRubinoVideo(rubinoSendingPost);
                    return;
                } else {
                    if (sendingStatus == RubinoDraftManager.RubinoSendingPost.SendingStatus.addFileToPost) {
                        addVideoFileToPost(rubinoSendingPost);
                        return;
                    }
                    return;
                }
            }
            RubinoDraftManager.RubinoSendingPost.SendingStatus sendingStatus2 = rubinoSendingPost.sendingStatus;
            if (sendingStatus2 == RubinoDraftManager.RubinoSendingPost.SendingStatus.initNextUpload) {
                rubinoSendingPost.sendingStatus = RubinoDraftManager.RubinoSendingPost.SendingStatus.converting;
                doNext(rubinoSendingPost);
                return;
            }
            if (sendingStatus2 == RubinoDraftManager.RubinoSendingPost.SendingStatus.converting) {
                MediaController.SSHMediaConvertRequest sSHMediaConvertRequest2 = new MediaController.SSHMediaConvertRequest(this.currentAccount, r8.imageId, new File(Utils.getImageOutputFilePath()), null, rubinoSendingPost.getCurrentSendingEntry());
                sSHMediaConvertRequest2.postRnd = rubinoSendingPost.rnd;
                rubinoSendingPost.mediaConvertRequest = sSHMediaConvertRequest2;
                if (ApplicationLoader.applicationActivity != null) {
                    MediaController.getInstance().scheduleMediaConvert(ApplicationLoader.applicationActivity, sSHMediaConvertRequest2);
                    return;
                }
                return;
            }
            if (sendingStatus2 == RubinoDraftManager.RubinoSendingPost.SendingStatus.uploadingFile) {
                FileLoaderInsta.getInstance(this.currentAccount).uploadFile(rubinoSendingPost.rnd, rubinoSendingPost.getCurrentSendingEntry().path, "1.jpg", "jpg", rubinoSendingPost.profile_id);
                return;
            }
            if (sendingStatus2 == RubinoDraftManager.RubinoSendingPost.SendingStatus.uploadingThumbnail) {
                uploadThumbnailRubino(rubinoSendingPost.rnd, rubinoSendingPost.getCurrentSendingEntry().path, rubinoSendingPost.profile_id);
            } else if (sendingStatus2 == RubinoDraftManager.RubinoSendingPost.SendingStatus.sendingPost) {
                addPostRubinoPicture(rubinoSendingPost);
            } else if (sendingStatus2 == RubinoDraftManager.RubinoSendingPost.SendingStatus.addFileToPost) {
                addPictureFileToPost(rubinoSendingPost);
            }
        }
    }

    public void clear() {
        HashMap map = new HashMap(RubinoDraftManager.getInstance(this.currentAccount).sendingPostInfoMap);
        RubinoDraftManager.getInstance(this.currentAccount).clear();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            cancelSendPostRubino((RubinoDraftManager.RubinoSendingPost) map.get(Integer.valueOf(((Integer) it.next()).intValue())));
        }
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
        this.compositeDisposable = new CompositeDisposable();
    }
}
