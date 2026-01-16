package ir.resaneh1.iptv.fragment.rubino.shop;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.core.content.FileProvider;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.stetho.websocket.CloseCodes;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import ir.appp.rghapp.RGHMediaHelper$PhotoEntry;
import ir.medu.shad.R;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx;
import ir.resaneh1.iptv.fragment.rubino.RubinoController;
import ir.resaneh1.iptv.helper.ImageHelper;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.RubinoUploadFileOutput;
import ir.resaneh1.iptv.model.ShopModels;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.ImageLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.SendMessagesHelper;
import org.rbmain.messenger.VideoEditedInfo;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.Components.Bulletin;
import org.rbmain.ui.Components.BulletinFactory;
import org.rbmain.ui.LaunchActivity;
import org.rbmain.ui.PhotoAlbumPickerActivity;
import org.rbmain.ui.PhotoCropActivity;
import org.rbmain.ui.PhotoViewer;

/* loaded from: classes3.dex */
public class ShopImageUpdater implements NotificationCenter.NotificationCenterDelegate, PhotoCropActivity.PhotoEditActivityDelegate {
    private int REQUEST_SEND_FILE_MAX_SIZE_IN_BYTES = 100000000;
    private final int currentAccount;
    public String currentPicturePath;
    public ImageUpdaterDelegate delegate;
    public BaseFragment parentFragment;
    public boolean uploadingImage;

    public interface ImageUpdaterDelegate {
        void didFaildUploadPhoto(ShopModels.ShopImage shopImage);

        void didStartUploadPhoto(ShopModels.ShopImage shopImage);

        void didUploadedPhoto(ShopModels.ShopImage shopImage);
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
    }

    public ShopImageUpdater(int i, String str) {
        this.currentAccount = i;
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
        photoAlbumPickerActivity.setDelegate(new PhotoAlbumPickerActivity.PhotoAlbumPickerActivityDelegate() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ShopImageUpdater.1
            @Override // org.rbmain.ui.PhotoAlbumPickerActivity.PhotoAlbumPickerActivityDelegate
            public void didSelectPhotos(ArrayList<SendMessagesHelper.SendingMediaInfo> arrayList, boolean z, int i) {
                if (arrayList.isEmpty()) {
                    return;
                }
                ShopImageUpdater.this.processBitmap(ImageHelper.loadImage(arrayList.get(0).path, 800.0f, 800.0f, true));
            }

            @Override // org.rbmain.ui.PhotoAlbumPickerActivity.PhotoAlbumPickerActivityDelegate
            public void startPhotoSelectActivity() {
                try {
                    Intent intent = new Intent("android.intent.action.GET_CONTENT");
                    intent.setType("image/*");
                    ShopImageUpdater.this.parentFragment.startActivityForResult(intent, 14);
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
                PhotoViewer.getInstance().openPhotoForSelect(arrayList, 0, 1, false, new PhotoViewer.EmptyPhotoViewerProvider() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ShopImageUpdater.2
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
                        ShopImageUpdater.this.processBitmap(ImageHelper.loadImage(str, 800.0f, 800.0f, true));
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

    public Bitmap compressBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getByteCount() <= this.REQUEST_SEND_FILE_MAX_SIZE_IN_BYTES) {
            return bitmap;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, byteArrayOutputStream);
        if (byteArrayOutputStream.size() <= this.REQUEST_SEND_FILE_MAX_SIZE_IN_BYTES) {
            return bitmap;
        }
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        if (byteArrayOutputStream.size() > this.REQUEST_SEND_FILE_MAX_SIZE_IN_BYTES) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ShopImageUpdater$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$compressBitmap$0();
                }
            });
            return null;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$compressBitmap$0() {
        Bulletin bulletinCreateCustomBulletin = BulletinFactory.of(this.parentFragment).createCustomBulletin(LocaleController.getString("bitmap_max_size", R.string.bitmap_max_size));
        BaseFragment baseFragment = this.parentFragment;
        if (baseFragment == null || baseFragment.getParentActivity() == null) {
            return;
        }
        bulletinCreateCustomBulletin.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processBitmap(Bitmap bitmap) {
        Bitmap bitmapCompressBitmap;
        if (bitmap == null || (bitmapCompressBitmap = compressBitmap(bitmap)) == null) {
            return;
        }
        TLRPC$PhotoSize tLRPC$PhotoSizeScaleAndSaveImage = ImageLoader.scaleAndSaveImage(bitmapCompressBitmap, 200.0f, 200.0f, 80, false);
        TLRPC$PhotoSize tLRPC$PhotoSizeScaleAndSaveImage2 = ImageLoader.scaleAndSaveImage(bitmapCompressBitmap, 800.0f, 800.0f, 80, false, 320, 320);
        bitmap.recycle();
        if (tLRPC$PhotoSizeScaleAndSaveImage2 == null || tLRPC$PhotoSizeScaleAndSaveImage == null) {
            return;
        }
        final ShopModels.ShopImage shopImage = new ShopModels.ShopImage();
        shopImage.smallPhoto = tLRPC$PhotoSizeScaleAndSaveImage;
        shopImage.bigPhoto = tLRPC$PhotoSizeScaleAndSaveImage2;
        shopImage.state = ShopModels.UploadingStateEnum.uploading;
        this.delegate.didStartUploadPhoto(shopImage);
        uploadAvatarForRubino(shopImage).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<ShopModels.InputFile>() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ShopImageUpdater.3
            @Override // io.reactivex.Observer
            public void onNext(ShopModels.InputFile inputFile) {
                ShopImageUpdater shopImageUpdater = ShopImageUpdater.this;
                shopImageUpdater.uploadingImage = false;
                ShopModels.ShopImage shopImage2 = shopImage;
                shopImage2.inputFile = inputFile;
                shopImage2.state = ShopModels.UploadingStateEnum.finished;
                shopImageUpdater.delegate.didUploadedPhoto(shopImage2);
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                ShopImageUpdater shopImageUpdater = ShopImageUpdater.this;
                shopImageUpdater.uploadingImage = false;
                ShopModels.ShopImage shopImage2 = shopImage;
                shopImage2.state = ShopModels.UploadingStateEnum.error;
                shopImageUpdater.delegate.didFaildUploadPhoto(shopImage2);
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                ShopImageUpdater.this.uploadingImage = false;
            }
        });
    }

    Observable<ShopModels.InputFile> uploadAvatarForRubino(final ShopModels.ShopImage shopImage) {
        final ShopModels.InputFile inputFile = new ShopModels.InputFile();
        return Observable.just(1).flatMap(new Function<Integer, Observable<MessangerOutput<ShopModels.ShopRequestUploadFileOutput>>>() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ShopImageUpdater.9
            @Override // io.reactivex.functions.Function
            public Observable<MessangerOutput<ShopModels.ShopRequestUploadFileOutput>> apply(Integer num) throws Exception {
                ShopModels.ShopRequestUploadFileInput shopRequestUploadFileInput = new ShopModels.ShopRequestUploadFileInput(RubinoController.getInstance(ShopImageUpdater.this.currentAccount).getMyCurrentProfileID());
                shopRequestUploadFileInput.file_name = "thumb.jpg";
                shopRequestUploadFileInput.file_size = Long.valueOf(new File(shopImage.smallPhoto.filePath).length());
                shopRequestUploadFileInput.file_type = ShopModels.FileType.Picture;
                return ApiRequestMessangerRx.getInstance(ShopImageUpdater.this.currentAccount).shopRequestUploadFile(shopRequestUploadFileInput);
            }
        }).observeOn(Schedulers.io()).flatMap(new Function<MessangerOutput<ShopModels.ShopRequestUploadFileOutput>, Observable<MessangerOutput<RubinoUploadFileOutput>>>() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ShopImageUpdater.8
            @Override // io.reactivex.functions.Function
            public Observable<MessangerOutput<RubinoUploadFileOutput>> apply(MessangerOutput<ShopModels.ShopRequestUploadFileOutput> messangerOutput) throws Exception {
                inputFile.thumbnail_file = new ShopModels.EmbeddedInputFile();
                ShopModels.EmbeddedInputFile embeddedInputFile = inputFile.thumbnail_file;
                embeddedInputFile.file_type = ShopModels.FileType.Picture;
                embeddedInputFile.file_id = messangerOutput.data.file_id;
                TLRPC$PhotoSize tLRPC$PhotoSize = shopImage.smallPhoto;
                embeddedInputFile.width = tLRPC$PhotoSize.w;
                embeddedInputFile.height = tLRPC$PhotoSize.h;
                File file = new File(shopImage.smallPhoto.filePath);
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[((int) file.length()) + CloseCodes.NORMAL_CLOSURE];
                int i = fileInputStream.read(bArr);
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
                byteBufferAllocate.put(bArr, 0, i);
                byteBufferAllocate.rewind();
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, i);
                ApiRequestMessangerRx apiRequestMessangerRx = ApiRequestMessangerRx.getInstance(ShopImageUpdater.this.currentAccount);
                ShopModels.ShopRequestUploadFileOutput shopRequestUploadFileOutput = messangerOutput.data;
                return apiRequestMessangerRx.rubinoUploadFile(shopRequestUploadFileOutput.server_url, bArrCopyOfRange, 1, 1, shopRequestUploadFileOutput.hash_file_request, shopRequestUploadFileOutput.file_id);
            }
        }).observeOn(Schedulers.io()).flatMap(new Function<MessangerOutput<RubinoUploadFileOutput>, Observable<Integer>>(this) { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ShopImageUpdater.7
            @Override // io.reactivex.functions.Function
            public Observable<Integer> apply(MessangerOutput<RubinoUploadFileOutput> messangerOutput) throws Exception {
                inputFile.thumbnail_file.access_hash_rec = messangerOutput.data.hash_file_receive;
                return Observable.just(1);
            }
        }).observeOn(Schedulers.io()).flatMap(new Function<Integer, Observable<MessangerOutput<ShopModels.ShopRequestUploadFileOutput>>>() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ShopImageUpdater.6
            @Override // io.reactivex.functions.Function
            public Observable<MessangerOutput<ShopModels.ShopRequestUploadFileOutput>> apply(Integer num) throws Exception {
                ShopModels.ShopRequestUploadFileInput shopRequestUploadFileInput = new ShopModels.ShopRequestUploadFileInput(RubinoController.getInstance(ShopImageUpdater.this.currentAccount).getMyCurrentProfileID());
                shopRequestUploadFileInput.file_name = "main.jpg";
                shopRequestUploadFileInput.file_size = Long.valueOf(new File(shopImage.bigPhoto.filePath).length());
                shopRequestUploadFileInput.file_type = ShopModels.FileType.Picture;
                return ApiRequestMessangerRx.getInstance(ShopImageUpdater.this.currentAccount).shopRequestUploadFile(shopRequestUploadFileInput);
            }
        }).observeOn(Schedulers.io()).flatMap(new Function<MessangerOutput<ShopModels.ShopRequestUploadFileOutput>, Observable<MessangerOutput<RubinoUploadFileOutput>>>() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ShopImageUpdater.5
            @Override // io.reactivex.functions.Function
            public Observable<MessangerOutput<RubinoUploadFileOutput>> apply(MessangerOutput<ShopModels.ShopRequestUploadFileOutput> messangerOutput) throws Exception {
                inputFile.main_file = new ShopModels.EmbeddedInputFile();
                ShopModels.EmbeddedInputFile embeddedInputFile = inputFile.main_file;
                embeddedInputFile.file_type = ShopModels.FileType.Picture;
                embeddedInputFile.file_id = messangerOutput.data.file_id;
                TLRPC$PhotoSize tLRPC$PhotoSize = shopImage.bigPhoto;
                embeddedInputFile.width = tLRPC$PhotoSize.w;
                embeddedInputFile.height = tLRPC$PhotoSize.h;
                File file = new File(shopImage.bigPhoto.filePath);
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[((int) file.length()) + CloseCodes.NORMAL_CLOSURE];
                int i = fileInputStream.read(bArr);
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
                byteBufferAllocate.put(bArr, 0, i);
                byteBufferAllocate.rewind();
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, i);
                ApiRequestMessangerRx apiRequestMessangerRx = ApiRequestMessangerRx.getInstance(ShopImageUpdater.this.currentAccount);
                ShopModels.ShopRequestUploadFileOutput shopRequestUploadFileOutput = messangerOutput.data;
                return apiRequestMessangerRx.rubinoUploadFile(shopRequestUploadFileOutput.server_url, bArrCopyOfRange, 1, 1, shopRequestUploadFileOutput.hash_file_request, shopRequestUploadFileOutput.file_id);
            }
        }).observeOn(Schedulers.io()).flatMap(new Function<MessangerOutput<RubinoUploadFileOutput>, Observable<ShopModels.InputFile>>(this) { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ShopImageUpdater.4
            @Override // io.reactivex.functions.Function
            public Observable<ShopModels.InputFile> apply(MessangerOutput<RubinoUploadFileOutput> messangerOutput) throws Exception {
                ShopModels.InputFile inputFile2 = inputFile;
                inputFile2.main_file.access_hash_rec = messangerOutput.data.hash_file_receive;
                return Observable.just(inputFile2);
            }
        });
    }

    @Override // org.rbmain.ui.PhotoCropActivity.PhotoEditActivityDelegate
    public void didFinishEdit(Bitmap bitmap) {
        processBitmap(bitmap);
    }
}
