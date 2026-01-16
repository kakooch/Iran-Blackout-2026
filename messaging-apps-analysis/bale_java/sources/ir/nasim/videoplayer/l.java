package ir.nasim.videoplayer;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C11458d25;
import ir.nasim.EnumC24384yX3;
import ir.nasim.InterfaceC10956cU7;
import ir.nasim.InterfaceC18963pY7;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.videoplayer.NewVideoPlayerActivity;

/* loaded from: classes8.dex */
public final class l implements InterfaceC10956cU7 {
    @Override // ir.nasim.InterfaceC10956cU7
    public void b(Context context, C11458d25 c11458d25, ExPeerType exPeerType, InterfaceC18963pY7 interfaceC18963pY7, View view, EnumC24384yX3 enumC24384yX3) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(interfaceC18963pY7, "viewableContent");
        AbstractC13042fc3.i(enumC24384yX3, "mediaLoadType");
        NewVideoPlayerActivity.Companion companion = NewVideoPlayerActivity.INSTANCE;
        Intent intentB = companion.b(context, c11458d25, exPeerType, interfaceC18963pY7, view != null ? view.getTransitionName() : null, enumC24384yX3);
        Activity activity = context instanceof Activity ? (Activity) context : null;
        ActivityOptions activityOptionsA = (activity == null || view == null) ? null : companion.a(activity, view);
        context.startActivity(intentB, activityOptionsA != null ? activityOptionsA.toBundle() : null);
    }
}
