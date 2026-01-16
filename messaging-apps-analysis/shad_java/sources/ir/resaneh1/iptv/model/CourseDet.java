package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class CourseDet extends PresenterItem {
    public TagObject comments;
    public CourseAbs object_abs;
    public TagObject related;
    public String teacher_name = BuildConfig.FLAVOR;
    public String teacher_imageurl = BuildConfig.FLAVOR;
    public boolean has_trailer = false;
    public String trailer_id = BuildConfig.FLAVOR;
    public ArrayList<SectionObject> sections = new ArrayList<>();

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.courseDet;
    }
}
