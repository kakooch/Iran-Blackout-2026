package io.livekit.android.room.participant;

import ir.nasim.AbstractC10976cX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC21649tt7;
import ir.nasim.ED1;
import ir.nasim.EnumC9607aF3;
import java.util.ArrayList;
import java.util.List;
import livekit.LivekitModels$ParticipantPermission;

/* loaded from: classes3.dex */
public final class c {
    public static final a Companion = new a(null);
    private final boolean a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final List f;
    private final boolean g;
    private final boolean h;

    public static final class a {
        private a() {
        }

        public final c a(LivekitModels$ParticipantPermission livekitModels$ParticipantPermission) {
            AbstractC13042fc3.i(livekitModels$ParticipantPermission, "proto");
            boolean canPublish = livekitModels$ParticipantPermission.getCanPublish();
            boolean canSubscribe = livekitModels$ParticipantPermission.getCanSubscribe();
            boolean canPublishData = livekitModels$ParticipantPermission.getCanPublishData();
            boolean hidden = livekitModels$ParticipantPermission.getHidden();
            boolean recorder = livekitModels$ParticipantPermission.getRecorder();
            List<EnumC9607aF3> canPublishSourcesList = livekitModels$ParticipantPermission.getCanPublishSourcesList();
            AbstractC13042fc3.h(canPublishSourcesList, "getCanPublishSourcesList(...)");
            List<EnumC9607aF3> list = canPublishSourcesList;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            for (EnumC9607aF3 enumC9607aF3 : list) {
                AbstractC21649tt7.g.a aVar = AbstractC21649tt7.g.Companion;
                AbstractC13042fc3.f(enumC9607aF3);
                arrayList.add(aVar.a(enumC9607aF3));
            }
            return new c(canPublish, canSubscribe, canPublishData, hidden, recorder, arrayList, livekitModels$ParticipantPermission.getCanUpdateMetadata(), livekitModels$ParticipantPermission.getCanSubscribeMetrics());
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public c(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, List list, boolean z6, boolean z7) {
        AbstractC13042fc3.i(list, "canPublishSources");
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
        this.e = z5;
        this.f = list;
        this.g = z6;
        this.h = z7;
    }

    public final boolean a() {
        return this.a;
    }

    public final List b() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.a == cVar.a && this.b == cVar.b && this.c == cVar.c && this.d == cVar.d && this.e == cVar.e && AbstractC13042fc3.d(this.f, cVar.f) && this.g == cVar.g && this.h == cVar.h;
    }

    public int hashCode() {
        return (((((((((((((Boolean.hashCode(this.a) * 31) + Boolean.hashCode(this.b)) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + Boolean.hashCode(this.e)) * 31) + this.f.hashCode()) * 31) + Boolean.hashCode(this.g)) * 31) + Boolean.hashCode(this.h);
    }

    public String toString() {
        return "ParticipantPermission(canPublish=" + this.a + ", canSubscribe=" + this.b + ", canPublishData=" + this.c + ", hidden=" + this.d + ", recorder=" + this.e + ", canPublishSources=" + this.f + ", canUpdateMetadata=" + this.g + ", canSubscribeMetrics=" + this.h + ')';
    }
}
