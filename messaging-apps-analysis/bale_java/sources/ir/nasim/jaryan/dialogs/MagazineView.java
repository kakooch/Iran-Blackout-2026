package ir.nasim.jaryan.dialogs;

import android.content.Context;
import android.widget.FrameLayout;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.C15903kN1;
import ir.nasim.C17067mL1;
import ir.nasim.IM3;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.AvatarImage;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0006R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lir/nasim/jaryan/dialogs/MagazineView;", "Landroid/widget/FrameLayout;", "Lir/nasim/mL1;", "dialog", "Lir/nasim/rB7;", "setMessageText", "(Lir/nasim/mL1;)V", "setTitleText", "setAvatar", "Lir/nasim/IM3;", "binding", "Lir/nasim/IM3;", "getBinding", "()Lir/nasim/IM3;", "setBinding", "(Lir/nasim/IM3;)V", "jaryan_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class MagazineView extends FrameLayout {
    private final void setAvatar(C17067mL1 dialog) {
        AvatarImage imageDefaultSize;
        Avatar avatarH = dialog.H();
        if (avatarH == null || (imageDefaultSize = avatarH.getImageDefaultSize()) == null) {
            return;
        }
        AbstractC5969Lp4.d().q(imageDefaultSize.getFileReference(), true, null);
    }

    private final void setMessageText(C17067mL1 dialog) {
        Context context = getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        C15903kN1.c(context, dialog);
        throw null;
    }

    private final void setTitleText(C17067mL1 dialog) {
        throw null;
    }

    public final IM3 getBinding() {
        return null;
    }

    public final void setBinding(IM3 im3) {
        AbstractC13042fc3.i(im3, "<set-?>");
    }
}
