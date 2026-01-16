package ir.nasim;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.CollectionsStruct$MapValue;
import ai.bale.proto.CollectionsStruct$MapValueItem;
import ai.bale.proto.CollectionsStruct$RawValue;
import ai.bale.proto.FilesStruct$Avatar;
import ai.bale.proto.FilesStruct$AvatarImage;
import ai.bale.proto.FilesStruct$FastThumb;
import ai.bale.proto.FilesStruct$FileLocation;
import ai.bale.proto.FilesStruct$ImageLocation;
import ai.bale.proto.GroupsStruct$FullGroup;
import ai.bale.proto.GroupsStruct$Group;
import ai.bale.proto.GroupsStruct$Member;
import ai.bale.proto.GroupsStruct$Permissions;
import ai.bale.proto.ImagesStruct$AnimatedStickerDescriptor;
import ai.bale.proto.ImagesStruct$StickerCollection;
import ai.bale.proto.ImagesStruct$StickerDescriptor;
import ai.bale.proto.MeetStruct$Call;
import ai.bale.proto.MeetStruct$GroupCall;
import ai.bale.proto.MeetStruct$JoinRequest;
import ai.bale.proto.MessagingStruct$AnimatedStickerMessage;
import ai.bale.proto.MessagingStruct$BankAccount;
import ai.bale.proto.MessagingStruct$BankEx;
import ai.bale.proto.MessagingStruct$BankMessage;
import ai.bale.proto.MessagingStruct$BankMoneyTransfer;
import ai.bale.proto.MessagingStruct$BankRemain;
import ai.bale.proto.MessagingStruct$BankTransaction;
import ai.bale.proto.MessagingStruct$BannedMessage;
import ai.bale.proto.MessagingStruct$BinaryMessage;
import ai.bale.proto.MessagingStruct$ChatAdministratorRights;
import ai.bale.proto.MessagingStruct$CrowdFundingMessage;
import ai.bale.proto.MessagingStruct$CustomAction;
import ai.bale.proto.MessagingStruct$Dialog;
import ai.bale.proto.MessagingStruct$DocumentEx;
import ai.bale.proto.MessagingStruct$DocumentMessage;
import ai.bale.proto.MessagingStruct$GiftPacketMessage;
import ai.bale.proto.MessagingStruct$GoldGiftPacketMessage;
import ai.bale.proto.MessagingStruct$InlineKeyboardButton;
import ai.bale.proto.MessagingStruct$InlineKeyboardButtonList;
import ai.bale.proto.MessagingStruct$InlineKeyboardButtonMarkup;
import ai.bale.proto.MessagingStruct$JsonMessage;
import ai.bale.proto.MessagingStruct$KeyboardButton;
import ai.bale.proto.MessagingStruct$KeyboardButtonRequestChat;
import ai.bale.proto.MessagingStruct$KeyboardButtonRequestUser;
import ai.bale.proto.MessagingStruct$ListOfKeyboardButton;
import ai.bale.proto.MessagingStruct$LiveMessage;
import ai.bale.proto.MessagingStruct$LoginUrl;
import ai.bale.proto.MessagingStruct$Message;
import ai.bale.proto.MessagingStruct$MessageAttributes;
import ai.bale.proto.MessagingStruct$MessageContainer;
import ai.bale.proto.MessagingStruct$MessageId;
import ai.bale.proto.MessagingStruct$MessageReaction;
import ai.bale.proto.MessagingStruct$MessageTag;
import ai.bale.proto.MessagingStruct$MultiplexingData;
import ai.bale.proto.MessagingStruct$MultiplexingRow;
import ai.bale.proto.MessagingStruct$PollMessage;
import ai.bale.proto.MessagingStruct$ProtectedMessage;
import ai.bale.proto.MessagingStruct$PurchaseMessage;
import ai.bale.proto.MessagingStruct$QuotedMessage;
import ai.bale.proto.MessagingStruct$ReceiptMessage;
import ai.bale.proto.MessagingStruct$Replies;
import ai.bale.proto.MessagingStruct$ReplyKeyboardMarkup;
import ai.bale.proto.MessagingStruct$ReplyKeyboardRemove;
import ai.bale.proto.MessagingStruct$ServiceEx;
import ai.bale.proto.MessagingStruct$ServiceExCallRecordStateChanged;
import ai.bale.proto.MessagingStruct$ServiceExGiftPacketOpened;
import ai.bale.proto.MessagingStruct$ServiceExGiftPacketOpenedCompact;
import ai.bale.proto.MessagingStruct$ServiceExGroupCallEnded;
import ai.bale.proto.MessagingStruct$ServiceExGroupCallStarted;
import ai.bale.proto.MessagingStruct$ServiceExPhoneCall;
import ai.bale.proto.MessagingStruct$ServiceMessage;
import ai.bale.proto.MessagingStruct$StickerMessage;
import ai.bale.proto.MessagingStruct$StoryReference;
import ai.bale.proto.MessagingStruct$SwitchInlineQueryChosenChat;
import ai.bale.proto.MessagingStruct$TemplateMessage;
import ai.bale.proto.MessagingStruct$TemplateMessageResponse;
import ai.bale.proto.MessagingStruct$TextMessage;
import ai.bale.proto.MessagingStruct$Transaction;
import ai.bale.proto.PeersStruct$ExInfo;
import ai.bale.proto.PeersStruct$ExPeer;
import ai.bale.proto.PeersStruct$GroupOutPeer;
import ai.bale.proto.PeersStruct$OutExPeer;
import ai.bale.proto.PeersStruct$OutPeer;
import ai.bale.proto.PeersStruct$Peer;
import ai.bale.proto.PeersStruct$UserOutPeer;
import ai.bale.proto.PollStruct$OptionResult;
import ai.bale.proto.PollStruct$PollOption;
import ai.bale.proto.PollStruct$PollResult;
import ai.bale.proto.UsersStruct$BotCommand;
import ai.bale.proto.UsersStruct$BotExInfo;
import ai.bale.proto.UsersStruct$ContactRecord;
import ai.bale.proto.UsersStruct$FullUser;
import ai.bale.proto.UsersStruct$Intro;
import ai.bale.proto.UsersStruct$IntroMedia;
import ai.bale.proto.UsersStruct$IntroMessage;
import ai.bale.proto.UsersStruct$MediaExt;
import ai.bale.proto.UsersStruct$User;
import com.google.protobuf.BoolValue;
import com.google.protobuf.BytesValue;
import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;
import ir.nasim.C9475a16;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.p92, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C18732p92 {
    public static final C18732p92 a = new C18732p92();

    /* renamed from: ir.nasim.p92$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;
        public static final /* synthetic */ int[] d;
        public static final /* synthetic */ int[] e;
        public static final /* synthetic */ int[] f;
        public static final /* synthetic */ int[] g;
        public static final /* synthetic */ int[] h;
        public static final /* synthetic */ int[] i;
        public static final /* synthetic */ int[] j;
        public static final /* synthetic */ int[] k;
        public static final /* synthetic */ int[] l;
        public static final /* synthetic */ int[] m;
        public static final /* synthetic */ int[] n;
        public static final /* synthetic */ int[] o;
        public static final /* synthetic */ int[] p;
        public static final /* synthetic */ int[] q;
        public static final /* synthetic */ int[] r;
        public static final /* synthetic */ int[] s;
        public static final /* synthetic */ int[] t;
        public static final /* synthetic */ int[] u;
        public static final /* synthetic */ int[] v;

        static {
            int[] iArr = new int[EnumC4884Gz.values().length];
            try {
                iArr[EnumC4884Gz.READ.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC4884Gz.RECEIVED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC4884Gz.SENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
            int[] iArr2 = new int[ZN2.values().length];
            try {
                iArr2[ZN2.CHANNEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ZN2.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            b = iArr2;
            int[] iArr3 = new int[EnumC24932zS2.values().length];
            try {
                iArr3[EnumC24932zS2.GroupType_GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[EnumC24932zS2.GroupType_CHANNEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[EnumC24932zS2.GroupType_SUPER_GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[EnumC24932zS2.UNRECOGNIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            c = iArr3;
            int[] iArr4 = new int[BB.values().length];
            try {
                iArr4[BB.PRIVATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr4[BB.PUBLIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr4[BB.UNSUPPORTED_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            d = iArr4;
            int[] iArr5 = new int[KM7.values().length];
            try {
                iArr5[KM7.Sex_MALE.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr5[KM7.Sex_FEMALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            e = iArr5;
            int[] iArr6 = new int[CA.values().length];
            try {
                iArr6[CA.GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr6[CA.PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
            f = iArr6;
            int[] iArr7 = new int[W25.values().length];
            try {
                iArr7[W25.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr7[W25.a.ordinal()] = 2;
            } catch (NoSuchFieldError unused18) {
            }
            g = iArr7;
            int[] iArr8 = new int[EnumC9196Yx.values().length];
            try {
                iArr8[EnumC9196Yx.BOT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr8[EnumC9196Yx.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr8[EnumC9196Yx.CHANNEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr8[EnumC9196Yx.PRIVATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            h = iArr8;
            int[] iArr9 = new int[EnumC23583xA.values().length];
            try {
                iArr9[EnumC23583xA.VERIFIED.ordinal()] = 1;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr9[EnumC23583xA.LEGAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr9[EnumC23583xA.INFORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused25) {
            }
            i = iArr9;
            int[] iArr10 = new int[EnumC10088b35.values().length];
            try {
                iArr10[EnumC10088b35.ExPeerType_BOT.ordinal()] = 1;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr10[EnumC10088b35.ExPeerType_PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr10[EnumC10088b35.ExPeerType_GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr10[EnumC10088b35.ExPeerType_CHANNEL.ordinal()] = 4;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr10[EnumC10088b35.ExPeerType_SUPERGROUP.ordinal()] = 5;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr10[EnumC10088b35.ExPeerType_THREAD.ordinal()] = 6;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr10[EnumC10088b35.UNRECOGNIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr10[EnumC10088b35.ExPeerType_UNKNOWN.ordinal()] = 8;
            } catch (NoSuchFieldError unused33) {
            }
            j = iArr10;
            int[] iArr11 = new int[EnumC8374Vr6.values().length];
            try {
                iArr11[EnumC8374Vr6.IRANCELL.ordinal()] = 1;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr11[EnumC8374Vr6.MCI.ordinal()] = 2;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr11[EnumC8374Vr6.RIGHTEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr11[EnumC8374Vr6.UNSUPPORTED_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused37) {
            }
            k = iArr11;
            int[] iArr12 = new int[EnumC10123b70.values().length];
            try {
                iArr12[EnumC10123b70.ServiceOperator_IRANCELL.ordinal()] = 1;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                iArr12[EnumC10123b70.ServiceOperator_MCI.ordinal()] = 2;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                iArr12[EnumC10123b70.ServiceOperator_RIGHTEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                iArr12[EnumC10123b70.UNRECOGNIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                iArr12[EnumC10123b70.ServiceOperator_UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused42) {
            }
            l = iArr12;
            int[] iArr13 = new int[EnumC16466lK0.values().length];
            try {
                iArr13[EnumC16466lK0.TOPUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                iArr13[EnumC16466lK0.WOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                iArr13[EnumC16466lK0.VOUCHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                iArr13[EnumC16466lK0.UNSUPPORTED_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused46) {
            }
            m = iArr13;
            int[] iArr14 = new int[Q60.values().length];
            try {
                iArr14[Q60.ChargeType_TOPUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                iArr14[Q60.ChargeType_WOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                iArr14[Q60.ChargeType_VOUCHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                iArr14[Q60.UNRECOGNIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                iArr14[Q60.ChargeType_UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused51) {
            }
            n = iArr14;
            int[] iArr15 = new int[EnumC16311l35.values().length];
            try {
                iArr15[EnumC16311l35.PeerType_GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                iArr15[EnumC16311l35.PeerType_PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                iArr15[EnumC16311l35.PeerType_ENCRYPTEDPRIVATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused54) {
            }
            o = iArr15;
            int[] iArr16 = new int[MessagingStruct$Message.b.values().length];
            try {
                iArr16[MessagingStruct$Message.b.BINARY_MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                iArr16[MessagingStruct$Message.b.DELETED_MESSAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                iArr16[MessagingStruct$Message.b.DOCUMENT_MESSAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                iArr16[MessagingStruct$Message.b.EMPTY_MESSAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                iArr16[MessagingStruct$Message.b.JSON_MESSAGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                iArr16[MessagingStruct$Message.b.NASIM_ENCRYPTED_MESSAGE.ordinal()] = 6;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                iArr16[MessagingStruct$Message.b.PURCHASE_MESSAGE.ordinal()] = 7;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                iArr16[MessagingStruct$Message.b.SERVICE_MESSAGE.ordinal()] = 8;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                iArr16[MessagingStruct$Message.b.STICKER_MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                iArr16[MessagingStruct$Message.b.TEMPLATE_MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                iArr16[MessagingStruct$Message.b.TEMPLATE_MESSAGE_RESPONSE.ordinal()] = 11;
            } catch (NoSuchFieldError unused65) {
            }
            try {
                iArr16[MessagingStruct$Message.b.TEXT_MESSAGE.ordinal()] = 12;
            } catch (NoSuchFieldError unused66) {
            }
            try {
                iArr16[MessagingStruct$Message.b.GIFT_PACKET_MESSAGE.ordinal()] = 13;
            } catch (NoSuchFieldError unused67) {
            }
            try {
                iArr16[MessagingStruct$Message.b.ADVERTISEMENT_MESSAGE.ordinal()] = 14;
            } catch (NoSuchFieldError unused68) {
            }
            try {
                iArr16[MessagingStruct$Message.b.CROWD_FUNDING_MESSAGE.ordinal()] = 15;
            } catch (NoSuchFieldError unused69) {
            }
            try {
                iArr16[MessagingStruct$Message.b.ANIMATED_STICKER_MESSAGE.ordinal()] = 16;
            } catch (NoSuchFieldError unused70) {
            }
            try {
                iArr16[MessagingStruct$Message.b.LIVE_MESSAGE.ordinal()] = 17;
            } catch (NoSuchFieldError unused71) {
            }
            try {
                iArr16[MessagingStruct$Message.b.PROTECTED_MESSAGE.ordinal()] = 18;
            } catch (NoSuchFieldError unused72) {
            }
            try {
                iArr16[MessagingStruct$Message.b.GOLD_GIFT_PACKET_MESSAGE.ordinal()] = 19;
            } catch (NoSuchFieldError unused73) {
            }
            try {
                iArr16[MessagingStruct$Message.b.POLL_MESSAGE.ordinal()] = 20;
            } catch (NoSuchFieldError unused74) {
            }
            try {
                iArr16[MessagingStruct$Message.b.BANNED_MESSAGE.ordinal()] = 21;
            } catch (NoSuchFieldError unused75) {
            }
            try {
                iArr16[MessagingStruct$Message.b.BANK_MESSAGE.ordinal()] = 22;
            } catch (NoSuchFieldError unused76) {
            }
            try {
                iArr16[MessagingStruct$Message.b.PREMIUM_MESSAGE.ordinal()] = 23;
            } catch (NoSuchFieldError unused77) {
            }
            try {
                iArr16[MessagingStruct$Message.b.NEW_PREMIUM_MESSAGE.ordinal()] = 24;
            } catch (NoSuchFieldError unused78) {
            }
            try {
                iArr16[MessagingStruct$Message.b.BOUGHT_PREMIUM_MESSAGE.ordinal()] = 25;
            } catch (NoSuchFieldError unused79) {
            }
            try {
                iArr16[MessagingStruct$Message.b.UNSUPPORTED_MESSAGE.ordinal()] = 26;
            } catch (NoSuchFieldError unused80) {
            }
            try {
                iArr16[MessagingStruct$Message.b.TRAIT_NOT_SET.ordinal()] = 27;
            } catch (NoSuchFieldError unused81) {
            }
            try {
                iArr16[MessagingStruct$Message.b.ORDER_MESSAGE.ordinal()] = 28;
            } catch (NoSuchFieldError unused82) {
            }
            try {
                iArr16[MessagingStruct$Message.b.STORY.ordinal()] = 29;
            } catch (NoSuchFieldError unused83) {
            }
            p = iArr16;
            int[] iArr17 = new int[MessagingStruct$ServiceEx.b.values().length];
            try {
                iArr17[MessagingStruct$ServiceEx.b.SERVICE_EX_USER_INVITED.ordinal()] = 1;
            } catch (NoSuchFieldError unused84) {
            }
            try {
                iArr17[MessagingStruct$ServiceEx.b.SERVICE_EX_USER_KICKED.ordinal()] = 2;
            } catch (NoSuchFieldError unused85) {
            }
            try {
                iArr17[MessagingStruct$ServiceEx.b.SERVICE_EX_USER_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused86) {
            }
            try {
                iArr17[MessagingStruct$ServiceEx.b.SERVICE_EX_GROUP_CREATED.ordinal()] = 4;
            } catch (NoSuchFieldError unused87) {
            }
            try {
                iArr17[MessagingStruct$ServiceEx.b.SERVICE_EX_CHANGED_TITLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused88) {
            }
            try {
                iArr17[MessagingStruct$ServiceEx.b.SERVICE_EX_CHANGED_AVATAR.ordinal()] = 6;
            } catch (NoSuchFieldError unused89) {
            }
            try {
                iArr17[MessagingStruct$ServiceEx.b.SERVICE_EX_CONTACT_REGISTERED.ordinal()] = 7;
            } catch (NoSuchFieldError unused90) {
            }
            try {
                iArr17[MessagingStruct$ServiceEx.b.SERVICE_EX_PHONE_MISSED.ordinal()] = 8;
            } catch (NoSuchFieldError unused91) {
            }
            try {
                iArr17[MessagingStruct$ServiceEx.b.SERVICE_EX_PHONE_CALL.ordinal()] = 9;
            } catch (NoSuchFieldError unused92) {
            }
            try {
                iArr17[MessagingStruct$ServiceEx.b.SERVICE_EX_USER_JOINED.ordinal()] = 10;
            } catch (NoSuchFieldError unused93) {
            }
            try {
                iArr17[MessagingStruct$ServiceEx.b.SERVICE_EX_CHANGED_TOPIC.ordinal()] = 11;
            } catch (NoSuchFieldError unused94) {
            }
            try {
                iArr17[MessagingStruct$ServiceEx.b.SERVICE_EX_CHANGED_ABOUT.ordinal()] = 12;
            } catch (NoSuchFieldError unused95) {
            }
            try {
                iArr17[MessagingStruct$ServiceEx.b.SERVICE_EX_CHAT_ARCHIVED.ordinal()] = 13;
            } catch (NoSuchFieldError unused96) {
            }
            try {
                iArr17[MessagingStruct$ServiceEx.b.SERVICE_EX_CHAT_RESTORED.ordinal()] = 14;
            } catch (NoSuchFieldError unused97) {
            }
            try {
                iArr17[MessagingStruct$ServiceEx.b.SERVICE_EX_BECAME_ORPHANED.ordinal()] = 15;
            } catch (NoSuchFieldError unused98) {
            }
            try {
                iArr17[MessagingStruct$ServiceEx.b.SERVICE_EX_GROUP_CALL_STARTED.ordinal()] = 16;
            } catch (NoSuchFieldError unused99) {
            }
            try {
                iArr17[MessagingStruct$ServiceEx.b.SERVICE_EX_NEW_USER_WELCOME.ordinal()] = 17;
            } catch (NoSuchFieldError unused100) {
            }
            try {
                iArr17[MessagingStruct$ServiceEx.b.SERVICE_EX_GROUP_CALL_ENDED.ordinal()] = 18;
            } catch (NoSuchFieldError unused101) {
            }
            try {
                iArr17[MessagingStruct$ServiceEx.b.SERVICE_EX_ANONYMOUS_CONTACT.ordinal()] = 19;
            } catch (NoSuchFieldError unused102) {
            }
            try {
                iArr17[MessagingStruct$ServiceEx.b.SERVICE_EX_CHANGED_NICK.ordinal()] = 20;
            } catch (NoSuchFieldError unused103) {
            }
            try {
                iArr17[MessagingStruct$ServiceEx.b.SERVICE_EX_GIFT_PACKET_OPENED.ordinal()] = 21;
            } catch (NoSuchFieldError unused104) {
            }
            try {
                iArr17[MessagingStruct$ServiceEx.b.SERVICE_EX_GIFT_PACKET_OPENED_COMPACT.ordinal()] = 22;
            } catch (NoSuchFieldError unused105) {
            }
            try {
                iArr17[MessagingStruct$ServiceEx.b.SERVICE_EX_CALL_RECORD_STATE_CHANGED.ordinal()] = 23;
            } catch (NoSuchFieldError unused106) {
            }
            try {
                iArr17[MessagingStruct$ServiceEx.b.SERVICE_EX_MINI_APP_DATA_SENT.ordinal()] = 24;
            } catch (NoSuchFieldError unused107) {
            }
            try {
                iArr17[MessagingStruct$ServiceEx.b.SERVICE_EX_PASSPORT_DATA_SENT.ordinal()] = 25;
            } catch (NoSuchFieldError unused108) {
            }
            try {
                iArr17[MessagingStruct$ServiceEx.b.TRAIT_NOT_SET.ordinal()] = 26;
            } catch (NoSuchFieldError unused109) {
            }
            q = iArr17;
            int[] iArr18 = new int[EnumC8973Ya4.values().length];
            try {
                iArr18[EnumC8973Ya4.BrowserType_INTERNAL_BROWSER.ordinal()] = 1;
            } catch (NoSuchFieldError unused110) {
            }
            try {
                iArr18[EnumC8973Ya4.BrowserType_EXTERNAL_BROWSER.ordinal()] = 2;
            } catch (NoSuchFieldError unused111) {
            }
            try {
                iArr18[EnumC8973Ya4.UNRECOGNIZED.ordinal()] = 3;
            } catch (NoSuchFieldError unused112) {
            }
            r = iArr18;
            int[] iArr19 = new int[MessagingStruct$BankEx.b.values().length];
            try {
                iArr19[MessagingStruct$BankEx.b.BANK_MONEY_TRANSFER.ordinal()] = 1;
            } catch (NoSuchFieldError unused113) {
            }
            try {
                iArr19[MessagingStruct$BankEx.b.BANK_REMAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused114) {
            }
            try {
                iArr19[MessagingStruct$BankEx.b.BANK_TRANSACTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused115) {
            }
            try {
                iArr19[MessagingStruct$BankEx.b.RECEIPT_MESSAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused116) {
            }
            s = iArr19;
            int[] iArr20 = new int[EnumC6251Mv.values().length];
            try {
                iArr20[EnumC6251Mv.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused117) {
            }
            try {
                iArr20[EnumC6251Mv.DEFAULT.ordinal()] = 2;
            } catch (NoSuchFieldError unused118) {
            }
            try {
                iArr20[EnumC6251Mv.BALEONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused119) {
            }
            try {
                iArr20[EnumC6251Mv.SMS.ordinal()] = 4;
            } catch (NoSuchFieldError unused120) {
            }
            try {
                iArr20[EnumC6251Mv.CALL.ordinal()] = 5;
            } catch (NoSuchFieldError unused121) {
            }
            try {
                iArr20[EnumC6251Mv.EMAIL.ordinal()] = 6;
            } catch (NoSuchFieldError unused122) {
            }
            try {
                iArr20[EnumC6251Mv.MISSCALL.ordinal()] = 7;
            } catch (NoSuchFieldError unused123) {
            }
            try {
                iArr20[EnumC6251Mv.SETUP_EMAIL_REQUIRED.ordinal()] = 8;
            } catch (NoSuchFieldError unused124) {
            }
            try {
                iArr20[EnumC6251Mv.WHATSAPP.ordinal()] = 9;
            } catch (NoSuchFieldError unused125) {
            }
            try {
                iArr20[EnumC6251Mv.TELEGRAM.ordinal()] = 10;
            } catch (NoSuchFieldError unused126) {
            }
            try {
                iArr20[EnumC6251Mv.FUTURE_AUTH_TOKEN.ordinal()] = 11;
            } catch (NoSuchFieldError unused127) {
            }
            try {
                iArr20[EnumC6251Mv.USSD.ordinal()] = 12;
            } catch (NoSuchFieldError unused128) {
            }
            t = iArr20;
            int[] iArr21 = new int[SQ.values().length];
            try {
                iArr21[SQ.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused129) {
            }
            try {
                iArr21[SQ.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused130) {
            }
            try {
                iArr21[SQ.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused131) {
            }
            try {
                iArr21[SQ.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused132) {
            }
            try {
                iArr21[SQ.e.ordinal()] = 5;
            } catch (NoSuchFieldError unused133) {
            }
            try {
                iArr21[SQ.f.ordinal()] = 6;
            } catch (NoSuchFieldError unused134) {
            }
            try {
                iArr21[SQ.g.ordinal()] = 7;
            } catch (NoSuchFieldError unused135) {
            }
            try {
                iArr21[SQ.h.ordinal()] = 8;
            } catch (NoSuchFieldError unused136) {
            }
            try {
                iArr21[SQ.i.ordinal()] = 9;
            } catch (NoSuchFieldError unused137) {
            }
            try {
                iArr21[SQ.j.ordinal()] = 10;
            } catch (NoSuchFieldError unused138) {
            }
            try {
                iArr21[SQ.k.ordinal()] = 11;
            } catch (NoSuchFieldError unused139) {
            }
            try {
                iArr21[SQ.l.ordinal()] = 12;
            } catch (NoSuchFieldError unused140) {
            }
            try {
                iArr21[SQ.m.ordinal()] = 13;
            } catch (NoSuchFieldError unused141) {
            }
            u = iArr21;
            int[] iArr22 = new int[WQ.values().length];
            try {
                iArr22[WQ.AuthSendCodeType_UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused142) {
            }
            try {
                iArr22[WQ.AuthSendCodeType_DEFAULT.ordinal()] = 2;
            } catch (NoSuchFieldError unused143) {
            }
            try {
                iArr22[WQ.AuthSendCodeType_BALEONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused144) {
            }
            try {
                iArr22[WQ.AuthSendCodeType_SMS.ordinal()] = 4;
            } catch (NoSuchFieldError unused145) {
            }
            try {
                iArr22[WQ.AuthSendCodeType_CALL.ordinal()] = 5;
            } catch (NoSuchFieldError unused146) {
            }
            try {
                iArr22[WQ.AuthSendCodeType_EMAIL.ordinal()] = 6;
            } catch (NoSuchFieldError unused147) {
            }
            try {
                iArr22[WQ.AuthSendCodeType_MISSCALL.ordinal()] = 7;
            } catch (NoSuchFieldError unused148) {
            }
            try {
                iArr22[WQ.AuthSendCodeType_SETUP_EMAIL_REQUIRED.ordinal()] = 8;
            } catch (NoSuchFieldError unused149) {
            }
            try {
                iArr22[WQ.AuthSendCodeType_WHATSAPP.ordinal()] = 9;
            } catch (NoSuchFieldError unused150) {
            }
            try {
                iArr22[WQ.AuthSendCodeType_TELEGRAM.ordinal()] = 10;
            } catch (NoSuchFieldError unused151) {
            }
            try {
                iArr22[WQ.AuthSendCodeType_USSD.ordinal()] = 11;
            } catch (NoSuchFieldError unused152) {
            }
            try {
                iArr22[WQ.AuthSendCodeType_FUTURE_AUTH_TOKEN.ordinal()] = 12;
            } catch (NoSuchFieldError unused153) {
            }
            try {
                iArr22[WQ.UNRECOGNIZED.ordinal()] = 13;
            } catch (NoSuchFieldError unused154) {
            }
            try {
                iArr22[WQ.AuthSendCodeType_TELEGRAM_GATEWAY.ordinal()] = 14;
            } catch (NoSuchFieldError unused155) {
            }
            v = iArr22;
        }
    }

    /* renamed from: ir.nasim.p92$b */
    public static final class b extends ArrayList {
        b(Map map) {
            for (String str : map.keySet()) {
                AbstractC17566nB abstractC17566nBV0 = C18732p92.V0((CollectionsStruct$RawValue) map.get(str));
                AbstractC13042fc3.f(abstractC17566nBV0);
                add(new C20420rz(str, abstractC17566nBV0));
            }
        }

        public /* bridge */ int C(C20420rz c20420rz) {
            return super.lastIndexOf(c20420rz);
        }

        public /* bridge */ boolean D(C20420rz c20420rz) {
            return super.remove(c20420rz);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj == null ? true : obj instanceof C20420rz) {
                return f((C20420rz) obj);
            }
            return false;
        }

        public /* bridge */ boolean f(C20420rz c20420rz) {
            return super.contains(c20420rz);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj == null ? true : obj instanceof C20420rz) {
                return w((C20420rz) obj);
            }
            return -1;
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj == null ? true : obj instanceof C20420rz) {
                return C((C20420rz) obj);
            }
            return -1;
        }

        public /* bridge */ int r() {
            return super.size();
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean remove(Object obj) {
            if (obj == null ? true : obj instanceof C20420rz) {
                return D((C20420rz) obj);
            }
            return false;
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ int size() {
            return r();
        }

        public /* bridge */ int w(C20420rz c20420rz) {
            return super.indexOf(c20420rz);
        }
    }

    /* renamed from: ir.nasim.p92$c */
    public static final class c extends ArrayList {
        c(UsersStruct$FullUser usersStruct$FullUser) {
            for (UsersStruct$ContactRecord usersStruct$ContactRecord : usersStruct$FullUser.getContactInfoList()) {
                EnumC14458hx enumC14458hx = EnumC14458hx.PHONE;
                StringValue stringValue = usersStruct$ContactRecord.getStringValue();
                String value = stringValue != null ? stringValue.getValue() : null;
                CollectionsStruct$Int64Value longValue = usersStruct$ContactRecord.getLongValue();
                Long lValueOf = longValue != null ? Long.valueOf(longValue.getValue()) : null;
                StringValue title = usersStruct$ContactRecord.getTitle();
                String value2 = title != null ? title.getValue() : null;
                StringValue subtitle = usersStruct$ContactRecord.getSubtitle();
                String value3 = subtitle != null ? subtitle.getValue() : null;
                StringValue typeSpec = usersStruct$ContactRecord.getTypeSpec();
                add(new C13865gx(enumC14458hx, value, lValueOf, value2, value3, typeSpec != null ? typeSpec.getValue() : null));
            }
        }

        public /* bridge */ int C(C13865gx c13865gx) {
            return super.lastIndexOf(c13865gx);
        }

        public /* bridge */ boolean D(C13865gx c13865gx) {
            return super.remove(c13865gx);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj == null ? true : obj instanceof C13865gx) {
                return f((C13865gx) obj);
            }
            return false;
        }

        public /* bridge */ boolean f(C13865gx c13865gx) {
            return super.contains(c13865gx);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj == null ? true : obj instanceof C13865gx) {
                return w((C13865gx) obj);
            }
            return -1;
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj == null ? true : obj instanceof C13865gx) {
                return C((C13865gx) obj);
            }
            return -1;
        }

        public /* bridge */ int r() {
            return super.size();
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean remove(Object obj) {
            if (obj == null ? true : obj instanceof C13865gx) {
                return D((C13865gx) obj);
            }
            return false;
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ int size() {
            return r();
        }

        public /* bridge */ int w(C13865gx c13865gx) {
            return super.indexOf(c13865gx);
        }
    }

    /* renamed from: ir.nasim.p92$d */
    public static final class d extends ArrayList {
        d(UsersStruct$FullUser usersStruct$FullUser) {
            for (UsersStruct$BotCommand usersStruct$BotCommand : usersStruct$FullUser.getBotCommandsList()) {
                String slashCommand = usersStruct$BotCommand.getSlashCommand();
                String description = usersStruct$BotCommand.getDescription();
                StringValue locKey = usersStruct$BotCommand.getLocKey();
                add(new C20393rw(slashCommand, description, locKey != null ? locKey.getValue() : null));
            }
        }

        public /* bridge */ int C(C20393rw c20393rw) {
            return super.lastIndexOf(c20393rw);
        }

        public /* bridge */ boolean D(C20393rw c20393rw) {
            return super.remove(c20393rw);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj == null ? true : obj instanceof C20393rw) {
                return f((C20393rw) obj);
            }
            return false;
        }

        public /* bridge */ boolean f(C20393rw c20393rw) {
            return super.contains(c20393rw);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj == null ? true : obj instanceof C20393rw) {
                return w((C20393rw) obj);
            }
            return -1;
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj == null ? true : obj instanceof C20393rw) {
                return C((C20393rw) obj);
            }
            return -1;
        }

        public /* bridge */ int r() {
            return super.size();
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ boolean remove(Object obj) {
            if (obj == null ? true : obj instanceof C20393rw) {
                return D((C20393rw) obj);
            }
            return false;
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public final /* bridge */ int size() {
            return r();
        }

        public /* bridge */ int w(C20393rw c20393rw) {
            return super.indexOf(c20393rw);
        }
    }

    private C18732p92() {
    }

    public static final List A(List list) {
        AbstractC13042fc3.i(list, "protoUsers");
        List<PeersStruct$GroupOutPeer> list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        for (PeersStruct$GroupOutPeer peersStruct$GroupOutPeer : list2) {
            arrayList.add(new C25238zy(peersStruct$GroupOutPeer.getGroupId(), peersStruct$GroupOutPeer.getAccessHash()));
        }
        return arrayList;
    }

    public static final List B(List list) {
        AbstractC13042fc3.i(list, "protoUsers");
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(b((GroupsStruct$Group) it.next()));
        }
        return arrayList;
    }

    private final C24653yz B0(MessagingStruct$MessageAttributes messagingStruct$MessageAttributes) {
        if (messagingStruct$MessageAttributes == null) {
            return null;
        }
        BoolValue isMentioned = messagingStruct$MessageAttributes.getIsMentioned();
        Boolean boolValueOf = isMentioned != null ? Boolean.valueOf(isMentioned.getValue()) : null;
        BoolValue isHighlighted = messagingStruct$MessageAttributes.getIsHighlighted();
        Boolean boolValueOf2 = isHighlighted != null ? Boolean.valueOf(isHighlighted.getValue()) : null;
        BoolValue isNotified = messagingStruct$MessageAttributes.getIsNotified();
        Boolean boolValueOf3 = isNotified != null ? Boolean.valueOf(isNotified.getValue()) : null;
        BoolValue isOnlyForYou = messagingStruct$MessageAttributes.getIsOnlyForYou();
        return new C24653yz(boolValueOf, boolValueOf2, boolValueOf3, isOnlyForYou != null ? Boolean.valueOf(isOnlyForYou.getValue()) : null);
    }

    private final EnumC24781zC C(KM7 km7) {
        int i = a.e[km7.ordinal()];
        return i != 1 ? i != 2 ? EnumC24781zC.UNKNOWN : EnumC24781zC.FEMALE : EnumC24781zC.MALE;
    }

    private final C4167Dz E0(MessagingStruct$MessageReaction messagingStruct$MessageReaction) {
        List<Integer> usersList = messagingStruct$MessageReaction.getUsersList();
        String code = messagingStruct$MessageReaction.getCode();
        CollectionsStruct$Int64Value cardinality = messagingStruct$MessageReaction.getCardinality();
        return new C4167Dz(usersList, code, cardinality != null ? Long.valueOf(cardinality.getValue()) : null, g0(messagingStruct$MessageReaction.getExt()));
    }

    public static final Q60 F(EnumC16466lK0 enumC16466lK0) {
        int i = enumC16466lK0 == null ? -1 : a.m[enumC16466lK0.ordinal()];
        if (i != -1) {
            if (i == 1) {
                return Q60.ChargeType_TOPUP;
            }
            if (i == 2) {
                return Q60.ChargeType_WOW;
            }
            if (i == 3) {
                return Q60.ChargeType_VOUCHER;
            }
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return Q60.UNRECOGNIZED;
    }

    private final List F0(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a.E0((MessagingStruct$MessageReaction) it.next()));
        }
        return arrayList;
    }

    public static final EnumC10123b70 G(EnumC8374Vr6 enumC8374Vr6) {
        int i = enumC8374Vr6 == null ? -1 : a.k[enumC8374Vr6.ordinal()];
        if (i != -1) {
            if (i == 1) {
                return EnumC10123b70.ServiceOperator_IRANCELL;
            }
            if (i == 2) {
                return EnumC10123b70.ServiceOperator_MCI;
            }
            if (i == 3) {
                return EnumC10123b70.ServiceOperator_RIGHTEL;
            }
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return EnumC10123b70.UNRECOGNIZED;
    }

    private final C5118Hz G0(MessagingStruct$MessageTag messagingStruct$MessageTag) {
        if (messagingStruct$MessageTag != null) {
            return new C5118Hz(messagingStruct$MessageTag.getText());
        }
        return null;
    }

    private final C16966mA H0(PeersStruct$OutExPeer peersStruct$OutExPeer) {
        return new C16966mA(EnumC9196Yx.p(peersStruct$OutExPeer.getTypeValue()), peersStruct$OutExPeer.getId(), peersStruct$OutExPeer.getAccessHash());
    }

    public static final List J(List list) {
        AbstractC13042fc3.i(list, "protoUsers");
        List<PeersStruct$UserOutPeer> list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        for (PeersStruct$UserOutPeer peersStruct$UserOutPeer : list2) {
            arrayList.add(new C18766pD(peersStruct$UserOutPeer.getUid(), peersStruct$UserOutPeer.getAccessHash()));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final ai.bale.proto.GroupsStruct$Permissions J0(ir.nasim.DA r3) {
        /*
            Method dump skipped, instructions count: 435
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18732p92.J0(ir.nasim.DA):ai.bale.proto.GroupsStruct$Permissions");
    }

    public static final List K(List list) {
        AbstractC13042fc3.i(list, "protoUsers");
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(d((UsersStruct$User) it.next()));
        }
        return arrayList;
    }

    public static final DA K0(GroupsStruct$Permissions groupsStruct$Permissions) {
        if (groupsStruct$Permissions == null) {
            return null;
        }
        boolean seeMessage = groupsStruct$Permissions.getSeeMessage();
        boolean deleteMessage = groupsStruct$Permissions.getDeleteMessage();
        boolean kickUser = groupsStruct$Permissions.getKickUser();
        boolean pinMessage = groupsStruct$Permissions.getPinMessage();
        boolean inviteUser = groupsStruct$Permissions.getInviteUser();
        boolean addAdmin = groupsStruct$Permissions.getAddAdmin();
        boolean changeInfo = groupsStruct$Permissions.getChangeInfo();
        boolean sendMessage = groupsStruct$Permissions.getSendMessage();
        boolean seeMembers = groupsStruct$Permissions.getSeeMembers();
        boolean editMessage = groupsStruct$Permissions.getEditMessage();
        BoolValue sendMedia = groupsStruct$Permissions.getSendMedia();
        Boolean boolValueOf = sendMedia != null ? Boolean.valueOf(sendMedia.getValue()) : null;
        BoolValue sendGifStickers = groupsStruct$Permissions.getSendGifStickers();
        Boolean boolValueOf2 = sendGifStickers != null ? Boolean.valueOf(sendGifStickers.getValue()) : null;
        BoolValue replyToStory = groupsStruct$Permissions.getReplyToStory();
        Boolean boolValueOf3 = replyToStory != null ? Boolean.valueOf(replyToStory.getValue()) : null;
        BoolValue startCall = groupsStruct$Permissions.getStartCall();
        Boolean boolValueOf4 = startCall != null ? Boolean.valueOf(startCall.getValue()) : null;
        BoolValue addStory = groupsStruct$Permissions.getAddStory();
        Boolean boolValueOf5 = addStory != null ? Boolean.valueOf(addStory.getValue()) : null;
        BoolValue manageCall = groupsStruct$Permissions.getManageCall();
        return new DA(seeMessage, deleteMessage, kickUser, pinMessage, inviteUser, addAdmin, changeInfo, sendMessage, seeMembers, editMessage, boolValueOf, boolValueOf2, boolValueOf3, null, null, boolValueOf4, null, null, boolValueOf5, manageCall != null ? Boolean.valueOf(manageCall.getValue()) : null);
    }

    public static final J44 L(MessagingStruct$MessageContainer messagingStruct$MessageContainer) {
        AbstractC13042fc3.i(messagingStruct$MessageContainer, "struct");
        return M(a.C0(messagingStruct$MessageContainer));
    }

    private final C16975mB L0(MessagingStruct$QuotedMessage messagingStruct$QuotedMessage) {
        LC lcD1 = null;
        if (j1(messagingStruct$QuotedMessage) || messagingStruct$QuotedMessage == null) {
            return null;
        }
        CollectionsStruct$Int64Value messageId = messagingStruct$QuotedMessage.getMessageId();
        Long lValueOf = messageId != null ? Long.valueOf(messageId.getValue()) : null;
        Int32Value publicGroupId = messagingStruct$QuotedMessage.getPublicGroupId();
        Integer numValueOf = publicGroupId != null ? Integer.valueOf(publicGroupId.getValue()) : null;
        int senderUserId = messagingStruct$QuotedMessage.getSenderUserId();
        long messageDate = messagingStruct$QuotedMessage.getMessageDate();
        MessagingStruct$Message quotedMessageContent = messagingStruct$QuotedMessage.getQuotedMessageContent();
        AbstractC13042fc3.h(quotedMessageContent, "getQuotedMessageContent(...)");
        AbstractC24063xz abstractC24063xzA0 = A0(quotedMessageContent);
        C17557nA c17557nAI0 = I0(messagingStruct$QuotedMessage.getQuotedPeer());
        if (messagingStruct$QuotedMessage.hasStory()) {
            MessagingStruct$StoryReference story = messagingStruct$QuotedMessage.getStory();
            AbstractC13042fc3.h(story, "getStory(...)");
            lcD1 = d1(story);
        }
        return new C16975mB(lValueOf, numValueOf, senderUserId, messageDate, abstractC24063xzA0, c17557nAI0, lcD1);
    }

    public static final J44 M(C25247zz c25247zz) {
        C8445Vz5 c8445Vz5Y;
        long jLongValue;
        AbstractC13042fc3.i(c25247zz, "historyMessage");
        AbstractC17457n0 abstractC17457n0H = AbstractC17457n0.h(c25247zz.s());
        EnumC23558x74 enumC23558x74K = k(c25247zz.E());
        if (c25247zz.y() != null) {
            boolean z = abstractC17457n0H instanceof C18121o72;
            c8445Vz5Y = C8445Vz5.y(AbstractC5969Lp4.e(), c25247zz.y(), z);
            if (z) {
                abstractC17457n0H = c8445Vz5Y.r();
            }
        } else {
            c8445Vz5Y = null;
        }
        AbstractC17457n0 abstractC17457n0 = abstractC17457n0H;
        C8445Vz5 c8445Vz5 = c8445Vz5Y;
        ArrayList arrayList = new ArrayList();
        Iterator it = c25247zz.z().iterator();
        while (true) {
            long jLongValue2 = 0;
            if (!it.hasNext()) {
                break;
            }
            C4167Dz c4167Dz = (C4167Dz) it.next();
            String strR = c4167Dz.r();
            AbstractC13042fc3.h(strR, "getCode(...)");
            List listS = c4167Dz.s();
            AbstractC13042fc3.h(listS, "getUsers(...)");
            Long lQ = c4167Dz.q();
            if (lQ != null) {
                jLongValue2 = lQ.longValue();
            }
            arrayList.add(new GG5(strR, listS, jLongValue2));
        }
        if (c25247zz.q() != null) {
            Long lQ2 = c25247zz.q();
            AbstractC13042fc3.f(lQ2);
            jLongValue = lQ2.longValue();
        } else {
            jLongValue = 0;
        }
        long jI = c25247zz.i();
        long jH = c25247zz.h();
        long jH2 = c25247zz.h();
        int iD = c25247zz.D();
        AbstractC13042fc3.f(abstractC17457n0);
        int i = jLongValue > 0 ? 1 : 0;
        C3460Az c3460AzW = c25247zz.w();
        C3460Az c3460AzU = c25247zz.u();
        Long lR = c25247zz.r();
        C18732p92 c18732p92 = a;
        C23592xB c23592xBC = c25247zz.C();
        Boolean boolF = c25247zz.F();
        C17532n74 c17532n74D = c18732p92.D(c23592xBC, boolF != null ? boolF.booleanValue() : false);
        Boolean boolF2 = c25247zz.F();
        return new J44(jI, jH, jH2, iD, enumC23558x74K, abstractC17457n0, arrayList, i, c8445Vz5, null, 0L, c3460AzW, c3460AzU, false, lR, c17532n74D, boolF2 != null ? boolF2.booleanValue() : false, null, c18732p92.v1(c25247zz.E()), 139776, null);
    }

    private final XA M0(MessagingStruct$PollMessage messagingStruct$PollMessage) {
        ZA za;
        List<PollStruct$PollOption> optionsList = messagingStruct$PollMessage.getOptionsList();
        AbstractC13042fc3.h(optionsList, "getOptionsList(...)");
        List<PollStruct$PollOption> list = optionsList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (PollStruct$PollOption pollStruct$PollOption : list) {
            arrayList.add(new YA(pollStruct$PollOption.getId(), pollStruct$PollOption.getText()));
        }
        EnumC8283Vh5 type = messagingStruct$PollMessage.getType();
        Integer numValueOf = type != null ? Integer.valueOf(type.getNumber()) : null;
        EnumC9567aB enumC9567aB = (numValueOf != null && numValueOf.intValue() == 0) ? EnumC9567aB.SINGLECHOICE : (numValueOf != null && numValueOf.intValue() == 1) ? EnumC9567aB.MULTIPLECHOICE : EnumC9567aB.UNSUPPORTED_VALUE;
        PollStruct$PollResult result = messagingStruct$PollMessage.getResult();
        if (result != null) {
            List<PollStruct$OptionResult> optionResultsList = result.getOptionResultsList();
            AbstractC13042fc3.h(optionResultsList, "getOptionResultsList(...)");
            List<PollStruct$OptionResult> list2 = optionResultsList;
            ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list2, 10));
            for (PollStruct$OptionResult pollStruct$OptionResult : list2) {
                arrayList2.add(new C12766fA(pollStruct$OptionResult.getOptionId(), pollStruct$OptionResult.getVotesCount()));
            }
            za = new ZA(arrayList2, result.getRecentVotersList(), result.getChosenOptionIdsList(), result.getIsClosed(), result.getPollId(), result.getVotersCount());
        } else {
            za = null;
        }
        return new XA(messagingStruct$PollMessage.getQuestion(), arrayList, messagingStruct$PollMessage.getIsAnonymous(), enumC9567aB, za, messagingStruct$PollMessage.getPollId());
    }

    private final C7732Sz N(MessagingStruct$MultiplexingRow messagingStruct$MultiplexingRow) {
        return new C7732Sz(messagingStruct$MultiplexingRow.getIbanNumber(), messagingStruct$MultiplexingRow.getValue());
    }

    public static final EnumC16466lK0 N0(Q60 q60) {
        int i = q60 == null ? -1 : a.n[q60.ordinal()];
        if (i != -1) {
            if (i == 1) {
                return EnumC16466lK0.TOPUP;
            }
            if (i == 2) {
                return EnumC16466lK0.WOW;
            }
            if (i == 3) {
                return EnumC16466lK0.VOUCHER;
            }
            if (i != 4 && i != 5) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return EnumC16466lK0.UNSUPPORTED_VALUE;
    }

    private final C5316Iv O(MessagingStruct$AnimatedStickerMessage messagingStruct$AnimatedStickerMessage) {
        return new C5316Iv(Integer.valueOf(messagingStruct$AnimatedStickerMessage.getStickerId().getValue()), messagingStruct$AnimatedStickerMessage.getFastPreview().getValue().a0(), o0(messagingStruct$AnimatedStickerMessage.getFileLocation()), Integer.valueOf(messagingStruct$AnimatedStickerMessage.getStickerCollectionId().getValue()), Long.valueOf(messagingStruct$AnimatedStickerMessage.getStickerCollectionAccessHash().getValue()));
    }

    public static final EnumC8374Vr6 O0(EnumC10123b70 enumC10123b70) {
        int i = enumC10123b70 == null ? -1 : a.l[enumC10123b70.ordinal()];
        if (i != -1) {
            if (i == 1) {
                return EnumC8374Vr6.IRANCELL;
            }
            if (i == 2) {
                return EnumC8374Vr6.MCI;
            }
            if (i == 3) {
                return EnumC8374Vr6.RIGHTEL;
            }
            if (i != 4 && i != 5) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return EnumC8374Vr6.UNSUPPORTED_VALUE;
    }

    public static final C5082Hv P(ImagesStruct$AnimatedStickerDescriptor imagesStruct$AnimatedStickerDescriptor) {
        if (imagesStruct$AnimatedStickerDescriptor == null) {
            return null;
        }
        return new C5082Hv(imagesStruct$AnimatedStickerDescriptor.getId(), imagesStruct$AnimatedStickerDescriptor.getEmoji().getValue(), o0(imagesStruct$AnimatedStickerDescriptor.getFileLocation()));
    }

    private final C4857Gw P0(MeetStruct$Call meetStruct$Call) {
        C22993wA c22993wAR0;
        long id = meetStruct$Call.getId();
        String token = meetStruct$Call.getToken();
        String room = meetStruct$Call.getRoom();
        String value = meetStruct$Call.hasUrl() ? meetStruct$Call.getUrl().getValue() : null;
        boolean video = meetStruct$Call.getVideo();
        long createDate = meetStruct$Call.getCreateDate();
        long startDate = meetStruct$Call.getStartDate();
        int adminUid = meetStruct$Call.getAdminUid();
        if (meetStruct$Call.hasPeer()) {
            PeersStruct$Peer peer = meetStruct$Call.getPeer();
            AbstractC13042fc3.h(peer, "getPeer(...)");
            c22993wAR0 = R0(peer);
        } else {
            c22993wAR0 = null;
        }
        return new C4857Gw(id, token, room, value, video, createDate, startDate, adminUid, c22993wAR0, meetStruct$Call.getDuration(), EnumC5091Hw.p(meetStruct$Call.getDiscardReasonValue()), meetStruct$Call.getIsLivekit(), meetStruct$Call.hasDiscardServiceMessageRid() ? Long.valueOf(meetStruct$Call.getDiscardServiceMessageRid().getValue()) : null, meetStruct$Call.hasDiscardServiceMessageDate() ? Long.valueOf(meetStruct$Call.getDiscardServiceMessageDate().getValue()) : null);
    }

    private final C7498Rz Q(MessagingStruct$MultiplexingData messagingStruct$MultiplexingData) {
        EnumC21409tc4 multiplexingType = messagingStruct$MultiplexingData.getMultiplexingType();
        AbstractC13042fc3.h(multiplexingType, "getMultiplexingType(...)");
        EnumC7971Tz enumC7971TzI1 = i1(multiplexingType);
        List<MessagingStruct$MultiplexingRow> multiplexingRowsList = messagingStruct$MultiplexingData.getMultiplexingRowsList();
        AbstractC13042fc3.h(multiplexingRowsList, "getMultiplexingRowsList(...)");
        List<MessagingStruct$MultiplexingRow> list = multiplexingRowsList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (MessagingStruct$MultiplexingRow messagingStruct$MultiplexingRow : list) {
            C18732p92 c18732p92 = a;
            AbstractC13042fc3.f(messagingStruct$MultiplexingRow);
            arrayList.add(c18732p92.N(messagingStruct$MultiplexingRow));
        }
        return new C7498Rz(enumC7971TzI1, arrayList);
    }

    private final C24054xy Q0(MeetStruct$GroupCall meetStruct$GroupCall) {
        C16966mA c16966mAH0;
        long id = meetStruct$GroupCall.getId();
        String room = meetStruct$GroupCall.getRoom();
        String token = meetStruct$GroupCall.getToken();
        OC oc = meetStruct$GroupCall.hasUrl() ? new OC(meetStruct$GroupCall.getUrl().getText()) : null;
        boolean video = meetStruct$GroupCall.getVideo();
        Long lValueOf = meetStruct$GroupCall.hasCreateDate() ? Long.valueOf(meetStruct$GroupCall.getCreateDate().getValue()) : null;
        C5577Jy c5577Jy = meetStruct$GroupCall.hasDuration() ? new C5577Jy(meetStruct$GroupCall.getDuration().getValue()) : null;
        int initiatorUserId = meetStruct$GroupCall.getInitiatorUserId();
        if (meetStruct$GroupCall.hasPeer()) {
            PeersStruct$OutExPeer peer = meetStruct$GroupCall.getPeer();
            AbstractC13042fc3.h(peer, "getPeer(...)");
            c16966mAH0 = H0(peer);
        } else {
            c16966mAH0 = null;
        }
        EnumC5325Iw enumC5325IwP = EnumC5325Iw.p(meetStruct$GroupCall.getModeValue());
        String link = meetStruct$GroupCall.getLink();
        boolean isPublic = meetStruct$GroupCall.getIsPublic();
        String title = meetStruct$GroupCall.getTitle();
        List<PeersStruct$OutExPeer> inCallParticipantsList = meetStruct$GroupCall.getInCallParticipantsList();
        AbstractC13042fc3.h(inCallParticipantsList, "getInCallParticipantsList(...)");
        List<PeersStruct$OutExPeer> list = inCallParticipantsList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (PeersStruct$OutExPeer peersStruct$OutExPeer : list) {
            C18732p92 c18732p92 = a;
            AbstractC13042fc3.f(peersStruct$OutExPeer);
            arrayList.add(c18732p92.H0(peersStruct$OutExPeer));
        }
        Long lValueOf2 = meetStruct$GroupCall.hasEndDate() ? Long.valueOf(meetStruct$GroupCall.getEndDate().getValue()) : null;
        List<MeetStruct$JoinRequest> pendingRequestsList = meetStruct$GroupCall.getPendingRequestsList();
        AbstractC13042fc3.h(pendingRequestsList, "getPendingRequestsList(...)");
        List<MeetStruct$JoinRequest> list2 = pendingRequestsList;
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            MeetStruct$JoinRequest meetStruct$JoinRequest = (MeetStruct$JoinRequest) it.next();
            Iterator it2 = it;
            C18732p92 c18732p922 = a;
            AbstractC13042fc3.f(meetStruct$JoinRequest);
            arrayList2.add(c18732p922.s0(meetStruct$JoinRequest));
            it = it2;
        }
        return new C24054xy(id, room, token, oc, video, lValueOf, c5577Jy, initiatorUserId, c16966mAH0, enumC5325IwP, link, isPublic, title, arrayList, lValueOf2, arrayList2, meetStruct$GroupCall.getRaisedHandsUserIdentitiesList());
    }

    public static final C6984Pv R(FilesStruct$Avatar filesStruct$Avatar) {
        if (filesStruct$Avatar == null) {
            return null;
        }
        C7228Qv c7228QvS = S(filesStruct$Avatar.hasSmallImage() ? filesStruct$Avatar.getSmallImage() : null);
        C7228Qv c7228QvS2 = S(filesStruct$Avatar.hasLargeImage() ? filesStruct$Avatar.getLargeImage() : null);
        C7228Qv c7228QvS3 = S(filesStruct$Avatar.hasFullImage() ? filesStruct$Avatar.getFullImage() : null);
        CollectionsStruct$Int64Value id = filesStruct$Avatar.getId();
        Long lValueOf = id != null ? Long.valueOf(id.getValue()) : null;
        CollectionsStruct$Int64Value date = filesStruct$Avatar.getDate();
        return new C6984Pv(c7228QvS, c7228QvS2, c7228QvS3, lValueOf, date != null ? Long.valueOf(date.getValue()) : null);
    }

    private final C22993wA R0(PeersStruct$Peer peersStruct$Peer) {
        return new C22993wA(CA.p(peersStruct$Peer.getTypeValue()), peersStruct$Peer.getId());
    }

    public static final C7228Qv S(FilesStruct$AvatarImage filesStruct$AvatarImage) {
        if (filesStruct$AvatarImage == null) {
            return null;
        }
        return new C7228Qv(i0(filesStruct$AvatarImage.getFileLocation()), filesStruct$AvatarImage.getWidth(), filesStruct$AvatarImage.getHeight(), filesStruct$AvatarImage.getFileSize());
    }

    private final C18757pC S0(MessagingStruct$ServiceExPhoneCall messagingStruct$ServiceExPhoneCall) {
        C4857Gw c4857GwP0;
        int duration = messagingStruct$ServiceExPhoneCall.getDuration();
        Long lValueOf = messagingStruct$ServiceExPhoneCall.hasStartDate() ? Long.valueOf(messagingStruct$ServiceExPhoneCall.getStartDate().getValue()) : null;
        EnumC5091Hw enumC5091HwP = EnumC5091Hw.p(messagingStruct$ServiceExPhoneCall.getDiscardReasonValue());
        Boolean boolValueOf = messagingStruct$ServiceExPhoneCall.hasIsVideo() ? Boolean.valueOf(messagingStruct$ServiceExPhoneCall.getIsVideo().getValue()) : null;
        C19811qz c19811qzG0 = g0(messagingStruct$ServiceExPhoneCall.getExtMap());
        if (messagingStruct$ServiceExPhoneCall.hasCall()) {
            MeetStruct$Call call = messagingStruct$ServiceExPhoneCall.getCall();
            AbstractC13042fc3.h(call, "getCall(...)");
            c4857GwP0 = P0(call);
        } else {
            c4857GwP0 = null;
        }
        return new C18757pC(duration, lValueOf, enumC5091HwP, boolValueOf, c19811qzG0, c4857GwP0);
    }

    private final C10015aw T(MessagingStruct$BankAccount messagingStruct$BankAccount) {
        return new C10015aw(messagingStruct$BankAccount.getAccountNumber(), messagingStruct$BankAccount.getBranchCode(), messagingStruct$BankAccount.getOpenDate(), messagingStruct$BankAccount.getRate(), messagingStruct$BankAccount.getAvailableBalance(), messagingStruct$BankAccount.getLastMoneyTransferDate(), messagingStruct$BankAccount.getFirstName(), messagingStruct$BankAccount.getLastName());
    }

    private final AbstractC24063xz T0(MessagingStruct$PurchaseMessage messagingStruct$PurchaseMessage) {
        MessagingStruct$Message msg = messagingStruct$PurchaseMessage.getMsg();
        AbstractC13042fc3.h(msg, "getMsg(...)");
        AbstractC24063xz abstractC24063xzA0 = A0(msg);
        String accountNumber = messagingStruct$PurchaseMessage.getAccountNumber();
        long amount = messagingStruct$PurchaseMessage.getAmount();
        String value = messagingStruct$PurchaseMessage.getRegexAmount().getValue();
        EnumC18998pc4 requestType = messagingStruct$PurchaseMessage.getRequestType();
        AbstractC13042fc3.h(requestType, "getRequestType(...)");
        EnumC7264Qz enumC7264QzH1 = h1(requestType);
        MessagingStruct$MultiplexingData multiplexingData = messagingStruct$PurchaseMessage.getMultiplexingData();
        AbstractC13042fc3.h(multiplexingData, "getMultiplexingData(...)");
        C7498Rz c7498RzQ = Q(multiplexingData);
        List<CollectionsStruct$MapValueItem> itemsList = messagingStruct$PurchaseMessage.getAdditionalInfo().getItemsList();
        AbstractC13042fc3.h(itemsList, "getItemsList(...)");
        List<CollectionsStruct$MapValueItem> list = itemsList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(x0((CollectionsStruct$MapValueItem) it.next()));
        }
        return new C16384lB(abstractC24063xzA0, accountNumber, amount, value, enumC7264QzH1, c7498RzQ, new C19811qz(arrayList), messagingStruct$PurchaseMessage.getTargetWalletId().getValue());
    }

    private final AbstractC24063xz U(MessagingStruct$BankMessage messagingStruct$BankMessage) {
        AbstractC10632bw abstractC10632bwV;
        MessagingStruct$BankEx.b traitCase = messagingStruct$BankMessage.getBankEx().getTraitCase();
        int i = traitCase == null ? -1 : a.s[traitCase.ordinal()];
        if (i == 1) {
            MessagingStruct$BankMoneyTransfer bankMoneyTransfer = messagingStruct$BankMessage.getBankEx().getBankMoneyTransfer();
            AbstractC13042fc3.h(bankMoneyTransfer, "getBankMoneyTransfer(...)");
            abstractC10632bwV = V(bankMoneyTransfer);
        } else if (i == 2) {
            MessagingStruct$BankRemain bankRemain = messagingStruct$BankMessage.getBankEx().getBankRemain();
            AbstractC13042fc3.h(bankRemain, "getBankRemain(...)");
            abstractC10632bwV = W(bankRemain);
        } else if (i == 3) {
            MessagingStruct$BankTransaction bankTransaction = messagingStruct$BankMessage.getBankEx().getBankTransaction();
            AbstractC13042fc3.h(bankTransaction, "getBankTransaction(...)");
            abstractC10632bwV = X(bankTransaction);
        } else if (i != 4) {
            abstractC10632bwV = new C11395cw(0, null);
        } else {
            MessagingStruct$ReceiptMessage receiptMessage = messagingStruct$BankMessage.getBankEx().getReceiptMessage();
            AbstractC13042fc3.h(receiptMessage, "getReceiptMessage(...)");
            abstractC10632bwV = W0(receiptMessage);
        }
        return new C12038dw(abstractC10632bwV);
    }

    private final C12629ew V(MessagingStruct$BankMoneyTransfer messagingStruct$BankMoneyTransfer) {
        MessagingStruct$BankAccount originAccount = messagingStruct$BankMoneyTransfer.getOriginAccount();
        AbstractC13042fc3.h(originAccount, "getOriginAccount(...)");
        C10015aw c10015awT = T(originAccount);
        MessagingStruct$BankAccount destAccount = messagingStruct$BankMoneyTransfer.getDestAccount();
        AbstractC13042fc3.h(destAccount, "getDestAccount(...)");
        return new C12629ew(c10015awT, T(destAccount), messagingStruct$BankMoneyTransfer.getMoneyTransferVal(), messagingStruct$BankMoneyTransfer.getReferenceNumber(), messagingStruct$BankMoneyTransfer.getPaymentCode(), messagingStruct$BankMoneyTransfer.getDescription().getValue(), messagingStruct$BankMoneyTransfer.getMoneyTransferDate(), Integer.valueOf(messagingStruct$BankMoneyTransfer.getBranch().getValue()));
    }

    public static final AbstractC17566nB V0(CollectionsStruct$RawValue collectionsStruct$RawValue) {
        if (collectionsStruct$RawValue == null) {
            return null;
        }
        if (collectionsStruct$RawValue.hasInt32Value()) {
            return new C5577Jy(collectionsStruct$RawValue.getInt32Value());
        }
        if (collectionsStruct$RawValue.hasInt64Value()) {
            return new C5811Ky(collectionsStruct$RawValue.getInt64Value());
        }
        if (collectionsStruct$RawValue.hasDoubleValue()) {
            return new C6529Nx(collectionsStruct$RawValue.getDoubleValue());
        }
        if (collectionsStruct$RawValue.hasStringValue()) {
            return new OC(collectionsStruct$RawValue.getStringValue());
        }
        if (collectionsStruct$RawValue.hasBooleanValue()) {
            return new C19784qw(collectionsStruct$RawValue.getBooleanValue());
        }
        return null;
    }

    private final C13265fw W(MessagingStruct$BankRemain messagingStruct$BankRemain) {
        MessagingStruct$BankAccount bankAccount = messagingStruct$BankRemain.getBankAccount();
        AbstractC13042fc3.h(bankAccount, "getBankAccount(...)");
        return new C13265fw(T(bankAccount), messagingStruct$BankRemain.getRemainDate());
    }

    private final C21142tB W0(MessagingStruct$ReceiptMessage messagingStruct$ReceiptMessage) {
        CollectionsStruct$MapValue message = messagingStruct$ReceiptMessage.getMessage();
        AbstractC13042fc3.h(message, "getMessage(...)");
        C19811qz c19811qzW0 = w0(message);
        CollectionsStruct$MapValue message2 = messagingStruct$ReceiptMessage.getMessage();
        AbstractC13042fc3.h(message2, "getMessage(...)");
        return new C21142tB(c19811qzW0, w0(message2));
    }

    private final C13856gw X(MessagingStruct$BankTransaction messagingStruct$BankTransaction) {
        List<MessagingStruct$Transaction> transactionsList = messagingStruct$BankTransaction.getTransactionsList();
        AbstractC13042fc3.h(transactionsList, "getTransactionsList(...)");
        List<MessagingStruct$Transaction> list = transactionsList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (Iterator it = list.iterator(); it.hasNext(); it = it) {
            MessagingStruct$Transaction messagingStruct$Transaction = (MessagingStruct$Transaction) it.next();
            arrayList.add(new C12811fD(messagingStruct$Transaction.getId(), messagingStruct$Transaction.getTransactionName(), messagingStruct$Transaction.getTransactionChannel(), messagingStruct$Transaction.getTransactionDate(), messagingStruct$Transaction.getTransactionAmountWithSign(), messagingStruct$Transaction.getTransactionType(), messagingStruct$Transaction.getCategoryId(), messagingStruct$Transaction.getComment(), messagingStruct$Transaction.getBrno(), messagingStruct$Transaction.getTransactionTrace(), Integer.valueOf(messagingStruct$Transaction.getHyperLink().getValue())));
        }
        return new C13856gw(arrayList);
    }

    private final C23592xB X0(MessagingStruct$Replies messagingStruct$Replies) {
        if (messagingStruct$Replies == null) {
            return null;
        }
        int repliesCount = messagingStruct$Replies.getRepliesCount();
        List<PeersStruct$UserOutPeer> recentRepliersList = messagingStruct$Replies.getRecentRepliersList();
        AbstractC13042fc3.h(recentRepliersList, "getRecentRepliersList(...)");
        List<PeersStruct$UserOutPeer> list = recentRepliersList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(w1((PeersStruct$UserOutPeer) it.next()));
        }
        return new C23592xB(repliesCount, arrayList, D0(messagingStruct$Replies.getLastMessage()));
    }

    private final AbstractC24063xz Y(MessagingStruct$BannedMessage messagingStruct$BannedMessage) {
        return new C14449hw(EnumC9412Zv.p(messagingStruct$BannedMessage.getBanReasonValue()));
    }

    private final C23011wC Y0(MessagingStruct$ServiceMessage messagingStruct$ServiceMessage) {
        String text = messagingStruct$ServiceMessage.getText();
        MessagingStruct$ServiceEx ext = messagingStruct$ServiceMessage.getExt();
        AbstractC13042fc3.h(ext, "getExt(...)");
        return new C23011wC(text, Z0(ext));
    }

    private final C19193pw Z(MessagingStruct$BinaryMessage messagingStruct$BinaryMessage) {
        return new C19193pw(messagingStruct$BinaryMessage.getContentTag(), messagingStruct$BinaryMessage.getMsg().a0());
    }

    private final VB Z0(MessagingStruct$ServiceEx messagingStruct$ServiceEx) {
        VB c20548sC;
        MessagingStruct$ServiceEx.b traitCase = messagingStruct$ServiceEx.getTraitCase();
        switch (traitCase == null ? -1 : a.q[traitCase.ordinal()]) {
            case 1:
                c20548sC = new C20548sC(messagingStruct$ServiceEx.getServiceExUserInvited().getInvitedUid());
                break;
            case 2:
                c20548sC = new C21825uC(messagingStruct$ServiceEx.getServiceExUserKicked().getKickedUid());
                break;
            case 3:
                c20548sC = new C22415vC(messagingStruct$ServiceEx.getServiceExUserLeft().getLeftUid());
                break;
            case 4:
                return new C16393lC();
            case 5:
                c20548sC = new C10786cC(messagingStruct$ServiceEx.getServiceExChangedTitle().getTitle());
                break;
            case 6:
                c20548sC = new C9576aC(R(messagingStruct$ServiceEx.getServiceExChangedAvatar().getAvatar()));
                break;
            case 7:
                c20548sC = new C13420gC(messagingStruct$ServiceEx.getServiceExContactRegistered().getUid());
                break;
            case 8:
                return new C19348qC();
            case 9:
                MessagingStruct$ServiceExPhoneCall serviceExPhoneCall = messagingStruct$ServiceEx.getServiceExPhoneCall();
                AbstractC13042fc3.h(serviceExPhoneCall, "getServiceExPhoneCall(...)");
                return S0(serviceExPhoneCall);
            case 10:
                return new C21151tC();
            case 11:
                c20548sC = new C11550dC(messagingStruct$ServiceEx.getServiceExChangedTopic().getTopic().getValue());
                break;
            case 12:
                c20548sC = new ZB(messagingStruct$ServiceEx.getServiceExChangedAbout().getAbout().getValue());
                break;
            case 13:
                return new C12193eC();
            case 14:
                return new C12802fC();
            case 15:
                return new XB();
            case 16:
                MessagingStruct$ServiceExGroupCallStarted serviceExGroupCallStarted = messagingStruct$ServiceEx.getServiceExGroupCallStarted();
                MeetStruct$GroupCall groupCall = serviceExGroupCallStarted.getGroupCall();
                AbstractC13042fc3.h(groupCall, "getGroupCall(...)");
                c20548sC = new C15802kC(Q0(groupCall), g0(serviceExGroupCallStarted.getExtMap()));
                break;
            case 17:
                return new C17575nC();
            case 18:
                MessagingStruct$ServiceExGroupCallEnded serviceExGroupCallEnded = messagingStruct$ServiceEx.getServiceExGroupCallEnded();
                MeetStruct$GroupCall groupCall2 = serviceExGroupCallEnded.getGroupCall();
                AbstractC13042fc3.h(groupCall2, "getGroupCall(...)");
                c20548sC = new C15211jC(Q0(groupCall2), serviceExGroupCallEnded.getMissed(), g0(serviceExGroupCallEnded.getExtMap()));
                break;
            case 19:
                c20548sC = new WB(messagingStruct$ServiceEx.getServiceExAnonymousContact().getDesc().getValue());
                break;
            case 20:
                c20548sC = new C10170bC(messagingStruct$ServiceEx.getServiceExChangedNick().getNick().getValue());
                break;
            case 21:
                MessagingStruct$ServiceExGiftPacketOpened serviceExGiftPacketOpened = messagingStruct$ServiceEx.getServiceExGiftPacketOpened();
                return new C14011hC(serviceExGiftPacketOpened.getUserId(), serviceExGiftPacketOpened.getMsgRid(), serviceExGiftPacketOpened.getMsgDate());
            case 22:
                MessagingStruct$ServiceExGiftPacketOpenedCompact serviceExGiftPacketOpenedCompact = messagingStruct$ServiceEx.getServiceExGiftPacketOpenedCompact();
                return new C14613iC(serviceExGiftPacketOpenedCompact.getLastUserId(), serviceExGiftPacketOpenedCompact.getOthersCount(), serviceExGiftPacketOpenedCompact.getMsgRid(), serviceExGiftPacketOpenedCompact.getMsgDate());
            case 23:
                MessagingStruct$ServiceExCallRecordStateChanged serviceExCallRecordStateChanged = messagingStruct$ServiceEx.getServiceExCallRecordStateChanged();
                c20548sC = new YB(serviceExCallRecordStateChanged.getStarterUserId(), serviceExCallRecordStateChanged.getIsStarted());
                break;
            case 24:
                return new C16984mC();
            case 25:
                return new C18166oC();
            case 26:
                return null;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return c20548sC;
    }

    public static final EnumC6619Oh a(EnumC4599Fv enumC4599Fv) {
        return (enumC4599Fv == null || enumC4599Fv != EnumC4599Fv.BANNER_AND_NATIVE) ? (enumC4599Fv == null || enumC4599Fv != EnumC4599Fv.BANNER) ? (enumC4599Fv == null || enumC4599Fv != EnumC4599Fv.NATIVE) ? EnumC6619Oh.NONE : EnumC6619Oh.NATIVE : EnumC6619Oh.BANNER : EnumC6619Oh.BANNER_AND_NATIVE;
    }

    private final AbstractC24063xz a0(MessagingStruct$CrowdFundingMessage messagingStruct$CrowdFundingMessage) {
        long totalAmount = messagingStruct$CrowdFundingMessage.getTotalAmount();
        String cardNumber = messagingStruct$CrowdFundingMessage.getCardNumber();
        long sliceAmount = messagingStruct$CrowdFundingMessage.getSliceAmount();
        String title = messagingStruct$CrowdFundingMessage.getTitle();
        String description = messagingStruct$CrowdFundingMessage.getDescription();
        long endDate = messagingStruct$CrowdFundingMessage.getEndDate();
        EnumC16838lx enumC16838lxB0 = b0(messagingStruct$CrowdFundingMessage.getStatus());
        C6035Lx c6035LxD0 = d0(messagingStruct$CrowdFundingMessage.getPhoto());
        AbstractC13042fc3.g(c6035LxD0, "null cannot be cast to non-null type ir.nasim.core.api.ApiDocumentMessage");
        return new C16247kx(totalAmount, cardNumber, sliceAmount, title, description, endDate, enumC16838lxB0, c6035LxD0);
    }

    public static final GC a1(ImagesStruct$StickerCollection imagesStruct$StickerCollection) {
        if (imagesStruct$StickerCollection == null) {
            return null;
        }
        int id = imagesStruct$StickerCollection.getId();
        long accessHash = imagesStruct$StickerCollection.getAccessHash();
        List<ImagesStruct$StickerDescriptor> stickersList = imagesStruct$StickerCollection.getStickersList();
        AbstractC13042fc3.h(stickersList, "getStickersList(...)");
        List<ImagesStruct$StickerDescriptor> list = stickersList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(b1((ImagesStruct$StickerDescriptor) it.next()));
        }
        Boolean boolValueOf = Boolean.valueOf(imagesStruct$StickerCollection.getAnimated().getValue());
        List<ImagesStruct$AnimatedStickerDescriptor> animatedStickersList = imagesStruct$StickerCollection.getAnimatedStickersList();
        AbstractC13042fc3.h(animatedStickersList, "getAnimatedStickersList(...)");
        List<ImagesStruct$AnimatedStickerDescriptor> list2 = animatedStickersList;
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(P((ImagesStruct$AnimatedStickerDescriptor) it2.next()));
        }
        return new GC(id, accessHash, arrayList, boolValueOf, arrayList2, imagesStruct$StickerCollection.getName().getValue());
    }

    public static final C23464wy b(GroupsStruct$Group groupsStruct$Group) {
        AbstractC13042fc3.i(groupsStruct$Group, "group");
        int id = groupsStruct$Group.getId();
        long accessHash = groupsStruct$Group.getAccessHash();
        String title = groupsStruct$Group.getTitle();
        C6984Pv c6984PvR = R(groupsStruct$Group.getAvatar());
        Int32Value membersCount = groupsStruct$Group.getMembersCount();
        Integer numValueOf = membersCount != null ? Integer.valueOf(membersCount.getValue()) : null;
        BoolValue isMember = groupsStruct$Group.getIsMember();
        Boolean boolValueOf = isMember != null ? Boolean.valueOf(isMember.getValue()) : null;
        BoolValue isHidden = groupsStruct$Group.getIsHidden();
        Boolean boolValueOf2 = isHidden != null ? Boolean.valueOf(isHidden.getValue()) : null;
        EnumC3690By enumC3690By = groupsStruct$Group.getGroupType() == EnumC24932zS2.GroupType_GROUP ? EnumC3690By.GROUP : EnumC3690By.CHANNEL;
        BoolValue canSendMessage = groupsStruct$Group.getCanSendMessage();
        Boolean boolValueOf3 = canSendMessage != null ? Boolean.valueOf(canSendMessage.getValue()) : null;
        CollectionsStruct$MapValue ext = groupsStruct$Group.getExt();
        AbstractC13042fc3.h(ext, "getExt(...)");
        C19811qz c19811qzW0 = w0(ext);
        StringValue nick = groupsStruct$Group.getNick();
        String value = nick != null ? nick.getValue() : null;
        BoolValue becameOrphaned = groupsStruct$Group.getBecameOrphaned();
        Boolean boolValueOf4 = becameOrphaned != null ? Boolean.valueOf(becameOrphaned.getValue()) : null;
        CollectionsStruct$Int64Value stateVersion = groupsStruct$Group.getStateVersion();
        Long lValueOf = stateVersion != null ? Long.valueOf(stateVersion.getValue()) : null;
        DA daK0 = K0(groupsStruct$Group.getPermissions());
        DA daK02 = K0(groupsStruct$Group.getDefaultPermissions());
        Int32Value ownerUid = groupsStruct$Group.getOwnerUid();
        Integer numValueOf2 = ownerUid != null ? Integer.valueOf(ownerUid.getValue()) : null;
        List<String> availableReactionsList = groupsStruct$Group.getAvailableReactionsList();
        BoolValue isSuspend = groupsStruct$Group.getIsSuspend();
        Boolean boolValueOf5 = isSuspend != null ? Boolean.valueOf(isSuspend.getValue()) : null;
        Int32Value linkedGroupPeerId = groupsStruct$Group.getLinkedGroupPeerId();
        Integer numValueOf3 = linkedGroupPeerId != null ? Integer.valueOf(linkedGroupPeerId.getValue()) : null;
        BoolValue discussionGroupEnabled = groupsStruct$Group.getDiscussionGroupEnabled();
        return new C23464wy(id, accessHash, title, c6984PvR, numValueOf, boolValueOf, boolValueOf2, enumC3690By, boolValueOf3, c19811qzW0, value, boolValueOf4, lValueOf, daK0, daK02, numValueOf2, availableReactionsList, boolValueOf5, numValueOf3, discussionGroupEnabled != null ? Boolean.valueOf(discussionGroupEnabled.getValue()) : null);
    }

    private final EnumC16838lx b0(EnumC12424eb4 enumC12424eb4) {
        if (enumC12424eb4 != null) {
            return EnumC16838lx.p(enumC12424eb4.getNumber() + 1);
        }
        return null;
    }

    public static final HC b1(ImagesStruct$StickerDescriptor imagesStruct$StickerDescriptor) {
        if (imagesStruct$StickerDescriptor == null) {
            return null;
        }
        return new HC(imagesStruct$StickerDescriptor.getId(), imagesStruct$StickerDescriptor.getEmoji().getValue(), o0(imagesStruct$StickerDescriptor.getImage128()), o0(imagesStruct$StickerDescriptor.getImage512()), o0(imagesStruct$StickerDescriptor.getImage256()));
    }

    public static final C19811qz c(CollectionsStruct$MapValue collectionsStruct$MapValue) {
        AbstractC13042fc3.i(collectionsStruct$MapValue, "map");
        List<CollectionsStruct$MapValueItem> itemsList = collectionsStruct$MapValue.getItemsList();
        AbstractC13042fc3.h(itemsList, "getItemsList(...)");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = itemsList.iterator();
        while (it.hasNext()) {
            C20420rz c20420rzX0 = x0((CollectionsStruct$MapValueItem) it.next());
            if (c20420rzX0 != null) {
                arrayList.add(c20420rzX0);
            }
        }
        return new C19811qz(arrayList);
    }

    private final AbstractC4383Ex c0(MessagingStruct$DocumentEx messagingStruct$DocumentEx) {
        AbstractC4383Ex c5802Kx;
        if (messagingStruct$DocumentEx.hasDocumentExAudio()) {
            int duration = messagingStruct$DocumentEx.getDocumentExAudio().getDuration();
            String album = messagingStruct$DocumentEx.getDocumentExAudio().getAlbum();
            String artist = messagingStruct$DocumentEx.getDocumentExAudio().getArtist();
            String genre = messagingStruct$DocumentEx.getDocumentExAudio().getGenre();
            String track = messagingStruct$DocumentEx.getDocumentExAudio().getTrack();
            BytesValue cover = messagingStruct$DocumentEx.getDocumentExAudio().getCover();
            c5802Kx = new C4617Fx(duration, album, artist, genre, track, cover != null ? cover.toByteArray() : null);
        } else {
            if (messagingStruct$DocumentEx.hasDocumentExGif()) {
                return new C4866Gx(messagingStruct$DocumentEx.getDocumentExGif().getW(), messagingStruct$DocumentEx.getDocumentExGif().getH(), messagingStruct$DocumentEx.getDocumentExGif().getDuration());
            }
            if (messagingStruct$DocumentEx.hasDocumentExPhoto()) {
                return new C5100Hx(messagingStruct$DocumentEx.getDocumentExPhoto().getW(), messagingStruct$DocumentEx.getDocumentExPhoto().getH());
            }
            if (messagingStruct$DocumentEx.hasDocumentExVideo()) {
                return new C5568Jx(messagingStruct$DocumentEx.getDocumentExVideo().getW(), messagingStruct$DocumentEx.getDocumentExVideo().getH(), messagingStruct$DocumentEx.getDocumentExVideo().getDuration());
            }
            if (!messagingStruct$DocumentEx.hasDocumentExVoice()) {
                return null;
            }
            int duration2 = messagingStruct$DocumentEx.getDocumentExVoice().getDuration();
            StringValue transcript = messagingStruct$DocumentEx.getDocumentExVoice().getTranscript();
            c5802Kx = new C5802Kx(duration2, transcript != null ? transcript.getValue() : null);
        }
        return c5802Kx;
    }

    private final IC c1(MessagingStruct$StickerMessage messagingStruct$StickerMessage) {
        return new IC(Integer.valueOf(messagingStruct$StickerMessage.getStickerId().getValue()), messagingStruct$StickerMessage.getFastPreview().getValue().a0(), o0(messagingStruct$StickerMessage.getImage512()), o0(messagingStruct$StickerMessage.getImage256()), Integer.valueOf(messagingStruct$StickerMessage.getStickerCollectionId().getValue()), Long.valueOf(messagingStruct$StickerMessage.getStickerCollectionAccessHash().getValue()));
    }

    public static final C15811kD d(UsersStruct$User usersStruct$User) {
        BoolValue hasTimcheProfile;
        BoolValue hasMainMiniApp;
        StringValue botActiveUsers;
        AbstractC13042fc3.i(usersStruct$User, "protoUser");
        int id = usersStruct$User.getId();
        long accessHash = usersStruct$User.getAccessHash();
        String name = usersStruct$User.getName();
        StringValue localName = usersStruct$User.getLocalName();
        String value = localName != null ? localName.getValue() : null;
        StringValue nick = usersStruct$User.getNick();
        String value2 = nick != null ? nick.getValue() : null;
        C18732p92 c18732p92 = a;
        KM7 sex = usersStruct$User.getSex();
        AbstractC13042fc3.h(sex, "getSex(...)");
        EnumC24781zC enumC24781zCC = c18732p92.C(sex);
        C6984Pv c6984PvR = R(usersStruct$User.getAvatar());
        BoolValue isBot = usersStruct$User.getIsBot();
        Boolean boolValueOf = isBot != null ? Boolean.valueOf(isBot.getValue()) : null;
        C19811qz c19811qzG0 = g0(usersStruct$User.getExt());
        CollectionsStruct$Int64Value stateVersion = usersStruct$User.getStateVersion();
        Long lValueOf = stateVersion != null ? Long.valueOf(stateVersion.getValue()) : null;
        BoolValue isDeleted = usersStruct$User.getIsDeleted();
        Boolean boolValueOf2 = isDeleted != null ? Boolean.valueOf(isDeleted.getValue()) : null;
        EnumC14002hB enumC14002hBP = EnumC14002hB.p(usersStruct$User.getPuppeteer().ordinal());
        CollectionsStruct$Int64Value createdAt = usersStruct$User.getCreatedAt();
        Long lValueOf2 = createdAt != null ? Long.valueOf(createdAt.getValue()) : null;
        UsersStruct$BotExInfo botExInfo = usersStruct$User.getBotExInfo();
        String value3 = (botExInfo == null || (botActiveUsers = botExInfo.getBotActiveUsers()) == null) ? null : botActiveUsers.getValue();
        UsersStruct$BotExInfo botExInfo2 = usersStruct$User.getBotExInfo();
        Boolean boolValueOf3 = (botExInfo2 == null || (hasMainMiniApp = botExInfo2.getHasMainMiniApp()) == null) ? null : Boolean.valueOf(hasMainMiniApp.getValue());
        UsersStruct$BotExInfo botExInfo3 = usersStruct$User.getBotExInfo();
        C7021Py c7021PyP0 = c18732p92.p0(botExInfo3 != null ? botExInfo3.getIntro() : null);
        UsersStruct$BotExInfo botExInfo4 = usersStruct$User.getBotExInfo();
        C7723Sy c7723SyR0 = c18732p92.r0(botExInfo4 != null ? botExInfo4.getIntroMessage() : null);
        UsersStruct$BotExInfo botExInfo5 = usersStruct$User.getBotExInfo();
        return new C15811kD(id, accessHash, name, value, value2, enumC24781zCC, c6984PvR, boolValueOf, c19811qzG0, lValueOf, boolValueOf2, enumC14002hBP, lValueOf2, new C20983sw(value3, boolValueOf3, c7021PyP0, c7723SyR0, (botExInfo5 == null || (hasTimcheProfile = botExInfo5.getHasTimcheProfile()) == null) ? null : Boolean.valueOf(hasTimcheProfile.getValue())));
    }

    private final C8205Uz e0(MessagingStruct$Message messagingStruct$Message) {
        return new C8205Uz(messagingStruct$Message.getNasimEncryptedMessage().getKey().a0(), messagingStruct$Message.getNasimEncryptedMessage().getMessage().a0(), messagingStruct$Message.getNasimEncryptedMessage().getMessageLength(), messagingStruct$Message.getNasimEncryptedMessage().getSignature().a0());
    }

    private final ZC e1(MessagingStruct$TextMessage messagingStruct$TextMessage) {
        return new ZC(messagingStruct$TextMessage.getText(), new ArrayList(), null, a.G0(messagingStruct$TextMessage.getMessageTag()));
    }

    public static final C7714Sx f0(PeersStruct$ExInfo peersStruct$ExInfo) {
        String name;
        if (peersStruct$ExInfo == null) {
            return null;
        }
        try {
            EnumC9196Yx enumC9196YxP = EnumC9196Yx.p(peersStruct$ExInfo.getExPeerTypeValue());
            EnumC23583xA enumC23583xAP = EnumC23583xA.p(peersStruct$ExInfo.getPeerIdentityValue() + 1);
            StringValue peerCategory = peersStruct$ExInfo.getPeerCategory();
            return new C7714Sx(enumC9196YxP, enumC23583xAP, peerCategory != null ? peerCategory.getValue() : null);
        } catch (IOException e) {
            if (a.getClass().isAnonymousClass()) {
                name = C18732p92.class.getName();
                int length = name.length();
                AbstractC13042fc3.f(name);
                if (length > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = C18732p92.class.getSimpleName();
                int length2 = name.length();
                AbstractC13042fc3.f(name);
                if (length2 > 23) {
                    name = name.substring(0, 23);
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            }
            C19406qI3.c(name, "fromExInfo", e);
            return null;
        }
    }

    private final AbstractC19202px f1(MessagingStruct$CustomAction messagingStruct$CustomAction) {
        EnumC4140Dw enumC4140Dw;
        if (messagingStruct$CustomAction.getType().hasOpenDialogAction()) {
            return new C9214Yz(messagingStruct$CustomAction.getType().getOpenDialogAction().getTitle(), messagingStruct$CustomAction.getType().getOpenDialogAction().getDescription(), messagingStruct$CustomAction.getType().getOpenDialogAction().getAgreeButton(), messagingStruct$CustomAction.getType().getOpenDialogAction().getDisagreeButton());
        }
        if (!messagingStruct$CustomAction.getType().hasOpenUrlAction()) {
            return messagingStruct$CustomAction.getType().hasShowSnackBarAction() ? new AC(messagingStruct$CustomAction.getType().getShowSnackBarAction().getText()) : messagingStruct$CustomAction.getType().hasDoNothingAction() ? new C4149Dx() : new C4149Dx();
        }
        String url = messagingStruct$CustomAction.getType().getOpenUrlAction().getUrl();
        EnumC8973Ya4 browserType = messagingStruct$CustomAction.getType().getOpenUrlAction().getBrowserType();
        int i = browserType == null ? -1 : a.r[browserType.ordinal()];
        if (i == -1) {
            enumC4140Dw = EnumC4140Dw.UNSUPPORTED_VALUE;
        } else if (i == 1) {
            enumC4140Dw = EnumC4140Dw.INTERNAL_BROWSER;
        } else if (i != 2) {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            enumC4140Dw = EnumC4140Dw.UNSUPPORTED_VALUE;
        } else {
            enumC4140Dw = EnumC4140Dw.EXTERNAL_BROWSER;
        }
        return new C10152bA(url, enumC4140Dw);
    }

    public static final C17676nN1 g(MessagingStruct$Dialog messagingStruct$Dialog) {
        String name;
        AbstractC13042fc3.i(messagingStruct$Dialog, "dialog");
        List<MessagingStruct$MessageId> unreadMentionsList = messagingStruct$Dialog.getUnreadMentionsList();
        AbstractC13042fc3.h(unreadMentionsList, "getUnreadMentionsList(...)");
        List<MessagingStruct$MessageId> list = unreadMentionsList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (MessagingStruct$MessageId messagingStruct$MessageId : list) {
            arrayList.add(new Q64(messagingStruct$MessageId.getDate(), messagingStruct$MessageId.getRid()));
        }
        List<MessagingStruct$MessageId> unreadReactionsList = messagingStruct$Dialog.getUnreadReactionsList();
        AbstractC13042fc3.h(unreadReactionsList, "getUnreadReactionsList(...)");
        List<MessagingStruct$MessageId> list2 = unreadReactionsList;
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list2, 10));
        for (MessagingStruct$MessageId messagingStruct$MessageId2 : list2) {
            arrayList2.add(new Q64(messagingStruct$MessageId2.getDate(), messagingStruct$MessageId2.getRid()));
        }
        EnumC16311l35 type = messagingStruct$Dialog.getPeer().getType();
        AbstractC13042fc3.h(type, "getType(...)");
        W25 w25R = r(type);
        if (w25R == null) {
            if (a.getClass().isAnonymousClass()) {
                name = C18732p92.class.getName();
                int length = name.length();
                AbstractC13042fc3.f(name);
                if (length > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = C18732p92.class.getSimpleName();
                int length2 = name.length();
                AbstractC13042fc3.f(name);
                if (length2 > 23) {
                    name = name.substring(0, 23);
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            }
            C19406qI3.b(name, "Peer type in dialog to DialogHistory is null, use PeerType.GROUP!");
            w25R = W25.b;
        }
        C11458d25 c11458d25 = new C11458d25(w25R, messagingStruct$Dialog.getPeer().getId());
        int unreadCount = messagingStruct$Dialog.getUnreadCount();
        long sortDate = messagingStruct$Dialog.getSortDate();
        long rid = messagingStruct$Dialog.getRid();
        long date = messagingStruct$Dialog.getDate();
        int senderUid = messagingStruct$Dialog.getSenderUid();
        C18732p92 c18732p92 = a;
        MessagingStruct$Message message = messagingStruct$Dialog.getMessage();
        AbstractC13042fc3.h(message, "getMessage(...)");
        AbstractC17457n0 abstractC17457n0H = AbstractC17457n0.h(c18732p92.A0(message));
        boolean z = messagingStruct$Dialog.getState() == EnumC16043kc4.MessageState_READ;
        CollectionsStruct$Int64Value firstUnreadDate = messagingStruct$Dialog.getFirstUnreadDate();
        long value = firstUnreadDate != null ? firstUnreadDate.getValue() : 0L;
        boolean z2 = messagingStruct$Dialog.getState() == EnumC16043kc4.MessageState_RECEIVED;
        EnumC10088b35 exPeerType = messagingStruct$Dialog.getExInfo().getExPeerType();
        AbstractC13042fc3.h(exPeerType, "getExPeerType(...)");
        return new C17676nN1(c11458d25, unreadCount, sortDate, rid, date, senderUid, abstractC17457n0H, z, value, z2, c18732p92.w(exPeerType), E25.j(messagingStruct$Dialog.getExInfo().getPeerIdentityValue() + 1), arrayList, arrayList2);
    }

    public static final C19811qz g0(Map map) {
        if (map == null) {
            return null;
        }
        return new C19811qz(new b(map));
    }

    private final EnumC19802qy g1(EnumC4424Fb4 enumC4424Fb4) {
        return enumC4424Fb4.ordinal() == 0 ? EnumC19802qy.SAME : EnumC19802qy.RANDOM;
    }

    public static final C14697iL2 h(C23464wy c23464wy) {
        AbstractC13042fc3.i(c23464wy, "group");
        return new C14697iL2(c23464wy, null);
    }

    private final C11413cy h0(FilesStruct$FastThumb filesStruct$FastThumb) {
        if (filesStruct$FastThumb != null) {
            return new C11413cy(filesStruct$FastThumb.getW(), filesStruct$FastThumb.getH(), filesStruct$FastThumb.getThumb().a0(), i0(filesStruct$FastThumb.getOptFileLocation()));
        }
        return null;
    }

    private final EnumC7264Qz h1(EnumC18998pc4 enumC18998pc4) {
        int iOrdinal = enumC18998pc4.ordinal();
        return iOrdinal != 0 ? iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? iOrdinal != 4 ? EnumC7264Qz.UNSUPPORTED_VALUE : EnumC7264Qz.WALLET : EnumC7264Qz.MELLI_LOAN : EnumC7264Qz.PAYMENT : EnumC7264Qz.BILL : EnumC7264Qz.NORMAL;
    }

    public static final ZN2 i(EnumC3690By enumC3690By) {
        return (enumC3690By == null || enumC3690By != EnumC3690By.CHANNEL) ? ZN2.GROUP : ZN2.CHANNEL;
    }

    public static final C12056dy i0(FilesStruct$FileLocation filesStruct$FileLocation) {
        if (filesStruct$FileLocation == null) {
            return null;
        }
        long fileId = filesStruct$FileLocation.getFileId();
        long accessHash = filesStruct$FileLocation.getAccessHash();
        Int32Value fileStorageVersion = filesStruct$FileLocation.getFileStorageVersion();
        return new C12056dy(fileId, accessHash, fileStorageVersion != null ? Integer.valueOf(fileStorageVersion.getValue()) : null);
    }

    private final EnumC7971Tz i1(EnumC21409tc4 enumC21409tc4) {
        return enumC21409tc4.ordinal() == 0 ? EnumC7971Tz.AMOUNT : enumC21409tc4.ordinal() == 1 ? EnumC7971Tz.PERCENTAGE : EnumC7971Tz.UNSUPPORTED_VALUE;
    }

    public static final EnumC24932zS2 j(ZN2 zn2) {
        AbstractC13042fc3.i(zn2, "groupType");
        int i = a.b[zn2.ordinal()];
        if (i == 1) {
            return EnumC24932zS2.GroupType_CHANNEL;
        }
        if (i == 2) {
            return EnumC24932zS2.GroupType_GROUP;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final C14697iL2 j0(GroupsStruct$FullGroup groupsStruct$FullGroup) {
        AbstractC13042fc3.i(groupsStruct$FullGroup, "f");
        int id = groupsStruct$FullGroup.getId();
        long accessHash = groupsStruct$FullGroup.getAccessHash();
        String title = groupsStruct$FullGroup.getTitle();
        C6984Pv c6984PvR = R(groupsStruct$FullGroup.hasAvatar() ? groupsStruct$FullGroup.getAvatar() : null);
        Int32Value membersCount10 = groupsStruct$FullGroup.getMembersCount10();
        Integer numValueOf = membersCount10 != null ? Integer.valueOf(membersCount10.getValue()) : null;
        BoolValue isMember = groupsStruct$FullGroup.getIsMember();
        Boolean boolValueOf = isMember != null ? Boolean.valueOf(isMember.getValue()) : null;
        EnumC3690By enumC3690ByP = EnumC3690By.p(groupsStruct$FullGroup.getGroupTypeValue() + 1);
        GroupsStruct$Permissions permissions = groupsStruct$FullGroup.getPermissions();
        Boolean boolValueOf2 = permissions != null ? Boolean.valueOf(permissions.getSendMessage()) : null;
        CollectionsStruct$MapValue ext = groupsStruct$FullGroup.getExt();
        List<CollectionsStruct$MapValueItem> itemsList = ext != null ? ext.getItemsList() : null;
        AbstractC13042fc3.f(itemsList);
        C19811qz c19811qz = new C19811qz(y0(itemsList));
        StringValue nick = groupsStruct$FullGroup.getNick();
        String value = nick != null ? nick.getValue() : null;
        BoolValue becameOrphaned = groupsStruct$FullGroup.getBecameOrphaned();
        Boolean boolValueOf3 = becameOrphaned != null ? Boolean.valueOf(becameOrphaned.getValue()) : null;
        DA daK0 = K0(groupsStruct$FullGroup.getPermissions());
        DA daK02 = K0(groupsStruct$FullGroup.getDefaultPermissions());
        Integer numValueOf2 = Integer.valueOf(groupsStruct$FullGroup.getOwnerUid());
        List<String> availableReactionsList = groupsStruct$FullGroup.getAvailableReactionsList();
        BoolValue isSuspend = groupsStruct$FullGroup.getIsSuspend();
        Boolean boolValueOf4 = isSuspend != null ? Boolean.valueOf(isSuspend.getValue()) : null;
        Int32Value linkedGroupPeerId = groupsStruct$FullGroup.getLinkedGroupPeerId();
        Integer numValueOf3 = linkedGroupPeerId != null ? Integer.valueOf(linkedGroupPeerId.getValue()) : null;
        BoolValue discussionGroupEnabled = groupsStruct$FullGroup.getDiscussionGroupEnabled();
        C23464wy c23464wy = new C23464wy(id, accessHash, title, c6984PvR, numValueOf, boolValueOf, null, enumC3690ByP, boolValueOf2, c19811qz, value, boolValueOf3, null, daK0, daK02, numValueOf2, availableReactionsList, boolValueOf4, numValueOf3, discussionGroupEnabled != null ? Boolean.valueOf(discussionGroupEnabled.getValue()) : null);
        int id2 = groupsStruct$FullGroup.getId();
        long createDate = groupsStruct$FullGroup.getCreateDate();
        int ownerUid = groupsStruct$FullGroup.getOwnerUid();
        C18732p92 c18732p92 = a;
        List<GroupsStruct$Member> members17List = groupsStruct$FullGroup.getMembers17List();
        AbstractC13042fc3.h(members17List, "getMembers17List(...)");
        List listN0 = c18732p92.n0(members17List);
        StringValue theme = groupsStruct$FullGroup.getTheme();
        String value2 = theme != null ? theme.getValue() : null;
        StringValue about = groupsStruct$FullGroup.getAbout();
        String value3 = about != null ? about.getValue() : null;
        CollectionsStruct$MapValue ext2 = groupsStruct$FullGroup.getExt();
        List<CollectionsStruct$MapValueItem> itemsList2 = ext2 != null ? ext2.getItemsList() : null;
        AbstractC13042fc3.f(itemsList2);
        C19811qz c19811qz2 = new C19811qz(y0(itemsList2));
        GroupsStruct$Permissions permissions2 = groupsStruct$FullGroup.getPermissions();
        Boolean boolValueOf5 = permissions2 != null ? Boolean.valueOf(permissions2.getSeeMembers()) : null;
        GroupsStruct$Permissions permissions3 = groupsStruct$FullGroup.getPermissions();
        Boolean boolValueOf6 = permissions3 != null ? Boolean.valueOf(permissions3.getInviteUser()) : null;
        C7714Sx c7714SxF0 = f0(groupsStruct$FullGroup.getExInfo());
        C25247zz c25247zzE = c18732p92.E(groupsStruct$FullGroup.getPin());
        BB bbP = BB.p(groupsStruct$FullGroup.getRestrictionValue() + 1);
        EnumC4599Fv enumC4599FvP = EnumC4599Fv.p(groupsStruct$FullGroup.getAdvertisementTypeValue() + 1);
        StringValue channelNativeAdTagId = groupsStruct$FullGroup.getChannelNativeAdTagId();
        String value4 = channelNativeAdTagId != null ? channelNativeAdTagId.getValue() : null;
        StringValue channelBannerAdTagId = groupsStruct$FullGroup.getChannelBannerAdTagId();
        String value5 = channelBannerAdTagId != null ? channelBannerAdTagId.getValue() : null;
        List<String> availableReactionsList2 = groupsStruct$FullGroup.getAvailableReactionsList();
        BoolValue isSuspend2 = groupsStruct$FullGroup.getIsSuspend();
        return new C14697iL2(c23464wy, new C24644yy(id2, createDate, ownerUid, listN0, value2, value3, c19811qz2, null, boolValueOf5, boolValueOf6, null, c7714SxF0, c25247zzE, bbP, enumC4599FvP, value4, value5, availableReactionsList2, isSuspend2 != null ? Boolean.valueOf(isSuspend2.getValue()) : null, EnumC12184eB.p(groupsStruct$FullGroup.getPrivacyBarModeValue())));
    }

    public static final EnumC23558x74 k(EnumC4884Gz enumC4884Gz) {
        if (enumC4884Gz == null) {
            return EnumC23558x74.UNKNOWN;
        }
        int i = a.a[enumC4884Gz.ordinal()];
        return (i == 1 || i == 2 || i == 3) ? EnumC23558x74.SENT : EnumC23558x74.UNKNOWN;
    }

    public static final C17637nI7 k0(UsersStruct$FullUser usersStruct$FullUser) {
        String name;
        Object objB;
        BoolValue hasTimcheProfile;
        BoolValue hasMainMiniApp;
        StringValue botActiveUsers;
        AbstractC13042fc3.i(usersStruct$FullUser, "fullUser");
        try {
            int id = usersStruct$FullUser.getId();
            long accessHash = usersStruct$FullUser.getAccessHash();
            String name2 = usersStruct$FullUser.getName();
            StringValue localName = usersStruct$FullUser.getLocalName();
            String value = localName != null ? localName.getValue() : null;
            StringValue nick = usersStruct$FullUser.getNick();
            String value2 = nick != null ? nick.getValue() : null;
            EnumC24781zC enumC24781zCP = EnumC24781zC.p(usersStruct$FullUser.getSexValue());
            C6984Pv c6984PvR = R(usersStruct$FullUser.hasAvatar() ? usersStruct$FullUser.getAvatar() : null);
            BoolValue isBot = usersStruct$FullUser.getIsBot();
            Boolean boolValueOf = isBot != null ? Boolean.valueOf(isBot.getValue()) : null;
            C19811qz c19811qzG0 = g0(usersStruct$FullUser.getExt());
            BoolValue isDeleted = usersStruct$FullUser.getIsDeleted();
            Boolean boolValueOf2 = isDeleted != null ? Boolean.valueOf(isDeleted.getValue()) : null;
            EnumC14002hB enumC14002hBP = EnumC14002hB.p(usersStruct$FullUser.getPuppeteerValue());
            Long lValueOf = Long.valueOf(usersStruct$FullUser.getCreatedAt().getValue());
            UsersStruct$BotExInfo botExInfo = usersStruct$FullUser.getBotExInfo();
            String value3 = (botExInfo == null || (botActiveUsers = botExInfo.getBotActiveUsers()) == null) ? null : botActiveUsers.getValue();
            UsersStruct$BotExInfo botExInfo2 = usersStruct$FullUser.getBotExInfo();
            Boolean boolValueOf3 = (botExInfo2 == null || (hasMainMiniApp = botExInfo2.getHasMainMiniApp()) == null) ? null : Boolean.valueOf(hasMainMiniApp.getValue());
            C18732p92 c18732p92 = a;
            C7021Py c7021PyP0 = c18732p92.p0(usersStruct$FullUser.getBotExInfo().getIntro());
            UsersStruct$BotExInfo botExInfo3 = usersStruct$FullUser.getBotExInfo();
            C7723Sy c7723SyR0 = c18732p92.r0(botExInfo3 != null ? botExInfo3.getIntroMessage() : null);
            UsersStruct$BotExInfo botExInfo4 = usersStruct$FullUser.getBotExInfo();
            C15811kD c15811kD = new C15811kD(id, accessHash, name2, value, value2, enumC24781zCP, c6984PvR, boolValueOf, c19811qzG0, null, boolValueOf2, enumC14002hBP, lValueOf, new C20983sw(value3, boolValueOf3, c7021PyP0, c7723SyR0, (botExInfo4 == null || (hasTimcheProfile = botExInfo4.getHasTimcheProfile()) == null) ? null : Boolean.valueOf(hasTimcheProfile.getValue())));
            int id2 = usersStruct$FullUser.getId();
            c cVar = new c(usersStruct$FullUser);
            StringValue about = usersStruct$FullUser.getAbout();
            String value4 = about != null ? about.getValue() : null;
            List<String> preferredLanguagesList = usersStruct$FullUser.getPreferredLanguagesList();
            StringValue timeZone = usersStruct$FullUser.getTimeZone();
            String value5 = timeZone != null ? timeZone.getValue() : null;
            d dVar = new d(usersStruct$FullUser);
            BoolValue isBlocked = usersStruct$FullUser.getIsBlocked();
            Boolean boolValueOf4 = isBlocked != null ? Boolean.valueOf(isBlocked.getValue()) : null;
            C7714Sx c7714SxF0 = f0(usersStruct$FullUser.getExInfo());
            StringValue defaultBankAccount = usersStruct$FullUser.getDefaultBankAccount();
            String value6 = defaultBankAccount != null ? defaultBankAccount.getValue() : null;
            StringValue defaultCardNumber = usersStruct$FullUser.getDefaultCardNumber();
            String value7 = defaultCardNumber != null ? defaultCardNumber.getValue() : null;
            BoolValue isDeleted2 = usersStruct$FullUser.getIsDeleted();
            Boolean boolValueOf5 = isDeleted2 != null ? Boolean.valueOf(isDeleted2.getValue()) : null;
            BoolValue isContact = usersStruct$FullUser.getIsContact();
            Boolean boolValueOf6 = isContact != null ? Boolean.valueOf(isContact.getValue()) : null;
            EnumC14002hB enumC14002hBP2 = EnumC14002hB.p(usersStruct$FullUser.getPuppeteerValue());
            Long lValueOf2 = Long.valueOf(usersStruct$FullUser.getCreatedAt().getValue());
            int privacyBarModeValue = usersStruct$FullUser.getPrivacyBarModeValue();
            try {
                C9475a16.a aVar = C9475a16.b;
                objB = C9475a16.b(EnumC12184eB.p(privacyBarModeValue));
            } catch (Throwable th) {
                C9475a16.a aVar2 = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(th));
            }
            EnumC12184eB enumC12184eB = EnumC12184eB.UNSUPPORTED_VALUE;
            if (C9475a16.g(objB)) {
                objB = enumC12184eB;
            }
            EnumC12184eB enumC12184eB2 = (EnumC12184eB) objB;
            BoolValue privacyAllowedToInvite = usersStruct$FullUser.getPrivacyAllowedToInvite();
            return new C17637nI7(c15811kD, new C16256ky(id2, cVar, value4, preferredLanguagesList, value5, dVar, null, boolValueOf4, c7714SxF0, value6, value7, boolValueOf5, boolValueOf6, enumC14002hBP2, lValueOf2, enumC12184eB2, privacyAllowedToInvite != null ? Boolean.valueOf(privacyAllowedToInvite.getValue()) : null));
        } catch (IOException e) {
            if (a.getClass().isAnonymousClass()) {
                name = C18732p92.class.getName();
                int length = name.length();
                AbstractC13042fc3.f(name);
                if (length > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = C18732p92.class.getSimpleName();
                int length2 = name.length();
                AbstractC13042fc3.f(name);
                if (length2 > 23) {
                    name = name.substring(0, 23);
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            }
            C19406qI3.c(name, "fromFullUser", e);
            return null;
        }
    }

    private final C4875Gy k1(MessagingStruct$InlineKeyboardButton messagingStruct$InlineKeyboardButton) {
        C18611ox c18611ox;
        C23610xD c23610xD = new C23610xD(messagingStruct$InlineKeyboardButton.getWebApp().getUrl());
        MessagingStruct$LoginUrl loginUrl = messagingStruct$InlineKeyboardButton.getLoginUrl();
        C19220pz c19220pz = new C19220pz(loginUrl.getUrl(), loginUrl.getForwardText(), loginUrl.getBotUsername(), loginUrl.getRequestWriteAccess());
        MessagingStruct$SwitchInlineQueryChosenChat switchInlineQueryChosenChat = messagingStruct$InlineKeyboardButton.getSwitchInlineQueryChosenChat();
        QC qc = new QC(switchInlineQueryChosenChat.getQuery(), switchInlineQueryChosenChat.getAllowUserChats(), switchInlineQueryChosenChat.getAllowBotChats(), switchInlineQueryChosenChat.getAllowGroupChats(), switchInlineQueryChosenChat.getAllowChannelChats());
        C15656jx c15656jx = new C15656jx(messagingStruct$InlineKeyboardButton.getCopyText().getText());
        C6750Ov c6750Ov = new C6750Ov();
        String text = messagingStruct$InlineKeyboardButton.getText();
        String value = messagingStruct$InlineKeyboardButton.hasUrl() ? messagingStruct$InlineKeyboardButton.getUrl().getValue() : null;
        String value2 = messagingStruct$InlineKeyboardButton.hasCallbackData() ? messagingStruct$InlineKeyboardButton.getCallbackData().getValue() : null;
        C23610xD c23610xD2 = messagingStruct$InlineKeyboardButton.hasWebApp() ? c23610xD : null;
        C19220pz c19220pz2 = messagingStruct$InlineKeyboardButton.hasLoginUrl() ? c19220pz : null;
        String value3 = messagingStruct$InlineKeyboardButton.hasSwitchInlineQuery() ? messagingStruct$InlineKeyboardButton.getSwitchInlineQuery().getValue() : null;
        String value4 = messagingStruct$InlineKeyboardButton.hasSwitchInlineQueryCurrentChat() ? messagingStruct$InlineKeyboardButton.getSwitchInlineQueryCurrentChat().getValue() : null;
        QC qc2 = messagingStruct$InlineKeyboardButton.hasSwitchInlineQueryChosenChat() ? qc : null;
        C15656jx c15656jx2 = messagingStruct$InlineKeyboardButton.hasCopyText() ? c15656jx : null;
        C6750Ov c6750Ov2 = messagingStruct$InlineKeyboardButton.hasAuthentication() ? c6750Ov : null;
        if (messagingStruct$InlineKeyboardButton.hasCustomAction()) {
            String id = messagingStruct$InlineKeyboardButton.getCustomAction().getId();
            MessagingStruct$CustomAction customAction = messagingStruct$InlineKeyboardButton.getCustomAction();
            AbstractC13042fc3.h(customAction, "getCustomAction(...)");
            c18611ox = new C18611ox(id, f1(customAction));
        } else {
            c18611ox = null;
        }
        return new C4875Gy(text, value, value2, c23610xD2, c19220pz2, value3, value4, qc2, c15656jx2, c6750Ov2, c18611ox, Boolean.valueOf(messagingStruct$InlineKeyboardButton.getSendData().getValue()));
    }

    public static final C11458d25 l(PeersStruct$ExPeer peersStruct$ExPeer) {
        W25 w25;
        AbstractC13042fc3.i(peersStruct$ExPeer, "peer");
        EnumC10088b35 type = peersStruct$ExPeer.getType();
        switch (type == null ? -1 : a.j[type.ordinal()]) {
            case 1:
            case 2:
                w25 = W25.a;
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                w25 = W25.b;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return new C11458d25(w25, peersStruct$ExPeer.getId());
    }

    private final AbstractC24063xz l0(MessagingStruct$GiftPacketMessage messagingStruct$GiftPacketMessage) {
        int giftCount = messagingStruct$GiftPacketMessage.getGiftCount();
        long totalAmount = messagingStruct$GiftPacketMessage.getTotalAmount();
        EnumC4424Fb4 givingType = messagingStruct$GiftPacketMessage.getGivingType();
        AbstractC13042fc3.h(givingType, "getGivingType(...)");
        return new C21001sy(giftCount, totalAmount, g1(givingType), messagingStruct$GiftPacketMessage.getWalletId().getValue(), messagingStruct$GiftPacketMessage.getRegarding().getValue(), messagingStruct$GiftPacketMessage.getOwnerUserId(), Integer.valueOf(messagingStruct$GiftPacketMessage.getCoverId().getValue()), Boolean.valueOf(messagingStruct$GiftPacketMessage.getShowTotalAmount().getValue()));
    }

    private final C5343Iy l1(MessagingStruct$InlineKeyboardButtonMarkup messagingStruct$InlineKeyboardButtonMarkup) {
        List<MessagingStruct$InlineKeyboardButtonList> listOfInlineListList = messagingStruct$InlineKeyboardButtonMarkup.getListOfInlineListList();
        AbstractC13042fc3.h(listOfInlineListList, "getListOfInlineListList(...)");
        List<MessagingStruct$InlineKeyboardButtonList> list = listOfInlineListList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            List<MessagingStruct$InlineKeyboardButton> inlineListList = ((MessagingStruct$InlineKeyboardButtonList) it.next()).getInlineListList();
            AbstractC13042fc3.h(inlineListList, "getInlineListList(...)");
            List<MessagingStruct$InlineKeyboardButton> list2 = inlineListList;
            ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list2, 10));
            for (MessagingStruct$InlineKeyboardButton messagingStruct$InlineKeyboardButton : list2) {
                C18732p92 c18732p92 = a;
                AbstractC13042fc3.f(messagingStruct$InlineKeyboardButton);
                arrayList2.add(c18732p92.k1(messagingStruct$InlineKeyboardButton));
            }
            arrayList.add(new C5109Hy(arrayList2));
        }
        return new C5343Iy(arrayList);
    }

    public static final C11458d25 m(C8421Vx c8421Vx) {
        AbstractC13042fc3.i(c8421Vx, "peer");
        EnumC9196Yx enumC9196YxR = c8421Vx.r();
        int i = enumC9196YxR == null ? -1 : a.h[enumC9196YxR.ordinal()];
        W25 w25 = i != 1 ? (i == 2 || i == 3 || i != 4) ? W25.b : W25.a : W25.a;
        return new C11458d25(w25, c8421Vx.q());
    }

    private final AbstractC24063xz m0(MessagingStruct$GoldGiftPacketMessage messagingStruct$GoldGiftPacketMessage) {
        long id = messagingStruct$GoldGiftPacketMessage.getId();
        long amount = messagingStruct$GoldGiftPacketMessage.getAmount();
        long count = messagingStruct$GoldGiftPacketMessage.getCount();
        String description = messagingStruct$GoldGiftPacketMessage.getDescription();
        EnumC4424Fb4 givingType = messagingStruct$GoldGiftPacketMessage.getGivingType();
        AbstractC13042fc3.h(givingType, "getGivingType(...)");
        return new C22874vy(id, amount, count, description, g1(givingType));
    }

    private final C9439Zy m1(MessagingStruct$KeyboardButton messagingStruct$KeyboardButton) {
        C18611ox c18611ox;
        MessagingStruct$KeyboardButtonRequestUser requestUser = messagingStruct$KeyboardButton.getRequestUser();
        C11422cz c11422cz = new C11422cz(requestUser.getRequestId(), requestUser.getUserIsBot(), requestUser.getUserIsPremium());
        MessagingStruct$ChatAdministratorRights userAdministratorRights = messagingStruct$KeyboardButton.getRequestChat().getUserAdministratorRights();
        AbstractC13042fc3.h(userAdministratorRights, "getUserAdministratorRights(...)");
        C7237Qw c7237QwP1 = p1(userAdministratorRights);
        MessagingStruct$ChatAdministratorRights botAdministratorRights = messagingStruct$KeyboardButton.getRequestChat().getBotAdministratorRights();
        AbstractC13042fc3.h(botAdministratorRights, "getBotAdministratorRights(...)");
        C7237Qw c7237QwP12 = p1(botAdministratorRights);
        MessagingStruct$KeyboardButtonRequestChat requestChat = messagingStruct$KeyboardButton.getRequestChat();
        C10658bz c10658bz = new C10658bz(requestChat.getRequestId(), requestChat.getChatIsChannel(), requestChat.getChatIsForum(), requestChat.getChatHasUsername(), requestChat.getChatIsCreated(), c7237QwP1, c7237QwP12, requestChat.getBotIsMember());
        C10042az c10042az = new C10042az(messagingStruct$KeyboardButton.getRequestPoll().getType());
        C23610xD c23610xD = new C23610xD(messagingStruct$KeyboardButton.getWebApp().getUrl());
        String text = messagingStruct$KeyboardButton.getText();
        Boolean boolValueOf = Boolean.valueOf(messagingStruct$KeyboardButton.getRequestContact().getValue());
        if (!messagingStruct$KeyboardButton.hasRequestContact()) {
            boolValueOf = null;
        }
        Boolean boolValueOf2 = messagingStruct$KeyboardButton.hasRequestLocation() ? Boolean.valueOf(messagingStruct$KeyboardButton.getRequestLocation().getValue()) : null;
        Boolean boolValueOf3 = messagingStruct$KeyboardButton.hasSendMessage() ? Boolean.valueOf(messagingStruct$KeyboardButton.getSendMessage().getValue()) : null;
        C11422cz c11422cz2 = messagingStruct$KeyboardButton.hasRequestUser() ? c11422cz : null;
        C10658bz c10658bz2 = messagingStruct$KeyboardButton.hasRequestChat() ? c10658bz : null;
        C10042az c10042az2 = messagingStruct$KeyboardButton.hasRequestPoll() ? c10042az : null;
        C23610xD c23610xD2 = messagingStruct$KeyboardButton.hasWebApp() ? c23610xD : null;
        if (messagingStruct$KeyboardButton.hasCustomAction()) {
            String id = messagingStruct$KeyboardButton.getCustomAction().getId();
            MessagingStruct$CustomAction customAction = messagingStruct$KeyboardButton.getCustomAction();
            AbstractC13042fc3.h(customAction, "getCustomAction(...)");
            c18611ox = new C18611ox(id, f1(customAction));
        } else {
            c18611ox = null;
        }
        return new C9439Zy(text, boolValueOf, boolValueOf2, boolValueOf3, c11422cz2, c10658bz2, c10042az2, c23610xD2, c18611ox);
    }

    public static final C11458d25 n(C17557nA c17557nA) {
        if (c17557nA == null) {
            return null;
        }
        return new C11458d25(q(c17557nA.r()), c17557nA.q());
    }

    private final List n0(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            GroupsStruct$Member groupsStruct$Member = (GroupsStruct$Member) it.next();
            int uid = groupsStruct$Member.getUid();
            int inviterUid = groupsStruct$Member.getInviterUid();
            long date = groupsStruct$Member.getDate();
            BoolValue isAdmin = groupsStruct$Member.getIsAdmin();
            Boolean boolValueOf = isAdmin != null ? Boolean.valueOf(isAdmin.getValue()) : null;
            Int32Value promoterUserId = groupsStruct$Member.getPromoterUserId();
            Integer numValueOf = promoterUserId != null ? Integer.valueOf(promoterUserId.getValue()) : null;
            CollectionsStruct$Int64Value promotedAt = groupsStruct$Member.getPromotedAt();
            Long lValueOf = promotedAt != null ? Long.valueOf(promotedAt.getValue()) : null;
            DA daK0 = K0(groupsStruct$Member.getPermissions());
            StringValue title = groupsStruct$Member.getTitle();
            arrayList.add(new C22883vz(uid, inviterUid, date, boolValueOf, numValueOf, lValueOf, daK0, title != null ? title.getValue() : null));
        }
        return arrayList;
    }

    private final C24772zB n1(MessagingStruct$ReplyKeyboardMarkup messagingStruct$ReplyKeyboardMarkup) {
        List<MessagingStruct$ListOfKeyboardButton> listOfKeyboardListList = messagingStruct$ReplyKeyboardMarkup.getListOfKeyboardListList();
        AbstractC13042fc3.h(listOfKeyboardListList, "getListOfKeyboardListList(...)");
        List<MessagingStruct$ListOfKeyboardButton> list = listOfKeyboardListList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            List<MessagingStruct$KeyboardButton> keyboardListList = ((MessagingStruct$ListOfKeyboardButton) it.next()).getKeyboardListList();
            AbstractC13042fc3.h(keyboardListList, "getKeyboardListList(...)");
            List<MessagingStruct$KeyboardButton> list2 = keyboardListList;
            ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list2, 10));
            for (MessagingStruct$KeyboardButton messagingStruct$KeyboardButton : list2) {
                C18732p92 c18732p92 = a;
                AbstractC13042fc3.f(messagingStruct$KeyboardButton);
                arrayList2.add(c18732p92.m1(messagingStruct$KeyboardButton));
            }
            arrayList.add(new C15674jz(arrayList2));
        }
        return new C24772zB(arrayList);
    }

    public static final C11458d25 o(C22993wA c22993wA) {
        AbstractC13042fc3.i(c22993wA, "peer");
        return new C11458d25(q(c22993wA.r()), c22993wA.q());
    }

    public static final C4626Fy o0(FilesStruct$ImageLocation filesStruct$ImageLocation) {
        if (filesStruct$ImageLocation == null) {
            return null;
        }
        return new C4626Fy(i0(filesStruct$ImageLocation.getFileLocation()), filesStruct$ImageLocation.getWidth(), filesStruct$ImageLocation.getHeight(), filesStruct$ImageLocation.getFileSize());
    }

    private final AB o1(MessagingStruct$ReplyKeyboardRemove messagingStruct$ReplyKeyboardRemove) {
        return new AB(messagingStruct$ReplyKeyboardRemove.getRemoveKeyboard(), Boolean.valueOf(messagingStruct$ReplyKeyboardRemove.getSelective().getValue()));
    }

    public static final E25 p(EnumC23583xA enumC23583xA) {
        int i = enumC23583xA == null ? -1 : a.i[enumC23583xA.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? E25.INFORMAL : E25.INFORMAL : E25.LEGAL : E25.VERIFIED;
    }

    private final C7021Py p0(UsersStruct$Intro usersStruct$Intro) {
        if (usersStruct$Intro != null) {
            return new C7021Py(usersStruct$Intro.getText().getValue(), i0(usersStruct$Intro.getFileLocation()), usersStruct$Intro.getWidth(), usersStruct$Intro.getHeight(), usersStruct$Intro.getFileSize(), usersStruct$Intro.getMimeType(), usersStruct$Intro.getFileName(), a.h0(usersStruct$Intro.getThumb()));
        }
        return null;
    }

    private static final C7237Qw p1(MessagingStruct$ChatAdministratorRights messagingStruct$ChatAdministratorRights) {
        return new C7237Qw(messagingStruct$ChatAdministratorRights.getIsAnonymous(), messagingStruct$ChatAdministratorRights.getCanManageChat(), messagingStruct$ChatAdministratorRights.getCanDeleteMessages(), messagingStruct$ChatAdministratorRights.getCanManageVideoChats(), messagingStruct$ChatAdministratorRights.getCanRestrictMembers(), messagingStruct$ChatAdministratorRights.getCanPromoteMembers(), messagingStruct$ChatAdministratorRights.getCanChangeInfo(), messagingStruct$ChatAdministratorRights.getCanInviteUsers(), messagingStruct$ChatAdministratorRights.getCanPostMessages(), messagingStruct$ChatAdministratorRights.getCanEditMessages(), messagingStruct$ChatAdministratorRights.getCanPinMessages(), messagingStruct$ChatAdministratorRights.getCanManageTopics());
    }

    public static final W25 q(CA ca) {
        int i = ca == null ? -1 : a.f[ca.ordinal()];
        return i != 1 ? i != 2 ? W25.a : W25.a : W25.b;
    }

    public static final C7489Ry q0(UsersStruct$IntroMedia usersStruct$IntroMedia) {
        if (usersStruct$IntroMedia == null) {
            return null;
        }
        C12056dy c12056dyI0 = i0(usersStruct$IntroMedia.getFileLocation());
        int fileSize = usersStruct$IntroMedia.getFileSize();
        String mimeType = usersStruct$IntroMedia.getMimeType();
        String fileName = usersStruct$IntroMedia.getFileName();
        UsersStruct$MediaExt mediaExtra = usersStruct$IntroMedia.getMediaExtra();
        AbstractC13042fc3.h(mediaExtra, "getMediaExtra(...)");
        return new C7489Ry(c12056dyI0, fileSize, mimeType, fileName, z0(mediaExtra));
    }

    public static final W25 r(EnumC16311l35 enumC16311l35) {
        AbstractC13042fc3.i(enumC16311l35, "peerType");
        int i = a.o[enumC16311l35.ordinal()];
        if (i == 1) {
            return W25.b;
        }
        if (i == 2) {
            return W25.a;
        }
        if (i != 3) {
            return null;
        }
        return W25.c;
    }

    private final C7723Sy r0(UsersStruct$IntroMessage usersStruct$IntroMessage) {
        if (usersStruct$IntroMessage != null) {
            return new C7723Sy(usersStruct$IntroMessage.getText().getValue(), q0(usersStruct$IntroMessage.getMedia()));
        }
        return null;
    }

    private final C16265kz r1(MessagingStruct$LiveMessage messagingStruct$LiveMessage) {
        return new C16265kz(messagingStruct$LiveMessage.getLink(), messagingStruct$LiveMessage.getUserCount(), messagingStruct$LiveMessage.getIsLive(), d0(messagingStruct$LiveMessage.getMedia()), messagingStruct$LiveMessage.getKey());
    }

    public static final EnumC16311l35 s(W25 w25) {
        int i = w25 == null ? -1 : a.g[w25.ordinal()];
        return i != 1 ? i != 2 ? EnumC16311l35.PeerType_UNKNOWN : EnumC16311l35.PeerType_PRIVATE : EnumC16311l35.PeerType_GROUP;
    }

    private final C8430Vy s0(MeetStruct$JoinRequest meetStruct$JoinRequest) {
        return new C8430Vy(meetStruct$JoinRequest.getRequesterIdentifier(), meetStruct$JoinRequest.getName());
    }

    private final C12793fB s1(MessagingStruct$ProtectedMessage messagingStruct$ProtectedMessage) {
        MessagingStruct$Message message = messagingStruct$ProtectedMessage.getMessage();
        AbstractC13042fc3.h(message, "getMessage(...)");
        return new C12793fB(A0(message));
    }

    public static final C24119y45 t(DA da) {
        AbstractC13042fc3.i(da, "apiPermissions");
        Boolean boolN = da.N();
        boolean zBooleanValue = boolN != null ? boolN.booleanValue() : true;
        Boolean boolK = da.K();
        boolean zBooleanValue2 = boolK != null ? boolK.booleanValue() : true;
        Boolean boolF = da.F();
        boolean zBooleanValue3 = boolF != null ? boolF.booleanValue() : true;
        Boolean boolR = da.r();
        boolean zBooleanValue4 = boolR != null ? boolR.booleanValue() : true;
        Boolean boolP = da.P();
        boolean zBooleanValue5 = boolP != null ? boolP.booleanValue() : true;
        Boolean boolD = da.D();
        return new C24119y45(da.H(), da.u(), da.C(), da.E(), da.z(), da.q(), da.s(), da.O(), da.G(), da.w(), zBooleanValue, zBooleanValue2, zBooleanValue3, zBooleanValue4, zBooleanValue5, boolD != null ? boolD.booleanValue() : false);
    }

    private final C8664Wy t0(MessagingStruct$JsonMessage messagingStruct$JsonMessage) {
        return new C8664Wy(messagingStruct$JsonMessage.getRawJson());
    }

    private final TC t1(MessagingStruct$TemplateMessage messagingStruct$TemplateMessage) {
        MessagingStruct$Message generalMessage = messagingStruct$TemplateMessage.getGeneralMessage();
        AbstractC13042fc3.h(generalMessage, "getGeneralMessage(...)");
        AbstractC24063xz abstractC24063xzA0 = A0(generalMessage);
        long templateMessageId = messagingStruct$TemplateMessage.getTemplateMessageId();
        List listM = AbstractC10360bX0.m();
        String value = messagingStruct$TemplateMessage.getResponseType().getValue();
        MessagingStruct$InlineKeyboardButtonMarkup inlineKeyboardMarkup = messagingStruct$TemplateMessage.getInlineKeyboardMarkup();
        AbstractC13042fc3.h(inlineKeyboardMarkup, "getInlineKeyboardMarkup(...)");
        C5343Iy c5343IyL1 = l1(inlineKeyboardMarkup);
        MessagingStruct$ReplyKeyboardMarkup replyKeyboardMarkup = messagingStruct$TemplateMessage.getReplyKeyboardMarkup();
        AbstractC13042fc3.h(replyKeyboardMarkup, "getReplyKeyboardMarkup(...)");
        C24772zB c24772zBN1 = n1(replyKeyboardMarkup);
        MessagingStruct$ReplyKeyboardRemove replyKeyboardRemove = messagingStruct$TemplateMessage.getReplyKeyboardRemove();
        AbstractC13042fc3.h(replyKeyboardRemove, "getReplyKeyboardRemove(...)");
        return new TC(abstractC24063xzA0, templateMessageId, listM, value, c5343IyL1, c24772zBN1, o1(replyKeyboardRemove));
    }

    public static final W06 u(BB bb) {
        return (bb == null || bb != BB.PRIVATE) ? W06.PUBLIC : W06.PRIVATE;
    }

    public static final CollectionsStruct$MapValue u0(C19811qz c19811qz) {
        if (c19811qz == null) {
            return null;
        }
        CollectionsStruct$MapValue.a aVarNewBuilder = CollectionsStruct$MapValue.newBuilder();
        List listU = c19811qz.u();
        AbstractC13042fc3.h(listU, "getItems(...)");
        List list = listU;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(v0((C20420rz) it.next()));
        }
        return (CollectionsStruct$MapValue) aVarNewBuilder.A(arrayList).a();
    }

    private final VC u1(MessagingStruct$TemplateMessageResponse messagingStruct$TemplateMessageResponse) {
        String tmrMessage = messagingStruct$TemplateMessageResponse.getTmrMessage();
        long templateMessageResponseId = messagingStruct$TemplateMessageResponse.getTemplateMessageResponseId();
        MessagingStruct$Message message = messagingStruct$TemplateMessageResponse.getMessage();
        AbstractC13042fc3.h(message, "getMessage(...)");
        return new VC(tmrMessage, templateMessageResponseId, A0(message));
    }

    public static final ExPeerType v(EnumC9196Yx enumC9196Yx) {
        int i = enumC9196Yx == null ? -1 : a.h[enumC9196Yx.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? ExPeerType.UNKNOWN : ExPeerType.PRIVATE : ExPeerType.CHANNEL : ExPeerType.GROUP : ExPeerType.BOT;
    }

    public static final CollectionsStruct$MapValueItem v0(C20420rz c20420rz) {
        if (c20420rz == null) {
            return null;
        }
        return (CollectionsStruct$MapValueItem) CollectionsStruct$MapValueItem.newBuilder().A(c20420rz.getKey()).B(CollectionsStruct$RawValue.newBuilder().E(c20420rz.getKey())).a();
    }

    public static final C19811qz w0(CollectionsStruct$MapValue collectionsStruct$MapValue) {
        AbstractC13042fc3.i(collectionsStruct$MapValue, "m");
        List<CollectionsStruct$MapValueItem> itemsList = collectionsStruct$MapValue.getItemsList();
        AbstractC13042fc3.h(itemsList, "getItemsList(...)");
        List<CollectionsStruct$MapValueItem> list = itemsList;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (CollectionsStruct$MapValueItem collectionsStruct$MapValueItem : list) {
            AbstractC17566nB abstractC17566nBV0 = V0(collectionsStruct$MapValueItem.getValue());
            arrayList.add(abstractC17566nBV0 != null ? new C20420rz(collectionsStruct$MapValueItem.getKey(), abstractC17566nBV0) : null);
        }
        return new C19811qz(arrayList);
    }

    public static final List x(List list) {
        AbstractC13042fc3.i(list, "peers");
        List<C17557nA> list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        for (C17557nA c17557nA : list2) {
            PeersStruct$OutPeer.a aVarB = PeersStruct$OutPeer.newBuilder().B(c17557nA.q());
            CA caR = c17557nA.r();
            arrayList.add((PeersStruct$OutPeer) aVarB.D(caR != null ? caR.j() : -1).A(c17557nA.getAccessHash()).a());
        }
        return arrayList;
    }

    public static final C20420rz x0(CollectionsStruct$MapValueItem collectionsStruct$MapValueItem) {
        if (collectionsStruct$MapValueItem == null) {
            return null;
        }
        String key = collectionsStruct$MapValueItem.getKey();
        AbstractC17566nB abstractC17566nBV0 = V0(collectionsStruct$MapValueItem.getValue());
        AbstractC13042fc3.f(abstractC17566nBV0);
        return new C20420rz(key, abstractC17566nBV0);
    }

    public static final GS2 y(BB bb) {
        AbstractC13042fc3.i(bb, "restriction");
        int i = a.d[bb.ordinal()];
        if (i == 1) {
            return GS2.Restriction_PRIVATE;
        }
        if (i == 2) {
            return GS2.Restriction_PUBLIC;
        }
        if (i == 3) {
            return GS2.UNRECOGNIZED;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final List y0(List list) {
        AbstractC13042fc3.i(list, "ms");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C20420rz c20420rzX0 = x0((CollectionsStruct$MapValueItem) it.next());
            AbstractC13042fc3.f(c20420rzX0);
            arrayList.add(c20420rzX0);
        }
        return arrayList;
    }

    public static final GS2 z(BB bb) {
        AbstractC13042fc3.i(bb, "restriction");
        int i = a.d[bb.ordinal()];
        if (i == 1) {
            return GS2.Restriction_PRIVATE;
        }
        if (i == 2) {
            return GS2.Restriction_PUBLIC;
        }
        if (i == 3) {
            return GS2.UNRECOGNIZED;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final AbstractC21697tz z0(UsersStruct$MediaExt usersStruct$MediaExt) {
        AbstractC13042fc3.i(usersStruct$MediaExt, "media");
        if (usersStruct$MediaExt.hasIntroGif()) {
            return new C7255Qy(a.h0(usersStruct$MediaExt.getIntroGif().getThumb()), usersStruct$MediaExt.getIntroGif().getWidth(), usersStruct$MediaExt.getIntroGif().getHeight());
        }
        if (usersStruct$MediaExt.hasIntroPhoto()) {
            return new C7962Ty(a.h0(usersStruct$MediaExt.getIntroPhoto().getThumb()), usersStruct$MediaExt.getIntroPhoto().getWidth(), usersStruct$MediaExt.getIntroPhoto().getHeight());
        }
        return null;
    }

    public final AbstractC24063xz A0(MessagingStruct$Message messagingStruct$Message) {
        AbstractC13042fc3.i(messagingStruct$Message, DialogEntity.COLUMN_MESSAGE);
        MessagingStruct$Message.b traitCase = messagingStruct$Message.getTraitCase();
        switch (traitCase == null ? -1 : a.p[traitCase.ordinal()]) {
            case 1:
                MessagingStruct$BinaryMessage binaryMessage = messagingStruct$Message.getBinaryMessage();
                AbstractC13042fc3.h(binaryMessage, "getBinaryMessage(...)");
                return Z(binaryMessage);
            case 2:
                return new C20402rx();
            case 3:
                C6035Lx c6035LxD0 = d0(messagingStruct$Message.getDocumentMessage());
                AbstractC13042fc3.f(c6035LxD0);
                return c6035LxD0;
            case 4:
                return new C7246Qx();
            case 5:
                MessagingStruct$JsonMessage jsonMessage = messagingStruct$Message.getJsonMessage();
                AbstractC13042fc3.h(jsonMessage, "getJsonMessage(...)");
                return t0(jsonMessage);
            case 6:
                return e0(messagingStruct$Message);
            case 7:
                MessagingStruct$PurchaseMessage purchaseMessage = messagingStruct$Message.getPurchaseMessage();
                AbstractC13042fc3.h(purchaseMessage, "getPurchaseMessage(...)");
                return T0(purchaseMessage);
            case 8:
                MessagingStruct$ServiceMessage serviceMessage = messagingStruct$Message.getServiceMessage();
                AbstractC13042fc3.h(serviceMessage, "getServiceMessage(...)");
                return Y0(serviceMessage);
            case 9:
                MessagingStruct$StickerMessage stickerMessage = messagingStruct$Message.getStickerMessage();
                AbstractC13042fc3.h(stickerMessage, "getStickerMessage(...)");
                return c1(stickerMessage);
            case 10:
                MessagingStruct$TemplateMessage templateMessage = messagingStruct$Message.getTemplateMessage();
                AbstractC13042fc3.h(templateMessage, "getTemplateMessage(...)");
                return t1(templateMessage);
            case 11:
                MessagingStruct$TemplateMessageResponse templateMessageResponse = messagingStruct$Message.getTemplateMessageResponse();
                AbstractC13042fc3.h(templateMessageResponse, "getTemplateMessageResponse(...)");
                return u1(templateMessageResponse);
            case 12:
                MessagingStruct$TextMessage textMessage = messagingStruct$Message.getTextMessage();
                AbstractC13042fc3.h(textMessage, "getTextMessage(...)");
                return e1(textMessage);
            case 13:
                MessagingStruct$GiftPacketMessage giftPacketMessage = messagingStruct$Message.getGiftPacketMessage();
                AbstractC13042fc3.h(giftPacketMessage, "getGiftPacketMessage(...)");
                return l0(giftPacketMessage);
            case 14:
                return new C4365Ev();
            case 15:
                MessagingStruct$CrowdFundingMessage crowdFundingMessage = messagingStruct$Message.getCrowdFundingMessage();
                AbstractC13042fc3.h(crowdFundingMessage, "getCrowdFundingMessage(...)");
                return a0(crowdFundingMessage);
            case 16:
                MessagingStruct$AnimatedStickerMessage animatedStickerMessage = messagingStruct$Message.getAnimatedStickerMessage();
                AbstractC13042fc3.h(animatedStickerMessage, "getAnimatedStickerMessage(...)");
                return O(animatedStickerMessage);
            case 17:
                MessagingStruct$LiveMessage liveMessage = messagingStruct$Message.getLiveMessage();
                AbstractC13042fc3.h(liveMessage, "getLiveMessage(...)");
                return r1(liveMessage);
            case 18:
                MessagingStruct$ProtectedMessage protectedMessage = messagingStruct$Message.getProtectedMessage();
                AbstractC13042fc3.h(protectedMessage, "getProtectedMessage(...)");
                return s1(protectedMessage);
            case 19:
                MessagingStruct$GoldGiftPacketMessage goldGiftPacketMessage = messagingStruct$Message.getGoldGiftPacketMessage();
                AbstractC13042fc3.h(goldGiftPacketMessage, "getGoldGiftPacketMessage(...)");
                return m0(goldGiftPacketMessage);
            case 20:
                MessagingStruct$PollMessage pollMessage = messagingStruct$Message.getPollMessage();
                AbstractC13042fc3.h(pollMessage, "getPollMessage(...)");
                return M0(pollMessage);
            case 21:
                MessagingStruct$BannedMessage bannedMessage = messagingStruct$Message.getBannedMessage();
                AbstractC13042fc3.h(bannedMessage, "getBannedMessage(...)");
                return Y(bannedMessage);
            case 22:
                MessagingStruct$BankMessage bankMessage = messagingStruct$Message.getBankMessage();
                AbstractC13042fc3.h(bankMessage, "getBankMessage(...)");
                return U(bankMessage);
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
                return new C7246Qx();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final C25247zz C0(MessagingStruct$MessageContainer messagingStruct$MessageContainer) {
        AbstractC13042fc3.i(messagingStruct$MessageContainer, "pin");
        int senderUid = messagingStruct$MessageContainer.getSenderUid();
        long rid = messagingStruct$MessageContainer.getRid();
        long date = messagingStruct$MessageContainer.getDate();
        MessagingStruct$Message message = messagingStruct$MessageContainer.getMessage();
        AbstractC13042fc3.h(message, "getMessage(...)");
        AbstractC24063xz abstractC24063xzA0 = A0(message);
        EnumC4884Gz enumC4884GzP = EnumC4884Gz.p(messagingStruct$MessageContainer.getStateValue() + 1);
        List<MessagingStruct$MessageReaction> reactionsList = messagingStruct$MessageContainer.getReactionsList();
        AbstractC13042fc3.h(reactionsList, "getReactionsList(...)");
        List listF0 = F0(reactionsList);
        C24653yz c24653yzB0 = B0(messagingStruct$MessageContainer.getAttribute());
        C16975mB c16975mBU0 = U0(messagingStruct$MessageContainer.getQuotedMessage());
        CollectionsStruct$Int64Value seq = messagingStruct$MessageContainer.getSeq();
        Long lValueOf = seq != null ? Long.valueOf(seq.getValue()) : null;
        C3460Az c3460AzD0 = D0(messagingStruct$MessageContainer.getPreviousMessageId());
        C3460Az c3460AzD02 = D0(messagingStruct$MessageContainer.getNextMessageId());
        CollectionsStruct$Int64Value editedAt = messagingStruct$MessageContainer.getEditedAt();
        Long lValueOf2 = editedAt != null ? Long.valueOf(editedAt.getValue()) : null;
        Int32Value editorUserId = messagingStruct$MessageContainer.getEditorUserId();
        Integer numValueOf = editorUserId != null ? Integer.valueOf(editorUserId.getValue()) : null;
        CollectionsStruct$Int64Value groupedId = messagingStruct$MessageContainer.getGroupedId();
        Long lValueOf3 = groupedId != null ? Long.valueOf(groupedId.getValue()) : null;
        BoolValue hasComment = messagingStruct$MessageContainer.getHasComment();
        return new C25247zz(senderUid, rid, date, abstractC24063xzA0, enumC4884GzP, listF0, c24653yzB0, c16975mBU0, lValueOf, c3460AzD0, c3460AzD02, lValueOf2, numValueOf, lValueOf3, hasComment != null ? Boolean.valueOf(hasComment.getValue()) : null, X0(messagingStruct$MessageContainer.getReplies()), D0(messagingStruct$MessageContainer.getReplyToTopId()));
    }

    public final C17532n74 D(C23592xB c23592xB, boolean z) {
        C17532n74 c17532n74;
        if (c23592xB == null && !z) {
            c17532n74 = null;
        } else {
            if (!z || c23592xB != null) {
                AbstractC13042fc3.f(c23592xB);
                return new C17532n74(c23592xB.s(), c23592xB.r(), I(c23592xB.q()), new C7880To7(0L, 0L, null, 7, null), 0, 0, false, 0L, 0, 448, null);
            }
            c17532n74 = new C17532n74(0, null, null, null, null, null, false, 0L, 0, 511, null);
        }
        return c17532n74;
    }

    public final C3460Az D0(MessagingStruct$MessageId messagingStruct$MessageId) {
        if (messagingStruct$MessageId == null) {
            return null;
        }
        if (messagingStruct$MessageId.getRid() == 0 && messagingStruct$MessageId.getDate() == 0) {
            return null;
        }
        return new C3460Az(messagingStruct$MessageId.getDate(), messagingStruct$MessageId.getRid(), messagingStruct$MessageId.getSeq());
    }

    public final C25247zz E(MessagingStruct$MessageContainer messagingStruct$MessageContainer) {
        if (messagingStruct$MessageContainer == null) {
            return null;
        }
        int senderUid = messagingStruct$MessageContainer.getSenderUid();
        long rid = messagingStruct$MessageContainer.getRid();
        long date = messagingStruct$MessageContainer.getDate();
        MessagingStruct$Message message = messagingStruct$MessageContainer.getMessage();
        AbstractC13042fc3.h(message, "getMessage(...)");
        AbstractC24063xz abstractC24063xzA0 = A0(message);
        EnumC4884Gz enumC4884GzP = EnumC4884Gz.p(messagingStruct$MessageContainer.getStateValue() + 1);
        List<MessagingStruct$MessageReaction> reactionsList = messagingStruct$MessageContainer.getReactionsList();
        AbstractC13042fc3.h(reactionsList, "getReactionsList(...)");
        List listF0 = F0(reactionsList);
        C24653yz c24653yzB0 = B0(messagingStruct$MessageContainer.getAttribute());
        C16975mB c16975mBL0 = L0(messagingStruct$MessageContainer.getQuotedMessage());
        CollectionsStruct$Int64Value seq = messagingStruct$MessageContainer.getSeq();
        Long lValueOf = seq != null ? Long.valueOf(seq.getValue()) : null;
        C3460Az c3460AzD0 = D0(messagingStruct$MessageContainer.getPreviousMessageId());
        C3460Az c3460AzD02 = D0(messagingStruct$MessageContainer.getNextMessageId());
        CollectionsStruct$Int64Value editedAt = messagingStruct$MessageContainer.getEditedAt();
        Long lValueOf2 = editedAt != null ? Long.valueOf(editedAt.getValue()) : null;
        Int32Value editorUserId = messagingStruct$MessageContainer.getEditorUserId();
        Integer numValueOf = editorUserId != null ? Integer.valueOf(editorUserId.getValue()) : null;
        CollectionsStruct$Int64Value groupedId = messagingStruct$MessageContainer.getGroupedId();
        Long lValueOf3 = groupedId != null ? Long.valueOf(groupedId.getValue()) : null;
        BoolValue hasComment = messagingStruct$MessageContainer.getHasComment();
        return new C25247zz(senderUid, rid, date, abstractC24063xzA0, enumC4884GzP, listF0, c24653yzB0, c16975mBL0, lValueOf, c3460AzD0, c3460AzD02, lValueOf2, numValueOf, lValueOf3, hasComment != null ? Boolean.valueOf(hasComment.getValue()) : null, X0(messagingStruct$MessageContainer.getReplies()), D0(messagingStruct$MessageContainer.getReplyToTopId()));
    }

    public final C7880To7 H(MessagingStruct$MessageId messagingStruct$MessageId) {
        return new C7880To7(messagingStruct$MessageId != null ? messagingStruct$MessageId.getRid() : 0L, messagingStruct$MessageId != null ? messagingStruct$MessageId.getDate() : 0L, null, 4, null);
    }

    public final C7880To7 I(C3460Az c3460Az) {
        return new C7880To7(c3460Az != null ? c3460Az.i() : 0L, c3460Az != null ? c3460Az.h() : 0L, null, 4, null);
    }

    public final C17557nA I0(PeersStruct$OutPeer peersStruct$OutPeer) {
        if (peersStruct$OutPeer == null) {
            return null;
        }
        return new C17557nA(CA.p(peersStruct$OutPeer.getTypeValue()), peersStruct$OutPeer.getId(), peersStruct$OutPeer.getAccessHash());
    }

    public final C16975mB U0(MessagingStruct$QuotedMessage messagingStruct$QuotedMessage) {
        LC lcD1 = null;
        if (j1(messagingStruct$QuotedMessage) || messagingStruct$QuotedMessage == null) {
            return null;
        }
        CollectionsStruct$Int64Value messageId = messagingStruct$QuotedMessage.getMessageId();
        Long lValueOf = messageId != null ? Long.valueOf(messageId.getValue()) : null;
        Int32Value publicGroupId = messagingStruct$QuotedMessage.getPublicGroupId();
        Integer numValueOf = publicGroupId != null ? Integer.valueOf(publicGroupId.getValue()) : null;
        int senderUserId = messagingStruct$QuotedMessage.getSenderUserId();
        long messageDate = messagingStruct$QuotedMessage.getMessageDate();
        MessagingStruct$Message quotedMessageContent = messagingStruct$QuotedMessage.getQuotedMessageContent();
        AbstractC13042fc3.h(quotedMessageContent, "getQuotedMessageContent(...)");
        AbstractC24063xz abstractC24063xzA0 = A0(quotedMessageContent);
        C17557nA c17557nAI0 = I0(messagingStruct$QuotedMessage.getQuotedPeer());
        if (messagingStruct$QuotedMessage.hasStory()) {
            MessagingStruct$StoryReference story = messagingStruct$QuotedMessage.getStory();
            AbstractC13042fc3.h(story, "getStory(...)");
            lcD1 = d1(story);
        }
        return new C16975mB(lValueOf, numValueOf, senderUserId, messageDate, abstractC24063xzA0, c17557nAI0, lcD1);
    }

    public final C6035Lx d0(MessagingStruct$DocumentMessage messagingStruct$DocumentMessage) {
        if (messagingStruct$DocumentMessage == null) {
            return null;
        }
        long fileId = messagingStruct$DocumentMessage.getFileId();
        long accessHash = messagingStruct$DocumentMessage.getAccessHash();
        int fileSize = messagingStruct$DocumentMessage.getFileSize();
        String name = messagingStruct$DocumentMessage.getName();
        String mimeType = messagingStruct$DocumentMessage.getMimeType();
        C18732p92 c18732p92 = a;
        C11413cy c11413cyH0 = c18732p92.h0(messagingStruct$DocumentMessage.getThumb());
        MessagingStruct$DocumentEx ext = messagingStruct$DocumentMessage.getExt();
        AbstractC13042fc3.h(ext, "getExt(...)");
        AbstractC4383Ex abstractC4383ExC0 = c18732p92.c0(ext);
        MessagingStruct$TextMessage caption = messagingStruct$DocumentMessage.getCaption();
        AbstractC13042fc3.h(caption, "getCaption(...)");
        ZC zcE1 = c18732p92.e1(caption);
        StringValue checkSum = messagingStruct$DocumentMessage.getCheckSum();
        String value = checkSum != null ? checkSum.getValue() : null;
        StringValue algorithm = messagingStruct$DocumentMessage.getAlgorithm();
        String value2 = algorithm != null ? algorithm.getValue() : null;
        Int32Value fileStorageVersion = messagingStruct$DocumentMessage.getFileStorageVersion();
        Integer numValueOf = fileStorageVersion != null ? Integer.valueOf(fileStorageVersion.getValue()) : null;
        CollectionsStruct$Int64Value groupedId = messagingStruct$DocumentMessage.getGroupedId();
        return new C6035Lx(fileId, accessHash, fileSize, name, mimeType, c11413cyH0, abstractC4383ExC0, zcE1, value, value2, numValueOf, groupedId != null ? Long.valueOf(groupedId.getValue()) : null, c18732p92.G0(messagingStruct$DocumentMessage.getMessageTag()));
    }

    public final LC d1(MessagingStruct$StoryReference messagingStruct$StoryReference) {
        AbstractC13042fc3.i(messagingStruct$StoryReference, "story");
        return new LC(messagingStruct$StoryReference.getStoryId(), new C16966mA(EnumC9196Yx.PRIVATE, messagingStruct$StoryReference.getOwner().getId(), 0L));
    }

    public final SQ e(WQ wq) {
        AbstractC13042fc3.i(wq, "type");
        switch (a.v[wq.ordinal()]) {
            case 1:
                return SQ.a;
            case 2:
                return SQ.b;
            case 3:
                return SQ.c;
            case 4:
                return SQ.d;
            case 5:
                return SQ.e;
            case 6:
                return SQ.f;
            case 7:
                return SQ.g;
            case 8:
                return SQ.h;
            case 9:
                return SQ.i;
            case 10:
                return SQ.j;
            case 11:
                return SQ.l;
            case 12:
                return SQ.k;
            case 13:
                return SQ.a;
            case 14:
                return SQ.m;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final WQ f(SQ sq) {
        AbstractC13042fc3.i(sq, "authSendCodeType");
        switch (a.u[sq.ordinal()]) {
            case 1:
                return WQ.AuthSendCodeType_UNKNOWN;
            case 2:
                return WQ.AuthSendCodeType_DEFAULT;
            case 3:
                return WQ.AuthSendCodeType_BALEONLY;
            case 4:
                return WQ.AuthSendCodeType_SMS;
            case 5:
                return WQ.AuthSendCodeType_CALL;
            case 6:
                return WQ.AuthSendCodeType_EMAIL;
            case 7:
                return WQ.AuthSendCodeType_MISSCALL;
            case 8:
                return WQ.AuthSendCodeType_SETUP_EMAIL_REQUIRED;
            case 9:
                return WQ.AuthSendCodeType_WHATSAPP;
            case 10:
                return WQ.AuthSendCodeType_TELEGRAM;
            case 11:
                return WQ.AuthSendCodeType_FUTURE_AUTH_TOKEN;
            case 12:
                return WQ.AuthSendCodeType_USSD;
            case 13:
                return WQ.AuthSendCodeType_TELEGRAM_GATEWAY;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean j1(MessagingStruct$QuotedMessage messagingStruct$QuotedMessage) {
        CollectionsStruct$Int64Value messageId;
        String storyId;
        return messagingStruct$QuotedMessage == null || ((messageId = messagingStruct$QuotedMessage.getMessageId()) != null && messageId.getValue() == 0 && ((storyId = messagingStruct$QuotedMessage.getStory().getStoryId()) == null || storyId.length() == 0));
    }

    public final C25238zy q1(PeersStruct$GroupOutPeer peersStruct$GroupOutPeer) {
        AbstractC13042fc3.i(peersStruct$GroupOutPeer, "apiOutPeer");
        return new C25238zy(peersStruct$GroupOutPeer.getGroupId(), peersStruct$GroupOutPeer.getAccessHash());
    }

    public final EnumC19769qu4 v1(EnumC4884Gz enumC4884Gz) {
        int i = enumC4884Gz == null ? -1 : a.a[enumC4884Gz.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? EnumC19769qu4.d : EnumC19769qu4.a : EnumC19769qu4.b : EnumC19769qu4.c;
    }

    public final ExPeerType w(EnumC10088b35 enumC10088b35) {
        AbstractC13042fc3.i(enumC10088b35, "exPeer");
        switch (a.j[enumC10088b35.ordinal()]) {
            case 1:
                return ExPeerType.BOT;
            case 2:
                return ExPeerType.PRIVATE;
            case 3:
                return ExPeerType.GROUP;
            case 4:
                return ExPeerType.CHANNEL;
            case 5:
                return ExPeerType.GROUP;
            case 6:
                return ExPeerType.THREAD;
            default:
                return ExPeerType.UNKNOWN;
        }
    }

    public final C18766pD w1(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        AbstractC13042fc3.i(peersStruct$UserOutPeer, "apiOutPeer");
        return new C18766pD(peersStruct$UserOutPeer.getUid(), peersStruct$UserOutPeer.getAccessHash());
    }

    public final PeersStruct$OutExPeer x1(C16966mA c16966mA) {
        EnumC9196Yx enumC9196YxR;
        if (c16966mA == null || (enumC9196YxR = c16966mA.r()) == null) {
            return null;
        }
        return (PeersStruct$OutExPeer) PeersStruct$OutExPeer.newBuilder().B(c16966mA.q()).D(enumC9196YxR.j()).A(c16966mA.getAccessHash()).a();
    }

    public final PeersStruct$OutPeer y1(C17557nA c17557nA) {
        AbstractC13042fc3.i(c17557nA, "apiOutPeer");
        CA caR = c17557nA.r();
        if (caR == null) {
            return null;
        }
        return (PeersStruct$OutPeer) PeersStruct$OutPeer.newBuilder().A(c17557nA.getAccessHash()).B(c17557nA.q()).D(caR.j()).a();
    }
}
