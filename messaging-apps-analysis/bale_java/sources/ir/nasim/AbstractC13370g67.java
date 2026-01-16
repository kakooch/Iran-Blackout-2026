package ir.nasim;

/* renamed from: ir.nasim.g67, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC13370g67 extends AbstractC12724f57 {
    public static AbstractC13370g67 d(T1 t1, int i, boolean z) {
        AbstractC13370g67 c22099uf7;
        switch (i) {
            case -1955338397:
                c22099uf7 = new C22099uf7();
                break;
            case -1198497870:
                c22099uf7 = new C21442tf7();
                break;
            case -463335103:
                c22099uf7 = new C23875xf7();
                break;
            case -135735141:
                c22099uf7 = new C20229rf7();
                break;
            case -125240806:
                c22099uf7 = new C23285wf7();
                break;
            case -123988:
                c22099uf7 = new C20822sf7();
                break;
            case 1103656293:
                c22099uf7 = new C22689vf7();
                break;
            case 1698855810:
                c22099uf7 = new C19031pf7();
                break;
            case 1796427406:
                c22099uf7 = new C19622qf7();
                break;
            default:
                c22099uf7 = null;
                break;
        }
        if (c22099uf7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in PrivacyRule", Integer.valueOf(i)));
        }
        if (c22099uf7 != null) {
            c22099uf7.b(t1, z);
        }
        return c22099uf7;
    }
}
