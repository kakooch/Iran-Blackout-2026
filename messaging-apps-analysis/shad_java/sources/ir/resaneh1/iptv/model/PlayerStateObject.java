package ir.resaneh1.iptv.model;

import android.view.ViewGroup;

/* loaded from: classes3.dex */
public class PlayerStateObject {
    public PlayerStateEnum state;
    public ViewDataObject viewDataObject;
    public ViewGroup viewObject;

    public enum PlayerStateEnum {
        playAds,
        stopAds,
        errorAds
    }
}
