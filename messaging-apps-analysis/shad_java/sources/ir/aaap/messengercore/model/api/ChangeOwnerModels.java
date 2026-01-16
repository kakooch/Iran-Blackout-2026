package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.ChatUpdateObject;

/* loaded from: classes3.dex */
public class ChangeOwnerModels {

    public enum ActionEnum {
        Accept,
        Reject
    }

    public static class CancelChangeOwnerOutput {
    }

    public static class GetPendingObjectOwnerOutput {
        public boolean exist_pending_owner;
        public String pending_owner_user_guid;
    }

    public static class ReplyRequestObjectOwnerInput {
        public ActionEnum action;
        public String object_guid;
    }

    public static class ReplyRequestObjectOwnerOutput {
        public ChatUpdateObject chat_update;
    }

    public static class RequestChangeOwnerInput {
        public String new_owner_user_guid;
        public String object_guid;
    }

    public static class RequestChangeOwnerOutput {
        public StatusEnum status;
    }

    public enum StatusEnum {
        OK,
        RequestExist
    }

    public static class CancelChangeOwnerInput {
        public String object_guid;

        public CancelChangeOwnerInput(String str) {
            this.object_guid = str;
        }
    }

    public static class GetPendingObjectOwnerInput {
        public String object_guid;

        public GetPendingObjectOwnerInput(String str) {
            this.object_guid = str;
        }
    }
}
