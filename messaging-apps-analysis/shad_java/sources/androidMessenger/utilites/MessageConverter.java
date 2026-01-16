package androidMessenger.utilites;

import android.text.TextUtils;
import android.util.Base64;
import android.webkit.MimeTypeMap;
import androidMessenger.ServiceLocator;
import androidMessenger.model.ExtraInfo;
import androidMessenger.proxy.CallProxy$$ExternalSyntheticBackport0;
import androidMessenger.proxy.IdStorage;
import androidMessenger.proxy.MessageProxy$32$$ExternalSyntheticBackport0;
import androidx.collection.LongSparseArray;
import com.facebook.stetho.websocket.CloseCodes;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.CoreMainClass;
import ir.aaap.messengercore.exceptions.InvalidInputException;
import ir.aaap.messengercore.model.AvatarFileInline;
import ir.aaap.messengercore.model.AvatarObject;
import ir.aaap.messengercore.model.Chat;
import ir.aaap.messengercore.model.ChatAbsObject;
import ir.aaap.messengercore.model.ChatMessage;
import ir.aaap.messengercore.model.ChatType;
import ir.aaap.messengercore.model.ContactMessageObject;
import ir.aaap.messengercore.model.FileInlineObject;
import ir.aaap.messengercore.model.KeyPadObject;
import ir.aaap.messengercore.model.KeyboardButton;
import ir.aaap.messengercore.model.KeypadRow;
import ir.aaap.messengercore.model.LiveLocationInfo;
import ir.aaap.messengercore.model.LiveLocationObject;
import ir.aaap.messengercore.model.LiveModels;
import ir.aaap.messengercore.model.LocationObject;
import ir.aaap.messengercore.model.Message;
import ir.aaap.messengercore.model.MessageCallData;
import ir.aaap.messengercore.model.MessageReactionObject;
import ir.aaap.messengercore.model.MetaDataObject;
import ir.aaap.messengercore.model.MetaDataPartObject;
import ir.aaap.messengercore.model.NotificationModels;
import ir.aaap.messengercore.model.ObjectGuidType;
import ir.aaap.messengercore.model.PollObject;
import ir.aaap.messengercore.model.PollStatusObject;
import ir.aaap.messengercore.model.ProductMessageData;
import ir.aaap.messengercore.model.SendChatActivityInput;
import ir.aaap.messengercore.model.ShowActivityObject;
import ir.aaap.messengercore.model.StickerObject;
import ir.aaap.messengercore.model.StickerSetObject;
import ir.aaap.messengercore.model.UserInfo;
import ir.aaap.messengercore.model.UserReactionObject;
import ir.aaap.messengercore.model.VoiceCallModels;
import ir.aaap.messengercore.model.WalletTransferDataObject;
import ir.aaap.messengercore.model.WalletTransferMessageObject;
import ir.aaap.messengercore.model.api.GetStickersOutput;
import ir.aaap.messengercore.model.api.InSearchMessage;
import ir.aaap.messengercore.model.api.SearchGlobalMessagesOutput;
import ir.appp.rghapp.Utils;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.FirebaseEventSender;
import ir.resaneh1.iptv.model.Link;
import ir.resaneh1.iptv.model.RubinoPostData;
import ir.resaneh1.iptv.model.RubinoStoryData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.LocationController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.Utilities;
import org.rbmain.tgnet.SerializedData;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$DocumentAttribute;
import org.rbmain.tgnet.TLRPC$FileLocation;
import org.rbmain.tgnet.TLRPC$GeoPoint;
import org.rbmain.tgnet.TLRPC$InputGeoPoint;
import org.rbmain.tgnet.TLRPC$KeyboardButton;
import org.rbmain.tgnet.TLRPC$Message;
import org.rbmain.tgnet.TLRPC$MessageAction;
import org.rbmain.tgnet.TLRPC$MessageEntity;
import org.rbmain.tgnet.TLRPC$MessageFwdHeader;
import org.rbmain.tgnet.TLRPC$MessageMedia;
import org.rbmain.tgnet.TLRPC$MessagePeerReaction;
import org.rbmain.tgnet.TLRPC$Peer;
import org.rbmain.tgnet.TLRPC$PhoneCallDiscardReason;
import org.rbmain.tgnet.TLRPC$Photo;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.tgnet.TLRPC$Poll;
import org.rbmain.tgnet.TLRPC$PollResults;
import org.rbmain.tgnet.TLRPC$ReplyMarkup;
import org.rbmain.tgnet.TLRPC$SendMessageAction;
import org.rbmain.tgnet.TLRPC$StickerSet;
import org.rbmain.tgnet.TLRPC$StickerSetCovered;
import org.rbmain.tgnet.TLRPC$TL_channel;
import org.rbmain.tgnet.TLRPC$TL_document;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeAnimated;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeAudio;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeFilename;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeImageSize;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeSticker;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeVideo;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeVideoFile;
import org.rbmain.tgnet.TLRPC$TL_fileLocationToBeDeprecated;
import org.rbmain.tgnet.TLRPC$TL_geoPoint;
import org.rbmain.tgnet.TLRPC$TL_inputMessageEntityMentionName;
import org.rbmain.tgnet.TLRPC$TL_inputStickerSetID;
import org.rbmain.tgnet.TLRPC$TL_inputUser;
import org.rbmain.tgnet.TLRPC$TL_keyboardButton;
import org.rbmain.tgnet.TLRPC$TL_keyboardButtonCallback;
import org.rbmain.tgnet.TLRPC$TL_keyboardButtonRow;
import org.rbmain.tgnet.TLRPC$TL_live;
import org.rbmain.tgnet.TLRPC$TL_message;
import org.rbmain.tgnet.TLRPC$TL_messageActionChannelCreate;
import org.rbmain.tgnet.TLRPC$TL_messageActionChatAddUser;
import org.rbmain.tgnet.TLRPC$TL_messageActionChatCreate;
import org.rbmain.tgnet.TLRPC$TL_messageActionChatDeletePhoto;
import org.rbmain.tgnet.TLRPC$TL_messageActionChatDeleteUser;
import org.rbmain.tgnet.TLRPC$TL_messageActionChatEditPhoto;
import org.rbmain.tgnet.TLRPC$TL_messageActionChatEditTitle;
import org.rbmain.tgnet.TLRPC$TL_messageActionChatJoinedByLink;
import org.rbmain.tgnet.TLRPC$TL_messageActionCustomAction;
import org.rbmain.tgnet.TLRPC$TL_messageActionGroupCall;
import org.rbmain.tgnet.TLRPC$TL_messageActionPhoneCall;
import org.rbmain.tgnet.TLRPC$TL_messageActionPinMessage;
import org.rbmain.tgnet.TLRPC$TL_messageEntityBold;
import org.rbmain.tgnet.TLRPC$TL_messageEntityCode;
import org.rbmain.tgnet.TLRPC$TL_messageEntityItalic;
import org.rbmain.tgnet.TLRPC$TL_messageEntityPre;
import org.rbmain.tgnet.TLRPC$TL_messageEntitySpoiler;
import org.rbmain.tgnet.TLRPC$TL_messageEntityStrike;
import org.rbmain.tgnet.TLRPC$TL_messageEntityTextUrl;
import org.rbmain.tgnet.TLRPC$TL_messageEntityUnderline;
import org.rbmain.tgnet.TLRPC$TL_messageEntityUnknown;
import org.rbmain.tgnet.TLRPC$TL_messageFwdHeader;
import org.rbmain.tgnet.TLRPC$TL_messageMediaContact;
import org.rbmain.tgnet.TLRPC$TL_messageMediaDocument;
import org.rbmain.tgnet.TLRPC$TL_messageMediaEmpty;
import org.rbmain.tgnet.TLRPC$TL_messageMediaGeo;
import org.rbmain.tgnet.TLRPC$TL_messageMediaGeoLive;
import org.rbmain.tgnet.TLRPC$TL_messageMediaPhoto;
import org.rbmain.tgnet.TLRPC$TL_messageMediaPoll;
import org.rbmain.tgnet.TLRPC$TL_messageMediaRubinoPost;
import org.rbmain.tgnet.TLRPC$TL_messageMediaRubinoProduct;
import org.rbmain.tgnet.TLRPC$TL_messageMediaRubinoStory;
import org.rbmain.tgnet.TLRPC$TL_messageMediaUnsupported;
import org.rbmain.tgnet.TLRPC$TL_messageMediaWallet;
import org.rbmain.tgnet.TLRPC$TL_messagePeerReaction;
import org.rbmain.tgnet.TLRPC$TL_messageReactions;
import org.rbmain.tgnet.TLRPC$TL_messageReplyHeader;
import org.rbmain.tgnet.TLRPC$TL_messageService;
import org.rbmain.tgnet.TLRPC$TL_messages_archivedStickers;
import org.rbmain.tgnet.TLRPC$TL_messages_channelMessages;
import org.rbmain.tgnet.TLRPC$TL_messages_featuredStickers;
import org.rbmain.tgnet.TLRPC$TL_messages_foundStickerSets;
import org.rbmain.tgnet.TLRPC$TL_messages_messages;
import org.rbmain.tgnet.TLRPC$TL_messages_stickerSet;
import org.rbmain.tgnet.TLRPC$TL_peerChannel;
import org.rbmain.tgnet.TLRPC$TL_peerUser;
import org.rbmain.tgnet.TLRPC$TL_phoneCallDiscardReasonBusy;
import org.rbmain.tgnet.TLRPC$TL_phoneCallDiscardReasonDisconnect;
import org.rbmain.tgnet.TLRPC$TL_phoneCallDiscardReasonHangup;
import org.rbmain.tgnet.TLRPC$TL_phoneCallDiscardReasonMissed;
import org.rbmain.tgnet.TLRPC$TL_photo;
import org.rbmain.tgnet.TLRPC$TL_photoEmpty;
import org.rbmain.tgnet.TLRPC$TL_photoPathSize;
import org.rbmain.tgnet.TLRPC$TL_photoSize;
import org.rbmain.tgnet.TLRPC$TL_photoSizeProgressive;
import org.rbmain.tgnet.TLRPC$TL_photoStrippedSize;
import org.rbmain.tgnet.TLRPC$TL_photos_photos;
import org.rbmain.tgnet.TLRPC$TL_poll;
import org.rbmain.tgnet.TLRPC$TL_pollAnswer;
import org.rbmain.tgnet.TLRPC$TL_pollAnswerVoters;
import org.rbmain.tgnet.TLRPC$TL_pollResults;
import org.rbmain.tgnet.TLRPC$TL_reactionCount;
import org.rbmain.tgnet.TLRPC$TL_reactionEmoji;
import org.rbmain.tgnet.TLRPC$TL_replyInlineMarkup;
import org.rbmain.tgnet.TLRPC$TL_replyKeyboardMarkup;
import org.rbmain.tgnet.TLRPC$TL_sendMessageRecordAudioAction;
import org.rbmain.tgnet.TLRPC$TL_sendMessageRecordRoundAction;
import org.rbmain.tgnet.TLRPC$TL_sendMessageTypingAction;
import org.rbmain.tgnet.TLRPC$TL_sendMessageUploadAudioAction;
import org.rbmain.tgnet.TLRPC$TL_sendMessageUploadDocumentAction;
import org.rbmain.tgnet.TLRPC$TL_sendMessageUploadPhotoAction;
import org.rbmain.tgnet.TLRPC$TL_sendMessageUploadRoundAction;
import org.rbmain.tgnet.TLRPC$TL_sendMessageUploadVideoAction;
import org.rbmain.tgnet.TLRPC$TL_stickerSet;
import org.rbmain.tgnet.TLRPC$TL_stickerSetCovered;
import org.rbmain.tgnet.TLRPC$TL_updateChannelUserTyping;
import org.rbmain.tgnet.TLRPC$TL_updateUserTyping;
import org.rbmain.tgnet.TLRPC$TL_videoSize;
import org.rbmain.tgnet.TLRPC$Update;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$VideoSize;
import org.rbmain.tgnet.TLRPC$WalletTransferMessage;
import org.rbmain.tgnet.TLRPC$messages_Messages;
import org.rbmain.tgnet.TLRPC$photos_Photos;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes.dex */
public class MessageConverter {
    private static Gson gson;

    public static TLRPC$messages_Messages convertAllMessages(CoreMainClass coreMainClass, long j, boolean z, List<Message> list, ExtraInfo extraInfo) {
        TLRPC$messages_Messages tLRPC$TL_messages_messages;
        ArrayList<TLRPC$Message> arrayList = new ArrayList<>();
        LongSparseArray longSparseArray = new LongSparseArray();
        if (z) {
            tLRPC$TL_messages_messages = new TLRPC$TL_messages_channelMessages();
        } else {
            tLRPC$TL_messages_messages = new TLRPC$TL_messages_messages();
        }
        TLRPC$messages_Messages tLRPC$messages_Messages = tLRPC$TL_messages_messages;
        long j2 = (extraInfo == null || extraInfo.load_type != 2) ? 0L : extraInfo.first_unread;
        for (int i = 0; i < list.size(); i++) {
            Message message = list.get(i);
            if (j2 > 0 && i > 0 && message.message_id == j2) {
                long j3 = list.get(i - 1).message_id;
                if (j3 > 0) {
                    extraInfo.first_unread = j3;
                }
            }
            arrayList.add(convertToTlMessage(coreMainClass, j, z, message, longSparseArray));
        }
        ArrayList<TLRPC$User> arrayList2 = new ArrayList<>();
        for (int i2 = 0; i2 < longSparseArray.size(); i2++) {
            arrayList2.add((TLRPC$User) longSparseArray.valueAt(i2));
        }
        tLRPC$messages_Messages.messages = arrayList;
        tLRPC$messages_Messages.count = arrayList.size();
        tLRPC$messages_Messages.users = arrayList2;
        return tLRPC$messages_Messages;
    }

    public static ArrayList<MessageObject> convertAllToMessageObject(int i, CoreMainClass coreMainClass, long j, boolean z, List<Message> list, ExtraInfo extraInfo) {
        ArrayList<MessageObject> arrayList = new ArrayList<>();
        LongSparseArray longSparseArray = new LongSparseArray();
        long j2 = (extraInfo == null || extraInfo.load_type != 2) ? 0L : extraInfo.first_unread;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Message message = list.get(i2);
            if (j2 > 0 && i2 > 0 && message.message_id == j2) {
                long j3 = list.get(i2 - 1).message_id;
                if (j3 > 0) {
                    extraInfo.first_unread = j3;
                }
            }
            arrayList.add(new MessageObject(i, convertToTlMessage(coreMainClass, j, z, message, longSparseArray), false, false));
        }
        return arrayList;
    }

    public static TLRPC$Message convertMessage(long j, ChatMessage chatMessage, long j2, int i, boolean z) {
        TLRPC$Peer tLRPC$TL_peerUser;
        TLRPC$TL_message tLRPC$TL_message = new TLRPC$TL_message();
        tLRPC$TL_message.id = chatMessage.message_id;
        if (chatMessage.author_type == null) {
            tLRPC$TL_peerUser = new TLRPC$TL_peerChannel();
            tLRPC$TL_peerUser.channel_id = (int) ((-1) * j);
        } else {
            tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
            tLRPC$TL_peerUser.user_id = (int) IdStorage.getInstance().generateDialogId(chatMessage.author_object_guid);
        }
        tLRPC$TL_message.from_id = tLRPC$TL_peerUser;
        tLRPC$TL_message.peer_id = tLRPC$TL_peerUser;
        tLRPC$TL_message.out = chatMessage.is_mine;
        tLRPC$TL_message.date = (int) j2;
        tLRPC$TL_message.message = chatMessage.text;
        tLRPC$TL_message.dialog_id = j;
        tLRPC$TL_message.chatMessageType = chatMessage.type;
        tLRPC$TL_message.author_title = chatMessage.author_title;
        tLRPC$TL_message.entities = convertAllMetaDataToEntities(chatMessage.metadata);
        if (i != -1) {
            tLRPC$TL_message.send_state = i;
        }
        tLRPC$TL_message.unread = z;
        return tLRPC$TL_message;
    }

    public static TLRPC$Message convertToTlMessage(CoreMainClass coreMainClass, long j, boolean z, Message message, LongSparseArray<TLRPC$User> longSparseArray) {
        TLRPC$Message tLRPC$MessageConvertToMessageService;
        Chat chatInstant;
        ArrayList<Long> arrayList;
        Message.MessageTypeEnum messageTypeEnum;
        FileInlineObject fileInlineObject;
        StickerObject stickerObject;
        Message.MessageTypeEnum messageTypeEnum2 = message.type;
        if (messageTypeEnum2 == Message.MessageTypeEnum.Event || messageTypeEnum2 == (messageTypeEnum = Message.MessageTypeEnum.Call)) {
            tLRPC$MessageConvertToMessageService = convertToMessageService(coreMainClass, message, j, z);
        } else {
            tLRPC$MessageConvertToMessageService = new TLRPC$TL_message();
            tLRPC$MessageConvertToMessageService.dialog_id = j;
            boolean z2 = message.is_banned;
            tLRPC$MessageConvertToMessageService.is_ban = z2;
            if (!z2 && (message.is_edited || message.isLocallyEdited)) {
                tLRPC$MessageConvertToMessageService.flags |= 32768;
                tLRPC$MessageConvertToMessageService.edit_hide = false;
            }
            String str = message.text;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            tLRPC$MessageConvertToMessageService.message = str;
            tLRPC$MessageConvertToMessageService.date = (int) message.time;
            tLRPC$MessageConvertToMessageService.post_author = message.author_signature;
            tLRPC$MessageConvertToMessageService.entities = convertAllMetaDataToEntities(message.metadata);
            if (message.via_bot_guid != null) {
                tLRPC$MessageConvertToMessageService.via_bot_id = (int) IdStorage.getInstance().generateDialogId(message.via_bot_guid);
            }
            Message.LocalParametersObject localParametersObject = message.localParametersObject;
            if (localParametersObject != null) {
                tLRPC$MessageConvertToMessageService.attachPath = localParametersObject.attachPath;
                HashMap<String, String> map = new HashMap<>();
                tLRPC$MessageConvertToMessageService.params = map;
                String str2 = message.localParametersObject.videoEditInfo;
                if (str2 != null) {
                    map.put("ve", str2);
                }
                String str3 = message.localParametersObject.originalPath;
                if (str3 != null) {
                    tLRPC$MessageConvertToMessageService.params.put("originalPath", str3);
                }
                Message.LocalParametersObject localParametersObject2 = message.localParametersObject;
                tLRPC$MessageConvertToMessageService.prevMessageId = localParametersObject2.prevMessageId;
                if (!TextUtils.isEmpty(localParametersObject2.fwdObj)) {
                    TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = (TLRPC$MessageFwdHeader) getGson().fromJson(message.localParametersObject.fwdObj, TLRPC$TL_messageFwdHeader.class);
                    tLRPC$MessageConvertToMessageService.fwd_from = tLRPC$MessageFwdHeader;
                    Message.LocalParametersObject localParametersObject3 = message.localParametersObject;
                    tLRPC$MessageConvertToMessageService.fwdFromGuid = localParametersObject3.fwdFromGuid;
                    tLRPC$MessageConvertToMessageService.fwdFromType = localParametersObject3.fwdFromType;
                    tLRPC$MessageConvertToMessageService.fwd_msg_id = localParametersObject3.fwd_msg_id;
                    if (tLRPC$MessageFwdHeader != null) {
                        int i = tLRPC$MessageConvertToMessageService.flags | 4;
                        tLRPC$MessageConvertToMessageService.flags = i;
                        if ((tLRPC$MessageFwdHeader.from_id instanceof TLRPC$TL_peerChannel) && !message.is_banned) {
                            tLRPC$MessageConvertToMessageService.flags = i | 1024;
                        }
                    }
                }
                if (message.localParametersObject.chatType == ChatType.Channel && !message.is_banned && message.count_seen == 0) {
                    tLRPC$MessageConvertToMessageService.flags |= 1024;
                }
            }
            int i2 = message.count_seen;
            if (i2 != 0 && !message.is_banned) {
                tLRPC$MessageConvertToMessageService.flags |= 1024;
                tLRPC$MessageConvertToMessageService.views = i2;
            }
            Message.MessageTypeEnum messageTypeEnum3 = message.type;
            if ((messageTypeEnum3 == Message.MessageTypeEnum.FileInline || messageTypeEnum3 == Message.MessageTypeEnum.FileInlineCaption) && (fileInlineObject = message.file_inline) != null) {
                tLRPC$MessageConvertToMessageService.media = convertToMessageMedia(message, fileInlineObject);
                tLRPC$MessageConvertToMessageService.flags |= 512;
            } else if (messageTypeEnum3 == Message.MessageTypeEnum.Sticker && (stickerObject = message.sticker) != null) {
                tLRPC$MessageConvertToMessageService.media = convertToMessageMedia(message, stickerObject.file);
                tLRPC$MessageConvertToMessageService.flags |= 512;
            } else if (messageTypeEnum3 == Message.MessageTypeEnum.Text) {
                tLRPC$MessageConvertToMessageService.media = new TLRPC$TL_messageMediaEmpty();
            } else if (messageTypeEnum3 == messageTypeEnum) {
                tLRPC$MessageConvertToMessageService.media = new TLRPC$TL_messageMediaUnsupported();
            } else if (messageTypeEnum3 == Message.MessageTypeEnum.ContactMessage) {
                ContactMessageObject contactMessageObject = message.contact_message;
                TLRPC$TL_messageMediaContact tLRPC$TL_messageMediaContact = new TLRPC$TL_messageMediaContact();
                tLRPC$MessageConvertToMessageService.media = tLRPC$TL_messageMediaContact;
                if (contactMessageObject != null) {
                    tLRPC$TL_messageMediaContact.first_name = contactMessageObject.first_name;
                    tLRPC$TL_messageMediaContact.last_name = contactMessageObject.last_name;
                    tLRPC$TL_messageMediaContact.phone_number = contactMessageObject.phone_number;
                    tLRPC$TL_messageMediaContact.vcard = contactMessageObject.vcard;
                    tLRPC$MessageConvertToMessageService.media.user_id = (int) (contactMessageObject.user_guid != null ? IdStorage.getInstance().generateDialogId(contactMessageObject.user_guid) : 0L);
                }
            } else if (messageTypeEnum3 == Message.MessageTypeEnum.Poll2 || messageTypeEnum3 == Message.MessageTypeEnum.Poll) {
                tLRPC$MessageConvertToMessageService.media = convertToTLPoll(tLRPC$MessageConvertToMessageService.params, message.poll);
            } else if (messageTypeEnum3 == Message.MessageTypeEnum.Location) {
                tLRPC$MessageConvertToMessageService.media = convertToTLLocation(message.location);
            } else if (messageTypeEnum3 == Message.MessageTypeEnum.LiveLocation) {
                tLRPC$MessageConvertToMessageService.media = convertToTLLiveLocation(message.live_location);
                tLRPC$MessageConvertToMessageService.edit_date = (int) message.live_location.last_update_time;
            } else if (messageTypeEnum3 == Message.MessageTypeEnum.Live) {
                tLRPC$MessageConvertToMessageService.media = convertToTLLive(message.live_data);
            } else if (messageTypeEnum3 == Message.MessageTypeEnum.RubinoStory) {
                tLRPC$MessageConvertToMessageService.media = convertToTLRubinoStory(message.rubino_story_data);
            } else if (messageTypeEnum3 == Message.MessageTypeEnum.RubinoPost) {
                tLRPC$MessageConvertToMessageService.media = convertToTLRubinoPost(message.rubino_post_data);
            } else if (messageTypeEnum3 == Message.MessageTypeEnum.ProductMessage) {
                tLRPC$MessageConvertToMessageService.media = convertToTLRubinoProduct(message.product_message_data);
            } else if (messageTypeEnum3 == Message.MessageTypeEnum.WalletTransfer) {
                tLRPC$MessageConvertToMessageService.media = convertToTLWallet(message.wallet_transfer_data);
            } else {
                tLRPC$MessageConvertToMessageService.media = new TLRPC$TL_messageMediaUnsupported();
            }
            if (message.reply_to_message_id != 0) {
                Message messageInstant = coreMainClass.getMessageInstant(IdStorage.getInstance().getDialogId(j), message.reply_to_message_id);
                TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
                tLRPC$TL_messageReplyHeader.reply_to_msg_id = message.reply_to_message_id;
                tLRPC$MessageConvertToMessageService.reply_to = tLRPC$TL_messageReplyHeader;
                tLRPC$MessageConvertToMessageService.flags |= 8;
                if (messageInstant != null) {
                    tLRPC$MessageConvertToMessageService.replyMessage = convertToTlMessage(coreMainClass, j, z, messageInstant, null);
                }
            }
            long j2 = message.groupId;
            if (j2 != 0) {
                tLRPC$MessageConvertToMessageService.grouped_id = j2;
            }
            tLRPC$MessageConvertToMessageService.id = message.message_id;
            KeyPadObject keyPadObject = message.inline_keypad;
            if (keyPadObject != null) {
                tLRPC$MessageConvertToMessageService.reply_markup = convertKeyPad(keyPadObject, true);
            }
            if (message.forwarded_from != null) {
                TLRPC$TL_messageFwdHeader tLRPC$TL_messageFwdHeader = new TLRPC$TL_messageFwdHeader();
                tLRPC$MessageConvertToMessageService.fwd_from = tLRPC$TL_messageFwdHeader;
                Message.ForwardFromObject forwardFromObject = message.forwarded_from;
                tLRPC$TL_messageFwdHeader.forwardFromObj = forwardFromObject;
                TLRPC$Peer tLRPC$TL_peerChannel = null;
                String str4 = forwardFromObject.object_guid;
                if (str4 != null && forwardFromObject.type_from == Message.ForwardFromType.User) {
                    tLRPC$TL_peerChannel = new TLRPC$TL_peerUser();
                    tLRPC$TL_peerChannel.user_id = (int) IdStorage.getInstance().generateDialogId(message.forwarded_from.object_guid);
                } else if (str4 != null && forwardFromObject.type_from == Message.ForwardFromType.Channel) {
                    tLRPC$TL_peerChannel = new TLRPC$TL_peerChannel();
                    tLRPC$TL_peerChannel.channel_id = -((int) IdStorage.getInstance().generateNegativeDialogId(message.forwarded_from.object_guid));
                }
                TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader2 = tLRPC$MessageConvertToMessageService.fwd_from;
                Message.ForwardFromObject forwardFromObject2 = message.forwarded_from;
                long j3 = forwardFromObject2.message_id;
                tLRPC$MessageFwdHeader2.channel_post = j3;
                if (j3 != 0) {
                    tLRPC$MessageFwdHeader2.flags |= 4;
                }
                if (message.author_signature != null) {
                    tLRPC$MessageFwdHeader2.flags |= 8;
                }
                tLRPC$MessageFwdHeader2.from_id = tLRPC$TL_peerChannel;
                tLRPC$MessageFwdHeader2.flags |= 1;
                if (tLRPC$TL_peerChannel instanceof TLRPC$TL_peerChannel) {
                    tLRPC$MessageConvertToMessageService.flags |= 1024;
                }
                ChatAbsObject chatAbsObject = forwardFromObject2.forwardAbsObject;
                if (chatAbsObject != null) {
                    tLRPC$MessageFwdHeader2.from_name = chatAbsObject.first_name;
                    tLRPC$MessageFwdHeader2.date = (int) (chatAbsObject.timeStamp / 1000);
                } else {
                    ChatAbsObject absInstant = coreMainClass.getAbsInstant(forwardFromObject2.object_guid);
                    if (absInstant != null) {
                        String str5 = absInstant.first_name;
                        if (str5 != null) {
                            tLRPC$MessageConvertToMessageService.fwd_from.from_name = str5;
                        } else {
                            String str6 = absInstant.title;
                            if (str6 != null) {
                                tLRPC$MessageConvertToMessageService.fwd_from.from_name = str6;
                            }
                        }
                        tLRPC$MessageConvertToMessageService.fwd_from.date = (int) (absInstant.timeStamp / 1000);
                    }
                }
                tLRPC$MessageConvertToMessageService.flags |= 4;
            } else if (message.forwarded_no_link != null) {
                TLRPC$TL_messageFwdHeader tLRPC$TL_messageFwdHeader2 = new TLRPC$TL_messageFwdHeader();
                tLRPC$MessageConvertToMessageService.fwd_from = tLRPC$TL_messageFwdHeader2;
                tLRPC$TL_messageFwdHeader2.from_name = message.forwarded_no_link.from_title;
                int i3 = tLRPC$MessageConvertToMessageService.flags | 4;
                tLRPC$MessageConvertToMessageService.flags = i3;
                tLRPC$MessageConvertToMessageService.flags = i3 | 32;
            }
            tLRPC$MessageConvertToMessageService.send_state = message.sendState;
            long j4 = tLRPC$MessageConvertToMessageService.id;
            if (j4 < 0) {
                tLRPC$MessageConvertToMessageService.local_id = j4;
            }
            Message.LocalParametersObject localParametersObject4 = message.localParametersObject;
            if (localParametersObject4 != null && localParametersObject4.prevText != null) {
                SerializedData serializedData = new SerializedData(true);
                Message.LocalParametersObject localParametersObject5 = message.localParametersObject;
                writePreviousMessageData(tLRPC$MessageConvertToMessageService, serializedData, localParametersObject5.prevText, convertAllMetaDataToEntities(localParametersObject5.prevMetadata));
                SerializedData serializedData2 = new SerializedData(serializedData.length());
                Message.LocalParametersObject localParametersObject6 = message.localParametersObject;
                writePreviousMessageData(tLRPC$MessageConvertToMessageService, serializedData2, localParametersObject6.prevText, convertAllMetaDataToEntities(localParametersObject6.prevMetadata));
                if (tLRPC$MessageConvertToMessageService.params == null) {
                    tLRPC$MessageConvertToMessageService.params = new HashMap<>();
                }
                tLRPC$MessageConvertToMessageService.params.put("prevMedia", Base64.encodeToString(serializedData2.toByteArray(), 0));
                serializedData2.cleanup();
                serializedData.cleanup();
            }
        }
        TLRPC$Message tLRPC$Message = tLRPC$MessageConvertToMessageService;
        if (message.aux_data != null) {
            tLRPC$Message.button_id = IdStorage.getInstance().generateButtonId(message.aux_data.button_id);
        }
        setMessagePeerId(tLRPC$Message, j);
        setMessageFromId(tLRPC$Message, message, j, z, longSparseArray, coreMainClass);
        tLRPC$Message.out = ((long) tLRPC$Message.from_id.user_id) == IdStorage.getInstance().generateDialogId(coreMainClass.getMyGuid()) || message.message_id < 0;
        ArrayList<MessageReactionObject> arrayList2 = message.reactions;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            tLRPC$Message.reactions = convertToTlMessageReactions(coreMainClass, j, message.reactions);
        }
        if (j != 0) {
            Chat chatInstant2 = coreMainClass.getChatInstant(IdStorage.getInstance().getDialogId(j));
            if (j == IdStorage.getInstance().generateDialogId(coreMainClass.getMyGuid())) {
                tLRPC$Message.unread = false;
            } else if (tLRPC$Message.out) {
                tLRPC$Message.unread = chatInstant2 == null || message.message_id > chatInstant2.last_seen_peer_mid;
            } else {
                tLRPC$Message.unread = chatInstant2 == null || message.message_id > chatInstant2.lastSeenMyMid;
            }
        }
        String dialogId = IdStorage.getInstance().getDialogId(j);
        if (dialogId != null && (chatInstant = coreMainClass.getChatInstant(dialogId)) != null && (arrayList = chatInstant.pinned_message_ids) != null && arrayList.size() > 0) {
            Iterator<Long> it = chatInstant.pinned_message_ids.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().longValue() == message.message_id) {
                    tLRPC$Message.pinned = true;
                    tLRPC$Message.flags |= 8;
                    break;
                }
            }
        }
        return tLRPC$Message;
    }

    public static TLRPC$TL_messageReactions convertToTlMessageReactions(CoreMainClass coreMainClass, long j, ArrayList<MessageReactionObject> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        String dialogId = IdStorage.getInstance().getDialogId(j);
        TLRPC$TL_messageReactions tLRPC$TL_messageReactions = new TLRPC$TL_messageReactions();
        int i = 1;
        tLRPC$TL_messageReactions.can_see_list = TextUtils.isEmpty(dialogId) || !coreMainClass.isChannel(dialogId);
        tLRPC$TL_messageReactions.results = new ArrayList<>();
        tLRPC$TL_messageReactions.recent_reactions = new ArrayList<>();
        Iterator<MessageReactionObject> it = arrayList.iterator();
        while (it.hasNext()) {
            MessageReactionObject next = it.next();
            TLRPC$TL_reactionCount tLRPC$TL_reactionCount = new TLRPC$TL_reactionCount();
            tLRPC$TL_reactionCount.count = next.reaction_count;
            TLRPC$TL_reactionEmoji tLRPC$TL_reactionEmoji = new TLRPC$TL_reactionEmoji();
            tLRPC$TL_reactionEmoji.emoticon = next.emoji_char;
            tLRPC$TL_reactionEmoji.reactionId = next.reaction_id;
            tLRPC$TL_reactionCount.reaction = tLRPC$TL_reactionEmoji;
            int i2 = i + 1;
            tLRPC$TL_reactionCount.chosen_order = i;
            ArrayList<String> arrayList2 = next.user_guids;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                Iterator<String> it2 = next.user_guids.iterator();
                while (it2.hasNext()) {
                    String next2 = it2.next();
                    TLRPC$TL_messagePeerReaction tLRPC$TL_messagePeerReaction = new TLRPC$TL_messagePeerReaction();
                    tLRPC$TL_messagePeerReaction.reaction = tLRPC$TL_reactionEmoji;
                    TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                    tLRPC$TL_messagePeerReaction.peer_id = tLRPC$TL_peerUser;
                    tLRPC$TL_peerUser.user_id = (int) IdStorage.getInstance().generateDialogId(next2);
                    tLRPC$TL_messageReactions.recent_reactions.add(tLRPC$TL_messagePeerReaction);
                }
            }
            tLRPC$TL_reactionCount.chosen = next.is_selected;
            tLRPC$TL_messageReactions.results.add(tLRPC$TL_reactionCount);
            i = i2;
        }
        return tLRPC$TL_messageReactions;
    }

    private static TLRPC$MessageMedia convertToTLRubinoStory(LinkedHashMap linkedHashMap) {
        if (linkedHashMap == null) {
            return null;
        }
        RubinoStoryData rubinoStoryData = (RubinoStoryData) Utils.convertMapToObject(linkedHashMap, RubinoStoryData.class);
        TLRPC$TL_messageMediaRubinoStory tLRPC$TL_messageMediaRubinoStory = new TLRPC$TL_messageMediaRubinoStory();
        tLRPC$TL_messageMediaRubinoStory.rubinoStoryData = rubinoStoryData;
        return tLRPC$TL_messageMediaRubinoStory;
    }

    private static TLRPC$MessageMedia convertToTLRubinoPost(LinkedHashMap linkedHashMap) {
        if (linkedHashMap == null) {
            return null;
        }
        RubinoPostData rubinoPostData = (RubinoPostData) Utils.convertMapToObject(linkedHashMap, RubinoPostData.class);
        TLRPC$TL_messageMediaRubinoPost tLRPC$TL_messageMediaRubinoPost = new TLRPC$TL_messageMediaRubinoPost();
        tLRPC$TL_messageMediaRubinoPost.rubinoPostData = rubinoPostData;
        return tLRPC$TL_messageMediaRubinoPost;
    }

    private static TLRPC$MessageMedia convertToTLRubinoProduct(ProductMessageData productMessageData) {
        if (productMessageData == null) {
            return null;
        }
        TLRPC$TL_messageMediaRubinoProduct tLRPC$TL_messageMediaRubinoProduct = new TLRPC$TL_messageMediaRubinoProduct();
        tLRPC$TL_messageMediaRubinoProduct.productMessageData = productMessageData;
        return tLRPC$TL_messageMediaRubinoProduct;
    }

    public static TLRPC$MessageMedia convertToTLWallet(WalletTransferDataObject walletTransferDataObject) {
        if (walletTransferDataObject == null) {
            return null;
        }
        TLRPC$TL_messageMediaWallet tLRPC$TL_messageMediaWallet = new TLRPC$TL_messageMediaWallet();
        tLRPC$TL_messageMediaWallet.wallet_transfer_data = walletTransferDataObject;
        return tLRPC$TL_messageMediaWallet;
    }

    private static TLRPC$MessageMedia convertToTLLive(LiveModels.LiveMessage liveMessage) {
        if (liveMessage == null) {
            return null;
        }
        TLRPC$MessageMedia tLRPC$MessageMedia = new TLRPC$MessageMedia() { // from class: org.rbmain.tgnet.TLRPC$TL_messageMediaLiveMessage
        };
        TLRPC$TL_live tLRPC$TL_live = new TLRPC$TL_live();
        tLRPC$MessageMedia.live = tLRPC$TL_live;
        tLRPC$TL_live.document = new TLRPC$TL_document();
        tLRPC$MessageMedia.live.document.thumbs = new ArrayList<>();
        String str = liveMessage.thumb_inline;
        if (str != null) {
            tLRPC$MessageMedia.live.document.thumbs.add(getStrippedSize(str, false));
        }
        TLRPC$TL_documentAttributeImageSize tLRPC$TL_documentAttributeImageSize = new TLRPC$TL_documentAttributeImageSize();
        tLRPC$TL_documentAttributeImageSize.w = 600;
        tLRPC$TL_documentAttributeImageSize.h = 600;
        tLRPC$MessageMedia.live.document.attributes = new ArrayList<>();
        tLRPC$MessageMedia.live.document.attributes.add(tLRPC$TL_documentAttributeImageSize);
        TLRPC$TL_live tLRPC$TL_live2 = tLRPC$MessageMedia.live;
        tLRPC$TL_live2.access_token = liveMessage.access_token;
        tLRPC$TL_live2.live_id = liveMessage.live_id;
        tLRPC$TL_live2.live_status = liveMessage.live_status;
        tLRPC$TL_live2.title = liveMessage.title;
        return tLRPC$MessageMedia;
    }

    public static TLRPC$MessageMedia convertToTLLiveLocation(LiveLocationObject liveLocationObject) {
        if (liveLocationObject == null) {
            return null;
        }
        TLRPC$TL_messageMediaGeoLive tLRPC$TL_messageMediaGeoLive = new TLRPC$TL_messageMediaGeoLive();
        tLRPC$TL_messageMediaGeoLive.period = liveLocationObject.status == LiveLocationObject.Status.Live ? (int) liveLocationObject.live_period : 0;
        tLRPC$TL_messageMediaGeoLive.geo = convertGeoPoint(liveLocationObject.current_location);
        tLRPC$TL_messageMediaGeoLive.live_loc_track_id = liveLocationObject.live_loc_track_id;
        tLRPC$TL_messageMediaGeoLive.device_hash = liveLocationObject.device_hash;
        return tLRPC$TL_messageMediaGeoLive;
    }

    public static TLRPC$MessageMedia convertToTLLocation(LocationObject locationObject) {
        if (locationObject == null) {
            return null;
        }
        TLRPC$TL_messageMediaGeo tLRPC$TL_messageMediaGeo = new TLRPC$TL_messageMediaGeo();
        tLRPC$TL_messageMediaGeo.geo = convertGeoPoint(locationObject);
        return tLRPC$TL_messageMediaGeo;
    }

    private static TLRPC$GeoPoint convertGeoPoint(LocationObject locationObject) {
        TLRPC$TL_geoPoint tLRPC$TL_geoPoint = new TLRPC$TL_geoPoint();
        tLRPC$TL_geoPoint._long = locationObject.longitude;
        tLRPC$TL_geoPoint.lat = locationObject.latitude;
        return tLRPC$TL_geoPoint;
    }

    public static TLRPC$MessageMedia convertToTLPoll(HashMap<String, String> map, PollObject pollObject) {
        Set<Integer> set;
        if (pollObject == null) {
            return null;
        }
        PollStatusObject pollStatusObject = pollObject.poll_status;
        TLRPC$TL_pollResults tLRPC$TL_pollResults = new TLRPC$TL_pollResults();
        TLRPC$TL_messageMediaPoll tLRPC$TL_messageMediaPoll = new TLRPC$TL_messageMediaPoll();
        TLRPC$TL_poll tLRPC$TL_poll = new TLRPC$TL_poll();
        String str = pollObject.poll_id;
        if (str != null && !str.isEmpty()) {
            tLRPC$TL_poll.id = IdStorage.getInstance().generatePollId(pollObject.poll_id);
        }
        tLRPC$TL_poll.question = pollObject.question;
        boolean z = false;
        int i = 0;
        while (i < pollObject.options.size()) {
            if (pollStatusObject != null && pollStatusObject.percent_vote_options != null) {
                TLRPC$TL_pollAnswerVoters tLRPC$TL_pollAnswerVoters = new TLRPC$TL_pollAnswerVoters();
                tLRPC$TL_pollAnswerVoters.chosen = i == pollStatusObject.selection_index || ((set = pollStatusObject.multiple_selections) != null && set.contains(Integer.valueOf(i)));
                tLRPC$TL_pollAnswerVoters.correct = i == pollStatusObject.correct_option_index;
                tLRPC$TL_pollAnswerVoters.voters = Math.round(((pollStatusObject.total_vote * 1.0f) * pollStatusObject.percent_vote_options.get(i).intValue()) / 100.0f);
                tLRPC$TL_pollAnswerVoters.option = new byte[]{(byte) (i + 48)};
                tLRPC$TL_pollResults.results.add(tLRPC$TL_pollAnswerVoters);
            }
            String str2 = pollObject.options.get(i);
            TLRPC$TL_pollAnswer tLRPC$TL_pollAnswer = new TLRPC$TL_pollAnswer();
            tLRPC$TL_pollAnswer.text = str2;
            tLRPC$TL_pollAnswer.option = new byte[]{(byte) (i + 48)};
            tLRPC$TL_poll.answers.add(tLRPC$TL_pollAnswer);
            i++;
        }
        tLRPC$TL_poll.public_voters = !pollObject.is_anonymous;
        tLRPC$TL_poll.quiz = pollObject.type == PollObject.QuizTypeEnum.Quiz;
        tLRPC$TL_poll.close_period = (int) pollObject.close_period;
        tLRPC$TL_poll.multiple_choice = pollObject.allows_multiple_answers;
        if (pollStatusObject != null && pollStatusObject.state == PollStatusObject.StateEnum.Closed) {
            z = true;
        }
        tLRPC$TL_poll.closed = z;
        tLRPC$TL_pollResults.solution = pollStatusObject != null ? pollStatusObject.explanation : pollObject.explanationTemp;
        if (pollStatusObject != null) {
            ArrayList<String> arrayList = pollStatusObject.voters_object_guids;
            if (arrayList != null) {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    tLRPC$TL_pollResults.recent_voters.add(Integer.valueOf((int) IdStorage.getInstance().generateDialogId(it.next())));
                }
            }
            tLRPC$TL_pollResults.total_voters = MessageProxy$32$$ExternalSyntheticBackport0.m(pollStatusObject.total_vote);
        } else if (pollObject.correctOptionIndexLocal != null) {
            SerializedData serializedData = new SerializedData(1);
            serializedData.writeByte((byte) (pollObject.correctOptionIndexLocal.intValue() + 48));
            if (map == null) {
                map = new HashMap<>();
            }
            map.put("answers", Utilities.bytesToHex(serializedData.toByteArray()));
        }
        tLRPC$TL_messageMediaPoll.poll = tLRPC$TL_poll;
        tLRPC$TL_messageMediaPoll.results = tLRPC$TL_pollResults;
        return tLRPC$TL_messageMediaPoll;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [org.rbmain.tgnet.TLRPC$TL_messageEntityUnknown] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.Object, org.rbmain.tgnet.TLRPC$MessageEntity] */
    /* JADX WARN: Type inference failed for: r2v11, types: [org.rbmain.tgnet.TLRPC$TL_messageEntitySpoiler] */
    /* JADX WARN: Type inference failed for: r2v2, types: [org.rbmain.tgnet.TLRPC$TL_messageEntityPre] */
    /* JADX WARN: Type inference failed for: r2v3, types: [org.rbmain.tgnet.TLRPC$TL_messageEntityCode] */
    /* JADX WARN: Type inference failed for: r2v4, types: [org.rbmain.tgnet.TLRPC$TL_inputMessageEntityMentionName] */
    /* JADX WARN: Type inference failed for: r2v5, types: [org.rbmain.tgnet.TLRPC$MessageEntity, org.rbmain.tgnet.TLRPC$TL_messageEntityTextUrl] */
    /* JADX WARN: Type inference failed for: r2v6, types: [org.rbmain.tgnet.TLRPC$TL_messageEntityItalic] */
    /* JADX WARN: Type inference failed for: r2v7, types: [org.rbmain.tgnet.TLRPC$TL_messageEntityUnderline] */
    /* JADX WARN: Type inference failed for: r2v8, types: [org.rbmain.tgnet.TLRPC$TL_messageEntityStrike] */
    /* JADX WARN: Type inference failed for: r2v9, types: [org.rbmain.tgnet.TLRPC$TL_messageEntityBold] */
    private static ArrayList<TLRPC$MessageEntity> convertAllMetaDataToEntities(MetaDataObject metaDataObject) {
        ArrayList<MetaDataPartObject> arrayList;
        ?? tLRPC$TL_messageEntityCode;
        ArrayList arrayList2 = new ArrayList();
        if (metaDataObject != null && (arrayList = metaDataObject.meta_data_parts) != null) {
            Iterator<MetaDataPartObject> it = arrayList.iterator();
            while (it.hasNext()) {
                MetaDataPartObject next = it.next();
                MetaDataPartObject.MetaType metaType = next.type;
                if (metaType == MetaDataPartObject.MetaType.Spoiler) {
                    tLRPC$TL_messageEntityCode = new TLRPC$TL_messageEntitySpoiler();
                } else if (metaType == MetaDataPartObject.MetaType.Bold) {
                    tLRPC$TL_messageEntityCode = new TLRPC$TL_messageEntityBold();
                } else if (metaType == MetaDataPartObject.MetaType.Strike) {
                    tLRPC$TL_messageEntityCode = new TLRPC$TL_messageEntityStrike();
                } else if (metaType == MetaDataPartObject.MetaType.Underline) {
                    tLRPC$TL_messageEntityCode = new TLRPC$TL_messageEntityUnderline();
                } else if (metaType == MetaDataPartObject.MetaType.Italic) {
                    tLRPC$TL_messageEntityCode = new TLRPC$TL_messageEntityItalic();
                } else if (metaType == MetaDataPartObject.MetaType.Link) {
                    tLRPC$TL_messageEntityCode = new TLRPC$TL_messageEntityTextUrl();
                    Link linkConvertToAppLink = MessengerLinkHandler.convertToAppLink(next.link);
                    if (linkConvertToAppLink != null && linkConvertToAppLink.type == Link.LinkTypeEnum.hyperlink) {
                        tLRPC$TL_messageEntityCode.url = linkConvertToAppLink.hyperlink_data.url;
                    }
                } else if (metaType == MetaDataPartObject.MetaType.MentionText) {
                    tLRPC$TL_messageEntityCode = new TLRPC$TL_inputMessageEntityMentionName();
                    TLRPC$TL_inputUser tLRPC$TL_inputUser = new TLRPC$TL_inputUser();
                    tLRPC$TL_messageEntityCode.user_id = tLRPC$TL_inputUser;
                    tLRPC$TL_inputUser.user_id = (int) IdStorage.getInstance().generateDialogId(next.mention_text_object_guid);
                } else {
                    tLRPC$TL_messageEntityCode = metaType == MetaDataPartObject.MetaType.Mono ? new TLRPC$TL_messageEntityCode() : metaType == MetaDataPartObject.MetaType.Pre ? new TLRPC$TL_messageEntityPre() : new TLRPC$TL_messageEntityUnknown();
                }
                tLRPC$TL_messageEntityCode.length = next.length;
                tLRPC$TL_messageEntityCode.offset = next.from_index;
                arrayList2.add(tLRPC$TL_messageEntityCode);
            }
        }
        return arrayList2;
    }

    public static MetaDataObject convertAllEntitiesToMetaData(ArrayList<TLRPC$MessageEntity> arrayList) {
        MetaDataObject metaDataObject = new MetaDataObject();
        ArrayList<MetaDataPartObject> arrayList2 = new ArrayList<>();
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<TLRPC$MessageEntity> it = arrayList.iterator();
            while (it.hasNext()) {
                TLRPC$MessageEntity next = it.next();
                if (next != null) {
                    MetaDataPartObject metaDataPartObject = new MetaDataPartObject();
                    if (next instanceof TLRPC$TL_messageEntitySpoiler) {
                        metaDataPartObject.type = MetaDataPartObject.MetaType.Spoiler;
                    } else if (next instanceof TLRPC$TL_messageEntityBold) {
                        metaDataPartObject.type = MetaDataPartObject.MetaType.Bold;
                    } else if (next instanceof TLRPC$TL_messageEntityItalic) {
                        metaDataPartObject.type = MetaDataPartObject.MetaType.Italic;
                    } else if (next instanceof TLRPC$TL_messageEntityTextUrl) {
                        metaDataPartObject.type = MetaDataPartObject.MetaType.Link;
                        Link link = new Link();
                        link.type = Link.LinkTypeEnum.hyperlink;
                        Link.HyperLinkData hyperLinkData = new Link.HyperLinkData();
                        link.hyperlink_data = hyperLinkData;
                        hyperLinkData.url = next.url;
                        metaDataPartObject.link = MessengerLinkHandler.convertToCoreLink(link);
                    } else if (next instanceof TLRPC$TL_inputMessageEntityMentionName) {
                        metaDataPartObject.type = MetaDataPartObject.MetaType.MentionText;
                        metaDataPartObject.mention_text_object_guid = IdStorage.getInstance().getDialogId(((TLRPC$TL_inputMessageEntityMentionName) next).user_id.user_id);
                    } else if (next instanceof TLRPC$TL_messageEntityCode) {
                        metaDataPartObject.type = MetaDataPartObject.MetaType.Mono;
                    } else if (next instanceof TLRPC$TL_messageEntityPre) {
                        metaDataPartObject.type = MetaDataPartObject.MetaType.Pre;
                    } else if (next instanceof TLRPC$TL_messageEntityStrike) {
                        metaDataPartObject.type = MetaDataPartObject.MetaType.Strike;
                    } else if (next instanceof TLRPC$TL_messageEntityUnderline) {
                        metaDataPartObject.type = MetaDataPartObject.MetaType.Underline;
                    }
                    metaDataPartObject.from_index = next.offset;
                    metaDataPartObject.length = next.length;
                    arrayList2.add(metaDataPartObject);
                }
            }
        }
        metaDataObject.meta_data_parts = arrayList2;
        if (arrayList2.isEmpty()) {
            return null;
        }
        return metaDataObject;
    }

    public static void setMessageFromId(TLRPC$Message tLRPC$Message, Message message, long j, boolean z, LongSparseArray<TLRPC$User> longSparseArray, CoreMainClass coreMainClass) {
        ObjectGuidType objectGuidType;
        Message.EventObject eventObject = message.event_data;
        if (eventObject != null && (objectGuidType = eventObject.performer_object) != null) {
            ChatType chatType = objectGuidType.type;
            ChatType chatType2 = ChatType.User;
            if (chatType == chatType2 || chatType == ChatType.Bot || chatType == ChatType.Service) {
                long jGenerateDialogId = IdStorage.getInstance().generateDialogId(objectGuidType.object_guid);
                TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                tLRPC$Message.from_id = tLRPC$TL_peerUser;
                tLRPC$TL_peerUser.user_id = (int) jGenerateDialogId;
                ChatAbsObject absInstant = coreMainClass.getAbsInstant(objectGuidType.object_guid);
                if (absInstant == null || longSparseArray == null) {
                    return;
                }
                TLRPC$User tLRPC$UserConvertBot = longSparseArray.get(jGenerateDialogId);
                if (tLRPC$UserConvertBot == null) {
                    ChatType chatType3 = objectGuidType.type;
                    if (chatType3 == chatType2) {
                        tLRPC$UserConvertBot = ChatConverter.convertUser(coreMainClass, jGenerateDialogId, absInstant, (UserInfo) null, (Chat) null);
                    } else if (chatType3 == ChatType.Service) {
                        tLRPC$UserConvertBot = ChatConverter.convertService(coreMainClass, jGenerateDialogId, absInstant, null, null);
                    } else {
                        tLRPC$UserConvertBot = ChatConverter.convertBot(coreMainClass, jGenerateDialogId, absInstant, null, null);
                    }
                }
                longSparseArray.put(tLRPC$UserConvertBot.id, tLRPC$UserConvertBot);
                return;
            }
            if (chatType == ChatType.Group || chatType == ChatType.Channel) {
                TLRPC$TL_peerChannel tLRPC$TL_peerChannel = new TLRPC$TL_peerChannel();
                tLRPC$Message.from_id = tLRPC$TL_peerChannel;
                tLRPC$TL_peerChannel.channel_id = ((int) IdStorage.getInstance().generateNegativeDialogId(objectGuidType.object_guid)) * (-1);
                return;
            }
            return;
        }
        Message.AuthorTypeEnum authorTypeEnum = message.author_type;
        if (authorTypeEnum == null) {
            if (z && j != 0) {
                TLRPC$TL_peerChannel tLRPC$TL_peerChannel2 = new TLRPC$TL_peerChannel();
                tLRPC$Message.from_id = tLRPC$TL_peerChannel2;
                tLRPC$TL_peerChannel2.channel_id = ((int) j) * (-1);
                return;
            } else {
                TLRPC$TL_peerUser tLRPC$TL_peerUser2 = new TLRPC$TL_peerUser();
                tLRPC$Message.from_id = tLRPC$TL_peerUser2;
                tLRPC$TL_peerUser2.user_id = (int) j;
                return;
            }
        }
        int i = AnonymousClass1.$SwitchMap$ir$aaap$messengercore$model$Message$AuthorTypeEnum[authorTypeEnum.ordinal()];
        if (i == 1 || i == 2) {
            long jGenerateDialogId2 = IdStorage.getInstance().generateDialogId(message.author_object_guid);
            TLRPC$TL_peerUser tLRPC$TL_peerUser3 = new TLRPC$TL_peerUser();
            tLRPC$Message.from_id = tLRPC$TL_peerUser3;
            tLRPC$TL_peerUser3.user_id = (int) jGenerateDialogId2;
            ChatAbsObject absInstant2 = coreMainClass.getAbsInstant(message.author_object_guid);
            if (absInstant2 == null || longSparseArray == null) {
                return;
            }
            TLRPC$User tLRPC$UserConvertBot2 = longSparseArray.get(jGenerateDialogId2);
            if (tLRPC$UserConvertBot2 == null) {
                if (message.author_type == Message.AuthorTypeEnum.User) {
                    tLRPC$UserConvertBot2 = ChatConverter.convertUser(coreMainClass, jGenerateDialogId2, absInstant2, (UserInfo) null, (Chat) null);
                } else {
                    tLRPC$UserConvertBot2 = ChatConverter.convertBot(coreMainClass, jGenerateDialogId2, absInstant2, null, null);
                }
            }
            longSparseArray.put(tLRPC$UserConvertBot2.id, tLRPC$UserConvertBot2);
            return;
        }
        TLRPC$TL_peerUser tLRPC$TL_peerUser4 = new TLRPC$TL_peerUser();
        tLRPC$Message.from_id = tLRPC$TL_peerUser4;
        tLRPC$TL_peerUser4.user_id = 111018908;
    }

    private static void setMessagePeerId(TLRPC$Message tLRPC$Message, long j) {
        if (j > 0) {
            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
            tLRPC$Message.peer_id = tLRPC$TL_peerUser;
            tLRPC$TL_peerUser.user_id = (int) j;
        } else {
            TLRPC$TL_peerChannel tLRPC$TL_peerChannel = new TLRPC$TL_peerChannel();
            tLRPC$Message.peer_id = tLRPC$TL_peerChannel;
            tLRPC$TL_peerChannel.channel_id = ((int) j) * (-1);
        }
    }

    private static void writePreviousMessageData(TLRPC$Message tLRPC$Message, SerializedData serializedData, String str, ArrayList<TLRPC$MessageEntity> arrayList) {
        TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$Message.media;
        if (tLRPC$MessageMedia == null) {
            new TLRPC$TL_messageMediaEmpty().serializeToStream(serializedData);
        } else {
            tLRPC$MessageMedia.serializeToStream(serializedData);
        }
        String str2 = BuildConfig.FLAVOR;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        serializedData.writeString(str);
        String str3 = tLRPC$Message.attachPath;
        if (str3 != null) {
            str2 = str3;
        }
        serializedData.writeString(str2);
        int size = arrayList.size();
        serializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            arrayList.get(i).serializeToStream(serializedData);
        }
    }

    public static TLRPC$MessageMedia convertToMessageMedia(Message message, FileInlineObject fileInlineObject) {
        TLRPC$MessageMedia tLRPC$TL_messageMediaDocument;
        TLRPC$DocumentAttribute tLRPC$TL_documentAttributeVideo;
        FileInlineObject.FileInlineType fileInlineType;
        if (fileInlineObject.type == FileInlineObject.FileInlineType.Image) {
            tLRPC$TL_messageMediaDocument = new TLRPC$TL_messageMediaPhoto();
            Message.LocalParametersObject localParametersObject = message.localParametersObject;
            tLRPC$TL_messageMediaDocument.photo = convertToPhoto(fileInlineObject, message.text, localParametersObject != null ? localParametersObject.thumb_local_id : 0);
        } else {
            tLRPC$TL_messageMediaDocument = new TLRPC$TL_messageMediaDocument();
            TLRPC$Document tLRPC$DocumentConvertFileInlineToDocumentCommonFields = convertFileInlineToDocumentCommonFields(fileInlineObject);
            tLRPC$DocumentConvertFileInlineToDocumentCommonFields.file_reference = new byte[0];
            ArrayList<TLRPC$DocumentAttribute> arrayList = new ArrayList<>();
            tLRPC$DocumentConvertFileInlineToDocumentCommonFields.mime_type = getMimeType(fileInlineObject.mime);
            FileInlineObject.FileInlineType fileInlineType2 = fileInlineObject.type;
            FileInlineObject.FileInlineType fileInlineType3 = FileInlineObject.FileInlineType.Video;
            if (fileInlineType2 == fileInlineType3 || fileInlineType2 == FileInlineObject.FileInlineType.Gif || (fileInlineType2 == FileInlineObject.FileInlineType.File && fileInlineObject.mime.contains("mp4"))) {
                if (!tLRPC$DocumentConvertFileInlineToDocumentCommonFields.mime_type.contains("video/") && ((fileInlineType = fileInlineObject.type) == fileInlineType3 || (fileInlineType == FileInlineObject.FileInlineType.File && fileInlineObject.mime.contains("mp4")))) {
                    tLRPC$DocumentConvertFileInlineToDocumentCommonFields.mime_type = "video/" + tLRPC$DocumentConvertFileInlineToDocumentCommonFields.mime_type;
                }
                if (!tLRPC$DocumentConvertFileInlineToDocumentCommonFields.mime_type.contains("video/") && fileInlineObject.type == FileInlineObject.FileInlineType.Gif) {
                    tLRPC$DocumentConvertFileInlineToDocumentCommonFields.mime_type = "image/gif";
                }
                FileInlineObject.FileInlineType fileInlineType4 = fileInlineObject.type;
                if (fileInlineType4 == fileInlineType3 || fileInlineType4 == FileInlineObject.FileInlineType.Gif) {
                    tLRPC$TL_documentAttributeVideo = new TLRPC$TL_documentAttributeVideo();
                    tLRPC$TL_documentAttributeVideo.duration = fileInlineObject.time / CloseCodes.NORMAL_CLOSURE;
                    tLRPC$TL_documentAttributeVideo.h = fileInlineObject.height;
                    tLRPC$TL_documentAttributeVideo.w = fileInlineObject.width;
                    tLRPC$TL_documentAttributeVideo.round_message = fileInlineObject.is_round;
                    tLRPC$TL_documentAttributeVideo.supports_streaming = true;
                } else {
                    tLRPC$TL_documentAttributeVideo = new TLRPC$TL_documentAttributeVideoFile();
                }
                arrayList.add(tLRPC$TL_documentAttributeVideo);
                Message.LocalParametersObject localParametersObject2 = message.localParametersObject;
                if (localParametersObject2 != null) {
                    int i = localParametersObject2.thumb_local_id;
                }
                tLRPC$DocumentConvertFileInlineToDocumentCommonFields.thumbs = new ArrayList<>();
                String str = fileInlineObject.thumb_inline;
                if (str != null) {
                    tLRPC$DocumentConvertFileInlineToDocumentCommonFields.thumbs.add(getStrippedSize(str, false));
                }
                if (fileInlineObject.type == FileInlineObject.FileInlineType.Gif) {
                    String mime = FileLoader.getMime(fileInlineObject.file_name);
                    if (!TextUtils.isEmpty(fileInlineObject.file_name) && TextUtils.isEmpty(mime)) {
                        boolean zEndsWith = fileInlineObject.file_name.endsWith(".");
                        StringBuilder sb = new StringBuilder();
                        sb.append(fileInlineObject.file_name);
                        sb.append(zEndsWith ? BuildConfig.FLAVOR : ".");
                        sb.append("mp4");
                        fileInlineObject.file_name = sb.toString();
                        fileInlineObject.mime = "mp4";
                    }
                    tLRPC$DocumentConvertFileInlineToDocumentCommonFields.thumbs.add(getPhotoSize(fileInlineObject, false, 0));
                    tLRPC$DocumentConvertFileInlineToDocumentCommonFields.video_thumbs = getVideoSizes(fileInlineObject);
                }
            } else {
                FileInlineObject.FileInlineType fileInlineType5 = fileInlineObject.type;
                if (fileInlineType5 == FileInlineObject.FileInlineType.Music) {
                    TLRPC$TL_documentAttributeAudio tLRPC$TL_documentAttributeAudio = new TLRPC$TL_documentAttributeAudio();
                    String mime2 = FileLoader.getMime(fileInlineObject.file_name);
                    if (!TextUtils.isEmpty(fileInlineObject.file_name) && TextUtils.isEmpty(mime2)) {
                        fileInlineObject.file_name += ".mp3";
                        fileInlineObject.mime = "mp3";
                    }
                    tLRPC$TL_documentAttributeAudio.duration = fileInlineObject.time;
                    tLRPC$TL_documentAttributeAudio.h = fileInlineObject.height;
                    tLRPC$TL_documentAttributeAudio.w = fileInlineObject.width;
                    tLRPC$TL_documentAttributeAudio.performer = fileInlineObject.music_performer;
                    tLRPC$TL_documentAttributeAudio.title = excludeMimePart(fileInlineObject.file_name);
                    arrayList.add(tLRPC$TL_documentAttributeAudio);
                } else if (fileInlineType5 == FileInlineObject.FileInlineType.Voice) {
                    TLRPC$TL_documentAttributeAudio tLRPC$TL_documentAttributeAudio2 = new TLRPC$TL_documentAttributeAudio();
                    tLRPC$TL_documentAttributeAudio2.duration = (int) Math.ceil(fileInlineObject.time / 1000.0f);
                    tLRPC$TL_documentAttributeAudio2.h = fileInlineObject.height;
                    tLRPC$TL_documentAttributeAudio2.w = fileInlineObject.width;
                    tLRPC$TL_documentAttributeAudio2.voice = true;
                    tLRPC$TL_documentAttributeAudio2.flags = 1028;
                    arrayList.add(tLRPC$TL_documentAttributeAudio2);
                    if (!tLRPC$DocumentConvertFileInlineToDocumentCommonFields.mime_type.contains("audio/")) {
                        tLRPC$DocumentConvertFileInlineToDocumentCommonFields.mime_type = "audio/" + tLRPC$DocumentConvertFileInlineToDocumentCommonFields.mime_type;
                    }
                } else if (message.type == Message.MessageTypeEnum.Sticker) {
                    TLRPC$TL_documentAttributeImageSize tLRPC$TL_documentAttributeImageSize = new TLRPC$TL_documentAttributeImageSize();
                    tLRPC$TL_documentAttributeImageSize.h = 512;
                    tLRPC$TL_documentAttributeImageSize.w = (int) (message.sticker.w_h_ratio * 512);
                    arrayList.add(tLRPC$TL_documentAttributeImageSize);
                    TLRPC$TL_documentAttributeSticker tLRPC$TL_documentAttributeSticker = new TLRPC$TL_documentAttributeSticker();
                    StickerObject stickerObject = message.sticker;
                    tLRPC$TL_documentAttributeSticker.alt = stickerObject.emoji_character;
                    tLRPC$TL_documentAttributeSticker.stickerId = stickerObject.sticker_id;
                    tLRPC$DocumentConvertFileInlineToDocumentCommonFields.mime_type = "image/webp";
                    TLRPC$TL_inputStickerSetID tLRPC$TL_inputStickerSetID = new TLRPC$TL_inputStickerSetID();
                    tLRPC$TL_documentAttributeSticker.stickerset = tLRPC$TL_inputStickerSetID;
                    tLRPC$TL_inputStickerSetID.id = IdStorage.getInstance().generateStickerSetId(message.sticker.sticker_set_id);
                    arrayList.add(tLRPC$TL_documentAttributeSticker);
                    ArrayList<TLRPC$PhotoSize> arrayList2 = new ArrayList<>();
                    tLRPC$DocumentConvertFileInlineToDocumentCommonFields.thumbs = arrayList2;
                    arrayList2.add(getStrippedSize(message.sticker.file.thumb_inline, true));
                    tLRPC$DocumentConvertFileInlineToDocumentCommonFields.thumbs.add(getPhotoSize(message.sticker.file, false, 0));
                }
            }
            String str2 = fileInlineObject.file_name;
            if (str2 != null && !str2.isEmpty()) {
                TLRPC$TL_documentAttributeFilename tLRPC$TL_documentAttributeFilename = new TLRPC$TL_documentAttributeFilename();
                tLRPC$TL_documentAttributeFilename.file_name = fileInlineObject.file_name;
                arrayList.add(tLRPC$TL_documentAttributeFilename);
            }
            if (fileInlineObject.type == FileInlineObject.FileInlineType.Gif) {
                arrayList.add(new TLRPC$TL_documentAttributeAnimated());
            }
            tLRPC$DocumentConvertFileInlineToDocumentCommonFields.attributes = arrayList;
            if (fileInlineObject.access_hash_rec != null) {
                tLRPC$DocumentConvertFileInlineToDocumentCommonFields.access_hash = IdStorage.getInstance().generateAccessHash(fileInlineObject.access_hash_rec);
            }
            tLRPC$DocumentConvertFileInlineToDocumentCommonFields.attributes = arrayList;
            tLRPC$TL_messageMediaDocument.document = tLRPC$DocumentConvertFileInlineToDocumentCommonFields;
        }
        tLRPC$TL_messageMediaDocument.flags = 1;
        setCdnTag(tLRPC$TL_messageMediaDocument, fileInlineObject.cdn_tag);
        return tLRPC$TL_messageMediaDocument;
    }

    private static String excludeMimePart(String str) {
        int iLastIndexOf;
        return (str == null || str.isEmpty() || (iLastIndexOf = str.lastIndexOf(46)) == -1) ? BuildConfig.FLAVOR : str.substring(0, iLastIndexOf);
    }

    public static TLRPC$MessageMedia convertToMessageMedia(FileInlineObject fileInlineObject) {
        TLRPC$MessageMedia tLRPC$TL_messageMediaDocument;
        TLRPC$DocumentAttribute tLRPC$TL_documentAttributeVideo;
        FileInlineObject.FileInlineType fileInlineType;
        if (fileInlineObject == null) {
            return null;
        }
        if (fileInlineObject.type == FileInlineObject.FileInlineType.Image) {
            tLRPC$TL_messageMediaDocument = new TLRPC$TL_messageMediaPhoto();
            tLRPC$TL_messageMediaDocument.photo = convertToPhoto(fileInlineObject, null, 0);
        } else {
            tLRPC$TL_messageMediaDocument = new TLRPC$TL_messageMediaDocument();
            TLRPC$Document tLRPC$DocumentConvertFileInlineToDocumentCommonFields = convertFileInlineToDocumentCommonFields(fileInlineObject);
            tLRPC$DocumentConvertFileInlineToDocumentCommonFields.file_reference = new byte[0];
            ArrayList<TLRPC$DocumentAttribute> arrayList = new ArrayList<>();
            tLRPC$DocumentConvertFileInlineToDocumentCommonFields.mime_type = getMimeType(fileInlineObject.mime);
            FileInlineObject.FileInlineType fileInlineType2 = fileInlineObject.type;
            FileInlineObject.FileInlineType fileInlineType3 = FileInlineObject.FileInlineType.Video;
            if (fileInlineType2 == fileInlineType3 || fileInlineType2 == FileInlineObject.FileInlineType.Gif || (fileInlineType2 == FileInlineObject.FileInlineType.File && fileInlineObject.mime.contains("mp4"))) {
                if (!tLRPC$DocumentConvertFileInlineToDocumentCommonFields.mime_type.contains("video/") && ((fileInlineType = fileInlineObject.type) == fileInlineType3 || (fileInlineType == FileInlineObject.FileInlineType.File && fileInlineObject.mime.contains("mp4")))) {
                    tLRPC$DocumentConvertFileInlineToDocumentCommonFields.mime_type = "video/" + tLRPC$DocumentConvertFileInlineToDocumentCommonFields.mime_type;
                }
                if (!tLRPC$DocumentConvertFileInlineToDocumentCommonFields.mime_type.contains("video/") && fileInlineObject.type == FileInlineObject.FileInlineType.Gif) {
                    tLRPC$DocumentConvertFileInlineToDocumentCommonFields.mime_type = "image/gif";
                }
                FileInlineObject.FileInlineType fileInlineType4 = fileInlineObject.type;
                if (fileInlineType4 == fileInlineType3 || fileInlineType4 == FileInlineObject.FileInlineType.Gif) {
                    tLRPC$TL_documentAttributeVideo = new TLRPC$TL_documentAttributeVideo();
                    tLRPC$TL_documentAttributeVideo.duration = fileInlineObject.time / CloseCodes.NORMAL_CLOSURE;
                    tLRPC$TL_documentAttributeVideo.h = fileInlineObject.height;
                    tLRPC$TL_documentAttributeVideo.w = fileInlineObject.width;
                    tLRPC$TL_documentAttributeVideo.round_message = fileInlineObject.is_round;
                    tLRPC$TL_documentAttributeVideo.supports_streaming = true;
                } else {
                    tLRPC$TL_documentAttributeVideo = new TLRPC$TL_documentAttributeVideoFile();
                }
                arrayList.add(tLRPC$TL_documentAttributeVideo);
                tLRPC$DocumentConvertFileInlineToDocumentCommonFields.thumbs = new ArrayList<>();
                String str = fileInlineObject.thumb_inline;
                if (str != null) {
                    tLRPC$DocumentConvertFileInlineToDocumentCommonFields.thumbs.add(getStrippedSize(str, false));
                }
                if (fileInlineObject.type == FileInlineObject.FileInlineType.Gif) {
                    String mime = FileLoader.getMime(fileInlineObject.file_name);
                    if (!TextUtils.isEmpty(fileInlineObject.file_name) && TextUtils.isEmpty(mime)) {
                        boolean zEndsWith = fileInlineObject.file_name.endsWith(".");
                        StringBuilder sb = new StringBuilder();
                        sb.append(fileInlineObject.file_name);
                        sb.append(zEndsWith ? BuildConfig.FLAVOR : ".");
                        sb.append("mp4");
                        fileInlineObject.file_name = sb.toString();
                        fileInlineObject.mime = "mp4";
                    }
                    tLRPC$DocumentConvertFileInlineToDocumentCommonFields.thumbs.add(getPhotoSize(fileInlineObject, false, 0));
                    tLRPC$DocumentConvertFileInlineToDocumentCommonFields.video_thumbs = getVideoSizes(fileInlineObject);
                }
            } else {
                FileInlineObject.FileInlineType fileInlineType5 = fileInlineObject.type;
                if (fileInlineType5 == FileInlineObject.FileInlineType.Music) {
                    TLRPC$TL_documentAttributeAudio tLRPC$TL_documentAttributeAudio = new TLRPC$TL_documentAttributeAudio();
                    String mime2 = FileLoader.getMime(fileInlineObject.file_name);
                    if (!TextUtils.isEmpty(fileInlineObject.file_name) && TextUtils.isEmpty(mime2)) {
                        fileInlineObject.mime = "mp3";
                    }
                    tLRPC$TL_documentAttributeAudio.duration = fileInlineObject.time;
                    tLRPC$TL_documentAttributeAudio.h = fileInlineObject.height;
                    tLRPC$TL_documentAttributeAudio.w = fileInlineObject.width;
                    tLRPC$TL_documentAttributeAudio.performer = fileInlineObject.music_performer;
                    tLRPC$TL_documentAttributeAudio.title = fileInlineObject.file_name;
                    arrayList.add(tLRPC$TL_documentAttributeAudio);
                } else if (fileInlineType5 == FileInlineObject.FileInlineType.Voice) {
                    TLRPC$TL_documentAttributeAudio tLRPC$TL_documentAttributeAudio2 = new TLRPC$TL_documentAttributeAudio();
                    tLRPC$TL_documentAttributeAudio2.duration = (int) Math.ceil(fileInlineObject.time / 1000.0f);
                    tLRPC$TL_documentAttributeAudio2.h = fileInlineObject.height;
                    tLRPC$TL_documentAttributeAudio2.w = fileInlineObject.width;
                    tLRPC$TL_documentAttributeAudio2.voice = true;
                    tLRPC$TL_documentAttributeAudio2.flags = 1028;
                    arrayList.add(tLRPC$TL_documentAttributeAudio2);
                    if (!tLRPC$DocumentConvertFileInlineToDocumentCommonFields.mime_type.contains("audio/")) {
                        tLRPC$DocumentConvertFileInlineToDocumentCommonFields.mime_type = "audio/" + tLRPC$DocumentConvertFileInlineToDocumentCommonFields.mime_type;
                    }
                }
            }
            String str2 = fileInlineObject.file_name;
            if (str2 != null && !str2.isEmpty()) {
                TLRPC$TL_documentAttributeFilename tLRPC$TL_documentAttributeFilename = new TLRPC$TL_documentAttributeFilename();
                tLRPC$TL_documentAttributeFilename.file_name = fileInlineObject.file_name;
                arrayList.add(tLRPC$TL_documentAttributeFilename);
            }
            if (fileInlineObject.type == FileInlineObject.FileInlineType.Gif) {
                arrayList.add(new TLRPC$TL_documentAttributeAnimated());
            }
            tLRPC$DocumentConvertFileInlineToDocumentCommonFields.attributes = arrayList;
            if (fileInlineObject.access_hash_rec != null) {
                tLRPC$DocumentConvertFileInlineToDocumentCommonFields.access_hash = IdStorage.getInstance().generateAccessHash(fileInlineObject.access_hash_rec);
            }
            tLRPC$DocumentConvertFileInlineToDocumentCommonFields.attributes = arrayList;
            tLRPC$TL_messageMediaDocument.document = tLRPC$DocumentConvertFileInlineToDocumentCommonFields;
        }
        tLRPC$TL_messageMediaDocument.flags = 1;
        setCdnTag(tLRPC$TL_messageMediaDocument, fileInlineObject.cdn_tag);
        return tLRPC$TL_messageMediaDocument;
    }

    public static String getMimeType(String str) {
        String mimeTypeFromExtension = str != null ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(str.toLowerCase()) : null;
        return mimeTypeFromExtension == null ? "application/octet-stream" : mimeTypeFromExtension;
    }

    public static TLRPC$Photo convertToPhoto(FileInlineObject fileInlineObject, String str, int i) {
        if (fileInlineObject == null) {
            return new TLRPC$TL_photoEmpty();
        }
        TLRPC$TL_photo tLRPC$TL_photo = new TLRPC$TL_photo();
        tLRPC$TL_photo.file_reference = new byte[0];
        tLRPC$TL_photo.id = fileInlineObject.file_id;
        tLRPC$TL_photo.cdnTag = fileInlineObject.cdn_tag;
        if (fileInlineObject.access_hash_rec != null) {
            tLRPC$TL_photo.access_hash = IdStorage.getInstance().generateAccessHash(fileInlineObject.access_hash_rec);
        }
        if (fileInlineObject.dc_id != null) {
            tLRPC$TL_photo.dc_id = IdStorage.getInstance().generateDcId(fileInlineObject.dc_id);
        }
        if (str != null) {
            tLRPC$TL_photo.caption = str;
        }
        tLRPC$TL_photo.sizes = new ArrayList<>();
        tLRPC$TL_photo.date = fileInlineObject.time;
        tLRPC$TL_photo.video_sizes = new ArrayList<>();
        tLRPC$TL_photo.sizes = getPhotoSizes(fileInlineObject, i);
        return tLRPC$TL_photo;
    }

    private static ArrayList<TLRPC$VideoSize> getVideoSizes(FileInlineObject fileInlineObject) {
        ArrayList<TLRPC$VideoSize> arrayList = new ArrayList<>();
        TLRPC$TL_videoSize tLRPC$TL_videoSize = new TLRPC$TL_videoSize();
        tLRPC$TL_videoSize.size = (int) fileInlineObject.size;
        tLRPC$TL_videoSize.h = fileInlineObject.height;
        tLRPC$TL_videoSize.w = fileInlineObject.width;
        tLRPC$TL_videoSize.type = "v";
        TLRPC$TL_fileLocationToBeDeprecated tLRPC$TL_fileLocationToBeDeprecated = new TLRPC$TL_fileLocationToBeDeprecated();
        tLRPC$TL_videoSize.location = tLRPC$TL_fileLocationToBeDeprecated;
        tLRPC$TL_fileLocationToBeDeprecated.local_id = 2;
        tLRPC$TL_fileLocationToBeDeprecated.volume_id = fileInlineObject.file_id;
        arrayList.add(tLRPC$TL_videoSize);
        return arrayList;
    }

    public static ArrayList<TLRPC$PhotoSize> getPhotoSizes(FileInlineObject fileInlineObject, int i) {
        ArrayList<TLRPC$PhotoSize> arrayList = new ArrayList<>();
        if (fileInlineObject == null) {
            return arrayList;
        }
        boolean z = true;
        String str = fileInlineObject.thumb_inline;
        if (str == null || str.length() == 0) {
            z = false;
        } else {
            arrayList.add(getStrippedSize(fileInlineObject.thumb_inline, false));
        }
        if (fileInlineObject.type == FileInlineObject.FileInlineType.Image || (fileInlineObject instanceof AvatarFileInline)) {
            arrayList.add(getPhotoSize(fileInlineObject, z, i));
        }
        return arrayList;
    }

    private static TLRPC$PhotoSize getPhotoSize(FileInlineObject fileInlineObject, boolean z, int i) {
        TLRPC$PhotoSize tLRPC$TL_photoSize;
        int i2 = fileInlineObject.height;
        if (i2 == 0) {
            i2 = 90;
        }
        String str = i2 <= 320 ? "m" : i2 <= 800 ? "x" : i2 <= 1280 ? "y" : i2 <= 2560 ? "w" : BuildConfig.FLAVOR;
        if (z) {
            tLRPC$TL_photoSize = new TLRPC$TL_photoSizeProgressive();
        } else {
            tLRPC$TL_photoSize = new TLRPC$TL_photoSize();
        }
        tLRPC$TL_photoSize.h = fileInlineObject.height;
        tLRPC$TL_photoSize.w = fileInlineObject.width;
        tLRPC$TL_photoSize.type = str;
        tLRPC$TL_photoSize.size = (int) fileInlineObject.size;
        TLRPC$TL_fileLocationToBeDeprecated tLRPC$TL_fileLocationToBeDeprecated = new TLRPC$TL_fileLocationToBeDeprecated();
        tLRPC$TL_photoSize.location = tLRPC$TL_fileLocationToBeDeprecated;
        if (i == 0) {
            i = 2;
        }
        tLRPC$TL_fileLocationToBeDeprecated.local_id = i;
        long j = fileInlineObject.file_id;
        if (j == 0) {
            j = -2147483648L;
        }
        tLRPC$TL_fileLocationToBeDeprecated.volume_id = j;
        return tLRPC$TL_photoSize;
    }

    public static TLRPC$PhotoSize getStrippedSize(String str, boolean z) {
        TLRPC$PhotoSize tLRPC$TL_photoPathSize = z ? new TLRPC$TL_photoPathSize() : new TLRPC$TL_photoStrippedSize();
        tLRPC$TL_photoPathSize.h = 50;
        tLRPC$TL_photoPathSize.w = 50;
        tLRPC$TL_photoPathSize.type = z ? "j" : "i";
        if (str != null) {
            try {
                byte[] bArrDecode = Base64.decode(str, 0);
                tLRPC$TL_photoPathSize.bytes = bArrDecode;
                tLRPC$TL_photoPathSize.size = bArrDecode.length;
            } catch (Exception unused) {
                tLRPC$TL_photoPathSize.bytes = new byte[0];
                tLRPC$TL_photoPathSize.size = 0;
            }
        }
        return tLRPC$TL_photoPathSize;
    }

    private static TLRPC$Message convertToMessageService(CoreMainClass coreMainClass, Message message, long j, boolean z) {
        TLRPC$MessageAction tLRPC$TL_messageActionCustomAction;
        TLRPC$MessageAction tLRPC$TL_messageActionCustomAction2;
        TLRPC$TL_messageService tLRPC$TL_messageService = new TLRPC$TL_messageService();
        tLRPC$TL_messageService.dialog_id = j;
        if (message.type == Message.MessageTypeEnum.Call) {
            tLRPC$TL_messageActionCustomAction2 = new TLRPC$TL_messageActionPhoneCall();
            MessageCallData messageCallData = message.message_call;
            if (messageCallData != null) {
                tLRPC$TL_messageActionCustomAction2.call_id = messageCallData.call_id;
                tLRPC$TL_messageActionCustomAction2.duration = messageCallData.duration;
                tLRPC$TL_messageActionCustomAction2.reason = getCallReason(messageCallData.discard_reason);
            }
        } else {
            Message.EventObject eventObject = message.event_data;
            if (eventObject == null) {
                tLRPC$TL_messageActionCustomAction2 = new TLRPC$TL_messageActionCustomAction();
                tLRPC$TL_messageActionCustomAction2.message = message.text;
            } else {
                Message.EventType eventType = eventObject.type;
                if (eventType == Message.EventType.GroupCreated) {
                    tLRPC$TL_messageActionCustomAction = new TLRPC$TL_messageActionChatCreate();
                } else if (eventType == Message.EventType.ChannelCreated) {
                    tLRPC$TL_messageActionCustomAction = new TLRPC$TL_messageActionChannelCreate();
                } else if (eventType == Message.EventType.AddedGroupMembers) {
                    tLRPC$TL_messageActionCustomAction = new TLRPC$TL_messageActionChatAddUser();
                } else if (eventType == Message.EventType.RemoveGroupMembers) {
                    tLRPC$TL_messageActionCustomAction = new TLRPC$TL_messageActionChatDeleteUser();
                } else if (eventType == Message.EventType.PhotoUpdate) {
                    tLRPC$TL_messageActionCustomAction = new TLRPC$TL_messageActionChatEditPhoto();
                } else if (eventType == Message.EventType.TitleUpdate) {
                    tLRPC$TL_messageActionCustomAction = new TLRPC$TL_messageActionChatEditTitle();
                } else if (eventType == Message.EventType.JoinedGroupByLink) {
                    tLRPC$TL_messageActionCustomAction = new TLRPC$TL_messageActionChatJoinedByLink();
                } else if (eventType == Message.EventType.PinnedMessageUpdated) {
                    TLRPC$TL_messageActionPinMessage tLRPC$TL_messageActionPinMessage = new TLRPC$TL_messageActionPinMessage();
                    TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
                    tLRPC$TL_messageService.reply_to = tLRPC$TL_messageReplyHeader;
                    tLRPC$TL_messageReplyHeader.reply_to_msg_id = message.event_data.pinned_message_id;
                    Message messageInstant = coreMainClass.getMessageInstant(IdStorage.getInstance().getDialogId(j), message.event_data.pinned_message_id);
                    if (messageInstant != null) {
                        tLRPC$TL_messageService.replyMessage = convertToTlMessage(coreMainClass, j, z, messageInstant, null);
                    }
                    tLRPC$TL_messageActionCustomAction = tLRPC$TL_messageActionPinMessage;
                } else if (eventType == Message.EventType.LeaveGroup) {
                    tLRPC$TL_messageActionCustomAction = new TLRPC$TL_messageActionChatDeleteUser();
                } else if (eventType == Message.EventType.RemovePhoto) {
                    tLRPC$TL_messageActionCustomAction = new TLRPC$TL_messageActionChatDeletePhoto();
                } else if (eventType == Message.EventType.CreateGroupVoiceChat) {
                    tLRPC$TL_messageActionCustomAction = new TLRPC$TL_messageActionGroupCall();
                } else if (eventType == Message.EventType.CreateGroupVoiceChatChannel) {
                    tLRPC$TL_messageActionCustomAction = new TLRPC$TL_messageActionGroupCall();
                    tLRPC$TL_messageActionCustomAction.duration = message.event_data.group_voice_chat_duration;
                } else if (eventType == Message.EventType.StopGroupVoiceChat) {
                    tLRPC$TL_messageActionCustomAction = new TLRPC$TL_messageActionGroupCall();
                    tLRPC$TL_messageActionCustomAction.duration = message.event_data.group_voice_chat_duration;
                } else {
                    tLRPC$TL_messageActionCustomAction = new TLRPC$TL_messageActionCustomAction();
                }
                Message.EventObject eventObject2 = message.event_data;
                AvatarFileInline avatarFileInline = eventObject2.avatar;
                if (avatarFileInline != null) {
                    tLRPC$TL_messageActionCustomAction.photo = convertToPhoto(avatarFileInline, null, 0);
                } else {
                    AvatarFileInline avatarFileInline2 = eventObject2.avatar_thumbnail;
                    if (avatarFileInline2 != null) {
                        tLRPC$TL_messageActionCustomAction.photo = convertToPhoto(avatarFileInline2, null, 0);
                    }
                }
                ArrayList<ObjectGuidType> arrayList = message.event_data.peer_objects;
                if (arrayList != null && !arrayList.isEmpty()) {
                    Iterator<ObjectGuidType> it = message.event_data.peer_objects.iterator();
                    while (it.hasNext()) {
                        ObjectGuidType next = it.next();
                        ChatType chatType = next.type;
                        if (chatType == ChatType.User || chatType == ChatType.Bot || chatType == ChatType.Service) {
                            tLRPC$TL_messageActionCustomAction.users.add(Integer.valueOf((int) IdStorage.getInstance().generateDialogId(next.object_guid)));
                        }
                    }
                    if (message.event_data.peer_objects.size() == 1) {
                        ObjectGuidType objectGuidType = message.event_data.peer_objects.get(0);
                        ChatType chatType2 = objectGuidType.type;
                        if (chatType2 == ChatType.User || chatType2 == ChatType.Bot || chatType2 == ChatType.Service) {
                            tLRPC$TL_messageActionCustomAction.user_id = (int) IdStorage.getInstance().generateDialogId(objectGuidType.object_guid);
                        } else {
                            tLRPC$TL_messageActionCustomAction.channel_id = -((int) IdStorage.getInstance().generateNegativeDialogId(objectGuidType.object_guid));
                        }
                    }
                } else {
                    ObjectGuidType objectGuidType2 = message.event_data.performer_object;
                    if (objectGuidType2 != null) {
                        ChatType chatType3 = objectGuidType2.type;
                        if (chatType3 == ChatType.User || chatType3 == ChatType.Bot || chatType3 == ChatType.Service) {
                            tLRPC$TL_messageActionCustomAction.user_id = (int) IdStorage.getInstance().generateDialogId(message.event_data.performer_object.object_guid);
                        } else {
                            tLRPC$TL_messageActionCustomAction.channel_id = -((int) IdStorage.getInstance().generateNegativeDialogId(message.event_data.performer_object.object_guid));
                        }
                        tLRPC$TL_messageService.out = message.event_data.performer_object.object_guid.equals(coreMainClass.getMyGuid());
                    }
                }
                tLRPC$TL_messageActionCustomAction.title = message.event_data.title;
                tLRPC$TL_messageActionCustomAction.message = message.text;
                tLRPC$TL_messageActionCustomAction2 = tLRPC$TL_messageActionCustomAction;
            }
        }
        tLRPC$TL_messageService.action = tLRPC$TL_messageActionCustomAction2;
        tLRPC$TL_messageService.date = (int) message.time;
        tLRPC$TL_messageService.id = message.message_id;
        MetaDataObject metaDataObject = message.metadata;
        if (metaDataObject != null) {
            tLRPC$TL_messageService.entities = convertAllMetaDataToEntities(metaDataObject);
        }
        return tLRPC$TL_messageService;
    }

    /* renamed from: androidMessenger.utilites.MessageConverter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$ir$aaap$messengercore$model$Message$AuthorTypeEnum;
        static final /* synthetic */ int[] $SwitchMap$ir$aaap$messengercore$model$MessageCallData$DiscardReasonEnum;

        static {
            int[] iArr = new int[MessageCallData.DiscardReasonEnum.values().length];
            $SwitchMap$ir$aaap$messengercore$model$MessageCallData$DiscardReasonEnum = iArr;
            try {
                iArr[MessageCallData.DiscardReasonEnum.Busy.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$model$MessageCallData$DiscardReasonEnum[MessageCallData.DiscardReasonEnum.Hangup.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$model$MessageCallData$DiscardReasonEnum[MessageCallData.DiscardReasonEnum.Missed.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$model$MessageCallData$DiscardReasonEnum[MessageCallData.DiscardReasonEnum.Disconnect.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$model$MessageCallData$DiscardReasonEnum[MessageCallData.DiscardReasonEnum.NotDiscarded.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[Message.AuthorTypeEnum.values().length];
            $SwitchMap$ir$aaap$messengercore$model$Message$AuthorTypeEnum = iArr2;
            try {
                iArr2[Message.AuthorTypeEnum.User.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$ir$aaap$messengercore$model$Message$AuthorTypeEnum[Message.AuthorTypeEnum.Bot.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private static TLRPC$PhoneCallDiscardReason getCallReason(MessageCallData.DiscardReasonEnum discardReasonEnum) {
        if (discardReasonEnum == null) {
            return null;
        }
        int i = AnonymousClass1.$SwitchMap$ir$aaap$messengercore$model$MessageCallData$DiscardReasonEnum[discardReasonEnum.ordinal()];
        if (i == 1) {
            return new TLRPC$TL_phoneCallDiscardReasonBusy();
        }
        if (i == 2) {
            return new TLRPC$TL_phoneCallDiscardReasonHangup();
        }
        if (i == 3) {
            return new TLRPC$TL_phoneCallDiscardReasonMissed();
        }
        if (i != 4) {
            return null;
        }
        return new TLRPC$TL_phoneCallDiscardReasonDisconnect();
    }

    public static TLRPC$photos_Photos convertAvatars(ArrayList<AvatarObject> arrayList) {
        TLRPC$TL_photos_photos tLRPC$TL_photos_photos = new TLRPC$TL_photos_photos();
        ArrayList<TLRPC$Photo> arrayList2 = new ArrayList<>();
        Iterator<AvatarObject> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(convertAvatar(it.next()));
        }
        tLRPC$TL_photos_photos.photos = arrayList2;
        return tLRPC$TL_photos_photos;
    }

    public static TLRPC$Photo convertAvatar(AvatarObject avatarObject) {
        TLRPC$Photo tLRPC$PhotoConvertToPhoto = convertToPhoto(avatarObject.main, null, 0);
        tLRPC$PhotoConvertToPhoto.avatr_id = avatarObject.avatar_id;
        AvatarFileInline avatarFileInline = avatarObject.main;
        tLRPC$PhotoConvertToPhoto.main_file_id = avatarFileInline != null ? avatarFileInline.file_id : 0L;
        AvatarFileInline avatarFileInline2 = avatarObject.thumbnail;
        if (avatarFileInline2 != null) {
            long j = avatarFileInline2.file_id;
        }
        tLRPC$PhotoConvertToPhoto.file_reference = new byte[0];
        return tLRPC$PhotoConvertToPhoto;
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x0373  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static ir.aaap.messengercore.model.Message convertToCoreMessage(ir.aaap.messengercore.CoreMainClass r14, org.rbmain.tgnet.TLRPC$Message r15) {
        /*
            Method dump skipped, instructions count: 1162
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidMessenger.utilites.MessageConverter.convertToCoreMessage(ir.aaap.messengercore.CoreMainClass, org.rbmain.tgnet.TLRPC$Message):ir.aaap.messengercore.model.Message");
    }

    private static void checkForInput(Message message, TLRPC$Message tLRPC$Message) {
        Message.MessageTypeEnum messageTypeEnum;
        if (message == null || tLRPC$Message == null) {
            return;
        }
        try {
            FileInlineObject fileInlineObject = message.file_inline;
            if (fileInlineObject != null && (((messageTypeEnum = message.type) == Message.MessageTypeEnum.FileInline || messageTypeEnum == Message.MessageTypeEnum.FileInlineCaption) && fileInlineObject.type == FileInlineObject.FileInlineType.File && fileInlineObject.size <= 0 && fileInlineObject.time == 0 && CallProxy$$ExternalSyntheticBackport0.m(fileInlineObject.dc_id, "0"))) {
                try {
                    FirebaseEventSender.recordException(new InvalidInputException("EMPTY FILE" + ApplicationLoader.getGson().toJson(tLRPC$Message)));
                } catch (Exception e) {
                    FirebaseEventSender.recordException(new InvalidInputException("EMPTY FILE Crash:\t" + e.getMessage()));
                }
            }
        } catch (Exception unused) {
        }
    }

    private static String getMediaFileName(String str, boolean z) {
        String str2;
        Date date = new Date();
        date.setTime(System.currentTimeMillis() + Utilities.random.nextInt(CloseCodes.NORMAL_CLOSURE) + 1);
        String str3 = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS", Locale.US).format(date);
        StringBuilder sb = new StringBuilder();
        sb.append(z ? "VIDEO_" : "VOICE_");
        sb.append(str3);
        if (str != null) {
            str2 = "." + str;
        } else {
            str2 = BuildConfig.FLAVOR;
        }
        sb.append(str2);
        return sb.toString();
    }

    private static ContactMessageObject convertMediaToContactMessage(TLRPC$MessageMedia tLRPC$MessageMedia) {
        if (tLRPC$MessageMedia == null) {
            return null;
        }
        ContactMessageObject contactMessageObject = new ContactMessageObject();
        String str = tLRPC$MessageMedia.first_name;
        String str2 = BuildConfig.FLAVOR;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        contactMessageObject.first_name = str;
        String str3 = tLRPC$MessageMedia.last_name;
        if (str3 != null) {
            str2 = str3;
        }
        contactMessageObject.last_name = str2;
        contactMessageObject.phone_number = !TextUtils.isEmpty(tLRPC$MessageMedia.phone_number) ? tLRPC$MessageMedia.phone_number : null;
        contactMessageObject.vcard = TextUtils.isEmpty(tLRPC$MessageMedia.vcard) ? null : tLRPC$MessageMedia.vcard;
        contactMessageObject.user_guid = IdStorage.getInstance().getDialogId(tLRPC$MessageMedia.user_id);
        return contactMessageObject;
    }

    public static PollObject convertTlPollToPollObject(TLRPC$MessageMedia tLRPC$MessageMedia, String str) {
        int i;
        HashSet hashSet = null;
        if (!(tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPoll)) {
            return null;
        }
        TLRPC$TL_messageMediaPoll tLRPC$TL_messageMediaPoll = (TLRPC$TL_messageMediaPoll) tLRPC$MessageMedia;
        TLRPC$Poll tLRPC$Poll = tLRPC$TL_messageMediaPoll.poll;
        TLRPC$PollResults tLRPC$PollResults = tLRPC$TL_messageMediaPoll.results;
        if (tLRPC$Poll == null) {
            return null;
        }
        PollObject pollObject = new PollObject();
        pollObject.options = new ArrayList<>();
        pollObject.question = tLRPC$Poll.question;
        pollObject.is_anonymous = !tLRPC$Poll.public_voters;
        pollObject.type = tLRPC$Poll.quiz ? PollObject.QuizTypeEnum.Quiz : PollObject.QuizTypeEnum.Regular;
        pollObject.close_period = tLRPC$Poll.close_period;
        pollObject.allows_multiple_answers = tLRPC$Poll.multiple_choice;
        byte[] bArrHexToBytes = str != null ? Utilities.hexToBytes(str) : null;
        if (bArrHexToBytes != null && bArrHexToBytes.length > 0) {
            hashSet = new HashSet();
            for (byte b : bArrHexToBytes) {
                hashSet.add(Character.valueOf((char) b));
            }
        }
        if (tLRPC$Poll.answers != null) {
            i = -1;
            for (int i2 = 0; i2 < tLRPC$Poll.answers.size(); i2++) {
                TLRPC$TL_pollAnswer tLRPC$TL_pollAnswer = tLRPC$Poll.answers.get(i2);
                pollObject.options.add(tLRPC$TL_pollAnswer.text);
                if (i == -1 && tLRPC$Poll.quiz && hashSet != null && !hashSet.isEmpty()) {
                    i = hashSet.contains(Character.valueOf((char) tLRPC$TL_pollAnswer.option[0])) ? i2 : -1;
                }
            }
        } else {
            i = -1;
        }
        if (tLRPC$PollResults != null) {
            pollObject.explanationTemp = tLRPC$PollResults.solution;
        }
        if (i != -1) {
            pollObject.correctOptionIndexLocal = Integer.valueOf(i);
        }
        return pollObject;
    }

    private static int getThumbLocalId(List<TLRPC$PhotoSize> list) {
        TLRPC$FileLocation tLRPC$FileLocation;
        int i = 0;
        for (TLRPC$PhotoSize tLRPC$PhotoSize : list) {
            if (!(tLRPC$PhotoSize instanceof TLRPC$TL_photoStrippedSize) && (tLRPC$FileLocation = tLRPC$PhotoSize.location) != null) {
                i = tLRPC$FileLocation.local_id;
            }
        }
        return i;
    }

    private static TLRPC$DocumentAttribute getVideoAttribute(ArrayList<TLRPC$DocumentAttribute> arrayList) {
        Iterator<TLRPC$DocumentAttribute> it = arrayList.iterator();
        while (it.hasNext()) {
            TLRPC$DocumentAttribute next = it.next();
            if (next instanceof TLRPC$TL_documentAttributeVideo) {
                return next;
            }
        }
        return null;
    }

    private static TLRPC$DocumentAttribute getAudioAttribute(ArrayList<TLRPC$DocumentAttribute> arrayList) {
        Iterator<TLRPC$DocumentAttribute> it = arrayList.iterator();
        while (it.hasNext()) {
            TLRPC$DocumentAttribute next = it.next();
            if (next instanceof TLRPC$TL_documentAttributeAudio) {
                return next;
            }
        }
        return null;
    }

    private static TLRPC$DocumentAttribute getStickerAttribute(ArrayList<TLRPC$DocumentAttribute> arrayList) {
        Iterator<TLRPC$DocumentAttribute> it = arrayList.iterator();
        while (it.hasNext()) {
            TLRPC$DocumentAttribute next = it.next();
            if (next instanceof TLRPC$TL_documentAttributeSticker) {
                return next;
            }
        }
        return null;
    }

    private static TLRPC$DocumentAttribute getImageSizeAttribute(ArrayList<TLRPC$DocumentAttribute> arrayList) {
        Iterator<TLRPC$DocumentAttribute> it = arrayList.iterator();
        while (it.hasNext()) {
            TLRPC$DocumentAttribute next = it.next();
            if (next instanceof TLRPC$TL_documentAttributeImageSize) {
                return next;
            }
        }
        return null;
    }

    private static FileInlineObject.FileInlineType getFileType(TLRPC$Document tLRPC$Document) {
        if (MessageObject.isVideoDocument(tLRPC$Document) || MessageObject.isRoundVideoDocument(tLRPC$Document)) {
            return FileInlineObject.FileInlineType.Video;
        }
        if (MessageObject.isGifDocument(tLRPC$Document) && isGifValid(tLRPC$Document)) {
            return FileInlineObject.FileInlineType.Gif;
        }
        if (MessageObject.isMusicDocument(tLRPC$Document)) {
            return FileInlineObject.FileInlineType.Music;
        }
        if (MessageObject.isVoiceDocument(tLRPC$Document)) {
            return FileInlineObject.FileInlineType.Voice;
        }
        return FileInlineObject.FileInlineType.File;
    }

    public static String getFileName(String str, ArrayList<TLRPC$DocumentAttribute> arrayList) {
        if (arrayList != null) {
            Iterator<TLRPC$DocumentAttribute> it = arrayList.iterator();
            while (it.hasNext()) {
                TLRPC$DocumentAttribute next = it.next();
                if (next instanceof TLRPC$TL_documentAttributeFilename) {
                    str = next.file_name;
                }
            }
        }
        if (TextUtils.isEmpty(str)) {
            return "file";
        }
        String[] strArrSplit = str.split("/");
        return strArrSplit.length > 0 ? strArrSplit[strArrSplit.length - 1] : "file";
    }

    private static String getThumbInline(ArrayList<TLRPC$PhotoSize> arrayList) {
        String strEncodeToString;
        try {
            strEncodeToString = Base64.encodeToString(FileLoader.getClosestPhotoSizeWithSize(arrayList, 90).bytes, 0);
        } catch (Exception unused) {
            strEncodeToString = null;
        }
        if (strEncodeToString == null && MyLog.isDebugAble) {
            MyLog.handleExceptionThrowOnDebug(new Exception("thumb_inline is null"));
        }
        return strEncodeToString;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0062 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String getVideoThumbnail(java.util.ArrayList<org.rbmain.tgnet.TLRPC$PhotoSize> r6) throws java.io.IOException {
        /*
            java.lang.String r0 = "/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDABALDA4MChAODQ4SERATGCgaGBYWGDEjJR0oOjM9PDkzODdASFxOQERXRTc4UG1RV19iZ2hnPk1xeXBkeFxlZ2P/2wBDARESEhgVGC8aGi9jQjhCY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2P/wAARCAB3AJEDASIAAhEBAxEB/8QAFQABAQAAAAAAAAAAAAAAAAAAAAb/xAAUEAEAAAAAAAAAAAAAAAAAAAAA/8QAFAEBAAAAAAAAAAAAAAAAAAAAAP/EABQRAQAAAAAAAAAAAAAAAAAAAAD/2gAMAwEAAhEDEQA/ALsAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH/2Q=="
            if (r6 == 0) goto L64
            boolean r1 = r6.isEmpty()
            if (r1 == 0) goto Lb
            goto L64
        Lb:
            r1 = 50
            org.rbmain.tgnet.TLRPC$PhotoSize r6 = org.rbmain.messenger.FileLoader.getClosestPhotoSizeWithSize(r6, r1)
            r1 = 0
            if (r6 == 0) goto L20
            byte[] r2 = r6.bytes
            if (r2 == 0) goto L20
            int r3 = r2.length
            if (r3 <= 0) goto L20
            java.lang.String r6 = android.util.Base64.encodeToString(r2, r1)
            return r6
        L20:
            if (r6 == 0) goto L64
            org.rbmain.tgnet.TLRPC$FileLocation r6 = r6.location
            if (r6 != 0) goto L27
            goto L64
        L27:
            r2 = 1
            java.io.File r6 = org.rbmain.messenger.FileLoader.getPathToAttach(r6, r2)
            boolean r2 = r6.exists()
            r3 = 0
            if (r2 == 0) goto L5c
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch: java.lang.Exception -> L4d
            java.lang.String r4 = "r"
            r2.<init>(r6, r4)     // Catch: java.lang.Exception -> L4d
            long r4 = r2.length()     // Catch: java.lang.Exception -> L4b
            int r6 = (int) r4     // Catch: java.lang.Exception -> L4b
            byte[] r4 = new byte[r6]     // Catch: java.lang.Exception -> L4b
            r2.readFully(r4)     // Catch: java.lang.Exception -> L4b
            if (r6 <= 0) goto L52
            java.lang.String r3 = android.util.Base64.encodeToString(r4, r1)     // Catch: java.lang.Exception -> L4b
            goto L52
        L4b:
            r6 = move-exception
            goto L4f
        L4d:
            r6 = move-exception
            r2 = r3
        L4f:
            r6.printStackTrace()
        L52:
            if (r2 == 0) goto L5c
            r2.close()     // Catch: java.io.IOException -> L58
            goto L5c
        L58:
            r6 = move-exception
            r6.printStackTrace()
        L5c:
            boolean r6 = android.text.TextUtils.isEmpty(r3)
            if (r6 == 0) goto L63
            return r0
        L63:
            return r3
        L64:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidMessenger.utilites.MessageConverter.getVideoThumbnail(java.util.ArrayList):java.lang.String");
    }

    public static ArrayList<TLRPC$Message> convertAllMessages(CoreMainClass coreMainClass, ArrayList<Message> arrayList, ArrayList<TLRPC$User> arrayList2) {
        String str;
        long jGenerateDialogId;
        ArrayList<TLRPC$Message> arrayList3 = new ArrayList<>();
        LongSparseArray longSparseArray = arrayList2 != null ? new LongSparseArray() : null;
        Iterator<Message> it = arrayList.iterator();
        while (it.hasNext()) {
            Message next = it.next();
            Message.LocalParametersObject localParametersObject = next.localParametersObject;
            if (localParametersObject != null && (str = localParametersObject.toGuid) != null && !str.isEmpty()) {
                ChatType chatType = next.localParametersObject.chatType;
                if (chatType == ChatType.User || chatType == ChatType.Bot || chatType == ChatType.Service) {
                    jGenerateDialogId = IdStorage.getInstance().generateDialogId(str);
                } else {
                    jGenerateDialogId = IdStorage.getInstance().generateNegativeDialogId(str);
                }
                TLRPC$Message tLRPC$MessageConvertToTlMessage = convertToTlMessage(coreMainClass, jGenerateDialogId, chatType == ChatType.Channel, next, longSparseArray);
                tLRPC$MessageConvertToTlMessage.chatType = chatType;
                if (longSparseArray != null && longSparseArray.size() > 0) {
                    for (int i = 0; i < longSparseArray.size(); i++) {
                        arrayList2.add((TLRPC$User) longSparseArray.valueAt(i));
                    }
                }
                arrayList3.add(tLRPC$MessageConvertToTlMessage);
            }
        }
        return arrayList3;
    }

    public static ArrayList<TLRPC$Document> convertAllStickersToDocuments(ArrayList<StickerObject> arrayList) {
        ArrayList<TLRPC$Document> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            Iterator<StickerObject> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(convertStickerToDocument(it.next()));
            }
        }
        return arrayList2;
    }

    public static ArrayList<StickerObject> convertAllDocumentsToStickers(ArrayList<TLRPC$Document> arrayList) {
        ArrayList<StickerObject> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            Iterator<TLRPC$Document> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(convertDocumentToSticker(it.next()));
            }
        }
        return arrayList2;
    }

    public static StickerObject convertDocumentToSticker(TLRPC$Document tLRPC$Document) {
        StickerObject stickerObject = new StickerObject();
        AvatarFileInline avatarFileInline = new AvatarFileInline();
        convertDocumentToFileInlineCommonFields(tLRPC$Document, avatarFileInline);
        avatarFileInline.mime = "image/webp";
        stickerObject.file = avatarFileInline;
        TLRPC$DocumentAttribute stickerAttribute = getStickerAttribute(tLRPC$Document.attributes);
        TLRPC$DocumentAttribute imageSizeAttribute = getImageSizeAttribute(tLRPC$Document.attributes);
        if (stickerAttribute != null && stickerAttribute.stickerset != null) {
            stickerObject.emoji_character = stickerAttribute.alt;
            stickerObject.sticker_id = stickerAttribute.stickerId;
            stickerObject.sticker_set_id = IdStorage.getInstance().getStickerSetId(stickerAttribute.stickerset.id);
        }
        if (imageSizeAttribute != null) {
            stickerObject.w_h_ratio = (imageSizeAttribute.w * 1.0f) / imageSizeAttribute.h;
        }
        return stickerObject;
    }

    public static TLRPC$Document convertStickerToDocument(StickerObject stickerObject) {
        TLRPC$Document tLRPC$DocumentConvertFileInlineToDocumentCommonFields = convertFileInlineToDocumentCommonFields(stickerObject.file);
        tLRPC$DocumentConvertFileInlineToDocumentCommonFields.file_reference = new byte[0];
        ArrayList<TLRPC$DocumentAttribute> arrayList = new ArrayList<>();
        TLRPC$TL_documentAttributeImageSize tLRPC$TL_documentAttributeImageSize = new TLRPC$TL_documentAttributeImageSize();
        tLRPC$TL_documentAttributeImageSize.h = 90;
        tLRPC$TL_documentAttributeImageSize.w = (int) (stickerObject.w_h_ratio * 90);
        arrayList.add(tLRPC$TL_documentAttributeImageSize);
        TLRPC$TL_documentAttributeSticker tLRPC$TL_documentAttributeSticker = new TLRPC$TL_documentAttributeSticker();
        tLRPC$TL_documentAttributeSticker.stickerId = stickerObject.sticker_id;
        tLRPC$TL_documentAttributeSticker.alt = stickerObject.emoji_character;
        TLRPC$TL_inputStickerSetID tLRPC$TL_inputStickerSetID = new TLRPC$TL_inputStickerSetID();
        tLRPC$TL_documentAttributeSticker.stickerset = tLRPC$TL_inputStickerSetID;
        tLRPC$TL_inputStickerSetID.id = IdStorage.getInstance().generateStickerSetId(stickerObject.sticker_set_id);
        tLRPC$DocumentConvertFileInlineToDocumentCommonFields.mime_type = "image/webp";
        arrayList.add(tLRPC$TL_documentAttributeSticker);
        ArrayList<TLRPC$PhotoSize> arrayList2 = new ArrayList<>();
        tLRPC$DocumentConvertFileInlineToDocumentCommonFields.thumbs = arrayList2;
        arrayList2.add(getStrippedSize(stickerObject.file.thumb_inline, true));
        tLRPC$DocumentConvertFileInlineToDocumentCommonFields.thumbs.add(getPhotoSize(stickerObject.file, false, 0));
        tLRPC$DocumentConvertFileInlineToDocumentCommonFields.attributes = arrayList;
        return tLRPC$DocumentConvertFileInlineToDocumentCommonFields;
    }

    public static FileInlineObject convertDocumentToGifFileInline(TLRPC$Document tLRPC$Document) {
        TLRPC$DocumentAttribute videoAttribute;
        FileInlineObject fileInlineObject = new FileInlineObject();
        FileInlineObject.FileInlineType fileInlineType = FileInlineObject.FileInlineType.Gif;
        fileInlineObject.type = fileInlineType;
        convertDocumentToFileInlineCommonFields(tLRPC$Document, fileInlineObject);
        FileInlineObject.FileInlineType fileInlineType2 = fileInlineObject.type;
        if ((fileInlineType2 == FileInlineObject.FileInlineType.Video || fileInlineType2 == fileInlineType) && (videoAttribute = getVideoAttribute(tLRPC$Document.attributes)) != null) {
            fileInlineObject.time = Math.max(videoAttribute.duration * CloseCodes.NORMAL_CLOSURE, 1);
            fileInlineObject.height = videoAttribute.h;
            fileInlineObject.width = videoAttribute.w;
            fileInlineObject.file_name = MediaStreamTrack.VIDEO_TRACK_KIND;
            fileInlineObject.thumb_inline = getVideoThumbnail(tLRPC$Document.thumbs);
        }
        String fileName = getFileName("gif.mp4", tLRPC$Document.attributes);
        fileInlineObject.file_name = fileName;
        fileInlineObject.mime = FileLoader.getMime(fileName);
        return fileInlineObject;
    }

    public static ArrayList<TLRPC$Document> convertAllRecentGifsToDocument(ArrayList<FileInlineObject> arrayList) {
        if (arrayList == null) {
            return new ArrayList<>();
        }
        ArrayList<TLRPC$Document> arrayList2 = new ArrayList<>();
        Iterator<FileInlineObject> it = arrayList.iterator();
        while (it.hasNext()) {
            FileInlineObject next = it.next();
            if (next != null) {
                arrayList2.add(convertGifFileInlineToDocument(next));
            }
        }
        Collections.reverse(arrayList2);
        return arrayList2;
    }

    private static void convertDocumentToFileInlineCommonFields(TLRPC$Document tLRPC$Document, FileInlineObject fileInlineObject) {
        if (tLRPC$Document == null || fileInlineObject == null) {
            return;
        }
        fileInlineObject.file_id = tLRPC$Document.id;
        fileInlineObject.cdn_tag = tLRPC$Document.cdnTag;
        fileInlineObject.dc_id = IdStorage.getInstance().getDcId(tLRPC$Document.dc_id);
        fileInlineObject.access_hash_rec = IdStorage.getInstance().getAccessHashId(tLRPC$Document.access_hash);
        fileInlineObject.size = tLRPC$Document.size;
    }

    private static TLRPC$Document convertFileInlineToDocumentCommonFields(FileInlineObject fileInlineObject) {
        TLRPC$TL_document tLRPC$TL_document = new TLRPC$TL_document();
        tLRPC$TL_document.id = fileInlineObject.file_id;
        tLRPC$TL_document.cdnTag = fileInlineObject.cdn_tag;
        if (fileInlineObject.dc_id != null) {
            tLRPC$TL_document.dc_id = IdStorage.getInstance().generateDcId(fileInlineObject.dc_id);
        }
        if (fileInlineObject.access_hash_rec != null) {
            tLRPC$TL_document.access_hash = IdStorage.getInstance().generateAccessHash(fileInlineObject.access_hash_rec);
        }
        tLRPC$TL_document.size = (int) fileInlineObject.size;
        return tLRPC$TL_document;
    }

    public static TLRPC$Document convertGifFileInlineToDocument(FileInlineObject fileInlineObject) {
        TLRPC$Document tLRPC$DocumentConvertFileInlineToDocumentCommonFields = convertFileInlineToDocumentCommonFields(fileInlineObject);
        tLRPC$DocumentConvertFileInlineToDocumentCommonFields.file_reference = new byte[0];
        tLRPC$DocumentConvertFileInlineToDocumentCommonFields.mime_type = fileInlineObject.mime;
        ArrayList<TLRPC$DocumentAttribute> arrayList = new ArrayList<>();
        FileInlineObject.FileInlineType fileInlineType = fileInlineObject.type;
        FileInlineObject.FileInlineType fileInlineType2 = FileInlineObject.FileInlineType.Video;
        if (fileInlineType == fileInlineType2 || fileInlineType == FileInlineObject.FileInlineType.Gif) {
            if (!tLRPC$DocumentConvertFileInlineToDocumentCommonFields.mime_type.contains("video/") && fileInlineObject.type == fileInlineType2) {
                tLRPC$DocumentConvertFileInlineToDocumentCommonFields.mime_type = "video/" + tLRPC$DocumentConvertFileInlineToDocumentCommonFields.mime_type;
            }
            if (!tLRPC$DocumentConvertFileInlineToDocumentCommonFields.mime_type.contains("video/") && fileInlineObject.type == FileInlineObject.FileInlineType.Gif) {
                tLRPC$DocumentConvertFileInlineToDocumentCommonFields.mime_type = "image/gif";
            }
            TLRPC$TL_documentAttributeVideo tLRPC$TL_documentAttributeVideo = new TLRPC$TL_documentAttributeVideo();
            tLRPC$TL_documentAttributeVideo.duration = (int) Math.ceil(fileInlineObject.time / 1000.0f);
            int i = fileInlineObject.height;
            if (i <= 0) {
                i = 80;
            }
            tLRPC$TL_documentAttributeVideo.h = i;
            int i2 = fileInlineObject.width;
            tLRPC$TL_documentAttributeVideo.w = i2 > 0 ? i2 : 80;
            tLRPC$TL_documentAttributeVideo.supports_streaming = true;
            arrayList.add(tLRPC$TL_documentAttributeVideo);
            tLRPC$DocumentConvertFileInlineToDocumentCommonFields.thumbs = new ArrayList<>();
            String str = fileInlineObject.thumb_inline;
            if (str != null) {
                tLRPC$DocumentConvertFileInlineToDocumentCommonFields.thumbs.add(getStrippedSize(str, false));
            }
            if (fileInlineObject.type == FileInlineObject.FileInlineType.Gif) {
                tLRPC$DocumentConvertFileInlineToDocumentCommonFields.video_thumbs = getVideoSizes(fileInlineObject);
            }
        }
        String str2 = fileInlineObject.file_name;
        if (str2 != null && !str2.isEmpty()) {
            TLRPC$TL_documentAttributeFilename tLRPC$TL_documentAttributeFilename = new TLRPC$TL_documentAttributeFilename();
            tLRPC$TL_documentAttributeFilename.file_name = fileInlineObject.file_name;
            arrayList.add(tLRPC$TL_documentAttributeFilename);
        }
        arrayList.add(new TLRPC$TL_documentAttributeAnimated());
        tLRPC$DocumentConvertFileInlineToDocumentCommonFields.attributes = arrayList;
        return tLRPC$DocumentConvertFileInlineToDocumentCommonFields;
    }

    public static TLRPC$TL_messages_stickerSet convertStickerSetAndSticker(StickerSetObject stickerSetObject, ArrayList<StickerObject> arrayList) {
        TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = new TLRPC$TL_messages_stickerSet();
        tLRPC$TL_messages_stickerSet.set = convertStickerSet(stickerSetObject);
        tLRPC$TL_messages_stickerSet.documents = convertAllStickersToDocuments(arrayList);
        return tLRPC$TL_messages_stickerSet;
    }

    public static TLRPC$StickerSet convertStickerSet(StickerSetObject stickerSetObject) {
        TLRPC$TL_stickerSet tLRPC$TL_stickerSet = new TLRPC$TL_stickerSet();
        tLRPC$TL_stickerSet.id = IdStorage.getInstance().generateStickerSetId(stickerSetObject.sticker_set_id);
        String str = stickerSetObject.title;
        tLRPC$TL_stickerSet.title = str;
        tLRPC$TL_stickerSet.short_name = str;
        tLRPC$TL_stickerSet.count = stickerSetObject.count_stickers;
        tLRPC$TL_stickerSet.shareString = stickerSetObject.share_string;
        return tLRPC$TL_stickerSet;
    }

    public static TLRPC$TL_messages_featuredStickers convertTrendStickerSet(GetStickersOutput getStickersOutput) {
        TLRPC$TL_messages_featuredStickers tLRPC$TL_messages_featuredStickers = new TLRPC$TL_messages_featuredStickers();
        tLRPC$TL_messages_featuredStickers.nextStartId = getStickersOutput.next_start_id;
        tLRPC$TL_messages_featuredStickers.hasContinue = getStickersOutput.has_continue;
        tLRPC$TL_messages_featuredStickers.sets = convertAllStickerSetsToCovered(getStickersOutput.sticker_sets);
        return tLRPC$TL_messages_featuredStickers;
    }

    public static TLRPC$TL_messages_foundStickerSets convertFoundStickerSet(GetStickersOutput getStickersOutput) {
        TLRPC$TL_messages_foundStickerSets tLRPC$TL_messages_foundStickerSets = new TLRPC$TL_messages_foundStickerSets();
        tLRPC$TL_messages_foundStickerSets.nextStartId = getStickersOutput.next_start_id;
        tLRPC$TL_messages_foundStickerSets.hasContinue = getStickersOutput.has_continue;
        tLRPC$TL_messages_foundStickerSets.sets = convertAllStickerSetsToCovered(getStickersOutput.sticker_sets);
        return tLRPC$TL_messages_foundStickerSets;
    }

    public static TLRPC$TL_messages_archivedStickers convertArchivedStickerSet(GetStickersOutput getStickersOutput) {
        TLRPC$TL_messages_archivedStickers tLRPC$TL_messages_archivedStickers = new TLRPC$TL_messages_archivedStickers();
        tLRPC$TL_messages_archivedStickers.nextStartId = getStickersOutput.next_start_id;
        tLRPC$TL_messages_archivedStickers.hasContinue = getStickersOutput.has_continue;
        tLRPC$TL_messages_archivedStickers.sets = convertAllStickerSetsToCovered(getStickersOutput.sticker_sets);
        return tLRPC$TL_messages_archivedStickers;
    }

    private static ArrayList<TLRPC$StickerSetCovered> convertAllStickerSetsToCovered(ArrayList<StickerSetObject> arrayList) {
        ArrayList<TLRPC$StickerSetCovered> arrayList2 = new ArrayList<>();
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<StickerSetObject> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(convertStickerSetToCovered(it.next()));
            }
        }
        return arrayList2;
    }

    private static TLRPC$StickerSetCovered convertStickerSetToCovered(StickerSetObject stickerSetObject) {
        TLRPC$TL_stickerSetCovered tLRPC$TL_stickerSetCovered = new TLRPC$TL_stickerSetCovered();
        tLRPC$TL_stickerSetCovered.covers = convertAllStickersToDocuments(stickerSetObject.top_stickers);
        tLRPC$TL_stickerSetCovered.set = convertStickerSet(stickerSetObject);
        AvatarFileInline avatarFileInline = stickerSetObject.set_image;
        if (avatarFileInline != null) {
            TLRPC$Document tLRPC$DocumentConvertFileInlineToDocumentCommonFields = convertFileInlineToDocumentCommonFields(avatarFileInline);
            tLRPC$DocumentConvertFileInlineToDocumentCommonFields.mime_type = stickerSetObject.set_image.mime;
            tLRPC$DocumentConvertFileInlineToDocumentCommonFields.mime_type = "image/webp";
            ArrayList<TLRPC$PhotoSize> arrayList = new ArrayList<>();
            tLRPC$DocumentConvertFileInlineToDocumentCommonFields.thumbs = arrayList;
            arrayList.add(getStrippedSize(stickerSetObject.set_image.thumb_inline, true));
            tLRPC$DocumentConvertFileInlineToDocumentCommonFields.thumbs.add(getPhotoSize(stickerSetObject.set_image, false, 0));
            tLRPC$TL_stickerSetCovered.cover = tLRPC$DocumentConvertFileInlineToDocumentCommonFields;
        }
        return tLRPC$TL_stickerSetCovered;
    }

    public static TLRPC$messages_Messages convertAllInSearchMessages(CoreMainClass coreMainClass, SearchGlobalMessagesOutput searchGlobalMessagesOutput) {
        TLRPC$TL_messages_messages tLRPC$TL_messages_messages = new TLRPC$TL_messages_messages();
        ArrayList<TLRPC$Chat> arrayList = new ArrayList<>();
        ArrayList<TLRPC$User> arrayList2 = new ArrayList<>();
        ArrayList<TLRPC$Message> arrayList3 = new ArrayList<>();
        ArrayList<InSearchMessage> arrayList4 = searchGlobalMessagesOutput.messages;
        if (arrayList4 != null) {
            Iterator<InSearchMessage> it = arrayList4.iterator();
            while (it.hasNext()) {
                convertInSearchMessage(coreMainClass, it.next(), arrayList, arrayList2, arrayList3);
            }
        }
        tLRPC$TL_messages_messages.chats = arrayList;
        tLRPC$TL_messages_messages.users = arrayList2;
        tLRPC$TL_messages_messages.messages = arrayList3;
        tLRPC$TL_messages_messages.nextStartId = searchGlobalMessagesOutput.next_start_id;
        tLRPC$TL_messages_messages.hasContinue = searchGlobalMessagesOutput.has_continue;
        return tLRPC$TL_messages_messages;
    }

    private static void convertInSearchMessage(CoreMainClass coreMainClass, InSearchMessage inSearchMessage, ArrayList<TLRPC$Chat> arrayList, ArrayList<TLRPC$User> arrayList2, ArrayList<TLRPC$Message> arrayList3) {
        TLRPC$User tLRPC$UserConvertBot;
        if (inSearchMessage == null || inSearchMessage.abs_object == null || inSearchMessage.message == null) {
            return;
        }
        long jGenerateDialogId = 0;
        ChatType chatType = inSearchMessage.type;
        ChatType chatType2 = ChatType.User;
        if (chatType == chatType2 || chatType == ChatType.Bot || chatType == ChatType.Service) {
            jGenerateDialogId = (int) IdStorage.getInstance().generateDialogId(inSearchMessage.object_guid);
            ChatType chatType3 = inSearchMessage.type;
            if (chatType3 == chatType2) {
                tLRPC$UserConvertBot = ChatConverter.convertUser(coreMainClass, jGenerateDialogId, inSearchMessage.abs_object, (UserInfo) null, (Chat) null);
            } else if (chatType3 == ChatType.Service) {
                tLRPC$UserConvertBot = ChatConverter.convertService(coreMainClass, jGenerateDialogId, inSearchMessage.abs_object, null, null);
            } else {
                tLRPC$UserConvertBot = ChatConverter.convertBot(coreMainClass, jGenerateDialogId, inSearchMessage.abs_object, null, null);
            }
            arrayList2.add(tLRPC$UserConvertBot);
        } else if (chatType == ChatType.Group || chatType == ChatType.Channel) {
            jGenerateDialogId = (int) IdStorage.getInstance().generateNegativeDialogId(inSearchMessage.object_guid);
            TLRPC$TL_channel tLRPC$TL_channel = new TLRPC$TL_channel();
            tLRPC$TL_channel.id = (int) (-jGenerateDialogId);
            ChatConverter.setAbsInfoForChannelGroup(tLRPC$TL_channel, inSearchMessage.abs_object);
            arrayList.add(tLRPC$TL_channel);
        }
        long j = jGenerateDialogId;
        ChatMessage chatMessage = inSearchMessage.message;
        arrayList3.add(convertMessage(j, chatMessage, inSearchMessage.time, -1, chatMessage.message_id > inSearchMessage.last_seen_peer_mid));
    }

    public static TLRPC$ReplyMarkup convertKeyPad(KeyPadObject keyPadObject, boolean z) {
        TLRPC$ReplyMarkup tLRPC$TL_replyKeyboardMarkup;
        if (z) {
            tLRPC$TL_replyKeyboardMarkup = new TLRPC$TL_replyInlineMarkup();
        } else {
            tLRPC$TL_replyKeyboardMarkup = new TLRPC$TL_replyKeyboardMarkup();
        }
        tLRPC$TL_replyKeyboardMarkup.resize = keyPadObject.resize_keyboard;
        tLRPC$TL_replyKeyboardMarkup.single_use = keyPadObject.one_time_keyboard;
        ArrayList<KeypadRow> arrayList = keyPadObject.rows;
        if (arrayList != null) {
            Iterator<KeypadRow> it = arrayList.iterator();
            while (it.hasNext()) {
                KeypadRow next = it.next();
                TLRPC$TL_keyboardButtonRow tLRPC$TL_keyboardButtonRow = new TLRPC$TL_keyboardButtonRow();
                ArrayList<KeyboardButton> arrayList2 = next.buttons;
                if (arrayList2 != null) {
                    Iterator<KeyboardButton> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        tLRPC$TL_keyboardButtonRow.buttons.add(convertKeyboardButton(it2.next(), z));
                    }
                    tLRPC$TL_replyKeyboardMarkup.rows.add(tLRPC$TL_keyboardButtonRow);
                }
            }
        }
        return tLRPC$TL_replyKeyboardMarkup;
    }

    private static TLRPC$KeyboardButton convertKeyboardButton(KeyboardButton keyboardButton, boolean z) {
        TLRPC$KeyboardButton tLRPC$TL_keyboardButton;
        if (z) {
            tLRPC$TL_keyboardButton = new TLRPC$TL_keyboardButtonCallback();
        } else {
            tLRPC$TL_keyboardButton = new TLRPC$TL_keyboardButton();
        }
        tLRPC$TL_keyboardButton.text = keyboardButton.button_text;
        tLRPC$TL_keyboardButton.button_id = IdStorage.getInstance().generateButtonId(keyboardButton.id);
        tLRPC$TL_keyboardButton.miniFunctionObject = keyboardButton;
        tLRPC$TL_keyboardButton.data = (keyboardButton.id + "_" + keyboardButton.button_text).getBytes();
        return tLRPC$TL_keyboardButton;
    }

    public static ArrayList<TLRPC$KeyboardButton> convertKeyboardButtons(ArrayList<KeyboardButton> arrayList) {
        if (arrayList == null) {
            return null;
        }
        ArrayList<TLRPC$KeyboardButton> arrayList2 = new ArrayList<>();
        Iterator<KeyboardButton> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(convertKeyboardButton(it.next(), false));
        }
        return arrayList2;
    }

    public static TLRPC$WalletTransferMessage convertWalletTransferMessage(CoreMainClass coreMainClass, WalletTransferMessageObject walletTransferMessageObject) {
        if (walletTransferMessageObject == null) {
            return null;
        }
        TLRPC$WalletTransferMessage tLRPC$WalletTransferMessage = new TLRPC$WalletTransferMessage();
        tLRPC$WalletTransferMessage.trackId = walletTransferMessageObject.track_id;
        tLRPC$WalletTransferMessage.description = walletTransferMessageObject.description;
        tLRPC$WalletTransferMessage.amount = walletTransferMessageObject.amount;
        tLRPC$WalletTransferMessage.currencyTitle = walletTransferMessageObject.currency_title;
        tLRPC$WalletTransferMessage.buttons = convertKeyboardButtons(walletTransferMessageObject.buttons);
        tLRPC$WalletTransferMessage.transaction_time = walletTransferMessageObject.transaction_time;
        tLRPC$WalletTransferMessage.status = walletTransferMessageObject.status;
        if (walletTransferMessageObject.sender_abs_object != null) {
            tLRPC$WalletTransferMessage.senderUser = ChatConverter.convertUser(coreMainClass, IdStorage.getInstance().generateDialogId(walletTransferMessageObject.sender_abs_object.object_guid), walletTransferMessageObject.sender_abs_object, (UserInfo) null, (Chat) null);
        }
        if (walletTransferMessageObject.receiver_abs_object != null) {
            tLRPC$WalletTransferMessage.receiverUser = ChatConverter.convertUser(coreMainClass, IdStorage.getInstance().generateDialogId(walletTransferMessageObject.receiver_abs_object.object_guid), walletTransferMessageObject.receiver_abs_object, (UserInfo) null, (Chat) null);
        }
        return tLRPC$WalletTransferMessage;
    }

    public static TLRPC$Message getMessageForKeyboard(long j, Chat chat) {
        if (j <= 0 || chat == null || chat.chat_keypad == null) {
            return null;
        }
        TLRPC$TL_message tLRPC$TL_message = new TLRPC$TL_message();
        tLRPC$TL_message.id = IdStorage.getInstance().generateKeypadStateId(chat.chat_keypad.state_id);
        tLRPC$TL_message.dialog_id = j;
        tLRPC$TL_message.reply_markup = convertKeyPad(chat.chat_keypad, false);
        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
        tLRPC$TL_message.from_id = tLRPC$TL_peerUser;
        tLRPC$TL_peerUser.user_id = (int) j;
        return tLRPC$TL_message;
    }

    public static LocationObject convertMediaToLocationObject(TLRPC$InputGeoPoint tLRPC$InputGeoPoint) {
        LocationObject locationObject = new LocationObject();
        locationObject.latitude = tLRPC$InputGeoPoint.lat;
        locationObject.longitude = tLRPC$InputGeoPoint._long;
        locationObject.map_view = tLRPC$InputGeoPoint.map_view;
        return locationObject;
    }

    public static LocationObject convertMediaToLocationObject(TLRPC$MessageMedia tLRPC$MessageMedia) {
        if (!(tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaGeo)) {
            return null;
        }
        LocationObject locationObject = new LocationObject();
        TLRPC$GeoPoint tLRPC$GeoPoint = tLRPC$MessageMedia.geo;
        locationObject.latitude = tLRPC$GeoPoint.lat;
        locationObject.longitude = tLRPC$GeoPoint._long;
        return locationObject;
    }

    public static LiveLocationObject convertMediaToLiveLocationObject(TLRPC$MessageMedia tLRPC$MessageMedia) {
        if (!(tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaGeoLive)) {
            return null;
        }
        LiveLocationObject liveLocationObject = new LiveLocationObject();
        LocationObject locationObject = new LocationObject();
        TLRPC$GeoPoint tLRPC$GeoPoint = tLRPC$MessageMedia.geo;
        locationObject.latitude = tLRPC$GeoPoint.lat;
        locationObject.longitude = tLRPC$GeoPoint._long;
        liveLocationObject.current_location = locationObject;
        liveLocationObject.live_period = tLRPC$MessageMedia.period;
        return liveLocationObject;
    }

    public static LiveLocationInfo convertLiveLocationInfo(CoreMainClass coreMainClass, LocationController.SharingLocationInfo sharingLocationInfo) {
        ChatType chatType;
        String str;
        if (sharingLocationInfo == null) {
            return null;
        }
        LiveLocationInfo liveLocationInfo = new LiveLocationInfo();
        String dialogId = IdStorage.getInstance().getDialogId(sharingLocationInfo.did);
        liveLocationInfo.chatGuid = dialogId;
        if (sharingLocationInfo.did < 0) {
            chatType = coreMainClass.isChannel(dialogId) ? ChatType.Channel : ChatType.Group;
        } else {
            chatType = coreMainClass.isBot(dialogId) ? ChatType.Bot : coreMainClass.isService(dialogId) ? ChatType.Service : ChatType.User;
        }
        liveLocationInfo.chatType = chatType;
        liveLocationInfo.messageId = sharingLocationInfo.messageObject.getId();
        liveLocationInfo.periodSecond = sharingLocationInfo.period;
        liveLocationInfo.stopTimeSecond = sharingLocationInfo.stopTime;
        liveLocationInfo.messageObject = convertToCoreMessage(coreMainClass, sharingLocationInfo.messageObject.messageOwner);
        FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
        if (liveLocationInfo.messageObject != null) {
            str = liveLocationInfo.messageObject.message_id + " ";
        } else {
            str = "null";
        }
        firebaseCrashlytics.setCustomKey("send message convertLiveLocationInfo ", str);
        return liveLocationInfo;
    }

    public static ArrayList<LocationController.SharingLocationInfo> convertAllLiveLocationInfos(int i, CoreMainClass coreMainClass, ArrayList<LiveLocationInfo> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<LocationController.SharingLocationInfo> arrayList2 = new ArrayList<>();
        Iterator<LiveLocationInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            LiveLocationInfo next = it.next();
            LocationController.SharingLocationInfo sharingLocationInfo = new LocationController.SharingLocationInfo();
            ChatType chatType = next.chatType;
            if (chatType == ChatType.Group || chatType == ChatType.Channel) {
                sharingLocationInfo.did = IdStorage.getInstance().generateNegativeDialogId(next.chatGuid);
            } else {
                sharingLocationInfo.did = IdStorage.getInstance().generateDialogId(next.chatGuid);
            }
            sharingLocationInfo.mid = next.messageId;
            sharingLocationInfo.period = next.periodSecond;
            sharingLocationInfo.stopTime = next.stopTimeSecond;
            TLRPC$Message tLRPC$MessageConvertToTlMessage = convertToTlMessage(coreMainClass, sharingLocationInfo.did, next.chatType == ChatType.Channel, next.messageObject, null);
            sharingLocationInfo.account = i;
            sharingLocationInfo.messageObject = new MessageObject(i, tLRPC$MessageConvertToTlMessage, false, false);
            arrayList2.add(sharingLocationInfo);
        }
        return arrayList2;
    }

    public static SendChatActivityInput.ActivityEnum convertActionToCoreActivity(TLRPC$SendMessageAction tLRPC$SendMessageAction) {
        if (tLRPC$SendMessageAction instanceof TLRPC$TL_sendMessageTypingAction) {
            return SendChatActivityInput.ActivityEnum.Typing;
        }
        if ((tLRPC$SendMessageAction instanceof TLRPC$TL_sendMessageRecordAudioAction) || (tLRPC$SendMessageAction instanceof TLRPC$TL_sendMessageRecordRoundAction)) {
            return SendChatActivityInput.ActivityEnum.Recording;
        }
        if ((tLRPC$SendMessageAction instanceof TLRPC$TL_sendMessageUploadDocumentAction) || (tLRPC$SendMessageAction instanceof TLRPC$TL_sendMessageUploadPhotoAction) || (tLRPC$SendMessageAction instanceof TLRPC$TL_sendMessageUploadVideoAction) || (tLRPC$SendMessageAction instanceof TLRPC$TL_sendMessageUploadAudioAction) || (tLRPC$SendMessageAction instanceof TLRPC$TL_sendMessageUploadRoundAction)) {
            return SendChatActivityInput.ActivityEnum.Uploading;
        }
        return null;
    }

    public static TLRPC$Update convertShowActivity(ShowActivityObject showActivityObject) {
        TLRPC$SendMessageAction tLRPC$TL_sendMessageUploadDocumentAction;
        ShowActivityObject.Type type = showActivityObject.type;
        if (type == ShowActivityObject.Type.Typing) {
            tLRPC$TL_sendMessageUploadDocumentAction = new TLRPC$TL_sendMessageTypingAction();
        } else if (type == ShowActivityObject.Type.Recording) {
            tLRPC$TL_sendMessageUploadDocumentAction = new TLRPC$TL_sendMessageRecordAudioAction();
        } else {
            tLRPC$TL_sendMessageUploadDocumentAction = type == ShowActivityObject.Type.Uploading ? new TLRPC$TL_sendMessageUploadDocumentAction() : null;
        }
        ChatType chatType = showActivityObject.object_type;
        if (chatType == ChatType.User || chatType == ChatType.Bot || chatType == ChatType.Service) {
            TLRPC$TL_updateUserTyping tLRPC$TL_updateUserTyping = new TLRPC$TL_updateUserTyping();
            tLRPC$TL_updateUserTyping.user_id = (int) IdStorage.getInstance().generateDialogId(showActivityObject.user_activity_guid);
            tLRPC$TL_updateUserTyping.action = tLRPC$TL_sendMessageUploadDocumentAction;
            return tLRPC$TL_updateUserTyping;
        }
        if (chatType != ChatType.Group && chatType != ChatType.Channel) {
            return null;
        }
        TLRPC$TL_updateChannelUserTyping tLRPC$TL_updateChannelUserTyping = new TLRPC$TL_updateChannelUserTyping();
        tLRPC$TL_updateChannelUserTyping.channel_id = -((int) IdStorage.getInstance().generateNegativeDialogId(showActivityObject.object_guid));
        tLRPC$TL_updateChannelUserTyping.action = tLRPC$TL_sendMessageUploadDocumentAction;
        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
        tLRPC$TL_updateChannelUserTyping.from_id = tLRPC$TL_peerUser;
        tLRPC$TL_peerUser.user_id = (int) IdStorage.getInstance().generateDialogId(showActivityObject.user_activity_guid);
        return tLRPC$TL_updateChannelUserTyping;
    }

    public static MessageObject convertNotificationMessage(int i, NotificationModels.ShowNotificationObject showNotificationObject) {
        int i2;
        int i3;
        int i4;
        NotificationModels.MessageDataObject messageDataObject;
        int i5;
        TLRPC$TL_message tLRPC$TL_message = new TLRPC$TL_message();
        tLRPC$TL_message.notificationId = showNotificationObject.notification_id;
        tLRPC$TL_message.message = showNotificationObject.text;
        showNotificationObject.getObjectGuid();
        tLRPC$TL_message.chatType = showNotificationObject.getObjectType();
        tLRPC$TL_message.entities = convertAllMetaDataToEntities(showNotificationObject.text_metadata);
        long timeMillis = showNotificationObject.receivedTime;
        if (timeMillis == 0) {
            timeMillis = ServiceLocator.getInstance(i).getCoreMainClass().getTimeMillis() / 1000;
        }
        tLRPC$TL_message.date = (int) timeMillis;
        tLRPC$TL_message.notificationImageId = showNotificationObject.image_file_id;
        NotificationModels.ShowNotificationTypeEnum showNotificationTypeEnum = showNotificationObject.type;
        if (showNotificationTypeEnum == NotificationModels.ShowNotificationTypeEnum.Message && (messageDataObject = showNotificationObject.message_data) != null) {
            tLRPC$TL_message.id = messageDataObject.message_id;
            ChatType chatType = messageDataObject.object_type;
            if (chatType == ChatType.User || chatType == ChatType.Bot || chatType == ChatType.Service) {
                long jGenerateDialogId = IdStorage.getInstance().generateDialogId(messageDataObject.object_guid);
                tLRPC$TL_message.dialog_id = jGenerateDialogId;
                i5 = (int) jGenerateDialogId;
                i4 = 0;
            } else {
                long jGenerateNegativeDialogId = IdStorage.getInstance().generateNegativeDialogId(messageDataObject.object_guid);
                tLRPC$TL_message.dialog_id = jGenerateNegativeDialogId;
                i4 = ((int) jGenerateNegativeDialogId) * (-1);
                i5 = 0;
            }
            if (i4 != 0) {
                TLRPC$TL_peerChannel tLRPC$TL_peerChannel = new TLRPC$TL_peerChannel();
                tLRPC$TL_message.peer_id = tLRPC$TL_peerChannel;
                tLRPC$TL_peerChannel.channel_id = i4;
            } else {
                TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                tLRPC$TL_message.peer_id = tLRPC$TL_peerUser;
                tLRPC$TL_peerUser.user_id = i5;
            }
            tLRPC$TL_message.from_id = tLRPC$TL_message.peer_id;
            tLRPC$TL_message.chatType = messageDataObject.object_type;
        } else {
            if (showNotificationTypeEnum != NotificationModels.ShowNotificationTypeEnum.NotMessage || showNotificationObject.not_message_data == null) {
                return null;
            }
            tLRPC$TL_message.id = IdStorage.getInstance().generateNotificationId(tLRPC$TL_message.notificationId);
            NotificationModels.NotMessageDataObject notMessageDataObject = showNotificationObject.not_message_data;
            ChatType chatType2 = notMessageDataObject.object_type;
            if (chatType2 == ChatType.User || chatType2 == ChatType.Bot || chatType2 == ChatType.Service) {
                long jGenerateDialogId2 = IdStorage.getInstance().generateDialogId(notMessageDataObject.object_guid);
                tLRPC$TL_message.dialog_id = jGenerateDialogId2;
                i2 = (int) jGenerateDialogId2;
                i3 = 0;
            } else {
                long jGenerateNegativeDialogId2 = IdStorage.getInstance().generateNegativeDialogId(notMessageDataObject.object_guid);
                tLRPC$TL_message.dialog_id = jGenerateNegativeDialogId2;
                i3 = ((int) jGenerateNegativeDialogId2) * (-1);
                i2 = 0;
            }
            if (i3 != 0) {
                TLRPC$TL_peerChannel tLRPC$TL_peerChannel2 = new TLRPC$TL_peerChannel();
                tLRPC$TL_message.peer_id = tLRPC$TL_peerChannel2;
                tLRPC$TL_peerChannel2.channel_id = i3;
            } else {
                TLRPC$TL_peerUser tLRPC$TL_peerUser2 = new TLRPC$TL_peerUser();
                tLRPC$TL_message.peer_id = tLRPC$TL_peerUser2;
                tLRPC$TL_peerUser2.user_id = i2;
            }
            tLRPC$TL_message.from_id = tLRPC$TL_message.peer_id;
            tLRPC$TL_message.chatType = notMessageDataObject.object_type;
            i4 = i3;
        }
        return new MessageObject(i, tLRPC$TL_message, showNotificationObject.text, TextUtils.isEmpty(showNotificationObject.title) ? LocaleController.getString("UnknownName", R.string.UnknownName) : showNotificationObject.title, null, false, i4 != 0 && tLRPC$TL_message.chatType == ChatType.Channel, i4 != 0 && tLRPC$TL_message.chatType == ChatType.Group, false);
    }

    public static ArrayList<TLRPC$Message> convertAllCallMessages(CoreMainClass coreMainClass, ArrayList<VoiceCallModels.CallAbsObject> arrayList, ArrayList<TLRPC$User> arrayList2) {
        ArrayList<TLRPC$Message> arrayList3 = new ArrayList<>();
        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
        tLRPC$TL_peerUser.user_id = (int) IdStorage.getInstance().generateDialogId(coreMainClass.getMyGuid());
        Iterator<VoiceCallModels.CallAbsObject> it = arrayList.iterator();
        while (it.hasNext()) {
            VoiceCallModels.CallAbsObject next = it.next();
            TLRPC$TL_message tLRPC$TL_message = new TLRPC$TL_message();
            tLRPC$TL_message.id = next.message_id;
            String str = next.object_guid;
            ChatType chatType = ChatType.User;
            long dialogId = ChatConverter.getDialogId(str, chatType);
            tLRPC$TL_message.dialog_id = dialogId;
            TLRPC$Peer peer = ChatConverter.getPeer(dialogId, next.object_guid, chatType);
            if (next.request_type == VoiceCallModels.CallRequestType.Caller) {
                tLRPC$TL_message.from_id = tLRPC$TL_peerUser;
                tLRPC$TL_message.peer_id = peer;
            } else {
                tLRPC$TL_message.from_id = peer;
                tLRPC$TL_message.peer_id = tLRPC$TL_peerUser;
            }
            tLRPC$TL_message.date = (int) next.start_time;
            TLRPC$TL_messageActionPhoneCall tLRPC$TL_messageActionPhoneCall = new TLRPC$TL_messageActionPhoneCall();
            tLRPC$TL_message.action = tLRPC$TL_messageActionPhoneCall;
            tLRPC$TL_messageActionPhoneCall.reason = getCallReason(next.discard_reason);
            TLRPC$MessageAction tLRPC$MessageAction = tLRPC$TL_message.action;
            tLRPC$MessageAction.video = next.call_type == VoiceCallModels.CallType.Video;
            tLRPC$MessageAction.duration = next.duration;
            tLRPC$MessageAction.call_id = next.call_id;
            if (arrayList2 != null) {
                arrayList2.addAll(ChatConverter.getUserParticipants(coreMainClass, next.other_participants));
            }
            arrayList3.add(tLRPC$TL_message);
        }
        return arrayList3;
    }

    private static String getCdnTag(TLRPC$MessageMedia tLRPC$MessageMedia) {
        TLRPC$Document tLRPC$Document;
        TLRPC$Photo tLRPC$Photo;
        if ((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) && (tLRPC$Photo = tLRPC$MessageMedia.photo) != null) {
            return tLRPC$Photo.cdnTag;
        }
        if (!(tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaDocument) || (tLRPC$Document = tLRPC$MessageMedia.document) == null) {
            return null;
        }
        return tLRPC$Document.cdnTag;
    }

    private static void setCdnTag(TLRPC$MessageMedia tLRPC$MessageMedia, String str) {
        TLRPC$Document tLRPC$Document;
        TLRPC$Photo tLRPC$Photo;
        if ((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) && (tLRPC$Photo = tLRPC$MessageMedia.photo) != null) {
            tLRPC$Photo.cdnTag = str;
        } else {
            if (!(tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaDocument) || (tLRPC$Document = tLRPC$MessageMedia.document) == null) {
                return;
            }
            tLRPC$Document.cdnTag = str;
        }
    }

    public static FileInlineObject convertToFileInlineObject(TLRPC$MessageMedia tLRPC$MessageMedia) {
        TLRPC$DocumentAttribute audioAttribute;
        if (tLRPC$MessageMedia == null || (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaEmpty)) {
            return null;
        }
        AvatarFileInline avatarFileInline = new AvatarFileInline();
        avatarFileInline.cdn_tag = getCdnTag(tLRPC$MessageMedia);
        String str = "null";
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) {
            avatarFileInline.file_id = tLRPC$MessageMedia.photo.id;
            avatarFileInline.type = FileInlineObject.FileInlineType.Image;
            FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
            StringBuilder sb = new StringBuilder();
            sb.append(tLRPC$MessageMedia.photo.id);
            sb.append(" ");
            if (avatarFileInline.type != null) {
                str = avatarFileInline.type + BuildConfig.FLAVOR;
            }
            sb.append(str);
            firebaseCrashlytics.setCustomKey("TL_messageMediaPhoto", sb.toString());
            avatarFileInline.dc_id = IdStorage.getInstance().getDcId(tLRPC$MessageMedia.photo.dc_id);
            avatarFileInline.access_hash_rec = IdStorage.getInstance().getAccessHashId(tLRPC$MessageMedia.photo.access_hash);
            TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(tLRPC$MessageMedia.photo.sizes, 100, true);
            avatarFileInline.height = closestPhotoSizeWithSize.h;
            avatarFileInline.width = closestPhotoSizeWithSize.w;
            avatarFileInline.size = closestPhotoSizeWithSize.size;
            avatarFileInline.thumb_inline = getThumbInline(tLRPC$MessageMedia.photo.sizes);
        } else if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaDocument) {
            TLRPC$Document tLRPC$Document = tLRPC$MessageMedia.document;
            avatarFileInline.type = getFileType(tLRPC$Document);
            FirebaseCrashlytics firebaseCrashlytics2 = FirebaseCrashlytics.getInstance();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(tLRPC$Document.id);
            sb2.append(" ");
            if (avatarFileInline.type != null) {
                str = avatarFileInline.type + BuildConfig.FLAVOR;
            }
            sb2.append(str);
            firebaseCrashlytics2.setCustomKey("TL_messageMediaDocument", sb2.toString());
            convertDocumentToFileInlineCommonFields(tLRPC$Document, avatarFileInline);
            avatarFileInline.mime = tLRPC$Document.mime_type;
            avatarFileInline.file_name = getFileName(BuildConfig.FLAVOR, tLRPC$Document.attributes);
            if (MessageObject.isStickerDocument(tLRPC$Document)) {
                StickerObject stickerObject = new StickerObject();
                TLRPC$DocumentAttribute stickerAttribute = getStickerAttribute(tLRPC$Document.attributes);
                TLRPC$DocumentAttribute imageSizeAttribute = getImageSizeAttribute(tLRPC$Document.attributes);
                if (stickerAttribute != null && stickerAttribute.stickerset != null) {
                    stickerObject.emoji_character = stickerAttribute.alt;
                    stickerObject.sticker_id = stickerAttribute.stickerId;
                    stickerObject.sticker_set_id = IdStorage.getInstance().getStickerSetId(stickerAttribute.stickerset.id);
                }
                if (imageSizeAttribute != null) {
                    stickerObject.w_h_ratio = (imageSizeAttribute.w * 1.0f) / imageSizeAttribute.h;
                }
            } else {
                FileInlineObject.FileInlineType fileInlineType = avatarFileInline.type;
                if (fileInlineType == FileInlineObject.FileInlineType.Voice) {
                    TLRPC$DocumentAttribute audioAttribute2 = getAudioAttribute(tLRPC$Document.attributes);
                    avatarFileInline.time = audioAttribute2 != null ? Math.max(audioAttribute2.duration * CloseCodes.NORMAL_CLOSURE, 1) : 0;
                } else if (fileInlineType == FileInlineObject.FileInlineType.Video || fileInlineType == FileInlineObject.FileInlineType.Gif) {
                    TLRPC$DocumentAttribute videoAttribute = getVideoAttribute(tLRPC$Document.attributes);
                    if (videoAttribute != null) {
                        avatarFileInline.time = Math.max(videoAttribute.duration * CloseCodes.NORMAL_CLOSURE, 1);
                        avatarFileInline.height = videoAttribute.h;
                        avatarFileInline.width = videoAttribute.w;
                        avatarFileInline.file_name = "video.mp4";
                        avatarFileInline.thumb_inline = getVideoThumbnail(tLRPC$MessageMedia.document.thumbs);
                        avatarFileInline.is_round = videoAttribute.round_message;
                    }
                } else if (fileInlineType == FileInlineObject.FileInlineType.Music && (audioAttribute = getAudioAttribute(tLRPC$Document.attributes)) != null) {
                    avatarFileInline.time = audioAttribute.duration;
                    avatarFileInline.music_performer = audioAttribute.performer;
                }
            }
        }
        return avatarFileInline;
    }

    public static Gson getGson() {
        Gson gson2 = gson;
        if (gson2 == null) {
            synchronized (Gson.class) {
                gson2 = gson;
                if (gson2 == null) {
                    GsonBuilder gsonBuilder = new GsonBuilder();
                    gsonBuilder.registerTypeAdapter(TLRPC$Peer.class, new FwdObjectSerializer());
                    gsonBuilder.registerTypeAdapter(TLRPC$Peer.class, new FwdObjectDeserializer());
                    Gson gsonCreate = gsonBuilder.create();
                    gson = gsonCreate;
                    gson2 = gsonCreate;
                }
            }
        }
        return gson2;
    }

    public static String getMusicFileName(TLRPC$Message tLRPC$Message) {
        TLRPC$MessageMedia tLRPC$MessageMedia;
        TLRPC$Document tLRPC$Document;
        TLRPC$DocumentAttribute audioAttribute;
        String str;
        if (tLRPC$Message == null || (tLRPC$MessageMedia = tLRPC$Message.media) == null || (tLRPC$Document = tLRPC$MessageMedia.document) == null || getFileType(tLRPC$Document) != FileInlineObject.FileInlineType.Music || (audioAttribute = getAudioAttribute(tLRPC$Message.media.document.attributes)) == null) {
            return null;
        }
        if (TextUtils.isEmpty(audioAttribute.title)) {
            return getFileName(tLRPC$Message.attachPath, tLRPC$Message.media.document.attributes);
        }
        String mime = FileLoader.getMime(tLRPC$Message.attachPath);
        StringBuilder sb = new StringBuilder();
        sb.append(getFileName(audioAttribute.title, null));
        if (TextUtils.isEmpty(mime)) {
            str = BuildConfig.FLAVOR;
        } else {
            str = "." + mime.toLowerCase();
        }
        sb.append(str);
        return sb.toString();
    }

    public static String getFileNameAttached(String str, String str2, ArrayList<TLRPC$DocumentAttribute> arrayList) {
        String str3;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return getFileName(str, arrayList);
        }
        String strExcludeMimePart = excludeMimePart(getFileName(str2, arrayList));
        String mime = FileLoader.getMime(str);
        StringBuilder sb = new StringBuilder();
        sb.append(strExcludeMimePart);
        if (TextUtils.isEmpty(mime)) {
            str3 = BuildConfig.FLAVOR;
        } else {
            str3 = "." + mime.toLowerCase();
        }
        sb.append(str3);
        return sb.toString();
    }

    public static boolean isGifValid(TLRPC$Document tLRPC$Document) {
        if (tLRPC$Document != null && tLRPC$Document.attributes != null) {
            for (int i = 0; i < tLRPC$Document.attributes.size(); i++) {
                TLRPC$DocumentAttribute tLRPC$DocumentAttribute = tLRPC$Document.attributes.get(i);
                if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeVideo) {
                    return tLRPC$DocumentAttribute.duration > 0 && tLRPC$DocumentAttribute.w > 0 && tLRPC$DocumentAttribute.h > 0;
                }
            }
        }
        return false;
    }

    public static ArrayList<TLRPC$MessagePeerReaction> convertToTlMessageReactionList(CoreMainClass coreMainClass, ArrayList<UserReactionObject> arrayList, ArrayList<TLRPC$User> arrayList2) {
        if (arrayList == null) {
            return null;
        }
        ArrayList<TLRPC$MessagePeerReaction> arrayList3 = new ArrayList<>();
        Iterator<UserReactionObject> it = arrayList.iterator();
        while (it.hasNext()) {
            UserReactionObject next = it.next();
            TLRPC$TL_messagePeerReaction tLRPC$TL_messagePeerReaction = new TLRPC$TL_messagePeerReaction();
            tLRPC$TL_messagePeerReaction.date = next.reaction_time;
            TLRPC$TL_reactionEmoji tLRPC$TL_reactionEmoji = new TLRPC$TL_reactionEmoji();
            tLRPC$TL_reactionEmoji.emoticon = next.emoji_char;
            tLRPC$TL_messagePeerReaction.reaction = tLRPC$TL_reactionEmoji;
            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
            tLRPC$TL_messagePeerReaction.peer_id = tLRPC$TL_peerUser;
            tLRPC$TL_peerUser.user_id = (int) IdStorage.getInstance().generateDialogId(next.user_guid);
            arrayList3.add(tLRPC$TL_messagePeerReaction);
            TLRPC$User tLRPC$UserConvertUser = ChatConverter.convertUser(coreMainClass, IdStorage.getInstance().generateDialogId(next.user_guid), coreMainClass.getAbsInstant(next.user_guid), (UserInfo) null, (Chat) null);
            if (arrayList2 != null) {
                arrayList2.add(tLRPC$UserConvertUser);
            }
        }
        return arrayList3;
    }
}
