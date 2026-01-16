package ir.nasim;

/* loaded from: classes7.dex */
public final class I35 implements InterfaceC17517n6 {
    private UA2 a = new UA2() { // from class: ir.nasim.H35
        @Override // ir.nasim.UA2
        public final Object invoke(Object obj) {
            return I35.d(((Boolean) obj).booleanValue());
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d(boolean z) {
        return C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC17517n6
    public /* bridge */ /* synthetic */ void a(Object obj) {
        c(((Boolean) obj).booleanValue());
    }

    public void c(boolean z) {
        this.a.invoke(Boolean.valueOf(z));
    }

    public final void e(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "<set-?>");
        this.a = ua2;
    }
}
