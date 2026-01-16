package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.media.ExifInterface;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.facebook.stetho.websocket.CloseCodes;
import com.pedro.encoder.input.video.Camera1ApiManager;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import ir.appp.rghapp.Utils;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.UIView.UI_rubinoCameraButtonCell;
import ir.resaneh1.iptv.UIView.UI_rubinoCameraTypeRow;
import ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity;
import ir.resaneh1.iptv.fragment.messanger.StorySettingsActivity;
import ir.resaneh1.iptv.fragment.rubino.RubinoController;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.StoryCameraSurfaceView;
import ir.resaneh1.iptv.helper.StoryEntityView;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.FragmentType;
import ir.resaneh1.iptv.model.RubinoCameraTypeItem;
import ir.resaneh1.iptv.model.StoryEntityItem;
import ir.resaneh1.iptv.model.StoryPositionObject;
import ir.resaneh1.iptv.model.WidgetStoryObject;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.Bitmaps;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.Utilities;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.LaunchActivity;

/* loaded from: classes3.dex */
public class StoryCameraFragment extends PresenterFragment implements MediaRecorder.OnInfoListener {
    public static int maxVideoPartDurationtInSecond = 15;
    public static int minVideoDurationInSecond = 1;
    private static final String[] neededPermissions = {"android.permission.CAMERA", "android.permission.RECORD_AUDIO"};
    private Camera camera;
    private UI_rubinoCameraButtonCell cameraButtonCell;
    private FrameLayout cameraContainer;
    private int cameraFacing;
    private String cameraResultPath;
    private StoryCameraSurfaceView cameraSurfaceview;
    private long clickStartTime;
    private float clickStartX;
    private float clickStartY;
    private RubinoCameraTypeItem.RubinoCameraTypeEnum currentSelectedCameraType;
    private ImageView imageViewFlash;
    private ImageView imageViewSetting;
    private boolean inClickProcess;
    private WidgetStoryObject initWidget;
    private boolean isCameraFlashOn;
    public boolean isLockScrollBecauseOfCamera;
    private boolean isRecording;
    private boolean isVideo;
    private ImageView leftBottomImageView;
    private int normalPosition;
    private DisposableObserver recordDisposable;
    private float screenHeight;
    private float screenWidth;
    private DisposableObserver startCameraDisposable;
    private StoryEntityView storyEntityView;
    private DisposableObserver trigerRecordDisposable;
    private FrameLayout widgetContainer;
    private final int CLICK_ACTION_THRESHOLD = AndroidUtilities.dp(2.0f);
    private long recordStartTime = -1;
    public boolean initTypeLive = false;
    StoryCameraSurfaceView.SurfaceChangeListener surfaceChangeListener = new StoryCameraSurfaceView.SurfaceChangeListener() { // from class: ir.resaneh1.iptv.fragment.StoryCameraFragment.12
        @Override // ir.resaneh1.iptv.helper.StoryCameraSurfaceView.SurfaceChangeListener
        public void onSurfaceCreated() {
            StoryCameraFragment.this.isLockScrollBecauseOfCamera = false;
        }

        @Override // ir.resaneh1.iptv.helper.StoryCameraSurfaceView.SurfaceChangeListener
        public void onZoomStarted() {
            StoryCameraFragment.this.isLockScrollBecauseOfCamera = true;
        }

        @Override // ir.resaneh1.iptv.helper.StoryCameraSurfaceView.SurfaceChangeListener
        public void onZoomFinished() {
            StoryCameraFragment.this.isLockScrollBecauseOfCamera = false;
        }
    };
    Camera.PictureCallback pictureCallback2 = new Camera.PictureCallback() { // from class: ir.resaneh1.iptv.fragment.StoryCameraFragment.14
        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(final byte[] bArr, Camera camera) {
            MyLog.e("StoryCameraFragment", "onPictureTaken " + (System.currentTimeMillis() - StoryCameraFragment.this.clickStartTime));
            ((PresenterFragment) StoryCameraFragment.this).compositeDisposable.add((Disposable) Observable.timer(10L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).doOnNext(new Consumer<Long>() { // from class: ir.resaneh1.iptv.fragment.StoryCameraFragment.14.4
                @Override // io.reactivex.functions.Consumer
                public void accept(Long l) throws Exception {
                    StoryCameraFragment.this.nextStep(null);
                }
            }).observeOn(Schedulers.computation()).doOnNext(new Consumer<Long>() { // from class: ir.resaneh1.iptv.fragment.StoryCameraFragment.14.3
                @Override // io.reactivex.functions.Consumer
                public void accept(Long l) throws Exception {
                    Bitmap bitmapRotateBitmap;
                    StoryCameraFragment.this.cameraResultPath = null;
                    String cameraImageOutputFilePath = Utils.getCameraImageOutputFilePath();
                    MyLog.e("StoryCameraFragment", "Path " + cameraImageOutputFilePath);
                    File file = new File(cameraImageOutputFilePath);
                    byte[] bArr2 = bArr;
                    Bitmap bitmapCopy = BitmapFactory.decodeByteArray(bArr2, 0, bArr2 != null ? bArr2.length : 0).copy(Bitmap.Config.ARGB_8888, true);
                    Matrix matrix = new Matrix();
                    matrix.setRotate(StoryCameraFragment.getOrientation(bArr) - StoryCameraFragment.this.cameraSurfaceview.basedOnSizeRotation);
                    Bitmap bitmapCreateBitmap = Bitmaps.createBitmap(bitmapCopy, 0, 0, bitmapCopy.getWidth(), bitmapCopy.getHeight(), matrix, false);
                    if (StoryCameraFragment.this.cameraFacing == 1) {
                        try {
                            bitmapRotateBitmap = StoryCameraFragment.this.cameraSurfaceview.isRotated() ? StoryCameraFragment.this.rotateBitmap(bitmapCreateBitmap, 4) : StoryCameraFragment.this.rotateBitmap(bitmapCreateBitmap, 2);
                        } catch (Exception unused) {
                        }
                    } else {
                        bitmapRotateBitmap = bitmapCreateBitmap;
                    }
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        bitmapRotateBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                        bitmapCreateBitmap.recycle();
                        file.createNewFile();
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        fileOutputStream.write(byteArrayOutputStream.toByteArray());
                        bitmapRotateBitmap.recycle();
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        StoryCameraFragment.this.cameraResultPath = file.getAbsolutePath();
                        MyLog.e("StoryCameraFragment ", "cameraResultPath " + StoryCameraFragment.this.cameraResultPath);
                        ExifInterface exifInterface = new ExifInterface(StoryCameraFragment.this.cameraResultPath);
                        exifInterface.setAttribute("Orientation", String.valueOf(6));
                        exifInterface.saveAttributes();
                    } catch (FileNotFoundException e) {
                        MyLog.e("StoryCameraFragment", "File not found: " + e.getMessage());
                    } catch (IOException e2) {
                        MyLog.e("StoryCameraFragment", "Error accessing file: " + e2.getMessage());
                    }
                }
            }).observeOn(AndroidSchedulers.mainThread()).doOnNext(new Consumer<Long>() { // from class: ir.resaneh1.iptv.fragment.StoryCameraFragment.14.2
                @Override // io.reactivex.functions.Consumer
                public void accept(Long l) throws Exception {
                    StoryCameraFragment.this.inClickProcess = false;
                    if (StoryCameraFragment.this.cameraResultPath != null) {
                        MyLog.e("StoryCameraFragment", "nextStep " + (System.currentTimeMillis() - StoryCameraFragment.this.clickStartTime));
                        StoryCameraFragment storyCameraFragment = StoryCameraFragment.this;
                        storyCameraFragment.refreshStory(storyCameraFragment.cameraResultPath);
                    }
                }
            }).subscribeWith(new DisposableObserver<Long>(this) { // from class: ir.resaneh1.iptv.fragment.StoryCameraFragment.14.1
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                }

                @Override // io.reactivex.Observer
                public void onNext(Long l) {
                }
            }));
        }
    };

    public StoryCameraFragment() {
        initFragmentParameters();
    }

    public StoryCameraFragment(WidgetStoryObject widgetStoryObject) {
        this.initWidget = widgetStoryObject;
        initFragmentParameters();
    }

    private void initFragmentParameters() {
        FragmentType fragmentType = FragmentType.Rubino;
        this.fragmentName = "StoryCameraFragment";
        if (DimensionHelper.isShowstoryNeedFullScreen()) {
            this.isFullScreen = true;
        }
        this.isForceBlackTheme = true;
        this.needLockOrientation = true;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        ((PresenterFragment) this).compositeDisposable = new CompositeDisposable();
        ActionBar actionBar = this.actionBar;
        if (actionBar != null) {
            actionBar.setVisibility(8);
        }
        this.mContext = context;
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        frameLayout.setBackgroundColor(context.getResources().getColor(R.color.black));
        FrameLayout frameLayout2 = (FrameLayout) this.fragmentView;
        Activity activity = (Activity) context;
        this.screenWidth = DimensionHelper.getScreenMinDimension(activity);
        this.screenHeight = DimensionHelper.getScreenMaxDimension(activity);
        new HashMap();
        FrameLayout frameLayout3 = new FrameLayout(context);
        this.cameraContainer = frameLayout3;
        frameLayout2.addView(frameLayout3, LayoutHelper.createFrame(-1, -1.0f));
        FrameLayout frameLayout4 = new FrameLayout(context);
        this.widgetContainer = frameLayout4;
        frameLayout2.addView(frameLayout4, new FrameLayout.LayoutParams(-1, (int) (DimensionHelper.getScreenWidth((Activity) this.mContext) * DimensionHelper.getStoryHWRatio())));
        WidgetStoryObject widgetStoryObject = this.initWidget;
        if (widgetStoryObject != null) {
            if (widgetStoryObject.type == WidgetStoryObject.WidgetTypeEnum.QuestionTest) {
                this.storyEntityView = new StoryEntityView(this.mContext);
                StoryEntityItem storyEntityItem = new StoryEntityItem();
                storyEntityItem.storyEntityType = StoryEntityItem.StoryEntityTypeEnum.questionShare;
                storyEntityItem.shareQuestionObject = this.initWidget.shareQuestionObject;
                this.storyEntityView.setOrEditEntityItem(storyEntityItem);
                this.widgetContainer.addView(this.storyEntityView, LayoutHelper.createFrame(-2, -2.0f, 1, 0.0f, DimensionHelper.pxToDp(context, this.screenHeight / 5.0f), 0.0f, 0.0f));
            }
            this.widgetContainer.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ir.resaneh1.iptv.fragment.StoryCameraFragment.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    WidgetStoryObject widgetStoryObject2 = StoryCameraFragment.this.initWidget;
                    StoryCameraFragment storyCameraFragment = StoryCameraFragment.this;
                    widgetStoryObject2.position = new StoryPositionObject(storyCameraFragment.mContext, storyCameraFragment.storyEntityView.getCenterX(), StoryCameraFragment.this.storyEntityView.getCenterY(), StoryCameraFragment.this.storyEntityView.getWidthAfterScale(), StoryCameraFragment.this.storyEntityView.getHeightAfterScale(), StoryCameraFragment.this.storyEntityView.getRotation());
                }
            });
        }
        ImageView imageView = new ImageView(context);
        imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.rubino_canvas_close));
        imageView.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.fragment.StoryCameraFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    ApplicationLoader.applicationActivity.onBackPressed();
                } catch (Exception unused) {
                }
            }
        });
        frameLayout2.addView(imageView, LayoutHelper.createFrame(48, 48.0f, 53, 0.0f, 8.0f, 8.0f, 0.0f));
        ImageView imageView2 = new ImageView(context);
        this.imageViewFlash = imageView2;
        imageView2.setImageDrawable(context.getResources().getDrawable(R.drawable.rubino_flash_off));
        this.imageViewFlash.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.StoryCameraFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StoryCameraFragment.this.isCameraFlashOn = !r2.isCameraFlashOn;
                StoryCameraFragment.this.setCameraFlashMode(false);
            }
        });
        frameLayout2.addView(this.imageViewFlash, LayoutHelper.createFrame(48, 48.0f, 49, 0.0f, 8.0f, 0.0f, 0.0f));
        ImageView imageView3 = new ImageView(context);
        this.imageViewSetting = imageView3;
        imageView3.setImageDrawable(context.getResources().getDrawable(R.drawable.story_settings));
        this.imageViewSetting.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.StoryCameraFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                StoryCameraFragment.this.presentFragment(new StorySettingsActivity(AppRubinoPreferences.getInstance(((BaseFragment) StoryCameraFragment.this).currentAccount).getInstaCurrentProfileObject()));
            }
        });
        frameLayout2.addView(this.imageViewSetting, LayoutHelper.createFrame(48, 48.0f, 51, 8.0f, 8.0f, 0.0f, 0.0f));
        UI_rubinoCameraButtonCell uI_rubinoCameraButtonCell = new UI_rubinoCameraButtonCell();
        this.cameraButtonCell = uI_rubinoCameraButtonCell;
        uI_rubinoCameraButtonCell.createView(activity);
        frameLayout2.addView(this.cameraButtonCell.view, LayoutHelper.createFrame(90, 90.0f, 81, 0.0f, 0.0f, 0.0f, 68.0f));
        this.cameraButtonCell.clickableArea.setOnTouchListener(new View.OnTouchListener() { // from class: ir.resaneh1.iptv.fragment.StoryCameraFragment.5
            /* JADX WARN: Removed duplicated region for block: B:12:0x0016  */
            /* JADX WARN: Removed duplicated region for block: B:34:0x00be  */
            @Override // android.view.View.OnTouchListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public boolean onTouch(android.view.View r9, android.view.MotionEvent r10) throws java.lang.IllegalStateException, java.lang.IllegalArgumentException {
                /*
                    Method dump skipped, instructions count: 261
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.fragment.StoryCameraFragment.AnonymousClass5.onTouch(android.view.View, android.view.MotionEvent):boolean");
            }
        });
        FrameLayout frameLayout5 = new FrameLayout(context);
        frameLayout5.setBackgroundColor(-2013265920);
        frameLayout2.addView(frameLayout5, LayoutHelper.createFrame(-1, 60, 80));
        ImageView imageView4 = new ImageView(context);
        imageView4.setImageDrawable(context.getResources().getDrawable(R.drawable.rubino_camera_flip));
        imageView4.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.StoryCameraFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) throws IOException {
                if (StoryCameraFragment.this.hasTwoCamera()) {
                    StoryCameraFragment.this.toggleCameraFrontAndBack();
                }
            }
        });
        frameLayout5.addView(imageView4, LayoutHelper.createFrame(44, 44.0f, 21, 0.0f, 0.0f, 16.0f, 0.0f));
        ImageView imageView5 = new ImageView(context);
        this.leftBottomImageView = imageView5;
        imageView5.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.fragment.StoryCameraFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        setLeftBottomImage(BuildConfig.FLAVOR, null);
        frameLayout5.addView(this.leftBottomImageView, LayoutHelper.createFrame(36, 36.0f, 19, 16.0f, 0.0f, 0.0f, 0.0f));
        UI_rubinoCameraTypeRow uI_rubinoCameraTypeRow = new UI_rubinoCameraTypeRow();
        ArrayList<RubinoCameraTypeItem> arrayList = new ArrayList<>();
        if (RubinoController.getInstance(this.currentAccount).hasPermissionAddLive()) {
            arrayList.add(new RubinoCameraTypeItem(RubinoCameraTypeItem.RubinoCameraTypeEnum.live));
        }
        RubinoCameraTypeItem.RubinoCameraTypeEnum rubinoCameraTypeEnum = RubinoCameraTypeItem.RubinoCameraTypeEnum.normal;
        arrayList.add(new RubinoCameraTypeItem(rubinoCameraTypeEnum));
        this.normalPosition = arrayList.size() - 1;
        arrayList.add(new RubinoCameraTypeItem(RubinoCameraTypeItem.RubinoCameraTypeEnum.handsFree));
        uI_rubinoCameraTypeRow.createView(activity, 60, arrayList, new UI_rubinoCameraTypeRow.SelectItemListener() { // from class: ir.resaneh1.iptv.fragment.StoryCameraFragment.8
            @Override // ir.resaneh1.iptv.UIView.UI_rubinoCameraTypeRow.SelectItemListener
            public void onSelectItem(RubinoCameraTypeItem rubinoCameraTypeItem) {
                MyLog.e("StoryCameraFragment", "select :" + rubinoCameraTypeItem.getName());
                if (rubinoCameraTypeItem.typeEnum == null) {
                    return;
                }
                StoryCameraFragment.this.stopCameraRecording();
                RubinoCameraTypeItem.RubinoCameraTypeEnum rubinoCameraTypeEnum2 = StoryCameraFragment.this.currentSelectedCameraType;
                RubinoCameraTypeItem.RubinoCameraTypeEnum rubinoCameraTypeEnum3 = rubinoCameraTypeItem.typeEnum;
                if (rubinoCameraTypeEnum2 != rubinoCameraTypeEnum3) {
                    StoryCameraFragment.this.currentSelectedCameraType = rubinoCameraTypeEnum3;
                    StoryCameraFragment.this.cameraButtonCell.setIconByCameraTypeAndState(StoryCameraFragment.this.currentSelectedCameraType, StoryCameraFragment.this.isRecording);
                }
            }
        });
        frameLayout5.addView(uI_rubinoCameraTypeRow.view, LayoutHelper.createFrame(-1, -1.0f, 17, 72.0f, 0.0f, 72.0f, 0.0f));
        this.cameraFacing = 1;
        if (MyLog.isDebugAble) {
            this.cameraFacing = 0;
        }
        this.isCameraFlashOn = false;
        this.isVideo = false;
        if (this.initTypeLive) {
            this.currentSelectedCameraType = RubinoCameraTypeItem.RubinoCameraTypeEnum.live;
            uI_rubinoCameraTypeRow.recyclerView.smoothScrollToPosition(0);
        } else {
            this.currentSelectedCameraType = rubinoCameraTypeEnum;
            RecyclerView recyclerView = uI_rubinoCameraTypeRow.recyclerView;
            int i = this.normalPosition;
            if (i < 0) {
                i = 0;
            }
            recyclerView.smoothScrollToPosition(i);
        }
        this.swipeBackEnabled = false;
        checkPermissions(true);
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLiveClicked() {
        Camera1ApiManager.staticCamera = this.camera;
        this.camera = null;
        this.cameraSurfaceview.mCamera = null;
        presentFragment(new LiveBroadCastActivity(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject(), this.cameraFacing), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStopRecordClick() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        stopCameraRecording();
        long j = this.recordStartTime;
        if (j > 0 && jCurrentTimeMillis - j > minVideoDurationInSecond * CloseCodes.NORMAL_CLOSURE) {
            String currentVideoPath = this.cameraSurfaceview.getCurrentVideoPath();
            this.cameraResultPath = currentVideoPath;
            if (currentVideoPath != null) {
                nextStep(currentVideoPath);
            }
        }
        this.recordStartTime = -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRecordClick() throws IllegalStateException, IllegalArgumentException {
        StoryCameraSurfaceView storyCameraSurfaceView;
        if (this.isRecording || (storyCameraSurfaceView = this.cameraSurfaceview) == null || storyCameraSurfaceView.mCamera == null) {
            return;
        }
        this.isRecording = true;
        this.cameraButtonCell.setIconByCameraTypeAndState(this.currentSelectedCameraType, true);
        this.isVideo = true;
        StoryCameraSurfaceView storyCameraSurfaceView2 = this.cameraSurfaceview;
        if (storyCameraSurfaceView2 != null) {
            storyCameraSurfaceView2.setPictureVideoMode(true);
            this.cameraSurfaceview.startRecord(60);
        }
        setCameraFlashMode(true);
        this.cameraButtonCell.setProgressWithAnimation(100, maxVideoPartDurationtInSecond * CloseCodes.NORMAL_CLOSURE);
        this.recordStartTime = System.currentTimeMillis();
        DisposableObserver disposableObserver = (DisposableObserver) Observable.timer(60L, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.StoryCameraFragment.9
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(Long l) {
                StoryCameraFragment.this.stopCameraRecording();
                StoryCameraFragment storyCameraFragment = StoryCameraFragment.this;
                storyCameraFragment.cameraResultPath = storyCameraFragment.cameraSurfaceview.getCurrentVideoPath();
                StoryCameraFragment storyCameraFragment2 = StoryCameraFragment.this;
                storyCameraFragment2.nextStep(storyCameraFragment2.cameraResultPath);
            }
        });
        this.recordDisposable = disposableObserver;
        ((PresenterFragment) this).compositeDisposable.add(disposableObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAClick(float f, float f2, float f3, float f4, long j) {
        float fAbs = Math.abs(f - f2);
        float fAbs2 = Math.abs(f3 - f4);
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        int i = this.CLICK_ACTION_THRESHOLD;
        boolean z = fAbs <= ((float) i) && fAbs2 <= ((float) i) && jCurrentTimeMillis <= 250;
        MyLog.e("StoryCameraFragment", z + " is click");
        return z;
    }

    public void stopCameraRecording() {
        DisposableObserver disposableObserver = this.trigerRecordDisposable;
        if (disposableObserver != null) {
            disposableObserver.dispose();
        }
        DisposableObserver disposableObserver2 = this.recordDisposable;
        if (disposableObserver2 != null) {
            disposableObserver2.dispose();
        }
        StoryCameraSurfaceView storyCameraSurfaceView = this.cameraSurfaceview;
        if (storyCameraSurfaceView != null) {
            storyCameraSurfaceView.stopRecord();
        }
        try {
            this.cameraButtonCell.setIconByCameraTypeAndState(this.currentSelectedCameraType, this.isRecording);
            this.cameraButtonCell.resetProgress(this.isRecording);
        } catch (Exception unused) {
        }
        this.isRecording = false;
        setCameraFlashMode(false);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        if (this.camera != null) {
            stopCameraRecording();
            releaseCamera();
        }
        return super.onBackPressed();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        Observable.timer(1000L, TimeUnit.MILLISECONDS).subscribe(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.StoryCameraFragment.10
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(Long l) {
                StoryCameraFragment.this.releaseCamera();
            }
        });
        super.onFragmentDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasTwoCamera() {
        return Camera.getNumberOfCameras() > 1;
    }

    public void setLeftBottomImage(String str, View.OnClickListener onClickListener) {
        this.leftBottomImageView.setBackground(this.mContext.getResources().getDrawable(R.drawable.shape_rectangle_white_conrner_8dp));
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.transforms(new CenterCrop(), new RoundedCorners(AndroidUtilities.dp(4.0f)));
        requestOptions.placeholder(R.drawable.shape_rectangle_grey_conrner_8dp);
        GlideHelper.loadPath(this.mContext, this.leftBottomImageView, str, requestOptions);
        this.leftBottomImageView.setPadding(AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f));
        if (onClickListener != null) {
            this.leftBottomImageView.setOnClickListener(onClickListener);
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        lockOrientationPortrait();
        DisposableObserver disposableObserver = (DisposableObserver) Observable.timer(550L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.StoryCameraFragment.11
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(Long l) {
                StoryCameraFragment.this.onResumeCamera();
            }
        });
        this.startCameraDisposable = disposableObserver;
        ((PresenterFragment) this).compositeDisposable.add(disposableObserver);
    }

    private int findFacingCamera(int i) {
        int numberOfCameras = Camera.getNumberOfCameras();
        int i2 = 0;
        int i3 = -1;
        while (true) {
            if (i2 >= numberOfCameras) {
                i2 = -1;
                break;
            }
            if (i2 == 0) {
                i3 = i2;
            }
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == i) {
                break;
            }
            i2++;
        }
        return i2 != -1 ? i2 : i3;
    }

    public static boolean checkPermissions(boolean z) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        LaunchActivity launchActivity = ApplicationLoader.applicationActivity;
        if (launchActivity == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : neededPermissions) {
            if (ContextCompat.checkSelfPermission(launchActivity, str) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() == 0) {
            return true;
        }
        if (z) {
            launchActivity.requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), 1034);
        }
        return false;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onRequestPermissionsResultFragment(int i, String[] strArr, int[] iArr) {
        if (i == 1034 && iArr != null && iArr.length > 0 && iArr[0] == 0) {
            if (this.camera == null) {
                startCamera();
            }
        } else if (i == 1034) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
            builder.setTitle(LocaleController.getString(R.string.AppName));
            builder.setMessage(LocaleController.formatString(R.string.StoryPermissions, LocaleController.getString(R.string.AppName)));
            builder.setNegativeButton(LocaleController.getString(R.string.PermissionOpenSettings), new DialogInterface.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.StoryCameraFragment$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    StoryCameraFragment.lambda$onRequestPermissionsResultFragment$0(dialogInterface, i2);
                }
            });
            builder.setPositiveButton(LocaleController.getString(R.string.OK), null);
            builder.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onRequestPermissionsResultFragment$0(DialogInterface dialogInterface, int i) {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + ApplicationLoader.applicationContext.getPackageName()));
            ApplicationLoader.applicationActivity.startActivity(intent);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void onResumeCamera() {
        StoryCameraSurfaceView storyCameraSurfaceView;
        if (checkPermissions(false)) {
            Camera camera = this.camera;
            if (camera != null && (storyCameraSurfaceView = this.cameraSurfaceview) != null && storyCameraSurfaceView.mCamera != null) {
                try {
                    camera.reconnect();
                    this.camera.startPreview();
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            startCamera();
        }
    }

    public void onPauseCamera() {
        if (this.camera != null) {
            stopCamera();
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        DisposableObserver disposableObserver = this.startCameraDisposable;
        if (disposableObserver != null) {
            disposableObserver.dispose();
        }
        onPauseCamera();
    }

    public StoryPositionObject getInitWidgetPosition() {
        WidgetStoryObject widgetStoryObject = this.initWidget;
        if (widgetStoryObject != null) {
            return widgetStoryObject.position;
        }
        return null;
    }

    private void startCamera() throws IOException {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        this.isLockScrollBecauseOfCamera = true;
        try {
            this.camera = Camera.open(findFacingCamera(this.cameraFacing));
        } catch (Exception unused) {
        }
        Camera camera = this.camera;
        if (camera == null) {
            this.isLockScrollBecauseOfCamera = false;
        }
        if (camera != null) {
            this.cameraSurfaceview = new StoryCameraSurfaceView(ApplicationLoader.applicationActivity, this.camera, this.cameraFacing, this.isVideo, this.surfaceChangeListener);
        }
        if (this.cameraSurfaceview != null) {
            this.cameraContainer.removeAllViews();
            float backCameraPictureSizeHWRatio = this.cameraSurfaceview.getBackCameraPictureSizeHWRatio();
            float f = this.screenWidth;
            float f2 = backCameraPictureSizeHWRatio * f;
            MyLog.e("StoryCameraFragment", "startCamera screen " + this.screenWidth + " " + this.screenHeight);
            MyLog.e("StoryCameraFragment", "startCamera " + backCameraPictureSizeHWRatio + " " + f + " " + f2);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) f, (int) f2);
            layoutParams.gravity = 49;
            this.cameraContainer.addView(this.cameraSurfaceview, layoutParams);
            Camera camera2 = this.camera;
            if (camera2 != null) {
                this.cameraSurfaceview.refreshCamera(camera2);
                setCameraFlashMode(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCameraFlashMode(boolean z) {
        if (this.camera != null) {
            try {
                if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera.flash")) {
                    this.imageViewFlash.setVisibility(0);
                    Camera.Parameters parameters = this.camera.getParameters();
                    if (this.isCameraFlashOn) {
                        if (z) {
                            parameters.setFlashMode("torch");
                        } else {
                            parameters.setFlashMode("on");
                        }
                        this.imageViewFlash.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.rubino_flash_on));
                    } else {
                        parameters.setFlashMode("off");
                        this.imageViewFlash.setImageDrawable(this.mContext.getResources().getDrawable(R.drawable.rubino_flash_off));
                    }
                    this.camera.setParameters(parameters);
                    return;
                }
                this.imageViewFlash.setVisibility(8);
            } catch (Exception unused) {
            }
        }
    }

    private void stopCamera() {
        stopCameraRecording();
        if (this.camera != null) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.resaneh1.iptv.fragment.StoryCameraFragment.13
                @Override // java.lang.Runnable
                public void run() {
                    if (StoryCameraFragment.this.camera != null) {
                        try {
                            StoryCameraFragment.this.camera.stopPreview();
                            StoryCameraFragment.this.camera.unlock();
                        } catch (Exception unused) {
                        }
                    }
                }
            });
        }
        this.isLockScrollBecauseOfCamera = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseCamera() {
        if (this.camera != null) {
            this.cameraContainer.removeAllViews();
            this.camera.release();
            this.camera = null;
        }
        this.isLockScrollBecauseOfCamera = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleCameraFrontAndBack() throws IOException {
        stopCameraRecording();
        releaseCamera();
        this.cameraFacing = this.cameraFacing == 0 ? 1 : 0;
        if (checkPermissions(false)) {
            startCamera();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void takePicture() {
        if (this.inClickProcess) {
            return;
        }
        this.inClickProcess = true;
        this.isVideo = false;
        MyLog.e("StoryCameraFragment", "takePicture 2 " + (System.currentTimeMillis() - this.clickStartTime));
        StoryCameraSurfaceView storyCameraSurfaceView = this.cameraSurfaceview;
        if (storyCameraSurfaceView != null) {
            storyCameraSurfaceView.setPictureVideoMode(this.isVideo);
        }
        MyLog.e("StoryCameraFragment", "takePicture 3 " + (System.currentTimeMillis() - this.clickStartTime));
        Camera camera = this.camera;
        if (camera != null) {
            try {
                camera.takePicture(null, null, this.pictureCallback2);
                return;
            } catch (Exception unused) {
                this.inClickProcess = false;
                return;
            }
        }
        this.inClickProcess = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nextStep(String str) {
        if (this.initWidget != null) {
            float storyHWRatio = 1.0f / DimensionHelper.getStoryHWRatio();
            if (str == null) {
                presentFragment(new AddStoryFragment(this.initWidget, storyHWRatio));
            } else {
                presentFragment(new AddStoryFragment(str, this.isVideo, this.initWidget, storyHWRatio));
            }
        } else if (str == null) {
            presentFragment(new AddStoryFragment());
        } else {
            presentFragment(new AddStoryFragment(str, this.isVideo));
        }
        this.inClickProcess = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshStory(String str) throws Throwable {
        BaseFragment lastFragment = ApplicationLoader.applicationActivity.getLastFragment();
        if (lastFragment instanceof AddStoryFragment) {
            ((AddStoryFragment) lastFragment).setMediaAndInit(str, this.isVideo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005c, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x005f, code lost:
    
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0060, code lost:
    
        r3 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int getOrientation(byte[] r10) {
        /*
            Method dump skipped, instructions count: 186
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.fragment.StoryCameraFragment.getOrientation(byte[]):int");
    }

    private static int pack(byte[] bArr, int i, int i2, boolean z) {
        int i3;
        if (z) {
            i += i2 - 1;
            i3 = -1;
        } else {
            i3 = 1;
        }
        int i4 = 0;
        while (true) {
            int i5 = i2 - 1;
            if (i2 <= 0) {
                return i4;
            }
            i4 = (bArr[i] & 255) | (i4 << 8);
            i += i3;
            i2 = i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap rotateBitmap(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        switch (i) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
            default:
                return bitmap;
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            bitmap.recycle();
            return bitmapCreateBitmap;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // android.media.MediaRecorder.OnInfoListener
    public void onInfo(MediaRecorder mediaRecorder, int i, int i2) throws IllegalStateException {
        if ((i == 800 || i == 801 || i == 1) && mediaRecorder != null) {
            mediaRecorder.stop();
            mediaRecorder.release();
        }
    }
}
