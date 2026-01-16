package ir.eitaa.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.FrameLayout;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.Emoji;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SendMessagesHelper;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.WebFile;
import ir.eitaa.tgnet.TLRPC$BotInlineResult;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$DocumentAttribute;
import ir.eitaa.tgnet.TLRPC$InputStickerSet;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeSticker;
import ir.eitaa.tgnet.TLRPC$TL_webDocument;
import ir.eitaa.tgnet.TLRPC$VideoSize;
import ir.eitaa.tgnet.TLRPC$WebDocument;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.ContextLinkCell;
import ir.eitaa.ui.Cells.StickerCell;
import ir.eitaa.ui.Cells.StickerEmojiCell;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.ContentPreviewViewer;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ContentPreviewViewer {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile ContentPreviewViewer Instance;
    private static TextPaint textPaint;
    private boolean animateY;
    private boolean clearsInputField;
    private FrameLayoutDrawer containerView;
    private int currentAccount;
    private int currentContentType;
    private TLRPC$Document currentDocument;
    private float currentMoveY;
    private float currentMoveYProgress;
    private View currentPreviewCell;
    private String currentQuery;
    private TLRPC$InputStickerSet currentStickerSet;
    private ContentPreviewViewerDelegate delegate;
    private float finalMoveY;
    private SendMessagesHelper.ImportingSticker importingSticker;
    private TLRPC$BotInlineResult inlineResult;
    private boolean isRecentSticker;
    private WindowInsets lastInsets;
    private float lastTouchY;
    private long lastUpdateTime;
    private Runnable openPreviewRunnable;
    private Activity parentActivity;
    private Object parentObject;
    private Theme.ResourcesProvider resourcesProvider;
    private float showProgress;
    private Drawable slideUpDrawable;
    private float startMoveY;
    private int startX;
    private int startY;
    private StaticLayout stickerEmojiLayout;
    VibrationEffect vibrationEffect;
    private BottomSheet visibleDialog;
    private WindowManager.LayoutParams windowLayoutParams;
    private FrameLayout windowView;
    private float moveY = 0.0f;
    private ColorDrawable backgroundDrawable = new ColorDrawable(1895825408);
    private ImageReceiver centerImage = new ImageReceiver();
    private boolean isVisible = false;
    private int keyboardHeight = AndroidUtilities.dp(200.0f);
    private Runnable showSheetRunnable = new AnonymousClass1();

    public interface ContentPreviewViewerDelegate {

        /* renamed from: ir.eitaa.ui.ContentPreviewViewer$ContentPreviewViewerDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static String $default$getQuery(ContentPreviewViewerDelegate contentPreviewViewerDelegate, boolean z) {
                return null;
            }

            public static void $default$gifAddedOrDeleted(ContentPreviewViewerDelegate contentPreviewViewerDelegate) {
            }

            public static boolean $default$needMenu(ContentPreviewViewerDelegate contentPreviewViewerDelegate) {
                return true;
            }

            public static boolean $default$needOpen(ContentPreviewViewerDelegate contentPreviewViewerDelegate) {
                return true;
            }

            public static boolean $default$needRemove(ContentPreviewViewerDelegate contentPreviewViewerDelegate) {
                return false;
            }

            public static void $default$remove(ContentPreviewViewerDelegate contentPreviewViewerDelegate, SendMessagesHelper.ImportingSticker importingSticker) {
            }

            public static void $default$sendGif(ContentPreviewViewerDelegate contentPreviewViewerDelegate, Object obj, Object obj2, boolean z, int i) {
            }
        }

        long getDialogId();

        String getQuery(boolean isGif);

        void gifAddedOrDeleted();

        boolean isInScheduleMode();

        boolean needMenu();

        boolean needOpen();

        boolean needRemove();

        boolean needSend();

        void openSet(TLRPC$InputStickerSet set, boolean clearInputField);

        void remove(SendMessagesHelper.ImportingSticker sticker);

        void sendGif(Object gif, Object parent, boolean notify, int scheduleDate);

        void sendSticker(TLRPC$Document sticker, String query, Object parent, boolean notify, int scheduleDate);
    }

    public /* synthetic */ WindowInsets lambda$setParentActivity$2$ContentPreviewViewer(View view, WindowInsets windowInsets) {
        lambda$setParentActivity$2(view, windowInsets);
        return windowInsets;
    }

    private class FrameLayoutDrawer extends FrameLayout {
        public FrameLayoutDrawer(Context context) {
            super(context);
            setWillNotDraw(false);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            ContentPreviewViewer.this.onDraw(canvas);
        }
    }

    /* renamed from: ir.eitaa.ui.ContentPreviewViewer$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean zHasRecentGif;
            int i;
            String str;
            if (ContentPreviewViewer.this.parentActivity == null) {
                return;
            }
            boolean z = false;
            if (ContentPreviewViewer.this.currentContentType == 0) {
                final boolean zIsStickerInFavorites = MediaDataController.getInstance(ContentPreviewViewer.this.currentAccount).isStickerInFavorites(ContentPreviewViewer.this.currentDocument);
                BottomSheet.Builder builder = new BottomSheet.Builder(ContentPreviewViewer.this.parentActivity, true, ContentPreviewViewer.this.resourcesProvider);
                ArrayList arrayList = new ArrayList();
                final ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                if (ContentPreviewViewer.this.delegate != null) {
                    if (ContentPreviewViewer.this.delegate.needSend() && !ContentPreviewViewer.this.delegate.isInScheduleMode()) {
                        arrayList.add(LocaleController.getString("SendStickerPreview", R.string.SendStickerPreview));
                        arrayList3.add(Integer.valueOf(R.drawable.outline_send));
                        arrayList2.add(0);
                    }
                    if (!ContentPreviewViewer.this.delegate.isInScheduleMode()) {
                        arrayList.add(LocaleController.getString("SendWithoutSound", R.string.SendWithoutSound));
                        arrayList3.add(Integer.valueOf(R.drawable.input_notify_off));
                        arrayList2.add(6);
                    }
                    if (ContentPreviewViewer.this.currentStickerSet != null && ContentPreviewViewer.this.delegate.needOpen()) {
                        arrayList.add(LocaleController.formatString("ViewPackPreview", R.string.ViewPackPreview, new Object[0]));
                        arrayList3.add(Integer.valueOf(R.drawable.outline_pack));
                        arrayList2.add(1);
                    }
                    if (ContentPreviewViewer.this.delegate.needRemove()) {
                        arrayList.add(LocaleController.getString("ImportStickersRemoveMenu", R.string.ImportStickersRemoveMenu));
                        arrayList3.add(Integer.valueOf(R.drawable.msg_delete));
                        arrayList2.add(5);
                    }
                }
                if (!MessageObject.isMaskDocument(ContentPreviewViewer.this.currentDocument) && (zIsStickerInFavorites || (MediaDataController.getInstance(ContentPreviewViewer.this.currentAccount).canAddStickerToFavorites() && MessageObject.isStickerHasSet(ContentPreviewViewer.this.currentDocument)))) {
                    if (zIsStickerInFavorites) {
                        i = R.string.DeleteFromFavorites;
                        str = "DeleteFromFavorites";
                    } else {
                        i = R.string.AddToFavorites;
                        str = "AddToFavorites";
                    }
                    arrayList.add(LocaleController.getString(str, i));
                    arrayList3.add(Integer.valueOf(zIsStickerInFavorites ? R.drawable.outline_unfave : R.drawable.outline_fave));
                    arrayList2.add(2);
                }
                if (ContentPreviewViewer.this.isRecentSticker) {
                    arrayList.add(LocaleController.getString("DeleteFromRecent", R.string.DeleteFromRecent));
                    arrayList3.add(Integer.valueOf(R.drawable.msg_delete));
                    arrayList2.add(4);
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                int[] iArr = new int[arrayList3.size()];
                for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                    iArr[i2] = ((Integer) arrayList3.get(i2)).intValue();
                }
                builder.setItems((CharSequence[]) arrayList.toArray(new CharSequence[0]), iArr, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ContentPreviewViewer$1$URFvsSZQJrF2Lb0PMe0qBX1fbhg
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        this.f$0.lambda$run$1$ContentPreviewViewer$1(arrayList2, zIsStickerInFavorites, dialogInterface, i3);
                    }
                });
                builder.setDimBehind(false);
                ContentPreviewViewer.this.visibleDialog = builder.create();
                ContentPreviewViewer.this.visibleDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.-$$Lambda$ContentPreviewViewer$1$paYIfKs6na3brHU5wvq3dv_lO8A
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.f$0.lambda$run$2$ContentPreviewViewer$1(dialogInterface);
                    }
                });
                ContentPreviewViewer.this.visibleDialog.show();
                ContentPreviewViewer.this.containerView.performHapticFeedback(0);
                if (ContentPreviewViewer.this.delegate == null || !ContentPreviewViewer.this.delegate.needRemove()) {
                    return;
                }
                BottomSheet.BottomSheetCell bottomSheetCell = ContentPreviewViewer.this.visibleDialog.getItemViews().get(0);
                bottomSheetCell.setTextColor(ContentPreviewViewer.this.getThemedColor("dialogTextRed"));
                bottomSheetCell.setIconColor(ContentPreviewViewer.this.getThemedColor("dialogRedIcon"));
                return;
            }
            if (ContentPreviewViewer.this.delegate != null) {
                ContentPreviewViewer.this.animateY = true;
                ContentPreviewViewer.this.visibleDialog = new BottomSheet(ContentPreviewViewer.this.parentActivity, z) { // from class: ir.eitaa.ui.ContentPreviewViewer.1.1
                    @Override // ir.eitaa.ui.ActionBar.BottomSheet
                    protected void onContainerTranslationYChanged(float translationY) {
                        if (ContentPreviewViewer.this.animateY) {
                            getSheetContainer();
                            if (ContentPreviewViewer.this.finalMoveY == 0.0f) {
                                ContentPreviewViewer.this.finalMoveY = 0.0f;
                                ContentPreviewViewer contentPreviewViewer = ContentPreviewViewer.this;
                                contentPreviewViewer.startMoveY = contentPreviewViewer.moveY;
                            }
                            ContentPreviewViewer.this.currentMoveYProgress = 1.0f - Math.min(1.0f, translationY / this.containerView.getMeasuredHeight());
                            ContentPreviewViewer contentPreviewViewer2 = ContentPreviewViewer.this;
                            contentPreviewViewer2.moveY = contentPreviewViewer2.startMoveY + ((ContentPreviewViewer.this.finalMoveY - ContentPreviewViewer.this.startMoveY) * ContentPreviewViewer.this.currentMoveYProgress);
                            ContentPreviewViewer.this.containerView.invalidate();
                            if (ContentPreviewViewer.this.currentMoveYProgress == 1.0f) {
                                ContentPreviewViewer.this.animateY = false;
                            }
                        }
                    }
                };
                ArrayList arrayList4 = new ArrayList();
                final ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = new ArrayList();
                if (ContentPreviewViewer.this.delegate.needSend() && !ContentPreviewViewer.this.delegate.isInScheduleMode()) {
                    arrayList4.add(LocaleController.getString("SendGifPreview", R.string.SendGifPreview));
                    arrayList6.add(Integer.valueOf(R.drawable.outline_send));
                    arrayList5.add(0);
                }
                if (ContentPreviewViewer.this.currentDocument != null) {
                    zHasRecentGif = MediaDataController.getInstance(ContentPreviewViewer.this.currentAccount).hasRecentGif(ContentPreviewViewer.this.currentDocument);
                    if (zHasRecentGif) {
                        arrayList4.add(LocaleController.formatString("Delete", R.string.Delete, new Object[0]));
                        arrayList6.add(Integer.valueOf(R.drawable.msg_delete));
                        arrayList5.add(1);
                    } else {
                        arrayList4.add(LocaleController.formatString("SaveToGIFs", R.string.SaveToGIFs, new Object[0]));
                        arrayList6.add(Integer.valueOf(R.drawable.outline_add_gif));
                        arrayList5.add(2);
                    }
                } else {
                    zHasRecentGif = false;
                }
                int[] iArr2 = new int[arrayList6.size()];
                for (int i3 = 0; i3 < arrayList6.size(); i3++) {
                    iArr2[i3] = ((Integer) arrayList6.get(i3)).intValue();
                }
                ContentPreviewViewer.this.visibleDialog.setItems((CharSequence[]) arrayList4.toArray(new CharSequence[0]), iArr2, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ContentPreviewViewer$1$VqdOpGwB4dsuJ9V_rMXivkEuMYE
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) {
                        this.f$0.lambda$run$4$ContentPreviewViewer$1(arrayList5, dialogInterface, i4);
                    }
                });
                ContentPreviewViewer.this.visibleDialog.setDimBehind(false);
                ContentPreviewViewer.this.visibleDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.-$$Lambda$ContentPreviewViewer$1$prDHEJBwqtYOpUGsHRx1FZEc_cw
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.f$0.lambda$run$5$ContentPreviewViewer$1(dialogInterface);
                    }
                });
                ContentPreviewViewer.this.visibleDialog.show();
                ContentPreviewViewer.this.containerView.performHapticFeedback(0);
                if (zHasRecentGif) {
                    ContentPreviewViewer.this.visibleDialog.setItemColor(arrayList4.size() - 1, ContentPreviewViewer.this.getThemedColor("dialogTextRed2"), ContentPreviewViewer.this.getThemedColor("dialogRedIcon"));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$1$ContentPreviewViewer$1(ArrayList arrayList, boolean z, DialogInterface dialogInterface, int i) {
            if (ContentPreviewViewer.this.parentActivity == null) {
                return;
            }
            if (((Integer) arrayList.get(i)).intValue() == 0 || ((Integer) arrayList.get(i)).intValue() == 6) {
                if (ContentPreviewViewer.this.delegate != null) {
                    ContentPreviewViewer.this.delegate.sendSticker(ContentPreviewViewer.this.currentDocument, ContentPreviewViewer.this.currentQuery, ContentPreviewViewer.this.parentObject, ((Integer) arrayList.get(i)).intValue() == 0, 0);
                    return;
                }
                return;
            }
            if (((Integer) arrayList.get(i)).intValue() == 1) {
                if (ContentPreviewViewer.this.delegate != null) {
                    ContentPreviewViewer.this.delegate.openSet(ContentPreviewViewer.this.currentStickerSet, ContentPreviewViewer.this.clearsInputField);
                    return;
                }
                return;
            }
            if (((Integer) arrayList.get(i)).intValue() == 2) {
                MediaDataController.getInstance(ContentPreviewViewer.this.currentAccount).addRecentSticker(2, ContentPreviewViewer.this.parentObject, ContentPreviewViewer.this.currentDocument, (int) (System.currentTimeMillis() / 1000), z);
                return;
            }
            if (((Integer) arrayList.get(i)).intValue() == 3) {
                final TLRPC$Document tLRPC$Document = ContentPreviewViewer.this.currentDocument;
                final Object obj = ContentPreviewViewer.this.parentObject;
                final String str = ContentPreviewViewer.this.currentQuery;
                final ContentPreviewViewerDelegate contentPreviewViewerDelegate = ContentPreviewViewer.this.delegate;
                AlertsCreator.createScheduleDatePickerDialog(ContentPreviewViewer.this.parentActivity, contentPreviewViewerDelegate.getDialogId(), new AlertsCreator.ScheduleDatePickerDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ContentPreviewViewer$1$RBn1SDbn_Q-b-lbIrLD5DOgGyl8
                    @Override // ir.eitaa.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
                    public final void didSelectDate(boolean z2, int i2) {
                        contentPreviewViewerDelegate.sendSticker(tLRPC$Document, str, obj, z2, i2);
                    }
                });
                return;
            }
            if (((Integer) arrayList.get(i)).intValue() == 4) {
                MediaDataController.getInstance(ContentPreviewViewer.this.currentAccount).addRecentSticker(0, ContentPreviewViewer.this.parentObject, ContentPreviewViewer.this.currentDocument, (int) (System.currentTimeMillis() / 1000), true);
            } else if (((Integer) arrayList.get(i)).intValue() == 5) {
                ContentPreviewViewer.this.delegate.remove(ContentPreviewViewer.this.importingSticker);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$2$ContentPreviewViewer$1(DialogInterface dialogInterface) {
            ContentPreviewViewer.this.visibleDialog = null;
            ContentPreviewViewer.this.close();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$4$ContentPreviewViewer$1(ArrayList arrayList, DialogInterface dialogInterface, int i) {
            if (ContentPreviewViewer.this.parentActivity == null) {
                return;
            }
            if (((Integer) arrayList.get(i)).intValue() == 0) {
                ContentPreviewViewer.this.delegate.sendGif(ContentPreviewViewer.this.currentDocument != null ? ContentPreviewViewer.this.currentDocument : ContentPreviewViewer.this.inlineResult, ContentPreviewViewer.this.parentObject, true, 0);
                return;
            }
            if (((Integer) arrayList.get(i)).intValue() == 1) {
                MediaDataController.getInstance(ContentPreviewViewer.this.currentAccount).removeRecentGif(ContentPreviewViewer.this.currentDocument);
                ContentPreviewViewer.this.delegate.gifAddedOrDeleted();
                return;
            }
            if (((Integer) arrayList.get(i)).intValue() == 2) {
                MediaDataController.getInstance(ContentPreviewViewer.this.currentAccount).addRecentGif(ContentPreviewViewer.this.currentDocument, (int) (System.currentTimeMillis() / 1000));
                MessagesController.getInstance(ContentPreviewViewer.this.currentAccount).saveGif("gif", ContentPreviewViewer.this.currentDocument);
                ContentPreviewViewer.this.delegate.gifAddedOrDeleted();
            } else if (((Integer) arrayList.get(i)).intValue() == 3) {
                final TLRPC$Document tLRPC$Document = ContentPreviewViewer.this.currentDocument;
                final TLRPC$BotInlineResult tLRPC$BotInlineResult = ContentPreviewViewer.this.inlineResult;
                final Object obj = ContentPreviewViewer.this.parentObject;
                final ContentPreviewViewerDelegate contentPreviewViewerDelegate = ContentPreviewViewer.this.delegate;
                AlertsCreator.createScheduleDatePickerDialog(ContentPreviewViewer.this.parentActivity, contentPreviewViewerDelegate.getDialogId(), new AlertsCreator.ScheduleDatePickerDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ContentPreviewViewer$1$cDtveOQm3-YcVMt23Hmenb7k8EY
                    @Override // ir.eitaa.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
                    public final void didSelectDate(boolean z, int i2) {
                        ContentPreviewViewer.AnonymousClass1.lambda$run$3(contentPreviewViewerDelegate, tLRPC$Document, tLRPC$BotInlineResult, obj, z, i2);
                    }
                }, ContentPreviewViewer.this.resourcesProvider);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        static /* synthetic */ void lambda$run$3(ContentPreviewViewerDelegate contentPreviewViewerDelegate, TLRPC$Document tLRPC$Document, TLRPC$BotInlineResult tLRPC$BotInlineResult, Object obj, boolean z, int i) {
            if (tLRPC$Document == null) {
                tLRPC$Document = tLRPC$BotInlineResult;
            }
            contentPreviewViewerDelegate.sendGif(tLRPC$Document, obj, z, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$5, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$5$ContentPreviewViewer$1(DialogInterface dialogInterface) {
            ContentPreviewViewer.this.visibleDialog = null;
            ContentPreviewViewer.this.close();
        }
    }

    public static ContentPreviewViewer getInstance() {
        ContentPreviewViewer contentPreviewViewer = Instance;
        if (contentPreviewViewer == null) {
            synchronized (PhotoViewer.class) {
                contentPreviewViewer = Instance;
                if (contentPreviewViewer == null) {
                    contentPreviewViewer = new ContentPreviewViewer();
                    Instance = contentPreviewViewer;
                }
            }
        }
        return contentPreviewViewer;
    }

    public static boolean hasInstance() {
        return Instance != null;
    }

    public void reset() {
        Runnable runnable = this.openPreviewRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.openPreviewRunnable = null;
        }
        View view = this.currentPreviewCell;
        if (view != null) {
            if (view instanceof StickerEmojiCell) {
                ((StickerEmojiCell) view).setScaled(false);
            } else if (view instanceof StickerCell) {
                ((StickerCell) view).setScaled(false);
            } else if (view instanceof ContextLinkCell) {
                ((ContextLinkCell) view).setScaled(false);
            }
            this.currentPreviewCell = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0193  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.MotionEvent r16, final ir.eitaa.ui.Components.RecyclerListView r17, final int r18, final java.lang.Object r19, ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate r20, ir.eitaa.ui.ActionBar.Theme.ResourcesProvider r21) {
        /*
            Method dump skipped, instructions count: 653
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ContentPreviewViewer.onTouch(android.view.MotionEvent, ir.eitaa.ui.Components.RecyclerListView, int, java.lang.Object, ir.eitaa.ui.ContentPreviewViewer$ContentPreviewViewerDelegate, ir.eitaa.ui.ActionBar.Theme$ResourcesProvider):boolean");
    }

    static /* synthetic */ void lambda$onTouch$0(RecyclerListView recyclerListView, Object obj) {
        if (recyclerListView instanceof RecyclerListView) {
            recyclerListView.setOnItemClickListener((RecyclerListView.OnItemClickListener) obj);
        }
    }

    protected void runSmoothHaptic() {
        if (Build.VERSION.SDK_INT >= 26) {
            Vibrator vibrator = (Vibrator) this.containerView.getContext().getSystemService("vibrator");
            if (this.vibrationEffect == null) {
                this.vibrationEffect = VibrationEffect.createWaveform(new long[]{0, 2}, -1);
            }
            vibrator.cancel();
            vibrator.vibrate(this.vibrationEffect);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r14, final ir.eitaa.ui.Components.RecyclerListView r15, final int r16, ir.eitaa.ui.ContentPreviewViewer.ContentPreviewViewerDelegate r17, final ir.eitaa.ui.ActionBar.Theme.ResourcesProvider r18) {
        /*
            r13 = this;
            r6 = r13
            r0 = r17
            r6.delegate = r0
            r5 = r18
            r6.resourcesProvider = r5
            int r0 = r14.getAction()
            r1 = 0
            if (r0 != 0) goto Lbb
            float r0 = r14.getX()
            int r0 = (int) r0
            float r2 = r14.getY()
            int r2 = (int) r2
            int r3 = r15.getChildCount()
            r4 = 0
        L1f:
            if (r4 >= r3) goto Lbb
            r7 = r15
            android.view.View r8 = r15.getChildAt(r4)
            if (r8 != 0) goto L29
            return r1
        L29:
            int r9 = r8.getTop()
            int r10 = r8.getBottom()
            int r11 = r8.getLeft()
            int r12 = r8.getRight()
            if (r9 > r2) goto Lb7
            if (r10 < r2) goto Lb7
            if (r11 > r0) goto Lb7
            if (r12 >= r0) goto L43
            goto Lb7
        L43:
            boolean r3 = r8 instanceof ir.eitaa.ui.Cells.StickerEmojiCell
            r4 = -1
            r9 = 1
            if (r3 == 0) goto L59
            r3 = r8
            ir.eitaa.ui.Cells.StickerEmojiCell r3 = (ir.eitaa.ui.Cells.StickerEmojiCell) r3
            boolean r3 = r3.showingBitmap()
            if (r3 == 0) goto L98
            ir.eitaa.messenger.ImageReceiver r3 = r6.centerImage
            r3.setRoundRadius(r1)
        L57:
            r10 = 0
            goto L99
        L59:
            boolean r3 = r8 instanceof ir.eitaa.ui.Cells.StickerCell
            if (r3 == 0) goto L6c
            r3 = r8
            ir.eitaa.ui.Cells.StickerCell r3 = (ir.eitaa.ui.Cells.StickerCell) r3
            boolean r3 = r3.showingBitmap()
            if (r3 == 0) goto L98
            ir.eitaa.messenger.ImageReceiver r3 = r6.centerImage
            r3.setRoundRadius(r1)
            goto L57
        L6c:
            boolean r3 = r8 instanceof ir.eitaa.ui.Cells.ContextLinkCell
            if (r3 == 0) goto L98
            r3 = r8
            ir.eitaa.ui.Cells.ContextLinkCell r3 = (ir.eitaa.ui.Cells.ContextLinkCell) r3
            boolean r10 = r3.showingBitmap()
            if (r10 == 0) goto L98
            boolean r10 = r3.isSticker()
            if (r10 == 0) goto L85
            ir.eitaa.messenger.ImageReceiver r3 = r6.centerImage
            r3.setRoundRadius(r1)
            goto L57
        L85:
            boolean r3 = r3.isGif()
            if (r3 == 0) goto L98
            ir.eitaa.messenger.ImageReceiver r3 = r6.centerImage
            r10 = 1086324736(0x40c00000, float:6.0)
            int r10 = ir.eitaa.messenger.AndroidUtilities.dp(r10)
            r3.setRoundRadius(r10)
            r10 = 1
            goto L99
        L98:
            r10 = -1
        L99:
            if (r10 != r4) goto L9c
            return r1
        L9c:
            r6.startX = r0
            r6.startY = r2
            r6.currentPreviewCell = r8
            ir.eitaa.ui.-$$Lambda$ContentPreviewViewer$SymcxvmJ7lhzk8ooulFOU8h5HqU r8 = new ir.eitaa.ui.-$$Lambda$ContentPreviewViewer$SymcxvmJ7lhzk8ooulFOU8h5HqU
            r0 = r8
            r1 = r13
            r2 = r15
            r3 = r16
            r4 = r10
            r5 = r18
            r0.<init>()
            r6.openPreviewRunnable = r8
            r0 = 200(0xc8, double:9.9E-322)
            ir.eitaa.messenger.AndroidUtilities.runOnUIThread(r8, r0)
            return r9
        Lb7:
            int r4 = r4 + 1
            goto L1f
        Lbb:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ContentPreviewViewer.onInterceptTouchEvent(android.view.MotionEvent, ir.eitaa.ui.Components.RecyclerListView, int, ir.eitaa.ui.ContentPreviewViewer$ContentPreviewViewerDelegate, ir.eitaa.ui.ActionBar.Theme$ResourcesProvider):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onInterceptTouchEvent$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onInterceptTouchEvent$1$ContentPreviewViewer(RecyclerListView recyclerListView, int i, int i2, Theme.ResourcesProvider resourcesProvider) {
        if (this.openPreviewRunnable == null) {
            return;
        }
        recyclerListView.setOnItemClickListener((RecyclerListView.OnItemClickListener) null);
        recyclerListView.requestDisallowInterceptTouchEvent(true);
        this.openPreviewRunnable = null;
        setParentActivity((Activity) recyclerListView.getContext());
        setKeyboardHeight(i);
        this.clearsInputField = false;
        View view = this.currentPreviewCell;
        if (view instanceof StickerEmojiCell) {
            StickerEmojiCell stickerEmojiCell = (StickerEmojiCell) view;
            TLRPC$Document sticker = stickerEmojiCell.getSticker();
            SendMessagesHelper.ImportingSticker stickerPath = stickerEmojiCell.getStickerPath();
            String emoji = stickerEmojiCell.getEmoji();
            ContentPreviewViewerDelegate contentPreviewViewerDelegate = this.delegate;
            open(sticker, stickerPath, emoji, contentPreviewViewerDelegate != null ? contentPreviewViewerDelegate.getQuery(false) : null, null, i2, stickerEmojiCell.isRecent(), stickerEmojiCell.getParentObject(), resourcesProvider);
            stickerEmojiCell.setScaled(true);
        } else if (view instanceof StickerCell) {
            StickerCell stickerCell = (StickerCell) view;
            TLRPC$Document sticker2 = stickerCell.getSticker();
            ContentPreviewViewerDelegate contentPreviewViewerDelegate2 = this.delegate;
            open(sticker2, null, null, contentPreviewViewerDelegate2 != null ? contentPreviewViewerDelegate2.getQuery(false) : null, null, i2, false, stickerCell.getParentObject(), resourcesProvider);
            stickerCell.setScaled(true);
            this.clearsInputField = stickerCell.isClearsInputField();
        } else if (view instanceof ContextLinkCell) {
            ContextLinkCell contextLinkCell = (ContextLinkCell) view;
            TLRPC$Document document = contextLinkCell.getDocument();
            ContentPreviewViewerDelegate contentPreviewViewerDelegate3 = this.delegate;
            open(document, null, null, contentPreviewViewerDelegate3 != null ? contentPreviewViewerDelegate3.getQuery(true) : null, contextLinkCell.getBotInlineResult(), i2, false, contextLinkCell.getBotInlineResult() != null ? contextLinkCell.getInlineBot() : contextLinkCell.getParentObject(), resourcesProvider);
            if (i2 != 1) {
                contextLinkCell.setScaled(true);
            }
        }
        this.currentPreviewCell.performHapticFeedback(0, 2);
    }

    public void setParentActivity(Activity activity) {
        int i = UserConfig.selectedAccount;
        this.currentAccount = i;
        this.centerImage.setCurrentAccount(i);
        this.centerImage.setLayerNum(7);
        if (this.parentActivity == activity) {
            return;
        }
        this.parentActivity = activity;
        this.slideUpDrawable = activity.getResources().getDrawable(R.drawable.preview_arrow);
        FrameLayout frameLayout = new FrameLayout(activity);
        this.windowView = frameLayout;
        frameLayout.setFocusable(true);
        this.windowView.setFocusableInTouchMode(true);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            this.windowView.setFitsSystemWindows(true);
            this.windowView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: ir.eitaa.ui.-$$Lambda$ContentPreviewViewer$hYsvZcnEPweIR9u7hiFSirvbbUs
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    this.f$0.lambda$setParentActivity$2$ContentPreviewViewer(view, windowInsets);
                    return windowInsets;
                }
            });
        }
        FrameLayoutDrawer frameLayoutDrawer = new FrameLayoutDrawer(activity);
        this.containerView = frameLayoutDrawer;
        frameLayoutDrawer.setFocusable(false);
        this.windowView.addView(this.containerView, LayoutHelper.createFrame(-1, -1, 51));
        this.containerView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.-$$Lambda$ContentPreviewViewer$8dluVAfEBe4tjqpaJo7-mMdn1RA
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f$0.lambda$setParentActivity$3$ContentPreviewViewer(view, motionEvent);
            }
        });
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.windowLayoutParams = layoutParams;
        layoutParams.height = -1;
        layoutParams.format = -3;
        layoutParams.width = -1;
        layoutParams.gravity = 48;
        layoutParams.type = 99;
        if (i2 >= 21) {
            layoutParams.flags = -2147417848;
        } else {
            layoutParams.flags = 8;
        }
        this.centerImage.setAspectFit(true);
        this.centerImage.setInvalidateAll(true);
        this.centerImage.setParentView(this.containerView);
    }

    private /* synthetic */ WindowInsets lambda$setParentActivity$2(View view, WindowInsets windowInsets) {
        this.lastInsets = windowInsets;
        return windowInsets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setParentActivity$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$setParentActivity$3$ContentPreviewViewer(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 6 || motionEvent.getAction() == 3) {
            close();
        }
        return true;
    }

    public void setKeyboardHeight(int height) {
        this.keyboardHeight = height;
    }

    public void open(TLRPC$Document document, SendMessagesHelper.ImportingSticker sticker, String emojiPath, String query, TLRPC$BotInlineResult botInlineResult, int contentType, boolean isRecent, Object parent, Theme.ResourcesProvider resourcesProvider) {
        TLRPC$InputStickerSet tLRPC$InputStickerSet;
        ContentPreviewViewerDelegate contentPreviewViewerDelegate;
        if (this.parentActivity == null || this.windowView == null) {
            return;
        }
        this.resourcesProvider = resourcesProvider;
        this.isRecentSticker = isRecent;
        this.stickerEmojiLayout = null;
        if (contentType != 0) {
            if (document != null) {
                TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(document.thumbs, 90);
                TLRPC$VideoSize documentVideoThumb = MessageObject.getDocumentVideoThumb(document);
                ImageLocation forDocument = ImageLocation.getForDocument(document);
                forDocument.imageType = 2;
                if (documentVideoThumb != null) {
                    this.centerImage.setImage(forDocument, null, ImageLocation.getForDocument(documentVideoThumb, document), null, ImageLocation.getForDocument(closestPhotoSizeWithSize, document), "90_90_b", null, document.size, null, "gif" + document, 0);
                } else {
                    this.centerImage.setImage(forDocument, null, ImageLocation.getForDocument(closestPhotoSizeWithSize, document), "90_90_b", document.size, null, "gif" + document, 0);
                }
            } else {
                if (botInlineResult == null || botInlineResult.content == null) {
                    return;
                }
                TLRPC$WebDocument tLRPC$WebDocument = botInlineResult.thumb;
                if ((tLRPC$WebDocument instanceof TLRPC$TL_webDocument) && "video/mp4".equals(tLRPC$WebDocument.mime_type)) {
                    this.centerImage.setImage(ImageLocation.getForWebFile(WebFile.createWithWebDocument(botInlineResult.content)), null, ImageLocation.getForWebFile(WebFile.createWithWebDocument(botInlineResult.thumb)), null, ImageLocation.getForWebFile(WebFile.createWithWebDocument(botInlineResult.thumb)), "90_90_b", null, botInlineResult.content.size, null, "gif" + botInlineResult, 1);
                } else {
                    this.centerImage.setImage(ImageLocation.getForWebFile(WebFile.createWithWebDocument(botInlineResult.content)), null, ImageLocation.getForWebFile(WebFile.createWithWebDocument(botInlineResult.thumb)), "90_90_b", botInlineResult.content.size, null, "gif" + botInlineResult, 1);
                }
            }
            AndroidUtilities.cancelRunOnUIThread(this.showSheetRunnable);
            AndroidUtilities.runOnUIThread(this.showSheetRunnable, 2000L);
        } else {
            if (document == null && sticker == null) {
                return;
            }
            if (textPaint == null) {
                TextPaint textPaint2 = new TextPaint(1);
                textPaint = textPaint2;
                textPaint2.setTextSize(AndroidUtilities.dp(24.0f));
            }
            if (document != null) {
                int i = 0;
                while (true) {
                    if (i >= document.attributes.size()) {
                        tLRPC$InputStickerSet = null;
                        break;
                    }
                    TLRPC$DocumentAttribute tLRPC$DocumentAttribute = document.attributes.get(i);
                    if ((tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeSticker) && (tLRPC$InputStickerSet = tLRPC$DocumentAttribute.stickerset) != null) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (tLRPC$InputStickerSet != null && ((contentPreviewViewerDelegate = this.delegate) == null || contentPreviewViewerDelegate.needMenu())) {
                    try {
                        BottomSheet bottomSheet = this.visibleDialog;
                        if (bottomSheet != null) {
                            bottomSheet.setOnDismissListener(null);
                            this.visibleDialog.dismiss();
                            this.visibleDialog = null;
                        }
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                    AndroidUtilities.cancelRunOnUIThread(this.showSheetRunnable);
                    AndroidUtilities.runOnUIThread(this.showSheetRunnable, 1300L);
                }
                this.currentStickerSet = tLRPC$InputStickerSet;
                this.centerImage.setImage(ImageLocation.getForDocument(document), (String) null, ImageLocation.getForDocument(FileLoader.getClosestPhotoSizeWithSize(document.thumbs, 90), document), (String) null, "webp", this.currentStickerSet, 1);
                int i2 = 0;
                while (true) {
                    if (i2 >= document.attributes.size()) {
                        break;
                    }
                    TLRPC$DocumentAttribute tLRPC$DocumentAttribute2 = document.attributes.get(i2);
                    if ((tLRPC$DocumentAttribute2 instanceof TLRPC$TL_documentAttributeSticker) && !TextUtils.isEmpty(tLRPC$DocumentAttribute2.alt)) {
                        this.stickerEmojiLayout = new StaticLayout(Emoji.replaceEmoji(tLRPC$DocumentAttribute2.alt, textPaint.getFontMetricsInt(), AndroidUtilities.dp(24.0f), false), textPaint, AndroidUtilities.dp(100.0f), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
                        break;
                    }
                    i2++;
                }
            } else if (sticker != null) {
                this.centerImage.setImage(sticker.path, (String) null, (Drawable) null, sticker.animated ? "tgs" : null, 0);
                if (emojiPath != null) {
                    this.stickerEmojiLayout = new StaticLayout(Emoji.replaceEmoji(emojiPath, textPaint.getFontMetricsInt(), AndroidUtilities.dp(24.0f), false), textPaint, AndroidUtilities.dp(100.0f), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
                }
                if (this.delegate.needMenu()) {
                    try {
                        BottomSheet bottomSheet2 = this.visibleDialog;
                        if (bottomSheet2 != null) {
                            bottomSheet2.setOnDismissListener(null);
                            this.visibleDialog.dismiss();
                            this.visibleDialog = null;
                        }
                    } catch (Exception e2) {
                        FileLog.e(e2);
                    }
                    AndroidUtilities.cancelRunOnUIThread(this.showSheetRunnable);
                    AndroidUtilities.runOnUIThread(this.showSheetRunnable, 1300L);
                }
            }
        }
        this.currentContentType = contentType;
        this.currentDocument = document;
        this.importingSticker = sticker;
        this.currentQuery = query;
        this.inlineResult = botInlineResult;
        this.parentObject = parent;
        this.resourcesProvider = resourcesProvider;
        this.containerView.invalidate();
        if (this.isVisible) {
            return;
        }
        AndroidUtilities.lockOrientation(this.parentActivity);
        try {
            if (this.windowView.getParent() != null) {
                ((WindowManager) this.parentActivity.getSystemService("window")).removeView(this.windowView);
            }
        } catch (Exception e3) {
            FileLog.e(e3);
        }
        ((WindowManager) this.parentActivity.getSystemService("window")).addView(this.windowView, this.windowLayoutParams);
        this.isVisible = true;
        this.showProgress = 0.0f;
        this.lastTouchY = -10000.0f;
        this.currentMoveYProgress = 0.0f;
        this.finalMoveY = 0.0f;
        this.currentMoveY = 0.0f;
        this.moveY = 0.0f;
        this.lastUpdateTime = System.currentTimeMillis();
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.stopAllHeavyOperations, 8);
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public void close() {
        if (this.parentActivity == null || this.visibleDialog != null) {
            return;
        }
        AndroidUtilities.cancelRunOnUIThread(this.showSheetRunnable);
        this.showProgress = 1.0f;
        this.lastUpdateTime = System.currentTimeMillis();
        this.containerView.invalidate();
        try {
            BottomSheet bottomSheet = this.visibleDialog;
            if (bottomSheet != null) {
                bottomSheet.dismiss();
                this.visibleDialog = null;
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        this.currentDocument = null;
        this.currentStickerSet = null;
        this.currentQuery = null;
        this.delegate = null;
        this.isVisible = false;
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.startAllHeavyOperations, 8);
    }

    public void destroy() {
        FrameLayout frameLayout;
        this.isVisible = false;
        this.delegate = null;
        this.currentDocument = null;
        this.currentQuery = null;
        this.currentStickerSet = null;
        try {
            BottomSheet bottomSheet = this.visibleDialog;
            if (bottomSheet != null) {
                bottomSheet.dismiss();
                this.visibleDialog = null;
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (this.parentActivity == null || (frameLayout = this.windowView) == null) {
            return;
        }
        try {
            if (frameLayout.getParent() != null) {
                ((WindowManager) this.parentActivity.getSystemService("window")).removeViewImmediate(this.windowView);
            }
            this.windowView = null;
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        Instance = null;
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.startAllHeavyOperations, 8);
    }

    private float rubberYPoisition(float offset, float factor) {
        return (-((1.0f - (1.0f / (((Math.abs(offset) * 0.55f) / factor) + 1.0f))) * factor)) * (offset >= 0.0f ? -1.0f : 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        ColorDrawable colorDrawable;
        int stableInsetTop;
        int stableInsetBottom;
        int iMin;
        Drawable drawable;
        WindowInsets windowInsets;
        if (this.containerView == null || (colorDrawable = this.backgroundDrawable) == null) {
            return;
        }
        colorDrawable.setAlpha((int) (this.showProgress * 180.0f));
        this.backgroundDrawable.setBounds(0, 0, this.containerView.getWidth(), this.containerView.getHeight());
        this.backgroundDrawable.draw(canvas);
        canvas.save();
        if (Build.VERSION.SDK_INT >= 21 && (windowInsets = this.lastInsets) != null) {
            stableInsetBottom = windowInsets.getStableInsetBottom() + this.lastInsets.getStableInsetTop();
            stableInsetTop = this.lastInsets.getStableInsetTop();
        } else {
            stableInsetTop = AndroidUtilities.statusBarHeight;
            stableInsetBottom = 0;
        }
        if (this.currentContentType == 1) {
            iMin = Math.min(this.containerView.getWidth(), this.containerView.getHeight() - stableInsetBottom) - AndroidUtilities.dp(40.0f);
        } else {
            iMin = (int) (Math.min(this.containerView.getWidth(), this.containerView.getHeight() - stableInsetBottom) / 1.8f);
        }
        canvas.translate(this.containerView.getWidth() / 2, this.moveY + Math.max((iMin / 2) + stableInsetTop + (this.stickerEmojiLayout != null ? AndroidUtilities.dp(40.0f) : 0), ((this.containerView.getHeight() - stableInsetBottom) - this.keyboardHeight) / 2));
        float f = this.showProgress;
        int i = (int) (iMin * ((f * 0.8f) / 0.8f));
        this.centerImage.setAlpha(f);
        float f2 = (-i) / 2;
        float f3 = i;
        this.centerImage.setImageCoords(f2, f2, f3, f3);
        this.centerImage.draw(canvas);
        if (this.currentContentType == 1 && (drawable = this.slideUpDrawable) != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = this.slideUpDrawable.getIntrinsicHeight();
            int iDp = (int) (this.centerImage.getDrawRegion().top - AndroidUtilities.dp(((this.currentMoveY / AndroidUtilities.dp(60.0f)) * 6.0f) + 17.0f));
            this.slideUpDrawable.setAlpha((int) ((1.0f - this.currentMoveYProgress) * 255.0f));
            this.slideUpDrawable.setBounds((-intrinsicWidth) / 2, (-intrinsicHeight) + iDp, intrinsicWidth / 2, iDp);
            this.slideUpDrawable.draw(canvas);
        }
        if (this.stickerEmojiLayout != null) {
            canvas.translate(-AndroidUtilities.dp(50.0f), ((-this.centerImage.getImageHeight()) / 2.0f) - AndroidUtilities.dp(30.0f));
            this.stickerEmojiLayout.draw(canvas);
        }
        canvas.restore();
        if (this.isVisible) {
            if (this.showProgress != 1.0f) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j = jCurrentTimeMillis - this.lastUpdateTime;
                this.lastUpdateTime = jCurrentTimeMillis;
                this.showProgress += j / 120.0f;
                this.containerView.invalidate();
                if (this.showProgress > 1.0f) {
                    this.showProgress = 1.0f;
                    return;
                }
                return;
            }
            return;
        }
        if (this.showProgress != 0.0f) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            long j2 = jCurrentTimeMillis2 - this.lastUpdateTime;
            this.lastUpdateTime = jCurrentTimeMillis2;
            this.showProgress -= j2 / 120.0f;
            this.containerView.invalidate();
            if (this.showProgress < 0.0f) {
                this.showProgress = 0.0f;
            }
            if (this.showProgress == 0.0f) {
                this.centerImage.setImageBitmap((Drawable) null);
                AndroidUtilities.unlockOrientation(this.parentActivity);
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ContentPreviewViewer$w9qwT8CCvbiHjFjrzaAcokJs8sg
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onDraw$4$ContentPreviewViewer();
                    }
                });
                try {
                    if (this.windowView.getParent() != null) {
                        ((WindowManager) this.parentActivity.getSystemService("window")).removeView(this.windowView);
                    }
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onDraw$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onDraw$4$ContentPreviewViewer() {
        this.centerImage.setImageBitmap((Bitmap) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
