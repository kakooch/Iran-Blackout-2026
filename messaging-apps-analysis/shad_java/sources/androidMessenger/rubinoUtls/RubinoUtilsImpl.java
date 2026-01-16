package androidMessenger.rubinoUtls;

import android.text.TextUtils;
import ir.aaap.messengercore.RubinoUtils;
import ir.aaap.messengercore.model.ChatType;
import ir.aaap.messengercore.model.ProductMessageData;
import ir.aaap.messengercore.model.RubinoPostData;
import ir.aaap.messengercore.model.RubinoStoryData;
import ir.aaap.messengercore.model.api.SendProductMessageInput;
import ir.aaap.messengercore.model.api.SendRubinoPostInput;
import ir.aaap.messengercore.model.api.SendRubinoStoryInput;
import ir.appp.rghapp.Utils;
import ir.resaneh1.iptv.model.RubinoStoryData;

/* loaded from: classes.dex */
public class RubinoUtilsImpl implements RubinoUtils {
    public RubinoUtilsImpl(int i) {
    }

    @Override // ir.aaap.messengercore.RubinoUtils
    public SendRubinoPostInput getSendRubinoPostInput(long j, String str, ChatType chatType, boolean z, RubinoPostData rubinoPostData) {
        if (rubinoPostData == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ir.resaneh1.iptv.model.RubinoPostData rubinoPostData2 = (ir.resaneh1.iptv.model.RubinoPostData) Utils.convertMapToObject(rubinoPostData, ir.resaneh1.iptv.model.RubinoPostData.class);
        SendRubinoPostInput sendRubinoPostInput = new SendRubinoPostInput();
        sendRubinoPostInput.object_guid = str;
        sendRubinoPostInput.post_id = rubinoPostData2.post_id;
        sendRubinoPostInput.post_profile_id = rubinoPostData2.post_profile_id;
        sendRubinoPostInput.rnd = j;
        sendRubinoPostInput.is_mute = z;
        return sendRubinoPostInput;
    }

    @Override // ir.aaap.messengercore.RubinoUtils
    public SendRubinoStoryInput getSendRubinoStoryInput(long j, String str, ChatType chatType, boolean z, RubinoStoryData rubinoStoryData) {
        if (rubinoStoryData == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ir.resaneh1.iptv.model.RubinoStoryData rubinoStoryData2 = (ir.resaneh1.iptv.model.RubinoStoryData) Utils.convertMapToObject(rubinoStoryData, ir.resaneh1.iptv.model.RubinoStoryData.class);
        SendRubinoStoryInput sendRubinoStoryInput = new SendRubinoStoryInput();
        sendRubinoStoryInput.object_guid = str;
        sendRubinoStoryInput.story_id = rubinoStoryData2.story_id;
        sendRubinoStoryInput.story_profile_id = rubinoStoryData2.story_profile_id;
        sendRubinoStoryInput.rnd = j;
        sendRubinoStoryInput.is_mute = z;
        sendRubinoStoryInput.type = rubinoStoryData2.type == RubinoStoryData.Type.Direct ? RubinoStoryData.Type.Direct : RubinoStoryData.Type.Reply;
        sendRubinoStoryInput.reply_text = rubinoStoryData2.reply_text;
        return sendRubinoStoryInput;
    }

    @Override // ir.aaap.messengercore.RubinoUtils
    public SendProductMessageInput getSendRubinoProductInput(long j, String str, ProductMessageData productMessageData) {
        if (productMessageData == null || TextUtils.isEmpty(str)) {
            return null;
        }
        SendProductMessageInput sendProductMessageInput = new SendProductMessageInput();
        sendProductMessageInput.object_guid = str;
        sendProductMessageInput.store_id = productMessageData.store_id;
        sendProductMessageInput.product_id = productMessageData.product_id;
        sendProductMessageInput.product_varieties = productMessageData.product_varieties;
        sendProductMessageInput.rnd = j;
        return sendProductMessageInput;
    }
}
