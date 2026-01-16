package ir.eitaa.ui;

import android.graphics.Canvas;
import android.view.View;
import android.widget.FrameLayout;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.EmojiData;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$TL_dataJSON;
import ir.eitaa.tgnet.TLRPC$TL_messages_setTyping;
import ir.eitaa.tgnet.TLRPC$TL_messages_stickerSet;
import ir.eitaa.tgnet.TLRPC$TL_sendMessageEmojiInteraction;
import ir.eitaa.tgnet.TLRPC$TL_stickerPack;
import ir.eitaa.ui.Cells.ChatMessageCell;
import ir.eitaa.ui.Components.Bulletin;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.StickerSetBulletinLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
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
    Runnable sentInteractionsRunnable;
    TLRPC$TL_messages_stickerSet set;
    int threadMsgId;
    private final int ANIMATION_JSON_VERSION = 1;
    private final String INTERACTIONS_STICKER_PACK = "EmojiAnimations";
    boolean inited = false;
    HashMap<String, ArrayList<TLRPC$Document>> emojiInteractionsStickersMap = new HashMap<>();
    HashMap<Long, Integer> lastAnimationIndex = new HashMap<>();
    Random random = new Random();
    int lastTappedMsgId = -1;
    long lastTappedTime = 0;
    ArrayList<Long> timeIntervals = new ArrayList<>();
    ArrayList<Integer> animationIndexes = new ArrayList<>();
    ArrayList<DrawingObject> drawingObjects = new ArrayList<>();

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

    public EmojiAnimationsOverlay(ChatActivity chatActivity, FrameLayout frameLayout, RecyclerListView chatListView, int currentAccount, long dialogId, int threadMsgId) {
        this.chatActivity = chatActivity;
        this.contentLayout = frameLayout;
        this.listView = chatListView;
        this.currentAccount = currentAccount;
        this.dialogId = dialogId;
        this.threadMsgId = threadMsgId;
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

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) throws JSONException {
        Integer printingStringType;
        if (id == NotificationCenter.diceStickersDidLoad) {
            if ("EmojiAnimations".equals((String) args[0])) {
                checkStickerPack();
                return;
            }
            return;
        }
        if (id == NotificationCenter.onEmojiInteractionsReceived) {
            long jLongValue = ((Long) args[0]).longValue();
            TLRPC$TL_sendMessageEmojiInteraction tLRPC$TL_sendMessageEmojiInteraction = (TLRPC$TL_sendMessageEmojiInteraction) args[1];
            if (jLongValue == this.dialogId && supportedEmoji.contains(tLRPC$TL_sendMessageEmojiInteraction.emoticon)) {
                final int i = tLRPC$TL_sendMessageEmojiInteraction.msg_id;
                if (tLRPC$TL_sendMessageEmojiInteraction.interaction.data != null) {
                    try {
                        JSONArray jSONArray = new JSONObject(tLRPC$TL_sendMessageEmojiInteraction.interaction.data).getJSONArray("a");
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i2);
                            final int iOptInt = jSONObject.optInt("i", 1) - 1;
                            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.EmojiAnimationsOverlay.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    EmojiAnimationsOverlay.this.findViewAndShowAnimation(i, iOptInt);
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
        if (id == NotificationCenter.updateInterfaces && (printingStringType = MessagesController.getInstance(this.currentAccount).getPrintingStringType(this.dialogId, this.threadMsgId)) != null && printingStringType.intValue() == 5) {
            cancelHintRunnable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void findViewAndShowAnimation(int messageId, int animation) {
        if (this.attached) {
            ChatMessageCell chatMessageCell = null;
            int i = 0;
            while (true) {
                if (i >= this.listView.getChildCount()) {
                    break;
                }
                View childAt = this.listView.getChildAt(i);
                if (childAt instanceof ChatMessageCell) {
                    ChatMessageCell chatMessageCell2 = (ChatMessageCell) childAt;
                    if (chatMessageCell2.getPhotoImage().hasNotThumb() && chatMessageCell2.getMessageObject().getStickerEmoji() != null && chatMessageCell2.getMessageObject().getId() == messageId) {
                        chatMessageCell = chatMessageCell2;
                        break;
                    }
                }
                i++;
            }
            if (chatMessageCell != null) {
                this.chatActivity.restartSticker(chatMessageCell);
                if (!EmojiData.hasEmojiSupportVibration(chatMessageCell.getMessageObject().getStickerEmoji())) {
                    chatMessageCell.performHapticFeedback(3);
                }
                showAnimationForCell(chatMessageCell, animation, false, true);
            }
        }
    }

    public void draw(Canvas canvas) {
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
                    break;
                }
                View childAt = this.listView.getChildAt(i2);
                if (childAt instanceof ChatMessageCell) {
                    ChatMessageCell chatMessageCell = (ChatMessageCell) childAt;
                    if (chatMessageCell.getMessageObject().getId() == drawingObject.messageId) {
                        drawingObject.viewFound = true;
                        float x = this.listView.getX() + childAt.getX() + chatMessageCell.getPhotoImage().getImageX();
                        float y = this.listView.getY() + childAt.getY() + chatMessageCell.getPhotoImage().getImageY();
                        if (drawingObject.isOut) {
                            fDp = ((-chatMessageCell.getPhotoImage().getImageWidth()) * 2.0f) + AndroidUtilities.dp(24.0f);
                        } else {
                            fDp = -AndroidUtilities.dp(24.0f);
                        }
                        float imageWidth = y - chatMessageCell.getPhotoImage().getImageWidth();
                        drawingObject.lastX = x + fDp;
                        drawingObject.lastY = imageWidth;
                        drawingObject.lastW = chatMessageCell.getPhotoImage().getImageWidth();
                    }
                }
                i2++;
            }
            ImageReceiver imageReceiver = drawingObject.imageReceiver;
            float f = drawingObject.lastX + drawingObject.randomOffsetX;
            float f2 = drawingObject.lastY + drawingObject.randomOffsetY;
            float f3 = drawingObject.lastW;
            imageReceiver.setImageCoords(f, f2, f3 * 3.0f, f3 * 3.0f);
            if (!drawingObject.isOut) {
                canvas.save();
                canvas.scale(-1.0f, 1.0f, drawingObject.imageReceiver.getCenterX(), drawingObject.imageReceiver.getCenterY());
                drawingObject.imageReceiver.draw(canvas);
                canvas.restore();
            } else {
                drawingObject.imageReceiver.draw(canvas);
            }
            if (drawingObject.wasPlayed && drawingObject.imageReceiver.getLottieAnimation() != null && drawingObject.imageReceiver.getLottieAnimation().getCurrentFrame() == drawingObject.imageReceiver.getLottieAnimation().getFramesCount() - 2) {
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
        this.contentLayout.invalidate();
    }

    public void onTapItem(ChatMessageCell view, ChatActivity chatActivity) {
        int i;
        if (chatActivity.currentUser == null || chatActivity.isSecretChat()) {
            return;
        }
        boolean zShowAnimationForCell = showAnimationForCell(view, -1, true, false);
        if (zShowAnimationForCell && !EmojiData.hasEmojiSupportVibration(view.getMessageObject().getStickerEmoji())) {
            view.performHapticFeedback(3);
        }
        Integer printingStringType = MessagesController.getInstance(this.currentAccount).getPrintingStringType(this.dialogId, this.threadMsgId);
        if ((printingStringType == null || printingStringType.intValue() != 5) && this.hintRunnable == null && zShowAnimationForCell) {
            if ((Bulletin.getVisibleBulletin() == null || !Bulletin.getVisibleBulletin().isShowing()) && (i = SharedConfig.emojiInteractionsHintCount) > 0) {
                SharedConfig.updateEmojiInteractionsHintCount(i - 1);
                StickerSetBulletinLayout stickerSetBulletinLayout = new StickerSetBulletinLayout(chatActivity.getParentActivity(), null, -1, MediaDataController.getInstance(this.currentAccount).getEmojiAnimatedSticker(view.getMessageObject().getStickerEmoji()), chatActivity.getResourceProvider());
                stickerSetBulletinLayout.subtitleTextView.setVisibility(8);
                stickerSetBulletinLayout.titleTextView.setText(AndroidUtilities.replaceTags(LocaleController.formatString("EmojiInteractionTapHint", R.string.EmojiInteractionTapHint, chatActivity.currentUser.first_name)));
                stickerSetBulletinLayout.titleTextView.setTypeface(null);
                stickerSetBulletinLayout.titleTextView.setMaxLines(3);
                stickerSetBulletinLayout.titleTextView.setSingleLine(false);
                final Bulletin bulletinMake = Bulletin.make(chatActivity, stickerSetBulletinLayout, 2750);
                Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.EmojiAnimationsOverlay.2
                    @Override // java.lang.Runnable
                    public void run() {
                        bulletinMake.show();
                        EmojiAnimationsOverlay.this.hintRunnable = null;
                    }
                };
                this.hintRunnable = runnable;
                AndroidUtilities.runOnUIThread(runnable, 1500L);
            }
        }
    }

    public void cancelHintRunnable() {
        Runnable runnable = this.hintRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
        }
        this.hintRunnable = null;
    }

    private boolean showAnimationForCell(ChatMessageCell view, int animation, boolean sendTap, boolean sendSeen) {
        String stickerEmoji;
        ArrayList<TLRPC$Document> arrayList;
        Runnable runnable;
        int iAbs = animation;
        if (this.drawingObjects.size() > 12 || !view.getPhotoImage().hasNotThumb() || (stickerEmoji = view.getMessageObject().getStickerEmoji()) == null) {
            return false;
        }
        float imageHeight = view.getPhotoImage().getImageHeight();
        float imageWidth = view.getPhotoImage().getImageWidth();
        if (imageHeight <= 0.0f || imageWidth <= 0.0f || !supportedEmoji.contains(stickerEmoji) || (arrayList = this.emojiInteractionsStickersMap.get(view.getMessageObject().getStickerEmoji())) == null || arrayList.isEmpty()) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.drawingObjects.size(); i2++) {
            if (this.drawingObjects.get(i2).messageId == view.getMessageObject().getId()) {
                i++;
                if (this.drawingObjects.get(i2).imageReceiver.getLottieAnimation() == null || this.drawingObjects.get(i2).imageReceiver.getLottieAnimation().isGeneratingCache()) {
                    return false;
                }
            }
        }
        if (i >= 4) {
            return false;
        }
        if (iAbs < 0 || iAbs > arrayList.size() - 1) {
            iAbs = Math.abs(this.random.nextInt()) % arrayList.size();
        }
        TLRPC$Document tLRPC$Document = arrayList.get(iAbs);
        DrawingObject drawingObject = new DrawingObject();
        drawingObject.randomOffsetX = (imageWidth / 4.0f) * ((this.random.nextInt() % R.styleable.AppCompatTheme_textAppearanceSearchResultSubtitle) / 100.0f);
        drawingObject.randomOffsetY = (imageHeight / 4.0f) * ((this.random.nextInt() % R.styleable.AppCompatTheme_textAppearanceSearchResultSubtitle) / 100.0f);
        drawingObject.messageId = view.getMessageObject().getId();
        drawingObject.document = tLRPC$Document;
        drawingObject.isOut = view.getMessageObject().isOutOwner();
        Integer num = this.lastAnimationIndex.get(Long.valueOf(tLRPC$Document.id));
        int iIntValue = num == null ? 0 : num.intValue();
        this.lastAnimationIndex.put(Long.valueOf(tLRPC$Document.id), Integer.valueOf((iIntValue + 1) % 4));
        ImageLocation forDocument = ImageLocation.getForDocument(tLRPC$Document);
        drawingObject.imageReceiver.setUniqKeyPrefix(iIntValue + "_" + drawingObject.messageId + "_");
        int i3 = (int) ((imageWidth * 2.0f) / AndroidUtilities.density);
        drawingObject.imageReceiver.setImage(forDocument, i3 + "_" + i3 + "_pcache", null, "tgs", this.set, 1);
        drawingObject.imageReceiver.setLayerNum(ConnectionsManager.DEFAULT_DATACENTER_ID);
        drawingObject.imageReceiver.setAllowStartAnimation(true);
        drawingObject.imageReceiver.setAutoRepeat(0);
        if (drawingObject.imageReceiver.getLottieAnimation() != null) {
            drawingObject.imageReceiver.getLottieAnimation().start();
        }
        this.drawingObjects.add(drawingObject);
        drawingObject.imageReceiver.onAttachedToWindow();
        drawingObject.imageReceiver.setParentView(this.contentLayout);
        this.contentLayout.invalidate();
        if (sendTap) {
            int i4 = this.lastTappedMsgId;
            if (i4 != 0 && i4 != view.getMessageObject().getId() && (runnable = this.sentInteractionsRunnable) != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
                this.sentInteractionsRunnable.run();
            }
            this.lastTappedMsgId = view.getMessageObject().getId();
            this.lastTappedEmoji = stickerEmoji;
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
            Runnable runnable3 = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$EmojiAnimationsOverlay$LfpgO55Y8t5kzq_jUie02sFbjsQ
                @Override // java.lang.Runnable
                public final void run() throws JSONException {
                    this.f$0.lambda$showAnimationForCell$0$EmojiAnimationsOverlay();
                }
            };
            this.sentInteractionsRunnable = runnable3;
            AndroidUtilities.runOnUIThread(runnable3, 500L);
        }
        if (sendSeen) {
            MessagesController.getInstance(this.currentAccount).sendTyping(this.dialogId, this.threadMsgId, 11, stickerEmoji, 0);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showAnimationForCell$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showAnimationForCell$0$EmojiAnimationsOverlay() throws JSONException {
        sendCurrentTaps();
        this.sentInteractionsRunnable = null;
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
            int i2 = this.threadMsgId;
            if (i2 != 0) {
                tLRPC$TL_messages_setTyping.top_msg_id = i2;
                tLRPC$TL_messages_setTyping.flags |= 1;
            }
            tLRPC$TL_messages_setTyping.action = tLRPC$TL_sendMessageEmojiInteraction;
            tLRPC$TL_messages_setTyping.peer = MessagesController.getInstance(this.currentAccount).getInputPeer(this.dialogId);
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_messages_setTyping, null);
            clearSendingInfo();
        } catch (JSONException e) {
            clearSendingInfo();
            FileLog.e(e);
        }
    }

    private void clearSendingInfo() {
        this.lastTappedMsgId = 0;
        this.lastTappedEmoji = null;
        this.lastTappedTime = 0L;
        this.timeIntervals.clear();
        this.animationIndexes.clear();
    }

    public void onScrolled(int dy) {
        for (int i = 0; i < this.drawingObjects.size(); i++) {
            if (!this.drawingObjects.get(i).viewFound) {
                this.drawingObjects.get(i).lastY -= dy;
            }
        }
    }

    private class DrawingObject {
        TLRPC$Document document;
        ImageReceiver imageReceiver;
        boolean isOut;
        public float lastW;
        public float lastX;
        public float lastY;
        int messageId;
        public float randomOffsetX;
        public float randomOffsetY;
        public boolean viewFound;
        boolean wasPlayed;

        private DrawingObject() {
            this.imageReceiver = new ImageReceiver();
        }
    }
}
