package ir.resaneh1.iptv.model;

import android.net.Uri;
import ir.aaap.messengercore.model.MetaDataPartObject;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import java.util.ArrayList;
import org.rbmain.messenger.VideoEditedInfo;

/* loaded from: classes3.dex */
public class SendingMediaInfo extends PresenterItem {
    public String caption;
    public int duration;
    public ArrayList<MetaDataPartObject> entities;
    public int height;
    public boolean isVideo;
    public String orginalPath;
    public String path;
    public int rnd;
    public String thumbPath;
    public Uri uri;
    public VideoEditedInfo videoEditedInfo;
    public int width;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.sendingMediaInfo;
    }
}
