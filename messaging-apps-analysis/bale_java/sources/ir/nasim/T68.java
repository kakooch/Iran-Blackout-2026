package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeer;

/* loaded from: classes5.dex */
public abstract class T68 {
    private final int a;
    private final EnumC23552x68 b;
    private final C24732z68 c;

    public static final class a extends T68 {
        private final String d;
        private final String e;
        private final ExPeer f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, ExPeer exPeer, int i, EnumC23552x68 enumC23552x68, C24732z68 c24732z68) {
            super(i, enumC23552x68, c24732z68, null);
            AbstractC13042fc3.i(str, "shortName");
            AbstractC13042fc3.i(enumC23552x68, "screenMode");
            AbstractC13042fc3.i(c24732z68, "themeParams");
            this.d = str;
            this.e = str2;
            this.f = exPeer;
        }

        public final ExPeer d() {
            return this.f;
        }

        public final String e() {
            return this.d;
        }

        public final String f() {
            return this.e;
        }
    }

    public static final class b extends T68 {
        private final String d;
        private final ExPeer e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, ExPeer exPeer, int i, EnumC23552x68 enumC23552x68, C24732z68 c24732z68) {
            super(i, enumC23552x68, c24732z68, null);
            AbstractC13042fc3.i(enumC23552x68, "screenMode");
            AbstractC13042fc3.i(c24732z68, "themeParams");
            this.d = str;
            this.e = exPeer;
        }

        public final ExPeer d() {
            return this.e;
        }

        public final String e() {
            return this.d;
        }
    }

    public static final class c extends T68 {
        private final String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, int i, EnumC23552x68 enumC23552x68, C24732z68 c24732z68) {
            super(i, enumC23552x68, c24732z68, null);
            AbstractC13042fc3.i(enumC23552x68, "screenMode");
            AbstractC13042fc3.i(c24732z68, "themeParams");
            this.d = str;
        }

        public final String d() {
            return this.d;
        }
    }

    public static final class d extends T68 {
        private final String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, int i, EnumC23552x68 enumC23552x68, C24732z68 c24732z68) {
            super(i, enumC23552x68, c24732z68, null);
            AbstractC13042fc3.i(str, "url");
            AbstractC13042fc3.i(enumC23552x68, "screenMode");
            AbstractC13042fc3.i(c24732z68, "themeParams");
            this.d = str;
        }

        public final String d() {
            return this.d;
        }
    }

    public /* synthetic */ T68(int i, EnumC23552x68 enumC23552x68, C24732z68 c24732z68, ED1 ed1) {
        this(i, enumC23552x68, c24732z68);
    }

    public final int a() {
        return this.a;
    }

    public final EnumC23552x68 b() {
        return this.b;
    }

    public final C24732z68 c() {
        return this.c;
    }

    private T68(int i, EnumC23552x68 enumC23552x68, C24732z68 c24732z68) {
        this.a = i;
        this.b = enumC23552x68;
        this.c = c24732z68;
    }
}
