package ir.nasim;

/* loaded from: classes2.dex */
public interface A07 {
    public static final A07 a = new a();

    class a implements A07 {
        a() {
        }

        @Override // ir.nasim.A07
        public InterfaceC24671z07 a(com.google.android.exoplayer2.X x) {
            String str = x.l;
            if (str != null) {
                switch (str) {
                    case "application/dvbsubs":
                        return new C9481a22(x.n);
                    case "application/pgs":
                        return new I75();
                    case "application/x-mp4-vtt":
                        return new C4037Dk4();
                    case "text/vtt":
                        return new Y88();
                    case "application/x-quicktime-tx3g":
                        return new C5810Kx7(x.n);
                    case "text/x-ssa":
                        return new C22485vJ6(x.n);
                    case "application/x-mp4-cea-608":
                    case "application/cea-608":
                        return new EH0(str, x.G, 16000L);
                    case "text/x-exoplayer-cues":
                        return new C14270he2();
                    case "application/cea-708":
                        return new GH0(x.G, x.n);
                    case "application/x-subrip":
                        return new C12674f07();
                    case "application/ttml+xml":
                        return new C23454ww7();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }

        @Override // ir.nasim.A07
        public boolean b(com.google.android.exoplayer2.X x) {
            String str = x.l;
            return "text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str) || "application/pgs".equals(str) || "text/x-exoplayer-cues".equals(str);
        }
    }

    InterfaceC24671z07 a(com.google.android.exoplayer2.X x);

    boolean b(com.google.android.exoplayer2.X x);
}
