package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class un implements acw, tm {
    final /* synthetic */ us a;
    private final Uri c;
    private final adg d;
    private final uj e;
    private final ka f;
    private final adm g;
    private volatile boolean i;
    private long k;
    private kr n;
    private boolean o;
    private final kl h = new kl();
    private boolean j = true;
    private long m = -1;
    private final long b = to.a();
    private acb l = j(0);

    public un(us usVar, Uri uri, abx abxVar, uj ujVar, ka kaVar, adm admVar) {
        this.a = usVar;
        this.c = uri;
        this.d = new adg(abxVar);
        this.e = ujVar;
        this.f = kaVar;
        this.g = admVar;
    }

    static /* synthetic */ void i(un unVar, long j, long j2) {
        unVar.h.a = j;
        unVar.k = j2;
        unVar.j = true;
        unVar.o = false;
    }

    private final acb j(long j) {
        aca acaVar = new aca();
        acaVar.g(this.c);
        acaVar.f(j);
        us.H(this.a);
        acaVar.d(null);
        acaVar.b(6);
        acaVar.c(us.b);
        return acaVar.a();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.acw
    public final void b() {
        this.i = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x01aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x022e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:? A[LOOP:0: B:3:0x0004->B:128:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01ed A[EDGE_INSN: B:129:0x01ed->B:93:0x01ed BREAK  A[LOOP:1: B:81:0x01a8->B:132:0x01a8], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0095 A[Catch: all -> 0x020f, TryCatch #6 {all -> 0x020f, blocks: (B:6:0x000c, B:8:0x0022, B:9:0x0025, B:12:0x003a, B:13:0x0040, B:31:0x008a, B:33:0x0095, B:35:0x00a1, B:37:0x00ab, B:39:0x00b7, B:41:0x00c1, B:43:0x00cd, B:45:0x00d7, B:47:0x00e9, B:49:0x00f3, B:50:0x00f9, B:68:0x0139, B:69:0x013f, B:71:0x014c, B:73:0x0156, B:74:0x0174, B:76:0x0194, B:77:0x0199, B:79:0x019d, B:53:0x0101, B:55:0x010b, B:57:0x0115, B:56:0x0110, B:61:0x011d, B:63:0x0127, B:65:0x0131, B:64:0x012c, B:17:0x004a, B:19:0x0056, B:21:0x0061, B:20:0x005b, B:25:0x006a, B:27:0x0076, B:29:0x0080, B:28:0x007b), top: B:124:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ab A[Catch: all -> 0x020f, TryCatch #6 {all -> 0x020f, blocks: (B:6:0x000c, B:8:0x0022, B:9:0x0025, B:12:0x003a, B:13:0x0040, B:31:0x008a, B:33:0x0095, B:35:0x00a1, B:37:0x00ab, B:39:0x00b7, B:41:0x00c1, B:43:0x00cd, B:45:0x00d7, B:47:0x00e9, B:49:0x00f3, B:50:0x00f9, B:68:0x0139, B:69:0x013f, B:71:0x014c, B:73:0x0156, B:74:0x0174, B:76:0x0194, B:77:0x0199, B:79:0x019d, B:53:0x0101, B:55:0x010b, B:57:0x0115, B:56:0x0110, B:61:0x011d, B:63:0x0127, B:65:0x0131, B:64:0x012c, B:17:0x004a, B:19:0x0056, B:21:0x0061, B:20:0x005b, B:25:0x006a, B:27:0x0076, B:29:0x0080, B:28:0x007b), top: B:124:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c1 A[Catch: all -> 0x020f, TryCatch #6 {all -> 0x020f, blocks: (B:6:0x000c, B:8:0x0022, B:9:0x0025, B:12:0x003a, B:13:0x0040, B:31:0x008a, B:33:0x0095, B:35:0x00a1, B:37:0x00ab, B:39:0x00b7, B:41:0x00c1, B:43:0x00cd, B:45:0x00d7, B:47:0x00e9, B:49:0x00f3, B:50:0x00f9, B:68:0x0139, B:69:0x013f, B:71:0x014c, B:73:0x0156, B:74:0x0174, B:76:0x0194, B:77:0x0199, B:79:0x019d, B:53:0x0101, B:55:0x010b, B:57:0x0115, B:56:0x0110, B:61:0x011d, B:63:0x0127, B:65:0x0131, B:64:0x012c, B:17:0x004a, B:19:0x0056, B:21:0x0061, B:20:0x005b, B:25:0x006a, B:27:0x0076, B:29:0x0080, B:28:0x007b), top: B:124:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d7 A[Catch: all -> 0x020f, TryCatch #6 {all -> 0x020f, blocks: (B:6:0x000c, B:8:0x0022, B:9:0x0025, B:12:0x003a, B:13:0x0040, B:31:0x008a, B:33:0x0095, B:35:0x00a1, B:37:0x00ab, B:39:0x00b7, B:41:0x00c1, B:43:0x00cd, B:45:0x00d7, B:47:0x00e9, B:49:0x00f3, B:50:0x00f9, B:68:0x0139, B:69:0x013f, B:71:0x014c, B:73:0x0156, B:74:0x0174, B:76:0x0194, B:77:0x0199, B:79:0x019d, B:53:0x0101, B:55:0x010b, B:57:0x0115, B:56:0x0110, B:61:0x011d, B:63:0x0127, B:65:0x0131, B:64:0x012c, B:17:0x004a, B:19:0x0056, B:21:0x0061, B:20:0x005b, B:25:0x006a, B:27:0x0076, B:29:0x0080, B:28:0x007b), top: B:124:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f3 A[Catch: all -> 0x020f, TRY_LEAVE, TryCatch #6 {all -> 0x020f, blocks: (B:6:0x000c, B:8:0x0022, B:9:0x0025, B:12:0x003a, B:13:0x0040, B:31:0x008a, B:33:0x0095, B:35:0x00a1, B:37:0x00ab, B:39:0x00b7, B:41:0x00c1, B:43:0x00cd, B:45:0x00d7, B:47:0x00e9, B:49:0x00f3, B:50:0x00f9, B:68:0x0139, B:69:0x013f, B:71:0x014c, B:73:0x0156, B:74:0x0174, B:76:0x0194, B:77:0x0199, B:79:0x019d, B:53:0x0101, B:55:0x010b, B:57:0x0115, B:56:0x0110, B:61:0x011d, B:63:0x0127, B:65:0x0131, B:64:0x012c, B:17:0x004a, B:19:0x0056, B:21:0x0061, B:20:0x005b, B:25:0x006a, B:27:0x0076, B:29:0x0080, B:28:0x007b), top: B:124:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0139 A[Catch: all -> 0x020f, TryCatch #6 {all -> 0x020f, blocks: (B:6:0x000c, B:8:0x0022, B:9:0x0025, B:12:0x003a, B:13:0x0040, B:31:0x008a, B:33:0x0095, B:35:0x00a1, B:37:0x00ab, B:39:0x00b7, B:41:0x00c1, B:43:0x00cd, B:45:0x00d7, B:47:0x00e9, B:49:0x00f3, B:50:0x00f9, B:68:0x0139, B:69:0x013f, B:71:0x014c, B:73:0x0156, B:74:0x0174, B:76:0x0194, B:77:0x0199, B:79:0x019d, B:53:0x0101, B:55:0x010b, B:57:0x0115, B:56:0x0110, B:61:0x011d, B:63:0x0127, B:65:0x0131, B:64:0x012c, B:17:0x004a, B:19:0x0056, B:21:0x0061, B:20:0x005b, B:25:0x006a, B:27:0x0076, B:29:0x0080, B:28:0x007b), top: B:124:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x014c A[Catch: all -> 0x020f, TryCatch #6 {all -> 0x020f, blocks: (B:6:0x000c, B:8:0x0022, B:9:0x0025, B:12:0x003a, B:13:0x0040, B:31:0x008a, B:33:0x0095, B:35:0x00a1, B:37:0x00ab, B:39:0x00b7, B:41:0x00c1, B:43:0x00cd, B:45:0x00d7, B:47:0x00e9, B:49:0x00f3, B:50:0x00f9, B:68:0x0139, B:69:0x013f, B:71:0x014c, B:73:0x0156, B:74:0x0174, B:76:0x0194, B:77:0x0199, B:79:0x019d, B:53:0x0101, B:55:0x010b, B:57:0x0115, B:56:0x0110, B:61:0x011d, B:63:0x0127, B:65:0x0131, B:64:0x012c, B:17:0x004a, B:19:0x0056, B:21:0x0061, B:20:0x005b, B:25:0x006a, B:27:0x0076, B:29:0x0080, B:28:0x007b), top: B:124:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0194 A[Catch: all -> 0x020f, TryCatch #6 {all -> 0x020f, blocks: (B:6:0x000c, B:8:0x0022, B:9:0x0025, B:12:0x003a, B:13:0x0040, B:31:0x008a, B:33:0x0095, B:35:0x00a1, B:37:0x00ab, B:39:0x00b7, B:41:0x00c1, B:43:0x00cd, B:45:0x00d7, B:47:0x00e9, B:49:0x00f3, B:50:0x00f9, B:68:0x0139, B:69:0x013f, B:71:0x014c, B:73:0x0156, B:74:0x0174, B:76:0x0194, B:77:0x0199, B:79:0x019d, B:53:0x0101, B:55:0x010b, B:57:0x0115, B:56:0x0110, B:61:0x011d, B:63:0x0127, B:65:0x0131, B:64:0x012c, B:17:0x004a, B:19:0x0056, B:21:0x0061, B:20:0x005b, B:25:0x006a, B:27:0x0076, B:29:0x0080, B:28:0x007b), top: B:124:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x019d A[Catch: all -> 0x020f, TRY_LEAVE, TryCatch #6 {all -> 0x020f, blocks: (B:6:0x000c, B:8:0x0022, B:9:0x0025, B:12:0x003a, B:13:0x0040, B:31:0x008a, B:33:0x0095, B:35:0x00a1, B:37:0x00ab, B:39:0x00b7, B:41:0x00c1, B:43:0x00cd, B:45:0x00d7, B:47:0x00e9, B:49:0x00f3, B:50:0x00f9, B:68:0x0139, B:69:0x013f, B:71:0x014c, B:73:0x0156, B:74:0x0174, B:76:0x0194, B:77:0x0199, B:79:0x019d, B:53:0x0101, B:55:0x010b, B:57:0x0115, B:56:0x0110, B:61:0x011d, B:63:0x0127, B:65:0x0131, B:64:0x012c, B:17:0x004a, B:19:0x0056, B:21:0x0061, B:20:0x005b, B:25:0x006a, B:27:0x0076, B:29:0x0080, B:28:0x007b), top: B:124:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01f0  */
    @Override // com.google.ads.interactivemedia.v3.internal.acw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 559
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.un.c():void");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tm
    public final void a(aee aeeVar) {
        long jMax = !this.o ? this.k : Math.max(this.a.T(), this.k);
        int iD = aeeVar.d();
        kr krVar = this.n;
        ary.t(krVar);
        krVar.d(aeeVar, iD);
        krVar.b(jMax, 1, iD, 0, null);
        this.o = true;
    }
}
