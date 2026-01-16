package ir.nasim;

import ai.bale.proto.MeetStruct$PeerState;
import ir.nasim.T25;

/* loaded from: classes5.dex */
public abstract class S25 {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC11447d14.values().length];
            try {
                iArr[EnumC11447d14.PeerStateEnum_UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC11447d14.PeerStateEnum_INVITED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC11447d14.PeerStateEnum_JOINED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC11447d14.PeerStateEnum_REJECTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnumC11447d14.PeerStateEnum_LEFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EnumC11447d14.PeerStateEnum_TRACKMUTED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            a = iArr;
        }
    }

    public static final R25 a(long j, MeetStruct$PeerState meetStruct$PeerState) {
        T25 t25B;
        AbstractC13042fc3.i(meetStruct$PeerState, "apiPeerState");
        EnumC11447d14 peerStateEnum = meetStruct$PeerState.getPeerStateEnum();
        switch (peerStateEnum == null ? -1 : a.a[peerStateEnum.ordinal()]) {
            case 1:
                t25B = T25.g.a;
                break;
            case 2:
                t25B = T25.a.a;
                break;
            case 3:
                t25B = T25.b.a;
                break;
            case 4:
                t25B = T25.d.a;
                break;
            case 5:
                t25B = T25.c.a;
                break;
            case 6:
                t25B = b(meetStruct$PeerState);
                break;
            default:
                t25B = T25.g.a;
                break;
        }
        T25 t25 = t25B;
        if (t25 != null) {
            return new R25(meetStruct$PeerState.getId(), t25, meetStruct$PeerState.getDate(), j, null);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final ir.nasim.T25.e b(ai.bale.proto.MeetStruct$PeerState r5) {
        /*
            java.lang.String r0 = "apiPeerState"
            ir.nasim.AbstractC13042fc3.i(r5, r0)
            java.util.Map r0 = r5.getExtraMap()
            r1 = 0
            if (r0 == 0) goto L69
            java.util.List r0 = ir.nasim.AbstractC18278oO3.C(r0)
            if (r0 == 0) goto L69
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L18:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L32
            java.lang.Object r2 = r0.next()
            r3 = r2
            ir.nasim.XV4 r3 = (ir.nasim.XV4) r3
            java.lang.Object r3 = r3.e()
            java.lang.String r4 = "trackSource"
            boolean r3 = ir.nasim.AbstractC13042fc3.d(r3, r4)
            if (r3 == 0) goto L18
            goto L33
        L32:
            r2 = r1
        L33:
            ir.nasim.XV4 r2 = (ir.nasim.XV4) r2
            if (r2 == 0) goto L69
            java.lang.Object r0 = r2.f()
            boolean r2 = r0 instanceof ai.bale.proto.CollectionsStruct$Int32Value
            if (r2 == 0) goto L42
            ai.bale.proto.CollectionsStruct$Int32Value r0 = (ai.bale.proto.CollectionsStruct$Int32Value) r0
            goto L43
        L42:
            r0 = r1
        L43:
            if (r0 == 0) goto L4e
            int r0 = r0.getValue()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L4f
        L4e:
            r0 = r1
        L4f:
            if (r0 != 0) goto L52
            goto L5c
        L52:
            int r2 = r0.intValue()
            r3 = 1
            if (r2 != r3) goto L5c
            ir.nasim.T25$f r0 = ir.nasim.T25.f.a
            goto L6a
        L5c:
            if (r0 != 0) goto L5f
            goto L69
        L5f:
            int r0 = r0.intValue()
            r2 = 2
            if (r0 != r2) goto L69
            ir.nasim.T25$f r0 = ir.nasim.T25.f.b
            goto L6a
        L69:
            r0 = r1
        L6a:
            java.util.Map r5 = r5.getExtraMap()
            if (r5 == 0) goto Lb2
            java.util.List r5 = ir.nasim.AbstractC18278oO3.C(r5)
            if (r5 == 0) goto Lb2
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L7c:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L96
            java.lang.Object r2 = r5.next()
            r3 = r2
            ir.nasim.XV4 r3 = (ir.nasim.XV4) r3
            java.lang.Object r3 = r3.e()
            java.lang.String r4 = "muterUID"
            boolean r3 = ir.nasim.AbstractC13042fc3.d(r3, r4)
            if (r3 == 0) goto L7c
            goto L97
        L96:
            r2 = r1
        L97:
            ir.nasim.XV4 r2 = (ir.nasim.XV4) r2
            if (r2 == 0) goto Lb2
            java.lang.Object r5 = r2.f()
            boolean r2 = r5 instanceof ai.bale.proto.CollectionsStruct$Int32Value
            if (r2 == 0) goto La6
            ai.bale.proto.CollectionsStruct$Int32Value r5 = (ai.bale.proto.CollectionsStruct$Int32Value) r5
            goto La7
        La6:
            r5 = r1
        La7:
            if (r5 == 0) goto Lb2
            int r5 = r5.getValue()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            goto Lb3
        Lb2:
            r5 = r1
        Lb3:
            if (r0 == 0) goto Lc1
            if (r5 != 0) goto Lb8
            goto Lc1
        Lb8:
            ir.nasim.T25$e r1 = new ir.nasim.T25$e
            int r5 = r5.intValue()
            r1.<init>(r0, r5)
        Lc1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.S25.b(ai.bale.proto.MeetStruct$PeerState):ir.nasim.T25$e");
    }
}
