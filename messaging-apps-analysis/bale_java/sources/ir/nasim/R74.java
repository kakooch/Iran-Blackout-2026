package ir.nasim;

import android.content.Context;
import android.util.Log;
import ir.nasim.C9475a16;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.AvatarImage;

/* loaded from: classes5.dex */
public final class R74 implements InterfaceC14123hO3 {
    private final Context a;
    private final InterfaceC11621dJ7 b;

    public R74(Context context, InterfaceC11621dJ7 interfaceC11621dJ7) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(interfaceC11621dJ7, "userRepository");
        this.a = context;
        this.b = interfaceC11621dJ7;
    }

    private final WU b(C17637nI7 c17637nI7) {
        String name = c17637nI7 != null ? c17637nI7.getName() : null;
        if (name == null) {
            name = "";
        }
        return new WU(name, c17637nI7 != null ? c17637nI7.n0() : 0, 18.0f, this.a, c17637nI7 != null ? c17637nI7.r0() : false, true);
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C20610sI7 a(J44 j44) {
        Object objB;
        AvatarImage secondImage;
        AvatarImage imageDefaultSize;
        AbstractC13042fc3.i(j44, "input");
        if (j44.g0()) {
            return null;
        }
        C17637nI7 c17637nI7P = this.b.p(j44.U());
        Avatar avatarS = c17637nI7P != null ? c17637nI7P.S() : null;
        if (c17637nI7P == null) {
            Log.d("NullUser", "rid:" + j44.i() + " does not have any SenderId:  " + j44.U());
        }
        try {
            C9475a16.a aVar = C9475a16.b;
            objB = C9475a16.b(new C20610sI7((avatarS == null || (imageDefaultSize = avatarS.getImageDefaultSize()) == null) ? null : imageDefaultSize.getFileReference(), (avatarS == null || (secondImage = avatarS.getSecondImage()) == null) ? null : secondImage.getFileReference(), b(c17637nI7P)));
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        if (C9475a16.e(objB) != null) {
            objB = new C20610sI7(null, null, new WU("", 0, 18.0f, this.a, false, true));
        }
        return (C20610sI7) objB;
    }
}
