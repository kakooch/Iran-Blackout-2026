package ir.nasim;

/* renamed from: ir.nasim.kp0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC16169kp0 {
    public static final InterfaceC16169kp0 a = new InterfaceC16169kp0() { // from class: ir.nasim.jp0
        @Override // ir.nasim.InterfaceC16169kp0
        public final String a(com.google.android.exoplayer2.upstream.b bVar) {
            return InterfaceC16169kp0.b(bVar);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ String b(com.google.android.exoplayer2.upstream.b bVar) {
        String str = bVar.i;
        return str != null ? str : bVar.a.toString();
    }

    String a(com.google.android.exoplayer2.upstream.b bVar);
}
