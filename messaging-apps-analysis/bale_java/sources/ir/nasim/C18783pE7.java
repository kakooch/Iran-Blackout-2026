package ir.nasim;

import ai.bale.proto.GroupsOuterClass$UpdateGroupRestrictionChanged;

/* renamed from: ir.nasim.pE7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18783pE7 implements InterfaceC14123hO3 {

    /* renamed from: ir.nasim.pE7$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[GS2.values().length];
            try {
                iArr[GS2.Restriction_PRIVATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GS2.Restriction_PUBLIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C18192oE7 a(GroupsOuterClass$UpdateGroupRestrictionChanged groupsOuterClass$UpdateGroupRestrictionChanged) {
        AbstractC13042fc3.i(groupsOuterClass$UpdateGroupRestrictionChanged, "input");
        int groupId = groupsOuterClass$UpdateGroupRestrictionChanged.getGroupId();
        GS2 restriction = groupsOuterClass$UpdateGroupRestrictionChanged.getRestriction();
        int i = restriction == null ? -1 : a.a[restriction.ordinal()];
        W06 w06 = (i == 1 || i != 2) ? W06.PRIVATE : W06.PUBLIC;
        return new C18192oE7(groupId, w06);
    }
}
