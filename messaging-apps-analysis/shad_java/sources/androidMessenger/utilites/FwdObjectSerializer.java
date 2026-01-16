package androidMessenger.utilites;

import androidMessenger.proxy.IdStorage;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import org.rbmain.tgnet.TLRPC$Peer;
import org.rbmain.tgnet.TLRPC$TL_peerChannel;
import org.rbmain.tgnet.TLRPC$TL_peerChat;
import org.rbmain.tgnet.TLRPC$TL_peerUser;

/* loaded from: classes.dex */
public class FwdObjectSerializer implements JsonSerializer<TLRPC$Peer> {
    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(TLRPC$Peer tLRPC$Peer, Type type, JsonSerializationContext jsonSerializationContext) {
        if (tLRPC$Peer.user_id != 0) {
            tLRPC$Peer.guid = IdStorage.getInstance().getDialogId(tLRPC$Peer.user_id);
            return jsonSerializationContext.serialize((TLRPC$TL_peerUser) tLRPC$Peer);
        }
        if (tLRPC$Peer.channel_id != 0) {
            tLRPC$Peer.guid = IdStorage.getInstance().getDialogId(-tLRPC$Peer.channel_id);
            return jsonSerializationContext.serialize((TLRPC$TL_peerChannel) tLRPC$Peer);
        }
        if (tLRPC$Peer.chat_id == 0) {
            return null;
        }
        tLRPC$Peer.guid = IdStorage.getInstance().getDialogId(-tLRPC$Peer.chat_id);
        return jsonSerializationContext.serialize((TLRPC$TL_peerChat) tLRPC$Peer);
    }
}
