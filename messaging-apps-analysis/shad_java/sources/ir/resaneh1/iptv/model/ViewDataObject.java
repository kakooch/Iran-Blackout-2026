package ir.resaneh1.iptv.model;

import com.facebook.stetho.websocket.CloseCodes;
import io.reactivex.ObservableEmitter;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class ViewDataObject extends PresenterItem {
    public String apiUrl;
    private boolean hasVideo;
    public Map<String, String> images;
    public Map<String, ViewObjectAttr> images_attr;
    public Map<String, Link> links;
    public Map<String, ViewObjectAttr> links_attr;
    public String object_data_id;
    public Map<String, String> texts;
    public Map<String, ViewObjectAttr> texts_attr;
    public String url;
    public Map<String, ObservableEmitter<Boolean>> progressViewDisposableMap = new HashMap();
    public Integer viewId = null;

    public static int getPresenterItemTypeByViewId(int i) {
        return i * CloseCodes.NORMAL_CLOSURE;
    }

    public boolean hasVideo() {
        return false;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.viewDataObject;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public int getPresenterItemTypeInt() {
        Integer num = this.viewId;
        if (num != null) {
            return getPresenterItemTypeByViewId(num.intValue());
        }
        return getPresenterType().ordinal();
    }

    public void editByNewDataObject(ViewDataObject viewDataObject) {
        if (this.object_data_id == null) {
            return;
        }
        if (viewDataObject.images != null) {
            if (this.images == null) {
                this.images = new HashMap();
            }
            for (String str : viewDataObject.images.keySet()) {
                this.images.put(str, viewDataObject.images.get(str));
            }
        }
        if (viewDataObject.texts != null) {
            if (this.texts == null) {
                this.texts = new HashMap();
            }
            for (String str2 : viewDataObject.texts.keySet()) {
                this.texts.put(str2, viewDataObject.texts.get(str2));
            }
        }
        if (viewDataObject.links != null) {
            if (this.links == null) {
                this.links = new HashMap();
            }
            for (String str3 : viewDataObject.links.keySet()) {
                this.links.put(str3, viewDataObject.links.get(str3));
            }
        }
        if (viewDataObject.images_attr != null) {
            if (this.images_attr == null) {
                this.images_attr = new HashMap();
            }
            for (String str4 : viewDataObject.images_attr.keySet()) {
                ViewObjectAttr viewObjectAttr = this.images_attr.get(str4);
                if (viewObjectAttr != null) {
                    viewObjectAttr.editYourSelf(viewDataObject.images_attr.get(str4));
                } else {
                    this.images_attr.put(str4, viewDataObject.images_attr.get(str4));
                }
            }
        }
        if (viewDataObject.texts_attr != null) {
            if (this.texts_attr == null) {
                this.texts_attr = new HashMap();
            }
            for (String str5 : viewDataObject.texts_attr.keySet()) {
                ViewObjectAttr viewObjectAttr2 = this.texts_attr.get(str5);
                if (viewObjectAttr2 != null) {
                    viewObjectAttr2.editYourSelf(viewDataObject.texts_attr.get(str5));
                } else {
                    this.texts_attr.put(str5, viewDataObject.texts_attr.get(str5));
                }
            }
        }
        if (viewDataObject.links_attr != null) {
            if (this.links_attr == null) {
                this.links_attr = new HashMap();
            }
            for (String str6 : viewDataObject.links_attr.keySet()) {
                ViewObjectAttr viewObjectAttr3 = this.links_attr.get(str6);
                if (viewObjectAttr3 != null) {
                    viewObjectAttr3.editYourSelf(viewDataObject.links_attr.get(str6));
                } else {
                    this.links_attr.put(str6, viewDataObject.links_attr.get(str6));
                }
            }
        }
        this.hasVideo = viewDataObject.hasVideo;
        this.url = viewDataObject.url;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public String getId() {
        return this.object_data_id;
    }
}
