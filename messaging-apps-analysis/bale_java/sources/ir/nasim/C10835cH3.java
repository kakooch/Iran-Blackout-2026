package ir.nasim;

/* renamed from: ir.nasim.cH3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C10835cH3 extends C9625aH3 {
    private AbstractC4970Hi4 i;
    private AbstractC13130fi4 j;
    private String k;

    public C10835cH3(AbstractC4970Hi4 abstractC4970Hi4, C9625aH3 c9625aH3, AbstractC13130fi4 abstractC13130fi4, String str) {
        super(c9625aH3.getFileName(), c9625aH3.u(), c9625aH3.getCaption(), c9625aH3.getFileSize(), c9625aH3.w(), c9625aH3.s(), c9625aH3.z(), c9625aH3.y());
        this.i = abstractC4970Hi4;
        this.j = abstractC13130fi4;
        this.k = str;
    }

    public AbstractC13130fi4 C() {
        return this.j;
    }

    public AbstractC4970Hi4 D() {
        return this.i;
    }

    public String E() {
        return this.k;
    }

    @Override // ir.nasim.C9625aH3, ir.nasim.OG3, ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        super.parse(c19084pl0);
        String strR = c19084pl0.r(12);
        if (strR == null || strR.isEmpty()) {
            this.i = new C19605qe0();
        } else if (strR.startsWith("u") || (strR.length() == 24 && (strR.startsWith("603799") || strR.equals("00000000000000000000000000")))) {
            this.i = new C12104e28(strR);
        } else {
            this.i = new C14057hH0(strR);
        }
        long jI = c19084pl0.i(13);
        String strS = c19084pl0.s(14, "");
        if (strS == null || strS.isEmpty()) {
            this.j = new C17944np2(jI);
        } else {
            try {
                this.j = AbstractC13130fi4.a(strS);
            } catch (Exception unused) {
                this.j = new C17944np2(0L);
            }
        }
        this.k = c19084pl0.s(15, "");
    }

    @Override // ir.nasim.C9625aH3, ir.nasim.OG3, ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        super.serialize(c19675ql0);
        AbstractC4970Hi4 abstractC4970Hi4 = this.i;
        c19675ql0.o(12, abstractC4970Hi4 instanceof C14057hH0 ? ((C14057hH0) abstractC4970Hi4).a() : abstractC4970Hi4 instanceof C12104e28 ? ((C12104e28) abstractC4970Hi4).a() : "");
        AbstractC13130fi4 abstractC13130fi4 = this.j;
        c19675ql0.g(13, abstractC13130fi4 instanceof C17944np2 ? ((C17944np2) abstractC13130fi4).c() : 0L);
        c19675ql0.o(14, this.j.toString());
        String str = this.k;
        if (str != null) {
            c19675ql0.o(15, str);
        }
    }

    public C10835cH3(byte[] bArr) {
        super(bArr);
    }
}
