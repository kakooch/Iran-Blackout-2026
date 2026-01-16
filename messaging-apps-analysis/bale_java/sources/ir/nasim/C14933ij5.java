package ir.nasim;

import ai.bale.proto.PeersStruct$ExPeer;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import ir.nasim.data.model.story.PostToStoryData;
import ir.nasim.database.model.story.WidgetCoordinate;
import ir.nasim.story.model.StoryWidget;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 /2\u00020\u0001:\u00010B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ-\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0003J!\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001b\u0010+\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0016\u0010.\u001a\u0004\u0018\u00010\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u00061"}, d2 = {"Lir/nasim/ij5;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/data/model/story/PostToStoryData;", "postToStoryData", "", "Lir/nasim/story/model/StoryWidget;", "V9", "(Lir/nasim/data/model/story/PostToStoryData;)Ljava/util/List;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lir/nasim/rB7;", "i9", "T6", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lir/nasim/az2;", "h1", "Lir/nasim/az2;", "_binding", "Lir/nasim/v6;", "", "i1", "Lir/nasim/v6;", "requestPermissionLauncher", "Lir/nasim/I35;", "j1", "Lir/nasim/I35;", "permissionResultCallback", "Lir/nasim/bX6;", "k1", "Lir/nasim/Yu3;", "U9", "()Lir/nasim/bX6;", "viewModel", "T9", "()Lir/nasim/az2;", "binding", "l1", "a", "story_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.ij5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C14933ij5 extends AbstractC23793xX2 {

    /* renamed from: l1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int m1 = 8;

    /* renamed from: h1, reason: from kotlin metadata */
    private C10045az2 _binding;

    /* renamed from: i1, reason: from kotlin metadata */
    private AbstractC22357v6 requestPermissionLauncher;

    /* renamed from: j1, reason: from kotlin metadata */
    private final I35 permissionResultCallback = new I35();

    /* renamed from: k1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.hj5
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C14933ij5.W9(this.a);
        }
    });

    /* renamed from: ir.nasim.ij5$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C22042ua0 a(String str, List list, PostToStoryData postToStoryData) {
            AbstractC13042fc3.i(str, "filePath");
            AbstractC13042fc3.i(list, "coordinates");
            AbstractC13042fc3.i(postToStoryData, "postToStoryData");
            C14933ij5 c14933ij5 = new C14933ij5();
            Bundle bundle = new Bundle();
            bundle.putString("filePath", str);
            bundle.putParcelableArray("COORDINATES", (Parcelable[]) list.toArray(new WidgetCoordinate[0]));
            bundle.putParcelable("POST_DATA", postToStoryData);
            c14933ij5.a8(bundle);
            return c14933ij5;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: T9, reason: from getter */
    private final C10045az2 get_binding() {
        return this._binding;
    }

    private final C10366bX6 U9() {
        return (C10366bX6) this.viewModel.getValue();
    }

    private final List V9(PostToStoryData postToStoryData) {
        List listC = AbstractC9766aX0.c();
        if (postToStoryData != null) {
            Bundle bundleE5 = E5();
            List listM = null;
            if (bundleE5 != null) {
                if (Build.VERSION.SDK_INT >= 33) {
                    Parcelable[] parcelableArr = (Parcelable[]) bundleE5.getParcelableArray("COORDINATES", WidgetCoordinate.class);
                    if (parcelableArr != null) {
                        listM = AbstractC10242bK.f1(parcelableArr);
                    }
                } else {
                    Parcelable[] parcelableArray = bundleE5.getParcelableArray("COORDINATES");
                    if (parcelableArray != null) {
                        listM = new ArrayList(parcelableArray.length);
                        for (Parcelable parcelable : parcelableArray) {
                            if (parcelable == null) {
                                throw new NullPointerException("null cannot be cast to non-null type ir.nasim.database.model.story.WidgetCoordinate");
                            }
                            listM.add((WidgetCoordinate) parcelable);
                        }
                    } else {
                        listM = AbstractC10360bX0.m();
                    }
                }
            }
            if (listM == null) {
                listM = AbstractC10360bX0.m();
            }
            String postWidgetUrl = postToStoryData.getPostWidgetUrl();
            if (postWidgetUrl != null) {
                listC.add(new StoryWidget.PostWidget(postWidgetUrl, listM));
            }
            String linkWidgetUrl = postToStoryData.getLinkWidgetUrl();
            if (linkWidgetUrl != null) {
                String linkWidgetTitle = postToStoryData.getLinkWidgetTitle();
                if (linkWidgetTitle == null) {
                    linkWidgetTitle = h6(SD5.view_post);
                    AbstractC13042fc3.h(linkWidgetTitle, "getString(...)");
                }
                listC.add(new StoryWidget.LinkWidget(linkWidgetUrl, linkWidgetTitle, listM));
            }
        }
        return AbstractC9766aX0.a(listC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C10366bX6 W9(C14933ij5 c14933ij5) {
        AbstractC13042fc3.i(c14933ij5, "this$0");
        FragmentActivity fragmentActivityQ7 = c14933ij5.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        return (C10366bX6) new androidx.lifecycle.G(fragmentActivityQ7).b(C10366bX6.class);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        this._binding = C10045az2.c(inflater, container, false);
        C10045az2 c10045az2 = get_binding();
        if (c10045az2 != null) {
            return c10045az2.getRoot();
        }
        return null;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        U9().d6();
    }

    @Override // ir.nasim.C22042ua0
    public void i9() {
        super.i9();
        U9().Y4();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        String string;
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        U9().T5(U9().T3());
        this.requestPermissionLauncher = N7(new C19881r6(), this.permissionResultCallback);
        Bundle bundleE5 = E5();
        PostToStoryData postToStoryData = bundleE5 != null ? (PostToStoryData) AbstractC19455qN7.c(bundleE5, "POST_DATA", PostToStoryData.class) : null;
        List listV9 = V9(postToStoryData);
        C10366bX6 c10366bX6U9 = U9();
        PeersStruct$ExPeer peersStruct$ExPeerI4 = U9().i4();
        Bundle bundleE52 = E5();
        if (bundleE52 == null || (string = bundleE52.getString("filePath")) == null) {
            string = "";
        }
        c10366bX6U9.p6(string, peersStruct$ExPeerI4, (4 & 4) != 0 ? null : null, (4 & 8) != 0 ? null : listV9, (4 & 16) != 0 ? null : postToStoryData);
    }
}
