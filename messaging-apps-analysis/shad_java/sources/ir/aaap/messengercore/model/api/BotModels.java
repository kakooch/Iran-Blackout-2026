package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.AuxDataObject;
import ir.aaap.messengercore.model.AvatarFileInline;
import ir.aaap.messengercore.model.BotButtonObject;
import ir.aaap.messengercore.model.ChatUpdateObject;
import ir.aaap.messengercore.model.ContactMessageObject;
import ir.aaap.messengercore.model.FileInlineObject;
import ir.aaap.messengercore.model.LocationObject;
import ir.aaap.messengercore.model.MessageUpdateObject;
import ir.aaap.messengercore.model.MetaDataObject;
import ir.aaap.messengercore.model.PaymentInfoObject;
import ir.aaap.messengercore.model.StickerObject;
import java.util.ArrayList;
import java.util.Set;

/* loaded from: classes3.dex */
public class BotModels {

    public static class CheckBotQueryInput {
        public String bot_username;
    }

    public static class CheckBotQueryOutput {
        public boolean accept_query;
        public String bot_guid;
        public String place_holder;
        public RequestLocationType request_location;
        public String username;
    }

    public static class DeleteBotChatInput {
        public String bot_guid;
        public long last_deleted_message_id;
    }

    public static class GetBotSelectionInput {
        public String bot_guid;
        public String selection_id;
        public String start_id;
    }

    public static class GetBotSelectionOutput {
        public boolean has_continue;
        public ArrayList<BotButtonObject.BotButtonSimpleObject> items;
        public String next_start_id;
    }

    public static class GetInlineBotsInput {
        public Set<String> bot_guids;
    }

    public static class GetInlineBotsOutput {
        public ArrayList<InlineBotObject> inline_bots;
    }

    public static class GetPaymentInfoInput {
        public String bot_guid;
        public String payment_id;
    }

    public static class GetPaymentInfoOutput {
        public boolean allow_payment;
        public ChatUpdateObject message_update;
        public PaymentInfoObject payment_info;
    }

    public static class GetSuggestedInlineBotInput {
    }

    public static class InlineBotObject {
        public AvatarFileInline avatar_thumbnail;
        public String bot_guid;
        public boolean is_deleted;
        public boolean is_verified;
        public String title;
        public String username;
    }

    public static class QueryMessage {
        public FileInlineObject file_inline;
        public LocationObject location;
        public ContactMessageObject message_contact;
        public MetaDataObject metadata;
        public StickerObject sticker;
        public String text;
    }

    public static class QueryResultObject {
        public String botGuid;
        public String botUsername;
        public String description;
        public FileView preview_file;
        public String preview_url;
        public QueryMessage query_message;
        public String query_result_id;
        public String title;
        public String url;
    }

    public enum RequestLocationType {
        SendLocation,
        AskLocation,
        None
    }

    public static class SearchBotSelectionInput {
        public String app_id;
        public String bot_guid;
        public int limit;
        public String search_text;
        public String selection_id;
    }

    public static class SearchBotSelectionOutput {
        public ArrayList<BotButtonObject.BotButtonSimpleObject> items;
    }

    public static class SendBotQueryInput {
        public String bot_username;
        public LocationObject location;
        public String query;
        public String start_id;
    }

    public static class SendBotQueryOutput {
        public int cache_timeout;
        public boolean has_continue;
        public String next_start_id;
        public PresentationType presentation;
        public PreviewType preview_type;
        public String query_id;
        public ArrayList<QueryResultObject> results;
        public SwitchBotObject switch_bot;
        public Type type;

        public enum PresentationType {
            List,
            Media
        }

        public enum PreviewType {
            Sticker,
            Gif,
            Music,
            ImageFile,
            ImageUrl,
            Voice,
            None
        }

        public enum Type {
            Text,
            FileInline,
            FileInlineCaption,
            Sticker,
            Location,
            ContactMessage
        }
    }

    public static class SendMessageApiCallInput {
        public AuxDataObject aux_data;
        public FileInlineObject file_inline;
        public LocationObject location;
        public long message_id;
        public String object_guid;
        public String text;
    }

    public static class SendMessageApiCallOutput {
        public ChatUpdateObject chat_update;
        public ArrayList<MessageUpdateObject> message_updates;
    }

    public static class SetPaymentStatusInput {
        public String payment_id;
    }

    public static class SetPaymentStatusOutput {
        public ChatUpdateObject chat_update;
        public ArrayList<MessageUpdateObject> message_updates;
    }

    public static class StopBotInput {
        public String bot_guid;
    }

    public static class StopBotOutput {
        public ChatUpdateObject chat_update;
    }

    public static class SwitchBotObject {
        public String bot_start_id;
        public String button_text;
        public String start_message;
    }

    public static class FileView {
        public FileInlineObject file;
        public int height;
        public int size;
        public int width;

        public void setFileInlineAttr() {
            FileInlineObject fileInlineObject = this.file;
            fileInlineObject.width = this.width;
            fileInlineObject.height = this.height;
            fileInlineObject.size = this.size;
        }
    }
}
