package com.example.trivia.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class Prefs {
    private static final String HIGHEST_SCORE = "highest_score";
    private static final String STATE = "question_index";
    private SharedPreferences preferences;

    public Prefs(Activity context) {
        this.preferences = context.getPreferences(Context.MODE_PRIVATE);
    }

    public void saveHighestScore(int currentScore) {
        int lastScore = preferences.getInt(HIGHEST_SCORE, 0);

        if (currentScore > lastScore) {
            preferences.edit().putInt(HIGHEST_SCORE, currentScore).apply();
        }
    }

    public int getHighestScore() {
        return preferences.getInt(HIGHEST_SCORE, 0);
    }

    public void setState(int questionIndex) {
        preferences.edit().putInt(STATE, questionIndex).apply();
    }

    public int getState() {
        return preferences.getInt(STATE, 0);
    }
}
