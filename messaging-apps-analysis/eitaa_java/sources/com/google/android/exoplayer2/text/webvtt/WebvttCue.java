package com.google.android.exoplayer2.text.webvtt;

import android.text.Layout;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;

/* loaded from: classes.dex */
public final class WebvttCue extends Cue {
    public final long endTime;
    public final long startTime;

    private WebvttCue(long startTime, long endTime, CharSequence text, Layout.Alignment textAlignment, float line, int lineType, int lineAnchor, float position, int positionAnchor, float width) {
        super(text, textAlignment, line, lineType, lineAnchor, position, positionAnchor, width);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean isNormalCue() {
        return this.line == -3.4028235E38f && this.position == 0.5f;
    }

    public static class Builder {
        private long endTime;
        private float line;
        private int lineAnchor;
        private int lineType;
        private float position;
        private int positionAnchor;
        private long startTime;
        private CharSequence text;
        private int textAlignment;
        private float width;

        private static float computeLine(float line, int lineType) {
            if (line == -3.4028235E38f || lineType != 0 || (line >= 0.0f && line <= 1.0f)) {
                return line != -3.4028235E38f ? line : lineType == 0 ? 1.0f : -3.4028235E38f;
            }
            return 1.0f;
        }

        private static float derivePosition(int textAlignment) {
            if (textAlignment != 4) {
                return textAlignment != 5 ? 0.5f : 1.0f;
            }
            return 0.0f;
        }

        private static int derivePositionAnchor(int textAlignment) {
            if (textAlignment == 1) {
                return 0;
            }
            if (textAlignment == 3) {
                return 2;
            }
            if (textAlignment != 4) {
                return textAlignment != 5 ? 1 : 2;
            }
            return 0;
        }

        public Builder() {
            reset();
        }

        public void reset() {
            this.startTime = 0L;
            this.endTime = 0L;
            this.text = null;
            this.textAlignment = 2;
            this.line = -3.4028235E38f;
            this.lineType = 1;
            this.lineAnchor = 0;
            this.position = -3.4028235E38f;
            this.positionAnchor = Integer.MIN_VALUE;
            this.width = 1.0f;
        }

        public WebvttCue build() {
            this.line = computeLine(this.line, this.lineType);
            if (this.position == -3.4028235E38f) {
                this.position = derivePosition(this.textAlignment);
            }
            if (this.positionAnchor == Integer.MIN_VALUE) {
                this.positionAnchor = derivePositionAnchor(this.textAlignment);
            }
            this.width = Math.min(this.width, deriveMaxSize(this.positionAnchor, this.position));
            return new WebvttCue(this.startTime, this.endTime, (CharSequence) Assertions.checkNotNull(this.text), convertTextAlignment(this.textAlignment), this.line, this.lineType, this.lineAnchor, this.position, this.positionAnchor, this.width);
        }

        public Builder setStartTime(long time) {
            this.startTime = time;
            return this;
        }

        public Builder setEndTime(long time) {
            this.endTime = time;
            return this;
        }

        public Builder setText(CharSequence text) {
            this.text = text;
            return this;
        }

        public Builder setTextAlignment(int textAlignment) {
            this.textAlignment = textAlignment;
            return this;
        }

        public Builder setLine(float line) {
            this.line = line;
            return this;
        }

        public Builder setLineType(int lineType) {
            this.lineType = lineType;
            return this;
        }

        public Builder setLineAnchor(int lineAnchor) {
            this.lineAnchor = lineAnchor;
            return this;
        }

        public Builder setPosition(float position) {
            this.position = position;
            return this;
        }

        public Builder setPositionAnchor(int positionAnchor) {
            this.positionAnchor = positionAnchor;
            return this;
        }

        public Builder setWidth(float width) {
            this.width = width;
            return this;
        }

        private static Layout.Alignment convertTextAlignment(int textAlignment) {
            if (textAlignment != 1) {
                if (textAlignment == 2) {
                    return Layout.Alignment.ALIGN_CENTER;
                }
                if (textAlignment != 3) {
                    if (textAlignment != 4) {
                        if (textAlignment != 5) {
                            Log.w("WebvttCueBuilder", "Unknown textAlignment: " + textAlignment);
                            return null;
                        }
                    }
                }
                return Layout.Alignment.ALIGN_OPPOSITE;
            }
            return Layout.Alignment.ALIGN_NORMAL;
        }

        private static float deriveMaxSize(int positionAnchor, float position) {
            if (positionAnchor == 0) {
                return 1.0f - position;
            }
            if (positionAnchor == 1) {
                return position <= 0.5f ? position * 2.0f : (1.0f - position) * 2.0f;
            }
            if (positionAnchor == 2) {
                return position;
            }
            throw new IllegalStateException(String.valueOf(positionAnchor));
        }
    }
}
