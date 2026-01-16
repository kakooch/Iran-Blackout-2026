package ir.nasim;

import android.content.res.Resources;
import ir.nasim.AbstractC19428qK7;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.as2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC9978as2 {
    public static final String a(int i, String str, Resources resources) throws Resources.NotFoundException {
        AbstractC13042fc3.i(str, "folderName");
        AbstractC13042fc3.i(resources, "resource");
        if (i == EnumC7296Rc4.ReservedFolderID_GROUP.getNumber()) {
            String string = resources.getString(FD5.group_folder);
            AbstractC13042fc3.h(string, "getString(...)");
            return string;
        }
        if (i == EnumC7296Rc4.ReservedFolderID_CHANNEL.getNumber()) {
            String string2 = resources.getString(FD5.channel_folder);
            AbstractC13042fc3.h(string2, "getString(...)");
            return string2;
        }
        if (i == EnumC7296Rc4.ReservedFolderID_BOT.getNumber()) {
            String string3 = resources.getString(FD5.bot_folder);
            AbstractC13042fc3.h(string3, "getString(...)");
            return string3;
        }
        if (i == EnumC7296Rc4.ReservedFolderID_PRIVATE.getNumber()) {
            String string4 = resources.getString(FD5.private_folder);
            AbstractC13042fc3.h(string4, "getString(...)");
            return string4;
        }
        if (i == EnumC7296Rc4.ReservedFolderID_ALL.getNumber()) {
            String string5 = resources.getString(FD5.all_folder);
            AbstractC13042fc3.h(string5, "getString(...)");
            return string5;
        }
        if (i != EnumC7296Rc4.ReservedFolderID_UNREAD.getNumber()) {
            return str;
        }
        String string6 = resources.getString(FD5.unread_folder);
        AbstractC13042fc3.h(string6, "getString(...)");
        return string6;
    }

    public static final String b(AbstractC19428qK7 abstractC19428qK7, Resources resources) throws Resources.NotFoundException {
        AbstractC13042fc3.i(abstractC19428qK7, "userType");
        AbstractC13042fc3.i(resources, "resource");
        if (AbstractC13042fc3.d(abstractC19428qK7, AbstractC19428qK7.a.c)) {
            String string = resources.getString(FD5.bot_folder);
            AbstractC13042fc3.h(string, "getString(...)");
            return string;
        }
        if (AbstractC13042fc3.d(abstractC19428qK7, AbstractC19428qK7.b.c)) {
            String string2 = resources.getString(FD5.channel_folder);
            AbstractC13042fc3.h(string2, "getString(...)");
            return string2;
        }
        if (AbstractC13042fc3.d(abstractC19428qK7, AbstractC19428qK7.c.c)) {
            String string3 = resources.getString(FD5.group_folder);
            AbstractC13042fc3.h(string3, "getString(...)");
            return string3;
        }
        if (AbstractC13042fc3.d(abstractC19428qK7, AbstractC19428qK7.d.c)) {
            String string4 = resources.getString(FD5.private_folder);
            AbstractC13042fc3.h(string4, "getString(...)");
            return string4;
        }
        if ((abstractC19428qK7 instanceof AbstractC19428qK7.e) || AbstractC13042fc3.d(abstractC19428qK7, AbstractC19428qK7.f.c)) {
            return "";
        }
        throw new NoWhenBranchMatchedException();
    }
}
