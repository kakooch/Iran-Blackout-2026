package ir.nasim;

import ai.bale.proto.PeersStruct$ExPeer;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import androidx.lifecycle.j;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.airbnb.lottie.LottieAnimationView;
import com.genius.multiprogressbar.MultiProgressBar;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC11710dT6;
import ir.nasim.AbstractC13463gG6;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.AbstractC8081Ul1;
import ir.nasim.C9475a16;
import ir.nasim.D20;
import ir.nasim.GY;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.LA3;
import ir.nasim.MW6;
import ir.nasim.W9;
import ir.nasim.ZV6;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.database.model.story.WidgetCoordinate;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import ir.nasim.features.conversation.messages.content.CircleProgressBar;
import ir.nasim.story.model.StoryWidget;
import ir.nasim.story.ui.storyadder.StoryAdderSourceCallerEnum;
import ir.nasim.story.ui.viewfragment.reaction.ReactionHandler;
import ir.nasim.story.ui.viewfragment.views.PopularStoryBarView;
import ir.nasim.story.ui.viewfragment.views.ReplyStoryView;
import ir.nasim.story.ui.viewfragment.views.TopBarStoryView;
import ir.nasim.story.ui.viewfragment.views.a;
import ir.nasim.story.ui.viewfragment.views.footer.a;
import ir.nasim.tgwidgets.editor.ui.stories.bale.views.StoryLinkCustomView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000è\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0002»\u0002\b\u0007\u0018\u0000 Ð\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t:\u0002Ñ\u0002B\t\b\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u000bJ\u000f\u0010\u0011\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u000eJ\u000f\u0010\u0013\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0013\u0010\u000eJ\u000f\u0010\u0014\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0014\u0010\u000bJ\u0017\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0019\u0010\u000bJG\u0010#\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001a2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0\u001f2\b\b\u0002\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b#\u0010$J\u001d\u0010%\u001a\u00020\u000f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0\u001fH\u0002¢\u0006\u0004\b%\u0010&J\u001d\u0010'\u001a\u00020\u000f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0\u001fH\u0002¢\u0006\u0004\b'\u0010&J\u000f\u0010(\u001a\u00020\u000fH\u0002¢\u0006\u0004\b(\u0010\u000bJ\u000f\u0010)\u001a\u00020\u000fH\u0002¢\u0006\u0004\b)\u0010\u000bJ;\u0010-\u001a\u00020\u000f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0\u001f2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001f2\u0006\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u001cH\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u000fH\u0002¢\u0006\u0004\b/\u0010\u000bJ\u000f\u00100\u001a\u00020\u000fH\u0002¢\u0006\u0004\b0\u0010\u000bJ\u0011\u00102\u001a\u0004\u0018\u000101H\u0002¢\u0006\u0004\b2\u00103J\u0011\u00105\u001a\u0004\u0018\u000104H\u0002¢\u0006\u0004\b5\u00106J\u001f\u00109\u001a\u00020\f2\u0006\u00107\u001a\u00020!2\u0006\u00108\u001a\u00020\u001aH\u0002¢\u0006\u0004\b9\u0010:J\u001f\u0010<\u001a\u00020\f2\u0006\u00107\u001a\u00020!2\u0006\u0010;\u001a\u00020\u001aH\u0002¢\u0006\u0004\b<\u0010:J!\u0010>\u001a\u00020\f2\u0006\u00107\u001a\u00020!2\b\b\u0002\u0010=\u001a\u00020\u001cH\u0002¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\fH\u0002¢\u0006\u0004\b@\u0010\u000eJ%\u0010E\u001a\u00020\u000f2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020B0A2\u0006\u0010D\u001a\u00020!H\u0002¢\u0006\u0004\bE\u0010FJ\u0017\u0010G\u001a\u00020\u000f2\u0006\u0010D\u001a\u00020!H\u0002¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\u000fH\u0002¢\u0006\u0004\bI\u0010\u000bJ\u000f\u0010J\u001a\u00020\u000fH\u0002¢\u0006\u0004\bJ\u0010\u000bJ\u000f\u0010K\u001a\u00020\u000fH\u0002¢\u0006\u0004\bK\u0010\u000bJ\u000f\u0010L\u001a\u00020\u000fH\u0002¢\u0006\u0004\bL\u0010\u000bJ\u000f\u0010M\u001a\u00020\u000fH\u0002¢\u0006\u0004\bM\u0010\u000bJ\u000f\u0010O\u001a\u00020NH\u0002¢\u0006\u0004\bO\u0010PJ\u0017\u0010R\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020BH\u0002¢\u0006\u0004\bR\u0010SJ\u000f\u0010T\u001a\u00020\u000fH\u0002¢\u0006\u0004\bT\u0010\u000bJ\u0017\u0010V\u001a\u00020\u000f2\u0006\u0010U\u001a\u00020!H\u0002¢\u0006\u0004\bV\u0010HJ\u000f\u0010W\u001a\u00020\u000fH\u0002¢\u0006\u0004\bW\u0010\u000bJ\u0017\u0010Y\u001a\u00020\u000f2\u0006\u0010X\u001a\u00020BH\u0002¢\u0006\u0004\bY\u0010SJ\u000f\u0010Z\u001a\u00020\u000fH\u0002¢\u0006\u0004\bZ\u0010\u000bJ\u0017\u0010[\u001a\u00020\u000f2\u0006\u0010U\u001a\u00020!H\u0002¢\u0006\u0004\b[\u0010HJ\u0017\u0010]\u001a\u00020\u000f2\u0006\u0010\\\u001a\u00020BH\u0002¢\u0006\u0004\b]\u0010SJ\u001f\u0010`\u001a\u00020\u000f2\u0006\u0010_\u001a\u00020^2\u0006\u0010\\\u001a\u00020BH\u0002¢\u0006\u0004\b`\u0010aJ\u001f\u0010f\u001a\u00020\u000f2\u0006\u0010c\u001a\u00020b2\u0006\u0010e\u001a\u00020dH\u0002¢\u0006\u0004\bf\u0010gJ\u0017\u0010h\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020BH\u0002¢\u0006\u0004\bh\u0010SJ\u0017\u0010i\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020BH\u0002¢\u0006\u0004\bi\u0010SJ\u000f\u0010j\u001a\u00020\u001cH\u0002¢\u0006\u0004\bj\u0010kJ\u000f\u0010l\u001a\u00020\u001cH\u0002¢\u0006\u0004\bl\u0010kJ\u000f\u0010m\u001a\u00020\u001cH\u0002¢\u0006\u0004\bm\u0010kJ\u0017\u0010n\u001a\u00020\f2\u0006\u0010D\u001a\u00020!H\u0002¢\u0006\u0004\bn\u0010oJ\u001d\u0010q\u001a\u00020!2\f\u0010p\u001a\b\u0012\u0004\u0012\u00020B0AH\u0002¢\u0006\u0004\bq\u0010rJ\u000f\u0010s\u001a\u00020\u000fH\u0002¢\u0006\u0004\bs\u0010\u000bJ\u0017\u0010t\u001a\u00020\u000f2\u0006\u0010\\\u001a\u00020BH\u0002¢\u0006\u0004\bt\u0010SJ\u0017\u0010w\u001a\u00020v2\u0006\u0010u\u001a\u00020BH\u0002¢\u0006\u0004\bw\u0010xJ\u0019\u0010z\u001a\u00020\u000f2\b\b\u0002\u0010y\u001a\u00020\u001cH\u0002¢\u0006\u0004\bz\u0010{J\u000f\u0010|\u001a\u00020\fH\u0002¢\u0006\u0004\b|\u0010\u000eJ\u0017\u0010~\u001a\u00020\u000f2\u0006\u0010}\u001a\u00020BH\u0002¢\u0006\u0004\b~\u0010SJ\u001b\u0010\u0081\u0001\u001a\u00030\u0080\u00012\u0006\u0010\u007f\u001a\u00020!H\u0002¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u0011\u0010\u0083\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\b\u0083\u0001\u0010\u000bJ\u0011\u0010\u0084\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\b\u0084\u0001\u0010\u000bJ\u001c\u0010\u0086\u0001\u001a\u00030\u0080\u00012\u0007\u0010\u0085\u0001\u001a\u00020!H\u0002¢\u0006\u0006\b\u0086\u0001\u0010\u0082\u0001J\u001c\u0010\u0087\u0001\u001a\u00030\u0080\u00012\u0007\u0010\u0085\u0001\u001a\u00020!H\u0002¢\u0006\u0006\b\u0087\u0001\u0010\u0082\u0001J\u0011\u0010\u0088\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\b\u0088\u0001\u0010\u000bJ\u0011\u0010\u0089\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\b\u0089\u0001\u0010\u000bJ\u0011\u0010\u008a\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\b\u008a\u0001\u0010\u000bJ\u0011\u0010\u008b\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\b\u008b\u0001\u0010\u000bJ\u0011\u0010\u008c\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\b\u008c\u0001\u0010\u000bJ$\u0010\u008f\u0001\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020B2\b\u0010\u008e\u0001\u001a\u00030\u008d\u0001H\u0002¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J#\u0010\u0092\u0001\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020B2\u0007\u0010\u0091\u0001\u001a\u000201H\u0002¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u001b\u0010\u0095\u0001\u001a\u00020\u000f2\u0007\u0010\u0094\u0001\u001a\u000204H\u0002¢\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001J\u0011\u0010\u0097\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\b\u0097\u0001\u0010\u000bJ/\u0010\u009b\u0001\u001a\u00020\u000f2\u001b\u0010\u009a\u0001\u001a\u0016\u0012\u0004\u0012\u00020!\u0012\u0005\u0012\u00030\u0099\u0001\u0012\u0004\u0012\u00020\u000f0\u0098\u0001H\u0002¢\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001J/\u0010\u009d\u0001\u001a\u00020\u000f2\u001b\u0010\u009a\u0001\u001a\u0016\u0012\u0004\u0012\u00020!\u0012\u0005\u0012\u00030\u0099\u0001\u0012\u0004\u0012\u00020\u000f0\u0098\u0001H\u0002¢\u0006\u0006\b\u009d\u0001\u0010\u009c\u0001J\u0011\u0010\u009e\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b\u009e\u0001\u0010\u000eJ\u0011\u0010\u009f\u0001\u001a\u00020\fH\u0002¢\u0006\u0005\b\u009f\u0001\u0010\u000eJ\u0011\u0010 \u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\b \u0001\u0010\u000bJ\u001a\u0010¡\u0001\u001a\u00020\u001c2\u0006\u00107\u001a\u00020!H\u0002¢\u0006\u0006\b¡\u0001\u0010¢\u0001J\u0011\u0010£\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\b£\u0001\u0010\u000bJ\u0011\u0010¤\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\b¤\u0001\u0010\u000bJ#\u0010¦\u0001\u001a\u00020\u000f2\u0007\u0010¥\u0001\u001a\u00020v2\u0006\u0010Q\u001a\u00020BH\u0002¢\u0006\u0006\b¦\u0001\u0010§\u0001J\u0019\u0010¨\u0001\u001a\u00020\u000f2\u0006\u0010\\\u001a\u00020BH\u0002¢\u0006\u0005\b¨\u0001\u0010SJ\u001a\u0010ª\u0001\u001a\u00020\u000f2\u0007\u0010©\u0001\u001a\u00020\u001cH\u0002¢\u0006\u0005\bª\u0001\u0010{J\u0011\u0010«\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\b«\u0001\u0010\u000bJ\u0011\u0010¬\u0001\u001a\u00020\u000fH\u0002¢\u0006\u0005\b¬\u0001\u0010\u000bJ\u001a\u0010®\u0001\u001a\u00020\u000f2\u0007\u0010\u00ad\u0001\u001a\u00020!H\u0002¢\u0006\u0005\b®\u0001\u0010HJ\u0014\u0010¯\u0001\u001a\u0004\u0018\u00010BH\u0002¢\u0006\u0006\b¯\u0001\u0010°\u0001J\u0011\u0010±\u0001\u001a\u00020\u001cH\u0002¢\u0006\u0005\b±\u0001\u0010kJ\u001a\u0010³\u0001\u001a\u00020\u000f2\u0007\u0010²\u0001\u001a\u00020\u001cH\u0002¢\u0006\u0005\b³\u0001\u0010{J\u001a\u0010µ\u0001\u001a\u00020\u000f2\u0007\u0010´\u0001\u001a\u00020!H\u0002¢\u0006\u0005\bµ\u0001\u0010HJ5\u0010½\u0001\u001a\u00030¼\u00012\b\u0010·\u0001\u001a\u00030¶\u00012\n\u0010¹\u0001\u001a\u0005\u0018\u00010¸\u00012\n\u0010»\u0001\u001a\u0005\u0018\u00010º\u0001H\u0016¢\u0006\u0006\b½\u0001\u0010¾\u0001J(\u0010À\u0001\u001a\u00020\u000f2\b\u0010¿\u0001\u001a\u00030¼\u00012\n\u0010»\u0001\u001a\u0005\u0018\u00010º\u0001H\u0016¢\u0006\u0006\bÀ\u0001\u0010Á\u0001J\u0011\u0010Â\u0001\u001a\u00020\u000fH\u0016¢\u0006\u0005\bÂ\u0001\u0010\u000bJ\u0011\u0010Ã\u0001\u001a\u00020\u000fH\u0016¢\u0006\u0005\bÃ\u0001\u0010\u000bJ*\u0010Æ\u0001\u001a\u00020\u001c2\n\u0010¿\u0001\u001a\u0005\u0018\u00010¼\u00012\n\u0010Å\u0001\u001a\u0005\u0018\u00010Ä\u0001H\u0016¢\u0006\u0006\bÆ\u0001\u0010Ç\u0001J\u0011\u0010È\u0001\u001a\u00020\u000fH\u0016¢\u0006\u0005\bÈ\u0001\u0010\u000bJ\u0019\u0010É\u0001\u001a\u00020\u000f2\u0006\u0010\u007f\u001a\u00020!H\u0016¢\u0006\u0005\bÉ\u0001\u0010HJ\u0011\u0010Ê\u0001\u001a\u00020\u000fH\u0016¢\u0006\u0005\bÊ\u0001\u0010\u000bJ\u0011\u0010Ë\u0001\u001a\u00020\u000fH\u0016¢\u0006\u0005\bË\u0001\u0010\u000bJ\u0011\u0010Ì\u0001\u001a\u00020\u000fH\u0016¢\u0006\u0005\bÌ\u0001\u0010\u000bJ\u0011\u0010Í\u0001\u001a\u00020\u000fH\u0016¢\u0006\u0005\bÍ\u0001\u0010\u000bJ\u0019\u0010Î\u0001\u001a\u00020\u000f2\u0006\u0010U\u001a\u00020!H\u0016¢\u0006\u0005\bÎ\u0001\u0010HJ\u0011\u0010Ï\u0001\u001a\u00020\u000fH\u0016¢\u0006\u0005\bÏ\u0001\u0010\u000bJ\u0011\u0010Ð\u0001\u001a\u00020\u000fH\u0016¢\u0006\u0005\bÐ\u0001\u0010\u000bJ\u0011\u0010Ñ\u0001\u001a\u00020\u000fH\u0016¢\u0006\u0005\bÑ\u0001\u0010\u000bJ\u0011\u0010Ò\u0001\u001a\u00020\u000fH\u0016¢\u0006\u0005\bÒ\u0001\u0010\u000bJ\u0011\u0010Ó\u0001\u001a\u00020\u000fH\u0016¢\u0006\u0005\bÓ\u0001\u0010\u000bJ\u0011\u0010Ô\u0001\u001a\u00020\u000fH\u0016¢\u0006\u0005\bÔ\u0001\u0010\u000bJ\u0011\u0010Õ\u0001\u001a\u00020\u000fH\u0016¢\u0006\u0005\bÕ\u0001\u0010\u000bJ\u0011\u0010Ö\u0001\u001a\u00020\u000fH\u0016¢\u0006\u0005\bÖ\u0001\u0010\u000bJ\u001c\u0010×\u0001\u001a\u00020\u001c2\b\u0010Å\u0001\u001a\u00030Ä\u0001H\u0016¢\u0006\u0006\b×\u0001\u0010Ø\u0001J\u0011\u0010Ù\u0001\u001a\u00020\u000fH\u0016¢\u0006\u0005\bÙ\u0001\u0010\u000bR\u001c\u0010Ý\u0001\u001a\u0005\u0018\u00010Ú\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÛ\u0001\u0010Ü\u0001R!\u0010ã\u0001\u001a\u00030Þ\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bß\u0001\u0010à\u0001\u001a\u0006\bá\u0001\u0010â\u0001R!\u0010è\u0001\u001a\u00030ä\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bå\u0001\u0010à\u0001\u001a\u0006\bæ\u0001\u0010ç\u0001R\u0018\u00107\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bé\u0001\u0010ê\u0001R\u001a\u0010í\u0001\u001a\u00030ë\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÐ\u0001\u0010ì\u0001R+\u0010ò\u0001\u001a\u0014\u0012\u0004\u0012\u00020!0î\u0001j\t\u0012\u0004\u0012\u00020!`ï\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bð\u0001\u0010ñ\u0001R\u001a\u00108\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bó\u0001\u0010ô\u0001R\u001b\u0010ö\u0001\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bõ\u0001\u0010ô\u0001R\u001f\u0010C\u001a\t\u0012\u0004\u0012\u00020B0÷\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bø\u0001\u0010ù\u0001R\u001c\u0010ý\u0001\u001a\u0005\u0018\u00010ú\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bû\u0001\u0010ü\u0001R\u0019\u0010\u0080\u0002\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bþ\u0001\u0010ÿ\u0001R\u0019\u0010\u0082\u0002\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0002\u0010ÿ\u0001R\u0019\u0010\u0085\u0002\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0002\u0010\u0084\u0002R\u001b\u0010\u0087\u0002\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b×\u0001\u0010\u0086\u0002R\u0019\u0010\u0089\u0002\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0002\u0010ê\u0001R\u001b\u0010\u008c\u0002\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0002\u0010\u008b\u0002R\u001e\u0010\u008f\u0002\u001a\u00020\u001c8\u0016X\u0096D¢\u0006\u000f\n\u0006\b\u008d\u0002\u0010ÿ\u0001\u001a\u0005\b\u008e\u0002\u0010kR\u001e\u0010\u0092\u0002\u001a\u00020\u001c8\u0016X\u0096D¢\u0006\u000f\n\u0006\b\u0090\u0002\u0010ÿ\u0001\u001a\u0005\b\u0091\u0002\u0010kR\u001e\u0010\u0095\u0002\u001a\u00020\u001c8\u0016X\u0096D¢\u0006\u000f\n\u0006\b\u0093\u0002\u0010ÿ\u0001\u001a\u0005\b\u0094\u0002\u0010kR\u001c\u0010\u0099\u0002\u001a\u0005\u0018\u00010\u0096\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0002\u0010\u0098\u0002R\u001a\u0010\u009d\u0002\u001a\u00030\u009a\u00028\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u009b\u0002\u0010\u009c\u0002R)\u0010¡\u0002\u001a\u00020\u001c2\u0007\u0010\u009e\u0002\u001a\u00020\u001c8\u0002@BX\u0082\u000e¢\u0006\u000f\n\u0006\b\u009f\u0002\u0010ÿ\u0001\"\u0005\b \u0002\u0010{R'\u0010¥\u0002\u001a\u00020\u001c8\u0016@\u0016X\u0096\u000e¢\u0006\u0016\n\u0006\b¢\u0002\u0010ÿ\u0001\u001a\u0005\b£\u0002\u0010k\"\u0005\b¤\u0002\u0010{R*\u0010¬\u0002\u001a\u00030¦\u00028\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\bÉ\u0001\u0010§\u0002\u001a\u0006\b¨\u0002\u0010©\u0002\"\u0006\bª\u0002\u0010«\u0002R*\u0010´\u0002\u001a\u00030\u00ad\u00028\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b®\u0002\u0010¯\u0002\u001a\u0006\b°\u0002\u0010±\u0002\"\u0006\b²\u0002\u0010³\u0002R0\u0010º\u0002\u001a\u0019\u0012\u0005\u0012\u00030¶\u0002\u0012\u0004\u0012\u00020\u001a\u0018\u00010µ\u0002j\u0005\u0018\u0001`·\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0002\u0010¹\u0002R\u001a\u0010¾\u0002\u001a\u00030»\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0002\u0010½\u0002R!\u0010Ã\u0002\u001a\n\u0012\u0005\u0012\u00030À\u00020¿\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÁ\u0002\u0010Â\u0002R\u001b\u0010Æ\u0002\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÄ\u0002\u0010Å\u0002R\u001c\u0010Ê\u0002\u001a\u0005\u0018\u00010Ç\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÈ\u0002\u0010É\u0002R\u001b\u0010Ì\u0002\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bË\u0002\u0010Å\u0002R\u0018\u0010Ï\u0002\u001a\u00030Ú\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bÍ\u0002\u0010Î\u0002¨\u0006Ò\u0002"}, d2 = {"Lir/nasim/MW6;", "Lir/nasim/ua0;", "Landroid/view/View$OnTouchListener;", "Lir/nasim/jJ4;", "Lcom/genius/multiprogressbar/MultiProgressBar$c;", "Lcom/genius/multiprogressbar/MultiProgressBar$d;", "Lir/nasim/DS6;", "Lir/nasim/DQ6;", "Lir/nasim/SW6;", "Lir/nasim/XZ;", "<init>", "()V", "Lir/nasim/gj3;", "Rb", "()Lir/nasim/gj3;", "Lir/nasim/rB7;", "Bc", "Wb", "Ub", "Tb", "Cc", "", DialogEntity.COLUMN_RID, "Vb", "(J)Lir/nasim/gj3;", "Kb", "", DialogEntity.COLUMN_MESSAGE, "", "rtl", "action", "Lkotlin/Function0;", "onClickListener", "", "length", "wd", "(Ljava/lang/String;ZLjava/lang/String;Lir/nasim/SA2;I)V", "md", "(Lir/nasim/SA2;)V", "kd", "Ab", "xc", "onDismissListener", "title", "showIcon", "nd", "(Lir/nasim/SA2;Lir/nasim/SA2;Ljava/lang/String;Z)V", "rd", "Xb", "Lir/nasim/story/model/StoryWidget$LinkWidget;", "jc", "()Lir/nasim/story/model/StoryWidget$LinkWidget;", "Lir/nasim/story/model/StoryWidget$PostWidget;", "kc", "()Lir/nasim/story/model/StoryWidget$PostWidget;", "userId", "selectedStoryId", "Yb", "(ILjava/lang/String;)Lir/nasim/gj3;", "storyId", "bc", "fromEnd", "Zb", "(IZ)Lir/nasim/gj3;", "Jc", "", "Lir/nasim/QQ6;", "storyList", "storyIndex", "Kc", "(Ljava/util/List;I)V", "Ib", "(I)V", "Dd", "hd", "zc", "Lc", "cb", "Lir/nasim/Ul1$b;", "fc", "()Lir/nasim/Ul1$b;", "storyItem", "Gb", "(Lir/nasim/QQ6;)V", "Jb", "position", "dd", "uc", "myStory", "Cd", "ib", "qb", "currentStory", "pb", "Lir/nasim/Ji5;", "popularStoryViews", "fd", "(Lir/nasim/Ji5;Lir/nasim/QQ6;)V", "Lir/nasim/d25;", "peer", "Lir/nasim/core/modules/profile/entity/ExPeerType;", DialogEntity.COLUMN_EX_PEER_TYPE, "Pc", "(Lir/nasim/d25;Lir/nasim/core/modules/profile/entity/ExPeerType;)V", "ob", "sd", "Gc", "()Z", "Ec", "Hc", "gb", "(I)Lir/nasim/gj3;", "stories", "cc", "(Ljava/util/List;)I", "fb", "Fb", "currentItem", "Lir/nasim/story/ui/viewfragment/views/a;", "lc", "(Lir/nasim/QQ6;)Lir/nasim/story/ui/viewfragment/views/a;", "hideViews", "Qc", "(Z)V", "Ad", "currentStoryItem", "gd", "newStep", "", "rc", "(I)Ljava/lang/Object;", "hb", "zb", "currentStoryPosition", "qc", "pc", "zd", "Ac", "Nb", "Zc", "yc", "Lir/nasim/story/model/StoryWidget;", "storyWidget", "Oc", "(Lir/nasim/QQ6;Lir/nasim/story/model/StoryWidget;)V", "linkWidget", "sc", "(Lir/nasim/QQ6;Lir/nasim/story/model/StoryWidget$LinkWidget;)V", "postWidget", "tc", "(Lir/nasim/story/model/StoryWidget$PostWidget;)V", "Vc", "Lkotlin/Function2;", "Lir/nasim/OP5;", "onResult", "vd", "(Lir/nasim/iB2;)V", "Tc", "Pb", "Sb", "Ob", "Dc", "(I)Z", "Bd", "ad", "state", "Mc", "(Lir/nasim/story/ui/viewfragment/views/a;Lir/nasim/QQ6;)V", "Sc", "visible", "cd", "jd", "Qb", "progress", "ed", "ic", "()Lir/nasim/QQ6;", "Fc", "isOn", "Ic", "color", "Lb", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "U6", "T6", "Landroid/view/MotionEvent;", "event", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", TokenNames.U, "E1", "a1", "c7", "S0", "onClose", "M4", "v4", "l1", "P2", "I4", "y3", "a5", "n4", "O2", "u1", "(Landroid/view/MotionEvent;)Z", "i9", "Lir/nasim/Bz2;", "h1", "Lir/nasim/Bz2;", "_binding", "Lir/nasim/bX6;", "i1", "Lir/nasim/Yu3;", "oc", "()Lir/nasim/bX6;", "viewModel", "Lir/nasim/mX6;", "j1", "nc", "()Lir/nasim/mX6;", "storyViewViewModel", "k1", TokenNames.I, "Lir/nasim/xV6;", "Lir/nasim/xV6;", "storyType", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "m1", "Ljava/util/ArrayList;", "userIdList", "n1", "Ljava/lang/String;", "o1", "jumpToStoryId", "", "p1", "Ljava/util/List;", "Lir/nasim/px4;", "q1", "Lir/nasim/px4;", "storyAdapter", "r1", "Z", "isDiscreteMode", "s1", "isLiked", "t1", "J", "storyStartTime", "Lir/nasim/QQ6;", "lastViewedStory", "v1", "loadedStoryPosition", "w1", "Ljava/lang/Integer;", "originalNavigationBarColor", "x1", "P0", "autoSystemBarBottom", "y1", "F0", "autoSystemBarTop", "z1", "l2", "autoIme", "Lir/nasim/n10;", "A1", "Lir/nasim/n10;", "snackBar", "Lir/nasim/EQ6;", "B1", "Lir/nasim/EQ6;", "storyGestureDetector", "value", "C1", "bd", "canGoNextStory", "D1", "s3", "U1", "hasBeenResumed", "Lir/nasim/dQ0;", "Lir/nasim/dQ0;", "ec", "()Lir/nasim/dQ0;", "setChatNavigator", "(Lir/nasim/dQ0;)V", "chatNavigator", "Lir/nasim/zP5;", "F1", "Lir/nasim/zP5;", "mc", "()Lir/nasim/zP5;", "setReportNavigator", "(Lir/nasim/zP5;)V", "reportNavigator", "Lir/nasim/XV4;", "Lir/nasim/D20;", "Lir/nasim/story/ui/viewfragment/BalloonToStoryId;", "G1", "Lir/nasim/XV4;", "postToStoryOnboardingTooltip", "ir/nasim/MW6$r", "H1", "Lir/nasim/MW6$r;", "pagerChangeCallback", "Lir/nasim/ij3;", "Lir/nasim/cj5;", "I1", "Lir/nasim/ij3;", "showPostOnboardingTooltipTracker", "J1", "Lir/nasim/gj3;", "uploadProgressJob", "Lir/nasim/Jl1;", "K1", "Lir/nasim/Jl1;", "contextMenu", "L1", "downloadJob", "dc", "()Lir/nasim/Bz2;", "binding", "M1", "a", "story_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes7.dex */
public final class MW6 extends VX2 implements View.OnTouchListener, InterfaceC15279jJ4, MultiProgressBar.c, MultiProgressBar.d, DS6, DQ6, SW6, XZ {

    /* renamed from: M1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int N1 = 8;

    /* renamed from: A1, reason: from kotlin metadata */
    private C17468n10 snackBar;

    /* renamed from: B1, reason: from kotlin metadata */
    private EQ6 storyGestureDetector;

    /* renamed from: C1, reason: from kotlin metadata */
    private boolean canGoNextStory;

    /* renamed from: D1, reason: from kotlin metadata */
    private boolean hasBeenResumed;

    /* renamed from: E1, reason: from kotlin metadata */
    public InterfaceC11677dQ0 chatNavigator;

    /* renamed from: F1, reason: from kotlin metadata */
    public InterfaceC24908zP5 reportNavigator;

    /* renamed from: G1, reason: from kotlin metadata */
    private XV4 postToStoryOnboardingTooltip;

    /* renamed from: H1, reason: from kotlin metadata */
    private r pagerChangeCallback;

    /* renamed from: I1, reason: from kotlin metadata */
    private C14931ij3 showPostOnboardingTooltipTracker;

    /* renamed from: J1, reason: from kotlin metadata */
    private InterfaceC13730gj3 uploadProgressJob;

    /* renamed from: K1, reason: from kotlin metadata */
    private AbstractC5462Jl1 contextMenu;

    /* renamed from: L1, reason: from kotlin metadata */
    private InterfaceC13730gj3 downloadJob;

    /* renamed from: h1, reason: from kotlin metadata */
    private C3702Bz2 _binding;

    /* renamed from: i1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.aW6
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return MW6.Ed(this.a);
        }
    });

    /* renamed from: j1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 storyViewViewModel;

    /* renamed from: k1, reason: from kotlin metadata */
    private int userId;

    /* renamed from: l1, reason: from kotlin metadata */
    private EnumC23779xV6 storyType;

    /* renamed from: m1, reason: from kotlin metadata */
    private ArrayList userIdList;

    /* renamed from: n1, reason: from kotlin metadata */
    private String selectedStoryId;

    /* renamed from: o1, reason: from kotlin metadata */
    private String jumpToStoryId;

    /* renamed from: p1, reason: from kotlin metadata */
    private List storyList;

    /* renamed from: q1, reason: from kotlin metadata */
    private C19207px4 storyAdapter;

    /* renamed from: r1, reason: from kotlin metadata */
    private boolean isDiscreteMode;

    /* renamed from: s1, reason: from kotlin metadata */
    private boolean isLiked;

    /* renamed from: t1, reason: from kotlin metadata */
    private long storyStartTime;

    /* renamed from: u1, reason: from kotlin metadata */
    private QQ6 lastViewedStory;

    /* renamed from: v1, reason: from kotlin metadata */
    private int loadedStoryPosition;

    /* renamed from: w1, reason: from kotlin metadata */
    private Integer originalNavigationBarColor;

    /* renamed from: x1, reason: from kotlin metadata */
    private final boolean autoSystemBarBottom;

    /* renamed from: y1, reason: from kotlin metadata */
    private final boolean autoSystemBarTop;

    /* renamed from: z1, reason: from kotlin metadata */
    private final boolean autoIme;

    /* renamed from: ir.nasim.MW6$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C22042ua0 a(int i, List list, String str, String str2, WV6 wv6, int i2) {
            AbstractC13042fc3.i(list, "userIdList");
            MW6 mw6 = new MW6();
            Bundle bundle = new Bundle();
            bundle.putInt("USER_ID_KEY", i);
            Integer[] numArr = (Integer[]) list.toArray(new Integer[0]);
            bundle.putIntegerArrayList("USER_ID_LIST_KEY", AbstractC10360bX0.g(Arrays.copyOf(numArr, numArr.length)));
            bundle.putString("SELECTED_STORY_ID_KEY", str);
            bundle.putString("JUMP_TO_STORY_ID_KEY", str2);
            bundle.putString("BUNDLE_STORY_OPENING_ORIGIN", wv6 != null ? wv6.name() : null);
            bundle.putInt("BUNDLE_STORY_POSITION", i2);
            mw6.a8(bundle);
            return mw6;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[YK6.values().length];
            try {
                iArr[YK6.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[YK6.a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[YK6.b.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[YK6.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
            int[] iArr2 = new int[E25.values().length];
            try {
                iArr2[E25.VERIFIED.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[E25.LEGAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            b = iArr2;
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ QQ6 d;

        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ MW6 a;
            final /* synthetic */ QQ6 b;

            a(MW6 mw6, QQ6 qq6) {
                this.a = mw6;
                this.b = qq6;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(C5439Ji5 c5439Ji5, InterfaceC20295rm1 interfaceC20295rm1) {
                this.a.fd(c5439Ji5, this.b);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(QQ6 qq6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = qq6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return MW6.this.new c(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10040ay6 interfaceC10040ay6Z3 = MW6.this.oc().Z3();
                a aVar = new a(MW6.this, this.d);
                this.b = 1;
                if (interfaceC10040ay6Z3.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class d implements InterfaceC12925fP5 {
        final /* synthetic */ QQ6 b;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ MW6 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(MW6 mw6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = mw6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    this.b = 1;
                    if (HG1.b(150L, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                MW6 mw6 = this.c;
                String strH6 = mw6.h6(SD5.story_reply_sent);
                AbstractC13042fc3.h(strH6, "getString(...)");
                MW6.xd(mw6, strH6, false, null, null, 0, 30, null);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        d(QQ6 qq6) {
            this.b = qq6;
        }

        @Override // ir.nasim.InterfaceC12925fP5
        public boolean a() {
            return MW6.this.dc().o.E(true);
        }

        @Override // ir.nasim.InterfaceC12925fP5
        public void b(ir.nasim.story.ui.viewfragment.views.a aVar) {
            AbstractC13042fc3.i(aVar, "state");
            MW6.this.Mc(aVar, this.b);
        }

        @Override // ir.nasim.InterfaceC12925fP5
        public void c(boolean z) {
            if (z) {
                MW6.this.Ad();
            } else {
                MW6.this.Qc(false);
            }
        }

        @Override // ir.nasim.InterfaceC12925fP5
        public void d(String str) {
            AbstractC13042fc3.i(str, ParameterNames.TEXT);
            AbstractC10533bm0.d(AbstractC19224pz3.a(MW6.this), null, null, new a(MW6.this, null), 3, null);
            MW6.this.Ob();
            MW6.this.nc().j1(str, MW6.this.userId, this.b);
            ReplyStoryView replyStoryView = MW6.this.dc().d.getReplyStoryView();
            if (replyStoryView != null) {
                replyStoryView.f();
                replyStoryView.clearFocus();
            }
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ MW6 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(MW6 mw6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = mw6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    this.b = 1;
                    if (HG1.b(300L, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                if (this.c.dc().l.getProgressPercents() == 100) {
                    int currentStep = this.c.dc().l.getCurrentStep();
                    if (currentStep == this.c.storyList.size()) {
                        this.c.U();
                    } else {
                        this.c.l1();
                        this.c.E1(currentStep);
                    }
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return MW6.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                MW6 mw6 = MW6.this;
                j.b bVar = j.b.RESUMED;
                a aVar = new a(mw6, null);
                this.b = 1;
                if (androidx.lifecycle.w.b(mw6, bVar, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ MW6 a;

            a(MW6 mw6) {
                this.a = mw6;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(W9 w9, InterfaceC20295rm1 interfaceC20295rm1) {
                if (AbstractC13042fc3.d(w9, W9.a.a)) {
                    MW6 mw6 = this.a;
                    String strH6 = mw6.h6(SD5.story_add_story_restricted_error);
                    AbstractC13042fc3.h(strH6, "getString(...)");
                    MW6.xd(mw6, strH6, false, null, null, -2, 14, null);
                }
                return C19938rB7.a;
            }
        }

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return MW6.this.new f(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6A3 = MW6.this.oc().A3();
                a aVar = new a(MW6.this);
                this.b = 1;
                if (interfaceC10258bL6A3.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ MW6 a;

            a(MW6 mw6) {
                this.a = mw6;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            public /* bridge */ /* synthetic */ Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return b(((Number) obj).intValue(), interfaceC20295rm1);
            }

            public final Object b(int i, InterfaceC20295rm1 interfaceC20295rm1) {
                InterfaceC13730gj3 interfaceC13730gj3;
                this.a.ed(i);
                if (i == 100 && (interfaceC13730gj3 = this.a.downloadJob) != null) {
                    InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
                }
                return C19938rB7.a;
            }
        }

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return MW6.this.new g(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                QQ6 qq6Ic = MW6.this.ic();
                if (qq6Ic == null) {
                    return C19938rB7.a;
                }
                InterfaceC4557Fq2 interfaceC4557Fq2E3 = MW6.this.oc().E3(qq6Ic);
                if (interfaceC4557Fq2E3 != null) {
                    a aVar = new a(MW6.this);
                    this.b = 1;
                    if (interfaceC4557Fq2E3.b(aVar, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ MW6 c;

            /* renamed from: ir.nasim.MW6$h$a$a, reason: collision with other inner class name */
            static final class C0496a implements InterfaceC4806Gq2 {
                final /* synthetic */ MW6 a;

                /* renamed from: ir.nasim.MW6$h$a$a$a, reason: collision with other inner class name */
                static final class C0497a implements InterfaceC15796kB2 {
                    final /* synthetic */ LA3 a;
                    final /* synthetic */ MW6 b;

                    C0497a(LA3 la3, MW6 mw6) {
                        this.a = la3;
                        this.b = mw6;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final C19938rB7 c(MW6 mw6, LA3 la3) {
                        AbstractC13042fc3.i(mw6, "this$0");
                        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
                        Context contextS7 = mw6.S7();
                        AbstractC13042fc3.h(contextS7, "requireContext(...)");
                        aVar.A(contextS7, Uri.parse(((LA3.a) la3).a()));
                        return C19938rB7.a;
                    }

                    public final void b(Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        AbstractC13042fc3.i(dialog, "dialog");
                        String strA = ((LA3.a) this.a).a();
                        interfaceC22053ub1.W(2003636933);
                        boolean zD = interfaceC22053ub1.D(this.b) | interfaceC22053ub1.D(this.a);
                        final MW6 mw6 = this.b;
                        final LA3 la3 = this.a;
                        Object objB = interfaceC22053ub1.B();
                        if (zD || objB == InterfaceC22053ub1.a.a()) {
                            objB = new SA2() { // from class: ir.nasim.NW6
                                @Override // ir.nasim.SA2
                                public final Object invoke() {
                                    return MW6.h.a.C0496a.C0497a.c(mw6, la3);
                                }
                            };
                            interfaceC22053ub1.s(objB);
                        }
                        interfaceC22053ub1.Q();
                        AbstractC10781cB3.q(dialog, strA, (SA2) objB, interfaceC22053ub1, i & 14);
                    }

                    @Override // ir.nasim.InterfaceC15796kB2
                    public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                        b((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.MW6$h$a$a$b */
                static final class b implements InterfaceC15796kB2 {
                    final /* synthetic */ LA3 a;

                    b(LA3 la3) {
                        this.a = la3;
                    }

                    public final void a(Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        AbstractC13042fc3.i(dialog, "dialog");
                        AbstractC10781cB3.n(dialog, ((LA3.b) this.a).b(), interfaceC22053ub1, i & 14);
                    }

                    @Override // ir.nasim.InterfaceC15796kB2
                    public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                        a((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.MW6$h$a$a$c */
                static final class c implements InterfaceC15796kB2 {
                    final /* synthetic */ LA3 a;
                    final /* synthetic */ MW6 b;

                    c(LA3 la3, MW6 mw6) {
                        this.a = la3;
                        this.b = mw6;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final C19938rB7 c(MW6 mw6, LA3 la3) {
                        AbstractC13042fc3.i(mw6, "this$0");
                        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
                        Context contextS7 = mw6.S7();
                        AbstractC13042fc3.h(contextS7, "requireContext(...)");
                        aVar.A(contextS7, Uri.parse(((LA3.b) la3).b()));
                        return C19938rB7.a;
                    }

                    public final void b(Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        AbstractC13042fc3.i(dialog, "dialog");
                        String strB = ((LA3.b) this.a).b();
                        interfaceC22053ub1.W(2003685133);
                        boolean zD = interfaceC22053ub1.D(this.b) | interfaceC22053ub1.D(this.a);
                        final MW6 mw6 = this.b;
                        final LA3 la3 = this.a;
                        Object objB = interfaceC22053ub1.B();
                        if (zD || objB == InterfaceC22053ub1.a.a()) {
                            objB = new SA2() { // from class: ir.nasim.OW6
                                @Override // ir.nasim.SA2
                                public final Object invoke() {
                                    return MW6.h.a.C0496a.c.c(mw6, la3);
                                }
                            };
                            interfaceC22053ub1.s(objB);
                        }
                        interfaceC22053ub1.Q();
                        AbstractC10781cB3.C(dialog, strB, (SA2) objB, interfaceC22053ub1, i & 14);
                    }

                    @Override // ir.nasim.InterfaceC15796kB2
                    public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                        b((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.MW6$h$a$a$d */
                public /* synthetic */ class d {
                    public static final /* synthetic */ int[] a;

                    static {
                        int[] iArr = new int[EnumC4458Ff2.values().length];
                        try {
                            iArr[EnumC4458Ff2.a.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[EnumC4458Ff2.b.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[EnumC4458Ff2.c.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        a = iArr;
                    }
                }

                C0496a(MW6 mw6) {
                    this.a = mw6;
                }

                @Override // ir.nasim.InterfaceC4806Gq2
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object a(LA3 la3, InterfaceC20295rm1 interfaceC20295rm1) {
                    this.a.dc().q.setProgressBarVisibility(false);
                    if (la3 == null) {
                        return C19938rB7.a;
                    }
                    if (la3 instanceof LA3.a) {
                        Context contextS7 = this.a.S7();
                        AbstractC13042fc3.h(contextS7, "requireContext(...)");
                        MW6 mw6 = this.a;
                        AbstractC21375tZ.c(contextS7, mw6, null, AbstractC19242q11.c(-660288916, true, new C0497a(la3, mw6)), 4, null).show();
                    } else {
                        if (!(la3 instanceof LA3.b)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        LA3.b bVar = (LA3.b) la3;
                        int i = d.a[bVar.a().ordinal()];
                        if (i == 1) {
                            AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
                            Context contextS72 = this.a.S7();
                            AbstractC13042fc3.h(contextS72, "requireContext(...)");
                            aVar.A(contextS72, Uri.parse(bVar.b()));
                        } else if (i == 2) {
                            Context contextS73 = this.a.S7();
                            AbstractC13042fc3.h(contextS73, "requireContext(...)");
                            AbstractC21375tZ.c(contextS73, this.a, null, AbstractC19242q11.c(-868669962, true, new b(la3)), 4, null).show();
                        } else {
                            if (i != 3) {
                                throw new NoWhenBranchMatchedException();
                            }
                            Context contextS74 = this.a.S7();
                            AbstractC13042fc3.h(contextS74, "requireContext(...)");
                            MW6 mw62 = this.a;
                            AbstractC21375tZ.c(contextS74, mw62, null, AbstractC19242q11.c(1684073493, true, new c(la3, mw62)), 4, null).show();
                        }
                    }
                    this.a.oc().w5();
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(MW6 mw6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = mw6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC10258bL6 interfaceC10258bL6R3 = this.c.oc().R3();
                    C0496a c0496a = new C0496a(this.c);
                    this.b = 1;
                    if (interfaceC10258bL6R3.b(c0496a, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                throw new KotlinNothingValueException();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return MW6.this.new h(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                MW6 mw6 = MW6.this;
                j.b bVar = j.b.RESUMED;
                a aVar = new a(mw6, null);
                this.b = 1;
                if (androidx.lifecycle.w.b(mw6, bVar, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ MW6 a;

            /* renamed from: ir.nasim.MW6$i$a$a, reason: collision with other inner class name */
            static final class C0498a extends AbstractC22163um1 {
                Object a;
                /* synthetic */ Object b;
                int d;

                C0498a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.b = obj;
                    this.d |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            a(MW6 mw6) {
                this.a = mw6;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(ir.nasim.AbstractC14180hU6 r13, ir.nasim.InterfaceC20295rm1 r14) {
                /*
                    r12 = this;
                    boolean r0 = r14 instanceof ir.nasim.MW6.i.a.C0498a
                    if (r0 == 0) goto L13
                    r0 = r14
                    ir.nasim.MW6$i$a$a r0 = (ir.nasim.MW6.i.a.C0498a) r0
                    int r1 = r0.d
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.d = r1
                    goto L18
                L13:
                    ir.nasim.MW6$i$a$a r0 = new ir.nasim.MW6$i$a$a
                    r0.<init>(r14)
                L18:
                    java.lang.Object r14 = r0.b
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.d
                    java.lang.String r3 = "getString(...)"
                    r4 = 2
                    r5 = 1
                    if (r2 == 0) goto L42
                    if (r2 == r5) goto L3a
                    if (r2 != r4) goto L32
                    java.lang.Object r13 = r0.a
                    ir.nasim.MW6$i$a r13 = (ir.nasim.MW6.i.a) r13
                    ir.nasim.AbstractC10685c16.b(r14)
                    goto L86
                L32:
                    java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                    java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                    r13.<init>(r14)
                    throw r13
                L3a:
                    java.lang.Object r13 = r0.a
                    ir.nasim.MW6$i$a r13 = (ir.nasim.MW6.i.a) r13
                    ir.nasim.AbstractC10685c16.b(r14)
                    goto L57
                L42:
                    ir.nasim.AbstractC10685c16.b(r14)
                    boolean r14 = r13 instanceof ir.nasim.AbstractC14180hU6.b
                    r6 = 200(0xc8, double:9.9E-322)
                    if (r14 == 0) goto L76
                    r0.a = r12
                    r0.d = r5
                    java.lang.Object r13 = ir.nasim.HG1.b(r6, r0)
                    if (r13 != r1) goto L56
                    return r1
                L56:
                    r13 = r12
                L57:
                    ir.nasim.MW6 r4 = r13.a
                    int r14 = ir.nasim.SD5.report_send_successfully
                    java.lang.String r5 = r4.h6(r14)
                    ir.nasim.AbstractC13042fc3.h(r5, r3)
                    r10 = 30
                    r11 = 0
                    r6 = 0
                    r7 = 0
                    r8 = 0
                    r9 = 0
                    ir.nasim.MW6.xd(r4, r5, r6, r7, r8, r9, r10, r11)
                    ir.nasim.MW6 r13 = r13.a
                    ir.nasim.bX6 r13 = ir.nasim.MW6.Pa(r13)
                    r13.Q2()
                    goto La7
                L76:
                    boolean r14 = r13 instanceof ir.nasim.AbstractC14180hU6.a
                    if (r14 == 0) goto La5
                    r0.a = r12
                    r0.d = r4
                    java.lang.Object r13 = ir.nasim.HG1.b(r6, r0)
                    if (r13 != r1) goto L85
                    return r1
                L85:
                    r13 = r12
                L86:
                    ir.nasim.MW6 r4 = r13.a
                    int r14 = ir.nasim.SD5.there_was_an_error_when_send_report
                    java.lang.String r5 = r4.h6(r14)
                    ir.nasim.AbstractC13042fc3.h(r5, r3)
                    r10 = 30
                    r11 = 0
                    r6 = 0
                    r7 = 0
                    r8 = 0
                    r9 = 0
                    ir.nasim.MW6.xd(r4, r5, r6, r7, r8, r9, r10, r11)
                    ir.nasim.MW6 r13 = r13.a
                    ir.nasim.bX6 r13 = ir.nasim.MW6.Pa(r13)
                    r13.Q2()
                    goto La7
                La5:
                    if (r13 != 0) goto Laa
                La7:
                    ir.nasim.rB7 r13 = ir.nasim.C19938rB7.a
                    return r13
                Laa:
                    kotlin.NoWhenBranchMatchedException r13 = new kotlin.NoWhenBranchMatchedException
                    r13.<init>()
                    throw r13
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.MW6.i.a.a(ir.nasim.hU6, ir.nasim.rm1):java.lang.Object");
            }
        }

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return MW6.this.new i(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6D4 = MW6.this.oc().d4();
                a aVar = new a(MW6.this);
                this.b = 1;
                if (interfaceC10258bL6D4.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ MW6 a;

            /* renamed from: ir.nasim.MW6$j$a$a, reason: collision with other inner class name */
            public static final class C0499a implements InterfaceC5024Ho4 {
                final /* synthetic */ QQ6 a;
                final /* synthetic */ MW6 b;

                C0499a(QQ6 qq6, MW6 mw6) {
                    this.a = qq6;
                    this.b = mw6;
                }

                @Override // ir.nasim.InterfaceC5024Ho4
                public void r() {
                    PeersStruct$ExPeer peersStruct$ExPeerG;
                    QQ6 qq6Ic = this.b.ic();
                    if (qq6Ic != null && (peersStruct$ExPeerG = qq6Ic.g()) != null) {
                        this.b.oc().T5(peersStruct$ExPeerG);
                    }
                    this.b.Qc(false);
                    MW6 mw6 = this.b;
                    C22042ua0.m9(mw6, mw6, false, 2, null);
                    C22042ua0.A9(this.b, C20672sP6.INSTANCE.a(StoryAdderSourceCallerEnum.b), false, null, 6, null);
                }

                @Override // ir.nasim.InterfaceC5024Ho4
                public void s() {
                    PeersStruct$ExPeer peersStruct$ExPeerG = this.a.g();
                    if ((peersStruct$ExPeerG != null ? peersStruct$ExPeerG.getType() : null) == EnumC10088b35.ExPeerType_BOT) {
                        return;
                    }
                    C22042ua0.A9(this.b, C24387yX6.n1.a(this.a.l(), this.b), false, null, 6, null);
                }
            }

            a(MW6 mw6) {
                this.a = mw6;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(C21364tX6 c21364tX6, InterfaceC20295rm1 interfaceC20295rm1) {
                QQ6 qq6Ic = this.a.ic();
                if (qq6Ic == null) {
                    return C19938rB7.a;
                }
                if (AbstractC13042fc3.d(c21364tX6.a(), qq6Ic.l())) {
                    this.a.dc().d.setState(new a.C1551a(AbstractC6392Nk0.d(this.a.oc().R4()), AbstractC6392Nk0.d(this.a.oc().P3()), new C0499a(qq6Ic, this.a)));
                }
                return C19938rB7.a;
            }
        }

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return MW6.this.new j(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10040ay6 interfaceC10040ay6X4 = MW6.this.oc().x4();
                a aVar = new a(MW6.this);
                this.b = 1;
                if (interfaceC10040ay6X4.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ MW6 a;

            a(MW6 mw6) {
                this.a = mw6;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                Object next;
                if (list != null) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Object obj : list) {
                        String strB = ((JX6) obj).b();
                        Object arrayList = linkedHashMap.get(strB);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            linkedHashMap.put(strB, arrayList);
                        }
                        ((List) arrayList).add(obj);
                    }
                    MW6 mw6 = this.a;
                    for (Map.Entry entry : linkedHashMap.entrySet()) {
                        String str = (String) entry.getKey();
                        List list2 = (List) entry.getValue();
                        Iterator it = mw6.storyList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it.next();
                            if (AbstractC13042fc3.d(((QQ6) next).l(), str)) {
                                break;
                            }
                        }
                        QQ6 qq6 = (QQ6) next;
                        if (qq6 != null) {
                            List list3 = list2;
                            ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list3, 10));
                            Iterator it2 = list3.iterator();
                            while (it2.hasNext()) {
                                arrayList2.add(((JX6) it2.next()).c());
                            }
                            qq6.M(arrayList2);
                        }
                        QQ6 qq6Ic = mw6.ic();
                        if (AbstractC13042fc3.d(qq6Ic != null ? qq6Ic.l() : null, str)) {
                            mw6.uc();
                            if (mw6.canGoNextStory) {
                                mw6.zd();
                            }
                        }
                    }
                }
                return C19938rB7.a;
            }
        }

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return MW6.this.new k(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10040ay6 interfaceC10040ay6Z4 = MW6.this.oc().z4();
                a aVar = new a(MW6.this);
                this.b = 1;
                if (interfaceC10040ay6Z4.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ int c;
            final /* synthetic */ MW6 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(MW6 mw6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = mw6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = ((Number) obj).intValue();
                return aVar;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return n(((Number) obj).intValue(), (InterfaceC20295rm1) obj2);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.d.dc().d.setProgress(this.c <= 99 ? -1 : 100);
                return C19938rB7.a;
            }

            public final Object n(int i, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(Integer.valueOf(i), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return MW6.this.new l(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C17037mH7 c17037mH7A = MW6.this.oc().H4().a(this.d);
                if (c17037mH7A == null) {
                    return C19938rB7.a;
                }
                InterfaceC9336Zm4 interfaceC9336Zm4B = c17037mH7A.b();
                a aVar = new a(MW6.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC9336Zm4B, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ float c;
            final /* synthetic */ MW6 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(MW6 mw6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = mw6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = ((Number) obj).floatValue();
                return aVar;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return n(((Number) obj).floatValue(), (InterfaceC20295rm1) obj2);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.d.dc().t.setVolumeIcon(this.c == 0.0f);
                return C19938rB7.a;
            }

            public final Object n(float f, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(Float.valueOf(f), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        m(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(MW6 mw6, boolean z) {
            mw6.oc().a6(z);
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return MW6.this.new m(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                TopBarStoryView topBarStoryView = MW6.this.dc().t;
                final MW6 mw6 = MW6.this;
                topBarStoryView.setOnChangeMute(new UA2() { // from class: ir.nasim.PW6
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj2) {
                        return MW6.m.y(mw6, ((Boolean) obj2).booleanValue());
                    }
                });
                InterfaceC4557Fq2 interfaceC4557Fq2O4 = MW6.this.oc().O4();
                a aVar = new a(MW6.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2O4, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((m) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class n extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;
        final /* synthetic */ String e;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ MW6 d;
            final /* synthetic */ String e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(MW6 mw6, String str, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = mw6;
                this.e = str;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                List list = (List) this.c;
                MW6 mw6 = this.d;
                mw6.storyList = mw6.oc().v3(AbstractC15401jX0.p1(list), this.e);
                MW6 mw62 = this.d;
                mw62.Kc(mw62.storyList, 0);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(int i, String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return MW6.this.new n(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2Q4 = MW6.this.oc().q4(this.d);
                a aVar = new a(MW6.this, this.e, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2Q4, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((n) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class o extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;
        final /* synthetic */ boolean e;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ MW6 d;
            final /* synthetic */ boolean e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(MW6 mw6, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = mw6;
                this.e = z;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.d.storyList = AbstractC15401jX0.p1((List) this.c);
                MW6 mw6 = this.d;
                int iCc = mw6.cc(mw6.storyList);
                int iMax = (!this.e || iCc >= 0) ? Math.max(0, iCc) : this.d.storyList.size() - 1;
                MW6 mw62 = this.d;
                mw62.Kc(mw62.storyList, iMax);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(int i, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return MW6.this.new o(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2Q4 = MW6.this.oc().q4(this.d);
                a aVar = new a(MW6.this, this.e, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2Q4, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((o) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class p extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;
        final /* synthetic */ String e;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ MW6 d;
            final /* synthetic */ String e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(MW6 mw6, String str, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = mw6;
                this.e = str;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                List list = (List) this.c;
                this.d.storyList = AbstractC15401jX0.p1(list);
                String str = this.e;
                Iterator it = list.iterator();
                int i = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i = -1;
                        break;
                    }
                    if (AbstractC13042fc3.d(((QQ6) it.next()).l(), str)) {
                        break;
                    }
                    i++;
                }
                this.d.Kc(list, Math.max(0, i));
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p(int i, String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return MW6.this.new p(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2Q4 = MW6.this.oc().q4(this.d);
                a aVar = new a(MW6.this, this.e, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2Q4, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((p) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class q extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ MW6 a;

            a(MW6 mw6) {
                this.a = mw6;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(QQ6 qq6, InterfaceC20295rm1 interfaceC20295rm1) {
                Iterator it = this.a.storyList.iterator();
                int i = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i = -1;
                        break;
                    }
                    if (((QQ6) it.next()).F(qq6)) {
                        break;
                    }
                    i++;
                }
                if (i < 0) {
                    return C19938rB7.a;
                }
                this.a.storyList.set(i, qq6);
                QQ6 qq6Ic = this.a.ic();
                if (qq6Ic != null && qq6Ic.F(qq6)) {
                    MW6 mw6 = this.a;
                    mw6.Kc(mw6.storyList, i);
                    this.a.dd(i);
                }
                return C19938rB7.a;
            }
        }

        q(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return MW6.this.new q(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10040ay6 interfaceC10040ay6G4 = MW6.this.oc().G4();
                a aVar = new a(MW6.this);
                this.b = 1;
                if (interfaceC10040ay6G4.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((q) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class r extends ViewPager2.i {
        r() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void c(int i) {
            MW6.this.dc().q.setVisibility(8);
            if (((QQ6) MW6.this.storyList.get(i)).E()) {
                MW6.this.qb(i);
            }
        }
    }

    public static final class s implements InterfaceC3313Ai5 {
        final /* synthetic */ QQ6 b;

        s(QQ6 qq6) {
            this.b = qq6;
        }

        @Override // ir.nasim.InterfaceC3313Ai5
        public boolean a() {
            return MW6.this.dc().o.E(true);
        }

        @Override // ir.nasim.InterfaceC3313Ai5
        public void b(ir.nasim.story.ui.viewfragment.views.a aVar) {
            AbstractC13042fc3.i(aVar, "state");
            MW6.this.Mc(aVar, this.b);
        }
    }

    public static final class t extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    public static final class u extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    public static final class v extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    public static final class w extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = sa2;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            if (sa2 != null && (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) != null) {
                return abstractC20375ru1;
            }
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            return hVar != null ? hVar.p3() : AbstractC20375ru1.a.b;
        }
    }

    public static final class x extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = fragment;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            G.c cVarN3;
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            if (hVar != null && (cVarN3 = hVar.n3()) != null) {
                return cVarN3;
            }
            G.c cVarN32 = this.e.n3();
            AbstractC13042fc3.h(cVarN32, "defaultViewModelProviderFactory");
            return cVarN32;
        }
    }

    static final class y extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;

        y(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return MW6.this.new y(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            MW6 mw6;
            MultiProgressBar multiProgressBar;
            Object objE = AbstractC14862ic3.e();
            int i = this.d;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                MultiProgressBar multiProgressBar2 = MW6.this.dc().l;
                mw6 = MW6.this;
                this.b = mw6;
                this.c = multiProgressBar2;
                this.d = 1;
                if (HG1.b(200L, this) == objE) {
                    return objE;
                }
                multiProgressBar = multiProgressBar2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                multiProgressBar = (MultiProgressBar) this.c;
                mw6 = (MW6) this.b;
                AbstractC10685c16.b(obj);
            }
            if (multiProgressBar.getCurrentStep() != mw6.loadedStoryPosition || !mw6.getHasBeenResumed()) {
                mw6.Qc(false);
            } else if (multiProgressBar.k()) {
                mw6.l1();
                mw6.ad();
                mw6.Ob();
            }
            MW6.this.Ic(true);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((y) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public MW6() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new u(new t(this)));
        this.storyViewViewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C17180mX6.class), new v(interfaceC9173Yu3B), new w(null, interfaceC9173Yu3B), new x(this, interfaceC9173Yu3B));
        this.storyType = EnumC23779xV6.a;
        this.userIdList = new ArrayList();
        this.storyList = new ArrayList();
        this.isDiscreteMode = true;
        this.loadedStoryPosition = -1;
        this.canGoNextStory = true;
        this.pagerChangeCallback = new r();
        this.showPostOnboardingTooltipTracker = new C14931ij3();
    }

    private final void Ab() {
        if (C8386Vt0.a.lb()) {
            ReactionHandler reactionHandler = dc().o;
            androidx.lifecycle.j lifecycle = getLifecycle();
            AbstractC13042fc3.h(lifecycle, "<get-lifecycle>(...)");
            reactionHandler.D(lifecycle);
            dc().o.r(nc());
            dc().o.B(new UA2() { // from class: ir.nasim.iW6
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return MW6.Bb(this.a, (C12853fH5) obj);
                }
            }, new SA2() { // from class: ir.nasim.jW6
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return MW6.Cb(this.a);
                }
            }, new SA2() { // from class: ir.nasim.kW6
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return MW6.Db(this.a);
                }
            }, new SA2() { // from class: ir.nasim.mW6
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return MW6.Eb(this.a);
                }
            });
        }
    }

    private final void Ac() {
        dc().t.setVisibility(4);
        dc().l.setVisibility(4);
        dc().r.setVisibility(4);
        dc().d.setVisibility(4);
        if (dc().o.getVisibility() != 8) {
            dc().o.setVisibility(4);
        }
        dc().q.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 Ad() {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new y(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Bb(MW6 mw6, C12853fH5 c12853fH5) {
        ir.nasim.story.ui.viewfragment.views.a bVar;
        AbstractC13042fc3.i(mw6, "this$0");
        AbstractC13042fc3.i(c12853fH5, "reactionItem");
        QQ6 qq6Ic = mw6.ic();
        if (qq6Ic == null) {
            return C19938rB7.a;
        }
        if (c12853fH5.b()) {
            bVar = new a.c(true);
        } else if (AbstractC19455qN7.e(c12853fH5.a())) {
            mw6.Sc(qq6Ic);
            bVar = new a.C1549a(true);
        } else {
            bVar = new a.b(c12853fH5.a(), true);
        }
        if (mw6.Hc()) {
            PopularStoryBarView popularStoryBarView = mw6.dc().d.getPopularStoryBarView();
            if (popularStoryBarView != null) {
                popularStoryBarView.setReaction(bVar);
            }
        } else {
            ReplyStoryView replyStoryView = mw6.dc().d.getReplyStoryView();
            if (replyStoryView != null) {
                replyStoryView.setReaction(bVar);
            }
        }
        if (c12853fH5.b()) {
            qq6Ic.K(AbstractC11710dT6.c.a);
        } else {
            qq6Ic.K(new AbstractC11710dT6.b(c12853fH5.a()));
        }
        mw6.isLiked = !c12853fH5.b();
        mw6.nc().i1(c12853fH5.a(), !c12853fH5.b(), qq6Ic);
        mw6.bd(true);
        return C19938rB7.a;
    }

    private final void Bc() {
        CircleProgressBar circleProgressBar = dc().m;
        circleProgressBar.setColor(circleProgressBar.getContext().getResources().getColor(GA5.design_default_color_on_primary));
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        circleProgressBar.setBgColor(c5495Jo7.y0(circleProgressBar.getContext().getResources().getColor(GA5.design_default_color_on_primary), 40));
        FrameLayout frameLayout = dc().n;
        frameLayout.getBackground().setColorFilter(new PorterDuffColorFilter(c5495Jo7.y0(frameLayout.getContext().getResources().getColor(GA5.design_default_color_on_primary), 40), PorterDuff.Mode.MULTIPLY));
    }

    private final void Bd() {
        oc().g6();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Cb(MW6 mw6) {
        AbstractC13042fc3.i(mw6, "this$0");
        mw6.nc().m1(true);
        mw6.bd(false);
        return C19938rB7.a;
    }

    private final void Cc() {
        CoordinatorLayout coordinatorLayoutB = dc().getRoot();
        AbstractC13042fc3.h(coordinatorLayoutB, "getRoot(...)");
        C17468n10 c17468n10 = new C17468n10(coordinatorLayoutB, null, 0, 6, null);
        c17468n10.k(dc().d);
        c17468n10.m(-1);
        this.snackBar = c17468n10;
    }

    private final void Cd(QQ6 myStory) {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        String strJ = C14593iA1.j(contextS7, myStory.f() * AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, false, 4, null);
        if (!AbstractC13042fc3.d(strJ, h6(SD5.story_date_now))) {
            strJ = strJ + h6(SD5.story_date_ago);
        }
        if (JF5.g()) {
            strJ = XY6.e(strJ);
        }
        dc().t.setTime(strJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Db(MW6 mw6) {
        AbstractC13042fc3.i(mw6, "this$0");
        mw6.bd(true);
        mw6.nc().m1(false);
        if (mw6.nc().o1()) {
            mw6.nc().f1();
            mw6.rd();
        }
        return C19938rB7.a;
    }

    private final boolean Dc(int userId) {
        return oc().I3().contains(String.valueOf(userId));
    }

    private final void Dd() {
        C3702Bz2 c3702Bz2Dc = dc();
        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
        cVar.p(c3702Bz2Dc.c);
        if (AbstractC19455qN7.d() > 0.54d) {
            cVar.t(c3702Bz2Dc.u.getId(), 4, 0, 4, 0);
        } else {
            cVar.t(c3702Bz2Dc.u.getId(), 4, c3702Bz2Dc.d.getId(), 3, 0);
        }
        cVar.i(c3702Bz2Dc.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Eb(MW6 mw6) {
        AbstractC13042fc3.i(mw6, "this$0");
        mw6.bd(false);
        return C19938rB7.a;
    }

    private final boolean Ec() {
        EnumC23779xV6 enumC23779xV6 = this.storyType;
        return enumC23779xV6 == EnumC23779xV6.c || enumC23779xV6 == EnumC23779xV6.d || enumC23779xV6 == EnumC23779xV6.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C10366bX6 Ed(MW6 mw6) {
        AbstractC13042fc3.i(mw6, "this$0");
        FragmentActivity fragmentActivityQ7 = mw6.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        return (C10366bX6) new androidx.lifecycle.G(fragmentActivityQ7).b(C10366bX6.class);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void Fb(ir.nasim.QQ6 r11) {
        /*
            r10 = this;
            ir.nasim.Bz2 r0 = r10.dc()
            ir.nasim.story.ui.viewfragment.views.footer.FooterStoryView r0 = r0.d
            r1 = 0
            r0.setVisibility(r1)
            ir.nasim.Bz2 r0 = r10.dc()
            ir.nasim.story.ui.viewfragment.views.footer.FooterStoryView r0 = r0.d
            ir.nasim.story.ui.viewfragment.views.footer.a$d r9 = new ir.nasim.story.ui.viewfragment.views.footer.a$d
            ai.bale.proto.PeersStruct$ExPeer r2 = r11.g()
            if (r2 == 0) goto L28
            ai.bale.proto.PeersStruct$ExPeer r2 = r11.g()
            if (r2 == 0) goto L23
            ir.nasim.b35 r2 = r2.getType()
            goto L24
        L23:
            r2 = 0
        L24:
            ir.nasim.b35 r3 = ir.nasim.EnumC10088b35.ExPeerType_PRIVATE
            if (r2 != r3) goto L31
        L28:
            int r2 = r10.userId
            boolean r2 = r10.Dc(r2)
            if (r2 != 0) goto L31
            r1 = 1
        L31:
            r3 = r1
            ir.nasim.story.ui.viewfragment.views.a r4 = r10.lc(r11)
            ir.nasim.MW6$d r5 = new ir.nasim.MW6$d
            r5.<init>(r11)
            r7 = 8
            r8 = 0
            r6 = 0
            r2 = r9
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r0.setState(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.MW6.Fb(ir.nasim.QQ6):void");
    }

    private final boolean Fc() {
        return dc().l.getCurrentStep() == dc().l.getCountOfProgressSteps() - 1;
    }

    private final void Gb(final QQ6 storyItem) {
        StoryLinkCustomView storyLinkCustomView = dc().q;
        String strL = storyItem.l();
        QQ6 qq6Ic = ic();
        if (!AbstractC13042fc3.d(strL, qq6Ic != null ? qq6Ic.l() : null) || this.loadedStoryPosition != dc().u.getCurrentItem()) {
            storyLinkCustomView.setVisibility(8);
            return;
        }
        final StoryWidget.LinkWidget linkWidgetJc = jc();
        if (linkWidgetJc == null) {
            storyLinkCustomView.setVisibility(8);
        } else {
            storyLinkCustomView.p(new C20690sR6().a(linkWidgetJc));
            storyLinkCustomView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.IW6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MW6.Hb(this.a, storyItem, linkWidgetJc, view);
                }
            });
        }
    }

    private final boolean Gc() {
        QQ6 qq6Ic;
        if (this.storyList.isEmpty() || (qq6Ic = ic()) == null) {
            return false;
        }
        if (AbstractC24369yV6.c(qq6Ic).c() == EnumC23779xV6.d || AbstractC24369yV6.c(qq6Ic).c() == EnumC23779xV6.c) {
            if (C8386Vt0.a.H8()) {
                C10366bX6 c10366bX6Oc = oc();
                PeersStruct$ExPeer peersStruct$ExPeerG = qq6Ic.g();
                AbstractC13042fc3.f(peersStruct$ExPeerG);
                C14733iO2 c14733iO2K3 = c10366bX6Oc.K3(peersStruct$ExPeerG.getId());
                QQ6 qq6Ic2 = ic();
                if ((qq6Ic2 == null || qq6Ic2.p() != oc().W3()) && (c14733iO2K3 == null || c14733iO2K3.x() != oc().W3())) {
                    return false;
                }
            } else if (qq6Ic.p() != oc().W3()) {
                return false;
            }
        } else if (AbstractC24369yV6.c(qq6Ic).c() == EnumC23779xV6.f) {
            if (qq6Ic.p() != oc().W3()) {
                return false;
            }
        } else if (this.userId != oc().W3()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hb(MW6 mw6, QQ6 qq6, StoryWidget.LinkWidget linkWidget, View view) {
        AbstractC13042fc3.i(mw6, "this$0");
        AbstractC13042fc3.i(qq6, "$storyItem");
        AbstractC13042fc3.i(linkWidget, "$storyLink");
        mw6.Oc(qq6, linkWidget);
    }

    private final boolean Hc() {
        return this.storyType == EnumC23779xV6.e;
    }

    private final void Ib(int storyIndex) {
        Dd();
        gb(storyIndex);
        ib();
        Jb();
        QQ6 qq6 = (QQ6) this.storyList.get(storyIndex);
        if (Gc()) {
            ob(qq6);
        } else if (Hc()) {
            pb(qq6);
        } else if (Ec()) {
            fd(new C5439Ji5(0, 0), qq6);
        } else {
            Fb(qq6);
        }
        zd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ic(boolean isOn) {
        try {
            if (isOn) {
                Q7().getWindow().addFlags(128);
            } else {
                Q7().getWindow().clearFlags(128);
            }
        } catch (Exception e2) {
            C19406qI3.b("StoryViewFragment", "keepScreen(" + isOn + ") error: " + e2);
        }
    }

    private final void Jb() {
        ViewPager2 viewPager2 = dc().u;
        C19207px4 c19207px4 = new C19207px4(this, this, this.storyList);
        this.storyAdapter = c19207px4;
        viewPager2.setAdapter(c19207px4);
        viewPager2.setOffscreenPageLimit(3);
    }

    private final InterfaceC13730gj3 Jc() {
        return AbstractC16751lo1.c(this, j.b.CREATED, new q(null));
    }

    private final void Kb() {
        InterfaceC13730gj3 interfaceC13730gj3;
        InterfaceC13730gj3 interfaceC13730gj32 = this.uploadProgressJob;
        if (interfaceC13730gj32 == null || !interfaceC13730gj32.b() || (interfaceC13730gj3 = this.uploadProgressJob) == null) {
            return;
        }
        InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Kc(List storyList, int storyIndex) {
        if (!(!storyList.isEmpty())) {
            AbstractC7426Rr.a.U(S7(), h6(SD5.story_load_list_error));
            C22042ua0.m9(this, this, false, 2, null);
            return;
        }
        xc();
        Ib(storyIndex);
        cd(true);
        dc().u.setVisibility(0);
        dc().l.setVisibility(0);
    }

    private final void Lb(int color) {
        Q7().getWindow().setNavigationBarColor(color);
    }

    private final void Lc() {
        this.isDiscreteMode = false;
        yc();
        FragmentActivity fragmentActivityA5 = A5();
        if (fragmentActivityA5 != null) {
            fragmentActivityA5.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Mb(MW6 mw6, StoryWidget.PostWidget postWidget) {
        AbstractC13042fc3.i(mw6, "this$0");
        AbstractC13042fc3.i(postWidget, "$widget");
        QQ6 qq6Ic = mw6.ic();
        if (qq6Ic != null) {
            mw6.Oc(qq6Ic, postWidget);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Mc(ir.nasim.story.ui.viewfragment.views.a state, QQ6 storyItem) {
        if (state instanceof a.C1549a) {
            Sc(storyItem);
            this.isLiked = true;
            nc().i1(AbstractC19455qN7.b(), true, storyItem);
            storyItem.K(new AbstractC11710dT6.b(AbstractC19455qN7.b()));
            return;
        }
        if (state instanceof a.b) {
            this.isLiked = true;
            a.b bVar = (a.b) state;
            nc().i1(bVar.b(), true, storyItem);
            storyItem.K(new AbstractC11710dT6.b(bVar.b()));
            return;
        }
        if (!(state instanceof a.c)) {
            throw new NoWhenBranchMatchedException();
        }
        this.isLiked = false;
        nc().i1(AbstractC19455qN7.b(), false, storyItem);
        storyItem.K(AbstractC11710dT6.c.a);
    }

    private final void Nb() {
        dc().u.setVisibility(4);
        dc().l.setVisibility(8);
        dc().d.setVisibility(4);
        this.storyAdapter = null;
        dc().u.setAdapter(null);
        dc().l.setListener(null);
        dc().l.setFinishListener(null);
        v4();
        Bd();
        dc().l.e();
        this.loadedStoryPosition = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nc(MW6 mw6, View view) {
        AbstractC13042fc3.i(mw6, "this$0");
        mw6.Lc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ob() {
        CoordinatorLayout coordinatorLayoutB = dc().getRoot();
        AbstractC13042fc3.f(coordinatorLayoutB);
        AbstractC16172kp3.a(coordinatorLayoutB);
    }

    private final void Oc(QQ6 storyItem, StoryWidget storyWidget) {
        if (storyWidget instanceof StoryWidget.LinkWidget) {
            sc(storyItem, (StoryWidget.LinkWidget) storyWidget);
        } else if (storyWidget instanceof StoryWidget.PostWidget) {
            tc((StoryWidget.PostWidget) storyWidget);
        } else {
            oc().Q5(true);
        }
        Qc(false);
    }

    private final InterfaceC13730gj3 Pb() {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new f(null), 3, null);
    }

    private final void Pc(C11458d25 peer, ExPeerType exPeerType) {
        PP0.a.b(Long.valueOf(System.currentTimeMillis()));
        C22042ua0.A9(this, InterfaceC11677dQ0.b(ec(), peer, exPeerType, null, null, false, null, null, null, null, 0L, null, null, null, false, null, null, null, null, null, false, null, null, null, null, null, false, null, 134217724, null), false, null, 6, null);
    }

    private final void Qb() {
        dc().m.c();
        this.downloadJob = AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new g(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qc(boolean hideViews) {
        v4();
        Bd();
        if (hideViews) {
            Ac();
        }
    }

    private final InterfaceC13730gj3 Rb() {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new h(null), 3, null);
    }

    static /* synthetic */ void Rc(MW6 mw6, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        mw6.Qc(z);
    }

    private final InterfaceC13730gj3 Sb() {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new i(null), 3, null);
    }

    private final void Sc(QQ6 currentStory) {
        LottieAnimationView lottieAnimationView = dc().k;
        C14189hV6 c14189hV6W = currentStory.w();
        Integer numValueOf = c14189hV6W != null ? Integer.valueOf(c14189hV6W.a()) : null;
        if (numValueOf == null || AbstractC22003uV6.a(numValueOf.intValue()) == null) {
            lottieAnimationView.setAnimation(AbstractC18772pD5.story_like);
        } else {
            Integer numA = AbstractC22003uV6.a(numValueOf.intValue());
            AbstractC13042fc3.f(numA);
            lottieAnimationView.setAnimation(numA.intValue());
        }
        lottieAnimationView.bringToFront();
        lottieAnimationView.x();
    }

    private final InterfaceC13730gj3 Tb() {
        return AbstractC19455qN7.g(this, null, new j(null), 1, null);
    }

    private final void Tc(final InterfaceC14603iB2 onResult) {
        AbstractC18623oy2.d(this, "REPORT_STORY_REQUEST_KEY", new InterfaceC14603iB2() { // from class: ir.nasim.CW6
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return MW6.Uc(this.a, onResult, (String) obj, (Bundle) obj2);
            }
        });
    }

    private final InterfaceC13730gj3 Ub() {
        return AbstractC16751lo1.c(this, j.b.STARTED, new k(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Uc(MW6 mw6, InterfaceC14603iB2 interfaceC14603iB2, String str, Bundle bundle) {
        OP5 op5;
        AbstractC13042fc3.i(mw6, "this$0");
        AbstractC13042fc3.i(interfaceC14603iB2, "$onResult");
        AbstractC13042fc3.i(str, "<unused var>");
        AbstractC13042fc3.i(bundle, "bundle");
        AbstractC18623oy2.b(mw6, "REPORT_STORY_REQUEST_KEY");
        int i2 = bundle.getInt("REPORT_TITLE_RESULT_KEY", 0);
        if (Build.VERSION.SDK_INT >= 33) {
            op5 = (OP5) bundle.getSerializable("REPORT_TYPE_RESULT_KEY", OP5.class);
        } else {
            Serializable serializable = bundle.getSerializable("REPORT_TYPE_RESULT_KEY");
            op5 = serializable instanceof OP5 ? (OP5) serializable : null;
        }
        if (op5 == null) {
            return C19938rB7.a;
        }
        interfaceC14603iB2.invoke(Integer.valueOf(i2), op5);
        return C19938rB7.a;
    }

    private final InterfaceC13730gj3 Vb(long rid) {
        InterfaceC13730gj3 interfaceC13730gj3D = AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new l(rid, null), 3, null);
        Kb();
        this.uploadProgressJob = interfaceC13730gj3D;
        return interfaceC13730gj3D;
    }

    private final void Vc() {
        Qc(false);
        final QQ6 qq6Ic = ic();
        if (qq6Ic == null) {
            return;
        }
        vd(new InterfaceC14603iB2() { // from class: ir.nasim.zW6
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return MW6.Wc(this.a, qq6Ic, ((Integer) obj).intValue(), (OP5) obj2);
            }
        });
    }

    private final InterfaceC13730gj3 Wb() {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new m(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Wc(final MW6 mw6, final QQ6 qq6, int i2, final OP5 op5) {
        AbstractC13042fc3.i(mw6, "this$0");
        AbstractC13042fc3.i(qq6, "$currentStory");
        AbstractC13042fc3.i(op5, "reportType");
        Context contextS7 = mw6.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = mw6.p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        C24398yZ.j(contextS7, interfaceC18633oz3P6, i2, false, new SA2() { // from class: ir.nasim.DW6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return MW6.Xc(this.a);
            }
        }, new UA2() { // from class: ir.nasim.EW6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return MW6.Yc(this.a, qq6, op5, (String) obj);
            }
        });
        return C19938rB7.a;
    }

    private final void Xb() {
        dc().l.setSingleDisplayTime(AbstractC5969Lp4.e().S().O1());
        float f2 = 100;
        dc().f.setGuidelinePercent(AbstractC5969Lp4.e().S().m3() / f2);
        dc().g.setGuidelinePercent((f2 - AbstractC5969Lp4.e().S().m3()) / f2);
        View view = dc().j;
        AbstractC13042fc3.h(view, "layoutStart");
        View view2 = dc().h;
        AbstractC13042fc3.h(view2, "layoutCenter");
        View view3 = dc().i;
        AbstractC13042fc3.h(view3, "layoutEnd");
        this.storyGestureDetector = new EQ6(view, view2, view3, this);
        fb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Xc(MW6 mw6) {
        AbstractC13042fc3.i(mw6, "this$0");
        mw6.l1();
        mw6.ad();
        return C19938rB7.a;
    }

    private final InterfaceC13730gj3 Yb(int userId, String selectedStoryId) {
        return AbstractC16751lo1.c(this, j.b.CREATED, new n(userId, selectedStoryId, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Yc(MW6 mw6, QQ6 qq6, OP5 op5, String str) {
        AbstractC13042fc3.i(mw6, "this$0");
        AbstractC13042fc3.i(qq6, "$currentStory");
        AbstractC13042fc3.i(op5, "$reportType");
        AbstractC13042fc3.i(str, "reportDescription");
        mw6.oc().t5(qq6.l(), op5, str);
        mw6.l1();
        mw6.ad();
        return C19938rB7.a;
    }

    private final InterfaceC13730gj3 Zb(int userId, boolean fromEnd) {
        return AbstractC16751lo1.c(this, j.b.CREATED, new o(userId, fromEnd, null));
    }

    private final void Zc() {
        this.lastViewedStory = ic();
        this.storyStartTime = System.currentTimeMillis();
    }

    static /* synthetic */ InterfaceC13730gj3 ac(MW6 mw6, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        return mw6.Zb(i2, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ad() {
        oc().z5();
        Ic(true);
    }

    private final InterfaceC13730gj3 bc(int userId, String storyId) {
        return AbstractC16751lo1.c(this, j.b.CREATED, new p(userId, storyId, null));
    }

    private final void bd(boolean z) {
        if (z == this.canGoNextStory) {
            return;
        }
        this.canGoNextStory = z;
        if (z && dc().l.k()) {
            AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new e(null), 3, null);
        }
    }

    private final void cb() {
        TopBarStoryView topBarStoryView = dc().t;
        topBarStoryView.n0(C8386Vt0.a.pb());
        topBarStoryView.h0(new View.OnClickListener() { // from class: ir.nasim.JW6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MW6.db(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int cc(List stories) {
        Iterator it = stories.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (AbstractC13042fc3.d(((QQ6) it.next()).s(), AbstractC11710dT6.a.a)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    private final void cd(boolean visible) {
        CircleProgressBar circleProgressBar = dc().m;
        AbstractC13042fc3.h(circleProgressBar, "progressView");
        circleProgressBar.setVisibility(visible ? 0 : 8);
        FrameLayout frameLayout = dc().n;
        AbstractC13042fc3.h(frameLayout, "progressViewLayout");
        frameLayout.setVisibility(visible ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void db(final MW6 mw6, View view) {
        AbstractC13042fc3.i(mw6, "this$0");
        mw6.Qc(false);
        AbstractC13042fc3.f(view);
        CoordinatorLayout coordinatorLayoutB = mw6.dc().getRoot();
        AbstractC13042fc3.h(coordinatorLayoutB, "getRoot(...)");
        GY gyB = new GY.a(view, coordinatorLayoutB, null, 4, null).d(true).f(false).e(new Runnable() { // from class: ir.nasim.oW6
            @Override // java.lang.Runnable
            public final void run() {
                MW6.eb(this.a);
            }
        }).b(mw6.fc());
        mw6.contextMenu = gyB;
        if (gyB != null) {
            AbstractC5462Jl1.f(gyB, 0, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C3702Bz2 dc() {
        C3702Bz2 c3702Bz2 = this._binding;
        AbstractC13042fc3.f(c3702Bz2);
        return c3702Bz2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dd(int position) {
        C14189hV6 c14189hV6W;
        EnumC20117rV6 enumC20117rV6A;
        EnumC20117rV6 enumC20117rV6A2;
        if (position < 0 || position >= this.storyList.size()) {
            C19406qI3.a("StoryViewFragment", "setCurrentItem with wrong position!", new Object[0]);
            return;
        }
        Kb();
        cd(this.loadedStoryPosition != position);
        dc().u.setCurrentItem(position);
        QQ6 qq6 = (QQ6) this.storyList.get(position);
        QQ6 qq6Ic = ic();
        if (qq6Ic == null || !qq6Ic.G()) {
            Qb();
        } else {
            jd();
        }
        if (qq6.G()) {
            dc().t.setMuteUnMuteVisibility(0);
            MultiProgressBar multiProgressBar = dc().l;
            C20091rS7 c20091rS7C = qq6.C();
            AbstractC13042fc3.f(c20091rS7C);
            multiProgressBar.setSingleDisplayTime(c20091rS7C.a() + 0.5f);
        } else {
            dc().t.setMuteUnMuteVisibility(4);
            dc().l.setSingleDisplayTime(AbstractC5969Lp4.d().o2().S().O1());
        }
        int i2 = b.a[qq6.u().ordinal()];
        if (i2 == 1) {
            zc();
            if (Gc()) {
                dc().t.j0(false);
                dc().d.setState(a.b.b);
                oc().w4(qq6.l(), 1, 20);
            } else if (Hc()) {
                dc().t.j0(false);
                if (qq6.p() == 178536948 && (c14189hV6W = qq6.w()) != null && (enumC20117rV6A = EnumC20117rV6.h.a(c14189hV6W.a())) != null) {
                    dc().t.j0(true);
                    dc().t.setBadgeDrawable(enumC20117rV6A.j());
                }
                if (qq6.p() == 645784619) {
                    dc().t.j0(true);
                    dc().t.setBadgeDrawable(AbstractC23008wB5.badge_popular_with_circle);
                }
                dc().d.setState(new a.c(null, null, null, null, 15, null));
                pb(qq6);
            } else {
                dc().t.j0(false);
                Fb(qq6);
            }
            C14189hV6 c14189hV6W2 = qq6.w();
            if (c14189hV6W2 != null && (enumC20117rV6A2 = EnumC20117rV6.h.a(c14189hV6W2.a())) != null) {
                dc().t.j0(true);
                dc().t.setBadgeDrawable(enumC20117rV6A2.j());
            }
            if (qq6.k() && qq6.D() == null) {
                oc().y4(qq6);
            }
        } else if (i2 == 2) {
            dc().d.setState(a.e.b);
            Vb(qq6.i());
            dc().t.n0(true);
            cd(false);
            zc();
        } else if (i2 == 3) {
            dc().d.setState(a.b.b);
            dc().t.n0(true);
            hd();
        }
        Cd(qq6);
        ReplyStoryView replyStoryView = dc().d.getReplyStoryView();
        if (replyStoryView != null) {
            replyStoryView.f();
            replyStoryView.clearFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void eb(MW6 mw6) {
        AbstractC13042fc3.i(mw6, "this$0");
        mw6.l1();
        mw6.ad();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ed(int progress) {
        if (1 <= progress && progress < 100) {
            CircleProgressBar circleProgressBar = dc().m;
            AbstractC13042fc3.f(circleProgressBar);
            circleProgressBar.setVisibility(0);
            circleProgressBar.setValue(progress);
            return;
        }
        if (progress == 100) {
            CircleProgressBar circleProgressBar2 = dc().m;
            AbstractC13042fc3.f(circleProgressBar2);
            circleProgressBar2.setVisibility(8);
            circleProgressBar2.setProgressWithoutAnimation(0);
            return;
        }
        if (progress == 0) {
            CircleProgressBar circleProgressBar3 = dc().m;
            AbstractC13042fc3.f(circleProgressBar3);
            circleProgressBar3.setVisibility(0);
            circleProgressBar3.setProgressWithoutAnimation(0);
        }
    }

    private final void fb() {
        dc().j.setOnTouchListener(this);
        dc().i.setOnTouchListener(this);
        dc().h.setOnTouchListener(this);
    }

    private final AbstractC8081Ul1.b fc() {
        AbstractC8081Ul1.b bVar = new AbstractC8081Ul1.b();
        return Gc() ? AbstractC8081Ul1.b.d(bVar, SD5.remove_story, AbstractC23008wB5.delete_card_icon, null, new SA2() { // from class: ir.nasim.xW6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return MW6.gc(this.a);
            }
        }, 4, null) : AbstractC8081Ul1.b.k(bVar, SD5.report_story, AbstractC23008wB5.alert, null, new SA2() { // from class: ir.nasim.yW6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return MW6.hc(this.a);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fd(C5439Ji5 popularStoryViews, QQ6 currentStory) {
        dc().d.setState(new a.c(lc(currentStory), Integer.valueOf(popularStoryViews.b()), Integer.valueOf(popularStoryViews.a()), new s(currentStory)));
    }

    private final InterfaceC13730gj3 gb(int storyIndex) {
        MultiProgressBar multiProgressBar = dc().l;
        multiProgressBar.setProgressStepsCount(this.storyList.size());
        multiProgressBar.setListener(this);
        multiProgressBar.setFinishListener(this);
        v4();
        multiProgressBar.o(Integer.valueOf(storyIndex));
        return Ad();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 gc(MW6 mw6) {
        AbstractC13042fc3.i(mw6, "this$0");
        AbstractC5462Jl1 abstractC5462Jl1 = mw6.contextMenu;
        if (abstractC5462Jl1 != null) {
            abstractC5462Jl1.dismiss();
        }
        QQ6 qq6Ic = mw6.ic();
        if (qq6Ic != null) {
            mw6.sd(qq6Ic);
        }
        return C19938rB7.a;
    }

    private final void gd(QQ6 currentStoryItem) {
        nc().q1(currentStoryItem.b((1048575 & 1) != 0 ? currentStoryItem.a : 0L, (1048575 & 2) != 0 ? currentStoryItem.b : null, (1048575 & 4) != 0 ? currentStoryItem.c : null, (1048575 & 8) != 0 ? currentStoryItem.d : null, (1048575 & 16) != 0 ? currentStoryItem.e : 0L, (1048575 & 32) != 0 ? currentStoryItem.f : 0, (1048575 & 64) != 0 ? currentStoryItem.g : null, (1048575 & 128) != 0 ? currentStoryItem.h : null, (1048575 & 256) != 0 ? currentStoryItem.i : null, (1048575 & 512) != 0 ? currentStoryItem.j : null, (1048575 & 1024) != 0 ? currentStoryItem.k : null, (1048575 & 2048) != 0 ? currentStoryItem.l : false, (1048575 & 4096) != 0 ? currentStoryItem.m : null, (1048575 & 8192) != 0 ? currentStoryItem.n : null, (1048575 & 16384) != 0 ? currentStoryItem.o : false, (1048575 & 32768) != 0 ? currentStoryItem.p : null, (1048575 & 65536) != 0 ? currentStoryItem.q : false, (1048575 & 131072) != 0 ? currentStoryItem.r : null, (1048575 & 262144) != 0 ? currentStoryItem.s : null, (1048575 & 524288) != 0 ? currentStoryItem.t : null));
        if (Fc()) {
            oc().Z5(AbstractC24369yV6.c(currentStoryItem.b((1048575 & 1) != 0 ? currentStoryItem.a : 0L, (1048575 & 2) != 0 ? currentStoryItem.b : null, (1048575 & 4) != 0 ? currentStoryItem.c : null, (1048575 & 8) != 0 ? currentStoryItem.d : null, (1048575 & 16) != 0 ? currentStoryItem.e : 0L, (1048575 & 32) != 0 ? currentStoryItem.f : 0, (1048575 & 64) != 0 ? currentStoryItem.g : null, (1048575 & 128) != 0 ? currentStoryItem.h : null, (1048575 & 256) != 0 ? currentStoryItem.i : null, (1048575 & 512) != 0 ? currentStoryItem.j : null, (1048575 & 1024) != 0 ? currentStoryItem.k : null, (1048575 & 2048) != 0 ? currentStoryItem.l : false, (1048575 & 4096) != 0 ? currentStoryItem.m : null, (1048575 & 8192) != 0 ? currentStoryItem.n : null, (1048575 & 16384) != 0 ? currentStoryItem.o : false, (1048575 & 32768) != 0 ? currentStoryItem.p : null, (1048575 & 65536) != 0 ? currentStoryItem.q : false, (1048575 & 131072) != 0 ? currentStoryItem.r : null, (1048575 & 262144) != 0 ? currentStoryItem.s : null, (1048575 & 524288) != 0 ? currentStoryItem.t : null)));
        }
        if (currentStoryItem.u() == YK6.c && AbstractC13042fc3.d(currentStoryItem.s(), AbstractC11710dT6.a.a)) {
            currentStoryItem.K(AbstractC11710dT6.c.a);
        }
    }

    private final void hb() {
        bd(true);
        int iIndexOf = this.userIdList.indexOf(Integer.valueOf(this.userId));
        if (iIndexOf >= this.userIdList.size() - 1 || this.userId == oc().W3()) {
            Lc();
        } else {
            pc(iIndexOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 hc(MW6 mw6) {
        AbstractC13042fc3.i(mw6, "this$0");
        AbstractC5462Jl1 abstractC5462Jl1 = mw6.contextMenu;
        if (abstractC5462Jl1 != null) {
            abstractC5462Jl1.dismiss();
        }
        mw6.Vc();
        return C19938rB7.a;
    }

    private final void hd() {
        final QQ6 qq6Ic = ic();
        if (qq6Ic != null && qq6Ic.u() == YK6.b) {
            String strH6 = h6(SD5.story_uploading_error);
            AbstractC13042fc3.h(strH6, "getString(...)");
            wd(strH6, false, h6(SD5.try_again), new SA2() { // from class: ir.nasim.lW6
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return MW6.id(this.a, qq6Ic);
                }
            }, -2);
        }
    }

    private final void ib() {
        final TopBarStoryView topBarStoryView = dc().t;
        topBarStoryView.setVisibility(0);
        topBarStoryView.getAvatarView().B(22.0f, true);
        TopBarStoryView.m0(topBarStoryView, false, null, 2, null);
        EnumC23779xV6 enumC23779xV6C = AbstractC24369yV6.c((QQ6) AbstractC15401jX0.C0(this.storyList)).c();
        if (enumC23779xV6C == EnumC23779xV6.b || enumC23779xV6C == EnumC23779xV6.f) {
            C3512Be1 c3512Be1K0 = AbstractC5969Lp4.d().o2().A().k0(this.userId);
            if (c3512Be1K0 != null) {
                topBarStoryView.getAvatarView().o(c3512Be1K0);
                String name = c3512Be1K0.getName();
                AbstractC13042fc3.h(name, "getName(...)");
                topBarStoryView.setTitle(name);
                AbstractC5969Lp4.d().k0().k(this.userId).m0(new InterfaceC24449ye1() { // from class: ir.nasim.dW6
                    @Override // ir.nasim.InterfaceC24449ye1
                    public final void apply(Object obj) {
                        MW6.jb(topBarStoryView, (C21231tK7) obj);
                    }
                });
            } else {
                AbstractC5969Lp4.d().V0(AbstractC10360bX0.g(Integer.valueOf(this.userId))).m0(new InterfaceC24449ye1() { // from class: ir.nasim.eW6
                    @Override // ir.nasim.InterfaceC24449ye1
                    public final void apply(Object obj) {
                        MW6.kb(this.a, topBarStoryView, (C14505i18) obj);
                    }
                });
            }
            topBarStoryView.i0(new View.OnClickListener() { // from class: ir.nasim.fW6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MW6.mb(this.a, view);
                }
            });
            return;
        }
        C14733iO2 c14733iO2K3 = oc().K3(this.userId);
        if (c14733iO2K3 != null) {
            topBarStoryView.getAvatarView().q(c14733iO2K3);
            Object objB = c14733iO2K3.v().b();
            AbstractC13042fc3.h(objB, "get(...)");
            topBarStoryView.setTitle((String) objB);
            E25 e25 = (E25) c14733iO2K3.y().b();
            if (e25 != null) {
                int i2 = b.b[e25.ordinal()];
                topBarStoryView.o0(i2 == 1 || i2 == 2);
            }
        }
        topBarStoryView.i0(new View.OnClickListener() { // from class: ir.nasim.gW6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MW6.nb(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQ6 ic() {
        try {
            return (QQ6) this.storyList.get(dc().u.getCurrentItem());
        } catch (Exception unused) {
            Lc();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 id(MW6 mw6, QQ6 qq6) {
        AbstractC13042fc3.i(mw6, "this$0");
        AbstractC13042fc3.i(qq6, "$currentStoryItem");
        mw6.oc().h6(qq6);
        mw6.dc().d.setState(a.e.b);
        C17468n10 c17468n10 = mw6.snackBar;
        if (c17468n10 != null) {
            c17468n10.f();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void jb(TopBarStoryView topBarStoryView, C21231tK7 c21231tK7) {
        E25 e25;
        AbstractC13042fc3.i(topBarStoryView, "$this_with");
        C19482qQ7 c19482qQ7T = c21231tK7.t();
        if (c19482qQ7T == null || (e25 = (E25) c19482qQ7T.b()) == null) {
            return;
        }
        int i2 = b.b[e25.ordinal()];
        boolean z = true;
        if (i2 != 1 && i2 != 2) {
            z = false;
        }
        topBarStoryView.o0(z);
    }

    private final StoryWidget.LinkWidget jc() {
        StoryWidget storyWidget;
        List listD;
        Object next;
        QQ6 qq6Ic = ic();
        if (qq6Ic == null || (listD = qq6Ic.D()) == null) {
            storyWidget = null;
        } else {
            Iterator it = listD.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((StoryWidget) next) instanceof StoryWidget.LinkWidget) {
                    break;
                }
            }
            storyWidget = (StoryWidget) next;
        }
        StoryWidget.LinkWidget linkWidget = storyWidget instanceof StoryWidget.LinkWidget ? (StoryWidget.LinkWidget) storyWidget : null;
        if (C8386Vt0.Bb()) {
            StoryWidget.PostWidget postWidgetKc = kc();
            if (AbstractC13042fc3.d(postWidgetKc != null ? postWidgetKc.getLink() : null, linkWidget != null ? linkWidget.a() : null)) {
                return null;
            }
        }
        return linkWidget;
    }

    private final void jd() {
        CircleProgressBar circleProgressBar = dc().m;
        circleProgressBar.setValue(1);
        circleProgressBar.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void kb(MW6 mw6, final TopBarStoryView topBarStoryView, C14505i18 c14505i18) {
        AbstractC13042fc3.i(mw6, "this$0");
        AbstractC13042fc3.i(topBarStoryView, "$this_with");
        AbstractC5969Lp4.d().k0().k(mw6.userId).m0(new InterfaceC24449ye1() { // from class: ir.nasim.qW6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                MW6.lb(topBarStoryView, (C21231tK7) obj);
            }
        });
    }

    private final StoryWidget.PostWidget kc() {
        StoryWidget storyWidget;
        List listD;
        Object next;
        QQ6 qq6Ic = ic();
        if (qq6Ic == null || (listD = qq6Ic.D()) == null) {
            storyWidget = null;
        } else {
            Iterator it = listD.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((StoryWidget) next) instanceof StoryWidget.PostWidget) {
                    break;
                }
            }
            storyWidget = (StoryWidget) next;
        }
        if (storyWidget instanceof StoryWidget.PostWidget) {
            return (StoryWidget.PostWidget) storyWidget;
        }
        return null;
    }

    private final void kd(SA2 onClickListener) {
        String strH6 = h6(SD5.tap_to_see_chanel);
        AbstractC13042fc3.h(strH6, "getString(...)");
        nd(onClickListener, new SA2() { // from class: ir.nasim.nW6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return MW6.ld();
            }
        }, strH6, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lb(TopBarStoryView topBarStoryView, C21231tK7 c21231tK7) {
        E25 e25;
        AbstractC13042fc3.i(topBarStoryView, "$this_with");
        AvatarViewGlide avatarView = topBarStoryView.getAvatarView();
        AbstractC13042fc3.f(c21231tK7);
        AvatarViewGlide.u(avatarView, c21231tK7, null, 2, null);
        Object objB = c21231tK7.r().b();
        AbstractC13042fc3.h(objB, "get(...)");
        topBarStoryView.setTitle((String) objB);
        C19482qQ7 c19482qQ7T = c21231tK7.t();
        if (c19482qQ7T == null || (e25 = (E25) c19482qQ7T.b()) == null) {
            return;
        }
        int i2 = b.b[e25.ordinal()];
        boolean z = true;
        if (i2 != 1 && i2 != 2) {
            z = false;
        }
        topBarStoryView.o0(z);
    }

    private final ir.nasim.story.ui.viewfragment.views.a lc(QQ6 currentItem) {
        AbstractC11710dT6 abstractC11710dT6S = currentItem.s();
        if (abstractC11710dT6S instanceof AbstractC11710dT6.b) {
            AbstractC11710dT6.b bVar = (AbstractC11710dT6.b) abstractC11710dT6S;
            nc().l1(bVar.a());
            this.isLiked = true;
            return AbstractC19455qN7.e(bVar.a()) ? new a.C1549a(false) : new a.b(bVar.a(), false, 2, null);
        }
        if (!AbstractC13042fc3.d(abstractC11710dT6S, AbstractC11710dT6.a.a) && !AbstractC13042fc3.d(abstractC11710dT6S, AbstractC11710dT6.c.a)) {
            throw new NoWhenBranchMatchedException();
        }
        this.isLiked = false;
        nc().Y0();
        return new a.c(false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ld() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mb(MW6 mw6, View view) {
        AbstractC13042fc3.i(mw6, "this$0");
        if (!mw6.Dc(mw6.userId)) {
            mw6.Pc(new C11458d25(W25.a, mw6.userId), ExPeerType.PRIVATE);
            mw6.Qc(false);
        }
        QQ6 qq6Ic = mw6.ic();
        if (qq6Ic != null) {
            mw6.nc().k1(qq6Ic);
        }
    }

    private final void md(SA2 onClickListener) {
        Qc(false);
        String strH6 = h6(SD5.view_post);
        AbstractC13042fc3.h(strH6, "getString(...)");
        nd(onClickListener, new SA2() { // from class: ir.nasim.rW6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return MW6.od(this.a);
            }
        }, strH6, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void nb(MW6 mw6, View view) {
        PeersStruct$ExPeer peersStruct$ExPeerG;
        AbstractC13042fc3.i(mw6, "this$0");
        if (!mw6.Dc(mw6.userId)) {
            C11458d25 c11458d25 = new C11458d25(W25.b, mw6.userId);
            QQ6 qq6Ic = mw6.ic();
            mw6.Pc(c11458d25, ((qq6Ic == null || (peersStruct$ExPeerG = qq6Ic.g()) == null) ? null : peersStruct$ExPeerG.getType()) == EnumC10088b35.ExPeerType_GROUP ? ExPeerType.GROUP : ExPeerType.CHANNEL);
            mw6.Qc(false);
        }
        QQ6 qq6Ic2 = mw6.ic();
        if (qq6Ic2 != null) {
            mw6.nc().k1(qq6Ic2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C17180mX6 nc() {
        return (C17180mX6) this.storyViewViewModel.getValue();
    }

    private final void nd(final SA2 onClickListener, final SA2 onDismissListener, String title, boolean showIcon) {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        D20.a aVarG1 = new D20.a(contextS7).g1(AbstractC4043Dl1.c(S7(), GA5.n400_light)).X1(title).W0(AbstractC23008wB5.ic_tooltip_arrow).Z1(AbstractC4043Dl1.c(S7(), GA5.surface_light)).v1(AbstractC4043Dl1.c(S7(), GA5.surface_light)).b2(8388613).Q1(12).S1(12).O1(8).U1(8).e2(14.0f).z1(24).e1(4).d1(8).l1(14.0f).X0(EnumC11622dK.c).G1(p6());
        if (showIcon) {
            aVarG1.w1(JF5.g() ? AbstractC23008wB5.simple_arrow_left : AbstractC23008wB5.simple_arrow_right).x1(EnumC22897w03.b);
        }
        final D20 d20A = aVarG1.a();
        d20A.q0(new UA2() { // from class: ir.nasim.uW6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return MW6.pd(onClickListener, d20A, (View) obj);
            }
        });
        d20A.t0(new SA2() { // from class: ir.nasim.vW6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return MW6.qd(onDismissListener);
            }
        });
        View view = dc().s;
        AbstractC13042fc3.h(view, "tooltipAnchorView");
        D20.N0(d20A, view, 0, 0, 6, null);
        QQ6 qq6Ic = ic();
        if (qq6Ic != null) {
            this.postToStoryOnboardingTooltip = new XV4(d20A, qq6Ic.l());
        }
    }

    private final void ob(QQ6 storyItem) {
        C3702Bz2 c3702Bz2Dc = dc();
        c3702Bz2Dc.t.n0(true);
        int i2 = b.a[storyItem.u().ordinal()];
        if (i2 == 1) {
            c3702Bz2Dc.d.setState(a.b.b);
            return;
        }
        if (i2 == 2) {
            c3702Bz2Dc.d.setState(a.e.b);
        } else if (i2 != 3) {
            if (i2 != 4) {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            c3702Bz2Dc.t.n0(true);
            hd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C10366bX6 oc() {
        return (C10366bX6) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 od(MW6 mw6) {
        AbstractC13042fc3.i(mw6, "this$0");
        mw6.I4();
        mw6.bd(true);
        return C19938rB7.a;
    }

    private final void pb(QQ6 currentStory) {
        if (!oc().a5()) {
            fd(new C5439Ji5(0, 0), currentStory);
        } else {
            oc().a4(currentStory.l());
            AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new c(currentStory, null), 3, null);
        }
    }

    private final Object pc(int currentStoryPosition) {
        try {
            Nb();
            Object obj = this.userIdList.get(currentStoryPosition + 1);
            AbstractC13042fc3.h(obj, "get(...)");
            int iIntValue = ((Number) obj).intValue();
            this.userId = iIntValue;
            this.storyType = oc().u4(iIntValue);
            return ac(this, iIntValue, false, 2, null);
        } catch (Exception e2) {
            C19406qI3.a("StoryViewFragment", "goNextUser(from pos=" + currentStoryPosition + ") error: " + e2.getMessage(), new Object[0]);
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 pd(SA2 sa2, D20 d20, View view) {
        AbstractC13042fc3.i(sa2, "$onClickListener");
        AbstractC13042fc3.i(d20, "$this_apply");
        AbstractC13042fc3.i(view, "it");
        sa2.invoke();
        d20.E();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qb(final int position) {
        final TopBarStoryView topBarStoryView = dc().t;
        final PeersStruct$ExPeer peersStruct$ExPeerG = ((QQ6) this.storyList.get(position)).g();
        AbstractC13042fc3.f(peersStruct$ExPeerG);
        final int id = peersStruct$ExPeerG.getId();
        boolean z = true;
        topBarStoryView.getAvatarView().B(22.0f, true);
        EnumC10088b35 type = peersStruct$ExPeerG.getType();
        AbstractC13042fc3.h(type, "getType(...)");
        EnumC23779xV6 enumC23779xV6B = AbstractC24369yV6.b(type);
        if (enumC23779xV6B == EnumC23779xV6.b || enumC23779xV6B == EnumC23779xV6.f) {
            long j2 = id;
            C3512Be1 c3512Be1K0 = AbstractC5969Lp4.d().o2().A().k0(j2);
            if (c3512Be1K0 != null) {
                topBarStoryView.getAvatarView().o(c3512Be1K0);
                String name = c3512Be1K0.getName();
                AbstractC13042fc3.h(name, "getName(...)");
                topBarStoryView.setTitle(name);
                AbstractC5969Lp4.d().k0().k(j2).m0(new InterfaceC24449ye1() { // from class: ir.nasim.KW6
                    @Override // ir.nasim.InterfaceC24449ye1
                    public final void apply(Object obj) {
                        MW6.rb(topBarStoryView, (C21231tK7) obj);
                    }
                });
            } else {
                AbstractC5969Lp4.d().V0(AbstractC10360bX0.g(Integer.valueOf(id))).m0(new InterfaceC24449ye1() { // from class: ir.nasim.LW6
                    @Override // ir.nasim.InterfaceC24449ye1
                    public final void apply(Object obj) {
                        MW6.sb(id, topBarStoryView, (C14505i18) obj);
                    }
                });
            }
        } else {
            final C14733iO2 c14733iO2K3 = oc().K3(id);
            if (c14733iO2K3 != null) {
                Object objB = c14733iO2K3.v().b();
                AbstractC13042fc3.h(objB, "get(...)");
                topBarStoryView.setTitle((String) objB);
                if (((Boolean) c14733iO2K3.F().b()).booleanValue()) {
                    TopBarStoryView.m0(topBarStoryView, false, null, 2, null);
                } else {
                    topBarStoryView.k0(true, S7().getString(SD5.btn_join));
                }
                topBarStoryView.getAvatarView().q(c14733iO2K3);
                E25 e25 = (E25) c14733iO2K3.y().b();
                if (e25 != null) {
                    int i2 = b.b[e25.ordinal()];
                    if (i2 != 1 && i2 != 2) {
                        z = false;
                    }
                    topBarStoryView.o0(z);
                }
                topBarStoryView.g0(new View.OnClickListener() { // from class: ir.nasim.bW6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MW6.ub(c14733iO2K3, id, this, position, peersStruct$ExPeerG, topBarStoryView, view);
                    }
                });
            }
        }
        topBarStoryView.i0(new View.OnClickListener() { // from class: ir.nasim.cW6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MW6.xb(peersStruct$ExPeerG, this, id, position, view);
            }
        });
    }

    private final Object qc(int currentStoryPosition) {
        try {
            Nb();
            Object obj = this.userIdList.get(currentStoryPosition - 1);
            AbstractC13042fc3.h(obj, "get(...)");
            int iIntValue = ((Number) obj).intValue();
            this.userId = iIntValue;
            this.storyType = oc().u4(iIntValue);
            return Zb(iIntValue, true);
        } catch (Exception e2) {
            C19406qI3.a("StoryViewFragment", "goPreviousUser(from pos=" + currentStoryPosition + ") error: " + e2.getMessage(), new Object[0]);
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 qd(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onDismissListener");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rb(TopBarStoryView topBarStoryView, C21231tK7 c21231tK7) {
        E25 e25;
        AbstractC13042fc3.i(topBarStoryView, "$this_with");
        C19482qQ7 c19482qQ7T = c21231tK7.t();
        if (c19482qQ7T == null || (e25 = (E25) c19482qQ7T.b()) == null) {
            return;
        }
        int i2 = b.b[e25.ordinal()];
        boolean z = true;
        if (i2 != 1 && i2 != 2) {
            z = false;
        }
        topBarStoryView.o0(z);
    }

    private final Object rc(int newStep) {
        try {
            return oc().t3((QQ6) this.storyList.get(newStep));
        } catch (Exception e2) {
            C19406qI3.b("StoryViewFragment", "handleDownloadNextStory error: " + e2);
            return C19938rB7.a;
        }
    }

    private final void rd() {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        D20.a aVarE2 = new D20.a(contextS7).d1(10).X0(EnumC11622dK.c).W0(AbstractC23008wB5.ic_tooltip_arrow).U0(AbstractC4043Dl1.c(S7(), GA5.n20)).g1(AbstractC4043Dl1.c(S7(), GA5.n20)).k2(RecyclerView.UNDEFINED_DURATION).u1(RecyclerView.UNDEFINED_DURATION).b2(8388613).Q1(16).S1(16).O1(8).U1(8).e1(4).l1(14.0f).C1(true).e2(14.0f);
        Typeface typefaceH = VW5.h(S7(), MB5.iran_sans_regular);
        AbstractC13042fc3.f(typefaceH);
        D20.a aVarA1 = aVarE2.h2(typefaceH).Z1(AbstractC4043Dl1.c(S7(), GA5.n500)).i1(F20.e).s1(false).f1(5000L).G1(p6()).k1(I20.a, 0L).a1(0.85f);
        String strH6 = h6(SD5.story_reaction_onbiarding_tooltip);
        AbstractC13042fc3.h(strH6, "getString(...)");
        D20 d20A = aVarA1.X1(strH6).a();
        View view = dc().p;
        AbstractC13042fc3.h(view, "reactionTooltipAnchor");
        d20A.M0(view, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sb(int i2, final TopBarStoryView topBarStoryView, C14505i18 c14505i18) {
        AbstractC13042fc3.i(topBarStoryView, "$this_with");
        AbstractC5969Lp4.d().k0().k(i2).m0(new InterfaceC24449ye1() { // from class: ir.nasim.pW6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                MW6.tb(topBarStoryView, (C21231tK7) obj);
            }
        });
    }

    private final void sc(QQ6 storyItem, StoryWidget.LinkWidget linkWidget) {
        oc().G5(storyItem);
        dc().q.setProgressBarVisibility(true);
        oc().P2(linkWidget);
    }

    private final void sd(final QQ6 storyItem) {
        Qc(false);
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        new NY(contextS7).B(h6(SD5.remove_story)).i(h6(SD5.story_delete_title)).x(h6(SD5.story_delete_button)).p(AbstractC23008wB5.ic_story_remove_alert).E(4).k(4).u(h6(SD5.story_cancel_button)).f(false).s(new View.OnClickListener() { // from class: ir.nasim.AW6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MW6.td(this.a, view);
            }
        }).v(new View.OnClickListener() { // from class: ir.nasim.BW6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MW6.ud(storyItem, this, view);
            }
        }).y(C5495Jo7.a.B0()).a().z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tb(TopBarStoryView topBarStoryView, C21231tK7 c21231tK7) {
        E25 e25;
        AbstractC13042fc3.i(topBarStoryView, "$this_with");
        AvatarViewGlide avatarView = topBarStoryView.getAvatarView();
        AbstractC13042fc3.f(c21231tK7);
        AvatarViewGlide.u(avatarView, c21231tK7, null, 2, null);
        Object objB = c21231tK7.r().b();
        AbstractC13042fc3.h(objB, "get(...)");
        topBarStoryView.setTitle((String) objB);
        C19482qQ7 c19482qQ7T = c21231tK7.t();
        if (c19482qQ7T == null || (e25 = (E25) c19482qQ7T.b()) == null) {
            return;
        }
        int i2 = b.b[e25.ordinal()];
        boolean z = true;
        if (i2 != 1 && i2 != 2) {
            z = false;
        }
        topBarStoryView.o0(z);
    }

    private final void tc(StoryWidget.PostWidget postWidget) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(postWidget.getLink()));
            C18987pb3 c18987pb3 = C18987pb3.a;
            FragmentActivity fragmentActivityQ7 = Q7();
            AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
            if (c18987pb3.k0(intent, fragmentActivityQ7)) {
                oc().Q5(true);
            } else {
                AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
                Context contextS7 = S7();
                AbstractC13042fc3.h(contextS7, "requireContext(...)");
                Uri uri = Uri.parse(postWidget.getLink());
                AbstractC13042fc3.h(uri, "parse(...)");
                aVar.A(contextS7, uri);
            }
        } catch (Exception e2) {
            C19406qI3.c("StoryWidget", "Error handling post widget click", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void td(MW6 mw6, View view) {
        AbstractC13042fc3.i(mw6, "this$0");
        mw6.l1();
        mw6.ad();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ub(final C14733iO2 c14733iO2, int i2, final MW6 mw6, int i3, PeersStruct$ExPeer peersStruct$ExPeer, final TopBarStoryView topBarStoryView, View view) {
        EnumC10088b35 type;
        AbstractC13042fc3.i(c14733iO2, "$groupVM");
        AbstractC13042fc3.i(mw6, "this$0");
        AbstractC13042fc3.i(peersStruct$ExPeer, "$exPeer");
        AbstractC13042fc3.i(topBarStoryView, "$this_with");
        if (((Boolean) c14733iO2.F().b()).booleanValue()) {
            yb(peersStruct$ExPeer, mw6, i2, i3);
            return;
        }
        C19406qI3.a("Source_Join_Cause", "story doJoinClick()", new Object[0]);
        AbstractC5969Lp4.d().C0(C11458d25.y(i2)).E(new InterfaceC24449ye1() { // from class: ir.nasim.sW6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                MW6.vb(c14733iO2, mw6, (Exception) obj);
            }
        }).m0(new InterfaceC24449ye1() { // from class: ir.nasim.tW6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                MW6.wb(this.a, topBarStoryView, (Integer) obj);
            }
        });
        ZV6 zv6D1 = mw6.nc().d1();
        if (zv6D1 != null) {
            C17180mX6 c17180mX6Nc = mw6.nc();
            ZV6.b bVar = new ZV6.b(zv6D1, ((QQ6) mw6.storyList.get(i3)).l(), XV6.b.a(((QQ6) mw6.storyList.get(i3)).e()));
            PeersStruct$ExPeer peersStruct$ExPeerG = ((QQ6) mw6.storyList.get(i3)).g();
            c17180mX6Nc.s1(bVar, (peersStruct$ExPeerG == null || (type = peersStruct$ExPeerG.getType()) == null) ? null : AbstractC24369yV6.b(type));
        }
        mw6.oc().F5(((QQ6) mw6.storyList.get(i3)).l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void uc() {
        if (C8386Vt0.Bb()) {
            this.showPostOnboardingTooltipTracker.a();
            final StoryWidget.PostWidget postWidgetKc = kc();
            if (postWidgetKc == null || !(!postWidgetKc.getWidgetCoordinates().isEmpty())) {
                return;
            }
            int top = dc().u.getTop();
            int left = dc().u.getLeft();
            WidgetCoordinate widgetCoordinateB = postWidgetKc.b(new XV4(Integer.valueOf(dc().u.getWidth()), Integer.valueOf(dc().u.getHeight())));
            WidgetCoordinate widgetCoordinateA = widgetCoordinateB.a(widgetCoordinateB.getX() + left, widgetCoordinateB.getY() + top);
            dc().s.setX(widgetCoordinateA.getX());
            dc().s.setY(widgetCoordinateA.getY());
            if (oc().c6()) {
                this.showPostOnboardingTooltipTracker.e(new SA2() { // from class: ir.nasim.wW6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return Boolean.valueOf(MW6.vc(this.a, postWidgetKc));
                    }
                });
                this.showPostOnboardingTooltipTracker.d(EnumC11271cj5.a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ud(QQ6 qq6, MW6 mw6, View view) {
        AbstractC13042fc3.i(qq6, "$storyItem");
        AbstractC13042fc3.i(mw6, "this$0");
        try {
            int i2 = b.a[qq6.u().ordinal()];
            if (i2 == 1) {
                mw6.oc().o5(qq6.l());
                mw6.Lc();
                return;
            }
            if (i2 != 2 && i2 != 3 && i2 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            mw6.oc().n5(qq6);
            mw6.Lc();
        } catch (Exception unused) {
            String strH6 = mw6.h6(SD5.story_remove_error);
            AbstractC13042fc3.h(strH6, "getString(...)");
            xd(mw6, strH6, false, null, null, 0, 30, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vb(C14733iO2 c14733iO2, MW6 mw6, Exception exc) {
        AbstractC13042fc3.i(c14733iO2, "$groupVM");
        AbstractC13042fc3.i(mw6, "this$0");
        xd(mw6, UN2.a(exc, c14733iO2.p() == ExPeerType.CHANNEL ? ZN2.CHANNEL : ZN2.GROUP), false, null, null, 0, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean vc(final MW6 mw6, final StoryWidget.PostWidget postWidget) {
        AbstractC13042fc3.i(mw6, "this$0");
        mw6.kd(new SA2() { // from class: ir.nasim.hW6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return MW6.wc(this.a, postWidget);
            }
        });
        mw6.oc().k5();
        return false;
    }

    private final void vd(InterfaceC14603iB2 onResult) {
        Tc(onResult);
        InterfaceC24908zP5.b(mc(), "REPORT_STORY_REQUEST_KEY", "REPORT_TITLE_RESULT_KEY", "REPORT_TYPE_RESULT_KEY", null, 8, null).L8(Q7().B0(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wb(MW6 mw6, TopBarStoryView topBarStoryView, Integer num) {
        AbstractC13042fc3.i(mw6, "this$0");
        AbstractC13042fc3.i(topBarStoryView, "$this_with");
        mw6.hd();
        String string = C5721Ko.a.d().getString(SD5.story_join_channel);
        AbstractC13042fc3.h(string, "getString(...)");
        xd(mw6, string, false, null, null, 0, 30, null);
        topBarStoryView.k0(true, mw6.S7().getString(SD5.btn_show));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 wc(MW6 mw6, StoryWidget.PostWidget postWidget) {
        AbstractC13042fc3.i(mw6, "this$0");
        QQ6 qq6Ic = mw6.ic();
        if (qq6Ic != null) {
            mw6.Oc(qq6Ic, postWidget);
        }
        return C19938rB7.a;
    }

    private final void wd(String message, boolean rtl, String action, SA2 onClickListener, int length) {
        C17468n10 c17468n10 = this.snackBar;
        if (c17468n10 != null) {
            c17468n10.m(length);
            if (action != null) {
                C17468n10.p(c17468n10, message, new AbstractC13463gG6.a(action, null, false, onClickListener, 6, null), null, 4, null);
            } else {
                C17468n10.p(c17468n10, message, AbstractC13463gG6.c.b, null, 4, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xb(PeersStruct$ExPeer peersStruct$ExPeer, MW6 mw6, int i2, int i3, View view) {
        AbstractC13042fc3.i(peersStruct$ExPeer, "$exPeer");
        AbstractC13042fc3.i(mw6, "this$0");
        yb(peersStruct$ExPeer, mw6, i2, i3);
    }

    private final void xc() {
        if (Gc()) {
            dc().o.w();
            return;
        }
        if (nc().o1()) {
            dc().o.E(false);
            nc().m1(true);
        } else if (nc().b1()) {
            dc().o.E(false);
        } else if (nc().p1()) {
            dc().o.w();
            rd();
            nc().f1();
        }
    }

    static /* synthetic */ void xd(MW6 mw6, String str, boolean z, String str2, SA2 sa2, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i3 & 4) != 0) {
            str2 = null;
        }
        String str3 = str2;
        if ((i3 & 8) != 0) {
            sa2 = new SA2() { // from class: ir.nasim.FW6
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return MW6.yd();
                }
            };
        }
        SA2 sa22 = sa2;
        if ((i3 & 16) != 0) {
            i2 = -1;
        }
        mw6.wd(str, z2, str3, sa22, i2);
    }

    private static final void yb(PeersStruct$ExPeer peersStruct$ExPeer, MW6 mw6, int i2, int i3) {
        EnumC10088b35 type = peersStruct$ExPeer.getType();
        AbstractC13042fc3.h(type, "getType(...)");
        if (AbstractC24369yV6.b(type) == EnumC23779xV6.b) {
            return;
        }
        C11458d25 c11458d25Y = C11458d25.y(i2);
        AbstractC13042fc3.h(c11458d25Y, "group(...)");
        mw6.Pc(c11458d25Y, peersStruct$ExPeer.getType() == EnumC10088b35.ExPeerType_GROUP ? ExPeerType.GROUP : ExPeerType.CHANNEL);
        mw6.nc().k1((QQ6) mw6.storyList.get(i3));
    }

    private final void yc() {
        HashMap map = new HashMap();
        QQ6 qq6 = this.lastViewedStory;
        if (qq6 != null) {
            map.put("duration_seconds", Long.valueOf((System.currentTimeMillis() - this.storyStartTime) / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT));
            map.put("story_id", qq6.l());
            map.put("action_type", Integer.valueOf(qq6.G() ? 2 : 1));
            C3343Am.i("status_time", map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 yd() {
        return C19938rB7.a;
    }

    private final void zb() {
        bd(true);
        int iIndexOf = this.userIdList.indexOf(Integer.valueOf(this.userId));
        if (iIndexOf > 0 && dc().l.getCurrentStep() == 0) {
            qc(iIndexOf);
        } else if (iIndexOf == 0 && dc().l.getCurrentStep() == 0) {
            Lc();
        } else {
            dc().l.n();
        }
    }

    private final void zc() {
        C17468n10 c17468n10;
        C17468n10 c17468n102 = this.snackBar;
        if (c17468n102 == null || !c17468n102.j() || (c17468n10 = this.snackBar) == null) {
            return;
        }
        c17468n10.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zd() {
        dc().t.setVisibility(0);
        dc().l.setVisibility(0);
        dc().r.setVisibility(0);
        dc().d.setVisibility(0);
        StoryLinkCustomView storyLinkCustomView = dc().q;
        AbstractC13042fc3.h(storyLinkCustomView, "storyLinkLayout");
        storyLinkCustomView.setVisibility(jc() != null ? 0 : 8);
        if (dc().o.getLastCommand() instanceof ReactionHandler.b.d) {
            dc().o.setVisibility(0);
        }
    }

    @Override // com.genius.multiprogressbar.MultiProgressBar.d
    public void E1(int newStep) {
        C19938rB7 c19938rB7;
        EnumC10088b35 type;
        QQ6 qq6;
        if (getHasBeenResumed()) {
            if (!this.canGoNextStory) {
                v4();
                return;
            }
            if (Hc() && (qq6 = this.lastViewedStory) != null) {
                oc().D5(qq6.l());
            }
            try {
                C9475a16.a aVar = C9475a16.b;
                ZV6 zv6D1 = nc().d1();
                if (zv6D1 != null) {
                    QQ6 qq62 = (QQ6) this.storyList.get(newStep);
                    C17180mX6 c17180mX6Nc = nc();
                    ZV6.c cVar = new ZV6.c(zv6D1, qq62.l(), XV6.b.a(qq62.e()));
                    PeersStruct$ExPeer peersStruct$ExPeerG = qq62.g();
                    c17180mX6Nc.s1(cVar, (peersStruct$ExPeerG == null || (type = peersStruct$ExPeerG.getType()) == null) ? null : AbstractC24369yV6.b(type));
                    c19938rB7 = C19938rB7.a;
                } else {
                    c19938rB7 = null;
                }
                C9475a16.b(c19938rB7);
            } catch (Throwable th) {
                C9475a16.a aVar2 = C9475a16.b;
                C9475a16.b(AbstractC10685c16.a(th));
            }
            yc();
            Zc();
            if (this.isDiscreteMode) {
                dd(newStep);
                Ad();
                XV4 xv4 = this.postToStoryOnboardingTooltip;
                if (xv4 != null) {
                    D20 d20 = (D20) xv4.a();
                    String str = (String) xv4.b();
                    if (d20.m0()) {
                        QQ6 qq6Ic = ic();
                        if (!AbstractC13042fc3.d(str, qq6Ic != null ? qq6Ic.l() : null)) {
                            d20.E();
                        }
                    }
                }
            } else {
                U();
            }
            rc(newStep);
            uc();
        }
    }

    @Override // ir.nasim.InterfaceC24762z98
    /* renamed from: F0, reason: from getter */
    public boolean getAutoSystemBarTop() {
        return this.autoSystemBarTop;
    }

    @Override // ir.nasim.DQ6
    public void I4() {
        dd(dc().l.getCurrentStep());
        Ad();
        zd();
    }

    @Override // ir.nasim.DS6
    public void M4(int position) {
        if (position == dc().u.getCurrentItem()) {
            cd(false);
            this.showPostOnboardingTooltipTracker.d(EnumC11271cj5.b);
        }
        this.loadedStoryPosition = position;
        QQ6 qq6Ic = ic();
        if (qq6Ic == null) {
            return;
        }
        gd(qq6Ic);
        Gb(qq6Ic);
        Ad();
    }

    @Override // ir.nasim.DQ6
    public void O2() {
        int iIndexOf = this.userIdList.indexOf(Integer.valueOf(this.userId));
        if (iIndexOf > 0) {
            qc(iIndexOf);
        }
    }

    @Override // ir.nasim.InterfaceC24762z98
    /* renamed from: P0, reason: from getter */
    public boolean getAutoSystemBarBottom() {
        return this.autoSystemBarBottom;
    }

    @Override // ir.nasim.DQ6
    public void P2() {
        bd(true);
        Rc(this, false, 1, null);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            this.userId = bundleE5.getInt("USER_ID_KEY");
            this.storyType = oc().u4(this.userId);
            ArrayList<Integer> integerArrayList = bundleE5.getIntegerArrayList("USER_ID_LIST_KEY");
            AbstractC13042fc3.g(integerArrayList, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Int>");
            this.userIdList = integerArrayList;
            this.selectedStoryId = bundleE5.getString("SELECTED_STORY_ID_KEY");
            this.jumpToStoryId = bundleE5.getString("JUMP_TO_STORY_ID_KEY");
            int i2 = bundleE5.getInt("BUNDLE_STORY_POSITION", -1);
            String string = bundleE5.getString("BUNDLE_STORY_OPENING_ORIGIN", null);
            if (string != null) {
                nc().e1(WV6.valueOf(string), i2 != -1 ? Integer.valueOf(i2) : null, this.storyType);
            }
        }
        this._binding = C3702Bz2.c(inflater, container, false);
        CoordinatorLayout coordinatorLayoutB = dc().getRoot();
        AbstractC13042fc3.h(coordinatorLayoutB, "getRoot(...)");
        return coordinatorLayoutB;
    }

    @Override // ir.nasim.InterfaceC19822r00
    public void S0() {
        Ic(true);
        ad();
        l1();
        Lb(-16777216);
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        zc();
        Nb();
        super.T6();
        oc().d6();
    }

    @Override // com.genius.multiprogressbar.MultiProgressBar.c
    public void U() {
        if (!this.canGoNextStory) {
            v4();
        } else {
            Ac();
            hb();
        }
    }

    @Override // ir.nasim.XZ
    public void U1(boolean z) {
        this.hasBeenResumed = z;
    }

    @Override // androidx.fragment.app.Fragment
    public void U6() {
        dc().u.r(this.pagerChangeCallback);
        super.U6();
    }

    @Override // ir.nasim.InterfaceC19822r00
    public void a1() {
        Ic(false);
        Qc(false);
        Integer num = this.originalNavigationBarColor;
        if (num != null) {
            Lb(num.intValue());
        }
    }

    @Override // ir.nasim.DQ6
    public void a5() {
        zb();
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void c7() {
        Qc(false);
        Ic(false);
        Integer num = this.originalNavigationBarColor;
        if (num != null) {
            Lb(num.intValue());
        }
        super.c7();
    }

    public final InterfaceC11677dQ0 ec() {
        InterfaceC11677dQ0 interfaceC11677dQ0 = this.chatNavigator;
        if (interfaceC11677dQ0 != null) {
            return interfaceC11677dQ0;
        }
        AbstractC13042fc3.y("chatNavigator");
        return null;
    }

    @Override // ir.nasim.C22042ua0
    public void i9() {
        super.i9();
        oc().Y4();
    }

    @Override // ir.nasim.DS6
    public void l1() {
        MultiProgressBar multiProgressBar = dc().l;
        if (this.storyList.size() > 0) {
            try {
                MultiProgressBar.p(multiProgressBar, null, 1, null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // ir.nasim.InterfaceC24762z98
    /* renamed from: l2, reason: from getter */
    public boolean getAutoIme() {
        return this.autoIme;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        this.originalNavigationBarColor = Integer.valueOf(Q7().getWindow().getNavigationBarColor());
        C14931ij3 c14931ij3 = this.showPostOnboardingTooltipTracker;
        EnumC11271cj5[] enumC11271cj5Arr = (EnumC11271cj5[]) EnumC11271cj5.j().toArray(new EnumC11271cj5[0]);
        c14931ij3.f((Comparable[]) Arrays.copyOf(enumC11271cj5Arr, enumC11271cj5Arr.length));
        Xb();
        cb();
        dc().t.f0(new View.OnClickListener() { // from class: ir.nasim.GW6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MW6.Nc(this.a, view2);
            }
        });
        dc().u.k(this.pagerChangeCallback);
        Tb();
        Pb();
        Sb();
        Ub();
        Wb();
        Rb();
        String str = this.jumpToStoryId;
        if (str == null || bc(this.userId, str) == null) {
            String str2 = this.selectedStoryId;
            if (str2 != null) {
                Yb(this.userId, str2);
            } else {
                ac(this, this.userId, false, 2, null);
            }
        }
        Jc();
        Cc();
        Ab();
        Bc();
    }

    public final InterfaceC24908zP5 mc() {
        InterfaceC24908zP5 interfaceC24908zP5 = this.reportNavigator;
        if (interfaceC24908zP5 != null) {
            return interfaceC24908zP5;
        }
        AbstractC13042fc3.y("reportNavigator");
        return null;
    }

    @Override // ir.nasim.DQ6
    public void n4() {
        int iIndexOf = this.userIdList.indexOf(Integer.valueOf(this.userId));
        if (iIndexOf < this.userIdList.size() - 1) {
            pc(iIndexOf);
        } else {
            Lc();
        }
    }

    @Override // ir.nasim.InterfaceC15279jJ4
    public void onClose() {
        Ad();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent event) {
        EQ6 eq6 = this.storyGestureDetector;
        if (eq6 == null) {
            AbstractC13042fc3.y("storyGestureDetector");
            eq6 = null;
        }
        return eq6.b(view, event);
    }

    @Override // ir.nasim.XZ
    /* renamed from: s3, reason: from getter */
    public boolean getHasBeenResumed() {
        return this.hasBeenResumed;
    }

    @Override // ir.nasim.DQ6
    public boolean u1(MotionEvent event) {
        AbstractC13042fc3.i(event, "event");
        if (!C8386Vt0.Bb()) {
            return false;
        }
        final StoryWidget.PostWidget postWidgetKc = kc();
        if (postWidgetKc == null) {
            I4();
            bd(true);
            return false;
        }
        zd();
        int top = dc().u.getTop();
        int left = dc().u.getLeft();
        XV4 xv4 = new XV4(Integer.valueOf(dc().u.getWidth()), Integer.valueOf(dc().u.getHeight()));
        WidgetCoordinate widgetCoordinateD = postWidgetKc.d(xv4);
        float f2 = left;
        float f3 = top;
        WidgetCoordinate widgetCoordinateA = widgetCoordinateD.a(widgetCoordinateD.getX() + f2, widgetCoordinateD.getY() + f3);
        WidgetCoordinate widgetCoordinateA2 = postWidgetKc.a(xv4);
        WidgetCoordinate widgetCoordinateA3 = widgetCoordinateA2.a(widgetCoordinateA2.getX() + f2, widgetCoordinateA2.getY() + f3);
        float x2 = widgetCoordinateA.getX();
        float x3 = widgetCoordinateA3.getX();
        float rawX = event.getRawX();
        if (x2 <= rawX && rawX <= x3) {
            float y2 = widgetCoordinateA.getY();
            float y3 = widgetCoordinateA3.getY();
            float rawY = event.getRawY();
            if (y2 <= rawY && rawY <= y3) {
                md(new SA2() { // from class: ir.nasim.HW6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return MW6.Mb(this.a, postWidgetKc);
                    }
                });
                return true;
            }
        }
        I4();
        bd(true);
        return false;
    }

    @Override // ir.nasim.DS6
    public void v4() {
        dc().l.m();
    }

    @Override // ir.nasim.DQ6
    public void y3() {
        if (Fc()) {
            hb();
        } else {
            dc().l.l();
        }
    }
}
