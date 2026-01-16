package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;

/* loaded from: classes3.dex */
public class TagObject {
    public String name = BuildConfig.FLAVOR;
    public ShowType show_type = ShowType.none;
    public String tag_id;
    public TagType type;
    public ViewGroupObject viewObject;

    public enum ShowType {
        none,
        event,
        postComment
    }

    public enum TagType {
        no_type,
        vchannel_item,
        virtual_channel,
        vod_film,
        aod_track,
        firstMenu,
        tv_episode,
        tv_channel,
        tv_archive,
        large_banner,
        snapshot,
        user,
        category,
        radio_archive,
        radio_episode,
        radio_channel,
        app,
        file,
        setting,
        storage,
        channels_of_epg,
        date_of_epg,
        date,
        avatar,
        secondMenu,
        web,
        company,
        course,
        operator,
        item_link,
        small_banner,
        instaPost,
        dynamicView,
        address,
        comment
    }

    public TagObject(TagType tagType, String str) {
        this.type = tagType;
        this.tag_id = str;
    }

    public TagObject() {
    }
}
