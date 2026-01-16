package androidMessenger.utilites;

import androidMessenger.proxy.IdStorage;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import org.rbmain.tgnet.TLRPC$Peer;
import org.rbmain.tgnet.TLRPC$TL_peerChannel;
import org.rbmain.tgnet.TLRPC$TL_peerChat;
import org.rbmain.tgnet.TLRPC$TL_peerUser;

/* loaded from: classes.dex */
public class FwdObjectDeserializer implements JsonDeserializer<TLRPC$Peer> {
    @Override // com.google.gson.JsonDeserializer
    public TLRPC$Peer deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (jsonElement.getAsJsonObject().get("guid") == null) {
            return null;
        }
        int asInt = jsonElement.getAsJsonObject().get("user_id").getAsInt();
        int asInt2 = jsonElement.getAsJsonObject().get("chat_id").getAsInt();
        int asInt3 = jsonElement.getAsJsonObject().get("channel_id").getAsInt();
        if (asInt != 0) {
            TLRPC$Peer tLRPC$Peer = (TLRPC$Peer) jsonDeserializationContext.deserialize(jsonElement, TLRPC$TL_peerUser.class);
            tLRPC$Peer.user_id = (int) IdStorage.getInstance().generateDialogId(tLRPC$Peer.guid);
            return tLRPC$Peer;
        }
        if (asInt3 != 0) {
            TLRPC$Peer tLRPC$Peer2 = (TLRPC$Peer) jsonDeserializationContext.deserialize(jsonElement, TLRPC$TL_peerChannel.class);
            tLRPC$Peer2.channel_id = (int) (-IdStorage.getInstance().generateNegativeDialogId(tLRPC$Peer2.guid));
            return tLRPC$Peer2;
        }
        if (asInt2 == 0) {
            return null;
        }
        TLRPC$Peer tLRPC$Peer3 = (TLRPC$Peer) jsonDeserializationContext.deserialize(jsonElement, TLRPC$TL_peerChat.class);
        tLRPC$Peer3.chat_id = (int) (-IdStorage.getInstance().generateNegativeDialogId(tLRPC$Peer3.guid));
        return tLRPC$Peer3;
    }
}
