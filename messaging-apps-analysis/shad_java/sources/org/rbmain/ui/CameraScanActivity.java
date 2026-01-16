package org.rbmain.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
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
import androidx.core.content.ContextCompat;
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
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.model.Link;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.ImageLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MrzRecognizer;
import org.rbmain.messenger.SendMessagesHelper;
import org.rbmain.messenger.camera.CameraController;
import org.rbmain.messenger.camera.CameraSession;
import org.rbmain.messenger.camera.CameraView;
import org.rbmain.messenger.camera.Size;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarLayout;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Components.AnimationProperties;
import org.rbmain.ui.Components.CubicBezierInterpolator;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.PhotoAlbumPickerActivity;

/* loaded from: classes4.dex */
public class CameraScanActivity extends BaseFragment implements Camera.PreviewCallback {
    private HandlerThread backgroundHandlerThread;
    private final Link.BarcodescanData barcodeScanData;
    private CameraView cameraView;
    private Paint cornerPaint;
    private int currentType;
    private CameraScanActivityDelegate delegate;
    private TextView descriptionText;
    private AnimatorSet flashAnimator;
    private ImageView flashButton;
    private ImageView galleryButton;
    private Handler handler;
    private boolean needGalleryButton;
    private Paint paint;
    private Path path;
    private QRCodeReader qrReader;
    private boolean recognized;
    private TextView recognizedMrzView;
    private TextView textViewEnterCode;
    private TextView textViewLink;
    private final String title;
    private TextView titleTextView;
    private BarcodeDetector visionQrReader;

    public interface CameraScanActivityDelegate {

        /* renamed from: org.rbmain.ui.CameraScanActivity$CameraScanActivityDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$didFindMrzInfo(CameraScanActivityDelegate cameraScanActivityDelegate, MrzRecognizer.Result result) {
            }

            public static void $default$didFindQr(CameraScanActivityDelegate cameraScanActivityDelegate, String str) {
            }
        }

        void didFindMrzInfo(MrzRecognizer.Result result);

        void didFindQr(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createView$1(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createView$3(View view) {
    }

    public static ActionBarLayout[] showAsSheet(BaseFragment baseFragment, boolean z, CameraScanActivityDelegate cameraScanActivityDelegate) {
        return showAsSheet(baseFragment, z, null, null, cameraScanActivityDelegate);
    }

    public static ActionBarLayout[] showAsSheet(BaseFragment baseFragment, boolean z, String str, Link.BarcodescanData barcodescanData, CameraScanActivityDelegate cameraScanActivityDelegate) {
        if (baseFragment == null || baseFragment.getParentActivity() == null) {
            return null;
        }
        ActionBarLayout[] actionBarLayoutArr = {new ActionBarLayout(baseFragment.getParentActivity())};
        new AnonymousClass1(baseFragment.getParentActivity(), false, actionBarLayoutArr, barcodescanData, str, z, cameraScanActivityDelegate).show();
        return actionBarLayoutArr;
    }

    /* renamed from: org.rbmain.ui.CameraScanActivity$1, reason: invalid class name */
    class AnonymousClass1 extends BottomSheet {
        final /* synthetic */ ActionBarLayout[] val$actionBarLayout;
        final /* synthetic */ Link.BarcodescanData val$barcodescanData;
        final /* synthetic */ CameraScanActivityDelegate val$delegate1;
        final /* synthetic */ boolean val$gallery;
        final /* synthetic */ String val$title;

        @Override // org.rbmain.ui.ActionBar.BottomSheet
        protected boolean canDismissWithSwipe() {
            return false;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context, boolean z, ActionBarLayout[] actionBarLayoutArr, Link.BarcodescanData barcodescanData, String str, boolean z2, CameraScanActivityDelegate cameraScanActivityDelegate) {
            super(context, z);
            this.val$actionBarLayout = actionBarLayoutArr;
            this.val$barcodescanData = barcodescanData;
            this.val$title = str;
            this.val$gallery = z2;
            this.val$delegate1 = cameraScanActivityDelegate;
            actionBarLayoutArr[0].init(new ArrayList<>());
            final CameraScanActivity cameraScanActivity = new CameraScanActivity(1, barcodescanData, str) { // from class: org.rbmain.ui.CameraScanActivity.1.1
                @Override // org.rbmain.ui.ActionBar.BaseFragment
                public void finishFragment() {
                    AnonymousClass1.this.dismiss();
                }

                @Override // org.rbmain.ui.ActionBar.BaseFragment
                public void removeSelfFromStack() {
                    AnonymousClass1.this.dismiss();
                }
            };
            cameraScanActivity.needGalleryButton = z2;
            actionBarLayoutArr[0].addFragmentToStack(cameraScanActivity);
            actionBarLayoutArr[0].showLastFragment();
            ActionBarLayout actionBarLayout = actionBarLayoutArr[0];
            int i = this.backgroundPaddingLeft;
            actionBarLayout.setPadding(i, 0, i, 0);
            cameraScanActivity.setDelegate(cameraScanActivityDelegate);
            this.containerView = actionBarLayoutArr[0];
            setApplyBottomPadding(false);
            setApplyBottomPadding(false);
            setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: org.rbmain.ui.CameraScanActivity$1$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
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

        @Override // org.rbmain.ui.ActionBar.BottomSheet, android.app.Dialog, android.content.DialogInterface
        public void dismiss() {
            super.dismiss();
            this.val$actionBarLayout[0] = null;
        }
    }

    public CameraScanActivity(int i) {
        this(i, null, null);
    }

    public CameraScanActivity(int i, Link.BarcodescanData barcodescanData, String str) {
        this.backgroundHandlerThread = new HandlerThread("ScanCamera");
        this.paint = new Paint();
        this.cornerPaint = new Paint(1);
        this.path = new Path();
        this.title = str;
        this.barcodeScanData = barcodescanData;
        CameraController.getInstance().initCamera(new Runnable() { // from class: org.rbmain.ui.CameraScanActivity$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0();
            }
        });
        this.currentType = i;
        if (i == 1) {
            this.qrReader = new QRCodeReader();
            this.visionQrReader = new BarcodeDetector.Builder(ApplicationLoader.applicationContext).setBarcodeFormats(256).build();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        CameraView cameraView = this.cameraView;
        if (cameraView != null) {
            cameraView.initCamera();
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        return super.onFragmentCreate();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setItemsColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText2), false);
        this.actionBar.setItemsBackgroundColor(Theme.getColor(Theme.key_actionBarWhiteSelector), false);
        this.actionBar.setCastShadows(false);
        if (!AndroidUtilities.isTablet() && this.currentType != 1) {
            this.actionBar.showActionModeTop();
        }
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: org.rbmain.ui.CameraScanActivity.2
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    CameraScanActivity.this.finishFragment();
                }
            }
        });
        this.paint.setColor(2130706432);
        this.cornerPaint.setColor(-1);
        this.cornerPaint.setStyle(Paint.Style.STROKE);
        this.cornerPaint.setStrokeWidth(AndroidUtilities.dp(4.0f));
        this.cornerPaint.setStrokeJoin(Paint.Join.ROUND);
        ViewGroup viewGroup = new ViewGroup(context) { // from class: org.rbmain.ui.CameraScanActivity.3
            @Override // android.view.View
            protected void onMeasure(int i, int i2) {
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                ((BaseFragment) CameraScanActivity.this).actionBar.measure(i, i2);
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
                CameraScanActivity.this.textViewEnterCode.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, 0));
                CameraScanActivity.this.textViewLink.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(size2, 0));
                setMeasuredDimension(size, size2);
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
                int i5 = i3 - i;
                int i6 = i4 - i2;
                if (CameraScanActivity.this.currentType == 0) {
                    CameraScanActivity.this.cameraView.layout(0, 0, CameraScanActivity.this.cameraView.getMeasuredWidth(), CameraScanActivity.this.cameraView.getMeasuredHeight() + 0);
                    int i7 = (int) (i6 * 0.65f);
                    CameraScanActivity.this.titleTextView.layout(0, i7, CameraScanActivity.this.titleTextView.getMeasuredWidth(), CameraScanActivity.this.titleTextView.getMeasuredHeight() + i7);
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
                    if (CameraScanActivity.this.barcodeScanData != null) {
                        int measuredWidth2 = (CameraScanActivity.this.cameraView.getMeasuredWidth() / 2) - (CameraScanActivity.this.textViewEnterCode.getMeasuredWidth() / 2);
                        int measuredHeight3 = measuredHeight2 + CameraScanActivity.this.flashButton.getMeasuredHeight() + AndroidUtilities.dp(30.0f);
                        CameraScanActivity.this.textViewEnterCode.layout(measuredWidth2, measuredHeight3, CameraScanActivity.this.textViewEnterCode.getMeasuredWidth() + measuredWidth2, CameraScanActivity.this.textViewEnterCode.getMeasuredHeight() + measuredHeight3);
                        int measuredWidth3 = (CameraScanActivity.this.cameraView.getMeasuredWidth() / 2) - (CameraScanActivity.this.textViewLink.getMeasuredWidth() / 2);
                        measuredHeight2 = measuredHeight3 + CameraScanActivity.this.textViewEnterCode.getMeasuredHeight() + AndroidUtilities.dp(10.0f);
                        CameraScanActivity.this.textViewLink.layout(measuredWidth3, measuredHeight2, CameraScanActivity.this.textViewLink.getMeasuredWidth() + measuredWidth3, CameraScanActivity.this.textViewLink.getMeasuredHeight() + measuredHeight2);
                    }
                    if (CameraScanActivity.this.galleryButton != null) {
                        int measuredWidth4 = ((CameraScanActivity.this.cameraView.getMeasuredWidth() / 2) - AndroidUtilities.dp(35.0f)) - CameraScanActivity.this.galleryButton.getMeasuredWidth();
                        CameraScanActivity.this.galleryButton.layout(measuredWidth4, measuredHeight2, CameraScanActivity.this.galleryButton.getMeasuredWidth() + measuredWidth4, CameraScanActivity.this.galleryButton.getMeasuredHeight() + measuredHeight2);
                    }
                }
                int i8 = (int) (i6 * 0.74f);
                int i9 = (int) (i5 * 0.05f);
                CameraScanActivity.this.descriptionText.layout(i9, i8, CameraScanActivity.this.descriptionText.getMeasuredWidth() + i9, CameraScanActivity.this.descriptionText.getMeasuredHeight() + i8);
            }

            @Override // android.view.ViewGroup
            protected boolean drawChild(Canvas canvas, View view, long j) {
                boolean zDrawChild = super.drawChild(canvas, view, j);
                if (CameraScanActivity.this.currentType != 1 || view != CameraScanActivity.this.cameraView) {
                    return zDrawChild;
                }
                int iMin = (int) (Math.min(view.getWidth(), view.getHeight()) / 1.5f);
                int width = (view.getWidth() - iMin) / 2;
                int height = (view.getHeight() - iMin) / 2;
                float f = height;
                canvas.drawRect(0.0f, 0.0f, view.getMeasuredWidth(), f, CameraScanActivity.this.paint);
                float f2 = height + iMin;
                canvas.drawRect(0.0f, f2, view.getMeasuredWidth(), view.getMeasuredHeight(), CameraScanActivity.this.paint);
                float f3 = width;
                canvas.drawRect(0.0f, f, f3, f2, CameraScanActivity.this.paint);
                float f4 = iMin + width;
                canvas.drawRect(f4, f, view.getMeasuredWidth(), f2, CameraScanActivity.this.paint);
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
        viewGroup.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.CameraScanActivity$$ExternalSyntheticLambda5
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
        this.cameraView.setDelegate(new CameraView.CameraViewDelegate() { // from class: org.rbmain.ui.CameraScanActivity.4
            @Override // org.rbmain.messenger.camera.CameraView.CameraViewDelegate
            public void onCameraCreated(Camera camera) {
            }

            @Override // org.rbmain.messenger.camera.CameraView.CameraViewDelegate
            public void onCameraInit() {
                CameraScanActivity.this.startRecognizing();
            }
        });
        viewGroup.addView(this.cameraView, LayoutHelper.createFrame(-1, -1.0f));
        if (this.currentType == 0) {
            ActionBar actionBar = this.actionBar;
            int i = Theme.key_windowBackgroundWhite;
            actionBar.setBackgroundColor(Theme.getColor(i));
            this.fragmentView.setBackgroundColor(Theme.getColor(i));
        } else {
            this.actionBar.setBackgroundDrawable(null);
            this.actionBar.setAddToContainer(false);
            this.actionBar.setItemsColor(-1, false);
            this.actionBar.setItemsBackgroundColor(587202559, false);
            viewGroup.setBackgroundColor(-16777216);
            viewGroup.addView(this.actionBar);
        }
        TextView textView = new TextView(context);
        this.titleTextView = textView;
        textView.setGravity(1);
        this.titleTextView.setTextSize(1, 24.0f);
        viewGroup.addView(this.titleTextView);
        TextView textView2 = new TextView(context);
        this.descriptionText = textView2;
        textView2.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText6));
        this.descriptionText.setGravity(1);
        this.descriptionText.setTextSize(1, 16.0f);
        viewGroup.addView(this.descriptionText);
        if (this.barcodeScanData != null) {
            TextView textView3 = new TextView(context);
            this.textViewEnterCode = textView3;
            textView3.setTextColor(ContextCompat.getColor(context, R.color.grey_900));
            this.textViewEnterCode.setGravity(1);
            this.textViewEnterCode.setTextSize(1, 16.0f);
            this.textViewEnterCode.setBackgroundResource(R.drawable.shape_barcode_entercode);
            this.textViewEnterCode.setPadding(AndroidUtilities.dp(16.0f), AndroidUtilities.dp(12.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(12.0f));
            this.textViewEnterCode.setText("وارد کردن کد");
            viewGroup.addView(this.textViewEnterCode);
            TextView textView4 = new TextView(context);
            this.textViewLink = textView4;
            textView4.setTextColor(ContextCompat.getColor(context, R.color.white));
            this.textViewLink.setGravity(1);
            this.textViewLink.setTextSize(1, 16.0f);
            this.textViewLink.setBackgroundResource(R.drawable.shape_barcode_link);
            this.textViewLink.setPadding(AndroidUtilities.dp(16.0f), AndroidUtilities.dp(12.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(12.0f));
            this.textViewLink.setText("لینک");
            viewGroup.addView(this.textViewLink);
            String str = this.barcodeScanData.code_entry_message;
            if (str != null && !str.isEmpty()) {
                this.textViewEnterCode.setText(this.barcodeScanData.code_entry_message);
            }
            Link.BarcodescanData barcodescanData = this.barcodeScanData;
            if (barcodescanData.has_link && barcodescanData.link != null) {
                this.textViewLink.setText(barcodescanData.link_title);
                this.textViewLink.setVisibility(0);
                this.textViewLink.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.CameraScanActivity$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$createView$2(view);
                    }
                });
            }
            this.textViewEnterCode.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.CameraScanActivity$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CameraScanActivity.lambda$createView$3(view);
                }
            });
        }
        TextView textView5 = new TextView(context);
        this.recognizedMrzView = textView5;
        textView5.setTextColor(-1);
        this.recognizedMrzView.setGravity(81);
        this.recognizedMrzView.setAlpha(0.0f);
        if (this.currentType == 0) {
            this.titleTextView.setText(LocaleController.getString("PassportScanPassport", R.string.PassportScanPassport));
            this.descriptionText.setText(LocaleController.getString("PassportScanPassportInfo", R.string.PassportScanPassportInfo));
            this.titleTextView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
            this.recognizedMrzView.setTypeface(Typeface.MONOSPACE);
            this.cameraView.addView(this.recognizedMrzView);
        } else {
            if (!this.needGalleryButton) {
                TextView textView6 = this.titleTextView;
                String string = this.title;
                if (string == null) {
                    string = LocaleController.getString("AuthAnotherClientScan", R.string.AuthAnotherClientScan);
                }
                textView6.setText(string);
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
                this.galleryButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.CameraScanActivity$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$createView$4(view);
                    }
                });
            }
            ImageView imageView2 = new ImageView(context);
            this.flashButton = imageView2;
            imageView2.setScaleType(ImageView.ScaleType.CENTER);
            this.flashButton.setImageResource(R.drawable.qr_flashlight);
            this.flashButton.setBackgroundDrawable(Theme.createCircleDrawable(AndroidUtilities.dp(60.0f), 587202559));
            viewGroup.addView(this.flashButton);
            this.flashButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.CameraScanActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$createView$6(view);
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
    public /* synthetic */ void lambda$createView$2(View view) {
        new MainClickHandler().onLinkClick(this.baseFragment, this.barcodeScanData.link);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$4(View view) {
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
        photoAlbumPickerActivity.setDelegate(new PhotoAlbumPickerActivity.PhotoAlbumPickerActivityDelegate() { // from class: org.rbmain.ui.CameraScanActivity.5
            @Override // org.rbmain.ui.PhotoAlbumPickerActivity.PhotoAlbumPickerActivityDelegate
            public void didSelectPhotos(ArrayList<SendMessagesHelper.SendingMediaInfo> arrayList, boolean z, int i) {
                try {
                    if (arrayList.isEmpty()) {
                        return;
                    }
                    SendMessagesHelper.SendingMediaInfo sendingMediaInfo = arrayList.get(0);
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

            @Override // org.rbmain.ui.PhotoAlbumPickerActivity.PhotoAlbumPickerActivityDelegate
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
    public /* synthetic */ void lambda$createView$6(View view) {
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
            objectAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.CameraScanActivity$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$createView$5(valueAnimator);
                }
            });
            this.flashAnimator.playTogether(objectAnimatorOfInt);
            this.flashAnimator.setDuration(200L);
            this.flashAnimator.setInterpolator(CubicBezierInterpolator.DEFAULT);
            this.flashAnimator.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.CameraScanActivity.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
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
    public /* synthetic */ void lambda$createView$5(ValueAnimator valueAnimator) {
        this.flashButton.invalidate();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onActivityResultFragment(int i, int i2, Intent intent) {
        if (i2 != -1 || i != 11 || intent == null || intent.getData() == null) {
            return;
        }
        try {
            Point realScreenSize = AndroidUtilities.getRealScreenSize();
            String strTryReadQr = tryReadQr(null, null, 0, 0, 0, ImageLoader.loadBitmap(null, intent.getData(), realScreenSize.x, realScreenSize.y, true));
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

    public void destroy(boolean z, Runnable runnable) {
        CameraView cameraView = this.cameraView;
        if (cameraView != null) {
            cameraView.destroy(z, runnable);
            this.cameraView = null;
        }
        this.backgroundHandlerThread.quitSafely();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRecognizing() {
        this.backgroundHandlerThread.start();
        this.handler = new Handler(this.backgroundHandlerThread.getLooper());
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.CameraScanActivity.7
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
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.CameraScanActivity$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onNoQrFound$7();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onNoQrFound$7() {
        if (this.recognizedMrzView.getTag() != null) {
            this.recognizedMrzView.setTag(null);
            this.recognizedMrzView.animate().setDuration(200L).alpha(0.0f).setInterpolator(CubicBezierInterpolator.DEFAULT).start();
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(final byte[] bArr, final Camera camera) {
        this.handler.post(new Runnable() { // from class: org.rbmain.ui.CameraScanActivity$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onPreviewFrame$10(bArr, camera);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPreviewFrame$10(byte[] bArr, Camera camera) {
        try {
            Size previewSize = this.cameraView.getPreviewSize();
            if (this.currentType == 0) {
                final MrzRecognizer.Result resultRecognize = MrzRecognizer.recognize(bArr, previewSize.getWidth(), previewSize.getHeight(), this.cameraView.getCameraSession().getDisplayOrientation());
                if (resultRecognize != null && !TextUtils.isEmpty(resultRecognize.firstName) && !TextUtils.isEmpty(resultRecognize.lastName) && !TextUtils.isEmpty(resultRecognize.number) && resultRecognize.birthDay != 0 && ((resultRecognize.expiryDay != 0 || resultRecognize.doesNotExpire) && resultRecognize.gender != 0)) {
                    this.recognized = true;
                    camera.stopPreview();
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.CameraScanActivity$$ExternalSyntheticLambda10
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onPreviewFrame$8(resultRecognize);
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
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.CameraScanActivity$$ExternalSyntheticLambda9
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onPreviewFrame$9(strTryReadQr);
                        }
                    });
                }
            }
        } catch (Throwable unused) {
            onNoQrFound();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPreviewFrame$8(MrzRecognizer.Result result) {
        this.recognizedMrzView.setText(result.rawMRZ);
        this.recognizedMrzView.animate().setDuration(200L).alpha(1.0f).setInterpolator(CubicBezierInterpolator.DEFAULT).start();
        CameraScanActivityDelegate cameraScanActivityDelegate = this.delegate;
        if (cameraScanActivityDelegate != null) {
            cameraScanActivityDelegate.didFindMrzInfo(result);
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.CameraScanActivity$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.finishFragment();
            }
        }, 1200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPreviewFrame$9(String str) {
        CameraScanActivityDelegate cameraScanActivityDelegate = this.delegate;
        if (cameraScanActivityDelegate != null) {
            cameraScanActivityDelegate.didFindQr(str);
        }
        finishFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String tryReadQr(byte[] bArr, Size size, int i, int i2, int i3, Bitmap bitmap) {
        LuminanceSource planarYUVLuminanceSource;
        String text;
        Frame frameBuild;
        try {
            if (this.visionQrReader.isOperational()) {
                if (bitmap != null) {
                    frameBuild = new Frame.Builder().setBitmap(bitmap).build();
                } else {
                    frameBuild = new Frame.Builder().setImageData(ByteBuffer.wrap(bArr), size.getWidth(), size.getHeight(), 17).build();
                }
                SparseArray<Barcode> sparseArrayDetect = this.visionQrReader.detect(frameBuild);
                text = (sparseArrayDetect == null || sparseArrayDetect.size() <= 0) ? null : sparseArrayDetect.valueAt(0).rawValue;
            } else {
                if (bitmap != null) {
                    int[] iArr = new int[bitmap.getWidth() * bitmap.getHeight()];
                    bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
                    planarYUVLuminanceSource = new RGBLuminanceSource(bitmap.getWidth(), bitmap.getHeight(), iArr);
                } else {
                    planarYUVLuminanceSource = new PlanarYUVLuminanceSource(bArr, size.getWidth(), size.getHeight(), i, i2, i3, i3, false);
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
            if (this.needGalleryButton) {
                Uri.parse(text).getPath().replace("/", BuildConfig.FLAVOR);
            }
            return text;
        } catch (Throwable unused) {
            onNoQrFound();
            return null;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        if (this.currentType == 1) {
            return arrayList;
        }
        View view = this.fragmentView;
        int i = ThemeDescription.FLAG_BACKGROUND;
        int i2 = Theme.key_windowBackgroundWhite;
        arrayList.add(new ThemeDescription(view, i, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteGrayText2));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_actionBarWhiteSelector));
        arrayList.add(new ThemeDescription(this.titleTextView, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteBlackText));
        arrayList.add(new ThemeDescription(this.descriptionText, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteGrayText6));
        return arrayList;
    }
}
