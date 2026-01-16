package androidMessenger.utilites;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidMessenger.utilites.BotButtonHandler;
import androidx.appcompat.widget.Toolbar;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.common.utils.AndroidUtilities;
import ir.medu.shad.R;
import ir.resaneh1.iptv.dialog.PresenterDialog;
import ir.resaneh1.iptv.dialog.ThreeButtonDialog;
import ir.resaneh1.iptv.helper.NewImageHelper;
import ir.resaneh1.iptv.model.ProgressItem;
import ir.resaneh1.iptv.model.ViewObjectAttr;
import ir.resaneh1.iptv.toolbar.ToolbarImageView;
import ir.resaneh1.iptv.toolbar.ToolbarMaker;
import ir.resaneh1.iptv.upload.MiniFunctionFileUploadOperation;
import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes.dex */
public class UploadFileProgressDialog extends PresenterDialog {
    String afterCompressMime;
    private int currentAccount;
    public ImageView imageView;
    public ImageView imageViewRetry;
    BotButtonHandler.Delegate listener;
    Context mContext;
    View.OnClickListener onCancelClickListener;
    View.OnClickListener onRetryClickListener;
    MiniFunctionFileUploadOperation operation;
    String path;
    public ProgressBar progressBar;
    public ProgressItem progressItem;
    public String requestSendFileUrl;
    public TextView textViewProgress;
    public TextView textViewStatus;
    private long totalSize;
    ViewObjectAttr viewObjectAttr;

    @Override // ir.resaneh1.iptv.dialog.PresenterDialog
    public int getLayoutId() {
        return R.layout.upload_file_progress_dialog;
    }

    public UploadFileProgressDialog(Context context) {
        super(context);
        this.totalSize = 0L;
        this.currentAccount = UserConfig.selectedAccount;
        this.afterCompressMime = null;
        this.onCancelClickListener = new View.OnClickListener() { // from class: androidMessenger.utilites.UploadFileProgressDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                final ThreeButtonDialog threeButtonDialog = new ThreeButtonDialog(UploadFileProgressDialog.this.mContext, "آیا می خواهید ارسال فایل متوقف شود؟");
                threeButtonDialog.button1.setText("بله");
                threeButtonDialog.button2.setText("خیر");
                threeButtonDialog.button1.setOnClickListener(new View.OnClickListener() { // from class: androidMessenger.utilites.UploadFileProgressDialog.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) throws IOException {
                        threeButtonDialog.dismiss();
                        MiniFunctionFileUploadOperation miniFunctionFileUploadOperation = UploadFileProgressDialog.this.operation;
                        if (miniFunctionFileUploadOperation != null) {
                            miniFunctionFileUploadOperation.cancel();
                        }
                        UploadFileProgressDialog.this.dismiss();
                    }
                });
                threeButtonDialog.button2.setOnClickListener(new View.OnClickListener(this) { // from class: androidMessenger.utilites.UploadFileProgressDialog.2.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        threeButtonDialog.dismiss();
                    }
                });
            }
        };
        this.onRetryClickListener = new View.OnClickListener() { // from class: androidMessenger.utilites.UploadFileProgressDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) throws IOException {
                MiniFunctionFileUploadOperation miniFunctionFileUploadOperation = UploadFileProgressDialog.this.operation;
                if (miniFunctionFileUploadOperation != null) {
                    miniFunctionFileUploadOperation.cancel();
                }
                ProgressItem progressItem = UploadFileProgressDialog.this.progressItem;
                progressItem.hasError = false;
                progressItem.setProgress(0.0f, r5.totalSize);
                UploadFileProgressDialog.this.updateView();
                UploadFileProgressDialog.this.setOperationAndStart();
            }
        };
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.dialog.PresenterDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // ir.resaneh1.iptv.dialog.PresenterDialog
    protected void findView() {
        super.findView();
        this.imageView = (ImageView) findViewById(R.id.imageView);
        this.progressBar = (ProgressBar) findViewById(R.id.progressBar);
        this.textViewStatus = (TextView) findViewById(R.id.textView);
        this.textViewProgress = (TextView) findViewById(R.id.textViewProgress);
    }

    @Override // ir.resaneh1.iptv.dialog.PresenterDialog
    protected void init() {
        super.init();
        this.progressItem = new ProgressItem(0);
        setCanceledOnTouchOutside(false);
        setToolbar();
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: androidMessenger.utilites.UploadFileProgressDialog.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                UploadFileProgressDialog.this.onCancelClickListener.onClick(null);
            }
        });
    }

    public void setToolbar() {
        if (this.mContext == null) {
            return;
        }
        this.toolbarMaker.clearToolbar();
        Toolbar toolbar = this.toolbarMaker.toolbar;
        if (toolbar != null) {
            toolbar.setBackgroundColor(this.mContext.getResources().getColor(R.color.toolbar_grey));
        }
        View viewCreateView = this.toolbarMaker.toolbarTextView.createView((Activity) this.mContext, "ارسال فایل");
        this.toolbarMaker.toolbarTextView.textView.setTextColor(this.mContext.getResources().getColor(R.color.toolbar_text_grey));
        ToolbarMaker toolbarMaker = this.toolbarMaker;
        if (toolbarMaker != null) {
            toolbarMaker.leftLayout.removeAllViews();
            this.toolbarMaker.addViewToRightLayout(viewCreateView);
        }
        ToolbarImageView toolbarImageView = new ToolbarImageView();
        toolbarImageView.createView((Activity) this.mContext, R.drawable.ic_close_grey, Integer.valueOf(Theme.getColor(Theme.key_actionBarDefaultIcon)));
        toolbarImageView.imageView.setOnClickListener(this.onCancelClickListener);
        this.toolbarMaker.addViewToLeftLayout(toolbarImageView.view);
        ToolbarImageView toolbarImageView2 = new ToolbarImageView();
        toolbarImageView2.createView((Activity) this.mContext, R.drawable.ic_retry_grey);
        toolbarImageView2.imageView.setOnClickListener(this.onRetryClickListener);
        toolbarImageView2.imageView.setPadding(AndroidUtilities.dp(5.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(5.0f), AndroidUtilities.dp(16.0f));
        this.imageViewRetry = toolbarImageView2.imageView;
        this.toolbarMaker.addViewToLeftLayout(toolbarImageView2.view);
    }

    public void updateView() {
        setProgress();
        setStatusText();
    }

    public void setStatusText() {
        if (!this.progressItem.hasError) {
            this.imageViewRetry.setVisibility(4);
            this.textViewStatus.setText("در حال ارسال");
        } else {
            this.textViewStatus.setText("خطا در ارسال");
            this.imageViewRetry.setVisibility(0);
        }
    }

    public void setProgress() {
        ProgressItem progressItem = this.progressItem;
        if (!progressItem.hasError) {
            this.progressBar.setProgress(progressItem.getProgress());
            this.progressBar.setVisibility(0);
            this.textViewProgress.setText(this.progressItem.getProgressString());
        } else {
            this.progressBar.setVisibility(4);
            this.textViewProgress.setText(BuildConfig.FLAVOR);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00a0 A[PHI: r12
      0x00a0: PHI (r12v6 boolean) = (r12v5 boolean), (r12v5 boolean), (r12v8 boolean), (r12v8 boolean) binds: [B:25:0x0078, B:27:0x007e, B:33:0x0099, B:35:0x009d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void startUploading(ir.aaap.messengercore.model.FileUploadProperties r10, ir.resaneh1.iptv.model.ViewObjectAttr r11, java.lang.String r12, androidMessenger.utilites.BotButtonHandler.Delegate r13) {
        /*
            r9 = this;
            if (r10 != 0) goto L3
            return
        L3:
            r9.show()
            r9.listener = r13
            r9.path = r12
            java.lang.String r13 = r10.requestSendFileUrl
            r9.requestSendFileUrl = r13
            r9.viewObjectAttr = r11
            java.io.File r11 = new java.io.File
            r11.<init>(r12)
            long r0 = r11.length()
            r9.totalSize = r0
            java.lang.String r13 = r11.getName()
            java.lang.String r13 = java.net.URLConnection.guessContentTypeFromName(r13)
            java.lang.String r0 = "image"
            r1 = 0
            if (r13 == 0) goto L46
            boolean r2 = r13.contains(r0)
            if (r2 != 0) goto L36
            java.lang.String r2 = "video"
            boolean r2 = r13.contains(r2)
            if (r2 == 0) goto L46
        L36:
            android.widget.ImageView r2 = r9.imageView
            r2.setVisibility(r1)
            android.content.Context r2 = r9.mContext
            android.widget.ImageView r3 = r9.imageView
            r4 = 2131231725(0x7f0803ed, float:1.807954E38)
            ir.resaneh1.iptv.helper.GlideHelper.load(r2, r3, r12, r4)
            goto L4d
        L46:
            android.widget.ImageView r12 = r9.imageView
            r2 = 8
            r12.setVisibility(r2)
        L4d:
            boolean r12 = r10.should_compress
            if (r12 == 0) goto L5f
            boolean r12 = r13.contains(r0)
            if (r12 == 0) goto L5f
            float r11 = r10.compress_quality
            int r10 = r10.max_pixel
            r9.compressAndSend(r11, r10)
            goto Laf
        L5f:
            r12 = 1
            long r2 = r11.length()
            long r4 = r10.min_size
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L6b
            r12 = 0
        L6b:
            long r4 = r10.max_size
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L78
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L78
            r12 = 0
        L78:
            if (r13 == 0) goto La0
            boolean r13 = r13.contains(r0)
            if (r13 == 0) goto La0
            java.lang.String r11 = r11.getAbsolutePath()
            android.graphics.Bitmap r11 = android.graphics.BitmapFactory.decodeFile(r11)
            int r13 = r11.getWidth()
            int r11 = r11.getHeight()
            int r0 = r10.min_pixel
            if (r13 < r0) goto L96
            if (r11 >= r0) goto L97
        L96:
            r12 = 0
        L97:
            int r10 = r10.max_pixel
            if (r10 <= 0) goto La0
            if (r13 > r10) goto La1
            if (r11 <= r10) goto La0
            goto La1
        La0:
            r1 = r12
        La1:
            if (r1 == 0) goto La7
            r9.setOperationAndStart()
            goto Laf
        La7:
            java.lang.String r10 = "اندازه فایل مورد نظر برای ارسال مناسب نیست"
            ir.resaneh1.iptv.helper.ToastiLikeSnack.showMessageLikeToast(r10)
            r9.dismiss()
        Laf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidMessenger.utilites.UploadFileProgressDialog.startUploading(ir.aaap.messengercore.model.FileUploadProperties, ir.resaneh1.iptv.model.ViewObjectAttr, java.lang.String, androidMessenger.utilites.BotButtonHandler$Delegate):void");
    }

    private void compressAndSend(float f, int i) {
        int i2 = (int) (f * 100.0f);
        if (i2 > 100) {
            i2 = 100;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        try {
            if (i > 0) {
                Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(this.path);
                ir.resaneh1.iptv.logger.MyLog.e("UploadFileProgressDialog before", bitmapDecodeFile.getWidth() + " " + bitmapDecodeFile.getHeight());
                float f2 = (float) i;
                String strCompressImageAndSave = NewImageHelper.compressImageAndSave(NewImageHelper.loadImage(this.path, f2, f2, false), i2);
                this.path = strCompressImageAndSave;
                Bitmap bitmapDecodeFile2 = BitmapFactory.decodeFile(strCompressImageAndSave);
                ir.resaneh1.iptv.logger.MyLog.e("UploadFileProgressDialog after", bitmapDecodeFile2.getWidth() + " " + bitmapDecodeFile2.getHeight() + " " + i);
            } else {
                this.path = NewImageHelper.compressImageAndSave(BitmapFactory.decodeFile(this.path), i2);
            }
            this.afterCompressMime = "jpg";
            setOperationAndStart();
        } catch (Exception e) {
            ir.resaneh1.iptv.logger.MyLog.handleException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOperationAndStart() {
        String lowerCase;
        File file = new File(this.path);
        this.totalSize = file.length();
        String name = file.getName();
        String str = this.afterCompressMime;
        if (str == null) {
            String strGuessContentTypeFromName = URLConnection.guessContentTypeFromName(file.getName());
            ir.resaneh1.iptv.logger.MyLog.e("UploadFileProgressDialog", "mime : " + strGuessContentTypeFromName);
            int iIndexOf = strGuessContentTypeFromName.indexOf("/");
            if (iIndexOf >= 0) {
                strGuessContentTypeFromName = strGuessContentTypeFromName.substring(iIndexOf + 1);
            }
            lowerCase = strGuessContentTypeFromName.toLowerCase();
        } else {
            lowerCase = str;
        }
        ir.resaneh1.iptv.logger.MyLog.e("UploadFileProgressDialog", "after mime : " + lowerCase);
        ViewObjectAttr viewObjectAttr = this.viewObjectAttr;
        if (viewObjectAttr != null) {
            MiniFunctionFileUploadOperation miniFunctionFileUploadOperation = new MiniFunctionFileUploadOperation(this.requestSendFileUrl, this.path, name, lowerCase, viewObjectAttr.track_id, this.currentAccount);
            this.operation = miniFunctionFileUploadOperation;
            miniFunctionFileUploadOperation.setDelegate(new MiniFunctionFileUploadOperation.FileUploadOperationDelegate() { // from class: androidMessenger.utilites.UploadFileProgressDialog.4
                @Override // ir.resaneh1.iptv.upload.MiniFunctionFileUploadOperation.FileUploadOperationDelegate
                public void onUploadStart(MiniFunctionFileUploadOperation miniFunctionFileUploadOperation2) {
                    ir.resaneh1.iptv.logger.MyLog.e("MiniFunctionClickHandler", "onUploadStart");
                    UploadFileProgressDialog.this.progressItem.setProgress(0.0f, r4.totalSize);
                    UploadFileProgressDialog uploadFileProgressDialog = UploadFileProgressDialog.this;
                    uploadFileProgressDialog.progressItem.hasError = false;
                    uploadFileProgressDialog.updateView();
                }

                @Override // ir.resaneh1.iptv.upload.MiniFunctionFileUploadOperation.FileUploadOperationDelegate
                public void onUploadProgress(MiniFunctionFileUploadOperation miniFunctionFileUploadOperation2) {
                    UploadFileProgressDialog.this.progressItem.setProgress(miniFunctionFileUploadOperation2.getUploadedBytesCount(), UploadFileProgressDialog.this.totalSize);
                    UploadFileProgressDialog.this.updateView();
                    ir.resaneh1.iptv.logger.MyLog.e("MiniFunctionClickHandler", "onUploadProgress " + UploadFileProgressDialog.this.progressItem.getProgress());
                }

                @Override // ir.resaneh1.iptv.upload.MiniFunctionFileUploadOperation.FileUploadOperationDelegate
                public void onUploadCompleted(MiniFunctionFileUploadOperation miniFunctionFileUploadOperation2) {
                    ir.resaneh1.iptv.logger.MyLog.e("MiniFunctionClickHandler", "onUploadCompleted");
                    UploadFileProgressDialog.this.progressItem.setProgress(r0.totalSize, UploadFileProgressDialog.this.totalSize);
                    UploadFileProgressDialog.this.updateView();
                    BotButtonHandler.Delegate delegate = UploadFileProgressDialog.this.listener;
                    if (delegate != null) {
                        delegate.uploadFileDone(miniFunctionFileUploadOperation2.file_id, miniFunctionFileUploadOperation2.access_hash_rec);
                    }
                    UploadFileProgressDialog.this.dismiss();
                }

                @Override // ir.resaneh1.iptv.upload.MiniFunctionFileUploadOperation.FileUploadOperationDelegate
                public void onUploadError(MiniFunctionFileUploadOperation miniFunctionFileUploadOperation2, MiniFunctionFileUploadOperation.UploadError uploadError) {
                    ir.resaneh1.iptv.logger.MyLog.e("MiniFunctionClickHandler", "onUploadError");
                    UploadFileProgressDialog uploadFileProgressDialog = UploadFileProgressDialog.this;
                    uploadFileProgressDialog.progressItem.hasError = true;
                    uploadFileProgressDialog.updateView();
                }
            });
            this.operation.start();
        }
    }
}
