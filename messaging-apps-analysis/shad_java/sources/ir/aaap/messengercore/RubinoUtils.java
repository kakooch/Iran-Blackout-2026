package ir.aaap.messengercore;

import ir.aaap.messengercore.model.ChatType;
import ir.aaap.messengercore.model.ProductMessageData;
import ir.aaap.messengercore.model.RubinoPostData;
import ir.aaap.messengercore.model.RubinoStoryData;
import ir.aaap.messengercore.model.api.SendProductMessageInput;
import ir.aaap.messengercore.model.api.SendRubinoPostInput;
import ir.aaap.messengercore.model.api.SendRubinoStoryInput;

/* loaded from: classes3.dex */
public interface RubinoUtils {
    SendRubinoPostInput getSendRubinoPostInput(long j, String str, ChatType chatType, boolean z, RubinoPostData rubinoPostData);

    SendProductMessageInput getSendRubinoProductInput(long j, String str, ProductMessageData productMessageData);

    SendRubinoStoryInput getSendRubinoStoryInput(long j, String str, ChatType chatType, boolean z, RubinoStoryData rubinoStoryData);
}
