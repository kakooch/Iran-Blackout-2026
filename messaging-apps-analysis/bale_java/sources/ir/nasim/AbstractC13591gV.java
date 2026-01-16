package ir.nasim;

import android.content.Context;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.AvatarImage;

/* renamed from: ir.nasim.gV, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC13591gV {
    public static final C20610sI7 a(CI7 ci7, Context context) {
        AvatarImage secondImage;
        AvatarImage imageDefaultSize;
        AbstractC13042fc3.i(ci7, "<this>");
        AbstractC13042fc3.i(context, "context");
        Avatar avatarA = ci7.a();
        FileReference fileReference = null;
        FileReference fileReference2 = (avatarA == null || (imageDefaultSize = avatarA.getImageDefaultSize()) == null) ? null : imageDefaultSize.getFileReference();
        Avatar avatarA2 = ci7.a();
        if (avatarA2 != null && (secondImage = avatarA2.getSecondImage()) != null) {
            fileReference = secondImage.getFileReference();
        }
        return new C20610sI7(fileReference2, fileReference, new WU(ci7.b(), ci7.c(), 12.0f, context, ci7.e(), true));
    }
}
