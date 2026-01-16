package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.data.model.story.PostToStoryOrigin;
import ir.nasim.data.model.story.PostToStoryStoryType;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.HashMap;

/* renamed from: ir.nasim.wQ6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C23144wQ6 {
    public static final C23144wQ6 a = new C23144wQ6();
    private static long b = System.currentTimeMillis();
    public static final int c = 8;

    /* renamed from: ir.nasim.wQ6$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[EnumC17253mf2.values().length];
            try {
                iArr[EnumC17253mf2.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC17253mf2.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
            int[] iArr2 = new int[EnumC10088b35.values().length];
            try {
                iArr2[EnumC10088b35.ExPeerType_BOT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[EnumC10088b35.ExPeerType_GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[EnumC10088b35.ExPeerType_CHANNEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[EnumC10088b35.ExPeerType_PRIVATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            b = iArr2;
        }
    }

    private C23144wQ6() {
    }

    public final void a(int i, int i2, int i3, long j, PostToStoryOrigin postToStoryOrigin, PostToStoryStoryType postToStoryStoryType, EnumC11893dj5 enumC11893dj5, String str, Integer num) {
        AbstractC13042fc3.i(postToStoryOrigin, "origin");
        AbstractC13042fc3.i(postToStoryStoryType, "storyType");
        AbstractC13042fc3.i(enumC11893dj5, "actionType");
        HashMap map = new HashMap();
        map.put("random_id", Integer.valueOf(i));
        map.put(DialogEntity.COLUMN_RID, Long.valueOf(j));
        map.put("channel_id", Integer.valueOf(i2));
        map.put("peer_type", Integer.valueOf(i3));
        map.put("origin", Integer.valueOf(postToStoryOrigin.getIndex()));
        map.put("action_type", Integer.valueOf(enumC11893dj5.j()));
        map.put("story_type", Integer.valueOf(postToStoryStoryType.getIndex()));
        if (str != null) {
            map.put("story_id", str);
        }
        if (num != null) {
            map.put("file_size", Integer.valueOf(num.intValue()));
        }
        C3343Am.i("add_post_on_story", map);
    }

    public final void b(EnumC17253mf2 enumC17253mf2) {
        AbstractC13042fc3.i(enumC17253mf2, "hafezFaalEventStatus");
        HashMap map = new HashMap();
        boolean z = true;
        map.put("origin", 1);
        int i = a.a[enumC17253mf2.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return;
            } else {
                z = false;
            }
        }
        map.put("request_status", Boolean.valueOf(z));
        C3343Am.i("yalda", map);
    }

    public final void c(String str) {
        AbstractC13042fc3.i(str, "storyId");
        HashMap map = new HashMap();
        map.put("event_type", "join");
        map.put("story_id", str);
        C3343Am.i("story_tab_click", map);
    }

    public final void d(String str) {
        AbstractC13042fc3.i(str, "storyId");
        HashMap map = new HashMap();
        map.put("action_type", 1);
        map.put("story_id", str);
        C3343Am.i("status_most_view", map);
    }

    public final void e(String str) {
        AbstractC13042fc3.i(str, "storyId");
        HashMap map = new HashMap();
        map.put("event_type", "profile_view");
        map.put("story_id", str);
        C3343Am.i("story_tab_click", map);
    }

    public final void f() {
        HashMap map = new HashMap();
        map.put("event_type", "reply");
        C3343Am.i("story_tab_click", map);
    }

    public final void g(String str) {
        AbstractC13042fc3.i(str, "eventType");
        HashMap map = new HashMap();
        map.put("event_type", str);
        C3343Am.i("text_status", map);
    }

    public final void h(int i, int i2, int i3, int i4) {
        HashMap map = new HashMap();
        map.put("user_get_status", Integer.valueOf(i));
        map.put("channel_get_status", Integer.valueOf(i2));
        map.put("group_get_status", Integer.valueOf(i3));
        map.put("bot_get_status", Integer.valueOf(i4));
        C3343Am.i("get_status_client", map);
    }

    public final void i(int i, int i2, String str, Integer num, Integer num2, String str2, Integer num3, Integer num4, EnumC10088b35 enumC10088b35) {
        AbstractC13042fc3.i(str2, "storyId");
        HashMap map = new HashMap();
        map.put("random_id", Integer.valueOf(i));
        map.put("action_type", Integer.valueOf(i2));
        if (!(!AbstractC20762sZ6.n0(str2))) {
            str2 = null;
        }
        if (str2 != null) {
            map.put("story_id", str2);
        }
        if (str != null) {
            map.put("event_type", str);
        }
        if (num != null) {
            map.put("story_type", Integer.valueOf(num.intValue()));
        }
        if (num2 != null) {
            map.put("category_type", Integer.valueOf(num2.intValue()));
        }
        if (num3 != null) {
            map.put("channel_id", Integer.valueOf(num3.intValue()));
        }
        if (num4 != null) {
            map.put("file_size", Integer.valueOf(num4.intValue()));
        }
        if (enumC10088b35 != null) {
            int i3 = a.b[enumC10088b35.ordinal()];
            map.put("peer_type", Integer.valueOf((i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? ExPeerType.UNKNOWN : ExPeerType.PRIVATE : ExPeerType.CHANNEL : ExPeerType.GROUP : ExPeerType.BOT).getValue()));
        }
        C3343Am.i("client_story", map);
    }

    public final void k(YV6 yv6, WV6 wv6, Integer num, XV6 xv6, String str, Integer num2, Integer num3, EnumC10088b35 enumC10088b35) {
        AbstractC13042fc3.i(yv6, "eventType");
        AbstractC13042fc3.i(str, "storyId");
        HashMap map = new HashMap();
        if (num2 != null) {
            map.put("random_id", Integer.valueOf(num2.intValue()));
        }
        map.put("story_id", str);
        map.put("event_type", yv6.j());
        if (wv6 != null) {
            map.put("origin", Integer.valueOf(wv6.j()));
        }
        if (num != null) {
            map.put("index", Integer.valueOf(num.intValue()));
        }
        if (xv6 != null) {
            map.put("story_type", Integer.valueOf(xv6.j()));
        }
        if (num3 != null) {
            map.put("file_size", Integer.valueOf(num3.intValue()));
        }
        if (enumC10088b35 != null) {
            int i = a.b[enumC10088b35.ordinal()];
            map.put("peer_type", Integer.valueOf((i != 1 ? i != 2 ? i != 3 ? i != 4 ? ExPeerType.UNKNOWN : ExPeerType.PRIVATE : ExPeerType.CHANNEL : ExPeerType.GROUP : ExPeerType.BOT).getValue()));
        }
        C3343Am.i("origin_view_story", map);
    }

    public final void l() {
        C3343Am.i("tooltip_story", AbstractC19460qO3.g(AbstractC4616Fw7.a("action_type", 3)));
    }
}
