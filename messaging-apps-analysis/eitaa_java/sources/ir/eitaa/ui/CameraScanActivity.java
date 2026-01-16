package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Property;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.common.GlobalHistogramBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLoader;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MrzRecognizer;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SendMessagesHelper;
import ir.eitaa.messenger.camera.CameraController;
import ir.eitaa.messenger.camera.CameraSession;
import ir.eitaa.messenger.camera.CameraView;
import ir.eitaa.messenger.camera.Size;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarLayout;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Components.AnimationProperties;
import ir.eitaa.ui.Components.CubicBezierInterpolator;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.PhotoAlbumPickerActivity;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.linphone.mediastream.Factory;

@TargetApi(18)
/* loaded from: classes3.dex */
public class CameraScanActivity extends BaseFragment implements Camera.PreviewCallback {
    private CameraView cameraView;
    private int currentType;
    private CameraScanActivityDelegate delegate;
    private TextView descriptionText;
    private AnimatorSet flashAnimator;
    private ImageView flashButton;
    private ImageView galleryButton;
    private Handler handler;
    private boolean needGalleryButton;
    private QRCodeReader qrReader;
    private boolean recognized;
    private TextView recognizedMrzView;
    private TextView titleTextView;
    private BarcodeDetector visionQrReader;
    private HandlerThread backgroundHandlerThread = new HandlerThread("ScanCamera");
    private Paint paint = new Paint();
    private Paint cornerPaint = new Paint(1);
    private Path path = new Path();
    public boolean isEitaaPay = false;

    public interface CameraScanActivityDelegate {

        /* renamed from: ir.eitaa.ui.CameraScanActivity$CameraScanActivityDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$didFindMrzInfo(CameraScanActivityDelegate cameraScanActivityDelegate, MrzRecognizer.Result result) {
            }

            public static void $default$didFindQr(CameraScanActivityDelegate cameraScanActivityDelegate, String str) {
            }
        }

        void didFindMrzInfo(MrzRecognizer.Result result);

        void didFindQr(String text);
    }

    static /* synthetic */ boolean lambda$createView$1(View view, MotionEvent motionEvent) {
        return true;
    }

    static /* synthetic */ void lambda$new$0() {
    }

    public static ActionBarLayout[] showAsSheet(BaseFragment parentFragment, boolean gallery, CameraScanActivityDelegate delegate) {
        if (parentFragment == null || parentFragment.getParentActivity() == null) {
            return null;
        }
        ActionBarLayout[] actionBarLayoutArr = {new ActionBarLayout(parentFragment.getParentActivity())};
        new AnonymousClass1(parentFragment.getParentActivity(), false, actionBarLayoutArr, gallery, delegate).show();
        return actionBarLayoutArr;
    }

    /* renamed from: ir.eitaa.ui.CameraScanActivity$1, reason: invalid class name */
    class AnonymousClass1 extends BottomSheet {
        final /* synthetic */ ActionBarLayout[] val$actionBarLayout;
        final /* synthetic */ CameraScanActivityDelegate val$delegate;
        final /* synthetic */ boolean val$gallery;

        @Override // ir.eitaa.ui.ActionBar.BottomSheet
        protected boolean canDismissWithSwipe() {
            return false;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context, boolean needFocus, final ActionBarLayout[] val$actionBarLayout, final boolean val$gallery, final CameraScanActivityDelegate val$delegate) {
            super(context, needFocus);
            this.val$actionBarLayout = val$actionBarLayout;
            this.val$gallery = val$gallery;
            this.val$delegate = val$delegate;
            val$actionBarLayout[0].init(new ArrayList<>());
            final CameraScanActivity cameraScanActivity = new CameraScanActivity(1) { // from class: ir.eitaa.ui.CameraScanActivity.1.1
                @Override // ir.eitaa.ui.ActionBar.BaseFragment
                public void finishFragment() {
                    AnonymousClass1.this.dismiss();
                }

                @Override // ir.eitaa.ui.ActionBar.BaseFragment
                public void removeSelfFromStack() {
                    AnonymousClass1.this.dismiss();
                }
            };
            cameraScanActivity.needGalleryButton = val$gallery;
            val$actionBarLayout[0].addFragmentToStack(cameraScanActivity);
            val$actionBarLayout[0].showLastFragment();
            ActionBarLayout actionBarLayout = val$actionBarLayout[0];
            int i = this.backgroundPaddingLeft;
            actionBarLayout.setPadding(i, 0, i, 0);
            cameraScanActivity.setDelegate(val$delegate);
            this.containerView = val$actionBarLayout[0];
            setApplyBottomPadding(false);
            setApplyBottomPadding(false);
            setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.-$$Lambda$CameraScanActivity$1$faWM8f1q6MqrQqhVnhfZbEet6uY
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) throws InterruptedException {
                    cameraScanActivity.onFragmentDestroy();
                }
            });
        }

        @Override // android.app.Dialog
        public void onBackPressed() {
            ActionBarLayout[] actionBarLayoutArr = this.val$actionBarLayout;
            if (actionBarLayoutArr[0] == null || actionBarLayoutArr[0].fragmentsStack.size() <= 1) {
                super.onBackPressed();
            } else {
                this.val$actionBarLayout[0].onBackPressed();
            }
        }

        @Override // ir.eitaa.ui.ActionBar.BottomSheet, android.app.Dialog, android.content.DialogInterface
        public void dismiss() {
            super.dismiss();
            this.val$actionBarLayout[0] = null;
        }
    }

    public CameraScanActivity(int type) {
        CameraController.getInstance().initCamera(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$CameraScanActivity$goAwTI8aldj7aAXAPNSLWTDj4zA
            @Override // java.lang.Runnable
            public final void run() {
                CameraScanActivity.lambda$new$0();
            }
        });
        this.currentType = type;
        if (type == 1) {
            this.qrReader = new QRCodeReader();
            this.visionQrReader = new BarcodeDetector.Builder(ApplicationLoader.applicationContext).setBarcodeFormats(Factory.DEVICE_HAS_CRAPPY_OPENSLES).build();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        destroy(false, null);
        if (getParentActivity() != null) {
            getParentActivity().setRequestedOrientation(-1);
        }
        BarcodeDetector barcodeDetector = this.visionQrReader;
        if (barcodeDetector != null) {
            barcodeDetector.release();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        return super.onFragmentCreate();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setItemsColor(Theme.getColor("windowBackgroundWhiteGrayText2"), false);
        this.actionBar.setItemsBackgroundColor(Theme.getColor("actionBarWhiteSelector"), false);
        this.actionBar.setCastShadows(false);
        if (!AndroidUtilities.isTablet() && this.currentType != 1) {
            this.actionBar.showActionModeTop();
        }
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.CameraScanActivity.2
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    CameraScanActivity.this.finishFragment();
                }
            }
        });
        this.paint.setColor(2130706432);
        this.cornerPaint.setColor(-1);
        this.cornerPaint.setStyle(Paint.Style.STROKE);
        this.cornerPaint.setStrokeWidth(AndroidUtilities.dp(4.0f));
        this.cornerPaint.setStrokeJoin(Paint.Join.ROUND);
        ViewGroup viewGroup = new ViewGroup(context) { // from class: ir.eitaa.ui.CameraScanActivity.3
            @Override // android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                int size = View.MeasureSpec.getSize(widthMeasureSpec);
                int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
                ((BaseFragment) CameraScanActivity.this).actionBar.measure(widthMeasureSpec, heightMeasureSpec);
                if (CameraScanActivity.this.currentType == 0) {
                    CameraScanActivity.this.cameraView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (size * 0.704f), 1073741824));
                } else {
                    CameraScanActivity.this.cameraView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
                    CameraScanActivity.this.recognizedMrzView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 0));
                    if (CameraScanActivity.this.galleryButton != null) {
                        CameraScanActivity.this.galleryButton.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(60.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(60.0f), 1073741824));
                    }
                    CameraScanActivity.this.flashButton.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(60.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(60.0f), 1073741824));
                }
                CameraScanActivity.this.titleTextView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 0));
                CameraScanActivity.this.descriptionText.measure(View.MeasureSpec.makeMeasureSpec((int) (size * 0.9f), 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 0));
                setMeasuredDimension(size, size2);
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int l, int t, int r, int b) {
                int i = r - l;
                int i2 = b - t;
                if (CameraScanActivity.this.currentType == 0) {
                    CameraScanActivity.this.cameraView.layout(0, 0, CameraScanActivity.this.cameraView.getMeasuredWidth(), CameraScanActivity.this.cameraView.getMeasuredHeight() + 0);
                    int i3 = (int) (i2 * 0.65f);
                    CameraScanActivity.this.titleTextView.layout(0, i3, CameraScanActivity.this.titleTextView.getMeasuredWidth(), CameraScanActivity.this.titleTextView.getMeasuredHeight() + i3);
                    CameraScanActivity.this.recognizedMrzView.setTextSize(0, CameraScanActivity.this.cameraView.getMeasuredHeight() / 22);
                    CameraScanActivity.this.recognizedMrzView.setPadding(0, 0, 0, CameraScanActivity.this.cameraView.getMeasuredHeight() / 15);
                } else {
                    ((BaseFragment) CameraScanActivity.this).actionBar.layout(0, 0, ((BaseFragment) CameraScanActivity.this).actionBar.getMeasuredWidth(), ((BaseFragment) CameraScanActivity.this).actionBar.getMeasuredHeight());
                    CameraScanActivity.this.cameraView.layout(0, 0, CameraScanActivity.this.cameraView.getMeasuredWidth(), CameraScanActivity.this.cameraView.getMeasuredHeight());
                    int iMin = (int) (Math.min(CameraScanActivity.this.cameraView.getWidth(), CameraScanActivity.this.cameraView.getHeight()) / 1.5f);
                    int measuredHeight = (((CameraScanActivity.this.cameraView.getMeasuredHeight() - iMin) / 2) - CameraScanActivity.this.titleTextView.getMeasuredHeight()) - AndroidUtilities.dp(30.0f);
                    CameraScanActivity.this.titleTextView.layout(0, measuredHeight, CameraScanActivity.this.titleTextView.getMeasuredWidth(), CameraScanActivity.this.titleTextView.getMeasuredHeight() + measuredHeight);
                    CameraScanActivity.this.recognizedMrzView.layout(0, getMeasuredHeight() - CameraScanActivity.this.recognizedMrzView.getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight());
                    int measuredWidth = CameraScanActivity.this.needGalleryButton ? (CameraScanActivity.this.cameraView.getMeasuredWidth() / 2) + AndroidUtilities.dp(35.0f) : (CameraScanActivity.this.cameraView.getMeasuredWidth() / 2) - (CameraScanActivity.this.flashButton.getMeasuredWidth() / 2);
                    int measuredHeight2 = ((CameraScanActivity.this.cameraView.getMeasuredHeight() - iMin) / 2) + iMin + AndroidUtilities.dp(30.0f);
                    CameraScanActivity.this.flashButton.layout(measuredWidth, measuredHeight2, CameraScanActivity.this.flashButton.getMeasuredWidth() + measuredWidth, CameraScanActivity.this.flashButton.getMeasuredHeight() + measuredHeight2);
                    if (CameraScanActivity.this.galleryButton != null) {
                        int measuredWidth2 = ((CameraScanActivity.this.cameraView.getMeasuredWidth() / 2) - AndroidUtilities.dp(35.0f)) - CameraScanActivity.this.galleryButton.getMeasuredWidth();
                        CameraScanActivity.this.galleryButton.layout(measuredWidth2, measuredHeight2, CameraScanActivity.this.galleryButton.getMeasuredWidth() + measuredWidth2, CameraScanActivity.this.galleryButton.getMeasuredHeight() + measuredHeight2);
                    }
                }
                int i4 = (int) (i2 * 0.74f);
                int i5 = (int) (i * 0.05f);
                CameraScanActivity.this.descriptionText.layout(i5, i4, CameraScanActivity.this.descriptionText.getMeasuredWidth() + i5, CameraScanActivity.this.descriptionText.getMeasuredHeight() + i4);
            }

            @Override // android.view.ViewGroup
            protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
                boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
                if (CameraScanActivity.this.currentType != 1 || child != CameraScanActivity.this.cameraView) {
                    return zDrawChild;
                }
                int iMin = (int) (Math.min(child.getWidth(), child.getHeight()) / 1.5f);
                int width = (child.getWidth() - iMin) / 2;
                int height = (child.getHeight() - iMin) / 2;
                float f = height;
                canvas.drawRect(0.0f, 0.0f, child.getMeasuredWidth(), f, CameraScanActivity.this.paint);
                float f2 = height + iMin;
                canvas.drawRect(0.0f, f2, child.getMeasuredWidth(), child.getMeasuredHeight(), CameraScanActivity.this.paint);
                float f3 = width;
                canvas.drawRect(0.0f, f, f3, f2, CameraScanActivity.this.paint);
                float f4 = iMin + width;
                canvas.drawRect(f4, f, child.getMeasuredWidth(), f2, CameraScanActivity.this.paint);
                CameraScanActivity.this.path.reset();
                CameraScanActivity.this.path.moveTo(f3, AndroidUtilities.dp(20.0f) + height);
                CameraScanActivity.this.path.lineTo(f3, f);
                CameraScanActivity.this.path.lineTo(AndroidUtilities.dp(20.0f) + width, f);
                canvas.drawPath(CameraScanActivity.this.path, CameraScanActivity.this.cornerPaint);
                CameraScanActivity.this.path.reset();
                CameraScanActivity.this.path.moveTo(f4, height + AndroidUtilities.dp(20.0f));
                CameraScanActivity.this.path.lineTo(f4, f);
                CameraScanActivity.this.path.lineTo(r10 - AndroidUtilities.dp(20.0f), f);
                canvas.drawPath(CameraScanActivity.this.path, CameraScanActivity.this.cornerPaint);
                CameraScanActivity.this.path.reset();
                CameraScanActivity.this.path.moveTo(f3, r14 - AndroidUtilities.dp(20.0f));
                CameraScanActivity.this.path.lineTo(f3, f2);
                CameraScanActivity.this.path.lineTo(width + AndroidUtilities.dp(20.0f), f2);
                canvas.drawPath(CameraScanActivity.this.path, CameraScanActivity.this.cornerPaint);
                CameraScanActivity.this.path.reset();
                CameraScanActivity.this.path.moveTo(f4, r14 - AndroidUtilities.dp(20.0f));
                CameraScanActivity.this.path.lineTo(f4, f2);
                CameraScanActivity.this.path.lineTo(r10 - AndroidUtilities.dp(20.0f), f2);
                canvas.drawPath(CameraScanActivity.this.path, CameraScanActivity.this.cornerPaint);
                return zDrawChild;
            }
        };
        viewGroup.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.-$$Lambda$CameraScanActivity$FGYHCT_efQ5B5A-tAsSMgvs3Iho
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return CameraScanActivity.lambda$createView$1(view, motionEvent);
            }
        });
        this.fragmentView = viewGroup;
        CameraView cameraView = new CameraView(context, false);
        this.cameraView = cameraView;
        cameraView.setUseMaxPreview(true);
        this.cameraView.setOptimizeForBarcode(true);
        this.cameraView.setDelegate(new CameraView.CameraViewDelegate() { // from class: ir.eitaa.ui.CameraScanActivity.4
            @Override // ir.eitaa.messenger.camera.CameraView.CameraViewDelegate
            public void onCameraCreated(Camera camera) {
            }

            @Override // ir.eitaa.messenger.camera.CameraView.CameraViewDelegate
            public void onCameraInit() {
                CameraScanActivity.this.startRecognizing();
            }
        });
        viewGroup.addView(this.cameraView, LayoutHelper.createFrame(-1, -1.0f));
        if (this.currentType == 0) {
            this.actionBar.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            this.fragmentView.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        } else {
            this.actionBar.setBackgroundDrawable(null);
            this.actionBar.setAddToContainer(false);
            this.actionBar.setItemsColor(-1, false);
            this.actionBar.setItemsBackgroundColor(587202559, false);
            viewGroup.setBackgroundColor(Theme.getColor("wallet_blackBackground"));
            viewGroup.addView(this.actionBar);
        }
        TextView textView = new TextView(context);
        this.titleTextView = textView;
        textView.setGravity(1);
        this.titleTextView.setTextSize(1, 24.0f);
        this.titleTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        viewGroup.addView(this.titleTextView);
        TextView textView2 = new TextView(context);
        this.descriptionText = textView2;
        textView2.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText6"));
        this.descriptionText.setGravity(1);
        this.descriptionText.setTextSize(1, 16.0f);
        this.descriptionText.setTypeface(AndroidUtilities.getFontFamily(false));
        viewGroup.addView(this.descriptionText);
        TextView textView3 = new TextView(context);
        this.recognizedMrzView = textView3;
        textView3.setTextColor(-1);
        this.recognizedMrzView.setGravity(81);
        this.recognizedMrzView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.recognizedMrzView.setAlpha(0.0f);
        if (this.currentType == 0) {
            this.titleTextView.setText(LocaleController.getString("PassportScanPassport", R.string.PassportScanPassport));
            this.descriptionText.setText(LocaleController.getString("PassportScanPassportInfo", R.string.PassportScanPassportInfo));
            this.titleTextView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.recognizedMrzView.setTypeface(Typeface.MONOSPACE);
            this.cameraView.addView(this.recognizedMrzView);
        } else {
            if (!this.needGalleryButton) {
                this.titleTextView.setText(LocaleController.getString("AuthAnotherClientScan", R.string.AuthAnotherClientScan));
            }
            this.titleTextView.setTextColor(-1);
            this.recognizedMrzView.setTextSize(1, 16.0f);
            this.recognizedMrzView.setPadding(AndroidUtilities.dp(10.0f), 0, AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f));
            if (!this.needGalleryButton) {
                this.recognizedMrzView.setText(LocaleController.getString("AuthAnotherClientNotFound", R.string.AuthAnotherClientNotFound));
            }
            viewGroup.addView(this.recognizedMrzView);
            if (this.needGalleryButton) {
                ImageView imageView = new ImageView(context);
                this.galleryButton = imageView;
                imageView.setScaleType(ImageView.ScaleType.CENTER);
                this.galleryButton.setImageResource(R.drawable.qr_gallery);
                this.galleryButton.setBackgroundDrawable(Theme.createSelectorDrawableFromDrawables(Theme.createCircleDrawable(AndroidUtilities.dp(60.0f), 587202559), Theme.createCircleDrawable(AndroidUtilities.dp(60.0f), 1157627903)));
                viewGroup.addView(this.galleryButton);
                this.galleryButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$CameraScanActivity$jp5eaKf3Dh1uOqdEKDPewiLmTL0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$createView$2$CameraScanActivity(view);
                    }
                });
            }
            ImageView imageView2 = new ImageView(context);
            this.flashButton = imageView2;
            imageView2.setScaleType(ImageView.ScaleType.CENTER);
            this.flashButton.setImageResource(R.drawable.qr_flashlight);
            this.flashButton.setBackgroundDrawable(Theme.createCircleDrawable(AndroidUtilities.dp(60.0f), 587202559));
            viewGroup.addView(this.flashButton);
            this.flashButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$CameraScanActivity$Vy7668OSyoWAVApc1ATkW9OJJPs
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$createView$4$CameraScanActivity(view);
                }
            });
        }
        if (getParentActivity() != null) {
            getParentActivity().setRequestedOrientation(1);
        }
        this.fragmentView.setKeepScreenOn(true);
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$2$CameraScanActivity(View view) {
        if (getParentActivity() == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23 && getParentActivity().checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
            getParentActivity().requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 4);
            return;
        }
        PhotoAlbumPickerActivity photoAlbumPickerActivity = new PhotoAlbumPickerActivity(PhotoAlbumPickerActivity.SELECT_TYPE_QR, false, false, null);
        photoAlbumPickerActivity.setMaxSelectedPhotos(1, false);
        photoAlbumPickerActivity.setAllowSearchImages(false);
        photoAlbumPickerActivity.setDelegate(new PhotoAlbumPickerActivity.PhotoAlbumPickerActivityDelegate() { // from class: ir.eitaa.ui.CameraScanActivity.5
            @Override // ir.eitaa.ui.PhotoAlbumPickerActivity.PhotoAlbumPickerActivityDelegate
            public void didSelectPhotos(ArrayList<SendMessagesHelper.SendingMediaInfo> photos, boolean notify, int scheduleDate) {
                try {
                    if (photos.isEmpty()) {
                        return;
                    }
                    SendMessagesHelper.SendingMediaInfo sendingMediaInfo = photos.get(0);
                    if (sendingMediaInfo.path != null) {
                        Point realScreenSize = AndroidUtilities.getRealScreenSize();
                        String strTryReadQr = CameraScanActivity.this.tryReadQr(null, null, 0, 0, 0, ImageLoader.loadBitmap(sendingMediaInfo.path, null, realScreenSize.x, realScreenSize.y, true));
                        if (strTryReadQr != null) {
                            if (CameraScanActivity.this.delegate != null) {
                                CameraScanActivity.this.delegate.didFindQr(strTryReadQr);
                            }
                            CameraScanActivity.this.removeSelfFromStack();
                        }
                    }
                } catch (Throwable th) {
                    FileLog.e(th);
                }
            }

            @Override // ir.eitaa.ui.PhotoAlbumPickerActivity.PhotoAlbumPickerActivityDelegate
            public void startPhotoSelectActivity() {
                try {
                    Intent intent = new Intent("android.intent.action.PICK");
                    intent.setType("image/*");
                    CameraScanActivity.this.getParentActivity().startActivityForResult(intent, 11);
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
        });
        presentFragment(photoAlbumPickerActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$4$CameraScanActivity(View view) {
        CameraSession cameraSession = this.cameraView.getCameraSession();
        if (cameraSession != null) {
            ShapeDrawable shapeDrawable = (ShapeDrawable) this.flashButton.getBackground();
            AnimatorSet animatorSet = this.flashAnimator;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.flashAnimator = null;
            }
            this.flashAnimator = new AnimatorSet();
            Property<ShapeDrawable, Integer> property = AnimationProperties.SHAPE_DRAWABLE_ALPHA;
            int[] iArr = new int[1];
            iArr[0] = this.flashButton.getTag() == null ? 68 : 34;
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(shapeDrawable, property, iArr);
            objectAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$CameraScanActivity$3PXcgvpUu8ONC7iM0jsTA5RvTtY
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$createView$3$CameraScanActivity(valueAnimator);
                }
            });
            this.flashAnimator.playTogether(objectAnimatorOfInt);
            this.flashAnimator.setDuration(200L);
            this.flashAnimator.setInterpolator(CubicBezierInterpolator.DEFAULT);
            this.flashAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.CameraScanActivity.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    CameraScanActivity.this.flashAnimator = null;
                }
            });
            this.flashAnimator.start();
            if (this.flashButton.getTag() == null) {
                this.flashButton.setTag(1);
                cameraSession.setTorchEnabled(true);
            } else {
                this.flashButton.setTag(null);
                cameraSession.setTorchEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$3$CameraScanActivity(ValueAnimator valueAnimator) {
        this.flashButton.invalidate();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onActivityResultFragment(int requestCode, int resultCode, Intent data) {
        if (resultCode != -1 || requestCode != 11 || data == null || data.getData() == null) {
            return;
        }
        try {
            Point realScreenSize = AndroidUtilities.getRealScreenSize();
            String strTryReadQr = tryReadQr(null, null, 0, 0, 0, ImageLoader.loadBitmap(null, data.getData(), realScreenSize.x, realScreenSize.y, true));
            if (strTryReadQr != null) {
                CameraScanActivityDelegate cameraScanActivityDelegate = this.delegate;
                if (cameraScanActivityDelegate != null) {
                    cameraScanActivityDelegate.didFindQr(strTryReadQr);
                }
                finishFragment();
            }
        } catch (Throwable th) {
            FileLog.e(th);
        }
    }

    public void setDelegate(CameraScanActivityDelegate cameraScanActivityDelegate) {
        this.delegate = cameraScanActivityDelegate;
    }

    public void destroy(boolean async, final Runnable beforeDestroyRunnable) {
        CameraView cameraView = this.cameraView;
        if (cameraView != null) {
            cameraView.destroy(async, beforeDestroyRunnable);
            this.cameraView = null;
        }
        this.backgroundHandlerThread.quitSafely();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRecognizing() {
        this.backgroundHandlerThread.start();
        this.handler = new Handler(this.backgroundHandlerThread.getLooper());
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.CameraScanActivity.7
            @Override // java.lang.Runnable
            public void run() {
                if (CameraScanActivity.this.cameraView == null || CameraScanActivity.this.recognized || CameraScanActivity.this.cameraView.getCameraSession() == null) {
                    return;
                }
                CameraScanActivity.this.cameraView.getCameraSession().setOneShotPreviewCallback(CameraScanActivity.this);
                AndroidUtilities.runOnUIThread(this, 500L);
            }
        });
    }

    private void onNoQrFound() {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$CameraScanActivity$PHaZtJUrYQ9DB-wTiIQRgDjgFxY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onNoQrFound$5$CameraScanActivity();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onNoQrFound$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onNoQrFound$5$CameraScanActivity() {
        if (this.recognizedMrzView.getTag() != null) {
            this.recognizedMrzView.setTag(null);
            this.recognizedMrzView.animate().setDuration(200L).alpha(0.0f).setInterpolator(CubicBezierInterpolator.DEFAULT).start();
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(final byte[] data, final Camera camera) {
        this.handler.post(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$CameraScanActivity$XT4Yizx9VU5widho3MUGhbVckfM
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onPreviewFrame$8$CameraScanActivity(data, camera);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onPreviewFrame$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onPreviewFrame$8$CameraScanActivity(byte[] bArr, Camera camera) {
        try {
            Size previewSize = this.cameraView.getPreviewSize();
            if (this.currentType == 0) {
                final MrzRecognizer.Result resultRecognize = MrzRecognizer.recognize(bArr, previewSize.getWidth(), previewSize.getHeight(), this.cameraView.getCameraSession().getDisplayOrientation());
                if (resultRecognize != null && !TextUtils.isEmpty(resultRecognize.firstName) && !TextUtils.isEmpty(resultRecognize.lastName) && !TextUtils.isEmpty(resultRecognize.number) && resultRecognize.birthDay != 0 && ((resultRecognize.expiryDay != 0 || resultRecognize.doesNotExpire) && resultRecognize.gender != 0)) {
                    this.recognized = true;
                    camera.stopPreview();
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$CameraScanActivity$87TSgsFDrutGLzGSampvZu6MxJU
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onPreviewFrame$6$CameraScanActivity(resultRecognize);
                        }
                    });
                }
            } else {
                camera.getParameters().getPreviewFormat();
                int iMin = (int) (Math.min(previewSize.getWidth(), previewSize.getHeight()) / 1.5f);
                final String strTryReadQr = tryReadQr(bArr, previewSize, (previewSize.getWidth() - iMin) / 2, (previewSize.getHeight() - iMin) / 2, iMin, null);
                if (strTryReadQr != null) {
                    this.recognized = true;
                    camera.stopPreview();
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$CameraScanActivity$Z-yT3trMbhG26puFfL8QRZT-x2U
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onPreviewFrame$7$CameraScanActivity(strTryReadQr);
                        }
                    });
                }
            }
        } catch (Throwable unused) {
            onNoQrFound();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onPreviewFrame$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onPreviewFrame$6$CameraScanActivity(MrzRecognizer.Result result) {
        this.recognizedMrzView.setText(result.rawMRZ);
        this.recognizedMrzView.animate().setDuration(200L).alpha(1.0f).setInterpolator(CubicBezierInterpolator.DEFAULT).start();
        CameraScanActivityDelegate cameraScanActivityDelegate = this.delegate;
        if (cameraScanActivityDelegate != null) {
            cameraScanActivityDelegate.didFindMrzInfo(result);
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$18zlBrhmV8hOQKP99U1vomph2G0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.finishFragment();
            }
        }, 1200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onPreviewFrame$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onPreviewFrame$7$CameraScanActivity(String str) {
        CameraScanActivityDelegate cameraScanActivityDelegate = this.delegate;
        if (cameraScanActivityDelegate != null) {
            cameraScanActivityDelegate.didFindQr(str);
        }
        finishFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String tryReadQr(byte[] data, Size size, int x, int y, int side, Bitmap bitmap) {
        LuminanceSource planarYUVLuminanceSource;
        String text;
        Frame frameBuild;
        try {
            if (this.visionQrReader.isOperational()) {
                if (bitmap != null) {
                    frameBuild = new Frame.Builder().setBitmap(bitmap).build();
                } else {
                    frameBuild = new Frame.Builder().setImageData(ByteBuffer.wrap(data), size.getWidth(), size.getHeight(), 17).build();
                }
                SparseArray<Barcode> sparseArrayDetect = this.visionQrReader.detect(frameBuild);
                text = (sparseArrayDetect == null || sparseArrayDetect.size() <= 0) ? null : sparseArrayDetect.valueAt(0).rawValue;
            } else {
                if (bitmap != null) {
                    int[] iArr = new int[bitmap.getWidth() * bitmap.getHeight()];
                    bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
                    planarYUVLuminanceSource = new RGBLuminanceSource(bitmap.getWidth(), bitmap.getHeight(), iArr);
                } else {
                    planarYUVLuminanceSource = new PlanarYUVLuminanceSource(data, size.getWidth(), size.getHeight(), x, y, side, side, false);
                }
                Result resultDecode = this.qrReader.decode(new BinaryBitmap(new GlobalHistogramBinarizer(planarYUVLuminanceSource)));
                if (resultDecode == null) {
                    onNoQrFound();
                    return null;
                }
                text = resultDecode.getText();
            }
            if (TextUtils.isEmpty(text)) {
                onNoQrFound();
                return null;
            }
            if (this.isEitaaPay) {
                return text;
            }
            if (this.needGalleryButton) {
                if (!text.startsWith("ton://transfer/")) {
                    return null;
                }
                Uri.parse(text).getPath().replace("/", "");
            } else if (!text.startsWith("et://login?token=")) {
                onNoQrFound();
                return null;
            }
            return text;
        } catch (Throwable unused) {
            onNoQrFound();
            return null;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        if (this.currentType == 1) {
            return arrayList;
        }
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarWhiteSelector"));
        arrayList.add(new ThemeDescription(this.titleTextView, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.descriptionText, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText6"));
        return arrayList;
    }
}
