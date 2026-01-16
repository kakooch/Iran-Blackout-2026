package ir.nasim.features.audioplayer.ui;

import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC17683nO;
import ir.nasim.AbstractC18874pP;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC7562Sg0;
import ir.nasim.C10410bZ6;
import ir.nasim.C14730iO;
import ir.nasim.C14733iO2;
import ir.nasim.C17959nq7;
import ir.nasim.C21231tK7;
import ir.nasim.C23709xO;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.C8552Wl4;
import ir.nasim.EnumC8503Wg0;
import ir.nasim.InterfaceC16501lO;
import ir.nasim.InterfaceC24449ye1;
import ir.nasim.JF5;
import ir.nasim.KB5;
import ir.nasim.QZ7;
import ir.nasim.VL;
import ir.nasim.VW5;
import ir.nasim.XY6;
import ir.nasim.features.audioplayer.ui.AudioPlayBar;
import java.text.Bidi;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import livekit.org.webrtc.MediaStreamTrack;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u00014B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0013H\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\"\u0010\u0018J\u0017\u0010%\u001a\u00020\f2\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u0016H\u0002¢\u0006\u0004\b'\u0010\u0018J\u000f\u0010(\u001a\u00020\fH\u0002¢\u0006\u0004\b(\u0010\u000eJ\u000f\u0010)\u001a\u00020\fH\u0002¢\u0006\u0004\b)\u0010\u000eJ\u000f\u0010*\u001a\u00020\fH\u0002¢\u0006\u0004\b*\u0010\u000eJ\u000f\u0010+\u001a\u00020\fH\u0002¢\u0006\u0004\b+\u0010\u000eJ\u000f\u0010,\u001a\u00020\fH\u0002¢\u0006\u0004\b,\u0010\u000eJ\r\u0010-\u001a\u00020\f¢\u0006\u0004\b-\u0010\u000eJ\r\u0010.\u001a\u00020\f¢\u0006\u0004\b.\u0010\u000eJ\u0015\u00101\u001a\u00020\f2\u0006\u00100\u001a\u00020/¢\u0006\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006>"}, d2 = {"Lir/nasim/features/audioplayer/ui/AudioPlayBar;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rB7;", "u", "()V", "Lir/nasim/VL;", MediaStreamTrack.AUDIO_TRACK_KIND, TokenNames.F, "(Lir/nasim/VL;)V", "Lir/nasim/Wl4;", "setTitleForMusic", "(Lir/nasim/Wl4;)V", "Lir/nasim/QZ7;", "setTitleForVoice", "(Lir/nasim/QZ7;)V", "Lir/nasim/pP;", "audioSpeedMode", "setAudioSpeedIcon", "(Lir/nasim/pP;)V", "", "time", "setTimer", "(J)V", "voice", "setVoiceSenderName", "Lir/nasim/tK7;", "userVM", "setTitleBySenderName", "(Lir/nasim/tK7;)V", "setTitleByGroupName", "s", "r", "q", "t", "D", "p", TokenNames.E, "Lir/nasim/features/audioplayer/ui/AudioPlayBar$a;", "callback", "setOnPlayerCallbacks", "(Lir/nasim/features/audioplayer/ui/AudioPlayBar$a;)V", "Lir/nasim/nO;", "a", "Lir/nasim/nO;", "audioPlayerCallback", "b", "Lir/nasim/features/audioplayer/ui/AudioPlayBar$a;", "playerClickCallback", "Lir/nasim/iO;", "c", "Lir/nasim/iO;", "binding", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class AudioPlayBar extends FrameLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private AbstractC17683nO audioPlayerCallback;

    /* renamed from: b, reason: from kotlin metadata */
    private a playerClickCallback;

    /* renamed from: c, reason: from kotlin metadata */
    private C14730iO binding;

    public interface a {
        static /* synthetic */ void U3(a aVar, VL vl, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onClick");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            aVar.g2(vl, z);
        }

        void g2(VL vl, boolean z);
    }

    public static final class b extends AbstractC17683nO {
        b() {
        }

        @Override // ir.nasim.AbstractC17683nO
        public void a(VL vl) {
            AudioPlayBar.this.F(vl);
        }

        @Override // ir.nasim.AbstractC17683nO
        public void b(AbstractC18874pP abstractC18874pP) {
            AbstractC13042fc3.i(abstractC18874pP, "audioSpeedMode");
            AudioPlayBar.this.setAudioSpeedIcon(abstractC18874pP);
        }

        @Override // ir.nasim.AbstractC17683nO
        public void c(VL vl) {
            AbstractC13042fc3.i(vl, MediaStreamTrack.AUDIO_TRACK_KIND);
            AudioPlayBar.this.t();
        }

        @Override // ir.nasim.AbstractC17683nO
        public void d(VL vl) {
            AbstractC13042fc3.i(vl, MediaStreamTrack.AUDIO_TRACK_KIND);
            AudioPlayBar.this.q();
        }

        @Override // ir.nasim.AbstractC17683nO
        public void e() {
            AudioPlayBar.this.t();
        }

        @Override // ir.nasim.AbstractC17683nO
        public void f(VL vl) {
            AbstractC13042fc3.i(vl, MediaStreamTrack.AUDIO_TRACK_KIND);
            AudioPlayBar.this.q();
        }

        @Override // ir.nasim.AbstractC17683nO
        public void g(VL vl) {
            AbstractC13042fc3.i(vl, MediaStreamTrack.AUDIO_TRACK_KIND);
            AudioPlayBar.this.r();
            AudioPlayBar.this.D();
        }

        @Override // ir.nasim.AbstractC17683nO
        public void h(VL vl, long j) {
            AbstractC13042fc3.i(vl, MediaStreamTrack.AUDIO_TRACK_KIND);
            if (vl instanceof QZ7) {
                AudioPlayBar.this.setTimer(Math.max(((QZ7) vl).b() - j, 0L));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioPlayBar(Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        C14730iO c14730iOC = C14730iO.c(LayoutInflater.from(getContext()), this, true);
        AbstractC13042fc3.h(c14730iOC, "inflate(...)");
        this.binding = c14730iOC;
        u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(AudioPlayBar audioPlayBar, Exception exc) {
        AbstractC13042fc3.i(audioPlayBar, "this$0");
        audioPlayBar.binding.d.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(AudioPlayBar audioPlayBar, QZ7 qz7, Exception exc) {
        AbstractC13042fc3.i(audioPlayBar, "this$0");
        AbstractC13042fc3.i(qz7, "$voice");
        audioPlayBar.setTitleByGroupName(qz7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(AudioPlayBar audioPlayBar, QZ7 qz7, C21231tK7 c21231tK7) {
        AbstractC13042fc3.i(audioPlayBar, "this$0");
        AbstractC13042fc3.i(qz7, "$voice");
        if (c21231tK7 != null) {
            audioPlayBar.setTitleBySenderName(c21231tK7);
        } else {
            audioPlayBar.setTitleByGroupName(qz7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D() {
        if (getVisibility() != 0) {
            setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(VL audio) {
        if (audio instanceof QZ7) {
            if (this.binding.h.getVisibility() != 0) {
                this.binding.h.setVisibility(0);
            }
            if (this.binding.g.getVisibility() != 0) {
                this.binding.g.setVisibility(0);
            }
            setTitleForVoice((QZ7) audio);
            setAudioSpeedIcon(C23709xO.a.K());
            return;
        }
        if (!(audio instanceof C8552Wl4)) {
            this.binding.d.setText("");
            return;
        }
        if (this.binding.h.getVisibility() == 0) {
            this.binding.h.setVisibility(8);
        }
        if (this.binding.g.getVisibility() != 0) {
            this.binding.g.setVisibility(0);
        }
        setAudioSpeedIcon(C23709xO.a.K());
        setTitleForMusic((C8552Wl4) audio);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        this.binding.f.setImageDrawable(VW5.f(getResources(), KB5.inline_video_play, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        this.binding.f.setImageDrawable(VW5.f(getResources(), KB5.inline_video_pause, null));
    }

    private final void s() {
        C23709xO c23709xO = C23709xO.a;
        if (c23709xO.N() == 3) {
            D();
            if (c23709xO.i()) {
                r();
            } else {
                q();
            }
        }
        AbstractC17683nO abstractC17683nO = this.audioPlayerCallback;
        if (abstractC17683nO != null) {
            c23709xO.u(abstractC17683nO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAudioSpeedIcon(AbstractC18874pP audioSpeedMode) {
        if (audioSpeedMode instanceof AbstractC18874pP.a) {
            ImageView imageView = this.binding.g;
            imageView.setBackgroundResource(KB5.ic_half_x_speed_voice);
            imageView.getBackground().setColorFilter(AbstractC7562Sg0.a(C5495Jo7.a.a0(), EnumC8503Wg0.SRC_ATOP));
            return;
        }
        if (audioSpeedMode instanceof AbstractC18874pP.c) {
            ImageView imageView2 = this.binding.g;
            imageView2.setBackgroundResource(KB5.icon_speed_one_x);
            imageView2.getBackground().setColorFilter(AbstractC7562Sg0.a(C5495Jo7.a.c0(), EnumC8503Wg0.SRC_ATOP));
        } else if (audioSpeedMode instanceof AbstractC18874pP.b) {
            ImageView imageView3 = this.binding.g;
            imageView3.setBackgroundResource(KB5.icon_speed_one_and_half_x);
            imageView3.getBackground().setColorFilter(AbstractC7562Sg0.a(C5495Jo7.a.a0(), EnumC8503Wg0.SRC_ATOP));
        } else {
            if (!(audioSpeedMode instanceof AbstractC18874pP.d)) {
                throw new NoWhenBranchMatchedException();
            }
            ImageView imageView4 = this.binding.g;
            imageView4.setBackgroundResource(KB5.icon_speed_two_x);
            imageView4.getBackground().setColorFilter(AbstractC7562Sg0.a(C5495Jo7.a.a0(), EnumC8503Wg0.SRC_ATOP));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTimer(long time) {
        String str;
        String strA = C17959nq7.a.a((int) (time / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT));
        if (JF5.g()) {
            str = XY6.e(strA) + " - ";
        } else {
            str = " - " + strA;
        }
        this.binding.h.setText(str);
    }

    private final void setTitleByGroupName(QZ7 voice) {
        AbstractC5969Lp4.b().k(voice.d().e().getPeerId()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.gO
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                AudioPlayBar.z(this.a, (C14733iO2) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.hO
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                AudioPlayBar.A(this.a, (Exception) obj);
            }
        });
    }

    private final void setTitleBySenderName(C21231tK7 userVM) {
        String str = (String) userVM.q().b();
        if (str == null || str.length() == 0) {
            str = (String) userVM.r().b();
        }
        this.binding.d.setText(str);
    }

    private final void setTitleForMusic(C8552Wl4 audio) {
        if (audio.h().length() == 0 && audio.j().length() == 0) {
            this.binding.d.setText("Audio");
            return;
        }
        if (audio.h().length() == 0) {
            this.binding.d.setText(audio.j());
            return;
        }
        if (audio.j().length() == 0) {
            this.binding.d.setText(audio.h());
            return;
        }
        if (new Bidi(audio.h() + " - " + audio.j(), -2).getBaseLevel() == 0) {
            this.binding.d.setText(audio.h() + " - " + audio.j());
            return;
        }
        this.binding.d.setText(audio.j() + " - " + audio.h());
    }

    private final void setTitleForVoice(QZ7 audio) {
        setTimer(audio.b() - C23709xO.a.O());
        setVoiceSenderName(audio);
    }

    private final void setVoiceSenderName(final QZ7 voice) {
        AbstractC5969Lp4.g().k(voice.h()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.aO
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                AudioPlayBar.C(this.a, voice, (C21231tK7) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.bO
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                AudioPlayBar.B(this.a, voice, (Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        if (getVisibility() != 8) {
            setVisibility(8);
        }
    }

    private final void u() {
        this.binding.d.setSelected(true);
        this.binding.d.setTypeface(C6011Lu2.k());
        this.binding.h.setTypeface(C6011Lu2.k());
        this.binding.f.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.cO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudioPlayBar.v(view);
            }
        });
        this.binding.e.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.dO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudioPlayBar.w(view);
            }
        });
        this.binding.g.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.eO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudioPlayBar.x(view);
            }
        });
        setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.fO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudioPlayBar.y(this.a, view);
            }
        });
        this.audioPlayerCallback = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(View view) {
        C23709xO.a.x0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(View view) {
        InterfaceC16501lO.w(C23709xO.a, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(View view) {
        C23709xO.a.y0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(AudioPlayBar audioPlayBar, View view) {
        a aVar;
        AbstractC13042fc3.i(audioPlayBar, "this$0");
        VL vlM = C23709xO.a.M();
        if (vlM == null || (aVar = audioPlayBar.playerClickCallback) == null) {
            return;
        }
        a.U3(aVar, vlM, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(AudioPlayBar audioPlayBar, C14733iO2 c14733iO2) {
        String str;
        C10410bZ6 c10410bZ6V;
        AbstractC13042fc3.i(audioPlayBar, "this$0");
        TextView textView = audioPlayBar.binding.d;
        if (c14733iO2 == null || (c10410bZ6V = c14733iO2.v()) == null || (str = (String) c10410bZ6V.b()) == null) {
            str = "";
        }
        textView.setText(str);
    }

    public final void E() {
        this.playerClickCallback = null;
        AbstractC17683nO abstractC17683nO = this.audioPlayerCallback;
        if (abstractC17683nO != null) {
            C23709xO.a.z0(abstractC17683nO);
        }
    }

    public final void p() {
        s();
        F(C23709xO.a.M());
    }

    public final void setOnPlayerCallbacks(a callback) {
        AbstractC13042fc3.i(callback, "callback");
        this.playerClickCallback = callback;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioPlayBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        C14730iO c14730iOC = C14730iO.c(LayoutInflater.from(getContext()), this, true);
        AbstractC13042fc3.h(c14730iOC, "inflate(...)");
        this.binding = c14730iOC;
        u();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioPlayBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        C14730iO c14730iOC = C14730iO.c(LayoutInflater.from(getContext()), this, true);
        AbstractC13042fc3.h(c14730iOC, "inflate(...)");
        this.binding = c14730iOC;
        u();
    }
}
