package org.rbmain.ui.Components;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import com.facebook.stetho.server.http.HttpStatus;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import ir.medu.shad.R;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes5.dex */
public class QRCodeBottomSheet extends BottomSheet {
    private final TextView buttonTextView;
    private final TextView help;
    RLottieImageView iconImage;
    int imageSize;
    Bitmap qrCode;

    public QRCodeBottomSheet(final Context context, String str, String str2) {
        super(context, false);
        setTitle(LocaleController.getString("InviteByQRCode", R.string.InviteByQRCode), true);
        final ImageView imageView = new ImageView(this, context) { // from class: org.rbmain.ui.Components.QRCodeBottomSheet.1
            @Override // android.widget.ImageView, android.view.View
            protected void onMeasure(int i, int i2) {
                int size = View.MeasureSpec.getSize(i);
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size, 1073741824));
            }
        };
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (Build.VERSION.SDK_INT >= 21) {
            imageView.setOutlineProvider(new ViewOutlineProvider(this) { // from class: org.rbmain.ui.Components.QRCodeBottomSheet.2
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) {
                    outline.setRoundRect(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight(), AndroidUtilities.dp(12.0f));
                }
            });
            imageView.setClipToOutline(true);
        }
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(0, AndroidUtilities.dp(16.0f), 0, 0);
        Bitmap bitmapCreateQR = createQR(context, str, this.qrCode);
        this.qrCode = bitmapCreateQR;
        imageView.setImageBitmap(bitmapCreateQR);
        RLottieImageView rLottieImageView = new RLottieImageView(context);
        this.iconImage = rLottieImageView;
        rLottieImageView.setBackgroundColor(-1);
        this.iconImage.setAutoRepeat(true);
        FrameLayout frameLayout = new FrameLayout(context) { // from class: org.rbmain.ui.Components.QRCodeBottomSheet.3
            float lastX;

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i, int i2) {
                super.onMeasure(i, i2);
                float measuredHeight = (QRCodeBottomSheet.this.imageSize / 768.0f) * imageView.getMeasuredHeight();
                if (this.lastX != measuredHeight) {
                    this.lastX = measuredHeight;
                    ViewGroup.LayoutParams layoutParams = QRCodeBottomSheet.this.iconImage.getLayoutParams();
                    int i3 = (int) measuredHeight;
                    QRCodeBottomSheet.this.iconImage.getLayoutParams().width = i3;
                    layoutParams.height = i3;
                    super.onMeasure(i, i2);
                }
            }
        };
        frameLayout.addView(imageView, LayoutHelper.createFrame(-1, -1.0f));
        frameLayout.addView(this.iconImage, LayoutHelper.createFrame(60, 60, 17));
        linearLayout.addView(frameLayout, LayoutHelper.createLinear(220, 220, 1, 30, 0, 30, 0));
        TextView textView = new TextView(context);
        this.help = textView;
        textView.setTextSize(1, 14.0f);
        textView.setText(str2);
        textView.setGravity(1);
        linearLayout.addView(textView, LayoutHelper.createFrame(-1, -2.0f, 0, 40.0f, 8.0f, 40.0f, 8.0f));
        TextView textView2 = new TextView(context);
        this.buttonTextView = textView2;
        textView2.setPadding(AndroidUtilities.dp(34.0f), 0, AndroidUtilities.dp(34.0f), 0);
        textView2.setGravity(17);
        textView2.setTextSize(1, 14.0f);
        textView2.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        textView2.setText(LocaleController.getString("ShareQrCode", R.string.ShareQrCode));
        textView2.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.QRCodeBottomSheet$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IOException {
                this.f$0.lambda$new$0(context, view);
            }
        });
        linearLayout.addView(textView2, LayoutHelper.createLinear(-1, 48, 80, 16, 15, 16, 16));
        updateColors();
        ScrollView scrollView = new ScrollView(context);
        scrollView.addView(linearLayout);
        setCustomView(scrollView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(Context context, View view) throws IOException {
        Uri imageUri = getImageUri(this.qrCode);
        if (imageUri != null) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/*");
            intent.putExtra("android.intent.extra.STREAM", imageUri);
            try {
                AndroidUtilities.findActivity(context).startActivityForResult(Intent.createChooser(intent, LocaleController.getString("InviteByQRCode", R.string.InviteByQRCode)), HttpStatus.HTTP_INTERNAL_SERVER_ERROR);
                dismiss();
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public Uri getImageUri(Bitmap bitmap) throws IOException {
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, new ByteArrayOutputStream());
        File cacheDir = AndroidUtilities.getCacheDir();
        if (!cacheDir.isDirectory()) {
            try {
                cacheDir.mkdirs();
            } catch (Exception e) {
                FileLog.e(e);
                return null;
            }
        }
        File file = new File(cacheDir, "qr_tmp.png");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.close();
                Uri uriForFile = FileProvider.getUriForFile(ApplicationLoader.applicationContext, "ir.medu.shad.provider", file);
                fileOutputStream.close();
                return uriForFile;
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (IOException e2) {
            FileLog.e(e2);
            return null;
        }
    }

    public Bitmap createQR(Context context, String str, Bitmap bitmap) {
        try {
            HashMap map = new HashMap();
            map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
            map.put(EncodeHintType.MARGIN, 0);
            QRCodeWriter qRCodeWriter = new QRCodeWriter();
            Bitmap bitmapEncode = qRCodeWriter.encode(str, BarcodeFormat.QR_CODE, 768, 768, map, bitmap, context);
            this.imageSize = qRCodeWriter.getImageSize();
            return bitmapEncode;
        } catch (Exception e) {
            FileLog.e(e);
            return null;
        }
    }

    void updateColors() {
        this.buttonTextView.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(6.0f), Theme.getColor(Theme.key_featuredStickers_addButton), Theme.getColor(Theme.key_featuredStickers_addButtonPressed)));
        this.help.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText));
        this.buttonTextView.setTextColor(Theme.getColor(Theme.key_featuredStickers_buttonText));
        if (getTitleView() != null) {
            getTitleView().setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
        }
        setBackgroundColor(Theme.getColor(Theme.key_dialogBackground));
    }
}
