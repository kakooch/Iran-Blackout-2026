package ir.eitaa.ui.Components;

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
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.Theme;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class QRCodeBottomSheet extends BottomSheet {
    private final TextView buttonTextView;
    private final TextView help;
    ImageView iconImage;
    int imageSize;
    Bitmap qrCode;

    public QRCodeBottomSheet(final Context context, String link, String helpMessage) {
        super(context, false);
        setTitle(LocaleController.getString("InviteByQRCode", R.string.InviteByQRCode), true);
        final ImageView imageView = new ImageView(context) { // from class: ir.eitaa.ui.Components.QRCodeBottomSheet.1
            @Override // android.widget.ImageView, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                int size = View.MeasureSpec.getSize(widthMeasureSpec);
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size, 1073741824));
            }
        };
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (Build.VERSION.SDK_INT >= 21) {
            imageView.setOutlineProvider(new ViewOutlineProvider() { // from class: ir.eitaa.ui.Components.QRCodeBottomSheet.2
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
        Bitmap bitmapCreateQR = createQR(context, link, this.qrCode);
        this.qrCode = bitmapCreateQR;
        imageView.setImageBitmap(bitmapCreateQR);
        ImageView imageView2 = new ImageView(context);
        this.iconImage = imageView2;
        imageView2.setImageResource(R.mipmap.ic_launcher);
        FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.eitaa.ui.Components.QRCodeBottomSheet.3
            float lastX;

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                float measuredHeight = (QRCodeBottomSheet.this.imageSize / 768.0f) * imageView.getMeasuredHeight();
                if (this.lastX != measuredHeight) {
                    this.lastX = measuredHeight;
                    ViewGroup.LayoutParams layoutParams = QRCodeBottomSheet.this.iconImage.getLayoutParams();
                    int i = (int) measuredHeight;
                    QRCodeBottomSheet.this.iconImage.getLayoutParams().width = i;
                    layoutParams.height = i;
                    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                }
            }
        };
        frameLayout.addView(imageView, LayoutHelper.createFrame(-1, -1.0f));
        frameLayout.addView(this.iconImage, LayoutHelper.createFrame(60, 60, 17));
        linearLayout.addView(frameLayout, LayoutHelper.createLinear(220, 220, 1, 30, 0, 30, 0));
        TextView textView = new TextView(context);
        this.help = textView;
        textView.setTextSize(1, 14.0f);
        textView.setText(helpMessage);
        textView.setGravity(1);
        linearLayout.addView(textView, LayoutHelper.createFrame(-1, -2.0f, 0, 40.0f, 8.0f, 40.0f, 8.0f));
        TextView textView2 = new TextView(context);
        this.buttonTextView = textView2;
        textView2.setPadding(AndroidUtilities.dp(34.0f), 0, AndroidUtilities.dp(34.0f), 0);
        textView2.setGravity(17);
        textView2.setTextSize(1, 14.0f);
        textView2.setTypeface(AndroidUtilities.getFontFamily(true));
        textView2.setText(LocaleController.getString("ShareQrCode", R.string.ShareQrCode));
        textView2.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$QRCodeBottomSheet$4ZYeMuZhTXdZvBaAQ7UVryyzWAY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IOException {
                this.f$0.lambda$new$0$QRCodeBottomSheet(context, view);
            }
        });
        linearLayout.addView(textView2, LayoutHelper.createLinear(-1, 48, 80, 16, 15, 16, 16));
        updateColors();
        ScrollView scrollView = new ScrollView(context);
        scrollView.addView(linearLayout);
        setCustomView(scrollView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$QRCodeBottomSheet(Context context, View view) throws IOException {
        Uri imageUri = getImageUri(this.qrCode);
        if (imageUri != null) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/*");
            intent.putExtra("android.intent.extra.STREAM", imageUri);
            try {
                AndroidUtilities.findActivity(context).startActivityForResult(Intent.createChooser(intent, LocaleController.getString("InviteByQRCode", R.string.InviteByQRCode)), 500);
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public Uri getImageUri(Bitmap inImage) throws IOException {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (inImage == null) {
            return null;
        }
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
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
                inImage.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.close();
                Uri uriForFile = FileProvider.getUriForFile(ApplicationLoader.applicationContext, "ir.eitaa.messenger.provider", file);
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

    public Bitmap createQR(Context context, String key, Bitmap oldBitmap) {
        try {
            HashMap map = new HashMap();
            map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
            map.put(EncodeHintType.MARGIN, 0);
            QRCodeWriter qRCodeWriter = new QRCodeWriter();
            Bitmap bitmapEncode = qRCodeWriter.encode(key, BarcodeFormat.QR_CODE, 768, 768, map, oldBitmap, context);
            this.imageSize = qRCodeWriter.getImageSize();
            return bitmapEncode;
        } catch (Exception e) {
            FileLog.e(e);
            return null;
        }
    }

    void updateColors() {
        this.buttonTextView.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(6.0f), Theme.getColor("featuredStickers_addButton"), Theme.getColor("featuredStickers_addButtonPressed")));
        this.help.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText"));
        this.buttonTextView.setTextColor(Theme.getColor("featuredStickers_buttonText"));
        if (getTitleView() != null) {
            getTitleView().setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        }
        setBackgroundColor(Theme.getColor("dialogBackground"));
    }
}
