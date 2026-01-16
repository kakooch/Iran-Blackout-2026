package ir.aaap.messengercore.model;

import ir.aaap.messengercore.model.ChatParamUpdateTimeObject;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class ChatNeedReloadResult {
    public ArrayList<String> deleteChats;
    public ArrayList<String> newChats;
    public TypeEnum typeEnum;
    public Map<String, Set<ChatParamUpdateTimeObject.Params>> updatedChats;

    public enum TypeEnum {
        AllListUpdated,
        SomeChatsUpdated,
        hasError
    }

    public ChatNeedReloadResult(TypeEnum typeEnum) {
        this.typeEnum = typeEnum;
    }
}
