package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionValues;
import android.util.Property;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.Emoji;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.FileRefController;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SendMessagesHelper;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$DocumentAttribute;
import ir.eitaa.tgnet.TLRPC$InputFile;
import ir.eitaa.tgnet.TLRPC$InputStickerSet;
import ir.eitaa.tgnet.TLRPC$Photo;
import ir.eitaa.tgnet.TLRPC$StickerSet;
import ir.eitaa.tgnet.TLRPC$StickerSetCovered;
import ir.eitaa.tgnet.TLRPC$TL_boolTrue;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeSticker;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inputDocument;
import ir.eitaa.tgnet.TLRPC$TL_inputPhoto;
import ir.eitaa.tgnet.TLRPC$TL_inputStickerSetID;
import ir.eitaa.tgnet.TLRPC$TL_inputStickeredMediaDocument;
import ir.eitaa.tgnet.TLRPC$TL_inputStickeredMediaPhoto;
import ir.eitaa.tgnet.TLRPC$TL_messages_getAttachedStickers;
import ir.eitaa.tgnet.TLRPC$TL_messages_getStickerSet;
import ir.eitaa.tgnet.TLRPC$TL_messages_installStickerSet;
import ir.eitaa.tgnet.TLRPC$TL_messages_stickerSet;
import ir.eitaa.tgnet.TLRPC$TL_messages_stickerSetInstallResultArchive;
import ir.eitaa.tgnet.TLRPC$TL_stickers_checkShortName;
import ir.eitaa.tgnet.TLRPC$TL_stickers_suggestShortName;
import ir.eitaa.tgnet.TLRPC$TL_stickers_suggestedShortName;
import ir.eitaa.tgnet.TLRPC$Vector;
import ir.eitaa.ui.ActionBar.ActionBarMenu;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.EmptyCell;
import ir.eitaa.ui.Cells.FeaturedStickerSetInfoCell;
import ir.eitaa.ui.Cells.StickerEmojiCell;
import ir.eitaa.ui.ChatActivity;
import ir.eitaa.ui.Components.Bulletin;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.ContentPreviewViewer;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import org.linphone.mediastream.Factory;

/* loaded from: classes3.dex */
public class StickersAlert extends BottomSheet implements NotificationCenter.NotificationCenterDelegate {
    private GridAdapter adapter;
    private List<ThemeDescription> animatingDescriptions;
    private String buttonTextColorKey;
    private int checkReqId;
    private Runnable checkRunnable;
    private boolean clearsInputField;
    private StickersAlertDelegate delegate;
    private FrameLayout emptyView;
    private RecyclerListView gridView;
    private boolean ignoreLayout;
    private String importingSoftware;
    private ArrayList<Parcelable> importingStickers;
    private ArrayList<SendMessagesHelper.ImportingSticker> importingStickersPaths;
    private TLRPC$InputStickerSet inputStickerSet;
    private StickersAlertInstallDelegate installDelegate;
    private int itemSize;
    private String lastCheckName;
    private boolean lastNameAvailable;
    private GridLayoutManager layoutManager;
    private ActionBarMenuItem optionsButton;
    private Activity parentActivity;
    private BaseFragment parentFragment;
    private TextView pickerBottomLayout;
    private ContentPreviewViewer.ContentPreviewViewerDelegate previewDelegate;
    private TextView previewSendButton;
    private View previewSendButtonShadow;
    private int reqId;
    private int scrollOffsetY;
    private TLRPC$Document selectedSticker;
    private SendMessagesHelper.ImportingSticker selectedStickerPath;
    private String setTitle;
    private View[] shadow;
    private AnimatorSet[] shadowAnimation;
    private boolean showEmoji;
    private boolean showTooltipWhenToggle;
    private TextView stickerEmojiTextView;
    private BackupImageView stickerImageView;
    private FrameLayout stickerPreviewLayout;
    private TLRPC$TL_messages_stickerSet stickerSet;
    private ArrayList<TLRPC$StickerSetCovered> stickerSetCovereds;
    private RecyclerListView.OnItemClickListener stickersOnItemClickListener;
    private TextView titleTextView;
    private HashMap<String, SendMessagesHelper.ImportingSticker> uploadImportStickers;
    private Pattern urlPattern;

    public interface StickersAlertDelegate {
        boolean isInScheduleMode();

        /* renamed from: onStickerSelected */
        void lambda$onStickerSelected$36(TLRPC$Document sticker, String query, Object parent, MessageObject.SendAnimationData sendAnimationData, boolean clearsInputField, boolean notify, int scheduleDate);
    }

    public interface StickersAlertInstallDelegate {
        void onStickerSetInstalled();

        void onStickerSetUninstalled();
    }

    static /* synthetic */ boolean lambda$init$9(View view, MotionEvent motionEvent) {
        return true;
    }

    static /* synthetic */ void lambda$showNameEnterAlert$20(DialogInterface dialogInterface, int i) {
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    protected boolean canDismissWithSwipe() {
        return false;
    }

    private static class LinkMovementMethodMy extends LinkMovementMethod {
        private LinkMovementMethodMy() {
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
            try {
                boolean zOnTouchEvent = super.onTouchEvent(widget, buffer, event);
                if (event.getAction() == 1 || event.getAction() == 3) {
                    Selection.removeSelection(buffer);
                }
                return zOnTouchEvent;
            } catch (Exception e) {
                FileLog.e(e);
                return false;
            }
        }
    }

    public StickersAlert(Context context, final Object parentObject, TLObject object, Theme.ResourcesProvider resourcesProvider) {
        super(context, false, resourcesProvider);
        this.shadowAnimation = new AnimatorSet[2];
        this.shadow = new View[2];
        this.showTooltipWhenToggle = true;
        this.previewDelegate = new ContentPreviewViewer.ContentPreviewViewerDelegate() { // from class: ir.eitaa.ui.Components.StickersAlert.1
            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ String getQuery(boolean z) {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$getQuery(this, z);
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ void gifAddedOrDeleted() {
                ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$gifAddedOrDeleted(this);
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ boolean needMenu() {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$needMenu(this);
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public boolean needOpen() {
                return false;
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public void openSet(TLRPC$InputStickerSet set, boolean clearsInputField) {
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ void sendGif(Object obj, Object obj2, boolean z, int i) {
                ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$sendGif(this, obj, obj2, z, i);
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public void sendSticker(TLRPC$Document sticker, String query, Object parent, boolean notify, int scheduleDate) {
                if (StickersAlert.this.delegate == null) {
                    return;
                }
                StickersAlert.this.delegate.lambda$onStickerSelected$36(sticker, query, parent, null, StickersAlert.this.clearsInputField, notify, scheduleDate);
                StickersAlert.this.dismiss();
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public boolean isInScheduleMode() {
                return StickersAlert.this.delegate != null && StickersAlert.this.delegate.isInScheduleMode();
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public boolean needRemove() {
                return StickersAlert.this.importingStickers != null;
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public void remove(SendMessagesHelper.ImportingSticker importingSticker) {
                StickersAlert.this.removeSticker(importingSticker);
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public boolean needSend() {
                return StickersAlert.this.previewSendButton.getVisibility() == 0 && StickersAlert.this.importingStickers == null;
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public long getDialogId() {
                if (StickersAlert.this.parentFragment instanceof ChatActivity) {
                    return ((ChatActivity) StickersAlert.this.parentFragment).getDialogId();
                }
                return 0L;
            }
        };
        this.resourcesProvider = resourcesProvider;
        this.parentActivity = (Activity) context;
        final TLRPC$TL_messages_getAttachedStickers tLRPC$TL_messages_getAttachedStickers = new TLRPC$TL_messages_getAttachedStickers();
        if (object instanceof TLRPC$Photo) {
            TLRPC$Photo tLRPC$Photo = (TLRPC$Photo) object;
            TLRPC$TL_inputStickeredMediaPhoto tLRPC$TL_inputStickeredMediaPhoto = new TLRPC$TL_inputStickeredMediaPhoto();
            TLRPC$TL_inputPhoto tLRPC$TL_inputPhoto = new TLRPC$TL_inputPhoto();
            tLRPC$TL_inputStickeredMediaPhoto.id = tLRPC$TL_inputPhoto;
            tLRPC$TL_inputPhoto.id = tLRPC$Photo.id;
            tLRPC$TL_inputPhoto.access_hash = tLRPC$Photo.access_hash;
            byte[] bArr = tLRPC$Photo.file_reference;
            tLRPC$TL_inputPhoto.file_reference = bArr;
            if (bArr == null) {
                tLRPC$TL_inputPhoto.file_reference = new byte[0];
            }
            tLRPC$TL_messages_getAttachedStickers.media = tLRPC$TL_inputStickeredMediaPhoto;
        } else if (object instanceof TLRPC$Document) {
            TLRPC$Document tLRPC$Document = (TLRPC$Document) object;
            TLRPC$TL_inputStickeredMediaDocument tLRPC$TL_inputStickeredMediaDocument = new TLRPC$TL_inputStickeredMediaDocument();
            TLRPC$TL_inputDocument tLRPC$TL_inputDocument = new TLRPC$TL_inputDocument();
            tLRPC$TL_inputStickeredMediaDocument.id = tLRPC$TL_inputDocument;
            tLRPC$TL_inputDocument.id = tLRPC$Document.id;
            tLRPC$TL_inputDocument.access_hash = tLRPC$Document.access_hash;
            byte[] bArr2 = tLRPC$Document.file_reference;
            tLRPC$TL_inputDocument.file_reference = bArr2;
            if (bArr2 == null) {
                tLRPC$TL_inputDocument.file_reference = new byte[0];
            }
            tLRPC$TL_messages_getAttachedStickers.media = tLRPC$TL_inputStickeredMediaDocument;
        }
        final RequestDelegate requestDelegate = new RequestDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$StickersAlert$6y22ZWwF93CrO3yLPQwt4K9nKmY
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$new$1$StickersAlert(tLRPC$TL_messages_getAttachedStickers, tLObject, tLRPC$TL_error);
            }
        };
        this.reqId = ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_messages_getAttachedStickers, new RequestDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$StickersAlert$LXoQOEO4I8eTdds6G66DgTJ403M
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$new$2$StickersAlert(parentObject, tLRPC$TL_messages_getAttachedStickers, requestDelegate, tLObject, tLRPC$TL_error);
            }
        });
        init(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$StickersAlert(final TLRPC$TL_messages_getAttachedStickers tLRPC$TL_messages_getAttachedStickers, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$StickersAlert$670wTJOSBUC-kpi7x7QySm1T_TI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0$StickersAlert(tLRPC$TL_error, tLObject, tLRPC$TL_messages_getAttachedStickers);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$StickersAlert(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, TLRPC$TL_messages_getAttachedStickers tLRPC$TL_messages_getAttachedStickers) {
        this.reqId = 0;
        if (tLRPC$TL_error == null) {
            TLRPC$Vector tLRPC$Vector = (TLRPC$Vector) tLObject;
            if (tLRPC$Vector.objects.isEmpty()) {
                dismiss();
                return;
            }
            if (tLRPC$Vector.objects.size() == 1) {
                TLRPC$StickerSetCovered tLRPC$StickerSetCovered = (TLRPC$StickerSetCovered) tLRPC$Vector.objects.get(0);
                TLRPC$TL_inputStickerSetID tLRPC$TL_inputStickerSetID = new TLRPC$TL_inputStickerSetID();
                this.inputStickerSet = tLRPC$TL_inputStickerSetID;
                TLRPC$StickerSet tLRPC$StickerSet = tLRPC$StickerSetCovered.set;
                tLRPC$TL_inputStickerSetID.id = tLRPC$StickerSet.id;
                tLRPC$TL_inputStickerSetID.access_hash = tLRPC$StickerSet.access_hash;
                loadStickerSet();
                return;
            }
            this.stickerSetCovereds = new ArrayList<>();
            for (int i = 0; i < tLRPC$Vector.objects.size(); i++) {
                this.stickerSetCovereds.add((TLRPC$StickerSetCovered) tLRPC$Vector.objects.get(i));
            }
            this.gridView.setLayoutParams(LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 0.0f, 0.0f, 48.0f));
            this.titleTextView.setVisibility(8);
            this.shadow[0].setVisibility(8);
            this.adapter.notifyDataSetChanged();
            return;
        }
        AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, this.parentFragment, tLRPC$TL_messages_getAttachedStickers, new Object[0]);
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$2$StickersAlert(Object obj, TLRPC$TL_messages_getAttachedStickers tLRPC$TL_messages_getAttachedStickers, RequestDelegate requestDelegate, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null && FileRefController.isFileRefError(tLRPC$TL_error.text) && obj != null) {
            FileRefController.getInstance(this.currentAccount).requestReference(obj, tLRPC$TL_messages_getAttachedStickers, requestDelegate);
        } else {
            requestDelegate.run(tLObject, tLRPC$TL_error);
        }
    }

    public StickersAlert(Context context, String software, final ArrayList<Parcelable> uris, final ArrayList<String> emoji, Theme.ResourcesProvider resourcesProvider) {
        super(context, false, resourcesProvider);
        this.shadowAnimation = new AnimatorSet[2];
        this.shadow = new View[2];
        this.showTooltipWhenToggle = true;
        this.previewDelegate = new ContentPreviewViewer.ContentPreviewViewerDelegate() { // from class: ir.eitaa.ui.Components.StickersAlert.1
            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ String getQuery(boolean z) {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$getQuery(this, z);
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ void gifAddedOrDeleted() {
                ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$gifAddedOrDeleted(this);
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ boolean needMenu() {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$needMenu(this);
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public boolean needOpen() {
                return false;
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public void openSet(TLRPC$InputStickerSet set, boolean clearsInputField) {
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ void sendGif(Object obj, Object obj2, boolean z, int i) {
                ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$sendGif(this, obj, obj2, z, i);
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public void sendSticker(TLRPC$Document sticker, String query, Object parent, boolean notify, int scheduleDate) {
                if (StickersAlert.this.delegate == null) {
                    return;
                }
                StickersAlert.this.delegate.lambda$onStickerSelected$36(sticker, query, parent, null, StickersAlert.this.clearsInputField, notify, scheduleDate);
                StickersAlert.this.dismiss();
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public boolean isInScheduleMode() {
                return StickersAlert.this.delegate != null && StickersAlert.this.delegate.isInScheduleMode();
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public boolean needRemove() {
                return StickersAlert.this.importingStickers != null;
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public void remove(SendMessagesHelper.ImportingSticker importingSticker) {
                StickersAlert.this.removeSticker(importingSticker);
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public boolean needSend() {
                return StickersAlert.this.previewSendButton.getVisibility() == 0 && StickersAlert.this.importingStickers == null;
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public long getDialogId() {
                if (StickersAlert.this.parentFragment instanceof ChatActivity) {
                    return ((ChatActivity) StickersAlert.this.parentFragment).getDialogId();
                }
                return 0L;
            }
        };
        this.parentActivity = (Activity) context;
        this.importingStickers = uris;
        this.importingSoftware = software;
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$StickersAlert$JOWAuRjeALrZsoWSNE5WhKYvt6c
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.lambda$new$4$StickersAlert(uris, emoji);
            }
        });
        init(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$4$StickersAlert(ArrayList arrayList, ArrayList arrayList2) throws Throwable {
        Uri uri;
        String stickerExt;
        int i;
        final ArrayList arrayList3 = new ArrayList();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        int size = arrayList.size();
        final Boolean boolValueOf = null;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = arrayList.get(i2);
            if ((obj instanceof Uri) && (stickerExt = MediaController.getStickerExt((uri = (Uri) obj))) != null) {
                boolean zEquals = "tgs".equals(stickerExt);
                if (boolValueOf == null) {
                    boolValueOf = Boolean.valueOf(zEquals);
                } else if (boolValueOf.booleanValue() != zEquals) {
                    continue;
                }
                if (isDismissed()) {
                    return;
                }
                SendMessagesHelper.ImportingSticker importingSticker = new SendMessagesHelper.ImportingSticker();
                importingSticker.animated = zEquals;
                String strCopyFileToCache = MediaController.copyFileToCache(uri, stickerExt, (zEquals ? 64 : Factory.DEVICE_USE_ANDROID_CAMCORDER) * Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV);
                importingSticker.path = strCopyFileToCache;
                if (strCopyFileToCache != null) {
                    if (!zEquals) {
                        BitmapFactory.decodeFile(strCopyFileToCache, options);
                        int i3 = options.outWidth;
                        if ((i3 == 512 && (i = options.outHeight) > 0 && i <= 512) || (options.outHeight == 512 && i3 > 0 && i3 <= 512)) {
                            importingSticker.mimeType = "image/" + stickerExt;
                            importingSticker.validated = true;
                        }
                    } else {
                        importingSticker.mimeType = "application/x-tgsticker";
                    }
                    if (arrayList2 != null && arrayList2.size() == size && (arrayList2.get(i2) instanceof String)) {
                        importingSticker.emoji = (String) arrayList2.get(i2);
                    } else {
                        importingSticker.emoji = "#️⃣";
                    }
                    arrayList3.add(importingSticker);
                    if (arrayList3.size() >= 200) {
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$StickersAlert$qcvrhU0rRi9WVQza6QGsxo6E6WQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$3$StickersAlert(arrayList3, boolValueOf);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$3$StickersAlert(ArrayList arrayList, Boolean bool) {
        this.importingStickersPaths = arrayList;
        if (arrayList.isEmpty()) {
            dismiss();
            return;
        }
        this.adapter.notifyDataSetChanged();
        if (bool.booleanValue()) {
            this.uploadImportStickers = new HashMap<>();
            int size = this.importingStickersPaths.size();
            for (int i = 0; i < size; i++) {
                SendMessagesHelper.ImportingSticker importingSticker = this.importingStickersPaths.get(i);
                this.uploadImportStickers.put(importingSticker.path, importingSticker);
                FileLoader.getInstance(this.currentAccount).uploadFile(importingSticker.path, false, true, ConnectionsManager.FileTypeFile);
            }
        }
        updateFields();
    }

    public StickersAlert(Context context, BaseFragment baseFragment, TLRPC$InputStickerSet set, TLRPC$TL_messages_stickerSet loadedSet, StickersAlertDelegate stickersAlertDelegate) {
        this(context, baseFragment, set, loadedSet, stickersAlertDelegate, null);
    }

    public StickersAlert(Context context, BaseFragment baseFragment, TLRPC$InputStickerSet set, TLRPC$TL_messages_stickerSet loadedSet, StickersAlertDelegate stickersAlertDelegate, Theme.ResourcesProvider resourcesProvider) {
        super(context, false, resourcesProvider);
        this.shadowAnimation = new AnimatorSet[2];
        this.shadow = new View[2];
        this.showTooltipWhenToggle = true;
        this.previewDelegate = new ContentPreviewViewer.ContentPreviewViewerDelegate() { // from class: ir.eitaa.ui.Components.StickersAlert.1
            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ String getQuery(boolean z) {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$getQuery(this, z);
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ void gifAddedOrDeleted() {
                ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$gifAddedOrDeleted(this);
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ boolean needMenu() {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$needMenu(this);
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public boolean needOpen() {
                return false;
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public void openSet(TLRPC$InputStickerSet set2, boolean clearsInputField) {
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ void sendGif(Object obj, Object obj2, boolean z, int i) {
                ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$sendGif(this, obj, obj2, z, i);
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public void sendSticker(TLRPC$Document sticker, String query, Object parent, boolean notify, int scheduleDate) {
                if (StickersAlert.this.delegate == null) {
                    return;
                }
                StickersAlert.this.delegate.lambda$onStickerSelected$36(sticker, query, parent, null, StickersAlert.this.clearsInputField, notify, scheduleDate);
                StickersAlert.this.dismiss();
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public boolean isInScheduleMode() {
                return StickersAlert.this.delegate != null && StickersAlert.this.delegate.isInScheduleMode();
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public boolean needRemove() {
                return StickersAlert.this.importingStickers != null;
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public void remove(SendMessagesHelper.ImportingSticker importingSticker) {
                StickersAlert.this.removeSticker(importingSticker);
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public boolean needSend() {
                return StickersAlert.this.previewSendButton.getVisibility() == 0 && StickersAlert.this.importingStickers == null;
            }

            @Override // ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public long getDialogId() {
                if (StickersAlert.this.parentFragment instanceof ChatActivity) {
                    return ((ChatActivity) StickersAlert.this.parentFragment).getDialogId();
                }
                return 0L;
            }
        };
        this.delegate = stickersAlertDelegate;
        this.inputStickerSet = set;
        this.stickerSet = loadedSet;
        this.parentFragment = baseFragment;
        loadStickerSet();
        init(context);
    }

    public void setClearsInputField(boolean value) {
        this.clearsInputField = value;
    }

    private void loadStickerSet() {
        String str;
        if (this.inputStickerSet != null) {
            final MediaDataController mediaDataController = MediaDataController.getInstance(this.currentAccount);
            if (this.stickerSet == null && (str = this.inputStickerSet.short_name) != null) {
                this.stickerSet = mediaDataController.getStickerSetByName(str);
            }
            if (this.stickerSet == null) {
                this.stickerSet = mediaDataController.getStickerSetById(this.inputStickerSet.id);
            }
            if (this.stickerSet == null) {
                TLRPC$TL_messages_getStickerSet tLRPC$TL_messages_getStickerSet = new TLRPC$TL_messages_getStickerSet();
                tLRPC$TL_messages_getStickerSet.stickerset = this.inputStickerSet;
                ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_messages_getStickerSet, new RequestDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$StickersAlert$vO5yQ73tF2KKjmptBCYfUAKuqK4
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$loadStickerSet$6$StickersAlert(mediaDataController, tLObject, tLRPC$TL_error);
                    }
                });
            } else {
                if (this.adapter != null) {
                    updateSendButton();
                    updateFields();
                    this.adapter.notifyDataSetChanged();
                }
                mediaDataController.preloadStickerSetThumb(this.stickerSet);
            }
        }
        if (this.stickerSet != null) {
            this.showEmoji = !r0.set.masks;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadStickerSet$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadStickerSet$6$StickersAlert(final MediaDataController mediaDataController, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$StickersAlert$rehGZQBEXYL70BfVIg2E15L5Dj4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadStickerSet$5$StickersAlert(tLRPC$TL_error, tLObject, mediaDataController);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadStickerSet$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadStickerSet$5$StickersAlert(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, MediaDataController mediaDataController) {
        this.reqId = 0;
        if (tLRPC$TL_error == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2();
                anonymousClass2.addTarget(this.containerView);
                TransitionManager.beginDelayedTransition(this.container, anonymousClass2);
            }
            this.optionsButton.setVisibility(0);
            TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = (TLRPC$TL_messages_stickerSet) tLObject;
            this.stickerSet = tLRPC$TL_messages_stickerSet;
            this.showEmoji = !tLRPC$TL_messages_stickerSet.set.masks;
            mediaDataController.preloadStickerSetThumb(tLRPC$TL_messages_stickerSet);
            updateSendButton();
            updateFields();
            this.adapter.notifyDataSetChanged();
            return;
        }
        Toast.makeText(getContext(), LocaleController.getString("AddStickersNotFound", R.string.AddStickersNotFound), 0).show();
        dismiss();
    }

    /* renamed from: ir.eitaa.ui.Components.StickersAlert$2, reason: invalid class name */
    class AnonymousClass2 extends Transition {
        AnonymousClass2() {
        }

        @Override // android.transition.Transition
        public void captureStartValues(TransitionValues transitionValues) {
            transitionValues.values.put("start", Boolean.TRUE);
            transitionValues.values.put("offset", Integer.valueOf(((BottomSheet) StickersAlert.this).containerView.getTop() + StickersAlert.this.scrollOffsetY));
        }

        @Override // android.transition.Transition
        public void captureEndValues(TransitionValues transitionValues) {
            transitionValues.values.put("start", Boolean.FALSE);
            transitionValues.values.put("offset", Integer.valueOf(((BottomSheet) StickersAlert.this).containerView.getTop() + StickersAlert.this.scrollOffsetY));
        }

        @Override // android.transition.Transition
        public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues, TransitionValues endValues) {
            final int i = StickersAlert.this.scrollOffsetY;
            final int iIntValue = ((Integer) startValues.values.get("offset")).intValue() - ((Integer) endValues.values.get("offset")).intValue();
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.setDuration(250L);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$StickersAlert$2$2HfqL8rsYoLQCotXigdFEHOuGpM
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$createAnimator$0$StickersAlert$2(iIntValue, i, valueAnimator);
                }
            });
            return valueAnimatorOfFloat;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$createAnimator$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$createAnimator$0$StickersAlert$2(int i, int i2, ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            StickersAlert.this.gridView.setAlpha(animatedFraction);
            StickersAlert.this.titleTextView.setAlpha(animatedFraction);
            if (i != 0) {
                int i3 = (int) (i * (1.0f - animatedFraction));
                StickersAlert.this.setScrollOffsetY(i2 + i3);
                StickersAlert.this.gridView.setTranslationY(i3);
            }
        }
    }

    private void init(Context context) {
        FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.eitaa.ui.Components.StickersAlert.3
            private boolean fullHeight;
            private int lastNotifyWidth;
            private RectF rect = new RectF();

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent ev) {
                if (ev.getAction() == 0 && StickersAlert.this.scrollOffsetY != 0 && ev.getY() < StickersAlert.this.scrollOffsetY) {
                    StickersAlert.this.dismiss();
                    return true;
                }
                return super.onInterceptTouchEvent(ev);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent e) {
                return !StickersAlert.this.isDismissed() && super.onTouchEvent(e);
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                int iDp;
                int iDp2;
                int size = View.MeasureSpec.getSize(heightMeasureSpec);
                if (Build.VERSION.SDK_INT >= 21) {
                    StickersAlert.this.ignoreLayout = true;
                    setPadding(((BottomSheet) StickersAlert.this).backgroundPaddingLeft, AndroidUtilities.statusBarHeight, ((BottomSheet) StickersAlert.this).backgroundPaddingLeft, 0);
                    StickersAlert.this.ignoreLayout = false;
                }
                StickersAlert.this.itemSize = (View.MeasureSpec.getSize(widthMeasureSpec) - AndroidUtilities.dp(36.0f)) / 5;
                if (StickersAlert.this.importingStickers != null) {
                    iDp = AndroidUtilities.dp(96.0f) + (Math.max(3, (int) Math.ceil(StickersAlert.this.importingStickers.size() / 5.0f)) * AndroidUtilities.dp(82.0f)) + ((BottomSheet) StickersAlert.this).backgroundPaddingTop;
                    iDp2 = AndroidUtilities.statusBarHeight;
                } else if (StickersAlert.this.stickerSetCovereds != null) {
                    iDp = AndroidUtilities.dp(56.0f) + (AndroidUtilities.dp(60.0f) * StickersAlert.this.stickerSetCovereds.size()) + (StickersAlert.this.adapter.stickersRowCount * AndroidUtilities.dp(82.0f)) + ((BottomSheet) StickersAlert.this).backgroundPaddingTop;
                    iDp2 = AndroidUtilities.dp(24.0f);
                } else {
                    iDp = AndroidUtilities.dp(96.0f) + (Math.max(3, StickersAlert.this.stickerSet != null ? (int) Math.ceil(StickersAlert.this.stickerSet.documents.size() / 5.0f) : 0) * AndroidUtilities.dp(82.0f)) + ((BottomSheet) StickersAlert.this).backgroundPaddingTop;
                    iDp2 = AndroidUtilities.statusBarHeight;
                }
                int i = iDp + iDp2;
                double d = i;
                int i2 = size / 5;
                double d2 = i2;
                Double.isNaN(d2);
                int iDp3 = d < d2 * 3.2d ? 0 : i2 * 2;
                if (iDp3 != 0 && i < size) {
                    iDp3 -= size - i;
                }
                if (iDp3 == 0) {
                    iDp3 = ((BottomSheet) StickersAlert.this).backgroundPaddingTop;
                }
                if (StickersAlert.this.stickerSetCovereds != null) {
                    iDp3 += AndroidUtilities.dp(8.0f);
                }
                if (StickersAlert.this.gridView.getPaddingTop() != iDp3) {
                    StickersAlert.this.ignoreLayout = true;
                    StickersAlert.this.gridView.setPadding(AndroidUtilities.dp(10.0f), iDp3, AndroidUtilities.dp(10.0f), 0);
                    StickersAlert.this.emptyView.setPadding(0, iDp3, 0, 0);
                    StickersAlert.this.ignoreLayout = false;
                }
                this.fullHeight = i >= size;
                super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.min(i, size), 1073741824));
            }

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                int i = right - left;
                if (this.lastNotifyWidth != i) {
                    this.lastNotifyWidth = i;
                    if (StickersAlert.this.adapter != null && StickersAlert.this.stickerSetCovereds != null) {
                        StickersAlert.this.adapter.notifyDataSetChanged();
                    }
                }
                super.onLayout(changed, left, top, right, bottom);
                StickersAlert.this.updateLayout();
            }

            @Override // android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (StickersAlert.this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }

            /* JADX WARN: Removed duplicated region for block: B:13:0x0092 A[PHI: r0 r1 r2
              0x0092: PHI (r0v4 int) = (r0v3 int), (r0v25 int) binds: [B:3:0x0041, B:5:0x004a] A[DONT_GENERATE, DONT_INLINE]
              0x0092: PHI (r1v8 int) = (r1v7 int), (r1v27 int) binds: [B:3:0x0041, B:5:0x004a] A[DONT_GENERATE, DONT_INLINE]
              0x0092: PHI (r2v7 int) = (r2v6 int), (r2v17 int) binds: [B:3:0x0041, B:5:0x004a] A[DONT_GENERATE, DONT_INLINE]] */
            @Override // android.view.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            protected void onDraw(android.graphics.Canvas r14) {
                /*
                    Method dump skipped, instructions count: 405
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.StickersAlert.AnonymousClass3.onDraw(android.graphics.Canvas):void");
            }
        };
        this.containerView = frameLayout;
        frameLayout.setWillNotDraw(false);
        ViewGroup viewGroup = this.containerView;
        int i = this.backgroundPaddingLeft;
        viewGroup.setPadding(i, 0, i, 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, AndroidUtilities.getShadowHeight(), 51);
        layoutParams.topMargin = AndroidUtilities.dp(48.0f);
        this.shadow[0] = new View(context);
        this.shadow[0].setBackgroundColor(getThemedColor("dialogShadowLine"));
        this.shadow[0].setAlpha(0.0f);
        this.shadow[0].setVisibility(4);
        this.shadow[0].setTag(1);
        this.containerView.addView(this.shadow[0], layoutParams);
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: ir.eitaa.ui.Components.StickersAlert.4
            @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent event) {
                return super.onInterceptTouchEvent(event) || ContentPreviewViewer.getInstance().onInterceptTouchEvent(event, StickersAlert.this.gridView, 0, StickersAlert.this.previewDelegate, this.resourcesProvider);
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (StickersAlert.this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }
        };
        this.gridView = recyclerListView;
        recyclerListView.setTag(14);
        RecyclerListView recyclerListView2 = this.gridView;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 5) { // from class: ir.eitaa.ui.Components.StickersAlert.5
            @Override // androidx.recyclerview.widget.LinearLayoutManager
            protected boolean isLayoutRTL() {
                return StickersAlert.this.stickerSetCovereds != null && LocaleController.isRTL;
            }
        };
        this.layoutManager = gridLayoutManager;
        recyclerListView2.setLayoutManager(gridLayoutManager);
        this.layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: ir.eitaa.ui.Components.StickersAlert.6
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int position) {
                if ((StickersAlert.this.stickerSetCovereds == null || !(StickersAlert.this.adapter.cache.get(position) instanceof Integer)) && position != StickersAlert.this.adapter.totalItems) {
                    return 1;
                }
                return StickersAlert.this.adapter.stickersPerRow;
            }
        });
        RecyclerListView recyclerListView3 = this.gridView;
        GridAdapter gridAdapter = new GridAdapter(context);
        this.adapter = gridAdapter;
        recyclerListView3.setAdapter(gridAdapter);
        this.gridView.setVerticalScrollBarEnabled(false);
        this.gridView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: ir.eitaa.ui.Components.StickersAlert.7
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(android.graphics.Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.left = 0;
                outRect.right = 0;
                outRect.bottom = 0;
                outRect.top = 0;
            }
        });
        this.gridView.setPadding(AndroidUtilities.dp(10.0f), 0, AndroidUtilities.dp(10.0f), 0);
        this.gridView.setClipToPadding(false);
        this.gridView.setEnabled(true);
        this.gridView.setGlowColor(getThemedColor("dialogScrollGlow"));
        this.gridView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$StickersAlert$neZwFzU6pKwzPuf4Wd8cRKrJdy8
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f$0.lambda$init$7$StickersAlert(view, motionEvent);
            }
        });
        this.gridView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.Components.StickersAlert.8
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                StickersAlert.this.updateLayout();
            }
        });
        RecyclerListView.OnItemClickListener onItemClickListener = new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$StickersAlert$bJf-gOqIunyN_WzguwuZS4qf7E8
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i2) {
                this.f$0.lambda$init$8$StickersAlert(view, i2);
            }
        };
        this.stickersOnItemClickListener = onItemClickListener;
        this.gridView.setOnItemClickListener(onItemClickListener);
        this.containerView.addView(this.gridView, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 48.0f, 0.0f, 48.0f));
        FrameLayout frameLayout2 = new FrameLayout(context) { // from class: ir.eitaa.ui.Components.StickersAlert.9
            @Override // android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (StickersAlert.this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }
        };
        this.emptyView = frameLayout2;
        this.containerView.addView(frameLayout2, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 0.0f, 0.0f, 48.0f));
        this.gridView.setEmptyView(this.emptyView);
        this.emptyView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$StickersAlert$gp4vdzxkJ0KIwfOQwMguDNyZGBw
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return StickersAlert.lambda$init$9(view, motionEvent);
            }
        });
        TextView textView = new TextView(context);
        this.titleTextView = textView;
        textView.setLines(1);
        this.titleTextView.setSingleLine(true);
        this.titleTextView.setTextColor(getThemedColor("dialogTextBlack"));
        this.titleTextView.setTextSize(1, 20.0f);
        this.titleTextView.setLinkTextColor(getThemedColor("dialogTextLink"));
        this.titleTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.titleTextView.setPadding(AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f), 0);
        this.titleTextView.setGravity(16);
        this.titleTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.containerView.addView(this.titleTextView, LayoutHelper.createFrame(-1, 50.0f, 51, 0.0f, 0.0f, 40.0f, 0.0f));
        ActionBarMenuItem actionBarMenuItem = new ActionBarMenuItem(context, (ActionBarMenu) null, 0, getThemedColor("key_sheet_other"), this.resourcesProvider);
        this.optionsButton = actionBarMenuItem;
        actionBarMenuItem.setLongClickEnabled(false);
        this.optionsButton.setSubMenuOpenSide(2);
        this.optionsButton.setIcon(R.drawable.ic_ab_other);
        this.optionsButton.setBackgroundDrawable(Theme.createSelectorDrawable(getThemedColor("player_actionBarSelector"), 1));
        this.containerView.addView(this.optionsButton, LayoutHelper.createFrame(40, 40.0f, 53, 0.0f, 5.0f, 5.0f, 0.0f));
        this.optionsButton.addSubItem(1, R.drawable.msg_share, LocaleController.getString("StickersShare", R.string.StickersShare));
        this.optionsButton.addSubItem(2, R.drawable.msg_link, LocaleController.getString("CopyLink", R.string.CopyLink));
        this.optionsButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$StickersAlert$wtXv-lUfgyGXtkA1rjSm-JCBHbw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$init$10$StickersAlert(view);
            }
        });
        this.optionsButton.setDelegate(new ActionBarMenuItem.ActionBarMenuItemDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$StickersAlert$4ZEJuYlaenrS2K_Ho8IZrnI4AWY
            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemDelegate
            public final void onItemClick(int i2) {
                this.f$0.onSubItemClick(i2);
            }
        });
        this.optionsButton.setContentDescription(LocaleController.getString("AccDescrMoreOptions", R.string.AccDescrMoreOptions));
        this.optionsButton.setVisibility(this.inputStickerSet != null ? 0 : 8);
        this.emptyView.addView(new RadialProgressView(context), LayoutHelper.createFrame(-2, -2, 17));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, AndroidUtilities.getShadowHeight(), 83);
        layoutParams2.bottomMargin = AndroidUtilities.dp(48.0f);
        this.shadow[1] = new View(context);
        this.shadow[1].setBackgroundColor(getThemedColor("dialogShadowLine"));
        this.containerView.addView(this.shadow[1], layoutParams2);
        TextView textView2 = new TextView(context);
        this.pickerBottomLayout = textView2;
        textView2.setBackgroundDrawable(Theme.createSelectorWithBackgroundDrawable(getThemedColor("dialogBackground"), getThemedColor("listSelectorSDK21")));
        TextView textView3 = this.pickerBottomLayout;
        this.buttonTextColorKey = "dialogTextBlue2";
        textView3.setTextColor(getThemedColor("dialogTextBlue2"));
        this.pickerBottomLayout.setTextSize(1, 14.0f);
        this.pickerBottomLayout.setPadding(AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f), 0);
        this.pickerBottomLayout.setTypeface(AndroidUtilities.getFontFamily(true));
        this.pickerBottomLayout.setGravity(17);
        this.containerView.addView(this.pickerBottomLayout, LayoutHelper.createFrame(-1, 48, 83));
        FrameLayout frameLayout3 = new FrameLayout(context);
        this.stickerPreviewLayout = frameLayout3;
        frameLayout3.setVisibility(8);
        this.stickerPreviewLayout.setSoundEffectsEnabled(false);
        this.containerView.addView(this.stickerPreviewLayout, LayoutHelper.createFrame(-1, -1.0f));
        this.stickerPreviewLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$StickersAlert$tVIAwz4M6Zfklg9siwd3_e3qCsA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$init$11$StickersAlert(view);
            }
        });
        BackupImageView backupImageView = new BackupImageView(context);
        this.stickerImageView = backupImageView;
        backupImageView.setAspectFit(true);
        this.stickerImageView.setLayerNum(7);
        this.stickerPreviewLayout.addView(this.stickerImageView);
        TextView textView4 = new TextView(context);
        this.stickerEmojiTextView = textView4;
        textView4.setTextSize(1, 30.0f);
        this.stickerEmojiTextView.setGravity(85);
        this.stickerPreviewLayout.addView(this.stickerEmojiTextView);
        TextView textView5 = new TextView(context);
        this.previewSendButton = textView5;
        textView5.setTextSize(1, 14.0f);
        this.previewSendButton.setTextColor(getThemedColor("dialogTextBlue2"));
        this.previewSendButton.setBackground(Theme.createSelectorWithBackgroundDrawable(getThemedColor("dialogBackground"), getThemedColor("listSelectorSDK21")));
        this.previewSendButton.setGravity(17);
        this.previewSendButton.setPadding(AndroidUtilities.dp(29.0f), 0, AndroidUtilities.dp(29.0f), 0);
        this.previewSendButton.setTypeface(AndroidUtilities.getFontFamily(true));
        this.stickerPreviewLayout.addView(this.previewSendButton, LayoutHelper.createFrame(-1, 48, 83));
        this.previewSendButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$StickersAlert$ru_osrsu_VDTELumdFpcBVbM-mI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$init$12$StickersAlert(view);
            }
        });
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, AndroidUtilities.getShadowHeight(), 83);
        layoutParams3.bottomMargin = AndroidUtilities.dp(48.0f);
        View view = new View(context);
        this.previewSendButtonShadow = view;
        view.setBackgroundColor(getThemedColor("dialogShadowLine"));
        this.stickerPreviewLayout.addView(this.previewSendButtonShadow, layoutParams3);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.emojiLoaded);
        if (this.importingStickers != null) {
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.fileUploaded);
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.fileUploadFailed);
        }
        updateFields();
        updateSendButton();
        updateColors();
        this.adapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$init$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$init$7$StickersAlert(View view, MotionEvent motionEvent) {
        return ContentPreviewViewer.getInstance().onTouch(motionEvent, this.gridView, 0, this.stickersOnItemClickListener, this.previewDelegate, this.resourcesProvider);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$init$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$init$8$StickersAlert(View view, int i) {
        boolean z;
        if (this.stickerSetCovereds == null) {
            ArrayList<SendMessagesHelper.ImportingSticker> arrayList = this.importingStickersPaths;
            if (arrayList != null) {
                if (i < 0 || i >= arrayList.size()) {
                    return;
                }
                SendMessagesHelper.ImportingSticker importingSticker = this.importingStickersPaths.get(i);
                this.selectedStickerPath = importingSticker;
                if (importingSticker.validated) {
                    TextView textView = this.stickerEmojiTextView;
                    textView.setText(Emoji.replaceEmoji(importingSticker.emoji, textView.getPaint().getFontMetricsInt(), AndroidUtilities.dp(30.0f), false));
                    this.stickerImageView.setImage(ImageLocation.getForPath(this.selectedStickerPath.path), null, null, null, null, null, this.selectedStickerPath.animated ? "tgs" : null, 0, null);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.stickerPreviewLayout.getLayoutParams();
                    layoutParams.topMargin = this.scrollOffsetY;
                    this.stickerPreviewLayout.setLayoutParams(layoutParams);
                    this.stickerPreviewLayout.setVisibility(0);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(ObjectAnimator.ofFloat(this.stickerPreviewLayout, (Property<FrameLayout, Float>) View.ALPHA, 0.0f, 1.0f));
                    animatorSet.setDuration(200L);
                    animatorSet.start();
                    return;
                }
                return;
            }
            TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = this.stickerSet;
            if (tLRPC$TL_messages_stickerSet == null || i < 0 || i >= tLRPC$TL_messages_stickerSet.documents.size()) {
                return;
            }
            this.selectedSticker = this.stickerSet.documents.get(i);
            int i2 = 0;
            while (true) {
                if (i2 >= this.selectedSticker.attributes.size()) {
                    break;
                }
                TLRPC$DocumentAttribute tLRPC$DocumentAttribute = this.selectedSticker.attributes.get(i2);
                if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeSticker) {
                    String str = tLRPC$DocumentAttribute.alt;
                    if (str == null || str.length() <= 0) {
                        break;
                    }
                    TextView textView2 = this.stickerEmojiTextView;
                    textView2.setText(Emoji.replaceEmoji(tLRPC$DocumentAttribute.alt, textView2.getPaint().getFontMetricsInt(), AndroidUtilities.dp(30.0f), false));
                    z = true;
                } else {
                    i2++;
                }
            }
            z = false;
            if (!z) {
                this.stickerEmojiTextView.setText(Emoji.replaceEmoji(MediaDataController.getInstance(this.currentAccount).getEmojiForSticker(this.selectedSticker.id), this.stickerEmojiTextView.getPaint().getFontMetricsInt(), AndroidUtilities.dp(30.0f), false));
            }
            this.stickerImageView.getImageReceiver().setImage(ImageLocation.getForDocument(this.selectedSticker), (String) null, ImageLocation.getForDocument(FileLoader.getClosestPhotoSizeWithSize(this.selectedSticker.thumbs, 90), this.selectedSticker), (String) null, "webp", this.stickerSet, 1);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.stickerPreviewLayout.getLayoutParams();
            layoutParams2.topMargin = this.scrollOffsetY;
            this.stickerPreviewLayout.setLayoutParams(layoutParams2);
            this.stickerPreviewLayout.setVisibility(0);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(ObjectAnimator.ofFloat(this.stickerPreviewLayout, (Property<FrameLayout, Float>) View.ALPHA, 0.0f, 1.0f));
            animatorSet2.setDuration(200L);
            animatorSet2.start();
            return;
        }
        TLRPC$StickerSetCovered tLRPC$StickerSetCovered = (TLRPC$StickerSetCovered) this.adapter.positionsToSets.get(i);
        if (tLRPC$StickerSetCovered != null) {
            dismiss();
            TLRPC$TL_inputStickerSetID tLRPC$TL_inputStickerSetID = new TLRPC$TL_inputStickerSetID();
            TLRPC$StickerSet tLRPC$StickerSet = tLRPC$StickerSetCovered.set;
            tLRPC$TL_inputStickerSetID.access_hash = tLRPC$StickerSet.access_hash;
            tLRPC$TL_inputStickerSetID.id = tLRPC$StickerSet.id;
            new StickersAlert(this.parentActivity, this.parentFragment, tLRPC$TL_inputStickerSetID, null, null, this.resourcesProvider).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$init$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$init$10$StickersAlert(View view) {
        this.optionsButton.toggleSubMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$init$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$init$11$StickersAlert(View view) {
        hidePreview();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$init$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$init$12$StickersAlert(View view) {
        if (this.importingStickersPaths != null) {
            removeSticker(this.selectedStickerPath);
            hidePreview();
            this.selectedStickerPath = null;
        } else {
            this.delegate.lambda$onStickerSelected$36(this.selectedSticker, null, this.stickerSet, null, this.clearsInputField, true, 0);
            dismiss();
        }
    }

    private void updateSendButton() {
        TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet;
        android.graphics.Point point = AndroidUtilities.displaySize;
        int iMin = (int) ((Math.min(point.x, point.y) / 2) / AndroidUtilities.density);
        if (this.importingStickers != null) {
            this.previewSendButton.setText(LocaleController.getString("ImportStickersRemove", R.string.ImportStickersRemove).toUpperCase());
            this.previewSendButton.setTextColor(getThemedColor("dialogTextRed"));
            float f = iMin;
            this.stickerImageView.setLayoutParams(LayoutHelper.createFrame(iMin, f, 17, 0.0f, 0.0f, 0.0f, 30.0f));
            this.stickerEmojiTextView.setLayoutParams(LayoutHelper.createFrame(iMin, f, 17, 0.0f, 0.0f, 0.0f, 30.0f));
            this.previewSendButton.setVisibility(0);
            this.previewSendButtonShadow.setVisibility(0);
            return;
        }
        if (this.delegate != null && ((tLRPC$TL_messages_stickerSet = this.stickerSet) == null || !tLRPC$TL_messages_stickerSet.set.masks)) {
            this.previewSendButton.setText(LocaleController.getString("SendSticker", R.string.SendSticker).toUpperCase());
            float f2 = iMin;
            this.stickerImageView.setLayoutParams(LayoutHelper.createFrame(iMin, f2, 17, 0.0f, 0.0f, 0.0f, 30.0f));
            this.stickerEmojiTextView.setLayoutParams(LayoutHelper.createFrame(iMin, f2, 17, 0.0f, 0.0f, 0.0f, 30.0f));
            this.previewSendButton.setVisibility(0);
            this.previewSendButtonShadow.setVisibility(0);
            return;
        }
        this.previewSendButton.setText(LocaleController.getString("Close", R.string.Close).toUpperCase());
        this.stickerImageView.setLayoutParams(LayoutHelper.createFrame(iMin, iMin, 17));
        this.stickerEmojiTextView.setLayoutParams(LayoutHelper.createFrame(iMin, iMin, 17));
        this.previewSendButton.setVisibility(8);
        this.previewSendButtonShadow.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSticker(SendMessagesHelper.ImportingSticker sticker) {
        int iIndexOf = this.importingStickersPaths.indexOf(sticker);
        if (iIndexOf >= 0) {
            this.importingStickersPaths.remove(iIndexOf);
            this.adapter.notifyItemRemoved(iIndexOf);
            if (this.importingStickersPaths.isEmpty()) {
                dismiss();
            } else {
                updateFields();
            }
        }
    }

    public void setInstallDelegate(StickersAlertInstallDelegate stickersAlertInstallDelegate) {
        this.installDelegate = stickersAlertInstallDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSubItemClick(int id) {
        BaseFragment baseFragment;
        if (this.stickerSet == null) {
            return;
        }
        String str = "https://" + MessagesController.getInstance(this.currentAccount).linkPrefix + "/addstickers/" + this.stickerSet.set.short_name;
        if (id != 1) {
            if (id == 2) {
                try {
                    AndroidUtilities.addToClipboard(str);
                    BulletinFactory.of((FrameLayout) this.containerView, this.resourcesProvider).createCopyLinkBulletin().show();
                    return;
                } catch (Exception e) {
                    FileLog.e(e);
                    return;
                }
            }
            return;
        }
        Context context = this.parentActivity;
        if (context == null && (baseFragment = this.parentFragment) != null) {
            context = baseFragment.getParentActivity();
        }
        if (context == null) {
            context = getContext();
        }
        ShareAlert shareAlert = new ShareAlert(context, null, str, false, str, false, this.resourcesProvider);
        BaseFragment baseFragment2 = this.parentFragment;
        if (baseFragment2 != null) {
            baseFragment2.showDialog(shareAlert);
        } else {
            shareAlert.show();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0129  */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r1v21, types: [android.text.SpannableStringBuilder] */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r7v7, types: [android.text.SpannableStringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void updateFields() {
        /*
            Method dump skipped, instructions count: 461
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.StickersAlert.updateFields():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateFields$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateFields$15$StickersAlert(View view) {
        dismiss();
        StickersAlertInstallDelegate stickersAlertInstallDelegate = this.installDelegate;
        if (stickersAlertInstallDelegate != null) {
            stickersAlertInstallDelegate.onStickerSetInstalled();
        }
        if (this.inputStickerSet == null || MediaDataController.getInstance(this.currentAccount).cancelRemovingStickerSet(this.inputStickerSet.id)) {
            return;
        }
        TLRPC$TL_messages_installStickerSet tLRPC$TL_messages_installStickerSet = new TLRPC$TL_messages_installStickerSet();
        tLRPC$TL_messages_installStickerSet.stickerset = this.inputStickerSet;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_messages_installStickerSet, new RequestDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$StickersAlert$e7BoWE0eSneOkgBgN8D8WsFEiHQ
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$updateFields$14$StickersAlert(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateFields$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateFields$14$StickersAlert(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$StickersAlert$Oj9lGcNQ5nG30-Ah5gauVcd9suc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateFields$13$StickersAlert(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateFields$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateFields$13$StickersAlert(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        boolean z = this.stickerSet.set.masks;
        try {
            if (tLRPC$TL_error == null) {
                if (this.showTooltipWhenToggle) {
                    Bulletin.make(this.parentFragment, new StickerSetBulletinLayout(this.pickerBottomLayout.getContext(), this.stickerSet, 2, null, this.resourcesProvider), 1500).show();
                }
                if (tLObject instanceof TLRPC$TL_messages_stickerSetInstallResultArchive) {
                    MediaDataController.getInstance(this.currentAccount).processStickerSetInstallResultArchive(this.parentFragment, true, z ? 1 : 0, (TLRPC$TL_messages_stickerSetInstallResultArchive) tLObject);
                }
            } else {
                Toast.makeText(getContext(), LocaleController.getString("ErrorOccurred", R.string.ErrorOccurred), 0).show();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        MediaDataController.getInstance(this.currentAccount).loadStickers(z ? 1 : 0, false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateFields$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateFields$16$StickersAlert(View view) {
        StickersAlertInstallDelegate stickersAlertInstallDelegate = this.installDelegate;
        if (stickersAlertInstallDelegate != null) {
            stickersAlertInstallDelegate.onStickerSetUninstalled();
        }
        dismiss();
        MediaDataController.getInstance(this.currentAccount).toggleStickerSet(getContext(), this.stickerSet, 1, this.parentFragment, true, this.showTooltipWhenToggle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateFields$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateFields$17$StickersAlert(View view) {
        StickersAlertInstallDelegate stickersAlertInstallDelegate = this.installDelegate;
        if (stickersAlertInstallDelegate != null) {
            stickersAlertInstallDelegate.onStickerSetUninstalled();
        }
        dismiss();
        MediaDataController.getInstance(this.currentAccount).toggleStickerSet(getContext(), this.stickerSet, 0, this.parentFragment, true, this.showTooltipWhenToggle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateFields$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateFields$18$StickersAlert(View view) {
        showNameEnterAlert();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateFields$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateFields$19$StickersAlert(View view) {
        dismiss();
    }

    private void showNameEnterAlert() {
        Context context = getContext();
        final int[] iArr = {0};
        FrameLayout frameLayout = new FrameLayout(context);
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(LocaleController.getString("ImportStickersEnterName", R.string.ImportStickersEnterName));
        builder.setPositiveButton(LocaleController.getString("Next", R.string.Next), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$StickersAlert$abBQEXKX57i0tHC-dI1fKRebHok
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                StickersAlert.lambda$showNameEnterAlert$20(dialogInterface, i);
            }
        });
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        builder.setView(linearLayout);
        linearLayout.addView(frameLayout, LayoutHelper.createLinear(-1, 36, 51, 24, 6, 24, 0));
        final TextView textView = new TextView(context);
        final TextView textView2 = new TextView(context);
        textView2.setTextSize(1, 16.0f);
        textView2.setTextColor(getThemedColor("dialogTextHint"));
        textView2.setMaxLines(1);
        textView2.setLines(1);
        textView2.setText("eitaa.com/addstickers/");
        textView2.setInputType(16385);
        textView2.setGravity(51);
        textView2.setSingleLine(true);
        textView2.setVisibility(4);
        textView2.setImeOptions(6);
        textView2.setPadding(0, AndroidUtilities.dp(4.0f), 0, 0);
        frameLayout.addView(textView2, LayoutHelper.createFrame(-2, 36, 51));
        final EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
        editTextBoldCursor.setBackgroundDrawable(Theme.createEditTextDrawable(context, true));
        editTextBoldCursor.setTextSize(1, 16.0f);
        editTextBoldCursor.setTextColor(getThemedColor("dialogTextBlack"));
        editTextBoldCursor.setMaxLines(1);
        editTextBoldCursor.setLines(1);
        editTextBoldCursor.setInputType(16385);
        editTextBoldCursor.setGravity(51);
        editTextBoldCursor.setSingleLine(true);
        editTextBoldCursor.setImeOptions(5);
        editTextBoldCursor.setCursorColor(getThemedColor("windowBackgroundWhiteBlackText"));
        editTextBoldCursor.setCursorSize(AndroidUtilities.dp(20.0f));
        editTextBoldCursor.setCursorWidth(1.5f);
        editTextBoldCursor.setPadding(0, AndroidUtilities.dp(4.0f), 0, 0);
        editTextBoldCursor.addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.Components.StickersAlert.11
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (iArr[0] != 2) {
                    return;
                }
                StickersAlert.this.checkUrlAvailable(textView, editTextBoldCursor.getText().toString(), false);
            }
        });
        frameLayout.addView(editTextBoldCursor, LayoutHelper.createFrame(-1, 36, 51));
        editTextBoldCursor.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$StickersAlert$5Cg0FtXk6ahEAXiMK7i5sOQ7ALE
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView3, int i, KeyEvent keyEvent) {
                return StickersAlert.lambda$showNameEnterAlert$21(builder, textView3, i, keyEvent);
            }
        });
        editTextBoldCursor.setSelection(editTextBoldCursor.length());
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$StickersAlert$z3w1EewqUJKRgPQK1Sh0q-SUXlY
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AndroidUtilities.hideKeyboard(editTextBoldCursor);
            }
        });
        textView.setText(AndroidUtilities.replaceTags(LocaleController.getString("ImportStickersEnterNameInfo", R.string.ImportStickersEnterNameInfo)));
        textView.setTextSize(1, 14.0f);
        textView.setPadding(AndroidUtilities.dp(23.0f), AndroidUtilities.dp(12.0f), AndroidUtilities.dp(23.0f), AndroidUtilities.dp(6.0f));
        textView.setTextColor(getThemedColor("dialogTextGray2"));
        linearLayout.addView(textView, LayoutHelper.createLinear(-1, -2));
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$StickersAlert$p8TQ3lAC2qUaQ9QyMZ6MFMkdjQ4
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$StickersAlert$M5O07oyCEkqzsKUVMDDvFEO1id8
                    @Override // java.lang.Runnable
                    public final void run() {
                        StickersAlert.lambda$showNameEnterAlert$23(editTextBoldCursor);
                    }
                });
            }
        });
        alertDialogCreate.show();
        editTextBoldCursor.requestFocus();
        alertDialogCreate.getButton(-1).setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$StickersAlert$BY47cTABqRLpmVyQjDPYpMtuSG8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$showNameEnterAlert$28$StickersAlert(iArr, editTextBoldCursor, textView, textView2, builder, view);
            }
        });
    }

    static /* synthetic */ boolean lambda$showNameEnterAlert$21(AlertDialog.Builder builder, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 5) {
            return false;
        }
        builder.create().getButton(-1).callOnClick();
        return true;
    }

    static /* synthetic */ void lambda$showNameEnterAlert$23(EditTextBoldCursor editTextBoldCursor) {
        editTextBoldCursor.requestFocus();
        AndroidUtilities.showKeyboard(editTextBoldCursor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showNameEnterAlert$28, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showNameEnterAlert$28$StickersAlert(final int[] iArr, final EditTextBoldCursor editTextBoldCursor, final TextView textView, final TextView textView2, AlertDialog.Builder builder, View view) {
        if (iArr[0] == 1) {
            return;
        }
        if (iArr[0] == 0) {
            iArr[0] = 1;
            TLRPC$TL_stickers_suggestShortName tLRPC$TL_stickers_suggestShortName = new TLRPC$TL_stickers_suggestShortName();
            String string = editTextBoldCursor.getText().toString();
            this.setTitle = string;
            tLRPC$TL_stickers_suggestShortName.title = string;
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_stickers_suggestShortName, new RequestDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$StickersAlert$Z-KH5x5TQ0ElYetwprJ3lK6uDyQ
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$showNameEnterAlert$26$StickersAlert(editTextBoldCursor, textView, textView2, iArr, tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        if (iArr[0] == 2) {
            iArr[0] = 3;
            if (!this.lastNameAvailable) {
                AndroidUtilities.shakeView(editTextBoldCursor, 2.0f, 0);
                editTextBoldCursor.performHapticFeedback(3, 2);
            }
            AndroidUtilities.hideKeyboard(editTextBoldCursor);
            SendMessagesHelper.getInstance(this.currentAccount).prepareImportStickers(this.setTitle, this.lastCheckName, this.importingSoftware, this.importingStickersPaths, new MessagesStorage.StringCallback() { // from class: ir.eitaa.ui.Components.-$$Lambda$StickersAlert$8IjzUeRV3ur4NwZngRyWCCXpDAY
                @Override // ir.eitaa.messenger.MessagesStorage.StringCallback
                public final void run(String str) {
                    this.f$0.lambda$showNameEnterAlert$27$StickersAlert(str);
                }
            });
            builder.getDismissRunnable().run();
            dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showNameEnterAlert$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showNameEnterAlert$26$StickersAlert(final EditTextBoldCursor editTextBoldCursor, final TextView textView, final TextView textView2, final int[] iArr, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$StickersAlert$cCkE3LAWdrepj5kXKNOQOZz-hmc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showNameEnterAlert$25$StickersAlert(tLObject, editTextBoldCursor, textView, textView2, iArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showNameEnterAlert$25, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showNameEnterAlert$25$StickersAlert(TLObject tLObject, EditTextBoldCursor editTextBoldCursor, TextView textView, TextView textView2, int[] iArr) {
        String str;
        boolean z = true;
        if (!(tLObject instanceof TLRPC$TL_stickers_suggestedShortName) || (str = ((TLRPC$TL_stickers_suggestedShortName) tLObject).short_name) == null) {
            z = false;
        } else {
            editTextBoldCursor.setText(str);
            editTextBoldCursor.setSelection(0, editTextBoldCursor.length());
            checkUrlAvailable(textView, editTextBoldCursor.getText().toString(), true);
        }
        textView2.setVisibility(0);
        editTextBoldCursor.setPadding(textView2.getMeasuredWidth(), AndroidUtilities.dp(4.0f), 0, 0);
        if (!z) {
            editTextBoldCursor.setText("");
        }
        iArr[0] = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showNameEnterAlert$27, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showNameEnterAlert$27$StickersAlert(String str) {
        new ImportingAlert(getContext(), this.lastCheckName, null, this.resourcesProvider).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUrlAvailable(final TextView message, final String text, boolean forceAvailable) {
        if (forceAvailable) {
            message.setText(LocaleController.getString("ImportStickersLinkAvailable", R.string.ImportStickersLinkAvailable));
            message.setTextColor(getThemedColor("windowBackgroundWhiteGreenText"));
            this.lastNameAvailable = true;
            this.lastCheckName = text;
            return;
        }
        Runnable runnable = this.checkRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.checkRunnable = null;
            this.lastCheckName = null;
            if (this.checkReqId != 0) {
                ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.checkReqId, true);
            }
        }
        if (TextUtils.isEmpty(text)) {
            message.setText(LocaleController.getString("ImportStickersEnterUrlInfo", R.string.ImportStickersEnterUrlInfo));
            message.setTextColor(getThemedColor("dialogTextGray2"));
            return;
        }
        this.lastNameAvailable = false;
        if (text != null) {
            if (text.startsWith("_") || text.endsWith("_")) {
                message.setText(LocaleController.getString("ImportStickersLinkInvalid", R.string.ImportStickersLinkInvalid));
                message.setTextColor(getThemedColor("windowBackgroundWhiteRedText4"));
                return;
            }
            int length = text.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = text.charAt(i);
                if ((cCharAt < '0' || cCharAt > '9') && ((cCharAt < 'a' || cCharAt > 'z') && ((cCharAt < 'A' || cCharAt > 'Z') && cCharAt != '_'))) {
                    message.setText(LocaleController.getString("ImportStickersEnterUrlInfo", R.string.ImportStickersEnterUrlInfo));
                    message.setTextColor(getThemedColor("windowBackgroundWhiteRedText4"));
                    return;
                }
            }
        }
        if (text == null || text.length() < 5) {
            message.setText(LocaleController.getString("ImportStickersLinkInvalidShort", R.string.ImportStickersLinkInvalidShort));
            message.setTextColor(getThemedColor("windowBackgroundWhiteRedText4"));
        } else {
            if (text.length() > 32) {
                message.setText(LocaleController.getString("ImportStickersLinkInvalidLong", R.string.ImportStickersLinkInvalidLong));
                message.setTextColor(getThemedColor("windowBackgroundWhiteRedText4"));
                return;
            }
            message.setText(LocaleController.getString("ImportStickersLinkChecking", R.string.ImportStickersLinkChecking));
            message.setTextColor(getThemedColor("windowBackgroundWhiteGrayText8"));
            this.lastCheckName = text;
            Runnable runnable2 = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$StickersAlert$P9A1moUmEvPWNEqigZgkEoLVBh8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$checkUrlAvailable$31$StickersAlert(text, message);
                }
            };
            this.checkRunnable = runnable2;
            AndroidUtilities.runOnUIThread(runnable2, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkUrlAvailable$31, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkUrlAvailable$31$StickersAlert(final String str, final TextView textView) {
        TLRPC$TL_stickers_checkShortName tLRPC$TL_stickers_checkShortName = new TLRPC$TL_stickers_checkShortName();
        tLRPC$TL_stickers_checkShortName.short_name = str;
        this.checkReqId = ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_stickers_checkShortName, new RequestDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$StickersAlert$HLjGl6FxCIDbVNj3xrBkRX9GMCo
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$checkUrlAvailable$30$StickersAlert(str, textView, tLObject, tLRPC$TL_error);
            }
        }, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkUrlAvailable$30, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkUrlAvailable$30$StickersAlert(final String str, final TextView textView, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$StickersAlert$El1Qc_ZQoL0ct8ijmx6m8iNx9IY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkUrlAvailable$29$StickersAlert(str, tLRPC$TL_error, tLObject, textView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkUrlAvailable$29, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkUrlAvailable$29$StickersAlert(String str, TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, TextView textView) {
        this.checkReqId = 0;
        String str2 = this.lastCheckName;
        if (str2 == null || !str2.equals(str)) {
            return;
        }
        if (tLRPC$TL_error == null && (tLObject instanceof TLRPC$TL_boolTrue)) {
            textView.setText(LocaleController.getString("ImportStickersLinkAvailable", R.string.ImportStickersLinkAvailable));
            textView.setTextColor(getThemedColor("windowBackgroundWhiteGreenText"));
            this.lastNameAvailable = true;
        } else {
            textView.setText(LocaleController.getString("ImportStickersLinkTaken", R.string.ImportStickersLinkTaken));
            textView.setTextColor(getThemedColor("windowBackgroundWhiteRedText4"));
            this.lastNameAvailable = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void updateLayout() {
        if (this.gridView.getChildCount() <= 0) {
            setScrollOffsetY(this.gridView.getPaddingTop());
            return;
        }
        int i = 0;
        View childAt = this.gridView.getChildAt(0);
        RecyclerListView.Holder holder = (RecyclerListView.Holder) this.gridView.findContainingViewHolder(childAt);
        int top = childAt.getTop();
        if (top >= 0 && holder != null && holder.getAdapterPosition() == 0) {
            runShadowAnimation(0, false);
            i = top;
        } else {
            runShadowAnimation(0, true);
        }
        if (this.scrollOffsetY != i) {
            setScrollOffsetY(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollOffsetY(int newOffset) {
        this.scrollOffsetY = newOffset;
        this.gridView.setTopGlowOffset(newOffset);
        if (this.stickerSetCovereds == null) {
            float f = newOffset;
            this.titleTextView.setTranslationY(f);
            if (this.importingStickers == null) {
                this.optionsButton.setTranslationY(f);
            }
            this.shadow[0].setTranslationY(f);
        }
        this.containerView.invalidate();
    }

    private void hidePreview() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.stickerPreviewLayout, (Property<FrameLayout, Float>) View.ALPHA, 0.0f));
        animatorSet.setDuration(200L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.StickersAlert.12
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                StickersAlert.this.stickerPreviewLayout.setVisibility(8);
                StickersAlert.this.stickerImageView.setImageDrawable(null);
            }
        });
        animatorSet.start();
    }

    private void runShadowAnimation(final int num, final boolean show) {
        if (this.stickerSetCovereds != null) {
            return;
        }
        if ((!show || this.shadow[num].getTag() == null) && (show || this.shadow[num].getTag() != null)) {
            return;
        }
        this.shadow[num].setTag(show ? null : 1);
        if (show) {
            this.shadow[num].setVisibility(0);
        }
        AnimatorSet[] animatorSetArr = this.shadowAnimation;
        if (animatorSetArr[num] != null) {
            animatorSetArr[num].cancel();
        }
        this.shadowAnimation[num] = new AnimatorSet();
        AnimatorSet animatorSet = this.shadowAnimation[num];
        Animator[] animatorArr = new Animator[1];
        View view = this.shadow[num];
        Property property = View.ALPHA;
        float[] fArr = new float[1];
        fArr[0] = show ? 1.0f : 0.0f;
        animatorArr[0] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
        animatorSet.playTogether(animatorArr);
        this.shadowAnimation[num].setDuration(150L);
        this.shadowAnimation[num].addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.StickersAlert.13
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (StickersAlert.this.shadowAnimation[num] == null || !StickersAlert.this.shadowAnimation[num].equals(animation)) {
                    return;
                }
                if (!show) {
                    StickersAlert.this.shadow[num].setVisibility(4);
                }
                StickersAlert.this.shadowAnimation[num] = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                if (StickersAlert.this.shadowAnimation[num] == null || !StickersAlert.this.shadowAnimation[num].equals(animation)) {
                    return;
                }
                StickersAlert.this.shadowAnimation[num] = null;
            }
        });
        this.shadowAnimation[num].start();
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet, android.app.Dialog
    public void show() {
        super.show();
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.stopAllHeavyOperations, 4);
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (this.reqId != 0) {
            ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.reqId, true);
            this.reqId = 0;
        }
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.emojiLoaded);
        if (this.importingStickers != null) {
            ArrayList<SendMessagesHelper.ImportingSticker> arrayList = this.importingStickersPaths;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    SendMessagesHelper.ImportingSticker importingSticker = this.importingStickersPaths.get(i);
                    if (!importingSticker.validated) {
                        FileLoader.getInstance(this.currentAccount).cancelFileUpload(importingSticker.path, false);
                    }
                    if (importingSticker.animated) {
                        new File(importingSticker.path).delete();
                    }
                }
            }
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.fileUploaded);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.fileUploadFailed);
        }
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.startAllHeavyOperations, 4);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        Bulletin.addDelegate((FrameLayout) this.containerView, new Bulletin.Delegate() { // from class: ir.eitaa.ui.Components.StickersAlert.14
            @Override // ir.eitaa.ui.Components.Bulletin.Delegate
            public /* synthetic */ void onHide(Bulletin bulletin) {
                Bulletin.Delegate.CC.$default$onHide(this, bulletin);
            }

            @Override // ir.eitaa.ui.Components.Bulletin.Delegate
            public /* synthetic */ void onOffsetChange(float f) {
                Bulletin.Delegate.CC.$default$onOffsetChange(this, f);
            }

            @Override // ir.eitaa.ui.Components.Bulletin.Delegate
            public /* synthetic */ void onShow(Bulletin bulletin) {
                Bulletin.Delegate.CC.$default$onShow(this, bulletin);
            }

            @Override // ir.eitaa.ui.Components.Bulletin.Delegate
            public int getBottomOffset(int tag) {
                if (StickersAlert.this.pickerBottomLayout != null) {
                    return StickersAlert.this.pickerBottomLayout.getHeight();
                }
                return 0;
            }
        });
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        Bulletin.removeDelegate((FrameLayout) this.containerView);
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        HashMap<String, SendMessagesHelper.ImportingSticker> map;
        final String str;
        final SendMessagesHelper.ImportingSticker importingSticker;
        if (id == NotificationCenter.emojiLoaded) {
            RecyclerListView recyclerListView = this.gridView;
            if (recyclerListView != null) {
                int childCount = recyclerListView.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    this.gridView.getChildAt(i).invalidate();
                }
            }
            if (ContentPreviewViewer.getInstance().isVisible()) {
                ContentPreviewViewer.getInstance().close();
            }
            ContentPreviewViewer.getInstance().reset();
            return;
        }
        if (id == NotificationCenter.fileUploaded) {
            HashMap<String, SendMessagesHelper.ImportingSticker> map2 = this.uploadImportStickers;
            if (map2 == null || (importingSticker = map2.get((str = (String) args[0]))) == null) {
                return;
            }
            importingSticker.uploadMedia(this.currentAccount, (TLRPC$InputFile) args[1], new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$StickersAlert$8B-AotAs4aUNc4gXR33JcwdLKW8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$didReceivedNotification$32$StickersAlert(str, importingSticker);
                }
            });
            return;
        }
        if (id != NotificationCenter.fileUploadFailed || (map = this.uploadImportStickers) == null) {
            return;
        }
        SendMessagesHelper.ImportingSticker importingStickerRemove = map.remove((String) args[0]);
        if (importingStickerRemove != null) {
            removeSticker(importingStickerRemove);
        }
        if (this.uploadImportStickers.isEmpty()) {
            updateFields();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didReceivedNotification$32, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didReceivedNotification$32$StickersAlert(String str, SendMessagesHelper.ImportingSticker importingSticker) {
        if (isDismissed()) {
            return;
        }
        this.uploadImportStickers.remove(str);
        if (!"application/x-tgsticker".equals(importingSticker.mimeType)) {
            removeSticker(importingSticker);
        } else {
            importingSticker.validated = true;
            int iIndexOf = this.importingStickersPaths.indexOf(importingSticker);
            if (iIndexOf >= 0) {
                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.gridView.findViewHolderForAdapterPosition(iIndexOf);
                if (viewHolderFindViewHolderForAdapterPosition != null) {
                    ((StickerEmojiCell) viewHolderFindViewHolderForAdapterPosition.itemView).setSticker(importingSticker);
                }
            } else {
                this.adapter.notifyDataSetChanged();
            }
        }
        if (this.uploadImportStickers.isEmpty()) {
            updateFields();
        }
    }

    private void setButton(View.OnClickListener onClickListener, String title, String colorKey) {
        TextView textView = this.pickerBottomLayout;
        this.buttonTextColorKey = colorKey;
        textView.setTextColor(getThemedColor(colorKey));
        this.pickerBottomLayout.setText(title.toUpperCase());
        this.pickerBottomLayout.setOnClickListener(onClickListener);
    }

    public void setShowTooltipWhenToggle(boolean showTooltipWhenToggle) {
        this.showTooltipWhenToggle = showTooltipWhenToggle;
    }

    public void updateColors() {
        updateColors(false);
    }

    public void updateColors(boolean applyDescriptions) {
        this.adapter.updateColors();
        this.titleTextView.setHighlightColor(getThemedColor("dialogLinkSelection"));
        this.stickerPreviewLayout.setBackgroundColor(getThemedColor("dialogBackground") & (-536870913));
        this.optionsButton.setIconColor(getThemedColor("key_sheet_other"));
        this.optionsButton.setPopupItemsColor(getThemedColor("actionBarDefaultSubmenuItem"), false);
        this.optionsButton.setPopupItemsColor(getThemedColor("actionBarDefaultSubmenuItemIcon"), true);
        this.optionsButton.setPopupItemsSelectorColor(getThemedColor("dialogButtonSelector"));
        this.optionsButton.redrawPopup(getThemedColor("actionBarDefaultSubmenuBackground"));
        if (applyDescriptions) {
            if (Theme.isAnimatingColor() && this.animatingDescriptions == null) {
                ArrayList<ThemeDescription> themeDescriptions = getThemeDescriptions();
                this.animatingDescriptions = themeDescriptions;
                int size = themeDescriptions.size();
                for (int i = 0; i < size; i++) {
                    this.animatingDescriptions.get(i).setDelegateDisabled();
                }
            }
            int size2 = this.animatingDescriptions.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ThemeDescription themeDescription = this.animatingDescriptions.get(i2);
                themeDescription.setColor(getThemedColor(themeDescription.getCurrentKey()), false, false);
            }
        }
        if (Theme.isAnimatingColor() || this.animatingDescriptions == null) {
            return;
        }
        this.animatingDescriptions = null;
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$9fTHGYbTcesRK4KHCxAzT-Yl_F0
            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.updateColors();
            }

            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public /* synthetic */ void onAnimationProgress(float f) {
                ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
            }
        };
        arrayList.add(new ThemeDescription(this.containerView, 0, null, null, new Drawable[]{this.shadowDrawable}, null, "dialogBackground"));
        arrayList.add(new ThemeDescription(this.containerView, 0, null, null, null, null, "key_sheet_scrollUp"));
        this.adapter.getThemeDescriptions(arrayList, themeDescriptionDelegate);
        arrayList.add(new ThemeDescription(this.shadow[0], ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "dialogShadowLine"));
        arrayList.add(new ThemeDescription(this.shadow[1], ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "dialogShadowLine"));
        arrayList.add(new ThemeDescription(this.gridView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "dialogScrollGlow"));
        arrayList.add(new ThemeDescription(this.titleTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "dialogTextBlack"));
        arrayList.add(new ThemeDescription(this.titleTextView, ThemeDescription.FLAG_LINKCOLOR, null, null, null, null, "dialogTextLink"));
        arrayList.add(new ThemeDescription(this.optionsButton, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, "player_actionBarSelector"));
        arrayList.add(new ThemeDescription(this.pickerBottomLayout, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "dialogBackground"));
        arrayList.add(new ThemeDescription(this.pickerBottomLayout, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.pickerBottomLayout, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, this.buttonTextColorKey));
        arrayList.add(new ThemeDescription(this.previewSendButton, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "dialogTextBlue2"));
        arrayList.add(new ThemeDescription(this.previewSendButton, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "dialogBackground"));
        arrayList.add(new ThemeDescription(this.previewSendButton, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.previewSendButtonShadow, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "dialogShadowLine"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "dialogLinkSelection"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "dialogBackground"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "key_sheet_other"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "actionBarDefaultSubmenuItem"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "actionBarDefaultSubmenuItemIcon"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "dialogButtonSelector"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "actionBarDefaultSubmenuBackground"));
        return arrayList;
    }

    private class GridAdapter extends RecyclerListView.SelectionAdapter {
        private Context context;
        private int stickersPerRow;
        private int stickersRowCount;
        private int totalItems;
        private SparseArray<Object> cache = new SparseArray<>();
        private SparseArray<TLRPC$StickerSetCovered> positionsToSets = new SparseArray<>();

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return false;
        }

        public GridAdapter(Context context) {
            this.context = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.totalItems;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (StickersAlert.this.stickerSetCovereds == null) {
                return 0;
            }
            Object obj = this.cache.get(position);
            if (obj != null) {
                return obj instanceof TLRPC$Document ? 0 : 2;
            }
            return 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            FrameLayout featuredStickerSetInfoCell;
            if (i == 0) {
                StickerEmojiCell stickerEmojiCell = new StickerEmojiCell(this.context, false) { // from class: ir.eitaa.ui.Components.StickersAlert.GridAdapter.1
                    @Override // android.widget.FrameLayout, android.view.View
                    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                        super.onMeasure(View.MeasureSpec.makeMeasureSpec(StickersAlert.this.itemSize, 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(82.0f), 1073741824));
                    }
                };
                stickerEmojiCell.getImageView().setLayerNum(7);
                featuredStickerSetInfoCell = stickerEmojiCell;
            } else if (i == 1) {
                featuredStickerSetInfoCell = new EmptyCell(this.context);
            } else {
                featuredStickerSetInfoCell = i != 2 ? null : new FeaturedStickerSetInfoCell(this.context, 8, true, false, ((BottomSheet) StickersAlert.this).resourcesProvider);
            }
            return new RecyclerListView.Holder(featuredStickerSetInfoCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (StickersAlert.this.stickerSetCovereds == null) {
                if (StickersAlert.this.importingStickers != null) {
                    ((StickerEmojiCell) holder.itemView).setSticker((SendMessagesHelper.ImportingSticker) StickersAlert.this.importingStickersPaths.get(position));
                    return;
                } else {
                    ((StickerEmojiCell) holder.itemView).setSticker(StickersAlert.this.stickerSet.documents.get(position), StickersAlert.this.stickerSet, StickersAlert.this.showEmoji);
                    return;
                }
            }
            int itemViewType = holder.getItemViewType();
            if (itemViewType == 0) {
                ((StickerEmojiCell) holder.itemView).setSticker((TLRPC$Document) this.cache.get(position), this.positionsToSets.get(position), false);
            } else if (itemViewType == 1) {
                ((EmptyCell) holder.itemView).setHeight(AndroidUtilities.dp(82.0f));
            } else {
                if (itemViewType != 2) {
                    return;
                }
                ((FeaturedStickerSetInfoCell) holder.itemView).setStickerSet((TLRPC$StickerSetCovered) StickersAlert.this.stickerSetCovereds.get(((Integer) this.cache.get(position)).intValue()), false);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            int iCeil;
            int i;
            if (StickersAlert.this.stickerSetCovereds != null) {
                int measuredWidth = StickersAlert.this.gridView.getMeasuredWidth();
                if (measuredWidth == 0) {
                    measuredWidth = AndroidUtilities.displaySize.x;
                }
                this.stickersPerRow = measuredWidth / AndroidUtilities.dp(72.0f);
                StickersAlert.this.layoutManager.setSpanCount(this.stickersPerRow);
                this.cache.clear();
                this.positionsToSets.clear();
                this.totalItems = 0;
                this.stickersRowCount = 0;
                for (int i2 = 0; i2 < StickersAlert.this.stickerSetCovereds.size(); i2++) {
                    TLRPC$StickerSetCovered tLRPC$StickerSetCovered = (TLRPC$StickerSetCovered) StickersAlert.this.stickerSetCovereds.get(i2);
                    if (!tLRPC$StickerSetCovered.covers.isEmpty() || tLRPC$StickerSetCovered.cover != null) {
                        double d = this.stickersRowCount;
                        double dCeil = Math.ceil(StickersAlert.this.stickerSetCovereds.size() / this.stickersPerRow);
                        Double.isNaN(d);
                        this.stickersRowCount = (int) (d + dCeil);
                        this.positionsToSets.put(this.totalItems, tLRPC$StickerSetCovered);
                        SparseArray<Object> sparseArray = this.cache;
                        int i3 = this.totalItems;
                        this.totalItems = i3 + 1;
                        sparseArray.put(i3, Integer.valueOf(i2));
                        int i4 = this.totalItems / this.stickersPerRow;
                        if (!tLRPC$StickerSetCovered.covers.isEmpty()) {
                            iCeil = (int) Math.ceil(tLRPC$StickerSetCovered.covers.size() / this.stickersPerRow);
                            for (int i5 = 0; i5 < tLRPC$StickerSetCovered.covers.size(); i5++) {
                                this.cache.put(this.totalItems + i5, tLRPC$StickerSetCovered.covers.get(i5));
                            }
                        } else {
                            this.cache.put(this.totalItems, tLRPC$StickerSetCovered.cover);
                            iCeil = 1;
                        }
                        int i6 = 0;
                        while (true) {
                            i = this.stickersPerRow;
                            if (i6 >= iCeil * i) {
                                break;
                            }
                            this.positionsToSets.put(this.totalItems + i6, tLRPC$StickerSetCovered);
                            i6++;
                        }
                        this.totalItems += iCeil * i;
                    }
                }
            } else if (StickersAlert.this.importingStickersPaths != null) {
                this.totalItems = StickersAlert.this.importingStickersPaths.size();
            } else {
                this.totalItems = StickersAlert.this.stickerSet != null ? StickersAlert.this.stickerSet.documents.size() : 0;
            }
            super.notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemRemoved(int position) {
            if (StickersAlert.this.importingStickersPaths != null) {
                this.totalItems = StickersAlert.this.importingStickersPaths.size();
            }
            super.notifyItemRemoved(position);
        }

        public void updateColors() {
            if (StickersAlert.this.stickerSetCovereds != null) {
                int childCount = StickersAlert.this.gridView.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = StickersAlert.this.gridView.getChildAt(i);
                    if (childAt instanceof FeaturedStickerSetInfoCell) {
                        ((FeaturedStickerSetInfoCell) childAt).updateColors();
                    }
                }
            }
        }

        public void getThemeDescriptions(List<ThemeDescription> descriptions, ThemeDescription.ThemeDescriptionDelegate delegate) {
            if (StickersAlert.this.stickerSetCovereds != null) {
                FeaturedStickerSetInfoCell.createThemeDescriptions(descriptions, StickersAlert.this.gridView, delegate);
            }
        }
    }
}
