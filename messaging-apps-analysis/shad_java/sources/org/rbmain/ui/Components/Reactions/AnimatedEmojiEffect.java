package org.rbmain.ui.Components.Reactions;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import com.facebook.stetho.websocket.CloseCodes;
import ir.medu.shad.R;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LiteMode;
import org.rbmain.messenger.MediaDataController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.Utilities;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$TL_availableReaction;
import org.rbmain.tgnet.TLRPC$TL_messages_stickerSet;
import org.rbmain.ui.Components.AnimatedEmojiDrawable;
import org.rbmain.ui.Components.RLottieDrawable;

/* loaded from: classes5.dex */
public class AnimatedEmojiEffect {
    public AnimatedEmojiDrawable animatedEmojiDrawable;
    int currentAccount;
    ImageReceiver effectImageReceiver;
    long lastGenerateTime;
    boolean longAnimation;
    View parentView;
    boolean showGeneric;
    Rect bounds = new Rect();
    ArrayList<Particle> particles = new ArrayList<>();
    boolean firsDraw = true;
    int animationIndex = -1;
    long startTime = System.currentTimeMillis();

    private AnimatedEmojiEffect(AnimatedEmojiDrawable animatedEmojiDrawable, int i, boolean z, boolean z2) {
        this.animatedEmojiDrawable = animatedEmojiDrawable;
        this.longAnimation = z;
        this.currentAccount = i;
        this.showGeneric = z2;
        if (!z && z2 && LiteMode.isEnabled(LiteMode.FLAG_ANIMATED_EMOJI_CHAT)) {
            this.effectImageReceiver = new ImageReceiver();
        }
    }

    public static AnimatedEmojiEffect createFrom(AnimatedEmojiDrawable animatedEmojiDrawable, boolean z, boolean z2) {
        return new AnimatedEmojiEffect(animatedEmojiDrawable, UserConfig.selectedAccount, z, z2);
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        this.bounds.set(i, i2, i3, i4);
        ImageReceiver imageReceiver = this.effectImageReceiver;
        if (imageReceiver != null) {
            imageReceiver.setImageCoords(this.bounds);
        }
    }

    public void draw(Canvas canvas) {
        if (!this.longAnimation) {
            if (this.firsDraw) {
                for (int i = 0; i < 7; i++) {
                    Particle particle = new Particle();
                    particle.generate();
                    this.particles.add(particle);
                }
            }
        } else {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.particles.size() < 12) {
                long j = this.startTime;
                if (jCurrentTimeMillis - j < 1500 && jCurrentTimeMillis - j > 200 && jCurrentTimeMillis - this.lastGenerateTime > 50 && Utilities.fastRandom.nextInt() % 6 == 0) {
                    Particle particle2 = new Particle();
                    particle2.generate();
                    this.particles.add(particle2);
                    this.lastGenerateTime = jCurrentTimeMillis;
                }
            }
        }
        ImageReceiver imageReceiver = this.effectImageReceiver;
        if (imageReceiver != null && this.showGeneric) {
            imageReceiver.draw(canvas);
        }
        int i2 = 0;
        while (i2 < this.particles.size()) {
            this.particles.get(i2).draw(canvas);
            if (this.particles.get(i2).progress >= 1.0f) {
                this.particles.remove(i2);
                i2--;
            }
            i2++;
        }
        View view = this.parentView;
        if (view != null) {
            view.invalidate();
        }
        this.firsDraw = false;
    }

    public void setView(View view) {
        boolean z;
        TLRPC$TL_availableReaction tLRPC$TL_availableReaction;
        TLRPC$Document tLRPC$Document;
        this.animatedEmojiDrawable.addView(view);
        this.parentView = view;
        ImageReceiver imageReceiver = this.effectImageReceiver;
        if (imageReceiver == null || !this.showGeneric) {
            return;
        }
        imageReceiver.onAttachedToWindow();
        TLRPC$TL_messages_stickerSet stickerSetByName = null;
        String strFindAnimatedEmojiEmoticon = MessageObject.findAnimatedEmojiEmoticon(this.animatedEmojiDrawable.getDocument(), null);
        if (strFindAnimatedEmojiEmoticon == null || (tLRPC$TL_availableReaction = MediaDataController.getInstance(this.currentAccount).getReactionsMap().get(strFindAnimatedEmojiEmoticon)) == null || (tLRPC$Document = tLRPC$TL_availableReaction.around_animation) == null) {
            z = false;
        } else {
            this.effectImageReceiver.setImage(ImageLocation.getForDocument(tLRPC$Document), ReactionsEffectOverlay.getFilterForAroundAnimation(), null, null, tLRPC$TL_availableReaction.around_animation, 0);
            z = true;
        }
        if (!z) {
            String str = UserConfig.getInstance(this.currentAccount).genericAnimationsStickerPack;
            if (str != null && (stickerSetByName = MediaDataController.getInstance(this.currentAccount).getStickerSetByName(str)) == null) {
                stickerSetByName = MediaDataController.getInstance(this.currentAccount).getStickerSetByEmojiOrName(str);
            }
            if (stickerSetByName != null) {
                if (this.animationIndex < 0) {
                    this.animationIndex = Math.abs(Utilities.fastRandom.nextInt() % stickerSetByName.documents.size());
                }
                this.effectImageReceiver.setImage(ImageLocation.getForDocument(stickerSetByName.documents.get(this.animationIndex)), "60_60", null, null, stickerSetByName.documents.get(this.animationIndex), 0);
                z = true;
            }
        }
        if (z) {
            if (this.effectImageReceiver.getLottieAnimation() != null) {
                this.effectImageReceiver.getLottieAnimation().setCurrentFrame(0, false, true);
            }
            this.effectImageReceiver.setAutoRepeat(0);
            return;
        }
        this.effectImageReceiver.setImageBitmap(new RLottieDrawable(R.raw.custom_emoji_reaction, "2131820572", AndroidUtilities.dp(60.0f), AndroidUtilities.dp(60.0f), false, null));
    }

    public void removeView(View view) {
        this.animatedEmojiDrawable.removeView(view);
        ImageReceiver imageReceiver = this.effectImageReceiver;
        if (imageReceiver != null) {
            imageReceiver.onDetachedFromWindow();
            this.effectImageReceiver.clearImage();
        }
    }

    private class Particle {
        long duration;
        float fromSize;
        float fromX;
        float fromY;
        boolean mirror;
        float progress;
        float randomRotation;
        float toSize;
        float toX;
        float toY1;
        float toY2;

        private Particle() {
        }

        public void generate() {
            float f = 0.0f;
            this.progress = 0.0f;
            float fRandX = randX();
            float fRandY = randY();
            for (int i = 0; i < 20; i++) {
                float fRandX2 = randX();
                float fRandY2 = randY();
                float f2 = 2.1474836E9f;
                for (int i2 = 0; i2 < AnimatedEmojiEffect.this.particles.size(); i2++) {
                    float f3 = AnimatedEmojiEffect.this.particles.get(i2).toX - fRandX2;
                    float f4 = AnimatedEmojiEffect.this.particles.get(i2).toY1 - fRandY2;
                    float f5 = (f3 * f3) + (f4 * f4);
                    if (f5 < f2) {
                        f2 = f5;
                    }
                }
                if (f2 > f) {
                    fRandX = fRandX2;
                    fRandY = fRandY2;
                    f = f2;
                }
            }
            float f6 = AnimatedEmojiEffect.this.longAnimation ? 0.8f : 0.5f;
            this.toX = fRandX;
            if (fRandX > r0.bounds.width() * f6) {
                this.fromX = AnimatedEmojiEffect.this.bounds.width() * f6;
            } else {
                float fWidth = AnimatedEmojiEffect.this.bounds.width() * f6;
                this.fromX = fWidth;
                if (this.toX > fWidth) {
                    this.toX = fWidth - 0.1f;
                }
            }
            this.fromY = (AnimatedEmojiEffect.this.bounds.height() * 0.45f) + (AnimatedEmojiEffect.this.bounds.height() * 0.1f * (Math.abs(Utilities.fastRandom.nextInt() % 100) / 100.0f));
            if (AnimatedEmojiEffect.this.longAnimation) {
                float fWidth2 = (r0.bounds.width() * 0.05f) + (AnimatedEmojiEffect.this.bounds.width() * 0.1f * (Math.abs(Utilities.fastRandom.nextInt() % 100) / 100.0f));
                this.fromSize = fWidth2;
                this.toSize = fWidth2 * (((Math.abs(Utilities.fastRandom.nextInt() % 100) / 100.0f) * 1.5f) + 1.5f);
                this.toY1 = (this.fromSize / 2.0f) + (AnimatedEmojiEffect.this.bounds.height() * 0.1f * (Math.abs(Utilities.fastRandom.nextInt() % 100) / 100.0f));
                this.toY2 = AnimatedEmojiEffect.this.bounds.height() + this.fromSize;
                this.duration = Math.abs(Utilities.fastRandom.nextInt() % 600) + CloseCodes.NORMAL_CLOSURE;
            } else {
                float fWidth3 = (r0.bounds.width() * 0.05f) + (AnimatedEmojiEffect.this.bounds.width() * 0.1f * (Math.abs(Utilities.fastRandom.nextInt() % 100) / 100.0f));
                this.fromSize = fWidth3;
                this.toSize = fWidth3 * (((Math.abs(Utilities.fastRandom.nextInt() % 100) / 100.0f) * 0.5f) + 1.5f);
                this.toY1 = fRandY;
                this.toY2 = fRandY + AnimatedEmojiEffect.this.bounds.height();
                this.duration = 1800L;
            }
            this.duration = (long) (this.duration / 1.75f);
            this.mirror = Utilities.fastRandom.nextBoolean();
            this.randomRotation = ((Utilities.fastRandom.nextInt() % 100) / 100.0f) * 20.0f;
        }

        private float randY() {
            return AnimatedEmojiEffect.this.bounds.height() * 0.5f * (Math.abs(Utilities.fastRandom.nextInt() % 100) / 100.0f);
        }

        private float randX() {
            if (AnimatedEmojiEffect.this.longAnimation) {
                return (r0.bounds.width() * (-0.25f)) + (AnimatedEmojiEffect.this.bounds.width() * 1.5f * (Math.abs(Utilities.fastRandom.nextInt() % 100) / 100.0f));
            }
            return r0.bounds.width() * (Math.abs(Utilities.fastRandom.nextInt() % 100) / 100.0f);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0088  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void draw(android.graphics.Canvas r11) {
            /*
                Method dump skipped, instructions count: 221
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.Reactions.AnimatedEmojiEffect.Particle.draw(android.graphics.Canvas):void");
        }
    }
}
