package ir.nasim;

/* renamed from: ir.nasim.m67, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC16934m67 extends AbstractC12724f57 {
    public static AbstractC16934m67 d(T1 t1, int i, boolean z) {
        AbstractC16934m67 c6354Nf7;
        switch (i) {
            case -1995211763:
                c6354Nf7 = new C6354Nf7();
                break;
            case -1954007928:
                c6354Nf7 = new C8501Wf7();
                break;
            case -1908627474:
                c6354Nf7 = new C6848Pf7();
                break;
            case -1717268701:
                c6354Nf7 = new C7326Rf7();
                break;
            case -1713143702:
                c6354Nf7 = new C7797Tf7();
                break;
            case -1658158621:
                c6354Nf7 = new C8033Uf7();
                break;
            case -1596951477:
                c6354Nf7 = new C7092Qf7();
                break;
            case -1289704741:
                c6354Nf7 = new C8267Vf7();
                break;
            case -874308058:
                c6354Nf7 = new C6115Mf7();
                break;
            case -368907213:
                c6354Nf7 = new C8767Xf7();
                break;
            case -63531698:
                c6354Nf7 = new C9042Yf7();
                break;
            case 115615172:
                c6354Nf7 = new C6609Of7();
                break;
            case 1034709504:
                c6354Nf7 = new C7560Sf7();
                break;
            default:
                c6354Nf7 = null;
                break;
        }
        if (c6354Nf7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in SecureValueType", Integer.valueOf(i)));
        }
        if (c6354Nf7 != null) {
            c6354Nf7.b(t1, z);
        }
        return c6354Nf7;
    }
}
