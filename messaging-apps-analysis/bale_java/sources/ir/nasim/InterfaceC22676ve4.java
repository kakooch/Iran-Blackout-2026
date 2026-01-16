package ir.nasim;

/* renamed from: ir.nasim.ve4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC22676ve4 {
    public static final InterfaceC22676ve4 a = new a();

    /* renamed from: ir.nasim.ve4$a */
    class a implements InterfaceC22676ve4 {
        a() {
        }

        @Override // ir.nasim.InterfaceC22676ve4
        public InterfaceC22086ue4 a(com.google.android.exoplayer2.X x) {
            String str = x.l;
            if (str != null) {
                switch (str) {
                    case "application/vnd.dvb.ait":
                        return new C14029hE();
                    case "application/x-icy":
                        return new C03();
                    case "application/id3":
                        return new E03();
                    case "application/x-emsg":
                        return new C11015cb2();
                    case "application/x-scte35":
                        return new com.google.android.exoplayer2.metadata.scte35.a();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }

        @Override // ir.nasim.InterfaceC22676ve4
        public boolean b(com.google.android.exoplayer2.X x) {
            String str = x.l;
            return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str);
        }
    }

    InterfaceC22086ue4 a(com.google.android.exoplayer2.X x);

    boolean b(com.google.android.exoplayer2.X x);
}
