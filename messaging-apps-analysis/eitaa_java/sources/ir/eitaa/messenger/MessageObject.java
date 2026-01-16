package ir.eitaa.messenger;

import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Patterns;
import androidx.collection.LongSparseArray;
import ir.eitaa.PhoneFormat.PhoneFormat;
import ir.eitaa.messenger.Emoji;
import ir.eitaa.messenger.SvgHelper;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.SerializedData;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$BotInlineResult;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$DecryptedMessageAction;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$DocumentAttribute;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.tgnet.TLRPC$InputStickerSet;
import ir.eitaa.tgnet.TLRPC$KeyboardButton;
import ir.eitaa.tgnet.TLRPC$LiveStreamState;
import ir.eitaa.tgnet.TLRPC$Message;
import ir.eitaa.tgnet.TLRPC$MessageAction;
import ir.eitaa.tgnet.TLRPC$MessageEntity;
import ir.eitaa.tgnet.TLRPC$MessageFwdHeader;
import ir.eitaa.tgnet.TLRPC$MessageMedia;
import ir.eitaa.tgnet.TLRPC$MessageReplies;
import ir.eitaa.tgnet.TLRPC$Page;
import ir.eitaa.tgnet.TLRPC$PageBlock;
import ir.eitaa.tgnet.TLRPC$Peer;
import ir.eitaa.tgnet.TLRPC$Photo;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$PollResults;
import ir.eitaa.tgnet.TLRPC$TL_LiveStream;
import ir.eitaa.tgnet.TLRPC$TL_LiveStreamStateBroadcasting;
import ir.eitaa.tgnet.TLRPC$TL_channelAdminLogEvent;
import ir.eitaa.tgnet.TLRPC$TL_chatAdminRights;
import ir.eitaa.tgnet.TLRPC$TL_chatBannedRights;
import ir.eitaa.tgnet.TLRPC$TL_chatInviteExported;
import ir.eitaa.tgnet.TLRPC$TL_decryptedMessageActionScreenshotMessages;
import ir.eitaa.tgnet.TLRPC$TL_decryptedMessageActionSetMessageTTL;
import ir.eitaa.tgnet.TLRPC$TL_document;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeAnimated;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeAudio;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeHasStickers;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeImageSize;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeSticker;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeVideo;
import ir.eitaa.tgnet.TLRPC$TL_documentEmpty;
import ir.eitaa.tgnet.TLRPC$TL_documentEncrypted;
import ir.eitaa.tgnet.TLRPC$TL_fileLocationUnavailable;
import ir.eitaa.tgnet.TLRPC$TL_game;
import ir.eitaa.tgnet.TLRPC$TL_inputStickerSetEmpty;
import ir.eitaa.tgnet.TLRPC$TL_inputStickerSetShortName;
import ir.eitaa.tgnet.TLRPC$TL_keyboardButtonBuy;
import ir.eitaa.tgnet.TLRPC$TL_keyboardButtonRow;
import ir.eitaa.tgnet.TLRPC$TL_message;
import ir.eitaa.tgnet.TLRPC$TL_messageActionChatEditPhoto;
import ir.eitaa.tgnet.TLRPC$TL_messageActionContactSignUp;
import ir.eitaa.tgnet.TLRPC$TL_messageActionEmpty;
import ir.eitaa.tgnet.TLRPC$TL_messageActionHistoryClear;
import ir.eitaa.tgnet.TLRPC$TL_messageActionLoginUnknownLocation;
import ir.eitaa.tgnet.TLRPC$TL_messageActionPhoneCall;
import ir.eitaa.tgnet.TLRPC$TL_messageActionUserUpdatedPhoto;
import ir.eitaa.tgnet.TLRPC$TL_messageEmpty;
import ir.eitaa.tgnet.TLRPC$TL_messageEncryptedAction;
import ir.eitaa.tgnet.TLRPC$TL_messageEntityItalic;
import ir.eitaa.tgnet.TLRPC$TL_messageEntityMentionName;
import ir.eitaa.tgnet.TLRPC$TL_messageEntityTextUrl;
import ir.eitaa.tgnet.TLRPC$TL_messageForwarded_old2;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaContact;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaDice;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaDocument;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaEmpty;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaGame;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaGeo;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaGeoLive;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaInvoice;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaLiveStream;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaPhoto;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaPoll;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaUnsupported;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaVenue;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaWebPage;
import ir.eitaa.tgnet.TLRPC$TL_messageReactions;
import ir.eitaa.tgnet.TLRPC$TL_messageReplyHeader;
import ir.eitaa.tgnet.TLRPC$TL_messageService;
import ir.eitaa.tgnet.TLRPC$TL_message_secret;
import ir.eitaa.tgnet.TLRPC$TL_pageBlockCollage;
import ir.eitaa.tgnet.TLRPC$TL_pageBlockPhoto;
import ir.eitaa.tgnet.TLRPC$TL_pageBlockSlideshow;
import ir.eitaa.tgnet.TLRPC$TL_pageBlockVideo;
import ir.eitaa.tgnet.TLRPC$TL_peerChannel;
import ir.eitaa.tgnet.TLRPC$TL_peerChat;
import ir.eitaa.tgnet.TLRPC$TL_peerUser;
import ir.eitaa.tgnet.TLRPC$TL_photo;
import ir.eitaa.tgnet.TLRPC$TL_photoCachedSize;
import ir.eitaa.tgnet.TLRPC$TL_photoEmpty;
import ir.eitaa.tgnet.TLRPC$TL_photoSizeEmpty;
import ir.eitaa.tgnet.TLRPC$TL_photoStrippedSize;
import ir.eitaa.tgnet.TLRPC$TL_pollAnswer;
import ir.eitaa.tgnet.TLRPC$TL_pollAnswerVoters;
import ir.eitaa.tgnet.TLRPC$TL_reactionCount;
import ir.eitaa.tgnet.TLRPC$TL_replyInlineMarkup;
import ir.eitaa.tgnet.TLRPC$TL_webPage;
import ir.eitaa.tgnet.TLRPC$TL_webPageAttributeTheme;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$VideoSize;
import ir.eitaa.tgnet.TLRPC$WebDocument;
import ir.eitaa.tgnet.TLRPC$WebPage;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.ChatMessageCell;
import ir.eitaa.ui.Components.URLSpanNoUnderlineBold;
import java.io.BufferedReader;
import java.io.File;
import java.io.StringReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class MessageObject {
    private static final int LINES_PER_BLOCK = 10;
    public static final int MESSAGE_SEND_STATE_EDITING = 3;
    public static final int MESSAGE_SEND_STATE_SENDING = 1;
    public static final int MESSAGE_SEND_STATE_SEND_ERROR = 2;
    public static final int MESSAGE_SEND_STATE_SENT = 0;
    public static final int POSITION_FLAG_BOTTOM = 8;
    public static final int POSITION_FLAG_LEFT = 1;
    public static final int POSITION_FLAG_RIGHT = 2;
    public static final int POSITION_FLAG_TOP = 4;
    public static final int TYPE_ANIMATED_STICKER = 15;
    public static final int TYPE_LIVE_STREAM = 72;
    public static final int TYPE_PHOTO = 1;
    public static final int TYPE_POLL = 17;
    public static final int TYPE_ROUND_VIDEO = 5;
    public static final int TYPE_STICKER = 13;
    public static final int TYPE_VIDEO = 3;
    static final String[] excludeWords = {" vs. ", " vs ", " versus ", " ft. ", " ft ", " featuring ", " feat. ", " feat ", " presents ", " pres. ", " pres ", " and ", " & ", " . "};
    public static Pattern instagramUrlPattern;
    public static Pattern urlPattern;
    public static Pattern videoTimeUrlPattern;
    public boolean animateComments;
    public boolean attachPathExists;
    public int audioPlayerDuration;
    public float audioProgress;
    public int audioProgressMs;
    public int audioProgressSec;
    public StringBuilder botButtonsLayout;
    public String botStartParam;
    public float bufferedProgress;
    public Boolean cachedIsSupergroup;
    public boolean cancelEditing;
    public CharSequence caption;
    public ArrayList<TLRPC$TL_pollAnswer> checkedVotes;
    public int contentType;
    public int currentAccount;
    public TLRPC$TL_channelAdminLogEvent currentEvent;
    public String customReplyName;
    public String dateKey;
    public boolean deleted;
    public int drawFullWith;
    public CharSequence editingMessage;
    public ArrayList<TLRPC$MessageEntity> editingMessageEntities;
    public boolean editingMessageSearchWebPage;
    public TLRPC$Document emojiAnimatedSticker;
    public String emojiAnimatedStickerColor;
    private int emojiOnlyCount;
    public long eventId;
    public boolean forceDrawAvatarAndShare;
    public float forceSeekTo;
    public boolean forceUpdate;
    private float generatedWithDensity;
    private int generatedWithMinSize;
    public float gifState;
    public boolean hadAnimationNotReadyLoading;
    public boolean hasRtl;
    public ArrayList<String> highlightedWords;
    public boolean isDateObject;
    public boolean isNotAloneInGroup;
    public boolean isRestrictedMessage;
    private int isRoundVideoCached;
    public int lastLineWidth;
    private boolean layoutCreated;
    public int linesCount;
    public CharSequence linkDescription;
    public long liveLastCheckTime;
    public boolean liveVisibleOnScreen;
    public long loadedFileSize;
    public boolean loadingCancelled;
    public boolean localChannel;
    public boolean localEdit;
    public long localGroupId;
    public String localName;
    public long localSentGroupId;
    public boolean localSupergroup;
    public int localType;
    public String localUserName;
    public boolean mediaExists;
    public TLRPC$Message messageOwner;
    public CharSequence messageText;
    public String messageTrimmedToHighlight;
    public String monthKey;
    public int parentWidth;
    public SvgHelper.SvgDrawable pathThumb;
    public ArrayList<TLRPC$PhotoSize> photoThumbs;
    public ArrayList<TLRPC$PhotoSize> photoThumbs2;
    public TLObject photoThumbsObject;
    public TLObject photoThumbsObject2;
    public long pollLastCheckTime;
    public boolean pollVisibleOnScreen;
    public boolean preview;
    public String previousAttachPath;
    public TLRPC$MessageMedia previousMedia;
    public String previousMessage;
    public ArrayList<TLRPC$MessageEntity> previousMessageEntities;
    public MessageObject replyMessageObject;
    public boolean resendAsIs;
    public boolean savedToCloud;
    public boolean scheduled;
    public SendAnimationData sendAnimationData;
    public boolean shortCaption;
    public boolean shouldRemoveVideoEditedInfo;
    public byte[] sponsoredId;
    public int stableId;
    public BitmapDrawable strippedThumb;
    public int textHeight;
    public ArrayList<TextLayoutBlock> textLayoutBlocks;
    public int textWidth;
    public float textXOffset;
    public int type;
    public boolean useCustomPhoto;
    public CharSequence vCardData;
    public VideoEditedInfo videoEditedInfo;
    public boolean viewsReloaded;
    public int wantedBotKeyboardWidth;
    public boolean wasJustSent;
    public boolean wasUnread;

    public static class SendAnimationData {
        public float currentScale;
        public float currentX;
        public float currentY;
        public float height;
        public float timeAlpha;
        public float width;
        public float x;
        public float y;
    }

    public void checkForScam() {
    }

    public boolean hasReplies() {
        return false;
    }

    public int getEmojiOnlyCount() {
        return this.emojiOnlyCount;
    }

    public static class VCardData {
        private String company;
        private ArrayList<String> emails = new ArrayList<>();
        private ArrayList<String> phones = new ArrayList<>();

        public static CharSequence parse(String data) {
            byte[] bArrDecodeQuotedPrintable;
            try {
                BufferedReader bufferedReader = new BufferedReader(new StringReader(data));
                boolean z = false;
                VCardData vCardData = null;
                String strSubstring = null;
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        if (!line.startsWith("PHOTO")) {
                            if (line.indexOf(58) >= 0) {
                                if (line.startsWith("BEGIN:VCARD")) {
                                    vCardData = new VCardData();
                                } else if (line.startsWith("END:VCARD") && vCardData != null) {
                                    z = true;
                                }
                            }
                            if (strSubstring != null) {
                                line = strSubstring + line;
                                strSubstring = null;
                            }
                            if (line.contains("=QUOTED-PRINTABLE") && line.endsWith("=")) {
                                strSubstring = line.substring(0, line.length() - 1);
                            } else {
                                int iIndexOf = line.indexOf(":");
                                int i = 2;
                                String[] strArr = iIndexOf >= 0 ? new String[]{line.substring(0, iIndexOf), line.substring(iIndexOf + 1).trim()} : new String[]{line.trim()};
                                if (strArr.length >= 2 && vCardData != null) {
                                    if (strArr[0].startsWith("ORG")) {
                                        String[] strArrSplit = strArr[0].split(";");
                                        int length = strArrSplit.length;
                                        int i2 = 0;
                                        String str = null;
                                        String str2 = null;
                                        while (i2 < length) {
                                            String[] strArrSplit2 = strArrSplit[i2].split("=");
                                            if (strArrSplit2.length == i) {
                                                if (strArrSplit2[0].equals("CHARSET")) {
                                                    str2 = strArrSplit2[1];
                                                } else if (strArrSplit2[0].equals("ENCODING")) {
                                                    str = strArrSplit2[1];
                                                }
                                            }
                                            i2++;
                                            i = 2;
                                        }
                                        vCardData.company = strArr[1];
                                        if (str != null && str.equalsIgnoreCase("QUOTED-PRINTABLE") && (bArrDecodeQuotedPrintable = AndroidUtilities.decodeQuotedPrintable(AndroidUtilities.getStringBytes(vCardData.company))) != null && bArrDecodeQuotedPrintable.length != 0) {
                                            vCardData.company = new String(bArrDecodeQuotedPrintable, str2);
                                        }
                                        vCardData.company = vCardData.company.replace(';', ' ');
                                    } else if (strArr[0].startsWith("TEL")) {
                                        if (strArr[1].length() > 0) {
                                            vCardData.phones.add(strArr[1]);
                                        }
                                    } else if (strArr[0].startsWith("EMAIL")) {
                                        String str3 = strArr[1];
                                        if (str3.length() > 0) {
                                            vCardData.emails.add(str3);
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        try {
                            break;
                        } catch (Exception e) {
                            FileLog.e(e);
                        }
                    }
                }
                bufferedReader.close();
                if (!z) {
                    return null;
                }
                StringBuilder sb = new StringBuilder();
                for (int i3 = 0; i3 < vCardData.phones.size(); i3++) {
                    if (sb.length() > 0) {
                        sb.append('\n');
                    }
                    String str4 = vCardData.phones.get(i3);
                    if (str4.contains("#") || str4.contains("*")) {
                        sb.append(str4);
                    } else {
                        sb.append(PhoneFormat.getInstance().format(str4));
                    }
                }
                for (int i4 = 0; i4 < vCardData.emails.size(); i4++) {
                    if (sb.length() > 0) {
                        sb.append('\n');
                    }
                    sb.append(PhoneFormat.getInstance().format(vCardData.emails.get(i4)));
                }
                if (!TextUtils.isEmpty(vCardData.company)) {
                    if (sb.length() > 0) {
                        sb.append('\n');
                    }
                    sb.append(vCardData.company);
                }
                return sb;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public static class TextLayoutBlock {
        public int charactersEnd;
        public int charactersOffset;
        public byte directionFlags;
        public int height;
        public int heightByOffset;
        public StaticLayout textLayout;
        public float textYOffset;

        public boolean isRtl() {
            byte b = this.directionFlags;
            return (b & 1) != 0 && (b & 2) == 0;
        }
    }

    public static class GroupedMessagePosition {
        public float aspectRatio;
        public boolean edge;
        public int flags;
        public boolean last;
        public int leftSpanOffset;
        public byte maxX;
        public byte maxY;
        public byte minX;
        public byte minY;
        public float ph;
        public int pw;
        public float[] siblingHeights;
        public int spanSize;

        public void set(int minX, int maxX, int minY, int maxY, int w, float h, int flags) {
            this.minX = (byte) minX;
            this.maxX = (byte) maxX;
            this.minY = (byte) minY;
            this.maxY = (byte) maxY;
            this.pw = w;
            this.spanSize = w;
            this.ph = h;
            this.flags = (byte) flags;
        }
    }

    public static class GroupedMessages {
        public long groupId;
        public boolean hasCaption;
        public boolean hasSibling;
        public boolean isDocuments;
        public ArrayList<MessageObject> messages = new ArrayList<>();
        public ArrayList<GroupedMessagePosition> posArray = new ArrayList<>();
        public HashMap<MessageObject, GroupedMessagePosition> positions = new HashMap<>();
        private int maxSizeWidth = 800;
        public final TransitionParams transitionParams = new TransitionParams();

        private static class MessageGroupedLayoutAttempt {
            public float[] heights;
            public int[] lineCounts;

            public MessageGroupedLayoutAttempt(int i1, int i2, float f1, float f2) {
                this.lineCounts = new int[]{i1, i2};
                this.heights = new float[]{f1, f2};
            }

            public MessageGroupedLayoutAttempt(int i1, int i2, int i3, float f1, float f2, float f3) {
                this.lineCounts = new int[]{i1, i2, i3};
                this.heights = new float[]{f1, f2, f3};
            }

            public MessageGroupedLayoutAttempt(int i1, int i2, int i3, int i4, float f1, float f2, float f3, float f4) {
                this.lineCounts = new int[]{i1, i2, i3, i4};
                this.heights = new float[]{f1, f2, f3, f4};
            }
        }

        private float multiHeight(float[] array, int start, int end) {
            float f = 0.0f;
            while (start < end) {
                f += array[start];
                start++;
            }
            return this.maxSizeWidth / f;
        }

        /* JADX WARN: Removed duplicated region for block: B:239:0x0767 A[PHI: r4
          0x0767: PHI (r4v15 int) = (r4v14 int), (r4v18 int) binds: [B:235:0x075c, B:237:0x0760] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0075  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x007b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void calculate() {
            /*
                Method dump skipped, instructions count: 2081
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessageObject.GroupedMessages.calculate():void");
        }

        public MessageObject findPrimaryMessageObject() {
            if (!this.messages.isEmpty() && this.positions.isEmpty()) {
                calculate();
            }
            for (int i = 0; i < this.messages.size(); i++) {
                MessageObject messageObject = this.messages.get(i);
                GroupedMessagePosition groupedMessagePosition = this.positions.get(messageObject);
                if (groupedMessagePosition != null && (groupedMessagePosition.flags & 5) != 0) {
                    return messageObject;
                }
            }
            return null;
        }

        public static class TransitionParams {
            public boolean backgroundChangeBounds;
            public int bottom;
            public float captionEnterProgress = 1.0f;
            public ChatMessageCell cell;
            public boolean drawBackgroundForDeletedItems;
            public boolean drawCaptionLayout;
            public boolean isNewGroup;
            public int left;
            public float offsetBottom;
            public float offsetLeft;
            public float offsetRight;
            public float offsetTop;
            public boolean pinnedBotton;
            public boolean pinnedTop;
            public int right;
            public int top;

            public void reset() {
                this.captionEnterProgress = 1.0f;
                this.offsetBottom = 0.0f;
                this.offsetTop = 0.0f;
                this.offsetRight = 0.0f;
                this.offsetLeft = 0.0f;
                this.backgroundChangeBounds = false;
            }
        }
    }

    public MessageObject(int accountNum, TLRPC$Message message, String formattedMessage, String name, String userName, boolean localMessage, boolean isChannel, boolean supergroup, boolean edit) {
        this.type = 1000;
        this.forceSeekTo = -1.0f;
        this.drawFullWith = 0;
        this.savedToCloud = false;
        this.shortCaption = true;
        this.forceDrawAvatarAndShare = false;
        this.localType = localMessage ? 2 : 1;
        this.currentAccount = accountNum;
        this.localName = name;
        this.localUserName = userName;
        this.messageText = formattedMessage;
        this.messageOwner = message;
        this.localChannel = isChannel;
        this.localSupergroup = supergroup;
        this.localEdit = edit;
    }

    public MessageObject(int accountNum, TLRPC$Message message, AbstractMap<Long, TLRPC$User> users, boolean generateLayout, boolean checkMediaExists) {
        this(accountNum, message, users, (AbstractMap<Long, TLRPC$Chat>) null, generateLayout, checkMediaExists);
    }

    public MessageObject(int accountNum, TLRPC$Message message, LongSparseArray<TLRPC$User> users, boolean generateLayout, boolean checkMediaExists) {
        this(accountNum, message, users, (LongSparseArray<TLRPC$Chat>) null, generateLayout, checkMediaExists);
    }

    public MessageObject(int accountNum, TLRPC$Message message, boolean generateLayout, boolean checkMediaExists) {
        this(accountNum, message, null, null, null, null, null, generateLayout, checkMediaExists, 0L, 0);
    }

    public MessageObject(int accountNum, TLRPC$Message message, boolean generateLayout, boolean checkMediaExists, int drawFullWidth) {
        this(accountNum, message, null, null, null, null, null, generateLayout, checkMediaExists, 0L, drawFullWidth);
    }

    public MessageObject(int accountNum, TLRPC$Message message, MessageObject replyToMessage, boolean generateLayout, boolean checkMediaExists) {
        this(accountNum, message, replyToMessage, null, null, null, null, generateLayout, checkMediaExists, 0L, 0);
    }

    public MessageObject(int accountNum, TLRPC$Message message, AbstractMap<Long, TLRPC$User> users, AbstractMap<Long, TLRPC$Chat> chats, boolean generateLayout, boolean checkMediaExists) {
        this(accountNum, message, users, chats, generateLayout, checkMediaExists, 0L);
    }

    public MessageObject(int accountNum, TLRPC$Message message, LongSparseArray<TLRPC$User> users, LongSparseArray<TLRPC$Chat> chats, boolean generateLayout, boolean checkMediaExists) {
        this(accountNum, message, null, null, null, users, chats, generateLayout, checkMediaExists, 0L, 0);
    }

    public MessageObject(int accountNum, TLRPC$Message message, AbstractMap<Long, TLRPC$User> users, AbstractMap<Long, TLRPC$Chat> chats, boolean generateLayout, boolean checkMediaExists, long eid) {
        this(accountNum, message, null, users, chats, null, null, generateLayout, checkMediaExists, eid, 0);
    }

    public MessageObject(int accountNum, TLRPC$Message message, MessageObject replyToMessage, AbstractMap<Long, TLRPC$User> users, AbstractMap<Long, TLRPC$Chat> chats, LongSparseArray<TLRPC$User> sUsers, LongSparseArray<TLRPC$Chat> sChats, boolean generateLayout, boolean checkMediaExists, long eid, int drawFullWidth) {
        LongSparseArray<TLRPC$User> longSparseArray;
        AbstractMap<Long, TLRPC$User> abstractMap;
        LongSparseArray<TLRPC$User> longSparseArray2;
        AbstractMap<Long, TLRPC$Chat> abstractMap2;
        LongSparseArray<TLRPC$Chat> longSparseArray3;
        TLRPC$User user;
        TextPaint textPaint;
        int i;
        this.type = 1000;
        this.forceSeekTo = -1.0f;
        this.drawFullWith = 0;
        this.savedToCloud = false;
        this.shortCaption = true;
        this.forceDrawAvatarAndShare = false;
        Theme.createCommonMessageResources();
        this.currentAccount = accountNum;
        this.messageOwner = message;
        this.replyMessageObject = replyToMessage;
        this.eventId = eid;
        this.wasUnread = !message.out && message.unread;
        this.drawFullWith = drawFullWidth;
        TLRPC$Message tLRPC$Message = message.replyMessage;
        if (tLRPC$Message != null) {
            longSparseArray = sUsers;
            this.replyMessageObject = new MessageObject(accountNum, tLRPC$Message, null, users, chats, sUsers, sChats, false, checkMediaExists, eid, drawFullWidth);
        } else {
            longSparseArray = sUsers;
        }
        TLRPC$Peer tLRPC$Peer = message.from_id;
        if (tLRPC$Peer instanceof TLRPC$TL_peerUser) {
            abstractMap = users;
            longSparseArray2 = longSparseArray;
            user = getUser(abstractMap, longSparseArray2, tLRPC$Peer.user_id);
            abstractMap2 = chats;
            longSparseArray3 = sChats;
        } else {
            abstractMap = users;
            longSparseArray2 = longSparseArray;
            abstractMap2 = chats;
            longSparseArray3 = sChats;
            user = null;
        }
        updateMessageText(abstractMap, abstractMap2, longSparseArray2, longSparseArray3);
        shouldHavePayButton(message, true);
        setType();
        measureInlineBotButtons();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(this.messageOwner.date * 1000);
        int i2 = gregorianCalendar.get(6);
        int i3 = gregorianCalendar.get(1);
        int i4 = gregorianCalendar.get(2);
        this.dateKey = String.format("%d_%02d_%02d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2));
        this.monthKey = String.format("%d_%02d", Integer.valueOf(i3), Integer.valueOf(i4));
        createMessageSendInfo();
        generateCaption();
        if (generateLayout) {
            if (this.messageOwner.media instanceof TLRPC$TL_messageMediaGame) {
                textPaint = Theme.chat_msgGameTextPaint;
            } else if (this.drawFullWith == 1) {
                textPaint = Theme.explore_captionTextPaint;
            } else {
                textPaint = Theme.chat_msgTextPaint;
            }
            int[] iArr = allowsBigEmoji() ? new int[1] : null;
            this.messageText = Emoji.replaceEmoji(this.messageText, textPaint.getFontMetricsInt(), AndroidUtilities.dp(20.0f), false, iArr);
            checkEmojiOnly(iArr);
            this.emojiAnimatedSticker = null;
            if (this.emojiOnlyCount == 1) {
                TLRPC$MessageMedia tLRPC$MessageMedia = message.media;
                if (!(tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) && !(tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaInvoice) && message.entities.isEmpty()) {
                    CharSequence charSequenceSubSequence = this.messageText;
                    int iIndexOf = TextUtils.indexOf(charSequenceSubSequence, "🏻");
                    if (iIndexOf >= 0) {
                        this.emojiAnimatedStickerColor = "_c1";
                        charSequenceSubSequence = charSequenceSubSequence.subSequence(0, iIndexOf);
                    } else {
                        iIndexOf = TextUtils.indexOf(charSequenceSubSequence, "🏼");
                        if (iIndexOf >= 0) {
                            this.emojiAnimatedStickerColor = "_c2";
                            charSequenceSubSequence = charSequenceSubSequence.subSequence(0, iIndexOf);
                        } else {
                            iIndexOf = TextUtils.indexOf(charSequenceSubSequence, "🏽");
                            if (iIndexOf >= 0) {
                                this.emojiAnimatedStickerColor = "_c3";
                                charSequenceSubSequence = charSequenceSubSequence.subSequence(0, iIndexOf);
                            } else {
                                iIndexOf = TextUtils.indexOf(charSequenceSubSequence, "🏾");
                                if (iIndexOf >= 0) {
                                    this.emojiAnimatedStickerColor = "_c4";
                                    charSequenceSubSequence = charSequenceSubSequence.subSequence(0, iIndexOf);
                                } else {
                                    iIndexOf = TextUtils.indexOf(charSequenceSubSequence, "🏿");
                                    if (iIndexOf >= 0) {
                                        this.emojiAnimatedStickerColor = "_c5";
                                        charSequenceSubSequence = charSequenceSubSequence.subSequence(0, iIndexOf);
                                    } else {
                                        this.emojiAnimatedStickerColor = "";
                                    }
                                }
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(this.emojiAnimatedStickerColor) && (i = iIndexOf + 2) < this.messageText.length()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(charSequenceSubSequence.toString());
                        CharSequence charSequence = this.messageText;
                        sb.append(charSequence.subSequence(i, charSequence.length()).toString());
                        charSequenceSubSequence = sb.toString();
                    }
                    if (TextUtils.isEmpty(this.emojiAnimatedStickerColor) || EmojiData.emojiColoredMap.contains(charSequenceSubSequence.toString())) {
                        this.emojiAnimatedSticker = MediaDataController.getInstance(this.currentAccount).getEmojiAnimatedSticker(charSequenceSubSequence);
                    }
                }
            }
            if (this.emojiAnimatedSticker == null) {
                generateLayout(user);
            } else {
                this.type = 1000;
                if (isSticker()) {
                    this.type = 13;
                } else if (isAnimatedSticker()) {
                    this.type = 15;
                }
            }
            createPathThumb();
        }
        this.layoutCreated = generateLayout;
        generateThumbs(false);
        if (checkMediaExists) {
            checkMediaExistance();
        }
    }

    private void createPathThumb() {
        TLRPC$Document document = getDocument();
        if (document == null) {
            return;
        }
        this.pathThumb = DocumentObject.getSvgThumb(document, "chat_serviceBackground", 1.0f);
    }

    public void createStrippedThumb() {
        if (this.photoThumbs == null || SharedConfig.getDevicePerformanceClass() != 2) {
            return;
        }
        try {
            int size = this.photoThumbs.size();
            for (int i = 0; i < size; i++) {
                TLRPC$PhotoSize tLRPC$PhotoSize = this.photoThumbs.get(i);
                if (tLRPC$PhotoSize instanceof TLRPC$TL_photoStrippedSize) {
                    this.strippedThumb = new BitmapDrawable(ImageLoader.getStrippedPhotoBitmap(tLRPC$PhotoSize.bytes, "b"));
                    return;
                }
            }
        } catch (Throwable th) {
            FileLog.e(th);
        }
    }

    private void createDateArray(int accountNum, TLRPC$TL_channelAdminLogEvent event, ArrayList<MessageObject> messageObjects, HashMap<String, ArrayList<MessageObject>> messagesByDays, boolean addToEnd) {
        if (messagesByDays.get(this.dateKey) == null) {
            messagesByDays.put(this.dateKey, new ArrayList<>());
            TLRPC$TL_message tLRPC$TL_message = new TLRPC$TL_message();
            tLRPC$TL_message.message = LocaleController.formatDateChat(event.date);
            tLRPC$TL_message.id = 0;
            tLRPC$TL_message.date = event.date;
            MessageObject messageObject = new MessageObject(accountNum, tLRPC$TL_message, false, false);
            messageObject.type = 10;
            messageObject.contentType = 1;
            messageObject.isDateObject = true;
            if (addToEnd) {
                messageObjects.add(0, messageObject);
            } else {
                messageObjects.add(messageObject);
            }
        }
    }

    private void checkEmojiOnly(int[] emojiOnly) {
        TextPaint textPaint;
        int iDp;
        if (emojiOnly != null) {
            if (emojiOnly[0] < 1 || emojiOnly[0] > 3) {
                return;
            }
            int i = emojiOnly[0];
            if (i == 1) {
                textPaint = Theme.chat_msgTextPaintOneEmoji;
                iDp = AndroidUtilities.dp(32.0f);
                this.emojiOnlyCount = 1;
            } else if (i == 2) {
                textPaint = Theme.chat_msgTextPaintTwoEmoji;
                int iDp2 = AndroidUtilities.dp(28.0f);
                this.emojiOnlyCount = 2;
                iDp = iDp2;
            } else {
                textPaint = Theme.chat_msgTextPaintThreeEmoji;
                iDp = AndroidUtilities.dp(24.0f);
                this.emojiOnlyCount = 3;
            }
            CharSequence charSequence = this.messageText;
            Emoji.EmojiSpan[] emojiSpanArr = (Emoji.EmojiSpan[]) ((Spannable) charSequence).getSpans(0, charSequence.length(), Emoji.EmojiSpan.class);
            if (emojiSpanArr == null || emojiSpanArr.length <= 0) {
                return;
            }
            for (Emoji.EmojiSpan emojiSpan : emojiSpanArr) {
                emojiSpan.replaceFontMetrics(textPaint.getFontMetricsInt(), iDp);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:461:0x0ca7  */
    /* JADX WARN: Removed duplicated region for block: B:692:0x1316  */
    /* JADX WARN: Removed duplicated region for block: B:695:0x1364  */
    /* JADX WARN: Removed duplicated region for block: B:697:0x1367  */
    /* JADX WARN: Removed duplicated region for block: B:707:0x13d9  */
    /* JADX WARN: Removed duplicated region for block: B:710:0x13e0  */
    /* JADX WARN: Removed duplicated region for block: B:735:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MessageObject(int r28, ir.eitaa.tgnet.TLRPC$TL_channelAdminLogEvent r29, java.util.ArrayList<ir.eitaa.messenger.MessageObject> r30, java.util.HashMap<java.lang.String, java.util.ArrayList<ir.eitaa.messenger.MessageObject>> r31, ir.eitaa.tgnet.TLRPC$Chat r32, int[] r33, boolean r34) {
        /*
            Method dump skipped, instructions count: 5220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessageObject.<init>(int, ir.eitaa.tgnet.TLRPC$TL_channelAdminLogEvent, java.util.ArrayList, java.util.HashMap, ir.eitaa.tgnet.TLRPC$Chat, int[], boolean):void");
    }

    private String getUserName(TLObject object, ArrayList<TLRPC$MessageEntity> entities, int offset) {
        String str;
        String str2;
        long j;
        String str3;
        long j2;
        String name;
        if (object == null) {
            str3 = null;
            j2 = 0;
            str = "";
        } else {
            if (object instanceof TLRPC$User) {
                TLRPC$User tLRPC$User = (TLRPC$User) object;
                if (tLRPC$User.deleted) {
                    name = LocaleController.getString("HiddenName", R.string.HiddenName);
                } else {
                    name = ContactsController.formatName(tLRPC$User.first_name, tLRPC$User.last_name);
                }
                str = name;
                str2 = tLRPC$User.username;
                j = tLRPC$User.id;
            } else {
                TLRPC$Chat tLRPC$Chat = (TLRPC$Chat) object;
                str = tLRPC$Chat.title;
                str2 = tLRPC$Chat.username;
                j = -tLRPC$Chat.id;
            }
            str3 = str2;
            j2 = j;
        }
        if (offset >= 0) {
            TLRPC$TL_messageEntityMentionName tLRPC$TL_messageEntityMentionName = new TLRPC$TL_messageEntityMentionName();
            tLRPC$TL_messageEntityMentionName.user_id = j2;
            tLRPC$TL_messageEntityMentionName.offset = offset;
            tLRPC$TL_messageEntityMentionName.length = str.length();
            entities.add(tLRPC$TL_messageEntityMentionName);
        }
        if (TextUtils.isEmpty(str3)) {
            return str;
        }
        if (offset >= 0) {
            TLRPC$TL_messageEntityMentionName tLRPC$TL_messageEntityMentionName2 = new TLRPC$TL_messageEntityMentionName();
            tLRPC$TL_messageEntityMentionName2.user_id = j2;
            tLRPC$TL_messageEntityMentionName2.offset = offset + str.length() + 2;
            tLRPC$TL_messageEntityMentionName2.length = str3.length() + 1;
            entities.add(tLRPC$TL_messageEntityMentionName2);
        }
        return String.format("%1$s (@%2$s)", str, str3);
    }

    public void applyNewText() {
        TextPaint textPaint;
        if (TextUtils.isEmpty(this.messageOwner.message)) {
            return;
        }
        TLRPC$User user = isFromUser() ? MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(this.messageOwner.from_id.user_id)) : null;
        TLRPC$Message tLRPC$Message = this.messageOwner;
        this.messageText = tLRPC$Message.message;
        if (tLRPC$Message.media instanceof TLRPC$TL_messageMediaGame) {
            textPaint = Theme.chat_msgGameTextPaint;
        } else if (this.drawFullWith == 1) {
            textPaint = Theme.explore_captionTextPaint;
        } else {
            textPaint = Theme.chat_msgTextPaint;
        }
        int[] iArr = allowsBigEmoji() ? new int[1] : null;
        this.messageText = Emoji.replaceEmoji(this.messageText, textPaint.getFontMetricsInt(), AndroidUtilities.dp(20.0f), false, iArr);
        checkEmojiOnly(iArr);
        generateLayout(user);
    }

    private boolean allowsBigEmoji() {
        TLRPC$Peer tLRPC$Peer;
        if (!SharedConfig.allowBigEmoji) {
            return false;
        }
        TLRPC$Message tLRPC$Message = this.messageOwner;
        if (tLRPC$Message == null || (tLRPC$Peer = tLRPC$Message.peer_id) == null || (tLRPC$Peer.channel_id == 0 && tLRPC$Peer.chat_id == 0)) {
            return true;
        }
        MessagesController messagesController = MessagesController.getInstance(this.currentAccount);
        TLRPC$Peer tLRPC$Peer2 = this.messageOwner.peer_id;
        long j = tLRPC$Peer2.channel_id;
        if (j == 0) {
            j = tLRPC$Peer2.chat_id;
        }
        TLRPC$Chat chat = messagesController.getChat(Long.valueOf(j));
        return (chat != null && chat.gigagroup) || !ChatObject.isActionBanned(chat, 8) || ChatObject.hasAdminRights(chat);
    }

    public void generateGameMessageText(TLRPC$User fromUser) {
        TLRPC$MessageMedia tLRPC$MessageMedia;
        TLRPC$TL_game tLRPC$TL_game;
        if (fromUser == null && isFromUser()) {
            fromUser = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(this.messageOwner.from_id.user_id));
        }
        TLRPC$TL_game tLRPC$TL_game2 = null;
        MessageObject messageObject = this.replyMessageObject;
        if (messageObject != null && (tLRPC$MessageMedia = messageObject.messageOwner.media) != null && (tLRPC$TL_game = tLRPC$MessageMedia.game) != null) {
            tLRPC$TL_game2 = tLRPC$TL_game;
        }
        if (tLRPC$TL_game2 == null) {
            if (fromUser == null || fromUser.id != UserConfig.getInstance(this.currentAccount).getClientUserId()) {
                this.messageText = replaceWithLink(LocaleController.formatString("ActionUserScored", R.string.ActionUserScored, LocaleController.formatPluralString("Points", this.messageOwner.action.score)), "un1", fromUser);
                return;
            } else {
                this.messageText = LocaleController.formatString("ActionYouScored", R.string.ActionYouScored, LocaleController.formatPluralString("Points", this.messageOwner.action.score));
                return;
            }
        }
        if (fromUser == null || fromUser.id != UserConfig.getInstance(this.currentAccount).getClientUserId()) {
            this.messageText = replaceWithLink(LocaleController.formatString("ActionUserScoredInGame", R.string.ActionUserScoredInGame, LocaleController.formatPluralString("Points", this.messageOwner.action.score)), "un1", fromUser);
        } else {
            this.messageText = LocaleController.formatString("ActionYouScoredInGame", R.string.ActionYouScoredInGame, LocaleController.formatPluralString("Points", this.messageOwner.action.score));
        }
        this.messageText = replaceWithLink(this.messageText, "un2", tLRPC$TL_game2);
    }

    public boolean hasValidReplyMessageObject() {
        MessageObject messageObject = this.replyMessageObject;
        if (messageObject != null) {
            TLRPC$Message tLRPC$Message = messageObject.messageOwner;
            if (!(tLRPC$Message instanceof TLRPC$TL_messageEmpty) && !(tLRPC$Message.action instanceof TLRPC$TL_messageActionHistoryClear)) {
                return true;
            }
        }
        return false;
    }

    public void generatePaymentSentMessageText(TLRPC$User fromUser) {
        if (fromUser == null) {
            fromUser = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(getDialogId()));
        }
        String firstName = fromUser != null ? UserObject.getFirstName(fromUser) : "";
        MessageObject messageObject = this.replyMessageObject;
        if (messageObject != null && (messageObject.messageOwner.media instanceof TLRPC$TL_messageMediaInvoice)) {
            LocaleController localeController = LocaleController.getInstance();
            TLRPC$MessageAction tLRPC$MessageAction = this.messageOwner.action;
            this.messageText = LocaleController.formatString("PaymentSuccessfullyPaid", R.string.PaymentSuccessfullyPaid, localeController.formatCurrencyString(tLRPC$MessageAction.total_amount, tLRPC$MessageAction.currency), firstName, this.replyMessageObject.messageOwner.media.title);
        } else {
            LocaleController localeController2 = LocaleController.getInstance();
            TLRPC$MessageAction tLRPC$MessageAction2 = this.messageOwner.action;
            this.messageText = LocaleController.formatString("PaymentSuccessfullyPaidNoItem", R.string.PaymentSuccessfullyPaidNoItem, localeController2.formatCurrencyString(tLRPC$MessageAction2.total_amount, tLRPC$MessageAction2.currency), firstName);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [ir.eitaa.tgnet.TLRPC$Chat] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v12, types: [ir.eitaa.tgnet.TLRPC$Chat] */
    /* JADX WARN: Type inference failed for: r10v9, types: [ir.eitaa.tgnet.TLRPC$Chat] */
    public void generatePinMessageText(TLRPC$User fromUser, TLRPC$Chat chat) {
        if (fromUser == null && chat == 0) {
            if (isFromUser()) {
                fromUser = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(this.messageOwner.from_id.user_id));
            }
            if (fromUser == null) {
                TLRPC$Peer tLRPC$Peer = this.messageOwner.peer_id;
                if (tLRPC$Peer instanceof TLRPC$TL_peerChannel) {
                    chat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(this.messageOwner.peer_id.channel_id));
                } else if (tLRPC$Peer instanceof TLRPC$TL_peerChat) {
                    chat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(this.messageOwner.peer_id.chat_id));
                }
            }
        }
        MessageObject messageObject = this.replyMessageObject;
        if (messageObject != null) {
            TLRPC$Message tLRPC$Message = messageObject.messageOwner;
            if (!(tLRPC$Message instanceof TLRPC$TL_messageEmpty) && !(tLRPC$Message.action instanceof TLRPC$TL_messageActionHistoryClear)) {
                if (messageObject.isMusic()) {
                    String string = LocaleController.getString("ActionPinnedMusic", R.string.ActionPinnedMusic);
                    if (fromUser == null) {
                        fromUser = chat;
                    }
                    this.messageText = replaceWithLink(string, "un1", fromUser);
                    return;
                }
                if (this.replyMessageObject.isVideo()) {
                    String string2 = LocaleController.getString("ActionPinnedVideo", R.string.ActionPinnedVideo);
                    if (fromUser == null) {
                        fromUser = chat;
                    }
                    this.messageText = replaceWithLink(string2, "un1", fromUser);
                    return;
                }
                if (this.replyMessageObject.isGif()) {
                    String string3 = LocaleController.getString("ActionPinnedGif", R.string.ActionPinnedGif);
                    if (fromUser == null) {
                        fromUser = chat;
                    }
                    this.messageText = replaceWithLink(string3, "un1", fromUser);
                    return;
                }
                if (this.replyMessageObject.isVoice()) {
                    String string4 = LocaleController.getString("ActionPinnedVoice", R.string.ActionPinnedVoice);
                    if (fromUser == null) {
                        fromUser = chat;
                    }
                    this.messageText = replaceWithLink(string4, "un1", fromUser);
                    return;
                }
                if (this.replyMessageObject.isRoundVideo()) {
                    String string5 = LocaleController.getString("ActionPinnedRound", R.string.ActionPinnedRound);
                    if (fromUser == null) {
                        fromUser = chat;
                    }
                    this.messageText = replaceWithLink(string5, "un1", fromUser);
                    return;
                }
                if ((this.replyMessageObject.isSticker() || this.replyMessageObject.isAnimatedSticker()) && !this.replyMessageObject.isAnimatedEmoji()) {
                    String string6 = LocaleController.getString("ActionPinnedSticker", R.string.ActionPinnedSticker);
                    if (fromUser == null) {
                        fromUser = chat;
                    }
                    this.messageText = replaceWithLink(string6, "un1", fromUser);
                    return;
                }
                MessageObject messageObject2 = this.replyMessageObject;
                TLRPC$MessageMedia tLRPC$MessageMedia = messageObject2.messageOwner.media;
                if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaDocument) {
                    String string7 = LocaleController.getString("ActionPinnedFile", R.string.ActionPinnedFile);
                    if (fromUser == null) {
                        fromUser = chat;
                    }
                    this.messageText = replaceWithLink(string7, "un1", fromUser);
                    return;
                }
                if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaGeo) {
                    String string8 = LocaleController.getString("ActionPinnedGeo", R.string.ActionPinnedGeo);
                    if (fromUser == null) {
                        fromUser = chat;
                    }
                    this.messageText = replaceWithLink(string8, "un1", fromUser);
                    return;
                }
                if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaGeoLive) {
                    String string9 = LocaleController.getString("ActionPinnedGeoLive", R.string.ActionPinnedGeoLive);
                    if (fromUser == null) {
                        fromUser = chat;
                    }
                    this.messageText = replaceWithLink(string9, "un1", fromUser);
                    return;
                }
                if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaContact) {
                    String string10 = LocaleController.getString("ActionPinnedContact", R.string.ActionPinnedContact);
                    if (fromUser == null) {
                        fromUser = chat;
                    }
                    this.messageText = replaceWithLink(string10, "un1", fromUser);
                    return;
                }
                if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPoll) {
                    if (((TLRPC$TL_messageMediaPoll) tLRPC$MessageMedia).poll.quiz) {
                        String string11 = LocaleController.getString("ActionPinnedQuiz", R.string.ActionPinnedQuiz);
                        if (fromUser == null) {
                            fromUser = chat;
                        }
                        this.messageText = replaceWithLink(string11, "un1", fromUser);
                        return;
                    }
                    String string12 = LocaleController.getString("ActionPinnedPoll", R.string.ActionPinnedPoll);
                    if (fromUser == null) {
                        fromUser = chat;
                    }
                    this.messageText = replaceWithLink(string12, "un1", fromUser);
                    return;
                }
                if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) {
                    String string13 = LocaleController.getString("ActionPinnedPhoto", R.string.ActionPinnedPhoto);
                    if (fromUser == null) {
                        fromUser = chat;
                    }
                    this.messageText = replaceWithLink(string13, "un1", fromUser);
                    return;
                }
                if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaGame) {
                    String string14 = LocaleController.formatString("ActionPinnedGame", R.string.ActionPinnedGame, "🎮 " + this.replyMessageObject.messageOwner.media.game.title);
                    if (fromUser == null) {
                        fromUser = chat;
                    }
                    CharSequence charSequenceReplaceWithLink = replaceWithLink(string14, "un1", fromUser);
                    this.messageText = charSequenceReplaceWithLink;
                    this.messageText = Emoji.replaceEmoji(charSequenceReplaceWithLink, (this.drawFullWith == 1 ? Theme.explore_captionTextPaint : Theme.chat_msgTextPaint).getFontMetricsInt(), AndroidUtilities.dp(20.0f), false);
                    return;
                }
                CharSequence charSequence = messageObject2.messageText;
                if (charSequence != null && charSequence.length() > 0) {
                    CharSequence charSequence2 = this.replyMessageObject.messageText;
                    if (charSequence2.length() > 20) {
                        charSequence2 = ((Object) charSequence2.subSequence(0, 20)) + "...";
                    }
                    String str = String.format(LocaleController.getString("ActionPinnedText", R.string.ActionPinnedText), Emoji.replaceEmoji(charSequence2, (this.drawFullWith == 1 ? Theme.explore_captionTextPaint : Theme.chat_msgTextPaint).getFontMetricsInt(), AndroidUtilities.dp(20.0f), false));
                    if (fromUser == null) {
                        fromUser = chat;
                    }
                    this.messageText = replaceWithLink(str, "un1", fromUser);
                    return;
                }
                String string15 = LocaleController.getString("ActionPinnedNoText", R.string.ActionPinnedNoText);
                if (fromUser == null) {
                    fromUser = chat;
                }
                this.messageText = replaceWithLink(string15, "un1", fromUser);
                return;
            }
        }
        String string16 = LocaleController.getString("ActionPinnedNoText", R.string.ActionPinnedNoText);
        if (fromUser == null) {
            fromUser = chat;
        }
        this.messageText = replaceWithLink(string16, "un1", fromUser);
    }

    public static void updateReactions(TLRPC$Message message, TLRPC$TL_messageReactions reactions) {
        TLRPC$TL_messageReactions tLRPC$TL_messageReactions;
        if (message == null || reactions == null) {
            return;
        }
        if (reactions.min && (tLRPC$TL_messageReactions = message.reactions) != null) {
            int size = tLRPC$TL_messageReactions.results.size();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                TLRPC$TL_reactionCount tLRPC$TL_reactionCount = message.reactions.results.get(i2);
                if (tLRPC$TL_reactionCount.chosen) {
                    int size2 = reactions.results.size();
                    while (true) {
                        if (i >= size2) {
                            break;
                        }
                        TLRPC$TL_reactionCount tLRPC$TL_reactionCount2 = reactions.results.get(i);
                        if (tLRPC$TL_reactionCount.reaction.equals(tLRPC$TL_reactionCount2.reaction)) {
                            tLRPC$TL_reactionCount2.chosen = true;
                            break;
                        }
                        i++;
                    }
                } else {
                    i2++;
                }
            }
        }
        message.reactions = reactions;
        message.flags |= 1048576;
    }

    public boolean hasReactions() {
        TLRPC$TL_messageReactions tLRPC$TL_messageReactions = this.messageOwner.reactions;
        return (tLRPC$TL_messageReactions == null || tLRPC$TL_messageReactions.results.isEmpty()) ? false : true;
    }

    public static void updatePollResults(TLRPC$TL_messageMediaPoll media, TLRPC$PollResults results) {
        ArrayList arrayList;
        byte[] bArr;
        ArrayList<TLRPC$TL_pollAnswerVoters> arrayList2;
        if (media == null || results == null) {
            return;
        }
        if ((results.flags & 2) != 0) {
            if (!results.min || (arrayList2 = media.results.results) == null) {
                arrayList = null;
                bArr = null;
            } else {
                int size = arrayList2.size();
                arrayList = null;
                bArr = null;
                for (int i = 0; i < size; i++) {
                    TLRPC$TL_pollAnswerVoters tLRPC$TL_pollAnswerVoters = media.results.results.get(i);
                    if (tLRPC$TL_pollAnswerVoters.chosen) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(tLRPC$TL_pollAnswerVoters.option);
                    }
                    if (tLRPC$TL_pollAnswerVoters.correct) {
                        bArr = tLRPC$TL_pollAnswerVoters.option;
                    }
                }
            }
            TLRPC$PollResults tLRPC$PollResults = media.results;
            ArrayList<TLRPC$TL_pollAnswerVoters> arrayList3 = results.results;
            tLRPC$PollResults.results = arrayList3;
            if (arrayList != null || bArr != null) {
                int size2 = arrayList3.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    TLRPC$TL_pollAnswerVoters tLRPC$TL_pollAnswerVoters2 = media.results.results.get(i2);
                    if (arrayList != null) {
                        int size3 = arrayList.size();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= size3) {
                                break;
                            }
                            if (Arrays.equals(tLRPC$TL_pollAnswerVoters2.option, (byte[]) arrayList.get(i3))) {
                                tLRPC$TL_pollAnswerVoters2.chosen = true;
                                arrayList.remove(i3);
                                break;
                            }
                            i3++;
                        }
                        if (arrayList.isEmpty()) {
                            arrayList = null;
                        }
                    }
                    if (bArr != null && Arrays.equals(tLRPC$TL_pollAnswerVoters2.option, bArr)) {
                        tLRPC$TL_pollAnswerVoters2.correct = true;
                        bArr = null;
                    }
                    if (arrayList == null && bArr == null) {
                        break;
                    }
                }
            }
            media.results.flags |= 2;
        }
        if ((results.flags & 4) != 0) {
            TLRPC$PollResults tLRPC$PollResults2 = media.results;
            tLRPC$PollResults2.total_voters = results.total_voters;
            tLRPC$PollResults2.flags |= 4;
        }
        if ((results.flags & 8) != 0) {
            TLRPC$PollResults tLRPC$PollResults3 = media.results;
            tLRPC$PollResults3.recent_voters = results.recent_voters;
            tLRPC$PollResults3.flags |= 8;
        }
        if ((results.flags & 16) != 0) {
            TLRPC$PollResults tLRPC$PollResults4 = media.results;
            tLRPC$PollResults4.solution = results.solution;
            tLRPC$PollResults4.solution_entities = results.solution_entities;
            tLRPC$PollResults4.flags |= 16;
        }
    }

    public boolean isPollClosed() {
        if (this.type != 17) {
            return false;
        }
        return ((TLRPC$TL_messageMediaPoll) this.messageOwner.media).poll.closed;
    }

    public boolean isQuiz() {
        if (this.type != 17) {
            return false;
        }
        return ((TLRPC$TL_messageMediaPoll) this.messageOwner.media).poll.quiz;
    }

    public boolean isPublicPoll() {
        if (this.type != 17) {
            return false;
        }
        return ((TLRPC$TL_messageMediaPoll) this.messageOwner.media).poll.public_voters;
    }

    public boolean isPoll() {
        return this.type == 17;
    }

    public boolean canUnvote() {
        TLRPC$TL_messageMediaPoll tLRPC$TL_messageMediaPoll;
        TLRPC$PollResults tLRPC$PollResults;
        if (this.type == 17 && (tLRPC$PollResults = (tLRPC$TL_messageMediaPoll = (TLRPC$TL_messageMediaPoll) this.messageOwner.media).results) != null && !tLRPC$PollResults.results.isEmpty() && !tLRPC$TL_messageMediaPoll.poll.quiz) {
            int size = tLRPC$TL_messageMediaPoll.results.results.size();
            for (int i = 0; i < size; i++) {
                if (tLRPC$TL_messageMediaPoll.results.results.get(i).chosen) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isVoted() {
        TLRPC$TL_messageMediaPoll tLRPC$TL_messageMediaPoll;
        TLRPC$PollResults tLRPC$PollResults;
        if (this.type == 17 && (tLRPC$PollResults = (tLRPC$TL_messageMediaPoll = (TLRPC$TL_messageMediaPoll) this.messageOwner.media).results) != null && !tLRPC$PollResults.results.isEmpty()) {
            int size = tLRPC$TL_messageMediaPoll.results.results.size();
            for (int i = 0; i < size; i++) {
                if (tLRPC$TL_messageMediaPoll.results.results.get(i).chosen) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSponsored() {
        return this.sponsoredId != null;
    }

    public long getPollId() {
        if (this.type != 17) {
            return 0L;
        }
        return ((TLRPC$TL_messageMediaPoll) this.messageOwner.media).poll.id;
    }

    private TLRPC$Photo getPhotoWithId(TLRPC$WebPage webPage, long id) {
        if (webPage != null && webPage.cached_page != null) {
            TLRPC$Photo tLRPC$Photo = webPage.photo;
            if (tLRPC$Photo != null && tLRPC$Photo.id == id) {
                return tLRPC$Photo;
            }
            for (int i = 0; i < webPage.cached_page.photos.size(); i++) {
                TLRPC$Photo tLRPC$Photo2 = webPage.cached_page.photos.get(i);
                if (tLRPC$Photo2.id == id) {
                    return tLRPC$Photo2;
                }
            }
        }
        return null;
    }

    private TLRPC$Document getDocumentWithId(TLRPC$WebPage webPage, long id) {
        if (webPage != null && webPage.cached_page != null) {
            TLRPC$Document tLRPC$Document = webPage.document;
            if (tLRPC$Document != null && tLRPC$Document.id == id) {
                return tLRPC$Document;
            }
            for (int i = 0; i < webPage.cached_page.documents.size(); i++) {
                TLRPC$Document tLRPC$Document2 = webPage.cached_page.documents.get(i);
                if (tLRPC$Document2.id == id) {
                    return tLRPC$Document2;
                }
            }
        }
        return null;
    }

    public boolean isSupergroup() {
        if (this.localSupergroup) {
            return true;
        }
        Boolean bool = this.cachedIsSupergroup;
        if (bool != null) {
            return bool.booleanValue();
        }
        TLRPC$Peer tLRPC$Peer = this.messageOwner.peer_id;
        if (tLRPC$Peer != null) {
            long j = tLRPC$Peer.channel_id;
            if (j != 0) {
                TLRPC$Chat chat = getChat(null, null, j);
                if (chat == null) {
                    return false;
                }
                Boolean boolValueOf = Boolean.valueOf(chat.megagroup);
                this.cachedIsSupergroup = boolValueOf;
                return boolValueOf.booleanValue();
            }
        }
        this.cachedIsSupergroup = Boolean.FALSE;
        return false;
    }

    private MessageObject getMessageObjectForBlock(TLRPC$WebPage webPage, TLRPC$PageBlock pageBlock) {
        TLRPC$TL_message tLRPC$TL_message;
        if (pageBlock instanceof TLRPC$TL_pageBlockPhoto) {
            TLRPC$Photo photoWithId = getPhotoWithId(webPage, ((TLRPC$TL_pageBlockPhoto) pageBlock).photo_id);
            if (photoWithId == webPage.photo) {
                return this;
            }
            tLRPC$TL_message = new TLRPC$TL_message();
            TLRPC$TL_messageMediaPhoto tLRPC$TL_messageMediaPhoto = new TLRPC$TL_messageMediaPhoto();
            tLRPC$TL_message.media = tLRPC$TL_messageMediaPhoto;
            tLRPC$TL_messageMediaPhoto.photo = photoWithId;
        } else if (pageBlock instanceof TLRPC$TL_pageBlockVideo) {
            TLRPC$TL_pageBlockVideo tLRPC$TL_pageBlockVideo = (TLRPC$TL_pageBlockVideo) pageBlock;
            if (getDocumentWithId(webPage, tLRPC$TL_pageBlockVideo.video_id) == webPage.document) {
                return this;
            }
            TLRPC$TL_message tLRPC$TL_message2 = new TLRPC$TL_message();
            TLRPC$TL_messageMediaDocument tLRPC$TL_messageMediaDocument = new TLRPC$TL_messageMediaDocument();
            tLRPC$TL_message2.media = tLRPC$TL_messageMediaDocument;
            tLRPC$TL_messageMediaDocument.document = getDocumentWithId(webPage, tLRPC$TL_pageBlockVideo.video_id);
            tLRPC$TL_message = tLRPC$TL_message2;
        } else {
            tLRPC$TL_message = null;
        }
        tLRPC$TL_message.message = "";
        tLRPC$TL_message.realId = getId();
        tLRPC$TL_message.id = Utilities.random.nextInt();
        TLRPC$Message tLRPC$Message = this.messageOwner;
        tLRPC$TL_message.date = tLRPC$Message.date;
        tLRPC$TL_message.peer_id = tLRPC$Message.peer_id;
        tLRPC$TL_message.out = tLRPC$Message.out;
        tLRPC$TL_message.from_id = tLRPC$Message.from_id;
        return new MessageObject(this.currentAccount, tLRPC$TL_message, false, true);
    }

    public ArrayList<MessageObject> getWebPagePhotos(ArrayList<MessageObject> array, ArrayList<TLRPC$PageBlock> blocksToSearch) {
        TLRPC$WebPage tLRPC$WebPage;
        TLRPC$Page tLRPC$Page;
        if (array == null) {
            array = new ArrayList<>();
        }
        TLRPC$MessageMedia tLRPC$MessageMedia = this.messageOwner.media;
        if (tLRPC$MessageMedia == null || (tLRPC$WebPage = tLRPC$MessageMedia.webpage) == null || (tLRPC$Page = tLRPC$WebPage.cached_page) == null) {
            return array;
        }
        if (blocksToSearch == null) {
            blocksToSearch = tLRPC$Page.blocks;
        }
        for (int i = 0; i < blocksToSearch.size(); i++) {
            TLRPC$PageBlock tLRPC$PageBlock = blocksToSearch.get(i);
            if (tLRPC$PageBlock instanceof TLRPC$TL_pageBlockSlideshow) {
                TLRPC$TL_pageBlockSlideshow tLRPC$TL_pageBlockSlideshow = (TLRPC$TL_pageBlockSlideshow) tLRPC$PageBlock;
                for (int i2 = 0; i2 < tLRPC$TL_pageBlockSlideshow.items.size(); i2++) {
                    array.add(getMessageObjectForBlock(tLRPC$WebPage, tLRPC$TL_pageBlockSlideshow.items.get(i2)));
                }
            } else if (tLRPC$PageBlock instanceof TLRPC$TL_pageBlockCollage) {
                TLRPC$TL_pageBlockCollage tLRPC$TL_pageBlockCollage = (TLRPC$TL_pageBlockCollage) tLRPC$PageBlock;
                for (int i3 = 0; i3 < tLRPC$TL_pageBlockCollage.items.size(); i3++) {
                    array.add(getMessageObjectForBlock(tLRPC$WebPage, tLRPC$TL_pageBlockCollage.items.get(i3)));
                }
            }
        }
        return array;
    }

    public void createMessageSendInfo() {
        HashMap<String, String> map;
        String str;
        TLRPC$Message tLRPC$Message = this.messageOwner;
        if (tLRPC$Message.message != null) {
            if ((tLRPC$Message.id < 0 || isEditing()) && (map = this.messageOwner.params) != null) {
                String str2 = map.get("ve");
                if (str2 != null && (isVideo() || isNewGif() || isRoundVideo())) {
                    VideoEditedInfo videoEditedInfo = new VideoEditedInfo();
                    this.videoEditedInfo = videoEditedInfo;
                    if (!videoEditedInfo.parseString(str2)) {
                        this.videoEditedInfo = null;
                    } else {
                        this.videoEditedInfo.roundVideo = isRoundVideo();
                    }
                }
                TLRPC$Message tLRPC$Message2 = this.messageOwner;
                if (tLRPC$Message2.send_state != 3 || (str = tLRPC$Message2.params.get("prevMedia")) == null) {
                    return;
                }
                SerializedData serializedData = new SerializedData(Base64.decode(str, 0));
                this.previousMedia = TLRPC$MessageMedia.TLdeserialize(serializedData, serializedData.readInt32(false), false);
                this.previousMessage = serializedData.readString(false);
                this.previousAttachPath = serializedData.readString(false);
                int int32 = serializedData.readInt32(false);
                this.previousMessageEntities = new ArrayList<>(int32);
                for (int i = 0; i < int32; i++) {
                    this.previousMessageEntities.add(TLRPC$MessageEntity.TLdeserialize(serializedData, serializedData.readInt32(false), false));
                }
                serializedData.cleanup();
            }
        }
    }

    public void measureInlineBotButtons() {
        int iMax;
        CharSequence charSequenceReplaceEmoji;
        TLRPC$TL_messageReactions tLRPC$TL_messageReactions;
        if (this.isRestrictedMessage) {
            return;
        }
        this.wantedBotKeyboardWidth = 0;
        TLRPC$Message tLRPC$Message = this.messageOwner;
        if ((tLRPC$Message.reply_markup instanceof TLRPC$TL_replyInlineMarkup) || ((tLRPC$TL_messageReactions = tLRPC$Message.reactions) != null && !tLRPC$TL_messageReactions.results.isEmpty())) {
            Theme.createCommonMessageResources();
            StringBuilder sb = this.botButtonsLayout;
            if (sb == null) {
                this.botButtonsLayout = new StringBuilder();
            } else {
                sb.setLength(0);
            }
        }
        TLRPC$Message tLRPC$Message2 = this.messageOwner;
        if (tLRPC$Message2.reply_markup instanceof TLRPC$TL_replyInlineMarkup) {
            for (int i = 0; i < this.messageOwner.reply_markup.rows.size(); i++) {
                TLRPC$TL_keyboardButtonRow tLRPC$TL_keyboardButtonRow = this.messageOwner.reply_markup.rows.get(i);
                int size = tLRPC$TL_keyboardButtonRow.buttons.size();
                int iMax2 = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    TLRPC$KeyboardButton tLRPC$KeyboardButton = tLRPC$TL_keyboardButtonRow.buttons.get(i2);
                    StringBuilder sb2 = this.botButtonsLayout;
                    sb2.append(i);
                    sb2.append(i2);
                    boolean z = tLRPC$KeyboardButton instanceof TLRPC$TL_keyboardButtonBuy;
                    TLRPC$MessageMedia tLRPC$MessageMedia = this.messageOwner.media;
                    if ((z & (tLRPC$MessageMedia != null)) && (tLRPC$MessageMedia.flags & 4) != 0) {
                        charSequenceReplaceEmoji = LocaleController.getString("PaymentReceipt", R.string.PaymentReceipt);
                    } else {
                        charSequenceReplaceEmoji = Emoji.replaceEmoji(tLRPC$KeyboardButton.text, Theme.chat_msgBotButtonPaint.getFontMetricsInt(), AndroidUtilities.dp(15.0f), false);
                    }
                    StaticLayout staticLayout = new StaticLayout(charSequenceReplaceEmoji, Theme.chat_msgBotButtonPaint, AndroidUtilities.dp(2000.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                    if (staticLayout.getLineCount() > 0) {
                        float lineWidth = staticLayout.getLineWidth(0);
                        float lineLeft = staticLayout.getLineLeft(0);
                        if (lineLeft < lineWidth) {
                            lineWidth -= lineLeft;
                        }
                        iMax2 = Math.max(iMax2, ((int) Math.ceil(lineWidth)) + AndroidUtilities.dp(4.0f));
                    }
                }
                this.wantedBotKeyboardWidth = Math.max(this.wantedBotKeyboardWidth, ((iMax2 + AndroidUtilities.dp(12.0f)) * size) + (AndroidUtilities.dp(5.0f) * (size - 1)));
            }
            return;
        }
        TLRPC$TL_messageReactions tLRPC$TL_messageReactions2 = tLRPC$Message2.reactions;
        if (tLRPC$TL_messageReactions2 != null) {
            int size2 = tLRPC$TL_messageReactions2.results.size();
            for (int i3 = 0; i3 < size2; i3++) {
                TLRPC$TL_reactionCount tLRPC$TL_reactionCount = this.messageOwner.reactions.results.get(i3);
                StringBuilder sb3 = this.botButtonsLayout;
                sb3.append(0);
                sb3.append(i3);
                StaticLayout staticLayout2 = new StaticLayout(Emoji.replaceEmoji(String.format("%d %s", Integer.valueOf(tLRPC$TL_reactionCount.count), tLRPC$TL_reactionCount.reaction), Theme.chat_msgBotButtonPaint.getFontMetricsInt(), AndroidUtilities.dp(15.0f), false), Theme.chat_msgBotButtonPaint, AndroidUtilities.dp(2000.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                if (staticLayout2.getLineCount() > 0) {
                    float lineWidth2 = staticLayout2.getLineWidth(0);
                    float lineLeft2 = staticLayout2.getLineLeft(0);
                    if (lineLeft2 < lineWidth2) {
                        lineWidth2 -= lineLeft2;
                    }
                    iMax = Math.max(0, ((int) Math.ceil(lineWidth2)) + AndroidUtilities.dp(4.0f));
                } else {
                    iMax = 0;
                }
                this.wantedBotKeyboardWidth = Math.max(this.wantedBotKeyboardWidth, ((iMax + AndroidUtilities.dp(12.0f)) * size2) + (AndroidUtilities.dp(5.0f) * (size2 - 1)));
            }
        }
    }

    public boolean isVideoAvatar() {
        TLRPC$Photo tLRPC$Photo;
        TLRPC$MessageAction tLRPC$MessageAction = this.messageOwner.action;
        return (tLRPC$MessageAction == null || (tLRPC$Photo = tLRPC$MessageAction.photo) == null || tLRPC$Photo.video_sizes.isEmpty()) ? false : true;
    }

    public boolean isFcmMessage() {
        return this.localType != 0;
    }

    private TLRPC$User getUser(AbstractMap<Long, TLRPC$User> users, LongSparseArray<TLRPC$User> sUsers, long userId) {
        TLRPC$User tLRPC$User;
        if (users != null) {
            tLRPC$User = users.get(Long.valueOf(userId));
        } else {
            tLRPC$User = sUsers != null ? sUsers.get(userId) : null;
        }
        return tLRPC$User == null ? MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(userId)) : tLRPC$User;
    }

    private TLRPC$Chat getChat(AbstractMap<Long, TLRPC$Chat> chats, LongSparseArray<TLRPC$Chat> sChats, long chatId) {
        TLRPC$Chat tLRPC$Chat;
        if (chats != null) {
            tLRPC$Chat = chats.get(Long.valueOf(chatId));
        } else {
            tLRPC$Chat = sChats != null ? sChats.get(chatId) : null;
        }
        return tLRPC$Chat == null ? MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(chatId)) : tLRPC$Chat;
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0523  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x05af  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x061c  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x06e3  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0918  */
    /* JADX WARN: Removed duplicated region for block: B:480:0x0cb5  */
    /* JADX WARN: Removed duplicated region for block: B:584:0x0eed  */
    /* JADX WARN: Removed duplicated region for block: B:604:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void updateMessageText(java.util.AbstractMap<java.lang.Long, ir.eitaa.tgnet.TLRPC$User> r21, java.util.AbstractMap<java.lang.Long, ir.eitaa.tgnet.TLRPC$Chat> r22, androidx.collection.LongSparseArray<ir.eitaa.tgnet.TLRPC$User> r23, androidx.collection.LongSparseArray<ir.eitaa.tgnet.TLRPC$Chat> r24) {
        /*
            Method dump skipped, instructions count: 3824
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessageObject.updateMessageText(java.util.AbstractMap, java.util.AbstractMap, androidx.collection.LongSparseArray, androidx.collection.LongSparseArray):void");
    }

    public void setType() {
        int i = this.type;
        this.type = 1000;
        this.isRoundVideoCached = 0;
        TLRPC$Message tLRPC$Message = this.messageOwner;
        if ((tLRPC$Message instanceof TLRPC$TL_message) || (tLRPC$Message instanceof TLRPC$TL_messageForwarded_old2)) {
            if (this.isRestrictedMessage) {
                this.type = 0;
            } else if (this.emojiAnimatedSticker != null) {
                if (isSticker()) {
                    this.type = 13;
                } else {
                    this.type = 15;
                }
            } else if (isMediaEmpty()) {
                this.type = 0;
                if (TextUtils.isEmpty(this.messageText) && this.eventId == 0) {
                    this.messageText = "Empty message";
                }
            } else {
                TLRPC$MessageMedia tLRPC$MessageMedia = this.messageOwner.media;
                if (tLRPC$MessageMedia.ttl_seconds != 0 && ((tLRPC$MessageMedia.photo instanceof TLRPC$TL_photoEmpty) || (getDocument() instanceof TLRPC$TL_documentEmpty))) {
                    this.contentType = 1;
                    this.type = 10;
                } else {
                    TLRPC$MessageMedia tLRPC$MessageMedia2 = this.messageOwner.media;
                    if (tLRPC$MessageMedia2 instanceof TLRPC$TL_messageMediaDice) {
                        this.type = 15;
                        if (tLRPC$MessageMedia2.document == null) {
                            tLRPC$MessageMedia2.document = new TLRPC$TL_document();
                            TLRPC$Document tLRPC$Document = this.messageOwner.media.document;
                            tLRPC$Document.file_reference = new byte[0];
                            tLRPC$Document.mime_type = "application/x-tgsdice";
                            tLRPC$Document.dc_id = Integer.MIN_VALUE;
                            tLRPC$Document.id = -2147483648L;
                            TLRPC$TL_documentAttributeImageSize tLRPC$TL_documentAttributeImageSize = new TLRPC$TL_documentAttributeImageSize();
                            tLRPC$TL_documentAttributeImageSize.w = Factory.DEVICE_USE_ANDROID_CAMCORDER;
                            tLRPC$TL_documentAttributeImageSize.h = Factory.DEVICE_USE_ANDROID_CAMCORDER;
                            this.messageOwner.media.document.attributes.add(tLRPC$TL_documentAttributeImageSize);
                        }
                    } else if (tLRPC$MessageMedia2 instanceof TLRPC$TL_messageMediaPhoto) {
                        this.type = 1;
                    } else if ((tLRPC$MessageMedia2 instanceof TLRPC$TL_messageMediaGeo) || (tLRPC$MessageMedia2 instanceof TLRPC$TL_messageMediaVenue) || (tLRPC$MessageMedia2 instanceof TLRPC$TL_messageMediaGeoLive)) {
                        this.type = 4;
                    } else if (isRoundVideo()) {
                        this.type = 5;
                    } else if (isVideo()) {
                        this.type = 3;
                    } else if (isVoice()) {
                        this.type = 2;
                    } else if (isMusic()) {
                        this.type = 14;
                    } else {
                        TLRPC$MessageMedia tLRPC$MessageMedia3 = this.messageOwner.media;
                        if (tLRPC$MessageMedia3 instanceof TLRPC$TL_messageMediaContact) {
                            this.type = 12;
                        } else if (tLRPC$MessageMedia3 instanceof TLRPC$TL_messageMediaPoll) {
                            this.type = 17;
                            this.checkedVotes = new ArrayList<>();
                        } else if (tLRPC$MessageMedia3 instanceof TLRPC$TL_messageMediaUnsupported) {
                            this.type = 0;
                        } else if (tLRPC$MessageMedia3 instanceof TLRPC$TL_messageMediaDocument) {
                            TLRPC$Document document = getDocument();
                            if (document != null && document.mime_type != null) {
                                if (isGifDocument(document, hasValidGroupId())) {
                                    this.type = 8;
                                } else if (isSticker()) {
                                    this.type = 13;
                                } else if (isAnimatedSticker()) {
                                    this.type = 15;
                                } else {
                                    this.type = 9;
                                }
                            } else {
                                this.type = 9;
                            }
                        } else if ((tLRPC$MessageMedia3 instanceof TLRPC$TL_messageMediaGame) || (tLRPC$MessageMedia3 instanceof TLRPC$TL_messageMediaInvoice)) {
                            this.type = 0;
                        } else if (tLRPC$MessageMedia3 instanceof TLRPC$TL_messageMediaLiveStream) {
                            this.type = 72;
                        }
                    }
                }
            }
        } else if (tLRPC$Message instanceof TLRPC$TL_messageService) {
            TLRPC$MessageAction tLRPC$MessageAction = tLRPC$Message.action;
            if (tLRPC$MessageAction instanceof TLRPC$TL_messageActionLoginUnknownLocation) {
                this.type = 0;
            } else if ((tLRPC$MessageAction instanceof TLRPC$TL_messageActionChatEditPhoto) || (tLRPC$MessageAction instanceof TLRPC$TL_messageActionUserUpdatedPhoto)) {
                this.contentType = 1;
                this.type = 11;
            } else if (tLRPC$MessageAction instanceof TLRPC$TL_messageEncryptedAction) {
                TLRPC$DecryptedMessageAction tLRPC$DecryptedMessageAction = tLRPC$MessageAction.encryptedAction;
                if ((tLRPC$DecryptedMessageAction instanceof TLRPC$TL_decryptedMessageActionScreenshotMessages) || (tLRPC$DecryptedMessageAction instanceof TLRPC$TL_decryptedMessageActionSetMessageTTL)) {
                    this.contentType = 1;
                    this.type = 10;
                } else {
                    this.contentType = -1;
                    this.type = -1;
                }
            } else if (tLRPC$MessageAction instanceof TLRPC$TL_messageActionHistoryClear) {
                this.contentType = -1;
                this.type = -1;
            } else if (tLRPC$MessageAction instanceof TLRPC$TL_messageActionPhoneCall) {
                this.type = 16;
            } else {
                this.contentType = 1;
                this.type = 10;
            }
        }
        if (i == 1000 || i == this.type) {
            return;
        }
        updateMessageText(MessagesController.getInstance(this.currentAccount).getUsers(), MessagesController.getInstance(this.currentAccount).getChats(), null, null);
        generateThumbs(false);
    }

    public boolean checkLayout() {
        CharSequence charSequence;
        TextPaint textPaint;
        if (this.type == 0 && this.messageOwner.peer_id != null && (charSequence = this.messageText) != null && charSequence.length() != 0) {
            if (this.layoutCreated) {
                if (Math.abs(this.generatedWithMinSize - (AndroidUtilities.isTablet() ? AndroidUtilities.getMinTabletSide() : AndroidUtilities.displaySize.x)) > AndroidUtilities.dp(52.0f) || this.generatedWithDensity != AndroidUtilities.density) {
                    this.layoutCreated = false;
                }
            }
            if (!this.layoutCreated) {
                this.layoutCreated = true;
                TLRPC$User user = isFromUser() ? MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(this.messageOwner.from_id.user_id)) : null;
                if (this.messageOwner.media instanceof TLRPC$TL_messageMediaGame) {
                    textPaint = Theme.chat_msgGameTextPaint;
                } else if (this.drawFullWith == 1) {
                    textPaint = Theme.explore_captionTextPaint;
                } else {
                    textPaint = Theme.chat_msgTextPaint;
                }
                int[] iArr = allowsBigEmoji() ? new int[1] : null;
                this.messageText = Emoji.replaceEmoji(this.messageText, textPaint.getFontMetricsInt(), AndroidUtilities.dp(20.0f), false, iArr);
                checkEmojiOnly(iArr);
                generateLayout(user);
                return true;
            }
        }
        return false;
    }

    public void resetLayout() {
        this.layoutCreated = false;
    }

    public String getMimeType() {
        TLRPC$Document document = getDocument();
        if (document != null) {
            return document.mime_type;
        }
        TLRPC$MessageMedia tLRPC$MessageMedia = this.messageOwner.media;
        if (!(tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaInvoice)) {
            return tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto ? "image/jpeg" : (!(tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) || tLRPC$MessageMedia.webpage.photo == null) ? "" : "image/jpeg";
        }
        TLRPC$WebDocument tLRPC$WebDocument = ((TLRPC$TL_messageMediaInvoice) tLRPC$MessageMedia).photo;
        return tLRPC$WebDocument != null ? tLRPC$WebDocument.mime_type : "";
    }

    public boolean canPreviewDocument() {
        return canPreviewDocument(getDocument());
    }

    public static boolean isGifDocument(WebFile document) {
        return document != null && (document.mime_type.equals("image/gif") || isNewGifDocument(document));
    }

    public static boolean isGifDocument(TLRPC$Document document) {
        return isGifDocument(document, false);
    }

    public static boolean isGifDocument(TLRPC$Document document, boolean hasGroup) {
        String str;
        return (document == null || (str = document.mime_type) == null || ((!str.equals("image/gif") || hasGroup) && !isNewGifDocument(document))) ? false : true;
    }

    public static boolean isDocumentHasThumb(TLRPC$Document document) {
        if (document != null && !document.thumbs.isEmpty()) {
            int size = document.thumbs.size();
            for (int i = 0; i < size; i++) {
                TLRPC$PhotoSize tLRPC$PhotoSize = document.thumbs.get(i);
                if (tLRPC$PhotoSize != null && !(tLRPC$PhotoSize instanceof TLRPC$TL_photoSizeEmpty) && !(tLRPC$PhotoSize.location instanceof TLRPC$TL_fileLocationUnavailable)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean canPreviewDocument(TLRPC$Document document) {
        String str;
        if (document != null && (str = document.mime_type) != null) {
            String lowerCase = str.toLowerCase();
            if ((isDocumentHasThumb(document) && (lowerCase.equals("image/png") || lowerCase.equals("image/jpg") || lowerCase.equals("image/jpeg"))) || (Build.VERSION.SDK_INT >= 26 && lowerCase.equals("image/heic"))) {
                for (int i = 0; i < document.attributes.size(); i++) {
                    TLRPC$DocumentAttribute tLRPC$DocumentAttribute = document.attributes.get(i);
                    if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeImageSize) {
                        TLRPC$TL_documentAttributeImageSize tLRPC$TL_documentAttributeImageSize = (TLRPC$TL_documentAttributeImageSize) tLRPC$DocumentAttribute;
                        return tLRPC$TL_documentAttributeImageSize.w < 6000 && tLRPC$TL_documentAttributeImageSize.h < 6000;
                    }
                }
            } else if (BuildVars.DEBUG_PRIVATE_VERSION) {
                String documentFileName = FileLoader.getDocumentFileName(document);
                if ((documentFileName.startsWith("tg_secret_sticker") && documentFileName.endsWith("json")) || documentFileName.endsWith(".svg")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean shouldHavePayButton(TLRPC$Message message, boolean add) {
        if (!MessagesController.getInstance(UserConfig.selectedAccount).payEnabled || message == null) {
            return false;
        }
        String strHasPayLink = hasPayLink(message);
        if (!add || strHasPayLink == null) {
            return strHasPayLink != null;
        }
        message.reply_markup = new TLRPC$TL_replyInlineMarkup();
        TLRPC$TL_keyboardButtonBuy tLRPC$TL_keyboardButtonBuy = new TLRPC$TL_keyboardButtonBuy();
        tLRPC$TL_keyboardButtonBuy.text = LocaleController.getString("PayTitle", R.string.PayTitle);
        if (strHasPayLink.toLowerCase().contains(MessagesController.getInstance(UserConfig.selectedAccount).payHost + "/v/")) {
            tLRPC$TL_keyboardButtonBuy.text = LocaleController.getString("PayButtonViewTitle", R.string.PayButtonViewTitle);
        } else {
            if (strHasPayLink.toLowerCase().contains(MessagesController.getInstance(UserConfig.selectedAccount).payHost + "/r/")) {
                tLRPC$TL_keyboardButtonBuy.text = LocaleController.getString("PayButtonEnterTitle", R.string.PayButtonEnterTitle);
            } else {
                if (strHasPayLink.toLowerCase().contains(MessagesController.getInstance(UserConfig.selectedAccount).payHost + "/l/")) {
                    tLRPC$TL_keyboardButtonBuy.text = LocaleController.getString("PayButtonRegisterTitle", R.string.PayButtonRegisterTitle);
                } else {
                    if (strHasPayLink.toLowerCase().contains(MessagesController.getInstance(UserConfig.selectedAccount).payHost + "/s/")) {
                        tLRPC$TL_keyboardButtonBuy.text = LocaleController.getString("PayButtonBuyTitle", R.string.PayButtonBuyTitle);
                    } else {
                        if (strHasPayLink.toLowerCase().contains(MessagesController.getInstance(UserConfig.selectedAccount).payHost + "/i/")) {
                            tLRPC$TL_keyboardButtonBuy.text = LocaleController.getString("PayButtonGetTitle", R.string.PayButtonGetTitle);
                        }
                    }
                }
            }
        }
        tLRPC$TL_keyboardButtonBuy.url = strHasPayLink;
        TLRPC$TL_keyboardButtonRow tLRPC$TL_keyboardButtonRow = new TLRPC$TL_keyboardButtonRow();
        tLRPC$TL_keyboardButtonRow.buttons.add(tLRPC$TL_keyboardButtonBuy);
        message.reply_markup.rows.add(tLRPC$TL_keyboardButtonRow);
        return true;
    }

    public static String hasPayLink(TLRPC$Message message) {
        ArrayList<TLRPC$MessageEntity> arrayList;
        URL url;
        String str;
        URL url2;
        URL url3;
        String string = null;
        if (message == null) {
            return null;
        }
        String str2 = MessagesController.getInstance(UserConfig.selectedAccount).payHost;
        String str3 = message.message;
        if (str3 == null) {
            str3 = "";
        }
        Matcher matcher = Patterns.WEB_URL.matcher(str3);
        while (matcher.find()) {
            try {
                String strGroup = matcher.group();
                if (!strGroup.startsWith("http")) {
                    strGroup = "https://" + strGroup;
                }
                url3 = new URL(strGroup);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (url3.getHost().toLowerCase().equals(str2)) {
                string = url3.toString();
                break;
            }
            continue;
        }
        if (string == null && message.media != null && (str = message.message) != null && str.length() > 0) {
            Matcher matcher2 = Patterns.WEB_URL.matcher(message.message);
            while (matcher2.find()) {
                try {
                    String strGroup2 = matcher2.group();
                    if (!strGroup2.startsWith("http")) {
                        strGroup2 = "https://" + strGroup2;
                    }
                    url2 = new URL(strGroup2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (url2.getHost().toLowerCase().equals(str2)) {
                    string = url2.toString();
                    break;
                }
                continue;
            }
        }
        if (string == null && (arrayList = message.entities) != null && arrayList.size() > 0) {
            Iterator<TLRPC$MessageEntity> it = message.entities.iterator();
            while (it.hasNext()) {
                TLRPC$MessageEntity next = it.next();
                if (next instanceof TLRPC$TL_messageEntityTextUrl) {
                    Matcher matcher3 = Patterns.WEB_URL.matcher(next.url);
                    while (true) {
                        if (!matcher3.find()) {
                            break;
                        }
                        try {
                            String strGroup3 = matcher3.group();
                            if (!strGroup3.startsWith("http")) {
                                strGroup3 = "https://" + strGroup3;
                            }
                            url = new URL(strGroup3);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        if (url.getHost().toLowerCase().equals(str2)) {
                            string = url.toString();
                            break;
                        }
                    }
                    if (string != null) {
                        break;
                    }
                }
            }
        }
        return string;
    }

    public static boolean isRoundVideoDocument(TLRPC$Document document) {
        if (document != null && "video/mp4".equals(document.mime_type)) {
            boolean z = false;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < document.attributes.size(); i3++) {
                TLRPC$DocumentAttribute tLRPC$DocumentAttribute = document.attributes.get(i3);
                if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeVideo) {
                    i = tLRPC$DocumentAttribute.w;
                    i2 = tLRPC$DocumentAttribute.h;
                    z = tLRPC$DocumentAttribute.round_message;
                }
            }
            if (z && i <= 1280 && i2 <= 1280) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNewGifDocument(WebFile document) {
        if (document != null && "video/mp4".equals(document.mime_type)) {
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < document.attributes.size(); i3++) {
                TLRPC$DocumentAttribute tLRPC$DocumentAttribute = document.attributes.get(i3);
                if (!(tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeAnimated) && (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeVideo)) {
                    i = tLRPC$DocumentAttribute.w;
                    i2 = tLRPC$DocumentAttribute.h;
                }
            }
            if (i <= 1280 && i2 <= 1280) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNewGifDocument(TLRPC$Document document) {
        if (document != null && ("video/mp4".equals(document.mime_type) || "image/gif".equals(document.mime_type))) {
            boolean z = false;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < document.attributes.size(); i3++) {
                TLRPC$DocumentAttribute tLRPC$DocumentAttribute = document.attributes.get(i3);
                if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeAnimated) {
                    z = true;
                } else if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeVideo) {
                    i = tLRPC$DocumentAttribute.w;
                    i2 = tLRPC$DocumentAttribute.h;
                }
            }
            if (z && i <= 1280 && i2 <= 1280) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSystemSignUp(MessageObject message) {
        if (message != null) {
            TLRPC$Message tLRPC$Message = message.messageOwner;
            if ((tLRPC$Message instanceof TLRPC$TL_messageService) && (((TLRPC$TL_messageService) tLRPC$Message).action instanceof TLRPC$TL_messageActionContactSignUp)) {
                return true;
            }
        }
        return false;
    }

    public void generateThumbs(boolean update) {
        ArrayList<TLRPC$PhotoSize> arrayList;
        ArrayList<TLRPC$PhotoSize> arrayList2;
        ArrayList<TLRPC$PhotoSize> arrayList3;
        ArrayList<TLRPC$PhotoSize> arrayList4;
        ArrayList<TLRPC$PhotoSize> arrayList5;
        ArrayList<TLRPC$PhotoSize> arrayList6;
        ArrayList<TLRPC$PhotoSize> arrayList7;
        TLRPC$Message tLRPC$Message = this.messageOwner;
        if (tLRPC$Message instanceof TLRPC$TL_messageService) {
            TLRPC$MessageAction tLRPC$MessageAction = tLRPC$Message.action;
            if (tLRPC$MessageAction instanceof TLRPC$TL_messageActionChatEditPhoto) {
                TLRPC$Photo tLRPC$Photo = tLRPC$MessageAction.photo;
                if (!update) {
                    this.photoThumbs = new ArrayList<>(tLRPC$Photo.sizes);
                } else {
                    ArrayList<TLRPC$PhotoSize> arrayList8 = this.photoThumbs;
                    if (arrayList8 != null && !arrayList8.isEmpty()) {
                        for (int i = 0; i < this.photoThumbs.size(); i++) {
                            TLRPC$PhotoSize tLRPC$PhotoSize = this.photoThumbs.get(i);
                            int i2 = 0;
                            while (true) {
                                if (i2 < tLRPC$Photo.sizes.size()) {
                                    TLRPC$PhotoSize tLRPC$PhotoSize2 = tLRPC$Photo.sizes.get(i2);
                                    if (!(tLRPC$PhotoSize2 instanceof TLRPC$TL_photoSizeEmpty) && tLRPC$PhotoSize2.type.equals(tLRPC$PhotoSize.type)) {
                                        tLRPC$PhotoSize.location = tLRPC$PhotoSize2.location;
                                        break;
                                    }
                                    i2++;
                                }
                            }
                        }
                    }
                }
                if (tLRPC$Photo.dc_id != 0 && (arrayList7 = this.photoThumbs) != null) {
                    int size = arrayList7.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        TLRPC$FileLocation tLRPC$FileLocation = this.photoThumbs.get(i3).location;
                        if (tLRPC$FileLocation != null) {
                            tLRPC$FileLocation.dc_id = tLRPC$Photo.dc_id;
                            tLRPC$FileLocation.file_reference = tLRPC$Photo.file_reference;
                        }
                    }
                }
                this.photoThumbsObject = this.messageOwner.action.photo;
                return;
            }
            return;
        }
        if (this.emojiAnimatedSticker != null) {
            if (TextUtils.isEmpty(this.emojiAnimatedStickerColor) && isDocumentHasThumb(this.emojiAnimatedSticker)) {
                if (!update || (arrayList6 = this.photoThumbs) == null) {
                    ArrayList<TLRPC$PhotoSize> arrayList9 = new ArrayList<>();
                    this.photoThumbs = arrayList9;
                    arrayList9.addAll(this.emojiAnimatedSticker.thumbs);
                } else if (!arrayList6.isEmpty()) {
                    updatePhotoSizeLocations(this.photoThumbs, this.emojiAnimatedSticker.thumbs);
                }
                this.photoThumbsObject = this.emojiAnimatedSticker;
                return;
            }
            return;
        }
        TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$Message.media;
        if (tLRPC$MessageMedia == null || (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaEmpty)) {
            return;
        }
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) {
            TLRPC$Photo tLRPC$Photo2 = tLRPC$MessageMedia.photo;
            if (!update || ((arrayList5 = this.photoThumbs) != null && arrayList5.size() != tLRPC$Photo2.sizes.size())) {
                this.photoThumbs = new ArrayList<>(tLRPC$Photo2.sizes);
            } else {
                ArrayList<TLRPC$PhotoSize> arrayList10 = this.photoThumbs;
                if (arrayList10 != null && !arrayList10.isEmpty()) {
                    for (int i4 = 0; i4 < this.photoThumbs.size(); i4++) {
                        TLRPC$PhotoSize tLRPC$PhotoSize3 = this.photoThumbs.get(i4);
                        if (tLRPC$PhotoSize3 != null) {
                            int i5 = 0;
                            while (true) {
                                if (i5 >= tLRPC$Photo2.sizes.size()) {
                                    break;
                                }
                                TLRPC$PhotoSize tLRPC$PhotoSize4 = tLRPC$Photo2.sizes.get(i5);
                                if (tLRPC$PhotoSize4 != null && !(tLRPC$PhotoSize4 instanceof TLRPC$TL_photoSizeEmpty)) {
                                    if (tLRPC$PhotoSize4.type.equals(tLRPC$PhotoSize3.type)) {
                                        tLRPC$PhotoSize3.location = tLRPC$PhotoSize4.location;
                                        break;
                                    } else if ("s".equals(tLRPC$PhotoSize3.type) && (tLRPC$PhotoSize4 instanceof TLRPC$TL_photoStrippedSize)) {
                                        this.photoThumbs.set(i4, tLRPC$PhotoSize4);
                                        break;
                                    }
                                }
                                i5++;
                            }
                        }
                    }
                }
            }
            this.photoThumbsObject = this.messageOwner.media.photo;
            return;
        }
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaDocument) {
            TLRPC$Document document = getDocument();
            if (isDocumentHasThumb(document)) {
                if (!update || (arrayList4 = this.photoThumbs) == null) {
                    ArrayList<TLRPC$PhotoSize> arrayList11 = new ArrayList<>();
                    this.photoThumbs = arrayList11;
                    arrayList11.addAll(document.thumbs);
                } else if (!arrayList4.isEmpty()) {
                    updatePhotoSizeLocations(this.photoThumbs, document.thumbs);
                }
                this.photoThumbsObject = document;
                return;
            }
            return;
        }
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaGame) {
            TLRPC$Document tLRPC$Document = tLRPC$MessageMedia.game.document;
            if (tLRPC$Document != null && isDocumentHasThumb(tLRPC$Document)) {
                if (!update) {
                    ArrayList<TLRPC$PhotoSize> arrayList12 = new ArrayList<>();
                    this.photoThumbs = arrayList12;
                    arrayList12.addAll(tLRPC$Document.thumbs);
                } else {
                    ArrayList<TLRPC$PhotoSize> arrayList13 = this.photoThumbs;
                    if (arrayList13 != null && !arrayList13.isEmpty()) {
                        updatePhotoSizeLocations(this.photoThumbs, tLRPC$Document.thumbs);
                    }
                }
                this.photoThumbsObject = tLRPC$Document;
            }
            TLRPC$Photo tLRPC$Photo3 = this.messageOwner.media.game.photo;
            if (tLRPC$Photo3 != null) {
                if (!update || (arrayList3 = this.photoThumbs2) == null) {
                    this.photoThumbs2 = new ArrayList<>(tLRPC$Photo3.sizes);
                } else if (!arrayList3.isEmpty()) {
                    updatePhotoSizeLocations(this.photoThumbs2, tLRPC$Photo3.sizes);
                }
                this.photoThumbsObject2 = tLRPC$Photo3;
            }
            if (this.photoThumbs != null || (arrayList2 = this.photoThumbs2) == null) {
                return;
            }
            this.photoThumbs = arrayList2;
            this.photoThumbs2 = null;
            this.photoThumbsObject = this.photoThumbsObject2;
            this.photoThumbsObject2 = null;
            return;
        }
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) {
            TLRPC$WebPage tLRPC$WebPage = tLRPC$MessageMedia.webpage;
            TLRPC$Photo tLRPC$Photo4 = tLRPC$WebPage.photo;
            TLRPC$Document tLRPC$Document2 = tLRPC$WebPage.document;
            if (tLRPC$Photo4 != null) {
                if (!update || (arrayList = this.photoThumbs) == null) {
                    this.photoThumbs = new ArrayList<>(tLRPC$Photo4.sizes);
                } else if (!arrayList.isEmpty()) {
                    updatePhotoSizeLocations(this.photoThumbs, tLRPC$Photo4.sizes);
                }
                this.photoThumbsObject = tLRPC$Photo4;
                return;
            }
            if (tLRPC$Document2 == null || !isDocumentHasThumb(tLRPC$Document2)) {
                return;
            }
            if (!update) {
                ArrayList<TLRPC$PhotoSize> arrayList14 = new ArrayList<>();
                this.photoThumbs = arrayList14;
                arrayList14.addAll(tLRPC$Document2.thumbs);
            } else {
                ArrayList<TLRPC$PhotoSize> arrayList15 = this.photoThumbs;
                if (arrayList15 != null && !arrayList15.isEmpty()) {
                    updatePhotoSizeLocations(this.photoThumbs, tLRPC$Document2.thumbs);
                }
            }
            this.photoThumbsObject = tLRPC$Document2;
        }
    }

    private static void updatePhotoSizeLocations(ArrayList<TLRPC$PhotoSize> o, ArrayList<TLRPC$PhotoSize> n) {
        int size = o.size();
        for (int i = 0; i < size; i++) {
            TLRPC$PhotoSize tLRPC$PhotoSize = o.get(i);
            if (tLRPC$PhotoSize != null) {
                int size2 = n.size();
                int i2 = 0;
                while (true) {
                    if (i2 < size2) {
                        TLRPC$PhotoSize tLRPC$PhotoSize2 = n.get(i2);
                        if (!(tLRPC$PhotoSize2 instanceof TLRPC$TL_photoSizeEmpty) && !(tLRPC$PhotoSize2 instanceof TLRPC$TL_photoCachedSize) && tLRPC$PhotoSize2 != null && tLRPC$PhotoSize2.type.equals(tLRPC$PhotoSize.type)) {
                            tLRPC$PhotoSize.location = tLRPC$PhotoSize2.location;
                            break;
                        }
                        i2++;
                    }
                }
            }
        }
    }

    public CharSequence replaceWithLink(CharSequence source, String param, ArrayList<Long> uids, AbstractMap<Long, TLRPC$User> usersDict, LongSparseArray<TLRPC$User> sUsersDict) {
        if (TextUtils.indexOf(source, param) < 0) {
            return source;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        for (int i = 0; i < uids.size(); i++) {
            TLRPC$User user = null;
            if (usersDict != null) {
                user = usersDict.get(uids.get(i));
            } else if (sUsersDict != null) {
                user = sUsersDict.get(uids.get(i).longValue());
            }
            if (user == null) {
                user = MessagesController.getInstance(this.currentAccount).getUser(uids.get(i));
            }
            if (user != null) {
                String userName = UserObject.getUserName(user);
                int length = spannableStringBuilder.length();
                if (spannableStringBuilder.length() != 0) {
                    spannableStringBuilder.append((CharSequence) ", ");
                }
                spannableStringBuilder.append((CharSequence) userName);
                spannableStringBuilder.setSpan(new URLSpanNoUnderlineBold("" + user.id), length, userName.length() + length, 33);
            }
        }
        return TextUtils.replace(source, new String[]{param}, new CharSequence[]{spannableStringBuilder});
    }

    public static CharSequence replaceWithLink(CharSequence source, String param, TLObject object) {
        String str;
        String userName;
        int iIndexOf = TextUtils.indexOf(source, param);
        if (iIndexOf < 0) {
            return source;
        }
        TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported = null;
        if (object instanceof TLRPC$User) {
            TLRPC$User tLRPC$User = (TLRPC$User) object;
            userName = UserObject.getUserName(tLRPC$User);
            str = "" + tLRPC$User.id;
        } else if (object instanceof TLRPC$Chat) {
            TLRPC$Chat tLRPC$Chat = (TLRPC$Chat) object;
            userName = tLRPC$Chat.title;
            str = "" + (-tLRPC$Chat.id);
        } else if (object instanceof TLRPC$TL_game) {
            userName = ((TLRPC$TL_game) object).title;
            str = "game";
        } else if (object instanceof TLRPC$TL_chatInviteExported) {
            tLRPC$TL_chatInviteExported = (TLRPC$TL_chatInviteExported) object;
            userName = tLRPC$TL_chatInviteExported.link;
            str = "invite";
        } else {
            str = "0";
            userName = "";
        }
        String strReplace = userName.replace('\n', ' ');
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(TextUtils.replace(source, new String[]{param}, new String[]{strReplace}));
        URLSpanNoUnderlineBold uRLSpanNoUnderlineBold = new URLSpanNoUnderlineBold("" + str);
        uRLSpanNoUnderlineBold.setObject(tLRPC$TL_chatInviteExported);
        spannableStringBuilder.setSpan(uRLSpanNoUnderlineBold, iIndexOf, strReplace.length() + iIndexOf, 33);
        return spannableStringBuilder;
    }

    public String getExtension() {
        String fileName = getFileName();
        int iLastIndexOf = fileName.lastIndexOf(46);
        String strSubstring = iLastIndexOf != -1 ? fileName.substring(iLastIndexOf + 1) : null;
        if (strSubstring == null || strSubstring.length() == 0) {
            strSubstring = getDocument().mime_type;
        }
        if (strSubstring == null) {
            strSubstring = "";
        }
        return strSubstring.toUpperCase();
    }

    public String getFileName() {
        return getFileName(this.messageOwner);
    }

    public static String getFileName(TLRPC$Message messageOwner) {
        TLRPC$PhotoSize closestPhotoSizeWithSize;
        TLRPC$MessageMedia tLRPC$MessageMedia = messageOwner.media;
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaDocument) {
            return FileLoader.getAttachFileName(getDocument(messageOwner));
        }
        if (!(tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto)) {
            return tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage ? FileLoader.getAttachFileName(tLRPC$MessageMedia.webpage.document) : "";
        }
        ArrayList<TLRPC$PhotoSize> arrayList = tLRPC$MessageMedia.photo.sizes;
        return (arrayList.size() <= 0 || (closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(arrayList, AndroidUtilities.getPhotoSize())) == null) ? "" : FileLoader.getAttachFileName(closestPhotoSizeWithSize);
    }

    public int getMediaType() {
        if (isVideo()) {
            return 2;
        }
        if (isVoice()) {
            return 1;
        }
        TLRPC$MessageMedia tLRPC$MessageMedia = this.messageOwner.media;
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaDocument) {
            return 3;
        }
        return tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto ? 0 : 4;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean containsUrls(java.lang.CharSequence r14) {
        /*
            r0 = 0
            if (r14 == 0) goto L8d
            int r1 = r14.length()
            r2 = 2
            if (r1 < r2) goto L8d
            int r1 = r14.length()
            r3 = 20480(0x5000, float:2.8699E-41)
            if (r1 <= r3) goto L14
            goto L8d
        L14:
            int r1 = r14.length()
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
        L1d:
            if (r3 >= r1) goto L8d
            char r8 = r14.charAt(r3)
            r9 = 48
            r10 = 32
            r11 = 1
            if (r8 < r9) goto L37
            r9 = 57
            if (r8 > r9) goto L37
            int r4 = r4 + 1
            r5 = 6
            if (r4 < r5) goto L34
            return r11
        L34:
            r5 = 0
            r6 = 0
            goto L3c
        L37:
            if (r8 == r10) goto L3b
            if (r4 > 0) goto L3c
        L3b:
            r4 = 0
        L3c:
            r9 = 64
            r12 = 47
            if (r8 == r9) goto L4c
            r9 = 35
            if (r8 == r9) goto L4c
            if (r8 == r12) goto L4c
            r9 = 36
            if (r8 != r9) goto L4e
        L4c:
            if (r3 == 0) goto L8c
        L4e:
            if (r3 == 0) goto L61
            int r9 = r3 + (-1)
            char r13 = r14.charAt(r9)
            if (r13 == r10) goto L8c
            char r9 = r14.charAt(r9)
            r13 = 10
            if (r9 != r13) goto L61
            goto L8c
        L61:
            r9 = 58
            if (r8 != r9) goto L6b
            if (r5 != 0) goto L69
            r5 = 1
            goto L88
        L69:
            r5 = 0
            goto L88
        L6b:
            if (r8 != r12) goto L75
            if (r5 != r2) goto L70
            return r11
        L70:
            if (r5 != r11) goto L69
            int r5 = r5 + 1
            goto L88
        L75:
            r9 = 46
            if (r8 != r9) goto L80
            if (r6 != 0) goto L87
            if (r7 == r10) goto L87
            int r6 = r6 + 1
            goto L88
        L80:
            if (r8 == r10) goto L87
            if (r7 != r9) goto L87
            if (r6 != r11) goto L87
            return r11
        L87:
            r6 = 0
        L88:
            int r3 = r3 + 1
            r7 = r8
            goto L1d
        L8c:
            return r11
        L8d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessageObject.containsUrls(java.lang.CharSequence):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void generateLinkDescription() {
        /*
            Method dump skipped, instructions count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessageObject.generateLinkDescription():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void generateCaption() {
        /*
            Method dump skipped, instructions count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessageObject.generateCaption():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01d7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0049 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void addUrlsByPattern(boolean r16, java.lang.CharSequence r17, boolean r18, int r19, int r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 501
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessageObject.addUrlsByPattern(boolean, java.lang.CharSequence, boolean, int, int, boolean):void");
    }

    public static int[] getWebDocumentWidthAndHeight(TLRPC$WebDocument document) {
        int i;
        if (document == null) {
            return null;
        }
        int size = document.attributes.size();
        while (i < size) {
            TLRPC$DocumentAttribute tLRPC$DocumentAttribute = document.attributes.get(i);
            i = ((tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeImageSize) || (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeVideo)) ? 0 : i + 1;
            return new int[]{tLRPC$DocumentAttribute.w, tLRPC$DocumentAttribute.h};
        }
        return null;
    }

    public static int getWebDocumentDuration(TLRPC$WebDocument document) {
        if (document == null) {
            return 0;
        }
        int size = document.attributes.size();
        for (int i = 0; i < size; i++) {
            TLRPC$DocumentAttribute tLRPC$DocumentAttribute = document.attributes.get(i);
            if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeVideo) {
                return tLRPC$DocumentAttribute.duration;
            }
            if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeAudio) {
                return tLRPC$DocumentAttribute.duration;
            }
        }
        return 0;
    }

    public static int[] getInlineResultWidthAndHeight(TLRPC$BotInlineResult inlineResult) {
        int[] webDocumentWidthAndHeight = getWebDocumentWidthAndHeight(inlineResult.content);
        if (webDocumentWidthAndHeight != null) {
            return webDocumentWidthAndHeight;
        }
        int[] webDocumentWidthAndHeight2 = getWebDocumentWidthAndHeight(inlineResult.thumb);
        return webDocumentWidthAndHeight2 == null ? new int[]{0, 0} : webDocumentWidthAndHeight2;
    }

    public static int getInlineResultDuration(TLRPC$BotInlineResult inlineResult) {
        int webDocumentDuration = getWebDocumentDuration(inlineResult.content);
        return webDocumentDuration == 0 ? getWebDocumentDuration(inlineResult.thumb) : webDocumentDuration;
    }

    public boolean hasValidGroupId() {
        ArrayList<TLRPC$PhotoSize> arrayList;
        return getGroupId() != 0 && (!((arrayList = this.photoThumbs) == null || arrayList.isEmpty()) || isMusic() || isDocument());
    }

    public long getGroupIdForUse() {
        long j = this.localSentGroupId;
        return j != 0 ? j : this.messageOwner.grouped_id;
    }

    public long getGroupId() {
        long j = this.localGroupId;
        return j != 0 ? j : getGroupIdForUse();
    }

    public static void addLinks(boolean isOut, CharSequence messageText) {
        addLinks(isOut, messageText, true, false);
    }

    public static void addLinks(boolean isOut, CharSequence messageText, boolean botCommands, boolean check) {
        addLinks(isOut, messageText, botCommands, check, false);
    }

    public static void addLinks(boolean isOut, CharSequence messageText, boolean botCommands, boolean check, boolean internalOnly) {
        if ((messageText instanceof Spannable) && containsUrls(messageText)) {
            if (messageText.length() < 1000) {
                try {
                    AndroidUtilities.addLinks((Spannable) messageText, 5, internalOnly);
                } catch (Exception e) {
                    FileLog.e(e);
                }
            } else {
                try {
                    AndroidUtilities.addLinks((Spannable) messageText, 1, internalOnly);
                } catch (Exception e2) {
                    FileLog.e(e2);
                }
            }
            addUrlsByPattern(isOut, messageText, botCommands, 0, 0, check);
        }
    }

    public void resetPlayingProgress() {
        this.audioProgress = 0.0f;
        this.audioProgressSec = 0;
        this.bufferedProgress = 0.0f;
    }

    private boolean addEntitiesToText(CharSequence text, boolean useManualParse) {
        return addEntitiesToText(text, false, useManualParse);
    }

    public boolean addEntitiesToText(CharSequence text, boolean photoViewer, boolean useManualParse) {
        if (this.isRestrictedMessage) {
            ArrayList arrayList = new ArrayList();
            TLRPC$TL_messageEntityItalic tLRPC$TL_messageEntityItalic = new TLRPC$TL_messageEntityItalic();
            tLRPC$TL_messageEntityItalic.offset = 0;
            tLRPC$TL_messageEntityItalic.length = text.length();
            arrayList.add(tLRPC$TL_messageEntityItalic);
            return addEntitiesToText(text, arrayList, isOutOwner(), true, photoViewer, useManualParse);
        }
        return addEntitiesToText(text, this.messageOwner.entities, isOutOwner(), true, photoViewer, useManualParse);
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0202 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean addEntitiesToText(java.lang.CharSequence r17, java.util.ArrayList<ir.eitaa.tgnet.TLRPC$MessageEntity> r18, boolean r19, boolean r20, boolean r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 950
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessageObject.addEntitiesToText(java.lang.CharSequence, java.util.ArrayList, boolean, boolean, boolean, boolean):boolean");
    }

    static /* synthetic */ int lambda$addEntitiesToText$0(TLRPC$MessageEntity tLRPC$MessageEntity, TLRPC$MessageEntity tLRPC$MessageEntity2) {
        int i = tLRPC$MessageEntity.offset;
        int i2 = tLRPC$MessageEntity2.offset;
        if (i > i2) {
            return 1;
        }
        return i < i2 ? -1 : 0;
    }

    public boolean needDrawShareButton() {
        int i;
        String str;
        if (this.preview || this.scheduled || this.eventId != 0) {
            return false;
        }
        if (this.messageOwner.fwd_from != null && !isOutOwner() && this.messageOwner.fwd_from.saved_from_peer != null && getDialogId() == UserConfig.getInstance(this.currentAccount).getClientUserId()) {
            return true;
        }
        int i2 = this.type;
        if (i2 != 13 && i2 != 15) {
            TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = this.messageOwner.fwd_from;
            if (tLRPC$MessageFwdHeader != null && (tLRPC$MessageFwdHeader.from_id instanceof TLRPC$TL_peerChannel) && !isOutOwner()) {
                return true;
            }
            if (isFromUser()) {
                TLRPC$MessageMedia tLRPC$MessageMedia = this.messageOwner.media;
                if ((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaEmpty) || tLRPC$MessageMedia == null || ((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) && !(tLRPC$MessageMedia.webpage instanceof TLRPC$TL_webPage))) {
                    return false;
                }
                TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(this.messageOwner.from_id.user_id));
                if (user != null && user.bot) {
                    return true;
                }
                if (!isOut()) {
                    TLRPC$Message tLRPC$Message = this.messageOwner;
                    TLRPC$MessageMedia tLRPC$MessageMedia2 = tLRPC$Message.media;
                    if ((tLRPC$MessageMedia2 instanceof TLRPC$TL_messageMediaGame) || (tLRPC$MessageMedia2 instanceof TLRPC$TL_messageMediaInvoice)) {
                        return true;
                    }
                    TLRPC$Peer tLRPC$Peer = tLRPC$Message.peer_id;
                    TLRPC$Chat chat = null;
                    if (tLRPC$Peer != null) {
                        long j = tLRPC$Peer.channel_id;
                        if (j != 0) {
                            chat = getChat(null, null, j);
                        }
                    }
                    if (!ChatObject.isChannel(chat) || !chat.megagroup || (str = chat.username) == null || str.length() <= 0) {
                        return false;
                    }
                    TLRPC$MessageMedia tLRPC$MessageMedia3 = this.messageOwner.media;
                    return ((tLRPC$MessageMedia3 instanceof TLRPC$TL_messageMediaContact) || (tLRPC$MessageMedia3 instanceof TLRPC$TL_messageMediaGeo)) ? false : true;
                }
            } else {
                TLRPC$Message tLRPC$Message2 = this.messageOwner;
                if ((!(tLRPC$Message2.from_id instanceof TLRPC$TL_peerChannel) && !tLRPC$Message2.post) || isSupergroup()) {
                    return false;
                }
                TLRPC$Message tLRPC$Message3 = this.messageOwner;
                if (tLRPC$Message3.peer_id.channel_id != 0 && ((tLRPC$Message3.via_bot_id == 0 && tLRPC$Message3.reply_to == null) || ((i = this.type) != 13 && i != 15))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isYouTubeVideo() {
        TLRPC$WebPage tLRPC$WebPage;
        TLRPC$MessageMedia tLRPC$MessageMedia = this.messageOwner.media;
        return (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) && (tLRPC$WebPage = tLRPC$MessageMedia.webpage) != null && !TextUtils.isEmpty(tLRPC$WebPage.embed_url) && "YouTube".equals(this.messageOwner.media.webpage.site_name);
    }

    public int getMaxMessageTextWidth() {
        int minTabletSide;
        int iDp;
        TLRPC$WebPage tLRPC$WebPage;
        if (AndroidUtilities.isTablet() && this.eventId != 0) {
            this.generatedWithMinSize = AndroidUtilities.dp(530.0f);
        } else {
            this.generatedWithMinSize = AndroidUtilities.isTablet() ? AndroidUtilities.getMinTabletSide() : getParentWidth();
        }
        this.generatedWithDensity = AndroidUtilities.density;
        TLRPC$MessageMedia tLRPC$MessageMedia = this.messageOwner.media;
        int iDp2 = 0;
        if ((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) && (tLRPC$WebPage = tLRPC$MessageMedia.webpage) != null && "eitaa_background".equals(tLRPC$WebPage.type)) {
            try {
                Uri uri = Uri.parse(this.messageOwner.media.webpage.url);
                String lastPathSegment = uri.getLastPathSegment();
                if (uri.getQueryParameter("bg_color") != null) {
                    iDp2 = AndroidUtilities.dp(220.0f);
                } else if (lastPathSegment.length() == 6 || (lastPathSegment.length() == 13 && lastPathSegment.charAt(6) == '-')) {
                    iDp2 = AndroidUtilities.dp(200.0f);
                }
            } catch (Exception unused) {
            }
        } else if (isAndroidTheme()) {
            iDp2 = AndroidUtilities.dp(200.0f);
        }
        if (iDp2 != 0) {
            return iDp2;
        }
        int i = this.drawFullWith;
        if (i == 1) {
            minTabletSide = (AndroidUtilities.isTablet() ? AndroidUtilities.getMinTabletSide() : AndroidUtilities.displaySize.x) / 2;
            iDp = AndroidUtilities.dp(32.0f);
        } else if (i == 2 || i == 3) {
            minTabletSide = AndroidUtilities.isTablet() ? AndroidUtilities.getMinTabletSide() : AndroidUtilities.displaySize.x;
            iDp = AndroidUtilities.dp(16.0f);
        } else {
            minTabletSide = this.generatedWithMinSize;
            iDp = AndroidUtilities.dp((!needDrawAvatarInternal() || isOutOwner() || this.messageOwner.isThreadMessage) ? 80.0f : 132.0f);
        }
        int iDp3 = minTabletSide - iDp;
        if (needDrawShareButton() && !isOutOwner()) {
            iDp3 -= AndroidUtilities.dp(10.0f);
        }
        int i2 = iDp3;
        return this.messageOwner.media instanceof TLRPC$TL_messageMediaGame ? i2 - AndroidUtilities.dp(10.0f) : i2;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:101|(1:103)(1:104)|105|(3:107|(1:(2:110|(2:112|(1:115))(1:116))(1:117))|118)(5:119|(1:121)(10:122|(5:126|127|253|128|129)(2:255|125)|261|130|131|(3:133|246|134)|135|136|(3:138|263|139)|143)|238|270|239)|144|267|145|146|(2:244|150)|259|159|163|(1:165)|166|(1:168)|169|(8:171|(11:248|173|174|251|177|181|(1:183)(1:184)|185|(1:187)(1:188)|(2:197|273)(6:257|192|193|(1:195)|197|273)|198)|272|199|(2:(1:202)|203)(1:(1:205))|206|(1:208)(1:209)|210)(4:211|(5:213|(1:215)|216|(1:218)(1:219)|220)(1:221)|222|(1:224)(1:225))|226|271|239) */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0361, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0362, code lost:
    
        r8 = 0.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0374, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0375, code lost:
    
        ir.eitaa.messenger.FileLog.e(r0);
        r0 = 0.0f;
     */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void generateLayout(ir.eitaa.tgnet.TLRPC$User r33) {
        /*
            Method dump skipped, instructions count: 1265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessageObject.generateLayout(ir.eitaa.tgnet.TLRPC$User):void");
    }

    public boolean isOut() {
        return this.messageOwner.out;
    }

    public boolean isOutOwner() {
        TLRPC$Peer tLRPC$Peer;
        if (this.preview) {
            return true;
        }
        TLRPC$Peer tLRPC$Peer2 = this.messageOwner.peer_id;
        TLRPC$Chat chat = null;
        if (tLRPC$Peer2 != null) {
            long j = tLRPC$Peer2.channel_id;
            if (j != 0) {
                chat = getChat(null, null, j);
            }
        }
        TLRPC$Message tLRPC$Message = this.messageOwner;
        if (tLRPC$Message.out) {
            TLRPC$Peer tLRPC$Peer3 = tLRPC$Message.from_id;
            if ((tLRPC$Peer3 instanceof TLRPC$TL_peerUser) || ((tLRPC$Peer3 instanceof TLRPC$TL_peerChannel) && (!ChatObject.isChannel(chat) || chat.megagroup))) {
                TLRPC$Message tLRPC$Message2 = this.messageOwner;
                if (!tLRPC$Message2.post) {
                    if (tLRPC$Message2.fwd_from == null) {
                        return true;
                    }
                    long clientUserId = UserConfig.getInstance(this.currentAccount).getClientUserId();
                    if (getDialogId() == clientUserId) {
                        TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = this.messageOwner.fwd_from;
                        TLRPC$Peer tLRPC$Peer4 = tLRPC$MessageFwdHeader.from_id;
                        if ((tLRPC$Peer4 instanceof TLRPC$TL_peerUser) && tLRPC$Peer4.user_id == clientUserId && ((tLRPC$Peer = tLRPC$MessageFwdHeader.saved_from_peer) == null || tLRPC$Peer.user_id == clientUserId)) {
                            return true;
                        }
                        TLRPC$Peer tLRPC$Peer5 = tLRPC$MessageFwdHeader.saved_from_peer;
                        return tLRPC$Peer5 != null && tLRPC$Peer5.user_id == clientUserId && (tLRPC$Peer4 == null || tLRPC$Peer4.user_id == clientUserId);
                    }
                    TLRPC$Peer tLRPC$Peer6 = this.messageOwner.fwd_from.saved_from_peer;
                    return tLRPC$Peer6 == null || tLRPC$Peer6.user_id == clientUserId;
                }
            }
        }
        return false;
    }

    public boolean needDrawAvatar() {
        TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader;
        return (!isSponsored() && (isFromUser() || isFromGroup() || this.eventId != 0 || !((tLRPC$MessageFwdHeader = this.messageOwner.fwd_from) == null || tLRPC$MessageFwdHeader.saved_from_peer == null))) || this.forceDrawAvatarAndShare;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needDrawAvatarInternal() {
        TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader;
        return (!isSponsored() && ((isFromChat() && isFromUser()) || isFromGroup() || this.eventId != 0 || !((tLRPC$MessageFwdHeader = this.messageOwner.fwd_from) == null || tLRPC$MessageFwdHeader.saved_from_peer == null))) || this.forceDrawAvatarAndShare;
    }

    public boolean isFromChat() {
        TLRPC$Peer tLRPC$Peer;
        if (getDialogId() == UserConfig.getInstance(this.currentAccount).clientUserId) {
            return true;
        }
        TLRPC$Peer tLRPC$Peer2 = this.messageOwner.peer_id;
        TLRPC$Chat chat = null;
        if (tLRPC$Peer2 != null) {
            long j = tLRPC$Peer2.channel_id;
            if (j != 0) {
                chat = getChat(null, null, j);
            }
        }
        if (!(ChatObject.isChannel(chat) && chat.megagroup) && ((tLRPC$Peer = this.messageOwner.peer_id) == null || tLRPC$Peer.chat_id == 0)) {
            return (tLRPC$Peer == null || tLRPC$Peer.channel_id == 0 || chat == null || !chat.megagroup) ? false : true;
        }
        return true;
    }

    public static long getFromChatId(TLRPC$Message message) {
        return getPeerId(message.from_id);
    }

    public static long getPeerId(TLRPC$Peer peer) {
        long j;
        if (peer == null) {
            return 0L;
        }
        if (peer instanceof TLRPC$TL_peerChat) {
            j = peer.chat_id;
        } else if (peer instanceof TLRPC$TL_peerChannel) {
            j = peer.channel_id;
        } else {
            return peer.user_id;
        }
        return -j;
    }

    public long getFromChatId() {
        return getFromChatId(this.messageOwner);
    }

    public long getChatId() {
        TLRPC$Peer tLRPC$Peer = this.messageOwner.peer_id;
        if (tLRPC$Peer instanceof TLRPC$TL_peerChat) {
            return tLRPC$Peer.chat_id;
        }
        if (tLRPC$Peer instanceof TLRPC$TL_peerChannel) {
            return tLRPC$Peer.channel_id;
        }
        return 0L;
    }

    public boolean isFromUser() {
        TLRPC$Message tLRPC$Message = this.messageOwner;
        return (tLRPC$Message.from_id instanceof TLRPC$TL_peerUser) && !tLRPC$Message.post;
    }

    public boolean isFromGroup() {
        TLRPC$Peer tLRPC$Peer = this.messageOwner.peer_id;
        TLRPC$Chat chat = null;
        if (tLRPC$Peer != null) {
            long j = tLRPC$Peer.channel_id;
            if (j != 0) {
                chat = getChat(null, null, j);
            }
        }
        return (this.messageOwner.from_id instanceof TLRPC$TL_peerChannel) && ChatObject.isChannel(chat) && chat.megagroup;
    }

    public boolean isForwardedChannelPost() {
        TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader;
        TLRPC$Message tLRPC$Message = this.messageOwner;
        TLRPC$Peer tLRPC$Peer = tLRPC$Message.from_id;
        if ((tLRPC$Peer instanceof TLRPC$TL_peerChannel) && (tLRPC$MessageFwdHeader = tLRPC$Message.fwd_from) != null && tLRPC$MessageFwdHeader.channel_post != 0) {
            TLRPC$Peer tLRPC$Peer2 = tLRPC$MessageFwdHeader.saved_from_peer;
            if ((tLRPC$Peer2 instanceof TLRPC$TL_peerChannel) && tLRPC$Peer.channel_id == tLRPC$Peer2.channel_id) {
                return true;
            }
        }
        return false;
    }

    public boolean isUnread() {
        return this.messageOwner.unread;
    }

    public boolean isContentUnread() {
        return this.messageOwner.media_unread;
    }

    public void setIsRead() {
        this.messageOwner.unread = false;
    }

    public int getUnradFlags() {
        return getUnreadFlags(this.messageOwner);
    }

    public static int getUnreadFlags(TLRPC$Message message) {
        int i = !message.unread ? 1 : 0;
        return !message.media_unread ? i | 2 : i;
    }

    public void setContentIsRead() {
        this.messageOwner.media_unread = false;
    }

    public int getId() {
        return this.messageOwner.id;
    }

    public int getRealId() {
        TLRPC$Message tLRPC$Message = this.messageOwner;
        int i = tLRPC$Message.realId;
        return i != 0 ? i : tLRPC$Message.id;
    }

    public static int getMessageSize(TLRPC$Message message) {
        TLRPC$Document tLRPC$Document;
        TLRPC$MessageMedia tLRPC$MessageMedia = message.media;
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) {
            tLRPC$Document = tLRPC$MessageMedia.webpage.document;
        } else if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaGame) {
            tLRPC$Document = tLRPC$MessageMedia.game.document;
        } else {
            tLRPC$Document = tLRPC$MessageMedia != null ? tLRPC$MessageMedia.document : null;
        }
        if (tLRPC$Document != null) {
            return tLRPC$Document.size;
        }
        return 0;
    }

    public int getSize() {
        return getMessageSize(this.messageOwner);
    }

    public static void fixMessagePeer(ArrayList<TLRPC$Message> messages, long channelId) {
        if (messages == null || messages.isEmpty() || channelId == 0) {
            return;
        }
        for (int i = 0; i < messages.size(); i++) {
            TLRPC$Message tLRPC$Message = messages.get(i);
            if (tLRPC$Message instanceof TLRPC$TL_messageEmpty) {
                TLRPC$TL_peerChannel tLRPC$TL_peerChannel = new TLRPC$TL_peerChannel();
                tLRPC$Message.peer_id = tLRPC$TL_peerChannel;
                tLRPC$TL_peerChannel.channel_id = channelId;
            }
        }
    }

    public long getChannelId() {
        return getChannelId(this.messageOwner);
    }

    public static long getChannelId(TLRPC$Message message) {
        TLRPC$Peer tLRPC$Peer = message.peer_id;
        if (tLRPC$Peer != null) {
            return tLRPC$Peer.channel_id;
        }
        return 0L;
    }

    public static boolean shouldEncryptPhotoOrVideo(TLRPC$Message message) {
        int i;
        if (message instanceof TLRPC$TL_message_secret) {
            return ((message.media instanceof TLRPC$TL_messageMediaPhoto) || isVideoMessage(message)) && (i = message.ttl) > 0 && i <= 60;
        }
        TLRPC$MessageMedia tLRPC$MessageMedia = message.media;
        return ((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) || (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaDocument)) && tLRPC$MessageMedia.ttl_seconds != 0;
    }

    public boolean shouldEncryptPhotoOrVideo() {
        return shouldEncryptPhotoOrVideo(this.messageOwner);
    }

    public static boolean isSecretPhotoOrVideo(TLRPC$Message message) {
        int i;
        if (message instanceof TLRPC$TL_message_secret) {
            return ((message.media instanceof TLRPC$TL_messageMediaPhoto) || isRoundVideoMessage(message) || isVideoMessage(message)) && (i = message.ttl) > 0 && i <= 60;
        }
        if (!(message instanceof TLRPC$TL_message)) {
            return false;
        }
        TLRPC$MessageMedia tLRPC$MessageMedia = message.media;
        return ((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) || (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaDocument)) && tLRPC$MessageMedia.ttl_seconds != 0;
    }

    public static boolean isSecretMedia(TLRPC$Message message) {
        if (message instanceof TLRPC$TL_message_secret) {
            return ((message.media instanceof TLRPC$TL_messageMediaPhoto) || isRoundVideoMessage(message) || isVideoMessage(message)) && message.media.ttl_seconds != 0;
        }
        if (!(message instanceof TLRPC$TL_message)) {
            return false;
        }
        TLRPC$MessageMedia tLRPC$MessageMedia = message.media;
        return ((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) || (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaDocument)) && tLRPC$MessageMedia.ttl_seconds != 0;
    }

    public boolean needDrawBluredPreview() {
        TLRPC$MessageMedia tLRPC$MessageMedia;
        TLRPC$Message tLRPC$Message = this.messageOwner;
        if (!(tLRPC$Message instanceof TLRPC$TL_message_secret)) {
            return (tLRPC$Message instanceof TLRPC$TL_message) && (tLRPC$MessageMedia = tLRPC$Message.media) != null && tLRPC$MessageMedia.ttl_seconds != 0 && ((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) || (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaDocument));
        }
        int iMax = Math.max(tLRPC$Message.ttl, tLRPC$Message.media.ttl_seconds);
        return iMax > 0 && ((((this.messageOwner.media instanceof TLRPC$TL_messageMediaPhoto) || isVideo() || isGif()) && iMax <= 60) || isRoundVideo());
    }

    public boolean isSecretMedia() {
        TLRPC$MessageMedia tLRPC$MessageMedia;
        int i;
        TLRPC$Message tLRPC$Message = this.messageOwner;
        return tLRPC$Message instanceof TLRPC$TL_message_secret ? (((tLRPC$Message.media instanceof TLRPC$TL_messageMediaPhoto) || isGif()) && (i = this.messageOwner.ttl) > 0 && i <= 60) || isVoice() || isRoundVideo() || isVideo() : (tLRPC$Message instanceof TLRPC$TL_message) && (tLRPC$MessageMedia = tLRPC$Message.media) != null && tLRPC$MessageMedia.ttl_seconds != 0 && ((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) || (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaDocument));
    }

    public static void setUnreadFlags(TLRPC$Message message, int flag) {
        message.unread = (flag & 1) == 0;
        message.media_unread = (flag & 2) == 0;
    }

    public static boolean isUnread(TLRPC$Message message) {
        return message.unread;
    }

    public static boolean isContentUnread(TLRPC$Message message) {
        return message.media_unread;
    }

    public boolean isSavedFromMegagroup() {
        TLRPC$Peer tLRPC$Peer;
        TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = this.messageOwner.fwd_from;
        if (tLRPC$MessageFwdHeader == null || (tLRPC$Peer = tLRPC$MessageFwdHeader.saved_from_peer) == null || tLRPC$Peer.channel_id == 0) {
            return false;
        }
        return ChatObject.isMegagroup(MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(this.messageOwner.fwd_from.saved_from_peer.channel_id)));
    }

    public static boolean isOut(TLRPC$Message message) {
        return message.out;
    }

    public long getDialogId() {
        return getDialogId(this.messageOwner);
    }

    public boolean canStreamVideo() {
        TLRPC$Document document = getDocument();
        if (document == null || (document instanceof TLRPC$TL_documentEncrypted)) {
            return false;
        }
        if (SharedConfig.streamAllVideo || this.drawFullWith == 1) {
            return true;
        }
        for (int i = 0; i < document.attributes.size(); i++) {
            TLRPC$DocumentAttribute tLRPC$DocumentAttribute = document.attributes.get(i);
            if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeVideo) {
                return tLRPC$DocumentAttribute.supports_streaming;
            }
        }
        return SharedConfig.streamMkv && "video/x-matroska".equals(document.mime_type);
    }

    public static long getDialogId(TLRPC$Message message) {
        TLRPC$Peer tLRPC$Peer;
        if (message.dialog_id == 0 && (tLRPC$Peer = message.peer_id) != null) {
            long j = tLRPC$Peer.chat_id;
            if (j != 0) {
                message.dialog_id = -j;
            } else {
                long j2 = tLRPC$Peer.channel_id;
                if (j2 != 0) {
                    message.dialog_id = -j2;
                } else if (message.from_id == null || isOut(message)) {
                    message.dialog_id = message.peer_id.user_id;
                } else {
                    message.dialog_id = message.from_id.user_id;
                }
            }
        }
        return message.dialog_id;
    }

    public boolean isSending() {
        TLRPC$Message tLRPC$Message = this.messageOwner;
        return tLRPC$Message.send_state == 1 && tLRPC$Message.id < 0;
    }

    public boolean isEditing() {
        TLRPC$Message tLRPC$Message = this.messageOwner;
        return tLRPC$Message.send_state == 3 && tLRPC$Message.id > 0;
    }

    public boolean isEditingMedia() {
        TLRPC$MessageMedia tLRPC$MessageMedia = this.messageOwner.media;
        return tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto ? tLRPC$MessageMedia.photo.id == 0 : (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaDocument) && tLRPC$MessageMedia.document.dc_id == 0;
    }

    public boolean isSendError() {
        TLRPC$Message tLRPC$Message = this.messageOwner;
        return (tLRPC$Message.send_state == 2 && tLRPC$Message.id < 0) || (this.scheduled && tLRPC$Message.id > 0 && tLRPC$Message.date < ConnectionsManager.getInstance(this.currentAccount).getCurrentTime() + (-60));
    }

    public boolean isSent() {
        TLRPC$Message tLRPC$Message = this.messageOwner;
        return tLRPC$Message.send_state == 0 || tLRPC$Message.id > 0;
    }

    public int getSecretTimeLeft() {
        TLRPC$Message tLRPC$Message = this.messageOwner;
        int i = tLRPC$Message.ttl;
        int i2 = tLRPC$Message.destroyTime;
        return i2 != 0 ? Math.max(0, i2 - ConnectionsManager.getInstance(this.currentAccount).getCurrentTime()) : i;
    }

    public String getSecretTimeString() {
        if (!isSecretMedia()) {
            return null;
        }
        int secretTimeLeft = getSecretTimeLeft();
        if (secretTimeLeft < 60) {
            return secretTimeLeft + "s";
        }
        return (secretTimeLeft / 60) + "m";
    }

    public String getDocumentName() {
        return FileLoader.getDocumentFileName(getDocument());
    }

    public static boolean isStickerDocument(TLRPC$Document document) {
        if (document != null) {
            for (int i = 0; i < document.attributes.size(); i++) {
                if (document.attributes.get(i) instanceof TLRPC$TL_documentAttributeSticker) {
                    return "image/webp".equals(document.mime_type);
                }
            }
        }
        return false;
    }

    public static boolean isStickerHasSet(TLRPC$Document document) {
        if (document != null) {
            for (int i = 0; i < document.attributes.size(); i++) {
                TLRPC$DocumentAttribute tLRPC$DocumentAttribute = document.attributes.get(i);
                if ((tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeSticker) && tLRPC$DocumentAttribute.stickerset != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isAnimatedStickerDocument(TLRPC$Document document, boolean allowWithoutSet) {
        if (document != null && (("application/x-tgsticker".equals(document.mime_type) && !document.thumbs.isEmpty()) || "application/x-tgsdice".equals(document.mime_type))) {
            if (allowWithoutSet) {
                return true;
            }
            int size = document.attributes.size();
            for (int i = 0; i < size; i++) {
                TLRPC$DocumentAttribute tLRPC$DocumentAttribute = document.attributes.get(i);
                if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeSticker) {
                    return tLRPC$DocumentAttribute.stickerset instanceof TLRPC$TL_inputStickerSetShortName;
                }
            }
        }
        return false;
    }

    public static boolean canAutoplayAnimatedSticker(TLRPC$Document document) {
        return isAnimatedStickerDocument(document, true) && SharedConfig.getDevicePerformanceClass() != 0;
    }

    public static boolean isMaskDocument(TLRPC$Document document) {
        if (document != null) {
            for (int i = 0; i < document.attributes.size(); i++) {
                TLRPC$DocumentAttribute tLRPC$DocumentAttribute = document.attributes.get(i);
                if ((tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeSticker) && tLRPC$DocumentAttribute.mask) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isVoiceDocument(TLRPC$Document document) {
        if (document != null) {
            for (int i = 0; i < document.attributes.size(); i++) {
                TLRPC$DocumentAttribute tLRPC$DocumentAttribute = document.attributes.get(i);
                if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeAudio) {
                    return tLRPC$DocumentAttribute.voice;
                }
            }
        }
        return false;
    }

    public static boolean isVoiceWebDocument(WebFile webDocument) {
        return webDocument != null && webDocument.mime_type.equals("audio/ogg");
    }

    public static boolean isImageWebDocument(WebFile webDocument) {
        return (webDocument == null || isGifDocument(webDocument) || !webDocument.mime_type.startsWith("image/")) ? false : true;
    }

    public static boolean isVideoWebDocument(WebFile webDocument) {
        return webDocument != null && webDocument.mime_type.startsWith("video/");
    }

    public static boolean isMusicDocument(TLRPC$Document document) {
        if (document != null) {
            for (int i = 0; i < document.attributes.size(); i++) {
                if (document.attributes.get(i) instanceof TLRPC$TL_documentAttributeAudio) {
                    return !r2.voice;
                }
            }
            if (!TextUtils.isEmpty(document.mime_type)) {
                String lowerCase = document.mime_type.toLowerCase();
                if (lowerCase.equals("audio/flac") || lowerCase.equals("audio/ogg") || lowerCase.equals("audio/opus") || lowerCase.equals("audio/x-opus+ogg") || (lowerCase.equals("application/octet-stream") && FileLoader.getDocumentFileName(document).endsWith(".opus"))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static TLRPC$VideoSize getDocumentVideoThumb(TLRPC$Document document) {
        if (document == null || document.video_thumbs.isEmpty()) {
            return null;
        }
        return document.video_thumbs.get(0);
    }

    public static boolean isVideoDocument(TLRPC$Document document) {
        if (document == null) {
            return false;
        }
        boolean z = false;
        int i = 0;
        int i2 = 0;
        boolean z2 = false;
        for (int i3 = 0; i3 < document.attributes.size(); i3++) {
            TLRPC$DocumentAttribute tLRPC$DocumentAttribute = document.attributes.get(i3);
            if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeVideo) {
                if (tLRPC$DocumentAttribute.round_message) {
                    return false;
                }
                i = tLRPC$DocumentAttribute.w;
                i2 = tLRPC$DocumentAttribute.h;
                z2 = true;
            } else if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeAnimated) {
                z = true;
            }
        }
        if (z && (i > 1280 || i2 > 1280)) {
            z = false;
        }
        if (SharedConfig.streamMkv && !z2 && "video/x-matroska".equals(document.mime_type)) {
            z2 = true;
        }
        return z2 && !z;
    }

    public TLRPC$Document getDocument() {
        return getDocument(this.messageOwner);
    }

    public static TLRPC$Document getDocument(TLRPC$Message message) {
        TLRPC$MessageMedia tLRPC$MessageMedia = message.media;
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) {
            return tLRPC$MessageMedia.webpage.document;
        }
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaGame) {
            return tLRPC$MessageMedia.game.document;
        }
        if (tLRPC$MessageMedia != null) {
            return tLRPC$MessageMedia.document;
        }
        return null;
    }

    public static TLRPC$Photo getPhoto(TLRPC$Message message) {
        TLRPC$MessageMedia tLRPC$MessageMedia = message.media;
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) {
            return tLRPC$MessageMedia.webpage.photo;
        }
        if (tLRPC$MessageMedia != null) {
            return tLRPC$MessageMedia.photo;
        }
        return null;
    }

    public static boolean isStickerMessage(TLRPC$Message message) {
        TLRPC$MessageMedia tLRPC$MessageMedia = message.media;
        return tLRPC$MessageMedia != null && isStickerDocument(tLRPC$MessageMedia.document);
    }

    public static boolean isAnimatedStickerMessage(TLRPC$Message message) {
        TLRPC$MessageMedia tLRPC$MessageMedia;
        boolean zIsEncryptedDialog = DialogObject.isEncryptedDialog(message.dialog_id);
        if ((!zIsEncryptedDialog || message.stickerVerified == 1) && (tLRPC$MessageMedia = message.media) != null) {
            return isAnimatedStickerDocument(tLRPC$MessageMedia.document, !zIsEncryptedDialog || message.out);
        }
        return false;
    }

    public static boolean isLocationMessage(TLRPC$Message message) {
        TLRPC$MessageMedia tLRPC$MessageMedia = message.media;
        return (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaGeo) || (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaGeoLive) || (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaVenue);
    }

    public static boolean isMaskMessage(TLRPC$Message message) {
        TLRPC$MessageMedia tLRPC$MessageMedia = message.media;
        return tLRPC$MessageMedia != null && isMaskDocument(tLRPC$MessageMedia.document);
    }

    public static boolean isMusicMessage(TLRPC$Message message) {
        TLRPC$MessageMedia tLRPC$MessageMedia = message.media;
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) {
            return isMusicDocument(tLRPC$MessageMedia.webpage.document);
        }
        return tLRPC$MessageMedia != null && isMusicDocument(tLRPC$MessageMedia.document);
    }

    public static boolean isGifMessage(TLRPC$Message message) {
        TLRPC$MessageMedia tLRPC$MessageMedia = message.media;
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) {
            return isGifDocument(tLRPC$MessageMedia.webpage.document);
        }
        if (tLRPC$MessageMedia != null) {
            if (isGifDocument(tLRPC$MessageMedia.document, message.grouped_id != 0)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isRoundVideoMessage(TLRPC$Message message) {
        TLRPC$MessageMedia tLRPC$MessageMedia = message.media;
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) {
            return isRoundVideoDocument(tLRPC$MessageMedia.webpage.document);
        }
        return tLRPC$MessageMedia != null && isRoundVideoDocument(tLRPC$MessageMedia.document);
    }

    public static boolean isPhoto(TLRPC$Message message) {
        TLRPC$MessageMedia tLRPC$MessageMedia = message.media;
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) {
            TLRPC$WebPage tLRPC$WebPage = tLRPC$MessageMedia.webpage;
            return (tLRPC$WebPage.photo instanceof TLRPC$TL_photo) && !(tLRPC$WebPage.document instanceof TLRPC$TL_document);
        }
        return tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto;
    }

    public static boolean isVoiceMessage(TLRPC$Message message) {
        TLRPC$MessageMedia tLRPC$MessageMedia = message.media;
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) {
            return isVoiceDocument(tLRPC$MessageMedia.webpage.document);
        }
        return tLRPC$MessageMedia != null && isVoiceDocument(tLRPC$MessageMedia.document);
    }

    public static boolean isNewGifMessage(TLRPC$Message message) {
        TLRPC$MessageMedia tLRPC$MessageMedia = message.media;
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) {
            return isNewGifDocument(tLRPC$MessageMedia.webpage.document);
        }
        return tLRPC$MessageMedia != null && isNewGifDocument(tLRPC$MessageMedia.document);
    }

    public static boolean isLiveLocationMessage(TLRPC$Message message) {
        return message.media instanceof TLRPC$TL_messageMediaGeoLive;
    }

    public static boolean isVideoMessage(TLRPC$Message message) {
        TLRPC$MessageMedia tLRPC$MessageMedia = message.media;
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) {
            return isVideoDocument(tLRPC$MessageMedia.webpage.document);
        }
        return tLRPC$MessageMedia != null && isVideoDocument(tLRPC$MessageMedia.document);
    }

    public static boolean isGameMessage(TLRPC$Message message) {
        return message.media instanceof TLRPC$TL_messageMediaGame;
    }

    public static boolean isInvoiceMessage(TLRPC$Message message) {
        return message.media instanceof TLRPC$TL_messageMediaInvoice;
    }

    public static TLRPC$InputStickerSet getInputStickerSet(TLRPC$Message message) {
        TLRPC$Document document = getDocument(message);
        if (document != null) {
            return getInputStickerSet(document);
        }
        return null;
    }

    public static TLRPC$InputStickerSet getInputStickerSet(TLRPC$Document document) {
        if (document == null) {
            return null;
        }
        int size = document.attributes.size();
        for (int i = 0; i < size; i++) {
            TLRPC$DocumentAttribute tLRPC$DocumentAttribute = document.attributes.get(i);
            if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeSticker) {
                TLRPC$InputStickerSet tLRPC$InputStickerSet = tLRPC$DocumentAttribute.stickerset;
                if (tLRPC$InputStickerSet instanceof TLRPC$TL_inputStickerSetEmpty) {
                    return null;
                }
                return tLRPC$InputStickerSet;
            }
        }
        return null;
    }

    public static long getStickerSetId(TLRPC$Document document) {
        if (document == null) {
            return -1L;
        }
        for (int i = 0; i < document.attributes.size(); i++) {
            TLRPC$DocumentAttribute tLRPC$DocumentAttribute = document.attributes.get(i);
            if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeSticker) {
                TLRPC$InputStickerSet tLRPC$InputStickerSet = tLRPC$DocumentAttribute.stickerset;
                if (tLRPC$InputStickerSet instanceof TLRPC$TL_inputStickerSetEmpty) {
                    return -1L;
                }
                return tLRPC$InputStickerSet.id;
            }
        }
        return -1L;
    }

    public static String getStickerSetName(TLRPC$Document document) {
        if (document == null) {
            return null;
        }
        for (int i = 0; i < document.attributes.size(); i++) {
            TLRPC$DocumentAttribute tLRPC$DocumentAttribute = document.attributes.get(i);
            if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeSticker) {
                TLRPC$InputStickerSet tLRPC$InputStickerSet = tLRPC$DocumentAttribute.stickerset;
                if (tLRPC$InputStickerSet instanceof TLRPC$TL_inputStickerSetEmpty) {
                    return null;
                }
                return tLRPC$InputStickerSet.short_name;
            }
        }
        return null;
    }

    public String getStickerChar() {
        TLRPC$Document document = getDocument();
        if (document == null) {
            return null;
        }
        Iterator<TLRPC$DocumentAttribute> it = document.attributes.iterator();
        while (it.hasNext()) {
            TLRPC$DocumentAttribute next = it.next();
            if (next instanceof TLRPC$TL_documentAttributeSticker) {
                return next.alt;
            }
        }
        return null;
    }

    public int getApproximateHeight() {
        int minTabletSide;
        int i;
        int iMin;
        int iMin2;
        int i2 = this.type;
        int iDp = 0;
        if (i2 == 0) {
            int i3 = this.textHeight;
            TLRPC$MessageMedia tLRPC$MessageMedia = this.messageOwner.media;
            if ((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) && (tLRPC$MessageMedia.webpage instanceof TLRPC$TL_webPage)) {
                iDp = AndroidUtilities.dp(100.0f);
            }
            int i4 = i3 + iDp;
            return isReply() ? i4 + AndroidUtilities.dp(42.0f) : i4;
        }
        if (i2 == 2) {
            return AndroidUtilities.dp(72.0f);
        }
        if (i2 == 12) {
            return AndroidUtilities.dp(71.0f);
        }
        if (i2 == 9) {
            return AndroidUtilities.dp(100.0f);
        }
        if (i2 == 4) {
            return AndroidUtilities.dp(114.0f);
        }
        if (i2 == 14) {
            return AndroidUtilities.dp(82.0f);
        }
        if (i2 == 10) {
            return AndroidUtilities.dp(30.0f);
        }
        if (i2 == 11) {
            return AndroidUtilities.dp(50.0f);
        }
        if (i2 == 5) {
            return AndroidUtilities.roundMessageSize;
        }
        if (i2 == 13 || i2 == 15) {
            float f = AndroidUtilities.displaySize.y * 0.4f;
            if (AndroidUtilities.isTablet()) {
                minTabletSide = AndroidUtilities.getMinTabletSide();
            } else {
                minTabletSide = AndroidUtilities.displaySize.x;
            }
            float f2 = minTabletSide * 0.5f;
            TLRPC$Document document = getDocument();
            int size = document.attributes.size();
            int i5 = 0;
            while (true) {
                if (i5 >= size) {
                    i = 0;
                    break;
                }
                TLRPC$DocumentAttribute tLRPC$DocumentAttribute = document.attributes.get(i5);
                if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeImageSize) {
                    iDp = tLRPC$DocumentAttribute.w;
                    i = tLRPC$DocumentAttribute.h;
                    break;
                }
                i5++;
            }
            if (iDp == 0) {
                i = (int) f;
                iDp = AndroidUtilities.dp(100.0f) + i;
            }
            float f3 = i;
            if (f3 > f) {
                iDp = (int) (iDp * (f / f3));
                i = (int) f;
            }
            float f4 = iDp;
            if (f4 > f2) {
                i = (int) (i * (f2 / f4));
            }
            return i + AndroidUtilities.dp(14.0f);
        }
        if (AndroidUtilities.isTablet()) {
            iMin = AndroidUtilities.getMinTabletSide();
        } else {
            Point point = AndroidUtilities.displaySize;
            iMin = Math.min(point.x, point.y);
        }
        int photoSize = (int) (iMin * 0.7f);
        int iDp2 = AndroidUtilities.dp(100.0f) + photoSize;
        if (photoSize > AndroidUtilities.getPhotoSize()) {
            photoSize = AndroidUtilities.getPhotoSize();
        }
        if (iDp2 > AndroidUtilities.getPhotoSize()) {
            iDp2 = AndroidUtilities.getPhotoSize();
        }
        if (FileLoader.getClosestPhotoSizeWithSize(this.photoThumbs, AndroidUtilities.getPhotoSize()) != null) {
            int iDp3 = (int) (r3.h / (r3.w / photoSize));
            if (iDp3 == 0) {
                iDp3 = AndroidUtilities.dp(100.0f);
            }
            if (iDp3 <= iDp2) {
                iDp2 = iDp3 < AndroidUtilities.dp(120.0f) ? AndroidUtilities.dp(120.0f) : iDp3;
            }
            if (needDrawBluredPreview()) {
                if (AndroidUtilities.isTablet()) {
                    iMin2 = AndroidUtilities.getMinTabletSide();
                } else {
                    Point point2 = AndroidUtilities.displaySize;
                    iMin2 = Math.min(point2.x, point2.y);
                }
                iDp2 = (int) (iMin2 * 0.5f);
            }
        }
        return iDp2 + AndroidUtilities.dp(14.0f);
    }

    private int getParentWidth() {
        int i;
        return (!this.preview || (i = this.parentWidth) <= 0) ? AndroidUtilities.displaySize.x : i;
    }

    public String getStickerEmoji() {
        TLRPC$Document document = getDocument();
        if (document == null) {
            return null;
        }
        for (int i = 0; i < document.attributes.size(); i++) {
            TLRPC$DocumentAttribute tLRPC$DocumentAttribute = document.attributes.get(i);
            if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeSticker) {
                String str = tLRPC$DocumentAttribute.alt;
                if (str == null || str.length() <= 0) {
                    return null;
                }
                return tLRPC$DocumentAttribute.alt;
            }
        }
        return null;
    }

    public boolean isVideoCall() {
        TLRPC$MessageAction tLRPC$MessageAction = this.messageOwner.action;
        return (tLRPC$MessageAction instanceof TLRPC$TL_messageActionPhoneCall) && tLRPC$MessageAction.video;
    }

    public boolean isAnimatedEmoji() {
        return this.emojiAnimatedSticker != null;
    }

    public boolean isDice() {
        return this.messageOwner.media instanceof TLRPC$TL_messageMediaDice;
    }

    public String getDiceEmoji() {
        if (!isDice()) {
            return null;
        }
        TLRPC$TL_messageMediaDice tLRPC$TL_messageMediaDice = (TLRPC$TL_messageMediaDice) this.messageOwner.media;
        return TextUtils.isEmpty(tLRPC$TL_messageMediaDice.emoticon) ? "🎲" : tLRPC$TL_messageMediaDice.emoticon.replace("️", "");
    }

    public int getDiceValue() {
        TLRPC$MessageMedia tLRPC$MessageMedia = this.messageOwner.media;
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaDice) {
            return ((TLRPC$TL_messageMediaDice) tLRPC$MessageMedia).value;
        }
        return -1;
    }

    public boolean isSticker() {
        int i = this.type;
        if (i != 1000) {
            return i == 13;
        }
        return isStickerDocument(getDocument());
    }

    public boolean isAnimatedSticker() {
        int i = this.type;
        if (i != 1000) {
            return i == 15;
        }
        boolean zIsEncryptedDialog = DialogObject.isEncryptedDialog(getDialogId());
        if (!zIsEncryptedDialog || this.messageOwner.stickerVerified == 1) {
            return isAnimatedStickerDocument(getDocument(), (this.emojiAnimatedSticker == null && zIsEncryptedDialog && !isOut()) ? false : true);
        }
        return false;
    }

    public boolean isAnyKindOfSticker() {
        int i = this.type;
        return i == 13 || i == 15;
    }

    public boolean shouldDrawWithoutBackground() {
        int i = this.type;
        return i == 13 || i == 15 || i == 5;
    }

    public boolean isLocation() {
        return isLocationMessage(this.messageOwner);
    }

    public boolean isMask() {
        return isMaskMessage(this.messageOwner);
    }

    public boolean isMusic() {
        return isMusicMessage(this.messageOwner);
    }

    public boolean isDocument() {
        return (getDocument() == null || isVideo() || isMusic() || isVoice() || isAnyKindOfSticker()) ? false : true;
    }

    public boolean isVoice() {
        return isVoiceMessage(this.messageOwner);
    }

    public boolean isVideo() {
        return isVideoMessage(this.messageOwner);
    }

    public boolean isPhoto() {
        return isPhoto(this.messageOwner);
    }

    public boolean isLiveLocation() {
        return isLiveLocationMessage(this.messageOwner);
    }

    public boolean isExpiredLiveLocation(int date) {
        TLRPC$Message tLRPC$Message = this.messageOwner;
        return tLRPC$Message.date + tLRPC$Message.media.period <= date;
    }

    public boolean isGame() {
        return isGameMessage(this.messageOwner);
    }

    public boolean isInvoice() {
        return isInvoiceMessage(this.messageOwner);
    }

    public boolean isRoundVideo() {
        if (this.isRoundVideoCached == 0) {
            this.isRoundVideoCached = (this.type == 5 || isRoundVideoMessage(this.messageOwner)) ? 1 : 2;
        }
        return this.isRoundVideoCached == 1;
    }

    public boolean shouldAnimateSending() {
        return isSending() && (this.type == 5 || isVoice() || ((isAnyKindOfSticker() && this.sendAnimationData != null) || !(this.messageText == null || this.sendAnimationData == null)));
    }

    public boolean hasAttachedStickers() {
        TLRPC$MessageMedia tLRPC$MessageMedia = this.messageOwner.media;
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) {
            TLRPC$Photo tLRPC$Photo = tLRPC$MessageMedia.photo;
            return tLRPC$Photo != null && tLRPC$Photo.has_stickers;
        }
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaDocument) {
            return isDocumentHasAttachedStickers(tLRPC$MessageMedia.document);
        }
        return false;
    }

    public static boolean isDocumentHasAttachedStickers(TLRPC$Document document) {
        if (document != null) {
            for (int i = 0; i < document.attributes.size(); i++) {
                if (document.attributes.get(i) instanceof TLRPC$TL_documentAttributeHasStickers) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isGif() {
        return isGifMessage(this.messageOwner);
    }

    public boolean isWebpageDocument() {
        TLRPC$Document tLRPC$Document;
        TLRPC$MessageMedia tLRPC$MessageMedia = this.messageOwner.media;
        return (!(tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) || (tLRPC$Document = tLRPC$MessageMedia.webpage.document) == null || isGifDocument(tLRPC$Document)) ? false : true;
    }

    public boolean isWebpage() {
        return this.messageOwner.media instanceof TLRPC$TL_messageMediaWebPage;
    }

    public boolean isNewGif() {
        return this.messageOwner.media != null && isNewGifDocument(getDocument());
    }

    public boolean isAndroidTheme() {
        TLRPC$WebPage tLRPC$WebPage;
        TLRPC$MessageMedia tLRPC$MessageMedia = this.messageOwner.media;
        if (tLRPC$MessageMedia != null && (tLRPC$WebPage = tLRPC$MessageMedia.webpage) != null && !tLRPC$WebPage.attributes.isEmpty()) {
            int size = this.messageOwner.media.webpage.attributes.size();
            for (int i = 0; i < size; i++) {
                TLRPC$TL_webPageAttributeTheme tLRPC$TL_webPageAttributeTheme = this.messageOwner.media.webpage.attributes.get(i);
                ArrayList<TLRPC$Document> arrayList = tLRPC$TL_webPageAttributeTheme.documents;
                int size2 = arrayList.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    if ("application/x-tgtheme-android".equals(arrayList.get(i2).mime_type)) {
                        return true;
                    }
                }
                if (tLRPC$TL_webPageAttributeTheme.settings != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getMusicTitle() {
        return getMusicTitle(true);
    }

    public String getMusicTitle(boolean unknown) {
        TLRPC$Document document = getDocument();
        if (document != null) {
            for (int i = 0; i < document.attributes.size(); i++) {
                TLRPC$DocumentAttribute tLRPC$DocumentAttribute = document.attributes.get(i);
                if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeAudio) {
                    if (tLRPC$DocumentAttribute.voice) {
                        if (unknown) {
                            return LocaleController.formatDateAudio(this.messageOwner.date, true);
                        }
                        return null;
                    }
                    String str = tLRPC$DocumentAttribute.title;
                    if (str != null && str.length() != 0) {
                        return str;
                    }
                    String documentFileName = FileLoader.getDocumentFileName(document);
                    return (TextUtils.isEmpty(documentFileName) && unknown) ? LocaleController.getString("AudioUnknownTitle", R.string.AudioUnknownTitle) : documentFileName;
                }
                if ((tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeVideo) && tLRPC$DocumentAttribute.round_message) {
                    return LocaleController.formatDateAudio(this.messageOwner.date, true);
                }
            }
            String documentFileName2 = FileLoader.getDocumentFileName(document);
            if (!TextUtils.isEmpty(documentFileName2)) {
                return documentFileName2;
            }
        }
        return LocaleController.getString("AudioUnknownTitle", R.string.AudioUnknownTitle);
    }

    public int getDuration() {
        TLRPC$Document document = getDocument();
        if (document == null) {
            return 0;
        }
        int i = this.audioPlayerDuration;
        if (i > 0) {
            return i;
        }
        for (int i2 = 0; i2 < document.attributes.size(); i2++) {
            TLRPC$DocumentAttribute tLRPC$DocumentAttribute = document.attributes.get(i2);
            if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeAudio) {
                return tLRPC$DocumentAttribute.duration;
            }
            if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeVideo) {
                return tLRPC$DocumentAttribute.duration;
            }
        }
        return this.audioPlayerDuration;
    }

    public String getArtworkUrl(boolean small) {
        TLRPC$Document document = getDocument();
        if (document == null || "audio/ogg".equals(document.mime_type)) {
            return null;
        }
        int size = document.attributes.size();
        for (int i = 0; i < size; i++) {
            TLRPC$DocumentAttribute tLRPC$DocumentAttribute = document.attributes.get(i);
            if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeAudio) {
                if (tLRPC$DocumentAttribute.voice) {
                    return null;
                }
                String strReplace = tLRPC$DocumentAttribute.performer;
                String str = tLRPC$DocumentAttribute.title;
                if (!TextUtils.isEmpty(strReplace)) {
                    int i2 = 0;
                    while (true) {
                        String[] strArr = excludeWords;
                        if (i2 >= strArr.length) {
                            break;
                        }
                        strReplace = strReplace.replace(strArr[i2], " ");
                        i2++;
                    }
                }
                if (TextUtils.isEmpty(strReplace) && TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("athumb://itunes.apple.com/search?term=");
                    sb.append(URLEncoder.encode(strReplace + " - " + str, "UTF-8"));
                    sb.append("&entity=song&limit=4");
                    sb.append(small ? "&s=1" : "");
                    return sb.toString();
                } catch (Exception unused) {
                    continue;
                }
            }
        }
        return null;
    }

    public String getMusicAuthor() {
        return getMusicAuthor(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0158 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String getMusicAuthor(boolean r13) {
        /*
            Method dump skipped, instructions count: 353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessageObject.getMusicAuthor(boolean):java.lang.String");
    }

    public TLRPC$InputStickerSet getInputStickerSet() {
        return getInputStickerSet(this.messageOwner);
    }

    public boolean isForwarded() {
        return isForwardedMessage(this.messageOwner);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean needDrawForwarded() {
        /*
            r5 = this;
            ir.eitaa.tgnet.TLRPC$Message r0 = r5.messageOwner
            int r1 = r0.flags
            r1 = r1 & 4
            if (r1 == 0) goto L36
            ir.eitaa.tgnet.TLRPC$MessageFwdHeader r0 = r0.fwd_from
            if (r0 == 0) goto L36
            boolean r1 = r0.imported
            if (r1 != 0) goto L36
            ir.eitaa.tgnet.TLRPC$Peer r1 = r0.saved_from_peer
            if (r1 == 0) goto L22
            ir.eitaa.tgnet.TLRPC$Peer r0 = r0.from_id
            boolean r2 = r0 instanceof ir.eitaa.tgnet.TLRPC$TL_peerChannel
            if (r2 == 0) goto L36
            long r1 = r1.channel_id
            long r3 = r0.channel_id
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 == 0) goto L36
        L22:
            int r0 = r5.currentAccount
            ir.eitaa.messenger.UserConfig r0 = ir.eitaa.messenger.UserConfig.getInstance(r0)
            long r0 = r0.getClientUserId()
            long r2 = r5.getDialogId()
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L36
            r0 = 1
            goto L37
        L36:
            r0 = 0
        L37:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.MessageObject.needDrawForwarded():boolean");
    }

    public static boolean isForwardedMessage(TLRPC$Message message) {
        return ((message.flags & 4) == 0 || message.fwd_from == null) ? false : true;
    }

    public boolean isReply() {
        TLRPC$Message tLRPC$Message;
        TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader;
        MessageObject messageObject = this.replyMessageObject;
        return ((messageObject != null && (messageObject.messageOwner instanceof TLRPC$TL_messageEmpty)) || (tLRPC$TL_messageReplyHeader = (tLRPC$Message = this.messageOwner).reply_to) == null || (tLRPC$TL_messageReplyHeader.reply_to_msg_id == 0 && tLRPC$TL_messageReplyHeader.reply_to_random_id == 0) || (tLRPC$Message.flags & 8) == 0) ? false : true;
    }

    public boolean isMediaEmpty() {
        return isMediaEmpty(this.messageOwner);
    }

    public boolean isMediaEmptyWebpage() {
        return isMediaEmptyWebpage(this.messageOwner);
    }

    public static boolean isMediaEmpty(TLRPC$Message message) {
        TLRPC$MessageMedia tLRPC$MessageMedia;
        return message == null || (tLRPC$MessageMedia = message.media) == null || (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaEmpty) || (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage);
    }

    public static boolean isMediaEmptyWebpage(TLRPC$Message message) {
        TLRPC$MessageMedia tLRPC$MessageMedia;
        return message == null || (tLRPC$MessageMedia = message.media) == null || (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaEmpty);
    }

    public boolean canViewThread() {
        MessageObject messageObject;
        if (this.messageOwner.action != null) {
            return false;
        }
        return hasReplies() || !(((messageObject = this.replyMessageObject) == null || messageObject.messageOwner.replies == null) && getReplyTopMsgId() == 0);
    }

    public boolean isComments() {
        TLRPC$MessageReplies tLRPC$MessageReplies = this.messageOwner.replies;
        return tLRPC$MessageReplies != null && tLRPC$MessageReplies.comments;
    }

    public boolean isLinkedToChat(long chatId) {
        TLRPC$MessageReplies tLRPC$MessageReplies = this.messageOwner.replies;
        return tLRPC$MessageReplies != null && (chatId == 0 || tLRPC$MessageReplies.channel_id == chatId);
    }

    public int getRepliesCount() {
        TLRPC$MessageReplies tLRPC$MessageReplies = this.messageOwner.replies;
        if (tLRPC$MessageReplies != null) {
            return tLRPC$MessageReplies.replies;
        }
        return 0;
    }

    public boolean canEditMessage(TLRPC$Chat chat) {
        return canEditMessage(this.currentAccount, this.messageOwner, chat, this.scheduled);
    }

    public boolean canEditMessageScheduleTime(TLRPC$Chat chat) {
        return canEditMessageScheduleTime(this.currentAccount, this.messageOwner, chat);
    }

    public boolean canForwardMessage() {
        return ((this.messageOwner instanceof TLRPC$TL_message_secret) || needDrawBluredPreview() || isLiveLocation() || this.type == 16 || isSponsored()) ? false : true;
    }

    public boolean canEditMedia() {
        if (isSecretMedia()) {
            return false;
        }
        TLRPC$MessageMedia tLRPC$MessageMedia = this.messageOwner.media;
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) {
            return true;
        }
        return (!(tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaDocument) || isVoice() || isSticker() || isAnimatedSticker() || isRoundVideo()) ? false : true;
    }

    public boolean canEditMessageAnytime(TLRPC$Chat chat) {
        return canEditMessageAnytime(this.currentAccount, this.messageOwner, chat);
    }

    public static boolean canEditMessageAnytime(int currentAccount, TLRPC$Message message, TLRPC$Chat chat) {
        TLRPC$MessageMedia tLRPC$MessageMedia;
        TLRPC$MessageAction tLRPC$MessageAction;
        TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights;
        TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights;
        TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights2;
        if (message != null && message.peer_id != null && (((tLRPC$MessageMedia = message.media) == null || (!isRoundVideoDocument(tLRPC$MessageMedia.document) && !isStickerDocument(message.media.document) && !isAnimatedStickerDocument(message.media.document, true))) && (((tLRPC$MessageAction = message.action) == null || (tLRPC$MessageAction instanceof TLRPC$TL_messageActionEmpty)) && !isForwardedMessage(message) && message.via_bot_id == 0 && message.id >= 0))) {
            TLRPC$Peer tLRPC$Peer = message.from_id;
            if (tLRPC$Peer instanceof TLRPC$TL_peerUser) {
                long j = tLRPC$Peer.user_id;
                if (j == message.peer_id.user_id && j == UserConfig.getInstance(currentAccount).getClientUserId() && !isLiveLocationMessage(message)) {
                    return true;
                }
            }
            if (chat == null && message.peer_id.channel_id != 0 && (chat = MessagesController.getInstance(UserConfig.selectedAccount).getChat(Long.valueOf(message.peer_id.channel_id))) == null) {
                return false;
            }
            if (ChatObject.isChannel(chat) && !chat.megagroup && (chat.creator || ((tLRPC$TL_chatAdminRights2 = chat.admin_rights) != null && tLRPC$TL_chatAdminRights2.edit_messages))) {
                return true;
            }
            if (message.out && chat != null && chat.megagroup && (chat.creator || (((tLRPC$TL_chatAdminRights = chat.admin_rights) != null && tLRPC$TL_chatAdminRights.pin_messages) || ((tLRPC$TL_chatBannedRights = chat.default_banned_rights) != null && !tLRPC$TL_chatBannedRights.pin_messages)))) {
                return true;
            }
        }
        return false;
    }

    public static boolean canEditMessageScheduleTime(int currentAccount, TLRPC$Message message, TLRPC$Chat chat) {
        if (chat == null && message.peer_id.channel_id != 0 && (chat = MessagesController.getInstance(currentAccount).getChat(Long.valueOf(message.peer_id.channel_id))) == null) {
            return false;
        }
        if (!ChatObject.isChannel(chat) || chat.megagroup || chat.creator) {
            return true;
        }
        TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights = chat.admin_rights;
        return tLRPC$TL_chatAdminRights != null && (tLRPC$TL_chatAdminRights.edit_messages || message.out);
    }

    public static boolean canEditMessage(int currentAccount, TLRPC$Message message, TLRPC$Chat chat, boolean scheduled) {
        TLRPC$MessageMedia tLRPC$MessageMedia;
        TLRPC$MessageAction tLRPC$MessageAction;
        TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights;
        TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights2;
        TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights;
        TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights3;
        if (scheduled && message.date < ConnectionsManager.getInstance(currentAccount).getCurrentTime() - 60) {
            return false;
        }
        if ((chat == null || ((!chat.left && !chat.kicked) || (chat.megagroup && chat.has_link))) && message != null && message.peer_id != null && (((tLRPC$MessageMedia = message.media) == null || (!isRoundVideoDocument(tLRPC$MessageMedia.document) && !isStickerDocument(message.media.document) && !isAnimatedStickerDocument(message.media.document, true) && !isLocationMessage(message))) && (((tLRPC$MessageAction = message.action) == null || (tLRPC$MessageAction instanceof TLRPC$TL_messageActionEmpty)) && !isForwardedMessage(message) && message.via_bot_id == 0 && message.id >= 0))) {
            TLRPC$Peer tLRPC$Peer = message.from_id;
            if (tLRPC$Peer instanceof TLRPC$TL_peerUser) {
                long j = tLRPC$Peer.user_id;
                if (j == message.peer_id.user_id && j == UserConfig.getInstance(currentAccount).getClientUserId() && !isLiveLocationMessage(message) && !(message.media instanceof TLRPC$TL_messageMediaContact)) {
                    return true;
                }
            }
            if (chat == null && message.peer_id.channel_id != 0 && (chat = MessagesController.getInstance(currentAccount).getChat(Long.valueOf(message.peer_id.channel_id))) == null) {
                return false;
            }
            TLRPC$MessageMedia tLRPC$MessageMedia2 = message.media;
            if (tLRPC$MessageMedia2 != null && !(tLRPC$MessageMedia2 instanceof TLRPC$TL_messageMediaEmpty) && !(tLRPC$MessageMedia2 instanceof TLRPC$TL_messageMediaPhoto) && !(tLRPC$MessageMedia2 instanceof TLRPC$TL_messageMediaDocument) && !(tLRPC$MessageMedia2 instanceof TLRPC$TL_messageMediaWebPage) && !(tLRPC$MessageMedia2 instanceof TLRPC$TL_messageMediaLiveStream)) {
                return false;
            }
            if (ChatObject.isChannel(chat) && !chat.megagroup && (chat.creator || ((tLRPC$TL_chatAdminRights3 = chat.admin_rights) != null && tLRPC$TL_chatAdminRights3.edit_messages))) {
                return true;
            }
            if (message.out && chat != null && chat.megagroup && (chat.creator || (((tLRPC$TL_chatAdminRights2 = chat.admin_rights) != null && tLRPC$TL_chatAdminRights2.pin_messages) || ((tLRPC$TL_chatBannedRights = chat.default_banned_rights) != null && !tLRPC$TL_chatBannedRights.pin_messages)))) {
                return true;
            }
            if (!scheduled && Math.abs(message.date - ConnectionsManager.getInstance(currentAccount).getCurrentTime()) > MessagesController.getInstance(currentAccount).maxEditTime) {
                return false;
            }
            if (message.peer_id.channel_id == 0) {
                if (!message.out) {
                    TLRPC$Peer tLRPC$Peer2 = message.from_id;
                    if (!(tLRPC$Peer2 instanceof TLRPC$TL_peerUser) || tLRPC$Peer2.user_id != UserConfig.getInstance(currentAccount).getClientUserId()) {
                        return false;
                    }
                }
                TLRPC$MessageMedia tLRPC$MessageMedia3 = message.media;
                if (!(tLRPC$MessageMedia3 instanceof TLRPC$TL_messageMediaPhoto) && (!(tLRPC$MessageMedia3 instanceof TLRPC$TL_messageMediaDocument) || isStickerMessage(message) || isAnimatedStickerMessage(message))) {
                    TLRPC$MessageMedia tLRPC$MessageMedia4 = message.media;
                    if (!(tLRPC$MessageMedia4 instanceof TLRPC$TL_messageMediaEmpty) && !(tLRPC$MessageMedia4 instanceof TLRPC$TL_messageMediaWebPage) && !(tLRPC$MessageMedia4 instanceof TLRPC$TL_messageMediaLiveStream) && tLRPC$MessageMedia4 != null) {
                        return false;
                    }
                }
                return true;
            }
            if ((chat != null && chat.megagroup && message.out) || (chat != null && !chat.megagroup && ((chat.creator || ((tLRPC$TL_chatAdminRights = chat.admin_rights) != null && (tLRPC$TL_chatAdminRights.edit_messages || (message.out && tLRPC$TL_chatAdminRights.post_messages)))) && message.post))) {
                TLRPC$MessageMedia tLRPC$MessageMedia5 = message.media;
                if (!(tLRPC$MessageMedia5 instanceof TLRPC$TL_messageMediaPhoto) && (!(tLRPC$MessageMedia5 instanceof TLRPC$TL_messageMediaDocument) || isStickerMessage(message) || isAnimatedStickerMessage(message))) {
                    TLRPC$MessageMedia tLRPC$MessageMedia6 = message.media;
                    if ((tLRPC$MessageMedia6 instanceof TLRPC$TL_messageMediaEmpty) || (tLRPC$MessageMedia6 instanceof TLRPC$TL_messageMediaWebPage) || (tLRPC$MessageMedia6 instanceof TLRPC$TL_messageMediaLiveStream) || tLRPC$MessageMedia6 == null) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public boolean canDeleteMessage(boolean inScheduleMode, TLRPC$Chat chat) {
        return this.eventId == 0 && this.sponsoredId == null && canDeleteMessage(this.currentAccount, inScheduleMode, this.messageOwner, chat);
    }

    public static boolean canDeleteMessage(int currentAccount, boolean inScheduleMode, TLRPC$Message message, TLRPC$Chat chat) {
        TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights;
        if (message == null) {
            return false;
        }
        if (message.id < 0) {
            return true;
        }
        if (chat == null && message.peer_id.channel_id != 0) {
            chat = MessagesController.getInstance(currentAccount).getChat(Long.valueOf(message.peer_id.channel_id));
        }
        if (!ChatObject.isChannel(chat)) {
            return inScheduleMode || isOut(message) || !ChatObject.isChannel(chat);
        }
        if (inScheduleMode && !chat.megagroup) {
            if (!chat.creator) {
                TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights2 = chat.admin_rights;
                if (tLRPC$TL_chatAdminRights2 == null) {
                    return false;
                }
                if (!tLRPC$TL_chatAdminRights2.delete_messages && !message.out) {
                    return false;
                }
            }
            return true;
        }
        boolean z = message.out;
        if (z && (message instanceof TLRPC$TL_messageService)) {
            return message.id != 1 && ChatObject.canUserDoAdminAction(chat, 13);
        }
        if (!inScheduleMode) {
            if (message.id == 1) {
                return false;
            }
            if (!chat.creator && (((tLRPC$TL_chatAdminRights = chat.admin_rights) == null || (!tLRPC$TL_chatAdminRights.delete_messages && (!z || (!chat.megagroup && !tLRPC$TL_chatAdminRights.post_messages)))) && (!chat.megagroup || !z || !(message.from_id instanceof TLRPC$TL_peerUser)))) {
                return false;
            }
        }
        return true;
    }

    public String getForwardedName() {
        TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = this.messageOwner.fwd_from;
        if (tLRPC$MessageFwdHeader == null) {
            return null;
        }
        TLRPC$Peer tLRPC$Peer = tLRPC$MessageFwdHeader.from_id;
        if (tLRPC$Peer instanceof TLRPC$TL_peerChannel) {
            TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(this.messageOwner.fwd_from.from_id.channel_id));
            if (chat != null) {
                return chat.title;
            }
            return null;
        }
        if (tLRPC$Peer instanceof TLRPC$TL_peerChat) {
            TLRPC$Chat chat2 = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(this.messageOwner.fwd_from.from_id.chat_id));
            if (chat2 != null) {
                return chat2.title;
            }
            return null;
        }
        if (tLRPC$Peer instanceof TLRPC$TL_peerUser) {
            TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(this.messageOwner.fwd_from.from_id.user_id));
            if (user != null) {
                return UserObject.getUserName(user);
            }
            return null;
        }
        String str = tLRPC$MessageFwdHeader.from_name;
        if (str != null) {
            return str;
        }
        return null;
    }

    public int getReplyMsgId() {
        TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = this.messageOwner.reply_to;
        if (tLRPC$TL_messageReplyHeader != null) {
            return tLRPC$TL_messageReplyHeader.reply_to_msg_id;
        }
        return 0;
    }

    public int getReplyTopMsgId() {
        TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = this.messageOwner.reply_to;
        if (tLRPC$TL_messageReplyHeader != null) {
            return tLRPC$TL_messageReplyHeader.reply_to_top_id;
        }
        return 0;
    }

    public static long getReplyToDialogId(TLRPC$Message message) {
        TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = message.reply_to;
        if (tLRPC$TL_messageReplyHeader == null) {
            return 0L;
        }
        TLRPC$Peer tLRPC$Peer = tLRPC$TL_messageReplyHeader.reply_to_peer_id;
        if (tLRPC$Peer != null) {
            return getPeerId(tLRPC$Peer);
        }
        return getDialogId(message);
    }

    public int getReplyAnyMsgId() {
        TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = this.messageOwner.reply_to;
        if (tLRPC$TL_messageReplyHeader == null) {
            return 0;
        }
        int i = tLRPC$TL_messageReplyHeader.reply_to_top_id;
        return i != 0 ? i : tLRPC$TL_messageReplyHeader.reply_to_msg_id;
    }

    public boolean isPrivateForward() {
        TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = this.messageOwner.fwd_from;
        return (tLRPC$MessageFwdHeader == null || TextUtils.isEmpty(tLRPC$MessageFwdHeader.from_name)) ? false : true;
    }

    public boolean isImportedForward() {
        TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = this.messageOwner.fwd_from;
        return tLRPC$MessageFwdHeader != null && tLRPC$MessageFwdHeader.imported;
    }

    public long getSenderId() {
        TLRPC$Peer tLRPC$Peer;
        TLRPC$Message tLRPC$Message = this.messageOwner;
        TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = tLRPC$Message.fwd_from;
        if (tLRPC$MessageFwdHeader != null && (tLRPC$Peer = tLRPC$MessageFwdHeader.saved_from_peer) != null) {
            long j = tLRPC$Peer.user_id;
            if (j != 0) {
                TLRPC$Peer tLRPC$Peer2 = tLRPC$MessageFwdHeader.from_id;
                return tLRPC$Peer2 instanceof TLRPC$TL_peerUser ? tLRPC$Peer2.user_id : j;
            }
            if (tLRPC$Peer.channel_id != 0) {
                if (isSavedFromMegagroup()) {
                    TLRPC$Peer tLRPC$Peer3 = this.messageOwner.fwd_from.from_id;
                    if (tLRPC$Peer3 instanceof TLRPC$TL_peerUser) {
                        return tLRPC$Peer3.user_id;
                    }
                }
                TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader2 = this.messageOwner.fwd_from;
                TLRPC$Peer tLRPC$Peer4 = tLRPC$MessageFwdHeader2.from_id;
                if (tLRPC$Peer4 instanceof TLRPC$TL_peerChannel) {
                    return -tLRPC$Peer4.channel_id;
                }
                if (tLRPC$Peer4 instanceof TLRPC$TL_peerChat) {
                    return -tLRPC$Peer4.chat_id;
                }
                return -tLRPC$MessageFwdHeader2.saved_from_peer.channel_id;
            }
            long j2 = tLRPC$Peer.chat_id;
            if (j2 != 0) {
                TLRPC$Peer tLRPC$Peer5 = tLRPC$MessageFwdHeader.from_id;
                if (tLRPC$Peer5 instanceof TLRPC$TL_peerUser) {
                    return tLRPC$Peer5.user_id;
                }
                if (tLRPC$Peer5 instanceof TLRPC$TL_peerChannel) {
                    return -tLRPC$Peer5.channel_id;
                }
                return tLRPC$Peer5 instanceof TLRPC$TL_peerChat ? -tLRPC$Peer5.chat_id : -j2;
            }
        } else {
            TLRPC$Peer tLRPC$Peer6 = tLRPC$Message.from_id;
            if (tLRPC$Peer6 instanceof TLRPC$TL_peerUser) {
                return tLRPC$Peer6.user_id;
            }
            if (tLRPC$Peer6 instanceof TLRPC$TL_peerChannel) {
                return -tLRPC$Peer6.channel_id;
            }
            if (tLRPC$Peer6 instanceof TLRPC$TL_peerChat) {
                return -tLRPC$Peer6.chat_id;
            }
            if (tLRPC$Message.post) {
                return tLRPC$Message.peer_id.channel_id;
            }
        }
        return 0L;
    }

    public boolean isWallpaper() {
        TLRPC$WebPage tLRPC$WebPage;
        TLRPC$MessageMedia tLRPC$MessageMedia = this.messageOwner.media;
        return (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) && (tLRPC$WebPage = tLRPC$MessageMedia.webpage) != null && "eitaa_background".equals(tLRPC$WebPage.type);
    }

    public boolean isTheme() {
        TLRPC$WebPage tLRPC$WebPage;
        TLRPC$MessageMedia tLRPC$MessageMedia = this.messageOwner.media;
        return (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) && (tLRPC$WebPage = tLRPC$MessageMedia.webpage) != null && "eitaa_theme".equals(tLRPC$WebPage.type);
    }

    public int getMediaExistanceFlags() {
        int i = this.attachPathExists ? 1 : 0;
        return this.mediaExists ? i | 2 : i;
    }

    public void applyMediaExistanceFlags(int flags) {
        if (flags == -1) {
            checkMediaExistance();
        } else {
            this.attachPathExists = (flags & 1) != 0;
            this.mediaExists = (flags & 2) != 0;
        }
    }

    public void checkMediaExistance() {
        int i;
        TLRPC$Photo tLRPC$Photo;
        this.attachPathExists = false;
        this.mediaExists = false;
        if (this.type == 1 && FileLoader.getClosestPhotoSizeWithSize(this.photoThumbs, AndroidUtilities.getPhotoSize()) != null) {
            File pathToMessage = FileLoader.getPathToMessage(this.messageOwner);
            if (needDrawBluredPreview()) {
                this.mediaExists = new File(pathToMessage.getAbsolutePath() + ".enc").exists();
            }
            if (!this.mediaExists) {
                this.mediaExists = pathToMessage.exists();
            }
        }
        if ((!this.mediaExists && this.type == 8) || (i = this.type) == 3 || i == 9 || i == 2 || i == 14 || i == 5) {
            String str = this.messageOwner.attachPath;
            if (str != null && str.length() > 0) {
                this.attachPathExists = new File(this.messageOwner.attachPath).exists();
            }
            if (!this.attachPathExists) {
                File pathToMessage2 = FileLoader.getPathToMessage(this.messageOwner);
                if (this.type == 3 && needDrawBluredPreview()) {
                    this.mediaExists = new File(pathToMessage2.getAbsolutePath() + ".enc").exists();
                }
                if (!this.mediaExists) {
                    this.mediaExists = pathToMessage2.exists();
                }
            }
        }
        if (this.mediaExists) {
            return;
        }
        TLRPC$Document document = getDocument();
        if (document != null) {
            if (isWallpaper()) {
                this.mediaExists = FileLoader.getPathToAttach(document, true).exists();
                return;
            } else {
                this.mediaExists = FileLoader.getPathToAttach(document).exists();
                return;
            }
        }
        int i2 = this.type;
        if (i2 == 0) {
            TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(this.photoThumbs, AndroidUtilities.getPhotoSize());
            if (closestPhotoSizeWithSize == null) {
                return;
            }
            this.mediaExists = FileLoader.getPathToAttach(closestPhotoSizeWithSize, true).exists();
            return;
        }
        if (i2 != 11 || (tLRPC$Photo = this.messageOwner.action.photo) == null || tLRPC$Photo.video_sizes.isEmpty()) {
            return;
        }
        this.mediaExists = FileLoader.getPathToAttach(tLRPC$Photo.video_sizes.get(0), true).exists();
    }

    public void setQuery(String query) {
        String strSubstring;
        int iIndexOf;
        if (TextUtils.isEmpty(query)) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        String lowerCase = query.trim().toLowerCase();
        String[] strArrSplit = lowerCase.split("\\P{L}+");
        ArrayList arrayList2 = new ArrayList();
        if (!TextUtils.isEmpty(this.messageOwner.message)) {
            String lowerCase2 = this.messageOwner.message.trim().toLowerCase();
            if (lowerCase2.contains(lowerCase) && !arrayList.contains(lowerCase)) {
                arrayList.add(lowerCase);
                handleFoundWords(arrayList, strArrSplit);
                return;
            }
            arrayList2.addAll(Arrays.asList(lowerCase2.split("\\P{L}+")));
        }
        if (getDocument() != null) {
            String lowerCase3 = FileLoader.getDocumentFileName(getDocument()).toLowerCase();
            if (lowerCase3.contains(lowerCase) && !arrayList.contains(lowerCase)) {
                arrayList.add(lowerCase);
            }
            arrayList2.addAll(Arrays.asList(lowerCase3.split("\\P{L}+")));
        }
        TLRPC$MessageMedia tLRPC$MessageMedia = this.messageOwner.media;
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) {
            TLRPC$WebPage tLRPC$WebPage = tLRPC$MessageMedia.webpage;
            if (tLRPC$WebPage instanceof TLRPC$TL_webPage) {
                String str = tLRPC$WebPage.title;
                if (str == null) {
                    str = tLRPC$WebPage.site_name;
                }
                if (str != null) {
                    String lowerCase4 = str.toLowerCase();
                    if (lowerCase4.contains(lowerCase) && !arrayList.contains(lowerCase)) {
                        arrayList.add(lowerCase);
                    }
                    arrayList2.addAll(Arrays.asList(lowerCase4.split("\\P{L}+")));
                }
            }
        }
        String musicAuthor = getMusicAuthor();
        if (musicAuthor != null) {
            String lowerCase5 = musicAuthor.toLowerCase();
            if (lowerCase5.contains(lowerCase) && !arrayList.contains(lowerCase)) {
                arrayList.add(lowerCase);
            }
            arrayList2.addAll(Arrays.asList(lowerCase5.split("\\P{L}+")));
        }
        for (String str2 : strArrSplit) {
            if (str2.length() >= 2) {
                for (int i = 0; i < arrayList2.size(); i++) {
                    if (!arrayList.contains(arrayList2.get(i)) && (iIndexOf = (strSubstring = (String) arrayList2.get(i)).indexOf(str2.charAt(0))) >= 0) {
                        int iMax = Math.max(str2.length(), strSubstring.length());
                        if (iIndexOf != 0) {
                            strSubstring = strSubstring.substring(iIndexOf);
                        }
                        int iMin = Math.min(str2.length(), strSubstring.length());
                        int i2 = 0;
                        for (int i3 = 0; i3 < iMin && strSubstring.charAt(i3) == str2.charAt(i3); i3++) {
                            i2++;
                        }
                        if (i2 / iMax >= 0.5d) {
                            arrayList.add((String) arrayList2.get(i));
                        }
                    }
                }
            }
        }
        handleFoundWords(arrayList, strArrSplit);
    }

    private void handleFoundWords(ArrayList<String> foundWords, String[] queryWord) {
        boolean z;
        if (foundWords.isEmpty()) {
            return;
        }
        boolean z2 = false;
        for (int i = 0; i < foundWords.size(); i++) {
            int i2 = 0;
            while (true) {
                if (i2 >= queryWord.length) {
                    break;
                }
                if (foundWords.get(i).contains(queryWord[i2])) {
                    z2 = true;
                    break;
                }
                i2++;
            }
            if (z2) {
                break;
            }
        }
        if (z2) {
            int i3 = 0;
            while (i3 < foundWords.size()) {
                int i4 = 0;
                while (true) {
                    if (i4 >= queryWord.length) {
                        z = false;
                        break;
                    } else {
                        if (foundWords.get(i3).contains(queryWord[i4])) {
                            z = true;
                            break;
                        }
                        i4++;
                    }
                }
                if (!z) {
                    foundWords.remove(i3);
                    i3--;
                }
                i3++;
            }
            if (foundWords.size() > 0) {
                Collections.sort(foundWords, $$Lambda$MessageObject$ZnDN2IkPmtHxxIasQfFMiAHbX88.INSTANCE);
                String str = foundWords.get(0);
                foundWords.clear();
                foundWords.add(str);
            }
        }
        this.highlightedWords = foundWords;
        String str2 = this.messageOwner.message;
        if (str2 != null) {
            String strTrim = str2.replace('\n', ' ').replaceAll(" +", " ").trim();
            int length = strTrim.length();
            int iIndexOf = strTrim.toLowerCase().indexOf(foundWords.get(0));
            if (iIndexOf < 0) {
                iIndexOf = 0;
            }
            if (length > 200) {
                int iMax = Math.max(0, iIndexOf - 100);
                strTrim = strTrim.substring(iMax, Math.min(length, (iIndexOf - iMax) + iIndexOf + 100));
            }
            this.messageTrimmedToHighlight = strTrim;
        }
    }

    static /* synthetic */ int lambda$handleFoundWords$1(String str, String str2) {
        return str2.length() - str.length();
    }

    public boolean hasHighlightedWords() {
        ArrayList<String> arrayList = this.highlightedWords;
        return (arrayList == null || arrayList.isEmpty()) ? false : true;
    }

    public boolean equals(MessageObject obj) {
        return getId() == obj.getId() && getDialogId() == obj.getDialogId();
    }

    public boolean isLiveStream() {
        return isLiveStreamMessage(this.messageOwner);
    }

    public long getLiveStreamId() {
        if (isLiveStream()) {
            return ((TLRPC$TL_messageMediaLiveStream) this.messageOwner.media).id;
        }
        return 0L;
    }

    public static boolean isLiveStreamMessage(TLRPC$Message message) {
        return message.media instanceof TLRPC$TL_messageMediaLiveStream;
    }

    public boolean isLiveStreamBroadcasting() {
        if (isLiveStream()) {
            return ((TLRPC$TL_messageMediaLiveStream) this.messageOwner.media).state instanceof TLRPC$TL_LiveStreamStateBroadcasting;
        }
        return false;
    }

    public TLRPC$TL_LiveStream getLiveStream() {
        if (isLiveStreamBroadcasting()) {
            return ((TLRPC$TL_LiveStreamStateBroadcasting) ((TLRPC$TL_messageMediaLiveStream) this.messageOwner.media).state).liveStream;
        }
        return null;
    }

    public static void updateLiveMedia(TLRPC$TL_messageMediaLiveStream oldMedia, TLRPC$TL_messageMediaLiveStream newMedia) {
        oldMedia.total_viewers = newMedia.total_viewers;
        TLRPC$LiveStreamState tLRPC$LiveStreamState = newMedia.state;
        if (tLRPC$LiveStreamState instanceof TLRPC$TL_LiveStreamStateBroadcasting) {
            boolean z = tLRPC$LiveStreamState.isPaused;
            if (z) {
                oldMedia.state.flags |= 1;
            } else {
                oldMedia.state.flags &= -2;
            }
            oldMedia.state.isPaused = z;
            return;
        }
        oldMedia.state = tLRPC$LiveStreamState;
    }
}
