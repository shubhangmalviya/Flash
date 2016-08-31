package com.flash;

import java.util.ArrayList;

public class StepsManager {

    private final ArrayList<Step> mSteps;
    private final int mCurrentIndex = 0;

    public StepsManager() {
        mSteps = new ArrayList<>();
    }

    public void registerStep(Step step) {
        mSteps.add(step);
    }

    public void unregisterStep(Step step) {
        mSteps.remove(step);
    }

    public void moveToNext() {

    }

    public void jumpToStep(Step step) {

        step.enable();
        step.makeVisible();
    }

    public void resetAllSteps() {
        for (Step step : mSteps) {
            step.disable();
            step.makeInvisible();
        }
        mSteps.get(0).enable();
        mSteps.get(0).makeVisible();
    }
}
