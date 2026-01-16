package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;

/* loaded from: classes3.dex */
public class GetNewsOutput extends StatusOutput {
    public Result result;

    public static class Result extends PresenterItem {
        public NewsObject news;
    }
}
