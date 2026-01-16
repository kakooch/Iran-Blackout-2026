package ir.resaneh1.iptv.helper;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.os.Build;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import ir.appp.rghapp.FilterHelper;
import ir.appp.rghapp.RGHFilter;
import ir.appp.rghapp.Utils;
import ir.resaneh1.iptv.helper.StoryController;
import ir.resaneh1.iptv.insta.FileLoaderStory;
import ir.resaneh1.iptv.insta.FileUploadOperationStory;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.AddStoryInput;
import ir.resaneh1.iptv.model.AddStoryOutput;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import ir.resaneh1.iptv.model.StoryObject;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.BaseController;
import org.rbmain.messenger.Bitmaps;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.MediaController;
import org.rbmain.messenger.NotificationCenter;

/* loaded from: classes3.dex */
public class SendStoryHelper extends BaseController implements NotificationCenter.NotificationCenterDelegate {
    private static volatile SendStoryHelper[] Instance = new SendStoryHelper[3];
    private LinkedList<StoryObject> commandQueue;
    private CompositeDisposable compositeDisposable;
    private int currentCommandInProgressCount;
    private FilterHelper filterHelper;
    private ArrayList<StoryObject> localStories;

    static /* synthetic */ int access$1410(SendStoryHelper sendStoryHelper) {
        int i = sendStoryHelper.currentCommandInProgressCount;
        sendStoryHelper.currentCommandInProgressCount = i - 1;
        return i;
    }

    public static SendStoryHelper getInstance(int i) {
        SendStoryHelper sendStoryHelper = Instance[i];
        if (sendStoryHelper == null) {
            synchronized (SendStoryHelper.class) {
                sendStoryHelper = Instance[i];
                if (sendStoryHelper == null) {
                    SendStoryHelper[] sendStoryHelperArr = Instance;
                    SendStoryHelper sendStoryHelper2 = new SendStoryHelper(i);
                    sendStoryHelperArr[i] = sendStoryHelper2;
                    sendStoryHelper = sendStoryHelper2;
                }
            }
        }
        return sendStoryHelper;
    }

    public ArrayList<StoryObject> getLocalStories() {
        if (this.localStories == null) {
            this.localStories = new ArrayList<>();
        }
        return this.localStories;
    }

    SendStoryHelper(int i) {
        super(i);
        this.currentCommandInProgressCount = 0;
        this.commandQueue = new LinkedList<>();
        this.compositeDisposable = new CompositeDisposable();
    }

    private void addLocalStory(StoryObject storyObject) {
        if (this.localStories == null) {
            this.localStories = new ArrayList<>();
        }
        this.localStories.add(storyObject);
        getStoryController().addToProfileStoryStatusMap(storyObject.localProfileId, StoryController.ProfileStoryStatusEnum.SeenStory);
        getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.sendingStoryStatusChanges, new Object[0]);
    }

    public void retrySendStory(int i) {
        StoryObject localStory = getLocalStory(i);
        if (localStory != null) {
            localStory.isFailed = false;
            doOrPutInQueueSendStory(localStory);
            getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.storySendFailedOrRetry, Integer.valueOf(i));
            getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.sendingStoryStatusChanges, new Object[0]);
        }
    }

    public void doOrPutInQueueSendStory(StoryObject storyObject) {
        if (storyObject == null) {
            return;
        }
        if (getLocalStory(storyObject.rnd) == null) {
            addLocalStory(storyObject);
        }
        getStoryController().checkIsMyFirstStoryAndNotify();
        MyLog.e("SendStoryHelper", " currentCommandInProgressCount " + this.currentCommandInProgressCount + " " + storyObject.rnd);
        if (this.currentCommandInProgressCount < 1) {
            if (storyObject.isLocal) {
                StoryObject.SendingStateEnum sendingStateEnum = storyObject.sendingState;
                StoryObject.SendingStateEnum sendingStateEnum2 = StoryObject.SendingStateEnum.init;
                if (sendingStateEnum == sendingStateEnum2) {
                    MyLog.e("SendStoryHelper", "saving " + storyObject.rnd);
                    this.currentCommandInProgressCount = this.currentCommandInProgressCount + 1;
                    storyObject.sendingState = StoryObject.SendingStateEnum.saving;
                    saveVideoAndImage(storyObject);
                    return;
                }
                if (sendingStateEnum == StoryObject.SendingStateEnum.saving) {
                    saveVideoAndImage(storyObject);
                    return;
                }
                if (sendingStateEnum == StoryObject.SendingStateEnum.uploadingMainFile) {
                    uploadStory(storyObject);
                    return;
                }
                if (sendingStateEnum == StoryObject.SendingStateEnum.uploadThumbnail) {
                    StoryObject.StoryTypeEnum storyTypeEnum = storyObject.story_type;
                    if (storyTypeEnum == StoryObject.StoryTypeEnum.Video) {
                        createAndUploadThumbAndSnapshotVideo(storyObject, false);
                        return;
                    } else {
                        if (storyTypeEnum == StoryObject.StoryTypeEnum.Picture) {
                            uploadThumbImage(storyObject);
                            return;
                        }
                        return;
                    }
                }
                if (sendingStateEnum == StoryObject.SendingStateEnum.uploadSnapShot) {
                    if (storyObject.story_type == StoryObject.StoryTypeEnum.Video) {
                        createAndUploadThumbAndSnapshotVideo(storyObject, true);
                        return;
                    } else {
                        storyObject.sendingState = sendingStateEnum2;
                        onFailed(storyObject.rnd);
                        return;
                    }
                }
                if (sendingStateEnum == StoryObject.SendingStateEnum.addStoryInProgress) {
                    callAddStory(storyObject);
                    return;
                }
                return;
            }
            return;
        }
        this.commandQueue.add(storyObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendStoryFromQueue() {
        StoryObject storyObjectPoll;
        if (this.currentCommandInProgressCount >= 1 || (storyObjectPoll = this.commandQueue.poll()) == null) {
            return;
        }
        doOrPutInQueueSendStory(storyObjectPoll);
    }

    public void clear() {
        try {
            ArrayList<StoryObject> arrayList = this.localStories;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.localStories);
                this.localStories.clear();
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    cancelSendLocalStory((StoryObject) it.next());
                }
            }
            LinkedList<StoryObject> linkedList = this.commandQueue;
            if (linkedList != null) {
                linkedList.clear();
            }
            this.currentCommandInProgressCount = 0;
            this.compositeDisposable.dispose();
            this.compositeDisposable = new CompositeDisposable();
        } catch (Exception unused) {
        }
    }

    private void saveVideoAndImage(final StoryObject storyObject) {
        this.filterHelper = new FilterHelper(new FilterHelper.FilterProcessListener() { // from class: ir.resaneh1.iptv.helper.SendStoryHelper.1
            @Override // ir.appp.rghapp.FilterHelper.FilterProcessListener
            public void onFilterOperationEstimatedOutputSize(int i) {
            }

            @Override // ir.appp.rghapp.FilterHelper.FilterProcessListener
            public void onFilterProgressChanged(int i, double d, int i2) {
                MyLog.e("SendStoryHelper", "onFilterProgressChanged " + d);
                storyObject.saveProgress = d;
                SendStoryHelper.this.getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.storySendProgressChange, Integer.valueOf(storyObject.rnd));
            }

            @Override // ir.appp.rghapp.FilterHelper.FilterProcessListener
            public void onFilterOperationCanceled(int i) {
                SendStoryHelper.this.getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.storySendProgressCanceled, Integer.valueOf(storyObject.rnd));
                MyLog.e("SendStoryHelper", "onFilterOperationCanceled " + i);
                SendStoryHelper.this.onFailed(storyObject.rnd);
            }

            @Override // ir.appp.rghapp.FilterHelper.FilterProcessListener
            public void onFilterOperationCompleted(int i, String str) {
                SendStoryHelper.this.getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.storySendProgressCompleted, Integer.valueOf(storyObject.rnd));
                MyLog.e("SendStoryHelper", "onFilterOperationCompleted " + i);
                if (AppRubinoPreferences.getInstance(((BaseController) SendStoryHelper.this).currentAccount).getProfileSettingObject() != null && AppRubinoPreferences.getInstance(((BaseController) SendStoryHelper.this).currentAccount).getProfileSettingObject().story_save_to_gallery) {
                    try {
                        if (ApplicationLoader.applicationActivity != null && (Build.VERSION.SDK_INT < 23 || ApplicationLoader.applicationActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)) {
                            String name = new File(storyObject.localFilePathAfterSave).getName();
                            StoryObject storyObject2 = storyObject;
                            StoryObject.StoryTypeEnum storyTypeEnum = storyObject2.story_type;
                            StoryObject.StoryTypeEnum storyTypeEnum2 = StoryObject.StoryTypeEnum.Picture;
                            MediaController.saveFile(storyObject2.localFilePathAfterSave, ApplicationLoader.applicationActivity, storyTypeEnum == storyTypeEnum2 ? 0 : 1, name, storyTypeEnum == storyTypeEnum2 ? "jpg" : "mp4", null);
                        }
                    } catch (Exception unused) {
                    }
                }
                SendStoryHelper.this.uploadStory(storyObject);
            }

            @Override // ir.appp.rghapp.FilterHelper.FilterProcessListener
            public void onFilterOperationFailed(int i, String str, String str2) {
                MyLog.e("SendStoryHelper", str + "--RGH--" + str2);
                CrashHandelHelper.handleCrashOnStroy(str, str2);
                SendStoryHelper.this.onFailed(storyObject.rnd);
            }
        });
        if (storyObject.story_type == StoryObject.StoryTypeEnum.Video) {
            storyObject.localFilePathAfterSave = Utils.getVideoOutputFilePath();
        } else {
            storyObject.localFilePathAfterSave = Utils.getImageOutputFilePath2();
        }
        this.compositeDisposable.add((Disposable) Observable.timer(100L, TimeUnit.MILLISECONDS).observeOn(Schedulers.io()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.helper.SendStoryHelper.2
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(Long l) {
                if (!Utils.useNewStoryCreationSystem()) {
                    FilterHelper filterHelper = SendStoryHelper.this.filterHelper;
                    StoryObject storyObject2 = storyObject;
                    int i = storyObject2.rnd;
                    RGHFilter rGHFilter = storyObject2.rghFilterToSave;
                    String backgroundFilePath = storyObject2.glSceneState.getBackgroundFilePath();
                    StoryObject storyObject3 = storyObject;
                    filterHelper.applyFilterOnMedia(i, rGHFilter, backgroundFilePath, storyObject3.localFilePathBeforeSave, storyObject3.localFilePathAfterSave);
                    return;
                }
                SendStoryHelper.this.filterHelper.applyFilterOnMedia(storyObject);
            }
        }));
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        Integer num;
        StoryObject localStory;
        if (i == NotificationCenter.storyFileUploadProgress) {
            MyLog.e("SendStoryHelper", "storyFileUploadProgress");
            FileUploadOperationStory fileUploadOperationStory = (FileUploadOperationStory) objArr[0];
            if (fileUploadOperationStory != null) {
                StoryObject localStory2 = getLocalStory(fileUploadOperationStory.getRnd());
                float fFloatValue = ((Float) objArr[1]).floatValue();
                if (localStory2 != null && localStory2.sendingState == StoryObject.SendingStateEnum.uploadingMainFile) {
                    localStory2.sendProgressMain = fFloatValue;
                } else if (localStory2 != null && localStory2.sendingState == StoryObject.SendingStateEnum.uploadThumbnail) {
                    localStory2.sendProgressThumbnail = fFloatValue;
                } else if (localStory2 != null && localStory2.sendingState == StoryObject.SendingStateEnum.uploadSnapShot) {
                    localStory2.sendProgressSnapshot = fFloatValue;
                }
                MyLog.e("SendStoryHelper", "storyFileUploadProgress " + fFloatValue);
                if (localStory2 != null) {
                    getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.storySendProgressChange, Integer.valueOf(localStory2.rnd));
                    return;
                }
                return;
            }
            return;
        }
        if (i == NotificationCenter.storyFileUploadDone) {
            MyLog.e("SendStoryHelper", "storyFileUploadDone");
            FileUploadOperationStory fileUploadOperationStory2 = (FileUploadOperationStory) objArr[0];
            if (fileUploadOperationStory2 == null || (localStory = getLocalStory(fileUploadOperationStory2.getRnd())) == null) {
                return;
            }
            MyLog.e("SendStoryHelper", "storyFileUploadDone " + localStory.sendingState + " " + localStory.rnd);
            StoryObject.SendingStateEnum sendingStateEnum = localStory.sendingState;
            if (sendingStateEnum == StoryObject.SendingStateEnum.uploadingMainFile) {
                localStory.fileId = fileUploadOperationStory2.file_id;
                localStory.hashFileReceive = fileUploadOperationStory2.access_hash_rec;
                StoryObject.StoryTypeEnum storyTypeEnum = localStory.story_type;
                if (storyTypeEnum == StoryObject.StoryTypeEnum.Video) {
                    localStory.sendingState = StoryObject.SendingStateEnum.uploadThumbnail;
                    createAndUploadThumbAndSnapshotVideo(localStory, false);
                    getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.storySendProgressChange, Integer.valueOf(localStory.rnd));
                    return;
                } else {
                    if (storyTypeEnum == StoryObject.StoryTypeEnum.Picture) {
                        localStory.sendingState = StoryObject.SendingStateEnum.uploadThumbnail;
                        uploadThumbImage(localStory);
                        getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.storySendProgressChange, Integer.valueOf(localStory.rnd));
                        return;
                    }
                    onFailed(localStory.rnd);
                    return;
                }
            }
            if (sendingStateEnum == StoryObject.SendingStateEnum.uploadThumbnail) {
                localStory.thuFileId = fileUploadOperationStory2.file_id;
                localStory.thuHashFileReceive = fileUploadOperationStory2.access_hash_rec;
                StoryObject.StoryTypeEnum storyTypeEnum2 = localStory.story_type;
                if (storyTypeEnum2 == StoryObject.StoryTypeEnum.Video) {
                    localStory.sendingState = StoryObject.SendingStateEnum.uploadSnapShot;
                    createAndUploadThumbAndSnapshotVideo(localStory, true);
                    getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.storySendProgressChange, Integer.valueOf(localStory.rnd));
                    return;
                } else {
                    if (storyTypeEnum2 == StoryObject.StoryTypeEnum.Picture) {
                        localStory.sendingState = StoryObject.SendingStateEnum.addStoryInProgress;
                        callAddStory(localStory);
                        getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.storySendProgressChange, Integer.valueOf(localStory.rnd));
                        return;
                    }
                    onFailed(localStory.rnd);
                    return;
                }
            }
            if (sendingStateEnum == StoryObject.SendingStateEnum.uploadSnapShot) {
                localStory.snapshotFileId = fileUploadOperationStory2.file_id;
                localStory.snapshotHashFileReceive = fileUploadOperationStory2.access_hash_rec;
                localStory.sendingState = StoryObject.SendingStateEnum.addStoryInProgress;
                getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.storySendProgressChange, Integer.valueOf(localStory.rnd));
                callAddStory(localStory);
                return;
            }
            return;
        }
        if (i != NotificationCenter.storyFileUploadFaild || (num = (Integer) objArr[0]) == null || num.intValue() == 0) {
            return;
        }
        onFailed(num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFailed(int i) {
        StoryObject localStory = getLocalStory(i);
        if (localStory != null) {
            localStory.isFailed = true;
        }
        int i2 = this.currentCommandInProgressCount - 1;
        this.currentCommandInProgressCount = i2;
        if (i2 < 0) {
            this.currentCommandInProgressCount = 0;
        }
        sendStoryFromQueue();
        getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.storySendFailedOrRetry, Integer.valueOf(i));
        getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.sendingStoryStatusChanges, Integer.valueOf(i));
    }

    private void uploadThumbImage(StoryObject storyObject) {
        String strCompressImageAndSave = ImageHelper.compressImageAndSave(ImageHelper.loadImage(storyObject.localFilePathAfterSave, 350.0f, 350.0f, false));
        if (strCompressImageAndSave != null) {
            storyObject.sendingState = StoryObject.SendingStateEnum.uploadThumbnail;
            uploadThumbOrSnapShot(storyObject, strCompressImageAndSave);
        }
    }

    private void createAndUploadThumbAndSnapshotVideo(final StoryObject storyObject, final boolean z) {
        final int i = z ? MediaController.MAX_WIDTH_HEIGHT_SIZE : 350;
        new AsyncTask<Integer, Integer, String>() { // from class: ir.resaneh1.iptv.helper.SendStoryHelper.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public String doInBackground(Integer... numArr) throws IllegalArgumentException {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                if (isCancelled()) {
                    return null;
                }
                try {
                    mediaMetadataRetriever.setDataSource(storyObject.localFilePathAfterSave);
                    Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L, 1);
                    if (isCancelled()) {
                        return null;
                    }
                    if (frameAtTime == null) {
                        return BuildConfig.FLAVOR;
                    }
                    int width = frameAtTime.getWidth();
                    int height = frameAtTime.getHeight();
                    int iMax = Math.max(width, height);
                    int i2 = i;
                    if (iMax > i2) {
                        float f = (i2 * 1.0f) / iMax;
                        frameAtTime = Bitmaps.createScaledBitmap(frameAtTime, Math.round(width * f), Math.round(f * height), true);
                    }
                    return ImageHelper.compressImageAndSave(frameAtTime);
                } catch (Exception e) {
                    FileLog.e(e);
                    return BuildConfig.FLAVOR;
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(String str) {
                if (str != null) {
                    if (z) {
                        storyObject.sendingState = StoryObject.SendingStateEnum.uploadSnapShot;
                    } else {
                        storyObject.sendingState = StoryObject.SendingStateEnum.uploadThumbnail;
                    }
                    SendStoryHelper.this.uploadThumbOrSnapShot(storyObject, str);
                }
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadThumbOrSnapShot(final StoryObject storyObject, final String str) {
        if (str != null) {
            File file = new File(str);
            final String name = file.getName();
            final long length = file.length();
            CompositeDisposable compositeDisposable = this.compositeDisposable;
            if (compositeDisposable != null) {
                compositeDisposable.add((Disposable) Observable.just(1).delay(100L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Integer>() { // from class: ir.resaneh1.iptv.helper.SendStoryHelper.4
                    @Override // io.reactivex.Observer
                    public void onComplete() {
                    }

                    @Override // io.reactivex.Observer
                    public void onError(Throwable th) {
                    }

                    @Override // io.reactivex.Observer
                    public void onNext(Integer num) {
                        SendStoryHelper.this.getNotificationCenter().addObserver(SendStoryHelper.this, NotificationCenter.storyFileUploadDone);
                        SendStoryHelper.this.getNotificationCenter().addObserver(SendStoryHelper.this, NotificationCenter.storyFileUploadProgress);
                        SendStoryHelper.this.getNotificationCenter().addObserver(SendStoryHelper.this, NotificationCenter.storyFileUploadFaild);
                        FileLoaderStory fileLoaderStory = FileLoaderStory.getInstance(((BaseController) SendStoryHelper.this).currentAccount);
                        StoryObject storyObject2 = storyObject;
                        fileLoaderStory.uploadSnapshotOrThumbnail(storyObject2.rnd, str, name, length, storyObject2.localProfileId, false);
                    }
                }));
                return;
            }
            return;
        }
        onFailed(storyObject.rnd);
    }

    private void callAddStory(final StoryObject storyObject) {
        MyLog.e("SendStoryHelper", "callAddStory " + storyObject.rnd);
        storyObject.sendingState = StoryObject.SendingStateEnum.addStoryInProgress;
        AddStoryInput addStoryInputCreateFromStory = AddStoryInput.createFromStory(storyObject);
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        if (compositeDisposable != null) {
            compositeDisposable.add((Disposable) getApiRequestMessangerRx().addStory(addStoryInputCreateFromStory).observeOn(Schedulers.computation()).subscribeWith(new DisposableObserver<MessangerOutput<AddStoryOutput>>() { // from class: ir.resaneh1.iptv.helper.SendStoryHelper.5
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onNext(MessangerOutput<AddStoryOutput> messangerOutput) {
                    AddStoryOutput addStoryOutput;
                    if (messangerOutput != null && (addStoryOutput = messangerOutput.data) != null && addStoryOutput.story != null) {
                        SendStoryHelper.this.removeLocalStory(storyObject.rnd);
                        SendStoryHelper.this.getStoryController().onAddNewStoryResponse(messangerOutput.data.story);
                    }
                    SendStoryHelper.access$1410(SendStoryHelper.this);
                    if (SendStoryHelper.this.currentCommandInProgressCount < 0) {
                        SendStoryHelper.this.currentCommandInProgressCount = 0;
                    }
                    SendStoryHelper.this.sendStoryFromQueue();
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    SendStoryHelper.this.onFailed(storyObject.rnd);
                }
            }));
            return;
        }
        int i = this.currentCommandInProgressCount - 1;
        this.currentCommandInProgressCount = i;
        if (i < 0) {
            this.currentCommandInProgressCount = 0;
        }
        sendStoryFromQueue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadStory(final StoryObject storyObject) {
        storyObject.sendingState = StoryObject.SendingStateEnum.uploadingMainFile;
        File file = new File(storyObject.localFilePathAfterSave);
        final String name = file.getName();
        final long length = file.length();
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        if (compositeDisposable != null) {
            compositeDisposable.add((Disposable) Observable.just(1).delay(100L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Integer>() { // from class: ir.resaneh1.iptv.helper.SendStoryHelper.6
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                }

                @Override // io.reactivex.Observer
                public void onNext(Integer num) {
                    SendStoryHelper.this.getNotificationCenter().addObserver(SendStoryHelper.this, NotificationCenter.storyFileUploadDone);
                    SendStoryHelper.this.getNotificationCenter().addObserver(SendStoryHelper.this, NotificationCenter.storyFileUploadProgress);
                    SendStoryHelper.this.getNotificationCenter().addObserver(SendStoryHelper.this, NotificationCenter.storyFileUploadFaild);
                    FileLoaderStory fileLoaderStory = FileLoaderStory.getInstance(((BaseController) SendStoryHelper.this).currentAccount);
                    StoryObject storyObject2 = storyObject;
                    fileLoaderStory.uploadStory(storyObject2.rnd, storyObject2.localFilePathAfterSave, name, length, storyObject2.story_type, storyObject2.localProfileId, false);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeLocalStory(int i) {
        ArrayList<StoryController.StoryIdObject> arrayList;
        ArrayList<StoryObject> arrayList2 = this.localStories;
        if (arrayList2 == null) {
            return;
        }
        Iterator<StoryObject> it = arrayList2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            StoryObject next = it.next();
            if (next.rnd == i) {
                this.localStories.remove(next);
                break;
            }
        }
        RubinoProfileObject rubinoCurrentProfileObject = AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject();
        StoryController.ProfileStoryInfo instantProfileStoryIdsWithLocal = getStoryController().getInstantProfileStoryIdsWithLocal(rubinoCurrentProfileObject, null, false);
        if (instantProfileStoryIdsWithLocal != null && (arrayList = instantProfileStoryIdsWithLocal.storyIdsObject) != null && arrayList.size() > 0) {
            getStoryController().addToProfileStoryStatusMap(rubinoCurrentProfileObject.id, StoryController.ProfileStoryStatusEnum.SeenStory);
        } else {
            getStoryController().addToProfileStoryStatusMap(rubinoCurrentProfileObject.id, StoryController.ProfileStoryStatusEnum.NoStory);
        }
        getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.sendingStoryStatusChanges, new Object[0]);
    }

    private void removeFromQueue(int i) {
        LinkedList<StoryObject> linkedList = this.commandQueue;
        if (linkedList == null) {
            return;
        }
        Iterator<StoryObject> it = linkedList.iterator();
        while (it.hasNext()) {
            StoryObject next = it.next();
            if (next.rnd == i) {
                this.commandQueue.remove(next);
                return;
            }
        }
    }

    public StoryObject getLocalStory(int i) {
        ArrayList<StoryObject> arrayList = this.localStories;
        if (arrayList == null) {
            return null;
        }
        Iterator<StoryObject> it = arrayList.iterator();
        while (it.hasNext()) {
            StoryObject next = it.next();
            if (next.rnd == i) {
                return next;
            }
        }
        return null;
    }

    public void cancelSendLocalStory(StoryObject storyObject) {
        if (storyObject != null && storyObject.isLocal) {
            MyLog.e("SendStoryHelper", "delete " + storyObject.sendingState + " " + storyObject.rnd);
            removeLocalStory(storyObject.rnd);
            getNotificationCenter().postNotificationNameOnUIThread(NotificationCenter.myStoryDeleted, storyObject);
            if (storyObject.isFailed) {
                return;
            }
            MyLog.e("SendStoryHelper", "delete  !isFailed");
            StoryObject.SendingStateEnum sendingStateEnum = storyObject.sendingState;
            if (sendingStateEnum == StoryObject.SendingStateEnum.init) {
                removeFromQueue(storyObject.rnd);
                return;
            }
            if (sendingStateEnum == StoryObject.SendingStateEnum.saving) {
                MyLog.e("SendStoryHelper", "delete  saving");
                if (this.filterHelper != null) {
                    MyLog.e("SendStoryHelper", "delete cancel filter");
                    this.filterHelper.cancelFilteringProcess();
                    removeFromQueue(storyObject.rnd);
                    return;
                }
                onFailed(storyObject.rnd);
                return;
            }
            if (sendingStateEnum == StoryObject.SendingStateEnum.uploadingMainFile || sendingStateEnum == StoryObject.SendingStateEnum.uploadSnapShot || sendingStateEnum == StoryObject.SendingStateEnum.uploadThumbnail) {
                MyLog.e("SendStoryHelper", "delete cancel upload ");
                if (FileLoaderStory.getInstance(this.currentAccount).isUploading(storyObject.rnd)) {
                    FileLoaderStory.getInstance(this.currentAccount).cancelUploadFile(storyObject.rnd);
                    removeFromQueue(storyObject.rnd);
                    return;
                } else {
                    onFailed(storyObject.rnd);
                    return;
                }
            }
            if (sendingStateEnum == StoryObject.SendingStateEnum.addStoryInProgress) {
                removeFromQueue(storyObject.rnd);
            }
        }
    }
}
