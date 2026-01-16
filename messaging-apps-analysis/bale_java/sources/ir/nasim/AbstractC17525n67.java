package ir.nasim;

/* renamed from: ir.nasim.n67, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC17525n67 extends AbstractC12724f57 {
    public int b;

    public static AbstractC17525n67 d(T1 t1, int i, boolean z) {
        AbstractC17525n67 c14905ig7;
        switch (i) {
            case -1997373508:
                c14905ig7 = new C14905ig7();
                break;
            case -1884362354:
                c14905ig7 = new C18450og7();
                break;
            case -1845219337:
                c14905ig7 = new C21452tg7();
                break;
            case -1727382502:
                c14905ig7 = new C19632qg7();
                break;
            case -1584933265:
                c14905ig7 = new C15495jg7();
                break;
            case -1441998364:
                c14905ig7 = new C17859ng7();
                break;
            case -1336228175:
                c14905ig7 = new C10480bg7();
                break;
            case -1234857938:
                c14905ig7 = new C11865dg7();
                break;
            case -774682074:
                c14905ig7 = new C19041pg7();
                break;
            case -718310409:
                c14905ig7 = new C14295hg7();
                break;
            case -651419003:
                c14905ig7 = new C22109ug7();
                break;
            case -606432698:
                c14905ig7 = new C13704gg7();
                break;
            case -580219064:
                c14905ig7 = new C12477eg7();
                break;
            case -424899985:
                c14905ig7 = new C17268mg7();
                break;
            case -378127636:
                c14905ig7 = new C20832sg7();
                break;
            case -212740181:
                c14905ig7 = new C16677lg7();
                break;
            case -44119819:
                c14905ig7 = new C9276Zf7();
                break;
            case 381645902:
                c14905ig7 = new C16086kg7();
                break;
            case 393186209:
                c14905ig7 = new C13113fg7();
                break;
            case 608050278:
                c14905ig7 = new C20239rg7();
                break;
            case 630664139:
                c14905ig7 = new C11070cg7();
                break;
            case 1653390447:
                c14905ig7 = new C9860ag7();
                break;
            default:
                c14905ig7 = null;
                break;
        }
        if (c14905ig7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in SendMessageAction", Integer.valueOf(i)));
        }
        if (c14905ig7 != null) {
            c14905ig7.b(t1, z);
        }
        return c14905ig7;
    }
}
