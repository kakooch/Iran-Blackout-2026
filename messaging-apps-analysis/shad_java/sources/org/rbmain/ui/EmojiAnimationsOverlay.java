package org.rbmain.ui;

import android.graphics.Canvas;
import android.view.View;
import android.widget.FrameLayout;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.Emoji;
import org.rbmain.messenger.EmojiData;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaDataController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.Utilities;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$InputStickerSet;
import org.rbmain.tgnet.TLRPC$TL_dataJSON;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_messages_getStickerSet;
import org.rbmain.tgnet.TLRPC$TL_messages_setTyping;
import org.rbmain.tgnet.TLRPC$TL_messages_stickerSet;
import org.rbmain.tgnet.TLRPC$TL_sendMessageEmojiInteraction;
import org.rbmain.tgnet.TLRPC$TL_stickerPack;
import org.rbmain.tgnet.TLRPC$VideoSize;
import org.rbmain.ui.Cells.ChatActionCell;
import org.rbmain.ui.Cells.ChatMessageCell;
import org.rbmain.ui.Components.Bulletin;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.StickerSetBulletinLayout;
import org.rbmain.ui.Components.StickersAlert;

/* loaded from: classes4.dex */
public class EmojiAnimationsOverlay implements NotificationCenter.NotificationCenterDelegate {
    private static final HashSet<String> excludeEmojiFromPack;
    private static final HashSet<String> supportedEmoji = new HashSet<>();
    private boolean attached;
    ChatActivity chatActivity;
    FrameLayout contentLayout;
    int currentAccount;
    long dialogId;
    Runnable hintRunnable;
    String lastTappedEmoji;
    RecyclerListView listView;
    private HashMap<Long, Boolean> preloaded;
    Runnable sentInteractionsRunnable;
    TLRPC$TL_messages_stickerSet set;
    long threadMsgId;
    boolean inited = false;
    HashMap<String, ArrayList<TLRPC$Document>> emojiInteractionsStickersMap = new HashMap<>();
    HashMap<Long, Integer> lastAnimationIndex = new HashMap<>();
    Random random = new Random();
    long lastTappedMsgId = -1;
    long lastTappedTime = 0;
    ArrayList<Long> timeIntervals = new ArrayList<>();
    ArrayList<Integer> animationIndexes = new ArrayList<>();
    ArrayList<DrawingObject> drawingObjects = new ArrayList<>();

    public void onAllEffectsEnd() {
        throw null;
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        excludeEmojiFromPack = hashSet;
        hashSet.add("0⃣");
        hashSet.add("1⃣");
        hashSet.add("2⃣");
        hashSet.add("3⃣");
        hashSet.add("4⃣");
        hashSet.add("5⃣");
        hashSet.add("6⃣");
        hashSet.add("7⃣");
        hashSet.add("8⃣");
        hashSet.add("9⃣");
    }

    public EmojiAnimationsOverlay(ChatActivity chatActivity, FrameLayout frameLayout, RecyclerListView recyclerListView, int i, long j, long j2) {
        this.chatActivity = chatActivity;
        this.contentLayout = frameLayout;
        this.listView = recyclerListView;
        this.currentAccount = i;
        this.dialogId = j;
        this.threadMsgId = j2;
    }

    protected void onAttachedToWindow() {
        this.attached = true;
        checkStickerPack();
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.diceStickersDidLoad);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.onEmojiInteractionsReceived);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.updateInterfaces);
    }

    protected void onDetachedFromWindow() {
        this.attached = false;
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.diceStickersDidLoad);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.onEmojiInteractionsReceived);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.updateInterfaces);
    }

    public void checkStickerPack() {
        if (this.inited) {
            return;
        }
        TLRPC$TL_messages_stickerSet stickerSetByName = MediaDataController.getInstance(this.currentAccount).getStickerSetByName("EmojiAnimations");
        this.set = stickerSetByName;
        if (stickerSetByName == null) {
            this.set = MediaDataController.getInstance(this.currentAccount).getStickerSetByEmojiOrName("EmojiAnimations");
        }
        if (this.set == null) {
            MediaDataController.getInstance(this.currentAccount).loadStickersByEmojiOrName("EmojiAnimations", false, true);
        }
        if (this.set != null) {
            HashMap map = new HashMap();
            for (int i = 0; i < this.set.documents.size(); i++) {
                map.put(Long.valueOf(this.set.documents.get(i).id), this.set.documents.get(i));
            }
            for (int i2 = 0; i2 < this.set.packs.size(); i2++) {
                TLRPC$TL_stickerPack tLRPC$TL_stickerPack = this.set.packs.get(i2);
                if (!excludeEmojiFromPack.contains(tLRPC$TL_stickerPack.emoticon) && tLRPC$TL_stickerPack.documents.size() > 0) {
                    supportedEmoji.add(tLRPC$TL_stickerPack.emoticon);
                    ArrayList<TLRPC$Document> arrayList = new ArrayList<>();
                    this.emojiInteractionsStickersMap.put(tLRPC$TL_stickerPack.emoticon, arrayList);
                    for (int i3 = 0; i3 < tLRPC$TL_stickerPack.documents.size(); i3++) {
                        arrayList.add((TLRPC$Document) map.get(tLRPC$TL_stickerPack.documents.get(i3)));
                    }
                    if (tLRPC$TL_stickerPack.emoticon.equals("❤")) {
                        String[] strArr = {"🧡", "💛", "💚", "💙", "💜", "🖤", "🤍", "🤎"};
                        for (int i4 = 0; i4 < 8; i4++) {
                            String str = strArr[i4];
                            supportedEmoji.add(str);
                            this.emojiInteractionsStickersMap.put(str, arrayList);
                        }
                    }
                }
            }
            this.inited = true;
        }
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) throws JSONException {
        Integer printingStringType;
        if (i == NotificationCenter.diceStickersDidLoad) {
            if ("EmojiAnimations".equals((String) objArr[0])) {
                checkStickerPack();
                return;
            }
            return;
        }
        if (i == NotificationCenter.onEmojiInteractionsReceived) {
            long jLongValue = ((Long) objArr[0]).longValue();
            TLRPC$TL_sendMessageEmojiInteraction tLRPC$TL_sendMessageEmojiInteraction = (TLRPC$TL_sendMessageEmojiInteraction) objArr[1];
            if (jLongValue == this.dialogId && supportedEmoji.contains(tLRPC$TL_sendMessageEmojiInteraction.emoticon)) {
                final long j = tLRPC$TL_sendMessageEmojiInteraction.msg_id;
                if (tLRPC$TL_sendMessageEmojiInteraction.interaction.data != null) {
                    try {
                        JSONArray jSONArray = new JSONObject(tLRPC$TL_sendMessageEmojiInteraction.interaction.data).getJSONArray("a");
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i3);
                            final int iOptInt = jSONObject.optInt("i", 1) - 1;
                            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.EmojiAnimationsOverlay.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    EmojiAnimationsOverlay.this.findViewAndShowAnimation(j, iOptInt);
                                }
                            }, (long) (jSONObject.optDouble("t", 0.0d) * 1000.0d));
                        }
                        return;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                return;
            }
            return;
        }
        if (i == NotificationCenter.updateInterfaces && (printingStringType = MessagesController.getInstance(this.currentAccount).getPrintingStringType(this.dialogId, this.threadMsgId)) != null && printingStringType.intValue() == 5) {
            cancelHintRunnable();
        }
    }

    public boolean supports(String str) {
        return this.emojiInteractionsStickersMap.containsKey(unwrapEmoji(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void findViewAndShowAnimation(long j, int i) {
        if (this.attached) {
            ChatMessageCell chatMessageCell = null;
            int i2 = 0;
            while (true) {
                if (i2 >= this.listView.getChildCount()) {
                    break;
                }
                View childAt = this.listView.getChildAt(i2);
                if (childAt instanceof ChatMessageCell) {
                    ChatMessageCell chatMessageCell2 = (ChatMessageCell) childAt;
                    String stickerEmoji = chatMessageCell2.getMessageObject().getStickerEmoji();
                    if (stickerEmoji == null) {
                        stickerEmoji = chatMessageCell2.getMessageObject().messageOwner.message;
                    }
                    if (chatMessageCell2.getPhotoImage().hasNotThumb() && stickerEmoji != null && chatMessageCell2.getMessageObject().getId() == j) {
                        chatMessageCell = chatMessageCell2;
                        break;
                    }
                }
                i2++;
            }
            if (chatMessageCell != null) {
                this.chatActivity.restartSticker(chatMessageCell);
                if (!EmojiData.hasEmojiSupportVibration(chatMessageCell.getMessageObject().getStickerEmoji()) && !chatMessageCell.getMessageObject().isPremiumSticker() && !chatMessageCell.getMessageObject().isAnimatedAnimatedEmoji()) {
                    chatMessageCell.performHapticFeedback(3);
                }
                showAnimationForCell(chatMessageCell, i, false, true);
            }
        }
    }

    public void draw(Canvas canvas) {
        float y;
        ImageReceiver photoImage;
        float fDp;
        if (this.drawingObjects.isEmpty()) {
            return;
        }
        int i = 0;
        while (i < this.drawingObjects.size()) {
            DrawingObject drawingObject = this.drawingObjects.get(i);
            drawingObject.viewFound = false;
            int i2 = 0;
            while (true) {
                if (i2 >= this.listView.getChildCount()) {
                    y = 0.0f;
                    break;
                }
                View childAt = this.listView.getChildAt(i2);
                MessageObject messageObject = null;
                if (childAt instanceof ChatMessageCell) {
                    ChatMessageCell chatMessageCell = (ChatMessageCell) childAt;
                    messageObject = chatMessageCell.getMessageObject();
                    photoImage = chatMessageCell.getPhotoImage();
                } else if (childAt instanceof ChatActionCell) {
                    ChatActionCell chatActionCell = (ChatActionCell) childAt;
                    messageObject = chatActionCell.getMessageObject();
                    photoImage = chatActionCell.getPhotoImage();
                } else {
                    photoImage = null;
                }
                if (messageObject == null || messageObject.getId() != drawingObject.messageId) {
                    i2++;
                } else {
                    drawingObject.viewFound = true;
                    float x = this.listView.getX() + childAt.getX();
                    float y2 = this.listView.getY() + childAt.getY();
                    y = childAt.getY();
                    if (drawingObject.isPremiumSticker) {
                        drawingObject.lastX = x + photoImage.getImageX();
                        drawingObject.lastY = y2 + photoImage.getImageY();
                    } else {
                        float imageX = x + photoImage.getImageX();
                        float imageY = y2 + photoImage.getImageY();
                        if (drawingObject.isOut) {
                            fDp = ((-photoImage.getImageWidth()) * 2.0f) + AndroidUtilities.dp(24.0f);
                        } else {
                            fDp = -AndroidUtilities.dp(24.0f);
                        }
                        float imageWidth = imageY - photoImage.getImageWidth();
                        drawingObject.lastX = imageX + fDp;
                        drawingObject.lastY = imageWidth;
                    }
                    drawingObject.lastW = photoImage.getImageWidth();
                    drawingObject.lastH = photoImage.getImageHeight();
                }
            }
            if (!drawingObject.viewFound || drawingObject.lastH + y < this.chatActivity.getChatListViewPadding() || y > this.listView.getMeasuredHeight() - this.chatActivity.blurredViewBottomOffset) {
                drawingObject.removing = true;
            }
            if (drawingObject.removing) {
                float f = drawingObject.removeProgress;
                if (f != 1.0f) {
                    float fClamp = Utilities.clamp(f + 0.10666667f, 1.0f, 0.0f);
                    drawingObject.removeProgress = fClamp;
                    drawingObject.imageReceiver.setAlpha(1.0f - fClamp);
                    this.chatActivity.contentView.invalidate();
                }
            }
            if (drawingObject.isPremiumSticker) {
                float f2 = drawingObject.lastH;
                float f3 = 1.49926f * f2;
                float f4 = 0.0546875f * f3;
                float f5 = ((drawingObject.lastY + (f2 / 2.0f)) - (f3 / 2.0f)) - (0.00279f * f3);
                if (!drawingObject.isOut) {
                    drawingObject.imageReceiver.setImageCoords(drawingObject.lastX - f4, f5, f3, f3);
                } else {
                    drawingObject.imageReceiver.setImageCoords(((drawingObject.lastX + drawingObject.lastW) - f3) + f4, f5, f3, f3);
                }
                if (!drawingObject.isOut) {
                    canvas.save();
                    canvas.scale(-1.0f, 1.0f, drawingObject.imageReceiver.getCenterX(), drawingObject.imageReceiver.getCenterY());
                    drawingObject.imageReceiver.draw(canvas);
                    canvas.restore();
                } else {
                    drawingObject.imageReceiver.draw(canvas);
                }
            } else {
                ImageReceiver imageReceiver = drawingObject.imageReceiver;
                float f6 = drawingObject.lastX + drawingObject.randomOffsetX;
                float f7 = drawingObject.lastY + drawingObject.randomOffsetY;
                float f8 = drawingObject.lastW;
                imageReceiver.setImageCoords(f6, f7, f8 * 3.0f, f8 * 3.0f);
                if (!drawingObject.isOut) {
                    canvas.save();
                    canvas.scale(-1.0f, 1.0f, drawingObject.imageReceiver.getCenterX(), drawingObject.imageReceiver.getCenterY());
                    drawingObject.imageReceiver.draw(canvas);
                    canvas.restore();
                } else {
                    drawingObject.imageReceiver.draw(canvas);
                }
            }
            if (drawingObject.removeProgress == 1.0f || (drawingObject.wasPlayed && drawingObject.imageReceiver.getLottieAnimation() != null && drawingObject.imageReceiver.getLottieAnimation().getCurrentFrame() >= drawingObject.imageReceiver.getLottieAnimation().getFramesCount() - 2)) {
                this.drawingObjects.remove(i);
                i--;
            } else if (drawingObject.imageReceiver.getLottieAnimation() != null && drawingObject.imageReceiver.getLottieAnimation().isRunning()) {
                drawingObject.wasPlayed = true;
            } else if (drawingObject.imageReceiver.getLottieAnimation() != null && !drawingObject.imageReceiver.getLottieAnimation().isRunning()) {
                drawingObject.imageReceiver.getLottieAnimation().setCurrentFrame(0, true);
                drawingObject.imageReceiver.getLottieAnimation().start();
            }
            i++;
        }
        if (this.drawingObjects.isEmpty()) {
            onAllEffectsEnd();
        }
        this.contentLayout.invalidate();
    }

    public boolean onTapItem(ChatMessageCell chatMessageCell, ChatActivity chatActivity, boolean z) {
        TLRPC$Document emojiAnimatedSticker;
        if (chatActivity.isSecretChat() || chatMessageCell.getMessageObject() == null || chatMessageCell.getMessageObject().getId() < 0) {
            return false;
        }
        if (!chatMessageCell.getMessageObject().isPremiumSticker() && chatActivity.currentUser == null) {
            return false;
        }
        boolean zShowAnimationForCell = showAnimationForCell(chatMessageCell, -1, z, false);
        if (z && zShowAnimationForCell && !EmojiData.hasEmojiSupportVibration(chatMessageCell.getMessageObject().getStickerEmoji()) && !chatMessageCell.getMessageObject().isPremiumSticker() && !chatMessageCell.getMessageObject().isAnimatedAnimatedEmoji()) {
            chatMessageCell.performHapticFeedback(3);
        }
        if (chatMessageCell.getMessageObject().isPremiumSticker() || (!z && chatMessageCell.getMessageObject().isAnimatedEmojiStickerSingle())) {
            chatMessageCell.getMessageObject().forcePlayEffect = false;
            chatMessageCell.getMessageObject().messageOwner.premiumEffectWasPlayed = true;
            chatActivity.getMessagesStorage().updateMessageCustomParams(this.dialogId, chatMessageCell.getMessageObject().messageOwner);
            return zShowAnimationForCell;
        }
        Integer printingStringType = MessagesController.getInstance(this.currentAccount).getPrintingStringType(this.dialogId, this.threadMsgId);
        if ((printingStringType == null || printingStringType.intValue() != 5) && this.hintRunnable == null && zShowAnimationForCell && ((Bulletin.getVisibleBulletin() == null || !Bulletin.getVisibleBulletin().isShowing()) && SharedConfig.emojiInteractionsHintCount > 0 && UserConfig.getInstance(this.currentAccount).getClientUserId() != chatActivity.currentUser.id)) {
            SharedConfig.updateEmojiInteractionsHintCount(SharedConfig.emojiInteractionsHintCount - 1);
            if (chatMessageCell.getMessageObject().isAnimatedAnimatedEmoji()) {
                emojiAnimatedSticker = chatMessageCell.getMessageObject().getDocument();
            } else {
                emojiAnimatedSticker = MediaDataController.getInstance(this.currentAccount).getEmojiAnimatedSticker(chatMessageCell.getMessageObject().getStickerEmoji());
            }
            StickerSetBulletinLayout stickerSetBulletinLayout = new StickerSetBulletinLayout(chatActivity.getParentActivity(), null, -1, emojiAnimatedSticker, chatActivity.getResourceProvider());
            stickerSetBulletinLayout.subtitleTextView.setVisibility(8);
            stickerSetBulletinLayout.titleTextView.setText(Emoji.replaceEmoji(AndroidUtilities.replaceTags(LocaleController.formatString("EmojiInteractionTapHint", R.string.EmojiInteractionTapHint, chatActivity.currentUser.first_name)), stickerSetBulletinLayout.titleTextView.getPaint().getFontMetricsInt(), false));
            stickerSetBulletinLayout.titleTextView.setTypeface(null);
            stickerSetBulletinLayout.titleTextView.setMaxLines(3);
            stickerSetBulletinLayout.titleTextView.setSingleLine(false);
            final Bulletin bulletinMake = Bulletin.make(chatActivity, stickerSetBulletinLayout, 2750);
            Runnable runnable = new Runnable() { // from class: org.rbmain.ui.EmojiAnimationsOverlay.2
                @Override // java.lang.Runnable
                public void run() {
                    bulletinMake.show();
                    EmojiAnimationsOverlay.this.hintRunnable = null;
                }
            };
            this.hintRunnable = runnable;
            AndroidUtilities.runOnUIThread(runnable, 1500L);
        }
        return zShowAnimationForCell;
    }

    public void cancelHintRunnable() {
        Runnable runnable = this.hintRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
        }
        this.hintRunnable = null;
    }

    public void preloadAnimation(ChatMessageCell chatMessageCell) {
        ArrayList<TLRPC$Document> arrayList;
        MessageObject messageObject = chatMessageCell.getMessageObject();
        if (messageObject.isPremiumSticker()) {
            return;
        }
        String stickerEmoji = messageObject.getStickerEmoji();
        if (stickerEmoji == null) {
            stickerEmoji = messageObject.messageOwner.message;
        }
        String strUnwrapEmoji = unwrapEmoji(stickerEmoji);
        if (!supportedEmoji.contains(strUnwrapEmoji) || (arrayList = this.emojiInteractionsStickersMap.get(strUnwrapEmoji)) == null || arrayList.isEmpty()) {
            return;
        }
        int imageWidth = (int) ((chatMessageCell.getPhotoImage().getImageWidth() * 2.0f) / AndroidUtilities.density);
        int iMin = Math.min(1, arrayList.size());
        for (int i = 0; i < iMin; i++) {
            preloadAnimation(arrayList.get(i), imageWidth);
        }
    }

    private void preloadAnimation(TLRPC$Document tLRPC$Document, int i) {
        if (tLRPC$Document == null) {
            return;
        }
        HashMap<Long, Boolean> map = this.preloaded;
        if (map == null || !map.containsKey(Long.valueOf(tLRPC$Document.id))) {
            if (this.preloaded == null) {
                this.preloaded = new HashMap<>();
            }
            this.preloaded.put(Long.valueOf(tLRPC$Document.id), Boolean.TRUE);
            new ImageReceiver().setImage(ImageLocation.getForDocument(tLRPC$Document), i + "_" + i, null, "tgs", this.set, 1);
        }
    }

    private boolean showAnimationForCell(final ChatMessageCell chatMessageCell, int i, final boolean z, boolean z2) {
        ArrayList<TLRPC$Document> arrayList;
        TLRPC$Document tLRPC$Document;
        TLRPC$VideoSize premiumStickerAnimation;
        Runnable runnable;
        String str;
        int iAbs = i;
        boolean z3 = false;
        if (this.drawingObjects.size() > 12 || !chatMessageCell.getPhotoImage().hasNotThumb()) {
            return false;
        }
        final MessageObject messageObject = chatMessageCell.getMessageObject();
        String stickerEmoji = messageObject.getStickerEmoji();
        if (stickerEmoji == null) {
            stickerEmoji = messageObject.messageOwner.message;
        }
        if (stickerEmoji == null) {
            return false;
        }
        float imageHeight = chatMessageCell.getPhotoImage().getImageHeight();
        float imageWidth = chatMessageCell.getPhotoImage().getImageWidth();
        if (imageHeight <= 0.0f || imageWidth <= 0.0f) {
            return false;
        }
        String strUnwrapEmoji = unwrapEmoji(stickerEmoji);
        boolean zIsPremiumSticker = messageObject.isPremiumSticker();
        if ((!supportedEmoji.contains(strUnwrapEmoji) && !zIsPremiumSticker) || (((arrayList = this.emojiInteractionsStickersMap.get(strUnwrapEmoji)) == null || arrayList.isEmpty()) && !zIsPremiumSticker)) {
            return false;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < this.drawingObjects.size()) {
            if (this.drawingObjects.get(i2).messageId == chatMessageCell.getMessageObject().getId()) {
                i3++;
                if (this.drawingObjects.get(i2).imageReceiver.getLottieAnimation() == null || this.drawingObjects.get(i2).imageReceiver.getLottieAnimation().isGeneratingCache()) {
                    return z3;
                }
            }
            if (this.drawingObjects.get(i2).document == null || chatMessageCell.getMessageObject().getDocument() == null) {
                str = strUnwrapEmoji;
            } else {
                str = strUnwrapEmoji;
                if (this.drawingObjects.get(i2).document.id == chatMessageCell.getMessageObject().getDocument().id) {
                    i4++;
                }
            }
            i2++;
            strUnwrapEmoji = str;
            z3 = false;
        }
        String str2 = strUnwrapEmoji;
        if (z && zIsPremiumSticker && i3 > 0) {
            if (Bulletin.getVisibleBulletin() != null && Bulletin.getVisibleBulletin().hash == messageObject.getId()) {
                return false;
            }
            TLRPC$InputStickerSet inputStickerSet = messageObject.getInputStickerSet();
            TLRPC$TL_messages_stickerSet stickerSetByName = inputStickerSet.short_name != null ? MediaDataController.getInstance(this.currentAccount).getStickerSetByName(inputStickerSet.short_name) : null;
            if (stickerSetByName == null) {
                stickerSetByName = MediaDataController.getInstance(this.currentAccount).getStickerSetById(inputStickerSet.id);
            }
            if (stickerSetByName == null) {
                TLRPC$TL_messages_getStickerSet tLRPC$TL_messages_getStickerSet = new TLRPC$TL_messages_getStickerSet();
                tLRPC$TL_messages_getStickerSet.stickerset = inputStickerSet;
                ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_messages_getStickerSet, new RequestDelegate() { // from class: org.rbmain.ui.EmojiAnimationsOverlay$$ExternalSyntheticLambda3
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$showAnimationForCell$1(messageObject, tLObject, tLRPC$TL_error);
                    }
                });
                return false;
            }
            lambda$showAnimationForCell$0(stickerSetByName, messageObject);
            return false;
        }
        if (i3 >= 4) {
            return false;
        }
        if (zIsPremiumSticker) {
            premiumStickerAnimation = messageObject.getPremiumStickerAnimation();
            tLRPC$Document = null;
        } else {
            if (messageObject.isAnimatedAnimatedEmoji()) {
                if (iAbs < 0 || iAbs > arrayList.size() - 1) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i5 = 0; i5 < arrayList.size(); i5++) {
                        TLRPC$Document tLRPC$Document2 = arrayList.get(i5);
                        if (tLRPC$Document2 != null) {
                            HashMap<Long, Boolean> map = this.preloaded;
                            Boolean bool = map != null ? map.get(Long.valueOf(tLRPC$Document2.id)) : null;
                            if (bool != null && bool.booleanValue()) {
                                arrayList2.add(Integer.valueOf(i5));
                            }
                        }
                    }
                    if (arrayList2.isEmpty()) {
                        iAbs = Math.abs(this.random.nextInt()) % arrayList.size();
                    } else {
                        iAbs = ((Integer) arrayList2.get(Math.abs(this.random.nextInt()) % arrayList2.size())).intValue();
                    }
                }
                tLRPC$Document = arrayList.get(iAbs);
            } else {
                if (iAbs < 0 || iAbs > arrayList.size() - 1) {
                    iAbs = Math.abs(this.random.nextInt()) % arrayList.size();
                }
                tLRPC$Document = arrayList.get(iAbs);
            }
            premiumStickerAnimation = null;
        }
        if (tLRPC$Document == null && premiumStickerAnimation == null) {
            return false;
        }
        DrawingObject drawingObject = new DrawingObject();
        drawingObject.isPremiumSticker = messageObject.isPremiumSticker();
        drawingObject.randomOffsetX = (imageWidth / 4.0f) * ((this.random.nextInt() % 101) / 100.0f);
        drawingObject.randomOffsetY = (imageHeight / 4.0f) * ((this.random.nextInt() % 101) / 100.0f);
        drawingObject.messageId = chatMessageCell.getMessageObject().getId();
        drawingObject.document = tLRPC$Document;
        drawingObject.isOut = chatMessageCell.getMessageObject().isOutOwner();
        drawingObject.imageReceiver.setAllowStartAnimation(true);
        drawingObject.imageReceiver.setAllowLottieVibration(z);
        if (tLRPC$Document != null) {
            int i6 = (int) ((imageWidth * 2.0f) / AndroidUtilities.density);
            Integer num = this.lastAnimationIndex.get(Long.valueOf(tLRPC$Document.id));
            int iIntValue = ((num == null ? 0 : num.intValue()) + 1) % 4;
            this.lastAnimationIndex.put(Long.valueOf(tLRPC$Document.id), Integer.valueOf(iIntValue));
            ImageLocation forDocument = ImageLocation.getForDocument(tLRPC$Document);
            drawingObject.imageReceiver.setUniqKeyPrefix(iIntValue + "_" + drawingObject.messageId + "_");
            drawingObject.imageReceiver.setImage(forDocument, i6 + "_" + i6 + "_pcache_compress", null, "tgs", this.set, 1);
            drawingObject.imageReceiver.setDelegate(new ImageReceiver.ImageReceiverDelegate(this) { // from class: org.rbmain.ui.EmojiAnimationsOverlay.3
                @Override // org.rbmain.messenger.ImageReceiver.ImageReceiverDelegate
                public void didSetImage(ImageReceiver imageReceiver, boolean z4, boolean z5, boolean z6) {
                }

                @Override // org.rbmain.messenger.ImageReceiver.ImageReceiverDelegate
                public void onAnimationReady(ImageReceiver imageReceiver) {
                    if (!z || !messageObject.isAnimatedAnimatedEmoji() || imageReceiver.getLottieAnimation() == null || imageReceiver.getLottieAnimation().hasVibrationPattern()) {
                        return;
                    }
                    chatMessageCell.performHapticFeedback(3, 1);
                }
            });
            if (drawingObject.imageReceiver.getLottieAnimation() != null) {
                drawingObject.imageReceiver.getLottieAnimation().setCurrentFrame(0, false, true);
            }
        } else {
            int i7 = (int) ((imageWidth * 1.5f) / AndroidUtilities.density);
            if (i4 > 0) {
                Integer num2 = this.lastAnimationIndex.get(Long.valueOf(messageObject.getDocument().id));
                int iIntValue2 = num2 == null ? 0 : num2.intValue();
                this.lastAnimationIndex.put(Long.valueOf(messageObject.getDocument().id), Integer.valueOf((iIntValue2 + 1) % 4));
                drawingObject.imageReceiver.setUniqKeyPrefix(iIntValue2 + "_" + drawingObject.messageId + "_");
            }
            drawingObject.document = messageObject.getDocument();
            drawingObject.imageReceiver.setImage(ImageLocation.getForDocument(premiumStickerAnimation, messageObject.getDocument()), i7 + "_" + i7, null, "tgs", this.set, 1);
        }
        drawingObject.imageReceiver.setLayerNum(ConnectionsManager.DEFAULT_DATACENTER_ID);
        drawingObject.imageReceiver.setAutoRepeat(0);
        if (drawingObject.imageReceiver.getLottieAnimation() != null) {
            if (drawingObject.isPremiumSticker) {
                drawingObject.imageReceiver.getLottieAnimation().setCurrentFrame(0, false, true);
            }
            drawingObject.imageReceiver.getLottieAnimation().start();
        }
        this.drawingObjects.add(drawingObject);
        drawingObject.imageReceiver.onAttachedToWindow();
        drawingObject.imageReceiver.setParentView(this.contentLayout);
        this.contentLayout.invalidate();
        if (z && !zIsPremiumSticker && UserConfig.getInstance(this.currentAccount).clientUserId != this.dialogId) {
            long j = this.lastTappedMsgId;
            if (j != 0 && j != chatMessageCell.getMessageObject().getId() && (runnable = this.sentInteractionsRunnable) != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
                this.sentInteractionsRunnable.run();
            }
            this.lastTappedMsgId = chatMessageCell.getMessageObject().getId();
            this.lastTappedEmoji = str2;
            if (this.lastTappedTime == 0) {
                this.lastTappedTime = System.currentTimeMillis();
                this.timeIntervals.clear();
                this.animationIndexes.clear();
                this.timeIntervals.add(0L);
                this.animationIndexes.add(Integer.valueOf(iAbs));
            } else {
                this.timeIntervals.add(Long.valueOf(System.currentTimeMillis() - this.lastTappedTime));
                this.animationIndexes.add(Integer.valueOf(iAbs));
            }
            Runnable runnable2 = this.sentInteractionsRunnable;
            if (runnable2 != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable2);
                this.sentInteractionsRunnable = null;
            }
            Runnable runnable3 = new Runnable() { // from class: org.rbmain.ui.EmojiAnimationsOverlay$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() throws JSONException {
                    this.f$0.lambda$showAnimationForCell$2();
                }
            };
            this.sentInteractionsRunnable = runnable3;
            AndroidUtilities.runOnUIThread(runnable3, 500L);
        }
        if (z2) {
            MessagesController.getInstance(this.currentAccount).sendTyping(this.dialogId, this.threadMsgId, 11, 0);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAnimationForCell$1(final MessageObject messageObject, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.EmojiAnimationsOverlay$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showAnimationForCell$0(tLObject, messageObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAnimationForCell$2() throws JSONException {
        sendCurrentTaps();
        this.sentInteractionsRunnable = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showStickerSetBulletin, reason: merged with bridge method [inline-methods] */
    public void lambda$showAnimationForCell$0(TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet, final MessageObject messageObject) {
        if (MessagesController.getInstance(this.currentAccount).premiumLocked || this.chatActivity.getParentActivity() == null) {
            return;
        }
        StickerSetBulletinLayout stickerSetBulletinLayout = new StickerSetBulletinLayout(this.contentLayout.getContext(), null, -1, messageObject.getDocument(), this.chatActivity.getResourceProvider());
        stickerSetBulletinLayout.titleTextView.setText(tLRPC$TL_messages_stickerSet.set.title);
        stickerSetBulletinLayout.subtitleTextView.setText(LocaleController.getString("PremiumStickerTooltip", R.string.PremiumStickerTooltip));
        Bulletin.UndoButton undoButton = new Bulletin.UndoButton(this.chatActivity.getParentActivity(), true, this.chatActivity.getResourceProvider());
        stickerSetBulletinLayout.setButton(undoButton);
        undoButton.setUndoAction(new Runnable() { // from class: org.rbmain.ui.EmojiAnimationsOverlay$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showStickerSetBulletin$3(messageObject);
            }
        });
        undoButton.setText(LocaleController.getString("ViewAction", R.string.ViewAction));
        Bulletin bulletinMake = Bulletin.make(this.chatActivity, stickerSetBulletinLayout, 2750);
        bulletinMake.hash = messageObject.getId();
        bulletinMake.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showStickerSetBulletin$3(MessageObject messageObject) {
        StickersAlert stickersAlert = new StickersAlert(this.chatActivity.getParentActivity(), this.chatActivity, messageObject.getInputStickerSet(), null, this.chatActivity.chatActivityEnterView);
        stickersAlert.setCalcMandatoryInsets(this.chatActivity.isKeyboardVisible());
        this.chatActivity.showDialog(stickersAlert);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0085 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.lang.CharSequence] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String unwrapEmoji(java.lang.String r8) {
        /*
            int r0 = r8.length()
            r1 = 0
            r2 = 0
        L6:
            if (r2 >= r0) goto L88
            int r3 = r0 + (-1)
            r4 = 2
            r5 = 1
            if (r2 >= r3) goto L60
            char r3 = r8.charAt(r2)
            r6 = 55356(0xd83c, float:7.757E-41)
            if (r3 != r6) goto L2b
            int r3 = r2 + 1
            char r6 = r8.charAt(r3)
            r7 = 57339(0xdffb, float:8.0349E-41)
            if (r6 < r7) goto L2b
            char r3 = r8.charAt(r3)
            r6 = 57343(0xdfff, float:8.0355E-41)
            if (r3 <= r6) goto L45
        L2b:
            char r3 = r8.charAt(r2)
            r6 = 8205(0x200d, float:1.1498E-41)
            if (r3 != r6) goto L60
            int r3 = r2 + 1
            char r6 = r8.charAt(r3)
            r7 = 9792(0x2640, float:1.3722E-41)
            if (r6 == r7) goto L45
            char r3 = r8.charAt(r3)
            r6 = 9794(0x2642, float:1.3724E-41)
            if (r3 != r6) goto L60
        L45:
            java.lang.CharSequence[] r3 = new java.lang.CharSequence[r4]
            java.lang.CharSequence r4 = r8.subSequence(r1, r2)
            r3[r1] = r4
            int r4 = r2 + 2
            int r6 = r8.length()
            java.lang.CharSequence r8 = r8.subSequence(r4, r6)
            r3[r5] = r8
            java.lang.CharSequence r8 = android.text.TextUtils.concat(r3)
            int r0 = r0 + (-2)
            goto L83
        L60:
            char r3 = r8.charAt(r2)
            r6 = 65039(0xfe0f, float:9.1139E-41)
            if (r3 != r6) goto L85
            java.lang.CharSequence[] r3 = new java.lang.CharSequence[r4]
            java.lang.CharSequence r4 = r8.subSequence(r1, r2)
            r3[r1] = r4
            int r4 = r2 + 1
            int r6 = r8.length()
            java.lang.CharSequence r8 = r8.subSequence(r4, r6)
            r3[r5] = r8
            java.lang.CharSequence r8 = android.text.TextUtils.concat(r3)
            int r0 = r0 + (-1)
        L83:
            int r2 = r2 + (-1)
        L85:
            int r2 = r2 + r5
            goto L6
        L88:
            java.lang.String r8 = r8.toString()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.EmojiAnimationsOverlay.unwrapEmoji(java.lang.String):java.lang.String");
    }

    private void sendCurrentTaps() throws JSONException {
        if (this.lastTappedMsgId == 0) {
            return;
        }
        TLRPC$TL_sendMessageEmojiInteraction tLRPC$TL_sendMessageEmojiInteraction = new TLRPC$TL_sendMessageEmojiInteraction();
        tLRPC$TL_sendMessageEmojiInteraction.msg_id = this.lastTappedMsgId;
        tLRPC$TL_sendMessageEmojiInteraction.emoticon = this.lastTappedEmoji;
        tLRPC$TL_sendMessageEmojiInteraction.interaction = new TLRPC$TL_dataJSON();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("v", 1);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.timeIntervals.size(); i++) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("i", this.animationIndexes.get(i).intValue() + 1);
                jSONObject2.put("t", this.timeIntervals.get(i).longValue() / 1000.0f);
                jSONArray.put(i, jSONObject2);
            }
            jSONObject.put("a", jSONArray);
            tLRPC$TL_sendMessageEmojiInteraction.interaction.data = jSONObject.toString();
            TLRPC$TL_messages_setTyping tLRPC$TL_messages_setTyping = new TLRPC$TL_messages_setTyping();
            long j = this.threadMsgId;
            if (j != 0) {
                tLRPC$TL_messages_setTyping.top_msg_id = j;
                tLRPC$TL_messages_setTyping.flags |= 1;
            }
            tLRPC$TL_messages_setTyping.action = tLRPC$TL_sendMessageEmojiInteraction;
            tLRPC$TL_messages_setTyping.peer = MessagesController.getInstance(this.currentAccount).getInputPeer((int) this.dialogId);
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_messages_setTyping, null);
            clearSendingInfo();
        } catch (JSONException e) {
            clearSendingInfo();
            FileLog.e(e);
        }
    }

    private void clearSendingInfo() {
        this.lastTappedMsgId = 0L;
        this.lastTappedEmoji = null;
        this.lastTappedTime = 0L;
        this.timeIntervals.clear();
        this.animationIndexes.clear();
    }

    public void onScrolled(int i) {
        for (int i2 = 0; i2 < this.drawingObjects.size(); i2++) {
            if (!this.drawingObjects.get(i2).viewFound) {
                this.drawingObjects.get(i2).lastY -= i;
            }
        }
    }

    public boolean isIdle() {
        return this.drawingObjects.isEmpty();
    }

    public boolean checkPosition(ChatMessageCell chatMessageCell, float f, int i) {
        float y = chatMessageCell.getY() + chatMessageCell.getPhotoImage().getCenterY();
        return y > f && y < ((float) i);
    }

    public void cancelAllAnimations() {
        for (int i = 0; i < this.drawingObjects.size(); i++) {
            this.drawingObjects.get(i).removing = true;
        }
    }

    private class DrawingObject {
        TLRPC$Document document;
        ImageReceiver imageReceiver;
        boolean isOut;
        public boolean isPremiumSticker;
        public float lastH;
        public float lastW;
        public float lastX;
        public float lastY;
        long messageId;
        public float randomOffsetX;
        public float randomOffsetY;
        float removeProgress;
        boolean removing;
        public boolean viewFound;
        boolean wasPlayed;

        private DrawingObject(EmojiAnimationsOverlay emojiAnimationsOverlay) {
            this.imageReceiver = new ImageReceiver();
        }
    }
}
