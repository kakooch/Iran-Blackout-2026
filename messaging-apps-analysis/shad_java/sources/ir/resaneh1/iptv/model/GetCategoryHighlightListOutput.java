package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class GetCategoryHighlightListOutput extends StatusOutput {
    public HighlightList result;

    public static class HighlightList extends PresenterItem {
        public ArrayList<NewsHighlightObject> highlights;
    }
}
