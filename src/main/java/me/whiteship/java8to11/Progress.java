package me.whiteship.java8to11;

import java.time.Duration;

public class Progress {

    //얼마나 수료를 했는지

    private Duration studyDuration;

    private boolean finished;

    public Duration getStudyDuration() {
        return studyDuration;
    }

    public void setStudyDuration(Duration studyDuration) {
        this.studyDuration = studyDuration;
    }
}
