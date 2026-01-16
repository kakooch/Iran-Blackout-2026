package ir.nasim;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Ge3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC4699Ge3 {

    /* renamed from: ir.nasim.Ge3$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC5360Iz7.values().length];
            try {
                iArr[EnumC5360Iz7.d.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC5360Iz7.e.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC5360Iz7.f.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC5360Iz7.h.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnumC5360Iz7.g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EnumC5360Iz7.i.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[EnumC5360Iz7.j.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[EnumC5360Iz7.l.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[EnumC5360Iz7.m.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[EnumC5360Iz7.k.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[EnumC5360Iz7.n.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[EnumC5360Iz7.c.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            a = iArr;
        }
    }

    public static final String a(Context context, ArrayList arrayList, String str) {
        AbstractC13042fc3.i(context, "ctx");
        AbstractC13042fc3.i(arrayList, "groupTypingState");
        AbstractC13042fc3.i(str, "firstUserName");
        if (arrayList.isEmpty()) {
            return "";
        }
        if (arrayList.size() == 1) {
            String string = context.getString(AbstractC12217eE5.group_typing_single_member, str, b(context, ((C11661dO2) AbstractC15401jX0.q0(arrayList)).a()));
            AbstractC13042fc3.h(string, "getString(...)");
            return string;
        }
        if (c(arrayList)) {
            String string2 = context.getString(AbstractC12217eE5.group_chat_members_typing_many_members, str, XY6.v(String.valueOf(arrayList.size() - 1)), b(context, ((C11661dO2) AbstractC15401jX0.q0(arrayList)).a()));
            AbstractC13042fc3.h(string2, "getString(...)");
            return string2;
        }
        String string3 = context.getString(AbstractC12217eE5.group_chat_members_typing_many_members, str, XY6.v(String.valueOf(arrayList.size() - 1)), context.getString(AbstractC12217eE5.chat_sending_message));
        AbstractC13042fc3.h(string3, "getString(...)");
        return string3;
    }

    public static final String b(Context context, EnumC5360Iz7 enumC5360Iz7) {
        AbstractC13042fc3.i(context, "ctx");
        switch (enumC5360Iz7 == null ? -1 : a.a[enumC5360Iz7.ordinal()]) {
            case 1:
                String string = context.getString(AbstractC12217eE5.chat_voice_recording);
                AbstractC13042fc3.h(string, "getString(...)");
                return string;
            case 2:
                String string2 = context.getString(AbstractC12217eE5.chat_sending_voice);
                AbstractC13042fc3.h(string2, "getString(...)");
                return string2;
            case 3:
                String string3 = context.getString(AbstractC12217eE5.chat_sending_file);
                AbstractC13042fc3.h(string3, "getString(...)");
                return string3;
            case 4:
                String string4 = context.getString(AbstractC12217eE5.chat_sending_album);
                AbstractC13042fc3.h(string4, "getString(...)");
                return string4;
            case 5:
                String string5 = context.getString(AbstractC12217eE5.chat_sending_photo);
                AbstractC13042fc3.h(string5, "getString(...)");
                return string5;
            case 6:
                String string6 = context.getString(AbstractC12217eE5.chat_sending_video);
                AbstractC13042fc3.h(string6, "getString(...)");
                return string6;
            case 7:
                String string7 = context.getString(AbstractC12217eE5.chat_sending_music);
                AbstractC13042fc3.h(string7, "getString(...)");
                return string7;
            case 8:
                String string8 = context.getString(AbstractC12217eE5.chat_sending_sticker);
                AbstractC13042fc3.h(string8, "getString(...)");
                return string8;
            case 9:
                String string9 = context.getString(AbstractC12217eE5.chat_sending_gif);
                AbstractC13042fc3.h(string9, "getString(...)");
                return string9;
            case 10:
                String string10 = context.getString(AbstractC12217eE5.chat_sending_emoji);
                AbstractC13042fc3.h(string10, "getString(...)");
                return string10;
            case 11:
                String string11 = context.getString(AbstractC12217eE5.chat_creating_gift_packet);
                AbstractC13042fc3.h(string11, "getString(...)");
                return string11;
            case 12:
                String string12 = context.getString(AbstractC12217eE5.chat_typing);
                AbstractC13042fc3.h(string12, "getString(...)");
                return string12;
            default:
                String string13 = context.getString(AbstractC12217eE5.chat_typing);
                AbstractC13042fc3.h(string13, "getString(...)");
                return string13;
        }
    }

    private static final boolean c(List list) {
        EnumC5360Iz7 enumC5360Iz7A;
        if (list.size() < 2) {
            return true;
        }
        List listP1 = AbstractC15401jX0.p1(list);
        C11661dO2 c11661dO2 = (C11661dO2) AbstractC15401jX0.s0(listP1);
        if (c11661dO2 == null || (enumC5360Iz7A = c11661dO2.a()) == null) {
            return true;
        }
        List list2 = listP1;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return true;
        }
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            if (((C11661dO2) it.next()).a() != enumC5360Iz7A) {
                return false;
            }
        }
        return true;
    }

    public static final boolean d(EnumC5360Iz7 enumC5360Iz7) {
        AbstractC13042fc3.i(enumC5360Iz7, "typingType");
        return enumC5360Iz7 == EnumC5360Iz7.b;
    }
}
