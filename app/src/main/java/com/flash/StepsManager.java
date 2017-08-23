package com.flash;

import java.util.ArrayList;

public class StepsManager {

    private final ArrayList<Step> mSteps;
    private int mCurrentIndex = -1;

    public StepsManager() {
        mSteps = new ArrayList<>();
    }

    public void registerStep(Step step) {
        mSteps.add(step);
    }

    public void unregisterStep(Step step) {
        mSteps.remove(step);
    }

    public void moveToPrevious() {

        if (mCurrentIndex > 0) {

            mSteps.get(mCurrentIndex).makeInvisible();
            mSteps.get(mCurrentIndex).disable();
            mCurrentIndex --;
            mSteps.get(mCurrentIndex).enable();
            mSteps.get(mCurrentIndex).makeVisible();

        }

    }

    public void moveToNext() {

        if (mCurrentIndex < mSteps.size() - 1) {

            if (mCurrentIndex != -1) {
                mSteps.get(mCurrentIndex).makeInvisible();
                mSteps.get(mCurrentIndex).disable();
            }

            mCurrentIndex ++;
            Step step = mSteps.get(mCurrentIndex);
            step.enable();
            step.makeVisible();
        }

    }

    public boolean isFirstStep() {
        return mCurrentIndex == 0;
    }

    public boolean isLastStep() {
        return mCurrentIndex == mSteps.size() -1;
    }

    public void jumpToStep(Step step) {

        if (mCurrentIndex != -1) {
            mSteps.get(mCurrentIndex).makeInvisible();
            mSteps.get(mCurrentIndex).disable();
        }

//        if (step.isEnabled()) {
            mCurrentIndex = mSteps.indexOf(step);
            step.enable();
            step.makeVisible();
//        }
    }

    public void resetAllSteps() {
        for (Step step : mSteps) {
            step.disable();
            step.makeInvisible();
        }
        mCurrentIndex = 0;
        mSteps.get(mCurrentIndex).enable();
        mSteps.get(mCurrentIndex).makeVisible();
    }
}
