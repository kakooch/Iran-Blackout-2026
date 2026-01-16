package org.rbmain.ui.Components.Reactions;

import android.text.TextUtils;
import org.rbmain.tgnet.TLRPC$Reaction;
import org.rbmain.tgnet.TLRPC$TL_reactionCustomEmoji;
import org.rbmain.tgnet.TLRPC$TL_reactionEmoji;
import org.rbmain.ui.Components.Reactions.ReactionsLayoutInBubble;

/* loaded from: classes5.dex */
public class ReactionsUtils {
    public static boolean compare(TLRPC$Reaction tLRPC$Reaction, ReactionsLayoutInBubble.VisibleReaction visibleReaction) {
        if ((tLRPC$Reaction instanceof TLRPC$TL_reactionEmoji) && visibleReaction.documentId == 0 && TextUtils.equals(((TLRPC$TL_reactionEmoji) tLRPC$Reaction).emoticon, visibleReaction.emojicon)) {
            return true;
        }
        if (!(tLRPC$Reaction instanceof TLRPC$TL_reactionCustomEmoji)) {
            return false;
        }
        long j = visibleReaction.documentId;
        return j != 0 && ((TLRPC$TL_reactionCustomEmoji) tLRPC$Reaction).document_id == j;
    }

    public static TLRPC$Reaction toTLReaction(ReactionsLayoutInBubble.VisibleReaction visibleReaction) {
        if (visibleReaction.emojicon != null) {
            TLRPC$TL_reactionEmoji tLRPC$TL_reactionEmoji = new TLRPC$TL_reactionEmoji();
            tLRPC$TL_reactionEmoji.emoticon = visibleReaction.emojicon;
            return tLRPC$TL_reactionEmoji;
        }
        TLRPC$TL_reactionCustomEmoji tLRPC$TL_reactionCustomEmoji = new TLRPC$TL_reactionCustomEmoji();
        tLRPC$TL_reactionCustomEmoji.document_id = visibleReaction.documentId;
        return tLRPC$TL_reactionCustomEmoji;
    }
}
