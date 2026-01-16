package ir.aaap.messengercore.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.StringHelper;
import ir.aaap.messengercore.model.FileInlineObject;
import ir.aaap.messengercore.model.LiveModels;
import ir.aaap.messengercore.model.Message;
import ir.aaap.messengercore.utilites.Objects;
import org.rbmain.messenger.ImageReceiver;

/* loaded from: classes3.dex */
public class ChatMessage {
    public String author_title;
    public Message.AuthorTypeEnum author_type;
    public MetaDataObject metadata;
    public ChatMessageTypeEnum type;
    public long message_id = 0;
    public String text = BuildConfig.FLAVOR;
    public String author_object_guid = BuildConfig.FLAVOR;
    public boolean is_mine = false;

    public enum ChatMessageTypeEnum {
        Text,
        Other,
        NotMessage
    }

    public static ChatMessage createFromLocalMessage(Message message) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.message_id = message.message_id;
        chatMessage.text = getText(message);
        chatMessage.is_mine = true;
        chatMessage.author_object_guid = message.author_object_guid;
        chatMessage.author_type = message.author_type;
        chatMessage.author_title = StringHelper.getString(StringHelper.StringKeyEnum.You);
        chatMessage.type = getType(message);
        chatMessage.metadata = message.metadata;
        return chatMessage;
    }

    private static String getText(Message message) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = message.text;
        if (str5 != null && !str5.isEmpty()) {
            if (message.text.length() < 150) {
                return message.text;
            }
            return message.text.substring(0, ImageReceiver.DEFAULT_CROSSFADE_DURATION);
        }
        FileInlineObject fileInlineObject = message.file_inline;
        if (fileInlineObject != null) {
            if (fileInlineObject == null) {
                return BuildConfig.FLAVOR;
            }
            FileInlineObject.FileInlineType fileInlineType = fileInlineObject.type;
            if (fileInlineType == FileInlineObject.FileInlineType.Image) {
                return StringHelper.getString(StringHelper.StringKeyEnum.Image) + BuildConfig.FLAVOR;
            }
            if (fileInlineType == FileInlineObject.FileInlineType.Video) {
                return StringHelper.getString(StringHelper.StringKeyEnum.Video) + BuildConfig.FLAVOR;
            }
            if (fileInlineType == FileInlineObject.FileInlineType.Voice) {
                return StringHelper.getString(StringHelper.StringKeyEnum.Voice) + BuildConfig.FLAVOR;
            }
            if (fileInlineType == FileInlineObject.FileInlineType.Gif) {
                return StringHelper.getString(StringHelper.StringKeyEnum.Gif) + BuildConfig.FLAVOR;
            }
            if (fileInlineType == FileInlineObject.FileInlineType.Music) {
                return StringHelper.getString(StringHelper.StringKeyEnum.music) + BuildConfig.FLAVOR;
            }
            if (fileInlineType == FileInlineObject.FileInlineType.File && (str4 = fileInlineObject.file_name) != null && !str4.isEmpty()) {
                return message.file_inline.file_name;
            }
            return StringHelper.getString(StringHelper.StringKeyEnum.File) + BuildConfig.FLAVOR;
        }
        Message.MessageTypeEnum messageTypeEnum = message.type;
        if (messageTypeEnum == Message.MessageTypeEnum.ContactMessage) {
            return StringHelper.getString(StringHelper.StringKeyEnum.ContactMessage) + BuildConfig.FLAVOR;
        }
        if (messageTypeEnum == Message.MessageTypeEnum.Live) {
            String str6 = null;
            LiveModels.LiveMessage liveMessage = message.live_data;
            if (liveMessage != null && (str3 = liveMessage.title) != null && !str3.isEmpty()) {
                str6 = message.live_data.title;
            }
            String str7 = StringHelper.getString(StringHelper.StringKeyEnum.ChatLive) + BuildConfig.FLAVOR;
            if (str6 != null) {
                str7 = str7 + ":" + str6;
            }
            return str7;
        }
        if (messageTypeEnum == Message.MessageTypeEnum.RubinoPost) {
            return StringHelper.getString(StringHelper.StringKeyEnum.RubinoPost) + BuildConfig.FLAVOR;
        }
        if (messageTypeEnum == Message.MessageTypeEnum.Call) {
            return StringHelper.getString(StringHelper.StringKeyEnum.call) + BuildConfig.FLAVOR;
        }
        if (messageTypeEnum == Message.MessageTypeEnum.RubinoStory) {
            return StringHelper.getString(StringHelper.StringKeyEnum.Story) + BuildConfig.FLAVOR;
        }
        if (messageTypeEnum == Message.MessageTypeEnum.Poll2) {
            PollObject pollObject = message.poll;
            if (pollObject != null && (str2 = pollObject.question) != null && !str2.isEmpty()) {
                return "📊 " + message.poll.question;
            }
            return "📊 " + StringHelper.getString(StringHelper.StringKeyEnum.poll);
        }
        if (messageTypeEnum == Message.MessageTypeEnum.Location) {
            return StringHelper.getString(StringHelper.StringKeyEnum.Location) + BuildConfig.FLAVOR;
        }
        if (messageTypeEnum == Message.MessageTypeEnum.LiveLocation) {
            return StringHelper.getString(StringHelper.StringKeyEnum.LiveLocation) + BuildConfig.FLAVOR;
        }
        if (messageTypeEnum != Message.MessageTypeEnum.Sticker) {
            return BuildConfig.FLAVOR;
        }
        StickerObject stickerObject = message.sticker;
        if (stickerObject == null || stickerObject.emoji_character == null) {
            str = BuildConfig.FLAVOR;
        } else {
            str = message.sticker.emoji_character + " ";
        }
        return str + StringHelper.getString(StringHelper.StringKeyEnum.StickerMessage) + BuildConfig.FLAVOR;
    }

    private static ChatMessageTypeEnum getType(Message message) {
        String str = message.text;
        if (str != null && !str.isEmpty()) {
            return ChatMessageTypeEnum.Text;
        }
        return ChatMessageTypeEnum.Other;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatMessage)) {
            return false;
        }
        ChatMessage chatMessage = (ChatMessage) obj;
        return this.message_id == chatMessage.message_id && this.is_mine == chatMessage.is_mine && this.type == chatMessage.type && Objects.equals(this.text, chatMessage.text) && Objects.equals(this.author_object_guid, chatMessage.author_object_guid) && this.author_type == chatMessage.author_type && Objects.equals(this.author_title, chatMessage.author_title) && getClass().getDeclaredFields().length == 7;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.message_id), this.type, this.text, this.author_object_guid, Boolean.valueOf(this.is_mine), this.author_type, this.author_title);
    }
}
