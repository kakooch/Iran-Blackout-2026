package org.rbmain.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionValues;
import android.util.Property;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.Emoji;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.FileRefController;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaDataController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$DocumentAttribute;
import org.rbmain.tgnet.TLRPC$InputStickerSet;
import org.rbmain.tgnet.TLRPC$Photo;
import org.rbmain.tgnet.TLRPC$StickerSet;
import org.rbmain.tgnet.TLRPC$StickerSetCovered;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeSticker;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_inputDocument;
import org.rbmain.tgnet.TLRPC$TL_inputPhoto;
import org.rbmain.tgnet.TLRPC$TL_inputStickerSetID;
import org.rbmain.tgnet.TLRPC$TL_inputStickeredMediaDocument;
import org.rbmain.tgnet.TLRPC$TL_inputStickeredMediaPhoto;
import org.rbmain.tgnet.TLRPC$TL_messages_getAttachedStickers;
import org.rbmain.tgnet.TLRPC$TL_messages_getStickerSet;
import org.rbmain.tgnet.TLRPC$TL_messages_installStickerSet;
import org.rbmain.tgnet.TLRPC$TL_messages_stickerSet;
import org.rbmain.tgnet.TLRPC$TL_messages_stickerSetInstallResultArchive;
import org.rbmain.tgnet.TLRPC$Vector;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Cells.EmptyCell;
import org.rbmain.ui.Cells.FeaturedStickerSetInfoCell;
import org.rbmain.ui.Cells.StickerEmojiCell;
import org.rbmain.ui.ChatActivity;
import org.rbmain.ui.Components.Bulletin;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.ContentPreviewViewer;

/* loaded from: classes5.dex */
public class StickersAlert extends BottomSheet implements NotificationCenter.NotificationCenterDelegate {
    private GridAdapter adapter;
    private List<ThemeDescription> animatingDescriptions;
    private int buttonTextColorKey;
    private boolean clearsInputField;
    private StickersAlertDelegate delegate;
    private FrameLayout emptyView;
    private RecyclerListView gridView;
    private boolean ignoreLayout;
    private TLRPC$InputStickerSet inputStickerSet;
    private StickersAlertInstallDelegate installDelegate;
    private int itemSize;
    private GridLayoutManager layoutManager;
    private Runnable onDismissListener;
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
    private Pattern urlPattern;

    public interface StickersAlertDelegate {
        boolean canSchedule();

        boolean isInScheduleMode();

        /* renamed from: onStickerSelected */
        void lambda$onStickerSelected$33(TLRPC$Document tLRPC$Document, String str, Object obj, boolean z, boolean z2, int i);
    }

    public interface StickersAlertInstallDelegate {
        void onStickerSetInstalled();

        void onStickerSetUninstalled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$init$7(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    protected boolean canDismissWithSwipe() {
        return false;
    }

    private static class LinkMovementMethodMy extends LinkMovementMethod {
        private LinkMovementMethodMy() {
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            try {
                boolean zOnTouchEvent = super.onTouchEvent(textView, spannable, motionEvent);
                if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    Selection.removeSelection(spannable);
                }
                return zOnTouchEvent;
            } catch (Exception e) {
                FileLog.e(e);
                return false;
            }
        }
    }

    public StickersAlert(Context context, final Object obj, TLObject tLObject) {
        super(context, false);
        this.shadowAnimation = new AnimatorSet[2];
        this.shadow = new View[2];
        this.showTooltipWhenToggle = true;
        this.previewDelegate = new ContentPreviewViewer.ContentPreviewViewerDelegate() { // from class: org.rbmain.ui.Components.StickersAlert.1
            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ boolean can() {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$can(this);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ Boolean canSetAsStatus(TLRPC$Document tLRPC$Document) {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$canSetAsStatus(this, tLRPC$Document);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ void copyEmoji(TLRPC$Document tLRPC$Document) {
                ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$copyEmoji(this, tLRPC$Document);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ String getQuery(boolean z) {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$getQuery(this, z);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ void gifAddedOrDeleted() {
                ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$gifAddedOrDeleted(this);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ boolean needCopy() {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$needCopy(this);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ boolean needMenu() {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$needMenu(this);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public boolean needOpen() {
                return false;
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ boolean needRemove() {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$needRemove(this);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ boolean needRemoveFromRecent(TLRPC$Document tLRPC$Document) {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$needRemoveFromRecent(this, tLRPC$Document);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public void openSet(TLRPC$InputStickerSet tLRPC$InputStickerSet, boolean z) {
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ void removeFromRecent(TLRPC$Document tLRPC$Document) {
                ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$removeFromRecent(this, tLRPC$Document);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ void resetTouch() {
                ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$resetTouch(this);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ void sendEmoji(TLRPC$Document tLRPC$Document) {
                ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$sendEmoji(this, tLRPC$Document);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ void sendGif(Object obj2, Object obj3, boolean z, int i) {
                ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$sendGif(this, obj2, obj3, z, i);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ void setAsEmojiStatus(TLRPC$Document tLRPC$Document, Integer num) {
                ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$setAsEmojiStatus(this, tLRPC$Document, num);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public void sendSticker(TLRPC$Document tLRPC$Document, String str, Object obj2, boolean z, int i) {
                if (StickersAlert.this.delegate == null) {
                    return;
                }
                StickersAlert.this.delegate.lambda$onStickerSelected$33(tLRPC$Document, str, obj2, StickersAlert.this.clearsInputField, z, i);
                StickersAlert.this.dismiss();
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public boolean canSchedule() {
                return StickersAlert.this.delegate != null && StickersAlert.this.delegate.canSchedule();
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public boolean isInScheduleMode() {
                return StickersAlert.this.delegate != null && StickersAlert.this.delegate.isInScheduleMode();
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public boolean needSend(int i) {
                return StickersAlert.this.previewSendButton.getVisibility() == 0;
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public long getDialogId() {
                if (StickersAlert.this.parentFragment instanceof ChatActivity) {
                    return ((ChatActivity) StickersAlert.this.parentFragment).getDialogId();
                }
                return 0L;
            }
        };
        this.parentActivity = (Activity) context;
        final TLRPC$TL_messages_getAttachedStickers tLRPC$TL_messages_getAttachedStickers = new TLRPC$TL_messages_getAttachedStickers();
        if (tLObject instanceof TLRPC$Photo) {
            TLRPC$Photo tLRPC$Photo = (TLRPC$Photo) tLObject;
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
        } else if (tLObject instanceof TLRPC$Document) {
            TLRPC$Document tLRPC$Document = (TLRPC$Document) tLObject;
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
        final RequestDelegate requestDelegate = new RequestDelegate() { // from class: org.rbmain.ui.Components.StickersAlert$$ExternalSyntheticLambda15
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$new$1(tLRPC$TL_messages_getAttachedStickers, tLObject2, tLRPC$TL_error);
            }
        };
        this.reqId = ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_messages_getAttachedStickers, new RequestDelegate() { // from class: org.rbmain.ui.Components.StickersAlert$$ExternalSyntheticLambda13
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$new$2(obj, tLRPC$TL_messages_getAttachedStickers, requestDelegate, tLObject2, tLRPC$TL_error);
            }
        });
        init(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(final TLRPC$TL_messages_getAttachedStickers tLRPC$TL_messages_getAttachedStickers, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.StickersAlert$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0(tLRPC$TL_error, tLObject, tLRPC$TL_messages_getAttachedStickers);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, TLRPC$TL_messages_getAttachedStickers tLRPC$TL_messages_getAttachedStickers) {
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
    public /* synthetic */ void lambda$new$2(Object obj, TLRPC$TL_messages_getAttachedStickers tLRPC$TL_messages_getAttachedStickers, RequestDelegate requestDelegate, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error != null && FileRefController.isFileRefError(tLRPC$TL_error.text) && obj != null) {
            FileRefController.getInstance(this.currentAccount).requestReference(obj, tLRPC$TL_messages_getAttachedStickers, requestDelegate);
        } else {
            requestDelegate.run(tLObject, tLRPC$TL_error);
        }
    }

    public StickersAlert(Context context, BaseFragment baseFragment, TLRPC$InputStickerSet tLRPC$InputStickerSet, TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet, StickersAlertDelegate stickersAlertDelegate) {
        super(context, false);
        this.shadowAnimation = new AnimatorSet[2];
        this.shadow = new View[2];
        this.showTooltipWhenToggle = true;
        this.previewDelegate = new ContentPreviewViewer.ContentPreviewViewerDelegate() { // from class: org.rbmain.ui.Components.StickersAlert.1
            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ boolean can() {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$can(this);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ Boolean canSetAsStatus(TLRPC$Document tLRPC$Document) {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$canSetAsStatus(this, tLRPC$Document);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ void copyEmoji(TLRPC$Document tLRPC$Document) {
                ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$copyEmoji(this, tLRPC$Document);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ String getQuery(boolean z) {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$getQuery(this, z);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ void gifAddedOrDeleted() {
                ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$gifAddedOrDeleted(this);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ boolean needCopy() {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$needCopy(this);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ boolean needMenu() {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$needMenu(this);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public boolean needOpen() {
                return false;
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ boolean needRemove() {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$needRemove(this);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ boolean needRemoveFromRecent(TLRPC$Document tLRPC$Document) {
                return ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$needRemoveFromRecent(this, tLRPC$Document);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public void openSet(TLRPC$InputStickerSet tLRPC$InputStickerSet2, boolean z) {
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ void removeFromRecent(TLRPC$Document tLRPC$Document) {
                ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$removeFromRecent(this, tLRPC$Document);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ void resetTouch() {
                ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$resetTouch(this);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ void sendEmoji(TLRPC$Document tLRPC$Document) {
                ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$sendEmoji(this, tLRPC$Document);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ void sendGif(Object obj2, Object obj3, boolean z, int i) {
                ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$sendGif(this, obj2, obj3, z, i);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public /* synthetic */ void setAsEmojiStatus(TLRPC$Document tLRPC$Document, Integer num) {
                ContentPreviewViewer.ContentPreviewViewerDelegate.CC.$default$setAsEmojiStatus(this, tLRPC$Document, num);
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public void sendSticker(TLRPC$Document tLRPC$Document, String str, Object obj2, boolean z, int i) {
                if (StickersAlert.this.delegate == null) {
                    return;
                }
                StickersAlert.this.delegate.lambda$onStickerSelected$33(tLRPC$Document, str, obj2, StickersAlert.this.clearsInputField, z, i);
                StickersAlert.this.dismiss();
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public boolean canSchedule() {
                return StickersAlert.this.delegate != null && StickersAlert.this.delegate.canSchedule();
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public boolean isInScheduleMode() {
                return StickersAlert.this.delegate != null && StickersAlert.this.delegate.isInScheduleMode();
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public boolean needSend(int i) {
                return StickersAlert.this.previewSendButton.getVisibility() == 0;
            }

            @Override // org.rbmain.ui.ContentPreviewViewer.ContentPreviewViewerDelegate
            public long getDialogId() {
                if (StickersAlert.this.parentFragment instanceof ChatActivity) {
                    return ((ChatActivity) StickersAlert.this.parentFragment).getDialogId();
                }
                return 0L;
            }
        };
        this.delegate = stickersAlertDelegate;
        this.inputStickerSet = tLRPC$InputStickerSet;
        this.stickerSet = tLRPC$TL_messages_stickerSet;
        this.parentFragment = baseFragment;
        loadStickerSet();
        init(context);
    }

    public void setClearsInputField(boolean z) {
        this.clearsInputField = z;
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
                AccountInstance.getInstance(this.currentAccount).getMessageProxy().getStickerSetById(tLRPC$TL_messages_getStickerSet, new RequestDelegate() { // from class: org.rbmain.ui.Components.StickersAlert$$ExternalSyntheticLambda14
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$loadStickerSet$4(mediaDataController, tLObject, tLRPC$TL_error);
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
    public /* synthetic */ void lambda$loadStickerSet$4(final MediaDataController mediaDataController, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.StickersAlert$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadStickerSet$3(tLRPC$TL_error, tLObject, mediaDataController);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadStickerSet$3(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, MediaDataController mediaDataController) {
        this.reqId = 0;
        if (tLRPC$TL_error == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2();
                anonymousClass2.addTarget(this.containerView);
                TransitionManager.beginDelayedTransition(this.container, anonymousClass2);
            }
            this.optionsButton.setVisibility(8);
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

    /* renamed from: org.rbmain.ui.Components.StickersAlert$2, reason: invalid class name */
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
        public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
            final int i = StickersAlert.this.scrollOffsetY;
            final int iIntValue = ((Integer) transitionValues.values.get("offset")).intValue() - ((Integer) transitionValues2.values.get("offset")).intValue();
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.setDuration(250L);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Components.StickersAlert$2$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$createAnimator$0(iIntValue, i, valueAnimator);
                }
            });
            return valueAnimatorOfFloat;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$createAnimator$0(int i, int i2, ValueAnimator valueAnimator) {
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
        FrameLayout frameLayout = new FrameLayout(context) { // from class: org.rbmain.ui.Components.StickersAlert.3
            private boolean fullHeight;
            private int lastNotifyWidth;
            private RectF rect = new RectF();

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0 && StickersAlert.this.scrollOffsetY != 0 && motionEvent.getY() < StickersAlert.this.scrollOffsetY) {
                    StickersAlert.this.dismiss();
                    return true;
                }
                return super.onInterceptTouchEvent(motionEvent);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                return !StickersAlert.this.isDismissed() && super.onTouchEvent(motionEvent);
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i, int i2) {
                int iDp;
                int iDp2;
                int size = View.MeasureSpec.getSize(i2);
                if (Build.VERSION.SDK_INT >= 21) {
                    StickersAlert.this.ignoreLayout = true;
                    setPadding(((BottomSheet) StickersAlert.this).backgroundPaddingLeft, AndroidUtilities.statusBarHeight, ((BottomSheet) StickersAlert.this).backgroundPaddingLeft, 0);
                    StickersAlert.this.ignoreLayout = false;
                }
                StickersAlert.this.itemSize = (View.MeasureSpec.getSize(i) - AndroidUtilities.dp(36.0f)) / 5;
                if (StickersAlert.this.stickerSetCovereds != null) {
                    iDp = AndroidUtilities.dp(56.0f) + (AndroidUtilities.dp(60.0f) * StickersAlert.this.stickerSetCovereds.size()) + (StickersAlert.this.adapter.stickersRowCount * AndroidUtilities.dp(82.0f)) + ((BottomSheet) StickersAlert.this).backgroundPaddingTop;
                    iDp2 = AndroidUtilities.dp(24.0f);
                } else {
                    iDp = AndroidUtilities.dp(96.0f) + (Math.max(3, StickersAlert.this.stickerSet != null ? (int) Math.ceil(StickersAlert.this.stickerSet.documents.size() / 5.0f) : 0) * AndroidUtilities.dp(82.0f)) + ((BottomSheet) StickersAlert.this).backgroundPaddingTop;
                    iDp2 = AndroidUtilities.statusBarHeight;
                }
                int i3 = iDp + iDp2;
                double d = i3;
                int i4 = size / 5;
                double d2 = i4;
                Double.isNaN(d2);
                int iDp3 = d < d2 * 3.2d ? 0 : i4 * 2;
                if (iDp3 != 0 && i3 < size) {
                    iDp3 -= size - i3;
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
                this.fullHeight = i3 >= size;
                super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(Math.min(i3, size), 1073741824));
            }

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
                int i5 = i3 - i;
                if (this.lastNotifyWidth != i5) {
                    this.lastNotifyWidth = i5;
                    if (StickersAlert.this.adapter != null && StickersAlert.this.stickerSetCovereds != null) {
                        StickersAlert.this.adapter.notifyDataSetChanged();
                    }
                }
                super.onLayout(z, i, i2, i3, i4);
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
              0x0092: PHI (r2v7 int) = (r2v6 int), (r2v26 int) binds: [B:3:0x0041, B:5:0x004a] A[DONT_GENERATE, DONT_INLINE]] */
            @Override // android.view.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            protected void onDraw(android.graphics.Canvas r14) {
                /*
                    Method dump skipped, instructions count: 401
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.StickersAlert.AnonymousClass3.onDraw(android.graphics.Canvas):void");
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
        View view = this.shadow[0];
        int i2 = Theme.key_dialogShadowLine;
        view.setBackgroundColor(Theme.getColor(i2));
        this.shadow[0].setAlpha(0.0f);
        this.shadow[0].setVisibility(4);
        this.shadow[0].setTag(1);
        this.containerView.addView(this.shadow[0], layoutParams);
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: org.rbmain.ui.Components.StickersAlert.4
            @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                return super.onInterceptTouchEvent(motionEvent) || ContentPreviewViewer.getInstance().onInterceptTouchEvent(motionEvent, StickersAlert.this.gridView, 0, StickersAlert.this.previewDelegate, null);
            }

            @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
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
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 5) { // from class: org.rbmain.ui.Components.StickersAlert.5
            @Override // androidx.recyclerview.widget.LinearLayoutManager
            protected boolean isLayoutRTL() {
                return StickersAlert.this.stickerSetCovereds != null && LocaleController.isRTL;
            }
        };
        this.layoutManager = gridLayoutManager;
        recyclerListView2.setLayoutManager(gridLayoutManager);
        this.layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: org.rbmain.ui.Components.StickersAlert.6
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i3) {
                if ((StickersAlert.this.stickerSetCovereds == null || !(StickersAlert.this.adapter.cache.get(i3) instanceof Integer)) && i3 != StickersAlert.this.adapter.totalItems) {
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
        this.gridView.addItemDecoration(new RecyclerView.ItemDecoration(this) { // from class: org.rbmain.ui.Components.StickersAlert.7
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(android.graphics.Rect rect, View view2, RecyclerView recyclerView, RecyclerView.State state) {
                rect.left = 0;
                rect.right = 0;
                rect.bottom = 0;
                rect.top = 0;
            }
        });
        this.gridView.setPadding(AndroidUtilities.dp(10.0f), 0, AndroidUtilities.dp(10.0f), 0);
        this.gridView.setClipToPadding(false);
        this.gridView.setEnabled(true);
        this.gridView.setGlowColor(Theme.getColor(Theme.key_dialogScrollGlow));
        this.gridView.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.Components.StickersAlert$$ExternalSyntheticLambda7
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return this.f$0.lambda$init$5(view2, motionEvent);
            }
        });
        this.gridView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: org.rbmain.ui.Components.StickersAlert.8
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i3, int i4) {
                StickersAlert.this.updateLayout();
            }
        });
        RecyclerListView.OnItemClickListener onItemClickListener = new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.Components.StickersAlert$$ExternalSyntheticLambda18
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view2, int i3) {
                this.f$0.lambda$init$6(view2, i3);
            }
        };
        this.stickersOnItemClickListener = onItemClickListener;
        this.gridView.setOnItemClickListener(onItemClickListener);
        this.containerView.addView(this.gridView, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 48.0f, 0.0f, 48.0f));
        FrameLayout frameLayout2 = new FrameLayout(context) { // from class: org.rbmain.ui.Components.StickersAlert.9
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
        this.emptyView.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.Components.StickersAlert$$ExternalSyntheticLambda8
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return StickersAlert.lambda$init$7(view2, motionEvent);
            }
        });
        TextView textView = new TextView(context);
        this.titleTextView = textView;
        textView.setLines(1);
        this.titleTextView.setSingleLine(true);
        this.titleTextView.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
        this.titleTextView.setTextSize(1, 20.0f);
        this.titleTextView.setLinkTextColor(Theme.getColor(Theme.key_dialogTextLink));
        this.titleTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.titleTextView.setPadding(AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f), 0);
        this.titleTextView.setGravity(16);
        this.titleTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.containerView.addView(this.titleTextView, LayoutHelper.createFrame(-1, 50.0f, 51, 0.0f, 0.0f, 40.0f, 0.0f));
        ActionBarMenuItem actionBarMenuItem = new ActionBarMenuItem(context, null, 0, Theme.getColor(Theme.key_sheet_other));
        this.optionsButton = actionBarMenuItem;
        actionBarMenuItem.setLongClickEnabled(false);
        this.optionsButton.setSubMenuOpenSide(2);
        this.optionsButton.setIcon(R.drawable.ic_ab_other);
        this.optionsButton.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor(Theme.key_player_actionBarSelector), 1));
        this.containerView.addView(this.optionsButton, LayoutHelper.createFrame(40, 40.0f, 53, 0.0f, 5.0f, 5.0f, 0.0f));
        this.optionsButton.addSubItem(1, R.drawable.msg_share, LocaleController.getString("StickersShare", R.string.StickersShare));
        this.optionsButton.addSubItem(2, R.drawable.msg_link, LocaleController.getString("CopyLink", R.string.CopyLink));
        this.optionsButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.StickersAlert$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$init$8(view2);
            }
        });
        this.optionsButton.setDelegate(new ActionBarMenuItem.ActionBarMenuItemDelegate() { // from class: org.rbmain.ui.Components.StickersAlert$$ExternalSyntheticLambda16
            @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemDelegate
            public final void onItemClick(int i3) {
                this.f$0.onSubItemClick(i3);
            }
        });
        this.optionsButton.setContentDescription(LocaleController.getString("AccDescrMoreOptions", R.string.AccDescrMoreOptions));
        this.optionsButton.setVisibility(8);
        this.emptyView.addView(new RadialProgressView(context), LayoutHelper.createFrame(-2, -2, 17));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, AndroidUtilities.getShadowHeight(), 83);
        layoutParams2.bottomMargin = AndroidUtilities.dp(48.0f);
        this.shadow[1] = new View(context);
        this.shadow[1].setBackgroundColor(Theme.getColor(i2));
        this.containerView.addView(this.shadow[1], layoutParams2);
        TextView textView2 = new TextView(context);
        this.pickerBottomLayout = textView2;
        int i3 = Theme.key_dialogBackground;
        int color = Theme.getColor(i3);
        int i4 = Theme.key_listSelector;
        textView2.setBackgroundDrawable(Theme.createSelectorWithBackgroundDrawable(color, Theme.getColor(i4)));
        TextView textView3 = this.pickerBottomLayout;
        int i5 = Theme.key_dialogTextBlue2;
        this.buttonTextColorKey = i5;
        textView3.setTextColor(Theme.getColor(i5));
        this.pickerBottomLayout.setTextSize(1, 14.0f);
        this.pickerBottomLayout.setPadding(AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f), 0);
        this.pickerBottomLayout.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.pickerBottomLayout.setGravity(17);
        this.containerView.addView(this.pickerBottomLayout, LayoutHelper.createFrame(-1, 48, 83));
        FrameLayout frameLayout3 = new FrameLayout(context);
        this.stickerPreviewLayout = frameLayout3;
        frameLayout3.setVisibility(8);
        this.stickerPreviewLayout.setSoundEffectsEnabled(false);
        this.containerView.addView(this.stickerPreviewLayout, LayoutHelper.createFrame(-1, -1.0f));
        this.stickerPreviewLayout.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.StickersAlert$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$init$9(view2);
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
        this.previewSendButton.setTextColor(Theme.getColor(i5));
        this.previewSendButton.setBackground(Theme.createSelectorWithBackgroundDrawable(Theme.getColor(i3), Theme.getColor(i4)));
        this.previewSendButton.setGravity(17);
        this.previewSendButton.setPadding(AndroidUtilities.dp(29.0f), 0, AndroidUtilities.dp(29.0f), 0);
        this.previewSendButton.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.stickerPreviewLayout.addView(this.previewSendButton, LayoutHelper.createFrame(-1, 48, 83));
        this.previewSendButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.StickersAlert$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$init$10(view2);
            }
        });
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, AndroidUtilities.getShadowHeight(), 83);
        layoutParams3.bottomMargin = AndroidUtilities.dp(48.0f);
        View view2 = new View(context);
        this.previewSendButtonShadow = view2;
        view2.setBackgroundColor(Theme.getColor(i2));
        this.stickerPreviewLayout.addView(this.previewSendButtonShadow, layoutParams3);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.emojiDidLoad);
        updateFields();
        updateSendButton();
        updateColors();
        this.adapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$init$5(View view, MotionEvent motionEvent) {
        return ContentPreviewViewer.getInstance().onTouch(motionEvent, this.gridView, 0, this.stickersOnItemClickListener, this.previewDelegate, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$6(View view, int i) {
        boolean z;
        if (this.stickerSetCovereds == null) {
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
                    TextView textView = this.stickerEmojiTextView;
                    textView.setText(Emoji.replaceEmoji(tLRPC$DocumentAttribute.alt, textView.getPaint().getFontMetricsInt(), AndroidUtilities.dp(30.0f), false));
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
        TLRPC$StickerSetCovered tLRPC$StickerSetCovered = (TLRPC$StickerSetCovered) this.adapter.positionsToSets.get(i);
        if (tLRPC$StickerSetCovered != null) {
            dismiss();
            TLRPC$TL_inputStickerSetID tLRPC$TL_inputStickerSetID = new TLRPC$TL_inputStickerSetID();
            TLRPC$StickerSet tLRPC$StickerSet = tLRPC$StickerSetCovered.set;
            tLRPC$TL_inputStickerSetID.access_hash = tLRPC$StickerSet.access_hash;
            tLRPC$TL_inputStickerSetID.id = tLRPC$StickerSet.id;
            new StickersAlert(this.parentActivity, this.parentFragment, tLRPC$TL_inputStickerSetID, null, null).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$8(View view) {
        this.optionsButton.toggleSubMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$9(View view) {
        hidePreview();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$10(View view) {
        this.delegate.lambda$onStickerSelected$33(this.selectedSticker, null, this.stickerSet, this.clearsInputField, true, 0);
        dismiss();
    }

    private void updateSendButton() {
        TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet;
        android.graphics.Point point = AndroidUtilities.displaySize;
        int iMin = (int) ((Math.min(point.x, point.y) / 2) / AndroidUtilities.density);
        if (this.delegate != null && ((tLRPC$TL_messages_stickerSet = this.stickerSet) == null || !tLRPC$TL_messages_stickerSet.set.masks)) {
            this.previewSendButton.setText(LocaleController.getString("SendSticker", R.string.SendSticker).toUpperCase());
            float f = iMin;
            this.stickerImageView.setLayoutParams(LayoutHelper.createFrame(iMin, f, 17, 0.0f, 0.0f, 0.0f, 30.0f));
            this.stickerEmojiTextView.setLayoutParams(LayoutHelper.createFrame(iMin, f, 17, 0.0f, 0.0f, 0.0f, 30.0f));
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

    public void setInstallDelegate(StickersAlertInstallDelegate stickersAlertInstallDelegate) {
        this.installDelegate = stickersAlertInstallDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSubItemClick(int i) {
        BaseFragment baseFragment;
        TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = this.stickerSet;
        if (tLRPC$TL_messages_stickerSet == null) {
            return;
        }
        String str = tLRPC$TL_messages_stickerSet.set.shareString;
        if (i != 1) {
            if (i == 2) {
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
        ShareAlert shareAlert = new ShareAlert(context, null, str, false, str, false);
        BaseFragment baseFragment2 = this.parentFragment;
        if (baseFragment2 != null) {
            baseFragment2.showDialog(shareAlert);
        } else {
            shareAlert.show();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0129  */
    /* JADX WARN: Type inference failed for: r0v6, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r3v12, types: [android.text.SpannableStringBuilder] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r4v5, types: [android.text.SpannableStringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void updateFields() {
        /*
            Method dump skipped, instructions count: 359
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.StickersAlert.updateFields():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateFields$13(View view) {
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
        AccountInstance.getInstance(this.currentAccount).getMessageProxy().toggleStickerSet(tLRPC$TL_messages_installStickerSet, new RequestDelegate() { // from class: org.rbmain.ui.Components.StickersAlert$$ExternalSyntheticLambda12
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$updateFields$12(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateFields$12(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.StickersAlert$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$updateFields$11(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateFields$11(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        boolean z = this.stickerSet.set.masks;
        try {
            if (tLRPC$TL_error == null) {
                if (this.showTooltipWhenToggle) {
                    Bulletin.make(this.parentFragment, new StickerSetBulletinLayout(this.pickerBottomLayout.getContext(), this.stickerSet, 2), 1500).show();
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
    public /* synthetic */ void lambda$updateFields$14(View view) {
        StickersAlertInstallDelegate stickersAlertInstallDelegate = this.installDelegate;
        if (stickersAlertInstallDelegate != null) {
            stickersAlertInstallDelegate.onStickerSetUninstalled();
        }
        dismiss();
        MediaDataController.getInstance(this.currentAccount).toggleStickerSet(getContext(), this.stickerSet, 1, this.parentFragment, true, this.showTooltipWhenToggle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateFields$15(View view) {
        StickersAlertInstallDelegate stickersAlertInstallDelegate = this.installDelegate;
        if (stickersAlertInstallDelegate != null) {
            stickersAlertInstallDelegate.onStickerSetUninstalled();
        }
        dismiss();
        MediaDataController.getInstance(this.currentAccount).toggleStickerSet(getContext(), this.stickerSet, 0, this.parentFragment, true, this.showTooltipWhenToggle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateFields$16(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
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
    public void setScrollOffsetY(int i) {
        this.scrollOffsetY = i;
        this.gridView.setTopGlowOffset(i);
        if (this.stickerSetCovereds == null) {
            float f = i;
            this.titleTextView.setTranslationY(f);
            this.optionsButton.setTranslationY(f);
            this.shadow[0].setTranslationY(f);
        }
        this.containerView.invalidate();
    }

    private void hidePreview() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.stickerPreviewLayout, (Property<FrameLayout, Float>) View.ALPHA, 0.0f));
        animatorSet.setDuration(200L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.StickersAlert.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                StickersAlert.this.stickerPreviewLayout.setVisibility(8);
                StickersAlert.this.stickerImageView.setImageDrawable(null);
            }
        });
        animatorSet.start();
    }

    private void runShadowAnimation(final int i, final boolean z) {
        if (this.stickerSetCovereds != null) {
            return;
        }
        if ((!z || this.shadow[i].getTag() == null) && (z || this.shadow[i].getTag() != null)) {
            return;
        }
        this.shadow[i].setTag(z ? null : 1);
        if (z) {
            this.shadow[i].setVisibility(0);
        }
        AnimatorSet[] animatorSetArr = this.shadowAnimation;
        if (animatorSetArr[i] != null) {
            animatorSetArr[i].cancel();
        }
        this.shadowAnimation[i] = new AnimatorSet();
        AnimatorSet animatorSet = this.shadowAnimation[i];
        Animator[] animatorArr = new Animator[1];
        View view = this.shadow[i];
        Property property = View.ALPHA;
        float[] fArr = new float[1];
        fArr[0] = z ? 1.0f : 0.0f;
        animatorArr[0] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
        animatorSet.playTogether(animatorArr);
        this.shadowAnimation[i].setDuration(150L);
        this.shadowAnimation[i].addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.StickersAlert.12
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (StickersAlert.this.shadowAnimation[i] == null || !StickersAlert.this.shadowAnimation[i].equals(animator)) {
                    return;
                }
                if (!z) {
                    StickersAlert.this.shadow[i].setVisibility(4);
                }
                StickersAlert.this.shadowAnimation[i] = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (StickersAlert.this.shadowAnimation[i] == null || !StickersAlert.this.shadowAnimation[i].equals(animator)) {
                    return;
                }
                StickersAlert.this.shadowAnimation[i] = null;
            }
        });
        this.shadowAnimation[i].start();
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet, android.app.Dialog
    public void show() {
        super.show();
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.stopAllHeavyOperations, 4);
    }

    public void setOnDismissListener(Runnable runnable) {
        this.onDismissListener = runnable;
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        Runnable runnable = this.onDismissListener;
        if (runnable != null) {
            runnable.run();
        }
        if (this.reqId != 0) {
            ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.reqId, true);
            this.reqId = 0;
        }
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.emojiDidLoad);
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.startAllHeavyOperations, 4);
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet, android.app.Dialog
    protected void onStart() {
        super.onStart();
        Bulletin.addDelegate((FrameLayout) this.containerView, new Bulletin.Delegate() { // from class: org.rbmain.ui.Components.StickersAlert.13
            @Override // org.rbmain.ui.Components.Bulletin.Delegate
            public /* synthetic */ boolean allowLayoutChanges() {
                return Bulletin.Delegate.CC.$default$allowLayoutChanges(this);
            }

            @Override // org.rbmain.ui.Components.Bulletin.Delegate
            public /* synthetic */ int getTopOffset(int i) {
                return Bulletin.Delegate.CC.$default$getTopOffset(this, i);
            }

            @Override // org.rbmain.ui.Components.Bulletin.Delegate
            public /* synthetic */ void onBottomOffsetChange(float f) {
                Bulletin.Delegate.CC.$default$onBottomOffsetChange(this, f);
            }

            @Override // org.rbmain.ui.Components.Bulletin.Delegate
            public /* synthetic */ void onHide(Bulletin bulletin) {
                Bulletin.Delegate.CC.$default$onHide(this, bulletin);
            }

            @Override // org.rbmain.ui.Components.Bulletin.Delegate
            public /* synthetic */ void onShow(Bulletin bulletin) {
                Bulletin.Delegate.CC.$default$onShow(this, bulletin);
            }

            @Override // org.rbmain.ui.Components.Bulletin.Delegate
            public int getBottomOffset(int i) {
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

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.emojiDidLoad) {
            RecyclerListView recyclerListView = this.gridView;
            if (recyclerListView != null) {
                int childCount = recyclerListView.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    this.gridView.getChildAt(i3).invalidate();
                }
            }
            if (ContentPreviewViewer.getInstance().isVisible()) {
                ContentPreviewViewer.getInstance().close();
            }
            ContentPreviewViewer.getInstance().reset();
        }
    }

    private void setButton(View.OnClickListener onClickListener, String str, int i) {
        TextView textView = this.pickerBottomLayout;
        this.buttonTextColorKey = i;
        textView.setTextColor(Theme.getColor(i));
        this.pickerBottomLayout.setText(str.toUpperCase());
        this.pickerBottomLayout.setOnClickListener(onClickListener);
    }

    public void setShowTooltipWhenToggle(boolean z) {
        this.showTooltipWhenToggle = z;
    }

    public void updateColors() {
        updateColors(false);
    }

    public void updateColors(boolean z) {
        this.adapter.updateColors();
        this.titleTextView.setHighlightColor(Theme.getColor(Theme.key_dialogLinkSelection));
        this.stickerPreviewLayout.setBackgroundColor(Theme.getColor(Theme.key_dialogBackground) & (-536870913));
        this.optionsButton.setIconColor(Theme.getColor(Theme.key_sheet_other));
        this.optionsButton.setPopupItemsColor(Theme.getColor(Theme.key_actionBarDefaultSubmenuItem), false);
        this.optionsButton.setPopupItemsColor(Theme.getColor(Theme.key_actionBarDefaultSubmenuItemIcon), true);
        this.optionsButton.setPopupItemsSelectorColor(Theme.getColor(Theme.key_dialogButtonSelector));
        this.optionsButton.redrawPopup(Theme.getColor(Theme.key_actionBarDefaultSubmenuBackground));
        if (z) {
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
                themeDescription.setColor(Theme.getColor(themeDescription.getCurrentKey()), false, false);
            }
        }
        if (Theme.isAnimatingColor() || this.animatingDescriptions == null) {
            return;
        }
        this.animatingDescriptions = null;
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: org.rbmain.ui.Components.StickersAlert$$ExternalSyntheticLambda17
            @Override // org.rbmain.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.updateColors();
            }
        };
        ViewGroup viewGroup = this.containerView;
        Drawable[] drawableArr = {this.shadowDrawable};
        int i = Theme.key_dialogBackground;
        arrayList.add(new ThemeDescription(viewGroup, 0, null, null, drawableArr, null, i));
        arrayList.add(new ThemeDescription(this.containerView, 0, null, null, null, null, Theme.key_sheet_scrollUp));
        this.adapter.getThemeDescriptions(arrayList, themeDescriptionDelegate);
        View view = this.shadow[0];
        int i2 = ThemeDescription.FLAG_BACKGROUND;
        int i3 = Theme.key_dialogShadowLine;
        arrayList.add(new ThemeDescription(view, i2, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.shadow[1], ThemeDescription.FLAG_BACKGROUND, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.gridView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, Theme.key_dialogScrollGlow));
        arrayList.add(new ThemeDescription(this.titleTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_dialogTextBlack));
        arrayList.add(new ThemeDescription(this.titleTextView, ThemeDescription.FLAG_LINKCOLOR, null, null, null, null, Theme.key_dialogTextLink));
        arrayList.add(new ThemeDescription(this.optionsButton, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, Theme.key_player_actionBarSelector));
        arrayList.add(new ThemeDescription(this.pickerBottomLayout, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, i));
        TextView textView = this.pickerBottomLayout;
        int i4 = ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE;
        int i5 = Theme.key_listSelector;
        arrayList.add(new ThemeDescription(textView, i4, null, null, null, null, i5));
        arrayList.add(new ThemeDescription(this.pickerBottomLayout, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, this.buttonTextColorKey));
        arrayList.add(new ThemeDescription(this.previewSendButton, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_dialogTextBlue2));
        arrayList.add(new ThemeDescription(this.previewSendButton, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, i));
        arrayList.add(new ThemeDescription(this.previewSendButton, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, i5));
        arrayList.add(new ThemeDescription(this.previewSendButtonShadow, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_dialogLinkSelection));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, i));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_sheet_other));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_actionBarDefaultSubmenuItem));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_actionBarDefaultSubmenuItemIcon));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_dialogButtonSelector));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_actionBarDefaultSubmenuBackground));
        return arrayList;
    }

    private class GridAdapter extends RecyclerListView.SelectionAdapter {
        private Context context;
        private int stickersPerRow;
        private int stickersRowCount;
        private int totalItems;
        private SparseArray<Object> cache = new SparseArray<>();
        private SparseArray<TLRPC$StickerSetCovered> positionsToSets = new SparseArray<>();

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
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
        public int getItemViewType(int i) {
            if (StickersAlert.this.stickerSetCovereds == null) {
                return 0;
            }
            Object obj = this.cache.get(i);
            if (obj != null) {
                return obj instanceof TLRPC$Document ? 0 : 2;
            }
            return 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            FrameLayout featuredStickerSetInfoCell;
            FrameLayout emptyCell;
            boolean z = false;
            if (i == 0) {
                StickerEmojiCell stickerEmojiCell = new StickerEmojiCell(this.context, z) { // from class: org.rbmain.ui.Components.StickersAlert.GridAdapter.1
                    @Override // android.widget.FrameLayout, android.view.View
                    public void onMeasure(int i2, int i3) {
                        super.onMeasure(View.MeasureSpec.makeMeasureSpec(StickersAlert.this.itemSize, 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(82.0f), 1073741824));
                    }
                };
                stickerEmojiCell.getImageView().setLayerNum(7);
                featuredStickerSetInfoCell = stickerEmojiCell;
            } else {
                if (i == 1) {
                    emptyCell = new EmptyCell(this.context);
                } else if (i != 2) {
                    emptyCell = null;
                } else {
                    featuredStickerSetInfoCell = new FeaturedStickerSetInfoCell(this.context, 8, true, false);
                }
                return new RecyclerListView.Holder(emptyCell);
            }
            emptyCell = featuredStickerSetInfoCell;
            return new RecyclerListView.Holder(emptyCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (StickersAlert.this.stickerSetCovereds == null) {
                ((StickerEmojiCell) viewHolder.itemView).setSticker(StickersAlert.this.stickerSet.documents.get(i), StickersAlert.this.stickerSet, StickersAlert.this.showEmoji);
                return;
            }
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                ((StickerEmojiCell) viewHolder.itemView).setSticker((TLRPC$Document) this.cache.get(i), this.positionsToSets.get(i), false);
            } else if (itemViewType == 1) {
                ((EmptyCell) viewHolder.itemView).setHeight(AndroidUtilities.dp(82.0f));
            } else {
                if (itemViewType != 2) {
                    return;
                }
                ((FeaturedStickerSetInfoCell) viewHolder.itemView).setStickerSet((TLRPC$StickerSetCovered) StickersAlert.this.stickerSetCovereds.get(((Integer) this.cache.get(i)).intValue()), false);
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
            } else {
                this.totalItems = StickersAlert.this.stickerSet != null ? StickersAlert.this.stickerSet.documents.size() : 0;
            }
            super.notifyDataSetChanged();
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

        public void getThemeDescriptions(List<ThemeDescription> list, ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate) {
            if (StickersAlert.this.stickerSetCovereds != null) {
                FeaturedStickerSetInfoCell.createThemeDescriptions(list, StickersAlert.this.gridView, themeDescriptionDelegate);
            }
        }
    }
}
