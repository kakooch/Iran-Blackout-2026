package ir.aaap.messengercore.db;

import android.util.Log;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.CoreUtilities;
import ir.aaap.messengercore.JsonHelper;
import ir.aaap.messengercore.MessageUtils;
import ir.aaap.messengercore.db.DB;
import ir.aaap.messengercore.db.WhereCondition;
import ir.aaap.messengercore.exceptions.InvalidInputException2;
import ir.aaap.messengercore.model.AvatarFileInline;
import ir.aaap.messengercore.model.BotInfo;
import ir.aaap.messengercore.model.ChannelInfo;
import ir.aaap.messengercore.model.ChannelInfoFromServer;
import ir.aaap.messengercore.model.Chat;
import ir.aaap.messengercore.model.ChatAbsObject;
import ir.aaap.messengercore.model.ChatExtra;
import ir.aaap.messengercore.model.ChatFromServer;
import ir.aaap.messengercore.model.ChatMessage;
import ir.aaap.messengercore.model.ChatParamUpdateTimeObject;
import ir.aaap.messengercore.model.ChatReactionSetting;
import ir.aaap.messengercore.model.ChatType;
import ir.aaap.messengercore.model.ContactMessageObject;
import ir.aaap.messengercore.model.FileInlineObject;
import ir.aaap.messengercore.model.FolderObject;
import ir.aaap.messengercore.model.ForwardedNoLinkObject;
import ir.aaap.messengercore.model.GroupInfo;
import ir.aaap.messengercore.model.GroupInfoFromServer;
import ir.aaap.messengercore.model.KeyPadObject;
import ir.aaap.messengercore.model.KeypadRow;
import ir.aaap.messengercore.model.LiveLocationObject;
import ir.aaap.messengercore.model.LiveModels;
import ir.aaap.messengercore.model.LocationObject;
import ir.aaap.messengercore.model.Message;
import ir.aaap.messengercore.model.MessageCallData;
import ir.aaap.messengercore.model.MessageHoleObject;
import ir.aaap.messengercore.model.MessageParamUpdateTimeObject;
import ir.aaap.messengercore.model.MessageReactionObject;
import ir.aaap.messengercore.model.MessageUpdateResult;
import ir.aaap.messengercore.model.MetaDataObject;
import ir.aaap.messengercore.model.MetaDataPartObject;
import ir.aaap.messengercore.model.NotificationModels;
import ir.aaap.messengercore.model.ObjectGuidType;
import ir.aaap.messengercore.model.OnlineTimeObject;
import ir.aaap.messengercore.model.PhoneBookObject;
import ir.aaap.messengercore.model.PollObject;
import ir.aaap.messengercore.model.ProductMessageData;
import ir.aaap.messengercore.model.RubinoPostData;
import ir.aaap.messengercore.model.RubinoStoryData;
import ir.aaap.messengercore.model.ServiceInfo;
import ir.aaap.messengercore.model.StickerObject;
import ir.aaap.messengercore.model.UserInfo;
import ir.aaap.messengercore.model.UserInfoFromServer;
import ir.aaap.messengercore.model.WalletTransferDataObject;
import ir.aaap.messengercore.model.WarningObject;
import ir.aaap.messengercore.model.api.BotCommandObject;
import ir.aaap.messengercore.model.api.GetStickerSetByIdOutput;
import ir.aaap.messengercore.model.api.InSearchObject;
import ir.aaap.messengercore.utilites.CoreLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class DBHelperImpl implements DBHelper {
    private CoreLog coreLog;
    private DB db;
    private JsonHelper jsonHelper;

    enum AbsColumn {
        guid1,
        type2,
        title3,
        avatar_thumbnail_file_id4,
        avatar_thumbnail_access_hash5,
        avatar_thumbnail_dc_id6,
        first_name7,
        last_name8,
        is_deleted9,
        is_verified10,
        updated_time11
    }

    enum BotInfoColumn {
        bot_guid1,
        username2,
        warning_json3,
        start_message4,
        description5,
        share_url6,
        commands_json7,
        updated_time8
    }

    enum ChannelInfoColumn {
        channel_guid1,
        count_members2,
        username3,
        description4,
        warning_info_json5,
        sign_messages6,
        channel_type7,
        insertedTime8,
        share_url9,
        chat_reaction_setting10
    }

    enum ChatHintColumn {
        guid1,
        insertedToDbTime2,
        rate3
    }

    enum ContactColumn {
        user_guid1,
        online_time_type18,
        online_time_exact_time19,
        online_time_approximate_period20
    }

    public static class FindMessageIdResult {
        public boolean isFound;
        public long messageId;
    }

    enum FolderColumn {
        folder_id1,
        name2,
        include_objects_json3,
        exclude_objects_json4,
        pinned_objects_json5,
        include_chat_types_json6,
        exclude_chat_types_json7,
        order8,
        suggestion_folder_id9
    }

    public enum FunctionEnum {
        Abs
    }

    enum GroupInfoColumn {
        group_guid1,
        count_members2,
        warning_info3,
        description4,
        slow_mode5,
        chat_history_for_new_members6,
        event_messages7,
        insertedTime8,
        chat_reaction_setting9
    }

    enum MessageHoleColumn {
        guid1,
        start2,
        end3,
        type4
    }

    enum MyStickerSetColumn {
        sticker_set_id_1,
        updatedTime_2,
        sticker_set_data_3
    }

    enum NotificationColumn {
        notification_id1,
        type2,
        title3,
        text4,
        image_file_id5,
        message_data_object_guid6,
        message_data_object_type7,
        message_data_message_id8,
        not_message_data_object_guid9,
        not_message_data_object_type10,
        not_message_data_time11,
        is_read12,
        time13,
        textMetaData14
    }

    enum PhoneBookColumn {
        phone,
        firstName,
        lastName
    }

    enum RecentChatColumn {
        guid1,
        insertedToDbTime2,
        data3
    }

    enum RecentGifColumn {
        file_id_1,
        last_used_time_millis_2,
        gif_data_3
    }

    enum RecentOrFavoriteStickerColumn {
        sticker_id_1,
        sticker_set_id_2,
        last_used_time_millis_3,
        type_4,
        sticker_data_5
    }

    enum SentFileColumn {
        path1,
        data2,
        updated_time3
    }

    enum ServiceColumn {
        service_guid1,
        description2,
        warning_json3,
        updated_time4
    }

    public enum TableName {
        messageTable,
        messageHoleTable,
        chatTable,
        chatExtraTable,
        absTable,
        userTable,
        contactTable,
        phoneBookTable,
        channelInfoTable,
        groupInfoTable,
        recentOrFavoriteStickerTable,
        myStickerSetTable,
        recentGifTable,
        folderTable,
        recentChatTable,
        chatHintTable,
        serviceTable,
        botInfoTable,
        notificationTable,
        sentFileTable
    }

    enum UserColumn {
        user_guid1,
        phone4,
        username5,
        bio10,
        count_common_groups14,
        warning_info_json15,
        can_receive_call16,
        can_video_call17,
        online_time_type18,
        online_time_exact_time19,
        online_time_approximate_period20,
        timeStamp21,
        insertedTime22
    }

    public DBHelperImpl(final DB db, JsonHelper jsonHelper, CoreLog coreLog) {
        this.db = db;
        this.jsonHelper = jsonHelper;
        this.coreLog = coreLog;
        db.init(new DB.Delegate() { // from class: ir.aaap.messengercore.db.DBHelperImpl.1
            @Override // ir.aaap.messengercore.db.DB.Delegate
            public void onCreate() {
                DBHelperImpl.this.initDatabase();
            }

            @Override // ir.aaap.messengercore.db.DB.Delegate
            public void onUpgrade(int i, int i2) {
                if (i < 1) {
                    for (TableName tableName : TableName.values()) {
                        db.dropTable(tableName.name());
                    }
                    onCreate();
                    return;
                }
                if (i < 2) {
                    DBHelperImpl.this.version_to2();
                }
                if (i < 3) {
                    DBHelperImpl.this.version_to3();
                }
                if (i < 4) {
                    DBHelperImpl.this.version_to4();
                }
                if (i < 5) {
                    DBHelperImpl.this.version_to5();
                }
                if (i < 6) {
                    DBHelperImpl.this.version_to6();
                }
                if (i < 7) {
                    DBHelperImpl.this.version_to7();
                }
                if (i < 8) {
                    DBHelperImpl.this.version_to8();
                }
                if (i < 9) {
                    DBHelperImpl.this.version_to9();
                }
                if (i < 10) {
                    DBHelperImpl.this.version_to10();
                }
                if (i < 11) {
                    DBHelperImpl.this.version_to11();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void version_to2() {
        DB db = this.db;
        String strName = TableName.messageTable.name();
        MessageColumn messageColumn = MessageColumn.product_message_data78;
        db.alterTableAddColumn(strName, messageColumn.name(), messageColumn.type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void version_to3() {
        DB db = this.db;
        String strName = TableName.messageTable.name();
        MessageColumn messageColumn = MessageColumn.wallet_transfer_data79;
        db.alterTableAddColumn(strName, messageColumn.name(), messageColumn.type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void version_to4() {
        DB db = this.db;
        String strName = TableName.messageTable.name();
        MessageColumn messageColumn = MessageColumn.live_title80;
        db.alterTableAddColumn(strName, messageColumn.name(), messageColumn.type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void version_to5() {
        createSentFileTable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void version_to6() {
        DB db = this.db;
        TableName tableName = TableName.notificationTable;
        db.removeObject(tableName.name(), null);
        this.db.alterTableAddColumn(tableName.name(), NotificationColumn.time13.name(), DB.ColumnTypeEnum.IntegerDefault0);
        DB db2 = this.db;
        String strName = TableName.messageTable.name();
        MessageColumn messageColumn = MessageColumn.is_banned81;
        db2.alterTableAddColumn(strName, messageColumn.name(), messageColumn.type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void version_to7() {
        DB db = this.db;
        String strName = TableName.messageTable.name();
        MessageColumn messageColumn = MessageColumn.file_inline_cdn_tag82;
        db.alterTableAddColumn(strName, messageColumn.name(), messageColumn.type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void version_to8() {
        DB db = this.db;
        String strName = TableName.groupInfoTable.name();
        String strName2 = GroupInfoColumn.chat_reaction_setting9.name();
        DB.ColumnTypeEnum columnTypeEnum = DB.ColumnTypeEnum.LongText;
        db.alterTableAddColumn(strName, strName2, columnTypeEnum);
        this.db.alterTableAddColumn(TableName.channelInfoTable.name(), ChannelInfoColumn.chat_reaction_setting10.name(), columnTypeEnum);
        DB db2 = this.db;
        String strName3 = TableName.messageTable.name();
        MessageColumn messageColumn = MessageColumn.reactions83;
        db2.alterTableAddColumn(strName3, messageColumn.name(), messageColumn.type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void version_to9() {
        DB db = this.db;
        String strName = TableName.messageTable.name();
        MessageColumn messageColumn = MessageColumn.sticker_file_cdn_tag84;
        db.alterTableAddColumn(strName, messageColumn.name(), messageColumn.type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void version_to10() {
        DB db = this.db;
        TableName tableName = TableName.chatTable;
        db.alterTableAddColumn(tableName.name(), ChatColumn.pinned_message_ids37.name(), MessageColumn.local_attached_path_orginal37.type);
        DB db2 = this.db;
        String strName = tableName.name();
        ChatColumn chatColumn = ChatColumn.last_message_metadata_json38;
        db2.alterTableAddColumn(strName, chatColumn.name(), chatColumn.type);
        DB db3 = this.db;
        String strName2 = TableName.chatExtraTable.name();
        ChatExtraColumn chatExtraColumn = ChatExtraColumn.local_last_message_metadata_json13;
        db3.alterTableAddColumn(strName2, chatExtraColumn.name(), chatExtraColumn.type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void version_to11() {
        this.db.alterTableAddColumn(TableName.notificationTable.name(), NotificationColumn.textMetaData14.name(), DB.ColumnTypeEnum.LongText);
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'object_guid1' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    static final class MessageColumn {
        private static final /* synthetic */ MessageColumn[] $VALUES;
        public static final MessageColumn author_object_guid3;
        public static final MessageColumn author_signature65;
        public static final MessageColumn author_type4;
        public static final MessageColumn call_data_json59;
        public static final MessageColumn count_seen19;
        public static final MessageColumn event_json64;
        public static final MessageColumn file_inline_access_hash_rec9;
        public static final MessageColumn file_inline_auto_play16;
        public static final MessageColumn file_inline_cdn_tag82;
        public static final MessageColumn file_inline_dc_id8;
        public static final MessageColumn file_inline_file_id6;
        public static final MessageColumn file_inline_file_name10;
        public static final MessageColumn file_inline_height12;
        public static final MessageColumn file_inline_is_round75;
        public static final MessageColumn file_inline_mime7;
        public static final MessageColumn file_inline_performer46;
        public static final MessageColumn file_inline_size14;
        public static final MessageColumn file_inline_thumb_inline45;
        public static final MessageColumn file_inline_time13;
        public static final MessageColumn file_inline_type15;
        public static final MessageColumn file_inline_width11;
        public static final MessageColumn forward_message_id22;
        public static final MessageColumn forward_object_guid23;
        public static final MessageColumn forward_type_from21;
        public static final MessageColumn forwarded_no_link_from_title56;
        public static final MessageColumn isDeleted66;
        public static final MessageColumn isLocallyEdited72;
        public static final MessageColumn is_banned81;
        public static final MessageColumn is_edited20;
        public static final MessageColumn is_local_deleted34;
        public static final MessageColumn json_contact38;
        public static final MessageColumn json_poll44;
        public static final MessageColumn key_pad_json57;
        public static final MessageColumn live_access_token61;
        public static final MessageColumn live_id60;
        public static final MessageColumn live_loc_current_location_lat48;
        public static final MessageColumn live_loc_current_location_lon49;
        public static final MessageColumn live_loc_device_hash50;
        public static final MessageColumn live_loc_last_update_time55;
        public static final MessageColumn live_loc_live_period54;
        public static final MessageColumn live_loc_start_time53;
        public static final MessageColumn live_loc_status52;
        public static final MessageColumn live_loc_track_id47;
        public static final MessageColumn live_loc_user_guid51;
        public static final MessageColumn live_status_json62;
        public static final MessageColumn live_thumb_inline74;
        public static final MessageColumn live_title80;
        public static final MessageColumn localParameters69;
        public static final MessageColumn local_attached_path36;
        public static final MessageColumn local_attached_path_orginal37;
        public static final MessageColumn local_deleted_type_35;
        public static final MessageColumn location_latitude26;
        public static final MessageColumn location_longitude25;
        public static final MessageColumn message_id2;
        public static final MessageColumn metadata_json63;
        public static final MessageColumn object_guid1;
        public static final MessageColumn payment_data_json58;
        public static final MessageColumn product_message_data78;
        public static final MessageColumn reactions83;
        public static final MessageColumn reply_timeout24;
        public static final MessageColumn reply_to_message_id17;
        public static final MessageColumn rubino_post_data;
        public static final MessageColumn rubino_story_data;
        public static final MessageColumn sendState71;
        public static final MessageColumn sticker_access_hash_rec31;
        public static final MessageColumn sticker_dc_id30;
        public static final MessageColumn sticker_emoji_character32;
        public static final MessageColumn sticker_file_cdn_tag84;
        public static final MessageColumn sticker_file_id29;
        public static final MessageColumn sticker_id27;
        public static final MessageColumn sticker_sticker_set_id33;
        public static final MessageColumn sticker_w_h_ratio28;
        public static final MessageColumn text5;
        public static final MessageColumn time18;
        public static final MessageColumn timeMillis70;
        public static final MessageColumn timeStamp67;
        public static final MessageColumn type39;
        public static final MessageColumn via_bot_guid73;
        public static final MessageColumn wallet_transfer_data79;
        private DB.ColumnTypeEnum type;

        public static MessageColumn valueOf(String str) {
            return (MessageColumn) Enum.valueOf(MessageColumn.class, str);
        }

        public static MessageColumn[] values() {
            return (MessageColumn[]) $VALUES.clone();
        }

        static {
            DB.ColumnTypeEnum columnTypeEnum = DB.ColumnTypeEnum.Varchar100;
            MessageColumn messageColumn = new MessageColumn("object_guid1", 0, columnTypeEnum);
            object_guid1 = messageColumn;
            DB.ColumnTypeEnum columnTypeEnum2 = DB.ColumnTypeEnum.IntegerDefault0;
            MessageColumn messageColumn2 = new MessageColumn("message_id2", 1, columnTypeEnum2);
            message_id2 = messageColumn2;
            MessageColumn messageColumn3 = new MessageColumn("author_object_guid3", 2, columnTypeEnum);
            author_object_guid3 = messageColumn3;
            DB.ColumnTypeEnum columnTypeEnum3 = DB.ColumnTypeEnum.Varchar20;
            MessageColumn messageColumn4 = new MessageColumn("author_type4", 3, columnTypeEnum3);
            author_type4 = messageColumn4;
            DB.ColumnTypeEnum columnTypeEnum4 = DB.ColumnTypeEnum.LongText;
            MessageColumn messageColumn5 = new MessageColumn("text5", 4, columnTypeEnum4);
            text5 = messageColumn5;
            DB.ColumnTypeEnum columnTypeEnum5 = DB.ColumnTypeEnum.Integer;
            MessageColumn messageColumn6 = new MessageColumn("file_inline_file_id6", 5, columnTypeEnum5);
            file_inline_file_id6 = messageColumn6;
            MessageColumn messageColumn7 = new MessageColumn("file_inline_mime7", 6, columnTypeEnum3);
            file_inline_mime7 = messageColumn7;
            DB.ColumnTypeEnum columnTypeEnum6 = DB.ColumnTypeEnum.Varchar60;
            MessageColumn messageColumn8 = new MessageColumn("file_inline_dc_id8", 7, columnTypeEnum6);
            file_inline_dc_id8 = messageColumn8;
            MessageColumn messageColumn9 = new MessageColumn("file_inline_access_hash_rec9", 8, columnTypeEnum);
            file_inline_access_hash_rec9 = messageColumn9;
            MessageColumn messageColumn10 = new MessageColumn("file_inline_file_name10", 9, columnTypeEnum);
            file_inline_file_name10 = messageColumn10;
            MessageColumn messageColumn11 = new MessageColumn("file_inline_width11", 10, columnTypeEnum5);
            file_inline_width11 = messageColumn11;
            MessageColumn messageColumn12 = new MessageColumn("file_inline_height12", 11, columnTypeEnum5);
            file_inline_height12 = messageColumn12;
            MessageColumn messageColumn13 = new MessageColumn("file_inline_time13", 12, columnTypeEnum5);
            file_inline_time13 = messageColumn13;
            MessageColumn messageColumn14 = new MessageColumn("file_inline_size14", 13, columnTypeEnum5);
            file_inline_size14 = messageColumn14;
            MessageColumn messageColumn15 = new MessageColumn("file_inline_type15", 14, columnTypeEnum6);
            file_inline_type15 = messageColumn15;
            MessageColumn messageColumn16 = new MessageColumn("file_inline_auto_play16", 15, columnTypeEnum5);
            file_inline_auto_play16 = messageColumn16;
            MessageColumn messageColumn17 = new MessageColumn("reply_to_message_id17", 16, columnTypeEnum5);
            reply_to_message_id17 = messageColumn17;
            MessageColumn messageColumn18 = new MessageColumn("time18", 17, columnTypeEnum5);
            time18 = messageColumn18;
            MessageColumn messageColumn19 = new MessageColumn("count_seen19", 18, columnTypeEnum5);
            count_seen19 = messageColumn19;
            MessageColumn messageColumn20 = new MessageColumn("is_edited20", 19, columnTypeEnum2);
            is_edited20 = messageColumn20;
            MessageColumn messageColumn21 = new MessageColumn("forward_type_from21", 20, columnTypeEnum6);
            forward_type_from21 = messageColumn21;
            MessageColumn messageColumn22 = new MessageColumn("forward_message_id22", 21, columnTypeEnum5);
            forward_message_id22 = messageColumn22;
            MessageColumn messageColumn23 = new MessageColumn("forward_object_guid23", 22, columnTypeEnum);
            forward_object_guid23 = messageColumn23;
            MessageColumn messageColumn24 = new MessageColumn("reply_timeout24", 23, columnTypeEnum5);
            reply_timeout24 = messageColumn24;
            DB.ColumnTypeEnum columnTypeEnum7 = DB.ColumnTypeEnum.Real;
            MessageColumn messageColumn25 = new MessageColumn("location_longitude25", 24, columnTypeEnum7);
            location_longitude25 = messageColumn25;
            MessageColumn messageColumn26 = new MessageColumn("location_latitude26", 25, columnTypeEnum7);
            location_latitude26 = messageColumn26;
            MessageColumn messageColumn27 = new MessageColumn("sticker_id27", 26, columnTypeEnum);
            sticker_id27 = messageColumn27;
            MessageColumn messageColumn28 = new MessageColumn("sticker_w_h_ratio28", 27, columnTypeEnum7);
            sticker_w_h_ratio28 = messageColumn28;
            MessageColumn messageColumn29 = new MessageColumn("sticker_file_id29", 28, columnTypeEnum5);
            sticker_file_id29 = messageColumn29;
            MessageColumn messageColumn30 = new MessageColumn("sticker_dc_id30", 29, columnTypeEnum6);
            sticker_dc_id30 = messageColumn30;
            MessageColumn messageColumn31 = new MessageColumn("sticker_access_hash_rec31", 30, columnTypeEnum);
            sticker_access_hash_rec31 = messageColumn31;
            MessageColumn messageColumn32 = new MessageColumn("sticker_emoji_character32", 31, columnTypeEnum6);
            sticker_emoji_character32 = messageColumn32;
            MessageColumn messageColumn33 = new MessageColumn("sticker_sticker_set_id33", 32, columnTypeEnum);
            sticker_sticker_set_id33 = messageColumn33;
            MessageColumn messageColumn34 = new MessageColumn("is_local_deleted34", 33, columnTypeEnum2);
            is_local_deleted34 = messageColumn34;
            MessageColumn messageColumn35 = new MessageColumn("local_deleted_type_35", 34, columnTypeEnum3);
            local_deleted_type_35 = messageColumn35;
            DB.ColumnTypeEnum columnTypeEnum8 = DB.ColumnTypeEnum.Varchar300;
            MessageColumn messageColumn36 = new MessageColumn("local_attached_path36", 35, columnTypeEnum8);
            local_attached_path36 = messageColumn36;
            MessageColumn messageColumn37 = new MessageColumn("local_attached_path_orginal37", 36, columnTypeEnum8);
            local_attached_path_orginal37 = messageColumn37;
            MessageColumn messageColumn38 = new MessageColumn("json_contact38", 37, columnTypeEnum4);
            json_contact38 = messageColumn38;
            MessageColumn messageColumn39 = new MessageColumn("type39", 38, columnTypeEnum3);
            type39 = messageColumn39;
            MessageColumn messageColumn40 = new MessageColumn("json_poll44", 39, columnTypeEnum4);
            json_poll44 = messageColumn40;
            MessageColumn messageColumn41 = new MessageColumn("file_inline_thumb_inline45", 40, columnTypeEnum4);
            file_inline_thumb_inline45 = messageColumn41;
            MessageColumn messageColumn42 = new MessageColumn("file_inline_performer46", 41, columnTypeEnum);
            file_inline_performer46 = messageColumn42;
            MessageColumn messageColumn43 = new MessageColumn("live_loc_track_id47", 42, columnTypeEnum);
            live_loc_track_id47 = messageColumn43;
            MessageColumn messageColumn44 = new MessageColumn("live_loc_current_location_lat48", 43, columnTypeEnum7);
            live_loc_current_location_lat48 = messageColumn44;
            MessageColumn messageColumn45 = new MessageColumn("live_loc_current_location_lon49", 44, columnTypeEnum7);
            live_loc_current_location_lon49 = messageColumn45;
            MessageColumn messageColumn46 = new MessageColumn("live_loc_device_hash50", 45, columnTypeEnum);
            live_loc_device_hash50 = messageColumn46;
            MessageColumn messageColumn47 = new MessageColumn("live_loc_user_guid51", 46, columnTypeEnum);
            live_loc_user_guid51 = messageColumn47;
            MessageColumn messageColumn48 = new MessageColumn("live_loc_status52", 47, columnTypeEnum);
            live_loc_status52 = messageColumn48;
            MessageColumn messageColumn49 = new MessageColumn("live_loc_start_time53", 48, columnTypeEnum5);
            live_loc_start_time53 = messageColumn49;
            MessageColumn messageColumn50 = new MessageColumn("live_loc_live_period54", 49, columnTypeEnum5);
            live_loc_live_period54 = messageColumn50;
            MessageColumn messageColumn51 = new MessageColumn("live_loc_last_update_time55", 50, columnTypeEnum5);
            live_loc_last_update_time55 = messageColumn51;
            MessageColumn messageColumn52 = new MessageColumn("forwarded_no_link_from_title56", 51, columnTypeEnum);
            forwarded_no_link_from_title56 = messageColumn52;
            MessageColumn messageColumn53 = new MessageColumn("key_pad_json57", 52, columnTypeEnum4);
            key_pad_json57 = messageColumn53;
            MessageColumn messageColumn54 = new MessageColumn("payment_data_json58", 53, columnTypeEnum4);
            payment_data_json58 = messageColumn54;
            MessageColumn messageColumn55 = new MessageColumn("call_data_json59", 54, columnTypeEnum4);
            call_data_json59 = messageColumn55;
            MessageColumn messageColumn56 = new MessageColumn("live_id60", 55, columnTypeEnum6);
            live_id60 = messageColumn56;
            MessageColumn messageColumn57 = new MessageColumn("live_access_token61", 56, columnTypeEnum);
            live_access_token61 = messageColumn57;
            MessageColumn messageColumn58 = new MessageColumn("live_status_json62", 57, columnTypeEnum4);
            live_status_json62 = messageColumn58;
            MessageColumn messageColumn59 = new MessageColumn("metadata_json63", 58, columnTypeEnum4);
            metadata_json63 = messageColumn59;
            MessageColumn messageColumn60 = new MessageColumn("event_json64", 59, columnTypeEnum4);
            event_json64 = messageColumn60;
            MessageColumn messageColumn61 = new MessageColumn("author_signature65", 60, columnTypeEnum);
            author_signature65 = messageColumn61;
            MessageColumn messageColumn62 = new MessageColumn("isDeleted66", 61, columnTypeEnum2);
            isDeleted66 = messageColumn62;
            MessageColumn messageColumn63 = new MessageColumn("timeStamp67", 62, columnTypeEnum5);
            timeStamp67 = messageColumn63;
            MessageColumn messageColumn64 = new MessageColumn("localParameters69", 63, columnTypeEnum4);
            localParameters69 = messageColumn64;
            MessageColumn messageColumn65 = new MessageColumn("timeMillis70", 64, columnTypeEnum5);
            timeMillis70 = messageColumn65;
            MessageColumn messageColumn66 = new MessageColumn("sendState71", 65, columnTypeEnum2);
            sendState71 = messageColumn66;
            MessageColumn messageColumn67 = new MessageColumn("isLocallyEdited72", 66, columnTypeEnum2);
            isLocallyEdited72 = messageColumn67;
            MessageColumn messageColumn68 = new MessageColumn("via_bot_guid73", 67, columnTypeEnum);
            via_bot_guid73 = messageColumn68;
            MessageColumn messageColumn69 = new MessageColumn("live_thumb_inline74", 68, columnTypeEnum4);
            live_thumb_inline74 = messageColumn69;
            MessageColumn messageColumn70 = new MessageColumn("file_inline_is_round75", 69, columnTypeEnum5);
            file_inline_is_round75 = messageColumn70;
            MessageColumn messageColumn71 = new MessageColumn("rubino_story_data", 70, columnTypeEnum4);
            rubino_story_data = messageColumn71;
            MessageColumn messageColumn72 = new MessageColumn("rubino_post_data", 71, columnTypeEnum4);
            rubino_post_data = messageColumn72;
            MessageColumn messageColumn73 = new MessageColumn("product_message_data78", 72, columnTypeEnum4);
            product_message_data78 = messageColumn73;
            MessageColumn messageColumn74 = new MessageColumn("wallet_transfer_data79", 73, columnTypeEnum4);
            wallet_transfer_data79 = messageColumn74;
            MessageColumn messageColumn75 = new MessageColumn("live_title80", 74, columnTypeEnum);
            live_title80 = messageColumn75;
            MessageColumn messageColumn76 = new MessageColumn("is_banned81", 75, columnTypeEnum2);
            is_banned81 = messageColumn76;
            MessageColumn messageColumn77 = new MessageColumn("file_inline_cdn_tag82", 76, columnTypeEnum6);
            file_inline_cdn_tag82 = messageColumn77;
            MessageColumn messageColumn78 = new MessageColumn("reactions83", 77, columnTypeEnum4);
            reactions83 = messageColumn78;
            MessageColumn messageColumn79 = new MessageColumn("sticker_file_cdn_tag84", 78, columnTypeEnum6);
            sticker_file_cdn_tag84 = messageColumn79;
            $VALUES = new MessageColumn[]{messageColumn, messageColumn2, messageColumn3, messageColumn4, messageColumn5, messageColumn6, messageColumn7, messageColumn8, messageColumn9, messageColumn10, messageColumn11, messageColumn12, messageColumn13, messageColumn14, messageColumn15, messageColumn16, messageColumn17, messageColumn18, messageColumn19, messageColumn20, messageColumn21, messageColumn22, messageColumn23, messageColumn24, messageColumn25, messageColumn26, messageColumn27, messageColumn28, messageColumn29, messageColumn30, messageColumn31, messageColumn32, messageColumn33, messageColumn34, messageColumn35, messageColumn36, messageColumn37, messageColumn38, messageColumn39, messageColumn40, messageColumn41, messageColumn42, messageColumn43, messageColumn44, messageColumn45, messageColumn46, messageColumn47, messageColumn48, messageColumn49, messageColumn50, messageColumn51, messageColumn52, messageColumn53, messageColumn54, messageColumn55, messageColumn56, messageColumn57, messageColumn58, messageColumn59, messageColumn60, messageColumn61, messageColumn62, messageColumn63, messageColumn64, messageColumn65, messageColumn66, messageColumn67, messageColumn68, messageColumn69, messageColumn70, messageColumn71, messageColumn72, messageColumn73, messageColumn74, messageColumn75, messageColumn76, messageColumn77, messageColumn78, messageColumn79};
        }

        private MessageColumn(String str, int i, DB.ColumnTypeEnum columnTypeEnum) {
            this.type = columnTypeEnum;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'object_guid1' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    static final class ChatColumn {
        private static final /* synthetic */ ChatColumn[] $VALUES;
        public static final ChatColumn absObject_first_name19;
        public static final ChatColumn absObject_is_deleted26;
        public static final ChatColumn absObject_is_verified25;
        public static final ChatColumn absObject_last_name20;
        public static final ChatColumn absObject_object_guid17;
        public static final ChatColumn absObject_title18;
        public static final ChatColumn absObject_type24;
        public static final ChatColumn access2;
        public static final ChatColumn avatar_thumbnail_access_hash_rec23;
        public static final ChatColumn avatar_thumbnail_dc_id22;
        public static final ChatColumn avatar_thumbnail_file_id21;
        public static final ChatColumn chat_keypad_json_32;
        public static final ChatColumn chat_keypad_timestamp_33;
        public static final ChatColumn count_unseen3;
        public static final ChatColumn group_my_last_send_time36;
        public static final ChatColumn group_voice_chat_id68;
        public static final ChatColumn is_blocked29;
        public static final ChatColumn is_in_contact34;
        public static final ChatColumn is_mute4;
        public static final ChatColumn is_pinned5;
        public static final ChatColumn last_deleted_mid31;
        public static final ChatColumn last_message_author_object_guid10;
        public static final ChatColumn last_message_author_title13;
        public static final ChatColumn last_message_author_type11;
        public static final ChatColumn last_message_id30;
        public static final ChatColumn last_message_is_mine12;
        public static final ChatColumn last_message_message_id7;
        public static final ChatColumn last_message_metadata_json38;
        public static final ChatColumn last_message_text9;
        public static final ChatColumn last_message_type8;
        public static final ChatColumn last_seen_my_mid14;
        public static final ChatColumn last_seen_peer_mid15;
        public static final ChatColumn object_guid1;
        public static final ChatColumn pinned_message_id28;
        public static final ChatColumn pinned_message_ids37;
        public static final ChatColumn show_ask_spam69;
        public static final ChatColumn slow_mode_duration35;
        public static final ChatColumn status16;
        public static final ChatColumn time27;
        public static final ChatColumn time_string6;
        public static final ChatColumn timestamp64;
        private DB.ColumnTypeEnum type;

        public static ChatColumn valueOf(String str) {
            return (ChatColumn) Enum.valueOf(ChatColumn.class, str);
        }

        public static ChatColumn[] values() {
            return (ChatColumn[]) $VALUES.clone();
        }

        static {
            DB.ColumnTypeEnum columnTypeEnum = DB.ColumnTypeEnum.Varchar100;
            ChatColumn chatColumn = new ChatColumn("object_guid1", 0, columnTypeEnum);
            object_guid1 = chatColumn;
            ChatColumn chatColumn2 = new ChatColumn("access2", 1, columnTypeEnum);
            access2 = chatColumn2;
            ChatColumn chatColumn3 = new ChatColumn("count_unseen3", 2, columnTypeEnum);
            count_unseen3 = chatColumn3;
            DB.ColumnTypeEnum columnTypeEnum2 = DB.ColumnTypeEnum.IntegerDefault0;
            ChatColumn chatColumn4 = new ChatColumn("is_mute4", 3, columnTypeEnum2);
            is_mute4 = chatColumn4;
            ChatColumn chatColumn5 = new ChatColumn("is_pinned5", 4, columnTypeEnum2);
            is_pinned5 = chatColumn5;
            ChatColumn chatColumn6 = new ChatColumn("time_string6", 5, columnTypeEnum);
            time_string6 = chatColumn6;
            DB.ColumnTypeEnum columnTypeEnum3 = DB.ColumnTypeEnum.Integer;
            ChatColumn chatColumn7 = new ChatColumn("last_message_message_id7", 6, columnTypeEnum3);
            last_message_message_id7 = chatColumn7;
            DB.ColumnTypeEnum columnTypeEnum4 = DB.ColumnTypeEnum.Varchar20;
            ChatColumn chatColumn8 = new ChatColumn("last_message_type8", 7, columnTypeEnum4);
            last_message_type8 = chatColumn8;
            DB.ColumnTypeEnum columnTypeEnum5 = DB.ColumnTypeEnum.LongText;
            ChatColumn chatColumn9 = new ChatColumn("last_message_text9", 8, columnTypeEnum5);
            last_message_text9 = chatColumn9;
            ChatColumn chatColumn10 = new ChatColumn("last_message_author_object_guid10", 9, columnTypeEnum);
            last_message_author_object_guid10 = chatColumn10;
            ChatColumn chatColumn11 = new ChatColumn("last_message_author_type11", 10, columnTypeEnum4);
            last_message_author_type11 = chatColumn11;
            ChatColumn chatColumn12 = new ChatColumn("last_message_is_mine12", 11, columnTypeEnum2);
            last_message_is_mine12 = chatColumn12;
            ChatColumn chatColumn13 = new ChatColumn("last_message_author_title13", 12, columnTypeEnum);
            last_message_author_title13 = chatColumn13;
            ChatColumn chatColumn14 = new ChatColumn("last_seen_my_mid14", 13, columnTypeEnum3);
            last_seen_my_mid14 = chatColumn14;
            ChatColumn chatColumn15 = new ChatColumn("last_seen_peer_mid15", 14, columnTypeEnum3);
            last_seen_peer_mid15 = chatColumn15;
            ChatColumn chatColumn16 = new ChatColumn("status16", 15, columnTypeEnum4);
            status16 = chatColumn16;
            ChatColumn chatColumn17 = new ChatColumn("absObject_object_guid17", 16, columnTypeEnum);
            absObject_object_guid17 = chatColumn17;
            ChatColumn chatColumn18 = new ChatColumn("absObject_title18", 17, columnTypeEnum);
            absObject_title18 = chatColumn18;
            ChatColumn chatColumn19 = new ChatColumn("absObject_first_name19", 18, columnTypeEnum);
            absObject_first_name19 = chatColumn19;
            ChatColumn chatColumn20 = new ChatColumn("absObject_last_name20", 19, columnTypeEnum);
            absObject_last_name20 = chatColumn20;
            ChatColumn chatColumn21 = new ChatColumn("avatar_thumbnail_file_id21", 20, columnTypeEnum3);
            avatar_thumbnail_file_id21 = chatColumn21;
            ChatColumn chatColumn22 = new ChatColumn("avatar_thumbnail_dc_id22", 21, columnTypeEnum);
            avatar_thumbnail_dc_id22 = chatColumn22;
            ChatColumn chatColumn23 = new ChatColumn("avatar_thumbnail_access_hash_rec23", 22, columnTypeEnum);
            avatar_thumbnail_access_hash_rec23 = chatColumn23;
            ChatColumn chatColumn24 = new ChatColumn("absObject_type24", 23, columnTypeEnum4);
            absObject_type24 = chatColumn24;
            ChatColumn chatColumn25 = new ChatColumn("absObject_is_verified25", 24, columnTypeEnum2);
            absObject_is_verified25 = chatColumn25;
            ChatColumn chatColumn26 = new ChatColumn("absObject_is_deleted26", 25, columnTypeEnum2);
            absObject_is_deleted26 = chatColumn26;
            ChatColumn chatColumn27 = new ChatColumn("time27", 26, columnTypeEnum3);
            time27 = chatColumn27;
            ChatColumn chatColumn28 = new ChatColumn("pinned_message_id28", 27, columnTypeEnum3);
            pinned_message_id28 = chatColumn28;
            ChatColumn chatColumn29 = new ChatColumn("is_blocked29", 28, columnTypeEnum2);
            is_blocked29 = chatColumn29;
            ChatColumn chatColumn30 = new ChatColumn("last_message_id30", 29, columnTypeEnum3);
            last_message_id30 = chatColumn30;
            ChatColumn chatColumn31 = new ChatColumn("last_deleted_mid31", 30, columnTypeEnum3);
            last_deleted_mid31 = chatColumn31;
            ChatColumn chatColumn32 = new ChatColumn("pinned_message_ids37", 31, columnTypeEnum5);
            pinned_message_ids37 = chatColumn32;
            ChatColumn chatColumn33 = new ChatColumn("chat_keypad_json_32", 32, columnTypeEnum5);
            chat_keypad_json_32 = chatColumn33;
            ChatColumn chatColumn34 = new ChatColumn("chat_keypad_timestamp_33", 33, columnTypeEnum3);
            chat_keypad_timestamp_33 = chatColumn34;
            ChatColumn chatColumn35 = new ChatColumn("is_in_contact34", 34, columnTypeEnum2);
            is_in_contact34 = chatColumn35;
            ChatColumn chatColumn36 = new ChatColumn("slow_mode_duration35", 35, columnTypeEnum3);
            slow_mode_duration35 = chatColumn36;
            ChatColumn chatColumn37 = new ChatColumn("group_my_last_send_time36", 36, columnTypeEnum3);
            group_my_last_send_time36 = chatColumn37;
            ChatColumn chatColumn38 = new ChatColumn("timestamp64", 37, columnTypeEnum3);
            timestamp64 = chatColumn38;
            ChatColumn chatColumn39 = new ChatColumn("group_voice_chat_id68", 38, columnTypeEnum);
            group_voice_chat_id68 = chatColumn39;
            ChatColumn chatColumn40 = new ChatColumn("show_ask_spam69", 39, columnTypeEnum3);
            show_ask_spam69 = chatColumn40;
            ChatColumn chatColumn41 = new ChatColumn("last_message_metadata_json38", 40, columnTypeEnum5);
            last_message_metadata_json38 = chatColumn41;
            $VALUES = new ChatColumn[]{chatColumn, chatColumn2, chatColumn3, chatColumn4, chatColumn5, chatColumn6, chatColumn7, chatColumn8, chatColumn9, chatColumn10, chatColumn11, chatColumn12, chatColumn13, chatColumn14, chatColumn15, chatColumn16, chatColumn17, chatColumn18, chatColumn19, chatColumn20, chatColumn21, chatColumn22, chatColumn23, chatColumn24, chatColumn25, chatColumn26, chatColumn27, chatColumn28, chatColumn29, chatColumn30, chatColumn31, chatColumn32, chatColumn33, chatColumn34, chatColumn35, chatColumn36, chatColumn37, chatColumn38, chatColumn39, chatColumn40, chatColumn41};
        }

        private ChatColumn(String str, int i, DB.ColumnTypeEnum columnTypeEnum) {
            this.type = columnTypeEnum;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'object_guid1' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    static final class ChatExtraColumn {
        private static final /* synthetic */ ChatExtraColumn[] $VALUES;
        public static final ChatExtraColumn local_count_unseen11;
        public static final ChatExtraColumn local_last_message_author_object_guid5;
        public static final ChatExtraColumn local_last_message_author_title8;
        public static final ChatExtraColumn local_last_message_author_type6;
        public static final ChatExtraColumn local_last_message_is_mine7;
        public static final ChatExtraColumn local_last_message_message_id2;
        public static final ChatExtraColumn local_last_message_metadata_json13;
        public static final ChatExtraColumn local_last_message_prev_message_id9;
        public static final ChatExtraColumn local_last_message_send_state13;
        public static final ChatExtraColumn local_last_message_text4;
        public static final ChatExtraColumn local_last_message_type3;
        public static final ChatExtraColumn local_last_seen_my_mid10;
        public static final ChatExtraColumn local_time12;
        public static final ChatExtraColumn object_guid1;
        DB.ColumnTypeEnum type;

        public static ChatExtraColumn valueOf(String str) {
            return (ChatExtraColumn) Enum.valueOf(ChatExtraColumn.class, str);
        }

        public static ChatExtraColumn[] values() {
            return (ChatExtraColumn[]) $VALUES.clone();
        }

        static {
            DB.ColumnTypeEnum columnTypeEnum = DB.ColumnTypeEnum.Varchar100;
            ChatExtraColumn chatExtraColumn = new ChatExtraColumn("object_guid1", 0, columnTypeEnum);
            object_guid1 = chatExtraColumn;
            DB.ColumnTypeEnum columnTypeEnum2 = DB.ColumnTypeEnum.Integer;
            ChatExtraColumn chatExtraColumn2 = new ChatExtraColumn("local_last_message_message_id2", 1, columnTypeEnum2);
            local_last_message_message_id2 = chatExtraColumn2;
            DB.ColumnTypeEnum columnTypeEnum3 = DB.ColumnTypeEnum.Varchar20;
            ChatExtraColumn chatExtraColumn3 = new ChatExtraColumn("local_last_message_type3", 2, columnTypeEnum3);
            local_last_message_type3 = chatExtraColumn3;
            DB.ColumnTypeEnum columnTypeEnum4 = DB.ColumnTypeEnum.LongText;
            ChatExtraColumn chatExtraColumn4 = new ChatExtraColumn("local_last_message_text4", 3, columnTypeEnum4);
            local_last_message_text4 = chatExtraColumn4;
            ChatExtraColumn chatExtraColumn5 = new ChatExtraColumn("local_last_message_author_object_guid5", 4, columnTypeEnum);
            local_last_message_author_object_guid5 = chatExtraColumn5;
            ChatExtraColumn chatExtraColumn6 = new ChatExtraColumn("local_last_message_author_type6", 5, columnTypeEnum3);
            local_last_message_author_type6 = chatExtraColumn6;
            ChatExtraColumn chatExtraColumn7 = new ChatExtraColumn("local_last_message_is_mine7", 6, DB.ColumnTypeEnum.IntegerDefault0);
            local_last_message_is_mine7 = chatExtraColumn7;
            ChatExtraColumn chatExtraColumn8 = new ChatExtraColumn("local_last_message_author_title8", 7, columnTypeEnum);
            local_last_message_author_title8 = chatExtraColumn8;
            ChatExtraColumn chatExtraColumn9 = new ChatExtraColumn("local_last_message_prev_message_id9", 8, columnTypeEnum2);
            local_last_message_prev_message_id9 = chatExtraColumn9;
            ChatExtraColumn chatExtraColumn10 = new ChatExtraColumn("local_last_message_send_state13", 9, columnTypeEnum2);
            local_last_message_send_state13 = chatExtraColumn10;
            ChatExtraColumn chatExtraColumn11 = new ChatExtraColumn("local_last_seen_my_mid10", 10, columnTypeEnum2);
            local_last_seen_my_mid10 = chatExtraColumn11;
            ChatExtraColumn chatExtraColumn12 = new ChatExtraColumn("local_count_unseen11", 11, columnTypeEnum2);
            local_count_unseen11 = chatExtraColumn12;
            ChatExtraColumn chatExtraColumn13 = new ChatExtraColumn("local_time12", 12, columnTypeEnum2);
            local_time12 = chatExtraColumn13;
            ChatExtraColumn chatExtraColumn14 = new ChatExtraColumn("local_last_message_metadata_json13", 13, columnTypeEnum4);
            local_last_message_metadata_json13 = chatExtraColumn14;
            $VALUES = new ChatExtraColumn[]{chatExtraColumn, chatExtraColumn2, chatExtraColumn3, chatExtraColumn4, chatExtraColumn5, chatExtraColumn6, chatExtraColumn7, chatExtraColumn8, chatExtraColumn9, chatExtraColumn10, chatExtraColumn11, chatExtraColumn12, chatExtraColumn13, chatExtraColumn14};
        }

        private ChatExtraColumn(String str, int i, DB.ColumnTypeEnum columnTypeEnum) {
            this.type = columnTypeEnum;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initDatabase() {
        createMessageTable();
        createHoleTable();
        createChatTable();
        createChatExtraTable();
        createAbsTable();
        createUserTable();
        createContactTable();
        createPhoneBookTable();
        createGroupInfoTable();
        createChannelInfoTable();
        createMyStickerSetTable();
        createRecentStickerTable();
        createRecentGifTable();
        createFoldersTable();
        createRecentChatTable();
        createChatHintTable();
        createBotTable();
        createServiceTable();
        createNotificationTable();
        createSentFileTable();
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void createSentFileTable() {
        HashSet hashSet = new HashSet();
        SentFileColumn sentFileColumn = SentFileColumn.path1;
        hashSet.add(sentFileColumn.name());
        HashMap map = new HashMap();
        map.put(sentFileColumn.name(), DB.ColumnTypeEnum.Varchar100);
        map.put(SentFileColumn.data2.name(), DB.ColumnTypeEnum.LongText);
        map.put(SentFileColumn.updated_time3.name(), DB.ColumnTypeEnum.Integer);
        this.db.createTable(TableName.sentFileTable.name(), hashSet, map);
    }

    private void createNotificationTable() {
        HashSet hashSet = new HashSet();
        NotificationColumn notificationColumn = NotificationColumn.notification_id1;
        hashSet.add(notificationColumn.name());
        HashMap map = new HashMap();
        String strName = notificationColumn.name();
        DB.ColumnTypeEnum columnTypeEnum = DB.ColumnTypeEnum.Varchar100;
        map.put(strName, columnTypeEnum);
        map.put(NotificationColumn.type2.name(), columnTypeEnum);
        map.put(NotificationColumn.title3.name(), columnTypeEnum);
        String strName2 = NotificationColumn.text4.name();
        DB.ColumnTypeEnum columnTypeEnum2 = DB.ColumnTypeEnum.LongText;
        map.put(strName2, columnTypeEnum2);
        map.put(NotificationColumn.textMetaData14.name(), columnTypeEnum2);
        map.put(NotificationColumn.image_file_id5.name(), DB.ColumnTypeEnum.Integer);
        map.put(NotificationColumn.message_data_object_guid6.name(), columnTypeEnum);
        String strName3 = NotificationColumn.message_data_object_type7.name();
        DB.ColumnTypeEnum columnTypeEnum3 = DB.ColumnTypeEnum.Varchar60;
        map.put(strName3, columnTypeEnum3);
        String strName4 = NotificationColumn.message_data_message_id8.name();
        DB.ColumnTypeEnum columnTypeEnum4 = DB.ColumnTypeEnum.IntegerDefault0;
        map.put(strName4, columnTypeEnum4);
        map.put(NotificationColumn.not_message_data_object_guid9.name(), columnTypeEnum);
        map.put(NotificationColumn.not_message_data_object_type10.name(), columnTypeEnum3);
        map.put(NotificationColumn.not_message_data_time11.name(), columnTypeEnum4);
        map.put(NotificationColumn.is_read12.name(), columnTypeEnum4);
        map.put(NotificationColumn.time13.name(), columnTypeEnum4);
        this.db.createTable(TableName.notificationTable.name(), hashSet, map);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void createServiceTable() {
        HashSet hashSet = new HashSet();
        ServiceColumn serviceColumn = ServiceColumn.service_guid1;
        hashSet.add(serviceColumn.name());
        HashMap map = new HashMap();
        map.put(serviceColumn.name(), DB.ColumnTypeEnum.Varchar100);
        String strName = ServiceColumn.description2.name();
        DB.ColumnTypeEnum columnTypeEnum = DB.ColumnTypeEnum.LongText;
        map.put(strName, columnTypeEnum);
        map.put(ServiceColumn.warning_json3.name(), columnTypeEnum);
        map.put(ServiceColumn.updated_time4.name(), DB.ColumnTypeEnum.Integer);
        this.db.createTable(TableName.serviceTable.name(), hashSet, map);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void createBotTable() {
        HashSet hashSet = new HashSet();
        BotInfoColumn botInfoColumn = BotInfoColumn.bot_guid1;
        hashSet.add(botInfoColumn.name());
        HashMap map = new HashMap();
        String strName = botInfoColumn.name();
        DB.ColumnTypeEnum columnTypeEnum = DB.ColumnTypeEnum.Varchar100;
        map.put(strName, columnTypeEnum);
        String strName2 = BotInfoColumn.description5.name();
        DB.ColumnTypeEnum columnTypeEnum2 = DB.ColumnTypeEnum.LongText;
        map.put(strName2, columnTypeEnum2);
        map.put(BotInfoColumn.warning_json3.name(), columnTypeEnum2);
        map.put(BotInfoColumn.updated_time8.name(), DB.ColumnTypeEnum.Integer);
        map.put(BotInfoColumn.start_message4.name(), columnTypeEnum2);
        map.put(BotInfoColumn.username2.name(), columnTypeEnum);
        map.put(BotInfoColumn.share_url6.name(), columnTypeEnum2);
        map.put(BotInfoColumn.commands_json7.name(), columnTypeEnum2);
        this.db.createTable(TableName.botInfoTable.name(), hashSet, map);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void createChatHintTable() {
        HashSet hashSet = new HashSet();
        ChatHintColumn chatHintColumn = ChatHintColumn.guid1;
        hashSet.add(chatHintColumn.name());
        HashMap map = new HashMap();
        map.put(chatHintColumn.name(), DB.ColumnTypeEnum.Varchar100);
        String strName = ChatHintColumn.insertedToDbTime2.name();
        DB.ColumnTypeEnum columnTypeEnum = DB.ColumnTypeEnum.Integer;
        map.put(strName, columnTypeEnum);
        map.put(ChatHintColumn.rate3.name(), columnTypeEnum);
        this.db.createTable(TableName.chatHintTable.name(), hashSet, map);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void createRecentChatTable() {
        HashSet hashSet = new HashSet();
        RecentChatColumn recentChatColumn = RecentChatColumn.guid1;
        hashSet.add(recentChatColumn.name());
        HashMap map = new HashMap();
        map.put(recentChatColumn.name(), DB.ColumnTypeEnum.Varchar100);
        map.put(RecentChatColumn.data3.name(), DB.ColumnTypeEnum.LongText);
        map.put(RecentChatColumn.insertedToDbTime2.name(), DB.ColumnTypeEnum.Integer);
        this.db.createTable(TableName.recentChatTable.name(), hashSet, map);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void createFoldersTable() {
        HashSet hashSet = new HashSet();
        FolderColumn folderColumn = FolderColumn.folder_id1;
        hashSet.add(folderColumn.name());
        HashMap map = new HashMap();
        String strName = folderColumn.name();
        DB.ColumnTypeEnum columnTypeEnum = DB.ColumnTypeEnum.Varchar100;
        map.put(strName, columnTypeEnum);
        map.put(FolderColumn.name2.name(), columnTypeEnum);
        String strName2 = FolderColumn.include_objects_json3.name();
        DB.ColumnTypeEnum columnTypeEnum2 = DB.ColumnTypeEnum.LongText;
        map.put(strName2, columnTypeEnum2);
        map.put(FolderColumn.exclude_objects_json4.name(), columnTypeEnum2);
        map.put(FolderColumn.pinned_objects_json5.name(), columnTypeEnum2);
        map.put(FolderColumn.include_chat_types_json6.name(), columnTypeEnum2);
        map.put(FolderColumn.exclude_chat_types_json7.name(), columnTypeEnum2);
        map.put(FolderColumn.order8.name(), DB.ColumnTypeEnum.IntegerDefault0);
        map.put(FolderColumn.suggestion_folder_id9.name(), columnTypeEnum);
        this.db.createTable(TableName.folderTable.name(), hashSet, map);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void createMyStickerSetTable() {
        HashSet hashSet = new HashSet();
        MyStickerSetColumn myStickerSetColumn = MyStickerSetColumn.sticker_set_id_1;
        hashSet.add(myStickerSetColumn.name());
        HashMap map = new HashMap();
        map.put(myStickerSetColumn.name(), DB.ColumnTypeEnum.Varchar100);
        map.put(MyStickerSetColumn.updatedTime_2.name(), DB.ColumnTypeEnum.Integer);
        map.put(MyStickerSetColumn.sticker_set_data_3.name(), DB.ColumnTypeEnum.LongText);
        this.db.createTable(TableName.myStickerSetTable.name(), hashSet, map);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void createRecentStickerTable() {
        HashSet hashSet = new HashSet();
        RecentOrFavoriteStickerColumn recentOrFavoriteStickerColumn = RecentOrFavoriteStickerColumn.sticker_id_1;
        hashSet.add(recentOrFavoriteStickerColumn.name());
        RecentOrFavoriteStickerColumn recentOrFavoriteStickerColumn2 = RecentOrFavoriteStickerColumn.type_4;
        hashSet.add(recentOrFavoriteStickerColumn2.name());
        HashMap map = new HashMap();
        String strName = recentOrFavoriteStickerColumn.name();
        DB.ColumnTypeEnum columnTypeEnum = DB.ColumnTypeEnum.Varchar100;
        map.put(strName, columnTypeEnum);
        map.put(RecentOrFavoriteStickerColumn.sticker_set_id_2.name(), columnTypeEnum);
        map.put(RecentOrFavoriteStickerColumn.last_used_time_millis_3.name(), DB.ColumnTypeEnum.Integer);
        map.put(recentOrFavoriteStickerColumn2.name(), DB.ColumnTypeEnum.Varchar60);
        map.put(RecentOrFavoriteStickerColumn.sticker_data_5.name(), DB.ColumnTypeEnum.LongText);
        this.db.createTable(TableName.recentOrFavoriteStickerTable.name(), hashSet, map);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void createRecentGifTable() {
        HashSet hashSet = new HashSet();
        RecentGifColumn recentGifColumn = RecentGifColumn.file_id_1;
        hashSet.add(recentGifColumn.name());
        HashMap map = new HashMap();
        String strName = recentGifColumn.name();
        DB.ColumnTypeEnum columnTypeEnum = DB.ColumnTypeEnum.Integer;
        map.put(strName, columnTypeEnum);
        map.put(RecentGifColumn.last_used_time_millis_2.name(), columnTypeEnum);
        map.put(RecentGifColumn.gif_data_3.name(), DB.ColumnTypeEnum.LongText);
        this.db.createTable(TableName.recentGifTable.name(), hashSet, map);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void createChannelInfoTable() {
        HashSet hashSet = new HashSet();
        ChannelInfoColumn channelInfoColumn = ChannelInfoColumn.channel_guid1;
        hashSet.add(channelInfoColumn.name());
        HashMap map = new HashMap();
        String strName = channelInfoColumn.name();
        DB.ColumnTypeEnum columnTypeEnum = DB.ColumnTypeEnum.Varchar100;
        map.put(strName, columnTypeEnum);
        map.put(ChannelInfoColumn.count_members2.name(), DB.ColumnTypeEnum.IntegerDefaultMinus1);
        map.put(ChannelInfoColumn.username3.name(), columnTypeEnum);
        String strName2 = ChannelInfoColumn.description4.name();
        DB.ColumnTypeEnum columnTypeEnum2 = DB.ColumnTypeEnum.LongText;
        map.put(strName2, columnTypeEnum2);
        map.put(ChannelInfoColumn.warning_info_json5.name(), columnTypeEnum2);
        map.put(ChannelInfoColumn.sign_messages6.name(), DB.ColumnTypeEnum.IntegerDefault0);
        map.put(ChannelInfoColumn.channel_type7.name(), DB.ColumnTypeEnum.Varchar20);
        map.put(ChannelInfoColumn.insertedTime8.name(), DB.ColumnTypeEnum.Integer);
        map.put(ChannelInfoColumn.share_url9.name(), columnTypeEnum);
        map.put(ChannelInfoColumn.chat_reaction_setting10.name(), columnTypeEnum2);
        this.db.createTable(TableName.channelInfoTable.name(), hashSet, map);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void createGroupInfoTable() {
        HashSet hashSet = new HashSet();
        GroupInfoColumn groupInfoColumn = GroupInfoColumn.group_guid1;
        hashSet.add(groupInfoColumn.name());
        HashMap map = new HashMap();
        map.put(groupInfoColumn.name(), DB.ColumnTypeEnum.Varchar100);
        map.put(GroupInfoColumn.count_members2.name(), DB.ColumnTypeEnum.IntegerDefaultMinus1);
        map.put(GroupInfoColumn.insertedTime8.name(), DB.ColumnTypeEnum.Integer);
        String strName = GroupInfoColumn.warning_info3.name();
        DB.ColumnTypeEnum columnTypeEnum = DB.ColumnTypeEnum.LongText;
        map.put(strName, columnTypeEnum);
        String strName2 = GroupInfoColumn.slow_mode5.name();
        DB.ColumnTypeEnum columnTypeEnum2 = DB.ColumnTypeEnum.IntegerDefault0;
        map.put(strName2, columnTypeEnum2);
        map.put(GroupInfoColumn.description4.name(), columnTypeEnum);
        map.put(GroupInfoColumn.chat_history_for_new_members6.name(), DB.ColumnTypeEnum.Varchar20);
        map.put(GroupInfoColumn.event_messages7.name(), columnTypeEnum2);
        map.put(GroupInfoColumn.chat_reaction_setting9.name(), columnTypeEnum);
        this.db.createTable(TableName.groupInfoTable.name(), hashSet, map);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void createHoleTable() {
        HashSet hashSet = new HashSet();
        MessageHoleColumn messageHoleColumn = MessageHoleColumn.guid1;
        hashSet.add(messageHoleColumn.name());
        MessageHoleColumn messageHoleColumn2 = MessageHoleColumn.start2;
        hashSet.add(messageHoleColumn2.name());
        MessageHoleColumn messageHoleColumn3 = MessageHoleColumn.end3;
        hashSet.add(messageHoleColumn3.name());
        MessageHoleColumn messageHoleColumn4 = MessageHoleColumn.type4;
        hashSet.add(messageHoleColumn4.name());
        HashMap map = new HashMap();
        map.put(messageHoleColumn.name(), DB.ColumnTypeEnum.Varchar100);
        String strName = messageHoleColumn2.name();
        DB.ColumnTypeEnum columnTypeEnum = DB.ColumnTypeEnum.Integer;
        map.put(strName, columnTypeEnum);
        map.put(messageHoleColumn3.name(), columnTypeEnum);
        map.put(messageHoleColumn4.name(), DB.ColumnTypeEnum.Varchar20);
        this.db.createTable(TableName.messageHoleTable.name(), hashSet, map);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void createContactTable() {
        HashSet hashSet = new HashSet();
        ContactColumn contactColumn = ContactColumn.user_guid1;
        hashSet.add(contactColumn.name());
        HashMap map = new HashMap();
        map.put(contactColumn.name(), DB.ColumnTypeEnum.Varchar100);
        String strName = UserColumn.online_time_type18.name();
        DB.ColumnTypeEnum columnTypeEnum = DB.ColumnTypeEnum.Varchar60;
        map.put(strName, columnTypeEnum);
        map.put(UserColumn.online_time_exact_time19.name(), DB.ColumnTypeEnum.IntegerDefault0);
        map.put(UserColumn.online_time_approximate_period20.name(), columnTypeEnum);
        this.db.createTable(TableName.contactTable.name(), hashSet, map);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void createPhoneBookTable() {
        HashSet hashSet = new HashSet();
        PhoneBookColumn phoneBookColumn = PhoneBookColumn.phone;
        hashSet.add(phoneBookColumn.name());
        HashMap map = new HashMap();
        map.put(phoneBookColumn.name(), DB.ColumnTypeEnum.Varchar20);
        String strName = PhoneBookColumn.firstName.name();
        DB.ColumnTypeEnum columnTypeEnum = DB.ColumnTypeEnum.Varchar100;
        map.put(strName, columnTypeEnum);
        map.put(PhoneBookColumn.lastName.name(), columnTypeEnum);
        this.db.createTable(TableName.phoneBookTable.name(), hashSet, map);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void createUserTable() {
        HashSet hashSet = new HashSet();
        UserColumn userColumn = UserColumn.user_guid1;
        hashSet.add(userColumn.name());
        HashMap map = new HashMap();
        String strName = userColumn.name();
        DB.ColumnTypeEnum columnTypeEnum = DB.ColumnTypeEnum.Varchar100;
        map.put(strName, columnTypeEnum);
        map.put(UserColumn.phone4.name(), columnTypeEnum);
        map.put(UserColumn.username5.name(), columnTypeEnum);
        String strName2 = UserColumn.bio10.name();
        DB.ColumnTypeEnum columnTypeEnum2 = DB.ColumnTypeEnum.LongText;
        map.put(strName2, columnTypeEnum2);
        String strName3 = UserColumn.count_common_groups14.name();
        DB.ColumnTypeEnum columnTypeEnum3 = DB.ColumnTypeEnum.Integer;
        map.put(strName3, columnTypeEnum3);
        map.put(UserColumn.warning_info_json15.name(), columnTypeEnum2);
        String strName4 = UserColumn.can_receive_call16.name();
        DB.ColumnTypeEnum columnTypeEnum4 = DB.ColumnTypeEnum.IntegerDefault0;
        map.put(strName4, columnTypeEnum4);
        map.put(UserColumn.can_video_call17.name(), columnTypeEnum4);
        String strName5 = UserColumn.online_time_type18.name();
        DB.ColumnTypeEnum columnTypeEnum5 = DB.ColumnTypeEnum.Varchar60;
        map.put(strName5, columnTypeEnum5);
        map.put(UserColumn.online_time_exact_time19.name(), columnTypeEnum4);
        map.put(UserColumn.online_time_approximate_period20.name(), columnTypeEnum5);
        map.put(UserColumn.timeStamp21.name(), columnTypeEnum3);
        map.put(UserColumn.insertedTime22.name(), columnTypeEnum3);
        this.db.createTable(TableName.userTable.name(), hashSet, map);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void createAbsTable() {
        HashSet hashSet = new HashSet();
        AbsColumn absColumn = AbsColumn.guid1;
        hashSet.add(absColumn.name());
        HashMap map = new HashMap();
        String strName = absColumn.name();
        DB.ColumnTypeEnum columnTypeEnum = DB.ColumnTypeEnum.Varchar100;
        map.put(strName, columnTypeEnum);
        map.put(AbsColumn.type2.name(), columnTypeEnum);
        map.put(AbsColumn.title3.name(), columnTypeEnum);
        map.put(AbsColumn.avatar_thumbnail_file_id4.name(), DB.ColumnTypeEnum.Integer);
        map.put(AbsColumn.avatar_thumbnail_access_hash5.name(), columnTypeEnum);
        map.put(AbsColumn.avatar_thumbnail_dc_id6.name(), columnTypeEnum);
        map.put(AbsColumn.first_name7.name(), columnTypeEnum);
        map.put(AbsColumn.last_name8.name(), columnTypeEnum);
        String strName2 = AbsColumn.is_deleted9.name();
        DB.ColumnTypeEnum columnTypeEnum2 = DB.ColumnTypeEnum.IntegerDefault0;
        map.put(strName2, columnTypeEnum2);
        map.put(AbsColumn.is_verified10.name(), columnTypeEnum2);
        map.put(AbsColumn.updated_time11.name(), columnTypeEnum2);
        this.db.createTable(TableName.absTable.name(), hashSet, map);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void createMessageTable() {
        HashSet hashSet = new HashSet();
        hashSet.add(MessageColumn.message_id2.name());
        HashMap map = new HashMap();
        for (MessageColumn messageColumn : MessageColumn.values()) {
            map.put(messageColumn.name(), messageColumn.type);
        }
        this.db.createTable(TableName.messageTable.name(), hashSet, map);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void createChatTable() {
        HashSet hashSet = new HashSet();
        hashSet.add(ChatColumn.object_guid1.name());
        HashMap map = new HashMap();
        for (ChatColumn chatColumn : ChatColumn.values()) {
            map.put(chatColumn.name(), chatColumn.type);
        }
        this.db.createTable(TableName.chatTable.name(), hashSet, map);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void createChatExtraTable() {
        HashSet hashSet = new HashSet();
        hashSet.add(ChatExtraColumn.object_guid1.name());
        HashMap map = new HashMap();
        for (ChatExtraColumn chatExtraColumn : ChatExtraColumn.values()) {
            map.put(chatExtraColumn.name(), chatExtraColumn.type);
        }
        this.db.createTable(TableName.chatExtraTable.name(), hashSet, map);
    }

    public void addHole(String str, MessageHoleObject messageHoleObject) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(messageHoleObject);
        addAllHoles(str, arrayList);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void addAllHoles(String str, Collection<MessageHoleObject> collection) {
        if (collection.size() == 0) {
            return;
        }
        String[] strArr = {MessageHoleColumn.guid1.name(), MessageHoleColumn.start2.name(), MessageHoleColumn.end3.name(), MessageHoleColumn.type4.name()};
        ArrayList<String[]> arrayList = new ArrayList<>();
        for (MessageHoleObject messageHoleObject : collection) {
            String[] strArr2 = new String[4];
            strArr2[0] = str;
            strArr2[1] = messageHoleObject.start + BuildConfig.FLAVOR;
            strArr2[2] = messageHoleObject.end + BuildConfig.FLAVOR;
            strArr2[3] = messageHoleObject.type != null ? messageHoleObject.type + BuildConfig.FLAVOR : MessageUtils.FilterTypeEnum.All.name();
            arrayList.add(strArr2);
        }
        this.db.insertAllToTable(TableName.messageHoleTable.name(), strArr, arrayList);
    }

    public ArrayList<MessageHoleObject> getHolesOverlapsMinAndMax(String str, long j, long j2, MessageUtils.FilterTypeEnum filterTypeEnum) {
        if (str == null || j2 < j || j2 < 0) {
            return new ArrayList<>();
        }
        String strName = MessageHoleColumn.guid1.name();
        WhereCondition.OperatorEnum operatorEnum = WhereCondition.OperatorEnum.EQ;
        WhereCondition whereCondition = new WhereCondition(strName, operatorEnum, str);
        MessageHoleColumn messageHoleColumn = MessageHoleColumn.start2;
        String strName2 = messageHoleColumn.name();
        WhereCondition.OperatorEnum operatorEnum2 = WhereCondition.OperatorEnum.GTE;
        WhereCondition whereCondition2 = new WhereCondition(strName2, operatorEnum2, j + BuildConfig.FLAVOR);
        String strName3 = messageHoleColumn.name();
        WhereCondition.OperatorEnum operatorEnum3 = WhereCondition.OperatorEnum.LTE;
        WhereCondition whereCondition3 = new WhereCondition(strName3, operatorEnum3, j2 + BuildConfig.FLAVOR);
        WhereCondition.OperatorEnum operatorEnum4 = WhereCondition.OperatorEnum.And;
        WhereCondition whereCondition4 = new WhereCondition(whereCondition2, operatorEnum4, whereCondition3);
        MessageHoleColumn messageHoleColumn2 = MessageHoleColumn.end3;
        WhereCondition whereCondition5 = new WhereCondition(new WhereCondition(messageHoleColumn2.name(), operatorEnum2, j + BuildConfig.FLAVOR), operatorEnum4, new WhereCondition(messageHoleColumn2.name(), operatorEnum3, j2 + BuildConfig.FLAVOR));
        WhereCondition whereCondition6 = new WhereCondition(new WhereCondition(messageHoleColumn.name(), operatorEnum3, j + BuildConfig.FLAVOR), operatorEnum4, new WhereCondition(messageHoleColumn2.name(), operatorEnum2, j2 + BuildConfig.FLAVOR));
        WhereCondition.OperatorEnum operatorEnum5 = WhereCondition.OperatorEnum.Or;
        WhereCondition whereCondition7 = new WhereCondition(whereCondition, operatorEnum4, new WhereCondition(new WhereCondition(whereCondition4, operatorEnum5, whereCondition5), operatorEnum5, whereCondition6));
        MessageUtils.FilterTypeEnum filterTypeEnum2 = filterTypeEnum == null ? MessageUtils.FilterTypeEnum.All : filterTypeEnum;
        ArrayList<MessageHoleObject> arrayListSelectObject = this.db.selectObject(TableName.messageHoleTable.name(), null, new WhereCondition(whereCondition7, operatorEnum4, new WhereCondition(MessageHoleColumn.type4.name(), operatorEnum, filterTypeEnum2 + BuildConfig.FLAVOR)), null, false, 0, new DBParser<MessageHoleObject>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // ir.aaap.messengercore.db.DBParser
            public MessageHoleObject parse(CursorInterFace cursorInterFace) {
                return DBHelperImpl.this.parseMessageHoleCursor(cursorInterFace);
            }
        });
        return arrayListSelectObject != null ? arrayListSelectObject : new ArrayList<>();
    }

    public ArrayList<MessageHoleObject> getAllHoles(String str, MessageUtils.FilterTypeEnum filterTypeEnum) {
        if (str == null) {
            return new ArrayList<>();
        }
        if (filterTypeEnum == null) {
            filterTypeEnum = MessageUtils.FilterTypeEnum.All;
        }
        String strName = MessageHoleColumn.guid1.name();
        WhereCondition.OperatorEnum operatorEnum = WhereCondition.OperatorEnum.EQ;
        ArrayList<MessageHoleObject> arrayListSelectObject = this.db.selectObject(TableName.messageHoleTable.name(), null, new WhereCondition(new WhereCondition(strName, operatorEnum, str), WhereCondition.OperatorEnum.And, new WhereCondition(MessageHoleColumn.type4.name(), operatorEnum, filterTypeEnum + BuildConfig.FLAVOR)), null, false, 0, new DBParser<MessageHoleObject>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // ir.aaap.messengercore.db.DBParser
            public MessageHoleObject parse(CursorInterFace cursorInterFace) {
                return DBHelperImpl.this.parseMessageHoleCursor(cursorInterFace);
            }
        });
        return arrayListSelectObject != null ? arrayListSelectObject : new ArrayList<>();
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void addAllMessages(String str, Collection<Message> collection, long j) {
        if (str == null || collection == null || collection.size() == 0) {
            return;
        }
        String[] messageColumnArray = getMessageColumnArray();
        ArrayList<String[]> arrayList = new ArrayList<>();
        Iterator<Message> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(getMessageValueArray(str, it.next(), j));
        }
        this.db.insertAllToTable(TableName.messageTable.name(), messageColumnArray, arrayList);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void addAllAbsObject(Collection<ChatAbsObject> collection, long j) {
        if (collection == null || collection.size() == 0) {
            return;
        }
        String[] absColumnArray = getAbsColumnArray();
        ArrayList<String[]> arrayList = new ArrayList<>();
        Iterator<ChatAbsObject> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(getAbsValueArray(it.next(), j));
        }
        this.db.insertAllToTable(TableName.absTable.name(), absColumnArray, arrayList);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void addAbsObject(ChatAbsObject chatAbsObject, long j) {
        if (chatAbsObject == null) {
            return;
        }
        this.db.insertToTable(TableName.absTable.name(), getAbsColumnArray(), getAbsValueArray(chatAbsObject, j));
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void addUserInfo(UserInfo userInfo, long j) {
        if (userInfo == null) {
            return;
        }
        this.db.insertToTable(TableName.userTable.name(), getUserColumnArray(), getUserValueArray(userInfo, j));
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void addGroupInfo(GroupInfo groupInfo, long j) {
        if (groupInfo == null) {
            return;
        }
        this.db.insertToTable(TableName.groupInfoTable.name(), getGroupInfoColumnArray(), getGroupInfoValueArray(groupInfo, j));
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void addChannelInfo(ChannelInfo channelInfo, long j) {
        if (channelInfo == null) {
            return;
        }
        this.db.insertToTable(TableName.channelInfoTable.name(), getChannelInfoColumnArray(), getChannelInfoValueArray(channelInfo, j));
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void addBotInfo(BotInfo botInfo, long j) {
        if (botInfo == null) {
            return;
        }
        this.db.insertToTable(TableName.botInfoTable.name(), getBotColumnArray(), getBotValueArray(botInfo, j));
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void addServiceInfo(ServiceInfo serviceInfo, long j) {
        if (serviceInfo == null) {
            return;
        }
        this.db.insertToTable(TableName.serviceTable.name(), getServiceColumnArray(), getServiceValueArray(serviceInfo, j));
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void addAllNotification(ArrayList<NotificationModels.ShowNotificationObject> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        String[] notificationColumnArray = getNotificationColumnArray();
        ArrayList<String[]> arrayList2 = new ArrayList<>();
        Iterator<NotificationModels.ShowNotificationObject> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(getNotificationValueArray(it.next()));
        }
        this.db.insertAllToTable(TableName.notificationTable.name(), notificationColumnArray, arrayList2);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void addAllContactsAndUserInfo(ArrayList<UserInfo> arrayList, long j) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        String[] contactColumnArray = getContactColumnArray();
        ArrayList<String[]> arrayList2 = new ArrayList<>();
        Iterator<UserInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(getContactValueArray(it.next()));
        }
        this.db.insertAllToTable(TableName.contactTable.name(), contactColumnArray, arrayList2);
        addAllUserInfo(arrayList, j);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void addAllUserInfo(ArrayList<UserInfo> arrayList, long j) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        String[] userColumnArray = getUserColumnArray();
        ArrayList<String[]> arrayList2 = new ArrayList<>();
        Iterator<UserInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(getUserValueArray(it.next(), j));
        }
        this.db.insertAllToTable(TableName.userTable.name(), userColumnArray, arrayList2);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void addContact(UserInfo userInfo, long j) {
        if (userInfo == null) {
            return;
        }
        this.db.insertToTable(TableName.contactTable.name(), getContactColumnArray(), getContactValueArray(userInfo));
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void removeContact(String str) {
        this.db.removeObject(TableName.contactTable.name(), new WhereCondition(ContactColumn.user_guid1.name(), WhereCondition.OperatorEnum.EQ, str));
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void removeContacts(ArrayList<String> arrayList) {
        this.db.removeObject(TableName.contactTable.name(), new WhereCondition(ContactColumn.user_guid1.name(), WhereCondition.OperatorEnum.In, arrayList));
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void removeAllContacts() {
        this.db.removeObject(TableName.contactTable.name(), null);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void removeAllPhoneBooks() {
        this.db.removeObject(TableName.phoneBookTable.name(), null);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void removeAllRecentOrFavoriteStickers() {
        this.db.removeObject(TableName.recentOrFavoriteStickerTable.name(), null);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void addAllChats(Collection<Chat> collection) {
        if (collection == null || collection.size() == 0) {
            return;
        }
        String[] chatColumnArray = getChatColumnArray();
        ArrayList<String[]> arrayList = new ArrayList<>();
        Iterator<Chat> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(getChatValueArray(it.next()));
        }
        this.db.insertAllToTable(TableName.chatTable.name(), chatColumnArray, arrayList);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void addOrUpdateChatExtra(ChatExtra chatExtra) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(chatExtra);
        addAllChatExtras(arrayList);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void addAllChatExtras(Collection<ChatExtra> collection) {
        if (collection == null || collection.size() == 0) {
            return;
        }
        String[] chatExtraColumnArray = getChatExtraColumnArray();
        ArrayList<String[]> arrayList = new ArrayList<>();
        Iterator<ChatExtra> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(getChatExtraValueArray(it.next()));
        }
        this.db.insertAllToTable(TableName.chatExtraTable.name(), chatExtraColumnArray, arrayList);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void addAllPhoneBook(Collection<PhoneBookObject> collection) {
        if (collection == null || collection.size() == 0) {
            return;
        }
        String[] phoneBookColumnArray = getPhoneBookColumnArray();
        ArrayList<String[]> arrayList = new ArrayList<>();
        Iterator<PhoneBookObject> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(getPhoneBookValueArray(it.next()));
        }
        this.db.insertAllToTable(TableName.phoneBookTable.name(), phoneBookColumnArray, arrayList);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void removeAllRecentSticker() {
        this.db.removeObject(TableName.recentOrFavoriteStickerTable.name(), new WhereCondition(RecentOrFavoriteStickerColumn.type_4.name(), WhereCondition.OperatorEnum.EQ, StickerObject.TypeEnum.recent.name()));
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void removeAllFavoriteSticker() {
        this.db.removeObject(TableName.recentOrFavoriteStickerTable.name(), new WhereCondition(RecentOrFavoriteStickerColumn.type_4.name(), WhereCondition.OperatorEnum.EQ, StickerObject.TypeEnum.favorite.name()));
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void removeFavoriteSticker(String str) {
        if (str == null) {
            return;
        }
        String strName = RecentOrFavoriteStickerColumn.type_4.name();
        WhereCondition.OperatorEnum operatorEnum = WhereCondition.OperatorEnum.EQ;
        this.db.removeObject(TableName.recentOrFavoriteStickerTable.name(), new WhereCondition(new WhereCondition(strName, operatorEnum, StickerObject.TypeEnum.favorite.name()), WhereCondition.OperatorEnum.And, new WhereCondition(RecentOrFavoriteStickerColumn.sticker_id_1.name(), operatorEnum, str)));
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void addAllRecentSticker(ArrayList<StickerObject> arrayList, long j) {
        addSticker(arrayList, StickerObject.TypeEnum.recent, j);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void addAllFavoriteSticker(ArrayList<StickerObject> arrayList, long j) {
        addSticker(arrayList, StickerObject.TypeEnum.favorite, j);
    }

    private void addSticker(ArrayList<StickerObject> arrayList, StickerObject.TypeEnum typeEnum, long j) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        String[] stickerColumnArray = getStickerColumnArray();
        ArrayList<String[]> arrayList2 = new ArrayList<>();
        Iterator<StickerObject> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(getStickerValueArray(it.next(), typeEnum, j));
        }
        this.db.insertAllToTable(TableName.recentOrFavoriteStickerTable.name(), stickerColumnArray, arrayList2);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void addOrUpdateRecentChat(InSearchObject inSearchObject, long j) {
        this.db.insertToTable(TableName.recentChatTable.name(), getRecentChatColumnArray(), getRecentChatValueArray(inSearchObject, j));
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public boolean increaseRateChatHint(String str, ChatType chatType, long j) {
        if (str == null || chatType != ChatType.User) {
            return false;
        }
        int chatHintRate = getChatHintRate(str) + 1;
        this.db.insertToTable(TableName.chatHintTable.name(), getChatHintColumnArray(), getChatHintValueArray(str, chatHintRate + BuildConfig.FLAVOR, j));
        return true;
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void addAllFolders(ArrayList<FolderObject> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        String[] folderColumnArray = getFolderColumnArray();
        ArrayList<String[]> arrayList2 = new ArrayList<>();
        Iterator<FolderObject> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(getFolderValueArray(it.next()));
        }
        this.db.insertAllToTable(TableName.folderTable.name(), folderColumnArray, arrayList2);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void addRecentGif(FileInlineObject fileInlineObject, long j) {
        if (fileInlineObject == null || fileInlineObject.type != FileInlineObject.FileInlineType.Gif) {
            return;
        }
        this.db.insertToTable(TableName.recentGifTable.name(), getGifColumnArray(), getGifValueArray(fileInlineObject, j));
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void addAllRecentGif(ArrayList<FileInlineObject> arrayList, long j) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        String[] gifColumnArray = getGifColumnArray();
        ArrayList<String[]> arrayList2 = new ArrayList<>();
        Iterator<FileInlineObject> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(getGifValueArray(it.next(), j));
        }
        this.db.insertAllToTable(TableName.recentGifTable.name(), gifColumnArray, arrayList2);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void addMyStickerSet(GetStickerSetByIdOutput getStickerSetByIdOutput) {
        if (getStickerSetByIdOutput == null || getStickerSetByIdOutput.sticker_set == null) {
            return;
        }
        ArrayList<GetStickerSetByIdOutput> arrayList = new ArrayList<>();
        arrayList.add(getStickerSetByIdOutput);
        addAllMyStickerSet(arrayList);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void addAllMyStickerSet(ArrayList<GetStickerSetByIdOutput> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        String[] myStickerSetColumnArray = getMyStickerSetColumnArray();
        ArrayList<String[]> arrayList2 = new ArrayList<>();
        Iterator<GetStickerSetByIdOutput> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(getMyStickerSetValueArray(it.next()));
        }
        this.db.insertAllToTable(TableName.myStickerSetTable.name(), myStickerSetColumnArray, arrayList2);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void removeAllMyStickerSet() {
        this.db.removeObject(TableName.myStickerSetTable.name(), null);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void removeAllGif() {
        this.db.removeObject(TableName.recentGifTable.name(), null);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void removeGif(String str) {
        if (str == null) {
            return;
        }
        this.db.removeObject(TableName.recentGifTable.name(), new WhereCondition(RecentGifColumn.file_id_1.name(), WhereCondition.OperatorEnum.EQ, str));
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void removeMyStickerSet(String str) {
        if (str == null) {
            return;
        }
        this.db.removeObject(TableName.myStickerSetTable.name(), new WhereCondition(MyStickerSetColumn.sticker_set_id_1.name(), WhereCondition.OperatorEnum.EQ, str));
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public ArrayList<GetStickerSetByIdOutput> getAllMyStickerSets() {
        return this.db.selectObject(TableName.myStickerSetTable.name(), null, null, null, false, 600, new DBParser<GetStickerSetByIdOutput>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // ir.aaap.messengercore.db.DBParser
            public GetStickerSetByIdOutput parse(CursorInterFace cursorInterFace) {
                return DBHelperImpl.this.parseStickerSetObject(cursorInterFace);
            }
        });
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public ArrayList<StickerObject> getRecentStickers() {
        return getStickersOrderByLastUsedTime(StickerObject.TypeEnum.recent);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public ArrayList<StickerObject> getFavoriteStickers() {
        return getStickersOrderByLastUsedTime(StickerObject.TypeEnum.favorite);
    }

    private ArrayList<StickerObject> getStickersOrderByLastUsedTime(StickerObject.TypeEnum typeEnum) {
        if (typeEnum == null) {
            return null;
        }
        return this.db.selectObject(TableName.recentOrFavoriteStickerTable.name(), null, new WhereCondition(RecentOrFavoriteStickerColumn.type_4.name(), WhereCondition.OperatorEnum.EQ, typeEnum + BuildConfig.FLAVOR), RecentOrFavoriteStickerColumn.last_used_time_millis_3.name(), false, DBHelper.GET_STICKER_LIMIT, new DBParser<StickerObject>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // ir.aaap.messengercore.db.DBParser
            public StickerObject parse(CursorInterFace cursorInterFace) {
                return DBHelperImpl.this.parseStickerObject(cursorInterFace);
            }
        });
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public ArrayList<FileInlineObject> getAllRecentGif() {
        return this.db.selectObject(TableName.recentGifTable.name(), null, null, RecentGifColumn.last_used_time_millis_2.name(), false, 600, new DBParser<FileInlineObject>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // ir.aaap.messengercore.db.DBParser
            public FileInlineObject parse(CursorInterFace cursorInterFace) {
                return DBHelperImpl.this.parseGifObject(cursorInterFace);
            }
        });
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public ArrayList<FolderObject> getAllFolders() {
        return this.db.selectObject(TableName.folderTable.name(), null, null, FolderColumn.order8.name(), true, 20, new DBParser<FolderObject>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // ir.aaap.messengercore.db.DBParser
            public FolderObject parse(CursorInterFace cursorInterFace) {
                return DBHelperImpl.this.parseFolderObject(cursorInterFace);
            }
        });
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public ArrayList<String> getAllChatHintGuid() {
        return this.db.selectObject(TableName.chatHintTable.name(), null, null, new String[]{ChatHintColumn.rate3.name(), ChatHintColumn.insertedToDbTime2.name()}, null, new boolean[]{false, false}, 30, new DBParser<String>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.8
            @Override // ir.aaap.messengercore.db.DBParser
            public String parse(CursorInterFace cursorInterFace) {
                return DBHelperImpl.this.parseChatHint(cursorInterFace);
            }
        });
    }

    private int getChatHintRate(String str) {
        ArrayList arrayListSelectObject = this.db.selectObject(TableName.chatHintTable.name(), null, new WhereCondition(ChatHintColumn.guid1.name(), WhereCondition.OperatorEnum.EQ, str), null, false, 1, new DBParser<Integer>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // ir.aaap.messengercore.db.DBParser
            public Integer parse(CursorInterFace cursorInterFace) {
                return Integer.valueOf(cursorInterFace.getInt(ChatHintColumn.rate3.name()));
            }
        });
        if (arrayListSelectObject == null || arrayListSelectObject.size() <= 0) {
            return 0;
        }
        return ((Integer) arrayListSelectObject.get(0)).intValue();
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public ArrayList<InSearchObject> getAllRecentChat() {
        return this.db.selectObject(TableName.recentChatTable.name(), null, null, RecentChatColumn.insertedToDbTime2.name(), false, 30, new DBParser<InSearchObject>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.10
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // ir.aaap.messengercore.db.DBParser
            public InSearchObject parse(CursorInterFace cursorInterFace) {
                return DBHelperImpl.this.parseRecentChat(cursorInterFace);
            }
        });
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void addFolder(FolderObject folderObject) {
        ArrayList<FolderObject> arrayList = new ArrayList<>();
        arrayList.add(folderObject);
        addAllFolders(arrayList);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void removeAllChatHint() {
        this.db.removeObject(TableName.chatHintTable.name(), null);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void removeAllRecentChat() {
        this.db.removeObject(TableName.recentChatTable.name(), null);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void addMessage(String str, Message message) {
        if (str == null || message == null) {
            return;
        }
        this.db.insertToTable(TableName.messageTable.name(), getMessageColumnArray(), getMessageValueArray(str, message, 0L));
    }

    public static String[] getNames(Class<? extends Enum<?>> cls) {
        return Arrays.toString(cls.getEnumConstants()).replaceAll("^.|.$", BuildConfig.FLAVOR).split(", ");
    }

    private String[] getMessageColumnArray() {
        return getNames(MessageColumn.class);
    }

    private String[] getFolderColumnArray() {
        return getNames(FolderColumn.class);
    }

    private String[] getMyStickerSetColumnArray() {
        return getNames(MyStickerSetColumn.class);
    }

    private String[] getStickerColumnArray() {
        return getNames(RecentOrFavoriteStickerColumn.class);
    }

    private String[] getRecentChatColumnArray() {
        return getNames(RecentChatColumn.class);
    }

    private String[] getChatHintColumnArray() {
        return getNames(ChatHintColumn.class);
    }

    private String[] getGifColumnArray() {
        return getNames(RecentGifColumn.class);
    }

    private String[] getGroupInfoColumnArray() {
        return getNames(GroupInfoColumn.class);
    }

    private String[] getChannelInfoColumnArray() {
        return getNames(ChannelInfoColumn.class);
    }

    private String[] getSentFileColumnArray() {
        return getNames(SentFileColumn.class);
    }

    private String[] getNotificationColumnArray() {
        return getNames(NotificationColumn.class);
    }

    private String[] getServiceColumnArray() {
        return getNames(ServiceColumn.class);
    }

    private String[] getBotColumnArray() {
        return getNames(BotInfoColumn.class);
    }

    private String[] getChatColumnArray() {
        return getNames(ChatColumn.class);
    }

    private String[] getChatExtraColumnArray() {
        return getNames(ChatExtraColumn.class);
    }

    private String[] getPhoneBookColumnArray() {
        return getNames(PhoneBookColumn.class);
    }

    private String[] getUserColumnArray() {
        return getNames(UserColumn.class);
    }

    private String[] getContactColumnArray() {
        return getNames(ContactColumn.class);
    }

    private String[] getAbsColumnArray() {
        return getNames(AbsColumn.class);
    }

    private String[] getAbsValueArray(ChatAbsObject chatAbsObject, long j) {
        String[] strArr = new String[AbsColumn.values().length];
        strArr[AbsColumn.guid1.ordinal()] = chatAbsObject.object_guid;
        int iOrdinal = AbsColumn.type2.ordinal();
        ChatType chatType = chatAbsObject.type;
        strArr[iOrdinal] = chatType != null ? chatType.name() : null;
        strArr[AbsColumn.title3.ordinal()] = chatAbsObject.title;
        if (chatAbsObject.avatar_thumbnail != null) {
            strArr[AbsColumn.avatar_thumbnail_file_id4.ordinal()] = chatAbsObject.avatar_thumbnail.file_id + BuildConfig.FLAVOR;
            strArr[AbsColumn.avatar_thumbnail_access_hash5.ordinal()] = chatAbsObject.avatar_thumbnail.access_hash_rec;
            strArr[AbsColumn.avatar_thumbnail_dc_id6.ordinal()] = chatAbsObject.avatar_thumbnail.dc_id;
        }
        strArr[AbsColumn.first_name7.ordinal()] = chatAbsObject.first_name;
        strArr[AbsColumn.last_name8.ordinal()] = chatAbsObject.last_name;
        strArr[AbsColumn.is_deleted9.ordinal()] = chatAbsObject.is_deleted ? "1" : "0";
        strArr[AbsColumn.is_verified10.ordinal()] = chatAbsObject.is_verified ? "1" : "0";
        strArr[AbsColumn.updated_time11.ordinal()] = j + BuildConfig.FLAVOR;
        return strArr;
    }

    private String[] getContactValueArray(UserInfo userInfo) {
        String str;
        String[] strArr = new String[ContactColumn.values().length];
        strArr[ContactColumn.user_guid1.ordinal()] = userInfo.user_guid;
        String str2 = null;
        if (userInfo.online_time != null) {
            int iOrdinal = ContactColumn.online_time_type18.ordinal();
            if (userInfo.online_time.type != null) {
                str = userInfo.online_time.type + BuildConfig.FLAVOR;
            } else {
                str = null;
            }
            strArr[iOrdinal] = str;
            strArr[ContactColumn.online_time_exact_time19.ordinal()] = userInfo.online_time.exact_time + BuildConfig.FLAVOR;
            int iOrdinal2 = ContactColumn.online_time_approximate_period20.ordinal();
            if (userInfo.online_time.approximate_period != null) {
                str2 = userInfo.online_time.approximate_period + BuildConfig.FLAVOR;
            }
            strArr[iOrdinal2] = str2;
        } else {
            strArr[ContactColumn.online_time_type18.ordinal()] = null;
            strArr[ContactColumn.online_time_exact_time19.ordinal()] = null;
            strArr[ContactColumn.online_time_approximate_period20.ordinal()] = null;
        }
        return strArr;
    }

    private String[] getPhoneBookValueArray(PhoneBookObject phoneBookObject) {
        String[] strArr = new String[PhoneBookColumn.values().length];
        strArr[PhoneBookColumn.phone.ordinal()] = phoneBookObject.phone;
        strArr[PhoneBookColumn.firstName.ordinal()] = phoneBookObject.first_name;
        strArr[PhoneBookColumn.lastName.ordinal()] = phoneBookObject.last_name;
        return strArr;
    }

    private String[] getFolderValueArray(FolderObject folderObject) {
        String[] strArr = new String[FolderColumn.values().length];
        if (folderObject != null) {
            strArr[FolderColumn.folder_id1.ordinal()] = folderObject.folder_id;
            strArr[FolderColumn.name2.ordinal()] = folderObject.name;
            int iOrdinal = FolderColumn.include_objects_json3.ordinal();
            ArrayList<ObjectGuidType> arrayList = folderObject.include_objects;
            strArr[iOrdinal] = arrayList != null ? this.jsonHelper.toJson(arrayList) : null;
            int iOrdinal2 = FolderColumn.exclude_objects_json4.ordinal();
            ArrayList<ObjectGuidType> arrayList2 = folderObject.exclude_objects;
            strArr[iOrdinal2] = arrayList2 != null ? this.jsonHelper.toJson(arrayList2) : null;
            int iOrdinal3 = FolderColumn.pinned_objects_json5.ordinal();
            ArrayList<ObjectGuidType> arrayList3 = folderObject.pinned_objects;
            strArr[iOrdinal3] = arrayList3 != null ? this.jsonHelper.toJson(arrayList3) : null;
            int iOrdinal4 = FolderColumn.include_chat_types_json6.ordinal();
            ArrayList<FolderObject.EnumIncludeChatType> arrayList4 = folderObject.include_chat_types;
            strArr[iOrdinal4] = arrayList4 != null ? this.jsonHelper.toJson(arrayList4) : null;
            int iOrdinal5 = FolderColumn.exclude_chat_types_json7.ordinal();
            ArrayList<FolderObject.EnumExcludeChatType> arrayList5 = folderObject.exclude_chat_types;
            strArr[iOrdinal5] = arrayList5 != null ? this.jsonHelper.toJson(arrayList5) : null;
            strArr[FolderColumn.order8.ordinal()] = folderObject.order + BuildConfig.FLAVOR;
            strArr[FolderColumn.suggestion_folder_id9.ordinal()] = folderObject.suggestion_folder_id;
        }
        return strArr;
    }

    private String[] getStickerValueArray(StickerObject stickerObject, StickerObject.TypeEnum typeEnum, long j) {
        String[] strArr = new String[RecentOrFavoriteStickerColumn.values().length];
        if (stickerObject != null) {
            strArr[RecentOrFavoriteStickerColumn.sticker_id_1.ordinal()] = stickerObject.sticker_id;
            strArr[RecentOrFavoriteStickerColumn.sticker_set_id_2.ordinal()] = stickerObject.sticker_set_id;
            strArr[RecentOrFavoriteStickerColumn.sticker_data_5.ordinal()] = this.jsonHelper.toJson(stickerObject);
        }
        strArr[RecentOrFavoriteStickerColumn.last_used_time_millis_3.ordinal()] = j + BuildConfig.FLAVOR;
        strArr[RecentOrFavoriteStickerColumn.type_4.ordinal()] = typeEnum != null ? typeEnum.name() : null;
        return strArr;
    }

    private String[] getRecentChatValueArray(InSearchObject inSearchObject, long j) {
        String[] strArr = new String[RecentChatColumn.values().length];
        strArr[RecentChatColumn.guid1.ordinal()] = inSearchObject.object_guid;
        strArr[RecentChatColumn.insertedToDbTime2.ordinal()] = j + BuildConfig.FLAVOR;
        strArr[RecentChatColumn.data3.ordinal()] = this.jsonHelper.toJson(inSearchObject);
        return strArr;
    }

    private String[] getChatHintValueArray(String str, String str2, long j) {
        String[] strArr = new String[ChatHintColumn.values().length];
        strArr[ChatHintColumn.guid1.ordinal()] = str;
        strArr[ChatHintColumn.insertedToDbTime2.ordinal()] = j + BuildConfig.FLAVOR;
        strArr[ChatHintColumn.rate3.ordinal()] = str2;
        return strArr;
    }

    private String[] getBotValueArray(BotInfo botInfo, long j) {
        String[] strArr = new String[BotInfoColumn.values().length];
        strArr[BotInfoColumn.bot_guid1.ordinal()] = botInfo.bot_guid;
        strArr[BotInfoColumn.username2.ordinal()] = botInfo.username;
        int iOrdinal = BotInfoColumn.warning_json3.ordinal();
        WarningObject warningObject = botInfo.warning_info;
        strArr[iOrdinal] = warningObject != null ? this.jsonHelper.toJson(warningObject) : null;
        strArr[BotInfoColumn.start_message4.ordinal()] = botInfo.start_message;
        strArr[BotInfoColumn.description5.ordinal()] = botInfo.description;
        strArr[BotInfoColumn.share_url6.ordinal()] = botInfo.share_url;
        int iOrdinal2 = BotInfoColumn.commands_json7.ordinal();
        ArrayList<BotCommandObject> arrayList = botInfo.commands;
        strArr[iOrdinal2] = arrayList != null ? this.jsonHelper.toJson(arrayList) : null;
        strArr[BotInfoColumn.updated_time8.ordinal()] = String.valueOf(j);
        return strArr;
    }

    private String[] getSentFileValueArray(String str, FileInlineObject fileInlineObject, long j) {
        String[] strArr = new String[SentFileColumn.values().length];
        strArr[SentFileColumn.path1.ordinal()] = str;
        strArr[SentFileColumn.data2.ordinal()] = fileInlineObject != null ? this.jsonHelper.toJson(fileInlineObject) : null;
        strArr[SentFileColumn.updated_time3.ordinal()] = String.valueOf(j);
        return strArr;
    }

    private String[] getNotificationValueArray(NotificationModels.ShowNotificationObject showNotificationObject) {
        String[] strArr = new String[NotificationColumn.values().length];
        strArr[NotificationColumn.notification_id1.ordinal()] = showNotificationObject.notification_id;
        int iOrdinal = NotificationColumn.type2.ordinal();
        NotificationModels.ShowNotificationTypeEnum showNotificationTypeEnum = showNotificationObject.type;
        strArr[iOrdinal] = showNotificationTypeEnum != null ? showNotificationTypeEnum.name() : null;
        strArr[NotificationColumn.title3.ordinal()] = showNotificationObject.title;
        strArr[NotificationColumn.text4.ordinal()] = showNotificationObject.text;
        strArr[NotificationColumn.is_read12.ordinal()] = "0";
        strArr[NotificationColumn.image_file_id5.ordinal()] = String.valueOf(showNotificationObject.image_file_id);
        NotificationModels.ShowNotificationTypeEnum showNotificationTypeEnum2 = showNotificationObject.type;
        if (showNotificationTypeEnum2 == NotificationModels.ShowNotificationTypeEnum.Message && showNotificationObject.message_data != null) {
            strArr[NotificationColumn.message_data_object_guid6.ordinal()] = showNotificationObject.message_data.object_guid;
            int iOrdinal2 = NotificationColumn.message_data_object_type7.ordinal();
            ChatType chatType = showNotificationObject.message_data.object_type;
            strArr[iOrdinal2] = chatType != null ? chatType.name() : null;
            strArr[NotificationColumn.message_data_message_id8.ordinal()] = String.valueOf(showNotificationObject.message_data.message_id);
        } else if (showNotificationTypeEnum2 == NotificationModels.ShowNotificationTypeEnum.NotMessage && showNotificationObject.not_message_data != null) {
            strArr[NotificationColumn.not_message_data_object_guid9.ordinal()] = showNotificationObject.not_message_data.object_guid;
            int iOrdinal3 = NotificationColumn.not_message_data_object_type10.ordinal();
            ChatType chatType2 = showNotificationObject.not_message_data.object_type;
            strArr[iOrdinal3] = chatType2 != null ? chatType2.name() : null;
            strArr[NotificationColumn.not_message_data_time11.ordinal()] = String.valueOf(showNotificationObject.not_message_data.time);
        }
        if (showNotificationObject.message_data != null) {
            strArr[NotificationColumn.textMetaData14.ordinal()] = this.jsonHelper.toJson(showNotificationObject.text_metadata);
        }
        strArr[NotificationColumn.time13.ordinal()] = String.valueOf(showNotificationObject.receivedTime);
        return strArr;
    }

    private String[] getServiceValueArray(ServiceInfo serviceInfo, long j) {
        String[] strArr = new String[ServiceColumn.values().length];
        strArr[ServiceColumn.service_guid1.ordinal()] = serviceInfo.service_guid;
        strArr[ServiceColumn.description2.ordinal()] = serviceInfo.description;
        int iOrdinal = ServiceColumn.warning_json3.ordinal();
        WarningObject warningObject = serviceInfo.warning_info;
        strArr[iOrdinal] = warningObject != null ? this.jsonHelper.toJson(warningObject) : null;
        strArr[ServiceColumn.updated_time4.ordinal()] = String.valueOf(j);
        return strArr;
    }

    private String[] getGifValueArray(FileInlineObject fileInlineObject, long j) {
        String[] strArr = new String[RecentGifColumn.values().length];
        if (fileInlineObject != null) {
            strArr[RecentGifColumn.file_id_1.ordinal()] = fileInlineObject.file_id + BuildConfig.FLAVOR;
            strArr[RecentGifColumn.gif_data_3.ordinal()] = this.jsonHelper.toJson(fileInlineObject);
        }
        strArr[RecentGifColumn.last_used_time_millis_2.ordinal()] = j + BuildConfig.FLAVOR;
        return strArr;
    }

    private String[] getMyStickerSetValueArray(GetStickerSetByIdOutput getStickerSetByIdOutput) {
        String[] strArr = new String[MyStickerSetColumn.values().length];
        if (getStickerSetByIdOutput.sticker_set != null) {
            strArr[MyStickerSetColumn.sticker_set_id_1.ordinal()] = getStickerSetByIdOutput.sticker_set.sticker_set_id;
            strArr[MyStickerSetColumn.updatedTime_2.ordinal()] = getStickerSetByIdOutput.sticker_set.update_time;
        }
        strArr[MyStickerSetColumn.sticker_set_data_3.ordinal()] = this.jsonHelper.toJson(getStickerSetByIdOutput);
        return strArr;
    }

    private String[] getUserValueArray(UserInfo userInfo, long j) {
        String str;
        String[] strArr = new String[UserColumn.values().length];
        strArr[UserColumn.user_guid1.ordinal()] = userInfo.user_guid;
        strArr[UserColumn.phone4.ordinal()] = userInfo.phone;
        strArr[UserColumn.username5.ordinal()] = userInfo.username;
        strArr[UserColumn.bio10.ordinal()] = userInfo.bio;
        strArr[UserColumn.count_common_groups14.ordinal()] = userInfo.count_common_groups + BuildConfig.FLAVOR;
        strArr[UserColumn.warning_info_json15.ordinal()] = this.jsonHelper.toJson(userInfo.warning_info);
        strArr[UserColumn.can_receive_call16.ordinal()] = userInfo.can_receive_call ? "1" : "0";
        strArr[UserColumn.can_video_call17.ordinal()] = userInfo.can_video_call ? "1" : "0";
        String str2 = null;
        if (userInfo.online_time != null) {
            int iOrdinal = UserColumn.online_time_type18.ordinal();
            if (userInfo.online_time.type != null) {
                str = userInfo.online_time.type + BuildConfig.FLAVOR;
            } else {
                str = null;
            }
            strArr[iOrdinal] = str;
            strArr[UserColumn.online_time_exact_time19.ordinal()] = userInfo.online_time.exact_time + BuildConfig.FLAVOR;
            int iOrdinal2 = UserColumn.online_time_approximate_period20.ordinal();
            if (userInfo.online_time.approximate_period != null) {
                str2 = userInfo.online_time.approximate_period + BuildConfig.FLAVOR;
            }
            strArr[iOrdinal2] = str2;
        } else {
            strArr[UserColumn.online_time_type18.ordinal()] = null;
            strArr[UserColumn.online_time_exact_time19.ordinal()] = null;
            strArr[UserColumn.online_time_approximate_period20.ordinal()] = null;
        }
        strArr[UserColumn.timeStamp21.ordinal()] = userInfo.timeStamp + BuildConfig.FLAVOR;
        strArr[UserColumn.insertedTime22.ordinal()] = j + BuildConfig.FLAVOR;
        return strArr;
    }

    private String[] getGroupInfoValueArray(GroupInfo groupInfo, long j) {
        String[] strArr = new String[GroupInfoColumn.values().length];
        strArr[GroupInfoColumn.group_guid1.ordinal()] = groupInfo.group_guid;
        strArr[GroupInfoColumn.count_members2.ordinal()] = groupInfo.count_members + BuildConfig.FLAVOR;
        int iOrdinal = GroupInfoColumn.warning_info3.ordinal();
        WarningObject warningObject = groupInfo.warning_info;
        strArr[iOrdinal] = warningObject != null ? this.jsonHelper.toJson(warningObject) : null;
        strArr[GroupInfoColumn.description4.ordinal()] = groupInfo.description;
        strArr[GroupInfoColumn.slow_mode5.ordinal()] = groupInfo.slow_mode + BuildConfig.FLAVOR;
        int iOrdinal2 = GroupInfoColumn.chat_history_for_new_members6.ordinal();
        GroupInfoFromServer.ChatHistoryForNewMembers chatHistoryForNewMembers = groupInfo.chat_history_for_new_members;
        strArr[iOrdinal2] = chatHistoryForNewMembers != null ? chatHistoryForNewMembers.name() : null;
        strArr[GroupInfoColumn.event_messages7.ordinal()] = groupInfo.event_messages ? "1" : "0";
        strArr[GroupInfoColumn.insertedTime8.ordinal()] = j + BuildConfig.FLAVOR;
        int iOrdinal3 = GroupInfoColumn.chat_reaction_setting9.ordinal();
        ChatReactionSetting chatReactionSetting = groupInfo.chat_reaction_setting;
        strArr[iOrdinal3] = chatReactionSetting != null ? this.jsonHelper.toJson(chatReactionSetting) : null;
        return strArr;
    }

    private String[] getChannelInfoValueArray(ChannelInfo channelInfo, long j) {
        String[] strArr = new String[ChannelInfoColumn.values().length];
        strArr[ChannelInfoColumn.channel_guid1.ordinal()] = channelInfo.channel_guid;
        strArr[ChannelInfoColumn.count_members2.ordinal()] = channelInfo.count_members + BuildConfig.FLAVOR;
        strArr[ChannelInfoColumn.username3.ordinal()] = channelInfo.username;
        strArr[ChannelInfoColumn.description4.ordinal()] = channelInfo.description;
        int iOrdinal = ChannelInfoColumn.warning_info_json5.ordinal();
        WarningObject warningObject = channelInfo.warning_info;
        strArr[iOrdinal] = warningObject != null ? this.jsonHelper.toJson(warningObject) : null;
        strArr[ChannelInfoColumn.sign_messages6.ordinal()] = channelInfo.sign_messages ? "1" : "0";
        int iOrdinal2 = ChannelInfoColumn.channel_type7.ordinal();
        ChannelInfoFromServer.ChannelTypeEnum channelTypeEnum = channelInfo.channel_type;
        strArr[iOrdinal2] = channelTypeEnum != null ? channelTypeEnum.name() : null;
        strArr[ChannelInfoColumn.insertedTime8.ordinal()] = j + BuildConfig.FLAVOR;
        strArr[ChannelInfoColumn.share_url9.ordinal()] = channelInfo.share_url;
        int iOrdinal3 = ChannelInfoColumn.chat_reaction_setting10.ordinal();
        ChatReactionSetting chatReactionSetting = channelInfo.chat_reaction_setting;
        strArr[iOrdinal3] = chatReactionSetting != null ? this.jsonHelper.toJson(chatReactionSetting) : null;
        return strArr;
    }

    private String[] getMessageValueArray(String str, Message message, long j) {
        String str2;
        ArrayList<MetaDataPartObject> arrayList;
        ArrayList<KeypadRow> arrayList2;
        String str3;
        String str4;
        String[] strArr = new String[MessageColumn.values().length];
        strArr[MessageColumn.object_guid1.ordinal()] = str;
        strArr[MessageColumn.message_id2.ordinal()] = message.message_id + BuildConfig.FLAVOR;
        strArr[MessageColumn.author_object_guid3.ordinal()] = message.author_object_guid;
        int iOrdinal = MessageColumn.author_type4.ordinal();
        Message.AuthorTypeEnum authorTypeEnum = message.author_type;
        strArr[iOrdinal] = authorTypeEnum != null ? authorTypeEnum.name() : null;
        strArr[MessageColumn.text5.ordinal()] = message.text;
        if (message.file_inline != null) {
            strArr[MessageColumn.file_inline_file_id6.ordinal()] = message.file_inline.file_id + BuildConfig.FLAVOR;
            strArr[MessageColumn.file_inline_mime7.ordinal()] = message.file_inline.mime;
            strArr[MessageColumn.file_inline_dc_id8.ordinal()] = message.file_inline.dc_id;
            strArr[MessageColumn.file_inline_access_hash_rec9.ordinal()] = message.file_inline.access_hash_rec;
            strArr[MessageColumn.file_inline_file_name10.ordinal()] = message.file_inline.file_name;
            strArr[MessageColumn.file_inline_width11.ordinal()] = message.file_inline.width + BuildConfig.FLAVOR;
            strArr[MessageColumn.file_inline_height12.ordinal()] = message.file_inline.height + BuildConfig.FLAVOR;
            strArr[MessageColumn.file_inline_time13.ordinal()] = message.file_inline.time + BuildConfig.FLAVOR;
            strArr[MessageColumn.file_inline_size14.ordinal()] = message.file_inline.size + BuildConfig.FLAVOR;
            int iOrdinal2 = MessageColumn.file_inline_type15.ordinal();
            FileInlineObject.FileInlineType fileInlineType = message.file_inline.type;
            strArr[iOrdinal2] = fileInlineType != null ? fileInlineType.name() : null;
            strArr[MessageColumn.file_inline_auto_play16.ordinal()] = message.file_inline.auto_play ? "1" : "0";
            strArr[MessageColumn.file_inline_thumb_inline45.ordinal()] = message.file_inline.thumb_inline;
            int iOrdinal3 = MessageColumn.file_inline_performer46.ordinal();
            FileInlineObject fileInlineObject = message.file_inline;
            strArr[iOrdinal3] = fileInlineObject.type == FileInlineObject.FileInlineType.Music ? fileInlineObject.music_performer : null;
            int iOrdinal4 = MessageColumn.file_inline_is_round75.ordinal();
            FileInlineObject fileInlineObject2 = message.file_inline;
            strArr[iOrdinal4] = (fileInlineObject2.type == FileInlineObject.FileInlineType.Video && fileInlineObject2.is_round) ? "1" : "0";
            strArr[MessageColumn.file_inline_cdn_tag82.ordinal()] = message.file_inline.cdn_tag;
        } else {
            strArr[MessageColumn.file_inline_width11.ordinal()] = "0";
            strArr[MessageColumn.file_inline_height12.ordinal()] = "0";
            strArr[MessageColumn.file_inline_time13.ordinal()] = "0";
            strArr[MessageColumn.file_inline_size14.ordinal()] = "0";
            strArr[MessageColumn.file_inline_auto_play16.ordinal()] = "0";
        }
        strArr[MessageColumn.reply_to_message_id17.ordinal()] = message.reply_to_message_id + BuildConfig.FLAVOR;
        strArr[MessageColumn.time18.ordinal()] = message.time + BuildConfig.FLAVOR;
        strArr[MessageColumn.count_seen19.ordinal()] = message.count_seen + BuildConfig.FLAVOR;
        strArr[MessageColumn.is_edited20.ordinal()] = message.is_edited ? "1" : "0";
        if (message.forwarded_from != null) {
            int iOrdinal5 = MessageColumn.forward_type_from21.ordinal();
            Message.ForwardFromType forwardFromType = message.forwarded_from.type_from;
            strArr[iOrdinal5] = forwardFromType != null ? forwardFromType.name() : null;
            strArr[MessageColumn.forward_message_id22.ordinal()] = message.forwarded_from.message_id + BuildConfig.FLAVOR;
            strArr[MessageColumn.forward_object_guid23.ordinal()] = message.forwarded_from.object_guid;
        } else {
            strArr[MessageColumn.forward_message_id22.ordinal()] = "0";
        }
        strArr[MessageColumn.reply_timeout24.ordinal()] = message.reply_timeout + BuildConfig.FLAVOR;
        if (message.location != null) {
            strArr[MessageColumn.location_longitude25.ordinal()] = message.location.longitude + BuildConfig.FLAVOR;
            strArr[MessageColumn.location_latitude26.ordinal()] = message.location.latitude + BuildConfig.FLAVOR;
        } else {
            strArr[MessageColumn.location_longitude25.ordinal()] = "0";
            strArr[MessageColumn.location_latitude26.ordinal()] = "0";
        }
        if (message.sticker != null) {
            strArr[MessageColumn.sticker_id27.ordinal()] = message.sticker.sticker_id;
            strArr[MessageColumn.sticker_w_h_ratio28.ordinal()] = message.sticker.w_h_ratio + BuildConfig.FLAVOR;
            strArr[MessageColumn.sticker_file_id29.ordinal()] = message.sticker.getFileId() + BuildConfig.FLAVOR;
            strArr[MessageColumn.sticker_dc_id30.ordinal()] = message.sticker.getDcId();
            strArr[MessageColumn.sticker_access_hash_rec31.ordinal()] = message.sticker.getHashRec();
            strArr[MessageColumn.sticker_emoji_character32.ordinal()] = message.sticker.emoji_character;
            strArr[MessageColumn.sticker_sticker_set_id33.ordinal()] = message.sticker.sticker_set_id;
            strArr[MessageColumn.sticker_file_cdn_tag84.ordinal()] = message.sticker.getCdnTag();
        } else {
            strArr[MessageColumn.sticker_w_h_ratio28.ordinal()] = "0";
        }
        strArr[MessageColumn.local_deleted_type_35.ordinal()] = message.is_local_deleted ? "1" : "0";
        if (message.contact_message != null) {
            strArr[MessageColumn.json_contact38.ordinal()] = this.jsonHelper.toJson(message.contact_message);
        }
        int iOrdinal6 = MessageColumn.type39.ordinal();
        if (message.type != null) {
            str2 = message.type + BuildConfig.FLAVOR;
        } else {
            str2 = null;
        }
        strArr[iOrdinal6] = str2;
        if (message.poll != null) {
            strArr[MessageColumn.json_poll44.ordinal()] = this.jsonHelper.toJson(message.poll);
        }
        if (message.live_location != null) {
            strArr[MessageColumn.live_loc_track_id47.ordinal()] = message.live_location.live_loc_track_id;
            int iOrdinal7 = MessageColumn.live_loc_current_location_lat48.ordinal();
            if (message.live_location.current_location != null) {
                str3 = message.live_location.current_location.latitude + BuildConfig.FLAVOR;
            } else {
                str3 = "0";
            }
            strArr[iOrdinal7] = str3;
            int iOrdinal8 = MessageColumn.live_loc_current_location_lon49.ordinal();
            if (message.live_location.current_location != null) {
                str4 = message.live_location.current_location.longitude + BuildConfig.FLAVOR;
            } else {
                str4 = "0";
            }
            strArr[iOrdinal8] = str4;
            strArr[MessageColumn.live_loc_device_hash50.ordinal()] = message.live_location.device_hash;
            strArr[MessageColumn.live_loc_user_guid51.ordinal()] = message.live_location.user_guid;
            int iOrdinal9 = MessageColumn.live_loc_status52.ordinal();
            LiveLocationObject.Status status = message.live_location.status;
            strArr[iOrdinal9] = status != null ? status.name() : null;
            strArr[MessageColumn.live_loc_start_time53.ordinal()] = message.live_location.start_time + BuildConfig.FLAVOR;
            strArr[MessageColumn.live_loc_live_period54.ordinal()] = message.live_location.live_period + BuildConfig.FLAVOR;
            strArr[MessageColumn.live_loc_last_update_time55.ordinal()] = message.live_location.last_update_time + BuildConfig.FLAVOR;
        } else {
            strArr[MessageColumn.live_loc_current_location_lat48.ordinal()] = "0";
            strArr[MessageColumn.live_loc_current_location_lon49.ordinal()] = "0";
            strArr[MessageColumn.live_loc_start_time53.ordinal()] = "0";
            strArr[MessageColumn.live_loc_live_period54.ordinal()] = "0";
            strArr[MessageColumn.live_loc_last_update_time55.ordinal()] = "0";
        }
        int iOrdinal10 = MessageColumn.forwarded_no_link_from_title56.ordinal();
        ForwardedNoLinkObject forwardedNoLinkObject = message.forwarded_no_link;
        strArr[iOrdinal10] = forwardedNoLinkObject != null ? forwardedNoLinkObject.from_title : null;
        KeyPadObject keyPadObject = message.inline_keypad;
        if (keyPadObject != null && (arrayList2 = keyPadObject.rows) != null && arrayList2.size() > 0) {
            strArr[MessageColumn.key_pad_json57.ordinal()] = this.jsonHelper.toJson(message.inline_keypad);
        }
        if (message.message_call != null) {
            strArr[MessageColumn.call_data_json59.ordinal()] = this.jsonHelper.toJson(message.message_call);
        }
        if (message.live_data != null) {
            strArr[MessageColumn.live_id60.ordinal()] = message.live_data.live_id;
            strArr[MessageColumn.live_access_token61.ordinal()] = message.live_data.access_token;
            strArr[MessageColumn.live_status_json62.ordinal()] = this.jsonHelper.toJson(message.live_data.live_status);
            strArr[MessageColumn.live_thumb_inline74.ordinal()] = message.live_data.thumb_inline;
            strArr[MessageColumn.live_title80.ordinal()] = message.live_data.title;
        }
        MetaDataObject metaDataObject = message.metadata;
        if (metaDataObject != null && (arrayList = metaDataObject.meta_data_parts) != null && !arrayList.isEmpty()) {
            strArr[MessageColumn.metadata_json63.ordinal()] = this.jsonHelper.toJson(message.metadata);
        }
        Message.EventObject eventObject = message.event_data;
        if (eventObject != null && eventObject.type != null) {
            strArr[MessageColumn.event_json64.ordinal()] = this.jsonHelper.toJson(message.event_data);
        }
        strArr[MessageColumn.author_signature65.ordinal()] = message.author_signature;
        strArr[MessageColumn.isDeleted66.ordinal()] = message.isDeleted ? "1" : "0";
        strArr[MessageColumn.timeStamp67.ordinal()] = j + BuildConfig.FLAVOR;
        if (message.message_id < 0) {
            if (message.localParametersObject != null) {
                strArr[MessageColumn.localParameters69.ordinal()] = this.jsonHelper.toJson(message.localParametersObject);
            }
            strArr[MessageColumn.sendState71.ordinal()] = message.sendState + BuildConfig.FLAVOR;
        }
        strArr[MessageColumn.timeMillis70.ordinal()] = message.timeMillis + BuildConfig.FLAVOR;
        strArr[MessageColumn.isLocallyEdited72.ordinal()] = message.isLocallyEdited ? "1" : "0";
        strArr[MessageColumn.via_bot_guid73.ordinal()] = message.via_bot_guid;
        if (message.rubino_story_data != null) {
            strArr[MessageColumn.rubino_story_data.ordinal()] = this.jsonHelper.toJson(message.rubino_story_data);
        }
        if (message.rubino_post_data != null) {
            strArr[MessageColumn.rubino_post_data.ordinal()] = this.jsonHelper.toJson(message.rubino_post_data);
        }
        if (message.product_message_data != null) {
            strArr[MessageColumn.product_message_data78.ordinal()] = this.jsonHelper.toJson(message.product_message_data);
        }
        if (message.type == Message.MessageTypeEnum.WalletTransfer && message.wallet_transfer_data != null) {
            strArr[MessageColumn.wallet_transfer_data79.ordinal()] = this.jsonHelper.toJson(message.wallet_transfer_data);
        }
        strArr[MessageColumn.is_banned81.ordinal()] = message.is_banned ? "1" : "0";
        if (message.reactions != null) {
            strArr[MessageColumn.reactions83.ordinal()] = this.jsonHelper.toJson(message.reactions);
        }
        return strArr;
    }

    private String[] getChatExtraValueArray(ChatExtra chatExtra) {
        String str;
        String str2;
        String[] strArr = new String[ChatExtraColumn.values().length];
        strArr[ChatExtraColumn.object_guid1.ordinal()] = chatExtra.object_guid;
        ChatMessage chatMessage = chatExtra.local_last_message;
        if (chatMessage != null) {
            strArr[ChatExtraColumn.local_last_message_message_id2.ordinal()] = chatMessage.message_id + BuildConfig.FLAVOR;
            int iOrdinal = ChatExtraColumn.local_last_message_type3.ordinal();
            if (chatMessage.type != null) {
                str = chatMessage.type + BuildConfig.FLAVOR;
            } else {
                str = null;
            }
            strArr[iOrdinal] = str;
            strArr[ChatExtraColumn.local_last_message_text4.ordinal()] = chatMessage.text;
            strArr[ChatExtraColumn.local_last_message_author_object_guid5.ordinal()] = chatMessage.author_object_guid;
            int iOrdinal2 = ChatExtraColumn.local_last_message_author_type6.ordinal();
            if (chatMessage.author_type != null) {
                str2 = chatMessage.author_type + BuildConfig.FLAVOR;
            } else {
                str2 = null;
            }
            strArr[iOrdinal2] = str2;
            strArr[ChatExtraColumn.local_last_message_is_mine7.ordinal()] = chatMessage.is_mine ? "1" : "0";
            strArr[ChatExtraColumn.local_last_message_author_title8.ordinal()] = chatMessage.author_title;
            int iOrdinal3 = ChatExtraColumn.local_last_message_metadata_json13.ordinal();
            MetaDataObject metaDataObject = chatMessage.metadata;
            strArr[iOrdinal3] = metaDataObject != null ? this.jsonHelper.toJson(metaDataObject) : null;
        }
        strArr[ChatExtraColumn.local_last_message_prev_message_id9.ordinal()] = chatExtra.local_last_message_prev_message_id + BuildConfig.FLAVOR;
        strArr[ChatExtraColumn.local_last_message_send_state13.ordinal()] = chatExtra.local_last_message_send_state + BuildConfig.FLAVOR;
        strArr[ChatExtraColumn.local_last_seen_my_mid10.ordinal()] = chatExtra.local_last_seen_my_mid + BuildConfig.FLAVOR;
        strArr[ChatExtraColumn.local_count_unseen11.ordinal()] = chatExtra.local_count_unseen + BuildConfig.FLAVOR;
        strArr[ChatExtraColumn.local_time12.ordinal()] = chatExtra.local_time + BuildConfig.FLAVOR;
        return strArr;
    }

    private String[] getChatValueArray(Chat chat) {
        String str;
        String[] strArr = new String[ChatColumn.values().length];
        strArr[ChatColumn.object_guid1.ordinal()] = chat.object_guid;
        strArr[ChatColumn.access2.ordinal()] = this.jsonHelper.toJson(chat.access);
        strArr[ChatColumn.count_unseen3.ordinal()] = chat.count_unseen + BuildConfig.FLAVOR;
        strArr[ChatColumn.is_mute4.ordinal()] = chat.is_mute ? "1" : "0";
        strArr[ChatColumn.is_pinned5.ordinal()] = chat.is_pinned ? "1" : "0";
        strArr[ChatColumn.time_string6.ordinal()] = chat.time_string;
        if (chat.last_message != null) {
            strArr[ChatColumn.last_message_message_id7.ordinal()] = chat.last_message.message_id + BuildConfig.FLAVOR;
            int iOrdinal = ChatColumn.last_message_type8.ordinal();
            ChatMessage.ChatMessageTypeEnum chatMessageTypeEnum = chat.last_message.type;
            strArr[iOrdinal] = chatMessageTypeEnum != null ? chatMessageTypeEnum.name() : null;
            strArr[ChatColumn.last_message_text9.ordinal()] = chat.last_message.text;
            strArr[ChatColumn.last_message_author_object_guid10.ordinal()] = chat.last_message.author_object_guid;
            int iOrdinal2 = ChatColumn.last_message_author_type11.ordinal();
            Message.AuthorTypeEnum authorTypeEnum = chat.last_message.author_type;
            strArr[iOrdinal2] = authorTypeEnum != null ? authorTypeEnum.name() : null;
            strArr[ChatColumn.last_message_is_mine12.ordinal()] = chat.last_message.is_mine ? "1" : "0";
            strArr[ChatColumn.last_message_author_title13.ordinal()] = chat.last_message.author_title;
            strArr[ChatColumn.last_message_metadata_json38.ordinal()] = this.jsonHelper.toJson(chat.last_message.metadata);
        }
        strArr[ChatColumn.last_seen_my_mid14.ordinal()] = chat.last_seen_my_mid + BuildConfig.FLAVOR;
        strArr[ChatColumn.last_seen_peer_mid15.ordinal()] = chat.last_seen_peer_mid + BuildConfig.FLAVOR;
        int iOrdinal3 = ChatColumn.status16.ordinal();
        if (chat.status != null) {
            str = chat.status + BuildConfig.FLAVOR;
        } else {
            str = null;
        }
        strArr[iOrdinal3] = str;
        strArr[ChatColumn.time27.ordinal()] = chat.time + BuildConfig.FLAVOR;
        strArr[ChatColumn.pinned_message_id28.ordinal()] = chat.pinned_message_id + BuildConfig.FLAVOR;
        int iOrdinal4 = ChatColumn.pinned_message_ids37.ordinal();
        ArrayList<Long> arrayList = chat.pinned_message_ids;
        strArr[iOrdinal4] = arrayList != null ? this.jsonHelper.toJson(arrayList) : null;
        strArr[ChatColumn.is_blocked29.ordinal()] = chat.is_blocked ? "1" : "0";
        strArr[ChatColumn.last_message_id30.ordinal()] = chat.last_message_id + BuildConfig.FLAVOR;
        strArr[ChatColumn.last_deleted_mid31.ordinal()] = chat.last_deleted_mid + BuildConfig.FLAVOR;
        int iOrdinal5 = ChatColumn.chat_keypad_json_32.ordinal();
        KeyPadObject keyPadObject = chat.chat_keypad;
        strArr[iOrdinal5] = keyPadObject != null ? this.jsonHelper.toJson(keyPadObject) : null;
        strArr[ChatColumn.chat_keypad_timestamp_33.ordinal()] = "0";
        strArr[ChatColumn.slow_mode_duration35.ordinal()] = chat.slow_mode_duration + BuildConfig.FLAVOR;
        strArr[ChatColumn.group_my_last_send_time36.ordinal()] = chat.group_my_last_send_time + BuildConfig.FLAVOR;
        strArr[ChatColumn.is_in_contact34.ordinal()] = chat.is_in_contact ? "1" : "0";
        strArr[ChatColumn.timestamp64.ordinal()] = chat.getUpdateTimestamp() + BuildConfig.FLAVOR;
        strArr[ChatColumn.group_voice_chat_id68.ordinal()] = chat.group_voice_chat_id;
        strArr[ChatColumn.show_ask_spam69.ordinal()] = chat.show_ask_spam ? "1" : "0";
        return strArr;
    }

    public FindMessageIdResult findOldestMessageIdAboveMaxId(String str, long j, MessageUtils.FilterTypeEnum filterTypeEnum) {
        MessageUtils.FilterTypeEnum filterTypeEnum2;
        FindMessageIdResult findMessageIdResult = new FindMessageIdResult();
        if (filterTypeEnum == null || filterTypeEnum == (filterTypeEnum2 = MessageUtils.FilterTypeEnum.All)) {
            if (isIdInHole(str, filterTypeEnum, j)) {
                findMessageIdResult.isFound = false;
                return findMessageIdResult;
            }
            long maxHoleEndAboveMaxId = getMaxHoleEndAboveMaxId(str, j, filterTypeEnum);
            findMessageIdResult.isFound = true;
            findMessageIdResult.messageId = maxHoleEndAboveMaxId + 1;
            return findMessageIdResult;
        }
        boolean zIsIdInHole = isIdInHole(str, filterTypeEnum2, j);
        boolean zIsIdInHole2 = isIdInHole(str, filterTypeEnum, j);
        if (zIsIdInHole && zIsIdInHole2) {
            findMessageIdResult.isFound = false;
        } else {
            findMessageIdResult.isFound = true;
            if (!zIsIdInHole && !zIsIdInHole2) {
                findMessageIdResult.messageId = Math.min(getMaxHoleEndAboveMaxId(str, j, filterTypeEnum2), getMaxHoleEndAboveMaxId(str, j, filterTypeEnum)) + 1;
            } else if (!zIsIdInHole) {
                findMessageIdResult.messageId = getMaxHoleEndAboveMaxId(str, j, filterTypeEnum2) + 1;
            } else if (!zIsIdInHole2) {
                findMessageIdResult.messageId = getMaxHoleEndAboveMaxId(str, j, filterTypeEnum) + 1;
            }
        }
        return findMessageIdResult;
    }

    public FindMessageIdResult findNewestMessageIdBelowMinId(String str, long j, MessageUtils.FilterTypeEnum filterTypeEnum) {
        MessageUtils.FilterTypeEnum filterTypeEnum2;
        FindMessageIdResult findMessageIdResult = new FindMessageIdResult();
        if (j < 0) {
            findMessageIdResult.isFound = false;
            return findMessageIdResult;
        }
        if (filterTypeEnum == null || filterTypeEnum == (filterTypeEnum2 = MessageUtils.FilterTypeEnum.All)) {
            if (isIdInHole(str, filterTypeEnum, j)) {
                findMessageIdResult.isFound = false;
                return findMessageIdResult;
            }
            long minHoleStartBelowMinId = getMinHoleStartBelowMinId(str, j, filterTypeEnum);
            if (minHoleStartBelowMinId < j) {
                findMessageIdResult.isFound = false;
                return findMessageIdResult;
            }
            findMessageIdResult.isFound = true;
            findMessageIdResult.messageId = minHoleStartBelowMinId - 1;
            return findMessageIdResult;
        }
        boolean zIsIdInHole = isIdInHole(str, filterTypeEnum2, j);
        boolean zIsIdInHole2 = isIdInHole(str, filterTypeEnum, j);
        if (zIsIdInHole && zIsIdInHole2) {
            findMessageIdResult.isFound = false;
        } else {
            findMessageIdResult.isFound = true;
            if (!zIsIdInHole && !zIsIdInHole2) {
                long minHoleStartBelowMinId2 = getMinHoleStartBelowMinId(str, j, filterTypeEnum2);
                long minHoleStartBelowMinId3 = getMinHoleStartBelowMinId(str, j, filterTypeEnum);
                if (minHoleStartBelowMinId2 < j && minHoleStartBelowMinId3 < j) {
                    findMessageIdResult.isFound = false;
                }
                findMessageIdResult.messageId = Math.max(minHoleStartBelowMinId2, minHoleStartBelowMinId3) - 1;
            } else if (!zIsIdInHole) {
                long minHoleStartBelowMinId4 = getMinHoleStartBelowMinId(str, j, filterTypeEnum2);
                if (minHoleStartBelowMinId4 < j) {
                    findMessageIdResult.isFound = false;
                }
                findMessageIdResult.messageId = minHoleStartBelowMinId4 - 1;
            } else if (!zIsIdInHole2) {
                long minHoleStartBelowMinId5 = getMinHoleStartBelowMinId(str, j, filterTypeEnum);
                if (minHoleStartBelowMinId5 < j) {
                    findMessageIdResult.isFound = false;
                }
                findMessageIdResult.messageId = minHoleStartBelowMinId5 - 1;
            }
        }
        return findMessageIdResult;
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public GetMessagesResultInner getLocalMessages(String str, MessageUtils.FilterTypeEnum filterTypeEnum, long j, long j2, boolean z, int i) {
        GetMessagesResultInner getMessagesResultInner = new GetMessagesResultInner();
        ArrayList<Message> arrayListSelectJustLocalMessages = selectJustLocalMessages(str, filterTypeEnum, j, j2, z, i);
        if (arrayListSelectJustLocalMessages != null && arrayListSelectJustLocalMessages.size() > 0) {
            getMessagesResultInner.justLocalMessages = arrayListSelectJustLocalMessages;
            getMessagesResultInner.hasJustLocal = true;
            int size = arrayListSelectJustLocalMessages.size();
            if (z) {
                long j3 = getMessagesResultInner.justLocalMessages.get(size - 1).message_id;
                long absMaxLocalId = getAbsMaxLocalId(str, filterTypeEnum);
                getMessagesResultInner.newerHasContinue = true;
                if (Math.abs(j3) >= absMaxLocalId) {
                    getMessagesResultInner.newerHasContinue = false;
                }
            } else {
                long j4 = getMessagesResultInner.justLocalMessages.get(size - 1).message_id;
                long absMinLocalId = getAbsMinLocalId(str, filterTypeEnum);
                getMessagesResultInner.newerHasContinue = true;
                if (Math.abs(j4) <= absMinLocalId) {
                    getMessagesResultInner.olderHasContinue = false;
                }
            }
        }
        return getMessagesResultInner;
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public ArrayList<Message> getAllLocalMessages(Set<Integer> set) {
        WhereCondition whereCondition;
        WhereCondition whereCondition2 = new WhereCondition(MessageColumn.message_id2.name(), WhereCondition.OperatorEnum.LTE, "0");
        String strName = MessageColumn.isLocallyEdited72.name();
        WhereCondition.OperatorEnum operatorEnum = WhereCondition.OperatorEnum.EQ;
        WhereCondition whereCondition3 = new WhereCondition(new WhereCondition(whereCondition2, WhereCondition.OperatorEnum.Or, new WhereCondition(strName, operatorEnum, "1")), WhereCondition.OperatorEnum.And, new WhereCondition(MessageColumn.isDeleted66.name(), operatorEnum, "0"));
        if (set == null || set.size() <= 0) {
            whereCondition = whereCondition3;
        } else {
            ArrayList arrayList = new ArrayList();
            for (Integer num : set) {
                if (num != null) {
                    arrayList.add(String.valueOf(num));
                }
            }
            whereCondition = new WhereCondition(whereCondition3, WhereCondition.OperatorEnum.And, new WhereCondition(MessageColumn.sendState71.name(), WhereCondition.OperatorEnum.In, (ArrayList<String>) arrayList));
        }
        return this.db.selectObject(TableName.messageTable.name(), null, whereCondition, new String[]{MessageColumn.timeMillis70.name(), MessageColumn.message_id2.name()}, new FunctionEnum[]{null, FunctionEnum.Abs}, new boolean[]{false, false}, 600, new DBParser<Message>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.11
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // ir.aaap.messengercore.db.DBParser
            public Message parse(CursorInterFace cursorInterFace) {
                return DBHelperImpl.this.lambda$getMessagesWithFileInline$1(cursorInterFace);
            }
        });
    }

    public GetMessagesResultInner getMessagesToBottom(String str, MessageUtils.FilterTypeEnum filterTypeEnum, long j, long j2, int i, boolean z) {
        long j3;
        DBHelperImpl dBHelperImpl;
        String str2;
        MessageUtils.FilterTypeEnum filterTypeEnum2;
        long jMax = j;
        GetMessagesResultInner getMessagesResultInner = new GetMessagesResultInner();
        if (z) {
            dBHelperImpl = this;
            str2 = str;
            filterTypeEnum2 = filterTypeEnum;
            j3 = jMax;
        } else {
            j3 = jMax + 1;
            dBHelperImpl = this;
            str2 = str;
            filterTypeEnum2 = filterTypeEnum;
        }
        FindMessageIdResult findMessageIdResultFindNewestMessageIdBelowMinId = dBHelperImpl.findNewestMessageIdBelowMinId(str2, j3, filterTypeEnum2);
        if (!findMessageIdResultFindNewestMessageIdBelowMinId.isFound) {
            getMessagesResultInner.isExistInDB = false;
            return getMessagesResultInner;
        }
        long j4 = findMessageIdResultFindNewestMessageIdBelowMinId.messageId;
        ArrayList<Message> messages = getMessages(str, filterTypeEnum, j, j4, i, true, z);
        getMessagesResultInner.isExistInDB = true;
        getMessagesResultInner.messages = messages;
        getMessagesResultInner.hasContinue = true;
        int size = messages.size();
        getMessagesResultInner.newMinId = jMax;
        if (size > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                jMax = Math.max(messages.get(i2).message_id, jMax);
            }
            getMessagesResultInner.newMinId = jMax + 1;
        } else {
            getMessagesResultInner.newMinId = j4 + 1;
        }
        if (getMessagesResultInner.newMinId > j2) {
            getMessagesResultInner.hasContinue = false;
        }
        return getMessagesResultInner;
    }

    public GetMessagesResultInner getMessagesToTop(String str, MessageUtils.FilterTypeEnum filterTypeEnum, long j, long j2, int i) {
        long jMin = j;
        GetMessagesResultInner getMessagesResultInner = new GetMessagesResultInner();
        if (jMin == 0) {
            getMessagesResultInner.isExistInDB = true;
            getMessagesResultInner.messages = new ArrayList<>();
            getMessagesResultInner.hasContinue = false;
            return getMessagesResultInner;
        }
        FindMessageIdResult findMessageIdResultFindOldestMessageIdAboveMaxId = findOldestMessageIdAboveMaxId(str, jMin, filterTypeEnum);
        if (!findMessageIdResultFindOldestMessageIdAboveMaxId.isFound) {
            getMessagesResultInner.isExistInDB = false;
            return getMessagesResultInner;
        }
        long j3 = findMessageIdResultFindOldestMessageIdAboveMaxId.messageId;
        ArrayList<Message> messages = getMessages(str, filterTypeEnum, j3, j, i, false);
        getMessagesResultInner.isExistInDB = true;
        getMessagesResultInner.messages = messages;
        getMessagesResultInner.hasContinue = true;
        int size = messages.size();
        if (size < i && (j3 <= j2 || j3 <= 1)) {
            getMessagesResultInner.hasContinue = false;
        }
        getMessagesResultInner.newMaxId = jMin;
        if (size > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                jMin = Math.min(messages.get(i2).message_id, jMin);
            }
            getMessagesResultInner.newMaxId = jMin - 1;
        } else {
            getMessagesResultInner.newMaxId = j3 - 1;
        }
        return getMessagesResultInner;
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public GetMessagesResultInner getMessagesInterval(String str, MessageUtils.FilterTypeEnum filterTypeEnum, long j, long j2, long j3, int i, int i2) {
        GetMessagesResultInner getMessagesResultInner;
        GetMessagesResultInner messagesToBottom;
        GetMessagesResultInner getMessagesResultInner2 = new GetMessagesResultInner();
        if (j <= j3 || j < 1) {
            getMessagesResultInner = new GetMessagesResultInner();
            getMessagesResultInner.hasContinue = false;
        } else {
            getMessagesResultInner = getMessagesToTop(str, filterTypeEnum, j, j3, i);
        }
        GetMessagesResultInner getMessagesResultInner3 = getMessagesResultInner;
        if (j >= j2) {
            messagesToBottom = new GetMessagesResultInner();
            messagesToBottom.hasContinue = false;
        } else {
            messagesToBottom = getMessagesToBottom(str, filterTypeEnum, j, j2, i2, false);
        }
        if ((!getMessagesResultInner3.isExistInDB && !messagesToBottom.isExistInDB) || (j == 0 && !messagesToBottom.isExistInDB)) {
            getMessagesResultInner2.isExistInDB = false;
            return getMessagesResultInner2;
        }
        getMessagesResultInner2.messages = new ArrayList<>();
        ArrayList<Message> arrayList = getMessagesResultInner3.messages;
        if (arrayList != null) {
            Collections.reverse(arrayList);
            getMessagesResultInner2.messages.addAll(getMessagesResultInner3.messages);
        }
        ArrayList<Message> arrayList2 = messagesToBottom.messages;
        if (arrayList2 != null) {
            getMessagesResultInner2.messages.addAll(arrayList2);
        }
        ArrayList<Message> arrayList3 = getMessagesResultInner3.messages;
        if (arrayList3 == null || arrayList3.isEmpty()) {
            if (getMessagesResultInner2.messages.size() > 0) {
                getMessagesResultInner2.newMaxId = getMessagesResultInner2.messages.get(0).message_id - 1;
            } else {
                getMessagesResultInner2.newMaxId = j - 1;
            }
            getMessagesResultInner2.olderHasContinue = true;
            if (getMessagesResultInner2.messages.size() < i) {
                long j4 = getMessagesResultInner2.newMaxId;
                if (j4 <= j3 || j4 < 1) {
                    getMessagesResultInner2.olderHasContinue = false;
                }
            }
        } else {
            getMessagesResultInner2.newMaxId = getMessagesResultInner3.newMaxId;
            getMessagesResultInner2.olderHasContinue = getMessagesResultInner3.hasContinue;
        }
        ArrayList<Message> arrayList4 = messagesToBottom.messages;
        if (arrayList4 == null || arrayList4.isEmpty()) {
            if (getMessagesResultInner2.messages.size() > 0) {
                ArrayList<Message> arrayList5 = getMessagesResultInner2.messages;
                getMessagesResultInner2.newMinId = arrayList5.get(arrayList5.size() - 1).message_id + 1;
            } else {
                getMessagesResultInner2.newMinId = j + 1;
            }
            getMessagesResultInner2.newerHasContinue = getMessagesResultInner2.newMinId <= j2;
        } else {
            getMessagesResultInner2.newMinId = messagesToBottom.newMinId;
            getMessagesResultInner2.newerHasContinue = messagesToBottom.hasContinue;
        }
        getMessagesResultInner2.isExistInDB = true;
        return getMessagesResultInner2;
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public GetMessagesResultInner getMessagesToBottomOrTop(String str, MessageUtils.FilterTypeEnum filterTypeEnum, boolean z, long j, long j2, long j3, int i) {
        new GetMessagesResultInner();
        if (z) {
            return getMessagesToBottom(str, filterTypeEnum, j, j2, i, true);
        }
        return getMessagesToTop(str, filterTypeEnum, j, j3, i);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public Message getMessageById(String str, long j) {
        String strName = MessageColumn.object_guid1.name();
        WhereCondition.OperatorEnum operatorEnum = WhereCondition.OperatorEnum.EQ;
        WhereCondition whereCondition = new WhereCondition(strName, operatorEnum, str);
        WhereCondition whereCondition2 = new WhereCondition(MessageColumn.message_id2.name(), operatorEnum, j + BuildConfig.FLAVOR);
        WhereCondition whereCondition3 = new WhereCondition(MessageColumn.isDeleted66.name(), operatorEnum, "0");
        WhereCondition.OperatorEnum operatorEnum2 = WhereCondition.OperatorEnum.And;
        ArrayList arrayListSelectObject = this.db.selectObject(TableName.messageTable.name(), null, new WhereCondition(new WhereCondition(whereCondition, operatorEnum2, whereCondition2), operatorEnum2, whereCondition3), null, false, 0, new DBParser<Message>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.12
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // ir.aaap.messengercore.db.DBParser
            public Message parse(CursorInterFace cursorInterFace) {
                return DBHelperImpl.this.lambda$getMessagesWithFileInline$1(cursorInterFace);
            }
        });
        if (arrayListSelectObject.size() > 0) {
            return (Message) arrayListSelectObject.get(0);
        }
        return null;
    }

    public ArrayList<Message> getMessages(String str, MessageUtils.FilterTypeEnum filterTypeEnum, long j, long j2, int i, boolean z) {
        return getMessages(str, filterTypeEnum, j, j2, i, z, true);
    }

    public ArrayList<Message> getMessages(String str, MessageUtils.FilterTypeEnum filterTypeEnum, long j, long j2, int i, boolean z, boolean z2) {
        int i2;
        WhereCondition.OperatorEnum operatorEnum;
        WhereCondition filterTypeCondition;
        if (str == null) {
            return new ArrayList<>();
        }
        long j3 = j < 0 ? 0L : j;
        if (i <= 0 || i > 100) {
            this.coreLog.recordFireBaseException(new InvalidInputException2("get message limit db" + i + " guid " + str + " filterType " + filterTypeEnum + " fromMin " + z + " minid " + j3 + " max " + j2 + "includedEqual" + z2));
            i2 = 100;
        } else {
            i2 = i;
        }
        String strName = MessageColumn.object_guid1.name();
        WhereCondition.OperatorEnum operatorEnum2 = WhereCondition.OperatorEnum.EQ;
        WhereCondition whereCondition = new WhereCondition(strName, operatorEnum2, str);
        if (z2) {
            operatorEnum = WhereCondition.OperatorEnum.GTE;
        } else {
            operatorEnum = WhereCondition.OperatorEnum.GT;
        }
        MessageColumn messageColumn = MessageColumn.message_id2;
        WhereCondition whereCondition2 = new WhereCondition(messageColumn.name(), operatorEnum, j3 + BuildConfig.FLAVOR);
        if (j2 > 0) {
            whereCondition2 = new WhereCondition(whereCondition2, WhereCondition.OperatorEnum.And, new WhereCondition(messageColumn.name(), WhereCondition.OperatorEnum.LTE, j2 + BuildConfig.FLAVOR));
        }
        WhereCondition.OperatorEnum operatorEnum3 = WhereCondition.OperatorEnum.And;
        WhereCondition whereCondition3 = new WhereCondition(whereCondition, operatorEnum3, whereCondition2);
        if (filterTypeEnum != null && (filterTypeCondition = getFilterTypeCondition(filterTypeEnum)) != null) {
            whereCondition3 = new WhereCondition(whereCondition3, operatorEnum3, filterTypeCondition);
        }
        return this.db.selectObject(TableName.messageTable.name(), null, new WhereCondition(whereCondition3, operatorEnum3, new WhereCondition(MessageColumn.isDeleted66.name(), operatorEnum2, "0")), messageColumn.name(), z, i2, new DBParser<Message>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.13
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // ir.aaap.messengercore.db.DBParser
            public Message parse(CursorInterFace cursorInterFace) {
                return DBHelperImpl.this.lambda$getMessagesWithFileInline$1(cursorInterFace);
            }
        });
    }

    public ArrayList<Message> selectJustLocalMessages(String str, MessageUtils.FilterTypeEnum filterTypeEnum, long j, long j2, boolean z, int i) {
        MessageColumn messageColumn;
        long j3;
        WhereCondition filterTypeCondition;
        if (str == null) {
            return new ArrayList<>();
        }
        String strName = MessageColumn.object_guid1.name();
        WhereCondition.OperatorEnum operatorEnum = WhereCondition.OperatorEnum.EQ;
        WhereCondition whereCondition = new WhereCondition(strName, operatorEnum, str);
        MessageColumn messageColumn2 = MessageColumn.message_id2;
        String strName2 = messageColumn2.name();
        WhereCondition.OperatorEnum operatorEnum2 = WhereCondition.OperatorEnum.LTE;
        WhereCondition whereCondition2 = new WhereCondition(strName2, operatorEnum2, "0");
        if (j >= 0 || j2 > 0) {
            if (j >= 0) {
                messageColumn = messageColumn2;
                whereCondition2 = new WhereCondition(whereCondition2, WhereCondition.OperatorEnum.And, new WhereCondition(MessageColumn.timeMillis70.name(), WhereCondition.OperatorEnum.GTE, j + BuildConfig.FLAVOR));
                j3 = 0;
            } else {
                messageColumn = messageColumn2;
                j3 = 0;
            }
            if (j2 > j3) {
                whereCondition2 = new WhereCondition(whereCondition2, WhereCondition.OperatorEnum.And, new WhereCondition(MessageColumn.timeMillis70.name(), operatorEnum2, j2 + BuildConfig.FLAVOR));
            }
        } else {
            this.coreLog.e("TAAAAAG", "HEEEEREEEE");
            messageColumn = messageColumn2;
        }
        WhereCondition.OperatorEnum operatorEnum3 = WhereCondition.OperatorEnum.And;
        WhereCondition whereCondition3 = new WhereCondition(whereCondition, operatorEnum3, whereCondition2);
        if (filterTypeEnum != null && (filterTypeCondition = getFilterTypeCondition(filterTypeEnum)) != null) {
            whereCondition3 = new WhereCondition(whereCondition3, operatorEnum3, filterTypeCondition);
        }
        return this.db.selectObject(TableName.messageTable.name(), null, new WhereCondition(whereCondition3, operatorEnum3, new WhereCondition(MessageColumn.isDeleted66.name(), operatorEnum, "0")), new String[]{MessageColumn.timeMillis70.name(), messageColumn.name()}, new FunctionEnum[]{null, FunctionEnum.Abs}, new boolean[]{z, z}, i > 0 ? i : 600, new DBParser<Message>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.14
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // ir.aaap.messengercore.db.DBParser
            public Message parse(CursorInterFace cursorInterFace) {
                return DBHelperImpl.this.lambda$getMessagesWithFileInline$1(cursorInterFace);
            }
        });
    }

    private WhereCondition getFilterTypeCondition(MessageUtils.FilterTypeEnum filterTypeEnum) {
        String strName;
        if (filterTypeEnum == MessageUtils.FilterTypeEnum.Media) {
            MessageColumn messageColumn = MessageColumn.file_inline_type15;
            String strName2 = messageColumn.name();
            WhereCondition.OperatorEnum operatorEnum = WhereCondition.OperatorEnum.EQ;
            return new WhereCondition(new WhereCondition(strName2, operatorEnum, FileInlineObject.FileInlineType.Image.name()), WhereCondition.OperatorEnum.Or, new WhereCondition(messageColumn.name(), operatorEnum, FileInlineObject.FileInlineType.Video.name()));
        }
        if (filterTypeEnum == MessageUtils.FilterTypeEnum.File) {
            strName = FileInlineObject.FileInlineType.File.name();
        } else if (filterTypeEnum == MessageUtils.FilterTypeEnum.Voice) {
            strName = FileInlineObject.FileInlineType.Voice.name();
        } else {
            strName = filterTypeEnum == MessageUtils.FilterTypeEnum.Music ? FileInlineObject.FileInlineType.Music.name() : null;
        }
        if (strName != null) {
            return new WhereCondition(MessageColumn.file_inline_type15.name(), WhereCondition.OperatorEnum.EQ, strName);
        }
        return null;
    }

    public int getMessagesCount(String str, MessageUtils.FilterTypeEnum filterTypeEnum, long j, long j2) {
        WhereCondition filterTypeCondition;
        if (str == null) {
            return 0;
        }
        String strName = MessageColumn.object_guid1.name();
        WhereCondition.OperatorEnum operatorEnum = WhereCondition.OperatorEnum.EQ;
        WhereCondition whereCondition = new WhereCondition(strName, operatorEnum, str);
        if (j > 0) {
            whereCondition = new WhereCondition(whereCondition, WhereCondition.OperatorEnum.And, new WhereCondition(MessageColumn.message_id2.name(), WhereCondition.OperatorEnum.GTE, j + BuildConfig.FLAVOR));
        }
        if (j2 > 0) {
            whereCondition = new WhereCondition(whereCondition, WhereCondition.OperatorEnum.And, new WhereCondition(MessageColumn.message_id2.name(), WhereCondition.OperatorEnum.LTE, j2 + BuildConfig.FLAVOR));
        }
        if (filterTypeEnum != null && (filterTypeCondition = getFilterTypeCondition(filterTypeEnum)) != null) {
            whereCondition = new WhereCondition(whereCondition, WhereCondition.OperatorEnum.And, filterTypeCondition);
        }
        return this.db.count(TableName.messageTable.name(), null, new WhereCondition(whereCondition, WhereCondition.OperatorEnum.And, new WhereCondition(MessageColumn.isDeleted66.name(), operatorEnum, "0")));
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public ArrayList<Chat> getAllChatsOrderByTime() {
        return this.db.selectObject(TableName.chatTable.name(), null, null, ChatColumn.time_string6.name(), false, 2500, new DBParser<Chat>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.15
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // ir.aaap.messengercore.db.DBParser
            public Chat parse(CursorInterFace cursorInterFace) {
                return DBHelperImpl.this.lambda$getAllChats$0(cursorInterFace);
            }
        });
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public ArrayList<Chat> getAllChats() {
        return this.db.selectObject(TableName.chatTable.name(), null, null, null, false, 2500, new DBParser() { // from class: ir.aaap.messengercore.db.DBHelperImpl$$ExternalSyntheticLambda1
            @Override // ir.aaap.messengercore.db.DBParser
            public final Object parse(CursorInterFace cursorInterFace) {
                return this.f$0.lambda$getAllChats$0(cursorInterFace);
            }
        });
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public ArrayList<String> getAllChatsGuidOrderByTime(int i) {
        return this.db.selectObject(TableName.chatTable.name(), null, null, ChatColumn.time_string6.name(), false, Math.min(i, 2500), new DBParser<String>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.16
            @Override // ir.aaap.messengercore.db.DBParser
            public String parse(CursorInterFace cursorInterFace) {
                return cursorInterFace.getString(ChatColumn.object_guid1.name());
            }
        });
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public ChatExtra getChatExtra(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        ArrayList<ChatExtra> allChatExtra = getAllChatExtra(arrayList);
        if (allChatExtra == null || allChatExtra.size() <= 0) {
            return null;
        }
        return allChatExtra.get(0);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public Chat getChatById(String str) {
        if (str != null && !str.isEmpty()) {
            ArrayList arrayListSelectObject = this.db.selectObject(TableName.chatTable.name(), null, new WhereCondition(ChatColumn.object_guid1.name(), WhereCondition.OperatorEnum.EQ, str), null, false, 2500, new DBParser<Chat>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.17
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // ir.aaap.messengercore.db.DBParser
                public Chat parse(CursorInterFace cursorInterFace) {
                    return DBHelperImpl.this.lambda$getAllChats$0(cursorInterFace);
                }
            });
            if (arrayListSelectObject != null && arrayListSelectObject.size() > 0) {
                return (Chat) arrayListSelectObject.get(0);
            }
        }
        return null;
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public ArrayList<ChatExtra> getAllChatExtra(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        return this.db.selectObject(TableName.chatExtraTable.name(), null, new WhereCondition(ChatExtraColumn.object_guid1.name(), WhereCondition.OperatorEnum.In, arrayList), null, false, 2500, new DBParser<ChatExtra>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.18
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // ir.aaap.messengercore.db.DBParser
            public ChatExtra parse(CursorInterFace cursorInterFace) {
                return DBHelperImpl.this.parseChatExtraObject(cursorInterFace);
            }
        });
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public ArrayList<ChatAbsObject> getAllAbsObject(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        return this.db.selectObject(TableName.absTable.name(), null, new WhereCondition(AbsColumn.guid1.name(), WhereCondition.OperatorEnum.In, arrayList), null, false, 2500, new DBParser<ChatAbsObject>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.19
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // ir.aaap.messengercore.db.DBParser
            public ChatAbsObject parse(CursorInterFace cursorInterFace) {
                return DBHelperImpl.this.parseAbsObject(cursorInterFace);
            }
        });
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public ChatAbsObject getAbsObject(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayListSelectObject = this.db.selectObject(TableName.absTable.name(), null, new WhereCondition(AbsColumn.guid1.name(), WhereCondition.OperatorEnum.EQ, str), null, false, 0, new DBParser<ChatAbsObject>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.20
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // ir.aaap.messengercore.db.DBParser
            public ChatAbsObject parse(CursorInterFace cursorInterFace) {
                return DBHelperImpl.this.parseAbsObject(cursorInterFace);
            }
        });
        if (arrayListSelectObject == null || arrayListSelectObject.size() <= 0) {
            return null;
        }
        return (ChatAbsObject) arrayListSelectObject.get(0);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public UserInfo getUserInfo(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayListSelectObject = this.db.selectObject(TableName.userTable.name(), null, new WhereCondition(UserColumn.user_guid1.name(), WhereCondition.OperatorEnum.EQ, str), null, false, 0, new DBParser<UserInfo>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.21
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // ir.aaap.messengercore.db.DBParser
            public UserInfo parse(CursorInterFace cursorInterFace) {
                return DBHelperImpl.this.parseUserInfoObject(cursorInterFace);
            }
        });
        if (arrayListSelectObject == null || arrayListSelectObject.size() <= 0) {
            return null;
        }
        return (UserInfo) arrayListSelectObject.get(0);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public UserInfo getUserInfoByUsername(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayListSelectObject = this.db.selectObject(TableName.userTable.name(), null, new WhereCondition(UserColumn.username5.name(), WhereCondition.OperatorEnum.EqCaseInsensitive, str), null, false, 0, new DBParser<UserInfo>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.22
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // ir.aaap.messengercore.db.DBParser
            public UserInfo parse(CursorInterFace cursorInterFace) {
                return DBHelperImpl.this.parseUserInfoObject(cursorInterFace);
            }
        });
        if (arrayListSelectObject == null || arrayListSelectObject.size() <= 0) {
            return null;
        }
        return (UserInfo) arrayListSelectObject.get(0);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public BotInfo getBotInfoByUsername(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayListSelectObject = this.db.selectObject(TableName.botInfoTable.name(), null, new WhereCondition(BotInfoColumn.username2.name(), WhereCondition.OperatorEnum.EqCaseInsensitive, str), null, false, 0, new DBParser<BotInfo>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.23
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // ir.aaap.messengercore.db.DBParser
            public BotInfo parse(CursorInterFace cursorInterFace) {
                return DBHelperImpl.this.parseBot(cursorInterFace);
            }
        });
        if (arrayListSelectObject == null || arrayListSelectObject.size() <= 0) {
            return null;
        }
        return (BotInfo) arrayListSelectObject.get(0);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public GroupInfo getGroupInfo(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayListSelectObject = this.db.selectObject(TableName.groupInfoTable.name(), null, new WhereCondition(GroupInfoColumn.group_guid1.name(), WhereCondition.OperatorEnum.EQ, str), null, false, 0, new DBParser<GroupInfo>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.24
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // ir.aaap.messengercore.db.DBParser
            public GroupInfo parse(CursorInterFace cursorInterFace) {
                return DBHelperImpl.this.parseGroupInfo(cursorInterFace);
            }
        });
        if (arrayListSelectObject == null || arrayListSelectObject.size() <= 0) {
            return null;
        }
        return (GroupInfo) arrayListSelectObject.get(0);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public ChannelInfo getChannelInfo(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayListSelectObject = this.db.selectObject(TableName.channelInfoTable.name(), null, new WhereCondition(ChannelInfoColumn.channel_guid1.name(), WhereCondition.OperatorEnum.EQ, str), null, false, 0, new DBParser<ChannelInfo>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.25
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // ir.aaap.messengercore.db.DBParser
            public ChannelInfo parse(CursorInterFace cursorInterFace) {
                return DBHelperImpl.this.parseChannelInfo(cursorInterFace);
            }
        });
        if (arrayListSelectObject == null || arrayListSelectObject.size() <= 0) {
            return null;
        }
        return (ChannelInfo) arrayListSelectObject.get(0);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public BotInfo getBotInfo(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayListSelectObject = this.db.selectObject(TableName.botInfoTable.name(), null, new WhereCondition(BotInfoColumn.bot_guid1.name(), WhereCondition.OperatorEnum.EQ, str), null, false, 0, new DBParser<BotInfo>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.26
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // ir.aaap.messengercore.db.DBParser
            public BotInfo parse(CursorInterFace cursorInterFace) {
                return DBHelperImpl.this.parseBot(cursorInterFace);
            }
        });
        if (arrayListSelectObject == null || arrayListSelectObject.size() <= 0) {
            return null;
        }
        return (BotInfo) arrayListSelectObject.get(0);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public ServiceInfo getServiceInfo(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayListSelectObject = this.db.selectObject(TableName.serviceTable.name(), null, new WhereCondition(ServiceColumn.service_guid1.name(), WhereCondition.OperatorEnum.EQ, str), null, false, 0, new DBParser<ServiceInfo>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.27
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // ir.aaap.messengercore.db.DBParser
            public ServiceInfo parse(CursorInterFace cursorInterFace) {
                return DBHelperImpl.this.parseService(cursorInterFace);
            }
        });
        if (arrayListSelectObject == null || arrayListSelectObject.size() <= 0) {
            return null;
        }
        return (ServiceInfo) arrayListSelectObject.get(0);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public ChannelInfo getChannelInfoByUsername(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayListSelectObject = this.db.selectObject(TableName.channelInfoTable.name(), null, new WhereCondition(ChannelInfoColumn.username3.name(), WhereCondition.OperatorEnum.EqCaseInsensitive, str), null, false, 0, new DBParser<ChannelInfo>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.28
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // ir.aaap.messengercore.db.DBParser
            public ChannelInfo parse(CursorInterFace cursorInterFace) {
                return DBHelperImpl.this.parseChannelInfo(cursorInterFace);
            }
        });
        if (arrayListSelectObject == null || arrayListSelectObject.size() <= 0) {
            return null;
        }
        return (ChannelInfo) arrayListSelectObject.get(0);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public ArrayList<UserInfo> searchUsers(String str, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        return this.db.selectObject(TableName.userTable.name(), null, new WhereCondition(UserColumn.user_guid1.name(), WhereCondition.OperatorEnum.In, arrayList), null, false, 0, new DBParser<UserInfo>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.29
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // ir.aaap.messengercore.db.DBParser
            public UserInfo parse(CursorInterFace cursorInterFace) {
                return DBHelperImpl.this.parseUserInfoObject(cursorInterFace);
            }
        });
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public ArrayList<NotificationModels.ShowNotificationObject> getAllNotifications() {
        return this.db.selectObject(TableName.notificationTable.name(), null, new WhereCondition(NotificationColumn.is_read12.name(), WhereCondition.OperatorEnum.EQ, "0"), null, false, 200, new DBParser<NotificationModels.ShowNotificationObject>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.30
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // ir.aaap.messengercore.db.DBParser
            public NotificationModels.ShowNotificationObject parse(CursorInterFace cursorInterFace) {
                return DBHelperImpl.this.parseNotificationObject(cursorInterFace);
            }
        });
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public NotificationModels.ShowNotificationObject getNotificationById(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayListSelectObject = this.db.selectObject(TableName.notificationTable.name(), null, new WhereCondition(NotificationColumn.notification_id1.name(), WhereCondition.OperatorEnum.EQ, str), null, false, 0, new DBParser<NotificationModels.ShowNotificationObject>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.31
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // ir.aaap.messengercore.db.DBParser
            public NotificationModels.ShowNotificationObject parse(CursorInterFace cursorInterFace) {
                return DBHelperImpl.this.parseNotificationObject(cursorInterFace);
            }
        });
        if (arrayListSelectObject == null || arrayListSelectObject.size() <= 0) {
            return null;
        }
        return (NotificationModels.ShowNotificationObject) arrayListSelectObject.get(0);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public ArrayList<NotificationModels.ShowNotificationObject> getAllNotificationById(ArrayList<String> arrayList) {
        if (arrayList == null) {
            return null;
        }
        return this.db.selectObject(TableName.notificationTable.name(), null, new WhereCondition(NotificationColumn.notification_id1.name(), WhereCondition.OperatorEnum.In, arrayList), null, false, 0, new DBParser<NotificationModels.ShowNotificationObject>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.32
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // ir.aaap.messengercore.db.DBParser
            public NotificationModels.ShowNotificationObject parse(CursorInterFace cursorInterFace) {
                return DBHelperImpl.this.parseNotificationObject(cursorInterFace);
            }
        });
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public ArrayList<String> getNotificationByChat(String str) {
        if (str == null || str.isEmpty()) {
            return new ArrayList<>();
        }
        NotificationColumn notificationColumn = NotificationColumn.type2;
        String strName = notificationColumn.name();
        WhereCondition.OperatorEnum operatorEnum = WhereCondition.OperatorEnum.EQ;
        WhereCondition whereCondition = new WhereCondition(strName, operatorEnum, NotificationModels.ShowNotificationTypeEnum.Message.name());
        WhereCondition whereCondition2 = new WhereCondition(NotificationColumn.message_data_object_guid6.name(), operatorEnum, str);
        WhereCondition.OperatorEnum operatorEnum2 = WhereCondition.OperatorEnum.And;
        WhereCondition whereCondition3 = new WhereCondition(new WhereCondition(whereCondition, operatorEnum2, whereCondition2), WhereCondition.OperatorEnum.Or, new WhereCondition(new WhereCondition(notificationColumn.name(), operatorEnum, NotificationModels.ShowNotificationTypeEnum.NotMessage.name()), operatorEnum2, new WhereCondition(NotificationColumn.not_message_data_object_guid9.name(), operatorEnum, str)));
        HashSet hashSet = new HashSet();
        hashSet.add(NotificationColumn.notification_id1.name());
        return this.db.selectObject(TableName.notificationTable.name(), hashSet, whereCondition3, NotificationColumn.message_data_message_id8.name(), false, 200, new DBParser<String>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.33
            @Override // ir.aaap.messengercore.db.DBParser
            public String parse(CursorInterFace cursorInterFace) {
                return cursorInterFace.getString(NotificationColumn.notification_id1.name());
            }
        });
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public ArrayList<String> getNotificationToMessageId(String str, long j) {
        if (str == null) {
            return new ArrayList<>();
        }
        String strName = NotificationColumn.type2.name();
        WhereCondition.OperatorEnum operatorEnum = WhereCondition.OperatorEnum.EQ;
        WhereCondition whereCondition = new WhereCondition(strName, operatorEnum, NotificationModels.ShowNotificationTypeEnum.Message.name());
        WhereCondition whereCondition2 = new WhereCondition(NotificationColumn.message_data_object_guid6.name(), operatorEnum, str);
        NotificationColumn notificationColumn = NotificationColumn.message_data_message_id8;
        WhereCondition whereCondition3 = new WhereCondition(notificationColumn.name(), WhereCondition.OperatorEnum.LTE, String.valueOf(j));
        WhereCondition.OperatorEnum operatorEnum2 = WhereCondition.OperatorEnum.And;
        WhereCondition whereCondition4 = new WhereCondition(new WhereCondition(whereCondition, operatorEnum2, whereCondition2), operatorEnum2, whereCondition3);
        HashSet hashSet = new HashSet();
        hashSet.add(NotificationColumn.notification_id1.name());
        return this.db.selectObject(TableName.notificationTable.name(), hashSet, whereCondition4, notificationColumn.name(), false, 200, new DBParser<String>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.34
            @Override // ir.aaap.messengercore.db.DBParser
            public String parse(CursorInterFace cursorInterFace) {
                return cursorInterFace.getString(NotificationColumn.notification_id1.name());
            }
        });
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public ArrayList<String> getNotificationIDToMessageIdOrTime(String str, ChatType chatType, long j, long j2) {
        if (str == null) {
            return null;
        }
        NotificationColumn notificationColumn = NotificationColumn.type2;
        String strName = notificationColumn.name();
        WhereCondition.OperatorEnum operatorEnum = WhereCondition.OperatorEnum.EQ;
        WhereCondition whereCondition = new WhereCondition(strName, operatorEnum, NotificationModels.ShowNotificationTypeEnum.Message.name());
        WhereCondition whereCondition2 = new WhereCondition(NotificationColumn.message_data_object_guid6.name(), operatorEnum, str);
        WhereCondition.OperatorEnum operatorEnum2 = WhereCondition.OperatorEnum.And;
        WhereCondition whereCondition3 = new WhereCondition(whereCondition, operatorEnum2, whereCondition2);
        if (chatType != null) {
            whereCondition3 = new WhereCondition(whereCondition3, operatorEnum2, new WhereCondition(NotificationColumn.message_data_object_type7.name(), operatorEnum, chatType.name()));
        }
        NotificationColumn notificationColumn2 = NotificationColumn.message_data_message_id8;
        String strName2 = notificationColumn2.name();
        WhereCondition.OperatorEnum operatorEnum3 = WhereCondition.OperatorEnum.LTE;
        WhereCondition whereCondition4 = new WhereCondition(whereCondition3, operatorEnum2, new WhereCondition(strName2, operatorEnum3, String.valueOf(j)));
        WhereCondition whereCondition5 = new WhereCondition(new WhereCondition(notificationColumn.name(), operatorEnum, NotificationModels.ShowNotificationTypeEnum.NotMessage.name()), operatorEnum2, new WhereCondition(NotificationColumn.not_message_data_object_guid9.name(), operatorEnum, str));
        if (chatType != null) {
            whereCondition5 = new WhereCondition(whereCondition5, operatorEnum2, new WhereCondition(NotificationColumn.not_message_data_object_type10.name(), operatorEnum, chatType.name()));
        }
        WhereCondition whereCondition6 = new WhereCondition(whereCondition4, WhereCondition.OperatorEnum.Or, new WhereCondition(whereCondition5, operatorEnum2, new WhereCondition(NotificationColumn.not_message_data_time11.name(), operatorEnum3, String.valueOf(j2))));
        HashSet hashSet = new HashSet();
        hashSet.add(NotificationColumn.notification_id1.name());
        return this.db.selectObject(TableName.notificationTable.name(), hashSet, whereCondition6, notificationColumn2.name(), false, 200, new DBParser<String>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.35
            @Override // ir.aaap.messengercore.db.DBParser
            public String parse(CursorInterFace cursorInterFace) {
                return cursorInterFace.getString(NotificationColumn.notification_id1.name());
            }
        });
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void setNotificationReadByGuid(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        String strName = NotificationColumn.message_data_object_guid6.name();
        WhereCondition.OperatorEnum operatorEnum = WhereCondition.OperatorEnum.EQ;
        this.db.updateTable(TableName.notificationTable.name(), new String[]{NotificationColumn.is_read12.name()}, new String[]{"1"}, new WhereCondition(new WhereCondition(strName, operatorEnum, str), WhereCondition.OperatorEnum.Or, new WhereCondition(NotificationColumn.not_message_data_object_guid9.name(), operatorEnum, str)));
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void setAllNotificationsRead() {
        this.db.updateTable(TableName.notificationTable.name(), new String[]{NotificationColumn.is_read12.name()}, new String[]{"1"}, (WhereCondition) null);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public ArrayList<UserInfo> getAllUserInfoObject(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        return this.db.selectObject(TableName.userTable.name(), null, new WhereCondition(UserColumn.user_guid1.name(), WhereCondition.OperatorEnum.In, arrayList), null, false, 0, new DBParser<UserInfo>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.36
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // ir.aaap.messengercore.db.DBParser
            public UserInfo parse(CursorInterFace cursorInterFace) {
                return DBHelperImpl.this.parseUserInfoObject(cursorInterFace);
            }
        });
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public ArrayList<String> getAllContacts() {
        return this.db.selectObject(TableName.contactTable.name(), null, null, ContactColumn.online_time_exact_time19.name(), false, 2500, new DBParser<String>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.37
            @Override // ir.aaap.messengercore.db.DBParser
            public String parse(CursorInterFace cursorInterFace) {
                return DBHelperImpl.this.parseContactObject(cursorInterFace);
            }
        });
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public ArrayList<String> getRecentContacts() {
        ContactColumn contactColumn = ContactColumn.online_time_type18;
        String strName = contactColumn.name();
        WhereCondition.OperatorEnum operatorEnum = WhereCondition.OperatorEnum.EQ;
        return this.db.selectObject(TableName.contactTable.name(), null, new WhereCondition(new WhereCondition(strName, operatorEnum, OnlineTimeObject.Type.Exact.name()), WhereCondition.OperatorEnum.Or, new WhereCondition(new WhereCondition(contactColumn.name(), operatorEnum, OnlineTimeObject.Type.Approximate.name()), WhereCondition.OperatorEnum.And, new WhereCondition(ContactColumn.online_time_approximate_period20.name(), operatorEnum, OnlineTimeObject.ApproximatePeriodEnum.Recently.name()))), ContactColumn.online_time_exact_time19.name(), false, 2500, new DBParser<String>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.38
            @Override // ir.aaap.messengercore.db.DBParser
            public String parse(CursorInterFace cursorInterFace) {
                return DBHelperImpl.this.parseContactObject(cursorInterFace);
            }
        });
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public Map<String, PhoneBookObject> getAllPhoneBook() {
        HashMap map = new HashMap();
        Iterator it = this.db.selectObject(TableName.phoneBookTable.name(), null, null, null, false, 0, new DBParser<PhoneBookObject>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.39
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // ir.aaap.messengercore.db.DBParser
            public PhoneBookObject parse(CursorInterFace cursorInterFace) {
                return DBHelperImpl.this.parsePhoneBookObject(cursorInterFace);
            }
        }).iterator();
        while (it.hasNext()) {
            PhoneBookObject phoneBookObject = (PhoneBookObject) it.next();
            map.put(phoneBookObject.phone, phoneBookObject);
        }
        return map;
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public Map<String, PhoneBookObject> getAllPhoneBook(ArrayList<String> arrayList) {
        WhereCondition whereCondition = new WhereCondition(PhoneBookColumn.phone.name(), WhereCondition.OperatorEnum.In, arrayList);
        HashMap map = new HashMap();
        Iterator it = this.db.selectObject(TableName.phoneBookTable.name(), null, whereCondition, null, false, 0, new DBParser<PhoneBookObject>() { // from class: ir.aaap.messengercore.db.DBHelperImpl.40
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // ir.aaap.messengercore.db.DBParser
            public PhoneBookObject parse(CursorInterFace cursorInterFace) {
                return DBHelperImpl.this.parsePhoneBookObject(cursorInterFace);
            }
        }).iterator();
        while (it.hasNext()) {
            PhoneBookObject phoneBookObject = (PhoneBookObject) it.next();
            map.put(phoneBookObject.phone, phoneBookObject);
        }
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0030  */
    @Override // ir.aaap.messengercore.db.DBHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void addAllMessagesAndFillHoles(java.lang.String r11, java.util.ArrayList<ir.aaap.messengercore.model.Message> r12, long r13, long r15, ir.aaap.messengercore.MessageUtils.FilterTypeEnum r17, long r18, long r20) {
        /*
            r10 = this;
            r9 = r10
            r1 = r11
            r0 = r12
            r2 = r18
            r10.addAllMessages(r11, r12, r2)
            r2 = 9223372036854775797(0x7ffffffffffffff5, double:NaN)
            int r4 = (r15 > r2 ? 1 : (r15 == r2 ? 0 : -1))
            if (r4 < 0) goto L30
            java.util.Iterator r0 = r12.iterator()
            r2 = 0
            r4 = r2
        L18:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L2b
            java.lang.Object r6 = r0.next()
            ir.aaap.messengercore.model.Message r6 = (ir.aaap.messengercore.model.Message) r6
            long r6 = r6.message_id
            long r4 = java.lang.Math.max(r6, r4)
            goto L18
        L2b:
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 <= 0) goto L30
            goto L31
        L30:
            r4 = r15
        L31:
            r0 = r10
            r1 = r11
            r2 = r13
            r6 = r17
            r7 = r20
            r0.fillHole(r1, r2, r4, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.aaap.messengercore.db.DBHelperImpl.addAllMessagesAndFillHoles(java.lang.String, java.util.ArrayList, long, long, ir.aaap.messengercore.MessageUtils$FilterTypeEnum, long, long):void");
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void removeLocalMessageByRnd(String str, long j) {
        String strName = MessageColumn.object_guid1.name();
        WhereCondition.OperatorEnum operatorEnum = WhereCondition.OperatorEnum.EQ;
        this.db.removeObject(TableName.messageTable.name(), new WhereCondition(new WhereCondition(strName, operatorEnum, str), WhereCondition.OperatorEnum.And, new WhereCondition(MessageColumn.message_id2.name(), operatorEnum, j + BuildConfig.FLAVOR)));
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void removeRecentChat(String str) {
        this.db.removeObject(TableName.recentChatTable.name(), new WhereCondition(RecentChatColumn.guid1.name(), WhereCondition.OperatorEnum.EQ, str));
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void removeHole(String str, MessageHoleObject messageHoleObject) {
        if (messageHoleObject == null) {
            return;
        }
        String strName = MessageHoleColumn.guid1.name();
        WhereCondition.OperatorEnum operatorEnum = WhereCondition.OperatorEnum.EQ;
        WhereCondition whereCondition = new WhereCondition(strName, operatorEnum, str);
        WhereCondition whereCondition2 = new WhereCondition(MessageHoleColumn.start2.name(), operatorEnum, messageHoleObject.start + BuildConfig.FLAVOR);
        WhereCondition whereCondition3 = new WhereCondition(MessageHoleColumn.end3.name(), operatorEnum, messageHoleObject.end + BuildConfig.FLAVOR);
        WhereCondition.OperatorEnum operatorEnum2 = WhereCondition.OperatorEnum.And;
        WhereCondition whereCondition4 = new WhereCondition(new WhereCondition(whereCondition, operatorEnum2, whereCondition2), operatorEnum2, whereCondition3);
        if (messageHoleObject.type == null) {
            messageHoleObject.type = MessageUtils.FilterTypeEnum.All;
        }
        this.db.removeObject(TableName.messageHoleTable.name(), new WhereCondition(whereCondition4, operatorEnum2, new WhereCondition(MessageHoleColumn.type4.name(), operatorEnum, messageHoleObject.type + BuildConfig.FLAVOR)));
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void removeAllFolders() {
        this.db.removeObject(TableName.folderTable.name(), null);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void removeAllFolders(ArrayList<String> arrayList) {
        this.db.removeObject(TableName.folderTable.name(), new WhereCondition(FolderColumn.folder_id1.name(), WhereCondition.OperatorEnum.In, arrayList));
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void removeAllNotifications(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        this.db.removeObject(TableName.notificationTable.name(), new WhereCondition(NotificationColumn.notification_id1.name(), WhereCondition.OperatorEnum.In, arrayList));
    }

    public void removeAllHoles(String str) {
        this.db.removeObject(TableName.messageHoleTable.name(), new WhereCondition(MessageHoleColumn.guid1.name(), WhereCondition.OperatorEnum.EQ, str));
    }

    public void removeAllHoles(ArrayList<String> arrayList) {
        this.db.removeObject(TableName.messageHoleTable.name(), new WhereCondition(MessageHoleColumn.guid1.name(), WhereCondition.OperatorEnum.In, arrayList));
    }

    public void removeAllHoles() {
        this.db.removeObject(TableName.messageHoleTable.name(), null);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void removeAllChats() {
        this.db.removeObject(TableName.chatTable.name(), null);
        removeAllChatExtra();
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void removeAllChatExtra() {
        this.db.removeObject(TableName.chatExtraTable.name(), null);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void removeChatExtra(String str) {
        this.db.removeObject(TableName.chatExtraTable.name(), new WhereCondition(ChatExtraColumn.object_guid1.name(), WhereCondition.OperatorEnum.EQ, str));
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void removeChatExtra(ArrayList<String> arrayList) {
        this.db.removeObject(TableName.chatExtraTable.name(), new WhereCondition(ChatExtraColumn.object_guid1.name(), WhereCondition.OperatorEnum.In, arrayList));
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void removeAllAbs() {
        this.db.removeObject(TableName.absTable.name(), null);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void removeAllNotLocalMessagesAndHoles(String str) {
        this.db.removeObject(TableName.messageTable.name(), new WhereCondition(new WhereCondition(MessageColumn.object_guid1.name(), WhereCondition.OperatorEnum.EQ, str), WhereCondition.OperatorEnum.And, new WhereCondition(MessageColumn.message_id2.name(), WhereCondition.OperatorEnum.GTE, "0")));
        removeAllHoles(str);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void removeAllMessagesAndHoles(String str) {
        this.db.removeObject(TableName.messageTable.name(), new WhereCondition(MessageColumn.object_guid1.name(), WhereCondition.OperatorEnum.EQ, str));
        removeAllHoles(str);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void removeAllMessagesAndHoles(ArrayList<String> arrayList) {
        this.db.removeObject(TableName.messageTable.name(), new WhereCondition(MessageColumn.object_guid1.name(), WhereCondition.OperatorEnum.In, arrayList));
        removeAllHoles(arrayList);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void removeChats(ArrayList<String> arrayList) {
        this.db.removeObject(TableName.chatTable.name(), new WhereCondition(ChatColumn.object_guid1.name(), WhereCondition.OperatorEnum.In, arrayList));
        removeChatExtra(arrayList);
    }

    public void removeAllMessages() {
        this.db.removeObject(TableName.messageTable.name(), null);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void fillHole(String str, long j, long j2, MessageUtils.FilterTypeEnum filterTypeEnum, long j3) {
        this.coreLog.e("DBHelperImpl", "fill hole " + j + " " + j2);
        long j4 = j == 0 ? 1L : j;
        long j5 = j2 != 0 ? j2 : 1L;
        if (j3 > 0 && j5 > j3) {
            this.coreLog.e("DBHelperImpl", "fill hole problem !!!!!!!!!!!!!! " + j3 + " " + j5);
            j5 = j3;
        }
        if (j5 >= 9223372036854775797L) {
            return;
        }
        initHoleTableIfNeeded(str, filterTypeEnum);
        ArrayList<MessageHoleObject> holesOverlapsMinAndMax = getHolesOverlapsMinAndMax(str, j4, j5, filterTypeEnum);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.addAll(holesOverlapsMinAndMax);
        Iterator<MessageHoleObject> it = holesOverlapsMinAndMax.iterator();
        while (it.hasNext()) {
            MessageHoleObject next = it.next();
            if (!isHoleBetweenMinAndMax(next, j4, j5)) {
                arrayList2.addAll(breakHole(next, j4, j5));
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            removeHole(str, (MessageHoleObject) it2.next());
        }
        addAllHoles(str, arrayList2);
    }

    public ArrayList<MessageHoleObject> breakHole(MessageHoleObject messageHoleObject, long j, long j2) {
        ArrayList<MessageHoleObject> arrayList = new ArrayList<>();
        long j3 = messageHoleObject.start;
        if (j3 < j && messageHoleObject.end >= j) {
            MessageHoleObject messageHoleObject2 = new MessageHoleObject();
            messageHoleObject2.start = messageHoleObject.start;
            messageHoleObject2.end = j - 1;
            messageHoleObject2.type = messageHoleObject.type;
            arrayList.add(messageHoleObject2);
            if (messageHoleObject.end > j2) {
                MessageHoleObject messageHoleObject3 = new MessageHoleObject();
                messageHoleObject3.start = j2 + 1;
                messageHoleObject3.end = messageHoleObject.end;
                messageHoleObject3.type = messageHoleObject.type;
                arrayList.add(messageHoleObject3);
            }
        } else if (j3 <= j2) {
            MessageHoleObject messageHoleObject4 = new MessageHoleObject();
            messageHoleObject4.start = j2 + 1;
            messageHoleObject4.end = messageHoleObject.end;
            messageHoleObject4.type = messageHoleObject.type;
            arrayList.add(messageHoleObject4);
        }
        return arrayList;
    }

    public void initHoleTableIfNeeded(String str, MessageUtils.FilterTypeEnum filterTypeEnum) {
        if (getHolesOfChatCount(str, filterTypeEnum) <= 0) {
            MessageHoleObject messageHoleObject = new MessageHoleObject();
            messageHoleObject.start = 1L;
            messageHoleObject.end = 9223372036854775797L;
            messageHoleObject.type = filterTypeEnum;
            addHole(str, messageHoleObject);
        }
    }

    private boolean isHoleBetweenMinAndMax(MessageHoleObject messageHoleObject, long j, long j2) {
        return messageHoleObject.start >= j && messageHoleObject.end <= j2;
    }

    public int getHolesOfChatCount(String str, MessageUtils.FilterTypeEnum filterTypeEnum) {
        String strName = MessageHoleColumn.guid1.name();
        WhereCondition.OperatorEnum operatorEnum = WhereCondition.OperatorEnum.EQ;
        WhereCondition whereCondition = new WhereCondition(strName, operatorEnum, str);
        if (filterTypeEnum == null) {
            filterTypeEnum = MessageUtils.FilterTypeEnum.All;
        }
        return this.db.count(TableName.messageHoleTable.name(), null, new WhereCondition(whereCondition, WhereCondition.OperatorEnum.And, new WhereCondition(MessageHoleColumn.type4.name(), operatorEnum, filterTypeEnum + BuildConfig.FLAVOR)));
    }

    public long getMaxHoleEndAboveMaxId(String str, long j, MessageUtils.FilterTypeEnum filterTypeEnum) {
        String strName = MessageHoleColumn.guid1.name();
        WhereCondition.OperatorEnum operatorEnum = WhereCondition.OperatorEnum.EQ;
        WhereCondition whereCondition = new WhereCondition(strName, operatorEnum, str);
        WhereCondition whereCondition2 = new WhereCondition(MessageHoleColumn.start2.name(), WhereCondition.OperatorEnum.LTE, j + BuildConfig.FLAVOR);
        WhereCondition.OperatorEnum operatorEnum2 = WhereCondition.OperatorEnum.And;
        WhereCondition whereCondition3 = new WhereCondition(whereCondition, operatorEnum2, whereCondition2);
        if (filterTypeEnum == null) {
            filterTypeEnum = MessageUtils.FilterTypeEnum.All;
        }
        WhereCondition whereCondition4 = new WhereCondition(whereCondition3, operatorEnum2, new WhereCondition(MessageHoleColumn.type4.name(), operatorEnum, filterTypeEnum + BuildConfig.FLAVOR));
        return this.db.max(TableName.messageHoleTable.name(), MessageHoleColumn.end3 + BuildConfig.FLAVOR, whereCondition4);
    }

    private long getAbsMaxLocalId(String str, MessageUtils.FilterTypeEnum filterTypeEnum) {
        WhereCondition filterTypeCondition;
        WhereCondition whereCondition = new WhereCondition(MessageColumn.object_guid1.name(), WhereCondition.OperatorEnum.EQ, str);
        MessageColumn messageColumn = MessageColumn.message_id2;
        WhereCondition whereCondition2 = new WhereCondition(messageColumn.name(), WhereCondition.OperatorEnum.LT, "0");
        WhereCondition.OperatorEnum operatorEnum = WhereCondition.OperatorEnum.And;
        WhereCondition whereCondition3 = new WhereCondition(whereCondition, operatorEnum, whereCondition2);
        if (filterTypeEnum != null && (filterTypeCondition = getFilterTypeCondition(filterTypeEnum)) != null) {
            whereCondition3 = new WhereCondition(whereCondition3, operatorEnum, filterTypeCondition);
        }
        return Math.abs(this.db.min(TableName.messageTable.name(), messageColumn.name(), whereCondition3));
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public Message getLastLocalMessage(String str, MessageUtils.FilterTypeEnum filterTypeEnum) {
        long absMaxLocalId = getAbsMaxLocalId(str, filterTypeEnum);
        if (absMaxLocalId != 0) {
            return getMessageById(str, absMaxLocalId * (-1));
        }
        return null;
    }

    private long getAbsMinLocalId(String str, MessageUtils.FilterTypeEnum filterTypeEnum) {
        WhereCondition filterTypeCondition;
        WhereCondition whereCondition = new WhereCondition(MessageColumn.object_guid1.name(), WhereCondition.OperatorEnum.EQ, str);
        MessageColumn messageColumn = MessageColumn.message_id2;
        WhereCondition whereCondition2 = new WhereCondition(messageColumn.name(), WhereCondition.OperatorEnum.LT, "0");
        WhereCondition.OperatorEnum operatorEnum = WhereCondition.OperatorEnum.And;
        WhereCondition whereCondition3 = new WhereCondition(whereCondition, operatorEnum, whereCondition2);
        if (filterTypeEnum != null && (filterTypeCondition = getFilterTypeCondition(filterTypeEnum)) != null) {
            whereCondition3 = new WhereCondition(whereCondition3, operatorEnum, filterTypeCondition);
        }
        return Math.abs(this.db.max(TableName.messageTable.name(), messageColumn.name(), whereCondition3));
    }

    public long getMinHoleStartBelowMinId(String str, long j, MessageUtils.FilterTypeEnum filterTypeEnum) {
        String strName = MessageHoleColumn.guid1.name();
        WhereCondition.OperatorEnum operatorEnum = WhereCondition.OperatorEnum.EQ;
        WhereCondition whereCondition = new WhereCondition(strName, operatorEnum, str);
        WhereCondition whereCondition2 = new WhereCondition(MessageHoleColumn.end3.name(), WhereCondition.OperatorEnum.GTE, j + BuildConfig.FLAVOR);
        WhereCondition.OperatorEnum operatorEnum2 = WhereCondition.OperatorEnum.And;
        WhereCondition whereCondition3 = new WhereCondition(whereCondition, operatorEnum2, whereCondition2);
        if (filterTypeEnum == null) {
            filterTypeEnum = MessageUtils.FilterTypeEnum.All;
        }
        return this.db.min(TableName.messageHoleTable.name(), MessageHoleColumn.start2.name(), new WhereCondition(whereCondition3, operatorEnum2, new WhereCondition(MessageHoleColumn.type4 + BuildConfig.FLAVOR, operatorEnum, filterTypeEnum + BuildConfig.FLAVOR)));
    }

    public long getHoleCountContainsId(String str, long j, MessageUtils.FilterTypeEnum filterTypeEnum) {
        WhereCondition whereCondition = new WhereCondition(MessageHoleColumn.guid1.name(), WhereCondition.OperatorEnum.EQ, str);
        WhereCondition whereCondition2 = new WhereCondition(MessageHoleColumn.start2.name(), WhereCondition.OperatorEnum.LTE, j + BuildConfig.FLAVOR);
        WhereCondition whereCondition3 = new WhereCondition(MessageHoleColumn.end3.name(), WhereCondition.OperatorEnum.GTE, j + BuildConfig.FLAVOR);
        WhereCondition.OperatorEnum operatorEnum = WhereCondition.OperatorEnum.And;
        WhereCondition whereCondition4 = new WhereCondition(new WhereCondition(whereCondition, operatorEnum, whereCondition2), operatorEnum, whereCondition3);
        if (filterTypeEnum == null) {
            filterTypeEnum = MessageUtils.FilterTypeEnum.All;
        }
        String strName = MessageHoleColumn.type4.name();
        return this.db.count(TableName.messageHoleTable.name(), null, new WhereCondition(whereCondition4, operatorEnum, new WhereCondition(strName, r2, filterTypeEnum + BuildConfig.FLAVOR)));
    }

    public boolean isAnyHolesInDB(String str, MessageUtils.FilterTypeEnum filterTypeEnum) {
        return getHolesOfChatCount(str, filterTypeEnum) > 0;
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public boolean isMessageIdInDb(String str, MessageUtils.FilterTypeEnum filterTypeEnum, long j) {
        return !isIdInHole(str, filterTypeEnum, j);
    }

    public boolean isIdInHole(String str, MessageUtils.FilterTypeEnum filterTypeEnum, long j) {
        if (j == 0) {
            j = 1;
        }
        if (filterTypeEnum == null) {
            filterTypeEnum = MessageUtils.FilterTypeEnum.All;
        }
        return !isAnyHolesInDB(str, filterTypeEnum) || getHoleCountContainsId(str, j, filterTypeEnum) > 0;
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void setMessageDeleted(String str, long j, long j2) {
        String[] messageColumnArray = getMessageColumnArray();
        String[] strArr = new String[messageColumnArray.length];
        strArr[MessageColumn.object_guid1.ordinal()] = str;
        strArr[MessageColumn.message_id2.ordinal()] = j + BuildConfig.FLAVOR;
        strArr[MessageColumn.timeStamp67.ordinal()] = j2 + BuildConfig.FLAVOR;
        strArr[MessageColumn.isDeleted66.ordinal()] = "1";
        this.db.insertToTable(TableName.messageTable.name(), messageColumnArray, strArr);
    }

    public ChatAbsObject parseAbsObject(CursorInterFace cursorInterFace) {
        ChatAbsObject chatAbsObject = new ChatAbsObject();
        if (cursorInterFace == null) {
            return chatAbsObject;
        }
        chatAbsObject.object_guid = cursorInterFace.getString(AbsColumn.guid1.name());
        try {
            chatAbsObject.type = ChatType.valueOf(cursorInterFace.getString(AbsColumn.type2.name()));
        } catch (Exception unused) {
        }
        chatAbsObject.title = cursorInterFace.getString(AbsColumn.title3.name());
        long j = cursorInterFace.getLong(AbsColumn.avatar_thumbnail_file_id4.name());
        if (j != 0) {
            AvatarFileInline avatarFileInline = new AvatarFileInline();
            avatarFileInline.file_id = j;
            avatarFileInline.access_hash_rec = cursorInterFace.getString(AbsColumn.avatar_thumbnail_access_hash5.name());
            avatarFileInline.dc_id = cursorInterFace.getString(AbsColumn.avatar_thumbnail_dc_id6.name());
            chatAbsObject.avatar_thumbnail = avatarFileInline;
        }
        chatAbsObject.first_name = cursorInterFace.getString(AbsColumn.first_name7.name());
        chatAbsObject.last_name = cursorInterFace.getString(AbsColumn.last_name8.name());
        chatAbsObject.is_deleted = cursorInterFace.getInt(AbsColumn.is_deleted9.name()) == 1;
        chatAbsObject.is_verified = cursorInterFace.getInt(AbsColumn.is_verified10.name()) == 1;
        chatAbsObject.timeStamp = cursorInterFace.getLong(AbsColumn.updated_time11.name());
        return chatAbsObject;
    }

    public String parseContactObject(CursorInterFace cursorInterFace) {
        return cursorInterFace.getString(ContactColumn.user_guid1.name());
    }

    public String parseChatHint(CursorInterFace cursorInterFace) {
        return cursorInterFace.getString(ChatHintColumn.guid1.name());
    }

    public InSearchObject parseRecentChat(CursorInterFace cursorInterFace) {
        InSearchObject inSearchObject = new InSearchObject();
        String string = cursorInterFace.getString(RecentChatColumn.data3.name());
        if (string == null) {
            return inSearchObject;
        }
        try {
            return (InSearchObject) this.jsonHelper.fromJson(string, InSearchObject.class);
        } catch (Exception e) {
            this.coreLog.handleException(e);
            return inSearchObject;
        }
    }

    public PhoneBookObject parsePhoneBookObject(CursorInterFace cursorInterFace) {
        String string = cursorInterFace.getString(PhoneBookColumn.phone.name());
        String string2 = cursorInterFace.getString(PhoneBookColumn.firstName.name());
        String string3 = cursorInterFace.getString(PhoneBookColumn.lastName.name());
        PhoneBookObject phoneBookObject = new PhoneBookObject();
        phoneBookObject.phone = string;
        phoneBookObject.first_name = string2;
        phoneBookObject.last_name = string3;
        return phoneBookObject;
    }

    public UserInfo parseUserInfoObject(CursorInterFace cursorInterFace) {
        UserInfo userInfo = new UserInfo();
        userInfo.user_guid = cursorInterFace.getString(UserColumn.user_guid1.name());
        userInfo.phone = cursorInterFace.getString(UserColumn.phone4.name());
        userInfo.username = cursorInterFace.getString(UserColumn.username5.name());
        userInfo.bio = cursorInterFace.getString(UserColumn.bio10.name());
        userInfo.count_common_groups = cursorInterFace.getLong(UserColumn.count_common_groups14.name());
        userInfo.can_receive_call = cursorInterFace.getInt(UserColumn.can_receive_call16.name()) == 1;
        userInfo.can_video_call = cursorInterFace.getInt(UserColumn.can_video_call17.name()) == 1;
        try {
            String string = cursorInterFace.getString(UserColumn.online_time_type18.name());
            if (string != null) {
                OnlineTimeObject onlineTimeObject = new OnlineTimeObject();
                userInfo.online_time = onlineTimeObject;
                onlineTimeObject.type = OnlineTimeObject.Type.valueOf(string);
                OnlineTimeObject onlineTimeObject2 = userInfo.online_time;
                OnlineTimeObject.Type type = onlineTimeObject2.type;
                if (type == OnlineTimeObject.Type.Exact) {
                    onlineTimeObject2.exact_time = cursorInterFace.getLong(UserColumn.online_time_exact_time19.name());
                } else if (type == OnlineTimeObject.Type.Approximate) {
                    onlineTimeObject2.approximate_period = OnlineTimeObject.ApproximatePeriodEnum.valueOf(cursorInterFace.getString(UserColumn.online_time_approximate_period20.name()));
                } else {
                    userInfo.online_time = null;
                }
            }
        } catch (Exception unused) {
            userInfo.online_time = null;
        }
        String string2 = cursorInterFace.getString(UserColumn.warning_info_json15.name());
        if (string2 != null) {
            try {
                if (!string2.isEmpty()) {
                    userInfo.warning_info = (WarningObject) this.jsonHelper.fromJson(string2, WarningObject.class);
                }
            } catch (Exception unused2) {
            }
        }
        userInfo.timeStamp = cursorInterFace.getLong(UserColumn.timeStamp21.name());
        userInfo.insertedToDbTime = cursorInterFace.getLong(UserColumn.insertedTime22.name());
        return userInfo;
    }

    /* renamed from: parseChatObject, reason: merged with bridge method [inline-methods] */
    public Chat lambda$getAllChats$0(CursorInterFace cursorInterFace) {
        Chat chat = new Chat();
        if (cursorInterFace == null) {
            return chat;
        }
        String string = cursorInterFace.getString(ChatColumn.object_guid1.name());
        chat.object_guid = string;
        if (string == null) {
            chat.object_guid = BuildConfig.FLAVOR;
        }
        try {
            chat.access = new HashSet<>(Arrays.asList((Chat.ChatAccessEnum[]) this.jsonHelper.fromJson(cursorInterFace.getString(ChatColumn.access2.name()), Chat.ChatAccessEnum[].class)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        chat.count_unseen = cursorInterFace.getInt(ChatColumn.count_unseen3.name());
        chat.is_mute = cursorInterFace.getInt(ChatColumn.is_mute4.name()) == 1;
        chat.is_pinned = cursorInterFace.getInt(ChatColumn.is_pinned5.name()) == 1;
        chat.time_string = cursorInterFace.getString(ChatColumn.time_string6.name());
        long j = cursorInterFace.getLong(ChatColumn.last_message_message_id7.name());
        ChatMessage.ChatMessageTypeEnum chatMessageTypeEnumValueOf = null;
        try {
            chatMessageTypeEnumValueOf = ChatMessage.ChatMessageTypeEnum.valueOf(cursorInterFace.getString(ChatColumn.last_message_type8.name()));
        } catch (Exception unused) {
        }
        if (j != 0 || chatMessageTypeEnumValueOf != null) {
            ChatMessage chatMessage = new ChatMessage();
            chatMessage.message_id = j;
            try {
                chatMessage.type = chatMessageTypeEnumValueOf;
            } catch (Exception unused2) {
            }
            chatMessage.text = cursorInterFace.getString(ChatColumn.last_message_text9.name());
            chatMessage.author_object_guid = cursorInterFace.getString(ChatColumn.last_message_author_object_guid10.name());
            try {
                chatMessage.author_type = Message.AuthorTypeEnum.valueOf(cursorInterFace.getString(ChatColumn.last_message_author_type11.name()));
            } catch (Exception unused3) {
            }
            chatMessage.is_mine = cursorInterFace.getInt(ChatColumn.last_message_is_mine12.name()) == 1;
            chatMessage.author_title = cursorInterFace.getString(ChatColumn.last_message_author_title13.name());
            String string2 = cursorInterFace.getString(ChatColumn.last_message_metadata_json38.name());
            if (string2 != null) {
                try {
                    chatMessage.metadata = (MetaDataObject) this.jsonHelper.fromJson(string2, MetaDataObject.class);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            chat.last_message = chatMessage;
        }
        chat.last_seen_my_mid = cursorInterFace.getLong(ChatColumn.last_seen_my_mid14.name());
        chat.last_seen_peer_mid = cursorInterFace.getLong(ChatColumn.last_seen_peer_mid15.name());
        try {
            chat.status = Chat.ChatStatusEnum.valueOf(cursorInterFace.getString(ChatColumn.status16.name()));
        } catch (Exception unused4) {
        }
        String string3 = cursorInterFace.getString(ChatColumn.absObject_object_guid17.name());
        if (string3 != null && !string3.isEmpty()) {
            ChatAbsObject chatAbsObject = new ChatAbsObject();
            chatAbsObject.object_guid = string3;
            chatAbsObject.title = cursorInterFace.getString(ChatColumn.absObject_title18.name());
            chatAbsObject.first_name = cursorInterFace.getString(ChatColumn.absObject_first_name19.name());
            chatAbsObject.last_name = cursorInterFace.getString(ChatColumn.absObject_last_name20.name());
            long j2 = cursorInterFace.getLong(ChatColumn.avatar_thumbnail_file_id21.name());
            if (j2 != 0) {
                AvatarFileInline avatarFileInline = new AvatarFileInline();
                avatarFileInline.file_id = j2;
                avatarFileInline.dc_id = cursorInterFace.getString(ChatColumn.avatar_thumbnail_dc_id22.name());
                avatarFileInline.access_hash_rec = cursorInterFace.getString(ChatColumn.avatar_thumbnail_access_hash_rec23.name());
                chatAbsObject.avatar_thumbnail = avatarFileInline;
            }
            try {
                chatAbsObject.type = ChatType.valueOf(cursorInterFace.getString(ChatColumn.absObject_type24.name()));
            } catch (Exception unused5) {
            }
            chatAbsObject.is_verified = cursorInterFace.getInt(ChatColumn.absObject_is_verified25.name()) == 1;
            chatAbsObject.is_deleted = cursorInterFace.getInt(ChatColumn.absObject_is_deleted26.name()) == 1;
        }
        chat.time = cursorInterFace.getLong(ChatColumn.time27.name());
        chat.pinned_message_id = cursorInterFace.getLong(ChatColumn.pinned_message_id28.name());
        String string4 = cursorInterFace.getString(ChatColumn.pinned_message_ids37.name());
        if (string4 != null && !string4.isEmpty()) {
            try {
                chat.pinned_message_ids = new ArrayList<>(Arrays.asList((Long[]) this.jsonHelper.fromJson(string4, Long[].class)));
            } catch (Exception unused6) {
            }
        }
        chat.is_blocked = cursorInterFace.getInt(ChatColumn.is_blocked29.name()) == 1;
        chat.last_message_id = cursorInterFace.getLong(ChatColumn.last_message_id30.name());
        chat.last_deleted_mid = cursorInterFace.getLong(ChatColumn.last_deleted_mid31.name());
        String string5 = cursorInterFace.getString(ChatColumn.chat_keypad_json_32.name());
        if (string5 != null && !string5.isEmpty()) {
            try {
                chat.chat_keypad = (KeyPadObject) this.jsonHelper.fromJson(string5, KeyPadObject.class);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        chat.slow_mode_duration = cursorInterFace.getInt(ChatColumn.slow_mode_duration35.name());
        chat.group_my_last_send_time = cursorInterFace.getInt(ChatColumn.group_my_last_send_time36.name());
        chat.is_in_contact = cursorInterFace.getInt(ChatColumn.is_in_contact34.name()) == 1;
        chat.group_voice_chat_id = cursorInterFace.getString(ChatColumn.group_voice_chat_id68.name());
        chat.show_ask_spam = cursorInterFace.getInt(ChatColumn.show_ask_spam69.name()) == 1;
        chat.fillAttributes();
        return chat;
    }

    public ChatExtra parseChatExtraObject(CursorInterFace cursorInterFace) {
        ChatExtra chatExtra = new ChatExtra(cursorInterFace.getString(ChatExtraColumn.object_guid1.name()));
        long j = cursorInterFace.getLong(ChatExtraColumn.local_last_message_message_id2.name());
        if (j != 0) {
            ChatMessage chatMessage = new ChatMessage();
            chatMessage.message_id = j;
            try {
                chatMessage.type = ChatMessage.ChatMessageTypeEnum.valueOf(cursorInterFace.getString(ChatExtraColumn.local_last_message_type3.name()));
            } catch (Exception unused) {
            }
            chatMessage.text = cursorInterFace.getString(ChatExtraColumn.local_last_message_text4.name());
            chatMessage.author_object_guid = cursorInterFace.getString(ChatExtraColumn.local_last_message_author_object_guid5.name());
            try {
                chatMessage.author_type = Message.AuthorTypeEnum.valueOf(cursorInterFace.getString(ChatExtraColumn.local_last_message_author_type6.name()));
            } catch (Exception unused2) {
            }
            chatMessage.is_mine = cursorInterFace.getInt(ChatExtraColumn.local_last_message_is_mine7.name()) == 1;
            chatMessage.author_title = cursorInterFace.getString(ChatExtraColumn.local_last_message_author_title8.name());
            String string = cursorInterFace.getString(ChatExtraColumn.local_last_message_metadata_json13.name());
            if (string != null) {
                try {
                    chatMessage.metadata = (MetaDataObject) this.jsonHelper.fromJson(string, MetaDataObject.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            chatExtra.local_last_message = chatMessage;
        }
        chatExtra.local_last_message_prev_message_id = cursorInterFace.getLong(ChatExtraColumn.local_last_message_prev_message_id9.name());
        chatExtra.local_last_seen_my_mid = cursorInterFace.getLong(ChatExtraColumn.local_last_seen_my_mid10.name());
        chatExtra.local_count_unseen = cursorInterFace.getInt(ChatExtraColumn.local_count_unseen11.name());
        chatExtra.local_time = cursorInterFace.getLong(ChatExtraColumn.local_time12.name());
        chatExtra.local_last_message_send_state = cursorInterFace.getInt(ChatExtraColumn.local_last_message_send_state13.name());
        return chatExtra;
    }

    /* renamed from: parseMessageObject, reason: merged with bridge method [inline-methods] */
    public Message lambda$getMessagesWithFileInline$1(CursorInterFace cursorInterFace) {
        String string;
        String string2;
        String string3;
        String string4;
        Message.LocalParametersObject localParametersObject;
        Message message = new Message();
        if (cursorInterFace == null) {
            return message;
        }
        message.message_id = cursorInterFace.getLong(MessageColumn.message_id2.name());
        boolean z = cursorInterFace.getInt(MessageColumn.isLocallyEdited72.name()) == 1;
        message.isLocallyEdited = z;
        if (message.message_id < 0 || z) {
            try {
                message.localParametersObject = (Message.LocalParametersObject) this.jsonHelper.fromJson(cursorInterFace.getString(MessageColumn.localParameters69.name()), Message.LocalParametersObject.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            message.sendState = cursorInterFace.getInt(MessageColumn.sendState71.name());
        }
        message.author_object_guid = cursorInterFace.getString(MessageColumn.author_object_guid3.name());
        try {
            message.author_type = Message.AuthorTypeEnum.valueOf(cursorInterFace.getString(MessageColumn.author_type4.name()));
        } catch (Exception unused) {
            message.author_type = null;
        }
        message.text = cursorInterFace.getString(MessageColumn.text5.name());
        long j = cursorInterFace.getLong(MessageColumn.file_inline_file_id6.name());
        if (j != 0 || (message.message_id < 0 && (localParametersObject = message.localParametersObject) != null && localParametersObject.attachPath != null)) {
            FileInlineObject fileInlineObject = new FileInlineObject();
            fileInlineObject.file_id = j;
            fileInlineObject.mime = cursorInterFace.getString(MessageColumn.file_inline_mime7.name());
            fileInlineObject.dc_id = cursorInterFace.getString(MessageColumn.file_inline_dc_id8.name());
            fileInlineObject.access_hash_rec = cursorInterFace.getString(MessageColumn.file_inline_access_hash_rec9.name());
            fileInlineObject.file_name = cursorInterFace.getString(MessageColumn.file_inline_file_name10.name());
            fileInlineObject.width = cursorInterFace.getInt(MessageColumn.file_inline_width11.name());
            fileInlineObject.height = cursorInterFace.getInt(MessageColumn.file_inline_height12.name());
            fileInlineObject.time = cursorInterFace.getInt(MessageColumn.file_inline_time13.name());
            fileInlineObject.size = cursorInterFace.getLong(MessageColumn.file_inline_size14.name());
            fileInlineObject.local_attach_path = cursorInterFace.getString(MessageColumn.local_attached_path36.name());
            fileInlineObject.local_attach_path_orginal = cursorInterFace.getString(MessageColumn.local_attached_path_orginal37.name());
            fileInlineObject.thumb_inline = cursorInterFace.getString(MessageColumn.file_inline_thumb_inline45.name());
            fileInlineObject.music_performer = cursorInterFace.getString(MessageColumn.file_inline_performer46.name());
            fileInlineObject.is_round = cursorInterFace.getInt(MessageColumn.file_inline_is_round75.name()) == 1;
            fileInlineObject.cdn_tag = cursorInterFace.getString(MessageColumn.file_inline_cdn_tag82.name());
            try {
                fileInlineObject.type = FileInlineObject.FileInlineType.valueOf(cursorInterFace.getString(MessageColumn.file_inline_type15.name()));
            } catch (Exception unused2) {
                fileInlineObject.type = null;
            }
            fileInlineObject.auto_play = cursorInterFace.getInt(MessageColumn.file_inline_auto_play16.name()) == 1;
            message.file_inline = fileInlineObject;
        }
        message.reply_to_message_id = cursorInterFace.getLong(MessageColumn.reply_to_message_id17.name());
        message.time = cursorInterFace.getLong(MessageColumn.time18.name());
        message.count_seen = cursorInterFace.getInt(MessageColumn.count_seen19.name());
        message.is_edited = cursorInterFace.getInt(MessageColumn.is_edited20.name()) == 1;
        message.via_bot_guid = cursorInterFace.getString(MessageColumn.via_bot_guid73.name());
        String string5 = cursorInterFace.getString(MessageColumn.forward_object_guid23.name());
        if (string5 != null && !string5.isEmpty()) {
            Message.ForwardFromObject forwardFromObject = new Message.ForwardFromObject();
            try {
                forwardFromObject.type_from = Message.ForwardFromType.valueOf(cursorInterFace.getString(MessageColumn.forward_type_from21.name()));
            } catch (Exception unused3) {
                forwardFromObject.type_from = null;
            }
            forwardFromObject.message_id = cursorInterFace.getLong(MessageColumn.forward_message_id22.name());
            forwardFromObject.object_guid = string5;
            message.forwarded_from = forwardFromObject;
        } else {
            message.forwarded_from = null;
        }
        message.reply_timeout = cursorInterFace.getInt(MessageColumn.reply_timeout24.name());
        message.is_local_deleted = cursorInterFace.getInt(MessageColumn.is_local_deleted34.name()) == 1;
        try {
            message.type = Message.MessageTypeEnum.valueOf(cursorInterFace.getString(MessageColumn.type39.name()));
        } catch (Exception unused4) {
            message.type = null;
        }
        Message.MessageTypeEnum messageTypeEnum = message.type;
        if ((messageTypeEnum == Message.MessageTypeEnum.Poll2 || messageTypeEnum == Message.MessageTypeEnum.Poll) && (string = cursorInterFace.getString(MessageColumn.json_poll44.name())) != null && !string.isEmpty()) {
            try {
                message.poll = (PollObject) this.jsonHelper.fromJson(string, PollObject.class);
            } catch (Exception unused5) {
            }
        }
        if (message.type == Message.MessageTypeEnum.Location) {
            double d = cursorInterFace.getDouble(MessageColumn.location_longitude25.name());
            double d2 = cursorInterFace.getDouble(MessageColumn.location_latitude26.name());
            LocationObject locationObject = new LocationObject();
            message.location = locationObject;
            locationObject.longitude = d;
            locationObject.latitude = d2;
        }
        if (message.type == Message.MessageTypeEnum.Sticker && (string4 = cursorInterFace.getString(MessageColumn.sticker_id27.name())) != null && !string4.isEmpty()) {
            StickerObject stickerObject = new StickerObject();
            stickerObject.sticker_id = string4;
            stickerObject.w_h_ratio = cursorInterFace.getFloat(MessageColumn.sticker_w_h_ratio28.name());
            long j2 = cursorInterFace.getLong(MessageColumn.sticker_file_id29.name());
            if (j2 != 0) {
                AvatarFileInline avatarFileInline = new AvatarFileInline();
                avatarFileInline.file_id = j2;
                avatarFileInline.dc_id = cursorInterFace.getString(MessageColumn.sticker_dc_id30.name());
                avatarFileInline.access_hash_rec = cursorInterFace.getString(MessageColumn.sticker_access_hash_rec31.name());
                avatarFileInline.cdn_tag = cursorInterFace.getString(MessageColumn.sticker_file_cdn_tag84.name());
                stickerObject.file = avatarFileInline;
            }
            stickerObject.emoji_character = cursorInterFace.getString(MessageColumn.sticker_emoji_character32.name());
            stickerObject.sticker_set_id = cursorInterFace.getString(MessageColumn.sticker_sticker_set_id33.name());
            message.sticker = stickerObject;
        }
        long j3 = cursorInterFace.getLong(MessageColumn.live_loc_start_time53.name());
        if (j3 > 0) {
            LiveLocationObject liveLocationObject = new LiveLocationObject();
            message.live_location = liveLocationObject;
            liveLocationObject.current_location = new LocationObject();
            LiveLocationObject liveLocationObject2 = message.live_location;
            liveLocationObject2.start_time = j3;
            liveLocationObject2.live_loc_track_id = cursorInterFace.getString(MessageColumn.live_loc_track_id47.name());
            message.live_location.current_location.latitude = cursorInterFace.getDouble(MessageColumn.live_loc_current_location_lat48.name());
            message.live_location.current_location.longitude = cursorInterFace.getDouble(MessageColumn.live_loc_current_location_lon49.name());
            message.live_location.device_hash = cursorInterFace.getString(MessageColumn.live_loc_device_hash50.name());
            message.live_location.user_guid = cursorInterFace.getString(MessageColumn.live_loc_user_guid51.name());
            try {
                message.live_location.status = LiveLocationObject.Status.valueOf(cursorInterFace.getString(MessageColumn.live_loc_status52.name()));
            } catch (Exception unused6) {
                message.live_location.status = LiveLocationObject.Status.Stopped;
            }
            message.live_location.live_period = cursorInterFace.getLong(MessageColumn.live_loc_live_period54.name());
            message.live_location.last_update_time = cursorInterFace.getLong(MessageColumn.live_loc_last_update_time55.name());
        }
        String string6 = cursorInterFace.getString(MessageColumn.forwarded_no_link_from_title56.name());
        if (string6 != null) {
            ForwardedNoLinkObject forwardedNoLinkObject = new ForwardedNoLinkObject();
            message.forwarded_no_link = forwardedNoLinkObject;
            forwardedNoLinkObject.from_title = string6;
        }
        String string7 = cursorInterFace.getString(MessageColumn.key_pad_json57.name());
        if (string7 != null && !string7.isEmpty()) {
            try {
                message.inline_keypad = (KeyPadObject) this.jsonHelper.fromJson(string7, KeyPadObject.class);
            } catch (Exception unused7) {
            }
        }
        if (message.type == Message.MessageTypeEnum.Call && (string3 = cursorInterFace.getString(MessageColumn.call_data_json59.name())) != null && !string3.isEmpty()) {
            try {
                message.message_call = (MessageCallData) this.jsonHelper.fromJson(string3, MessageCallData.class);
            } catch (Exception unused8) {
            }
        }
        if (message.type == Message.MessageTypeEnum.ContactMessage && (string2 = cursorInterFace.getString(MessageColumn.json_contact38.name())) != null && !string2.isEmpty()) {
            try {
                message.contact_message = (ContactMessageObject) this.jsonHelper.fromJson(string2, ContactMessageObject.class);
            } catch (Exception unused9) {
            }
        }
        if (message.type == Message.MessageTypeEnum.Live) {
            LiveModels.LiveMessage liveMessage = new LiveModels.LiveMessage();
            message.live_data = liveMessage;
            liveMessage.live_id = cursorInterFace.getString(MessageColumn.live_id60.name());
            message.live_data.access_token = cursorInterFace.getString(MessageColumn.live_access_token61.name());
            message.live_data.thumb_inline = cursorInterFace.getString(MessageColumn.live_thumb_inline74.name());
            message.live_data.title = cursorInterFace.getString(MessageColumn.live_title80.name());
            String string8 = cursorInterFace.getString(MessageColumn.live_status_json62.name());
            if (string8 != null && !string8.isEmpty()) {
                try {
                    message.live_data.live_status = (LiveModels.LiveStatus) this.jsonHelper.fromJson(string8, LiveModels.LiveStatus.class);
                } catch (Exception unused10) {
                }
            }
            LiveModels.LiveMessage liveMessage2 = message.live_data;
            if (liveMessage2.live_status == null) {
                liveMessage2.live_status = new LiveModels.LiveStatus();
            }
        }
        String string9 = cursorInterFace.getString(MessageColumn.metadata_json63.name());
        if (string9 != null && !string9.isEmpty()) {
            try {
                message.metadata = (MetaDataObject) this.jsonHelper.fromJson(string9, MetaDataObject.class);
            } catch (Exception unused11) {
            }
        }
        String string10 = cursorInterFace.getString(MessageColumn.event_json64.name());
        if (string10 != null && !string10.isEmpty()) {
            try {
                message.event_data = (Message.EventObject) this.jsonHelper.fromJson(string10, Message.EventObject.class);
            } catch (Exception unused12) {
            }
        }
        message.author_signature = cursorInterFace.getString(MessageColumn.author_signature65.name());
        message.isDeleted = cursorInterFace.getInt(MessageColumn.isDeleted66.name()) == 1;
        message.timeStamp = cursorInterFace.getLong(MessageColumn.timeStamp67.name());
        message.timeMillis = cursorInterFace.getLong(MessageColumn.timeMillis70.name());
        String string11 = cursorInterFace.getString(MessageColumn.rubino_story_data.name());
        if (string11 != null && !string11.isEmpty()) {
            try {
                message.rubino_story_data = (RubinoStoryData) this.jsonHelper.fromJson(string11, RubinoStoryData.class);
            } catch (Exception unused13) {
            }
        }
        String string12 = cursorInterFace.getString(MessageColumn.rubino_post_data.name());
        if (string12 != null && !string12.isEmpty()) {
            try {
                message.rubino_post_data = (RubinoPostData) this.jsonHelper.fromJson(string12, RubinoPostData.class);
            } catch (Exception unused14) {
            }
        }
        String string13 = cursorInterFace.getString(MessageColumn.product_message_data78.name());
        if (string13 != null && !string13.isEmpty()) {
            try {
                message.product_message_data = (ProductMessageData) this.jsonHelper.fromJson(string13, ProductMessageData.class);
            } catch (Exception unused15) {
            }
        }
        String string14 = cursorInterFace.getString(MessageColumn.wallet_transfer_data79.name());
        if (message.type == Message.MessageTypeEnum.WalletTransfer && string14 != null && !string14.isEmpty()) {
            try {
                message.wallet_transfer_data = (WalletTransferDataObject) this.jsonHelper.fromJson(string14, WalletTransferDataObject.class);
            } catch (Exception unused16) {
            }
        }
        message.is_banned = cursorInterFace.getInt(MessageColumn.is_banned81.name()) == 1;
        String string15 = cursorInterFace.getString(MessageColumn.reactions83.name());
        if (string15 != null && !string15.isEmpty()) {
            try {
                message.reactions = new ArrayList<>(Arrays.asList((MessageReactionObject[]) this.jsonHelper.fromJson(string15, MessageReactionObject[].class)));
            } catch (Exception unused17) {
            }
        }
        return message;
    }

    public NotificationModels.ShowNotificationObject parseNotificationObject(CursorInterFace cursorInterFace) {
        NotificationModels.ShowNotificationObject showNotificationObject = new NotificationModels.ShowNotificationObject();
        showNotificationObject.notification_id = cursorInterFace.getString(NotificationColumn.notification_id1 + BuildConfig.FLAVOR);
        try {
            showNotificationObject.type = NotificationModels.ShowNotificationTypeEnum.valueOf(cursorInterFace.getString(NotificationColumn.type2 + BuildConfig.FLAVOR));
        } catch (Exception unused) {
            showNotificationObject.type = null;
        }
        showNotificationObject.title = cursorInterFace.getString(NotificationColumn.title3 + BuildConfig.FLAVOR);
        showNotificationObject.text = cursorInterFace.getString(NotificationColumn.text4 + BuildConfig.FLAVOR);
        String string = cursorInterFace.getString(NotificationColumn.textMetaData14 + BuildConfig.FLAVOR);
        if (string != null) {
            try {
                showNotificationObject.text_metadata = (MetaDataObject) this.jsonHelper.fromJson(string, MetaDataObject.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        showNotificationObject.image_file_id = cursorInterFace.getLong(NotificationColumn.image_file_id5 + BuildConfig.FLAVOR);
        String string2 = cursorInterFace.getString(NotificationColumn.message_data_object_guid6 + BuildConfig.FLAVOR);
        if (string2 != null) {
            NotificationModels.MessageDataObject messageDataObject = new NotificationModels.MessageDataObject();
            messageDataObject.object_guid = string2;
            try {
                messageDataObject.object_type = ChatType.valueOf(cursorInterFace.getString(NotificationColumn.message_data_object_type7 + BuildConfig.FLAVOR));
            } catch (Exception unused2) {
            }
            messageDataObject.message_id = cursorInterFace.getLong(NotificationColumn.message_data_message_id8 + BuildConfig.FLAVOR);
            showNotificationObject.message_data = messageDataObject;
        }
        String string3 = cursorInterFace.getString(NotificationColumn.not_message_data_object_guid9 + BuildConfig.FLAVOR);
        if (string3 != null) {
            NotificationModels.NotMessageDataObject notMessageDataObject = new NotificationModels.NotMessageDataObject();
            notMessageDataObject.object_guid = string3;
            try {
                notMessageDataObject.object_type = ChatType.valueOf(cursorInterFace.getString(NotificationColumn.not_message_data_object_type10 + BuildConfig.FLAVOR));
            } catch (Exception unused3) {
            }
            notMessageDataObject.time = cursorInterFace.getLong(NotificationColumn.not_message_data_time11 + BuildConfig.FLAVOR);
            showNotificationObject.not_message_data = notMessageDataObject;
        }
        showNotificationObject.receivedTime = cursorInterFace.getLong(NotificationColumn.time13 + BuildConfig.FLAVOR);
        return showNotificationObject;
    }

    public MessageHoleObject parseMessageHoleCursor(CursorInterFace cursorInterFace) {
        MessageHoleObject messageHoleObject = new MessageHoleObject();
        messageHoleObject.start = cursorInterFace.getLong(MessageHoleColumn.start2.name());
        messageHoleObject.end = cursorInterFace.getLong(MessageHoleColumn.end3.name());
        String string = cursorInterFace.getString(MessageHoleColumn.type4.name());
        if (string != null) {
            try {
                messageHoleObject.type = MessageUtils.FilterTypeEnum.valueOf(string);
            } catch (Exception unused) {
            }
        } else {
            messageHoleObject.type = MessageUtils.FilterTypeEnum.All;
        }
        return messageHoleObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ServiceInfo parseService(CursorInterFace cursorInterFace) {
        ServiceInfo serviceInfo = new ServiceInfo();
        serviceInfo.service_guid = cursorInterFace.getString(ServiceColumn.service_guid1 + BuildConfig.FLAVOR);
        serviceInfo.description = cursorInterFace.getString(ServiceColumn.description2 + BuildConfig.FLAVOR);
        String string = cursorInterFace.getString(ServiceColumn.warning_json3 + BuildConfig.FLAVOR);
        if (string != null) {
            try {
                if (!string.isEmpty()) {
                    serviceInfo.warning_info = (WarningObject) this.jsonHelper.fromJson(string, WarningObject.class);
                }
            } catch (Exception unused) {
            }
        }
        serviceInfo.insertedToDbTime = cursorInterFace.getLong(ServiceColumn.updated_time4 + BuildConfig.FLAVOR);
        return serviceInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BotInfo parseBot(CursorInterFace cursorInterFace) {
        BotInfo botInfo = new BotInfo();
        botInfo.bot_guid = cursorInterFace.getString(BotInfoColumn.bot_guid1 + BuildConfig.FLAVOR);
        botInfo.description = cursorInterFace.getString(BotInfoColumn.description5 + BuildConfig.FLAVOR);
        String string = cursorInterFace.getString(BotInfoColumn.warning_json3 + BuildConfig.FLAVOR);
        if (string != null) {
            try {
                if (!string.isEmpty()) {
                    botInfo.warning_info = (WarningObject) this.jsonHelper.fromJson(string, WarningObject.class);
                }
            } catch (Exception unused) {
            }
        }
        botInfo.insertedToDbTime = cursorInterFace.getLong(BotInfoColumn.updated_time8 + BuildConfig.FLAVOR);
        botInfo.start_message = cursorInterFace.getString(BotInfoColumn.start_message4 + BuildConfig.FLAVOR);
        botInfo.username = cursorInterFace.getString(BotInfoColumn.username2 + BuildConfig.FLAVOR);
        botInfo.share_url = cursorInterFace.getString(BotInfoColumn.share_url6 + BuildConfig.FLAVOR);
        try {
            botInfo.commands = new ArrayList<>(Arrays.asList((BotCommandObject[]) this.jsonHelper.fromJson(cursorInterFace.getString(BotInfoColumn.commands_json7 + BuildConfig.FLAVOR), BotCommandObject[].class)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return botInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FolderObject parseFolderObject(CursorInterFace cursorInterFace) {
        FolderObject folderObject = new FolderObject();
        String string = cursorInterFace.getString(FolderColumn.folder_id1.name());
        folderObject.folder_id = string;
        if (string == null || string.isEmpty()) {
            return null;
        }
        folderObject.name = cursorInterFace.getString(FolderColumn.name2.name());
        String string2 = cursorInterFace.getString(FolderColumn.include_objects_json3.name());
        if (string2 != null && !string2.isEmpty()) {
            ObjectGuidType[] objectGuidTypeArr = new ObjectGuidType[0];
            try {
                objectGuidTypeArr = (ObjectGuidType[]) this.jsonHelper.fromJson(string2, ObjectGuidType[].class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            folderObject.include_objects = new ArrayList<>(Arrays.asList(objectGuidTypeArr));
        }
        String string3 = cursorInterFace.getString(FolderColumn.exclude_objects_json4.name());
        if (string3 != null && !string3.isEmpty()) {
            ObjectGuidType[] objectGuidTypeArr2 = new ObjectGuidType[0];
            try {
                objectGuidTypeArr2 = (ObjectGuidType[]) this.jsonHelper.fromJson(string3, ObjectGuidType[].class);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            folderObject.exclude_objects = new ArrayList<>(Arrays.asList(objectGuidTypeArr2));
        }
        String string4 = cursorInterFace.getString(FolderColumn.pinned_objects_json5.name());
        if (string4 != null && !string4.isEmpty()) {
            ObjectGuidType[] objectGuidTypeArr3 = new ObjectGuidType[0];
            try {
                objectGuidTypeArr3 = (ObjectGuidType[]) this.jsonHelper.fromJson(string4, ObjectGuidType[].class);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            folderObject.pinned_objects = new ArrayList<>(Arrays.asList(objectGuidTypeArr3));
        }
        String string5 = cursorInterFace.getString(FolderColumn.include_chat_types_json6.name());
        if (string5 != null && !string5.isEmpty()) {
            FolderObject.EnumIncludeChatType[] enumIncludeChatTypeArr = new FolderObject.EnumIncludeChatType[0];
            try {
                enumIncludeChatTypeArr = (FolderObject.EnumIncludeChatType[]) this.jsonHelper.fromJson(string5, FolderObject.EnumIncludeChatType[].class);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            folderObject.include_chat_types = new ArrayList<>(Arrays.asList(enumIncludeChatTypeArr));
        }
        String string6 = cursorInterFace.getString(FolderColumn.exclude_chat_types_json7.name());
        if (string6 != null && !string6.isEmpty()) {
            FolderObject.EnumExcludeChatType[] enumExcludeChatTypeArr = new FolderObject.EnumExcludeChatType[0];
            try {
                enumExcludeChatTypeArr = (FolderObject.EnumExcludeChatType[]) this.jsonHelper.fromJson(string6, FolderObject.EnumExcludeChatType[].class);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            folderObject.exclude_chat_types = new ArrayList<>(Arrays.asList(enumExcludeChatTypeArr));
        }
        folderObject.order = cursorInterFace.getInt(FolderColumn.order8.name());
        folderObject.suggestion_folder_id = cursorInterFace.getString(FolderColumn.suggestion_folder_id9.name());
        folderObject.createFlags();
        folderObject.makeSetFromArrays();
        return folderObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GroupInfo parseGroupInfo(CursorInterFace cursorInterFace) {
        GroupInfo groupInfo = new GroupInfo();
        groupInfo.group_guid = cursorInterFace.getString(GroupInfoColumn.group_guid1.name());
        groupInfo.count_members = cursorInterFace.getInt(GroupInfoColumn.count_members2.name());
        groupInfo.insertedToDbTime = cursorInterFace.getLong(GroupInfoColumn.insertedTime8.name());
        String string = cursorInterFace.getString(GroupInfoColumn.warning_info3.name());
        if (string != null) {
            try {
                if (!string.isEmpty()) {
                    groupInfo.warning_info = (WarningObject) this.jsonHelper.fromJson(string, WarningObject.class);
                }
            } catch (Exception unused) {
            }
        }
        groupInfo.slow_mode = cursorInterFace.getInt(GroupInfoColumn.slow_mode5.name());
        groupInfo.description = cursorInterFace.getString(GroupInfoColumn.description4.name());
        try {
            groupInfo.chat_history_for_new_members = GroupInfoFromServer.ChatHistoryForNewMembers.valueOf(cursorInterFace.getString(GroupInfoColumn.chat_history_for_new_members6.name()));
        } catch (Exception unused2) {
        }
        groupInfo.event_messages = cursorInterFace.getInt(GroupInfoColumn.event_messages7.name()) == 1;
        String string2 = cursorInterFace.getString(GroupInfoColumn.chat_reaction_setting9.name());
        if (string2 != null) {
            try {
                if (!string2.isEmpty()) {
                    groupInfo.chat_reaction_setting = (ChatReactionSetting) this.jsonHelper.fromJson(string2, ChatReactionSetting.class);
                }
            } catch (Exception unused3) {
            }
        }
        return groupInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChannelInfo parseChannelInfo(CursorInterFace cursorInterFace) {
        ChannelInfo channelInfo = new ChannelInfo();
        channelInfo.channel_guid = cursorInterFace.getString(ChannelInfoColumn.channel_guid1.name());
        channelInfo.count_members = cursorInterFace.getInt(ChannelInfoColumn.count_members2.name());
        channelInfo.username = cursorInterFace.getString(ChannelInfoColumn.username3.name());
        channelInfo.description = cursorInterFace.getString(ChannelInfoColumn.description4.name());
        String string = cursorInterFace.getString(ChannelInfoColumn.warning_info_json5.name());
        if (string != null) {
            try {
                if (!string.isEmpty()) {
                    channelInfo.warning_info = (WarningObject) this.jsonHelper.fromJson(string, WarningObject.class);
                }
            } catch (Exception unused) {
            }
        }
        channelInfo.sign_messages = cursorInterFace.getInt(ChannelInfoColumn.sign_messages6.name()) == 1;
        try {
            channelInfo.channel_type = ChannelInfoFromServer.ChannelTypeEnum.valueOf(cursorInterFace.getString(ChannelInfoColumn.channel_type7.name()));
        } catch (Exception unused2) {
        }
        if (channelInfo.channel_type == null) {
            channelInfo.channel_type = ChannelInfoFromServer.ChannelTypeEnum.Public;
        }
        channelInfo.insertedToDbTime = cursorInterFace.getLong(ChannelInfoColumn.insertedTime8.name());
        channelInfo.share_url = cursorInterFace.getString(ChannelInfoColumn.share_url9.name());
        String string2 = cursorInterFace.getString(ChannelInfoColumn.chat_reaction_setting10.name());
        if (string2 != null) {
            try {
                if (!string2.isEmpty()) {
                    channelInfo.chat_reaction_setting = (ChatReactionSetting) this.jsonHelper.fromJson(string2, ChatReactionSetting.class);
                }
            } catch (Exception unused3) {
            }
        }
        return channelInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FileInlineObject parseGifObject(CursorInterFace cursorInterFace) {
        FileInlineObject fileInlineObject = new FileInlineObject();
        if (cursorInterFace.getLong(RecentGifColumn.file_id_1.name()) > 0) {
            try {
                fileInlineObject = (FileInlineObject) this.jsonHelper.fromJson(cursorInterFace.getString(RecentGifColumn.gif_data_3.name()), FileInlineObject.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            fileInlineObject.type = FileInlineObject.FileInlineType.Gif;
        }
        return fileInlineObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FileInlineObject parseSentFile(CursorInterFace cursorInterFace) {
        FileInlineObject fileInlineObject = new FileInlineObject();
        if (!CoreUtilities.isNotEmpty(cursorInterFace.getString(SentFileColumn.path1.name()))) {
            return fileInlineObject;
        }
        try {
            return (FileInlineObject) this.jsonHelper.fromJson(cursorInterFace.getString(SentFileColumn.data2.name()), FileInlineObject.class);
        } catch (Exception e) {
            e.printStackTrace();
            return fileInlineObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public StickerObject parseStickerObject(CursorInterFace cursorInterFace) {
        String string = cursorInterFace.getString(RecentOrFavoriteStickerColumn.sticker_id_1.name());
        if (string == null || string.isEmpty()) {
            return null;
        }
        try {
            return (StickerObject) this.jsonHelper.fromJson(cursorInterFace.getString(RecentOrFavoriteStickerColumn.sticker_data_5.name()), StickerObject.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GetStickerSetByIdOutput parseStickerSetObject(CursorInterFace cursorInterFace) {
        String string = cursorInterFace.getString(MyStickerSetColumn.sticker_set_id_1.name());
        if (string != null && !string.isEmpty()) {
            try {
                return (GetStickerSetByIdOutput) this.jsonHelper.fromJson(cursorInterFace.getString(MyStickerSetColumn.sticker_set_data_3.name()), GetStickerSetByIdOutput.class);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void clearDatabase(boolean z) {
        for (TableName tableName : TableName.values()) {
            this.db.removeObject(tableName.name(), null);
        }
        if (z) {
            this.db.close();
        }
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void updateChatParameter(Map<String, ChatFromServer> map, Map<String, Set<ChatParamUpdateTimeObject.Params>> map2, Map<String, Long> map3) {
        for (String str : map.keySet()) {
            try {
                ChatFromServer chatFromServer = map.get(str);
                chatFromServer.object_guid = str;
                updateChatAndAbsInternal(chatFromServer, map2.get(str), map3.get(str).longValue());
            } catch (Exception e) {
                Log.e("TAAAAAG", e.getMessage());
            }
        }
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void updateFolderOrder(String str, int i) {
        this.db.updateTable(TableName.folderTable.name(), new String[]{FolderColumn.order8.name()}, new String[]{i + BuildConfig.FLAVOR}, new WhereCondition(FolderColumn.folder_id1.name(), WhereCondition.OperatorEnum.EQ, str));
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void updateMessagePoll(String str, long j, PollObject pollObject) {
        String strName = MessageColumn.object_guid1.name();
        WhereCondition.OperatorEnum operatorEnum = WhereCondition.OperatorEnum.EQ;
        WhereCondition whereCondition = new WhereCondition(new WhereCondition(strName, operatorEnum, str), WhereCondition.OperatorEnum.And, new WhereCondition(MessageColumn.message_id2.name(), operatorEnum, String.valueOf(j)));
        String[] strArr = {MessageColumn.json_poll44.name()};
        String[] strArr2 = new String[1];
        strArr2[0] = pollObject != null ? this.jsonHelper.toJson(pollObject) : null;
        this.db.updateTable(TableName.messageTable.name(), strArr, strArr2, whereCondition);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void updateMessageLiveStatus(String str, LiveModels.LiveStatus liveStatus) {
        WhereCondition whereCondition = new WhereCondition(MessageColumn.live_id60.name(), WhereCondition.OperatorEnum.EQ, str);
        String[] strArr = {MessageColumn.live_status_json62.name()};
        String[] strArr2 = new String[1];
        strArr2[0] = liveStatus != null ? this.jsonHelper.toJson(liveStatus) : null;
        this.db.updateTable(TableName.messageTable.name(), strArr, strArr2, whereCondition);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void updateLiveLocation(String str, long j, LiveLocationObject liveLocationObject) {
        if (liveLocationObject == null) {
            return;
        }
        String strName = MessageColumn.object_guid1.name();
        WhereCondition.OperatorEnum operatorEnum = WhereCondition.OperatorEnum.EQ;
        WhereCondition whereCondition = new WhereCondition(new WhereCondition(strName, operatorEnum, str), WhereCondition.OperatorEnum.And, new WhereCondition(MessageColumn.message_id2.name(), operatorEnum, String.valueOf(j)));
        String[] strArr = {MessageColumn.live_loc_current_location_lat48.name(), MessageColumn.live_loc_current_location_lon49.name(), MessageColumn.live_loc_status52.name(), MessageColumn.live_loc_last_update_time55.name()};
        String[] strArr2 = new String[4];
        strArr2[0] = String.valueOf(liveLocationObject.current_location.latitude);
        strArr2[1] = String.valueOf(liveLocationObject.current_location.longitude);
        LiveLocationObject.Status status = liveLocationObject.status;
        strArr2[2] = status != null ? status.name() : null;
        strArr2[3] = String.valueOf(liveLocationObject.last_update_time);
        this.db.updateTable(TableName.messageTable.name(), strArr, strArr2, whereCondition);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void updateMessageParameter(Map<String, ArrayList<MessageUpdateResult>> map) {
        ArrayList<KeypadRow> arrayList;
        ArrayList<MetaDataPartObject> arrayList2;
        if (map == null || map.size() == 0) {
            return;
        }
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            Iterator<MessageUpdateResult> it2 = map.get(it.next()).iterator();
            while (it2.hasNext()) {
                MessageUpdateResult next = it2.next();
                Set<MessageParamUpdateTimeObject.UpdateParameterEnum> set = next.updatedParametersForDatabase;
                if (set != null && set.size() != 0) {
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    String strName = MessageColumn.object_guid1.name();
                    WhereCondition.OperatorEnum operatorEnum = WhereCondition.OperatorEnum.EQ;
                    WhereCondition whereCondition = new WhereCondition(new WhereCondition(strName, operatorEnum, next.object_guid), WhereCondition.OperatorEnum.And, new WhereCondition(MessageColumn.message_id2.name(), operatorEnum, next.message.message_id + BuildConfig.FLAVOR));
                    for (MessageParamUpdateTimeObject.UpdateParameterEnum updateParameterEnum : next.updatedParametersForDatabase) {
                        if (updateParameterEnum == MessageParamUpdateTimeObject.UpdateParameterEnum.text) {
                            arrayList3.add(MessageColumn.text5.name());
                            arrayList4.add(next.message.text);
                        } else {
                            if (updateParameterEnum == MessageParamUpdateTimeObject.UpdateParameterEnum.type) {
                                arrayList3.add(MessageColumn.type39.name());
                                Message.MessageTypeEnum messageTypeEnum = next.message.type;
                                arrayList4.add(messageTypeEnum != null ? messageTypeEnum.name() : null);
                            } else if (updateParameterEnum == MessageParamUpdateTimeObject.UpdateParameterEnum.inline_keypad) {
                                arrayList3.add(MessageColumn.key_pad_json57.name());
                                KeyPadObject keyPadObject = next.message.inline_keypad;
                                if (keyPadObject != null && (arrayList = keyPadObject.rows) != null && arrayList.size() > 0) {
                                    json = this.jsonHelper.toJson(next.message.inline_keypad);
                                }
                                arrayList4.add(json);
                            } else if (updateParameterEnum == MessageParamUpdateTimeObject.UpdateParameterEnum.metadata) {
                                arrayList3.add(MessageColumn.metadata_json63.name());
                                MetaDataObject metaDataObject = next.message.metadata;
                                if (metaDataObject != null && (arrayList2 = metaDataObject.meta_data_parts) != null && !arrayList2.isEmpty()) {
                                    json = this.jsonHelper.toJson(next.message.metadata);
                                }
                                arrayList4.add(json);
                            } else {
                                if (updateParameterEnum == MessageParamUpdateTimeObject.UpdateParameterEnum.is_edited) {
                                    arrayList3.add(MessageColumn.is_edited20.name());
                                    arrayList4.add(next.message.is_edited ? "1" : "0");
                                } else if (updateParameterEnum == MessageParamUpdateTimeObject.UpdateParameterEnum.message_call) {
                                    arrayList3.add(MessageColumn.call_data_json59.name());
                                    MessageCallData messageCallData = next.message.message_call;
                                    arrayList4.add(messageCallData != null ? this.jsonHelper.toJson(messageCallData) : null);
                                } else if (updateParameterEnum == MessageParamUpdateTimeObject.UpdateParameterEnum.is_banned) {
                                    arrayList3.add(MessageColumn.is_banned81.name());
                                    arrayList4.add(next.message.is_banned ? "1" : "0");
                                }
                            }
                        }
                    }
                    this.db.updateTable(TableName.messageTable.name(), (String[]) arrayList3.toArray(new String[arrayList3.size()]), (String[]) arrayList4.toArray(new String[arrayList4.size()]), whereCondition);
                }
            }
        }
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void updateMessageSendState(Message message) {
        if (message == null) {
            return;
        }
        this.db.updateTable(TableName.messageTable.name(), new String[]{MessageColumn.sendState71.name()}, new String[]{message.sendState + BuildConfig.FLAVOR}, new WhereCondition(MessageColumn.message_id2.name(), WhereCondition.OperatorEnum.EQ, message.message_id + BuildConfig.FLAVOR));
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void updateMessageReplyTo(Message message) {
        if (message == null) {
            return;
        }
        this.db.updateTable(TableName.messageTable.name(), new String[]{MessageColumn.reply_to_message_id17.name()}, new String[]{message.reply_to_message_id + BuildConfig.FLAVOR}, new WhereCondition(MessageColumn.message_id2.name(), WhereCondition.OperatorEnum.EQ, message.message_id + BuildConfig.FLAVOR));
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void clearLocalMessageFileInline(long j) {
        if (j >= 0) {
            return;
        }
        this.db.updateTable(TableName.messageTable.name(), new String[]{MessageColumn.file_inline_file_id6.name(), MessageColumn.file_inline_dc_id8.name(), MessageColumn.file_inline_access_hash_rec9.name()}, new String[]{BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR}, new WhereCondition(MessageColumn.message_id2.name(), WhereCondition.OperatorEnum.EQ, j + BuildConfig.FLAVOR));
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void updateMessagesSeenCount(Map<Long, Integer> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        for (Long l : map.keySet()) {
            this.db.updateTable(TableName.messageTable.name(), new String[]{MessageColumn.count_seen19.name()}, new String[]{map.get(l) + BuildConfig.FLAVOR}, new WhereCondition(MessageColumn.message_id2.name(), WhereCondition.OperatorEnum.EQ, l + BuildConfig.FLAVOR));
        }
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void updateMessagesReactions(Map<Long, ArrayList<MessageReactionObject>> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        for (Long l : map.keySet()) {
            String[] strArr = {MessageColumn.reactions83.name()};
            String[] strArr2 = map.get(l) != null ? new String[]{this.jsonHelper.toJson(map.get(l))} : new String[]{BuildConfig.FLAVOR};
            this.db.updateTable(TableName.messageTable.name(), strArr, strArr2, new WhereCondition(MessageColumn.message_id2.name(), WhereCondition.OperatorEnum.EQ, l + BuildConfig.FLAVOR));
        }
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void updateChatLastMessageText(String str, String str2) {
        if (str == null) {
            return;
        }
        this.db.updateTable(TableName.chatTable.name(), new String[]{ChatColumn.last_message_text9.name()}, new String[]{str2}, new WhereCondition(ChatColumn.object_guid1.name(), WhereCondition.OperatorEnum.EQ, str));
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void updateMessageLocalParameters(Message message) {
        if (message == null) {
            return;
        }
        String[] strArr = {MessageColumn.localParameters69.name()};
        String[] strArr2 = new String[1];
        Message.LocalParametersObject localParametersObject = message.localParametersObject;
        strArr2[0] = localParametersObject != null ? this.jsonHelper.toJson(localParametersObject) : null;
        this.db.updateTable(TableName.messageTable.name(), strArr, strArr2, new WhereCondition(MessageColumn.message_id2.name(), WhereCondition.OperatorEnum.EQ, message.message_id + BuildConfig.FLAVOR));
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void updateMessageOnLocallyEditedChanged(Message message, boolean z, boolean z2) {
        String[] strArr;
        String[] strArr2;
        if (message == null) {
            return;
        }
        if (z2) {
            strArr2 = new String[]{MessageColumn.isLocallyEdited72.name()};
            strArr = new String[1];
            strArr[0] = z ? "1" : "0";
        } else {
            String[] strArr3 = {MessageColumn.text5.name(), MessageColumn.metadata_json63.name(), MessageColumn.isLocallyEdited72.name(), MessageColumn.localParameters69.name()};
            String[] strArr4 = new String[4];
            strArr4[0] = message.text;
            MetaDataObject metaDataObject = message.metadata;
            String json = null;
            strArr4[1] = metaDataObject != null ? this.jsonHelper.toJson(metaDataObject) : null;
            strArr4[2] = z ? "1" : "0";
            Message.LocalParametersObject localParametersObject = message.localParametersObject;
            if (localParametersObject != null && z) {
                json = this.jsonHelper.toJson(localParametersObject);
            }
            strArr4[3] = json;
            strArr = strArr4;
            strArr2 = strArr3;
        }
        this.db.updateTable(TableName.messageTable.name(), strArr2, strArr, new WhereCondition(MessageColumn.message_id2.name(), WhereCondition.OperatorEnum.EQ, message.message_id + BuildConfig.FLAVOR));
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void updateContactLastOnline(ArrayList<UserInfoFromServer> arrayList) {
        String str;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        int i = 3;
        String[] strArr = {UserColumn.online_time_type18.name(), UserColumn.online_time_exact_time19.name(), UserColumn.online_time_approximate_period20.name()};
        ArrayList<String[]> arrayList2 = new ArrayList<>();
        WhereCondition[] whereConditionArr = new WhereCondition[arrayList.size()];
        int i2 = 0;
        while (i2 < arrayList.size()) {
            UserInfoFromServer userInfoFromServer = arrayList.get(i2);
            String[] strArr2 = new String[i];
            String str2 = null;
            if (userInfoFromServer.online_time.type != null) {
                str = userInfoFromServer.online_time.type + BuildConfig.FLAVOR;
            } else {
                str = null;
            }
            strArr2[0] = str;
            StringBuilder sb = new StringBuilder();
            String[] strArr3 = strArr;
            sb.append(userInfoFromServer.online_time.exact_time);
            sb.append(BuildConfig.FLAVOR);
            strArr2[1] = sb.toString();
            if (userInfoFromServer.online_time.approximate_period != null) {
                str2 = userInfoFromServer.online_time.approximate_period + BuildConfig.FLAVOR;
            }
            strArr2[2] = str2;
            arrayList2.add(strArr2);
            whereConditionArr[i2] = new WhereCondition(UserColumn.user_guid1 + BuildConfig.FLAVOR, WhereCondition.OperatorEnum.EQ, userInfoFromServer.user_guid);
            i2++;
            strArr = strArr3;
            i = 3;
        }
        this.db.updateTable(TableName.userTable.name(), strArr, arrayList2, whereConditionArr);
        this.db.updateTable(TableName.contactTable.name(), strArr, arrayList2, whereConditionArr);
    }

    public void updateChatAndAbsInternal(ChatFromServer chatFromServer, Set<ChatParamUpdateTimeObject.Params> set, long j) {
        if (chatFromServer == null || set == null || set.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean z = false;
        for (ChatParamUpdateTimeObject.Params params : set) {
            if (params == ChatParamUpdateTimeObject.Params.access) {
                arrayList2.add(this.jsonHelper.toJson(chatFromServer.access));
                arrayList.add(ChatColumn.access2.name());
            } else if (params == ChatParamUpdateTimeObject.Params.count_unseen) {
                arrayList2.add(chatFromServer.count_unseen + BuildConfig.FLAVOR);
                arrayList.add(ChatColumn.count_unseen3.name());
            } else {
                if (params == ChatParamUpdateTimeObject.Params.is_mute) {
                    arrayList2.add(chatFromServer.is_mute ? "1" : "0");
                    arrayList.add(ChatColumn.is_mute4.name());
                } else if (params == ChatParamUpdateTimeObject.Params.is_pinned) {
                    arrayList2.add(chatFromServer.is_pinned ? "1" : "0");
                    arrayList.add(ChatColumn.is_pinned5.name());
                } else if (params == ChatParamUpdateTimeObject.Params.time_string) {
                    arrayList2.add(chatFromServer.time_string);
                    arrayList.add(ChatColumn.time_string6.name());
                } else {
                    if (params == ChatParamUpdateTimeObject.Params.last_message) {
                        if (chatFromServer.last_message != null) {
                            arrayList2.add(chatFromServer.last_message.message_id + BuildConfig.FLAVOR);
                            arrayList.add(ChatColumn.last_message_message_id7.name());
                            arrayList2.add(chatFromServer.last_message.type != null ? chatFromServer.last_message.type + BuildConfig.FLAVOR : null);
                            arrayList.add(ChatColumn.last_message_type8.name());
                            arrayList2.add(chatFromServer.last_message.text);
                            arrayList.add(ChatColumn.last_message_text9.name());
                            arrayList2.add(chatFromServer.last_message.author_object_guid);
                            arrayList.add(ChatColumn.last_message_author_object_guid10.name());
                            arrayList2.add(chatFromServer.last_message.author_type != null ? chatFromServer.last_message.author_type + BuildConfig.FLAVOR : null);
                            arrayList.add(ChatColumn.last_message_author_type11.name());
                            arrayList2.add(chatFromServer.last_message.is_mine ? "1" : "0");
                            arrayList.add(ChatColumn.last_message_is_mine12.name());
                            arrayList2.add(chatFromServer.last_message.author_title);
                            arrayList.add(ChatColumn.last_message_author_title13.name());
                            MetaDataObject metaDataObject = chatFromServer.last_message.metadata;
                            arrayList2.add(metaDataObject != null ? this.jsonHelper.toJson(metaDataObject) : null);
                            arrayList.add(ChatColumn.last_message_metadata_json38.name());
                        } else {
                            arrayList2.add("0");
                            arrayList.add(ChatColumn.last_message_message_id7.name());
                            arrayList2.add(null);
                            arrayList.add(ChatColumn.last_message_type8.name());
                        }
                    } else if (params == ChatParamUpdateTimeObject.Params.last_seen_my_mid) {
                        arrayList2.add(chatFromServer.last_seen_my_mid + BuildConfig.FLAVOR);
                        arrayList.add(ChatColumn.last_seen_my_mid14.name());
                    } else if (params == ChatParamUpdateTimeObject.Params.last_seen_peer_mid) {
                        arrayList2.add(chatFromServer.last_seen_peer_mid + BuildConfig.FLAVOR);
                        arrayList.add(ChatColumn.last_seen_peer_mid15.name());
                    } else if (params == ChatParamUpdateTimeObject.Params.status) {
                        arrayList2.add(chatFromServer.status != null ? chatFromServer.status + BuildConfig.FLAVOR : null);
                        arrayList.add(ChatColumn.status16 + BuildConfig.FLAVOR);
                    } else if (params == ChatParamUpdateTimeObject.Params.abs_object) {
                        if (chatFromServer.abs_object != null) {
                            z = true;
                            arrayList2.add(chatFromServer.abs_object.object_guid + BuildConfig.FLAVOR);
                            arrayList.add(ChatColumn.absObject_object_guid17 + BuildConfig.FLAVOR);
                            arrayList2.add(chatFromServer.abs_object.title);
                            arrayList.add(ChatColumn.absObject_title18 + BuildConfig.FLAVOR);
                            AvatarFileInline avatarFileInline = chatFromServer.abs_object.avatar_thumbnail;
                            if (avatarFileInline != null) {
                                arrayList2.add(avatarFileInline.dc_id);
                                arrayList.add(ChatColumn.avatar_thumbnail_dc_id22 + BuildConfig.FLAVOR);
                                arrayList2.add(chatFromServer.abs_object.avatar_thumbnail.file_id + BuildConfig.FLAVOR);
                                arrayList.add(ChatColumn.avatar_thumbnail_file_id21 + BuildConfig.FLAVOR);
                                arrayList2.add(chatFromServer.abs_object.avatar_thumbnail.access_hash_rec);
                                arrayList.add(ChatColumn.avatar_thumbnail_access_hash_rec23 + BuildConfig.FLAVOR);
                            } else {
                                arrayList2.add("0");
                                arrayList.add(ChatColumn.avatar_thumbnail_file_id21 + BuildConfig.FLAVOR);
                            }
                            arrayList2.add(chatFromServer.abs_object.first_name);
                            arrayList.add(ChatColumn.absObject_first_name19 + BuildConfig.FLAVOR);
                            arrayList2.add(chatFromServer.abs_object.last_name);
                            arrayList.add(ChatColumn.absObject_last_name20 + BuildConfig.FLAVOR);
                            arrayList2.add(chatFromServer.abs_object.is_verified ? "1" : "0");
                            arrayList.add(ChatColumn.absObject_is_verified25 + BuildConfig.FLAVOR);
                            arrayList2.add(chatFromServer.abs_object.is_deleted ? "1" : "0");
                            arrayList.add(ChatColumn.absObject_is_deleted26 + BuildConfig.FLAVOR);
                        } else {
                            arrayList2.add(null);
                            arrayList.add(ChatColumn.absObject_object_guid17 + BuildConfig.FLAVOR);
                        }
                    } else if (params == ChatParamUpdateTimeObject.Params.time) {
                        arrayList2.add(chatFromServer.time + BuildConfig.FLAVOR);
                        arrayList.add(ChatColumn.time27 + BuildConfig.FLAVOR);
                    } else if (params == ChatParamUpdateTimeObject.Params.pinned_message_id) {
                        arrayList2.add(chatFromServer.pinned_message_id + BuildConfig.FLAVOR);
                        arrayList.add(ChatColumn.pinned_message_id28 + BuildConfig.FLAVOR);
                    } else if (params == ChatParamUpdateTimeObject.Params.pinned_message_ids) {
                        arrayList2.add(this.jsonHelper.toJson(chatFromServer.pinned_message_ids));
                        arrayList.add(ChatColumn.pinned_message_ids37 + BuildConfig.FLAVOR);
                    } else if (params == ChatParamUpdateTimeObject.Params.is_blocked) {
                        arrayList2.add(chatFromServer.is_blocked ? "1" : "0");
                        arrayList.add(ChatColumn.is_blocked29 + BuildConfig.FLAVOR);
                    } else if (params == ChatParamUpdateTimeObject.Params.last_message_id) {
                        arrayList2.add(chatFromServer.last_message_id + BuildConfig.FLAVOR);
                        arrayList.add(ChatColumn.last_message_id30 + BuildConfig.FLAVOR);
                    } else if (params == ChatParamUpdateTimeObject.Params.last_deleted_mid) {
                        arrayList2.add(chatFromServer.last_deleted_mid + BuildConfig.FLAVOR);
                        arrayList.add(ChatColumn.last_deleted_mid31 + BuildConfig.FLAVOR);
                    } else if (params == ChatParamUpdateTimeObject.Params.chat_keypad) {
                        KeyPadObject keyPadObject = chatFromServer.chat_keypad;
                        if (keyPadObject != null) {
                            arrayList2.add(this.jsonHelper.toJson(keyPadObject));
                        } else {
                            arrayList2.add(null);
                        }
                        arrayList.add(ChatColumn.chat_keypad_json_32 + BuildConfig.FLAVOR);
                        arrayList2.add(j + BuildConfig.FLAVOR);
                        arrayList.add(ChatColumn.chat_keypad_timestamp_33 + BuildConfig.FLAVOR);
                    } else if (params == ChatParamUpdateTimeObject.Params.slow_mode_duration) {
                        arrayList2.add(chatFromServer.slow_mode_duration + BuildConfig.FLAVOR);
                        arrayList.add(ChatColumn.slow_mode_duration35 + BuildConfig.FLAVOR);
                    } else if (params == ChatParamUpdateTimeObject.Params.group_my_last_send_time) {
                        arrayList2.add(chatFromServer.group_my_last_send_time + BuildConfig.FLAVOR);
                        arrayList.add(ChatColumn.group_my_last_send_time36 + BuildConfig.FLAVOR);
                    } else if (params != ChatParamUpdateTimeObject.Params.group_voice_chat_id) {
                        ChatParamUpdateTimeObject.Params params2 = ChatParamUpdateTimeObject.Params.show_ask_spam;
                    }
                }
            }
        }
        this.db.updateTable(TableName.chatTable.name(), (String[]) arrayList.toArray(new String[arrayList.size()]), (String[]) arrayList2.toArray(new String[arrayList2.size()]), new WhereCondition(ChatColumn.object_guid1 + BuildConfig.FLAVOR, WhereCondition.OperatorEnum.EQ, chatFromServer.object_guid));
        if (z) {
            addAbsObject(chatFromServer.abs_object, chatFromServer.time);
        }
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public ArrayList<Message> getMessagesWithFileInline(String str) {
        return this.db.selectObject(TableName.messageTable.name(), null, new WhereCondition(new WhereCondition(MessageColumn.object_guid1.name(), WhereCondition.OperatorEnum.EQ, str), WhereCondition.OperatorEnum.And, new WhereCondition(MessageColumn.file_inline_file_id6.name(), WhereCondition.OperatorEnum.GT, "0")), null, false, 2000, new DBParser() { // from class: ir.aaap.messengercore.db.DBHelperImpl$$ExternalSyntheticLambda0
            @Override // ir.aaap.messengercore.db.DBParser
            public final Object parse(CursorInterFace cursorInterFace) {
                return this.f$0.lambda$getMessagesWithFileInline$1(cursorInterFace);
            }
        });
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void updateMessageRubinoStory(String str, long j, RubinoStoryData rubinoStoryData) {
        String strName = MessageColumn.object_guid1.name();
        WhereCondition.OperatorEnum operatorEnum = WhereCondition.OperatorEnum.EQ;
        WhereCondition whereCondition = new WhereCondition(new WhereCondition(strName, operatorEnum, str), WhereCondition.OperatorEnum.And, new WhereCondition(MessageColumn.message_id2.name(), operatorEnum, String.valueOf(j)));
        String[] strArr = {MessageColumn.rubino_story_data.name()};
        String[] strArr2 = new String[1];
        strArr2[0] = rubinoStoryData != null ? this.jsonHelper.toJson(rubinoStoryData) : null;
        this.db.updateTable(TableName.messageTable.name(), strArr, strArr2, whereCondition);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void updateMessageRubinoPost(String str, long j, RubinoPostData rubinoPostData) {
        String strName = MessageColumn.object_guid1.name();
        WhereCondition.OperatorEnum operatorEnum = WhereCondition.OperatorEnum.EQ;
        WhereCondition whereCondition = new WhereCondition(new WhereCondition(strName, operatorEnum, str), WhereCondition.OperatorEnum.And, new WhereCondition(MessageColumn.message_id2.name(), operatorEnum, String.valueOf(j)));
        String[] strArr = {MessageColumn.rubino_post_data.name()};
        String[] strArr2 = new String[1];
        strArr2[0] = rubinoPostData != null ? this.jsonHelper.toJson(rubinoPostData) : null;
        this.db.updateTable(TableName.messageTable.name(), strArr, strArr2, whereCondition);
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public void addSentFile(String str, FileInlineObject fileInlineObject, long j) {
        if (fileInlineObject == null || !CoreUtilities.isNotEmpty(str)) {
            return;
        }
        this.db.insertToTable(TableName.sentFileTable.name(), getSentFileColumnArray(), getSentFileValueArray(str, fileInlineObject, j));
    }

    @Override // ir.aaap.messengercore.db.DBHelper
    public FileInlineObject getSentFile(String str) {
        if (!CoreUtilities.isNotEmpty(str)) {
            return null;
        }
        ArrayList arrayListSelectObject = this.db.selectObject(TableName.sentFileTable.name(), null, new WhereCondition(SentFileColumn.path1.name(), WhereCondition.OperatorEnum.EQ, str), null, false, 1, new DBParser() { // from class: ir.aaap.messengercore.db.DBHelperImpl$$ExternalSyntheticLambda2
            @Override // ir.aaap.messengercore.db.DBParser
            public final Object parse(CursorInterFace cursorInterFace) {
                return this.f$0.parseSentFile(cursorInterFace);
            }
        });
        if (arrayListSelectObject != null && !arrayListSelectObject.isEmpty()) {
            return (FileInlineObject) arrayListSelectObject.get(0);
        }
        return new FileInlineObject();
    }
}
