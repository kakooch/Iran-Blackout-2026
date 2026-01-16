package ir.aaap.messengercore.model;

import ir.aaap.messengercore.utilites.Objects;

/* loaded from: classes3.dex */
public class NotificationModels {

    public static class EditNotificationObject {
        public String edited_text;
        public String notification_id;
        public MetaDataObject text_metadata;
    }

    public static class RemoveNotificationObject {
        public RemoveOneData remove_one_data;
        public RemoveToData remove_to_data;
        public RemoveNotificationTypeEnum type;
    }

    public enum RemoveNotificationTypeEnum {
        RemoveOne,
        RemoveTo
    }

    public static class RemoveOneData {
        public String notification_id;
    }

    public static class RemoveToData {
        public String object_guid;
        public ChatType object_type;
        public long to_message_id;
        public long to_time;
    }

    public enum ShowNotificationTypeEnum {
        Message,
        NotMessage,
        Other
    }

    public static class ShowNotificationObject {
        public long image_file_id;
        public MessageDataObject message_data;
        public NotMessageDataObject not_message_data;
        public String notification_id;
        public NotificationOtherDataObject other_data;
        public long receivedTime;
        public String text;
        public MetaDataObject text_metadata;
        public String title;
        public ShowNotificationTypeEnum type;

        public String getObjectGuid() {
            NotMessageDataObject notMessageDataObject;
            MessageDataObject messageDataObject;
            ShowNotificationTypeEnum showNotificationTypeEnum = this.type;
            if (showNotificationTypeEnum == null) {
                return null;
            }
            if (showNotificationTypeEnum == ShowNotificationTypeEnum.Message && (messageDataObject = this.message_data) != null) {
                return messageDataObject.object_guid;
            }
            if (showNotificationTypeEnum != ShowNotificationTypeEnum.NotMessage || (notMessageDataObject = this.not_message_data) == null) {
                return null;
            }
            return notMessageDataObject.object_guid;
        }

        public ChatType getObjectType() {
            NotMessageDataObject notMessageDataObject;
            MessageDataObject messageDataObject;
            ShowNotificationTypeEnum showNotificationTypeEnum = this.type;
            if (showNotificationTypeEnum == null) {
                return null;
            }
            if (showNotificationTypeEnum == ShowNotificationTypeEnum.Message && (messageDataObject = this.message_data) != null) {
                return messageDataObject.object_type;
            }
            if (showNotificationTypeEnum != ShowNotificationTypeEnum.NotMessage || (notMessageDataObject = this.not_message_data) == null) {
                return null;
            }
            return notMessageDataObject.object_type;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShowNotificationObject)) {
                return false;
            }
            ShowNotificationObject showNotificationObject = (ShowNotificationObject) obj;
            return this.image_file_id == showNotificationObject.image_file_id && Objects.equals(this.notification_id, showNotificationObject.notification_id) && this.type == showNotificationObject.type && Objects.equals(this.title, showNotificationObject.title) && Objects.equals(this.text, showNotificationObject.text) && Objects.equals(this.message_data, showNotificationObject.message_data) && Objects.equals(this.not_message_data, showNotificationObject.not_message_data) && Objects.equals(this.other_data, showNotificationObject.other_data);
        }
    }

    public static class NotificationOtherDataObject {
        public Link notif_link;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof NotificationOtherDataObject) {
                return Objects.equals(this.notif_link, ((NotificationOtherDataObject) obj).notif_link);
            }
            return false;
        }
    }

    public static class ToRemoveNotificationObject {
        public String notification_id;
        public String object_guid;
        public ChatType object_type;

        public ToRemoveNotificationObject(String str, String str2, ChatType chatType) {
            this.notification_id = str;
            this.object_guid = str2;
            this.object_type = chatType;
        }
    }

    public static class MessageDataObject {
        public long message_id;
        public String object_guid;
        public ChatType object_type;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MessageDataObject)) {
                return false;
            }
            MessageDataObject messageDataObject = (MessageDataObject) obj;
            return this.message_id == messageDataObject.message_id && Objects.equals(this.object_guid, messageDataObject.object_guid) && this.object_type == messageDataObject.object_type;
        }
    }

    public static class NotMessageDataObject {
        public String object_guid;
        public ChatType object_type;
        public long time;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof NotMessageDataObject)) {
                return false;
            }
            NotMessageDataObject notMessageDataObject = (NotMessageDataObject) obj;
            return this.time == notMessageDataObject.time && Objects.equals(this.object_guid, notMessageDataObject.object_guid) && this.object_type == notMessageDataObject.object_type;
        }
    }
}
