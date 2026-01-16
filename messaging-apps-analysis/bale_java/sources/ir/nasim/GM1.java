package ir.nasim;

import ir.nasim.AbstractC25195zt3;
import ir.nasim.dialoglist.data.model.DialogDTO;

/* loaded from: classes5.dex */
public abstract class GM1 {
    public static final int a(DialogDTO dialogDTO) {
        AbstractC13042fc3.i(dialogDTO, "<this>");
        return C11458d25.r(dialogDTO.getPeerUniqueId()).getPeerId();
    }

    public static final C15321jO1 b(DialogDTO dialogDTO) {
        AbstractC13042fc3.i(dialogDTO, "<this>");
        String formattedTime = dialogDTO.getFormattedTime();
        boolean zIsPinned = dialogDTO.isPinned();
        boolean markAsUnread = dialogDTO.getMarkAsUnread();
        return new C15321jO1(formattedTime, zIsPinned, dialogDTO.getUnreadMessageCount(), markAsUnread, dialogDTO.isMuted(), dialogDTO.getHasMention(), dialogDTO.getLastReactionEmoji(), dialogDTO.getMessageState(), Boolean.valueOf((!AbstractC13042fc3.d(dialogDTO.getLastMessageIsMine(), Boolean.TRUE) || (dialogDTO.getPreviewLastMessage() instanceof AbstractC25195zt3.d) || (dialogDTO.getPreviewLastMessage() instanceof AbstractC25195zt3.c)) ? false : true), dialogDTO.getHasMainWebApp(), dialogDTO.isFormalDialog(), dialogDTO.getFormalDialogsMaxUnreadCount());
    }

    public static final JI7 c(DialogDTO dialogDTO) {
        AbstractC13042fc3.i(dialogDTO, "<this>");
        return new JI7(dialogDTO.getUserType(), dialogDTO.isMuted());
    }
}
