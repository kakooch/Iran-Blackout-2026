package com.google.ads.interactivemedia.v3.internal;

import android.view.View;
import android.view.ViewGroup;
import com.google.ads.interactivemedia.v3.api.BaseDisplayContainer;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.v3.api.FriendlyObstruction;
import com.google.ads.interactivemedia.v3.api.FriendlyObstructionPurpose;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public class amg implements BaseDisplayContainer {
    private static int g;
    private ViewGroup a;
    private Collection<CompanionAdSlot> b = arn.i();
    private Map<String, CompanionAdSlot> c = null;
    private final Set<FriendlyObstruction> d = new HashSet();
    private amf e = null;
    private boolean f = false;

    public amg(ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    public final Map<String, CompanionAdSlot> a() {
        return this.c;
    }

    public final Set<FriendlyObstruction> b() {
        return new HashSet(this.d);
    }

    public final void c(amf amfVar) {
        this.e = amfVar;
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseDisplayContainer
    public final void claim() {
        aqd.e(!this.f, "A given DisplayContainer may only be used once");
        this.f = true;
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseDisplayContainer
    public final void destroy() {
        ViewGroup viewGroup = this.a;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseDisplayContainer
    public final ViewGroup getAdContainer() {
        return this.a;
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseDisplayContainer
    public final Collection<CompanionAdSlot> getCompanionSlots() {
        return this.b;
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseDisplayContainer
    public final void registerFriendlyObstruction(FriendlyObstruction friendlyObstruction) {
        if (friendlyObstruction == null || this.d.contains(friendlyObstruction)) {
            return;
        }
        this.d.add(friendlyObstruction);
        amf amfVar = this.e;
        if (amfVar != null) {
            ((anr) amfVar).g(friendlyObstruction);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseDisplayContainer
    public final void registerVideoControlsOverlay(View view) {
        if (view == null) {
            return;
        }
        com.google.ads.interactivemedia.v3.impl.data.ay ayVarBuilder = com.google.ads.interactivemedia.v3.impl.data.az.builder();
        ayVarBuilder.view(view);
        ayVarBuilder.purpose(FriendlyObstructionPurpose.VIDEO_CONTROLS);
        com.google.ads.interactivemedia.v3.impl.data.az azVarBuild = ayVarBuilder.build();
        if (azVarBuild == null || this.d.contains(azVarBuild)) {
            return;
        }
        this.d.add(azVarBuild);
        amf amfVar = this.e;
        if (amfVar != null) {
            ((anr) amfVar).g(azVarBuild);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseDisplayContainer
    public final void setAdContainer(ViewGroup viewGroup) {
        aqd.j(viewGroup);
        this.a = viewGroup;
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseDisplayContainer
    public final void setCompanionSlots(Collection<CompanionAdSlot> collection) {
        if (collection == null) {
            collection = arn.i();
        }
        arq arqVar = new arq();
        for (CompanionAdSlot companionAdSlot : collection) {
            if (companionAdSlot != null) {
                int i = g;
                g = i + 1;
                StringBuilder sb = new StringBuilder(20);
                sb.append("compSlot_");
                sb.append(i);
                arqVar.b(sb.toString(), companionAdSlot);
            }
        }
        this.c = arqVar.a();
        this.b = collection;
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseDisplayContainer
    public final void unregisterAllFriendlyObstructions() {
        this.d.clear();
        amf amfVar = this.e;
        if (amfVar != null) {
            ((anr) amfVar).h();
        }
    }

    @Override // com.google.ads.interactivemedia.v3.api.BaseDisplayContainer
    public final void unregisterAllVideoControlsOverlays() {
        this.d.clear();
        amf amfVar = this.e;
        if (amfVar != null) {
            ((anr) amfVar).h();
        }
    }
}
