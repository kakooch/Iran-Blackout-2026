package ir.nasim;

import ir.nasim.C9475a16;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.database.entity.ContactEntity;

/* renamed from: ir.nasim.oY, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC18364oY {
    public static final Avatar a(ContactEntity contactEntity) {
        Object objB;
        AbstractC13042fc3.i(contactEntity, "<this>");
        try {
            C9475a16.a aVar = C9475a16.b;
            byte[] avatarByte = contactEntity.getAvatarByte();
            objB = C9475a16.b(avatarByte != null ? (Avatar) AbstractC16720ll0.b(new Avatar(), avatarByte) : null);
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        return (Avatar) (C9475a16.g(objB) ? null : objB);
    }
}
