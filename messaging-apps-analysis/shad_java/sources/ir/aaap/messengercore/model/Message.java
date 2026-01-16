package ir.aaap.messengercore.model;

import android.util.Log;
import ir.aaap.messengercore.model.LiveModels;
import ir.aaap.messengercore.model.MessageParamUpdateTimeObject;
import ir.aaap.messengercore.utilites.DataGenerator;
import ir.aaap.messengercore.utilites.Objects;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class Message {
    public String author_object_guid;
    public String author_signature;
    public AuthorTypeEnum author_type;
    public AuxDataObject aux_data;
    public ContactMessageObject contact_message;
    public EventObject event_data;
    public FileInlineObject file_inline;
    public ForwardFromObject forwarded_from;
    public ForwardedNoLinkObject forwarded_no_link;
    public long groupId;
    public KeyPadObject inline_keypad;
    public boolean isDeleted;
    public boolean isLocallyEdited;
    public boolean is_banned;
    public boolean is_edited;
    public boolean is_local_deleted;
    public LiveModels.LiveMessage live_data;
    public LiveLocationObject live_location;
    public LocalParametersObject localParametersObject;
    public LocationObject location;
    public MessageParamUpdateTimeObject messageParamUpdateTimeObject;
    public MessageCallData message_call;
    public long message_id;
    public MetaDataObject metadata;
    public PollObject poll;
    public ProductMessageData product_message_data;
    public ArrayList<MessageReactionObject> reactions;
    public long reply_to_message_id;
    public RubinoPostData rubino_post_data;
    public RubinoStoryData rubino_story_data;
    public int sendState;
    public StickerObject sticker;
    public String text;
    public long timeMillis;
    public long timeStamp;
    public MessageTypeEnum type;
    public String via_bot_guid;
    public WalletTransferDataObject wallet_transfer_data;
    public long time = 0;
    public int count_seen = 0;
    public int reply_timeout = 0;

    public enum AuthorTypeEnum {
        User,
        Bot
    }

    public enum EventType {
        GroupCreated,
        ChannelCreated,
        AddedGroupMembers,
        RemoveGroupMembers,
        PhotoUpdate,
        TitleUpdate,
        JoinedGroupByLink,
        PinnedMessageUpdated,
        LeaveGroup,
        RemovePhoto,
        CreateGroupVoiceChat,
        StopGroupVoiceChat,
        InviteGroupVoiceChat,
        CreateGroupVoiceChatChannel
    }

    public enum MessageTypeEnum {
        Text,
        FileInline,
        FileInlineCaption,
        Event,
        ContactMessage,
        Sticker,
        Location,
        LiveLocation,
        Poll2,
        Payment,
        Call,
        Poll,
        Live,
        RubinoPost,
        RubinoStory,
        ProductMessage,
        WalletTransfer
    }

    public boolean equals(Object obj) throws IllegalAccessException, IllegalArgumentException {
        Object objValueOf;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Message)) {
            return false;
        }
        Message message = (Message) obj;
        for (Field field : getClass().getDeclaredFields()) {
            try {
                Object obj2 = field.get(message);
                Object obj3 = field.get(this);
                StringBuilder sb = new StringBuilder();
                if (obj2 != null) {
                    objValueOf = Boolean.valueOf(obj2.equals(obj3));
                } else if (obj3 == null) {
                    objValueOf = "true";
                } else {
                    objValueOf = "a is null b: " + obj3;
                }
                sb.append(objValueOf);
                sb.append("\t");
                sb.append(field.getName());
                Log.e("MessageFields", sb.toString());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return this.sendState == message.sendState && this.message_id == message.message_id && this.reply_to_message_id == message.reply_to_message_id && this.time == message.time && this.count_seen == message.count_seen && this.is_edited == message.is_edited && this.reply_timeout == message.reply_timeout && this.is_local_deleted == message.is_local_deleted && Objects.equals(this.author_object_guid, message.author_object_guid) && this.author_type == message.author_type && Objects.equals(this.text, message.text) && Objects.equals(this.file_inline, message.file_inline) && Objects.equals(this.forwarded_from, message.forwarded_from) && Objects.equals(this.location, message.location) && Objects.equals(this.sticker, message.sticker) && Objects.equals(this.contact_message, message.contact_message) && this.type == message.type && Objects.equals(this.poll, message.poll) && Objects.equals(this.live_location, message.live_location) && Objects.equals(this.forwarded_no_link, message.forwarded_no_link) && Objects.equals(this.aux_data, message.aux_data) && Objects.equals(this.message_call, message.message_call) && Objects.equals(this.live_data, message.live_data) && Objects.equals(this.metadata, message.metadata) && Objects.equals(this.event_data, message.event_data) && Objects.equals(this.author_signature, message.author_signature) && Objects.equals(this.inline_keypad, message.inline_keypad) && this.isDeleted == message.isDeleted && this.timeStamp == message.timeStamp && this.timeMillis == message.timeMillis && this.isLocallyEdited == message.isLocallyEdited && Objects.equals(this.via_bot_guid, message.via_bot_guid) && Objects.equals(this.localParametersObject, message.localParametersObject) && this.rubino_story_data.equals(message.rubino_story_data) && this.rubino_post_data.equals(message.rubino_post_data) && this.product_message_data.equals(message.product_message_data) && this.is_banned == message.is_banned && getClass().getDeclaredFields().length == 36;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.sendState), Long.valueOf(this.message_id), this.author_object_guid, this.author_type, this.text, this.file_inline, Long.valueOf(this.reply_to_message_id), Long.valueOf(this.time), Integer.valueOf(this.count_seen), Boolean.valueOf(this.is_edited), this.forwarded_from, Integer.valueOf(this.reply_timeout), this.location, this.sticker, Boolean.valueOf(this.is_local_deleted), this.contact_message, this.type, this.poll, this.live_location, this.forwarded_no_link, this.aux_data, this.message_call, this.live_data, this.metadata, this.event_data, this.author_signature, Boolean.valueOf(this.isDeleted), Long.valueOf(this.timeStamp), this.localParametersObject, this.rubino_story_data, this.rubino_post_data, this.product_message_data, Boolean.valueOf(this.is_banned));
    }

    public void setTime() {
        if (this.message_id < 0) {
            long j = this.timeMillis;
            if (j > 0) {
                this.time = j / 1000;
            }
        }
        long j2 = this.time;
        if (j2 <= 0 || this.timeMillis != 0) {
            return;
        }
        this.timeMillis = j2 * 1000;
    }

    public long getUpdateTimestamp() {
        MessageParamUpdateTimeObject messageParamUpdateTimeObject = this.messageParamUpdateTimeObject;
        return messageParamUpdateTimeObject != null ? messageParamUpdateTimeObject.update_timestamp : this.timeStamp;
    }

    public long getUpdateTimestamp(MessageParamUpdateTimeObject.UpdateParameterEnum updateParameterEnum) {
        MessageParamUpdateTimeObject messageParamUpdateTimeObject = this.messageParamUpdateTimeObject;
        if (messageParamUpdateTimeObject != null) {
            return messageParamUpdateTimeObject.getLastUpdateTimestamp(updateParameterEnum);
        }
        return 0L;
    }

    public void setParamUpdateTime(MessageParamUpdateTimeObject.UpdateParameterEnum updateParameterEnum, long j) {
        if (this.messageParamUpdateTimeObject == null) {
            this.messageParamUpdateTimeObject = new MessageParamUpdateTimeObject();
        }
        this.messageParamUpdateTimeObject.setParamUpdateTimestamp(updateParameterEnum, j);
    }

    public void setUpdateTimestamp(long j) {
        if (this.messageParamUpdateTimeObject == null) {
            this.messageParamUpdateTimeObject = new MessageParamUpdateTimeObject();
        }
        this.messageParamUpdateTimeObject.update_timestamp = j;
    }

    public static class ForwardFromObject {
        public ChatAbsObject forwardAbsObject;
        public long forwarded_for_send_message_id;
        public String forwarded_for_send_object_guid;
        public long message_id;
        public String object_guid;
        public ForwardFromType type_from;

        public boolean equals(Object obj) {
            if (!(obj instanceof ForwardFromObject)) {
                return false;
            }
            ForwardFromObject forwardFromObject = (ForwardFromObject) obj;
            return this.type_from == forwardFromObject.type_from && this.message_id == forwardFromObject.message_id;
        }

        public static ForwardFromObject generate(long j) {
            ForwardFromObject forwardFromObject = new ForwardFromObject();
            if (DataGenerator.randomBooleanSeed(j)) {
                forwardFromObject.type_from = ForwardFromType.Channel;
            } else {
                forwardFromObject.type_from = ForwardFromType.User;
            }
            forwardFromObject.object_guid = DataGenerator.randomNameSeed(j);
            forwardFromObject.message_id = DataGenerator.randomLongSeed(j);
            return forwardFromObject;
        }
    }

    public enum ForwardFromType {
        User,
        Channel,
        Bot;

        public ChatType getChatType() {
            if (User == this) {
                return ChatType.User;
            }
            if (Channel == this) {
                return ChatType.Channel;
            }
            if (Bot == this) {
                return ChatType.Bot;
            }
            return null;
        }
    }

    public static class EventObject {
        public AvatarFileInline avatar;
        public AvatarFileInline avatar_thumbnail;
        public int group_voice_chat_duration;
        public ArrayList<ObjectGuidType> peer_objects;
        public ObjectGuidType performer_object;
        public long pinned_message_id;
        public String title;
        public EventType type;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EventObject)) {
                return false;
            }
            EventObject eventObject = (EventObject) obj;
            return this.pinned_message_id == eventObject.pinned_message_id && this.type == eventObject.type && Objects.equals(this.performer_object, eventObject.performer_object) && Objects.equals(this.peer_objects, eventObject.peer_objects) && Objects.equals(this.title, eventObject.title) && Objects.equals(this.avatar, eventObject.avatar);
        }
    }

    public void fillAttribute(long j) {
        this.timeStamp = j;
        setTime();
        setUpdateTimestamp(j);
    }

    public static class LocalParametersObject {
        public String attachPath;
        public ChatType chatType;
        public String fileName;
        public String fwdFromGuid;
        public ChatType fwdFromType;
        public String fwdObj;
        public long fwd_msg_id;
        public String originalPath;
        public long prevMessageId;
        public MetaDataObject prevMetadata;
        public String prevText;
        public int thumb_local_id;
        public String toGuid;
        public String videoEditInfo;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LocalParametersObject)) {
                return false;
            }
            LocalParametersObject localParametersObject = (LocalParametersObject) obj;
            return Objects.equals(this.attachPath, localParametersObject.attachPath) && Objects.equals(this.videoEditInfo, localParametersObject.videoEditInfo) && Objects.equals(this.toGuid, localParametersObject.toGuid) && Objects.equals(this.chatType, localParametersObject.chatType) && Objects.equals(this.originalPath, localParametersObject.originalPath) && Objects.equals(Integer.valueOf(this.thumb_local_id), Integer.valueOf(localParametersObject.thumb_local_id)) && Objects.equals(this.fileName, localParametersObject.fileName);
        }

        public int hashCode() {
            return Objects.hash(this.attachPath);
        }
    }

    public long getSortingMessageId() {
        long j = this.message_id;
        if (j >= 0) {
            return j;
        }
        LocalParametersObject localParametersObject = this.localParametersObject;
        if (localParametersObject == null) {
            return 0L;
        }
        return localParametersObject.prevMessageId;
    }
}
