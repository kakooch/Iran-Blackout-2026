package ir.nasim;

/* renamed from: ir.nasim.Uw1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8180Uw1 implements InterfaceC16169kp0 {
    private static final a b = new a(null);

    /* renamed from: ir.nasim.Uw1$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    @Override // ir.nasim.InterfaceC16169kp0
    public String a(com.google.android.exoplayer2.upstream.b bVar) {
        AbstractC13042fc3.i(bVar, "dataSpec");
        C19406qI3.a("CustomCacheKeyFactory", "dataSpec key: " + bVar.i, new Object[0]);
        String str = bVar.i;
        if (str != null) {
            return str;
        }
        String string = bVar.a.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        String strSubstring = string.substring(AbstractC20762sZ6.r0(string, "cacheId=", 0, false, 6, null) + 8);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        C19406qI3.a("CustomCacheKeyFactory", "cacheId: " + strSubstring, new Object[0]);
        return strSubstring;
    }
}
