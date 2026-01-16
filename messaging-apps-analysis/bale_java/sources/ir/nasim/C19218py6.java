package ir.nasim;

/* renamed from: ir.nasim.py6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C19218py6 {
    public static final C19218py6 a = new C19218py6();

    private C19218py6() {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    public final EnumC18627oy6 a(String str) {
        AbstractC13042fc3.i(str, "value");
        switch (str.hashCode()) {
            case -1062763707:
                if (str.equals("MessageContentType_DOCUMENT_AUDIO")) {
                    return EnumC18627oy6.a;
                }
                break;
            case -1049287263:
                if (str.equals("MessageContentType_DOCUMENT_PHOTO")) {
                    return EnumC18627oy6.c;
                }
                break;
            case -1043727382:
                if (str.equals("MessageContentType_DOCUMENT_VIDEO")) {
                    return EnumC18627oy6.b;
                }
                break;
            case -1043543903:
                if (str.equals("MessageContentType_DOCUMENT_VOICE")) {
                    return EnumC18627oy6.e;
                }
                break;
            case 1494449934:
                if (str.equals("MessageContentType_DOCUMENT")) {
                    return EnumC18627oy6.d;
                }
                break;
        }
        return EnumC18627oy6.f;
    }
}
