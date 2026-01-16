package androidMessenger.proxy;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import androidMessenger.proxy.FileLoadProxy;
import androidMessenger.utilites.ChatConverter;
import androidMessenger.utilites.MessageConverter;
import androidMessenger.utilites.MyLog;
import com.google.android.exoplayer2t.util.Log;
import ir.aaap.messengercore.CoreMainClass;
import ir.aaap.messengercore.LoadListener;
import ir.aaap.messengercore.model.AvatarFileInline;
import ir.aaap.messengercore.model.FileInlineObject;
import ir.aaap.messengercore.model.GetFileResult;
import ir.aaap.messengercore.model.LocationObject;
import ir.aaap.messengercore.model.MapViewObject;
import ir.aaap.messengercore.model.SendFileResult;
import ir.aaap.messengercore.model.api.SendFileInput;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.BaseController;
import org.rbmain.messenger.DispatchQueue;
import org.rbmain.messenger.Utilities;
import org.rbmain.tgnet.NativeByteBuffer;
import org.rbmain.tgnet.QuickAckDelegate;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$InputChatPhoto;
import org.rbmain.tgnet.TLRPC$InputFileLocation;
import org.rbmain.tgnet.TLRPC$InputPeer;
import org.rbmain.tgnet.TLRPC$InputWebFileLocation;
import org.rbmain.tgnet.TLRPC$MessageMedia;
import org.rbmain.tgnet.TLRPC$TL_channels_editPhoto;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_inputChatUploadedPhoto;
import org.rbmain.tgnet.TLRPC$TL_inputWebFileGeoPointLocation;
import org.rbmain.tgnet.TLRPC$TL_messageActionChatEditPhoto;
import org.rbmain.tgnet.TLRPC$TL_messageService;
import org.rbmain.tgnet.TLRPC$TL_photos_photo;
import org.rbmain.tgnet.TLRPC$TL_photos_updateProfilePhoto;
import org.rbmain.tgnet.TLRPC$TL_photos_uploadProfilePhoto;
import org.rbmain.tgnet.TLRPC$TL_resultUploadFile;
import org.rbmain.tgnet.TLRPC$TL_storage_filePartial;
import org.rbmain.tgnet.TLRPC$TL_storage_filePng;
import org.rbmain.tgnet.TLRPC$TL_updateNewMessage;
import org.rbmain.tgnet.TLRPC$TL_updates;
import org.rbmain.tgnet.TLRPC$TL_upload_file;
import org.rbmain.tgnet.TLRPC$TL_upload_getFile;
import org.rbmain.tgnet.TLRPC$TL_upload_getWebFile;
import org.rbmain.tgnet.TLRPC$TL_upload_webFile;
import org.rbmain.tgnet.WriteToSocketDelegate;

/* loaded from: classes.dex */
public class FileLoadProxy extends BaseController {
    private static volatile FileLoadProxy[] Instance = new FileLoadProxy[3];

    public FileLoadProxy(int i) {
        super(i);
        this.currentAccount = i;
    }

    public static FileLoadProxy getInstance(int i) {
        FileLoadProxy fileLoadProxy = Instance[i];
        if (fileLoadProxy == null) {
            synchronized (MessageProxy.class) {
                fileLoadProxy = Instance[i];
                if (fileLoadProxy == null) {
                    FileLoadProxy[] fileLoadProxyArr = Instance;
                    FileLoadProxy fileLoadProxy2 = new FileLoadProxy(i);
                    fileLoadProxyArr[i] = fileLoadProxy2;
                    fileLoadProxy = fileLoadProxy2;
                }
            }
        }
        return fileLoadProxy;
    }

    public int sendRequest(TLObject tLObject, RequestDelegate requestDelegate, QuickAckDelegate quickAckDelegate, WriteToSocketDelegate writeToSocketDelegate, int i, int i2, int i3, boolean z) {
        String str;
        String str2;
        long j;
        String accessHashId;
        if (tLObject instanceof TLRPC$TL_upload_getFile) {
            TLRPC$TL_upload_getFile tLRPC$TL_upload_getFile = (TLRPC$TL_upload_getFile) tLObject;
            String dcId = IdStorage.getInstance().getDcId(i2);
            TLRPC$InputFileLocation tLRPC$InputFileLocation = tLRPC$TL_upload_getFile.location;
            if (tLRPC$InputFileLocation != null) {
                j = tLRPC$InputFileLocation.id;
                str = tLRPC$InputFileLocation.cdnTag;
                if (tLRPC$InputFileLocation.access_hash != 0) {
                    accessHashId = IdStorage.getInstance().getAccessHashId(tLRPC$TL_upload_getFile.location.access_hash);
                } else {
                    TLRPC$InputPeer tLRPC$InputPeer = tLRPC$InputFileLocation.peer;
                    if (tLRPC$InputPeer == null || tLRPC$InputPeer.access_hash == 0) {
                        str2 = null;
                    } else {
                        accessHashId = IdStorage.getInstance().getAccessHashId(tLRPC$TL_upload_getFile.location.peer.access_hash);
                    }
                }
                str2 = accessHashId;
            } else {
                str = null;
                str2 = null;
                j = 0;
            }
            if (dcId == null || str2 == null || j == 0) {
                return -1;
            }
            return getAccountInstance().getCoreMainClass().getFile(dcId, str, tLRPC$TL_upload_getFile.offset, (r3 + tLRPC$TL_upload_getFile.limit) - 1, str2, String.valueOf(j), new AnonymousClass1(this, requestDelegate));
        }
        if (tLObject instanceof TLRPC$TL_upload_getWebFile) {
            TLRPC$InputWebFileLocation tLRPC$InputWebFileLocation = ((TLRPC$TL_upload_getWebFile) tLObject).location;
            if (tLRPC$InputWebFileLocation instanceof TLRPC$TL_inputWebFileGeoPointLocation) {
                LocationObject locationObjectConvertMediaToLocationObject = MessageConverter.convertMediaToLocationObject(((TLRPC$TL_inputWebFileGeoPointLocation) tLRPC$InputWebFileLocation).geo_point);
                if (locationObjectConvertMediaToLocationObject.map_view == null) {
                    getCoreMainClass().getMapView(locationObjectConvertMediaToLocationObject, new AnonymousClass2(locationObjectConvertMediaToLocationObject, requestDelegate));
                } else {
                    getLocationFile(locationObjectConvertMediaToLocationObject, requestDelegate);
                }
            }
        }
        return -1;
    }

    /* renamed from: androidMessenger.proxy.FileLoadProxy$1, reason: invalid class name */
    class AnonymousClass1 implements CoreMainClass.FileLoadResponseListener {
        final /* synthetic */ RequestDelegate val$onComplete;

        AnonymousClass1(FileLoadProxy fileLoadProxy, RequestDelegate requestDelegate) {
            this.val$onComplete = requestDelegate;
        }

        @Override // ir.aaap.messengercore.CoreMainClass.FileLoadResponseListener
        public void onFileDidLoad(GetFileResult getFileResult) {
            final TLRPC$TL_upload_file tLRPC$TL_upload_file = new TLRPC$TL_upload_file();
            try {
                tLRPC$TL_upload_file.bytes = FileLoadProxy.getByteBufferOfResult(getFileResult.bytes);
            } catch (Exception e) {
                e.printStackTrace();
            }
            tLRPC$TL_upload_file.type = new TLRPC$TL_storage_filePartial();
            DispatchQueue dispatchQueue = Utilities.fileQueue;
            final RequestDelegate requestDelegate = this.val$onComplete;
            dispatchQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.FileLoadProxy$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    FileLoadProxy.AnonymousClass1.lambda$onFileDidLoad$0(tLRPC$TL_upload_file, requestDelegate);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onFileDidLoad$0(TLRPC$TL_upload_file tLRPC$TL_upload_file, RequestDelegate requestDelegate) {
            if (tLRPC$TL_upload_file.bytes != null) {
                requestDelegate.run(tLRPC$TL_upload_file, null);
            }
        }

        @Override // ir.aaap.messengercore.CoreMainClass.FileLoadResponseListener
        public void onFileLoadingFailed() {
            Log.d("MyTag", "FileDidntLoaded");
            final TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
            tLRPC$TL_error.text = "FileDidntLoaded";
            DispatchQueue dispatchQueue = Utilities.fileQueue;
            final RequestDelegate requestDelegate = this.val$onComplete;
            dispatchQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.FileLoadProxy$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    requestDelegate.run(null, tLRPC$TL_error);
                }
            });
        }
    }

    /* renamed from: androidMessenger.proxy.FileLoadProxy$2, reason: invalid class name */
    class AnonymousClass2 implements LoadListener<MapViewObject> {
        final /* synthetic */ LocationObject val$locationObject;
        final /* synthetic */ RequestDelegate val$onComplete;

        AnonymousClass2(LocationObject locationObject, RequestDelegate requestDelegate) {
            this.val$locationObject = locationObject;
            this.val$onComplete = requestDelegate;
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onDidLoad(MapViewObject mapViewObject) {
            LocationObject locationObject = this.val$locationObject;
            locationObject.map_view = mapViewObject;
            FileLoadProxy.this.getLocationFile(locationObject, this.val$onComplete);
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onError(Exception exc) {
            Log.d("MyTag", "FileDidntLoaded");
            final TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
            tLRPC$TL_error.text = "FileDidntLoaded";
            DispatchQueue dispatchQueue = Utilities.fileQueue;
            final RequestDelegate requestDelegate = this.val$onComplete;
            dispatchQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.FileLoadProxy$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    requestDelegate.run(null, tLRPC$TL_error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getLocationFile(final LocationObject locationObject, final RequestDelegate requestDelegate) {
        final HashMap map = new HashMap();
        for (int i = 0; i < locationObject.map_view.tile_urls.size(); i++) {
            final String str = locationObject.map_view.tile_urls.get(i);
            final int i2 = i;
            Utilities.fileQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.FileLoadProxy$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getLocationFile$0(str, map, i2, locationObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getLocationFile$0(String str, final Map map, final int i, final LocationObject locationObject, final RequestDelegate requestDelegate) {
        final File fileForUrl = getFileForUrl(str);
        if (fileForUrl.exists() && fileForUrl.length() > 0) {
            map.put(Integer.valueOf(i), fileForUrl.getPath());
            checkFinished(map, locationObject, requestDelegate);
        } else {
            getCoreMainClass().getExternalFile(str, new CoreMainClass.FileLoadResponseListener() { // from class: androidMessenger.proxy.FileLoadProxy.3
                @Override // ir.aaap.messengercore.CoreMainClass.FileLoadResponseListener
                public void onFileLoadingFailed() {
                }

                @Override // ir.aaap.messengercore.CoreMainClass.FileLoadResponseListener
                public void onFileDidLoad(GetFileResult getFileResult) throws IOException {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(fileForUrl);
                        try {
                            fileOutputStream.write(getFileResult.bytes);
                            fileOutputStream.close();
                        } catch (Throwable th) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable unused) {
                            }
                            throw th;
                        }
                    } catch (Exception unused2) {
                    }
                    map.put(Integer.valueOf(i), fileForUrl.getPath());
                    FileLoadProxy.this.checkFinished(map, locationObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkFinished(Map<Integer, String> map, LocationObject locationObject, final RequestDelegate requestDelegate) {
        if (map.size() == locationObject.map_view.tile_urls.size()) {
            byte[] bArrCreateLocationImageBitmap = createLocationImageBitmap(map, locationObject);
            final TLRPC$TL_upload_webFile tLRPC$TL_upload_webFile = new TLRPC$TL_upload_webFile();
            try {
                tLRPC$TL_upload_webFile.bytes = getByteBufferOfResult(bArrCreateLocationImageBitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
            tLRPC$TL_upload_webFile.file_type = new TLRPC$TL_storage_filePng();
            tLRPC$TL_upload_webFile.size = bArrCreateLocationImageBitmap.length;
            Utilities.fileQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.FileLoadProxy$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    FileLoadProxy.lambda$checkFinished$1(tLRPC$TL_upload_webFile, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$checkFinished$1(TLRPC$TL_upload_webFile tLRPC$TL_upload_webFile, RequestDelegate requestDelegate) {
        if (tLRPC$TL_upload_webFile.bytes != null) {
            requestDelegate.run(tLRPC$TL_upload_webFile, null);
        }
    }

    private byte[] createLocationImageBitmap(Map<Integer, String> map, LocationObject locationObject) {
        MapViewObject mapViewObject;
        ArrayList arrayList;
        Paint paint;
        int i;
        int i2;
        int i3;
        Bitmap bitmap;
        Paint paint2;
        int i4;
        MapViewObject mapViewObject2 = locationObject.map_view;
        double d = mapViewObject2.x_loc;
        double d2 = mapViewObject2.y_loc;
        ArrayList arrayList2 = new ArrayList();
        map.size();
        int i5 = 1;
        Paint paint3 = new Paint(1);
        paint3.setAntiAlias(true);
        paint3.setFilterBitmap(true);
        paint3.setDither(true);
        int i6 = 0;
        Bitmap bitmap2 = null;
        int i7 = 0;
        Canvas canvas = null;
        while (i6 < mapViewObject2.tile_side_count) {
            int i8 = 0;
            while (i8 < mapViewObject2.tile_side_count) {
                Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(map.get(Integer.valueOf(i7)));
                if (canvas == null && bitmap2 != null) {
                    try {
                        canvas = new Canvas(bitmap2);
                    } catch (Exception unused) {
                        canvas = null;
                    }
                }
                if (i7 != 0) {
                    mapViewObject = mapViewObject2;
                    arrayList = arrayList2;
                    paint = paint3;
                    i = i6;
                    i2 = i7;
                    i3 = i8;
                    bitmap = bitmapDecodeFile;
                } else if (bitmapDecodeFile == null) {
                    i7++;
                    mapViewObject = mapViewObject2;
                    arrayList = arrayList2;
                    paint2 = paint3;
                    i = i6;
                    i3 = i8;
                    i8 = i3 + 1;
                    arrayList2 = arrayList;
                    paint3 = paint2;
                    mapViewObject2 = mapViewObject;
                    i6 = i;
                    i5 = 1;
                } else {
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeFile.getWidth() * (mapViewObject2.tile_side_count - i5), bitmapDecodeFile.getHeight() * (mapViewObject2.tile_side_count - i5), Bitmap.Config.ARGB_8888);
                    if (canvas == null) {
                        canvas = new Canvas(bitmapCreateBitmap);
                    }
                    float width = bitmapDecodeFile.getWidth();
                    float height = bitmapDecodeFile.getHeight();
                    int i9 = 0;
                    while (i9 < mapViewObject2.tile_side_count) {
                        Canvas canvas2 = canvas;
                        int i10 = 0;
                        while (i10 < mapViewObject2.tile_side_count) {
                            int i11 = i8;
                            double d3 = width;
                            Double.isNaN(d3);
                            MapViewObject mapViewObject3 = mapViewObject2;
                            int i12 = i6;
                            double d4 = i10 * width;
                            Double.isNaN(d4);
                            ArrayList arrayList3 = arrayList2;
                            double d5 = height;
                            Double.isNaN(d5);
                            float f = width;
                            double d6 = i9 * height;
                            Double.isNaN(d6);
                            Double.isNaN(d3);
                            Double.isNaN(d3);
                            Double.isNaN(d4);
                            Double.isNaN(d5);
                            Double.isNaN(d5);
                            Double.isNaN(d6);
                            arrayList3.add(new Rect((int) ((d * (-1.0d) * d3) + d4), (int) (((-1.0d) * d2 * d5) + d6), (int) ((d3 - (d * d3)) + d4), (int) ((d5 - (d2 * d5)) + d6)));
                            i10++;
                            arrayList2 = arrayList3;
                            width = f;
                            i8 = i11;
                            bitmapDecodeFile = bitmapDecodeFile;
                            mapViewObject2 = mapViewObject3;
                            i6 = i12;
                            paint3 = paint3;
                            height = height;
                            i7 = i7;
                        }
                        i9++;
                        canvas = canvas2;
                        mapViewObject2 = mapViewObject2;
                    }
                    mapViewObject = mapViewObject2;
                    arrayList = arrayList2;
                    paint = paint3;
                    i = i6;
                    i2 = i7;
                    i3 = i8;
                    bitmap = bitmapDecodeFile;
                    bitmap2 = bitmapCreateBitmap;
                }
                if (canvas == null || bitmap == null) {
                    paint2 = paint;
                    i4 = i2;
                } else {
                    i4 = i2;
                    Bitmap bitmap3 = bitmap;
                    paint2 = paint;
                    canvas.drawBitmap(bitmap3, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), (Rect) arrayList.get(i4), paint2);
                    bitmap3.recycle();
                }
                i7 = i4 + 1;
                i8 = i3 + 1;
                arrayList2 = arrayList;
                paint3 = paint2;
                mapViewObject2 = mapViewObject;
                i6 = i;
                i5 = 1;
            }
            i6++;
            mapViewObject2 = mapViewObject2;
            i5 = 1;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap2 != null) {
            bitmap2.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (bitmap2 != null) {
            bitmap2.recycle();
        }
        return byteArray;
    }

    File getFileForUrl(String str) {
        return new File(getDownloadTempDirectory(), "tile" + Utilities.MD5(str) + ".jpg");
    }

    private File getDownloadTempDirectory() {
        File file = new File(ApplicationLoader.applicationContext.getExternalCacheDir(), "downloadtemp");
        file.mkdirs();
        return file;
    }

    public int uploadFile(String str, byte[] bArr, int i, int i2, String str2, String str3, RequestDelegate requestDelegate) {
        SendFileInput sendFileInput = new SendFileInput();
        sendFileInput.bytes = bArr;
        int i3 = i + 1;
        sendFileInput.partNumber = i3;
        sendFileInput.totalPart = i2;
        if (i3 > i2) {
            sendFileInput.totalPart = i3;
        }
        MyLog.e("UPLOOOOAD", "partNum: " + sendFileInput.partNumber + "\ttotal: " + sendFileInput.totalPart + "\tlength: " + bArr.length);
        sendFileInput.access_hash_send = str2;
        sendFileInput.file_id = str3;
        return getAccountInstance().getCoreMainClass().sendFile(str, sendFileInput, new AnonymousClass4(this, requestDelegate));
    }

    /* renamed from: androidMessenger.proxy.FileLoadProxy$4, reason: invalid class name */
    class AnonymousClass4 implements CoreMainClass.FileUpLoadResponseListener {
        final /* synthetic */ RequestDelegate val$onComplete;

        AnonymousClass4(FileLoadProxy fileLoadProxy, RequestDelegate requestDelegate) {
            this.val$onComplete = requestDelegate;
        }

        @Override // ir.aaap.messengercore.CoreMainClass.FileUpLoadResponseListener
        public void onFileDidUpload(final SendFileResult sendFileResult) {
            DispatchQueue dispatchQueue = Utilities.fileQueue;
            final RequestDelegate requestDelegate = this.val$onComplete;
            dispatchQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.FileLoadProxy$4$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    FileLoadProxy.AnonymousClass4.lambda$onFileDidUpload$0(sendFileResult, requestDelegate);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onFileDidUpload$0(SendFileResult sendFileResult, RequestDelegate requestDelegate) {
            TLRPC$TL_resultUploadFile tLRPC$TL_resultUploadFile = new TLRPC$TL_resultUploadFile();
            if (sendFileResult != null && !TextUtils.isEmpty(sendFileResult.access_hash_rec)) {
                tLRPC$TL_resultUploadFile.access_hash_rec = sendFileResult.access_hash_rec;
            }
            requestDelegate.run(tLRPC$TL_resultUploadFile, null);
        }

        @Override // ir.aaap.messengercore.CoreMainClass.FileUpLoadResponseListener
        public void onFileUploadingFailed() {
            DispatchQueue dispatchQueue = Utilities.fileQueue;
            final RequestDelegate requestDelegate = this.val$onComplete;
            dispatchQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.FileLoadProxy$4$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    FileLoadProxy.AnonymousClass4.lambda$onFileUploadingFailed$2(requestDelegate);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onFileUploadingFailed$2(final RequestDelegate requestDelegate) {
            Log.d("MyTag", "FileDidntUploaded");
            final TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
            tLRPC$TL_error.text = "FileDidntUploaded";
            Utilities.fileQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.FileLoadProxy$4$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    requestDelegate.run(null, tLRPC$TL_error);
                }
            });
        }
    }

    public static NativeByteBuffer getByteBufferOfResult(byte[] bArr) throws Exception {
        NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(bArr.length);
        nativeByteBuffer.position(0);
        nativeByteBuffer.writeBytes(bArr);
        nativeByteBuffer.position(0);
        return nativeByteBuffer;
    }

    public void cancelRequest(int i) {
        getAccountInstance().getCoreMainClass().cancelGetFile(i);
    }

    public void sendUploadPhotoReq(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if ((tLObject instanceof TLRPC$TL_photos_uploadProfilePhoto) || (tLObject instanceof TLRPC$TL_channels_editPhoto)) {
            Utilities.fileQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.FileLoadProxy$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$sendUploadPhotoReq$2(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendUploadPhotoReq$2(final TLObject tLObject, final RequestDelegate requestDelegate) {
        String dialogId;
        String strValueOf;
        String strValueOf2;
        if (tLObject instanceof TLRPC$TL_photos_uploadProfilePhoto) {
            TLRPC$TL_photos_uploadProfilePhoto tLRPC$TL_photos_uploadProfilePhoto = (TLRPC$TL_photos_uploadProfilePhoto) tLObject;
            strValueOf2 = String.valueOf(tLRPC$TL_photos_uploadProfilePhoto.smallFile.id);
            strValueOf = String.valueOf(tLRPC$TL_photos_uploadProfilePhoto.file.id);
            dialogId = getAccountInstance().getCoreMainClass().getMyGuid();
        } else {
            TLRPC$TL_channels_editPhoto tLRPC$TL_channels_editPhoto = (TLRPC$TL_channels_editPhoto) tLObject;
            TLRPC$InputChatPhoto tLRPC$InputChatPhoto = tLRPC$TL_channels_editPhoto.photo;
            if (!(tLRPC$InputChatPhoto instanceof TLRPC$TL_inputChatUploadedPhoto) || !(tLRPC$TL_channels_editPhoto.smallPhoto instanceof TLRPC$TL_inputChatUploadedPhoto)) {
                return;
            }
            String strValueOf3 = String.valueOf(((TLRPC$TL_inputChatUploadedPhoto) tLRPC$InputChatPhoto).file.id);
            String strValueOf4 = String.valueOf(((TLRPC$TL_inputChatUploadedPhoto) tLRPC$TL_channels_editPhoto.smallPhoto).file.id);
            dialogId = IdStorage.getInstance().getDialogId(tLRPC$TL_channels_editPhoto.channel.channel_id * (-1));
            strValueOf = strValueOf3;
            strValueOf2 = strValueOf4;
        }
        getAccountInstance().getCoreMainClass().uploadAvatar(dialogId, strValueOf, strValueOf2, new LoadListener<AvatarFileInline>(this) { // from class: androidMessenger.proxy.FileLoadProxy.5
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(AvatarFileInline avatarFileInline) {
                if (tLObject instanceof TLRPC$TL_photos_uploadProfilePhoto) {
                    TLRPC$TL_photos_photo tLRPC$TL_photos_photo = new TLRPC$TL_photos_photo();
                    tLRPC$TL_photos_photo.photo = MessageConverter.convertToPhoto(avatarFileInline, null, 0);
                    requestDelegate.run(tLRPC$TL_photos_photo, null);
                    return;
                }
                TLRPC$TL_updates tLRPC$TL_updates = new TLRPC$TL_updates();
                TLRPC$TL_updateNewMessage tLRPC$TL_updateNewMessage = new TLRPC$TL_updateNewMessage();
                TLRPC$TL_messageService tLRPC$TL_messageService = new TLRPC$TL_messageService();
                tLRPC$TL_updateNewMessage.message = tLRPC$TL_messageService;
                tLRPC$TL_messageService.action = new TLRPC$TL_messageActionChatEditPhoto();
                tLRPC$TL_updateNewMessage.message.action.photo = MessageConverter.convertToPhoto(avatarFileInline, null, 0);
                tLRPC$TL_updates.updates.add(tLRPC$TL_updateNewMessage);
                requestDelegate.run(tLRPC$TL_updates, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Fail Uploading Avatar";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void deleteAvatar(final long j, final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_photos_updateProfilePhoto) {
            Utilities.fileQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.FileLoadProxy$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$deleteAvatar$3(tLObject, j, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteAvatar$3(TLObject tLObject, long j, final RequestDelegate requestDelegate) {
        getAccountInstance().getCoreMainClass().deleteAvatar(j == 0 ? getAccountInstance().getCoreMainClass().getMyGuid() : IdStorage.getInstance().getDialogId(j), String.valueOf(((TLRPC$TL_photos_updateProfilePhoto) tLObject).id.avatar_id), new LoadListener<AvatarFileInline>(this) { // from class: androidMessenger.proxy.FileLoadProxy.6
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(AvatarFileInline avatarFileInline) {
                requestDelegate.run(avatarFileInline != null ? ChatConverter.getUserProfilePhoto(avatarFileInline) : null, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Fail to delete avatar";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void saveSentFile(String str, TLRPC$MessageMedia tLRPC$MessageMedia) {
        FileInlineObject fileInlineObjectConvertToFileInlineObject;
        if (tLRPC$MessageMedia == null || (fileInlineObjectConvertToFileInlineObject = MessageConverter.convertToFileInlineObject(tLRPC$MessageMedia)) == null) {
            return;
        }
        String strSubstring = fileInlineObjectConvertToFileInlineObject.file_name;
        if (!TextUtils.isEmpty(strSubstring)) {
            int iLastIndexOf = strSubstring.lastIndexOf(".");
            if (iLastIndexOf > 0) {
                strSubstring = strSubstring.substring(0, iLastIndexOf);
            }
            fileInlineObjectConvertToFileInlineObject.file_name = strSubstring;
        }
        getCoreMainClass().addSentFile(str, fileInlineObjectConvertToFileInlineObject);
    }

    public TLRPC$MessageMedia getSentFile(String str) {
        FileInlineObject sentFile = getCoreMainClass().getSentFile(str);
        if (sentFile == null || sentFile.file_id <= 0) {
            return null;
        }
        String strSubstring = sentFile.file_name;
        if (!TextUtils.isEmpty(strSubstring)) {
            int iLastIndexOf = strSubstring.lastIndexOf(".");
            if (iLastIndexOf > 0) {
                strSubstring = strSubstring.substring(0, iLastIndexOf);
            }
            sentFile.file_name = strSubstring;
        }
        return MessageConverter.convertToMessageMedia(sentFile);
    }

    public void setAsMainAvatar(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_photos_updateProfilePhoto) {
            Utilities.fileQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.FileLoadProxy$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setAsMainAvatar$4(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setAsMainAvatar$4(TLObject tLObject, final RequestDelegate requestDelegate) {
        TLRPC$TL_photos_updateProfilePhoto tLRPC$TL_photos_updateProfilePhoto = (TLRPC$TL_photos_updateProfilePhoto) tLObject;
        getAccountInstance().getCoreMainClass().uploadAvatar(getAccountInstance().getCoreMainClass().getMyGuid(), String.valueOf(tLRPC$TL_photos_updateProfilePhoto.id.main_id), String.valueOf(tLRPC$TL_photos_updateProfilePhoto.id.thumb_id), new LoadListener<AvatarFileInline>(this) { // from class: androidMessenger.proxy.FileLoadProxy.7
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(AvatarFileInline avatarFileInline) {
                TLRPC$TL_photos_photo tLRPC$TL_photos_photo = new TLRPC$TL_photos_photo();
                tLRPC$TL_photos_photo.photo = MessageConverter.convertToPhoto(avatarFileInline, null, 0);
                requestDelegate.run(tLRPC$TL_photos_photo, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Fail Uploading Avatar";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }
}
