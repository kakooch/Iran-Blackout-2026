package ir.resaneh1.iptv.fragment.rubino.highlight;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.core.content.FileProvider;
import com.facebook.stetho.websocket.CloseCodes;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import ir.appp.rghapp.RGHMediaHelper$PhotoEntry;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx;
import ir.resaneh1.iptv.fragment.rubino.RubinoController;
import ir.resaneh1.iptv.helper.ImageHelper;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.RubinoRequestUploadFileInput;
import ir.resaneh1.iptv.model.RubinoRequestUploadFileOutput;
import ir.resaneh1.iptv.model.RubinoUploadFileOutput;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.ImageLoader;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.SendMessagesHelper;
import org.rbmain.messenger.VideoEditedInfo;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.LaunchActivity;
import org.rbmain.ui.PhotoAlbumPickerActivity;
import org.rbmain.ui.PhotoCropActivity;
import org.rbmain.ui.PhotoViewer;

/* loaded from: classes3.dex */
public class HighlightImageUpdater implements NotificationCenter.NotificationCenterDelegate, PhotoCropActivity.PhotoEditActivityDelegate {
    private final int currentAccount;
    public String currentPicturePath;
    public ImageUpdaterDelegate delegate;
    public boolean needUploadThumbnail;
    public BaseFragment parentFragment;
    public boolean uploadingImage;

    public interface ImageUpdaterDelegate {
        void didFailedUploadPhoto(UploadFileObject uploadFileObject);

        void didStartUploadPhoto(UploadFileObject uploadFileObject);

        void didUploadedPhoto(UploadFileObject uploadFileObject);
    }

    public static class UploadFileObject {
        TLRPC$PhotoSize bigPhoto;
        public String mainAccessHashRec;
        public String mainFileId;
        TLRPC$PhotoSize smallPhoto;
        UploadingStateEnum state;
        public String thumbnailAccessHashRec;
        public String thumbnailFileId;
    }

    public enum UploadingStateEnum {
        uploading,
        finished,
        error
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
    }

    public HighlightImageUpdater(int i, boolean z) {
        this.currentAccount = i;
        this.needUploadThumbnail = z;
    }

    public void openCamera() {
        BaseFragment baseFragment = this.parentFragment;
        if (baseFragment == null || baseFragment.getParentActivity() == null) {
            return;
        }
        try {
            int i = Build.VERSION.SDK_INT;
            if (i >= 23 && this.parentFragment.getParentActivity().checkSelfPermission("android.permission.CAMERA") != 0) {
                this.parentFragment.getParentActivity().requestPermissions(new String[]{"android.permission.CAMERA"}, 19);
                return;
            }
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            File fileGeneratePicturePath = AndroidUtilities.generatePicturePath();
            if (fileGeneratePicturePath != null) {
                if (i >= 24) {
                    intent.putExtra("output", FileProvider.getUriForFile(this.parentFragment.getParentActivity(), "ir.medu.shad.provider", fileGeneratePicturePath));
                    intent.addFlags(2);
                    intent.addFlags(1);
                } else {
                    intent.putExtra("output", Uri.fromFile(fileGeneratePicturePath));
                }
                this.currentPicturePath = fileGeneratePicturePath.getAbsolutePath();
            }
            this.parentFragment.startActivityForResult(intent, 13);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void openGallery() {
        BaseFragment baseFragment = this.parentFragment;
        if (baseFragment == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23 && baseFragment != null && baseFragment.getParentActivity() != null && this.parentFragment.getParentActivity().checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
            this.parentFragment.getParentActivity().requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 4);
            return;
        }
        PhotoAlbumPickerActivity photoAlbumPickerActivity = new PhotoAlbumPickerActivity(PhotoAlbumPickerActivity.SELECT_TYPE_AVATAR, false, false, null);
        photoAlbumPickerActivity.setDelegate(new PhotoAlbumPickerActivity.PhotoAlbumPickerActivityDelegate() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightImageUpdater.1
            @Override // org.rbmain.ui.PhotoAlbumPickerActivity.PhotoAlbumPickerActivityDelegate
            public void didSelectPhotos(ArrayList<SendMessagesHelper.SendingMediaInfo> arrayList, boolean z, int i) {
                if (arrayList.isEmpty()) {
                    return;
                }
                HighlightImageUpdater.this.processBitmap(ImageHelper.loadImage(arrayList.get(0).path, 800.0f, 800.0f, true));
            }

            @Override // org.rbmain.ui.PhotoAlbumPickerActivity.PhotoAlbumPickerActivityDelegate
            public void startPhotoSelectActivity() {
                try {
                    Intent intent = new Intent("android.intent.action.GET_CONTENT");
                    intent.setType("image/*");
                    HighlightImageUpdater.this.parentFragment.startActivityForResult(intent, 14);
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
        });
        this.parentFragment.presentFragment(photoAlbumPickerActivity);
    }

    private void startCrop(String str, Uri uri) {
        try {
            LaunchActivity launchActivity = ApplicationLoader.applicationActivity;
            if (launchActivity == null) {
                return;
            }
            Bundle bundle = new Bundle();
            if (str != null) {
                bundle.putString("photoPath", str);
            } else if (uri != null) {
                bundle.putParcelable("photoUri", uri);
            }
            PhotoCropActivity photoCropActivity = new PhotoCropActivity(bundle);
            photoCropActivity.setDelegate(this);
            launchActivity.lambda$runLinkRequest$40(photoCropActivity);
        } catch (Exception e) {
            FileLog.e(e);
            processBitmap(ImageHelper.loadImage(str, 800.0f, 800.0f, true));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException {
        int i3;
        if (i2 == -1) {
            if (i == 13) {
                PhotoViewer.getInstance().setParentActivity(this.parentFragment.getParentActivity());
                int i4 = 0;
                try {
                    int attributeInt = new ExifInterface(this.currentPicturePath).getAttributeInt("Orientation", 1);
                    if (attributeInt == 3) {
                        i4 = 180;
                    } else if (attributeInt == 6) {
                        i4 = 90;
                    } else if (attributeInt == 8) {
                        i4 = 270;
                    }
                    i3 = i4;
                } catch (Exception e) {
                    FileLog.e(e);
                    i3 = 0;
                }
                final ArrayList<Object> arrayList = new ArrayList<>();
                arrayList.add(new RGHMediaHelper$PhotoEntry(0, 0, 0L, this.currentPicturePath, i3, false));
                PhotoViewer.getInstance().openPhotoForSelect(arrayList, 0, 1, false, new PhotoViewer.EmptyPhotoViewerProvider() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightImageUpdater.2
                    @Override // org.rbmain.ui.PhotoViewer.EmptyPhotoViewerProvider, org.rbmain.ui.PhotoViewer.PhotoViewerProvider
                    public boolean allowCaption() {
                        return false;
                    }

                    @Override // org.rbmain.ui.PhotoViewer.EmptyPhotoViewerProvider, org.rbmain.ui.PhotoViewer.PhotoViewerProvider
                    public boolean canScrollAway() {
                        return false;
                    }

                    @Override // org.rbmain.ui.PhotoViewer.EmptyPhotoViewerProvider, org.rbmain.ui.PhotoViewer.PhotoViewerProvider
                    public void sendButtonPressed(int i5, VideoEditedInfo videoEditedInfo, boolean z, int i6, boolean z2) {
                        RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry = (RGHMediaHelper$PhotoEntry) arrayList.get(0);
                        String str = rGHMediaHelper$PhotoEntry.imagePath;
                        if (str == null && (str = rGHMediaHelper$PhotoEntry.path) == null) {
                            str = null;
                        }
                        HighlightImageUpdater.this.processBitmap(ImageHelper.loadImage(str, 800.0f, 800.0f, true));
                    }
                }, null);
                AndroidUtilities.addMediaToGallery(this.currentPicturePath);
                this.currentPicturePath = null;
                return;
            }
            if (i != 14 || intent == null || intent.getData() == null) {
                return;
            }
            startCrop(null, intent.getData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        TLRPC$PhotoSize tLRPC$PhotoSizeScaleAndSaveImage = ImageLoader.scaleAndSaveImage(bitmap, 200.0f, 200.0f, 80, false);
        TLRPC$PhotoSize tLRPC$PhotoSizeScaleAndSaveImage2 = ImageLoader.scaleAndSaveImage(bitmap, 800.0f, 800.0f, 80, false, 320, 320);
        bitmap.recycle();
        if (tLRPC$PhotoSizeScaleAndSaveImage2 == null || tLRPC$PhotoSizeScaleAndSaveImage == null) {
            return;
        }
        final UploadFileObject uploadFileObject = new UploadFileObject();
        AndroidUtilities.getNextRnd();
        uploadFileObject.smallPhoto = tLRPC$PhotoSizeScaleAndSaveImage;
        uploadFileObject.bigPhoto = tLRPC$PhotoSizeScaleAndSaveImage2;
        UploadingStateEnum uploadingStateEnum = UploadingStateEnum.uploading;
        this.delegate.didStartUploadPhoto(uploadFileObject);
        uploadAvatarForRubino(uploadFileObject).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Integer>() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightImageUpdater.3
            @Override // io.reactivex.Observer
            public void onNext(Integer num) {
                HighlightImageUpdater highlightImageUpdater = HighlightImageUpdater.this;
                highlightImageUpdater.uploadingImage = false;
                UploadFileObject uploadFileObject2 = uploadFileObject;
                uploadFileObject2.state = UploadingStateEnum.finished;
                highlightImageUpdater.delegate.didUploadedPhoto(uploadFileObject2);
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                HighlightImageUpdater highlightImageUpdater = HighlightImageUpdater.this;
                highlightImageUpdater.uploadingImage = false;
                UploadFileObject uploadFileObject2 = uploadFileObject;
                uploadFileObject2.state = UploadingStateEnum.error;
                highlightImageUpdater.delegate.didFailedUploadPhoto(uploadFileObject2);
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                HighlightImageUpdater.this.uploadingImage = false;
            }
        });
    }

    Observable<Integer> uploadAvatarForRubino(final UploadFileObject uploadFileObject) {
        Observable observableJust;
        if (this.needUploadThumbnail) {
            observableJust = Observable.just(1).flatMap(new Function<Integer, Observable<MessangerOutput<RubinoRequestUploadFileOutput>>>() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightImageUpdater.6
                @Override // io.reactivex.functions.Function
                public Observable<MessangerOutput<RubinoRequestUploadFileOutput>> apply(Integer num) throws Exception {
                    RubinoRequestUploadFileInput rubinoRequestUploadFileInput = new RubinoRequestUploadFileInput(RubinoController.getInstance(HighlightImageUpdater.this.currentAccount).getMyCurrentProfileID());
                    rubinoRequestUploadFileInput.file_name = "thumb.jpg";
                    rubinoRequestUploadFileInput.file_size = Long.valueOf(new File(uploadFileObject.smallPhoto.filePath).length());
                    rubinoRequestUploadFileInput.file_type = RubinoRequestUploadFileInput.FileType.Picture;
                    return ApiRequestMessangerRx.getInstance(HighlightImageUpdater.this.currentAccount).rubinoRequestUploadFile(rubinoRequestUploadFileInput);
                }
            }).observeOn(Schedulers.io()).flatMap(new Function<MessangerOutput<RubinoRequestUploadFileOutput>, Observable<MessangerOutput<RubinoUploadFileOutput>>>() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightImageUpdater.5
                @Override // io.reactivex.functions.Function
                public Observable<MessangerOutput<RubinoUploadFileOutput>> apply(MessangerOutput<RubinoRequestUploadFileOutput> messangerOutput) throws Exception {
                    uploadFileObject.thumbnailFileId = messangerOutput.data.file_id;
                    File file = new File(uploadFileObject.smallPhoto.filePath);
                    FileInputStream fileInputStream = new FileInputStream(file);
                    byte[] bArr = new byte[((int) file.length()) + CloseCodes.NORMAL_CLOSURE];
                    int i = fileInputStream.read(bArr);
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
                    byteBufferAllocate.put(bArr, 0, i);
                    byteBufferAllocate.rewind();
                    byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, i);
                    ApiRequestMessangerRx apiRequestMessangerRx = ApiRequestMessangerRx.getInstance(HighlightImageUpdater.this.currentAccount);
                    RubinoRequestUploadFileOutput rubinoRequestUploadFileOutput = messangerOutput.data;
                    return apiRequestMessangerRx.rubinoUploadFile(rubinoRequestUploadFileOutput.server_url, bArrCopyOfRange, 1, 1, rubinoRequestUploadFileOutput.hash_file_request, rubinoRequestUploadFileOutput.file_id);
                }
            }).observeOn(Schedulers.io()).flatMap(new Function<MessangerOutput<RubinoUploadFileOutput>, Observable<Integer>>(this) { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightImageUpdater.4
                @Override // io.reactivex.functions.Function
                public Observable<Integer> apply(MessangerOutput<RubinoUploadFileOutput> messangerOutput) throws Exception {
                    uploadFileObject.thumbnailAccessHashRec = messangerOutput.data.hash_file_receive;
                    return Observable.just(1);
                }
            });
        } else {
            observableJust = Observable.just(1);
        }
        return observableJust.observeOn(Schedulers.io()).flatMap(new Function<Integer, Observable<MessangerOutput<RubinoRequestUploadFileOutput>>>() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightImageUpdater.9
            @Override // io.reactivex.functions.Function
            public Observable<MessangerOutput<RubinoRequestUploadFileOutput>> apply(Integer num) throws Exception {
                RubinoRequestUploadFileInput rubinoRequestUploadFileInput = new RubinoRequestUploadFileInput(RubinoController.getInstance(HighlightImageUpdater.this.currentAccount).getMyCurrentProfileID());
                rubinoRequestUploadFileInput.file_name = "main.jpg";
                rubinoRequestUploadFileInput.file_size = Long.valueOf(new File(uploadFileObject.bigPhoto.filePath).length());
                rubinoRequestUploadFileInput.file_type = RubinoRequestUploadFileInput.FileType.Picture;
                return ApiRequestMessangerRx.getInstance(HighlightImageUpdater.this.currentAccount).rubinoRequestUploadFile(rubinoRequestUploadFileInput);
            }
        }).observeOn(Schedulers.io()).flatMap(new Function<MessangerOutput<RubinoRequestUploadFileOutput>, Observable<MessangerOutput<RubinoUploadFileOutput>>>() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightImageUpdater.8
            @Override // io.reactivex.functions.Function
            public Observable<MessangerOutput<RubinoUploadFileOutput>> apply(MessangerOutput<RubinoRequestUploadFileOutput> messangerOutput) throws Exception {
                uploadFileObject.mainFileId = messangerOutput.data.file_id;
                File file = new File(uploadFileObject.bigPhoto.filePath);
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[((int) file.length()) + CloseCodes.NORMAL_CLOSURE];
                int i = fileInputStream.read(bArr);
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
                byteBufferAllocate.put(bArr, 0, i);
                byteBufferAllocate.rewind();
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, i);
                ApiRequestMessangerRx apiRequestMessangerRx = ApiRequestMessangerRx.getInstance(HighlightImageUpdater.this.currentAccount);
                RubinoRequestUploadFileOutput rubinoRequestUploadFileOutput = messangerOutput.data;
                return apiRequestMessangerRx.rubinoUploadFile(rubinoRequestUploadFileOutput.server_url, bArrCopyOfRange, 1, 1, rubinoRequestUploadFileOutput.hash_file_request, rubinoRequestUploadFileOutput.file_id);
            }
        }).observeOn(Schedulers.io()).flatMap(new Function<MessangerOutput<RubinoUploadFileOutput>, Observable<Integer>>(this) { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.HighlightImageUpdater.7
            @Override // io.reactivex.functions.Function
            public Observable<Integer> apply(MessangerOutput<RubinoUploadFileOutput> messangerOutput) throws Exception {
                uploadFileObject.mainAccessHashRec = messangerOutput.data.hash_file_receive;
                return Observable.just(1);
            }
        });
    }

    @Override // org.rbmain.ui.PhotoCropActivity.PhotoEditActivityDelegate
    public void didFinishEdit(Bitmap bitmap) {
        processBitmap(bitmap);
    }
}
