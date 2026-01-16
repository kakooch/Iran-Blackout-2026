package ai.bale.proto;

import ai.bale.proto.MessagingStruct$AdvertisementMessage;
import ai.bale.proto.MessagingStruct$AnimatedStickerMessage;
import ai.bale.proto.MessagingStruct$BankMessage;
import ai.bale.proto.MessagingStruct$BannedMessage;
import ai.bale.proto.MessagingStruct$BinaryMessage;
import ai.bale.proto.MessagingStruct$BoughtPremiumMessage;
import ai.bale.proto.MessagingStruct$CrowdFundingMessage;
import ai.bale.proto.MessagingStruct$DeletedMessage;
import ai.bale.proto.MessagingStruct$DocumentMessage;
import ai.bale.proto.MessagingStruct$EmptyMessage;
import ai.bale.proto.MessagingStruct$GiftPacketMessage;
import ai.bale.proto.MessagingStruct$GoldGiftPacketMessage;
import ai.bale.proto.MessagingStruct$JsonMessage;
import ai.bale.proto.MessagingStruct$LiveMessage;
import ai.bale.proto.MessagingStruct$NasimEncryptedMessage;
import ai.bale.proto.MessagingStruct$NewPremiumMessage;
import ai.bale.proto.MessagingStruct$OrderMessage;
import ai.bale.proto.MessagingStruct$PollMessage;
import ai.bale.proto.MessagingStruct$PremiumMessage;
import ai.bale.proto.MessagingStruct$ProtectedMessage;
import ai.bale.proto.MessagingStruct$PurchaseMessage;
import ai.bale.proto.MessagingStruct$ServiceMessage;
import ai.bale.proto.MessagingStruct$StickerMessage;
import ai.bale.proto.MessagingStruct$StoryReference;
import ai.bale.proto.MessagingStruct$TemplateMessage;
import ai.bale.proto.MessagingStruct$TemplateMessageResponse;
import ai.bale.proto.MessagingStruct$TextMessage;
import ai.bale.proto.MessagingStruct$UnsupportedMessage;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$Message extends GeneratedMessageLite implements U64 {
    public static final int ADVERTISEMENT_MESSAGE_FIELD_NUMBER = 21;
    public static final int ANIMATED_STICKER_MESSAGE_FIELD_NUMBER = 24;
    public static final int BANK_MESSAGE_FIELD_NUMBER = 1;
    public static final int BANNED_MESSAGE_FIELD_NUMBER = 25;
    public static final int BINARY_MESSAGE_FIELD_NUMBER = 2;
    public static final int BOUGHT_PREMIUM_MESSAGE_FIELD_NUMBER = 20;
    public static final int CROWD_FUNDING_MESSAGE_FIELD_NUMBER = 23;
    private static final MessagingStruct$Message DEFAULT_INSTANCE;
    public static final int DELETED_MESSAGE_FIELD_NUMBER = 3;
    public static final int DOCUMENT_MESSAGE_FIELD_NUMBER = 4;
    public static final int EMPTY_MESSAGE_FIELD_NUMBER = 5;
    public static final int GIFT_PACKET_MESSAGE_FIELD_NUMBER = 17;
    public static final int GOLD_GIFT_PACKET_MESSAGE_FIELD_NUMBER = 28;
    public static final int JSON_MESSAGE_FIELD_NUMBER = 7;
    public static final int LIVE_MESSAGE_FIELD_NUMBER = 26;
    public static final int NASIM_ENCRYPTED_MESSAGE_FIELD_NUMBER = 8;
    public static final int NEW_PREMIUM_MESSAGE_FIELD_NUMBER = 19;
    public static final int ORDER_MESSAGE_FIELD_NUMBER = 9;
    private static volatile KW4 PARSER = null;
    public static final int POLL_MESSAGE_FIELD_NUMBER = 29;
    public static final int PREMIUM_MESSAGE_FIELD_NUMBER = 18;
    public static final int PROTECTED_MESSAGE_FIELD_NUMBER = 27;
    public static final int PURCHASE_MESSAGE_FIELD_NUMBER = 10;
    public static final int SERVICE_MESSAGE_FIELD_NUMBER = 11;
    public static final int STICKER_MESSAGE_FIELD_NUMBER = 12;
    public static final int STORY_FIELD_NUMBER = 100;
    public static final int TEMPLATE_MESSAGE_FIELD_NUMBER = 13;
    public static final int TEMPLATE_MESSAGE_RESPONSE_FIELD_NUMBER = 14;
    public static final int TEXT_MESSAGE_FIELD_NUMBER = 15;
    public static final int UNSUPPORTED_MESSAGE_FIELD_NUMBER = 16;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$Message.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        BANK_MESSAGE(1),
        BINARY_MESSAGE(2),
        DELETED_MESSAGE(3),
        DOCUMENT_MESSAGE(4),
        EMPTY_MESSAGE(5),
        JSON_MESSAGE(7),
        NASIM_ENCRYPTED_MESSAGE(8),
        ORDER_MESSAGE(9),
        PURCHASE_MESSAGE(10),
        SERVICE_MESSAGE(11),
        STICKER_MESSAGE(12),
        TEMPLATE_MESSAGE(13),
        TEMPLATE_MESSAGE_RESPONSE(14),
        TEXT_MESSAGE(15),
        UNSUPPORTED_MESSAGE(16),
        GIFT_PACKET_MESSAGE(17),
        PREMIUM_MESSAGE(18),
        NEW_PREMIUM_MESSAGE(19),
        BOUGHT_PREMIUM_MESSAGE(20),
        ADVERTISEMENT_MESSAGE(21),
        CROWD_FUNDING_MESSAGE(23),
        ANIMATED_STICKER_MESSAGE(24),
        BANNED_MESSAGE(25),
        LIVE_MESSAGE(26),
        PROTECTED_MESSAGE(27),
        GOLD_GIFT_PACKET_MESSAGE(28),
        POLL_MESSAGE(29),
        STORY(100),
        TRAIT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return TRAIT_NOT_SET;
            }
            if (i == 1) {
                return BANK_MESSAGE;
            }
            if (i == 2) {
                return BINARY_MESSAGE;
            }
            if (i == 3) {
                return DELETED_MESSAGE;
            }
            if (i == 4) {
                return DOCUMENT_MESSAGE;
            }
            if (i == 5) {
                return EMPTY_MESSAGE;
            }
            if (i == 100) {
                return STORY;
            }
            switch (i) {
                case 7:
                    return JSON_MESSAGE;
                case 8:
                    return NASIM_ENCRYPTED_MESSAGE;
                case 9:
                    return ORDER_MESSAGE;
                case 10:
                    return PURCHASE_MESSAGE;
                case 11:
                    return SERVICE_MESSAGE;
                case 12:
                    return STICKER_MESSAGE;
                case 13:
                    return TEMPLATE_MESSAGE;
                case 14:
                    return TEMPLATE_MESSAGE_RESPONSE;
                case 15:
                    return TEXT_MESSAGE;
                case 16:
                    return UNSUPPORTED_MESSAGE;
                case 17:
                    return GIFT_PACKET_MESSAGE;
                case 18:
                    return PREMIUM_MESSAGE;
                case 19:
                    return NEW_PREMIUM_MESSAGE;
                case 20:
                    return BOUGHT_PREMIUM_MESSAGE;
                case 21:
                    return ADVERTISEMENT_MESSAGE;
                default:
                    switch (i) {
                        case 23:
                            return CROWD_FUNDING_MESSAGE;
                        case 24:
                            return ANIMATED_STICKER_MESSAGE;
                        case 25:
                            return BANNED_MESSAGE;
                        case 26:
                            return LIVE_MESSAGE;
                        case 27:
                            return PROTECTED_MESSAGE;
                        case 28:
                            return GOLD_GIFT_PACKET_MESSAGE;
                        case 29:
                            return POLL_MESSAGE;
                        default:
                            return null;
                    }
            }
        }
    }

    static {
        MessagingStruct$Message messagingStruct$Message = new MessagingStruct$Message();
        DEFAULT_INSTANCE = messagingStruct$Message;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$Message.class, messagingStruct$Message);
    }

    private MessagingStruct$Message() {
    }

    private void clearAdvertisementMessage() {
        if (this.traitCase_ == 21) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearAnimatedStickerMessage() {
        if (this.traitCase_ == 24) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearBankMessage() {
        if (this.traitCase_ == 1) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearBannedMessage() {
        if (this.traitCase_ == 25) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearBinaryMessage() {
        if (this.traitCase_ == 2) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearBoughtPremiumMessage() {
        if (this.traitCase_ == 20) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearCrowdFundingMessage() {
        if (this.traitCase_ == 23) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearDeletedMessage() {
        if (this.traitCase_ == 3) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearDocumentMessage() {
        if (this.traitCase_ == 4) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearEmptyMessage() {
        if (this.traitCase_ == 5) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGiftPacketMessage() {
        if (this.traitCase_ == 17) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearGoldGiftPacketMessage() {
        if (this.traitCase_ == 28) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearJsonMessage() {
        if (this.traitCase_ == 7) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearLiveMessage() {
        if (this.traitCase_ == 26) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearNasimEncryptedMessage() {
        if (this.traitCase_ == 8) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearNewPremiumMessage() {
        if (this.traitCase_ == 19) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearOrderMessage() {
        if (this.traitCase_ == 9) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearPollMessage() {
        if (this.traitCase_ == 29) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearPremiumMessage() {
        if (this.traitCase_ == 18) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearProtectedMessage() {
        if (this.traitCase_ == 27) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearPurchaseMessage() {
        if (this.traitCase_ == 10) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearServiceMessage() {
        if (this.traitCase_ == 11) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearStickerMessage() {
        if (this.traitCase_ == 12) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearStory() {
        if (this.traitCase_ == 100) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTemplateMessage() {
        if (this.traitCase_ == 13) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTemplateMessageResponse() {
        if (this.traitCase_ == 14) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTextMessage() {
        if (this.traitCase_ == 15) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    private void clearUnsupportedMessage() {
        if (this.traitCase_ == 16) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    public static MessagingStruct$Message getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAdvertisementMessage(MessagingStruct$AdvertisementMessage messagingStruct$AdvertisementMessage) {
        messagingStruct$AdvertisementMessage.getClass();
        if (this.traitCase_ != 21 || this.trait_ == MessagingStruct$AdvertisementMessage.getDefaultInstance()) {
            this.trait_ = messagingStruct$AdvertisementMessage;
        } else {
            this.trait_ = ((MessagingStruct$AdvertisementMessage.a) MessagingStruct$AdvertisementMessage.newBuilder((MessagingStruct$AdvertisementMessage) this.trait_).v(messagingStruct$AdvertisementMessage)).j();
        }
        this.traitCase_ = 21;
    }

    private void mergeAnimatedStickerMessage(MessagingStruct$AnimatedStickerMessage messagingStruct$AnimatedStickerMessage) {
        messagingStruct$AnimatedStickerMessage.getClass();
        if (this.traitCase_ != 24 || this.trait_ == MessagingStruct$AnimatedStickerMessage.getDefaultInstance()) {
            this.trait_ = messagingStruct$AnimatedStickerMessage;
        } else {
            this.trait_ = ((MessagingStruct$AnimatedStickerMessage.a) MessagingStruct$AnimatedStickerMessage.newBuilder((MessagingStruct$AnimatedStickerMessage) this.trait_).v(messagingStruct$AnimatedStickerMessage)).j();
        }
        this.traitCase_ = 24;
    }

    private void mergeBankMessage(MessagingStruct$BankMessage messagingStruct$BankMessage) {
        messagingStruct$BankMessage.getClass();
        if (this.traitCase_ != 1 || this.trait_ == MessagingStruct$BankMessage.getDefaultInstance()) {
            this.trait_ = messagingStruct$BankMessage;
        } else {
            this.trait_ = ((MessagingStruct$BankMessage.a) MessagingStruct$BankMessage.newBuilder((MessagingStruct$BankMessage) this.trait_).v(messagingStruct$BankMessage)).j();
        }
        this.traitCase_ = 1;
    }

    private void mergeBannedMessage(MessagingStruct$BannedMessage messagingStruct$BannedMessage) {
        messagingStruct$BannedMessage.getClass();
        if (this.traitCase_ != 25 || this.trait_ == MessagingStruct$BannedMessage.getDefaultInstance()) {
            this.trait_ = messagingStruct$BannedMessage;
        } else {
            this.trait_ = ((MessagingStruct$BannedMessage.a) MessagingStruct$BannedMessage.newBuilder((MessagingStruct$BannedMessage) this.trait_).v(messagingStruct$BannedMessage)).j();
        }
        this.traitCase_ = 25;
    }

    private void mergeBinaryMessage(MessagingStruct$BinaryMessage messagingStruct$BinaryMessage) {
        messagingStruct$BinaryMessage.getClass();
        if (this.traitCase_ != 2 || this.trait_ == MessagingStruct$BinaryMessage.getDefaultInstance()) {
            this.trait_ = messagingStruct$BinaryMessage;
        } else {
            this.trait_ = ((MessagingStruct$BinaryMessage.a) MessagingStruct$BinaryMessage.newBuilder((MessagingStruct$BinaryMessage) this.trait_).v(messagingStruct$BinaryMessage)).j();
        }
        this.traitCase_ = 2;
    }

    private void mergeBoughtPremiumMessage(MessagingStruct$BoughtPremiumMessage messagingStruct$BoughtPremiumMessage) {
        messagingStruct$BoughtPremiumMessage.getClass();
        if (this.traitCase_ != 20 || this.trait_ == MessagingStruct$BoughtPremiumMessage.getDefaultInstance()) {
            this.trait_ = messagingStruct$BoughtPremiumMessage;
        } else {
            this.trait_ = ((MessagingStruct$BoughtPremiumMessage.a) MessagingStruct$BoughtPremiumMessage.newBuilder((MessagingStruct$BoughtPremiumMessage) this.trait_).v(messagingStruct$BoughtPremiumMessage)).j();
        }
        this.traitCase_ = 20;
    }

    private void mergeCrowdFundingMessage(MessagingStruct$CrowdFundingMessage messagingStruct$CrowdFundingMessage) {
        messagingStruct$CrowdFundingMessage.getClass();
        if (this.traitCase_ != 23 || this.trait_ == MessagingStruct$CrowdFundingMessage.getDefaultInstance()) {
            this.trait_ = messagingStruct$CrowdFundingMessage;
        } else {
            this.trait_ = ((MessagingStruct$CrowdFundingMessage.a) MessagingStruct$CrowdFundingMessage.newBuilder((MessagingStruct$CrowdFundingMessage) this.trait_).v(messagingStruct$CrowdFundingMessage)).j();
        }
        this.traitCase_ = 23;
    }

    private void mergeDeletedMessage(MessagingStruct$DeletedMessage messagingStruct$DeletedMessage) {
        messagingStruct$DeletedMessage.getClass();
        if (this.traitCase_ != 3 || this.trait_ == MessagingStruct$DeletedMessage.getDefaultInstance()) {
            this.trait_ = messagingStruct$DeletedMessage;
        } else {
            this.trait_ = ((MessagingStruct$DeletedMessage.a) MessagingStruct$DeletedMessage.newBuilder((MessagingStruct$DeletedMessage) this.trait_).v(messagingStruct$DeletedMessage)).j();
        }
        this.traitCase_ = 3;
    }

    private void mergeDocumentMessage(MessagingStruct$DocumentMessage messagingStruct$DocumentMessage) {
        messagingStruct$DocumentMessage.getClass();
        if (this.traitCase_ != 4 || this.trait_ == MessagingStruct$DocumentMessage.getDefaultInstance()) {
            this.trait_ = messagingStruct$DocumentMessage;
        } else {
            this.trait_ = ((MessagingStruct$DocumentMessage.a) MessagingStruct$DocumentMessage.newBuilder((MessagingStruct$DocumentMessage) this.trait_).v(messagingStruct$DocumentMessage)).j();
        }
        this.traitCase_ = 4;
    }

    private void mergeEmptyMessage(MessagingStruct$EmptyMessage messagingStruct$EmptyMessage) {
        messagingStruct$EmptyMessage.getClass();
        if (this.traitCase_ != 5 || this.trait_ == MessagingStruct$EmptyMessage.getDefaultInstance()) {
            this.trait_ = messagingStruct$EmptyMessage;
        } else {
            this.trait_ = ((MessagingStruct$EmptyMessage.a) MessagingStruct$EmptyMessage.newBuilder((MessagingStruct$EmptyMessage) this.trait_).v(messagingStruct$EmptyMessage)).j();
        }
        this.traitCase_ = 5;
    }

    private void mergeGiftPacketMessage(MessagingStruct$GiftPacketMessage messagingStruct$GiftPacketMessage) {
        messagingStruct$GiftPacketMessage.getClass();
        if (this.traitCase_ != 17 || this.trait_ == MessagingStruct$GiftPacketMessage.getDefaultInstance()) {
            this.trait_ = messagingStruct$GiftPacketMessage;
        } else {
            this.trait_ = ((MessagingStruct$GiftPacketMessage.a) MessagingStruct$GiftPacketMessage.newBuilder((MessagingStruct$GiftPacketMessage) this.trait_).v(messagingStruct$GiftPacketMessage)).j();
        }
        this.traitCase_ = 17;
    }

    private void mergeGoldGiftPacketMessage(MessagingStruct$GoldGiftPacketMessage messagingStruct$GoldGiftPacketMessage) {
        messagingStruct$GoldGiftPacketMessage.getClass();
        if (this.traitCase_ != 28 || this.trait_ == MessagingStruct$GoldGiftPacketMessage.getDefaultInstance()) {
            this.trait_ = messagingStruct$GoldGiftPacketMessage;
        } else {
            this.trait_ = ((MessagingStruct$GoldGiftPacketMessage.a) MessagingStruct$GoldGiftPacketMessage.newBuilder((MessagingStruct$GoldGiftPacketMessage) this.trait_).v(messagingStruct$GoldGiftPacketMessage)).j();
        }
        this.traitCase_ = 28;
    }

    private void mergeJsonMessage(MessagingStruct$JsonMessage messagingStruct$JsonMessage) {
        messagingStruct$JsonMessage.getClass();
        if (this.traitCase_ != 7 || this.trait_ == MessagingStruct$JsonMessage.getDefaultInstance()) {
            this.trait_ = messagingStruct$JsonMessage;
        } else {
            this.trait_ = ((MessagingStruct$JsonMessage.a) MessagingStruct$JsonMessage.newBuilder((MessagingStruct$JsonMessage) this.trait_).v(messagingStruct$JsonMessage)).j();
        }
        this.traitCase_ = 7;
    }

    private void mergeLiveMessage(MessagingStruct$LiveMessage messagingStruct$LiveMessage) {
        messagingStruct$LiveMessage.getClass();
        if (this.traitCase_ != 26 || this.trait_ == MessagingStruct$LiveMessage.getDefaultInstance()) {
            this.trait_ = messagingStruct$LiveMessage;
        } else {
            this.trait_ = ((MessagingStruct$LiveMessage.a) MessagingStruct$LiveMessage.newBuilder((MessagingStruct$LiveMessage) this.trait_).v(messagingStruct$LiveMessage)).j();
        }
        this.traitCase_ = 26;
    }

    private void mergeNasimEncryptedMessage(MessagingStruct$NasimEncryptedMessage messagingStruct$NasimEncryptedMessage) {
        messagingStruct$NasimEncryptedMessage.getClass();
        if (this.traitCase_ != 8 || this.trait_ == MessagingStruct$NasimEncryptedMessage.getDefaultInstance()) {
            this.trait_ = messagingStruct$NasimEncryptedMessage;
        } else {
            this.trait_ = ((MessagingStruct$NasimEncryptedMessage.a) MessagingStruct$NasimEncryptedMessage.newBuilder((MessagingStruct$NasimEncryptedMessage) this.trait_).v(messagingStruct$NasimEncryptedMessage)).j();
        }
        this.traitCase_ = 8;
    }

    private void mergeNewPremiumMessage(MessagingStruct$NewPremiumMessage messagingStruct$NewPremiumMessage) {
        messagingStruct$NewPremiumMessage.getClass();
        if (this.traitCase_ != 19 || this.trait_ == MessagingStruct$NewPremiumMessage.getDefaultInstance()) {
            this.trait_ = messagingStruct$NewPremiumMessage;
        } else {
            this.trait_ = ((MessagingStruct$NewPremiumMessage.a) MessagingStruct$NewPremiumMessage.newBuilder((MessagingStruct$NewPremiumMessage) this.trait_).v(messagingStruct$NewPremiumMessage)).j();
        }
        this.traitCase_ = 19;
    }

    private void mergeOrderMessage(MessagingStruct$OrderMessage messagingStruct$OrderMessage) {
        messagingStruct$OrderMessage.getClass();
        if (this.traitCase_ != 9 || this.trait_ == MessagingStruct$OrderMessage.getDefaultInstance()) {
            this.trait_ = messagingStruct$OrderMessage;
        } else {
            this.trait_ = ((MessagingStruct$OrderMessage.a) MessagingStruct$OrderMessage.newBuilder((MessagingStruct$OrderMessage) this.trait_).v(messagingStruct$OrderMessage)).j();
        }
        this.traitCase_ = 9;
    }

    private void mergePollMessage(MessagingStruct$PollMessage messagingStruct$PollMessage) {
        messagingStruct$PollMessage.getClass();
        if (this.traitCase_ != 29 || this.trait_ == MessagingStruct$PollMessage.getDefaultInstance()) {
            this.trait_ = messagingStruct$PollMessage;
        } else {
            this.trait_ = ((MessagingStruct$PollMessage.a) MessagingStruct$PollMessage.newBuilder((MessagingStruct$PollMessage) this.trait_).v(messagingStruct$PollMessage)).j();
        }
        this.traitCase_ = 29;
    }

    private void mergePremiumMessage(MessagingStruct$PremiumMessage messagingStruct$PremiumMessage) {
        messagingStruct$PremiumMessage.getClass();
        if (this.traitCase_ != 18 || this.trait_ == MessagingStruct$PremiumMessage.getDefaultInstance()) {
            this.trait_ = messagingStruct$PremiumMessage;
        } else {
            this.trait_ = ((MessagingStruct$PremiumMessage.a) MessagingStruct$PremiumMessage.newBuilder((MessagingStruct$PremiumMessage) this.trait_).v(messagingStruct$PremiumMessage)).j();
        }
        this.traitCase_ = 18;
    }

    private void mergeProtectedMessage(MessagingStruct$ProtectedMessage messagingStruct$ProtectedMessage) {
        messagingStruct$ProtectedMessage.getClass();
        if (this.traitCase_ != 27 || this.trait_ == MessagingStruct$ProtectedMessage.getDefaultInstance()) {
            this.trait_ = messagingStruct$ProtectedMessage;
        } else {
            this.trait_ = ((MessagingStruct$ProtectedMessage.a) MessagingStruct$ProtectedMessage.newBuilder((MessagingStruct$ProtectedMessage) this.trait_).v(messagingStruct$ProtectedMessage)).j();
        }
        this.traitCase_ = 27;
    }

    private void mergePurchaseMessage(MessagingStruct$PurchaseMessage messagingStruct$PurchaseMessage) {
        messagingStruct$PurchaseMessage.getClass();
        if (this.traitCase_ != 10 || this.trait_ == MessagingStruct$PurchaseMessage.getDefaultInstance()) {
            this.trait_ = messagingStruct$PurchaseMessage;
        } else {
            this.trait_ = ((MessagingStruct$PurchaseMessage.a) MessagingStruct$PurchaseMessage.newBuilder((MessagingStruct$PurchaseMessage) this.trait_).v(messagingStruct$PurchaseMessage)).j();
        }
        this.traitCase_ = 10;
    }

    private void mergeServiceMessage(MessagingStruct$ServiceMessage messagingStruct$ServiceMessage) {
        messagingStruct$ServiceMessage.getClass();
        if (this.traitCase_ != 11 || this.trait_ == MessagingStruct$ServiceMessage.getDefaultInstance()) {
            this.trait_ = messagingStruct$ServiceMessage;
        } else {
            this.trait_ = ((MessagingStruct$ServiceMessage.a) MessagingStruct$ServiceMessage.newBuilder((MessagingStruct$ServiceMessage) this.trait_).v(messagingStruct$ServiceMessage)).j();
        }
        this.traitCase_ = 11;
    }

    private void mergeStickerMessage(MessagingStruct$StickerMessage messagingStruct$StickerMessage) {
        messagingStruct$StickerMessage.getClass();
        if (this.traitCase_ != 12 || this.trait_ == MessagingStruct$StickerMessage.getDefaultInstance()) {
            this.trait_ = messagingStruct$StickerMessage;
        } else {
            this.trait_ = ((MessagingStruct$StickerMessage.a) MessagingStruct$StickerMessage.newBuilder((MessagingStruct$StickerMessage) this.trait_).v(messagingStruct$StickerMessage)).j();
        }
        this.traitCase_ = 12;
    }

    private void mergeStory(MessagingStruct$StoryReference messagingStruct$StoryReference) {
        messagingStruct$StoryReference.getClass();
        if (this.traitCase_ != 100 || this.trait_ == MessagingStruct$StoryReference.getDefaultInstance()) {
            this.trait_ = messagingStruct$StoryReference;
        } else {
            this.trait_ = ((MessagingStruct$StoryReference.a) MessagingStruct$StoryReference.newBuilder((MessagingStruct$StoryReference) this.trait_).v(messagingStruct$StoryReference)).j();
        }
        this.traitCase_ = 100;
    }

    private void mergeTemplateMessage(MessagingStruct$TemplateMessage messagingStruct$TemplateMessage) {
        messagingStruct$TemplateMessage.getClass();
        if (this.traitCase_ != 13 || this.trait_ == MessagingStruct$TemplateMessage.getDefaultInstance()) {
            this.trait_ = messagingStruct$TemplateMessage;
        } else {
            this.trait_ = ((MessagingStruct$TemplateMessage.a) MessagingStruct$TemplateMessage.newBuilder((MessagingStruct$TemplateMessage) this.trait_).v(messagingStruct$TemplateMessage)).j();
        }
        this.traitCase_ = 13;
    }

    private void mergeTemplateMessageResponse(MessagingStruct$TemplateMessageResponse messagingStruct$TemplateMessageResponse) {
        messagingStruct$TemplateMessageResponse.getClass();
        if (this.traitCase_ != 14 || this.trait_ == MessagingStruct$TemplateMessageResponse.getDefaultInstance()) {
            this.trait_ = messagingStruct$TemplateMessageResponse;
        } else {
            this.trait_ = ((MessagingStruct$TemplateMessageResponse.a) MessagingStruct$TemplateMessageResponse.newBuilder((MessagingStruct$TemplateMessageResponse) this.trait_).v(messagingStruct$TemplateMessageResponse)).j();
        }
        this.traitCase_ = 14;
    }

    private void mergeTextMessage(MessagingStruct$TextMessage messagingStruct$TextMessage) {
        messagingStruct$TextMessage.getClass();
        if (this.traitCase_ != 15 || this.trait_ == MessagingStruct$TextMessage.getDefaultInstance()) {
            this.trait_ = messagingStruct$TextMessage;
        } else {
            this.trait_ = ((MessagingStruct$TextMessage.a) MessagingStruct$TextMessage.newBuilder((MessagingStruct$TextMessage) this.trait_).v(messagingStruct$TextMessage)).j();
        }
        this.traitCase_ = 15;
    }

    private void mergeUnsupportedMessage(MessagingStruct$UnsupportedMessage messagingStruct$UnsupportedMessage) {
        messagingStruct$UnsupportedMessage.getClass();
        if (this.traitCase_ != 16 || this.trait_ == MessagingStruct$UnsupportedMessage.getDefaultInstance()) {
            this.trait_ = messagingStruct$UnsupportedMessage;
        } else {
            this.trait_ = ((MessagingStruct$UnsupportedMessage.a) MessagingStruct$UnsupportedMessage.newBuilder((MessagingStruct$UnsupportedMessage) this.trait_).v(messagingStruct$UnsupportedMessage)).j();
        }
        this.traitCase_ = 16;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$Message parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$Message) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$Message parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAdvertisementMessage(MessagingStruct$AdvertisementMessage messagingStruct$AdvertisementMessage) {
        messagingStruct$AdvertisementMessage.getClass();
        this.trait_ = messagingStruct$AdvertisementMessage;
        this.traitCase_ = 21;
    }

    private void setAnimatedStickerMessage(MessagingStruct$AnimatedStickerMessage messagingStruct$AnimatedStickerMessage) {
        messagingStruct$AnimatedStickerMessage.getClass();
        this.trait_ = messagingStruct$AnimatedStickerMessage;
        this.traitCase_ = 24;
    }

    private void setBankMessage(MessagingStruct$BankMessage messagingStruct$BankMessage) {
        messagingStruct$BankMessage.getClass();
        this.trait_ = messagingStruct$BankMessage;
        this.traitCase_ = 1;
    }

    private void setBannedMessage(MessagingStruct$BannedMessage messagingStruct$BannedMessage) {
        messagingStruct$BannedMessage.getClass();
        this.trait_ = messagingStruct$BannedMessage;
        this.traitCase_ = 25;
    }

    private void setBinaryMessage(MessagingStruct$BinaryMessage messagingStruct$BinaryMessage) {
        messagingStruct$BinaryMessage.getClass();
        this.trait_ = messagingStruct$BinaryMessage;
        this.traitCase_ = 2;
    }

    private void setBoughtPremiumMessage(MessagingStruct$BoughtPremiumMessage messagingStruct$BoughtPremiumMessage) {
        messagingStruct$BoughtPremiumMessage.getClass();
        this.trait_ = messagingStruct$BoughtPremiumMessage;
        this.traitCase_ = 20;
    }

    private void setCrowdFundingMessage(MessagingStruct$CrowdFundingMessage messagingStruct$CrowdFundingMessage) {
        messagingStruct$CrowdFundingMessage.getClass();
        this.trait_ = messagingStruct$CrowdFundingMessage;
        this.traitCase_ = 23;
    }

    private void setDeletedMessage(MessagingStruct$DeletedMessage messagingStruct$DeletedMessage) {
        messagingStruct$DeletedMessage.getClass();
        this.trait_ = messagingStruct$DeletedMessage;
        this.traitCase_ = 3;
    }

    private void setDocumentMessage(MessagingStruct$DocumentMessage messagingStruct$DocumentMessage) {
        messagingStruct$DocumentMessage.getClass();
        this.trait_ = messagingStruct$DocumentMessage;
        this.traitCase_ = 4;
    }

    private void setEmptyMessage(MessagingStruct$EmptyMessage messagingStruct$EmptyMessage) {
        messagingStruct$EmptyMessage.getClass();
        this.trait_ = messagingStruct$EmptyMessage;
        this.traitCase_ = 5;
    }

    private void setGiftPacketMessage(MessagingStruct$GiftPacketMessage messagingStruct$GiftPacketMessage) {
        messagingStruct$GiftPacketMessage.getClass();
        this.trait_ = messagingStruct$GiftPacketMessage;
        this.traitCase_ = 17;
    }

    private void setGoldGiftPacketMessage(MessagingStruct$GoldGiftPacketMessage messagingStruct$GoldGiftPacketMessage) {
        messagingStruct$GoldGiftPacketMessage.getClass();
        this.trait_ = messagingStruct$GoldGiftPacketMessage;
        this.traitCase_ = 28;
    }

    private void setJsonMessage(MessagingStruct$JsonMessage messagingStruct$JsonMessage) {
        messagingStruct$JsonMessage.getClass();
        this.trait_ = messagingStruct$JsonMessage;
        this.traitCase_ = 7;
    }

    private void setLiveMessage(MessagingStruct$LiveMessage messagingStruct$LiveMessage) {
        messagingStruct$LiveMessage.getClass();
        this.trait_ = messagingStruct$LiveMessage;
        this.traitCase_ = 26;
    }

    private void setNasimEncryptedMessage(MessagingStruct$NasimEncryptedMessage messagingStruct$NasimEncryptedMessage) {
        messagingStruct$NasimEncryptedMessage.getClass();
        this.trait_ = messagingStruct$NasimEncryptedMessage;
        this.traitCase_ = 8;
    }

    private void setNewPremiumMessage(MessagingStruct$NewPremiumMessage messagingStruct$NewPremiumMessage) {
        messagingStruct$NewPremiumMessage.getClass();
        this.trait_ = messagingStruct$NewPremiumMessage;
        this.traitCase_ = 19;
    }

    private void setOrderMessage(MessagingStruct$OrderMessage messagingStruct$OrderMessage) {
        messagingStruct$OrderMessage.getClass();
        this.trait_ = messagingStruct$OrderMessage;
        this.traitCase_ = 9;
    }

    private void setPollMessage(MessagingStruct$PollMessage messagingStruct$PollMessage) {
        messagingStruct$PollMessage.getClass();
        this.trait_ = messagingStruct$PollMessage;
        this.traitCase_ = 29;
    }

    private void setPremiumMessage(MessagingStruct$PremiumMessage messagingStruct$PremiumMessage) {
        messagingStruct$PremiumMessage.getClass();
        this.trait_ = messagingStruct$PremiumMessage;
        this.traitCase_ = 18;
    }

    private void setProtectedMessage(MessagingStruct$ProtectedMessage messagingStruct$ProtectedMessage) {
        messagingStruct$ProtectedMessage.getClass();
        this.trait_ = messagingStruct$ProtectedMessage;
        this.traitCase_ = 27;
    }

    private void setPurchaseMessage(MessagingStruct$PurchaseMessage messagingStruct$PurchaseMessage) {
        messagingStruct$PurchaseMessage.getClass();
        this.trait_ = messagingStruct$PurchaseMessage;
        this.traitCase_ = 10;
    }

    private void setServiceMessage(MessagingStruct$ServiceMessage messagingStruct$ServiceMessage) {
        messagingStruct$ServiceMessage.getClass();
        this.trait_ = messagingStruct$ServiceMessage;
        this.traitCase_ = 11;
    }

    private void setStickerMessage(MessagingStruct$StickerMessage messagingStruct$StickerMessage) {
        messagingStruct$StickerMessage.getClass();
        this.trait_ = messagingStruct$StickerMessage;
        this.traitCase_ = 12;
    }

    private void setStory(MessagingStruct$StoryReference messagingStruct$StoryReference) {
        messagingStruct$StoryReference.getClass();
        this.trait_ = messagingStruct$StoryReference;
        this.traitCase_ = 100;
    }

    private void setTemplateMessage(MessagingStruct$TemplateMessage messagingStruct$TemplateMessage) {
        messagingStruct$TemplateMessage.getClass();
        this.trait_ = messagingStruct$TemplateMessage;
        this.traitCase_ = 13;
    }

    private void setTemplateMessageResponse(MessagingStruct$TemplateMessageResponse messagingStruct$TemplateMessageResponse) {
        messagingStruct$TemplateMessageResponse.getClass();
        this.trait_ = messagingStruct$TemplateMessageResponse;
        this.traitCase_ = 14;
    }

    private void setTextMessage(MessagingStruct$TextMessage messagingStruct$TextMessage) {
        messagingStruct$TextMessage.getClass();
        this.trait_ = messagingStruct$TextMessage;
        this.traitCase_ = 15;
    }

    private void setUnsupportedMessage(MessagingStruct$UnsupportedMessage messagingStruct$UnsupportedMessage) {
        messagingStruct$UnsupportedMessage.getClass();
        this.trait_ = messagingStruct$UnsupportedMessage;
        this.traitCase_ = 16;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$Message();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u001c\u0001\u0000\u0001d\u001c\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0007<\u0000\b<\u0000\t<\u0000\n<\u0000\u000b<\u0000\f<\u0000\r<\u0000\u000e<\u0000\u000f<\u0000\u0010<\u0000\u0011<\u0000\u0012<\u0000\u0013<\u0000\u0014<\u0000\u0015<\u0000\u0017<\u0000\u0018<\u0000\u0019<\u0000\u001a<\u0000\u001b<\u0000\u001c<\u0000\u001d<\u0000d<\u0000", new Object[]{"trait_", "traitCase_", MessagingStruct$BankMessage.class, MessagingStruct$BinaryMessage.class, MessagingStruct$DeletedMessage.class, MessagingStruct$DocumentMessage.class, MessagingStruct$EmptyMessage.class, MessagingStruct$JsonMessage.class, MessagingStruct$NasimEncryptedMessage.class, MessagingStruct$OrderMessage.class, MessagingStruct$PurchaseMessage.class, MessagingStruct$ServiceMessage.class, MessagingStruct$StickerMessage.class, MessagingStruct$TemplateMessage.class, MessagingStruct$TemplateMessageResponse.class, MessagingStruct$TextMessage.class, MessagingStruct$UnsupportedMessage.class, MessagingStruct$GiftPacketMessage.class, MessagingStruct$PremiumMessage.class, MessagingStruct$NewPremiumMessage.class, MessagingStruct$BoughtPremiumMessage.class, MessagingStruct$AdvertisementMessage.class, MessagingStruct$CrowdFundingMessage.class, MessagingStruct$AnimatedStickerMessage.class, MessagingStruct$BannedMessage.class, MessagingStruct$LiveMessage.class, MessagingStruct$ProtectedMessage.class, MessagingStruct$GoldGiftPacketMessage.class, MessagingStruct$PollMessage.class, MessagingStruct$StoryReference.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$Message.class) {
                        try {
                            cVar = PARSER;
                            if (cVar == null) {
                                cVar = new GeneratedMessageLite.c(DEFAULT_INSTANCE);
                                PARSER = cVar;
                            }
                        } finally {
                        }
                    }
                }
                return cVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public MessagingStruct$AdvertisementMessage getAdvertisementMessage() {
        return this.traitCase_ == 21 ? (MessagingStruct$AdvertisementMessage) this.trait_ : MessagingStruct$AdvertisementMessage.getDefaultInstance();
    }

    public MessagingStruct$AnimatedStickerMessage getAnimatedStickerMessage() {
        return this.traitCase_ == 24 ? (MessagingStruct$AnimatedStickerMessage) this.trait_ : MessagingStruct$AnimatedStickerMessage.getDefaultInstance();
    }

    public MessagingStruct$BankMessage getBankMessage() {
        return this.traitCase_ == 1 ? (MessagingStruct$BankMessage) this.trait_ : MessagingStruct$BankMessage.getDefaultInstance();
    }

    public MessagingStruct$BannedMessage getBannedMessage() {
        return this.traitCase_ == 25 ? (MessagingStruct$BannedMessage) this.trait_ : MessagingStruct$BannedMessage.getDefaultInstance();
    }

    public MessagingStruct$BinaryMessage getBinaryMessage() {
        return this.traitCase_ == 2 ? (MessagingStruct$BinaryMessage) this.trait_ : MessagingStruct$BinaryMessage.getDefaultInstance();
    }

    public MessagingStruct$BoughtPremiumMessage getBoughtPremiumMessage() {
        return this.traitCase_ == 20 ? (MessagingStruct$BoughtPremiumMessage) this.trait_ : MessagingStruct$BoughtPremiumMessage.getDefaultInstance();
    }

    public MessagingStruct$CrowdFundingMessage getCrowdFundingMessage() {
        return this.traitCase_ == 23 ? (MessagingStruct$CrowdFundingMessage) this.trait_ : MessagingStruct$CrowdFundingMessage.getDefaultInstance();
    }

    public MessagingStruct$DeletedMessage getDeletedMessage() {
        return this.traitCase_ == 3 ? (MessagingStruct$DeletedMessage) this.trait_ : MessagingStruct$DeletedMessage.getDefaultInstance();
    }

    public MessagingStruct$DocumentMessage getDocumentMessage() {
        return this.traitCase_ == 4 ? (MessagingStruct$DocumentMessage) this.trait_ : MessagingStruct$DocumentMessage.getDefaultInstance();
    }

    public MessagingStruct$EmptyMessage getEmptyMessage() {
        return this.traitCase_ == 5 ? (MessagingStruct$EmptyMessage) this.trait_ : MessagingStruct$EmptyMessage.getDefaultInstance();
    }

    public MessagingStruct$GiftPacketMessage getGiftPacketMessage() {
        return this.traitCase_ == 17 ? (MessagingStruct$GiftPacketMessage) this.trait_ : MessagingStruct$GiftPacketMessage.getDefaultInstance();
    }

    public MessagingStruct$GoldGiftPacketMessage getGoldGiftPacketMessage() {
        return this.traitCase_ == 28 ? (MessagingStruct$GoldGiftPacketMessage) this.trait_ : MessagingStruct$GoldGiftPacketMessage.getDefaultInstance();
    }

    public MessagingStruct$JsonMessage getJsonMessage() {
        return this.traitCase_ == 7 ? (MessagingStruct$JsonMessage) this.trait_ : MessagingStruct$JsonMessage.getDefaultInstance();
    }

    public MessagingStruct$LiveMessage getLiveMessage() {
        return this.traitCase_ == 26 ? (MessagingStruct$LiveMessage) this.trait_ : MessagingStruct$LiveMessage.getDefaultInstance();
    }

    public MessagingStruct$NasimEncryptedMessage getNasimEncryptedMessage() {
        return this.traitCase_ == 8 ? (MessagingStruct$NasimEncryptedMessage) this.trait_ : MessagingStruct$NasimEncryptedMessage.getDefaultInstance();
    }

    public MessagingStruct$NewPremiumMessage getNewPremiumMessage() {
        return this.traitCase_ == 19 ? (MessagingStruct$NewPremiumMessage) this.trait_ : MessagingStruct$NewPremiumMessage.getDefaultInstance();
    }

    public MessagingStruct$OrderMessage getOrderMessage() {
        return this.traitCase_ == 9 ? (MessagingStruct$OrderMessage) this.trait_ : MessagingStruct$OrderMessage.getDefaultInstance();
    }

    public MessagingStruct$PollMessage getPollMessage() {
        return this.traitCase_ == 29 ? (MessagingStruct$PollMessage) this.trait_ : MessagingStruct$PollMessage.getDefaultInstance();
    }

    public MessagingStruct$PremiumMessage getPremiumMessage() {
        return this.traitCase_ == 18 ? (MessagingStruct$PremiumMessage) this.trait_ : MessagingStruct$PremiumMessage.getDefaultInstance();
    }

    public MessagingStruct$ProtectedMessage getProtectedMessage() {
        return this.traitCase_ == 27 ? (MessagingStruct$ProtectedMessage) this.trait_ : MessagingStruct$ProtectedMessage.getDefaultInstance();
    }

    public MessagingStruct$PurchaseMessage getPurchaseMessage() {
        return this.traitCase_ == 10 ? (MessagingStruct$PurchaseMessage) this.trait_ : MessagingStruct$PurchaseMessage.getDefaultInstance();
    }

    public MessagingStruct$ServiceMessage getServiceMessage() {
        return this.traitCase_ == 11 ? (MessagingStruct$ServiceMessage) this.trait_ : MessagingStruct$ServiceMessage.getDefaultInstance();
    }

    public MessagingStruct$StickerMessage getStickerMessage() {
        return this.traitCase_ == 12 ? (MessagingStruct$StickerMessage) this.trait_ : MessagingStruct$StickerMessage.getDefaultInstance();
    }

    public MessagingStruct$StoryReference getStory() {
        return this.traitCase_ == 100 ? (MessagingStruct$StoryReference) this.trait_ : MessagingStruct$StoryReference.getDefaultInstance();
    }

    public MessagingStruct$TemplateMessage getTemplateMessage() {
        return this.traitCase_ == 13 ? (MessagingStruct$TemplateMessage) this.trait_ : MessagingStruct$TemplateMessage.getDefaultInstance();
    }

    public MessagingStruct$TemplateMessageResponse getTemplateMessageResponse() {
        return this.traitCase_ == 14 ? (MessagingStruct$TemplateMessageResponse) this.trait_ : MessagingStruct$TemplateMessageResponse.getDefaultInstance();
    }

    public MessagingStruct$TextMessage getTextMessage() {
        return this.traitCase_ == 15 ? (MessagingStruct$TextMessage) this.trait_ : MessagingStruct$TextMessage.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public MessagingStruct$UnsupportedMessage getUnsupportedMessage() {
        return this.traitCase_ == 16 ? (MessagingStruct$UnsupportedMessage) this.trait_ : MessagingStruct$UnsupportedMessage.getDefaultInstance();
    }

    public boolean hasAdvertisementMessage() {
        return this.traitCase_ == 21;
    }

    public boolean hasAnimatedStickerMessage() {
        return this.traitCase_ == 24;
    }

    public boolean hasBankMessage() {
        return this.traitCase_ == 1;
    }

    public boolean hasBannedMessage() {
        return this.traitCase_ == 25;
    }

    public boolean hasBinaryMessage() {
        return this.traitCase_ == 2;
    }

    public boolean hasBoughtPremiumMessage() {
        return this.traitCase_ == 20;
    }

    public boolean hasCrowdFundingMessage() {
        return this.traitCase_ == 23;
    }

    public boolean hasDeletedMessage() {
        return this.traitCase_ == 3;
    }

    public boolean hasDocumentMessage() {
        return this.traitCase_ == 4;
    }

    public boolean hasEmptyMessage() {
        return this.traitCase_ == 5;
    }

    public boolean hasGiftPacketMessage() {
        return this.traitCase_ == 17;
    }

    public boolean hasGoldGiftPacketMessage() {
        return this.traitCase_ == 28;
    }

    public boolean hasJsonMessage() {
        return this.traitCase_ == 7;
    }

    public boolean hasLiveMessage() {
        return this.traitCase_ == 26;
    }

    public boolean hasNasimEncryptedMessage() {
        return this.traitCase_ == 8;
    }

    public boolean hasNewPremiumMessage() {
        return this.traitCase_ == 19;
    }

    public boolean hasOrderMessage() {
        return this.traitCase_ == 9;
    }

    public boolean hasPollMessage() {
        return this.traitCase_ == 29;
    }

    public boolean hasPremiumMessage() {
        return this.traitCase_ == 18;
    }

    public boolean hasProtectedMessage() {
        return this.traitCase_ == 27;
    }

    public boolean hasPurchaseMessage() {
        return this.traitCase_ == 10;
    }

    public boolean hasServiceMessage() {
        return this.traitCase_ == 11;
    }

    public boolean hasStickerMessage() {
        return this.traitCase_ == 12;
    }

    public boolean hasStory() {
        return this.traitCase_ == 100;
    }

    public boolean hasTemplateMessage() {
        return this.traitCase_ == 13;
    }

    public boolean hasTemplateMessageResponse() {
        return this.traitCase_ == 14;
    }

    public boolean hasTextMessage() {
        return this.traitCase_ == 15;
    }

    public boolean hasUnsupportedMessage() {
        return this.traitCase_ == 16;
    }

    public static a newBuilder(MessagingStruct$Message messagingStruct$Message) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$Message);
    }

    public static MessagingStruct$Message parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$Message) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$Message parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$Message parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$Message parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$Message parseFrom(byte[] bArr) {
        return (MessagingStruct$Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$Message parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$Message parseFrom(InputStream inputStream) {
        return (MessagingStruct$Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$Message parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$Message parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$Message parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$Message) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
