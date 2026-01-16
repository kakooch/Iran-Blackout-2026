package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class GetNewsListOutput extends StatusOutput {
    public NewsList result;

    public static class NewsList extends PresenterItem {
        public ArrayList<NewsObject> newsList;
    }
}
